(ns chapter-1.exercise-1-12)

(defn pascal
  [row col]
  (cond
    (or (<= row 0) (<= col 0) (< row col)) 0
    (or (= 1 col) (= row col)) 1
    :else (+ (pascal (dec row) (dec col))
             (pascal (dec row) col))))

(doseq [row (range 1 10)]
  (apply println
         (for [col (range 1 (inc row))]
           (pascal row col))))

; 1
; 1 1
; 1 2 1
; 1 3 3 1
; 1 4 6 4 1
; 1 5 10 10 5 1
; 1 6 15 20 15 6 1
; 1 7 21 35 35 21 7 1
; 1 8 28 56 70 56 28 8 1
