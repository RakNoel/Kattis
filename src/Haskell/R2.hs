module Main where

solve :: [Integer] -> Integer
solve [a,b] = (( b * 2) - a)

--Input output
readInput = (map read) . words

--Reads in, solves, prints out
main :: IO()
main = interact (show . solve . readInput)