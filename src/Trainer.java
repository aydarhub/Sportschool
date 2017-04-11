
public class Trainer {
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public KindOfSport getKindOfSport() {
        return kindOfSport;
    }

    public SportsCategory getSportsCategory() {
        return sportsCategory;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    private KindOfSport kindOfSport;
    private SportsCategory sportsCategory;
    private String phone;
    private String address;
}
