package com.datasure.login.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Controller;

import com.datasure.login.domain.Category;
import com.datasure.login.domain.HomepageRecommend;
import com.datasure.login.domain.Product;
import com.datasure.login.domain.Shopcar;
import com.datasure.login.domain.User;
import com.datasure.login.service.CategoryService;
import com.datasure.login.service.HomepageRecommendService;
import com.datasure.login.service.ProductService;
import com.datasure.login.service.UserService;


/**
 * 
 * @ClassName: ProductAction 
 * @Description: 该类处理所有与商品有关的逻辑，涉及到的表包括Category和Product
 * @date: 2016-6-22 下午02:45:13 
 * @author LiDongSheng
 * @version
 */
@Controller("productAction")
public class ProductAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private CategoryService categoryService;
	private HomepageRecommendService homepageRecommendService;
	private ProductService productService;
	private UserService userService;
	
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
		//将查询出来的Produtid组成数组
		int[] productid = new int[list.size()];
		
		for(int i = 0; i < productid.length; ++i){
			productid[i] = list.get(i).getProductid();
		}
		
		List<Product> prdtList = productService.getProduct(productid);
		dataMap.put("productList", prdtList);
		
		
		return "returnJson";
	}
	
	/**
	 * 
	 * getHomepageProductCount:(获取首页推荐商品数量). <br/>
	 * @author LiDongSheng
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * 
	 * putProductToShopCar:(将商品添加至购物车). <br/>
	 * (通过判断用户是否在线在执行不同的流程，在线则直接持久化到对应用户的购物车中，
	 * 不在线则发送到Cookie中).<br/>
	 * @author LiDongSheng
	 * @return
	 * @throws Exception
	 */
	public String putProductToShopCar() throws Exception {
		
		//获取前台数据
//		String userName = request.getParameter("nickName");
		int productId = Integer.valueOf(request.getParameter("productid"));
		int productNum = Integer.valueOf(request.getParameter("productnum"));
		
		//判断用户在线与否
		boolean isOnline = false;
		
		if(userService.isOnline()){
			isOnline = true;
		}
		
		if(isOnline){
			//用户在线，直接将商品添加到用户的默认购物车中
			User user = userService.getUserFromSession();
			Shopcar shopcar = new Shopcar(user, productId, productNum);
			productService.saveProductToShopcar(shopcar);
		}
		else{
			//用户不在线，将商品保存在Cookie中
			productService.saveProductToCookies(request, response, cookieUtil);
		}
		response.flushBuffer();
		return "returnJson";
	}
	
	//TODO
	static int i = 1;
	public String test() throws Exception {
		
		Cookie c = cookieUtil.createCookie("test", "test" + i++);
		response.addCookie(c);
		
		
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
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected String getActionClassFullName() {
		return "com.datasure.login.action.ProductAction";
	}

	
	
	
	
	

}
