package net.runelite.client.config;

import java.lang.reflect.Method;
import java.util.Objects;

public class ConfigKeyPair {

    public final Method left;
    public final Object right;
    private final int hashCode;

    public ConfigKeyPair(Method left, Object right) {
        this.left = left;
        this.right = right;
        this.hashCode = (left == null ? 0 : left.hashCode()) ^ (right == null ? 0 : right.hashCode());
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof ConfigKeyPair)) {
            return false;
        } else {
            ConfigKeyPair other = (ConfigKeyPair) obj;
            return this.left == other.left && this.right == other.right;
        }
    }

    public static ConfigKeyPair of(Method left, Object right) {
        return new ConfigKeyPair(left, right);
    }
}
