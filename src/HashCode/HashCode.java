package HashCode;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HashCode {
    int R,C,L,H;

    boolean pizza[][];
    List<Point> possibleSizes;
    boolean[][] isUsedPosition;
    List<Rectangle> foundRectangles;



    public static void main(String[] args) {
        new HashCode();
    }

    HashCode(){
        loadData();
    }

    public boolean[][] loadData() {
        File inFile = new File("in/in.txt");

        Scanner sc = null;
        try {
            sc = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        r = sc.nextInt();
        c = sc.nextInt();
        l = sc.nextInt();
        h = sc.nextInt();

        pizza = new boolean[r][c];

        for(int i=0; i<r; i++){
            String line = sc.next();
            for(int j=0; j<c; j++){
                pizza[i][j] = line.charAt(j)=='T';
            }
        }

        System.out.println(r);
        System.out.println(c);


        for(int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(pizza[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }

        return pizza;
    }
}
