package Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import TelusPagewiseClass.TelusHomePage;
import TelusUtil.Testbaseclass;
import TelusUtil.WebUtil;

public class TelusRunner extends Testbaseclass {
    @Test
    public void TelusValidation() {
        WebUtil web = new WebUtil();
        TelusHomePage telusObj = new TelusHomePage(util);
        telusObj.closePopup();
        telusObj.clickOnDemandHDR();
        telusObj.clickOnMovies();
        telusObj.getFilterBtn();
        telusObj.clickOnAnimatedOption();
        telusObj.clickOnapplybtn();
        telusObj.click18plus();
        String txt = telusObj.getTxt18plus();
        String[] word = txt.split("\\s+");
        Assert.assertEquals(word[0], "18+");
    }
}
