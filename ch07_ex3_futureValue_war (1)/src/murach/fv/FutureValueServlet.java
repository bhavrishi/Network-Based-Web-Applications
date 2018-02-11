package murach.fv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import murach.business.Calculation;

@WebServlet("/calculate")
public class FutureValueServlet extends HttpServlet {

	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		// get parameters from the request
		String investmentString = request.getParameter("investment");
		String interestRateString = request.getParameter("interest_rate");
		String yearsString = request.getParameter("years");

		// validate the parameters
		String url;
		String message;
		double investment = 0;
		// session.setAttribute("amount", investment);

		double interestRate = 0;
		int years = 0;
		if (session.isNew()) {
			try {
				System.out.println("In if");
				investment = Double.parseDouble(investmentString);
				interestRate = Double.parseDouble(interestRateString);
				years = Integer.parseInt(yearsString);
				session.setAttribute("investmentAmount", investment);
				session.setAttribute("interestRate", interestRate);
				session.setAttribute("years", years);
				message = "";
				url = "/result.jsp";

			} catch (NumberFormatException e) {
				message = "Please enter a valid number in all three text boxes.";
				url = "/index.jsp";
			}
		} else {

			System.out.println("In else");
			investment = (double) session.getValue("investmentAmount");
			interestRate = (double) session.getValue("interestRate");
			years = (int) session.getValue("years");
			System.out.println(investment + interestRate + years);

			message = "";
			url = "/result.jsp";
		}

		// store data in Calculation object
		Calculation calculation = new Calculation();
		calculation.setMonthlyInvestmentAmount(investment);
		calculation.setYearlyInterestRate(interestRate);
		calculation.setYears(years);

		request.setAttribute("calculation", calculation);
		request.setAttribute("message", message);
		System.out.println("calculation " + calculation.getMonthlyInvestmentAmount() + calculation.getFutureValue()
				+ calculation.getYears());

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}