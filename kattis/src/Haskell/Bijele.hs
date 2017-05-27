module Main where

solve :: [Integer] -> [Integer]
solve [k,q,r,b,kn,p] = [1-k,1-q,2-r,2-b,2-kn,8-p]

--Input output
readInput = (map read) . words
writeOutput = unlines . (map show)

--Reads in, solves, prints out
main :: IO()
main = interact (writeOutput . solve . readInput)