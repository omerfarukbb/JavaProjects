public class User {
    private final String username;
    private final String password;
    private Vote vote;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public Vote getVote() {
        return vote;
    }

    public String getPassword() {
        return password;
    }
}
