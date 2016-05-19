package client.application;

import client.invocation.ConsoleProxy;
import name.INameService;
import name.NameServiceProxy;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ConsoleClient {

    public static void main(String[] args){

        NameServiceProxy nameServiceProxy = new NameServiceProxy("localhost", 1717);

        ConsoleProxy consoleProxy = nameServiceProxy.lookup("Console");

        consoleProxy.print("Hello World!");

    }
}
