(ns chapter-1.exercise-1-4)

;; if b is positive, add b to a
;; if b is negative, do a - b, which is the same as a + |b|
;; in both cases, a + |b| is calculated for any a and b
(defn a-plus-abs-b
  [a b]
  ((if (> b 0) + -) a b))

