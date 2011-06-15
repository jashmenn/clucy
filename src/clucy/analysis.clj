
(ns clucy.analysis
  (:use [clojure.contrib.string :only [as-str]]
        [clucy.util])
  (:require [clojure.java.io :as io]
            [clucy.imports :as imp]))

(imp/import-analysis)

(defn tokenizer [type input & tokenizer-args]
  (let [klass (condp = type
                  :ngram NGramTokenizer)
        reader (make-reader input)]
  (clojure.lang.Reflector/invokeConstructor 
   klass (to-array (concat [reader] tokenizer-args)))))


(comment

  (let [tok (tokenizer :ngram "my dog has fleas" 1 1)]
    )

  )
