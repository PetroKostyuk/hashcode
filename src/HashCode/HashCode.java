package HashCode;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HashCode {
    int R, C, L, H;

    boolean pizza[][];
    List<Point> possibleSizes;
    boolean[][] isUsedPosition;
    List<Rectangle> foundRectangles = new LinkedList<>();



    public static void main(String[] args) throws IOException {
        HashCode hash = new HashCode();
    }


    HashCode() throws IOException {
        String[] strs = {"example", "small", "medium", "big" };
        for (String str : strs) {
            loadData(str);
            possibleSizes = genSizes(H);
            solve();
            output(str);
        }
    }

    void solve() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (Point p : possibleSizes) {
                    Rectangle rect = new Rectangle(j, i, p.x, p.y);
                    if(this.isValid(rect)) {
                        foundRectangles.add(rect);
                        this.fillRect(rect);
                        break;
                    }
                }

            }
        }
    }

    public boolean[][] loadData(String in) {
        File inFile = new File("in/"+in+".in");

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
        isUsedPosition = new boolean[R][C];

        for(int i = 0; i< R; i++){
            String line = sc.next();
            for(int j = 0; j< C; j++){
                pizza[i][j] = line.charAt(j)=='T';
            }
        }

        return pizza;
    }

    ArrayList<Point> genSizes(int h) {
        ArrayList<Point> res = new ArrayList();
        for (int i = 1; i <= h; i++) {
            if (h % i == 0) {
                Point tmp = new Point();
                tmp.x = i;
                tmp.y = h / i;
                res.add(tmp);
            }

        }
        return res;
    }

    boolean isValid(Rectangle rec) {
        boolean valid = true;

        int ex = rec.x + rec.width;
        int ey = rec.y + rec.height;

        if(ex > C || ey > R){
            return false;
        }

        int trueCount = 0;
        int falseCount = 0;

        for (int x=rec.x; x<ex; x++){
            for(int y=rec.y; y<ey; y++){
                if(isUsedPosition[y][x]){
                    return false;
                }

                if(pizza[y][x]) trueCount++;
                else falseCount++;
            }
        }

        return trueCount>=L && falseCount>=L;
    }

    public void output(String out) throws IOException {
        PrintWriter fileWriter = new PrintWriter("out/"+out+".txt");
        fileWriter.println(foundRectangles.size());

        for (Rectangle rectangle : foundRectangles) {
            int x1 = rectangle.x;
            int y1 = rectangle.y;
            int x2 = x1 + rectangle.width - 1;
            int y2 = y1 + rectangle.height - 1;

            fileWriter.println(y1 + " " + x1 + " " + y2 + " " + x2);

        }
        fileWriter.close();
    }

    // Denys



    // Michal





    // Pavel






    // Petro

    void fillRect(Rectangle rect){
        int ex = rect.x + rect.width;
        int ey = rect.y + rect.height;

        for (int x=rect.x; x<ex; x++){
            for(int y=rect.y; y<ey; y++){
                isUsedPosition[y][x] = true;
            }
        }
    }
}
