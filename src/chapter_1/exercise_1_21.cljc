(ns chapter-1.exercise-1-21)

(defn smallest-divisor [n]
  (loop [test-divisor 2]
    (cond
      (> (* test-divisor test-divisor) n) n
      (zero? (mod n test-divisor)) test-divisor
      :else (recur (inc test-divisor)))))

(doseq [n [199 1999 19999]]
  (println "smallest divisor of" n "is" (smallest-divisor n)))
; smallest divisor of 199 is 199
; smallest divisor of 1999 is 1999
; smallest divisor of 19999 is 7
