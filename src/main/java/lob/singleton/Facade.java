package lob.singleton;

public class Facade {
    /*
    하위 시스템의 복잡한 비즈니스 로직을 상위 인터페이스를 통해 캡슐화하여 숨기고, 하위 시스템을 더 쉽게 접근,
    사용하게끔 하는 패턴이다.
    */

    public static void main(String[] args) {
        new Facade().SomeMethodA();
        System.out.println();
        new Facade().SomeMethodB();

    }

    // 복잡한 로직은 퍼사드 메서드안에서 호출하고 외부적으로는 메서드 하나만 호출하여 사용한다. 추상화 단계를 나눈다.
    // 결합도가 낮아지고, 유지보수성, 관리성이 증가한다.
    // 여러번 실행해도 호출하는 메서드는 동일하기에 일관된 서비스가 보장된다.
    public void SomeMethodA() {
        System.out.println("Facade.SomeMethodA");
        System.out.println("하위 구현체의 복잡한 메서드1");
        System.out.println("하위 구현체의 복잡한 메서드2");
        System.out.println("하위 구현체의 복잡한 메서드3");
        System.out.println("하위 구현체의 복잡한 메서드4");
        System.out.println("Facade.SomeMethodA");
    }

    public void SomeMethodB() {
        System.out.println("Facade.SomeMethodB");
        System.out.println("하위 구현체의 간결한 메서드1");
        System.out.println("하위 구현체의 간결한 메서드2");
        System.out.println("Facade.SomeMethodB");
    }

}
