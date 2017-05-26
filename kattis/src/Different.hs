module Different where
import Prelude

someFunc :: (Num a) => a -> a -> a
someFunc a b = abs (a - b)

getNumbers :: IO()
getNumbers = do
    [n, m] <- fmap ((map read) . words) getLine
    putStrLn read someFunc n m