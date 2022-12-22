package ducksim

import java.awt.Color

abstract class Duck(
    val defaultFlyBehavior: FlyBehavior = FlyWithWings(),
    val deafaultQuackBehavior: QuackBehavior = QuackNormal()
) : Observer {

    // values that can be overridden
    open val color: Color = Color.BLACK
    open val quackText: String = "Quack!"

    // variables that can be changed only by functions in this class
    var flyBehavior: FlyBehavior = defaultFlyBehavior
        private set

    var quackBehavior: QuackBehavior = deafaultQuackBehavior
        private set

    var state = State.SWIMMING
        private set
    var isFree = true
        private set
    var isOnDSWC = false
        private set

    // function for setting the state back to its default (swimming)
    fun swim() {
        state = State.SWIMMING
    }

    // functions from the context menu
    open fun fly() {
        state = flyBehavior.state
    }

    open fun quack() {
        state = quackBehavior.state
    }

    open val joinDSCW = object : DuckMenuItem {
        override fun invoke() {
            doJoin()
        }
    }

    fun doJoin() {
        val duckWC = DuckFactory.registerObserver(this@Duck)
        isOnDSWC = true
    }

    open val quitDSCW = object : DuckMenuItem {
        override fun invoke() {
            doQuit()
        }
    }

    fun doQuit() {
        val duckWC = DuckFactory.removeObserver(this@Duck)
        isOnDSWC = false
    }

    open val capture = object : DuckMenuItem {
        override fun invoke() {
            doCapture()
        }
    }

    fun doCapture() {
        isFree = false
        flyBehavior = FlyNoWay()
        quackBehavior = QuackNoWay()
    }

    open val release = object : DuckMenuItem {
        override fun invoke() {
            doRelease()
        }
    }

    fun doRelease() {
        isFree = true
        flyBehavior = defaultFlyBehavior
        quackBehavior = deafaultQuackBehavior
    }

    // abstract display function that must be implemented by concrete classes
    abstract fun display(): String

    override fun update() {
        state = State.WELCOMING
    }
}
