package edu.prahlad.ds.creational.singleton;

public class RuntimeExample {
    public static void main(String[] args) {
        new RuntimeExample().checkSingletonDS();
    }
    private void checkSingletonDS() {
        Runtime singletonRuntime = Runtime.getRuntime();
        singletonRuntime.gc();
        System.out.println("singletonRuntime: " + singletonRuntime);

        Runtime anotherInstance = Runtime.getRuntime();
        System.out.println("anotherInstance: "+anotherInstance);

        if (singletonRuntime == anotherInstance){
            System.out.println("They are the same instance");
        }
    }


}
