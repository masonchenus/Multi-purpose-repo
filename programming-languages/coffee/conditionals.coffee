# Conditionals in CoffeeScript
# CoffeeScript provides clean conditional syntax

# Simple if statement
temperature = 25
if temperature > 30
  console.log "It's hot outside!"

# If-else statement
score = 75
if score >= 60
  console.log "You passed!"
else
  console.log "You failed!"

# If-else if-else chain
grade = (score) ->
  if score >= 90 then "A"
  else if score >= 80 then "B"
  else if score >= 70 then "C"
  else if score >= 60 then "D"
  else "F"

# Unless statement (inverse of if)
isRaining = true
unless isRaining
  console.log "No rain, let's go outside!"
else
  console.log "It's raining, bring an umbrella!"

# Ternary operator
status = if age >= 18 then "Adult" else "Minor"

# Switch statement (using when)
day = new Date().getDay()
dayName = switch day
  when 0 then "Sunday"
  when 1 then "Monday"
  when 2 then "Tuesday"
  when 3 then "Wednesday"
  when 4 then "Thursday"
  when 5 then "Friday"
  when 6 then "Saturday"
  else "Unknown"

# Switch with ranges
getSpeedCategory = (speed) ->
  switch
    when speed < 30 then "Slow"
    when speed < 60 then "Medium"
    when speed < 100 then "Fast"
    else "Very Fast"

# Conditional assignment with ?
userName ?= "Guest User"

# Existential operator
data = null
value = data?.property ? "default value"

# Boolean conditions
isActive = true
isVerified = false

# AND operator
canAccess = isActive and isVerified

# OR operator
fallbackValue = primaryValue || secondaryValue

# NOT operator
isDisabled = not isActive

# Combined conditions
hasPermission = (isAdmin or isOwner) and not isSuspended

# Pattern matching with case
response = 404
message = switch response
  when 200 then "Success"
  when 301, 302 then "Redirect"
  when 404 then "Not Found"
  when 500 then "Server Error"
  else "Unknown Status"

# Inline conditionals
console.log "Adult" if age >= 18

# Chained conditionals
validateInput = (input) ->
  return "Empty" unless input?
  return "Too short" if input.length < 3
  return "Too long" if input.length > 50
  return "Valid"

