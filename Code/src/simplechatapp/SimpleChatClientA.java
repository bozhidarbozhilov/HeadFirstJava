package simplechatapp;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;

public class SimpleChatClientA {
    private JTextField outgoing;
    private PrintWriter writer;

    public void go(){
        setUpNetworking();
        outgoing = new JTextField(20);
        JButton sendBtn = new JButton("Send");

        sendBtn.addActionListener(e->sendMessage());

        JPanel mainPanel = new JPanel();
        mainPanel.add(outgoing);
        mainPanel.add(sendBtn);

        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
            System.out.println("Networking established.");
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}
