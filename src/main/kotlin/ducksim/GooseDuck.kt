package ducksim

import java.awt.Color

class GooseDuck : Duck(FlyWithWings(), QuackNormal()) {
    val goose = Goose();

    override val color: Color = Color.BLUE
    override val quackText: String = goose.honkText;
    override fun display() = goose.name
}
