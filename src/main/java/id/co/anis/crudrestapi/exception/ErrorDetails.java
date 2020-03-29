package id.co.anis.crudrestapi.exception;

import java.util.Date;

/**
 * Created By Anis
 * created on 3/29/2020 - 5:08 PM on crudrestapi
 */
public class ErrorDetails {
    private Date timeStapms;
    private String message;
    private String detail;

    public ErrorDetails(Date timeStapms, String message, String detail) {
        super();
        this.timeStapms = timeStapms;
        this.message = message;
        this.detail = detail;
    }

    public Date getTimeStapms() {
        return timeStapms;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
