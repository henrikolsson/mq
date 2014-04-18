(ns mq.core
  (:require [clojure.tools.logging :as log]))

(defn new []
  {:listeners (atom [])})

(defn stop [q]
  q)

(defn start [q]
  q)

(defn listen [q selector handler]
  (swap! (:listeners q) conj [selector handler]))

(defn send-message [q message]
  (let [matching-listeners (filter (fn [listener]
                                     ((first listener) message))
                                   @(:listeners q))]
    (doall (map 
            (fn [listener]
              (log/trace "found handler for message: " message)
              (future (apply (second listener) message)))
            matching-listeners))))




