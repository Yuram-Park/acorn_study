package io.netsong7;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ItemRepository extends MongoRepository<GroceryItem, String>{
	
	@Query("{name:'?0'}") // 0번째 값으로 조회
	GroceryItem findItemByName(String name);
	
	@Query(value="{category:'?0'}", fields = "{'name':1, 'quantity':1}")
	List<GroceryItem> findAll(String category);
	
	public long count();
}
