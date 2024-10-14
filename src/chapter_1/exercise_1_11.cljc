(ns chapter-1.exercise-1-11)

(defn f-recur [n]
  (if (< n 3)
    n
    (+ (f-recur (dec n))
       (* 2 (f-recur (- n 2)))
       (* 3 (f-recur (- n 3))))))

(defn f-iter [n]
  (loop [a 2, b 1, c 0, counter n]
    (if (<= counter 0)
      c
      (recur (+ a (* 2 b) (* 3 c)) a b (dec counter)))))
