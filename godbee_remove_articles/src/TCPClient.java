/*
 * Richard Godbee
 * CS 3550
 * Assignment 2
 */
import java.io.*; 
import java.net.*; 
class TCPClient {

    public static void main(String argv[]) throws Exception 
    { 
        String sentence; 
        String modifiedSentence;

        BufferedReader inFromUser = 
          new BufferedReader(new FileReader("really-big-file1.txt"));

        Socket clientSocket = new Socket("localhost", 6790);

        DataOutputStream outToServer = 
          new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = 
          new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        int counter = 0;
        long startTime = System.currentTimeMillis();
        while((sentence = inFromUser.readLine()) != null){
        	outToServer.writeBytes(sentence + '\n');
//        	System.out.println(counter);
        	counter++;
        	modifiedSentence = inFromServer.readLine();	
//	        System.out.println("[FROM SERVER]: " + modifiedSentence);
        }
        clientSocket.close();
        long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Time Elapsed: "+estimatedTime+" milliseconds");
		System.out.print("Number of lines sent: "+counter);

    } 
}
/*
 * Running big-file1.txt
 * Time Elapsed: 606902 milliseconds
 * Number of lines sent: 128457
 * 
 * Running really-big-file1.txt
 * Time Elapsed: 1194644 milliseconds
 * Number of lines sent: 256890
 */
