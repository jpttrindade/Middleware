package server.application;

import common.Console;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ConsoleImpl implements Console {

    private String id;

    public ConsoleImpl(String _id) {
        id = _id;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void print(String text) {
        System.out.println(String.format(">>> %s", text));
    }
}
