(ns chapter-1.exercise-1-26)

(defn expmod [base exp m]
  (cond (zero? exp) 1
        (even? exp) (mod (* (expmod base (quot exp 2) m)
                            (expmod base (quot exp 2) m))
                         m)
        :else (mod (* base (expmod base (dec exp) m))
                   m)))

;; Evaluating expmod twice for each expmod when exp is even turns the time complexity
;; from O(log n) to O(2^(log n)) = O(n)
