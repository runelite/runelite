import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("lx")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("o")
   static Client field277;
   @ObfuscatedName("i")
   static boolean field278 = false;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 533260721
   )
   static int field279;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -1248956475
   )
   static int field280;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 231339351
   )
   static int field281 = 0;
   @ObfuscatedName("s")
   static class228 field282;
   @ObfuscatedName("g")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1411147767
   )
   static int field284;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 939408459
   )
   static int field285 = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1823130251
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("z")
   static boolean field287 = true;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = 895384669
   )
   static int field288;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -3290557238120843711L
   )
   static long field289 = -1L;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1407767335
   )
   static int field290 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 39833753
   )
   static int field291 = -1;
   @ObfuscatedName("or")
   static short field292;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 2063961575
   )
   static int field293;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1000825959
   )
   static int field294;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -270830759
   )
   static int field295;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1508784659
   )
   static int field296 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 888982391
   )
   static int field297 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -955362863
   )
   static int field298 = 0;
   @ObfuscatedName("mp")
   static String field299;
   @ObfuscatedName("hr")
   static Deque field300;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 370953683
   )
   static int field301 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1929676741
   )
   static int field302 = 0;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1403660417
   )
   static int field303 = 0;
   @ObfuscatedName("ac")
   static class40 field304;
   @ObfuscatedName("ag")
   static class40 field305;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -160478737
   )
   static int field306;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -398258759
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1626571663
   )
   static int field308;
   @ObfuscatedName("jf")
   static Widget field309;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1737269909
   )
   static int field310;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -2013799451
   )
   static int field311;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1942627171
   )
   static int field312;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 2036324915
   )
   static int field313;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 563634625
   )
   static int field314;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1201387633
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ch")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1963783853
   )
   static int field317;
   @ObfuscatedName("hj")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1980103703
   )
   static int field319;
   @ObfuscatedName("ck")
   static int[] field320;
   @ObfuscatedName("ca")
   static class166 field321;
   @ObfuscatedName("cw")
   static class166 field322;
   @ObfuscatedName("cg")
   static class166 field323;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 602624511
   )
   static int field324;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1615559609
   )
   static int field325 = 0;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1574163715
   )
   static int field326;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 966108241
   )
   static int field327;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -991946675
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1987965077
   )
   static int field329;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -152285715
   )
   static int field330;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1231119183
   )
   static int field331;
   @ObfuscatedName("cj")
   static boolean field332;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = 1738894645
   )
   static int field333;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -114400571
   )
   static int field334;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 124379971
   )
   static int field335;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      longValue = 6499964958454419577L
   )
   static long field336;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -643556409
   )
   static int field337;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("lz")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("dg")
   static int[][][] field340;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1682999833
   )
   static int field341;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1075937621
   )
   static int field342;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 401149831
   )
   static int field343;
   @ObfuscatedName("hd")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -322426599
   )
   static int field345;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 886075539
   )
   static int field346;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -579921785
   )
   static int field347;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1402148453
   )
   static int field348 = 0;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      longValue = -4708771471016809773L
   )
   static long field349;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -212454997
   )
   static int field350;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1198943407
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -1441502267
   )
   static int field352;
   @ObfuscatedName("an")
   static class184 field353;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 1326252403
   )
   static int field354;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -961894941
   )
   static int field355;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1922996069
   )
   static int field356;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = 1610625219
   )
   static int field357;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -315234861
   )
   static int field358;
   @ObfuscatedName("es")
   static boolean field359;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -1894556973
   )
   static int field360;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 1638258595
   )
   static int field361;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -701834271
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 1314713061
   )
   static int field363;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1151263091
   )
   static int field364;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1175885101
   )
   static int field365 = -1;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 1458191775
   )
   static int field366;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -2136486969
   )
   static int field367;
   @ObfuscatedName("om")
   static short field368;
   @ObfuscatedName("iw")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 478906581
   )
   static int field370;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -596145671
   )
   static int field371;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1367319189
   )
   static int field372;
   @ObfuscatedName("fn")
   static int[] field373;
   @ObfuscatedName("fx")
   static int[] field374;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 809776733
   )
   static int field375;
   @ObfuscatedName("fd")
   static int[] field376;
   @ObfuscatedName("fr")
   static int[] field377;
   @ObfuscatedName("fu")
   static int[] field378;
   @ObfuscatedName("fw")
   static int[] field379;
   @ObfuscatedName("gh")
   static String[] field380;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -930389743
   )
   static int field381;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = -1790897967
   )
   static int field382;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 7755257
   )
   static int field383;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -559610725
   )
   static int field384;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1082120459
   )
   static int field385;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -2134585007
   )
   static int field386;
   @ObfuscatedName("oh")
   static int[] field387;
   @ObfuscatedName("jd")
   static boolean field388;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1024172173
   )
   static int field389;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -637868859
   )
   static int field390;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 962137221
   )
   static int field391;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -1283955253
   )
   static int field392;
   @ObfuscatedName("ky")
   static int[] field393;
   @ObfuscatedName("jz")
   static boolean field394;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -590420825
   )
   static int field395;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -865122935
   )
   static int field396;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -327217579
   )
   static int field397;
   @ObfuscatedName("gd")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 2047677037
   )
   static int field399;
   @ObfuscatedName("nm")
   static class53[] field400;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1227672881
   )
   static int field401;
   @ObfuscatedName("hh")
   static int[] field402;
   @ObfuscatedName("kt")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("ga")
   static int[][] field404;
   @ObfuscatedName("he")
   @Export("playerOptionsPriority")
   static boolean[] playerOptionsPriority;
   @ObfuscatedName("hs")
   static int[] field406;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -1510577361
   )
   static int field407;
   @ObfuscatedName("hp")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("of")
   static class130 field409;
   @ObfuscatedName("hb")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hz")
   static Deque field411;
   @ObfuscatedName("oi")
   static short field412;
   @ObfuscatedName("hg")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 126430633
   )
   static int field415;
   @ObfuscatedName("hi")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -676073067
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("hy")
   static final int[] field418;
   @ObfuscatedName("hx")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jk")
   static Widget field420;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 587309321
   )
   static int field421;
   @ObfuscatedName("ik")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("hq")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 1282365529
   )
   static int field424;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 1396557159
   )
   static int field425;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1306570935
   )
   static int field426;
   @ObfuscatedName("ha")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 991779215
   )
   static int field428 = 0;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 2051506049
   )
   static int field429;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -997427781
   )
   static int field430;
   @ObfuscatedName("is")
   static String field431;
   @ObfuscatedName("iq")
   static boolean field432;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 1699252731
   )
   static int field433;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 1542914419
   )
   static int field434;
   @ObfuscatedName("ij")
   static String field435;
   @ObfuscatedName("ie")
   static String field436;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -115360685
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("it")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 2091583515
   )
   static int field439;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -2075667561
   )
   static int field440;
   @ObfuscatedName("aw")
   static boolean field441 = false;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -1620874883
   )
   static int field442;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 896323235
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("ig")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 708344221
   )
   static int field445;
   @ObfuscatedName("jt")
   static boolean field446;
   @ObfuscatedName("ot")
   static short field447;
   @ObfuscatedName("kv")
   static int[] field448;
   @ObfuscatedName("aq")
   static boolean field449 = true;
   @ObfuscatedName("ja")
   static Widget field450;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1419328929
   )
   static int field451;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 1462062387
   )
   static int field452;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1160915299
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("jw")
   static Widget field454;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -403133701
   )
   static int field455;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -1536827439
   )
   static int field456;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -392295299
   )
   static int field457;
   @ObfuscatedName("jg")
   static boolean field458;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 623053527
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("jq")
   static boolean field460;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = 726952485
   )
   static int field461;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -2038051229
   )
   static int field462;
   @ObfuscatedName("pu")
   static int[] field463;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -979570725
   )
   static int field464;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -1989615993
   )
   static int field465;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -1607931999
   )
   static int field466;
   @ObfuscatedName("jp")
   static Widget field467;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -1159068381
   )
   static int field468;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 2061928861
   )
   static int field469;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 1161731505
   )
   static int field470;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 355374533
   )
   static int field471;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 1012417049
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("np")
   static int[] field473;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -1241718815
   )
   static int field474;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 192664823
   )
   static int field475;
   @ObfuscatedName("kh")
   static Deque field476;
   @ObfuscatedName("kp")
   static Deque field477;
   @ObfuscatedName("kc")
   static Deque field478;
   @ObfuscatedName("kn")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1597982293
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1583271981
   )
   static int field481;
   @ObfuscatedName("kb")
   static boolean[] field482;
   @ObfuscatedName("ld")
   static boolean[] field483;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      longValue = -7426092762545355445L
   )
   static long field484;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -1441149161
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("je")
   static boolean field486;
   @ObfuscatedName("lb")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("le")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = 1483469743
   )
   static int field489;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 1204745371
   )
   static int field490;
   @ObfuscatedName("li")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1943300381
   )
   static int field492;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = -380058779
   )
   static int field493;
   @ObfuscatedName("fj")
   static boolean field494;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1728170975
   )
   static int field495;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1254265229
   )
   static int field496;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1972940245
   )
   static int field497;
   @ObfuscatedName("lc")
   static int[] field498;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -1708998135
   )
   static int field499;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 1481222277
   )
   static int field500;
   @ObfuscatedName("lh")
   static int[] field501;
   @ObfuscatedName("mt")
   static int[] field502;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -391633801
   )
   static int field503;
   @ObfuscatedName("go")
   static boolean field504;
   @ObfuscatedName("mx")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 975405725
   )
   static int field506;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -671373
   )
   static int field507;
   @ObfuscatedName("mh")
   static int[] field508;
   @ObfuscatedName("mr")
   static int[] field509;
   @ObfuscatedName("me")
   static SpritePixels[] field510;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = -2089549517
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -1247560065
   )
   static int field512;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = -1810842221
   )
   static int field514;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 1431821619
   )
   static int field515;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 1346817533
   )
   static int field516;
   @ObfuscatedName("mw")
   static boolean field517;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -1842646115
   )
   static int field518;
   @ObfuscatedName("fz")
   static int[] field519;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1273935027
   )
   static int field520;
   @ObfuscatedName("oj")
   static short field521;
   @ObfuscatedName("nf")
   static int[] field522;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -1853127321
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("nr")
   static int[] field524;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1987264543
   )
   static int field525;
   @ObfuscatedName("nv")
   static boolean field526;
   @ObfuscatedName("nn")
   static boolean[] field527;
   @ObfuscatedName("oc")
   static int[] field528;
   @ObfuscatedName("on")
   static int[] field529;
   @ObfuscatedName("pq")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("ov")
   static int[] field531;
   @ObfuscatedName("pk")
   static int[] field532;
   @ObfuscatedName("nl")
   static int[] field533;
   @ObfuscatedName("oa")
   static short field534;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1960296863
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("lt")
   static boolean[] field536;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -1088933037
   )
   static int field537;
   @ObfuscatedName("ou")
   static short field538;
   @ObfuscatedName("ok")
   static short field539;
   @ObfuscatedName("di")
   static final int[] field540;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -1018806155
   )
   static int field541;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 738876445
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -353404483
   )
   static int field543;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 1049381493
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 682116495
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1258124741
   )
   static int field546;
   @ObfuscatedName("ob")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("dz")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("r")
   static boolean field549 = true;
   @ObfuscatedName("op")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("oq")
   static PlayerComposition field551;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -836664231
   )
   static int field552;
   @ObfuscatedName("ir")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ct")
   static int[] field554;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -905014383
   )
   static int field555;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      longValue = -2937124903389650631L
   )
   static long field556;
   @ObfuscatedName("pv")
   static final class22 field557;
   @ObfuscatedName("lo")
   static long[] field558;
   @ObfuscatedName("lw")
   static String field559;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 2100719599
   )
   static int field561;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1583108828"
   )
   protected final void vmethod2109() {
   }

   public final void init() {
      if(this.method2169()) {
         class214[] var1 = class172.method3249();

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            class214 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3151);
            if(var4 != null) {
               class178[] var7;
               int var8;
               switch(Integer.parseInt(var3.field3151)) {
               case 1:
                  class20.field214 = var4;
                  continue;
               case 2:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  continue;
               case 3:
                  class103.field1685 = Integer.parseInt(var4);
                  continue;
               case 4:
                  class1.field12 = var4;
                  continue;
               case 5:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  continue;
               case 6:
                  class179[] var18 = new class179[]{class179.field2679, class179.field2674, class179.field2670, class179.field2680, class179.field2676, class179.field2672};
                  MessageNode.field229 = (class179)CombatInfoListHolder.method732(var18, Integer.parseInt(var4));
                  if(MessageNode.field229 == class179.field2674) {
                     field282 = class228.field3239;
                  } else {
                     field282 = class228.field3241;
                  }
                  continue;
               case 7:
                  world = Integer.parseInt(var4);
               case 8:
               case 11:
               case 13:
               default:
                  continue;
               case 9:
                  field285 = Integer.parseInt(var4);
                  continue;
               case 10:
                  class206.field3084 = Integer.parseInt(var4);
                  continue;
               case 12:
                  flags = Integer.parseInt(var4);
                  continue;
               case 14:
                  field281 = Integer.parseInt(var4);
                  continue;
               case 15:
                  var6 = Integer.parseInt(var4);
                  var7 = FileOnDisk.method1438();
                  var8 = 0;
               }

               class178 var5;
               while(true) {
                  if(var8 >= var7.length) {
                     var5 = null;
                     break;
                  }

                  class178 var9 = var7[var8];
                  if(var6 == var9.field2660) {
                     var5 = var9;
                     break;
                  }

                  ++var8;
               }

               class16.field170 = var5;
            }
         }

         class45.method826();
         class10.host = this.getCodeBase().getHost();
         String var15 = class16.field170.field2664;
         byte var16 = 0;

         try {
            WidgetNode.field177 = 16;
            class104.field1692 = var16;

            try {
               class155.field2207 = System.getProperty("os.name");
            } catch (Exception var13) {
               class155.field2207 = "Unknown";
            }

            FileOnDisk.field1195 = class155.field2207.toLowerCase();

            try {
               ChatLineBuffer.field968 = System.getProperty("user.home");
               if(null != ChatLineBuffer.field968) {
                  ChatLineBuffer.field968 = ChatLineBuffer.field968 + "/";
               }
            } catch (Exception var12) {
               ;
            }

            try {
               if(FileOnDisk.field1195.startsWith("win")) {
                  if(null == ChatLineBuffer.field968) {
                     ChatLineBuffer.field968 = System.getenv("USERPROFILE");
                  }
               } else if(ChatLineBuffer.field968 == null) {
                  ChatLineBuffer.field968 = System.getenv("HOME");
               }

               if(ChatLineBuffer.field968 != null) {
                  ChatLineBuffer.field968 = ChatLineBuffer.field968 + "/";
               }
            } catch (Exception var11) {
               ;
            }

            if(null == ChatLineBuffer.field968) {
               ChatLineBuffer.field968 = "~/";
            }

            FileOnDisk.field1198 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", ChatLineBuffer.field968, "/tmp/", ""};
            class104.field1697 = new String[]{".jagex_cache_" + class104.field1692, ".file_store_" + class104.field1692};

            int var10;
            label119:
            for(var10 = 0; var10 < 4; ++var10) {
               class231.field3282 = class37.method758("oldschool", var15, var10);
               if(!class231.field3282.exists()) {
                  class231.field3282.mkdirs();
               }

               File[] var17 = class231.field3282.listFiles();
               if(null == var17) {
                  break;
               }

               File[] var19 = var17;
               var6 = 0;

               while(true) {
                  if(var6 >= var19.length) {
                     break label119;
                  }

                  File var20 = var19[var6];
                  if(!CombatInfo1.method650(var20, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            class186.method3419(class231.field3282);
            class196.method3589();
            class104.field1694 = new class72(new FileOnDisk(class103.method1970("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class104.field1695 = new class72(new FileOnDisk(class103.method1970("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            XItemContainer.field120 = new class72[WidgetNode.field177];

            for(var10 = 0; var10 < WidgetNode.field177; ++var10) {
               XItemContainer.field120[var10] = new class72(new FileOnDisk(class103.method1970("main_file_cache.idx" + var10), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var14) {
            class32.method709((String)null, var14);
         }

         field277 = this;
         this.method2093(765, 503, 133);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1373799363"
   )
   protected final void vmethod2142() {
      class157.field2216 = field281 == 0?'ꩊ':'鱀' + world;
      class6.field54 = field281 == 0?443:world + '썐';
      field492 = class157.field2216;
      PlayerComposition.field2020 = class148.field2031;
      class101.field1661 = class148.field2029;
      class227.field3231 = class148.field2030;
      class167.field2307 = class148.field2034;
      if(class103.field1687.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1721[186] = 57;
         class105.field1721[187] = 27;
         class105.field1721[188] = 71;
         class105.field1721[189] = 26;
         class105.field1721[190] = 72;
         class105.field1721[191] = 73;
         class105.field1721[192] = 58;
         class105.field1721[219] = 42;
         class105.field1721[220] = 74;
         class105.field1721[221] = 43;
         class105.field1721[222] = 59;
         class105.field1721[223] = 28;
      } else {
         class105.field1721[44] = 71;
         class105.field1721[45] = 26;
         class105.field1721[46] = 72;
         class105.field1721[47] = 73;
         class105.field1721[59] = 57;
         class105.field1721[61] = 27;
         class105.field1721[91] = 42;
         class105.field1721[92] = 74;
         class105.field1721[93] = 43;
         class105.field1721[192] = 28;
         class105.field1721[222] = 58;
         class105.field1721[520] = 59;
      }

      Canvas var1 = class32.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class105.keyboard);
      var1.addFocusListener(class105.keyboard);
      FrameMap.method1704(class32.canvas);

      class106 var2;
      try {
         var2 = new class106();
      } catch (Throwable var8) {
         var2 = null;
      }

      class8.field76 = var2;
      if(null != class8.field76) {
         class8.field76.vmethod2079(class32.canvas);
      }

      class103.field1684 = new class116(255, class104.field1694, class104.field1695, 500000);
      class85.field1456 = Overlay.method3741();
      MessageNode.field233 = this.getToolkit().getSystemClipboard();
      String var4 = class31.field707;
      class114.field1792 = this;
      class114.field1785 = var4;
      if(field281 != 0) {
         field441 = true;
      }

      int var5 = class85.field1456.field684;
      field484 = 0L;
      if(var5 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      ChatLineBuffer.method912();
      if(gameState >= 25) {
         field321.method3195(245);
         class166 var6 = field321;
         int var7 = isResized?2:1;
         var6.method2912(var7);
         field321.method3094(XItemContainer.field123);
         field321.method3094(class143.field1999);
      }

      GameEngine.field1776 = true;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   protected final void vmethod2105() {
      boolean var1;
      label349: {
         try {
            if(class138.field1910 == 2) {
               if(class138.field1913 == null) {
                  class138.field1913 = class144.method2714(class1.field10, class138.field1915, ChatLineBuffer.field971);
                  if(null == class138.field1913) {
                     var1 = false;
                     break label349;
                  }
               }

               if(null == PlayerComposition.field2024) {
                  PlayerComposition.field2024 = new class60(class138.field1908, class138.field1911);
               }

               if(class138.field1906.method2500(class138.field1913, class138.field1909, PlayerComposition.field2024, 22050)) {
                  class138.field1906.method2606();
                  class138.field1906.method2468(class97.field1631);
                  class138.field1906.method2473(class138.field1913, class138.field1912);
                  class138.field1910 = 0;
                  class138.field1913 = null;
                  PlayerComposition.field2024 = null;
                  class1.field10 = null;
                  var1 = true;
                  break label349;
               }
            }
         } catch (Exception var22) {
            var22.printStackTrace();
            class138.field1906.method2474();
            class138.field1910 = 0;
            class138.field1913 = null;
            PlayerComposition.field2024 = null;
            class1.field10 = null;
         }

         var1 = false;
      }

      if(var1 && field517 && null != class139.field1944) {
         class139.field1944.method1068();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field484 && class22.method224() > field484) {
            int var3 = isResized?2:1;
            class36.method748(var3);
         } else if(GameEngine.field1782) {
            class26.method623();
         }
      }

      Dimension var17 = this.method2108();
      if(var17.width != class9.field84 || var17.height != class60.field1084 || GameEngine.field1778) {
         ChatLineBuffer.method912();
         field484 = class22.method224() + 500L;
         GameEngine.field1778 = false;
      }

      boolean var4 = false;
      int var5;
      if(GameEngine.field1776) {
         GameEngine.field1776 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field482[var5] = true;
         }
      }

      if(var4) {
         ChatMessages.method844();
      }

      int var6;
      if(gameState == 0) {
         TextureProvider.method1465(class41.field849, class41.field839, (Color)null, var4);
      } else if(gameState == 5) {
         CombatInfo1.method649(class16.field176, class41.field855, class49.field961, var4);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            CombatInfo1.method649(class16.field176, class41.field855, class49.field961, var4);
         } else if(gameState == 25) {
            if(field337 == 1) {
               if(field279 > field334) {
                  field334 = field279;
               }

               var5 = (field334 * 50 - field279 * 50) / field334;
               class101.method1940("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field337 == 2) {
               if(field335 > field465) {
                  field465 = field335;
               }

               var5 = (field465 * 50 - field335 * 50) / field465 + 50;
               class101.method1940("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class101.method1940("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            if(widgetRoot != -1) {
               class39.method767(widgetRoot);
            }

            for(var5 = 0; var5 < field288; ++var5) {
               if(field482[var5]) {
                  field483[var5] = true;
               }

               field536[var5] = field482[var5];
               field482[var5] = false;
            }

            field481 = gameCycle;
            field424 = -1;
            field425 = -1;
            class212.field3114 = null;
            if(widgetRoot != -1) {
               field288 = 0;
               class105.method2013(widgetRoot, 0, 0, XItemContainer.field123, class143.field1999, 0, 0, -1);
            }

            Rasterizer2D.method3972();
            if(!isMenuOpen) {
               if(field424 != -1) {
                  class5.method74(field424, field425);
               }
            } else {
               class99.method1927();
            }

            if(field489 == 3) {
               for(var5 = 0; var5 < field288; ++var5) {
                  if(field536[var5]) {
                     Rasterizer2D.method3978(widgetPositionX[var5], widgetPositionY[var5], widgetBoundsWidth[var5], widgetBoundsHeight[var5], 16711935, 128);
                  } else if(field483[var5]) {
                     Rasterizer2D.method3978(widgetPositionX[var5], widgetPositionY[var5], widgetBoundsWidth[var5], widgetBoundsHeight[var5], 16711680, 128);
                  }
               }
            }

            var5 = class48.plane;
            var6 = VertexNormal.localPlayer.x;
            int var7 = VertexNormal.localPlayer.y;
            int var8 = field354;

            for(class31 var9 = (class31)class31.field693.method2403(); var9 != null; var9 = (class31)class31.field693.method2398()) {
               if(var9.field694 != -1 || null != var9.field695) {
                  int var10 = 0;
                  if(var6 > var9.field696) {
                     var10 += var6 - var9.field696;
                  } else if(var6 < var9.field699) {
                     var10 += var9.field699 - var6;
                  }

                  if(var7 > var9.field704) {
                     var10 += var7 - var9.field704;
                  } else if(var7 < var9.field692) {
                     var10 += var9.field692 - var7;
                  }

                  if(var10 - 64 <= var9.field698 && field512 != 0 && var5 == var9.field703) {
                     var10 -= 64;
                     if(var10 < 0) {
                        var10 = 0;
                     }

                     int var11 = (var9.field698 - var10) * field512 / var9.field698;
                     Object var10000;
                     if(null == var9.field700) {
                        if(var9.field694 >= 0) {
                           var10000 = null;
                           class53 var12 = class53.method986(Friend.field152, var9.field694, 0);
                           if(var12 != null) {
                              class55 var13 = var12.method980().method1026(class22.field237);
                              class66 var14 = class66.method1304(var13, 100, var11);
                              var14.method1196(-1);
                              class164.field2290.method918(var14);
                              var9.field700 = var14;
                           }
                        }
                     } else {
                        var9.field700.method1197(var11);
                     }

                     if(null == var9.field705) {
                        if(null != var9.field695 && (var9.field697 -= var8) <= 0) {
                           int var18 = (int)(Math.random() * (double)var9.field695.length);
                           var10000 = null;
                           class53 var23 = class53.method986(Friend.field152, var9.field695[var18], 0);
                           if(var23 != null) {
                              class55 var24 = var23.method980().method1026(class22.field237);
                              class66 var15 = class66.method1304(var24, 100, var11);
                              var15.method1196(0);
                              class164.field2290.method918(var15);
                              var9.field705 = var15;
                              var9.field697 = var9.field701 + (int)(Math.random() * (double)(var9.field702 - var9.field701));
                           }
                        }
                     } else {
                        var9.field705.method1197(var11);
                        if(!var9.field705.linked()) {
                           var9.field705 = null;
                        }
                     }
                  } else {
                     if(null != var9.field700) {
                        class164.field2290.method919(var9.field700);
                        var9.field700 = null;
                     }

                     if(null != var9.field705) {
                        class164.field2290.method919(var9.field705);
                        var9.field705 = null;
                     }
                  }
               }
            }

            field354 = 0;
         } else if(gameState == 40) {
            class101.method1940("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class101.method1940("Please wait...", false);
         }
      } else {
         CombatInfo1.method649(class16.field176, class41.field855, class49.field961, var4);
      }

      Graphics var19;
      if(gameState == 30 && field489 == 0 && !var4) {
         try {
            var19 = class32.canvas.getGraphics();

            for(var6 = 0; var6 < field288; ++var6) {
               if(field483[var6]) {
                  class13.bufferProvider.drawSub(var19, widgetPositionX[var6], widgetPositionY[var6], widgetBoundsWidth[var6], widgetBoundsHeight[var6]);
                  field483[var6] = false;
               }
            }
         } catch (Exception var21) {
            class32.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var19 = class32.canvas.getGraphics();
            class13.bufferProvider.draw(var19, 0, 0);

            for(var6 = 0; var6 < field288; ++var6) {
               field483[var6] = false;
            }
         } catch (Exception var20) {
            class32.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1807889947"
   )
   void method272(int var1) {
      class16.field174 = null;
      XGrandExchangeOffer.field44 = null;
      field355 = 0;
      if(field492 == class157.field2216) {
         field492 = class6.field54;
      } else {
         field492 = class157.field2216;
      }

      ++field310;
      if(field310 < 2 || var1 != 7 && var1 != 9) {
         if(field310 >= 2 && var1 == 6) {
            this.method2107("js5connect_outofdate");
            gameState = 1000;
         } else if(field310 >= 4) {
            if(gameState <= 5) {
               this.method2107("js5connect");
               gameState = 1000;
            } else {
               field308 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2107("js5connect_full");
         gameState = 1000;
      } else {
         field308 = 3000;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-690063341"
   )
   protected final void packetHandler() {
      ++gameCycle;
      this.method463();
      class88.method1873();

      int var1;
      try {
         if(class138.field1910 == 1) {
            var1 = class138.field1906.method2598();
            if(var1 > 0 && class138.field1906.method2475()) {
               var1 -= class15.field165;
               if(var1 < 0) {
                  var1 = 0;
               }

               class138.field1906.method2468(var1);
            } else {
               class138.field1906.method2474();
               class138.field1906.method2472();
               if(class1.field10 != null) {
                  class138.field1910 = 2;
               } else {
                  class138.field1910 = 0;
               }

               class138.field1913 = null;
               PlayerComposition.field2024 = null;
            }
         }
      } catch (Exception var30) {
         var30.printStackTrace();
         class138.field1906.method2474();
         class138.field1910 = 0;
         class138.field1913 = null;
         PlayerComposition.field2024 = null;
         class1.field10 = null;
      }

      class3.method33();
      class94.method1902();
      XClanMember.method261();
      if(class8.field76 != null) {
         var1 = class8.field76.vmethod2080();
         field475 = var1;
      }

      if(gameState == 0) {
         class189.method3454();
         Spotanim.method3457();
      } else if(gameState == 5) {
         class38.method763(this);
         class189.method3454();
         Spotanim.method3457();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class38.method763(this);
            class31.method703();
         } else if(gameState == 25) {
            class85.method1701();
         }
      } else {
         class38.method763(this);
      }

      if(gameState == 30) {
         if(field325 > 1) {
            --field325;
         }

         if(field331 > 0) {
            --field331;
         }

         if(field332) {
            field332 = false;
            class1.method16();
         } else {
            if(!isMenuOpen) {
               menuOptions[0] = "Cancel";
               menuTargets[0] = "";
               menuTypes[0] = 1006;
               menuOptionCount = 1;
            }

            for(var1 = 0; var1 < 100 && TextureProvider.method1462(); ++var1) {
               ;
            }

            if(gameState == 30) {
               while(true) {
                  ClassInfo var2 = (ClassInfo)class227.field3232.method2351();
                  boolean var33;
                  if(var2 == null) {
                     var33 = false;
                  } else {
                     var33 = true;
                  }

                  int var15;
                  if(!var33) {
                     Object var14 = WallObject.field1557.field210;
                     int var3;
                     int var4;
                     int var5;
                     int var6;
                     int var7;
                     int var8;
                     int var9;
                     synchronized(WallObject.field1557.field210) {
                        if(!field549) {
                           WallObject.field1557.field211 = 0;
                        } else if(class115.field1804 != 0 || WallObject.field1557.field211 >= 40) {
                           field321.method3195(156);
                           field321.method2912(0);
                           var15 = field321.offset;
                           var3 = 0;

                           for(var4 = 0; var4 < WallObject.field1557.field211 && field321.offset - var15 < 240; ++var4) {
                              ++var3;
                              var5 = WallObject.field1557.field218[var4];
                              if(var5 < 0) {
                                 var5 = 0;
                              } else if(var5 > 502) {
                                 var5 = 502;
                              }

                              var6 = WallObject.field1557.field212[var4];
                              if(var6 < 0) {
                                 var6 = 0;
                              } else if(var6 > 764) {
                                 var6 = 764;
                              }

                              var7 = var6 + 765 * var5;
                              if(WallObject.field1557.field218[var4] == -1 && WallObject.field1557.field212[var4] == -1) {
                                 var6 = -1;
                                 var5 = -1;
                                 var7 = 524287;
                              }

                              if(var6 == field290 && var5 == field291) {
                                 if(field365 < 2047) {
                                    ++field365;
                                 }
                              } else {
                                 var8 = var6 - field290;
                                 field290 = var6;
                                 var9 = var5 - field291;
                                 field291 = var5;
                                 if(field365 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                    var8 += 32;
                                    var9 += 32;
                                    field321.method3094(var9 + (field365 << 12) + (var8 << 6));
                                    field365 = 0;
                                 } else if(field365 < 8) {
                                    field321.method2914(var7 + (field365 << 19) + 8388608);
                                    field365 = 0;
                                 } else {
                                    field321.method3057(-1073741824 + (field365 << 19) + var7);
                                    field365 = 0;
                                 }
                              }
                           }

                           field321.method2924(field321.offset - var15);
                           if(var3 >= WallObject.field1557.field211) {
                              WallObject.field1557.field211 = 0;
                           } else {
                              WallObject.field1557.field211 -= var3;

                              for(var4 = 0; var4 < WallObject.field1557.field211; ++var4) {
                                 WallObject.field1557.field212[var4] = WallObject.field1557.field212[var3 + var4];
                                 WallObject.field1557.field218[var4] = WallObject.field1557.field218[var3 + var4];
                              }
                           }
                        }
                     }

                     if(class115.field1804 == 1 || !class115.field1809 && class115.field1804 == 4 || class115.field1804 == 2) {
                        long var16 = (class115.field1806 - field289) / 50L;
                        if(var16 > 4095L) {
                           var16 = 4095L;
                        }

                        field289 = class115.field1806;
                        var3 = class115.field1807;
                        if(var3 < 0) {
                           var3 = 0;
                        } else if(var3 > class143.field1999) {
                           var3 = class143.field1999;
                        }

                        var4 = class115.field1800;
                        if(var4 < 0) {
                           var4 = 0;
                        } else if(var4 > XItemContainer.field123) {
                           var4 = XItemContainer.field123;
                        }

                        var5 = (int)var16;
                        field321.method3195(87);
                        field321.method3094((var5 << 1) + (class115.field1804 == 2?1:0));
                        field321.method3094(var4);
                        field321.method3094(var3);
                     }

                     if(class105.field1716 > 0) {
                        field321.method3195(82);
                        field321.method3094(0);
                        var1 = field321.offset;
                        long var18 = class22.method224();

                        for(var4 = 0; var4 < class105.field1716; ++var4) {
                           long var20 = var18 - field336;
                           if(var20 > 16777215L) {
                              var20 = 16777215L;
                           }

                           field336 = var18;
                           field321.method2967((int)var20);
                           field321.method2912(class105.field1715[var4]);
                        }

                        field321.method3056(field321.offset - var1);
                     }

                     if(field506 > 0) {
                        --field506;
                     }

                     if(class105.field1712[96] || class105.field1712[97] || class105.field1712[98] || class105.field1712[99]) {
                        field494 = true;
                     }

                     if(field494 && field506 <= 0) {
                        field506 = 20;
                        field494 = false;
                        field321.method3195(7);
                        field321.method3094(mapAngle);
                        field321.method2961(field361);
                     }

                     if(class97.field1630 && !field449) {
                        field449 = true;
                        field321.method3195(52);
                        field321.method2912(1);
                     }

                     if(!class97.field1630 && field449) {
                        field449 = false;
                        field321.method3195(52);
                        field321.method2912(0);
                     }

                     if(field382 != class48.plane) {
                        field382 = class48.plane;
                        class173.method3252(class48.plane);
                     }

                     if(gameState == 30) {
                        class175.method3253();
                        class60.method1156();
                        ++field326;
                        if(field326 > 750) {
                           class1.method16();
                        } else {
                           var1 = class45.field901;
                           int[] var31 = class45.field902;

                           for(var3 = 0; var3 < var1; ++var3) {
                              Player var22 = cachedPlayers[var31[var3]];
                              if(var22 != null) {
                                 class72.method1396(var22, 1);
                              }
                           }

                           for(var1 = 0; var1 < field317; ++var1) {
                              var15 = field554[var1];
                              NPC var23 = cachedNPCs[var15];
                              if(null != var23) {
                                 class72.method1396(var23, var23.composition.field2987);
                              }
                           }

                           GameObject.method1910();
                           ++field354;
                           if(field520 != 0) {
                              field464 += 20;
                              if(field464 >= 400) {
                                 field520 = 0;
                              }
                           }

                           if(null != class31.field708) {
                              ++field389;
                              if(field389 >= 15) {
                                 class2.method28(class31.field708);
                                 class31.field708 = null;
                              }
                           }

                           Widget var36 = class138.field1907;
                           Widget var32 = class137.field1893;
                           class138.field1907 = null;
                           class137.field1893 = null;
                           field454 = null;
                           field458 = false;
                           field388 = false;
                           field500 = 0;

                           while(true) {
                              while(class205.method3821() && field500 < 128) {
                                 if(field396 >= 2 && class105.field1712[82] && class44.field893 == 66) {
                                    String var38 = class162.method3142();
                                    MessageNode.field233.setContents(new StringSelection(var38), (ClipboardOwner)null);
                                 } else {
                                    field502[field500] = class44.field893;
                                    field501[field500] = XClanMember.field273;
                                    ++field500;
                                 }
                              }

                              if(widgetRoot != -1) {
                                 class7.method112(widgetRoot, 0, 0, XItemContainer.field123, class143.field1999, 0, 0);
                              }

                              ++field462;

                              while(true) {
                                 Widget var24;
                                 Widget var37;
                                 class18 var39;
                                 do {
                                    var39 = (class18)field477.method2383();
                                    if(null == var39) {
                                       while(true) {
                                          do {
                                             var39 = (class18)field478.method2383();
                                             if(var39 == null) {
                                                while(true) {
                                                   do {
                                                      var39 = (class18)field476.method2383();
                                                      if(null == var39) {
                                                         method608();
                                                         int var11;
                                                         int var25;
                                                         if(null == class178.field2665 && field450 == null) {
                                                            var3 = class115.field1804;
                                                            if(isMenuOpen) {
                                                               if(var3 != 1 && (class115.field1809 || var3 != 4)) {
                                                                  var4 = class115.field1799;
                                                                  var5 = class115.field1794;
                                                                  if(var4 < class161.menuX - 10 || var4 > class161.menuX + class99.menuWidth + 10 || var5 < class217.menuY - 10 || var5 > class18.menuHeight + class217.menuY + 10) {
                                                                     isMenuOpen = false;
                                                                     class45.method837(class161.menuX, class217.menuY, class99.menuWidth, class18.menuHeight);
                                                                  }
                                                               }

                                                               if(var3 == 1 || !class115.field1809 && var3 == 4) {
                                                                  var4 = class161.menuX;
                                                                  var5 = class217.menuY;
                                                                  var6 = class99.menuWidth;
                                                                  var7 = class115.field1800;
                                                                  var8 = class115.field1807;
                                                                  var9 = -1;

                                                                  for(var25 = 0; var25 < menuOptionCount; ++var25) {
                                                                     var11 = var5 + 31 + (menuOptionCount - 1 - var25) * 15;
                                                                     if(var7 > var4 && var7 < var4 + var6 && var8 > var11 - 13 && var8 < var11 + 3) {
                                                                        var9 = var25;
                                                                     }
                                                                  }

                                                                  if(var9 != -1) {
                                                                     class63.method1173(var9);
                                                                  }

                                                                  isMenuOpen = false;
                                                                  class45.method837(class161.menuX, class217.menuY, class99.menuWidth, class18.menuHeight);
                                                               }
                                                            } else {
                                                               label1216: {
                                                                  label1248: {
                                                                     if((var3 == 1 || !class115.field1809 && var3 == 4) && menuOptionCount > 0) {
                                                                        var4 = menuTypes[menuOptionCount - 1];
                                                                        if(var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                                                                           var5 = menuActionParams0[menuOptionCount - 1];
                                                                           var6 = menuActionParams1[menuOptionCount - 1];
                                                                           Widget var26 = class37.method759(var6);
                                                                           var9 = class88.method1872(var26);
                                                                           boolean var35 = (var9 >> 28 & 1) != 0;
                                                                           if(var35) {
                                                                              break label1248;
                                                                           }

                                                                           Object var10000 = null;
                                                                           if(class30.method695(class88.method1872(var26))) {
                                                                              break label1248;
                                                                           }
                                                                        }
                                                                     }

                                                                     if((var3 == 1 || !class115.field1809 && var3 == 4) && (field543 == 1 && menuOptionCount > 2 || class16.method198(menuOptionCount - 1))) {
                                                                        var3 = 2;
                                                                     }

                                                                     if((var3 == 1 || !class115.field1809 && var3 == 4) && menuOptionCount > 0) {
                                                                        class63.method1173(menuOptionCount - 1);
                                                                     }

                                                                     if(var3 == 2 && menuOptionCount > 0) {
                                                                        Actor.method643(class115.field1800, class115.field1807);
                                                                     }
                                                                     break label1216;
                                                                  }

                                                                  if(null != class178.field2665 && !field504 && field543 != 1 && !class16.method198(menuOptionCount - 1) && menuOptionCount > 0) {
                                                                     var25 = field392;
                                                                     var11 = field497;
                                                                     class38 var12 = Friend.field158;
                                                                     class0.menuAction(var12.field796, var12.field791, var12.field792, var12.field793, var12.field790, var12.field790, var25, var11);
                                                                     Friend.field158 = null;
                                                                  }

                                                                  field504 = false;
                                                                  field395 = 0;
                                                                  if(null != class178.field2665) {
                                                                     class2.method28(class178.field2665);
                                                                  }

                                                                  class178.field2665 = class37.method759(var6);
                                                                  field391 = var5;
                                                                  field392 = class115.field1800;
                                                                  field497 = class115.field1807;
                                                                  if(menuOptionCount > 0) {
                                                                     XGrandExchangeOffer.method70(menuOptionCount - 1);
                                                                  }

                                                                  class2.method28(class178.field2665);
                                                               }
                                                            }
                                                         }

                                                         if(field450 != null) {
                                                            class45.method839();
                                                         }

                                                         if(class178.field2665 != null) {
                                                            class2.method28(class178.field2665);
                                                            ++field395;
                                                            if(class115.field1805 != 0) {
                                                               if(field395 >= 5 && (class115.field1799 > 5 + field392 || class115.field1799 < field392 - 5 || class115.field1794 > 5 + field497 || class115.field1794 < field497 - 5)) {
                                                                  field504 = true;
                                                               }
                                                            } else {
                                                               if(field504) {
                                                                  if(class178.field2665 == class212.field3114 && field381 != field391) {
                                                                     Widget var40 = class178.field2665;
                                                                     byte var34 = 0;
                                                                     if(field440 == 1 && var40.contentType == 206) {
                                                                        var34 = 1;
                                                                     }

                                                                     if(var40.itemIds[field381] <= 0) {
                                                                        var34 = 0;
                                                                     }

                                                                     if(class30.method695(class88.method1872(var40))) {
                                                                        var5 = field391;
                                                                        var6 = field381;
                                                                        var40.itemIds[var6] = var40.itemIds[var5];
                                                                        var40.itemQuantities[var6] = var40.itemQuantities[var5];
                                                                        var40.itemIds[var5] = -1;
                                                                        var40.itemQuantities[var5] = 0;
                                                                     } else if(var34 == 1) {
                                                                        var5 = field391;
                                                                        var6 = field381;

                                                                        while(var6 != var5) {
                                                                           if(var5 > var6) {
                                                                              var40.method2783(var5 - 1, var5);
                                                                              --var5;
                                                                           } else if(var5 < var6) {
                                                                              var40.method2783(var5 + 1, var5);
                                                                              ++var5;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var40.method2783(field381, field391);
                                                                     }

                                                                     field321.method3195(105);
                                                                     field321.method2961(field391);
                                                                     field321.method2961(field381);
                                                                     field321.method3032(var34);
                                                                     field321.method2969(class178.field2665.id);
                                                                  }
                                                               } else if((field543 == 1 || class16.method198(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                                  Actor.method643(field392, field497);
                                                               } else if(menuOptionCount > 0) {
                                                                  var3 = field392;
                                                                  var4 = field497;
                                                                  class38 var41 = Friend.field158;
                                                                  class0.menuAction(var41.field796, var41.field791, var41.field792, var41.field793, var41.field790, var41.field790, var3, var4);
                                                                  Friend.field158 = null;
                                                               }

                                                               field389 = 10;
                                                               class115.field1804 = 0;
                                                               class178.field2665 = null;
                                                            }
                                                         }

                                                         if(Region.method1746()) {
                                                            var3 = Region.field1485;
                                                            var4 = Region.field1510;
                                                            field321.method3195(233);
                                                            field321.method2912(5);
                                                            field321.method2959(class114.baseX + var3);
                                                            field321.method3094(CombatInfo1.baseY + var4);
                                                            field321.method2952(class105.field1712[82]?(class105.field1712[81]?2:1):0);
                                                            Region.method1792();
                                                            field385 = class115.field1800;
                                                            field386 = class115.field1807;
                                                            field520 = 1;
                                                            field464 = 0;
                                                            flagX = var3;
                                                            flagY = var4;
                                                         }

                                                         if(var36 != class138.field1907) {
                                                            if(var36 != null) {
                                                               class2.method28(var36);
                                                            }

                                                            if(class138.field1907 != null) {
                                                               class2.method28(class138.field1907);
                                                            }
                                                         }

                                                         if(class137.field1893 != var32 && field455 == field426) {
                                                            if(null != var32) {
                                                               class2.method28(var32);
                                                            }

                                                            if(class137.field1893 != null) {
                                                               class2.method28(class137.field1893);
                                                            }
                                                         }

                                                         if(null != class137.field1893) {
                                                            if(field426 < field455) {
                                                               ++field426;
                                                               if(field426 == field455) {
                                                                  class2.method28(class137.field1893);
                                                               }
                                                            }
                                                         } else if(field426 > 0) {
                                                            --field426;
                                                         }

                                                         class6.method95();
                                                         if(field526) {
                                                            var3 = Item.field891 * 128 + 64;
                                                            var4 = VertexNormal.field1422 * 128 + 64;
                                                            var5 = Renderable.method1883(var3, var4, class48.plane) - Varbit.field2835;
                                                            if(class202.cameraX < var3) {
                                                               class202.cameraX += (var3 - class202.cameraX) * class22.field240 / 1000 + class162.field2282;
                                                               if(class202.cameraX > var3) {
                                                                  class202.cameraX = var3;
                                                               }
                                                            }

                                                            if(class202.cameraX > var3) {
                                                               class202.cameraX -= class162.field2282 + class22.field240 * (class202.cameraX - var3) / 1000;
                                                               if(class202.cameraX < var3) {
                                                                  class202.cameraX = var3;
                                                               }
                                                            }

                                                            if(class32.cameraZ < var5) {
                                                               class32.cameraZ += class22.field240 * (var5 - class32.cameraZ) / 1000 + class162.field2282;
                                                               if(class32.cameraZ > var5) {
                                                                  class32.cameraZ = var5;
                                                               }
                                                            }

                                                            if(class32.cameraZ > var5) {
                                                               class32.cameraZ -= class162.field2282 + (class32.cameraZ - var5) * class22.field240 / 1000;
                                                               if(class32.cameraZ < var5) {
                                                                  class32.cameraZ = var5;
                                                               }
                                                            }

                                                            if(class16.cameraY < var4) {
                                                               class16.cameraY += class22.field240 * (var4 - class16.cameraY) / 1000 + class162.field2282;
                                                               if(class16.cameraY > var4) {
                                                                  class16.cameraY = var4;
                                                               }
                                                            }

                                                            if(class16.cameraY > var4) {
                                                               class16.cameraY -= class22.field240 * (class16.cameraY - var4) / 1000 + class162.field2282;
                                                               if(class16.cameraY < var4) {
                                                                  class16.cameraY = var4;
                                                               }
                                                            }

                                                            var3 = class175.field2635 * 128 + 64;
                                                            var4 = 64 + class105.field1723 * 128;
                                                            var5 = Renderable.method1883(var3, var4, class48.plane) - Frames.field1569;
                                                            var6 = var3 - class202.cameraX;
                                                            var7 = var5 - class32.cameraZ;
                                                            var8 = var4 - class16.cameraY;
                                                            var9 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
                                                            var25 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                            var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                            if(var25 < 128) {
                                                               var25 = 128;
                                                            }

                                                            if(var25 > 383) {
                                                               var25 = 383;
                                                            }

                                                            if(FloorUnderlayDefinition.cameraPitch < var25) {
                                                               FloorUnderlayDefinition.cameraPitch += (var25 - FloorUnderlayDefinition.cameraPitch) * class49.field959 / 1000 + field399;
                                                               if(FloorUnderlayDefinition.cameraPitch > var25) {
                                                                  FloorUnderlayDefinition.cameraPitch = var25;
                                                               }
                                                            }

                                                            if(FloorUnderlayDefinition.cameraPitch > var25) {
                                                               FloorUnderlayDefinition.cameraPitch -= (FloorUnderlayDefinition.cameraPitch - var25) * class49.field959 / 1000 + field399;
                                                               if(FloorUnderlayDefinition.cameraPitch < var25) {
                                                                  FloorUnderlayDefinition.cameraPitch = var25;
                                                               }
                                                            }

                                                            int var27 = var11 - class3.cameraYaw;
                                                            if(var27 > 1024) {
                                                               var27 -= 2048;
                                                            }

                                                            if(var27 < -1024) {
                                                               var27 += 2048;
                                                            }

                                                            if(var27 > 0) {
                                                               class3.cameraYaw += field399 + class49.field959 * var27 / 1000;
                                                               class3.cameraYaw &= 2047;
                                                            }

                                                            if(var27 < 0) {
                                                               class3.cameraYaw -= class49.field959 * -var27 / 1000 + field399;
                                                               class3.cameraYaw &= 2047;
                                                            }

                                                            int var13 = var11 - class3.cameraYaw;
                                                            if(var13 > 1024) {
                                                               var13 -= 2048;
                                                            }

                                                            if(var13 < -1024) {
                                                               var13 += 2048;
                                                            }

                                                            if(var13 < 0 && var27 > 0 || var13 > 0 && var27 < 0) {
                                                               class3.cameraYaw = var11;
                                                            }
                                                         }

                                                         for(var3 = 0; var3 < 5; ++var3) {
                                                            ++field531[var3];
                                                         }

                                                         class45.chatMessages.method847();
                                                         var3 = ++class115.mouseIdleTicks - 1;
                                                         var5 = class105.keyboardIdleTicks;
                                                         if(var3 > 15000 && var5 > 15000) {
                                                            field331 = 250;
                                                            class115.mouseIdleTicks = 14500;
                                                            field321.method3195(216);
                                                         }

                                                         ++field421;
                                                         if(field421 > 500) {
                                                            field421 = 0;
                                                            var7 = (int)(Math.random() * 8.0D);
                                                            if((var7 & 1) == 1) {
                                                               field342 += field343;
                                                            }

                                                            if((var7 & 2) == 2) {
                                                               field442 += field345;
                                                            }

                                                            if((var7 & 4) == 4) {
                                                               field346 += field347;
                                                            }
                                                         }

                                                         if(field342 < -50) {
                                                            field343 = 2;
                                                         }

                                                         if(field342 > 50) {
                                                            field343 = -2;
                                                         }

                                                         if(field442 < -55) {
                                                            field345 = 2;
                                                         }

                                                         if(field442 > 55) {
                                                            field345 = -2;
                                                         }

                                                         if(field346 < -40) {
                                                            field347 = 1;
                                                         }

                                                         if(field346 > 40) {
                                                            field347 = -1;
                                                         }

                                                         ++field341;
                                                         if(field341 > 500) {
                                                            field341 = 0;
                                                            var7 = (int)(Math.random() * 8.0D);
                                                            if((var7 & 1) == 1) {
                                                               mapScale += field350;
                                                            }

                                                            if((var7 & 2) == 2) {
                                                               mapScaleDelta += field352;
                                                            }
                                                         }

                                                         if(mapScale < -60) {
                                                            field350 = 2;
                                                         }

                                                         if(mapScale > 60) {
                                                            field350 = -2;
                                                         }

                                                         if(mapScaleDelta < -20) {
                                                            field352 = 1;
                                                         }

                                                         if(mapScaleDelta > 10) {
                                                            field352 = -1;
                                                         }

                                                         for(class16 var42 = (class16)field409.method2417(); null != var42; var42 = (class16)field409.method2418()) {
                                                            if((long)var42.field173 < class22.method224() / 1000L - 5L) {
                                                               if(var42.field175 > 0) {
                                                                  ChatLineBuffer.sendGameMessage(5, "", var42.field167 + " has logged in.");
                                                               }

                                                               if(var42.field175 == 0) {
                                                                  ChatLineBuffer.sendGameMessage(5, "", var42.field167 + " has logged out.");
                                                               }

                                                               var42.method2426();
                                                            }
                                                         }

                                                         ++field327;
                                                         if(field327 > 50) {
                                                            field321.method3195(212);
                                                         }

                                                         try {
                                                            if(null != class177.field2657 && field321.offset > 0) {
                                                               class177.field2657.method2054(field321.payload, 0, field321.offset);
                                                               field321.offset = 0;
                                                               field327 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var28) {
                                                            class1.method16();
                                                         }

                                                         return;
                                                      }

                                                      var37 = var39.field190;
                                                      if(var37.index < 0) {
                                                         break;
                                                      }

                                                      var24 = class37.method759(var37.parentId);
                                                   } while(null == var24 || var24.children == null || var37.index >= var24.children.length || var24.children[var37.index] != var37);

                                                   class9.method118(var39);
                                                }
                                             }

                                             var37 = var39.field190;
                                             if(var37.index < 0) {
                                                break;
                                             }

                                             var24 = class37.method759(var37.parentId);
                                          } while(null == var24 || null == var24.children || var37.index >= var24.children.length || var37 != var24.children[var37.index]);

                                          class9.method118(var39);
                                       }
                                    }

                                    var37 = var39.field190;
                                    if(var37.index < 0) {
                                       break;
                                    }

                                    var24 = class37.method759(var37.parentId);
                                 } while(var24 == null || null == var24.children || var37.index >= var24.children.length || var37 != var24.children[var37.index]);

                                 class9.method118(var39);
                              }
                           }
                        }
                     }
                     break;
                  }

                  field321.method3195(5);
                  field321.method2912(0);
                  var15 = field321.offset;
                  class156.method2896(field321);
                  field321.method2924(field321.offset - var15);
               }
            }
         }
      } else if(gameState == 40 || gameState == 45) {
         class31.method703();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "118"
   )
   void method358() {
      if(class185.field2745 >= 4) {
         this.method2107("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2746 >= 4) {
            if(gameState <= 5) {
               this.method2107("js5io");
               gameState = 1000;
               return;
            }

            field308 = 3000;
            class185.field2746 = 3;
         }

         if(--field308 + 1 <= 0) {
            try {
               if(field355 == 0) {
                  class16.field174 = class63.field1093.method1944(class10.host, field492);
                  ++field355;
               }

               if(field355 == 1) {
                  if(class16.field174.field1667 == 2) {
                     this.method272(-1);
                     return;
                  }

                  if(class16.field174.field1667 == 1) {
                     ++field355;
                  }
               }

               if(field355 == 2) {
                  XGrandExchangeOffer.field44 = new class110((Socket)class16.field174.field1675, class63.field1093);
                  Buffer var1 = new Buffer(5);
                  var1.method2912(15);
                  var1.method3057(133);
                  XGrandExchangeOffer.field44.method2054(var1.payload, 0, 5);
                  ++field355;
                  FloorUnderlayDefinition.field2799 = class22.method224();
               }

               if(field355 == 3) {
                  if(gameState > 5 && XGrandExchangeOffer.field44.method2052() <= 0) {
                     if(class22.method224() - FloorUnderlayDefinition.field2799 > 30000L) {
                        this.method272(-2);
                        return;
                     }
                  } else {
                     int var5 = XGrandExchangeOffer.field44.method2049();
                     if(var5 != 0) {
                        this.method272(var5);
                        return;
                     }

                     ++field355;
                  }
               }

               if(field355 == 4) {
                  class110 var10 = XGrandExchangeOffer.field44;
                  boolean var2 = gameState > 20;
                  if(class185.field2748 != null) {
                     try {
                        class185.field2748.method2064();
                     } catch (Exception var8) {
                        ;
                     }

                     class185.field2748 = null;
                  }

                  class185.field2748 = var10;
                  Renderable.method1875(var2);
                  class185.field2744.offset = 0;
                  class112.field1762 = null;
                  CombatInfoListHolder.field749 = null;
                  class185.field2735 = 0;

                  while(true) {
                     class181 var3 = (class181)class185.field2733.method2334();
                     if(null == var3) {
                        while(true) {
                           var3 = (class181)class185.field2740.method2334();
                           if(null == var3) {
                              if(class185.field2728 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.method2912(4);
                                    var11.method2912(class185.field2728);
                                    var11.method3094(0);
                                    class185.field2748.method2054(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class185.field2748.method2064();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class185.field2746;
                                    class185.field2748 = null;
                                 }
                              }

                              class185.field2738 = 0;
                              class185.field2730 = class22.method224();
                              class16.field174 = null;
                              XGrandExchangeOffer.field44 = null;
                              field355 = 0;
                              field310 = 0;
                              return;
                           }

                           class185.field2729.method2290(var3);
                           class185.field2741.method2333(var3, var3.hash);
                           ++class185.field2731;
                           --class185.field2739;
                        }
                     }

                     class185.field2736.method2333(var3, var3.hash);
                     ++class185.field2732;
                     --class185.field2734;
                  }
               }
            } catch (IOException var9) {
               this.method272(-3);
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-941690739"
   )
   void method463() {
      if(gameState != 1000) {
         boolean var1 = class45.method838();
         if(!var1) {
            this.method358();
         }

      }
   }

   static {
      field304 = class40.field810;
      field305 = class40.field810;
      field294 = 0;
      field355 = 0;
      field308 = 0;
      field310 = 0;
      field546 = 0;
      field312 = 0;
      field313 = 0;
      field319 = 0;
      cachedNPCs = new NPC['耀'];
      field317 = 0;
      field554 = new int['耀'];
      field311 = 0;
      field320 = new int[250];
      field321 = new class166(5000);
      field322 = new class166(5000);
      field323 = new class166(15000);
      field324 = 0;
      packetOpcode = 0;
      field326 = 0;
      field327 = 0;
      field284 = 0;
      field329 = 0;
      field330 = 0;
      field331 = 0;
      field332 = false;
      field279 = 0;
      field334 = 1;
      field335 = 0;
      field465 = 1;
      field337 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field340 = new int[4][13][13];
      field540 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field342 = 0;
      field343 = 2;
      field442 = 0;
      field345 = 2;
      field346 = 0;
      field347 = 1;
      field421 = 0;
      mapScale = 0;
      field350 = 2;
      mapScaleDelta = 0;
      field352 = 1;
      field341 = 0;
      field354 = 0;
      field490 = 2301979;
      field356 = 5063219;
      field357 = 3353893;
      field358 = 7759444;
      field359 = false;
      field314 = 0;
      field361 = 128;
      mapAngle = 0;
      field363 = 0;
      field364 = 0;
      field306 = 0;
      field366 = 0;
      field367 = 50;
      field506 = 0;
      field494 = false;
      field370 = 0;
      field371 = 0;
      field372 = 50;
      field373 = new int[field372];
      field374 = new int[field372];
      field519 = new int[field372];
      field376 = new int[field372];
      field377 = new int[field372];
      field378 = new int[field372];
      field379 = new int[field372];
      field380 = new String[field372];
      field404 = new int[104][104];
      field451 = 0;
      field383 = -1;
      field384 = -1;
      field385 = 0;
      field386 = 0;
      field464 = 0;
      field520 = 0;
      field389 = 0;
      field390 = 0;
      field391 = 0;
      field392 = 0;
      field497 = 0;
      field381 = 0;
      field504 = false;
      field395 = 0;
      field397 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field503 = 0;
      field401 = 0;
      field402 = new int[1000];
      field418 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriority = new boolean[8];
      field406 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field407 = -1;
      groundItemDeque = new Deque[4][104][104];
      field300 = new Deque();
      projectiles = new Deque();
      field411 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field543 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field424 = -1;
      field425 = -1;
      field426 = 0;
      field455 = 50;
      field525 = 0;
      field431 = null;
      field432 = false;
      field433 = -1;
      field434 = -1;
      field435 = null;
      field436 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field439 = 0;
      field440 = 0;
      field309 = null;
      energy = 0;
      weight = 0;
      field396 = 0;
      field445 = -1;
      field446 = false;
      field486 = false;
      field394 = false;
      field467 = null;
      field450 = null;
      field420 = null;
      field452 = 0;
      field360 = 0;
      field454 = null;
      field388 = false;
      field456 = -1;
      field457 = -1;
      field458 = false;
      field375 = -1;
      field555 = -1;
      field460 = false;
      field462 = 1;
      field393 = new int[32];
      field561 = 0;
      interfaceItemTriggers = new int[32];
      field466 = 0;
      field448 = new int[32];
      field468 = 0;
      field469 = 0;
      field470 = 0;
      field471 = 0;
      field415 = 0;
      field293 = 0;
      field474 = 0;
      field475 = 0;
      field476 = new Deque();
      field477 = new Deque();
      field478 = new Deque();
      widgetFlags = new XHashTable(512);
      field288 = 0;
      field481 = -2;
      field482 = new boolean[100];
      field483 = new boolean[100];
      field536 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field489 = 0;
      field484 = 0L;
      isResized = true;
      field537 = 765;
      field493 = 503;
      field498 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field495 = 0;
      field496 = 0;
      field559 = "";
      field558 = new long[100];
      field499 = 0;
      field500 = 0;
      field501 = new int[128];
      field502 = new int[128];
      field336 = -1L;
      field299 = null;
      clanChatOwner = null;
      field382 = -1;
      field507 = 0;
      field508 = new int[1000];
      field509 = new int[1000];
      field510 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field514 = 0;
      field515 = 255;
      field516 = -1;
      field517 = false;
      field518 = 127;
      field512 = 127;
      field461 = 0;
      field473 = new int[50];
      field522 = new int[50];
      field533 = new int[50];
      field524 = new int[50];
      field400 = new class53[50];
      field526 = false;
      field527 = new boolean[5];
      field528 = new int[5];
      field529 = new int[5];
      field387 = new int[5];
      field531 = new int[5];
      field368 = 256;
      field292 = 205;
      field534 = 256;
      field521 = 320;
      field447 = 1;
      field412 = 32767;
      field538 = 1;
      field539 = 32767;
      field280 = 0;
      field541 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field333 = 0;
      friends = new Friend[400];
      field409 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field551 = new PlayerComposition();
      field552 = -1;
      field295 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field349 = -1L;
      field556 = -1L;
      field557 = new class22();
      field532 = new int[50];
      field463 = new int[50];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1010859480"
   )
   protected final void vmethod2106() {
      if(class45.chatMessages.method852()) {
         class45.chatMessages.method849();
      }

      if(null != WallObject.field1557) {
         WallObject.field1557.field215 = false;
      }

      WallObject.field1557 = null;
      if(class177.field2657 != null) {
         class177.field2657.method2064();
         class177.field2657 = null;
      }

      if(class105.keyboard != null) {
         class105 var1 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

      class7.method110();
      class8.field76 = null;
      if(class139.field1944 != null) {
         class139.field1944.method1060();
      }

      if(CombatInfoListHolder.field760 != null) {
         CombatInfoListHolder.field760.method1060();
      }

      class103.method1969();
      Object var7 = class183.field2712;
      synchronized(class183.field2712) {
         if(class183.field2715 != 0) {
            class183.field2715 = 1;

            try {
               class183.field2712.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      class109.method2047();
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1799868162"
   )
   static final void method608() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < menuOptionCount - 1; ++var1) {
            if(menuTypes[var1] < 1000 && menuTypes[var1 + 1] > 1000) {
               String var2 = menuTargets[var1];
               menuTargets[var1] = menuTargets[1 + var1];
               menuTargets[1 + var1] = var2;
               String var3 = menuOptions[var1];
               menuOptions[var1] = menuOptions[1 + var1];
               menuOptions[1 + var1] = var3;
               int var4 = menuTypes[var1];
               menuTypes[var1] = menuTypes[1 + var1];
               menuTypes[1 + var1] = var4;
               var4 = menuActionParams0[var1];
               menuActionParams0[var1] = menuActionParams0[var1 + 1];
               menuActionParams0[1 + var1] = var4;
               var4 = menuActionParams1[var1];
               menuActionParams1[var1] = menuActionParams1[var1 + 1];
               menuActionParams1[1 + var1] = var4;
               var4 = menuIdentifiers[var1];
               menuIdentifiers[var1] = menuIdentifiers[1 + var1];
               menuIdentifiers[var1 + 1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-16738886"
   )
   static final void method609(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field288; ++var4) {
         if(widgetPositionX[var4] + widgetBoundsWidth[var4] > var0 && widgetPositionX[var4] < var0 + var2 && widgetPositionY[var4] + widgetBoundsHeight[var4] > var1 && widgetPositionY[var4] < var3 + var1) {
            field483[var4] = true;
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "-393714858"
   )
   public static FileOnDisk method610(String var0, String var1, boolean var2) {
      File var3 = new File(class231.field3282, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class104.field1692 == 33) {
         var4 = "_rc";
      } else if(class104.field1692 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(ChatLineBuffer.field968, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
