(defproject clojure-getting-started "0.1.0"
  :dependencies [[org.clojure/clojure "1.12.4"]
                 [ring/ring-core "1.15.3"]
                 [ring/ring-jetty-adapter "1.15.3"]
                 [ring/ring-defaults "0.7.0"]
                 [compojure "1.7.2"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.postgresql/postgresql "42.7.10"]]
  :main com.heroku.clojure-getting-started
  :aot [com.heroku.clojure-getting-started]
  :uberjar-name "clojure-getting-started.jar"
  :resource-paths ["resources"]
  :min-lein-version "2.0.0")
