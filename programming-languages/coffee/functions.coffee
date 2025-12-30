# Functions in CoffeeScript
# CoffeeScript has multiple ways to define functions

# Basic function declaration
greet = (name) ->
  "Hello, #{name}!"

# Function with multiple parameters
add = (a, b, c) ->
  a + b + c

# Function with default parameters
multiply = (a, b = 2) ->
  a * b

# Function with rest parameters
sum = (args...) ->
  total = 0
  for arg in args
    total += arg
  total

# Arrow function (single expression)
square = (x) -> x * x

# Arrow function with implicit return
cube = (x) -> x * x * x

# Function with conditional logic
absolute = (num) ->
  if num >= 0 then num else -num

# Function with else if
getGrade = (score) ->
  if score >= 90 then "A"
  else if score >= 80 then "B"
  else if score >= 70 then "C"
  else if score >= 60 then "D"
  else "F"

# Function with object parameter
createUser = (name, age, role = "user") ->
  { name, age, role, createdAt: new Date() }

# Higher-order function
applyOperation = (a, b, operation) ->
  operation(a, b)

# Closure example
counterFactory = ->
  count = 0
  ->
    count += 1
    count

# Immediately Invoked Function Expression (IIFE)
do ->
  temp = "This runs immediately"
  console.log temp

# Recursive function
factorial = (n) ->
  return 1 if n <= 1
  n * factorial(n - 1)

# Using the functions
console.log greet("World")
console.log add(1, 2, 3)
console.log multiply(5)
console.log sum(1, 2, 3, 4, 5)
console.log square(4)
console.log getGrade(85)
user = createUser("Bob", 25, "admin")
console.log applyOperation(10, 5, (a, b) -> a + b)

