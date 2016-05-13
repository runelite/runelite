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
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1610853443
   )
   static int field275;
   @ObfuscatedName("j")
   static client field276;
   @ObfuscatedName("p")
   static boolean field277 = true;
   @ObfuscatedName("dy")
   static int[][][] field278;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 65112213
   )
   @Export("flags")
   static int field279 = 0;
   @ObfuscatedName("o")
   static class153 field280;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1304237175
   )
   static int field281 = 0;
   @ObfuscatedName("an")
   static boolean field282 = false;
   @ObfuscatedName("kb")
   static class199 field283;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1467985559
   )
   static int field285 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -778161829
   )
   @Export("gameState")
   static int field286 = 0;
   @ObfuscatedName("a")
   static boolean field287 = true;
   @ObfuscatedName("jo")
   static class173 field288;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 436822406371399493L
   )
   static long field289 = -1L;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 581161041
   )
   static int field290 = -1;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -189796081
   )
   @Export("localInteractingIndex")
   static int field291;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -2034186015
   )
   static int field292;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 639461657
   )
   static int field293;
   @ObfuscatedName("ht")
   static boolean[] field294;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1459455093
   )
   static int field295 = 0;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 534954117
   )
   static int field296;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1197190835
   )
   static int field297 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 234061835
   )
   static int field298 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1953166527
   )
   static int field299 = 0;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 1438928705
   )
   static int field300;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 1999409945
   )
   @Export("energy")
   static int field301;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1601844117
   )
   static int field302 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1284808245
   )
   static int field303 = 0;
   @ObfuscatedName("ay")
   static class20 field304;
   @ObfuscatedName("aj")
   static class20 field305;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 621379295
   )
   static int field306;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 911930541
   )
   static int field307;
   @ObfuscatedName("iu")
   @Export("componentTable")
   static class196 field308;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 788953677
   )
   static int field309;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -609959975
   )
   static int field310;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -204497549
   )
   static int field311;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -575859423
   )
   static int field312;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 2026250731
   )
   static int field313;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1269998623
   )
   static int field314;
   @ObfuscatedName("ou")
   static class195 field316;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 673606253
   )
   static int field317;
   @ObfuscatedName("ci")
   static int[] field318;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -2063222951
   )
   static int field319;
   @ObfuscatedName("co")
   static int[] field320;
   @ObfuscatedName("cw")
   static class146 field321;
   @ObfuscatedName("cg")
   static class122 field322;
   @ObfuscatedName("on")
   static short field323;
   @ObfuscatedName("ce")
   static class122 field324;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -1008484881
   )
   static int field325;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1973451307
   )
   @Export("packetOpcode")
   static int field326;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -833128001
   )
   static int field327;
   @ObfuscatedName("km")
   static class199 field328;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1898651635
   )
   static int field329;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1927525365
   )
   static int field330;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 862958955
   )
   static int field331;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -440846841
   )
   static int field332;
   @ObfuscatedName("ch")
   static boolean field333;
   @ObfuscatedName("bg")
   static class168 field334;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1849539171
   )
   @Export("gameCycle")
   static int field335 = 0;
   @ObfuscatedName("lt")
   @Export("isResized")
   static boolean field336;
   @ObfuscatedName("om")
   static int[] field337;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -746846431
   )
   static int field338;
   @ObfuscatedName("ds")
   @Export("region")
   static class86 field339;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class108[] field340;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -1196206407
   )
   static int field341;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 1692190137
   )
   static int field342;
   @ObfuscatedName("di")
   static final int[] field343;
   @ObfuscatedName("oc")
   @Export("ignores")
   static class7[] field344;
   @ObfuscatedName("hr")
   @Export("groundItemDeque")
   static class199[][][] field345;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 181270909
   )
   static int field346;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1547685565
   )
   static int field347;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -1658438207
   )
   static int field348;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 1413749765
   )
   static int field349;
   @ObfuscatedName("pd")
   static class179 field350;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -12886951
   )
   static int field351;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -841148157
   )
   static int field352;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -644944783
   )
   @Export("mapScaleDelta")
   static int field353;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1134184447
   )
   static int field354;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -1373459547
   )
   static int field355;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 2114866961
   )
   static int field356;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1122994775
   )
   static int field357;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -1944806483
   )
   static int field358;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 482675147
   )
   static int field359;
   @ObfuscatedName("ee")
   static boolean field361;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -287448627
   )
   static int field362;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 1038438797
   )
   static int field363;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -2049256127
   )
   @Export("mapAngle")
   static int field364;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 268512789
   )
   static int field365;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1539534039
   )
   static int field366;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 849578085
   )
   static int field367;
   @ObfuscatedName("ld")
   static boolean[] field368;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -960666773
   )
   static int field369;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = -1105411211
   )
   static int field370;
   @ObfuscatedName("fj")
   static boolean field371;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 880859411
   )
   static int field372;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 1380487825
   )
   static int field373;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 2039906185
   )
   static int field374;
   @ObfuscatedName("fw")
   static int[] field375;
   @ObfuscatedName("fz")
   static int[] field376;
   @ObfuscatedName("fo")
   static int[] field377;
   @ObfuscatedName("ik")
   @Export("menuIdentifiers")
   static int[] field378;
   @ObfuscatedName("ff")
   static int[] field379;
   @ObfuscatedName("fb")
   static int[] field380;
   @ObfuscatedName("gj")
   static int[] field381;
   @ObfuscatedName("lf")
   static long[] field382;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = -1342527989
   )
   @Export("camera3")
   static int field383;
   @ObfuscatedName("gk")
   static String[] field384;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 337745907
   )
   static int field385;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 906517247
   )
   static int field386;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 528184153
   )
   static int field387;
   @ObfuscatedName("pv")
   @Export("grandExchangeOffers")
   static class220[] field388;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -2143190721
   )
   static int field389;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -98283413
   )
   static int field390;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 630588293
   )
   static int field391;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -1373068767
   )
   static int field392;
   @ObfuscatedName("lz")
   static String field393;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -106265037
   )
   static int field394;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -726743081
   )
   static int field395;
   @ObfuscatedName("mh")
   static byte field396;
   @ObfuscatedName("gb")
   static boolean field397;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = -257090247
   )
   static int field398;
   @ObfuscatedName("hf")
   @Export("boostedSkillLevels")
   static int[] field399;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 2121553383
   )
   static int field400;
   @ObfuscatedName("og")
   static short field401;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -1733104759
   )
   static int field402;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -215687859
   )
   static int field403;
   @ObfuscatedName("he")
   static int[] field404;
   @ObfuscatedName("hy")
   static final int[] field405;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1300510421
   )
   static int field406;
   @ObfuscatedName("nx")
   static int[] field407;
   @ObfuscatedName("mp")
   static int[] field408;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 1130787153
   )
   static int field409;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -133483329
   )
   @Export("mapScale")
   static int field410;
   @ObfuscatedName("hh")
   static class199 field411;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 2089059319
   )
   @Export("widgetRoot")
   static int field412;
   @ObfuscatedName("ho")
   static class199 field413;
   @ObfuscatedName("hx")
   @Export("projectiles")
   static class199 field414;
   @ObfuscatedName("hz")
   @Export("realSkillLevels")
   static int[] field415;
   @ObfuscatedName("mv")
   static String field416;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1715123641
   )
   static int field417;
   @ObfuscatedName("hm")
   @Export("isMenuOpen")
   static boolean field418;
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = -253971939
   )
   static int field419;
   @ObfuscatedName("hv")
   @Export("menuActionParams0")
   static int[] field420;
   @ObfuscatedName("ij")
   @Export("menuActionParams1")
   static int[] field421;
   @ObfuscatedName("il")
   @Export("menuTypes")
   static int[] field422;
   @ObfuscatedName("ob")
   static int[] field423;
   @ObfuscatedName("ir")
   @Export("menuOptions")
   static String[] field424;
   @ObfuscatedName("io")
   @Export("menuTargets")
   static String[] field425;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = -1512033779
   )
   static int field426;
   @ObfuscatedName("hs")
   @Export("skillExperiences")
   static int[] field427;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 506782971
   )
   static int field428;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1604713773
   )
   static int field429;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 1231100629
   )
   static int field430;
   @ObfuscatedName("it")
   static String field431;
   @ObfuscatedName("ih")
   static boolean field432;
   @ObfuscatedName("px")
   static final class10 field433;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = 84693199
   )
   static int field434;
   @ObfuscatedName("if")
   static String field435;
   @ObfuscatedName("ig")
   static String field436;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 565701751
   )
   @Export("weight")
   static int field437;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -2081880895
   )
   static int field438;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -423043271
   )
   static int field439;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 599001627
   )
   static int field440;
   @ObfuscatedName("jw")
   static class173 field441;
   @ObfuscatedName("hc")
   static String[] field442;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -1959000003
   )
   static int field443;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 1771857697
   )
   static int field444;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -987222675
   )
   static int field445;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 53940977
   )
   static int field446;
   @ObfuscatedName("l")
   @Export("isMembers")
   static boolean field447 = false;
   @ObfuscatedName("jq")
   static boolean field448;
   @ObfuscatedName("jg")
   static class173 field449;
   @ObfuscatedName("jk")
   static class173 field450;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 576040195
   )
   static int field451;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -630985795
   )
   static int field452;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 509035499
   )
   static int field453;
   @ObfuscatedName("jj")
   static class173 field454;
   @ObfuscatedName("ju")
   static boolean field455;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = -1375542505
   )
   static int field456;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 426906563
   )
   static int field457;
   @ObfuscatedName("jp")
   static boolean field458;
   @ObfuscatedName("k")
   static class154 field459;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 1690748981
   )
   static int field460;
   @ObfuscatedName("ja")
   static boolean field461;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -1419637069
   )
   static int field462;
   @ObfuscatedName("kh")
   static int[] field463;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 645441117
   )
   static int field464;
   @ObfuscatedName("kn")
   static int[] field465;
   @ObfuscatedName("fq")
   static int[] field466;
   @ObfuscatedName("kw")
   static int[] field467;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1260262945
   )
   static int field468;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 1138829539
   )
   static int field469;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 608151161
   )
   static int field470;
   @ObfuscatedName("dj")
   static boolean field471;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 1656698621
   )
   @Export("camera2")
   static int field472;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -535663493
   )
   static int field473;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -337248223
   )
   static int field474;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 1302823187
   )
   static int field475;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1411510321
   )
   static int field476 = 0;
   @ObfuscatedName("ls")
   @Export("widgetBoundsWidth")
   static int[] field477;
   @ObfuscatedName("kj")
   static class199 field478;
   @ObfuscatedName("kf")
   @Export("widgetFlags")
   static class196 field479;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -26459837
   )
   static int field480;
   @ObfuscatedName("r")
   static String field481;
   @ObfuscatedName("le")
   static boolean[] field482;
   @ObfuscatedName("lg")
   static boolean[] field483;
   @ObfuscatedName("hg")
   static int[] field484;
   @ObfuscatedName("lm")
   @Export("widgetPositionX")
   static int[] field485;
   @ObfuscatedName("lb")
   @Export("widgetPositionY")
   static int[] field486;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -1165718379
   )
   static int field487;
   @ObfuscatedName("ln")
   @Export("widgetBoundsHeight")
   static int[] field488;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1925560759
   )
   static int field489 = -1;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      longValue = -6913380066483939773L
   )
   static long field490;
   @ObfuscatedName("gf")
   @Export("cachedPlayers")
   static class2[] field491;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 1532201843
   )
   static int field492;
   @ObfuscatedName("t")
   static boolean field493 = false;
   @ObfuscatedName("ll")
   static int[] field494;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = -1187893665
   )
   static int field495;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -16429781
   )
   @Export("menuOptionCount")
   static int field496;
   @ObfuscatedName("pn")
   static int[] field497;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -1122084415
   )
   static int field498;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -379926267
   )
   @Export("friendCount")
   static int field499;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -1444452205
   )
   static int field500;
   @ObfuscatedName("mr")
   static int[] field501;
   @ObfuscatedName("jx")
   static boolean field502;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      longValue = -3687670299127673953L
   )
   static long field503;
   @ObfuscatedName("ms")
   static String field504;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -959230243
   )
   static int field505 = -1;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -986614533
   )
   static int field506;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 598467415
   )
   static int field507;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -1401516849
   )
   static int field508;
   @ObfuscatedName("mt")
   static int[] field509;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -607034295
   )
   static int field510;
   @ObfuscatedName("md")
   static class78[] field511;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 1931724213
   )
   @Export("flagX")
   static int field512;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -609527607
   )
   @Export("flagY")
   static int field513;
   @ObfuscatedName("cm")
   @Export("cachedNPCs")
   static class34[] field515;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 1656712803
   )
   static int field516;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 797730811
   )
   static int field517;
   @ObfuscatedName("ml")
   static boolean field518;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -372694933
   )
   static int field519;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -70104543
   )
   static int field520;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 802270599
   )
   static int field521;
   @ObfuscatedName("mq")
   static int[] field522;
   @ObfuscatedName("nd")
   static int[] field523;
   @ObfuscatedName("nk")
   static int[] field524;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -817158365
   )
   static int field525;
   @ObfuscatedName("ni")
   static class58[] field526;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -833463873
   )
   static int field527;
   @ObfuscatedName("oy")
   static boolean[] field528;
   @ObfuscatedName("oh")
   static int[] field529;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -315981745
   )
   static int field530;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -633516087
   )
   static int field531;
   @ObfuscatedName("oj")
   static int[] field532;
   @ObfuscatedName("ok")
   static short field533;
   @ObfuscatedName("oi")
   static short field534;
   @ObfuscatedName("jn")
   static boolean field535;
   @ObfuscatedName("or")
   static short field536;
   @ObfuscatedName("nt")
   static int[] field537;
   @ObfuscatedName("of")
   static short field538;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -2097813425
   )
   static int field539;
   @ObfuscatedName("ot")
   static short field540;
   @ObfuscatedName("ad")
   static boolean field541 = true;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 1273256177
   )
   static int field542;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 482793521
   )
   static int field543 = 0;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = 1856541573
   )
   static int field544;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -1975735565
   )
   static int field545;
   @ObfuscatedName("ct")
   static class122 field546;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -954865103
   )
   static int field547 = 0;
   @ObfuscatedName("oq")
   @Export("friends")
   static class17[] field548;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -458452073
   )
   static int field549;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 909526665
   )
   @Export("ignoreCount")
   static int field550;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1690777257
   )
   @Export("world")
   static int field551 = 1;
   @ObfuscatedName("gw")
   static int[][] field552;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 2119596667
   )
   static int field553;
   @ObfuscatedName("ox")
   static short field554;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 1630104517
   )
   @Export("scale")
   static int field555;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = -2629689870970175195L
   )
   static long field556;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      longValue = 5225485906521576085L
   )
   static long field557;
   @ObfuscatedName("ny")
   static boolean field558;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 1580333283
   )
   static int field559;
   @ObfuscatedName("pg")
   static int[] field560;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 1512542465
   )
   static int field561;
   @ObfuscatedName("ck")
   static class143 field562;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -2125801741
   )
   static int field563;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-99228613"
   )
   protected final void vmethod2998() {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2111856721"
   )
   protected final void vmethod2993() {
      boolean var1 = class21.method557();
      if(var1 && field518 && null != class3.field63) {
         class3.field63.method1172();
      }

      if(field286 == 10 || field286 == 20 || field286 == 30) {
         if(0L != field490 && class12.method162() > field490) {
            int var10 = field336?2:1;
            class9.method127(var10);
         } else if(class144.field2214) {
            class74.method1576(class122.field2024);
            class137.method2896(class122.field2024);
            if(class3.field67 != null) {
               class3.field67.vmethod3092(class122.field2024);
            }

            field276.method3084();
            class122.field2024.setBackground(Color.black);
            Canvas var2 = class122.field2024;
            var2.setFocusTraversalKeysEnabled(false);
            var2.addKeyListener(class137.field2119);
            var2.addFocusListener(class137.field2119);
            class89.method2066(class122.field2024);
            if(null != class3.field67) {
               class3.field67.vmethod3091(class122.field2024);
            }

            if(-1 != field412) {
               class9.method125(false);
            }

            class144.field2209 = true;
         }
      }

      Dimension var11 = this.method2997();
      if(class32.field770 != var11.width || var11.height != class131.field2079 || class144.field2209) {
         class102.method2268();
         field490 = class12.method162() + 500L;
         class144.field2209 = false;
      }

      boolean var3 = false;
      int var4;
      if(class144.field2212) {
         class144.field2212 = false;
         var3 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field482[var4] = true;
         }
      }

      if(var3) {
         class0.method0();
      }

      if(0 == field286) {
         class133.method2845(class31.field730, class31.field731, (Color)null, var3);
      } else if(field286 == 5) {
         class98.method2178(class164.field2665, class12.field187, class181.field2945, var3);
      } else if(10 != field286 && field286 != 11) {
         if(20 == field286) {
            class98.method2178(class164.field2665, class12.field187, class181.field2945, var3);
         } else if(25 == field286) {
            if(field338 == 1) {
               if(field473 > field525) {
                  field525 = field473;
               }

               var4 = (field525 * 50 - field473 * 50) / field525;
               class153.method3132("Loading - please wait.<br> (" + var4 + "%" + ")", false);
            } else if(2 == field338) {
               if(field561 > field444) {
                  field444 = field561;
               }

               var4 = (field444 * 50 - field561 * 50) / field444 + 50;
               class153.method3132("Loading - please wait.<br> (" + var4 + "%" + ")", false);
            } else {
               class153.method3132("Loading - please wait.", false);
            }
         } else if(30 == field286) {
            class172.method3365();
         } else if(40 == field286) {
            class153.method3132("Connection lost<br>Please wait - attempting to reestablish", false);
         } else if(field286 == 45) {
            class153.method3132("Please wait...", false);
         }
      } else {
         class98.method2178(class164.field2665, class12.field187, class181.field2945, var3);
      }

      int var5;
      Graphics var6;
      if(30 == field286 && field506 == 0 && !var3) {
         try {
            var6 = class122.field2024.getGraphics();

            for(var5 = 0; var5 < field480; ++var5) {
               if(field483[var5]) {
                  class135.field2094.vmethod1858(var6, field485[var5], field486[var5], field477[var5], field488[var5]);
                  field483[var5] = false;
               }
            }
         } catch (Exception var9) {
            class122.field2024.repaint();
         }
      } else if(field286 > 0) {
         try {
            var6 = class122.field2024.getGraphics();
            class135.field2094.vmethod1857(var6, 0, 0);

            for(var5 = 0; var5 < field480; ++var5) {
               field483[var5] = false;
            }
         } catch (Exception var8) {
            class122.field2024.repaint();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1080116079"
   )
   void method251() {
      if(1000 != field286) {
         boolean var1 = class134.method2855();
         if(!var1) {
            this.method252();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1966920333"
   )
   void method252() {
      if(class171.field2727 >= 4) {
         this.method2995("js5crc");
         field286 = 1000;
      } else {
         if(class171.field2741 >= 4) {
            if(field286 <= 5) {
               this.method2995("js5io");
               field286 = 1000;
               return;
            }

            field400 = 3000;
            class171.field2741 = 3;
         }

         if(--field400 + 1 <= 0) {
            try {
               if(0 == field309) {
                  class125.field2050 = class38.field878.method2864(class127.field2059, class52.field1170);
                  ++field309;
               }

               if(field309 == 1) {
                  if(2 == class125.field2050.field2226) {
                     this.method253(-1);
                     return;
                  }

                  if(class125.field2050.field2226 == 1) {
                     ++field309;
                  }
               }

               if(2 == field309) {
                  class39.field920 = new class143((Socket)class125.field2050.field2224, class38.field878);
                  class119 var1 = new class119(5);
                  var1.method2477(15);
                  var1.method2480(114);
                  class39.field920.method2964(var1.field2007, 0, 5);
                  ++field309;
                  class135.field2095 = class12.method162();
               }

               if(field309 == 3) {
                  if(field286 > 5 && class39.field920.method2962() <= 0) {
                     if(class12.method162() - class135.field2095 > 30000L) {
                        this.method253(-2);
                        return;
                     }
                  } else {
                     int var10 = class39.field920.method2979();
                     if(0 != var10) {
                        this.method253(var10);
                        return;
                     }

                     ++field309;
                  }
               }

               if(field309 == 4) {
                  class143 var11 = class39.field920;
                  boolean var2 = field286 > 20;
                  if(null != class171.field2731) {
                     try {
                        class171.field2731.method2960();
                     } catch (Exception var8) {
                        ;
                     }

                     class171.field2731 = null;
                  }

                  class171.field2731 = var11;
                  class115.method2439(var2);
                  class171.field2738.field2005 = 0;
                  class124.field2045 = null;
                  class171.field2735 = null;
                  class171.field2733 = 0;

                  while(true) {
                     class172 var3 = (class172)class171.field2726.method3780();
                     if(null == var3) {
                        while(true) {
                           var3 = (class172)class171.field2736.method3780();
                           if(null == var3) {
                              if(class171.field2744 != 0) {
                                 try {
                                    class119 var4 = new class119(4);
                                    var4.method2477(4);
                                    var4.method2477(class171.field2744);
                                    var4.method2661(0);
                                    class171.field2731.method2964(var4.field2007, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class171.field2731.method2960();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class171.field2741;
                                    class171.field2731 = null;
                                 }
                              }

                              class171.field2739 = 0;
                              class171.field2728 = class12.method162();
                              class125.field2050 = null;
                              class39.field920 = null;
                              field309 = 0;
                              field310 = 0;
                              return;
                           }

                           class171.field2743.method3861(var3);
                           class171.field2734.method3778(var3, var3.field3125);
                           ++class171.field2745;
                           --class171.field2737;
                        }
                     }

                     class171.field2729.method3778(var3, var3.field3125);
                     ++class171.field2730;
                     --class171.field2732;
                  }
               }
            } catch (IOException var9) {
               this.method253(-3);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-902132521"
   )
   void method253(int var1) {
      class125.field2050 = null;
      class39.field920 = null;
      field309 = 0;
      if(class59.field1223 == class52.field1170) {
         class52.field1170 = class176.field2922;
      } else {
         class52.field1170 = class59.field1223;
      }

      ++field310;
      if(field310 < 2 || var1 != 7 && var1 != 9) {
         if(field310 >= 2 && var1 == 6) {
            this.method2995("js5connect_outofdate");
            field286 = 1000;
         } else if(field310 >= 4) {
            if(field286 <= 5) {
               this.method2995("js5connect");
               field286 = 1000;
            } else {
               field400 = 3000;
            }
         }
      } else if(field286 <= 5) {
         this.method2995("js5connect_full");
         field286 = 1000;
      } else {
         field400 = 3000;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   protected final void vmethod2987() {
      if(class34.field784.method230()) {
         class34.field784.method227();
      }

      if(null != class44.field1036) {
         class44.field1036.field193 = false;
      }

      class44.field1036 = null;
      if(null != class167.field2697) {
         class167.field2697.method2960();
         class167.field2697 = null;
      }

      if(class137.field2119 != null) {
         class137 var1 = class137.field2119;
         class137 var2 = class137.field2119;
         synchronized(class137.field2119) {
            class137.field2119 = null;
         }
      }

      if(null != class140.field2158) {
         class140 var7 = class140.field2158;
         class140 var8 = class140.field2158;
         synchronized(class140.field2158) {
            class140.field2158 = null;
         }
      }

      class3.field67 = null;
      if(null != class3.field63) {
         class3.field63.method1153();
      }

      if(null != class139.field2154) {
         class139.field2154.method1153();
      }

      class163.method3177();
      class50.method985();
      class87.method2061();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-696510695"
   )
   protected final void vmethod2991() {
      class59.field1223 = 0 == field281?'ꩊ':'鱀' + field551;
      class176.field2922 = field281 == 0?443:'썐' + field551;
      class52.field1170 = class59.field1223;
      class177.field2925 = class174.field2900;
      class166.field2673 = class174.field2907;
      class179.field2933 = class174.field2902;
      class12.field190 = class174.field2903;
      if(class136.field2115.toLowerCase().indexOf("microsoft") != -1) {
         class137.field2145[186] = 57;
         class137.field2145[187] = 27;
         class137.field2145[188] = 71;
         class137.field2145[189] = 26;
         class137.field2145[190] = 72;
         class137.field2145[191] = 73;
         class137.field2145[192] = 58;
         class137.field2145[219] = 42;
         class137.field2145[220] = 74;
         class137.field2145[221] = 43;
         class137.field2145[222] = 59;
         class137.field2145[223] = 28;
      } else {
         class137.field2145[44] = 71;
         class137.field2145[45] = 26;
         class137.field2145[46] = 72;
         class137.field2145[47] = 73;
         class137.field2145[59] = 57;
         class137.field2145[61] = 27;
         class137.field2145[91] = 42;
         class137.field2145[92] = 74;
         class137.field2145[93] = 43;
         class137.field2145[192] = 28;
         class137.field2145[222] = 58;
         class137.field2145[520] = 59;
      }

      Canvas var1 = class122.field2024;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class137.field2119);
      var1.addFocusListener(class137.field2119);
      class89.method2066(class122.field2024);

      class145 var2;
      try {
         var2 = new class145();
      } catch (Throwable var9) {
         var2 = null;
      }

      class3.field67 = var2;
      if(class3.field67 != null) {
         class3.field67.vmethod3091(class122.field2024);
      }

      class30.field709 = new class134(255, class149.field2243, class149.field2244, 500000);
      class227 var3 = null;
      class8 var4 = new class8();

      try {
         var3 = class25.method614("", field459.field2292, false);
         byte[] var5 = new byte[(int)var3.method4108()];

         int var6;
         for(int var7 = 0; var7 < var5.length; var7 += var6) {
            var6 = var3.method4119(var5, var7, var5.length - var7);
            if(-1 == var6) {
               throw new IOException();
            }
         }

         var4 = new class8(new class119(var5));
      } catch (Exception var10) {
         ;
      }

      try {
         if(null != var3) {
            var3.method4121();
         }
      } catch (Exception var8) {
         ;
      }

      class76.field1388 = var4;
      class121.field2019 = this.getToolkit().getSystemClipboard();
      class9.method129(this, class124.field2047);
      if(field281 != 0) {
         field282 = true;
      }

      class9.method127(class76.field1388.field144);
   }

   public final void init() {
      if(this.method3032()) {
         class190[] var1 = class127.method2808();
         int var3 = 0;

         while(true) {
            int var2;
            int var8;
            if(var3 >= var1.length) {
               class86.field1479 = false;
               field493 = false;
               class127.field2059 = this.getCodeBase().getHost();
               String var26 = field280.field2285;
               byte var27 = 0;

               try {
                  class47.field1071 = 16;
                  class149.field2245 = var27;

                  try {
                     class104.field1805 = System.getProperty("os.name");
                  } catch (Exception var21) {
                     class104.field1805 = "Unknown";
                  }

                  class149.field2246 = class104.field1805.toLowerCase();

                  try {
                     class18.field258 = System.getProperty("user.home");
                     if(class18.field258 != null) {
                        class18.field258 = class18.field258 + "/";
                     }
                  } catch (Exception var20) {
                     ;
                  }

                  try {
                     if(class149.field2246.startsWith("win")) {
                        if(class18.field258 == null) {
                           class18.field258 = System.getenv("USERPROFILE");
                        }
                     } else if(class18.field258 == null) {
                        class18.field258 = System.getenv("HOME");
                     }

                     if(class18.field258 != null) {
                        class18.field258 = class18.field258 + "/";
                     }
                  } catch (Exception var19) {
                     ;
                  }

                  if(null == class18.field258) {
                     class18.field258 = "~/";
                  }

                  class76.field1392 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class18.field258, "/tmp/", ""};
                  class22.field583 = new String[]{".jagex_cache_" + class149.field2245, ".file_store_" + class149.field2245};
                  int var28 = 0;

                  File var29;
                  label288:
                  while(var28 < 4) {
                     String var30 = var28 == 0?"":"" + var28;
                     class114.field1977 = new File(class18.field258, "jagex_cl_oldschool_" + var26 + var30 + ".dat");
                     String var32 = null;
                     String var33 = null;
                     boolean var34 = false;
                     File var11;
                     int var14;
                     int var15;
                     if(class114.field1977.exists()) {
                        try {
                           class227 var12 = new class227(class114.field1977, "rw", 10000L);

                           class119 var13;
                           for(var13 = new class119((int)var12.method4108()); var13.field2005 < var13.field2007.length; var13.field2005 += var14) {
                              var14 = var12.method4119(var13.field2007, var13.field2005, var13.field2007.length - var13.field2005);
                              if(-1 == var14) {
                                 throw new IOException();
                              }
                           }

                           var13.field2005 = 0;
                           var14 = var13.method2492();
                           if(var14 < 1 || var14 > 3) {
                              throw new IOException("" + var14);
                           }

                           var15 = 0;
                           if(var14 > 1) {
                              var15 = var13.method2492();
                           }

                           if(var14 <= 2) {
                              var32 = var13.method2501();
                              if(1 == var15) {
                                 var33 = var13.method2501();
                              }
                           } else {
                              var32 = var13.method2502();
                              if(1 == var15) {
                                 var33 = var13.method2502();
                              }
                           }

                           var12.method4121();
                        } catch (IOException var24) {
                           var24.printStackTrace();
                        }

                        if(var32 != null) {
                           var11 = new File(var32);
                           if(!var11.exists()) {
                              var32 = null;
                           }
                        }

                        if(null != var32) {
                           var11 = new File(var32, "test.dat");
                           if(!class170.method3344(var11, true)) {
                              var32 = null;
                           }
                        }
                     }

                     if(null == var32 && 0 == var28) {
                        label263:
                        for(int var36 = 0; var36 < class22.field583.length; ++var36) {
                           for(int var38 = 0; var38 < class76.field1392.length; ++var38) {
                              File var42 = new File(class76.field1392[var38] + class22.field583[var36] + File.separatorChar + "oldschool" + File.separatorChar);
                              if(var42.exists() && class170.method3344(new File(var42, "test.dat"), true)) {
                                 var32 = var42.toString();
                                 var34 = true;
                                 break label263;
                              }
                           }
                        }
                     }

                     if(null == var32) {
                        var32 = class18.field258 + File.separatorChar + "jagexcache" + var30 + File.separatorChar + "oldschool" + File.separatorChar + var26 + File.separatorChar;
                        var34 = true;
                     }

                     File[] var41;
                     if(var33 != null) {
                        File var37 = new File(var33);
                        var11 = new File(var32);

                        try {
                           var41 = var37.listFiles();
                           File[] var43 = var41;

                           for(var15 = 0; var15 < var43.length; ++var15) {
                              File var16 = var43[var15];
                              File var17 = new File(var11, var16.getName());
                              boolean var18 = var16.renameTo(var17);
                              if(!var18) {
                                 throw new IOException();
                              }
                           }
                        } catch (Exception var23) {
                           var23.printStackTrace();
                        }

                        var34 = true;
                     }

                     if(var34) {
                        class162.method3170(new File(var32), (File)null);
                     }

                     var29 = new File(var32);
                     class4.field72 = var29;
                     if(!class4.field72.exists()) {
                        class4.field72.mkdirs();
                     }

                     File[] var39 = class4.field72.listFiles();
                     if(var39 != null) {
                        var41 = var39;

                        for(var14 = 0; var14 < var41.length; ++var14) {
                           File var44 = var41[var14];
                           if(!class170.method3344(var44, false)) {
                              ++var28;
                              continue label288;
                           }
                        }
                     }
                     break;
                  }

                  File var31 = class4.field72;
                  class135.field2099 = var31;
                  if(!class135.field2099.exists()) {
                     throw new RuntimeException("");
                  }

                  class135.field2101 = true;

                  try {
                     var29 = new File(class18.field258, "random.dat");
                     if(var29.exists()) {
                        class149.field2242 = new class228(new class227(var29, "rw", 25L), 24, 0);
                     } else {
                        label213:
                        for(var8 = 0; var8 < class22.field583.length; ++var8) {
                           for(var2 = 0; var2 < class76.field1392.length; ++var2) {
                              File var35 = new File(class76.field1392[var2] + class22.field583[var8] + File.separatorChar + "random.dat");
                              if(var35.exists()) {
                                 class149.field2242 = new class228(new class227(var35, "rw", 25L), 24, 0);
                                 break label213;
                              }
                           }
                        }
                     }

                     if(class149.field2242 == null) {
                        RandomAccessFile var40 = new RandomAccessFile(var29, "rw");
                        var2 = var40.read();
                        var40.seek(0L);
                        var40.write(var2);
                        var40.seek(0L);
                        var40.close();
                        class149.field2242 = new class228(new class227(var29, "rw", 25L), 24, 0);
                     }
                  } catch (IOException var22) {
                     ;
                  }

                  class149.field2243 = new class228(new class227(class33.method693("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
                  class149.field2244 = new class228(new class227(class33.method693("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
                  class20.field570 = new class228[class47.field1071];

                  for(var8 = 0; var8 < class47.field1071; ++var8) {
                     class20.field570[var8] = new class228(new class227(class33.method693("main_file_cache.idx" + var8), "rw", 1048576L), 6000, 0);
                  }
               } catch (Exception var25) {
                  class90.method2067((String)null, var25);
               }

               field276 = this;
               this.method3044(765, 503, 114);
               break;
            }

            class190 var4 = var1[var3];
            String var5 = this.getParameter(var4.field3077);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3077)) {
               case 1:
                  class154[] var6 = new class154[]{class154.field2295, class154.field2293, class154.field2294, class154.field2297, class154.field2296, class154.field2299};
                  field459 = (class154)class75.method1616(var6, Integer.parseInt(var5));
                  if(class154.field2296 == field459) {
                     class1.field24 = class212.field3148;
                  } else {
                     class1.field24 = class212.field3152;
                  }
                  break;
               case 2:
                  field481 = var5;
                  break;
               case 3:
                  if(var5.equalsIgnoreCase("true")) {
                     field447 = true;
                  } else {
                     field447 = false;
                  }
                  break;
               case 4:
                  class15.field208 = Integer.parseInt(var5);
               case 5:
               case 8:
               case 12:
               default:
                  break;
               case 6:
                  class10.field164 = var5;
                  break;
               case 7:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 9:
                  field279 = Integer.parseInt(var5);
                  break;
               case 10:
                  field285 = Integer.parseInt(var5);
                  break;
               case 11:
                  var2 = Integer.parseInt(var5);
                  class153[] var7 = class142.method2957();
                  var8 = 0;

                  class153 var9;
                  while(true) {
                     if(var8 >= var7.length) {
                        var9 = null;
                        break;
                     }

                     class153 var10 = var7[var8];
                     if(var10.field2290 == var2) {
                        var9 = var10;
                        break;
                     }

                     ++var8;
                  }

                  field280 = var9;
                  break;
               case 13:
                  field281 = Integer.parseInt(var5);
                  break;
               case 14:
                  field551 = Integer.parseInt(var5);
                  break;
               case 15:
                  class15.field207 = Integer.parseInt(var5);
               }
            }

            ++var3;
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   @Export("packetHandler")
   protected final void vmethod2992() {
      ++field335;
      this.method251();
      class43.method892();
      class103.method2277();
      class31.method677();
      class123.method2760();
      class140 var1 = class140.field2158;
      class140 var2 = class140.field2158;
      synchronized(class140.field2158) {
         class140.field2161 = class140.field2171;
         class140.field2162 = class140.field2168;
         class140.field2163 = class140.field2160;
         class140.field2159 = class140.field2167;
         class140.field2169 = class140.field2165;
         class140.field2170 = class140.field2166;
         class140.field2164 = class140.field2156;
         class140.field2167 = 0;
      }

      if(null != class3.field67) {
         int var53 = class3.field67.vmethod3094();
         field475 = var53;
      }

      if(0 == field286) {
         class98.method2176();
         class217.method3942();
      } else if(field286 == 5) {
         class75.method1618(this);
         class98.method2176();
         class217.method3942();
      } else if(10 != field286 && field286 != 11) {
         if(20 == field286) {
            class75.method1618(this);
            class108.method2409();
         } else if(field286 == 25) {
            class139.method2920(false);
            field473 = 0;
            boolean var54 = true;

            int var3;
            for(var3 = 0; var3 < class20.field566.length; ++var3) {
               if(class163.field2659[var3] != -1 && null == class20.field566[var3]) {
                  class20.field566[var3] = class7.field132.method3239(class163.field2659[var3], 0);
                  if(null == class20.field566[var3]) {
                     var54 = false;
                     ++field473;
                  }
               }

               if(class11.field172[var3] != -1 && null == class127.field2061[var3]) {
                  class127.field2061[var3] = class7.field132.method3240(class11.field172[var3], 0, class183.field2970[var3]);
                  if(class127.field2061[var3] == null) {
                     var54 = false;
                     ++field473;
                  }
               }
            }

            if(!var54) {
               field338 = 1;
            } else {
               field561 = 0;
               var54 = true;

               int var4;
               int var5;
               for(var3 = 0; var3 < class20.field566.length; ++var3) {
                  byte[] var6 = class127.field2061[var3];
                  if(var6 != null) {
                     var4 = (class144.field2220[var3] >> 8) * 64 - class22.field594;
                     var5 = 64 * (class144.field2220[var3] & 255) - class114.field1981;
                     if(field471) {
                        var4 = 10;
                        var5 = 10;
                     }

                     var54 &= class46.method947(var6, var4, var5);
                  }
               }

               if(!var54) {
                  field338 = 2;
               } else {
                  if(0 != field338) {
                     class153.method3132("Loading - please wait.<br> (100%)", true);
                  }

                  class31.method677();
                  class168.method3328();
                  class31.method677();
                  field339.method1895();
                  class31.method677();
                  System.gc();

                  for(var3 = 0; var3 < 4; ++var3) {
                     field340[var3].method2374();
                  }

                  int var55;
                  for(var3 = 0; var3 < 4; ++var3) {
                     for(var55 = 0; var55 < 104; ++var55) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           class5.field90[var3][var55][var4] = 0;
                        }
                     }
                  }

                  class31.method677();
                  class5.field81 = 99;
                  class5.field94 = new byte[4][104][104];
                  class5.field86 = new byte[4][104][104];
                  class175.field2912 = new byte[4][104][104];
                  class102.field1774 = new byte[4][104][104];
                  class211.field3142 = new int[4][105][105];
                  class5.field84 = new byte[4][105][105];
                  class5.field82 = new int[105][105];
                  class15.field211 = new int[104];
                  class5.field79 = new int[104];
                  class209.field3131 = new int[104];
                  class130.field2077 = new int[104];
                  class148.field2232 = new int[104];
                  var3 = class20.field566.length;

                  for(class23 var7 = (class23)class23.field615.method3812(); null != var7; var7 = (class23)class23.field615.method3817()) {
                     if(null != var7.field598) {
                        class114.field1978.method1117(var7.field598);
                        var7.field598 = null;
                     }

                     if(var7.field610 != null) {
                        class114.field1978.method1117(var7.field610);
                        var7.field610 = null;
                     }
                  }

                  class23.field615.method3806();
                  class139.method2920(true);
                  int var56;
                  if(!field471) {
                     byte[] var8;
                     for(var55 = 0; var55 < var3; ++var55) {
                        var4 = (class144.field2220[var55] >> 8) * 64 - class22.field594;
                        var5 = 64 * (class144.field2220[var55] & 255) - class114.field1981;
                        var8 = class20.field566[var55];
                        if(null != var8) {
                           class31.method677();
                           class16.method200(var8, var4, var5, class110.field1945 * 8 - 48, class82.field1438 * 8 - 48, field340);
                        }
                     }

                     for(var55 = 0; var55 < var3; ++var55) {
                        var4 = 64 * (class144.field2220[var55] >> 8) - class22.field594;
                        var5 = (class144.field2220[var55] & 255) * 64 - class114.field1981;
                        var8 = class20.field566[var55];
                        if(var8 == null && class82.field1438 < 800) {
                           class31.method677();
                           class109.method2414(var4, var5, 64, 64);
                        }
                     }

                     class139.method2920(true);

                     for(var55 = 0; var55 < var3; ++var55) {
                        byte[] var9 = class127.field2061[var55];
                        if(null != var9) {
                           var5 = (class144.field2220[var55] >> 8) * 64 - class22.field594;
                           var56 = (class144.field2220[var55] & 255) * 64 - class114.field1981;
                           class31.method677();
                           class103.method2271(var9, var5, var56, field339, field340);
                        }
                     }
                  }

                  int var10;
                  int var11;
                  int var12;
                  int var13;
                  int var14;
                  int var57;
                  int var58;
                  if(field471) {
                     var55 = 0;

                     label985:
                     while(true) {
                        if(var55 >= 4) {
                           for(var55 = 0; var55 < 13; ++var55) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = field278[0][var55][var4];
                                 if(-1 == var5) {
                                    class109.method2414(8 * var55, 8 * var4, 8, 8);
                                 }
                              }
                           }

                           class139.method2920(true);
                           var55 = 0;

                           while(true) {
                              if(var55 >= 4) {
                                 break label985;
                              }

                              class31.method677();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var56 = field278[var55][var4][var5];
                                    if(-1 != var56) {
                                       var57 = var56 >> 24 & 3;
                                       var58 = var56 >> 1 & 3;
                                       var10 = var56 >> 14 & 1023;
                                       var11 = var56 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var13 = 0; var13 < class144.field2220.length; ++var13) {
                                          if(class144.field2220[var13] == var12 && null != class127.field2061[var13]) {
                                             class153.method3135(class127.field2061[var13], var55, 8 * var4, var5 * 8, var57, 8 * (var10 & 7), 8 * (var11 & 7), var58, field339, field340);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var55;
                           }
                        }

                        class31.method677();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var15 = false;
                              var57 = field278[var55][var4][var5];
                              if(-1 != var57) {
                                 var58 = var57 >> 24 & 3;
                                 var10 = var57 >> 1 & 3;
                                 var11 = var57 >> 14 & 1023;
                                 var12 = var57 >> 3 & 2047;
                                 var13 = (var11 / 8 << 8) + var12 / 8;

                                 for(var14 = 0; var14 < class144.field2220.length; ++var14) {
                                    if(var13 == class144.field2220[var14] && class20.field566[var14] != null) {
                                       class108.method2382(class20.field566[var14], var55, 8 * var4, var5 * 8, var58, 8 * (var11 & 7), (var12 & 7) * 8, var10, field340);
                                       var15 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var15) {
                                 var58 = var55;
                                 var10 = 8 * var4;
                                 var11 = var5 * 8;

                                 for(var12 = 0; var12 < 8; ++var12) {
                                    for(var13 = 0; var13 < 8; ++var13) {
                                       class5.field93[var58][var12 + var10][var11 + var13] = 0;
                                    }
                                 }

                                 if(var10 > 0) {
                                    for(var12 = 1; var12 < 8; ++var12) {
                                       class5.field93[var58][var10][var11 + var12] = class5.field93[var58][var10 - 1][var11 + var12];
                                    }
                                 }

                                 if(var11 > 0) {
                                    for(var12 = 1; var12 < 8; ++var12) {
                                       class5.field93[var58][var12 + var10][var11] = class5.field93[var58][var10 + var12][var11 - 1];
                                    }
                                 }

                                 if(var10 > 0 && 0 != class5.field93[var58][var10 - 1][var11]) {
                                    class5.field93[var58][var10][var11] = class5.field93[var58][var10 - 1][var11];
                                 } else if(var11 > 0 && 0 != class5.field93[var58][var10][var11 - 1]) {
                                    class5.field93[var58][var10][var11] = class5.field93[var58][var10][var11 - 1];
                                 } else if(var10 > 0 && var11 > 0 && 0 != class5.field93[var58][var10 - 1][var11 - 1]) {
                                    class5.field93[var58][var10][var11] = class5.field93[var58][var10 - 1][var11 - 1];
                                 }
                              }
                           }
                        }

                        ++var55;
                     }
                  }

                  class139.method2920(true);
                  class168.method3328();
                  class31.method677();
                  class86 var59 = field339;
                  class108[] var16 = field340;

                  for(var5 = 0; var5 < 4; ++var5) {
                     for(var56 = 0; var56 < 104; ++var56) {
                        for(var57 = 0; var57 < 104; ++var57) {
                           if((class5.field90[var5][var56][var57] & 1) == 1) {
                              var58 = var5;
                              if(2 == (class5.field90[1][var56][var57] & 2)) {
                                 var58 = var5 - 1;
                              }

                              if(var58 >= 0) {
                                 var16[var58].method2378(var56, var57);
                              }
                           }
                        }
                     }
                  }

                  class5.field80 += (int)(Math.random() * 5.0D) - 2;
                  if(class5.field80 < -8) {
                     class5.field80 = -8;
                  }

                  if(class5.field80 > 8) {
                     class5.field80 = 8;
                  }

                  class5.field83 += (int)(Math.random() * 5.0D) - 2;
                  if(class5.field83 < -16) {
                     class5.field83 = -16;
                  }

                  if(class5.field83 > 16) {
                     class5.field83 = 16;
                  }

                  int var17;
                  int var18;
                  int var19;
                  int var20;
                  int var21;
                  int var22;
                  int var23;
                  int var24;
                  for(var5 = 0; var5 < 4; ++var5) {
                     byte[][] var25 = class5.field84[var5];
                     var13 = (int)Math.sqrt(5100.0D);
                     var14 = var13 * 768 >> 8;

                     int var26;
                     int var27;
                     for(var17 = 1; var17 < 103; ++var17) {
                        for(var18 = 1; var18 < 103; ++var18) {
                           var19 = class5.field93[var5][var18 + 1][var17] - class5.field93[var5][var18 - 1][var17];
                           var20 = class5.field93[var5][var18][var17 + 1] - class5.field93[var5][var18][var17 - 1];
                           var21 = (int)Math.sqrt((double)(var20 * var20 + 65536 + var19 * var19));
                           var22 = (var19 << 8) / var21;
                           var23 = 65536 / var21;
                           var24 = (var20 << 8) / var21;
                           var26 = (-50 * var24 + var23 * -10 + -50 * var22) / var14 + 96;
                           var27 = (var25[var18][1 + var17] >> 3) + (var25[var18][var17 - 1] >> 2) + (var25[var18 - 1][var17] >> 2) + (var25[1 + var18][var17] >> 3) + (var25[var18][var17] >> 1);
                           class5.field82[var18][var17] = var26 - var27;
                        }
                     }

                     for(var17 = 0; var17 < 104; ++var17) {
                        class15.field211[var17] = 0;
                        class5.field79[var17] = 0;
                        class209.field3131[var17] = 0;
                        class130.field2077[var17] = 0;
                        class148.field2232[var17] = 0;
                     }

                     for(var17 = -5; var17 < 109; ++var17) {
                        for(var18 = 0; var18 < 104; ++var18) {
                           var19 = 5 + var17;
                           class41 var28;
                           if(var19 >= 0 && var19 < 104) {
                              var20 = class5.field94[var5][var19][var18] & 255;
                              if(var20 > 0) {
                                 var28 = class8.method114(var20 - 1);
                                 class15.field211[var18] += var28.field973;
                                 class5.field79[var18] += var28.field977;
                                 class209.field3131[var18] += var28.field978;
                                 class130.field2077[var18] += var28.field979;
                                 ++class148.field2232[var18];
                              }
                           }

                           var20 = var17 - 5;
                           if(var20 >= 0 && var20 < 104) {
                              var21 = class5.field94[var5][var20][var18] & 255;
                              if(var21 > 0) {
                                 var28 = class8.method114(var21 - 1);
                                 class15.field211[var18] -= var28.field973;
                                 class5.field79[var18] -= var28.field977;
                                 class209.field3131[var18] -= var28.field978;
                                 class130.field2077[var18] -= var28.field979;
                                 --class148.field2232[var18];
                              }
                           }
                        }

                        if(var17 >= 1 && var17 < 103) {
                           var18 = 0;
                           var19 = 0;
                           var20 = 0;
                           var21 = 0;
                           var22 = 0;

                           for(var23 = -5; var23 < 109; ++var23) {
                              var24 = var23 + 5;
                              if(var24 >= 0 && var24 < 104) {
                                 var18 += class15.field211[var24];
                                 var19 += class5.field79[var24];
                                 var20 += class209.field3131[var24];
                                 var21 += class130.field2077[var24];
                                 var22 += class148.field2232[var24];
                              }

                              var26 = var23 - 5;
                              if(var26 >= 0 && var26 < 104) {
                                 var18 -= class15.field211[var26];
                                 var19 -= class5.field79[var26];
                                 var20 -= class209.field3131[var26];
                                 var21 -= class130.field2077[var26];
                                 var22 -= class148.field2232[var26];
                              }

                              if(var23 >= 1 && var23 < 103 && (!field493 || 0 != (class5.field90[0][var17][var23] & 2) || 0 == (class5.field90[var5][var17][var23] & 16))) {
                                 if(var5 < class5.field81) {
                                    class5.field81 = var5;
                                 }

                                 var27 = class5.field94[var5][var17][var23] & 255;
                                 int var62 = class5.field86[var5][var17][var23] & 255;
                                 if(var27 > 0 || var62 > 0) {
                                    int var29 = class5.field93[var5][var17][var23];
                                    int var30 = class5.field93[var5][1 + var17][var23];
                                    int var31 = class5.field93[var5][var17 + 1][var23 + 1];
                                    int var32 = class5.field93[var5][var17][1 + var23];
                                    int var33 = class5.field82[var17][var23];
                                    int var34 = class5.field82[1 + var17][var23];
                                    int var35 = class5.field82[var17 + 1][1 + var23];
                                    int var36 = class5.field82[var17][1 + var23];
                                    int var37 = -1;
                                    int var38 = -1;
                                    int var39;
                                    int var40;
                                    int var41;
                                    if(var27 > 0) {
                                       var39 = 256 * var18 / var21;
                                       var40 = var19 / var22;
                                       var41 = var20 / var22;
                                       var37 = class51.method1039(var39, var40, var41);
                                       var39 = class5.field80 + var39 & 255;
                                       var41 += class5.field83;
                                       if(var41 < 0) {
                                          var41 = 0;
                                       } else if(var41 > 255) {
                                          var41 = 255;
                                       }

                                       var38 = class51.method1039(var39, var40, var41);
                                    }

                                    class46 var42;
                                    if(var5 > 0) {
                                       boolean var43 = true;
                                       if(0 == var27 && 0 != class175.field2912[var5][var17][var23]) {
                                          var43 = false;
                                       }

                                       if(var62 > 0) {
                                          var41 = var62 - 1;
                                          var42 = (class46)class46.field1063.method3743((long)var41);
                                          class46 var44;
                                          if(null != var42) {
                                             var44 = var42;
                                          } else {
                                             byte[] var45 = class209.field3129.method3239(4, var41);
                                             var42 = new class46();
                                             if(null != var45) {
                                                var42.method937(new class119(var45), var41);
                                             }

                                             var42.method936();
                                             class46.field1063.method3745(var42, (long)var41);
                                             var44 = var42;
                                          }

                                          if(!var44.field1052) {
                                             var43 = false;
                                          }
                                       }

                                       if(var43 && var29 == var30 && var29 == var31 && var32 == var29) {
                                          class211.field3142[var5][var17][var23] |= 2340;
                                       }
                                    }

                                    var39 = 0;
                                    if(var38 != -1) {
                                       var39 = class91.field1580[class121.method2735(var38, 96)];
                                    }

                                    if(var62 == 0) {
                                       var59.method2041(var5, var17, var23, 0, 0, -1, var29, var30, var31, var32, class121.method2735(var37, var33), class121.method2735(var37, var34), class121.method2735(var37, var35), class121.method2735(var37, var36), 0, 0, 0, 0, var39, 0);
                                    } else {
                                       var40 = class175.field2912[var5][var17][var23] + 1;
                                       byte var63 = class102.field1774[var5][var17][var23];
                                       int var64 = var62 - 1;
                                       class46 var65 = (class46)class46.field1063.method3743((long)var64);
                                       if(var65 != null) {
                                          var42 = var65;
                                       } else {
                                          byte[] var46 = class209.field3129.method3239(4, var64);
                                          var65 = new class46();
                                          if(var46 != null) {
                                             var65.method937(new class119(var46), var64);
                                          }

                                          var65.method936();
                                          class46.field1063.method3745(var65, (long)var64);
                                          var42 = var65;
                                       }

                                       int var66 = var42.field1051;
                                       int var47;
                                       int var48;
                                       int var49;
                                       int var50;
                                       if(var66 >= 0) {
                                          var48 = class91.field1593.vmethod2150(var66);
                                          var47 = -1;
                                       } else if(var42.field1058 == 16711935) {
                                          var47 = -2;
                                          var66 = -1;
                                          var48 = -2;
                                       } else {
                                          var47 = class51.method1039(var42.field1054, var42.field1055, var42.field1049);
                                          var49 = var42.field1054 + class5.field80 & 255;
                                          var50 = class5.field83 + var42.field1049;
                                          if(var50 < 0) {
                                             var50 = 0;
                                          } else if(var50 > 255) {
                                             var50 = 255;
                                          }

                                          var48 = class51.method1039(var49, var42.field1055, var50);
                                       }

                                       var49 = 0;
                                       if(var48 != -2) {
                                          var49 = class91.field1580[class2.method12(var48, 96)];
                                       }

                                       if(var42.field1053 != -1) {
                                          var50 = class5.field80 + var42.field1061 & 255;
                                          int var51 = class5.field83 + var42.field1059;
                                          if(var51 < 0) {
                                             var51 = 0;
                                          } else if(var51 > 255) {
                                             var51 = 255;
                                          }

                                          var48 = class51.method1039(var50, var42.field1056, var51);
                                          var49 = class91.field1580[class2.method12(var48, 96)];
                                       }

                                       var59.method2041(var5, var17, var23, var40, var63, var66, var29, var30, var31, var32, class121.method2735(var37, var33), class121.method2735(var37, var34), class121.method2735(var37, var35), class121.method2735(var37, var36), class2.method12(var47, var33), class2.method12(var47, var34), class2.method12(var47, var35), class2.method12(var47, var36), var39, var49);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     for(var17 = 1; var17 < 103; ++var17) {
                        for(var18 = 1; var18 < 103; ++var18) {
                           if((class5.field90[var5][var18][var17] & 8) != 0) {
                              var23 = 0;
                           } else if(var5 > 0 && (class5.field90[1][var18][var17] & 2) != 0) {
                              var23 = var5 - 1;
                           } else {
                              var23 = var5;
                           }

                           var59.method1899(var5, var18, var17, var23);
                        }
                     }

                     class5.field94[var5] = (byte[][])((byte[][])null);
                     class5.field86[var5] = (byte[][])((byte[][])null);
                     class175.field2912[var5] = (byte[][])((byte[][])null);
                     class102.field1774[var5] = (byte[][])((byte[][])null);
                     class5.field84[var5] = (byte[][])((byte[][])null);
                  }

                  var59.method1916(-50, -10, -50);

                  for(var5 = 0; var5 < 104; ++var5) {
                     for(var56 = 0; var56 < 104; ++var56) {
                        if((class5.field90[1][var5][var56] & 2) == 2) {
                           var59.method1950(var5, var56);
                        }
                     }
                  }

                  var5 = 1;
                  var56 = 2;
                  var57 = 4;

                  for(var58 = 0; var58 < 4; ++var58) {
                     if(var58 > 0) {
                        var5 <<= 3;
                        var56 <<= 3;
                        var57 <<= 3;
                     }

                     for(var10 = 0; var10 <= var58; ++var10) {
                        for(var11 = 0; var11 <= 104; ++var11) {
                           for(var12 = 0; var12 <= 104; ++var12) {
                              short var60;
                              if((class211.field3142[var10][var12][var11] & var5) != 0) {
                                 var13 = var11;
                                 var14 = var11;
                                 var17 = var10;

                                 for(var18 = var10; var13 > 0 && 0 != (class211.field3142[var10][var12][var13 - 1] & var5); --var13) {
                                    ;
                                 }

                                 while(var14 < 104 && 0 != (class211.field3142[var10][var12][1 + var14] & var5)) {
                                    ++var14;
                                 }

                                 label636:
                                 while(var17 > 0) {
                                    for(var19 = var13; var19 <= var14; ++var19) {
                                       if((class211.field3142[var17 - 1][var12][var19] & var5) == 0) {
                                          break label636;
                                       }
                                    }

                                    --var17;
                                 }

                                 label625:
                                 while(var18 < var58) {
                                    for(var19 = var13; var19 <= var14; ++var19) {
                                       if((class211.field3142[var18 + 1][var12][var19] & var5) == 0) {
                                          break label625;
                                       }
                                    }

                                    ++var18;
                                 }

                                 var19 = (1 + var18 - var17) * (1 + (var14 - var13));
                                 if(var19 >= 8) {
                                    var60 = 240;
                                    var21 = class5.field93[var18][var12][var13] - var60;
                                    var22 = class5.field93[var17][var12][var13];
                                    class86.method1898(var58, 1, 128 * var12, 128 * var12, var13 * 128, 128 * var14 + 128, var21, var22);

                                    for(var23 = var17; var23 <= var18; ++var23) {
                                       for(var24 = var13; var24 <= var14; ++var24) {
                                          class211.field3142[var23][var12][var24] &= ~var5;
                                       }
                                    }
                                 }
                              }

                              if(0 != (class211.field3142[var10][var12][var11] & var56)) {
                                 var13 = var12;
                                 var14 = var12;
                                 var17 = var10;

                                 for(var18 = var10; var13 > 0 && 0 != (class211.field3142[var10][var13 - 1][var11] & var56); --var13) {
                                    ;
                                 }

                                 while(var14 < 104 && 0 != (class211.field3142[var10][var14 + 1][var11] & var56)) {
                                    ++var14;
                                 }

                                 label689:
                                 while(var17 > 0) {
                                    for(var19 = var13; var19 <= var14; ++var19) {
                                       if(0 == (class211.field3142[var17 - 1][var19][var11] & var56)) {
                                          break label689;
                                       }
                                    }

                                    --var17;
                                 }

                                 label678:
                                 while(var18 < var58) {
                                    for(var19 = var13; var19 <= var14; ++var19) {
                                       if(0 == (class211.field3142[var18 + 1][var19][var11] & var56)) {
                                          break label678;
                                       }
                                    }

                                    ++var18;
                                 }

                                 var19 = (var18 + 1 - var17) * (var14 - var13 + 1);
                                 if(var19 >= 8) {
                                    var60 = 240;
                                    var21 = class5.field93[var18][var13][var11] - var60;
                                    var22 = class5.field93[var17][var13][var11];
                                    class86.method1898(var58, 2, var13 * 128, 128 * var14 + 128, 128 * var11, 128 * var11, var21, var22);

                                    for(var23 = var17; var23 <= var18; ++var23) {
                                       for(var24 = var13; var24 <= var14; ++var24) {
                                          class211.field3142[var23][var24][var11] &= ~var56;
                                       }
                                    }
                                 }
                              }

                              if((class211.field3142[var10][var12][var11] & var57) != 0) {
                                 var13 = var12;
                                 var14 = var12;
                                 var17 = var11;

                                 for(var18 = var11; var17 > 0 && 0 != (class211.field3142[var10][var12][var17 - 1] & var57); --var17) {
                                    ;
                                 }

                                 while(var18 < 104 && (class211.field3142[var10][var12][1 + var18] & var57) != 0) {
                                    ++var18;
                                 }

                                 label742:
                                 while(var13 > 0) {
                                    for(var19 = var17; var19 <= var18; ++var19) {
                                       if(0 == (class211.field3142[var10][var13 - 1][var19] & var57)) {
                                          break label742;
                                       }
                                    }

                                    --var13;
                                 }

                                 label731:
                                 while(var14 < 104) {
                                    for(var19 = var17; var19 <= var18; ++var19) {
                                       if(0 == (class211.field3142[var10][1 + var14][var19] & var57)) {
                                          break label731;
                                       }
                                    }

                                    ++var14;
                                 }

                                 if((1 + (var14 - var13)) * (1 + (var18 - var17)) >= 4) {
                                    var19 = class5.field93[var10][var13][var17];
                                    class86.method1898(var58, 4, 128 * var13, 128 + var14 * 128, var17 * 128, 128 + 128 * var18, var19, var19);

                                    for(var20 = var13; var20 <= var14; ++var20) {
                                       for(var21 = var17; var21 <= var18; ++var21) {
                                          class211.field3142[var10][var20][var21] &= ~var57;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  class139.method2920(true);
                  var5 = class5.field81;
                  if(var5 > class21.field581) {
                     var5 = class21.field581;
                  }

                  if(var5 < class21.field581 - 1) {
                     var5 = class21.field581 - 1;
                  }

                  if(field493) {
                     field339.method2055(class5.field81);
                  } else {
                     field339.method2055(0);
                  }

                  for(var56 = 0; var56 < 104; ++var56) {
                     for(var57 = 0; var57 < 104; ++var57) {
                        class12.method161(var56, var57);
                     }
                  }

                  class31.method677();

                  for(class16 var61 = (class16)field411.method3812(); var61 != null; var61 = (class16)field411.method3817()) {
                     if(-1 == var61.field230) {
                        var61.field228 = 0;
                        class148.method3114(var61);
                     } else {
                        var61.method3898();
                     }
                  }

                  class40.field927.method3750();
                  if(class85.field1464 != null) {
                     field322.method2737(203);
                     field322.method2480(1057001181);
                  }

                  if(!field471) {
                     var56 = (class110.field1945 - 6) / 8;
                     var57 = (class110.field1945 + 6) / 8;
                     var58 = (class82.field1438 - 6) / 8;
                     var10 = (6 + class82.field1438) / 8;

                     for(var11 = var56 - 1; var11 <= 1 + var57; ++var11) {
                        for(var12 = var58 - 1; var12 <= 1 + var10; ++var12) {
                           if(var11 < var56 || var11 > var57 || var12 < var58 || var12 > var10) {
                              class7.field132.method3237("m" + var11 + "_" + var12);
                              class7.field132.method3237("l" + var11 + "_" + var12);
                           }
                        }
                     }
                  }

                  class15.method188(30);
                  class31.method677();
                  class5.field94 = (byte[][][])((byte[][][])null);
                  class5.field86 = (byte[][][])((byte[][][])null);
                  class175.field2912 = (byte[][][])((byte[][][])null);
                  class102.field1774 = (byte[][][])((byte[][][])null);
                  class211.field3142 = (int[][][])((int[][][])null);
                  class5.field84 = (byte[][][])((byte[][][])null);
                  class5.field82 = (int[][])((int[][])null);
                  class15.field211 = null;
                  class5.field79 = null;
                  class209.field3131 = null;
                  class130.field2077 = null;
                  class148.field2232 = null;
                  field322.method2737(43);
                  class217.method3942();
               }
            }
         }
      } else {
         class75.method1618(this);
      }

      if(30 == field286) {
         class144.method3081();
      } else if(field286 == 40 || field286 == 45) {
         class108.method2409();
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lclass173;I)Ljava/lang/String;",
      garbageValue = "967183028"
   )
   static String method544(String var0, class173 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(-1 == var3) {
                  break;
               }

               var0 = var0.substring(0, var3) + class130.method2815(class121.method2733(var1, var2 - 1)) + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(-1 == var2) {
               break;
            }

            String var6 = "";
            if(class114.field1975 != null) {
               int var4 = class114.field1975.field2228;
               String var5 = (var4 >> 24 & 255) + "." + (var4 >> 16 & 255) + "." + (var4 >> 8 & 255) + "." + (var4 & 255);
               var6 = var5;
               if(class114.field1975.field2224 != null) {
                  var6 = (String)class114.field1975.field2224;
               }
            }

            var0 = var0.substring(0, var2) + var6 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   static {
      field304 = class20.field567;
      field305 = class20.field567;
      field306 = 0;
      field309 = 0;
      field400 = 0;
      field310 = 0;
      field311 = 0;
      field312 = 0;
      field313 = 0;
      field314 = 0;
      field515 = new class34['耀'];
      field317 = 0;
      field318 = new int['耀'];
      field319 = 0;
      field320 = new int[250];
      field322 = new class122(5000);
      field546 = new class122(5000);
      field324 = new class122(15000);
      field325 = 0;
      field326 = 0;
      field510 = 0;
      field354 = 0;
      field329 = 0;
      field330 = 0;
      field331 = 0;
      field332 = 0;
      field333 = false;
      field473 = 0;
      field525 = 1;
      field561 = 0;
      field444 = 1;
      field338 = 0;
      field340 = new class108[4];
      field471 = false;
      field278 = new int[4][13][13];
      field343 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field342 = 0;
      field498 = 2;
      field346 = 0;
      field347 = 2;
      field348 = 0;
      field549 = 1;
      field440 = 0;
      field410 = 0;
      field352 = 2;
      field353 = 0;
      field300 = 1;
      field355 = 0;
      field356 = 0;
      field357 = 2301979;
      field531 = 5063219;
      field327 = 3353893;
      field527 = 7759444;
      field361 = false;
      field362 = 0;
      field363 = 128;
      field364 = 0;
      field365 = 0;
      field366 = 0;
      field367 = 0;
      field392 = 0;
      field369 = 50;
      field351 = 0;
      field371 = false;
      field372 = 0;
      field373 = 0;
      field374 = 50;
      field375 = new int[field374];
      field376 = new int[field374];
      field377 = new int[field374];
      field466 = new int[field374];
      field379 = new int[field374];
      field380 = new int[field374];
      field381 = new int[field374];
      field384 = new String[field374];
      field552 = new int[104][104];
      field275 = 0;
      field385 = -1;
      field386 = -1;
      field387 = 0;
      field539 = 0;
      field389 = 0;
      field390 = 0;
      field391 = 0;
      field406 = 0;
      field359 = 0;
      field394 = 0;
      field395 = 0;
      field296 = 0;
      field397 = false;
      field417 = 0;
      field358 = 0;
      field491 = new class2[2048];
      field291 = -1;
      field402 = 0;
      field403 = 0;
      field404 = new int[1000];
      field405 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field442 = new String[8];
      field294 = new boolean[8];
      field484 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field409 = -1;
      field345 = new class199[4][104][104];
      field411 = new class199();
      field414 = new class199();
      field413 = new class199();
      field399 = new int[25];
      field415 = new int[25];
      field427 = new int[25];
      field545 = 0;
      field418 = false;
      field496 = 0;
      field420 = new int[500];
      field421 = new int[500];
      field422 = new int[500];
      field378 = new int[500];
      field424 = new String[500];
      field425 = new String[500];
      field426 = -1;
      field443 = -1;
      field428 = 0;
      field429 = 50;
      field430 = 0;
      field431 = null;
      field432 = false;
      field307 = -1;
      field434 = -1;
      field435 = null;
      field436 = null;
      field412 = -1;
      field308 = new class196(8);
      field439 = 0;
      field349 = 0;
      field441 = null;
      field301 = 0;
      field437 = 0;
      field517 = 0;
      field445 = -1;
      field502 = false;
      field535 = false;
      field448 = false;
      field449 = null;
      field450 = null;
      field288 = null;
      field452 = 0;
      field453 = 0;
      field454 = null;
      field455 = false;
      field456 = -1;
      field457 = -1;
      field458 = false;
      field559 = -1;
      field460 = -1;
      field461 = false;
      field462 = 1;
      field463 = new int[32];
      field464 = 0;
      field465 = new int[32];
      field446 = 0;
      field467 = new int[32];
      field468 = 0;
      field469 = 0;
      field470 = 0;
      field451 = 0;
      field438 = 0;
      field563 = 0;
      field474 = 0;
      field475 = 0;
      field283 = new class199();
      field328 = new class199();
      field478 = new class199();
      field479 = new class196(512);
      field480 = 0;
      field487 = -2;
      field482 = new boolean[100];
      field483 = new boolean[100];
      field368 = new boolean[100];
      field485 = new int[100];
      field486 = new int[100];
      field477 = new int[100];
      field488 = new int[100];
      field506 = 0;
      field490 = 0L;
      field336 = true;
      field492 = 765;
      field341 = 503;
      field494 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field495 = 0;
      field292 = 0;
      field393 = "";
      field382 = new long[100];
      field530 = 0;
      field500 = 0;
      field501 = new int[128];
      field408 = new int[128];
      field503 = -1L;
      field504 = null;
      field416 = null;
      field507 = -1;
      field508 = 0;
      field509 = new int[1000];
      field522 = new int[1000];
      field511 = new class78[1000];
      field512 = 0;
      field513 = 0;
      field293 = 0;
      field516 = 255;
      field370 = -1;
      field518 = false;
      field519 = 127;
      field520 = 127;
      field521 = 0;
      field537 = new int[50];
      field523 = new int[50];
      field524 = new int[50];
      field407 = new int[50];
      field526 = new class58[50];
      field558 = false;
      field528 = new boolean[5];
      field529 = new int[5];
      field423 = new int[5];
      field337 = new int[5];
      field532 = new int[5];
      field554 = 256;
      field534 = 205;
      field533 = 256;
      field536 = 320;
      field323 = 1;
      field538 = 32767;
      field401 = 1;
      field540 = 32767;
      field398 = 0;
      field542 = 0;
      field472 = 0;
      field383 = 0;
      field555 = 0;
      field499 = 0;
      field544 = 0;
      field548 = new class17[400];
      field316 = new class195();
      field550 = 0;
      field344 = new class7[400];
      field350 = new class179();
      field553 = -1;
      field419 = -1;
      field388 = new class220[8];
      field556 = -1L;
      field557 = -1L;
      field433 = new class10();
      field497 = new int[50];
      field560 = new int[50];
   }
}
