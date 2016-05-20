package name;

import client.invocation.ConsoleProxy;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ServiceInstance {
    String name;
    ConsoleProxy clientProxy;

    public ServiceInstance(String name, ConsoleProxy clientProxy) {
        this.name = name;
        this.clientProxy = clientProxy;
    }
}
