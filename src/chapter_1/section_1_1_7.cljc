(ns chapter-1.section-1-1-7
  (:require [utils :refer [square]]))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn average [x y]
  (/ (+ x y) 2.0))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [guess x]
  (loop [guess guess]
    (if (good-enough? guess x)
      guess
      (recur (improve guess x)))))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

