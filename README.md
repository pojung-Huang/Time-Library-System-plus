# Time-Library-System-plus
<img width="946" alt="{328B5F36-E5CD-4222-A176-6D7E6D717800}" src="https://github.com/user-attachments/assets/832189ef-9d56-47bf-8a1a-4a13b896cfe9" />
<img width="821" alt="{EC5BDAD7-1E0E-4287-AD9E-FBDDBC2C0ECF}" src="https://github.com/user-attachments/assets/037f053c-1ff1-4178-be06-886b18589bc7" />


## 專案簡介
Time-Library-System-plus 是一套現代化的圖書館管理系統，支援會員管理、圖書借閱、座位預約、評論反饋等多項功能，前後端分離設計，易於擴充與維護。


## 技術架構：
本系統採用 前後端分離 + 混合式資料處理架構，整體設計模組化，利於擴充與維護，並結合全文搜尋、資料前處理與容器化部署。
架構可分為以下層級：

前端：Nuxt3 + Vue3（單頁式應用 SPA）

後端：Spring Boot + RESTful API（Java 17, Maven 3.9.9）

資料前處理：Python 腳本（清洗與轉換後同步至資料庫與搜尋引擎）

資料庫：

MySQL（儲存結構化資料）

Elasticsearch（支援全文搜尋）

部署：Docker（前後端與資料庫容器化）

通訊格式：JSON（前後端透過 API 傳輸資料）

版本控管：Git / GitHub


## 功能特色
🔐 會員管理

支援註冊、登入、JWT 驗證

權限區分一般會員與管理員

📚 圖書管理與查詢

書籍列表、分類查詢、詳細資料瀏覽

使用 Elasticsearch 實現快速模糊搜尋與全文檢索

📖 借閱系統

借書、還書功能

借閱紀錄查詢與逾期提醒

🪑 座位預約系統

使用者可預約圖書館座位

支援即時查詢座位狀況與取消預約

💬 書籍評論與評分

使用者可對書籍留言、評論與評分

協助其他讀者參考選書

🛠️ 管理員後台

書籍 CRUD 操作（新增、修改、刪除）

使用者與借閱紀錄管理

座位與評論審核功能

🌐 郵遞區號資料匯入

使用 Python 腳本匯入政府開放郵遞區號資料

提供地址欄位自動填寫輔助功能

🚀 容器化部署

使用 Docker 快速啟動前端、後端與資料庫服務

可輕鬆部署至本機或雲端伺服器


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

## 啟動方式

### 後端
1. 進入 `backend` 目錄 :
   ```cd backend```
2. 安裝依賴並啟動 Spring Boot 伺服器 :
   ```mvn spring-boot:run```

### 前端
1. 進入 `frontend` 目錄 :
   ```cd backend```
2. 安裝依賴 :
   ```npm install```
3. 啟動開發伺服器 :
   ```npm run dev```

## 使用說明
- 前端預設運行於 `http://localhost:3000`
- 後端 API 運行於 `http://localhost:8080`

## 授權
本專案採用 MIT License 授權。

---
