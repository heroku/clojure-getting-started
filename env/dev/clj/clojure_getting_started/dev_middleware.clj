(ns clojure-getting-started.dev-middleware
  (:require
   [clojure-getting-started.config :refer [env]
   [ring.middleware.reload :refer [wrap-reload]
   [selmer.middleware :refer [wrap-error-page]
   [prone.middleware :refer [wrap-exceptions]

(defn wrap-dev [handler]
  (-> handler
      wrap-reload
      wrap-error-page
      ;; disable prone middleware, it can not handle async
      (cond-> (not (env :async?)) (wrap-exceptions {:app-namespaces ['clojure-getting-started]}))))
"ยินดีต้อนรับสู่คลิปบอร์ดของ Gboard ข้อความที่คุณคัดลอกจะบันทึกไว้ที่นี่
