/*
 * Requirements: Java 6+
 * Linux/Mac:
 *  wget https://github.com/TooTallNate/Java-WebSocket/releases/download/v1.3.9/Java-WebSocket-1.3.9.jar -O Java-WebSocket.jar
 *  javac -cp "web_socket_client/java:Java-WebSocket.jar" web_socket_client/java/Client.java
 *  java -cp "web_socket_client/java:Java-WebSocket.jar" Client
 * Windows (Powershell):
 *  wget https://github.com/TooTallNate/Java-WebSocket/releases/download/v1.3.9/Java-WebSocket-1.3.9.jar -OutFile Java-WebSocket.jar
 *  javac -cp "web_socket_client/java;Java-WebSocket.jar" web_socket_client/java/Client.java
 *  java -cp "web_socket_client/java;Java-WebSocket.jar" Client
 */

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class Client extends WebSocketClient {
  private int count = 0;

  public Client(URI serverURI) {
    super(serverURI);
  }

  @Override
  public void onOpen(ServerHandshake handshakedata) {
  }

  @Override
  public void onMessage(String message) {
  }

  @Override
  public void onClose(int code, String reason, boolean remote) {
  }

  @Override
  public void onError(Exception e) {
    e.printStackTrace();
  }

  public void sendCount() {
    if (isOpen()) {
      System.out.println("Sending " + count);
      send(String.valueOf(count));
      count++;
    }
  }

  public static void main(String[] args) throws Exception {
    Client c = new Client(new URI("ws://localhost:9000"));
    c.connect();

    while (true) {
      c.sendCount();
      Thread.sleep(1000);
    }
  }
}
