package lob.code.singleton;

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


    /* 생성 요청이 아닌 Class Loader 에 의한 Loading 시 Singleton 생성하기
    private final static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(instance.toString());
    }

    */

    /* 생성자 호출 전에 초기화 되는 Static Block 을 통한 Lazy initialization Singleton
    private static Singleton instance = null;

    static {
        instance = new Singleton();
    }

    private Singleton() {};

    public static Singleton getInstance() {
        return  instance;
    }
    */


    /*
    Double-checked locking Singleton.
    인스턴스 생성 여부를 임계 영역을 통한 잠금 이전에 1번. 잠금 이후에 객체 생성 이전에 한번 진행하는 방식이다.
    해당 방식도 Reflection API 를 통하여 생성자의 접근 수정자를 public 으로 바꾼다면 싱글톤을 만들 수 있다.
    */

    private static Singleton instance;

    private Singleton() {};

    public static Singleton getInstance() {
        if (instance == null) { // 1중 잠금
            synchronized (Singleton.class){
                if (instance == null){ // 2중 잠금
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) throws Exception {
        // Reflection API 을 통한 여러 Singleton 객체 만들기

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = null;
        Singleton instance3 = null;
        try {
            Class<Singleton> c = Singleton.class;

            // 접근 설정자와 상관없이 모든 생성자에 접근할 수 있다. getDeclaredConstructor();
            var constructor = c.getDeclaredConstructor();

            // 가져온 생성자의 Private 접근 설정에 대하여서 접근 가능하게끔 설정한다.
            constructor.setAccessible(true);

            // constructor 객체의 새성자를 사용하여 인스턴스를 만들고 초기화한 다음, 초기화 매개 변수를 통해 클래스를 선언한다.
            instance2 = constructor.newInstance();
            instance3 = constructor.newInstance();

        //NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("instance2 = " + instance1);
        System.out.println("instance2 = " + instance2);
        System.out.println("instance2 = " + instance3);
    }
}
