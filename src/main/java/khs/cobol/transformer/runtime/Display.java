package khs.cobol.transformer.runtime;

/**
 * Created by mauget on 1/22/17 9:54 AM.
 */
public class Display {

    public static void display(String item){
        print( item );
        newLn();
    }

    public static void display(InItem[] rec) {

        for (InItem item : rec){
            System.out.print( item.get() );
            System.out.print(" ");
        }
        newLn();
    }

    private static void print( Object item){
        System.out.print( item );
    }

    private static void newLn( ){
        System.out.println( );
    }
}
