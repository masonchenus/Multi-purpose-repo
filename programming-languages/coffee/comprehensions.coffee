# Comprehensions in CoffeeScript
# Comprehensions provide concise syntax for creating new arrays/objects

# Basic array comprehension
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Create new array with operation
squares = (n * n for n in numbers)

# Create new array with condition
evens = (n for n in numbers when n % 2 == 0)
odds = (n for n in numbers when n % 2 == 1)

# Create new array with index
indexed = ("#{i}: #{n}" for n, i in numbers)

# Nested comprehension (flattening)
matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
flat = (num for row in matrix for num in row)

# Object comprehension (from array)
users = [
  { name: "Alice", age: 25, role: "admin" }
  { name: "Bob", age: 30, role: "user" }
  { name: "Charlie", age: 35, role: "user" }
]

# Create object from array
userNames = (user.name for user in users)
userAges = (user.age for user in users)

# Object with key-value pairs
userMap = {}
userMap[user.name] = user.age for user in users

# Complex object comprehension
adminUsers = ({ name: user.name, level: "admin" } for user in users when user.role is "admin")

# Dictionary comprehension
squaresDict = {}
squaresDict[n] = n * n for n in [1..5]

# Set comprehension (using object keys)
uniqueSquares = {}
squaresDict[n] = n for n in [1, 2, 2, 3, 3, 3, 4]

# Filter and map combined
processed = (
  { name: user.name, adult: user.age >= 18 }
  for user in users
  when user.age >= 18
)

# Comprehension with multiple conditions
specialNumbers = (
  n for n in [1..100]
  when n % 2 == 0
  when n % 3 == 0
  when n % 5 == 0
)

# Transform and filter
names = ["alice", "BOB", "Charlie", "diana"]
capitalized = (name.charAt(0).toUpperCase() + name[1...].toLowerCase() for name in names when name.length > 3)

# Nested conditionals in comprehension
data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
result = (
  if n % 2 == 0 then "even:#{n}" else "odd:#{n}"
  for n in data
  when n > 3
)

# Using comprehensions with functions
applyOperation = (arr, operation) ->
  (operation(x) for x in arr)

squared = applyOperation([1, 2, 3, 4], (x) -> x * x)

