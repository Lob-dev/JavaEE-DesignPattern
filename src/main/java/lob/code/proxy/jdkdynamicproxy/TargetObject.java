package lob.code.proxy.jdkdynamicproxy;

public interface TargetObject {

    void someMethod(String name);

    default void someMethodA() {
        System.out.println("TargetObject.someMethodA");
    }

    default void someMethodB() {
        System.out.println("TargetObject.someMethodA");
    }

}
