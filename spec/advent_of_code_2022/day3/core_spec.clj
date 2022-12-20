(ns advent-of-code-2022.day3.core-spec
  (:require [speclj.core :refer :all]
            [advent-of-code-2022.day3.core :as day3]))

(def example-input "vJrwpWtwJgWrhcsFMMfFFhFp\r\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\r\nPmmdzqPrVvPwwTWBwg\r\nwMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\r\nttgJtRGJQctTZtZT\r\nCrZsJsPPZsGzwwsLwLmpwMDw")
(def puzzle-input (slurp "spec/advent_of_code_2022/day3/input.txt"))

(describe "Day 3 Part 1"
          (it "Should solve the example"
              (should= 157 (day3/solve-part-1 example-input))
              )
          (it "Should solve the puzzle"
              (should= 7737 (day3/solve-part-1 puzzle-input))
              )
          )
(describe "Day 3 Part 2"
          (it "Should solve the example"
              (should= 70 (day3/solve-part-2 example-input))
              )
          (it "Should solve the puzzle"
              (should= 2697 (day3/solve-part-2 puzzle-input))
              )
          )
