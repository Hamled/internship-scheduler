(set-env!
  :source-paths #{"src/clj" "src/cljs"}
  :asset-paths #{"assets"}
  :dependencies '[[org.clojure/clojure          "1.8.0"]
                  [org.clojure/clojurescript    "1.9.229"]
                  [adzerk/boot-cljs             "1.7.228-1" :scope "test"]
                  [adzerk/boot-cljs-repl        "0.3.3"     :scope "test"]
                  [adzerk/boot-reload           "0.4.12"    :scope "test"]
                  [tailrecursion/boot-jetty     "0.1.3"     :scope "test"]
                  [com.cemerick/piggieback      "0.2.1"     :scope "test"]
                  [weasel                       "0.7.0"     :scope "test"]
                  [org.clojure/tools.nrepl      "0.2.12"    :scope "test"]])

(require '[adzerk.boot-cljs         :refer [cljs]]
         '[adzerk.boot-cljs-repl    :refer [cljs-repl]]
         '[adzerk.boot-reload       :refer [reload]]
         '[tailrecursion.boot-jetty :refer [serve]])

(def port 3994)

(deftask dev []
  (comp
    (watch)
    (reload)
    (cljs-repl)
    (cljs :optimizations :none)
    (serve :port port)))
