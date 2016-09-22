import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
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
   @ObfuscatedName("er")
   static SpritePixels[] field276;
   @ObfuscatedName("d")
   static Client field277;
   @ObfuscatedName("v")
   static boolean field278 = true;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -398931515
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1548972151
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 341466579
   )
   static int field281 = 0;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -173366373
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("g")
   static class215 field283;
   @ObfuscatedName("ok")
   static short field284;
   @ObfuscatedName("k")
   static boolean field285 = false;
   @ObfuscatedName("mf")
   static String field286;
   @ObfuscatedName("q")
   static String field287;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1388499779
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 231205325
   )
   static int field289;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 789802943
   )
   static int field290;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 5552655321468732323L
   )
   static long field291 = -1L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -49660047
   )
   static int field292 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -148170863
   )
   static int field293 = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1285781921
   )
   static int field294 = -1;
   @ObfuscatedName("as")
   static boolean field295 = true;
   @ObfuscatedName("af")
   static boolean field296 = false;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 1467910073
   )
   static int field297;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 69811177
   )
   static int field298 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -929638775
   )
   static int field299 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 302382779
   )
   static int field300 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1340976913
   )
   static int field301 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1283477763
   )
   static int field302 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1086756365
   )
   static int field303 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1713846087
   )
   static int field304 = 0;
   @ObfuscatedName("fc")
   static int[] field305;
   @ObfuscatedName("al")
   static class21 field306;
   @ObfuscatedName("ad")
   static class21 field307;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1528066065
   )
   static int field308;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1418394671
   )
   static int field309;
   @ObfuscatedName("iw")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("bo")
   static class171 field311;
   @ObfuscatedName("bt")
   static class171 field312;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 696857935
   )
   static int field313;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -1693295931
   )
   static int field314;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -243968001
   )
   static int field315;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1261433617
   )
   static int field316;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 89663255
   )
   static int field317;
   @ObfuscatedName("ch")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 252546987
   )
   static int field319;
   @ObfuscatedName("cr")
   static int[] field320;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 26525549
   )
   static int field321;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 1567288485
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("cm")
   static class125 field323;
   @ObfuscatedName("cj")
   static class125 field324;
   @ObfuscatedName("ct")
   static class125 field325;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 909917835
   )
   static int field326;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 513329885
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1462581167
   )
   static int field328;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 602564487
   )
   static int field329;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 2109500647
   )
   static int field330;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1054995083
   )
   static int field331;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -520774365
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 572654653
   )
   static int field333;
   @ObfuscatedName("ck")
   static boolean field334;
   @ObfuscatedName("cx")
   static class227 field335;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = -40270525
   )
   static int field336;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = -1996781377
   )
   static int field338;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 1512518771
   )
   static int field339;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -2039333313
   )
   static int field340;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 1778653009
   )
   static int field341;
   @ObfuscatedName("do")
   static boolean field342;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -98957039
   )
   static int field343;
   @ObfuscatedName("db")
   static final int[] field344;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 114522121
   )
   static int field345;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 1199296615
   )
   static int field346;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 845920977
   )
   static int field347;
   @ObfuscatedName("kg")
   static int[] field348;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 1720361151
   )
   static int field349;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -101055603
   )
   static int field350;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 854680517
   )
   static int field351;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -479941717
   )
   static int field352;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -1856869393
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1384256265
   )
   static int field354;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 1764175437
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1279125183
   )
   static int field356;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 1475329717
   )
   static int field357;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 1619299361
   )
   static int field358;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 114297341
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 2015952323
   )
   static int field360;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1419300885
   )
   static int field361;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -153669563
   )
   static int field362;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1816809637
   )
   static int field363;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -1888115999
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("mb")
   static int[] field365;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -362842487
   )
   static int field366;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -785362135
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("ou")
   static short field368;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 1170154021
   )
   static int field369;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -270819465
   )
   static int field370;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 1403378111
   )
   static int field371;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -827323471
   )
   static int field372;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -171426969
   )
   static int field373;
   @ObfuscatedName("ku")
   static boolean[] field374;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 658657481
   )
   static int field375;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -1115589327
   )
   static int field376;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 263105811
   )
   static int field377;
   @ObfuscatedName("ff")
   static int[] field378;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 936916115
   )
   static int field379;
   @ObfuscatedName("fj")
   static int[] field380;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2052736933
   )
   static int field381 = 0;
   @ObfuscatedName("fb")
   static int[] field382;
   @ObfuscatedName("fq")
   static int[] field383;
   @ObfuscatedName("fd")
   static int[] field384;
   @ObfuscatedName("gu")
   static String[] field385;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1124021685
   )
   static int field387;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1102411117
   )
   static int field388;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -712946355
   )
   static int field389;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -971601021
   )
   static int field390;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -400245797
   )
   static int field391;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -1552931981
   )
   static int field392;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -1468497829
   )
   static int field393;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -1959890379
   )
   static int field394;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -756354625
   )
   static int field395;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 922024487
   )
   static int field396;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 709038017
   )
   static int field398;
   @ObfuscatedName("cq")
   static int[] field399;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 1919197845
   )
   static int field400;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 543812741
   )
   static int field401;
   @ObfuscatedName("lo")
   static boolean[] field402;
   @ObfuscatedName("gw")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 71387743
   )
   static int field404;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 2050538387
   )
   static int field405;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -1332585009
   )
   static int field406;
   @ObfuscatedName("ho")
   static int[] field407;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      longValue = 3523479585221054127L
   )
   static long field408;
   @ObfuscatedName("he")
   static String[] field409;
   @ObfuscatedName("ld")
   static int[] field410;
   @ObfuscatedName("s")
   static boolean field411 = true;
   @ObfuscatedName("jx")
   static boolean field412;
   @ObfuscatedName("hb")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -2025389353
   )
   static int field414;
   @ObfuscatedName("hv")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hh")
   static Deque field416;
   @ObfuscatedName("hj")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 676365101
   )
   static int field418;
   @ObfuscatedName("hu")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("ls")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("hs")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -2021048979
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("li")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("hz")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("ha")
   static Deque field425;
   @ObfuscatedName("mt")
   static boolean field426;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -1323945923
   )
   static int field427;
   @ObfuscatedName("nq")
   static int[] field428;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -1275127135
   )
   static int field429;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -66351855
   )
   static int field430;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1846372503
   )
   static int field431;
   @ObfuscatedName("ns")
   static class61[] field432;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1686073733
   )
   static int field433;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1642851769
   )
   static int field434;
   @ObfuscatedName("ip")
   static boolean field435;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -1508913369
   )
   static int field436;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1270459891
   )
   static int field437;
   @ObfuscatedName("ig")
   static String field438;
   @ObfuscatedName("ic")
   static String field439;
   @ObfuscatedName("gy")
   static boolean field440;
   @ObfuscatedName("ia")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -1159391343
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("jd")
   static Widget field443;
   @ObfuscatedName("ji")
   static Widget field444;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 1574380397
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("fm")
   static boolean field446;
   @ObfuscatedName("ft")
   static int[] field447;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = -1812087747
   )
   static int field448;
   @ObfuscatedName("ev")
   static SpritePixels[] field449;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1427070579
   )
   static int field450;
   @ObfuscatedName("ex")
   static boolean field451;
   @ObfuscatedName("jg")
   static Widget field452;
   @ObfuscatedName("jp")
   static Widget field453;
   @ObfuscatedName("of")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1900265547
   )
   static int field455;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 560934417
   )
   static int field456;
   @ObfuscatedName("jf")
   static Widget field457;
   @ObfuscatedName("jo")
   static boolean field458;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1498930761
   )
   static int field459;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 1256929043
   )
   static int field460;
   @ObfuscatedName("ja")
   static boolean field461;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -1186935829
   )
   static int field462;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = -948316159
   )
   static int field463;
   @ObfuscatedName("jz")
   static boolean field464;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 2009189769
   )
   static int field465;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -608101847
   )
   static int field466;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 211845035
   )
   static int field467;
   @ObfuscatedName("kk")
   static int[] field468;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -489092355
   )
   static int field469;
   @ObfuscatedName("ij")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("np")
   static int[] field471;
   @ObfuscatedName("ge")
   static int[][] field472;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -695257281
   )
   static int field473;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -760546133
   )
   static int field474;
   @ObfuscatedName("ds")
   static int[][][] field475;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 1930753881
   )
   static int field476;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1012165155
   )
   static int field477;
   @ObfuscatedName("jv")
   static boolean field478;
   @ObfuscatedName("kw")
   static Deque field479;
   @ObfuscatedName("ke")
   static Deque field480;
   @ObfuscatedName("oh")
   static int[] field481;
   @ObfuscatedName("km")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -755226479
   )
   static int field483;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -379644087
   )
   static int field484;
   @ObfuscatedName("m")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("la")
   static boolean[] field486;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 378876797
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("lz")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1905935431
   )
   static int field489 = 0;
   @ObfuscatedName("pv")
   static final class10 field490;
   @ObfuscatedName("lg")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 473108863
   )
   static int field492;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      longValue = 3821813620419242289L
   )
   static long field493;
   @ObfuscatedName("kv")
   static int[] field494;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1969649635
   )
   static int field495;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -381990229
   )
   static int field496;
   @ObfuscatedName("lm")
   static int[] field497;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -447846783
   )
   static int field498;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 1689545653
   )
   static int field499;
   @ObfuscatedName("lq")
   static String field500;
   @ObfuscatedName("lp")
   static long[] field501;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 294040871
   )
   static int field502;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = -733373059
   )
   static int field503;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -928133497
   )
   static int field504;
   @ObfuscatedName("mr")
   static int[] field505;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      longValue = 6555877509149094607L
   )
   static long field506;
   @ObfuscatedName("ms")
   static String field507;
   @ObfuscatedName("hq")
   static int[] field508;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -1215321869
   )
   static int field509;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = -1494777391
   )
   static int field510;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 139275107
   )
   static int field511;
   @ObfuscatedName("mc")
   static int[] field512;
   @ObfuscatedName("my")
   static SpritePixels[] field513;
   @ObfuscatedName("hm")
   static boolean[] field514;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1314112675
   )
   static int field515;
   @ObfuscatedName("ko")
   static Deque field516;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 1734106473
   )
   static int field517;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -2015056969
   )
   static int field518;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 1065750285
   )
   static int field519;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = 654275109
   )
   static int field520;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -458672241
   )
   static int field521;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -479538965
   )
   static int field522;
   @ObfuscatedName("nb")
   static int[] field523;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -854387553
   )
   static int field524;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 1273054913
   )
   static int field525;
   @ObfuscatedName("nx")
   static int[] field526;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -1412429035
   )
   static int field527;
   @ObfuscatedName("nt")
   static boolean field528;
   @ObfuscatedName("il")
   static String field529;
   @ObfuscatedName("oc")
   static short field530;
   @ObfuscatedName("on")
   static int[] field531;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1452538735
   )
   static int field532 = 0;
   @ObfuscatedName("ol")
   static int[] field533;
   @ObfuscatedName("oz")
   static int[] field534;
   @ObfuscatedName("ov")
   static short field535;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -526955373
   )
   static int field536;
   @ObfuscatedName("oi")
   static short field537;
   @ObfuscatedName("hi")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("nl")
   static boolean[] field539;
   @ObfuscatedName("ot")
   static short field540;
   @ObfuscatedName("oy")
   static short field541;
   @ObfuscatedName("od")
   static short field542;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = -773475299
   )
   static int field543;
   @ObfuscatedName("lv")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 1117975283
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("hp")
   static final int[] field546;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 79240981
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("i")
   static class157 field548;
   @ObfuscatedName("iq")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("om")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("ox")
   static class198 field551;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 1477731551
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("hw")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("og")
   static PlayerComposition field554;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -927534595
   )
   static int field555;
   @ObfuscatedName("iu")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("pp")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("jn")
   static boolean field558;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      longValue = 6070242264283427503L
   )
   static long field559;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 957588663
   )
   static int field560;
   @ObfuscatedName("pm")
   static int[] field561;
   @ObfuscatedName("pf")
   static int[] field562;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 837437417
   )
   static int field563;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -125267049
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 1477909605
   )
   static int field565;
   @ObfuscatedName("aj")
   static ModIcon[] field566;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 979363467
   )
   static int field568;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-81"
   )
   protected final void vmethod3055() {
   }

   public final void init() {
      if(this.method3045()) {
         class193[] var1 = new class193[]{class193.field3112, class193.field3120, class193.field3108, class193.field3111, class193.field3116, class193.field3114, class193.field3115, class193.field3109, class193.field3122, class193.field3106, class193.field3119, class193.field3110, class193.field3113, class193.field3107, class193.field3118};
         class193[] var2 = var1;

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class193 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3121);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3121)) {
               case 1:
                  field489 = Integer.parseInt(var5);
                  break;
               case 2:
                  field548 = (class157)class54.method1117(class43.method898(), Integer.parseInt(var5));
                  if(class157.field2352 == field548) {
                     field283 = class215.field3196;
                  } else {
                     field283 = class215.field3191;
                  }
               case 3:
               case 8:
               case 10:
               default:
                  break;
               case 4:
                  class164.field2707 = var5;
                  break;
               case 5:
                  field287 = var5;
                  break;
               case 6:
                  field281 = Integer.parseInt(var5);
                  break;
               case 7:
                  world = Integer.parseInt(var5);
                  break;
               case 9:
                  class5.field84 = NPC.method764(Integer.parseInt(var5));
                  break;
               case 11:
                  flags = Integer.parseInt(var5);
                  break;
               case 12:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 13:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 14:
                  XClanMember.field640 = Integer.parseInt(var5);
                  break;
               case 15:
                  class144.field2237 = Integer.parseInt(var5);
               }
            }
         }

         class12.method163();
         class62.host = this.getCodeBase().getHost();
         String var14 = class5.field84.field2344;
         byte var8 = 0;

         try {
            class152.field2301 = 16;
            class146.field2248 = var8;

            try {
               GroundObject.field1685 = System.getProperty("os.name");
            } catch (Exception var12) {
               GroundObject.field1685 = "Unknown";
            }

            class152.field2306 = GroundObject.field1685.toLowerCase();

            try {
               class228.field3259 = System.getProperty("user.home");
               if(null != class228.field3259) {
                  class228.field3259 = class228.field3259 + "/";
               }
            } catch (Exception var11) {
               ;
            }

            try {
               if(class152.field2306.startsWith("win")) {
                  if(null == class228.field3259) {
                     class228.field3259 = System.getenv("USERPROFILE");
                  }
               } else if(class228.field3259 == null) {
                  class228.field3259 = System.getenv("HOME");
               }

               if(null != class228.field3259) {
                  class228.field3259 = class228.field3259 + "/";
               }
            } catch (Exception var10) {
               ;
            }

            if(null == class228.field3259) {
               class228.field3259 = "~/";
            }

            class129.field2120 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class228.field3259, "/tmp/", ""};
            class124.field2082 = new String[]{".jagex_cache_" + class146.field2248, ".file_store_" + class146.field2248};

            label118:
            for(var3 = 0; var3 < 4; ++var3) {
               class152.field2300 = class187.method3743("oldschool", var14, var3);
               if(!class152.field2300.exists()) {
                  class152.field2300.mkdirs();
               }

               File[] var15 = class152.field2300.listFiles();
               if(null == var15) {
                  break;
               }

               File[] var16 = var15;
               int var6 = 0;

               while(true) {
                  if(var6 >= var16.length) {
                     break label118;
                  }

                  File var7 = var16[var6];
                  if(!class62.method1320(var7, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            method298(class152.field2300);
            class125.method2783();
            class152.field2304 = new class231(new FileOnDisk(class8.method122("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class152.field2297 = new class231(new FileOnDisk(class8.method122("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class232.field3276 = new class231[class152.field2301];

            for(var3 = 0; var3 < class152.field2301; ++var3) {
               class232.field3276[var3] = new class231(new FileOnDisk(class8.method122("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var13) {
            class128.method2843((String)null, var13);
         }

         field277 = this;
         this.method3114(765, 503, 122);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1586014316"
   )
   void method244() {
      if(gameState != 1000) {
         long var2 = class5.method63();
         int var4 = (int)(var2 - CollisionData.field1982);
         CollisionData.field1982 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class174.field2786 += var4;
         boolean var1;
         if(class174.field2790 == 0 && class174.field2785 == 0 && class174.field2788 == 0 && class174.field2783 == 0) {
            var1 = true;
         } else if(null == class174.field2781) {
            var1 = false;
         } else {
            try {
               label244: {
                  if(class174.field2786 > 30000) {
                     throw new IOException();
                  }

                  class175 var5;
                  Buffer var6;
                  while(class174.field2785 < 20 && class174.field2783 > 0) {
                     var5 = (class175)class174.field2791.method3820();
                     var6 = new Buffer(4);
                     var6.method2513(1);
                     var6.method2743((int)var5.hash);
                     class174.field2781.method3025(var6.payload, 0, 4);
                     class174.field2799.method3823(var5, var5.hash);
                     --class174.field2783;
                     ++class174.field2785;
                  }

                  while(class174.field2790 < 20 && class174.field2788 > 0) {
                     var5 = (class175)class174.field2780.method3929();
                     var6 = new Buffer(4);
                     var6.method2513(0);
                     var6.method2743((int)var5.hash);
                     class174.field2781.method3025(var6.payload, 0, 4);
                     var5.method3938();
                     class174.field2784.method3823(var5, var5.hash);
                     --class174.field2788;
                     ++class174.field2790;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class174.field2781.method3021();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class174.field2786 = 0;
                     byte var7 = 0;
                     if(GroundObject.field1677 == null) {
                        var7 = 8;
                     } else if(class174.field2792 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class174.field2782.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class174.field2781.method3035(class174.field2782.payload, class174.field2782.offset, var8);
                        if(class174.field2797 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class174.field2782.payload[class174.field2782.offset + var9] ^= class174.field2797;
                           }
                        }

                        class174.field2782.offset += var8;
                        if(class174.field2782.offset < var7) {
                           break;
                        }

                        if(null == GroundObject.field1677) {
                           class174.field2782.offset = 0;
                           var9 = class174.field2782.method2528();
                           var10 = class174.field2782.method2717();
                           int var11 = class174.field2782.method2528();
                           var12 = class174.field2782.method2533();
                           long var13 = (long)((var9 << 16) + var10);
                           class175 var15 = (class175)class174.field2799.method3817(var13);
                           class112.field1988 = true;
                           if(null == var15) {
                              var15 = (class175)class174.field2784.method3817(var13);
                              class112.field1988 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           GroundObject.field1677 = var15;
                           class117.field2050 = new Buffer(var12 + var16 + GroundObject.field1677.field2802);
                           class117.field2050.method2513(var11);
                           class117.field2050.method2600(var12);
                           class174.field2792 = 8;
                           class174.field2782.offset = 0;
                        } else if(class174.field2792 == 0) {
                           if(class174.field2782.payload[0] == -1) {
                              class174.field2792 = 1;
                              class174.field2782.offset = 0;
                           } else {
                              GroundObject.field1677 = null;
                           }
                        }
                     } else {
                        var8 = class117.field2050.payload.length - GroundObject.field1677.field2802;
                        var9 = 512 - class174.field2792;
                        if(var9 > var8 - class117.field2050.offset) {
                           var9 = var8 - class117.field2050.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class174.field2781.method3035(class117.field2050.payload, class117.field2050.offset, var9);
                        if(class174.field2797 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class117.field2050.payload[var10 + class117.field2050.offset] ^= class174.field2797;
                           }
                        }

                        class117.field2050.offset += var9;
                        class174.field2792 += var9;
                        if(var8 == class117.field2050.offset) {
                           if(16711935L == GroundObject.field1677.hash) {
                              class174.field2795 = class117.field2050;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class171 var19 = class174.field2796[var10];
                                 if(null != var19) {
                                    class174.field2795.offset = var10 * 8 + 5;
                                    var12 = class174.field2795.method2533();
                                    int var23 = class174.field2795.method2533();
                                    var19.method3397(var12, var23);
                                 }
                              }
                           } else {
                              class174.field2794.reset();
                              class174.field2794.update(class117.field2050.payload, 0, var8);
                              var10 = (int)class174.field2794.getValue();
                              if(GroundObject.field1677.field2801 != var10) {
                                 try {
                                    class174.field2781.method3039();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class174.field2798;
                                 class174.field2781 = null;
                                 class174.field2797 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label244;
                              }

                              class174.field2798 = 0;
                              class174.field2789 = 0;
                              GroundObject.field1677.field2805.method3387((int)(GroundObject.field1677.hash & 65535L), class117.field2050.payload, (GroundObject.field1677.hash & 16711680L) == 16711680L, class112.field1988);
                           }

                           GroundObject.field1677.unlink();
                           if(class112.field1988) {
                              --class174.field2785;
                           } else {
                              --class174.field2790;
                           }

                           class174.field2792 = 0;
                           GroundObject.field1677 = null;
                           class117.field2050 = null;
                        } else {
                           if(class174.field2792 != 512) {
                              break;
                           }

                           class174.field2792 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class174.field2781.method3039();
               } catch (Exception var20) {
                  ;
               }

               ++class174.field2789;
               class174.field2781 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method249();
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1647699249"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method244();

      while(true) {
         Deque var2 = class173.field2774;
         class172 var1;
         synchronized(class173.field2774) {
            var1 = (class172)class173.field2773.method3852();
         }

         if(var1 == null) {
            Widget.method3495();
            WidgetNode.method41();
            Buffer.method2742();
            class43.method897();
            int var4;
            if(null != KitDefinition.field1060) {
               var4 = KitDefinition.field1060.vmethod3138();
               field492 = var4;
            }

            if(gameState == 0) {
               class32.method696();
               DecorativeObject.field1699.vmethod3147();

               for(var4 = 0; var4 < 32; ++var4) {
                  GameEngine.field2268[var4] = 0L;
               }

               for(var4 = 0; var4 < 32; ++var4) {
                  GameEngine.field2269[var4] = 0L;
               }

               TextureProvider.field1702 = 0;
            } else if(gameState == 5) {
               class129.method2858(this);
               class32.method696();
               DecorativeObject.field1699.vmethod3147();

               for(var4 = 0; var4 < 32; ++var4) {
                  GameEngine.field2268[var4] = 0L;
               }

               for(var4 = 0; var4 < 32; ++var4) {
                  GameEngine.field2269[var4] = 0L;
               }

               TextureProvider.field1702 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class129.method2858(this);
                  class23.method581();
               } else if(gameState == 25) {
                  class112.method2445();
               }
            } else {
               class129.method2858(this);
            }

            if(gameState == 30) {
               NPC.method766();
            } else if(gameState == 40 || gameState == 45) {
               class23.method581();
            }

            return;
         }

         var1.field2768.method3382(var1.field2763, (int)var1.hash, var1.field2762, false);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1462595576"
   )
   void method249() {
      if(class174.field2798 >= 4) {
         this.method3057("js5crc");
         gameState = 1000;
      } else {
         if(class174.field2789 >= 4) {
            if(gameState <= 5) {
               this.method3057("js5io");
               gameState = 1000;
               return;
            }

            field391 = 3000;
            class174.field2789 = 3;
         }

         if(--field391 + 1 <= 0) {
            try {
               if(field309 == 0) {
                  class132.field2127 = class126.field2103.method2928(class62.host, class50.field1115);
                  ++field309;
               }

               if(field309 == 1) {
                  if(class132.field2127.field2284 == 2) {
                     this.method250(-1);
                     return;
                  }

                  if(class132.field2127.field2284 == 1) {
                     ++field309;
                  }
               }

               if(field309 == 2) {
                  class167.field2721 = new class146((Socket)class132.field2127.field2287, class126.field2103);
                  Buffer var1 = new Buffer(5);
                  var1.method2513(15);
                  var1.method2600(122);
                  class167.field2721.method3025(var1.payload, 0, 5);
                  ++field309;
                  class10.field159 = class5.method63();
               }

               if(field309 == 3) {
                  if(gameState > 5 && class167.field2721.method3021() <= 0) {
                     if(class5.method63() - class10.field159 > 30000L) {
                        this.method250(-2);
                        return;
                     }
                  } else {
                     int var5 = class167.field2721.method3022();
                     if(var5 != 0) {
                        this.method250(var5);
                        return;
                     }

                     ++field309;
                  }
               }

               if(field309 == 4) {
                  class146 var10 = class167.field2721;
                  boolean var2 = gameState > 20;
                  if(class174.field2781 != null) {
                     try {
                        class174.field2781.method3039();
                     } catch (Exception var8) {
                        ;
                     }

                     class174.field2781 = null;
                  }

                  class174.field2781 = var10;
                  class163.method3216(var2);
                  class174.field2782.offset = 0;
                  GroundObject.field1677 = null;
                  class117.field2050 = null;
                  class174.field2792 = 0;

                  while(true) {
                     class175 var3 = (class175)class174.field2799.method3820();
                     if(null == var3) {
                        while(true) {
                           var3 = (class175)class174.field2784.method3820();
                           if(null == var3) {
                              if(class174.field2797 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.method2513(4);
                                    var11.method2513(class174.field2797);
                                    var11.method2514(0);
                                    class174.field2781.method3025(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class174.field2781.method3039();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class174.field2789;
                                    class174.field2781 = null;
                                 }
                              }

                              class174.field2786 = 0;
                              CollisionData.field1982 = class5.method63();
                              class132.field2127 = null;
                              class167.field2721 = null;
                              field309 = 0;
                              field313 = 0;
                              return;
                           }

                           class174.field2780.method3926(var3);
                           class174.field2787.method3823(var3, var3.hash);
                           ++class174.field2788;
                           --class174.field2790;
                        }
                     }

                     class174.field2791.method3823(var3, var3.hash);
                     ++class174.field2783;
                     --class174.field2785;
                  }
               }
            } catch (IOException var9) {
               this.method250(-3);
            }

         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "11743"
   )
   void method250(int var1) {
      class132.field2127 = null;
      class167.field2721 = null;
      field309 = 0;
      if(class50.field1115 == class21.field583) {
         class50.field1115 = class21.field584;
      } else {
         class50.field1115 = class21.field583;
      }

      ++field313;
      if(field313 < 2 || var1 != 7 && var1 != 9) {
         if(field313 >= 2 && var1 == 6) {
            this.method3057("js5connect_outofdate");
            gameState = 1000;
         } else if(field313 >= 4) {
            if(gameState <= 5) {
               this.method3057("js5connect");
               gameState = 1000;
            } else {
               field391 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method3057("js5connect_full");
         gameState = 1000;
      } else {
         field391 = 3000;
      }

   }

   static {
      field306 = class21.field581;
      field307 = class21.field581;
      field308 = 0;
      field309 = 0;
      field391 = 0;
      field313 = 0;
      field290 = 0;
      field315 = 0;
      field316 = 0;
      field317 = 0;
      cachedNPCs = new NPC['耀'];
      field319 = 0;
      field320 = new int['耀'];
      field321 = 0;
      field399 = new int[250];
      field323 = new class125(5000);
      field324 = new class125(5000);
      field325 = new class125(15000);
      field326 = 0;
      packetOpcode = 0;
      field328 = 0;
      field329 = 0;
      field330 = 0;
      field331 = 0;
      field434 = 0;
      field333 = 0;
      field334 = false;
      field289 = 0;
      field390 = 1;
      field338 = 0;
      field339 = 1;
      field340 = 0;
      collisionMaps = new CollisionData[4];
      field342 = false;
      field475 = new int[4][13][13];
      field344 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field525 = 0;
      field347 = 2;
      field352 = 0;
      field349 = 2;
      field350 = 0;
      field483 = 1;
      field568 = 0;
      mapScale = 0;
      field354 = 2;
      mapScaleDelta = 0;
      field356 = 1;
      field357 = 0;
      field358 = 0;
      field360 = 2301979;
      field361 = 5063219;
      field362 = 3353893;
      field363 = 7759444;
      field451 = false;
      field427 = 0;
      field366 = 128;
      mapAngle = 0;
      field495 = 0;
      field369 = 0;
      field370 = 0;
      field371 = 0;
      field372 = 50;
      field373 = 0;
      field446 = false;
      field375 = 0;
      field376 = 0;
      field377 = 50;
      field378 = new int[field377];
      field447 = new int[field377];
      field380 = new int[field377];
      field305 = new int[field377];
      field382 = new int[field377];
      field383 = new int[field377];
      field384 = new int[field377];
      field385 = new String[field377];
      field472 = new int[104][104];
      field387 = 0;
      field388 = -1;
      field389 = -1;
      field521 = 0;
      field394 = 0;
      field392 = 0;
      field393 = 0;
      field455 = 0;
      field395 = 0;
      field396 = 0;
      field450 = 0;
      field398 = 0;
      field504 = 0;
      field440 = false;
      field515 = 0;
      field401 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field405 = 0;
      field406 = 0;
      field407 = new int[1000];
      field546 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field409 = new String[8];
      field514 = new boolean[8];
      field508 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field555 = -1;
      groundItemDeque = new Deque[4][104][104];
      field425 = new Deque();
      projectiles = new Deque();
      field416 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field341 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field429 = -1;
      field430 = -1;
      field431 = 0;
      field565 = 50;
      field524 = 0;
      field529 = null;
      field435 = false;
      field436 = -1;
      field437 = -1;
      field438 = null;
      field439 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field536 = 0;
      field400 = 0;
      field444 = null;
      energy = 0;
      weight = 0;
      field351 = 0;
      field418 = -1;
      field478 = false;
      field558 = false;
      field412 = false;
      field452 = null;
      field453 = null;
      field443 = null;
      field511 = 0;
      field456 = 0;
      field457 = null;
      field458 = false;
      field459 = -1;
      field460 = -1;
      field461 = false;
      field462 = -1;
      field463 = -1;
      field464 = false;
      field465 = 1;
      field348 = new int[32];
      field467 = 0;
      field468 = new int[32];
      field314 = 0;
      field494 = new int[32];
      field527 = 0;
      field560 = 0;
      field473 = 0;
      field474 = 0;
      field433 = 0;
      field476 = 0;
      field477 = 0;
      field492 = 0;
      field479 = new Deque();
      field480 = new Deque();
      field516 = new Deque();
      widgetFlags = new XHashTable(512);
      field518 = 0;
      field484 = -2;
      field374 = new boolean[100];
      field486 = new boolean[100];
      field402 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field519 = 0;
      field493 = 0L;
      isResized = true;
      field346 = 765;
      field509 = 1;
      field497 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field498 = 0;
      field499 = 0;
      field500 = "";
      field501 = new long[100];
      field502 = 0;
      field503 = 0;
      field410 = new int[128];
      field505 = new int[128];
      field506 = -1L;
      field507 = null;
      field286 = null;
      field466 = -1;
      field510 = 0;
      field365 = new int[1000];
      field512 = new int[1000];
      field513 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field404 = 0;
      field517 = 255;
      field496 = -1;
      field426 = false;
      field520 = 127;
      field414 = 127;
      field522 = 0;
      field523 = new int[50];
      field428 = new int[50];
      field471 = new int[50];
      field526 = new int[50];
      field432 = new class61[50];
      field528 = false;
      field539 = new boolean[5];
      field531 = new int[5];
      field481 = new int[5];
      field533 = new int[5];
      field534 = new int[5];
      field535 = 256;
      field368 = 205;
      field537 = 256;
      field530 = 320;
      field284 = 1;
      field540 = 32767;
      field541 = 1;
      field542 = 32767;
      field543 = 0;
      field297 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field469 = 0;
      friends = new Friend[400];
      field551 = new class198();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field554 = new PlayerComposition();
      field336 = -1;
      field343 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field408 = -1L;
      field559 = -1L;
      field490 = new class10();
      field561 = new int[50];
      field562 = new int[50];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-2041093555"
   )
   public static void method298(File var0) {
      class181.field2974 = var0;
      if(!class181.field2974.exists()) {
         throw new RuntimeException("");
      } else {
         class138.field2158 = true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   protected final void vmethod3066() {
      boolean var1 = class125.method2790();
      if(var1 && field426 && null != Projectile.field101) {
         Projectile.field101.method1237();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field493 && class5.method63() > field493) {
            WidgetNode.method45(class23.method586());
         } else if(GameEngine.field2275) {
            class109.method2391();
         }
      }

      Dimension var2 = this.method3059();
      if(class31.field720 != var2.width || class146.field2258 != var2.height || GameEngine.field2265) {
         class22.method580();
         field493 = class5.method63() + 500L;
         GameEngine.field2265 = false;
      }

      boolean var3 = false;
      int var4;
      if(GameEngine.field2273) {
         GameEngine.field2273 = false;
         var3 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field374[var4] = true;
         }
      }

      if(var3) {
         World.method666();
      }

      int var5;
      if(gameState == 0) {
         class119.method2478(class33.field750, class33.field751, (Color)null, var3);
      } else if(gameState == 5) {
         Item.method684(Frames.field1850, field335, class0.field14, var3);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            Item.method684(Frames.field1850, field335, class0.field14, var3);
         } else if(gameState == 25) {
            if(field340 == 1) {
               if(field289 > field390) {
                  field390 = field289;
               }

               var4 = (field390 * 50 - field289 * 50) / field390;
               class38.method779("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field340 == 2) {
               if(field338 > field339) {
                  field339 = field338;
               }

               var4 = 50 + (field339 * 50 - field338 * 50) / field339;
               class38.method779("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class38.method779("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            if(widgetRoot != -1) {
               var4 = widgetRoot;
               if(class93.method2114(var4)) {
                  class75.method1621(Widget.widgets[var4], -1);
               }
            }

            for(var4 = 0; var4 < field518; ++var4) {
               if(field374[var4]) {
                  field486[var4] = true;
               }

               field402[var4] = field374[var4];
               field374[var4] = false;
            }

            field484 = gameCycle;
            field429 = -1;
            field430 = -1;
            ItemComposition.field1217 = null;
            if(widgetRoot != -1) {
               field518 = 0;
               class51.method1048(widgetRoot, 0, 0, class159.field2374, class92.field1643, 0, 0, -1);
            }

            class82.method1822();
            if(!isMenuOpen) {
               if(field429 != -1) {
                  class77.method1643(field429, field430);
               }
            } else {
               Friend.method188();
            }

            if(field519 == 3) {
               for(var4 = 0; var4 < field518; ++var4) {
                  if(field402[var4]) {
                     class82.method1866(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4], 16711935, 128);
                  } else if(field486[var4]) {
                     class82.method1866(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4], 16711680, 128);
                  }
               }
            }

            var4 = Item.plane;
            var5 = WidgetNode.localPlayer.x;
            int var6 = WidgetNode.localPlayer.y;
            int var7 = field358;

            for(class24 var8 = (class24)class24.field629.method3854(); var8 != null; var8 = (class24)class24.field629.method3869()) {
               if(var8.field616 != -1 || null != var8.field622) {
                  int var9 = 0;
                  if(var5 > var8.field613) {
                     var9 += var5 - var8.field613;
                  } else if(var5 < var8.field620) {
                     var9 += var8.field620 - var5;
                  }

                  if(var6 > var8.field614) {
                     var9 += var6 - var8.field614;
                  } else if(var6 < var8.field612) {
                     var9 += var8.field612 - var6;
                  }

                  if(var9 - 64 <= var8.field625 && field414 != 0 && var4 == var8.field610) {
                     var9 -= 64;
                     if(var9 < 0) {
                        var9 = 0;
                     }

                     int var10 = field414 * (var8.field625 - var9) / var8.field625;
                     Object var10000;
                     if(null == var8.field617) {
                        if(var8.field616 >= 0) {
                           var10000 = null;
                           class61 var11 = class61.method1309(class47.field1065, var8.field616, 0);
                           if(var11 != null) {
                              class65 var12 = var11.method1299().method1330(class53.field1160);
                              class67 var13 = class67.method1468(var12, 100, var10);
                              var13.method1430(-1);
                              GameObject.field1759.method1187(var13);
                              var8.field617 = var13;
                           }
                        }
                     } else {
                        var8.field617.method1353(var10);
                     }

                     if(var8.field619 == null) {
                        if(var8.field622 != null && (var8.field621 -= var7) <= 0) {
                           int var15 = (int)(Math.random() * (double)var8.field622.length);
                           var10000 = null;
                           class61 var19 = class61.method1309(class47.field1065, var8.field622[var15], 0);
                           if(null != var19) {
                              class65 var20 = var19.method1299().method1330(class53.field1160);
                              class67 var14 = class67.method1468(var20, 100, var10);
                              var14.method1430(0);
                              GameObject.field1759.method1187(var14);
                              var8.field619 = var14;
                              var8.field621 = var8.field618 + (int)(Math.random() * (double)(var8.field611 - var8.field618));
                           }
                        }
                     } else {
                        var8.field619.method1353(var10);
                        if(!var8.field619.linked()) {
                           var8.field619 = null;
                        }
                     }
                  } else {
                     if(var8.field617 != null) {
                        GameObject.field1759.method1188(var8.field617);
                        var8.field617 = null;
                     }

                     if(var8.field619 != null) {
                        GameObject.field1759.method1188(var8.field619);
                        var8.field619 = null;
                     }
                  }
               }
            }

            field358 = 0;
         } else if(gameState == 40) {
            class38.method779("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class38.method779("Please wait...", false);
         }
      } else {
         Item.method684(Frames.field1850, field335, class0.field14, var3);
      }

      Graphics var16;
      if(gameState == 30 && field519 == 0 && !var3) {
         try {
            var16 = class79.canvas.getGraphics();

            for(var5 = 0; var5 < field518; ++var5) {
               if(field486[var5]) {
                  Buffer.bufferProvider.drawSub(var16, widgetPositionX[var5], widgetPositionY[var5], widgetBoundsWidth[var5], widgetBoundsHeight[var5]);
                  field486[var5] = false;
               }
            }
         } catch (Exception var18) {
            class79.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var16 = class79.canvas.getGraphics();
            Buffer.bufferProvider.draw(var16, 0, 0);

            for(var5 = 0; var5 < field518; ++var5) {
               field486[var5] = false;
            }
         } catch (Exception var17) {
            class79.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "14570"
   )
   protected final void vmethod3053() {
      class21.field583 = field281 == 0?'ꩊ':'鱀' + world;
      class21.field584 = field281 == 0?443:world + '썐';
      class50.field1115 = class21.field583;
      FileOnDisk.field3260 = class177.field2952;
      PlayerComposition.field2975 = class177.field2956;
      PlayerComposition.field2982 = class177.field2953;
      class127.field2112 = class177.field2954;
      if(class139.field2162.toLowerCase().indexOf("microsoft") != -1) {
         class140.field2199[186] = 57;
         class140.field2199[187] = 27;
         class140.field2199[188] = 71;
         class140.field2199[189] = 26;
         class140.field2199[190] = 72;
         class140.field2199[191] = 73;
         class140.field2199[192] = 58;
         class140.field2199[219] = 42;
         class140.field2199[220] = 74;
         class140.field2199[221] = 43;
         class140.field2199[222] = 59;
         class140.field2199[223] = 28;
      } else {
         class140.field2199[44] = 71;
         class140.field2199[45] = 26;
         class140.field2199[46] = 72;
         class140.field2199[47] = 73;
         class140.field2199[59] = 57;
         class140.field2199[61] = 27;
         class140.field2199[91] = 42;
         class140.field2199[92] = 74;
         class140.field2199[93] = 43;
         class140.field2199[192] = 28;
         class140.field2199[222] = 58;
         class140.field2199[520] = 59;
      }

      class34.method746(class79.canvas);
      Canvas var1 = class79.canvas;
      var1.addMouseListener(class143.mouse);
      var1.addMouseMotionListener(class143.mouse);
      var1.addFocusListener(class143.mouse);

      class148 var2;
      try {
         var2 = new class148();
      } catch (Throwable var4) {
         var2 = null;
      }

      KitDefinition.field1060 = var2;
      if(null != KitDefinition.field1060) {
         KitDefinition.field1060.vmethod3136(class79.canvas);
      }

      class13.field188 = new class137(255, class152.field2304, class152.field2297, 500000);
      class116.field2039 = class9.method126();
      FaceNormal.field1539 = this.getToolkit().getSystemClipboard();
      CollisionData.method2430(this, MessageNode.field821);
      if(field281 != 0) {
         field296 = true;
      }

      WidgetNode.method45(class116.field2039.field134);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-66"
   )
   protected final void vmethod3056() {
      if(Friend.chatMessages.method209()) {
         Friend.chatMessages.method207();
      }

      if(null != class165.field2714) {
         class165.field2714.field197 = false;
      }

      class165.field2714 = null;
      if(BufferProvider.field1475 != null) {
         BufferProvider.field1475.method3039();
         BufferProvider.field1475 = null;
      }

      if(null != class140.keyboard) {
         class140 var1 = class140.keyboard;
         synchronized(class140.keyboard) {
            class140.keyboard = null;
         }
      }

      if(null != class143.mouse) {
         class143 var9 = class143.mouse;
         synchronized(class143.mouse) {
            class143.mouse = null;
         }
      }

      KitDefinition.field1060 = null;
      if(null != Projectile.field101) {
         Projectile.field101.method1240();
      }

      if(null != class13.field192) {
         class13.field192.method1240();
      }

      class20.method564();
      Object var10 = class173.field2772;
      synchronized(class173.field2772) {
         if(class173.field2777 != 0) {
            class173.field2777 = 1;

            try {
               class173.field2772.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      class49.method1023();
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "487422402"
   )
   static void method440() {
      if(field435) {
         Widget var0 = class38.method781(XClanMember.field638, field436);
         if(null != var0 && null != var0.field2892) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field7 = var0.field2892;
            class1.method9(var1, 200000);
         }

         field435 = false;
         class53.method1101(var0);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-35065067"
   )
   static void method555(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3817((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3823(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
