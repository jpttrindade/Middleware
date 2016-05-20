package name;

import client.invocation.ConsoleProxy;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class NameServiceProxy implements INameService{

    private String host;
    private int port;
    private Socket socket;
    private DataOutputStream dtout;
    private DataInputStream dtin;

    public NameServiceProxy(String _host, int _port) {
        host = _host;
        port = _port;
    }

    @Override
    public void bind(String name, ConsoleProxy consoleProxy) {
        try {
            socket = new Socket(host, port);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            NameServiceMessage msg = new NameServiceMessage();
            msg.op = "bind";
            msg.host = consoleProxy.getHost();
            msg.port = consoleProxy.getPort();
            msg.param = name;
            msg.obejctID = consoleProxy.getObjectID();
            objectOutputStream.writeObject(msg);
            objectOutputStream.flush();
            objectOutputStream.close();
            socket.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ConsoleProxy lookup(String serviceName) {

        try {
            socket = new Socket(host, port);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            NameServiceMessage msg1 = new NameServiceMessage();

            msg1.op = "lookup";
            msg1.host = host;
            msg1.port = port;
            msg1.param = serviceName;

            objectOutputStream.writeObject(msg1);

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            NameServiceMessage  msg2 = (NameServiceMessage) objectInputStream.readObject();

            socket.close();
            objectInputStream.close();
            objectOutputStream.close();


            return new ConsoleProxy(msg2.host, msg2.port, msg2.obejctID );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public ArrayList<String> list() {
        return null;
    }
}
