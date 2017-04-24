package pl.morecraft.dev.stm.dto;

import lombok.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PriviligeObjectDTO {

    private Date createdDate;
    private Date modified_date;

}
