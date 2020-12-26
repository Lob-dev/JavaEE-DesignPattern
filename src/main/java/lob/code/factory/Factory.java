package lob.code.factory;

public class Factory {

    // 추상 펙토리 패턴
    // 실제 클래스를 지정하지 않아도 관련된, 의존하는 객체를 생성하는 인터페이스를 제공한다.
    // 어떤 클래스의 인스턴스화를 클라이언트에서 선택하여 담당한다.
    // 복잡한 객체에 대해 내부의 생성 로직을 감추는 방법이다.
    // 일관되게 객체를 생성하고 통제하여야 할 경우 추상 팩토리 패턴을 고려하여야 한다.

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.run();
    }

    public void run() {
        LobFactory lobFactory = new LobFactory();
        Lob lobA = lobFactory.CodingLob();
        Lob lobB = lobFactory.DevLob();

        lobA.LobSay();
        lobB.LobSay();
    }


    public interface AbstractLobFactory {
        public Lob CodingLob();
        public Lob DevLob();
    }

    public class LobFactory implements AbstractLobFactory {

        @Override
        public Lob CodingLob() {
            return new CodingLob();
        }

        @Override
        public Lob DevLob() {
            return new DevLob();
        }
    }

    public class Lob {
        public void LobSay(){
            System.out.println("Hello! I'm Lob!");
        }
    }

    public class CodingLob extends Lob{
        @Override
        public void LobSay() {
            System.out.println("Hello! I'm Coding Lob!");
        }
    }

    public class DevLob extends Lob{
        @Override
        public void LobSay() {
            System.out.println("Hello! I'm Dev Lob!");
        }
    }

}
