package org.springframework.samples.petclinic;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/cucumber/features"})
public class PetclinicTestRunner extends AbstractTestNGCucumberTests{
}
