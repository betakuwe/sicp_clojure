(ns chapter-1.exercise-1-17)

(defn double [x] (* x 2))

(defn halve [x] (/ x 2))

(defn * [a b]
  (cond
    (zero? b) 0
    (even? b) (double (* a (halve b)))
    :else (+ a (* a (dec b)))))

(println (* 2 4)) ; 8
(println (* 2 0)) ; 0
(println (* 0 0)) ; 0
(println (* 0 3)) ; 0
(println (* 5 3)) ; 15
(println (* 5 1)) ; 5
(println (* 1 10)) ; 10








