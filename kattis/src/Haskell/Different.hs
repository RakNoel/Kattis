module Main where

solve :: [Int] -> Int
solve [a,b] = abs (a - b)
solve _ = 0

--Input output
readInput = (map read) . words

--Reads in, solves, prints out
main :: IO()
main = interact (show . solve . readInput)