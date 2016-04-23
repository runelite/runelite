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
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
public final class client extends class144 {
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 81892227
   )
   static int field271;
   @ObfuscatedName("h")
   static client field272;
   @ObfuscatedName("m")
   static boolean field273 = true;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -431129383
   )
   @Export("world")
   static int field274 = 1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2119062387
   )
   static int field275 = 0;
   @ObfuscatedName("i")
   static class153 field276;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -747757755
   )
   static int field277;
   @ObfuscatedName("l")
   static class212 field278;
   @ObfuscatedName("u")
   static boolean field279 = false;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1725013631
   )
   static int field280;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 953263917
   )
   static int field281;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 658501095
   )
   static int field282;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -386729525
   )
   @Export("gameState")
   static int field283 = 0;
   @ObfuscatedName("g")
   static boolean field284 = true;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -269204053
   )
   @Export("gameCycle")
   static int field285 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 1267672314823176323L
   )
   static long field286 = -1L;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1541210207
   )
   static int field287;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1337583675
   )
   static int field288 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1834433745
   )
   static int field289 = -1;
   @ObfuscatedName("is")
   @Export("menuTargets")
   static String[] field290;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1268999227
   )
   static int field291;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 521298565
   )
   static int field292 = 0;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1521849115
   )
   static int field293;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1151601809
   )
   static int field294 = 0;
   @ObfuscatedName("jy")
   static class173 field295;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -294796291
   )
   static int field296 = 0;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 105348657
   )
   static int field297;
   @ObfuscatedName("ju")
   static class173 field298;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -1595194449
   )
   static int field299;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1682196197
   )
   static int field300 = 0;
   @ObfuscatedName("ah")
   static class20 field301;
   @ObfuscatedName("r")
   static boolean field303 = false;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      longValue = -4047335405049366261L
   )
   static long field304;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1331260269
   )
   static int field305;
   @ObfuscatedName("bm")
   static class168 field306;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -714080241
   )
   static int field307;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 2031157825
   )
   static int field308;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 453809891
   )
   static int field309 = 0;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1802717085
   )
   static int field310;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1474651163
   )
   static int field311;
   @ObfuscatedName("bl")
   static String field312;
   @ObfuscatedName("il")
   static String field313;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -1146556529
   )
   static int field314;
   @ObfuscatedName("lh")
   @Export("widgetPositionY")
   static int[] field315;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -144662671
   )
   static int field316;
   @ObfuscatedName("cf")
   static int[] field317;
   @ObfuscatedName("cl")
   static class122 field318;
   @ObfuscatedName("cv")
   static class122 field319;
   @ObfuscatedName("cp")
   static class122 field320;
   @ObfuscatedName("lp")
   @Export("widgetPositionX")
   static int[] field321;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1197185579
   )
   @Export("packetOpcode")
   static int field322;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1853349745
   )
   static int field323;
   @ObfuscatedName("ob")
   static short field324;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1274646311
   )
   static int field325;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -934734497
   )
   static int field326;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -787601043
   )
   static int field327;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -1331967333
   )
   static int field328;
   @ObfuscatedName("ci")
   static boolean field329;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -722916593
   )
   static int field330;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1223078835
   )
   static int field331;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -314341425
   )
   static int field332;
   @ObfuscatedName("fg")
   static boolean field333;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -49542913
   )
   static int field334;
   @ObfuscatedName("ai")
   static class20 field335;
   @ObfuscatedName("do")
   static boolean field336;
   @ObfuscatedName("dh")
   static int[][][] field337;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1466907815
   )
   static int field338;
   @ObfuscatedName("aq")
   static boolean field339 = true;
   @ObfuscatedName("ka")
   static class199 field340;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 110498139
   )
   static int field341;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -1475352437
   )
   static int field342;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 2024251503
   )
   static int field343;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -227878319
   )
   static int field344;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 2146999383
   )
   static int field345;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1253107697
   )
   @Export("mapScale")
   static int field346;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 1717032083
   )
   static int field347;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = -1634647995
   )
   static int field348;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = 1350165637
   )
   static int field349;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 419735665
   )
   static int field350;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 1885619897
   )
   static int field351;
   @ObfuscatedName("eh")
   static class78[] field352;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 1347775545
   )
   static int field353;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 764216119
   )
   static int field354;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 1416873597
   )
   static int field355;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -1912470107
   )
   static int field356;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 2018293647
   )
   static int field357;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -1260008911
   )
   static int field358;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1958829233
   )
   static int field359;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -2017578329
   )
   static int field360;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -808056489
   )
   static int field361;
   @ObfuscatedName("iq")
   static String field362;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -1524718999
   )
   static int field363;
   @ObfuscatedName("hs")
   @Export("groundItemDeque")
   static class199[][][] field364;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 2083705159
   )
   static int field365;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -1513815641
   )
   static int field366;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2026805375
   )
   static int field367 = -1;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1345895537
   )
   static int field368;
   @ObfuscatedName("oe")
   static int[] field369;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 715218599
   )
   static int field370;
   @ObfuscatedName("fc")
   static int[] field371;
   @ObfuscatedName("fv")
   static int[] field372;
   @ObfuscatedName("fd")
   static int[] field373;
   @ObfuscatedName("ff")
   static int[] field374;
   @ObfuscatedName("fl")
   static int[] field375;
   @ObfuscatedName("jc")
   static boolean field376;
   @ObfuscatedName("gp")
   static int[] field377;
   @ObfuscatedName("gd")
   static String[] field378;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -1077443817
   )
   static int field379;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      longValue = -4185821392900472995L
   )
   static long field380;
   @ObfuscatedName("fu")
   static int[] field381;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 1895457057
   )
   static int field382;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 1661862475
   )
   static int field383;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1013348427
   )
   static int field384;
   @ObfuscatedName("hu")
   static int[] field385;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -176366735
   )
   static int field386;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -810891173
   )
   static int field387;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1063481837
   )
   static int field388;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -852074875
   )
   static int field389;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1074896109
   )
   static int field390;
   @ObfuscatedName("ls")
   static boolean[] field391;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 1899508575
   )
   static int field392;
   @ObfuscatedName("gx")
   static boolean field393;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 302299945
   )
   static int field394;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 1250156653
   )
   static int field395;
   @ObfuscatedName("gm")
   @Export("cachedPlayers")
   static class2[] field396;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -2046181907
   )
   static int field397;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 1197062611
   )
   static int field398;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -1088578405
   )
   static int field399;
   @ObfuscatedName("ha")
   static int[] field400;
   @ObfuscatedName("oi")
   static short field401;
   @ObfuscatedName("hp")
   static String[] field402;
   @ObfuscatedName("hx")
   static boolean[] field403;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1527260623
   )
   static int field404 = 0;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 761250201
   )
   static int field405;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1303788541
   )
   static int field406;
   @ObfuscatedName("ht")
   static class199 field407;
   @ObfuscatedName("hv")
   static class199 field408;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 467232169
   )
   static int field409;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1754087261
   )
   static int field410;
   @ObfuscatedName("hb")
   @Export("realSkillLevels")
   static int[] field411;
   @ObfuscatedName("hf")
   @Export("skillExperiences")
   static int[] field412;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 1621822337
   )
   @Export("weight")
   static int field413;
   @ObfuscatedName("dc")
   static final int[] field414;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = 52479933
   )
   @Export("menuOptionCount")
   static int field415;
   @ObfuscatedName("mm")
   static String field416;
   @ObfuscatedName("if")
   static int[] field417;
   @ObfuscatedName("ig")
   @Export("menuTypes")
   static int[] field418;
   @ObfuscatedName("hq")
   @Export("boostedSkillLevels")
   static int[] field419;
   @ObfuscatedName("im")
   @Export("menuOptions")
   static String[] field420;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -116749767
   )
   static int field421 = 0;
   @ObfuscatedName("eo")
   static boolean field422;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1164802875
   )
   static int field423 = 0;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -1359918557
   )
   static int field424;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -552868121
   )
   static int field425;
   @ObfuscatedName("oo")
   static short field426;
   @ObfuscatedName("it")
   static String field427;
   @ObfuscatedName("of")
   @Export("friends")
   static class17[] field428;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -822916015
   )
   static int field429;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -1008186929
   )
   static int field430;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2123192431
   )
   static int field431 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1202189973
   )
   static int field432;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -1041925771
   )
   static int field433;
   @ObfuscatedName("ii")
   @Export("componentTable")
   static class196 field434;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 1081140105
   )
   static int field435;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -1404436281
   )
   static int field436;
   @ObfuscatedName("jd")
   static class173 field437;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 1304622951
   )
   @Export("energy")
   static int field438;
   @ObfuscatedName("nk")
   static int[] field439;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1702712779
   )
   static int field440;
   @ObfuscatedName("kl")
   static int[] field441;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 1554143949
   )
   static int field442;
   @ObfuscatedName("jf")
   static boolean field443;
   @ObfuscatedName("jn")
   static boolean field444;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -1140807779
   )
   static int field445;
   @ObfuscatedName("jx")
   static class173 field446;
   @ObfuscatedName("je")
   static class173 field447;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 612784465
   )
   static int field448;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -327083707
   )
   static int field449;
   @ObfuscatedName("mf")
   static int[] field450;
   @ObfuscatedName("jb")
   static boolean field451;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = 1501006445
   )
   static int field452;
   @ObfuscatedName("hi")
   @Export("isMenuOpen")
   static boolean field453;
   @ObfuscatedName("hj")
   static class199 field454;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 2119420191
   )
   static int field455;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 171528589
   )
   static int field456;
   @ObfuscatedName("jw")
   static boolean field457;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 1070240137
   )
   static int field458;
   @ObfuscatedName("ca")
   static int[] field459;
   @ObfuscatedName("nl")
   static int[] field460;
   @ObfuscatedName("kb")
   static int[] field461;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -942096441
   )
   static int field462;
   @ObfuscatedName("ko")
   static int[] field463;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -910138489
   )
   static int field464;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1689571847
   )
   static int field465;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -1544814145
   )
   static int field466;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 1630913693
   )
   static int field467;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 1138144549
   )
   static int field468;
   @ObfuscatedName("jv")
   static boolean field469;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -453331449
   )
   static int field470;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 428662053
   )
   static int field471;
   @ObfuscatedName("kw")
   static class199 field472;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 718839885
   )
   static int field473;
   @ObfuscatedName("mn")
   static int[] field474;
   @ObfuscatedName("ks")
   static class196 field475;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -432415977
   )
   static int field476;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -1716799769
   )
   static int field477;
   @ObfuscatedName("ll")
   static boolean[] field478;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1725589507
   )
   static int field479;
   @ObfuscatedName("lu")
   static boolean[] field480;
   @ObfuscatedName("lb")
   static String field481;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class108[] field482;
   @ObfuscatedName("lm")
   static int[] field483;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 1704860165
   )
   static int field484;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -1595139901
   )
   static int field485;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      longValue = -1406817896101174081L
   )
   static long field486;
   @ObfuscatedName("lg")
   @Export("isResized")
   static boolean field487;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 1135787403
   )
   static int field488;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -2106372463
   )
   static int field489;
   @ObfuscatedName("hm")
   static int[] field490;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 393713729
   )
   static int field491;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1361376481
   )
   static int field492 = 0;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      longValue = 1202201054774430947L
   )
   static long field493;
   @ObfuscatedName("ld")
   static long[] field494;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = -1914000553
   )
   static int field495;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -903298135
   )
   static int field496;
   @ObfuscatedName("mv")
   static int[] field497;
   @ObfuscatedName("md")
   static int[] field498;
   @ObfuscatedName("nf")
   static boolean field499;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -406756579
   )
   static int field500;
   @ObfuscatedName("mp")
   static String field501;
   @ObfuscatedName("ir")
   @Export("menuIdentifiers")
   static int[] field502;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 2039677219
   )
   static int field503;
   @ObfuscatedName("oc")
   static short field504;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -1899882135
   )
   @Export("camera2")
   static int field505;
   @ObfuscatedName("ml")
   static class78[] field506;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 1203620255
   )
   static int field507;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = -458952579
   )
   static int field508;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = -629495885
   )
   static int field509;
   @ObfuscatedName("hk")
   static final int[] field510;
   @ObfuscatedName("ip")
   static boolean field511;
   @ObfuscatedName("ma")
   static boolean field512;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 349154109
   )
   static int field513;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -1853699763
   )
   static int field514;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -1019100167
   )
   static int field515;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -407973915
   )
   static int field516;
   @ObfuscatedName("cn")
   @Export("cachedNPCs")
   static class34[] field517;
   @ObfuscatedName("nu")
   static int[] field518;
   @ObfuscatedName("ng")
   static int[] field519;
   @ObfuscatedName("gh")
   static int[][] field520;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -1998323893
   )
   @Export("mapAngle")
   static int field521;
   @ObfuscatedName("ox")
   static boolean[] field522;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -2076047995
   )
   static int field523;
   @ObfuscatedName("od")
   static int[] field524;
   @ObfuscatedName("ou")
   static int[] field525;
   @ObfuscatedName("oh")
   static int[] field526;
   @ObfuscatedName("om")
   static short field527;
   @ObfuscatedName("op")
   static short field528;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -511870437
   )
   static int field529 = 0;
   @ObfuscatedName("os")
   static short field530;
   @ObfuscatedName("ab")
   static boolean field531 = false;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 306136505
   )
   static int field532;
   @ObfuscatedName("og")
   static short field533;
   @ObfuscatedName("oz")
   static class195 field534;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -1706264467
   )
   static int field535;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 1749104731
   )
   static int field536;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1674060739
   )
   static int field537;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -848550309
   )
   @Export("camera3")
   static int field538;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 621606709
   )
   @Export("scale")
   static int field539;
   @ObfuscatedName("lv")
   static int[] field540;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1988292557
   )
   static int field541;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 217281667
   )
   static int field542;
   @ObfuscatedName("nz")
   static class58[] field543;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 40706855
   )
   static int field544;
   @ObfuscatedName("ol")
   @Export("ignores")
   static class7[] field545;
   @ObfuscatedName("pp")
   static class179 field546;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = 333659285
   )
   static int field547;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 1688855155
   )
   static int field548;
   @ObfuscatedName("pb")
   @Export("grandExchangeOffers")
   static class220[] field549;
   @ObfuscatedName("kc")
   static class199 field550;
   @ObfuscatedName("ln")
   static int[] field551;
   @ObfuscatedName("pf")
   static final class10 field552;
   @ObfuscatedName("pj")
   static int[] field553;
   @ObfuscatedName("pd")
   static int[] field554;
   @ObfuscatedName("eq")
   static class78[] field555;
   @ObfuscatedName("pn")
   static class221 field556;
   @ObfuscatedName("n")
   static byte[][] field557;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   protected final void vmethod3001() {
   }

   public final void init() {
      if(this.method2986()) {
         class190[] var1 = new class190[]{class190.field3073, class190.field3076, class190.field3065, class190.field3070, class190.field3071, class190.field3074, class190.field3068, class190.field3072, class190.field3067, class190.field3063, class190.field3062, class190.field3064, class190.field3066, class190.field3075, class190.field3069};
         class190[] var2 = var1;

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class190 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3077);
            if(null != var5) {
               switch(Integer.parseInt(var4.field3077)) {
               case 1:
                  class14.field201 = var5;
                  break;
               case 2:
                  field274 = Integer.parseInt(var5);
                  break;
               case 3:
                  field292 = Integer.parseInt(var5);
                  break;
               case 4:
                  field431 = Integer.parseInt(var5);
                  break;
               case 5:
                  class14.field207 = Integer.parseInt(var5);
                  break;
               case 6:
                  field492 = Integer.parseInt(var5);
                  break;
               case 7:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 8:
                  field282 = Integer.parseInt(var5);
                  break;
               case 9:
                  int var7 = Integer.parseInt(var5);
                  class153[] var8 = class95.method2187();
                  int var9 = 0;

                  class153 var6;
                  while(true) {
                     if(var9 >= var8.length) {
                        var6 = null;
                        break;
                     }

                     class153 var10 = var8[var9];
                     if(var10.field2262 == var7) {
                        var6 = var10;
                        break;
                     }

                     ++var9;
                  }

                  field276 = var6;
                  break;
               case 10:
                  if(var5.equalsIgnoreCase("true")) {
                     field279 = true;
                  } else {
                     field279 = false;
                  }
               case 11:
               default:
                  break;
               case 12:
                  class185.field3005 = var5;
                  break;
               case 13:
                  class75.field1360 = (class154)class104.method2282(class139.method2910(), Integer.parseInt(var5));
                  if(class154.field2272 == class75.field1360) {
                     field278 = class212.field3146;
                  } else {
                     field278 = class212.field3151;
                  }
               }
            }
         }

         class86.field1478 = false;
         field303 = false;
         field312 = this.getCodeBase().getHost();
         String var15 = field276.field2257;
         byte var16 = 0;

         try {
            class10.field166 = 16;
            class149.field2219 = var16;

            try {
               class30.field693 = System.getProperty("os.name");
            } catch (Exception var13) {
               class30.field693 = "Unknown";
            }

            class11.field176 = class30.field693.toLowerCase();

            try {
               class89.field1529 = System.getProperty("user.home");
               if(class89.field1529 != null) {
                  class89.field1529 = class89.field1529 + "/";
               }
            } catch (Exception var12) {
               ;
            }

            try {
               if(class11.field176.startsWith("win")) {
                  if(null == class89.field1529) {
                     class89.field1529 = System.getenv("USERPROFILE");
                  }
               } else if(null == class89.field1529) {
                  class89.field1529 = System.getenv("HOME");
               }

               if(class89.field1529 != null) {
                  class89.field1529 = class89.field1529 + "/";
               }
            } catch (Exception var11) {
               ;
            }

            if(null == class89.field1529) {
               class89.field1529 = "~/";
            }

            class19.field268 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class89.field1529, "/tmp/", ""};
            class124.field2007 = new String[]{".jagex_cache_" + class149.field2219, ".file_store_" + class149.field2219};

            label123:
            for(var3 = 0; var3 < 4; ++var3) {
               class149.field2213 = class190.method3699("oldschool", var15, var3);
               if(!class149.field2213.exists()) {
                  class149.field2213.mkdirs();
               }

               File[] var18 = class149.field2213.listFiles();
               if(var18 == null) {
                  break;
               }

               File[] var20 = var18;
               int var21 = 0;

               while(true) {
                  if(var21 >= var20.length) {
                     break label123;
                  }

                  File var22 = var20[var21];
                  if(!class134.method2840(var22, false)) {
                     break;
                  }

                  ++var21;
               }
            }

            File var17 = class149.field2213;
            class135.field2063 = var17;
            if(!class135.field2063.exists()) {
               throw new RuntimeException("");
            }

            class135.field2065 = true;
            class30.method660();
            class149.field2217 = new class228(new class227(class28.method644("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class149.field2218 = new class228(new class227(class28.method644("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class15.field221 = new class228[class10.field166];

            for(int var19 = 0; var19 < class10.field166; ++var19) {
               class15.field221[var19] = new class228(new class227(class28.method644("main_file_cache.idx" + var19), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var14) {
            class6.method102((String)null, var14);
         }

         field272 = this;
         this.method3018(765, 503, 113);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-499334333"
   )
   protected final void vmethod2995() {
      class39.field903 = 0 == field431?'ꩊ':field274 + '鱀';
      class127.field2020 = 0 == field431?443:field274 + '썐';
      class47.field1055 = class39.field903;
      class179.field2924 = class174.field2879;
      class89.field1535 = class174.field2889;
      class90.field1545 = class174.field2881;
      class35.field767 = class174.field2882;
      class134.method2838();
      Canvas var1 = class3.field66;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class137.field2089);
      var1.addFocusListener(class137.field2089);
      class28.method648(class3.field66);
      class171.field2726 = class119.method2700();
      if(null != class171.field2726) {
         class171.field2726.vmethod3078(class3.field66);
      }

      class151.field2243 = new class134(255, class149.field2217, class149.field2218, 500000);
      class227 var3 = null;
      class8 var4 = new class8();

      try {
         var3 = class106.method2367("", class75.field1360.field2273, false);
         byte[] var5 = new byte[(int)var3.method4092()];

         int var7;
         for(int var6 = 0; var6 < var5.length; var6 += var7) {
            var7 = var3.method4093(var5, var6, var5.length - var6);
            if(-1 == var7) {
               throw new IOException();
            }
         }

         var4 = new class8(new class119(var5));
      } catch (Exception var9) {
         ;
      }

      try {
         if(null != var3) {
            var3.method4088();
         }
      } catch (Exception var8) {
         ;
      }

      class4.field75 = var4;
      class129.field2026 = this.getToolkit().getSystemClipboard();
      class6.method97(this, class138.field2114);
      if(0 != field431) {
         field531 = true;
      }

      int var10 = class4.field75.field144;
      field486 = 0L;
      if(var10 >= 2) {
         field487 = true;
      } else {
         field487 = false;
      }

      class44.method933();
      if(field283 >= 25) {
         field318.method2735(98);
         class122 var11 = field318;
         int var12 = field487?2:1;
         var11.method2503(var12);
         field318.method2486(class5.field102);
         field318.method2486(class39.field901);
      }

      class144.field2183 = true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2018964743"
   )
   @Export("packetHandler")
   protected final void vmethod2996() {
      ++field285;
      this.method252();

      while(true) {
         class199 var2 = class170.field2702;
         class169 var1;
         synchronized(class170.field2702) {
            var1 = (class169)class170.field2707.method3782();
         }

         if(var1 == null) {
            int var58;
            try {
               if(class183.field2959 == 1) {
                  var58 = class183.field2958.method3560();
                  if(var58 > 0 && class183.field2958.method3599()) {
                     var58 -= class183.field2963;
                     if(var58 < 0) {
                        var58 = 0;
                     }

                     class183.field2958.method3559(var58);
                  } else {
                     class183.field2958.method3565();
                     class183.field2958.method3563();
                     if(class76.field1370 != null) {
                        class183.field2959 = 2;
                     } else {
                        class183.field2959 = 0;
                     }

                     class183.field2955 = null;
                     class3.field67 = null;
                  }
               }
            } catch (Exception var57) {
               var57.printStackTrace();
               class183.field2958.method3565();
               class183.field2959 = 0;
               class183.field2955 = null;
               class3.field67 = null;
               class76.field1370 = null;
            }

            class13.method165();
            class127.method2791();
            class109.method2417();
            if(class171.field2726 != null) {
               var58 = class171.field2726.vmethod3084();
               field537 = var58;
            }

            int var4;
            int var5;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var18;
            int var59;
            int var60;
            int var64;
            int var66;
            int var69;
            int var74;
            if(field283 == 0) {
               class114.method2434();
               class110.field1934.vmethod3090();

               for(var58 = 0; var58 < 32; ++var58) {
                  class144.field2179[var58] = 0L;
               }

               for(var58 = 0; var58 < 32; ++var58) {
                  class144.field2181[var58] = 0L;
               }

               class169.field2695 = 0;
            } else if(field283 == 5) {
               class0.method1(this);
               class114.method2434();
               class110.field1934.vmethod3090();

               for(var58 = 0; var58 < 32; ++var58) {
                  class144.field2179[var58] = 0L;
               }

               for(var58 = 0; var58 < 32; ++var58) {
                  class144.field2181[var58] = 0L;
               }

               class169.field2695 = 0;
            } else if(field283 != 10 && 11 != field283) {
               if(20 == field283) {
                  class0.method1(this);
                  class34.method724();
               } else if(25 == field283) {
                  class94.method2162(false);
                  field330 = 0;
                  boolean var62 = true;

                  for(var59 = 0; var59 < class31.field728.length; ++var59) {
                     if(class40.field904[var59] != -1 && null == class31.field728[var59]) {
                        class31.field728[var59] = class158.field2578.method3217(class40.field904[var59], 0);
                        if(class31.field728[var59] == null) {
                           var62 = false;
                           ++field330;
                        }
                     }

                     if(-1 != class50.field1083[var59] && class164.field2646[var59] == null) {
                        class164.field2646[var59] = class158.field2578.method3265(class50.field1083[var59], 0, class7.field132[var59]);
                        if(null == class164.field2646[var59]) {
                           var62 = false;
                           ++field330;
                        }
                     }
                  }

                  if(!var62) {
                     field334 = 1;
                  } else {
                     field332 = 0;
                     var62 = true;

                     for(var59 = 0; var59 < class31.field728.length; ++var59) {
                        byte[] var3 = class164.field2646[var59];
                        if(null != var3) {
                           var4 = (class98.field1638[var59] >> 8) * 64 - class187.field3014;
                           var5 = 64 * (class98.field1638[var59] & 255) - class0.field12;
                           if(field336) {
                              var4 = 10;
                              var5 = 10;
                           }

                           var62 &= class19.method243(var3, var4, var5);
                        }
                     }

                     if(!var62) {
                        field334 = 2;
                     } else {
                        if(field334 != 0) {
                           class171.method3355("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class13.method165();
                        class11.method152();
                        class13.method165();
                        class35.field771.method1905();
                        class13.method165();
                        System.gc();

                        for(var59 = 0; var59 < 4; ++var59) {
                           field482[var59].method2378();
                        }

                        for(var59 = 0; var59 < 4; ++var59) {
                           for(var60 = 0; var60 < 104; ++var60) {
                              for(var4 = 0; var4 < 104; ++var4) {
                                 class5.field84[var59][var60][var4] = 0;
                              }
                           }
                        }

                        class13.method165();
                        class5.field85 = 99;
                        class5.field100 = new byte[4][104][104];
                        class5.field87 = new byte[4][104][104];
                        class51.field1138 = new byte[4][104][104];
                        class5.field88 = new byte[4][104][104];
                        class59.field1201 = new int[4][105][105];
                        class186.field3009 = new byte[4][105][105];
                        class5.field89 = new int[105][105];
                        class4.field73 = new int[104];
                        class5.field90 = new int[104];
                        class94.field1597 = new int[104];
                        class109.field1889 = new int[104];
                        class109.field1895 = new int[104];
                        var59 = class31.field728.length;
                        class74.method1594();
                        class94.method2162(true);
                        int var17;
                        int var19;
                        int var20;
                        int var21;
                        int var22;
                        if(!field336) {
                           byte[] var6;
                           for(var60 = 0; var60 < var59; ++var60) {
                              var4 = 64 * (class98.field1638[var60] >> 8) - class187.field3014;
                              var5 = 64 * (class98.field1638[var60] & 255) - class0.field12;
                              var6 = class31.field728[var60];
                              if(null != var6) {
                                 class13.method165();
                                 class39.method769(var6, var4, var5, class156.field2294 * 8 - 48, class168.field2692 * 8 - 48, field482);
                              }
                           }

                           for(var60 = 0; var60 < var59; ++var60) {
                              var4 = 64 * (class98.field1638[var60] >> 8) - class187.field3014;
                              var5 = 64 * (class98.field1638[var60] & 255) - class0.field12;
                              var6 = class31.field728[var60];
                              if(var6 == null && class168.field2692 < 800) {
                                 class13.method165();
                                 class23.method596(var4, var5, 64, 64);
                              }
                           }

                           class94.method2162(true);

                           for(var60 = 0; var60 < var59; ++var60) {
                              byte[] var63 = class164.field2646[var60];
                              if(null != var63) {
                                 var5 = (class98.field1638[var60] >> 8) * 64 - class187.field3014;
                                 var64 = (class98.field1638[var60] & 255) * 64 - class0.field12;
                                 class13.method165();
                                 class86 var7 = class35.field771;
                                 class108[] var8 = field482;
                                 class119 var9 = new class119(var63);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var9.method2512();
                                    if(0 == var11) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var13 = var9.method2512();
                                       if(0 == var13) {
                                          break;
                                       }

                                       var12 += var13 - 1;
                                       var14 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       var17 = var9.method2500();
                                       var18 = var17 >> 2;
                                       var19 = var17 & 3;
                                       var20 = var15 + var5;
                                       var21 = var64 + var14;
                                       if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                          var22 = var16;
                                          if(2 == (class5.field84[1][var20][var21] & 2)) {
                                             var22 = var16 - 1;
                                          }

                                          class108 var23 = null;
                                          if(var22 >= 0) {
                                             var23 = var8[var22];
                                          }

                                          class144.method3076(var16, var20, var21, var10, var19, var18, var7, var23);
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        if(field336) {
                           var60 = 0;

                           label4617:
                           while(true) {
                              if(var60 >= 4) {
                                 for(var60 = 0; var60 < 13; ++var60) {
                                    for(var4 = 0; var4 < 13; ++var4) {
                                       var5 = field337[0][var60][var4];
                                       if(-1 == var5) {
                                          class23.method596(var60 * 8, var4 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 class94.method2162(true);
                                 var60 = 0;

                                 while(true) {
                                    if(var60 >= 4) {
                                       break label4617;
                                    }

                                    class13.method165();

                                    for(var4 = 0; var4 < 13; ++var4) {
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var64 = field337[var60][var4][var5];
                                          if(var64 != -1) {
                                             var66 = var64 >> 24 & 3;
                                             var69 = var64 >> 1 & 3;
                                             var74 = var64 >> 14 & 1023;
                                             var10 = var64 >> 3 & 2047;
                                             var11 = var10 / 8 + (var74 / 8 << 8);

                                             for(var12 = 0; var12 < class98.field1638.length; ++var12) {
                                                if(var11 == class98.field1638[var12] && class164.field2646[var12] != null) {
                                                   class4.method35(class164.field2646[var12], var60, var4 * 8, 8 * var5, var66, (var74 & 7) * 8, 8 * (var10 & 7), var69, class35.field771, field482);
                                                   break;
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var60;
                                 }
                              }

                              class13.method165();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var65 = false;
                                    var66 = field337[var60][var4][var5];
                                    if(var66 != -1) {
                                       var69 = var66 >> 24 & 3;
                                       var74 = var66 >> 1 & 3;
                                       var10 = var66 >> 14 & 1023;
                                       var11 = var66 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var13 = 0; var13 < class98.field1638.length; ++var13) {
                                          if(var12 == class98.field1638[var13] && class31.field728[var13] != null) {
                                             class136.method2861(class31.field728[var13], var60, 8 * var4, var5 * 8, var69, (var10 & 7) * 8, (var11 & 7) * 8, var74, field482);
                                             var65 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var65) {
                                       var69 = var60;
                                       var74 = 8 * var4;
                                       var10 = 8 * var5;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class5.field91[var69][var74 + var11][var12 + var10] = 0;
                                          }
                                       }

                                       if(var74 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.field91[var69][var74][var10 + var11] = class5.field91[var69][var74 - 1][var10 + var11];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.field91[var69][var11 + var74][var10] = class5.field91[var69][var11 + var74][var10 - 1];
                                          }
                                       }

                                       if(var74 > 0 && class5.field91[var69][var74 - 1][var10] != 0) {
                                          class5.field91[var69][var74][var10] = class5.field91[var69][var74 - 1][var10];
                                       } else if(var10 > 0 && class5.field91[var69][var74][var10 - 1] != 0) {
                                          class5.field91[var69][var74][var10] = class5.field91[var69][var74][var10 - 1];
                                       } else if(var74 > 0 && var10 > 0 && class5.field91[var69][var74 - 1][var10 - 1] != 0) {
                                          class5.field91[var69][var74][var10] = class5.field91[var69][var74 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var60;
                           }
                        }

                        class94.method2162(true);
                        class11.method152();
                        class13.method165();
                        class86 var67 = class35.field771;
                        class108[] var71 = field482;

                        for(var5 = 0; var5 < 4; ++var5) {
                           for(var64 = 0; var64 < 104; ++var64) {
                              for(var66 = 0; var66 < 104; ++var66) {
                                 if((class5.field84[var5][var64][var66] & 1) == 1) {
                                    var69 = var5;
                                    if((class5.field84[1][var64][var66] & 2) == 2) {
                                       var69 = var5 - 1;
                                    }

                                    if(var69 >= 0) {
                                       var71[var69].method2407(var64, var66);
                                    }
                                 }
                              }
                           }
                        }

                        class5.field98 += (int)(Math.random() * 5.0D) - 2;
                        if(class5.field98 < -8) {
                           class5.field98 = -8;
                        }

                        if(class5.field98 > 8) {
                           class5.field98 = 8;
                        }

                        class5.field99 += (int)(Math.random() * 5.0D) - 2;
                        if(class5.field99 < -16) {
                           class5.field99 = -16;
                        }

                        if(class5.field99 > 16) {
                           class5.field99 = 16;
                        }

                        for(var5 = 0; var5 < 4; ++var5) {
                           byte[][] var73 = class186.field3009[var5];
                           var12 = (int)Math.sqrt(5100.0D);
                           var13 = 768 * var12 >> 8;

                           int var151;
                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var16 = class5.field91[var5][1 + var15][var14] - class5.field91[var5][var15 - 1][var14];
                                 var17 = class5.field91[var5][var15][1 + var14] - class5.field91[var5][var15][var14 - 1];
                                 var18 = (int)Math.sqrt((double)(var17 * var17 + 65536 + var16 * var16));
                                 var19 = (var16 << 8) / var18;
                                 var20 = 65536 / var18;
                                 var21 = (var17 << 8) / var18;
                                 var22 = 96 + (var19 * -50 + var20 * -10 + -50 * var21) / var13;
                                 var151 = (var73[var15][var14 + 1] >> 3) + (var73[var15][var14 - 1] >> 2) + (var73[var15 + 1][var14] >> 3) + (var73[var15 - 1][var14] >> 2) + (var73[var15][var14] >> 1);
                                 class5.field89[var15][var14] = var22 - var151;
                              }
                           }

                           for(var14 = 0; var14 < 104; ++var14) {
                              class4.field73[var14] = 0;
                              class5.field90[var14] = 0;
                              class94.field1597[var14] = 0;
                              class109.field1889[var14] = 0;
                              class109.field1895[var14] = 0;
                           }

                           for(var14 = -5; var14 < 109; ++var14) {
                              for(var15 = 0; var15 < 104; ++var15) {
                                 var16 = 5 + var14;
                                 if(var16 >= 0 && var16 < 104) {
                                    var17 = class5.field100[var5][var16][var15] & 255;
                                    if(var17 > 0) {
                                       class41 var119 = class34.method719(var17 - 1);
                                       class4.field73[var15] += var119.field960;
                                       class5.field90[var15] += var119.field957;
                                       class94.field1597[var15] += var119.field962;
                                       class109.field1889[var15] += var119.field963;
                                       ++class109.field1895[var15];
                                    }
                                 }

                                 var17 = var14 - 5;
                                 if(var17 >= 0 && var17 < 104) {
                                    var18 = class5.field100[var5][var17][var15] & 255;
                                    if(var18 > 0) {
                                       class41 var128 = class34.method719(var18 - 1);
                                       class4.field73[var15] -= var128.field960;
                                       class5.field90[var15] -= var128.field957;
                                       class94.field1597[var15] -= var128.field962;
                                       class109.field1889[var15] -= var128.field963;
                                       --class109.field1895[var15];
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
                                    var21 = 5 + var20;
                                    if(var21 >= 0 && var21 < 104) {
                                       var15 += class4.field73[var21];
                                       var16 += class5.field90[var21];
                                       var17 += class94.field1597[var21];
                                       var18 += class109.field1889[var21];
                                       var19 += class109.field1895[var21];
                                    }

                                    var22 = var20 - 5;
                                    if(var22 >= 0 && var22 < 104) {
                                       var15 -= class4.field73[var22];
                                       var16 -= class5.field90[var22];
                                       var17 -= class94.field1597[var22];
                                       var18 -= class109.field1889[var22];
                                       var19 -= class109.field1895[var22];
                                    }

                                    if(var20 >= 1 && var20 < 103 && (!field303 || 0 != (class5.field84[0][var14][var20] & 2) || (class5.field84[var5][var14][var20] & 16) == 0)) {
                                       if(var5 < class5.field85) {
                                          class5.field85 = var5;
                                       }

                                       var151 = class5.field100[var5][var14][var20] & 255;
                                       int var24 = class5.field87[var5][var14][var20] & 255;
                                       if(var151 > 0 || var24 > 0) {
                                          int var25 = class5.field91[var5][var14][var20];
                                          int var26 = class5.field91[var5][var14 + 1][var20];
                                          int var27 = class5.field91[var5][var14 + 1][1 + var20];
                                          int var28 = class5.field91[var5][var14][var20 + 1];
                                          int var29 = class5.field89[var14][var20];
                                          int var30 = class5.field89[var14 + 1][var20];
                                          int var31 = class5.field89[1 + var14][1 + var20];
                                          int var32 = class5.field89[var14][1 + var20];
                                          int var33 = -1;
                                          int var34 = -1;
                                          int var35;
                                          int var36;
                                          if(var151 > 0) {
                                             var35 = var15 * 256 / var18;
                                             var36 = var16 / var19;
                                             int var37 = var17 / var19;
                                             var33 = class5.method86(var35, var36, var37);
                                             var35 = class5.field98 + var35 & 255;
                                             var37 += class5.field99;
                                             if(var37 < 0) {
                                                var37 = 0;
                                             } else if(var37 > 255) {
                                                var37 = 255;
                                             }

                                             var34 = class5.method86(var35, var36, var37);
                                          }

                                          if(var5 > 0) {
                                             boolean var164 = true;
                                             if(0 == var151 && class51.field1138[var5][var14][var20] != 0) {
                                                var164 = false;
                                             }

                                             if(var24 > 0 && !class95.method2189(var24 - 1).field1034) {
                                                var164 = false;
                                             }

                                             if(var164 && var26 == var25 && var25 == var27 && var25 == var28) {
                                                class59.field1201[var5][var14][var20] |= 2340;
                                             }
                                          }

                                          var35 = 0;
                                          if(var34 != -1) {
                                             var35 = class91.field1567[class13.method166(var34, 96)];
                                          }

                                          if(0 == var24) {
                                             var67.method1910(var5, var14, var20, 0, 0, -1, var25, var26, var27, var28, class13.method166(var33, var29), class13.method166(var33, var30), class13.method166(var33, var31), class13.method166(var33, var32), 0, 0, 0, 0, var35, 0);
                                          } else {
                                             var36 = 1 + class51.field1138[var5][var14][var20];
                                             byte var167 = class5.field88[var5][var14][var20];
                                             class46 var38 = class95.method2189(var24 - 1);
                                             int var39 = var38.field1033;
                                             int var40;
                                             int var41;
                                             int var42;
                                             int var43;
                                             if(var39 >= 0) {
                                                var41 = class91.field1566.vmethod2167(var39);
                                                var40 = -1;
                                             } else if(var38.field1040 == 16711935) {
                                                var40 = -2;
                                                var39 = -1;
                                                var41 = -2;
                                             } else {
                                                var40 = class5.method86(var38.field1036, var38.field1030, var38.field1044);
                                                var42 = class5.field98 + var38.field1036 & 255;
                                                var43 = class5.field99 + var38.field1044;
                                                if(var43 < 0) {
                                                   var43 = 0;
                                                } else if(var43 > 255) {
                                                   var43 = 255;
                                                }

                                                var41 = class5.method86(var42, var38.field1030, var43);
                                             }

                                             var42 = 0;
                                             if(-2 != var41) {
                                                var42 = class91.field1567[class167.method3280(var41, 96)];
                                             }

                                             if(var38.field1035 != -1) {
                                                var43 = var38.field1038 + class5.field98 & 255;
                                                int var44 = var38.field1032 + class5.field99;
                                                if(var44 < 0) {
                                                   var44 = 0;
                                                } else if(var44 > 255) {
                                                   var44 = 255;
                                                }

                                                var41 = class5.method86(var43, var38.field1041, var44);
                                                var42 = class91.field1567[class167.method3280(var41, 96)];
                                             }

                                             var67.method1910(var5, var14, var20, var36, var167, var39, var25, var26, var27, var28, class13.method166(var33, var29), class13.method166(var33, var30), class13.method166(var33, var31), class13.method166(var33, var32), class167.method3280(var40, var29), class167.method3280(var40, var30), class167.method3280(var40, var31), class167.method3280(var40, var32), var35, var42);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 if((class5.field84[var5][var15][var14] & 8) != 0) {
                                    var20 = 0;
                                 } else if(var5 > 0 && 0 != (class5.field84[1][var15][var14] & 2)) {
                                    var20 = var5 - 1;
                                 } else {
                                    var20 = var5;
                                 }

                                 var67.method2000(var5, var15, var14, var20);
                              }
                           }

                           class5.field100[var5] = (byte[][])null;
                           class5.field87[var5] = (byte[][])null;
                           class51.field1138[var5] = (byte[][])null;
                           class5.field88[var5] = (byte[][])null;
                           class186.field3009[var5] = (byte[][])null;
                        }

                        var67.method1936(-50, -10, -50);

                        for(var5 = 0; var5 < 104; ++var5) {
                           for(var64 = 0; var64 < 104; ++var64) {
                              if((class5.field84[1][var5][var64] & 2) == 2) {
                                 var67.method1941(var5, var64);
                              }
                           }
                        }

                        var5 = 1;
                        var64 = 2;
                        var66 = 4;

                        for(var69 = 0; var69 < 4; ++var69) {
                           if(var69 > 0) {
                              var5 <<= 3;
                              var64 <<= 3;
                              var66 <<= 3;
                           }

                           for(var74 = 0; var74 <= var69; ++var74) {
                              for(var10 = 0; var10 <= 104; ++var10) {
                                 for(var11 = 0; var11 <= 104; ++var11) {
                                    short var132;
                                    if((class59.field1201[var74][var11][var10] & var5) != 0) {
                                       var12 = var10;
                                       var13 = var10;
                                       var14 = var74;

                                       for(var15 = var74; var12 > 0 && (class59.field1201[var74][var11][var12 - 1] & var5) != 0; --var12) {
                                          ;
                                       }

                                       while(var13 < 104 && (class59.field1201[var74][var11][1 + var13] & var5) != 0) {
                                          ++var13;
                                       }

                                       label4268:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if(0 == (class59.field1201[var14 - 1][var11][var16] & var5)) {
                                                break label4268;
                                             }
                                          }

                                          --var14;
                                       }

                                       label4257:
                                       while(var15 < var69) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if(0 == (class59.field1201[1 + var15][var11][var16] & var5)) {
                                                break label4257;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var15 + 1 - var14) * (1 + (var13 - var12));
                                       if(var16 >= 8) {
                                          var132 = 240;
                                          var18 = class5.field91[var15][var11][var12] - var132;
                                          var19 = class5.field91[var14][var11][var12];
                                          class86.method1908(var69, 1, 128 * var11, var11 * 128, var12 * 128, 128 + 128 * var13, var18, var19);

                                          for(var20 = var14; var20 <= var15; ++var20) {
                                             for(var21 = var12; var21 <= var13; ++var21) {
                                                class59.field1201[var20][var11][var21] &= ~var5;
                                             }
                                          }
                                       }
                                    }

                                    if(0 != (class59.field1201[var74][var11][var10] & var64)) {
                                       var12 = var11;
                                       var13 = var11;
                                       var14 = var74;

                                       for(var15 = var74; var12 > 0 && (class59.field1201[var74][var12 - 1][var10] & var64) != 0; --var12) {
                                          ;
                                       }

                                       while(var13 < 104 && (class59.field1201[var74][var13 + 1][var10] & var64) != 0) {
                                          ++var13;
                                       }

                                       label4321:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if(0 == (class59.field1201[var14 - 1][var16][var10] & var64)) {
                                                break label4321;
                                             }
                                          }

                                          --var14;
                                       }

                                       label4310:
                                       while(var15 < var69) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class59.field1201[var15 + 1][var16][var10] & var64) == 0) {
                                                break label4310;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var15 + 1 - var14) * (1 + (var13 - var12));
                                       if(var16 >= 8) {
                                          var132 = 240;
                                          var18 = class5.field91[var15][var12][var10] - var132;
                                          var19 = class5.field91[var14][var12][var10];
                                          class86.method1908(var69, 2, var12 * 128, 128 * var13 + 128, 128 * var10, var10 * 128, var18, var19);

                                          for(var20 = var14; var20 <= var15; ++var20) {
                                             for(var21 = var12; var21 <= var13; ++var21) {
                                                class59.field1201[var20][var21][var10] &= ~var64;
                                             }
                                          }
                                       }
                                    }

                                    if((class59.field1201[var74][var11][var10] & var66) != 0) {
                                       var12 = var11;
                                       var13 = var11;
                                       var14 = var10;

                                       for(var15 = var10; var14 > 0 && (class59.field1201[var74][var11][var14 - 1] & var66) != 0; --var14) {
                                          ;
                                       }

                                       while(var15 < 104 && 0 != (class59.field1201[var74][var11][var15 + 1] & var66)) {
                                          ++var15;
                                       }

                                       label4374:
                                       while(var12 > 0) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if(0 == (class59.field1201[var74][var12 - 1][var16] & var66)) {
                                                break label4374;
                                             }
                                          }

                                          --var12;
                                       }

                                       label4363:
                                       while(var13 < 104) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if(0 == (class59.field1201[var74][1 + var13][var16] & var66)) {
                                                break label4363;
                                             }
                                          }

                                          ++var13;
                                       }

                                       if((1 + (var13 - var12)) * (var15 - var14 + 1) >= 4) {
                                          var16 = class5.field91[var74][var12][var14];
                                          class86.method1908(var69, 4, var12 * 128, 128 + var13 * 128, var14 * 128, 128 + 128 * var15, var16, var16);

                                          for(var17 = var12; var17 <= var13; ++var17) {
                                             for(var18 = var14; var18 <= var15; ++var18) {
                                                class59.field1201[var74][var17][var18] &= ~var66;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        class94.method2162(true);
                        var5 = class5.field85;
                        if(var5 > class28.field655) {
                           var5 = class28.field655;
                        }

                        if(var5 < class28.field655 - 1) {
                           var5 = class28.field655 - 1;
                        }

                        if(field303) {
                           class35.field771.method1985(class5.field85);
                        } else {
                           class35.field771.method1985(0);
                        }

                        for(var64 = 0; var64 < 104; ++var64) {
                           for(var66 = 0; var66 < 104; ++var66) {
                              class11.method156(var64, var66);
                           }
                        }

                        class13.method165();
                        class141.method2950();
                        class40.field908.method3707();
                        if(null != class4.field82) {
                           field318.method2735(39);
                           field318.method2488(1057001181);
                        }

                        if(!field336) {
                           var64 = (class156.field2294 - 6) / 8;
                           var66 = (6 + class156.field2294) / 8;
                           var69 = (class168.field2692 - 6) / 8;
                           var74 = (6 + class168.field2692) / 8;

                           for(var10 = var64 - 1; var10 <= 1 + var66; ++var10) {
                              for(var11 = var69 - 1; var11 <= 1 + var74; ++var11) {
                                 if(var10 < var64 || var10 > var66 || var11 < var69 || var11 > var74) {
                                    class158.field2578.method3237("m" + var10 + "_" + var11);
                                    class158.field2578.method3237("l" + var10 + "_" + var11);
                                 }
                              }
                           }
                        }

                        class13.method162(30);
                        class13.method165();
                        class27.method630();
                        field318.method2735(123);
                        class110.field1934.vmethod3090();

                        for(var64 = 0; var64 < 32; ++var64) {
                           class144.field2179[var64] = 0L;
                        }

                        for(var64 = 0; var64 < 32; ++var64) {
                           class144.field2181[var64] = 0L;
                        }

                        class169.field2695 = 0;
                     }
                  }
               }
            } else {
               class0.method1(this);
            }

            if(30 == field283) {
               if(field404 > 1) {
                  --field404;
               }

               if(field305 > 0) {
                  --field305;
               }

               if(field329) {
                  field329 = false;
                  if(field305 > 0) {
                     class21.method579();
                  } else {
                     class13.method162(40);
                     class18.field257 = class99.field1660;
                     class99.field1660 = null;
                  }
               } else {
                  if(!field453) {
                     field420[0] = "Cancel";
                     field290[0] = "";
                     field418[0] = 1006;
                     field415 = 1;
                  }

                  String var89;
                  boolean var91;
                  class173 var103;
                  long var115;
                  boolean var118;
                  class173 var121;
                  class173 var153;
                  String var161;
                  for(var58 = 0; var58 < 100; ++var58) {
                     boolean var61;
                     if(class99.field1660 == null) {
                        var61 = false;
                     } else {
                        label4963: {
                           String var72;
                           try {
                              var60 = class99.field1660.method2972();
                              if(var60 == 0) {
                                 var61 = false;
                                 break label4963;
                              }

                              if(-1 == field322) {
                                 class99.field1660.method2966(field320.field1973, 0, 1);
                                 field320.field1971 = 0;
                                 field322 = field320.method2741();
                                 field523 = class188.field3055[field322];
                                 --var60;
                              }

                              if(-1 == field523) {
                                 if(var60 <= 0) {
                                    var61 = false;
                                    break label4963;
                                 }

                                 class99.field1660.method2966(field320.field1973, 0, 1);
                                 field523 = field320.field1973[0] & 255;
                                 --var60;
                              }

                              if(field523 == -2) {
                                 if(var60 <= 1) {
                                    var61 = false;
                                    break label4963;
                                 }

                                 class99.field1660.method2966(field320.field1973, 0, 2);
                                 field320.field1971 = 0;
                                 field523 = field320.method2502();
                                 var60 -= 2;
                              }

                              if(var60 < field523) {
                                 var61 = false;
                                 break label4963;
                              }

                              field320.field1971 = 0;
                              class99.field1660.method2966(field320.field1973, 0, field523);
                              field323 = 0;
                              field281 = field326;
                              field326 = field325 * -1;
                              field325 = field322 * -1;
                              if(209 == field322) {
                                 field404 = field320.method2534() * 30;
                                 field470 = field458;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(33 == field322) {
                                 class187.method3698(false);
                                 field320.method2741();
                                 var4 = field320.method2502();
                                 class49.method1002(field320, var4);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(12 == field322) {
                                 for(var4 = 0; var4 < field396.length; ++var4) {
                                    if(null != field396[var4]) {
                                       field396[var4].field825 = -1;
                                    }
                                 }

                                 for(var4 = 0; var4 < field517.length; ++var4) {
                                    if(null != field517[var4]) {
                                       field517[var4].field825 = -1;
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              boolean var84;
                              boolean var110;
                              boolean var124;
                              boolean var156;
                              if(213 == field322) {
                                 while(field320.field1971 < field523) {
                                    var156 = field320.method2500() == 1;
                                    var161 = field320.method2508();
                                    var89 = field320.method2508();
                                    var66 = field320.method2502();
                                    var69 = field320.method2500();
                                    var74 = field320.method2500();
                                    boolean var127 = 0 != (var74 & 2);
                                    var110 = (var74 & 1) != 0;
                                    if(var66 > 0) {
                                       field320.method2508();
                                       field320.method2500();
                                       field320.method2505();
                                    }

                                    field320.method2508();

                                    for(var12 = 0; var12 < field348; ++var12) {
                                       class17 var117 = field428[var12];
                                       if(!var156) {
                                          if(var161.equals(var117.field239)) {
                                             if(var66 != var117.field237) {
                                                var124 = true;

                                                for(class38 var146 = (class38)field534.method3731(); null != var146; var146 = (class38)field534.method3733()) {
                                                   if(var146.field857.equals(var161)) {
                                                      if(var66 != 0 && var146.field859 == 0) {
                                                         var146.method3880();
                                                         var124 = false;
                                                      } else if(0 == var66 && var146.field859 != 0) {
                                                         var146.method3880();
                                                         var124 = false;
                                                      }
                                                   }
                                                }

                                                if(var124) {
                                                   field534.method3739(new class38(var161, var66));
                                                }

                                                var117.field237 = var66;
                                             }

                                             var117.field238 = var89;
                                             var117.field240 = var69;
                                             var117.field241 = var127;
                                             var117.field242 = var110;
                                             var161 = null;
                                             break;
                                          }
                                       } else if(var89.equals(var117.field239)) {
                                          var117.field239 = var161;
                                          var117.field238 = var89;
                                          var161 = null;
                                          break;
                                       }
                                    }

                                    if(null != var161 && field348 < 400) {
                                       class17 var130 = new class17();
                                       field428[field348] = var130;
                                       var130.field239 = var161;
                                       var130.field238 = var89;
                                       var130.field237 = var66;
                                       var130.field240 = var69;
                                       var130.field241 = var127;
                                       var130.field242 = var110;
                                       ++field348;
                                    }
                                 }

                                 field271 = 2;
                                 field466 = field458;
                                 var156 = false;
                                 var5 = field348;

                                 while(var5 > 0) {
                                    var156 = true;
                                    --var5;

                                    for(var64 = 0; var64 < var5; ++var64) {
                                       var84 = false;
                                       class17 var143 = field428[var64];
                                       class17 var122 = field428[var64 + 1];
                                       if(field274 != var143.field237 && field274 == var122.field237) {
                                          var84 = true;
                                       }

                                       if(!var84 && 0 == var143.field237 && 0 != var122.field237) {
                                          var84 = true;
                                       }

                                       if(!var84 && !var143.field241 && var122.field241) {
                                          var84 = true;
                                       }

                                       if(!var84 && !var143.field242 && var122.field242) {
                                          var84 = true;
                                       }

                                       if(var84) {
                                          class17 var129 = field428[var64];
                                          field428[var64] = field428[var64 + 1];
                                          field428[var64 + 1] = var129;
                                          var156 = false;
                                       }
                                    }

                                    if(var156) {
                                       break;
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(189 == field322) {
                                 var5 = field320.method2500();
                                 class130[] var159 = class141.method2958();
                                 var66 = 0;

                                 class130 var160;
                                 while(true) {
                                    if(var66 >= var159.length) {
                                       var160 = null;
                                       break;
                                    }

                                    class130 var141 = var159[var66];
                                    if(var5 == var141.field2038) {
                                       var160 = var141;
                                       break;
                                    }

                                    ++var66;
                                 }

                                 class27.field653 = var160;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(23 == field322) {
                                 class18.method196();
                                 var4 = field320.method2505();
                                 var5 = field320.method2500();
                                 var64 = field320.method2527();
                                 field412[var64] = var4;
                                 field419[var64] = var5;
                                 field411[var64] = 1;

                                 for(var66 = 0; var66 < 98; ++var66) {
                                    if(var4 >= class155.field2279[var66]) {
                                       field411[var64] = var66 + 2;
                                    }
                                 }

                                 field463[++field496 - 1 & 31] = var64;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 163) {
                                 var4 = field320.method2526();
                                 var5 = field320.method2527();
                                 var89 = field320.method2508();
                                 if(var4 >= 1 && var4 <= 8) {
                                    if(var89.equalsIgnoreCase("null")) {
                                       var89 = null;
                                    }

                                    field402[var4 - 1] = var89;
                                    field403[var4 - 1] = var5 == 0;
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(247 == field322) {
                                 field499 = true;
                                 class28.field656 = field320.method2500();
                                 class176.field2905 = field320.method2500();
                                 class76.field1369 = field320.method2502();
                                 class148.field2203 = field320.method2500();
                                 class41.field966 = field320.method2500();
                                 if(class41.field966 >= 100) {
                                    class122.field1991 = 64 + class28.field656 * 128;
                                    class24.field603 = 64 + class176.field2905 * 128;
                                    class115.field1952 = class148.method3106(class122.field1991, class24.field603, class28.field655) - class76.field1369;
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(185 == field322) {
                                 field499 = true;
                                 class2.field62 = field320.method2500();
                                 class93.field1580 = field320.method2500();
                                 class129.field2030 = field320.method2502();
                                 class50.field1080 = field320.method2500();
                                 class175.field2896 = field320.method2500();
                                 if(class175.field2896 >= 100) {
                                    var4 = 64 + class2.field62 * 128;
                                    var5 = 64 + class93.field1580 * 128;
                                    var64 = class148.method3106(var4, var5, class28.field655) - class129.field2030;
                                    var66 = var4 - class122.field1991;
                                    var69 = var64 - class115.field1952;
                                    var74 = var5 - class24.field603;
                                    var10 = (int)Math.sqrt((double)(var66 * var66 + var74 * var74));
                                    class154.field2276 = (int)(Math.atan2((double)var69, (double)var10) * 325.949D) & 2047;
                                    class17.field243 = (int)(Math.atan2((double)var66, (double)var74) * -325.949D) & 2047;
                                    if(class154.field2276 < 128) {
                                       class154.field2276 = 128;
                                    }

                                    if(class154.field2276 > 383) {
                                       class154.field2276 = 383;
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              class173 var93;
                              class3 var105;
                              if(field322 == 202) {
                                 var4 = field320.method2544();
                                 var5 = field320.method2545();
                                 class3 var157 = (class3)field434.method3742((long)var4);
                                 var105 = (class3)field434.method3742((long)var5);
                                 if(null != var105) {
                                    class130.method2798(var105, null == var157 || var105.field65 != var157.field65);
                                 }

                                 if(var157 != null) {
                                    var157.method3883();
                                    field434.method3743(var157, (long)var5);
                                 }

                                 var93 = class141.method2959(var4);
                                 if(null != var93) {
                                    class2.method28(var93);
                                 }

                                 var93 = class141.method2959(var5);
                                 if(var93 != null) {
                                    class2.method28(var93);
                                    class116.method2448(class173.field2735[var93.field2774 >>> 16], var93, true);
                                 }

                                 if(-1 != field433) {
                                    var74 = field433;
                                    if(class107.method2374(var74)) {
                                       class4.method38(class173.field2735[var74], 1);
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 8) {
                                 class49.method1002(field320, field523);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              class173 var101;
                              if(230 == field322) {
                                 var4 = field320.method2543();
                                 var91 = field320.method2527() == 1;
                                 var101 = class141.method2959(var4);
                                 if(var101.field2759 != var91) {
                                    var101.field2759 = var91;
                                    class2.method28(var101);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              String var77;
                              if(field322 == 77) {
                                 var72 = field320.method2508();
                                 class185.field3005 = var72;

                                 try {
                                    var161 = field272.getParameter(class190.field3063.field3077);
                                    var89 = field272.getParameter(class190.field3065.field3077);
                                    var77 = var161 + "settings=" + var72 + "; version=1; path=/; domain=" + var89;
                                    if(var72.length() == 0) {
                                       var77 = var77 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                                    } else {
                                       var77 = var77 + "; Expires=" + class36.method738(class77.method1674() + 94608000000L) + "; Max-Age=" + 94608000L;
                                    }

                                    class132.method2814(field272, "document.cookie=\"" + var77 + "\"");
                                 } catch (Throwable var50) {
                                    ;
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 156) {
                                 var4 = field320.method2505();
                                 var153 = class141.method2959(var4);
                                 var153.field2787 = 3;
                                 var153.field2776 = class47.field1053.field36.method3446();
                                 class2.method28(var153);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(26 == field322) {
                                 var4 = field320.method2544();
                                 var5 = field320.method2535();
                                 if(var5 == '\uffff') {
                                    var5 = -1;
                                 }

                                 var64 = field320.method2505();
                                 var121 = class141.method2959(var4);
                                 class51 var131;
                                 if(!var121.field2768) {
                                    if(var5 == -1) {
                                       var121.field2787 = 0;
                                       field322 = -1;
                                       var61 = true;
                                       break label4963;
                                    }

                                    var131 = class89.method2081(var5);
                                    var121.field2787 = 4;
                                    var121.field2776 = var5;
                                    var121.field2795 = var131.field1101;
                                    var121.field2832 = var131.field1084;
                                    var121.field2743 = var131.field1100 * 100 / var64;
                                    class2.method28(var121);
                                 } else {
                                    var121.field2773 = var5;
                                    var121.field2738 = var64;
                                    var131 = class89.method2081(var5);
                                    var121.field2795 = var131.field1101;
                                    var121.field2832 = var131.field1084;
                                    var121.field2797 = var131.field1103;
                                    var121.field2793 = var131.field1104;
                                    var121.field2801 = var131.field1096;
                                    var121.field2743 = var131.field1100;
                                    if(1 == var131.field1106) {
                                       var121.field2802 = 1;
                                    } else {
                                       var121.field2802 = 2;
                                    }

                                    if(var121.field2799 > 0) {
                                       var121.field2743 = var121.field2743 * 32 / var121.field2799;
                                    } else if(var121.field2755 > 0) {
                                       var121.field2743 = var121.field2743 * 32 / var121.field2755;
                                    }

                                    class2.method28(var121);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              long var90;
                              long var114;
                              if(133 == field322) {
                                 var72 = field320.method2508();
                                 var115 = (long)field320.method2502();
                                 var90 = (long)field320.method2662();
                                 class152 var109 = (class152)class104.method2282(class168.method3331(), field320.method2500());
                                 var114 = (var115 << 32) + var90;
                                 boolean var113 = false;

                                 for(var13 = 0; var13 < 100; ++var13) {
                                    if(field494[var13] == var114) {
                                       var113 = true;
                                       break;
                                    }
                                 }

                                 if(class18.method200(var72)) {
                                    var113 = true;
                                 }

                                 if(!var113 && field395 == 0) {
                                    field494[field495] = var114;
                                    field495 = (field495 + 1) % 100;
                                    class122 var136 = field320;

                                    String var142;
                                    try {
                                       var16 = var136.method2512();
                                       if(var16 > 32767) {
                                          var16 = 32767;
                                       }

                                       byte[] var145 = new byte[var16];
                                       var136.field1971 += class163.field2644.method2425(var136.field1973, var136.field1971, var145, 0, var16);
                                       String var148 = class139.method2912(var145, 0, var16);
                                       var142 = var148;
                                    } catch (Exception var49) {
                                       var142 = "Cabbage";
                                    }

                                    var142 = class223.method4005(method555(var142));
                                    byte var154;
                                    if(var109.field2252) {
                                       var154 = 7;
                                    } else {
                                       var154 = 3;
                                    }

                                    if(-1 != var109.field2251) {
                                       class8.method109(var154, class7.method106(var109.field2251) + var72, var142);
                                    } else {
                                       class8.method109(var154, var72, var142);
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 21) {
                                 var156 = field320.method2500() == 1;
                                 if(var156) {
                                    class149.field2223 = class77.method1674() - field320.method2506();
                                    field556 = new class221(field320, true);
                                 } else {
                                    field556 = null;
                                 }

                                 field484 = field458;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 138 || 206 == field322 || field322 == 109 || 169 == field322 || field322 == 56 || 165 == field322 || 32 == field322 || 105 == field322 || 174 == field322 || 212 == field322) {
                                 class30.method661();
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(104 == field322) {
                                 for(var4 = 0; var4 < class52.field1142; ++var4) {
                                    class52 var158 = class176.method3415(var4);
                                    if(null != var158) {
                                       class176.field2901[var4] = 0;
                                       class176.field2900[var4] = 0;
                                    }
                                 }

                                 class18.method196();
                                 field445 += 32;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(88 == field322) {
                                 var4 = field320.method2505();
                                 var5 = field320.method2502();
                                 if(var4 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var4 >= 0) {
                                    var101 = class141.method2959(var4);
                                 } else {
                                    var101 = null;
                                 }

                                 for(; field320.field1971 < field523; class56.method1220(var5, var66, var69 - 1, var74)) {
                                    var66 = field320.method2512();
                                    var69 = field320.method2502();
                                    var74 = 0;
                                    if(0 != var69) {
                                       var74 = field320.method2500();
                                       if(var74 == 255) {
                                          var74 = field320.method2505();
                                       }
                                    }

                                    if(null != var101 && var66 >= 0 && var66 < var101.field2862.length) {
                                       var101.field2862[var66] = var69;
                                       var101.field2863[var66] = var74;
                                    }
                                 }

                                 if(null != var101) {
                                    class2.method28(var101);
                                 }

                                 class18.method196();
                                 field461[++field462 - 1 & 31] = var5 & 32767;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              long var102;
                              if(field322 == 164) {
                                 field467 = field458;
                                 if(0 == field523) {
                                    field416 = null;
                                    field501 = null;
                                    class37.field853 = 0;
                                    class123.field2005 = null;
                                    field322 = -1;
                                    var61 = true;
                                    break label4963;
                                 }

                                 field501 = field320.method2508();
                                 long var155 = field320.method2506();
                                 var90 = var155;
                                 if(var155 > 0L && var155 < 6582952005840035281L) {
                                    if(0L == var155 % 37L) {
                                       var89 = null;
                                    } else {
                                       var74 = 0;

                                       for(var114 = var155; var114 != 0L; var114 /= 37L) {
                                          ++var74;
                                       }

                                       StringBuilder var107 = new StringBuilder(var74);

                                       while(var90 != 0L) {
                                          var102 = var90;
                                          var90 /= 37L;
                                          var107.append(class162.field2642[(int)(var102 - 37L * var90)]);
                                       }

                                       var89 = var107.reverse().toString();
                                    }
                                 } else {
                                    var89 = null;
                                 }

                                 field416 = var89;
                                 class109.field1890 = field320.method2670();
                                 var74 = field320.method2500();
                                 if(var74 == 255) {
                                    field322 = -1;
                                    var61 = true;
                                    break label4963;
                                 }

                                 class37.field853 = var74;
                                 class24[] var120 = new class24[100];

                                 for(var11 = 0; var11 < class37.field853; ++var11) {
                                    var120[var11] = new class24();
                                    var120[var11].field607 = field320.method2508();
                                    var120[var11].field604 = class75.method1629(var120[var11].field607, field278);
                                    var120[var11].field605 = field320.method2502();
                                    var120[var11].field606 = field320.method2670();
                                    field320.method2508();
                                    if(var120[var11].field607.equals(class47.field1053.field58)) {
                                       class59.field1204 = var120[var11].field606;
                                    }
                                 }

                                 var110 = false;
                                 var13 = class37.field853;

                                 while(var13 > 0) {
                                    var110 = true;
                                    --var13;

                                    for(var14 = 0; var14 < var13; ++var14) {
                                       if(var120[var14].field604.compareTo(var120[var14 + 1].field604) > 0) {
                                          class24 var108 = var120[var14];
                                          var120[var14] = var120[var14 + 1];
                                          var120[var14 + 1] = var108;
                                          var110 = false;
                                       }
                                    }

                                    if(var110) {
                                       break;
                                    }
                                 }

                                 class123.field2005 = var120;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 183) {
                                 class21.method579();
                                 field322 = -1;
                                 var61 = false;
                                 break label4963;
                              }

                              if(field322 == 107) {
                                 var4 = field320.method2500();
                                 var5 = field320.method2500();
                                 var64 = field320.method2500();
                                 var66 = field320.method2500();
                                 field522[var4] = true;
                                 field369[var4] = var5;
                                 field524[var4] = var64;
                                 field525[var4] = var66;
                                 field526[var4] = 0;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 117) {
                                 class32.field737 = 0;

                                 for(var4 = 0; var4 < 2048; ++var4) {
                                    class32.field736[var4] = null;
                                    class32.field735[var4] = 1;
                                 }

                                 for(var4 = 0; var4 < 2048; ++var4) {
                                    field396[var4] = null;
                                 }

                                 class5.method41(field320);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(130 == field322) {
                                 class15.method183(true);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(168 == field322) {
                                 class15.method183(false);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(36 == field322) {
                                 class187.method3698(true);
                                 field320.method2741();
                                 var4 = field320.method2502();
                                 class49.method1002(field320, var4);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 249) {
                                 var4 = field320.method2545();
                                 var5 = field320.method2536();
                                 var101 = class141.method2959(var4);
                                 if(var101.field2787 != 2 || var101.field2776 != var5) {
                                    var101.field2787 = 2;
                                    var101.field2776 = var5;
                                    class2.method28(var101);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 218) {
                                 var4 = field320.method2505();
                                 var5 = field320.method2502();
                                 var101 = class141.method2959(var4);
                                 if(null != var101 && var101.field2820 == 0) {
                                    if(var5 > var101.field2784 - var101.field2746) {
                                       var5 = var101.field2784 - var101.field2746;
                                    }

                                    if(var5 < 0) {
                                       var5 = 0;
                                    }

                                    if(var5 != var101.field2766) {
                                       var101.field2766 = var5;
                                       class2.method28(var101);
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(237 == field322) {
                                 var72 = field320.method2508();
                                 var5 = field320.method2502();
                                 byte var149 = field320.method2670();
                                 var84 = false;
                                 if(-128 == var149) {
                                    var84 = true;
                                 }

                                 if(var84) {
                                    if(class37.field853 == 0) {
                                       field322 = -1;
                                       var61 = true;
                                       break label4963;
                                    }

                                    var118 = false;

                                    for(var69 = 0; var69 < class37.field853 && (!class123.field2005[var69].field607.equals(var72) || class123.field2005[var69].field605 != var5); ++var69) {
                                       ;
                                    }

                                    if(var69 < class37.field853) {
                                       while(var69 < class37.field853 - 1) {
                                          class123.field2005[var69] = class123.field2005[var69 + 1];
                                          ++var69;
                                       }

                                       --class37.field853;
                                       class123.field2005[class37.field853] = null;
                                    }
                                 } else {
                                    field320.method2508();
                                    class24 var116 = new class24();
                                    var116.field607 = var72;
                                    var116.field604 = class75.method1629(var116.field607, field278);
                                    var116.field605 = var5;
                                    var116.field606 = var149;

                                    for(var74 = class37.field853 - 1; var74 >= 0; --var74) {
                                       var10 = class123.field2005[var74].field604.compareTo(var116.field604);
                                       if(var10 == 0) {
                                          class123.field2005[var74].field605 = var5;
                                          class123.field2005[var74].field606 = var149;
                                          if(var72.equals(class47.field1053.field58)) {
                                             class59.field1204 = var149;
                                          }

                                          field467 = field458;
                                          field322 = -1;
                                          var61 = true;
                                          break label4963;
                                       }

                                       if(var10 < 0) {
                                          break;
                                       }
                                    }

                                    if(class37.field853 >= class123.field2005.length) {
                                       field322 = -1;
                                       var61 = true;
                                       break label4963;
                                    }

                                    for(var10 = class37.field853 - 1; var10 > var74; --var10) {
                                       class123.field2005[var10 + 1] = class123.field2005[var10];
                                    }

                                    if(class37.field853 == 0) {
                                       class123.field2005 = new class24[100];
                                    }

                                    class123.field2005[1 + var74] = var116;
                                    ++class37.field853;
                                    if(var72.equals(class47.field1053.field58)) {
                                       class59.field1204 = var149;
                                    }
                                 }

                                 field467 = field458;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 225) {
                                 field275 = field320.method2500();
                                 if(field275 == 1) {
                                    field294 = field320.method2502();
                                 }

                                 if(field275 >= 2 && field275 <= 6) {
                                    if(field275 == 2) {
                                       field529 = 64;
                                       field300 = 64;
                                    }

                                    if(3 == field275) {
                                       field529 = 0;
                                       field300 = 64;
                                    }

                                    if(4 == field275) {
                                       field529 = 128;
                                       field300 = 64;
                                    }

                                    if(5 == field275) {
                                       field529 = 64;
                                       field300 = 0;
                                    }

                                    if(field275 == 6) {
                                       field529 = 64;
                                       field300 = 128;
                                    }

                                    field275 = 2;
                                    field296 = field320.method2502();
                                    field423 = field320.method2502();
                                    field421 = field320.method2500();
                                 }

                                 if(field275 == 10) {
                                    field309 = field320.method2502();
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 9) {
                                 field491 = field320.method2500();
                                 field287 = field320.method2500();
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 233) {
                                 var4 = field320.method2536();
                                 var5 = field320.method2534();
                                 var64 = field320.method2544();
                                 var121 = class141.method2959(var64);
                                 var121.field2761 = (var4 << 16) + var5;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 149) {
                                 field499 = false;

                                 for(var4 = 0; var4 < 5; ++var4) {
                                    field522[var4] = false;
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 252) {
                                 var4 = field320.method2500();
                                 if(field320.method2500() == 0) {
                                    field549[var4] = new class220();
                                    field320.field1971 += 18;
                                 } else {
                                    --field320.field1971;
                                    field549[var4] = new class220(field320, false);
                                 }

                                 field468 = field458;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 144) {
                                 var4 = field320.method2534();
                                 class18.method198(var4);
                                 field461[++field462 - 1 & 31] = var4 & 32767;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 72) {
                                 var4 = field320.method2544();
                                 var153 = class141.method2959(var4);

                                 for(var64 = 0; var64 < var153.field2862.length; ++var64) {
                                    var153.field2862[var64] = -1;
                                    var153.field2862[var64] = 0;
                                 }

                                 class2.method28(var153);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 176) {
                                 field509 = field320.method2500();
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 49) {
                                 var4 = field320.method2538();
                                 var5 = field320.method2581();
                                 var64 = field320.method2543();
                                 var121 = class141.method2959(var64);
                                 if(var121.field2753 != var4 || var5 != var121.field2754 || var121.field2749 != 0 || 0 != var121.field2750) {
                                    var121.field2753 = var4;
                                    var121.field2754 = var5;
                                    var121.field2749 = 0;
                                    var121.field2750 = 0;
                                    class2.method28(var121);
                                    class22.method587(var121);
                                    if(0 == var121.field2820) {
                                       class116.method2448(class173.field2735[var64 >> 16], var121, false);
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(211 == field322) {
                                 var4 = field320.method2502();
                                 var5 = field320.method2544();
                                 var64 = var4 >> 10 & 31;
                                 var66 = var4 >> 5 & 31;
                                 var69 = var4 & 31;
                                 var74 = (var66 << 11) + (var64 << 19) + (var69 << 3);
                                 var103 = class141.method2959(var5);
                                 if(var74 != var103.field2790) {
                                    var103.field2790 = var74;
                                    class2.method28(var103);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 251) {
                                 var4 = field320.method2534();
                                 var5 = field320.method2544();
                                 var64 = field320.method2527();
                                 var105 = (class3)field434.method3742((long)var5);
                                 if(var105 != null) {
                                    class130.method2798(var105, var4 != var105.field65);
                                 }

                                 class56.method1219(var5, var4, var64);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(112 == field322) {
                                 class1.field30 = field320.method2527();
                                 class152.field2247 = field320.method2526();
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              long var82;
                              if(field322 == 45) {
                                 var4 = field320.method2505();
                                 var5 = field320.method2505();
                                 if(null == class156.field2283 || !class156.field2283.isValid()) {
                                    try {
                                       Iterator var138 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                                       while(var138.hasNext()) {
                                          GarbageCollectorMXBean var111 = (GarbageCollectorMXBean)var138.next();
                                          if(var111.isValid()) {
                                             class156.field2283 = var111;
                                             field493 = -1L;
                                             field304 = -1L;
                                          }
                                       }
                                    } catch (Throwable var54) {
                                       ;
                                    }
                                 }

                                 long var139 = class77.method1674();
                                 var69 = -1;
                                 if(class156.field2283 != null) {
                                    var82 = class156.field2283.getCollectionTime();
                                    if(field304 != -1L) {
                                       long var104 = var82 - field304;
                                       var102 = var139 - field493;
                                       if(var102 != 0L) {
                                          var69 = (int)(var104 * 100L / var102);
                                       }
                                    }

                                    field304 = var82;
                                    field493 = var139;
                                 }

                                 field318.method2735(121);
                                 field318.method2597(class144.field2184);
                                 field318.method2503(var69);
                                 field318.method2541(var4);
                                 field318.method2540(var5);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 30) {
                                 var72 = field320.method2508();
                                 Object[] var147 = new Object[var72.length() + 1];

                                 for(var64 = var72.length() - 1; var64 >= 0; --var64) {
                                    if(var72.charAt(var64) == 115) {
                                       var147[var64 + 1] = field320.method2508();
                                    } else {
                                       var147[1 + var64] = new Integer(field320.method2505());
                                    }
                                 }

                                 var147[0] = new Integer(field320.method2505());
                                 class0 var133 = new class0();
                                 var133.field16 = var147;
                                 class37.method749(var133);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              long var106;
                              if(195 == field322) {
                                 var4 = field320.field1971 + field523;
                                 var5 = field320.method2502();
                                 var64 = field320.method2502();
                                 if(var5 != field433) {
                                    field433 = var5;
                                    class72.method1569(false);
                                    class211.method3905(field433);
                                    class95.method2181(field433);

                                    for(var66 = 0; var66 < 100; ++var66) {
                                       field478[var66] = true;
                                    }
                                 }

                                 class3 var95;
                                 for(; var64-- > 0; var95.field63 = true) {
                                    var66 = field320.method2505();
                                    var69 = field320.method2502();
                                    var74 = field320.method2500();
                                    var95 = (class3)field434.method3742((long)var66);
                                    if(var95 != null && var69 != var95.field65) {
                                       class130.method2798(var95, true);
                                       var95 = null;
                                    }

                                    if(var95 == null) {
                                       var95 = class56.method1219(var66, var69, var74);
                                    }
                                 }

                                 for(var105 = (class3)field434.method3745(); null != var105; var105 = (class3)field434.method3746()) {
                                    if(var105.field63) {
                                       var105.field63 = false;
                                    } else {
                                       class130.method2798(var105, true);
                                    }
                                 }

                                 field475 = new class196(512);

                                 while(field320.field1971 < var4) {
                                    var66 = field320.method2505();
                                    var69 = field320.method2502();
                                    var74 = field320.method2502();
                                    var10 = field320.method2505();

                                    for(var11 = var69; var11 <= var74; ++var11) {
                                       var106 = (long)var11 + ((long)var66 << 32);
                                       field475.method3743(new class201(var10), var106);
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(134 == field322) {
                                 var72 = field320.method2508();
                                 var5 = field320.method2545();
                                 var101 = class141.method2959(var5);
                                 if(!var72.equals(var101.field2875)) {
                                    var101.field2875 = var72;
                                    class2.method28(var101);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 44) {
                                 class152.field2247 = field320.method2527();
                                 class1.field30 = field320.method2526();

                                 for(var4 = class1.field30; var4 < 8 + class1.field30; ++var4) {
                                    for(var5 = class152.field2247; var5 < class152.field2247 + 8; ++var5) {
                                       if(null != field364[class28.field655][var4][var5]) {
                                          field364[class28.field655][var4][var5] = null;
                                          class11.method156(var4, var5);
                                       }
                                    }
                                 }

                                 for(class16 var123 = (class16)field407.method3784(); var123 != null; var123 = (class16)field407.method3777()) {
                                    if(var123.field224 >= class1.field30 && var123.field224 < 8 + class1.field30 && var123.field225 >= class152.field2247 && var123.field225 < class152.field2247 + 8 && class28.field655 == var123.field227) {
                                       var123.field233 = 0;
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(111 == field322) {
                                 class25 var112 = new class25();
                                 var112.field627 = field320.method2508();
                                 var112.field618 = field320.method2502();
                                 var5 = field320.method2505();
                                 var112.field613 = var5;
                                 class13.method162(45);
                                 class99.field1660.method2964();
                                 class99.field1660 = null;
                                 class21.method572(var112);
                                 field322 = -1;
                                 var61 = false;
                                 break label4963;
                              }

                              if(76 == field322) {
                                 var4 = field320.method2505();
                                 class3 var135 = (class3)field434.method3742((long)var4);
                                 if(var135 != null) {
                                    class130.method2798(var135, true);
                                 }

                                 if(field437 != null) {
                                    class2.method28(field437);
                                    field437 = null;
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(85 == field322) {
                                 var4 = field320.method2502();
                                 if('\uffff' == var4) {
                                    var4 = -1;
                                 }

                                 if(var4 == -1 && !field512) {
                                    class168.method3332();
                                 } else if(var4 != -1 && var4 != field532 && field409 != 0 && !field512) {
                                    class168 var134 = class135.field2069;
                                    var64 = field409;
                                    class183.field2959 = 1;
                                    class76.field1370 = var134;
                                    class183.field2960 = var4;
                                    class183.field2961 = 0;
                                    class183.field2957 = var64;
                                    class183.field2964 = false;
                                    class183.field2963 = 2;
                                 }

                                 field532 = var4;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(203 == field322) {
                                 var4 = field320.method2662();
                                 var5 = field320.method2534();
                                 if('\uffff' == var5) {
                                    var5 = -1;
                                 }

                                 if(field409 != 0 && var5 != -1) {
                                    class126.method2783(class136.field2080, var5, 0, field409, false);
                                    field512 = true;
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 186) {
                                 var4 = field320.method2505();
                                 var5 = field320.method2502();
                                 if(var4 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var4 >= 0) {
                                    var101 = class141.method2959(var4);
                                 } else {
                                    var101 = null;
                                 }

                                 if(null != var101) {
                                    for(var66 = 0; var66 < var101.field2862.length; ++var66) {
                                       var101.field2862[var66] = 0;
                                       var101.field2863[var66] = 0;
                                    }
                                 }

                                 class15 var97 = (class15)class15.field210.method3742((long)var5);
                                 if(null != var97) {
                                    for(var69 = 0; var69 < var97.field211.length; ++var69) {
                                       var97.field211[var69] = -1;
                                       var97.field212[var69] = 0;
                                    }
                                 }

                                 var66 = field320.method2502();

                                 for(var69 = 0; var69 < var66; ++var69) {
                                    var74 = field320.method2534();
                                    var10 = field320.method2527();
                                    if(var10 == 255) {
                                       var10 = field320.method2545();
                                    }

                                    if(null != var101 && var69 < var101.field2862.length) {
                                       var101.field2862[var69] = var74;
                                       var101.field2863[var69] = var10;
                                    }

                                    class56.method1220(var5, var69, var74 - 1, var10);
                                 }

                                 if(var101 != null) {
                                    class2.method28(var101);
                                 }

                                 class18.method196();
                                 field461[++field462 - 1 & 31] = var5 & 32767;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 236) {
                                 class152.field2247 = field320.method2526();
                                 class1.field30 = field320.method2663();

                                 while(field320.field1971 < field523) {
                                    field322 = field320.method2500();
                                    class30.method661();
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 90) {
                                 var4 = field320.method2545();
                                 class12.field189 = class142.field2153.method2872(var4);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 114) {
                                 var4 = field320.method2536();
                                 var5 = field320.method2536();
                                 var64 = field320.method2543();
                                 var66 = field320.method2502();
                                 var93 = class141.method2959(var64);
                                 if(var66 != var93.field2795 || var5 != var93.field2832 || var4 != var93.field2743) {
                                    var93.field2795 = var66;
                                    var93.field2832 = var5;
                                    var93.field2743 = var4;
                                    class2.method28(var93);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(234 == field322) {
                                 var72 = field320.method2508();
                                 var115 = field320.method2506();
                                 var90 = (long)field320.method2502();
                                 var82 = (long)field320.method2662();
                                 class152 var100 = (class152)class104.method2282(class168.method3331(), field320.method2500());
                                 var106 = (var90 << 32) + var82;
                                 var124 = false;

                                 for(var15 = 0; var15 < 100; ++var15) {
                                    if(var106 == field494[var15]) {
                                       var124 = true;
                                       break;
                                    }
                                 }

                                 if(var100.field2253 && class18.method200(var72)) {
                                    var124 = true;
                                 }

                                 if(!var124 && field395 == 0) {
                                    field494[field495] = var106;
                                    field495 = (field495 + 1) % 100;
                                    class122 var150 = field320;

                                    String var140;
                                    try {
                                       var18 = var150.method2512();
                                       if(var18 > 32767) {
                                          var18 = 32767;
                                       }

                                       byte[] var144 = new byte[var18];
                                       var150.field1971 += class163.field2644.method2425(var150.field1973, var150.field1971, var144, 0, var18);
                                       String var152 = class139.method2912(var144, 0, var18);
                                       var140 = var152;
                                    } catch (Exception var48) {
                                       var140 = "Cabbage";
                                    }

                                    var140 = class223.method4005(method555(var140));
                                    if(var100.field2251 != -1) {
                                       class77.method1685(9, class7.method106(var100.field2251) + var72, var140, class104.method2281(var115));
                                    } else {
                                       class77.method1685(9, var72, var140, class104.method2281(var115));
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(190 == field322) {
                                 if(-1 != field433) {
                                    var4 = field433;
                                    if(class107.method2374(var4)) {
                                       class4.method38(class173.field2735[var4], 0);
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 43) {
                                 var4 = field320.method2502();
                                 var5 = field320.method2500();
                                 var64 = field320.method2502();
                                 if(0 != field513 && var5 != 0 && field515 < 50) {
                                    field439[field515] = var4;
                                    field460[field515] = var5;
                                    field518[field515] = var64;
                                    field543[field515] = null;
                                    field519[field515] = 0;
                                    ++field515;
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(73 == field322) {
                                 for(var4 = 0; var4 < class176.field2900.length; ++var4) {
                                    if(class176.field2900[var4] != class176.field2901[var4]) {
                                       class176.field2900[var4] = class176.field2901[var4];
                                       class48.method989(var4);
                                       field441[++field445 - 1 & 31] = var4;
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 224) {
                                 field271 = 1;
                                 field466 = field458;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 181) {
                                 var4 = field320.method2502();
                                 field433 = var4;
                                 class72.method1569(false);
                                 class211.method3905(var4);
                                 class95.method2181(field433);

                                 for(var5 = 0; var5 < 100; ++var5) {
                                    field478[var5] = true;
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(89 == field322) {
                                 byte var85 = field320.method2521();
                                 var5 = field320.method2535();
                                 class176.field2901[var5] = var85;
                                 if(class176.field2900[var5] != var85) {
                                    class176.field2900[var5] = var85;
                                 }

                                 class48.method989(var5);
                                 field441[++field445 - 1 & 31] = var5;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 24) {
                                 var4 = field320.method2505();
                                 var5 = field320.method2501();
                                 var101 = class141.method2959(var4);
                                 if(var5 != var101.field2848 || -1 == var5) {
                                    var101.field2848 = var5;
                                    var101.field2866 = 0;
                                    var101.field2867 = 0;
                                    class2.method28(var101);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(7 == field322) {
                                 var4 = field320.method2545();
                                 var5 = field320.method2536();
                                 var101 = class141.method2959(var4);
                                 if(1 != var101.field2787 || var5 != var101.field2776) {
                                    var101.field2787 = 1;
                                    var101.field2776 = var5;
                                    class2.method28(var101);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 145) {
                                 class18.method196();
                                 field413 = field320.method2501();
                                 field470 = field458;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(102 == field322) {
                                 var4 = field320.method2534();
                                 if(var4 == '\uffff') {
                                    var4 = -1;
                                 }

                                 var5 = field320.method2536();
                                 if('\uffff' == var5) {
                                    var5 = -1;
                                 }

                                 var64 = field320.method2505();
                                 var66 = field320.method2545();

                                 for(var69 = var4; var69 <= var5; ++var69) {
                                    var82 = ((long)var66 << 32) + (long)var69;
                                    class208 var99 = field475.method3742(var82);
                                    if(null != var99) {
                                       var99.method3883();
                                    }

                                    field475.method3743(new class201(var64), var82);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(217 == field322) {
                                 var4 = field320.method2512();
                                 var91 = field320.method2500() == 1;
                                 var89 = "";
                                 var84 = false;
                                 if(var91) {
                                    var89 = field320.method2508();
                                    if(class18.method200(var89)) {
                                       var84 = true;
                                    }
                                 }

                                 String var88 = field320.method2508();
                                 if(!var84) {
                                    class8.method109(var4, var89, var88);
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 194) {
                                 var4 = field320.method2502();
                                 var5 = field320.method2543();
                                 class176.field2901[var4] = var5;
                                 if(class176.field2900[var4] != var5) {
                                    class176.field2900[var4] = var5;
                                 }

                                 class48.method989(var4);
                                 field441[++field445 - 1 & 31] = var4;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(246 == field322) {
                                 class18.method196();
                                 field438 = field320.method2500();
                                 field470 = field458;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 239) {
                                 field320.field1971 += 28;
                                 if(field320.method2531()) {
                                    class122 var76 = field320;
                                    var5 = field320.field1971 - 28;
                                    if(class149.field2215 != null) {
                                       try {
                                          class149.field2215.method4132(0L);
                                          class149.field2215.method4112(var76.field1973, var5, 24);
                                       } catch (Exception var47) {
                                          ;
                                       }
                                    }
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(67 == field322) {
                                 class17.method191(field320, field523);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(field322 == 208) {
                                 var72 = field320.method2508();
                                 class122 var96 = field320;

                                 try {
                                    var69 = var96.method2512();
                                    if(var69 > 32767) {
                                       var69 = 32767;
                                    }

                                    byte[] var81 = new byte[var69];
                                    var96.field1971 += class163.field2644.method2425(var96.field1973, var96.field1971, var81, 0, var69);
                                    String var86 = class139.method2912(var81, 0, var69);
                                    var77 = var86;
                                 } catch (Exception var46) {
                                    var77 = "Cabbage";
                                 }

                                 var77 = class223.method4005(method555(var77));
                                 class8.method109(6, var72, var77);
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(192 == field322) {
                                 field507 = field320.method2500();
                                 if(field507 == 255) {
                                    field507 = 0;
                                 }

                                 field508 = field320.method2500();
                                 if(255 == field508) {
                                    field508 = 0;
                                 }

                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              if(93 == field322) {
                                 while(field320.field1971 < field523) {
                                    var4 = field320.method2500();
                                    var91 = (var4 & 1) == 1;
                                    var89 = field320.method2508();
                                    var77 = field320.method2508();
                                    field320.method2508();

                                    for(var69 = 0; var69 < field544; ++var69) {
                                       class7 var80 = field545[var69];
                                       if(var91) {
                                          if(var77.equals(var80.field131)) {
                                             var80.field131 = var89;
                                             var80.field133 = var77;
                                             var89 = null;
                                             break;
                                          }
                                       } else if(var89.equals(var80.field131)) {
                                          var80.field131 = var89;
                                          var80.field133 = var77;
                                          var89 = null;
                                          break;
                                       }
                                    }

                                    if(var89 != null && field544 < 400) {
                                       class7 var83 = new class7();
                                       field545[field544] = var83;
                                       var83.field131 = var89;
                                       var83.field133 = var77;
                                       ++field544;
                                    }
                                 }

                                 field466 = field458;
                                 field322 = -1;
                                 var61 = true;
                                 break label4963;
                              }

                              class6.method102("" + field322 + "," + field326 + "," + field281 + "," + field523, (Throwable)null);
                              class21.method579();
                           } catch (IOException var55) {
                              if(field305 > 0) {
                                 class21.method579();
                              } else {
                                 class13.method162(40);
                                 class18.field257 = class99.field1660;
                                 class99.field1660 = null;
                              }
                           } catch (Exception var56) {
                              var72 = "" + field322 + "," + field326 + "," + field281 + "," + field523 + "," + (class47.field1053.field848[0] + class187.field3014) + "," + (class47.field1053.field822[0] + class0.field12) + ",";

                              for(var5 = 0; var5 < field523 && var5 < 50; ++var5) {
                                 var72 = var72 + field320.field1973[var5] + ",";
                              }

                              class6.method102(var72, var56);
                              class21.method579();
                           }

                           var61 = true;
                        }
                     }

                     if(!var61) {
                        break;
                     }
                  }

                  if(30 == field283) {
                     while(class18.method199()) {
                        field318.method2735(217);
                        field318.method2503(0);
                        var58 = field318.field1971;
                        class96.method2192(field318);
                        field318.method2497(field318.field1971 - var58);
                     }

                     Object var68 = class226.field3215.field191;
                     synchronized(class226.field3215.field191) {
                        if(!field273) {
                           class226.field3215.field193 = 0;
                        } else if(0 != class140.field2134 || class226.field3215.field193 >= 40) {
                           field318.method2735(238);
                           field318.method2503(0);
                           var59 = field318.field1971;
                           var60 = 0;

                           for(var4 = 0; var4 < class226.field3215.field193 && field318.field1971 - var59 < 240; ++var4) {
                              ++var60;
                              var5 = class226.field3215.field196[var4];
                              if(var5 < 0) {
                                 var5 = 0;
                              } else if(var5 > 502) {
                                 var5 = 502;
                              }

                              var64 = class226.field3215.field194[var4];
                              if(var64 < 0) {
                                 var64 = 0;
                              } else if(var64 > 764) {
                                 var64 = 764;
                              }

                              var66 = var64 + var5 * 765;
                              if(class226.field3215.field196[var4] == -1 && class226.field3215.field194[var4] == -1) {
                                 var64 = -1;
                                 var5 = -1;
                                 var66 = 524287;
                              }

                              if(field367 == var64 && var5 == field288) {
                                 if(field289 < 2047) {
                                    ++field289;
                                 }
                              } else {
                                 var69 = var64 - field367;
                                 field367 = var64;
                                 var74 = var5 - field288;
                                 field288 = var5;
                                 if(field289 < 8 && var69 >= -32 && var69 <= 31 && var74 >= -32 && var74 <= 31) {
                                    var69 += 32;
                                    var74 += 32;
                                    field318.method2486(var74 + (field289 << 12) + (var69 << 6));
                                    field289 = 0;
                                 } else if(field289 < 8) {
                                    field318.method2487(var66 + 8388608 + (field289 << 19));
                                    field289 = 0;
                                 } else {
                                    field318.method2488(var66 + (field289 << 19) + -1073741824);
                                    field289 = 0;
                                 }
                              }
                           }

                           field318.method2497(field318.field1971 - var59);
                           if(var60 >= class226.field3215.field193) {
                              class226.field3215.field193 = 0;
                           } else {
                              class226.field3215.field193 -= var60;

                              for(var4 = 0; var4 < class226.field3215.field193; ++var4) {
                                 class226.field3215.field194[var4] = class226.field3215.field194[var60 + var4];
                                 class226.field3215.field196[var4] = class226.field3215.field196[var4 + var60];
                              }
                           }
                        }
                     }

                     if(class140.field2134 == 1 || !class139.field2116 && class140.field2134 == 4 || 2 == class140.field2134) {
                        long var70 = (class140.field2137 - field286) / 50L;
                        if(var70 > 4095L) {
                           var70 = 4095L;
                        }

                        field286 = class140.field2137;
                        var60 = class140.field2136;
                        if(var60 < 0) {
                           var60 = 0;
                        } else if(var60 > class39.field901) {
                           var60 = class39.field901;
                        }

                        var4 = class140.field2135;
                        if(var4 < 0) {
                           var4 = 0;
                        } else if(var4 > class5.field102) {
                           var4 = class5.field102;
                        }

                        var5 = (int)var70;
                        field318.method2735(8);
                        field318.method2486((var5 << 1) + (class140.field2134 == 2?1:0));
                        field318.method2486(var4);
                        field318.method2486(var60);
                     }

                     if(class137.field2088 > 0) {
                        field318.method2735(211);
                        field318.method2486(0);
                        var58 = field318.field1971;
                        long var162 = class77.method1674();

                        for(var4 = 0; var4 < class137.field2088; ++var4) {
                           var115 = var162 - field380;
                           if(var115 > 16777215L) {
                              var115 = 16777215L;
                           }

                           field380 = var162;
                           field318.method2503(class137.field2102[var4]);
                           field318.method2539((int)var115);
                        }

                        field318.method2496(field318.field1971 - var58);
                     }

                     if(field366 > 0) {
                        --field366;
                     }

                     if(class137.field2095[96] || class137.field2095[97] || class137.field2095[98] || class137.field2095[99]) {
                        field333 = true;
                     }

                     if(field333 && field366 <= 0) {
                        field366 = 20;
                        field333 = false;
                        field318.method2735(52);
                        field318.method2603(field359);
                        field318.method2603(field521);
                     }

                     if(class107.field1864 && !field339) {
                        field339 = true;
                        field318.method2735(147);
                        field318.method2503(1);
                     }

                     if(!class107.field1864 && field339) {
                        field339 = false;
                        field318.method2735(147);
                        field318.method2503(0);
                     }

                     if(field355 != class28.field655) {
                        field355 = class28.field655;
                        class11.method154(class28.field655);
                     }

                     if(field283 == 30) {
                        for(class16 var75 = (class16)field407.method3784(); null != var75; var75 = (class16)field407.method3777()) {
                           if(var75.field233 > 0) {
                              --var75.field233;
                           }

                           if(0 == var75.field233) {
                              if(var75.field236 < 0 || class184.method3672(var75.field236, var75.field228)) {
                                 class48.method993(var75.field227, var75.field222, var75.field224, var75.field225, var75.field236, var75.field234, var75.field228);
                                 var75.method3883();
                              }
                           } else {
                              if(var75.field232 > 0) {
                                 --var75.field232;
                              }

                              if(var75.field232 == 0 && var75.field224 >= 1 && var75.field225 >= 1 && var75.field224 <= 102 && var75.field225 <= 102 && (var75.field229 < 0 || class184.method3672(var75.field229, var75.field231))) {
                                 class48.method993(var75.field227, var75.field222, var75.field224, var75.field225, var75.field229, var75.field230, var75.field231);
                                 var75.field232 = -1;
                                 if(var75.field236 == var75.field229 && -1 == var75.field236) {
                                    var75.method3883();
                                 } else if(var75.field229 == var75.field236 && var75.field234 == var75.field230 && var75.field228 == var75.field231) {
                                    var75.method3883();
                                 }
                              }
                           }
                        }

                        class16.method184();
                        ++field323;
                        if(field323 > 750) {
                           if(field305 > 0) {
                              class21.method579();
                           } else {
                              class13.method162(40);
                              class18.field257 = class99.field1660;
                              class99.field1660 = null;
                           }
                        } else {
                           var58 = class32.field737;
                           int[] var163 = class32.field738;

                           for(var60 = 0; var60 < var58; ++var60) {
                              class2 var168 = field396[var163[var60]];
                              if(null != var168) {
                                 class162.method3159(var168, 1);
                              }
                           }

                           class17.method189();
                           int[] var78 = class32.field738;

                           for(var59 = 0; var59 < class32.field737; ++var59) {
                              class2 var87 = field396[var78[var59]];
                              if(null != var87 && var87.field810 > 0) {
                                 --var87.field810;
                                 if(0 == var87.field810) {
                                    var87.field807 = null;
                                 }
                              }
                           }

                           for(var59 = 0; var59 < field314; ++var59) {
                              var60 = field459[var59];
                              class34 var169 = field517[var60];
                              if(null != var169 && var169.field810 > 0) {
                                 --var169.field810;
                                 if(var169.field810 == 0) {
                                    var169.field807 = null;
                                 }
                              }
                           }

                           ++field351;
                           if(field386 != 0) {
                              field542 += 20;
                              if(field542 >= 400) {
                                 field386 = 0;
                              }
                           }

                           if(class15.field217 != null) {
                              ++field387;
                              if(field387 >= 15) {
                                 class2.method28(class15.field217);
                                 class15.field217 = null;
                              }
                           }

                           class173 var79 = class143.field2170;
                           class173 var165 = class0.field14;
                           class143.field2170 = null;
                           class0.field14 = null;
                           field295 = null;
                           field469 = false;
                           field451 = false;
                           field410 = 0;

                           while(true) {
                              while(class2.method29() && field410 < 128) {
                                 if(field440 >= 2 && class137.field2095[82] && class188.field3056 == 66) {
                                    String var92 = class167.method3293();
                                    class129.field2026.setContents(new StringSelection(var92), (ClipboardOwner)null);
                                 } else {
                                    field498[field410] = class188.field3056;
                                    field497[field410] = class137.field2081;
                                    ++field410;
                                 }
                              }

                              if(-1 != field433) {
                                 class108.method2414(field433, 0, 0, class5.field102, class39.field901, 0, 0);
                              }

                              ++field458;

                              while(true) {
                                 class0 var94;
                                 class173 var170;
                                 do {
                                    var94 = (class0)field550.method3782();
                                    if(var94 == null) {
                                       while(true) {
                                          do {
                                             var94 = (class0)field340.method3782();
                                             if(null == var94) {
                                                while(true) {
                                                   do {
                                                      var94 = (class0)field472.method3782();
                                                      if(var94 == null) {
                                                         boolean var98 = false;

                                                         while(!var98) {
                                                            var98 = true;

                                                            for(var4 = 0; var4 < field415 - 1; ++var4) {
                                                               if(field418[var4] < 1000 && field418[1 + var4] > 1000) {
                                                                  var161 = field290[var4];
                                                                  field290[var4] = field290[1 + var4];
                                                                  field290[var4 + 1] = var161;
                                                                  var89 = field420[var4];
                                                                  field420[var4] = field420[1 + var4];
                                                                  field420[var4 + 1] = var89;
                                                                  var66 = field418[var4];
                                                                  field418[var4] = field418[1 + var4];
                                                                  field418[var4 + 1] = var66;
                                                                  var66 = field385[var4];
                                                                  field385[var4] = field385[1 + var4];
                                                                  field385[1 + var4] = var66;
                                                                  var66 = field417[var4];
                                                                  field417[var4] = field417[1 + var4];
                                                                  field417[var4 + 1] = var66;
                                                                  var66 = field502[var4];
                                                                  field502[var4] = field502[var4 + 1];
                                                                  field502[1 + var4] = var66;
                                                                  var98 = false;
                                                               }
                                                            }
                                                         }

                                                         if(null == class35.field772 && field446 == null) {
                                                            var60 = class140.field2134;
                                                            if(field453) {
                                                               if(1 != var60 && (class139.field2116 || var60 != 4)) {
                                                                  var4 = class140.field2128;
                                                                  var5 = class140.field2126;
                                                                  if(var4 < class167.field2665 - 10 || var4 > 10 + class18.field256 + class167.field2665 || var5 < class28.field663 - 10 || var5 > class28.field663 + class93.field1585 + 10) {
                                                                     field453 = false;
                                                                     class43.method889(class167.field2665, class28.field663, class18.field256, class93.field1585);
                                                                  }
                                                               }

                                                               if(var60 == 1 || !class139.field2116 && 4 == var60) {
                                                                  var4 = class167.field2665;
                                                                  var5 = class28.field663;
                                                                  var64 = class18.field256;
                                                                  var66 = class140.field2135;
                                                                  var69 = class140.field2136;
                                                                  var74 = -1;

                                                                  for(var10 = 0; var10 < field415; ++var10) {
                                                                     var11 = 15 * (field415 - 1 - var10) + 31 + var5;
                                                                     if(var66 > var4 && var66 < var4 + var64 && var69 > var11 - 13 && var69 < var11 + 3) {
                                                                        var74 = var10;
                                                                     }
                                                                  }

                                                                  if(-1 != var74) {
                                                                     class90.method2086(var74);
                                                                  }

                                                                  field453 = false;
                                                                  class43.method889(class167.field2665, class28.field663, class18.field256, class93.field1585);
                                                               }
                                                            } else {
                                                               label5091: {
                                                                  if((var60 == 1 || !class139.field2116 && var60 == 4) && field415 > 0) {
                                                                     var4 = field418[field415 - 1];
                                                                     if(var4 == 39 || 40 == var4 || 41 == var4 || 42 == var4 || 43 == var4 || var4 == 33 || 34 == var4 || 35 == var4 || var4 == 36 || 37 == var4 || var4 == 38 || var4 == 1005) {
                                                                        label5059: {
                                                                           var5 = field385[field415 - 1];
                                                                           var64 = field417[field415 - 1];
                                                                           var121 = class141.method2959(var64);
                                                                           if(!class0.method0(class144.method3075(var121))) {
                                                                              var74 = class144.method3075(var121);
                                                                              var118 = 0 != (var74 >> 29 & 1);
                                                                              if(!var118) {
                                                                                 break label5059;
                                                                              }
                                                                           }

                                                                           if(null != class35.field772 && !field393 && 1 != field327 && !class158.method3135(field415 - 1) && field415 > 0) {
                                                                              class6.method104(field390, field357);
                                                                           }

                                                                           field393 = false;
                                                                           field394 = 0;
                                                                           if(null != class35.field772) {
                                                                              class2.method28(class35.field772);
                                                                           }

                                                                           class35.field772 = class141.method2959(var64);
                                                                           field389 = var5;
                                                                           field390 = class140.field2135;
                                                                           field357 = class140.field2136;
                                                                           if(field415 > 0) {
                                                                              var69 = field415 - 1;
                                                                              class179.field2925 = new class30();
                                                                              class179.field2925.field684 = field385[var69];
                                                                              class179.field2925.field689 = field417[var69];
                                                                              class179.field2925.field691 = field418[var69];
                                                                              class179.field2925.field686 = field502[var69];
                                                                              class179.field2925.field687 = field420[var69];
                                                                           }

                                                                           class2.method28(class35.field772);
                                                                           break label5091;
                                                                        }
                                                                     }
                                                                  }

                                                                  if((var60 == 1 || !class139.field2116 && var60 == 4) && (1 == field327 && field415 > 2 || class158.method3135(field415 - 1))) {
                                                                     var60 = 2;
                                                                  }

                                                                  if((1 == var60 || !class139.field2116 && var60 == 4) && field415 > 0) {
                                                                     class90.method2086(field415 - 1);
                                                                  }

                                                                  if(var60 == 2 && field415 > 0) {
                                                                     class36.method739(class140.field2135, class140.field2136);
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         if(null != field446) {
                                                            class2.method28(field446);
                                                            ++class99.field1659;
                                                            if(field469 && field451) {
                                                               var60 = class140.field2128;
                                                               var4 = class140.field2126;
                                                               var60 -= field448;
                                                               var4 -= field449;
                                                               if(var60 < field452) {
                                                                  var60 = field452;
                                                               }

                                                               if(var60 + field446.field2840 > field447.field2840 + field452) {
                                                                  var60 = field452 + field447.field2840 - field446.field2840;
                                                               }

                                                               if(var4 < field299) {
                                                                  var4 = field299;
                                                               }

                                                               if(var4 + field446.field2746 > field447.field2746 + field299) {
                                                                  var4 = field447.field2746 + field299 - field446.field2746;
                                                               }

                                                               var5 = var60 - field455;
                                                               var64 = var4 - field456;
                                                               var66 = field446.field2857;
                                                               if(class99.field1659 > field446.field2821 && (var5 > var66 || var5 < -var66 || var64 > var66 || var64 < -var66)) {
                                                                  field457 = true;
                                                               }

                                                               var69 = var60 - field452 + field447.field2765;
                                                               var74 = field447.field2766 + (var4 - field299);
                                                               class0 var137;
                                                               if(field446.field2804 != null && field457) {
                                                                  var137 = new class0();
                                                                  var137.field18 = field446;
                                                                  var137.field3 = var69;
                                                                  var137.field4 = var74;
                                                                  var137.field16 = field446.field2804;
                                                                  class37.method749(var137);
                                                               }

                                                               if(class140.field2127 == 0) {
                                                                  if(field457) {
                                                                     if(null != field446.field2834) {
                                                                        var137 = new class0();
                                                                        var137.field18 = field446;
                                                                        var137.field3 = var69;
                                                                        var137.field4 = var74;
                                                                        var137.field6 = field295;
                                                                        var137.field16 = field446.field2834;
                                                                        class37.method749(var137);
                                                                     }

                                                                     if(null != field295) {
                                                                        class173 var126 = field446;
                                                                        var12 = class172.method3358(class144.method3075(var126));
                                                                        if(0 == var12) {
                                                                           var103 = null;
                                                                        } else {
                                                                           var13 = 0;

                                                                           while(true) {
                                                                              if(var13 >= var12) {
                                                                                 var103 = var126;
                                                                                 break;
                                                                              }

                                                                              var126 = class141.method2959(var126.field2763);
                                                                              if(var126 == null) {
                                                                                 var103 = null;
                                                                                 break;
                                                                              }

                                                                              ++var13;
                                                                           }
                                                                        }

                                                                        if(null != var103) {
                                                                           field318.method2735(212);
                                                                           field318.method2486(field295.field2773);
                                                                           field318.method2603(field446.field2798);
                                                                           field318.method2533(field446.field2773);
                                                                           field318.method2541(field295.field2774);
                                                                           field318.method2540(field446.field2774);
                                                                           field318.method2603(field295.field2798);
                                                                        }
                                                                     }
                                                                  } else if((field327 == 1 || class158.method3135(field415 - 1)) && field415 > 2) {
                                                                     class36.method739(field448 + field455, field449 + field456);
                                                                  } else if(field415 > 0) {
                                                                     class6.method104(field455 + field448, field456 + field449);
                                                                  }

                                                                  field446 = null;
                                                               }
                                                            } else if(class99.field1659 > 1) {
                                                               field446 = null;
                                                            }
                                                         }

                                                         if(class35.field772 != null) {
                                                            class2.method28(class35.field772);
                                                            ++field394;
                                                            if(class140.field2127 != 0) {
                                                               if(field394 >= 5 && (class140.field2128 > field390 + 5 || class140.field2128 < field390 - 5 || class140.field2126 > field357 + 5 || class140.field2126 < field357 - 5)) {
                                                                  field393 = true;
                                                               }
                                                            } else {
                                                               if(field393) {
                                                                  if(class166.field2657 == class35.field772 && field389 != field392) {
                                                                     class173 var125 = class35.field772;
                                                                     byte var171 = 0;
                                                                     if(field436 == 1 && 206 == var125.field2748) {
                                                                        var171 = 1;
                                                                     }

                                                                     if(var125.field2862[field392] <= 0) {
                                                                        var171 = 0;
                                                                     }

                                                                     var64 = class144.method3075(var125);
                                                                     var91 = 0 != (var64 >> 29 & 1);
                                                                     if(var91) {
                                                                        var66 = field389;
                                                                        var69 = field392;
                                                                        var125.field2862[var69] = var125.field2862[var66];
                                                                        var125.field2863[var69] = var125.field2863[var66];
                                                                        var125.field2862[var66] = -1;
                                                                        var125.field2863[var66] = 0;
                                                                     } else if(1 == var171) {
                                                                        var66 = field389;
                                                                        var69 = field392;

                                                                        while(var66 != var69) {
                                                                           if(var66 > var69) {
                                                                              var125.method3364(var66 - 1, var66);
                                                                              --var66;
                                                                           } else if(var66 < var69) {
                                                                              var125.method3364(1 + var66, var66);
                                                                              ++var66;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var125.method3364(field392, field389);
                                                                     }

                                                                     field318.method2735(155);
                                                                     field318.method2642(field389);
                                                                     field318.method2486(field392);
                                                                     field318.method2601(var171);
                                                                     field318.method2541(class35.field772.field2774);
                                                                  }
                                                               } else if((1 == field327 || class158.method3135(field415 - 1)) && field415 > 2) {
                                                                  class36.method739(field390, field357);
                                                               } else if(field415 > 0) {
                                                                  class6.method104(field390, field357);
                                                               }

                                                               field387 = 10;
                                                               class140.field2134 = 0;
                                                               class35.field772 = null;
                                                            }
                                                         }

                                                         if(-1 != class86.field1472) {
                                                            var60 = class86.field1472;
                                                            var4 = class86.field1490;
                                                            field318.method2735(187);
                                                            field318.method2503(5);
                                                            field318.method2486(var60 + class187.field3014);
                                                            field318.method2597(class137.field2095[82]?(class137.field2095[81]?2:1):0);
                                                            field318.method2533(class0.field12 + var4);
                                                            class86.field1472 = -1;
                                                            field383 = class140.field2135;
                                                            field384 = class140.field2136;
                                                            field386 = 1;
                                                            field542 = 0;
                                                            field507 = var60;
                                                            field508 = var4;
                                                         }

                                                         if(var79 != class143.field2170) {
                                                            if(null != var79) {
                                                               class2.method28(var79);
                                                            }

                                                            if(class143.field2170 != null) {
                                                               class2.method28(class143.field2170);
                                                            }
                                                         }

                                                         if(class0.field14 != var165 && field425 == field424) {
                                                            if(null != var165) {
                                                               class2.method28(var165);
                                                            }

                                                            if(class0.field14 != null) {
                                                               class2.method28(class0.field14);
                                                            }
                                                         }

                                                         if(class0.field14 != null) {
                                                            if(field424 < field425) {
                                                               ++field424;
                                                               if(field425 == field424) {
                                                                  class2.method28(class0.field14);
                                                               }
                                                            }
                                                         } else if(field424 > 0) {
                                                            --field424;
                                                         }

                                                         var60 = field360 + class47.field1053.field816;
                                                         var4 = class47.field1053.field840 + field341;
                                                         if(class21.field568 - var60 < -500 || class21.field568 - var60 > 500 || class26.field634 - var4 < -500 || class26.field634 - var4 > 500) {
                                                            class21.field568 = var60;
                                                            class26.field634 = var4;
                                                         }

                                                         if(var60 != class21.field568) {
                                                            class21.field568 += (var60 - class21.field568) / 16;
                                                         }

                                                         if(class26.field634 != var4) {
                                                            class26.field634 += (var4 - class26.field634) / 16;
                                                         }

                                                         if(class140.field2127 == 4 && class139.field2116) {
                                                            var5 = class140.field2126 - field471;
                                                            field399 = var5 * 2;
                                                            field471 = var5 != -1 && 1 != var5?(field471 + class140.field2126) / 2:class140.field2126;
                                                            var64 = field363 - class140.field2128;
                                                            field361 = var64 * 2;
                                                            field363 = var64 != -1 && 1 != var64?(class140.field2128 + field363) / 2:class140.field2128;
                                                         } else {
                                                            if(class137.field2095[96]) {
                                                               field361 += (-24 - field361) / 2;
                                                            } else if(class137.field2095[97]) {
                                                               field361 += (24 - field361) / 2;
                                                            } else {
                                                               field361 /= 2;
                                                            }

                                                            if(class137.field2095[98]) {
                                                               field399 += (12 - field399) / 2;
                                                            } else if(class137.field2095[99]) {
                                                               field399 += (-12 - field399) / 2;
                                                            } else {
                                                               field399 /= 2;
                                                            }

                                                            field471 = class140.field2126;
                                                            field363 = class140.field2128;
                                                         }

                                                         field521 = field361 / 2 + field521 & 2047;
                                                         field359 += field399 / 2;
                                                         if(field359 < 128) {
                                                            field359 = 128;
                                                         }

                                                         if(field359 > 383) {
                                                            field359 = 383;
                                                         }

                                                         var5 = class21.field568 >> 7;
                                                         var64 = class26.field634 >> 7;
                                                         var66 = class148.method3106(class21.field568, class26.field634, class28.field655);
                                                         var69 = 0;
                                                         if(var5 > 3 && var64 > 3 && var5 < 100 && var64 < 100) {
                                                            for(var74 = var5 - 4; var74 <= var5 + 4; ++var74) {
                                                               for(var10 = var64 - 4; var10 <= var64 + 4; ++var10) {
                                                                  var11 = class28.field655;
                                                                  if(var11 < 3 && (class5.field84[1][var74][var10] & 2) == 2) {
                                                                     ++var11;
                                                                  }

                                                                  var12 = var66 - class5.field91[var11][var74][var10];
                                                                  if(var12 > var69) {
                                                                     var69 = var12;
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         var74 = 192 * var69;
                                                         if(var74 > 98048) {
                                                            var74 = 98048;
                                                         }

                                                         if(var74 < '耀') {
                                                            var74 = '耀';
                                                         }

                                                         if(var74 > field368) {
                                                            field368 += (var74 - field368) / 24;
                                                         } else if(var74 < field368) {
                                                            field368 += (var74 - field368) / 80;
                                                         }

                                                         if(field499) {
                                                            class77.method1683();
                                                         }

                                                         for(var60 = 0; var60 < 5; ++var60) {
                                                            ++field526[var60];
                                                         }

                                                         class27.field651.method210();
                                                         var60 = ++class140.field2123 - 1;
                                                         var5 = class7.method108();
                                                         if(var60 > 15000 && var5 > 15000) {
                                                            field305 = 250;
                                                            class140.field2123 = 14500;
                                                            field318.method2735(45);
                                                         }

                                                         ++field345;
                                                         if(field345 > 500) {
                                                            field345 = 0;
                                                            var64 = (int)(Math.random() * 8.0D);
                                                            if(1 == (var64 & 1)) {
                                                               field360 += field464;
                                                            }

                                                            if((var64 & 2) == 2) {
                                                               field341 += field342;
                                                            }

                                                            if((var64 & 4) == 4) {
                                                               field343 += field344;
                                                            }
                                                         }

                                                         if(field360 < -50) {
                                                            field464 = 2;
                                                         }

                                                         if(field360 > 50) {
                                                            field464 = -2;
                                                         }

                                                         if(field341 < -55) {
                                                            field342 = 2;
                                                         }

                                                         if(field341 > 55) {
                                                            field342 = -2;
                                                         }

                                                         if(field343 < -40) {
                                                            field344 = 1;
                                                         }

                                                         if(field343 > 40) {
                                                            field344 = -1;
                                                         }

                                                         ++field297;
                                                         if(field297 > 500) {
                                                            field297 = 0;
                                                            var64 = (int)(Math.random() * 8.0D);
                                                            if((var64 & 1) == 1) {
                                                               field346 += field347;
                                                            }

                                                            if(2 == (var64 & 2)) {
                                                               field479 += field349;
                                                            }
                                                         }

                                                         if(field346 < -60) {
                                                            field347 = 2;
                                                         }

                                                         if(field346 > 60) {
                                                            field347 = -2;
                                                         }

                                                         if(field479 < -20) {
                                                            field349 = 1;
                                                         }

                                                         if(field479 > 10) {
                                                            field349 = -1;
                                                         }

                                                         for(class38 var166 = (class38)field534.method3731(); var166 != null; var166 = (class38)field534.method3733()) {
                                                            if((long)var166.field858 < class77.method1674() / 1000L - 5L) {
                                                               if(var166.field859 > 0) {
                                                                  class8.method109(5, "", var166.field857 + " has logged in.");
                                                               }

                                                               if(0 == var166.field859) {
                                                                  class8.method109(5, "", var166.field857 + " has logged out.");
                                                               }

                                                               var166.method3880();
                                                            }
                                                         }

                                                         ++field291;
                                                         if(field291 > 50) {
                                                            field318.method2735(200);
                                                         }

                                                         try {
                                                            if(null != class99.field1660 && field318.field1971 > 0) {
                                                               class99.field1660.method2967(field318.field1973, 0, field318.field1971);
                                                               field318.field1971 = 0;
                                                               field291 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var52) {
                                                            if(field305 > 0) {
                                                               class21.method579();
                                                            } else {
                                                               class13.method162(40);
                                                               class18.field257 = class99.field1660;
                                                               class99.field1660 = null;
                                                            }

                                                            return;
                                                         }

                                                         return;
                                                      }

                                                      var170 = var94.field18;
                                                      if(var170.field2798 < 0) {
                                                         break;
                                                      }

                                                      var153 = class141.method2959(var170.field2763);
                                                   } while(null == var153 || null == var153.field2868 || var170.field2798 >= var153.field2868.length || var170 != var153.field2868[var170.field2798]);

                                                   class37.method749(var94);
                                                }
                                             }

                                             var170 = var94.field18;
                                             if(var170.field2798 < 0) {
                                                break;
                                             }

                                             var153 = class141.method2959(var170.field2763);
                                          } while(var153 == null || var153.field2868 == null || var170.field2798 >= var153.field2868.length || var170 != var153.field2868[var170.field2798]);

                                          class37.method749(var94);
                                       }
                                    }

                                    var170 = var94.field18;
                                    if(var170.field2798 < 0) {
                                       break;
                                    }

                                    var153 = class141.method2959(var170.field2763);
                                 } while(var153 == null || var153.field2868 == null || var170.field2798 >= var153.field2868.length || var170 != var153.field2868[var170.field2798]);

                                 class37.method749(var94);
                              }
                           }
                        }
                     }
                  }
               }
            } else if(40 == field283 || field283 == 45) {
               class34.method724();
            }

            return;
         }

         var1.field2696.method3301(var1.field2699, (int)var1.field3122, var1.field2693, false);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1548178931"
   )
   protected final void vmethod2984() {
      boolean var1 = class33.method708();
      if(var1 && field512 && class17.field244 != null) {
         class17.field244.method1198();
      }

      int var23;
      if(field283 == 10 || field283 == 20 || 30 == field283) {
         if(field486 != 0L && class77.method1674() > field486) {
            int var19 = field487?2:1;
            field486 = 0L;
            if(var19 >= 2) {
               field487 = true;
            } else {
               field487 = false;
            }

            class44.method933();
            if(field283 >= 25) {
               field318.method2735(98);
               class122 var21 = field318;
               var23 = field487?2:1;
               var21.method2503(var23);
               field318.method2486(class5.field102);
               field318.method2486(class39.field901);
            }

            class144.field2183 = true;
         } else if(class144.field2189) {
            Canvas var2 = class3.field66;
            var2.removeKeyListener(class137.field2089);
            var2.removeFocusListener(class137.field2089);
            class137.field2099 = -1;
            Canvas var3 = class3.field66;
            var3.removeMouseListener(class140.field2124);
            var3.removeMouseMotionListener(class140.field2124);
            var3.removeFocusListener(class140.field2124);
            class140.field2130 = 0;
            if(class171.field2726 != null) {
               class171.field2726.vmethod3079(class3.field66);
            }

            field272.method2985();
            class3.field66.setBackground(Color.black);
            Canvas var4 = class3.field66;
            var4.setFocusTraversalKeysEnabled(false);
            var4.addKeyListener(class137.field2089);
            var4.addFocusListener(class137.field2089);
            class28.method648(class3.field66);
            if(null != class171.field2726) {
               class171.field2726.vmethod3078(class3.field66);
            }

            if(field433 != -1) {
               class72.method1569(false);
            }

            class144.field2185 = true;
         }
      }

      Dimension var20 = this.method2987();
      if(var20.width != class129.field2028 || class37.field809 != var20.height || class144.field2185) {
         class44.method933();
         field486 = class77.method1674() + 500L;
         class144.field2185 = false;
      }

      boolean var22 = false;
      if(class144.field2183) {
         class144.field2183 = false;
         var22 = true;

         for(var23 = 0; var23 < 100; ++var23) {
            field478[var23] = true;
         }
      }

      if(var22) {
         class21.method565();
      }

      int var9;
      int var10;
      int var24;
      if(0 == field283) {
         var23 = class31.field730;
         String var5 = class31.field711;
         Color var6 = null;

         try {
            Graphics var7 = class3.field66.getGraphics();
            if(null == class124.field2009) {
               class124.field2009 = new Font("Helvetica", 1, 13);
               class77.field1372 = class3.field66.getFontMetrics(class124.field2009);
            }

            if(var22) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, class5.field102, class39.field901);
            }

            if(null == var6) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(class142.field2156 == null) {
                  class142.field2156 = class3.field66.createImage(304, 34);
               }

               Graphics var8 = class142.field2156.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, 3 * var23, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(2 + var23 * 3, 2, 300 - var23 * 3, 30);
               var8.setFont(class124.field2009);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - class77.field1372.stringWidth(var5)) / 2, 22);
               var7.drawImage(class142.field2156, class5.field102 / 2 - 152, class39.field901 / 2 - 18, (ImageObserver)null);
            } catch (Exception var15) {
               var9 = class5.field102 / 2 - 152;
               var10 = class39.field901 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(2 + var9, 2 + var10, 3 * var23, 30);
               var7.setColor(Color.black);
               var7.drawRect(1 + var9, var10 + 1, 301, 31);
               var7.fillRect(var23 * 3 + var9 + 2, 2 + var10, 300 - var23 * 3, 30);
               var7.setFont(class124.field2009);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - class77.field1372.stringWidth(var5)) / 2, var10 + 22);
            }
         } catch (Exception var16) {
            class3.field66.repaint();
         }
      } else if(field283 == 5) {
         class123.method2762(class95.field1606, class188.field3044, class37.field797, var22);
      } else if(field283 != 10 && field283 != 11) {
         if(20 == field283) {
            class123.method2762(class95.field1606, class188.field3044, class37.field797, var22);
         } else if(25 == field283) {
            if(field334 == 1) {
               if(field330 > field331) {
                  field331 = field330;
               }

               var23 = (field331 * 50 - field330 * 50) / field331;
               class171.method3355("Loading - please wait." + "<br>" + " (" + var23 + "%" + ")", false);
            } else if(field334 == 2) {
               if(field332 > field485) {
                  field485 = field332;
               }

               var23 = (field485 * 50 - field332 * 50) / field485 + 50;
               class171.method3355("Loading - please wait." + "<br>" + " (" + var23 + "%" + ")", false);
            } else {
               class171.method3355("Loading - please wait.", false);
            }
         } else if(field283 == 30) {
            if(field433 != -1) {
               class7.method107(field433);
            }

            for(var23 = 0; var23 < field476; ++var23) {
               if(field478[var23]) {
                  field391[var23] = true;
               }

               field480[var23] = field478[var23];
               field478[var23] = false;
            }

            field477 = field285;
            field316 = -1;
            field442 = -1;
            class166.field2657 = null;
            if(field433 != -1) {
               field476 = 0;
               class52.method1079(field433, 0, 0, class5.field102, class39.field901, 0, 0, -1);
            }

            class79.method1776();
            if(!field453) {
               if(-1 != field316) {
                  var23 = field316;
                  var24 = field442;
                  if(field415 >= 2 || field280 != 0 || field511) {
                     String var26;
                     if(field280 == 1 && field415 < 2) {
                        var26 = "Use" + " " + field427 + " " + "->";
                     } else if(field511 && field415 < 2) {
                        var26 = field362 + " " + field313 + " " + "->";
                     } else {
                        var26 = class98.method2193(field415 - 1);
                     }

                     if(field415 > 2) {
                        var26 = var26 + class219.method3968(16777215) + " " + '/' + " " + (field415 - 2) + " more options";
                     }

                     class95.field1606.method4012(var26, var23 + 4, 15 + var24, 16777215, 0, field285 / 1000);
                  }
               }
            } else {
               class139.method2913();
            }

            if(3 == field338) {
               for(var23 = 0; var23 < field476; ++var23) {
                  if(field480[var23]) {
                     class79.method1782(field321[var23], field315[var23], field483[var23], field551[var23], 16711935, 128);
                  } else if(field391[var23]) {
                     class79.method1782(field321[var23], field315[var23], field483[var23], field551[var23], 16711680, 128);
                  }
               }
            }

            var23 = class28.field655;
            var24 = class47.field1053.field816;
            int var29 = class47.field1053.field840;
            int var25 = field351;

            for(class23 var28 = (class23)class23.field593.method3784(); var28 != null; var28 = (class23)class23.field593.method3777()) {
               if(var28.field602 != -1 || var28.field599 != null) {
                  var9 = 0;
                  if(var24 > var28.field588) {
                     var9 += var24 - var28.field588;
                  } else if(var24 < var28.field584) {
                     var9 += var28.field584 - var24;
                  }

                  if(var29 > var28.field595) {
                     var9 += var29 - var28.field595;
                  } else if(var29 < var28.field587) {
                     var9 += var28.field587 - var29;
                  }

                  if(var9 - 64 <= var28.field590 && 0 != field514 && var28.field585 == var23) {
                     var9 -= 64;
                     if(var9 < 0) {
                        var9 = 0;
                     }

                     var10 = (var28.field590 - var9) * field514 / var28.field590;
                     class58 var10000;
                     if(var28.field592 == null) {
                        if(var28.field602 >= 0) {
                           var10000 = (class58)null;
                           class58 var11 = class58.method1237(class101.field1741, var28.field602, 0);
                           if(var11 != null) {
                              class62 var12 = var11.method1246().method1277(class108.field1886);
                              class64 var13 = class64.method1313(var12, 100, var10);
                              var13.method1303(-1);
                              class135.field2066.method1146(var13);
                              var28.field592 = var13;
                           }
                        }
                     } else {
                        var28.field592.method1304(var10);
                     }

                     if(var28.field597 == null) {
                        if(null != var28.field599 && (var28.field591 -= var25) <= 0) {
                           int var30 = (int)(Math.random() * (double)var28.field599.length);
                           var10000 = (class58)null;
                           class58 var31 = class58.method1237(class101.field1741, var28.field599[var30], 0);
                           if(null != var31) {
                              class62 var32 = var31.method1246().method1277(class108.field1886);
                              class64 var14 = class64.method1313(var32, 100, var10);
                              var14.method1303(0);
                              class135.field2066.method1146(var14);
                              var28.field597 = var14;
                              var28.field591 = var28.field596 + (int)(Math.random() * (double)(var28.field586 - var28.field596));
                           }
                        }
                     } else {
                        var28.field597.method1304(var10);
                        if(!var28.field597.method3882()) {
                           var28.field597 = null;
                        }
                     }
                  } else {
                     if(var28.field592 != null) {
                        class135.field2066.method1133(var28.field592);
                        var28.field592 = null;
                     }

                     if(null != var28.field597) {
                        class135.field2066.method1133(var28.field597);
                        var28.field597 = null;
                     }
                  }
               }
            }

            field351 = 0;
         } else if(field283 == 40) {
            class171.method3355("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(45 == field283) {
            class171.method3355("Please wait...", false);
         }
      } else {
         class123.method2762(class95.field1606, class188.field3044, class37.field797, var22);
      }

      Graphics var27;
      if(field283 == 30 && 0 == field338 && !var22) {
         try {
            var27 = class3.field66.getGraphics();

            for(var24 = 0; var24 < field476; ++var24) {
               if(field391[var24]) {
                  class75.field1363.vmethod1871(var27, field321[var24], field315[var24], field483[var24], field551[var24]);
                  field391[var24] = false;
               }
            }
         } catch (Exception var18) {
            class3.field66.repaint();
         }
      } else if(field283 > 0) {
         try {
            var27 = class3.field66.getGraphics();
            class75.field1363.vmethod1873(var27, 0, 0);

            for(var24 = 0; var24 < field476; ++var24) {
               field391[var24] = false;
            }
         } catch (Exception var17) {
            class3.field66.repaint();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "58346606"
   )
   void method252() {
      if(1000 != field283) {
         long var2 = class77.method1674();
         int var4 = (int)(var2 - class127.field2024);
         class127.field2024 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class171.field2710 += var4;
         boolean var1;
         if(class171.field2718 == 0 && 0 == class171.field2713 && class171.field2720 == 0 && 0 == class171.field2719) {
            var1 = true;
         } else if(null == class226.field3216) {
            var1 = false;
         } else {
            try {
               label243: {
                  if(class171.field2710 > 30000) {
                     throw new IOException();
                  }

                  class172 var5;
                  class119 var6;
                  while(class171.field2713 < 20 && class171.field2719 > 0) {
                     var5 = (class172)class171.field2728.method3745();
                     var6 = new class119(4);
                     var6.method2503(1);
                     var6.method2487((int)var5.field3122);
                     class226.field3216.method2967(var6.field1973, 0, 4);
                     class171.field2712.method3743(var5, var5.field3122);
                     --class171.field2719;
                     ++class171.field2713;
                  }

                  while(class171.field2718 < 20 && class171.field2720 > 0) {
                     var5 = (class172)class171.field2716.method3848();
                     var6 = new class119(4);
                     var6.method2503(0);
                     var6.method2487((int)var5.field3122);
                     class226.field3216.method2967(var6.field1973, 0, 4);
                     var5.method3863();
                     class171.field2717.method3743(var5, var5.field3122);
                     --class171.field2720;
                     ++class171.field2718;
                  }

                  for(int var20 = 0; var20 < 100; ++var20) {
                     int var21 = class226.field3216.method2972();
                     if(var21 < 0) {
                        throw new IOException();
                     }

                     if(var21 == 0) {
                        break;
                     }

                     class171.field2710 = 0;
                     byte var7 = 0;
                     if(class161.field2639 == null) {
                        var7 = 8;
                     } else if(0 == class171.field2709) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class171.field2711.field1971;
                        if(var8 > var21) {
                           var8 = var21;
                        }

                        class226.field3216.method2966(class171.field2711.field1973, class171.field2711.field1971, var8);
                        if(class171.field2723 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class171.field2711.field1973[var9 + class171.field2711.field1971] ^= class171.field2723;
                           }
                        }

                        class171.field2711.field1971 += var8;
                        if(class171.field2711.field1971 < var7) {
                           break;
                        }

                        if(null == class161.field2639) {
                           class171.field2711.field1971 = 0;
                           var9 = class171.field2711.method2500();
                           var10 = class171.field2711.method2502();
                           int var11 = class171.field2711.method2500();
                           var12 = class171.field2711.method2505();
                           long var13 = (long)((var9 << 16) + var10);
                           class172 var15 = (class172)class171.field2712.method3742(var13);
                           class38.field862 = true;
                           if(var15 == null) {
                              var15 = (class172)class171.field2717.method3742(var13);
                              class38.field862 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = 0 == var11?5:9;
                           class161.field2639 = var15;
                           class93.field1574 = new class119(class161.field2639.field2732 + var12 + var16);
                           class93.field1574.method2503(var11);
                           class93.field1574.method2488(var12);
                           class171.field2709 = 8;
                           class171.field2711.field1971 = 0;
                        } else if(0 == class171.field2709) {
                           if(class171.field2711.field1973[0] == -1) {
                              class171.field2709 = 1;
                              class171.field2711.field1971 = 0;
                           } else {
                              class161.field2639 = null;
                           }
                        }
                     } else {
                        var8 = class93.field1574.field1973.length - class161.field2639.field2732;
                        var9 = 512 - class171.field2709;
                        if(var9 > var8 - class93.field1574.field1971) {
                           var9 = var8 - class93.field1574.field1971;
                        }

                        if(var9 > var21) {
                           var9 = var21;
                        }

                        class226.field3216.method2966(class93.field1574.field1973, class93.field1574.field1971, var9);
                        if(0 != class171.field2723) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class93.field1574.field1973[var10 + class93.field1574.field1971] ^= class171.field2723;
                           }
                        }

                        class93.field1574.field1971 += var9;
                        class171.field2709 += var9;
                        if(var8 == class93.field1574.field1971) {
                           if(16711935L == class161.field2639.field3122) {
                              class75.field1361 = class93.field1574;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class168 var22 = class171.field2722[var10];
                                 if(var22 != null) {
                                    class75.field1361.field1971 = 5 + var10 * 8;
                                    var12 = class75.field1361.method2505();
                                    int var23 = class75.field1361.method2505();
                                    var22.method3299(var12, var23);
                                 }
                              }
                           } else {
                              class171.field2721.reset();
                              class171.field2721.update(class93.field1574.field1973, 0, var8);
                              var10 = (int)class171.field2721.getValue();
                              if(class161.field2639.field2730 != var10) {
                                 try {
                                    class226.field3216.method2964();
                                 } catch (Exception var18) {
                                    ;
                                 }

                                 ++class171.field2724;
                                 class226.field3216 = null;
                                 class171.field2723 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label243;
                              }

                              class171.field2724 = 0;
                              class171.field2725 = 0;
                              class161.field2639.field2731.method3300((int)(class161.field2639.field3122 & 65535L), class93.field1574.field1973, (class161.field2639.field3122 & 16711680L) == 16711680L, class38.field862);
                           }

                           class161.field2639.method3883();
                           if(class38.field862) {
                              --class171.field2713;
                           } else {
                              --class171.field2718;
                           }

                           class171.field2709 = 0;
                           class161.field2639 = null;
                           class93.field1574 = null;
                        } else {
                           if(512 != class171.field2709) {
                              break;
                           }

                           class171.field2709 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var19) {
               try {
                  class226.field3216.method2964();
               } catch (Exception var17) {
                  ;
               }

               ++class171.field2725;
               class226.field3216 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method253();
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1766274930"
   )
   void method253() {
      if(class171.field2724 >= 4) {
         this.method2998("js5crc");
         field283 = 1000;
      } else {
         if(class171.field2725 >= 4) {
            if(field283 <= 5) {
               this.method2998("js5io");
               field283 = 1000;
               return;
            }

            field465 = 3000;
            class171.field2725 = 3;
         }

         if(--field465 + 1 <= 0) {
            try {
               if(0 == field350) {
                  class4.field77 = class142.field2153.method2850(field312, class47.field1055);
                  ++field350;
               }

               if(1 == field350) {
                  if(2 == class4.field77.field2195) {
                     this.method254(-1);
                     return;
                  }

                  if(class4.field77.field2195 == 1) {
                     ++field350;
                  }
               }

               if(2 == field350) {
                  class7.field137 = new class143((Socket)class4.field77.field2194, class142.field2153);
                  class119 var1 = new class119(5);
                  var1.method2503(15);
                  var1.method2488(113);
                  class7.field137.method2967(var1.field1973, 0, 5);
                  ++field350;
                  class30.field694 = class77.method1674();
               }

               if(3 == field350) {
                  if(field283 > 5 && class7.field137.method2972() <= 0) {
                     if(class77.method1674() - class30.field694 > 30000L) {
                        this.method254(-2);
                        return;
                     }
                  } else {
                     int var9 = class7.field137.method2968();
                     if(0 != var9) {
                        this.method254(var9);
                        return;
                     }

                     ++field350;
                  }
               }

               if(field350 == 4) {
                  class143 var10 = class7.field137;
                  boolean var2 = field283 > 20;
                  if(class226.field3216 != null) {
                     try {
                        class226.field3216.method2964();
                     } catch (Exception var7) {
                        ;
                     }

                     class226.field3216 = null;
                  }

                  class226.field3216 = var10;
                  class5.method69(var2);
                  class171.field2711.field1971 = 0;
                  class161.field2639 = null;
                  class93.field1574 = null;
                  class171.field2709 = 0;

                  while(true) {
                     class172 var3 = (class172)class171.field2712.method3745();
                     if(var3 == null) {
                        while(true) {
                           var3 = (class172)class171.field2717.method3745();
                           if(null == var3) {
                              if(0 != class171.field2723) {
                                 try {
                                    class119 var11 = new class119(4);
                                    var11.method2503(4);
                                    var11.method2503(class171.field2723);
                                    var11.method2486(0);
                                    class226.field3216.method2967(var11.field1973, 0, 4);
                                 } catch (IOException var6) {
                                    try {
                                       class226.field3216.method2964();
                                    } catch (Exception var5) {
                                       ;
                                    }

                                    ++class171.field2725;
                                    class226.field3216 = null;
                                 }
                              }

                              class171.field2710 = 0;
                              class127.field2024 = class77.method1674();
                              class4.field77 = null;
                              class7.field137 = null;
                              field350 = 0;
                              field307 = 0;
                              return;
                           }

                           class171.field2716.method3855(var3);
                           class171.field2715.method3743(var3, var3.field3122);
                           ++class171.field2720;
                           --class171.field2718;
                        }
                     }

                     class171.field2728.method3743(var3, var3.field3122);
                     ++class171.field2719;
                     --class171.field2713;
                  }
               }
            } catch (IOException var8) {
               this.method254(-3);
            }

         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1512648362"
   )
   void method254(int var1) {
      class4.field77 = null;
      class7.field137 = null;
      field350 = 0;
      if(class47.field1055 == class39.field903) {
         class47.field1055 = class127.field2020;
      } else {
         class47.field1055 = class39.field903;
      }

      ++field307;
      if(field307 < 2 || 7 != var1 && 9 != var1) {
         if(field307 >= 2 && 6 == var1) {
            this.method2998("js5connect_outofdate");
            field283 = 1000;
         } else if(field307 >= 4) {
            if(field283 <= 5) {
               this.method2998("js5connect");
               field283 = 1000;
            } else {
               field465 = 3000;
            }
         }
      } else if(field283 <= 5) {
         this.method2998("js5connect_full");
         field283 = 1000;
      } else {
         field465 = 3000;
      }

   }

   static {
      field301 = class20.field565;
      field335 = class20.field565;
      field432 = 0;
      field350 = 0;
      field465 = 0;
      field307 = 0;
      field308 = 0;
      field293 = 0;
      field310 = 0;
      field311 = 0;
      field517 = new class34['耀'];
      field314 = 0;
      field459 = new int['耀'];
      field541 = 0;
      field317 = new int[250];
      field318 = new class122(5000);
      field319 = new class122(5000);
      field320 = new class122(15000);
      field523 = 0;
      field322 = 0;
      field323 = 0;
      field291 = 0;
      field325 = 0;
      field326 = 0;
      field281 = 0;
      field305 = 0;
      field329 = false;
      field330 = 0;
      field331 = 1;
      field332 = 0;
      field485 = 1;
      field334 = 0;
      field482 = new class108[4];
      field336 = false;
      field337 = new int[4][13][13];
      field414 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field360 = 0;
      field464 = 2;
      field341 = 0;
      field342 = 2;
      field343 = 0;
      field344 = 1;
      field345 = 0;
      field346 = 0;
      field347 = 2;
      field479 = 0;
      field349 = 1;
      field297 = 0;
      field351 = 0;
      field353 = 2301979;
      field354 = 5063219;
      field406 = 3353893;
      field356 = 7759444;
      field422 = false;
      field358 = 0;
      field359 = 128;
      field521 = 0;
      field361 = 0;
      field399 = 0;
      field363 = 0;
      field471 = 0;
      field365 = 50;
      field366 = 0;
      field333 = false;
      field368 = 0;
      field516 = 0;
      field370 = 50;
      field371 = new int[field370];
      field372 = new int[field370];
      field373 = new int[field370];
      field374 = new int[field370];
      field375 = new int[field370];
      field381 = new int[field370];
      field377 = new int[field370];
      field378 = new String[field370];
      field520 = new int[104][104];
      field473 = 0;
      field277 = -1;
      field382 = -1;
      field383 = 0;
      field384 = 0;
      field542 = 0;
      field386 = 0;
      field387 = 0;
      field388 = 0;
      field389 = 0;
      field390 = 0;
      field357 = 0;
      field392 = 0;
      field393 = false;
      field394 = 0;
      field395 = 0;
      field396 = new class2[2048];
      field397 = -1;
      field398 = 0;
      field328 = 0;
      field400 = new int[1000];
      field510 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field402 = new String[8];
      field403 = new boolean[8];
      field490 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field405 = -1;
      field364 = new class199[4][104][104];
      field407 = new class199();
      field408 = new class199();
      field454 = new class199();
      field419 = new int[25];
      field411 = new int[25];
      field412 = new int[25];
      field327 = 0;
      field453 = false;
      field415 = 0;
      field385 = new int[500];
      field417 = new int[500];
      field418 = new int[500];
      field502 = new int[500];
      field420 = new String[500];
      field290 = new String[500];
      field316 = -1;
      field442 = -1;
      field424 = 0;
      field425 = 50;
      field280 = 0;
      field427 = null;
      field511 = false;
      field429 = -1;
      field430 = -1;
      field362 = null;
      field313 = null;
      field433 = -1;
      field434 = new class196(8);
      field435 = 0;
      field436 = 0;
      field437 = null;
      field438 = 0;
      field413 = 0;
      field440 = 0;
      field379 = -1;
      field376 = false;
      field443 = false;
      field444 = false;
      field298 = null;
      field446 = null;
      field447 = null;
      field448 = 0;
      field449 = 0;
      field295 = null;
      field451 = false;
      field452 = -1;
      field299 = -1;
      field469 = false;
      field455 = -1;
      field456 = -1;
      field457 = false;
      field458 = 1;
      field441 = new int[32];
      field445 = 0;
      field461 = new int[32];
      field462 = 0;
      field463 = new int[32];
      field496 = 0;
      field500 = 0;
      field466 = 0;
      field467 = 0;
      field468 = 0;
      field484 = 0;
      field470 = 0;
      field537 = 0;
      field472 = new class199();
      field550 = new class199();
      field340 = new class199();
      field475 = new class196(512);
      field476 = 0;
      field477 = -2;
      field478 = new boolean[100];
      field391 = new boolean[100];
      field480 = new boolean[100];
      field321 = new int[100];
      field315 = new int[100];
      field483 = new int[100];
      field551 = new int[100];
      field338 = 0;
      field486 = 0L;
      field487 = true;
      field488 = 765;
      field489 = 503;
      field540 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field491 = 0;
      field287 = 0;
      field481 = "";
      field494 = new long[100];
      field495 = 0;
      field410 = 0;
      field497 = new int[128];
      field498 = new int[128];
      field380 = -1L;
      field416 = null;
      field501 = null;
      field355 = -1;
      field503 = 0;
      field474 = new int[1000];
      field450 = new int[1000];
      field506 = new class78[1000];
      field507 = 0;
      field508 = 0;
      field509 = 0;
      field409 = 255;
      field532 = -1;
      field512 = false;
      field513 = 127;
      field514 = 127;
      field515 = 0;
      field439 = new int[50];
      field460 = new int[50];
      field518 = new int[50];
      field519 = new int[50];
      field543 = new class58[50];
      field499 = false;
      field522 = new boolean[5];
      field369 = new int[5];
      field524 = new int[5];
      field525 = new int[5];
      field526 = new int[5];
      field527 = 256;
      field528 = 205;
      field426 = 256;
      field530 = 320;
      field324 = 1;
      field401 = 32767;
      field533 = 1;
      field504 = 32767;
      field535 = 0;
      field536 = 0;
      field505 = 0;
      field538 = 0;
      field539 = 0;
      field348 = 0;
      field271 = 0;
      field428 = new class17[400];
      field534 = new class195();
      field544 = 0;
      field545 = new class7[400];
      field546 = new class179();
      field547 = -1;
      field548 = -1;
      field549 = new class220[8];
      field304 = -1L;
      field493 = -1L;
      field552 = new class10();
      field553 = new int[50];
      field554 = new int[50];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass168;II)V",
      garbageValue = "-2059691973"
   )
   static void method263(class168 var0, int var1) {
      if(class75.field1361 != null) {
         class75.field1361.field1971 = 5 + 8 * var1;
         int var2 = class75.field1361.method2505();
         int var3 = class75.field1361.method2505();
         var0.method3299(var2, var3);
      } else {
         class22.method586((class168)null, 255, 255, 0, (byte)0, true);
         class171.field2722[var1] = var0;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "587883500"
   )
   protected final void vmethod2997() {
      if(class27.field651.method211()) {
         class27.field651.method208();
      }

      if(class226.field3215 != null) {
         class226.field3215.field195 = false;
      }

      class226.field3215 = null;
      if(null != class99.field1660) {
         class99.field1660.method2964();
         class99.field1660 = null;
      }

      class13.method168();
      class114.method2435();
      class171.field2726 = null;
      if(null != class17.field244) {
         class17.field244.method1178();
      }

      if(class14.field203 != null) {
         class14.field203.method1178();
      }

      if(class226.field3216 != null) {
         class226.field3216.method2964();
      }

      class149.method3107();
      class159.method3140();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILclass107;Lclass108;Z[I[II)I",
      garbageValue = "1"
   )
   public static int method312(int var0, int var1, int var2, class107 var3, class108 var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class106.field1850[var8][var9] = 0;
            class106.field1855[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var27;
      int var29;
      int var30;
      int var32;
      if(1 == var2) {
         var27 = class19.method241(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var27 = class3.method31(var0, var1, var3, var4);
      } else {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class106.field1850[var12][var13] = 99;
         class106.field1855[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class106.field1853[var16] = var0;
         var32 = var16 + 1;
         class106.field1849[var16] = var1;
         int[][] var18 = var4.field1879;

         boolean var28;
         label516:
         while(true) {
            label514:
            while(true) {
               do {
                  do {
                     do {
                        label491:
                        do {
                           if(var32 == var17) {
                              class33.field758 = var10;
                              class103.field1756 = var11;
                              var28 = false;
                              break label516;
                           }

                           var10 = class106.field1853[var17];
                           var11 = class106.field1849[var17];
                           var17 = var17 + 1 & 4095;
                           var29 = var10 - var14;
                           var30 = var11 - var15;
                           var19 = var10 - var4.field1880;
                           var20 = var11 - var4.field1876;
                           if(var3.vmethod2375(var2, var10, var11, var4)) {
                              class33.field758 = var10;
                              class103.field1756 = var11;
                              var28 = true;
                              break label516;
                           }

                           var21 = class106.field1855[var29][var30] + 1;
                           if(var29 > 0 && 0 == class106.field1850[var29 - 1][var30] && 0 == (var18[var19 - 1][var20] & 19136782) && (var18[var19 - 1][var2 + var20 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class106.field1853[var32] = var10 - 1;
                                    class106.field1849[var32] = var11;
                                    var32 = var32 + 1 & 4095;
                                    class106.field1850[var29 - 1][var30] = 2;
                                    class106.field1855[var29 - 1][var30] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var29 < 128 - var2 && 0 == class106.field1850[var29 + 1][var30] && 0 == (var18[var19 + var2][var20] & 19136899) && 0 == (var18[var19 + var2][var2 + var20 - 1] & 19136992)) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class106.field1853[var32] = var10 + 1;
                                    class106.field1849[var32] = var11;
                                    var32 = var32 + 1 & 4095;
                                    class106.field1850[1 + var29][var30] = 8;
                                    class106.field1855[var29 + 1][var30] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var22 + var20] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && class106.field1850[var29][var30 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && 0 == (var18[var2 + var19 - 1][var20 - 1] & 19136899)) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class106.field1853[var32] = var10;
                                    class106.field1849[var32] = var11 - 1;
                                    var32 = 1 + var32 & 4095;
                                    class106.field1850[var29][var30 - 1] = 1;
                                    class106.field1855[var29][var30 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class106.field1850[var29][1 + var30] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && (var18[var2 + var19 - 1][var20 + var2] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class106.field1853[var32] = var10;
                                    class106.field1849[var32] = var11 + 1;
                                    var32 = var32 + 1 & 4095;
                                    class106.field1850[var29][var30 + 1] = 4;
                                    class106.field1855[var29][var30 + 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var2 + var20] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var29 > 0 && var30 > 0 && 0 == class106.field1850[var29 - 1][var30 - 1] && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class106.field1853[var32] = var10 - 1;
                                    class106.field1849[var32] = var11 - 1;
                                    var32 = 1 + var32 & 4095;
                                    class106.field1850[var29 - 1][var30 - 1] = 3;
                                    class106.field1855[var29 - 1][var30 - 1] = var21;
                                    break;
                                 }

                                 if(0 != (var18[var19 - 1][var22 + (var20 - 1)] & 19136830) || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var29 < 128 - var2 && var30 > 0 && 0 == class106.field1850[var29 + 1][var30 - 1] && 0 == (var18[var2 + var19][var20 - 1] & 19136899)) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class106.field1853[var32] = 1 + var10;
                                    class106.field1849[var32] = var11 - 1;
                                    var32 = var32 + 1 & 4095;
                                    class106.field1850[var29 + 1][var30 - 1] = 9;
                                    class106.field1855[var29 + 1][var30 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var22 + (var20 - 1)] & 19136995) != 0 || 0 != (var18[var19 + var22][var20 - 1] & 19136911)) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var29 > 0 && var30 < 128 - var2 && 0 == class106.field1850[var29 - 1][1 + var30] && (var18[var19 - 1][var2 + var20] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0 || (var18[var19 - 1 + var22][var20 + var2] & 19137016) != 0) {
                                    continue label491;
                                 }
                              }

                              class106.field1853[var32] = var10 - 1;
                              class106.field1849[var32] = var11 + 1;
                              var32 = var32 + 1 & 4095;
                              class106.field1850[var29 - 1][var30 + 1] = 6;
                              class106.field1855[var29 - 1][1 + var30] = var21;
                           }
                        } while(var29 >= 128 - var2);
                     } while(var30 >= 128 - var2);
                  } while(0 != class106.field1850[1 + var29][1 + var30]);
               } while((var18[var19 + var2][var20 + var2] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if(0 != (var18[var19 + var22][var2 + var20] & 19137016) || (var18[var2 + var19][var20 + var22] & 19136995) != 0) {
                     continue label514;
                  }
               }

               class106.field1853[var32] = 1 + var10;
               class106.field1849[var32] = var11 + 1;
               var32 = 1 + var32 & 4095;
               class106.field1850[1 + var29][1 + var30] = 12;
               class106.field1855[var29 + 1][var30 + 1] = var21;
            }
         }

         var27 = var28;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class33.field758;
      var29 = class103.field1756;
      if(!var27) {
         var30 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var31 = 10;
         var32 = var3.field1861;
         var17 = var3.field1859;
         int var33 = var3.field1858;
         var19 = var3.field1863;

         for(var20 = var32 - var31; var20 <= var32 + var31; ++var20) {
            for(var21 = var17 - var31; var21 <= var31 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class106.field1855[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var32) {
                     var24 = var32 - var20;
                  } else if(var20 > var33 + var32 - 1) {
                     var24 = var20 - (var33 + var32 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var30 || var26 == var30 && class106.field1855[var22][var23] < var14) {
                     var30 = var26;
                     var14 = class106.field1855[var22][var23];
                     var11 = var20;
                     var29 = var21;
                  }
               }
            }
         }

         if(var30 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var29 == var1) {
         return 0;
      } else {
         var13 = 0;
         class106.field1853[var13] = var11;
         var30 = var13 + 1;
         class106.field1849[var13] = var29;

         for(var14 = var15 = class106.field1850[var11 - var9][var29 - var10]; var0 != var11 || var1 != var29; var14 = class106.field1850[var11 - var9][var29 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class106.field1853[var30] = var11;
               class106.field1849[var30++] = var29;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if(0 != (var14 & 8)) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var29;
            } else if(0 != (var14 & 4)) {
               --var29;
            }
         }

         var32 = 0;

         while(var30-- > 0) {
            var6[var32] = class106.field1853[var30];
            var7[var32++] = class106.field1849[var30];
            if(var32 >= var6.length) {
               break;
            }
         }

         return var32;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Lclass25;II[I[IB)V",
      garbageValue = "-37"
   )
   static void method553(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
         class25 var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].field624;
                     var12 = var8.field624;
                  } else if(1 == var3[var10]) {
                     var11 = var0[var6].field625;
                     var12 = var8.field625;
                     if(var11 == -1 && 1 == var4[var10]) {
                        var11 = 2001;
                     }

                     if(-1 == var12 && 1 == var4[var10]) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method599()?1:0;
                     var12 = var8.method599()?1:0;
                  } else {
                     var11 = var0[var6].field618;
                     var12 = var8.field618;
                  }

                  if(var12 != var11) {
                     if((1 != var4[var10] || var11 <= var12) && (0 != var4[var10] || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(2 == var3[var10]) {
                     var11 = var0[var5].field624;
                     var12 = var8.field624;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field625;
                     var12 = var8.field625;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(-1 == var12 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(3 == var3[var10]) {
                     var11 = var0[var5].method599()?1:0;
                     var12 = var8.method599()?1:0;
                  } else {
                     var11 = var0[var5].field618;
                     var12 = var8.field618;
                  }

                  if(var11 != var12) {
                     if((1 != var4[var10] || var11 >= var12) && (0 != var4[var10] || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method553(var0, var1, var6, var3, var4);
         method553(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-155821771"
   )
   public static String method555(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(0 == var3) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(2 != var3) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
