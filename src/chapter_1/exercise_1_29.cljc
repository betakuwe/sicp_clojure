(ns chapter-1.exercise-1-29)

(defn simpson-integral [f a b n]
  (let [h (/ (- a b) n)
        y (fn [k] (f (+ a (* k h))))
        c (fn [k] (cond (#{1 n} k) 1.0
                        (even? k) 2.0
                        :else 4.0))]
    (letfn [(sum [k]
              (if (> k n)
                0.0
                (+ (* (c k) (y k))
                   (sum (inc k)))))]
      (* (/ h 3.0) (sum 0)))))

(println (simpson-integral #(* % % %) 0 1 100)) ; 0.2499999899999999
(println (simpson-integral #(* % % %) 0 1 1000)) ; 0.24999999999900022 
