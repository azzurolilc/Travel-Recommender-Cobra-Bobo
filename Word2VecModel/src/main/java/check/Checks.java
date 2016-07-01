package check;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by lil on 6/28/16.
 */
public class Checks {
    private String message = "";

    // Constructor
    public Checks(String message){
        this.message = message;
    }

    private void appendMessage(String str){
        message.concat(str);
    }

    public String getMessage(){
        return message;
    }

    public void printMessage(){
        System.out.print(message);
    }

//    public boolean networkReschable() throws IOException {
//        int timeout = 2000;
//        InetAddress address = InetAddress.getByName("www.google.com");
//        return address.isReachable(timeout);
//    }

    public boolean networkReachable(String url) throws IOException {
        int timeout = 2000;
        InetAddress address = InetAddress.getByName(url);
        return address.isReachable(timeout);
    }



}
