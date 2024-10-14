(ns chapter-1.exercise-1-6
  (:require [chapter-1.section-1-1-7 :refer [sqrt-iter sqrt good-enough? improve]]))

(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(new-if (= 2 3) 0 5)

(new-if (= 1 1) 0 5)

(defn sqrt-iter-alyssa [guess x]
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter-alyssa (improve guess x)
                            x)))

(defn sqrt-alyssa [x] (sqrt-iter-alyssa 1.0 x))


