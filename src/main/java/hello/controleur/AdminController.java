//package hello.controleur;
//
//
//
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import hello.model.ContenusRepository;
//import hello.model.AmisRepository;
//import hello.model.LangueRepository;
//import hello.model.LikeRepository;
//import hello.model.UtilisateurRepository;
//import hello.tables.Utilisateur;
//import hello.tables.Contenus;
//import hello.tables.Amis;
//import hello.tables.Langue;
//import hello.tables.Likes;
//
//
//@CrossOrigin(origins="*")
//@Controller    // This means that this class is a Controller
//@RequestMapping(path="/admin",method = { RequestMethod.POST, 	RequestMethod.GET }) // This means URL's start with /demo (after Application path)
//public class AdminController {
//	@Autowired 
//	private UtilisateurRepository userRepository;
//	
//	@Autowired 
//	private ContenusRepository activiteRepository;
//	
//	@Autowired 
//	private LangueRepository langueRepository;
//	
//	
//	
//	@GetMapping(path="/{adminId}/set/role")
//	public @ResponseBody void setRole(
//			@PathVariable int adminId,
//			@RequestParam int userId,
//			@RequestParam String role,
//			HttpServletRequest request,HttpServletResponse response
//			) throws IOException {
//		Utilisateur admin = userRepository.findById(adminId);
//		Utilisateur  user =  userRepository.findById(userId);
//		//TODO vérifier admin
//		if (admin!=null) {
//			if (admin.getRole().equals("Admin") && user!=null) {
//				user.setRole(role);
//				userRepository.save(user);
//				response.sendError(HttpServletResponse.SC_OK, "Done");
//			}else {
//				
//				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//			}
//			
//			
//			
//		}else {
//			
//		
//		response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//		}
//
//		
//	}
//	
//	@RequestMapping("/{adminId}/activite/flagged")
//	public @ResponseBody Iterable<Contenus> getflagged(
//			@PathVariable int adminId,
//			@RequestParam(required=false) Integer nbFlagsMin,
//			HttpServletRequest request,HttpServletResponse response
//			) throws IOException {
//		Utilisateur admin = userRepository.findById(adminId);
//		if (admin!=null) {
//			if (admin.getRole().equals("Admin")) {
//				if (nbFlagsMin==null || nbFlagsMin<0) {
//					nbFlagsMin = 0;
//				}
//				return activiteRepository.findFirst40ByFlagsGreaterThanOrderByFlagsDesc(nbFlagsMin);
//			}else {
//				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//				return null;
//			}
//		}else {
//			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//			return null;
//		}
//
//	}
//	
//	@RequestMapping("/{adminId}/langue/ajouter")
//	public @ResponseBody void addLangue(
//	    @PathVariable int adminId,
//	    @RequestParam String langue,
//	    @RequestParam String data,
//	    HttpServletRequest request,HttpServletResponse response
//	    ) throws IOException{
//	        	Utilisateur admin = userRepository.findById(adminId);
//		if (admin!=null) {
//			if (admin.getRole().equals("Admin")) {
//	        Langue langueCreate = new Langue();
//	        langueCreate.setLangue(langue);
//	        langueCreate.setData(data);
//	        langueRepository.save(langueCreate);
//			}else{
//			    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//			}
//		}else{
//		    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//		}
//	        
//	    }
//	    
//	 @Transactional
//	  @RequestMapping("/{adminId}/langue/supprimer")
//	public @ResponseBody void supprimerLangue(
//	    	@PathVariable int adminId,
//	    @RequestParam int id,
//	    HttpServletRequest request,HttpServletResponse response
//	    ) throws IOException{
//	           	Utilisateur admin = userRepository.findById(adminId);
//		if (admin!=null) {
//			if (admin.getRole().equals("Admin")) {
//	        langueRepository.deleteById(id);
//			}else{
//			    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//			}
//		}else{
//		    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//		}
//	        
//	    }
//	    
//	    	  @RequestMapping("/{adminId}/langue/modifier")
//	public @ResponseBody void ModifierLangue(
//	    	@PathVariable int adminId,
//	   @RequestParam int id,
//	    @RequestParam(required=false) String data,
//	     @RequestParam(required=false) String langue,
//	     HttpServletRequest request,HttpServletResponse response
//	    ) throws IOException{
//	          	Utilisateur admin = userRepository.findById(adminId);
//		if (admin!=null) {
//			if (admin.getRole().equals("Admin")) {
//	        Langue langueModif =  langueRepository.findById(id);
//	        if (langueModif!=null){
//	            if (data!=null && data!=""){
//	                langueModif.setData(data);
//	            }
//	            if (langue!=null && langue!=""){
//	                langueModif.setLangue(langue);
//	            }
//	            langueRepository.save(langueModif);
//	        }else{
//	           response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied langue non trouvé");
//	        }
//			}else{
//			     response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied non trouvé");
//			}
//		}else{
//		     response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied pas admin");
//		}
//	        
//	    }
//	    
//@RequestMapping("/langue/all")
//	public @ResponseBody Iterable<Langue> allLangue(
//
//	    ){
//	        return langueRepository.findAll();
//	        
//	    }
//	    @RequestMapping("/langue/{langueId}/data")
//	public @ResponseBody String getLangueData(
//	   @RequestParam int id,
//	   HttpServletRequest request,HttpServletResponse response
//		
//	    ) throws IOException{
//	        Langue langue = langueRepository.findById(id);
//	        if (langue!=null){
//	             return langue.getData();
//	        }else{
//	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//	            return null;
//	        }
//	       
//	        
//	        
//	    }
//	    
//	
//	@RequestMapping("/{adminId}/activite/{activiteId}/flagged")
//	public @ResponseBody void setflag(
//			@PathVariable int adminId,
//			@PathVariable int activiteId,
//			@RequestParam int nbFlag,
//			HttpServletRequest request,HttpServletResponse response
//			) throws IOException {
//		Utilisateur admin = userRepository.findById(adminId);
//		Contenus activite = activiteRepository.findById(activiteId);
//		if (admin!=null) {
//			if (admin.getRole().equals("Admin") && activite!=null) {
//				activite.setFlags(nbFlag);
//				activiteRepository.save(activite);
//			}else {
//				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//			}
//		}else {
//			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Access Denied");
//		}
//
//	}
//	
//	
////Reccomendation: sélection aléatoirement 1 amis puis aléatoirement 1 de ces amis  x3 ?
//
//	
//}
