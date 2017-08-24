module Main where

solve :: (RealFrac a, Floating a) => [a] -> Int
solve [x,y] = ceiling (x / (sin (radians y)))

radians deg = (pi / 180) * deg

readInput = (map read) . words

--Reads in, solves, prints out
main :: IO()
main = interact $ show . solve . readInput