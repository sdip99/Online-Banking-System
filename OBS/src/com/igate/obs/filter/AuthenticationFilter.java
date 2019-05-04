package com.igate.obs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.obs.bean.Login;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {


	String[] userPage={
			"acceptServiceId.jsp",
			"addPayee.jsp",
			"ChangePassword.jsp",
			"ChequeService.jsp",
			"detail.jsp",
			"DetailedInfo.jsp",
			"fundTransferForm.jsp",
			"header_user.jsp",
			"ministatementInfo.jsp",
			"profile.jsp",
			"selectStatementChoice.jsp",
			"Service4.jsp",
			"Service3.jsp",
			"Service2.jsp",
			"settings.jsp",
			"ShowAllTransactionData.jsp",
			"showPayee.jsp",
			"sidebar_user.jsp",
			"user_home.jsp",
			"viewAllOnlineTransaction.jsp",
			
			"changeUserDetials.jsp",
			"saveDetails.html",
			"SaveChangedPassword.html",
			"miniStatement.html",
			"showDetailedStatement.html",
			"addPayee.html",
			"showAllPayee.html",
			"makePayment.html",
			"transferFund.html",
			"viewTransactions.html",
			"ChequeBookRequest.html",
			"SaveChequeDetails.html",
			"displayTracker.html",
			"trackAllServices.html",
			"changeDetails.html",
			"saveDetails.html",
			
		
			
	};
	String[] nofilterPages={
		
			"login.jsp",
			"registration.jsp",
			"forgotpassword.jsp",
			"ObsController",
			"LoginCheck.html",
			"LoginInfo.jsp",
			"SaveLoginDetails.html",
			"Register.html",
			"logout.html",
			"Home.jsp"
			
	};
	String[] adminPages={
			
			"admin_home.jsp",
			"admin_sidebar.jsp",
			"header_admin.jsp",
			"newAccount.jsp",
			"ViewAllTransactions.jsp",
			"ObsController",
			"AddUser.html",
			"ViewAllTransaction.html"
			
			
	};
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = ((HttpServletRequest)request).getRequestURI();
		Login login = null;
		Object obj = session.getAttribute("login_info");
		if(obj !=null){
			login=(Login) obj;
		}
		if(uri.contains("/images")|| uri.contains("/js")|| uri.contains("/lib") || uri.contains("/stylesheet")||uri.contains("/css")||uri.contains("/fonts")||uri.contains("/plugins") || allowAccess(uri,nofilterPages)){
		
		chain.doFilter(request, response);
		return;
		}
		if(login !=null){
			if(login.getUserType().equals("user")){
				if(allowAccess(uri, userPage)){
					chain.doFilter(request, response);
					return;
				}
					
			}
			if(login.getUserType().equals("admin")){
				if(allowAccess(uri, adminPages)){
					chain.doFilter(request, response);
					return;
				}
			}
		}
			resp.sendRedirect("login.jsp");
		
	}

	private boolean allowAccess(String uri, String[] allowed) {
		
		for (String str : allowed) {
			if(uri.contains(str)){
				return true;
			}
			
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
