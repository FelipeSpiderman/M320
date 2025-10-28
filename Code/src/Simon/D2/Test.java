package Simon.D2;

public class Test {
    private final int points;
    private final int totalPoints;

    public Test(int points, int totalPoints) {
        this.points = points;
        this.totalPoints = totalPoints;
    }

    public float calculateGrade() {
        return (float) points * 5 / totalPoints + 1;
    }
}
