import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
public final class client extends class144 {
   @ObfuscatedName("lp")
   static boolean[] field283;
   @ObfuscatedName("g")
   static client field284;
   @ObfuscatedName("j")
   static boolean field285 = true;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1415689327
   )
   @Export("world")
   static int field286 = 1;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 905744507
   )
   static int field287;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 1852864793
   )
   static int field288;
   @ObfuscatedName("p")
   static class212 field289;
   @ObfuscatedName("n")
   @Export("isMembers")
   static boolean field290 = false;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class108[] field291;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 593035483
   )
   static int field292 = 0;
   @ObfuscatedName("mg")
   static int[] field293;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2067339215
   )
   @Export("gameState")
   static int field294 = 0;
   @ObfuscatedName("f")
   static boolean field295 = true;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1867429777
   )
   @Export("gameCycle")
   static int field296 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 1665348350871389597L
   )
   static long field297 = -1L;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -899575577
   )
   static int field298;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -662737869
   )
   static int field299 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1384276567
   )
   static int field300 = -1;
   @ObfuscatedName("an")
   static boolean field301 = true;
   @ObfuscatedName("ag")
   static boolean field302 = false;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -269016693
   )
   static int field303;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 933908253
   )
   static int field304;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 842580967
   )
   static int field305 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1461796015
   )
   static int field306 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1740046195
   )
   static int field307 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 351262225
   )
   static int field308 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1293495031
   )
   static int field309 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1481951147
   )
   static int field310 = 0;
   @ObfuscatedName("ku")
   @Export("widgetFlags")
   static class196 field311;
   @ObfuscatedName("as")
   static class20 field312;
   @ObfuscatedName("ak")
   static class20 field313;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 922228957
   )
   static int field314;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 61387129
   )
   static int field315;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 395904267
   )
   static int field316;
   @ObfuscatedName("ao")
   static class168 field317;
   @ObfuscatedName("cs")
   static int[] field318;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 1081256681
   )
   static int field319;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 991182435
   )
   static int field320;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -204304425
   )
   static int field321;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 1968280261
   )
   @Export("mapAngle")
   static int field322;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 290461799
   )
   static int field323 = 0;
   @ObfuscatedName("op")
   static int[] field324;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 697731483
   )
   static int field325;
   @ObfuscatedName("cp")
   @Export("cachedNPCs")
   static class34[] field326;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -1377404313
   )
   static int field327;
   @ObfuscatedName("ot")
   static short field328;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1925440299
   )
   static int field329;
   @ObfuscatedName("cl")
   static int[] field330;
   @ObfuscatedName("cu")
   static class122 field331;
   @ObfuscatedName("cy")
   static class122 field332;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 235254805
   )
   static int field333 = -1;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1430285739
   )
   static int field334;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1241323911
   )
   @Export("packetOpcode")
   static int field335;
   @ObfuscatedName("jd")
   static boolean field336;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 99443769
   )
   static int field337;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1194014681
   )
   static int field338;
   @ObfuscatedName("pu")
   static class179 field339;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -2007252661
   )
   @Export("friendCount")
   static int field340;
   @ObfuscatedName("jw")
   static boolean field341;
   @ObfuscatedName("cd")
   static boolean field342;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -1650841109
   )
   static int field343;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 104846781
   )
   static int field344;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 661086193
   )
   static int field345;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -668983047
   )
   static int field346;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -301855719
   )
   static int field347;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -1110764473
   )
   static int field348;
   @ObfuscatedName("ik")
   static String field349;
   @ObfuscatedName("lk")
   static long[] field350;
   @ObfuscatedName("dz")
   static int[][][] field351;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 1822438205
   )
   static int field352;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -1210726335
   )
   static int field353;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -1718478527
   )
   static int field354;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -566542309
   )
   static int field355;
   @ObfuscatedName("hw")
   @Export("boostedSkillLevels")
   static int[] field356;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 1013596563
   )
   static int field357;
   @ObfuscatedName("be")
   static class168 field358;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 97871971
   )
   static int field359;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -940071183
   )
   @Export("mapScale")
   static int field360;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 1279137443
   )
   static int field361;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -1562673317
   )
   static int field362;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -1089071057
   )
   static int field363;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1474394141
   )
   static int field364;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 2026992331
   )
   static int field365;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1011600419
   )
   static int field366;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 1881446521
   )
   static int field367;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1243859413
   )
   static int field368;
   @ObfuscatedName("da")
   static final int[] field369;
   @ObfuscatedName("ec")
   static boolean field370;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 417752847
   )
   static int field371;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 2019289677
   )
   static int field372;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -232775411
   )
   static int field373;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 224804829
   )
   static int field374;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -1942689535
   )
   static int field375;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -1709861315
   )
   static int field376;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -586437569
   )
   static int field377;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 1219377667
   )
   static int field378;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1434926379
   )
   static int field379;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 546828577
   )
   static int field380;
   @ObfuscatedName("fu")
   static boolean field381;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -1754829683
   )
   static int field382;
   @ObfuscatedName("z")
   static boolean field383 = false;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1625968483
   )
   static int field384;
   @ObfuscatedName("ff")
   static int[] field385;
   @ObfuscatedName("fr")
   static int[] field386;
   @ObfuscatedName("mq")
   static int[] field387;
   @ObfuscatedName("fv")
   static int[] field388;
   @ObfuscatedName("fy")
   static int[] field389;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 70844791
   )
   static int field390;
   @ObfuscatedName("gr")
   static int[] field391;
   @ObfuscatedName("go")
   static String[] field392;
   @ObfuscatedName("gg")
   static int[][] field393;
   @ObfuscatedName("pj")
   static final class10 field394;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 763518251
   )
   static int field395;
   @ObfuscatedName("is")
   @Export("menuTargets")
   static String[] field396;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -36755951
   )
   static int field397;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 95032769
   )
   static int field398;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -327614305
   )
   static int field399;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 5981653
   )
   static int field400;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1534869795
   )
   static int field401;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1198152419
   )
   static int field402;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 740869555
   )
   static int field403;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -1773494341
   )
   static int field404;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -35920701
   )
   static int field405;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -2128307331
   )
   static int field406;
   @ObfuscatedName("gp")
   static boolean field407;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 124312827
   )
   static int field408;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1536332179
   )
   static int field409;
   @ObfuscatedName("gf")
   @Export("cachedPlayers")
   static class2[] field410;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -80271705
   )
   static int field411;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1747590983
   )
   static int field412;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -323588959
   )
   static int field413;
   @ObfuscatedName("hq")
   static int[] field414;
   @ObfuscatedName("hl")
   static final int[] field415;
   @ObfuscatedName("hn")
   static String[] field416;
   @ObfuscatedName("hs")
   static boolean[] field417;
   @ObfuscatedName("ho")
   static int[] field418;
   @ObfuscatedName("hu")
   @Export("menuActionParams0")
   static int[] field419;
   @ObfuscatedName("hj")
   @Export("groundItemDeque")
   static class199[][][] field420;
   @ObfuscatedName("hg")
   static class199 field421;
   @ObfuscatedName("hp")
   @Export("projectiles")
   static class199 field422;
   @ObfuscatedName("hf")
   static class199 field423;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      longValue = -7211922178148478905L
   )
   static long field424;
   @ObfuscatedName("hv")
   @Export("realSkillLevels")
   static int[] field425;
   @ObfuscatedName("hx")
   @Export("skillExperiences")
   static int[] field426;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -22164251
   )
   static int field427;
   @ObfuscatedName("hi")
   @Export("isMenuOpen")
   static boolean field428;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 936274193
   )
   @Export("menuOptionCount")
   static int field429;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1833143559
   )
   @Export("localInteractingIndex")
   static int field430;
   @ObfuscatedName("if")
   @Export("menuActionParams1")
   static int[] field431;
   @ObfuscatedName("ij")
   @Export("menuTypes")
   static int[] field432;
   @ObfuscatedName("ii")
   @Export("menuIdentifiers")
   static int[] field433;
   @ObfuscatedName("im")
   @Export("menuOptions")
   static String[] field434;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 422054635
   )
   static int field435;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -739475851
   )
   static int field436;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 573445581
   )
   static int field437;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -805865479
   )
   static int field438;
   @ObfuscatedName("ju")
   static boolean field439;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -1755539265
   )
   static int field440;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -2116179461
   )
   static int field441;
   @ObfuscatedName("it")
   static boolean field442;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 591519639
   )
   static int field443;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -1048014397
   )
   static int field444;
   @ObfuscatedName("in")
   static String field445;
   @ObfuscatedName("ie")
   static String field446;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -1944549593
   )
   static int field447;
   @ObfuscatedName("ip")
   @Export("componentTable")
   static class196 field448;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -1761519437
   )
   static int field449;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1557713695
   )
   static int field450;
   @ObfuscatedName("jn")
   static class173 field451;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -2046666847
   )
   @Export("energy")
   static int field452;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -294246749
   )
   @Export("weight")
   static int field453;
   @ObfuscatedName("jg")
   static boolean field454;
   @ObfuscatedName("fx")
   static int[] field455;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -1964436175
   )
   @Export("widgetRoot")
   static int field456;
   @ObfuscatedName("fh")
   static int[] field457;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 153062213
   )
   static int field458 = 0;
   @ObfuscatedName("ja")
   static class173 field459;
   @ObfuscatedName("ji")
   static class173 field460;
   @ObfuscatedName("jt")
   static class173 field461;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 989447431
   )
   static int field462;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -1197151917
   )
   static int field463;
   @ObfuscatedName("je")
   static class173 field464;
   @ObfuscatedName("jr")
   static boolean field465;
   @ObfuscatedName("bj")
   static class168 field466;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 566145793
   )
   static int field467;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1437300281
   )
   static int field468;
   @ObfuscatedName("px")
   static int[] field469;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 1939410017
   )
   static int field470;
   @ObfuscatedName("ky")
   static int[] field471;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 160076219
   )
   static int field472;
   @ObfuscatedName("kg")
   static int[] field473;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1255744321
   )
   static int field474;
   @ObfuscatedName("kr")
   static int[] field475;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -2071782213
   )
   static int field476;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1464783713
   )
   @Export("flags")
   static int field477 = 0;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -946011665
   )
   @Export("cameraY")
   static int field478;
   @ObfuscatedName("cj")
   static class122 field479;
   @ObfuscatedName("ng")
   static int[] field480;
   @ObfuscatedName("on")
   static int[] field481;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 57335991
   )
   static int field482;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 877908437
   )
   static int field483;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -254490889
   )
   static int field484;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -1075061839
   )
   static int field485;
   @ObfuscatedName("kd")
   static class199 field486;
   @ObfuscatedName("kh")
   static class199 field487;
   @ObfuscatedName("ka")
   static class199 field488;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = -344159487
   )
   static int field489;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -616678083
   )
   static int field490;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -477088061
   )
   static int field491;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1681584301
   )
   static int field492;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -468123787
   )
   static int field493;
   @ObfuscatedName("lq")
   static boolean[] field494;
   @ObfuscatedName("lt")
   @Export("widgetPositionX")
   static int[] field495;
   @ObfuscatedName("lr")
   @Export("widgetPositionY")
   static int[] field496;
   @ObfuscatedName("lb")
   @Export("widgetBoundsWidth")
   static int[] field497;
   @ObfuscatedName("ld")
   @Export("widgetBoundsHeight")
   static int[] field498;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -1701591237
   )
   static int field499;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      longValue = -1300354130795724687L
   )
   static long field500;
   @ObfuscatedName("la")
   @Export("isResized")
   static boolean field501;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -1233755955
   )
   static int field502;
   @ObfuscatedName("ln")
   static String field503;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1029364475
   )
   static int field504;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      longValue = 1057146928772423445L
   )
   static long field505;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = 219190119
   )
   static int field506;
   @ObfuscatedName("lz")
   static boolean[] field507;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = 2040044265
   )
   static int field509;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 1785413679
   )
   static int field510;
   @ObfuscatedName("mu")
   static int[] field511;
   @ObfuscatedName("mm")
   static int[] field512;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -625634133
   )
   @Export("ignoreCount")
   static int field513;
   @ObfuscatedName("my")
   static String field514;
   @ObfuscatedName("mf")
   static String field515;
   @ObfuscatedName("om")
   static short field516;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 739782399
   )
   static int field517;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1398523889
   )
   static int field518;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 414351697
   )
   static int field519 = 0;
   @ObfuscatedName("mo")
   static class78[] field520;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -840825333
   )
   @Export("flagX")
   static int field521;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 781096975
   )
   @Export("flagY")
   static int field522;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -868432895
   )
   static int field523;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 315446595
   )
   static int field524;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 195953581
   )
   static int field525;
   @ObfuscatedName("mx")
   static boolean field526;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -2126774299
   )
   static int field527;
   @ObfuscatedName("pq")
   @Export("grandExchangeOffers")
   static class220[] field528;
   @ObfuscatedName("og")
   static int[] field529;
   @ObfuscatedName("nm")
   static int[] field530;
   @ObfuscatedName("nj")
   static int[] field531;
   @ObfuscatedName("nc")
   static int[] field532;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 2058960409
   )
   static int field533;
   @ObfuscatedName("nn")
   static class58[] field534;
   @ObfuscatedName("ns")
   static boolean field535;
   @ObfuscatedName("or")
   static boolean[] field536;
   @ObfuscatedName("oz")
   static short field537;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -193820309
   )
   static int field538;
   @ObfuscatedName("oq")
   static int[] field539;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 655508887
   )
   static int field540;
   @ObfuscatedName("ou")
   static short field541;
   @ObfuscatedName("os")
   static short field542;
   @ObfuscatedName("ox")
   static short field543;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 2118703041
   )
   static int field544;
   @ObfuscatedName("jb")
   static boolean field545;
   @ObfuscatedName("oj")
   static short field546;
   @ObfuscatedName("oa")
   static short field547;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1612492575
   )
   static int field548 = 0;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -337176957
   )
   static int field549;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = -295966887
   )
   static int field550;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -176610627
   )
   @Export("camera2")
   static int field551;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 312700441
   )
   @Export("camera3")
   static int field552;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = 1613474445
   )
   @Export("scale")
   static int field553;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 1127463229
   )
   static int field554;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = -800656115
   )
   static int field555;
   @ObfuscatedName("ow")
   @Export("friends")
   static class17[] field556;
   @ObfuscatedName("ob")
   static class195 field557;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -1836544595
   )
   @Export("mapScaleDelta")
   static int field558;
   @ObfuscatedName("ov")
   @Export("ignores")
   static class7[] field559;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 1388028429
   )
   static int field560;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 843519485
   )
   static int field561;
   @ObfuscatedName("lw")
   static int[] field562;
   @ObfuscatedName("t")
   static String field563;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      longValue = 3638050377703759691L
   )
   static long field564;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 391472895
   )
   static int field565;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -969386103
   )
   static int field566;
   @ObfuscatedName("pi")
   static int[] field567;
   @ObfuscatedName("du")
   static boolean field568;
   @ObfuscatedName("u")
   static class154 field570;

   public final void init() {
      if(this.method3104()) {
         class190[] var1 = new class190[]{class190.field3061, class190.field3049, class190.field3052, class190.field3062, class190.field3051, class190.field3050, class190.field3056, class190.field3055, class190.field3063, class190.field3053, class190.field3057, class190.field3059, class190.field3058, class190.field3054, class190.field3060};
         class190[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class190 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3064);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3064)) {
               case 1:
                  field548 = Integer.parseInt(var5);
                  break;
               case 2:
                  class44.field1018 = Integer.parseInt(var5);
               case 3:
               case 6:
               case 14:
               default:
                  break;
               case 4:
                  field292 = Integer.parseInt(var5);
                  break;
               case 5:
                  if(var5.equalsIgnoreCase("true")) {
                     field290 = true;
                  } else {
                     field290 = false;
                  }
                  break;
               case 7:
                  class98.field1634 = var5;
                  break;
               case 8:
                  class154[] var15 = new class154[]{class154.field2272, class154.field2270, class154.field2277, class154.field2271, class154.field2268, class154.field2269};
                  field570 = (class154)class157.method3181(var15, Integer.parseInt(var5));
                  if(class154.field2277 == field570) {
                     field289 = class212.field3142;
                  } else {
                     field289 = class212.field3138;
                  }
                  break;
               case 9:
                  int var7 = Integer.parseInt(var5);
                  class153[] var8 = class52.method1068();
                  int var9 = 0;

                  class153 var6;
                  while(true) {
                     if(var9 >= var8.length) {
                        var6 = null;
                        break;
                     }

                     class153 var10 = var8[var9];
                     if(var7 == var10.field2261) {
                        var6 = var10;
                        break;
                     }

                     ++var9;
                  }

                  class123.field2020 = var6;
                  break;
               case 10:
                  field477 = Integer.parseInt(var5);
                  break;
               case 11:
                  field563 = var5;
                  break;
               case 12:
                  field286 = Integer.parseInt(var5);
                  break;
               case 13:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 15:
                  class17.field254 = Integer.parseInt(var5);
               }
            }
         }

         class86.field1478 = false;
         field383 = false;
         class43.field1002 = this.getCodeBase().getHost();
         String var14 = class123.field2020.field2260;
         byte var11 = 0;

         try {
            class2.method35("oldschool", var14, var11, 16);
         } catch (Exception var13) {
            class7.method94((String)null, var13);
         }

         field284 = this;
         this.method3110(765, 503, 116);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1714457839"
   )
   protected final void vmethod3053() {
      class13.field200 = field548 == 0?'ꩊ':field286 + '鱀';
      field472 = field548 == 0?443:'썐' + field286;
      class16.field239 = class13.field200;
      class179.field2917 = class174.field2883;
      class34.field760 = class174.field2884;
      class179.field2922 = class174.field2885;
      class179.field2919 = class174.field2887;
      if(class26.field659.toLowerCase().indexOf("microsoft") != -1) {
         class137.field2107[186] = 57;
         class137.field2107[187] = 27;
         class137.field2107[188] = 71;
         class137.field2107[189] = 26;
         class137.field2107[190] = 72;
         class137.field2107[191] = 73;
         class137.field2107[192] = 58;
         class137.field2107[219] = 42;
         class137.field2107[220] = 74;
         class137.field2107[221] = 43;
         class137.field2107[222] = 59;
         class137.field2107[223] = 28;
      } else {
         class137.field2107[44] = 71;
         class137.field2107[45] = 26;
         class137.field2107[46] = 72;
         class137.field2107[47] = 73;
         class137.field2107[59] = 57;
         class137.field2107[61] = 27;
         class137.field2107[91] = 42;
         class137.field2107[92] = 74;
         class137.field2107[93] = 43;
         class137.field2107[192] = 28;
         class137.field2107[222] = 58;
         class137.field2107[520] = 59;
      }

      Canvas var1 = class46.field1040;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class137.field2081);
      var1.addFocusListener(class137.field2081);
      class29.method654(class46.field1040);
      class102.field1746 = class162.method3213();
      if(class102.field1746 != null) {
         class102.field1746.vmethod3114(class46.field1040);
      }

      class98.field1644 = new class134(255, class149.field2220, class149.field2221, 500000);
      class162.field2637 = class41.method864();
      class56.field1146 = this.getToolkit().getSystemClipboard();
      class110.method2433(this, class44.field1022);
      if(field548 != 0) {
         field302 = true;
      }

      class72.method1602(class162.field2637.field131);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   protected final void vmethod3055() {
      boolean var1 = class48.method989();
      if(var1 && field526 && class93.field1572 != null) {
         class93.field1572.method1181();
      }

      if(field294 == 10 || field294 == 20 || field294 == 30) {
         if(field500 != 0L && class90.method2090() > field500) {
            int var2 = field501?2:1;
            class72.method1602(var2);
         } else if(class144.field2189) {
            Canvas var11 = class46.field1040;
            var11.removeKeyListener(class137.field2081);
            var11.removeFocusListener(class137.field2081);
            class137.field2098 = -1;
            class135.method2907(class46.field1040);
            if(null != class102.field1746) {
               class102.field1746.vmethod3115(class46.field1040);
            }

            field284.method3083();
            class46.field1040.setBackground(Color.black);
            Canvas var3 = class46.field1040;
            var3.setFocusTraversalKeysEnabled(false);
            var3.addKeyListener(class137.field2081);
            var3.addFocusListener(class137.field2081);
            class29.method654(class46.field1040);
            if(class102.field1746 != null) {
               class102.field1746.vmethod3114(class46.field1040);
            }

            if(field456 != -1) {
               class85.method1921(field456, class45.field1026, class143.field2169, false);
            }

            class144.field2188 = true;
         }
      }

      Dimension var19 = this.method3058();
      if(class110.field1934 != var19.width || var19.height != class89.field1532 || class144.field2188) {
         class137.method2961();
         field500 = class90.method2090() + 500L;
         class144.field2188 = false;
      }

      boolean var12 = false;
      int var4;
      if(class144.field2186) {
         class144.field2186 = false;
         var12 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field507[var4] = true;
         }
      }

      if(var12) {
         class35.method737();
      }

      if(field294 == 0) {
         var4 = class31.field700;
         String var5 = class31.field709;
         Color var6 = null;

         try {
            Graphics var7 = class46.field1040.getGraphics();
            if(class56.field1168 == null) {
               class56.field1168 = new Font("Helvetica", 1, 13);
               class123.field2018 = class46.field1040.getFontMetrics(class56.field1168);
            }

            if(var12) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, class45.field1026, class143.field2169);
            }

            if(null == var6) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(class106.field1854 == null) {
                  class106.field1854 = class46.field1040.createImage(304, 34);
               }

               Graphics var8 = class106.field1854.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, 3 * var4, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(3 * var4 + 2, 2, 300 - 3 * var4, 30);
               var8.setFont(class56.field1168);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - class123.field2018.stringWidth(var5)) / 2, 22);
               var7.drawImage(class106.field1854, class45.field1026 / 2 - 152, class143.field2169 / 2 - 18, (ImageObserver)null);
            } catch (Exception var15) {
               int var9 = class45.field1026 / 2 - 152;
               int var10 = class143.field2169 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(var9 + 2, var10 + 2, var4 * 3, 30);
               var7.setColor(Color.black);
               var7.drawRect(1 + var9, var10 + 1, 301, 31);
               var7.fillRect(3 * var4 + 2 + var9, var10 + 2, 300 - var4 * 3, 30);
               var7.setFont(class56.field1168);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - class123.field2018.stringWidth(var5)) / 2, 22 + var10);
            }
         } catch (Exception var16) {
            class46.field1040.repaint();
         }
      } else if(field294 == 5) {
         class7.method92(class162.field2636, class43.field986, class44.field1021, var12);
      } else if(field294 != 10 && field294 != 11) {
         if(field294 == 20) {
            class7.method92(class162.field2636, class43.field986, class44.field1021, var12);
         } else if(field294 == 25) {
            if(field348 == 1) {
               if(field554 > field380) {
                  field380 = field554;
               }

               var4 = (field380 * 50 - field554 * 50) / field380;
               class47.method972("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field348 == 2) {
               if(field346 > field287) {
                  field287 = field346;
               }

               var4 = 50 + (field287 * 50 - field346 * 50) / field287;
               class47.method972("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class47.method972("Loading - please wait.", false);
            }
         } else if(field294 == 30) {
            class14.method168();
         } else if(field294 == 40) {
            class47.method972("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field294 == 45) {
            class47.method972("Please wait...", false);
         }
      } else {
         class7.method92(class162.field2636, class43.field986, class44.field1021, var12);
      }

      Graphics var13;
      int var14;
      if(field294 == 30 && field499 == 0 && !var12) {
         try {
            var13 = class46.field1040.getGraphics();

            for(var14 = 0; var14 < field490; ++var14) {
               if(field283[var14]) {
                  class48.field1049.vmethod1879(var13, field495[var14], field496[var14], field497[var14], field498[var14]);
                  field283[var14] = false;
               }
            }
         } catch (Exception var18) {
            class46.field1040.repaint();
         }
      } else if(field294 > 0) {
         try {
            var13 = class46.field1040.getGraphics();
            class48.field1049.vmethod1887(var13, 0, 0);

            for(var14 = 0; var14 < field490; ++var14) {
               field283[var14] = false;
            }
         } catch (Exception var17) {
            class46.field1040.repaint();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   protected final void vmethod3077() {
      if(class139.field2124.method199()) {
         class139.field2124.method196();
      }

      if(null != class12.field182) {
         class12.field182.field196 = false;
      }

      class12.field182 = null;
      if(null != class13.field195) {
         class13.field195.method3025();
         class13.field195 = null;
      }

      class166.method3262();
      if(class140.field2131 != null) {
         class140 var1 = class140.field2131;
         synchronized(class140.field2131) {
            class140.field2131 = null;
         }
      }

      class102.field1746 = null;
      if(class93.field1572 != null) {
         class93.field1572.method1215();
      }

      if(null != class50.field1074) {
         class50.field1074.method1215();
      }

      if(null != class171.field2719) {
         class171.field2719.method3025();
      }

      Object var7 = class170.field2706;
      synchronized(class170.field2706) {
         if(class170.field2701 != 0) {
            class170.field2701 = 1;

            try {
               class170.field2706.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      class129.method2856();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   void method234() {
      if(field294 != 1000) {
         boolean var1 = class109.method2432();
         if(!var1) {
            this.method235();
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "303568841"
   )
   void method235() {
      if(class171.field2725 >= 4) {
         this.method3056("js5crc");
         field294 = 1000;
      } else {
         if(class171.field2710 >= 4) {
            if(field294 <= 5) {
               this.method3056("js5io");
               field294 = 1000;
               return;
            }

            field316 = 3000;
            class171.field2710 = 3;
         }

         if(--field316 + 1 <= 0) {
            try {
               if(field315 == 0) {
                  class9.field153 = class40.field924.method2916(class43.field1002, class16.field239);
                  ++field315;
               }

               if(field315 == 1) {
                  if(class9.field153.field2199 == 2) {
                     this.method236(-1);
                     return;
                  }

                  if(class9.field153.field2199 == 1) {
                     ++field315;
                  }
               }

               if(field315 == 2) {
                  class114.field1949 = new class143((Socket)class9.field153.field2201, class40.field924);
                  class119 var1 = new class119(5);
                  var1.method2650(15);
                  var1.method2502(116);
                  class114.field1949.method3020(var1.field1982, 0, 5);
                  ++field315;
                  class102.field1750 = class90.method2090();
               }

               if(field315 == 3) {
                  if(field294 > 5 && class114.field1949.method3018() <= 0) {
                     if(class90.method2090() - class102.field1750 > 30000L) {
                        this.method236(-2);
                        return;
                     }
                  } else {
                     int var5 = class114.field1949.method3026();
                     if(var5 != 0) {
                        this.method236(var5);
                        return;
                     }

                     ++field315;
                  }
               }

               if(field315 == 4) {
                  class143 var10 = class114.field1949;
                  boolean var2 = field294 > 20;
                  if(null != class171.field2719) {
                     try {
                        class171.field2719.method3025();
                     } catch (Exception var8) {
                        ;
                     }

                     class171.field2719 = null;
                  }

                  class171.field2719 = var10;
                  class98.method2200(var2);
                  class171.field2726.field1976 = 0;
                  class137.field2099 = null;
                  class75.field1348 = null;
                  class171.field2721 = 0;

                  while(true) {
                     class172 var3 = (class172)class171.field2712.method3799();
                     if(null == var3) {
                        while(true) {
                           var3 = (class172)class171.field2717.method3799();
                           if(var3 == null) {
                              if(class171.field2724 != 0) {
                                 try {
                                    class119 var11 = new class119(4);
                                    var11.method2650(4);
                                    var11.method2650(class171.field2724);
                                    var11.method2695(0);
                                    class171.field2719.method3020(var11.field1982, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class171.field2719.method3025();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class171.field2710;
                                    class171.field2719 = null;
                                 }
                              }

                              class171.field2709 = 0;
                              class229.field3231 = class90.method2090();
                              class9.field153 = null;
                              class114.field1949 = null;
                              field315 = 0;
                              field298 = 0;
                              return;
                           }

                           class171.field2728.method3880(var3);
                           class171.field2715.method3797(var3, var3.field3113);
                           ++class171.field2716;
                           --class171.field2718;
                        }
                     }

                     class171.field2720.method3797(var3, var3.field3113);
                     ++class171.field2711;
                     --class171.field2713;
                  }
               }
            } catch (IOException var9) {
               this.method236(-3);
            }

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2092958606"
   )
   void method236(int var1) {
      class9.field153 = null;
      class114.field1949 = null;
      field315 = 0;
      if(class13.field200 == class16.field239) {
         class16.field239 = field472;
      } else {
         class16.field239 = class13.field200;
      }

      ++field298;
      if(field298 < 2 || var1 != 7 && var1 != 9) {
         if(field298 >= 2 && var1 == 6) {
            this.method3056("js5connect_outofdate");
            field294 = 1000;
         } else if(field298 >= 4) {
            if(field294 <= 5) {
               this.method3056("js5connect");
               field294 = 1000;
            } else {
               field316 = 3000;
            }
         }
      } else if(field294 <= 5) {
         this.method3056("js5connect_full");
         field294 = 1000;
      } else {
         field316 = 3000;
      }

   }

   static {
      field312 = class20.field574;
      field313 = class20.field574;
      field314 = 0;
      field315 = 0;
      field316 = 0;
      field298 = 0;
      field482 = 0;
      field345 = 0;
      field566 = 0;
      field468 = 0;
      field326 = new class34['耀'];
      field449 = 0;
      field318 = new int['耀'];
      field462 = 0;
      field330 = new int[250];
      field331 = new class122(5000);
      field479 = new class122(5000);
      field332 = new class122(15000);
      field334 = 0;
      field335 = 0;
      field441 = 0;
      field337 = 0;
      field338 = 0;
      field406 = 0;
      field540 = 0;
      field399 = 0;
      field342 = false;
      field554 = 0;
      field380 = 1;
      field346 = 0;
      field287 = 1;
      field348 = 0;
      field291 = new class108[4];
      field568 = false;
      field351 = new int[4][13][13];
      field369 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field444 = 0;
      field343 = 2;
      field523 = 0;
      field413 = 2;
      field357 = 0;
      field372 = 1;
      field411 = 0;
      field360 = 0;
      field361 = 2;
      field558 = 0;
      field363 = 1;
      field364 = 0;
      field538 = 0;
      field366 = 2301979;
      field367 = 5063219;
      field368 = 3353893;
      field325 = 7759444;
      field370 = false;
      field533 = 0;
      field403 = 128;
      field322 = 0;
      field375 = 0;
      field376 = 0;
      field390 = 0;
      field378 = 0;
      field379 = 50;
      field382 = 0;
      field381 = false;
      field450 = 0;
      field489 = 0;
      field384 = 50;
      field385 = new int[field384];
      field386 = new int[field384];
      field455 = new int[field384];
      field388 = new int[field384];
      field389 = new int[field384];
      field457 = new int[field384];
      field391 = new int[field384];
      field392 = new String[field384];
      field393 = new int[104][104];
      field565 = 0;
      field395 = -1;
      field544 = -1;
      field397 = 0;
      field398 = 0;
      field304 = 0;
      field400 = 0;
      field401 = 0;
      field402 = 0;
      field347 = 0;
      field404 = 0;
      field405 = 0;
      field320 = 0;
      field407 = false;
      field408 = 0;
      field409 = 0;
      field410 = new class2[2048];
      field430 = -1;
      field412 = 0;
      field344 = 0;
      field414 = new int[1000];
      field415 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field416 = new String[8];
      field417 = new boolean[8];
      field418 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field329 = -1;
      field420 = new class199[4][104][104];
      field421 = new class199();
      field422 = new class199();
      field423 = new class199();
      field356 = new int[25];
      field425 = new int[25];
      field426 = new int[25];
      field427 = 0;
      field428 = false;
      field429 = 0;
      field419 = new int[500];
      field431 = new int[500];
      field432 = new int[500];
      field433 = new int[500];
      field434 = new String[500];
      field396 = new String[500];
      field436 = -1;
      field437 = -1;
      field518 = 0;
      field321 = 50;
      field352 = 0;
      field349 = null;
      field442 = false;
      field443 = -1;
      field319 = -1;
      field445 = null;
      field446 = null;
      field456 = -1;
      field448 = new class196(8);
      field377 = 0;
      field362 = 0;
      field451 = null;
      field452 = 0;
      field453 = 0;
      field354 = 0;
      field374 = -1;
      field454 = false;
      field336 = false;
      field439 = false;
      field459 = null;
      field460 = null;
      field461 = null;
      field560 = 0;
      field463 = 0;
      field464 = null;
      field465 = false;
      field440 = -1;
      field447 = -1;
      field341 = false;
      field438 = -1;
      field470 = -1;
      field545 = false;
      field359 = 1;
      field473 = new int[32];
      field474 = 0;
      field475 = new int[32];
      field476 = 0;
      field471 = new int[32];
      field467 = 0;
      field435 = 0;
      field492 = 0;
      field288 = 0;
      field327 = 0;
      field483 = 0;
      field484 = 0;
      field485 = 0;
      field486 = new class199();
      field487 = new class199();
      field488 = new class199();
      field311 = new class196(512);
      field490 = 0;
      field491 = -2;
      field507 = new boolean[100];
      field283 = new boolean[100];
      field494 = new boolean[100];
      field495 = new int[100];
      field496 = new int[100];
      field497 = new int[100];
      field498 = new int[100];
      field499 = 0;
      field500 = 0L;
      field501 = true;
      field502 = 765;
      field353 = 1;
      field562 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field355 = 0;
      field506 = 0;
      field503 = "";
      field350 = new long[100];
      field509 = 0;
      field510 = 0;
      field511 = new int[128];
      field512 = new int[128];
      field505 = -1L;
      field514 = null;
      field515 = null;
      field303 = -1;
      field373 = 0;
      field293 = new int[1000];
      field387 = new int[1000];
      field520 = new class78[1000];
      field521 = 0;
      field522 = 0;
      field493 = 0;
      field524 = 255;
      field525 = -1;
      field526 = false;
      field527 = 127;
      field365 = 127;
      field504 = 0;
      field530 = new int[50];
      field531 = new int[50];
      field532 = new int[50];
      field480 = new int[50];
      field534 = new class58[50];
      field535 = false;
      field536 = new boolean[5];
      field481 = new int[5];
      field529 = new int[5];
      field539 = new int[5];
      field324 = new int[5];
      field541 = 256;
      field542 = 205;
      field543 = 256;
      field537 = 320;
      field547 = 1;
      field546 = 32767;
      field328 = 1;
      field516 = 32767;
      field549 = 0;
      field550 = 0;
      field551 = 0;
      field552 = 0;
      field553 = 0;
      field340 = 0;
      field555 = 0;
      field556 = new class17[400];
      field557 = new class195();
      field513 = 0;
      field559 = new class7[400];
      field339 = new class179();
      field561 = -1;
      field517 = -1;
      field528 = new class220[8];
      field564 = -1L;
      field424 = -1L;
      field394 = new class10();
      field567 = new int[50];
      field469 = new int[50];
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "484717246"
   )
   static final void method272(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class84.method1909(var0)) {
         class42.field968 = null;
         class72.method1597(class173.field2750[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class42.field968 != null) {
            class72.method1597(class42.field968, -1412584499, var1, var2, var3, var4, class101.field1740, class7.field125, var7);
            class42.field968 = null;
         }

      } else {
         if(var7 != -1) {
            field507[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               field507[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-614007547"
   )
   @Export("packetHandler")
   protected final void vmethod3054() {
      ++field296;
      this.method234();

      while(true) {
         class199 var2 = class170.field2704;
         class169 var1;
         synchronized(class170.field2704) {
            var1 = (class169)class170.field2702.method3833();
         }

         if(null == var1) {
            int var51;
            try {
               if(class183.field2953 == 1) {
                  var51 = class183.field2952.method3609();
                  if(var51 > 0 && class183.field2952.method3707()) {
                     var51 -= class183.field2955;
                     if(var51 < 0) {
                        var51 = 0;
                     }

                     class183.field2952.method3608(var51);
                  } else {
                     class183.field2952.method3614();
                     class183.field2952.method3612();
                     if(class50.field1075 != null) {
                        class183.field2953 = 2;
                     } else {
                        class183.field2953 = 0;
                     }

                     class0.field0 = null;
                     class177.field2906 = null;
                  }
               }
            } catch (Exception var80) {
               var80.printStackTrace();
               class183.field2952.method3614();
               class183.field2953 = 0;
               class0.field0 = null;
               class177.field2906 = null;
               class50.field1075 = null;
            }

            class124.method2824();
            class0.method2();
            class140 var81 = class140.field2131;
            synchronized(class140.field2131) {
               class140.field2133 = class140.field2130;
               class140.field2134 = class140.field2132;
               class140.field2135 = class140.field2136;
               class140.field2140 = class140.field2128;
               class140.field2141 = class140.field2137;
               class140.field2142 = class140.field2138;
               class140.field2143 = class140.field2139;
               class140.field2128 = 0;
            }

            if(null != class102.field1746) {
               var51 = class102.field1746.vmethod3116();
               field485 = var51;
            }

            int var5;
            int var7;
            int var8;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var52;
            int var53;
            int var54;
            int var56;
            int var59;
            class16 var88;
            if(field294 == 0) {
               class175.method3453();
               class109.field1888.vmethod3124();

               for(var51 = 0; var51 < 32; ++var51) {
                  class144.field2178[var51] = 0L;
               }

               for(var51 = 0; var51 < 32; ++var51) {
                  class144.field2183[var51] = 0L;
               }

               class17.field253 = 0;
            } else if(field294 == 5) {
               class109.method2429(this);
               class175.method3453();
               class109.field1888.vmethod3124();

               for(var51 = 0; var51 < 32; ++var51) {
                  class144.field2178[var51] = 0L;
               }

               for(var51 = 0; var51 < 32; ++var51) {
                  class144.field2183[var51] = 0L;
               }

               class17.field253 = 0;
            } else if(field294 != 10 && field294 != 11) {
               if(field294 == 20) {
                  class109.method2429(this);
                  class151.method3155();
               } else if(field294 == 25) {
                  class13.method159(false);
                  field554 = 0;
                  boolean var122 = true;

                  for(var52 = 0; var52 < class13.field199.length; ++var52) {
                     if(class59.field1184[var52] != -1 && class13.field199[var52] == null) {
                        class13.field199[var52] = class35.field771.method3266(class59.field1184[var52], 0);
                        if(null == class13.field199[var52]) {
                           var122 = false;
                           ++field554;
                        }
                     }

                     if(class98.field1643[var52] != -1 && null == class183.field2954[var52]) {
                        class183.field2954[var52] = class35.field771.method3267(class98.field1643[var52], 0, class217.field3163[var52]);
                        if(class183.field2954[var52] == null) {
                           var122 = false;
                           ++field554;
                        }
                     }
                  }

                  if(!var122) {
                     field348 = 1;
                  } else {
                     field346 = 0;
                     var122 = true;

                     for(var52 = 0; var52 < class13.field199.length; ++var52) {
                        byte[] var3 = class183.field2954[var52];
                        if(null != var3) {
                           var53 = (class141.field2153[var52] >> 8) * 64 - class4.field62;
                           var5 = 64 * (class141.field2153[var52] & 255) - class85.field1434;
                           if(field568) {
                              var53 = 10;
                              var5 = 10;
                           }

                           var122 &= class14.method166(var3, var53, var5);
                        }
                     }

                     if(!var122) {
                        field348 = 2;
                     } else {
                        if(field348 != 0) {
                           class47.method972("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class124.method2824();
                        class99.method2203();
                        class124.method2824();
                        class150.field2230.method2006();
                        class124.method2824();
                        System.gc();

                        for(var52 = 0; var52 < 4; ++var52) {
                           field291[var52].method2419();
                        }

                        for(var52 = 0; var52 < 4; ++var52) {
                           for(var54 = 0; var54 < 104; ++var54) {
                              for(var53 = 0; var53 < 104; ++var53) {
                                 class5.field69[var52][var54][var53] = 0;
                              }
                           }
                        }

                        class124.method2824();
                        class172.method3398();
                        var52 = class13.field199.length;
                        class99.method2201();
                        class13.method159(true);
                        int var17;
                        int var18;
                        int var20;
                        int var21;
                        int var22;
                        if(!field568) {
                           var54 = 0;

                           label3991:
                           while(true) {
                              byte[] var6;
                              if(var54 >= var52) {
                                 for(var54 = 0; var54 < var52; ++var54) {
                                    var53 = 64 * (class141.field2153[var54] >> 8) - class4.field62;
                                    var5 = 64 * (class141.field2153[var54] & 255) - class85.field1434;
                                    var6 = class13.field199[var54];
                                    if(var6 == null && field371 < 800) {
                                       class124.method2824();
                                       class15.method175(var53, var5, 64, 64);
                                    }
                                 }

                                 class13.method159(true);
                                 var54 = 0;

                                 while(true) {
                                    if(var54 >= var52) {
                                       break label3991;
                                    }

                                    byte[] var4 = class183.field2954[var54];
                                    if(null != var4) {
                                       var5 = (class141.field2153[var54] >> 8) * 64 - class4.field62;
                                       var56 = 64 * (class141.field2153[var54] & 255) - class85.field1434;
                                       class124.method2824();
                                       class86 var57 = class150.field2230;
                                       class108[] var58 = field291;
                                       class119 var96 = new class119(var4);
                                       var10 = -1;

                                       while(true) {
                                          var11 = var96.method2642();
                                          if(var11 == 0) {
                                             break;
                                          }

                                          var10 += var11;
                                          var12 = 0;

                                          while(true) {
                                             var13 = var96.method2642();
                                             if(var13 == 0) {
                                                break;
                                             }

                                             var12 += var13 - 1;
                                             var14 = var12 & 63;
                                             var15 = var12 >> 6 & 63;
                                             var16 = var12 >> 12;
                                             var17 = var96.method2514();
                                             var18 = var17 >> 2;
                                             int var19 = var17 & 3;
                                             var20 = var5 + var15;
                                             var21 = var56 + var14;
                                             if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                                var22 = var16;
                                                if((class5.field69[1][var20][var21] & 2) == 2) {
                                                   var22 = var16 - 1;
                                                }

                                                class108 var23 = null;
                                                if(var22 >= 0) {
                                                   var23 = var58[var22];
                                                }

                                                class1.method8(var16, var20, var21, var10, var19, var18, var57, var23);
                                             }
                                          }
                                       }
                                    }

                                    ++var54;
                                 }
                              }

                              var53 = (class141.field2153[var54] >> 8) * 64 - class4.field62;
                              var5 = 64 * (class141.field2153[var54] & 255) - class85.field1434;
                              var6 = class13.field199[var54];
                              if(var6 != null) {
                                 class124.method2824();
                                 var7 = class153.field2265 * 8 - 48;
                                 var8 = field371 * 8 - 48;
                                 class108[] var9 = field291;
                                 var10 = 0;

                                 label3988:
                                 while(true) {
                                    if(var10 >= 4) {
                                       class119 var55 = new class119(var6);
                                       var11 = 0;

                                       while(true) {
                                          if(var11 >= 4) {
                                             break label3988;
                                          }

                                          for(var12 = 0; var12 < 64; ++var12) {
                                             for(var13 = 0; var13 < 64; ++var13) {
                                                class177.method3464(var55, var11, var12 + var53, var13 + var5, var7, var8, 0);
                                             }
                                          }

                                          ++var11;
                                       }
                                    }

                                    for(var11 = 0; var11 < 64; ++var11) {
                                       for(var12 = 0; var12 < 64; ++var12) {
                                          if(var11 + var53 > 0 && var53 + var11 < 103 && var12 + var5 > 0 && var12 + var5 < 103) {
                                             var9[var10].field1884[var11 + var53][var12 + var5] &= -16777217;
                                          }
                                       }
                                    }

                                    ++var10;
                                 }
                              }

                              ++var54;
                           }
                        }

                        if(field568) {
                           var54 = 0;

                           label3924:
                           while(true) {
                              class108[] var61;
                              class119 var62;
                              int var63;
                              if(var54 >= 4) {
                                 for(var54 = 0; var54 < 13; ++var54) {
                                    for(var53 = 0; var53 < 13; ++var53) {
                                       var5 = field351[0][var54][var53];
                                       if(var5 == -1) {
                                          class15.method175(var54 * 8, var53 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 class13.method159(true);
                                 var54 = 0;

                                 while(true) {
                                    if(var54 >= 4) {
                                       break label3924;
                                    }

                                    class124.method2824();

                                    for(var53 = 0; var53 < 13; ++var53) {
                                       label3847:
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var56 = field351[var54][var53][var5];
                                          if(var56 != -1) {
                                             var7 = var56 >> 24 & 3;
                                             var8 = var56 >> 1 & 3;
                                             var59 = var56 >> 14 & 1023;
                                             var10 = var56 >> 3 & 2047;
                                             var11 = (var59 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < class141.field2153.length; ++var12) {
                                                if(var11 == class141.field2153[var12] && class183.field2954[var12] != null) {
                                                   byte[] var64 = class183.field2954[var12];
                                                   var14 = var53 * 8;
                                                   var15 = var5 * 8;
                                                   var16 = 8 * (var59 & 7);
                                                   var17 = (var10 & 7) * 8;
                                                   class86 var65 = class150.field2230;
                                                   var61 = field291;
                                                   var62 = new class119(var64);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var62.method2642();
                                                      if(var22 == 0) {
                                                         continue label3847;
                                                      }

                                                      var21 += var22;
                                                      var63 = 0;

                                                      while(true) {
                                                         int var24 = var62.method2642();
                                                         if(var24 == 0) {
                                                            break;
                                                         }

                                                         var63 += var24 - 1;
                                                         int var25 = var63 & 63;
                                                         int var26 = var63 >> 6 & 63;
                                                         int var27 = var63 >> 12;
                                                         int var28 = var62.method2514();
                                                         int var29 = var28 >> 2;
                                                         int var30 = var28 & 3;
                                                         if(var27 == var7 && var26 >= var16 && var26 < 8 + var16 && var25 >= var17 && var25 < var17 + 8) {
                                                            class40 var31 = class172.method3399(var21);
                                                            int var34 = var26 & 7;
                                                            int var35 = var25 & 7;
                                                            int var37 = var31.field915;
                                                            int var38 = var31.field904;
                                                            int var39;
                                                            if((var30 & 1) == 1) {
                                                               var39 = var37;
                                                               var37 = var38;
                                                               var38 = var39;
                                                            }

                                                            int var36 = var8 & 3;
                                                            int var33;
                                                            if(var36 == 0) {
                                                               var33 = var34;
                                                            } else if(var36 == 1) {
                                                               var33 = var35;
                                                            } else if(var36 == 2) {
                                                               var33 = 7 - var34 - (var37 - 1);
                                                            } else {
                                                               var33 = 7 - var35 - (var38 - 1);
                                                            }

                                                            var39 = var33 + var14;
                                                            int var42 = var26 & 7;
                                                            int var43 = var25 & 7;
                                                            int var45 = var31.field915;
                                                            int var46 = var31.field904;
                                                            int var47;
                                                            if((var30 & 1) == 1) {
                                                               var47 = var45;
                                                               var45 = var46;
                                                               var46 = var47;
                                                            }

                                                            int var44 = var8 & 3;
                                                            int var41;
                                                            if(var44 == 0) {
                                                               var41 = var43;
                                                            } else if(var44 == 1) {
                                                               var41 = 7 - var42 - (var45 - 1);
                                                            } else if(var44 == 2) {
                                                               var41 = 7 - var43 - (var46 - 1);
                                                            } else {
                                                               var41 = var42;
                                                            }

                                                            var47 = var15 + var41;
                                                            if(var39 > 0 && var47 > 0 && var39 < 103 && var47 < 103) {
                                                               int var48 = var54;
                                                               if((class5.field69[1][var39][var47] & 2) == 2) {
                                                                  var48 = var54 - 1;
                                                               }

                                                               class108 var49 = null;
                                                               if(var48 >= 0) {
                                                                  var49 = var61[var48];
                                                               }

                                                               class1.method8(var54, var39, var47, var21, var30 + var8 & 3, var29, var65, var49);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var54;
                                 }
                              }

                              class124.method2824();

                              for(var53 = 0; var53 < 13; ++var53) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var126 = false;
                                    var7 = field351[var54][var53][var5];
                                    if(var7 != -1) {
                                       var8 = var7 >> 24 & 3;
                                       var59 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var13 = 0; var13 < class141.field2153.length; ++var13) {
                                          if(var12 == class141.field2153[var13] && class13.field199[var13] != null) {
                                             byte[] var60 = class13.field199[var13];
                                             var15 = var53 * 8;
                                             var16 = 8 * var5;
                                             var17 = (var10 & 7) * 8;
                                             var18 = 8 * (var11 & 7);
                                             var61 = field291;

                                             for(var20 = 0; var20 < 8; ++var20) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var20 + var15 > 0 && var20 + var15 < 103 && var16 + var21 > 0 && var21 + var16 < 103) {
                                                      var61[var54].field1884[var15 + var20][var16 + var21] &= -16777217;
                                                   }
                                                }
                                             }

                                             var62 = new class119(var60);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(var63 = 0; var63 < 64; ++var63) {
                                                      if(var8 == var21 && var22 >= var17 && var22 < var17 + 8 && var63 >= var18 && var63 < var18 + 8) {
                                                         class177.method3464(var62, var54, var15 + class127.method2854(var22 & 7, var63 & 7, var59), var16 + class14.method167(var22 & 7, var63 & 7, var59), 0, 0, var59);
                                                      } else {
                                                         class177.method3464(var62, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var126 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var126) {
                                       class40.method802(var54, 8 * var53, var5 * 8);
                                    }
                                 }
                              }

                              ++var54;
                           }
                        }

                        class13.method159(true);
                        class99.method2203();
                        class124.method2824();
                        class4.method38(class150.field2230, field291);
                        class13.method159(true);
                        var54 = class5.field70;
                        if(var54 > class144.field2193) {
                           var54 = class144.field2193;
                        }

                        if(var54 < class144.field2193 - 1) {
                           var54 = class144.field2193 - 1;
                        }

                        if(field383) {
                           class150.field2230.method2083(class5.field70);
                        } else {
                           class150.field2230.method2083(0);
                        }

                        for(var53 = 0; var53 < 104; ++var53) {
                           for(var5 = 0; var5 < 104; ++var5) {
                              class93.method2171(var53, var5);
                           }
                        }

                        class124.method2824();

                        for(var88 = (class16)field421.method3844(); null != var88; var88 = (class16)field421.method3834()) {
                           if(var88.field233 == -1) {
                              var88.field241 = 0;
                              class21.method558(var88);
                           } else {
                              var88.method3916();
                           }
                        }

                        class40.field901.method3755();
                        if(null != class75.field1346) {
                           field331.method2781(194);
                           field331.method2502(1057001181);
                        }

                        if(!field568) {
                           var53 = (class153.field2265 - 6) / 8;
                           var5 = (class153.field2265 + 6) / 8;
                           var56 = (field371 - 6) / 8;
                           var7 = (field371 + 6) / 8;

                           for(var8 = var53 - 1; var8 <= 1 + var5; ++var8) {
                              for(var59 = var56 - 1; var59 <= var7 + 1; ++var59) {
                                 if(var8 < var53 || var8 > var5 || var59 < var56 || var59 > var7) {
                                    class35.field771.method3286("m" + var8 + "_" + var59);
                                    class35.field771.method3286("l" + var8 + "_" + var59);
                                 }
                              }
                           }
                        }

                        class43.method919(30);
                        class124.method2824();
                        class5.field71 = (byte[][][])null;
                        class5.field72 = (byte[][][])null;
                        class5.field73 = (byte[][][])null;
                        class49.field1067 = (byte[][][])null;
                        class149.field2225 = (int[][][])null;
                        class5.field91 = (byte[][][])null;
                        class41.field957 = (int[][])null;
                        class9.field144 = null;
                        class14.field212 = null;
                        class41.field954 = null;
                        class76.field1356 = null;
                        class10.field161 = null;
                        field331.method2781(38);
                        class109.field1888.vmethod3124();

                        for(var53 = 0; var53 < 32; ++var53) {
                           class144.field2178[var53] = 0L;
                        }

                        for(var53 = 0; var53 < 32; ++var53) {
                           class144.field2183[var53] = 0L;
                        }

                        class17.field253 = 0;
                     }
                  }
               }
            } else {
               class109.method2429(this);
            }

            if(field294 == 30) {
               if(field519 > 1) {
                  --field519;
               }

               if(field399 > 0) {
                  --field399;
               }

               if(field342) {
                  field342 = false;
                  class157.method3180();
               } else {
                  if(!field428) {
                     field434[0] = "Cancel";
                     field396[0] = "";
                     field432[0] = 1006;
                     field429 = 1;
                  }

                  String var90;
                  String var92;
                  long var113;
                  boolean var114;
                  class173 var128;
                  String var151;
                  class173 var154;
                  for(var51 = 0; var51 < 100; ++var51) {
                     boolean var121;
                     if(null == class13.field195) {
                        var121 = false;
                     } else {
                        label4258: {
                           try {
                              var54 = class13.field195.method3018();
                              if(var54 == 0) {
                                 var121 = false;
                                 break label4258;
                              }

                              if(field335 == -1) {
                                 class13.field195.method3019(field332.field1982, 0, 1);
                                 field332.field1976 = 0;
                                 field335 = field332.method2787();
                                 field334 = class188.field3045[field335];
                                 --var54;
                              }

                              if(field334 == -1) {
                                 if(var54 <= 0) {
                                    var121 = false;
                                    break label4258;
                                 }

                                 class13.field195.method3019(field332.field1982, 0, 1);
                                 field334 = field332.field1982[0] & 255;
                                 --var54;
                              }

                              if(field334 == -2) {
                                 if(var54 <= 1) {
                                    var121 = false;
                                    break label4258;
                                 }

                                 class13.field195.method3019(field332.field1982, 0, 2);
                                 field332.field1976 = 0;
                                 field334 = field332.method2516();
                                 var54 -= 2;
                              }

                              if(var54 < field334) {
                                 var121 = false;
                                 break label4258;
                              }

                              field332.field1976 = 0;
                              class13.field195.method3019(field332.field1982, 0, field334);
                              field441 = 0;
                              field540 = field406;
                              field406 = field338 * -1;
                              field338 = field335 * -1;
                              class173 var91;
                              if(field335 == 208) {
                                 var53 = field332.method2559();
                                 var5 = field332.method2548();
                                 var91 = class161.method3205(var53);
                                 if(null != var91 && var91.field2833 == 0) {
                                    if(var5 > var91.field2772 - var91.field2764) {
                                       var5 = var91.field2772 - var91.field2764;
                                    }

                                    if(var5 < 0) {
                                       var5 = 0;
                                    }

                                    if(var5 != var91.field2770) {
                                       var91.field2770 = var5;
                                       class4.method37(var91);
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              boolean var100;
                              if(field335 == 161) {
                                 var90 = field332.method2522();
                                 var5 = field332.method2516();
                                 byte var149 = field332.method2515();
                                 var100 = false;
                                 if(var149 == -128) {
                                    var100 = true;
                                 }

                                 if(var100) {
                                    if(class116.field1957 == 0) {
                                       field335 = -1;
                                       var121 = true;
                                       break label4258;
                                    }

                                    var114 = false;

                                    for(var8 = 0; var8 < class116.field1957 && (!class40.field923[var8].field617.equals(var90) || var5 != class40.field923[var8].field619); ++var8) {
                                       ;
                                    }

                                    if(var8 < class116.field1957) {
                                       while(var8 < class116.field1957 - 1) {
                                          class40.field923[var8] = class40.field923[var8 + 1];
                                          ++var8;
                                       }

                                       --class116.field1957;
                                       class40.field923[class116.field1957] = null;
                                    }
                                 } else {
                                    field332.method2522();
                                    class24 var142 = new class24();
                                    var142.field617 = var90;
                                    var142.field618 = class39.method796(var142.field617, field289);
                                    var142.field619 = var5;
                                    var142.field622 = var149;

                                    for(var59 = class116.field1957 - 1; var59 >= 0; --var59) {
                                       var10 = class40.field923[var59].field618.compareTo(var142.field618);
                                       if(var10 == 0) {
                                          class40.field923[var59].field619 = var5;
                                          class40.field923[var59].field622 = var149;
                                          if(var90.equals(class153.field2262.field26)) {
                                             class119.field1986 = var149;
                                          }

                                          field288 = field359;
                                          field335 = -1;
                                          var121 = true;
                                          break label4258;
                                       }

                                       if(var10 < 0) {
                                          break;
                                       }
                                    }

                                    if(class116.field1957 >= class40.field923.length) {
                                       field335 = -1;
                                       var121 = true;
                                       break label4258;
                                    }

                                    for(var10 = class116.field1957 - 1; var10 > var59; --var10) {
                                       class40.field923[1 + var10] = class40.field923[var10];
                                    }

                                    if(class116.field1957 == 0) {
                                       class40.field923 = new class24[100];
                                    }

                                    class40.field923[1 + var59] = var142;
                                    ++class116.field1957;
                                    if(var90.equals(class153.field2262.field26)) {
                                       class119.field1986 = var149;
                                    }
                                 }

                                 field288 = field359;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 122) {
                                 for(var53 = 0; var53 < class52.field1129; ++var53) {
                                    class52 var155 = class20.method553(var53);
                                    if(var155 != null) {
                                       class176.field2894[var53] = 0;
                                       class176.field2896[var53] = 0;
                                    }
                                 }

                                 class52.method1069();
                                 field474 += 32;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 43) {
                                 var53 = field332.method2519();
                                 var5 = field332.method2516();
                                 if(var53 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var53 >= 0) {
                                    var91 = class161.method3205(var53);
                                 } else {
                                    var91 = null;
                                 }

                                 class82.method1890(var5);
                                 var7 = field332.method2516();

                                 for(var8 = 0; var8 < var7; ++var8) {
                                    var59 = field332.method2542();
                                    if(var59 == 255) {
                                       var59 = field332.method2519();
                                    }

                                    var10 = field332.method2516();
                                    if(null != var91 && var8 < var91.field2866.length) {
                                       var91.field2866[var8] = var10;
                                       var91.field2745[var8] = var59;
                                    }

                                    class113.method2451(var5, var8, var10 - 1, var59);
                                 }

                                 if(null != var91) {
                                    class4.method37(var91);
                                 }

                                 class52.method1069();
                                 field475[++field476 - 1 & 31] = var5 & 32767;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 44) {
                                 class18.field264 = field332.method2574();
                                 class39.field882 = field332.method2574();

                                 while(field332.field1976 < field334) {
                                    field335 = field332.method2514();
                                    class48.method990();
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 226) {
                                 field555 = 1;
                                 field492 = field359;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              long var110;
                              boolean var115;
                              long var119;
                              long var141;
                              String var157;
                              if(field335 == 237) {
                                 var90 = field332.method2522();
                                 var113 = field332.method2699();
                                 var110 = (long)field332.method2516();
                                 var141 = (long)field332.method2518();
                                 class152 var152 = (class152)class157.method3181(class4.method39(), field332.method2514());
                                 var119 = (var110 << 32) + var141;
                                 var115 = false;

                                 for(var15 = 0; var15 < 100; ++var15) {
                                    if(field350[var15] == var119) {
                                       var115 = true;
                                       break;
                                    }
                                 }

                                 if(var152.field2252 && class45.method953(var90)) {
                                    var115 = true;
                                 }

                                 if(!var115 && field409 == 0) {
                                    field350[field509] = var119;
                                    field509 = (1 + field509) % 100;
                                    class122 var68 = field332;
                                    var157 = class175.method3455(var68, 32767);
                                    String var70 = class223.method4032(class82.method1896(var157));
                                    if(var152.field2249 != -1) {
                                       class22.method571(9, class56.method1172(var152.field2249) + var90, var70, class103.method2293(var113));
                                    } else {
                                       class22.method571(9, var90, var70, class103.method2293(var113));
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 69) {
                                 field355 = field332.method2514();
                                 field506 = field332.method2514();
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 54) {
                                 var53 = field332.method2548();
                                 var5 = field332.method2559();
                                 var56 = field332.method2661();
                                 var128 = class161.method3205(var5);
                                 var128.field2779 = var56 + (var53 << 16);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 11) {
                                 var53 = field332.method2560();
                                 var5 = field332.method2559();
                                 var56 = field332.method2516();
                                 if(var56 == '\uffff') {
                                    var56 = -1;
                                 }

                                 var128 = class161.method3205(var5);
                                 class51 var138;
                                 if(!var128.field2741) {
                                    if(var56 == -1) {
                                       var128.field2791 = 0;
                                       field335 = -1;
                                       var121 = true;
                                       break label4258;
                                    }

                                    var138 = class35.method741(var56);
                                    var128.field2791 = 4;
                                    var128.field2792 = var56;
                                    var128.field2839 = var138.field1091;
                                    var128.field2800 = var138.field1083;
                                    var128.field2802 = var138.field1106 * 100 / var53;
                                    class4.method37(var128);
                                 } else {
                                    var128.field2868 = var56;
                                    var128.field2871 = var53;
                                    var138 = class35.method741(var56);
                                    var128.field2839 = var138.field1091;
                                    var128.field2800 = var138.field1083;
                                    var128.field2844 = var138.field1093;
                                    var128.field2797 = var138.field1089;
                                    var128.field2798 = var138.field1095;
                                    var128.field2802 = var138.field1106;
                                    if(var138.field1096 == 1) {
                                       var128.field2806 = 1;
                                    } else {
                                       var128.field2806 = 2;
                                    }

                                    if(var128.field2803 > 0) {
                                       var128.field2802 = var128.field2802 * 32 / var128.field2803;
                                    } else if(var128.field2759 > 0) {
                                       var128.field2802 = var128.field2802 * 32 / var128.field2759;
                                    }

                                    class4.method37(var128);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              boolean var108;
                              if(field335 == 72) {
                                 var53 = field332.method2642();
                                 var108 = field332.method2514() == 1;
                                 var92 = "";
                                 var100 = false;
                                 if(var108) {
                                    var92 = field332.method2522();
                                    if(class45.method953(var92)) {
                                       var100 = true;
                                    }
                                 }

                                 String var137 = field332.method2522();
                                 if(!var100) {
                                    class45.method955(var53, var92, var137);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 216) {
                                 var53 = field332.method2519();
                                 var5 = field332.method2516();
                                 if(var53 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var53 >= 0) {
                                    var91 = class161.method3205(var53);
                                 } else {
                                    var91 = null;
                                 }

                                 for(; field332.field1976 < field334; class113.method2451(var5, var7, var8 - 1, var59)) {
                                    var7 = field332.method2642();
                                    var8 = field332.method2516();
                                    var59 = 0;
                                    if(var8 != 0) {
                                       var59 = field332.method2514();
                                       if(var59 == 255) {
                                          var59 = field332.method2519();
                                       }
                                    }

                                    if(var91 != null && var7 >= 0 && var7 < var91.field2866.length) {
                                       var91.field2866[var7] = var8;
                                       var91.field2745[var7] = var59;
                                    }
                                 }

                                 if(null != var91) {
                                    class4.method37(var91);
                                 }

                                 class52.method1069();
                                 field475[++field476 - 1 & 31] = var5 & 32767;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              class3 var135;
                              if(field335 == 62) {
                                 var53 = field332.method2560();
                                 var5 = field332.method2540();
                                 var56 = field332.method2550();
                                 var135 = (class3)field448.method3807((long)var53);
                                 if(null != var135) {
                                    class139.method2971(var135, var56 != var135.field60);
                                 }

                                 class159.method3189(var53, var56, var5);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 131) {
                                 class139.method2973(true);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 198) {
                                 class139.method2973(false);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 253) {
                                 var53 = field332.method2559();
                                 var154 = class161.method3205(var53);

                                 for(var56 = 0; var56 < var154.field2866.length; ++var56) {
                                    var154.field2866[var56] = -1;
                                    var154.field2866[var56] = 0;
                                 }

                                 class4.method37(var154);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 186) {
                                 var53 = field332.method2661();
                                 field456 = var53;
                                 class85.method1921(field456, class45.field1026, class143.field2169, false);
                                 class14.method164(var53);
                                 class32.method711(field456);

                                 for(var5 = 0; var5 < 100; ++var5) {
                                    field507[var5] = true;
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 38) {
                                 field521 = field332.method2514();
                                 if(field521 == 255) {
                                    field521 = 0;
                                 }

                                 field522 = field332.method2514();
                                 if(field522 == 255) {
                                    field522 = 0;
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 68) {
                                 for(var53 = 0; var53 < field410.length; ++var53) {
                                    if(null != field410[var53]) {
                                       field410[var53].field801 = -1;
                                    }
                                 }

                                 for(var53 = 0; var53 < field326.length; ++var53) {
                                    if(null != field326[var53]) {
                                       field326[var53].field801 = -1;
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 225) {
                                 var53 = field332.method2738();
                                 var154 = class161.method3205(var53);
                                 var154.field2791 = 3;
                                 var154.field2792 = class153.field2262.field49.method3494();
                                 class4.method37(var154);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 162) {
                                 var53 = field332.method2559();
                                 var5 = field332.method2661();
                                 var91 = class161.method3205(var53);
                                 if(var91.field2791 != 2 || var91.field2792 != var5) {
                                    var91.field2791 = 2;
                                    var91.field2792 = var5;
                                    class4.method37(var91);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 46) {
                                 class158.method3182();
                                 field335 = -1;
                                 var121 = false;
                                 break label4258;
                              }

                              if(field335 == 20) {
                                 class134.method2905(field332.method2522());
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 223) {
                                 field535 = false;

                                 for(var53 = 0; var53 < 5; ++var53) {
                                    field536[var53] = false;
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 51) {
                                 if(field456 != -1) {
                                    var53 = field456;
                                    if(class84.method1909(var53)) {
                                       class31.method705(class173.field2750[var53], 0);
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              class173 var136;
                              if(field335 == 212) {
                                 var53 = field332.method2550();
                                 var5 = field332.method2550();
                                 var56 = field332.method2738();
                                 var7 = field332.method2548();
                                 var136 = class161.method3205(var56);
                                 if(var136.field2839 != var53 || var136.field2800 != var5 || var7 != var136.field2802) {
                                    var136.field2839 = var53;
                                    var136.field2800 = var5;
                                    var136.field2802 = var7;
                                    class4.method37(var136);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 114) {
                                 class10.field156 = class186.method3746(field332.method2514());
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 172) {
                                 var53 = field332.method2516();
                                 var5 = field332.method2514();
                                 var56 = field332.method2516();
                                 class50.method1016(var53, var5, var56);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 86) {
                                 field535 = true;
                                 class8.field134 = field332.method2514();
                                 class181.field2934 = field332.method2514();
                                 class10.field159 = field332.method2516();
                                 class41.field951 = field332.method2514();
                                 class114.field1950 = field332.method2514();
                                 if(class114.field1950 >= 100) {
                                    var53 = 64 + class8.field134 * 128;
                                    var5 = class181.field2934 * 128 + 64;
                                    var56 = class108.method2413(var53, var5, class144.field2193) - class10.field159;
                                    var7 = var53 - class28.field670;
                                    var8 = var56 - class59.field1188;
                                    var59 = var5 - field478;
                                    var10 = (int)Math.sqrt((double)(var7 * var7 + var59 * var59));
                                    class156.field2286 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                                    class149.field2224 = (int)(Math.atan2((double)var7, (double)var59) * -325.949D) & 2047;
                                    if(class156.field2286 < 128) {
                                       class156.field2286 = 128;
                                    }

                                    if(class156.field2286 > 383) {
                                       class156.field2286 = 383;
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 252) {
                                 field493 = field332.method2514();
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 12) {
                                 class25 var94 = new class25();
                                 var94.field637 = field332.method2522();
                                 var94.field636 = field332.method2516();
                                 var5 = field332.method2519();
                                 var94.field640 = var5;
                                 class43.method919(45);
                                 class13.field195.method3025();
                                 class13.field195 = null;
                                 class7.method93(var94);
                                 field335 = -1;
                                 var121 = false;
                                 break label4258;
                              }

                              if(field335 == 213) {
                                 class116.method2462(field332, field334);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 0) {
                                 var53 = field334 + field332.field1976;
                                 var5 = field332.method2516();
                                 var56 = field332.method2516();
                                 if(var5 != field456) {
                                    field456 = var5;
                                    class85.method1921(field456, class45.field1026, class143.field2169, false);
                                    class14.method164(field456);
                                    class32.method711(field456);

                                    for(var7 = 0; var7 < 100; ++var7) {
                                       field507[var7] = true;
                                    }
                                 }

                                 class3 var127;
                                 for(; var56-- > 0; var127.field53 = true) {
                                    var7 = field332.method2519();
                                    var8 = field332.method2516();
                                    var59 = field332.method2514();
                                    var127 = (class3)field448.method3807((long)var7);
                                    if(var127 != null && var127.field60 != var8) {
                                       class139.method2971(var127, true);
                                       var127 = null;
                                    }

                                    if(null == var127) {
                                       var127 = class159.method3189(var7, var8, var59);
                                    }
                                 }

                                 for(var135 = (class3)field448.method3799(); var135 != null; var135 = (class3)field448.method3800()) {
                                    if(var135.field53) {
                                       var135.field53 = false;
                                    } else {
                                       class139.method2971(var135, true);
                                    }
                                 }

                                 field311 = new class196(512);

                                 while(field332.field1976 < var53) {
                                    var7 = field332.method2519();
                                    var8 = field332.method2516();
                                    var59 = field332.method2516();
                                    var10 = field332.method2519();

                                    for(var11 = var8; var11 <= var59; ++var11) {
                                       var119 = (long)var11 + ((long)var7 << 32);
                                       field311.method3797(new class201(var10), var119);
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 146) {
                                 var53 = field332.method2514();
                                 if(field332.method2514() == 0) {
                                    field528[var53] = new class220();
                                    field332.field1976 += 18;
                                 } else {
                                    --field332.field1976;
                                    field528[var53] = new class220(field332, false);
                                 }

                                 field327 = field359;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 135) {
                                 for(var53 = 0; var53 < class176.field2896.length; ++var53) {
                                    if(class176.field2896[var53] != class176.field2894[var53]) {
                                       class176.field2896[var53] = class176.field2894[var53];
                                       class4.method40(var53);
                                       field473[++field474 - 1 & 31] = var53;
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              long var109;
                              boolean var111;
                              long var116;
                              if(field335 == 81) {
                                 field288 = field359;
                                 if(field334 == 0) {
                                    field514 = null;
                                    field515 = null;
                                    class116.field1957 = 0;
                                    class40.field923 = null;
                                    field335 = -1;
                                    var121 = true;
                                    break label4258;
                                 }

                                 field515 = field332.method2522();
                                 long var159 = field332.method2699();
                                 var110 = var159;
                                 if(var159 > 0L && var159 < 6582952005840035281L) {
                                    if(0L == var159 % 37L) {
                                       var92 = null;
                                    } else {
                                       var59 = 0;

                                       for(var109 = var159; var109 != 0L; var109 /= 37L) {
                                          ++var59;
                                       }

                                       StringBuilder var71 = new StringBuilder(var59);

                                       while(0L != var110) {
                                          var116 = var110;
                                          var110 /= 37L;
                                          var71.append(class162.field2639[(int)(var116 - var110 * 37L)]);
                                       }

                                       var92 = var71.reverse().toString();
                                    }
                                 } else {
                                    var92 = null;
                                 }

                                 field514 = var92;
                                 class153.field2264 = field332.method2515();
                                 var59 = field332.method2514();
                                 if(var59 == 255) {
                                    field335 = -1;
                                    var121 = true;
                                    break label4258;
                                 }

                                 class116.field1957 = var59;
                                 class24[] var125 = new class24[100];

                                 for(var11 = 0; var11 < class116.field1957; ++var11) {
                                    var125[var11] = new class24();
                                    var125[var11].field617 = field332.method2522();
                                    var125[var11].field618 = class39.method796(var125[var11].field617, field289);
                                    var125[var11].field619 = field332.method2516();
                                    var125[var11].field622 = field332.method2515();
                                    field332.method2522();
                                    if(var125[var11].field617.equals(class153.field2262.field26)) {
                                       class119.field1986 = var125[var11].field622;
                                    }
                                 }

                                 var111 = false;
                                 var13 = class116.field1957;

                                 while(var13 > 0) {
                                    var111 = true;
                                    --var13;

                                    for(var14 = 0; var14 < var13; ++var14) {
                                       if(var125[var14].field618.compareTo(var125[1 + var14].field618) > 0) {
                                          class24 var160 = var125[var14];
                                          var125[var14] = var125[var14 + 1];
                                          var125[var14 + 1] = var160;
                                          var111 = false;
                                       }
                                    }

                                    if(var111) {
                                       break;
                                    }
                                 }

                                 class40.field923 = var125;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 34) {
                                 var53 = field332.method2550();
                                 var5 = field332.method2559();
                                 var91 = class161.method3205(var5);
                                 if(var91.field2791 != 1 || var53 != var91.field2792) {
                                    var91.field2791 = 1;
                                    var91.field2792 = var53;
                                    class4.method37(var91);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 153) {
                                 field332.field1976 += 28;
                                 if(field332.method2678()) {
                                    class122 var93 = field332;
                                    var5 = field332.field1976 - 28;
                                    if(null != class149.field2219) {
                                       try {
                                          class149.field2219.method4146(0L);
                                          class149.field2219.method4137(var93.field1982, var5, 24);
                                       } catch (Exception var73) {
                                          ;
                                       }
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 64) {
                                 var53 = field332.method2514();
                                 var5 = field332.method2514();
                                 var56 = field332.method2514();
                                 var7 = field332.method2514();
                                 field536[var53] = true;
                                 field481[var53] = var5;
                                 field529[var53] = var56;
                                 field539[var53] = var7;
                                 field324[var53] = 0;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 63) {
                                 field519 = field332.method2516() * 30;
                                 field484 = field359;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 210) {
                                 var90 = field332.method2522();
                                 Object[] var153 = new Object[var90.length() + 1];

                                 for(var56 = var90.length() - 1; var56 >= 0; --var56) {
                                    if(var90.charAt(var56) == 115) {
                                       var153[1 + var56] = field332.method2522();
                                    } else {
                                       var153[var56 + 1] = new Integer(field332.method2519());
                                    }
                                 }

                                 var153[0] = new Integer(field332.method2519());
                                 class0 var102 = new class0();
                                 var102.field12 = var153;
                                 class90.method2092(var102, 200000);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 241) {
                                 var53 = field332.method2559();
                                 var5 = field332.method2738();
                                 class3 var99 = (class3)field448.method3807((long)var53);
                                 var135 = (class3)field448.method3807((long)var5);
                                 if(null != var135) {
                                    class139.method2971(var135, var99 == null || var135.field60 != var99.field60);
                                 }

                                 if(null != var99) {
                                    var99.method3916();
                                    field448.method3797(var99, (long)var5);
                                 }

                                 var136 = class161.method3205(var53);
                                 if(null != var136) {
                                    class4.method37(var136);
                                 }

                                 var136 = class161.method3205(var5);
                                 if(null != var136) {
                                    class4.method37(var136);
                                    class9.method121(class173.field2750[var136.field2748 >>> 16], var136, true);
                                 }

                                 if(field456 != -1) {
                                    class32.method720(field456, 1);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 40) {
                                 field535 = true;
                                 class11.field167 = field332.method2514();
                                 class130.field2047 = field332.method2514();
                                 class99.field1660 = field332.method2516();
                                 class75.field1343 = field332.method2514();
                                 class17.field244 = field332.method2514();
                                 if(class17.field244 >= 100) {
                                    class28.field670 = 64 + class11.field167 * 128;
                                    field478 = class130.field2047 * 128 + 64;
                                    class59.field1188 = class108.method2413(class28.field670, field478, class144.field2193) - class99.field1660;
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 3) {
                                 class52.method1069();
                                 field453 = field332.method2517();
                                 field484 = field359;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              String var129;
                              if(field335 == 119) {
                                 var90 = field332.method2522();
                                 class122 var97 = field332;
                                 var151 = class175.method3455(var97, 32767);
                                 var129 = class223.method4032(class82.method1896(var151));
                                 class45.method955(6, var90, var129);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 173) {
                                 class52.method1069();
                                 var53 = field332.method2559();
                                 var5 = field332.method2574();
                                 var56 = field332.method2542();
                                 field426[var56] = var53;
                                 field356[var56] = var5;
                                 field425[var56] = 1;

                                 for(var7 = 0; var7 < 98; ++var7) {
                                    if(var53 >= class155.field2282[var7]) {
                                       field425[var56] = 2 + var7;
                                    }
                                 }

                                 field471[++field467 - 1 & 31] = var56;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 14) {
                                 var53 = field332.method2519();
                                 var5 = field332.method2519();
                                 if(null == class16.field238 || !class16.field238.isValid()) {
                                    try {
                                       Iterator var95 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                                       while(var95.hasNext()) {
                                          GarbageCollectorMXBean var132 = (GarbageCollectorMXBean)var95.next();
                                          if(var132.isValid()) {
                                             class16.field238 = var132;
                                             field424 = -1L;
                                             field564 = -1L;
                                          }
                                       }
                                    } catch (Throwable var77) {
                                       ;
                                    }
                                 }

                                 long var139 = class90.method2090();
                                 var8 = -1;
                                 if(null != class16.field238) {
                                    var141 = class16.field238.getCollectionTime();
                                    if(field564 != -1L) {
                                       long var112 = var141 - field564;
                                       var116 = var139 - field424;
                                       if(var116 != 0L) {
                                          var8 = (int)(100L * var112 / var116);
                                       }
                                    }

                                    field564 = var141;
                                    field424 = var139;
                                 }

                                 field331.method2781(193);
                                 field331.method2538(class144.field2181);
                                 field331.method2650(var8);
                                 field331.method2557(var53);
                                 field331.method2502(var5);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 136 || field335 == 222 || field335 == 127 || field335 == 35 || field335 == 71 || field335 == 77 || field335 == 45 || field335 == 16 || field335 == 232 || field335 == 197) {
                                 class48.method990();
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 10) {
                                 class139.method2969(field332, field334);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 247) {
                                 var53 = field332.method2661();
                                 var5 = field332.method2560();
                                 var56 = var53 >> 10 & 31;
                                 var7 = var53 >> 5 & 31;
                                 var8 = var53 & 31;
                                 var59 = (var56 << 19) + (var7 << 11) + (var8 << 3);
                                 class173 var124 = class161.method3205(var5);
                                 if(var124.field2773 != var59) {
                                    var124.field2773 = var59;
                                    class4.method37(var124);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 52) {
                                 class0.method0(true);
                                 field332.method2787();
                                 var53 = field332.method2516();
                                 class116.method2462(field332, var53);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 229) {
                                 class52.method1069();
                                 field452 = field332.method2514();
                                 field484 = field359;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 147) {
                                 while(field332.field1976 < field334) {
                                    var53 = field332.method2514();
                                    var108 = (var53 & 1) == 1;
                                    var92 = field332.method2522();
                                    var129 = field332.method2522();
                                    field332.method2522();

                                    for(var8 = 0; var8 < field513; ++var8) {
                                       class7 var104 = field559[var8];
                                       if(var108) {
                                          if(var129.equals(var104.field124)) {
                                             var104.field124 = var92;
                                             var104.field122 = var129;
                                             var91 = null;
                                             break;
                                          }
                                       } else if(var92.equals(var104.field124)) {
                                          var104.field124 = var92;
                                          var104.field122 = var129;
                                          var91 = null;
                                          break;
                                       }
                                    }
                                 }

                                 field492 = field359;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 117) {
                                 var53 = field332.method2560();
                                 class17.field250 = class40.field924.method2928(var53);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 2) {
                                 var53 = field332.method2550();
                                 if(var53 == '\uffff') {
                                    var53 = -1;
                                 }

                                 if(var53 == -1 && !field526) {
                                    class183.field2952.method3614();
                                    class183.field2953 = 1;
                                    class50.field1075 = null;
                                 } else if(var53 != -1 && var53 != field525 && field524 != 0 && !field526) {
                                    class12.method155(2, field358, var53, 0, field524, false);
                                 }

                                 field525 = var53;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 134) {
                                 var53 = field332.method2706();
                                 var5 = field332.method2516();
                                 if(var5 == '\uffff') {
                                    var5 = -1;
                                 }

                                 if(field524 != 0 && var5 != -1) {
                                    class85.method1922(class84.field1422, var5, 0, field524, false);
                                    field526 = true;
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 151) {
                                 var53 = field332.method2519();
                                 var5 = field332.method2517();
                                 var56 = field332.method2551();
                                 var128 = class161.method3205(var53);
                                 if(var128.field2762 != var5 || var128.field2784 != var56 || var128.field2753 != 0 || var128.field2754 != 0) {
                                    var128.field2762 = var5;
                                    var128.field2784 = var56;
                                    var128.field2753 = 0;
                                    var128.field2754 = 0;
                                    class4.method37(var128);
                                    class39.method798(var128);
                                    if(var128.field2833 == 0) {
                                       class9.method121(class173.field2750[var53 >> 16], var128, false);
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 59) {
                                 byte var150 = field332.method2515();
                                 var5 = field332.method2550();
                                 class176.field2894[var5] = var150;
                                 if(class176.field2896[var5] != var150) {
                                    class176.field2896[var5] = var150;
                                 }

                                 class4.method40(var5);
                                 field473[++field474 - 1 & 31] = var5;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              boolean var145;
                              if(field335 == 179) {
                                 var145 = field332.method2514() == 1;
                                 if(var145) {
                                    class157.field2576 = class90.method2090() - field332.method2699();
                                    class143.field2172 = new class221(field332, true);
                                 } else {
                                    class143.field2172 = null;
                                 }

                                 field483 = field359;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 227) {
                                 var53 = field332.method2560();
                                 var5 = field332.method2552();
                                 var91 = class161.method3205(var53);
                                 if(var5 != var91.field2752 || var5 == -1) {
                                    var91.field2752 = var5;
                                    var91.field2870 = 0;
                                    var91.field2855 = 0;
                                    class4.method37(var91);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 156) {
                                 class39.field882 = field332.method2542();
                                 class18.field264 = field332.method2540();
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 235) {
                                 class32.field738 = 0;

                                 for(var53 = 0; var53 < 2048; ++var53) {
                                    class32.field737[var53] = null;
                                    class32.field736[var53] = 1;
                                 }

                                 for(var53 = 0; var53 < 2048; ++var53) {
                                    field410[var53] = null;
                                 }

                                 class115.method2453(field332);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 246) {
                                 var90 = field332.method2522();
                                 var113 = (long)field332.method2516();
                                 var110 = (long)field332.method2518();
                                 class152 var103 = (class152)class157.method3181(class4.method39(), field332.method2514());
                                 var109 = var110 + (var113 << 32);
                                 boolean var117 = false;

                                 for(var13 = 0; var13 < 100; ++var13) {
                                    if(var109 == field350[var13]) {
                                       var117 = true;
                                       break;
                                    }
                                 }

                                 if(class45.method953(var90)) {
                                    var117 = true;
                                 }

                                 if(!var117 && field409 == 0) {
                                    field350[field509] = var109;
                                    field509 = (1 + field509) % 100;
                                    class122 var140 = field332;
                                    String var147 = class175.method3455(var140, 32767);
                                    var157 = class223.method4032(class82.method1896(var147));
                                    byte var120;
                                    if(var103.field2250) {
                                       var120 = 7;
                                    } else {
                                       var120 = 3;
                                    }

                                    if(var103.field2249 != -1) {
                                       class45.method955(var120, class56.method1172(var103.field2249) + var90, var157);
                                    } else {
                                       class45.method955(var120, var90, var157);
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              class3 var66;
                              if(field335 == 157) {
                                 while(field332.field1976 < field334) {
                                    var145 = field332.method2514() == 1;
                                    var151 = field332.method2522();
                                    var92 = field332.method2522();
                                    var7 = field332.method2516();
                                    var8 = field332.method2514();
                                    var59 = field332.method2514();
                                    boolean var107 = (var59 & 2) != 0;
                                    var111 = (var59 & 1) != 0;
                                    if(var7 > 0) {
                                       field332.method2522();
                                       field332.method2514();
                                       field332.method2519();
                                    }

                                    field332.method2522();

                                    for(var12 = 0; var12 < field340; ++var12) {
                                       class17 var146 = field556[var12];
                                       if(!var145) {
                                          if(var151.equals(var146.field243)) {
                                             if(var146.field249 != var7) {
                                                var115 = true;

                                                for(class38 var69 = (class38)field557.method3793(); var69 != null; var69 = (class38)field557.method3786()) {
                                                   if(var69.field856.equals(var151)) {
                                                      if(var7 != 0 && var69.field851 == 0) {
                                                         var69.method3905();
                                                         var115 = false;
                                                      } else if(var7 == 0 && var69.field851 != 0) {
                                                         var69.method3905();
                                                         var115 = false;
                                                      }
                                                   }
                                                }

                                                if(var115) {
                                                   field557.method3794(new class38(var151, var7));
                                                }

                                                var146.field249 = var7;
                                             }

                                             var146.field246 = var92;
                                             var146.field248 = var8;
                                             var146.field242 = var107;
                                             var146.field247 = var111;
                                             var66 = null;
                                             break;
                                          }
                                       } else if(var92.equals(var146.field243)) {
                                          var146.field243 = var151;
                                          var146.field246 = var92;
                                          var66 = null;
                                          break;
                                       }
                                    }
                                 }

                                 field555 = 2;
                                 field492 = field359;
                                 var145 = false;
                                 var5 = field340;

                                 while(var5 > 0) {
                                    var145 = true;
                                    --var5;

                                    for(var56 = 0; var56 < var5; ++var56) {
                                       var100 = false;
                                       class17 var134 = field556[var56];
                                       class17 var101 = field556[1 + var56];
                                       if(var134.field249 != field286 && field286 == var101.field249) {
                                          var100 = true;
                                       }

                                       if(!var100 && var134.field249 == 0 && var101.field249 != 0) {
                                          var100 = true;
                                       }

                                       if(!var100 && !var134.field242 && var101.field242) {
                                          var100 = true;
                                       }

                                       if(!var100 && !var134.field247 && var101.field247) {
                                          var100 = true;
                                       }

                                       if(var100) {
                                          class17 var123 = field556[var56];
                                          field556[var56] = field556[1 + var56];
                                          field556[var56 + 1] = var123;
                                          var145 = false;
                                       }
                                    }

                                    if(var145) {
                                       break;
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 234) {
                                 field323 = field332.method2514();
                                 if(field323 == 1) {
                                    field305 = field332.method2516();
                                 }

                                 if(field323 >= 2 && field323 <= 6) {
                                    if(field323 == 2) {
                                       field310 = 64;
                                       field458 = 64;
                                    }

                                    if(field323 == 3) {
                                       field310 = 0;
                                       field458 = 64;
                                    }

                                    if(field323 == 4) {
                                       field310 = 128;
                                       field458 = 64;
                                    }

                                    if(field323 == 5) {
                                       field310 = 64;
                                       field458 = 0;
                                    }

                                    if(field323 == 6) {
                                       field310 = 64;
                                       field458 = 128;
                                    }

                                    field323 = 2;
                                    field307 = field332.method2516();
                                    field308 = field332.method2516();
                                    field309 = field332.method2514();
                                 }

                                 if(field323 == 10) {
                                    field306 = field332.method2516();
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 101) {
                                 class18.field264 = field332.method2540();
                                 class39.field882 = field332.method2574();

                                 for(var53 = class39.field882; var53 < 8 + class39.field882; ++var53) {
                                    for(var5 = class18.field264; var5 < class18.field264 + 8; ++var5) {
                                       if(null != field420[class144.field2193][var53][var5]) {
                                          field420[class144.field2193][var53][var5] = null;
                                          class93.method2171(var53, var5);
                                       }
                                    }
                                 }

                                 for(var88 = (class16)field421.method3844(); var88 != null; var88 = (class16)field421.method3834()) {
                                    if(var88.field225 >= class39.field882 && var88.field225 < class39.field882 + 8 && var88.field223 >= class18.field264 && var88.field223 < class18.field264 + 8 && var88.field232 == class144.field2193) {
                                       var88.field233 = 0;
                                    }
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 37) {
                                 var53 = field332.method2560();
                                 var151 = field332.method2522();
                                 var91 = class161.method3205(var53);
                                 if(!var151.equals(var91.field2808)) {
                                    var91.field2808 = var151;
                                    class4.method37(var91);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 154) {
                                 var53 = field332.method2519();
                                 var66 = (class3)field448.method3807((long)var53);
                                 if(null != var66) {
                                    class139.method2971(var66, true);
                                 }

                                 if(field451 != null) {
                                    class4.method37(field451);
                                    field451 = null;
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 209) {
                                 var53 = field332.method2519();
                                 var108 = field332.method2574() == 1;
                                 var91 = class161.method3205(var53);
                                 if(var91.field2882 != var108) {
                                    var91.field2882 = var108;
                                    class4.method37(var91);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 239) {
                                 var53 = field332.method2516();
                                 class136.method2942(var53);
                                 field475[++field476 - 1 & 31] = var53 & 32767;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 26) {
                                 var90 = field332.method2522();
                                 var5 = field332.method2542();
                                 var56 = field332.method2574();
                                 if(var5 >= 1 && var5 <= 8) {
                                    if(var90.equalsIgnoreCase("null")) {
                                       var90 = null;
                                    }

                                    field416[var5 - 1] = var90;
                                    field417[var5 - 1] = var56 == 0;
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 184) {
                                 var53 = field332.method2559();
                                 var5 = field332.method2516();
                                 if(var5 == '\uffff') {
                                    var5 = -1;
                                 }

                                 var56 = field332.method2738();
                                 var7 = field332.method2550();
                                 if(var7 == '\uffff') {
                                    var7 = -1;
                                 }

                                 for(var8 = var5; var8 <= var7; ++var8) {
                                    var141 = ((long)var53 << 32) + (long)var8;
                                    class208 var67 = field311.method3807(var141);
                                    if(var67 != null) {
                                       var67.method3916();
                                    }

                                    field311.method3797(new class201(var56), var141);
                                 }

                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 41) {
                                 class0.method0(false);
                                 field332.method2787();
                                 var53 = field332.method2516();
                                 class116.method2462(field332, var53);
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              if(field335 == 123) {
                                 var53 = field332.method2559();
                                 var5 = field332.method2548();
                                 class176.field2894[var5] = var53;
                                 if(class176.field2896[var5] != var53) {
                                    class176.field2896[var5] = var53;
                                 }

                                 class4.method40(var5);
                                 field473[++field474 - 1 & 31] = var5;
                                 field335 = -1;
                                 var121 = true;
                                 break label4258;
                              }

                              class7.method94("" + field335 + "," + field406 + "," + field540 + "," + field334, (Throwable)null);
                              class158.method3182();
                           } catch (IOException var78) {
                              class157.method3180();
                           } catch (Exception var79) {
                              var90 = "" + field335 + "," + field406 + "," + field540 + "," + field334 + "," + (class4.field62 + class153.field2262.field844[0]) + "," + (class85.field1434 + class153.field2262.field831[0]) + ",";

                              for(var5 = 0; var5 < field334 && var5 < 50; ++var5) {
                                 var90 = var90 + field332.field1982[var5] + ",";
                              }

                              class7.method94(var90, var79);
                              class158.method3182();
                           }

                           var121 = true;
                        }
                     }

                     if(!var121) {
                        break;
                     }
                  }

                  if(field294 == 30) {
                     while(class17.method181()) {
                        field331.method2781(225);
                        field331.method2650(0);
                        var51 = field331.field1976;
                        class178.method3484(field331);
                        field331.method2511(field331.field1976 - var51);
                     }

                     Object var82 = class12.field182.field201;
                     synchronized(class12.field182.field201) {
                        if(!field285) {
                           class12.field182.field197 = 0;
                        } else if(class140.field2140 != 0 || class12.field182.field197 >= 40) {
                           field331.method2781(80);
                           field331.method2650(0);
                           var52 = field331.field1976;
                           var54 = 0;

                           for(var53 = 0; var53 < class12.field182.field197 && field331.field1976 - var52 < 240; ++var53) {
                              ++var54;
                              var5 = class12.field182.field198[var53];
                              if(var5 < 0) {
                                 var5 = 0;
                              } else if(var5 > 502) {
                                 var5 = 502;
                              }

                              var56 = class12.field182.field202[var53];
                              if(var56 < 0) {
                                 var56 = 0;
                              } else if(var56 > 764) {
                                 var56 = 764;
                              }

                              var7 = var56 + var5 * 765;
                              if(class12.field182.field198[var53] == -1 && class12.field182.field202[var53] == -1) {
                                 var56 = -1;
                                 var5 = -1;
                                 var7 = 524287;
                              }

                              if(field333 == var56 && field299 == var5) {
                                 if(field300 < 2047) {
                                    ++field300;
                                 }
                              } else {
                                 var8 = var56 - field333;
                                 field333 = var56;
                                 var59 = var5 - field299;
                                 field299 = var5;
                                 if(field300 < 8 && var8 >= -32 && var8 <= 31 && var59 >= -32 && var59 <= 31) {
                                    var8 += 32;
                                    var59 += 32;
                                    field331.method2695(var59 + (var8 << 6) + (field300 << 12));
                                    field300 = 0;
                                 } else if(field300 < 8) {
                                    field331.method2501(var7 + 8388608 + (field300 << 19));
                                    field300 = 0;
                                 } else {
                                    field331.method2502((field300 << 19) + -1073741824 + var7);
                                    field300 = 0;
                                 }
                              }
                           }

                           field331.method2511(field331.field1976 - var52);
                           if(var54 >= class12.field182.field197) {
                              class12.field182.field197 = 0;
                           } else {
                              class12.field182.field197 -= var54;

                              for(var53 = 0; var53 < class12.field182.field197; ++var53) {
                                 class12.field182.field202[var53] = class12.field182.field202[var53 + var54];
                                 class12.field182.field198[var53] = class12.field182.field198[var53 + var54];
                              }
                           }
                        }
                     }

                     if(class140.field2140 == 1 || !class161.field2631 && class140.field2140 == 4 || class140.field2140 == 2) {
                        long var130 = (class140.field2143 - field297) / 50L;
                        if(var130 > 4095L) {
                           var130 = 4095L;
                        }

                        field297 = class140.field2143;
                        var54 = class140.field2142;
                        if(var54 < 0) {
                           var54 = 0;
                        } else if(var54 > class143.field2169) {
                           var54 = class143.field2169;
                        }

                        var53 = class140.field2141;
                        if(var53 < 0) {
                           var53 = 0;
                        } else if(var53 > class45.field1026) {
                           var53 = class45.field1026;
                        }

                        var5 = (int)var130;
                        field331.method2781(35);
                        field331.method2695((class140.field2140 == 2?1:0) + (var5 << 1));
                        field331.method2695(var53);
                        field331.method2695(var54);
                     }

                     if(class137.field2102 > 0) {
                        field331.method2781(12);
                        field331.method2695(0);
                        var51 = field331.field1976;
                        long var162 = class90.method2090();

                        for(var53 = 0; var53 < class137.field2102; ++var53) {
                           var113 = var162 - field505;
                           if(var113 > 16777215L) {
                              var113 = 16777215L;
                           }

                           field505 = var162;
                           field331.method2553((int)var113);
                           field331.method2538(class137.field2101[var53]);
                        }

                        field331.method2510(field331.field1976 - var51);
                     }

                     if(field382 > 0) {
                        --field382;
                     }

                     if(class137.field2095[96] || class137.field2095[97] || class137.field2095[98] || class137.field2095[99]) {
                        field381 = true;
                     }

                     if(field381 && field382 <= 0) {
                        field382 = 20;
                        field381 = false;
                        field331.method2781(165);
                        field331.method2547(field403);
                        field331.method2695(field322);
                     }

                     if(class108.field1871 && !field301) {
                        field301 = true;
                        field331.method2781(145);
                        field331.method2650(1);
                     }

                     if(!class108.field1871 && field301) {
                        field301 = false;
                        field331.method2781(145);
                        field331.method2650(0);
                     }

                     int[] var84;
                     if(field303 != class144.field2193) {
                        field303 = class144.field2193;
                        var51 = class144.field2193;
                        var84 = class44.field1017.field1380;
                        var54 = var84.length;

                        for(var53 = 0; var53 < var54; ++var53) {
                           var84[var53] = 0;
                        }

                        var53 = 1;

                        while(true) {
                           if(var53 >= 103) {
                              var53 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                              var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                              class44.field1017.method1770();

                              for(var56 = 1; var56 < 103; ++var56) {
                                 for(var7 = 1; var7 < 103; ++var7) {
                                    if((class5.field69[var51][var7][var56] & 24) == 0) {
                                       class17.method180(var51, var7, var56, var53, var5);
                                    }

                                    if(var51 < 3 && (class5.field69[var51 + 1][var7][var56] & 8) != 0) {
                                       class17.method180(1 + var51, var7, var56, var53, var5);
                                    }
                                 }
                              }

                              field373 = 0;

                              for(var56 = 0; var56 < 104; ++var56) {
                                 for(var7 = 0; var7 < 104; ++var7) {
                                    var8 = class150.field2230.method1954(class144.field2193, var56, var7);
                                    if(var8 != 0) {
                                       var8 = var8 >> 14 & 32767;
                                       var59 = class172.method3399(var8).field928;
                                       if(var59 >= 0) {
                                          var10 = var56;
                                          var11 = var7;
                                          if(var59 != 22 && var59 != 29 && var59 != 34 && var59 != 36 && var59 != 46 && var59 != 47 && var59 != 48) {
                                             int[][] var143 = field291[class144.field2193].field1884;

                                             for(var15 = 0; var15 < 10; ++var15) {
                                                var16 = (int)(Math.random() * 4.0D);
                                                if(var16 == 0 && var10 > 0 && var10 > var56 - 3 && (var143[var10 - 1][var11] & 19136776) == 0) {
                                                   --var10;
                                                }

                                                if(var16 == 1 && var10 < 103 && var10 < var56 + 3 && (var143[1 + var10][var11] & 19136896) == 0) {
                                                   ++var10;
                                                }

                                                if(var16 == 2 && var11 > 0 && var11 > var7 - 3 && (var143[var10][var11 - 1] & 19136770) == 0) {
                                                   --var11;
                                                }

                                                if(var16 == 3 && var11 < 103 && var11 < 3 + var7 && (var143[var10][1 + var11] & 19136800) == 0) {
                                                   ++var11;
                                                }
                                             }
                                          }

                                          field520[field373] = class26.field663[var59];
                                          field293[field373] = var10;
                                          field387[field373] = var11;
                                          ++field373;
                                       }
                                    }
                                 }
                              }

                              class48.field1049.method1685();
                              break;
                           }

                           var5 = 2048 * (103 - var53) + 24628;

                           for(var56 = 1; var56 < 103; ++var56) {
                              if((class5.field69[var51][var56][var53] & 24) == 0) {
                                 class150.field2230.method2065(var84, var5, 512, var51, var56, var53);
                              }

                              if(var51 < 3 && (class5.field69[var51 + 1][var56][var53] & 8) != 0) {
                                 class150.field2230.method2065(var84, var5, 512, var51 + 1, var56, var53);
                              }

                              var5 += 4;
                           }

                           ++var53;
                        }
                     }

                     if(field294 == 30) {
                        for(class16 var83 = (class16)field421.method3844(); null != var83; var83 = (class16)field421.method3834()) {
                           if(var83.field233 > 0) {
                              --var83.field233;
                           }

                           if(var83.field233 == 0) {
                              if(var83.field227 < 0 || class23.method589(var83.field227, var83.field228)) {
                                 class47.method974(var83.field232, var83.field224, var83.field225, var83.field223, var83.field227, var83.field240, var83.field228);
                                 var83.method3916();
                              }
                           } else {
                              if(var83.field241 > 0) {
                                 --var83.field241;
                              }

                              if(var83.field241 == 0 && var83.field225 >= 1 && var83.field223 >= 1 && var83.field225 <= 102 && var83.field223 <= 102 && (var83.field230 < 0 || class23.method589(var83.field230, var83.field235))) {
                                 class47.method974(var83.field232, var83.field224, var83.field225, var83.field223, var83.field230, var83.field231, var83.field235);
                                 var83.field241 = -1;
                                 if(var83.field227 == var83.field230 && var83.field227 == -1) {
                                    var83.method3916();
                                 } else if(var83.field227 == var83.field230 && var83.field240 == var83.field231 && var83.field235 == var83.field228) {
                                    var83.method3916();
                                 }
                              }
                           }
                        }

                        class1.method11();
                        ++field441;
                        if(field441 > 750) {
                           class157.method3180();
                        } else {
                           var51 = class32.field738;
                           var84 = class32.field739;

                           for(var54 = 0; var54 < var51; ++var54) {
                              class2 var98 = field410[var84[var54]];
                              if(var98 != null) {
                                 class98.method2199(var98, 1);
                              }
                           }

                           class183.method3606();
                           class215.method3954();
                           ++field538;
                           if(field400 != 0) {
                              field304 += 20;
                              if(field304 >= 400) {
                                 field400 = 0;
                              }
                           }

                           if(class219.field3170 != null) {
                              ++field401;
                              if(field401 >= 15) {
                                 class4.method37(class219.field3170);
                                 class219.field3170 = null;
                              }
                           }

                           class173 var85 = class172.field2732;
                           class173 var86 = class175.field2890;
                           class172.field2732 = null;
                           class175.field2890 = null;
                           field464 = null;
                           field341 = false;
                           field465 = false;
                           field510 = 0;

                           while(true) {
                              while(class95.method2192() && field510 < 128) {
                                 if(field354 >= 2 && class137.field2095[82] && class10.field158 == 66) {
                                    var90 = "";

                                    class35 var118;
                                    for(Iterator var156 = class11.field169.iterator(); var156.hasNext(); var90 = var90 + var118.field766 + ':' + var118.field768 + '\n') {
                                       var118 = (class35)var156.next();
                                    }

                                    class56.field1146.setContents(new StringSelection(var90), (ClipboardOwner)null);
                                 } else {
                                    field512[field510] = class10.field158;
                                    field511[field510] = class25.field644;
                                    ++field510;
                                 }
                              }

                              if(field456 != -1) {
                                 class19.method220(field456, 0, 0, class45.field1026, class143.field2169, 0, 0);
                              }

                              ++field359;

                              while(true) {
                                 class0 var87;
                                 class173 var105;
                                 do {
                                    var87 = (class0)field487.method3833();
                                    if(null == var87) {
                                       while(true) {
                                          do {
                                             var87 = (class0)field488.method3833();
                                             if(var87 == null) {
                                                while(true) {
                                                   do {
                                                      var87 = (class0)field486.method3833();
                                                      if(null == var87) {
                                                         boolean var148 = false;

                                                         while(!var148) {
                                                            var148 = true;

                                                            for(var53 = 0; var53 < field429 - 1; ++var53) {
                                                               if(field432[var53] < 1000 && field432[1 + var53] > 1000) {
                                                                  var151 = field396[var53];
                                                                  field396[var53] = field396[var53 + 1];
                                                                  field396[1 + var53] = var151;
                                                                  var92 = field434[var53];
                                                                  field434[var53] = field434[1 + var53];
                                                                  field434[var53 + 1] = var92;
                                                                  var7 = field432[var53];
                                                                  field432[var53] = field432[1 + var53];
                                                                  field432[1 + var53] = var7;
                                                                  var7 = field419[var53];
                                                                  field419[var53] = field419[1 + var53];
                                                                  field419[1 + var53] = var7;
                                                                  var7 = field431[var53];
                                                                  field431[var53] = field431[1 + var53];
                                                                  field431[var53 + 1] = var7;
                                                                  var7 = field433[var53];
                                                                  field433[var53] = field433[1 + var53];
                                                                  field433[var53 + 1] = var7;
                                                                  var148 = false;
                                                               }
                                                            }
                                                         }

                                                         class30 var161;
                                                         if(class38.field849 == null && field460 == null) {
                                                            var54 = class140.field2140;
                                                            if(field428) {
                                                               if(var54 != 1 && (class161.field2631 || var54 != 4)) {
                                                                  var53 = class140.field2134;
                                                                  var5 = class140.field2135;
                                                                  if(var53 < class16.field234 - 10 || var53 > 10 + class156.field2288 + class16.field234 || var5 < class12.field194 - 10 || var5 > class12.field194 + class20.field573 + 10) {
                                                                     field428 = false;
                                                                     class168.method3374(class16.field234, class12.field194, class156.field2288, class20.field573);
                                                                  }
                                                               }

                                                               if(var54 == 1 || !class161.field2631 && var54 == 4) {
                                                                  var53 = class16.field234;
                                                                  var5 = class12.field194;
                                                                  var56 = class156.field2288;
                                                                  var7 = class140.field2141;
                                                                  var8 = class140.field2142;
                                                                  var59 = -1;

                                                                  for(var10 = 0; var10 < field429; ++var10) {
                                                                     var11 = 15 * (field429 - 1 - var10) + 31 + var5;
                                                                     if(var7 > var53 && var7 < var56 + var53 && var8 > var11 - 13 && var8 < var11 + 3) {
                                                                        var59 = var10;
                                                                     }
                                                                  }

                                                                  if(var59 != -1) {
                                                                     class177.method3468(var59);
                                                                  }

                                                                  field428 = false;
                                                                  class168.method3374(class16.field234, class12.field194, class156.field2288, class20.field573);
                                                               }
                                                            } else {
                                                               label4305: {
                                                                  label4365: {
                                                                     if((var54 == 1 || !class161.field2631 && var54 == 4) && field429 > 0) {
                                                                        var53 = field432[field429 - 1];
                                                                        if(var53 == 39 || var53 == 40 || var53 == 41 || var53 == 42 || var53 == 43 || var53 == 33 || var53 == 34 || var53 == 35 || var53 == 36 || var53 == 37 || var53 == 38 || var53 == 1005) {
                                                                           var5 = field419[field429 - 1];
                                                                           var56 = field431[field429 - 1];
                                                                           var128 = class161.method3205(var56);
                                                                           var59 = class34.method734(var128);
                                                                           var114 = (var59 >> 28 & 1) != 0;
                                                                           if(var114) {
                                                                              break label4365;
                                                                           }

                                                                           class178 var164 = (class178)null;
                                                                           if(class151.method3154(class34.method734(var128))) {
                                                                              break label4365;
                                                                           }
                                                                        }
                                                                     }

                                                                     if((var54 == 1 || !class161.field2631 && var54 == 4) && (field427 == 1 && field429 > 2 || class95.method2184(field429 - 1))) {
                                                                        var54 = 2;
                                                                     }

                                                                     if((var54 == 1 || !class161.field2631 && var54 == 4) && field429 > 0) {
                                                                        var53 = field429 - 1;
                                                                        if(var53 >= 0) {
                                                                           var5 = field419[var53];
                                                                           var56 = field431[var53];
                                                                           var7 = field432[var53];
                                                                           var8 = field433[var53];
                                                                           String var106 = field434[var53];
                                                                           String var131 = field396[var53];
                                                                           class96.method2198(var5, var56, var7, var8, var106, var131, class140.field2141, class140.field2142);
                                                                        }
                                                                     }

                                                                     if(var54 == 2 && field429 > 0) {
                                                                        class11.method148(class140.field2141, class140.field2142);
                                                                     }
                                                                     break label4305;
                                                                  }

                                                                  if(null != class38.field849 && !field407 && field427 != 1 && !class95.method2184(field429 - 1) && field429 > 0) {
                                                                     var10 = field404;
                                                                     var11 = field405;
                                                                     var161 = class7.field123;
                                                                     class96.method2198(var161.field688, var161.field691, var161.field690, var161.field689, var161.field692, var161.field692, var10, var11);
                                                                     class7.field123 = null;
                                                                  }

                                                                  field407 = false;
                                                                  field408 = 0;
                                                                  if(null != class38.field849) {
                                                                     class4.method37(class38.field849);
                                                                  }

                                                                  class38.field849 = class161.method3205(var56);
                                                                  field347 = var5;
                                                                  field404 = class140.field2141;
                                                                  field405 = class140.field2142;
                                                                  if(field429 > 0) {
                                                                     class110.method2434(field429 - 1);
                                                                  }

                                                                  class4.method37(class38.field849);
                                                               }
                                                            }
                                                         }

                                                         if(field460 != null) {
                                                            class4.method37(field460);
                                                            ++class103.field1755;
                                                            if(field341 && field465) {
                                                               var54 = class140.field2134;
                                                               var53 = class140.field2135;
                                                               var54 -= field560;
                                                               var53 -= field463;
                                                               if(var54 < field440) {
                                                                  var54 = field440;
                                                               }

                                                               if(field460.field2763 + var54 > field440 + field461.field2763) {
                                                                  var54 = field440 + field461.field2763 - field460.field2763;
                                                               }

                                                               if(var53 < field447) {
                                                                  var53 = field447;
                                                               }

                                                               if(var53 + field460.field2764 > field461.field2764 + field447) {
                                                                  var53 = field447 + field461.field2764 - field460.field2764;
                                                               }

                                                               var5 = var54 - field438;
                                                               var56 = var53 - field470;
                                                               var7 = field460.field2824;
                                                               if(class103.field1755 > field460.field2825 && (var5 > var7 || var5 < -var7 || var56 > var7 || var56 < -var7)) {
                                                                  field545 = true;
                                                               }

                                                               var8 = field461.field2863 + (var54 - field440);
                                                               var59 = var53 - field447 + field461.field2770;
                                                               class0 var133;
                                                               if(field460.field2769 != null && field545) {
                                                                  var133 = new class0();
                                                                  var133.field10 = field460;
                                                                  var133.field3 = var8;
                                                                  var133.field4 = var59;
                                                                  var133.field12 = field460.field2769;
                                                                  class106.method2384(var133);
                                                               }

                                                               if(class140.field2133 == 0) {
                                                                  if(field545) {
                                                                     if(null != field460.field2804) {
                                                                        var133 = new class0();
                                                                        var133.field10 = field460;
                                                                        var133.field3 = var8;
                                                                        var133.field4 = var59;
                                                                        var133.field6 = field464;
                                                                        var133.field12 = field460.field2804;
                                                                        class106.method2384(var133);
                                                                     }

                                                                     if(field464 != null && class119.method2536(field460) != null) {
                                                                        field331.method2781(83);
                                                                        field331.method2695(field464.field2868);
                                                                        field331.method2545(field460.field2868);
                                                                        field331.method2693(field460.field2749);
                                                                        field331.method2545(field464.field2749);
                                                                        field331.method2556(field464.field2748);
                                                                        field331.method2499(field460.field2748);
                                                                     }
                                                                  } else if((field427 == 1 || class95.method2184(field429 - 1)) && field429 > 2) {
                                                                     class11.method148(field560 + field438, field463 + field470);
                                                                  } else if(field429 > 0) {
                                                                     var10 = field438 + field560;
                                                                     var11 = field463 + field470;
                                                                     var161 = class7.field123;
                                                                     class96.method2198(var161.field688, var161.field691, var161.field690, var161.field689, var161.field692, var161.field692, var10, var11);
                                                                     class7.field123 = null;
                                                                  }

                                                                  field460 = null;
                                                               }
                                                            } else if(class103.field1755 > 1) {
                                                               field460 = null;
                                                            }
                                                         }

                                                         if(null != class38.field849) {
                                                            class4.method37(class38.field849);
                                                            ++field408;
                                                            if(class140.field2133 != 0) {
                                                               if(field408 >= 5 && (class140.field2134 > 5 + field404 || class140.field2134 < field404 - 5 || class140.field2135 > 5 + field405 || class140.field2135 < field405 - 5)) {
                                                                  field407 = true;
                                                               }
                                                            } else {
                                                               if(field407) {
                                                                  if(class38.field849 == class119.field1983 && field347 != field320) {
                                                                     class173 var89 = class38.field849;
                                                                     byte var163 = 0;
                                                                     if(field362 == 1 && var89.field2768 == 206) {
                                                                        var163 = 1;
                                                                     }

                                                                     if(var89.field2866[field320] <= 0) {
                                                                        var163 = 0;
                                                                     }

                                                                     if(class151.method3154(class34.method734(var89))) {
                                                                        var5 = field347;
                                                                        var56 = field320;
                                                                        var89.field2866[var56] = var89.field2866[var5];
                                                                        var89.field2745[var56] = var89.field2745[var5];
                                                                        var89.field2866[var5] = -1;
                                                                        var89.field2745[var5] = 0;
                                                                     } else if(var163 == 1) {
                                                                        var5 = field347;
                                                                        var56 = field320;

                                                                        while(var56 != var5) {
                                                                           if(var5 > var56) {
                                                                              var89.method3405(var5 - 1, var5);
                                                                              --var5;
                                                                           } else if(var5 < var56) {
                                                                              var89.method3405(1 + var5, var5);
                                                                              ++var5;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var89.method3405(field320, field347);
                                                                     }

                                                                     field331.method2781(91);
                                                                     field331.method2539(var163);
                                                                     field331.method2557(class38.field849.field2748);
                                                                     field331.method2695(field347);
                                                                     field331.method2545(field320);
                                                                  }
                                                               } else if((field427 == 1 || class95.method2184(field429 - 1)) && field429 > 2) {
                                                                  class11.method148(field404, field405);
                                                               } else if(field429 > 0) {
                                                                  var54 = field404;
                                                                  var53 = field405;
                                                                  class30 var158 = class7.field123;
                                                                  class96.method2198(var158.field688, var158.field691, var158.field690, var158.field689, var158.field692, var158.field692, var54, var53);
                                                                  class7.field123 = null;
                                                               }

                                                               field401 = 10;
                                                               class140.field2140 = 0;
                                                               class38.field849 = null;
                                                            }
                                                         }

                                                         if(class86.field1494 != -1) {
                                                            var54 = class86.field1494;
                                                            var53 = class86.field1473;
                                                            field331.method2781(2);
                                                            field331.method2650(5);
                                                            field331.method2538(class137.field2095[82]?(class137.field2095[81]?2:1):0);
                                                            field331.method2545(var54 + class4.field62);
                                                            field331.method2695(class85.field1434 + var53);
                                                            class86.field1494 = -1;
                                                            field397 = class140.field2141;
                                                            field398 = class140.field2142;
                                                            field400 = 1;
                                                            field304 = 0;
                                                            field521 = var54;
                                                            field522 = var53;
                                                         }

                                                         if(class172.field2732 != var85) {
                                                            if(var85 != null) {
                                                               class4.method37(var85);
                                                            }

                                                            if(class172.field2732 != null) {
                                                               class4.method37(class172.field2732);
                                                            }
                                                         }

                                                         if(class175.field2890 != var86 && field321 == field518) {
                                                            if(var86 != null) {
                                                               class4.method37(var86);
                                                            }

                                                            if(null != class175.field2890) {
                                                               class4.method37(class175.field2890);
                                                            }
                                                         }

                                                         if(null != class175.field2890) {
                                                            if(field518 < field321) {
                                                               ++field518;
                                                               if(field321 == field518) {
                                                                  class4.method37(class175.field2890);
                                                               }
                                                            }
                                                         } else if(field518 > 0) {
                                                            --field518;
                                                         }

                                                         class29.method660();
                                                         if(field535) {
                                                            class99.method2204();
                                                         }

                                                         for(var54 = 0; var54 < 5; ++var54) {
                                                            ++field324[var54];
                                                         }

                                                         class139.field2124.method198();
                                                         var54 = ++class140.field2129 - 1;
                                                         var5 = class137.field2094;
                                                         if(var54 > 15000 && var5 > 15000) {
                                                            field399 = 250;
                                                            class87.method2087(14500);
                                                            field331.method2781(86);
                                                         }

                                                         ++field411;
                                                         if(field411 > 500) {
                                                            field411 = 0;
                                                            var7 = (int)(Math.random() * 8.0D);
                                                            if((var7 & 1) == 1) {
                                                               field444 += field343;
                                                            }

                                                            if((var7 & 2) == 2) {
                                                               field523 += field413;
                                                            }

                                                            if((var7 & 4) == 4) {
                                                               field357 += field372;
                                                            }
                                                         }

                                                         if(field444 < -50) {
                                                            field343 = 2;
                                                         }

                                                         if(field444 > 50) {
                                                            field343 = -2;
                                                         }

                                                         if(field523 < -55) {
                                                            field413 = 2;
                                                         }

                                                         if(field523 > 55) {
                                                            field413 = -2;
                                                         }

                                                         if(field357 < -40) {
                                                            field372 = 1;
                                                         }

                                                         if(field357 > 40) {
                                                            field372 = -1;
                                                         }

                                                         ++field364;
                                                         if(field364 > 500) {
                                                            field364 = 0;
                                                            var7 = (int)(Math.random() * 8.0D);
                                                            if((var7 & 1) == 1) {
                                                               field360 += field361;
                                                            }

                                                            if((var7 & 2) == 2) {
                                                               field558 += field363;
                                                            }
                                                         }

                                                         if(field360 < -60) {
                                                            field361 = 2;
                                                         }

                                                         if(field360 > 60) {
                                                            field361 = -2;
                                                         }

                                                         if(field558 < -20) {
                                                            field363 = 1;
                                                         }

                                                         if(field558 > 10) {
                                                            field363 = -1;
                                                         }

                                                         for(class38 var144 = (class38)field557.method3793(); null != var144; var144 = (class38)field557.method3786()) {
                                                            if((long)var144.field853 < class90.method2090() / 1000L - 5L) {
                                                               if(var144.field851 > 0) {
                                                                  class45.method955(5, "", var144.field856 + " has logged in.");
                                                               }

                                                               if(var144.field851 == 0) {
                                                                  class45.method955(5, "", var144.field856 + " has logged out.");
                                                               }

                                                               var144.method3905();
                                                            }
                                                         }

                                                         ++field337;
                                                         if(field337 > 50) {
                                                            field331.method2781(210);
                                                         }

                                                         try {
                                                            if(class13.field195 != null && field331.field1976 > 0) {
                                                               class13.field195.method3020(field331.field1982, 0, field331.field1976);
                                                               field331.field1976 = 0;
                                                               field337 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var72) {
                                                            class157.method3180();
                                                         }

                                                         return;
                                                      }

                                                      var105 = var87.field10;
                                                      if(var105.field2749 < 0) {
                                                         break;
                                                      }

                                                      var154 = class161.method3205(var105.field2777);
                                                   } while(var154 == null || null == var154.field2872 || var105.field2749 >= var154.field2872.length || var105 != var154.field2872[var105.field2749]);

                                                   class90.method2092(var87, 200000);
                                                }
                                             }

                                             var105 = var87.field10;
                                             if(var105.field2749 < 0) {
                                                break;
                                             }

                                             var154 = class161.method3205(var105.field2777);
                                          } while(null == var154 || null == var154.field2872 || var105.field2749 >= var154.field2872.length || var105 != var154.field2872[var105.field2749]);

                                          class106.method2384(var87);
                                       }
                                    }

                                    var105 = var87.field10;
                                    if(var105.field2749 < 0) {
                                       break;
                                    }

                                    var154 = class161.method3205(var105.field2777);
                                 } while(null == var154 || null == var154.field2872 || var105.field2749 >= var154.field2872.length || var105 != var154.field2872[var105.field2749]);

                                 class90.method2092(var87, 200000);
                              }
                           }
                        }
                     }
                  }
               }
            } else if(field294 == 40 || field294 == 45) {
               class151.method3155();
            }

            return;
         }

         var1.field2693.method3356(var1.field2695, (int)var1.field3113, var1.field2694, false);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-114"
   )
   protected final void vmethod3059() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1026246469"
   )
   static void method546() {
      for(class23 var0 = (class23)class23.field606.method3844(); var0 != null; var0 = (class23)class23.field606.method3834()) {
         if(null != var0.field599) {
            var0.method573();
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;I)V",
      garbageValue = "625498010"
   )
   public static void method547(class167 var0, class167 var1) {
      class39.field886 = var0;
      class39.field884 = var1;
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "-1830247176"
   )
   static void method548(class173 var0, int var1, int var2) {
      if(var0.field2753 == 0) {
         var0.field2796 = var0.field2762;
      } else if(var0.field2753 == 1) {
         var0.field2796 = var0.field2762 + (var1 - var0.field2763) / 2;
      } else if(var0.field2753 == 2) {
         var0.field2796 = var1 - var0.field2763 - var0.field2762;
      } else if(var0.field2753 == 3) {
         var0.field2796 = var0.field2762 * var1 >> 14;
      } else if(var0.field2753 == 4) {
         var0.field2796 = (var1 * var0.field2762 >> 14) + (var1 - var0.field2763) / 2;
      } else {
         var0.field2796 = var1 - var0.field2763 - (var1 * var0.field2762 >> 14);
      }

      if(var0.field2754 == 0) {
         var0.field2823 = var0.field2784;
      } else if(var0.field2754 == 1) {
         var0.field2823 = var0.field2784 + (var2 - var0.field2764) / 2;
      } else if(var0.field2754 == 2) {
         var0.field2823 = var2 - var0.field2764 - var0.field2784;
      } else if(var0.field2754 == 3) {
         var0.field2823 = var2 * var0.field2784 >> 14;
      } else if(var0.field2754 == 4) {
         var0.field2823 = (var0.field2784 * var2 >> 14) + (var2 - var0.field2764) / 2;
      } else {
         var0.field2823 = var2 - var0.field2764 - (var2 * var0.field2784 >> 14);
      }

      if(field336 && var0.field2833 == 0) {
         if(var0.field2796 < 0) {
            var0.field2796 = 0;
         } else if(var0.field2763 + var0.field2796 > var1) {
            var0.field2796 = var1 - var0.field2763;
         }

         if(var0.field2823 < 0) {
            var0.field2823 = 0;
         } else if(var0.field2823 + var0.field2764 > var2) {
            var0.field2823 = var2 - var0.field2764;
         }
      }

   }
}
