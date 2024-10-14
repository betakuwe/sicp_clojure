(ns chapter-1.exercise-1-15)

(defn cube [x] (* x x x))

(defn p [x]
  (println "p called")
  (- (* 3 x) (* 4 (cube x))))

(defn sine [angle]
  (if (not (> (abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))

(println (sine 12.15)) ; -0.39980345741334 

;; a. p called 5 times
;; b. time and space O(log angle)
