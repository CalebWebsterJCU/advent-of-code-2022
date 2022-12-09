(ns advent-of-code-2022.day1.core_spec
  (:require [speclj.core :refer :all]
            [advent-of-code-2022.day1.core :as core]))

(def example-input "1000\r\n2000\r\n3000\r\n\r\n4000\r\n\r\n5000\r\n6000\r\n\r\n7000\r\n8000\r\n9000\r\n\r\n10000")
(def puzzle-input (slurp "spec/advent_of_code_2022/day1/input.txt"))

(describe "Day 1 Part 1"
          (it "Should solve the example"
              (should= 24000 (core/solve-part-1 example-input))
              )
          (it "Should solve the puzzle"
              (should= 71124 (core/solve-part-1 puzzle-input))
              )
          )

(describe "Day 1 Part 2"
          (it "Should solve the example"
              (should= 45000 (core/solve-part-2 example-input))
              )
          (it "Should solve the puzzle"
              (should= 204639 (core/solve-part-2 puzzle-input))
              )
          )