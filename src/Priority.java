
public enum Priority {
    h("High"),m("Medium"),l("Low");
    public final String priority;
    Priority(String priority) {
        this.priority = priority;
    }
    public String getPriority() {
        return priority;
    }
}
