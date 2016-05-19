package server.application;

import common.Console;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ConsoleImpl implements Console {

    @Override
    public void print(String text) {
        System.out.println(String.format(">>> %s", text));
    }
}
