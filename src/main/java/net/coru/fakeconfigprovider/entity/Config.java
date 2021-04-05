package net.coru.fakeconfigprovider.entity;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Config {

  private String id;
  private Map<String, Object> value;

}
