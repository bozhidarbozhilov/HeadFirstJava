package chapter18;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentReaders {
    public static void main(String[] args) {
        //NOT thread safe - leads to ConcurrentModificationException
        //because a thread reads collection while another thread changes it
        //List<Chat> chatHistory = new ArrayList<>();
        //CopyOnWriteArrayList is thread safe collection
        List<Chat> chatHistory = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            Chat chat = new Chat("Hi There!");
            executorService.execute(()->chatHistory.add(chat));
            executorService.execute(()-> System.out.println(chatHistory));
            executorService.execute(()-> System.out.println(chatHistory));
        }
        executorService.shutdown();
    }

}
final class Chat {
    private final String message;
    private final LocalDateTime timestamp;

    public Chat(String message){
        this.message = message;
        timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String time = timestamp.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        return time + " " + message;
    }
}
