package com.litigiven.step_definitions;

import com.litigiven.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

/*
   In this class we will be able to crate "pre" and "post" condition for ALL the SCENARIOS an even STEPS.
    */
public class Hooks {

    //import the @Before annotation coming from io.cucumber.java

    @Before (order = 1)
    public void setupMethod(){
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");

    }

    /*
      @After will be executed automatically after EVERY scenario in the project.

       */

    @After
    public void tearDownMethod(){

        System.out.println("---> @After: RUNNING AFTER EACH SCENARIO.");
        Driver.closeDriver();
    }

//   // @Before (value = "@db", order = 2)
//    public void login_scenario_before(){
//        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO Order 2");

//    }



    //@BeforeStep
    public void setupStep() {
        //System.out.println("---> @BeforeStep: running before each step!");
    }
   // @AfterStep
    public void teardownStep(){
        //System.out.println("---> @AfterStep: running after each step!");
    }


}
