/**
 * 
 */
package net.ruhama.project.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.ruhama.project.model.Category;
import net.ruhama.project.service.ICategoriesService;
import net.ruhama.project.util.CategoryStatus;

/**
 * @author MaJiD
 *
 */
@SpringBootTest
public class CategoryServiceUnitsTest {

	@Autowired
	private ICategoriesService categoryService;
//	
//	@Test
//	public void addCategoryUnitTest() {
//		Category category = new Category();
//		category.setName_ar("تبرع مسجد");
//		category.setName("building");
//		category.setType("Test building");
//		category.setType_ar("اختبار اخر");
//		category.setMax_budget(200000d);
//		category.setDescription("This is just to describe the application.");
//		category.setStatus(CategoryStatus.ACTIVE);
//		Category savedCategory = categoryService.addCategory(category);
//		if(savedCategory != null)
//			System.out.println(savedCategory);
//	}
//	
//	@Test
//	public void activateCategoryUnitTest() {
//		Category category = categoryService.getAllActiveCategories().get(0);
//		Category activateCategory = categoryService.activateCategory(category);
//		if(activateCategory != null)
//			System.out.println(activateCategory);
//	}
//	
//	@Test
//	public void deactivateCategoryUnitTest() {
//		Category category = categoryService.getAllActiveCategories().get(0);
//		Category unActivateCategory = categoryService.deactivateCategory(category);
//		if(unActivateCategory != null)
//			System.out.println(unActivateCategory);
//	}
//	
//	@Test
//	public void getCategoryByIdUnitTest() {
//		Category category = categoryService.getCategoryById(1);
//		if(category != null)
//			System.out.println(category);
//	}
//	
//	@Test
//	public void getAllCategoriesUnitTest() {
//		for(Category category : categoryService.getAllCategories()) {
//			if(category != null)
//				System.out.println(category);
//		}
//	}
//	
//	@Test
//	public void getAllActiveCategoriesUnitTest() {
//		for(Category category : categoryService.getAllActiveCategories()) {
//			if(category != null)
//				System.out.println(category);
//		}
//	}
//	
//	@Test
//	public void getAllNotActiveCategoriesUnitTest() {
//		for(Category category : categoryService.getAllNotActiveCategories()) {
//			if(category != null)
//				System.out.println(category);
//		}
//	}
//	
//	@Test
//	public void updateCategoryUnitTest() {
//		Category category = categoryService.getCategoryById(1);
//		category.setMax_budget(150000d);
//		Category updatedCategory = categoryService.updateCategory(category);
//		if(updatedCategory != null)
//			System.out.println(updatedCategory);
//	}
//	
//	@Test
//	public void updateCategoriesUnitTest() {
//		List<Category> categoriesList = new ArrayList<Category>();
//		
//		Category category1 = new Category();
//		category1.setName_ar("تبرع كفالة");
//		category1.setName("help");
//		category1.setType("Test helping");
//		category1.setType_ar("اختبار جديد");
//		category1.setMax_budget(400000d);
//		category1.setDescription("This is just to describe the application.");
//		category1.setStatus(CategoryStatus.ACTIVE);
//		categoriesList.add(category1);
//		
//		Category category2 = new Category();
//		category2.setName_ar("تبرع عادي");
//		category2.setName("Normal");
//		category2.setType("Test Normal");
//		category2.setType_ar("اختبار اجد");
//		category2.setMax_budget(300000d);
//		category2.setDescription("This is just to describe the application.");
//		category2.setStatus(CategoryStatus.ACTIVE);
//		categoriesList.add(category2);
//		
//		List<Category> savedList = categoryService.updateCategories(categoriesList);
//		
//		for(Category cate : savedList) {
//			if(cate != null)
//				System.out.println(cate);
//		}
//	}
	
}
