package lob.code.proxy.cglibdynamicproxy;

public class TargetObject {

    void someMethod(String name) {
        System.out.println("Real Subject Do something " + name);
    };

}
