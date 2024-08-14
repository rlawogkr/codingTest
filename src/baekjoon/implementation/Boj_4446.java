package baekjoon.implementation;

import java.io.*;

public class Boj_4446 {
    static char[] vowels = {'a', 'i', 'y', 'e', 'o', 'u'};
    static char[] consonants = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'};

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input;
            while ((input = br.readLine()) != null) {
                StringBuilder output = new StringBuilder();

                for (char c : input.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char transformedChar = changeCharacter(c);
                        output.append(transformedChar);
                    } else {
                        output.append(c);
                    }
                }

                System.out.println(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static char changeCharacter(char c) {
        char[] array;
        int shift;

        if (isVowel(c)) {
            array = vowels;
            shift = 3;  // 세 번째 오른쪽 위치
        } else {
            array = consonants;
            shift = 10; // 열 번째 오른쪽 위치
        }

        boolean isUpperCase = Character.isUpperCase(c);
        c = Character.toLowerCase(c);

        int index = indexOf(array, c);
        char changeChar = array[(index + shift) % array.length];

        return isUpperCase ? Character.toUpperCase(changeChar) : changeChar;
    }

    static int indexOf(char[] array, char c) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }

    static boolean isVowel(char c) {
        c = Character.toLowerCase(c); // 소문자로 변환하여 모음 확인
        for (char v : vowels) {
            if (v == c) return true;
        }
        return false;
    }
}
