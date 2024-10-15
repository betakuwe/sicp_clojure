(ns chapter-1.exercise-1-20)

(defn gcd [a b]
  (println "gcd called")
  (if (zero? b)
    a
    (gcd b (mod a b))))

(println (gcd 206 40)) ; 2
;; gcd is called 5 times (applicative order)
