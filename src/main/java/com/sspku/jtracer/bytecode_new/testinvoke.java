package com.sspku.jtracer.bytecode_new;


interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() {
       System.currentTimeMillis();
    }
}

class Cat implements Animal {
    public void speak() {
        System.nanoTime();
    }
}

public class testinvoke {
    public static void main(String[] args) {
        Animal a = new Dog();  
        Cat b = new Cat();
        Dog c = new Dog(); // Interface reference
        a.speak();    
        b.speak();
        c.speak();          // ← invokeinterface
    }
}
