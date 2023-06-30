
public enum Status {
    c("Complete"), p("inProcess"),d("Deferred");
    public final String status;
    Status(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
