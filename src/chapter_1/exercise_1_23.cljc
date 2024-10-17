(ns chapter-1.exercise-1-23
  (:import (java.lang System)))

(defn next [n]
  (case n
    2 3
    (+ n 2)))

(defn smallest-divisor [n]
  (loop [test-divisor 2]
    (cond
      (> (* test-divisor test-divisor) n) n
      (zero? (mod n test-divisor)) test-divisor
      :else (recur (next test-divisor)))))

(defn prime? [n] (= n (smallest-divisor n)))

(defn report-prime [elapsed-time]
  (println " *** ")
  (println elapsed-time))

(defn runtime [] (. System (currentTimeMillis)))

(defn start-prime-test [n start-time]
  (when (prime? n)
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

;; Still too fast to tell the difference

; 1009
;  ***
; 1

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
