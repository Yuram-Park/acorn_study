package io.netsong7;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroceryItem {

        @Id
        private String id;

        private String name;
        private int quantity;
        private String category;
        
}
