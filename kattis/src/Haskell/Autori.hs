module Main where

solve :: String -> String
solve xs = [ x | x <- xs, (x <= 'Z') && (x >= 'A') ]

main :: IO()
main = interact solve