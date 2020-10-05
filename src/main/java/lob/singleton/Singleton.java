package lob.singleton;

public class Singleton {
    /*
    하나의 인스턴스만 생성하고 전역에서 공유하는 방식.
    설정 데이터, 리소스 캐싱, 로거 인스턴스 생성, 펙토리 패턴을 구현한 클래스 내부에서 객체 관리 등을 할 수 있다.
    남용할 시 Static 으로 구현된 Singleton 은 GC 되지 않기 때문에, 메모리 리소스가 줄어들고, 객체 지향적인 설계를 무너트리며,
    시스템의 성능 문제를 야기할 수 있다.

    하나의 포인트 (참조체 : Reference) 를 통해 접근이 가능하다.

    해당 클래스에서 소스들을 모두 구현하기에 Local Static Class 로 작성한다.
     */


    //
    //
    /*  제일 간단한 Singleton
        Thread-safe 하지 않다. 최초 실행 시 동시에 여러 쓰레드가 getInstance() 를 호출한다면, 2개 이상의 인스턴스가 만들어질 수 있다.

    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance == null) {
            return new Singleton();
        }
        return instance;
    }
    */

    /* synchronized 키워드를 사용한 Singleton
       synchronized? 하나의 Thread getInstance() 를 호출하고 사용하고 있다면, 다른 Thread 의 접근을 막는다.
       변수와 함수에 사용해서 동기화가 가능하지만, 남용할 경우 성능 저하를 일으킬 수 있다.
       왜냐하면 해당 키워드를 사용할 경우 자바 내부적으로 Thread 동기화를 하기 위해 block, unblock 처리를 하게 되는데
       이런 처리들도 어느정도 시간이 걸리기 때문이다.

    private static Singleton instance;

    private Singleton(){}

    public static synchronized Singleton getInstance() {
        if(instance == null){
            return new Singleton();
        }
        return instance;
    }

    */
}
