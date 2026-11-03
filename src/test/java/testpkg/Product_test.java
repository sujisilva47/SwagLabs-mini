package testpkg;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporterclass;
import pagepkg.Login_page;
import pagepkg.Product_page;

public class Product_test extends Base_class{
           Login_page log;
           Product_page pdt;
           
           @Test(priority = 1)
           public void logo() throws InterruptedException, IOException
           {
        	   log=new Login_page(driver);
        	   log.setvalues("standard_user", "secret_sauce");
//        	   log.buttontext();
//        	   Thread.sleep(3000);
        	   
        	   test=extent.createTest("logo validation test");
        	   pdt=new Product_page(driver);
        	   WebElement x=pdt.logoverify();
        	   Thread.sleep(3000);
        	   if(x.isDisplayed())
        	   {
        		   test.pass("logo is displayed in product page");
        	   }
        	   else
        	   {
        		   String path=Reporterclass.screenshotMethod(driver, "logo_fail");
        		   test.addScreenCaptureFromPath(path);
        		   test.fail("logo not displayed");
        		   
        	   }
           }
           
          @Test(priority = 2)
          public void additemstocart() throws InterruptedException 
          {
       
              pdt=new Product_page(driver);
              Thread.sleep(5000);
        	  pdt.additems();
        	  Thread.sleep(5000);
        	  List<WebElement> dtl=pdt.pdtdetails();
              Thread.sleep(5000);
              System.out.println("Total Number of Products: " +dtl.size());
                  for(WebElement cartbtn: dtl) {
                       System.out.println(cartbtn.getText());
                
                  }
                  
              Thread.sleep(3000);
              pdt.sortpdt();
              test.pass("Products sorted by Price (low to high)");
              
              Thread.sleep(3000);
              pdt.hamIcon();
              test.pass("Hamburger Menu clicked successfully");
                  
              Thread.sleep(3000);
              pdt.CartIcon();
              test.pass("Navigated to Cart page successfully");
              
              
           }
          
          
    }
