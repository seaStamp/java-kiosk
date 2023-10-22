public class Parser {
    public int parseInt(int answer, int lastNum) throws Exception {
        // 잘못된 입력 값이 들어 왔을 때 예외처리
        if (answer < 1 || answer > lastNum){
            throw new BadInputException(lastNum);
        }
        return answer;
    }
}
