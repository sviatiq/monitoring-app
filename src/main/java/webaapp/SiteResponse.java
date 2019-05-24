package webaapp;


import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

public class SiteResponse extends Site {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ClientData clientData = new ClientData(i);
            clientData.start();
        }
    }
}

class ClientData extends Thread {

    private final static String[] WEB_APPS = {"localhost:8080", "localhost:1212", "localhost:1234", "localhost2345", "localhost:2020"};
    private int appNum;

    public ClientData(int appNum) {
        this.appNum = appNum;
    }

    @Override
    public void run() {
        sendInformation();
    }

    private void sendInformation() {

        try {
            System.out.println("Send URL " + LocalDateTime.now());

            Socket socket = new Socket("127.0.0.1", 25225);

            BufferedReader br = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((socket.getOutputStream())));

            String app = WEB_APPS[appNum % WEB_APPS.length];
            String str = "http://" + app;

            bw.write(str);
            bw.newLine();
            bw.flush();

            String answer = br.readLine();
            System.out.println("Got the answer" + answer);


        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }


//
//        t.start();
//        LocalTime time1 = LocalTime.now();
//        Thread.sleep(5000);
//        LocalTime time2 = LocalTime.now();
//        //число в секундах которое запишется в БД, говорит о том, на сколько быстро отвечает сервер

}
