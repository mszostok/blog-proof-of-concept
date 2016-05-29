package com.mszostok.controller;

import com.mszostok.model.ErrorInfo;
import com.mszostok.model.UploadResponse;
import com.mszostok.util.CustomConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.util.UUID;

/**
 * Upload controller which allow upload only images (BMP, GIF, JPG and PNG ).
 *
 * @author mszostok
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    private static final Logger LOGGER = LogManager.getLogger(UploadController.class);

    public static final String UPLOAD_LOCATION = System.getenv("UPLOAD_LOCATION");


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {

        try (InputStream input = file.getInputStream()) {

            LOGGER.info("Received file: {}", file.getOriginalFilename());
            String filename = UUID.randomUUID().toString() + ".jpg";

            LOGGER.info("Check if uploaded file is a image.");
            ImageIO.read(input);

            String directoryDateSuffix = CustomConverter.getPathFromYearMonth.apply(YearMonth.now());
            Path directoryName = Paths.get(UPLOAD_LOCATION + directoryDateSuffix);
            String filepath = Paths.get(directoryName.toString(), filename).toString();

            if (!Files.exists(directoryName)) {
                LOGGER.info("Create directories : {}", directoryName);
                Files.createDirectories(directoryName);
            }

            LOGGER.info("Save the file locally: {}", filepath);
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            FileCopyUtils.copy(file.getInputStream(), stream);

            stream.close();

            UploadResponse response =
                    new UploadResponse("File successfully uploaded.", directoryDateSuffix + filename);

            LOGGER.info("Send response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (IOException ex) {
            LOGGER.error("Error occurred while uploading file", ex.getMessage());
            ErrorInfo response = new ErrorInfo(null, "File not uploaded (check your file type)");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
