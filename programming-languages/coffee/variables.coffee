# Variables in CoffeeScript
# CoffeeScript uses implicit variable declaration (no var, let, or const)

# String variable
firstName = "John"
lastName = "Doe"

# Number variable
age = 25
price = 19.99

# Boolean variable
isActive = true
isCompleted = false

# Array variable
fruits = ["apple", "banana", "orange", "grape"]
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Object variable
person =
  name: "Alice"
  age: 30
  city: "New York"
  country: "USA"

# Null and undefined
emptyValue = null
notDefined = undefined

# Constants (convention - use ALL_CAPS)
MAX_SIZE = 100
PI = 3.14159

# Updating variables
counter = 0
counter += 1
counter *= 2

# Variable assignment
x = 10
y = 20
z = x + y

# Chained assignment
a = b = c = 0

# Splat variables
coords = [1, 2, 3, 4, 5]
[first, second, third, rest...] = coords

# Conditional assignment
userName ?= "Guest"

# Existential operator
address = person?.address ? "Unknown"

