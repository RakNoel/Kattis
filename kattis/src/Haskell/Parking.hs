module Main where

--Main solution function
solve :: [Int] -> Int
solve xs = do

    where priceList = take 3 xs

--Find times
findTimes

--Pseudo code!!
--eks
-- D1 = [2-6] == [1..6]
-- D2 = [2-3] == [2..3]
-- D3 = [3-5] == [3..5]
-- Tot = D1++D2++D3

-- [1,2,3,4,5,6]    1st
--   [2,3]          2nd
--     [3,4,5]      3rd
--
-- C = length [1 | x <- D1, y <- D2, z <- D3] -> 1
-- B = length [1 | x <- Tot]
-- A = length []
--
-- -]

--Input output
readInput = (map read) . words

--Reads in, solves, prints out
main :: IO()
main = do
    interact (show . solve . readInput)