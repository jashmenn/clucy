
(ns clucy.util
  (:require [clojure.java.io :as io]
            [clucy.imports :as imp])
  (:import [java.io Reader StringReader InputStreamReader 
            InputStream]))

(defn make-reader 
  [readable]
  (cond
   (instance? Reader readable) readable
   (instance? String readable) (StringReader. readable)
   (instance? InputStream readable) (InputStreamReader. readable)))

