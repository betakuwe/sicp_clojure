(ns chapter-1.exercise-1-31)

(defn product [term a next b]
  (loop [a a result 1]
    (if (> a b)
      result
      (recur (next a) (* result (term a))))))

(defn factorial [n]
  (product identity 1 inc (inc n)))

(doseq [n (range 1 10)]
  (println (str n "!") "=" (factorial n)))
