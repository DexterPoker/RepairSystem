package cn.edu.zucc.repair.model;


public class UsersBean {
    private int userId;
    private String userName;
    private String password;
    private String level;
    private String status;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersBean usersBean = (UsersBean) o;

        if (userId != usersBean.userId) return false;
        if (level != null ? !level.equals(usersBean.level) : usersBean.level != null) return false;
        if (password != null ? !password.equals(usersBean.password) : usersBean.password != null) return false;
        if (status != null ? !status.equals(usersBean.status) : usersBean.status != null) return false;
        if (userName != null ? !userName.equals(usersBean.userName) : usersBean.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
