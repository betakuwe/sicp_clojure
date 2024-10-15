(ns chapter-1.exercise-1-19)

;; a <- a + b <- a + a + b
;; b <- a <- a + b

;; a <- bq + aq + ap <- (bp + aq)q + (bq + aq + ap)q + (bq + aq + ap)p
;;                    = bpq + aq^2 + bq^2 + aq^2 + apq + bpq + apq + ap^2
;;                    = 2bpq + 2aq^2 + 2apq + bq^2 + ap^2
;;                    = 2bpq + bq^2 + 2aq^2 +2apq + ap^2
;;                    = b(2pq + q^2) + 2apq + aq^2 + aq^2 + ap^2
;;                    = b(2pq + q^2) + a(2pq + q^2) + a(p^2 + q^2)

;; b <- bp + aq <- (bp + aq)p + (bq + aq + ap)q
;;               = bp^2 + apq + bq^2 + aq^2 + apq
;;               = bp^2 + bq^2 + 2apq + aq^2
;;               = b(p^2 + q^2) + a(2pq + q^2)

;; p <- p^2 + q^2
;; q <- 2pq + q^2

(defn fib [n]
  (loop [a 1, b 0, p 0, q 1, count n]
    (cond
      (zero? count) b
      (even? count) (recur a
                           b
                           (+ (* p p) (* q q))
                           (+ (* 2 p q) (* q q))
                           (quot count 2))
      :else (recur (+ (* b q) (* a q) (* a p))
                   (+ (* b p) (* a q))
                   p
                   q
                   (dec count)))))

(defn fib-linear [n]
  (loop [a 0, b 1, count n]
    (if (<= count 0)
      a
      (recur b (+ a b) (dec count)))))

(println (for [n (range 20)] (fib-linear n)))
; (0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181)

(println (for [n (range 20)] (fib n)))
; (0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181)
