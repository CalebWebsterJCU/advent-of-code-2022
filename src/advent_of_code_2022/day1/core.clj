(ns advent-of-code-2022.day1.core
  (:require [clojure.string :as str]))

(defn parse-ints [coll] (map #(Integer/parseInt %) coll))

(defn split-double-lines [str] (str/split str #"\r\n\r\n"))

(defn parse-input [input-str]
  (map parse-ints (map str/split-lines (split-double-lines input-str)))
  )

(defn get-bag-total [food-bag] (apply + food-bag))

(defn get-bag-totals [food-bags] (map get-bag-total food-bags))

(defn get-total-calories-of-top-elf [food-bags]
  (apply max (get-bag-totals food-bags))
  )

(defn get-total-calories-of-top-three [food-bags]
  (apply + (take 3 (sort > (get-bag-totals food-bags))))
  )

(defn solve-part-1 [input-str]
  (get-total-calories-of-top-elf (parse-input input-str))
  )

(defn solve-part-2 [input-str]
  (get-total-calories-of-top-three (parse-input input-str))
  )

