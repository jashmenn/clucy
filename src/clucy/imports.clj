
(ns clucy.imports
;;^{:doc "Functions to import entire packages under org.apache.lucene."}
)

(defn import-basics []
  (import '(org.apache.lucene.analysis.standard StandardAnalyzer)
          '(org.apache.lucene.document Document Field Field$Index Field$Store)
          '(org.apache.lucene.index IndexWriter IndexWriter$MaxFieldLength Term)
          '(org.apache.lucene.queryParser QueryParser)
          '(org.apache.lucene.search BooleanClause BooleanClause$Occur
                                     BooleanQuery IndexSearcher TermQuery)
          '(org.apache.lucene.search.highlight Highlighter QueryScorer
                                               SimpleHTMLFormatter)
          '(org.apache.lucene.store NIOFSDirectory RAMDirectory)
          '(org.apache.lucene.util Version)))


(defn import-analysis []
  (import 
   '(org.apache.lucene.analysis Analyzer KeywordAnalyzer
     PerFieldAnalyzerWrapper SimpleAnalyzer StopAnalyzer
     WhitespaceAnalyzer CharArraySet$CharArraySetIterator Token
     TokenStream TokenFilter CachingTokenFilter ISOLatin1AccentFilter
     LengthFilter LowerCaseFilter PorterStemFilter StopFilter
     TeeTokenFilter Tokenizer CharTokenizer LetterTokenizer
     LowerCaseTokenizer WhitespaceTokenizer KeywordTokenizer
     SinkTokenizer WordlistLoader)))
