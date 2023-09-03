package csc1035.project3;
import javax.persistence.*;

@Entity(name = "Items")
/**
 * Represents an item in the stock. All items have an automatically generated, unique id, a name, a category under
 * which they fall, a cost and sell price, their quantity and information regarding if they are perishable.
 */
public class itemsClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "perishable")
    private Boolean perishable;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "sell_price")
    private Double sell_price;

    /**
     * Creates an item without any attributes. Also known as a default constructor.
     */
    public itemsClass() {
    }

    /**
     * Allows setting the items category.
     * @param category The items category.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Allows returning the items perishability.
     * @return Returns the items perishability.
     */
    public Boolean getPerishable() {
        return perishable;
    }

    /**
     * Allows returning the items cost.
     * @return Returns the items cost.
     */
    public Double getCost() {
        return cost;
    }

    /**
     * Allows returning the items sell price.
     * @return Returns the items sell price.
     */
    public Double getSell_price() {
        return sell_price;
    }

    /**
     * Allows returning the items id.
     * @return Returns the items id.
     */
    public int getId() {
        return id;
    }

    /**
     * Allows returning the items quantity.
     * @return Returns the items quantity.
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Allows returning the items category.
     * @return Returns the items category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Allows returning the items name.
     * @return Returns the items name.
     */
    public String getName() {
        return name;
    }

    /**
     * Allows setting the items cost.
     * @param cost The items cost.
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * Allows setting the items name.
     * @param name The items name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Allows setting the items perishability.
     * @param perishable If the item is perishable.
     */
    public void setPerishable(Boolean perishable) {
        this.perishable = perishable;
    }

    /**
     * Allows setting the items sell price.
     * @param sell_price The items sell price.
     */
    public void setSell_price(Double sell_price) {
        this.sell_price = sell_price;
    }

    /**
     * Allows setting the items quantity.
     * @param stock The items quantity.
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Created an instance of an item with a name, category, cost, sell price and quantity.
     * @param name The items name.
     * @param category The category under which the item falls.
     * @param perishable If the item is perishable.
     * @param cost The items cost.
     * @param stock The items quantity.
     * @param sell_price The items sell price.
     */
    public itemsClass(String name, String category, Boolean perishable, Double cost, Integer stock,
                      Double sell_price){
        this.category = category;
        this.cost = cost;
        this.name = name;
        this.perishable = perishable;
        this.stock = stock;
        this.sell_price = sell_price;
    }

}

