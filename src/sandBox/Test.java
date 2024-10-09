package sandBox;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args){
        List<String> phoneBook = new ArrayList<>();
        phoneBook.add("119");
        phoneBook.add("97674223");
        phoneBook.add("1195524421");

        Collections.sort(phoneBook);

        for (int i = 0; i<phoneBook.size()-1; i++){
            if(phoneBook.get(i+1).startsWith(phoneBook.get(i))){
                System.out.println("false");
                return;
            }
        }


    }
}
