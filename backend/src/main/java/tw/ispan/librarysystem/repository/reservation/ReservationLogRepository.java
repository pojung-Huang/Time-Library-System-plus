// 預約清單 Repository，提供 reservation_logs 資料表的存取方法
package tw.ispan.librarysystem.repository.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.ispan.librarysystem.entity.reservation.ReservationLogEntity;

import java.util.List;

@Repository
public interface ReservationLogRepository extends JpaRepository<ReservationLogEntity, Long> {
    
    // 檢查是否存在相同的預約
    boolean existsByUserIdAndBookIdAndStatus(Integer userId, Long bookId, String status);
    
    // 根據用戶ID查詢並按創建時間降序排序
    List<ReservationLogEntity> findByUserIdOrderByCreatedAtDesc(Integer userId);
    
    // 根據用戶ID查詢
    List<ReservationLogEntity> findByUserId(Integer userId);
    
    // 根據狀態查詢
    List<ReservationLogEntity> findByStatus(String status);
    
    // 根據用戶ID和狀態查詢
    List<ReservationLogEntity> findByUserIdAndStatus(Integer userId, String status);
}