package edu.eci.arep.logic.Services;


import edu.eci.arep.logic.Model.LinkedList;

/**
 * Calculator class that calculates the mean and the standard deviation
 * @author Johan Sebastián Arias
 */
public class Calculator {

    /**
     * Calculates the mean given a LinkedList of numbers
     * @param list LinkedList containing the nodes with the values
     * @return a quantity that represents the mean
     */
    public double calcMean(LinkedList<Double> list){
        double suma = 0;
        for (double element : list){
            suma += element;
        }
        return (double)Math.round(suma/list.getSize() *100d)/100d;

    }

    /**
     * Calculates the standard deviation given a LinkedList of numbers
     * @param list LinkedList containing the nodes with the values
     * @return  a quantity that represents the standard deviation
     */
    public double calcSum(LinkedList<Double> list){
        double numerador = 0;
        for (double i : list){
            numerador += i;
        }
        return numerador;
    }
}
