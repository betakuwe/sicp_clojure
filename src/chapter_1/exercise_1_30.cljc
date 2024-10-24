(ns chapter-1.exercise-1-30)

(defn sum [term a next b]
  (loop [a a result 0.0]
    (if (> a b)
      result
      (recur (next a) (+ result (term a))))))

(defn simpson-integral [f a b n]
  (let [h (/ (- a b) n)
        y (fn [k] (f (+ a (* k h))))
        c (fn [k] (cond (#{1 n} k) 1.0
                        (even? k) 2.0
                        :else 4.0))]
    (* (/ h 3.0) (sum #(+ (* (c %) (y %))) 0 inc n))))

(println (simpson-integral #(* % % %) 0 1 100)) ; 0.24999999
(println (simpson-integral #(* % % %) 0 1 1000)) ; 0.24999999999900005

