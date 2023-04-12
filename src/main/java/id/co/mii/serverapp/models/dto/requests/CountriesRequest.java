package id.co.mii.serverapp.models.dto.requests;

import lombok.Data;

@Data
public class CountriesRequest {
    private String code;
    private String name;
    private Integer region_id;
}
