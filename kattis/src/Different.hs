module Main where

solve :: [Integer] -> [Integer]
solve xs =
    if length xs == 0
    then []
    else (abs ((xs !! 0) - (xs !! 1))) : solve (drop 2 xs)

--Input output
readInput = (map read) . words
writeOutput = unlines . (map show)

--Reads in, solves, prints out
main :: IO()
main = interact (writeOutput . solve . readInput)