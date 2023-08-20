# JavaProject
Online Departmental Store Opening:
Problem Statement:
Princy is a young girl with the passion to open her own department store. She has bought all the products required to the store. She has to go digital and store all her products in her website. Categorizing the product are done. Now help her go ahead for the next step, by creating the user accessing her products.
Note: Use project 1 as boiler plate code.
#Check List:
•	As an store owner, Princy needs to login in her website using username and password
•	Validate the credentials and allow to access the options.
•	Every item is a product. Use ((buyingprice*0.5)+buyingprice)to calculate the sellingPrice.
•	Options are (for admin) 
1.	List the products in the store (productid, product Name, category, Quantity, price )
2.	Search the product by using productid
3.	List the products by category (Grocery, Stationary, Toiletry, Vegetables)
4.	Search the product by using the name and view the details of the product.
5.	To check the total amount, spend on her products.
6.	Display the Profit amount that she gets on category wise. 
•	Options for Customer
1.	Existing customer can login and view the products from the store.
2.	Allow new customer to register and login to view the products  
3.	Provide 100 super coins for the new user as a welcome bonus.
4.	Provide filter options based on category and price for the customer
	If customer use filter for price, display products with price low to high
	If customer use filter for category, allow user to select the category and display the product from the specific category.
#Instructions:
o	Product Should be class with attributes
1.	productid
2.	productName
3.	sellingPrice
4.	availableQuantity
o	Create a class for User with attributes
1.	username
2.	emailId
3.	password
4.	superCoins
o	Create a class for Item with attributes
1.	Itemname
2.	Category
3.	buyingPrice
o	Create product, user, item as a pojo.
o	Convert all the arrays into list for storing user details.
o	Use Map to store the product details.
o	Create StoreInformation class to define all the functionalities related methods. 
o	Create custom exception for handling the improper inputs
o	Display menu options until user wants to exit from the application.
o	Create a separate thread for different users.
o	Use java 8 features in the applicaton.
Note: Registration should be allowed for customers only, admin registration should be restricted.
![image](https://github.com/fahimny36/JavaProject/assets/81046522/70f5d642-c70c-469e-8ecc-4f4b6a963ea5)
