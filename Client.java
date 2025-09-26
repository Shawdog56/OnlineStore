package OnlineStore;

import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT = 9010;

        try {
            Socket s = new Socket(HOST,PORT);
            ObjectOutputStream spw = new ObjectOutputStream(s.getOutputStream());
            BufferedReader sbr = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            User pusuas = new User("Fluffy", 15);
            spw.writeObject(pusuas);
            spw.flush();

            String message;
            message = sbr.readLine();
            System.out.print("Message received from server=" +  message);

            br.close();
            sbr.close();
            spw.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
