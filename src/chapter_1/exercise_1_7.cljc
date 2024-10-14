(ns chapter-1.exercise-1-7
  (:require [chapter-1.section-1-1-7 :refer [improve]]))

(defn good-enough?
  [prev-guess guess]
  (and prev-guess
       (< (/ (abs (- prev-guess guess))
             guess)
          0.001)))

(defn sqrt-iter
  [guess x]
  (loop [prev-guess nil, guess guess]
    (if (good-enough? prev-guess guess)
      guess
      (recur guess (improve guess x)))))

(defn sqrt [x] (sqrt-iter 1.0 x))

(println (sqrt 2)) ; 1.4142135623746899
