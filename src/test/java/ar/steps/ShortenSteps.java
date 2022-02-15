package ar.steps;

import api.model.Shorten;
import api.model.ShortenErrorModel;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class ShortenSteps extends PageSteps {

    @Then("^I will get the proper response in Shorten with json '(.*)'$")
    public void iWillGetTheProperResponse(String jsonName) throws IOException {
        Shorten expectedResponse = APIManager.getResponseFromJsonFile(jsonName, Shorten.class);
        Shorten actualResponse = (Shorten) APIManager.getLastResponse().getResponse();

        Assert.assertEquals(actualResponse.getUrl(), expectedResponse.getUrl());
    }
    
    @Then("^I will get the error response in Shorten with json '(.*)'$")
    public void iWillGetTheErrorResponse(String jsonName) throws IOException {
        ShortenErrorModel expectedResponse = APIManager.getResponseFromJsonFile(jsonName, ShortenErrorModel.class);
        ShortenErrorModel actualResponse = (ShortenErrorModel) APIManager.getLastResponse().getResponse();

        Assert.assertEquals(actualResponse.getError(), expectedResponse.getError());
    }
}
