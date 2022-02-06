package site.metacoding.ex23;

// 일의 순서가 없는 비동기 프로그램
class NewWorker implements Runnable {
    // Runnable 인터페이스가 필요하기 때문에 클래스를 만들어 상속
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("NewWorker스레드 : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class ThreadEx02 {

    // MainThread 의 타겟(task)은 main 메서드
    public static void main(String[] args) {

        // NewWorker 생성
        // Thread가 무조건 Runnable타입 받게하여 상속하게 한다.
        Thread newWorker = new Thread(new NewWorker());
        newWorker.start(); // run() 메서드 호출

        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("메인스레드 : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
