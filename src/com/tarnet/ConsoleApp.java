package com.tarnet;

import com.tarnet.entity.Department;
import com.tarnet.entity.Inventory;
import com.tarnet.entity.Personel;
import com.tarnet.managers.EntityManager;
import lombok.val;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConsoleApp {

    //    private final static MenuItem[] appMenuTree = new MenuItem[3];
    private final static List<MenuItem> appMenuTree = new ArrayList<>();// Inferring LinkedList
    private static List<Personel> personels = new ArrayList<>();
    private static List<Department> departments = new ArrayList<>();
    private static EntityManager<Personel> personelEntityManager = new EntityManager<>(personels);
    private static EntityManager<Department> departmentEntityManager = new EntityManager<>(departments);
    private static BufferedReader consoleReader;
    private static boolean isExited = false;

    public static void main(String[] args) throws IOException {
//        Supplier<String> s = () -> "Hello world!";
//        System.out.println(s.get());

//        Function<String, Boolean> f = (String keyword) -> keyword.equals("Gani");
//        System.out.println(f.apply("Gani"));
        GenerateStaticData();
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        GenerateAppMenu();
        do {
            Run(-1);
        } while (!isExited);
    }

    private static void GenerateAppMenu() {
//        appMenuTree[0] = new MenuItem.Builder().withId(1).withTitle("Personel").withDisplayOrder(1).build();
//        appMenuTree[1] = new MenuItem.Builder().withId(2).withTitle("Envanter").withDisplayOrder(2).build();
//        appMenuTree[2] = new MenuItem.Builder().withId(3).withTitle("Departmanlar").withDisplayOrder(3).build();

        appMenuTree.add(new MenuItem.Builder()
                .withId(1)
                .withTitle("Personel")
                .withParentId(-1)
                .withDisplayOrder(1)
                .build());

        appMenuTree.add(new MenuItem.Builder<List<Personel>>()
                .withId(11)
                .withTitle("Find By Id")
                .withParentId(1)
                .withDisplayOrder(1)
                .withIdParamAction(personelEntityManager.findById)
                .build());
        appMenuTree.add(new MenuItem.Builder()
                .withId(12)
                .withTitle("Search For Keyword")
                .withParentId(1)
                .withDisplayOrder(2)
                .withStringParamAction(personelEntityManager.findByKeyword)
                .build());
        appMenuTree.add(new MenuItem.Builder<List<Personel>>()
                .withId(13)
                .withTitle("Listele")
                .withParentId(1)
                .withDisplayOrder(3)
                .withAction(personelEntityManager.findAll)
                .build());
//----------------------------------------------------------------------------------------------------------------------------
        appMenuTree.add(new MenuItem.Builder().withId(2).withTitle("Departmanlar").withParentId(-1).withDisplayOrder(3).build());

        appMenuTree.add(new MenuItem.Builder().withId(21).withTitle("Find By Id").withParentId(2).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(22).withTitle("Search For Keyword").withParentId(2).withDisplayOrder(2).build());
        appMenuTree.add(new MenuItem.Builder().withId(23).withTitle("Listele").withParentId(2).withDisplayOrder(3).build());
//----------------------------------------------------------------------------------------------------------------------------
        appMenuTree.add(new MenuItem.Builder().withId(3).withTitle("Envanter").withParentId(-1).withDisplayOrder(2).build());

        appMenuTree.add(new MenuItem.Builder().withId(31).withTitle("Find By Id").withParentId(3).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(32).withTitle("Search For Keyword").withParentId(3).withDisplayOrder(2).build());
        appMenuTree.add(new MenuItem.Builder().withId(33).withTitle("Listele").withParentId(3).withDisplayOrder(3).build());
    }

    private static void GenerateStaticData() {
        personels.add(new Personel(1, "Mehmet Gani", "Tombalak", "Dev", new Department(1, "IT")));
        personels.add(new Personel(2, "Burcu", "Durmusoglu", "Senior Dev", new Department(1, "IT")));
        personels.add(new Personel(3, "Mehmet Emin", "Cakir", "Senior Dev", new Department(1, "IT")));
        personels.add(new Personel(4, "Ersin", "Kilic", "Architect", new Department(1, "IT")));
        personels.add(new Personel(5, "Faik Aykut", "Acer", "Dev Manager", new Department(1, "IT")));

        departments.add(new Department(1, "IT"));
        departments.add(new Department(2, "HR"));
        departments.add(new Department(3, "Marketing"));
        departments.add(new Department(4, "SM"));
        departments.add(new Department(4, "Support"));

    }

    private static void Run(int parentId) throws IOException {
        System.out.println(parentId == -1 ? "0. Exit" : "0.Back"); // TERNARY OPERATOR
        long startTime = System.currentTimeMillis();
//        for (MenuItem menuItem : appMenuTree) {
//            if (menuItem.getParentId() == parentId)
//                System.out.println(menuItem);
//        }
//        long endTime = System.currentTimeMillis() - startTime;
//        System.out.printf("For Menu has been generated in %s ms.\n",endTime);
        //FUNCTIONAL INTERFACE
//        startTime = System.currentTimeMillis();
        appMenuTree
                .stream()
                .filter(menuItem -> menuItem.getParentId() == parentId)
                .sorted(Comparator.comparingInt(MenuItem::getDisplayOrder)) //METHOD REFERENCE OPERATOR
                .forEach(System.out::println);
//                .forEach(m -> System.out.println(m.getDisplayOrder() + "." + m.getTitle()));
//                endTime = System.currentTimeMillis() - startTime;
//        System.out.printf("Stream Menu has been generated in %s ms.\n",endTime);
        System.out.print("Seciminiz:");
        int selectedMenuItem = Integer.parseInt(consoleReader.readLine());
        if (selectedMenuItem == 0 && parentId == -1) {
            isExited = true;
        } else {
            if (selectedMenuItem == 0) return;
            else if (selectedMenuItem != 0 && parentId != -1) {
                appMenuTree
                        .stream()
                        .filter(m -> m.getId() == selectedMenuItem)
                        .findFirst()
                        .ifPresent(menuItem -> {
                            if (menuItem.getAction() != null) {
                                ((List<?>) menuItem.getAction().get()).forEach(System.out::println);
                            } else if (menuItem.getStringParamAction() != null) {
                                System.out.print("Please enter keyword:");
                                try {
                                    String keyword = consoleReader.readLine();
                                    ((List<?>)menuItem.getStringParamAction().apply(keyword)).forEach(System.out::println);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else if (menuItem.getIdParamAction() != null) {
                                System.out.print("Please enter Id:");
                                try {
                                    int selectedId = Integer.parseInt(consoleReader.readLine());
                                    ((List<?>)menuItem.getIdParamAction().apply(selectedId)).forEach(System.out::println);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
            Run(selectedMenuItem);
        }
    }
}
