package com.evoke.springwebboot.helper;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String upload_Dir = "C:\\Users\\ssingh\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\springrestapi\\src\\main\\resources\\static\\image";

	public boolean uploadFile(MultipartFile multipartfile)
	{
		boolean f = false;
		try {
			// Reading the data
			InputStream stream = multipartfile.getInputStream();
			byte data[] = new byte[stream.available()];
			stream.read(data);

			// writing the data
			FileOutputStream fos = new FileOutputStream(upload_Dir + "//" + multipartfile.getOriginalFilename());
			fos.write(data);
			fos.close();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;

	}

}
