
(ns clucy.test.analysis
  (:use clucy.analysis
        clojure.test))

(deftest tokenizers
  (testing "standard tokenizer"
    (let [tok (tokenizer :standard "The dog said, \"hello you.\"")]
      (is (= (token-stream-seq tok) 
             '("The" "dog" "said" "hello" "you"))))))

