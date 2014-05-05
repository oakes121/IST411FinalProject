 package product;


public class Product {
    
    private String title;
    private String price;
    private String weight;
    private String description;
    private String category;

    public Product(String title, String price, String weight, String description, String category) {
        this.title = title;
        this.price = price;
        this.weight = weight;
        this.description = description;
        
        if (category.equals("1"))
            this.category = "fruit";
        
        if (category.equals("2"))
            this.category = "meat";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

      
    
}
