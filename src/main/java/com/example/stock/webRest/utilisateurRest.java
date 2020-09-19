package com.example.stock.webRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.Bean.utlisateur;
import com.example.stock.Service.Facade.utilisateurService;

@RestController
@CrossOrigin("https://gifted-yalow-41f4d8.netlify.app/")
@RequestMapping("/autoEcole-Api/utilisateur/")
public class utilisateurRest {
@Autowired
private utilisateurService utilisateurService;

@GetMapping("getHashMotDePasse/modPasse/{modPasse}")
public void getHashMotDePasse(@PathVariable String modPasse) {
	utilisateurService.getHashMotDePasse(modPasse);
}
@GetMapping("seConnecter/login/{login}/mdp/{mdp}")
public int seConnecter(@PathVariable String login,@PathVariable String mdp) throws Exception {
	return utilisateurService.seConnecter(login, mdp);
}
@GetMapping("resetPassword/email/{email}/oldPassword/{oldPassword}/nvPassword/{nvPassword}")
public int resetPassword(@PathVariable String email,@PathVariable String oldPassword,@PathVariable String nvPassword) throws Exception {
	return utilisateurService.resetPassword(email,oldPassword, nvPassword);
}
@GetMapping("resetPasswordCodeVerification/email/{email}/nvpassword/{nvpassword}/code/{code}")
public int resetPasswordCodeVerification(String email, String nvpassword, Long code) throws Exception {
	return utilisateurService.resetPasswordCodeVerification(email, nvpassword, code);
}
@GetMapping("findByLogin/login/{login}")
public utlisateur findByLogin(@PathVariable String login) {
	return utilisateurService.findByLogin(login);
}
@PostMapping("save")
public int save(@RequestBody utlisateur heureConduite) {
	return utilisateurService.save(heureConduite);
}
@PostMapping("edit")
public int edit(@RequestBody utlisateur heureConduite) {
	return utilisateurService.edit(heureConduite);
}

public int deleteById(Long id) {
	return utilisateurService.deleteById(id);
}

public utlisateur findById(Long id) {
	return utilisateurService.findById(id);
}


}
