import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1065 {
    public static void main(String[] args) throws IOException {
        //자리수가 등차수열:한수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int count = 99;

        if (num < 100) {
            System.out.println(num);
        } else {
            for (int i = 100; i <= num; i++) {
                if (isHansu(i)) {
                    count++;
                    if(i == 1000) {
                        count--;
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static boolean isHansu(int i) {
        int unitDigit = i % 10;
        int tenthDigit = i % 100 / 10;
        int hundDigit = i % 1000 / 100;

        if (hundDigit - tenthDigit == tenthDigit - unitDigit || unitDigit - tenthDigit == tenthDigit - hundDigit) {
            return true;
        }
        return false;
    }
}