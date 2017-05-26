module Main where
import Prelude

someFunc :: (Num a) => a -> a -> a
someFunc a b = abs (a - b)

main = do
    [n, m] <- fmap ((map read) . words) getLine
    print (someFunc n m)