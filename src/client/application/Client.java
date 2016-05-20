package client.application;

import client.invocation.ConsoleProxy;
import common.Console;
import name.NameServiceProxy;

import java.util.Scanner;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class Client {

    public static void main(String[] args){
        System.out.println("Client ONLINE");

        NameServiceProxy nameServiceProxy = new NameServiceProxy("localhost", 1717);
        System.out.println("Client pegou o nameServiceProxy");

        Console console = nameServiceProxy.lookup("Console");
        System.out.println("Client deu lookup no objeto de ID = "+console.getID());


        System.out.println("Por favor digite os comandos aqui:");
        Scanner in = new Scanner(System.in);
        String input;
        do {
            System.out.print("> ");
            input = in.nextLine();
            console.print(input);
        } while (!input.equals("exit"));

        System.out.println("Good bye!!!");

    }
}
