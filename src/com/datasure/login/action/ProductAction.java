package com.datasure.login.action;

import java.util.List;
import com.datasure.login.domain.Category;
import com.datasure.login.domain.HomepageRecommend;
import com.datasure.login.service.CategoryService;
import com.datasure.login.service.HomepageRecommendService;


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
	private HomepageRecommendService homepageRecommendService;
	
	/**
	 * 
	 * getContent:(��ȡ��ƷĿ¼). <br/>
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
	 * getHomepageProduct:(��ȡ��ҳ�Ƽ���Ʒ,��ҳ�洦ʹ�÷�ҳ��������). <br/>
	 * @author LiDongSheng
	 * @return
	 * @throws Exception
	 */
	public String getHomepageProduct() throws Exception {
		
		int page = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("numberPerPage"));
		List<HomepageRecommend> list = 
			homepageRecommendService.getHomepageRecommend(page, pageSize);
		
		//��homepageRecommend�л�ȡprdt
		
		
		return "returnJson";
	}
	
	public String getHomepageProductCount() throws Exception {
		long count = homepageRecommendService.getHomepageRecommendCount();
		dataMap.put("prdtCount", count);
		
		return "returnJson";
	}
	
	/**
	 * 
	 * getCategoryProduct:(��ȡϸ�ַ����µ���Ʒ). <br/>
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
