import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
public final class client extends class144 {
   @ObfuscatedName("dk")
   static final int[] field287;
   @ObfuscatedName("ch")
   static int[] field288;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = -2064604327
   )
   static int field289;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -1679948901
   )
   static int field290;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1882654623
   )
   @Export("flags")
   static int field291 = 0;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      longValue = -4347700076998185595L
   )
   static long field292;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 890966231
   )
   static int field293 = 0;
   @ObfuscatedName("s")
   static class212 field294;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -785537667
   )
   static int field295;
   @ObfuscatedName("k")
   static boolean field296 = false;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -424725029
   )
   static int field297 = 0;
   @ObfuscatedName("jd")
   static class173 field298;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 737163399
   )
   @Export("gameState")
   static int field299 = 0;
   @ObfuscatedName("v")
   static boolean field300 = true;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 92517887
   )
   @Export("gameCycle")
   static int field301 = 0;
   @ObfuscatedName("gc")
   @Export("cachedPlayers")
   static class2[] field302;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = -343595917
   )
   static int field303;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1396905247
   )
   static int field304;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -676022763
   )
   static int field305 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1560493359
   )
   static int field306 = -1;
   @ObfuscatedName("ax")
   static boolean field307 = true;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 487684353
   )
   static int field308;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1216306223
   )
   static int field309 = 0;
   @ObfuscatedName("hi")
   @Export("isMenuOpen")
   static boolean field310;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1246083121
   )
   static int field311 = 0;
   @ObfuscatedName("jc")
   static class173 field312;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2061009745
   )
   static int field313 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1328087221
   )
   static int field314 = 0;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 328642015
   )
   static int field315;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 721774831
   )
   static int field316 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 554134457
   )
   static int field317 = 0;
   @ObfuscatedName("ap")
   static class20 field318;
   @ObfuscatedName("af")
   static class20 field319;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1757284593
   )
   static int field320;
   @ObfuscatedName("ph")
   static int[] field321;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 29879103
   )
   static int field322;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -44860557
   )
   static int field323;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -46516629
   )
   static int field324;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 713012655
   )
   @Export("packetOpcode")
   static int field325;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -98700739
   )
   static int field326;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -417950081
   )
   static int field327;
   @ObfuscatedName("cl")
   @Export("cachedNPCs")
   static class34[] field328;
   @ObfuscatedName("in")
   @Export("menuTypes")
   static int[] field329;
   @ObfuscatedName("cz")
   static int[] field330;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -479567287
   )
   static int field331;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 1980548745
   )
   static int field332;
   @ObfuscatedName("cg")
   static class122 field333;
   @ObfuscatedName("gf")
   static String[] field334;
   @ObfuscatedName("ck")
   static class122 field335;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1211793191
   )
   static int field336;
   @ObfuscatedName("gb")
   static int[][] field337;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1759464441
   )
   static int field338;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1829362723
   )
   static int field339;
   @ObfuscatedName("fb")
   static boolean field340;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -2083576523
   )
   static int field341;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1096755771
   )
   static int field342;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 992801379
   )
   static int field343;
   @ObfuscatedName("os")
   static short field344;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 741027023
   )
   static int field345;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1536469169
   )
   static int field346;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 445874927
   )
   static int field347;
   @ObfuscatedName("li")
   static int[] field348;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 1776476947
   )
   static int field349;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class108[] field350;
   @ObfuscatedName("de")
   static boolean field351;
   @ObfuscatedName("dm")
   static int[][][] field352;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -692989321
   )
   static int field353;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -748442603
   )
   static int field354 = -1;
   @ObfuscatedName("ao")
   static boolean field355 = false;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 1198943891
   )
   static int field356;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 1444061733
   )
   static int field357;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 784610257
   )
   static int field358;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1120271967
   )
   static int field359;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1032066629
   )
   static int field360 = 0;
   @ObfuscatedName("cy")
   static boolean field361;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 1443897029
   )
   static int field362;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 67048233
   )
   @Export("mapScaleDelta")
   static int field363;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1827343631
   )
   static int field364;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      longValue = -2965810617333526431L
   )
   static long field365;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1743435793
   )
   static int field366;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -1208992087
   )
   static int field367;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 281708495
   )
   static int field368;
   @ObfuscatedName("jr")
   static boolean field369;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 922018925
   )
   static int field370;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -1474183715
   )
   static int field371;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1033199995
   )
   static int field372;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -2037977229
   )
   static int field373;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -1494353725
   )
   @Export("mapAngle")
   static int field374;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -702570901
   )
   static int field375;
   @ObfuscatedName("he")
   static boolean[] field376;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 483359011
   )
   static int field377;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1567754883
   )
   static int field378;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 1345081297
   )
   static int field379;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -2103847151
   )
   static int field380;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = 572965961
   )
   static int field381;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 23253219
   )
   static int field382;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 408960313
   )
   static int field383;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -1465265263
   )
   static int field384;
   @ObfuscatedName("fh")
   static int[] field385;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2122846565
   )
   @Export("world")
   static int field386 = 1;
   @ObfuscatedName("fg")
   static int[] field387;
   @ObfuscatedName("fa")
   static int[] field388;
   @ObfuscatedName("fn")
   static int[] field389;
   @ObfuscatedName("ft")
   static int[] field390;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 117067229
   )
   @Export("widgetRoot")
   static int field391;
   @ObfuscatedName("nb")
   static class58[] field392;
   @ObfuscatedName("kq")
   static class199 field393;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1147352655
   )
   static int field394;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 1347617371
   )
   static int field395;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1842245977
   )
   static int field396;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = -1592507873
   )
   static int field397;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1744021051
   )
   static int field398;
   @ObfuscatedName("jk")
   static class173 field399;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 1229806919
   )
   static int field400;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 1930246493
   )
   static int field401;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -305286989
   )
   static int field402;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -1553833127
   )
   static int field403;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1395284743
   )
   static int field404;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -47672963
   )
   static int field405;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -769501157
   )
   static int field406;
   @ObfuscatedName("gn")
   static boolean field407;
   @ObfuscatedName("kk")
   static int[] field408;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -560098253
   )
   static int field409;
   @ObfuscatedName("r")
   @Export("isMembers")
   static boolean field410 = false;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1374700221
   )
   @Export("localInteractingIndex")
   static int field411;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -759099717
   )
   static int field412;
   @ObfuscatedName("p")
   static String field413;
   @ObfuscatedName("hk")
   static int[] field414;
   @ObfuscatedName("hd")
   static final int[] field415;
   @ObfuscatedName("ho")
   static String[] field416;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1947174631
   )
   static int field417;
   @ObfuscatedName("hr")
   static int[] field418;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1078507685
   )
   static int field419;
   @ObfuscatedName("oi")
   static short field420;
   @ObfuscatedName("hj")
   static class199 field421;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = 494268147
   )
   static int field422;
   @ObfuscatedName("hw")
   static class199 field423;
   @ObfuscatedName("hm")
   @Export("boostedSkillLevels")
   static int[] field424;
   @ObfuscatedName("hs")
   @Export("realSkillLevels")
   static int[] field425;
   @ObfuscatedName("hv")
   @Export("skillExperiences")
   static int[] field426;
   @ObfuscatedName("lk")
   static boolean[] field427;
   @ObfuscatedName("js")
   static class173 field428;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 10157827
   )
   @Export("menuOptionCount")
   static int field429;
   @ObfuscatedName("mg")
   static int[] field430;
   @ObfuscatedName("ip")
   @Export("menuActionParams1")
   static int[] field431;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -1237016455
   )
   @Export("camera2")
   static int field432;
   @ObfuscatedName("iv")
   @Export("menuIdentifiers")
   static int[] field433;
   @ObfuscatedName("hy")
   @Export("menuActionParams0")
   static int[] field434;
   @ObfuscatedName("im")
   @Export("menuTargets")
   static String[] field435;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -2035987201
   )
   static int field436;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 150784955
   )
   static int field438;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -819852947
   )
   static int field439;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 456731923
   )
   static int field440 = 0;
   @ObfuscatedName("iu")
   static String field441;
   @ObfuscatedName("iw")
   static boolean field442;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 1982365871
   )
   static int field443;
   @ObfuscatedName("oz")
   static short field444;
   @ObfuscatedName("ig")
   static String field445;
   @ObfuscatedName("if")
   static String field446;
   @ObfuscatedName("n")
   static class153 field447;
   @ObfuscatedName("it")
   @Export("componentTable")
   static class196 field448;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 238078389
   )
   static int field449;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -152531373
   )
   static int field450;
   @ObfuscatedName("cw")
   static class122 field451;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -698083425
   )
   @Export("energy")
   static int field452;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -1262931187
   )
   @Export("weight")
   static int field453;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -601652687
   )
   static int field454;
   @ObfuscatedName("b")
   static boolean field455 = true;
   @ObfuscatedName("jm")
   static boolean field456;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 595161897
   )
   static int field457 = 0;
   @ObfuscatedName("jv")
   static boolean field458;
   @ObfuscatedName("ie")
   @Export("menuOptions")
   static String[] field459;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 6561637979643123859L
   )
   static long field460 = -1L;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 1923646791
   )
   static int field461;
   @ObfuscatedName("jj")
   static class173 field462;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 1696515951
   )
   static int field463;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 1367796885
   )
   static int field464;
   @ObfuscatedName("jw")
   static boolean field465;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 1096444261
   )
   static int field466;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 2604145
   )
   static int field467;
   @ObfuscatedName("jn")
   static boolean field468;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -368643395
   )
   static int field469;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 2045105159
   )
   static int field470;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -1167359077
   )
   static int field471;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -1253182033
   )
   static int field472;
   @ObfuscatedName("a")
   static class13 field473;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -283648345
   )
   static int field474;
   @ObfuscatedName("kp")
   static int[] field475;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 2005041909
   )
   static int field476;
   @ObfuscatedName("kv")
   static int[] field477;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -272135195
   )
   static int field478;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -345495311
   )
   static int field479;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -1130458631
   )
   static int field480;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -1029369341
   )
   static int field481;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -994446941
   )
   @Export("flagX")
   static int field482;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -332599035
   )
   static int field483;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      longValue = -2446214262078579835L
   )
   static long field484;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -1618330595
   )
   static int field485;
   @ObfuscatedName("kr")
   static class199 field486;
   @ObfuscatedName("gd")
   static int[] field487;
   @ObfuscatedName("ko")
   static class199 field488;
   @ObfuscatedName("ky")
   @Export("widgetFlags")
   static class196 field489;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 1704861165
   )
   static int field490;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 1027264803
   )
   static int field491;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 351869595
   )
   static int field492;
   @ObfuscatedName("lm")
   static boolean[] field493;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -216822061
   )
   static int field494;
   @ObfuscatedName("lh")
   @Export("widgetPositionX")
   static int[] field495;
   @ObfuscatedName("ll")
   @Export("widgetPositionY")
   static int[] field496;
   @ObfuscatedName("lo")
   @Export("widgetBoundsWidth")
   static int[] field497;
   @ObfuscatedName("ln")
   @Export("widgetBoundsHeight")
   static int[] field498;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -25772557
   )
   static int field499;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1679730889
   )
   @Export("mapScale")
   static int field500;
   @ObfuscatedName("la")
   @Export("isResized")
   static boolean field501;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -129234813
   )
   static int field502;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -74674811
   )
   static int field503;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -633157593
   )
   static int field504;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1200327811
   )
   static int field505;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -1418214267
   )
   static int field506;
   @ObfuscatedName("lc")
   static String field507;
   @ObfuscatedName("lx")
   static long[] field508;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -1669306893
   )
   static int field509;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -959427021
   )
   static int field510;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1640460743
   )
   static int field511;
   @ObfuscatedName("me")
   static int[] field512;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      longValue = -3877660256461327219L
   )
   static long field513;
   @ObfuscatedName("mw")
   static String field514;
   @ObfuscatedName("ms")
   static String field515;
   @ObfuscatedName("lz")
   static boolean[] field516;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -1090120211
   )
   static int field517;
   @ObfuscatedName("mp")
   static int[] field518;
   @ObfuscatedName("mt")
   static int[] field519;
   @ObfuscatedName("mj")
   static class78[] field520;
   @ObfuscatedName("nu")
   static int[] field521;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 1038522409
   )
   @Export("flagY")
   static int field522;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = -723662141
   )
   static int field523;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -178482881
   )
   static int field524;
   @ObfuscatedName("od")
   static boolean[] field525;
   @ObfuscatedName("mv")
   static boolean field526;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 871386773
   )
   static int field527;
   @ObfuscatedName("fj")
   static int[] field528;
   @ObfuscatedName("u")
   static client field530;
   @ObfuscatedName("nh")
   static int[] field531;
   @ObfuscatedName("na")
   static int[] field532;
   @ObfuscatedName("nc")
   static int[] field533;
   @ObfuscatedName("jo")
   static boolean field534;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 1918320573
   )
   static int field535;
   @ObfuscatedName("ns")
   static boolean field536;
   @ObfuscatedName("ez")
   static boolean field537;
   @ObfuscatedName("of")
   static int[] field538;
   @ObfuscatedName("ov")
   static int[] field539;
   @ObfuscatedName("oa")
   static int[] field540;
   @ObfuscatedName("oj")
   static int[] field541;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -1329109393
   )
   static int field542;
   @ObfuscatedName("om")
   static short field543;
   @ObfuscatedName("ol")
   static short field544;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 1127133225
   )
   static int field545;
   @ObfuscatedName("oc")
   static short field546;
   @ObfuscatedName("oe")
   static short field547;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 228066987
   )
   @Export("scale")
   static int field548;
   @ObfuscatedName("ha")
   @Export("projectiles")
   static class199 field549;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -855820675
   )
   static int field550;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -74277719
   )
   static int field551;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -47323735
   )
   static int field552;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 1332621253
   )
   @Export("camera3")
   static int field553;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = 1162915905
   )
   static int field554;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -1055572205
   )
   @Export("friendCount")
   static int field555;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 603207213
   )
   static int field556;
   @ObfuscatedName("ok")
   @Export("friends")
   static class17[] field557;
   @ObfuscatedName("og")
   static class195 field558;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 2013913585
   )
   @Export("ignoreCount")
   static int field559;
   @ObfuscatedName("ow")
   @Export("ignores")
   static class7[] field560;
   @ObfuscatedName("pl")
   static class179 field561;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 1011165873
   )
   static int field562;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -1887165913
   )
   static int field563;
   @ObfuscatedName("pj")
   @Export("grandExchangeOffers")
   static class220[] field564;
   @ObfuscatedName("oh")
   static short field565;
   @ObfuscatedName("pw")
   static class134 field566;
   @ObfuscatedName("py")
   static final class10 field567;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 978696929
   )
   static int field568;
   @ObfuscatedName("pp")
   static int[] field569;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = -493823483
   )
   static int field570;
   @ObfuscatedName("hh")
   @Export("groundItemDeque")
   static class199[][][] field572;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-25474"
   )
   @Export("packetHandler")
   protected final void vmethod3057() {
      ++field301;
      this.method285();
      class130.method2845();
      class177.method3485();
      class8.method114();
      class137 var1 = class137.field2118;
      int var2;
      synchronized(class137.field2118) {
         ++class137.field2126;
         class137.field2116 = class137.field2127;
         class137.field2123 = 0;
         if(class137.field2113 >= 0) {
            while(class137.field2113 != class137.field2125) {
               var2 = class137.field2122[class137.field2125];
               class137.field2125 = 1 + class137.field2125 & 127;
               if(var2 < 0) {
                  class137.field2114[~var2] = false;
               } else {
                  if(!class137.field2114[var2] && class137.field2123 < class137.field2117.length - 1) {
                     class137.field2117[++class137.field2123 - 1] = var2;
                  }

                  class137.field2114[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               class137.field2114[var2] = false;
            }

            class137.field2113 = class137.field2125;
         }

         class137.field2127 = class137.field2124;
      }

      class140 var58 = class140.field2147;
      synchronized(class140.field2147) {
         class140.field2144 = class140.field2154;
         class140.field2146 = class140.field2149;
         class140.field2151 = class140.field2150;
         class140.field2156 = class140.field2152;
         class140.field2161 = class140.field2153;
         class140.field2158 = class140.field2157;
         class140.field2159 = class140.field2155;
         class140.field2152 = 0;
      }

      if(class122.field2018 != null) {
         int var43 = class122.field2018.vmethod3141();
         field485 = var43;
      }

      if(field299 == 0) {
         class17.method201();
         class8.method120();
      } else if(field299 == 5) {
         class104.method2348(this);
         class17.method201();
         class8.method120();
      } else if(field299 != 10 && field299 != 11) {
         if(field299 == 20) {
            class104.method2348(this);
            class4.method51();
         } else if(field299 == 25) {
            class50.method1074(false);
            field377 = 0;
            boolean var60 = true;

            for(var2 = 0; var2 < class135.field2087.length; ++var2) {
               if(class164.field2652[var2] != -1 && null == class135.field2087[var2]) {
                  class135.field2087[var2] = class89.field1563.method3286(class164.field2652[var2], 0);
                  if(class135.field2087[var2] == null) {
                     var60 = false;
                     ++field377;
                  }
               }

               if(class175.field2897[var2] != -1 && class8.field150[var2] == null) {
                  class8.field150[var2] = class89.field1563.method3287(class175.field2897[var2], 0, class37.field863[var2]);
                  if(null == class8.field150[var2]) {
                     var60 = false;
                     ++field377;
                  }
               }
            }

            if(!var60) {
               field499 = 1;
            } else {
               field347 = 0;
               var60 = true;

               int var5;
               int var44;
               for(var2 = 0; var2 < class135.field2087.length; ++var2) {
                  byte[] var3 = class8.field150[var2];
                  if(var3 != null) {
                     var44 = 64 * (class16.field243[var2] >> 8) - class172.field2734;
                     var5 = 64 * (class16.field243[var2] & 255) - class20.field576;
                     if(field351) {
                        var44 = 10;
                        var5 = 10;
                     }

                     var60 &= class1.method9(var3, var44, var5);
                  }
               }

               if(!var60) {
                  field499 = 2;
               } else {
                  if(field499 != 0) {
                     class33.method747("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class8.method114();
                  class11.method141();
                  class8.method114();
                  class129.field2056.method2108();
                  class8.method114();
                  System.gc();

                  for(var2 = 0; var2 < 4; ++var2) {
                     field350[var2].method2432();
                  }

                  int var45;
                  for(var2 = 0; var2 < 4; ++var2) {
                     for(var45 = 0; var45 < 104; ++var45) {
                        for(var44 = 0; var44 < 104; ++var44) {
                           class5.field82[var2][var45][var44] = 0;
                        }
                     }
                  }

                  class8.method114();
                  class144.method3081();
                  var2 = class135.field2087.length;
                  class42.method938();
                  class50.method1074(true);
                  int var7;
                  int var8;
                  int var10;
                  int var11;
                  int var12;
                  int var13;
                  int var14;
                  int var15;
                  int var16;
                  int var17;
                  int var21;
                  int var22;
                  int var47;
                  if(!field351) {
                     var45 = 0;

                     label570:
                     while(true) {
                        byte[] var6;
                        if(var45 >= var2) {
                           for(var45 = 0; var45 < var2; ++var45) {
                              var44 = (class16.field243[var45] >> 8) * 64 - class172.field2734;
                              var5 = (class16.field243[var45] & 255) * 64 - class20.field576;
                              var6 = class135.field2087[var45];
                              if(var6 == null && class0.field5 < 800) {
                                 class8.method114();
                                 class114.method2496(var44, var5, 64, 64);
                              }
                           }

                           class50.method1074(true);
                           var45 = 0;

                           while(true) {
                              if(var45 >= var2) {
                                 break label570;
                              }

                              byte[] var4 = class8.field150[var45];
                              if(var4 != null) {
                                 var5 = 64 * (class16.field243[var45] >> 8) - class172.field2734;
                                 var47 = 64 * (class16.field243[var45] & 255) - class20.field576;
                                 class8.method114();
                                 class86 var48 = class129.field2056;
                                 class108[] var49 = field350;
                                 class119 var59 = new class119(var4);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var59.method2567();
                                    if(var11 == 0) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var13 = var59.method2567();
                                       if(var13 == 0) {
                                          break;
                                       }

                                       var12 += var13 - 1;
                                       var14 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       var17 = var59.method2554();
                                       int var18 = var17 >> 2;
                                       int var19 = var17 & 3;
                                       int var20 = var5 + var15;
                                       var21 = var47 + var14;
                                       if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                          var22 = var16;
                                          if((class5.field82[1][var20][var21] & 2) == 2) {
                                             var22 = var16 - 1;
                                          }

                                          class108 var23 = null;
                                          if(var22 >= 0) {
                                             var23 = var49[var22];
                                          }

                                          class36.method778(var16, var20, var21, var10, var19, var18, var48, var23);
                                       }
                                    }
                                 }
                              }

                              ++var45;
                           }
                        }

                        var44 = 64 * (class16.field243[var45] >> 8) - class172.field2734;
                        var5 = 64 * (class16.field243[var45] & 255) - class20.field576;
                        var6 = class135.field2087[var45];
                        if(null != var6) {
                           class8.method114();
                           var7 = class170.field2709 * 8 - 48;
                           var8 = class0.field5 * 8 - 48;
                           class108[] var9 = field350;
                           var10 = 0;

                           label567:
                           while(true) {
                              if(var10 >= 4) {
                                 class119 var46 = new class119(var6);
                                 var11 = 0;

                                 while(true) {
                                    if(var11 >= 4) {
                                       break label567;
                                    }

                                    for(var12 = 0; var12 < 64; ++var12) {
                                       for(var13 = 0; var13 < 64; ++var13) {
                                          class95.method2244(var46, var11, var12 + var44, var5 + var13, var7, var8, 0);
                                       }
                                    }

                                    ++var11;
                                 }
                              }

                              for(var11 = 0; var11 < 64; ++var11) {
                                 for(var12 = 0; var12 < 64; ++var12) {
                                    if(var44 + var11 > 0 && var44 + var11 < 103 && var5 + var12 > 0 && var5 + var12 < 103) {
                                       var9[var10].field1908[var44 + var11][var12 + var5] &= -16777217;
                                    }
                                 }
                              }

                              ++var10;
                           }
                        }

                        ++var45;
                     }
                  }

                  int var50;
                  if(field351) {
                     var45 = 0;

                     label503:
                     while(true) {
                        if(var45 >= 4) {
                           for(var45 = 0; var45 < 13; ++var45) {
                              for(var44 = 0; var44 < 13; ++var44) {
                                 var5 = field352[0][var45][var44];
                                 if(var5 == -1) {
                                    class114.method2496(8 * var45, 8 * var44, 8, 8);
                                 }
                              }
                           }

                           class50.method1074(true);
                           var45 = 0;

                           while(true) {
                              if(var45 >= 4) {
                                 break label503;
                              }

                              class8.method114();

                              for(var44 = 0; var44 < 13; ++var44) {
                                 label460:
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var47 = field352[var45][var44][var5];
                                    if(var47 != -1) {
                                       var7 = var47 >> 24 & 3;
                                       var8 = var47 >> 1 & 3;
                                       var50 = var47 >> 14 & 1023;
                                       var10 = var47 >> 3 & 2047;
                                       var11 = var10 / 8 + (var50 / 8 << 8);

                                       for(var12 = 0; var12 < class16.field243.length; ++var12) {
                                          if(class16.field243[var12] == var11 && null != class8.field150[var12]) {
                                             byte[] var51 = class8.field150[var12];
                                             var14 = var44 * 8;
                                             var15 = var5 * 8;
                                             var16 = (var50 & 7) * 8;
                                             var17 = 8 * (var10 & 7);
                                             class86 var52 = class129.field2056;
                                             class108[] var53 = field350;
                                             class119 var54 = new class119(var51);
                                             var21 = -1;

                                             while(true) {
                                                var22 = var54.method2567();
                                                if(var22 == 0) {
                                                   continue label460;
                                                }

                                                var21 += var22;
                                                int var55 = 0;

                                                while(true) {
                                                   int var24 = var54.method2567();
                                                   if(var24 == 0) {
                                                      break;
                                                   }

                                                   var55 += var24 - 1;
                                                   int var25 = var55 & 63;
                                                   int var26 = var55 >> 6 & 63;
                                                   int var27 = var55 >> 12;
                                                   int var28 = var54.method2554();
                                                   int var29 = var28 >> 2;
                                                   int var30 = var28 & 3;
                                                   if(var7 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                      class40 var31 = class150.method3166(var21);
                                                      int var32 = var14 + class48.method1042(var26 & 7, var25 & 7, var8, var31.field945, var31.field937, var30);
                                                      int var35 = var26 & 7;
                                                      int var36 = var25 & 7;
                                                      int var38 = var31.field945;
                                                      int var39 = var31.field937;
                                                      int var40;
                                                      if((var30 & 1) == 1) {
                                                         var40 = var38;
                                                         var38 = var39;
                                                         var39 = var40;
                                                      }

                                                      int var37 = var8 & 3;
                                                      int var34;
                                                      if(var37 == 0) {
                                                         var34 = var36;
                                                      } else if(var37 == 1) {
                                                         var34 = 7 - var35 - (var38 - 1);
                                                      } else if(var37 == 2) {
                                                         var34 = 7 - var36 - (var39 - 1);
                                                      } else {
                                                         var34 = var35;
                                                      }

                                                      var40 = var15 + var34;
                                                      if(var32 > 0 && var40 > 0 && var32 < 103 && var40 < 103) {
                                                         int var41 = var45;
                                                         if((class5.field82[1][var32][var40] & 2) == 2) {
                                                            var41 = var45 - 1;
                                                         }

                                                         class108 var42 = null;
                                                         if(var41 >= 0) {
                                                            var42 = var53[var41];
                                                         }

                                                         class36.method778(var45, var32, var40, var21, var8 + var30 & 3, var29, var52, var42);
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var45;
                           }
                        }

                        class8.method114();

                        for(var44 = 0; var44 < 13; ++var44) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var61 = false;
                              var7 = field352[var45][var44][var5];
                              if(var7 != -1) {
                                 var8 = var7 >> 24 & 3;
                                 var50 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(var13 = 0; var13 < class16.field243.length; ++var13) {
                                    if(class16.field243[var13] == var12 && null != class135.field2087[var13]) {
                                       class109.method2472(class135.field2087[var13], var45, 8 * var44, var5 * 8, var8, (var10 & 7) * 8, 8 * (var11 & 7), var50, field350);
                                       var61 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var61) {
                                 class3.method45(var45, var44 * 8, 8 * var5);
                              }
                           }
                        }

                        ++var45;
                     }
                  }

                  class50.method1074(true);
                  class11.method141();
                  class8.method114();
                  class125.method2829(class129.field2056, field350);
                  class50.method1074(true);
                  var45 = class5.field83;
                  if(var45 > class14.field212) {
                     var45 = class14.field212;
                  }

                  if(var45 < class14.field212 - 1) {
                     var45 = class14.field212 - 1;
                  }

                  if(field296) {
                     class129.field2056.method1976(class5.field83);
                  } else {
                     class129.field2056.method1976(0);
                  }

                  for(var44 = 0; var44 < 104; ++var44) {
                     for(var5 = 0; var5 < 104; ++var5) {
                        class160.method3204(var44, var5);
                     }
                  }

                  class8.method114();
                  class149.method3162();
                  class40.field966.method3796();
                  if(null != class102.field1764) {
                     field333.method2773(180);
                     field333.method2539(1057001181);
                  }

                  if(!field351) {
                     var44 = (class170.field2709 - 6) / 8;
                     var5 = (6 + class170.field2709) / 8;
                     var47 = (class0.field5 - 6) / 8;
                     var7 = (class0.field5 + 6) / 8;

                     for(var8 = var44 - 1; var8 <= var5 + 1; ++var8) {
                        for(var50 = var47 - 1; var50 <= var7 + 1; ++var50) {
                           if(var8 < var44 || var8 > var5 || var50 < var47 || var50 > var7) {
                              class89.field1563.method3304("m" + var8 + "_" + var50);
                              class89.field1563.method3304("l" + var8 + "_" + var50);
                           }
                        }
                     }
                  }

                  class11.method156(30);
                  class8.method114();
                  class5.field84 = (byte[][][])null;
                  class222.field3180 = (byte[][][])null;
                  class5.field81 = (byte[][][])null;
                  class5.field86 = (byte[][][])null;
                  class19.field286 = (int[][][])null;
                  class216.field3159 = (byte[][][])null;
                  class8.field147 = (int[][])null;
                  class5.field103 = null;
                  class5.field87 = null;
                  class5.field85 = null;
                  class5.field90 = null;
                  class38.field887 = null;
                  field333.method2773(116);
                  class8.method120();
               }
            }
         }
      } else {
         class104.method2348(this);
      }

      if(field299 == 30) {
         class3.method46();
      } else if(field299 == 40 || field299 == 45) {
         class4.method51();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1927182290"
   )
   protected final void vmethod3058() {
      boolean var1;
      label319: {
         try {
            if(class183.field2953 == 2) {
               if(null == class133.field2072) {
                  class133.field2072 = class180.method3556(class20.field582, class21.field589, class213.field3145);
                  if(class133.field2072 == null) {
                     var1 = false;
                     break label319;
                  }
               }

               if(class7.field133 == null) {
                  class7.field133 = new class59(class183.field2954, class183.field2952);
               }

               if(class183.field2955.method3638(class133.field2072, class183.field2958, class7.field133, 22050)) {
                  class183.field2955.method3639();
                  class183.field2955.method3636(class183.field2956);
                  class183.field2955.method3641(class133.field2072, class20.field583);
                  class183.field2953 = 0;
                  class133.field2072 = null;
                  class7.field133 = null;
                  class20.field582 = null;
                  var1 = true;
                  break label319;
               }
            }
         } catch (Exception var16) {
            var16.printStackTrace();
            class183.field2955.method3642();
            class183.field2953 = 0;
            class133.field2072 = null;
            class7.field133 = null;
            class20.field582 = null;
         }

         var1 = false;
      }

      if(var1 && field526 && null != class39.field923) {
         class39.field923.method1241();
      }

      int var5;
      if(field299 == 10 || field299 == 20 || field299 == 30) {
         if(field292 != 0L && class130.method2846() > field292) {
            int var3 = field501?2:1;
            field292 = 0L;
            if(var3 >= 2) {
               field501 = true;
            } else {
               field501 = false;
            }

            class159.method3193();
            if(field299 >= 25) {
               field333.method2773(81);
               class122 var4 = field333;
               var5 = field501?2:1;
               var4.method2654(var5);
               field333.method2540(class30.field708);
               field333.method2540(class153.field2274);
            }

            class144.field2196 = true;
         } else if(class144.field2198) {
            class51.method1134();
         }
      }

      Dimension var11 = this.method3062();
      if(class41.field995 != var11.width || class45.field1055 != var11.height || class144.field2204) {
         class159.method3193();
         field292 = class130.method2846() + 500L;
         class144.field2204 = false;
      }

      boolean var12 = false;
      if(class144.field2196) {
         class144.field2196 = false;
         var12 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field516[var5] = true;
         }
      }

      if(var12) {
         class0.method2();
      }

      int var6;
      if(field299 == 0) {
         class142.method3011(class31.field728, class31.field740, (Color)null, var12);
      } else if(field299 == 5) {
         class156.method3187(class32.field758, class31.field737, class36.field814, var12);
      } else if(field299 != 10 && field299 != 11) {
         if(field299 == 20) {
            class156.method3187(class32.field758, class31.field737, class36.field814, var12);
         } else if(field299 == 25) {
            if(field499 == 1) {
               if(field377 > field479) {
                  field479 = field377;
               }

               var5 = (field479 * 50 - field377 * 50) / field479;
               class33.method747("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field499 == 2) {
               if(field347 > field404) {
                  field404 = field347;
               }

               var5 = 50 + (field404 * 50 - field347 * 50) / field404;
               class33.method747("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class33.method747("Loading - please wait.", false);
            }
         } else if(field299 == 30) {
            if(field391 != -1) {
               class24.method633(field391);
            }

            for(var5 = 0; var5 < field490; ++var5) {
               if(field516[var5]) {
                  field493[var5] = true;
               }

               field427[var5] = field516[var5];
               field516[var5] = false;
            }

            field491 = field301;
            field568 = -1;
            field461 = -1;
            class51.field1165 = null;
            if(field391 != -1) {
               field490 = 0;
               class84.method1965(field391, 0, 0, class30.field708, class153.field2274, 0, 0, -1);
            }

            class79.method1847();
            if(!field310) {
               if(field568 != -1) {
                  var5 = field568;
                  var6 = field461;
                  if(field429 >= 2 || field353 != 0 || field442) {
                     String var7;
                     if(field353 == 1 && field429 < 2) {
                        var7 = "Use" + " " + field441 + " " + "->";
                     } else if(field442 && field429 < 2) {
                        var7 = field445 + " " + field446 + " " + "->";
                     } else {
                        int var9 = field429 - 1;
                        String var8;
                        if(field435[var9].length() > 0) {
                           var8 = field459[var9] + " " + field435[var9];
                        } else {
                           var8 = field459[var9];
                        }

                        var7 = var8;
                     }

                     if(field429 > 2) {
                        var7 = var7 + class164.method3251(16777215) + " " + '/' + " " + (field429 - 2) + " more options";
                     }

                     class32.field758.method4114(var7, var5 + 4, var6 + 15, 16777215, 0, field301 / 1000);
                  }
               }
            } else {
               class14.method178();
            }

            if(field336 == 3) {
               for(var5 = 0; var5 < field490; ++var5) {
                  if(field427[var5]) {
                     class79.method1853(field495[var5], field496[var5], field497[var5], field498[var5], 16711935, 128);
                  } else if(field493[var5]) {
                     class79.method1853(field495[var5], field496[var5], field497[var5], field498[var5], 16711680, 128);
                  }
               }
            }

            class116.method2503(class14.field212, class15.field225.field837, class15.field225.field880, field366);
            field366 = 0;
         } else if(field299 == 40) {
            class33.method747("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field299 == 45) {
            class33.method747("Please wait...", false);
         }
      } else {
         class156.method3187(class32.field758, class31.field737, class36.field814, var12);
      }

      Graphics var13;
      if(field299 == 30 && field336 == 0 && !var12) {
         try {
            var13 = class89.field1567.getGraphics();

            for(var6 = 0; var6 < field490; ++var6) {
               if(field493[var6]) {
                  class12.field196.vmethod1931(var13, field495[var6], field496[var6], field497[var6], field498[var6]);
                  field493[var6] = false;
               }
            }
         } catch (Exception var15) {
            class89.field1567.repaint();
         }
      } else if(field299 > 0) {
         try {
            var13 = class89.field1567.getGraphics();
            class12.field196.vmethod1939(var13, 0, 0);

            for(var6 = 0; var6 < field490; ++var6) {
               field493[var6] = false;
            }
         } catch (Exception var14) {
            class89.field1567.repaint();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1170344243"
   )
   void method255() {
      if(class171.field2731 >= 4) {
         this.method3055("js5crc");
         field299 = 1000;
      } else {
         if(class171.field2716 >= 4) {
            if(field299 <= 5) {
               this.method3055("js5io");
               field299 = 1000;
               return;
            }

            field322 = 3000;
            class171.field2716 = 3;
         }

         if(--field322 + 1 <= 0) {
            try {
               if(field341 == 0) {
                  class33.field777 = class7.field136.method2902(class3.field66, class15.field224);
                  ++field341;
               }

               if(field341 == 1) {
                  if(class33.field777.field2214 == 2) {
                     this.method256(-1);
                     return;
                  }

                  if(class33.field777.field2214 == 1) {
                     ++field341;
                  }
               }

               if(field341 == 2) {
                  class23.field618 = new class143((Socket)class33.field777.field2216, class7.field136);
                  class119 var1 = new class119(5);
                  var1.method2654(15);
                  var1.method2539(117);
                  class23.field618.method3018(var1.field2000, 0, 5);
                  ++field341;
                  class119.field2001 = class130.method2846();
               }

               if(field341 == 3) {
                  if(field299 > 5 && class23.field618.method3012() <= 0) {
                     if(class130.method2846() - class119.field2001 > 30000L) {
                        this.method256(-2);
                        return;
                     }
                  } else {
                     int var2 = class23.field618.method3015();
                     if(var2 != 0) {
                        this.method256(var2);
                        return;
                     }

                     ++field341;
                  }
               }

               if(field341 == 4) {
                  class137.method2961(class23.field618, field299 > 20);
                  class33.field777 = null;
                  class23.field618 = null;
                  field341 = 0;
                  field323 = 0;
               }
            } catch (IOException var3) {
               this.method256(-3);
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "850313670"
   )
   void method256(int var1) {
      class33.field777 = null;
      class23.field618 = null;
      field341 = 0;
      if(class228.field3230 == class15.field224) {
         class15.field224 = class18.field262;
      } else {
         class15.field224 = class228.field3230;
      }

      ++field323;
      if(field323 < 2 || var1 != 7 && var1 != 9) {
         if(field323 >= 2 && var1 == 6) {
            this.method3055("js5connect_outofdate");
            field299 = 1000;
         } else if(field323 >= 4) {
            if(field299 <= 5) {
               this.method3055("js5connect");
               field299 = 1000;
            } else {
               field322 = 3000;
            }
         }
      } else if(field299 <= 5) {
         this.method3055("js5connect_full");
         field299 = 1000;
      } else {
         field322 = 3000;
      }

   }

   static {
      field318 = class20.field575;
      field319 = class20.field575;
      field320 = 0;
      field341 = 0;
      field322 = 0;
      field323 = 0;
      field378 = 0;
      field342 = 0;
      field326 = 0;
      field327 = 0;
      field328 = new class34['耀'];
      field494 = 0;
      field330 = new int['耀'];
      field331 = 0;
      field288 = new int[250];
      field333 = new class122(5000);
      field451 = new class122(5000);
      field335 = new class122(15000);
      field419 = 0;
      field325 = 0;
      field338 = 0;
      field339 = 0;
      field304 = 0;
      field483 = 0;
      field417 = 0;
      field343 = 0;
      field361 = false;
      field377 = 0;
      field479 = 1;
      field347 = 0;
      field404 = 1;
      field499 = 0;
      field350 = new class108[4];
      field351 = false;
      field352 = new int[4][13][13];
      field287 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field382 = 0;
      field550 = 2;
      field356 = 0;
      field357 = 2;
      field358 = 0;
      field289 = 1;
      field345 = 0;
      field500 = 0;
      field362 = 2;
      field363 = 0;
      field503 = 1;
      field359 = 0;
      field366 = 0;
      field367 = 2301979;
      field368 = 5063219;
      field364 = 3353893;
      field370 = 7759444;
      field537 = false;
      field372 = 0;
      field373 = 128;
      field374 = 0;
      field375 = 0;
      field436 = 0;
      field371 = 0;
      field472 = 0;
      field379 = 50;
      field380 = 0;
      field340 = false;
      field556 = 0;
      field383 = 0;
      field384 = 50;
      field385 = new int[field384];
      field528 = new int[field384];
      field387 = new int[field384];
      field388 = new int[field384];
      field389 = new int[field384];
      field390 = new int[field384];
      field487 = new int[field384];
      field334 = new String[field384];
      field337 = new int[104][104];
      field552 = 0;
      field395 = -1;
      field396 = -1;
      field346 = 0;
      field398 = 0;
      field511 = 0;
      field394 = 0;
      field401 = 0;
      field402 = 0;
      field403 = 0;
      field504 = 0;
      field405 = 0;
      field406 = 0;
      field407 = false;
      field471 = 0;
      field409 = 0;
      field302 = new class2[2048];
      field411 = -1;
      field412 = 0;
      field324 = 0;
      field414 = new int[1000];
      field415 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field416 = new String[8];
      field376 = new boolean[8];
      field418 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field464 = -1;
      field572 = new class199[4][104][104];
      field421 = new class199();
      field549 = new class199();
      field423 = new class199();
      field424 = new int[25];
      field425 = new int[25];
      field426 = new int[25];
      field474 = 0;
      field310 = false;
      field429 = 0;
      field434 = new int[500];
      field431 = new int[500];
      field329 = new int[500];
      field433 = new int[500];
      field459 = new String[500];
      field435 = new String[500];
      field568 = -1;
      field461 = -1;
      field438 = 0;
      field439 = 50;
      field353 = 0;
      field441 = null;
      field442 = false;
      field443 = -1;
      field470 = -1;
      field445 = null;
      field446 = null;
      field391 = -1;
      field448 = new class196(8);
      field449 = 0;
      field450 = 0;
      field312 = null;
      field452 = 0;
      field453 = 0;
      field454 = 0;
      field332 = -1;
      field456 = false;
      field534 = false;
      field458 = false;
      field462 = null;
      field428 = null;
      field298 = null;
      field308 = 0;
      field545 = 0;
      field399 = null;
      field465 = false;
      field466 = -1;
      field467 = -1;
      field468 = false;
      field469 = -1;
      field295 = -1;
      field369 = false;
      field563 = 1;
      field408 = new int[32];
      field290 = 0;
      field475 = new int[32];
      field476 = 0;
      field477 = new int[32];
      field478 = 0;
      field481 = 0;
      field480 = 0;
      field542 = 0;
      field562 = 0;
      field535 = 0;
      field527 = 0;
      field485 = 0;
      field486 = new class199();
      field393 = new class199();
      field488 = new class199();
      field489 = new class196(512);
      field490 = 0;
      field491 = -2;
      field516 = new boolean[100];
      field493 = new boolean[100];
      field427 = new boolean[100];
      field495 = new int[100];
      field496 = new int[100];
      field497 = new int[100];
      field498 = new int[100];
      field336 = 0;
      field292 = 0L;
      field501 = true;
      field502 = 765;
      field381 = 503;
      field348 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field505 = 0;
      field506 = 0;
      field507 = "";
      field508 = new long[100];
      field509 = 0;
      field510 = 0;
      field430 = new int[128];
      field512 = new int[128];
      field513 = -1L;
      field514 = null;
      field515 = null;
      field422 = -1;
      field517 = 0;
      field518 = new int[1000];
      field519 = new int[1000];
      field520 = new class78[1000];
      field482 = 0;
      field522 = 0;
      field523 = 0;
      field524 = 255;
      field315 = -1;
      field526 = false;
      field492 = 127;
      field349 = 127;
      field554 = 0;
      field531 = new int[50];
      field532 = new int[50];
      field533 = new int[50];
      field521 = new int[50];
      field392 = new class58[50];
      field536 = false;
      field525 = new boolean[5];
      field538 = new int[5];
      field539 = new int[5];
      field540 = new int[5];
      field541 = new int[5];
      field344 = 256;
      field543 = 205;
      field544 = 256;
      field444 = 320;
      field546 = 1;
      field547 = 32767;
      field420 = 1;
      field565 = 32767;
      field463 = 0;
      field551 = 0;
      field432 = 0;
      field553 = 0;
      field548 = 0;
      field555 = 0;
      field397 = 0;
      field557 = new class17[400];
      field558 = new class195();
      field559 = 0;
      field560 = new class7[400];
      field561 = new class179();
      field303 = -1;
      field400 = -1;
      field564 = new class220[8];
      field365 = -1L;
      field484 = -1L;
      field567 = new class10();
      field321 = new int[50];
      field569 = new int[50];
   }

   public final void init() {
      if(this.method3104()) {
         class190[] var1 = new class190[]{class190.field3067, class190.field3057, class190.field3063, class190.field3062, class190.field3064, class190.field3060, class190.field3055, class190.field3068, class190.field3065, class190.field3058, class190.field3061, class190.field3059, class190.field3066, class190.field3056, class190.field3054};
         class190[] var2 = var1;

         int var3;
         String var5;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class190 var4 = var2[var3];
            var5 = this.getParameter(var4.field3069);
            if(null != var5) {
               switch(Integer.parseInt(var4.field3069)) {
               case 1:
                  field291 = Integer.parseInt(var5);
                  break;
               case 2:
                  field447 = class84.method1964(Integer.parseInt(var5));
                  break;
               case 3:
                  class59.field1236 = var5;
                  break;
               case 4:
                  class14.field220 = Integer.parseInt(var5);
                  break;
               case 5:
                  field293 = Integer.parseInt(var5);
                  break;
               case 6:
                  class43.field1036 = Integer.parseInt(var5);
                  break;
               case 7:
                  if(var5.equalsIgnoreCase("true")) {
                     field410 = true;
                  } else {
                     field410 = false;
                  }
                  break;
               case 8:
                  field297 = Integer.parseInt(var5);
                  break;
               case 9:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 10:
                  field386 = Integer.parseInt(var5);
               case 11:
               case 12:
               case 14:
               default:
                  break;
               case 13:
                  field413 = var5;
                  break;
               case 15:
                  class154[] var6 = new class154[]{class154.field2276, class154.field2282, class154.field2281, class154.field2279, class154.field2277, class154.field2278};
                  class137.field2130 = (class154)class14.method177(var6, Integer.parseInt(var5));
                  if(class154.field2276 == class137.field2130) {
                     field294 = class212.field3140;
                  } else {
                     field294 = class212.field3139;
                  }
               }
            }
         }

         class86.field1498 = false;
         field296 = false;
         class3.field66 = this.getCodeBase().getHost();
         String var36 = field447.field2275;
         byte var17 = 0;

         try {
            class49.field1103 = 16;
            class98.field1674 = var17;

            try {
               class3.field70 = System.getProperty("os.name");
            } catch (Exception var31) {
               class3.field70 = "Unknown";
            }

            class19.field274 = class3.field70.toLowerCase();

            try {
               class149.field2239 = System.getProperty("user.home");
               if(null != class149.field2239) {
                  class149.field2239 = class149.field2239 + "/";
               }
            } catch (Exception var30) {
               ;
            }

            try {
               if(class19.field274.startsWith("win")) {
                  if(class149.field2239 == null) {
                     class149.field2239 = System.getenv("USERPROFILE");
                  }
               } else if(null == class149.field2239) {
                  class149.field2239 = System.getenv("HOME");
               }

               if(class149.field2239 != null) {
                  class149.field2239 = class149.field2239 + "/";
               }
            } catch (Exception var29) {
               ;
            }

            if(class149.field2239 == null) {
               class149.field2239 = "~/";
            }

            class125.field2044 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class149.field2239, "/tmp/", ""};
            class149.field2238 = new String[]{".jagex_cache_" + class98.field1674, ".file_store_" + class98.field1674};
            var3 = 0;

            File var37;
            label292:
            while(var3 < 4) {
               var5 = var3 == 0?"":"" + var3;
               class3.field67 = new File(class149.field2239, "jagex_cl_oldschool_" + var36 + var5 + ".dat");
               String var40 = null;
               String var7 = null;
               boolean var8 = false;
               class119 var10;
               File var43;
               if(class3.field67.exists()) {
                  try {
                     class227 var9 = new class227(class3.field67, "rw", 10000L);

                     int var11;
                     for(var10 = new class119((int)var9.method4150()); var10.field1998 < var10.field2000.length; var10.field1998 += var11) {
                        var11 = var9.method4146(var10.field2000, var10.field1998, var10.field2000.length - var10.field1998);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var10.field1998 = 0;
                     var11 = var10.method2554();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var10.method2554();
                     }

                     if(var11 <= 2) {
                        var40 = var10.method2563();
                        if(var12 == 1) {
                           var7 = var10.method2563();
                        }
                     } else {
                        var40 = var10.method2608();
                        if(var12 == 1) {
                           var7 = var10.method2608();
                        }
                     }

                     var9.method4149();
                  } catch (IOException var34) {
                     var34.printStackTrace();
                  }

                  if(var40 != null) {
                     var43 = new File(var40);
                     if(!var43.exists()) {
                        var40 = null;
                     }
                  }

                  if(null != var40) {
                     var43 = new File(var40, "test.dat");
                     if(!class22.method617(var43, true)) {
                        var40 = null;
                     }
                  }
               }

               if(var40 == null && var3 == 0) {
                  label267:
                  for(int var19 = 0; var19 < class149.field2238.length; ++var19) {
                     for(int var20 = 0; var20 < class125.field2044.length; ++var20) {
                        File var21 = new File(class125.field2044[var20] + class149.field2238[var19] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var21.exists() && class22.method617(new File(var21, "test.dat"), true)) {
                           var40 = var21.toString();
                           var8 = true;
                           break label267;
                        }
                     }
                  }
               }

               if(null == var40) {
                  var40 = class149.field2239 + File.separatorChar + "jagexcache" + var5 + File.separatorChar + "oldschool" + File.separatorChar + var36 + File.separatorChar;
                  var8 = true;
               }

               File var42;
               if(null != var7) {
                  var42 = new File(var7);
                  var43 = new File(var40);

                  try {
                     File[] var45 = var42.listFiles();
                     File[] var22 = var45;

                     for(int var13 = 0; var13 < var22.length; ++var13) {
                        File var14 = var22[var13];
                        File var15 = new File(var43, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var33) {
                     var33.printStackTrace();
                  }

                  var8 = true;
               }

               if(var8) {
                  var42 = new File(var40);
                  var10 = null;

                  try {
                     class227 var46 = new class227(class3.field67, "rw", 10000L);
                     class119 var47 = new class119(500);
                     var47.method2654(3);
                     Object var10001 = null;
                     var47.method2654(0);
                     var47.method2615(var42.getPath());
                     Object var10000 = null;
                     var46.method4158(var47.field2000, 0, var47.field1998);
                     var46.method4149();
                  } catch (IOException var28) {
                     var28.printStackTrace();
                  }
               }

               var37 = new File(var40);
               class27.field674 = var37;
               if(!class27.field674.exists()) {
                  class27.field674.mkdirs();
               }

               File[] var38 = class27.field674.listFiles();
               if(var38 != null) {
                  File[] var44 = var38;

                  for(int var23 = 0; var23 < var44.length; ++var23) {
                     File var24 = var44[var23];
                     if(!class22.method617(var24, false)) {
                        ++var3;
                        continue label292;
                     }
                  }
               }
               break;
            }

            File var18 = class27.field674;
            class135.field2085 = var18;
            if(!class135.field2085.exists()) {
               throw new RuntimeException("");
            }

            class135.field2088 = true;

            try {
               var37 = new File(class149.field2239, "random.dat");
               int var26;
               if(var37.exists()) {
                  class149.field2241 = new class228(new class227(var37, "rw", 25L), 24, 0);
               } else {
                  label216:
                  for(int var25 = 0; var25 < class149.field2238.length; ++var25) {
                     for(var26 = 0; var26 < class125.field2044.length; ++var26) {
                        File var41 = new File(class125.field2044[var26] + class149.field2238[var25] + File.separatorChar + "random.dat");
                        if(var41.exists()) {
                           class149.field2241 = new class228(new class227(var41, "rw", 25L), 24, 0);
                           break label216;
                        }
                     }
                  }
               }

               if(class149.field2241 == null) {
                  RandomAccessFile var39 = new RandomAccessFile(var37, "rw");
                  var26 = var39.read();
                  var39.seek(0L);
                  var39.write(var26);
                  var39.seek(0L);
                  var39.close();
                  class149.field2241 = new class228(new class227(var37, "rw", 25L), 24, 0);
               }
            } catch (IOException var32) {
               ;
            }

            class149.field2237 = new class228(new class227(class16.method193("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class149.field2232 = new class228(new class227(class16.method193("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class17.field257 = new class228[class49.field1103];

            for(int var27 = 0; var27 < class49.field1103; ++var27) {
               class17.field257[var27] = new class228(new class227(class16.method193("main_file_cache.idx" + var27), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var35) {
            class45.method984((String)null, var35);
         }

         field530 = this;
         this.method3044(765, 503, 117);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   protected final void vmethod3056() {
      class228.field3230 = field293 == 0?'ꩊ':'鱀' + field386;
      class18.field262 = field293 == 0?443:'썐' + field386;
      class15.field224 = class228.field3230;
      class179.field2919 = class174.field2895;
      class169.field2701 = class174.field2892;
      class95.field1620 = class174.field2891;
      class179.field2920 = class174.field2894;
      if(class136.field2089.toLowerCase().indexOf("microsoft") != -1) {
         class137.field2103[186] = 57;
         class137.field2103[187] = 27;
         class137.field2103[188] = 71;
         class137.field2103[189] = 26;
         class137.field2103[190] = 72;
         class137.field2103[191] = 73;
         class137.field2103[192] = 58;
         class137.field2103[219] = 42;
         class137.field2103[220] = 74;
         class137.field2103[221] = 43;
         class137.field2103[222] = 59;
         class137.field2103[223] = 28;
      } else {
         class137.field2103[44] = 71;
         class137.field2103[45] = 26;
         class137.field2103[46] = 72;
         class137.field2103[47] = 73;
         class137.field2103[59] = 57;
         class137.field2103[61] = 27;
         class137.field2103[91] = 42;
         class137.field2103[92] = 74;
         class137.field2103[93] = 43;
         class137.field2103[192] = 28;
         class137.field2103[222] = 58;
         class137.field2103[520] = 59;
      }

      class22.method621(class89.field1567);
      class21.method611(class89.field1567);

      class145 var1;
      try {
         var1 = new class145();
      } catch (Throwable var6) {
         var1 = null;
      }

      class122.field2018 = var1;
      if(class122.field2018 != null) {
         class122.field2018.vmethod3135(class89.field1567);
      }

      field566 = new class134(255, class149.field2237, class149.field2232, 500000);
      class20.field580 = class16.method198();
      class121.field2011 = this.getToolkit().getSystemClipboard();
      class26.method675(this, class21.field587);
      if(field293 != 0) {
         field355 = true;
      }

      int var5 = class20.field580.field142;
      field292 = 0L;
      if(var5 >= 2) {
         field501 = true;
      } else {
         field501 = false;
      }

      class159.method3193();
      if(field299 >= 25) {
         field333.method2773(81);
         class122 var3 = field333;
         int var4 = field501?2:1;
         var3.method2654(var4);
         field333.method2540(class30.field708);
         field333.method2540(class153.field2274);
      }

      class144.field2196 = true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1792791927"
   )
   void method285() {
      if(field299 != 1000) {
         long var2 = class130.method2846();
         int var4 = (int)(var2 - class125.field2046);
         class125.field2046 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class171.field2724 += var4;
         boolean var1;
         if(class171.field2721 == 0 && class171.field2714 == 0 && class171.field2719 == 0 && class171.field2730 == 0) {
            var1 = true;
         } else if(class171.field2722 == null) {
            var1 = false;
         } else {
            try {
               label241: {
                  if(class171.field2724 > 30000) {
                     throw new IOException();
                  }

                  class172 var5;
                  class119 var6;
                  while(class171.field2714 < 20 && class171.field2730 > 0) {
                     var5 = (class172)class171.field2713.method3825();
                     var6 = new class119(4);
                     var6.method2654(1);
                     var6.method2541((int)var5.field3115);
                     class171.field2722.method3018(var6.field2000, 0, 4);
                     class171.field2715.method3826(var5, var5.field3115);
                     --class171.field2730;
                     ++class171.field2714;
                  }

                  while(class171.field2721 < 20 && class171.field2719 > 0) {
                     var5 = (class172)class171.field2717.method3915();
                     var6 = new class119(4);
                     var6.method2654(0);
                     var6.method2541((int)var5.field3115);
                     class171.field2722.method3018(var6.field2000, 0, 4);
                     var5.method3922();
                     class171.field2720.method3826(var5, var5.field3115);
                     --class171.field2719;
                     ++class171.field2721;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class171.field2722.method3012();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class171.field2724 = 0;
                     byte var7 = 0;
                     if(null == class142.field2173) {
                        var7 = 8;
                     } else if(class171.field2711 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class171.field2723.field1998;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class171.field2722.method3036(class171.field2723.field2000, class171.field2723.field1998, var8);
                        if(class171.field2729 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class171.field2723.field2000[class171.field2723.field1998 + var9] ^= class171.field2729;
                           }
                        }

                        class171.field2723.field1998 += var8;
                        if(class171.field2723.field1998 < var7) {
                           break;
                        }

                        if(null == class142.field2173) {
                           class171.field2723.field1998 = 0;
                           var9 = class171.field2723.method2554();
                           var10 = class171.field2723.method2556();
                           int var11 = class171.field2723.method2554();
                           var12 = class171.field2723.method2696();
                           long var13 = (long)((var9 << 16) + var10);
                           class172 var15 = (class172)class171.field2715.method3822(var13);
                           class113.field1968 = true;
                           if(var15 == null) {
                              var15 = (class172)class171.field2720.method3822(var13);
                              class113.field1968 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class142.field2173 = var15;
                           class171.field2712 = new class119(var16 + var12 + class142.field2173.field2737);
                           class171.field2712.method2654(var11);
                           class171.field2712.method2539(var12);
                           class171.field2711 = 8;
                           class171.field2723.field1998 = 0;
                        } else if(class171.field2711 == 0) {
                           if(class171.field2723.field2000[0] == -1) {
                              class171.field2711 = 1;
                              class171.field2723.field1998 = 0;
                           } else {
                              class142.field2173 = null;
                           }
                        }
                     } else {
                        var8 = class171.field2712.field2000.length - class142.field2173.field2737;
                        var9 = 512 - class171.field2711;
                        if(var9 > var8 - class171.field2712.field1998) {
                           var9 = var8 - class171.field2712.field1998;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class171.field2722.method3036(class171.field2712.field2000, class171.field2712.field1998, var9);
                        if(class171.field2729 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class171.field2712.field2000[var10 + class171.field2712.field1998] ^= class171.field2729;
                           }
                        }

                        class171.field2712.field1998 += var9;
                        class171.field2711 += var9;
                        if(class171.field2712.field1998 == var8) {
                           if(class142.field2173.field3115 == 16711935L) {
                              class171.field2727 = class171.field2712;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class168 var19 = class171.field2728[var10];
                                 if(var19 != null) {
                                    class171.field2727.field1998 = 5 + 8 * var10;
                                    var12 = class171.field2727.method2696();
                                    int var23 = class171.field2727.method2696();
                                    var19.method3369(var12, var23);
                                 }
                              }
                           } else {
                              class171.field2726.reset();
                              class171.field2726.update(class171.field2712.field2000, 0, var8);
                              var10 = (int)class171.field2726.getValue();
                              if(class142.field2173.field2735 != var10) {
                                 try {
                                    class171.field2722.method3013();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class171.field2731;
                                 class171.field2722 = null;
                                 class171.field2729 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label241;
                              }

                              class171.field2731 = 0;
                              class171.field2716 = 0;
                              class142.field2173.field2741.method3391((int)(class142.field2173.field3115 & 65535L), class171.field2712.field2000, 16711680L == (class142.field2173.field3115 & 16711680L), class113.field1968);
                           }

                           class142.field2173.method3946();
                           if(class113.field1968) {
                              --class171.field2714;
                           } else {
                              --class171.field2721;
                           }

                           class171.field2711 = 0;
                           class142.field2173 = null;
                           class171.field2712 = null;
                        } else {
                           if(class171.field2711 != 512) {
                              break;
                           }

                           class171.field2711 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class171.field2722.method3013();
               } catch (Exception var20) {
                  ;
               }

               ++class171.field2716;
               class171.field2722 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method255();
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-1227729520"
   )
   static boolean method309(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class138.field2133.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class132.method2871(class138.field2136, var2, new Object[]{(new URL(class138.field2136.getCodeBase(), var0)).toString()});
            return null != var3;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class138.field2136.getAppletContext().showDocument(new URL(class138.field2136.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class132.method2865(class138.field2136, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class138.field2136.getAppletContext().showDocument(new URL(class138.field2136.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "155077562"
   )
   protected final void vmethod3059() {
      if(class3.field65.method226()) {
         class3.field65.method227();
      }

      if(field473 != null) {
         field473.field204 = false;
      }

      field473 = null;
      if(null != class172.field2742) {
         class172.field2742.method3013();
         class172.field2742 = null;
      }

      class39.method837();
      if(class140.field2147 != null) {
         class140 var1 = class140.field2147;
         synchronized(class140.field2147) {
            class140.field2147 = null;
         }
      }

      class122.field2018 = null;
      if(null != class39.field923) {
         class39.field923.method1253();
      }

      if(class6.field128 != null) {
         class6.field128.method1253();
      }

      class113.method2493();
      Object var9 = class170.field2705;
      synchronized(class170.field2705) {
         if(class170.field2702 != 0) {
            class170.field2702 = 1;

            try {
               class170.field2705.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      try {
         class149.field2237.method4179();

         for(int var4 = 0; var4 < class49.field1103; ++var4) {
            class17.field257[var4].method4179();
         }

         class149.field2232.method4179();
         class149.field2241.method4179();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   protected final void vmethod3063() {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)[Lclass80;",
      garbageValue = "906021671"
   )
   public static class80[] method595(class167 var0, String var1, String var2) {
      int var3 = var0.method3300(var1);
      int var4 = var0.method3301(var3, var2);
      class80[] var5;
      if(!class94.method2227(var0, var3, var4)) {
         var5 = null;
      } else {
         class80[] var7 = new class80[class76.field1399];

         for(int var8 = 0; var8 < class76.field1399; ++var8) {
            class80 var9 = var7[var8] = new class80();
            var9.field1426 = class76.field1396;
            var9.field1432 = class76.field1398;
            var9.field1433 = class76.field1397[var8];
            var9.field1431 = class52.field1178[var8];
            var9.field1428 = class28.field690[var8];
            var9.field1429 = class31.field744[var8];
            var9.field1427 = class7.field135;
            var9.field1430 = class76.field1400[var8];
         }

         class33.method749();
         var5 = var7;
      }

      return var5;
   }
}
