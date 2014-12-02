package hrmanager.helpers;

import java.util.UUID;

/**
 * Created by Dan on 02.12.2014.
 */
public class UUIDWrapper {
    private UUID uuid;
    public UUIDWrapper(){
        uuid = UUID.randomUUID();
    }

    public UUIDWrapper(UUID uuid){
        this.uuid = uuid;
    }

    public void setId(String id) {
        if (id == null) return;
        uuid = UUID.fromString(id);
    }

    public String getId() {
        return uuid.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof UUIDWrapper)) return false;
        UUIDWrapper other = (UUIDWrapper)obj;
        return uuid.equals(other.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid.toString();
    }
}
