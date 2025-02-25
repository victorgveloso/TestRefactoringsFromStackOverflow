import com.google.gson.JsonElement;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
    
    @Test
    public void testProduct() {
        JsonElement asJsonObject = getProductData();
        // Patched assertion usage
        AssertProduct.withProduct(asJsonObject.get("product"))
            .ofName("name")
            .ofType(ProductType.PRODUCT_1.name());
    }
}

class AssertProduct {
    private JsonElement product;

    private AssertProduct(JsonElement product) {
        this.product = product;
    }

    public static AssertProduct withProduct(JsonElement product) {
        return new AssertProduct(product);
    }

    AssertProduct ofName(String name) {
        Assert.assertEquals(name, product.getAsJsonObject().get("name").getAsString());
        return this;
    }

    AssertProduct ofType(String type) {
        Assert.assertEquals(type, product.getAsJsonObject().get("type").getAsString());
        return this;
    }
} 