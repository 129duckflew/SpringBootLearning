package cn.duckflew.entity;

public class SpjKey {
    private String sno;

    private String pno;

    private String jno;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno == null ? null : pno.trim();
    }

    public String getJno() {
        return jno;
    }

    public void setJno(String jno) {
        this.jno = jno == null ? null : jno.trim();
    }
}