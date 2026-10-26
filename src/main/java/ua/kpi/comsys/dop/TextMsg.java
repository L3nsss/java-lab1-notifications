package ua.kpi.comsys.dop;

public record TextMsg(String sender, String text) implements Notification {
    public TextMsg {
        if (sender == null || sender.isBlank()) {
            throw new IllegalArgumentException("sender must not be blank");
        }
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("text must not be blank");
        }
    }
}
