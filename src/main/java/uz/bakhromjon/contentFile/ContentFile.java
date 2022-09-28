package uz.bakhromjon.contentFile;

import lombok.*;
import uz.bakhromjon.base.entity.Auditable;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContentFile extends Auditable {
    private String path;
    private String originalName;
    private String generatedName;
    private Long size;
    private String contentType;
}
