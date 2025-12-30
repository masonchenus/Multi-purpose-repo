# Loops in CoffeeScript
# CoffeeScript provides various loop constructs

# Basic for loop
for i in [1..5]
  console.log "Iteration #{i}"

# For loop with step (by using array slicing)
for i in [0..10] by 2
  console.log "Even number: #{i}"

# For loop over array
fruits = ["apple", "banana", "cherry"]
for fruit in fruits
  console.log fruit

# For loop with index
for fruit, index in fruits
  console.log "#{index}: #{fruit}"

# For loop over object
person = name: "Alice", age: 30, city: "Boston"
for key, value of person
  console.log "#{key}: #{value}"

# While loop
count = 5
while count > 0
  console.log "Countdown: #{count}"
  count -= 1

# Until loop (equivalent to while not)
until count >= 5
  count += 1
  console.log "Counting up: #{count}"

# Loop with guard condition
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
evens = []
for num in numbers when num % 2 == 0
  evens.push(num)

# Loop with break
for num in numbers
  break if num > 5
  console.log "Processing: #{num}"

# Loop with continue
odds = []
for num in numbers
  continue if num % 2 == 0
  odds.push(num)

# Loop with index and condition
for num, i in numbers when i < 5
  console.log "Index #{i}: #{num}"

# Nested loops
matrix = [[1, 2], [3, 4], [5, 6]]
for row in matrix
  for cell in row
    console.log cell

# Array comprehension with loop (creates new array)
squares = (x * x for x in [1..5])

# Object comprehension (creates new object)
squaresObj = ({ number: x, square: x * x } for x in [1..5])

# Loop with postfix condition
console.log "Checking primes..."
for num in [2..20]
  isPrime = true
  for i in [2..Math.sqrt(num)]
    if num % i == 0
      isPrime = false
      break
  console.log "#{num} is prime" if isPrime

# Comprehensions with assignment
results = []
results.push(x) for x in [1..10] when x % 3 == 0

