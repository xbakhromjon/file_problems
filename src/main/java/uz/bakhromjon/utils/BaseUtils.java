package uz.bakhromjon.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import uz.bakhromjon.exception.exception.UniversalException;

import java.nio.ByteBuffer;
import java.util.UUID;

@Component
public class BaseUtils {

    public UUID strToUUID(String id) {
        try {
            return UUID.fromString(id);
        } catch (Exception e) {
            throw new UniversalException("%s ID UUID formatda bo'lishi kerak.".formatted(id),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    public Long strToLong(String id) {
        try {
            return Long.parseLong(id);
        } catch (Exception e) {
            throw new UniversalException("%s Long formatda bo'lishi kerak", HttpStatus.BAD_REQUEST);
        }
    }

    public UUID convertBytesToUUID(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        long high = byteBuffer.getLong();
        long low = byteBuffer.getLong();
        return new UUID(high, low);
    }

    public static byte[] convertUUIDToBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

}
