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

    public ConsoleProxy(String host, int port) {
        super(host, port);
        requestor = new Requestor(host, port);
    }

    @Override
    public void print(String text) {
        Message m = new Message();
        m.operacao = "print";
        m.param = text;
        requestor.invoke(m);
    }
}
