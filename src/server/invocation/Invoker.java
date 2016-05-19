package server.invocation;

import common.ClientProxy;
import common.Marshaller;
import common.Message;
import server.application.ConsoleImpl;
import server.request.ServerRequestHandler;

import java.io.IOException;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class Invoker {


    private Marshaller marshaller = new Marshaller();
    private Message msg = new Message();

    public void invoke(ClientProxy clientProxy) throws IOException {
        ServerRequestHandler serverRequestHandler = new ServerRequestHandler(clientProxy.getPort());

        ConsoleImpl console = new ConsoleImpl();

        while (true) {
            byte[] bytes = serverRequestHandler.receive();
            msg = marshaller.unmarshall(bytes);

            execMethodConsole(console, msg);

            bytes = marshaller.marshall(msg);

            serverRequestHandler.send(bytes);
        }
    }

    private void execMethodConsole(ConsoleImpl console, Message msg) {

        if (msg.operacao.equals("print")) console.print(msg.param);


    }
}

