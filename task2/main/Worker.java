package homework8.task2;

import java.util.Set;

public class Worker {

    private Set<Skills> skills;

    public Worker(Set<Skills> skills) {
        this.skills = skills;
    }

    public Worker() {
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    public String toString() {
        return ("Worker("
                + skills
                + ')').replaceAll("\\[|\\]|\\<|\\>", "");
    }
}

