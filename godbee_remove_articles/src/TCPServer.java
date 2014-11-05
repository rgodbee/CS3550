/*
 * Richard Godbee
 * CS 3550
 * Assignment 2
 */
import java.io.*; 
import java.net.*;

class TCPServer {

	public static void main(String argv[]) throws Exception 
	{ 
		String clientSentence; 
			
		ServerSocket welcomeSocket = new ServerSocket(6790); 
		
		while(true) {
			
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("IP:" + connectionSocket);
			BufferedReader inFromClient = 
			new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream  outToClient = 
			new DataOutputStream(connectionSocket.getOutputStream());
//			long startTime = System.currentTimeMillis();
			while((clientSentence = inFromClient.readLine())!=null){
//				System.out.println("Received"+clientSentence);
				String pattern = "(\\s|^)(THE|tHe|the|The|a|A|an|An)(\\s|$)";
				String noArticlesSentence = clientSentence.replaceAll(pattern, " ")+'\n';
				System.out.println("[Original String]:"+clientSentence);
				System.out.print("[Altered String]:"+noArticlesSentence);
				outToClient.writeBytes(noArticlesSentence); 
			}
//			long estimatedTime = System.currentTimeMillis() - startTime;
//			System.out.println("Time Elapsed: "+estimatedTime+" milliseconds");
		} 
	} 
} 