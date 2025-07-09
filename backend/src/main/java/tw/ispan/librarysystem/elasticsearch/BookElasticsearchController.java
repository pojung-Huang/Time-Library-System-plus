package tw.ispan.librarysystem.elasticsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.librarysystem.dto.PageResponseDTO;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/elasticsearch")
public class BookElasticsearchController {

    private static final Logger log = LoggerFactory.getLogger(BookElasticsearchController.class);
    private final BookElasticsearchService service;

    @Autowired
    public BookElasticsearchController(BookElasticsearchService service) {
        this.service = service;
    }

    @GetMapping("/simple-search")
    public ResponseEntity<?> search(
        @RequestParam String keyword,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "title") String sortField,
        @RequestParam(defaultValue = "asc") String sortDir
    ) {
        try {
            // 參數驗證
            if (keyword == null || keyword.trim().isEmpty()) {
                return ResponseEntity.badRequest().body(createErrorResponse("搜尋關鍵字不能為空"));
            }
            
            if (page < 0) {
                return ResponseEntity.badRequest().body(createErrorResponse("頁碼不能為負數"));
            }
            
            if (size <= 0 || size > 100) {
                return ResponseEntity.badRequest().body(createErrorResponse("每頁大小必須在 1-100 之間"));
            }
            
            if (!sortDir.equalsIgnoreCase("asc") && !sortDir.equalsIgnoreCase("desc")) {
                return ResponseEntity.badRequest().body(createErrorResponse("排序方向必須是 'asc' 或 'desc'"));
            }

            // 自動使用全文搜尋
            PageResponseDTO<BookSearchResponse> result = service.searchBooks(
                "fulltext",  // 固定使用 fulltext
                keyword.trim(), 
                page, 
                size, 
                sortField, 
                sortDir
            );
            
            log.info("\n簡化搜尋成功: keyword={}, page={}, size={}, 結果數量={}", 
                keyword, page, size, result.getContent().size());
            
            return ResponseEntity.ok(result);
            
        } catch (Exception e) {
            log.error("\n簡化搜尋書籍時發生錯誤: keyword={}", keyword, e);
            return ResponseEntity.internalServerError()
                .body(createErrorResponse("\n搜尋失敗: " + e.getMessage()));
        }
    }

//    @PostMapping("/advanced-search")
//    public ResponseEntity<?> advancedSearch(@RequestBody List<EsQueryCondition> request) {
//        try {
//            PageResponseDTO<BookSearchResponse> result = service.advancedSearchBooks(request);
//            log.info("進階搜尋成功: 條件={}, 結果數量={}", request, result.getContent().size());
//            return ResponseEntity.ok(result);
//        } catch (Exception e) {
//            log.error("進階搜尋書籍時發生錯誤: 條件={}", request, e);
//            return ResponseEntity.internalServerError()
//                .body(createErrorResponse("進階搜尋失敗: " + e.getMessage()));
//        }
//    }

    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", true);
        response.put("message", message);
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }
}
