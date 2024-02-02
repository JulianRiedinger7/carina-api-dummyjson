import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DummyJsonApiTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Julian")
    public void verifyGetProductByNumberTest() {
        GetProduct getProduct = new GetProduct(2);

        getProduct.callAPIExpectSuccess();
        getProduct.validateResponseAgainstSchema("api/products/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "Julian")
    public void verifyPostProductTest() {
        PostProduct postProduct = new PostProduct();

        postProduct.setProperties("api/products/product.properties");
        Response response = postProduct.callAPIExpectSuccess();
        postProduct.validateResponse();
    }

    @Test
    @MethodOwner(owner = "Julian")
    public void verifyDeleteProductTest() {
        DeleteProduct deleteProduct = new DeleteProduct(1);

        deleteProduct.callAPIExpectSuccess();
        deleteProduct.validateResponseAgainstSchema("api/products/_delete/rs.schema");
    }

    @Test
    @MethodOwner(owner = "Julian")
    public void verifyPutProductTest() {
        PutProduct putProduct = new PutProduct(3);

        putProduct.setProperties("api/products/product.properties");
        putProduct.callAPIExpectSuccess();
        putProduct.validateResponseAgainstSchema("api/products/_put/rs.schema");
    }
}
