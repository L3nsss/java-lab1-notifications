package ua.kpi.comsys.dop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class NotificationValidationTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t\n"})
    void rejectsInvalidTextSender(String value) {
        assertThrows(IllegalArgumentException.class, () -> new TextMsg(value, "text"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t\n"})
    void rejectsInvalidTextBody(String value) {
        assertThrows(IllegalArgumentException.class, () -> new TextMsg("sender", value));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t\n"})
    void rejectsInvalidImageSender(String value) {
        assertThrows(IllegalArgumentException.class, () -> new ImageMsg(value, "url", 1));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t\n"})
    void rejectsInvalidImageUrl(String value) {
        assertThrows(IllegalArgumentException.class, () -> new ImageMsg("sender", value, 1));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t\n"})
    void rejectsInvalidAudioSender(String value) {
        assertThrows(IllegalArgumentException.class, () -> new AudioMsg(value, 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void rejectsInvalidSize(int value) {
        assertThrows(IllegalArgumentException.class, () -> new ImageMsg("sender", "url", value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void rejectsInvalidDuration(int value) {
        assertThrows(IllegalArgumentException.class, () -> new AudioMsg("sender", value));
    }

    @Test
    void acceptsPositiveBoundaries() {
        assertEquals(1, new ImageMsg("s", "u", 1).sizeKb());
        assertEquals(Integer.MAX_VALUE,
                new ImageMsg("s", "u", Integer.MAX_VALUE).sizeKb());
        assertEquals(1, new AudioMsg("s", 1).durationSeconds());
        assertEquals(Integer.MAX_VALUE,
                new AudioMsg("s", Integer.MAX_VALUE).durationSeconds());
    }

    @Test
    void recordsPreserveValuesAndImplementValueEquality() {
        TextMsg text = new TextMsg(" sender ", " text ");
        assertEquals(" sender ", text.sender());
        assertEquals(" text ", text.text());
        assertEquals(text, new TextMsg(" sender ", " text "));
        assertEquals(new ImageMsg("s", "u", 2), new ImageMsg("s", "u", 2));
        assertEquals(new AudioMsg("s", 2), new AudioMsg("s", 2));
    }
}
