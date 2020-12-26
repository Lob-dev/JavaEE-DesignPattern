package lob.code.proxy.purejavaproxy;

public class TargetObjectImpl implements TargetObject {

    @Override
    public String someMethod(String name) {
        return "Real Subject method "+ name +"\n";
    }
}
