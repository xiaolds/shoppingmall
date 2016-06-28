package com.datasure.login.action;

import java.util.List;
import com.datasure.login.domain.Category;
import com.datasure.login.domain.HomepageRecommend;
import com.datasure.login.service.CategoryService;
import com.datasure.login.service.HomepageRecommendService;


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
	private HomepageRecommendService homepageRecommendService;
	
	/**
	 * 
	 * getContent:(获取商品目录). <br/>
	 * @author LiDongSheng
	 * @return
	 * @throws Exception
	 */
	public String getContent() throws Exception{
		
		String grade = request.getParameter("grade");	
		
		try{
			List<Category> cList = categoryService.
							getCategoryByGrade(Integer.parseInt(grade));
			dataMap.put("data", cList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "returnJson";
	}
	
	/**
	 * 
	 * getHomepageProduct:(获取首页推荐商品,在页面处使用分页处理数据). <br/>
	 * @author LiDongSheng
	 * @return
	 * @throws Exception
	 */
	public String getHomepageProduct() throws Exception {
		
		int page = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("numberPerPage"));
		List<HomepageRecommend> list = 
			homepageRecommendService.getHomepageRecommend(page, pageSize);
		
		//从homepageRecommend中获取prdt
		
		
		return "returnJson";
	}
	
	public String getHomepageProductCount() throws Exception {
		long count = homepageRecommendService.getHomepageRecommendCount();
		dataMap.put("prdtCount", count);
		
		return "returnJson";
	}
	
	/**
	 * 
	 * getCategoryProduct:(获取细分分类下的商品). <br/>
	 * @author LiDongSheng
	 * @return
	 * @throws Exception
	 */
	public String getCategoryProduct() throws Exception {
		//TODO
		
		return "returnJson";
	}
	

	/*******getter && setter**********/
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public void setHomepageRecommendService(
			HomepageRecommendService homepageRecommendService) {
		this.homepageRecommendService = homepageRecommendService;
	}

	@Override
	protected String getActionClassFullName() {
		return "com.datasure.login.action.ProductAction";
	}

	
	
	
	
	

}
