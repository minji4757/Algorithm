package Q1000;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(input);
        System.out.println(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()));

    }
}
