(ns chapter-1.exercise-1-7
  (:require [chapter-1.section-1-1-7 :refer [improve]]))

(defn good-enough? [prev-guess guess]
  (and prev-guess
       (< (/ (abs (- prev-guess guess))
             guess)
          0.001)))

(defn sqrt-iter-2 [guess x]
  (loop [prev-guess nil guess guess]
    (if (good-enough? prev-guess guess)
      guess
      (recur guess (improve guess x)))))

(defn sqrt-2 [x]
  (sqrt-iter-2 1.0 x))
