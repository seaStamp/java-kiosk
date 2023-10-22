import java.util.Scanner;

public class InputDevice {

    // 값을 받는 함수
    public int receiveInput(int n) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        int answer = 0;

        try {
            answer = parser.parseInt(scanner.nextInt(),n);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return answer;
    }
}
