(ns chapter-1.exercise-1-3)

(defn sum-square
  [x y]
  (+ (* x x) (* y y)))

(defn sum-square-two-larger
  [a b c]
  (cond
    (and (<= a b) (<= a c)) (sum-square b c)
    (and (<= b a) (<= b c)) (sum-square a c)
    (and (<= c a) (<= c b)) (sum-square a b)))

(defn sum-square-two-larger2
  [a b c]
  (loop [a_ a, b_ b, c_ c]
    (if (and (< a_ b_) (< a_ c_))
      (sum-square b_ c_)
      (recur b_ c_ a_))))

(println (sum-square 3 4)) ; 25
(println (sum-square-two-larger 3 4 2)) ; 25
(println (sum-square-two-larger2 3 2 4)) ; 25
