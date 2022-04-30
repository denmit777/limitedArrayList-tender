package homework8.task2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Tender> tender = Arrays.asList(new Tender(Skills.CRANE_OPERATOR, 1),
                new Tender(Skills.CARPENTER, 1), new Tender(Skills.MASON, 1),
                new Tender(Skills.FITTER, 2), new Tender(Skills.ELECTRIC, 2),
                new Tender(Skills.PAINTER, 1));

        //1.POSITIVE CASE

        Set<Skills> skills1 = new HashSet<>();
        skills1.add(Skills.FITTER);
        skills1.add(Skills.CRANE_OPERATOR);
        Worker worker1 = new Worker(skills1);

        Set<Skills> skills2 = new HashSet<>();
        skills2.add(Skills.MASON);
        skills2.add(Skills.ELECTRIC);
        Worker worker2 = new Worker(skills2);

        Set<Skills> skills3 = new HashSet<>();
        skills3.add(Skills.FITTER);
        skills3.add(Skills.ELECTRIC);
        Worker worker3 = new Worker(skills3);

        Set<Skills> skills4 = new HashSet<>();
        skills4.add(Skills.PAINTER);
        Worker worker4 = new Worker(skills4);

        Set<Skills> skills5 = new HashSet<>();
        skills5.add(Skills.CARPENTER);
        Worker worker5 = new Worker(skills5);

        Set<Skills> skills6 = new HashSet<>();
        skills6.add(Skills.CARPENTER);
        Worker worker6 = new Worker(skills6);

        Set<Skills> skills7 = new HashSet<>();
        skills7.add(Skills.MASON);
        Worker worker7 = new Worker(skills7);

        Set<Skills> skills8 = new HashSet<>();
        skills8.add(Skills.FITTER);
        skills8.add(Skills.ELECTRIC);
        Worker worker8 = new Worker(skills8);

        Set<Skills> skills9 = new HashSet<>();
        skills9.add(Skills.PAINTER);
        skills9.add(Skills.CRANE_OPERATOR);
        Worker worker9 = new Worker(skills9);

        Set<Skills> skills10 = new HashSet<>();
        skills10.add(Skills.FITTER);
        skills10.add(Skills.ELECTRIC);
        Worker worker10 = new Worker(skills10);

        List<Worker> brigade1 = Arrays.asList(worker1, worker2, worker3, worker4, worker5);
        List<Worker> brigade2 = Arrays.asList(worker6, worker7, worker8, worker9, worker10);
        List<Worker> brigade3 = Arrays.asList(worker1, worker2, worker4, worker9, worker10);

        List<Brigade> brigades = Arrays.asList(new Brigade(brigade1, 190000),
                new Brigade(brigade2, 170000),
                new Brigade(brigade3, 140000));

        BrigadeChoice bc = new BrigadeChoice();

        System.out.println(tender);
        System.out.println(brigades);
        System.out.println(bc.convertTenderToMap(tender)); //{CRANE_OPERATOR=1, MASON=1, CARPENTER=1, PAINTER=1, ELECTRIC=2, FITTER=2}
        System.out.println(bc.convertWorkerToMap(brigade1)); //{CRANE_OPERATOR=1, CARPENTER=1, MASON=1, FITTER=2, ELECTRIC=2, PAINTER=1}
        System.out.println(bc.convertWorkerToMap(brigade2)); //{CRANE_OPERATOR=1, CARPENTER=1, MASON=1, FITTER=2, ELECTRIC=2, PAINTER=1}
        System.out.println(bc.convertWorkerToMap(brigade3)); //{CRANE_OPERATOR=2, ELECTRIC=2, FITTER=2, MASON=1, PAINTER=2}
        System.out.println(bc.equalsBrigadeWithTender(tender, brigade1)); //true
        System.out.println(bc.equalsBrigadeWithTender(tender, brigade2)); //true
        System.out.println(bc.equalsBrigadeWithTender(tender, brigade3)); //false
        try {
            System.out.println(bc.choiceBrigade(tender, brigades)); //brigade2
        } catch (UnsuitableArgumentException e) {
            e.printStackTrace();
        }
        System.out.println();

        //2.NEGATIVE CASE

        List<Worker> brigade4 = Arrays.asList(worker2, worker4, worker7, worker8);
        List<Worker> brigade5 = Arrays.asList(worker1, worker5, worker9, worker10);

        List<Brigade> brigades2 = Arrays.asList(new Brigade(brigade4, 150000),
                new Brigade(brigade5, 160000));

        BrigadeChoice bc2 = new BrigadeChoice();

        System.out.println(tender);
        System.out.println(brigades2);
        System.out.println(bc2.convertTenderToMap(tender)); //{CRANE_OPERATOR=1, MASON=1, CARPENTER=1, PAINTER=1, ELECTRIC=2, FITTER=2}
        System.out.println(bc2.convertWorkerToMap(brigade4)); //{ELECTRIC=2, FITTER=1, MASON=2, PAINTER=1}
        System.out.println(bc2.convertWorkerToMap(brigade5)); //{CARPENTER=1, CRANE_OPERATOR=2, ELECTRIC=1, FITTER=2, PAINTER=1}
        System.out.println(bc2.equalsBrigadeWithTender(tender, brigade4)); //false
        System.out.println(bc2.equalsBrigadeWithTender(tender, brigade5)); //false
        try {
            System.out.println(bc.choiceBrigade(tender, brigades2)); //UnsuitableArgumentException: There isn't a suitable brigade
        } catch (UnsuitableArgumentException e) {
            e.printStackTrace();
        }
    }
}
