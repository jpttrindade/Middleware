package server.request;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ServerRequestHandler {

    private int port;
    private ServerSocket ssk;
    private Socket sk;

    private DataOutputStream dtout;
    private DataInputStream dtin;

    public ServerRequestHandler(int _port) {
        port = _port;
    }

    public byte[] receive() throws IOException {
        ssk = new ServerSocket(port);
        sk = ssk.accept();

        dtin = new DataInputStream(sk.getInputStream());


        byte[] bytes = new byte[dtin.readInt()];
        dtin.read(bytes);

        return bytes;
    }

    public void send(byte[] bytes) throws IOException {
        dtout = new DataOutputStream(sk.getOutputStream());
        dtout.writeInt(bytes.length);
        dtout.write(bytes);
        dtout.flush();

        sk.close();
        ssk.close();
        dtout.close();
        dtin.close();

    }

}
