package Felipe.V2;

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void train() {
        System.out.println(name + " macht allgemeines Training.");
    }
}

class Striker extends Player {
    public Striker(String name) {
        super(name);
    }

    @Override
    public void train() {
        System.out.println(getName() + " trainiert Torschüsse.");
    }

    public void train(int extraShots) {
        System.out.println(getName() + " macht " + extraShots + " Extra Schüsse.");
    }
}

class Goalkeeper extends Player {
    public Goalkeeper(String name) {
        super(name);
    }

    @Override
    public void train() {
        System.out.println(getName() + " trainiert Paraden.");
    }
}

public class TeamTest {
    public static void main(String[] args) {
        Player[] team = new Player[3];
        team[0] = new Striker("Max");
        team[1] = new Goalkeeper("Tom");
        team[2] = new Player("Alex");

        for (Player p : team) {
            p.train();
        }

        Striker s = new Striker("Leo");
        s.train(5);
    }
}
