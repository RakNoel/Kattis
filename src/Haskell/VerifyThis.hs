module Main where

readInput xs = map read (words xs)

main = interact (solve . readInput)

solve (x:xs) = if validGrid $ pair xs then "CORRECT" else "INCORRECT"

validGrid [] = True
validGrid [x] = True
validGrid (x:xs) = all (not . collide x) xs && validGrid xs

pair :: [t] -> [(t,t)]
pair [] = []
pair (x:y:xs) = (x,y) : pair xs

collide (a,b) (c,d) = x == y || x == 0 || y == 0
    where x = abs (a-c) ; y = abs (b-d)