package ducksim

import java.awt.Color

class RubberDuck : Duck(FlyNoWay(), QuackNormal()) {
    override val color: Color = Color.YELLOW
    override val quackText: String = "Squeak!"
    override fun display() = "Rubber"
}