public class Main {
    public static void main(String[] args) {
        SocketServer server = new SocketServer(1111);

        server.start();
    }
}