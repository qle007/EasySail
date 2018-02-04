import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.sql.*;

public class Server {

    public static void main (String[] args) {
        int portNumber = 8080;
        int LoginID = 123456; //FIXME: Figure out how to tell which user it is.

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocker = serverSocket.accept();

            Thread clientThread = new Thread();
            clientThread.start();

            DataInputStream inputStream = new DataInputStream(clientSocker.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocker.getOutputStream());

            String clientRequest = inputStream.toString();

            //Class.forName("com.mysql.jdbc.Driver").newInstance();

            if (clientRequest.equals("Maintenance")) {
                maintenance(LoginID);
            } else if (clientRequest.equals("Food")) {
                food();
            } else if (clientRequest.equals("Cleaning")) {
                cleaning(LoginID);
            } else if (clientRequest.equals("Call")) {
                call();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void maintenance(int loginID) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=admin&password=password");

            Statement statement = connection.createStatement();
            statement.executeQuery("USE Passengers;");
            ResultSet result = statement.executeQuery("SELECT FROM passengerinfo WHERE IDLogin=" + loginID);

            System.out.println("Sending maintenance service to room " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void food() {
        System.out.println("Ordering food item");
    }

    public static void cleaning(int loginID) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=admin&password=password");

            Statement statement = connection.createStatement();
            statement.executeQuery("USE Passengers;");
            ResultSet result = statement.executeQuery("SELECT FROM passengerinfo WHERE IDLogin=" + loginID);

            System.out.println("Sending cleaning service to room " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void call() {
        return;
    }

}