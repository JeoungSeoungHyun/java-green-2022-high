package site.metacoding.ex23;

class Monster2 implements Runnable {
    int x = 10;
    int speed = 1; // 1초마다
    boolean isActive = true;

    @Override
    public void run() {
        while (isActive) {
            try {
                x = x + speed;
                Thread.sleep(1000);
                System.out.println("몬스터의 x좌표 : " + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 계속 움직인다.
class Host2 implements Runnable {
    int x = 0;
    int speed = 2; // 1초마다
    boolean isActive = true;

    @Override
    public void run() {
        while (isActive) {
            try {
                x = x + speed;
                Thread.sleep(1000);
                System.out.println("주인공의 x좌표 : " + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Monster2 monster = new Monster2();
        Thread monsterThread = new Thread(monster);
        monsterThread.start();

        Host2 host = new Host2();
        Thread hostThread = new Thread(host);
        hostThread.start();

        while (true) {
            if (host.x >= monster.x) {
                System.out.println("몬스터가 죽었습니다. 게임이 종료됩니다.");
                // 1. 몬스터 종료
                monster.isActive = false;
                // 2. 주인공 종료
                host.isActive = false;
                // 3. 메인종료
                break;
            } else {
                try {
                    System.out.println(1);
                    Thread.sleep(10); // 출력하는 것도 CPU가 쉬기때문에 가능하다.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
// 스레드는 context switching을 한다.
// 조건 : context switching은 다른 스레드의 제어권을 뺏는 행위
// -> 스레드가 잠시라도 멈춰있어야 함.
// RR : 1초마다 제어권이 뺏기기로 되어 있음.
// 선점, 비선점 스케줄링