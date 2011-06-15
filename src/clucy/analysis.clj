
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

(defn token-stream-seq
"Returns a lazy sequence on a
org.apache.lucene.analysis.TokenStream. By default returns the .term of the TermAttribute. If you wish to extract another property, pass an attr-extractor of one argument. e.g.:

 (let [tok (tokenizer :ngram \"my dog has fleas\" 1 1)]
    (prn (token-stream-seq tok 
          (fn [s] (.startOffset 
                  (.getAttribute s OffsetAttribute))))))"
([stream]
   (token-stream-seq stream
    (fn [s] (.term (.getAttribute s TermAttribute)))))
([stream attr-extractor]
     (let [step (fn [s]
                  (if (.incrementToken s)
                    (cons 
                     (attr-extractor s)
                     (token-stream-seq s attr-extractor))
                    (do
                      (.end s)
                      (.close s))))]
       (lazy-seq (step stream)))))

(comment

  (let [tok (tokenizer :ngram "my dog has fleas" 1 1)]
    (prn (token-stream-seq tok)))

  (let [tok (tokenizer :ngram "my dog has fleas" 1 1)]
    (prn (token-stream-seq tok 
          (fn [s] (.startOffset 
                  (.getAttribute s OffsetAttribute))))))
  )
