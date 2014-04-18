(defproject mq "0.0.1-SNAPSHOT"
  :description "Extremely simple message/event bus"
  :url "http://fixme.se"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 [log4j/log4j "1.2.14" :scope "test"]]
  :test-paths ["test" "test-resources"]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]]
                   :source-paths ["dev"]}})
