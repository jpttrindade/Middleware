package server.application;

import client.invocation.ConsoleProxy;
import name.NameServiceProxy;
import server.invocation.Invoker;

import java.io.IOException;
import java.util.Random;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class Server {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        //System.out.println(""+(Math.random() *1000)+1);
        ConsoleProxy consoleProxy = new ConsoleProxy("localhost", 2424, ((Math.random() *10)+1)+"");

        NameServiceProxy nameService = new NameServiceProxy("localhost", 1717);

        nameService.bind("Console", consoleProxy);
        System.out.println("Server deu bind no objeto de id = "+consoleProxy.getID());

        try {
            invoker.invoke(consoleProxy);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
