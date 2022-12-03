(ns advent-of-code-2022.day2.core-spec
  (:require [speclj.core :refer :all]
            [advent-of-code-2022.day2.core :refer :all]))

(def test-input "A Y\r\nB X\r\nC Z")

(describe "Day 2 Part 1"
          (it "Should parse input"
              (should= [["A" "Y"] ["B" "X"] ["C" "Z"]] (parse-input test-input))
              )
          (it "Should return the correct result"
              (should= :win (get-result-given-both-weapons "rock" "paper"))
              (should= :lose (get-result-given-both-weapons "paper" "rock"))
              (should= :draw (get-result-given-both-weapons "scissors" "scissors"))
              )
          (it "Should calculate the total score"
              (should= 15 (solve-part-1 test-input))
              )
          (it "Should solve the puzzle"
              (should= 14069 (solve-part-1 (slurp "spec/advent_of_code_2022/day2/input.txt")))
              )
          )

(describe "Day 2 Part 2"
          (it "Should calculate the total score"
              (should= 12 (solve-part-2 test-input))
              )
          (it "Should solve the puzzle"
              (should= 12411 (solve-part-2 (slurp "spec/advent_of_code_2022/day2/input.txt")))
              )
          )