(ns chapter-1.exercise-1-10)

(defn A [x y]
  (cond (zero? y) 0
        (zero? x) (* 2 y)
        (= y 1) 2
        :else (A (dec x)
                 (A x (dec y)))))

(A 1 10) ; 1024 = 2^10

(A 2 4) ; 65536 = 2^16

(A 3 3) ; 65536 = 2^16

(defn f [n] (A 0 n)) ; 2*n

(defn g [n] (A 1 n)) ; 2^n

(defn h [n] (A 2 n)) ; 2^2^...^2 n times

(defn k [n] (* 5 n n))
