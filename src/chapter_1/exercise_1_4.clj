(ns chapter-1.exercise-1-4)

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

