package khs.cobol.transformer.runtime;

/**
 * Created by mauget on 1/22/17 9:54 AM.
 */
public class Display {

    public static void display(String item){
        print( item );
        newLn();
    }

    public static void display(Object[] rec){

        // Array: display this way:
        for (Object item : rec ) {
            print(String.format("%s ", item));
        }
        newLn();
    }

    private static void print( Object item ){
        System.out.print( item );
    }

    private static void newLn( ){
        System.out.println( );
    }
}
