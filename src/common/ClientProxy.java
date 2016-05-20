package common;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ClientProxy {
    private int port;
    private String host;
    private AbsoluteObjectReference aor;

    public ClientProxy(String _host, int _port, String objectID) {
        aor = new AbsoluteObjectReference();
        aor.host = _host;
        port = _port;
        setObjectID(objectID);
    }

    public void setObjectID(String id) {
        aor.objectId = id;
    }

    public String getObjectID() {
        return aor.objectId;
    }
    public int getPort() {
        return port;
    }

    public String getHost() {
        return aor.host;
    }
}
