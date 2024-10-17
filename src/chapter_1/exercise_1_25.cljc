(ns chapter-1.exercise-1-25)

(defn fast-expt [b n]
  (loop [a 1, b b, n n]
    (cond
      (zero? n) a
      (even? n) (recur a (* b b) (quot n 2))
      :else (recur (* a b) b (dec n)))))

(defn expmod [base exp m]
  (mod (fast-expt base exp) m))

;; This would only work well for as long as base ^ exp does not overflow or become too big.
