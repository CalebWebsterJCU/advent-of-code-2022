(ns advent-of-code-2022.day1.core_spec
  (:require [speclj.core :refer :all]
            [advent-of-code-2022.day1.core :refer :all]))

(def test-input "1000\r\n2000\r\n3000\r\n\r\n4000\r\n\r\n5000\r\n6000\r\n\r\n7000\r\n8000\r\n9000\r\n\r\n10000")

(describe "Day 1 Part 1"
          (it "Should parse input"
              (should= [[1000 2000 3000] [4000] [5000 6000] [7000 8000 9000] [10000]] (parse-input test-input))
              )
          (it "Should find the max calories"
              (should= 24000 (get-total-calories-of-top-elf (parse-input test-input)))
              )
          (it "Should solve the puzzle"
              (should= 71124 (solve-part-1 (slurp "spec/advent_of_code_2022/day1/input.txt"))))
          )

(describe "Day 1 Part 2"
          (it "Should find the total calories of the top three elves"
              (should= 45000 (get-total-calories-of-top-three (parse-input test-input)))
              )
          (it "Should solve the puzzle"
              (should= 204639 (solve-part-2 (slurp "spec/advent_of_code_2022/day1/input.txt")))
              )
          )