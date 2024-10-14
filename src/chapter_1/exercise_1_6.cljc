(ns chapter-1.exercise-1-6
  (:require [chapter-1.section-1-1-7 :refer [sqrt-iter good-enough? improve]]))

(defn new-if
  [predicate then-clause else-clause]
  (if predicate
    then-clause
    else-clause))

(new-if (= 2 3) 0 5)

(new-if (= 1 1) 0 5)

(defn sqrt-iter
  [guess x]
  ; using `new-if` instead of `if`
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter (improve guess x)
                     x)))

(defn sqrt [x] (sqrt-iter 1.0 x))

;; This will lead to infinite recursion because the else-clause will have to be 
;; evaluated regardless of whether the predicate is true or false.
; (sqrt 2)
