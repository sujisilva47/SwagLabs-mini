package testpkg;

import org.testng.annotations.Test;

import basepkg.Base_class;
import pagepkg.Checkout_page;
import pagepkg.Login_page;
import pagepkg.Product_page;

public class Checkout_test {
	public class checkout_test  extends Base_class{
		@Test
	    public void verifyCheckoutProcess() throws InterruptedException {
	        Login_page log = new Login_page(driver);
	        Product_page pdt = new Product_page(driver);
	        Checkout_page ckout = new Checkout_page(driver);
	        
	        test = extent.createTest("Checkout Process Test");
	        
	       
	        log.setvalues("standard_user", "secret_sauce");
	        log.buttontext();
	        Thread.sleep(2000);
	        
	       
	        pdt.additems();
	        Thread.sleep(2000);
	        

	        ckout.clickCart();
	        Thread.sleep(2000);
	        
	       
	        ckout.clickcheckOut();
	        Thread.sleep(2000);
	        
	       
	        ckout.setDetails("suji", "jobin", "695501");
	        Thread.sleep(2000);
	        
	       
	        ckout.clickFinish();
	        Thread.sleep(2000);
	   
	        ckout.clickHamburgerMenu();
	        Thread.sleep(2000);
	        
	       
	        ckout.clickLogout();
	        Thread.sleep(2000);
	        
	        test.pass("Checkout process completed successfully");
	    }
	
    }
	
}
