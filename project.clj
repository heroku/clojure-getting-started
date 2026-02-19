(defproject clojure-getting-started "0.1.0"
  :dependencies [[org.clojure/clojure "1.12.3"]
                 [ring/ring-core "1.9.6"]
                 [ring/ring-jetty-adapter "1.9.6"]
                 [ring/ring-defaults "0.3.4"]
                 [compojure "1.7.0"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.postgresql/postgresql "42.7.2"]]
  :main com.heroku.clojure-getting-started
  :aot [com.heroku.clojure-getting-started]
  :uberjar-name "clojure-getting-started.jar"
  :resource-paths ["resources"]
  :min-lein-version "2.0.0")
