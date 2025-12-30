# Destructuring in CoffeeScript
# Destructuring allows unpacking values from arrays/objects

# Array destructuring
numbers = [1, 2, 3, 4, 5]

# Basic array destructuring
[a, b, c] = numbers

# Array destructuring with rest
[first, second, third, ...rest] = numbers

# Skipping elements
[,,, fourth] = numbers

# Swapping variables
x = 1
y = 2
[x, y] = [y, x]

# Nested array destructuring
nested = [[1, 2], [3, 4], [5, 6]]
[[a, b], [c, d], [e, f]] = nested

# Object destructuring
person =
  name: "Alice"
  age: 30
  city: "Boston"
  country: "USA"

# Basic object destructuring
{ name, age } = person

# Object destructuring with new variable names
{ name: personName, age: personAge } = person

# Default values in destructuring
{ name, age = 25, country = "Unknown" } = person

# Nested object destructuring
company =
  name: "TechCorp"
  address:
    street: "123 Main St"
    city: "San Francisco"
  employees: 100

{ name: companyName, address: { city: companyCity } } = company

# Function parameter destructuring
createUser = ( { name, age, role = "user" } ) ->
  "#{name} is #{age} years old and is a #{role}"

user1 = createUser({ name: "Bob", age: 25 })
user2 = createUser({ name: "Carol", age: 28, role: "admin" })

# Array parameter destructuring
processPair = ( [first, second] ) ->
  "First: #{first}, Second: #{second}"

# Mixed destructuring
config =
  server:
    host: "localhost"
    port: 3000
  features: ["auth", "database", "cache"]

{ server: { host, port }, features: [primaryFeature, ...otherFeatures] } = config

# Destructuring in comprehensions
users = [
  { name: "Alice", scores: [85, 90, 78] }
  { name: "Bob", scores: [70, 75, 80] }
]

names = ( { name } for { name, scores } in users )

# Destructuring with splat
fullName = ["John", "Michael", "Doe"]
[first, middle, ...last] = fullName

# Practical example - parsing CSV-like data
parseLine = (line) ->
  [id, name, email] = line.split(",")

line = "1,John Doe,john@example.com"
{ 0: id, 1: name, 2: email } = parseLine(line)

