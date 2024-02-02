import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/products/${productNumber}", methodType = HttpMethodType.DELETE)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteProduct extends AbstractApiMethodV2 {

    public DeleteProduct(int productNumber) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("productNumber", String.valueOf(productNumber));
    }
}
