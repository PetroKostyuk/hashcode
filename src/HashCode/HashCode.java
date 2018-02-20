package HashCode;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class HashCode {
    int R, C, L, H;

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

        R = sc.nextInt();
        C = sc.nextInt();
        L = sc.nextInt();
        H = sc.nextInt();

        pizza = new boolean[R][C];

        for(int i = 0; i< R; i++){
            String line = sc.next();
            for(int j = 0; j< C; j++){
                pizza[i][j] = line.charAt(j)=='T';
            }
        }

        System.out.println(R);
        System.out.println(C);


        for(int i = 0; i< R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(pizza[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }

        return pizza;
    }
    
     void getSizes() {
        
    }
    
    void isValid() {
        
    }
    
    void output() {
        System.out.println("sdfasdfasd");
    }
}
