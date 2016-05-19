package common;

import java.io.*;
import java.util.Arrays;

/**
 * Created by jpttrindade on 19/05/16.
 */
public class Marshaller {



    public byte[] marshall(Message message) throws IOException {
        String msg = String.format("%s;%s;%s", message.objectID, message.operacao, message.param);
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bytes.write(msg.getBytes());
        return bytes.toByteArray();
    }

    public Message unmarshall(byte[] bytes) throws IOException {

        String[] tokens = new String(bytes).split(";");
        Message message = new Message();
        message.objectID  = tokens[0];
        message.operacao = tokens[1];
        message.param = tokens[2];

        return message;
    }

    public static void main (String args[]) {
        Marshaller m = new Marshaller();

        Message msg1 = new Message();
        msg1.objectID = "id1";
        msg1.operacao = "print";
        msg1.param = "Hellow World!";

        try {
            byte[] bytes = m.marshall(msg1);

            Message msg2 = m.unmarshall(bytes);


            System.out.println(msg2.objectID);
            System.out.println(msg2.operacao);
            System.out.println(msg2.param);

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
