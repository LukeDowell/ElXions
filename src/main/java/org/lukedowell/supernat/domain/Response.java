package org.lukedowell.supernat.domain;

/**
 * Badass response envelope
 * Created by ldowell on 11/20/15.
 */
public class Response<T> {

    public static final int SUCCESS = 1;
    public static final int FAILED = 0;

    private int status;

    private String reason;

    private T result;

    public Response() {}

    public Response(int status, String reason, T result) {
        this.status = status;
        this.reason = reason;
        this.result = result;
    }

    public Response(T result) {
        this(SUCCESS, "Success", result);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}
