package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import to.Envoltorio;

@Controller
public class HolaMundoController {
	@RequestMapping("/holaMundo")
	public @ResponseBody String holaMundo() {
		return "Hola mundo";
	}
	
	@RequestMapping("/holaMundo1")
	public @ResponseBody String holaMundo1(@RequestParam String nombre) {
		return "Hola: " + nombre;
	}

	@RequestMapping("/holaMundo2")
	public @ResponseBody String holaMundo2(HttpServletRequest req) {
		return "Hola: " + req.getParameter("nombre");
	}

	@RequestMapping("/holaMundo3")
	public void holaMundo3(HttpServletRequest req,
			HttpServletResponse res) throws IOException {
		
		String nombre = req.getParameter("nombre");
		PrintWriter pw = res.getWriter();
		pw.println("Hola: " + nombre);
		pw.flush();
	}

	@RequestMapping("/holaMundo4")
	public @ResponseBody String holaMundo4(Envoltorio env) {
		return "Hola: " + env.getNombre();
	}

	@RequestMapping("/holaMundo5")
	public String holaMundo5(@RequestParam String nombre, Model model) {
		model.addAttribute("nombre", nombre);
		return "/holaMundo.jsp";
	}

	@RequestMapping("/holaMundo6")
	public ModelAndView holaMundo6(@RequestParam String nombre) {
		return new ModelAndView("/holaMundo.jsp", "nombre", nombre);
	}

	@RequestMapping("/holaMundo7")
	public void holaMundo6(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("nombre", req.getParameter("nombre"));
		req.getRequestDispatcher("/holaMundo.jsp").forward(req, res);
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	public String getMensaje() {
		return "Spring WebFlow";
	}
}










