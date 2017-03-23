import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 849851003
   )
   static int field307;
   @ObfuscatedName("c")
   static Client field308;
   @ObfuscatedName("cx")
   @Export("secretCipherBuffer1")
   static CipherBuffer secretCipherBuffer1;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -461626957
   )
   static int field310;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -696616229
   )
   static int field311;
   @ObfuscatedName("dr")
   static int[][][] field312;
   @ObfuscatedName("v")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1555953927
   )
   static int field314 = -1;
   @ObfuscatedName("lm")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1691805125
   )
   static int field316;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1057362745
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("t")
   static boolean field318 = true;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1205609047
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -3160753022584867505L
   )
   static long field320 = -1L;
   @ObfuscatedName("n")
   static class20 field321;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1925399443
   )
   static int field322 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -132971223
   )
   static int field323 = -1;
   @ObfuscatedName("om")
   static short field324;
   @ObfuscatedName("hu")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -1584352043
   )
   static int field326;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -2068296025
   )
   static int field327 = 0;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 500748343
   )
   static int field328;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1684403725
   )
   static int field329 = 0;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -1683348039
   )
   static int field330;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1517809183
   )
   static int field331 = 0;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1944291091
   )
   static int field332 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1378291471
   )
   static int field333 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1459985807
   )
   static int field334 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1429672479
   )
   static int field335 = 0;
   @ObfuscatedName("aq")
   static class40 field336;
   @ObfuscatedName("aj")
   static class40 field337;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 8407077
   )
   static int field338;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -2099708553
   )
   static int field339;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1489371065
   )
   static int field340;
   @ObfuscatedName("aw")
   static class184 field341;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      longValue = 6066528604505498945L
   )
   static long field342;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1283602049
   )
   static int field343;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 1913518065
   )
   static int field344;
   @ObfuscatedName("jl")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("iy")
   static boolean field346;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1568405
   )
   static int field347;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1454917795
   )
   static int field348;
   @ObfuscatedName("bg")
   static byte[] field349;
   @ObfuscatedName("cb")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -739706049
   )
   static int field351;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -1828742621
   )
   static int field352;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1569342935
   )
   static int field353;
   @ObfuscatedName("ox")
   static int[] field354;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1641960001
   )
   static int field355;
   @ObfuscatedName("cn")
   static CipherBuffer field356;
   @ObfuscatedName("cl")
   @Export("secretCipherBuffer2")
   static CipherBuffer secretCipherBuffer2;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1755325733
   )
   static int field358;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1659936361
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1383549511
   )
   static int field360;
   @ObfuscatedName("dm")
   static final int[] field361;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1695306109
   )
   static int field362 = 0;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1058361461
   )
   static int field363;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -2129323355
   )
   static int field364;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 795672697
   )
   static int field365;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      longValue = 5055474116632871415L
   )
   static long field366;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = -418905755
   )
   static int field367;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 92550243
   )
   static int field368;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -1901204937
   )
   static int field369;
   @ObfuscatedName("fi")
   static int[] field370;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 435964955
   )
   static int field371;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("gd")
   static int[][] field373;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -807604409
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 938351861
   )
   static int field375;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -1212882327
   )
   static int field376;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -524132209
   )
   static int field377;
   @ObfuscatedName("kr")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1262883783
   )
   static int field379;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -928983263
   )
   static int field380;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2121193137
   )
   static int field381 = 0;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 909399645
   )
   static int field382;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 362425261
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -377655959
   )
   static int field384;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 54882919
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -1430803033
   )
   static int field386;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -1733705999
   )
   static int field387;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1352245729
   )
   static int field388;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -1617060923
   )
   static int field389;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 783237527
   )
   static int field390;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 2054912489
   )
   static int field391;
   @ObfuscatedName("aa")
   static boolean field392 = false;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -224459031
   )
   static int field393;
   @ObfuscatedName("ft")
   static boolean field394;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -703255759
   )
   static int field395;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 1926420269
   )
   static int field396;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1553361911
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("kj")
   static boolean field398;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 439425361
   )
   static int field399;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -2117374245
   )
   static int field400;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -211836111
   )
   static int field401;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -855053871
   )
   static int field402;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -411464267
   )
   static int field403;
   @ObfuscatedName("fp")
   static boolean field404;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -1869452855
   )
   static int field405;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 597704119
   )
   static int field406;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 1078328337
   )
   static int field407;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 1415999823
   )
   static int field408;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1738918223
   )
   static int field409 = 0;
   @ObfuscatedName("fh")
   static int[] field410;
   @ObfuscatedName("ld")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("fz")
   static int[] field412;
   @ObfuscatedName("gk")
   static int[] field413;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 843439195
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 5647881
   )
   static int field415;
   @ObfuscatedName("hl")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 760118787
   )
   static int field417;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 574705005
   )
   static int field418;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = -1106234991
   )
   static int field419;
   @ObfuscatedName("ir")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 237562827
   )
   static int field421;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -855697487
   )
   static int field422;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1744040045
   )
   static int field423;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -845996117
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1453462513
   )
   static int field425;
   @ObfuscatedName("hb")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1863362735
   )
   static int field427;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1458032783
   )
   static int field428;
   @ObfuscatedName("cv")
   static int[] field430;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1401465113
   )
   static int field431;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1613071717
   )
   static int field432;
   @ObfuscatedName("gb")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -639803571
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("mq")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -779268783
   )
   static int field436;
   @ObfuscatedName("hi")
   static int[] field437;
   @ObfuscatedName("ha")
   static final int[] field438;
   @ObfuscatedName("l")
   static boolean field439 = false;
   @ObfuscatedName("ny")
   static boolean field440;
   @ObfuscatedName("hr")
   static int[] field441;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 456536979
   )
   static int field442;
   @ObfuscatedName("hv")
   static Deque field443;
   @ObfuscatedName("hm")
   static Deque field444;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = 1949849781
   )
   static int field445;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 685875277
   )
   static int field446;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 1523378605
   )
   static int field447;
   @ObfuscatedName("hs")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("el")
   static SpritePixels[] field449;
   @ObfuscatedName("jn")
   static boolean field450;
   @ObfuscatedName("he")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 610105593
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -1364578847
   )
   static int field453;
   @ObfuscatedName("ic")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("ih")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 798111585
   )
   static int field456;
   @ObfuscatedName("ig")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 442594493
   )
   static int field458 = 0;
   @ObfuscatedName("ga")
   static int[] field459;
   @ObfuscatedName("by")
   static class184 field460;
   @ObfuscatedName("ge")
   static boolean field461;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -986661071
   )
   static int field462;
   @ObfuscatedName("hz")
   @Export("playerOptionsPriority")
   static boolean[] playerOptionsPriority;
   @ObfuscatedName("lk")
   static int[] field464;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 109185671
   )
   static int field465;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -413270563
   )
   static int field466;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -1542848217
   )
   static int field467;
   @ObfuscatedName("is")
   static boolean field468;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = 102620189
   )
   static int field469;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 1074609415
   )
   static int field470;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -2025537709
   )
   static int field471;
   @ObfuscatedName("ja")
   static String field472;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 159541899
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -1367941507
   )
   static int field474;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 787321191
   )
   static int field475;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 914863853
   )
   static int field476;
   @ObfuscatedName("jd")
   static Widget field477;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -598437225
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ph")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 357350099
   )
   static int field480;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = 436991807
   )
   static int field481;
   @ObfuscatedName("js")
   static boolean field482;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1834128195
   )
   static int field483;
   @ObfuscatedName("jj")
   static boolean field484;
   @ObfuscatedName("fa")
   static int[] field485;
   @ObfuscatedName("jp")
   static Widget field486;
   @ObfuscatedName("ju")
   static Widget field487;
   @ObfuscatedName("lp")
   static boolean[] field488;
   @ObfuscatedName("jy")
   static String field489;
   @ObfuscatedName("jh")
   static Widget field490;
   @ObfuscatedName("jr")
   static boolean field491;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1224078107
   )
   static int field492;
   @ObfuscatedName("fw")
   static int[] field493;
   @ObfuscatedName("mx")
   static int[] field494;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 2106046031
   )
   static int field495;
   @ObfuscatedName("iw")
   static String field496;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1995426857
   )
   static int field497;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1604201655
   )
   static int field498;
   @ObfuscatedName("kn")
   static int[] field499;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 100700031
   )
   static int field500;
   @ObfuscatedName("gn")
   static String[] field501;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -42520281
   )
   static int field502;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1025796235
   )
   static int field503;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1930256373
   )
   static int field504;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -521005547
   )
   static int field505;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -2038739763
   )
   static int field506;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 354641673
   )
   static int field507;
   @ObfuscatedName("oo")
   static boolean[] field508;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 1503526609
   )
   static int field509;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -1944872161
   )
   static int field510;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 162719447
   )
   static int field511;
   @ObfuscatedName("kg")
   static Deque field512;
   @ObfuscatedName("ku")
   static Deque field513;
   @ObfuscatedName("ll")
   static Deque field514;
   @ObfuscatedName("lz")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("kq")
   static int[] field516;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -13636177
   )
   static int field517;
   @ObfuscatedName("la")
   static boolean[] field518;
   @ObfuscatedName("lb")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("lg")
   static boolean[] field520;
   @ObfuscatedName("hh")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("oq")
   static short field522;
   @ObfuscatedName("le")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("hq")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 1285069731
   )
   static int field525;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -1434841651
   )
   static int field526;
   @ObfuscatedName("lw")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -1164116511
   )
   static int field528;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1487548237
   )
   static int field529;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1040110697
   )
   static int field530;
   @ObfuscatedName("il")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 973422489
   )
   static int field532;
   @ObfuscatedName("lq")
   static String field533;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 2026055175
   )
   static int field534;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -906232399
   )
   static int field535;
   @ObfuscatedName("ps")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("mp")
   static int[] field537;
   @ObfuscatedName("mc")
   static int[] field538;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      longValue = -7240749804398592587L
   )
   static long field539;
   @ObfuscatedName("my")
   static String field540;
   @ObfuscatedName("ia")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("do")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 1850316753
   )
   static int field543;
   @ObfuscatedName("mz")
   static int[] field544;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -1524213121
   )
   static int field545;
   @ObfuscatedName("mh")
   static SpritePixels[] field546;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 168856691
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -153397441
   )
   static int field548;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -693705329
   )
   static int field549;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1668635869
   )
   static int field550;
   @ObfuscatedName("jv")
   static Widget field551;
   @ObfuscatedName("ni")
   static boolean field552;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 93711215
   )
   static int field553;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -583785375
   )
   static int field554;
   @ObfuscatedName("mm")
   static long[] field555;
   @ObfuscatedName("nu")
   static int[] field556;
   @ObfuscatedName("nb")
   static int[] field557;
   @ObfuscatedName("na")
   static int[] field558;
   @ObfuscatedName("nn")
   static int[] field559;
   @ObfuscatedName("nq")
   static class53[] field560;
   @ObfuscatedName("ik")
   static boolean field561;
   @ObfuscatedName("jt")
   static boolean field562;
   @ObfuscatedName("ol")
   static int[] field563;
   @ObfuscatedName("oc")
   static int[] field564;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1936738489
   )
   static int field565;
   @ObfuscatedName("or")
   static int[] field566;
   @ObfuscatedName("od")
   static short field567;
   @ObfuscatedName("os")
   static short field568;
   @ObfuscatedName("oz")
   static short field569;
   @ObfuscatedName("cj")
   static int[] field570;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -432793345
   )
   static int loginState;
   @ObfuscatedName("ou")
   static short field572;
   @ObfuscatedName("ob")
   static short field573;
   @ObfuscatedName("oj")
   static short field574;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 969987875
   )
   static int field575;
   @ObfuscatedName("pr")
   static PlayerComposition field576;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 1859462297
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = 888427091
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = 1199958539
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = 1182972749
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("ar")
   static boolean field581 = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 252428221
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("pb")
   static class130 field583;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -2124262451
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 2139968293
   )
   static int field585;
   @ObfuscatedName("d")
   static boolean field586 = true;
   @ObfuscatedName("cr")
   static boolean field587;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -1322167675
   )
   static int field588;
   @ObfuscatedName("pn")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 1468145199
   )
   static int field590;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      longValue = 7903002195392002027L
   )
   static long field591;
   @ObfuscatedName("pp")
   static final class22 field592;
   @ObfuscatedName("pa")
   static int[] field593;
   @ObfuscatedName("pt")
   static int[] field594;
   @ObfuscatedName("bb")
   static ModIcon field595;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   protected final void vmethod2229() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2051261552"
   )
   protected final void vmethod2179() {
      Ignore.field238 = field381 == 0?'ꩊ':'鱀' + world;
      field446 = field381 == 0?443:'썐' + world;
      GameObject.field1636 = Ignore.field238;
      class164.field2145 = class167.field2172;
      class6.field62 = class167.field2170;
      class15.field187 = class167.field2173;
      class138.field1921 = class167.field2171;
      Renderable.method1947();
      Canvas var1 = CollisionData.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class105.keyboard);
      var1.addFocusListener(class105.keyboard);
      Canvas var2 = CollisionData.canvas;
      var2.addMouseListener(class115.mouse);
      var2.addMouseMotionListener(class115.mouse);
      var2.addFocusListener(class115.mouse);

      class106 var3;
      try {
         var3 = new class106();
      } catch (Throwable var12) {
         var3 = null;
      }

      FaceNormal.field1575 = var3;
      if(null != FaceNormal.field1575) {
         FaceNormal.field1575.vmethod2141(CollisionData.canvas);
      }

      class15.field190 = new class116(255, class104.field1696, class104.field1691, 500000);
      FileOnDisk var5 = null;
      class30 var6 = new class30();

      try {
         var5 = class2.method33("", WidgetNode.field218.field2677, false);
         byte[] var7 = new byte[(int)var5.method1480()];

         int var9;
         for(int var8 = 0; var8 < var7.length; var8 += var9) {
            var9 = var5.method1476(var7, var8, var7.length - var8);
            if(var9 == -1) {
               throw new IOException();
            }
         }

         var6 = new class30(new Buffer(var7));
      } catch (Exception var13) {
         ;
      }

      try {
         if(var5 != null) {
            var5.method1479();
         }
      } catch (Exception var11) {
         ;
      }

      class8.field84 = var6;
      class25.field608 = this.getToolkit().getSystemClipboard();
      GameEngine.method2243(this, class33.field777);
      if(field381 != 0) {
         field392 = true;
      }

      int var10 = class8.field84.field715;
      field342 = 0L;
      if(var10 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      class22.method235();
      if(gameState >= 25) {
         class45.method910();
      }

      GameEngine.field1787 = true;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method287();
      Projectile.method872();

      int var1;
      try {
         if(class138.field1920 == 1) {
            var1 = class138.field1919.method2531();
            if(var1 > 0 && class138.field1919.method2537()) {
               var1 -= XClanMember.field302;
               if(var1 < 0) {
                  var1 = 0;
               }

               class138.field1919.method2566(var1);
            } else {
               class138.field1919.method2536();
               class138.field1919.method2612();
               if(class138.field1916 != null) {
                  class138.field1920 = 2;
               } else {
                  class138.field1920 = 0;
               }

               class179.field2679 = null;
               class30.field721 = null;
            }
         }
      } catch (Exception var37) {
         var37.printStackTrace();
         class138.field1919.method2536();
         class138.field1920 = 0;
         class179.field2679 = null;
         class30.field721 = null;
         class138.field1916 = null;
      }

      class47.method950();
      class88.method1938();
      class20.method222();
      if(FaceNormal.field1575 != null) {
         var1 = FaceNormal.field1575.vmethod2143();
         field511 = var1;
      }

      if(gameState == 0) {
         class115.method2271();
         class103.method2046();
      } else if(gameState == 5) {
         GameEngine.method2240(this);
         class115.method2271();
         class161.field2129.vmethod2107();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1783[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1784[var1] = 0L;
         }

         ItemLayer.field1226 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            GameEngine.method2240(this);
            class47.processLoginState();
         } else if(gameState == 25) {
            ChatMessages.method942(false);
            field389 = 0;
            boolean var38 = true;

            int var2;
            for(var2 = 0; var2 < Ignore.field242.length; ++var2) {
               if(class22.field266[var2] != -1 && Ignore.field242[var2] == null) {
                  Ignore.field242[var2] = class33.field778.getConfigData(class22.field266[var2], 0);
                  if(null == Ignore.field242[var2]) {
                     var38 = false;
                     ++field389;
                  }
               }

               if(class6.field65[var2] != -1 && class145.field2019[var2] == null) {
                  class145.field2019[var2] = class33.field778.getConfigData(class6.field65[var2], 0, XGrandExchangeOffer.xteaKeys[var2]);
                  if(class145.field2019[var2] == null) {
                     var38 = false;
                     ++field389;
                  }
               }
            }

            if(!var38) {
               field371 = 1;
            } else {
               field369 = 0;
               var38 = true;

               int var4;
               int var5;
               for(var2 = 0; var2 < Ignore.field242.length; ++var2) {
                  byte[] var3 = class145.field2019[var2];
                  if(var3 != null) {
                     var4 = 64 * (class30.mapRegions[var2] >> 8) - CombatInfoListHolder.baseX;
                     var5 = 64 * (class30.mapRegions[var2] & 255) - class3.baseY;
                     if(isDynamicRegion) {
                        var4 = 10;
                        var5 = 10;
                     }

                     var38 &= class154.method3042(var3, var4, var5);
                  }
               }

               if(!var38) {
                  field371 = 2;
               } else {
                  if(field371 != 0) {
                     class22.method238("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class47.method950();
                  class149.method2797();
                  class47.method950();
                  Friend.region.method1895();
                  class47.method950();
                  System.gc();

                  for(var2 = 0; var2 < 4; ++var2) {
                     collisionMaps[var2].method2300();
                  }

                  int var33;
                  for(var2 = 0; var2 < 4; ++var2) {
                     for(var33 = 0; var33 < 104; ++var33) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           class10.tileSettings[var2][var33][var4] = 0;
                        }
                     }
                  }

                  class47.method950();
                  class156.method3064();
                  var2 = Ignore.field242.length;
                  World.method669();
                  ChatMessages.method942(true);
                  int var35;
                  if(!isDynamicRegion) {
                     byte[] var6;
                     for(var33 = 0; var33 < var2; ++var33) {
                        var4 = (class30.mapRegions[var33] >> 8) * 64 - CombatInfoListHolder.baseX;
                        var5 = (class30.mapRegions[var33] & 255) * 64 - class3.baseY;
                        var6 = Ignore.field242[var33];
                        if(var6 != null) {
                           class47.method950();
                           class39.method815(var6, var4, var5, FileOnDisk.field1203 * 8 - 48, VertexNormal.field1435 * 8 - 48, collisionMaps);
                        }
                     }

                     for(var33 = 0; var33 < var2; ++var33) {
                        var4 = 64 * (class30.mapRegions[var33] >> 8) - CombatInfoListHolder.baseX;
                        var5 = 64 * (class30.mapRegions[var33] & 255) - class3.baseY;
                        var6 = Ignore.field242[var33];
                        if(var6 == null && VertexNormal.field1435 < 800) {
                           class47.method950();
                           class25.method599(var4, var5, 64, 64);
                        }
                     }

                     ChatMessages.method942(true);

                     for(var33 = 0; var33 < var2; ++var33) {
                        byte[] var34 = class145.field2019[var33];
                        if(var34 != null) {
                           var5 = 64 * (class30.mapRegions[var33] >> 8) - CombatInfoListHolder.baseX;
                           var35 = 64 * (class30.mapRegions[var33] & 255) - class3.baseY;
                           class47.method950();
                           class7.method102(var34, var5, var35, Friend.region, collisionMaps);
                        }
                     }
                  }

                  int var7;
                  int var8;
                  int var9;
                  if(isDynamicRegion) {
                     var33 = 0;

                     label475:
                     while(true) {
                        int var10;
                        int var11;
                        int var12;
                        if(var33 >= 4) {
                           for(var33 = 0; var33 < 13; ++var33) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = field312[0][var33][var4];
                                 if(var5 == -1) {
                                    class25.method599(var33 * 8, 8 * var4, 8, 8);
                                 }
                              }
                           }

                           ChatMessages.method942(true);
                           var33 = 0;

                           while(true) {
                              if(var33 >= 4) {
                                 break label475;
                              }

                              class47.method950();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var35 = field312[var33][var4][var5];
                                    if(var35 != -1) {
                                       var7 = var35 >> 24 & 3;
                                       var8 = var35 >> 1 & 3;
                                       var9 = var35 >> 14 & 1023;
                                       var10 = var35 >> 3 & 2047;
                                       var11 = var10 / 8 + (var9 / 8 << 8);

                                       for(var12 = 0; var12 < class30.mapRegions.length; ++var12) {
                                          if(class30.mapRegions[var12] == var11 && null != class145.field2019[var12]) {
                                             class154.method3040(class145.field2019[var12], var33, 8 * var4, 8 * var5, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, Friend.region, collisionMaps);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var33;
                           }
                        }

                        class47.method950();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var40 = false;
                              var7 = field312[var33][var4][var5];
                              if(var7 != -1) {
                                 var8 = var7 >> 24 & 3;
                                 var9 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(int var13 = 0; var13 < class30.mapRegions.length; ++var13) {
                                    if(var12 == class30.mapRegions[var13] && Ignore.field242[var13] != null) {
                                       byte[] var14 = Ignore.field242[var13];
                                       int var15 = var4 * 8;
                                       int var16 = var5 * 8;
                                       int var17 = (var10 & 7) * 8;
                                       int var18 = (var11 & 7) * 8;
                                       CollisionData[] var19 = collisionMaps;

                                       int var21;
                                       for(int var20 = 0; var20 < 8; ++var20) {
                                          for(var21 = 0; var21 < 8; ++var21) {
                                             if(var20 + var15 > 0 && var15 + var20 < 103 && var16 + var21 > 0 && var21 + var16 < 103) {
                                                var19[var33].flags[var20 + var15][var21 + var16] &= -16777217;
                                             }
                                          }
                                       }

                                       Buffer var36 = new Buffer(var14);

                                       for(var21 = 0; var21 < 4; ++var21) {
                                          for(int var22 = 0; var22 < 64; ++var22) {
                                             for(int var23 = 0; var23 < 64; ++var23) {
                                                if(var21 == var8 && var22 >= var17 && var22 < 8 + var17 && var23 >= var18 && var23 < var18 + 8) {
                                                   int var26 = var15 + class105.method2080(var22 & 7, var23 & 7, var9);
                                                   int var29 = var22 & 7;
                                                   int var30 = var23 & 7;
                                                   int var31 = var9 & 3;
                                                   int var28;
                                                   if(var31 == 0) {
                                                      var28 = var30;
                                                   } else if(var31 == 1) {
                                                      var28 = 7 - var29;
                                                   } else if(var31 == 2) {
                                                      var28 = 7 - var30;
                                                   } else {
                                                      var28 = var29;
                                                   }

                                                   class174.method3273(var36, var33, var26, var28 + var16, 0, 0, var9);
                                                } else {
                                                   class174.method3273(var36, 0, -1, -1, 0, 0, 0);
                                                }
                                             }
                                          }
                                       }

                                       var40 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var40) {
                                 class150.method2798(var33, var4 * 8, 8 * var5);
                              }
                           }
                        }

                        ++var33;
                     }
                  }

                  ChatMessages.method942(true);
                  class149.method2797();
                  class47.method950();
                  WallObject.method1951(Friend.region, collisionMaps);
                  ChatMessages.method942(true);
                  var33 = class10.field107;
                  if(var33 > class31.plane) {
                     var33 = class31.plane;
                  }

                  if(var33 < class31.plane - 1) {
                     var33 = class31.plane - 1;
                  }

                  if(field439) {
                     Friend.region.method1900(class10.field107);
                  } else {
                     Friend.region.method1900(0);
                  }

                  for(var4 = 0; var4 < 104; ++var4) {
                     for(var5 = 0; var5 < 104; ++var5) {
                        XGrandExchangeOffer.groundItemSpawned(var4, var5);
                     }
                  }

                  class47.method950();

                  for(class25 var39 = (class25)field444.method2448(); null != var39; var39 = (class25)field444.method2445()) {
                     if(var39.field596 == -1) {
                        var39.field606 = 0;
                        class31.method691(var39);
                     } else {
                        var39.unlink();
                     }
                  }

                  ObjectComposition.field2897.reset();
                  if(null != class16.field206) {
                     secretCipherBuffer1.putOpcode(137);
                     secretCipherBuffer1.putInt(1057001181);
                  }

                  if(!isDynamicRegion) {
                     var4 = (FileOnDisk.field1203 - 6) / 8;
                     var5 = (6 + FileOnDisk.field1203) / 8;
                     var35 = (VertexNormal.field1435 - 6) / 8;
                     var7 = (VertexNormal.field1435 + 6) / 8;

                     for(var8 = var4 - 1; var8 <= 1 + var5; ++var8) {
                        for(var9 = var35 - 1; var9 <= var7 + 1; ++var9) {
                           if(var8 < var4 || var8 > var5 || var9 < var35 || var9 > var7) {
                              class33.field778.method3303("m" + var8 + "_" + var9);
                              class33.field778.method3303("l" + var8 + "_" + var9);
                           }
                        }
                     }
                  }

                  class187.setGameState(30);
                  class47.method950();
                  class167.method3192();
                  secretCipherBuffer1.putOpcode(60);
                  class103.method2046();
               }
            }
         }
      } else {
         GameEngine.method2240(this);
      }

      if(gameState == 30) {
         class104.method2054();
      } else if(gameState == 40 || gameState == 45) {
         class47.processLoginState();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-48"
   )
   protected final void vmethod2167() {
      if(class7.chatMessages.method939()) {
         class7.chatMessages.method921();
      }

      if(field321 != null) {
         field321.field249 = false;
      }

      field321 = null;
      if(class1.field15 != null) {
         class1.field15.method2115();
         class1.field15 = null;
      }

      TextureProvider.method1517();
      if(null != class115.mouse) {
         class115 var1 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

      FaceNormal.field1575 = null;
      if(Buffer.field2089 != null) {
         Buffer.field2089.method1125();
      }

      if(class140.field1977 != null) {
         class140.field1977.method1125();
      }

      if(null != class185.field2748) {
         class185.field2748.method2115();
      }

      WidgetNode.method207();

      try {
         class104.field1696.method1444();

         for(int var3 = 0; var3 < class20.field251; ++var3) {
            class104.field1698[var3].method1444();
         }

         class104.field1691.method1444();
         class104.field1695.method1444();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2061077938"
   )
   void method287() {
      if(gameState != 1000) {
         long var2 = class99.method2005();
         int var4 = (int)(var2 - class185.field2742);
         class185.field2742 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class185.field2741 += var4;
         boolean var1;
         if(class185.field2751 == 0 && class185.field2759 == 0 && class185.field2749 == 0 && class185.field2744 == 0) {
            var1 = true;
         } else if(null == class185.field2748) {
            var1 = false;
         } else {
            try {
               label244: {
                  if(class185.field2741 > 30000) {
                     throw new IOException();
                  }

                  class181 var5;
                  Buffer var6;
                  while(class185.field2759 < 20 && class185.field2744 > 0) {
                     var5 = (class181)class185.field2743.method2391();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class185.field2748.queueForWrite(var6.payload, 0, 4);
                     class185.field2745.method2403(var5, var5.hash);
                     --class185.field2744;
                     ++class185.field2759;
                  }

                  while(class185.field2751 < 20 && class185.field2749 > 0) {
                     var5 = (class181)class185.field2747.method2334();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class185.field2748.queueForWrite(var6.payload, 0, 4);
                     var5.method2476();
                     class185.field2750.method2403(var5, var5.hash);
                     --class185.field2749;
                     ++class185.field2751;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class185.field2748.method2116();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class185.field2741 = 0;
                     byte var7 = 0;
                     if(null == FloorUnderlayDefinition.field2808) {
                        var7 = 8;
                     } else if(class185.field2753 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class185.field2752.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class185.field2748.method2119(class185.field2752.payload, class185.field2752.offset, var8);
                        if(class185.field2756 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class185.field2752.payload[class185.field2752.offset + var9] ^= class185.field2756;
                           }
                        }

                        class185.field2752.offset += var8;
                        if(class185.field2752.offset < var7) {
                           break;
                        }

                        if(null == FloorUnderlayDefinition.field2808) {
                           class185.field2752.offset = 0;
                           var9 = class185.field2752.readUnsignedByte();
                           var10 = class185.field2752.readUnsignedShort();
                           int var11 = class185.field2752.readUnsignedByte();
                           var12 = class185.field2752.readInt();
                           long var13 = (long)((var9 << 16) + var10);
                           class181 var15 = (class181)class185.field2745.method2405(var13);
                           class164.field2147 = true;
                           if(null == var15) {
                              var15 = (class181)class185.field2750.method2405(var13);
                              class164.field2147 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           FloorUnderlayDefinition.field2808 = var15;
                           class72.field1196 = new Buffer(var16 + var12 + FloorUnderlayDefinition.field2808.field2694);
                           class72.field1196.putByte(var11);
                           class72.field1196.putInt(var12);
                           class185.field2753 = 8;
                           class185.field2752.offset = 0;
                        } else if(class185.field2753 == 0) {
                           if(class185.field2752.payload[0] == -1) {
                              class185.field2753 = 1;
                              class185.field2752.offset = 0;
                           } else {
                              FloorUnderlayDefinition.field2808 = null;
                           }
                        }
                     } else {
                        var8 = class72.field1196.payload.length - FloorUnderlayDefinition.field2808.field2694;
                        var9 = 512 - class185.field2753;
                        if(var9 > var8 - class72.field1196.offset) {
                           var9 = var8 - class72.field1196.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class185.field2748.method2119(class72.field1196.payload, class72.field1196.offset, var9);
                        if(class185.field2756 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class72.field1196.payload[class72.field1196.offset + var10] ^= class185.field2756;
                           }
                        }

                        class72.field1196.offset += var9;
                        class185.field2753 += var9;
                        if(var8 == class72.field1196.offset) {
                           if(16711935L == FloorUnderlayDefinition.field2808.hash) {
                              class216.field3182 = class72.field1196;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class184 var19 = class185.field2755[var10];
                                 if(var19 != null) {
                                    class216.field3182.offset = 8 * var10 + 5;
                                    var12 = class216.field3182.readInt();
                                    int var20 = class216.field3182.readInt();
                                    var19.method3409(var12, var20);
                                 }
                              }
                           } else {
                              class185.field2740.reset();
                              class185.field2740.update(class72.field1196.payload, 0, var8);
                              var10 = (int)class185.field2740.getValue();
                              if(FloorUnderlayDefinition.field2808.field2692 != var10) {
                                 try {
                                    class185.field2748.method2115();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class185.field2746;
                                 class185.field2748 = null;
                                 class185.field2756 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label244;
                              }

                              class185.field2746 = 0;
                              class185.field2758 = 0;
                              FloorUnderlayDefinition.field2808.field2695.method3410((int)(FloorUnderlayDefinition.field2808.hash & 65535L), class72.field1196.payload, 16711680L == (FloorUnderlayDefinition.field2808.hash & 16711680L), class164.field2147);
                           }

                           FloorUnderlayDefinition.field2808.unlink();
                           if(class164.field2147) {
                              --class185.field2759;
                           } else {
                              --class185.field2751;
                           }

                           class185.field2753 = 0;
                           FloorUnderlayDefinition.field2808 = null;
                           class72.field1196 = null;
                        } else {
                           if(class185.field2753 != 512) {
                              break;
                           }

                           class185.field2753 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class185.field2748.method2115();
               } catch (Exception var22) {
                  ;
               }

               ++class185.field2758;
               class185.field2748 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method590();
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-7"
   )
   void method289(int var1) {
      FileOnDisk.field1200 = null;
      Item.field909 = null;
      field492 = 0;
      if(GameObject.field1636 == Ignore.field238) {
         GameObject.field1636 = field446;
      } else {
         GameObject.field1636 = Ignore.field238;
      }

      ++field343;
      if(field343 < 2 || var1 != 7 && var1 != 9) {
         if(field343 >= 2 && var1 == 6) {
            this.method2166("js5connect_outofdate");
            gameState = 1000;
         } else if(field343 >= 4) {
            if(gameState <= 5) {
               this.method2166("js5connect");
               gameState = 1000;
            } else {
               field340 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2166("js5connect_full");
         gameState = 1000;
      } else {
         field340 = 3000;
      }

   }

   static {
      field336 = class40.field836;
      field337 = class40.field836;
      field338 = 0;
      field492 = 0;
      field340 = 0;
      field343 = 0;
      loginState = 0;
      field471 = 0;
      field565 = 0;
      field347 = 0;
      field349 = null;
      cachedNPCs = new NPC['耀'];
      field351 = 0;
      field570 = new int['耀'];
      field353 = 0;
      field430 = new int[250];
      secretCipherBuffer1 = new CipherBuffer(5000);
      field356 = new CipherBuffer(5000);
      secretCipherBuffer2 = new CipherBuffer(15000);
      field358 = 0;
      packetOpcode = 0;
      field360 = 0;
      field497 = 0;
      field483 = 0;
      field363 = 0;
      field364 = 0;
      field365 = 0;
      field587 = false;
      field389 = 0;
      field368 = 1;
      field369 = 0;
      field453 = 1;
      field371 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field312 = new int[4][13][13];
      field361 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field376 = 0;
      field377 = 2;
      field415 = 0;
      field379 = 2;
      field380 = 0;
      field442 = 1;
      field382 = 0;
      mapScale = 0;
      field384 = 2;
      mapScaleDelta = 0;
      field386 = 1;
      field387 = 0;
      field328 = 0;
      field390 = 2301979;
      field417 = 5063219;
      field418 = 3353893;
      field393 = 7759444;
      field394 = false;
      field395 = 0;
      field396 = 128;
      mapAngle = 0;
      field447 = 0;
      field399 = 0;
      field400 = 0;
      field401 = 0;
      field402 = 50;
      field403 = 0;
      field404 = false;
      field503 = 0;
      field352 = 0;
      field326 = 50;
      field485 = new int[field326];
      field493 = new int[field326];
      field410 = new int[field326];
      field370 = new int[field326];
      field412 = new int[field326];
      field413 = new int[field326];
      field459 = new int[field326];
      field501 = new String[field326];
      field373 = new int[104][104];
      field534 = 0;
      field355 = -1;
      field339 = -1;
      field422 = 0;
      field421 = 0;
      field548 = 0;
      field423 = 0;
      field425 = 0;
      field406 = 0;
      field310 = 0;
      field427 = 0;
      field428 = 0;
      field408 = 0;
      field461 = false;
      field431 = 0;
      field432 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field529 = 0;
      field436 = 0;
      field437 = new int[1000];
      field438 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriority = new boolean[8];
      field441 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field407 = -1;
      groundItemDeque = new Deque[4][104][104];
      field444 = new Deque();
      projectiles = new Deque();
      field443 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field388 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field346 = false;
      field391 = -1;
      field561 = false;
      field462 = -1;
      field467 = -1;
      field348 = 0;
      field465 = 50;
      field466 = 0;
      field496 = null;
      field468 = false;
      field469 = -1;
      field405 = -1;
      field489 = null;
      field472 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field475 = 0;
      field476 = 0;
      field477 = null;
      energy = 0;
      weight = 0;
      field480 = 0;
      field481 = -1;
      field482 = false;
      field562 = false;
      field484 = false;
      field551 = null;
      field486 = null;
      field487 = null;
      field526 = 0;
      field470 = 0;
      field490 = null;
      field491 = false;
      field344 = -1;
      field590 = -1;
      field450 = false;
      field495 = -1;
      field530 = -1;
      field398 = false;
      field498 = 1;
      field499 = new int[32];
      field500 = 0;
      interfaceItemTriggers = new int[32];
      field502 = 0;
      field516 = new int[32];
      field504 = 0;
      field505 = 0;
      field506 = 0;
      field507 = 0;
      field545 = 0;
      field509 = 0;
      field510 = 0;
      field511 = 0;
      field512 = new Deque();
      field513 = new Deque();
      field514 = new Deque();
      widgetFlags = new XHashTable(512);
      field311 = 0;
      field517 = -2;
      field518 = new boolean[100];
      field488 = new boolean[100];
      field520 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field525 = 0;
      field342 = 0L;
      isResized = true;
      field528 = 765;
      field330 = 503;
      field464 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field307 = 0;
      field532 = 0;
      field533 = "";
      field555 = new long[100];
      field535 = 0;
      field474 = 0;
      field537 = new int[128];
      field538 = new int[128];
      field539 = -1L;
      field540 = null;
      clanChatOwner = null;
      field543 = -1;
      field585 = 0;
      field544 = new int[1000];
      field494 = new int[1000];
      field546 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field549 = 0;
      field550 = 255;
      field445 = -1;
      field552 = false;
      field553 = 127;
      field554 = 127;
      field419 = 0;
      field556 = new int[50];
      field557 = new int[50];
      field558 = new int[50];
      field559 = new int[50];
      field560 = new class53[50];
      field440 = false;
      field508 = new boolean[5];
      field563 = new int[5];
      field564 = new int[5];
      field354 = new int[5];
      field566 = new int[5];
      field567 = 256;
      field568 = 205;
      field569 = 256;
      field522 = 320;
      field324 = 1;
      field572 = 32767;
      field573 = 1;
      field574 = 32767;
      field575 = 0;
      field456 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field375 = 0;
      friends = new Friend[400];
      field583 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field576 = new PlayerComposition();
      field367 = -1;
      field588 = 1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field366 = -1L;
      field591 = -1L;
      field592 = new class22();
      field593 = new int[50];
      field594 = new int[50];
   }

   public final void init() {
      if(this.method2154()) {
         class214[] var1 = new class214[]{class214.field3166, class214.field3167, class214.field3162, class214.field3174, class214.field3176, class214.field3165, class214.field3171, class214.field3164, class214.field3173, class214.field3169, class214.field3175, class214.field3161, class214.field3160, class214.field3172, class214.field3163};
         class214[] var2 = var1;

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class214 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3170);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3170)) {
               case 1:
                  XClanMember.field301 = Buffer.method3034(Integer.parseInt(var5));
                  break;
               case 2:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 3:
                  class3.field33 = var5;
                  break;
               case 4:
                  field409 = Integer.parseInt(var5);
               case 5:
               case 6:
               case 7:
               default:
                  break;
               case 8:
                  class178.field2666 = var5;
                  break;
               case 9:
                  field316 = Integer.parseInt(var5);
                  break;
               case 10:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 11:
                  world = Integer.parseInt(var5);
                  break;
               case 12:
                  class25.field611 = Integer.parseInt(var5);
                  break;
               case 13:
                  flags = Integer.parseInt(var5);
                  break;
               case 14:
                  WidgetNode.field218 = (class179)class5.method77(class202.method3803(), Integer.parseInt(var5));
                  if(WidgetNode.field218 == class179.field2676) {
                     class165.field2155 = class228.field3253;
                  } else {
                     class165.field2155 = class228.field3255;
                  }
                  break;
               case 15:
                  field381 = Integer.parseInt(var5);
               }
            }
         }

         FaceNormal.method1952();
         WallObject.host = this.getCodeBase().getHost();
         String var17 = XClanMember.field301.field2667;
         byte var8 = 0;

         try {
            class20.field251 = 16;
            class18.field234 = var8;

            try {
               FrameMap.field1483 = System.getProperty("os.name");
            } catch (Exception var14) {
               FrameMap.field1483 = "Unknown";
            }

            class104.field1694 = FrameMap.field1483.toLowerCase();

            try {
               class30.field724 = System.getProperty("user.home");
               if(class30.field724 != null) {
                  class30.field724 = class30.field724 + "/";
               }
            } catch (Exception var13) {
               ;
            }

            try {
               if(class104.field1694.startsWith("win")) {
                  if(class30.field724 == null) {
                     class30.field724 = System.getenv("USERPROFILE");
                  }
               } else if(null == class30.field724) {
                  class30.field724 = System.getenv("HOME");
               }

               if(class30.field724 != null) {
                  class30.field724 = class30.field724 + "/";
               }
            } catch (Exception var12) {
               ;
            }

            if(class30.field724 == null) {
               class30.field724 = "~/";
            }

            FrameMap.field1476 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class30.field724, "/tmp/", ""};
            class206.field3100 = new String[]{".jagex_cache_" + class18.field234, ".file_store_" + class18.field234};

            int var6;
            File var7;
            label158:
            for(var3 = 0; var3 < 4; ++var3) {
               class217.field3183 = class183.method3404("oldschool", var17, var3);
               if(!class217.field3183.exists()) {
                  class217.field3183.mkdirs();
               }

               File[] var18 = class217.field3183.listFiles();
               if(null == var18) {
                  break;
               }

               File[] var20 = var18;
               var6 = 0;

               while(true) {
                  if(var6 >= var20.length) {
                     break label158;
                  }

                  var7 = var20[var6];
                  if(!XClanMember.method278(var7, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            File var9 = class217.field3183;
            class107.field1741 = var9;
            if(!class107.field1741.exists()) {
               throw new RuntimeException("");
            }

            class107.field1747 = true;

            try {
               File var19 = new File(class30.field724, "random.dat");
               if(var19.exists()) {
                  class104.field1695 = new class72(new FileOnDisk(var19, "rw", 25L), 24, 0);
               } else {
                  label136:
                  for(int var10 = 0; var10 < class206.field3100.length; ++var10) {
                     for(var6 = 0; var6 < FrameMap.field1476.length; ++var6) {
                        var7 = new File(FrameMap.field1476[var6] + class206.field3100[var10] + File.separatorChar + "random.dat");
                        if(var7.exists()) {
                           class104.field1695 = new class72(new FileOnDisk(var7, "rw", 25L), 24, 0);
                           break label136;
                        }
                     }
                  }
               }

               if(class104.field1695 == null) {
                  RandomAccessFile var21 = new RandomAccessFile(var19, "rw");
                  var6 = var21.read();
                  var21.seek(0L);
                  var21.write(var6);
                  var21.seek(0L);
                  var21.close();
                  class104.field1695 = new class72(new FileOnDisk(var19, "rw", 25L), 24, 0);
               }
            } catch (IOException var15) {
               ;
            }

            class104.field1696 = new class72(new FileOnDisk(GroundObject.method1594("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class104.field1691 = new class72(new FileOnDisk(GroundObject.method1594("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class104.field1698 = new class72[class20.field251];

            for(int var11 = 0; var11 < class20.field251; ++var11) {
               class104.field1698[var11] = new class72(new FileOnDisk(GroundObject.method1594("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var16) {
            class31.method703((String)null, var16);
         }

         field308 = this;
         this.method2152(765, 503, 138);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected final void vmethod2203() {
      boolean var1 = Item.method880();
      if(var1 && field552 && null != Buffer.field2089) {
         Buffer.field2089.method1124();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(field342 != 0L && class99.method2005() > field342) {
            int var2 = class13.method196();
            field342 = 0L;
            if(var2 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            class22.method235();
            if(gameState >= 25) {
               class45.method910();
            }

            GameEngine.field1787 = true;
         } else if(GameEngine.field1775) {
            class94.method1980();
         }
      }

      Dimension var16 = this.method2212();
      if(class16.field208 != var16.width || class178.field2668 != var16.height || GameEngine.field1789) {
         class22.method235();
         field342 = class99.method2005() + 500L;
         GameEngine.field1789 = false;
      }

      boolean var3 = false;
      int var4;
      if(GameEngine.field1787) {
         GameEngine.field1787 = false;
         var3 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field518[var4] = true;
         }
      }

      if(var3) {
         TextureProvider.method1515();
      }

      int var9;
      int var10;
      int var17;
      if(gameState == 0) {
         var4 = class41.field872;
         String var5 = class41.field866;
         Color var6 = null;

         try {
            Graphics var7 = CollisionData.canvas.getGraphics();
            if(null == class97.field1643) {
               class97.field1643 = new java.awt.Font("Helvetica", 1, 13);
               class85.field1471 = CollisionData.canvas.getFontMetrics(class97.field1643);
            }

            if(var3) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, class108.field1748, class145.field2018);
            }

            if(var6 == null) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(null == class150.field2042) {
                  class150.field2042 = CollisionData.canvas.createImage(304, 34);
               }

               Graphics var8 = class150.field2042.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, 3 * var4, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(2 + 3 * var4, 2, 300 - var4 * 3, 30);
               var8.setFont(class97.field1643);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - class85.field1471.stringWidth(var5)) / 2, 22);
               var7.drawImage(class150.field2042, class108.field1748 / 2 - 152, class145.field2018 / 2 - 18, (ImageObserver)null);
            } catch (Exception var22) {
               var9 = class108.field1748 / 2 - 152;
               var10 = class145.field2018 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(var9 + 2, 2 + var10, var4 * 3, 30);
               var7.setColor(Color.black);
               var7.drawRect(var9 + 1, var10 + 1, 301, 31);
               var7.fillRect(2 + var9 + 3 * var4, 2 + var10, 300 - var4 * 3, 30);
               var7.setFont(class97.field1643);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - class85.field1471.stringWidth(var5)) / 2, var10 + 22);
            }
         } catch (Exception var23) {
            CollisionData.canvas.repaint();
         }
      } else if(gameState == 5) {
         class114.method2245(BufferProvider.field3198, class31.field727, class15.field185, var3);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class114.method2245(BufferProvider.field3198, class31.field727, class15.field185, var3);
         } else if(gameState == 25) {
            if(field371 == 1) {
               if(field389 > field368) {
                  field368 = field389;
               }

               var4 = (field368 * 50 - field389 * 50) / field368;
               class22.method238("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field371 == 2) {
               if(field369 > field453) {
                  field453 = field369;
               }

               var4 = 50 + (field453 * 50 - field369 * 50) / field453;
               class22.method238("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class22.method238("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            if(widgetRoot != -1) {
               class38.method811(widgetRoot);
            }

            for(var4 = 0; var4 < field311; ++var4) {
               if(field518[var4]) {
                  field488[var4] = true;
               }

               field520[var4] = field518[var4];
               field518[var4] = false;
            }

            field517 = gameCycle;
            field462 = -1;
            field467 = -1;
            class3.field38 = null;
            if(widgetRoot != -1) {
               field311 = 0;
               class206.method3834(widgetRoot, 0, 0, class108.field1748, class145.field2018, 0, 0, -1);
            }

            Rasterizer2D.method3997();
            int var18;
            if(!isMenuOpen) {
               if(field462 != -1) {
                  var4 = field462;
                  var17 = field467;
                  if(menuOptionCount >= 2 || field466 != 0 || field468) {
                     var18 = class145.method2764();
                     String var26;
                     if(field466 == 1 && menuOptionCount < 2) {
                        var26 = "Use" + " " + field496 + " " + "->";
                     } else if(field468 && menuOptionCount < 2) {
                        var26 = field489 + " " + field472 + " " + "->";
                     } else {
                        var26 = Player.method269(var18);
                     }

                     if(menuOptionCount > 2) {
                        var26 = var26 + class116.method2288(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
                     }

                     BufferProvider.field3198.method3889(var26, var4 + 4, 15 + var17, 16777215, 0, gameCycle / 1000);
                  }
               }
            } else {
               var4 = class0.menuX;
               var17 = XItemContainer.menuY;
               var18 = class105.menuWidth;
               int var19 = NPCComposition.menuHeight;
               int var20 = 6116423;
               Rasterizer2D.method4028(var4, var17, var18, var19, var20);
               Rasterizer2D.method4028(1 + var4, 1 + var17, var18 - 2, 16, 0);
               Rasterizer2D.method4010(1 + var4, 18 + var17, var18 - 2, var19 - 19, 0);
               BufferProvider.field3198.method3881("Choose Option", 3 + var4, var17 + 14, var20, -1);
               var9 = class115.field1807;
               var10 = class115.field1801;

               int var11;
               int var12;
               int var13;
               for(var11 = 0; var11 < menuOptionCount; ++var11) {
                  var12 = 31 + var17 + 15 * (menuOptionCount - 1 - var11);
                  var13 = 16777215;
                  if(var9 > var4 && var9 < var18 + var4 && var10 > var12 - 13 && var10 < var12 + 3) {
                     var13 = 16776960;
                  }

                  BufferProvider.field3198.method3881(Player.method269(var11), var4 + 3, var12, var13, 0);
               }

               var11 = class0.menuX;
               var12 = XItemContainer.menuY;
               var13 = class105.menuWidth;
               int var14 = NPCComposition.menuHeight;

               for(int var15 = 0; var15 < field311; ++var15) {
                  if(widgetPositionX[var15] + widgetBoundsWidth[var15] > var11 && widgetPositionX[var15] < var13 + var11 && widgetBoundsHeight[var15] + widgetPositionY[var15] > var12 && widgetPositionY[var15] < var14 + var12) {
                     field488[var15] = true;
                  }
               }
            }

            if(field525 == 3) {
               for(var4 = 0; var4 < field311; ++var4) {
                  if(field520[var4]) {
                     Rasterizer2D.method4003(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4], 16711935, 128);
                  } else if(field488[var4]) {
                     Rasterizer2D.method4003(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4], 16711680, 128);
                  }
               }
            }

            class181.method3301(class31.plane, class22.localPlayer.x, class22.localPlayer.y, field328);
            field328 = 0;
         } else if(gameState == 40) {
            class22.method238("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class22.method238("Please wait...", false);
         }
      } else {
         class114.method2245(BufferProvider.field3198, class31.field727, class15.field185, var3);
      }

      Graphics var21;
      if(gameState == 30 && field525 == 0 && !var3) {
         try {
            var21 = CollisionData.canvas.getGraphics();

            for(var17 = 0; var17 < field311; ++var17) {
               if(field488[var17]) {
                  Frames.bufferProvider.drawSub(var21, widgetPositionX[var17], widgetPositionY[var17], widgetBoundsWidth[var17], widgetBoundsHeight[var17]);
                  field488[var17] = false;
               }
            }
         } catch (Exception var25) {
            CollisionData.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var21 = CollisionData.canvas.getGraphics();
            Frames.bufferProvider.draw(var21, 0, 0);

            for(var17 = 0; var17 < field311; ++var17) {
               field488[var17] = false;
            }
         } catch (Exception var24) {
            CollisionData.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1794246066"
   )
   void method590() {
      if(class185.field2746 >= 4) {
         this.method2166("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2758 >= 4) {
            if(gameState <= 5) {
               this.method2166("js5io");
               gameState = 1000;
               return;
            }

            field340 = 3000;
            class185.field2758 = 3;
         }

         if(--field340 + 1 <= 0) {
            try {
               if(field492 == 0) {
                  FileOnDisk.field1200 = class72.field1193.method2022(WallObject.host, GameObject.field1636);
                  ++field492;
               }

               if(field492 == 1) {
                  if(FileOnDisk.field1200.field1673 == 2) {
                     this.method289(-1);
                     return;
                  }

                  if(FileOnDisk.field1200.field1673 == 1) {
                     ++field492;
                  }
               }

               if(field492 == 2) {
                  Item.field909 = new RSSocket((Socket)FileOnDisk.field1200.field1677, class72.field1193);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(138);
                  Item.field909.queueForWrite(var1.payload, 0, 5);
                  ++field492;
                  class6.field63 = class99.method2005();
               }

               if(field492 == 3) {
                  if(gameState > 5 && Item.field909.method2116() <= 0) {
                     if(class99.method2005() - class6.field63 > 30000L) {
                        this.method289(-2);
                        return;
                     }
                  } else {
                     int var2 = Item.field909.method2118();
                     if(var2 != 0) {
                        this.method289(var2);
                        return;
                     }

                     ++field492;
                  }
               }

               if(field492 == 4) {
                  class145.method2760(Item.field909, gameState > 20);
                  FileOnDisk.field1200 = null;
                  Item.field909 = null;
                  field492 = 0;
                  field343 = 0;
               }
            } catch (IOException var3) {
               this.method289(-3);
            }

         }
      }
   }
}
