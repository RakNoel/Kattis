module Main where

solve :: [Int] -> Int
solve xs = calculate xs (sum xs)

calculate :: [Int] -> Int -> Int
calculate [] _ = error "No solution"
calculate (x:xs) tot
    | tot - x == x = x
    | tot - x == 0 = x
    | otherwise = calculate xs tot

readLine :: String -> [Int]
readLine = (map read) . words

main :: IO()
main = interact $ show . solve . readLine