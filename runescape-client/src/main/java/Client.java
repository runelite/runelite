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
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -2090181479
   )
   static int field278;
   @ObfuscatedName("l")
   static Client field279;
   @ObfuscatedName("i")
   static boolean field280 = true;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -413049529
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1457495431
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("h")
   static class178 field283;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -242803699
   )
   static int field284;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 1231016255
   )
   static int field285;
   @ObfuscatedName("a")
   static class228 field286;
   @ObfuscatedName("r")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1851651089
   )
   static int field288;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1817750635
   )
   static int field289 = 0;
   @ObfuscatedName("pn")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("fg")
   static int[] field291;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1866606425
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -3679569578008985359L
   )
   static long field293 = -1L;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1173334751
   )
   static int field294 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2095054641
   )
   static int field295 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1916518409
   )
   static int field296 = -1;
   @ObfuscatedName("aj")
   static boolean field297 = true;
   @ObfuscatedName("ab")
   static boolean field298 = false;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -559612375
   )
   static int field299;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1359625713
   )
   static int field300 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -280996689
   )
   static int field301 = 0;
   @ObfuscatedName("hd")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ok")
   static int[] field303;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -2078816399
   )
   static int field304;
   @ObfuscatedName("lh")
   static int[] field305;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -2085327453
   )
   static int field306 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 500377769
   )
   static int field307 = 0;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1606610449
   )
   static int field308;
   @ObfuscatedName("lc")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1978865661
   )
   static int field310;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1221064923
   )
   static int field311 = 0;
   @ObfuscatedName("pp")
   static class130 field312;
   @ObfuscatedName("aq")
   static class184 field313;
   @ObfuscatedName("by")
   static class184 field314;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1271029187
   )
   static int field315 = 0;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 1985984571
   )
   static int field316;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1726545357
   )
   static int field317;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 2127384215
   )
   static int field318;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1490018785
   )
   static int field319;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -334004399
   )
   static int field320;
   @ObfuscatedName("bh")
   static byte[] field321;
   @ObfuscatedName("ck")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1079456083
   )
   static int field323;
   @ObfuscatedName("cs")
   static int[] field324;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1291763691
   )
   static int field325;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -954081321
   )
   static int field326;
   @ObfuscatedName("cb")
   static class159 field327;
   @ObfuscatedName("ji")
   static String field328;
   @ObfuscatedName("cf")
   static class159 field329;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -1478473891
   )
   static int field330;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      longValue = -2462405510671310883L
   )
   static long field331;
   @ObfuscatedName("nn")
   static boolean field332;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 150463361
   )
   static int field333;
   @ObfuscatedName("gd")
   static int[][] field334;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 178302919
   )
   static int field335;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -800153497
   )
   static int field336;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1879352255
   )
   static int field337;
   @ObfuscatedName("cy")
   static boolean field338;
   @ObfuscatedName("mn")
   static long[] field339;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -748627045
   )
   static int field340;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -1325532095
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 762714279
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1446694757
   )
   static int field343;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 478541505
   )
   static int field344;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1558943181
   )
   static int field346 = -1;
   @ObfuscatedName("dt")
   static int[][][] field347;
   @ObfuscatedName("dc")
   static final int[] field348;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -1114647239
   )
   static int field349;
   @ObfuscatedName("jl")
   static String field350;
   @ObfuscatedName("na")
   static class53[] field351;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 1602760293
   )
   static int field352;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 217325043
   )
   static int field353;
   @ObfuscatedName("ii")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 832814357
   )
   static int field355;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1715331953
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 987651759
   )
   static int field357;
   @ObfuscatedName("hi")
   static int[] field358;
   @ObfuscatedName("aa")
   static class40 field359;
   @ObfuscatedName("oe")
   static short field360;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 528702145
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -1428874889
   )
   static int field362;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 684658317
   )
   static int field363;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -843516031
   )
   static int field364;
   @ObfuscatedName("iv")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 819041011
   )
   static int field366;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -1863656677
   )
   static int field367;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 507772549
   )
   static int field368;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -2056196043
   )
   static int field369;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 596780819
   )
   static int field370;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 1087172483
   )
   static int field371;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 292498887
   )
   static int field372;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1951085147
   )
   static int field373;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -1543279451
   )
   static int field374;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 547809899
   )
   static int field375;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -685623245
   )
   static int field376;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 142798537
   )
   static int field377;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 68148267
   )
   static int field378;
   @ObfuscatedName("fd")
   static int[] field380;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -39508627
   )
   static int field381;
   @ObfuscatedName("fc")
   static int[] field382;
   @ObfuscatedName("fo")
   static int[] field383;
   @ObfuscatedName("fe")
   static int[] field384;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -675654929
   )
   static int field385;
   @ObfuscatedName("ln")
   static boolean[] field386;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1153294177
   )
   static int field387 = 0;
   @ObfuscatedName("ct")
   static class159 field388;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -685949789
   )
   static int field389;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 1084467715
   )
   static int field390;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -1756380091
   )
   static int field391;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1217340081
   )
   static int field392;
   @ObfuscatedName("cw")
   static int[] field393;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1009119589
   )
   static int field394;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1282822819
   )
   static int field395;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 1142818105
   )
   static int field396;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -18684703
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -212411169
   )
   static int field398;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -724355169
   )
   static int field399;
   @ObfuscatedName("oa")
   static short field400;
   @ObfuscatedName("nl")
   static boolean field401;
   @ObfuscatedName("ge")
   static boolean field402;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -134643237
   )
   static int field403;
   @ObfuscatedName("z")
   static boolean field404 = false;
   @ObfuscatedName("gc")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -1788739525
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -2042252369
   )
   static int field407;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 972864695
   )
   static int field408;
   @ObfuscatedName("hg")
   static int[] field409;
   @ObfuscatedName("hf")
   static final int[] field410;
   @ObfuscatedName("hs")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("hv")
   @Export("playerOptionsPriority")
   static boolean[] playerOptionsPriority;
   @ObfuscatedName("f")
   static class179 field413;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 941444851
   )
   static int field414;
   @ObfuscatedName("hz")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ar")
   static class40 field416;
   @ObfuscatedName("gj")
   static int[] field417;
   @ObfuscatedName("hu")
   static Deque field418;
   @ObfuscatedName("jy")
   static boolean field419;
   @ObfuscatedName("hq")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("he")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = 617098277
   )
   static int field422;
   @ObfuscatedName("ha")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -1588454363
   )
   static int field424;
   @ObfuscatedName("do")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fq")
   static boolean field426;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      longValue = -2552919257971433059L
   )
   static long field427;
   @ObfuscatedName("ie")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("fs")
   static boolean field429;
   @ObfuscatedName("ic")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("im")
   static boolean field431;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 749588079
   )
   static int field432;
   @ObfuscatedName("ig")
   static boolean field433;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -1362141105
   )
   static int field434;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -588145527
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -345735177
   )
   static int field436;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 120358713
   )
   static int field437;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1439681877
   )
   static int field438;
   @ObfuscatedName("it")
   static String field439;
   @ObfuscatedName("en")
   static SpritePixels[] field440;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 616552467
   )
   static int field441;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 1431835169
   )
   static int field442;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 1853209861
   )
   static int field443;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -1376826251
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -269770731
   )
   static int field445;
   @ObfuscatedName("jo")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -1782133073
   )
   static int field447;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -2039766891
   )
   static int field448;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -897080191
   )
   static int field449;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 403915677
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 1951760249
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 751166779
   )
   static int field452;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -1734390783
   )
   static int field453;
   @ObfuscatedName("jt")
   static boolean field454;
   @ObfuscatedName("je")
   static boolean field455;
   @ObfuscatedName("jr")
   static boolean field456;
   @ObfuscatedName("js")
   static Widget field457;
   @ObfuscatedName("jp")
   static Widget field458;
   @ObfuscatedName("jj")
   static Widget field459;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 41998063
   )
   static int field460;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 1157462655
   )
   static int field461;
   @ObfuscatedName("hc")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("jq")
   static boolean field463;
   @ObfuscatedName("ib")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -384649317
   )
   static int field465;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = 1235054299
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("hn")
   static Deque field467;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -1127452963
   )
   static int field468;
   @ObfuscatedName("kh")
   static boolean field469;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 2132624723
   )
   static int field470;
   @ObfuscatedName("kz")
   static int[] field471;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 136673969
   )
   static int field472;
   @ObfuscatedName("kv")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -393872747
   )
   static int field474;
   @ObfuscatedName("kx")
   static int[] field475;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -1570987511
   )
   static int field476;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -966764195
   )
   static int field477;
   @ObfuscatedName("ou")
   static boolean[] field478;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 1602076489
   )
   static int field479;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -1167784525
   )
   static int field480;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -1982352549
   )
   static int field481;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -1535145125
   )
   static int field482;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -1129265535
   )
   static int field483;
   @ObfuscatedName("kq")
   static Deque field484;
   @ObfuscatedName("kj")
   static Deque field485;
   @ObfuscatedName("la")
   static Deque field486;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -1999644605
   )
   static int field487;
   @ObfuscatedName("gk")
   static String[] field488;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 1747399057
   )
   static int field489;
   @ObfuscatedName("lp")
   static boolean[] field490;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 830614053
   )
   static int field491;
   @ObfuscatedName("ld")
   static boolean[] field492;
   @ObfuscatedName("lk")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("lg")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("lv")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("lj")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -1962295307
   )
   static int field497;
   @ObfuscatedName("lu")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("mv")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -251204599
   )
   static int field500;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 1497022021
   )
   static int field501;
   @ObfuscatedName("lt")
   static String field502;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      longValue = 7951555672192966875L
   )
   static long field503;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1997123589
   )
   static int field504 = 0;
   @ObfuscatedName("oq")
   static short field505;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -1638781131
   )
   static int field506;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -311008845
   )
   static int field507;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 589000457
   )
   static int field508;
   @ObfuscatedName("mj")
   static int[] field509;
   @ObfuscatedName("mp")
   static int[] field510;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      longValue = -3687595318487087937L
   )
   static long field511;
   @ObfuscatedName("mw")
   static String field512;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -1097144169
   )
   static int field513;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 757812119
   )
   static int field514;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = -552853095
   )
   static int field515;
   @ObfuscatedName("me")
   static int[] field516;
   @ObfuscatedName("mm")
   static int[] field517;
   @ObfuscatedName("md")
   static SpritePixels[] field518;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -332216363
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -924065883
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("id")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 694130953
   )
   static int field522;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -141011967
   )
   static int field523;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -752446595
   )
   static int field524;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -1029107145
   )
   static int field525;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 930797349
   )
   static int field526;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = 21739089
   )
   static int field527;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -1544435223
   )
   static int field528;
   @ObfuscatedName("np")
   static int[] field529;
   @ObfuscatedName("nw")
   static int[] field530;
   @ObfuscatedName("nx")
   static int[] field531;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 1439240817
   )
   static int field532;
   @ObfuscatedName("be")
   static class184 field533;
   @ObfuscatedName("ob")
   static int[] field535;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1125804921
   )
   static int field536 = 0;
   @ObfuscatedName("od")
   static int[] field537;
   @ObfuscatedName("ow")
   static int[] field538;
   @ObfuscatedName("of")
   static short field539;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1588821
   )
   static int field540;
   @ObfuscatedName("op")
   static short field541;
   @ObfuscatedName("om")
   static short field542;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1092195407
   )
   static int field543;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -1021015785
   )
   static int field544;
   @ObfuscatedName("gn")
   static int[] field545;
   @ObfuscatedName("jn")
   static Widget field546;
   @ObfuscatedName("c")
   static boolean field547 = true;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 234323131
   )
   static int field548;
   @ObfuscatedName("ih")
   static boolean field549;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = 623157785
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 1009975253
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("no")
   static int[] field552;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = -1635885035
   )
   static int field553;
   @ObfuscatedName("pv")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("oj")
   static short field555;
   @ObfuscatedName("os")
   static short field556;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 1847653455
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 2050934163
   )
   static int field558;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 281607911
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -810490683
   )
   static int field560;
   @ObfuscatedName("pd")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("pw")
   static PlayerComposition field562;
   @ObfuscatedName("jv")
   static Widget field563;
   @ObfuscatedName("ps")
   static final class22 field564;
   @ObfuscatedName("pu")
   static int[] field565;
   @ObfuscatedName("pz")
   static int[] field566;
   @ObfuscatedName("cp")
   static Font field567;
   @ObfuscatedName("nt")
   static class57 field568;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -332280351
   )
   static int field569;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1100979627"
   )
   protected final void vmethod2181() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "741615720"
   )
   protected final void vmethod2174() {
      VertexNormal.field1406 = field295 == 0?'ꩊ':world + '鱀';
      class44.field890 = field295 == 0?443:world + '썐';
      class31.field713 = VertexNormal.field1406;
      SecondaryBufferProvider.field3212 = class167.field2176;
      Friend.field151 = class167.field2172;
      PlayerComposition.field2166 = class167.field2173;
      PlayerComposition.field2167 = class167.field2174;
      if(class103.field1661.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1720[186] = 57;
         class105.field1720[187] = 27;
         class105.field1720[188] = 71;
         class105.field1720[189] = 26;
         class105.field1720[190] = 72;
         class105.field1720[191] = 73;
         class105.field1720[192] = 58;
         class105.field1720[219] = 42;
         class105.field1720[220] = 74;
         class105.field1720[221] = 43;
         class105.field1720[222] = 59;
         class105.field1720[223] = 28;
      } else {
         class105.field1720[44] = 71;
         class105.field1720[45] = 26;
         class105.field1720[46] = 72;
         class105.field1720[47] = 73;
         class105.field1720[59] = 57;
         class105.field1720[61] = 27;
         class105.field1720[91] = 42;
         class105.field1720[92] = 74;
         class105.field1720[93] = 43;
         class105.field1720[192] = 28;
         class105.field1720[222] = 58;
         class105.field1720[520] = 59;
      }

      class162.method3172(class0.canvas);
      Actor.method638(class0.canvas);
      class8.field73 = Varbit.method3628();
      if(class8.field73 != null) {
         class8.field73.vmethod2162(class0.canvas);
      }

      class41.field852 = new class116(255, class104.field1683, class104.field1680, 500000);
      WallObject.field1551 = Script.method956();
      class146.field2014 = this.getToolkit().getSystemClipboard();
      class5.method79(this, XClanMember.field267);
      if(field295 != 0) {
         field298 = true;
      }

      int var1 = WallObject.field1551.field693;
      field427 = 0L;
      if(var1 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      class88.method1938();
      if(gameState >= 25) {
         field327.method3124(166);
         field327.method3010(Actor.method632());
         field327.method2842(class2.field21);
         field327.method2842(class20.field216);
      }

      GameEngine.field1773 = true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1035239250"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method524();

      while(true) {
         Deque var2 = class183.field2730;
         class180 var1;
         synchronized(class183.field2730) {
            var1 = (class180)class183.field2725.method2481();
         }

         if(null == var1) {
            class60.method1206();
            class22.method224();
            Buffer.method3072();
            class115 var8 = class115.mouse;
            synchronized(class115.mouse) {
               class115.field1809 = class115.field1797;
               class115.field1802 = class115.field1795;
               class115.field1801 = class115.field1799;
               class115.field1796 = class115.field1803;
               class115.field1808 = class115.field1804;
               class115.field1798 = class115.field1805;
               class115.field1810 = class115.field1806;
               class115.field1803 = 0;
            }

            if(null != class8.field73) {
               int var5 = class8.field73.vmethod2147();
               field483 = var5;
            }

            if(gameState == 0) {
               class6.method91();
               class49.method970();
            } else if(gameState == 5) {
               class196.method3677(this);
               class6.method91();
               class49.method970();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class196.method3677(this);
                  class137.method2536();
               } else if(gameState == 25) {
                  Friend.method188();
               }
            } else {
               class196.method3677(this);
            }

            if(gameState == 30) {
               class15.method191();
            } else if(gameState == 40 || gameState == 45) {
               class137.method2536();
            }

            return;
         }

         var1.field2694.method3466(var1.field2696, (int)var1.hash, var1.field2695, false);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "130923589"
   )
   protected final void vmethod2177() {
      if(class9.chatMessages.method913()) {
         class9.chatMessages.method910();
      }

      if(null != GameObject.field1621) {
         GameObject.field1621.field208 = false;
      }

      GameObject.field1621 = null;
      if(null != class5.field46) {
         class5.field46.method2109();
         class5.field46 = null;
      }

      class5.method81();
      if(class115.mouse != null) {
         class115 var1 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

      class8.field73 = null;
      if(class3.field30 != null) {
         class3.field30.method1141();
      }

      if(null != field568) {
         field568.method1141();
      }

      class49.method968();
      Object var7 = class183.field2728;
      synchronized(class183.field2728) {
         if(class183.field2727 != 0) {
            class183.field2727 = 1;

            try {
               class183.field2728.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      class152.method2839();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-601787168"
   )
   void method272(int var1) {
      class182.field2719 = null;
      class15.field159 = null;
      field278 = 0;
      if(VertexNormal.field1406 == class31.field713) {
         class31.field713 = class44.field890;
      } else {
         class31.field713 = VertexNormal.field1406;
      }

      ++field437;
      if(field437 < 2 || var1 != 7 && var1 != 9) {
         if(field437 >= 2 && var1 == 6) {
            this.method2178("js5connect_outofdate");
            gameState = 1000;
         } else if(field437 >= 4) {
            if(gameState <= 5) {
               this.method2178("js5connect");
               gameState = 1000;
            } else {
               field335 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2178("js5connect_full");
         gameState = 1000;
      } else {
         field335 = 3000;
      }

   }

   static {
      field359 = class40.field808;
      field416 = class40.field808;
      field366 = 0;
      field278 = 0;
      field335 = 0;
      field437 = 0;
      field317 = 0;
      field318 = 0;
      field319 = 0;
      field320 = 0;
      field321 = null;
      cachedNPCs = new NPC['耀'];
      field323 = 0;
      field324 = new int['耀'];
      field325 = 0;
      field393 = new int[250];
      field327 = new class159(5000);
      field388 = new class159(5000);
      field329 = new class159(15000);
      field330 = 0;
      packetOpcode = 0;
      field385 = 0;
      field333 = 0;
      field540 = 0;
      field288 = 0;
      field310 = 0;
      field337 = 0;
      field338 = false;
      field340 = 0;
      field395 = 1;
      field532 = 0;
      field343 = 1;
      field344 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field347 = new int[4][13][13];
      field348 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field349 = 0;
      field479 = 2;
      field449 = 0;
      field352 = 2;
      field353 = 0;
      field304 = 1;
      field355 = 0;
      mapScale = 0;
      field357 = 2;
      mapScaleDelta = 0;
      field528 = 1;
      field369 = 0;
      field477 = 0;
      field362 = 2301979;
      field363 = 5063219;
      field364 = 3353893;
      field376 = 7759444;
      field429 = false;
      field367 = 0;
      field368 = 128;
      mapAngle = 0;
      field472 = 0;
      field371 = 0;
      field560 = 0;
      field373 = 0;
      field374 = 50;
      field375 = 0;
      field426 = false;
      field377 = 0;
      field445 = 0;
      field372 = 50;
      field380 = new int[field372];
      field291 = new int[field372];
      field382 = new int[field372];
      field383 = new int[field372];
      field384 = new int[field372];
      field417 = new int[field372];
      field545 = new int[field372];
      field488 = new String[field372];
      field334 = new int[104][104];
      field543 = 0;
      field390 = -1;
      field391 = -1;
      field392 = 0;
      field524 = 0;
      field394 = 0;
      field326 = 0;
      field396 = 0;
      field308 = 0;
      field398 = 0;
      field399 = 0;
      field491 = 0;
      field284 = 0;
      field402 = false;
      field403 = 0;
      field336 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field407 = 0;
      field408 = 0;
      field409 = new int[1000];
      field410 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriority = new boolean[8];
      field358 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field414 = -1;
      groundItemDeque = new Deque[4][104][104];
      field467 = new Deque();
      projectiles = new Deque();
      field418 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field422 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field431 = false;
      field432 = -1;
      field433 = false;
      field434 = -1;
      field487 = -1;
      field436 = 0;
      field507 = 50;
      field438 = 0;
      field439 = null;
      field549 = false;
      field441 = -1;
      field442 = -1;
      field328 = null;
      field350 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field447 = 0;
      field448 = 0;
      field546 = null;
      energy = 0;
      weight = 0;
      field370 = 0;
      field453 = -1;
      field454 = false;
      field455 = false;
      field456 = false;
      field457 = null;
      field458 = null;
      field459 = null;
      field460 = 0;
      field461 = 0;
      field563 = null;
      field463 = false;
      field506 = -1;
      field465 = -1;
      field419 = false;
      field424 = -1;
      field468 = -1;
      field469 = false;
      field470 = 1;
      field471 = new int[32];
      field569 = 0;
      interfaceItemTriggers = new int[32];
      field474 = 0;
      field475 = new int[32];
      field476 = 0;
      field443 = 0;
      field285 = 0;
      field513 = 0;
      field480 = 0;
      field481 = 0;
      field482 = 0;
      field483 = 0;
      field484 = new Deque();
      field485 = new Deque();
      field486 = new Deque();
      widgetFlags = new XHashTable(512);
      field544 = 0;
      field489 = -2;
      field490 = new boolean[100];
      field386 = new boolean[100];
      field492 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field497 = 0;
      field427 = 0L;
      isResized = true;
      field500 = 765;
      field501 = 1;
      field305 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field452 = 0;
      field381 = 0;
      field502 = "";
      field339 = new long[100];
      field378 = 0;
      field508 = 0;
      field509 = new int[128];
      field510 = new int[128];
      field511 = -1L;
      field512 = null;
      clanChatOwner = null;
      field514 = -1;
      field515 = 0;
      field516 = new int[1000];
      field517 = new int[1000];
      field518 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field558 = 0;
      field522 = 255;
      field523 = -1;
      field401 = false;
      field525 = 127;
      field526 = 127;
      field527 = 0;
      field552 = new int[50];
      field529 = new int[50];
      field530 = new int[50];
      field531 = new int[50];
      field351 = new class53[50];
      field332 = false;
      field478 = new boolean[5];
      field535 = new int[5];
      field303 = new int[5];
      field537 = new int[5];
      field538 = new int[5];
      field539 = 256;
      field360 = 205;
      field541 = 256;
      field542 = 320;
      field400 = 1;
      field505 = 32767;
      field555 = 1;
      field556 = 32767;
      field316 = 0;
      field548 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field553 = 0;
      friends = new Friend[400];
      field312 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field562 = new PlayerComposition();
      field389 = -1;
      field299 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field331 = -1L;
      field503 = -1L;
      field564 = new class22();
      field565 = new int[50];
      field566 = new int[50];
   }

   public final void init() {
      if(this.method2165()) {
         class214[] var1 = class0.method8();

         int var6;
         int var9;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            class214 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3162);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3162)) {
               case 1:
                  field289 = Integer.parseInt(var4);
               case 2:
               case 6:
               case 14:
               default:
                  break;
               case 3:
                  field295 = Integer.parseInt(var4);
                  break;
               case 4:
                  MessageNode.field226 = var4;
                  break;
               case 5:
                  Frames.field1567 = var4;
                  break;
               case 7:
                  flags = Integer.parseInt(var4);
                  break;
               case 8:
                  class9.field78 = Integer.parseInt(var4);
                  break;
               case 9:
                  class179[] var38 = new class179[]{class179.field2687, class179.field2688, class179.field2686, class179.field2684, class179.field2685, class179.field2693};
                  field413 = (class179)class37.method801(var38, Integer.parseInt(var4));
                  if(class179.field2688 == field413) {
                     field286 = class228.field3252;
                  } else {
                     field286 = class228.field3257;
                  }
                  break;
               case 10:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 11:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 12:
                  var6 = Integer.parseInt(var4);
                  class178[] var7 = new class178[]{class178.field2671, class178.field2674, class178.field2680, class178.field2676};
                  class178[] var8 = var7;
                  var9 = 0;

                  class178 var5;
                  while(true) {
                     if(var9 >= var8.length) {
                        var5 = null;
                        break;
                     }

                     class178 var10 = var8[var9];
                     if(var10.field2678 == var6) {
                        var5 = var10;
                        break;
                     }

                     ++var9;
                  }

                  field283 = var5;
                  break;
               case 13:
                  world = Integer.parseInt(var4);
                  break;
               case 15:
                  class175.field2644 = Integer.parseInt(var4);
               }
            }
         }

         Region.field1481 = false;
         field404 = false;
         class105.host = this.getCodeBase().getHost();
         String var34 = field283.field2675;
         byte var35 = 0;

         try {
            class104.field1679 = 16;
            class105.field1715 = var35;

            try {
               class0.field1 = System.getProperty("os.name");
            } catch (Exception var29) {
               class0.field1 = "Unknown";
            }

            class104.field1685 = class0.field1.toLowerCase();

            try {
               class104.field1686 = System.getProperty("user.home");
               if(null != class104.field1686) {
                  class104.field1686 = class104.field1686 + "/";
               }
            } catch (Exception var28) {
               ;
            }

            try {
               if(class104.field1685.startsWith("win")) {
                  if(class104.field1686 == null) {
                     class104.field1686 = System.getenv("USERPROFILE");
                  }
               } else if(null == class104.field1686) {
                  class104.field1686 = System.getenv("HOME");
               }

               if(null != class104.field1686) {
                  class104.field1686 = class104.field1686 + "/";
               }
            } catch (Exception var27) {
               ;
            }

            if(class104.field1686 == null) {
               class104.field1686 = "~/";
            }

            class167.field2175 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class104.field1686, "/tmp/", ""};
            class119.field1848 = new String[]{".jagex_cache_" + class105.field1715, ".file_store_" + class105.field1715};
            int var17 = 0;

            File var37;
            label280:
            while(var17 < 4) {
               String var39 = var17 == 0?"":"" + var17;
               class104.field1677 = new File(class104.field1686, "jagex_cl_oldschool_" + var34 + var39 + ".dat");
               String var18 = null;
               String var42 = null;
               boolean var19 = false;
               File var46;
               if(class104.field1677.exists()) {
                  try {
                     FileOnDisk var20 = new FileOnDisk(class104.field1677, "rw", 10000L);

                     int var11;
                     Buffer var45;
                     for(var45 = new Buffer((int)var20.method1470()); var45.offset < var45.payload.length; var45.offset += var11) {
                        var11 = var20.method1469(var45.payload, var45.offset, var45.payload.length - var45.offset);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var45.offset = 0;
                     var11 = var45.readUnsignedByte();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var45.readUnsignedByte();
                     }

                     if(var11 <= 2) {
                        var18 = var45.method2865();
                        if(var12 == 1) {
                           var42 = var45.method2865();
                        }
                     } else {
                        var18 = var45.method2866();
                        if(var12 == 1) {
                           var42 = var45.method2866();
                        }
                     }

                     var20.method1471();
                  } catch (IOException var32) {
                     var32.printStackTrace();
                  }

                  if(null != var18) {
                     var46 = new File(var18);
                     if(!var46.exists()) {
                        var18 = null;
                     }
                  }

                  if(null != var18) {
                     var46 = new File(var18, "test.dat");
                     if(!Actor.method640(var46, true)) {
                        var18 = null;
                     }
                  }
               }

               if(var18 == null && var17 == 0) {
                  label256:
                  for(var9 = 0; var9 < class119.field1848.length; ++var9) {
                     for(int var21 = 0; var21 < class167.field2175.length; ++var21) {
                        File var22 = new File(class167.field2175[var21] + class119.field1848[var9] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var22.exists() && Actor.method640(new File(var22, "test.dat"), true)) {
                           var18 = var22.toString();
                           var19 = true;
                           break label256;
                        }
                     }
                  }
               }

               if(var18 == null) {
                  var18 = class104.field1686 + File.separatorChar + "jagexcache" + var39 + File.separatorChar + "oldschool" + File.separatorChar + var34 + File.separatorChar;
                  var19 = true;
               }

               if(var42 != null) {
                  File var47 = new File(var42);
                  var46 = new File(var18);

                  try {
                     File[] var48 = var47.listFiles();
                     File[] var23 = var48;

                     for(int var13 = 0; var13 < var23.length; ++var13) {
                        File var14 = var23[var13];
                        File var15 = new File(var46, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var31) {
                     var31.printStackTrace();
                  }

                  var19 = true;
               }

               if(var19) {
                  XGrandExchangeOffer.method51(new File(var18), (File)null);
               }

               var37 = new File(var18);
               class104.field1678 = var37;
               if(!class104.field1678.exists()) {
                  class104.field1678.mkdirs();
               }

               File[] var40 = class104.field1678.listFiles();
               if(var40 == null) {
                  break;
               }

               File[] var49 = var40;
               int var24 = 0;

               while(true) {
                  if(var24 >= var49.length) {
                     break label280;
                  }

                  File var43 = var49[var24];
                  if(!Actor.method640(var43, false)) {
                     ++var17;
                     break;
                  }

                  ++var24;
               }
            }

            File var36 = class104.field1678;
            class107.field1723 = var36;
            if(!class107.field1723.exists()) {
               throw new RuntimeException("");
            }

            class107.field1722 = true;

            try {
               var37 = new File(class104.field1686, "random.dat");
               if(var37.exists()) {
                  class104.field1681 = new class72(new FileOnDisk(var37, "rw", 25L), 24, 0);
               } else {
                  label209:
                  for(int var25 = 0; var25 < class119.field1848.length; ++var25) {
                     for(var6 = 0; var6 < class167.field2175.length; ++var6) {
                        File var44 = new File(class167.field2175[var6] + class119.field1848[var25] + File.separatorChar + "random.dat");
                        if(var44.exists()) {
                           class104.field1681 = new class72(new FileOnDisk(var44, "rw", 25L), 24, 0);
                           break label209;
                        }
                     }
                  }
               }

               if(class104.field1681 == null) {
                  RandomAccessFile var41 = new RandomAccessFile(var37, "rw");
                  var6 = var41.read();
                  var41.seek(0L);
                  var41.write(var6);
                  var41.seek(0L);
                  var41.close();
                  class104.field1681 = new class72(new FileOnDisk(var37, "rw", 25L), 24, 0);
               }
            } catch (IOException var30) {
               ;
            }

            class104.field1683 = new class72(new FileOnDisk(class88.method1935("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class104.field1680 = new class72(new FileOnDisk(class88.method1935("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class116.field1821 = new class72[class104.field1679];

            for(int var26 = 0; var26 < class104.field1679; ++var26) {
               class116.field1821[var26] = new class72(new FileOnDisk(class88.method1935("main_file_cache.idx" + var26), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var33) {
            FaceNormal.method1950((String)null, var33);
         }

         field279 = this;
         this.method2164(765, 503, 137);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2009460796"
   )
   protected final void vmethod2176() {
      boolean var1;
      label208: {
         try {
            if(class138.field1915 == 2) {
               if(null == class49.field952) {
                  class49.field952 = class144.method2770(class138.field1918, class20.field205, class85.field1446);
                  if(class49.field952 == null) {
                     var1 = false;
                     break label208;
                  }
               }

               if(XGrandExchangeOffer.field41 == null) {
                  XGrandExchangeOffer.field41 = new class60(class138.field1914, class138.field1913);
               }

               if(class39.field800.method2560(class49.field952, class138.field1916, XGrandExchangeOffer.field41, 22050)) {
                  class39.field800.method2573();
                  class39.field800.method2558(FaceNormal.field1561);
                  class39.field800.method2619(class49.field952, class105.field1713);
                  class138.field1915 = 0;
                  class49.field952 = null;
                  XGrandExchangeOffer.field41 = null;
                  class138.field1918 = null;
                  var1 = true;
                  break label208;
               }
            }
         } catch (Exception var12) {
            var12.printStackTrace();
            class39.field800.method2668();
            class138.field1915 = 0;
            class49.field952 = null;
            XGrandExchangeOffer.field41 = null;
            class138.field1918 = null;
         }

         var1 = false;
      }

      if(var1 && field401 && null != class3.field30) {
         class3.field30.method1114();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(field427 != 0L && ChatMessages.method935() > field427) {
            int var3 = Actor.method632();
            field427 = 0L;
            if(var3 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            class88.method1938();
            if(gameState >= 25) {
               field327.method3124(166);
               field327.method3010(Actor.method632());
               field327.method2842(class2.field21);
               field327.method2842(class20.field216);
            }

            GameEngine.field1773 = true;
         } else if(GameEngine.field1776) {
            class9.method121();
         }
      }

      Dimension var8 = this.method2180();
      if(FaceNormal.field1553 != var8.width || class85.field1445 != var8.height || GameEngine.field1775) {
         class88.method1938();
         field427 = ChatMessages.method935() + 500L;
         GameEngine.field1775 = false;
      }

      boolean var4 = false;
      int var5;
      if(GameEngine.field1773) {
         GameEngine.field1773 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field490[var5] = true;
         }
      }

      if(var4) {
         XGrandExchangeOffer.method67();
      }

      if(gameState == 0) {
         ChatLineBuffer.method986(class41.field829, class41.field834, (Color)null, var4);
      } else if(gameState == 5) {
         Ignore.method206(class16.field170, field567, XItemContainer.field119, var4);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            Ignore.method206(class16.field170, field567, XItemContainer.field119, var4);
         } else if(gameState == 25) {
            if(field344 == 1) {
               if(field340 > field395) {
                  field395 = field340;
               }

               var5 = (field395 * 50 - field340 * 50) / field395;
               XGrandExchangeOffer.method65("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field344 == 2) {
               if(field532 > field343) {
                  field343 = field532;
               }

               var5 = (field343 * 50 - field532 * 50) / field343 + 50;
               XGrandExchangeOffer.method65("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               XGrandExchangeOffer.method65("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            class30.method696();
         } else if(gameState == 40) {
            XGrandExchangeOffer.method65("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            XGrandExchangeOffer.method65("Please wait...", false);
         }
      } else {
         Ignore.method206(class16.field170, field567, XItemContainer.field119, var4);
      }

      int var6;
      Graphics var9;
      if(gameState == 30 && field497 == 0 && !var4) {
         try {
            var9 = class0.canvas.getGraphics();

            for(var6 = 0; var6 < field544; ++var6) {
               if(field386[var6]) {
                  class22.bufferProvider.drawSub(var9, widgetPositionX[var6], widgetPositionY[var6], widgetBoundsWidth[var6], widgetBoundsHeight[var6]);
                  field386[var6] = false;
               }
            }
         } catch (Exception var11) {
            class0.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var9 = class0.canvas.getGraphics();
            class22.bufferProvider.draw(var9, 0, 0);

            for(var6 = 0; var6 < field544; ++var6) {
               field386[var6] = false;
            }
         } catch (Exception var10) {
            class0.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-384649317"
   )
   void method524() {
      if(gameState != 1000) {
         long var2 = ChatMessages.method935();
         int var4 = (int)(var2 - class185.field2743);
         class185.field2743 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class185.field2742 += var4;
         boolean var1;
         if(class185.field2752 == 0 && class185.field2747 == 0 && class185.field2750 == 0 && class185.field2755 == 0) {
            var1 = true;
         } else if(null == class185.field2741) {
            var1 = false;
         } else {
            try {
               label239: {
                  if(class185.field2742 > 30000) {
                     throw new IOException();
                  }

                  class181 var5;
                  Buffer var6;
                  while(class185.field2747 < 20 && class185.field2755 > 0) {
                     var5 = (class181)class185.field2745.method2423();
                     var6 = new Buffer(4);
                     var6.method3010(1);
                     var6.method2862((int)var5.hash);
                     class185.field2741.method2114(var6.payload, 0, 4);
                     class185.field2746.method2425(var5, var5.hash);
                     --class185.field2755;
                     ++class185.field2747;
                  }

                  while(class185.field2752 < 20 && class185.field2750 > 0) {
                     var5 = (class181)class185.field2748.method2376();
                     var6 = new Buffer(4);
                     var6.method3010(0);
                     var6.method2862((int)var5.hash);
                     class185.field2741.method2114(var6.payload, 0, 4);
                     var5.method2497();
                     class185.field2756.method2425(var5, var5.hash);
                     --class185.field2750;
                     ++class185.field2752;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class185.field2741.method2131();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class185.field2742 = 0;
                     byte var7 = 0;
                     if(class168.field2181 == null) {
                        var7 = 8;
                     } else if(class185.field2754 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class185.field2753.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class185.field2741.method2113(class185.field2753.payload, class185.field2753.offset, var8);
                        if(class185.field2757 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class185.field2753.payload[class185.field2753.offset + var9] ^= class185.field2757;
                           }
                        }

                        class185.field2753.offset += var8;
                        if(class185.field2753.offset < var7) {
                           break;
                        }

                        if(null == class168.field2181) {
                           class185.field2753.offset = 0;
                           var9 = class185.field2753.readUnsignedByte();
                           var10 = class185.field2753.readUnsignedShort();
                           int var11 = class185.field2753.readUnsignedByte();
                           var12 = class185.field2753.readInt();
                           long var13 = (long)((var9 << 16) + var10);
                           class181 var15 = (class181)class185.field2746.method2428(var13);
                           class172.field2349 = true;
                           if(var15 == null) {
                              var15 = (class181)class185.field2756.method2428(var13);
                              class172.field2349 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class168.field2181 = var15;
                           class9.field83 = new Buffer(class168.field2181.field2702 + var12 + var16);
                           class9.field83.method3010(var11);
                           class9.field83.method2844(var12);
                           class185.field2754 = 8;
                           class185.field2753.offset = 0;
                        } else if(class185.field2754 == 0) {
                           if(class185.field2753.payload[0] == -1) {
                              class185.field2754 = 1;
                              class185.field2753.offset = 0;
                           } else {
                              class168.field2181 = null;
                           }
                        }
                     } else {
                        var8 = class9.field83.payload.length - class168.field2181.field2702;
                        var9 = 512 - class185.field2754;
                        if(var9 > var8 - class9.field83.offset) {
                           var9 = var8 - class9.field83.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class185.field2741.method2113(class9.field83.payload, class9.field83.offset, var9);
                        if(class185.field2757 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class9.field83.payload[var10 + class9.field83.offset] ^= class185.field2757;
                           }
                        }

                        class9.field83.offset += var9;
                        class185.field2754 += var9;
                        if(var8 == class9.field83.offset) {
                           if(16711935L == class168.field2181.hash) {
                              class15.field154 = class9.field83;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class184 var19 = class185.field2749[var10];
                                 if(null != var19) {
                                    class15.field154.offset = 5 + var10 * 8;
                                    var12 = class15.field154.readInt();
                                    int var20 = class15.field154.readInt();
                                    var19.method3437(var12, var20);
                                 }
                              }
                           } else {
                              class185.field2751.reset();
                              class185.field2751.update(class9.field83.payload, 0, var8);
                              var10 = (int)class185.field2751.getValue();
                              if(class168.field2181.field2704 != var10) {
                                 try {
                                    class185.field2741.method2109();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class185.field2758;
                                 class185.field2741 = null;
                                 class185.field2757 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label239;
                              }

                              class185.field2758 = 0;
                              class185.field2759 = 0;
                              class168.field2181.field2703.method3436((int)(class168.field2181.hash & 65535L), class9.field83.payload, 16711680L == (class168.field2181.hash & 16711680L), class172.field2349);
                           }

                           class168.field2181.unlink();
                           if(class172.field2349) {
                              --class185.field2747;
                           } else {
                              --class185.field2752;
                           }

                           class185.field2754 = 0;
                           class168.field2181 = null;
                           class9.field83 = null;
                        } else {
                           if(class185.field2754 != 512) {
                              break;
                           }

                           class185.field2754 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class185.field2741.method2109();
               } catch (Exception var22) {
                  ;
               }

               ++class185.field2759;
               class185.field2741 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method585();
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1847140109"
   )
   void method585() {
      if(class185.field2758 >= 4) {
         this.method2178("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2759 >= 4) {
            if(gameState <= 5) {
               this.method2178("js5io");
               gameState = 1000;
               return;
            }

            field335 = 3000;
            class185.field2759 = 3;
         }

         if(--field335 + 1 <= 0) {
            try {
               if(field278 == 0) {
                  class182.field2719 = class25.field579.method2020(class105.host, class31.field713);
                  ++field278;
               }

               if(field278 == 1) {
                  if(class182.field2719.field1655 == 2) {
                     this.method272(-1);
                     return;
                  }

                  if(class182.field2719.field1655 == 1) {
                     ++field278;
                  }
               }

               if(field278 == 2) {
                  class15.field159 = new class110((Socket)class182.field2719.field1659, class25.field579);
                  Buffer var1 = new Buffer(5);
                  var1.method3010(15);
                  var1.method2844(137);
                  class15.field159.method2114(var1.payload, 0, 5);
                  ++field278;
                  class187.field2771 = ChatMessages.method935();
               }

               if(field278 == 3) {
                  if(gameState > 5 && class15.field159.method2131() <= 0) {
                     if(ChatMessages.method935() - class187.field2771 > 30000L) {
                        this.method272(-2);
                        return;
                     }
                  } else {
                     int var5 = class15.field159.method2133();
                     if(var5 != 0) {
                        this.method272(var5);
                        return;
                     }

                     ++field278;
                  }
               }

               if(field278 == 4) {
                  class110 var10 = class15.field159;
                  boolean var2 = gameState > 20;
                  if(null != class185.field2741) {
                     try {
                        class185.field2741.method2109();
                     } catch (Exception var8) {
                        ;
                     }

                     class185.field2741 = null;
                  }

                  class185.field2741 = var10;
                  class30.method695(var2);
                  class185.field2753.offset = 0;
                  class168.field2181 = null;
                  class9.field83 = null;
                  class185.field2754 = 0;

                  while(true) {
                     class181 var3 = (class181)class185.field2746.method2423();
                     if(var3 == null) {
                        while(true) {
                           var3 = (class181)class185.field2756.method2423();
                           if(null == var3) {
                              if(class185.field2757 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.method3010(4);
                                    var11.method3010(class185.field2757);
                                    var11.method2842(0);
                                    class185.field2741.method2114(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class185.field2741.method2109();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class185.field2759;
                                    class185.field2741 = null;
                                 }
                              }

                              class185.field2742 = 0;
                              class185.field2743 = ChatMessages.method935();
                              class182.field2719 = null;
                              class15.field159 = null;
                              field278 = 0;
                              field437 = 0;
                              return;
                           }

                           class185.field2748.method2365(var3);
                           class185.field2744.method2425(var3, var3.hash);
                           ++class185.field2750;
                           --class185.field2752;
                        }
                     }

                     class185.field2745.method2425(var3, var3.hash);
                     ++class185.field2755;
                     --class185.field2747;
                  }
               }
            } catch (IOException var9) {
               this.method272(-3);
            }

         }
      }
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-2063411008"
   )
   static boolean method611(Widget var0) {
      if(field455) {
         if(class8.method112(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
