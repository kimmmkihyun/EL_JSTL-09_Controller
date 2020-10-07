package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MDeleteCommand implements MemberCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDao dao = MemberDao.getInstance();
		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("MDeleteCommand num : "+num);
		
		dao.deleteData(num); 
		
	}

}
