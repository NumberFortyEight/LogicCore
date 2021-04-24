package components.entity;

public class User implements Comparable{
    private String nickname;
    private Integer score;

    public User(String nickname, Integer score) {
        this.nickname = nickname;
        this.score = score;
    }

    public User() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getScore() {
        return score;
    }

    public void sumScore(int points){
        this.score = this.score + points;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" + nickname + ", " + score + '}';
    }

    @Override
    public int compareTo(Object otherUser) {
        User user = (User) otherUser;
        return -(this.score - user.score);
    }
}
