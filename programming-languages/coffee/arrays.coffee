# Arrays in CoffeeScript
# CoffeeScript provides concise array operations

# Array creation
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
fruits = ["apple", "banana", "cherry", "date", "elderberry"]
mixed = [1, "two", true, null, { name: "object" }]

# Array indexing (0-based, negative indices work from end)
first = numbers[0]
last = numbers[-1]
second = numbers[-2]

# Array slicing
slice1 = numbers[0...5]  # Exclusive end
slice2 = numbers[2..5]   # Inclusive end

# Array concatenation
combined = fruits.concat(numbers)

# Array length
count = fruits.length

# Array iteration
for fruit in fruits
  console.log fruit

# Array iteration with index
for fruit, index in fruits
  console.log "#{index}: #{fruit}"

# Array comprehension (with condition)
evens = (num for num in numbers when num % 2 == 0)
doubles = (num * 2 for num in numbers)

# Array mapping
squared = numbers.map (x) -> x * x

# Array filtering
greaterThan5 = numbers.filter (x) -> x > 5

# Array reducing
sum = numbers.reduce (acc, x) -> acc + x, 0
product = numbers.reduce (acc, x) -> acc * x, 1

# Array methods
fruits.push("fig")           # Add to end
fruits.unshift("apricot")    # Add to beginning
fruits.pop()                 # Remove from end
fruits.shift()               # Remove from beginning
fruits.splice(2, 1, "coconut") # Replace at index

# Finding elements
index = fruits.indexOf("cherry")
exists = "banana" in fruits

# Array destructuring
[a, b, c, ...rest] = numbers

# Array comprehension with object property
names = [
  { name: "Alice", age: 25 }
  { name: "Bob", age: 30 }
  { name: "Charlie", age: 35 }
]
ages = (person.age for person in names)

# Two-dimensional array
matrix = [
  [1, 2, 3]
  [4, 5, 6]
  [7, 8, 9]
]

