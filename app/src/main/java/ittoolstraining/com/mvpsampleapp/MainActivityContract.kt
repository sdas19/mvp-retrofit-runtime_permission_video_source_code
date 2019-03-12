package ittoolstraining.com.mvpsampleapp

interface MainActivityContract {

    interface View
    {
        fun onclickButton()
        fun showToastInView(message : String)
    }

    interface Presenter
    {
        fun makeApiCall()
    }
}