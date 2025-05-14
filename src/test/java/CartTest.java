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
        homePage.addItemToCart("item1", 15.0);
        homePage.addItemToCart("item2", 40.0);

        String cartContents = cartPage.viewCart();
        assertTrue(cartContents.contains("item1"));
        assertTrue(cartContents.contains("item2"));
    }

    @Test
    public void testCartTotal() {
        homePage.addItemToCart("item1", 15.0);
        homePage.addItemToCart("item2", 40.0);

        double total = cartPage.getCartTotal();
        assertEquals(55.0, total, 0.01);
    }

    @Test
    public void testCartIsEmptyDirectly() {
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    public void testCartEmptyOnStart() {
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testAddAndRemoveItems() {
        homePage.addItemToCart("item1", 10.0);
        homePage.addItemToCart("item2", 20.0);

        String cartContentsBeforeRemoval = cartPage.viewCart();
        assertTrue(cartContentsBeforeRemoval.contains("item1"));
        assertTrue(cartContentsBeforeRemoval.contains("item2"));

        cart.getItems().clear();
        String cartContentsAfterRemoval = cartPage.viewCart();
        assertFalse(cartContentsAfterRemoval.contains("item1"));
        assertFalse(cartContentsAfterRemoval.contains("item2"));
    }
}
