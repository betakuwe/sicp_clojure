(ns chapter-1.exercise-1-8)

(defn good-enough? [prev-guess guess]
  (and prev-guess
       (< (/ (abs (- prev-guess guess))
             guess)
          0.001)))

(defn improve [guess x]
  (/ (+ (/ x (* guess guess))
        (* 2.0 guess))
     3.0))

(defn cube-root-iter [guess x]
  (loop [prev-guess nil, guess guess]
    (if (good-enough? prev-guess guess)
      guess
      (recur guess (improve guess x)))))

(defn cube-root [x]
  (cube-root-iter 1.0 x))

