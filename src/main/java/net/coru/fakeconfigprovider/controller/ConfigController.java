package net.coru.fakeconfigprovider.controller;

import java.util.Objects;
import java.util.Optional;
import net.coru.fakeconfigprovider.entity.Config;
import net.coru.fakeconfigprovider.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/configs/")
public class ConfigController {

  @Autowired
  private ConfigService configService;

  @PostMapping
  ResponseEntity<Config> createConfig(@RequestBody Config config) {
    return ResponseEntity.ok(configService.createConfig(config.getValue()));
  }

  @GetMapping("{id}")
  ResponseEntity<Config> getConfigById(@PathVariable String id) {
    return Optional.ofNullable(configService.getConfig(id))
        .map(c -> ResponseEntity.ok(configService.getConfig(id)))
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("{id}")
  ResponseEntity<Config> updateConfig(@PathVariable String id, @RequestBody Config config) {
    return Optional.ofNullable(configService.getConfig(id))
        .map(c -> ResponseEntity.ok(configService.updateConfig(id, config.getValue())))
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("{id}")
  ResponseEntity<Config> deleteConfig(@PathVariable String id) {
    return Optional.ofNullable(configService.getConfig(id))
        .map(c -> ResponseEntity.ok(configService.deleteConfig(id)))
        .orElse(ResponseEntity.notFound().build());
  }
}
