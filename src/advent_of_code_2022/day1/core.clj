(ns advent-of-code-2022.day1.core
  (:require [clojure.string :as str]))

(defn parse-calorie-value [snack-string] (Integer/parseInt snack-string))

(defn split-into-snacks [basket-string] (str/split-lines basket-string))

(defn split-into-baskets [puzzle-input] (str/split puzzle-input #"\r\n\r\n"))

(defn get-basket-total [basket] (apply + basket))

(defn get-totals-of-all-baskets [baskets] (map get-basket-total baskets))

(defn get-total-of-fullest-basket [baskets]
  (apply max (get-totals-of-all-baskets baskets))
  )

(defn get-total-of-three-fullest-baskets [baskets]
  (apply + (take 3 (sort > (get-totals-of-all-baskets baskets))))
  )

(defn parse-basket [basket-string]
  (map parse-calorie-value (split-into-snacks basket-string))
  )

(defn parse-all-baskets [puzzle-input]
  (map parse-basket (split-into-baskets puzzle-input))
  )

(defn solve-part-1 [puzzle-input]
  (get-total-of-fullest-basket (parse-all-baskets puzzle-input))
  )

(defn solve-part-2 [puzzle-input]
  (get-total-of-three-fullest-baskets (parse-all-baskets puzzle-input))
  )

