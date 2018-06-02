package kr.co.highton.slacks.sim

class MainActivity : BaseActivity() {

    override var viewId: Int = R.layout.activity_main
    override var toolbarId: Int? = R.id.toolbar

    override fun onCreate() {
        showActionBar()
    }
}
