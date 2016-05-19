package client.request;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ClientRequestHandler {

    private String host;
    private int port;
    private Socket sk;
    private DataOutputStream dtout;
    private DataInputStream dtin;

    private static ClientRequestHandler sSingleton;

    public static ClientRequestHandler getInstance() {
        if (sSingleton == null) sSingleton = new ClientRequestHandler();
        return sSingleton;
    }

     private ClientRequestHandler() {}



    public void send(String host, int port, byte[] bytes) throws IOException {
        sk = new Socket(host, port);

        dtout = new DataOutputStream(sk.getOutputStream());

        dtin = new DataInputStream(sk.getInputStream());

        dtout.write(bytes);

        dtout.flush();

        receive();
    }

    private void receive() throws IOException {
       // System.out.println("dtin.read() = "+dtin.read());
        byte[] bytes = new byte[dtin.read()];
        dtin.read(bytes);
        String st = new String(bytes);
        System.out.println(st);
        sk.close();
        dtout.close();
        dtin.close();
    }
}
