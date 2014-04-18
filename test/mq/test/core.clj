(ns mq.test.core
  (:require [mq.core :as mq]
            [clojure.tools.logging :as log])
  (:use [clojure.test]
        [mq.util]))

(deftest can-send-and-receive []
  (let [bus (mq/new)
        should-be-set (ref nil)
        should-not-be-set (ref nil)]
    (mq/listen bus #(= (:foo %1) :something) (fn [msg]
                                               (log/info "got unexpected event")
                                               (dosync
                                                (ref-set should-not-be-set true))))
    (mq/listen bus #(= (:foo %1) :test) (fn [msg]
                                          (log/info "got expected event")
                                          (dosync 
                                           (ref-set should-be-set true))))
    (realize (mq/send-message bus {:foo :test}))
    (is (= @should-be-set true))
    (is (= @should-not-be-set nil))))
