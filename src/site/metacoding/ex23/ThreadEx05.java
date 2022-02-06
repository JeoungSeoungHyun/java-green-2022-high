package site.metacoding.ex23;

// 스레드가 context switching할 때는 내부적으로 조금이라도 sleep하고 넘어간다.
// 하나의 프로세스 안에 여러개의 스레드가 동작한다.
// 스레드 일시 정지 하는 법

// 2초씩 자고 움직인다.
class Monster {
    int x = 10;
    int speed = 1;
}

// 계속 움직인다.
class Host {
    int x = 0;
    int speed = 1;

    public Host(int speed) {
        this.speed = speed;
    }
}

// 실습 -> Host의 speed를 2로 만들고, Monster는 잠자지 않는다.

public class ThreadEx05 {
    public static void main(String[] args) {
        Monster m = new Monster();
        Host h = new Host(2);

        Thread mt = new Thread(() -> {
            while (m.x > h.x) {
                try {
                    m.x = m.x + m.speed;
                    System.out.println("몬스터의 위치 : " + m.x);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // System.out.println("mt 스레드 종료");
            // System.out.println("m.x : " + m.x);
        });

        Thread ht = new Thread(() -> {
            while (h.x < m.x) {
                try {
                    h.x = h.x + h.speed;
                    System.out.println("주인공의 위치 : " + h.x);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // System.out.println("ht 스레드 종료");
            // System.out.println("h.x : " + h.x);
        });

        mt.start();
        ht.start();
        int time = 0;
        while (h.x < m.x) {
            try {
                Thread.sleep(1000);
                time++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(time + "초에 " + h.x + "위치에서 몬스터가 죽었습니다.");

        // System.out.println("메인스레드 종료");
    }
}