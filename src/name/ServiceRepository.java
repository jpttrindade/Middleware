package name;

import java.util.ArrayList;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class ServiceRepository {
    ArrayList<ServiceInstance> services = new ArrayList<ServiceInstance>();

    public void add(ServiceInstance service) {
        services.add(service);
        System.out.println("total services = "+services.size());
    }

    public ServiceInstance get(String name){
        ServiceInstance si = null;
        for (ServiceInstance s : services) {
            if(s.name.equals(name)){
                System.out.println("Serviço encontrado!!");
                si = s;
                System.out.println("["+si.name +"]"+ " : "+si.clientProxy.getID() + " : "+ si.clientProxy.getHost());
            }
        }
        return si;
    }
}
