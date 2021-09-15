import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.util.Date;
import java.util.*;
import java.nio.ByteBuffer;


class Server {
	private int color, port;
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Board board;

	Server(){
		board = new Board();
	}

	public void getArgument() {
		try {
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("Color of stone(0 : black, 1 : white) : ");
				color = sc.nextInt();
			
				if (!(color == 0 || color == 1)){
					System.out.println("Wrong Color of Stone");
					sc.nextLine();
					continue;
				}
				else {
					break;
				}
			}
			
			while(true) {
				System.out.println("Port Number : ");
				port = sc.nextInt();
				//여기서 port범위를 미리 제한해야 하는가?
				//만약 그렇다면 범위는 어떻게 설정해야하나??
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println(e);
		}
		System.out.println("Stone Color : "+color);
		System.out.println("Port Numver : "+port);
	}

	public void connect() {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Connect Client with" + port + " port");

			socket = serverSocket.accept();

			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
		} catch(SocketTimeoutException e){ /* Timeout occured on a socket read or accept*/
			System.err.println("Socket Timeout " + e);
		} catch(ConnectException e){ /* An error occurred while attempting to connect a socket */
			System.err.println("Couldn't get I/O for the connection " + e);
		} catch(IOException e){
			System.err.println("catch" + e);
		}
	}

	public void sendRedStones(){
		String redStones = board.getRedStones();
		try {
			System.out.println(redStones);
			byte[] red = redStones.getBytes();
			outputStream.write(red);
		} catch(IOException e) {
			System.err.println("Write redstone" + e);
		}
	}

	public void start(){
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter start");
			while(true){
				String startMessage = sc.nextLine();
				if(startMessage.equals("start")){
					System.out.println("Connect6 Start");
					break;
				}
			}
		} catch (Exception e){
			System.err.println("IOException " + e);
		}

		
		//black 
		if(color == 0){
			//k10에 돌놓기
		}
		//white
		else {
		
		}
		

	}
	
	public static void main(String[] args){
		Server server = new Server();
		server.getArgument();
		server.connect();			
		server.sendRedStones();	
		server.start();
	}
}
