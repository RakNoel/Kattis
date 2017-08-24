module Main where

solve :: [Integer] -> [Integer]
solve [x,y] = [(((y-1)*x)+1)]

--Input output
readInput = (map read) . words
writeOutput = unlines . (map show)

--Reads in, solves, prints out
main :: IO()
main = interact $ writeOutput . solve . readInput