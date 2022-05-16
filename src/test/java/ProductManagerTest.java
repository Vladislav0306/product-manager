import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(1, "Одна на двоих", 500, "Франческа Кейт");
    Book book2 = new Book(2, "Эксплеты. Лебединая башня", 800, "Ирина Фуллер");
    Smartphone smartphone1 = new Smartphone(3, "Galaxy S21 5G", 60000, "Samsung");
    Smartphone smartphone2 = new Smartphone(4, "P40 Lite", 20000, "Huawei");

    @BeforeEach
    void prepareManager() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldSearch() {
        manager.searchBy("Одна на двоих");
        Product[] expected = { book1 };
        Product[] actual = manager.searchBy("Одна на двоих");
        assertArrayEquals(expected, actual);
    }
}