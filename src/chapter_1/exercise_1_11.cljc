(ns chapter-1.exercise-1-11
  (:require [clojure.string :as str]))

(defn f-recur
  [n]
  (if (< n 3)
    n
    (+ (f-recur (dec n))
       (* 2 (f-recur (- n 2)))
       (* 3 (f-recur (- n 3))))))

(defn f-iter
  [n]
  (loop [a 2, b 1, c 0, counter n]
    (if (<= counter 0)
      c
      (recur (+ a (* 2 b) (* 3 c)) a b (dec counter)))))

(println "Recursively")
(println (str/join " "
                   (for [n (range 10)]
                     (f-recur n))))
; => 0 1 2 4 11 25 59 142 335 796

(println "Iteratively")
(println (str/join " "
                   (for [n (range 10)]
                     (f-iter n))))
; => 0 1 2 4 11 25 59 142 335 796
