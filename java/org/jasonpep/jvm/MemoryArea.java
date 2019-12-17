package org.jasonpep.jvm;

/**
 * JVM memory area as bellow
 * <p>
 * 1. Heap
 * 2. Stack
 * -  ⅰ. Frame
 * -  ⅱ. Program counter
 * -  ⅲ.
 * 3. Native method area
 * 4. Method area
 */
public class MemoryArea {
    public static void main(String[] args) {
        String a = "a";
        // the "=" before part is reference and other part is constant
        // String Reference "a" is store in 'Heap'
        // The String object store in heap space
        // The "a" string store in compile constant pool, it's symbolic reference ex
        /* $ javap -v XXX
        This is classfile constant pool,
        Constant pool:
                ...
                ...
                #2 = String             #19            // a
                #19 = Utf8               a
                ...
                ...
         */
        // Constant "a" is store in classfile constant pool and when classfile loading to JVM by Classloader
        // it will store in runtime constant pool and the symbolic reference replace to direct address reference
    }
}
