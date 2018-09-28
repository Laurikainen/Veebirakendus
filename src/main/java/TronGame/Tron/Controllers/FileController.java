package TronGame.Tron.Controllers;

import TronGame.Tron.Entities.UploadForm;
import TronGame.Tron.Files.UploadFileResponse;
import TronGame.Tron.Services.UploadFormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private UploadFormService uploadFormService;

    @RequestMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        UploadForm dbFile = uploadFormService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @RequestMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @RequestMapping("/downloadFile/{fileId}")
    public ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable String fileId) {
        UploadForm uploadForm = uploadFormService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(uploadForm.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + uploadForm.getFileName() + "\"")
                .body(new ByteArrayResource(uploadForm.getData()));
    }

}
