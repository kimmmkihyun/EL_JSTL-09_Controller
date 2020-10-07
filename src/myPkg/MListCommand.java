package myPkg;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MListCommand implements MemberCommand{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberBean> lists = dao.getSelectAll();
		
		request.setAttribute("lists", lists);
		
	}

	
}
