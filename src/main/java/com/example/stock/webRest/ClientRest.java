package com.example.stock.webRest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.stock.Bean.Client;
import com.example.stock.Service.Facade.ClientService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/autoEcole-Api/client/")
public class ClientRest {
@Autowired
private ClientService clientService;

@PostMapping("/save")
public int save(@RequestBody Client client) {
	return clientService.save(client);
}
@PostMapping("/edit")
public int edit(@RequestBody Client client) {
	return clientService.edit(client);
}

public int deleteById(Long id) {
	return clientService.deleteById(id);
}
@GetMapping("findById/{id}")
public Client findById(@PathVariable Long id) {
	return clientService.findById(id);
}
@PostMapping("/uploadFile")
public int storeFile(@RequestParam("file") MultipartFile file) throws Exception {
	return clientService.storeFile(file);
}

public Client findByImageName(String image) {
	return clientService.findByImageName(image);
}

@GetMapping("findAll")
public List<Client> findAll() {
	return clientService.findAll();
}

public Client findByGeneratedcode(String generatedCode) {
	return clientService.findByGeneratedcode(generatedCode);
}

public Client findByNomFR(String nomFR) {
	return clientService.findByNomFR(nomFR);
}

public Client findByPrenomFR(String prenomFR) {
	return clientService.findByPrenomFR(prenomFR);
}

public Client findByPrenomFRAndNomFR(String prenomFR, String nomFR) {
	return clientService.findByPrenomFRAndNomFR(prenomFR, nomFR);
}
@GetMapping("/downloadFile/{fileName}")
public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String fileName,HttpServletResponse response) throws IOException {
    // Load file as Resource
    Client databaseFile = clientService.findByImageName(fileName);
    File convFile = null;
    if(databaseFile != null) {
    		//String fileLocation = "C:/Users/hp/Desktop/PROJET ZOUANI/ormvh-v3-back/";
             convFile = new File(databaseFile.getImageName());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(databaseFile.getImage());
            fos.close();
          
    }
    MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
    InputStreamResource resource = new InputStreamResource(new FileInputStream(convFile));
    
    return ResponseEntity.ok()
            // Content-Disposition
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + convFile.getName())
            // Content-Type
            .contentType(mediaType)
            // Contet-Length
            .contentLength(convFile.length()) //
            .body(resource);
	   }
@Autowired
private ServletContext servletContext;

}