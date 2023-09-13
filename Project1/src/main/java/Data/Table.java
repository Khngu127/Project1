package Data;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Table {

    private String fn, ln, access, status, user, id;
    private final LocalDate time;

    public Table(String fn, String ln, String id, String status, String user, String access, LocalDate time) {
        this.fn = fn;
        this.ln = ln;
        this.access = access;
        this.status = status;
        this.user = user;
        this.id = id;
        this.time = time;
    }

    public String getFn() {
        return fn;
    }

    public String getLn() {
        return ln;
    }

    public String getAccess() {
        return access;
    }

    public String getStatus() {
        return status;
    }

    public String getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public LocalDate getTime() {
        return time;
    }
}
