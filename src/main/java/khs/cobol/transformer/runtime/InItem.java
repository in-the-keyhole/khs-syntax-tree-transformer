package khs.cobol.transformer.runtime;

/**
 * Used to create an input lambda field of a record implemented as an array of OutItem.
 * A reference to a given element would returnsthe target field value of that record position.
 * Created by mauget on 1/28/17 1:26 PM.
 */
public interface InItem {
    Object get();
}
