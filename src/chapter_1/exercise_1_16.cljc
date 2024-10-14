(ns chapter-1.exercise-1-16)

(defn fast-expt [b n]
  (loop [a 1, b b, n n]
    (cond
      (zero? n) a
      (even? n) (recur a (* b b) (quot n 2))
      :else (recur (* a b) b (dec n)))))

(println (fast-expt 2 8)) ; 256
(println (fast-expt 0 8)) ; 0
(println (fast-expt 8 0)) ; 1
(println (fast-expt 3 3)) ; 27
