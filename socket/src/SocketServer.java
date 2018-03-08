import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {
    private ServerSocket serverSocket;

    private ExecutorService executorService;

    private boolean stop = false;

    public SocketServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            executorService = Executors.newFixedThreadPool(30);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void start() {
        try {
            while (!stop) {
                Socket s = accept();

                SocketThread t = new SocketThread(s);
                executorService.execute(t);
            }
        } catch (Exception ignored) {
        } finally {
            close();
        }
    }

    public void stop() {
        stop = true;
    }

    private Socket accept() {
        try {
            Socket socket = serverSocket.accept();
            return socket;
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    private void close() {
        if (!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
        executorService.shutdown();
    }
}