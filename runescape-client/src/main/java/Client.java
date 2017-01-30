import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
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
   @ObfuscatedName("fm")
   static int[] field278;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1373940535
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1926894625
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 884680373
   )
   static int field281;
   @ObfuscatedName("c")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("m")
   static boolean field283 = false;
   @ObfuscatedName("cf")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1039919263
   )
   static int field285;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1588425451
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("gx")
   static int[][] field287;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 865765955
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -1554926257203026045L
   )
   static long field289 = -1L;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 760295243
   )
   static int field290 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 374282811
   )
   static int field291 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -794189975
   )
   static int field292 = -1;
   @ObfuscatedName("am")
   static boolean field293 = true;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -318470747
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1683776577
   )
   static int field295 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 484332513
   )
   static int field296 = 0;
   @ObfuscatedName("lf")
   static String field297;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 2114952227
   )
   static int field298;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -2114703647
   )
   static int field299;
   @ObfuscatedName("lk")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 173039939
   )
   static int field301 = 0;
   @ObfuscatedName("ni")
   static class53[] field302;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1287051021
   )
   static int field303;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1834836253
   )
   static int field304;
   @ObfuscatedName("ab")
   static class40 field305;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -357012801
   )
   static int field306;
   @ObfuscatedName("ao")
   static class40 field307;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -101515571
   )
   static int field308;
   @ObfuscatedName("bo")
   static class184 field309;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -693335561
   )
   static int field310;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 52186723
   )
   static int field311;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -38224769
   )
   static int field312;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -66269445
   )
   static int field313;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1561037627
   )
   static int field314;
   @ObfuscatedName("ma")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1195486597
   )
   static int field316;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -738187645
   )
   static int field317;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -1811953459
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("ci")
   static int[] field319;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 406427167
   )
   static int field320;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -2068168555
   )
   static int field321 = 0;
   @ObfuscatedName("cg")
   static class159 field322;
   @ObfuscatedName("ch")
   static class159 field323;
   @ObfuscatedName("ht")
   @Export("playerOptionsPriority")
   static boolean[] playerOptionsPriority;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -885189021
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 464921891
   )
   static int field326;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -436880643
   )
   static int field327;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1525370987
   )
   static int field328;
   @ObfuscatedName("ok")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -1845493503
   )
   static int field330;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1717976111
   )
   static int field331;
   @ObfuscatedName("ca")
   static boolean field332;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -6254187
   )
   static int field333;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = -1502592201
   )
   static int field334;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -129170939
   )
   static int field335;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 1518768555
   )
   static int field336;
   @ObfuscatedName("jr")
   static boolean field337;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("dh")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("dj")
   static int[][][] field340;
   @ObfuscatedName("do")
   static final int[] field341;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 1356151939
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -1815013415
   )
   static int field343;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 1508929299
   )
   static int field344;
   @ObfuscatedName("oq")
   static short field345;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 1058101195
   )
   static int field346;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 543901845
   )
   static int field347;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -599782429
   )
   static int field348;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -1045713867
   )
   static int field349;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 1873113601
   )
   static int field350;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 952063113
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 351296655
   )
   static int field352;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -574290397
   )
   static int field353 = 0;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -597678857
   )
   static int field354;
   @ObfuscatedName("oz")
   static short field355;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 2139622139
   )
   static int field356 = 0;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -1391020765
   )
   static int field357;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -582444161
   )
   static int field358;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1099093317
   )
   static int field359;
   @ObfuscatedName("ez")
   static boolean field360;
   @ObfuscatedName("lm")
   static long[] field361;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1430970677
   )
   static int field362;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -709771947
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 1038510591
   )
   static int field364;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 2144421137
   )
   static int field365;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 1937630661
   )
   static int field366;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 783192053
   )
   static int field367;
   @ObfuscatedName("jp")
   static Widget field368;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 678601261
   )
   static int field369;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -115114607
   )
   static int field370;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1033393913
   )
   static int field371;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -515478855
   )
   static int field372;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 1575503793
   )
   static int field373;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      longValue = 7226030148908097519L
   )
   static long field374;
   @ObfuscatedName("q")
   static boolean field375 = true;
   @ObfuscatedName("fu")
   static int[] field376;
   @ObfuscatedName("fl")
   static int[] field377;
   @ObfuscatedName("ks")
   static Deque field378;
   @ObfuscatedName("fr")
   static int[] field379;
   @ObfuscatedName("fx")
   static int[] field380;
   @ObfuscatedName("gp")
   static String[] field381;
   @ObfuscatedName("og")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -2008839761
   )
   static int field383;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -730594879
   )
   static int field384;
   @ObfuscatedName("v")
   static boolean field385 = true;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 1585976891
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("ho")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1997881287
   )
   static int field388;
   @ObfuscatedName("el")
   static SpritePixels[] field389;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -1994507861
   )
   static int field390;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 458367899
   )
   static int field391;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 1585914991
   )
   static int field392;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -54596193
   )
   static int field393;
   @ObfuscatedName("cb")
   static class159 field394;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 61777419
   )
   static int field395;
   @ObfuscatedName("gf")
   static boolean field396;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1528676015
   )
   static int field397;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 1951749817
   )
   static int field398;
   @ObfuscatedName("gt")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -476764191
   )
   static int field400;
   @ObfuscatedName("fi")
   static int[] field401;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 1599962593
   )
   static int field402;
   @ObfuscatedName("hk")
   static int[] field403;
   @ObfuscatedName("hh")
   static final int[] field404;
   @ObfuscatedName("he")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("id")
   static String field406;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -2016630013
   )
   static int field407 = 0;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -978524401
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("hf")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("hp")
   static Deque field410;
   @ObfuscatedName("hw")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hq")
   static Deque field412;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -1987039337
   )
   static int field413;
   @ObfuscatedName("hl")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("hu")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -1839718633
   )
   static int field416;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1721855943
   )
   static int field417;
   @ObfuscatedName("hn")
   static int[] field418;
   @ObfuscatedName("cq")
   static int[] field419;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -276961441
   )
   static int field420;
   @ObfuscatedName("ir")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("iu")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("is")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2072958135
   )
   static int field424 = 0;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 1868098187
   )
   static int field425;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = 914998645
   )
   static int field426;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 1666463089
   )
   static int field427;
   @ObfuscatedName("ki")
   static int[] field428;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 52782555
   )
   static int field429;
   @ObfuscatedName("jz")
   static Widget field430;
   @ObfuscatedName("it")
   static String field431;
   @ObfuscatedName("il")
   static boolean field432;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -1763073427
   )
   static int field433;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 1493681895
   )
   static int field434;
   @ObfuscatedName("ft")
   static boolean field435;
   @ObfuscatedName("ic")
   static String field436;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -946485863
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("iz")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1566208051
   )
   static int field439 = 0;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -695506817
   )
   static int field440;
   @ObfuscatedName("jh")
   static Widget field441;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 1099724991
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("nv")
   static boolean[] field443;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 928095371
   )
   static int field444;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 276367273
   )
   static int field445;
   @ObfuscatedName("jd")
   static boolean field446;
   @ObfuscatedName("mj")
   static int[] field447;
   @ObfuscatedName("jf")
   static boolean field448;
   @ObfuscatedName("je")
   static Widget field449;
   @ObfuscatedName("oh")
   static short field450;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = -789377423
   )
   static int field451;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 708041931
   )
   static int field452;
   @ObfuscatedName("ia")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jl")
   static Widget field454;
   @ObfuscatedName("hb")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 315844423
   )
   static int field456;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -99864451
   )
   static int field457;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -282993491
   )
   static int field458;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -1834112871
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 413431621
   )
   static int field460;
   @ObfuscatedName("jo")
   static boolean field461;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 729084055
   )
   static int field462;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 873194675
   )
   static int field463;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -1304372399
   )
   static int field464;
   @ObfuscatedName("ku")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -395913651
   )
   static int field466;
   @ObfuscatedName("kw")
   static int[] field467;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -703490935
   )
   static int field468;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -751134171
   )
   static int field469;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -618135393
   )
   static int field470;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 1800393675
   )
   static int field471;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -436011295
   )
   static int field472;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 1738016007
   )
   static int field473;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1713386659
   )
   static int field474;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1454782749
   )
   static int field475;
   @ObfuscatedName("kj")
   static Deque field476;
   @ObfuscatedName("ad")
   static boolean field477 = false;
   @ObfuscatedName("kh")
   static Deque field478;
   @ObfuscatedName("kx")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 184468717
   )
   static int field480;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1425304829
   )
   static int field481;
   @ObfuscatedName("kb")
   static boolean[] field482;
   @ObfuscatedName("lp")
   static boolean[] field483;
   @ObfuscatedName("li")
   static boolean[] field484;
   @ObfuscatedName("lb")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("lg")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 1431662397
   )
   static int field487;
   @ObfuscatedName("ld")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 1822897729
   )
   static int field489;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      longValue = -5352199935282415203L
   )
   static long field490;
   @ObfuscatedName("fj")
   static int[] field491;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 27582993
   )
   static int field492;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = 1655330871
   )
   static int field493;
   @ObfuscatedName("ly")
   static int[] field494;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 56600057
   )
   static int field495;
   @ObfuscatedName("cd")
   static class110 field496;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 1307068913
   )
   static int field497;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1676085401
   )
   static int field498;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -66722569
   )
   static int field499 = 0;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 2043004735
   )
   static int field500;
   @ObfuscatedName("lu")
   static int[] field501;
   @ObfuscatedName("js")
   static boolean field502;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      longValue = -7230999939325187703L
   )
   static long field503;
   @ObfuscatedName("mg")
   static String field504;
   @ObfuscatedName("jm")
   static boolean field505;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 1371373473
   )
   static int field506;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 1209452087
   )
   static int field507;
   @ObfuscatedName("mz")
   static int[] field508;
   @ObfuscatedName("hr")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("ms")
   static SpritePixels[] field510;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 317966067
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = 1853480921
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = -252174329
   )
   static int field513;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = 1463038179
   )
   static int field514;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 508099619
   )
   static int field515;
   @ObfuscatedName("mu")
   static boolean field516;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 1371238533
   )
   static int field517;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -687695659
   )
   static int field518;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 1768279863
   )
   static int field519;
   @ObfuscatedName("nq")
   static int[] field520;
   @ObfuscatedName("nh")
   static int[] field521;
   @ObfuscatedName("nz")
   static int[] field522;
   @ObfuscatedName("nf")
   static int[] field523;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -2081987287
   )
   static int field524;
   @ObfuscatedName("nu")
   static boolean field525;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -468360089
   )
   static int field526;
   @ObfuscatedName("oa")
   static int[] field527;
   @ObfuscatedName("ov")
   static int[] field528;
   @ObfuscatedName("ou")
   static int[] field529;
   @ObfuscatedName("ox")
   static int[] field530;
   @ObfuscatedName("mi")
   static int[] field531;
   @ObfuscatedName("oy")
   static short field532;
   @ObfuscatedName("om")
   static short field533;
   @ObfuscatedName("oo")
   static short field534;
   @ObfuscatedName("of")
   static short field535;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 245162143
   )
   static int field536;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1878548783
   )
   static int field537;
   @ObfuscatedName("on")
   static short field538;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = -810896069
   )
   static int field539;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -2137509457
   )
   static int field540;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -958117139
   )
   static int field541;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 200157113
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("lc")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -505245585
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -2086196457
   )
   static int field545;
   @ObfuscatedName("hi")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("ot")
   static class130 field547;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -278871395
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1475769511
   )
   static int field549 = 0;
   @ObfuscatedName("ob")
   static PlayerComposition field550;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 65980949
   )
   static int field551;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -859852027
   )
   static int field552;
   @ObfuscatedName("pu")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1383955607
   )
   static int field554;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      longValue = 5371903900780178339L
   )
   static long field555;
   @ObfuscatedName("ps")
   static final class22 field556;
   @ObfuscatedName("pz")
   static int[] field557;
   @ObfuscatedName("pq")
   static int[] field558;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "436819917"
   )
   protected final void vmethod2119() {
   }

   public final void init() {
      if(this.method2104()) {
         class214[] var1 = class202.method3784();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class214 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3160);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3160)) {
               case 1:
                  field353 = Integer.parseInt(var4);
                  break;
               case 2:
                  field285 = Integer.parseInt(var4);
                  break;
               case 3:
                  class13.field136 = var4;
               case 4:
               case 7:
               case 9:
               default:
                  break;
               case 5:
                  int var6 = Integer.parseInt(var4);
                  class178[] var7 = FileOnDisk.method1406();
                  int var8 = 0;

                  class178 var5;
                  while(true) {
                     if(var8 >= var7.length) {
                        var5 = null;
                        break;
                     }

                     class178 var9 = var7[var8];
                     if(var9.field2671 == var6) {
                        var5 = var9;
                        break;
                     }

                     ++var8;
                  }

                  class38.field798 = var5;
                  break;
               case 6:
                  flags = Integer.parseInt(var4);
                  break;
               case 8:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 10:
                  class155.field2107 = (class179)TextureProvider.method1454(class6.method96(), Integer.parseInt(var4));
                  if(class179.field2685 == class155.field2107) {
                     FaceNormal.field1561 = class228.field3239;
                  } else {
                     FaceNormal.field1561 = class228.field3233;
                  }
                  break;
               case 11:
                  class146.field2022 = Integer.parseInt(var4);
                  break;
               case 12:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 13:
                  field424 = Integer.parseInt(var4);
                  break;
               case 14:
                  world = Integer.parseInt(var4);
                  break;
               case 15:
                  class47.field927 = var4;
               }
            }
         }

         Region.field1494 = false;
         field283 = false;
         MessageNode.host = this.getCodeBase().getHost();
         String var11 = class38.field798.field2674;
         byte var12 = 0;

         try {
            class33.method680("oldschool", var11, var12, 16);
         } catch (Exception var10) {
            class65.method1151((String)null, var10);
         }

         class88.field1536 = this;
         this.method2102(765, 503, 132);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method259();
      class1.method20();

      int var1;
      try {
         if(class138.field1921 == 1) {
            var1 = class138.field1920.method2548();
            if(var1 > 0 && class138.field1920.method2589()) {
               var1 -= class138.field1926;
               if(var1 < 0) {
                  var1 = 0;
               }

               class138.field1920.method2507(var1);
            } else {
               class138.field1920.method2513();
               class138.field1920.method2511();
               if(null != Item.field887) {
                  class138.field1921 = 2;
               } else {
                  class138.field1921 = 0;
               }

               class114.field1791 = null;
               class26.field587 = null;
            }
         }
      } catch (Exception var64) {
         var64.printStackTrace();
         class138.field1920.method2513();
         class138.field1921 = 0;
         class114.field1791 = null;
         class26.field587 = null;
         Item.field887 = null;
      }

      class85.method1692();
      NPC.method713();
      class115 var47 = class115.mouse;
      synchronized(class115.mouse) {
         class115.field1804 = class115.field1806;
         class115.field1805 = class115.field1802;
         class115.field1814 = class115.field1803;
         class115.field1813 = class115.field1807;
         class115.field1811 = class115.field1801;
         class115.field1812 = class115.field1809;
         class115.field1799 = class115.field1810;
         class115.field1807 = 0;
      }

      if(null != class138.field1917) {
         var1 = class138.field1917.vmethod2087();
         field475 = var1;
      }

      if(gameState == 0) {
         class145.method2746();
         class159.field2127.vmethod2044();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1773[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1778[var1] = 0L;
         }

         class33.field740 = 0;
      } else if(gameState == 5) {
         class2.method28(this);
         class145.method2746();
         class159.field2127.vmethod2044();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1773[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1778[var1] = 0L;
         }

         class33.field740 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class2.method28(this);
            class177.method3250();
         } else if(gameState == 25) {
            CombatInfo1.method602(false);
            field333 = 0;
            boolean var66 = true;

            int var48;
            for(var48 = 0; var48 < class139.field1936.length; ++var48) {
               if(class11.field110[var48] != -1 && class139.field1936[var48] == null) {
                  class139.field1936[var48] = field309.getConfigData(class11.field110[var48], 0);
                  if(class139.field1936[var48] == null) {
                     var66 = false;
                     ++field333;
                  }
               }

               if(Renderable.field1542[var48] != -1 && null == class18.field193[var48]) {
                  class18.field193[var48] = field309.getConfigData(Renderable.field1542[var48], 0, class207.xteaKeys[var48]);
                  if(null == class18.field193[var48]) {
                     var66 = false;
                     ++field333;
                  }
               }
            }

            if(!var66) {
               field349 = 1;
            } else {
               field335 = 0;
               var66 = true;

               int var4;
               int var5;
               Buffer var9;
               int var10;
               int var11;
               int var12;
               int var14;
               int var15;
               int var16;
               int var17;
               int var18;
               int var19;
               for(var48 = 0; var48 < class139.field1936.length; ++var48) {
                  byte[] var3 = class18.field193[var48];
                  if(var3 != null) {
                     var4 = (ItemLayer.mapRegions[var48] >> 8) * 64 - Projectile.baseX;
                     var5 = (ItemLayer.mapRegions[var48] & 255) * 64 - class3.baseY;
                     if(isDynamicRegion) {
                        var4 = 10;
                        var5 = 10;
                     }

                     boolean var8 = true;
                     var9 = new Buffer(var3);
                     var10 = -1;

                     label1352:
                     while(true) {
                        var11 = var9.method2979();
                        if(var11 == 0) {
                           var66 &= var8;
                           break;
                        }

                        var10 += var11;
                        var12 = 0;
                        boolean var13 = false;

                        while(true) {
                           while(!var13) {
                              var14 = var9.method2979();
                              if(var14 == 0) {
                                 continue label1352;
                              }

                              var12 += var14 - 1;
                              var15 = var12 & 63;
                              var16 = var12 >> 6 & 63;
                              var17 = var9.readUnsignedByte() >> 2;
                              var18 = var4 + var16;
                              var19 = var15 + var5;
                              if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                 ObjectComposition var20 = class217.getObjectDefinition(var10);
                                 if(var17 != 22 || !field283 || var20.field2908 != 0 || var20.field2906 == 1 || var20.field2927) {
                                    if(!var20.method3599()) {
                                       ++field335;
                                       var8 = false;
                                    }

                                    var13 = true;
                                 }
                              }
                           }

                           var14 = var9.method2979();
                           if(var14 == 0) {
                              break;
                           }

                           var9.readUnsignedByte();
                        }
                     }
                  }
               }

               if(!var66) {
                  field349 = 2;
               } else {
                  if(field349 != 0) {
                     Tile.method1549("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class85.method1692();
                  class63.method1132();
                  class85.method1692();
                  Renderable.region.method1796();
                  class85.method1692();
                  System.gc();

                  for(var48 = 0; var48 < 4; ++var48) {
                     collisionMaps[var48].method2264();
                  }

                  int var49;
                  for(var48 = 0; var48 < 4; ++var48) {
                     for(var49 = 0; var49 < 104; ++var49) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           class10.tileSettings[var48][var49][var4] = 0;
                        }
                     }
                  }

                  class85.method1692();
                  class10.field87 = 99;
                  class10.underlayIds = new byte[4][104][104];
                  class10.overlayIds = new byte[4][104][104];
                  class40.overlayPaths = new byte[4][104][104];
                  class60.overlayRotations = new byte[4][104][104];
                  class137.field1909 = new int[4][105][105];
                  class47.field931 = new byte[4][105][105];
                  class10.field100 = new int[105][105];
                  class189.field2782 = new int[104];
                  class165.field2163 = new int[104];
                  CombatInfoListHolder.field747 = new int[104];
                  NPC.field759 = new int[104];
                  class26.field581 = new int[104];
                  var48 = class139.field1936.length;
                  ItemComposition.method3701();
                  CombatInfo1.method602(true);
                  int var6;
                  int var21;
                  int var22;
                  int var54;
                  int var69;
                  if(!isDynamicRegion) {
                     byte[] var50;
                     for(var49 = 0; var49 < var48; ++var49) {
                        var4 = 64 * (ItemLayer.mapRegions[var49] >> 8) - Projectile.baseX;
                        var5 = (ItemLayer.mapRegions[var49] & 255) * 64 - class3.baseY;
                        var50 = class139.field1936[var49];
                        if(null != var50) {
                           class85.method1692();
                           class20.method198(var50, var4, var5, Spotanim.field2802 * 8 - 48, class156.field2112 * 8 - 48, collisionMaps);
                        }
                     }

                     for(var49 = 0; var49 < var48; ++var49) {
                        var4 = (ItemLayer.mapRegions[var49] >> 8) * 64 - Projectile.baseX;
                        var5 = 64 * (ItemLayer.mapRegions[var49] & 255) - class3.baseY;
                        var50 = class139.field1936[var49];
                        if(null == var50 && class156.field2112 < 800) {
                           class85.method1692();
                           class177.method3245(var4, var5, 64, 64);
                        }
                     }

                     CombatInfo1.method602(true);

                     for(var49 = 0; var49 < var48; ++var49) {
                        byte[] var51 = class18.field193[var49];
                        if(null != var51) {
                           var5 = (ItemLayer.mapRegions[var49] >> 8) * 64 - Projectile.baseX;
                           var6 = 64 * (ItemLayer.mapRegions[var49] & 255) - class3.baseY;
                           class85.method1692();
                           Region var52 = Renderable.region;
                           CollisionData[] var53 = collisionMaps;
                           var9 = new Buffer(var51);
                           var10 = -1;

                           while(true) {
                              var11 = var9.method2979();
                              if(var11 == 0) {
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;

                              while(true) {
                                 var69 = var9.method2979();
                                 if(var69 == 0) {
                                    break;
                                 }

                                 var12 += var69 - 1;
                                 var14 = var12 & 63;
                                 var15 = var12 >> 6 & 63;
                                 var16 = var12 >> 12;
                                 var17 = var9.readUnsignedByte();
                                 var18 = var17 >> 2;
                                 var19 = var17 & 3;
                                 var54 = var15 + var5;
                                 var21 = var6 + var14;
                                 if(var54 > 0 && var21 > 0 && var54 < 103 && var21 < 103) {
                                    var22 = var16;
                                    if((class10.tileSettings[1][var54][var21] & 2) == 2) {
                                       var22 = var16 - 1;
                                    }

                                    CollisionData var23 = null;
                                    if(var22 >= 0) {
                                       var23 = var53[var22];
                                    }

                                    class9.method118(var16, var54, var21, var10, var19, var18, var52, var23);
                                 }
                              }
                           }
                        }
                     }
                  }

                  int var7;
                  int var55;
                  int var68;
                  if(isDynamicRegion) {
                     var49 = 0;

                     label1257:
                     while(true) {
                        if(var49 >= 4) {
                           for(var49 = 0; var49 < 13; ++var49) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = field340[0][var49][var4];
                                 if(var5 == -1) {
                                    class177.method3245(var49 * 8, 8 * var4, 8, 8);
                                 }
                              }
                           }

                           CombatInfo1.method602(true);
                           var49 = 0;

                           while(true) {
                              if(var49 >= 4) {
                                 break label1257;
                              }

                              class85.method1692();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var6 = field340[var49][var4][var5];
                                    if(var6 != -1) {
                                       var7 = var6 >> 24 & 3;
                                       var68 = var6 >> 1 & 3;
                                       var55 = var6 >> 14 & 1023;
                                       var10 = var6 >> 3 & 2047;
                                       var11 = var10 / 8 + (var55 / 8 << 8);

                                       for(var12 = 0; var12 < ItemLayer.mapRegions.length; ++var12) {
                                          if(ItemLayer.mapRegions[var12] == var11 && class18.field193[var12] != null) {
                                             class176.method3243(class18.field193[var12], var49, var4 * 8, 8 * var5, var7, (var55 & 7) * 8, (var10 & 7) * 8, var68, Renderable.region, collisionMaps);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var49;
                           }
                        }

                        class85.method1692();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var67 = false;
                              var7 = field340[var49][var4][var5];
                              if(var7 != -1) {
                                 var68 = var7 >> 24 & 3;
                                 var55 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(var69 = 0; var69 < ItemLayer.mapRegions.length; ++var69) {
                                    if(var12 == ItemLayer.mapRegions[var69] && null != class139.field1936[var69]) {
                                       CombatInfo2.method3522(class139.field1936[var69], var49, 8 * var4, var5 * 8, var68, 8 * (var10 & 7), (var11 & 7) * 8, var55, collisionMaps);
                                       var67 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var67) {
                                 var68 = var49;
                                 var55 = 8 * var4;
                                 var10 = 8 * var5;

                                 for(var11 = 0; var11 < 8; ++var11) {
                                    for(var12 = 0; var12 < 8; ++var12) {
                                       class10.tileHeights[var68][var11 + var55][var10 + var12] = 0;
                                    }
                                 }

                                 if(var55 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class10.tileHeights[var68][var55][var11 + var10] = class10.tileHeights[var68][var55 - 1][var11 + var10];
                                    }
                                 }

                                 if(var10 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class10.tileHeights[var68][var11 + var55][var10] = class10.tileHeights[var68][var11 + var55][var10 - 1];
                                    }
                                 }

                                 if(var55 > 0 && class10.tileHeights[var68][var55 - 1][var10] != 0) {
                                    class10.tileHeights[var68][var55][var10] = class10.tileHeights[var68][var55 - 1][var10];
                                 } else if(var10 > 0 && class10.tileHeights[var68][var55][var10 - 1] != 0) {
                                    class10.tileHeights[var68][var55][var10] = class10.tileHeights[var68][var55][var10 - 1];
                                 } else if(var55 > 0 && var10 > 0 && class10.tileHeights[var68][var55 - 1][var10 - 1] != 0) {
                                    class10.tileHeights[var68][var55][var10] = class10.tileHeights[var68][var55 - 1][var10 - 1];
                                 }
                              }
                           }
                        }

                        ++var49;
                     }
                  }

                  CombatInfo1.method602(true);
                  class63.method1132();
                  class85.method1692();
                  Region var65 = Renderable.region;
                  CollisionData[] var75 = collisionMaps;

                  for(var5 = 0; var5 < 4; ++var5) {
                     for(var6 = 0; var6 < 104; ++var6) {
                        for(var7 = 0; var7 < 104; ++var7) {
                           if((class10.tileSettings[var5][var6][var7] & 1) == 1) {
                              var68 = var5;
                              if((class10.tileSettings[1][var6][var7] & 2) == 2) {
                                 var68 = var5 - 1;
                              }

                              if(var68 >= 0) {
                                 var75[var68].method2256(var6, var7);
                              }
                           }
                        }
                     }
                  }

                  class10.field97 += (int)(Math.random() * 5.0D) - 2;
                  if(class10.field97 < -8) {
                     class10.field97 = -8;
                  }

                  if(class10.field97 > 8) {
                     class10.field97 = 8;
                  }

                  class10.field90 += (int)(Math.random() * 5.0D) - 2;
                  if(class10.field90 < -16) {
                     class10.field90 = -16;
                  }

                  if(class10.field90 > 16) {
                     class10.field90 = 16;
                  }

                  for(var5 = 0; var5 < 4; ++var5) {
                     byte[][] var73 = class47.field931[var5];
                     var12 = (int)Math.sqrt(5100.0D);
                     var69 = var12 * 768 >> 8;

                     int var56;
                     for(var14 = 1; var14 < 103; ++var14) {
                        for(var15 = 1; var15 < 103; ++var15) {
                           var16 = class10.tileHeights[var5][var15 + 1][var14] - class10.tileHeights[var5][var15 - 1][var14];
                           var17 = class10.tileHeights[var5][var15][1 + var14] - class10.tileHeights[var5][var15][var14 - 1];
                           var18 = (int)Math.sqrt((double)(var17 * var17 + 65536 + var16 * var16));
                           var19 = (var16 << 8) / var18;
                           var54 = 65536 / var18;
                           var21 = (var17 << 8) / var18;
                           var22 = (-10 * var54 + -50 * var19 + -50 * var21) / var69 + 96;
                           var56 = (var73[var15][var14] >> 1) + (var73[var15][1 + var14] >> 3) + (var73[var15 - 1][var14] >> 2) + (var73[var15 + 1][var14] >> 3) + (var73[var15][var14 - 1] >> 2);
                           class10.field100[var15][var14] = var22 - var56;
                        }
                     }

                     for(var14 = 0; var14 < 104; ++var14) {
                        class189.field2782[var14] = 0;
                        class165.field2163[var14] = 0;
                        CombatInfoListHolder.field747[var14] = 0;
                        NPC.field759[var14] = 0;
                        class26.field581[var14] = 0;
                     }

                     for(var14 = -5; var14 < 109; ++var14) {
                        for(var15 = 0; var15 < 104; ++var15) {
                           var16 = var14 + 5;
                           if(var16 >= 0 && var16 < 104) {
                              var17 = class10.underlayIds[var5][var16][var15] & 255;
                              if(var17 > 0) {
                                 FloorUnderlayDefinition var57 = class103.method1953(var17 - 1);
                                 class189.field2782[var15] += var57.field2808;
                                 class165.field2163[var15] += var57.field2809;
                                 CombatInfoListHolder.field747[var15] += var57.field2805;
                                 NPC.field759[var15] += var57.field2812;
                                 ++class26.field581[var15];
                              }
                           }

                           var17 = var14 - 5;
                           if(var17 >= 0 && var17 < 104) {
                              var18 = class10.underlayIds[var5][var17][var15] & 255;
                              if(var18 > 0) {
                                 FloorUnderlayDefinition var58 = class103.method1953(var18 - 1);
                                 class189.field2782[var15] -= var58.field2808;
                                 class165.field2163[var15] -= var58.field2809;
                                 CombatInfoListHolder.field747[var15] -= var58.field2805;
                                 NPC.field759[var15] -= var58.field2812;
                                 --class26.field581[var15];
                              }
                           }
                        }

                        if(var14 >= 1 && var14 < 103) {
                           var15 = 0;
                           var16 = 0;
                           var17 = 0;
                           var18 = 0;
                           var19 = 0;

                           for(var54 = -5; var54 < 109; ++var54) {
                              var21 = 5 + var54;
                              if(var21 >= 0 && var21 < 104) {
                                 var15 += class189.field2782[var21];
                                 var16 += class165.field2163[var21];
                                 var17 += CombatInfoListHolder.field747[var21];
                                 var18 += NPC.field759[var21];
                                 var19 += class26.field581[var21];
                              }

                              var22 = var54 - 5;
                              if(var22 >= 0 && var22 < 104) {
                                 var15 -= class189.field2782[var22];
                                 var16 -= class165.field2163[var22];
                                 var17 -= CombatInfoListHolder.field747[var22];
                                 var18 -= NPC.field759[var22];
                                 var19 -= class26.field581[var22];
                              }

                              if(var54 >= 1 && var54 < 103 && (!field283 || (class10.tileSettings[0][var14][var54] & 2) != 0 || (class10.tileSettings[var5][var14][var54] & 16) == 0)) {
                                 if(var5 < class10.field87) {
                                    class10.field87 = var5;
                                 }

                                 var56 = class10.underlayIds[var5][var14][var54] & 255;
                                 int var24 = class10.overlayIds[var5][var14][var54] & 255;
                                 if(var56 > 0 || var24 > 0) {
                                    int var25 = class10.tileHeights[var5][var14][var54];
                                    int var26 = class10.tileHeights[var5][var14 + 1][var54];
                                    int var27 = class10.tileHeights[var5][var14 + 1][1 + var54];
                                    int var28 = class10.tileHeights[var5][var14][var54 + 1];
                                    int var29 = class10.field100[var14][var54];
                                    int var30 = class10.field100[var14 + 1][var54];
                                    int var31 = class10.field100[var14 + 1][var54 + 1];
                                    int var32 = class10.field100[var14][1 + var54];
                                    int var33 = -1;
                                    int var34 = -1;
                                    int var35;
                                    int var36;
                                    int var37;
                                    if(var56 > 0) {
                                       var35 = var15 * 256 / var18;
                                       var36 = var16 / var19;
                                       var37 = var17 / var19;
                                       var33 = Friend.method180(var35, var36, var37);
                                       var35 = class10.field97 + var35 & 255;
                                       var37 += class10.field90;
                                       if(var37 < 0) {
                                          var37 = 0;
                                       } else if(var37 > 255) {
                                          var37 = 255;
                                       }

                                       var34 = Friend.method180(var35, var36, var37);
                                    }

                                    Overlay var38;
                                    if(var5 > 0) {
                                       boolean var71 = true;
                                       if(var56 == 0 && class40.overlayPaths[var5][var14][var54] != 0) {
                                          var71 = false;
                                       }

                                       if(var24 > 0) {
                                          var37 = var24 - 1;
                                          var38 = (Overlay)Overlay.field3030.get((long)var37);
                                          Overlay var59;
                                          if(null != var38) {
                                             var59 = var38;
                                          } else {
                                             byte[] var39 = Overlay.field3037.getConfigData(4, var37);
                                             var38 = new Overlay();
                                             if(var39 != null) {
                                                var38.method3734(new Buffer(var39), var37);
                                             }

                                             var38.method3742();
                                             Overlay.field3030.put(var38, (long)var37);
                                             var59 = var38;
                                          }

                                          if(!var59.isHidden) {
                                             var71 = false;
                                          }
                                       }

                                       if(var71 && var25 == var26 && var27 == var25 && var28 == var25) {
                                          class137.field1909[var5][var14][var54] |= 2340;
                                       }
                                    }

                                    var35 = 0;
                                    if(var34 != -1) {
                                       var35 = class84.colorPalette[XItemContainer.method168(var34, 96)];
                                    }

                                    if(var24 == 0) {
                                       var65.method1704(var5, var14, var54, 0, 0, -1, var25, var26, var27, var28, XItemContainer.method168(var33, var29), XItemContainer.method168(var33, var30), XItemContainer.method168(var33, var31), XItemContainer.method168(var33, var32), 0, 0, 0, 0, var35, 0);
                                    } else {
                                       var36 = 1 + class40.overlayPaths[var5][var14][var54];
                                       byte var72 = class60.overlayRotations[var5][var14][var54];
                                       int var60 = var24 - 1;
                                       Overlay var40 = (Overlay)Overlay.field3030.get((long)var60);
                                       if(var40 != null) {
                                          var38 = var40;
                                       } else {
                                          byte[] var41 = Overlay.field3037.getConfigData(4, var60);
                                          var40 = new Overlay();
                                          if(null != var41) {
                                             var40.method3734(new Buffer(var41), var60);
                                          }

                                          var40.method3742();
                                          Overlay.field3030.put(var40, (long)var60);
                                          var38 = var40;
                                       }

                                       int var61 = var38.texture;
                                       int var42;
                                       int var43;
                                       int var44;
                                       int var45;
                                       if(var61 >= 0) {
                                          var43 = class84.field1448.vmethod1900(var61);
                                          var42 = -1;
                                       } else if(var38.color == 16711935) {
                                          var42 = -2;
                                          var61 = -1;
                                          var43 = -2;
                                       } else {
                                          var42 = Friend.method180(var38.hue, var38.saturation, var38.lightness);
                                          var44 = class10.field97 + var38.hue & 255;
                                          var45 = var38.lightness + class10.field90;
                                          if(var45 < 0) {
                                             var45 = 0;
                                          } else if(var45 > 255) {
                                             var45 = 255;
                                          }

                                          var43 = Friend.method180(var44, var38.saturation, var45);
                                       }

                                       var44 = 0;
                                       if(var43 != -2) {
                                          var44 = class84.colorPalette[PlayerComposition.method3146(var43, 96)];
                                       }

                                       if(var38.field3035 != -1) {
                                          var45 = var38.field3039 + class10.field97 & 255;
                                          int var46 = class10.field90 + var38.field3041;
                                          if(var46 < 0) {
                                             var46 = 0;
                                          } else if(var46 > 255) {
                                             var46 = 255;
                                          }

                                          var43 = Friend.method180(var45, var38.field3040, var46);
                                          var44 = class84.colorPalette[PlayerComposition.method3146(var43, 96)];
                                       }

                                       var65.method1704(var5, var14, var54, var36, var72, var61, var25, var26, var27, var28, XItemContainer.method168(var33, var29), XItemContainer.method168(var33, var30), XItemContainer.method168(var33, var31), XItemContainer.method168(var33, var32), PlayerComposition.method3146(var42, var29), PlayerComposition.method3146(var42, var30), PlayerComposition.method3146(var42, var31), PlayerComposition.method3146(var42, var32), var35, var44);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     for(var14 = 1; var14 < 103; ++var14) {
                        for(var15 = 1; var15 < 103; ++var15) {
                           if((class10.tileSettings[var5][var15][var14] & 8) != 0) {
                              var54 = 0;
                           } else if(var5 > 0 && (class10.tileSettings[1][var15][var14] & 2) != 0) {
                              var54 = var5 - 1;
                           } else {
                              var54 = var5;
                           }

                           var65.method1703(var5, var15, var14, var54);
                        }
                     }

                     class10.underlayIds[var5] = null;
                     class10.overlayIds[var5] = null;
                     class40.overlayPaths[var5] = null;
                     class60.overlayRotations[var5] = null;
                     class47.field931[var5] = null;
                  }

                  var65.method1730(-50, -10, -50);

                  for(var5 = 0; var5 < 104; ++var5) {
                     for(var6 = 0; var6 < 104; ++var6) {
                        if((class10.tileSettings[1][var5][var6] & 2) == 2) {
                           var65.method1701(var5, var6);
                        }
                     }
                  }

                  var5 = 1;
                  var6 = 2;
                  var7 = 4;

                  for(var68 = 0; var68 < 4; ++var68) {
                     if(var68 > 0) {
                        var5 <<= 3;
                        var6 <<= 3;
                        var7 <<= 3;
                     }

                     for(var55 = 0; var55 <= var68; ++var55) {
                        for(var10 = 0; var10 <= 104; ++var10) {
                           for(var11 = 0; var11 <= 104; ++var11) {
                              short var70;
                              if((class137.field1909[var55][var11][var10] & var5) != 0) {
                                 var12 = var10;
                                 var69 = var10;
                                 var14 = var55;

                                 for(var15 = var55; var12 > 0 && (class137.field1909[var55][var11][var12 - 1] & var5) != 0; --var12) {
                                    ;
                                 }

                                 while(var69 < 104 && (class137.field1909[var55][var11][1 + var69] & var5) != 0) {
                                    ++var69;
                                 }

                                 label908:
                                 while(var14 > 0) {
                                    for(var16 = var12; var16 <= var69; ++var16) {
                                       if((class137.field1909[var14 - 1][var11][var16] & var5) == 0) {
                                          break label908;
                                       }
                                    }

                                    --var14;
                                 }

                                 label897:
                                 while(var15 < var68) {
                                    for(var16 = var12; var16 <= var69; ++var16) {
                                       if((class137.field1909[1 + var15][var11][var16] & var5) == 0) {
                                          break label897;
                                       }
                                    }

                                    ++var15;
                                 }

                                 var16 = (var69 - var12 + 1) * (1 + var15 - var14);
                                 if(var16 >= 8) {
                                    var70 = 240;
                                    var18 = class10.tileHeights[var15][var11][var12] - var70;
                                    var19 = class10.tileHeights[var14][var11][var12];
                                    Region.method1702(var68, 1, 128 * var11, 128 * var11, var12 * 128, 128 + var69 * 128, var18, var19);

                                    for(var54 = var14; var54 <= var15; ++var54) {
                                       for(var21 = var12; var21 <= var69; ++var21) {
                                          class137.field1909[var54][var11][var21] &= ~var5;
                                       }
                                    }
                                 }
                              }

                              if((class137.field1909[var55][var11][var10] & var6) != 0) {
                                 var12 = var11;
                                 var69 = var11;
                                 var14 = var55;

                                 for(var15 = var55; var12 > 0 && (class137.field1909[var55][var12 - 1][var10] & var6) != 0; --var12) {
                                    ;
                                 }

                                 while(var69 < 104 && (class137.field1909[var55][1 + var69][var10] & var6) != 0) {
                                    ++var69;
                                 }

                                 label961:
                                 while(var14 > 0) {
                                    for(var16 = var12; var16 <= var69; ++var16) {
                                       if((class137.field1909[var14 - 1][var16][var10] & var6) == 0) {
                                          break label961;
                                       }
                                    }

                                    --var14;
                                 }

                                 label950:
                                 while(var15 < var68) {
                                    for(var16 = var12; var16 <= var69; ++var16) {
                                       if((class137.field1909[1 + var15][var16][var10] & var6) == 0) {
                                          break label950;
                                       }
                                    }

                                    ++var15;
                                 }

                                 var16 = (var15 + 1 - var14) * (1 + (var69 - var12));
                                 if(var16 >= 8) {
                                    var70 = 240;
                                    var18 = class10.tileHeights[var15][var12][var10] - var70;
                                    var19 = class10.tileHeights[var14][var12][var10];
                                    Region.method1702(var68, 2, var12 * 128, 128 + var69 * 128, var10 * 128, var10 * 128, var18, var19);

                                    for(var54 = var14; var54 <= var15; ++var54) {
                                       for(var21 = var12; var21 <= var69; ++var21) {
                                          class137.field1909[var54][var21][var10] &= ~var6;
                                       }
                                    }
                                 }
                              }

                              if((class137.field1909[var55][var11][var10] & var7) != 0) {
                                 var12 = var11;
                                 var69 = var11;
                                 var14 = var10;

                                 for(var15 = var10; var14 > 0 && (class137.field1909[var55][var11][var14 - 1] & var7) != 0; --var14) {
                                    ;
                                 }

                                 while(var15 < 104 && (class137.field1909[var55][var11][1 + var15] & var7) != 0) {
                                    ++var15;
                                 }

                                 label1014:
                                 while(var12 > 0) {
                                    for(var16 = var14; var16 <= var15; ++var16) {
                                       if((class137.field1909[var55][var12 - 1][var16] & var7) == 0) {
                                          break label1014;
                                       }
                                    }

                                    --var12;
                                 }

                                 label1003:
                                 while(var69 < 104) {
                                    for(var16 = var14; var16 <= var15; ++var16) {
                                       if((class137.field1909[var55][1 + var69][var16] & var7) == 0) {
                                          break label1003;
                                       }
                                    }

                                    ++var69;
                                 }

                                 if((var69 - var12 + 1) * (1 + (var15 - var14)) >= 4) {
                                    var16 = class10.tileHeights[var55][var12][var14];
                                    Region.method1702(var68, 4, 128 * var12, var69 * 128 + 128, 128 * var14, 128 + var15 * 128, var16, var16);

                                    for(var17 = var12; var17 <= var69; ++var17) {
                                       for(var18 = var14; var18 <= var15; ++var18) {
                                          class137.field1909[var55][var17][var18] &= ~var7;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  CombatInfo1.method602(true);
                  var5 = class10.field87;
                  if(var5 > WallObject.plane) {
                     var5 = WallObject.plane;
                  }

                  if(var5 < WallObject.plane - 1) {
                     var5 = WallObject.plane - 1;
                  }

                  if(field283) {
                     Renderable.region.method1854(class10.field87);
                  } else {
                     Renderable.region.method1854(0);
                  }

                  for(var6 = 0; var6 < 104; ++var6) {
                     for(var7 = 0; var7 < 104; ++var7) {
                        class15.groundItemSpawned(var6, var7);
                     }
                  }

                  class85.method1692();

                  for(class25 var74 = (class25)field410.method2412(); var74 != null; var74 = (class25)field410.method2426()) {
                     if(var74.field570 == -1) {
                        var74.field569 = 0;
                        class33.method683(var74);
                     } else {
                        var74.unlink();
                     }
                  }

                  ObjectComposition.field2913.reset();
                  if(class15.field163 != null) {
                     field394.method3037(240);
                     field394.method2802(1057001181);
                  }

                  if(!isDynamicRegion) {
                     var6 = (Spotanim.field2802 - 6) / 8;
                     var7 = (6 + Spotanim.field2802) / 8;
                     var68 = (class156.field2112 - 6) / 8;
                     var55 = (class156.field2112 + 6) / 8;

                     for(var10 = var6 - 1; var10 <= var7 + 1; ++var10) {
                        for(var11 = var68 - 1; var11 <= var55 + 1; ++var11) {
                           if(var10 < var6 || var10 > var7 || var11 < var68 || var11 > var55) {
                              field309.method3291("m" + var10 + "_" + var11);
                              field309.method3291("l" + var10 + "_" + var11);
                           }
                        }
                     }
                  }

                  class212.setGameState(30);
                  class85.method1692();
                  KitDefinition.method3483();
                  field394.method3037(204);
                  class159.field2127.vmethod2044();

                  for(var6 = 0; var6 < 32; ++var6) {
                     GameEngine.field1773[var6] = 0L;
                  }

                  for(var6 = 0; var6 < 32; ++var6) {
                     GameEngine.field1778[var6] = 0L;
                  }

                  class33.field740 = 0;
               }
            }
         }
      } else {
         class2.method28(this);
      }

      if(gameState == 30) {
         class22.method214();
      } else if(gameState == 40 || gameState == 45) {
         class177.method3250();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "352057780"
   )
   protected final void vmethod2111() {
      boolean var1 = class6.method97();
      if(var1 && field516 && class186.field2763 != null) {
         class186.field2763.method1023();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field490 && FrameMap.method1695() > field490) {
            int var2 = isResized?2:1;
            field490 = 0L;
            if(var2 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            class186.method3419();
            if(gameState >= 25) {
               class167.method3159();
            }

            GameEngine.field1781 = true;
         } else if(GameEngine.field1787) {
            DecorativeObject.method1913();
         }
      }

      Dimension var11 = this.method2118();
      if(var11.width != class40.field813 || var11.height != class8.field75 || GameEngine.field1783) {
         class186.method3419();
         field490 = FrameMap.method1695() + 500L;
         GameEngine.field1783 = false;
      }

      boolean var3 = false;
      int var4;
      if(GameEngine.field1781) {
         GameEngine.field1781 = false;
         var3 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field482[var4] = true;
         }
      }

      if(var3) {
         class114.method2204();
      }

      if(gameState == 0) {
         var4 = class41.field836;
         String var5 = class41.field837;
         Color var6 = null;

         try {
            Graphics var7 = class157.canvas.getGraphics();
            if(null == WallObject.field1551) {
               WallObject.field1551 = new java.awt.Font("Helvetica", 1, 13);
               class60.field1085 = class157.canvas.getFontMetrics(WallObject.field1551);
            }

            if(var3) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, class26.field577, class187.field2776);
            }

            if(var6 == null) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(null == class104.field1684) {
                  class104.field1684 = class157.canvas.createImage(304, 34);
               }

               Graphics var8 = class104.field1684.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, var4 * 3, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(2 + 3 * var4, 2, 300 - var4 * 3, 30);
               var8.setFont(WallObject.field1551);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - class60.field1085.stringWidth(var5)) / 2, 22);
               var7.drawImage(class104.field1684, class26.field577 / 2 - 152, class187.field2776 / 2 - 18, (ImageObserver)null);
            } catch (Exception var14) {
               int var9 = class26.field577 / 2 - 152;
               int var10 = class187.field2776 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(2 + var9, 2 + var10, 3 * var4, 30);
               var7.setColor(Color.black);
               var7.drawRect(var9 + 1, 1 + var10, 301, 31);
               var7.fillRect(var9 + 2 + 3 * var4, var10 + 2, 300 - var4 * 3, 30);
               var7.setFont(WallObject.field1551);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - class60.field1085.stringWidth(var5)) / 2, var10 + 22);
            }
         } catch (Exception var15) {
            class157.canvas.repaint();
         }
      } else if(gameState == 5) {
         class6.method92(Tile.field1346, Ignore.field204, class178.field2670, var3);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class6.method92(Tile.field1346, Ignore.field204, class178.field2670, var3);
         } else if(gameState == 25) {
            if(field349 == 1) {
               if(field333 > field334) {
                  field334 = field333;
               }

               var4 = (field334 * 50 - field333 * 50) / field334;
               Tile.method1549("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field349 == 2) {
               if(field335 > field498) {
                  field498 = field335;
               }

               var4 = (field498 * 50 - field335 * 50) / field498 + 50;
               Tile.method1549("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               Tile.method1549("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            class65.method1154();
         } else if(gameState == 40) {
            Tile.method1549("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            Tile.method1549("Please wait...", false);
         }
      } else {
         class6.method92(Tile.field1346, Ignore.field204, class178.field2670, var3);
      }

      Graphics var12;
      int var13;
      if(gameState == 30 && field489 == 0 && !var3) {
         try {
            var12 = class157.canvas.getGraphics();

            for(var13 = 0; var13 < field480; ++var13) {
               if(field483[var13]) {
                  class57.bufferProvider.drawSub(var12, widgetPositionX[var13], widgetPositionY[var13], widgetBoundsWidth[var13], widgetBoundsHeight[var13]);
                  field483[var13] = false;
               }
            }
         } catch (Exception var17) {
            class157.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var12 = class157.canvas.getGraphics();
            class57.bufferProvider.draw(var12, 0, 0);

            for(var13 = 0; var13 < field480; ++var13) {
               field483[var13] = false;
            }
         } catch (Exception var16) {
            class157.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   protected final void vmethod2115() {
      if(Tile.chatMessages.method832()) {
         Tile.chatMessages.method844();
      }

      if(null != class45.field901) {
         class45.field901.field213 = false;
      }

      class45.field901 = null;
      if(null != Friend.field152) {
         Friend.field152.method2059();
         Friend.field152 = null;
      }

      class6.method95();
      if(null != class115.mouse) {
         class115 var1 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

      class138.field1917 = null;
      if(null != class186.field2763) {
         class186.field2763.method1065();
      }

      if(class47.field935 != null) {
         class47.field935.method1065();
      }

      FrameMap.method1696();
      XGrandExchangeOffer.method62();
      class112.method2097();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   void method259() {
      if(gameState != 1000) {
         long var2 = FrameMap.method1695();
         int var4 = (int)(var2 - class185.field2759);
         class185.field2759 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class185.field2751 += var4;
         boolean var1;
         if(class185.field2752 == 0 && class185.field2747 == 0 && class185.field2750 == 0 && class185.field2745 == 0) {
            var1 = true;
         } else if(class185.field2757 == null) {
            var1 = false;
         } else {
            try {
               label239: {
                  if(class185.field2751 > 30000) {
                     throw new IOException();
                  }

                  class181 var5;
                  Buffer var6;
                  while(class185.field2747 < 20 && class185.field2745 > 0) {
                     var5 = (class181)class185.field2743.method2361();
                     var6 = new Buffer(4);
                     var6.method2799(1);
                     var6.method2801((int)var5.hash);
                     class185.field2757.method2073(var6.payload, 0, 4);
                     class185.field2761.method2364(var5, var5.hash);
                     --class185.field2745;
                     ++class185.field2747;
                  }

                  while(class185.field2752 < 20 && class185.field2750 > 0) {
                     var5 = (class181)class185.field2748.method2314();
                     var6 = new Buffer(4);
                     var6.method2799(0);
                     var6.method2801((int)var5.hash);
                     class185.field2757.method2073(var6.payload, 0, 4);
                     var5.method2440();
                     class185.field2762.method2364(var5, var5.hash);
                     --class185.field2750;
                     ++class185.field2752;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class185.field2757.method2054();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class185.field2751 = 0;
                     byte var7 = 0;
                     if(class185.field2753 == null) {
                        var7 = 8;
                     } else if(class185.field2755 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class185.field2754.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class185.field2757.method2055(class185.field2754.payload, class185.field2754.offset, var8);
                        if(class185.field2746 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class185.field2754.payload[class185.field2754.offset + var9] ^= class185.field2746;
                           }
                        }

                        class185.field2754.offset += var8;
                        if(class185.field2754.offset < var7) {
                           break;
                        }

                        if(class185.field2753 == null) {
                           class185.field2754.offset = 0;
                           var9 = class185.field2754.readUnsignedByte();
                           var10 = class185.field2754.readUnsignedShort();
                           int var11 = class185.field2754.readUnsignedByte();
                           var12 = class185.field2754.method2819();
                           long var13 = (long)((var9 << 16) + var10);
                           class181 var15 = (class181)class185.field2761.method2374(var13);
                           class171.field2343 = true;
                           if(null == var15) {
                              var15 = (class181)class185.field2762.method2374(var13);
                              class171.field2343 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class185.field2753 = var15;
                           class156.field2116 = new Buffer(class185.field2753.field2697 + var12 + var16);
                           class156.field2116.method2799(var11);
                           class156.field2116.method2802(var12);
                           class185.field2755 = 8;
                           class185.field2754.offset = 0;
                        } else if(class185.field2755 == 0) {
                           if(class185.field2754.payload[0] == -1) {
                              class185.field2755 = 1;
                              class185.field2754.offset = 0;
                           } else {
                              class185.field2753 = null;
                           }
                        }
                     } else {
                        var8 = class156.field2116.payload.length - class185.field2753.field2697;
                        var9 = 512 - class185.field2755;
                        if(var9 > var8 - class156.field2116.offset) {
                           var9 = var8 - class156.field2116.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class185.field2757.method2055(class156.field2116.payload, class156.field2116.offset, var9);
                        if(class185.field2746 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class156.field2116.payload[class156.field2116.offset + var10] ^= class185.field2746;
                           }
                        }

                        class156.field2116.offset += var9;
                        class185.field2755 += var9;
                        if(class156.field2116.offset == var8) {
                           if(class185.field2753.hash == 16711935L) {
                              Buffer.field2090 = class156.field2116;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class184 var19 = class185.field2758[var10];
                                 if(null != var19) {
                                    Buffer.field2090.offset = 8 * var10 + 5;
                                    var12 = Buffer.field2090.method2819();
                                    int var20 = Buffer.field2090.method2819();
                                    var19.method3364(var12, var20);
                                 }
                              }
                           } else {
                              class185.field2756.reset();
                              class185.field2756.update(class156.field2116.payload, 0, var8);
                              var10 = (int)class185.field2756.getValue();
                              if(class185.field2753.field2696 != var10) {
                                 try {
                                    class185.field2757.method2059();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class185.field2749;
                                 class185.field2757 = null;
                                 class185.field2746 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label239;
                              }

                              class185.field2749 = 0;
                              class185.field2760 = 0;
                              class185.field2753.field2699.method3393((int)(class185.field2753.hash & 65535L), class156.field2116.payload, 16711680L == (class185.field2753.hash & 16711680L), class171.field2343);
                           }

                           class185.field2753.unlink();
                           if(class171.field2343) {
                              --class185.field2747;
                           } else {
                              --class185.field2752;
                           }

                           class185.field2755 = 0;
                           class185.field2753 = null;
                           class156.field2116 = null;
                        } else {
                           if(class185.field2755 != 512) {
                              break;
                           }

                           class185.field2755 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class185.field2757.method2059();
               } catch (Exception var22) {
                  ;
               }

               ++class185.field2760;
               class185.field2757 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method260();
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "32768"
   )
   void method260() {
      if(class185.field2749 >= 4) {
         this.method2116("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2760 >= 4) {
            if(gameState <= 5) {
               this.method2116("js5io");
               gameState = 1000;
               return;
            }

            field308 = 3000;
            class185.field2760 = 3;
         }

         if(--field308 + 1 <= 0) {
            try {
               if(field444 == 0) {
                  DecorativeObject.field1600 = class45.field899.method1949(MessageNode.host, class103.field1676);
                  ++field444;
               }

               if(field444 == 1) {
                  if(DecorativeObject.field1600.field1667 == 2) {
                     this.method261(-1);
                     return;
                  }

                  if(DecorativeObject.field1600.field1667 == 1) {
                     ++field444;
                  }
               }

               if(field444 == 2) {
                  class18.field196 = new class110((Socket)DecorativeObject.field1600.field1664, class45.field899);
                  Buffer var1 = new Buffer(5);
                  var1.method2799(15);
                  var1.method2802(132);
                  class18.field196.method2073(var1.payload, 0, 5);
                  ++field444;
                  XGrandExchangeOffer.field43 = FrameMap.method1695();
               }

               if(field444 == 3) {
                  if(gameState > 5 && class18.field196.method2054() <= 0) {
                     if(FrameMap.method1695() - XGrandExchangeOffer.field43 > 30000L) {
                        this.method261(-2);
                        return;
                     }
                  } else {
                     int var5 = class18.field196.method2065();
                     if(var5 != 0) {
                        this.method261(var5);
                        return;
                     }

                     ++field444;
                  }
               }

               if(field444 == 4) {
                  class110 var10 = class18.field196;
                  boolean var2 = gameState > 20;
                  if(null != class185.field2757) {
                     try {
                        class185.field2757.method2059();
                     } catch (Exception var8) {
                        ;
                     }

                     class185.field2757 = null;
                  }

                  class185.field2757 = var10;
                  class119.method2295(var2);
                  class185.field2754.offset = 0;
                  class185.field2753 = null;
                  class156.field2116 = null;
                  class185.field2755 = 0;

                  while(true) {
                     class181 var3 = (class181)class185.field2761.method2361();
                     if(var3 == null) {
                        while(true) {
                           var3 = (class181)class185.field2762.method2361();
                           if(null == var3) {
                              if(class185.field2746 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.method2799(4);
                                    var11.method2799(class185.field2746);
                                    var11.method2837(0);
                                    class185.field2757.method2073(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class185.field2757.method2059();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class185.field2760;
                                    class185.field2757 = null;
                                 }
                              }

                              class185.field2751 = 0;
                              class185.field2759 = FrameMap.method1695();
                              DecorativeObject.field1600 = null;
                              class18.field196 = null;
                              field444 = 0;
                              field310 = 0;
                              return;
                           }

                           class185.field2748.method2306(var3);
                           class185.field2741.method2364(var3, var3.hash);
                           ++class185.field2750;
                           --class185.field2752;
                        }
                     }

                     class185.field2743.method2364(var3, var3.hash);
                     ++class185.field2745;
                     --class185.field2747;
                  }
               }
            } catch (IOException var9) {
               this.method261(-3);
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-769358321"
   )
   void method261(int var1) {
      DecorativeObject.field1600 = null;
      class18.field196 = null;
      field444 = 0;
      if(class49.field963 == class103.field1676) {
         class103.field1676 = class174.field2637;
      } else {
         class103.field1676 = class49.field963;
      }

      ++field310;
      if(field310 < 2 || var1 != 7 && var1 != 9) {
         if(field310 >= 2 && var1 == 6) {
            this.method2116("js5connect_outofdate");
            gameState = 1000;
         } else if(field310 >= 4) {
            if(gameState <= 5) {
               this.method2116("js5connect");
               gameState = 1000;
            } else {
               field308 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2116("js5connect_full");
         gameState = 1000;
      } else {
         field308 = 3000;
      }

   }

   static {
      field307 = class40.field808;
      field305 = class40.field808;
      field306 = 0;
      field444 = 0;
      field308 = 0;
      field310 = 0;
      field311 = 0;
      field303 = 0;
      field313 = 0;
      field314 = 0;
      cachedNPCs = new NPC['耀'];
      field316 = 0;
      field419 = new int['耀'];
      field554 = 0;
      field319 = new int[250];
      field394 = new class159(5000);
      field322 = new class159(5000);
      field323 = new class159(15000);
      field541 = 0;
      packetOpcode = 0;
      field326 = 0;
      field348 = 0;
      field328 = 0;
      field400 = 0;
      field330 = 0;
      field331 = 0;
      field332 = false;
      field333 = 0;
      field334 = 1;
      field335 = 0;
      field498 = 1;
      field349 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field340 = new int[4][13][13];
      field341 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field362 = 0;
      field299 = 2;
      field344 = 0;
      field417 = 2;
      field346 = 0;
      field347 = 1;
      field463 = 0;
      mapScale = 0;
      field350 = 2;
      mapScaleDelta = 0;
      field352 = 1;
      field281 = 0;
      field354 = 0;
      field537 = 2301979;
      field357 = 5063219;
      field358 = 3353893;
      field359 = 7759444;
      field360 = false;
      field487 = 0;
      field383 = 128;
      mapAngle = 0;
      field364 = 0;
      field365 = 0;
      field366 = 0;
      field367 = 0;
      field298 = 50;
      field369 = 0;
      field435 = false;
      field519 = 0;
      field372 = 0;
      field373 = 50;
      field491 = new int[field373];
      field401 = new int[field373];
      field376 = new int[field373];
      field377 = new int[field373];
      field278 = new int[field373];
      field379 = new int[field373];
      field380 = new int[field373];
      field381 = new String[field373];
      field287 = new int[104][104];
      field524 = 0;
      field398 = -1;
      field317 = -1;
      field420 = 0;
      field464 = 0;
      field388 = 0;
      field371 = 0;
      field390 = 0;
      field391 = 0;
      field392 = 0;
      field393 = 0;
      field526 = 0;
      field395 = 0;
      field396 = false;
      field320 = 0;
      field397 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field304 = 0;
      field402 = 0;
      field403 = new int[1000];
      field404 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriority = new boolean[8];
      field418 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field336 = -1;
      groundItemDeque = new Deque[4][104][104];
      field410 = new Deque();
      projectiles = new Deque();
      field412 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field384 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field425 = -1;
      field426 = -1;
      field427 = 0;
      field507 = 50;
      field429 = 0;
      field431 = null;
      field432 = false;
      field433 = -1;
      field434 = -1;
      field406 = null;
      field436 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field413 = 0;
      field440 = 0;
      field441 = null;
      energy = 0;
      weight = 0;
      field327 = 0;
      field445 = -1;
      field446 = false;
      field505 = false;
      field502 = false;
      field449 = null;
      field368 = null;
      field430 = null;
      field452 = 0;
      field551 = 0;
      field454 = null;
      field337 = false;
      field456 = -1;
      field457 = -1;
      field448 = false;
      field497 = -1;
      field460 = -1;
      field461 = false;
      field462 = 1;
      field428 = new int[32];
      field458 = 0;
      interfaceItemTriggers = new int[32];
      field466 = 0;
      field467 = new int[32];
      field468 = 0;
      field469 = 0;
      field416 = 0;
      field471 = 0;
      field470 = 0;
      field473 = 0;
      field474 = 0;
      field475 = 0;
      field476 = new Deque();
      field378 = new Deque();
      field478 = new Deque();
      widgetFlags = new XHashTable(512);
      field480 = 0;
      field481 = -2;
      field482 = new boolean[100];
      field483 = new boolean[100];
      field484 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field489 = 0;
      field490 = 0L;
      isResized = true;
      field492 = 765;
      field493 = 503;
      field494 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field495 = 0;
      field514 = 0;
      field297 = "";
      field361 = new long[100];
      field312 = 0;
      field500 = 0;
      field501 = new int[128];
      field447 = new int[128];
      field503 = -1L;
      field504 = null;
      clanChatOwner = null;
      field506 = -1;
      field343 = 0;
      field508 = new int[1000];
      field531 = new int[1000];
      field510 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field513 = 0;
      field536 = 255;
      field515 = -1;
      field516 = false;
      field517 = 127;
      field518 = 127;
      field370 = 0;
      field520 = new int[50];
      field521 = new int[50];
      field522 = new int[50];
      field523 = new int[50];
      field302 = new class53[50];
      field525 = false;
      field443 = new boolean[5];
      field527 = new int[5];
      field528 = new int[5];
      field529 = new int[5];
      field530 = new int[5];
      field355 = 256;
      field532 = 205;
      field533 = 256;
      field534 = 320;
      field535 = 1;
      field450 = 32767;
      field345 = 1;
      field538 = 32767;
      field539 = 0;
      field540 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field545 = 0;
      friends = new Friend[400];
      field547 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field550 = new PlayerComposition();
      field451 = -1;
      field552 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field374 = -1L;
      field555 = -1L;
      field556 = new class22();
      field557 = new int[50];
      field558 = new int[50];
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "-807442203"
   )
   static final WidgetNode method357(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field175 = var2;
      componentTable.method2364(var3, (long)var0);
      class9.method120(var1);
      Widget var4 = class37.method736(var0);
      class33.method682(var4);
      if(null != field441) {
         class33.method682(field441);
         field441 = null;
      }

      class13.method175();
      Renderable.method1892(Widget.widgets[var0 >> 16], var4, false);
      class5.method78(var1);
      if(widgetRoot != -1) {
         class148.method2783(widgetRoot, 1);
      }

      return var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-684342026"
   )
   protected final void vmethod2112() {
      class49.field963 = field424 == 0?'ꩊ':world + '鱀';
      class174.field2637 = field424 == 0?443:world + '썐';
      class103.field1676 = class49.field963;
      class227.field3229 = class167.field2181;
      PlayerComposition.field2171 = class167.field2179;
      PlayerComposition.field2172 = class167.field2178;
      World.field683 = class167.field2180;
      if(class103.field1671.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1712[186] = 57;
         class105.field1712[187] = 27;
         class105.field1712[188] = 71;
         class105.field1712[189] = 26;
         class105.field1712[190] = 72;
         class105.field1712[191] = 73;
         class105.field1712[192] = 58;
         class105.field1712[219] = 42;
         class105.field1712[220] = 74;
         class105.field1712[221] = 43;
         class105.field1712[222] = 59;
         class105.field1712[223] = 28;
      } else {
         class105.field1712[44] = 71;
         class105.field1712[45] = 26;
         class105.field1712[46] = 72;
         class105.field1712[47] = 73;
         class105.field1712[59] = 57;
         class105.field1712[61] = 27;
         class105.field1712[91] = 42;
         class105.field1712[92] = 74;
         class105.field1712[93] = 43;
         class105.field1712[192] = 28;
         class105.field1712[222] = 58;
         class105.field1712[520] = 59;
      }

      Canvas var1 = class157.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class105.keyboard);
      var1.addFocusListener(class105.keyboard);
      FileOnDisk.method1428(class157.canvas);
      class138.field1917 = class60.method1122();
      if(null != class138.field1917) {
         class138.field1917.vmethod2092(class157.canvas);
      }

      class2.field26 = new class116(255, class104.field1688, class104.field1689, 500000);
      FileOnDisk var3 = null;
      class30 var4 = new class30();

      try {
         var3 = class37.method728("", class155.field2107.field2688, false);
         byte[] var5 = new byte[(int)var3.method1418()];

         int var7;
         for(int var6 = 0; var6 < var5.length; var6 += var7) {
            var7 = var3.method1405(var5, var6, var5.length - var6);
            if(var7 == -1) {
               throw new IOException();
            }
         }

         var4 = new class30(new Buffer(var5));
      } catch (Exception var10) {
         ;
      }

      try {
         if(var3 != null) {
            var3.method1403();
         }
      } catch (Exception var9) {
         ;
      }

      class107.field1733 = var4;
      class15.field165 = this.getToolkit().getSystemClipboard();
      class48.method878(this, class146.field2025);
      if(field424 != 0) {
         field477 = true;
      }

      int var8 = class107.field1733.field687;
      field490 = 0L;
      if(var8 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      class186.method3419();
      if(gameState >= 25) {
         class167.method3159();
      }

      GameEngine.field1781 = true;
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-609235501"
   )
   static void method423(int var0, int var1) {
      class40.method746(class15.field164, var0, var1);
      class15.field164 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-229565322"
   )
   static String method568(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1008912553"
   )
   static String method569(int var0) {
      return menuTargets[var0].length() > 0?menuOptions[var0] + " " + menuTargets[var0]:menuOptions[var0];
   }
}
