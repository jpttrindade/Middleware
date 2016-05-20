package client.invocation;

import client.invocation.Requestor;
import common.ClientProxy;
import common.Console;
import common.Message;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ConsoleProxy extends ClientProxy implements Console {

    private Requestor requestor;

    public ConsoleProxy(String host, int port, String objectID) {
        super(host, port, objectID);
        requestor = new Requestor(host, port);
    }

    @Override
    public String getID() {
        return getObjectID();
    }

    @Override
    public void print(String text) {
        Message m = new Message();
        m.operacao = "print";
        m.param = text;
        m.objectID = getObjectID();
        requestor.invoke(m);
    }
}
