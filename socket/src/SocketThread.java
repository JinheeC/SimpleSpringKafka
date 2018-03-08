import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SocketThread implements Runnable {

    private final Socket socket;

    SocketThread(Socket socket) {
        this.socket = Objects.requireNonNull(socket);
    }

    @Override
    public void run() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String result = in.lines()
                              .collect(Collectors.joining("\n"));
            System.out.println("received message : " + result);
        } catch (Exception ignored) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                socket.close();
            } catch (IOException ignored) {
            }
        }
    }
}