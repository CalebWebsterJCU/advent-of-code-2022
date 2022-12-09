(ns advent-of-code-2022.day2.core
  (:require [clojure.string :as str]))

(defn get-choice-needed-to-achieve-result [opponents-choice result]
  (if (= :draw result)
    opponents-choice
    (case opponents-choice
      "rock" (if (= :win result) "paper" "scissors")
      "paper" (if (= :win result) "scissors" "rock")
      "scissors" (if (= :win result) "rock" "paper")
      )))

(defn get-result-given-both-choices [opponents-choice your-choice]
  (if (= opponents-choice your-choice)
    :draw
    (case opponents-choice
      "rock" (if (= your-choice "paper") :win :lose)
      "paper" (if (= your-choice "scissors") :win :lose)
      "scissors" (if (= your-choice "rock") :win :lose)
      )))

(def letter-to-choice {
                       "A" "rock"
                       "B" "paper"
                       "C" "scissors"
                       "X" "rock"
                       "Y" "paper"
                       "Z" "scissors"
                       })

(def letter-to-result {
                       "X" :lose
                       "Y" :draw
                       "Z" :win
                       })

(def get-score-for-choice {
                           "rock"     1
                           "paper"    2
                           "scissors" 3
                           })

(def get-score-for-result {
                           :win  6
                           :lose 0
                           :draw 3
                           })

(defn parse-round [round-string] (str/split round-string #" "))

(defn split-into-rounds [puzzle-input] (str/split-lines puzzle-input))

(defn parse-all-rounds [puzzle-input]
  (map parse-round (split-into-rounds puzzle-input))
  )

(defprotocol Strategy
  (calc-round-score [this round])
  )

(defrecord FirstStrategy []
  Strategy
  (calc-round-score [this round]
    (let [opponents-choice (letter-to-choice (get round 0))
          your-choice (letter-to-choice (get round 1))
          result (get-result-given-both-choices opponents-choice your-choice)]
      (+ (get-score-for-choice your-choice) (get-score-for-result result))
      ))
  )

(defrecord SecondStrategy []
  Strategy
  (calc-round-score [this round]
    (let [opponents-choice (letter-to-choice (get round 0))
          desired-result (letter-to-result (get round 1))
          recommended-choice (get-choice-needed-to-achieve-result opponents-choice desired-result)]
      (+ (get-score-for-choice recommended-choice) (get-score-for-result desired-result))
      ))
  )

(defn calc-round-scores-using-strategy [strategy rounds]
  (map #(calc-round-score strategy %) rounds)
  )

(defn solve-part-1 [puzzle-input]
  (apply + (calc-round-scores-using-strategy (FirstStrategy.) (parse-all-rounds puzzle-input)))
  )

(defn solve-part-2 [puzzle-input]
  (apply + (calc-round-scores-using-strategy (SecondStrategy.) (parse-all-rounds puzzle-input)))
  )
