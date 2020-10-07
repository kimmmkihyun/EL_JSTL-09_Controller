package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MUpdateCommand implements MemberCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		//MemberDao dao = new MemberDao(); 클래스생성자가  private이기 때문에
		MemberDao dao = MemberDao.getInstance();
		
		dao.updateData(num,id,passwd,name);
		
	}

}
