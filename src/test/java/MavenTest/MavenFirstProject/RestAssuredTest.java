package MavenTest.MavenFirstProject;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredTest {
	String baseURL = "https://jsonplaceholder.typicode.com";
	String endpoint = "/posts";
	String body = "{\n" +
					"\"title\":" + "\"foo\"" + ",\n" +
					"\"body\":" + "\"bar\"" + ",\n" +
					"\"userId\":" + "101" + "\n" +
			"}";
	static Response response = null;
	@Test
	public Response getRequest()
	{    
		try {
			 RestAssured.baseURI = baseURL + endpoint;
			 response = given()
					 	.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return response;
	}
	@Test
	public Response postRequest()
	{   
		System.out.println(body);
		try {
			 RestAssured.baseURI = baseURL + endpoint;
			 response = given()
					 	.contentType(ContentType.JSON)
					 	.body(body)
					 	.post();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return response;
	}
//==========================Test API==============================================
	public static void main( String[] args )
    {
		RestAssuredTest obj = new RestAssuredTest();
		Response output= obj.getRequest();
		String jsonString =response.getBody().asString(); //Convert Jsone response to string
		String title = JsonPath.from(jsonString).get("title[1]");  //Get the title of index 1
		List<String> dataList = response.jsonPath().getList("$"); //save response in list to get its size
		int dataSize = dataList.size(); //Get size of response list

		System.out.println("response Status code: " + output.getStatusCode());
		System.out.println("response: " + jsonString);
		System.out.println("title1: " + title);
		System.out.println("responseSize: " + dataSize);
    }
}
