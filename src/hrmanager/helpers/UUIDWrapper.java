package hrmanager.helpers;

import java.util.UUID;

/**
 * Created by Dan on 02.12.2014.
 */
public class UUIDWrapper {
    private UUID uuid;
    public UUIDWrapper(){

    }
    public UUIDWrapper(UUID uuid){
        this.uuid = uuid;
    }

    public void setId(String id) {
        if (id == null) {
            uuid = null;
        } else {
            uuid = UUID.fromString(id);
        }
    }

    public String getId() {
        if (uuid == null) return null;
        return uuid.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof UUIDWrapper)) return false;
        UUIDWrapper other = (UUIDWrapper)obj;
        if (uuid == null) return false;
        return uuid.equals(other.uuid);
    }
}
