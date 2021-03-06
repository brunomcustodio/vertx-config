package io.vertx.config;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Objects;

/**
 * Data object representing the configuration of a configuration store. This object describes the configuration of a
 * chunk of configuration that you retrieve. It specifies its type (type of configuration store), the format of the
 * retrieved configuration chunk, and you can also configures the store if it needs configuration to
 * retrieve the configuration chunk.
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
@DataObject
public class ConfigStoreOptions {

  private String type;

  private JsonObject config;
  private String format;

  public ConfigStoreOptions() {
    // Empty constructor
  }

  public ConfigStoreOptions(ConfigStoreOptions other) {
    this.type = other.type;
    this.config = other.config == null ? null : other.config.copy();
  }

  public ConfigStoreOptions(JsonObject json) {
    type = json.getString("type");
    config = json.getJsonObject("config");
    format = json.getString("format", "json");
  }


  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    if (type != null) {
      json.put("type", type);
    }
    if (config != null) {
      json.put("config", config);
    }
    if (format != null) {
      json.put("format", format);
    }
    return json;
  }

  /**
   * @return the configuration type, it specified from which store the configuration is coming.
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the configuration type
   *
   * @param type the type
   * @return the current instance of {@link ConfigStoreOptions}
   */
  public ConfigStoreOptions setType(String type) {
    this.type = type;
    return this;
  }

  /**
   * @return the configuration of the store, may be {@code null} if not needed.
   */
  public JsonObject getConfig() {
    return config;
  }

  /**
   * Sets the configuration of the store
   *
   * @param config the data, can be {@code null}
   * @return the current instance of {@link ConfigStoreOptions}
   */
  public ConfigStoreOptions setConfig(JsonObject config) {
    this.config = config;
    return this;
  }


  /**
   * @return the format of the configuration that is retrieved from the store.
   */
  public String getFormat() {
    return format;
  }

  /**
   * Sets the format of the configuration that is retrieved from the store.
   *
   * @param format the format, must not be {@code null}.
   * @return the current instance of {@link ConfigStoreOptions}
   */
  public ConfigStoreOptions setFormat(String format) {
    Objects.requireNonNull(format);
    this.format = format;
    return this;
  }
}
