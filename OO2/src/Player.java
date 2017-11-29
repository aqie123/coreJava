public class Player {
    int id;
    String name;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void play(){
        System.out.println(name+"开始训练");
    }
}
class TeamDriver{
    public static void main(String[] args){
        Player p1 = new Player(1,"梅东");
        Player p2 = new Player(2,"梅西");
        Player p3 = new Player(3,"梅南");

        // 创建一个球队
        Team t = new Team("阿根廷",p1,p2,p3);
        t.startPlay();
    }
}
class Team{
    String name;
    // 球员
    Player p1;
    Player p2;
    Player p3;
    public Team(String name,Player p1,Player p2, Player p3){
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    public void startPlay(){
        System.out.println(name+"开始比赛");
        System.out.println(p2.name+"开始比赛");
    }
}
