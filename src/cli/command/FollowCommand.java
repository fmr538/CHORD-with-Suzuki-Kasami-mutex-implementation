package cli.command;


import app.AppConfig;

public class FollowCommand implements CLICommand{

    @Override
    public String commandName() {return "follow";}

    @Override
    public void execute(String args) {
        try {
            if (AppConfig.chordState.sendFollowRequest(args, AppConfig.myServentInfo.getIpAddress() + ":" + AppConfig.myServentInfo.getListenerPort()))
                AppConfig.timestampedStandardPrint("Follow request sent to: " + args);
            else
                AppConfig.timestampedStandardPrint("User " + args + " not found");
        }catch (Exception e){
            //TODO exception i funkcija
            AppConfig.timestampedErrorPrint("Follow command exception: " + e.getMessage() + " for args: " + args);
        }
    }
}
