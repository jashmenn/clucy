
(ns clucy.test.analysis
  (:use clucy.analysis
        clojure.test))

(deftest tokenizers

  (testing "standard tokenizer"
    (let [tok (tokenizer :standard "The dog said, \"hello you.\"")]
      (is (= (token-stream-seq tok) 
             '("The" "dog" "said" "hello" "you")))))

  (testing "ngram tokenizer"
    (let [tok (tokenizer :ngram "abc def" 2 2)]
      (is (= (token-stream-seq tok) 
             '("ab" "bc" "c " " d" "de" "ef")))))

  )

