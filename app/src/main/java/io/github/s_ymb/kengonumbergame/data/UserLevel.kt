package io.github.s_ymb.kengonumbergame.data

import kotlin.math.sqrt

/*
    ユーザレベルを保持するクラス
    ・正解リストの登録状況に応じてレベルを設定し、課題設定時の空白の個数を制御する
 */
class UserLevel(
    private var level: Int = 0,
    private var maxBlankCell:Int = 1,
    private var minBlankCell:Int = 1,){

    constructor(satisfiedGridList: SatisfiedGridList) : this() {
        // 正解リストより、正解到達したデータの件数と検索機能で作られた件数をカウントする
        // TODO 種類が固定文字列なので対応方法は要検討
        val saticefiedCnt: Int = satisfiedGridList.getSize()
        var correctCnt = 0
        var searchCnt = 0
        for(idx in 0 until saticefiedCnt) {
            correctCnt += if (satisfiedGridList.getSatisfied(idx).satisfiedGrid.createUser == "正解到達")  1 else 0
            searchCnt += if (satisfiedGridList.getSatisfied(idx).satisfiedGrid.createUser == "検索機能") 1 else 0
        }
        // TODO とりあえずのレベル設定
        val levelPow2:Int = if(correctCnt - (searchCnt / 2) < 1){
            1
        }else {
            correctCnt - (searchCnt / 2)
        }
        level = sqrt(levelPow2.toDouble()).toInt()
        // TODO とりあえずの空白欄の上限・下限
        maxBlankCell = if(level <= 50){
                                level + 1
                        }else{
                                50
                        }
        minBlankCell = (maxBlankCell / 2)

    }

    fun getMaxBlankCell (): Int{
        return maxBlankCell
    }

    fun getMinBlankCell(): Int{
        return minBlankCell
    }

    fun getLevel(): Int{
        return level
    }
}