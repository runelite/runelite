package net.runelite.rs.client;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@Implements("Client")
public final class client extends class143 {
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      longValue = 4579680339242875769L
   )
   static long field273;
   @ObfuscatedName("m")
   static client field274;
   @ObfuscatedName("f")
   static boolean field275 = true;
   @ObfuscatedName("ar")
   static class20 field276;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -607115971
   )
   static int field277 = 0;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -37945593
   )
   static int field278;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1967096469
   )
   static int field279 = 0;
   @ObfuscatedName("t")
   static class211 field280;
   @ObfuscatedName("k")
   static boolean field281 = false;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -654587207
   )
   static int field282 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1519522343
   )
   static int field283 = 0;
   @ObfuscatedName("ot")
   static short field284;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 1995102259
   )
   static int field285;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -61212269
   )
   //@Export("currentPacketOpcode")
   @Export("gameCycle")
   static int field286 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -2769022728186077339L
   )
   static long field287 = 1L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 224726685
   )
   static int field288 = -1;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1591153535
   )
   static int field289;
   @ObfuscatedName("of")
   static int[] field290;
   @ObfuscatedName("ao")
   static boolean field291 = true;
   @ObfuscatedName("as")
   static boolean field292 = false;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -1897538761
   )
   static int field293;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 2011429615
   )
   static int field294;
   @ObfuscatedName("ms")
   static String field295;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 800135253
   )
   @Export("gameState")
   static int field296 = 0;
   @ObfuscatedName("if")
   @Export("menuActions")
   static String[] field297;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 465114441
   )
   static int field298 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2019885767
   )
   static int field299 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -368772735
   )
   static int field300 = 0;
   @ObfuscatedName("fw")
   static int[] field301;
   @ObfuscatedName("lt")
   static long[] field302;
   @ObfuscatedName("ah")
   static class20 field303;
   @ObfuscatedName("ic")
   @Export("componentTable")
   static class195 field304;
   @ObfuscatedName("gy")
   static int[][] field305;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1079475695
   )
   static int field306;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 68867235
   )
   static int field307;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -865928809
   )
   static int field308;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 779781185
   )
   static int field309;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -480660801
   )
   static int field310;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1310052755
   )
   static int field311 = 0;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 878566019
   )
   static int field312;
   @ObfuscatedName("cb")
   @Export("cachedNPCs")
   static class34[] field313;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1044185303
   )
   static int field314;
   @ObfuscatedName("cw")
   static int[] field315;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -2011645887
   )
   static int field316;
   @ObfuscatedName("cz")
   static int[] field317;
   @ObfuscatedName("co")
   static class121 field318;
   @ObfuscatedName("cf")
   static class121 field319;
   @ObfuscatedName("cg")
   static class121 field320;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1094370363
   )
   static int field321;
   @ObfuscatedName("mm")
   static int[] field322;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 291298501
   )
   static int field323;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -307762575
   )
   static int field324;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1969092921
   )
   static int field325;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1235592315
   )
   static int field326;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 426219065
   )
   static int field327;
   @ObfuscatedName("hr")
   static String[] field328;
   @ObfuscatedName("cn")
   static boolean field329;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -1329883747
   )
   static int field330;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 1808636171
   )
   static int field331;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 852577115
   )
   static int field332;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1866672601
   )
   static int field333;
   @ObfuscatedName("nk")
   static boolean field334;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class107[] field335;
   @ObfuscatedName("df")
   static boolean field336;
   @ObfuscatedName("de")
   static int[][][] field337;
   @ObfuscatedName("dp")
   static final int[] field338;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -1878253637
   )
   static int field340;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -2044763201
   )
   static int field341;
   @ObfuscatedName("eg")
   static class78[] field342;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -867572415
   )
   static int field343;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1620224917
   )
   static int field344;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -1122718015
   )
   static int field345;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 1671874609
   )
   static int field346;
   @ObfuscatedName("ho")
   @Export("skillExperiences")
   static int[] field347;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 2122694301
   )
   static int field348;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1815900429
   )
   static int field349 = 0;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 621655289
   )
   static int field350;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -630312437
   )
   static int field351;
   @ObfuscatedName("gc")
   static int[] field352;
   @ObfuscatedName("es")
   static class78[] field353;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 777257733
   )
   static int field354;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -1197929237
   )
   static int field355;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 214818871
   )
   static int field356;
   @ObfuscatedName("km")
   static class198 field357;
   @ObfuscatedName("ek")
   static boolean field358;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 230368721
   )
   static int field359;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -594446545
   )
   static int field360;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -699520387
   )
   static int field361;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1357346165
   )
   static int field362;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 1802345721
   )
   static int field363;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 1103892013
   )
   static int field364;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -492200153
   )
   static int field365;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -534590827
   )
   static int field366;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -301954465
   )
   static int field367;
   @ObfuscatedName("fv")
   static boolean field368;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -375698203
   )
   static int field369;
   @ObfuscatedName("li")
   static boolean[] field370;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -1071825963
   )
   static int field371;
   @ObfuscatedName("ff")
   static int[] field372;
   @ObfuscatedName("fy")
   static int[] field373;
   @ObfuscatedName("jm")
   static boolean field374;
   @ObfuscatedName("fz")
   static int[] field375;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1593250911
   )
   static int field376;
   @ObfuscatedName("fs")
   static int[] field377;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 1789835583
   )
   static int field379;
   @ObfuscatedName("ls")
   static int[] field380;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -12204971
   )
   static int field381;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -748132295
   )
   static int field382;
   @ObfuscatedName("jb")
   static boolean field383;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -2134387403
   )
   static int field384;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 2044301141
   )
   static int field385;
   @ObfuscatedName("ox")
   static short field386;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -223353809
   )
   static int field387;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 2008275499
   )
   static int field388;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1304797297
   )
   static int field389;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1572905549
   )
   static int field390;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -2091183485
   )
   static int field391;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 1688990771
   )
   static int field392;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 58867845
   )
   static int field393;
   @ObfuscatedName("gv")
   static String[] field394;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1209220521
   )
   static int field395;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1674171733
   )
   static int field396;
   @ObfuscatedName("gp")
   @Export("cachedPlayers")
   static class2[] field397;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 705364319
   )
   static int field398;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 1618910479
   )
   static int field399;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 693273397
   )
   static int field400;
   @ObfuscatedName("hh")
   static int[] field401;
   @ObfuscatedName("hg")
   static final int[] field402;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -1185880787
   )
   static int field403;
   @ObfuscatedName("hq")
   static boolean[] field404;
   @ObfuscatedName("hc")
   static int[] field405;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -1329406241
   )
   static int field406;
   @ObfuscatedName("hf")
   @Export("groundItemDeque")
   static class198[][][] field407;
   @ObfuscatedName("hs")
   static class198 field408;
   @ObfuscatedName("hp")
   static class198 field409;
   @ObfuscatedName("or")
   @Export("friends")
   static class17[] field410;
   @ObfuscatedName("hk")
   @Export("boostedSkillLevels")
   static int[] field411;
   @ObfuscatedName("hj")
   @Export("realSkillLevels")
   static int[] field412;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -416179167
   )
   static int field413;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 44418903
   )
   static int field414;
   @ObfuscatedName("iq")
   static int[] field415;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -1603666945
   )
   static int field416;
   @ObfuscatedName("hz")
   static int[] field417;
   @ObfuscatedName("ia")
   static int[] field418;
   @ObfuscatedName("ij")
   static int[] field419;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -1989011859
   )
   static int field420;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1388015669
   )
   @Export("world")
   static int field421 = 1;
   @ObfuscatedName("ig")
   @Export("menuOptions")
   static String[] field422;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -1553556713
   )
   static int field423;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 696099537
   )
   static int field424;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -1581051623
   )
   static int field425;
   @ObfuscatedName("ly")
   @Export("isResized")
   static boolean field426;
   @ObfuscatedName("od")
   static boolean[] field427;
   @ObfuscatedName("it")
   static String field428;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1165783423
   )
   static int field429 = 0;
   @ObfuscatedName("pu")
   static int[] field430;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -779763173
   )
   @Export("weight")
   static int field431;
   @ObfuscatedName("ir")
   static String field432;
   @ObfuscatedName("in")
   static String field433;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1361712145
   )
   static int field434;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 846051083
   )
   static int field435;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -313929469
   )
   static int field436;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 969176369
   )
   static int field437 = 0;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1046352379
   )
   static int field438;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -1870477629
   )
   @Export("energy")
   static int field439;
   @ObfuscatedName("gm")
   static boolean field440;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -1099585805
   )
   static int field441;
   @ObfuscatedName("jt")
   static boolean field442;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -690066517
   )
   static int field443;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1617420523
   )
   static int field444;
   @ObfuscatedName("op")
   @Export("ignores")
   static class7[] field445;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 844913373
   )
   static int field446;
   @ObfuscatedName("jr")
   static class172 field447;
   @ObfuscatedName("jq")
   static class172 field448;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 1181095349
   )
   static int field449;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1614928669
   )
   static int field450;
   @ObfuscatedName("ju")
   static class172 field451;
   @ObfuscatedName("jz")
   static boolean field452;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -1947808287
   )
   static int field453;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -445317115
   )
   static int field454;
   @ObfuscatedName("jd")
   static boolean field455;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 63121645
   )
   static int field456;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 2029370875
   )
   static int field457;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -1975883257
   )
   static int field458;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 1033716797
   )
   static int field459;
   @ObfuscatedName("kq")
   static int[] field460;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1834491441
   )
   static int field461;
   @ObfuscatedName("nc")
   static int[] field462;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -1017714393
   )
   static int field463;
   @ObfuscatedName("kx")
   static int[] field464;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -1848184893
   )
   static int field465;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -160447235
   )
   static int field466;
   @ObfuscatedName("na")
   static int[] field467;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = 1589421313
   )
   static int field468;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -313715885
   )
   static int field469;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -286553513
   )
   static int field470;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -852555161
   )
   static int field471;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -434669729
   )
   static int field472;
   @ObfuscatedName("kg")
   static class198 field473;
   @ObfuscatedName("oa")
   static int[] field474;
   @ObfuscatedName("kc")
   static class198 field475;
   @ObfuscatedName("kn")
   static class195 field476;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -1081337041
   )
   static int field477;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -1604326425
   )
   static int field478;
   @ObfuscatedName("a")
   static class152 field479;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1257207767
   )
   static int field480;
   @ObfuscatedName("lf")
   static boolean[] field481;
   @ObfuscatedName("lx")
   @Export("widgetPositionX")
   static int[] field482;
   @ObfuscatedName("ll")
   @Export("widgetPositionY")
   static int[] field483;
   @ObfuscatedName("lb")
   static int[] field484;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 1973092823
   )
   static int field485;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1268654541
   )
   static int field486 = 0;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      longValue = 5766920155356887845L
   )
   static long field487;
   @ObfuscatedName("oh")
   static short field488;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 912026501
   )
   static int field489;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -719734137
   )
   static int field490;
   @ObfuscatedName("ht")
   static class198 field491;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -25865313
   )
   static int field492;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -651580339
   )
   static int field493;
   @ObfuscatedName("lo")
   static String field494;
   @ObfuscatedName("ma")
   static int[] field495;
   @ObfuscatedName("lu")
   static boolean[] field496;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -1241452441
   )
   static int field497;
   @ObfuscatedName("mb")
   static int[] field498;
   @ObfuscatedName("pe")
   @Export("grandExchangeOffers")
   static class219[] field499;
   @ObfuscatedName("hm")
   static boolean field500;
   @ObfuscatedName("mk")
   static String field501;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -848289679
   )
   static int field502 = 0;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -374387103
   )
   static int field503;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = -416658187
   )
   static int field504;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -652707607
   )
   static int field505;
   @ObfuscatedName("mw")
   static int[] field506;
   @ObfuscatedName("mi")
   static class78[] field507;
   @ObfuscatedName("ku")
   static int[] field508;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1950674331
   )
   static int field509;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 933393677
   )
   static int field510;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 720648789
   )
   static int field511;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 1578557839
   )
   static int field512;
   @ObfuscatedName("mg")
   static boolean field513;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1974027943
   )
   static int field514;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 1678680535
   )
   static int field515;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -2137460621
   )
   static int field516;
   @ObfuscatedName("jy")
   static boolean field517;
   @ObfuscatedName("nt")
   static int[] field518;
   @ObfuscatedName("nu")
   static int[] field519;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1734478289
   )
   static int field520;
   @ObfuscatedName("nv")
   static class58[] field521;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 1023885593
   )
   static int field522;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 661905227
   )
   static int field523;
   @ObfuscatedName("ok")
   static int[] field524;
   @ObfuscatedName("og")
   static int[] field525;
   @ObfuscatedName("lk")
   static int[] field526;
   @ObfuscatedName("s")
   static boolean field527 = false;
   @ObfuscatedName("om")
   static short field528;
   @ObfuscatedName("ol")
   static short field529;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = 403468721
   )
   static int field530;
   @ObfuscatedName("oc")
   static short field531;
   @ObfuscatedName("v")
   static boolean field532 = true;
   @ObfuscatedName("oe")
   static short field533;
   @ObfuscatedName("oi")
   static short field534;
   @ObfuscatedName("jk")
   static class172 field535;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 385474235
   )
   static int field536;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = 1434000773
   )
   static int field537;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 1797905553
   )
   @Export("camera2")
   static int field538;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 294769919
   )
   @Export("camera3")
   static int field539;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 163765829
   )
   @Export("scale")
   static int field540;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = -662591399
   )
   static int field541;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 725102147
   )
   static int field542;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = -2117644975
   )
   static int field543;
   @ObfuscatedName("on")
   static class194 field544;
   @ObfuscatedName("jf")
   static class172 field545;
   @ObfuscatedName("ie")
   static boolean field546;
   @ObfuscatedName("pi")
   static class178 field547;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 369530941
   )
   static int field548;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = -982558985
   )
   static int field549;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1123520575
   )
   static int field550 = -1;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      longValue = -1881151082275210915L
   )
   static long field551;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      longValue = -5451699647267115039L
   )
   static long field552;
   @ObfuscatedName("pf")
   static final class10 field553;
   @ObfuscatedName("fi")
   static int[] field554;
   @ObfuscatedName("pw")
   static int[] field555;

   public final void init() {
      if(this.method3045()) {
         class189[] var1 = class151.method3186();

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            class189 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3055);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3055)) {
               case 3:
                  field421 = Integer.parseInt(var4);
                  break;
               case 4:
                  field283 = Integer.parseInt(var4);
                  break;
               case 5:
                  field277 = Integer.parseInt(var4);
                  break;
               case 6:
                  class52.field1146 = Integer.parseInt(var4);
                  break;
               case 7:
                  if(var4.equalsIgnoreCase("true")) {
                     field281 = true;
                  } else {
                     field281 = false;
                  }
               case 8:
               default:
                  break;
               case 9:
                  field279 = Integer.parseInt(var4);
                  break;
               case 10:
                  class35.field773 = Integer.parseInt(var4);
                  break;
               case 11:
                  var6 = Integer.parseInt(var4);
                  class152[] var7 = class142.method3039();
                  int var8 = 0;

                  class152 var5;
                  while(true) {
                     if(var8 >= var7.length) {
                        var5 = null;
                        break;
                     }

                     class152 var9 = var7[var8];
                     if(var6 == var9.field2266) {
                        var5 = var9;
                        break;
                     }

                     ++var8;
                  }

                  field479 = var5;
                  break;
               case 12:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 13:
                  class11.field165 = var4;
                  break;
               case 14:
                  class12.field184 = var4;
                  break;
               case 15:
                  class168.field2687 = (class153)class23.method634(class102.method2321(), Integer.parseInt(var4));
                  if(class153.field2273 == class168.field2687) {
                     field280 = class211.field3125;
                  } else {
                     field280 = class211.field3118;
                  }
               }
            }
         }

         class161.method3228();
         class41.field959 = this.getCodeBase().getHost();
         String var14 = field479.field2263;
         byte var15 = 0;

         try {
            class148.field2215 = 16;
            class20.field562 = var15;

            try {
               class13.field199 = System.getProperty("os.name");
            } catch (Exception var12) {
               class13.field199 = "Unknown";
            }

            class1.field29 = class13.field199.toLowerCase();

            try {
               class0.field14 = System.getProperty("user.home");
               if(class0.field14 != null) {
                  class0.field14 = class0.field14 + "/";
               }
            } catch (Exception var11) {
               ;
            }

            try {
               if(class1.field29.startsWith("win")) {
                  if(class0.field14 == null) {
                     class0.field14 = System.getenv("USERPROFILE");
                  }
               } else if(null == class0.field14) {
                  class0.field14 = System.getenv("HOME");
               }

               if(null != class0.field14) {
                  class0.field14 = class0.field14 + "/";
               }
            } catch (Exception var10) {
               ;
            }

            if(class0.field14 == null) {
               class0.field14 = "~/";
            }

            class188.field3036 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class0.field14, "/tmp/", ""};
            class14.field209 = new String[]{".jagex_cache_" + class20.field562, ".file_store_" + class20.field562};

            label123:
            for(int var16 = 0; var16 < 4; ++var16) {
               class148.field2226 = class139.method3005("oldschool", var14, var16);
               if(!class148.field2226.exists()) {
                  class148.field2226.mkdirs();
               }

               File[] var18 = class148.field2226.listFiles();
               if(var18 == null) {
                  break;
               }

               File[] var20 = var18;
               var6 = 0;

               while(true) {
                  if(var6 >= var20.length) {
                     break label123;
                  }

                  File var21 = var20[var6];
                  if(!class0.method3(var21, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            File var17 = class148.field2226;
            class134.field2065 = var17;
            if(!class134.field2065.exists()) {
               throw new RuntimeException("");
            }

            class134.field2066 = true;
            class107.method2449();
            class148.field2221 = new class227(new class226(class51.method1093("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class148.field2222 = new class227(new class226(class51.method1093("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class33.field747 = new class227[class148.field2215];

            for(int var19 = 0; var19 < class148.field2215; ++var19) {
               class33.field747[var19] = new class227(new class226(class51.method1093("main_file_cache.idx" + var19), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var13) {
            class37.method803((String)null, var13);
         }

         field274 = this;
         this.method3140(765, 503, 100);
      }
   }

   @ObfuscatedName("i")
   protected final void vmethod3050() {
      if(class83.field1439.method225()) {
         class83.field1439.method227();
      }

      if(class161.field2632 != null) {
         class161.field2632.field200 = false;
      }

      class161.field2632 = null;
      if(class11.field170 != null) {
         class11.field170.method3022();
         class11.field170 = null;
      }

      class93.method2181();
      if(class139.field2141 != null) {
         class139 var1 = class139.field2141;
         synchronized(class139.field2141) {
            class139.field2141 = null;
         }
      }

      class113.field1954 = null;
      if(class15.field212 != null) {
         class15.field212.method1221();
      }

      if(null != class29.field675) {
         class29.field675.method1221();
      }

      class2.method42();
      Object var8 = class169.field2690;
      synchronized(class169.field2690) {
         if(class169.field2693 != 0) {
            class169.field2693 = 1;

            try {
               class169.field2690.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      try {
         class148.field2221.method4189();

         for(int var9 = 0; var9 < class148.field2215; ++var9) {
            class33.field747[var9].method4189();
         }

         class148.field2222.method4189();
         class148.field2220.method4189();
      } catch (Exception var6) {
         ;
      }

   }

   @ObfuscatedName("k")
   void method273() {
      if(field296 != 1000) {
         boolean var1 = class92.method2180();
         if(!var1) {
            this.method274();
         }

      }
   }

   @ObfuscatedName("s")
   void method274() {
      if(class170.field2695 >= 4) {
         this.method3058("js5crc");
         field296 = 1000;
      } else {
         if(class170.field2704 >= 4) {
            if(field296 <= 5) {
               this.method3058("js5io");
               field296 = 1000;
               return;
            }

            field388 = 3000;
            class170.field2704 = 3;
         }

         if(--field388 + 1 <= 0) {
            try {
               if(0 == field505) {
                  class46.field1045 = class25.field630.method2915(class41.field959, class15.field219);
                  ++field505;
               }

               if(1 == field505) {
                  if(class46.field1045.field2198 == 2) {
                     this.method275(-1);
                     return;
                  }

                  if(1 == class46.field1045.field2198) {
                     ++field505;
                  }
               }

               if(2 == field505) {
                  class10.field160 = new class142((Socket)class46.field1045.field2204, class25.field630);
                  class118 var1 = new class118(5);
                  var1.method2521(15);
                  var1.method2524(100);
                  class10.field160.method3042(var1.field1980, 0, 5);
                  ++field505;
                  class77.field1384 = class92.method2177();
               }

               if(3 == field505) {
                  if(field296 > 5 && class10.field160.method3024() <= 0) {
                     if(class92.method2177() - class77.field1384 > 30000L) {
                        this.method275(-2);
                        return;
                     }
                  } else {
                     int var9 = class10.field160.method3023();
                     if(var9 != 0) {
                        this.method275(var9);
                        return;
                     }

                     ++field505;
                  }
               }

               if(4 == field505) {
                  class142 var10 = class10.field160;
                  boolean var2 = field296 > 20;
                  if(class170.field2715 != null) {
                     try {
                        class170.field2715.method3022();
                     } catch (Exception var7) {
                        ;
                     }

                     class170.field2715 = null;
                  }

                  class170.field2715 = var10;
                  class132.method2893(var2);
                  class170.field2709.field1981 = 0;
                  class47.field1054 = null;
                  class170.field2708 = null;
                  class170.field2714 = 0;

                  while(true) {
                     class171 var3 = (class171)class170.field2703.method3835();
                     if(var3 == null) {
                        while(true) {
                           var3 = (class171)class170.field2705.method3835();
                           if(null == var3) {
                              if(class170.field2713 != 0) {
                                 try {
                                    class118 var11 = new class118(4);
                                    var11.method2521(4);
                                    var11.method2521(class170.field2713);
                                    var11.method2522(0);
                                    class170.field2715.method3042(var11.field1980, 0, 4);
                                 } catch (IOException var6) {
                                    try {
                                       class170.field2715.method3022();
                                    } catch (Exception var5) {
                                       ;
                                    }

                                    ++class170.field2704;
                                    class170.field2715 = null;
                                 }
                              }

                              class170.field2696 = 0;
                              class170.field2697 = class92.method2177();
                              class46.field1045 = null;
                              class10.field160 = null;
                              field505 = 0;
                              field308 = 0;
                              return;
                           }

                           class170.field2707.method3933(var3);
                           class170.field2716.method3839(var3, var3.field3104);
                           ++class170.field2700;
                           --class170.field2706;
                        }
                     }

                     class170.field2698.method3839(var3, var3.field3104);
                     ++class170.field2699;
                     --class170.field2701;
                  }
               }
            } catch (IOException var8) {
               this.method275(-3);
            }

         }
      }
   }

   @ObfuscatedName("w")
   void method275(int var1) {
      class46.field1045 = null;
      class10.field160 = null;
      field505 = 0;
      if(class10.field164 == class15.field219) {
         class15.field219 = class120.field1989;
      } else {
         class15.field219 = class10.field164;
      }

      ++field308;
      if(field308 < 2 || 7 != var1 && var1 != 9) {
         if(field308 >= 2 && 6 == var1) {
            this.method3058("js5connect_outofdate");
            field296 = 1000;
         } else if(field308 >= 4) {
            if(field296 <= 5) {
               this.method3058("js5connect");
               field296 = 1000;
            } else {
               field388 = 3000;
            }
         }
      } else if(field296 <= 5) {
         this.method3058("js5connect_full");
         field296 = 1000;
      } else {
         field388 = 3000;
      }

   }

   @ObfuscatedName("h")
   protected final void vmethod3056() {
      boolean var1 = class135.method2911();
      if(var1 && field513 && null != class15.field212) {
         class15.field212.method1264();
      }

      if(10 == field296 || 20 == field296 || 30 == field296) {
         if(0L != field487 && class92.method2177() > field487) {
            int var15 = class27.method688();
            field487 = 0L;
            if(var15 >= 2) {
               field426 = true;
            } else {
               field426 = false;
            }

            class125.method2846();
            if(field296 >= 25) {
               class19.method256();
            }

            class143.field2186 = true;
         } else if(class143.field2189) {
            Canvas var2 = class17.field244;
            var2.removeKeyListener(class136.field2100);
            var2.removeFocusListener(class136.field2100);
            class136.field2104 = -1;
            Canvas var3 = class17.field244;
            var3.removeMouseListener(class139.field2141);
            var3.removeMouseMotionListener(class139.field2141);
            var3.removeFocusListener(class139.field2141);
            class139.field2145 = 0;
            if(class113.field1954 != null) {
               class113.field1954.vmethod3147(class17.field244);
            }

            field274.method3051();
            class17.field244.setBackground(Color.black);
            Canvas var4 = class17.field244;
            var4.setFocusTraversalKeysEnabled(false);
            var4.addKeyListener(class136.field2100);
            var4.addFocusListener(class136.field2100);
            class37.method801(class17.field244);
            if(null != class113.field1954) {
               class113.field1954.vmethod3148(class17.field244);
            }

            if(field438 != -1) {
               class24.method639(false);
            }

            class143.field2191 = true;
         }
      }

      Dimension var16 = this.method3060();
      if(class18.field252 != var16.width || class22.field585 != var16.height || class143.field2191) {
         class125.method2846();
         field487 = class92.method2177() + 500L;
         class143.field2191 = false;
      }

      boolean var17 = false;
      int var18;
      if(class143.field2186) {
         class143.field2186 = false;
         var17 = true;

         for(var18 = 0; var18 < 100; ++var18) {
            field370[var18] = true;
         }
      }

      if(var17) {
         class17.method213();
      }

      if(0 == field296) {
         var18 = class31.field707;
         String var5 = class31.field700;
         Color var6 = null;

         try {
            Graphics var7 = class17.field244.getGraphics();
            if(class50.field1084 == null) {
               class50.field1084 = new Font("Helvetica", 1, 13);
               class86.field1512 = class17.field244.getFontMetrics(class50.field1084);
            }

            if(var17) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, class129.field2048, class136.field2101);
            }

            if(null == var6) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(class103.field1760 == null) {
                  class103.field1760 = class17.field244.createImage(304, 34);
               }

               Graphics var8 = class103.field1760.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, 3 * var18, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(3 * var18 + 2, 2, 300 - var18 * 3, 30);
               var8.setFont(class50.field1084);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - class86.field1512.stringWidth(var5)) / 2, 22);
               var7.drawImage(class103.field1760, class129.field2048 / 2 - 152, class136.field2101 / 2 - 18, (ImageObserver)null);
            } catch (Exception var11) {
               int var9 = class129.field2048 / 2 - 152;
               int var10 = class136.field2101 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(var9 + 2, var10 + 2, 3 * var18, 30);
               var7.setColor(Color.black);
               var7.drawRect(1 + var9, var10 + 1, 301, 31);
               var7.fillRect(var18 * 3 + 2 + var9, 2 + var10, 300 - 3 * var18, 30);
               var7.setFont(class50.field1084);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - class86.field1512.stringWidth(var5)) / 2, 22 + var10);
            }
         } catch (Exception var12) {
            class17.field244.repaint();
         }
      } else if(field296 == 5) {
         class74.method1627(class143.field2174, class88.field1532, class8.field139, var17);
      } else if(10 != field296 && field296 != 11) {
         if(20 == field296) {
            class74.method1627(class143.field2174, class88.field1532, class8.field139, var17);
         } else if(field296 == 25) {
            if(field485 == 1) {
               if(field330 > field331) {
                  field331 = field330;
               }

               var18 = (field331 * 50 - field330 * 50) / field331;
               class40.method880("Loading - please wait." + "<br>" + " (" + var18 + "%" + ")", false);
            } else if(2 == field485) {
               if(field332 > field333) {
                  field333 = field332;
               }

               var18 = (field333 * 50 - field332 * 50) / field333 + 50;
               class40.method880("Loading - please wait." + "<br>" + " (" + var18 + "%" + ")", false);
            } else {
               class40.method880("Loading - please wait.", false);
            }
         } else if(30 == field296) {
            class28.method698();
         } else if(40 == field296) {
            class40.method880("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field296 == 45) {
            class40.method880("Please wait...", false);
         }
      } else {
         class74.method1627(class143.field2174, class88.field1532, class8.field139, var17);
      }

      int var19;
      Graphics var20;
      if(field296 == 30 && field316 == 0 && !var17) {
         try {
            var20 = class17.field244.getGraphics();

            for(var19 = 0; var19 < field477; ++var19) {
               if(field496[var19]) {
                  class84.field1440.vmethod1897(var20, field482[var19], field483[var19], field484[var19], field526[var19]);
                  field496[var19] = false;
               }
            }
         } catch (Exception var14) {
            class17.field244.repaint();
         }
      } else if(field296 > 0) {
         try {
            var20 = class17.field244.getGraphics();
            class84.field1440.vmethod1895(var20, 0, 0);

            for(var19 = 0; var19 < field477; ++var19) {
               field496[var19] = false;
            }
         } catch (Exception var13) {
            class17.field244.repaint();
         }
      }

   }

   @ObfuscatedName("m")
   protected final void vmethod3061() {
   }

   static {
      field276 = class20.field560;
      field303 = class20.field560;
      field321 = 0;
      field505 = 0;
      field388 = 0;
      field308 = 0;
      field309 = 0;
      field310 = 0;
      field307 = 0;
      field312 = 0;
      field313 = new class34['耀'];
      field314 = 0;
      field315 = new int['耀'];
      field444 = 0;
      field317 = new int[250];
      field318 = new class121(5000);
      field319 = new class121(5000);
      field320 = new class121(15000);
      field289 = 0;
      field446 = 0;
      field323 = 0;
      field324 = 0;
      field325 = 0;
      field326 = 0;
      field327 = 0;
      field400 = 0;
      field329 = false;
      field330 = 0;
      field331 = 1;
      field332 = 0;
      field333 = 1;
      field485 = 0;
      field335 = new class107[4];
      field336 = false;
      field337 = new int[4][13][13];
      field338 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field522 = 0;
      field340 = 2;
      field341 = 0;
      field392 = 2;
      field343 = 0;
      field344 = 1;
      field345 = 0;
      field346 = 0;
      field443 = 2;
      field348 = 0;
      field356 = 1;
      field350 = 0;
      field420 = 0;
      field480 = 2301979;
      field376 = 5063219;
      field384 = 3353893;
      field278 = 7759444;
      field358 = false;
      field359 = 0;
      field360 = 128;
      field434 = 0;
      field362 = 0;
      field363 = 0;
      field364 = 0;
      field365 = 0;
      field366 = 50;
      field367 = 0;
      field368 = false;
      field369 = 0;
      field385 = 0;
      field371 = 50;
      field372 = new int[field371];
      field373 = new int[field371];
      field301 = new int[field371];
      field375 = new int[field371];
      field554 = new int[field371];
      field377 = new int[field371];
      field352 = new int[field371];
      field394 = new String[field371];
      field305 = new int[104][104];
      field381 = 0;
      field382 = 1;
      field395 = 1;
      field520 = 0;
      field399 = 0;
      field361 = 0;
      field387 = 0;
      field306 = 0;
      field389 = 0;
      field390 = 0;
      field391 = 0;
      field509 = 0;
      field393 = 0;
      field440 = false;
      field489 = 0;
      field396 = 0;
      field397 = new class2[2048];
      field523 = -1;
      field351 = 0;
      field413 = 0;
      field401 = new int[1000];
      field402 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field328 = new String[8];
      field404 = new boolean[8];
      field405 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field406 = -1;
      field407 = new class198[4][104][104];
      field408 = new class198();
      field409 = new class198();
      field491 = new class198();
      field411 = new int[25];
      field412 = new int[25];
      field347 = new int[25];
      field414 = 0;
      field500 = false;
      field416 = 0;
      field417 = new int[500];
      field418 = new int[500];
      field419 = new int[500];
      field415 = new int[500];
      field297 = new String[500];
      field422 = new String[500];
      field423 = -1;
      field424 = -1;
      field425 = 0;
      field285 = 50;
      field398 = 0;
      field428 = null;
      field546 = false;
      field355 = -1;
      field379 = -1;
      field432 = null;
      field433 = null;
      field438 = -1;
      field304 = new class195(8);
      field436 = 0;
      field293 = 0;
      field545 = null;
      field439 = 0;
      field431 = 0;
      field441 = 0;
      field463 = -1;
      field383 = false;
      field442 = false;
      field374 = false;
      field535 = null;
      field447 = null;
      field448 = null;
      field449 = 0;
      field450 = 0;
      field451 = null;
      field452 = false;
      field453 = -1;
      field454 = -1;
      field455 = false;
      field456 = -1;
      field457 = -1;
      field517 = false;
      field459 = 1;
      field460 = new int[32];
      field461 = 0;
      field508 = new int[32];
      field530 = 0;
      field464 = new int[32];
      field465 = 0;
      field466 = 0;
      field458 = 0;
      field468 = 0;
      field469 = 0;
      field470 = 0;
      field471 = 0;
      field472 = 0;
      field473 = new class198();
      field357 = new class198();
      field475 = new class198();
      field476 = new class195(512);
      field477 = 0;
      field478 = -2;
      field370 = new boolean[100];
      field496 = new boolean[100];
      field481 = new boolean[100];
      field482 = new int[100];
      field483 = new int[100];
      field484 = new int[100];
      field526 = new int[100];
      field316 = 0;
      field487 = 0L;
      field426 = true;
      field511 = 1;
      field490 = 1;
      field380 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field492 = 0;
      field493 = 0;
      field494 = "";
      field302 = new long[100];
      field403 = 0;
      field497 = 0;
      field498 = new int[128];
      field495 = new int[128];
      field273 = -1L;
      field501 = null;
      field295 = null;
      field503 = 1;
      field504 = 0;
      field322 = new int[1000];
      field506 = new int[1000];
      field507 = new class78[1000];
      field537 = 0;
      field294 = 0;
      field510 = 0;
      field543 = 255;
      field512 = -1;
      field513 = false;
      field514 = 127;
      field515 = 127;
      field516 = 0;
      field462 = new int[50];
      field518 = new int[50];
      field519 = new int[50];
      field467 = new int[50];
      field521 = new class58[50];
      field334 = false;
      field427 = new boolean[5];
      field524 = new int[5];
      field525 = new int[5];
      field290 = new int[5];
      field474 = new int[5];
      field528 = 256;
      field529 = 205;
      field488 = 256;
      field531 = 320;
      field386 = 1;
      field533 = 32767;
      field534 = 1;
      field284 = 32767;
      field536 = 0;
      field435 = 0;
      field538 = 0;
      field539 = 0;
      field540 = 0;
      field541 = 0;
      field542 = 0;
      field410 = new class17[400];
      field544 = new class194();
      field354 = 0;
      field445 = new class7[400];
      field547 = new class178();
      field548 = 1;
      field549 = 1;
      field499 = new class219[8];
      field551 = -1L;
      field552 = -1L;
      field553 = new class10();
      field430 = new int[50];
      field555 = new int[50];
   }

   @ObfuscatedName("u")
   protected final void vmethod3054() {
      class10.field164 = field279 == 0?'ꩊ':'鱀' + field421;
      class120.field1989 = field279 == 0?443:field421 + '썐';
      class15.field219 = class10.field164;
      class9.field154 = class173.field2872;
      class118.field1979 = class173.field2869;
      class45.field1023 = class173.field2870;
      class178.field2904 = class173.field2871;
      class153.method3200();
      Canvas var1 = class17.field244;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class136.field2100);
      var1.addFocusListener(class136.field2100);
      class37.method801(class17.field244);

      class144 var2;
      try {
         var2 = new class144();
      } catch (Throwable var4) {
         var2 = null;
      }

      class113.field1954 = var2;
      if(class113.field1954 != null) {
         class113.field1954.vmethod3148(class17.field244);
      }

      class44.field1022 = new class133(255, class148.field2221, class148.field2222, 500000);
      class153.field2277 = class141.method3020();
      class50.field1085 = this.getToolkit().getSystemClipboard();
      class103.method2325(this, class42.field984);
      if(0 != field279) {
         field292 = true;
      }

      int var3 = class153.field2277.field132;
      field487 = 0L;
      if(var3 >= 2) {
         field426 = true;
      } else {
         field426 = false;
      }

      class125.method2846();
      if(field296 >= 25) {
         class19.method256();
      }

      class143.field2186 = true;
   }

   @ObfuscatedName("a")
   protected final void vmethod3096() {
      ++field286;
      this.method273();

      while(true) {
         class198 var2 = class169.field2694;
         class168 var1;
         synchronized(class169.field2694) {
            var1 = (class168)class169.field2691.method3869();
         }

         if(null == var1) {
            int var25;
            try {
               if(class182.field2940 == 1) {
                  var25 = class182.field2943.method3653();
                  if(var25 > 0 && class182.field2943.method3659()) {
                     var25 -= class173.field2874;
                     if(var25 < 0) {
                        var25 = 0;
                     }

                     class182.field2943.method3652(var25);
                  } else {
                     class182.field2943.method3658();
                     class182.field2943.method3656();
                     if(class188.field3038 != null) {
                        class182.field2940 = 2;
                     } else {
                        class182.field2940 = 0;
                     }

                     class147.field2213 = null;
                     class86.field1518 = null;
                  }
               }
            } catch (Exception var24) {
               var24.printStackTrace();
               class182.field2943.method3658();
               class182.field2940 = 0;
               class147.field2213 = null;
               class86.field1518 = null;
               class188.field3038 = null;
            }

            class130.method2869();
            class159.method3222();
            class92.method2178();
            if(null != class113.field1954) {
               var25 = class113.field1954.vmethod3146();
               field472 = var25;
            }

            if(0 == field296) {
               class48.method1035();
               class45.field1026.vmethod3155();

               for(var25 = 0; var25 < 32; ++var25) {
                  class143.field2182[var25] = 0L;
               }

               for(var25 = 0; var25 < 32; ++var25) {
                  class143.field2183[var25] = 0L;
               }

               class102.field1751 = 0;
            } else if(5 == field296) {
               class5.method59();
               class48.method1035();
               class59.method1308();
            } else if(10 != field296 && 11 != field296) {
               if(20 == field296) {
                  class5.method59();
                  class34.method766();
               } else if(25 == field296) {
                  class132.method2891();
               }
            } else {
               class5.method59();
            }

            if(field296 == 30) {
               if(field486 > 1) {
                  --field486;
               }

               if(field400 > 0) {
                  --field400;
               }

               if(field329) {
                  field329 = false;
                  if(field400 > 0) {
                     class77.method1699();
                  } else {
                     class31.method714(40);
                     class8.field138 = class11.field170;
                     class11.field170 = null;
                  }
               } else {
                  if(!field500) {
                     field297[0] = "Cancel";
                     field422[0] = "";
                     field419[0] = 1006;
                     field416 = 1;
                  }

                  int var3;
                  int var5;
                  int var6;
                  class172 var7;
                  int var15;
                  int var16;
                  boolean var26;
                  int var27;
                  String var32;
                  int var39;
                  boolean var40;
                  String var41;
                  class172 var43;
                  int var46;
                  int var47;
                  int var59;
                  int var61;
                  int var70;
                  boolean var88;
                  boolean var92;
                  long var104;
                  for(var25 = 0; var25 < 100; ++var25) {
                     if(class11.field170 == null) {
                        var26 = false;
                     } else {
                        label3956: {
                           String var4;
                           try {
                              var3 = class11.field170.method3024();
                              if(var3 == 0) {
                                 var26 = false;
                                 break label3956;
                              }

                              if(-1 == field446) {
                                 class11.field170.method3028(field320.field1980, 0, 1);
                                 field320.field1981 = 0;
                                 field446 = field320.method2796();
                                 field289 = class187.field3035[field446];
                                 --var3;
                              }

                              if(field289 == -1) {
                                 if(var3 <= 0) {
                                    var26 = false;
                                    break label3956;
                                 }

                                 class11.field170.method3028(field320.field1980, 0, 1);
                                 field289 = field320.field1980[0] & 255;
                                 --var3;
                              }

                              if(field289 == -2) {
                                 if(var3 <= 1) {
                                    var26 = false;
                                    break label3956;
                                 }

                                 class11.field170.method3028(field320.field1980, 0, 2);
                                 field320.field1981 = 0;
                                 field289 = field320.method2538();
                                 var3 -= 2;
                              }

                              if(var3 < field289) {
                                 var26 = false;
                                 break label3956;
                              }

                              field320.field1981 = 0;
                              class11.field170.method3028(field320.field1980, 0, field289);
                              field323 = 0;
                              field327 = field326;
                              field326 = field325 * -1;
                              field325 = field446 * -1;
                              if(92 == field446) {
                                 field334 = true;
                                 class123.field2021 = field320.method2536();
                                 class76.field1378 = field320.method2536();
                                 class133.field2060 = field320.method2538();
                                 class31.field724 = field320.method2536();
                                 class208.field3105 = field320.method2536();
                                 if(class208.field3105 >= 100) {
                                    var27 = 64 + class123.field2021 * 128;
                                    var5 = 64 + class76.field1378 * 128;
                                    var6 = class34.method774(var27, var5, class8.field134) - class133.field2060;
                                    var39 = var27 - class29.field672;
                                    var47 = var6 - class132.field2053;
                                    var46 = var5 - class76.field1374;
                                    var61 = (int)Math.sqrt((double)(var39 * var39 + var46 * var46));
                                    class11.field169 = (int)(Math.atan2((double)var47, (double)var61) * 325.949D) & 2047;
                                    class83.field1434 = (int)(Math.atan2((double)var39, (double)var46) * -325.949D) & 2047;
                                    if(class11.field169 < 128) {
                                       class11.field169 = 128;
                                    }

                                    if(class11.field169 > 383) {
                                       class11.field169 = 383;
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(188 == field446) {
                                 var4 = field320.method2544();
                                 Object[] var111 = new Object[var4.length() + 1];

                                 for(var6 = var4.length() - 1; var6 >= 0; --var6) {
                                    if(var4.charAt(var6) == 115) {
                                       var111[var6 + 1] = field320.method2544();
                                    } else {
                                       var111[1 + var6] = new Integer(field320.method2541());
                                    }
                                 }

                                 var111[0] = new Integer(field320.method2541());
                                 class0 var108 = new class0();
                                 var108.field10 = var111;
                                 class171.method3458(var108);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              class121 var89;
                              if(185 == field446) {
                                 class114.method2467(false);
                                 field320.method2796();
                                 var27 = field320.method2538();
                                 var89 = field320;
                                 var6 = var89.field1981;
                                 class32.field740 = 0;
                                 class50.method1065(var89);
                                 class48.method1037(var89);
                                 if(var27 != var89.field1981 - var6) {
                                    throw new RuntimeException(var89.field1981 - var6 + " " + var27);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(33 == field446) {
                                 field542 = 1;
                                 field458 = field459;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              boolean var53;
                              if(239 == field446) {
                                 var4 = field320.method2544();
                                 var5 = field320.method2538();
                                 byte var106 = field320.method2537();
                                 var53 = false;
                                 if(-128 == var106) {
                                    var53 = true;
                                 }

                                 if(var53) {
                                    if(class41.field964 == 0) {
                                       field446 = -1;
                                       var26 = true;
                                       break label3956;
                                    }

                                    var92 = false;

                                    for(var47 = 0; var47 < class41.field964 && (!class98.field1667[var47].field604.equals(var4) || class98.field1667[var47].field606 != var5); ++var47) {
                                       ;
                                    }

                                    if(var47 < class41.field964) {
                                       while(var47 < class41.field964 - 1) {
                                          class98.field1667[var47] = class98.field1667[1 + var47];
                                          ++var47;
                                       }

                                       --class41.field964;
                                       class98.field1667[class41.field964] = null;
                                    }
                                 } else {
                                    field320.method2544();
                                    class24 var101 = new class24();
                                    var101.field604 = var4;
                                    var101.field605 = class140.method3010(var101.field604, field280);
                                    var101.field606 = var5;
                                    var101.field607 = var106;

                                    for(var46 = class41.field964 - 1; var46 >= 0; --var46) {
                                       var61 = class98.field1667[var46].field605.compareTo(var101.field605);
                                       if(0 == var61) {
                                          class98.field1667[var46].field606 = var5;
                                          class98.field1667[var46].field607 = var106;
                                          if(var4.equals(class0.field12.field34)) {
                                             class139.field2137 = var106;
                                          }

                                          field468 = field459;
                                          field446 = -1;
                                          var26 = true;
                                          break label3956;
                                       }

                                       if(var61 < 0) {
                                          break;
                                       }
                                    }

                                    if(class41.field964 >= class98.field1667.length) {
                                       field446 = -1;
                                       var26 = true;
                                       break label3956;
                                    }

                                    for(var61 = class41.field964 - 1; var61 > var46; --var61) {
                                       class98.field1667[var61 + 1] = class98.field1667[var61];
                                    }

                                    if(0 == class41.field964) {
                                       class98.field1667 = new class24[100];
                                    }

                                    class98.field1667[var46 + 1] = var101;
                                    ++class41.field964;
                                    if(var4.equals(class0.field12.field34)) {
                                       class139.field2137 = var106;
                                    }
                                 }

                                 field468 = field459;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              class172 var38;
                              if(field446 == 35) {
                                 var27 = field320.method2580();
                                 var5 = field320.method2538();
                                 var38 = class48.method1036(var27);
                                 if(2 != var38.field2777 || var38.field2776 != var5) {
                                    var38.field2777 = 2;
                                    var38.field2776 = var5;
                                    class42.method942(var38);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(137 == field446) {
                                 field429 = field320.method2536();
                                 if(field429 == 1) {
                                    field311 = field320.method2538();
                                 }

                                 if(field429 >= 2 && field429 <= 6) {
                                    if(2 == field429) {
                                       field300 = 64;
                                       field349 = 64;
                                    }

                                    if(field429 == 3) {
                                       field300 = 0;
                                       field349 = 64;
                                    }

                                    if(field429 == 4) {
                                       field300 = 128;
                                       field349 = 64;
                                    }

                                    if(field429 == 5) {
                                       field300 = 64;
                                       field349 = 0;
                                    }

                                    if(field429 == 6) {
                                       field300 = 64;
                                       field349 = 128;
                                    }

                                    field429 = 2;
                                    field502 = field320.method2538();
                                    field437 = field320.method2538();
                                    field299 = field320.method2536();
                                 }

                                 if(10 == field429) {
                                    field282 = field320.method2538();
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              long var9;
                              long var13;
                              long var97;
                              if(field446 == 79) {
                                 var4 = field320.method2544();
                                 var104 = field320.method2734();
                                 var97 = (long)field320.method2538();
                                 var9 = (long)field320.method2540();
                                 class151[] var84 = new class151[]{class151.field2253, class151.field2249, class151.field2252, class151.field2250, class151.field2251};
                                 class151 var77 = (class151)class23.method634(var84, field320.method2536());
                                 var13 = var9 + (var97 << 32);
                                 boolean var100 = false;

                                 for(var16 = 0; var16 < 100; ++var16) {
                                    if(var13 == field302[var16]) {
                                       var100 = true;
                                       break;
                                    }
                                 }

                                 if(var77.field2257 && class40.method881(var4)) {
                                    var100 = true;
                                 }

                                 if(!var100 && field396 == 0) {
                                    field302[field403] = var13;
                                    field403 = (field403 + 1) % 100;
                                    String var95 = class222.method4107(class126.method2858(class150.method3183(field320)));
                                    if(var77.field2255 != -1) {
                                       class86.method2096(9, class19.method265(var77.field2255) + var4, var95, class16.method211(var104));
                                    } else {
                                       class86.method2096(9, var4, var95, class16.method211(var104));
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 147) {
                                 field537 = field320.method2536();
                                 if(255 == field537) {
                                    field537 = 0;
                                 }

                                 field294 = field320.method2536();
                                 if(field294 == 255) {
                                    field294 = 0;
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(207 == field446) {
                                 var27 = field320.method2561();
                                 var32 = field320.method2544();
                                 var6 = field320.method2563();
                                 if(var6 >= 1 && var6 <= 8) {
                                    if(var32.equalsIgnoreCase("null")) {
                                       var32 = null;
                                    }

                                    field328[var6 - 1] = var32;
                                    field404[var6 - 1] = var27 == 0;
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 19) {
                                 field334 = false;

                                 for(var27 = 0; var27 < 5; ++var27) {
                                    field427[var27] = false;
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 203) {
                                 var27 = field320.method2541();
                                 var5 = field320.method2538();
                                 if(var27 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var27 >= 0) {
                                    var38 = class48.method1036(var27);
                                 } else {
                                    var38 = null;
                                 }

                                 if(null != var38) {
                                    for(var39 = 0; var39 < var38.field2850.length; ++var39) {
                                       var38.field2850[var39] = 0;
                                       var38.field2851[var39] = 0;
                                    }
                                 }

                                 class28.method694(var5);
                                 var39 = field320.method2538();

                                 for(var47 = 0; var47 < var39; ++var47) {
                                    var46 = field320.method2563();
                                    if(255 == var46) {
                                       var46 = field320.method2581();
                                    }

                                    var61 = field320.method2572();
                                    if(var38 != null && var47 < var38.field2850.length) {
                                       var38.field2850[var47] = var61;
                                       var38.field2851[var47] = var46;
                                    }

                                    class50.method1061(var5, var47, var61 - 1, var46);
                                 }

                                 if(var38 != null) {
                                    class42.method942(var38);
                                 }

                                 class56.method1261();
                                 field508[++field530 - 1 & 31] = var5 & 32767;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 74) {
                                 var27 = field320.method2663();
                                 var5 = field320.method2571();
                                 var6 = var5 >> 10 & 31;
                                 var39 = var5 >> 5 & 31;
                                 var47 = var5 & 31;
                                 var46 = (var39 << 11) + (var6 << 19) + (var47 << 3);
                                 class172 var85 = class48.method1036(var27);
                                 if(var85.field2824 != var46) {
                                    var85.field2824 = var46;
                                    class42.method942(var85);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 111) {
                                 var27 = field320.method2538();
                                 var5 = field320.method2581();
                                 var6 = field320.method2572();
                                 var7 = class48.method1036(var5);
                                 var7.field2797 = (var27 << 16) + var6;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(127 == field446) {
                                 var27 = field320.method2571();
                                 field438 = var27;
                                 class24.method639(false);
                                 class43.method956(var27);
                                 class93.method2182(field438);

                                 for(var5 = 0; var5 < 100; ++var5) {
                                    field370[var5] = true;
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 126) {
                                 field468 = field459;
                                 if(field289 == 0) {
                                    field501 = null;
                                    field295 = null;
                                    class41.field964 = 0;
                                    class98.field1667 = null;
                                    field446 = -1;
                                    var26 = true;
                                    break label3956;
                                 }

                                 field295 = field320.method2544();
                                 long var110 = field320.method2734();
                                 field501 = class45.method989(var110);
                                 class5.field91 = field320.method2537();
                                 var6 = field320.method2536();
                                 if(255 == var6) {
                                    field446 = -1;
                                    var26 = true;
                                    break label3956;
                                 }

                                 class41.field964 = var6;
                                 class24[] var103 = new class24[100];

                                 for(var47 = 0; var47 < class41.field964; ++var47) {
                                    var103[var47] = new class24();
                                    var103[var47].field604 = field320.method2544();
                                    var103[var47].field605 = class140.method3010(var103[var47].field604, field280);
                                    var103[var47].field606 = field320.method2538();
                                    var103[var47].field607 = field320.method2537();
                                    field320.method2544();
                                    if(var103[var47].field604.equals(class0.field12.field34)) {
                                       class139.field2137 = var103[var47].field607;
                                    }
                                 }

                                 var92 = false;
                                 var61 = class41.field964;

                                 while(var61 > 0) {
                                    var92 = true;
                                    --var61;

                                    for(var59 = 0; var59 < var61; ++var59) {
                                       if(var103[var59].field605.compareTo(var103[var59 + 1].field605) > 0) {
                                          class24 var82 = var103[var59];
                                          var103[var59] = var103[1 + var59];
                                          var103[var59 + 1] = var82;
                                          var92 = false;
                                       }
                                    }

                                    if(var92) {
                                       break;
                                    }
                                 }

                                 class98.field1667 = var103;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(234 == field446) {
                                 class25 var109 = new class25();
                                 var109.field624 = field320.method2544();
                                 var109.field621 = field320.method2538();
                                 var5 = field320.method2541();
                                 var109.field622 = var5;
                                 class31.method714(45);
                                 class11.field170.method3022();
                                 class11.field170 = null;
                                 class26.method675(var109);
                                 field446 = -1;
                                 var26 = false;
                                 break label3956;
                              }

                              if(field446 == 100) {
                                 field486 = field320.method2572() * 30;
                                 field471 = field459;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(88 == field446) {
                                 class56.method1261();
                                 field431 = field320.method2539();
                                 field471 = field459;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(43 == field446) {
                                 var4 = field320.method2544();
                                 var32 = class222.method4107(class126.method2858(class150.method3183(field320)));
                                 class50.method1063(6, var4, var32);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 201) {
                                 var27 = field320.method2539();
                                 var5 = field320.method2573();
                                 var6 = field320.method2541();
                                 var7 = class48.method1036(var6);
                                 if(var27 != var7.field2743 || var5 != var7.field2792 || 0 != var7.field2739 || var7.field2740 != 0) {
                                    var7.field2743 = var27;
                                    var7.field2792 = var5;
                                    var7.field2739 = 0;
                                    var7.field2740 = 0;
                                    class42.method942(var7);
                                    class15.method194(var7);
                                    if(0 == var7.field2736) {
                                       class33.method754(class172.field2857[var6 >> 16], var7, false);
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(59 == field446) {
                                 field492 = field320.method2536();
                                 field493 = field320.method2536();
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(123 == field446) {
                                 var27 = field320.method2548();
                                 var40 = field320.method2536() == 1;
                                 var41 = "";
                                 var53 = false;
                                 if(var40) {
                                    var41 = field320.method2544();
                                    if(class40.method881(var41)) {
                                       var53 = true;
                                    }
                                 }

                                 String var87 = field320.method2544();
                                 if(!var53) {
                                    class50.method1063(var27, var41, var87);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 20) {
                                 class13.field198 = field320.method2563();
                                 class123.field2019 = field320.method2536();
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(171 == field446) {
                                 var27 = field320.method2581();
                                 var5 = field320.method2574();
                                 var38 = class48.method1036(var27);
                                 if(var38.field2802 != var5 || -1 == var5) {
                                    var38.field2802 = var5;
                                    var38.field2854 = 0;
                                    var38.field2773 = 0;
                                    class42.method942(var38);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(40 == field446) {
                                 for(var27 = 0; var27 < class52.field1143; ++var27) {
                                    class52 var98 = (class52)class52.field1144.method3808((long)var27);
                                    class52 var105;
                                    if(var98 != null) {
                                       var105 = var98;
                                    } else {
                                       byte[] var99 = class52.field1149.method3352(16, var27);
                                       var98 = new class52();
                                       if(var99 != null) {
                                          var98.method1117(new class118(var99));
                                       }

                                       class52.field1144.method3805(var98, (long)var27);
                                       var105 = var98;
                                    }

                                    if(var105 != null) {
                                       class175.field2887[var27] = 0;
                                       class175.field2884[var27] = 0;
                                    }
                                 }

                                 class56.method1261();
                                 field461 += 32;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              long var11;
                              int var14;
                              if(field446 == 178) {
                                 var4 = field320.method2544();
                                 var104 = (long)field320.method2538();
                                 var97 = (long)field320.method2540();
                                 class151[] var78 = new class151[]{class151.field2253, class151.field2249, class151.field2252, class151.field2250, class151.field2251};
                                 class151 var74 = (class151)class23.method634(var78, field320.method2536());
                                 var11 = var97 + (var104 << 32);
                                 boolean var83 = false;

                                 for(var14 = 0; var14 < 100; ++var14) {
                                    if(var11 == field302[var14]) {
                                       var83 = true;
                                       break;
                                    }
                                 }

                                 if(class40.method881(var4)) {
                                    var83 = true;
                                 }

                                 if(!var83 && field396 == 0) {
                                    field302[field403] = var11;
                                    field403 = (1 + field403) % 100;
                                    String var93 = class222.method4107(class126.method2858(class150.method3183(field320)));
                                    byte var94;
                                    if(var74.field2256) {
                                       var94 = 7;
                                    } else {
                                       var94 = 3;
                                    }

                                    if(-1 != var74.field2255) {
                                       class50.method1063(var94, class19.method265(var74.field2255) + var4, var93);
                                    } else {
                                       class50.method1063(var94, var4, var93);
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(24 == field446) {
                                 var27 = field320.method2572();
                                 if(var27 == '\uffff') {
                                    var27 = -1;
                                 }

                                 var5 = field320.method2663();
                                 var6 = field320.method2541();
                                 var39 = field320.method2572();
                                 if(var39 == '\uffff') {
                                    var39 = -1;
                                 }

                                 for(var47 = var39; var47 <= var27; ++var47) {
                                    var9 = ((long)var6 << 32) + (long)var47;
                                    class207 var72 = field476.method3836(var9);
                                    if(var72 != null) {
                                       var72.method3965();
                                    }

                                    field476.method3839(new class200(var5), var9);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 139) {
                                 field334 = true;
                                 class35.field776 = field320.method2536();
                                 class118.field1988 = field320.method2536();
                                 class50.field1088 = field320.method2538();
                                 class115.field1963 = field320.method2536();
                                 class88.field1540 = field320.method2536();
                                 if(class88.field1540 >= 100) {
                                    class29.field672 = class35.field776 * 128 + 64;
                                    class76.field1374 = 64 + class118.field1988 * 128;
                                    class132.field2053 = class34.method774(class29.field672, class76.field1374, class8.field134) - class50.field1088;
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(173 == field446) {
                                 var27 = field320.method2538();
                                 var5 = field320.method2536();
                                 var6 = field320.method2538();
                                 class38.method805(var27, var5, var6);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(210 == field446 || field446 == 143 || 34 == field446 || 236 == field446 || field446 == 213 || 238 == field446 || field446 == 116 || 73 == field446 || field446 == 226 || 62 == field446) {
                                 class4.method47();
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 31) {
                                 var27 = field320.method2663();
                                 var43 = class48.method1036(var27);

                                 for(var6 = 0; var6 < var43.field2850.length; ++var6) {
                                    var43.field2850[var6] = -1;
                                    var43.field2850[var6] = 0;
                                 }

                                 class42.method942(var43);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              class172 var42;
                              if(field446 == 93) {
                                 var27 = field320.method2570();
                                 var5 = field320.method2570();
                                 var6 = field320.method2581();
                                 var39 = field320.method2572();
                                 var42 = class48.method1036(var6);
                                 if(var39 != var42.field2783 || var5 != var42.field2760 || var27 != var42.field2787) {
                                    var42.field2783 = var39;
                                    var42.field2760 = var5;
                                    var42.field2787 = var27;
                                    class42.method942(var42);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 39) {
                                 class121 var107 = field320;
                                 var5 = field289;
                                 var6 = var107.field1981;
                                 class32.field740 = 0;
                                 class50.method1065(var107);
                                 class48.method1037(var107);
                                 if(var107.field1981 - var6 != var5) {
                                    throw new RuntimeException(var107.field1981 - var6 + " " + var5);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 41) {
                                 field320.field1981 += 28;
                                 if(field320.method2557()) {
                                    class140.method3013(field320, field320.field1981 - 28);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(26 == field446) {
                                 class140.method3014(field320.method2544());
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 189) {
                                 for(var27 = 0; var27 < class175.field2884.length; ++var27) {
                                    if(class175.field2887[var27] != class175.field2884[var27]) {
                                       class175.field2884[var27] = class175.field2887[var27];
                                       class132.method2896(var27);
                                       field460[++field461 - 1 & 31] = var27;
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 28) {
                                 var27 = field320.method2536();
                                 var5 = field320.method2536();
                                 var6 = field320.method2536();
                                 var39 = field320.method2536();
                                 field427[var27] = true;
                                 field524[var27] = var5;
                                 field525[var27] = var6;
                                 field290[var27] = var39;
                                 field474[var27] = 0;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              class3 var35;
                              if(field446 == 32) {
                                 var27 = field320.method2563();
                                 var5 = field320.method2538();
                                 var6 = field320.method2581();
                                 var35 = (class3)field304.method3836((long)var6);
                                 if(null != var35) {
                                    class7.method125(var35, var5 != var35.field63);
                                 }

                                 class3 var79 = new class3();
                                 var79.field63 = var5;
                                 var79.field61 = var27;
                                 field304.method3839(var79, (long)var6);
                                 class43.method956(var5);
                                 class172 var73 = class48.method1036(var6);
                                 class42.method942(var73);
                                 if(field545 != null) {
                                    class42.method942(field545);
                                    field545 = null;
                                 }

                                 for(var61 = 0; var61 < field416; ++var61) {
                                    if(class120.method2775(field419[var61])) {
                                       if(var61 < field416 - 1) {
                                          for(var59 = var61; var59 < field416 - 1; ++var59) {
                                             field297[var59] = field297[var59 + 1];
                                             field422[var59] = field422[var59 + 1];
                                             field419[var59] = field419[1 + var59];
                                             field415[var59] = field415[var59 + 1];
                                             field417[var59] = field417[1 + var59];
                                             field418[var59] = field418[var59 + 1];
                                          }
                                       }

                                       --field416;
                                    }
                                 }

                                 class33.method754(class172.field2857[var6 >> 16], var73, false);
                                 class93.method2182(var5);
                                 if(-1 != field438) {
                                    class15.method198(field438, 1);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 136) {
                                 class56.method1261();
                                 var27 = field320.method2536();
                                 var5 = field320.method2561();
                                 var6 = field320.method2663();
                                 field347[var27] = var6;
                                 field411[var27] = var5;
                                 field412[var27] = 1;

                                 for(var39 = 0; var39 < 98; ++var39) {
                                    if(var6 >= class154.field2285[var39]) {
                                       field412[var27] = 2 + var39;
                                    }
                                 }

                                 field464[++field465 - 1 & 31] = var27;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 146) {
                                 var27 = field320.method2541();
                                 var5 = field320.method2538();
                                 if(var27 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var27 >= 0) {
                                    var38 = class48.method1036(var27);
                                 } else {
                                    var38 = null;
                                 }

                                 for(; field320.field1981 < field289; class50.method1061(var5, var39, var47 - 1, var46)) {
                                    var39 = field320.method2548();
                                    var47 = field320.method2538();
                                    var46 = 0;
                                    if(0 != var47) {
                                       var46 = field320.method2536();
                                       if(var46 == 255) {
                                          var46 = field320.method2541();
                                       }
                                    }

                                    if(null != var38 && var39 >= 0 && var39 < var38.field2850.length) {
                                       var38.field2850[var39] = var47;
                                       var38.field2851[var39] = var46;
                                    }
                                 }

                                 if(var38 != null) {
                                    class42.method942(var38);
                                 }

                                 class56.method1261();
                                 field508[++field530 - 1 & 31] = var5 & 32767;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(108 == field446) {
                                 class123.field2019 = field320.method2536();
                                 class13.field198 = field320.method2563();

                                 while(field320.field1981 < field289) {
                                    field446 = field320.method2536();
                                    class4.method47();
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 191) {
                                 class114.method2467(true);
                                 field320.method2796();
                                 var27 = field320.method2538();
                                 var89 = field320;
                                 var6 = var89.field1981;
                                 class32.field740 = 0;
                                 class50.method1065(var89);
                                 class48.method1037(var89);
                                 if(var27 != var89.field1981 - var6) {
                                    throw new RuntimeException(var89.field1981 - var6 + " " + var27);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 50) {
                                 var88 = field320.method2536() == 1;
                                 if(var88) {
                                    class34.field759 = class92.method2177() - field320.method2734();
                                    class143.field2193 = new class220(field320, true);
                                 } else {
                                    class143.field2193 = null;
                                 }

                                 field470 = field459;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(237 == field446) {
                                 var5 = field320.method2536();
                                 class129[] var62 = new class129[]{class129.field2043, class129.field2047, class129.field2045};
                                 class129[] var80 = var62;
                                 var47 = 0;

                                 class129 var102;
                                 while(true) {
                                    if(var47 >= var80.length) {
                                       var102 = null;
                                       break;
                                    }

                                    class129 var57 = var80[var47];
                                    if(var57.field2046 == var5) {
                                       var102 = var57;
                                       break;
                                    }

                                    ++var47;
                                 }

                                 class163.field2640 = var102;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(219 == field446) {
                                 class72.method1600(false);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 172) {
                                 var88 = field320.method2559() == 1;
                                 var5 = field320.method2580();
                                 var38 = class48.method1036(var5);
                                 if(var88 != var38.field2724) {
                                    var38.field2724 = var88;
                                    class42.method942(var38);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(38 == field446) {
                                 var27 = field320.method2541();
                                 var5 = field320.method2570();
                                 var38 = class48.method1036(var27);
                                 if(1 != var38.field2777 || var5 != var38.field2776) {
                                    var38.field2777 = 1;
                                    var38.field2776 = var5;
                                    class42.method942(var38);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 141) {
                                 var27 = field320.method2663();
                                 var5 = field320.method2571();
                                 var38 = class48.method1036(var27);
                                 if(var38 != null && var38.field2736 == 0) {
                                    if(var5 > var38.field2765 - var38.field2750) {
                                       var5 = var38.field2765 - var38.field2750;
                                    }

                                    if(var5 < 0) {
                                       var5 = 0;
                                    }

                                    if(var38.field2762 != var5) {
                                       var38.field2762 = var5;
                                       class42.method942(var38);
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 12) {
                                 var27 = field320.method2541();
                                 class4.field68 = class25.field630.method2916(var27);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(161 == field446) {
                                 var27 = field320.method2541();
                                 class3 var65 = (class3)field304.method3836((long)var27);
                                 if(var65 != null) {
                                    class7.method125(var65, true);
                                 }

                                 if(null != field545) {
                                    class42.method942(field545);
                                    field545 = null;
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(208 == field446) {
                                 while(field320.field1981 < field289) {
                                    var88 = field320.method2536() == 1;
                                    var32 = field320.method2544();
                                    var41 = field320.method2544();
                                    var39 = field320.method2538();
                                    var47 = field320.method2536();
                                    var46 = field320.method2536();
                                    boolean var63 = 0 != (var46 & 2);
                                    boolean var64 = (var46 & 1) != 0;
                                    if(var39 > 0) {
                                       field320.method2544();
                                       field320.method2536();
                                       field320.method2541();
                                    }

                                    field320.method2544();

                                    for(var70 = 0; var70 < field541; ++var70) {
                                       class17 var81 = field410[var70];
                                       if(!var88) {
                                          if(var32.equals(var81.field237)) {
                                             if(var81.field238 != var39) {
                                                boolean var86 = true;

                                                for(class38 var91 = (class38)field544.method3826(); null != var91; var91 = (class38)field544.method3827()) {
                                                   if(var91.field859.equals(var32)) {
                                                      if(0 != var39 && 0 == var91.field860) {
                                                         var91.method3963();
                                                         var86 = false;
                                                      } else if(0 == var39 && var91.field860 != 0) {
                                                         var91.method3963();
                                                         var86 = false;
                                                      }
                                                   }
                                                }

                                                if(var86) {
                                                   field544.method3834(new class38(var32, var39));
                                                }

                                                var81.field238 = var39;
                                             }

                                             var81.field241 = var41;
                                             var81.field239 = var47;
                                             var81.field243 = var63;
                                             var81.field240 = var64;
                                             var32 = null;
                                             break;
                                          }
                                       } else if(var41.equals(var81.field237)) {
                                          var81.field237 = var32;
                                          var81.field241 = var41;
                                          var32 = null;
                                          break;
                                       }
                                    }

                                    if(var32 != null && field541 < 400) {
                                       class17 var75 = new class17();
                                       field410[field541] = var75;
                                       var75.field237 = var32;
                                       var75.field241 = var41;
                                       var75.field238 = var39;
                                       var75.field239 = var47;
                                       var75.field243 = var63;
                                       var75.field240 = var64;
                                       ++field541;
                                    }
                                 }

                                 field542 = 2;
                                 field458 = field459;
                                 var88 = false;
                                 var5 = field541;

                                 while(var5 > 0) {
                                    var88 = true;
                                    --var5;

                                    for(var6 = 0; var6 < var5; ++var6) {
                                       var53 = false;
                                       class17 var66 = field410[var6];
                                       class17 var54 = field410[var6 + 1];
                                       if(var66.field238 != field421 && field421 == var54.field238) {
                                          var53 = true;
                                       }

                                       if(!var53 && 0 == var66.field238 && 0 != var54.field238) {
                                          var53 = true;
                                       }

                                       if(!var53 && !var66.field243 && var54.field243) {
                                          var53 = true;
                                       }

                                       if(!var53 && !var66.field240 && var54.field240) {
                                          var53 = true;
                                       }

                                       if(var53) {
                                          class17 var68 = field410[var6];
                                          field410[var6] = field410[1 + var6];
                                          field410[1 + var6] = var68;
                                          var88 = false;
                                       }
                                    }

                                    if(var88) {
                                       break;
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 95) {
                                 class72.method1600(true);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 223) {
                                 field510 = field320.method2536();
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(224 == field446) {
                                 var27 = field320.method2571();
                                 var5 = field320.method2581();
                                 class175.field2887[var27] = var5;
                                 if(var5 != class175.field2884[var27]) {
                                    class175.field2884[var27] = var5;
                                    class132.method2896(var27);
                                 }

                                 field460[++field461 - 1 & 31] = var27;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 170) {
                                 var27 = field320.method2538();
                                 if('\uffff' == var27) {
                                    var27 = -1;
                                 }

                                 if(var27 == -1 && !field513) {
                                    class182.field2943.method3658();
                                    class182.field2940 = 1;
                                    class188.field3038 = null;
                                 } else if(var27 != -1 && var27 != field512 && field543 != 0 && !field513) {
                                    class167 var49 = class142.field2165;
                                    var6 = field543;
                                    class182.field2940 = 1;
                                    class188.field3038 = var49;
                                    class182.field2945 = var27;
                                    class35.field778 = 0;
                                    class182.field2942 = var6;
                                    class158.field2586 = false;
                                    class173.field2874 = 2;
                                 }

                                 field512 = var27;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(235 == field446) {
                                 var27 = field320.method2570();
                                 if(var27 == '\uffff') {
                                    var27 = -1;
                                 }

                                 var5 = field320.method2576();
                                 if(field543 != 0 && var27 != -1) {
                                    class41.method903(class118.field1985, var27, 0, field543, false);
                                    field513 = true;
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(245 == field446) {
                                 var27 = field320.method2541();
                                 var43 = class48.method1036(var27);
                                 var43.field2777 = 3;
                                 var43.field2776 = class0.field12.field31.method3558();
                                 class42.method942(var43);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 1) {
                                 byte var67 = field320.method2564();
                                 var5 = field320.method2572();
                                 class175.field2887[var5] = var67;
                                 if(class175.field2884[var5] != var67) {
                                    class175.field2884[var5] = var67;
                                    class132.method2896(var5);
                                 }

                                 field460[++field461 - 1 & 31] = var5;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 252) {
                                 while(field320.field1981 < field289) {
                                    var27 = field320.method2536();
                                    var40 = (var27 & 1) == 1;
                                    var41 = field320.method2544();
                                    String var51 = field320.method2544();
                                    field320.method2544();

                                    for(var47 = 0; var47 < field354; ++var47) {
                                       class7 var52 = field445[var47];
                                       if(var40) {
                                          if(var51.equals(var52.field130)) {
                                             var52.field130 = var41;
                                             var52.field126 = var51;
                                             var41 = null;
                                             break;
                                          }
                                       } else if(var41.equals(var52.field130)) {
                                          var52.field130 = var41;
                                          var52.field126 = var51;
                                          var41 = null;
                                          break;
                                       }
                                    }

                                    if(var41 != null && field354 < 400) {
                                       class7 var60 = new class7();
                                       field445[field354] = var60;
                                       var60.field130 = var41;
                                       var60.field126 = var51;
                                       ++field354;
                                    }
                                 }

                                 field458 = field459;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(106 == field446) {
                                 class77.method1699();
                                 field446 = -1;
                                 var26 = false;
                                 break label3956;
                              }

                              if(field446 == 36) {
                                 class21.method598(field320);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(101 == field446) {
                                 var27 = field320.method2572();
                                 class15 var37 = (class15)class15.field216.method3836((long)var27);
                                 if(var37 != null) {
                                    var37.method3965();
                                 }

                                 field508[++field530 - 1 & 31] = var27 & 32767;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(167 == field446) {
                                 class123.field2019 = field320.method2561();
                                 class13.field198 = field320.method2563();

                                 for(var27 = class123.field2019; var27 < 8 + class123.field2019; ++var27) {
                                    for(var5 = class13.field198; var5 < 8 + class13.field198; ++var5) {
                                       if(field407[class8.field134][var27][var5] != null) {
                                          field407[class8.field134][var27][var5] = null;
                                          class172.method3482(var27, var5);
                                       }
                                    }
                                 }

                                 for(class16 var58 = (class16)field408.method3871(); var58 != null; var58 = (class16)field408.method3873()) {
                                    if(var58.field224 >= class123.field2019 && var58.field224 < 8 + class123.field2019 && var58.field225 >= class13.field198 && var58.field225 < 8 + class13.field198 && var58.field226 == class8.field134) {
                                       var58.field233 = 0;
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 27) {
                                 class56.method1261();
                                 field439 = field320.method2536();
                                 field471 = field459;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 131) {
                                 var27 = field320.method2580();
                                 var32 = field320.method2544();
                                 var38 = class48.method1036(var27);
                                 if(!var32.equals(var38.field2756)) {
                                    var38.field2756 = var32;
                                    class42.method942(var38);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(196 == field446) {
                                 var27 = field320.field1981 + field289;
                                 var5 = field320.method2538();
                                 var6 = field320.method2538();
                                 if(var5 != field438) {
                                    field438 = var5;
                                    class24.method639(false);
                                    class43.method956(field438);
                                    class93.method2182(field438);

                                    for(var39 = 0; var39 < 100; ++var39) {
                                       field370[var39] = true;
                                    }
                                 }

                                 class3 var10;
                                 for(; var6-- > 0; var10.field62 = true) {
                                    var39 = field320.method2541();
                                    var47 = field320.method2538();
                                    var46 = field320.method2536();
                                    var10 = (class3)field304.method3836((long)var39);
                                    if(var10 != null && var47 != var10.field63) {
                                       class7.method125(var10, true);
                                       var10 = null;
                                    }

                                    if(var10 == null) {
                                       class3 var12 = new class3();
                                       var12.field63 = var47;
                                       var12.field61 = var46;
                                       field304.method3839(var12, (long)var39);
                                       class43.method956(var47);
                                       class172 var76 = class48.method1036(var39);
                                       class42.method942(var76);
                                       if(field545 != null) {
                                          class42.method942(field545);
                                          field545 = null;
                                       }

                                       for(var14 = 0; var14 < field416; ++var14) {
                                          if(class120.method2775(field419[var14])) {
                                             if(var14 < field416 - 1) {
                                                for(var15 = var14; var15 < field416 - 1; ++var15) {
                                                   field297[var15] = field297[1 + var15];
                                                   field422[var15] = field422[1 + var15];
                                                   field419[var15] = field419[var15 + 1];
                                                   field415[var15] = field415[var15 + 1];
                                                   field417[var15] = field417[1 + var15];
                                                   field418[var15] = field418[1 + var15];
                                                }
                                             }

                                             --field416;
                                          }
                                       }

                                       class33.method754(class172.field2857[var39 >> 16], var76, false);
                                       class93.method2182(var47);
                                       if(field438 != -1) {
                                          class15.method198(field438, 1);
                                       }

                                       var10 = var12;
                                    }
                                 }

                                 for(var35 = (class3)field304.method3835(); var35 != null; var35 = (class3)field304.method3840()) {
                                    if(var35.field62) {
                                       var35.field62 = false;
                                    } else {
                                       class7.method125(var35, true);
                                    }
                                 }

                                 field476 = new class195(512);

                                 while(field320.field1981 < var27) {
                                    var39 = field320.method2541();
                                    var47 = field320.method2538();
                                    var46 = field320.method2538();
                                    var61 = field320.method2541();

                                    for(var59 = var47; var59 <= var46; ++var59) {
                                       long var69 = ((long)var39 << 32) + (long)var59;
                                       field476.method3839(new class200(var61), var69);
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(154 == field446) {
                                 var27 = field320.method2541();
                                 var5 = field320.method2541();
                                 if(class9.field153 == null || !class9.field153.isValid()) {
                                    try {
                                       Iterator var31 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                                       while(var31.hasNext()) {
                                          GarbageCollectorMXBean var36 = (GarbageCollectorMXBean)var31.next();
                                          if(var36.isValid()) {
                                             class9.field153 = var36;
                                             field552 = -1L;
                                             field551 = -1L;
                                          }
                                       }
                                    } catch (Throwable var21) {
                                       ;
                                    }
                                 }

                                 long var33 = class92.method2177();
                                 var47 = -1;
                                 if(class9.field153 != null) {
                                    var9 = class9.field153.getCollectionTime();
                                    if(field551 != -1L) {
                                       var11 = var9 - field551;
                                       var13 = var33 - field552;
                                       if(var13 != 0L) {
                                          var47 = (int)(100L * var11 / var13);
                                       }
                                    }

                                    field551 = var9;
                                    field552 = var33;
                                 }

                                 field318.method2785(113);
                                 field318.method2558(class143.field2181);
                                 field318.method2524(var27);
                                 field318.method2578(var5);
                                 field318.method2558(var47);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(37 == field446) {
                                 class32.field733 = 0;

                                 for(var27 = 0; var27 < 2048; ++var27) {
                                    class32.field732[var27] = null;
                                    class32.field731[var27] = 1;
                                 }

                                 for(var27 = 0; var27 < 2048; ++var27) {
                                    field397[var27] = null;
                                 }

                                 class155.method3205(field320);
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 165) {
                                 var27 = field320.method2536();
                                 if(field320.method2536() == 0) {
                                    field499[var27] = new class219();
                                    field320.field1981 += 18;
                                 } else {
                                    --field320.field1981;
                                    field499[var27] = new class219(field320, false);
                                 }

                                 field469 = field459;
                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(76 == field446) {
                                 for(var27 = 0; var27 < field397.length; ++var27) {
                                    if(field397[var27] != null) {
                                       field397[var27].field829 = -1;
                                    }
                                 }

                                 for(var27 = 0; var27 < field313.length; ++var27) {
                                    if(null != field313[var27]) {
                                       field313[var27].field829 = -1;
                                    }
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(57 == field446) {
                                 var27 = field320.method2580();
                                 var5 = field320.method2541();
                                 class3 var30 = (class3)field304.method3836((long)var27);
                                 var35 = (class3)field304.method3836((long)var5);
                                 if(var35 != null) {
                                    class7.method125(var35, null == var30 || var30.field63 != var35.field63);
                                 }

                                 if(null != var30) {
                                    var30.method3965();
                                    field304.method3839(var30, (long)var5);
                                 }

                                 var42 = class48.method1036(var27);
                                 if(var42 != null) {
                                    class42.method942(var42);
                                 }

                                 var42 = class48.method1036(var5);
                                 if(null != var42) {
                                    class42.method942(var42);
                                    class33.method754(class172.field2857[var42.field2734 * -1 >>> 16], var42, true);
                                 }

                                 if(-1 != field438) {
                                    class15.method198(field438, 1);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(field446 == 56) {
                                 if(field438 != -1) {
                                    class15.method198(field438, 0);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              if(176 == field446) {
                                 var27 = field320.method2571();
                                 if('\uffff' == var27) {
                                    var27 = -1;
                                 }

                                 var5 = field320.method2580();
                                 var6 = field320.method2541();
                                 var7 = class48.method1036(var6);
                                 class51 var8;
                                 if(!var7.field2733) {
                                    if(-1 == var27) {
                                       var7.field2777 = 0;
                                       field446 = -1;
                                       var26 = true;
                                       break label3956;
                                    }

                                    var8 = class10.method158(var27);
                                    var7.field2777 = 4;
                                    var7.field2776 = var27;
                                    var7.field2783 = var8.field1105;
                                    var7.field2760 = var8.field1103;
                                    var7.field2787 = var8.field1129 * 100 / var5;
                                    class42.method942(var7);
                                 } else {
                                    var7.field2852 = var27;
                                    var7.field2853 = var5;
                                    var8 = class10.method158(var27);
                                    var7.field2783 = var8.field1105;
                                    var7.field2760 = var8.field1103;
                                    var7.field2785 = var8.field1089;
                                    var7.field2781 = var8.field1139;
                                    var7.field2782 = var8.field1130;
                                    var7.field2787 = var8.field1129;
                                    if(var8.field1110 == 1) {
                                       var7.field2779 = 1;
                                    } else {
                                       var7.field2779 = 2;
                                    }

                                    if(var7.field2789 > 0) {
                                       var7.field2787 = var7.field2787 * 32 / var7.field2789;
                                    } else if(var7.field2860 > 0) {
                                       var7.field2787 = var7.field2787 * 32 / var7.field2860;
                                    }

                                    class42.method942(var7);
                                 }

                                 field446 = -1;
                                 var26 = true;
                                 break label3956;
                              }

                              class37.method803("" + field446 + "," + field326 + "," + field327 + "," + field289, (Throwable)null);
                              class77.method1699();
                           } catch (IOException var22) {
                              if(field400 > 0) {
                                 class77.method1699();
                              } else {
                                 class31.method714(40);
                                 class8.field138 = class11.field170;
                                 class11.field170 = null;
                              }
                           } catch (Exception var23) {
                              var4 = "" + field446 + "," + field326 + "," + field327 + "," + field289 + "," + (class0.field12.field809[0] + class47.field1053) + "," + (class161.field2629 + class0.field12.field816[0]) + ",";

                              for(var5 = 0; var5 < field289 && var5 < 50; ++var5) {
                                 var4 = var4 + field320.field1980[var5] + ",";
                              }

                              class37.method803(var4, var23);
                              class77.method1699();
                           }

                           var26 = true;
                        }
                     }

                     if(!var26) {
                        break;
                     }
                  }

                  if(30 == field296) {
                     while(class102.method2311()) {
                        field318.method2785(13);
                        field318.method2521(0);
                        var25 = field318.field1981;
                        class140.method3017(field318);
                        field318.method2533(field318.field1981 - var25);
                     }

                     Object var28 = class161.field2632.field188;
                     int var112;
                     synchronized(class161.field2632.field188) {
                        if(!field275) {
                           class161.field2632.field190 = 0;
                        } else if(0 != class139.field2140 || class161.field2632.field190 >= 40) {
                           field318.method2785(22);
                           field318.method2521(0);
                           var112 = field318.field1981;
                           var3 = 0;

                           for(var27 = 0; var27 < class161.field2632.field190 && field318.field1981 - var112 < 240; ++var27) {
                              ++var3;
                              var5 = class161.field2632.field191[var27];
                              if(var5 < 0) {
                                 var5 = 0;
                              } else if(var5 > 502) {
                                 var5 = 502;
                              }

                              var6 = class161.field2632.field187[var27];
                              if(var6 < 0) {
                                 var6 = 0;
                              } else if(var6 > 764) {
                                 var6 = 764;
                              }

                              var39 = var6 + var5 * 765;
                              if(-1 == class161.field2632.field191[var27] && class161.field2632.field187[var27] == -1) {
                                 var6 = -1;
                                 var5 = -1;
                                 var39 = 524287;
                              }

                              if(var6 == field288 && var5 == field298) {
                                 if(field550 < 2047) {
                                    ++field550;
                                 }
                              } else {
                                 var47 = var6 - field288;
                                 field288 = var6;
                                 var46 = var5 - field298;
                                 field298 = var5;
                                 if(field550 < 8 && var47 >= -32 && var47 <= 31 && var46 >= -32 && var46 <= 31) {
                                    var47 += 32;
                                    var46 += 32;
                                    field318.method2522((field550 << 12) + (var47 << 6) + var46);
                                    field550 = 0;
                                 } else if(field550 < 8) {
                                    field318.method2523(var39 + 8388608 + (field550 << 19));
                                    field550 = 0;
                                 } else {
                                    field318.method2524(-1073741824 + (field550 << 19) + var39);
                                    field550 = 0;
                                 }
                              }
                           }

                           field318.method2533(field318.field1981 - var112);
                           if(var3 >= class161.field2632.field190) {
                              class161.field2632.field190 = 0;
                           } else {
                              class161.field2632.field190 -= var3;

                              for(var27 = 0; var27 < class161.field2632.field190; ++var27) {
                                 class161.field2632.field187[var27] = class161.field2632.field187[var3 + var27];
                                 class161.field2632.field191[var27] = class161.field2632.field191[var27 + var3];
                              }
                           }
                        }
                     }

                     if(1 == class139.field2140 || !class33.field752 && 4 == class139.field2140 || 2 == class139.field2140) {
                        long var29 = (class139.field2143 - field287 * -1L) / 50L;
                        if(var29 > 4095L) {
                           var29 = 4095L;
                        }

                        field287 = class139.field2143 * -1L;
                        var3 = class139.field2142;
                        if(var3 < 0) {
                           var3 = 0;
                        } else if(var3 > class136.field2101) {
                           var3 = class136.field2101;
                        }

                        var27 = class139.field2130;
                        if(var27 < 0) {
                           var27 = 0;
                        } else if(var27 > class129.field2048) {
                           var27 = class129.field2048;
                        }

                        var5 = (int)var29;
                        field318.method2785(192);
                        field318.method2522((var5 << 1) + (2 == class139.field2140?1:0));
                        field318.method2522(var27);
                        field318.method2522(var3);
                     }

                     if(class136.field2108 > 0) {
                        field318.method2785(241);
                        field318.method2522(0);
                        var25 = field318.field1981;
                        long var113 = class92.method2177();

                        for(var27 = 0; var27 < class136.field2108; ++var27) {
                           var104 = var113 - field273;
                           if(var104 > 16777215L) {
                              var104 = 16777215L;
                           }

                           field273 = var113;
                           field318.method2632(class136.field2107[var27]);
                           field318.method2575((int)var104);
                        }

                        field318.method2719(field318.field1981 - var25);
                     }

                     if(field367 > 0) {
                        --field367;
                     }

                     if(class136.field2114[96] || class136.field2114[97] || class136.field2114[98] || class136.field2114[99]) {
                        field368 = true;
                     }

                     if(field368 && field367 <= 0) {
                        field367 = 20;
                        field368 = false;
                        field318.method2785(202);
                        field318.method2567(field434);
                        field318.method2730(field360);
                     }

                     if(class86.field1516 && !field291) {
                        field291 = true;
                        field318.method2785(250);
                        field318.method2521(1);
                     }

                     if(!class86.field1516 && field291) {
                        field291 = false;
                        field318.method2785(250);
                        field318.method2521(0);
                     }

                     if(field503 * -1 != class8.field134) {
                        field503 = class8.field134 * -1;
                        var25 = class8.field134;
                        int[] var114 = class97.field1655.field1394;
                        var3 = var114.length;

                        for(var27 = 0; var27 < var3; ++var27) {
                           var114[var27] = 0;
                        }

                        var27 = 1;

                        while(true) {
                           if(var27 >= 103) {
                              var27 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                              var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                              class97.field1655.method1770();

                              for(var6 = 1; var6 < 103; ++var6) {
                                 for(var39 = 1; var39 < 103; ++var39) {
                                    if((class5.field86[var25][var39][var6] & 24) == 0) {
                                       class7.method123(var25, var39, var6, var27, var5);
                                    }

                                    if(var25 < 3 && 0 != (class5.field86[1 + var25][var39][var6] & 8)) {
                                       class7.method123(var25 + 1, var39, var6, var27, var5);
                                    }
                                 }
                              }

                              field504 = 0;

                              for(var6 = 0; var6 < 104; ++var6) {
                                 for(var39 = 0; var39 < 104; ++var39) {
                                    var47 = class24.field610.method2082(class8.field134, var6, var39);
                                    if(var47 != 0) {
                                       var47 = var47 >> 14 & 32767;
                                       var46 = class33.method755(var47).field910;
                                       if(var46 >= 0) {
                                          var61 = var6;
                                          var59 = var39;
                                          if(22 != var46 && 29 != var46 && var46 != 34 && var46 != 36 && 46 != var46 && 47 != var46 && 48 != var46) {
                                             int[][] var96 = field335[class8.field134].field1879;

                                             for(var15 = 0; var15 < 10; ++var15) {
                                                var16 = (int)(Math.random() * 4.0D);
                                                if(0 == var16 && var61 > 0 && var61 > var6 - 3 && 0 == (var96[var61 - 1][var59] & 19136776)) {
                                                   --var61;
                                                }

                                                if(var16 == 1 && var61 < 103 && var61 < var6 + 3 && (var96[1 + var61][var59] & 19136896) == 0) {
                                                   ++var61;
                                                }

                                                if(2 == var16 && var59 > 0 && var59 > var39 - 3 && 0 == (var96[var61][var59 - 1] & 19136770)) {
                                                   --var59;
                                                }

                                                if(var16 == 3 && var59 < 103 && var59 < 3 + var39 && 0 == (var96[var61][var59 + 1] & 19136800)) {
                                                   ++var59;
                                                }
                                             }
                                          }

                                          field507[field504] = class13.field192[var46];
                                          field322[field504] = var61;
                                          field506[field504] = var59;
                                          ++field504;
                                       }
                                    }
                                 }
                              }

                              class84.field1440.method1713();
                              break;
                           }

                           var5 = 24628 + (103 - var27) * 2048;

                           for(var6 = 1; var6 < 103; ++var6) {
                              if((class5.field86[var25][var6][var27] & 24) == 0) {
                                 class24.field610.method1966(var114, var5, 512, var25, var6, var27);
                              }

                              if(var25 < 3 && (class5.field86[var25 + 1][var6][var27] & 8) != 0) {
                                 class24.field610.method1966(var114, var5, 512, 1 + var25, var6, var27);
                              }

                              var5 += 4;
                           }

                           ++var27;
                        }
                     }

                     if(30 == field296) {
                        for(class16 var34 = (class16)field408.method3871(); null != var34; var34 = (class16)field408.method3873()) {
                           if(var34.field233 > 0) {
                              --var34.field233;
                           }

                           class40 var115;
                           if(var34.field233 == 0) {
                              if(var34.field232 >= 0) {
                                 var3 = var34.field232;
                                 var27 = var34.field228;
                                 var115 = class33.method755(var3);
                                 if(11 == var27) {
                                    var27 = 10;
                                 }

                                 if(var27 >= 5 && var27 <= 8) {
                                    var27 = 4;
                                 }

                                 var26 = var115.method848(var27);
                                 if(!var26) {
                                    continue;
                                 }
                              }

                              class16.method210(var34.field226, var34.field223, var34.field224, var34.field225, var34.field232, var34.field227, var34.field228);
                              var34.method3965();
                           } else {
                              if(var34.field222 > 0) {
                                 --var34.field222;
                              }

                              if(0 == var34.field222 && var34.field224 >= 1 && var34.field225 >= 1 && var34.field224 <= 102 && var34.field225 <= 102) {
                                 if(var34.field229 >= 0) {
                                    var3 = var34.field229;
                                    var27 = var34.field231;
                                    var115 = class33.method755(var3);
                                    if(var27 == 11) {
                                       var27 = 10;
                                    }

                                    if(var27 >= 5 && var27 <= 8) {
                                       var27 = 4;
                                    }

                                    var26 = var115.method848(var27);
                                    if(!var26) {
                                       continue;
                                    }
                                 }

                                 class16.method210(var34.field226, var34.field223, var34.field224, var34.field225, var34.field229, var34.field230, var34.field231);
                                 var34.field222 = -1;
                                 if(var34.field232 == var34.field229 && -1 == var34.field232) {
                                    var34.method3965();
                                 } else if(var34.field232 == var34.field229 && var34.field227 == var34.field230 && var34.field228 == var34.field231) {
                                    var34.method3965();
                                 }
                              }
                           }
                        }

                        for(var25 = 0; var25 < field516; ++var25) {
                           --field519[var25];
                           if(field519[var25] >= -10) {
                              class58 var117 = field521[var25];
                              if(var117 == null) {
                                 class58 var123 = (class58)null;
                                 var117 = class58.method1285(class158.field2583, field462[var25], 0);
                                 if(null == var117) {
                                    continue;
                                 }

                                 field519[var25] += var117.method1282();
                                 field521[var25] = var117;
                              }

                              if(field519[var25] < 0) {
                                 if(field467[var25] != 0) {
                                    var27 = (field467[var25] & 255) * 128;
                                    var5 = field467[var25] >> 16 & 255;
                                    var6 = 128 * var5 + 64 - class0.field12.field846;
                                    if(var6 < 0) {
                                       var6 = -var6;
                                    }

                                    var39 = field467[var25] >> 8 & 255;
                                    var47 = 128 * var39 + 64 - class0.field12.field834;
                                    if(var47 < 0) {
                                       var47 = -var47;
                                    }

                                    var46 = var6 + var47 - 128;
                                    if(var46 > var27) {
                                       field519[var25] = -100;
                                       continue;
                                    }

                                    if(var46 < 0) {
                                       var46 = 0;
                                    }

                                    var3 = field515 * (var27 - var46) / var27;
                                 } else {
                                    var3 = field514;
                                 }

                                 if(var3 > 0) {
                                    class62 var120 = var117.method1283().method1320(class103.field1774);
                                    class64 var118 = class64.method1473(var120, 100, var3);
                                    var118.method1348(field518[var25] - 1);
                                    class16.field235.method1200(var118);
                                 }

                                 field519[var25] = -100;
                              }
                           } else {
                              --field516;

                              for(var112 = var25; var112 < field516; ++var112) {
                                 field462[var112] = field462[var112 + 1];
                                 field521[var112] = field521[var112 + 1];
                                 field518[var112] = field518[1 + var112];
                                 field519[var112] = field519[1 + var112];
                                 field467[var112] = field467[var112 + 1];
                              }

                              --var25;
                           }
                        }

                        if(field513) {
                           boolean var44;
                           if(class182.field2940 != 0) {
                              var44 = true;
                           } else {
                              var44 = class182.field2943.method3659();
                           }

                           if(!var44) {
                              if(0 != field543 && field512 != -1) {
                                 class41.method903(class142.field2165, field512, 0, field543, false);
                              }

                              field513 = false;
                           }
                        }

                        ++field323;
                        if(field323 > 750) {
                           if(field400 > 0) {
                              class77.method1699();
                           } else {
                              class31.method714(40);
                              class8.field138 = class11.field170;
                              class11.field170 = null;
                           }
                        } else {
                           class171.method3459();

                           for(var25 = 0; var25 < field314; ++var25) {
                              var112 = field315[var25];
                              class34 var45 = field313[var112];
                              if(var45 != null) {
                                 class21.method609(var45);
                              }
                           }

                           class171.method3457();
                           ++field420;
                           if(field387 != 0) {
                              field361 += 20;
                              if(field361 >= 400) {
                                 field387 = 0;
                              }
                           }

                           if(null != class10.field156) {
                              ++field306;
                              if(field306 >= 15) {
                                 class42.method942(class10.field156);
                                 class10.field156 = null;
                              }
                           }

                           class172 var55 = class3.field65;
                           class172 var119 = class8.field140;
                           class3.field65 = null;
                           class8.field140 = null;
                           field451 = null;
                           field455 = false;
                           field452 = false;
                           field497 = 0;

                           while(true) {
                              while(class11.method180() && field497 < 128) {
                                 if(field441 >= 2 && class136.field2114[82] && class136.field2095 == 66) {
                                    String var48 = class88.method2099();
                                    class50.field1085.setContents(new StringSelection(var48), (ClipboardOwner)null);
                                 } else {
                                    field495[field497] = class136.field2095;
                                    field498[field497] = class14.field208;
                                    ++field497;
                                 }
                              }

                              if(-1 != field438) {
                                 class190.method3798(field438, 0, 0, class129.field2048, class136.field2101, 0, 0);
                              }

                              ++field459;

                              while(true) {
                                 class0 var50;
                                 class172 var121;
                                 do {
                                    var50 = (class0)field357.method3869();
                                    if(null == var50) {
                                       while(true) {
                                          do {
                                             var50 = (class0)field475.method3869();
                                             if(var50 == null) {
                                                while(true) {
                                                   do {
                                                      var50 = (class0)field473.method3869();
                                                      if(null == var50) {
                                                         boolean var56 = false;

                                                         while(!var56) {
                                                            var56 = true;

                                                            for(var27 = 0; var27 < field416 - 1; ++var27) {
                                                               if(field419[var27] < 1000 && field419[var27 + 1] > 1000) {
                                                                  var32 = field422[var27];
                                                                  field422[var27] = field422[1 + var27];
                                                                  field422[var27 + 1] = var32;
                                                                  var41 = field297[var27];
                                                                  field297[var27] = field297[1 + var27];
                                                                  field297[1 + var27] = var41;
                                                                  var39 = field419[var27];
                                                                  field419[var27] = field419[1 + var27];
                                                                  field419[var27 + 1] = var39;
                                                                  var39 = field417[var27];
                                                                  field417[var27] = field417[1 + var27];
                                                                  field417[1 + var27] = var39;
                                                                  var39 = field418[var27];
                                                                  field418[var27] = field418[1 + var27];
                                                                  field418[1 + var27] = var39;
                                                                  var39 = field415[var27];
                                                                  field415[var27] = field415[1 + var27];
                                                                  field415[1 + var27] = var39;
                                                                  var56 = false;
                                                               }
                                                            }
                                                         }

                                                         if(class1.field26 == null && field447 == null) {
                                                            var3 = class139.field2140;
                                                            if(field500) {
                                                               if(1 != var3 && (class33.field752 || 4 != var3)) {
                                                                  var27 = class139.field2134;
                                                                  var5 = class139.field2135;
                                                                  if(var27 < class18.field253 - 10 || var27 > 10 + class0.field9 + class18.field253 || var5 < class36.field793 - 10 || var5 > class19.field267 + class36.field793 + 10) {
                                                                     field500 = false;
                                                                     class186.method3794(class18.field253, class36.field793, class0.field9, class19.field267);
                                                                  }
                                                               }

                                                               if(var3 == 1 || !class33.field752 && 4 == var3) {
                                                                  var27 = class18.field253;
                                                                  var5 = class36.field793;
                                                                  var6 = class0.field9;
                                                                  var39 = class139.field2130;
                                                                  var47 = class139.field2142;
                                                                  var46 = -1;

                                                                  for(var61 = 0; var61 < field416; ++var61) {
                                                                     var59 = var5 + 31 + (field416 - 1 - var61) * 15;
                                                                     if(var39 > var27 && var39 < var6 + var27 && var47 > var59 - 13 && var47 < var59 + 3) {
                                                                        var46 = var61;
                                                                     }
                                                                  }

                                                                  if(var46 != -1) {
                                                                     class15.method207(var46);
                                                                  }

                                                                  field500 = false;
                                                                  class186.method3794(class18.field253, class36.field793, class0.field9, class19.field267);
                                                               }
                                                            } else {
                                                               label4008: {
                                                                  label4077: {
                                                                     if((var3 == 1 || !class33.field752 && 4 == var3) && field416 > 0) {
                                                                        var27 = field419[field416 - 1];
                                                                        if(39 == var27 || 40 == var27 || 41 == var27 || var27 == 42 || 43 == var27 || var27 == 33 || 34 == var27 || 35 == var27 || var27 == 36 || var27 == 37 || 38 == var27 || var27 == 1005) {
                                                                           var5 = field417[field416 - 1];
                                                                           var6 = field418[field416 - 1];
                                                                           var7 = class48.method1036(var6);
                                                                           if(class17.method216(class7.method126(var7))) {
                                                                              break label4077;
                                                                           }

                                                                           var46 = class7.method126(var7);
                                                                           var92 = (var46 >> 29 & 1) != 0;
                                                                           if(var92) {
                                                                              break label4077;
                                                                           }
                                                                        }
                                                                     }

                                                                     if(var3 == 1 || !class33.field752 && 4 == var3) {
                                                                        label4070: {
                                                                           if(1 != field414 || field416 <= 2) {
                                                                              var5 = field416 - 1;
                                                                              if(var5 < 0) {
                                                                                 var88 = false;
                                                                              } else {
                                                                                 var6 = field419[var5];
                                                                                 if(var6 >= 2000) {
                                                                                    var6 -= 2000;
                                                                                 }

                                                                                 if(var6 == 1007) {
                                                                                    var88 = true;
                                                                                 } else {
                                                                                    var88 = false;
                                                                                 }
                                                                              }

                                                                              if(!var88) {
                                                                                 break label4070;
                                                                              }
                                                                           }

                                                                           var3 = 2;
                                                                        }
                                                                     }

                                                                     if((1 == var3 || !class33.field752 && 4 == var3) && field416 > 0) {
                                                                        class15.method207(field416 - 1);
                                                                     }

                                                                     if(var3 == 2 && field416 > 0) {
                                                                        class154.method3202(class139.field2130, class139.field2142);
                                                                     }
                                                                     break label4008;
                                                                  }

                                                                  if(class1.field26 != null && !field440 && 1 != field414) {
                                                                     var46 = field416 - 1;
                                                                     if(var46 < 0) {
                                                                        var92 = false;
                                                                     } else {
                                                                        var61 = field419[var46];
                                                                        if(var61 >= 2000) {
                                                                           var61 -= 2000;
                                                                        }

                                                                        if(var61 == 1007) {
                                                                           var92 = true;
                                                                        } else {
                                                                           var92 = false;
                                                                        }
                                                                     }

                                                                     if(!var92 && field416 > 0) {
                                                                        var61 = field391;
                                                                        var59 = field509;
                                                                        class103.method2326(class160.field2625, var61, var59);
                                                                        class160.field2625 = null;
                                                                     }
                                                                  }

                                                                  field440 = false;
                                                                  field489 = 0;
                                                                  if(null != class1.field26) {
                                                                     class42.method942(class1.field26);
                                                                  }

                                                                  class1.field26 = class48.method1036(var6);
                                                                  field390 = var5;
                                                                  field391 = class139.field2130;
                                                                  field509 = class139.field2142;
                                                                  if(field416 > 0) {
                                                                     class177.method3528(field416 - 1);
                                                                  }

                                                                  class42.method942(class1.field26);
                                                               }
                                                            }
                                                         }

                                                         if(field447 != null) {
                                                            class102.method2317();
                                                         }

                                                         if(null != class1.field26) {
                                                            class42.method942(class1.field26);
                                                            ++field489;
                                                            if(0 != class139.field2133) {
                                                               if(field489 >= 5 && (class139.field2134 > 5 + field391 || class139.field2134 < field391 - 5 || class139.field2135 > 5 + field509 || class139.field2135 < field509 - 5)) {
                                                                  field440 = true;
                                                               }
                                                            } else {
                                                               if(field440) {
                                                                  if(class29.field678 == class1.field26 && field390 != field393) {
                                                                     class172 var71 = class1.field26;
                                                                     byte var122 = 0;
                                                                     if(field293 == 1 && 206 == var71.field2738) {
                                                                        var122 = 1;
                                                                     }

                                                                     if(var71.field2850[field393] <= 0) {
                                                                        var122 = 0;
                                                                     }

                                                                     var6 = class7.method126(var71);
                                                                     var40 = (var6 >> 29 & 1) != 0;
                                                                     if(var40) {
                                                                        var39 = field390;
                                                                        var47 = field393;
                                                                        var71.field2850[var47] = var71.field2850[var39];
                                                                        var71.field2851[var47] = var71.field2851[var39];
                                                                        var71.field2850[var39] = -1;
                                                                        var71.field2851[var39] = 0;
                                                                     } else if(1 == var122) {
                                                                        var39 = field390;
                                                                        var47 = field393;

                                                                        while(var39 != var47) {
                                                                           if(var39 > var47) {
                                                                              var71.method3466(var39 - 1, var39);
                                                                              --var39;
                                                                           } else if(var39 < var47) {
                                                                              var71.method3466(1 + var39, var39);
                                                                              ++var39;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var71.method3466(field393, field390);
                                                                     }

                                                                     field318.method2785(201);
                                                                     field318.method2522(field390);
                                                                     field318.method2547(field393);
                                                                     field318.method2524(class1.field26.field2734 * -1);
                                                                     field318.method2558(var122);
                                                                  }
                                                               } else {
                                                                  label2805: {
                                                                     label2804: {
                                                                        if(1 != field414) {
                                                                           var27 = field416 - 1;
                                                                           if(var27 < 0) {
                                                                              var56 = false;
                                                                           } else {
                                                                              var5 = field419[var27];
                                                                              if(var5 >= 2000) {
                                                                                 var5 -= 2000;
                                                                              }

                                                                              if(var5 == 1007) {
                                                                                 var56 = true;
                                                                              } else {
                                                                                 var56 = false;
                                                                              }
                                                                           }

                                                                           if(!var56) {
                                                                              break label2804;
                                                                           }
                                                                        }

                                                                        if(field416 > 2) {
                                                                           class154.method3202(field391, field509);
                                                                           break label2805;
                                                                        }
                                                                     }

                                                                     if(field416 > 0) {
                                                                        var3 = field391;
                                                                        var27 = field509;
                                                                        class103.method2326(class160.field2625, var3, var27);
                                                                        class160.field2625 = null;
                                                                     }
                                                                  }
                                                               }

                                                               field306 = 10;
                                                               class139.field2140 = 0;
                                                               class1.field26 = null;
                                                            }
                                                         }

                                                         if(class85.field1478 != -1) {
                                                            var3 = class85.field1478;
                                                            var27 = class85.field1479;
                                                            field318.method2785(166);
                                                            field318.method2521(5);
                                                            field318.method2522(class161.field2629 + var27);
                                                            field318.method2632(class136.field2114[82]?(class136.field2114[81]?2:1):0);
                                                            field318.method2730(class47.field1053 + var3);
                                                            class85.field1478 = -1;
                                                            field520 = class139.field2130;
                                                            field399 = class139.field2142;
                                                            field387 = 1;
                                                            field361 = 0;
                                                            field537 = var3;
                                                            field294 = var27;
                                                         }

                                                         if(var55 != class3.field65) {
                                                            if(var55 != null) {
                                                               class42.method942(var55);
                                                            }

                                                            if(class3.field65 != null) {
                                                               class42.method942(class3.field65);
                                                            }
                                                         }

                                                         if(class8.field140 != var119 && field285 == field425) {
                                                            if(var119 != null) {
                                                               class42.method942(var119);
                                                            }

                                                            if(null != class8.field140) {
                                                               class42.method942(class8.field140);
                                                            }
                                                         }

                                                         if(null != class8.field140) {
                                                            if(field425 < field285) {
                                                               ++field425;
                                                               if(field285 == field425) {
                                                                  class42.method942(class8.field140);
                                                               }
                                                            }
                                                         } else if(field425 > 0) {
                                                            --field425;
                                                         }

                                                         var3 = class0.field12.field846 + field522;
                                                         var27 = field341 + class0.field12.field834;
                                                         if(class18.field254 - var3 < -500 || class18.field254 - var3 > 500 || class24.field609 - var27 < -500 || class24.field609 - var27 > 500) {
                                                            class18.field254 = var3;
                                                            class24.field609 = var27;
                                                         }

                                                         if(class18.field254 != var3) {
                                                            class18.field254 += (var3 - class18.field254) / 16;
                                                         }

                                                         if(class24.field609 != var27) {
                                                            class24.field609 += (var27 - class24.field609) / 16;
                                                         }

                                                         if(class139.field2133 == 4 && class33.field752) {
                                                            var5 = class139.field2135 - field365;
                                                            field363 = var5 * 2;
                                                            field365 = -1 != var5 && 1 != var5?(class139.field2135 + field365) / 2:class139.field2135;
                                                            var6 = field364 - class139.field2134;
                                                            field362 = var6 * 2;
                                                            field364 = var6 != -1 && var6 != 1?(class139.field2134 + field364) / 2:class139.field2134;
                                                         } else {
                                                            if(class136.field2114[96]) {
                                                               field362 += (-24 - field362) / 2;
                                                            } else if(class136.field2114[97]) {
                                                               field362 += (24 - field362) / 2;
                                                            } else {
                                                               field362 /= 2;
                                                            }

                                                            if(class136.field2114[98]) {
                                                               field363 += (12 - field363) / 2;
                                                            } else if(class136.field2114[99]) {
                                                               field363 += (-12 - field363) / 2;
                                                            } else {
                                                               field363 /= 2;
                                                            }

                                                            field365 = class139.field2135;
                                                            field364 = class139.field2134;
                                                         }

                                                         field434 = field362 / 2 + field434 & 2047;
                                                         field360 += field363 / 2;
                                                         if(field360 < 128) {
                                                            field360 = 128;
                                                         }

                                                         if(field360 > 383) {
                                                            field360 = 383;
                                                         }

                                                         var5 = class18.field254 >> 7;
                                                         var6 = class24.field609 >> 7;
                                                         var39 = class34.method774(class18.field254, class24.field609, class8.field134);
                                                         var47 = 0;
                                                         if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                            for(var46 = var5 - 4; var46 <= 4 + var5; ++var46) {
                                                               for(var61 = var6 - 4; var61 <= var6 + 4; ++var61) {
                                                                  var59 = class8.field134;
                                                                  if(var59 < 3 && 2 == (class5.field86[1][var46][var61] & 2)) {
                                                                     ++var59;
                                                                  }

                                                                  var70 = var39 - class5.field79[var59][var46][var61];
                                                                  if(var70 > var47) {
                                                                     var47 = var70;
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         var46 = var47 * 192;
                                                         if(var46 > 98048) {
                                                            var46 = 98048;
                                                         }

                                                         if(var46 < '耀') {
                                                            var46 = '耀';
                                                         }

                                                         if(var46 > field369) {
                                                            field369 += (var46 - field369) / 24;
                                                         } else if(var46 < field369) {
                                                            field369 += (var46 - field369) / 80;
                                                         }

                                                         if(field334) {
                                                            var3 = class35.field776 * 128 + 64;
                                                            var27 = class118.field1988 * 128 + 64;
                                                            var5 = class34.method774(var3, var27, class8.field134) - class50.field1088;
                                                            if(class29.field672 < var3) {
                                                               class29.field672 += class115.field1963 + class88.field1540 * (var3 - class29.field672) / 1000;
                                                               if(class29.field672 > var3) {
                                                                  class29.field672 = var3;
                                                               }
                                                            }

                                                            if(class29.field672 > var3) {
                                                               class29.field672 -= class115.field1963 + class88.field1540 * (class29.field672 - var3) / 1000;
                                                               if(class29.field672 < var3) {
                                                                  class29.field672 = var3;
                                                               }
                                                            }

                                                            if(class132.field2053 < var5) {
                                                               class132.field2053 += (var5 - class132.field2053) * class88.field1540 / 1000 + class115.field1963;
                                                               if(class132.field2053 > var5) {
                                                                  class132.field2053 = var5;
                                                               }
                                                            }

                                                            if(class132.field2053 > var5) {
                                                               class132.field2053 -= class115.field1963 + (class132.field2053 - var5) * class88.field1540 / 1000;
                                                               if(class132.field2053 < var5) {
                                                                  class132.field2053 = var5;
                                                               }
                                                            }

                                                            if(class76.field1374 < var27) {
                                                               class76.field1374 += class88.field1540 * (var27 - class76.field1374) / 1000 + class115.field1963;
                                                               if(class76.field1374 > var27) {
                                                                  class76.field1374 = var27;
                                                               }
                                                            }

                                                            if(class76.field1374 > var27) {
                                                               class76.field1374 -= (class76.field1374 - var27) * class88.field1540 / 1000 + class115.field1963;
                                                               if(class76.field1374 < var27) {
                                                                  class76.field1374 = var27;
                                                               }
                                                            }

                                                            var3 = class123.field2021 * 128 + 64;
                                                            var27 = 64 + class76.field1378 * 128;
                                                            var5 = class34.method774(var3, var27, class8.field134) - class133.field2060;
                                                            var6 = var3 - class29.field672;
                                                            var39 = var5 - class132.field2053;
                                                            var47 = var27 - class76.field1374;
                                                            var46 = (int)Math.sqrt((double)(var6 * var6 + var47 * var47));
                                                            var61 = (int)(Math.atan2((double)var39, (double)var46) * 325.949D) & 2047;
                                                            var59 = (int)(Math.atan2((double)var6, (double)var47) * -325.949D) & 2047;
                                                            if(var61 < 128) {
                                                               var61 = 128;
                                                            }

                                                            if(var61 > 383) {
                                                               var61 = 383;
                                                            }

                                                            if(class11.field169 < var61) {
                                                               class11.field169 += (var61 - class11.field169) * class208.field3105 / 1000 + class31.field724;
                                                               if(class11.field169 > var61) {
                                                                  class11.field169 = var61;
                                                               }
                                                            }

                                                            if(class11.field169 > var61) {
                                                               class11.field169 -= (class11.field169 - var61) * class208.field3105 / 1000 + class31.field724;
                                                               if(class11.field169 < var61) {
                                                                  class11.field169 = var61;
                                                               }
                                                            }

                                                            var70 = var59 - class83.field1434;
                                                            if(var70 > 1024) {
                                                               var70 -= 2048;
                                                            }

                                                            if(var70 < -1024) {
                                                               var70 += 2048;
                                                            }

                                                            if(var70 > 0) {
                                                               class83.field1434 += class208.field3105 * var70 / 1000 + class31.field724;
                                                               class83.field1434 &= 2047;
                                                            }

                                                            if(var70 < 0) {
                                                               class83.field1434 -= class208.field3105 * -var70 / 1000 + class31.field724;
                                                               class83.field1434 &= 2047;
                                                            }

                                                            int var90 = var59 - class83.field1434;
                                                            if(var90 > 1024) {
                                                               var90 -= 2048;
                                                            }

                                                            if(var90 < -1024) {
                                                               var90 += 2048;
                                                            }

                                                            if(var90 < 0 && var70 > 0 || var90 > 0 && var70 < 0) {
                                                               class83.field1434 = var59;
                                                            }
                                                         }

                                                         for(var3 = 0; var3 < 5; ++var3) {
                                                            ++field474[var3];
                                                         }

                                                         class83.field1439.method233();
                                                         var3 = class132.method2894();
                                                         var27 = class136.field2094;
                                                         if(var3 > 15000 && var27 > 15000) {
                                                            field400 = 250;
                                                            class26.method679(14500);
                                                            field318.method2785(191);
                                                         }

                                                         ++field345;
                                                         if(field345 > 500) {
                                                            field345 = 0;
                                                            var6 = (int)(Math.random() * 8.0D);
                                                            if((var6 & 1) == 1) {
                                                               field522 += field340;
                                                            }

                                                            if((var6 & 2) == 2) {
                                                               field341 += field392;
                                                            }

                                                            if((var6 & 4) == 4) {
                                                               field343 += field344;
                                                            }
                                                         }

                                                         if(field522 < -50) {
                                                            field340 = 2;
                                                         }

                                                         if(field522 > 50) {
                                                            field340 = -2;
                                                         }

                                                         if(field341 < -55) {
                                                            field392 = 2;
                                                         }

                                                         if(field341 > 55) {
                                                            field392 = -2;
                                                         }

                                                         if(field343 < -40) {
                                                            field344 = 1;
                                                         }

                                                         if(field343 > 40) {
                                                            field344 = -1;
                                                         }

                                                         ++field350;
                                                         if(field350 > 500) {
                                                            field350 = 0;
                                                            var6 = (int)(Math.random() * 8.0D);
                                                            if((var6 & 1) == 1) {
                                                               field346 += field443;
                                                            }

                                                            if(2 == (var6 & 2)) {
                                                               field348 += field356;
                                                            }
                                                         }

                                                         if(field346 < -60) {
                                                            field443 = 2;
                                                         }

                                                         if(field346 > 60) {
                                                            field443 = -2;
                                                         }

                                                         if(field348 < -20) {
                                                            field356 = 1;
                                                         }

                                                         if(field348 > 10) {
                                                            field356 = -1;
                                                         }

                                                         for(class38 var116 = (class38)field544.method3826(); null != var116; var116 = (class38)field544.method3827()) {
                                                            if((long)var116.field863 < class92.method2177() / 1000L - 5L) {
                                                               if(var116.field860 > 0) {
                                                                  class50.method1063(5, "", var116.field859 + " has logged in.");
                                                               }

                                                               if(0 == var116.field860) {
                                                                  class50.method1063(5, "", var116.field859 + " has logged out.");
                                                               }

                                                               var116.method3963();
                                                            }
                                                         }

                                                         ++field324;
                                                         if(field324 > 50) {
                                                            field318.method2785(136);
                                                         }

                                                         try {
                                                            if(null != class11.field170 && field318.field1981 > 0) {
                                                               class11.field170.method3042(field318.field1980, 0, field318.field1981);
                                                               field318.field1981 = 0;
                                                               field324 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var19) {
                                                            if(field400 > 0) {
                                                               class77.method1699();
                                                            } else {
                                                               class31.method714(40);
                                                               class8.field138 = class11.field170;
                                                               class11.field170 = null;
                                                            }

                                                            return;
                                                         }

                                                         return;
                                                      }

                                                      var121 = var50.field2;
                                                      if(var121.field2735 < 0) {
                                                         break;
                                                      }

                                                      var43 = class48.method1036(var121.field2742);
                                                   } while(null == var43 || null == var43.field2806 || var121.field2735 >= var43.field2806.length || var121 != var43.field2806[var121.field2735]);

                                                   class171.method3458(var50);
                                                }
                                             }

                                             var121 = var50.field2;
                                             if(var121.field2735 < 0) {
                                                break;
                                             }

                                             var43 = class48.method1036(var121.field2742);
                                          } while(var43 == null || null == var43.field2806 || var121.field2735 >= var43.field2806.length || var43.field2806[var121.field2735] != var121);

                                          class171.method3458(var50);
                                       }
                                    }

                                    var121 = var50.field2;
                                    if(var121.field2735 < 0) {
                                       break;
                                    }

                                    var43 = class48.method1036(var121.field2742);
                                 } while(var43 == null || null == var43.field2806 || var121.field2735 >= var43.field2806.length || var121 != var43.field2806[var121.field2735]);

                                 class171.method3458(var50);
                              }
                           }
                        }
                     }
                  }
               }
            } else if(field296 == 40 || 45 == field296) {
               class34.method766();
            }

            return;
         }

         var1.field2686.method3406(var1.field2683, (int)var1.field3104, var1.field2685, false);
      }
   }

   @ObfuscatedName("j")
   public static class44 method583(int var0) {
      class44 var1 = (class44)class44.field1020.method3808((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class44.field1012.method3352(3, var0);
         var1 = new class44();
         if(null != var2) {
            var1.method971(new class118(var2));
         }

         class44.field1020.method3805(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   public static class42 method584(int var0) {
      class42 var1 = (class42)class42.field986.method3808((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class42.field989.method3352(12, var0);
         var1 = new class42();
         if(null != var2) {
            var1.method906(new class118(var2));
         }

         var1.method925();
         class42.field986.method3805(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   public static int method585(CharSequence var0, int var1) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var2 = false;
         boolean var3 = false;
         int var4 = 0;
         int var5 = var0.length();

         for(int var6 = 0; var6 < var5; ++var6) {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(45 == var7) {
                  var2 = true;
                  continue;
               }

               if(43 == var7) {
                  continue;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  throw new NumberFormatException();
               }

               var9 = var7 - 87;
            }

            if(var9 >= var1) {
               throw new NumberFormatException();
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var9 + var4 * var1;
            if(var8 / var1 != var4) {
               throw new NumberFormatException();
            }

            var4 = var8;
            var3 = true;
         }

         if(!var3) {
            throw new NumberFormatException();
         } else {
            return var4;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("cf")
   static final int method586(class172 var0, int var1) {
      if(null != var0.field2844 && var1 < var0.field2844.length) {
         try {
            int[] var2 = var0.field2844[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = field411[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = field412[var2[var4++]];
               }

               if(3 == var6) {
                  var7 = field347[var2[var4++]];
               }

               int var9;
               class172 var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class48.method1036(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class10.method158(var11).field1112 || field281)) {
                     for(var12 = 0; var12 < var10.field2850.length; ++var12) {
                        if(1 + var11 == var10.field2850[var12]) {
                           var7 += var10.field2851[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class175.field2884[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class154.field2285[field412[var2[var4++]] - 1];
               }

               if(7 == var6) {
                  var7 = class175.field2884[var2[var4++]] * 100 / '뜛';
               }

               if(8 == var6) {
                  var7 = class0.field12.field53;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class154.field2281[var9]) {
                        var7 += field412[var9];
                     }
                  }
               }

               if(10 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class48.method1036(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class10.method158(var11).field1112 || field281)) {
                     for(var12 = 0; var12 < var10.field2850.length; ++var12) {
                        if(var10.field2850[var12] == 1 + var11) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = field439;
               }

               if(var6 == 12) {
                  var7 = field431;
               }

               if(var6 == 13) {
                  var9 = class175.field2884[var2[var4++]];
                  int var14 = var2[var4++];
                  var7 = (var9 & 1 << var14) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class160.method3227(var9);
               }

               if(15 == var6) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(17 == var6) {
                  var8 = 3;
               }

               if(18 == var6) {
                  var7 = (class0.field12.field846 >> 7) + class47.field1053;
               }

               if(19 == var6) {
                  var7 = class161.field2629 + (class0.field12.field834 >> 7);
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(0 == var8) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(2 == var5 && 0 != var7) {
                     var3 /= var7;
                  }

                  if(3 == var5) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var13) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
