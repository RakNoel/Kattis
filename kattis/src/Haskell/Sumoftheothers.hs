module Main where
import Data.List

solve :: [Int] -> Int
solve xs = calculate xs (sum xs)

calculate :: [Int] -> Int -> Int
calculate (x:xs) tot
    | tot - x == x = x
    | otherwise = calculate xs tot

readLine :: String -> [Int]
readLine = (map read) . words

main :: IO()
main = interact (\x -> intercalate "\n" $ map (show . solve . readLine) (lines x))