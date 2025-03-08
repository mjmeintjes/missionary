(ns tasks.build
  (:require [clojure.tools.build.api :as b]
            [clojure.java.shell :as sh]
            #_[babashka.process :As ps]))


(def class-dir "target/classes")

(def basis (delay (b/create-basis {:project "deps.edn"})))

(defn clean [_]
  (b/delete {:path "target"}))

(defn compile [_]
  (b/javac {:src-dirs ["java"]
            :class-dir class-dir
            :basis @basis
            :javac-opts ["--release" "23"]}))
