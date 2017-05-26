module Main where
import Prelude

someFunc :: (Num a) => a -> a -> a
someFunc a b = abs (a - b)

main = do
    [a, b] <- fmap ((map read) . words) getLine
    [c, d] <- fmap ((map read) . words) getLine
    [e, f] <- fmap ((map read) . words) getLine
    print (someFunc a b)
    print (someFunc c d)
    print (someFunc e f)