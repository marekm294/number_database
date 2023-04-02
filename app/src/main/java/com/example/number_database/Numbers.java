package com.example.number_database;

public class Numbers {
    int zero, one, two, three, four, five, six, seven, eight, nine;
    String Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine;
    public Numbers() {
    }
    public Numbers(int zero, int one, int two, int three, int four, int five, int six, int seven, int eight, int nine) {
        this.zero = zero;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
        this.seven = seven;
        this.eight = eight;
        this.nine = nine;

        this.Zero = Integer.toString(zero);
        this.One = Integer.toString(one);
        this.Two = Integer.toString(two);
        this.Three = Integer.toString(three);
        this.Four = Integer.toString(four);
        this.Five = Integer.toString(five);
        this.Six = Integer.toString(six);
        this.Seven = Integer.toString(seven);
        this.Eight = Integer.toString(eight);
        this.Nine = Integer.toString(nine);

    }

    public int getZero() {
        return zero;
    }
    public int getOne() {
        return one;
    }
    public int getTwo() {
        return two;
    }
    public int getThree() {
        return three;
    }
    public int getFour() {
        return four;
    }
    public int getFive() {
        return five;
    }
    public int getSix() {
        return six;
    }
    public int getSeven() {
        return seven;
    }
    public int getEight() {
        return eight;
    }
    public int getNine() {
        return nine;
    }

    public void setZero(int zero) {
        this.zero = zero;
        this.Zero = Integer.toString(zero);
    }
    public void setOne(int one) {
        this.one = one;
        this.One = Integer.toString(one);
    }
    public void setTwo(int two) {
        this.two = two;
        this.Two = Integer.toString(two);
    }
    public void setThree(int three) {
        this.three = three;
        this.Three = Integer.toString(three);
    }
    public void setFour(int four) {
        this.four = four;
        this.Four = Integer.toString(four);
    }
    public void setFive(int five) {
        this.five = five;
        this.Five = Integer.toString(five);
    }
    public void setSix(int six) {
        this.six = six;
        this.Six = Integer.toString(six);
    }
    public void setSeven(int seven) {
        this.seven = seven;
        this.Seven = Integer.toString(seven);
    }
    public void setEight(int eight) {
        this.eight = eight;
        this.Eight = Integer.toString(eight);
    }
    public void setNine(int nine) {
        this.nine = nine;
        this.Nine = Integer.toString(nine);
    }

    public String getStringZero(){
        return Zero;
    }
    public String getStringOne(){
        return One;
    }
    public String getStringTwo(){
        return Two;
    }
    public String getStringThree(){
        return Three;
    }
    public String getStringFour(){
        return Four;
    }
    public String getStringFive(){
        return Five;
    }
    public String getStringSix(){
        return Six;
    }
    public String getStringSeven(){
        return Seven;
    }
    public String getStringEight(){
        return Eight;
    }
    public String getStringNine(){
        return Nine;
    }

    public void setZero(String zero) {
        this.zero = Integer.parseInt(zero);
        this.Zero = zero;
    }
    public void setOne(String one) {
        this.one = Integer.parseInt(one);
        this.One = one;
    }
    public void setTwo(String two) {
        this.two = Integer.parseInt(two);
        this.Two = two;
    }
    public void setThree(String three) {
        this.three = Integer.parseInt(three);
        this.Three = three;
    }
    public void setFour(String four) {
        this.four = Integer.parseInt(four);
        this.Four = four;
    }
    public void setFive(String five) {
        this.five = Integer.parseInt(five);
        this.Five = five;
    }
    public void setSix(String six) {
        this.six = Integer.parseInt(six);
        this.Six = six;
    }
    public void setSeven(String seven) {
        this.seven = Integer.parseInt(seven);
        this.Seven = seven;
    }
    public void setEight(String eight) {
        this.eight = Integer.parseInt(eight);
        this.Eight = eight;
    }
    public void setNine(String nine) {
        this.nine = Integer.parseInt(nine);
        this.Nine = nine;
    }
}
