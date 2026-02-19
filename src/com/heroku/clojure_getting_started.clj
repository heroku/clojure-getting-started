(ns com.heroku.clojure-getting-started
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [clojure.java.jdbc :as jdbc]
            [clojure.java.io :as io])
  (:gen-class))

(defn database [request]
  (let [db-url (System/getenv "JDBC_DATABASE_URL")]
    (if (nil? db-url)
      "JDBC_DATABASE_URL environment variable is not set!"
      (let [db {:connection-uri db-url}
            ticks (jdbc/with-db-connection [conn db]
                    (jdbc/execute! conn "CREATE TABLE IF NOT EXISTS ticks (tick timestamp)")
                    (jdbc/execute! conn "INSERT INTO ticks VALUES (now())")
                    (jdbc/query conn "SELECT tick FROM ticks"))]
        (str "Database Output\n\n"
             (clojure.string/join "\n" (map #(str "Read from DB: " (:tick %)) ticks)))))))

(defn home [request]
  (slurp (io/resource "public/index.html")))

(defroutes app-routes
  (GET "/" [] home)
  (GET "/database" [] database)
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-resource "public")
      (wrap-content-type)
      (wrap-defaults site-defaults)))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty app {:port port :join? false})))
