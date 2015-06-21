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
	private Dispositivo dispositivo_mov;
	private Dispositivo dispositivo_gas;
	private SimpleEntityManager simpleEntityManager;

	static int teste = 280;

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
		int mov;
		Long mq2;

		this.simpleEntityManager = new SimpleEntityManager("enfase");
		this.dispositivo_mov = new Dispositivo();
		this.dispositivo_gas = new Dispositivo();
		dao = new DispositivoDao(simpleEntityManager.getEntityManager());

		mov = Integer.parseInt(request.getParameter("dado1"));
		mq2 = Long.parseLong(request.getParameter("dado2"));

		dispositivo_mov.setNome("Sensor Movimento acionado");
		dispositivo_mov.setValor(mov);

		dispositivo_gas.setNome("Sensor Gas");
		dispositivo_gas.setValor(mq2);

		if (mov == 1) {
			System.out.println(mov);
			try {
				simpleEntityManager.beginTransaction();
				dao.save(this.dispositivo_mov);
				simpleEntityManager.commit();
			} catch (Exception e) {
				e.printStackTrace();
				simpleEntityManager.rollBack();
			}

		} else if (mq2 >= 250) {
			System.out.println(mq2);
			try {
				simpleEntityManager.beginTransaction();
				dao.save(this.dispositivo_gas);
				simpleEntityManager.commit();
			} catch (Exception e) {
				e.printStackTrace();
				simpleEntityManager.rollBack();
			}

		}

		/*
		 * 
		 * try { simpleEntityManager.beginTransaction();
		 * dao.save(this.dispositivo_mov); dao.save(this.dispositivo_gas);
		 * simpleEntityManager.commit(); } catch (Exception e) {
		 * e.printStackTrace(); simpleEntityManager.rollBack(); }
		 */
		//System.out.println(mov);
		//System.out.println(mq2);

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
