package br.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.DispositivoDao;
import br.com.dao.SimpleEntityManager;
import br.com.model.Dispositivo;

/**
 * Servlet implementation class RecebeDados
 */
@WebServlet("/RecebeDados")
public class RecebeDados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DispositivoDao dao;
	private Dispositivo dispositivo;
	private Dispositivo dispositivo2;
	private SimpleEntityManager simpleEntityManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecebeDados() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int mov, mq2;
		/*
		this.simpleEntityManager = new SimpleEntityManager("enfase");
		this.dispositivo = new Dispositivo();
		this.dispositivo2 = new Dispositivo();
		dao = new DispositivoDao(simpleEntityManager.getEntityManager());
		*/
		
		mov = Integer.parseInt(request.getParameter("dado1"));
		mq2 = Integer.parseInt(request.getParameter("dado2"));
		
		/*
		dispositivo.setNome("Sensor Movimento");
		dispositivo.setValor(mov);
		
		dispositivo2.setNome("Sensor Gas");
		dispositivo2.setValor(mq2);
		try {
			simpleEntityManager.beginTransaction();
			dao.save(this.dispositivo);
			dao.save(this.dispositivo2);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
		*/
		System.out.println(mov);
		System.out.println(mq2);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
