module Main where

solve :: [Int] -> Int
solve [x] = binaryToInt' $ reverse $ intToBinary' x
solve _ = 0

intToBinary' :: Int -> [Int]
intToBinary' 0 = []
intToBinary' x
    | x `mod` 2 == 0 = intToBinary' (x `div` 2) ++ [0]
    | x `mod` 2 == 1 = intToBinary' (x `div` 2) ++ [1]

binaryToInt' :: [Int] -> Int
binaryToInt' [] = 0
binaryToInt' xs = ((head xs) * (2 ^ ((length xs) - 1))) + binaryToInt' (drop 1 xs)


readLine :: String -> [Int]
readLine = (map read) . words

main :: IO()
main = interact $ show . solve . readLine