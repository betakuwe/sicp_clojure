(ns chapter-1.exercise-1-9)

; This is recursive
(defn + [a b]
  (if (= a 0)
    b
    (inc (+ (dec a) b))))

; This is iterative
(defn + [a b]
  (if (= a 0)
    b
    (+ (dec a) (inc b))))
