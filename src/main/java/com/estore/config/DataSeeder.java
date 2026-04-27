package com.estore.config;

import com.estore.catalog.entity.Category;
import com.estore.catalog.entity.Product;
import com.estore.catalog.repository.CategoryRepository;
import com.estore.catalog.repository.ProductRepository;
import com.estore.customer.entity.Profile;
import com.estore.customer.entity.Role;
import com.estore.customer.entity.User;
import com.estore.customer.repository.UserRepository;
import com.estore.inventory.entity.Inventory;
import com.estore.inventory.repository.InventoryRepository;
import com.estore.shopping.entity.Cart;
import com.estore.shopping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            // Seed Admin
            User admin = new User();
            admin.setEmail("admin@estore.com");
            admin.setPassword(encoder.encode("admin123"));
            Set<Role> roles = new HashSet<>();
            roles.add(Role.ROLE_ADMIN);
            roles.add(Role.ROLE_USER);
            admin.setRoles(roles);

            Profile adminProfile = new Profile();
            adminProfile.setFirstName("Admin");
            adminProfile.setLastName("User");
            adminProfile.setUser(admin);
            admin.setProfile(adminProfile);

            userRepository.save(admin);
            
            Cart adminCart = new Cart();
            adminCart.setUser(admin);
            cartRepository.save(adminCart);

            // Seed Test User
            User user = new User();
            user.setEmail("user@estore.com");
            user.setPassword(encoder.encode("user123"));
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(Role.ROLE_USER);
            user.setRoles(userRoles);

            Profile userProfile = new Profile();
            userProfile.setFirstName("Test");
            userProfile.setLastName("User");
            userProfile.setUser(user);
            user.setProfile(userProfile);

            userRepository.save(user);
            
            Cart userCart = new Cart();
            userCart.setUser(user);
            cartRepository.save(userCart);

            // Seed Categories
            Category electronics = new Category();
            electronics.setName("Electronics");
            electronics.setDescription("Gadgets and devices");
            categoryRepository.save(electronics);

            Category books = new Category();
            books.setName("Books");
            books.setDescription("Various genres of books");
            categoryRepository.save(books);

            // Seed Products
            Product laptop = new Product();
            laptop.setName("Laptop Pro");
            laptop.setDescription("High performance laptop");
            laptop.setPrice(1200.0);
            laptop.setCategory(electronics);
            productRepository.save(laptop);

            Inventory laptopStock = new Inventory();
            laptopStock.setQuantity(10);
            laptopStock.setProduct(laptop);
            inventoryRepository.save(laptopStock);

            Product javaBook = new Product();
            javaBook.setName("Java Programming");
            javaBook.setDescription("Learn Java from scratch");
            javaBook.setPrice(45.0);
            javaBook.setCategory(books);
            productRepository.save(javaBook);

            Inventory javaBookStock = new Inventory();
            javaBookStock.setQuantity(50);
            javaBookStock.setProduct(javaBook);
            inventoryRepository.save(javaBookStock);
        }
    }
}
