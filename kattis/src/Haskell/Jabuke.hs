module Main where

area' :: (Num a) => [(Int, Int)] -> a
area' [(a1,b1),(a2,b2),(a3,b3)] = 0

numTrees' :: (Num a) => [(Int, Int)] -> a
numTrees' [(a1,b1),(a2,b2),(a3,b3)] = 0

readLine :: String -> [a]
readLine = (map read) . words

readVector :: [Int] -> (Int, Int)
readVector [a,b] = (a,b)
readVector _ = 0

main :: IO()
main = do
    let vectors = (readVector . readLine . getLine, readVector $ readLine . getLine, readVector $ readLine . getLine)
        trees = readLine . getLine in
            show . area' vectors
            show . numTrees' vectors trees