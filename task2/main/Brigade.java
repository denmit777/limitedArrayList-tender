package homework8.task2;

import java.util.List;

public class Brigade extends Worker {

    private List<Worker> workers;
    private int price;

    public Brigade(List<Worker> workers, int price) {
        this.workers = workers;
        this.price = price;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String toString() {
        return ("Brigade{" + workers + ", " + "price: " + price + '}' + "\n")
                .replaceAll("\\[|\\]|\\<|\\>", "");
    }
}

