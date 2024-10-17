(ns chapter-1.exercise-1-28)

(defn square [n] (* n n))

(defn expmod [base exp m]
  (cond (zero? exp) 1
        (even? exp) (let [expmod-result (expmod base (quot exp 2) m)]
                      (if ([1 (dec m)] expmod-result)
                        0
                        (mod (square expmod-result) m)))
        :else (mod (* base (expmod base (dec exp) m))
                   m)))

(defn fermat-single-test? [n a]
  (= (expmod a (dec n) n) 1))

(defn all-fermat-test? [n]
  (every? (partial fermat-single-test? n) (range 1 n)))

;; Carmichael numbers  561, 1105, 1729, 2465, 2821, and 6601
(doseq [n [561 1105 1729 2465 2821 6601]]
  (println n (all-fermat-test? n)))

; 561 true
; 1105 true
; 1729 true
; 2465 true
; 2821 true
; 6601 true

;; Prime numbers
(doseq [n [1009 1013 1019 10007 10009 10037 100003 100019 100043 1000003 1000033 1000037]]
  (println n (all-fermat-test? n)))
