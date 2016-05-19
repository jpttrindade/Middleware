package name;

import client.invocation.ConsoleProxy;

import java.util.ArrayList;

/**
 * Created by jpttrindade on 19/05/16.
 */
public interface INameService {
    public void bind(String name, ConsoleProxy aor);
    public ConsoleProxy lookup(String serviceName);
    public ArrayList<String> list();

}
