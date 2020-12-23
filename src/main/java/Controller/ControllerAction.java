package Controller;

import java.io.PrintWriter;
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
import Model.FactModel;
import Model.companytable;
import Model.handle;
import Model.number;

@Controller
@RequestMapping(value="Con")
public class ControllerAction {
	
	ApplicationContext acd = Dao.implDao.acd;
	ApplicationContext acm = Dao.implDao.acm;
	
	//登入驗證
	@RequestMapping(value="login" ,method=RequestMethod.POST)
	public ModelAndView loginView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String User = request.getParameter("user");
		String Pass = request.getParameter("password");
		
		
		FactDao fd = acd.getBean("fbd",FactDao.class);
		
		List l = (List)fd.getNumD().loginCheck(User, Pass);
		
		if(l.size() != 0 ) {
			Object o[] = l.toArray();
			number num = (number)o[0];
			
			if(num.getType() == true) {
				session.setAttribute("NUM", num);
				return new ModelAndView("redirect:/admin/access.html");
			
			}else {
				session.setAttribute("NUM", num);
				return new ModelAndView("redirect:/user/access.html");
			}
		}else {
			return new ModelAndView("redirect:/index.html");
		}
		
	}
	
	//新增客戶
	@RequestMapping(value="addcom" , method=RequestMethod.POST)
	public ModelAndView addcom(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String Onlyday = request.getParameter("onlyday");
		String Its = request.getParameter("its");
		String Company = request.getParameter("company");
		String Number = request.getParameter("number");
		String Tel = request.getParameter("tel");
		String Undertake = request.getParameter("undertake");
		String Phone = request.getParameter("phone");
		String Addr = request.getParameter("addr");
		String Ps = request.getParameter("ps");
		
		FactModel fbm = acm.getBean("fbm", FactModel.class); 
		fbm.getCompM().setOnlyday(java.sql.Date.valueOf(Onlyday));
		fbm.getCompM().setIts(Its);
		fbm.getCompM().setCompany(Company);
		fbm.getCompM().setNumber(Number);
		fbm.getCompM().setTel(Tel);
		fbm.getCompM().setUndertake(Undertake);
		fbm.getCompM().setPhone(Phone);
		fbm.getCompM().setAddr(Addr);
		fbm.getCompM().setPs(Ps);
		
		FactDao fbd = acd.getBean("fbd", FactDao.class);
		fbd.getCompD().add(fbm.getCompM());
		
		return new ModelAndView("redirect:/user/addcomok.html");
	}
	
	//維護紀錄查詢  針對  電話  統一編號
	@RequestMapping(value="inquiry" ,method=RequestMethod.POST)
	public ModelAndView inquiry (HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		String Tel = request.getParameter("tel");
		String Number = request.getParameter("number");
		
		FactDao fbd = acd.getBean("fbd", FactDao.class);
		companytable comp = null;
		List l = null;
		
		try {
			if(Tel != null && Tel !="") {
				l = fbd.getCompD().queryTel(Tel);
				Object o[] = l.toArray();
				comp = (companytable)o[0];
	
			}else {
				l = fbd.getCompD().queryNumber(Number);
				Object o[] = l.toArray();
				comp = (companytable)o[0];
			}
			session.setAttribute("COMP", comp);
			return new ModelAndView("/user/inquiry");
			
		}catch(ArrayIndexOutOfBoundsException e) {
			return new ModelAndView("redirect:/view/quiry");
		}
	}
	
	//客戶資料搜尋結果
	@RequestMapping(value="query" , method=RequestMethod.POST)
	public ModelAndView query (HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		String Tel = request.getParameter("tel");
		String Number = request.getParameter("number");
		
		FactDao fbd = acd.getBean("fbd", FactDao.class);
		companytable comp ;
		handle hand = new handle() ;
		
		try {
			if(Tel !="" && Tel !=null) {
				List l = fbd.getCompD().queryTel(Tel);
				Object o[] = l.toArray();
				comp = (companytable)o[0];
				
				System.out.println(comp.getCompany()+";"+comp.getNumber());
				
				hand.setCompany(comp.getCompany());
				hand.setNumber(comp.getNumber());
				
				session.setAttribute("HAND", hand);
				
				return new ModelAndView("/user/queryall");
					
			}
			if(Number !="" && Number !=null) {
				List l = fbd.getCompD().queryNumber(Number);
				Object o[] = l.toArray();
				comp = (companytable)o[0];
				
				System.out.println(comp.getCompany()+";"+comp.getNumber());
				
				hand.setCompany(comp.getCompany());
				hand.setNumber(comp.getNumber());
				
				session.setAttribute("HAND", hand);
				
				return new ModelAndView("/user/queryall");
			}
				
			return new ModelAndView("redirect:/view/queryall");
		}catch(ArrayIndexOutOfBoundsException e) {
			
			return new ModelAndView("redirect:/view/queryall");
		}	
	}
	
	//新增客戶維護紀錄
	@RequestMapping(value="adddate" , method=RequestMethod.POST)
	public ModelAndView adddate (HttpServletRequest request , HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		handle ha = (handle) session.getAttribute("HAND");
		
		String Undertake = request.getParameter("undertake"); 
		String Sort = request.getParameter("sort"); 
		String Noticedate = request.getParameter("noticedate"); 
		String Servicedate = request.getParameter("servicedate"); 
		String Centent = request.getParameter("centent"); 
		String Exp = request.getParameter("explain"); 
		
		FactDao fbd = acd.getBean("fbd", FactDao.class);
		FactModel fbm = acm.getBean("fbm", FactModel.class);
		
		fbm.gethandM().setCompany(ha.getCompany());
		fbm.gethandM().setNumber(ha.getNumber());
		fbm.gethandM().setTel(ha.getTel());
		fbm.gethandM().setUndertake(Undertake);
		fbm.gethandM().setSort(Sort);
		fbm.gethandM().setNoticedate(java.sql.Date.valueOf(Noticedate));
		fbm.gethandM().setServicedate(java.sql.Date.valueOf(Servicedate));
		fbm.gethandM().setCentent(Centent);
		fbm.gethandM().setExp(Exp);
		
		fbd.getHandD().add(fbm.gethandM());
		
		session.removeAttribute("HAND");
		return new ModelAndView("redirect:/user/addcomok.html");
	}
	
	//員工資料刪除
	@RequestMapping(value="numdelete" ,method=RequestMethod.GET)
	public ModelAndView numdelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int Id = Integer.parseInt( request.getParameter("id") );

		FactDao fbd = acd.getBean("fbd", FactDao.class);
		fbd.getNumD().delete(Id);
		System.out.println("CON"+Id);
		return new ModelAndView("redirect:../view/staffview");
	}
	
	//員工資料進資料庫撈出
	@RequestMapping(value="alter" ,method=RequestMethod.GET)
	public ModelAndView alter(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		int Id = Integer.parseInt(request.getParameter("id"));
		
		FactDao fbd = acd.getBean("fbd", FactDao.class);
		
		List l = fbd.getNumD().numalter(Id);
		Object o[] = l.toArray();
		number num = (number)o[0];
		
		session.setAttribute("alter", num);
		
		return new ModelAndView("redirect:../view/staffalter");
	}
	
	//員工資料更新進入資料庫
	@RequestMapping(value="numup" ,method=RequestMethod.POST)
	public ModelAndView numupdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		number n1 = (number)session.getAttribute("alter");
		request.setCharacterEncoding("utf-8");
		
		String Name = request.getParameter("name");
		String User = request.getParameter("user");
		String Pass = request.getParameter("password");
		String Phone = request.getParameter("phone");
		String Body = request.getParameter("body");
		String Type = request.getParameter("type");
		
		FactModel fbm = acm.getBean("fbm", FactModel.class);
		fbm.getNumM().setId(n1.getId());
		
		fbm.getNumM().setName(Name);
		fbm.getNumM().setUser(User);
		fbm.getNumM().setPassword(Pass);
		fbm.getNumM().setPhone(Phone);
		fbm.getNumM().setBody(java.sql.Date.valueOf(Body));
		
		Boolean bl = false;
		if(Type.equals("1")) {
			bl = true;
		}
		fbm.getNumM().setType(bl);
		
		FactDao fbd = acd.getBean("fbd", FactDao.class );
		
		fbd.getNumD().update(fbm.getNumM());
		
		session.removeAttribute("alter");
 		return new ModelAndView("redirect:../staff/upok.html");
		
	}
	
	//新增員工資料
	@RequestMapping(value="addok" ,method=RequestMethod.POST)
	public ModelAndView addok(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		
		String User = request.getParameter("user");
		String Name = request.getParameter("name");
		String Pass = request.getParameter("password");
		String Phone = request.getParameter("phone");
		String Body = request.getParameter("body");
		
		FactModel fbm = acm.getBean("fbm", FactModel.class);
		
		fbm.getNumM().setUser(User);
		fbm.getNumM().setName(Name);
		fbm.getNumM().setPassword(Pass);
		fbm.getNumM().setPhone(Phone);
		fbm.getNumM().setBody(java.sql.Date.valueOf(Body));
		fbm.getNumM().setType(false);
		
		FactDao fbd = acd.getBean("fbd", FactDao.class);
		
		fbd.getNumD().add(fbm.getNumM());
		
		return new ModelAndView("redirect:../staff/upok.html"); 
	}
}
