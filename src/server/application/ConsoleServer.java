package server.application;

import client.invocation.ConsoleProxy;
import common.ClientProxy;
import name.NameServiceProxy;
import server.invocation.Invoker;

import java.io.IOException;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ConsoleServer {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        ConsoleProxy consoleProxy = new ConsoleProxy("localhost", 2424);

        NameServiceProxy nameService = new NameServiceProxy("localhost", 1717);

        nameService.bind("Console", consoleProxy);

        try {
            invoker.invoke(consoleProxy);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
