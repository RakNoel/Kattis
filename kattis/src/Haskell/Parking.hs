module Main where

solve :: [Int] -> Int
solve xs = length [x | x <- xs, x < 0]

--Input output
readInput = (map read) . words

--Reads in, solves, prints out
main :: IO()
main = do
    interact (show . solve . readInput)