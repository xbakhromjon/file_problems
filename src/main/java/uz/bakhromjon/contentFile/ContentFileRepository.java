package uz.bakhromjon.contentFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.base.repository.BaseRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface ContentFileRepository extends JpaRepository<ContentFile, UUID>, BaseRepository {
    @Query(nativeQuery = true, value = "update content_file set is_deleted = true  where id in :IDs")
    @Modifying
    void deleteAll(List<UUID> IDs);

    @Query(nativeQuery = true, value = "delete from missive_base_files where base_files_id in :IDs")
    @Modifying
    void deleteFromRelatedTable(List<UUID> IDs);

    @Query(nativeQuery = true, value = "select * from content_file where id in :IDs")
    List<ContentFile> findByIDs(List<UUID> IDs);

    @Query(nativeQuery = true, value = "select * from content_file where id in (select base_files_id from missive_base_files where missive_id = :ID)")
    List<ContentFile> getAll(UUID ID);
}
