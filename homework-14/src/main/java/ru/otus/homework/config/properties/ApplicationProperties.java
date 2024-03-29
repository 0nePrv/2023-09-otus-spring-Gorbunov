package ru.otus.homework.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app", ignoreInvalidFields = true)
public class ApplicationProperties implements ChunkSizePropertyProvider, JobNamePropertyProvider {

  private String jobName = "migrationJob";

  private int chunkSize = 10;
}
