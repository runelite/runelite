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
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
public final class client extends class147 {
   @ObfuscatedName("ij")
   @Export("menuIdentifiers")
   static int[] field291;
   @ObfuscatedName("ai")
   static class21 field292;
   @ObfuscatedName("r")
   static boolean field293 = true;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = 526628039
   )
   static int field294;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 1104562681
   )
   static int field295;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -5805477209415635149L
   )
   static long field296 = -1L;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1313921969
   )
   static int field297 = 0;
   @ObfuscatedName("u")
   static class157 field298;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 151760669
   )
   static int field299;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1832443155
   )
   static int field300;
   @ObfuscatedName("m")
   static boolean field301 = false;
   @ObfuscatedName("gi")
   @Export("cachedPlayers")
   static class2[] field302;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -128579603
   )
   @Export("gameState")
   static int field303 = 0;
   @ObfuscatedName("i")
   static boolean field304 = true;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -651791851
   )
   @Export("gameCycle")
   static int field305 = 0;
   @ObfuscatedName("ib")
   static String field306;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2101101309
   )
   static int field307 = -1;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1193774761
   )
   static int field308;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1961244509
   )
   static int field309 = -1;
   @ObfuscatedName("as")
   static boolean field310 = true;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -765417891
   )
   static int field311;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1651350681
   )
   static int field312 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1241413929
   )
   static int field313 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1062849293
   )
   static int field314 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1191766349
   )
   static int field315 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1281085977
   )
   static int field316 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 352938515
   )
   static int field317 = 0;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -2128586183
   )
   static int field318;
   @ObfuscatedName("nt")
   static int[] field319;
   @ObfuscatedName("os")
   static short field320;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 584939191
   )
   static int field321;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -1417110967
   )
   static int field322;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 735649289
   )
   static int field323;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1030370211
   )
   static int field324;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1509899973
   )
   static int field325;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 72957227
   )
   static int field326 = 0;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 28750497
   )
   static int field327;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -2114936013
   )
   static int field328;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1864487541
   )
   static int field329;
   @ObfuscatedName("fx")
   static int[] field330;
   @ObfuscatedName("ns")
   static boolean[] field331;
   @ObfuscatedName("ce")
   @Export("cachedNPCs")
   static class36[] field332;
   @ObfuscatedName("cz")
   static class125 field333;
   @ObfuscatedName("cl")
   static int[] field334;
   @ObfuscatedName("kt")
   static class202 field335;
   @ObfuscatedName("cf")
   static int[] field336;
   @ObfuscatedName("ck")
   static class125 field337;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 4384203
   )
   static int field338;
   @ObfuscatedName("cs")
   static class125 field339;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1131162623
   )
   static int field340;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1386923093
   )
   @Export("packetOpcode")
   static int field341;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 258285241
   )
   static int field342;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 303362511
   )
   static int field343;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -791961543
   )
   static int field344;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -2027658765
   )
   static int field345;
   @ObfuscatedName("jm")
   static boolean field346;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1594116775
   )
   static int field347;
   @ObfuscatedName("cr")
   static boolean field348;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 2082208315
   )
   static int field349;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1180195049
   )
   static int field350;
   @ObfuscatedName("on")
   static class198 field351;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      longValue = 1097460561611054187L
   )
   static long field352;
   @ObfuscatedName("kp")
   static class202 field353;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class111[] field354;
   @ObfuscatedName("dp")
   static boolean field355;
   @ObfuscatedName("dx")
   static int[][][] field356;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 1044551677
   )
   static int field357;
   @ObfuscatedName("hu")
   static int[] field358;
   @ObfuscatedName("oj")
   static short field359;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1275270817
   )
   static int field360;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -1399761199
   )
   static int field361;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -578918681
   )
   static int field362;
   @ObfuscatedName("mq")
   static String field363;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1535764481
   )
   static int field364;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -571506033
   )
   @Export("mapScale")
   static int field365;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -802849343
   )
   static int field366;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 1588152977
   )
   @Export("mapScaleDelta")
   static int field367;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -403216701
   )
   @Export("menuOptionCount")
   static int field368;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 642218611
   )
   static int field369;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 171016569
   )
   static int field370;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = 1780135451
   )
   @Export("flagX")
   static int field371;
   @ObfuscatedName("ef")
   static class83[] field372;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -556220269
   )
   static int field373;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -1938460569
   )
   static int field374;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -63626255
   )
   static int field375 = 0;
   @ObfuscatedName("jo")
   static class176 field376;
   @ObfuscatedName("ex")
   static boolean field377;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -1590197449
   )
   static int field378;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 24709633
   )
   static int field379;
   @ObfuscatedName("fl")
   static int[] field380;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -462073287
   )
   static int field381;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1154405977
   )
   static int field382;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 282891077
   )
   static int field383;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -606754529
   )
   static int field384 = 0;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 2089491583
   )
   static int field385;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -315049547
   )
   static int field386;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -748014477
   )
   static int field387;
   @ObfuscatedName("hi")
   static int[] field388;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -1673003057
   )
   static int field389;
   @ObfuscatedName("jb")
   static boolean field390;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -903313301
   )
   @Export("friendCount")
   static int field391;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 202303965
   )
   @Export("scale")
   static int field392;
   @ObfuscatedName("oe")
   static int[] field393;
   @ObfuscatedName("fo")
   static int[] field394;
   @ObfuscatedName("fu")
   static int[] field395;
   @ObfuscatedName("fe")
   static int[] field396;
   @ObfuscatedName("ja")
   static class176 field397;
   @ObfuscatedName("ga")
   static String[] field398;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -791997341
   )
   @Export("mapAngle")
   static int field399;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1464191669
   )
   static int field400;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 962320993
   )
   static int field401;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 531475953
   )
   static int field402;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -1539160087
   )
   static int field403;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 947135043
   )
   static int field404;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -9389313
   )
   static int field405;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -136983527
   )
   static int field406;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 480956447
   )
   @Export("world")
   static int field407 = 1;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -723753201
   )
   static int field408;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -2051633197
   )
   static int field409;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 567789021
   )
   static int field410;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1258552325
   )
   static int field411;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -1877490483
   )
   static int field412;
   @ObfuscatedName("gz")
   static boolean field413;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -1359409497
   )
   static int field414;
   @ObfuscatedName("ll")
   static String field415;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 1886754803
   )
   static int field416;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -58295201
   )
   @Export("localInteractingIndex")
   static int field417;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1090404665
   )
   static int field418;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 575506713
   )
   static int field419;
   @ObfuscatedName("aj")
   static class21 field420;
   @ObfuscatedName("hx")
   static final int[] field421;
   @ObfuscatedName("ht")
   static String[] field422;
   @ObfuscatedName("hq")
   static boolean[] field423;
   @ObfuscatedName("lm")
   static int[] field424;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -1077001167
   )
   static int field425;
   @ObfuscatedName("ha")
   @Export("groundItemDeque")
   static class202[][][] field426;
   @ObfuscatedName("hk")
   static class202 field427;
   @ObfuscatedName("hz")
   @Export("projectiles")
   static class202 field428;
   @ObfuscatedName("hs")
   static class202 field429;
   @ObfuscatedName("ho")
   @Export("boostedSkillLevels")
   static int[] field430;
   @ObfuscatedName("hp")
   @Export("realSkillLevels")
   static int[] field431;
   @ObfuscatedName("hj")
   @Export("skillExperiences")
   static int[] field432;
   @ObfuscatedName("ac")
   static boolean field433 = false;
   @ObfuscatedName("hf")
   @Export("isMenuOpen")
   static boolean field434;
   @ObfuscatedName("ky")
   @Export("widgetFlags")
   static class199 field435;
   @ObfuscatedName("hn")
   @Export("menuActionParams0")
   static int[] field436;
   @ObfuscatedName("hh")
   @Export("menuActionParams1")
   static int[] field437;
   @ObfuscatedName("iq")
   @Export("menuTypes")
   static int[] field438;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -640807227
   )
   static int field439;
   @ObfuscatedName("ih")
   @Export("menuOptions")
   static String[] field440;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -1711886081
   )
   static int field441;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -1459320581
   )
   static int field442;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -1312862699
   )
   static int field443;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -845924365
   )
   static int field444;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 935141043
   )
   static int field445;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 834204883
   )
   static int field446;
   @ObfuscatedName("ix")
   static String field447;
   @ObfuscatedName("ie")
   static boolean field448;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = 763544611
   )
   static int field449;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 471491289
   )
   static int field450;
   @ObfuscatedName("bo")
   static class171 field451;
   @ObfuscatedName("is")
   static String field452;
   @ObfuscatedName("mp")
   static class81[] field453;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -936841739
   )
   static int field454;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -1000966459
   )
   static int field455;
   @ObfuscatedName("og")
   @Export("friends")
   static class17[] field456;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = 1383965319
   )
   static int field457;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -1309145985
   )
   @Export("energy")
   static int field458;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 1826321473
   )
   static int field459;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 1415391863
   )
   static int field460;
   @ObfuscatedName("s")
   static class156 field461;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -738327549
   )
   static int field462;
   @ObfuscatedName("ez")
   static class81[] field463;
   @ObfuscatedName("jn")
   static boolean field464;
   @ObfuscatedName("ji")
   static class176 field465;
   @ObfuscatedName("ju")
   static class176 field466;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1149900521
   )
   static int field467;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1420441921
   )
   static int field468 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = 2794932120427165803L
   )
   static long field469;
   @ObfuscatedName("jp")
   static class176 field470;
   @ObfuscatedName("js")
   static boolean field471;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 1977658807
   )
   static int field472;
   @ObfuscatedName("lx")
   static int[] field473;
   @ObfuscatedName("jw")
   static boolean field474;
   @ObfuscatedName("iy")
   @Export("componentTable")
   static class199 field475;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 91755149
   )
   static int field476;
   @ObfuscatedName("g")
   static client field477;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -641949713
   )
   static int field478;
   @ObfuscatedName("ko")
   static int[] field479;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 823704217
   )
   static int field480;
   @ObfuscatedName("kf")
   static int[] field481;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 1977690063
   )
   static int field482;
   @ObfuscatedName("kl")
   static int[] field483;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 324427853
   )
   static int field484;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -40499225
   )
   static int field485;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1102091813
   )
   static int field486;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -1096332643
   )
   static int field487;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -192300651
   )
   static int field488;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -265128177
   )
   static int field490;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = 831320759
   )
   static int field491;
   @ObfuscatedName("ot")
   static short field492;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 1514490133
   )
   static int field493;
   @ObfuscatedName("ku")
   static class202 field494;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -990967083
   )
   @Export("widgetRoot")
   static int field495;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -1441624623
   )
   static int field496;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 329089063
   )
   static int field497;
   @ObfuscatedName("kx")
   static boolean[] field498;
   @ObfuscatedName("lw")
   static boolean[] field499;
   @ObfuscatedName("ld")
   static boolean[] field500;
   @ObfuscatedName("la")
   @Export("widgetPositionX")
   static int[] field501;
   @ObfuscatedName("lq")
   @Export("widgetPositionY")
   static int[] field502;
   @ObfuscatedName("ln")
   @Export("widgetBoundsWidth")
   static int[] field503;
   @ObfuscatedName("lc")
   @Export("widgetBoundsHeight")
   static int[] field504;
   @ObfuscatedName("fm")
   static int[] field505;
   @ObfuscatedName("jh")
   static boolean field506;
   @ObfuscatedName("lk")
   @Export("isResized")
   static boolean field507;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1723166407
   )
   static int field508;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -481400775
   )
   static int field509;
   @ObfuscatedName("il")
   @Export("menuTargets")
   static String[] field510;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 1004528177
   )
   static int field511;
   @ObfuscatedName("mc")
   static int[] field512;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -1736137023
   )
   static int field513;
   @ObfuscatedName("lu")
   static long[] field514;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 1991908345
   )
   static int field515;
   @ObfuscatedName("fj")
   static int[] field516;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1572209503
   )
   static int field517 = 0;
   @ObfuscatedName("n")
   static class215 field518;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      longValue = 1014551064618918831L
   )
   static long field519;
   @ObfuscatedName("b")
   @Export("isMembers")
   static boolean field520 = false;
   @ObfuscatedName("mz")
   static String field521;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 1115029881
   )
   static int field522;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -1245637309
   )
   static int field523;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 465152893
   )
   static int field524;
   @ObfuscatedName("mv")
   static int[] field525;
   @ObfuscatedName("mt")
   static int[] field526;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 96703413
   )
   static int field527;
   @ObfuscatedName("nz")
   static int[] field528;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 595976637
   )
   @Export("flagY")
   static int field529;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -1370801387
   )
   static int field530;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -806775011
   )
   static int field531;
   @ObfuscatedName("dc")
   static final int[] field532;
   @ObfuscatedName("mx")
   static boolean field533;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -1065047355
   )
   static int field534;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = 2120970875
   )
   static int field535;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -1362204189
   )
   static int field536;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -1937841273
   )
   static int field537;
   @ObfuscatedName("ni")
   static int[] field538;
   @ObfuscatedName("ny")
   static int[] field539;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -779728595
   )
   static int field540;
   @ObfuscatedName("na")
   static class61[] field541;
   @ObfuscatedName("ne")
   static boolean field542;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -604062125
   )
   static int field543;
   @ObfuscatedName("ok")
   static int[] field544;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -313000267
   )
   @Export("weight")
   static int field545;
   @ObfuscatedName("or")
   static int[] field546;
   @ObfuscatedName("od")
   static int[] field547;
   @ObfuscatedName("oq")
   static short field548;
   @ObfuscatedName("of")
   static short field549;
   @ObfuscatedName("fq")
   static boolean field550;
   @ObfuscatedName("oo")
   static short field551;
   @ObfuscatedName("oa")
   static short field552;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 1833268723
   )
   static int field553;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -218196363
   )
   static int field554;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -331021863
   )
   static int field555;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -1464332471
   )
   static int field556;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 1294978083
   )
   static int field557;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 110362467
   )
   @Export("camera2")
   static int field558;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 2023179217
   )
   @Export("camera3")
   static int field559;
   @ObfuscatedName("gk")
   static int[][] field560;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -420859049
   )
   @Export("flags")
   static int field561 = 0;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -337140947
   )
   static int field562;
   @ObfuscatedName("oh")
   static short field563;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1437767961
   )
   static int field564;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 935714291
   )
   @Export("ignoreCount")
   static int field565;
   @ObfuscatedName("oz")
   @Export("ignores")
   static class7[] field566;
   @ObfuscatedName("ou")
   static class182 field567;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = -2046158393
   )
   static int field568;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = 1973071615
   )
   static int field569;
   @ObfuscatedName("po")
   @Export("grandExchangeOffers")
   static class223[] field570;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      longValue = -3576225636231662799L
   )
   static long field571;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      longValue = -6520205773268932699L
   )
   static long field572;
   @ObfuscatedName("pf")
   static final class10 field573;
   @ObfuscatedName("pw")
   static int[] field574;
   @ObfuscatedName("pz")
   static int[] field575;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -1493308013
   )
   static int field576;

   public final void init() {
      if(this.method3157()) {
         class193[] var1 = new class193[]{class193.field3116, class193.field3118, class193.field3109, class193.field3122, class193.field3108, class193.field3114, class193.field3120, class193.field3119, class193.field3110, class193.field3117, class193.field3113, class193.field3112, class193.field3111, class193.field3121, class193.field3115};
         class193[] var2 = var1;

         int var3;
         String var5;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class193 var4 = var2[var3];
            var5 = this.getParameter(var4.field3123);
            if(null != var5) {
               switch(Integer.parseInt(var4.field3123)) {
               case 2:
                  class165.field2705 = Integer.parseInt(var5);
                  break;
               case 3:
                  field298 = (class157)class85.method1971(class8.method122(), Integer.parseInt(var5));
                  if(field298 == class157.field2345) {
                     field518 = class215.field3190;
                  } else {
                     field518 = class215.field3198;
                  }
                  break;
               case 4:
                  class133.field2112 = Integer.parseInt(var5);
                  break;
               case 5:
                  class15.field223 = var5;
                  break;
               case 6:
                  field326 = Integer.parseInt(var5);
               case 7:
               case 12:
               default:
                  break;
               case 8:
                  field561 = Integer.parseInt(var5);
                  break;
               case 9:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 10:
                  field407 = Integer.parseInt(var5);
                  break;
               case 11:
                  field297 = Integer.parseInt(var5);
                  break;
               case 13:
                  class48.field1097 = var5;
                  break;
               case 14:
                  field461 = class119.method2574(Integer.parseInt(var5));
                  break;
               case 15:
                  if(var5.equalsIgnoreCase("true")) {
                     field520 = true;
                  } else {
                     field520 = false;
                  }
               }
            }
         }

         class36.method776();
         class105.field1842 = this.getCodeBase().getHost();
         String var32 = field461.field2336;
         byte var17 = 0;

         try {
            class152.field2298 = 16;
            class15.field227 = var17;

            try {
               class24.field620 = System.getProperty("os.name");
            } catch (Exception var28) {
               class24.field620 = "Unknown";
            }

            class101.field1746 = class24.field620.toLowerCase();

            try {
               class3.field67 = System.getProperty("user.home");
               if(null != class3.field67) {
                  class3.field67 = class3.field67 + "/";
               }
            } catch (Exception var27) {
               ;
            }

            try {
               if(class101.field1746.startsWith("win")) {
                  if(null == class3.field67) {
                     class3.field67 = System.getenv("USERPROFILE");
                  }
               } else if(class3.field67 == null) {
                  class3.field67 = System.getenv("HOME");
               }

               if(null != class3.field67) {
                  class3.field67 = class3.field67 + "/";
               }
            } catch (Exception var26) {
               ;
            }

            if(class3.field67 == null) {
               class3.field67 = "~/";
            }

            class152.field2292 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class3.field67, "/tmp/", ""};
            class130.field2100 = new String[]{".jagex_cache_" + class15.field227, ".file_store_" + class15.field227};
            var3 = 0;

            label248:
            while(var3 < 4) {
               var5 = var3 == 0?"":"" + var3;
               class175.field2791 = new File(class3.field67, "jagex_cl_oldschool_" + var32 + var5 + ".dat");
               String var6 = null;
               String var7 = null;
               boolean var8 = false;
               class122 var10;
               File var36;
               if(class175.field2791.exists()) {
                  try {
                     class230 var9 = new class230(class175.field2791, "rw", 10000L);

                     int var11;
                     for(var10 = new class122((int)var9.method4273()); var10.field2050 < var10.field2051.length; var10.field2050 += var11) {
                        var11 = var9.method4274(var10.field2051, var10.field2050, var10.field2051.length - var10.field2050);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var10.field2050 = 0;
                     var11 = var10.method2633();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var10.method2633();
                     }

                     if(var11 <= 2) {
                        var6 = var10.method2642();
                        if(var12 == 1) {
                           var7 = var10.method2642();
                        }
                     } else {
                        var6 = var10.method2643();
                        if(var12 == 1) {
                           var7 = var10.method2643();
                        }
                     }

                     var9.method4283();
                  } catch (IOException var30) {
                     var30.printStackTrace();
                  }

                  if(null != var6) {
                     var36 = new File(var6);
                     if(!var36.exists()) {
                        var6 = null;
                     }
                  }

                  if(null != var6) {
                     var36 = new File(var6, "test.dat");
                     if(!class59.method1295(var36, true)) {
                        var6 = null;
                     }
                  }
               }

               if(null == var6 && var3 == 0) {
                  label223:
                  for(int var19 = 0; var19 < class130.field2100.length; ++var19) {
                     for(int var20 = 0; var20 < class152.field2292.length; ++var20) {
                        File var21 = new File(class152.field2292[var20] + class130.field2100[var19] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var21.exists() && class59.method1295(new File(var21, "test.dat"), true)) {
                           var6 = var21.toString();
                           var8 = true;
                           break label223;
                        }
                     }
                  }
               }

               if(null == var6) {
                  var6 = class3.field67 + File.separatorChar + "jagexcache" + var5 + File.separatorChar + "oldschool" + File.separatorChar + var32 + File.separatorChar;
                  var8 = true;
               }

               File var35;
               if(null != var7) {
                  var35 = new File(var7);
                  var36 = new File(var6);

                  try {
                     File[] var38 = var35.listFiles();
                     File[] var22 = var38;

                     for(int var13 = 0; var13 < var22.length; ++var13) {
                        File var14 = var22[var13];
                        File var15 = new File(var36, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var29) {
                     var29.printStackTrace();
                  }

                  var8 = true;
               }

               if(var8) {
                  var35 = new File(var6);
                  var10 = null;

                  try {
                     class230 var39 = new class230(class175.field2791, "rw", 10000L);
                     class122 var40 = new class122(500);
                     var40.method2783(3);
                     Object var10001 = null;
                     var40.method2783(0);
                     var40.method2626(var35.getPath());
                     var39.method4275(var40.field2051, 0, var40.field2050);
                     var39.method4283();
                  } catch (IOException var25) {
                     var25.printStackTrace();
                  }
               }

               File var33 = new File(var6);
               class152.field2300 = var33;
               if(!class152.field2300.exists()) {
                  class152.field2300.mkdirs();
               }

               File[] var34 = class152.field2300.listFiles();
               if(var34 == null) {
                  break;
               }

               File[] var37 = var34;
               int var23 = 0;

               while(true) {
                  if(var23 >= var37.length) {
                     break label248;
                  }

                  File var24 = var37[var23];
                  if(!class59.method1295(var24, false)) {
                     ++var3;
                     break;
                  }

                  ++var23;
               }
            }

            class17.method210(class152.field2300);
            class105.method2383();
            class152.field2296 = new class231(new class230(class180.method3614("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class152.field2297 = new class231(new class230(class180.method3614("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class8.field152 = new class231[class152.field2298];

            for(var3 = 0; var3 < class152.field2298; ++var3) {
               class8.field152[var3] = new class231(new class230(class180.method3614("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var31) {
            class13.method176((String)null, var31);
         }

         field477 = this;
         this.method3155(765, 503, 120);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   protected final void vmethod3166() {
      class12.field198 = field297 == 0?'ꩊ':field407 + '鱀';
      class56.field1235 = field297 == 0?443:field407 + '썐';
      class109.field1943 = class12.field198;
      class182.field2969 = class177.field2943;
      class175.field2794 = class177.field2942;
      class182.field2976 = class177.field2944;
      class105.field1840 = class177.field2945;
      class139.method3032();
      Canvas var1 = class107.field1867;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class140.field2157);
      var1.addFocusListener(class140.field2157);
      class114.method2542(class107.field1867);
      class152.field2302 = class93.method2162();
      if(class152.field2302 != null) {
         class152.field2302.vmethod3251(class107.field1867);
      }

      class159.field2367 = new class137(255, class152.field2296, class152.field2297, 500000);
      class136.field2123 = class4.method45();
      class11.field175 = this.getToolkit().getSystemClipboard();
      String var3 = class118.field2030;
      class141.field2195 = this;
      class141.field2193 = var3;
      if(field297 != 0) {
         field433 = true;
      }

      int var4 = class136.field2123.field146;
      field352 = 0L;
      if(var4 >= 2) {
         field507 = true;
      } else {
         field507 = false;
      }

      class10.method143();
      if(field303 >= 25) {
         class6.method103();
      }

      class147.field2263 = true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1031914960"
   )
   @Export("packetHandler")
   protected final void vmethod3246() {
      ++field305;
      this.method262();
      class53.method1147();

      int var1;
      try {
         if(class186.field3010 == 1) {
            var1 = class59.field1266.method3862();
            if(var1 > 0 && class59.field1266.method3756()) {
               var1 -= class144.field2222;
               if(var1 < 0) {
                  var1 = 0;
               }

               class59.field1266.method3750(var1);
            } else {
               class59.field1266.method3754();
               class59.field1266.method3782();
               if(class111.field1970 != null) {
                  class186.field3010 = 2;
               } else {
                  class186.field3010 = 0;
               }

               class186.field3011 = null;
               class43.field1010 = null;
            }
         }
      } catch (Exception var24) {
         var24.printStackTrace();
         class59.field1266.method3754();
         class186.field3010 = 0;
         class186.field3011 = null;
         class43.field1010 = null;
         class111.field1970 = null;
      }

      class47.method1009();
      class140 var14 = class140.field2157;
      int var2;
      synchronized(class140.field2157) {
         ++class140.field2182;
         class140.field2179 = class140.field2159;
         class140.field2178 = 0;
         if(class140.field2168 >= 0) {
            while(class140.field2168 != class140.field2173) {
               var2 = class140.field2181[class140.field2173];
               class140.field2173 = 1 + class140.field2173 & 127;
               if(var2 < 0) {
                  class140.field2171[~var2] = false;
               } else {
                  if(!class140.field2171[var2] && class140.field2178 < class140.field2161.length - 1) {
                     class140.field2161[++class140.field2178 - 1] = var2;
                  }

                  class140.field2171[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               class140.field2171[var2] = false;
            }

            class140.field2168 = class140.field2173;
         }

         class140.field2159 = class140.field2180;
      }

      class143 var37 = class143.field2202;
      synchronized(class143.field2202) {
         class143.field2207 = class143.field2204;
         class143.field2206 = class143.field2205;
         class143.field2209 = class143.field2214;
         class143.field2217 = class143.field2210;
         class143.field2215 = class143.field2211;
         class143.field2216 = class143.field2212;
         class143.field2208 = class143.field2213;
         class143.field2210 = 0;
      }

      if(null != class152.field2302) {
         var1 = class152.field2302.vmethod3254();
         field491 = var1;
      }

      if(field303 == 0) {
         class153.method3285();
         class96.field1669.vmethod3260();

         for(var1 = 0; var1 < 32; ++var1) {
            class147.field2259[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            class147.field2260[var1] = 0L;
         }

         class45.field1050 = 0;
      } else if(field303 == 5) {
         class15.method201(this);
         class153.method3285();
         class96.field1669.vmethod3260();

         for(var1 = 0; var1 < 32; ++var1) {
            class147.field2259[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            class147.field2260[var1] = 0L;
         }

         class45.field1050 = 0;
      } else if(field303 != 10 && field303 != 11) {
         if(field303 == 20) {
            class15.method201(this);
            class118.method2567();
         } else if(field303 == 25) {
            class9.method126();
         }
      } else {
         class15.method201(this);
      }

      if(field303 == 30) {
         if(field312 > 1) {
            --field312;
         }

         if(field299 > 0) {
            --field299;
         }

         if(field348) {
            field348 = false;
            if(field299 > 0) {
               class129.method2964();
            } else {
               class138.method3024(40);
               class52.field1153 = class40.field904;
               class40.field904 = null;
            }
         } else {
            if(!field434) {
               field440[0] = "Cancel";
               field510[0] = "";
               field438[0] = 1006;
               field368 = 1;
            }

            for(var1 = 0; var1 < 100 && class166.method3350(); ++var1) {
               ;
            }

            if(field303 == 30) {
               while(true) {
                  class213 var15 = (class213)class214.field3189.method4011();
                  boolean var33;
                  if(null == var15) {
                     var33 = false;
                  } else {
                     var33 = true;
                  }

                  if(!var33) {
                     Object var38 = class3.field68.field203;
                     int var5;
                     int var6;
                     int var7;
                     int var8;
                     int var9;
                     int var16;
                     int var17;
                     synchronized(class3.field68.field203) {
                        if(!field293) {
                           class3.field68.field204 = 0;
                        } else if(class143.field2217 != 0 || class3.field68.field204 >= 40) {
                           field337.method2903(121);
                           field337.method2783(0);
                           var2 = field337.field2050;
                           var16 = 0;

                           for(var17 = 0; var17 < class3.field68.field204 && field337.field2050 - var2 < 240; ++var17) {
                              ++var16;
                              var5 = class3.field68.field205[var17];
                              if(var5 < 0) {
                                 var5 = 0;
                              } else if(var5 > 502) {
                                 var5 = 502;
                              }

                              var6 = class3.field68.field210[var17];
                              if(var6 < 0) {
                                 var6 = 0;
                              } else if(var6 > 764) {
                                 var6 = 764;
                              }

                              var7 = 765 * var5 + var6;
                              if(class3.field68.field205[var17] == -1 && class3.field68.field210[var17] == -1) {
                                 var6 = -1;
                                 var5 = -1;
                                 var7 = 524287;
                              }

                              if(field307 == var6 && var5 == field468) {
                                 if(field309 < 2047) {
                                    ++field309;
                                 }
                              } else {
                                 var8 = var6 - field307;
                                 field307 = var6;
                                 var9 = var5 - field468;
                                 field468 = var5;
                                 if(field309 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                    var8 += 32;
                                    var9 += 32;
                                    field337.method2619(var9 + (var8 << 6) + (field309 << 12));
                                    field309 = 0;
                                 } else if(field309 < 8) {
                                    field337.method2849(var7 + 8388608 + (field309 << 19));
                                    field309 = 0;
                                 } else {
                                    field337.method2728((field309 << 19) + -1073741824 + var7);
                                    field309 = 0;
                                 }
                              }
                           }

                           field337.method2671(field337.field2050 - var2);
                           if(var16 >= class3.field68.field204) {
                              class3.field68.field204 = 0;
                           } else {
                              class3.field68.field204 -= var16;

                              for(var17 = 0; var17 < class3.field68.field204; ++var17) {
                                 class3.field68.field210[var17] = class3.field68.field210[var16 + var17];
                                 class3.field68.field205[var17] = class3.field68.field205[var17 + var16];
                              }
                           }
                        }
                     }

                     if(class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4 || class143.field2217 == 2) {
                        long var34 = (class143.field2208 - field296) / 50L;
                        if(var34 > 4095L) {
                           var34 = 4095L;
                        }

                        field296 = class143.field2208;
                        var16 = class143.field2216;
                        if(var16 < 0) {
                           var16 = 0;
                        } else if(var16 > class39.field892) {
                           var16 = class39.field892;
                        }

                        var17 = class143.field2215;
                        if(var17 < 0) {
                           var17 = 0;
                        } else if(var17 > class189.field3056) {
                           var17 = class189.field3056;
                        }

                        var5 = (int)var34;
                        field337.method2903(209);
                        field337.method2619((var5 << 1) + (class143.field2217 == 2?1:0));
                        field337.method2619(var17);
                        field337.method2619(var16);
                     }

                     if(class140.field2178 > 0) {
                        field337.method2903(158);
                        field337.method2619(0);
                        var1 = field337.field2050;
                        long var26 = class56.method1249();

                        for(var17 = 0; var17 < class140.field2178; ++var17) {
                           long var35 = var26 - field519;
                           if(var35 > 16777215L) {
                              var35 = 16777215L;
                           }

                           field519 = var26;
                           field337.method2796((int)var35);
                           field337.method2654(class140.field2161[var17]);
                        }

                        field337.method2629(field337.field2050 - var1);
                     }

                     if(field386 > 0) {
                        --field386;
                     }

                     if(class140.field2171[96] || class140.field2171[97] || class140.field2171[98] || class140.field2171[99]) {
                        field550 = true;
                     }

                     if(field550 && field386 <= 0) {
                        field386 = 20;
                        field550 = false;
                        field337.method2903(19);
                        field337.method2667(field462);
                        field337.method2668(field399);
                     }

                     if(class54.field1172 && !field310) {
                        field310 = true;
                        field337.method2903(172);
                        field337.method2783(1);
                     }

                     if(!class54.field1172 && field310) {
                        field310 = false;
                        field337.method2903(172);
                        field337.method2783(0);
                     }

                     class132.method2975();
                     if(field303 == 30) {
                        class162.method3319();

                        for(var1 = 0; var1 < field536; ++var1) {
                           --field539[var1];
                           if(field539[var1] >= -10) {
                              class61 var40 = field541[var1];
                              if(var40 == null) {
                                 Object var10000 = null;
                                 var40 = class61.method1380(class119.field2039, field319[var1], 0);
                                 if(null == var40) {
                                    continue;
                                 }

                                 field539[var1] += var40.method1370();
                                 field541[var1] = var40;
                              }

                              if(field539[var1] < 0) {
                                 if(field528[var1] != 0) {
                                    var17 = 128 * (field528[var1] & 255);
                                    var5 = field528[var1] >> 16 & 255;
                                    var6 = 64 + var5 * 128 - class3.field65.field875;
                                    if(var6 < 0) {
                                       var6 = -var6;
                                    }

                                    var7 = field528[var1] >> 8 & 255;
                                    var8 = 64 + var7 * 128 - class3.field65.field832;
                                    if(var8 < 0) {
                                       var8 = -var8;
                                    }

                                    var9 = var6 + var8 - 128;
                                    if(var9 > var17) {
                                       field539[var1] = -100;
                                       continue;
                                    }

                                    if(var9 < 0) {
                                       var9 = 0;
                                    }

                                    var16 = field535 * (var17 - var9) / var17;
                                 } else {
                                    var16 = field403;
                                 }

                                 if(var16 > 0) {
                                    class65 var4 = var40.method1369().method1407(class79.field1463);
                                    class67 var18 = class67.method1427(var4, 100, var16);
                                    var18.method1430(field538[var1] - 1);
                                    class20.field585.method1251(var18);
                                 }

                                 field539[var1] = -100;
                              }
                           } else {
                              --field536;

                              for(var2 = var1; var2 < field536; ++var2) {
                                 field319[var2] = field319[1 + var2];
                                 field541[var2] = field541[var2 + 1];
                                 field538[var2] = field538[var2 + 1];
                                 field539[var2] = field539[var2 + 1];
                                 field528[var2] = field528[var2 + 1];
                              }

                              --var1;
                           }
                        }

                        if(field533 && !class99.method2285()) {
                           if(field294 != 0 && field457 != -1) {
                              class180.method3615(class188.field3051, field457, 0, field294, false);
                           }

                           field533 = false;
                        }

                        ++field378;
                        if(field378 > 750) {
                           class102.method2289();
                        } else {
                           var1 = class34.field783;
                           int[] var42 = class34.field784;

                           for(var16 = 0; var16 < var1; ++var16) {
                              class2 var29 = field302[var42[var16]];
                              if(var29 != null) {
                                 class112.method2534(var29, 1);
                              }
                           }

                           for(var1 = 0; var1 < field486; ++var1) {
                              var2 = field334[var1];
                              class36 var3 = field332[var2];
                              if(var3 != null) {
                                 class112.method2534(var3, var3.field803.field913);
                              }
                           }

                           int[] var39 = class34.field784;

                           for(var2 = 0; var2 < class34.field783; ++var2) {
                              class2 var25 = field302[var39[var2]];
                              if(null != var25 && var25.field847 > 0) {
                                 --var25.field847;
                                 if(var25.field847 == 0) {
                                    var25.field835 = null;
                                 }
                              }
                           }

                           for(var2 = 0; var2 < field486; ++var2) {
                              var16 = field334[var2];
                              class36 var30 = field332[var16];
                              if(var30 != null && var30.field847 > 0) {
                                 --var30.field847;
                                 if(var30.field847 == 0) {
                                    var30.field835 = null;
                                 }
                              }
                           }

                           ++field370;
                           if(field406 != 0) {
                              field537 += 20;
                              if(field537 >= 400) {
                                 field406 = 0;
                              }
                           }

                           if(null != class42.field994) {
                              ++field300;
                              if(field300 >= 15) {
                                 class79.method1777(class42.field994);
                                 class42.field994 = null;
                              }
                           }

                           class176 var41 = class11.field177;
                           class176 var43 = class19.field278;
                           class11.field177 = null;
                           class19.field278 = null;
                           field470 = null;
                           field474 = false;
                           field346 = false;
                           field318 = 0;

                           while(true) {
                              while(class151.method3275() && field318 < 128) {
                                 if(field460 >= 2 && class140.field2171[82] && class25.field643 == 66) {
                                    String var27 = class27.method645();
                                    class11.field175.setContents(new StringSelection(var27), (ClipboardOwner)null);
                                 } else {
                                    field512[field318] = class25.field643;
                                    field473[field318] = class51.field1146;
                                    ++field318;
                                 }
                              }

                              if(field495 != -1) {
                                 var16 = field495;
                                 var17 = class189.field3056;
                                 var5 = class39.field892;
                                 if(class14.method179(var16)) {
                                    class4.method51(class176.field2836[var16], -1, 0, 0, var17, var5, 0, 0);
                                 }
                              }

                              ++field478;

                              while(true) {
                                 class0 var28;
                                 class176 var31;
                                 class176 var44;
                                 do {
                                    var28 = (class0)field335.method3966();
                                    if(null == var28) {
                                       while(true) {
                                          do {
                                             var28 = (class0)field494.method3966();
                                             if(null == var28) {
                                                while(true) {
                                                   do {
                                                      var28 = (class0)field353.method3966();
                                                      if(var28 == null) {
                                                         class96.method2253();
                                                         if(field466 != null) {
                                                            class110.method2490();
                                                         }

                                                         if(null != class23.field614) {
                                                            class79.method1777(class23.field614);
                                                            ++field414;
                                                            if(class143.field2207 != 0) {
                                                               if(field414 >= 5 && (class143.field2206 > field410 + 5 || class143.field2206 < field410 - 5 || class143.field2209 > 5 + field322 || class143.field2209 < field322 - 5)) {
                                                                  field413 = true;
                                                               }
                                                            } else {
                                                               if(field413) {
                                                                  if(class23.field614 == class132.field2104 && field484 != field409) {
                                                                     class176 var32 = class23.field614;
                                                                     byte var46 = 0;
                                                                     if(field446 == 1 && var32.field2811 == 206) {
                                                                        var46 = 1;
                                                                     }

                                                                     if(var32.field2905[field484] <= 0) {
                                                                        var46 = 0;
                                                                     }

                                                                     var6 = class2.method39(var32);
                                                                     boolean var36 = (var6 >> 29 & 1) != 0;
                                                                     if(var36) {
                                                                        var7 = field409;
                                                                        var8 = field484;
                                                                        var32.field2905[var8] = var32.field2905[var7];
                                                                        var32.field2926[var8] = var32.field2926[var7];
                                                                        var32.field2905[var7] = -1;
                                                                        var32.field2926[var7] = 0;
                                                                     } else if(var46 == 1) {
                                                                        var7 = field409;
                                                                        var8 = field484;

                                                                        while(var8 != var7) {
                                                                           if(var7 > var8) {
                                                                              var32.method3558(var7 - 1, var7);
                                                                              --var7;
                                                                           } else if(var7 < var8) {
                                                                              var32.method3558(var7 + 1, var7);
                                                                              ++var7;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var32.method3558(field484, field409);
                                                                     }

                                                                     field337.method2903(105);
                                                                     field337.method2728(class23.field614.field2807);
                                                                     field337.method2668(field484);
                                                                     field337.method2668(field409);
                                                                     field337.method2658(var46);
                                                                  }
                                                               } else if((field412 == 1 || class29.method680(field368 - 1)) && field368 > 2) {
                                                                  class172.method3514(field410, field322);
                                                               } else if(field368 > 0) {
                                                                  var16 = field410;
                                                                  var17 = field322;
                                                                  class132.method2973(class75.field1423, var16, var17);
                                                                  class75.field1423 = null;
                                                               }

                                                               field300 = 10;
                                                               class143.field2217 = 0;
                                                               class23.field614 = null;
                                                            }
                                                         }

                                                         if(class89.field1556 != -1) {
                                                            var16 = class89.field1556;
                                                            var17 = class89.field1589;
                                                            field337.method2903(27);
                                                            field337.method2783(5);
                                                            field337.method2619(class21.field592 + var17);
                                                            field337.method2668(var16 + class0.field11);
                                                            field337.method2783(class140.field2171[82]?(class140.field2171[81]?2:1):0);
                                                            class89.field1556 = -1;
                                                            field480 = class143.field2215;
                                                            field404 = class143.field2216;
                                                            field406 = 1;
                                                            field537 = 0;
                                                            field371 = var16;
                                                            field529 = var17;
                                                         }

                                                         if(var41 != class11.field177) {
                                                            if(null != var41) {
                                                               class79.method1777(var41);
                                                            }

                                                            if(null != class11.field177) {
                                                               class79.method1777(class11.field177);
                                                            }
                                                         }

                                                         if(class19.field278 != var43 && field444 == field445) {
                                                            if(var43 != null) {
                                                               class79.method1777(var43);
                                                            }

                                                            if(class19.field278 != null) {
                                                               class79.method1777(class19.field278);
                                                            }
                                                         }

                                                         if(null != class19.field278) {
                                                            if(field444 < field445) {
                                                               ++field444;
                                                               if(field445 == field444) {
                                                                  class79.method1777(class19.field278);
                                                               }
                                                            }
                                                         } else if(field444 > 0) {
                                                            --field444;
                                                         }

                                                         var16 = field576 + class3.field65.field875;
                                                         var17 = class3.field65.field832 + field360;
                                                         if(class37.field817 - var16 < -500 || class37.field817 - var16 > 500 || class167.field2710 - var17 < -500 || class167.field2710 - var17 > 500) {
                                                            class37.field817 = var16;
                                                            class167.field2710 = var17;
                                                         }

                                                         if(var16 != class37.field817) {
                                                            class37.field817 += (var16 - class37.field817) / 16;
                                                         }

                                                         if(var17 != class167.field2710) {
                                                            class167.field2710 += (var17 - class167.field2710) / 16;
                                                         }

                                                         if(class143.field2207 == 4 && class214.field3188) {
                                                            var5 = class143.field2209 - field553;
                                                            field382 = var5 * 2;
                                                            field553 = var5 != -1 && var5 != 1?(field553 + class143.field2209) / 2:class143.field2209;
                                                            var6 = field383 - class143.field2206;
                                                            field381 = var6 * 2;
                                                            field383 = var6 != -1 && var6 != 1?(class143.field2206 + field383) / 2:class143.field2206;
                                                         } else {
                                                            if(class140.field2171[96]) {
                                                               field381 += (-24 - field381) / 2;
                                                            } else if(class140.field2171[97]) {
                                                               field381 += (24 - field381) / 2;
                                                            } else {
                                                               field381 /= 2;
                                                            }

                                                            if(class140.field2171[98]) {
                                                               field382 += (12 - field382) / 2;
                                                            } else if(class140.field2171[99]) {
                                                               field382 += (-12 - field382) / 2;
                                                            } else {
                                                               field382 /= 2;
                                                            }

                                                            field553 = class143.field2209;
                                                            field383 = class143.field2206;
                                                         }

                                                         field399 = field399 + field381 / 2 & 2047;
                                                         field462 += field382 / 2;
                                                         if(field462 < 128) {
                                                            field462 = 128;
                                                         }

                                                         if(field462 > 383) {
                                                            field462 = 383;
                                                         }

                                                         var5 = class37.field817 >> 7;
                                                         var6 = class167.field2710 >> 7;
                                                         var7 = class127.method2936(class37.field817, class167.field2710, class99.field1701);
                                                         var8 = 0;
                                                         int var11;
                                                         int var12;
                                                         int var19;
                                                         if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                            for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                               for(var19 = var6 - 4; var19 <= var6 + 4; ++var19) {
                                                                  var11 = class99.field1701;
                                                                  if(var11 < 3 && (class5.field80[1][var9][var19] & 2) == 2) {
                                                                     ++var11;
                                                                  }

                                                                  var12 = var7 - class5.field85[var11][var9][var19];
                                                                  if(var12 > var8) {
                                                                     var8 = var12;
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         var9 = var8 * 192;
                                                         if(var9 > 98048) {
                                                            var9 = 98048;
                                                         }

                                                         if(var9 < '耀') {
                                                            var9 = '耀';
                                                         }

                                                         if(var9 > field540) {
                                                            field540 += (var9 - field540) / 24;
                                                         } else if(var9 < field540) {
                                                            field540 += (var9 - field540) / 80;
                                                         }

                                                         if(field542) {
                                                            var16 = 64 + class3.field63 * 128;
                                                            var17 = class102.field1756 * 128 + 64;
                                                            var5 = class127.method2936(var16, var17, class99.field1701) - class77.field1443;
                                                            if(class151.field2282 < var16) {
                                                               class151.field2282 += class152.field2303 * (var16 - class151.field2282) / 1000 + class165.field2706;
                                                               if(class151.field2282 > var16) {
                                                                  class151.field2282 = var16;
                                                               }
                                                            }

                                                            if(class151.field2282 > var16) {
                                                               class151.field2282 -= (class151.field2282 - var16) * class152.field2303 / 1000 + class165.field2706;
                                                               if(class151.field2282 < var16) {
                                                                  class151.field2282 = var16;
                                                               }
                                                            }

                                                            if(class8.field149 < var5) {
                                                               class8.field149 += class165.field2706 + class152.field2303 * (var5 - class8.field149) / 1000;
                                                               if(class8.field149 > var5) {
                                                                  class8.field149 = var5;
                                                               }
                                                            }

                                                            if(class8.field149 > var5) {
                                                               class8.field149 -= (class8.field149 - var5) * class152.field2303 / 1000 + class165.field2706;
                                                               if(class8.field149 < var5) {
                                                                  class8.field149 = var5;
                                                               }
                                                            }

                                                            if(class96.field1670 < var17) {
                                                               class96.field1670 += (var17 - class96.field1670) * class152.field2303 / 1000 + class165.field2706;
                                                               if(class96.field1670 > var17) {
                                                                  class96.field1670 = var17;
                                                               }
                                                            }

                                                            if(class96.field1670 > var17) {
                                                               class96.field1670 -= class152.field2303 * (class96.field1670 - var17) / 1000 + class165.field2706;
                                                               if(class96.field1670 < var17) {
                                                                  class96.field1670 = var17;
                                                               }
                                                            }

                                                            var16 = class33.field751 * 128 + 64;
                                                            var17 = 64 + class85.field1514 * 128;
                                                            var5 = class127.method2936(var16, var17, class99.field1701) - class133.field2106;
                                                            var6 = var16 - class151.field2282;
                                                            var7 = var5 - class8.field149;
                                                            var8 = var17 - class96.field1670;
                                                            var9 = (int)Math.sqrt((double)(var6 * var6 + var8 * var8));
                                                            var19 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                            var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                            if(var19 < 128) {
                                                               var19 = 128;
                                                            }

                                                            if(var19 > 383) {
                                                               var19 = 383;
                                                            }

                                                            if(class102.field1759 < var19) {
                                                               class102.field1759 += (var19 - class102.field1759) * class19.field275 / 1000 + class97.field1687;
                                                               if(class102.field1759 > var19) {
                                                                  class102.field1759 = var19;
                                                               }
                                                            }

                                                            if(class102.field1759 > var19) {
                                                               class102.field1759 -= class19.field275 * (class102.field1759 - var19) / 1000 + class97.field1687;
                                                               if(class102.field1759 < var19) {
                                                                  class102.field1759 = var19;
                                                               }
                                                            }

                                                            var12 = var11 - class59.field1255;
                                                            if(var12 > 1024) {
                                                               var12 -= 2048;
                                                            }

                                                            if(var12 < -1024) {
                                                               var12 += 2048;
                                                            }

                                                            if(var12 > 0) {
                                                               class59.field1255 += class97.field1687 + var12 * class19.field275 / 1000;
                                                               class59.field1255 &= 2047;
                                                            }

                                                            if(var12 < 0) {
                                                               class59.field1255 -= class97.field1687 + class19.field275 * -var12 / 1000;
                                                               class59.field1255 &= 2047;
                                                            }

                                                            int var13 = var11 - class59.field1255;
                                                            if(var13 > 1024) {
                                                               var13 -= 2048;
                                                            }

                                                            if(var13 < -1024) {
                                                               var13 += 2048;
                                                            }

                                                            if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                               class59.field1255 = var11;
                                                            }
                                                         }

                                                         for(var16 = 0; var16 < 5; ++var16) {
                                                            ++field547[var16];
                                                         }

                                                         class39.field869.method227();
                                                         var16 = class47.method1011();
                                                         var17 = class2.method41();
                                                         if(var16 > 15000 && var17 > 15000) {
                                                            field299 = 250;
                                                            class143.field2203 = 14500;
                                                            field337.method2903(59);
                                                         }

                                                         ++field364;
                                                         if(field364 > 500) {
                                                            field364 = 0;
                                                            var5 = (int)(Math.random() * 8.0D);
                                                            if((var5 & 1) == 1) {
                                                               field576 += field405;
                                                            }

                                                            if((var5 & 2) == 2) {
                                                               field360 += field361;
                                                            }

                                                            if((var5 & 4) == 4) {
                                                               field362 += field467;
                                                            }
                                                         }

                                                         if(field576 < -50) {
                                                            field405 = 2;
                                                         }

                                                         if(field576 > 50) {
                                                            field405 = -2;
                                                         }

                                                         if(field360 < -55) {
                                                            field361 = 2;
                                                         }

                                                         if(field360 > 55) {
                                                            field361 = -2;
                                                         }

                                                         if(field362 < -40) {
                                                            field467 = 1;
                                                         }

                                                         if(field362 > 40) {
                                                            field467 = -1;
                                                         }

                                                         ++field369;
                                                         if(field369 > 500) {
                                                            field369 = 0;
                                                            var5 = (int)(Math.random() * 8.0D);
                                                            if((var5 & 1) == 1) {
                                                               field365 += field441;
                                                            }

                                                            if((var5 & 2) == 2) {
                                                               field367 += field531;
                                                            }
                                                         }

                                                         if(field365 < -60) {
                                                            field441 = 2;
                                                         }

                                                         if(field365 > 60) {
                                                            field441 = -2;
                                                         }

                                                         if(field367 < -20) {
                                                            field531 = 1;
                                                         }

                                                         if(field367 > 10) {
                                                            field531 = -1;
                                                         }

                                                         for(class40 var45 = (class40)field351.method3928(); null != var45; var45 = (class40)field351.method3933()) {
                                                            if((long)var45.field894 < class56.method1249() / 1000L - 5L) {
                                                               if(var45.field896 > 0) {
                                                                  class78.method1721(5, "", var45.field895 + " has logged in.");
                                                               }

                                                               if(var45.field896 == 0) {
                                                                  class78.method1721(5, "", var45.field895 + " has logged out.");
                                                               }

                                                               var45.method4063();
                                                            }
                                                         }

                                                         ++field343;
                                                         if(field343 > 50) {
                                                            field337.method2903(177);
                                                         }

                                                         try {
                                                            if(null != class40.field904 && field337.field2050 > 0) {
                                                               class40.field904.method3135(field337.field2051, 0, field337.field2050);
                                                               field337.field2050 = 0;
                                                               field343 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var20) {
                                                            class102.method2289();
                                                         }

                                                         return;
                                                      }

                                                      var31 = var28.field2;
                                                      if(var31.field2813 < 0) {
                                                         break;
                                                      }

                                                      var44 = class134.method2983(var31.field2826);
                                                   } while(null == var44 || var44.field2931 == null || var31.field2813 >= var44.field2931.length || var44.field2931[var31.field2813] != var31);

                                                   class16.method203(var28);
                                                }
                                             }

                                             var31 = var28.field2;
                                             if(var31.field2813 < 0) {
                                                break;
                                             }

                                             var44 = class134.method2983(var31.field2826);
                                          } while(null == var44 || var44.field2931 == null || var31.field2813 >= var44.field2931.length || var31 != var44.field2931[var31.field2813]);

                                          class16.method203(var28);
                                       }
                                    }

                                    var31 = var28.field2;
                                    if(var31.field2813 < 0) {
                                       break;
                                    }

                                    var44 = class134.method2983(var31.field2826);
                                 } while(var44 == null || var44.field2931 == null || var31.field2813 >= var44.field2931.length || var44.field2931[var31.field2813] != var31);

                                 class16.method203(var28);
                              }
                           }
                        }
                     }
                     break;
                  }

                  field337.method2903(117);
                  field337.method2783(0);
                  var2 = field337.field2050;
                  class167.method3370(field337);
                  field337.method2671(field337.field2050 - var2);
               }
            }
         }
      } else if(field303 == 40 || field303 == 45) {
         class118.method2567();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1210517442"
   )
   void method262() {
      if(field303 != 1000) {
         boolean var1 = class154.method3288();
         if(!var1) {
            this.method263();
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-75"
   )
   void method263() {
      if(class174.field2785 >= 4) {
         this.method3170("js5crc");
         field303 = 1000;
      } else {
         if(class174.field2787 >= 4) {
            if(field303 <= 5) {
               this.method3170("js5io");
               field303 = 1000;
               return;
            }

            field325 = 3000;
            class174.field2787 = 3;
         }

         if(--field325 + 1 <= 0) {
            try {
               if(field324 == 0) {
                  class141.field2187 = class125.field2070.method3028(class105.field1842, class109.field1943);
                  ++field324;
               }

               if(field324 == 1) {
                  if(class141.field2187.field2276 == 2) {
                     this.method264(-1);
                     return;
                  }

                  if(class141.field2187.field2276 == 1) {
                     ++field324;
                  }
               }

               if(field324 == 2) {
                  class22.field601 = new class146((Socket)class141.field2187.field2272, class125.field2070);
                  class122 var1 = new class122(5);
                  var1.method2783(15);
                  var1.method2728(120);
                  class22.field601.method3135(var1.field2051, 0, 5);
                  ++field324;
                  field469 = class56.method1249();
               }

               if(field324 == 3) {
                  if(field303 > 5 && class22.field601.method3141() <= 0) {
                     if(class56.method1249() - field469 > 30000L) {
                        this.method264(-2);
                        return;
                     }
                  } else {
                     int var2 = class22.field601.method3140();
                     if(var2 != 0) {
                        this.method264(var2);
                        return;
                     }

                     ++field324;
                  }
               }

               if(field324 == 4) {
                  class78.method1722(class22.field601, field303 > 20);
                  class141.field2187 = null;
                  class22.field601 = null;
                  field324 = 0;
                  field327 = 0;
               }
            } catch (IOException var3) {
               this.method264(-3);
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "98"
   )
   void method264(int var1) {
      class141.field2187 = null;
      class22.field601 = null;
      field324 = 0;
      if(class12.field198 == class109.field1943) {
         class109.field1943 = class56.field1235;
      } else {
         class109.field1943 = class12.field198;
      }

      ++field327;
      if(field327 < 2 || var1 != 7 && var1 != 9) {
         if(field327 >= 2 && var1 == 6) {
            this.method3170("js5connect_outofdate");
            field303 = 1000;
         } else if(field327 >= 4) {
            if(field303 <= 5) {
               this.method3170("js5connect");
               field303 = 1000;
            } else {
               field325 = 3000;
            }
         }
      } else if(field303 <= 5) {
         this.method3170("js5connect_full");
         field303 = 1000;
      } else {
         field325 = 3000;
      }

   }

   static {
      field292 = class21.field589;
      field420 = class21.field589;
      field323 = 0;
      field324 = 0;
      field325 = 0;
      field327 = 0;
      field349 = 0;
      field411 = 0;
      field308 = 0;
      field450 = 0;
      field332 = new class36['耀'];
      field486 = 0;
      field334 = new int['耀'];
      field454 = 0;
      field336 = new int[250];
      field337 = new class125(5000);
      field333 = new class125(5000);
      field339 = new class125(15000);
      field340 = 0;
      field341 = 0;
      field378 = 0;
      field343 = 0;
      field344 = 0;
      field345 = 0;
      field311 = 0;
      field299 = 0;
      field348 = false;
      field342 = 0;
      field350 = 1;
      field493 = 0;
      field534 = 1;
      field527 = 0;
      field354 = new class111[4];
      field355 = false;
      field356 = new int[4][13][13];
      field532 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field576 = 0;
      field405 = 2;
      field360 = 0;
      field361 = 2;
      field362 = 0;
      field467 = 1;
      field364 = 0;
      field365 = 0;
      field441 = 2;
      field367 = 0;
      field531 = 1;
      field369 = 0;
      field370 = 0;
      field373 = 2301979;
      field374 = 5063219;
      field329 = 3353893;
      field554 = 7759444;
      field377 = false;
      field513 = 0;
      field462 = 128;
      field399 = 0;
      field381 = 0;
      field382 = 0;
      field383 = 0;
      field553 = 0;
      field338 = 50;
      field386 = 0;
      field550 = false;
      field540 = 0;
      field389 = 0;
      field408 = 50;
      field380 = new int[field408];
      field330 = new int[field408];
      field505 = new int[field408];
      field394 = new int[field408];
      field395 = new int[field408];
      field396 = new int[field408];
      field516 = new int[field408];
      field398 = new String[field408];
      field560 = new int[104][104];
      field400 = 0;
      field401 = -1;
      field402 = -1;
      field480 = 0;
      field404 = 0;
      field537 = 0;
      field406 = 0;
      field300 = 0;
      field509 = 0;
      field409 = 0;
      field410 = 0;
      field322 = 0;
      field484 = 0;
      field413 = false;
      field414 = 0;
      field564 = 0;
      field302 = new class2[2048];
      field417 = -1;
      field418 = 0;
      field419 = 0;
      field388 = new int[1000];
      field421 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field422 = new String[8];
      field423 = new boolean[8];
      field358 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field425 = -1;
      field426 = new class202[4][104][104];
      field427 = new class202();
      field428 = new class202();
      field429 = new class202();
      field430 = new int[25];
      field431 = new int[25];
      field432 = new int[25];
      field412 = 0;
      field434 = false;
      field368 = 0;
      field436 = new int[500];
      field437 = new int[500];
      field438 = new int[500];
      field291 = new int[500];
      field440 = new String[500];
      field510 = new String[500];
      field442 = -1;
      field443 = -1;
      field444 = 0;
      field445 = 50;
      field439 = 0;
      field447 = null;
      field448 = false;
      field449 = -1;
      field459 = -1;
      field306 = null;
      field452 = null;
      field495 = -1;
      field475 = new class199(8);
      field455 = 0;
      field446 = 0;
      field376 = null;
      field458 = 0;
      field545 = 0;
      field460 = 0;
      field555 = -1;
      field506 = false;
      field471 = false;
      field464 = false;
      field465 = null;
      field466 = null;
      field397 = null;
      field387 = 0;
      field472 = 0;
      field470 = null;
      field346 = false;
      field543 = -1;
      field295 = -1;
      field474 = false;
      field347 = -1;
      field476 = -1;
      field390 = false;
      field478 = 1;
      field479 = new int[32];
      field366 = 0;
      field481 = new int[32];
      field482 = 0;
      field483 = new int[32];
      field328 = 0;
      field485 = 0;
      field385 = 0;
      field487 = 0;
      field488 = 0;
      field416 = 0;
      field490 = 0;
      field491 = 0;
      field353 = new class202();
      field335 = new class202();
      field494 = new class202();
      field435 = new class199(512);
      field496 = 0;
      field497 = -2;
      field498 = new boolean[100];
      field499 = new boolean[100];
      field500 = new boolean[100];
      field501 = new int[100];
      field502 = new int[100];
      field503 = new int[100];
      field504 = new int[100];
      field357 = 0;
      field352 = 0L;
      field507 = true;
      field508 = 765;
      field321 = 1;
      field424 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field511 = 0;
      field379 = 0;
      field415 = "";
      field514 = new long[100];
      field515 = 0;
      field318 = 0;
      field473 = new int[128];
      field512 = new int[128];
      field519 = -1L;
      field363 = null;
      field521 = null;
      field523 = -1;
      field524 = 0;
      field525 = new int[1000];
      field526 = new int[1000];
      field453 = new class81[1000];
      field371 = 0;
      field529 = 0;
      field530 = 0;
      field294 = 255;
      field457 = -1;
      field533 = false;
      field403 = 127;
      field535 = 127;
      field536 = 0;
      field319 = new int[50];
      field538 = new int[50];
      field539 = new int[50];
      field528 = new int[50];
      field541 = new class61[50];
      field542 = false;
      field331 = new boolean[5];
      field544 = new int[5];
      field393 = new int[5];
      field546 = new int[5];
      field547 = new int[5];
      field548 = 256;
      field549 = 205;
      field359 = 256;
      field551 = 320;
      field552 = 1;
      field492 = 32767;
      field320 = 1;
      field563 = 32767;
      field556 = 0;
      field557 = 0;
      field558 = 0;
      field559 = 0;
      field392 = 0;
      field391 = 0;
      field562 = 0;
      field456 = new class17[400];
      field351 = new class198();
      field565 = 0;
      field566 = new class7[400];
      field567 = new class182();
      field568 = -1;
      field569 = -1;
      field570 = new class223[8];
      field571 = -1L;
      field572 = -1L;
      field573 = new class10();
      field574 = new int[50];
      field575 = new int[50];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1575533843"
   )
   protected final void vmethod3234() {
      if(class39.field869.method228()) {
         class39.field869.method225();
      }

      if(null != class3.field68) {
         class3.field68.field206 = false;
      }

      class3.field68 = null;
      if(class40.field904 != null) {
         class40.field904.method3131();
         class40.field904 = null;
      }

      if(class140.field2157 != null) {
         class140 var1 = class140.field2157;
         synchronized(class140.field2157) {
            class140.field2157 = null;
         }
      }

      class43.method896();
      class152.field2302 = null;
      if(class6.field127 != null) {
         class6.field127.method1322();
      }

      if(null != class125.field2069) {
         class125.field2069.method1322();
      }

      class109.method2483();
      Object var7 = class173.field2763;
      synchronized(class173.field2763) {
         if(class173.field2767 != 0) {
            class173.field2767 = 1;

            try {
               class173.field2763.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      class128.method2939();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   protected final void vmethod3225() {
      boolean var1;
      label229: {
         try {
            if(class186.field3010 == 2) {
               if(null == class186.field3011) {
                  class186.field3011 = class183.method3669(class111.field1970, class140.field2184, class186.field3009);
                  if(class186.field3011 == null) {
                     var1 = false;
                     break label229;
                  }
               }

               if(class43.field1010 == null) {
                  class43.field1010 = new class62(class159.field2369, class186.field3012);
               }

               if(class59.field1266.method3751(class186.field3011, class145.field2235, class43.field1010, 22050)) {
                  class59.field1266.method3839();
                  class59.field1266.method3750(class11.field176);
                  class59.field1266.method3755(class186.field3011, class37.field814);
                  class186.field3010 = 0;
                  class186.field3011 = null;
                  class43.field1010 = null;
                  class111.field1970 = null;
                  var1 = true;
                  break label229;
               }
            }
         } catch (Exception var14) {
            var14.printStackTrace();
            class59.field1266.method3754();
            class186.field3010 = 0;
            class186.field3011 = null;
            class43.field1010 = null;
            class111.field1970 = null;
         }

         var1 = false;
      }

      if(var1 && field533 && class6.field127 != null) {
         class6.field127.method1296();
      }

      int var5;
      int var6;
      if(field303 == 10 || field303 == 20 || field303 == 30) {
         if(0L != field352 && class56.method1249() > field352) {
            int var3 = class53.method1139();
            field352 = 0L;
            if(var3 >= 2) {
               field507 = true;
            } else {
               field507 = false;
            }

            class10.method143();
            if(field303 >= 25) {
               class6.method103();
            }

            class147.field2263 = true;
         } else if(class147.field2266) {
            class21.method582(class107.field1867);
            Canvas var9 = class107.field1867;
            var9.removeMouseListener(class143.field2202);
            var9.removeMouseMotionListener(class143.field2202);
            var9.removeFocusListener(class143.field2202);
            class143.field2204 = 0;
            if(class152.field2302 != null) {
               class152.field2302.vmethod3252(class107.field1867);
            }

            field477.method3156();
            class107.field1867.setBackground(Color.black);
            Canvas var4 = class107.field1867;
            var4.setFocusTraversalKeysEnabled(false);
            var4.addKeyListener(class140.field2157);
            var4.addFocusListener(class140.field2157);
            class114.method2542(class107.field1867);
            if(class152.field2302 != null) {
               class152.field2302.vmethod3251(class107.field1867);
            }

            if(field495 != -1) {
               var5 = field495;
               var6 = class189.field3056;
               int var7 = class39.field892;
               if(class14.method179(var5)) {
                  class0.method2(class176.field2836[var5], -1, var6, var7, false);
               }
            }

            class147.field2265 = true;
         }
      }

      Dimension var15 = this.method3172();
      if(class78.field1450 != var15.width || var15.height != class144.field2220 || class147.field2265) {
         class10.method143();
         field352 = class56.method1249() + 500L;
         class147.field2265 = false;
      }

      boolean var10 = false;
      if(class147.field2263) {
         class147.field2263 = false;
         var10 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field498[var5] = true;
         }
      }

      if(var10) {
         class142.method3088();
      }

      if(field303 == 0) {
         class116.method2556(class33.field757, class33.field758, (Color)null, var10);
      } else if(field303 == 5) {
         class143.method3118(class59.field1268, class7.field133, class8.field144, var10);
      } else if(field303 != 10 && field303 != 11) {
         if(field303 == 20) {
            class143.method3118(class59.field1268, class7.field133, class8.field144, var10);
         } else if(field303 == 25) {
            if(field527 == 1) {
               if(field342 > field350) {
                  field350 = field342;
               }

               var5 = (field350 * 50 - field342 * 50) / field350;
               class9.method131("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field527 == 2) {
               if(field493 > field534) {
                  field534 = field493;
               }

               var5 = 50 + (field534 * 50 - field493 * 50) / field534;
               class9.method131("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class9.method131("Loading - please wait.", false);
            }
         } else if(field303 == 30) {
            class31.method694();
         } else if(field303 == 40) {
            class9.method131("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field303 == 45) {
            class9.method131("Please wait...", false);
         }
      } else {
         class143.method3118(class59.field1268, class7.field133, class8.field144, var10);
      }

      Graphics var11;
      if(field303 == 30 && field357 == 0 && !var10) {
         try {
            var11 = class107.field1867.getGraphics();

            for(var6 = 0; var6 < field496; ++var6) {
               if(field499[var6]) {
                  class54.field1173.vmethod1963(var11, field501[var6], field502[var6], field503[var6], field504[var6]);
                  field499[var6] = false;
               }
            }
         } catch (Exception var13) {
            class107.field1867.repaint();
         }
      } else if(field303 > 0) {
         try {
            var11 = class107.field1867.getGraphics();
            class54.field1173.vmethod1965(var11, 0, 0);

            for(var6 = 0; var6 < field496; ++var6) {
               field499[var6] = false;
            }
         } catch (Exception var12) {
            class107.field1867.repaint();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "265552880"
   )
   protected final void vmethod3173() {
   }
}
