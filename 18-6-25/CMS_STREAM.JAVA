// You are given a list of Article objects. Each Article has three fields:
// 	int articleID – a unique identifier
// 	String authorName – the name of the article’s author
// 	int wordCount – the number of words in that article

// Task: Write a Java program that:
// 	1. Computes the average word count for each author across all their articles.
// 	2. Determines which author has the highest average word count.
// 	3. Prints the author’s name along with their average word count (formatted to two decimal places).

// 	If there are no articles, the program should print “No data available.”
	
// Expected Output:
// ----------------
// Top author: Alice Smith (avg words: 636.67)

import java.util.*;
import java.util.stream.*;
  
public class RevenuePerProduct {
    // Domain class
    static class Order {
        private final String product;
        private final String region;
        private final int quantity;
        private final double unitPrice;
        //WRITE YOUR HERE
        
        Order(String product, String region, int quantity, double unitPrice)
        {
            this.product=product;
            this.region=region;
            this.quantity=quantity;
            this.unitPrice=unitPrice;
        }
        
        String getProduct()
        {
            return product;
        }
        
        String getRegion()
        {
            return region;
        }
        
        int getQuantity()
        {
            return quantity;
        }
        
        double getUnitPrice()
        {
            return unitPrice;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order("Laptop",   "US",  2, 1200.00),
            new Order("Smartphone","EU",  5,  800.00),
            new Order("Laptop",   "US",  1, 1150.00),
            new Order("Headphones","US", 10,   50.00),
            new Order("Smartphone","US",  3,  820.00)
        );
        
       //WRITE YOUR CODE HERE
       Map<String,Double> mapp=orders.stream().filter(x->x.getRegion().equals("US")).collect(Collectors.groupingBy(x->x.getProduct(),Collectors.summingDouble(x->x.getQuantity()*x.getUnitPrice())));
       TreeMap<String,Double> tm= new TreeMap<>(mapp);
       
       for(Map.Entry<String,Double> ent : tm.entrySet())
       {
           System.out.println(ent.getKey()+" -> $"+String.format("%,.2f",ent.getValue()));
       }
     
       
    }
}