package com.practice.java;

import java.util.concurrent.Callable;

interface Bird {
    Egg lay();
}

class Chicken implements Bird {
    public Chicken() {
    }
    public Egg lay() throws ClassCastException{
        
			Chicken chicken = new Chicken();
			return (Egg)chicken;
		
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof Bird);
    }
}

class Egg extends Chicken {
    public Egg(Callable<Bird> createBird) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public Bird hatch() throws Exception {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }
}