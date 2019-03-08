import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int R = 8;
    static int S = 0;		// 판의 개수
    static int P = 0;		// 문제수
    static ArrayList<Shape> inputShapes;
    static Shape outputShape;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(Main.class.getResource("").getPath() + "sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());		// 테스트 케이스 수
        for(int testCase = 1; testCase <= T; testCase ++) {
            S = Integer.parseInt(br.readLine());		// 판의 개수
            inputShapes = new ArrayList<>();
            for(int squa = 0; squa < S; squa ++) {
                String[][] inputSqua = new String[8][8];
                int index = squa + 1;
                String color = "W";
                for(int row = 0; row < R; row ++) {
                    String readLine = br.readLine();
                    System.out.println(readLine);
                    char[] chars = readLine.toCharArray();
                    for(int n = 0; n < R; n ++) {
                        String c = String.valueOf(chars[n]);
                        inputSqua[row][n] = c;
                        if(!c.equals(".")) {
                            color = c;
                        }
                    }
                }
                prepareInputShape(index, color, inputSqua);
            }

            P = Integer.parseInt(br.readLine());		// 문제수
            for(int problem = 0; problem < P; problem ++) {
                String[][] outputSqua = new String[8][8];
                outputShape = new Shape();
                for(int row = 0; row < R; row ++) {
                    String readLine = br.readLine();
                    System.out.println(readLine);
                    char[] chars = readLine.toCharArray();
                    for(int n = 0; n < R; n ++) {
                        outputSqua[row][n] = String.valueOf(chars[n]);
                    }
                }
                outputShape.coord = outputSqua;

                // 문제풀이 시작

                for(int row = 0; row < R; row ++) {
                    for(int col = 0; col < R; col ++) {
                        String color = outputShape.coord[row][col];
                        if(color.equals("W")) {
                            checkWhiteColor(row, col);
                        } else {
//                            checkOtherColor(row, col, color);
                        }
                    }
                    System.out.println(inputShapes);
                }
            }
        }
    }

    public static void checkOtherColor(int row, int col, String color) {
        ArrayList<Shape> validShapes = new ArrayList<>();
        for(Shape inputShape : inputShapes) {
            if(inputShape.coord[row][col].equals(".")) {
                validShapes.add(inputShape);
            }
        }
        inputShapes = validShapes;
    }

    public static void checkWhiteColor(int row, int col) {
        ArrayList<Shape> validShapes = new ArrayList<>();
        for(Shape inputShape : inputShapes) {
            if(inputShape.coord[row][col].equals(".")) {
                validShapes.add(inputShape);
            }
        }
        inputShapes.clear();
        inputShapes. = validShapes;
    }


    public static void prepareInputShape(int index, String color, String[][] input){
        String[][] standard = input;
        int count = 4;
        Shape[] shape = new Shape[count];
        for(int i = 0; i < count; i++) {
            String[][] convert = new String[R][R];
            for(int n = 0; n < R; n++) {
                String[] row = standard[n];
                for(int m = 0; m < R; m++) {
                    convert[m][R - n - 1] = row[m];
                }
            }
            shape[i] = new Shape();
            shape[i].index = index;
            shape[i].color = color;
            shape[i].coord = convert;

            standard = convert;
        }

        for(Shape inputShape : inputShapes) {
            for (int i = 0; i < count; i++) {
                if(isSameColor(inputShape, shape[i]) && isSameShape(inputShape, shape[i])) {
                    return;
                }
            }
        }

        for(int i = 0; i < count; i++) {
            inputShapes.add(shape[i]);
        }
    }

    public static boolean isSameShape(Shape a, Shape b) {
        for(int row = 0; row < R; row ++) {
            for (int col = 0; col < R; col++) {
                if((a.coord[row][col].equals(".") && !b.coord[row][col].equals(".")) || (!a.coord[row][col].equals(".") && b.coord[row][col].equals("."))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSameColor(Shape a, Shape b) {
        if(a.color.equals(b.color)) {
            return true;
        }
        return false;
    }

    public static class Shape {
        public int index;
        public String color;
        public String[][] coord;
    }
}
