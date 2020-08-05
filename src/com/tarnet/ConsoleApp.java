package com.tarnet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleApp {

//    private final static MenuItem[] appMenuTree = new MenuItem[3];
    private final static List<MenuItem> appMenuTree = new ArrayList<>();// Inferring
    private static BufferedReader consoleReader;
    private static boolean isExited = false;

    public static void main(String[] args) throws IOException {

        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        GenerateAppMenu();
        do {
            System.out.println("0.Exit");
            Run();
            System.out.print("Seciminiz:");
            int selectedMenuItem = Integer.parseInt(consoleReader.readLine());
            if (selectedMenuItem == 0) {
                isExited = true;
            } else {
                System.out.println(appMenuTree.get(selectedMenuItem) + " has been selected.");
            }
        } while (!isExited);

    }

    private static void GenerateAppMenu() {
//        appMenuTree[0] = new MenuItem.Builder().withId(1).withTitle("Personel").withDisplayOrder(1).build();
//        appMenuTree[1] = new MenuItem.Builder().withId(2).withTitle("Satislar").withDisplayOrder(2).build();
//        appMenuTree[2] = new MenuItem.Builder().withId(3).withTitle("Krediler").withDisplayOrder(3).build();

        appMenuTree.add(new MenuItem.Builder().withId(1).withTitle("Personel").withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(11).withTitle("Ekle").withParentId(1).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(12).withTitle("Cikar").withParentId(1).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(13).withTitle("Listele").withParentId(1).withDisplayOrder(1).build());

        appMenuTree.add(new MenuItem.Builder().withId(2).withTitle("Satislar").withDisplayOrder(2).build());
        appMenuTree.add(new MenuItem.Builder().withId(21).withTitle("Ekle").withParentId(2).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(22).withTitle("Cikar").withParentId(2).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(23).withTitle("Listele").withParentId(2).withDisplayOrder(1).build());

        appMenuTree.add(new MenuItem.Builder().withId(3).withTitle("Krediler").withDisplayOrder(3).build());
        appMenuTree.add(new MenuItem.Builder().withId(31).withTitle("Ekle").withParentId(3).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(32).withTitle("Cikar").withParentId(3).withDisplayOrder(1).build());
        appMenuTree.add(new MenuItem.Builder().withId(33).withTitle("Listele").withParentId(3).withDisplayOrder(1).build());
    }

    private static void Run() {
        for (MenuItem menuItem : appMenuTree) {
            System.out.println(menuItem.getDisplayOrder() + "." + menuItem.getTitle());
        }
    }
}
