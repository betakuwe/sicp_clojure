(ns chapter-1.exercise-1-28)

(defn square [n] (* n n))

(defn expmod [base exp m]
  (cond (zero? exp) 1
        (even? exp) (let [expmod-result (expmod base (quot exp 2) m)]
                      (if (#{1 (dec m)} expmod-result)
                        0
                        (mod (square expmod-result) m)))
        :else (mod (* base (expmod base (dec exp) m))
                   m)))

(defn expmod-test? [n a]
  (zero? (expmod a (dec n) n)))

(defn miller-rabin-all? [n]
  (every? (partial expmod-test? n) (range 1 n)))

;; Carmichael numbers  561, 1105, 1729, 2465, 2821, and 6601
(doseq [n [561 1105 1729 2465 2821 6601]]
  (println n (miller-rabin-all? n)))

; 561 false
; 1105 false
; 1729 false
; 2465 false
; 2821 false
; 6601 false

;; Prime numbers
(doseq [n [1009 1013 1019 10007 10009 10037
           100003 100019 100043 1000003 1000033 1000037]]
  (println n (miller-rabin-all? n)))

; 1009 true
; 1013 true
; 1019 true
; 10007 true
; 10009 true
; 10037 true
; 100003 true
; 100019 true
; 100043 true
; 1000003 true
; 1000033 true
; 1000037 true
