package dduwcom.mobile.helpus;

import java.util.ArrayList;

public class HelpDataManager {
    private ArrayList<HelpData> helpDataList;

    public HelpDataManager(){
        helpDataList = new ArrayList<HelpData>();

        helpDataList.add(new HelpData("백주년/3", "왼쪽"));
        helpDataList.add(new HelpData("백주년/1", "왼쪽"));
        helpDataList.add(new HelpData("백주년/2", "왼쪽"));
        helpDataList.add(new HelpData("백주년/4", "오른쪽"));
        helpDataList.add(new HelpData("춘강/3", "왼쪽"));
        helpDataList.add(new HelpData("춘강/1", "왼쪽"));
        helpDataList.add(new HelpData("춘강/2", "왼쪽"));
        helpDataList.add(new HelpData("백주년/7", "왼쪽"));
        helpDataList.add(new HelpData("백주년/3", "왼쪽"));
        helpDataList.add(new HelpData("백주년/1", "왼쪽"));
        helpDataList.add(new HelpData("백주년/2", "왼쪽"));
        helpDataList.add(new HelpData("백주년/4", "오른쪽"));
        helpDataList.add(new HelpData("춘강/3", "왼쪽"));
        helpDataList.add(new HelpData("춘강/1", "왼쪽"));
        helpDataList.add(new HelpData("춘강/2", "왼쪽"));
        helpDataList.add(new HelpData("백주년/7", "왼쪽"));

    }

    public ArrayList<HelpData> getHelpDataList() {
        return helpDataList;
    }

    public void addHelpData(HelpData helpData){
        helpDataList.add(helpData);
    }

}
