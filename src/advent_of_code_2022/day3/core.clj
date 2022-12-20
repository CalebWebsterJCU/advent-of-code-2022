(ns advent-of-code-2022.day3.core
  (:require [clojure.string :as str])
  (:require [clojure.set :as set]))

(defn half-length [string]
  (/ (count string) 2))

(defn divide-into-compartments [rucksack-items]
  (split-at (half-length rucksack-items) rucksack-items))

(defn split-into-items [rucksack-string]
  (str/split rucksack-string #""))

(defn parse-rucksack [rucksack-string]
  (split-into-items rucksack-string))

(defn split-into-rucksacks [puzzle-input]
  (str/split-lines puzzle-input))

(defn parse-all-rucksacks [puzzle-input]
  (map parse-rucksack (split-into-rucksacks puzzle-input)))

(defn find-first-common-item [item-sets]
  (first (apply set/intersection (map set item-sets))))

(defn find-misplaced-item [rucksack]
    (find-first-common-item (divide-into-compartments rucksack)))

(defn find-all-misplaced-items [rucksacks]
  (map find-misplaced-item rucksacks))

(defn str-to-char [string]
  (.charAt string 0))

(defn get-ascii-code [char-string]
  (int (str-to-char char-string)))

(defn get-priority [item]
  (let [ascii-code (get-ascii-code item)]
    (if (> ascii-code 97) (- ascii-code 96) (- ascii-code 38))))

(defn get-priorities-of-items [items]
  (map get-priority items))

(defn group-into-elf-teams [rucksacks]
  (partition 3 rucksacks))

(defn find-team-badge [team-rucksacks]
  (find-first-common-item team-rucksacks))

(defn find-all-team-badges [teams]
  (map find-team-badge teams))

(defn solve-part-1 [puzzle-input]
  (->> (parse-all-rucksacks puzzle-input)
       (find-all-misplaced-items)
       (get-priorities-of-items)
       (apply +)))

(defn solve-part-2 [puzzle-input]
  (->> (parse-all-rucksacks puzzle-input)
       (group-into-elf-teams)
       (find-all-team-badges)
       (get-priorities-of-items)
       (apply +)))
