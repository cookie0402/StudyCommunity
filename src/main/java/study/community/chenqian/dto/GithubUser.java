package study.community.chenqian.dto;

public class GithubUser {



    private String name;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}
