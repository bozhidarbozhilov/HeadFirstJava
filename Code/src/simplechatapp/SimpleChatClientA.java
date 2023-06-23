package simplechatapp;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.charset.StandardCharsets.*;

public class SimpleChatClientA {
    private JTextArea incoming;
    private JTextField outgoing;
    private BufferedReader reader;

    private PrintWriter writer;

    public void go(){
        setUpNetworking();
        JScrollPane scroller = createScrollableTextArea();
        outgoing = new JTextField(20);
        JButton sendBtn = new JButton("Send");

        sendBtn.addActionListener(e->sendMessage());

        JPanel mainPanel = new JPanel();
        mainPanel.add(scroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendBtn);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new IncomingReader());

        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private JScrollPane createScrollableTextArea() {
        incoming = new JTextArea(15,30);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane scroller = new JScrollPane(incoming);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }

    private void sendMessage() {
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    private void setUpNetworking() {
        try{
            InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5050);
            SocketChannel socketChannel = SocketChannel.open(serverAddress);

            writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
            reader = new BufferedReader(Channels.newReader(socketChannel, UTF_8));
            System.out.println("Networking established.");
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;
            try{
                while((message = reader.readLine()) != null){
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}
