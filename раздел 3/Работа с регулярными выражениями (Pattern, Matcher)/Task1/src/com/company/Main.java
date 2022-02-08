package com.company;

//1. Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
//операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
//отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
//алфавиту.

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String str = "    Был яркий холодный апрельский день, часы били тринадцать. Уинстон Смит, прижав подбородок к груди и ежась от омерзительного ветра, быстро скользнул в стеклянные двери Дома Победы, но все же вихрь песка и пыли успел ворваться вместе с ним.\n" +
                "    В подъезде пахло вареной капустой и старыми половиками. К стене против входа был пришпилен цветной плакат, пожалуй слишком большой для этого места. На нем было изображено лишь огромное, шириной больше метра, лицо человека лет сорока пяти с грубоватыми, но привлекательными чертами и густыми черными усами. Уинстон направился прямо к лестнице. Не стоило тратить время на вызов лифта, — даже в лучшие времена он редко работал, а теперь электричество, в соответствии с программой экономии, вообще отключали в дневное время, поскольку уже началась подготовка к Неделе Ненависти. Уинстону предстояло одолеть семь лестничных маршей. Он шел медленно и несколько раз отдыхал: ему уже тридцать девять лет, да к тому же на правой ноге у него варикозная язва. И со стен каждой площадки, прямо против двери лифта, на него глядело огромное лицо.\n" +
                "    Это было одно из тех изображений, где глаза специально нарисованы так, чтобы взгляд их все время следил за вами. «БОЛЬШОЙ БРАТ ВИДИТ ТЕБЯ», — было написано на плакате снизу. Когда он вошел в свою квартиру, бархатный голос зачитывал сводку цифр, имевших какое-то отношение к выплавке чугуна. Голос шел из вмонтированной в правую стену комнаты продолговатой металлической пластины, напоминавшей тусклое зеркало. Уинстон повернул регулятор — голос зазвучал тише, но слова были по-прежнему различимы. Этот прибор (он назывался «монитор») можно было приглушить, но выключить совсем нельзя. Уинстон подошел к окну — маленькая щуплая фигурка, худобу которой еще больше подчеркивал синий форменный комбинезон члена Партии; у него были очень светлые волосы и румяное от природы лицо, кожа которого загрубела от скверного мыла, тупых бритвенных лезвий и холода только что закончившейся зимы.\n" +
                "    Мир снаружи, даже сквозь закрытое окно, казался холодным. Внизу, на улице, ветер крутил пыль и обрывки бумаги, и, хотя на синем небе ярко светило солнце, все выглядело бесцветным, за исключением всюду расклеенных плакатов. Лицо с черными усами было везде. Одно было на фасаде дома напротив. «БОЛЬШОЙ БРАТ ВИДИТ ТЕБЯ», — говорила надпись, а темные глаза пристально заглядывали внутрь Уинстона. Ниже бился на ветру другой плакат, с оторванным углом, то открывая, то закрывая единственное слово: «АНГСОЦ». Вдали над крышами парил вертолет. Время от времени он нырял и зависал на мгновение, как огромная синяя муха, а потом по кривой снова взмывал вверх. Это заглядывал в окна полицейский патруль. Впрочем, патрули не играли роли. Роль играла лишь Полиция Мысли.\n" +
                "    За спиной Уинстона голос из монитора все еще что-то бубнил про чугун и перевыполнение Девятого Трехлетнего Плана. Монитор был одновременно приемником и передатчиком, который улавливал любой звук, кроме очень тихого шепота. Более того, пока Уинстон оставался в поле зрения монитора, его можно было не только слышать, но и видеть. Конечно, никогда нельзя знать наверняка, наблюдают за тобой сейчас или нет. Можно только гадать, как часто и в каком порядке Полиция Мысли подключается к той или иной квартире. Вполне возможно, что они наблюдают за всеми и всегда. Во всяком случае, они могли подключиться к вашей линии в любой момент. И приходилось жить, зная, что каждый звук кто-то слышит и за каждым движением кто-то следит, если только этому не мешает полная темнота. И люди жили так — в силу привычки, которая стала уже инстинктом.";
        System.out.println("Текст:\n" + str);
        System.out.println("Выберите желаемую операцию: ");
        System.out.println("1. Отсортировать абзацы по количеству предложений;");
        System.out.println("2. В каждом предложении отсортировать слова по длине;");
        System.out.println("3. Отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        switch (key) {
            case 1:
                sortParagraphsBySentences(str);
                break;
            case 2:
                sortWordsByLength(str);
                break;
            case 3:
                sortWordsBySymbols(str);
                break;
        }
    }

    public static void sortParagraphsBySentences(String str) {
        Pattern pattern = Pattern.compile("\\s{4}[А-Яа-я ,.—:();«»-]*"); //паттерн абзаца
        Matcher matcher = pattern.matcher(str);
        ArrayList<String> paragraphs = new ArrayList<>(); //список абзацов
        while (matcher.find()) { //заполнение списка абзацов
            paragraphs.add(matcher.group());
        }
        ArrayList<Integer> countOfSentenceEnd = new ArrayList<>(); //количество предложений в каждом абзаце
        int k = 0;
        for (String s : paragraphs) {
            Pattern patternSentenceEnd = Pattern.compile("[.?!]"); //паттерн для определения конца предложения
            Matcher matcherSentenceEnd = patternSentenceEnd.matcher(s);
            countOfSentenceEnd.add(0);
            while (matcherSentenceEnd.find()) {
                countOfSentenceEnd.set(k, countOfSentenceEnd.get(k) + 1);
            }
            k++;
        }
        int buf; //буфер для количества предложений
        String bufStr; //буфер для абзаца
        for (int i = 0; i < countOfSentenceEnd.size(); i++) { //сортировка
            for (int j = i; j > 0; j--) {
                if (countOfSentenceEnd.get(j - 1) > countOfSentenceEnd.get(j)) {
                    buf = countOfSentenceEnd.get(j);
                    countOfSentenceEnd.set(j, countOfSentenceEnd.get(j - 1));
                    countOfSentenceEnd.set(j - 1, buf);
                    bufStr = paragraphs.get(j);
                    paragraphs.set(j, paragraphs.get(j - 1));
                    paragraphs.set(j - 1, bufStr);
                }
            }
        }
        for (String s : paragraphs) { //вывод отсортированных абзацев
            System.out.println(s);
        }
    }

    public static void sortWordsByLength(String str) {
        ArrayList<String> sentences = getSentences(str); //массив предложений
        Pattern patternWords = Pattern.compile("[ ,.:«»—()-]"); //паттерн, по которому предложение разделится на слова
        ArrayList<String[]> words = new ArrayList<>(); // слова в предложениях
        int k = 0;
        for (String sentence : sentences) {
            words.add(patternWords.split(sentence)); //разделение предложений на слова
            String buf; //буфер для слова
            for (int i = 0; i < words.get(k).length; i++) { //сортировка слов в предложении по длине
                for (int j = i; j > 0; j--) {
                    if (words.get(k)[j - 1].length() > words.get(k)[j].length()) {
                        buf = words.get(k)[j];
                        words.get(k)[j] = words.get(k)[j - 1];
                        words.get(k)[j - 1] = buf;
                    }
                }
            }
            k++;
        }
        for (String[] w : words) { //вывод результата на экран
            for (String s : w) {
                System.out.print(s + " ");
            }
            System.out.print(".\n");
        }
    }

    public static ArrayList<Integer> findCountOfOccurrences(ArrayList<String> collectionsOfWords, String character) { //нахождение и подсчет случаев вхождения символа в слово
        ArrayList<Integer> countOfOccurrences = new ArrayList<>(); //количества вхождения символа
        for (String sentences : collectionsOfWords) { //подсчет количества вхождения символа
            int counter = 0;
            for (int i = 0; i < sentences.length(); i++) {
                String strM = sentences.charAt(i) + "";
                if (strM.equals(character)) {
                    counter++;
                }
            }
            countOfOccurrences.add(counter);
        }
        return countOfOccurrences;
    }

    public static ArrayList<String> sortByOccurrences(ArrayList<String> collectionsOfWords, ArrayList<Integer> countOfOccurrences) { //сортировкапо вхождению символа в слово
        ArrayList<String> sortedWords = new ArrayList<>();
        int startSize = collectionsOfWords.size();
        for (int i = 0; i < startSize; i++) {
            int maxCountOfOccurrences = -1; //максимальное количества вхождений в строку
            int maxIndexOccurrence = -1; //индекс максимального количества в строку
            for (int j = 0; j < collectionsOfWords.size(); j++) {
                if (maxCountOfOccurrences < countOfOccurrences.get(j)) {
                    maxCountOfOccurrences = countOfOccurrences.get(j);
                    maxIndexOccurrence = j;
                }
            }
            sortedWords.add(collectionsOfWords.get(maxIndexOccurrence)); //добавляем слова в новом порядке
            collectionsOfWords.remove(maxIndexOccurrence); //убираем добавленное слово
            countOfOccurrences.remove(maxIndexOccurrence); //убираем индекс добавленного слова
        }
        return sortedWords;
    }

    public static void sortWordsBySymbols(String str) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> sentences = getSentences(str); //массив предложений
        Pattern patternWords = Pattern.compile("[ ,.:«»—()-]"); //паттерн, по которому предложение разделится на слова
        ArrayList<ArrayList<String>> sortedSentences = new ArrayList<>(); //слова в предложениях
        System.out.println("Введите символ для сортировки слов в предложеннии по количеству вхождения этого символа: ");
        String character = scanner.next();
        for (String sentence : sentences) {
            String[] arrayOfWords = patternWords.split(sentence.toLowerCase(Locale.ROOT)); //массив слов
            ArrayList<String> collectionOfWords = new ArrayList<>(Arrays.asList(arrayOfWords)); //коллекция из слов
            Collections.sort(collectionOfWords); //сортировать слова по алфавиту
            collectionOfWords.removeAll(Arrays.asList("", null, " ", "\n")); //удалить мусор из коллекции
            ArrayList<Integer> countOfOccurrences = new ArrayList<>(); //количества вхождения символа
            countOfOccurrences.addAll(findCountOfOccurrences(collectionOfWords, character));
            ArrayList<String> sortedWords = sortByOccurrences(collectionOfWords, countOfOccurrences); //сортировка по вхождению символа
            sortedSentences.add(sortedWords);
        }
        for (ArrayList<String> w : sortedSentences) { //вывод в консоль
            for (String s : w) {
                System.out.print(s + " ");
            }
            System.out.print(".\n");
        }
    }

    public static ArrayList<String> getSentences(String str) { //получить предложения из текста
        Pattern patternSentence = Pattern.compile("[А-Яа-я \n,—:«»();-]*[.!?]"); //паттерн предложения
        Matcher matcherSentence = patternSentence.matcher(str);
        ArrayList<String> sentences = new ArrayList<>(); //коллекция предложений
        while (matcherSentence.find()) { //нахождение предложений по паттерну в тексте
            sentences.add(matcherSentence.group());
        }
        return sentences;
    }

}
