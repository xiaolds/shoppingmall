package com.datasure.login.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.datasure.login.domain.Category;
import com.datasure.login.domain.Product;
import com.datasure.login.service.CategoryService;


/**
 * 
 * @ClassName: ProductAction 
 * @Description: 该类处理所有与商品有关的逻辑，涉及到的表包括Category和Product
 * @date: 2016-6-22 下午02:45:13 
 * @author LiDongSheng
 * @version
 */
public class ProductAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private CategoryService categoryService;
	
	
	public String getContent() throws Exception{
		
		//调用CategoryService
		int grade = 1;	//获取最高等级的商品种类
		

		try{
			List<Category> cList = categoryService.getCategoryByGrade(grade);
			dataMap.put("data", cList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "returnJson";
	}
	

	/*******getter && setter**********/
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	protected String getActionClassFullName() {
		return "com.datasure.login.action.ProductAction";
	}
	
	

}
