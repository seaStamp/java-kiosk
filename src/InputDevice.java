import java.util.Scanner;

public class InputDevice {
    public static Scanner scanner = new Scanner(System.in);

    // 값을 받는 함수
    public int input(int n) throws Exception{
        int answer = 0;
        answer = scanner.nextInt();
        if (answer < 1 || answer >= n){
            throw new BadInputException(n);
        }

        return answer;
    }
}
