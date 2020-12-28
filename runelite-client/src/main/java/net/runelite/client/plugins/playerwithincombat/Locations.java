package net.runelite.client.plugins.playerwithincombat;

import com.google.common.collect.ImmutableSet;
import net.runelite.api.Client;

import java.util.Set;

public class Locations {
    private final int id;
    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;
    private final int z;
    private static int y1base = 3520;
    private static int y2base = 3527;
    private static int multiplier = 8;
    private static Set<Locations> PlayerLocation = ImmutableSet.of(
            new Locations(1,2944,y1base+5,3410,y2base,0),
            new Locations(2,2944,y1base+multiplier,3410,y2base+multiplier,0),
            new Locations(3,2944,y1base+(multiplier*2),3410,y2base+(multiplier*2),0),
            new Locations(4,2944,y1base+(multiplier*3),3410,y2base+(multiplier*3),0),
            new Locations(5,2944,y1base+(multiplier*4),3410,y2base+(multiplier*4),0),
            new Locations(6,2944,y1base+(multiplier*5),3410,y2base+(multiplier*5),0),
            new Locations(7,2944,y1base+(multiplier*6),3410,y2base+(multiplier*6),0),
            new Locations(8,2944,y1base+(multiplier*7),3410,y2base+(multiplier*7),0),
            new Locations(9,2944,y1base+(multiplier*8),3410,y2base+(multiplier*8),0),
            new Locations(10,2944,y1base+(multiplier*9),3410,y2base+(multiplier*9),0),
            new Locations(11,2944,y1base+(multiplier*10),3410,y2base+(multiplier*10),0),
            new Locations(12,2944,y1base+(multiplier*11),3410,y2base+(multiplier*11),0),
            new Locations(13,2944,y1base+(multiplier*12),3410,y2base+(multiplier*12),0),
            new Locations(14,2944,y1base+(multiplier*13),3410,y2base+(multiplier*13),0),
            new Locations(15,2944,y1base+(multiplier*14),3410,y2base+(multiplier*14),0),
            new Locations(16,2944,y1base+(multiplier*15),3410,y2base+(multiplier*15),0),
            new Locations(17,2944,y1base+(multiplier*16),3410,y2base+(multiplier*16),0),
            new Locations(18,2944,y1base+(multiplier*17),3410,y2base+(multiplier*17),0),
            new Locations(19,2944,y1base+(multiplier*18),3410,y2base+(multiplier*18),0),
            new Locations(20,2944,y1base+(multiplier*19),3410,y2base+(multiplier*19),0),
            new Locations(21,2944,y1base+(multiplier*20),3410,y2base+(multiplier*20),0),
            new Locations(22,2944,y1base+(multiplier*21),3410,y2base+(multiplier*21),0),
            new Locations(23,2944,y1base+(multiplier*22),3410,y2base+(multiplier*22),0),
            new Locations(24,2944,y1base+(multiplier*23),3410,y2base+(multiplier*23),0),
            new Locations(25,2944,y1base+(multiplier*24),3410,y2base+(multiplier*24),0),
            new Locations(26,2944,y1base+(multiplier*25),3410,y2base+(multiplier*25),0),
            new Locations(27,2944,y1base+(multiplier*26),3410,y2base+(multiplier*26),0),
            new Locations(28,2944,y1base+(multiplier*27),3410,y2base+(multiplier*27),0),
            new Locations(29,2944,y1base+(multiplier*28),3410,y2base+(multiplier*28),0),
            new Locations(30,2944,y1base+(multiplier*29),3410,y2base+(multiplier*29),0),
            new Locations(31,2944,y1base+(multiplier*30),3410,y2base+(multiplier*30),0),
            new Locations(32,2944,y1base+(multiplier*31),3410,y2base+(multiplier*31),0),
            new Locations(33,2944,y1base+(multiplier*32),3410,y2base+(multiplier*32),0),
            new Locations(34,2944,y1base+(multiplier*33),3410,y2base+(multiplier*33),0),
            new Locations(35,2944,y1base+(multiplier*34),3410,y2base+(multiplier*34),0),
            new Locations(36,2944,y1base+(multiplier*35),3410,y2base+(multiplier*35),0),
            new Locations(37,2944,y1base+(multiplier*36),3410,y2base+(multiplier*36),0),
            new Locations(38,2944,y1base+(multiplier*37),3410,y2base+(multiplier*37),0),
            new Locations(39,2944,y1base+(multiplier*38),3410,y2base+(multiplier*38),0),
            new Locations(40,2944,y1base+(multiplier*39),3410,y2base+(multiplier*39),0),
            new Locations(41,2944,y1base+(multiplier*40),3410,y2base+(multiplier*40),0),
            new Locations(42,2944,y1base+(multiplier*41),3410,y2base+(multiplier*41),0),
            new Locations(43,2944,y1base+(multiplier*42),3410,y2base+(multiplier*42),0),
            new Locations(44,2944,y1base+(multiplier*43),3410,y2base+(multiplier*43),0),
            new Locations(45,2944,y1base+(multiplier*44),3410,y2base+(multiplier*44),0),
            new Locations(46,2944,y1base+(multiplier*45),3410,y2base+(multiplier*45),0),
            new Locations(47,2944,y1base+(multiplier*46),3410,y2base+(multiplier*46),0),
            new Locations(48,2944,y1base+(multiplier*47),3410,y2base+(multiplier*47),0),
            new Locations(49,2944,y1base+(multiplier*48),3410,y2base+(multiplier*48),0),
            new Locations(50,2944,y1base+(multiplier*49),3410,y2base+(multiplier*49),0),
            new Locations(51,2944,y1base+(multiplier*50),3410,y2base+(multiplier*50),0),
            new Locations(52,2944,y1base+(multiplier*51),3410,y2base+(multiplier*51),0),
            new Locations(53,2944,y1base+(multiplier*52),3410,y2base+(multiplier*52),0),
            new Locations(54,2944,y1base+(multiplier*53),3410,y2base+(multiplier*53),0),
            new Locations(55,2944,y1base+(multiplier*54),3410,y2base+(multiplier*54),0),
            new Locations(56,2944,y1base+(multiplier*55),3410,y2base+(multiplier*55),0),
            new Locations(57,2944,y1base+(multiplier*56),3410,y2base+(multiplier*56),0),
            new Locations(58,2944,y1base+(multiplier*57),3410,y2base+(multiplier*57),0),
            new Locations(59,2944,y1base+(multiplier*58),3410,y2base+(multiplier*58),0),
            new Locations(60,2944,y1base+(multiplier*59),3410,y2base+(multiplier*59),0)
    );
    private Locations(int id, int x1, int y1, int x2, int y2, int z){
        this.id = id;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z = z;
    }
    public static Set<Locations> getLocation(){return PlayerLocation;};
    public int getid(){return id;}
    public static Locations forPlayerLocation(Client client){
        int x = client.getLocalPlayer().getWorldLocation().getX();
        int y = client.getLocalPlayer().getWorldLocation().getY();
        int plane = client.getPlane();
        for (Locations locations : PlayerLocation){
            if(x >= locations.x1 && x <= locations.x2 && plane == locations.z
                && y >= locations.y1 && y <= locations.y2){
                return locations;
            }
        }
        return null;
    }
}
