package com.tarnet.old;

public class MyApplication {
    public static void main(String[] args) {
        String a = "Java";
        String b = new String("Java");
//        System.out.println(Integer.toHexString(a.hashCode()));
//        System.out.println(Integer.toHexString(b.hashCode()));
//        if (a.equals(b)) {
//            System.out.println("a equals b");
//        } else {
//            System.out.println("a not equals b");
//        }
        b = "Java";

        // Immutable
        String[] arr = new String[3];//{"Tarnet", "Tarim", "Teknolojileri"};

        arr[0] = "Tarnet";
        arr[1] = "Tarim";
        arr[2] = "Teknolojileri";

        System.out.println("arr has " + arr.length + " elements");
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);

        for (String s : arr) {
            if (s.equals("Tarim")) {
                break;
            }
            System.out.println(s);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

//        int x = 98;
//        System.out.println(Integer.toHexString(b.hashCode()));
//        String val=new String("Text");
//        if(conditiopn) {
//
//        } else if(another condition){
//
//        }
//        .
//        .
//        .
//        .
//        else{
//
//        }
    }
}
