package lob.code.proxy.jdkdynamicproxy;

public class TargetObjectImpl implements TargetObject {

    @Override
    public void someMethod(String name) {
        System.out.println("Real Subject Do something " + name);
    }
}
