/*
 * @author     ucchy
 * @license    LGPLv3
 * @copyright  Copyright ucchy 2014
 */
package com.github.ucchyocean.chatbot;

import java.io.File;
import java.util.HashMap;

/**
 * 時報のデータ管理オブジェクト
 * @author ucchy
 */
public class TimeSignalData {

    private static final String FILE_NAME = "timesignals.txt";

    private HashMap<String, String> data;

    private File jarFile;
    private File file;

    /**
     * コンストラクタ
     * @param jarFile プラグインのJarファイル
     * @param dataFolder プラグインのデータフォルダ
     */
    public TimeSignalData(File jarFile, File dataFolder) {

        this.jarFile = jarFile;
        file = new File(dataFolder, FILE_NAME);
        reloadData();
    }

    /**
     * 設定ファイルをリロードする
     */
    public void reloadData() {
        data = Utility.loadConfigFile(jarFile, file);
    }

    /**
     * 指定された時刻文字列に対する応答設定がある場合、応答内容を返します。
     * 応答設定が無いなら、nullが返されます。
     * @param source 時刻文字列
     * @return 応答内容
     */
    public String getResponceIfMatch(String source) {
        return data.get(source);
    }
}