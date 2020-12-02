package lob.singleton;

public enum EnumSingleton {
    INSTANCE;
    public void doSomethingInteresting(){}

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        System.out.println("singleton = " + singleton);

    }
}
