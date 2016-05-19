package name;

import java.io.Serializable;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class NameServiceMessage implements Serializable{
    private static final long serialVersionUID = 3940341617988134707L;

    String op;
    String host;
    int port;
    String param;

}
