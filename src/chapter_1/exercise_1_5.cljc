(ns chapter-1.exercise-1-5)

(defn p [] (p))

(defn test
  [x y]
  (if (= x 0)
    0
    y))

;; leads to infintie recursion due to applicative order
; (test 0 (p))

