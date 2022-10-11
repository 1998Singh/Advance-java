package com.evoke.springwebboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.evoke.springwebboot.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{

		System.out.println("File Name =" + file.getOriginalFilename());
		System.out.println("File size in byte = " + file.getSize());
		System.out.println("File Content Type = " + file.getContentType());
		System.out.println("File Name = " + file.getName());

		// validation
		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must cantain File");
		}

		if (!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG");

		}

		// file upload code
		
		boolean f = fileUploadHelper.uploadFile(file);
		if (f) {
			return ResponseEntity.ok("File Uploaded");
		}

		return ResponseEntity.ok("Working");
	}

}
