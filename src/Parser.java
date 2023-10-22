import java.util.regex.Pattern;
public class Parser {
    private static final String NUMBER_REG = "^[0-9]*$"; // 숫자만
    public int parse(String answer, int lastNum) throws Exception {
        // 잘못된 입력 값이 들어 왔을 때 예외처리
        int number;
        if (!Pattern.matches(NUMBER_REG, answer)) {
            throw new BadInputException(lastNum);
        }
        number = Integer.parseInt(answer);
        if (number < 1 || number > lastNum){
            throw new BadInputException(lastNum);
        }
        return number;
    }
}
