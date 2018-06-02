package hello.controleur;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hello.model.ContenusRepository;
import hello.model.EcoleRepository;
import hello.model.UtilisateurRepository;
import hello.tables.Contenus;
import hello.tables.Ecole;
import hello.tables.Utilisateur;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/ecole", method = { RequestMethod.POST,
		RequestMethod.GET }) // This means URL's start with /demo (after
								// Application path)
public class EcoleController {
	@Autowired 
	private EcoleRepository ecoleRepository;
	
	@Autowired
	private ContenusRepository contenusRepository;
	

	@RequestMapping("/{ecoleid}/content")
	public @ResponseBody Iterable<Contenus> getEcoleContent(@PathVariable int ecoleid,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Iterable<Contenus> liste = contenusRepository.findByEcoleIdOrderByDateDesc(ecoleid);
		if (liste != null) {
			return liste;

		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"no content found");
			return null;
		}

	}
	
	@RequestMapping("/{ecoleid}/update-infos")
	public @ResponseBody Ecole getEcoleInfos(@PathVariable int ecoleid,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Ecole ecole = ecoleRepository.findById(ecoleid);
		if (ecole != null) {
			return ecole;

		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"Not found");
			return null;
		}

	}


}
