package lob.code.proxy;

import lob.code.proxy.cglibdynamicproxy.CglibDynamicProxyClient;
import lob.code.proxy.jdkdynamicproxy.DynamicProxyClient;
import lob.code.proxy.purejavaproxy.PureProxyClient;

public class ProxyClient {

    public static void main(String[] args) {
        PureProxyClient client1 = new PureProxyClient();
        DynamicProxyClient client2 = new DynamicProxyClient();
        CglibDynamicProxyClient client3 = new CglibDynamicProxyClient();


        client1.run("Lob");
        System.out.println();
        client2.run("Lob");
        System.out.println();
        client3.run("Lob");
    }

}
