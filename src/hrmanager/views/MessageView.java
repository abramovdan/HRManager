package hrmanager.views;

import java.io.IOException;

public class MessageView {
	public MessageView(String message){
		System.out.println();
		System.out.println(message);
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
