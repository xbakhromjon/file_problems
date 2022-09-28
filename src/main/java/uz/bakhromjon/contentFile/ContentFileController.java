package uz.bakhromjon.contentFile;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.bakhromjon.base.controller.AbstractController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class ContentFileController extends AbstractController<ContentFileService> {

    public ContentFileController(ContentFileService service) {
        super(service);
    }

    @PostMapping()
    public ResponseEntity<?> upload(@RequestParam String orgId, MultipartHttpServletRequest request) throws IOException {
        return service.upload(orgId, request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable String id) throws IOException {
        return service.view(id);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> download(@PathVariable String id, HttpServletResponse response) throws IOException {
        return service.download(id, response);
    }
}
