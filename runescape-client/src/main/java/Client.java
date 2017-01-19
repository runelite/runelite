import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1228465191
   )
   static int field292;
   @ObfuscatedName("f")
   static boolean field293 = true;
   @ObfuscatedName("le")
   static boolean[] field294;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 2095406499
   )
   static int field295;
   @ObfuscatedName("g")
   static class178 field296;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1143342757
   )
   static int field297 = 0;
   @ObfuscatedName("r")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("n")
   static boolean field299 = false;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -445513891
   )
   static int field300 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -573080075
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("e")
   static boolean field302 = true;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 152503375
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -8221875906135989093L
   )
   static long field304 = -1L;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 232985239
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1305036281
   )
   static int field306 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -476945015
   )
   static int field307 = -1;
   @ObfuscatedName("ai")
   static boolean field308 = true;
   @ObfuscatedName("ad")
   static boolean field309 = false;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 1053193317
   )
   static int field310;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -270756939
   )
   static int field311 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1173290029
   )
   static int field312 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 157685299
   )
   static int field313 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -819087889
   )
   static int field314 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1379194823
   )
   static int field315 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1582899293
   )
   static int field316 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -449402521
   )
   static int field317 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 2033232087
   )
   static int field318 = 0;
   @ObfuscatedName("aq")
   static class40 field319;
   @ObfuscatedName("af")
   static class40 field320;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 321365249
   )
   static int field321;
   @ObfuscatedName("id")
   static String field322;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -146093855
   )
   static int field323;
   @ObfuscatedName("bl")
   static class184 field324;
   @ObfuscatedName("bh")
   static class184 field325;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -314476467
   )
   static int field326;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1074806387
   )
   static int field327;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1887748085
   )
   static int field328;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -538331331
   )
   static int field329;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 2046762873
   )
   static int field330;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 1160335755
   )
   static int field331;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 139787095
   )
   static int field332;
   @ObfuscatedName("cb")
   static int[] field333;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 144146811
   )
   static int field334;
   @ObfuscatedName("ca")
   static int[] field335;
   @ObfuscatedName("cs")
   static class159 field336;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1723438325
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("fi")
   static int[] field338;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 361333871
   )
   static int field339;
   @ObfuscatedName("kd")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("fv")
   static int[] field341;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -2108948569
   )
   static int field342;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1336195769
   )
   static int field344;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -589773767
   )
   static int field345;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1374507147
   )
   static int field346;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 752232109
   )
   static int field347;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 391838475
   )
   static int field348;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -747525923
   )
   static int field349;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -94577691
   )
   static int field350;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 1807327867
   )
   static int field351;
   @ObfuscatedName("cm")
   static class159 field352;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("di")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 2114677017
   )
   static int field355;
   @ObfuscatedName("dk")
   static final int[] field356;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -1853014739
   )
   static int field357;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -952205513
   )
   static int field358;
   @ObfuscatedName("hf")
   static Deque field359;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -2075715489
   )
   static int field360;
   @ObfuscatedName("lo")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -1235825073
   )
   static int field362;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -1596030395
   )
   static int field363;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -148953551
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 620152761
   )
   static int field365;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 422148797
   )
   static int field366;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 1658834397
   )
   static int field367;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1748050459
   )
   static int field368;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -497695155
   )
   static int field369;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -1674968449
   )
   static int field370;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -1206789953
   )
   static int field371;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -2055284587
   )
   static int field372;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1304046289
   )
   static int field373;
   @ObfuscatedName("oe")
   static short field374;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1949772899
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -2066594881
   )
   static int field376;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 1939523097
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -1493830103
   )
   static int field378;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -694993303
   )
   static int field379;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 1498302117
   )
   static int field380;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -127305485
   )
   static int field381;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -431999291
   )
   static int field382;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1887705873
   )
   static int field383;
   @ObfuscatedName("oc")
   static short field384;
   @ObfuscatedName("fw")
   static boolean field385;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -5007529
   )
   static int field386;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 1179831317
   )
   static int field387;
   @ObfuscatedName("kb")
   static Deque field388;
   @ObfuscatedName("fc")
   static int[] field389;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -972398365
   )
   static int field390;
   @ObfuscatedName("fg")
   static int[] field391;
   @ObfuscatedName("fs")
   static int[] field392;
   @ObfuscatedName("fa")
   static int[] field393;
   @ObfuscatedName("fh")
   static int[] field394;
   @ObfuscatedName("gp")
   static String[] field395;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      longValue = 3832249542097920021L
   )
   static long field396;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1910947311
   )
   static int field397;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 396490493
   )
   static int field398;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1133001409
   )
   static int field399;
   @ObfuscatedName("hz")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -895799429
   )
   static int field401;
   @ObfuscatedName("hm")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("li")
   static int[] field403;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -680118301
   )
   static int field404;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1866694171
   )
   static int field405;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -43706781
   )
   static int field406;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -36346975
   )
   static int field407;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 1305945377
   )
   static int field408;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 1572550079
   )
   static int field409;
   @ObfuscatedName("gv")
   static boolean field410;
   @ObfuscatedName("hc")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -1382434687
   )
   static int field412;
   @ObfuscatedName("ge")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1493272633
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -62086479
   )
   static int field415;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1703072041
   )
   static int field416;
   @ObfuscatedName("kx")
   static Deque field417;
   @ObfuscatedName("hb")
   static final int[] field418;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1506688847
   )
   static int field419;
   @ObfuscatedName("ne")
   static class53[] field420;
   @ObfuscatedName("hp")
   static int[] field421;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 900810593
   )
   static int field422;
   @ObfuscatedName("hh")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      longValue = 1229118246126831723L
   )
   static long field424;
   @ObfuscatedName("hd")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hx")
   static Deque field426;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -965027121
   )
   static int field427;
   @ObfuscatedName("hl")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("ju")
   static boolean field429;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -463545417
   )
   static int field430;
   @ObfuscatedName("hj")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 866792661
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1449633335
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("hg")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("lu")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("ib")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("hn")
   @Export("playerOptionsPriority")
   static boolean[] playerOptionsPriority;
   @ObfuscatedName("iw")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ik")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 1860953477
   )
   static int field440;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 1714060769
   )
   static int field441;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 328645165
   )
   static int field442;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 858483117
   )
   static int field443;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 952752179
   )
   static int field444;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 468174151
   )
   static int field445 = -1;
   @ObfuscatedName("ih")
   static boolean field446;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = -883172047
   )
   static int field447;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -513862287
   )
   static int field448;
   @ObfuscatedName("iz")
   static String field449;
   @ObfuscatedName("ig")
   static String field450;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -2012791501
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ij")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = 1203845811
   )
   static int field453;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 20381213
   )
   static int field454;
   @ObfuscatedName("jd")
   static Widget field455;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1997176837
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -1568633595
   )
   static int field457;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -629598431
   )
   static int field458;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 1755143809
   )
   static int field459;
   @ObfuscatedName("jp")
   static boolean field460;
   @ObfuscatedName("jn")
   static boolean field461;
   @ObfuscatedName("jr")
   static boolean field462;
   @ObfuscatedName("jt")
   static Widget field463;
   @ObfuscatedName("je")
   static Widget field464;
   @ObfuscatedName("jx")
   static Widget field465;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -1704382127
   )
   static int field466;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -1566474259
   )
   static int field467;
   @ObfuscatedName("jk")
   static Widget field468;
   @ObfuscatedName("oz")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("ob")
   static PlayerComposition field470;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = -585711073
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("jy")
   static boolean field472;
   @ObfuscatedName("cw")
   static boolean field473;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 691715875
   )
   static int field474;
   @ObfuscatedName("jh")
   static boolean field475;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 1370037249
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("kp")
   static int[] field477;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 1863040133
   )
   static int field478;
   @ObfuscatedName("ki")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1505877851
   )
   static int field480;
   @ObfuscatedName("kt")
   static int[] field481;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -1022765689
   )
   static int field482;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -79063623
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -444493515
   )
   static int field484;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -1951661753
   )
   static int field485;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1673347859
   )
   static int field486;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1510428491
   )
   static int field487;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -817904629
   )
   static int field488;
   @ObfuscatedName("ku")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("la")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("cg")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("kh")
   static Deque field492;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -514880463
   )
   static int field493;
   @ObfuscatedName("mp")
   static int[] field494;
   @ObfuscatedName("oj")
   static int[] field495;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 562773981
   )
   static int field496;
   @ObfuscatedName("ko")
   static boolean[] field497;
   @ObfuscatedName("pb")
   static final class22 field498;
   @ObfuscatedName("nm")
   static boolean field499;
   @ObfuscatedName("ex")
   static boolean field500;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -611291737
   )
   static int field501;
   @ObfuscatedName("nt")
   static int[] field502;
   @ObfuscatedName("lz")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 1310735435
   )
   static int field504;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -885015119
   )
   static int field505;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -1450677677
   )
   static int field506;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 834880935
   )
   static int field507;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -1516636921
   )
   static int field508;
   @ObfuscatedName("ht")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 1181280337
   )
   static int field510;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 379276667
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("ly")
   static String field512;
   @ObfuscatedName("ln")
   static long[] field513;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 69864801
   )
   static int field514;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -1510756191
   )
   static int field515;
   @ObfuscatedName("lc")
   static int[] field516;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1877793757
   )
   static int field517;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = -553218663
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("mx")
   static String field519;
   @ObfuscatedName("mw")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("hv")
   static int[] field521;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1572392129
   )
   static int field522;
   @ObfuscatedName("mj")
   static int[] field523;
   @ObfuscatedName("ma")
   static int[] field524;
   @ObfuscatedName("mt")
   static SpritePixels[] field525;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = -1105861555
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1150691361
   )
   static int field528;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -1641988411
   )
   static int field529;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 443043795
   )
   static int field530;
   @ObfuscatedName("me")
   static boolean field531;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 22784953
   )
   static int field532;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 105537279
   )
   static int field533;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1903089447
   )
   static int field534 = 0;
   @ObfuscatedName("op")
   static short field535;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -1310511013
   )
   static int field536;
   @ObfuscatedName("ni")
   static int[] field537;
   @ObfuscatedName("ny")
   static int[] field538;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 104030511
   )
   static int field539;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -1521059167
   )
   static int field540;
   @ObfuscatedName("nq")
   static boolean[] field541;
   @ObfuscatedName("lj")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("ov")
   static int[] field543;
   @ObfuscatedName("ox")
   static int[] field544;
   @ObfuscatedName("oh")
   static int[] field545;
   @ObfuscatedName("ol")
   static short field546;
   @ObfuscatedName("oy")
   static short field547;
   @ObfuscatedName("dl")
   static int[][][] field548;
   @ObfuscatedName("ot")
   static short field549;
   @ObfuscatedName("oi")
   static short field550;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1680006891
   )
   static int field551;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1298418983
   )
   static int field552;
   @ObfuscatedName("or")
   static short field553;
   @ObfuscatedName("im")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 1622470727
   )
   static int field555;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 747303933
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      longValue = -8844845742622077565L
   )
   static long field557;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 1910812187
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("gl")
   static int[][] field559;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -346181111
   )
   static int field560;
   @ObfuscatedName("ls")
   static boolean[] field561;
   @ObfuscatedName("of")
   static class130 field562;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = 1442636713
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("on")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("nd")
   static int[] field565;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = 74714527
   )
   static int field566;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = -1961480255
   )
   static int field567;
   @ObfuscatedName("pn")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      longValue = -6916355966716911047L
   )
   static long field569;
   @ObfuscatedName("cv")
   static class159 field570;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 1974992685
   )
   static int field571;
   @ObfuscatedName("pi")
   static int[] field572;
   @ObfuscatedName("pa")
   static int[] field573;
   @ObfuscatedName("c")
   static class182 field575;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 1709938605
   )
   static int field576;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1498655735"
   )
   protected final void vmethod2055() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-782581470"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method235();
      class155.method2927();

      int var1;
      try {
         if(class138.field1933 == 1) {
            var1 = class138.field1923.method2415();
            if(var1 > 0 && class138.field1923.method2421()) {
               var1 -= class138.field1926;
               if(var1 < 0) {
                  var1 = 0;
               }

               class138.field1923.method2531(var1);
            } else {
               class138.field1923.method2503();
               class138.field1923.method2418();
               if(ChatLineBuffer.field967 != null) {
                  class138.field1933 = 2;
               } else {
                  class138.field1933 = 0;
               }

               class138.field1928 = null;
               FrameMap.field1472 = null;
            }
         }
      } catch (Exception var8) {
         var8.printStackTrace();
         class138.field1923.method2503();
         class138.field1933 = 0;
         class138.field1928 = null;
         FrameMap.field1472 = null;
         ChatLineBuffer.field967 = null;
      }

      ChatMessages.method830();
      class105 var5 = class105.keyboard;
      synchronized(class105.keyboard) {
         ++class105.keyboardIdleTicks;
         class105.field1695 = class105.field1696;
         class105.field1722 = 0;
         int var2;
         if(class105.field1712 >= 0) {
            while(class105.field1712 != class105.field1711) {
               var2 = class105.field1710[class105.field1711];
               class105.field1711 = class105.field1711 + 1 & 127;
               if(var2 < 0) {
                  class105.field1709[~var2] = false;
               } else {
                  if(!class105.field1709[var2] && class105.field1722 < class105.field1715.length - 1) {
                     class105.field1715[++class105.field1722 - 1] = var2;
                  }

                  class105.field1709[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               class105.field1709[var2] = false;
            }

            class105.field1712 = class105.field1711;
         }

         class105.field1696 = class105.field1713;
      }

      class115 var9 = class115.mouse;
      synchronized(class115.mouse) {
         class115.field1801 = class115.field1798;
         class115.field1810 = class115.field1799;
         class115.field1803 = class115.field1800;
         class115.field1807 = class115.field1804;
         class115.field1809 = class115.field1808;
         class115.field1796 = class115.field1806;
         class115.field1811 = class115.field1805;
         class115.field1804 = 0;
      }

      if(null != class184.field2746) {
         var1 = class184.field2746.vmethod2037();
         field380 = var1;
      }

      if(gameState == 0) {
         XClanMember.method226();
         class101.field1654.vmethod1992();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1778[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1779[var1] = 0L;
         }

         class45.field895 = 0;
      } else if(gameState == 5) {
         class5.method67(this);
         XClanMember.method226();
         class101.field1654.vmethod1992();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1778[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1779[var1] = 0L;
         }

         class45.field895 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class5.method67(this);
            CombatInfoListHolder.method687();
         } else if(gameState == 25) {
            class178.method3165();
         }
      } else {
         class5.method67(this);
      }

      if(gameState == 30) {
         XClanMember.method225();
      } else if(gameState == 40 || gameState == 45) {
         CombatInfoListHolder.method687();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1666793926"
   )
   protected final void vmethod2075() {
      boolean var1;
      label226: {
         try {
            if(class138.field1933 == 2) {
               if(null == class138.field1928) {
                  class138.field1928 = class144.method2637(ChatLineBuffer.field967, GroundObject.field1298, class207.field3097);
                  if(class138.field1928 == null) {
                     var1 = false;
                     break label226;
                  }
               }

               if(FrameMap.field1472 == null) {
                  FrameMap.field1472 = new class60(class138.field1922, class0.field5);
               }

               if(class138.field1923.method2416(class138.field1928, class138.field1931, FrameMap.field1472, 22050)) {
                  class138.field1923.method2456();
                  class138.field1923.method2531(class138.field1921);
                  class138.field1923.method2419(class138.field1928, class138.field1927);
                  class138.field1933 = 0;
                  class138.field1928 = null;
                  FrameMap.field1472 = null;
                  ChatLineBuffer.field967 = null;
                  var1 = true;
                  break label226;
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
            class138.field1923.method2503();
            class138.field1933 = 0;
            class138.field1928 = null;
            FrameMap.field1472 = null;
            ChatLineBuffer.field967 = null;
         }

         var1 = false;
      }

      if(var1 && field531 && null != GameObject.field1626) {
         GameObject.field1626.method1017();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field557 && class2.method27() > field557) {
            class180.method3175(Tile.method1515());
         } else if(GameEngine.field1786) {
            class140.method2552();
         }
      }

      Dimension var3 = this.method2083();
      if(class15.field180 != var3.width || var3.height != class25.field590 || GameEngine.field1770) {
         class45.method789();
         field557 = class2.method27() + 500L;
         GameEngine.field1770 = false;
      }

      boolean var4 = false;
      int var5;
      if(GameEngine.field1783) {
         GameEngine.field1783 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field497[var5] = true;
         }
      }

      if(var4) {
         class36.method713();
      }

      if(gameState == 0) {
         var5 = class41.field828;
         String var6 = class41.field822;
         Color var7 = null;

         try {
            Graphics var8 = class25.canvas.getGraphics();
            if(null == Friend.field164) {
               Friend.field164 = new java.awt.Font("Helvetica", 1, 13);
               GameEngine.field1787 = class25.canvas.getFontMetrics(Friend.field164);
            }

            if(var4) {
               var8.setColor(Color.black);
               var8.fillRect(0, 0, class16.field186, ChatMessages.field907);
            }

            if(null == var7) {
               var7 = new Color(140, 17, 17);
            }

            try {
               if(null == class167.field2194) {
                  class167.field2194 = class25.canvas.createImage(304, 34);
               }

               Graphics var9 = class167.field2194.getGraphics();
               var9.setColor(var7);
               var9.drawRect(0, 0, 303, 33);
               var9.fillRect(2, 2, var5 * 3, 30);
               var9.setColor(Color.black);
               var9.drawRect(1, 1, 301, 31);
               var9.fillRect(2 + var5 * 3, 2, 300 - var5 * 3, 30);
               var9.setFont(Friend.field164);
               var9.setColor(Color.white);
               var9.drawString(var6, (304 - GameEngine.field1787.stringWidth(var6)) / 2, 22);
               var8.drawImage(class167.field2194, class16.field186 / 2 - 152, ChatMessages.field907 / 2 - 18, (ImageObserver)null);
            } catch (Exception var15) {
               int var10 = class16.field186 / 2 - 152;
               int var11 = ChatMessages.field907 / 2 - 18;
               var8.setColor(var7);
               var8.drawRect(var10, var11, 303, 33);
               var8.fillRect(var10 + 2, var11 + 2, var5 * 3, 30);
               var8.setColor(Color.black);
               var8.drawRect(var10 + 1, var11 + 1, 301, 31);
               var8.fillRect(var5 * 3 + 2 + var10, 2 + var11, 300 - 3 * var5, 30);
               var8.setFont(Friend.field164);
               var8.setColor(Color.white);
               var8.drawString(var6, var10 + (304 - GameEngine.field1787.stringWidth(var6)) / 2, var11 + 22);
            }
         } catch (Exception var16) {
            class25.canvas.repaint();
         }
      } else if(gameState == 5) {
         class85.method1651(class16.field187, class137.field1909, class20.field234, var4);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class85.method1651(class16.field187, class137.field1909, class20.field234, var4);
         } else if(gameState == 25) {
            if(field528 == 1) {
               if(field348 > field349) {
                  field349 = field348;
               }

               var5 = (field349 * 50 - field348 * 50) / field349;
               class36.method714("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field528 == 2) {
               if(field350 > field351) {
                  field351 = field350;
               }

               var5 = (field351 * 50 - field350 * 50) / field351 + 50;
               class36.method714("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class36.method714("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            XItemContainer.method143();
         } else if(gameState == 40) {
            class36.method714("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class36.method714("Please wait...", false);
         }
      } else {
         class85.method1651(class16.field187, class137.field1909, class20.field234, var4);
      }

      Graphics var13;
      int var14;
      if(gameState == 30 && field504 == 0 && !var4) {
         try {
            var13 = class25.canvas.getGraphics();

            for(var14 = 0; var14 < field404; ++var14) {
               if(field294[var14]) {
                  class57.bufferProvider.drawSub(var13, widgetPositionX[var14], widgetPositionY[var14], widgetBoundsWidth[var14], widgetBoundsHeight[var14]);
                  field294[var14] = false;
               }
            }
         } catch (Exception var18) {
            class25.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var13 = class25.canvas.getGraphics();
            class57.bufferProvider.draw(var13, 0, 0);

            for(var14 = 0; var14 < field404; ++var14) {
               field294[var14] = false;
            }
         } catch (Exception var17) {
            class25.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "553991589"
   )
   void method235() {
      if(gameState != 1000) {
         boolean var1 = FileOnDisk.method1385();
         if(!var1) {
            this.method525();
         }

      }
   }

   static {
      field319 = class40.field806;
      field320 = class40.field806;
      field321 = 0;
      field507 = 0;
      field323 = 0;
      field326 = 0;
      field327 = 0;
      field328 = 0;
      field329 = 0;
      field330 = 0;
      cachedNPCs = new NPC['耀'];
      field332 = 0;
      field333 = new int['耀'];
      field334 = 0;
      field335 = new int[250];
      field336 = new class159(5000);
      field570 = new class159(5000);
      field352 = new class159(15000);
      field339 = 0;
      packetOpcode = 0;
      field517 = 0;
      field342 = 0;
      field480 = 0;
      field552 = 0;
      field345 = 0;
      field346 = 0;
      field473 = false;
      field348 = 0;
      field349 = 1;
      field350 = 0;
      field351 = 1;
      field528 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field548 = new int[4][13][13];
      field356 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field560 = 0;
      field522 = 2;
      field536 = 0;
      field360 = 2;
      field382 = 0;
      field362 = 1;
      field363 = 0;
      mapScale = 0;
      field365 = 2;
      mapScaleDelta = 0;
      field367 = 1;
      field368 = 0;
      field533 = 0;
      field370 = 2301979;
      field371 = 5063219;
      field372 = 3353893;
      field373 = 7759444;
      field500 = false;
      field501 = 0;
      field419 = 128;
      mapAngle = 0;
      field295 = 0;
      field379 = 0;
      field539 = 0;
      field381 = 0;
      field366 = 50;
      field571 = 0;
      field385 = false;
      field376 = 0;
      field386 = 0;
      field387 = 50;
      field338 = new int[field387];
      field389 = new int[field387];
      field341 = new int[field387];
      field391 = new int[field387];
      field392 = new int[field387];
      field393 = new int[field387];
      field394 = new int[field387];
      field395 = new String[field387];
      field559 = new int[104][104];
      field397 = 0;
      field398 = -1;
      field399 = -1;
      field540 = 0;
      field486 = 0;
      field401 = 0;
      field390 = 0;
      field444 = 0;
      field405 = 0;
      field406 = 0;
      field407 = 0;
      field344 = 0;
      field409 = 0;
      field410 = false;
      field422 = 0;
      field383 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field415 = 0;
      field416 = 0;
      field521 = new int[1000];
      field418 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriority = new boolean[8];
      field421 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field292 = -1;
      groundItemDeque = new Deque[4][104][104];
      field359 = new Deque();
      projectiles = new Deque();
      field426 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field430 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field440 = -1;
      field441 = -1;
      field442 = 0;
      field443 = 50;
      field412 = 0;
      field322 = null;
      field446 = false;
      field447 = -1;
      field448 = -1;
      field449 = null;
      field450 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field493 = 0;
      field454 = 0;
      field455 = null;
      energy = 0;
      weight = 0;
      field458 = 0;
      field459 = -1;
      field460 = false;
      field461 = false;
      field462 = false;
      field463 = null;
      field464 = null;
      field465 = null;
      field466 = 0;
      field467 = 0;
      field468 = null;
      field429 = false;
      field408 = -1;
      field310 = -1;
      field472 = false;
      field576 = -1;
      field474 = -1;
      field475 = false;
      field358 = 1;
      field477 = new int[32];
      field478 = 0;
      interfaceItemTriggers = new int[32];
      field457 = 0;
      field481 = new int[32];
      field482 = 0;
      field357 = 0;
      field484 = 0;
      field485 = 0;
      field427 = 0;
      field487 = 0;
      field488 = 0;
      field380 = 0;
      field417 = new Deque();
      field492 = new Deque();
      field388 = new Deque();
      widgetFlags = new XHashTable(512);
      field404 = 0;
      field496 = -2;
      field497 = new boolean[100];
      field294 = new boolean[100];
      field561 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field504 = 0;
      field557 = 0L;
      isResized = true;
      field355 = 765;
      field508 = 1;
      field403 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field510 = 0;
      field514 = 0;
      field512 = "";
      field513 = new long[100];
      field453 = 0;
      field515 = 0;
      field516 = new int[128];
      field494 = new int[128];
      field396 = -1L;
      field519 = null;
      clanChatOwner = null;
      field369 = -1;
      field331 = 0;
      field523 = new int[1000];
      field524 = new int[1000];
      field525 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field347 = 0;
      field529 = 255;
      field530 = -1;
      field531 = false;
      field532 = 127;
      field551 = 127;
      field505 = 0;
      field565 = new int[50];
      field502 = new int[50];
      field537 = new int[50];
      field538 = new int[50];
      field420 = new class53[50];
      field499 = false;
      field541 = new boolean[5];
      field495 = new int[5];
      field543 = new int[5];
      field544 = new int[5];
      field545 = new int[5];
      field546 = 256;
      field547 = 205;
      field535 = 256;
      field549 = 320;
      field550 = 1;
      field384 = 32767;
      field374 = 1;
      field553 = 32767;
      field378 = 0;
      field555 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field506 = 0;
      friends = new Friend[400];
      field562 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field470 = new PlayerComposition();
      field566 = -1;
      field567 = 1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field569 = -1L;
      field424 = -1L;
      field498 = new class22();
      field572 = new int[50];
      field573 = new int[50];
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "193548262"
   )
   static boolean method382(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-803762306"
   )
   void method383(int var1) {
      class22.field254 = null;
      class36.field773 = null;
      field507 = 0;
      if(class26.field602 == class0.field6) {
         class26.field602 = CombatInfo2.field2843;
      } else {
         class26.field602 = class0.field6;
      }

      ++field326;
      if(field326 < 2 || var1 != 7 && var1 != 9) {
         if(field326 >= 2 && var1 == 6) {
            this.method2063("js5connect_outofdate");
            gameState = 1000;
         } else if(field326 >= 4) {
            if(gameState <= 5) {
               this.method2063("js5connect");
               gameState = 1000;
            } else {
               field323 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2063("js5connect_full");
         gameState = 1000;
      } else {
         field323 = 3000;
      }

   }

   public final void init() {
      if(this.method2052()) {
         class214[] var1 = Sequence.method3612();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class214 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3152);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3152)) {
               case 1:
                  field300 = Integer.parseInt(var4);
                  break;
               case 2:
                  class65.field1107 = Integer.parseInt(var4);
                  break;
               case 3:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 4:
                  field296 = class174.method3150(Integer.parseInt(var4));
                  break;
               case 5:
                  class155.field2116 = var4;
               case 6:
               case 7:
               case 14:
               default:
                  break;
               case 8:
                  flags = Integer.parseInt(var4);
                  break;
               case 9:
                  class103.field1678 = Integer.parseInt(var4);
                  break;
               case 10:
                  class5.field54 = var4;
                  break;
               case 11:
                  class179[] var5 = new class179[]{class179.field2689, class179.field2691, class179.field2696, class179.field2692, class179.field2690, class179.field2693};
                  class183.field2729 = (class179)class72.method1368(var5, Integer.parseInt(var4));
                  if(class179.field2693 == class183.field2729) {
                     class1.field15 = class228.field3235;
                  } else {
                     class1.field15 = class228.field3234;
                  }
                  break;
               case 12:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 13:
                  world = Integer.parseInt(var4);
                  break;
               case 15:
                  field297 = Integer.parseInt(var4);
               }
            }
         }

         class114.method2144();
         class178.host = this.getCodeBase().getHost();
         String var36 = field296.field2685;
         byte var37 = 0;

         try {
            class107.field1728 = 16;
            class170.field2347 = var37;

            try {
               class115.field1812 = System.getProperty("os.name");
            } catch (Exception var32) {
               class115.field1812 = "Unknown";
            }

            class195.field2869 = class115.field1812.toLowerCase();

            try {
               class104.field1692 = System.getProperty("user.home");
               if(class104.field1692 != null) {
                  class104.field1692 = class104.field1692 + "/";
               }
            } catch (Exception var31) {
               ;
            }

            try {
               if(class195.field2869.startsWith("win")) {
                  if(class104.field1692 == null) {
                     class104.field1692 = System.getenv("USERPROFILE");
                  }
               } else if(null == class104.field1692) {
                  class104.field1692 = System.getenv("HOME");
               }

               if(class104.field1692 != null) {
                  class104.field1692 = class104.field1692 + "/";
               }
            } catch (Exception var30) {
               ;
            }

            if(null == class104.field1692) {
               class104.field1692 = "~/";
            }

            ItemLayer.field1210 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class104.field1692, "/tmp/", ""};
            class104.field1690 = new String[]{".jagex_cache_" + class170.field2347, ".file_store_" + class170.field2347};
            int var17 = 0;

            label279:
            while(var17 < 4) {
               String var39 = var17 == 0?"":"" + var17;
               class104.field1685 = new File(class104.field1692, "jagex_cl_oldschool_" + var36 + var39 + ".dat");
               String var6 = null;
               String var7 = null;
               boolean var8 = false;
               Buffer var10;
               int var11;
               int var13;
               File var42;
               if(class104.field1685.exists()) {
                  try {
                     FileOnDisk var9 = new FileOnDisk(class104.field1685, "rw", 10000L);

                     for(var10 = new Buffer((int)var9.method1379()); var10.offset < var10.payload.length; var10.offset += var11) {
                        var11 = var9.method1380(var10.payload, var10.offset, var10.payload.length - var10.offset);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var10.offset = 0;
                     var11 = var10.readUnsignedByte();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var10.readUnsignedByte();
                     }

                     if(var11 <= 2) {
                        var6 = var10.method2852();
                        if(var12 == 1) {
                           var7 = var10.method2852();
                        }
                     } else {
                        var6 = var10.method2785();
                        if(var12 == 1) {
                           var7 = var10.method2785();
                        }
                     }

                     var9.method1378();
                  } catch (IOException var34) {
                     var34.printStackTrace();
                  }

                  if(null != var6) {
                     var42 = new File(var6);
                     if(!var42.exists()) {
                        var6 = null;
                     }
                  }

                  if(null != var6) {
                     var42 = new File(var6, "test.dat");

                     boolean var44;
                     try {
                        RandomAccessFile var18 = new RandomAccessFile(var42, "rw");
                        var13 = var18.read();
                        var18.seek(0L);
                        var18.write(var13);
                        var18.seek(0L);
                        var18.close();
                        var42.delete();
                        var44 = true;
                     } catch (Exception var29) {
                        var44 = false;
                     }

                     if(!var44) {
                        var6 = null;
                     }
                  }
               }

               if(null == var6 && var17 == 0) {
                  label254:
                  for(int var19 = 0; var19 < class104.field1690.length; ++var19) {
                     for(int var20 = 0; var20 < ItemLayer.field1210.length; ++var20) {
                        File var21 = new File(ItemLayer.field1210[var20] + class104.field1690[var19] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var21.exists()) {
                           File var22 = new File(var21, "test.dat");

                           boolean var46;
                           try {
                              RandomAccessFile var14 = new RandomAccessFile(var22, "rw");
                              int var15 = var14.read();
                              var14.seek(0L);
                              var14.write(var15);
                              var14.seek(0L);
                              var14.close();
                              var22.delete();
                              var46 = true;
                           } catch (Exception var28) {
                              var46 = false;
                           }

                           if(var46) {
                              var6 = var21.toString();
                              var8 = true;
                              break label254;
                           }
                        }
                     }
                  }
               }

               if(var6 == null) {
                  var6 = class104.field1692 + File.separatorChar + "jagexcache" + var39 + File.separatorChar + "oldschool" + File.separatorChar + var36 + File.separatorChar;
                  var8 = true;
               }

               File var41;
               if(null != var7) {
                  var41 = new File(var7);
                  var42 = new File(var6);

                  try {
                     File[] var51 = var41.listFiles();
                     File[] var48 = var51;

                     for(var13 = 0; var13 < var48.length; ++var13) {
                        File var47 = var48[var13];
                        File var23 = new File(var42, var47.getName());
                        boolean var16 = var47.renameTo(var23);
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
                  var41 = new File(var6);
                  var10 = null;

                  try {
                     FileOnDisk var52 = new FileOnDisk(class104.field1685, "rw", 10000L);
                     Buffer var49 = new Buffer(500);
                     var49.method2708(3);
                     var49.method2708(null != var10?1:0);
                     var49.method2716(var41.getPath());
                     if(null != var10) {
                        var49.method2716("");
                     }

                     var52.method1396(var49.payload, 0, var49.offset);
                     var52.method1378();
                  } catch (IOException var27) {
                     var27.printStackTrace();
                  }
               }

               File var38 = new File(var6);
               class112.field1766 = var38;
               if(!class112.field1766.exists()) {
                  class112.field1766.mkdirs();
               }

               File[] var40 = class112.field1766.listFiles();
               if(var40 == null) {
                  break;
               }

               File[] var43 = var40;
               int var24 = 0;

               while(true) {
                  if(var24 >= var43.length) {
                     break label279;
                  }

                  File var25 = var43[var24];

                  boolean var50;
                  try {
                     RandomAccessFile var45 = new RandomAccessFile(var25, "rw");
                     var11 = var45.read();
                     var45.seek(0L);
                     var45.write(var11);
                     var45.seek(0L);
                     var45.close();
                     var50 = true;
                  } catch (Exception var26) {
                     var50 = false;
                  }

                  if(!var50) {
                     ++var17;
                     break;
                  }

                  ++var24;
               }
            }

            class94.method1859(class112.field1766);
            GroundObject.method1503();
            class104.field1688 = new class72(new FileOnDisk(Player.method222("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class104.field1682 = new class72(new FileOnDisk(Player.method222("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            FaceNormal.field1560 = new class72[class107.field1728];

            for(var17 = 0; var17 < class107.field1728; ++var17) {
               FaceNormal.field1560[var17] = new class72(new FileOnDisk(Player.method222("main_file_cache.idx" + var17), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var35) {
            NPC.method695((String)null, var35);
         }

         class227.field3230 = this;
         this.method2049(765, 503, 131);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "559281869"
   )
   protected final void vmethod2062() {
      if(chatMessages.method812()) {
         chatMessages.method806();
      }

      if(null != class39.field802) {
         class39.field802.field231 = false;
      }

      class39.field802 = null;
      if(class30.field698 != null) {
         class30.field698.method2006();
         class30.field698 = null;
      }

      if(null != class105.keyboard) {
         class105 var1 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

      if(null != class115.mouse) {
         class115 var9 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

      class184.field2746 = null;
      if(null != GameObject.field1626) {
         GameObject.field1626.method996();
      }

      if(null != class47.field929) {
         class47.field929.method996();
      }

      class38.method721();
      Object var10 = class183.field2732;
      synchronized(class183.field2732) {
         if(class183.field2731 != 0) {
            class183.field2731 = 1;

            try {
               class183.field2732.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      Projectile.method756();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass188;",
      garbageValue = "1107676695"
   )
   public static class188 method446(int var0) {
      class188 var1 = (class188)class188.field2784.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class188.field2786.method3182(19, var0);
         var1 = new class188();
         if(var2 != null) {
            var1.method3344(new Buffer(var2));
         }

         class188.field2784.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)LFloorUnderlayDefinition;",
      garbageValue = "-1068675098"
   )
   public static FloorUnderlayDefinition method474(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2812.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.field2814.method3182(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(null != var2) {
            var1.method3377(new Buffer(var2), var0);
         }

         var1.method3367();
         FloorUnderlayDefinition.field2812.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "654709372"
   )
   void method525() {
      if(class185.field2748 >= 4) {
         this.method2063("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2756 >= 4) {
            if(gameState <= 5) {
               this.method2063("js5io");
               gameState = 1000;
               return;
            }

            field323 = 3000;
            class185.field2756 = 3;
         }

         if(--field323 + 1 <= 0) {
            try {
               if(field507 == 0) {
                  class22.field254 = class22.field252.method1911(class178.host, class26.field602);
                  ++field507;
               }

               if(field507 == 1) {
                  if(class22.field254.field1663 == 2) {
                     this.method383(-1);
                     return;
                  }

                  if(class22.field254.field1663 == 1) {
                     ++field507;
                  }
               }

               if(field507 == 2) {
                  class36.field773 = new class110((Socket)class22.field254.field1666, class22.field252);
                  Buffer var1 = new Buffer(5);
                  var1.method2708(15);
                  var1.method2711(131);
                  class36.field773.method2015(var1.payload, 0, 5);
                  ++field507;
                  class48.field941 = class2.method27();
               }

               if(field507 == 3) {
                  if(gameState > 5 && class36.field773.method2007() <= 0) {
                     if(class2.method27() - class48.field941 > 30000L) {
                        this.method383(-2);
                        return;
                     }
                  } else {
                     int var5 = class36.field773.method2004();
                     if(var5 != 0) {
                        this.method383(var5);
                        return;
                     }

                     ++field507;
                  }
               }

               if(field507 == 4) {
                  class110 var10 = class36.field773;
                  boolean var2 = gameState > 20;
                  if(null != class185.field2755) {
                     try {
                        class185.field2755.method2006();
                     } catch (Exception var8) {
                        ;
                     }

                     class185.field2755 = null;
                  }

                  class185.field2755 = var10;
                  class183.method3266(var2);
                  class185.field2759.offset = 0;
                  class138.field1925 = null;
                  class20.field236 = null;
                  class185.field2767 = 0;

                  while(true) {
                     class181 var3 = (class181)class185.field2752.method2283();
                     if(null == var3) {
                        while(true) {
                           var3 = (class181)class185.field2757.method2283();
                           if(null == var3) {
                              if(class185.field2763 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.method2708(4);
                                    var11.method2708(class185.field2763);
                                    var11.method2709(0);
                                    class185.field2755.method2015(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class185.field2755.method2006();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class185.field2756;
                                    class185.field2755 = null;
                                 }
                              }

                              class185.field2760 = 0;
                              class185.field2749 = class2.method27();
                              class22.field254 = null;
                              class36.field773 = null;
                              field507 = 0;
                              field326 = 0;
                              return;
                           }

                           class185.field2754.method2227(var3);
                           class185.field2765.method2282(var3, var3.hash);
                           ++class185.field2747;
                           --class185.field2758;
                        }
                     }

                     class185.field2750.method2282(var3, var3.hash);
                     ++class185.field2751;
                     --class185.field2753;
                  }
               }
            } catch (IOException var9) {
               this.method383(-3);
            }

         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-82"
   )
   protected final void vmethod2079() {
      class0.field6 = field297 == 0?'ꩊ':world + '鱀';
      CombatInfo2.field2843 = field297 == 0?443:world + '썐';
      class26.field602 = class0.field6;
      ChatLineBuffer.field963 = class167.field2189;
      class116.field1816 = class167.field2192;
      PlayerComposition.field2183 = class167.field2188;
      class38.field793 = class167.field2187;
      if(class103.field1670.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1721[186] = 57;
         class105.field1721[187] = 27;
         class105.field1721[188] = 71;
         class105.field1721[189] = 26;
         class105.field1721[190] = 72;
         class105.field1721[191] = 73;
         class105.field1721[192] = 58;
         class105.field1721[219] = 42;
         class105.field1721[220] = 74;
         class105.field1721[221] = 43;
         class105.field1721[222] = 59;
         class105.field1721[223] = 28;
      } else {
         class105.field1721[44] = 71;
         class105.field1721[45] = 26;
         class105.field1721[46] = 72;
         class105.field1721[47] = 73;
         class105.field1721[59] = 57;
         class105.field1721[61] = 27;
         class105.field1721[91] = 42;
         class105.field1721[92] = 74;
         class105.field1721[93] = 43;
         class105.field1721[192] = 28;
         class105.field1721[222] = 58;
         class105.field1721[520] = 59;
      }

      Canvas var1 = class25.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class105.keyboard);
      var1.addFocusListener(class105.keyboard);
      class139.method2544(class25.canvas);

      class106 var2;
      try {
         var2 = new class106();
      } catch (Throwable var10) {
         var2 = null;
      }

      class184.field2746 = var2;
      if(class184.field2746 != null) {
         class184.field2746.vmethod2041(class25.canvas);
      }

      class110.field1755 = new class116(255, class104.field1688, class104.field1682, 500000);
      FileOnDisk var4 = null;
      class30 var5 = new class30();

      try {
         var4 = class32.method667("", class183.field2729.field2688, false);
         byte[] var6 = new byte[(int)var4.method1379()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.method1380(var6, var7, var6.length - var7);
            if(var8 == -1) {
               throw new IOException();
            }
         }

         var5 = new class30(new Buffer(var6));
      } catch (Exception var11) {
         ;
      }

      try {
         if(var4 != null) {
            var4.method1378();
         }
      } catch (Exception var9) {
         ;
      }

      class38.field794 = var5;
      class88.field1541 = this.getToolkit().getSystemClipboard();
      class6.method81(this, Projectile.field877);
      if(field297 != 0) {
         field309 = true;
      }

      class180.method3175(class38.field794.field696);
   }
}
