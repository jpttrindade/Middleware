package server.invocation;

import common.ClientProxy;
import common.Console;
import common.Marshaller;
import common.Message;
import server.application.ConsoleImpl;
import server.request.ServerRequestHandler;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class Invoker {


    private Marshaller marshaller = new Marshaller();
    private Message msg = new Message();
    private HashMap<String, Console> objects = new HashMap<String, Console>();

    public void invoke(ClientProxy clientProxy) throws IOException {

        ConsoleImpl console = new ConsoleImpl(clientProxy.getObjectID());
        objects.put(console.getID(), console);
        ServerRequestHandler serverRequestHandler = new ServerRequestHandler(clientProxy.getPort());


        while (true) {
            byte[] bytes = serverRequestHandler.receive();
            msg = marshaller.unmarshall(bytes);

            execMethodConsole(msg);

            bytes = marshaller.marshall(msg);

            serverRequestHandler.send(bytes);
        }
    }

    private void execMethodConsole(Message msg) {

        if (msg.operacao.equals("print")) {
            System.out.println("Selectionando o objeto remoto de id = "+msg.objectID);
            objects.get(msg.objectID).print(msg.param);
        }
    }
}

