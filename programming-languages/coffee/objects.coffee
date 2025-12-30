# Objects in CoffeeScript
# CoffeeScript provides elegant object manipulation

# Object creation (key: value syntax)
person =
  name: "Alice"
  age: 30
  city: "Boston"
  isStudent: false

# Nested objects
company =
  name: "TechCorp"
  address:
    street: "123 Main St"
    city: "San Francisco"
    zip: "94102"
  employees: 100
  founded: 2020

# Object with methods
calculator =
  add: (a, b) -> a + b
  subtract: (a, b) -> a - b
  multiply: (a, b) -> a * b
  divide: (a, b) -> a / b if b isnt 0

# Object property access
name = person.name
city = person["city"]

# Object destructuring
{ name, age } = person
{ name: companyName, employees: employeeCount } = company

# Updating properties
person.age = 31
person.job = "Engineer"

# Deleting properties
delete person.isStudent

# Object iteration
for key, value of person
  console.log "#{key}: #{value}"

# Object.keys and Object.values
keys = Object.keys(person)
values = Object.values(person)

# Object spread
defaults =
  theme: "light"
  language: "en"
  notifications: true

userSettings =
  theme: "dark"
  ...defaults

# Object merging
baseConfig =
  apiUrl: "https://api.example.com"
  timeout: 3000

config =
  ...baseConfig
  timeout: 5000
  debug: true

# Object comprehension (from array)
users = [
  { name: "Alice", role: "admin" }
  { name: "Bob", role: "user" }
  { name: "Charlie", role: "user" }
]

userMap = {}
for user in users
  userMap[user.name] = user.role

# Object with computed property names
prefix = "user"
id = 123
userObj =
  ["#{prefix}Name"]: "David"
  ["#{prefix}Id"]: id

# Checking properties
hasName = "name" of person
hasEmail = "email" of person

