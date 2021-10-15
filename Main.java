package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(sevenBoom(new int[] {1,2,3,4,5,6,7}));
        System.out.println(cons(new int[]{5,1,4,3,2}));
        System.out.println(unmix("badce"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println(xPronounce("The x ray is excellent"));
        System.out.println(largestGap(new int[]{14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7}));
        System.out.println(back(51));
        System.out.println(commonLastVowel("Hello World!"));
        System.out.println(memeSum(26 ,39));
        System.out.println(unrepeated("hello"));

    }

    //1.Создайте функцию, которая принимает массив чисел и возвращает "Бум!", если в
    //массиве появляется цифра 7. В противном случае верните "в массиве нет 7".

    public static String sevenBoom(int[] a)
    {
        String str="";
        for (int i : a)
        {
            str=str+i;
        }
        for (int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)=='7')
                return "Boom!";
        }
        return "there is no 7 in the array";
    }

    //2.Создайте функцию, которая определяет, могут ли элементы в массиве быть
    //переупорядочены, чтобы сформировать последовательный список чисел, где
    //каждое число появляется ровно один раз.

    public static boolean cons (int[] ar) {
        Arrays.sort(ar);
        for (int i = 0; i < ar.length-1; i ++) {
            if (ar[i+1]-ar[i]!=1) return false;
        }
        return true;
    }

    //3.lPaeesh le pemu mnxit ehess rtnisg! О, извините, это должно было быть: Пожалуйста,
    //помогите мне распутать эти строки!
    //Каким-то образом все строки перепутались, каждая пара символов поменялась местами.
    //Помоги отменить это, чтобы снова понять строки.

    public static String unmix(String str){
        char buf;      // переменная для обмена
        char[] c = str.toCharArray();   // строку в символьный массив
        for(int i = 0; i < str.length() - 1; i += 2) {  // начиная с первого символа
            buf = c[i];
            c[i] = c[i + 1];    // обмен рядом стоящих символов
            c[i + 1] = buf;
        }
        return String.valueOf(c);
    }

    //4.Создать функцию, которая преобразует предложения, заканчивающиеся
    //несколькими вопросительными знаками ? или восклицательными знаками ! в
    //предложение, заканчивающееся только одним, без изменения пунктуации в
    //середине предложений.

    // Ищем индекс первого заканчивающего знака, возвращаем необходимую подстроку.
    public static String noYelling(String s) {
        StringBuilder sb = new StringBuilder();
        int s_len = s.length();
        // Проверяем с конца строки, ищем индекс первого заканчивающего знака ! или ?
        if(s.charAt(s_len-1) == '!' || s.charAt(s_len-1) == '?') {
            int i = s_len-1;
            while(i > 1 && s.charAt(i-1) == s.charAt(i))
                i--;
            // Т.к. конечный индекс в substring невключающий, пишем i+1
            sb.append(s.substring(0, i+1));
        }
        else {
            sb.append(s);
        }
        return sb.toString();
    }

    //5. Создайте функцию, которая заменяет все x в строке следующими способами:
    //Замените все x на "cks", ЕСЛИ ТОЛЬКО:
    //Слово начинается с "x", поэтому замените его на "z".
    //Слово-это просто буква "х", поэтому замените ее на " cks ".

    public static String xPronounce(String text) {
        String[] arr = text.split(" "); //split - делит строку на части
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].length() > 1 && arr[i].startsWith("x")) {
                arr[i] = "z" + arr[i].substring(1);
            } else if (arr[i].equals("x"))
                arr[i] = "cks";
        }
        return String.join(" ", arr);
    }
    //6. Учитывая массив целых чисел, верните наибольший разрыв между
    //отсортированными элементами массива.

    // Сортируем массив с помощью метода sort класса Arrays
    // Затем циклично рассматриваем разницы чисел и ищем наибольшую разницу
    public static int largestGap(int[] nums) {
        Arrays.sort(nums);
        int largestGap = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i]-nums[i-1] > largestGap)
                largestGap = nums[i]-nums[i-1];
        }
        return largestGap;
    }

    //7.Это вызов обратного кодирования. Обычно вам дают явные указания о том, как
    //создать функцию. Здесь вы должны сгенерировать свою собственную функцию,
    //чтобы удовлетворить соотношение между входами и выходами.
    //Ваша задача состоит в том, чтобы создать функцию, которая при подаче входных данных
    //ниже производит показанные примеры выходных данных

    // Находим число с цифрами по порядку с помощью преобразования в массив символов и его сортировки, если исходное число
    // больше найденного, возвращаем разницу, в противном случае - 0.
    public static int back(int num) {
        char[] numCA = Integer.toString(num).toCharArray();
        Arrays.sort(numCA);
        int numInOrder = Integer.parseInt(new String(numCA));
        if(num>numInOrder)
            return num-numInOrder;
        return 0;
    }

    //8. Создайте функцию, которая принимает предложение в качестве входных данных и
    //возвращает наиболее распространенную последнюю гласную в предложении в
    //виде одной символьной строки.

    // Используем java.util.Map для хранения и записи кол-ва гласных.
    //Циклично проходим по строке в поиске конца слов, рассматриваем предыдущий символ, если гласная,
    //то записываем в Map. Затем ищем максимальное кол-во вхождений в Map.
    public static char commonLastVowel(String s) {
        Map<Character, Integer> vowelsCount = new HashMap<Character, Integer>();
        for(int i = 1; i < s.length(); i++) {
            //Если находим не букву, то это конец слова
            if(!Character.isLetter(s.charAt(i))) {
                char nextChar = Character.toLowerCase(s.charAt(i-1));
                switch(nextChar) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'y':
                        // Используем merge для помещения 1, когда находим гласную первый раз и количества
                        //вхождений - суммы текущего количества и 1, когда находим гласную в след. раз
                        vowelsCount.merge(nextChar, 1, Integer::sum);
                }
            }
        }
        // Ищем наиболее распространённую гласную
        Map.Entry<Character, Integer> maxEntry = null;
        for (Map.Entry<Character, Integer> entry : vowelsCount.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    //task9
    public static int memeSum (int a, int b){
        StringBuilder result = new StringBuilder();
        while (a % 10 != 0 || b % 10 != 0) {
            int c = a % 10 + b % 10;
            result.insert(0, c);
            a/=10;
            b/=10;
        }
        return(Integer.parseInt(result.toString()));
    }

    //10. Создайте функцию, которая удалит все повторяющиеся символы в слове,
    //переданном этой функции. Не просто последовательные символы, а символы,
    //повторяющиеся в любом месте строки.

    // Используем java.util.Set для запоминания, какие символы уже записаны, и для быстрого
    //их поиска в Set с помощью метода .contains()
    public static String unrepeated ( String s) {
        ArrayList<Character> chars = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (!chars.contains(c)) {
                chars.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }
}
