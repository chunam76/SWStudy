import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    static int R = 8;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(Main.class.getResource("").getPath() + "sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());		// 테스트 케이스 수
        for(int testCase = 1; testCase <= T; testCase ++) {
            int S = Integer.parseInt(br.readLine());		// 판의 개수 K
            for(int squa = 0; squa < S; squa ++) {
                String[][] inputSqua = new String[8][8];
                for(int row = 0; row < R; row ++) {
                    String readLine = br.readLine();
                    System.out.println(readLine);
                    char[] chars = readLine.toCharArray();
                    System.out.println("길이=" + chars.length);
                    for(int n = 0; n < R; n ++) {
                        inputSqua[squa][n] = String.valueOf(chars[n]);
                    }
                }
                setCoordinate(inputSqua);
            }

            int P = Integer.parseInt(br.readLine());		// 문제수
            for(int problem = 0; problem < P; problem ++) {
                String[][] outputSqua = new String[8][8];
                for(int row = 0; row < R; row ++) {
                    String readLine = br.readLine();
                    System.out.println(readLine);
                    char[] chars = readLine.toCharArray();
                    System.out.println("길이=" + chars.length);
                    for(int n = 0; n < R; n ++) {
                        outputSqua[problem][n] = String.valueOf(chars[n]);
                    }
                }
                setCoordinate(outputSqua);
            }
        }
    }

    public static void setCoordinate(String[][] input){
        System.out.println(input);
    }

    public static class Shape {
        public int index;
        public String color; 	// X, Y좌표 차이
        public int[][] degree0; // 0도일 때 좌표
        public int[][] degree90; // 90도일 때 좌표
        public int[][] degree180; // 180도일 때 좌표
        public int[][] degree270; // 270도일 때 좌표
    }
}
