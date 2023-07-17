import java.util.*;

//String string = "Java";
//        String substring = "va";
//
//        System.out.println(string.contains(substring));


public class MainDz {
    public static void main(String[] args) {

        Set<Netbook> setN = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String[] menu = new String[]{"name","ozu","hardDisk","os","color"};

        Netbook netbook1 = new Netbook("534288","Lenova l5342",4,500,"Windows 8","Черный");
        Netbook netbook2 = new Netbook("534288","Lenova l5342",8,1000,"Windows 8","белый");
        Netbook netbook3 = new Netbook("54f582","Sony",2,500,"Windows 8","Черный");
        Netbook netbook4 = new Netbook("23188","Mac",16,1000,"Mac OS","Желтый");
        Netbook netbook5 = new Netbook("453g2","Acer a432",4,500,"Windows 8","Черный");

        setN.add(netbook1);
        setN.add(netbook2);
        setN.add(netbook3);
        setN.add(netbook4);
        setN.add(netbook5);
        for (Object se:setN) {
            System.out.println(se);
        }
        Boolean flag = true;
        while (flag) {
            System.out.println();
            String menu1 = "Выберите пункты \n" +
                    "1 - Наименование\n" +
                    "2 - ОЗУ\n" +
                    "3 - Обьем ЖД\n" +
                    "4 - ОС\n" +
                    "5 - цвет\n" +
                    "6 - выход";
            System.out.println(menu1);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("6")){
                flag = false;
            }else {
                Map map = new HashMap<>();
                String[] inputArr = input.split(" ");
//                System.out.println(Arrays.toString(inputArr));
                for (int i = 0; i < inputArr.length; i++) {
                    if(inputArr[i].equalsIgnoreCase("2") || inputArr[i].equalsIgnoreCase("3")) {
                        System.out.println("Введите минимальное значение "+ menu[Integer.parseInt(inputArr[i])-1]+ " :");
                        int min = Integer.parseInt(scanner.nextLine());
                        System.out.println("Введите максимальное значение "+ menu[Integer.parseInt(inputArr[i])-1]+ " :");
                        int max = Integer.parseInt(scanner.nextLine());
                        Integer[] range= new Integer[]{min,max};
                        List newRange = new ArrayList<>(Arrays.asList(range));
                        map.put(menu[Integer.parseInt(inputArr[i])-1],newRange);
                    }else {
                        System.out.println("Введите параметр "+ menu[Integer.parseInt(inputArr[i])-1]+ " :");
                        String filtr = scanner.nextLine();
                        map.put(menu[Integer.parseInt(inputArr[i])-1], filtr);
                    }
                }
//                System.out.println(map);
                Set filtr = filtr(setN,map);
                for (Object fi:filtr) {
                    System.out.println(fi);
                }
            }
        }
    }
    static Set filtr(Set<Netbook> netbook, Map benchmark) {
        Set<Netbook> filtrum = new HashSet<>(Comparable);
        System.out.println(benchmark);
        benchmark.forEach((k, v) -> {
            for (Netbook net : netbook) {
                if (k.toString().contains("ozu")) {
                    List rem = (List) v;
                    System.out.println(net.getOzu());
                    if ((net.getOzu() >= (Integer) rem.get(0)) && (net.getOzu() <= (Integer) rem.get(1))) {
                        filtrum.add(net);
                        System.out.println(rem.get(0));
                    }
                }
                if (k.toString().contains("hardDisk"))   {
                    List rem = (List) v;
                    if ((net.hardDisk >= (Integer)rem.get(0)) && (net.hardDisk <= (Integer) rem.get(1))){
                        filtrum.add(net);
                    }
                }
                 else if (net.toString().toLowerCase().contains(v.toString().toLowerCase())){
                    filtrum.add(net);
                }
          }
        });
        return filtrum;
    }

}
