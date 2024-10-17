(ns chapter-1.exercise-1-22
  (:import (java.lang System)))

(defn runtime [] (. System (currentTimeMillis)))

(defn smallest-divisor [n]
  (loop [test-divisor 2]
    (cond
      (> (* test-divisor test-divisor) n) n
      (zero? (mod n test-divisor)) test-divisor
      :else (recur (inc test-divisor)))))

(defn prime? [n] (= n (smallest-divisor n)))

(defn report-prime [elapsed-time]
  (println " *** ")
  (println elapsed-time))

(defn start-prime-test [n start-time]
  (when (prime? n)
    (report-prime (- (runtime) start-time))))

(defn timed-prime-test [n]
  (println)
  (println n)
  (start-prime-test n (runtime)))

(timed-prime-test 43)
; 43
;  ***
; 0

(defn search-for-primes [start end]
  (loop [n start]
    (cond
      (<= end n) nil
      (even? n) (recur (inc n))
      :else (do (timed-prime-test n)
                (recur (+ 2 n))))))

(search-for-primes 1000 1020)
{1009 0
 1013 0
 1019 0}

(search-for-primes 10000 10040)
{10007 0
 10009 0
 10037 0}

(search-for-primes 100000 100050)
{100003 0
 100019 0
 100043 0}

(search-for-primes 1000000 1000050)
{1000003 0
 1000033 0
 1000037 0}

;; Clojure babashka is too fast to tell the difference

;; Output:

; 1001

; 1003

; 1005

; 1007

; 1009
;  ***
; 0

; 1011

; 1013
;  ***
; 0

; 1015

; 1017

; 1019
;  ***
; 0

; 10001

; 10003

; 10005

; 10007
;  ***
; 0

; 10009
;  ***
; 0

; 10011

; 10013

; 10015

; 10017

; 10019

; 10021

; 10023

; 10025

; 10027

; 10029

; 10031

; 10033

; 10035

; 10037
;  ***
; 0

; 10039
;  ***
; 0

; 100001

; 100003
;  ***
; 0

; 100005

; 100007

; 100009

; 100011

; 100013

; 100015

; 100017

; 100019
;  ***
; 0

; 100021

; 100023

; 100025

; 100027

; 100029

; 100031

; 100033

; 100035

; 100037

; 100039

; 100041

; 100043
;  ***
; 0

; 100045

; 100047

; 100049
;  ***
; 0

; 1000001

; 1000003
;  ***
; 0

; 1000005

; 1000007

; 1000009

; 1000011

; 1000013

; 1000015

; 1000017

; 1000019

; 1000021

; 1000023

; 1000025

; 1000027

; 1000029

; 1000031

; 1000033
;  ***
; 0

; 1000035

; 1000037
;  ***
; 0

; 1000039
;  ***
; 0

; 1000041

; 1000043

; 1000045

; 1000047

; 1000049
