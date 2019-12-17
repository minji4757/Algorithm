import java.util.Arrays;

public class Q4673 {
    private static boolean[] isSelfNumber = new boolean[10002];

    //셀프넘버
    public static void main(String[] args) {
        Arrays.fill(isSelfNumber, true);

        //에라토스테네스의 체
        for (int i = 1; i <= 10000; i++) {
            cheakN(i);
            if(isSelfNumber[i] == true) {
                System.out.println(i);
            }
        }
    }

    private static void cheakN(int num) {
        int unitDigit = num % 10;
        int tenthDigit = num % 100 / 10;
        int hundDigit = num % 1000 / 100;
        int thouDigit = num % 10000 / 1000;
        int result = 0;

        result = num + unitDigit + tenthDigit + hundDigit + thouDigit;

        if(result <= 10000) {
            isSelfNumber[result] = false;
        }
        if(num > 10000) return;
    }
}
