package name;

import client.invocation.ConsoleProxy;

import java.util.ArrayList;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class NameService implements  INameService{

    ServiceRepository repository = new ServiceRepository();

    @Override
    public void bind(String name, ConsoleProxy aor) {
        System.out.println("bind called");
        repository.add(new ServiceInstance(name, aor));
    }

    @Override
    public ConsoleProxy lookup(String serviceName) {
        return repository.get(serviceName).clientProxy;
    }


    @Override
    public ArrayList<String> list() {
        return null;
    }
}
