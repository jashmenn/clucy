
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
   '(org.apache.lucene.analysis
     CharArraySet Analyzer KeywordAnalyzer PerFieldAnalyzerWrapper SimpleAnalyzer StopAnalyzer WhitespaceAnalyzer Token TokenStream NumericTokenStream TeeSinkTokenFilter$SinkTokenStream TokenFilter ASCIIFoldingFilter CachingTokenFilter ISOLatin1AccentFilter LengthFilter LowerCaseFilter PorterStemFilter StopFilter TeeSinkTokenFilter Tokenizer CharTokenizer LetterTokenizer LowerCaseTokenizer WhitespaceTokenizer KeywordTokenizer Token$TokenAttributeFactory CharArraySet$CharArraySetIterator NormalizeCharMap CharStream CharFilter BaseCharFilter MappingCharFilter CharReader TeeSinkTokenFilter$SinkFilter WordlistLoader)
   '(org.apache.lucene.analysis.ngram EdgeNGramTokenFilter NGramTokenFilter EdgeNGramTokenizer NGramTokenizer)
   '(org.apache.lucene.analysis.tokenattributes FlagsAttribute OffsetAttribute PayloadAttribute PositionIncrementAttribute TermAttribute TypeAttribute)
   '(org.apache.lucene.analysis.standard StandardAnalyzer StandardFilter StandardTokenizer)))


