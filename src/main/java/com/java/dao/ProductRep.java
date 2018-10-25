package com.java.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;

import com.java.dto.Product;
//Crud :crud operations
//pagination| sorting
public interface ProductRep extends JpaRepository<Product,Integer>{

	//Name is null: IllegalArgumentException
	//If no data fetched: Optional.Empty()
	public Optional<Product> findOptionalByName(String name, Sort sort);
	
	//EmptyResultDataAccessException| IllegalArgumentException
	@Nullable
	public List<Product> findByCreationdate(@Nullable LocalDateTime date, Pageable pageable);

	//findBy , readBy, queryBy, getBy.., countBy
	public List<Product> findDistinctProductByNameAndActive(String name, byte active);
	
	
	public long countByName(String name);
	
	public int deleteByName(String name);
	
	public int deleteByNameIgnoreCase(String name);
	
	public List<Product> removeByName(String name);
	
	public List<Product> findByCategories_Name(String name);
	
	
	//Top, first
	
	public List<Product> findTop3ByName(String name);
	
	@Async
	public Future<List<Product>> findFirst3ByName(String name);
	
	@Async
	public CompletableFuture<List<Product>> findByName(String name);
	
	/*//select from product  where category.id in (select id from category where name =?)
	@Query(value="from product where category.id in (select id from category where name = :name")	
	public List<Product> findDataUsingCategoryId(@Param("name") String name);
	
	
	@Query("from product where name like ?1 and id in (?2)")
	public List<Product> findProductByName(String name, int... id);
	*/
	
	@Query(nativeQuery=true, value="insert into product (name, id) values (:name, :id)")
	public int insertProduct(@Param("name")String name, @Param("id")int id);
}
