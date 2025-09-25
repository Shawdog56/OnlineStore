package OnlineShop;

import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT = 9010;

        try {
            Socket s = new Socket(HOST,PORT);
            PrintWriter spw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader sbr = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String message = br.readLine();
            spw.println(message);
            spw.flush();

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
