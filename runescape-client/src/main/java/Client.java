import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("fj")
   static int[] field286;
   @ObfuscatedName("hi")
   static int[] field287;
   @ObfuscatedName("b")
   static boolean field288 = true;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -875284091
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("mn")
   static String field290;
   @ObfuscatedName("v")
   static class178 field291;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1429018063
   )
   static int field292;
   @ObfuscatedName("k")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      longValue = 3516825078515006311L
   )
   static long field294;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -1126596555
   )
   static int field295;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -730851945
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("n")
   static boolean field297 = true;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1433442645
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -5034727310882451497L
   )
   static long field299 = -1L;
   @ObfuscatedName("ha")
   static Deque field300;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2063001383
   )
   static int field301 = -1;
   @ObfuscatedName("ml")
   static int[] field302;
   @ObfuscatedName("le")
   static String field303;
   @ObfuscatedName("fr")
   static int[] field304;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1252984955
   )
   static int field305 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1640638385
   )
   static int field306 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -447890325
   )
   static int field307 = 0;
   @ObfuscatedName("kn")
   static boolean[] field308;
   @ObfuscatedName("lr")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -471168287
   )
   static int field310;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -407197799
   )
   static int field311 = 0;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = 1573239687
   )
   static int field312;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 582228679
   )
   static int field313 = 0;
   @ObfuscatedName("z")
   static boolean field314 = false;
   @ObfuscatedName("ar")
   static class40 field315;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -1833989755
   )
   static int field316;
   @ObfuscatedName("az")
   static class110 field317;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 365442103
   )
   static int field318;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1635589477
   )
   static int field319;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 166011269
   )
   static int field320;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -1012136497
   )
   static int field321;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1978439547
   )
   static int field322;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1922229319
   )
   static int field323;
   @ObfuscatedName("ce")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ko")
   static int[] field326;
   @ObfuscatedName("cp")
   static int[] field327;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1490846189
   )
   static int field328;
   @ObfuscatedName("cl")
   static class159 field330;
   @ObfuscatedName("cb")
   static class159 field331;
   @ObfuscatedName("ck")
   static class159 field332;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -315864913
   )
   static int field333 = 0;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 704212765
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 181171801
   )
   static int field335;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1732935797
   )
   static int field336;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 47438079
   )
   static int field337;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -2032314079
   )
   static int field338;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 2119054943
   )
   static int field339;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1787095553
   )
   static int field340;
   @ObfuscatedName("cs")
   static boolean field341;
   @ObfuscatedName("hl")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -394622671
   )
   static int field343;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 1516289033
   )
   static int field344;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -415551173
   )
   static int field345;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 1433127077
   )
   static int field346;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("dm")
   static boolean field348;
   @ObfuscatedName("nv")
   static int[] field349;
   @ObfuscatedName("ag")
   static boolean field350 = true;
   @ObfuscatedName("nl")
   static int[] field351;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = 916978233
   )
   static int field352;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 524741445
   )
   static int field353;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -2112845243
   )
   static int field354;
   @ObfuscatedName("fc")
   static int[] field355;
   @ObfuscatedName("lc")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 142721167
   )
   static int field357 = 0;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -928316541
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -1793627919
   )
   static int field359;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1681608807
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 1039813765
   )
   static int field361;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 238096401
   )
   static int field362;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = 319800403
   )
   static int field363;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 883664097
   )
   static int field364 = 0;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 35442787
   )
   static int field365;
   @ObfuscatedName("ou")
   static short field366;
   @ObfuscatedName("ox")
   static int[] field367;
   @ObfuscatedName("em")
   static boolean field368;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -556710855
   )
   static int field369;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -660484613
   )
   static int field370;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -1125023285
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -167726475
   )
   static int field372;
   @ObfuscatedName("hh")
   static boolean[] field373;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1033911589
   )
   static int field374;
   @ObfuscatedName("mq")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("ac")
   static class40 field376;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -1869462017
   )
   static int field377;
   @ObfuscatedName("fz")
   static boolean field378;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 1218080725
   )
   static int field379;
   @ObfuscatedName("lo")
   static int[] field380;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 862940433
   )
   static int field381;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -228722633
   )
   static int field382;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 634321631
   )
   static int field383;
   @ObfuscatedName("ch")
   static int[] field384;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 1236697445
   )
   static int field385;
   @ObfuscatedName("fm")
   static int[] field386;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1765860543
   )
   static int field387;
   @ObfuscatedName("js")
   static boolean field388;
   @ObfuscatedName("gl")
   static String[] field389;
   @ObfuscatedName("gc")
   static int[][] field390;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1115297643
   )
   static int field391;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 975074467
   )
   static int field392;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -2022866883
   )
   static int field393;
   @ObfuscatedName("or")
   static short field394;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -904416187
   )
   static int field395;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -81802757
   )
   static int field396;
   @ObfuscatedName("oh")
   static short field397;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1192427031
   )
   static int field398;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -100532517
   )
   static int field399;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 2022699953
   )
   static int field400;
   @ObfuscatedName("hd")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 2083912667
   )
   static int field402;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -285906901
   )
   static int field403;
   @ObfuscatedName("gd")
   static boolean field404;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 2057449079
   )
   static int field405;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      longValue = -1184547691261289987L
   )
   static long field406;
   @ObfuscatedName("gv")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1101096029
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -224427725
   )
   static int field409;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 215623245
   )
   static int field410;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1430050443
   )
   static int field411;
   @ObfuscatedName("hk")
   static final int[] field412;
   @ObfuscatedName("hp")
   static String[] field413;
   @ObfuscatedName("ft")
   static int[] field414;
   @ObfuscatedName("hw")
   static int[] field415;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 3313221
   )
   static int field416;
   @ObfuscatedName("hf")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ic")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("hn")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("lh")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("hv")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ib")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("mc")
   static int[] field423;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 197524333
   )
   static int field424;
   @ObfuscatedName("ho")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 1005362367
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("hs")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -921288001
   )
   static int field428 = 0;
   @ObfuscatedName("il")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 970917783
   )
   static int field430 = 0;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1240571923
   )
   static int field431;
   @ObfuscatedName("iq")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1874522331
   )
   static int field433;
   @ObfuscatedName("jl")
   static boolean field434;
   @ObfuscatedName("jo")
   static Widget field435;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 1882943439
   )
   static int field436;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 999395383
   )
   static int field437;
   @ObfuscatedName("ih")
   static String field438;
   @ObfuscatedName("in")
   static boolean field439;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 502899515
   )
   static int field441;
   @ObfuscatedName("hj")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("it")
   static String field443;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -2101657977
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ig")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 2141685099
   )
   static int field446;
   @ObfuscatedName("df")
   static int[][][] field447;
   @ObfuscatedName("je")
   static Widget field448;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 220619327
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -1341830441
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -333109327
   )
   static int field451;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 2061317825
   )
   static int field452;
   @ObfuscatedName("jy")
   static boolean field453;
   @ObfuscatedName("jm")
   static boolean field454;
   @ObfuscatedName("jx")
   static Widget field455;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -832068781
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 1763999041
   )
   static int field457;
   @ObfuscatedName("fd")
   static int[] field458;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 1764184627
   )
   static int field459;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -121614733
   )
   static int field460;
   @ObfuscatedName("jr")
   static Widget field461;
   @ObfuscatedName("oc")
   static short field462;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -1207424989
   )
   static int field463;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1681210567
   )
   static int field464;
   @ObfuscatedName("jb")
   static boolean field465;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 1893625019
   )
   static int field466;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -121804859
   )
   static int field467;
   @ObfuscatedName("jt")
   static boolean field468;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -113015193
   )
   static int field469;
   @ObfuscatedName("kc")
   static int[] field470;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 228394293
   )
   static int field471;
   @ObfuscatedName("ky")
   static int[] field472;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 120683287
   )
   static int field473;
   @ObfuscatedName("md")
   static int[] field474;
   @ObfuscatedName("au")
   static boolean field475 = false;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1069873541
   )
   static int field476;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -948175791
   )
   static int field477;
   @ObfuscatedName("ot")
   static class130 field478;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2061774925
   )
   static int field479 = -1;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 784548131
   )
   static int field480;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 92750829
   )
   static int field481;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -1248589369
   )
   static int field482;
   @ObfuscatedName("kb")
   static Deque field483;
   @ObfuscatedName("kq")
   static Deque field484;
   @ObfuscatedName("kg")
   static Deque field485;
   @ObfuscatedName("kj")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1880470017
   )
   static int field487;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 35266861
   )
   static int field488;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 1467568591
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("ld")
   static boolean[] field490;
   @ObfuscatedName("lw")
   static boolean[] field491;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -855827731
   )
   static int field492;
   @ObfuscatedName("mf")
   static boolean field493;
   @ObfuscatedName("lx")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("oo")
   static PlayerComposition field495;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 908904703
   )
   static int field496;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      longValue = -9119411743189976613L
   )
   static long field497;
   @ObfuscatedName("li")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = 1397567463
   )
   static int field499;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 310028821
   )
   static int field500;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -1670650609
   )
   static int field501;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 1580793989
   )
   static int field502;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 1676532857
   )
   static int field503;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -349040583
   )
   static int field504;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -264606973
   )
   static int field505;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -2104068057
   )
   static int field506;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -1769961837
   )
   static int field507;
   @ObfuscatedName("lp")
   static int[] field508;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 970025937
   )
   static int field509 = 0;
   @ObfuscatedName("op")
   static short field510;
   @ObfuscatedName("hg")
   static Deque field511;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 1910285613
   )
   static int field512;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 211419809
   )
   static int field513;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -267678561
   )
   static int field514;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 1418166809
   )
   static int field515;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 481914659
   )
   static int field516;
   @ObfuscatedName("my")
   static SpritePixels[] field517;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -361302435
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1408334987
   )
   static int field519;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = 274645971
   )
   static int field520;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = -152325141
   )
   static int field521;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = -21086273
   )
   static int field522;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1096307605
   )
   static int field523;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 799246877
   )
   static int field524;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -1353375869
   )
   static int field525;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = 1986810241
   )
   static int field526;
   @ObfuscatedName("ni")
   static int[] field527;
   @ObfuscatedName("dy")
   static final int[] field528;
   @ObfuscatedName("np")
   static int[] field529;
   @ObfuscatedName("fs")
   static int[] field530;
   @ObfuscatedName("nf")
   static class53[] field531;
   @ObfuscatedName("pq")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("na")
   static boolean[] field533;
   @ObfuscatedName("of")
   static int[] field534;
   @ObfuscatedName("oq")
   static int[] field535;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -1261216075
   )
   static int field536;
   @ObfuscatedName("ov")
   static int[] field537;
   @ObfuscatedName("od")
   static short field538;
   @ObfuscatedName("os")
   static short field539;
   @ObfuscatedName("m")
   static Client field540;
   @ObfuscatedName("ly")
   static long[] field541;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 1480205293
   )
   static int field542;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1066625781
   )
   static int field543 = -1;
   @ObfuscatedName("oi")
   static short field544;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 82408525
   )
   static int field546;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -978227611
   )
   static int field547;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 138677199
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -2025941233
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("ol")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -1833617239
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -2041007681
   )
   static int field552;
   @ObfuscatedName("oj")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("nn")
   static boolean field554;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -1572986761
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1236243247
   )
   static int field556;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1222109353
   )
   static int field557;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = 1446998325
   )
   static int field558;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = 898940603
   )
   static int field559;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 1033882657
   )
   static int field560;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      longValue = 6192284526540295441L
   )
   static long field561;
   @ObfuscatedName("iz")
   static String field562;
   @ObfuscatedName("pv")
   static final class22 field563;
   @ObfuscatedName("pn")
   static int[] field564;
   @ObfuscatedName("pi")
   static int[] field565;
   @ObfuscatedName("jc")
   static Widget field566;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1075634525
   )
   static int field568;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 929646305
   )
   @Export("scale")
   static int scale;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1935400414"
   )
   protected final void vmethod2067() {
      if(class109.chatMessages.method828()) {
         class109.chatMessages.method827();
      }

      if(World.field695 != null) {
         World.field695.field226 = false;
      }

      World.field695 = null;
      if(class6.field46 != null) {
         class6.field46.method2027();
         class6.field46 = null;
      }

      class38.method725();
      class37.method722();
      class146.field2033 = null;
      if(null != class88.field1527) {
         class88.field1527.method1043();
      }

      if(class8.field62 != null) {
         class8.field62.method1043();
      }

      NPCComposition.method3644();
      Object var1 = class183.field2736;
      synchronized(class183.field2736) {
         if(class183.field2740 != 0) {
            class183.field2740 = 1;

            try {
               class183.field2736.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      try {
         class104.field1688.method1367();

         for(int var4 = 0; var4 < VertexNormal.field1418; ++var4) {
            class104.field1690[var4].method1367();
         }

         class104.field1689.method1367();
         class104.field1687.method1367();
      } catch (Exception var6) {
         ;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1686960688"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method380();

      while(true) {
         Deque var2 = class183.field2733;
         class180 var1;
         synchronized(class183.field2733) {
            var1 = (class180)class183.field2734.method2347();
         }

         if(null == var1) {
            class101.method1914();
            class183.method3292();
            Player.method232();
            class115 var29 = class115.mouse;
            synchronized(class115.mouse) {
               class115.field1822 = class115.field1827;
               class115.field1814 = class115.field1811;
               class115.field1821 = class115.field1812;
               class115.field1820 = class115.field1816;
               class115.field1823 = class115.field1817;
               class115.field1825 = class115.field1818;
               class115.field1813 = class115.field1819;
               class115.field1816 = 0;
            }

            int var16;
            if(null != class146.field2033) {
               var16 = class146.field2033.vmethod2036();
               field482 = var16;
            }

            if(gameState == 0) {
               class13.method169();
               class9.field77.vmethod2001();

               for(var16 = 0; var16 < 32; ++var16) {
                  GameEngine.field1791[var16] = 0L;
               }

               for(var16 = 0; var16 < 32; ++var16) {
                  GameEngine.field1786[var16] = 0L;
               }

               WidgetNode.field184 = 0;
            } else if(gameState == 5) {
               class8.method93(this);
               class13.method169();
               class9.field77.vmethod2001();

               for(var16 = 0; var16 < 32; ++var16) {
                  GameEngine.field1791[var16] = 0L;
               }

               for(var16 = 0; var16 < 32; ++var16) {
                  GameEngine.field1786[var16] = 0L;
               }

               WidgetNode.field184 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class8.method93(this);
                  class9.method100();
               } else if(gameState == 25) {
                  class15.method176();
               }
            } else {
               class8.method93(this);
            }

            if(gameState == 30) {
               if(field305 > 1) {
                  --field305;
               }

               if(field340 > 0) {
                  --field340;
               }

               if(field341) {
                  field341 = false;
                  WallObject.method1842();
               } else {
                  if(!isMenuOpen) {
                     menuOptions[0] = "Cancel";
                     menuTargets[0] = "";
                     menuTypes[0] = 1006;
                     menuOptionCount = 1;
                  }

                  for(var16 = 0; var16 < 100 && class112.method2049(); ++var16) {
                     ;
                  }

                  if(gameState == 30) {
                     while(PlayerComposition.method3094()) {
                        field330.method2967(178);
                        field330.method2815(0);
                        var16 = field330.offset;
                        class195.method3471(field330);
                        field330.method2909(field330.offset - var16);
                     }

                     Object var30 = World.field695.field223;
                     int var5;
                     int var6;
                     int var7;
                     int var8;
                     int var9;
                     int var17;
                     int var18;
                     int var19;
                     synchronized(World.field695.field223) {
                        if(!field288) {
                           World.field695.field224 = 0;
                        } else if(class115.field1820 != 0 || World.field695.field224 >= 40) {
                           field330.method2967(140);
                           field330.method2815(0);
                           var17 = field330.offset;
                           var18 = 0;

                           for(var19 = 0; var19 < World.field695.field224 && field330.offset - var17 < 240; ++var19) {
                              ++var18;
                              var5 = World.field695.field227[var19];
                              if(var5 < 0) {
                                 var5 = 0;
                              } else if(var5 > 502) {
                                 var5 = 502;
                              }

                              var6 = World.field695.field225[var19];
                              if(var6 < 0) {
                                 var6 = 0;
                              } else if(var6 > 764) {
                                 var6 = 764;
                              }

                              var7 = var6 + 765 * var5;
                              if(World.field695.field227[var19] == -1 && World.field695.field225[var19] == -1) {
                                 var6 = -1;
                                 var5 = -1;
                                 var7 = 524287;
                              }

                              if(var6 == field479 && var5 == field301) {
                                 if(field543 < 2047) {
                                    ++field543;
                                 }
                              } else {
                                 var8 = var6 - field479;
                                 field479 = var6;
                                 var9 = var5 - field301;
                                 field301 = var5;
                                 if(field543 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                    var8 += 32;
                                    var9 += 32;
                                    field330.method2712(var9 + (var8 << 6) + (field543 << 12));
                                    field543 = 0;
                                 } else if(field543 < 8) {
                                    field330.method2713(var7 + (field543 << 19) + 8388608);
                                    field543 = 0;
                                 } else {
                                    field330.method2714(-1073741824 + (field543 << 19) + var7);
                                    field543 = 0;
                                 }
                              }
                           }

                           field330.method2909(field330.offset - var17);
                           if(var18 >= World.field695.field224) {
                              World.field695.field224 = 0;
                           } else {
                              World.field695.field224 -= var18;

                              for(var19 = 0; var19 < World.field695.field224; ++var19) {
                                 World.field695.field225[var19] = World.field695.field225[var18 + var19];
                                 World.field695.field227[var19] = World.field695.field227[var19 + var18];
                              }
                           }
                        }
                     }

                     if(class115.field1820 == 1 || !class148.field2047 && class115.field1820 == 4 || class115.field1820 == 2) {
                        long var46 = (class115.field1813 - field299) / 50L;
                        if(var46 > 4095L) {
                           var46 = 4095L;
                        }

                        field299 = class115.field1813;
                        var18 = class115.field1825;
                        if(var18 < 0) {
                           var18 = 0;
                        } else if(var18 > class94.field1584) {
                           var18 = class94.field1584;
                        }

                        var19 = class115.field1823;
                        if(var19 < 0) {
                           var19 = 0;
                        } else if(var19 > TextureProvider.field1200) {
                           var19 = TextureProvider.field1200;
                        }

                        var5 = (int)var46;
                        field330.method2967(141);
                        field330.method2712((class115.field1820 == 2?1:0) + (var5 << 1));
                        field330.method2712(var19);
                        field330.method2712(var18);
                     }

                     if(class105.field1722 > 0) {
                        field330.method2967(244);
                        field330.method2712(0);
                        var16 = field330.offset;
                        long var44 = class114.method2154();

                        for(var19 = 0; var19 < class105.field1722; ++var19) {
                           long var41 = var44 - field406;
                           if(var41 > 16777215L) {
                              var41 = 16777215L;
                           }

                           field406 = var44;
                           field330.method2713((int)var41);
                           field330.method2752(class105.field1721[var19]);
                        }

                        field330.method2722(field330.offset - var16);
                     }

                     if(field402 > 0) {
                        --field402;
                     }

                     if(class105.field1728[96] || class105.field1728[97] || class105.field1728[98] || class105.field1728[99]) {
                        field378 = true;
                     }

                     if(field378 && field402 <= 0) {
                        field402 = 20;
                        field378 = false;
                        field330.method2967(81);
                        field330.method2760(field370);
                        field330.method2760(mapAngle);
                     }

                     if(Player.field270 && !field350) {
                        field350 = true;
                        field330.method2967(55);
                        field330.method2815(1);
                     }

                     if(!Player.field270 && field350) {
                        field350 = false;
                        field330.method2967(55);
                        field330.method2815(0);
                     }

                     if(field513 != class63.plane) {
                        field513 = class63.plane;
                        class191.method3393(class63.plane);
                     }

                     if(gameState == 30) {
                        for(class25 var31 = (class25)field300.method2349(); null != var31; var31 = (class25)field300.method2351()) {
                           if(var31.field577 > 0) {
                              --var31.field577;
                           }

                           ObjectComposition var20;
                           boolean var45;
                           if(var31.field577 == 0) {
                              if(var31.field572 >= 0) {
                                 var18 = var31.field572;
                                 var19 = var31.field576;
                                 var20 = class143.getObjectDefinition(var18);
                                 if(var19 == 11) {
                                    var19 = 10;
                                 }

                                 if(var19 >= 5 && var19 <= 8) {
                                    var19 = 4;
                                 }

                                 var45 = var20.method3520(var19);
                                 if(!var45) {
                                    continue;
                                 }
                              }

                              class26.method568(var31.field575, var31.field571, var31.field584, var31.field573, var31.field572, var31.field581, var31.field576);
                              var31.unlink();
                           } else {
                              if(var31.field580 > 0) {
                                 --var31.field580;
                              }

                              if(var31.field580 == 0 && var31.field584 >= 1 && var31.field573 >= 1 && var31.field584 <= 102 && var31.field573 <= 102) {
                                 if(var31.field579 >= 0) {
                                    var18 = var31.field579;
                                    var19 = var31.field570;
                                    var20 = class143.getObjectDefinition(var18);
                                    if(var19 == 11) {
                                       var19 = 10;
                                    }

                                    if(var19 >= 5 && var19 <= 8) {
                                       var19 = 4;
                                    }

                                    var45 = var20.method3520(var19);
                                    if(!var45) {
                                       continue;
                                    }
                                 }

                                 class26.method568(var31.field575, var31.field571, var31.field584, var31.field573, var31.field579, var31.field578, var31.field570);
                                 var31.field580 = -1;
                                 if(var31.field579 == var31.field572 && var31.field572 == -1) {
                                    var31.unlink();
                                 } else if(var31.field579 == var31.field572 && var31.field578 == var31.field581 && var31.field570 == var31.field576) {
                                    var31.unlink();
                                 }
                              }
                           }
                        }

                        class15.method175();
                        ++field335;
                        if(field335 > 750) {
                           WallObject.method1842();
                        } else {
                           var16 = class45.field900;
                           int[] var32 = class45.field902;

                           for(var18 = 0; var18 < var16; ++var18) {
                              Player var4 = cachedPlayers[var32[var18]];
                              if(var4 != null) {
                                 class97.method1885(var4, 1);
                              }
                           }

                           class39.method729();
                           int[] var33 = class45.field902;

                           for(var17 = 0; var17 < class45.field900; ++var17) {
                              Player var3 = cachedPlayers[var33[var17]];
                              if(var3 != null && var3.field619 > 0) {
                                 --var3.field619;
                                 if(var3.field619 == 0) {
                                    var3.overhead = null;
                                 }
                              }
                           }

                           for(var17 = 0; var17 < field492; ++var17) {
                              var18 = field327[var17];
                              NPC var38 = cachedNPCs[var18];
                              if(var38 != null && var38.field619 > 0) {
                                 --var38.field619;
                                 if(var38.field619 == 0) {
                                    var38.overhead = null;
                                 }
                              }
                           }

                           ++field363;
                           if(field476 != 0) {
                              field396 += 20;
                              if(field396 >= 400) {
                                 field476 = 0;
                              }
                           }

                           if(null != Ignore.field209) {
                              ++field398;
                              if(field398 >= 15) {
                                 class97.method1886(Ignore.field209);
                                 Ignore.field209 = null;
                              }
                           }

                           Widget var35 = class22.field245;
                           Widget var34 = class72.field1192;
                           class22.field245 = null;
                           class72.field1192 = null;
                           field461 = null;
                           field465 = false;
                           field388 = false;
                           field507 = 0;

                           while(true) {
                              while(class11.method147() && field507 < 128) {
                                 if(field451 >= 2 && class105.field1728[82] && class177.field2670 == 66) {
                                    String var36 = class194.method3456();
                                    TextureProvider.field1210.setContents(new StringSelection(var36), (ClipboardOwner)null);
                                 } else {
                                    field302[field507] = class177.field2670;
                                    field508[field507] = class88.field1529;
                                    ++field507;
                                 }
                              }

                              if(widgetRoot != -1) {
                                 var18 = widgetRoot;
                                 var19 = TextureProvider.field1200;
                                 var5 = class94.field1584;
                                 if(class2.method25(var18)) {
                                    class116.method2196(Widget.widgets[var18], -1, 0, 0, var19, var5, 0, 0);
                                 }
                              }

                              ++field469;

                              while(true) {
                                 class18 var37;
                                 Widget var39;
                                 Widget var47;
                                 do {
                                    var37 = (class18)field484.method2347();
                                    if(null == var37) {
                                       while(true) {
                                          do {
                                             var37 = (class18)field485.method2347();
                                             if(null == var37) {
                                                while(true) {
                                                   do {
                                                      var37 = (class18)field483.method2347();
                                                      if(var37 == null) {
                                                         class26.method560();
                                                         if(null == CombatInfo1.field669 && field455 == null) {
                                                            var18 = class115.field1820;
                                                            int var21;
                                                            if(isMenuOpen) {
                                                               if(var18 != 1 && (class148.field2047 || var18 != 4)) {
                                                                  var19 = class115.field1814;
                                                                  var5 = class115.field1821;
                                                                  if(var19 < GameObject.menuX - 10 || var19 > 10 + GameObject.menuX + class3.menuWidth || var5 < class109.menuY - 10 || var5 > class109.menuY + class30.menuHeight + 10) {
                                                                     isMenuOpen = false;
                                                                     class7.method86(GameObject.menuX, class109.menuY, class3.menuWidth, class30.menuHeight);
                                                                  }
                                                               }

                                                               if(var18 == 1 || !class148.field2047 && var18 == 4) {
                                                                  var19 = GameObject.menuX;
                                                                  var5 = class109.menuY;
                                                                  var6 = class3.menuWidth;
                                                                  var7 = class115.field1823;
                                                                  var8 = class115.field1825;
                                                                  var9 = -1;

                                                                  int var11;
                                                                  for(var21 = 0; var21 < menuOptionCount; ++var21) {
                                                                     var11 = var5 + 31 + 15 * (menuOptionCount - 1 - var21);
                                                                     if(var7 > var19 && var7 < var19 + var6 && var8 > var11 - 13 && var8 < var11 + 3) {
                                                                        var9 = var21;
                                                                     }
                                                                  }

                                                                  if(var9 != -1 && var9 >= 0) {
                                                                     var21 = menuActionParams0[var9];
                                                                     var11 = menuActionParams1[var9];
                                                                     int var12 = menuTypes[var9];
                                                                     int var13 = menuIdentifiers[var9];
                                                                     String var14 = menuOptions[var9];
                                                                     String var15 = menuTargets[var9];
                                                                     class109.menuAction(var21, var11, var12, var13, var14, var15, class115.field1823, class115.field1825);
                                                                  }

                                                                  isMenuOpen = false;
                                                                  class7.method86(GameObject.menuX, class109.menuY, class3.menuWidth, class30.menuHeight);
                                                               }
                                                            } else {
                                                               label1375: {
                                                                  label1407: {
                                                                     if((var18 == 1 || !class148.field2047 && var18 == 4) && menuOptionCount > 0) {
                                                                        var19 = menuTypes[menuOptionCount - 1];
                                                                        if(var19 == 39 || var19 == 40 || var19 == 41 || var19 == 42 || var19 == 43 || var19 == 33 || var19 == 34 || var19 == 35 || var19 == 36 || var19 == 37 || var19 == 38 || var19 == 1005) {
                                                                           var5 = menuActionParams0[menuOptionCount - 1];
                                                                           var6 = menuActionParams1[menuOptionCount - 1];
                                                                           Widget var22 = class174.method3178(var6);
                                                                           var9 = class217.method3874(var22);
                                                                           boolean var42 = (var9 >> 28 & 1) != 0;
                                                                           if(var42) {
                                                                              break label1407;
                                                                           }

                                                                           Object var10000 = null;
                                                                           if(Player.method220(class217.method3874(var22))) {
                                                                              break label1407;
                                                                           }
                                                                        }
                                                                     }

                                                                     if((var18 == 1 || !class148.field2047 && var18 == 4) && (field424 == 1 && menuOptionCount > 2 || VertexNormal.method1598(menuOptionCount - 1))) {
                                                                        var18 = 2;
                                                                     }

                                                                     if((var18 == 1 || !class148.field2047 && var18 == 4) && menuOptionCount > 0) {
                                                                        var19 = menuOptionCount - 1;
                                                                        if(var19 >= 0) {
                                                                           var5 = menuActionParams0[var19];
                                                                           var6 = menuActionParams1[var19];
                                                                           var7 = menuTypes[var19];
                                                                           var8 = menuIdentifiers[var19];
                                                                           String var23 = menuOptions[var19];
                                                                           String var10 = menuTargets[var19];
                                                                           class109.menuAction(var5, var6, var7, var8, var23, var10, class115.field1823, class115.field1825);
                                                                        }
                                                                     }

                                                                     if(var18 == 2 && menuOptionCount > 0) {
                                                                        Projectile.method765(class115.field1823, class115.field1825);
                                                                     }
                                                                     break label1375;
                                                                  }

                                                                  if(CombatInfo1.field669 != null && !field404 && field424 != 1 && !VertexNormal.method1598(menuOptionCount - 1) && menuOptionCount > 0) {
                                                                     GroundObject.method1506(field431, field387);
                                                                  }

                                                                  field404 = false;
                                                                  field405 = 0;
                                                                  if(null != CombatInfo1.field669) {
                                                                     class97.method1886(CombatInfo1.field669);
                                                                  }

                                                                  CombatInfo1.field669 = class174.method3178(var6);
                                                                  field400 = var5;
                                                                  field431 = class115.field1823;
                                                                  field387 = class115.field1825;
                                                                  if(menuOptionCount > 0) {
                                                                     var21 = menuOptionCount - 1;
                                                                     class154.field2120 = new class38();
                                                                     class154.field2120.field807 = menuActionParams0[var21];
                                                                     class154.field2120.field803 = menuActionParams1[var21];
                                                                     class154.field2120.field804 = menuTypes[var21];
                                                                     class154.field2120.field802 = menuIdentifiers[var21];
                                                                     class154.field2120.field805 = menuOptions[var21];
                                                                  }

                                                                  class97.method1886(CombatInfo1.field669);
                                                               }
                                                            }
                                                         }

                                                         if(field455 != null) {
                                                            class97.method1886(field455);
                                                            ++class36.field774;
                                                            if(field465 && field388) {
                                                               var18 = class115.field1814;
                                                               var19 = class115.field1821;
                                                               var18 -= field459;
                                                               var19 -= field460;
                                                               if(var18 < field463) {
                                                                  var18 = field463;
                                                               }

                                                               if(field455.width + var18 > field463 + field435.width) {
                                                                  var18 = field463 + field435.width - field455.width;
                                                               }

                                                               if(var19 < field464) {
                                                                  var19 = field464;
                                                               }

                                                               if(var19 + field455.height > field464 + field435.height) {
                                                                  var19 = field464 + field435.height - field455.height;
                                                               }

                                                               var5 = var18 - field433;
                                                               var6 = var19 - field467;
                                                               var7 = field455.field2283;
                                                               if(class36.field774 > field455.field2302 && (var5 > var7 || var5 < -var7 || var6 > var7 || var6 < -var7)) {
                                                                  field468 = true;
                                                               }

                                                               var8 = field435.scrollX + (var18 - field463);
                                                               var9 = field435.scrollY + (var19 - field464);
                                                               class18 var43;
                                                               if(null != field455.field2296 && field468) {
                                                                  var43 = new class18();
                                                                  var43.field193 = field455;
                                                                  var43.field195 = var8;
                                                                  var43.field194 = var9;
                                                                  var43.field203 = field455.field2296;
                                                                  class13.method165(var43);
                                                               }

                                                               if(class115.field1822 == 0) {
                                                                  if(field468) {
                                                                     if(null != field455.field2297) {
                                                                        var43 = new class18();
                                                                        var43.field193 = field455;
                                                                        var43.field195 = var8;
                                                                        var43.field194 = var9;
                                                                        var43.field198 = field461;
                                                                        var43.field203 = field455.field2297;
                                                                        class13.method165(var43);
                                                                     }

                                                                     if(null != field461 && class205.method3728(field455) != null) {
                                                                        field330.method2967(176);
                                                                        field330.method2922(field461.index);
                                                                        field330.method2712(field455.item);
                                                                        field330.method2922(field461.item);
                                                                        field330.method2922(field455.index);
                                                                        field330.method2791(field461.id);
                                                                        field330.method2769(field455.id);
                                                                     }
                                                                  } else if((field424 == 1 || VertexNormal.method1598(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                                     Projectile.method765(field433 + field459, field467 + field460);
                                                                  } else if(menuOptionCount > 0) {
                                                                     GroundObject.method1506(field433 + field459, field460 + field467);
                                                                  }

                                                                  field455 = null;
                                                               }
                                                            } else if(class36.field774 > 1) {
                                                               field455 = null;
                                                            }
                                                         }

                                                         if(CombatInfo1.field669 != null) {
                                                            class97.method1886(CombatInfo1.field669);
                                                            ++field405;
                                                            if(class115.field1822 != 0) {
                                                               if(field405 >= 5 && (class115.field1814 > field431 + 5 || class115.field1814 < field431 - 5 || class115.field1821 > 5 + field387 || class115.field1821 < field387 - 5)) {
                                                                  field404 = true;
                                                               }
                                                            } else {
                                                               if(field404) {
                                                                  if(class7.field51 == CombatInfo1.field669 && field400 != field403) {
                                                                     Widget var40 = CombatInfo1.field669;
                                                                     byte var48 = 0;
                                                                     if(field354 == 1 && var40.contentType == 206) {
                                                                        var48 = 1;
                                                                     }

                                                                     if(var40.itemIds[field403] <= 0) {
                                                                        var48 = 0;
                                                                     }

                                                                     if(Player.method220(class217.method3874(var40))) {
                                                                        var5 = field400;
                                                                        var6 = field403;
                                                                        var40.itemIds[var6] = var40.itemIds[var5];
                                                                        var40.itemQuantities[var6] = var40.itemQuantities[var5];
                                                                        var40.itemIds[var5] = -1;
                                                                        var40.itemQuantities[var5] = 0;
                                                                     } else if(var48 == 1) {
                                                                        var5 = field400;
                                                                        var6 = field403;

                                                                        while(var5 != var6) {
                                                                           if(var5 > var6) {
                                                                              var40.method3110(var5 - 1, var5);
                                                                              --var5;
                                                                           } else if(var5 < var6) {
                                                                              var40.method3110(1 + var5, var5);
                                                                              ++var5;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var40.method3110(field403, field400);
                                                                     }

                                                                     field330.method2967(127);
                                                                     field330.method2760(field400);
                                                                     field330.method2913(var48);
                                                                     field330.method2791(CombatInfo1.field669.id);
                                                                     field330.method2712(field403);
                                                                  }
                                                               } else if((field424 == 1 || VertexNormal.method1598(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                                  Projectile.method765(field431, field387);
                                                               } else if(menuOptionCount > 0) {
                                                                  GroundObject.method1506(field431, field387);
                                                               }

                                                               field398 = 10;
                                                               class115.field1820 = 0;
                                                               CombatInfo1.field669 = null;
                                                            }
                                                         }

                                                         if(Region.field1509 != -1) {
                                                            var18 = Region.field1509;
                                                            var19 = Region.field1505;
                                                            field330.method2967(34);
                                                            field330.method2815(5);
                                                            field330.method2752(class105.field1728[82]?(class105.field1728[81]?2:1):0);
                                                            field330.method2760(var18 + class107.baseX);
                                                            field330.method2759(XClanMember.baseY + var19);
                                                            Region.field1509 = -1;
                                                            field500 = class115.field1823;
                                                            field395 = class115.field1825;
                                                            field476 = 1;
                                                            field396 = 0;
                                                            flagX = var18;
                                                            flagY = var19;
                                                         }

                                                         if(var35 != class22.field245) {
                                                            if(null != var35) {
                                                               class97.method1886(var35);
                                                            }

                                                            if(class22.field245 != null) {
                                                               class97.method1886(class22.field245);
                                                            }
                                                         }

                                                         if(var34 != class72.field1192 && field436 == field512) {
                                                            if(null != var34) {
                                                               class97.method1886(var34);
                                                            }

                                                            if(class72.field1192 != null) {
                                                               class97.method1886(class72.field1192);
                                                            }
                                                         }

                                                         if(class72.field1192 != null) {
                                                            if(field512 < field436) {
                                                               ++field512;
                                                               if(field436 == field512) {
                                                                  class97.method1886(class72.field1192);
                                                               }
                                                            }
                                                         } else if(field512 > 0) {
                                                            --field512;
                                                         }

                                                         Tile.method1519();
                                                         if(field554) {
                                                            class178.method3195();
                                                         }

                                                         for(var18 = 0; var18 < 5; ++var18) {
                                                            ++field537[var18];
                                                         }

                                                         class109.chatMessages.method824();
                                                         var18 = class114.method2153();
                                                         var19 = class105.keyboardIdleTicks;
                                                         if(var18 > 15000 && var19 > 15000) {
                                                            field340 = 250;
                                                            class15.method177(14500);
                                                            field330.method2967(186);
                                                         }

                                                         ++field556;
                                                         if(field556 > 500) {
                                                            field556 = 0;
                                                            var6 = (int)(Math.random() * 8.0D);
                                                            if((var6 & 1) == 1) {
                                                               field505 += field310;
                                                            }

                                                            if((var6 & 2) == 2) {
                                                               field515 += field536;
                                                            }

                                                            if((var6 & 4) == 4) {
                                                               field365 += field295;
                                                            }
                                                         }

                                                         if(field505 < -50) {
                                                            field310 = 2;
                                                         }

                                                         if(field505 > 50) {
                                                            field310 = -2;
                                                         }

                                                         if(field515 < -55) {
                                                            field536 = 2;
                                                         }

                                                         if(field515 > 55) {
                                                            field536 = -2;
                                                         }

                                                         if(field365 < -40) {
                                                            field295 = 1;
                                                         }

                                                         if(field365 > 40) {
                                                            field295 = -1;
                                                         }

                                                         ++field362;
                                                         if(field362 > 500) {
                                                            field362 = 0;
                                                            var6 = (int)(Math.random() * 8.0D);
                                                            if((var6 & 1) == 1) {
                                                               mapScale += field560;
                                                            }

                                                            if((var6 & 2) == 2) {
                                                               mapScaleDelta += field361;
                                                            }
                                                         }

                                                         if(mapScale < -60) {
                                                            field560 = 2;
                                                         }

                                                         if(mapScale > 60) {
                                                            field560 = -2;
                                                         }

                                                         if(mapScaleDelta < -20) {
                                                            field361 = 1;
                                                         }

                                                         if(mapScaleDelta > 10) {
                                                            field361 = -1;
                                                         }

                                                         for(class16 var24 = (class16)field478.method2383(); null != var24; var24 = (class16)field478.method2384()) {
                                                            if((long)var24.field178 < class114.method2154() / 1000L - 5L) {
                                                               if(var24.field176 > 0) {
                                                                  class16.method183(5, "", var24.field174 + " has logged in.");
                                                               }

                                                               if(var24.field176 == 0) {
                                                                  class16.method183(5, "", var24.field174 + " has logged out.");
                                                               }

                                                               var24.method2395();
                                                            }
                                                         }

                                                         ++field336;
                                                         if(field336 > 50) {
                                                            field330.method2967(78);
                                                         }

                                                         try {
                                                            if(class6.field46 != null && field330.offset > 0) {
                                                               class6.field46.method2016(field330.payload, 0, field330.offset);
                                                               field330.offset = 0;
                                                               field336 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var25) {
                                                            WallObject.method1842();
                                                         }

                                                         return;
                                                      }

                                                      var39 = var37.field193;
                                                      if(var39.index < 0) {
                                                         break;
                                                      }

                                                      var47 = class174.method3178(var39.parentId);
                                                   } while(null == var47 || null == var47.children || var39.index >= var47.children.length || var39 != var47.children[var39.index]);

                                                   class13.method165(var37);
                                                }
                                             }

                                             var39 = var37.field193;
                                             if(var39.index < 0) {
                                                break;
                                             }

                                             var47 = class174.method3178(var39.parentId);
                                          } while(var47 == null || var47.children == null || var39.index >= var47.children.length || var39 != var47.children[var39.index]);

                                          class13.method165(var37);
                                       }
                                    }

                                    var39 = var37.field193;
                                    if(var39.index < 0) {
                                       break;
                                    }

                                    var47 = class174.method3178(var39.parentId);
                                 } while(null == var47 || null == var47.children || var39.index >= var47.children.length || var47.children[var39.index] != var39);

                                 class13.method165(var37);
                              }
                           }
                        }
                     }
                  }
               }
            } else if(gameState == 40 || gameState == 45) {
               class9.method100();
            }

            return;
         }

         var1.field2705.method3298(var1.field2704, (int)var1.hash, var1.field2703, false);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1577952340"
   )
   protected final void vmethod2091() {
      boolean var1;
      label316: {
         try {
            if(class138.field1929 == 2) {
               if(class60.field1083 == null) {
                  class60.field1083 = class144.method2646(class138.field1930, class138.field1931, class181.field2711);
                  if(class60.field1083 == null) {
                     var1 = false;
                     break label316;
                  }
               }

               if(null == ChatMessages.field932) {
                  ChatMessages.field932 = new class60(class138.field1927, class138.field1928);
               }

               if(class138.field1926.method2519(class60.field1083, class138.field1934, ChatMessages.field932, 22050)) {
                  class138.field1926.method2453();
                  class138.field1926.method2447(class138.field1932);
                  class138.field1926.method2521(class60.field1083, CombatInfo1.field665);
                  class138.field1929 = 0;
                  class60.field1083 = null;
                  ChatMessages.field932 = null;
                  class138.field1930 = null;
                  var1 = true;
                  break label316;
               }
            }
         } catch (Exception var13) {
            var13.printStackTrace();
            class138.field1926.method2488();
            class138.field1929 = 0;
            class60.field1083 = null;
            ChatMessages.field932 = null;
            class138.field1930 = null;
         }

         var1 = false;
      }

      if(var1 && field493 && class88.field1527 != null) {
         class88.field1527.method1022();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field497 && class114.method2154() > field497) {
            int var3 = class47.method871();
            field497 = 0L;
            if(var3 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            class8.method89();
            if(gameState >= 25) {
               field330.method2967(92);
               field330.method2815(class47.method871());
               field330.method2712(TextureProvider.field1200);
               field330.method2712(class94.field1584);
            }

            GameEngine.field1797 = true;
         } else if(GameEngine.field1785) {
            DecorativeObject.method1873(class36.canvas);
            Canvas var9 = class36.canvas;
            var9.removeMouseListener(class115.mouse);
            var9.removeMouseMotionListener(class115.mouse);
            var9.removeFocusListener(class115.mouse);
            class115.field1827 = 0;
            if(class146.field2033 != null) {
               class146.field2033.vmethod2044(class36.canvas);
            }

            field540.method2054();
            class36.canvas.setBackground(Color.black);
            CombatInfo1.method593(class36.canvas);
            method555(class36.canvas);
            if(null != class146.field2033) {
               class146.field2033.vmethod2035(class36.canvas);
            }

            if(widgetRoot != -1) {
               class112.method2051(false);
            }

            GameEngine.field1792 = true;
         }
      }

      Dimension var14 = this.method2070();
      if(var14.width != class105.field1720 || class45.field914 != var14.height || GameEngine.field1792) {
         class8.method89();
         field497 = class114.method2154() + 500L;
         GameEngine.field1792 = false;
      }

      boolean var4 = false;
      int var5;
      if(GameEngine.field1797) {
         GameEngine.field1797 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field308[var5] = true;
         }
      }

      if(var4) {
         KitDefinition.method3429();
      }

      int var6;
      if(gameState == 0) {
         GameObject.method1879(class41.field837, class41.field843, (Color)null, var4);
      } else if(gameState == 5) {
         class146.method2670(Ignore.field218, class5.field40, class33.field757, var4);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class146.method2670(Ignore.field218, class5.field40, class33.field757, var4);
         } else if(gameState == 25) {
            if(field346 == 1) {
               if(field516 > field343) {
                  field343 = field516;
               }

               var5 = (field343 * 50 - field516 * 50) / field343;
               DecorativeObject.method1875("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field346 == 2) {
               if(field344 > field345) {
                  field345 = field344;
               }

               var5 = 50 + (field345 * 50 - field344 * 50) / field345;
               DecorativeObject.method1875("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               DecorativeObject.method1875("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            if(widgetRoot != -1) {
               class63.method1145(widgetRoot);
            }

            for(var5 = 0; var5 < field487; ++var5) {
               if(field308[var5]) {
                  field490[var5] = true;
               }

               field491[var5] = field308[var5];
               field308[var5] = false;
            }

            field488 = gameCycle;
            field504 = -1;
            field501 = -1;
            class7.field51 = null;
            if(widgetRoot != -1) {
               field487 = 0;
               class26.method566(widgetRoot, 0, 0, TextureProvider.field1200, class94.field1584, 0, 0, -1);
            }

            class219.method3891();
            if(!isMenuOpen) {
               if(field504 != -1) {
                  var5 = field504;
                  var6 = field501;
                  if(menuOptionCount >= 2 || field437 != 0 || field439) {
                     String var7;
                     if(field437 == 1 && menuOptionCount < 2) {
                        var7 = "Use" + " " + field438 + " " + "->";
                     } else if(field439 && menuOptionCount < 2) {
                        var7 = field562 + " " + field443 + " " + "->";
                     } else {
                        var7 = Projectile.method775(menuOptionCount - 1);
                     }

                     if(menuOptionCount > 2) {
                        var7 = var7 + class16.method182(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
                     }

                     Ignore.field218.method3791(var7, var5 + 4, 15 + var6, 16777215, 0, gameCycle / 1000);
                  }
               }
            } else {
               NPC.method692();
            }

            if(field496 == 3) {
               for(var5 = 0; var5 < field487; ++var5) {
                  if(field491[var5]) {
                     class219.method3898(widgetPositionX[var5], widgetPositionY[var5], widgetBoundsWidth[var5], widgetBoundsHeight[var5], 16711935, 128);
                  } else if(field490[var5]) {
                     class219.method3898(widgetPositionX[var5], widgetPositionY[var5], widgetBoundsWidth[var5], widgetBoundsHeight[var5], 16711680, 128);
                  }
               }
            }

            class176.method3183(class63.plane, class5.localPlayer.x, class5.localPlayer.y, field363);
            field363 = 0;
         } else if(gameState == 40) {
            DecorativeObject.method1875("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            DecorativeObject.method1875("Please wait...", false);
         }
      } else {
         class146.method2670(Ignore.field218, class5.field40, class33.field757, var4);
      }

      Graphics var10;
      if(gameState == 30 && field496 == 0 && !var4) {
         try {
            var10 = class36.canvas.getGraphics();

            for(var6 = 0; var6 < field487; ++var6) {
               if(field490[var6]) {
                  TextureProvider.bufferProvider.drawSub(var10, widgetPositionX[var6], widgetPositionY[var6], widgetBoundsWidth[var6], widgetBoundsHeight[var6]);
                  field490[var6] = false;
               }
            }
         } catch (Exception var12) {
            class36.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var10 = class36.canvas.getGraphics();
            TextureProvider.bufferProvider.draw(var10, 0, 0);

            for(var6 = 0; var6 < field487; ++var6) {
               field490[var6] = false;
            }
         } catch (Exception var11) {
            class36.canvas.repaint();
         }
      }

   }

   static {
      field376 = class40.field824;
      field315 = class40.field824;
      field382 = 0;
      field318 = 0;
      field319 = 0;
      field320 = 0;
      field514 = 0;
      field322 = 0;
      field323 = 0;
      field372 = 0;
      cachedNPCs = new NPC['耀'];
      field492 = 0;
      field327 = new int['耀'];
      field328 = 0;
      field384 = new int[250];
      field330 = new class159(5000);
      field331 = new class159(5000);
      field332 = new class159(15000);
      field523 = 0;
      packetOpcode = 0;
      field335 = 0;
      field336 = 0;
      field337 = 0;
      field410 = 0;
      field339 = 0;
      field340 = 0;
      field341 = false;
      field516 = 0;
      field343 = 1;
      field344 = 0;
      field345 = 1;
      field346 = 0;
      collisionMaps = new CollisionData[4];
      field348 = false;
      field447 = new int[4][13][13];
      field528 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field505 = 0;
      field310 = 2;
      field515 = 0;
      field536 = 2;
      field365 = 0;
      field295 = 1;
      field556 = 0;
      mapScale = 0;
      field560 = 2;
      mapScaleDelta = 0;
      field361 = 1;
      field362 = 0;
      field363 = 0;
      field359 = 2301979;
      field568 = 5063219;
      field411 = 3353893;
      field353 = 7759444;
      field368 = false;
      field369 = 0;
      field370 = 128;
      mapAngle = 0;
      field502 = 0;
      field552 = 0;
      field374 = 0;
      field519 = 0;
      field321 = 50;
      field402 = 0;
      field378 = false;
      field379 = 0;
      field292 = 0;
      field381 = 50;
      field286 = new int[field381];
      field304 = new int[field381];
      field458 = new int[field381];
      field530 = new int[field381];
      field386 = new int[field381];
      field355 = new int[field381];
      field414 = new int[field381];
      field389 = new String[field381];
      field390 = new int[104][104];
      field391 = 0;
      field392 = -1;
      field393 = -1;
      field500 = 0;
      field395 = 0;
      field396 = 0;
      field476 = 0;
      field398 = 0;
      field399 = 0;
      field400 = 0;
      field431 = 0;
      field387 = 0;
      field403 = 0;
      field404 = false;
      field405 = 0;
      field542 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field409 = 0;
      field316 = 0;
      field287 = new int[1000];
      field412 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field413 = new String[8];
      field373 = new boolean[8];
      field415 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field416 = -1;
      groundItemDeque = new Deque[4][104][104];
      field300 = new Deque();
      projectiles = new Deque();
      field511 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field424 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field504 = -1;
      field501 = -1;
      field512 = 0;
      field436 = 50;
      field437 = 0;
      field438 = null;
      field439 = false;
      field385 = -1;
      field441 = -1;
      field562 = null;
      field443 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field446 = 0;
      field354 = 0;
      field448 = null;
      energy = 0;
      weight = 0;
      field451 = 0;
      field452 = -1;
      field453 = false;
      field454 = false;
      field434 = false;
      field566 = null;
      field455 = null;
      field435 = null;
      field459 = 0;
      field460 = 0;
      field461 = null;
      field388 = false;
      field463 = -1;
      field464 = -1;
      field465 = false;
      field433 = -1;
      field467 = -1;
      field468 = false;
      field469 = 1;
      field470 = new int[32];
      field471 = 0;
      field472 = new int[32];
      field473 = 0;
      field326 = new int[32];
      field557 = 0;
      field457 = 0;
      field477 = 0;
      field338 = 0;
      field466 = 0;
      field480 = 0;
      field481 = 0;
      field482 = 0;
      field483 = new Deque();
      field484 = new Deque();
      field485 = new Deque();
      widgetFlags = new XHashTable(512);
      field487 = 0;
      field488 = -2;
      field308 = new boolean[100];
      field490 = new boolean[100];
      field491 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field496 = 0;
      field497 = 0L;
      isResized = true;
      field499 = 765;
      field383 = 1;
      field380 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field352 = 0;
      field503 = 0;
      field303 = "";
      field541 = new long[100];
      field506 = 0;
      field507 = 0;
      field508 = new int[128];
      field302 = new int[128];
      field406 = -1L;
      field290 = null;
      clanChatOwner = null;
      field513 = -1;
      field377 = 0;
      field423 = new int[1000];
      field474 = new int[1000];
      field517 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field520 = 0;
      field521 = 255;
      field522 = -1;
      field493 = false;
      field524 = 127;
      field525 = 127;
      field526 = 0;
      field527 = new int[50];
      field351 = new int[50];
      field529 = new int[50];
      field349 = new int[50];
      field531 = new class53[50];
      field554 = false;
      field533 = new boolean[5];
      field534 = new int[5];
      field535 = new int[5];
      field367 = new int[5];
      field537 = new int[5];
      field538 = 256;
      field539 = 205;
      field366 = 256;
      field394 = 320;
      field397 = 1;
      field462 = 32767;
      field544 = 1;
      field510 = 32767;
      field546 = 0;
      field547 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field312 = 0;
      friends = new Friend[400];
      field478 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field495 = new PlayerComposition();
      field558 = -1;
      field559 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field561 = -1L;
      field294 = -1L;
      field563 = new class22();
      field564 = new int[50];
      field565 = new int[50];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1315306595"
   )
   protected final void vmethod2071() {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "169773653"
   )
   protected final void vmethod2064() {
      MessageNode.field237 = field428 == 0?'ꩊ':'鱀' + world;
      class38.field812 = field428 == 0?443:'썐' + world;
      class206.field3087 = MessageNode.field237;
      class164.field2166 = class167.field2191;
      class119.field1867 = class167.field2193;
      PlayerComposition.field2185 = class167.field2192;
      FrameMap.field1461 = class167.field2194;
      WidgetNode.method185();
      CombatInfo1.method593(class36.canvas);
      method555(class36.canvas);
      class146.field2033 = class101.method1908();
      if(null != class146.field2033) {
         class146.field2033.vmethod2035(class36.canvas);
      }

      GroundObject.field1294 = new class116(255, class104.field1688, class104.field1689, 500000);
      XGrandExchangeOffer.field35 = class39.method728();
      TextureProvider.field1210 = this.getToolkit().getSystemClipboard();
      class164.method3055(this, class10.field85);
      if(field428 != 0) {
         field475 = true;
      }

      int var1 = XGrandExchangeOffer.field35.field701;
      field497 = 0L;
      if(var1 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      class8.method89();
      if(gameState >= 25) {
         field330.method2967(92);
         field330.method2815(class47.method871());
         field330.method2712(TextureProvider.field1200);
         field330.method2712(class94.field1584);
      }

      GameEngine.field1797 = true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1746151113"
   )
   void method380() {
      if(gameState != 1000) {
         long var2 = class114.method2154();
         int var4 = (int)(var2 - class185.field2757);
         class185.field2757 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class185.field2756 += var4;
         boolean var1;
         if(class185.field2767 == 0 && class185.field2761 == 0 && class185.field2764 == 0 && class185.field2765 == 0) {
            var1 = true;
         } else if(class185.field2774 == null) {
            var1 = false;
         } else {
            try {
               label245: {
                  if(class185.field2756 > 30000) {
                     throw new IOException();
                  }

                  class181 var5;
                  Buffer var6;
                  while(class185.field2761 < 20 && class185.field2765 > 0) {
                     var5 = (class181)class185.field2773.method2296();
                     var6 = new Buffer(4);
                     var6.method2815(1);
                     var6.method2713((int)var5.hash);
                     class185.field2774.method2016(var6.payload, 0, 4);
                     class185.field2758.method2291(var5, var5.hash);
                     --class185.field2765;
                     ++class185.field2761;
                  }

                  while(class185.field2767 < 20 && class185.field2764 > 0) {
                     var5 = (class181)class185.field2762.method2244();
                     var6 = new Buffer(4);
                     var6.method2815(0);
                     var6.method2713((int)var5.hash);
                     class185.field2774.method2016(var6.payload, 0, 4);
                     var5.method2380();
                     class185.field2766.method2291(var5, var5.hash);
                     --class185.field2764;
                     ++class185.field2767;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class185.field2774.method2014();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class185.field2756 = 0;
                     byte var7 = 0;
                     if(null == class172.field2358) {
                        var7 = 8;
                     } else if(class185.field2768 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class185.field2775.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class185.field2774.method2015(class185.field2775.payload, class185.field2775.offset, var8);
                        if(class185.field2760 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class185.field2775.payload[class185.field2775.offset + var9] ^= class185.field2760;
                           }
                        }

                        class185.field2775.offset += var8;
                        if(class185.field2775.offset < var7) {
                           break;
                        }

                        if(class172.field2358 == null) {
                           class185.field2775.offset = 0;
                           var9 = class185.field2775.readUnsignedByte();
                           var10 = class185.field2775.readUnsignedShort();
                           int var11 = class185.field2775.readUnsignedByte();
                           var12 = class185.field2775.method2731();
                           long var13 = (long)(var10 + (var9 << 16));
                           class181 var15 = (class181)class185.field2758.method2299(var13);
                           class225.field3219 = true;
                           if(var15 == null) {
                              var15 = (class181)class185.field2766.method2299(var13);
                              class225.field3219 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class172.field2358 = var15;
                           class149.field2051 = new Buffer(var12 + var16 + class172.field2358.field2710);
                           class149.field2051.method2815(var11);
                           class149.field2051.method2714(var12);
                           class185.field2768 = 8;
                           class185.field2775.offset = 0;
                        } else if(class185.field2768 == 0) {
                           if(class185.field2775.payload[0] == -1) {
                              class185.field2768 = 1;
                              class185.field2775.offset = 0;
                           } else {
                              class172.field2358 = null;
                           }
                        }
                     } else {
                        var8 = class149.field2051.payload.length - class172.field2358.field2710;
                        var9 = 512 - class185.field2768;
                        if(var9 > var8 - class149.field2051.offset) {
                           var9 = var8 - class149.field2051.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class185.field2774.method2015(class149.field2051.payload, class149.field2051.offset, var9);
                        if(class185.field2760 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class149.field2051.payload[class149.field2051.offset + var10] ^= class185.field2760;
                           }
                        }

                        class149.field2051.offset += var9;
                        class185.field2768 += var9;
                        if(class149.field2051.offset == var8) {
                           if(16711935L == class172.field2358.hash) {
                              class118.field1862 = class149.field2051;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class184 var19 = class185.field2770[var10];
                                 if(null != var19) {
                                    class118.field1862.offset = 8 * var10 + 5;
                                    var12 = class118.field1862.method2731();
                                    int var23 = class118.field1862.method2731();
                                    var19.method3297(var12, var23);
                                 }
                              }
                           } else {
                              class185.field2769.reset();
                              class185.field2769.update(class149.field2051.payload, 0, var8);
                              var10 = (int)class185.field2769.getValue();
                              if(class172.field2358.field2709 != var10) {
                                 try {
                                    class185.field2774.method2027();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class185.field2772;
                                 class185.field2774 = null;
                                 class185.field2760 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label245;
                              }

                              class185.field2772 = 0;
                              class185.field2763 = 0;
                              class172.field2358.field2708.method3310((int)(class172.field2358.hash & 65535L), class149.field2051.payload, (class172.field2358.hash & 16711680L) == 16711680L, class225.field3219);
                           }

                           class172.field2358.unlink();
                           if(class225.field3219) {
                              --class185.field2761;
                           } else {
                              --class185.field2767;
                           }

                           class185.field2768 = 0;
                           class172.field2358 = null;
                           class149.field2051 = null;
                        } else {
                           if(class185.field2768 != 512) {
                              break;
                           }

                           class185.field2768 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class185.field2774.method2027();
               } catch (Exception var20) {
                  ;
               }

               ++class185.field2763;
               class185.field2774 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method542();
         }

      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "474965943"
   )
   static final void method400(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field571 == 0) {
         var1 = class159.region.method1823(var0.field575, var0.field584, var0.field573);
      }

      if(var0.field571 == 1) {
         var1 = class159.region.method1693(var0.field575, var0.field584, var0.field573);
      }

      if(var0.field571 == 2) {
         var1 = class159.region.method1691(var0.field575, var0.field584, var0.field573);
      }

      if(var0.field571 == 3) {
         var1 = class159.region.method1803(var0.field575, var0.field584, var0.field573);
      }

      if(var1 != 0) {
         int var5 = class159.region.method1696(var0.field575, var0.field584, var0.field573, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field572 = var2;
      var0.field576 = var3;
      var0.field581 = var4;
   }

   public final void init() {
      if(this.method2055()) {
         class214[] var1 = class207.method3768();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class214 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3157);
            if(null != var4) {
               switch(Integer.parseInt(var3.field3157)) {
               case 1:
                  class112.field1776 = var4;
                  break;
               case 2:
                  class167.field2195 = var4;
                  break;
               case 3:
                  class228.field3240 = Integer.parseInt(var4);
                  break;
               case 4:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
               case 5:
               case 7:
               default:
                  break;
               case 6:
                  world = Integer.parseInt(var4);
                  break;
               case 8:
                  field291 = class173.method3177(Integer.parseInt(var4));
                  break;
               case 9:
                  Ignore.field215 = Integer.parseInt(var4);
                  break;
               case 10:
                  field428 = Integer.parseInt(var4);
                  break;
               case 11:
                  flags = Integer.parseInt(var4);
                  break;
               case 12:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 13:
                  field509 = Integer.parseInt(var4);
                  break;
               case 14:
                  class179[] var5 = new class179[]{class179.field2695, class179.field2694, class179.field2693, class179.field2692, class179.field2691, class179.field2697};
                  class145.field2024 = (class179)FileOnDisk.method1390(var5, Integer.parseInt(var4));
                  if(class179.field2695 == class145.field2024) {
                     Friend.field155 = class228.field3230;
                  } else {
                     Friend.field155 = class228.field3239;
                  }
               }
            }
         }

         ChatLineBuffer.method892();
         class139.host = this.getCodeBase().getHost();
         String var7 = field291.field2685;
         byte var8 = 0;

         try {
            class187.method3346("oldschool", var7, var8, 16);
         } catch (Exception var6) {
            FaceNormal.method1844((String)null, var6);
         }

         field540 = this;
         this.method2053(765, 503, 128);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "121"
   )
   void method524(int var1) {
      class159.field2140 = null;
      field317 = null;
      field318 = 0;
      if(class206.field3087 == MessageNode.field237) {
         class206.field3087 = class38.field812;
      } else {
         class206.field3087 = MessageNode.field237;
      }

      ++field320;
      if(field320 < 2 || var1 != 7 && var1 != 9) {
         if(field320 >= 2 && var1 == 6) {
            this.method2068("js5connect_outofdate");
            gameState = 1000;
         } else if(field320 >= 4) {
            if(gameState <= 5) {
               this.method2068("js5connect");
               gameState = 1000;
            } else {
               field319 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2068("js5connect_full");
         gameState = 1000;
      } else {
         field319 = 3000;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1106088762"
   )
   static int method539(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
   )
   void method542() {
      if(class185.field2772 >= 4) {
         this.method2068("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2763 >= 4) {
            if(gameState <= 5) {
               this.method2068("js5io");
               gameState = 1000;
               return;
            }

            field319 = 3000;
            class185.field2763 = 3;
         }

         if(--field319 + 1 <= 0) {
            try {
               if(field318 == 0) {
                  class159.field2140 = Tile.field1346.method1918(class139.host, class206.field3087);
                  ++field318;
               }

               if(field318 == 1) {
                  if(class159.field2140.field1664 == 2) {
                     this.method524(-1);
                     return;
                  }

                  if(class159.field2140.field1664 == 1) {
                     ++field318;
                  }
               }

               if(field318 == 2) {
                  field317 = new class110((Socket)class159.field2140.field1662, Tile.field1346);
                  Buffer var1 = new Buffer(5);
                  var1.method2815(15);
                  var1.method2714(128);
                  field317.method2016(var1.payload, 0, 5);
                  ++field318;
                  class168.field2198 = class114.method2154();
               }

               if(field318 == 3) {
                  if(gameState > 5 && field317.method2014() <= 0) {
                     if(class114.method2154() - class168.field2198 > 30000L) {
                        this.method524(-2);
                        return;
                     }
                  } else {
                     int var2 = field317.method2013();
                     if(var2 != 0) {
                        this.method524(var2);
                        return;
                     }

                     ++field318;
                  }
               }

               if(field318 == 4) {
                  class168.method3103(field317, gameState > 20);
                  class159.field2140 = null;
                  field317 = null;
                  field318 = 0;
                  field320 = 0;
               }
            } catch (IOException var3) {
               this.method524(-3);
            }

         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-528391423"
   )
   public static void method555(Component var0) {
      var0.addMouseListener(class115.mouse);
      var0.addMouseMotionListener(class115.mouse);
      var0.addFocusListener(class115.mouse);
   }
}
