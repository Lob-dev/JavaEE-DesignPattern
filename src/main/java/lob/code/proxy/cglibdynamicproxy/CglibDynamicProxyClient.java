package lob.code.proxy.cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
    CGLIB Dynamic Proxy (Spring, Hibernate - embed Library)
    코드 생성 라이브러리(Code Generator Library), 런타임에 동적으로 자바 클래스의 프록시를 생성해주는 기능을 제공한다.

    - 실제 바이트 코드를 조작하여 JDK Dynamic Proxy 보다 상대적으로 빠르다.
    - CGLIB 프록시는 Interface 기반의 Proxy 가 아니라 Target Class 를 상속받아 생성한다.
    - final 이나 private 같이 상속된 객체에 Overriding 을 제공하는 않는다면 해당 행위에 대해서 Aspect 를 적용할 수 없다.
*/

public class CglibDynamicProxyClient {

    public static void main(String[] args) {
        CglibDynamicProxyClient client = new CglibDynamicProxyClient();
        client.run("Lob");
    }

    public void run(String name) {

        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            final TargetObject targetObject = new TargetObject();

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("Before Proxy");
                Object invoke = method.invoke(targetObject, args);
                System.out.println("After Proxy");
                return invoke;
            }
        };

        TargetObject targetObject = (TargetObject) Enhancer.create(TargetObject.class, methodInterceptor);

        targetObject.someMethod(name);
    }
}
