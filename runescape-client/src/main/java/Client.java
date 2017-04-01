import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.image.ImageObserver;
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
   @ObfuscatedName("ph")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 460346715
   )
   static int field298;
   @ObfuscatedName("lj")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1067657463
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1592127601
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("o")
   static class178 field302;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 313626715
   )
   static int field303;
   @ObfuscatedName("n")
   static class179 field304;
   @ObfuscatedName("j")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("s")
   static boolean field306 = false;
   @ObfuscatedName("kg")
   static Deque field307;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1573409051
   )
   static int field308 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 584399333
   )
   static int field309 = -1;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 1575957747
   )
   static int field310;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 457131395
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -2084550333
   )
   static int field312;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -426129339
   )
   static int field313;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 477121071
   )
   static int field314 = -1;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 1564735461
   )
   static int field315;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1229516399
   )
   static int field316 = -1;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -1005557729
   )
   static int field317;
   @ObfuscatedName("aq")
   static boolean field318 = false;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1255583121
   )
   static int field319 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -98962283
   )
   static int field320 = 0;
   @ObfuscatedName("fx")
   static boolean field321;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 992989093
   )
   static int field322 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 2128289407
   )
   static int field323 = 0;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 1839190155
   )
   static int field324;
   @ObfuscatedName("oi")
   static short field325;
   @ObfuscatedName("jg")
   static String field326;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1956869807
   )
   static int field327 = 0;
   @ObfuscatedName("at")
   static class40 field328;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -2063093855
   )
   static int field329;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -797480771
   )
   static int field330;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1155906289
   )
   static int field331;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1851180033
   )
   static int field332;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 579304521
   )
   static int field333;
   @ObfuscatedName("ne")
   static int[] field334;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1084948663
   )
   static int field335;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1873553771
   )
   static int field336;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 474203471
   )
   static int field337;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -2100580821
   )
   static int field338;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 1037315893527803361L
   )
   static long field339 = -1L;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 722471503
   )
   static int field340;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -185634769
   )
   static int field341 = 0;
   @ObfuscatedName("ce")
   static int[] field342;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1506245769
   )
   static int field343;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 162065911
   )
   static int field344;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -1673405993
   )
   static int field345;
   @ObfuscatedName("ch")
   static CipherBuffer field346;
   @ObfuscatedName("ca")
   @Export("secretCipherBuffer2")
   static CipherBuffer secretCipherBuffer2;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1711436239
   )
   static int field348;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -2029415455
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 512959331
   )
   static int field350;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -139260093
   )
   static int field351;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1675902303
   )
   static int field352;
   @ObfuscatedName("he")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1955155779
   )
   static int field354;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1403380927
   )
   static int field355;
   @ObfuscatedName("od")
   static int[] field356;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -1340849993
   )
   static int field357;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -753393819
   )
   static int field358;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 861586261
   )
   static int field359;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 1644613295
   )
   static int field360;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 319171149
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = 1810693455
   )
   static int field362;
   @ObfuscatedName("de")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("do")
   static int[][][] field364;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1502277047
   )
   static int field365;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 1290016729
   )
   static int field366;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -751616617
   )
   static int field367;
   @ObfuscatedName("jd")
   static boolean field368;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 584308065
   )
   static int field369;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -1520926023
   )
   static int field370;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -70650095
   )
   static int field371;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 92311583
   )
   static int field372;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 137059557
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -502197487
   )
   static int field374;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -314507465
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -2098712279
   )
   static int field376;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1474107201
   )
   static int field377;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 1127452179
   )
   static int field378;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -1501178459
   )
   static int field379;
   @ObfuscatedName("fp")
   static int[] field380;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 1513170123
   )
   static int field381;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 1831070449
   )
   static int field382;
   @ObfuscatedName("ol")
   static int[] field383;
   @ObfuscatedName("kd")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 1873552489
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 359771951
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -2104908745
   )
   static int field387;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -1231593605
   )
   static int field388;
   @ObfuscatedName("li")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("fj")
   static boolean field390;
   @ObfuscatedName("hy")
   static Deque field391;
   @ObfuscatedName("ad")
   static class40 field392;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1698019125
   )
   static int field393 = 0;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -1917950507
   )
   static int field394;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 543072743
   )
   static int field395;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 306241335
   )
   static int field396;
   @ObfuscatedName("fz")
   static int[] field397;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1441118659
   )
   static int field398;
   @ObfuscatedName("fg")
   static int[] field399;
   @ObfuscatedName("t")
   static class20 field400;
   @ObfuscatedName("fv")
   static int[] field401;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1977662407
   )
   static int field402;
   @ObfuscatedName("gi")
   static int[] field403;
   @ObfuscatedName("gp")
   static String[] field404;
   @ObfuscatedName("gg")
   static int[][] field405;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 110813355
   )
   static int field406;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 1211297111
   )
   static int field407;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -527861213
   )
   static int field408;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1506767803
   )
   static int field409;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -830841529
   )
   static int field410;
   @ObfuscatedName("cx")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -1656457747
   )
   static int field412;
   @ObfuscatedName("or")
   static int[] field413;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = -1628675337
   )
   static int field414;
   @ObfuscatedName("mo")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("gk")
   static boolean field416;
   @ObfuscatedName("ic")
   static boolean field417;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -174270939
   )
   static int field418;
   @ObfuscatedName("mx")
   static int[] field419;
   @ObfuscatedName("hz")
   static final int[] field420;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 1031671611
   )
   static int field421;
   @ObfuscatedName("gs")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("hv")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 103930221
   )
   static int field424;
   @ObfuscatedName("lk")
   static boolean[] field425;
   @ObfuscatedName("hq")
   static int[] field426;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -683360561
   )
   static int field427;
   @ObfuscatedName("hw")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("hk")
   @Export("playerOptionsPriority")
   static boolean[] playerOptionsPriority;
   @ObfuscatedName("hn")
   static int[] field430;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1595524881
   )
   static int field431;
   @ObfuscatedName("hm")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("i")
   static Client field433;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -112984337
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("mq")
   static int[] field435;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -303960187
   )
   static int field436;
   @ObfuscatedName("hu")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 1878969627
   )
   static int field439;
   @ObfuscatedName("ho")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 1158941057
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("in")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("ig")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("fn")
   static int[] field444;
   @ObfuscatedName("id")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("nx")
   static boolean field446;
   @ObfuscatedName("ii")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("iw")
   static boolean field448;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -859458011
   )
   static int field449;
   @ObfuscatedName("dg")
   static final int[] field450;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1618461429
   )
   static int field451;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1019121951
   )
   static int field452;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 1893323285
   )
   static int field453;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 823352245
   )
   static int field454;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -343128981
   )
   static int field455;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1409580345
   )
   static int field456;
   @ObfuscatedName("it")
   static String field457;
   @ObfuscatedName("ih")
   static boolean field458;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = -469945777
   )
   static int field459;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -1193643977
   )
   static int field460;
   @ObfuscatedName("hj")
   static Deque field461;
   @ObfuscatedName("ly")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = -1225413815
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("nb")
   static int[] field464;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 1748256821
   )
   static int field465;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -666235455
   )
   static int field466 = 0;
   @ObfuscatedName("jp")
   static Widget field467;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -1306245129
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -1007821423
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -1314295137
   )
   static int field470;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 587670521
   )
   static int field471;
   @ObfuscatedName("lm")
   static String field472;
   @ObfuscatedName("jm")
   static boolean field473;
   @ObfuscatedName("ju")
   static boolean field474;
   @ObfuscatedName("jt")
   static Widget field475;
   @ObfuscatedName("jw")
   static Widget field476;
   @ObfuscatedName("jk")
   static Widget field477;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 331634211
   )
   static int field478;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -1070845405
   )
   static int field479;
   @ObfuscatedName("ji")
   static Widget field480;
   @ObfuscatedName("js")
   static boolean field481;
   @ObfuscatedName("og")
   static int[] field482;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -1364839011
   )
   static int field483;
   @ObfuscatedName("jy")
   static boolean field484;
   @ObfuscatedName("ck")
   static int[] field485;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 1183840655
   )
   static int field486;
   @ObfuscatedName("kn")
   static boolean field487;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      longValue = -7873651655208521385L
   )
   static long field488;
   @ObfuscatedName("kl")
   static int[] field489;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -1653485565
   )
   static int field490;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -1885905679
   )
   static int field491;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -1341812713
   )
   static int field492;
   @ObfuscatedName("ky")
   static int[] field493;
   @ObfuscatedName("cp")
   @Export("secretCipherBuffer1")
   static CipherBuffer secretCipherBuffer1;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1046656433
   )
   static int field495;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -463006547
   )
   static int field496;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -980937427
   )
   static int field497;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -1676557465
   )
   static int field498;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1250931763
   )
   static int field499;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -220272963
   )
   static int field500;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1489598345
   )
   static int field501 = 0;
   @ObfuscatedName("ka")
   static Deque field502;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = 312377779
   )
   static int field503;
   @ObfuscatedName("lb")
   static Deque field504;
   @ObfuscatedName("oh")
   static short field505;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = 1685752467
   )
   static int field506;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -921324273
   )
   static int field507;
   @ObfuscatedName("ln")
   static boolean[] field508;
   @ObfuscatedName("pv")
   static PlayerComposition field509;
   @ObfuscatedName("ls")
   static boolean[] field510;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 607995889
   )
   static int field511;
   @ObfuscatedName("lf")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("lh")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("ll")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 2058742803
   )
   static int field515;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      longValue = -5996784617631561197L
   )
   static long field516;
   @ObfuscatedName("cj")
   static boolean field517;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      longValue = -1007744959716034823L
   )
   static long field518;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1212836935
   )
   static int field519;
   @ObfuscatedName("lo")
   static int[] field520;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -7470173
   )
   static int field521;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -484458185
   )
   static int field522;
   @ObfuscatedName("ie")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("mr")
   static long[] field524;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = -1227089007
   )
   static int field525;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("jz")
   static String field527;
   @ObfuscatedName("mp")
   static int[] field528;
   @ObfuscatedName("bp")
   static byte[] field529;
   @ObfuscatedName("md")
   static String field530;
   @ObfuscatedName("pk")
   static class130 field531;
   @ObfuscatedName("gb")
   static int[] field532;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 1671152819
   )
   static int field533;
   @ObfuscatedName("mw")
   static int[] field534;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -299944313
   )
   static int field535;
   @ObfuscatedName("mz")
   static SpritePixels[] field536;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1993813105
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -1575711177
   )
   static int field538;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -885984177
   )
   static int field539;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 1741290311
   )
   static int field540;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1328710459
   )
   static int field541;
   @ObfuscatedName("ns")
   static boolean field542;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 438684329
   )
   static int field543;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = -1726121981
   )
   static int field544;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 1915603633
   )
   static int field545;
   @ObfuscatedName("nv")
   static int[] field546;
   @ObfuscatedName("nc")
   static int[] field547;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1556216131
   )
   static int field548;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 237294397
   )
   static int field549;
   @ObfuscatedName("nw")
   static SoundEffect[] field550;
   @ObfuscatedName("u")
   static boolean field551 = true;
   @ObfuscatedName("oa")
   static boolean[] field552;
   @ObfuscatedName("jv")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("an")
   static boolean field554 = true;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 1582239603
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 351137497
   )
   static int field556;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 2093165301
   )
   static int field557;
   @ObfuscatedName("ot")
   static short field558;
   @ObfuscatedName("os")
   static short field559;
   @ObfuscatedName("oj")
   static short field560;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -823774359
   )
   static int field561;
   @ObfuscatedName("oq")
   static short field562;
   @ObfuscatedName("oy")
   static short field563;
   @ObfuscatedName("oz")
   static short field564;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -2022077055
   )
   static int field565;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -560759185
   )
   static int field566;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -1336073591
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = -1291364797
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -1837740379
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = -2141340201
   )
   static int field571;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -869494765
   )
   static int field572;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 1046690055
   )
   static int field573;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = 671087831
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("pt")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("ip")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = -1017556331
   )
   static int field577;
   @ObfuscatedName("g")
   static boolean field578 = true;
   @ObfuscatedName("pm")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1961472581
   )
   static int field580 = 0;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      longValue = 6408159599678003273L
   )
   static long field581;
   @ObfuscatedName("pg")
   static final class22 field582;
   @ObfuscatedName("pr")
   static int[] field583;
   @ObfuscatedName("pe")
   static int[] field584;
   @ObfuscatedName("hi")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("br")
   static IndexData field586;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected final void vmethod2159() {
      class99.field1671 = field580 == 0?'ꩊ':world + '鱀';
      class0.field4 = field580 == 0?443:'썐' + world;
      field431 = class99.field1671;
      PlayerComposition.field2190 = class167.field2205;
      PlayerComposition.field2191 = class167.field2201;
      VertexNormal.field1446 = class167.field2202;
      GroundObject.field1321 = class167.field2203;
      class10.method139();
      Canvas var1 = Projectile.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class105.keyboard);
      var1.addFocusListener(class105.keyboard);
      VertexNormal.method1668(Projectile.canvas);

      class106 var2;
      try {
         var2 = new class106();
      } catch (Throwable var6) {
         var2 = null;
      }

      WallObject.field1574 = var2;
      if(null != WallObject.field1574) {
         WallObject.field1574.vmethod2134(Projectile.canvas);
      }

      World.field695 = new IndexFile(255, class104.field1713, class104.field1714, 500000);
      class148.field2058 = class7.method86();
      IndexData.field2749 = this.getToolkit().getSystemClipboard();
      String var4 = FrameMap.field1495;
      class114.field1804 = this;
      class114.field1810 = var4;
      if(field580 != 0) {
         field318 = true;
      }

      int var5 = class148.field2058.field714;
      field516 = 0L;
      if(var5 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      class139.method2680();
      if(gameState >= 25) {
         class94.method1950();
      }

      GameEngine.field1787 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "262506472"
   )
   protected final void vmethod2161() {
      boolean var1 = class60.method1180();
      if(var1 && field542 && null != class2.field23) {
         class2.field23.method1084();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field516 && class45.method867() > field516) {
            int var2 = isResized?2:1;
            field516 = 0L;
            if(var2 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            class139.method2680();
            if(gameState >= 25) {
               class94.method1950();
            }

            GameEngine.field1787 = true;
         } else if(GameEngine.field1794) {
            class107.method2085();
         }
      }

      Dimension var11 = this.method2164();
      if(var11.width != CombatInfo1.field682 || class33.field758 != var11.height || GameEngine.field1797) {
         class139.method2680();
         field516 = class45.method867() + 500L;
         GameEngine.field1797 = false;
      }

      boolean var3 = false;
      int var4;
      if(GameEngine.field1787) {
         GameEngine.field1787 = false;
         var3 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field508[var4] = true;
         }
      }

      if(var3) {
         class72.method1441();
      }

      if(gameState == 0) {
         var4 = class41.field851;
         String var5 = class41.field852;
         Color var6 = null;

         try {
            Graphics var7 = Projectile.canvas.getGraphics();
            if(null == class112.field1780) {
               class112.field1780 = new java.awt.Font("Helvetica", 1, 13);
               class22.field253 = Projectile.canvas.getFontMetrics(class112.field1780);
            }

            if(var3) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, class32.field755, class168.field2207);
            }

            if(var6 == null) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(class13.field143 == null) {
                  class13.field143 = Projectile.canvas.createImage(304, 34);
               }

               Graphics var8 = class13.field143.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, var4 * 3, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(3 * var4 + 2, 2, 300 - 3 * var4, 30);
               var8.setFont(class112.field1780);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - class22.field253.stringWidth(var5)) / 2, 22);
               var7.drawImage(class13.field143, class32.field755 / 2 - 152, class168.field2207 / 2 - 18, (ImageObserver)null);
            } catch (Exception var14) {
               int var9 = class32.field755 / 2 - 152;
               int var10 = class168.field2207 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(2 + var9, var10 + 2, var4 * 3, 30);
               var7.setColor(Color.black);
               var7.drawRect(1 + var9, 1 + var10, 301, 31);
               var7.fillRect(3 * var4 + 2 + var9, var10 + 2, 300 - var4 * 3, 30);
               var7.setFont(class112.field1780);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - class22.field253.stringWidth(var5)) / 2, 22 + var10);
            }
         } catch (Exception var15) {
            Projectile.canvas.repaint();
         }
      } else if(gameState == 5) {
         class174.method3312(class63.field1119, class180.field2717, Player.field282, var3);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class174.method3312(class63.field1119, class180.field2717, Player.field282, var3);
         } else if(gameState == 25) {
            if(field535 == 1) {
               if(field357 > field358) {
                  field358 = field357;
               }

               var4 = (field358 * 50 - field357 * 50) / field358;
               GameEngine.method2242("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field535 == 2) {
               if(field359 > field360) {
                  field360 = field359;
               }

               var4 = (field360 * 50 - field359 * 50) / field360 + 50;
               GameEngine.method2242("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               GameEngine.method2242("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            method372();
         } else if(gameState == 40) {
            GameEngine.method2242("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            GameEngine.method2242("Please wait...", false);
         }
      } else {
         class174.method3312(class63.field1119, class180.field2717, Player.field282, var3);
      }

      Graphics var12;
      int var13;
      if(gameState == 30 && field515 == 0 && !var3) {
         try {
            var12 = Projectile.canvas.getGraphics();

            for(var13 = 0; var13 < field506; ++var13) {
               if(field425[var13]) {
                  class115.bufferProvider.drawSub(var12, widgetPositionX[var13], widgetPositionY[var13], widgetBoundsWidth[var13], widgetBoundsHeight[var13]);
                  field425[var13] = false;
               }
            }
         } catch (Exception var17) {
            Projectile.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var12 = Projectile.canvas.getGraphics();
            class115.bufferProvider.draw(var12, 0, 0);

            for(var13 = 0; var13 < field506; ++var13) {
               field425[var13] = false;
            }
         } catch (Exception var16) {
            Projectile.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-272138860"
   )
   protected final void vmethod2198() {
      if(class9.chatMessages.method890()) {
         class9.chatMessages.method876();
      }

      if(null != field400) {
         field400.field228 = false;
      }

      field400 = null;
      if(null != class20.field233) {
         class20.field233.method2113();
         class20.field233 = null;
      }

      if(class105.keyboard != null) {
         class105 var1 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

      class45.method864();
      WallObject.field1574 = null;
      if(class2.field23 != null) {
         class2.field23.method1113();
      }

      if(null != class137.field1927) {
         class137.field1927.method1113();
      }

      Actor.method587();
      Object var7 = class183.field2748;
      synchronized(class183.field2748) {
         if(class183.field2747 != 0) {
            class183.field2747 = 1;

            try {
               class183.field2748.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      Friend.method162();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-65"
   )
   void method245() {
      if(class185.field2781 >= 4) {
         this.method2162("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2782 >= 4) {
            if(gameState <= 5) {
               this.method2162("js5io");
               gameState = 1000;
               return;
            }

            field332 = 3000;
            class185.field2782 = 3;
         }

         if(--field332 + 1 <= 0) {
            try {
               if(field303 == 0) {
                  class175.field2662 = class108.field1755.method2003(XGrandExchangeOffer.host, field431);
                  ++field303;
               }

               if(field303 == 1) {
                  if(class175.field2662.field1686 == 2) {
                     this.method246(-1);
                     return;
                  }

                  if(class175.field2662.field1686 == 1) {
                     ++field303;
                  }
               }

               if(field303 == 2) {
                  class30.rssocket = new RSSocket((Socket)class175.field2662.field1690, class108.field1755);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(139);
                  class30.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++field303;
                  XGrandExchangeOffer.field40 = class45.method867();
               }

               if(field303 == 3) {
                  if(gameState > 5 && class30.rssocket.method2108() <= 0) {
                     if(class45.method867() - XGrandExchangeOffer.field40 > 30000L) {
                        this.method246(-2);
                        return;
                     }
                  } else {
                     int var2 = class30.rssocket.method2102();
                     if(var2 != 0) {
                        this.method246(var2);
                        return;
                     }

                     ++field303;
                  }
               }

               if(field303 == 4) {
                  class171.method3304(class30.rssocket, gameState > 20);
                  class175.field2662 = null;
                  class30.rssocket = null;
                  field303 = 0;
                  field333 = 0;
               }
            } catch (IOException var3) {
               this.method246(-3);
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1531563803"
   )
   void method246(int var1) {
      class175.field2662 = null;
      class30.rssocket = null;
      field303 = 0;
      if(class99.field1671 == field431) {
         field431 = class0.field4;
      } else {
         field431 = class99.field1671;
      }

      ++field333;
      if(field333 < 2 || var1 != 7 && var1 != 9) {
         if(field333 >= 2 && var1 == 6) {
            this.method2162("js5connect_outofdate");
            gameState = 1000;
         } else if(field333 >= 4) {
            if(gameState <= 5) {
               this.method2162("js5connect");
               gameState = 1000;
            } else {
               field332 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2162("js5connect_full");
         gameState = 1000;
      } else {
         field332 = 3000;
      }

   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2030438717"
   )
   static final void method263() {
      class41.method812(false);
      field357 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class85.field1484.length; ++var1) {
         if(class44.field915[var1] != -1 && class85.field1484[var1] == null) {
            class85.field1484[var1] = class205.indexMaps.getConfigData(class44.field915[var1], 0);
            if(null == class85.field1484[var1]) {
               var0 = false;
               ++field357;
            }
         }

         if(XClanMember.field296[var1] != -1 && null == Frames.field1593[var1]) {
            Frames.field1593[var1] = class205.indexMaps.getConfigData(XClanMember.field296[var1], 0, class41.xteaKeys[var1]);
            if(null == Frames.field1593[var1]) {
               var0 = false;
               ++field357;
            }
         }
      }

      if(!var0) {
         field535 = 1;
      } else {
         field359 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class85.field1484.length; ++var1) {
            byte[] var2 = Frames.field1593[var1];
            if(null != var2) {
               var3 = 64 * (class25.mapRegions[var1] >> 8) - class119.baseX;
               var4 = (class25.mapRegions[var1] & 255) * 64 - class187.baseY;
               if(isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= Item.method831(var2, var3, var4);
            }
         }

         if(!var0) {
            field535 = 2;
         } else {
            if(field535 != 0) {
               GameEngine.method2242("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            World.method596();
            class20.method189();
            World.method596();
            CombatInfo1.region.method1736();
            World.method596();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               collisionMaps[var1].method2346();
            }

            int var42;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var42 = 0; var42 < 104; ++var42) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class10.tileSettings[var1][var42][var3] = 0;
                  }
               }
            }

            World.method596();
            class10.field86 = 99;
            class10.underlayIds = new byte[4][104][104];
            class0.overlayIds = new byte[4][104][104];
            class3.overlayPaths = new byte[4][104][104];
            class109.overlayRotations = new byte[4][104][104];
            class162.field2166 = new int[4][105][105];
            Ignore.field219 = new byte[4][105][105];
            CombatInfo1.field688 = new int[105][105];
            class10.field94 = new int[104];
            class30.field712 = new int[104];
            class1.field9 = new int[104];
            class0.field2 = new int[104];
            ClassInfo.field3243 = new int[104];
            var1 = class85.field1484.length;

            for(class31 var46 = (class31)class31.field732.method2464(); null != var46; var46 = (class31)class31.field732.method2472()) {
               if(var46.field736 != null) {
                  Ignore.field224.method943(var46.field736);
                  var46.field736 = null;
               }

               if(var46.field735 != null) {
                  Ignore.field224.method943(var46.field735);
                  var46.field735 = null;
               }
            }

            class31.field732.method2458();
            class41.method812(true);
            int var44;
            if(!isDynamicRegion) {
               byte[] var5;
               for(var42 = 0; var42 < var1; ++var42) {
                  var3 = (class25.mapRegions[var42] >> 8) * 64 - class119.baseX;
                  var4 = (class25.mapRegions[var42] & 255) * 64 - class187.baseY;
                  var5 = class85.field1484[var42];
                  if(var5 != null) {
                     World.method596();
                     MessageNode.method196(var5, var3, var4, Friend.field161 * 8 - 48, class148.field2056 * 8 - 48, collisionMaps);
                  }
               }

               for(var42 = 0; var42 < var1; ++var42) {
                  var3 = 64 * (class25.mapRegions[var42] >> 8) - class119.baseX;
                  var4 = (class25.mapRegions[var42] & 255) * 64 - class187.baseY;
                  var5 = class85.field1484[var42];
                  if(null == var5 && class148.field2056 < 800) {
                     World.method596();
                     Player.method233(var3, var4, 64, 64);
                  }
               }

               class41.method812(true);

               for(var42 = 0; var42 < var1; ++var42) {
                  byte[] var43 = Frames.field1593[var42];
                  if(null != var43) {
                     var4 = (class25.mapRegions[var42] >> 8) * 64 - class119.baseX;
                     var44 = 64 * (class25.mapRegions[var42] & 255) - class187.baseY;
                     World.method596();
                     class6.method75(var43, var4, var44, CombatInfo1.region, collisionMaps);
                  }
               }
            }

            int var6;
            int var7;
            int var8;
            if(isDynamicRegion) {
               int var9;
               int var10;
               int var11;
               for(var42 = 0; var42 < 4; ++var42) {
                  World.method596();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var48 = false;
                        var6 = field364[var42][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(int var12 = 0; var12 < class25.mapRegions.length; ++var12) {
                              if(var11 == class25.mapRegions[var12] && class85.field1484[var12] != null) {
                                 Ignore.method177(class85.field1484[var12], var42, var3 * 8, var4 * 8, var7, 8 * (var9 & 7), (var10 & 7) * 8, var8, collisionMaps);
                                 var48 = true;
                                 break;
                              }
                           }
                        }

                        if(!var48) {
                           var7 = var42;
                           var8 = var3 * 8;
                           var9 = 8 * var4;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class10.tileHeights[var7][var8 + var10][var11 + var9] = 0;
                              }
                           }

                           if(var8 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var7][var8][var9 + var10] = class10.tileHeights[var7][var8 - 1][var10 + var9];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class10.tileHeights[var7][var8 + var10][var9] = class10.tileHeights[var7][var8 + var10][var9 - 1];
                              }
                           }

                           if(var8 > 0 && class10.tileHeights[var7][var8 - 1][var9] != 0) {
                              class10.tileHeights[var7][var8][var9] = class10.tileHeights[var7][var8 - 1][var9];
                           } else if(var9 > 0 && class10.tileHeights[var7][var8][var9 - 1] != 0) {
                              class10.tileHeights[var7][var8][var9] = class10.tileHeights[var7][var8][var9 - 1];
                           } else if(var8 > 0 && var9 > 0 && class10.tileHeights[var7][var8 - 1][var9 - 1] != 0) {
                              class10.tileHeights[var7][var8][var9] = class10.tileHeights[var7][var8 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var42 = 0; var42 < 13; ++var42) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = field364[0][var42][var3];
                     if(var4 == -1) {
                        Player.method233(var42 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class41.method812(true);

               for(var42 = 0; var42 < 4; ++var42) {
                  World.method596();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label503:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var44 = field364[var42][var3][var4];
                        if(var44 != -1) {
                           var6 = var44 >> 24 & 3;
                           var7 = var44 >> 1 & 3;
                           var8 = var44 >> 14 & 1023;
                           var9 = var44 >> 3 & 2047;
                           var10 = (var8 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class25.mapRegions.length; ++var11) {
                              if(var10 == class25.mapRegions[var11] && Frames.field1593[var11] != null) {
                                 byte[] var45 = Frames.field1593[var11];
                                 int var13 = 8 * var3;
                                 int var14 = var4 * 8;
                                 int var15 = 8 * (var8 & 7);
                                 int var16 = (var9 & 7) * 8;
                                 Region var17 = CombatInfo1.region;
                                 CollisionData[] var18 = collisionMaps;
                                 Buffer var19 = new Buffer(var45);
                                 int var20 = -1;

                                 while(true) {
                                    int var21 = var19.method2880();
                                    if(var21 == 0) {
                                       continue label503;
                                    }

                                    var20 += var21;
                                    int var22 = 0;

                                    while(true) {
                                       int var23 = var19.method2880();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       int var24 = var22 & 63;
                                       int var25 = var22 >> 6 & 63;
                                       int var26 = var22 >> 12;
                                       int var27 = var19.readUnsignedByte();
                                       int var28 = var27 >> 2;
                                       int var29 = var27 & 3;
                                       if(var26 == var6 && var25 >= var15 && var25 < 8 + var15 && var24 >= var16 && var24 < 8 + var16) {
                                          ObjectComposition var30 = class140.getObjectDefinition(var20);
                                          int var33 = var25 & 7;
                                          int var34 = var24 & 7;
                                          int var36 = var30.sizeX;
                                          int var37 = var30.sizeY;
                                          int var38;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var37;
                                             var37 = var38;
                                          }

                                          int var35 = var7 & 3;
                                          int var32;
                                          if(var35 == 0) {
                                             var32 = var33;
                                          } else if(var35 == 1) {
                                             var32 = var34;
                                          } else if(var35 == 2) {
                                             var32 = 7 - var33 - (var36 - 1);
                                          } else {
                                             var32 = 7 - var34 - (var37 - 1);
                                          }

                                          var38 = var32 + var13;
                                          int var39 = var14 + CombatInfo2.method3589(var25 & 7, var24 & 7, var7, var30.sizeX, var30.sizeY, var29);
                                          if(var38 > 0 && var39 > 0 && var38 < 103 && var39 < 103) {
                                             int var40 = var42;
                                             if((class10.tileSettings[1][var38][var39] & 2) == 2) {
                                                var40 = var42 - 1;
                                             }

                                             CollisionData var41 = null;
                                             if(var40 >= 0) {
                                                var41 = var18[var40];
                                             }

                                             class173.method3308(var42, var38, var39, var20, var7 + var29 & 3, var28, var17, var41);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class41.method812(true);
            class20.method189();
            World.method596();
            class107.method2082(CombatInfo1.region, collisionMaps);
            class41.method812(true);
            var42 = class10.field86;
            if(var42 > Sequence.plane) {
               var42 = Sequence.plane;
            }

            if(var42 < Sequence.plane - 1) {
               var42 = Sequence.plane - 1;
            }

            if(field306) {
               CombatInfo1.region.method1840(class10.field86);
            } else {
               CombatInfo1.region.method1840(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  groundItemSpawned(var3, var4);
               }
            }

            World.method596();

            for(class25 var47 = (class25)field461.method2464(); null != var47; var47 = (class25)field461.method2472()) {
               if(var47.field598 == -1) {
                  var47.field589 = 0;
                  method552(var47);
               } else {
                  var47.unlink();
               }
            }

            ObjectComposition.field2912.reset();
            if(CollisionData.field1860 != null) {
               secretCipherBuffer1.putOpcode(6);
               secretCipherBuffer1.putInt(1057001181);
            }

            if(!isDynamicRegion) {
               var3 = (Friend.field161 - 6) / 8;
               var4 = (6 + Friend.field161) / 8;
               var44 = (class148.field2056 - 6) / 8;
               var6 = (6 + class148.field2056) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var8 = var44 - 1; var8 <= var6 + 1; ++var8) {
                     if(var7 < var3 || var7 > var4 || var8 < var44 || var8 > var6) {
                        class205.indexMaps.method3356("m" + var7 + "_" + var8);
                        class205.indexMaps.method3356("l" + var7 + "_" + var8);
                     }
                  }
               }
            }

            GameObject.setGameState(30);
            World.method596();
            class10.underlayIds = null;
            class0.overlayIds = null;
            class3.overlayPaths = null;
            class109.overlayRotations = null;
            class162.field2166 = null;
            Ignore.field219 = null;
            CombatInfo1.field688 = null;
            class10.field94 = null;
            class30.field712 = null;
            class1.field9 = null;
            class0.field2 = null;
            ClassInfo.field3243 = null;
            secretCipherBuffer1.putOpcode(66);
            GroundObject.method1566();
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1046868510"
   )
   protected final void vmethod2188() {
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-638604732"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = groundItemDeque[Sequence.plane][var0][var1];
      if(var2 == null) {
         CombatInfo1.region.method1757(Sequence.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2464(); null != var6; var6 = (Item)var2.method2472()) {
            ItemComposition var7 = class196.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            CombatInfo1.region.method1757(Sequence.plane, var0, var1);
         } else {
            var2.method2460(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2464(); var6 != null; var6 = (Item)var2.method2472()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            CombatInfo1.region.method1743(Sequence.plane, var0, var1, class103.method2025(64 + 128 * var0, 128 * var1 + 64, Sequence.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1294394838"
   )
   static final void method372() {
      if(widgetRoot != -1) {
         class148.method2833(widgetRoot);
      }

      int var0;
      for(var0 = 0; var0 < field506; ++var0) {
         if(field508[var0]) {
            field425[var0] = true;
         }

         field510[var0] = field508[var0];
         field508[var0] = false;
      }

      field507 = gameCycle;
      field451 = -1;
      field331 = -1;
      class161.field2160 = null;
      if(widgetRoot != -1) {
         field506 = 0;
         ChatMessages.method905(widgetRoot, 0, 0, class32.field755, class168.field2207, 0, 0, -1);
      }

      Rasterizer2D.method4000();
      if(!isMenuOpen) {
         if(field451 != -1) {
            class20.method185(field451, field331);
         }
      } else {
         class142.method2749();
      }

      if(field515 == 3) {
         for(var0 = 0; var0 < field506; ++var0) {
            if(field510[var0]) {
               Rasterizer2D.method4006(widgetPositionX[var0], widgetPositionY[var0], widgetBoundsWidth[var0], widgetBoundsHeight[var0], 16711935, 128);
            } else if(field425[var0]) {
               Rasterizer2D.method4006(widgetPositionX[var0], widgetPositionY[var0], widgetBoundsWidth[var0], widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      var0 = Sequence.plane;
      int var1 = Projectile.localPlayer.x;
      int var2 = Projectile.localPlayer.y;
      int var3 = field511;

      for(class31 var4 = (class31)class31.field732.method2464(); null != var4; var4 = (class31)class31.field732.method2472()) {
         if(var4.field734 != -1 || var4.field733 != null) {
            int var5 = 0;
            if(var1 > var4.field726) {
               var5 += var1 - var4.field726;
            } else if(var1 < var4.field724) {
               var5 += var4.field724 - var1;
            }

            if(var2 > var4.field722) {
               var5 += var2 - var4.field722;
            } else if(var2 < var4.field725) {
               var5 += var4.field725 - var2;
            }

            if(var5 - 64 <= var4.field728 && field544 != 0 && var4.field723 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = field544 * (var4.field728 - var5) / var4.field728;
               Object var10000;
               if(null == var4.field736) {
                  if(var4.field734 >= 0) {
                     var10000 = null;
                     SoundEffect var11 = SoundEffect.method1013(IndexFile.indexSoundEffects, var4.field734, 0);
                     if(null != var11) {
                        class55 var8 = var11.method1008().method1054(class118.field1868);
                        class66 var9 = class66.method1211(var8, 100, var6);
                        var9.method1217(-1);
                        Ignore.field224.method942(var9);
                        var4.field736 = var9;
                     }
                  }
               } else {
                  var4.field736.method1206(var6);
               }

               if(var4.field735 == null) {
                  if(null != var4.field733 && (var4.field730 -= var3) <= 0) {
                     int var7 = (int)(Math.random() * (double)var4.field733.length);
                     var10000 = null;
                     SoundEffect var12 = SoundEffect.method1013(IndexFile.indexSoundEffects, var4.field733[var7], 0);
                     if(null != var12) {
                        class55 var13 = var12.method1008().method1054(class118.field1868);
                        class66 var10 = class66.method1211(var13, 100, var6);
                        var10.method1217(0);
                        Ignore.field224.method942(var10);
                        var4.field735 = var10;
                        var4.field730 = var4.field731 + (int)(Math.random() * (double)(var4.field727 - var4.field731));
                     }
                  }
               } else {
                  var4.field735.method1206(var6);
                  if(!var4.field735.linked()) {
                     var4.field735 = null;
                  }
               }
            } else {
               if(null != var4.field736) {
                  Ignore.field224.method943(var4.field736);
                  var4.field736 = null;
               }

               if(null != var4.field735) {
                  Ignore.field224.method943(var4.field735);
                  var4.field735 = null;
               }
            }
         }
      }

      field511 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   void method401() {
      if(gameState != 1000) {
         boolean var1 = class165.method3195();
         if(!var1) {
            this.method245();
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1238019017"
   )
   public static Object method425(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class156.field2132) {
            try {
               class151 var2 = new class151();
               var2.vmethod3077(var0);
               return var2;
            } catch (Throwable var3) {
               class156.field2132 = true;
            }
         }

         return var0;
      }
   }

   public final void init() {
      if(this.method2149()) {
         class214[] var1 = new class214[]{class214.field3165, class214.field3167, class214.field3170, class214.field3164, class214.field3176, class214.field3171, class214.field3173, class214.field3168, class214.field3163, class214.field3174, class214.field3175, class214.field3172, class214.field3162, class214.field3169, class214.field3166};
         class214[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class214 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3161);
            if(null != var5) {
               switch(Integer.parseInt(var4.field3161)) {
               case 1:
                  field377 = Integer.parseInt(var5);
                  break;
               case 2:
                  field580 = Integer.parseInt(var5);
               case 3:
               case 5:
               case 14:
               default:
                  break;
               case 4:
                  ScriptState.field113 = Integer.parseInt(var5);
                  break;
               case 6:
                  class156.field2133 = var5;
                  break;
               case 7:
                  NPC.field780 = var5;
                  break;
               case 8:
                  world = Integer.parseInt(var5);
                  break;
               case 9:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 10:
                  class179[] var6 = new class179[]{class179.field2704, class179.field2708, class179.field2705, class179.field2713, class179.field2711, class179.field2706};
                  field304 = (class179)method556(var6, Integer.parseInt(var5));
                  if(field304 == class179.field2708) {
                     Ignore.field214 = class228.field3257;
                  } else {
                     Ignore.field214 = class228.field3250;
                  }
                  break;
               case 11:
                  field302 = class49.method928(Integer.parseInt(var5));
                  break;
               case 12:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 13:
                  flags = Integer.parseInt(var5);
                  break;
               case 15:
                  field308 = Integer.parseInt(var5);
               }
            }
         }

         class8.method91();
         XGrandExchangeOffer.host = this.getCodeBase().getHost();
         String var10 = field302.field2700;
         byte var7 = 0;

         try {
            class119.method2360("oldschool", var10, var7, 16);
         } catch (Exception var9) {
            GameObject.method1958((String)null, var9);
         }

         field433 = this;
         this.method2147(765, 503, 139);
      }
   }

   static {
      field328 = class40.field827;
      field392 = class40.field827;
      field330 = 0;
      field303 = 0;
      field332 = 0;
      field333 = 0;
      field406 = 0;
      field335 = 0;
      field336 = 0;
      field409 = 0;
      field529 = null;
      cachedNPCs = new NPC['耀'];
      field402 = 0;
      field342 = new int['耀'];
      field343 = 0;
      field485 = new int[250];
      secretCipherBuffer1 = new CipherBuffer(5000);
      field346 = new CipherBuffer(5000);
      secretCipherBuffer2 = new CipherBuffer(15000);
      field348 = 0;
      packetOpcode = 0;
      field350 = 0;
      field436 = 0;
      field352 = 0;
      field424 = 0;
      field354 = 0;
      field355 = 0;
      field517 = false;
      field357 = 0;
      field358 = 1;
      field359 = 0;
      field360 = 1;
      field535 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field364 = new int[4][13][13];
      field450 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field366 = 0;
      field367 = 2;
      field573 = 0;
      field519 = 2;
      field370 = 0;
      field371 = 1;
      field372 = 0;
      mapScale = 0;
      field374 = 2;
      mapScaleDelta = 0;
      field376 = 1;
      field548 = 0;
      field511 = 0;
      field379 = 2301979;
      field329 = 5063219;
      field381 = 3353893;
      field382 = 7759444;
      field321 = false;
      field365 = 0;
      field398 = 128;
      mapAngle = 0;
      field387 = 0;
      field388 = 0;
      field315 = 0;
      field317 = 0;
      field572 = 50;
      field486 = 0;
      field390 = false;
      field394 = 0;
      field395 = 0;
      field396 = 50;
      field397 = new int[field396];
      field380 = new int[field396];
      field399 = new int[field396];
      field444 = new int[field396];
      field401 = new int[field396];
      field532 = new int[field396];
      field403 = new int[field396];
      field404 = new String[field396];
      field405 = new int[104][104];
      field337 = 0;
      field407 = -1;
      field408 = -1;
      field557 = 0;
      field410 = 0;
      field312 = 0;
      field412 = 0;
      field351 = 0;
      field452 = 0;
      field556 = 0;
      field338 = 0;
      field427 = 0;
      field418 = 0;
      field416 = false;
      field378 = 0;
      field421 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field313 = 0;
      field310 = 0;
      field426 = new int[1000];
      field420 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriority = new boolean[8];
      field430 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field340 = -1;
      groundItemDeque = new Deque[4][104][104];
      field461 = new Deque();
      projectiles = new Deque();
      field391 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field439 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field448 = false;
      field449 = -1;
      field417 = false;
      field451 = -1;
      field331 = -1;
      field453 = 0;
      field369 = 50;
      field455 = 0;
      field457 = null;
      field458 = false;
      field414 = -1;
      field460 = -1;
      field326 = null;
      field527 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field465 = 0;
      field344 = 0;
      field467 = null;
      energy = 0;
      weight = 0;
      field470 = 0;
      field471 = -1;
      field368 = false;
      field473 = false;
      field474 = false;
      field475 = null;
      field476 = null;
      field477 = null;
      field478 = 0;
      field479 = 0;
      field480 = null;
      field481 = false;
      field324 = -1;
      field483 = -1;
      field484 = false;
      field454 = -1;
      field491 = -1;
      field487 = false;
      field561 = 1;
      field489 = new int[32];
      field490 = 0;
      interfaceItemTriggers = new int[32];
      field492 = 0;
      field493 = new int[32];
      field503 = 0;
      field495 = 0;
      field496 = 0;
      field497 = 0;
      field498 = 0;
      field499 = 0;
      field500 = 0;
      field538 = 0;
      field502 = new Deque();
      field307 = new Deque();
      field504 = new Deque();
      widgetFlags = new XHashTable(512);
      field506 = 0;
      field507 = -2;
      field508 = new boolean[100];
      field425 = new boolean[100];
      field510 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field515 = 0;
      field516 = 0L;
      isResized = true;
      field362 = 765;
      field549 = 1;
      field520 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field521 = 0;
      field522 = 0;
      field472 = "";
      field524 = new long[100];
      field525 = 0;
      field345 = 0;
      field419 = new int[128];
      field528 = new int[128];
      field488 = -1L;
      field530 = null;
      clanChatOwner = null;
      field459 = -1;
      field533 = 0;
      field534 = new int[1000];
      field435 = new int[1000];
      field536 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field539 = 0;
      field540 = 255;
      field541 = -1;
      field542 = false;
      field543 = 127;
      field544 = 127;
      field545 = 0;
      field546 = new int[50];
      field547 = new int[50];
      field334 = new int[50];
      field464 = new int[50];
      field550 = new SoundEffect[50];
      field446 = false;
      field552 = new boolean[5];
      field482 = new int[5];
      field356 = new int[5];
      field383 = new int[5];
      field413 = new int[5];
      field325 = 256;
      field558 = 205;
      field559 = 256;
      field560 = 320;
      field505 = 1;
      field562 = 32767;
      field563 = 1;
      field564 = 32767;
      field565 = 0;
      field566 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field571 = 0;
      friends = new Friend[400];
      field531 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field509 = new PlayerComposition();
      field577 = -1;
      field298 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field518 = -1L;
      field581 = -1L;
      field582 = new class22();
      field583 = new int[50];
      field584 = new int[50];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2113440280"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method401();

      while(true) {
         Deque var2 = class183.field2746;
         class180 var1;
         synchronized(class183.field2746) {
            var1 = (class180)class183.field2745.method2487();
         }

         if(var1 == null) {
            int var16;
            try {
               if(class138.field1940 == 1) {
                  var16 = class138.field1939.method2554();
                  if(var16 > 0 && class138.field1939.method2555()) {
                     var16 -= class138.field1937;
                     if(var16 < 0) {
                        var16 = 0;
                     }

                     class138.field1939.method2564(var16);
                  } else {
                     class138.field1939.method2591();
                     class138.field1939.method2557();
                     if(class149.field2061 != null) {
                        class138.field1940 = 2;
                     } else {
                        class138.field1940 = 0;
                     }

                     class138.field1944 = null;
                     XClanMember.field285 = null;
                  }
               }
            } catch (Exception var35) {
               var35.printStackTrace();
               class138.field1939.method2591();
               class138.field1940 = 0;
               class138.field1944 = null;
               XClanMember.field285 = null;
               class149.field2061 = null;
            }

            World.method596();
            class105 var36 = class105.keyboard;
            int var17;
            synchronized(class105.keyboard) {
               ++class105.keyboardIdleTicks;
               class105.field1742 = class105.field1726;
               class105.field1745 = 0;
               if(class105.field1743 >= 0) {
                  while(class105.field1736 != class105.field1743) {
                     var17 = class105.field1735[class105.field1736];
                     class105.field1736 = class105.field1736 + 1 & 127;
                     if(var17 < 0) {
                        class105.field1734[~var17] = false;
                     } else {
                        if(!class105.field1734[var17] && class105.field1745 < class105.field1740.length - 1) {
                           class105.field1740[++class105.field1745 - 1] = var17;
                        }

                        class105.field1734[var17] = true;
                     }
                  }
               } else {
                  for(var17 = 0; var17 < 112; ++var17) {
                     class105.field1734[var17] = false;
                  }

                  class105.field1743 = class105.field1736;
               }

               if(class105.field1745 > 0) {
                  class105.keyboardIdleTicks = 0;
               }

               class105.field1726 = class105.field1737;
            }

            Varbit.method3598();
            if(null != WallObject.field1574) {
               var16 = WallObject.field1574.vmethod2136();
               field538 = var16;
            }

            if(gameState == 0) {
               class5.method65();
               GroundObject.method1566();
            } else if(gameState == 5) {
               Buffer.method3064(this);
               class5.method65();
               GroundObject.method1566();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  Buffer.method3064(this);
                  XItemContainer.method151();
               } else if(gameState == 25) {
                  method263();
               }
            } else {
               Buffer.method3064(this);
            }

            if(gameState == 30) {
               if(field319 > 1) {
                  --field319;
               }

               if(field355 > 0) {
                  --field355;
               }

               if(field517) {
                  field517 = false;
                  class107.method2083();
               } else {
                  if(!isMenuOpen) {
                     class37.method762();
                     menuOptions[0] = "Cancel";
                     menuTargets[0] = "";
                     menuTypes[0] = 1006;
                     menuOptionCount = 1;
                  }

                  for(var16 = 0; var16 < 100 && ScriptState.method145(); ++var16) {
                     ;
                  }

                  if(gameState == 30) {
                     while(true) {
                        ClassInfo var39 = (ClassInfo)class227.field3244.method2442();
                        boolean var49;
                        if(null == var39) {
                           var49 = false;
                        } else {
                           var49 = true;
                        }

                        if(!var49) {
                           Object var37 = field400.field227;
                           int var5;
                           int var6;
                           int var7;
                           int var8;
                           int var9;
                           int var18;
                           int var19;
                           synchronized(field400.field227) {
                              if(!field551) {
                                 field400.field234 = 0;
                              } else if(class115.field1823 != 0 || field400.field234 >= 40) {
                                 secretCipherBuffer1.putOpcode(166);
                                 secretCipherBuffer1.putByte(0);
                                 var17 = secretCipherBuffer1.offset;
                                 var18 = 0;

                                 for(var19 = 0; var19 < field400.field234 && secretCipherBuffer1.offset - var17 < 240; ++var19) {
                                    ++var18;
                                    var5 = field400.field226[var19];
                                    if(var5 < 0) {
                                       var5 = 0;
                                    } else if(var5 > 502) {
                                       var5 = 502;
                                    }

                                    var6 = field400.field229[var19];
                                    if(var6 < 0) {
                                       var6 = 0;
                                    } else if(var6 > 764) {
                                       var6 = 764;
                                    }

                                    var7 = 765 * var5 + var6;
                                    if(field400.field226[var19] == -1 && field400.field229[var19] == -1) {
                                       var6 = -1;
                                       var5 = -1;
                                       var7 = 524287;
                                    }

                                    if(var6 == field314 && field309 == var5) {
                                       if(field316 < 2047) {
                                          ++field316;
                                       }
                                    } else {
                                       var8 = var6 - field314;
                                       field314 = var6;
                                       var9 = var5 - field309;
                                       field309 = var5;
                                       if(field316 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                          var8 += 32;
                                          var9 += 32;
                                          secretCipherBuffer1.putShort((var8 << 6) + (field316 << 12) + var9);
                                          field316 = 0;
                                       } else if(field316 < 8) {
                                          secretCipherBuffer1.put24bitInt(var7 + (field316 << 19) + 8388608);
                                          field316 = 0;
                                       } else {
                                          secretCipherBuffer1.putInt(-1073741824 + (field316 << 19) + var7);
                                          field316 = 0;
                                       }
                                    }
                                 }

                                 secretCipherBuffer1.method2864(secretCipherBuffer1.offset - var17);
                                 if(var18 >= field400.field234) {
                                    field400.field234 = 0;
                                 } else {
                                    field400.field234 -= var18;

                                    for(var19 = 0; var19 < field400.field234; ++var19) {
                                       field400.field229[var19] = field400.field229[var19 + var18];
                                       field400.field226[var19] = field400.field226[var18 + var19];
                                    }
                                 }
                              }
                           }

                           if(class115.field1823 == 1 || !class177.field2687 && class115.field1823 == 4 || class115.field1823 == 2) {
                              long var20 = (class115.field1826 - field339) / 50L;
                              if(var20 > 4095L) {
                                 var20 = 4095L;
                              }

                              field339 = class115.field1826;
                              var18 = class115.field1813;
                              if(var18 < 0) {
                                 var18 = 0;
                              } else if(var18 > class168.field2207) {
                                 var18 = class168.field2207;
                              }

                              var19 = class115.field1825;
                              if(var19 < 0) {
                                 var19 = 0;
                              } else if(var19 > class32.field755) {
                                 var19 = class32.field755;
                              }

                              var5 = (int)var20;
                              secretCipherBuffer1.putOpcode(241);
                              secretCipherBuffer1.putShort((class115.field1823 == 2?1:0) + (var5 << 1));
                              secretCipherBuffer1.putShort(var19);
                              secretCipherBuffer1.putShort(var18);
                           }

                           if(class105.field1745 > 0) {
                              secretCipherBuffer1.putOpcode(223);
                              secretCipherBuffer1.putShort(0);
                              var16 = secretCipherBuffer1.offset;
                              long var22 = class45.method867();

                              for(var19 = 0; var19 < class105.field1745; ++var19) {
                                 long var24 = var22 - field488;
                                 if(var24 > 16777215L) {
                                    var24 = 16777215L;
                                 }

                                 field488 = var22;
                                 secretCipherBuffer1.method2891(class105.field1740[var19]);
                                 secretCipherBuffer1.method3023((int)var24);
                              }

                              secretCipherBuffer1.method3048(secretCipherBuffer1.offset - var16);
                           }

                           if(field486 > 0) {
                              --field486;
                           }

                           if(class105.field1734[96] || class105.field1734[97] || class105.field1734[98] || class105.field1734[99]) {
                              field390 = true;
                           }

                           if(field390 && field486 <= 0) {
                              field486 = 20;
                              field390 = false;
                              secretCipherBuffer1.putOpcode(162);
                              secretCipherBuffer1.method2900(field398);
                              secretCipherBuffer1.putShort(mapAngle);
                           }

                           if(class114.field1803 && !field554) {
                              field554 = true;
                              secretCipherBuffer1.putOpcode(90);
                              secretCipherBuffer1.putByte(1);
                           }

                           if(!class114.field1803 && field554) {
                              field554 = false;
                              secretCipherBuffer1.putOpcode(90);
                              secretCipherBuffer1.putByte(0);
                           }

                           class72.method1413();
                           if(gameState == 30) {
                              for(class25 var38 = (class25)field461.method2464(); null != var38; var38 = (class25)field461.method2472()) {
                                 if(var38.field598 > 0) {
                                    --var38.field598;
                                 }

                                 ObjectComposition var26;
                                 boolean var50;
                                 if(var38.field598 == 0) {
                                    if(var38.field591 >= 0) {
                                       var18 = var38.field591;
                                       var19 = var38.field593;
                                       var26 = class140.getObjectDefinition(var18);
                                       if(var19 == 11) {
                                          var19 = 10;
                                       }

                                       if(var19 >= 5 && var19 <= 8) {
                                          var19 = 4;
                                       }

                                       var50 = var26.method3641(var19);
                                       if(!var50) {
                                          continue;
                                       }
                                    }

                                    class10.method136(var38.field601, var38.field588, var38.field599, var38.field597, var38.field591, var38.field592, var38.field593);
                                    var38.unlink();
                                 } else {
                                    if(var38.field589 > 0) {
                                       --var38.field589;
                                    }

                                    if(var38.field589 == 0 && var38.field599 >= 1 && var38.field597 >= 1 && var38.field599 <= 102 && var38.field597 <= 102) {
                                       if(var38.field594 >= 0) {
                                          var18 = var38.field594;
                                          var19 = var38.field596;
                                          var26 = class140.getObjectDefinition(var18);
                                          if(var19 == 11) {
                                             var19 = 10;
                                          }

                                          if(var19 >= 5 && var19 <= 8) {
                                             var19 = 4;
                                          }

                                          var50 = var26.method3641(var19);
                                          if(!var50) {
                                             continue;
                                          }
                                       }

                                       class10.method136(var38.field601, var38.field588, var38.field599, var38.field597, var38.field594, var38.field587, var38.field596);
                                       var38.field589 = -1;
                                       if(var38.field591 == var38.field594 && var38.field591 == -1) {
                                          var38.unlink();
                                       } else if(var38.field594 == var38.field591 && var38.field587 == var38.field592 && var38.field593 == var38.field596) {
                                          var38.unlink();
                                       }
                                    }
                                 }
                              }

                              ScriptState.method144();
                              ++field350;
                              if(field350 > 750) {
                                 class107.method2083();
                              } else {
                                 class202.method3823();

                                 for(var16 = 0; var16 < field402; ++var16) {
                                    var17 = field342[var16];
                                    NPC var3 = cachedNPCs[var17];
                                    if(null != var3) {
                                       method555(var3, var3.composition.field3011);
                                    }
                                 }

                                 class105.method2064();
                                 ++field511;
                                 if(field412 != 0) {
                                    field312 += 20;
                                    if(field312 >= 400) {
                                       field412 = 0;
                                    }
                                 }

                                 if(null != XGrandExchangeOffer.field42) {
                                    ++field351;
                                    if(field351 >= 15) {
                                       class22.method197(XGrandExchangeOffer.field42);
                                       XGrandExchangeOffer.field42 = null;
                                    }
                                 }

                                 Widget var40 = class152.field2085;
                                 Widget var41 = WidgetNode.field190;
                                 class152.field2085 = null;
                                 WidgetNode.field190 = null;
                                 field480 = null;
                                 field484 = false;
                                 field481 = false;
                                 field345 = 0;

                                 while(true) {
                                    while(ItemLayer.method1491() && field345 < 128) {
                                       if(field470 >= 2 && class105.field1734[82] && class203.field3084 == 66) {
                                          String var42 = class161.method3136();
                                          IndexData.field2749.setContents(new StringSelection(var42), (ClipboardOwner)null);
                                       } else {
                                          field528[field345] = class203.field3084;
                                          field419[field345] = class37.field810;
                                          ++field345;
                                       }
                                    }

                                    if(widgetRoot != -1) {
                                       var18 = widgetRoot;
                                       var19 = class32.field755;
                                       var5 = class168.field2207;
                                       if(Ignore.method178(var18)) {
                                          class25.method558(Widget.widgets[var18], -1, 0, 0, var19, var5, 0, 0);
                                       }
                                    }

                                    ++field561;

                                    while(true) {
                                       Widget var4;
                                       class18 var43;
                                       Widget var51;
                                       do {
                                          var43 = (class18)field307.method2487();
                                          if(null == var43) {
                                             while(true) {
                                                do {
                                                   var43 = (class18)field504.method2487();
                                                   if(var43 == null) {
                                                      while(true) {
                                                         do {
                                                            var43 = (class18)field502.method2487();
                                                            if(null == var43) {
                                                               class30.method643();
                                                               int var12;
                                                               int var13;
                                                               int var27;
                                                               int var47;
                                                               if(class164.field2177 == null && null == field476) {
                                                                  var18 = class115.field1823;
                                                                  if(isMenuOpen) {
                                                                     if(var18 != 1 && (class177.field2687 || var18 != 4)) {
                                                                        var19 = class115.field1817;
                                                                        var5 = class115.field1818;
                                                                        if(var19 < World.menuX - 10 || var19 > Widget.menuWidth + World.menuX + 10 || var5 < class104.menuY - 10 || var5 > 10 + class104.menuY + class97.menuHeight) {
                                                                           isMenuOpen = false;
                                                                           class137.method2541(World.menuX, class104.menuY, Widget.menuWidth, class97.menuHeight);
                                                                        }
                                                                     }

                                                                     if(var18 == 1 || !class177.field2687 && var18 == 4) {
                                                                        var19 = World.menuX;
                                                                        var5 = class104.menuY;
                                                                        var6 = Widget.menuWidth;
                                                                        var7 = class115.field1825;
                                                                        var8 = class115.field1813;
                                                                        var9 = -1;

                                                                        for(var27 = 0; var27 < menuOptionCount; ++var27) {
                                                                           var47 = var5 + 31 + (menuOptionCount - 1 - var27) * 15;
                                                                           if(var7 > var19 && var7 < var6 + var19 && var8 > var47 - 13 && var8 < var47 + 3) {
                                                                              var9 = var27;
                                                                           }
                                                                        }

                                                                        if(var9 != -1 && var9 >= 0) {
                                                                           var27 = menuActionParams0[var9];
                                                                           var47 = menuActionParams1[var9];
                                                                           var12 = menuTypes[var9];
                                                                           var13 = menuIdentifiers[var9];
                                                                           String var48 = menuOptions[var9];
                                                                           String var15 = menuTargets[var9];
                                                                           Item.menuAction(var27, var47, var12, var13, var48, var15, class115.field1825, class115.field1813);
                                                                        }

                                                                        isMenuOpen = false;
                                                                        class137.method2541(World.menuX, class104.menuY, Widget.menuWidth, class97.menuHeight);
                                                                     }
                                                                  } else {
                                                                     label1412: {
                                                                        label1449: {
                                                                           var19 = World.method635();
                                                                           if((var18 == 1 || !class177.field2687 && var18 == 4) && var19 >= 0) {
                                                                              var5 = menuTypes[var19];
                                                                              if(var5 == 39 || var5 == 40 || var5 == 41 || var5 == 42 || var5 == 43 || var5 == 33 || var5 == 34 || var5 == 35 || var5 == 36 || var5 == 37 || var5 == 38 || var5 == 1005) {
                                                                                 var6 = menuActionParams0[var19];
                                                                                 var7 = menuActionParams1[var19];
                                                                                 Widget var28 = FaceNormal.method1932(var7);
                                                                                 var27 = FloorUnderlayDefinition.method3533(var28);
                                                                                 boolean var46 = (var27 >> 28 & 1) != 0;
                                                                                 if(var46) {
                                                                                    break label1449;
                                                                                 }

                                                                                 var12 = FloorUnderlayDefinition.method3533(var28);
                                                                                 boolean var11 = (var12 >> 29 & 1) != 0;
                                                                                 if(var11) {
                                                                                    break label1449;
                                                                                 }
                                                                              }
                                                                           }

                                                                           if((var18 == 1 || !class177.field2687 && var18 == 4) && (field439 == 1 && menuOptionCount > 2 && !class187.method3495() || class177.method3324(var19))) {
                                                                              var18 = 2;
                                                                           }

                                                                           if((var18 == 1 || !class177.field2687 && var18 == 4) && menuOptionCount > 0 && var19 >= 0) {
                                                                              var5 = menuActionParams0[var19];
                                                                              var6 = menuActionParams1[var19];
                                                                              var7 = menuTypes[var19];
                                                                              var8 = menuIdentifiers[var19];
                                                                              String var29 = menuOptions[var19];
                                                                              String var10 = menuTargets[var19];
                                                                              Item.menuAction(var5, var6, var7, var8, var29, var10, class115.field1825, class115.field1813);
                                                                           }

                                                                           if(var18 == 2 && menuOptionCount > 0) {
                                                                              class41.method815(class115.field1825, class115.field1813);
                                                                           }
                                                                           break label1412;
                                                                        }

                                                                        if(null != class164.field2177 && !field416) {
                                                                           var47 = World.method635();
                                                                           if(field439 != 1 && !class177.method3324(var47) && menuOptionCount > 0) {
                                                                              var12 = field338;
                                                                              var13 = field427;
                                                                              class38 var14 = GameObject.field1645;
                                                                              Item.menuAction(var14.field820, var14.field816, var14.field817, var14.field818, var14.field819, var14.field819, var12, var13);
                                                                              GameObject.field1645 = null;
                                                                           }
                                                                        }

                                                                        field416 = false;
                                                                        field378 = 0;
                                                                        if(null != class164.field2177) {
                                                                           class22.method197(class164.field2177);
                                                                        }

                                                                        class164.field2177 = FaceNormal.method1932(var7);
                                                                        field556 = var6;
                                                                        field338 = class115.field1825;
                                                                        field427 = class115.field1813;
                                                                        if(var19 >= 0) {
                                                                           GameObject.field1645 = new class38();
                                                                           GameObject.field1645.field820 = menuActionParams0[var19];
                                                                           GameObject.field1645.field816 = menuActionParams1[var19];
                                                                           GameObject.field1645.field817 = menuTypes[var19];
                                                                           GameObject.field1645.field818 = menuIdentifiers[var19];
                                                                           GameObject.field1645.field819 = menuOptions[var19];
                                                                        }

                                                                        class22.method197(class164.field2177);
                                                                     }
                                                                  }
                                                               }

                                                               if(null != field476) {
                                                                  class143.method2771();
                                                               }

                                                               if(null != class164.field2177) {
                                                                  class22.method197(class164.field2177);
                                                                  ++field378;
                                                                  if(class115.field1811 != 0) {
                                                                     if(field378 >= 5 && (class115.field1817 > 5 + field338 || class115.field1817 < field338 - 5 || class115.field1818 > 5 + field427 || class115.field1818 < field427 - 5)) {
                                                                        field416 = true;
                                                                     }
                                                                  } else {
                                                                     if(field416) {
                                                                        if(class164.field2177 == class161.field2160 && field556 != field418) {
                                                                           Widget var44 = class164.field2177;
                                                                           byte var52 = 0;
                                                                           if(field344 == 1 && var44.contentType == 206) {
                                                                              var52 = 1;
                                                                           }

                                                                           if(var44.itemIds[field418] <= 0) {
                                                                              var52 = 0;
                                                                           }

                                                                           var6 = FloorUnderlayDefinition.method3533(var44);
                                                                           boolean var45 = (var6 >> 29 & 1) != 0;
                                                                           if(var45) {
                                                                              var7 = field556;
                                                                              var8 = field418;
                                                                              var44.itemIds[var8] = var44.itemIds[var7];
                                                                              var44.itemQuantities[var8] = var44.itemQuantities[var7];
                                                                              var44.itemIds[var7] = -1;
                                                                              var44.itemQuantities[var7] = 0;
                                                                           } else if(var52 == 1) {
                                                                              var7 = field556;
                                                                              var8 = field418;

                                                                              while(var8 != var7) {
                                                                                 if(var7 > var8) {
                                                                                    var44.method3255(var7 - 1, var7);
                                                                                    --var7;
                                                                                 } else if(var7 < var8) {
                                                                                    var44.method3255(1 + var7, var7);
                                                                                    ++var7;
                                                                                 }
                                                                              }
                                                                           } else {
                                                                              var44.method3255(field418, field556);
                                                                           }

                                                                           secretCipherBuffer1.putOpcode(54);
                                                                           secretCipherBuffer1.method2900(field418);
                                                                           secretCipherBuffer1.method2900(field556);
                                                                           secretCipherBuffer1.method2893(var52);
                                                                           secretCipherBuffer1.method2950(class164.field2177.id);
                                                                        }
                                                                     } else {
                                                                        var18 = World.method635();
                                                                        if(menuOptionCount <= 2 || (field439 != 1 || class187.method3495()) && !class177.method3324(var18)) {
                                                                           if(menuOptionCount > 0) {
                                                                              var19 = field338;
                                                                              var5 = field427;
                                                                              class38 var30 = GameObject.field1645;
                                                                              Item.menuAction(var30.field820, var30.field816, var30.field817, var30.field818, var30.field819, var30.field819, var19, var5);
                                                                              GameObject.field1645 = null;
                                                                           }
                                                                        } else {
                                                                           class41.method815(field338, field427);
                                                                        }
                                                                     }

                                                                     field351 = 10;
                                                                     class115.field1823 = 0;
                                                                     class164.field2177 = null;
                                                                  }
                                                               }

                                                               if(Region.method1775()) {
                                                                  var18 = Region.field1532;
                                                                  var19 = Region.field1533;
                                                                  secretCipherBuffer1.putOpcode(11);
                                                                  secretCipherBuffer1.putByte(5);
                                                                  secretCipherBuffer1.method2893(class105.field1734[82]?(class105.field1734[81]?2:1):0);
                                                                  secretCipherBuffer1.method2900(var19 + class187.baseY);
                                                                  secretCipherBuffer1.method2895(class119.baseX + var18);
                                                                  Region.method1776();
                                                                  field557 = class115.field1825;
                                                                  field410 = class115.field1813;
                                                                  field412 = 1;
                                                                  field312 = 0;
                                                                  flagX = var18;
                                                                  flagY = var19;
                                                               }

                                                               if(var40 != class152.field2085) {
                                                                  if(null != var40) {
                                                                     class22.method197(var40);
                                                                  }

                                                                  if(null != class152.field2085) {
                                                                     class22.method197(class152.field2085);
                                                                  }
                                                               }

                                                               if(WidgetNode.field190 != var41 && field453 == field369) {
                                                                  if(var41 != null) {
                                                                     class22.method197(var41);
                                                                  }

                                                                  if(WidgetNode.field190 != null) {
                                                                     class22.method197(WidgetNode.field190);
                                                                  }
                                                               }

                                                               if(null != WidgetNode.field190) {
                                                                  if(field453 < field369) {
                                                                     ++field453;
                                                                     if(field369 == field453) {
                                                                        class22.method197(WidgetNode.field190);
                                                                     }
                                                                  }
                                                               } else if(field453 > 0) {
                                                                  --field453;
                                                               }

                                                               Frames.method1937();
                                                               if(field446) {
                                                                  var18 = 64 + class15.field172 * 128;
                                                                  var19 = 64 + class22.field254 * 128;
                                                                  var5 = class103.method2025(var18, var19, Sequence.plane) - Ignore.field216;
                                                                  if(MessageNode.cameraX < var18) {
                                                                     MessageNode.cameraX += class207.field3109 + class5.field54 * (var18 - MessageNode.cameraX) / 1000;
                                                                     if(MessageNode.cameraX > var18) {
                                                                        MessageNode.cameraX = var18;
                                                                     }
                                                                  }

                                                                  if(MessageNode.cameraX > var18) {
                                                                     MessageNode.cameraX -= class5.field54 * (MessageNode.cameraX - var18) / 1000 + class207.field3109;
                                                                     if(MessageNode.cameraX < var18) {
                                                                        MessageNode.cameraX = var18;
                                                                     }
                                                                  }

                                                                  if(class16.cameraZ < var5) {
                                                                     class16.cameraZ += (var5 - class16.cameraZ) * class5.field54 / 1000 + class207.field3109;
                                                                     if(class16.cameraZ > var5) {
                                                                        class16.cameraZ = var5;
                                                                     }
                                                                  }

                                                                  if(class16.cameraZ > var5) {
                                                                     class16.cameraZ -= (class16.cameraZ - var5) * class5.field54 / 1000 + class207.field3109;
                                                                     if(class16.cameraZ < var5) {
                                                                        class16.cameraZ = var5;
                                                                     }
                                                                  }

                                                                  if(DecorativeObject.cameraY < var19) {
                                                                     DecorativeObject.cameraY += class5.field54 * (var19 - DecorativeObject.cameraY) / 1000 + class207.field3109;
                                                                     if(DecorativeObject.cameraY > var19) {
                                                                        DecorativeObject.cameraY = var19;
                                                                     }
                                                                  }

                                                                  if(DecorativeObject.cameraY > var19) {
                                                                     DecorativeObject.cameraY -= class5.field54 * (DecorativeObject.cameraY - var19) / 1000 + class207.field3109;
                                                                     if(DecorativeObject.cameraY < var19) {
                                                                        DecorativeObject.cameraY = var19;
                                                                     }
                                                                  }

                                                                  var18 = IndexFile.field1839 * 128 + 64;
                                                                  var19 = 64 + Projectile.field900 * 128;
                                                                  var5 = class103.method2025(var18, var19, Sequence.plane) - class145.field2033;
                                                                  var6 = var18 - MessageNode.cameraX;
                                                                  var7 = var5 - class16.cameraZ;
                                                                  var8 = var19 - DecorativeObject.cameraY;
                                                                  var9 = (int)Math.sqrt((double)(var6 * var6 + var8 * var8));
                                                                  var27 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                                  var47 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                                  if(var27 < 128) {
                                                                     var27 = 128;
                                                                  }

                                                                  if(var27 > 383) {
                                                                     var27 = 383;
                                                                  }

                                                                  if(class16.cameraPitch < var27) {
                                                                     class16.cameraPitch += class37.field813 * (var27 - class16.cameraPitch) / 1000 + PlayerComposition.field2195;
                                                                     if(class16.cameraPitch > var27) {
                                                                        class16.cameraPitch = var27;
                                                                     }
                                                                  }

                                                                  if(class16.cameraPitch > var27) {
                                                                     class16.cameraPitch -= class37.field813 * (class16.cameraPitch - var27) / 1000 + PlayerComposition.field2195;
                                                                     if(class16.cameraPitch < var27) {
                                                                        class16.cameraPitch = var27;
                                                                     }
                                                                  }

                                                                  var12 = var47 - class9.cameraYaw;
                                                                  if(var12 > 1024) {
                                                                     var12 -= 2048;
                                                                  }

                                                                  if(var12 < -1024) {
                                                                     var12 += 2048;
                                                                  }

                                                                  if(var12 > 0) {
                                                                     class9.cameraYaw += PlayerComposition.field2195 + class37.field813 * var12 / 1000;
                                                                     class9.cameraYaw &= 2047;
                                                                  }

                                                                  if(var12 < 0) {
                                                                     class9.cameraYaw -= PlayerComposition.field2195 + class37.field813 * -var12 / 1000;
                                                                     class9.cameraYaw &= 2047;
                                                                  }

                                                                  var13 = var47 - class9.cameraYaw;
                                                                  if(var13 > 1024) {
                                                                     var13 -= 2048;
                                                                  }

                                                                  if(var13 < -1024) {
                                                                     var13 += 2048;
                                                                  }

                                                                  if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                                     class9.cameraYaw = var47;
                                                                  }
                                                               }

                                                               for(var18 = 0; var18 < 5; ++var18) {
                                                                  ++field413[var18];
                                                               }

                                                               class9.chatMessages.method878();
                                                               var18 = class142.method2747();
                                                               var19 = class18.method175();
                                                               if(var18 > 15000 && var19 > 15000) {
                                                                  field355 = 250;
                                                                  Actor.method588(14500);
                                                                  secretCipherBuffer1.putOpcode(140);
                                                               }

                                                               ++field372;
                                                               if(field372 > 500) {
                                                                  field372 = 0;
                                                                  var5 = (int)(Math.random() * 8.0D);
                                                                  if((var5 & 1) == 1) {
                                                                     field366 += field367;
                                                                  }

                                                                  if((var5 & 2) == 2) {
                                                                     field573 += field519;
                                                                  }

                                                                  if((var5 & 4) == 4) {
                                                                     field370 += field371;
                                                                  }
                                                               }

                                                               if(field366 < -50) {
                                                                  field367 = 2;
                                                               }

                                                               if(field366 > 50) {
                                                                  field367 = -2;
                                                               }

                                                               if(field573 < -55) {
                                                                  field519 = 2;
                                                               }

                                                               if(field573 > 55) {
                                                                  field519 = -2;
                                                               }

                                                               if(field370 < -40) {
                                                                  field371 = 1;
                                                               }

                                                               if(field370 > 40) {
                                                                  field371 = -1;
                                                               }

                                                               ++field548;
                                                               if(field548 > 500) {
                                                                  field548 = 0;
                                                                  var5 = (int)(Math.random() * 8.0D);
                                                                  if((var5 & 1) == 1) {
                                                                     mapScale += field374;
                                                                  }

                                                                  if((var5 & 2) == 2) {
                                                                     mapScaleDelta += field376;
                                                                  }
                                                               }

                                                               if(mapScale < -60) {
                                                                  field374 = 2;
                                                               }

                                                               if(mapScale > 60) {
                                                                  field374 = -2;
                                                               }

                                                               if(mapScaleDelta < -20) {
                                                                  field376 = 1;
                                                               }

                                                               if(mapScaleDelta > 10) {
                                                                  field376 = -1;
                                                               }

                                                               for(class16 var53 = (class16)field531.method2499(); var53 != null; var53 = (class16)field531.method2500()) {
                                                                  if((long)var53.field183 < class45.method867() / 1000L - 5L) {
                                                                     if(var53.field182 > 0) {
                                                                        Player.sendGameMessage(5, "", var53.field178 + " has logged in.");
                                                                     }

                                                                     if(var53.field182 == 0) {
                                                                        Player.sendGameMessage(5, "", var53.field178 + " has logged out.");
                                                                     }

                                                                     var53.method2511();
                                                                  }
                                                               }

                                                               ++field436;
                                                               if(field436 > 50) {
                                                                  secretCipherBuffer1.putOpcode(210);
                                                               }

                                                               try {
                                                                  if(null != class20.field233 && secretCipherBuffer1.offset > 0) {
                                                                     class20.field233.queueForWrite(secretCipherBuffer1.payload, 0, secretCipherBuffer1.offset);
                                                                     secretCipherBuffer1.offset = 0;
                                                                     field436 = 0;
                                                                     return;
                                                                  }
                                                               } catch (IOException var31) {
                                                                  class107.method2083();
                                                               }

                                                               return;
                                                            }

                                                            var4 = var43.field207;
                                                            if(var4.index < 0) {
                                                               break;
                                                            }

                                                            var51 = FaceNormal.method1932(var4.parentId);
                                                         } while(null == var51 || var51.children == null || var4.index >= var51.children.length || var51.children[var4.index] != var4);

                                                         class26.method565(var43);
                                                      }
                                                   }

                                                   var4 = var43.field207;
                                                   if(var4.index < 0) {
                                                      break;
                                                   }

                                                   var51 = FaceNormal.method1932(var4.parentId);
                                                } while(var51 == null || var51.children == null || var4.index >= var51.children.length || var4 != var51.children[var4.index]);

                                                class26.method565(var43);
                                             }
                                          }

                                          var4 = var43.field207;
                                          if(var4.index < 0) {
                                             break;
                                          }

                                          var51 = FaceNormal.method1932(var4.parentId);
                                       } while(var51 == null || var51.children == null || var4.index >= var51.children.length || var4 != var51.children[var4.index]);

                                       class26.method565(var43);
                                    }
                                 }
                              }
                           }
                           break;
                        }

                        secretCipherBuffer1.putOpcode(152);
                        secretCipherBuffer1.putByte(0);
                        var17 = secretCipherBuffer1.offset;
                        class174.method3313(secretCipherBuffer1);
                        secretCipherBuffer1.method2864(secretCipherBuffer1.offset - var17);
                     }
                  }
               }
            } else if(gameState == 40 || gameState == 45) {
               XItemContainer.method151();
            }

            return;
         }

         var1.field2714.method3426(var1.field2716, (int)var1.hash, var1.field2715, false);
      }
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-81"
   )
   static final void method550(int var0) {
      class30.method640();

      for(class31 var1 = (class31)class31.field732.method2464(); null != var1; var1 = (class31)class31.field732.method2472()) {
         if(null != var1.field729) {
            var1.method665();
         }
      }

      int var4 = class109.method2096(var0).field2790;
      if(var4 != 0) {
         int var2 = class165.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               class84.method1680(0.9D);
               ((TextureProvider)class84.field1472).method1462(0.9D);
            }

            if(var2 == 2) {
               class84.method1680(0.8D);
               ((TextureProvider)class84.field1472).method1462(0.8D);
            }

            if(var2 == 3) {
               class84.method1680(0.7D);
               ((TextureProvider)class84.field1472).method1462(0.7D);
            }

            if(var2 == 4) {
               class84.method1680(0.6D);
               ((TextureProvider)class84.field1472).method1462(0.6D);
            }

            ChatMessages.method904();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(field540 != var3) {
               if(field540 == 0 && field541 != -1) {
                  TextureProvider.method1487(field586, field541, 0, var3, false);
                  field542 = false;
               } else if(var3 == 0) {
                  TextureProvider.method1486();
                  field542 = false;
               } else if(class138.field1940 != 0) {
                  NPC.field783 = var3;
               } else {
                  class138.field1939.method2564(var3);
               }

               field540 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               field543 = 127;
            }

            if(var2 == 1) {
               field543 = 96;
            }

            if(var2 == 2) {
               field543 = 64;
            }

            if(var2 == 3) {
               field543 = 32;
            }

            if(var2 == 4) {
               field543 = 0;
            }
         }

         if(var4 == 5) {
            field439 = var2;
         }

         if(var4 == 6) {
            field465 = var2;
         }

         if(var4 == 9) {
            field344 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               field544 = 127;
            }

            if(var2 == 1) {
               field544 = 96;
            }

            if(var2 == 2) {
               field544 = 64;
            }

            if(var2 == 3) {
               field544 = 32;
            }

            if(var2 == 4) {
               field544 = 0;
            }
         }

         if(var4 == 17) {
            field471 = var2 & '\uffff';
         }

         class40[] var5;
         if(var4 == 18) {
            var5 = new class40[]{class40.field827, class40.field828, class40.field829, class40.field830};
            field328 = (class40)method556(var5, var2);
            if(field328 == null) {
               field328 = class40.field829;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               field340 = -1;
            } else {
               field340 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new class40[]{class40.field827, class40.field828, class40.field829, class40.field830};
            field392 = (class40)method556(var5, var2);
            if(null == field392) {
               field392 = class40.field829;
            }
         }

      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "-158030054"
   )
   static final void method552(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field588 == 0) {
         var1 = CombatInfo1.region.method1762(var0.field601, var0.field599, var0.field597);
      }

      if(var0.field588 == 1) {
         var1 = CombatInfo1.region.method1842(var0.field601, var0.field599, var0.field597);
      }

      if(var0.field588 == 2) {
         var1 = CombatInfo1.region.method1774(var0.field601, var0.field599, var0.field597);
      }

      if(var0.field588 == 3) {
         var1 = CombatInfo1.region.method1845(var0.field601, var0.field599, var0.field597);
      }

      if(var1 != 0) {
         int var5 = CombatInfo1.region.method1766(var0.field601, var0.field599, var0.field597, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field591 = var2;
      var0.field593 = var3;
      var0.field592 = var4;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "446427982"
   )
   static final void method555(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      if(var0.field664 > gameCycle) {
         var2 = var0.field664 - gameCycle;
         var3 = var0.field660 * 128 + var0.field622 * 64;
         var4 = var0.field662 * 128 + var0.field622 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field651 = 0;
         var0.field669 = var0.field640;
      } else if(var0.field665 >= gameCycle) {
         if(gameCycle == var0.field665 || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field652 > Friend.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
            var2 = var0.field665 - var0.field664;
            var3 = gameCycle - var0.field664;
            var4 = var0.field660 * 128 + var0.field622 * 64;
            int var5 = var0.field622 * 64 + var0.field662 * 128;
            int var6 = var0.field661 * 128 + var0.field622 * 64;
            int var7 = var0.field643 * 128 + var0.field622 * 64;
            var0.x = (var3 * var6 + (var2 - var3) * var4) / var2;
            var0.y = ((var2 - var3) * var5 + var3 * var7) / var2;
         }

         var0.field651 = 0;
         var0.field669 = var0.field640;
         var0.angle = var0.field669;
      } else {
         XGrandExchangeOffer.method32(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field664 = 0;
         var0.field665 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field622 * 64;
         var0.y = var0.field622 * 64 + var0.pathY[0] * 128;
         var0.method566();
      }

      if(var0 == Projectile.localPlayer && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field664 = 0;
         var0.field665 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field622 * 64;
         var0.y = var0.field622 * 64 + 128 * var0.pathY[0];
         var0.method566();
      }

      if(var0.field671 != 0) {
         if(var0.interacting != -1) {
            Object var9 = null;
            if(var0.interacting < '耀') {
               var9 = cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var9 = cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var9) {
               var3 = var0.x - ((Actor)var9).x;
               var4 = var0.y - ((Actor)var9).y;
               if(var3 != 0 || var4 != 0) {
                  var0.field669 = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if(var0.field677) {
               var0.interacting = -1;
               var0.field677 = false;
            }
         }

         if(var0.field646 != -1 && (var0.field672 == 0 || var0.field651 > 0)) {
            var0.field669 = var0.field646;
            var0.field646 = -1;
         }

         var2 = var0.field669 - var0.angle & 2047;
         if(var2 == 0 && var0.field677) {
            var0.interacting = -1;
            var0.field677 = false;
         }

         if(var2 != 0) {
            ++var0.field666;
            boolean var10;
            if(var2 > 1024) {
               var0.angle -= var0.field671;
               var10 = true;
               if(var2 < var0.field671 || var2 > 2048 - var0.field671) {
                  var0.angle = var0.field669;
                  var10 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field666 > 25 || var10)) {
                  if(var0.field633 != -1) {
                     var0.poseAnimation = var0.field633;
                  } else {
                     var0.poseAnimation = var0.field626;
                  }
               }
            } else {
               var0.angle += var0.field671;
               var10 = true;
               if(var2 < var0.field671 || var2 > 2048 - var0.field671) {
                  var0.angle = var0.field669;
                  var10 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field666 > 25 || var10)) {
                  if(var0.field625 != -1) {
                     var0.poseAnimation = var0.field625;
                  } else {
                     var0.poseAnimation = var0.field626;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field666 = 0;
         }
      }

      var0.field621 = false;
      Sequence var11;
      if(var0.poseAnimation != -1) {
         var11 = Friend.getAnimation(var0.poseAnimation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field649;
            if(var0.poseFrame < var11.frameIDs.length && var0.field649 > var11.frameLenghts[var0.poseFrame]) {
               var0.field649 = 1;
               ++var0.poseFrame;
               GroundObject.method1567(var11, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var11.frameIDs.length) {
               var0.field649 = 0;
               var0.poseFrame = 0;
               GroundObject.method1567(var11, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && gameCycle >= var0.field658) {
         if(var0.field678 < 0) {
            var0.field678 = 0;
         }

         var2 = class145.method2800(var0.graphic).field2808;
         if(var2 != -1) {
            Sequence var8 = Friend.getAnimation(var2);
            if(null != var8 && null != var8.frameIDs) {
               ++var0.field638;
               if(var0.field678 < var8.frameIDs.length && var0.field638 > var8.frameLenghts[var0.field678]) {
                  var0.field638 = 1;
                  ++var0.field678;
                  GroundObject.method1567(var8, var0.field678, var0.x, var0.y);
               }

               if(var0.field678 >= var8.frameIDs.length && (var0.field678 < 0 || var0.field678 >= var8.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var11 = Friend.getAnimation(var0.animation);
         if(var11.precedenceAnimating == 1 && var0.field655 > 0 && var0.field664 <= gameCycle && var0.field665 < gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var11 = Friend.getAnimation(var0.animation);
         if(var11 != null && var11.frameIDs != null) {
            ++var0.field652;
            if(var0.actionFrame < var11.frameIDs.length && var0.field652 > var11.frameLenghts[var0.actionFrame]) {
               var0.field652 = 1;
               ++var0.actionFrame;
               GroundObject.method1567(var11, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var11.frameIDs.length) {
               var0.actionFrame -= var11.frameStep;
               ++var0.field637;
               if(var0.field637 >= var11.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var11.frameIDs.length) {
                  GroundObject.method1567(var11, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field621 = var11.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Lclass158;IB)Lclass158;",
      garbageValue = "-125"
   )
   public static class158 method556(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod4085()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1602656377"
   )
   public static void method557(class182 var0) {
      class189.field2801 = var0;
   }
}
