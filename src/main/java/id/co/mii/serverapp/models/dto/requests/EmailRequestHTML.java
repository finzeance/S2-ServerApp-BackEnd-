package id.co.mii.serverapp.models.dto.requests;

import lombok.Data;

@Data
public class EmailRequestHTML {
    private String to;
    private String subject;
    private String img;
    private String body1;
    private String body2;
    private String body3;
    private String body4;
    private String attach;
    
}
