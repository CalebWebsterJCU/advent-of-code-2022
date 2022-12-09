(ns advent-of-code-2022.day2.core-spec
  (:require [speclj.core :refer :all]
            [advent-of-code-2022.day2.core :as day2]))

(def example-input "A Y\r\nB X\r\nC Z")
(def puzzle-input (slurp "spec/advent_of_code_2022/day2/input.txt"))

(describe "Day 2 Part 1"
          (it "Should solve the example"
              (should= 15 (day2/solve-part-1 example-input))
              )
          (it "Should solve the puzzle"
              (should= 14069 (day2/solve-part-1 puzzle-input))
              )
          )

(describe "Day 2 Part 2"
          (it "Should solve the example"
              (should= 12 (day2/solve-part-2 example-input))
              )
          (it "Should solve the puzzle"
              (should= 12411 (day2/solve-part-2 puzzle-input))
              )
          )