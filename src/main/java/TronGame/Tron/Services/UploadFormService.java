package TronGame.Tron.Services;

import TronGame.Tron.Entities.UploadForm;
import TronGame.Tron.Exceptions.FileStorageException;
import TronGame.Tron.Exceptions.MyFileNotFoundException;
import TronGame.Tron.Repositories.UploadFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadFormService {
    @Autowired
    private UploadFormRepository uploadFormRepository;

    public UploadForm storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            UploadForm uploadForm = new UploadForm(fileName, file.getContentType(), file.getBytes());

            return uploadFormRepository.save(uploadForm);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public UploadForm getFile(String fileId) {
        return uploadFormRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
