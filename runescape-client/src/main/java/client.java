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
   static int field412;
   @ObfuscatedName("ho")
   static class199 field413;
   @ObfuscatedName("hx")
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
   static int[] field420;
   @ObfuscatedName("ij")
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
   static int[] field477;
   @ObfuscatedName("kj")
   static class199 field478;
   @ObfuscatedName("kf")
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
   static int field512;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -609527607
   )
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
            int var8 = field336?2:1;
            class9.method127(var8);
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

      Dimension var9 = this.method2997();
      if(class32.field770 != var9.width || var9.height != class131.field2079 || class144.field2209) {
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
               class153.method3132("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(2 == field338) {
               if(field561 > field444) {
                  field444 = field561;
               }

               var4 = (field444 * 50 - field561 * 50) / field444 + 50;
               class153.method3132("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class153.method3132("Loading - please wait.", false);
            }
         } else if(30 == field286) {
            class172.method3365();
         } else if(40 == field286) {
            class153.method3132("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field286 == 45) {
            class153.method3132("Please wait...", false);
         }
      } else {
         class98.method2178(class164.field2665, class12.field187, class181.field2945, var3);
      }

      int var5;
      Graphics var10;
      if(30 == field286 && field506 == 0 && !var3) {
         try {
            var10 = class122.field2024.getGraphics();

            for(var5 = 0; var5 < field480; ++var5) {
               if(field483[var5]) {
                  class135.field2094.vmethod1858(var10, field485[var5], field486[var5], field477[var5], field488[var5]);
                  field483[var5] = false;
               }
            }
         } catch (Exception var7) {
            class122.field2024.repaint();
         }
      } else if(field286 > 0) {
         try {
            var10 = class122.field2024.getGraphics();
            class135.field2094.vmethod1857(var10, 0, 0);

            for(var5 = 0; var5 < field480; ++var5) {
               field483[var5] = false;
            }
         } catch (Exception var6) {
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
                     int var9 = class39.field920.method2979();
                     if(0 != var9) {
                        this.method253(var9);
                        return;
                     }

                     ++field309;
                  }
               }

               if(field309 == 4) {
                  class143 var10 = class39.field920;
                  boolean var2 = field286 > 20;
                  if(null != class171.field2731) {
                     try {
                        class171.field2731.method2960();
                     } catch (Exception var7) {
                        ;
                     }

                     class171.field2731 = null;
                  }

                  class171.field2731 = var10;
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
                                    class119 var11 = new class119(4);
                                    var11.method2477(4);
                                    var11.method2477(class171.field2744);
                                    var11.method2661(0);
                                    class171.field2731.method2964(var11.field2007, 0, 4);
                                 } catch (IOException var6) {
                                    try {
                                       class171.field2731.method2960();
                                    } catch (Exception var5) {
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
            } catch (IOException var8) {
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
         synchronized(class137.field2119) {
            class137.field2119 = null;
         }
      }

      if(null != class140.field2158) {
         class140 var6 = class140.field2158;
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
      } catch (Throwable var10) {
         var2 = null;
      }

      class3.field67 = var2;
      if(class3.field67 != null) {
         class3.field67.vmethod3091(class122.field2024);
      }

      class30.field709 = new class134(255, class149.field2243, class149.field2244, 500000);
      class227 var4 = null;
      class8 var5 = new class8();

      try {
         var4 = class25.method614("", field459.field2292, false);
         byte[] var6 = new byte[(int)var4.method4108()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.method4119(var6, var7, var6.length - var7);
            if(-1 == var8) {
               throw new IOException();
            }
         }

         var5 = new class8(new class119(var6));
      } catch (Exception var11) {
         ;
      }

      try {
         if(null != var4) {
            var4.method4121();
         }
      } catch (Exception var9) {
         ;
      }

      class76.field1388 = var5;
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

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            class190 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3077);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3077)) {
               case 1:
                  class154[] var30 = new class154[]{class154.field2295, class154.field2293, class154.field2294, class154.field2297, class154.field2296, class154.field2299};
                  field459 = (class154)class75.method1616(var30, Integer.parseInt(var4));
                  if(class154.field2296 == field459) {
                     class1.field24 = class212.field3148;
                  } else {
                     class1.field24 = class212.field3152;
                  }
                  break;
               case 2:
                  field481 = var4;
                  break;
               case 3:
                  if(var4.equalsIgnoreCase("true")) {
                     field447 = true;
                  } else {
                     field447 = false;
                  }
                  break;
               case 4:
                  class15.field208 = Integer.parseInt(var4);
               case 5:
               case 8:
               case 12:
               default:
                  break;
               case 6:
                  class10.field164 = var4;
                  break;
               case 7:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 9:
                  field279 = Integer.parseInt(var4);
                  break;
               case 10:
                  field285 = Integer.parseInt(var4);
                  break;
               case 11:
                  var6 = Integer.parseInt(var4);
                  class153[] var7 = class142.method2957();
                  int var8 = 0;

                  class153 var5;
                  while(true) {
                     if(var8 >= var7.length) {
                        var5 = null;
                        break;
                     }

                     class153 var9 = var7[var8];
                     if(var9.field2290 == var6) {
                        var5 = var9;
                        break;
                     }

                     ++var8;
                  }

                  field280 = var5;
                  break;
               case 13:
                  field281 = Integer.parseInt(var4);
                  break;
               case 14:
                  field551 = Integer.parseInt(var4);
                  break;
               case 15:
                  class15.field207 = Integer.parseInt(var4);
               }
            }
         }

         class86.field1479 = false;
         field493 = false;
         class127.field2059 = this.getCodeBase().getHost();
         String var24 = field280.field2285;
         byte var25 = 0;

         try {
            class47.field1071 = 16;
            class149.field2245 = var25;

            try {
               class104.field1805 = System.getProperty("os.name");
            } catch (Exception var19) {
               class104.field1805 = "Unknown";
            }

            class149.field2246 = class104.field1805.toLowerCase();

            try {
               class18.field258 = System.getProperty("user.home");
               if(class18.field258 != null) {
                  class18.field258 = class18.field258 + "/";
               }
            } catch (Exception var18) {
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
            } catch (Exception var17) {
               ;
            }

            if(null == class18.field258) {
               class18.field258 = "~/";
            }

            class76.field1392 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class18.field258, "/tmp/", ""};
            class22.field583 = new String[]{".jagex_cache_" + class149.field2245, ".file_store_" + class149.field2245};
            int var26 = 0;

            File var28;
            label280:
            while(var26 < 4) {
               String var31 = var26 == 0?"":"" + var26;
               class114.field1977 = new File(class18.field258, "jagex_cl_oldschool_" + var24 + var31 + ".dat");
               String var32 = null;
               String var35 = null;
               boolean var37 = false;
               File var42;
               if(class114.field1977.exists()) {
                  try {
                     class227 var39 = new class227(class114.field1977, "rw", 10000L);

                     class119 var10;
                     int var11;
                     for(var10 = new class119((int)var39.method4108()); var10.field2005 < var10.field2007.length; var10.field2005 += var11) {
                        var11 = var39.method4119(var10.field2007, var10.field2005, var10.field2007.length - var10.field2005);
                        if(-1 == var11) {
                           throw new IOException();
                        }
                     }

                     var10.field2005 = 0;
                     var11 = var10.method2492();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var10.method2492();
                     }

                     if(var11 <= 2) {
                        var32 = var10.method2501();
                        if(1 == var12) {
                           var35 = var10.method2501();
                        }
                     } else {
                        var32 = var10.method2502();
                        if(1 == var12) {
                           var35 = var10.method2502();
                        }
                     }

                     var39.method4121();
                  } catch (IOException var22) {
                     var22.printStackTrace();
                  }

                  if(var32 != null) {
                     var42 = new File(var32);
                     if(!var42.exists()) {
                        var32 = null;
                     }
                  }

                  if(null != var32) {
                     var42 = new File(var32, "test.dat");
                     if(!class170.method3344(var42, true)) {
                        var32 = null;
                     }
                  }
               }

               if(null == var32 && 0 == var26) {
                  label256:
                  for(int var41 = 0; var41 < class22.field583.length; ++var41) {
                     for(int var45 = 0; var45 < class76.field1392.length; ++var45) {
                        File var47 = new File(class76.field1392[var45] + class22.field583[var41] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var47.exists() && class170.method3344(new File(var47, "test.dat"), true)) {
                           var32 = var47.toString();
                           var37 = true;
                           break label256;
                        }
                     }
                  }
               }

               if(null == var32) {
                  var32 = class18.field258 + File.separatorChar + "jagexcache" + var31 + File.separatorChar + "oldschool" + File.separatorChar + var24 + File.separatorChar;
                  var37 = true;
               }

               if(var35 != null) {
                  File var43 = new File(var35);
                  var42 = new File(var32);

                  try {
                     File[] var48 = var43.listFiles();
                     File[] var49 = var48;

                     for(int var13 = 0; var13 < var49.length; ++var13) {
                        File var14 = var49[var13];
                        File var15 = new File(var42, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var21) {
                     var21.printStackTrace();
                  }

                  var37 = true;
               }

               if(var37) {
                  class162.method3170(new File(var32), (File)null);
               }

               var28 = new File(var32);
               class4.field72 = var28;
               if(!class4.field72.exists()) {
                  class4.field72.mkdirs();
               }

               File[] var33 = class4.field72.listFiles();
               if(var33 == null) {
                  break;
               }

               File[] var46 = var33;
               int var38 = 0;

               while(true) {
                  if(var38 >= var46.length) {
                     break label280;
                  }

                  File var44 = var46[var38];
                  if(!class170.method3344(var44, false)) {
                     ++var26;
                     break;
                  }

                  ++var38;
               }
            }

            File var27 = class4.field72;
            class135.field2099 = var27;
            if(!class135.field2099.exists()) {
               throw new RuntimeException("");
            }

            class135.field2101 = true;

            try {
               var28 = new File(class18.field258, "random.dat");
               if(var28.exists()) {
                  class149.field2242 = new class228(new class227(var28, "rw", 25L), 24, 0);
               } else {
                  label209:
                  for(int var34 = 0; var34 < class22.field583.length; ++var34) {
                     for(var6 = 0; var6 < class76.field1392.length; ++var6) {
                        File var40 = new File(class76.field1392[var6] + class22.field583[var34] + File.separatorChar + "random.dat");
                        if(var40.exists()) {
                           class149.field2242 = new class228(new class227(var40, "rw", 25L), 24, 0);
                           break label209;
                        }
                     }
                  }
               }

               if(class149.field2242 == null) {
                  RandomAccessFile var36 = new RandomAccessFile(var28, "rw");
                  var6 = var36.read();
                  var36.seek(0L);
                  var36.write(var6);
                  var36.seek(0L);
                  var36.close();
                  class149.field2242 = new class228(new class227(var28, "rw", 25L), 24, 0);
               }
            } catch (IOException var20) {
               ;
            }

            class149.field2243 = new class228(new class227(class33.method693("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class149.field2244 = new class228(new class227(class33.method693("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class20.field570 = new class228[class47.field1071];

            for(int var29 = 0; var29 < class47.field1071; ++var29) {
               class20.field570[var29] = new class228(new class227(class33.method693("main_file_cache.idx" + var29), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var23) {
            class90.method2067((String)null, var23);
         }

         field276 = this;
         this.method3044(765, 503, 114);
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
         int var48 = class3.field67.vmethod3094();
         field475 = var48;
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
            boolean var49 = true;

            int var2;
            for(var2 = 0; var2 < class20.field566.length; ++var2) {
               if(class163.field2659[var2] != -1 && null == class20.field566[var2]) {
                  class20.field566[var2] = class7.field132.method3239(class163.field2659[var2], 0);
                  if(null == class20.field566[var2]) {
                     var49 = false;
                     ++field473;
                  }
               }

               if(class11.field172[var2] != -1 && null == class127.field2061[var2]) {
                  class127.field2061[var2] = class7.field132.method3240(class11.field172[var2], 0, class183.field2970[var2]);
                  if(class127.field2061[var2] == null) {
                     var49 = false;
                     ++field473;
                  }
               }
            }

            if(!var49) {
               field338 = 1;
            } else {
               field561 = 0;
               var49 = true;

               int var4;
               int var5;
               for(var2 = 0; var2 < class20.field566.length; ++var2) {
                  byte[] var3 = class127.field2061[var2];
                  if(var3 != null) {
                     var4 = (class144.field2220[var2] >> 8) * 64 - class22.field594;
                     var5 = 64 * (class144.field2220[var2] & 255) - class114.field1981;
                     if(field471) {
                        var4 = 10;
                        var5 = 10;
                     }

                     var49 &= class46.method947(var3, var4, var5);
                  }
               }

               if(!var49) {
                  field338 = 2;
               } else {
                  if(0 != field338) {
                     class153.method3132("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class31.method677();
                  class168.method3328();
                  class31.method677();
                  field339.method1895();
                  class31.method677();
                  System.gc();

                  for(var2 = 0; var2 < 4; ++var2) {
                     field340[var2].method2374();
                  }

                  int var50;
                  for(var2 = 0; var2 < 4; ++var2) {
                     for(var50 = 0; var50 < 104; ++var50) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           class5.field90[var2][var50][var4] = 0;
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
                  var2 = class20.field566.length;

                  for(class23 var51 = (class23)class23.field615.method3812(); null != var51; var51 = (class23)class23.field615.method3817()) {
                     if(null != var51.field598) {
                        class114.field1978.method1117(var51.field598);
                        var51.field598 = null;
                     }

                     if(var51.field610 != null) {
                        class114.field1978.method1117(var51.field610);
                        var51.field610 = null;
                     }
                  }

                  class23.field615.method3806();
                  class139.method2920(true);
                  int var53;
                  if(!field471) {
                     byte[] var6;
                     for(var50 = 0; var50 < var2; ++var50) {
                        var4 = (class144.field2220[var50] >> 8) * 64 - class22.field594;
                        var5 = 64 * (class144.field2220[var50] & 255) - class114.field1981;
                        var6 = class20.field566[var50];
                        if(null != var6) {
                           class31.method677();
                           class16.method200(var6, var4, var5, class110.field1945 * 8 - 48, class82.field1438 * 8 - 48, field340);
                        }
                     }

                     for(var50 = 0; var50 < var2; ++var50) {
                        var4 = 64 * (class144.field2220[var50] >> 8) - class22.field594;
                        var5 = (class144.field2220[var50] & 255) * 64 - class114.field1981;
                        var6 = class20.field566[var50];
                        if(var6 == null && class82.field1438 < 800) {
                           class31.method677();
                           class109.method2414(var4, var5, 64, 64);
                        }
                     }

                     class139.method2920(true);

                     for(var50 = 0; var50 < var2; ++var50) {
                        byte[] var52 = class127.field2061[var50];
                        if(null != var52) {
                           var5 = (class144.field2220[var50] >> 8) * 64 - class22.field594;
                           var53 = (class144.field2220[var50] & 255) * 64 - class114.field1981;
                           class31.method677();
                           class103.method2271(var52, var5, var53, field339, field340);
                        }
                     }
                  }

                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  int var12;
                  int var13;
                  if(field471) {
                     var50 = 0;

                     label1153:
                     while(true) {
                        if(var50 >= 4) {
                           for(var50 = 0; var50 < 13; ++var50) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = field278[0][var50][var4];
                                 if(-1 == var5) {
                                    class109.method2414(8 * var50, 8 * var4, 8, 8);
                                 }
                              }
                           }

                           class139.method2920(true);
                           var50 = 0;

                           while(true) {
                              if(var50 >= 4) {
                                 break label1153;
                              }

                              class31.method677();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var53 = field278[var50][var4][var5];
                                    if(-1 != var53) {
                                       var7 = var53 >> 24 & 3;
                                       var8 = var53 >> 1 & 3;
                                       var9 = var53 >> 14 & 1023;
                                       var10 = var53 >> 3 & 2047;
                                       var11 = (var9 / 8 << 8) + var10 / 8;

                                       for(var12 = 0; var12 < class144.field2220.length; ++var12) {
                                          if(class144.field2220[var12] == var11 && null != class127.field2061[var12]) {
                                             class153.method3135(class127.field2061[var12], var50, 8 * var4, var5 * 8, var7, 8 * (var9 & 7), 8 * (var10 & 7), var8, field339, field340);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var50;
                           }
                        }

                        class31.method677();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var54 = false;
                              var7 = field278[var50][var4][var5];
                              if(-1 != var7) {
                                 var8 = var7 >> 24 & 3;
                                 var9 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(var13 = 0; var13 < class144.field2220.length; ++var13) {
                                    if(var12 == class144.field2220[var13] && class20.field566[var13] != null) {
                                       class108.method2382(class20.field566[var13], var50, 8 * var4, var5 * 8, var8, 8 * (var10 & 7), (var11 & 7) * 8, var9, field340);
                                       var54 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var54) {
                                 var8 = var50;
                                 var9 = 8 * var4;
                                 var10 = var5 * 8;

                                 for(var11 = 0; var11 < 8; ++var11) {
                                    for(var12 = 0; var12 < 8; ++var12) {
                                       class5.field93[var8][var11 + var9][var10 + var12] = 0;
                                    }
                                 }

                                 if(var9 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class5.field93[var8][var9][var10 + var11] = class5.field93[var8][var9 - 1][var10 + var11];
                                    }
                                 }

                                 if(var10 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class5.field93[var8][var11 + var9][var10] = class5.field93[var8][var9 + var11][var10 - 1];
                                    }
                                 }

                                 if(var9 > 0 && 0 != class5.field93[var8][var9 - 1][var10]) {
                                    class5.field93[var8][var9][var10] = class5.field93[var8][var9 - 1][var10];
                                 } else if(var10 > 0 && 0 != class5.field93[var8][var9][var10 - 1]) {
                                    class5.field93[var8][var9][var10] = class5.field93[var8][var9][var10 - 1];
                                 } else if(var9 > 0 && var10 > 0 && 0 != class5.field93[var8][var9 - 1][var10 - 1]) {
                                    class5.field93[var8][var9][var10] = class5.field93[var8][var9 - 1][var10 - 1];
                                 }
                              }
                           }
                        }

                        ++var50;
                     }
                  }

                  class139.method2920(true);
                  class168.method3328();
                  class31.method677();
                  class86 var55 = field339;
                  class108[] var56 = field340;

                  for(var5 = 0; var5 < 4; ++var5) {
                     for(var53 = 0; var53 < 104; ++var53) {
                        for(var7 = 0; var7 < 104; ++var7) {
                           if((class5.field90[var5][var53][var7] & 1) == 1) {
                              var8 = var5;
                              if(2 == (class5.field90[1][var53][var7] & 2)) {
                                 var8 = var5 - 1;
                              }

                              if(var8 >= 0) {
                                 var56[var8].method2378(var53, var7);
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

                  int var14;
                  int var15;
                  int var16;
                  int var17;
                  int var18;
                  int var19;
                  int var20;
                  int var21;
                  for(var5 = 0; var5 < 4; ++var5) {
                     byte[][] var57 = class5.field84[var5];
                     var12 = (int)Math.sqrt(5100.0D);
                     var13 = var12 * 768 >> 8;

                     int var22;
                     int var23;
                     for(var14 = 1; var14 < 103; ++var14) {
                        for(var15 = 1; var15 < 103; ++var15) {
                           var16 = class5.field93[var5][var15 + 1][var14] - class5.field93[var5][var15 - 1][var14];
                           var17 = class5.field93[var5][var15][var14 + 1] - class5.field93[var5][var15][var14 - 1];
                           var18 = (int)Math.sqrt((double)(var17 * var17 + 65536 + var16 * var16));
                           var19 = (var16 << 8) / var18;
                           var20 = 65536 / var18;
                           var21 = (var17 << 8) / var18;
                           var22 = (-50 * var21 + var20 * -10 + -50 * var19) / var13 + 96;
                           var23 = (var57[var15][1 + var14] >> 3) + (var57[var15][var14 - 1] >> 2) + (var57[var15 - 1][var14] >> 2) + (var57[1 + var15][var14] >> 3) + (var57[var15][var14] >> 1);
                           class5.field82[var15][var14] = var22 - var23;
                        }
                     }

                     for(var14 = 0; var14 < 104; ++var14) {
                        class15.field211[var14] = 0;
                        class5.field79[var14] = 0;
                        class209.field3131[var14] = 0;
                        class130.field2077[var14] = 0;
                        class148.field2232[var14] = 0;
                     }

                     for(var14 = -5; var14 < 109; ++var14) {
                        for(var15 = 0; var15 < 104; ++var15) {
                           var16 = 5 + var14;
                           if(var16 >= 0 && var16 < 104) {
                              var17 = class5.field94[var5][var16][var15] & 255;
                              if(var17 > 0) {
                                 class41 var59 = class8.method114(var17 - 1);
                                 class15.field211[var15] += var59.field973;
                                 class5.field79[var15] += var59.field977;
                                 class209.field3131[var15] += var59.field978;
                                 class130.field2077[var15] += var59.field979;
                                 ++class148.field2232[var15];
                              }
                           }

                           var17 = var14 - 5;
                           if(var17 >= 0 && var17 < 104) {
                              var18 = class5.field94[var5][var17][var15] & 255;
                              if(var18 > 0) {
                                 class41 var60 = class8.method114(var18 - 1);
                                 class15.field211[var15] -= var60.field973;
                                 class5.field79[var15] -= var60.field977;
                                 class209.field3131[var15] -= var60.field978;
                                 class130.field2077[var15] -= var60.field979;
                                 --class148.field2232[var15];
                              }
                           }
                        }

                        if(var14 >= 1 && var14 < 103) {
                           var15 = 0;
                           var16 = 0;
                           var17 = 0;
                           var18 = 0;
                           var19 = 0;

                           for(var20 = -5; var20 < 109; ++var20) {
                              var21 = var20 + 5;
                              if(var21 >= 0 && var21 < 104) {
                                 var15 += class15.field211[var21];
                                 var16 += class5.field79[var21];
                                 var17 += class209.field3131[var21];
                                 var18 += class130.field2077[var21];
                                 var19 += class148.field2232[var21];
                              }

                              var22 = var20 - 5;
                              if(var22 >= 0 && var22 < 104) {
                                 var15 -= class15.field211[var22];
                                 var16 -= class5.field79[var22];
                                 var17 -= class209.field3131[var22];
                                 var18 -= class130.field2077[var22];
                                 var19 -= class148.field2232[var22];
                              }

                              if(var20 >= 1 && var20 < 103 && (!field493 || 0 != (class5.field90[0][var14][var20] & 2) || 0 == (class5.field90[var5][var14][var20] & 16))) {
                                 if(var5 < class5.field81) {
                                    class5.field81 = var5;
                                 }

                                 var23 = class5.field94[var5][var14][var20] & 255;
                                 int var24 = class5.field86[var5][var14][var20] & 255;
                                 if(var23 > 0 || var24 > 0) {
                                    int var25 = class5.field93[var5][var14][var20];
                                    int var26 = class5.field93[var5][1 + var14][var20];
                                    int var27 = class5.field93[var5][var14 + 1][var20 + 1];
                                    int var28 = class5.field93[var5][var14][1 + var20];
                                    int var29 = class5.field82[var14][var20];
                                    int var30 = class5.field82[1 + var14][var20];
                                    int var31 = class5.field82[var14 + 1][1 + var20];
                                    int var32 = class5.field82[var14][1 + var20];
                                    int var33 = -1;
                                    int var34 = -1;
                                    int var35;
                                    int var36;
                                    int var37;
                                    if(var23 > 0) {
                                       var35 = 256 * var15 / var18;
                                       var36 = var16 / var19;
                                       var37 = var17 / var19;
                                       var33 = class51.method1039(var35, var36, var37);
                                       var35 = class5.field80 + var35 & 255;
                                       var37 += class5.field83;
                                       if(var37 < 0) {
                                          var37 = 0;
                                       } else if(var37 > 255) {
                                          var37 = 255;
                                       }

                                       var34 = class51.method1039(var35, var36, var37);
                                    }

                                    class46 var38;
                                    if(var5 > 0) {
                                       boolean var62 = true;
                                       if(0 == var23 && 0 != class175.field2912[var5][var14][var20]) {
                                          var62 = false;
                                       }

                                       if(var24 > 0) {
                                          var37 = var24 - 1;
                                          var38 = (class46)class46.field1063.method3743((long)var37);
                                          class46 var63;
                                          if(null != var38) {
                                             var63 = var38;
                                          } else {
                                             byte[] var39 = class209.field3129.method3239(4, var37);
                                             var38 = new class46();
                                             if(null != var39) {
                                                var38.method937(new class119(var39), var37);
                                             }

                                             var38.method936();
                                             class46.field1063.method3745(var38, (long)var37);
                                             var63 = var38;
                                          }

                                          if(!var63.field1052) {
                                             var62 = false;
                                          }
                                       }

                                       if(var62 && var25 == var26 && var25 == var27 && var28 == var25) {
                                          class211.field3142[var5][var14][var20] |= 2340;
                                       }
                                    }

                                    var35 = 0;
                                    if(var34 != -1) {
                                       var35 = class91.field1580[class121.method2735(var34, 96)];
                                    }

                                    if(var24 == 0) {
                                       var55.method2041(var5, var14, var20, 0, 0, -1, var25, var26, var27, var28, class121.method2735(var33, var29), class121.method2735(var33, var30), class121.method2735(var33, var31), class121.method2735(var33, var32), 0, 0, 0, 0, var35, 0);
                                    } else {
                                       var36 = class175.field2912[var5][var14][var20] + 1;
                                       byte var64 = class102.field1774[var5][var14][var20];
                                       int var65 = var24 - 1;
                                       class46 var40 = (class46)class46.field1063.method3743((long)var65);
                                       if(var40 != null) {
                                          var38 = var40;
                                       } else {
                                          byte[] var41 = class209.field3129.method3239(4, var65);
                                          var40 = new class46();
                                          if(var41 != null) {
                                             var40.method937(new class119(var41), var65);
                                          }

                                          var40.method936();
                                          class46.field1063.method3745(var40, (long)var65);
                                          var38 = var40;
                                       }

                                       int var66 = var38.field1051;
                                       int var42;
                                       int var43;
                                       int var44;
                                       int var45;
                                       if(var66 >= 0) {
                                          var43 = class91.field1593.vmethod2150(var66);
                                          var42 = -1;
                                       } else if(var38.field1058 == 16711935) {
                                          var42 = -2;
                                          var66 = -1;
                                          var43 = -2;
                                       } else {
                                          var42 = class51.method1039(var38.field1054, var38.field1055, var38.field1049);
                                          var44 = var38.field1054 + class5.field80 & 255;
                                          var45 = class5.field83 + var38.field1049;
                                          if(var45 < 0) {
                                             var45 = 0;
                                          } else if(var45 > 255) {
                                             var45 = 255;
                                          }

                                          var43 = class51.method1039(var44, var38.field1055, var45);
                                       }

                                       var44 = 0;
                                       if(var43 != -2) {
                                          var44 = class91.field1580[class2.method12(var43, 96)];
                                       }

                                       if(var38.field1053 != -1) {
                                          var45 = class5.field80 + var38.field1061 & 255;
                                          int var46 = class5.field83 + var38.field1059;
                                          if(var46 < 0) {
                                             var46 = 0;
                                          } else if(var46 > 255) {
                                             var46 = 255;
                                          }

                                          var43 = class51.method1039(var45, var38.field1056, var46);
                                          var44 = class91.field1580[class2.method12(var43, 96)];
                                       }

                                       var55.method2041(var5, var14, var20, var36, var64, var66, var25, var26, var27, var28, class121.method2735(var33, var29), class121.method2735(var33, var30), class121.method2735(var33, var31), class121.method2735(var33, var32), class2.method12(var42, var29), class2.method12(var42, var30), class2.method12(var42, var31), class2.method12(var42, var32), var35, var44);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     for(var14 = 1; var14 < 103; ++var14) {
                        for(var15 = 1; var15 < 103; ++var15) {
                           if((class5.field90[var5][var15][var14] & 8) != 0) {
                              var20 = 0;
                           } else if(var5 > 0 && (class5.field90[1][var15][var14] & 2) != 0) {
                              var20 = var5 - 1;
                           } else {
                              var20 = var5;
                           }

                           var55.method1899(var5, var15, var14, var20);
                        }
                     }

                     class5.field94[var5] = (byte[][])null;
                     class5.field86[var5] = (byte[][])null;
                     class175.field2912[var5] = (byte[][])null;
                     class102.field1774[var5] = (byte[][])null;
                     class5.field84[var5] = (byte[][])null;
                  }

                  var55.method1916(-50, -10, -50);

                  for(var5 = 0; var5 < 104; ++var5) {
                     for(var53 = 0; var53 < 104; ++var53) {
                        if((class5.field90[1][var5][var53] & 2) == 2) {
                           var55.method1950(var5, var53);
                        }
                     }
                  }

                  var5 = 1;
                  var53 = 2;
                  var7 = 4;

                  for(var8 = 0; var8 < 4; ++var8) {
                     if(var8 > 0) {
                        var5 <<= 3;
                        var53 <<= 3;
                        var7 <<= 3;
                     }

                     for(var9 = 0; var9 <= var8; ++var9) {
                        for(var10 = 0; var10 <= 104; ++var10) {
                           for(var11 = 0; var11 <= 104; ++var11) {
                              short var61;
                              if((class211.field3142[var9][var11][var10] & var5) != 0) {
                                 var12 = var10;
                                 var13 = var10;
                                 var14 = var9;

                                 for(var15 = var9; var12 > 0 && 0 != (class211.field3142[var9][var11][var12 - 1] & var5); --var12) {
                                    ;
                                 }

                                 while(var13 < 104 && 0 != (class211.field3142[var9][var11][1 + var13] & var5)) {
                                    ++var13;
                                 }

                                 label804:
                                 while(var14 > 0) {
                                    for(var16 = var12; var16 <= var13; ++var16) {
                                       if((class211.field3142[var14 - 1][var11][var16] & var5) == 0) {
                                          break label804;
                                       }
                                    }

                                    --var14;
                                 }

                                 label793:
                                 while(var15 < var8) {
                                    for(var16 = var12; var16 <= var13; ++var16) {
                                       if((class211.field3142[var15 + 1][var11][var16] & var5) == 0) {
                                          break label793;
                                       }
                                    }

                                    ++var15;
                                 }

                                 var16 = (1 + var15 - var14) * (1 + (var13 - var12));
                                 if(var16 >= 8) {
                                    var61 = 240;
                                    var18 = class5.field93[var15][var11][var12] - var61;
                                    var19 = class5.field93[var14][var11][var12];
                                    class86.method1898(var8, 1, 128 * var11, 128 * var11, var12 * 128, 128 * var13 + 128, var18, var19);

                                    for(var20 = var14; var20 <= var15; ++var20) {
                                       for(var21 = var12; var21 <= var13; ++var21) {
                                          class211.field3142[var20][var11][var21] &= ~var5;
                                       }
                                    }
                                 }
                              }

                              if(0 != (class211.field3142[var9][var11][var10] & var53)) {
                                 var12 = var11;
                                 var13 = var11;
                                 var14 = var9;

                                 for(var15 = var9; var12 > 0 && 0 != (class211.field3142[var9][var12 - 1][var10] & var53); --var12) {
                                    ;
                                 }

                                 while(var13 < 104 && 0 != (class211.field3142[var9][var13 + 1][var10] & var53)) {
                                    ++var13;
                                 }

                                 label857:
                                 while(var14 > 0) {
                                    for(var16 = var12; var16 <= var13; ++var16) {
                                       if(0 == (class211.field3142[var14 - 1][var16][var10] & var53)) {
                                          break label857;
                                       }
                                    }

                                    --var14;
                                 }

                                 label846:
                                 while(var15 < var8) {
                                    for(var16 = var12; var16 <= var13; ++var16) {
                                       if(0 == (class211.field3142[var15 + 1][var16][var10] & var53)) {
                                          break label846;
                                       }
                                    }

                                    ++var15;
                                 }

                                 var16 = (var15 + 1 - var14) * (var13 - var12 + 1);
                                 if(var16 >= 8) {
                                    var61 = 240;
                                    var18 = class5.field93[var15][var12][var10] - var61;
                                    var19 = class5.field93[var14][var12][var10];
                                    class86.method1898(var8, 2, var12 * 128, 128 * var13 + 128, 128 * var10, 128 * var10, var18, var19);

                                    for(var20 = var14; var20 <= var15; ++var20) {
                                       for(var21 = var12; var21 <= var13; ++var21) {
                                          class211.field3142[var20][var21][var10] &= ~var53;
                                       }
                                    }
                                 }
                              }

                              if((class211.field3142[var9][var11][var10] & var7) != 0) {
                                 var12 = var11;
                                 var13 = var11;
                                 var14 = var10;

                                 for(var15 = var10; var14 > 0 && 0 != (class211.field3142[var9][var11][var14 - 1] & var7); --var14) {
                                    ;
                                 }

                                 while(var15 < 104 && (class211.field3142[var9][var11][1 + var15] & var7) != 0) {
                                    ++var15;
                                 }

                                 label910:
                                 while(var12 > 0) {
                                    for(var16 = var14; var16 <= var15; ++var16) {
                                       if(0 == (class211.field3142[var9][var12 - 1][var16] & var7)) {
                                          break label910;
                                       }
                                    }

                                    --var12;
                                 }

                                 label899:
                                 while(var13 < 104) {
                                    for(var16 = var14; var16 <= var15; ++var16) {
                                       if(0 == (class211.field3142[var9][1 + var13][var16] & var7)) {
                                          break label899;
                                       }
                                    }

                                    ++var13;
                                 }

                                 if((1 + (var13 - var12)) * (1 + (var15 - var14)) >= 4) {
                                    var16 = class5.field93[var9][var12][var14];
                                    class86.method1898(var8, 4, 128 * var12, 128 + var13 * 128, var14 * 128, 128 + 128 * var15, var16, var16);

                                    for(var17 = var12; var17 <= var13; ++var17) {
                                       for(var18 = var14; var18 <= var15; ++var18) {
                                          class211.field3142[var9][var17][var18] &= ~var7;
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

                  for(var53 = 0; var53 < 104; ++var53) {
                     for(var7 = 0; var7 < 104; ++var7) {
                        class12.method161(var53, var7);
                     }
                  }

                  class31.method677();

                  for(class16 var58 = (class16)field411.method3812(); var58 != null; var58 = (class16)field411.method3817()) {
                     if(-1 == var58.field230) {
                        var58.field228 = 0;
                        class148.method3114(var58);
                     } else {
                        var58.method3898();
                     }
                  }

                  class40.field927.method3750();
                  if(class85.field1464 != null) {
                     field322.method2737(203);
                     field322.method2480(1057001181);
                  }

                  if(!field471) {
                     var53 = (class110.field1945 - 6) / 8;
                     var7 = (class110.field1945 + 6) / 8;
                     var8 = (class82.field1438 - 6) / 8;
                     var9 = (6 + class82.field1438) / 8;

                     for(var10 = var53 - 1; var10 <= 1 + var7; ++var10) {
                        for(var11 = var8 - 1; var11 <= 1 + var9; ++var11) {
                           if(var10 < var53 || var10 > var7 || var11 < var8 || var11 > var9) {
                              class7.field132.method3237("m" + var10 + "_" + var11);
                              class7.field132.method3237("l" + var10 + "_" + var11);
                           }
                        }
                     }
                  }

                  class15.method188(30);
                  class31.method677();
                  class5.field94 = (byte[][][])null;
                  class5.field86 = (byte[][][])null;
                  class175.field2912 = (byte[][][])null;
                  class102.field1774 = (byte[][][])null;
                  class211.field3142 = (int[][][])null;
                  class5.field84 = (byte[][][])null;
                  class5.field82 = (int[][])null;
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
               int var5 = class114.field1975.field2228;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var6 = var4;
               if(class114.field1975.field2224 != null) {
                  var6 = (String)class114.field1975.field2224;
               }
            }

            var0 = var0.substring(0, var2) + var6 + var0.substring(4 + var2);
         }
      }

      return var0;
   }
}
