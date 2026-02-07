package model;

public class PromiseUpdate {
    private String promiseId, date, detail;
    public PromiseUpdate(String pro_id, String date, String detail) {
        this.promiseId = pro_id; this.date = date; this.detail = detail;
    }

    public String getPromiseId() {
        return this.promiseId;
    }

    public void setPromiseId(String promiseId) {
        this.promiseId = promiseId;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}