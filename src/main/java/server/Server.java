package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server  {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(25225);

        Map<String, WebDate> handlers = loadHandlers();

        System.out.println("Server is started!");
        while (true) {
            Socket client = socket.accept();
            new ServerHandler(client, handlers).start();
        }
    }

    private static Map<String, WebDate> loadHandlers() {
        Map<String, WebDate> result = new HashMap<>();

        try (InputStream is = Server.class.getClassLoader().getResourceAsStream("server.properties")) {
            Properties properties = new Properties();
            properties.load(is);

            for (Object o : properties.keySet()) {
                String className = properties.getProperty(o.toString());
                Class<WebDate> c1 = (Class<WebDate>) Class.forName(className);
                WebDate handler = c1.getConstructor().newInstance();
                result.put(o.toString(), handler);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }
}


    class ServerHandler extends Thread {

        private Socket client;
        private Map<String, WebDate> handlers;

        public ServerHandler(Socket client, Map<String, WebDate> handlers) {
            this.client = client;
            this.handlers = handlers;
        }

        @Override
        public void run() {
            handleRequest(client);
        }

        private void handleRequest(Socket client) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                String request = br.readLine(); //читаем полученную информацию
                String[] lines = request.split("\\s+");
                String appNum = lines[0];
                String userData = lines[1];

                System.out.println("Server got 1: " + appNum);
                System.out.println("Server got 2: " + userData);

                String response = builtResponse(appNum, userData);
                bw.write(response);
                bw.newLine();
                bw.flush(); //сразу отправляем данные

                br.close();
                bw.close();

                client.close();

            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }

        private String builtResponse(String command, String userData) {
            WebDate handler = handlers.get(command);
            if(handler!=null){
                return handler.checkInfo(userData);
            }
            return "Haha "+ userData;
        }
    }

