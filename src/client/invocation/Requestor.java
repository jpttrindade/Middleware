package client.invocation;

import client.request.ClientRequestHandler;
import common.Marshaller;
import common.Message;

import java.io.IOException;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class Requestor {


    private Marshaller marshaller = new Marshaller();

    private String host;
    private int port;

    public Requestor(String _host , int _port) {
        host = _host;
        port = _port;
    }



    public void invoke(Message m) {
        try {
            byte[] bytes = marshaller.marshall(m);
            ClientRequestHandler.getInstance().send(host, port, bytes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


    public static void main(String[] args) {
        Message m = new Message();
        m.objectID = "id2";
        m.operacao = "echo2";
        m.param = "hello world2!";

        //new Requestor().invoke(m);
    }
}
