package khs.cobol.transformer.runtime;

import java.lang.reflect.Field;

/**
 * Created by mauget on 1/22/17 9:54 AM.
 */
public class Display {

    public static void display(String item, Object parent){
        print( item, parent );
        newLn();
    }

    public static void display(String[] rec, Object parent) throws NoSuchFieldException, IllegalAccessException {

        Class<?> klass = parent.getClass();
        // Array: display this way:
        for (String fieldName : rec ) {
            Field field = klass.getDeclaredField(fieldName);
            print(String.format("%s ", (String)field.get(parent)), parent);
        }
        newLn();
    }

    private static void print( Object item, Object parent){
        System.out.print( item );
    }

    private static void newLn( ){
        System.out.println( );
    }
}
