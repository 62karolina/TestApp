package com.mrc.testapp;
import java.util.Random;
/**
 * Created by Каролина on 16.06.2016.
 */
public class QuestionsTest {

    Random i1 = new Random(20);
    Random i2 = new Random(20);



    public void setI1(Random i1) {
        this.i1 = i1;
    }

    public void setI2(Random i2) {
        this.i2 = i2;
    }

    public Random getI1() {
        return i1;
    }

    public Random getI2() {
        return i2;
    }



}
