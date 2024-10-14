(ns chapter-1.exercise-1-18)

(defn double [x] (* x 2))

(defn halve [x] (/ x 2))

(defn * [a b]
  (loop [a a, b b, result 0]
    (cond
      (zero? b) result
      (even? b) (recur (double a) (halve b) result)
      :else (recur a (dec b) (+ result a)))))

(println (* 2 4)) ; 8
(println (* 2 0)) ; 0
(println (* 0 0)) ; 0
(println (* 0 3)) ; 0
(println (* 5 3)) ; 15
(println (* 5 1)) ; 5
(println (* 1 10)) ; 10
