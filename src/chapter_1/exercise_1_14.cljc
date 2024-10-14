(ns chapter-1.exercise-1-14)

(defn count-change
  [amount]
  (letfn [(first-denomination [kinds-of-coins]
            (case kinds-of-coins
              1 1
              2 5
              3 10
              4 25
              5 50))
          (cc [amount kinds-of-coins]
            (cond
              (zero? amount) 1
              (or (neg? amount) (zero? kinds-of-coins)) 0
              :else (+ (cc amount
                           (dec kinds-of-coins))
                       (cc (- amount (first-denomination kinds-of-coins))
                           kinds-of-coins))))]
    (cc amount 5)))

(println (count-change 100)) ; 292

;; it's like O(2^n) in time and space
; (cc 11 5)
;     (cc 11 4)
;         (cc 11 3)
;             (cc 11 2)
;                 (cc 11 1)
;                     (cc 11 0) = 0
;                     (cc 10 1)
;                         (cc 10 0) = 0
;                         (cc 9 1)
;                 (cc 6 1)
;             (cc 1 2)
;         (cc -14 4) = 0
;     (cc -39 4) = 0
