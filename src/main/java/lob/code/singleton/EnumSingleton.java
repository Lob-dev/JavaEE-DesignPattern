package lob.code.singleton;

public enum EnumSingleton {
    INSTANCE;
    public void doSomethingInteresting(){}

    public static void main(String[] args) {
        System.out.println("singleton = " + EnumSingleton.INSTANCE);
    }
}
