package io.github.s_ymb.kengonumbergame.data

enum class dupErr {
    NO_DUP,     //重複なし
    ROW_DUP,    //行で重複
    COL_DUP,    //列で重複
    SQ_DUP,     //四角いエリアで重複
    FIX_DUP,         //初期値なので変更不可
}