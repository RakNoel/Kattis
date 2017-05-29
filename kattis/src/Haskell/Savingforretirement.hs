module Main where

calculate :: [Int] -> Int
calculate [bNow,bRetire,bSave,aAge,aSave] = ((bSave * (bRetire - bNow)) `quot` aSave) + aAge + 1
calculate _ = 0

readLine :: String -> [Int]
readLine = (map read) . words

main :: IO()
main = interact $ show . calculate . readLine