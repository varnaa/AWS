package org.varnaa.APIGateway;

import com.amazonaws.services.apigateway.AmazonApiGateway;
import com.amazonaws.services.apigateway.AmazonApiGatewayClientBuilder;
import com.amazonaws.services.apigateway.model.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author swethavarnaa
 */
public class APIGateway {
    private static final AmazonApiGateway apiGatewayClient = AmazonApiGatewayClientBuilder.defaultClient();
    private static final String songsId = "e796e2";
    private static String apiId = "92rygu9obi";
    private static String parentId = "c1pksxk3fc";

    public static void main(String[] args) {

        createRestApi();
        getParentId();
        createApiResource("songs");
        createMethod("GET", songsId);
        createIntegration("GET", songsId);
        createMethodResponse("GET", songsId);
        createIntegrationResponse("GET", songsId, "songs");


    }

    private static void createRestApi() {
        // Generate a api request object
        CreateRestApiRequest restApiRequest = new CreateRestApiRequest();
        restApiRequest.setName("myapi");
        restApiRequest.setDescription("Collection of varnaa's api");
        restApiRequest.setEndpointConfiguration(new EndpointConfiguration().withTypes("REGIONAL"));


        // Save the new api request result
        CreateRestApiResult restApiResult = apiGatewayClient.createRestApi(restApiRequest);
        apiId = restApiResult.getId();
        System.out.println(apiId);
        System.out.println("Api Name: " + restApiResult.getName() + " Description: " + restApiResult.getDescription());

    }

    private static void getParentId() {
        GetResourcesRequest resourceRequest = new GetResourcesRequest();
        resourceRequest.setRestApiId(apiId);

        GetResourcesResult resourceResult = apiGatewayClient.getResources(resourceRequest);
        List<Resource> resourceList = resourceResult.getItems();

        for (Resource resource : resourceList) {
            if (resource.getPath().equals("/")) {
                parentId = resource.getParentId();
                System.out.println("Caught the root: " + resource.getId());
                break;
            }
        }
    }

    private static void createApiResource(String path) {
        CreateResourceRequest resourceRequest = new CreateResourceRequest();
        resourceRequest.setRestApiId(apiId);
        resourceRequest.setParentId(parentId);
        resourceRequest.setPathPart(path);
        String resourceId = apiGatewayClient.createResource(resourceRequest).getId();
        System.out.println(resourceId);
    }


    private static void createMethod(String methodType, String resourceId) {
        PutMethodRequest methodRequest = new PutMethodRequest();
        methodRequest.setHttpMethod(methodType);
        methodRequest.setResourceId(resourceId);
        methodRequest.setRestApiId(apiId);
        methodRequest.setAuthorizationType("NONE");

        if (methodType.contentEquals("GET")) {
            Map<String, Boolean> requestParams = new HashMap<>();

            /*
            A key defines a method request parameter name matching the pattern of method.request.{location}.{name},
            where location is querystring, path, or header and name is a valid and unique parameter name.
            The value associated with the key is a Boolean flag indicating whether the parameter is required ( true)
             or optional (false).
             */

            requestParams.put("method.request.querystring.product_id", false);
            requestParams.put("method.request.header.test", false);
            methodRequest.setRequestParameters(requestParams);
        } else {
            Map<String, Boolean> requestParams = new HashMap<>();
            methodRequest.setRequestParameters(requestParams);
        }

        PutMethodResult methodResult = apiGatewayClient.putMethod(methodRequest);
        System.out.println(methodResult.toString());
    }

    public static void updateMethod(String methodType, String resourceId) {
        /*
        https://docs.aws.amazon.com/apigateway/api-reference/link-relation/method-update/
         */
        UpdateMethodRequest updateMethodRequest = new UpdateMethodRequest();
        updateMethodRequest.setRestApiId(apiId);
        updateMethodRequest.setResourceId(resourceId);
        updateMethodRequest.setHttpMethod(methodType);

        PatchOperation patchOperation = new PatchOperation();
        patchOperation.setOp("remove");
        patchOperation.setPath("/requestParameters/method.request.header.test");
        //  patchOperation.setValue("false");

        updateMethodRequest.setPatchOperations(Arrays.asList(patchOperation));
        UpdateMethodResult result = apiGatewayClient.updateMethod(updateMethodRequest);
        System.out.println(result.toString());

    }

    public static void createIntegration(String methodType, String resourceId) {
        PutIntegrationRequest integrationRequest = new PutIntegrationRequest();
        integrationRequest.setResourceId(resourceId);
        integrationRequest.setRestApiId(apiId);
        integrationRequest.setHttpMethod(methodType);
        integrationRequest.setType("MOCK");

        Map<String, String> templates = new HashMap<>();
        templates.put("application/json", "{'Hello World!!'}");
        integrationRequest.setRequestTemplates(templates);

        PutIntegrationResult integrationResult = apiGatewayClient.putIntegration(integrationRequest);
        System.out.println(integrationResult.toString());

    }


    public static void createMethodResponse(String methodType, String resourceId) {
        PutMethodResponseRequest request = new PutMethodResponseRequest();
        request.setRestApiId(apiId);
        request.setResourceId(resourceId);
        request.setHttpMethod(methodType);
        request.setStatusCode("200");


        Map<String, Boolean> parameters = new HashMap<>();
        parameters.put("method.response.header.Access-Control-Allow-Headers", false);
        parameters.put("method.response.header.Access-Control-Allow-Origin", false);
        parameters.put("method.response.header.Access-Control-Allow-Methods", false);
        request.setResponseParameters(parameters);

        Map<String, String> models = new HashMap<>();
        models.put("application/json", "Empty");
        request.setResponseModels(models);

        PutMethodResponseResult result = apiGatewayClient.putMethodResponse(request);
        System.out.println(result.toString());

    }


    public static void createIntegrationResponse(String methodType, String resourceId, String resourceName) {
        PutIntegrationResponseRequest responseRequest = new PutIntegrationResponseRequest();
        responseRequest.setRestApiId(apiId);
        responseRequest.setResourceId(resourceId);
        responseRequest.setHttpMethod(methodType);
        responseRequest.setStatusCode("200");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("method.response.header.Access-Control-Allow-Headers", "'Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token'");
        parameters.put("method.response.header.Access-Control-Allow-Methods", "'" + resourceName + "'");
        parameters.put("method.response.header.Access-Control-Allow-Origin", "'*'");
        responseRequest.setResponseParameters(parameters);


        Map<String, String> templates = new HashMap<>();
        templates.put("application/json", "{'Name':'Elastic Heart', 'Artist Name' : 'Sia', 'Type':'Pop'}");

        responseRequest.setResponseTemplates(templates);
        PutIntegrationResponseResult responseResult = apiGatewayClient.putIntegrationResponse(responseRequest);
        System.out.println(responseResult.toString());


    }


}
