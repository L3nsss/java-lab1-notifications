package ua.kpi.comsys.dop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationProcessorTest {
    private final NotificationProcessor processor = new NotificationProcessor();

    @Test
    void formatsText() {
        assertEquals("Notification: TEXT\nFrom: Olena\nMessage: Hello, Java!\n",
                processor.process(new TextMsg("Olena", "Hello, Java!")));
    }

    @Test
    void formatsImage() {
        assertEquals("Notification: IMAGE\nFrom: Andrii\nURL: https://example.com/photo.png (256 KB)\n",
                processor.process(new ImageMsg("Andrii", "https://example.com/photo.png", 256)));
    }

    @Test
    void formatsAudio() {
        assertEquals("Notification: AUDIO\nFrom: Iryna\nDuration: 45 seconds\n",
                processor.process(new AudioMsg("Iryna", 45)));
    }

    @Test
    void rejectsNull() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class,
                () -> processor.process(null));
        assertEquals("Notification cannot be null", error.getMessage());
    }

    @Test
    void preservesUnicodeAndMultilineText() {
        assertEquals("Notification: TEXT\nFrom: Олена\nMessage: Рядок 1\nРядок 2\n",
                processor.process(new TextMsg("Олена", "Рядок 1\nРядок 2")));
    }
}
