package lob.code.proxy.purejavaproxy;

public class TargetObjectProxy implements TargetObject {

    TargetObjectImpl subject;

    {
        subject = new TargetObjectImpl();
    }

    @Override
    public String someMethod(String name) {
        System.out.println("Before proxy");

        return subject.someMethod(name) + ("After proxy\n");
    }
}
