package khs.cobol.transformer.runtime;

/**
 * Used to create an output field lambda of a record implemented as an array of OutItem.
 * Assigning a value to a given element would assign to the target field of that record position.
 * Created by mauget on 1/28/17 1:26 PM.
 */
public interface OutItem {
    void put(Object s);
}
