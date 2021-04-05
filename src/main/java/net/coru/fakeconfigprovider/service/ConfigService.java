package net.coru.fakeconfigprovider.service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.coru.fakeconfigprovider.entity.Config;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

  private ConcurrentHashMap<String, Config> simpleConfigCache = new ConcurrentHashMap<>();

  public Config createConfig(Map<String, Object> configValue) {
    var config = Config.builder()
        .id(UUID.randomUUID().toString())
        .value(configValue)
        .build();

    simpleConfigCache.put(config.getId(), config);

    return config;
  }

  public Config updateConfig(String id, Map<String, Object> configValue) {
    var config = Config.builder()
        .id(id)
        .value(configValue)
        .build();

    simpleConfigCache.put(config.getId(), config);

    return config;
  }

  public Config deleteConfig(String id) {
    var config = simpleConfigCache.get(id);
    simpleConfigCache.remove(id);
    return config;
  }

  public Config getConfig(String id) {
    return simpleConfigCache.get(id);
  }

}
