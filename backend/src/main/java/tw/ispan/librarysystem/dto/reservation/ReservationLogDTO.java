// 用來裝預約操作日誌的資料
package tw.ispan.librarysystem.dto.reservation;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationLogDTO {
    private Long logId;
    private Integer userId;
    private Integer bookId;
    private String action;
    private String status;
    private String message;
    private LocalDateTime createdAt;
    private LocalDateTime reserveTime;
    private String note;
    private String title;
    private String author;
    private String isbn;
    
    @JsonProperty("img_url")
    private String imgUrl;

    public Long getLogId() { return logId; }
    public void setLogId(Long logId) { this.logId = logId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getBookId() { return bookId; }
    public void setBookId(Integer bookId) { this.bookId = bookId; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getReserveTime() { return reserveTime; }
    public void setReserveTime(LocalDateTime reserveTime) { this.reserveTime = reserveTime; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
} 