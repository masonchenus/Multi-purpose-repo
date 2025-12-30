# Classes in CoffeeScript
# CoffeeScript provides class-based OOP support

# Basic class definition
class Animal
  constructor: (name) ->
    @name = name
    @hunger = 0

  eat: (amount) ->
    @hunger = Math.max(0, @hunger - amount)
    "#{@name} ate #{amount} food. Hunger: #{@hunger}"

  speak: ->
    "#{@name} makes a sound"

# Inheritance
class Dog extends Animal
  constructor: (name, breed) ->
    super(name)
    @breed = breed

  speak: ->
    "#{@name} barks: Woof!"

  fetch: ->
    "#{@name} fetches the ball"

# Another inheritance example
class Cat extends Animal
  constructor: (name, color) ->
    super(name)
    @color = color

  speak: ->
    "#{@name} meows: Meow!"

  purr: ->
    "#{@name} purrs contentedly"

# Class with static methods
class MathHelper
  @PI: 3.14159

  @square: (x) -> x * x

  @circleArea: (radius) ->
    @PI * @square(radius)

# Class with getters and setters (using simple methods)
class Temperature
  constructor: (celsius) ->
    @_celsius = celsius

  celsius: ->
    @_celsius

  fahrenheit: ->
    (@_celsius * 9/5) + 32

  setCelsius: (value) ->
    @_celsius = value

# Using the classes
animal = new Animal("Generic Animal")
dog = new Dog("Rex", "German Shepherd")
cat = new Cat("Whiskers", "Orange")

console.log animal.speak()
console.log dog.speak()
console.log dog.fetch()
console.log cat.speak()
console.log cat.purr()

console.log MathHelper.circleArea(5)

