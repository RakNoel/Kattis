module Test where

import Data.Char

doubleMe x = x + x

nothing :: Char
nothing = toEnum 0
doubleAdd x y = x*2 + y*2
boomBangs xs = [ if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]

upp :: Char -> Char
upp x = if (fromEnum x) >= (fromEnum 'a') && (fromEnum x) <= (fromEnum 'z')
  then toEnum((fromEnum x) - 32)
  else toEnum(32)

toUpperCase xs = [ if (x `elem` ['A'..'Z']) then x else upp x | x <- xs]

removeLowerCase :: String -> String
removeLowerCase xs = [ x | x <- xs, x `elem` (' ':['A'..'Z'])]

bmiTell :: (RealFloat a) => a -> a -> String
bmiTell weight height
    | bmi <= skinny = "You're underweight, you emo, you!"
    | bmi <= normal = "You're supposedly normal. Pffft, I bet you're ugly!"
    | bmi <= fat    = "You're fat! Lose some weight, fatty!"
    | otherwise     = "You're a whale, congratulations!"
    where bmi = weight / height ^ 2
          (skinny, normal, fat) = (18.5, 25.0, 30.0)