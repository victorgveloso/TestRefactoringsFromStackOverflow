import com.google.gson.JsonElement;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
    
    @Test
    public void testProduct() {
        JsonElement asJsonObject = getProductData(); // Assume exists in SUT
        JsonElement product = asJsonObject.get("product");
        
        // Original assertion statements
        JsonElement type = product.getAsJsonObject().get("type");
        Assert.assertEquals(ProductType.PRODUCT_1.name(), type.getAsString());
        JsonElement name = product.getAsJsonObject().get("name");
        Assert.assertEquals("name", name.getAsString());
        
        // Attempted assertion usage
        new AssertProduct(asJsonObject.get("product")).assert(type, name);
    }
}

class AssertProduct {
    private JsonElement product;

    AssertProduct(JsonElement product) {
        this.product = product;
    }

    boolean assert(String name, String type) {
        JsonElement typeElement = product.getAsJsonObject().get("type");
        Assert.assertEquals(type, typeElement.getAsString());
        JsonElement nameElement = product.getAsJsonObject().get("name");
        Assert.assertEquals(name, nameElement.getAsString());
        return true;
    }
} 