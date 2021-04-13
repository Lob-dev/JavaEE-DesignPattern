package lob.code;

public class Example {

	// 인스턴스 변수
	String var;

	// 인스턴스가 되지 않아도 접근 가능한 변수다
	// 정적 변수, static 변수
	static String staticVar;


	final String INDEX_VIEW = "WEB-INF/index1.html";

	int a;

}


class a {

	public static void main(String[] args) {

		// 클래스 정보 - perm generation
		Example.staticVar = "a";
		System.out.println(Example.staticVar);


		// 인스턴스, 인스턴스 변수 -> JVM Heap area
		Example example = new Example();
		example.var = ":";
		example.a = 10;


		String localVar = "l";
	}
}