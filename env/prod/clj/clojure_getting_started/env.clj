(ns clojure-getting-started.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[clojure-getting-started started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[clojure-getting-started has shut down successfully]=-"))
   :middleware identity})
