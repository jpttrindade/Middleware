package name;

import client.invocation.ConsoleProxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class NameServiceServer {

    public static void main(String[] args) {
        try {
            NameService nameService = new NameService();

            Socket sk;
            ObjectInputStream objectInputStream;
            ObjectOutputStream objectOutputStream = null;
            ServerSocket ssk = new ServerSocket(1717);
            System.out.println("Servidor de Nomes ONLINE");

            while (true) {
                sk = ssk.accept();
                System.out.println("<<<Nova conexão>>>");
                System.out.println(sk.toString());

                objectInputStream = new ObjectInputStream(sk.getInputStream());

                NameServiceMessage message = (NameServiceMessage) objectInputStream.readObject();

                if (message.op.equals("bind")) {
                    System.out.println("bind");
                    nameService.bind(message.param, new ConsoleProxy(message.host, message.port, message.obejctID));
                } else if (message.op.equals("lookup")){
                    System.out.println("lookup");

                    objectOutputStream = new ObjectOutputStream(sk.getOutputStream());

                    NameServiceMessage msg = new NameServiceMessage();
                    ConsoleProxy consoleProxy = nameService.lookup(message.param);
                    msg.host = consoleProxy.getHost();
                    msg.port = consoleProxy.getPort();
                    msg.obejctID = consoleProxy.getObjectID();

                    objectOutputStream.writeObject(msg);
                    objectOutputStream.flush();

                }
                objectInputStream.close();
                if(objectOutputStream != null) objectOutputStream.close();
                sk.close();
            }

            //ssk.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void send(ConsoleProxy consoleProxy) {

    }
}
