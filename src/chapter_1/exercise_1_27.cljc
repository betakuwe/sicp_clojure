(ns chapter-1.exercise-1-27)

(defn square [n] (* n n))

(defn expmod [base exp m]
  (cond (zero? exp) 1
        (even? exp) (mod (square (expmod base (quot exp 2) m))
                         m)
        :else (mod (* base (expmod base (dec exp) m))
                   m)))

(defn fermat-single-test? [n a]
  (= (expmod a n n) a))

(defn all-fermat-test? [n]
  (every? (partial fermat-single-test? n) (range 1 n))
  #_(loop [a 1]
      (cond (= a n) true
            (fermat-single-test? n a) (recur (inc a)))))

;; Carmichael numbers  561, 1105, 1729, 2465, 2821, and 6601
(doseq [n [561 1105 1729 2465 2821 6601]]
  (println n (all-fermat-test? n)))

; 561 true
; 1105 true
; 1729 true
; 2465 true
; 2821 true
; 6601 true
