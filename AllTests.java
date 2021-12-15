package CompleteTesting;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import salableProductsTesting.*;
import StoreInvtCartTesting.*;

@RunWith(Suite.class)
@SuiteClasses({ ArmorTest.class, HealthTest.class, SalableProductTest.class, WeaponTest.class, StoreFrontTester.class, InventoryTester.class, ShoppingCartTester.class })
public class AllTests {
	
	public static void main(String[]args) {
		
		org.junit.runner.Result result = JUnitCore.runClasses(ArmorTest.class, WeaponTest.class, HealthTest.class, SalableProductTest.class, StoreFrontTester.class, InventoryTester.class, ShoppingCartTester.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println("A JUnit test failed: " + failure.toString());
		}
		
		System.out.println("The JUnit Tests " + (result.wasSuccessful() ? "Passed" : "Failed"));
	}

}
