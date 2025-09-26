package OnlineStore;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        int PORT = 9010;
        
        try {
            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("Server running on host=" + ss.getInetAddress());
            System.out.println("SO_RCUBUF=" + ss.getOption(StandardSocketOptions.SO_RCVBUF));

            Socket s = ss.accept();
            PrintWriter spw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            ObjectInputStream sbr = new ObjectInputStream(s.getInputStream());


            System.out.println("Client connected from " + s.getInetAddress());

            User rcv = (User)sbr.readObject();
            System.out.println("Message Received: " + rcv);

            spw.println("Message Received, thanks");
            spw.flush();

            spw.close();
            sbr.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}