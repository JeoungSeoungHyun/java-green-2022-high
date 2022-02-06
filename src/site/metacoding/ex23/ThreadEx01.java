package site.metacoding.ex23;

public class ThreadEx01 {

    // main 스레드 시작
    public static void main(String[] args) {
        System.out.println(1);
        try { // 쓰레드를 잠재운 동안 예외상황이 발생할 수 있어 try/catch 해주어야 함.
            Thread.sleep(2000); // CPU가 잠드는 거
        } catch (Exception e) { // 자다가 exception 발생시 깨어남
            e.printStackTrace();
        } // 단위가 밀리세컨즈 : 1/1000초
        System.out.println(2);
    }
}
