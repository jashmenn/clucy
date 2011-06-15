
(ns clucy.analysis
  (:use [clojure.contrib.string :only [as-str]]
        [clucy.util])
  (:require [clojure.java.io :as io]
            [clucy.imports :as imp]))

(imp/import-basics)
(imp/import-analysis)

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

(defn tokenizer 
  "an easy (and opinionated) way to create tokenizers."
  [type input & tokenizer-args]
  (let [klass (condp = type
                  :ngram NGramTokenizer
                  :standard StandardTokenizer)
        reader (make-reader input)
        constr-args (condp = klass
                        NGramTokenizer (concat [reader] tokenizer-args)
                        StandardTokenizer [version-as-object reader])]
    (clojure.lang.Reflector/invokeConstructor 
     klass (into-array Object constr-args))))

(comment

  (let [tok (tokenizer :standard 
                       "The White House said, \"hello world.\"")]
    (prn (token-stream-seq tok)))

 )
