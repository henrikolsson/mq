(ns mq.util
  (:require [clojure.tools.logging :as log]))

(defn realize [objects]
  (doseq [o objects]
    (deref o)))
