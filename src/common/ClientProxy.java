package common;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ClientProxy {
    private int port;
    private String host;

    public ClientProxy(String _host, int _port) {
        host = _host;
        port = _port;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
}
