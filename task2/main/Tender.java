package homework8.task2;

public class Tender {

    private int quantity;
    private Skills skills;

    public Tender(Skills skills, int quantity) {
        this.skills = skills;
        this.quantity = quantity;
    }

    public Tender() {
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return (skills + "=" + quantity).replaceAll("\\[|\\]|\\<|\\>", "");
    }
}

