package model;

public class Promise {
    private String promiseId, politicianId, detail, date, status;
    public Promise(String pro_id, String pol_id, String detail, String date, String status) {
        this.promiseId = pro_id; this.politicianId = pol_id; 
        this.detail = detail; this.date = date; this.status = status;
    }

    public String getPromiseId() {
        return this.promiseId;
    }

    public void setPromiseId(String promiseId) {
        this.promiseId = promiseId;
    }

    public String getPoliticianId() {
        return this.politicianId;
    }

    public void setPoliticianId(String politicianId) {
        this.politicianId = politicianId;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}