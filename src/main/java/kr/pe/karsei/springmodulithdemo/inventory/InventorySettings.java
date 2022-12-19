package kr.pe.karsei.springmodulithdemo.inventory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@RequiredArgsConstructor(access = AccessLevel.PACKAGE, onConstructor = @__(@ConstructorBinding))
@ConfigurationProperties("example.inventory")
class InventorySettings {
    int stockThreshold;
}