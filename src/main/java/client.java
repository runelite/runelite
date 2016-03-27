import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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
public final class client extends class143 {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1739790421
   )
   static int field289 = 0;
   @ObfuscatedName("hk")
   @Export("skillExperiences")
   static int[] field290;
   @ObfuscatedName("ph")
   static final class10 field291;
   @ObfuscatedName("kp")
   static class198 field292;
   @ObfuscatedName("kc")
   static class198 field293;
   @ObfuscatedName("g")
   static class152 field294;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -690463111
   )
   static int field295 = 0;
   @ObfuscatedName("l")
   static boolean field296 = false;
   @ObfuscatedName("h")
   static boolean field297 = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1458228771
   )
   static int field298 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1801245479
   )
   static int field299;
   @ObfuscatedName("pb")
   static int[] field300;
   @ObfuscatedName("cv")
   static class121 field301;
   @ObfuscatedName("ij")
   @Export("menuTypes")
   static int[] field302;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1966177037
   )
   @Export("gameCycle")
   static int field303 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 4496738552662948441L
   )
   static long field304 = 1L;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1744637019
   )
   static int field305 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 355001275
   )
   static int field306 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1742702907
   )
   static int field307 = -1;
   @ObfuscatedName("at")
   static boolean field308 = true;
   @ObfuscatedName("aw")
   static boolean field309 = false;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 126325719
   )
   static int field310 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -232177055
   )
   static int field311 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1077639149
   )
   static int field312 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 432500921
   )
   static int field313 = 0;
   @ObfuscatedName("me")
   static String field314;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -25864989
   )
   static int field315 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1271549253
   )
   static int field316 = 0;
   @ObfuscatedName("mu")
   static class78[] field317;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 994040813
   )
   static int field318 = 0;
   @ObfuscatedName("aa")
   static class20 field319;
   @ObfuscatedName("kl")
   static class198 field320;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -766626633
   )
   static int field321;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 454478463
   )
   static int field322;
   @ObfuscatedName("af")
   static int field323;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1305503843
   )
   static int field324;
   @ObfuscatedName("oh")
   static short field325;
   @ObfuscatedName("nn")
   static int[] field326;
   @ObfuscatedName("eg")
   static boolean field327;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -2106295119
   )
   static int field328;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1688776489
   )
   static int field329;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -90582159
   )
   static int field330;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -1114605953
   )
   static int field331;
   @ObfuscatedName("ag")
   static class20 field332;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -1061190123
   )
   static int field333;
   @ObfuscatedName("ct")
   static int[] field334;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -131520171
   )
   static int field335;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 2050958043
   )
   @Export("weight")
   static int field336;
   @ObfuscatedName("ht")
   @Export("realSkillLevels")
   static int[] field337;
   @ObfuscatedName("ko")
   static int[] field338;
   @ObfuscatedName("ls")
   static long[] field339;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1591889495
   )
   static int field340;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1044960773
   )
   static int field341;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 1107030365
   )
   static int field342;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1606275135
   )
   static int field343;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 183535397
   )
   static int field344;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 929022893
   )
   static int field345;
   @ObfuscatedName("cn")
   static boolean field346;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 2072351141
   )
   @Export("scale")
   static int field347;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = -1203893307
   )
   static int field348;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -46009635
   )
   static int field349;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -1540194645
   )
   static int field350;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -410316087
   )
   static int field351;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 358822705
   )
   static int field352;
   @ObfuscatedName("dv")
   static boolean field353;
   @ObfuscatedName("dg")
   static int[][][] field354;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -309572249
   )
   static int field355;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -406694303
   )
   static int field356;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 1633279977
   )
   static int field357;
   @ObfuscatedName("cs")
   @Export("cachedNPCs")
   static class34[] field358;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class107[] field359;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 103130797
   )
   static int field360;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -999510525
   )
   static int field361;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -1261829455
   )
   static int field362;
   @ObfuscatedName("mp")
   static int[] field363;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1910621499
   )
   static int field364;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = 758508433
   )
   static int field365;
   @ObfuscatedName("kx")
   static class195 field366;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 1580522783
   )
   static int field367;
   @ObfuscatedName("jx")
   static class172 field368;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = -600135987
   )
   static int field369;
   @ObfuscatedName("eq")
   static class78[] field370;
   @ObfuscatedName("ep")
   static class78[] field371;
   @ObfuscatedName("oa")
   static short field372;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 71886459
   )
   static int field373;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 982781417
   )
   static int field374;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1245951765
   )
   static int field375;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1820975171
   )
   static int field377;
   @ObfuscatedName("pj")
   static class178 field378;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 1264555521
   )
   static int field379;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 1625495831
   )
   static int field380;
   @ObfuscatedName("fj")
   static int[] field381;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -1217908539
   )
   static int field382;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 1322428227
   )
   static int field383;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1979386975
   )
   static int field384;
   @ObfuscatedName("hq")
   static class198 field385;
   @ObfuscatedName("fa")
   static boolean field386;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 1758794999
   )
   static int field387;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 1451049801
   )
   static int field388;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 2050937693
   )
   static int field389;
   @ObfuscatedName("ob")
   static boolean[] field390;
   @ObfuscatedName("fy")
   static int[] field391;
   @ObfuscatedName("fd")
   static int[] field392;
   @ObfuscatedName("fo")
   static int[] field393;
   @ObfuscatedName("fs")
   static int[] field394;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 227008899
   )
   static int field395;
   @ObfuscatedName("gw")
   static int[] field396;
   @ObfuscatedName("db")
   static final int[] field397;
   @ObfuscatedName("gp")
   static int[][] field398;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -300000283
   )
   static int field399;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -1957135117
   )
   static int field400;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 882043033
   )
   static int field401;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -3558311
   )
   static int field402;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1499089797
   )
   static int field403;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1483890717
   )
   static int field404;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1476101085
   )
   static int field405;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1267489817
   )
   static int field406;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -662692033
   )
   static int field407;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 1293376525
   )
   static int field408;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -1815422977
   )
   static int field409;
   @ObfuscatedName("hh")
   static int[] field410;
   @ObfuscatedName("ge")
   static String[] field411;
   @ObfuscatedName("ga")
   static boolean field412;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -1268948025
   )
   static int field413;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -756175041
   )
   static int field414;
   @ObfuscatedName("gx")
   @Export("cachedPlayers")
   static class2[] field415;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1100220297
   )
   static int field416;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -424786847
   )
   static int field417;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1634659351
   )
   static int field418 = 0;
   @ObfuscatedName("ha")
   @Export("groundItemDeque")
   static class198[][][] field419;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1841313585
   )
   static int field421;
   @ObfuscatedName("od")
   static int[] field422;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = 1098491843
   )
   static int field423;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -1639177423
   )
   static int field424;
   @ObfuscatedName("or")
   static int[] field425;
   @ObfuscatedName("c")
   static boolean field426 = true;
   @ObfuscatedName("hp")
   static class198 field427;
   @ObfuscatedName("on")
   static class194 field428;
   @ObfuscatedName("hl")
   static class198 field429;
   @ObfuscatedName("hs")
   @Export("boostedSkillLevels")
   static int[] field430;
   @ObfuscatedName("jd")
   static class172 field431;
   @ObfuscatedName("ho")
   static String[] field432;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -984223581
   )
   static int field433;
   @ObfuscatedName("hy")
   static int[] field434;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = -1552435313
   )
   @Export("menuOptionCount")
   static int field435;
   @ObfuscatedName("hf")
   static int[] field436;
   @ObfuscatedName("is")
   static int[] field437;
   @ObfuscatedName("mh")
   static String field438;
   @ObfuscatedName("iv")
   @Export("menuIdentifiers")
   static int[] field439;
   @ObfuscatedName("if")
   @Export("menuOptions")
   static String[] field440;
   @ObfuscatedName("ot")
   static short field441;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 867169309
   )
   static int field442;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 1978642741
   )
   static int field443;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -1567602395
   )
   static int field444;
   @ObfuscatedName("ia")
   @Export("menuTargets")
   static String[] field445;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1082936463
   )
   static int field446;
   @ObfuscatedName("it")
   static String field447;
   @ObfuscatedName("im")
   static boolean field448;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 539992771
   )
   static int field449;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -420963845
   )
   static int field450;
   @ObfuscatedName("ix")
   static String field451;
   @ObfuscatedName("iw")
   static String field452;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -1889456363
   )
   static int field453;
   @ObfuscatedName("iu")
   @Export("componentTable")
   static class195 field454;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -1442378571
   )
   static int field455;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -905470893
   )
   static int field456;
   @ObfuscatedName("ok")
   static short field457;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 60076685
   )
   @Export("energy")
   static int field458;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 966463829
   )
   static int field459;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 51300059
   )
   static int field460;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -2101114963
   )
   static int field461;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -248554019
   )
   static int field462;
   @ObfuscatedName("js")
   static boolean field463;
   @ObfuscatedName("jk")
   static boolean field464;
   @ObfuscatedName("jc")
   static class172 field465;
   @ObfuscatedName("jr")
   static class172 field466;
   @ObfuscatedName("kb")
   static int[] field467;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 157866639
   )
   static int field468;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 1055047087
   )
   static int field469;
   @ObfuscatedName("hn")
   @Export("isMenuOpen")
   static boolean field470;
   @ObfuscatedName("jb")
   static boolean field471;
   @ObfuscatedName("cm")
   static class121 field472;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 985576965
   )
   static int field473;
   @ObfuscatedName("jj")
   static boolean field474;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -625485205
   )
   static int field475;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 8637599
   )
   static int field476;
   @ObfuscatedName("cu")
   static class121 field477;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -1371369911
   )
   static int field478;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1622901233
   )
   static int field479;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -190740855
   )
   static int field480;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1485115123
   )
   static int field481;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1383305971
   )
   static int field482;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1861364633
   )
   static int field483;
   @ObfuscatedName("kq")
   static int[] field484;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -1354421073
   )
   static int field485;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -1832580067
   )
   static int field486;
   @ObfuscatedName("f")
   static boolean field487 = true;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -175353769
   )
   @Export("packetOpcode")
   static int field488;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 687026167
   )
   static int field489;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -1465079529
   )
   static int field490;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 123408743
   )
   static int field491;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -2123441735
   )
   static int field492;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1615743253
   )
   static int field493;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 2122460245
   )
   static int field494;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 1597874683
   )
   @Export("mapAngle")
   static int field495;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 1577769325
   )
   static int field496;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 1821650811
   )
   static int field497;
   @ObfuscatedName("jv")
   static boolean field498;
   @ObfuscatedName("li")
   static boolean[] field499;
   @ObfuscatedName("lc")
   static boolean[] field500;
   @ObfuscatedName("lj")
   static boolean[] field501;
   @ObfuscatedName("lv")
   @Export("widgetPositionX")
   static int[] field502;
   @ObfuscatedName("nq")
   static int[] field503;
   @ObfuscatedName("lx")
   static int[] field504;
   @ObfuscatedName("lu")
   static int[] field505;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1357088407
   )
   static int field506 = 0;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      longValue = 3445426103564822509L
   )
   static long field507;
   @ObfuscatedName("le")
   @Export("isResized")
   static boolean field508;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 1369902285
   )
   static int field509;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -1886297305
   )
   static int field510;
   @ObfuscatedName("oy")
   static int[] field511;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -2020050475
   )
   static int field512;
   @ObfuscatedName("ov")
   @Export("friends")
   static class17[] field513;
   @ObfuscatedName("lf")
   static String field514;
   @ObfuscatedName("lg")
   @Export("widgetPositionY")
   static int[] field515;
   @ObfuscatedName("ln")
   static int[] field516;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -383672681
   )
   static int field517;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = -1125096327
   )
   static int field518;
   @ObfuscatedName("mt")
   static int[] field519;
   @ObfuscatedName("he")
   static boolean[] field520;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -2048569797
   )
   static int field521;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1212662683
   )
   static int field522;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -1882396693
   )
   static int field523;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = -1321336769
   )
   static int field524;
   @ObfuscatedName("hg")
   static final int[] field525;
   @ObfuscatedName("mw")
   static int[] field526;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1363207799
   )
   @Export("world")
   static int field527 = 1;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = 2105639123
   )
   static int field528;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = -2016071225
   )
   static int field529;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = -567816311
   )
   static int field530;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 874222299
   )
   static int field531;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -214628369
   )
   static int field532;
   @ObfuscatedName("mm")
   static boolean field533;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 850569045
   )
   static int field534;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 987192917
   )
   static int field535;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -465606255
   )
   static int field536;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 2124529749
   )
   static int field537;
   @ObfuscatedName("nk")
   static int[] field538;
   @ObfuscatedName("nv")
   static int[] field539;
   @ObfuscatedName("r")
   static client field540;
   @ObfuscatedName("nh")
   static class58[] field541;
   @ObfuscatedName("nt")
   static boolean field542;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -482590489
   )
   static int field543;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -738237331
   )
   static int field544;
   @ObfuscatedName("ec")
   static class78[] field545;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 2033178713
   )
   @Export("mapScale")
   static int field546;
   @ObfuscatedName("ox")
   static int[] field547;
   @ObfuscatedName("mr")
   static int[] field548;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -957853557
   )
   static int field549;
   @ObfuscatedName("oq")
   static short field550;
   @ObfuscatedName("oe")
   static short field551;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -959777641
   )
   @Export("gameState")
   static int field552 = 0;
   @ObfuscatedName("ol")
   static short field553;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -544561447
   )
   static int field554;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -700704349
   )
   static int field555;
   @ObfuscatedName("og")
   static short field556;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 139262135
   )
   static int field557;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = 1811410655
   )
   static int field558;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -1040513165
   )
   @Export("camera2")
   static int field559;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 1018157665
   )
   @Export("camera3")
   static int field560;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -952253251
   )
   static int field561;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -962354895
   )
   static int field562;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      longValue = -6057364226273691565L
   )
   static long field563;
   @ObfuscatedName("cc")
   static int[] field564;
   @ObfuscatedName("ja")
   static boolean field565;
   @ObfuscatedName("jl")
   static class172 field566;
   @ObfuscatedName("oz")
   @Export("ignores")
   static class7[] field568;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -935483739
   )
   static int field569;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 555543749
   )
   static int field570;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -1478901211
   )
   static int field571;
   @ObfuscatedName("pn")
   @Export("grandExchangeOffers")
   static class219[] field572;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      longValue = -5097164720630892369L
   )
   static long field573;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      longValue = -4062804400528457847L
   )
   static long field574;
   @ObfuscatedName("fi")
   static int[] field575;
   @ObfuscatedName("pk")
   static int[] field576;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -449258725
   )
   static int field577;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "126"
   )
   @Export("packetHandler")
   protected final void vmethod3044() {
      ++field303;
      this.method256();
      class10.method147();
      class151.method3161();
      class10.method146();
      class29.method657();
      class123.method2786();
      int var1;
      if(class107.field1894 != null) {
         var1 = class107.field1894.vmethod3111();
         field492 = var1;
      }

      int var2;
      int var4;
      int var5;
      int var7;
      int var8;
      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      int var16;
      int var18;
      int var35;
      int var41;
      int var47;
      if(0 == field552) {
         class150.method3150();
         class147.method3130();
      } else if(5 == field552) {
         class130.method2849();
         class150.method3150();
         class147.method3130();
      } else if(10 != field552 && 11 != field552) {
         if(20 == field552) {
            class130.method2849();
            class22.method581();
         } else if(25 == field552) {
            class15.method197(false);
            field444 = 0;
            boolean var34 = true;

            for(var2 = 0; var2 < class185.field2994.length; ++var2) {
               if(-1 != class157.field2579[var2] && null == class185.field2994[var2]) {
                  class185.field2994[var2] = class49.field1088.method3263(class157.field2579[var2], 0);
                  if(null == class185.field2994[var2]) {
                     var34 = false;
                     ++field444;
                  }
               }

               if(-1 != class13.field190[var2] && class15.field214[var2] == null) {
                  class15.field214[var2] = class49.field1088.method3311(class13.field190[var2], 0, class16.field241[var2]);
                  if(null == class15.field214[var2]) {
                     var34 = false;
                     ++field444;
                  }
               }
            }

            if(!var34) {
               field351 = 1;
            } else {
               field349 = 0;
               var34 = true;

               for(var2 = 0; var2 < class185.field2994.length; ++var2) {
                  byte[] var3 = class15.field214[var2];
                  if(var3 != null) {
                     var4 = (class110.field1951[var2] >> 8) * 64 - class147.field2214;
                     var5 = 64 * (class110.field1951[var2] & 255) - class17.field257;
                     if(field353) {
                        var4 = 10;
                        var5 = 10;
                     }

                     var34 &= class45.method956(var3, var4, var5);
                  }
               }

               if(!var34) {
                  field351 = 2;
               } else {
                  if(0 != field351) {
                     class185.method3778("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class10.method146();
                  class180.method3545();
                  class10.method146();
                  class77.field1396.method1922();
                  class10.method146();
                  System.gc();

                  for(var2 = 0; var2 < 4; ++var2) {
                     field359[var2].method2396();
                  }

                  for(var2 = 0; var2 < 4; ++var2) {
                     for(var35 = 0; var35 < 104; ++var35) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           class5.field90[var2][var35][var4] = 0;
                        }
                     }
                  }

                  class10.method146();
                  class24.method596();
                  var2 = class185.field2994.length;
                  class3.method49();
                  class15.method197(true);
                  if(!field353) {
                     var35 = 0;

                     label4092:
                     while(true) {
                        byte[] var6;
                        if(var35 >= var2) {
                           for(var35 = 0; var35 < var2; ++var35) {
                              var4 = (class110.field1951[var35] >> 8) * 64 - class147.field2214;
                              var5 = (class110.field1951[var35] & 255) * 64 - class17.field257;
                              var6 = class185.field2994[var35];
                              if(var6 == null && class9.field148 < 800) {
                                 class10.method146();
                                 class3.method46(var4, var5, 64, 64);
                              }
                           }

                           class15.method197(true);
                           var35 = 0;

                           while(true) {
                              if(var35 >= var2) {
                                 break label4092;
                              }

                              byte[] var40 = class15.field214[var35];
                              if(var40 != null) {
                                 var5 = 64 * (class110.field1951[var35] >> 8) - class147.field2214;
                                 var41 = 64 * (class110.field1951[var35] & 255) - class17.field257;
                                 class10.method146();
                                 class170.method3413(var40, var5, var41, class77.field1396, field359);
                              }

                              ++var35;
                           }
                        }

                        var4 = 64 * (class110.field1951[var35] >> 8) - class147.field2214;
                        var5 = (class110.field1951[var35] & 255) * 64 - class17.field257;
                        var6 = class185.field2994[var35];
                        if(var6 != null) {
                           class10.method146();
                           var7 = class38.field873 * 8 - 48;
                           var8 = class9.field148 * 8 - 48;
                           class107[] var9 = field359;
                           var10 = 0;

                           label4089:
                           while(true) {
                              if(var10 >= 4) {
                                 class118 var51 = new class118(var6);
                                 var11 = 0;

                                 while(true) {
                                    if(var11 >= 4) {
                                       break label4089;
                                    }

                                    for(var12 = 0; var12 < 64; ++var12) {
                                       for(var13 = 0; var13 < 64; ++var13) {
                                          class13.method181(var51, var11, var12 + var4, var13 + var5, var7, var8, 0);
                                       }
                                    }

                                    ++var11;
                                 }
                              }

                              for(var11 = 0; var11 < 64; ++var11) {
                                 for(var12 = 0; var12 < 64; ++var12) {
                                    if(var4 + var11 > 0 && var4 + var11 < 103 && var5 + var12 > 0 && var5 + var12 < 103) {
                                       var9[var10].field1888[var11 + var4][var5 + var12] &= -16777217;
                                    }
                                 }
                              }

                              ++var10;
                           }
                        }

                        ++var35;
                     }
                  }

                  if(field353) {
                     var35 = 0;

                     label4038:
                     while(true) {
                        if(var35 >= 4) {
                           for(var35 = 0; var35 < 13; ++var35) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = field354[0][var35][var4];
                                 if(var5 == -1) {
                                    class3.method46(var35 * 8, var4 * 8, 8, 8);
                                 }
                              }
                           }

                           class15.method197(true);
                           var35 = 0;

                           while(true) {
                              if(var35 >= 4) {
                                 break label4038;
                              }

                              class10.method146();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var41 = field354[var35][var4][var5];
                                    if(var41 != -1) {
                                       var7 = var41 >> 24 & 3;
                                       var8 = var41 >> 1 & 3;
                                       var47 = var41 >> 14 & 1023;
                                       var10 = var41 >> 3 & 2047;
                                       var11 = var10 / 8 + (var47 / 8 << 8);

                                       for(var12 = 0; var12 < class110.field1951.length; ++var12) {
                                          if(var11 == class110.field1951[var12] && null != class15.field214[var12]) {
                                             class136.method2926(class15.field214[var12], var35, var4 * 8, var5 * 8, var7, 8 * (var47 & 7), 8 * (var10 & 7), var8, class77.field1396, field359);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var35;
                           }
                        }

                        class10.method146();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var42 = false;
                              var7 = field354[var35][var4][var5];
                              if(-1 != var7) {
                                 var8 = var7 >> 24 & 3;
                                 var47 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(var13 = 0; var13 < class110.field1951.length; ++var13) {
                                    if(var12 == class110.field1951[var13] && class185.field2994[var13] != null) {
                                       byte[] var14 = class185.field2994[var13];
                                       var15 = var4 * 8;
                                       var16 = 8 * var5;
                                       int var17 = (var10 & 7) * 8;
                                       var18 = (var11 & 7) * 8;
                                       class107[] var19 = field359;

                                       int var21;
                                       for(int var20 = 0; var20 < 8; ++var20) {
                                          for(var21 = 0; var21 < 8; ++var21) {
                                             if(var20 + var15 > 0 && var15 + var20 < 103 && var16 + var21 > 0 && var16 + var21 < 103) {
                                                var19[var35].field1888[var15 + var20][var16 + var21] &= -16777217;
                                             }
                                          }
                                       }

                                       class118 var113 = new class118(var14);

                                       for(var21 = 0; var21 < 4; ++var21) {
                                          for(int var22 = 0; var22 < 64; ++var22) {
                                             for(int var23 = 0; var23 < 64; ++var23) {
                                                if(var8 == var21 && var22 >= var17 && var22 < var17 + 8 && var23 >= var18 && var23 < var18 + 8) {
                                                   class13.method181(var113, var35, var15 + class5.method100(var22 & 7, var23 & 7, var47), var16 + class14.method187(var22 & 7, var23 & 7, var47), 0, 0, var47);
                                                } else {
                                                   class13.method181(var113, 0, -1, -1, 0, 0, 0);
                                                }
                                             }
                                          }
                                       }

                                       var42 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var42) {
                                 var8 = var35;
                                 var47 = 8 * var4;
                                 var10 = var5 * 8;

                                 for(var11 = 0; var11 < 8; ++var11) {
                                    for(var12 = 0; var12 < 8; ++var12) {
                                       class5.field86[var8][var47 + var11][var10 + var12] = 0;
                                    }
                                 }

                                 if(var47 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class5.field86[var8][var47][var10 + var11] = class5.field86[var8][var47 - 1][var10 + var11];
                                    }
                                 }

                                 if(var10 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class5.field86[var8][var47 + var11][var10] = class5.field86[var8][var47 + var11][var10 - 1];
                                    }
                                 }

                                 if(var47 > 0 && 0 != class5.field86[var8][var47 - 1][var10]) {
                                    class5.field86[var8][var47][var10] = class5.field86[var8][var47 - 1][var10];
                                 } else if(var10 > 0 && class5.field86[var8][var47][var10 - 1] != 0) {
                                    class5.field86[var8][var47][var10] = class5.field86[var8][var47][var10 - 1];
                                 } else if(var47 > 0 && var10 > 0 && 0 != class5.field86[var8][var47 - 1][var10 - 1]) {
                                    class5.field86[var8][var47][var10] = class5.field86[var8][var47 - 1][var10 - 1];
                                 }
                              }
                           }
                        }

                        ++var35;
                     }
                  }

                  class15.method197(true);
                  class180.method3545();
                  class10.method146();
                  class142.method3018(class77.field1396, field359);
                  class15.method197(true);
                  var35 = class5.field72;
                  if(var35 > class48.field1078) {
                     var35 = class48.field1078;
                  }

                  if(var35 < class48.field1078 - 1) {
                     var35 = class48.field1078 - 1;
                  }

                  if(field297) {
                     class77.field1396.method1929(class5.field72);
                  } else {
                     class77.field1396.method1929(0);
                  }

                  for(var4 = 0; var4 < 104; ++var4) {
                     for(var5 = 0; var5 < 104; ++var5) {
                        class166.method3355(var4, var5);
                     }
                  }

                  class10.method146();
                  class11.method168();
                  class40.field933.method3800();
                  if(class59.field1217 != null) {
                     field301.method2753(27);
                     field301.method2663(1057001181);
                  }

                  if(!field353) {
                     var4 = (class38.field873 - 6) / 8;
                     var5 = (class38.field873 + 6) / 8;
                     var41 = (class9.field148 - 6) / 8;
                     var7 = (class9.field148 + 6) / 8;

                     for(var8 = var4 - 1; var8 <= 1 + var5; ++var8) {
                        for(var47 = var41 - 1; var47 <= 1 + var7; ++var47) {
                           if(var8 < var4 || var8 > var5 || var47 < var41 || var47 > var7) {
                              class49.field1088.method3283("m" + var8 + "_" + var47);
                              class49.field1088.method3283("l" + var8 + "_" + var47);
                           }
                        }
                     }
                  }

                  class1.method9(30);
                  class10.method146();
                  class5.field74 = (byte[][][])null;
                  class5.field75 = (byte[][][])null;
                  class5.field76 = (byte[][][])null;
                  class5.field73 = (byte[][][])null;
                  class5.field80 = (int[][][])null;
                  class5.field78 = (byte[][][])null;
                  class5.field71 = (int[][])null;
                  class72.field1351 = null;
                  class169.field2697 = null;
                  class209.field3119 = null;
                  class16.field240 = null;
                  class219.field3166 = null;
                  field301.method2753(30);
                  class147.method3130();
               }
            }
         }
      } else {
         class130.method2849();
      }

      if(field552 == 30) {
         if(field310 > 1) {
            --field310;
         }

         if(field345 > 0) {
            --field345;
         }

         if(field346) {
            field346 = false;
            if(field345 > 0) {
               class212.method3982();
            } else {
               class1.method9(40);
               class133.field2069 = class178.field2912;
               class178.field2912 = null;
            }
         } else {
            if(!field470) {
               field440[0] = "Cancel";
               field445[0] = "";
               field302[0] = 1006;
               field435 = 1;
            }

            class172 var50;
            long var54;
            String var56;
            class172 var57;
            String var59;
            String var75;
            class172 var87;
            String var90;
            int var91;
            for(var1 = 0; var1 < 100; ++var1) {
               boolean var38;
               if(class178.field2912 == null) {
                  var38 = false;
               } else {
                  label4323: {
                     String var48;
                     try {
                        var35 = class178.field2912.method3001();
                        if(var35 == 0) {
                           var38 = false;
                           break label4323;
                        }

                        if(field488 == -1) {
                           class178.field2912.method3002(field472.field1980, 0, 1);
                           field472.field1979 = 0;
                           field488 = field472.method2752();
                           field569 = class187.field3029[field488];
                           --var35;
                        }

                        if(field569 == -1) {
                           if(var35 <= 0) {
                              var38 = false;
                              break label4323;
                           }

                           class178.field2912.method3002(field472.field1980, 0, 1);
                           field569 = field472.field1980[0] & 255;
                           --var35;
                        }

                        if(field569 == -2) {
                           if(var35 <= 1) {
                              var38 = false;
                              break label4323;
                           }

                           class178.field2912.method3002(field472.field1980, 0, 2);
                           field472.field1979 = 0;
                           field569 = field472.method2514();
                           var35 -= 2;
                        }

                        if(var35 < field569) {
                           var38 = false;
                           break label4323;
                        }

                        field472.field1979 = 0;
                        class178.field2912.method3002(field472.field1980, 0, field569);
                        field340 = 0;
                        field344 = field343;
                        field343 = field342 * -1;
                        field342 = field488 * -1;
                        if(field488 == 227) {
                           class39.method803(false);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 111) {
                           var4 = field472.method2547();
                           var5 = field472.method2690();
                           var41 = field472.method2517();
                           var50 = class92.method2180(var41);
                           var50.field2797 = var5 + (var4 << 16);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(169 == field488) {
                           var4 = field472.method2579();
                           if(field472.method2579() == 0) {
                              field572[var4] = new class219();
                              field472.field1979 += 18;
                           } else {
                              --field472.field1979;
                              field572[var4] = new class219(field472, false);
                           }

                           field489 = field479;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 122) {
                           class7.field126 = class15.method195(field472.method2579());
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(199 == field488) {
                           var4 = field472.method2579();
                           var75 = field472.method2520();
                           var41 = field472.method2642();
                           if(var41 >= 1 && var41 <= 8) {
                              if(var75.equalsIgnoreCase("null")) {
                                 var75 = null;
                              }

                              field432[var41 - 1] = var75;
                              field520[var41 - 1] = 0 == var4;
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 184 || 244 == field488 || field488 == 108 || field488 == 112 || 96 == field488 || 240 == field488 || field488 == 100 || 117 == field488 || field488 == 200 || field488 == 215) {
                           class16.method199();
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        class172 var45;
                        if(field488 == 247) {
                           var4 = field472.method2515();
                           var5 = field472.method2555();
                           var45 = class92.method2180(var5);
                           if(var4 != var45.field2788 || -1 == var4) {
                              var45.field2788 = var4;
                              var45.field2808 = 0;
                              var45.field2864 = 0;
                              class36.method745(var45);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        long var49;
                        long var97;
                        String var109;
                        int var111;
                        if(field488 == 144) {
                           var48 = field472.method2520();
                           var54 = (long)field472.method2514();
                           var49 = (long)field472.method2516();
                           class151 var112 = (class151)class155.method3174(class211.method3970(), field472.method2579());
                           var97 = (var54 << 32) + var49;
                           boolean var98 = false;

                           for(var13 = 0; var13 < 100; ++var13) {
                              if(field339[var13] == var97) {
                                 var98 = true;
                                 break;
                              }
                           }

                           if(class26.method635(var48)) {
                              var98 = true;
                           }

                           if(!var98 && field414 == 0) {
                              field339[field561] = var97;
                              field561 = (field561 + 1) % 100;
                              class121 var99 = field472;

                              try {
                                 var16 = var99.method2659();
                                 if(var16 > 32767) {
                                    var16 = 32767;
                                 }

                                 byte[] var105 = new byte[var16];
                                 var99.field1979 += class221.field3177.method2441(var99.field1980, var99.field1979, var105, 0, var16);
                                 var109 = class47.method1009(var105, 0, var16);
                                 var90 = var109;
                              } catch (Exception var28) {
                                 var90 = "Cabbage";
                              }

                              var90 = class222.method4130(class188.method3784(var90));
                              byte var101;
                              if(var112.field2249) {
                                 var101 = 7;
                              } else {
                                 var101 = 3;
                              }

                              if(-1 != var112.field2248) {
                                 var111 = var112.field2248;
                                 var109 = "<img=" + var111 + ">";
                                 class137.method2943(var101, var109 + var48, var90);
                              } else {
                                 class137.method2943(var101, var48, var90);
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        long var69;
                        boolean var82;
                        if(17 == field488) {
                           field544 = field479;
                           if(0 == field569) {
                              field438 = null;
                              field314 = null;
                              class9.field151 = 0;
                              class42.field1003 = null;
                              field488 = -1;
                              var38 = true;
                              break label4323;
                           }

                           field314 = field472.method2520();
                           long var129 = field472.method2518();
                           var49 = var129;
                           if(var129 > 0L && var129 < 6582952005840035281L) {
                              if(var129 % 37L == 0L) {
                                 var59 = null;
                              } else {
                                 var47 = 0;

                                 for(var97 = var129; 0L != var97; var97 /= 37L) {
                                    ++var47;
                                 }

                                 StringBuilder var89 = new StringBuilder(var47);

                                 while(var49 != 0L) {
                                    var69 = var49;
                                    var49 /= 37L;
                                    var89.append(class161.field2630[(int)(var69 - var49 * 37L)]);
                                 }

                                 var59 = var89.reverse().toString();
                              }
                           } else {
                              var59 = null;
                           }

                           field438 = var59;
                           class12.field184 = field472.method2707();
                           var47 = field472.method2579();
                           if(255 == var47) {
                              field488 = -1;
                              var38 = true;
                              break label4323;
                           }

                           class9.field151 = var47;
                           class24[] var102 = new class24[100];

                           for(var11 = 0; var11 < class9.field151; ++var11) {
                              var102[var11] = new class24();
                              var102[var11].field624 = field472.method2520();
                              var102[var11].field627 = class128.method2832(var102[var11].field624, class132.field2062);
                              var102[var11].field629 = field472.method2514();
                              var102[var11].field626 = field472.method2707();
                              field472.method2520();
                              if(var102[var11].field624.equals(class151.field2253.field40)) {
                                 class10.field162 = var102[var11].field626;
                              }
                           }

                           var82 = false;
                           var13 = class9.field151;

                           while(var13 > 0) {
                              var82 = true;
                              --var13;

                              for(var91 = 0; var91 < var13; ++var91) {
                                 if(var102[var91].field627.compareTo(var102[1 + var91].field627) > 0) {
                                    class24 var96 = var102[var91];
                                    var102[var91] = var102[1 + var91];
                                    var102[var91 + 1] = var96;
                                    var82 = false;
                                 }
                              }

                              if(var82) {
                                 break;
                              }
                           }

                           class42.field1003 = var102;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 24) {
                           field530 = field472.method2579();
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 7) {
                           var4 = field472.method2556();
                           class72.field1356 = class129.field2056.method2880(var4);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(180 == field488) {
                           class4.field66 = field472.method2538();
                           class6.field124 = field472.method2579();

                           while(field472.field1979 < field569) {
                              field488 = field472.method2579();
                              class16.method199();
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(20 == field488) {
                           field542 = true;
                           class18.field275 = field472.method2579();
                           field543 = field472.method2579();
                           class10.field160 = field472.method2514();
                           class170.field2724 = field472.method2579();
                           class148.field2215 = field472.method2579();
                           if(class148.field2215 >= 100) {
                              var4 = 64 + class18.field275 * 128;
                              var5 = field543 * 128 + 64;
                              var41 = class4.method52(var4, var5, class48.field1078) - class10.field160;
                              var7 = var4 - class44.field1037;
                              var8 = var41 - class30.field713;
                              var47 = var5 - class17.field254;
                              var10 = (int)Math.sqrt((double)(var47 * var47 + var7 * var7));
                              class15.field219 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                              class13.field193 = (int)(Math.atan2((double)var7, (double)var47) * -325.949D) & 2047;
                              if(class15.field219 < 128) {
                                 class15.field219 = 128;
                              }

                              if(class15.field219 > 383) {
                                 class15.field219 = 383;
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(158 == field488) {
                           var4 = field472.method2547();
                           if('\uffff' == var4) {
                              var4 = -1;
                           }

                           if(var4 == -1 && !field533) {
                              class182.field2942.method3628();
                              class182.field2947 = 1;
                              class182.field2946 = null;
                           } else if(var4 != -1 && var4 != field532 && 0 != field531 && !field533) {
                              class35.method735(2, class129.field2054, var4, 0, field531, false);
                           }

                           field532 = var4;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 59) {
                           var4 = field472.method2546();
                           if(var4 == '\uffff') {
                              var4 = -1;
                           }

                           var5 = field472.method2678();
                           class27.method644(var4);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(172 == field488) {
                           class39.method802(false);
                           field472.method2752();
                           var4 = field472.method2514();
                           class25.method630(field472, var4);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(149 == field488) {
                           class39.method802(true);
                           field472.method2752();
                           var4 = field472.method2514();
                           class25.method630(field472, var4);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        class3 var55;
                        class172 var93;
                        if(field488 == 104) {
                           var4 = field472.method2556();
                           var5 = field472.method2556();
                           class3 var124 = (class3)field454.method3824((long)var4);
                           var55 = (class3)field454.method3824((long)var5);
                           if(var55 != null) {
                              class112.method2446(var55, var124 == null || var55.field56 != var124.field56);
                           }

                           if(var124 != null) {
                              var124.method3946();
                              field454.method3831(var124, (long)var5);
                           }

                           var93 = class92.method2180(var4);
                           if(var93 != null) {
                              class36.method745(var93);
                           }

                           var93 = class92.method2180(var5);
                           if(var93 != null) {
                              class36.method745(var93);
                              class1.method14(class172.field2850[var93.field2800 * -1 >>> 16], var93, true);
                           }

                           if(field453 != -1) {
                              var47 = field453;
                              if(class103.method2303(var47)) {
                                 class134.method2879(class172.field2850[var47], 1);
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        boolean var70;
                        if(field488 == 10) {
                           var48 = field472.method2520();
                           var5 = field472.method2514();
                           byte var122 = field472.method2707();
                           var70 = false;
                           if(var122 == -128) {
                              var70 = true;
                           }

                           if(var70) {
                              if(0 == class9.field151) {
                                 field488 = -1;
                                 var38 = true;
                                 break label4323;
                              }

                              boolean var107 = false;

                              for(var8 = 0; var8 < class9.field151 && (!class42.field1003[var8].field624.equals(var48) || class42.field1003[var8].field629 != var5); ++var8) {
                                 ;
                              }

                              if(var8 < class9.field151) {
                                 while(var8 < class9.field151 - 1) {
                                    class42.field1003[var8] = class42.field1003[1 + var8];
                                    ++var8;
                                 }

                                 --class9.field151;
                                 class42.field1003[class9.field151] = null;
                              }
                           } else {
                              field472.method2520();
                              class24 var106 = new class24();
                              var106.field624 = var48;
                              var106.field627 = class128.method2832(var106.field624, class132.field2062);
                              var106.field629 = var5;
                              var106.field626 = var122;

                              for(var47 = class9.field151 - 1; var47 >= 0; --var47) {
                                 var10 = class42.field1003[var47].field627.compareTo(var106.field627);
                                 if(0 == var10) {
                                    class42.field1003[var47].field629 = var5;
                                    class42.field1003[var47].field626 = var122;
                                    if(var48.equals(class151.field2253.field40)) {
                                       class10.field162 = var122;
                                    }

                                    field544 = field479;
                                    field488 = -1;
                                    var38 = true;
                                    break label4323;
                                 }

                                 if(var10 < 0) {
                                    break;
                                 }
                              }

                              if(class9.field151 >= class42.field1003.length) {
                                 field488 = -1;
                                 var38 = true;
                                 break label4323;
                              }

                              for(var10 = class9.field151 - 1; var10 > var47; --var10) {
                                 class42.field1003[var10 + 1] = class42.field1003[var10];
                              }

                              if(class9.field151 == 0) {
                                 class42.field1003 = new class24[100];
                              }

                              class42.field1003[1 + var47] = var106;
                              ++class9.field151;
                              if(var48.equals(class151.field2253.field40)) {
                                 class10.field162 = var122;
                              }
                           }

                           field544 = field479;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        long var53;
                        if(field488 == 32) {
                           var4 = field472.method2546();
                           if('\uffff' == var4) {
                              var4 = -1;
                           }

                           var5 = field472.method2645();
                           var41 = field472.method2546();
                           if(var41 == '\uffff') {
                              var41 = -1;
                           }

                           var7 = field472.method2555();

                           for(var8 = var41; var8 <= var4; ++var8) {
                              var53 = (long)var8 + ((long)var7 << 32);
                              class207 var92 = field366.method3824(var53);
                              if(var92 != null) {
                                 var92.method3946();
                              }

                              field366.method3831(new class200(var5), var53);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 234) {
                           field369 = 1;
                           field496 = field479;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(69 == field488) {
                           var4 = field472.method2517();
                           var5 = field472.method2517();
                           if(class24.field628 == null || !class24.field628.isValid()) {
                              try {
                                 Iterator var117 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                                 while(var117.hasNext()) {
                                    GarbageCollectorMXBean var118 = (GarbageCollectorMXBean)var117.next();
                                    if(var118.isValid()) {
                                       class24.field628 = var118;
                                       field574 = -1L;
                                       field573 = -1L;
                                    }
                                 }
                              } catch (Throwable var31) {
                                 ;
                              }
                           }

                           long var120 = class18.method214();
                           var8 = -1;
                           if(class24.field628 != null) {
                              var53 = class24.field628.getCollectionTime();
                              if(-1L != field573) {
                                 long var85 = var53 - field573;
                                 var69 = var120 - field574;
                                 if(var69 != 0L) {
                                    var8 = (int)(100L * var85 / var69);
                                 }
                              }

                              field573 = var53;
                              field574 = var120;
                           }

                           field301.method2753(186);
                           field301.method2497(class143.field2178);
                           field301.method2673(var4);
                           field301.method2552(var5);
                           field301.method2535(var8);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 28) {
                           class124.method2807(field472);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(73 == field488) {
                           var4 = field472.method2690();
                           var5 = field472.method2555();
                           var41 = field472.method2514();
                           var7 = field472.method2690();
                           var93 = class92.method2180(var5);
                           if(var93.field2792 != var41 || var7 != var93.field2802 || var93.field2795 != var4) {
                              var93.field2792 = var41;
                              var93.field2802 = var7;
                              var93.field2795 = var4;
                              class36.method745(var93);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 19) {
                           var4 = field472.method2690();
                           field453 = var4;
                           var5 = field453;
                           var41 = class6.field107;
                           var7 = class31.field749;
                           if(class103.method2303(var5)) {
                              class1.method11(class172.field2850[var5], -1, var41, var7, false);
                           }

                           class74.method1635(var4);
                           class106.method2387(field453);

                           for(var5 = 0; var5 < 100; ++var5) {
                              field499[var5] = true;
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(248 == field488) {
                           var48 = field472.method2520();
                           Object[] var123 = new Object[var48.length() + 1];

                           for(var41 = var48.length() - 1; var41 >= 0; --var41) {
                              if(var48.charAt(var41) == 115) {
                                 var123[var41 + 1] = field472.method2520();
                              } else {
                                 var123[var41 + 1] = new Integer(field472.method2517());
                              }
                           }

                           var123[0] = new Integer(field472.method2517());
                           class0 var114 = new class0();
                           var114.field8 = var123;
                           class150.method3148(var114);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        boolean var67;
                        boolean var104;
                        if(field488 == 120) {
                           while(field472.field1979 < field569) {
                              var104 = field472.method2579() == 1;
                              var75 = field472.method2520();
                              var59 = field472.method2520();
                              var7 = field472.method2514();
                              var8 = field472.method2579();
                              var47 = field472.method2579();
                              boolean var74 = (var47 & 2) != 0;
                              var82 = 0 != (var47 & 1);
                              if(var7 > 0) {
                                 field472.method2520();
                                 field472.method2579();
                                 field472.method2517();
                              }

                              field472.method2520();

                              for(var12 = 0; var12 < field562; ++var12) {
                                 class17 var66 = field513[var12];
                                 if(!var104) {
                                    if(var75.equals(var66.field261)) {
                                       if(var7 != var66.field249) {
                                          var67 = true;

                                          for(class38 var83 = (class38)field428.method3817(); null != var83; var83 = (class38)field428.method3818()) {
                                             if(var83.field872.equals(var75)) {
                                                if(var7 != 0 && var83.field874 == 0) {
                                                   var83.method3940();
                                                   var67 = false;
                                                } else if(0 == var7 && var83.field874 != 0) {
                                                   var83.method3940();
                                                   var67 = false;
                                                }
                                             }
                                          }

                                          if(var67) {
                                             field428.method3816(new class38(var75, var7));
                                          }

                                          var66.field249 = var7;
                                       }

                                       var66.field248 = var59;
                                       var66.field250 = var8;
                                       var66.field251 = var74;
                                       var66.field263 = var82;
                                       var75 = null;
                                       break;
                                    }
                                 } else if(var59.equals(var66.field261)) {
                                    var66.field261 = var75;
                                    var66.field248 = var59;
                                    var75 = null;
                                    break;
                                 }
                              }

                              if(var75 != null && field562 < 400) {
                                 class17 var84 = new class17();
                                 field513[field562] = var84;
                                 var84.field261 = var75;
                                 var84.field248 = var59;
                                 var84.field249 = var7;
                                 var84.field250 = var8;
                                 var84.field251 = var74;
                                 var84.field263 = var82;
                                 ++field562;
                              }
                           }

                           field369 = 2;
                           field496 = field479;
                           var104 = false;
                           var5 = field562;

                           while(var5 > 0) {
                              var104 = true;
                              --var5;

                              for(var41 = 0; var41 < var5; ++var41) {
                                 var70 = false;
                                 class17 var86 = field513[var41];
                                 class17 var94 = field513[1 + var41];
                                 if(var86.field249 != field527 && var94.field249 == field527) {
                                    var70 = true;
                                 }

                                 if(!var70 && var86.field249 == 0 && 0 != var94.field249) {
                                    var70 = true;
                                 }

                                 if(!var70 && !var86.field251 && var94.field251) {
                                    var70 = true;
                                 }

                                 if(!var70 && !var86.field263 && var94.field263) {
                                    var70 = true;
                                 }

                                 if(var70) {
                                    class17 var78 = field513[var41];
                                    field513[var41] = field513[1 + var41];
                                    field513[1 + var41] = var78;
                                    var104 = false;
                                 }
                              }

                              if(var104) {
                                 break;
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 110) {
                           var4 = field472.method2514();
                           if(var4 == '\uffff') {
                              var4 = -1;
                           }

                           var5 = field472.method2517();
                           var41 = field472.method2645();
                           var50 = class92.method2180(var5);
                           class51 var77;
                           if(!var50.field2742) {
                              if(var4 == -1) {
                                 var50.field2784 = 0;
                                 field488 = -1;
                                 var38 = true;
                                 break label4323;
                              }

                              var77 = class75.method1648(var4);
                              var50.field2784 = 4;
                              var50.field2846 = var4;
                              var50.field2792 = var77.field1141;
                              var50.field2802 = var77.field1122;
                              var50.field2795 = var77.field1127 * 100 / var41;
                              class36.method745(var50);
                           } else {
                              var50.field2834 = var4;
                              var50.field2862 = var41;
                              var77 = class75.method1648(var4);
                              var50.field2792 = var77.field1141;
                              var50.field2802 = var77.field1122;
                              var50.field2794 = var77.field1149;
                              var50.field2790 = var77.field1124;
                              var50.field2793 = var77.field1125;
                              var50.field2795 = var77.field1127;
                              if(var77.field1126 == 1) {
                                 var50.field2839 = 1;
                              } else {
                                 var50.field2839 = 2;
                              }

                              if(var50.field2796 > 0) {
                                 var50.field2795 = var50.field2795 * 32 / var50.field2796;
                              } else if(var50.field2783 > 0) {
                                 var50.field2795 = var50.field2795 * 32 / var50.field2783;
                              }

                              class36.method745(var50);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 87) {
                           class83.method1909(field472.method2520());
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 186) {
                           var4 = field472.method2517();
                           var5 = field472.method2514();
                           if(var4 < -70000) {
                              var5 += '耀';
                           }

                           if(var4 >= 0) {
                              var45 = class92.method2180(var4);
                           } else {
                              var45 = null;
                           }

                           for(; field472.field1979 < field569; class118.method2582(var5, var7, var8 - 1, var47)) {
                              var7 = field472.method2659();
                              var8 = field472.method2514();
                              var47 = 0;
                              if(var8 != 0) {
                                 var47 = field472.method2579();
                                 if(255 == var47) {
                                    var47 = field472.method2517();
                                 }
                              }

                              if(null != var45 && var7 >= 0 && var7 < var45.field2859.length) {
                                 var45.field2859[var7] = var8;
                                 var45.field2860[var7] = var47;
                              }
                           }

                           if(null != var45) {
                              class36.method745(var45);
                           }

                           class46.method990();
                           field467[++field483 - 1 & 31] = var5 & 32767;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(250 == field488) {
                           class46.method990();
                           var4 = field472.method2538();
                           var5 = field472.method2538();
                           var41 = field472.method2517();
                           field290[var4] = var41;
                           field430[var4] = var5;
                           field337[var4] = 1;

                           for(var7 = 0; var7 < 98; ++var7) {
                              if(var41 >= class154.field2279[var7]) {
                                 field337[var4] = var7 + 2;
                              }
                           }

                           field484[++field485 - 1 & 31] = var4;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 36) {
                           field311 = field472.method2579();
                           if(1 == field311) {
                              field312 = field472.method2514();
                           }

                           if(field311 >= 2 && field311 <= 6) {
                              if(field311 == 2) {
                                 field289 = 64;
                                 field318 = 64;
                              }

                              if(field311 == 3) {
                                 field289 = 0;
                                 field318 = 64;
                              }

                              if(4 == field311) {
                                 field289 = 128;
                                 field318 = 64;
                              }

                              if(field311 == 5) {
                                 field289 = 64;
                                 field318 = 0;
                              }

                              if(field311 == 6) {
                                 field289 = 64;
                                 field318 = 128;
                              }

                              field311 = 2;
                              field418 = field472.method2514();
                              field315 = field472.method2514();
                              field316 = field472.method2579();
                           }

                           if(field311 == 10) {
                              field313 = field472.method2514();
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 121) {
                           field512 = field472.method2579();
                           field482 = field472.method2579();
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 118) {
                           var4 = field472.method2555();
                           var87 = class92.method2180(var4);
                           var87.field2784 = 3;
                           var87.field2846 = class151.field2253.field43.method3521();
                           class36.method745(var87);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 147) {
                           field310 = field472.method2690() * 30;
                           field491 = field479;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(229 == field488) {
                           class212.method3982();
                           field488 = -1;
                           var38 = false;
                           break label4323;
                        }

                        if(35 == field488) {
                           field472.field1979 += 28;
                           if(field472.method2534()) {
                              class121 var125 = field472;
                              var5 = field472.field1979 - 28;
                              if(class148.field2223 != null) {
                                 try {
                                    class148.field2223.method4173(0L);
                                    class148.field2223.method4195(var125.field1980, var5, 24);
                                 } catch (Exception var27) {
                                    ;
                                 }
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 58) {
                           var4 = field472.method2514();
                           var5 = field472.method2579();
                           var41 = field472.method2514();
                           if(field534 != 0 && var5 != 0 && field536 < 50) {
                              field326[field536] = var4;
                              field538[field536] = var5;
                              field539[field536] = var41;
                              field541[field536] = null;
                              field503[field536] = 0;
                              ++field536;
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(195 == field488) {
                           var4 = field472.method2547();
                           class100.method2289(var4);
                           field467[++field483 - 1 & 31] = var4 & 32767;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 93) {
                           if(-1 != field453) {
                              var4 = field453;
                              if(class103.method2303(var4)) {
                                 class134.method2879(class172.field2850[var4], 0);
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(25 == field488) {
                           class46.method990();
                           field336 = field472.method2515();
                           field491 = field479;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(179 == field488) {
                           var104 = field472.method2579() == 1;
                           var5 = field472.method2556();
                           var45 = class92.method2180(var5);
                           if(var104 != var45.field2763) {
                              var45.field2763 = var104;
                              class36.method745(var45);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 218) {
                           var4 = field472.method2579();
                           var5 = field472.method2579();
                           var41 = field472.method2579();
                           var7 = field472.method2579();
                           field390[var4] = true;
                           field425[var4] = var5;
                           field511[var4] = var41;
                           field547[var4] = var7;
                           field422[var4] = 0;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(175 == field488) {
                           class6.field124 = field472.method2538();
                           class4.field66 = field472.method2540();

                           for(var4 = class4.field66; var4 < 8 + class4.field66; ++var4) {
                              for(var5 = class6.field124; var5 < class6.field124 + 8; ++var5) {
                                 if(null != field419[class48.field1078][var4][var5]) {
                                    field419[class48.field1078][var4][var5] = null;
                                    class166.method3355(var4, var5);
                                 }
                              }
                           }

                           for(class16 var121 = (class16)field427.method3860(); var121 != null; var121 = (class16)field427.method3861()) {
                              if(var121.field229 >= class4.field66 && var121.field229 < class4.field66 + 8 && var121.field244 >= class6.field124 && var121.field244 < 8 + class6.field124 && class48.field1078 == var121.field236) {
                                 var121.field238 = 0;
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 187) {
                           class46.method990();
                           field458 = field472.method2579();
                           field491 = field479;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 245) {
                           for(var4 = 0; var4 < class52.field1157; ++var4) {
                              class52 var95 = class5.method101(var4);
                              if(var95 != null) {
                                 class175.field2891[var4] = 0;
                                 class175.field2890[var4] = 0;
                              }
                           }

                           class46.method990();
                           field481 += 32;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(151 == field488) {
                           for(var4 = 0; var4 < field415.length; ++var4) {
                              if(field415[var4] != null) {
                                 field415[var4].field869 = -1;
                              }
                           }

                           for(var4 = 0; var4 < field358.length; ++var4) {
                              if(null != field358[var4]) {
                                 field358[var4].field869 = -1;
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(129 == field488) {
                           var4 = field472.method2645();
                           var87 = class92.method2180(var4);

                           for(var41 = 0; var41 < var87.field2859.length; ++var41) {
                              var87.field2859[var41] = -1;
                              var87.field2859[var41] = 0;
                           }

                           class36.method745(var87);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        String var44;
                        boolean var81;
                        if(field488 == 181) {
                           while(field472.field1979 < field569) {
                              var4 = field472.method2579();
                              var81 = 1 == (var4 & 1);
                              var59 = field472.method2520();
                              var44 = field472.method2520();
                              field472.method2520();

                              for(var8 = 0; var8 < field509; ++var8) {
                                 class7 var64 = field568[var8];
                                 if(var81) {
                                    if(var44.equals(var64.field129)) {
                                       var64.field129 = var59;
                                       var64.field125 = var44;
                                       var59 = null;
                                       break;
                                    }
                                 } else if(var59.equals(var64.field129)) {
                                    var64.field129 = var59;
                                    var64.field125 = var44;
                                    var59 = null;
                                    break;
                                 }
                              }

                              if(null != var59 && field509 < 400) {
                                 class7 var71 = new class7();
                                 field568[field509] = var71;
                                 var71.field129 = var59;
                                 var71.field125 = var44;
                                 ++field509;
                              }
                           }

                           field496 = field479;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 30) {
                           class130.method2851();

                           for(var4 = 0; var4 < 2048; ++var4) {
                              field415[var4] = null;
                           }

                           class172.method3414(field472);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 4) {
                           var104 = field472.method2579() == 1;
                           if(var104) {
                              class50.field1096 = class18.method214() - field472.method2518();
                              class165.field2653 = new class220(field472, true);
                           } else {
                              class165.field2653 = null;
                           }

                           field490 = field479;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 123) {
                           var4 = field472.method2659();
                           var81 = field472.method2579() == 1;
                           var59 = "";
                           var70 = false;
                           if(var81) {
                              var59 = field472.method2520();
                              if(class26.method635(var59)) {
                                 var70 = true;
                              }
                           }

                           String var61 = field472.method2520();
                           if(!var70) {
                              class137.method2943(var4, var59, var61);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 255) {
                           var4 = field472.method2517();
                           class3 var79 = (class3)field454.method3824((long)var4);
                           if(var79 != null) {
                              class112.method2446(var79, true);
                           }

                           if(field431 != null) {
                              class36.method745(field431);
                              field431 = null;
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 130) {
                           var4 = field472.method2517();
                           var75 = field472.method2520();
                           var45 = class92.method2180(var4);
                           if(!var75.equals(var45.field2778)) {
                              var45.field2778 = var75;
                              class36.method745(var45);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(235 == field488) {
                           var4 = field472.method2546();
                           byte var72 = field472.method2539();
                           class175.field2891[var4] = var72;
                           if(var72 != class175.field2890[var4]) {
                              class175.field2890[var4] = var72;
                           }

                           class45.method959(var4);
                           field338[++field481 - 1 & 31] = var4;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 155) {
                           for(var4 = 0; var4 < class175.field2890.length; ++var4) {
                              if(class175.field2891[var4] != class175.field2890[var4]) {
                                 class175.field2890[var4] = class175.field2891[var4];
                                 class45.method959(var4);
                                 field338[++field481 - 1 & 31] = var4;
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(139 == field488) {
                           var4 = field472.method2645();
                           var5 = field472.method2514();
                           var45 = class92.method2180(var4);
                           if(1 != var45.field2784 || var5 != var45.field2846) {
                              var45.field2784 = 1;
                              var45.field2846 = var5;
                              class36.method745(var45);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 39) {
                           class39.method803(true);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(26 == field488) {
                           var4 = field472.method2514();
                           var5 = field472.method2645();
                           var41 = field472.method2538();
                           var55 = (class3)field454.method3824((long)var5);
                           if(null != var55) {
                              class112.method2446(var55, var55.field56 != var4);
                           }

                           class37.method765(var5, var4, var41);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(114 == field488) {
                           var4 = field472.method2517();
                           var5 = field472.method2514();
                           if(var4 < -70000) {
                              var5 += '耀';
                           }

                           if(var4 >= 0) {
                              var45 = class92.method2180(var4);
                           } else {
                              var45 = null;
                           }

                           if(var45 != null) {
                              for(var7 = 0; var7 < var45.field2859.length; ++var7) {
                                 var45.field2859[var7] = 0;
                                 var45.field2860[var7] = 0;
                              }
                           }

                           class15 var62 = (class15)class15.field225.method3824((long)var5);
                           if(var62 != null) {
                              for(var8 = 0; var8 < var62.field215.length; ++var8) {
                                 var62.field215[var8] = -1;
                                 var62.field221[var8] = 0;
                              }
                           }

                           var7 = field472.method2514();

                           for(var8 = 0; var8 < var7; ++var8) {
                              var47 = field472.method2540();
                              if(var47 == 255) {
                                 var47 = field472.method2556();
                              }

                              var10 = field472.method2546();
                              if(var45 != null && var8 < var45.field2859.length) {
                                 var45.field2859[var8] = var10;
                                 var45.field2860[var8] = var47;
                              }

                              class118.method2582(var5, var8, var10 - 1, var47);
                           }

                           if(null != var45) {
                              class36.method745(var45);
                           }

                           class46.method990();
                           field467[++field483 - 1 & 31] = var5 & 32767;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        long var73;
                        if(194 == field488) {
                           var4 = field569 + field472.field1979;
                           var5 = field472.method2514();
                           var41 = field472.method2514();
                           if(var5 != field453) {
                              field453 = var5;
                              var7 = field453;
                              var8 = class6.field107;
                              var47 = class31.field749;
                              if(class103.method2303(var7)) {
                                 class1.method11(class172.field2850[var7], -1, var8, var47, false);
                              }

                              class74.method1635(field453);
                              class106.method2387(field453);

                              for(var7 = 0; var7 < 100; ++var7) {
                                 field499[var7] = true;
                              }
                           }

                           class3 var58;
                           for(; var41-- > 0; var58.field59 = true) {
                              var7 = field472.method2517();
                              var8 = field472.method2514();
                              var47 = field472.method2579();
                              var58 = (class3)field454.method3824((long)var7);
                              if(var58 != null && var58.field56 != var8) {
                                 class112.method2446(var58, true);
                                 var58 = null;
                              }

                              if(var58 == null) {
                                 var58 = class37.method765(var7, var8, var47);
                              }
                           }

                           for(var55 = (class3)field454.method3836(); var55 != null; var55 = (class3)field454.method3827()) {
                              if(var55.field59) {
                                 var55.field59 = false;
                              } else {
                                 class112.method2446(var55, true);
                              }
                           }

                           field366 = new class195(512);

                           while(field472.field1979 < var4) {
                              var7 = field472.method2517();
                              var8 = field472.method2514();
                              var47 = field472.method2514();
                              var10 = field472.method2517();

                              for(var11 = var8; var11 <= var47; ++var11) {
                                 var73 = (long)var11 + ((long)var7 << 32);
                                 field366.method3831(new class200(var10), var73);
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 113) {
                           field542 = false;

                           for(var4 = 0; var4 < 5; ++var4) {
                              field390[var4] = false;
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(156 == field488) {
                           field542 = true;
                           class177.field2900 = field472.method2579();
                           class15.field217 = field472.method2579();
                           class161.field2633 = field472.method2514();
                           class126.field2037 = field472.method2579();
                           class170.field2703 = field472.method2579();
                           if(class170.field2703 >= 100) {
                              class44.field1037 = class177.field2900 * 128 + 64;
                              class17.field254 = class15.field217 * 128 + 64;
                              class30.field713 = class4.method52(class44.field1037, class17.field254, class48.field1078) - class161.field2633;
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 242) {
                           var4 = field472.method2556();
                           var5 = field472.method2549();
                           var41 = field472.method2515();
                           var50 = class92.method2180(var4);
                           if(var50.field2743 != var41 || var5 != var50.field2753 || var50.field2748 != 0 || 0 != var50.field2749) {
                              var50.field2743 = var41;
                              var50.field2753 = var5;
                              var50.field2748 = 0;
                              var50.field2749 = 0;
                              class36.method745(var50);
                              class88.method2099(var50);
                              if(0 == var50.field2764) {
                                 class1.method14(class172.field2850[var4 >> 16], var50, false);
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 61) {
                           field528 = field472.method2579();
                           if(field528 == 255) {
                              field528 = 0;
                           }

                           field529 = field472.method2579();
                           if(field529 == 255) {
                              field529 = 0;
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(62 == field488) {
                           class4.field66 = field472.method2642();
                           class6.field124 = field472.method2579();
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(143 == field488) {
                           var48 = field472.method2520();
                           var54 = field472.method2518();
                           var49 = (long)field472.method2514();
                           var53 = (long)field472.method2516();
                           class151 var76 = (class151)class155.method3174(class211.method3970(), field472.method2579());
                           var73 = (var49 << 32) + var53;
                           var67 = false;

                           for(var15 = 0; var15 < 100; ++var15) {
                              if(field339[var15] == var73) {
                                 var67 = true;
                                 break;
                              }
                           }

                           if(var76.field2250 && class26.method635(var48)) {
                              var67 = true;
                           }

                           if(!var67 && field414 == 0) {
                              field339[field561] = var73;
                              field561 = (field561 + 1) % 100;
                              class121 var88 = field472;

                              String var100;
                              try {
                                 var18 = var88.method2659();
                                 if(var18 > 32767) {
                                    var18 = 32767;
                                 }

                                 byte[] var108 = new byte[var18];
                                 var88.field1979 += class221.field3177.method2441(var88.field1980, var88.field1979, var108, 0, var18);
                                 String var116 = class47.method1009(var108, 0, var18);
                                 var100 = var116;
                              } catch (Exception var26) {
                                 var100 = "Cabbage";
                              }

                              var100 = class222.method4130(class188.method3784(var100));
                              if(var76.field2248 != -1) {
                                 var111 = var76.field2248;
                                 var109 = "<img=" + var111 + ">";
                                 class0.method5(9, var109 + var48, var100, class33.method716(var54));
                              } else {
                                 class0.method5(9, var48, var100, class33.method716(var54));
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 44) {
                           class25 var60 = new class25();
                           var60.field630 = field472.method2520();
                           var60.field638 = field472.method2514();
                           var5 = field472.method2517();
                           var60.field639 = var5;
                           class1.method9(45);
                           class178.field2912.method3019();
                           class178.field2912 = null;
                           class18.method211(var60);
                           field488 = -1;
                           var38 = false;
                           break label4323;
                        }

                        if(94 == field488) {
                           var4 = field472.method2514();
                           var5 = field472.method2517();
                           var41 = var4 >> 10 & 31;
                           var7 = var4 >> 5 & 31;
                           var8 = var4 & 31;
                           var47 = (var7 << 11) + (var41 << 19) + (var8 << 3);
                           var57 = class92.method2180(var5);
                           if(var47 != var57.field2768) {
                              var57.field2768 = var47;
                              class36.method745(var57);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(141 == field488) {
                           var4 = field472.method2517();
                           var5 = field472.method2546();
                           class175.field2891[var5] = var4;
                           if(var4 != class175.field2890[var5]) {
                              class175.field2890[var5] = var4;
                           }

                           class45.method959(var5);
                           field338[++field481 - 1 & 31] = var5;
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 223) {
                           var4 = field472.method2645();
                           var5 = field472.method2690();
                           var45 = class92.method2180(var4);
                           if(var45.field2784 != 2 || var45.field2846 != var5) {
                              var45.field2784 = 2;
                              var45.field2846 = var5;
                              class36.method745(var45);
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(153 == field488) {
                           class25.method630(field472, field569);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(field488 == 131) {
                           var48 = field472.method2520();
                           class121 var46 = field472;

                           try {
                              var8 = var46.method2659();
                              if(var8 > 32767) {
                                 var8 = 32767;
                              }

                              byte[] var52 = new byte[var8];
                              var46.field1979 += class221.field3177.method2441(var46.field1980, var46.field1979, var52, 0, var8);
                              var56 = class47.method1009(var52, 0, var8);
                              var44 = var56;
                           } catch (Exception var25) {
                              var44 = "Cabbage";
                           }

                           var44 = class222.method4130(class188.method3784(var44));
                           class137.method2943(6, var48, var44);
                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        if(165 == field488) {
                           var4 = field472.method2546();
                           var5 = field472.method2645();
                           var45 = class92.method2180(var5);
                           if(var45 != null && 0 == var45.field2764) {
                              if(var4 > var45.field2813 - var45.field2759) {
                                 var4 = var45.field2813 - var45.field2759;
                              }

                              if(var4 < 0) {
                                 var4 = 0;
                              }

                              if(var4 != var45.field2765) {
                                 var45.field2765 = var4;
                                 class36.method745(var45);
                              }
                           }

                           field488 = -1;
                           var38 = true;
                           break label4323;
                        }

                        class28.method651("" + field488 + "," + field343 + "," + field344 + "," + field569, (Throwable)null);
                        class212.method3982();
                     } catch (IOException var32) {
                        if(field345 > 0) {
                           class212.method3982();
                        } else {
                           class1.method9(40);
                           class133.field2069 = class178.field2912;
                           class178.field2912 = null;
                        }
                     } catch (Exception var33) {
                        var48 = "" + field488 + "," + field343 + "," + field344 + "," + field569 + "," + (class147.field2214 + class151.field2253.field866[0]) + "," + (class151.field2253.field867[0] + class17.field257) + ",";

                        for(var5 = 0; var5 < field569 && var5 < 50; ++var5) {
                           var48 = var48 + field472.field1980[var5] + ",";
                        }

                        class28.method651(var48, var33);
                        class212.method3982();
                     }

                     var38 = true;
                  }
               }

               if(!var38) {
                  break;
               }
            }

            if(30 == field552) {
               while(class126.method2828()) {
                  field301.method2753(184);
                  field301.method2497(0);
                  var1 = field301.field1979;
                  class120.method2747(field301);
                  field301.method2509(field301.field1979 - var1);
               }

               Object var36 = class93.field1600.field188;
               synchronized(class93.field1600.field188) {
                  if(!field487) {
                     class93.field1600.field189 = 0;
                  } else if(class139.field2145 != 0 || class93.field1600.field189 >= 40) {
                     field301.method2753(8);
                     field301.method2497(0);
                     var2 = field301.field1979;
                     var35 = 0;

                     for(var4 = 0; var4 < class93.field1600.field189 && field301.field1979 - var2 < 240; ++var4) {
                        ++var35;
                        var5 = class93.field1600.field195[var4];
                        if(var5 < 0) {
                           var5 = 0;
                        } else if(var5 > 502) {
                           var5 = 502;
                        }

                        var41 = class93.field1600.field197[var4];
                        if(var41 < 0) {
                           var41 = 0;
                        } else if(var41 > 764) {
                           var41 = 764;
                        }

                        var7 = 765 * var5 + var41;
                        if(class93.field1600.field195[var4] == -1 && class93.field1600.field197[var4] == -1) {
                           var41 = -1;
                           var5 = -1;
                           var7 = 524287;
                        }

                        if(var41 == field305 && field306 == var5) {
                           if(field307 < 2047) {
                              ++field307;
                           }
                        } else {
                           var8 = var41 - field305;
                           field305 = var41;
                           var47 = var5 - field306;
                           field306 = var5;
                           if(field307 < 8 && var8 >= -32 && var8 <= 31 && var47 >= -32 && var47 <= 31) {
                              var8 += 32;
                              var47 += 32;
                              field301.method2498((field307 << 12) + (var8 << 6) + var47);
                              field307 = 0;
                           } else if(field307 < 8) {
                              field301.method2499(var7 + (field307 << 19) + 8388608);
                              field307 = 0;
                           } else {
                              field301.method2663(var7 + -1073741824 + (field307 << 19));
                              field307 = 0;
                           }
                        }
                     }

                     field301.method2509(field301.field1979 - var2);
                     if(var35 >= class93.field1600.field189) {
                        class93.field1600.field189 = 0;
                     } else {
                        class93.field1600.field189 -= var35;

                        for(var4 = 0; var4 < class93.field1600.field189; ++var4) {
                           class93.field1600.field197[var4] = class93.field1600.field197[var4 + var35];
                           class93.field1600.field195[var4] = class93.field1600.field195[var4 + var35];
                        }
                     }
                  }
               }

               if(1 == class139.field2145 || !class214.field3149 && 4 == class139.field2145 || class139.field2145 == 2) {
                  long var37 = (class139.field2148 - field304 * -1L) / 50L;
                  if(var37 > 4095L) {
                     var37 = 4095L;
                  }

                  field304 = class139.field2148 * -1L;
                  var35 = class139.field2147;
                  if(var35 < 0) {
                     var35 = 0;
                  } else if(var35 > class31.field749) {
                     var35 = class31.field749;
                  }

                  var4 = class139.field2146;
                  if(var4 < 0) {
                     var4 = 0;
                  } else if(var4 > class6.field107) {
                     var4 = class6.field107;
                  }

                  var5 = (int)var37;
                  field301.method2753(101);
                  field301.method2498((class139.field2145 == 2?1:0) + (var5 << 1));
                  field301.method2498(var4);
                  field301.method2498(var35);
               }

               if(class136.field2110 > 0) {
                  field301.method2753(125);
                  field301.method2498(0);
                  var1 = field301.field1979;
                  long var126 = class18.method214();

                  for(var4 = 0; var4 < class136.field2110; ++var4) {
                     var54 = var126 - field563;
                     if(var54 > 16777215L) {
                        var54 = 16777215L;
                     }

                     field563 = var126;
                     field301.method2497(class136.field2112[var4]);
                     field301.method2657((int)var54);
                  }

                  field301.method2508(field301.field1979 - var1);
               }

               if(field352 > 0) {
                  --field352;
               }

               if(class136.field2087[96] || class136.field2087[97] || class136.field2087[98] || class136.field2087[99]) {
                  field386 = true;
               }

               if(field386 && field352 <= 0) {
                  field352 = 20;
                  field386 = false;
                  field301.method2753(65);
                  field301.method2545(field554);
                  field301.method2544(field495);
               }

               if(class46.field1057 && !field308) {
                  field308 = true;
                  field301.method2753(31);
                  field301.method2497(1);
               }

               if(!class46.field1057 && field308) {
                  field308 = false;
                  field301.method2753(31);
                  field301.method2497(0);
               }

               if(class48.field1078 != field523 * -1) {
                  field523 = class48.field1078 * -1;
                  var1 = class48.field1078;
                  int[] var128 = class1.field21.field1397;
                  var35 = var128.length;

                  for(var4 = 0; var4 < var35; ++var4) {
                     var128[var4] = 0;
                  }

                  var4 = 1;

                  while(true) {
                     if(var4 >= 103) {
                        var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                        var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                        class1.field21.method1751();

                        for(var41 = 1; var41 < 103; ++var41) {
                           for(var7 = 1; var7 < 103; ++var7) {
                              if((class5.field90[var1][var7][var41] & 24) == 0) {
                                 class224.method4148(var1, var7, var41, var4, var5);
                              }

                              if(var1 < 3 && (class5.field90[1 + var1][var7][var41] & 8) != 0) {
                                 class224.method4148(var1 + 1, var7, var41, var4, var5);
                              }
                           }
                        }

                        field524 = 0;

                        for(var41 = 0; var41 < 104; ++var41) {
                           for(var7 = 0; var7 < 104; ++var7) {
                              var8 = class77.field1396.method1951(class48.field1078, var41, var7);
                              if(var8 != 0) {
                                 var8 = var8 >> 14 & 32767;
                                 var47 = class156.method3176(var8).field943;
                                 if(var47 >= 0) {
                                    var10 = var41;
                                    var11 = var7;
                                    if(22 != var47 && 29 != var47 && var47 != 34 && var47 != 36 && var47 != 46 && 47 != var47 && 48 != var47) {
                                       int[][] var103 = field359[class48.field1078].field1888;

                                       for(var15 = 0; var15 < 10; ++var15) {
                                          var16 = (int)(Math.random() * 4.0D);
                                          if(var16 == 0 && var10 > 0 && var10 > var41 - 3 && (var103[var10 - 1][var11] & 19136776) == 0) {
                                             --var10;
                                          }

                                          if(1 == var16 && var10 < 103 && var10 < var41 + 3 && (var103[1 + var10][var11] & 19136896) == 0) {
                                             ++var10;
                                          }

                                          if(var16 == 2 && var11 > 0 && var11 > var7 - 3 && (var103[var10][var11 - 1] & 19136770) == 0) {
                                             --var11;
                                          }

                                          if(3 == var16 && var11 < 103 && var11 < var7 + 3 && (var103[var10][1 + var11] & 19136800) == 0) {
                                             ++var11;
                                          }
                                       }
                                    }

                                    field317[field524] = class121.field2000[var47];
                                    field363[field524] = var10;
                                    field526[field524] = var11;
                                    ++field524;
                                 }
                              }
                           }
                        }

                        class139.field2149.method1723();
                        break;
                     }

                     var5 = 2048 * (103 - var4) + 24628;

                     for(var41 = 1; var41 < 103; ++var41) {
                        if(0 == (class5.field90[var1][var41][var4] & 24)) {
                           class77.field1396.method1956(var128, var5, 512, var1, var41, var4);
                        }

                        if(var1 < 3 && 0 != (class5.field90[1 + var1][var41][var4] & 8)) {
                           class77.field1396.method1956(var128, var5, 512, var1 + 1, var41, var4);
                        }

                        var5 += 4;
                     }

                     ++var4;
                  }
               }

               if(30 == field552) {
                  for(class16 var39 = (class16)field427.method3860(); null != var39; var39 = (class16)field427.method3861()) {
                     if(var39.field238 > 0) {
                        --var39.field238;
                     }

                     if(var39.field238 == 0) {
                        if(var39.field228 < 0 || class45.method963(var39.field228, var39.field233)) {
                           class3.method47(var39.field236, var39.field227, var39.field229, var39.field244, var39.field228, var39.field232, var39.field233);
                           var39.method3946();
                        }
                     } else {
                        if(var39.field237 > 0) {
                           --var39.field237;
                        }

                        if(var39.field237 == 0 && var39.field229 >= 1 && var39.field244 >= 1 && var39.field229 <= 102 && var39.field244 <= 102 && (var39.field234 < 0 || class45.method963(var39.field234, var39.field242))) {
                           class3.method47(var39.field236, var39.field227, var39.field229, var39.field244, var39.field234, var39.field235, var39.field242);
                           var39.field237 = -1;
                           if(var39.field234 == var39.field228 && -1 == var39.field228) {
                              var39.method3946();
                           } else if(var39.field228 == var39.field234 && var39.field235 == var39.field232 && var39.field233 == var39.field242) {
                              var39.method3946();
                           }
                        }
                     }
                  }

                  class16.method203();
                  ++field340;
                  if(field340 > 750) {
                     if(field345 > 0) {
                        class212.method3982();
                     } else {
                        class1.method9(40);
                        class133.field2069 = class178.field2912;
                        class178.field2912 = null;
                     }
                  } else {
                     class2.method43();

                     for(var1 = 0; var1 < field331; ++var1) {
                        var2 = field564[var1];
                        class34 var63 = field358[var2];
                        if(null != var63) {
                           class49.method1026(var63);
                        }
                     }

                     class76.method1704();
                     ++field409;
                     if(0 != field405) {
                        field355 += 20;
                        if(field355 >= 400) {
                           field405 = 0;
                        }
                     }

                     if(class28.field679 != null) {
                        ++field406;
                        if(field406 >= 15) {
                           class36.method745(class28.field679);
                           class28.field679 = null;
                        }
                     }

                     class172 var43 = class188.field3039;
                     class172 var130 = class161.field2632;
                     class188.field3039 = null;
                     class161.field2632 = null;
                     field368 = null;
                     field474 = false;
                     field498 = false;
                     field517 = 0;

                     while(true) {
                        while(class33.method715() && field517 < 128) {
                           if(field460 >= 2 && class136.field2087[82] && 66 == class13.field201) {
                              String var65 = class132.method2859();
                              class159.field2614.setContents(new StringSelection(var65), (ClipboardOwner)null);
                           } else {
                              field519[field517] = class13.field201;
                              field548[field517] = class110.field1948;
                              ++field517;
                           }
                        }

                        if(field453 != -1) {
                           class28.method656(field453, 0, 0, class6.field107, class31.field749, 0, 0);
                        }

                        ++field479;

                        while(true) {
                           class0 var68;
                           class172 var131;
                           do {
                              var68 = (class0)field293.method3866();
                              if(null == var68) {
                                 while(true) {
                                    do {
                                       var68 = (class0)field320.method3866();
                                       if(var68 == null) {
                                          while(true) {
                                             do {
                                                var68 = (class0)field292.method3866();
                                                if(var68 == null) {
                                                   boolean var80 = false;

                                                   while(!var80) {
                                                      var80 = true;

                                                      for(var4 = 0; var4 < field435 - 1; ++var4) {
                                                         if(field302[var4] < 1000 && field302[1 + var4] > 1000) {
                                                            var75 = field445[var4];
                                                            field445[var4] = field445[1 + var4];
                                                            field445[1 + var4] = var75;
                                                            var59 = field440[var4];
                                                            field440[var4] = field440[1 + var4];
                                                            field440[var4 + 1] = var59;
                                                            var7 = field302[var4];
                                                            field302[var4] = field302[var4 + 1];
                                                            field302[var4 + 1] = var7;
                                                            var7 = field436[var4];
                                                            field436[var4] = field436[1 + var4];
                                                            field436[var4 + 1] = var7;
                                                            var7 = field437[var4];
                                                            field437[var4] = field437[var4 + 1];
                                                            field437[1 + var4] = var7;
                                                            var7 = field439[var4];
                                                            field439[var4] = field439[var4 + 1];
                                                            field439[var4 + 1] = var7;
                                                            var80 = false;
                                                         }
                                                      }
                                                   }

                                                   if(class32.field762 == null && null == field466) {
                                                      var35 = class139.field2145;
                                                      String var133;
                                                      if(field470) {
                                                         if(var35 != 1 && (class214.field3149 || 4 != var35)) {
                                                            var4 = class139.field2140;
                                                            var5 = class139.field2135;
                                                            if(var4 < class13.field192 - 10 || var4 > 10 + class13.field192 + class180.field2925 || var5 < class30.field709 - 10 || var5 > 10 + class118.field1987 + class30.field709) {
                                                               field470 = false;
                                                               class18.method210(class13.field192, class30.field709, class180.field2925, class118.field1987);
                                                            }
                                                         }

                                                         if(1 == var35 || !class214.field3149 && var35 == 4) {
                                                            var4 = class13.field192;
                                                            var5 = class30.field709;
                                                            var41 = class180.field2925;
                                                            var7 = class139.field2146;
                                                            var8 = class139.field2147;
                                                            var47 = -1;

                                                            for(var10 = 0; var10 < field435; ++var10) {
                                                               var11 = 31 + var5 + (field435 - 1 - var10) * 15;
                                                               if(var7 > var4 && var7 < var4 + var41 && var8 > var11 - 13 && var8 < var11 + 3) {
                                                                  var47 = var10;
                                                               }
                                                            }

                                                            if(-1 != var47 && var47 >= 0) {
                                                               var10 = field436[var47];
                                                               var11 = field437[var47];
                                                               var12 = field302[var47];
                                                               var13 = field439[var47];
                                                               var133 = field440[var47];
                                                               var90 = field445[var47];
                                                               class10.method145(var10, var11, var12, var13, var90, class139.field2146, class139.field2147);
                                                            }

                                                            field470 = false;
                                                            class18.method210(class13.field192, class30.field709, class180.field2925, class118.field1987);
                                                         }
                                                      } else {
                                                         label4446: {
                                                            if((var35 == 1 || !class214.field3149 && 4 == var35) && field435 > 0) {
                                                               var4 = field302[field435 - 1];
                                                               if(var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || 43 == var4 || 33 == var4 || var4 == 34 || var4 == 35 || var4 == 36 || 37 == var4 || var4 == 38 || 1005 == var4) {
                                                                  var5 = field436[field435 - 1];
                                                                  var41 = field437[field435 - 1];
                                                                  var50 = class92.method2180(var41);
                                                                  if(class76.method1707(class101.method2294(var50)) || class59.method1278(class101.method2294(var50))) {
                                                                     if(class32.field762 != null && !field412 && 1 != field433 && !class46.method976(field435 - 1) && field435 > 0) {
                                                                        var8 = field510;
                                                                        var47 = field493;
                                                                        class11.method165(class136.field2120, var8, var47);
                                                                        class136.field2120 = null;
                                                                     }

                                                                     field412 = false;
                                                                     field413 = 0;
                                                                     if(null != class32.field762) {
                                                                        class36.method745(class32.field762);
                                                                     }

                                                                     class32.field762 = class92.method2180(var41);
                                                                     field408 = var5;
                                                                     field510 = class139.field2146;
                                                                     field493 = class139.field2147;
                                                                     if(field435 > 0) {
                                                                        var8 = field435 - 1;
                                                                        class136.field2120 = new class30();
                                                                        class136.field2120.field703 = field436[var8];
                                                                        class136.field2120.field704 = field437[var8];
                                                                        class136.field2120.field705 = field302[var8];
                                                                        class136.field2120.field706 = field439[var8];
                                                                        class136.field2120.field707 = field440[var8];
                                                                     }

                                                                     class36.method745(class32.field762);
                                                                     break label4446;
                                                                  }
                                                               }
                                                            }

                                                            if((var35 == 1 || !class214.field3149 && 4 == var35) && (field433 == 1 && field435 > 2 || class46.method976(field435 - 1))) {
                                                               var35 = 2;
                                                            }

                                                            if((var35 == 1 || !class214.field3149 && 4 == var35) && field435 > 0) {
                                                               var4 = field435 - 1;
                                                               if(var4 >= 0) {
                                                                  var5 = field436[var4];
                                                                  var41 = field437[var4];
                                                                  var7 = field302[var4];
                                                                  var8 = field439[var4];
                                                                  var133 = field440[var4];
                                                                  var56 = field445[var4];
                                                                  class10.method145(var5, var41, var7, var8, var56, class139.field2146, class139.field2147);
                                                               }
                                                            }

                                                            if(var35 == 2 && field435 > 0) {
                                                               class83.method1911(class139.field2146, class139.field2147);
                                                            }
                                                         }
                                                      }
                                                   }

                                                   if(field466 != null) {
                                                      class36.method745(field466);
                                                      ++field407;
                                                      if(field474 && field498) {
                                                         var35 = class139.field2140;
                                                         var4 = class139.field2135;
                                                         var35 -= field468;
                                                         var4 -= field469;
                                                         if(var35 < field480) {
                                                            var35 = field480;
                                                         }

                                                         if(var35 + field466.field2752 > field566.field2752 + field480) {
                                                            var35 = field566.field2752 + field480 - field466.field2752;
                                                         }

                                                         if(var4 < field473) {
                                                            var4 = field473;
                                                         }

                                                         if(var4 + field466.field2759 > field473 + field566.field2759) {
                                                            var4 = field473 + field566.field2759 - field466.field2759;
                                                         }

                                                         var5 = var35 - field423;
                                                         var41 = var4 - field476;
                                                         var7 = field466.field2732;
                                                         if(field407 > field466.field2818 && (var5 > var7 || var5 < -var7 || var41 > var7 || var41 < -var7)) {
                                                            field565 = true;
                                                         }

                                                         var8 = field566.field2803 + (var35 - field480);
                                                         var47 = var4 - field473 + field566.field2765;
                                                         class0 var119;
                                                         if(field466.field2830 != null && field565) {
                                                            var119 = new class0();
                                                            var119.field6 = field466;
                                                            var119.field3 = var8;
                                                            var119.field4 = var47;
                                                            var119.field8 = field466.field2830;
                                                            class150.method3148(var119);
                                                         }

                                                         if(class139.field2138 == 0) {
                                                            if(field565) {
                                                               if(null != field466.field2767) {
                                                                  var119 = new class0();
                                                                  var119.field6 = field466;
                                                                  var119.field3 = var8;
                                                                  var119.field4 = var47;
                                                                  var119.field2 = field368;
                                                                  var119.field8 = field466.field2767;
                                                                  class150.method3148(var119);
                                                               }

                                                               if(null != field368) {
                                                                  class172 var115 = field466;
                                                                  var13 = class101.method2294(var115);
                                                                  var12 = var13 >> 17 & 7;
                                                                  var91 = var12;
                                                                  if(var12 == 0) {
                                                                     var57 = null;
                                                                  } else {
                                                                     var15 = 0;

                                                                     while(true) {
                                                                        if(var15 >= var91) {
                                                                           var57 = var115;
                                                                           break;
                                                                        }

                                                                        var115 = class92.method2180(var115.field2762);
                                                                        if(var115 == null) {
                                                                           var57 = null;
                                                                           break;
                                                                        }

                                                                        ++var15;
                                                                     }
                                                                  }

                                                                  if(var57 != null) {
                                                                     field301.method2753(7);
                                                                     field301.method2545(field466.field2744);
                                                                     field301.method2666(field368.field2834);
                                                                     field301.method2652(field466.field2800 * -1);
                                                                     field301.method2545(field368.field2744);
                                                                     field301.method2666(field466.field2834);
                                                                     field301.method2663(field368.field2800 * -1);
                                                                  }
                                                               }
                                                            } else if((1 == field433 || class46.method976(field435 - 1)) && field435 > 2) {
                                                               class83.method1911(field468 + field423, field476 + field469);
                                                            } else if(field435 > 0) {
                                                               var10 = field468 + field423;
                                                               var11 = field476 + field469;
                                                               class11.method165(class136.field2120, var10, var11);
                                                               class136.field2120 = null;
                                                            }

                                                            field466 = null;
                                                         }
                                                      } else if(field407 > 1) {
                                                         field466 = null;
                                                      }
                                                   }

                                                   if(class32.field762 != null) {
                                                      class36.method745(class32.field762);
                                                      ++field413;
                                                      if(class139.field2138 != 0) {
                                                         if(field413 >= 5 && (class139.field2140 > 5 + field510 || class139.field2140 < field510 - 5 || class139.field2135 > 5 + field493 || class139.field2135 < field493 - 5)) {
                                                            field412 = true;
                                                         }
                                                      } else {
                                                         if(field412) {
                                                            if(class14.field204 == class32.field762 && field408 != field549) {
                                                               class172 var110 = class32.field762;
                                                               byte var132 = 0;
                                                               if(field456 == 1 && var110.field2747 == 206) {
                                                                  var132 = 1;
                                                               }

                                                               if(var110.field2859[field549] <= 0) {
                                                                  var132 = 0;
                                                               }

                                                               if(class59.method1278(class101.method2294(var110))) {
                                                                  var5 = field408;
                                                                  var41 = field549;
                                                                  var110.field2859[var41] = var110.field2859[var5];
                                                                  var110.field2860[var41] = var110.field2860[var5];
                                                                  var110.field2859[var5] = -1;
                                                                  var110.field2860[var5] = 0;
                                                               } else if(1 == var132) {
                                                                  var5 = field408;
                                                                  var41 = field549;

                                                                  while(var41 != var5) {
                                                                     if(var5 > var41) {
                                                                        var110.method3431(var5 - 1, var5);
                                                                        --var5;
                                                                     } else if(var5 < var41) {
                                                                        var110.method3431(1 + var5, var5);
                                                                        ++var5;
                                                                     }
                                                                  }
                                                               } else {
                                                                  var110.method3431(field549, field408);
                                                               }

                                                               field301.method2753(208);
                                                               field301.method2673(class32.field762.field2800 * -1);
                                                               field301.method2535(var132);
                                                               field301.method2666(field408);
                                                               field301.method2666(field549);
                                                            }
                                                         } else if((1 == field433 || class46.method976(field435 - 1)) && field435 > 2) {
                                                            class83.method1911(field510, field493);
                                                         } else if(field435 > 0) {
                                                            var35 = field510;
                                                            var4 = field493;
                                                            class11.method165(class136.field2120, var35, var4);
                                                            class136.field2120 = null;
                                                         }

                                                         field406 = 10;
                                                         class139.field2145 = 0;
                                                         class32.field762 = null;
                                                      }
                                                   }

                                                   if(-1 != class85.field1484) {
                                                      var35 = class85.field1484;
                                                      var4 = class85.field1485;
                                                      field301.method2753(32);
                                                      field301.method2497(5);
                                                      field301.method2497(class136.field2087[82]?(class136.field2087[81]?2:1):0);
                                                      field301.method2544(class147.field2214 + var35);
                                                      field301.method2545(class17.field257 + var4);
                                                      class85.field1484 = -1;
                                                      field402 = class139.field2146;
                                                      field403 = class139.field2147;
                                                      field405 = 1;
                                                      field355 = 0;
                                                      field528 = var35;
                                                      field529 = var4;
                                                   }

                                                   if(var43 != class188.field3039) {
                                                      if(null != var43) {
                                                         class36.method745(var43);
                                                      }

                                                      if(class188.field3039 != null) {
                                                         class36.method745(class188.field3039);
                                                      }
                                                   }

                                                   if(var130 != class161.field2632 && field494 == field395) {
                                                      if(null != var130) {
                                                         class36.method745(var130);
                                                      }

                                                      if(null != class161.field2632) {
                                                         class36.method745(class161.field2632);
                                                      }
                                                   }

                                                   if(class161.field2632 != null) {
                                                      if(field494 < field395) {
                                                         ++field494;
                                                         if(field395 == field494) {
                                                            class36.method745(class161.field2632);
                                                         }
                                                      }
                                                   } else if(field494 > 0) {
                                                      --field494;
                                                   }

                                                   var35 = field356 + class151.field2253.field870;
                                                   var4 = class151.field2253.field813 + field379;
                                                   if(class151.field2251 - var35 < -500 || class151.field2251 - var35 > 500 || class118.field1984 - var4 < -500 || class118.field1984 - var4 > 500) {
                                                      class151.field2251 = var35;
                                                      class118.field1984 = var4;
                                                   }

                                                   if(class151.field2251 != var35) {
                                                      class151.field2251 += (var35 - class151.field2251) / 16;
                                                   }

                                                   if(class118.field1984 != var4) {
                                                      class118.field1984 += (var4 - class118.field1984) / 16;
                                                   }

                                                   if(class139.field2138 == 4 && class214.field3149) {
                                                      var5 = class139.field2135 - field383;
                                                      field537 = var5 * 2;
                                                      field383 = -1 != var5 && 1 != var5?(field383 + class139.field2135) / 2:class139.field2135;
                                                      var41 = field475 - class139.field2140;
                                                      field380 = var41 * 2;
                                                      field475 = var41 != -1 && 1 != var41?(field475 + class139.field2140) / 2:class139.field2140;
                                                   } else {
                                                      if(class136.field2087[96]) {
                                                         field380 += (-24 - field380) / 2;
                                                      } else if(class136.field2087[97]) {
                                                         field380 += (24 - field380) / 2;
                                                      } else {
                                                         field380 /= 2;
                                                      }

                                                      if(class136.field2087[98]) {
                                                         field537 += (12 - field537) / 2;
                                                      } else if(class136.field2087[99]) {
                                                         field537 += (-12 - field537) / 2;
                                                      } else {
                                                         field537 /= 2;
                                                      }

                                                      field383 = class139.field2135;
                                                      field475 = class139.field2140;
                                                   }

                                                   field495 = field380 / 2 + field495 & 2047;
                                                   field554 += field537 / 2;
                                                   if(field554 < 128) {
                                                      field554 = 128;
                                                   }

                                                   if(field554 > 383) {
                                                      field554 = 383;
                                                   }

                                                   var5 = class151.field2251 >> 7;
                                                   var41 = class118.field1984 >> 7;
                                                   var7 = class4.method52(class151.field2251, class118.field1984, class48.field1078);
                                                   var8 = 0;
                                                   if(var5 > 3 && var41 > 3 && var5 < 100 && var41 < 100) {
                                                      for(var47 = var5 - 4; var47 <= var5 + 4; ++var47) {
                                                         for(var10 = var41 - 4; var10 <= var41 + 4; ++var10) {
                                                            var11 = class48.field1078;
                                                            if(var11 < 3 && 2 == (class5.field90[1][var47][var10] & 2)) {
                                                               ++var11;
                                                            }

                                                            var12 = var7 - class5.field86[var11][var47][var10];
                                                            if(var12 > var8) {
                                                               var8 = var12;
                                                            }
                                                         }
                                                      }
                                                   }

                                                   var47 = var8 * 192;
                                                   if(var47 > 98048) {
                                                      var47 = 98048;
                                                   }

                                                   if(var47 < '耀') {
                                                      var47 = '耀';
                                                   }

                                                   if(var47 > field387) {
                                                      field387 += (var47 - field387) / 24;
                                                   } else if(var47 < field387) {
                                                      field387 += (var47 - field387) / 80;
                                                   }

                                                   if(field542) {
                                                      class11.method156();
                                                   }

                                                   for(var35 = 0; var35 < 5; ++var35) {
                                                      ++field422[var35];
                                                   }

                                                   class112.field1958.method218();
                                                   var35 = ++class139.field2139 - 1;
                                                   var5 = class86.method2096();
                                                   if(var35 > 15000 && var5 > 15000) {
                                                      field345 = 250;
                                                      class139.field2139 = 14500;
                                                      field301.method2753(183);
                                                   }

                                                   ++field362;
                                                   if(field362 > 500) {
                                                      field362 = 0;
                                                      var41 = (int)(Math.random() * 8.0D);
                                                      if(1 == (var41 & 1)) {
                                                         field356 += field357;
                                                      }

                                                      if(2 == (var41 & 2)) {
                                                         field379 += field555;
                                                      }

                                                      if(4 == (var41 & 4)) {
                                                         field360 += field361;
                                                      }
                                                   }

                                                   if(field356 < -50) {
                                                      field357 = 2;
                                                   }

                                                   if(field356 > 50) {
                                                      field357 = -2;
                                                   }

                                                   if(field379 < -55) {
                                                      field555 = 2;
                                                   }

                                                   if(field379 > 55) {
                                                      field555 = -2;
                                                   }

                                                   if(field360 < -40) {
                                                      field361 = 1;
                                                   }

                                                   if(field360 > 40) {
                                                      field361 = -1;
                                                   }

                                                   ++field367;
                                                   if(field367 > 500) {
                                                      field367 = 0;
                                                      var41 = (int)(Math.random() * 8.0D);
                                                      if((var41 & 1) == 1) {
                                                         field546 += field364;
                                                      }

                                                      if((var41 & 2) == 2) {
                                                         field365 += field449;
                                                      }
                                                   }

                                                   if(field546 < -60) {
                                                      field364 = 2;
                                                   }

                                                   if(field546 > 60) {
                                                      field364 = -2;
                                                   }

                                                   if(field365 < -20) {
                                                      field449 = 1;
                                                   }

                                                   if(field365 > 10) {
                                                      field449 = -1;
                                                   }

                                                   for(class38 var127 = (class38)field428.method3817(); var127 != null; var127 = (class38)field428.method3818()) {
                                                      if((long)var127.field875 < class18.method214() / 1000L - 5L) {
                                                         if(var127.field874 > 0) {
                                                            class137.method2943(5, "", var127.field872 + " has logged in.");
                                                         }

                                                         if(0 == var127.field874) {
                                                            class137.method2943(5, "", var127.field872 + " has logged out.");
                                                         }

                                                         var127.method3940();
                                                      }
                                                   }

                                                   ++field341;
                                                   if(field341 > 50) {
                                                      field301.method2753(163);
                                                   }

                                                   try {
                                                      if(class178.field2912 != null && field301.field1979 > 0) {
                                                         class178.field2912.method3003(field301.field1980, 0, field301.field1979);
                                                         field301.field1979 = 0;
                                                         field341 = 0;
                                                         return;
                                                      }
                                                   } catch (IOException var29) {
                                                      if(field345 > 0) {
                                                         class212.method3982();
                                                      } else {
                                                         class1.method9(40);
                                                         class133.field2069 = class178.field2912;
                                                         class178.field2912 = null;
                                                      }

                                                      return;
                                                   }

                                                   return;
                                                }

                                                var131 = var68.field6;
                                                if(var131.field2744 < 0) {
                                                   break;
                                                }

                                                var87 = class92.method2180(var131.field2762);
                                             } while(var87 == null || null == var87.field2865 || var131.field2744 >= var87.field2865.length || var87.field2865[var131.field2744] != var131);

                                             class150.method3148(var68);
                                          }
                                       }

                                       var131 = var68.field6;
                                       if(var131.field2744 < 0) {
                                          break;
                                       }

                                       var87 = class92.method2180(var131.field2762);
                                    } while(var87 == null || var87.field2865 == null || var131.field2744 >= var87.field2865.length || var87.field2865[var131.field2744] != var131);

                                    class150.method3148(var68);
                                 }
                              }

                              var131 = var68.field6;
                              if(var131.field2744 < 0) {
                                 break;
                              }

                              var87 = class92.method2180(var131.field2762);
                           } while(null == var87 || var87.field2865 == null || var131.field2744 >= var87.field2865.length || var87.field2865[var131.field2744] != var131);

                           class150.method3148(var68);
                        }
                     }
                  }
               }
            }
         }
      } else if(field552 == 40 || field552 == 45) {
         class22.method581();
      }

   }

   @ObfuscatedName("j")
   protected final void vmethod3034() {
      if(class112.field1958.method225()) {
         class112.field1958.method221();
      }

      if(null != class93.field1600) {
         class93.field1600.field191 = false;
      }

      class93.field1600 = null;
      if(class178.field2912 != null) {
         class178.field2912.method3019();
         class178.field2912 = null;
      }

      class100.method2292();
      class76.method1675();
      class107.field1894 = null;
      if(null != class76.field1380) {
         class76.field1380.method1197();
      }

      if(class2.field53 != null) {
         class2.field53.method1197();
      }

      if(null != class89.field1549) {
         class89.field1549.method3019();
      }

      class46.method987();
      class156.method3175();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1669166001"
   )
   void method256() {
      if(field552 != 1000) {
         boolean var1 = class46.method977();
         if(!var1) {
            this.method532();
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "238793416"
   )
   void method258(int var1) {
      class32.field769 = null;
      class164.field2649 = null;
      field404 = 0;
      if(class72.field1350 == class36.field800) {
         class36.field800 = class94.field1612;
      } else {
         class36.field800 = class72.field1350;
      }

      ++field324;
      if(field324 < 2 || 7 != var1 && 9 != var1) {
         if(field324 >= 2 && var1 == 6) {
            this.method3075("js5connect_outofdate");
            field552 = 1000;
         } else if(field324 >= 4) {
            if(field552 <= 5) {
               this.method3075("js5connect");
               field552 = 1000;
            } else {
               field323 = -327848;
            }
         }
      } else if(field552 <= 5) {
         this.method3075("js5connect_full");
         field552 = 1000;
      } else {
         field323 = -327848;
      }

   }

   static {
      field319 = class20.field589;
      field332 = class20.field589;
      field321 = 0;
      field404 = 0;
      field323 = 0;
      field324 = 0;
      field335 = 0;
      field384 = 0;
      field421 = 0;
      field328 = 0;
      field358 = new class34['耀'];
      field331 = 0;
      field564 = new int['耀'];
      field330 = 0;
      field334 = new int[250];
      field301 = new class121(5000);
      field477 = new class121(5000);
      field472 = new class121(15000);
      field569 = 0;
      field488 = 0;
      field340 = 0;
      field341 = 0;
      field342 = 0;
      field343 = 0;
      field344 = 0;
      field345 = 0;
      field346 = false;
      field444 = 0;
      field348 = 1;
      field349 = 0;
      field478 = 1;
      field351 = 0;
      field359 = new class107[4];
      field353 = false;
      field354 = new int[4][13][13];
      field397 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field356 = 0;
      field357 = 2;
      field379 = 0;
      field555 = 2;
      field360 = 0;
      field361 = 1;
      field362 = 0;
      field546 = 0;
      field364 = 2;
      field365 = 0;
      field449 = 1;
      field367 = 0;
      field409 = 0;
      field424 = 2301979;
      field373 = 5063219;
      field374 = 3353893;
      field375 = 7759444;
      field327 = false;
      field377 = 0;
      field554 = 128;
      field495 = 0;
      field380 = 0;
      field537 = 0;
      field475 = 0;
      field383 = 0;
      field333 = 50;
      field352 = 0;
      field386 = false;
      field387 = 0;
      field388 = 0;
      field389 = 50;
      field381 = new int[field389];
      field391 = new int[field389];
      field392 = new int[field389];
      field393 = new int[field389];
      field394 = new int[field389];
      field575 = new int[field389];
      field396 = new int[field389];
      field411 = new String[field389];
      field398 = new int[104][104];
      field399 = 0;
      field400 = 1;
      field401 = 1;
      field402 = 0;
      field403 = 0;
      field355 = 0;
      field405 = 0;
      field406 = 0;
      field350 = 0;
      field408 = 0;
      field510 = 0;
      field493 = 0;
      field549 = 0;
      field412 = false;
      field413 = 0;
      field414 = 0;
      field415 = new class2[2048];
      field416 = -1;
      field459 = 0;
      field577 = 0;
      field410 = new int[1000];
      field525 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field432 = new String[8];
      field520 = new boolean[8];
      field434 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field521 = -1;
      field419 = new class198[4][104][104];
      field427 = new class198();
      field385 = new class198();
      field429 = new class198();
      field430 = new int[25];
      field337 = new int[25];
      field290 = new int[25];
      field433 = 0;
      field470 = false;
      field435 = 0;
      field436 = new int[500];
      field437 = new int[500];
      field302 = new int[500];
      field439 = new int[500];
      field440 = new String[500];
      field445 = new String[500];
      field442 = -1;
      field443 = -1;
      field494 = 0;
      field395 = 50;
      field446 = 0;
      field447 = null;
      field448 = false;
      field382 = -1;
      field450 = -1;
      field451 = null;
      field452 = null;
      field453 = -1;
      field454 = new class195(8);
      field455 = 0;
      field456 = 0;
      field431 = null;
      field458 = 0;
      field336 = 0;
      field460 = 0;
      field461 = -1;
      field471 = false;
      field463 = false;
      field464 = false;
      field465 = null;
      field466 = null;
      field566 = null;
      field468 = 0;
      field469 = 0;
      field368 = null;
      field498 = false;
      field480 = -1;
      field473 = -1;
      field474 = false;
      field423 = -1;
      field476 = -1;
      field565 = false;
      field479 = 1;
      field338 = new int[32];
      field481 = 0;
      field467 = new int[32];
      field483 = 0;
      field484 = new int[32];
      field485 = 0;
      field486 = 0;
      field496 = 0;
      field544 = 0;
      field489 = 0;
      field490 = 0;
      field491 = 0;
      field492 = 0;
      field292 = new class198();
      field293 = new class198();
      field320 = new class198();
      field366 = new class195(512);
      field497 = 0;
      field322 = -2;
      field499 = new boolean[100];
      field500 = new boolean[100];
      field501 = new boolean[100];
      field502 = new int[100];
      field515 = new int[100];
      field504 = new int[100];
      field505 = new int[100];
      field522 = 0;
      field507 = 0L;
      field508 = true;
      field417 = 1;
      field518 = 1;
      field516 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field512 = 0;
      field482 = 0;
      field514 = "";
      field339 = new long[100];
      field561 = 0;
      field517 = 0;
      field548 = new int[128];
      field519 = new int[128];
      field563 = -1L;
      field438 = null;
      field314 = null;
      field523 = 1;
      field524 = 0;
      field363 = new int[1000];
      field526 = new int[1000];
      field317 = new class78[1000];
      field528 = 0;
      field529 = 0;
      field530 = 0;
      field531 = 255;
      field532 = -1;
      field533 = false;
      field534 = 127;
      field535 = 127;
      field536 = 0;
      field326 = new int[50];
      field538 = new int[50];
      field539 = new int[50];
      field503 = new int[50];
      field541 = new class58[50];
      field542 = false;
      field390 = new boolean[5];
      field425 = new int[5];
      field511 = new int[5];
      field547 = new int[5];
      field422 = new int[5];
      field441 = 256;
      field550 = 205;
      field551 = 256;
      field457 = 320;
      field553 = 1;
      field372 = 32767;
      field325 = 1;
      field556 = 32767;
      field557 = 0;
      field558 = 0;
      field559 = 0;
      field560 = 0;
      field347 = 0;
      field562 = 0;
      field369 = 0;
      field513 = new class17[400];
      field428 = new class194();
      field509 = 0;
      field568 = new class7[400];
      field378 = new class178();
      field570 = 1;
      field571 = 1;
      field572 = new class219[8];
      field573 = -1L;
      field574 = -1L;
      field291 = new class10();
      field576 = new int[50];
      field300 = new int[50];
   }

   @ObfuscatedName("f")
   protected final void vmethod3056() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1742780065"
   )
   protected final void vmethod3055() {
      boolean var1;
      label222: {
         try {
            if(class182.field2947 == 2) {
               if(null == class182.field2950) {
                  class182.field2950 = class179.method3529(class182.field2946, class182.field2945, class182.field2948);
                  if(null == class182.field2950) {
                     var1 = false;
                     break label222;
                  }
               }

               if(null == class136.field2121) {
                  class136.field2121 = new class59(class182.field2943, class182.field2944);
               }

               if(class182.field2942.method3624(class182.field2950, class21.field593, class136.field2121, 22050)) {
                  class182.field2942.method3625();
                  class182.field2942.method3622(class134.field2077);
                  class182.field2942.method3727(class182.field2950, class182.field2949);
                  class182.field2947 = 0;
                  class182.field2950 = null;
                  class136.field2121 = null;
                  class182.field2946 = null;
                  var1 = true;
                  break label222;
               }
            }
         } catch (Exception var9) {
            var9.printStackTrace();
            class182.field2942.method3628();
            class182.field2947 = 0;
            class182.field2950 = null;
            class136.field2121 = null;
            class182.field2946 = null;
         }

         var1 = false;
      }

      if(var1 && field533 && class76.field1380 != null) {
         class76.field1380.method1196();
      }

      int var5;
      if(10 == field552 || field552 == 20 || 30 == field552) {
         if(0L != field507 && class18.method214() > field507) {
            int var3 = field508?2:1;
            field507 = 0L;
            if(var3 >= 2) {
               field508 = true;
            } else {
               field508 = false;
            }

            class83.method1910();
            if(field552 >= 25) {
               field301.method2753(78);
               class121 var4 = field301;
               var5 = field508?2:1;
               var4.method2497(var5);
               field301.method2498(class6.field107);
               field301.method2498(class31.field749);
            }

            class143.field2190 = true;
         } else if(class143.field2192) {
            class170.method3412();
         }
      }

      Dimension var10 = this.method3037();
      if(var10.width != class218.field3161 || var10.height != class42.field1005 || class143.field2187) {
         class83.method1910();
         field507 = class18.method214() + 500L;
         class143.field2187 = false;
      }

      boolean var11 = false;
      if(class143.field2190) {
         class143.field2190 = false;
         var11 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field499[var5] = true;
         }
      }

      if(var11) {
         class38.method767();
      }

      if(field552 == 0) {
         class39.method801(class31.field750, class31.field740, (Color)null, var11);
      } else if(5 == field552) {
         class76.method1688(class38.field876, class95.field1627, class72.field1348, var11);
      } else if(10 != field552 && 11 != field552) {
         if(field552 == 20) {
            class76.method1688(class38.field876, class95.field1627, class72.field1348, var11);
         } else if(field552 == 25) {
            if(field351 == 1) {
               if(field444 > field348) {
                  field348 = field444;
               }

               var5 = (field348 * 50 - field444 * 50) / field348;
               class185.method3778("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field351 == 2) {
               if(field349 > field478) {
                  field478 = field349;
               }

               var5 = 50 + (field478 * 50 - field349 * 50) / field478;
               class185.method3778("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class185.method3778("Loading - please wait.", false);
            }
         } else if(30 == field552) {
            class120.method2748();
         } else if(field552 == 40) {
            class185.method3778("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(45 == field552) {
            class185.method3778("Please wait...", false);
         }
      } else {
         class76.method1688(class38.field876, class95.field1627, class72.field1348, var11);
      }

      int var6;
      Graphics var12;
      if(30 == field552 && 0 == field522 && !var11) {
         try {
            var12 = class45.field1042.getGraphics();

            for(var6 = 0; var6 < field497; ++var6) {
               if(field500[var6]) {
                  class139.field2149.vmethod1895(var12, field502[var6], field515[var6], field504[var6], field505[var6]);
                  field500[var6] = false;
               }
            }
         } catch (Exception var8) {
            class45.field1042.repaint();
         }
      } else if(field552 > 0) {
         try {
            var12 = class45.field1042.getGraphics();
            class139.field2149.vmethod1900(var12, 0, 0);

            for(var6 = 0; var6 < field497; ++var6) {
               field500[var6] = false;
            }
         } catch (Exception var7) {
            class45.field1042.repaint();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1772687788"
   )
   protected final void vmethod3031() {
      class72.field1350 = 0 == field295?'ꩊ':'鱀' + field527;
      class94.field1612 = 0 == field295?443:'썐' + field527;
      class36.field800 = class72.field1350;
      class106.field1865 = class173.field2877;
      class123.field2027 = class173.field2880;
      class178.field2908 = class173.field2878;
      class178.field2914 = class173.field2879;
      if(class135.field2080.toLowerCase().indexOf("microsoft") != -1) {
         class136.field2118[186] = 57;
         class136.field2118[187] = 27;
         class136.field2118[188] = 71;
         class136.field2118[189] = 26;
         class136.field2118[190] = 72;
         class136.field2118[191] = 73;
         class136.field2118[192] = 58;
         class136.field2118[219] = 42;
         class136.field2118[220] = 74;
         class136.field2118[221] = 43;
         class136.field2118[222] = 59;
         class136.field2118[223] = 28;
      } else {
         class136.field2118[44] = 71;
         class136.field2118[45] = 26;
         class136.field2118[46] = 72;
         class136.field2118[47] = 73;
         class136.field2118[59] = 57;
         class136.field2118[61] = 27;
         class136.field2118[91] = 42;
         class136.field2118[92] = 74;
         class136.field2118[93] = 43;
         class136.field2118[192] = 28;
         class136.field2118[222] = 58;
         class136.field2118[520] = 59;
      }

      class18.method207(class45.field1042);
      class98.method2217(class45.field1042);
      class107.field1894 = class14.method184();
      if(class107.field1894 != null) {
         class107.field1894.vmethod3115(class45.field1042);
      }

      class15.field220 = new class133(255, class148.field2225, class148.field2221, 500000);
      class89.field1548 = class101.method2293();
      class159.field2614 = this.getToolkit().getSystemClipboard();
      class25.method620(this, class174.field2889);
      if(field295 != 0) {
         field309 = true;
      }

      int var1 = class89.field1548.field133;
      field507 = 0L;
      if(var1 >= 2) {
         field508 = true;
      } else {
         field508 = false;
      }

      class83.method1910();
      if(field552 >= 25) {
         field301.method2753(78);
         class121 var2 = field301;
         int var3 = field508?2:1;
         var2.method2497(var3);
         field301.method2498(class6.field107);
         field301.method2498(class31.field749);
      }

      class143.field2190 = true;
   }

   public final void init() {
      if(this.method3023()) {
         class189[] var1 = class10.method148();

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            class189 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3049);
            if(null != var4) {
               switch(Integer.parseInt(var3.field3049)) {
               case 1:
                  if(var4.equalsIgnoreCase("true")) {
                     field296 = true;
                  } else {
                     field296 = false;
                  }
                  break;
               case 2:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 3:
                  class3.field58 = var4;
               case 4:
               case 5:
               case 11:
               default:
                  break;
               case 6:
                  field295 = Integer.parseInt(var4);
                  break;
               case 7:
                  class18.field274 = (class153)class155.method3174(class32.method713(), Integer.parseInt(var4));
                  if(class18.field274 == class153.field2271) {
                     class132.field2062 = class211.field3130;
                  } else {
                     class132.field2062 = class211.field3134;
                  }
                  break;
               case 8:
                  field462 = Integer.parseInt(var4);
                  break;
               case 9:
                  field506 = Integer.parseInt(var4);
                  break;
               case 10:
                  field299 = Integer.parseInt(var4);
                  break;
               case 12:
                  field527 = Integer.parseInt(var4);
                  break;
               case 13:
                  var6 = Integer.parseInt(var4);
                  class152[] var7 = new class152[]{class152.field2258, class152.field2256, class152.field2265, class152.field2257};
                  class152[] var8 = var7;
                  int var9 = 0;

                  class152 var5;
                  while(true) {
                     if(var9 >= var8.length) {
                        var5 = null;
                        break;
                     }

                     class152 var10 = var8[var9];
                     if(var6 == var10.field2260) {
                        var5 = var10;
                        break;
                     }

                     ++var9;
                  }

                  field294 = var5;
                  break;
               case 14:
                  class208.field3114 = var4;
                  break;
               case 15:
                  field298 = Integer.parseInt(var4);
               }
            }
         }

         class110.method2433();
         class32.field768 = this.getCodeBase().getHost();
         String var16 = field294.field2259;
         byte var17 = 0;

         try {
            class95.field1619 = 16;
            class134.field2078 = var17;

            try {
               class148.field2226 = System.getProperty("os.name");
            } catch (Exception var13) {
               class148.field2226 = "Unknown";
            }

            class118.field1986 = class148.field2226.toLowerCase();

            try {
               class140.field2161 = System.getProperty("user.home");
               if(class140.field2161 != null) {
                  class140.field2161 = class140.field2161 + "/";
               }
            } catch (Exception var12) {
               ;
            }

            try {
               if(class118.field1986.startsWith("win")) {
                  if(class140.field2161 == null) {
                     class140.field2161 = System.getenv("USERPROFILE");
                  }
               } else if(null == class140.field2161) {
                  class140.field2161 = System.getenv("HOME");
               }

               if(class140.field2161 != null) {
                  class140.field2161 = class140.field2161 + "/";
               }
            } catch (Exception var11) {
               ;
            }

            if(class140.field2161 == null) {
               class140.field2161 = "~/";
            }

            class0.field12 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class140.field2161, "/tmp/", ""};
            class122.field2013 = new String[]{".jagex_cache_" + class134.field2078, ".file_store_" + class134.field2078};

            int var18;
            label155:
            for(var18 = 0; var18 < 4; ++var18) {
               class148.field2219 = class39.method804("oldschool", var16, var18);
               if(!class148.field2219.exists()) {
                  class148.field2219.mkdirs();
               }

               File[] var20 = class148.field2219.listFiles();
               if(var20 == null) {
                  break;
               }

               File[] var23 = var20;
               var6 = 0;

               while(true) {
                  if(var6 >= var23.length) {
                     break label155;
                  }

                  File var26 = var23[var6];
                  if(!class141.method2996(var26, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            class21.method562(class148.field2219);

            try {
               File var19 = new File(class140.field2161, "random.dat");
               int var24;
               if(var19.exists()) {
                  class148.field2223 = new class227(new class226(var19, "rw", 25L), 24, 0);
               } else {
                  label135:
                  for(int var21 = 0; var21 < class122.field2013.length; ++var21) {
                     for(var24 = 0; var24 < class0.field12.length; ++var24) {
                        File var25 = new File(class0.field12[var24] + class122.field2013[var21] + File.separatorChar + "random.dat");
                        if(var25.exists()) {
                           class148.field2223 = new class227(new class226(var25, "rw", 25L), 24, 0);
                           break label135;
                        }
                     }
                  }
               }

               if(null == class148.field2223) {
                  RandomAccessFile var22 = new RandomAccessFile(var19, "rw");
                  var24 = var22.read();
                  var22.seek(0L);
                  var22.write(var24);
                  var22.seek(0L);
                  var22.close();
                  class148.field2223 = new class227(new class226(var19, "rw", 25L), 24, 0);
               }
            } catch (IOException var14) {
               ;
            }

            class148.field2225 = new class227(new class226(class21.method574("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class148.field2221 = new class227(new class226(class21.method574("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class228.field3221 = new class227[class95.field1619];

            for(var18 = 0; var18 < class95.field1619; ++var18) {
               class228.field3221[var18] = new class227(new class226(class21.method574("main_file_cache.idx" + var18), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var15) {
            class28.method651((String)null, var15);
         }

         field540 = this;
         this.method3021(765, 503, 109);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "128"
   )
   void method532() {
      if(class170.field2720 >= 4) {
         this.method3075("js5crc");
         field552 = 1000;
      } else {
         if(class170.field2721 >= 4) {
            if(field552 <= 5) {
               this.method3075("js5io");
               field552 = 1000;
               return;
            }

            field323 = -327848;
            class170.field2721 = 3;
         }

         if((field323 -= 1450267181) * 331926949 + 1 <= 0) {
            try {
               if(field404 == 0) {
                  class32.field769 = class129.field2056.method2884(class32.field768, class36.field800);
                  ++field404;
               }

               if(field404 == 1) {
                  if(class32.field769.field2202 == 2) {
                     this.method258(-1);
                     return;
                  }

                  if(class32.field769.field2202 == 1) {
                     ++field404;
                  }
               }

               if(field404 == 2) {
                  class164.field2649 = new class142((Socket)class32.field769.field2206, class129.field2056);
                  class118 var1 = new class118(5);
                  var1.method2497(15);
                  var1.method2663(109);
                  class164.field2649.method3003(var1.field1980, 0, 5);
                  ++field404;
                  class72.field1357 = class18.method214();
               }

               if(field404 == 3) {
                  if(field552 > 5 && class164.field2649.method3001() <= 0) {
                     if(class18.method214() - class72.field1357 > 30000L) {
                        this.method258(-2);
                        return;
                     }
                  } else {
                     int var9 = class164.field2649.method3005();
                     if(0 != var9) {
                        this.method258(var9);
                        return;
                     }

                     ++field404;
                  }
               }

               if(4 == field404) {
                  class142 var10 = class164.field2649;
                  boolean var2 = field552 > 20;
                  if(null != class89.field1549) {
                     try {
                        class89.field1549.method3019();
                     } catch (Exception var7) {
                        ;
                     }

                     class89.field1549 = null;
                  }

                  class89.field1549 = var10;
                  class1.method16(var2);
                  class170.field2714.field1979 = 0;
                  class106.field1868 = null;
                  class76.field1388 = null;
                  class170.field2706 = 0;

                  while(true) {
                     class171 var3 = (class171)class170.field2707.method3836();
                     if(null == var3) {
                        while(true) {
                           var3 = (class171)class170.field2712.method3836();
                           if(var3 == null) {
                              if(class170.field2719 != 0) {
                                 try {
                                    class118 var11 = new class118(4);
                                    var11.method2497(4);
                                    var11.method2497(class170.field2719);
                                    var11.method2498(0);
                                    class89.field1549.method3003(var11.field1980, 0, 4);
                                 } catch (IOException var6) {
                                    try {
                                       class89.field1549.method3019();
                                    } catch (Exception var5) {
                                       ;
                                    }

                                    ++class170.field2721;
                                    class89.field1549 = null;
                                 }
                              }

                              class170.field2716 = 0;
                              class170.field2704 = class18.method214();
                              class32.field769 = null;
                              class164.field2649 = null;
                              field404 = 0;
                              field324 = 0;
                              return;
                           }

                           class170.field2709.method3909(var3);
                           class170.field2718.method3831(var3, var3.field3111);
                           ++class170.field2711;
                           --class170.field2713;
                        }
                     }

                     class170.field2705.method3831(var3, var3.field3111);
                     ++class170.field2725;
                     --class170.field2717;
                  }
               }
            } catch (IOException var8) {
               this.method258(-3);
            }

         }
      }
   }

   @ObfuscatedName("cw")
   static final String[] method553(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
