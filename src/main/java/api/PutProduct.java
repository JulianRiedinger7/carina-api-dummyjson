package api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/products/${productNumber}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/products/_put/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutProduct extends AbstractApiMethodV2 {
    public PutProduct(int productNumber) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("productNumber", String.valueOf(productNumber));
    }
}
