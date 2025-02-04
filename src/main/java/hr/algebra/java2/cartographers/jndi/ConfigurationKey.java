package hr.algebra.java2.cartographers.jndi;

import lombok.Getter;

@Getter
public enum ConfigurationKey {
    PLAYER_1_SERVER_PORT("player.one.server.port"),
    PLAYER_2_SERVER_PORT("player.two.server.port"),
    SERVER_HOST_PORT("server.host.port"),
    HOSTNAME("host.name"),
    RMI_PORT("rmi.server.port");

    private final String key;

    ConfigurationKey(final String key) {
        this.key = key;
    }
}
