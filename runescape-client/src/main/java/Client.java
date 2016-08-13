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
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("ij")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
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
   static Player[] cachedPlayers;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -128579603
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("i")
   static boolean field304 = true;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -651791851
   )
   @Export("gameCycle")
   static int gameCycle = 0;
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
   static NPC[] cachedNPCs;
   @ObfuscatedName("cz")
   static class125 field333;
   @ObfuscatedName("cl")
   static int[] field334;
   @ObfuscatedName("kt")
   static Deque field335;
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
   static int packetOpcode;
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
   static Deque field353;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
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
   static int mapScale;
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
   static int mapScaleDelta;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -403216701
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
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
   static int flagX;
   @ObfuscatedName("ef")
   static ModIcon[] field372;
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
   static Widget field376;
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
   static int friendCount;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 202303965
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("oe")
   static int[] field393;
   @ObfuscatedName("fo")
   static int[] field394;
   @ObfuscatedName("fu")
   static int[] field395;
   @ObfuscatedName("fe")
   static int[] field396;
   @ObfuscatedName("ja")
   static Widget field397;
   @ObfuscatedName("ga")
   static String[] field398;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -791997341
   )
   @Export("mapAngle")
   static int mapAngle;
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
   static int world = 1;
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
   static int localInteractingIndex;
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
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("hk")
   static Deque field427;
   @ObfuscatedName("hz")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hs")
   static Deque field429;
   @ObfuscatedName("ho")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("hp")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("hj")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("ac")
   static boolean field433 = false;
   @ObfuscatedName("hf")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("ky")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("hn")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("hh")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("iq")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -640807227
   )
   static int field439;
   @ObfuscatedName("ih")
   @Export("menuOptions")
   static String[] menuOptions;
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
   static SpritePixels[] field453;
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
   static Friend[] friends;
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
   static int energy;
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
   static SpritePixels[] field463;
   @ObfuscatedName("jn")
   static boolean field464;
   @ObfuscatedName("ji")
   static Widget field465;
   @ObfuscatedName("ju")
   static Widget field466;
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
   static Widget field470;
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
   static XHashTable componentTable;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 91755149
   )
   static int field476;
   @ObfuscatedName("g")
   static Client field477;
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
   static Deque field494;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -990967083
   )
   @Export("widgetRoot")
   static int widgetRoot;
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
   static int[] widgetPositionX;
   @ObfuscatedName("lq")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("ln")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("lc")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("fm")
   static int[] field505;
   @ObfuscatedName("jh")
   static boolean field506;
   @ObfuscatedName("lk")
   @Export("isResized")
   static boolean isResized;
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
   static String[] menuTargets;
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
   static boolean isMembers = false;
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
   static int flagY;
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
   static int weight;
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
   static int camera2;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 2023179217
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("gk")
   static int[][] field560;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -420859049
   )
   @Export("flags")
   static int flags = 0;
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
   static int ignoreCount;
   @ObfuscatedName("oz")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("ou")
   static PlayerComposition field567;
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
   static XGrandExchangeOffer[] grandExchangeOffers;
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
         String var4;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class193 var5 = var2[var3];
            var4 = this.getParameter(var5.field3123);
            if(null != var4) {
               switch(Integer.parseInt(var5.field3123)) {
               case 2:
                  class165.field2705 = Integer.parseInt(var4);
                  break;
               case 3:
                  field298 = (class157)class85.method1971(class8.method122(), Integer.parseInt(var4));
                  if(field298 == class157.field2345) {
                     field518 = class215.field3190;
                  } else {
                     field518 = class215.field3198;
                  }
                  break;
               case 4:
                  class133.field2112 = Integer.parseInt(var4);
                  break;
               case 5:
                  XItemContainer.field223 = var4;
                  break;
               case 6:
                  field326 = Integer.parseInt(var4);
               case 7:
               case 12:
               default:
                  break;
               case 8:
                  flags = Integer.parseInt(var4);
                  break;
               case 9:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 10:
                  world = Integer.parseInt(var4);
                  break;
               case 11:
                  field297 = Integer.parseInt(var4);
                  break;
               case 13:
                  class48.field1097 = var4;
                  break;
               case 14:
                  field461 = class119.method2574(Integer.parseInt(var4));
                  break;
               case 15:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
               }
            }
         }

         NPC.method776();
         FrameMap.host = this.getCodeBase().getHost();
         String var26 = field461.field2336;
         byte var6 = 0;

         try {
            class152.field2298 = 16;
            XItemContainer.field227 = var6;

            try {
               class24.field620 = System.getProperty("os.name");
            } catch (Exception var22) {
               class24.field620 = "Unknown";
            }

            GameObject.field1746 = class24.field620.toLowerCase();

            try {
               WidgetNode.field67 = System.getProperty("user.home");
               if(null != WidgetNode.field67) {
                  WidgetNode.field67 = WidgetNode.field67 + "/";
               }
            } catch (Exception var21) {
               ;
            }

            try {
               if(GameObject.field1746.startsWith("win")) {
                  if(null == WidgetNode.field67) {
                     WidgetNode.field67 = System.getenv("USERPROFILE");
                  }
               } else if(WidgetNode.field67 == null) {
                  WidgetNode.field67 = System.getenv("HOME");
               }

               if(null != WidgetNode.field67) {
                  WidgetNode.field67 = WidgetNode.field67 + "/";
               }
            } catch (Exception var20) {
               ;
            }

            if(WidgetNode.field67 == null) {
               WidgetNode.field67 = "~/";
            }

            class152.field2292 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", WidgetNode.field67, "/tmp/", ""};
            class130.field2100 = new String[]{".jagex_cache_" + XItemContainer.field227, ".file_store_" + XItemContainer.field227};
            var3 = 0;

            label254:
            while(var3 < 4) {
               var4 = var3 == 0?"":"" + var3;
               class175.field2791 = new File(WidgetNode.field67, "jagex_cl_oldschool_" + var26 + var4 + ".dat");
               String var7 = null;
               String var8 = null;
               boolean var9 = false;
               Buffer var10;
               File var11;
               int var13;
               if(class175.field2791.exists()) {
                  try {
                     FileOnDisk var12 = new FileOnDisk(class175.field2791, "rw", 10000L);

                     for(var10 = new Buffer((int)var12.method4273()); var10.offset < var10.payload.length; var10.offset += var13) {
                        var13 = var12.method4274(var10.payload, var10.offset, var10.payload.length - var10.offset);
                        if(var13 == -1) {
                           throw new IOException();
                        }
                     }

                     var10.offset = 0;
                     var13 = var10.method2633();
                     if(var13 < 1 || var13 > 3) {
                        throw new IOException("" + var13);
                     }

                     int var14 = 0;
                     if(var13 > 1) {
                        var14 = var10.method2633();
                     }

                     if(var13 <= 2) {
                        var7 = var10.method2642();
                        if(var14 == 1) {
                           var8 = var10.method2642();
                        }
                     } else {
                        var7 = var10.method2643();
                        if(var14 == 1) {
                           var8 = var10.method2643();
                        }
                     }

                     var12.method4283();
                  } catch (IOException var24) {
                     var24.printStackTrace();
                  }

                  if(null != var7) {
                     var11 = new File(var7);
                     if(!var11.exists()) {
                        var7 = null;
                     }
                  }

                  if(null != var7) {
                     var11 = new File(var7, "test.dat");
                     if(!class59.method1295(var11, true)) {
                        var7 = null;
                     }
                  }
               }

               if(null == var7 && var3 == 0) {
                  label228:
                  for(int var27 = 0; var27 < class130.field2100.length; ++var27) {
                     for(var13 = 0; var13 < class152.field2292.length; ++var13) {
                        File var32 = new File(class152.field2292[var13] + class130.field2100[var27] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var32.exists() && class59.method1295(new File(var32, "test.dat"), true)) {
                           var7 = var32.toString();
                           var9 = true;
                           break label228;
                        }
                     }
                  }
               }

               if(null == var7) {
                  var7 = WidgetNode.field67 + File.separatorChar + "jagexcache" + var4 + File.separatorChar + "oldschool" + File.separatorChar + var26 + File.separatorChar;
                  var9 = true;
               }

               File var17;
               File var28;
               File[] var33;
               if(null != var8) {
                  var28 = new File(var8);
                  var11 = new File(var7);

                  try {
                     File[] var29 = var28.listFiles();
                     var33 = var29;

                     for(int var15 = 0; var15 < var33.length; ++var15) {
                        File var16 = var33[var15];
                        var17 = new File(var11, var16.getName());
                        boolean var18 = var16.renameTo(var17);
                        if(!var18) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var23) {
                     var23.printStackTrace();
                  }

                  var9 = true;
               }

               File[] var34;
               if(var9) {
                  var28 = new File(var7);
                  var10 = null;

                  try {
                     FileOnDisk var30 = new FileOnDisk(class175.field2791, "rw", 10000L);
                     Buffer var35 = new Buffer(500);
                     var35.method2783(3);
                     var34 = null;
                     var35.method2783(0);
                     var35.method2626(var28.getPath());
                     var30.method4275(var35.payload, 0, var35.offset);
                     var30.method4283();
                  } catch (IOException var19) {
                     var19.printStackTrace();
                  }
               }

               File var31 = new File(var7);
               class152.field2300 = var31;
               if(!class152.field2300.exists()) {
                  class152.field2300.mkdirs();
               }

               var33 = class152.field2300.listFiles();
               if(var33 != null) {
                  var34 = var33;

                  for(int var36 = 0; var36 < var34.length; ++var36) {
                     var17 = var34[var36];
                     if(!class59.method1295(var17, false)) {
                        ++var3;
                        continue label254;
                     }
                  }
               }
               break;
            }

            Friend.method210(class152.field2300);
            FrameMap.method2383();
            class152.field2296 = new class231(new FileOnDisk(class180.method3614("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class152.field2297 = new class231(new FileOnDisk(class180.method3614("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class8.field152 = new class231[class152.field2298];

            for(var3 = 0; var3 < class152.field2298; ++var3) {
               class8.field152[var3] = new class231(new FileOnDisk(class180.method3614("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var25) {
            class13.method176((String)null, var25);
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
      class12.field198 = field297 == 0?'ꩊ':world + '鱀';
      class56.field1235 = field297 == 0?443:world + '썐';
      class109.field1943 = class12.field198;
      PlayerComposition.field2969 = class177.field2943;
      class175.field2794 = class177.field2942;
      PlayerComposition.field2976 = class177.field2944;
      FrameMap.field1840 = class177.field2945;
      class139.method3032();
      Canvas var1 = class107.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class140.keyboard);
      var1.addFocusListener(class140.keyboard);
      class114.method2542(class107.canvas);
      class152.field2302 = class93.method2162();
      if(class152.field2302 != null) {
         class152.field2302.vmethod3251(class107.canvas);
      }

      class159.field2367 = new class137(255, class152.field2296, class152.field2297, 500000);
      class136.field2123 = class4.method45();
      class11.field175 = this.getToolkit().getSystemClipboard();
      String var2 = class118.field2030;
      class141.field2195 = this;
      class141.field2193 = var2;
      if(field297 != 0) {
         field433 = true;
      }

      int var3 = class136.field2123.field146;
      field352 = 0L;
      if(var3 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      class10.method143();
      if(gameState >= 25) {
         Projectile.method103();
      }

      GameEngine.field2263 = true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1031914960"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
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
               if(CollisionData.field1970 != null) {
                  class186.field3010 = 2;
               } else {
                  class186.field3010 = 0;
               }

               class186.field3011 = null;
               class43.field1010 = null;
            }
         }
      } catch (Exception var30) {
         var30.printStackTrace();
         class59.field1266.method3754();
         class186.field3010 = 0;
         class186.field3011 = null;
         class43.field1010 = null;
         CollisionData.field1970 = null;
      }

      class47.method1009();
      class140 var2 = class140.keyboard;
      class140 var4 = class140.keyboard;
      int var3;
      synchronized(class140.keyboard) {
         ++class140.keyboardIdleTicks;
         class140.field2179 = class140.field2159;
         class140.field2178 = 0;
         if(class140.field2168 >= 0) {
            while(class140.field2168 != class140.field2173) {
               var3 = class140.field2181[class140.field2173];
               class140.field2173 = 1 + class140.field2173 & 127;
               if(var3 < 0) {
                  class140.field2171[~var3] = false;
               } else {
                  if(!class140.field2171[var3] && class140.field2178 < class140.field2161.length - 1) {
                     class140.field2161[++class140.field2178 - 1] = var3;
                  }

                  class140.field2171[var3] = true;
               }
            }
         } else {
            for(var3 = 0; var3 < 112; ++var3) {
               class140.field2171[var3] = false;
            }

            class140.field2168 = class140.field2173;
         }

         class140.field2159 = class140.field2180;
      }

      class143 var31 = class143.mouse;
      class143 var5 = class143.mouse;
      synchronized(class143.mouse) {
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

      if(gameState == 0) {
         class153.method3285();
         GroundObject.field1669.vmethod3260();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field2259[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field2260[var1] = 0L;
         }

         class45.field1050 = 0;
      } else if(gameState == 5) {
         XItemContainer.method201(this);
         class153.method3285();
         GroundObject.field1669.vmethod3260();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field2259[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field2260[var1] = 0L;
         }

         class45.field1050 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            XItemContainer.method201(this);
            class118.method2567();
         } else if(gameState == 25) {
            class9.method126();
         }
      } else {
         XItemContainer.method201(this);
      }

      if(gameState == 30) {
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
               class138.setGameState(40);
               class52.field1153 = class40.field904;
               class40.field904 = null;
            }
         } else {
            if(!isMenuOpen) {
               menuOptions[0] = "Cancel";
               menuTargets[0] = "";
               menuTypes[0] = 1006;
               menuOptionCount = 1;
            }

            for(var1 = 0; var1 < 100 && class166.method3350(); ++var1) {
               ;
            }

            if(gameState == 30) {
               while(true) {
                  ClassInfo var32 = (ClassInfo)class214.field3189.method4011();
                  boolean var6;
                  if(null == var32) {
                     var6 = false;
                  } else {
                     var6 = true;
                  }

                  if(!var6) {
                     Object var7 = WidgetNode.field68.field203;
                     Object var15 = WidgetNode.field68.field203;
                     int var8;
                     int var9;
                     int var10;
                     int var11;
                     int var12;
                     int var13;
                     int var14;
                     synchronized(WidgetNode.field68.field203) {
                        if(!field293) {
                           WidgetNode.field68.field204 = 0;
                        } else if(class143.field2217 != 0 || WidgetNode.field68.field204 >= 40) {
                           field337.method2903(121);
                           field337.method2783(0);
                           var3 = field337.offset;
                           var13 = 0;

                           for(var14 = 0; var14 < WidgetNode.field68.field204 && field337.offset - var3 < 240; ++var14) {
                              ++var13;
                              var8 = WidgetNode.field68.field205[var14];
                              if(var8 < 0) {
                                 var8 = 0;
                              } else if(var8 > 502) {
                                 var8 = 502;
                              }

                              var9 = WidgetNode.field68.field210[var14];
                              if(var9 < 0) {
                                 var9 = 0;
                              } else if(var9 > 764) {
                                 var9 = 764;
                              }

                              var10 = 765 * var8 + var9;
                              if(WidgetNode.field68.field205[var14] == -1 && WidgetNode.field68.field210[var14] == -1) {
                                 var9 = -1;
                                 var8 = -1;
                                 var10 = 524287;
                              }

                              if(field307 == var9 && var8 == field468) {
                                 if(field309 < 2047) {
                                    ++field309;
                                 }
                              } else {
                                 var11 = var9 - field307;
                                 field307 = var9;
                                 var12 = var8 - field468;
                                 field468 = var8;
                                 if(field309 < 8 && var11 >= -32 && var11 <= 31 && var12 >= -32 && var12 <= 31) {
                                    var11 += 32;
                                    var12 += 32;
                                    field337.method2619(var12 + (var11 << 6) + (field309 << 12));
                                    field309 = 0;
                                 } else if(field309 < 8) {
                                    field337.method2849(var10 + 8388608 + (field309 << 19));
                                    field309 = 0;
                                 } else {
                                    field337.method2728((field309 << 19) + -1073741824 + var10);
                                    field309 = 0;
                                 }
                              }
                           }

                           field337.method2671(field337.offset - var3);
                           if(var13 >= WidgetNode.field68.field204) {
                              WidgetNode.field68.field204 = 0;
                           } else {
                              WidgetNode.field68.field204 -= var13;

                              for(var14 = 0; var14 < WidgetNode.field68.field204; ++var14) {
                                 WidgetNode.field68.field210[var14] = WidgetNode.field68.field210[var13 + var14];
                                 WidgetNode.field68.field205[var14] = WidgetNode.field68.field205[var14 + var13];
                              }
                           }
                        }
                     }

                     long var33;
                     if(class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4 || class143.field2217 == 2) {
                        var33 = (class143.field2208 - field296) / 50L;
                        if(var33 > 4095L) {
                           var33 = 4095L;
                        }

                        field296 = class143.field2208;
                        var13 = class143.field2216;
                        if(var13 < 0) {
                           var13 = 0;
                        } else if(var13 > Actor.field892) {
                           var13 = Actor.field892;
                        }

                        var14 = class143.field2215;
                        if(var14 < 0) {
                           var14 = 0;
                        } else if(var14 > class189.field3056) {
                           var14 = class189.field3056;
                        }

                        var8 = (int)var33;
                        field337.method2903(209);
                        field337.method2619((var8 << 1) + (class143.field2217 == 2?1:0));
                        field337.method2619(var14);
                        field337.method2619(var13);
                     }

                     if(class140.field2178 > 0) {
                        field337.method2903(158);
                        field337.method2619(0);
                        var1 = field337.offset;
                        var33 = class56.method1249();

                        for(var14 = 0; var14 < class140.field2178; ++var14) {
                           long var17 = var33 - field519;
                           if(var17 > 16777215L) {
                              var17 = 16777215L;
                           }

                           field519 = var33;
                           field337.method2796((int)var17);
                           field337.method2654(class140.field2161[var14]);
                        }

                        field337.method2629(field337.offset - var1);
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
                        field337.method2668(mapAngle);
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
                     if(gameState == 30) {
                        class162.method3319();

                        for(var1 = 0; var1 < field536; ++var1) {
                           --field539[var1];
                           if(field539[var1] >= -10) {
                              class61 var34 = field541[var1];
                              class65 var16;
                              if(var34 == null) {
                                 var16 = null;
                                 var34 = class61.method1380(class119.field2039, field319[var1], 0);
                                 if(null == var34) {
                                    continue;
                                 }

                                 field539[var1] += var34.method1370();
                                 field541[var1] = var34;
                              }

                              if(field539[var1] < 0) {
                                 if(field528[var1] != 0) {
                                    var14 = 128 * (field528[var1] & 255);
                                    var8 = field528[var1] >> 16 & 255;
                                    var9 = 64 + var8 * 128 - WidgetNode.localPlayer.x;
                                    if(var9 < 0) {
                                       var9 = -var9;
                                    }

                                    var10 = field528[var1] >> 8 & 255;
                                    var11 = 64 + var10 * 128 - WidgetNode.localPlayer.y;
                                    if(var11 < 0) {
                                       var11 = -var11;
                                    }

                                    var12 = var9 + var11 - 128;
                                    if(var12 > var14) {
                                       field539[var1] = -100;
                                       continue;
                                    }

                                    if(var12 < 0) {
                                       var12 = 0;
                                    }

                                    var13 = field535 * (var14 - var12) / var14;
                                 } else {
                                    var13 = field403;
                                 }

                                 if(var13 > 0) {
                                    var16 = var34.method1369().method1407(class79.field1463);
                                    class67 var39 = class67.method1427(var16, 100, var13);
                                    var39.method1430(field538[var1] - 1);
                                    class20.field585.method1251(var39);
                                 }

                                 field539[var1] = -100;
                              }
                           } else {
                              --field536;

                              for(var3 = var1; var3 < field536; ++var3) {
                                 field319[var3] = field319[1 + var3];
                                 field541[var3] = field541[var3 + 1];
                                 field538[var3] = field538[var3 + 1];
                                 field539[var3] = field539[var3 + 1];
                                 field528[var3] = field528[var3 + 1];
                              }

                              --var1;
                           }
                        }

                        if(field533 && !VertexNormal.method2285()) {
                           if(field294 != 0 && field457 != -1) {
                              class180.method3615(class188.field3051, field457, 0, field294, false);
                           }

                           field533 = false;
                        }

                        ++field378;
                        if(field378 <= 750) {
                           var1 = class34.field783;
                           int[] var38 = class34.field784;

                           for(var13 = 0; var13 < var1; ++var13) {
                              Player var35 = cachedPlayers[var38[var13]];
                              if(var35 != null) {
                                 class112.method2534(var35, 1);
                              }
                           }

                           for(var1 = 0; var1 < field486; ++var1) {
                              var3 = field334[var1];
                              NPC var36 = cachedNPCs[var3];
                              if(var36 != null) {
                                 class112.method2534(var36, var36.composition.field913);
                              }
                           }

                           int[] var37 = class34.field784;

                           for(var3 = 0; var3 < class34.field783; ++var3) {
                              Player var40 = cachedPlayers[var37[var3]];
                              if(null != var40 && var40.field847 > 0) {
                                 --var40.field847;
                                 if(var40.field847 == 0) {
                                    var40.overhead = null;
                                 }
                              }
                           }

                           for(var3 = 0; var3 < field486; ++var3) {
                              var13 = field334[var3];
                              NPC var41 = cachedNPCs[var13];
                              if(var41 != null && var41.field847 > 0) {
                                 --var41.field847;
                                 if(var41.field847 == 0) {
                                    var41.overhead = null;
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

                           if(null != ObjectComposition.field994) {
                              ++field300;
                              if(field300 >= 15) {
                                 class79.method1777(ObjectComposition.field994);
                                 ObjectComposition.field994 = null;
                              }
                           }

                           Widget var42 = class11.field177;
                           Widget var18 = ChatMessages.field278;
                           class11.field177 = null;
                           ChatMessages.field278 = null;
                           field470 = null;
                           field474 = false;
                           field346 = false;
                           field318 = 0;

                           while(class151.method3275() && field318 < 128) {
                              if(field460 >= 2 && class140.field2171[82] && XClanMember.field643 == 66) {
                                 String var19 = World.method645();
                                 class11.field175.setContents(new StringSelection(var19), (ClipboardOwner)null);
                              } else {
                                 field512[field318] = XClanMember.field643;
                                 field473[field318] = class51.field1146;
                                 ++field318;
                              }
                           }

                           if(widgetRoot != -1) {
                              var13 = widgetRoot;
                              var14 = class189.field3056;
                              var8 = Actor.field892;
                              if(class14.method179(var13)) {
                                 class4.method51(Widget.widgets[var13], -1, 0, 0, var14, var8, 0, 0);
                              }
                           }

                           ++field478;

                           while(true) {
                              Widget var20;
                              Widget var21;
                              class0 var43;
                              do {
                                 var43 = (class0)field335.method3966();
                                 if(null == var43) {
                                    while(true) {
                                       do {
                                          var43 = (class0)field494.method3966();
                                          if(null == var43) {
                                             while(true) {
                                                do {
                                                   var43 = (class0)field353.method3966();
                                                   if(var43 == null) {
                                                      GroundObject.method2253();
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
                                                                  Widget var22 = class23.field614;
                                                                  byte var23 = 0;
                                                                  if(field446 == 1 && var22.contentType == 206) {
                                                                     var23 = 1;
                                                                  }

                                                                  if(var22.itemIds[field484] <= 0) {
                                                                     var23 = 0;
                                                                  }

                                                                  var9 = Player.method39(var22);
                                                                  boolean var24 = (var9 >> 29 & 1) != 0;
                                                                  if(var24) {
                                                                     var10 = field409;
                                                                     var11 = field484;
                                                                     var22.itemIds[var11] = var22.itemIds[var10];
                                                                     var22.itemQuantities[var11] = var22.itemQuantities[var10];
                                                                     var22.itemIds[var10] = -1;
                                                                     var22.itemQuantities[var10] = 0;
                                                                  } else if(var23 == 1) {
                                                                     var10 = field409;
                                                                     var11 = field484;

                                                                     while(var11 != var10) {
                                                                        if(var10 > var11) {
                                                                           var22.method3558(var10 - 1, var10);
                                                                           --var10;
                                                                        } else if(var10 < var11) {
                                                                           var22.method3558(var10 + 1, var10);
                                                                           ++var10;
                                                                        }
                                                                     }
                                                                  } else {
                                                                     var22.method3558(field484, field409);
                                                                  }

                                                                  field337.method2903(105);
                                                                  field337.method2728(class23.field614.id);
                                                                  field337.method2668(field484);
                                                                  field337.method2668(field409);
                                                                  field337.method2658(var23);
                                                               }
                                                            } else if((field412 == 1 || ChatLineBuffer.method680(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                               class172.method3514(field410, field322);
                                                            } else if(menuOptionCount > 0) {
                                                               var13 = field410;
                                                               var14 = field322;
                                                               class132.method2973(class75.field1423, var13, var14);
                                                               class75.field1423 = null;
                                                            }

                                                            field300 = 10;
                                                            class143.field2217 = 0;
                                                            class23.field614 = null;
                                                         }
                                                      }

                                                      if(Region.field1556 != -1) {
                                                         var13 = Region.field1556;
                                                         var14 = Region.field1589;
                                                         field337.method2903(27);
                                                         field337.method2783(5);
                                                         field337.method2619(class21.baseY + var14);
                                                         field337.method2668(var13 + class0.baseX);
                                                         field337.method2783(class140.field2171[82]?(class140.field2171[81]?2:1):0);
                                                         Region.field1556 = -1;
                                                         field480 = class143.field2215;
                                                         field404 = class143.field2216;
                                                         field406 = 1;
                                                         field537 = 0;
                                                         flagX = var13;
                                                         flagY = var14;
                                                      }

                                                      if(var42 != class11.field177) {
                                                         if(null != var42) {
                                                            class79.method1777(var42);
                                                         }

                                                         if(null != class11.field177) {
                                                            class79.method1777(class11.field177);
                                                         }
                                                      }

                                                      if(ChatMessages.field278 != var18 && field444 == field445) {
                                                         if(var18 != null) {
                                                            class79.method1777(var18);
                                                         }

                                                         if(ChatMessages.field278 != null) {
                                                            class79.method1777(ChatMessages.field278);
                                                         }
                                                      }

                                                      if(null != ChatMessages.field278) {
                                                         if(field444 < field445) {
                                                            ++field444;
                                                            if(field445 == field444) {
                                                               class79.method1777(ChatMessages.field278);
                                                            }
                                                         }
                                                      } else if(field444 > 0) {
                                                         --field444;
                                                      }

                                                      var13 = field576 + WidgetNode.localPlayer.x;
                                                      var14 = WidgetNode.localPlayer.y + field360;
                                                      if(MessageNode.field817 - var13 < -500 || MessageNode.field817 - var13 > 500 || class167.field2710 - var14 < -500 || class167.field2710 - var14 > 500) {
                                                         MessageNode.field817 = var13;
                                                         class167.field2710 = var14;
                                                      }

                                                      if(var13 != MessageNode.field817) {
                                                         MessageNode.field817 += (var13 - MessageNode.field817) / 16;
                                                      }

                                                      if(var14 != class167.field2710) {
                                                         class167.field2710 += (var14 - class167.field2710) / 16;
                                                      }

                                                      if(class143.field2207 == 4 && class214.field3188) {
                                                         var8 = class143.field2209 - field553;
                                                         field382 = var8 * 2;
                                                         field553 = var8 != -1 && var8 != 1?(field553 + class143.field2209) / 2:class143.field2209;
                                                         var9 = field383 - class143.field2206;
                                                         field381 = var9 * 2;
                                                         field383 = var9 != -1 && var9 != 1?(class143.field2206 + field383) / 2:class143.field2206;
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

                                                      mapAngle = mapAngle + field381 / 2 & 2047;
                                                      field462 += field382 / 2;
                                                      if(field462 < 128) {
                                                         field462 = 128;
                                                      }

                                                      if(field462 > 383) {
                                                         field462 = 383;
                                                      }

                                                      var8 = MessageNode.field817 >> 7;
                                                      var9 = class167.field2710 >> 7;
                                                      var10 = class127.method2936(MessageNode.field817, class167.field2710, VertexNormal.plane);
                                                      var11 = 0;
                                                      int var44;
                                                      int var45;
                                                      int var46;
                                                      if(var8 > 3 && var9 > 3 && var8 < 100 && var9 < 100) {
                                                         for(var12 = var8 - 4; var12 <= var8 + 4; ++var12) {
                                                            for(var45 = var9 - 4; var45 <= var9 + 4; ++var45) {
                                                               var44 = VertexNormal.plane;
                                                               if(var44 < 3 && (class5.tileSettings[1][var12][var45] & 2) == 2) {
                                                                  ++var44;
                                                               }

                                                               var46 = var10 - class5.tileHeights[var44][var12][var45];
                                                               if(var46 > var11) {
                                                                  var11 = var46;
                                                               }
                                                            }
                                                         }
                                                      }

                                                      var12 = var11 * 192;
                                                      if(var12 > 98048) {
                                                         var12 = 98048;
                                                      }

                                                      if(var12 < '耀') {
                                                         var12 = '耀';
                                                      }

                                                      if(var12 > field540) {
                                                         field540 += (var12 - field540) / 24;
                                                      } else if(var12 < field540) {
                                                         field540 += (var12 - field540) / 80;
                                                      }

                                                      if(field542) {
                                                         var13 = 64 + WidgetNode.field63 * 128;
                                                         var14 = ItemLayer.field1756 * 128 + 64;
                                                         var8 = class127.method2936(var13, var14, VertexNormal.plane) - class77.field1443;
                                                         if(class151.cameraX < var13) {
                                                            class151.cameraX += class152.field2303 * (var13 - class151.cameraX) / 1000 + class165.field2706;
                                                            if(class151.cameraX > var13) {
                                                               class151.cameraX = var13;
                                                            }
                                                         }

                                                         if(class151.cameraX > var13) {
                                                            class151.cameraX -= (class151.cameraX - var13) * class152.field2303 / 1000 + class165.field2706;
                                                            if(class151.cameraX < var13) {
                                                               class151.cameraX = var13;
                                                            }
                                                         }

                                                         if(class8.cameraZ < var8) {
                                                            class8.cameraZ += class165.field2706 + class152.field2303 * (var8 - class8.cameraZ) / 1000;
                                                            if(class8.cameraZ > var8) {
                                                               class8.cameraZ = var8;
                                                            }
                                                         }

                                                         if(class8.cameraZ > var8) {
                                                            class8.cameraZ -= (class8.cameraZ - var8) * class152.field2303 / 1000 + class165.field2706;
                                                            if(class8.cameraZ < var8) {
                                                               class8.cameraZ = var8;
                                                            }
                                                         }

                                                         if(GroundObject.cameraY < var14) {
                                                            GroundObject.cameraY += (var14 - GroundObject.cameraY) * class152.field2303 / 1000 + class165.field2706;
                                                            if(GroundObject.cameraY > var14) {
                                                               GroundObject.cameraY = var14;
                                                            }
                                                         }

                                                         if(GroundObject.cameraY > var14) {
                                                            GroundObject.cameraY -= class152.field2303 * (GroundObject.cameraY - var14) / 1000 + class165.field2706;
                                                            if(GroundObject.cameraY < var14) {
                                                               GroundObject.cameraY = var14;
                                                            }
                                                         }

                                                         var13 = class33.field751 * 128 + 64;
                                                         var14 = 64 + class85.field1514 * 128;
                                                         var8 = class127.method2936(var13, var14, VertexNormal.plane) - class133.field2106;
                                                         var9 = var13 - class151.cameraX;
                                                         var10 = var8 - class8.cameraZ;
                                                         var11 = var14 - GroundObject.cameraY;
                                                         var12 = (int)Math.sqrt((double)(var9 * var9 + var11 * var11));
                                                         var45 = (int)(Math.atan2((double)var10, (double)var12) * 325.949D) & 2047;
                                                         var44 = (int)(Math.atan2((double)var9, (double)var11) * -325.949D) & 2047;
                                                         if(var45 < 128) {
                                                            var45 = 128;
                                                         }

                                                         if(var45 > 383) {
                                                            var45 = 383;
                                                         }

                                                         if(ItemLayer.cameraPitch < var45) {
                                                            ItemLayer.cameraPitch += (var45 - ItemLayer.cameraPitch) * ChatMessages.field275 / 1000 + DecorativeObject.field1687;
                                                            if(ItemLayer.cameraPitch > var45) {
                                                               ItemLayer.cameraPitch = var45;
                                                            }
                                                         }

                                                         if(ItemLayer.cameraPitch > var45) {
                                                            ItemLayer.cameraPitch -= ChatMessages.field275 * (ItemLayer.cameraPitch - var45) / 1000 + DecorativeObject.field1687;
                                                            if(ItemLayer.cameraPitch < var45) {
                                                               ItemLayer.cameraPitch = var45;
                                                            }
                                                         }

                                                         var46 = var44 - class59.cameraYaw;
                                                         if(var46 > 1024) {
                                                            var46 -= 2048;
                                                         }

                                                         if(var46 < -1024) {
                                                            var46 += 2048;
                                                         }

                                                         if(var46 > 0) {
                                                            class59.cameraYaw += DecorativeObject.field1687 + var46 * ChatMessages.field275 / 1000;
                                                            class59.cameraYaw &= 2047;
                                                         }

                                                         if(var46 < 0) {
                                                            class59.cameraYaw -= DecorativeObject.field1687 + ChatMessages.field275 * -var46 / 1000;
                                                            class59.cameraYaw &= 2047;
                                                         }

                                                         int var25 = var44 - class59.cameraYaw;
                                                         if(var25 > 1024) {
                                                            var25 -= 2048;
                                                         }

                                                         if(var25 < -1024) {
                                                            var25 += 2048;
                                                         }

                                                         if(var25 < 0 && var46 > 0 || var25 > 0 && var46 < 0) {
                                                            class59.cameraYaw = var44;
                                                         }
                                                      }

                                                      for(var13 = 0; var13 < 5; ++var13) {
                                                         ++field547[var13];
                                                      }

                                                      Actor.chatMessages.method227();
                                                      var13 = class47.method1011();
                                                      var14 = Player.method41();
                                                      if(var13 > 15000 && var14 > 15000) {
                                                         field299 = 250;
                                                         class143.mouseIdleTicks = 14500;
                                                         field337.method2903(59);
                                                      }

                                                      ++field364;
                                                      if(field364 > 500) {
                                                         field364 = 0;
                                                         var8 = (int)(Math.random() * 8.0D);
                                                         if((var8 & 1) == 1) {
                                                            field576 += field405;
                                                         }

                                                         if((var8 & 2) == 2) {
                                                            field360 += field361;
                                                         }

                                                         if((var8 & 4) == 4) {
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
                                                         var8 = (int)(Math.random() * 8.0D);
                                                         if((var8 & 1) == 1) {
                                                            mapScale += field441;
                                                         }

                                                         if((var8 & 2) == 2) {
                                                            mapScaleDelta += field531;
                                                         }
                                                      }

                                                      if(mapScale < -60) {
                                                         field441 = 2;
                                                      }

                                                      if(mapScale > 60) {
                                                         field441 = -2;
                                                      }

                                                      if(mapScaleDelta < -20) {
                                                         field531 = 1;
                                                      }

                                                      if(mapScaleDelta > 10) {
                                                         field531 = -1;
                                                      }

                                                      for(class40 var47 = (class40)field351.method3928(); null != var47; var47 = (class40)field351.method3933()) {
                                                         if((long)var47.field894 < class56.method1249() / 1000L - 5L) {
                                                            if(var47.field896 > 0) {
                                                               SecondaryBufferProvider.sendGameMessage(5, "", var47.field895 + " has logged in.");
                                                            }

                                                            if(var47.field896 == 0) {
                                                               SecondaryBufferProvider.sendGameMessage(5, "", var47.field895 + " has logged out.");
                                                            }

                                                            var47.method4063();
                                                         }
                                                      }

                                                      ++field343;
                                                      if(field343 > 50) {
                                                         field337.method2903(177);
                                                      }

                                                      try {
                                                         if(null != class40.field904 && field337.offset > 0) {
                                                            class40.field904.method3135(field337.payload, 0, field337.offset);
                                                            field337.offset = 0;
                                                            field343 = 0;
                                                            return;
                                                         }
                                                      } catch (IOException var26) {
                                                         ItemLayer.method2289();
                                                      }

                                                      return;
                                                   }

                                                   var20 = var43.field2;
                                                   if(var20.index < 0) {
                                                      break;
                                                   }

                                                   var21 = class134.method2983(var20.parentId);
                                                } while(null == var21 || var21.children == null || var20.index >= var21.children.length || var21.children[var20.index] != var20);

                                                class16.method203(var43);
                                             }
                                          }

                                          var20 = var43.field2;
                                          if(var20.index < 0) {
                                             break;
                                          }

                                          var21 = class134.method2983(var20.parentId);
                                       } while(null == var21 || var21.children == null || var20.index >= var21.children.length || var20 != var21.children[var20.index]);

                                       class16.method203(var43);
                                    }
                                 }

                                 var20 = var43.field2;
                                 if(var20.index < 0) {
                                    break;
                                 }

                                 var21 = class134.method2983(var20.parentId);
                              } while(var21 == null || var21.children == null || var20.index >= var21.children.length || var21.children[var20.index] != var20);

                              class16.method203(var43);
                           }
                        }

                        ItemLayer.method2289();
                     }
                     break;
                  }

                  field337.method2903(117);
                  field337.method2783(0);
                  var3 = field337.offset;
                  class167.method3370(field337);
                  field337.method2671(field337.offset - var3);
               }
            }
         }
      } else if(gameState == 40 || gameState == 45) {
         class118.method2567();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1210517442"
   )
   void method262() {
      if(gameState != 1000) {
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
         gameState = 1000;
      } else {
         if(class174.field2787 >= 4) {
            if(gameState <= 5) {
               this.method3170("js5io");
               gameState = 1000;
               return;
            }

            field325 = 3000;
            class174.field2787 = 3;
         }

         if(--field325 + 1 <= 0) {
            try {
               if(field324 == 0) {
                  class141.field2187 = class125.field2070.method3028(FrameMap.host, class109.field1943);
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
                  Buffer var1 = new Buffer(5);
                  var1.method2783(15);
                  var1.method2728(120);
                  class22.field601.method3135(var1.payload, 0, 5);
                  ++field324;
                  field469 = class56.method1249();
               }

               if(field324 == 3) {
                  if(gameState > 5 && class22.field601.method3141() <= 0) {
                     if(class56.method1249() - field469 > 30000L) {
                        this.method264(-2);
                        return;
                     }
                  } else {
                     int var3 = class22.field601.method3140();
                     if(var3 != 0) {
                        this.method264(var3);
                        return;
                     }

                     ++field324;
                  }
               }

               if(field324 == 4) {
                  SecondaryBufferProvider.method1722(class22.field601, gameState > 20);
                  class141.field2187 = null;
                  class22.field601 = null;
                  field324 = 0;
                  field327 = 0;
               }
            } catch (IOException var2) {
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
            gameState = 1000;
         } else if(field327 >= 4) {
            if(gameState <= 5) {
               this.method3170("js5connect");
               gameState = 1000;
            } else {
               field325 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method3170("js5connect_full");
         gameState = 1000;
      } else {
         field325 = 3000;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1575533843"
   )
   protected final void vmethod3234() {
      if(Actor.chatMessages.method228()) {
         Actor.chatMessages.method225();
      }

      if(null != WidgetNode.field68) {
         WidgetNode.field68.field206 = false;
      }

      WidgetNode.field68 = null;
      if(class40.field904 != null) {
         class40.field904.method3131();
         class40.field904 = null;
      }

      if(class140.keyboard != null) {
         class140 var1 = class140.keyboard;
         class140 var2 = class140.keyboard;
         synchronized(class140.keyboard) {
            class140.keyboard = null;
         }
      }

      class43.method896();
      class152.field2302 = null;
      if(Projectile.field127 != null) {
         Projectile.field127.method1322();
      }

      if(null != class125.field2069) {
         class125.field2069.method1322();
      }

      class109.method2483();
      Object var8 = class173.field2763;
      Object var9 = class173.field2763;
      synchronized(class173.field2763) {
         if(class173.field2767 != 0) {
            class173.field2767 = 1;

            try {
               class173.field2763.wait();
            } catch (InterruptedException var5) {
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
      label187: {
         try {
            if(class186.field3010 == 2) {
               if(null == class186.field3011) {
                  class186.field3011 = class183.method3669(CollisionData.field1970, class140.field2184, class186.field3009);
                  if(class186.field3011 == null) {
                     var1 = false;
                     break label187;
                  }
               }

               if(class43.field1010 == null) {
                  class43.field1010 = new class62(class159.field2369, class186.field3012);
               }

               if(class59.field1266.method3751(class186.field3011, class145.field2235, class43.field1010, 22050)) {
                  class59.field1266.method3839();
                  class59.field1266.method3750(class11.field176);
                  class59.field1266.method3755(class186.field3011, MessageNode.field814);
                  class186.field3010 = 0;
                  class186.field3011 = null;
                  class43.field1010 = null;
                  CollisionData.field1970 = null;
                  var1 = true;
                  break label187;
               }
            }
         } catch (Exception var10) {
            var10.printStackTrace();
            class59.field1266.method3754();
            class186.field3010 = 0;
            class186.field3011 = null;
            class43.field1010 = null;
            CollisionData.field1970 = null;
         }

         var1 = false;
      }

      if(var1 && field533 && Projectile.field127 != null) {
         Projectile.field127.method1296();
      }

      int var2;
      int var3;
      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field352 && class56.method1249() > field352) {
            int var11 = class53.method1139();
            field352 = 0L;
            if(var11 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            class10.method143();
            if(gameState >= 25) {
               Projectile.method103();
            }

            GameEngine.field2263 = true;
         } else if(GameEngine.field2266) {
            class21.method582(class107.canvas);
            Canvas var4 = class107.canvas;
            var4.removeMouseListener(class143.mouse);
            var4.removeMouseMotionListener(class143.mouse);
            var4.removeFocusListener(class143.mouse);
            class143.field2204 = 0;
            if(class152.field2302 != null) {
               class152.field2302.vmethod3252(class107.canvas);
            }

            field477.method3156();
            class107.canvas.setBackground(Color.black);
            Canvas var5 = class107.canvas;
            var5.setFocusTraversalKeysEnabled(false);
            var5.addKeyListener(class140.keyboard);
            var5.addFocusListener(class140.keyboard);
            class114.method2542(class107.canvas);
            if(class152.field2302 != null) {
               class152.field2302.vmethod3251(class107.canvas);
            }

            if(widgetRoot != -1) {
               var2 = widgetRoot;
               var3 = class189.field3056;
               int var6 = Actor.field892;
               if(class14.method179(var2)) {
                  class0.method2(Widget.widgets[var2], -1, var3, var6, false);
               }
            }

            GameEngine.field2265 = true;
         }
      }

      Dimension var12 = this.method3172();
      if(SecondaryBufferProvider.field1450 != var12.width || var12.height != class144.field2220 || GameEngine.field2265) {
         class10.method143();
         field352 = class56.method1249() + 500L;
         GameEngine.field2265 = false;
      }

      boolean var13 = false;
      if(GameEngine.field2263) {
         GameEngine.field2263 = false;
         var13 = true;

         for(var2 = 0; var2 < 100; ++var2) {
            field498[var2] = true;
         }
      }

      if(var13) {
         RSCanvas.method3088();
      }

      if(gameState == 0) {
         class116.method2556(class33.field757, class33.field758, (Color)null, var13);
      } else if(gameState == 5) {
         class143.method3118(class59.field1268, Ignore.field133, class8.field144, var13);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class143.method3118(class59.field1268, Ignore.field133, class8.field144, var13);
         } else if(gameState == 25) {
            if(field527 == 1) {
               if(field342 > field350) {
                  field350 = field342;
               }

               var2 = (field350 * 50 - field342 * 50) / field350;
               class9.method131("Loading - please wait.<br> (" + var2 + "%" + ")", false);
            } else if(field527 == 2) {
               if(field493 > field534) {
                  field534 = field493;
               }

               var2 = 50 + (field534 * 50 - field493 * 50) / field534;
               class9.method131("Loading - please wait.<br> (" + var2 + "%" + ")", false);
            } else {
               class9.method131("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            class31.method694();
         } else if(gameState == 40) {
            class9.method131("Connection lost<br>Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class9.method131("Please wait...", false);
         }
      } else {
         class143.method3118(class59.field1268, Ignore.field133, class8.field144, var13);
      }

      Graphics var14;
      if(gameState == 30 && field357 == 0 && !var13) {
         try {
            var14 = class107.canvas.getGraphics();

            for(var3 = 0; var3 < field496; ++var3) {
               if(field499[var3]) {
                  class54.bufferProvider.drawSub(var14, widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
                  field499[var3] = false;
               }
            }
         } catch (Exception var9) {
            class107.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var14 = class107.canvas.getGraphics();
            class54.bufferProvider.draw(var14, 0, 0);

            for(var3 = 0; var3 < field496; ++var3) {
               field499[var3] = false;
            }
         } catch (Exception var8) {
            class107.canvas.repaint();
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
      cachedNPCs = new NPC['耀'];
      field486 = 0;
      field334 = new int['耀'];
      field454 = 0;
      field336 = new int[250];
      field337 = new class125(5000);
      field333 = new class125(5000);
      field339 = new class125(15000);
      field340 = 0;
      packetOpcode = 0;
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
      collisionMaps = new CollisionData[4];
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
      mapScale = 0;
      field441 = 2;
      mapScaleDelta = 0;
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
      mapAngle = 0;
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
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field418 = 0;
      field419 = 0;
      field388 = new int[1000];
      field421 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field422 = new String[8];
      field423 = new boolean[8];
      field358 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field425 = -1;
      groundItemDeque = new Deque[4][104][104];
      field427 = new Deque();
      projectiles = new Deque();
      field429 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field412 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
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
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field455 = 0;
      field446 = 0;
      field376 = null;
      energy = 0;
      weight = 0;
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
      field353 = new Deque();
      field335 = new Deque();
      field494 = new Deque();
      widgetFlags = new XHashTable(512);
      field496 = 0;
      field497 = -2;
      field498 = new boolean[100];
      field499 = new boolean[100];
      field500 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field357 = 0;
      field352 = 0L;
      isResized = true;
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
      field453 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
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
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field562 = 0;
      friends = new Friend[400];
      field351 = new class198();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field567 = new PlayerComposition();
      field568 = -1;
      field569 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field571 = -1L;
      field572 = -1L;
      field573 = new class10();
      field574 = new int[50];
      field575 = new int[50];
   }
}
