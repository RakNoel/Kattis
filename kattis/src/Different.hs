module Main where
import Prelude
import Control.Monad

someFunc :: (Num a) => a -> a -> a
someFunc a b = abs (a - b)

main :: IO()
main = do
    fLine <- getLine
    if null fLine
        then return()
        else do
            let readline = words fLine in
                print (someFunc (read (head readline)) (read (last readline)))
            main