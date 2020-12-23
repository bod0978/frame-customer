package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Dao.FactDao;
import Model.number;

@Controller
@RequestMapping(value="view")
public class ViewAction {
	
	//登出到前端
	@RequestMapping(value="index" ,method=RequestMethod.GET)
	public ModelAndView indexView(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		session.removeAttribute("NUM");
		
		return new ModelAndView("redirect:/index.html");
	}
	
	//客戶資料新增
	@RequestMapping(value="add" ,method=RequestMethod.GET)
	public ModelAndView addcom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		number num = (number)session.getAttribute("NUM");
		
			return new ModelAndView("redirect:/user/addcom.html");
		
	}
	
	//登入後針對type 轉跳頁面
	@RequestMapping(value="acc" , method=RequestMethod.GET)
	public ModelAndView access (HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		
		number num = (number)session.getAttribute("NUM");
		
		if(num.getType() ==true) {
			
			return new ModelAndView("redirect:/admin/access.html");
		}else {
			return new ModelAndView("redirect:/user/access.html");
		}
	}
	
	//客戶資料查詢結果
	@RequestMapping(value="quiry" , method=RequestMethod.GET)
	public ModelAndView quiry (HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return new ModelAndView("redirect:/user/inquiry.html");
	}
	
	//客戶資料查詢頁面
	@RequestMapping(value="queryall" , method=RequestMethod.GET)
	public ModelAndView queryall(HttpServletRequest request , HttpServletResponse response) throws Exception{
		return new ModelAndView("redirect:/user/queryall.html");
	}
	
	//維護資料新增
	@RequestMapping(value="adddate" , method=RequestMethod.GET)
	public ModelAndView adddate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("/user/adddate");
	}
	
	//*******員工資料管理
	//員工資料選單
	@RequestMapping(value="staffview" , method=RequestMethod.GET)
	public ModelAndView staffview(HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView("/staff/staffall");
	}
	
	//員工資料更新轉跳頁
	@RequestMapping(value="staffalter" , method=RequestMethod.GET)
	public ModelAndView staffalter(HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView("/staff/numalert");
	}
	
	//員工資料更新完成
	@RequestMapping(value="upok" , method=RequestMethod.GET)
	public ModelAndView upok(HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView("redirect:../staff/upok.html");
	}
	
	//員工資料新增
	@RequestMapping(value="addnum" , method=RequestMethod.GET)
	public ModelAndView addnum(HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView ("redirect:../staff/addnum.html");
	}
}
