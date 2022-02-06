package site.metacoding.ex23;

interface Remocon {
    public abstract void on();

    public abstract void off();
}

class Samsung {

    public void 수리를위한테스트(Remocon r) {
        r.on();
    }
}

public class ArrowEx01 {
    public static void main(String[] args) {
        Samsung s = new Samsung();
        // 화살표 메서드는 추상메서드가 1개인 경우에만 사용이 가능하다.
        s.수리를위한테스트(new Remocon() {

            @Override
            public void on() {
                // TODO Auto-generated method stub

            }

            @Override
            public void off() {
                // TODO Auto-generated method stub

            }

        });
    }
}
