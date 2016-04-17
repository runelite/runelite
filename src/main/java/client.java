import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
public final class client extends class144 {
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 2047304365
   )
   static int field293;
   @ObfuscatedName("d")
   static client field294;
   @ObfuscatedName("c")
   static boolean field295 = true;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1999749583
   )
   @Export("world")
   static int field296 = 1;
   @ObfuscatedName("ic")
   static String field297;
   @ObfuscatedName("p")
   static class153 field298;
   @ObfuscatedName("ml")
   static boolean field299;
   @ObfuscatedName("ar")
   static boolean field300 = true;
   @ObfuscatedName("z")
   static boolean field301 = false;
   @ObfuscatedName("i")
   static boolean field302 = false;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 2029723011
   )
   static int field303;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -2651559256491141909L
   )
   static long field304 = -1L;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = -1457582811
   )
   static int field305;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1987527235
   )
   @Export("gameCycle")
   static int field306 = 0;
   @ObfuscatedName("mx")
   static int[] field307;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1402013931
   )
   static int field308 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1609747663
   )
   static int field309 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 626826493
   )
   static int field310 = -1;
   @ObfuscatedName("lc")
   @Export("widgetPositionX")
   static int[] field311;
   @ObfuscatedName("ah")
   static boolean field312 = false;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 990159455
   )
   static int field313 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1715166557
   )
   static int field314 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1468929605
   )
   static int field315 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -593956289
   )
   static int field316 = 0;
   @ObfuscatedName("hd")
   static String[] field317;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -606851411
   )
   static int field318 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 548618309
   )
   static int field319 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -478232221
   )
   static int field320 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1084300825
   )
   static int field321 = 0;
   @ObfuscatedName("ae")
   static class20 field322;
   @ObfuscatedName("lh")
   static boolean[] field323;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1138959985
   )
   static int field324;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1840283393
   )
   static int field325;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -811461489
   )
   static int field326;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 200306873
   )
   static int field327;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1602404423
   )
   static int field328;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 157329481
   )
   static int field329;
   @ObfuscatedName("lj")
   static String field330;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -2129932229
   )
   static int field331;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -980322375
   )
   static int field332;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 1916688323
   )
   static int field333;
   @ObfuscatedName("ns")
   static int[] field334;
   @ObfuscatedName("cv")
   static int[] field335;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -453863183
   )
   static int field336;
   @ObfuscatedName("cr")
   static int[] field337;
   @ObfuscatedName("cs")
   static class122 field338;
   @ObfuscatedName("cn")
   static class122 field339;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1905511331
   )
   static int field340;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1055086463
   )
   static int field341;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 942185609
   )
   static int field342;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1149014499
   )
   static int field343;
   @ObfuscatedName("lk")
   @Export("isResized")
   static boolean field344;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -602568633
   )
   static int field345;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -345483113
   )
   static int field346;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = -1375302925
   )
   static int field347;
   @ObfuscatedName("fw")
   static boolean field348;
   @ObfuscatedName("ck")
   static boolean field349;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 197030647
   )
   static int field350;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      longValue = -1203522871109826451L
   )
   static long field351;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1943533731
   )
   static int field352 = 0;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 1674654573
   )
   static int field353;
   @ObfuscatedName("lt")
   static boolean[] field354;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 1959902309
   )
   static int field355;
   @ObfuscatedName("dv")
   static boolean field356;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -1635504899
   )
   static int field357;
   @ObfuscatedName("dl")
   static final int[] field358;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 1428999097
   )
   static int field359;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -164351155
   )
   static int field360;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class108[] field361;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -704692377
   )
   static int field362;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 2146499007
   )
   static int field363;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 774981261
   )
   static int field364;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -841158999
   )
   static int field365;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 2039194815
   )
   static int field366;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -848883721
   )
   static int field367;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -506011925
   )
   static int field368;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1281355187
   )
   static int field369;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -1608745943
   )
   static int field370;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 767805107
   )
   static int field371;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1413501147
   )
   static int field372 = 0;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 926157387
   )
   static int field373;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 2022696555
   )
   static int field374;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 1785250917
   )
   static int field375;
   @ObfuscatedName("el")
   static boolean field376;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -1620069247
   )
   static int field377;
   @ObfuscatedName("it")
   static String field378;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 322791587
   )
   @Export("mapAngle")
   static int field379;
   @ObfuscatedName("hh")
   static int[] field380;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1371745815
   )
   static int field381;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 713898931
   )
   static int field382;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = -576182965
   )
   static int field383;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 1345312633
   )
   static int field384;
   @ObfuscatedName("oq")
   static short field385;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -1392030433
   )
   static int field386;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 1975653745
   )
   static int field387;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -903987587
   )
   static int field388;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 1768860427
   )
   static int field389;
   @ObfuscatedName("fh")
   static int[] field390;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 244043975
   )
   static int field391 = 0;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1365854203
   )
   static int field392;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 9807023
   )
   static int field393;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1173715369
   )
   @Export("packetOpcode")
   static int field394;
   @ObfuscatedName("oi")
   @Export("ignores")
   static class7[] field395;
   @ObfuscatedName("gy")
   static int[] field396;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -1576089809
   )
   static int field397;
   @ObfuscatedName("gr")
   static int[][] field398;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 1656258695
   )
   static int field399;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 409370171
   )
   static int field400;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1873732787
   )
   static int field401;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -161683491
   )
   static int field402;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1007806303
   )
   static int field403;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 1585821101
   )
   static int field404;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 1329401093
   )
   static int field405;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -907060089
   )
   static int field406;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1040864105
   )
   static int field407;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 645168795
   )
   static int field408;
   @ObfuscatedName("jl")
   static class173 field409;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -1879379479
   )
   static int field410;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1388374043
   )
   static int field411;
   @ObfuscatedName("gv")
   static boolean field412;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1284556129
   )
   static int field413;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -1815585919
   )
   static int field414;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -428243353
   )
   static int field416;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -623994399
   )
   static int field417;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -1622668679
   )
   static int field418;
   @ObfuscatedName("fq")
   static int[] field419;
   @ObfuscatedName("ho")
   static final int[] field420;
   @ObfuscatedName("ou")
   static short field421;
   @ObfuscatedName("hi")
   static boolean[] field422;
   @ObfuscatedName("hp")
   static int[] field423;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -1189442631
   )
   static int field424;
   @ObfuscatedName("hm")
   @Export("groundItemDeque")
   static class199[][][] field425;
   @ObfuscatedName("hg")
   static class199 field426;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -1469510277
   )
   static int field427;
   @ObfuscatedName("hz")
   static class199 field428;
   @ObfuscatedName("hl")
   @Export("boostedSkillLevels")
   static int[] field429;
   @ObfuscatedName("hy")
   @Export("realSkillLevels")
   static int[] field430;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 936069645
   )
   static int field431 = 0;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 1447407575
   )
   static int field432;
   @ObfuscatedName("ht")
   @Export("isMenuOpen")
   static boolean field433;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1783625489
   )
   @Export("menuOptionCount")
   static int field434;
   @ObfuscatedName("hv")
   static int[] field435;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1039692003
   )
   static int field436;
   @ObfuscatedName("iu")
   @Export("menuTypes")
   static int[] field437;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -97937591
   )
   static int field438;
   @ObfuscatedName("ij")
   @Export("menuOptions")
   static String[] field439;
   @ObfuscatedName("im")
   @Export("menuTargets")
   static String[] field440;
   @ObfuscatedName("cj")
   static class122 field441;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = -1157988943
   )
   static int field442;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -2030265669
   )
   @Export("mapScale")
   static int field443;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -211455805
   )
   static int field444;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -358690025
   )
   static int field445;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -287427037
   )
   static int field446;
   @ObfuscatedName("ie")
   static boolean field447;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -1787946407
   )
   static int field448;
   @ObfuscatedName("hx")
   static class199 field449;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1462445695
   )
   static int field450;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -1848761277
   )
   static int field451;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = 2080774125
   )
   static int field452;
   @ObfuscatedName("iz")
   @Export("componentTable")
   static class196 field453;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -561391251
   )
   static int field454;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 624077631
   )
   static int field455;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -603863565
   )
   @Export("camera3")
   static int field456;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1992142983
   )
   static int field457;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 1607530781
   )
   @Export("weight")
   static int field458;
   @ObfuscatedName("fu")
   static int[] field459;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 843412903
   )
   static int field460;
   @ObfuscatedName("ja")
   static boolean field461;
   @ObfuscatedName("jg")
   static boolean field462;
   @ObfuscatedName("jd")
   static boolean field463;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 81121959
   )
   static int field464;
   @ObfuscatedName("jo")
   static class173 field465;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -1838413981
   )
   static int field466;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1040442409
   )
   static int field467;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 1851126333
   )
   static int field468;
   @ObfuscatedName("jc")
   static class173 field469;
   @ObfuscatedName("jb")
   static class173 field470;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1343777415
   )
   static int field471;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -423777103
   )
   static int field472;
   @ObfuscatedName("jw")
   static boolean field473;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -1619915845
   )
   static int field474;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 633971755
   )
   static int field475;
   @ObfuscatedName("jj")
   static boolean field476;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 2036034113
   )
   static int field477;
   @ObfuscatedName("hr")
   @Export("skillExperiences")
   static int[] field479;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -293187155
   )
   static int field480;
   @ObfuscatedName("ks")
   static int[] field481;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -563551489
   )
   static int field482;
   @ObfuscatedName("kw")
   static int[] field483;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -1280789689
   )
   static int field484;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 930197897
   )
   static int field485;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 78787859
   )
   static int field486;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 351397487
   )
   static int field487;
   @ObfuscatedName("gg")
   static String[] field488;
   @ObfuscatedName("ko")
   static int[] field489;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      longValue = -2335291602289962997L
   )
   static long field490;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 706319243
   )
   @Export("energy")
   static int field491;
   @ObfuscatedName("ku")
   static class199 field492;
   @ObfuscatedName("kt")
   static class199 field493;
   @ObfuscatedName("kf")
   static class199 field494;
   @ObfuscatedName("kk")
   static class196 field495;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -1340014377
   )
   static int field496;
   @ObfuscatedName("lx")
   @Export("widgetPositionY")
   static int[] field497;
   @ObfuscatedName("js")
   static boolean field498;
   @ObfuscatedName("lu")
   static long[] field499;
   @ObfuscatedName("ik")
   @Export("menuIdentifiers")
   static int[] field500;
   @ObfuscatedName("oe")
   static class195 field501;
   @ObfuscatedName("fv")
   static int[] field502;
   @ObfuscatedName("lf")
   static int[] field503;
   @ObfuscatedName("la")
   static int[] field504;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = 893053457
   )
   static int field505;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      longValue = -5637765941511322071L
   )
   static long field506;
   @ObfuscatedName("s")
   static boolean field507 = true;
   @ObfuscatedName("au")
   static class20 field508;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -78663201
   )
   static int field509;
   @ObfuscatedName("lr")
   static int[] field510;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -1783507679
   )
   static int field511;
   @ObfuscatedName("mf")
   static String field512;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = -1437810571
   )
   static int field514;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -13074275
   )
   static int field515;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -1323842753
   )
   static int field517;
   @ObfuscatedName("mq")
   static int[] field518;
   @ObfuscatedName("mb")
   static int[] field519;
   @ObfuscatedName("ld")
   static boolean[] field520;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 2132058793
   )
   static int field521;
   @ObfuscatedName("mj")
   static String field522;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 133756935
   )
   static int field523;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 779961487
   )
   static int field524;
   @ObfuscatedName("ii")
   static int[] field525;
   @ObfuscatedName("je")
   static class173 field526;
   @ObfuscatedName("mw")
   static class78[] field527;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = -1301272533
   )
   static int field528;
   @ObfuscatedName("ds")
   static int[][][] field529;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 441475751
   )
   static int field530;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = 256508397
   )
   static int field531;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1005680077
   )
   static int field532;
   @ObfuscatedName("fj")
   static int[] field533;
   @ObfuscatedName("is")
   static String field534;
   @ObfuscatedName("or")
   static short field535;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -1847208745
   )
   static int field536;
   @ObfuscatedName("ni")
   static int[] field537;
   @ObfuscatedName("ov")
   static int[] field538;
   @ObfuscatedName("nf")
   static int[] field539;
   @ObfuscatedName("nw")
   static int[] field540;
   @ObfuscatedName("nz")
   static class58[] field541;
   @ObfuscatedName("na")
   static boolean field542;
   @ObfuscatedName("og")
   static boolean[] field543;
   @ObfuscatedName("od")
   static int[] field544;
   @ObfuscatedName("op")
   static short field545;
   @ObfuscatedName("cu")
   @Export("cachedNPCs")
   static class34[] field546;
   @ObfuscatedName("of")
   static int[] field547;
   @ObfuscatedName("oz")
   static short field548;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 648609527
   )
   static int field549;
   @ObfuscatedName("gb")
   @Export("cachedPlayers")
   static class2[] field550;
   @ObfuscatedName("e")
   static class212 field551;
   @ObfuscatedName("om")
   static short field552;
   @ObfuscatedName("oh")
   static short field553;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1750450115
   )
   @Export("gameState")
   static int field554 = 0;
   @ObfuscatedName("ol")
   static short field555;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 1635825209
   )
   static int field556;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 294028263
   )
   static int field557;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 163356249
   )
   @Export("camera2")
   static int field558;
   @ObfuscatedName("oy")
   static int[] field559;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = -397260827
   )
   @Export("scale")
   static int field560;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 1880645837
   )
   static int field561;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -1958791195
   )
   static int field562;
   @ObfuscatedName("ow")
   @Export("friends")
   static class17[] field563;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -831053901
   )
   static int field564;
   @ObfuscatedName("mt")
   static int[] field565;
   @ObfuscatedName("fr")
   static int[] field566;
   @ObfuscatedName("pj")
   static class179 field567;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1328453345
   )
   static int field568;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -2110712331
   )
   static int field569;
   @ObfuscatedName("pd")
   @Export("grandExchangeOffers")
   static class220[] field570;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -1311515257
   )
   static int field571;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      longValue = -8577500595661121427L
   )
   static long field572;
   @ObfuscatedName("pm")
   static final class10 field573;
   @ObfuscatedName("pv")
   static int[] field574;
   @ObfuscatedName("pk")
   static int[] field575;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -997761843
   )
   static int field576;
   @ObfuscatedName("no")
   static class56 field577;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-610835257"
   )
   protected final void vmethod3121() {
   }

   public final void init() {
      if(this.method3116()) {
         class190[] var1 = class6.method136();

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            class190 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3075);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3075)) {
               case 1:
                  class14.field220 = var4;
                  break;
               case 2:
                  field431 = Integer.parseInt(var4);
                  break;
               case 3:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
               case 4:
               case 5:
               case 10:
               default:
                  break;
               case 6:
                  var6 = Integer.parseInt(var4);
                  class153[] var7 = class4.method51();
                  int var8 = 0;

                  class153 var5;
                  while(true) {
                     if(var8 >= var7.length) {
                        var5 = null;
                        break;
                     }

                     class153 var9 = var7[var8];
                     if(var9.field2274 == var6) {
                        var5 = var9;
                        break;
                     }

                     ++var8;
                  }

                  field298 = var5;
                  break;
               case 7:
                  class23.field611 = Integer.parseInt(var4);
                  break;
               case 8:
                  class129.field2050 = Integer.parseInt(var4);
                  break;
               case 9:
                  class1.field21 = (class154)class125.method2926(method631(), Integer.parseInt(var4));
                  if(class154.field2286 == class1.field21) {
                     field551 = class212.field3144;
                  } else {
                     field551 = class212.field3147;
                  }
                  break;
               case 11:
                  class33.field776 = var4;
                  break;
               case 12:
                  if(var4.equalsIgnoreCase("true")) {
                     field301 = true;
                  } else {
                     field301 = false;
                  }
                  break;
               case 13:
                  field296 = Integer.parseInt(var4);
                  break;
               case 14:
                  field372 = Integer.parseInt(var4);
                  break;
               case 15:
                  field352 = Integer.parseInt(var4);
               }
            }
         }

         class86.field1526 = false;
         field302 = false;
         class12.field191 = this.getCodeBase().getHost();
         String var25 = field298.field2278;
         byte var26 = 0;

         try {
            class149.field2232 = 16;
            class72.field1361 = var26;

            try {
               class210.field3135 = System.getProperty("os.name");
            } catch (Exception var20) {
               class210.field3135 = "Unknown";
            }

            class32.field773 = class210.field3135.toLowerCase();

            try {
               class23.field626 = System.getProperty("user.home");
               if(null != class23.field626) {
                  class23.field626 = class23.field626 + "/";
               }
            } catch (Exception var19) {
               ;
            }

            try {
               if(class32.field773.startsWith("win")) {
                  if(class23.field626 == null) {
                     class23.field626 = System.getenv("USERPROFILE");
                  }
               } else if(class23.field626 == null) {
                  class23.field626 = System.getenv("HOME");
               }

               if(class23.field626 != null) {
                  class23.field626 = class23.field626 + "/";
               }
            } catch (Exception var18) {
               ;
            }

            if(null == class23.field626) {
               class23.field626 = "~/";
            }

            class21.field588 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class23.field626, "/tmp/", ""};
            class142.field2173 = new String[]{".jagex_cache_" + class72.field1361, ".file_store_" + class72.field1361};
            int var27 = 0;

            File var29;
            label301:
            while(var27 < 4) {
               String var31 = 0 == var27?"":"" + var27;
               class149.field2230 = new File(class23.field626, "jagex_cl_oldschool_" + var25 + var31 + ".dat");
               String var32 = null;
               String var35 = null;
               boolean var37 = false;
               class119 var10;
               File var42;
               if(class149.field2230.exists()) {
                  try {
                     class227 var39 = new class227(class149.field2230, "rw", 10000L);

                     int var11;
                     for(var10 = new class119((int)var39.method4203()); var10.field1992 < var10.field1993.length; var10.field1992 += var11) {
                        var11 = var39.method4205(var10.field1993, var10.field1992, var10.field1993.length - var10.field1992);
                        if(-1 == var11) {
                           throw new IOException();
                        }
                     }

                     var10.field1992 = 0;
                     var11 = var10.method2613();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var10.method2613();
                     }

                     if(var11 <= 2) {
                        var32 = var10.method2622();
                        if(var12 == 1) {
                           var35 = var10.method2622();
                        }
                     } else {
                        var32 = var10.method2623();
                        if(1 == var12) {
                           var35 = var10.method2623();
                        }
                     }

                     var39.method4202();
                  } catch (IOException var23) {
                     var23.printStackTrace();
                  }

                  if(null != var32) {
                     var42 = new File(var32);
                     if(!var42.exists()) {
                        var32 = null;
                     }
                  }

                  if(null != var32) {
                     var42 = new File(var32, "test.dat");
                     if(!class87.method2161(var42, true)) {
                        var32 = null;
                     }
                  }
               }

               if(null == var32 && 0 == var27) {
                  label275:
                  for(int var41 = 0; var41 < class142.field2173.length; ++var41) {
                     for(int var45 = 0; var45 < class21.field588.length; ++var45) {
                        File var47 = new File(class21.field588[var45] + class142.field2173[var41] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var47.exists() && class87.method2161(new File(var47, "test.dat"), true)) {
                           var32 = var47.toString();
                           var37 = true;
                           break label275;
                        }
                     }
                  }
               }

               if(var32 == null) {
                  var32 = class23.field626 + File.separatorChar + "jagexcache" + var31 + File.separatorChar + "oldschool" + File.separatorChar + var25 + File.separatorChar;
                  var37 = true;
               }

               File var43;
               if(null != var35) {
                  var43 = new File(var35);
                  var42 = new File(var32);

                  try {
                     File[] var48 = var43.listFiles();
                     File[] var50 = var48;

                     for(int var13 = 0; var13 < var50.length; ++var13) {
                        File var14 = var50[var13];
                        File var15 = new File(var42, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var22) {
                     var22.printStackTrace();
                  }

                  var37 = true;
               }

               if(var37) {
                  var43 = new File(var32);
                  var10 = null;

                  try {
                     class227 var49 = new class227(class149.field2230, "rw", 10000L);
                     class119 var51 = new class119(500);
                     var51.method2603(3);
                     var51.method2603(var10 != null?1:0);
                     var51.method2793(var43.getPath());
                     if(var10 != null) {
                        var51.method2793(var10.getPath());
                     }

                     var49.method4201(var51.field1993, 0, var51.field1992);
                     var49.method4202();
                  } catch (IOException var17) {
                     var17.printStackTrace();
                  }
               }

               var29 = new File(var32);
               class149.field2233 = var29;
               if(!class149.field2233.exists()) {
                  class149.field2233.mkdirs();
               }

               File[] var33 = class149.field2233.listFiles();
               if(null != var33) {
                  File[] var46 = var33;

                  for(int var38 = 0; var38 < var46.length; ++var38) {
                     File var44 = var46[var38];
                     if(!class87.method2161(var44, false)) {
                        ++var27;
                        continue label301;
                     }
                  }
               }
               break;
            }

            File var28 = class149.field2233;
            class135.field2090 = var28;
            if(!class135.field2090.exists()) {
               throw new RuntimeException("");
            }

            class135.field2081 = true;

            try {
               var29 = new File(class23.field626, "random.dat");
               if(var29.exists()) {
                  class149.field2234 = new class228(new class227(var29, "rw", 25L), 24, 0);
               } else {
                  label224:
                  for(int var34 = 0; var34 < class142.field2173.length; ++var34) {
                     for(var6 = 0; var6 < class21.field588.length; ++var6) {
                        File var40 = new File(class21.field588[var6] + class142.field2173[var34] + File.separatorChar + "random.dat");
                        if(var40.exists()) {
                           class149.field2234 = new class228(new class227(var40, "rw", 25L), 24, 0);
                           break label224;
                        }
                     }
                  }
               }

               if(class149.field2234 == null) {
                  RandomAccessFile var36 = new RandomAccessFile(var29, "rw");
                  var6 = var36.read();
                  var36.seek(0L);
                  var36.write(var6);
                  var36.seek(0L);
                  var36.close();
                  class149.field2234 = new class228(new class227(var29, "rw", 25L), 24, 0);
               }
            } catch (IOException var21) {
               ;
            }

            class149.field2235 = new class228(new class227(class90.method2166("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class149.field2236 = new class228(new class227(class90.method2166("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class89.field1558 = new class228[class149.field2232];

            for(int var30 = 0; var30 < class149.field2232; ++var30) {
               class89.field1558[var30] = new class228(new class227(class90.method2166("main_file_cache.idx" + var30), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var24) {
            class22.method655((String)null, var24);
         }

         field294 = this;
         this.method3200(765, 503, 112);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-992510431"
   )
   @Export("packetHandler")
   protected final void vmethod3186() {
      ++field306;
      this.method267();
      class23.method660();
      class36.method833();
      class41.method935();
      class137 var1 = class137.field2117;
      synchronized(class137.field2117) {
         ++class137.field2127;
         class137.field2124 = class137.field2126;
         class137.field2123 = 0;
         int var2;
         if(class137.field2119 >= 0) {
            while(class137.field2130 != class137.field2119) {
               var2 = class137.field2121[class137.field2130];
               class137.field2130 = class137.field2130 + 1 & 127;
               if(var2 < 0) {
                  class137.field2115[~var2] = false;
               } else {
                  if(!class137.field2115[var2] && class137.field2123 < class137.field2122.length - 1) {
                     class137.field2122[++class137.field2123 - 1] = var2;
                  }

                  class137.field2115[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               class137.field2115[var2] = false;
            }

            class137.field2119 = class137.field2130;
         }

         class137.field2126 = class137.field2125;
      }

      class140 var7 = class140.field2145;
      synchronized(class140.field2145) {
         class140.field2147 = class140.field2148;
         class140.field2151 = class140.field2162;
         class140.field2161 = class140.field2149;
         class140.field2157 = class140.field2153;
         class140.field2160 = class140.field2154;
         class140.field2159 = class140.field2155;
         class140.field2158 = class140.field2156;
         class140.field2153 = 0;
      }

      int var8;
      if(null != class2.field60) {
         var8 = class2.field60.vmethod3208();
         field571 = var8;
      }

      if(field554 == 0) {
         class13.method195();
         class48.field1091.vmethod3216();

         for(var8 = 0; var8 < 32; ++var8) {
            class144.field2196[var8] = 0L;
         }

         for(var8 = 0; var8 < 32; ++var8) {
            class144.field2194[var8] = 0L;
         }

         class49.field1097 = 0;
      } else if(field554 == 5) {
         class41.method947(this);
         class13.method195();
         class48.field1091.vmethod3216();

         for(var8 = 0; var8 < 32; ++var8) {
            class144.field2196[var8] = 0L;
         }

         for(var8 = 0; var8 < 32; ++var8) {
            class144.field2194[var8] = 0L;
         }

         class49.field1097 = 0;
      } else if(field554 != 10 && 11 != field554) {
         if(20 == field554) {
            class41.method947(this);
            class9.method164();
         } else if(25 == field554) {
            class35.method826();
         }
      } else {
         class41.method947(this);
      }

      if(30 == field554) {
         class164.method3339();
      } else if(field554 == 40 || 45 == field554) {
         class9.method164();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1216940837"
   )
   protected final void vmethod3125() {
      boolean var1;
      label309: {
         try {
            if(class183.field2967 == 2) {
               if(null == class183.field2971) {
                  class183.field2971 = class180.method3586(class114.field1965, class183.field2963, class183.field2968);
                  if(null == class183.field2971) {
                     var1 = false;
                     break label309;
                  }
               }

               if(null == class148.field2223) {
                  class148.field2223 = new class59(class183.field2970, class183.field2964);
               }

               if(class183.field2973.method3715(class183.field2971, class183.field2969, class148.field2223, 22050)) {
                  class183.field2973.method3719();
                  class183.field2973.method3677(class183.field2966);
                  class183.field2973.method3682(class183.field2971, class90.field1568);
                  class183.field2967 = 0;
                  class183.field2971 = null;
                  class148.field2223 = null;
                  class114.field1965 = null;
                  var1 = true;
                  break label309;
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
            class183.field2973.method3683();
            class183.field2967 = 0;
            class183.field2971 = null;
            class148.field2223 = null;
            class114.field1965 = null;
         }

         var1 = false;
      }

      if(var1 && field299 && null != class96.field1627) {
         class96.field1627.method1308();
      }

      if(10 == field554 || 20 == field554 || field554 == 30) {
         if(field506 != 0L && class127.method2941() > field506) {
            int var20 = class24.method674();
            field506 = 0L;
            if(var20 >= 2) {
               field344 = true;
            } else {
               field344 = false;
            }

            class9.method160();
            if(field554 >= 25) {
               class34.method804();
            }

            class144.field2197 = true;
         } else if(class144.field2200) {
            Canvas var3 = class158.field2585;
            var3.removeKeyListener(class137.field2117);
            var3.removeFocusListener(class137.field2117);
            class137.field2119 = -1;
            class101.method2371(class158.field2585);
            if(class2.field60 != null) {
               class2.field60.vmethod3206(class158.field2585);
            }

            field294.method3120();
            class158.field2585.setBackground(Color.black);
            Canvas var4 = class158.field2585;
            var4.setFocusTraversalKeysEnabled(false);
            var4.addKeyListener(class137.field2117);
            var4.addFocusListener(class137.field2117);
            class6.method122(class158.field2585);
            if(class2.field60 != null) {
               class2.field60.vmethod3205(class158.field2585);
            }

            if(-1 != field452) {
               class47.method1085(false);
            }

            class144.field2199 = true;
         }
      }

      Dimension var21 = this.method3129();
      if(var21.width != class133.field2071 || class8.field155 != var21.height || class144.field2199) {
         class9.method160();
         field506 = class127.method2941() + 500L;
         class144.field2199 = false;
      }

      boolean var22 = false;
      int var5;
      if(class144.field2197) {
         class144.field2197 = false;
         var22 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field323[var5] = true;
         }
      }

      if(var22) {
         class93.method2250();
      }

      int var6;
      if(field554 == 0) {
         class127.method2938(class31.field746, class31.field744, (Color)null, var22);
      } else if(5 == field554) {
         class72.method1676(class33.field781, class148.field2220, class135.field2084, var22);
      } else if(field554 != 10 && 11 != field554) {
         if(field554 == 20) {
            class72.method1676(class33.field781, class148.field2220, class135.field2084, var22);
         } else if(25 == field554) {
            if(1 == field346) {
               if(field350 > field521) {
                  field521 = field350;
               }

               var5 = (field521 * 50 - field350 * 50) / field521;
               class25.method682("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field346 == 2) {
               if(field333 > field353) {
                  field353 = field333;
               }

               var5 = 50 + (field353 * 50 - field333 * 50) / field353;
               class25.method682("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class25.method682("Loading - please wait.", false);
            }
         } else if(30 == field554) {
            if(field452 != -1) {
               var5 = field452;
               if(class9.method161(var5)) {
                  class152.method3244(class173.field2886[var5], -1);
               }
            }

            for(var5 = 0; var5 < field496; ++var5) {
               if(field323[var5]) {
                  field520[var5] = true;
               }

               field354[var5] = field323[var5];
               field323[var5] = false;
            }

            field451 = field306;
            field340 = -1;
            field442 = -1;
            class140.field2150 = null;
            if(field452 != -1) {
               field496 = 0;
               class5.method114(field452, 0, 0, class37.field876, class98.field1671, 0, 0, -1);
            }

            class79.method1888();
            if(!field433) {
               if(field340 != -1) {
                  class29.method744(field340, field442);
               }
            } else {
               var5 = class2.field59;
               var6 = class72.field1355;
               int var7 = class42.field996;
               int var8 = class3.field69;
               int var9 = 6116423;
               class79.method1929(var5, var6, var7, var8, var9);
               class79.method1929(1 + var5, var6 + 1, var7 - 2, 16, 0);
               class79.method1941(1 + var5, var6 + 18, var7 - 2, var8 - 19, 0);
               class33.field781.method4116("Choose Option", 3 + var5, var6 + 14, var9, -1);
               int var10 = class140.field2151;
               int var11 = class140.field2161;

               for(int var12 = 0; var12 < field434; ++var12) {
                  int var13 = var6 + 31 + (field434 - 1 - var12) * 15;
                  int var14 = 16777215;
                  if(var10 > var5 && var10 < var5 + var7 && var11 > var13 - 13 && var11 < var13 + 3) {
                     var14 = 16776960;
                  }

                  class224 var15 = class33.field781;
                  String var16;
                  if(field440[var12].length() > 0) {
                     var16 = field439[var12] + " " + field440[var12];
                  } else {
                     var16 = field439[var12];
                  }

                  var15.method4116(var16, var5 + 3, var13, var14, 0);
               }

               class153.method3250(class2.field59, class72.field1355, class42.field996, class3.field69);
            }

            if(3 == field505) {
               for(var5 = 0; var5 < field496; ++var5) {
                  if(field354[var5]) {
                     class79.method1911(field311[var5], field497[var5], field503[var5], field504[var5], 16711935, 128);
                  } else if(field520[var5]) {
                     class79.method1911(field311[var5], field497[var5], field503[var5], field504[var5], 16711680, 128);
                  }
               }
            }

            class40.method902(class42.field1002, class5.field93.field844, class5.field93.field819, field427);
            field427 = 0;
         } else if(field554 == 40) {
            class25.method682("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(45 == field554) {
            class25.method682("Please wait...", false);
         }
      } else {
         class72.method1676(class33.field781, class148.field2220, class135.field2084, var22);
      }

      Graphics var23;
      if(field554 == 30 && field505 == 0 && !var22) {
         try {
            var23 = class158.field2585.getGraphics();

            for(var6 = 0; var6 < field496; ++var6) {
               if(field520[var6]) {
                  class28.field695.vmethod1972(var23, field311[var6], field497[var6], field503[var6], field504[var6]);
                  field520[var6] = false;
               }
            }
         } catch (Exception var18) {
            class158.field2585.repaint();
         }
      } else if(field554 > 0) {
         try {
            var23 = class158.field2585.getGraphics();
            class28.field695.vmethod1970(var23, 0, 0);

            for(var6 = 0; var6 < field496; ++var6) {
               field520[var6] = false;
            }
         } catch (Exception var17) {
            class158.field2585.repaint();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1302076508"
   )
   protected final void vmethod3126() {
      if(class171.field2723.method239()) {
         class171.field2723.method242();
      }

      if(null != class121.field2008) {
         class121.field2008.field213 = false;
      }

      class121.field2008 = null;
      if(null != class127.field2047) {
         class127.field2047.method3095();
         class127.field2047 = null;
      }

      if(null != class137.field2117) {
         class137 var1 = class137.field2117;
         synchronized(class137.field2117) {
            class137.field2117 = null;
         }
      }

      class51.method1173();
      class2.field60 = null;
      if(null != class96.field1627) {
         class96.field1627.method1303();
      }

      if(null != field577) {
         field577.method1303();
      }

      if(null != class171.field2717) {
         class171.field2717.method3095();
      }

      class126.method2934();
      class104.method2385();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-957017780"
   )
   void method267() {
      if(field554 != 1000) {
         boolean var1 = class99.method2286();
         if(!var1) {
            this.method268();
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-37"
   )
   void method268() {
      if(class171.field2734 >= 4) {
         this.method3127("js5crc");
         field554 = 1000;
      } else {
         if(class171.field2733 >= 4) {
            if(field554 <= 5) {
               this.method3127("js5io");
               field554 = 1000;
               return;
            }

            field326 = 3000;
            class171.field2733 = 3;
         }

         if(--field326 + 1 <= 0) {
            try {
               if(0 == field325) {
                  class126.field2039 = class107.field1874.method2990(class12.field191, class42.field1000);
                  ++field325;
               }

               if(field325 == 1) {
                  if(class126.field2039.field2210 == 2) {
                     this.method269(-1);
                     return;
                  }

                  if(class126.field2039.field2210 == 1) {
                     ++field325;
                  }
               }

               if(field325 == 2) {
                  class129.field2054 = new class143((Socket)class126.field2039.field2211, class107.field1874);
                  class119 var1 = new class119(5);
                  var1.method2603(15);
                  var1.method2786(112);
                  class129.field2054.method3100(var1.field1993, 0, 5);
                  ++field325;
                  class48.field1092 = class127.method2941();
               }

               if(field325 == 3) {
                  if(field554 > 5 && class129.field2054.method3098() <= 0) {
                     if(class127.method2941() - class48.field1092 > 30000L) {
                        this.method269(-2);
                        return;
                     }
                  } else {
                     int var3 = class129.field2054.method3097();
                     if(var3 != 0) {
                        this.method269(var3);
                        return;
                     }

                     ++field325;
                  }
               }

               if(4 == field325) {
                  class84.method1997(class129.field2054, field554 > 20);
                  class126.field2039 = null;
                  class129.field2054 = null;
                  field325 = 0;
                  field327 = 0;
               }
            } catch (IOException var2) {
               this.method269(-3);
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-116"
   )
   void method269(int var1) {
      class126.field2039 = null;
      class129.field2054 = null;
      field325 = 0;
      if(class27.field680 == class42.field1000) {
         class42.field1000 = field332;
      } else {
         class42.field1000 = class27.field680;
      }

      ++field327;
      if(field327 < 2 || 7 != var1 && var1 != 9) {
         if(field327 >= 2 && var1 == 6) {
            this.method3127("js5connect_outofdate");
            field554 = 1000;
         } else if(field327 >= 4) {
            if(field554 <= 5) {
               this.method3127("js5connect");
               field554 = 1000;
            } else {
               field326 = 3000;
            }
         }
      } else if(field554 <= 5) {
         this.method3127("js5connect_full");
         field554 = 1000;
      } else {
         field326 = 3000;
      }

   }

   static {
      field322 = class20.field585;
      field508 = class20.field585;
      field324 = 0;
      field325 = 0;
      field326 = 0;
      field327 = 0;
      field328 = 0;
      field329 = 0;
      field392 = 0;
      field331 = 0;
      field546 = new class34['耀'];
      field343 = 0;
      field335 = new int['耀'];
      field336 = 0;
      field337 = new int[250];
      field338 = new class122(5000);
      field339 = new class122(5000);
      field441 = new class122(15000);
      field341 = 0;
      field394 = 0;
      field371 = 0;
      field416 = 0;
      field471 = 0;
      field576 = 0;
      field436 = 0;
      field401 = 0;
      field349 = false;
      field350 = 0;
      field521 = 1;
      field333 = 0;
      field353 = 1;
      field346 = 0;
      field361 = new class108[4];
      field356 = false;
      field529 = new int[4][13][13];
      field358 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field359 = 0;
      field360 = 2;
      field568 = 0;
      field362 = 2;
      field363 = 0;
      field364 = 1;
      field384 = 0;
      field443 = 0;
      field367 = 2;
      field368 = 0;
      field369 = 1;
      field370 = 0;
      field427 = 0;
      field549 = 2301979;
      field373 = 5063219;
      field374 = 3353893;
      field375 = 7759444;
      field376 = false;
      field468 = 0;
      field564 = 128;
      field379 = 0;
      field357 = 0;
      field381 = 0;
      field382 = 0;
      field383 = 0;
      field556 = 50;
      field355 = 0;
      field348 = false;
      field387 = 0;
      field388 = 0;
      field389 = 50;
      field390 = new int[field389];
      field533 = new int[field389];
      field566 = new int[field389];
      field419 = new int[field389];
      field459 = new int[field389];
      field502 = new int[field389];
      field396 = new int[field389];
      field488 = new String[field389];
      field398 = new int[104][104];
      field399 = 0;
      field400 = -1;
      field293 = -1;
      field402 = 0;
      field403 = 0;
      field404 = 0;
      field467 = 0;
      field406 = 0;
      field407 = 0;
      field408 = 0;
      field414 = 0;
      field377 = 0;
      field411 = 0;
      field412 = false;
      field413 = 0;
      field366 = 0;
      field550 = new class2[2048];
      field457 = -1;
      field417 = 0;
      field418 = 0;
      field380 = new int[1000];
      field420 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field317 = new String[8];
      field422 = new boolean[8];
      field423 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field424 = -1;
      field425 = new class199[4][104][104];
      field426 = new class199();
      field449 = new class199();
      field428 = new class199();
      field429 = new int[25];
      field430 = new int[25];
      field479 = new int[25];
      field432 = 0;
      field433 = false;
      field434 = 0;
      field435 = new int[500];
      field525 = new int[500];
      field437 = new int[500];
      field500 = new int[500];
      field439 = new String[500];
      field440 = new String[500];
      field340 = -1;
      field442 = -1;
      field410 = 0;
      field444 = 50;
      field448 = 0;
      field378 = null;
      field447 = false;
      field386 = -1;
      field393 = -1;
      field297 = null;
      field534 = null;
      field452 = -1;
      field453 = new class196(8);
      field454 = 0;
      field455 = 0;
      field526 = null;
      field491 = 0;
      field458 = 0;
      field345 = 0;
      field460 = -1;
      field461 = false;
      field462 = false;
      field463 = false;
      field470 = null;
      field465 = null;
      field409 = null;
      field464 = 0;
      field485 = 0;
      field469 = null;
      field498 = false;
      field450 = -1;
      field472 = -1;
      field473 = false;
      field474 = -1;
      field475 = -1;
      field476 = false;
      field477 = 1;
      field489 = new int[32];
      field480 = 0;
      field481 = new int[32];
      field482 = 0;
      field483 = new int[32];
      field484 = 0;
      field303 = 0;
      field486 = 0;
      field487 = 0;
      field405 = 0;
      field365 = 0;
      field342 = 0;
      field571 = 0;
      field492 = new class199();
      field493 = new class199();
      field494 = new class199();
      field495 = new class196(512);
      field496 = 0;
      field451 = -2;
      field323 = new boolean[100];
      field520 = new boolean[100];
      field354 = new boolean[100];
      field311 = new int[100];
      field497 = new int[100];
      field503 = new int[100];
      field504 = new int[100];
      field505 = 0;
      field506 = 0L;
      field344 = true;
      field438 = 765;
      field509 = 503;
      field510 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field511 = 0;
      field445 = 0;
      field330 = "";
      field499 = new long[100];
      field515 = 0;
      field517 = 0;
      field518 = new int[128];
      field519 = new int[128];
      field351 = -1L;
      field512 = null;
      field522 = null;
      field523 = -1;
      field524 = 0;
      field307 = new int[1000];
      field565 = new int[1000];
      field527 = new class78[1000];
      field528 = 0;
      field347 = 0;
      field530 = 0;
      field531 = 255;
      field532 = -1;
      field299 = false;
      field466 = 127;
      field514 = 127;
      field536 = 0;
      field537 = new int[50];
      field334 = new int[50];
      field539 = new int[50];
      field540 = new int[50];
      field541 = new class58[50];
      field542 = false;
      field543 = new boolean[5];
      field544 = new int[5];
      field559 = new int[5];
      field538 = new int[5];
      field547 = new int[5];
      field548 = 256;
      field535 = 205;
      field421 = 256;
      field545 = 320;
      field552 = 1;
      field553 = 32767;
      field385 = 1;
      field555 = 32767;
      field305 = 0;
      field557 = 0;
      field558 = 0;
      field456 = 0;
      field560 = 0;
      field561 = 0;
      field562 = 0;
      field563 = new class17[400];
      field501 = new class195();
      field397 = 0;
      field395 = new class7[400];
      field567 = new class179();
      field446 = -1;
      field569 = -1;
      field570 = new class220[8];
      field490 = -1L;
      field572 = -1L;
      field573 = new class10();
      field574 = new int[50];
      field575 = new int[50];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1394036163"
   )
   protected final void vmethod3123() {
      class27.field680 = 0 == field352?'ꩊ':field296 + '鱀';
      field332 = field352 == 0?443:'썐' + field296;
      class42.field1000 = class27.field680;
      class17.field264 = class174.field2893;
      class179.field2925 = class174.field2894;
      class186.field3018 = class174.field2898;
      class179.field2922 = class174.field2896;
      class114.method2543();
      Canvas var1 = class158.field2585;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class137.field2117);
      var1.addFocusListener(class137.field2117);
      Canvas var2 = class158.field2585;
      var2.addMouseListener(class140.field2145);
      var2.addMouseMotionListener(class140.field2145);
      var2.addFocusListener(class140.field2145);

      class145 var3;
      try {
         var3 = new class145();
      } catch (Throwable var11) {
         var3 = null;
      }

      class2.field60 = var3;
      if(null != class2.field60) {
         class2.field60.vmethod3205(class158.field2585);
      }

      class134.field2072 = new class134(255, class149.field2235, class149.field2236, 500000);
      class227 var5 = null;
      class8 var6 = new class8();

      try {
         var5 = class11.method188("", class1.field21.field2280, false);
         byte[] var7 = new byte[(int)var5.method4203()];

         int var9;
         for(int var8 = 0; var8 < var7.length; var8 += var9) {
            var9 = var5.method4205(var7, var8, var7.length - var8);
            if(-1 == var9) {
               throw new IOException();
            }
         }

         var6 = new class8(new class119(var7));
      } catch (Exception var12) {
         ;
      }

      try {
         if(null != var5) {
            var5.method4202();
         }
      } catch (Exception var10) {
         ;
      }

      class134.field2078 = var6;
      class35.field793 = this.getToolkit().getSystemClipboard();
      String var13 = class24.field628;
      class138.field2137 = this;
      class138.field2135 = var13;
      if(field352 != 0) {
         field312 = true;
      }

      int var14 = class134.field2078.field145;
      field506 = 0L;
      if(var14 >= 2) {
         field344 = true;
      } else {
         field344 = false;
      }

      class9.method160();
      if(field554 >= 25) {
         class34.method804();
      }

      class144.field2197 = true;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;B)V",
      garbageValue = "18"
   )
   public static void method449(class167 var0) {
      class166.field2658 = var0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-110"
   )
   static int method627() {
      return ++class11.field185 - 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Lclass35;",
      garbageValue = "-242529937"
   )
   static class35 method629(int var0, int var1) {
      class27 var2 = (class27)class11.field183.get(Integer.valueOf(var0));
      return var2.method722(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lclass154;",
      garbageValue = "288038916"
   )
   public static class154[] method631() {
      return new class154[]{class154.field2285, class154.field2284, class154.field2283, class154.field2286, class154.field2282, class154.field2281};
   }
}
