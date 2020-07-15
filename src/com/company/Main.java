package com.company;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj katalog:");
        String directory = scanner.next();
        System.out.print("Podaj rozszerzenie:");
        String ext = scanner.next();
        System.out.print("Podaj schemat:");
        String text = scanner.next();
        try {
            File f = new File(directory);

            FileFilter filter = new FileFilter() {

                public boolean accept(File f) {
                    return f.getName().endsWith(ext);
                }
            };

            File[] files = f.listFiles(filter);
            for (int i = 0; i < files.length; i++) {
                Find(files[i],text, directory);
            }

        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void Find(File f1,String input, String directory) throws IOException
    {
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        while((s=br.readLine())!=null)   //Reading Content from the file
        {
            String[] words=s.split("\\|");  //Split the word using space
            if (words[0].equals(input))   //Search for the given word
            {
                System.out.println(s);
                save(s,directory);
            }
        }

        fr.close();
    }
    public static void save(String words,String directory) throws IOException{
        PrintWriter zapis=new PrintWriter(new BufferedWriter(new FileWriter(directory + "\\wynik",true)));
        zapis.println(words);
        zapis.close();
    }
}
