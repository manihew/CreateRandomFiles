package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Main {

    public static void main(String[] args)  throws IOException{


	    // write your code here
        int startYear = 2017, numberOfYears = 1;
        for (int i = 0; i < numberOfYears; i++, startYear++) {
            System.out.println("year : " + startYear);
            for (int j = 0; j < 12; j++) {
                System.out.println("month : " + (j+1));

                int numberOfDays = (new GregorianCalendar(startYear, j, 1)).getActualMaximum(Calendar.DAY_OF_MONTH);

                for (int k = 0; k < numberOfDays; k++) {
                    System.out.println("day : " + (k+1));

                    int numberOfFiles = 1 + (new Random()).nextInt(20);
                    for (int l = 0; l < numberOfFiles; l++) {

                        int numberOfCharacters = (new Random()).nextInt(1000);
                        String fileContent = "";

                        for (int m = 0; m < numberOfCharacters; m++) {
                            fileContent += Character.toString((char)(65 + (new Random()).nextInt(26)));
                        }
                        System.out.println(fileContent);

                        File abc = new File(String.format( "%s", startYear));

                        if (!abc.exists()){
                            System.out.println("Directory not exists." +  abc.getPath());
                            abc.mkdir();
                        }

                        abc = new File(String.format( "%s//%s", startYear, j));
                        if (!abc.exists()){
                            System.out.println("Directory not exists." +  abc.getPath());
                            abc.mkdir();
                        }

                        abc = new File(String.format( "%s//%s//%s", startYear, j, k));
                        if (!abc.exists()){
                            System.out.println("Directory not exists." +  abc.getPath());
                            abc.mkdir();
                        }

                            abc = new File(String.format( "%s//%s//%s//%s.txt", startYear, j, k, l));
                            abc.createNewFile();
                            Files.write(abc.toPath(), fileContent.getBytes());


                    }

                }
            }
        }
    }
}
