package ducksim

import java.awt.Color

class RedheadDuck : Duck() {
    override val color: Color = Color.RED
    override val quackText: String = "Quack!"
    override fun display() = "Redhead"
}