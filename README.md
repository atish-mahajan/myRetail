# Case Study: myRetail RESTful service

## Tech Stack

<ol>
	<li>Java 1.8</li>
	<li>SpringBoot</li>
	<li>MongoDB</li>
	<li>Maven</li>
	<li>Mockito</li>
</ol>


### Instructions for setup and running the solution locally:
1. Download the zip file that contains the solution and extract to a folder
2. Import the project from extracted folder using an IDE like Eclipse or IntelliJ
3. Download and install MongoDB. By default it will run at localhost:27017 and I have kept it that way
4. To insert the data I have created a POST endpoint at http://localhost:8080/v1/products. Here's an example of JSON body
```json
{
  "id": 16483589,
  "name": "Table Lamp",
  "current_price": {
    "value": 250.00,
    "currency_code": "USD"
  }
}
```
5. To run the application go to the project folder at ~\Target\myretailrestapi\myretailrestapi
 Run the command -> mvn spring-boot:run

6. There are some test cases created in ~\Target\myretailrestapi\myretailrestapi\src\test\java\com\target\myretailrestapi folder
Test cases can be executed using mvn test command

7. List of different endpoints:


- GET at v1/products/13860428 to get a product details

	```
	GET /v1/products/13860428 HTTP/1.1
	Host: localhost:8080
	Cache-Control: no-cache
	Postman-Token: a267ce64-a716-0a70-7e37-5629361d9223
	```
	
- PUT at /v1/products/13860428 to update a product

	```
	PUT /v1/products/13860428 HTTP/1.1
	Host: localhost:8080
	Content-Type: application/json
	Cache-Control: no-cache
	Postman-Token: 3894fde3-afb7-6a38-e94e-638471339383

	{
		"id": "13860428",
		"name": "The Big Lebowski (Blu-ray) (Widescreen)",
		  "current_price": {
    		"value": 50.00,
    		"currency_code": "USD"
    		}
    }
	```


- POST at /v1/products to create a new product
	
	```
	POST /v1/products HTTP/1.1
	Host: localhost:8080
	Content-Type: application/json
	Cache-Control: no-cache
	Postman-Token: c4985844-71b7-15f1-1e6c-dd061cea4c74

	{
	"id": 13860428,
	"name": "The Big Lebowski (Blu-ray) (Widescreen)",
	"current_price": {
	    "value": 13.49,
	    "currency_code": "USD"
	 }
	}
  		
	```


Scope for future implementation 

1. I haven't specifically implemented authentication for this exercise but have a stub code and framework ready for JWT token based authentication
2. Add custom exception handling
3. Although the current scope didn't require it some interfaces and abstract methods can be implemented to follow design guidelines
