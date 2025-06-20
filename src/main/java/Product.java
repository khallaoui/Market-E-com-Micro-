import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Génère tous les getters
@Setter // Génère tous les setters
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
public class Product {
    private String id;
    private String name;
    private String category;
    private double price;
    private double rating;
}