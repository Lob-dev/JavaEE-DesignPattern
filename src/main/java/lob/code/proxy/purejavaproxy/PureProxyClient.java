package lob.code.proxy.purejavaproxy;

/*
실제 비즈니스 로직과 그외의 코드를 분리시키는 역할을 수행하는 객체를 만드는 패턴이다.
서비스 객체를 호출하는 지점에 대리자 객체를 호출하여 그외의 코드를 수행시키고 대리자 객체에서 실제 서비스 객체를 호출한다.

    1. 프록시 객체는 실제 서비스 객체와 같은 이름의 메서드를 구현한다.
    2. 프록시 객체는 합성을 통해 서비스 객체에 대한 참조 변수를 가진다.
    3. 프록시 객체는 실제 서비스의 메서드를 호출하고 그 결과를 클라이언트에게 반환한다.
    4. 프록시 객체는 실제 서비스 메서드의 호출 전, 후에 별도의 로직을 수행할 수 있다.

    해당 패턴은 컴파일 타임에 이미 프록시 객체를 생성하고 있다.
*/

public class PureProxyClient {

    public static void main(String[] args) {
        PureProxyClient client = new PureProxyClient();
        client.run("Lob");
    }

    public void run(String name){
        TargetObjectProxy proxy = new TargetObjectProxy();
        System.out.println(proxy.someMethod(name));
    }

}
