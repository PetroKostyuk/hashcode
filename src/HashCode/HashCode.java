package HashCode;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HashCode {
    int R, C, L, H;

    boolean pizza[][];
    List<Point> possibleSizes;
    boolean[][] isUsedPosition;
    List<Rectangle> foundRectangles;



    public static void main(String[] args) throws FileNotFoundException {
        HashCode hash = new HashCode();
    }


    HashCode() throws FileNotFoundException {
        loadData();
        getSizes();
        solve();
        output();
    }
    
    void solve() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (Point p : possibleSizes) {
                    Rectangle rect = new Rectangle(i, j, p.x, p.y);
                    if(this.isValid(rect)) {
                        foundRectangles.add(rect);
                        this.fillRect(rect);
                        break;
                    }
                }
                
            }
        }
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
    
    public void output() throws FileNotFoundException {
        PrintWriter outFile = new PrintWriter("out/out.txt");
        System.out.println(foundRectangles.size());
        outFile.println(foundRectangles.size());

        for (Rectangle rectangle : foundRectangles) {
            int x1 = rectangle.x;
            int y1 = rectangle.y;
            int x2 = x1 + rectangle.width - 1;
            int y2 = y1 + rectangle.height - 1;

            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            outFile.println(x1 + " " + y1 + " " + x2 + " " + y2);
        }
    }

    // Denys



    // Michal



    // Pavel






    // Petro
}
