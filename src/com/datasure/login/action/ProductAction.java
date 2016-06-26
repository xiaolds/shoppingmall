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
 * @Description: ���ദ����������Ʒ�йص��߼����漰���ı����Category��Product
 * @date: 2016-6-22 ����02:45:13 
 * @author LiDongSheng
 * @version
 */
public class ProductAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private CategoryService categoryService;
	
	
	public String getContent() throws Exception{
		
		//����CategoryService
		int grade = 1;	//��ȡ��ߵȼ�����Ʒ����
		

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
