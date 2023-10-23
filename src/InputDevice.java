import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputDevice {

    // 값을 받는 함수
    public int receiveInput(int n) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        int answer = -1;
        try {
            answer = parser.parse(scanner.next(),n);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return answer;
    }

    public void receiveClean() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(br.ready()){
            br.readLine();
        }
    }
}
