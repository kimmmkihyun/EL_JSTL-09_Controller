package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MUpdateFormCommand implements MemberCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		
		MemberDao dao = MemberDao.getInstance();
		MemberBean mb = dao.oneSelect(num);
		
		request.setAttribute("mb", mb);
		
	}

}
