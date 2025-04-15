package ch05.sec13;

public enum Grade {
    A(95, "최우수"),
    B(85, "우수"),
    C(75, "보통"),
    D(65, "미흡"),
    F(0, "불합격");

    private final int score;
    private final String description;

    Grade(int score, String description) {
        this.score = score;
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

}
