(ns clojure-getting-started.env
  (:require
   [selmer.parser :as parser]
   [clojure.tools.logging :as log]
   [clojure-getting-started.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[clojure-getting-started started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[clojure-getting-started has shut down successfully]=-"))
   :middleware wrap-dev})
