import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
public class Client {
    private int color;
    private int port;
    private InputStream inputStream;
    private OutputStream outputStream;
    public void init(int color, int port){
        try {
            Socket socket = new Socket("localhost", port);
            System.out.println("Connected to server");
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            //Get RedStone
            byte[] str_byte = new byte[12];
            inputStream.read(str_byte, 0, 12);
            String redinfo = new String(str_byte);
            System.out.println("Got Red Stone :" + redinfo);
        } catch (IOException e){
            System.err.println("catch" + e);
        }
    }
    public static void main(String[] args) {
        Client c = new Client();
        Scanner sc = new Scanner(System.in);
        int color = sc.nextInt();
        int port = sc.nextInt();
        c.init(color, port);
    }
}

















