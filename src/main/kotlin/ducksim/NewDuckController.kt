package ducksim

class NewDuckController(private val duckPond: DuckPond, private val view: DuckSimView) {

    fun createNewDuck() {

        if (duckPond.noSelectedDucks()) {
            val makeDuckDialog = MakeDuckDialog(duckPond, view)
            makeDuckDialog.setSize(300, 200)
            makeDuckDialog.isVisible = true
        } else {
            // get and filter the selected ducks by removing any flocks
            val ducks = duckPond.selectedDucks.filterNot { it is Flock }

            // if there is at least one duck after removing flocks, create a new flock with the selected ducks
            if (ducks.isEmpty()) return

            val flock = Flock(ducks)
            duckPond.addNewDuck(flock)
            view.repaint()
        }
    }


}