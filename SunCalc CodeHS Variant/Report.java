public class Report {
    private final String reason;

    public Report(String reason) {
        this.reason = reason;
    }

    public String toString() {
        return (reason + "\nJoin the Discord server to report mistakes: https://bit.ly/SunCalcServer");
    }
}
