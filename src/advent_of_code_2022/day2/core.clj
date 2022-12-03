(ns advent-of-code-2022.day2.core
  (:require [clojure.string :as str]))

(defn get-weapon-needed-to-achieve-result [opponents-weapon result]
  (if (= :draw result)
    opponents-weapon
    (case opponents-weapon
      "rock" (if (= :win result) "paper" "scissors")
      "paper" (if (= :win result) "scissors" "rock")
      "scissors" (if (= :win result) "rock" "paper")
      )))

(defn get-result-given-both-weapons [opponents-weapon your-weapon]
  (if (= opponents-weapon your-weapon)
    :draw
    (case opponents-weapon
      "rock" (if (= your-weapon "paper") :win :lose)
      "paper" (if (= your-weapon "scissors") :win :lose)
      "scissors" (if (= your-weapon "rock") :win :lose)
      )))

(def letter-to-weapon {
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

(def weapon-scores {
                    "rock"     1
                    "paper"    2
                    "scissors" 3
                    })

(def result-scores {
                    :win  6
                    :lose 0
                    :draw 3
                    })

(defn split-by-space [string] (str/split string #" "))

(defn parse-input [test-input]
  (map split-by-space (str/split-lines test-input))
  )

(defn calc-round-score [your-weapon result]
  (+ (get weapon-scores your-weapon) (get result-scores result))
  )

(defn get-round-score-for-part-1 [[letter1 letter2]]
  (let [opponents-choice (get letter-to-weapon letter1)
        your-choice (get letter-to-weapon letter2)
        result (get-result-given-both-weapons opponents-choice your-choice)]
    (calc-round-score your-choice result)
    ))

(defn get-round-score-for-part-2 [[letter1 letter2]]
  (let [opponents-weapon (get letter-to-weapon letter1)
        desired-result (get letter-to-result letter2)
        your-weapon (get-weapon-needed-to-achieve-result opponents-weapon desired-result)]
    (calc-round-score your-weapon desired-result)
    ))

(defn solve-part-1 [input-str]
  (apply + (map get-round-score-for-part-1 (parse-input input-str))))

(defn solve-part-2 [input-str]
  (apply + (map get-round-score-for-part-2 (parse-input input-str))))
