# Cinema-Room-Manager
Kotlin Basics Project138 of HyperSkill.org

Things I learned:


Use `MutableList` for multidimensional dynamic list creation, reference: https://hyperskill.org/learn/step/15127
``` Kotlin
val data = MutableList(nRows) { MutableList(nCols) { false } }
```


Use `String.format` for formatting strings (integers, floats, HEX, etc.). reference: https://hyperskill.org/learn/step/21438
``` Kotlin
println("Percentage: ${"%.2f%%".format(occupiedSeats * 100.0 / totalSeats)}")
```
In the above code, one percentage sign is used to escape another percentage sign, so it's used as a character.
