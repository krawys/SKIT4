import com.example.Cart;
import com.example.pages.HomePage;
import com.example.pages.CartPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {

    private HomePage homePage;
    private CartPage cartPage;
    private Cart cart;

    @Before
    public void setUp() {
        cart = new Cart();
        homePage = new HomePage(cart);
        cartPage = new CartPage(cart);
    }

    @Test
    public void testAddItemToCart() {
        homePage.addItemToCart("item1", 10.0);
        homePage.addItemToCart("item2", 20.0);

        String cartContents = cartPage.viewCart();
        assertTrue(cartContents.contains("item1"));
        assertTrue(cartContents.contains("item2"));
    }

    @Test
    public void testCartTotal() {
        homePage.addItemToCart("item1", 10.0);
        homePage.addItemToCart("item2", 20.0);

        double total = cartPage.getCartTotal();
        assertEquals(30.0, total, 0.01); // Total should be 10 + 20
    }

    @Test
    public void testCartIsEmptyDirectly() {
        assertTrue(cart.getItems().isEmpty()); // Check cart directly
    }

    @Test
    public void testCartEmptyOnStart() {
        assertTrue(cart.isEmpty()); // or however you check if the cart is empty
    }

    @Test
    public void testAddAndRemoveItems() {
        homePage.addItemToCart("item1", 10.0);
        homePage.addItemToCart("item2", 20.0);

        String cartContentsBeforeRemoval = cartPage.viewCart();
        assertTrue(cartContentsBeforeRemoval.contains("item1"));
        assertTrue(cartContentsBeforeRemoval.contains("item2"));

        cart.getItems().clear(); // Simulate removing all items (simple approach for this test)
        String cartContentsAfterRemoval = cartPage.viewCart();
        assertFalse(cartContentsAfterRemoval.contains("item1"));
        assertFalse(cartContentsAfterRemoval.contains("item2"));
    }
}
