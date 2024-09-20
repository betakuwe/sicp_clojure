(ns chapter-1.exercise-1-3)

(defn sum-square-two-larger [a b c]
  (loop [a a b b c c]
    (if (and (< a b) (< a c))
      (+ (* b b) (* c c))
      (recur b c a))))
