package ua.kpi.comsys.dop;

public record ImageMsg(String sender, String url, int sizeKb) implements Notification {
    public ImageMsg {
        if (sender == null || sender.isBlank()) {
            throw new IllegalArgumentException("sender must not be blank");
        }
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("url must not be blank");
        }
        if (sizeKb <= 0) {
            throw new IllegalArgumentException("sizeKb must be positive");
        }
    }
}
