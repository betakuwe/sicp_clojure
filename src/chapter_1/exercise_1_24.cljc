(ns chapter-1.exercise-1-24
  (:import (java.lang System)))

(defn runtime [] (. System (currentTimeMillis)))

(defn smallest-divisor [n]
  (loop [test-divisor 2]
    (cond
      (> (* test-divisor test-divisor) n) n
      (zero? (mod n test-divisor)) test-divisor
      :else (recur (inc test-divisor)))))

(defn square [n] (* n n))

(defn expmod [base exp m]
  (cond (zero? exp) 1
        (even? exp) (mod (square (expmod base (quot exp 2) m))
                         m)
        :else (mod (* base (expmod base (dec exp) m))
                   m)))

(defn fermat-test [n]
  (let [a (inc (rand-int (dec n)))]
    (= (expmod a n n) a)))

(defn fast-prime? [n times]
  (loop [times times]
    (cond (zero? times) true
          (fermat-test n) (recur (dec times))
          :else false)))

(defn report-prime [elapsed-time]
  (println " *** ")
  (println elapsed-time))

(defn start-prime-test [n start-time]
  (when (fast-prime? n 3)
    (report-prime (- (runtime) start-time))))

(defn timed-prime-test [n]
  (println)
  (println n)
  (start-prime-test n (runtime)))

(timed-prime-test 1009)
(timed-prime-test 1013)
(timed-prime-test 1019)
(timed-prime-test 10007)
(timed-prime-test 10009)
(timed-prime-test 10037)
(timed-prime-test 100003)
(timed-prime-test 100019)
(timed-prime-test 100043)
(timed-prime-test 1000003)
(timed-prime-test 1000033)
(timed-prime-test 1000037)

;; Clojure is too good for this

; 1009
;  ***
; 0

; 1013
;  ***
; 0

; 1019
;  ***
; 0

; 10007
;  ***
; 0

; 10009
;  ***
; 0

; 10037
;  ***
; 0

; 100003
;  ***
; 0

; 100019
;  ***
; 0

; 100043
;  ***
; 0

; 1000003
;  ***
; 0

; 1000033
;  ***
; 0

; 1000037
;  ***
; 0
