package ducksim

abstract class Bling(val wrappedDuck: Duck) : Duck(wrappedDuck.defaultFlyBehavior, wrappedDuck.deafaultQuackBehavior) {

    // 1. make sure you are always calling through to the wrapped duck in your bling class
    // 2. create a honkQuack quack behavior and pass that in to the duck constructor
}