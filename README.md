# Time-Library-System-plus
<img width="946" alt="{328B5F36-E5CD-4222-A176-6D7E6D717800}" src="https://github.com/user-attachments/assets/832189ef-9d56-47bf-8a1a-4a13b896cfe9" />
<img width="444" alt="{D14368B6-1F48-4167-8D79-73F2E6345D5D}" src="https://github.com/user-attachments/assets/f31b731d-e122-43a2-9d22-87ee7e053f28" />


## 專案簡介
Time-Library-System-plus 是一套現代化的圖書館管理系統，支援會員管理、圖書借閱、座位預約、評論反饋等多項功能，前後端分離設計，易於擴充與維護。

## 主要功能
- 會員註冊與登入
- 圖書查詢與借閱
- 座位預約與管理
- 書籍評論與反饋
- 管理員後台管理
- 郵遞區號匯入
- Elasticsearch 書籍全文檢索

## 專案結構
```
ispan/
  ├── backend/         # 後端 Spring Boot 專案
  │   ├── src/         # Java 原始碼與資源
  │   └── zipcode_import/ # 郵遞區號匯入腳本
  └── frontend/        # 前端 Nuxt3 + Vue3 專案
      ├── components/  # 前端元件
      ├── pages/       # 前端頁面
      └── utils/       # 前端工具
```

## 安裝方式

### 後端
1. 進入 `backend` 目錄
2. 安裝依賴並啟動 Spring Boot 伺服器
   ```bash
   ./mvnw spring-boot:run
   ```
3. 如需郵遞區號資料，請參考`zipcode_import/` 目錄下說明

### 前端
1. 進入 `frontend` 目錄
2. 安裝依賴
   ```bash
   npm install
   ```
3. 啟動開發伺服器
   ```bash
   npm run dev
   ```

## 使用說明
- 前端預設運行於 `http://localhost:3000`
- 後端 API 運行於 `http://localhost:8080`
- 請依需求修改 `frontend/nuxt.config.ts` 及 `backend/src/main/resources/application.properties` 相關設定

## 授權
本專案採用 MIT License 授權。

---
