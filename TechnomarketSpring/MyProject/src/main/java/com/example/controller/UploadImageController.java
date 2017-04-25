package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;


@Controller
@SessionAttributes("filename")
@MultipartConfig
public class UploadImageController {
	
	private String vzemiToqImage;
	private static String sep = File.separator;
	private static final String FILE_LOCATION = "C:"+sep+"Users"+sep+"Ivan"+sep+"Desktop"+sep+"PictureUpload" + sep;
//	private static final String FILE_LOCATION = "C:"+sep+"Users"+sep+"ZARA_"+sep+"Desktop"+sep+"UploadPics" + sep;
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String prepareForUpload() {
//		return "upload";
		return "technomarket_addProduct";
	}
	

	@RequestMapping(value="/image/{fileName}", method=RequestMethod.GET)
	@ResponseBody
	public void prepareForUpload(@PathVariable("fileName") String fileName, HttpServletResponse resp, Model model) throws IOException {
//		File file = new File(FILE_LOCATION + vzemiToqImage);
//		File file = new File(FILE_LOCATION + "1");
		File file = new File(FILE_LOCATION + fileName + ".jpg");
		Files.copy(file.toPath(), resp.getOutputStream());
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String receiveUpload(@RequestParam("failche") MultipartFile multiPartFile, Model model, HttpServletRequest req) throws IOException{
		
//		File fileOnDisk = new File(FILE_LOCATION + multiPartFile.getOriginalFilename());
		String productId = req.getParameter("productId");
		if(multiPartFile.isEmpty() || multiPartFile == null){
			model.addAttribute("messege", "Трябва да посочите файл за качване!");
			return "technomarket_addProduct";
		}
		if(productId == null || productId.isEmpty()){
			model.addAttribute("messege", "Трябва да посочите име на файл!");
			return "technomarket_addProduct";
		}
		File fileOnDisk = new File(FILE_LOCATION + productId + ".jpg");
		Files.copy(multiPartFile.getInputStream(), fileOnDisk.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		vzemiToqImage = multiPartFile.getOriginalFilename();
//		model.addAttribute("filename", multiPartFile.getOriginalFilename());
//		return "technomarket_addProduct";
		model.addAttribute("messege", "Успешно качихте снимка за продукт с номер " + productId);
		vzemiToqImage = productId + ".jpg";
		model.addAttribute("filename", vzemiToqImage);
		return "technomarket_addProduct";
	}
}
