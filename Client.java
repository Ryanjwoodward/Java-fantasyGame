package storeDriver;

import java.net.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import store.Armor;
import store.Health;
import store.Weapon;

import java.io.*;

/**
 * @author Ryan Woodward
 *
 * Date: 11/17/2021
 * Class: CST-239
 * Description: Client Class for client and socket for milestone 6
 */
public class Client {

	private Socket _socket;
	private BufferedReader _input;
	private DataOutputStream _output;
	
	/**
	 * Client constructor behaves as the client to establish communication with storeServer
	 * @param ipAddress
	 * @param port
	 */
	public Client(String ipAddress, int port){
		
		try {
			
			_socket = new Socket(ipAddress, port);
			System.out.println("Successful Connection...");
			
			_input = new BufferedReader(new InputStreamReader(System.in));
			
			_output = new DataOutputStream(_socket.getOutputStream());
			
		}catch(UnknownHostException ue) {
			
			System.out.println(ue);
		}catch(IOException ioe) {
			
			System.out.println(ioe);
		}
		
		String str = "";
		
		while(!str.equals("STOP")) {
			
			try {
				
				str = _input.readLine();
				
				_output.writeUTF(str);	
			}catch(IOException ioe) {
				
				System.out.println(ioe);
			}
		}
		
		try {
			
			_input.close();
			_output.close();
			_socket.close();
			
		}catch(IOException ioe) {
			
			System.out.println(ioe);
		}
		
	}//Constructor
	
	public static void main(String[]args) {
		
		//System.out.println("Client main() accessed..."); [FOR TESTING]
		Client _client = new Client("127.0.0.1", 6666);
	}
	
	
	
}//Client Class
