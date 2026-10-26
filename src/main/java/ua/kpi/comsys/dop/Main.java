package ua.kpi.comsys.dop;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationProcessor processor = new NotificationProcessor();
        List<Notification> notifications = List.of(
                new TextMsg("Olena", "Hello, Java!"),
                new ImageMsg("Andrii", "https://example.com/photo.png", 256),
                new AudioMsg("Iryna", 45));
        for (Notification notification : notifications) {
            System.out.println(processor.process(notification));
        }
    }
}