import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Client {

    public static void main(String[] args) {

        int portNumber = 8080;
        String hostName = "127.0.0.1";

        try {
            Socket clientSocket = new Socket(hostName, portNumber);

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            String inputStreamString = inputStream.toString();

            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            if (inputStreamString.equals("Maintenance")) {
                outputStream.write(("Maintenance").getBytes());
            } else if (inputStreamString.equals("Food")) {
                outputStream.writeUTF("Food");
                outputStream.flush();
            } else if (inputStreamString.equals("Cleaning")) {
                outputStream.writeUTF("Cleaning");
                outputStream.flush();
            } else if (inputStreamString.equals("Call")) {
                outputStream.writeUTF("Call");
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

