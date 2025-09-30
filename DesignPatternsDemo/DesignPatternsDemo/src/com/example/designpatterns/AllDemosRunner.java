package com.example.designpatterns;
import com.example.designpatterns.behavioral.ObserverDemo;
import com.example.designpatterns.behavioral.StrategyDemo;
import com.example.designpatterns.creational.SingletonDemo;
import com.example.designpatterns.creational.FactoryDemo;
import com.example.designpatterns.structural.AdapterDemo;
import com.example.designpatterns.structural.DecoratorDemo;
public class AllDemosRunner {
    public static void main(String[] args) {
        System.out.println("===== BEHAVIORAL: OBSERVER =====");
        ObserverDemo.main(null);
        System.out.println("\n===== BEHAVIORAL: STRATEGY =====");
        StrategyDemo.main(null);
        System.out.println("\n===== CREATIONAL: SINGLETON =====");
        SingletonDemo.main(null);
        System.out.println("\n===== CREATIONAL: FACTORY =====");
        FactoryDemo.main(null);
        System.out.println("\n===== STRUCTURAL: ADAPTER =====");
        AdapterDemo.main(null);
        System.out.println("\n===== STRUCTURAL: DECORATOR =====");
        DecoratorDemo.main(null);
        System.out.println("\n===== ALL DEMOS FINISHED =====");
    }
}