import java.util.*;
import java.io.*;

public class Q3048 {
    //개미
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1Num = Integer.parseInt(st.nextToken());
        int N2Num = Integer.parseInt(st.nextToken());

        char[] N1Order = br.readLine().toCharArray();
        char[] N2Order = br.readLine().toCharArray();
        char[] totalOrder = new char[N1Num + N2Num];

        for (int i = 0; i < N1Num + N2Num; i++) {
            if (i < N1Num) {
                totalOrder[i] = N1Order[N1Num - i - 1];
            } else {
                totalOrder[i] = N2Order[i - N1Num];
            }
        }

        int T = Integer.parseInt(br.readLine());
        char temp = 0;

        for (int i = 0; i < T; i++) {

            temp = totalOrder[N1Num - i];
            totalOrder[N1Num - i] = totalOrder[N1Num - i - 1];
            totalOrder[N1Num - i - 1] = temp;

            if(i>0) {
                temp = totalOrder[N1Num + i];
                totalOrder[N1Num + i] = totalOrder[N1Num + i - 1];
                totalOrder[N1Num + i - 1] = temp;
            }
        }

        for (int i = 0; i < totalOrder.length; i++) {
            System.out.print(totalOrder[i]);
        }
    }
}
