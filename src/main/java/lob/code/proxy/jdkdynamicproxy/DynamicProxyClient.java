package lob.code.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/*
    JDK API Dynamic Proxy
    Java 에서 지원하는 동적(런타임) Proxy 구현 방식이다.
    특정 인터페이스들을 구현하는 클래스나 인스턴스를 만드는 기술

    가지고 있는 제약으로는 Interface 기반의 Proxy → 모든 Target Class 는 Interface 를 implement 하고 있어야 한다.
*/

public class DynamicProxyClient {

    public static void main(String[] args) {
        DynamicProxyClient dynamicProxyClient = new DynamicProxyClient();

        dynamicProxyClient.run("Lob");
    }

    public void run(String name) {
        realObject.someMethod(name);
    }

    TargetObject realObject = (TargetObject) Proxy.newProxyInstance(TargetObject.class.getClassLoader(), new Class[]{TargetObject.class},
            (InvocationHandler) (proxy, method, args) -> {
                TargetObject targetObject = new TargetObjectImpl();

                System.out.println("Before Proxy");
                Object invoke = method.invoke(targetObject, args);
                System.out.println("After Proxy");

                return invoke;
            });
}
