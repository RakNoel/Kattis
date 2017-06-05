module Main where

solve :: [Int] -> Int
solve xs = calculate xs (sum xs)

calculate :: [Int] -> Int -> Int
calculate [x] _ = x
calculate xs tot
    | tot - h == h = h
    |otherwise = calculate (drop 1 xs) tot
    where h = head xs

readLine :: String -> [Int]
readLine = (map read) . words

main :: IO()
main = interact $ show . solve . readLine