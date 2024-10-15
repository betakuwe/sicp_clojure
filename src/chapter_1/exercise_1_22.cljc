(ns chapter-1.exercise-1-22)

(defn smallest-divisor [n]
  (loop [test-divisor 2]
    (cond
      (> (* test-divisor test-divisor) n) n
      (zero? (mod n test-divisor)) test-divisor
      :else (recur (inc test-divisor)))))

(defn prime? [n] (= n (smallest-divisor n)))

(defn timed-prime-test [n]
  (println n)
  (println " *** ")
  (time (prime? n)))

(println (timed-prime-test 43))
; 43
;  ***
; "Elapsed time: 0.007474 msecs"
; true

(defn search-for-primes [start end]
  (loop [n start]
    (if (or (<= end n) (timed-prime-test n))
      n
      (recur (inc n)))))

(defn smallest-3-primes-larger-than [n]
  (loop [start (inc n), count 1]
    (if (> count 3)
      true
      (recur (inc (let [next-prime (search-for-primes start (* 2 start))]
                    (println "Prime number" count "after" n "is" next-prime)
                    next-prime))
             (inc count)))))

(smallest-3-primes-larger-than 1000)
(smallest-3-primes-larger-than 10000)
(smallest-3-primes-larger-than 100000)
(smallest-3-primes-larger-than 1000000)

; Prime number 1 after 1000 is 1009
; Prime number 2 after 1000 is 1013
; Prime number 3 after 1000 is 1019
; Prime number 1 after 10000 is 10007
; Prime number 2 after 10000 is 10009
; Prime number 3 after 10000 is 10037
; Prime number 1 after 100000 is 100003
; Prime number 2 after 100000 is 100019
; Prime number 3 after 100000 is 100043
; Prime number 1 after 1000000 is 1000003
; Prime number 2 after 1000000 is 1000033
; Prime number 3 after 1000000 is 1000037

; 43
;  ***
; "Elapsed time: 0.007487 msecs"
; true
; 1001
;  ***
; "Elapsed time: 0.002358 msecs"
; 1002
;  ***
; "Elapsed time: 4.42E-4 msecs"
; 1003
;  ***
; "Elapsed time: 0.002791 msecs"
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; 1004
;  ***
; "Elapsed time: 4.2E-4 msecs"
; 1005
;  ***
; "Elapsed time: 5.86E-4 msecs"
; 1006
;  ***
; "Elapsed time: 3.98E-4 msecs"
; 1007
;  ***
; "Elapsed time: 0.002981 msecs"
; 1008
;  ***
; "Elapsed time: 4.12E-4 msecs"
; 1009
;  ***
; "Elapsed time: 0.013092 msecs"
; Prime number 1 after 1000 is 1009
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; 1010
;  ***
; "Elapsed time: 5.12E-4 msecs"
; 1011
;  ***
; "Elapsed time: 5.99E-4 msecs"
; 1012
;  ***
; "Elapsed time: 4.03E-4 msecs"
; 1013
;  ***
; "Elapsed time: 0.004621 msecs"
; Prime number 2 after 1000 is 1013
; 1014
;  ***
; "Elapsed time: 4.2E-4 msecs"
; 1015
;  ***
; "Elapsed time: 9.21E-4 msecs"
; 1016
;  ***
; "Elapsed time: 3.98E-4 msecs"
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; 1017
;  ***
; "Elapsed time: 6.0E-4 msecs"
; 1018
;  ***
; "Elapsed time: 4.03E-4 msecs"
; 1019
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
;  ***
; "Elapsed time: 0.004865 msecs"
; Prime number 3 after 1000 is 1019
; 10001
;  ***
; "Elapsed time: 0.019776 msecs"
; 10002
;  ***
; "Elapsed time: 3.97E-4 msecs"
; 10003
;  ***
; "Elapsed time: 0.001215 msecs"
; 10004
;  ***
; "Elapsed time: 3.93E-4 msecs"
; 10005
;  ***
; "Elapsed time: 5.57E-4 msecs"
; 10006
;  ***
; "Elapsed time: 0.001408 msecs"
; 10007
;  ***
; "Elapsed time: 0.030205 msecs"
; Prime number 1 after 10000 is 10007
; 10008
;  ***
; "Elapsed time: 4.11E-4 msecs"
; 10009
;  ***
; "Elapsed time: 0.015544 msecs"
; Prime number 2 after 10000 is 10009
; 10010
;  ***
; "Elapsed time: 4.35E-4 msecs"
; 10011
;  ***
; "Elapsed time: 5.91E-4 msecs"
; 10012
;  ***
; "Elapsed time: 3.99E-4 msecs"
; 10013
;  ***
; "Elapsed time: 0.002646 msecs"
; 10014
;  ***
; "Elapsed time: 4.0E-4 msecs"
; 10015
;  ***
; "Elapsed time: 9.73E-4 msecs"
; 10016
;  ***
; "Elapsed time: 3.92E-4 msecs"
; 10017
;  ***
; "Elapsed time: 5.86E-4 msecs"
; 10018
;  ***
; "Elapsed time: 4.03E-4 msecs"
; 10019
;  ***
; "Elapsed time: 0.00636 msecs"
; 10020
;  ***
; "Elapsed time: 4.15E-4 msecs"
; 10021
;  ***
; "Elapsed time: 0.001854 msecs"
; 10022
;  ***
; "Elapsed time: 4.18E-4 msecs"
; 10023
;  ***
; "Elapsed time: 5.77E-4 msecs"
; 10024
;  ***
; "Elapsed time: 3.97E-4 msecs"
; 10025
;  ***
; "Elapsed time: 9.4E-4 msecs"
; 10026
;  ***
; "Elapsed time: 3.9E-4 msecs"
; 10027
;  ***
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; "Elapsed time: 0.005584 msecs"
; 10028
;  ***
; "Elapsed time: 4.01E-4 msecs"
; 10029
;  ***
; "Elapsed time: 0.007783 msecs"
; 10030
;  ***
; "Elapsed time: 3.97E-4 msecs"
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; 10031
;  ***
; "Elapsed time: 0.001197 msecs"
; 10032
;  ***
; "Elapsed time: 4.0E-4 msecs"
; 10033
;  ***
; "Elapsed time: 0.02591 msecs"
; 10034
;  ***
; "Elapsed time: 3.94E-4 msecs"
; 10035
;  ***
; "Elapsed time: 6.3E-4 msecs"
; 10036
;  ***
; "Elapsed time: 3.98E-4 msecs"
; 10037
;  ***
; "Elapsed time: 0.014152 msecs"
; Prime number 3 after 10000 is 10037
; 100001
;  ***
; "Elapsed time: 0.001782 msecs"
; 100002
;  ***
; "Elapsed time: 4.03E-4 msecs"
; 100003
;  ***
; "Elapsed time: 0.046455 msecs"
; Prime number 1 after 100000 is 100003
; 100004
;  ***
; "Elapsed time: 4.16E-4 msecs"
; 100005
;  ***
; "Elapsed time: 5.84E-4 msecs"
; 100006
;  ***
; "Elapsed time: 4.51E-4 msecs"
; 100007
;  ***
; "Elapsed time: 0.013697 msecs"
; 100008
;  ***
; "Elapsed time: 4.1E-4 msecs"
; 100009
;  ***
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; "Elapsed time: 0.001219 msecs"
; 100010
;  ***
; "Elapsed time: 4.07E-4 msecs"
; 100011
;  ***
; "Elapsed time: 6.27E-4 msecs"
; 100012
;  ***
; "Elapsed time: 4.16E-4 msecs"
; 100013
;  ***
; "Elapsed time: 0.015248 msecs"
; 100014
;  ***
; "Elapsed time: 3.99E-4 msecs"
; 100015
;  ***
; "Elapsed time: 9.13E-4 msecs"
; 100016
;  ***
; "Elapsed time: 3.99E-4 msecs"
; 100017
;  ***
; "Elapsed time: 5.93E-4 msecs"
; 100018
;  ***
; "Elapsed time: 4.05E-4 msecs"
; 100019
;  ***
; "Elapsed time: 0.055357 msecs"
; Prime number 2 after 100000 is 100019
; 100020
;  ***
; "Elapsed time: 4.12E-4 msecs"
; 100021
;  ***
; "Elapsed time: 0.005403 msecs"
; 100022
;  ***
; "Elapsed time: 4.02E-4 msecs"
; 100023
;  ***
; "Elapsed time: 5.85E-4 msecs"
; 100024
;  ***
; "Elapsed time: 3.94E-4 msecs"
; 100025
;  ***
; "Elapsed time: 9.4E-4 msecs"
; 100026
;  ***
; "Elapsed time: 3.98E-4 msecs"
; 100027
;  ***
; "Elapsed time: 0.003546 msecs"
; 100028
;  ***
; "Elapsed time: 3.97E-4 msecs"
; 100029
;  ***
; "Elapsed time: 6.38E-4 msecs"
; 100030
;  ***
; "Elapsed time: 4.11E-4 msecs"
; 100031
;  ***
; "Elapsed time: 0.018669 msecs"
; 100032
;  ***
; "Elapsed time: 4.01E-4 msecs"
; 100033
;  ***
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; "Elapsed time: 0.038227 msecs"
; 100034
;  ***
; "Elapsed time: 4.01E-4 msecs"
; 100035
;  ***
; "Elapsed time: 5.86E-4 msecs"
; 100036
;  ***
; "Elapsed time: 4.22E-4 msecs"
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; 100037
;  ***
; "Elapsed time: 0.001201 msecs"
; 100038
;  ***
; "Elapsed time: 4.16E-4 msecs"
; 100039
;  ***
; "Elapsed time: 0.010242 msecs"
; 100040
;  ***
; "Elapsed time: 3.98E-4 msecs"
; 100041
;  ***
; "Elapsed time: 5.99E-4 msecs"
; 100042
;  ***
; "Elapsed time: 3.95E-4 msecs"
; 100043
;  ***
; "Elapsed time: 0.064835 msecs"
; Prime number 3 after 100000 is 100043
; 1000001
;  ***
; "Elapsed time: 0.023963 msecs"
; 1000002
;  ***
; "Elapsed time: 4.04E-4 msecs"
; 1000003
;  ***
; "Elapsed time: 0.211979 msecs"
; Prime number 1 after 1000000 is 1000003
; 1000004
;  ***
; "Elapsed time: 4.15E-4 msecs"
; 1000005
;  ***
; "Elapsed time: 6.13E-4 msecs"
; 1000006
;  ***
; "Elapsed time: 3.93E-4 msecs"
; 1000007
;  ***
; "Elapsed time: 0.004412 msecs"
; 1000008
;  ***
; "Elapsed time: 3.99E-4 msecs"
; 1000009
;  ***
; "Elapsed time: 0.052053 msecs"
; 1000010
;  ***
; "Elapsed time: 3.98E-4 msecs"
; 1000011
;  ***
; "Elapsed time: 5.92E-4 msecs"
; 1000012
;  ***
; "Elapsed time: 4.23E-4 msecs"
; 1000013
;  ***
; "Elapsed time: 0.001226 msecs"
; 1000014
;  ***
; "Elapsed time: 4.07E-4 msecs"
; 1000015
;  ***
; "Elapsed time: 8.82E-4 msecs"
; 1000016
;  ***
; "Elapsed time: 3.78E-4 msecs"
; 1000017
;  ***
; "Elapsed time: 5.8E-4 msecs"
; 1000018
;  ***
; "Elapsed time: 4.03E-4 msecs"
; 1000019
;  ***
; "Elapsed time: 0.01412 msecs"
; 1000020
;  ***
; "Elapsed time: 3.98E-4 msecs"
; 1000021
;  ***
; "Elapsed time: 0.001781 msecs"
; 1000022
;  ***
; "Elapsed time: 3.98E-4 msecs"
; 1000023
;  ***
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; "Elapsed time: 5.79E-4 msecs"
; 1000024
;  ***
; "Elapsed time: 3.99E-4 msecs"
; 1000025
;  ***
; "Elapsed time: 8.84E-4 msecs"
; 1000026
;  ***
; "Elapsed time: 3.93E-4 msecs"
; 1000027
;  ***
; "Elapsed time: 0.001177 msecs"
; Prime number 1 after 1000 is 1009

; Prime number 2 after 1000 is 1013

; Prime number 3 after 1000 is 1019

; Prime number 1 after 10000 is 10007

; Prime number 2 after 10000 is 10009

; Prime number 3 after 10000 is 10037

; Prime number 1 after 100000 is 100003

; Prime number 2 after 100000 is 100019

; Prime number 3 after 100000 is 100043

; Prime number 1 after 1000000 is 1000003

; Prime number 2 after 1000000 is 1000033

; Prime number 3 after 1000000 is 1000037
; 1000028
;  ***
; "Elapsed time: 4.01E-4 msecs"
; 1000029
;  ***
; "Elapsed time: 5.84E-4 msecs"
; 1000030
;  ***
; "Elapsed time: 4.01E-4 msecs"
; 1000031
;  ***
; "Elapsed time: 0.00618 msecs"
; 1000032
;  ***
; "Elapsed time: 3.97E-4 msecs"
; 1000033
;  ***
; "Elapsed time: 0.192222 msecs"
; Prime number 2 after 1000000 is 1000033
; 1000034
;  ***
; "Elapsed time: 4.2E-4 msecs"
; 1000035
;  ***
; "Elapsed time: 5.89E-4 msecs"
; 1000036
;  ***
; "Elapsed time: 4.07E-4 msecs"
; 1000037
;  ***
; "Elapsed time: 0.17708 msecs"
; Prime number 3 after 1000000 is 1000037
