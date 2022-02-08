package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class ThreadOfServer {
    private Socket clientSocket; //сокет для общения
    private boolean isOpen;
    private boolean isConnected;
    private ServerSocket server;
    private BufferedReader in;
    private BufferedWriter out;
    private AccountInfo accountInfo;
    private ArrayList<Node> studentCasesList = new ArrayList<>();
    private int mode;
    private static String STUDENT_CASES_PATH = "studentCases.xml";
    private static String ACCOUNTS_CASES_PATH = "accounts.xml";
    private  Document studentCases;

    ThreadOfServer(ServerSocket server) {
        this.server = server;
        executeInformationExchangeThread();
    }

    public void executeInformationExchangeThread() {
        Runnable task = () -> {
            executeInformationExchange();
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    public void executeInformationExchange() { //главная по обмену информации
        isOpen = true;
        isConnected = false;
        reconnect();
        checkLogin();
        while (isOpen) {
            parseStudentCases();
            try {
                mode = in.read();
                switch (mode) {
                    case 1:
                        readCase();
                        break;
                    case 2:
                        changeCase();
                        break;
                    case 3:
                        createNewCase();
                        break;
                }
            } catch (IOException | ParserConfigurationException | TransformerException | SAXException e) {
                reconnect();
            }
        }
    }

    public void checkLogin() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document accounts = builder.parse(ACCOUNTS_CASES_PATH);
            NodeList accountsList = accounts.getElementsByTagName("account");
            checkUsername(accountsList); // проверка никнейма
            checkPassword(); // проверка пароля
            sendAccess(); // отправить на клиент модификатор доступа пользователя
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkUsername(NodeList accountsList) throws IOException {
        do {
            String nickname = String.valueOf(in.readLine());
            boolean isAccountExist = false;
            for (int i = 0; i < accountsList.getLength(); i++) {
                accountInfo = new AccountInfo(accountsList.item(i));
                if (nickname.equals(accountInfo.getNickname())) {
                    isAccountExist = true;
                    accountInfo.setAccId(i);
                    break;
                }
            }
            if (isAccountExist) {
                out.write(1);
                out.flush();
                break;
            } else {
                out.write(0);
                out.flush();
            }
        } while (true);
    }

    public void checkPassword() throws IOException {
        do {
            String password = String.valueOf(in.readLine());
            if (password.equals(accountInfo.getPassword())) {
                out.write(1);
                out.flush();
                break;
            } else {
                out.write(0);
                out.flush();
            }
        } while (true);
        System.out.println(accountInfo.getNickname() + " подключился");
    }

    public void sendAccess() throws IOException {
        out.write(accountInfo.getAccess() + "\n");
        out.flush();
    }

    public Document parseStudentCases() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            studentCases = builder.parse(new File(STUDENT_CASES_PATH));  // какие-то проблемы с этой строчкой
            NodeList studentCasesList = studentCases.getElementsByTagName("case");
            this.studentCasesList.clear();
            for (int i = 0; i < studentCasesList.getLength(); i++) { //занести студентов в коллекцию
                this.studentCasesList.add(studentCasesList.item(i));
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return studentCases;
    }

    public void reconnect() {
        try {
            clientSocket = server.accept();
            isConnected = true;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeSocket() {
        try {
            isOpen = false;
            clientSocket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCase() throws IOException {
        int indexOfStudent = 0;
        while (true) {
            sendListOfStudents();
            indexOfStudent = in.read();
            if (!(indexOfStudent >= 0 && indexOfStudent < studentCasesList.size())) {
                break;
            }
            sendStudentInfo(indexOfStudent);
        }
    }

    public void changeCase() throws IOException {
        int indexOfStudent = 0;
        while (true) {
            sendListOfStudents(); //отправить клиенту список студентов
            indexOfStudent = in.read(); //принять от клиента номер студента
            if (!(indexOfStudent >= 0 && indexOfStudent < studentCasesList.size())) { //проверка наличия студента в списке
                break;
            }
            int indexOfParameter = 0;
            while (true) {
                StudentInfo studentInfo = sendStudentInfo(indexOfStudent); //отправить клиенту информацию о студенте
                indexOfParameter = in.read(); //принять от клиента номер параметра, который нужно изменить
                if (!(indexOfParameter >= 0 && indexOfParameter < studentInfo.getAllParametersSize())) { //существует ли параметр с таким номером
                    break;
                }
                indexOfParameter = indexOfParameter * 2 + 1;
                String newParameter = in.readLine(); //принять от клиента новые данные параметра
                updateParameterInDocument(indexOfStudent, indexOfParameter, newParameter); //изменить данные студента
            }
        }
    }

    public void createNewCase() throws IOException, ParserConfigurationException, TransformerException, SAXException {
        StudentInfo studentInfo = new StudentInfo();
        for (int i = 0; i < studentInfo.getAllParametersSize(); i++) { //принять от клента данные студента
            studentInfo.setParameter(i, in.readLine());
        }
        Node root = studentCases.getDocumentElement();
        Element newStudentCase = studentCases.createElement("case");
        for (int i = 0; i < studentInfo.getAllParametersSize(); i++) { //создать студента в виде xml элемента
            Element newParameter = studentCases.createElement(studentInfo.getParameterName(i));
            newParameter.setTextContent(studentInfo.getParameter(i));
            newStudentCase.appendChild(newParameter);
        }
        root.appendChild(newStudentCase); //добавть студента в сущность со студентами
        writeDocument(studentCases); //записать в файл новую сущность
    }

    public void sendListOfStudents() throws IOException {
        out.write(studentCasesList.size());
        out.flush();
        for (Node studentCase : studentCasesList) {
            StudentInfo studentInfo = new StudentInfo(studentCase);
            out.write(studentInfo.messageToListOnClient() + "\n");
            out.flush();
        }
    }

    public StudentInfo sendStudentInfo(int indexOfStudent) throws IOException {
        StudentInfo studentInfo = new StudentInfo(studentCasesList.get(indexOfStudent));
        out.write(studentInfo.getAllParametersSize());
        out.flush();
        for (int i = 0; i < studentInfo.getAllParametersSize(); i++) {
            out.write(studentInfo.getParameterForMessage(i) + "\n");
            out.flush();
        }
        return studentInfo;
    }

    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError, IOException, ParserConfigurationException, SAXException, TransformerException {
            document = formatDocument(document);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            FileOutputStream fos = new FileOutputStream(STUDENT_CASES_PATH);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(fos));
    }

    private void updateParameterInDocument(int indexOfStudent, int indexOfParameter, String newParameter) throws TransformerFactoryConfigurationError {
        try {
            studentCases.getElementsByTagName("case").item(indexOfStudent).getChildNodes().item(indexOfParameter).getChildNodes().item(0).setNodeValue(newParameter);
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(studentCases);
            FileOutputStream fos = new FileOutputStream(STUDENT_CASES_PATH);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static Document formatDocument(Document document) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        String strDocument = documentToString(document);
        strDocument = strDocument.replaceAll("[\\n\\r]|[ ]{2,}", "");
       // System.out.println(strDocument);
        document = documentBuilder.parse(new InputSource(new StringReader(strDocument)));
        return document;
    }

    public static String documentToString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }

    public boolean getIsConnected() {
        return isConnected;
    }
}
