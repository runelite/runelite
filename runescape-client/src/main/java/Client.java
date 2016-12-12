import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.image.ImageObserver;
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
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1449809625
   )
   static int field281;
   @ObfuscatedName("e")
   static Client field282;
   @ObfuscatedName("f")
   static boolean field283 = true;
   @ObfuscatedName("oc")
   static PlayerComposition field284;
   @ObfuscatedName("ko")
   static int[] field285;
   @ObfuscatedName("n")
   static class178 field286;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2108822463
   )
   static int field287 = 0;
   @ObfuscatedName("h")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("p")
   static boolean field289 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1020204661
   )
   static int field290 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -210345695
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("d")
   static boolean field292 = true;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -323261049
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("cr")
   static class159 field294;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1928044371
   )
   static int field295 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 304077033
   )
   static int field296 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1286222493
   )
   static int field297 = -1;
   @ObfuscatedName("ai")
   static boolean field298 = true;
   @ObfuscatedName("fc")
   static int[] field299;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1722179419
   )
   static int field300 = 0;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 2117925349
   )
   static int field301;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 94135663
   )
   static int field302 = 0;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -2119006017
   )
   static int field303 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 963718599
   )
   static int field304 = 0;
   @ObfuscatedName("pz")
   static int[] field305;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1767626899
   )
   static int field306 = 0;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 2056801977
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 115462879
   )
   static int field308 = 0;
   @ObfuscatedName("ab")
   static class40 field309;
   @ObfuscatedName("al")
   static class40 field310;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1537972079
   )
   static int field311;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1492052139
   )
   static int field312;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1516717693
   )
   static int field313;
   @ObfuscatedName("bx")
   static class184 field314;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1271288835
   )
   static int field315;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1141512595
   )
   static int field316;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1038367055
   )
   static int field317;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1019638181
   )
   static int field318;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1019171497
   )
   static int field319;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1542086471
   )
   static int field320;
   @ObfuscatedName("ca")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 743352847
   )
   static int field322;
   @ObfuscatedName("co")
   static int[] field323;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1556302517
   )
   static int field324;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -1742396709
   )
   static int field325;
   @ObfuscatedName("cy")
   static class110 field326;
   @ObfuscatedName("is")
   static String field327;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 1792184265
   )
   static int field328;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 68929555
   )
   static int field329;
   @ObfuscatedName("fs")
   static int[] field330;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1194489149
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 465914207
   )
   static int field332;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1124332611
   )
   static int field333;
   @ObfuscatedName("fo")
   static int[] field334;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1867468593
   )
   static int field335 = 0;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -574313815
   )
   static int field336;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -177491673
   )
   static int field337;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 648972089
   )
   static int field338;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 974284249
   )
   static int field340;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -1382420337
   )
   static int field341;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 1810338527
   )
   static int field342;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 733484741
   )
   static int field343;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -147017159
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 640021365
   )
   static int field345;
   @ObfuscatedName("dc")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("dy")
   @Export("region")
   static Region region;
   @ObfuscatedName("ow")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("di")
   static boolean field349;
   @ObfuscatedName("dx")
   static int[][][] field350;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 1573241411
   )
   static int field351;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -1526704865
   )
   static int field352;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 607697209
   )
   static int field353;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 1733548945
   )
   static int field354;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 345376853
   )
   static int field355;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 257722023
   )
   static int field356;
   @ObfuscatedName("mw")
   static int[] field357;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -1038553879
   )
   static int field358;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -1628672123
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -1948130027
   )
   static int field360;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -437689027
   )
   static int field361;
   @ObfuscatedName("cw")
   static class159 field362;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 634562465
   )
   static int field363;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = -562492331
   )
   static int field364;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 242785617
   )
   static int field365;
   @ObfuscatedName("ij")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1183183881
   )
   static int field367;
   @ObfuscatedName("ey")
   static boolean field369;
   @ObfuscatedName("hv")
   static Deque field370;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 764001535
   )
   static int field371;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1795175003
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = -1164712149
   )
   static int field373;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -218430475
   )
   static int field374;
   @ObfuscatedName("it")
   static String field375;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1186727057
   )
   static int field377;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -623439155
   )
   static int field378;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -1674379723
   )
   static int field379;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 1694346533
   )
   static int field380;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -750704551
   )
   static int field381;
   @ObfuscatedName("ot")
   static short field382;
   @ObfuscatedName("fp")
   static int[] field383;
   @ObfuscatedName("fd")
   static int[] field384;
   @ObfuscatedName("fh")
   static int[] field385;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1201863203
   )
   static int field386;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1460487253
   )
   static int field387;
   @ObfuscatedName("im")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -151737833
   )
   static int field389;
   @ObfuscatedName("gq")
   static String[] field390;
   @ObfuscatedName("gs")
   static int[][] field391;
   @ObfuscatedName("oa")
   static short field392;
   @ObfuscatedName("og")
   static int[] field393;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 961378405
   )
   static int field394;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 663616093
   )
   static int field395;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -1292489147
   )
   static int field396;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 56606017
   )
   static int field397;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -1386083493
   )
   static int field398;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -1269679001
   )
   static int field399;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 213384045
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -879268369
   )
   static int field401;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1534087701
   )
   static int field402 = 0;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 994272403
   )
   static int field403;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 458999607
   )
   static int field404;
   @ObfuscatedName("cd")
   static int[] field405;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -1308573189
   )
   static int field406;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 1874118307
   )
   static int field407;
   @ObfuscatedName("gg")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("nd")
   static int[] field409;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -1630751579
   )
   static int field410;
   @ObfuscatedName("cl")
   static boolean field411;
   @ObfuscatedName("hu")
   static int[] field412;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 1099585163
   )
   static int field414;
   @ObfuscatedName("he")
   static String[] field415;
   @ObfuscatedName("hz")
   static boolean[] field416;
   @ObfuscatedName("hi")
   static int[] field417;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -1377260817
   )
   static int field418;
   @ObfuscatedName("hb")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ox")
   static int[] field420;
   @ObfuscatedName("jy")
   static Widget field421;
   @ObfuscatedName("hl")
   static Deque field422;
   @ObfuscatedName("hs")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("hr")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("hg")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -1226584399
   )
   static int field426;
   @ObfuscatedName("ht")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1081265259
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("hq")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("ha")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("mj")
   static int[] field431;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 457031783
   )
   static int field432;
   @ObfuscatedName("id")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("il")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -137577857
   )
   static int field435;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -2145361497
   )
   static int field436;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -547636551
   )
   static int field437;
   @ObfuscatedName("lh")
   static int[] field438;
   @ObfuscatedName("nr")
   static int[] field439;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1741527121
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("fu")
   static boolean field441;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -61542861
   )
   static int field442;
   @ObfuscatedName("lr")
   static long[] field443;
   @ObfuscatedName("iw")
   static String field444;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -1373568061
   )
   static int field446;
   @ObfuscatedName("iv")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -2043753489
   )
   static int field448;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 839410577
   )
   static int field449;
   @ObfuscatedName("ju")
   static Widget field450;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -303699519
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -1346228069
   )
   static int field452;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -263547881
   )
   static int field453;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 1059298833
   )
   static int field454;
   @ObfuscatedName("jg")
   static boolean field455;
   @ObfuscatedName("jm")
   static boolean field456;
   @ObfuscatedName("ge")
   static boolean field457;
   @ObfuscatedName("lw")
   static int[] field458;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      longValue = -2820206311954702429L
   )
   static long field459;
   @ObfuscatedName("jw")
   static Widget field460;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = -1124154735
   )
   static int field461;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 439215789
   )
   static int field462;
   @ObfuscatedName("jp")
   static Widget field463;
   @ObfuscatedName("jq")
   static boolean field464;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -1110700927
   )
   static int field465;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1159326109
   )
   static int field466;
   @ObfuscatedName("ja")
   static boolean field467;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -162161421
   )
   static int field468;
   @ObfuscatedName("aq")
   static boolean field469 = false;
   @ObfuscatedName("jr")
   static boolean field470;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -1263169357
   )
   static int field471;
   @ObfuscatedName("ki")
   static int[] field472;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 448458343
   )
   static int field473;
   @ObfuscatedName("ky")
   static int[] field474;
   @ObfuscatedName("kx")
   static Deque field475;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1383158761
   )
   static int field476;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -1258056435
   )
   static int field477;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -1897172249
   )
   static int field478;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -1602827971
   )
   static int field479;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 2037029273
   )
   static int field480;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 90219229
   )
   static int field481;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -319352227
   )
   static int field482;
   @ObfuscatedName("ni")
   static int[] field483;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -754469525
   )
   static int field484;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 747876391
   )
   static int field485;
   @ObfuscatedName("kw")
   static Deque field486;
   @ObfuscatedName("ho")
   static final int[] field487;
   @ObfuscatedName("ka")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1677277617
   )
   static int field489 = 0;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -1954397601
   )
   static int field490;
   @ObfuscatedName("do")
   static final int[] field491;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 301841449
   )
   static int field492;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 864964891
   )
   static int field493;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -1320531407
   )
   static int field494;
   @ObfuscatedName("lk")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("lv")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("lu")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 695989843
   )
   static int field498;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1133435769
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("ly")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = -1008992331
   )
   static int field501;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1808976985
   )
   static int field502;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 1707074081
   )
   static int field503;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 580541817
   )
   static int field504;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = -280858363
   )
   static int field505;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -655450395
   )
   static int field506;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 2145958433
   )
   static int field507;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = 1752989771
   )
   static int field508;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -215280449
   )
   static int field509;
   @ObfuscatedName("mi")
   static int[] field510;
   @ObfuscatedName("jh")
   static Widget field511;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      longValue = 7108941676648461419L
   )
   static long field512;
   @ObfuscatedName("mh")
   static String field513;
   @ObfuscatedName("mk")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 646407011
   )
   static int field515;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 1562717679
   )
   static int field516;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1058830219
   )
   static int field517;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 954128659
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("mn")
   static SpritePixels[] field519;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = 1756380447
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 1688020549
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 379733105
   )
   static int field522;
   @ObfuscatedName("ig")
   static boolean field523;
   @ObfuscatedName("kb")
   static boolean[] field524;
   @ObfuscatedName("ms")
   static boolean field525;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1015042127
   )
   static int field526;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 1873714073
   )
   static int field527;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -163126155
   )
   static int field528;
   @ObfuscatedName("na")
   static int[] field529;
   @ObfuscatedName("fn")
   static int[] field530;
   @ObfuscatedName("pg")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("ln")
   static String field532;
   @ObfuscatedName("no")
   static class53[] field533;
   @ObfuscatedName("np")
   static boolean field534;
   @ObfuscatedName("nm")
   static boolean[] field535;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 2144466379
   )
   static int field536;
   @ObfuscatedName("hn")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("oz")
   static int[] field538;
   @ObfuscatedName("oq")
   static int[] field539;
   @ObfuscatedName("ol")
   static short field540;
   @ObfuscatedName("ok")
   static short field541;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -1976824909
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("oo")
   static short field543;
   @ObfuscatedName("ct")
   static class159 field544;
   @ObfuscatedName("oi")
   static short field545;
   @ObfuscatedName("ou")
   static short field546;
   @ObfuscatedName("op")
   static short field547;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 997131603
   )
   static int field548;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -1695388341
   )
   static int field549;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = -1782720919
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 959870499
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("kk")
   static Deque field552;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = -1066891323
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = 1348947959
   )
   static int field554;
   @ObfuscatedName("or")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("ob")
   static class130 field556;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -1358157837
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("ll")
   static boolean[] field559;
   @ObfuscatedName("lb")
   static boolean[] field560;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -977471533
   )
   static int field561;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      longValue = 2221483590052675643L
   )
   static long field562;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 4732269455739611251L
   )
   static long field563 = -1L;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      longValue = 2111710829914967679L
   )
   static long field564;
   @ObfuscatedName("pk")
   static final class22 field565;
   @ObfuscatedName("pl")
   static int[] field566;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 1413605569
   )
   static int field567;
   @ObfuscatedName("nx")
   static class57 field568;
   @ObfuscatedName("jz")
   static boolean field570;
   @ObfuscatedName("lg")
   @Export("widgetPositionX")
   static int[] widgetPositionX;

   public final void init() {
      if(this.method2073()) {
         class214[] var1 = new class214[]{class214.field3150, class214.field3153, class214.field3154, class214.field3156, class214.field3149, class214.field3144, class214.field3158, class214.field3146, class214.field3157, class214.field3148, class214.field3155, class214.field3152, class214.field3151, class214.field3145, class214.field3147};
         class214[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class214 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3159);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3159)) {
               case 2:
                  CombatInfoListHolder.field756 = var5;
                  break;
               case 3:
                  world = Integer.parseInt(var5);
                  break;
               case 4:
                  field290 = Integer.parseInt(var5);
               case 5:
               case 7:
               default:
                  break;
               case 6:
                  class18.field185 = Integer.parseInt(var5);
                  break;
               case 8:
                  field287 = Integer.parseInt(var5);
                  break;
               case 9:
                  field286 = class63.method1134(Integer.parseInt(var5));
                  break;
               case 10:
                  flags = Integer.parseInt(var5);
                  break;
               case 11:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 12:
                  class3.field33 = var5;
                  break;
               case 13:
                  class167.field2188 = Integer.parseInt(var5);
                  break;
               case 14:
                  class179[] var6 = new class179[]{class179.field2686, class179.field2682, class179.field2689, class179.field2683, class179.field2684, class179.field2681};
                  MessageNode.field226 = (class179)XItemContainer.method161(var6, Integer.parseInt(var5));
                  if(MessageNode.field226 == class179.field2686) {
                     class108.field1724 = class228.field3239;
                  } else {
                     class108.field1724 = class228.field3237;
                  }
                  break;
               case 15:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
               }
            }
         }

         method552();
         class5.host = this.getCodeBase().getHost();
         String var10 = field286.field2676;
         byte var7 = 0;

         try {
            class104.method1974("oldschool", var10, var7, 16);
         } catch (Exception var9) {
            FaceNormal.method1864((String)null, var9);
         }

         field282 = this;
         this.method2145(765, 503, 129);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   protected final void vmethod2080() {
      class9.field87 = field287 == 0?'ꩊ':world + '鱀';
      class7.field66 = field287 == 0?443:world + '썐';
      class167.field2189 = class9.field87;
      FileOnDisk.field1195 = class167.field2190;
      class217.field3169 = class167.field2185;
      class0.field4 = class167.field2186;
      PlayerComposition.field2183 = class167.field2187;
      if(class103.field1665.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1687[186] = 57;
         class105.field1687[187] = 27;
         class105.field1687[188] = 71;
         class105.field1687[189] = 26;
         class105.field1687[190] = 72;
         class105.field1687[191] = 73;
         class105.field1687[192] = 58;
         class105.field1687[219] = 42;
         class105.field1687[220] = 74;
         class105.field1687[221] = 43;
         class105.field1687[222] = 59;
         class105.field1687[223] = 28;
      } else {
         class105.field1687[44] = 71;
         class105.field1687[45] = 26;
         class105.field1687[46] = 72;
         class105.field1687[47] = 73;
         class105.field1687[59] = 57;
         class105.field1687[61] = 27;
         class105.field1687[91] = 42;
         class105.field1687[92] = 74;
         class105.field1687[93] = 43;
         class105.field1687[192] = 28;
         class105.field1687[222] = 58;
         class105.field1687[520] = 59;
      }

      method307(class110.canvas);
      class49.method864(class110.canvas);
      WidgetNode.field176 = class15.method170();
      if(WidgetNode.field176 != null) {
         WidgetNode.field176.vmethod2058(class110.canvas);
      }

      class140.field1958 = new class116(255, class104.field1673, class104.field1666, 500000);
      FileOnDisk var2 = null;
      class30 var3 = new class30();

      try {
         var2 = NPC.method688("", MessageNode.field226.field2687, false);
         byte[] var4 = new byte[(int)var2.method1390()];

         int var6;
         for(int var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.method1392(var4, var5, var4.length - var5);
            if(var6 == -1) {
               throw new IOException();
            }
         }

         var3 = new class30(new Buffer(var4));
      } catch (Exception var8) {
         ;
      }

      try {
         if(null != var2) {
            var2.method1389();
         }
      } catch (Exception var7) {
         ;
      }

      class149.field2044 = var3;
      class116.field1814 = this.getToolkit().getSystemClipboard();
      class39.method708(this, Item.field892);
      if(field287 != 0) {
         field469 = true;
      }

      Friend.method166(class149.field2044.field691);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-37"
   )
   protected final void vmethod2107() {
      boolean var1;
      label241: {
         try {
            if(class138.field1914 == 2) {
               if(null == class138.field1917) {
                  class138.field1917 = class144.method2680(class145.field2014, class30.field693, class138.field1915);
                  if(class138.field1917 == null) {
                     var1 = false;
                     break label241;
                  }
               }

               if(class112.field1760 == null) {
                  class112.field1760 = new class60(class138.field1912, class138.field1918);
               }

               if(class138.field1913.method2462(class138.field1917, class138.field1919, class112.field1760, 22050)) {
                  class138.field1913.method2468();
                  class138.field1913.method2470(ItemLayer.field1220);
                  class138.field1913.method2497(class138.field1917, ItemLayer.field1221);
                  class138.field1914 = 0;
                  class138.field1917 = null;
                  class112.field1760 = null;
                  class145.field2014 = null;
                  var1 = true;
                  break label241;
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
            class138.field1913.method2466();
            class138.field1914 = 0;
            class138.field1917 = null;
            class112.field1760 = null;
            class145.field2014 = null;
         }

         var1 = false;
      }

      if(var1 && field525 && field568 != null) {
         field568.method1018();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(field562 != 0L && class72.method1385() > field562) {
            Friend.method166(XGrandExchangeOffer.method57());
         } else if(GameEngine.field1778) {
            class6.method84(class110.canvas);
            class148.method2734(class110.canvas);
            if(WidgetNode.field176 != null) {
               WidgetNode.field176.vmethod2056(class110.canvas);
            }

            field282.method2086();
            class110.canvas.setBackground(Color.black);
            method307(class110.canvas);
            class49.method864(class110.canvas);
            if(WidgetNode.field176 != null) {
               WidgetNode.field176.vmethod2058(class110.canvas);
            }

            if(widgetRoot != -1) {
               class39.method710(false);
            }

            GameEngine.field1777 = true;
         }
      }

      Dimension var3 = this.method2085();
      if(class118.field1849 != var3.width || var3.height != class104.field1679 || GameEngine.field1777) {
         class63.method1131();
         field562 = class72.method1385() + 500L;
         GameEngine.field1777 = false;
      }

      boolean var4 = false;
      int var5;
      if(GameEngine.field1775) {
         GameEngine.field1775 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field524[var5] = true;
         }
      }

      if(var4) {
         TextureProvider.method1423();
      }

      if(gameState == 0) {
         var5 = class41.field842;
         String var6 = class41.field843;
         Color var7 = null;

         try {
            Graphics var8 = class110.canvas.getGraphics();
            if(null == class88.field1537) {
               class88.field1537 = new Font("Helvetica", 1, 13);
               class37.field791 = class110.canvas.getFontMetrics(class88.field1537);
            }

            if(var4) {
               var8.setColor(Color.black);
               var8.fillRect(0, 0, ItemLayer.field1223, class112.field1755);
            }

            if(null == var7) {
               var7 = new Color(140, 17, 17);
            }

            try {
               if(null == ChatMessages.field925) {
                  ChatMessages.field925 = class110.canvas.createImage(304, 34);
               }

               Graphics var9 = ChatMessages.field925.getGraphics();
               var9.setColor(var7);
               var9.drawRect(0, 0, 303, 33);
               var9.fillRect(2, 2, var5 * 3, 30);
               var9.setColor(Color.black);
               var9.drawRect(1, 1, 301, 31);
               var9.fillRect(2 + var5 * 3, 2, 300 - 3 * var5, 30);
               var9.setFont(class88.field1537);
               var9.setColor(Color.white);
               var9.drawString(var6, (304 - class37.field791.stringWidth(var6)) / 2, 22);
               var8.drawImage(ChatMessages.field925, ItemLayer.field1223 / 2 - 152, class112.field1755 / 2 - 18, (ImageObserver)null);
            } catch (Exception var15) {
               int var10 = ItemLayer.field1223 / 2 - 152;
               int var11 = class112.field1755 / 2 - 18;
               var8.setColor(var7);
               var8.drawRect(var10, var11, 303, 33);
               var8.fillRect(var10 + 2, var11 + 2, 3 * var5, 30);
               var8.setColor(Color.black);
               var8.drawRect(1 + var10, var11 + 1, 301, 31);
               var8.fillRect(2 + var10 + var5 * 3, 2 + var11, 300 - var5 * 3, 30);
               var8.setFont(class88.field1537);
               var8.setColor(Color.white);
               var8.drawString(var6, var10 + (304 - class37.field791.stringWidth(var6)) / 2, var11 + 22);
            }
         } catch (Exception var16) {
            class110.canvas.repaint();
         }
      } else if(gameState == 5) {
         class49.method863(class11.field119, RSCanvas.field1753, class40.field821, var4);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class49.method863(class11.field119, RSCanvas.field1753, class40.field821, var4);
         } else if(gameState == 25) {
            if(field345 == 1) {
               if(field341 > field342) {
                  field342 = field341;
               }

               var5 = (field342 * 50 - field341 * 50) / field342;
               Frames.method1868("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field345 == 2) {
               if(field343 > field328) {
                  field328 = field343;
               }

               var5 = 50 + (field328 * 50 - field343 * 50) / field328;
               Frames.method1868("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               Frames.method1868("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            Tile.method1538();
         } else if(gameState == 40) {
            Frames.method1868("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            Frames.method1868("Please wait...", false);
         }
      } else {
         class49.method863(class11.field119, RSCanvas.field1753, class40.field821, var4);
      }

      Graphics var13;
      int var14;
      if(gameState == 30 && field498 == 0 && !var4) {
         try {
            var13 = class110.canvas.getGraphics();

            for(var14 = 0; var14 < field281; ++var14) {
               if(field560[var14]) {
                  ChatMessages.bufferProvider.drawSub(var13, widgetPositionX[var14], widgetPositionY[var14], widgetBoundsWidth[var14], widgetBoundsHeight[var14]);
                  field560[var14] = false;
               }
            }
         } catch (Exception var18) {
            class110.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var13 = class110.canvas.getGraphics();
            ChatMessages.bufferProvider.draw(var13, 0, 0);

            for(var14 = 0; var14 < field281; ++var14) {
               field560[var14] = false;
            }
         } catch (Exception var17) {
            class110.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-555505450"
   )
   protected final void vmethod2082() {
      if(Ignore.chatMessages.method812()) {
         Ignore.chatMessages.method809();
      }

      if(class26.field596 != null) {
         class26.field596.field209 = false;
      }

      class26.field596 = null;
      if(null != class156.field2118) {
         class156.field2118.method2035();
         class156.field2118 = null;
      }

      if(null != class105.keyboard) {
         class105 var1 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

      if(class115.mouse != null) {
         class115 var9 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

      WidgetNode.field176 = null;
      if(null != field568) {
         field568.method1019();
      }

      if(null != class104.field1680) {
         class104.field1680.method1019();
      }

      if(null != class185.field2750) {
         class185.field2750.method2035();
      }

      Object var10 = class183.field2727;
      synchronized(class183.field2727) {
         if(class183.field2728 != 0) {
            class183.field2728 = 1;

            try {
               class183.field2727.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      class137.method2433();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "514938959"
   )
   void method245() {
      if(gameState != 1000) {
         long var2 = class72.method1385();
         int var4 = (int)(var2 - class101.field1638);
         class101.field1638 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class185.field2746 += var4;
         boolean var1;
         if(class185.field2763 == 0 && class185.field2748 == 0 && class185.field2753 == 0 && class185.field2765 == 0) {
            var1 = true;
         } else if(class185.field2750 == null) {
            var1 = false;
         } else {
            try {
               label240: {
                  if(class185.field2746 > 30000) {
                     throw new IOException();
                  }

                  class181 var5;
                  Buffer var6;
                  while(class185.field2748 < 20 && class185.field2765 > 0) {
                     var5 = (class181)class185.field2747.method2313();
                     var6 = new Buffer(4);
                     var6.method2932(1);
                     var6.method2747((int)var5.hash);
                     class185.field2750.method2032(var6.payload, 0, 4);
                     class185.field2749.method2312(var5, var5.hash);
                     --class185.field2765;
                     ++class185.field2748;
                  }

                  while(class185.field2763 < 20 && class185.field2753 > 0) {
                     var5 = (class181)class185.field2751.method2261();
                     var6 = new Buffer(4);
                     var6.method2932(0);
                     var6.method2747((int)var5.hash);
                     class185.field2750.method2032(var6.payload, 0, 4);
                     var5.method2388();
                     class185.field2754.method2312(var5, var5.hash);
                     --class185.field2753;
                     ++class185.field2763;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class185.field2750.method2028();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class185.field2746 = 0;
                     byte var7 = 0;
                     if(class161.field2149 == null) {
                        var7 = 8;
                     } else if(class185.field2745 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class185.field2752.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class185.field2750.method2031(class185.field2752.payload, class185.field2752.offset, var8);
                        if(class185.field2762 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class185.field2752.payload[var9 + class185.field2752.offset] ^= class185.field2762;
                           }
                        }

                        class185.field2752.offset += var8;
                        if(class185.field2752.offset < var7) {
                           break;
                        }

                        if(class161.field2149 == null) {
                           class185.field2752.offset = 0;
                           var9 = class185.field2752.readUnsignedByte();
                           var10 = class185.field2752.readUnsignedShort();
                           int var11 = class185.field2752.readUnsignedByte();
                           var12 = class185.field2752.method2844();
                           long var13 = (long)((var9 << 16) + var10);
                           class181 var15 = (class181)class185.field2749.method2311(var13);
                           class185.field2756 = true;
                           if(var15 == null) {
                              var15 = (class181)class185.field2754.method2311(var13);
                              class185.field2756 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class161.field2149 = var15;
                           class185.field2758 = new Buffer(var16 + var12 + class161.field2149.field2701);
                           class185.field2758.method2932(var11);
                           class185.field2758.method2748(var12);
                           class185.field2745 = 8;
                           class185.field2752.offset = 0;
                        } else if(class185.field2745 == 0) {
                           if(class185.field2752.payload[0] == -1) {
                              class185.field2745 = 1;
                              class185.field2752.offset = 0;
                           } else {
                              class161.field2149 = null;
                           }
                        }
                     } else {
                        var8 = class185.field2758.payload.length - class161.field2149.field2701;
                        var9 = 512 - class185.field2745;
                        if(var9 > var8 - class185.field2758.offset) {
                           var9 = var8 - class185.field2758.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class185.field2750.method2031(class185.field2758.payload, class185.field2758.offset, var9);
                        if(class185.field2762 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class185.field2758.payload[class185.field2758.offset + var10] ^= class185.field2762;
                           }
                        }

                        class185.field2758.offset += var9;
                        class185.field2745 += var9;
                        if(class185.field2758.offset == var8) {
                           if(class161.field2149.hash == 16711935L) {
                              class142.field2000 = class185.field2758;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class184 var19 = class185.field2761[var10];
                                 if(null != var19) {
                                    class142.field2000.offset = 5 + 8 * var10;
                                    var12 = class142.field2000.method2844();
                                    int var23 = class142.field2000.method2844();
                                    var19.method3320(var12, var23);
                                 }
                              }
                           } else {
                              class185.field2760.reset();
                              class185.field2760.update(class185.field2758.payload, 0, var8);
                              var10 = (int)class185.field2760.getValue();
                              if(class161.field2149.field2697 != var10) {
                                 try {
                                    class185.field2750.method2035();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class185.field2755;
                                 class185.field2750 = null;
                                 class185.field2762 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label240;
                              }

                              class185.field2755 = 0;
                              class185.field2764 = 0;
                              class161.field2149.field2698.method3319((int)(class161.field2149.hash & 65535L), class185.field2758.payload, (class161.field2149.hash & 16711680L) == 16711680L, class185.field2756);
                           }

                           class161.field2149.unlink();
                           if(class185.field2756) {
                              --class185.field2748;
                           } else {
                              --class185.field2763;
                           }

                           class185.field2745 = 0;
                           class161.field2149 = null;
                           class185.field2758 = null;
                        } else {
                           if(class185.field2745 != 512) {
                              break;
                           }

                           class185.field2745 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class185.field2750.method2035();
               } catch (Exception var20) {
                  ;
               }

               ++class185.field2764;
               class185.field2750 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method392();
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1355099108"
   )
   void method247(int var1) {
      class45.field922 = null;
      class88.field1536 = null;
      field389 = 0;
      if(class167.field2189 == class9.field87) {
         class167.field2189 = class7.field66;
      } else {
         class167.field2189 = class9.field87;
      }

      ++field315;
      if(field315 < 2 || var1 != 7 && var1 != 9) {
         if(field315 >= 2 && var1 == 6) {
            this.method2083("js5connect_outofdate");
            gameState = 1000;
         } else if(field315 >= 4) {
            if(gameState <= 5) {
               this.method2083("js5connect");
               gameState = 1000;
            } else {
               field313 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2083("js5connect_full");
         gameState = 1000;
      } else {
         field313 = 3000;
      }

   }

   static {
      field309 = class40.field815;
      field310 = class40.field815;
      field311 = 0;
      field389 = 0;
      field313 = 0;
      field315 = 0;
      field316 = 0;
      field317 = 0;
      field318 = 0;
      field386 = 0;
      cachedNPCs = new NPC['耀'];
      field322 = 0;
      field323 = new int['耀'];
      field324 = 0;
      field405 = new int[250];
      field294 = new class159(5000);
      field362 = new class159(5000);
      field544 = new class159(15000);
      field485 = 0;
      packetOpcode = 0;
      field332 = 0;
      field333 = 0;
      field319 = 0;
      field466 = 0;
      field336 = 0;
      field453 = 0;
      field411 = false;
      field341 = 0;
      field342 = 1;
      field343 = 0;
      field328 = 1;
      field345 = 0;
      collisionMaps = new CollisionData[4];
      field349 = false;
      field350 = new int[4][13][13];
      field491 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field352 = 0;
      field353 = 2;
      field354 = 0;
      field355 = 2;
      field356 = 0;
      field465 = 1;
      field351 = 0;
      mapScale = 0;
      field360 = 2;
      mapScaleDelta = 0;
      field301 = 1;
      field363 = 0;
      field364 = 0;
      field502 = 2301979;
      field507 = 5063219;
      field367 = 3353893;
      field492 = 7759444;
      field369 = false;
      field473 = 0;
      field371 = 128;
      mapAngle = 0;
      field436 = 0;
      field374 = 0;
      field337 = 0;
      field478 = 0;
      field377 = 50;
      field378 = 0;
      field441 = false;
      field380 = 0;
      field381 = 0;
      field452 = 50;
      field383 = new int[field452];
      field384 = new int[field452];
      field385 = new int[field452];
      field330 = new int[field452];
      field334 = new int[field452];
      field530 = new int[field452];
      field299 = new int[field452];
      field390 = new String[field452];
      field391 = new int[104][104];
      field312 = 0;
      field387 = -1;
      field536 = -1;
      field395 = 0;
      field396 = 0;
      field397 = 0;
      field398 = 0;
      field399 = 0;
      field506 = 0;
      field401 = 0;
      field484 = 0;
      field403 = 0;
      field404 = 0;
      field457 = false;
      field406 = 0;
      field407 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field410 = 0;
      field517 = 0;
      field412 = new int[1000];
      field487 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field415 = new String[8];
      field416 = new boolean[8];
      field417 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field418 = -1;
      groundItemDeque = new Deque[4][104][104];
      field370 = new Deque();
      projectiles = new Deque();
      field422 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field426 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field435 = -1;
      field340 = -1;
      field437 = 0;
      field493 = 50;
      field526 = 0;
      field375 = null;
      field523 = false;
      field442 = -1;
      field338 = -1;
      field444 = null;
      field327 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field448 = 0;
      field449 = 0;
      field450 = null;
      energy = 0;
      weight = 0;
      field358 = 0;
      field454 = -1;
      field455 = false;
      field456 = false;
      field570 = false;
      field421 = null;
      field511 = null;
      field460 = null;
      field461 = 0;
      field462 = 0;
      field463 = null;
      field464 = false;
      field494 = -1;
      field329 = -1;
      field467 = false;
      field468 = -1;
      field325 = -1;
      field470 = false;
      field471 = 1;
      field472 = new int[32];
      field432 = 0;
      field474 = new int[32];
      field365 = 0;
      field285 = new int[32];
      field379 = 0;
      field361 = 0;
      field479 = 0;
      field480 = 0;
      field481 = 0;
      field446 = 0;
      field476 = 0;
      field394 = 0;
      field475 = new Deque();
      field486 = new Deque();
      field552 = new Deque();
      widgetFlags = new XHashTable(512);
      field281 = 0;
      field490 = -2;
      field524 = new boolean[100];
      field560 = new boolean[100];
      field559 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field498 = 0;
      field562 = 0L;
      isResized = true;
      field501 = 765;
      field477 = 1;
      field438 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field504 = 0;
      field505 = 0;
      field532 = "";
      field443 = new long[100];
      field508 = 0;
      field509 = 0;
      field458 = new int[128];
      field431 = new int[128];
      field512 = -1L;
      field513 = null;
      clanChatOwner = null;
      field515 = -1;
      field516 = 0;
      field357 = new int[1000];
      field510 = new int[1000];
      field519 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field522 = 0;
      field373 = 255;
      field414 = -1;
      field525 = false;
      field482 = 127;
      field527 = 127;
      field528 = 0;
      field529 = new int[50];
      field409 = new int[50];
      field439 = new int[50];
      field483 = new int[50];
      field533 = new class53[50];
      field534 = false;
      field535 = new boolean[5];
      field420 = new int[5];
      field393 = new int[5];
      field538 = new int[5];
      field539 = new int[5];
      field540 = 256;
      field541 = 205;
      field382 = 256;
      field543 = 320;
      field392 = 1;
      field545 = 32767;
      field546 = 1;
      field547 = 32767;
      field548 = 0;
      field549 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field554 = 0;
      friends = new Friend[400];
      field556 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field284 = new PlayerComposition();
      field567 = -1;
      field561 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field459 = -1L;
      field564 = -1L;
      field565 = new class22();
      field566 = new int[50];
      field305 = new int[50];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "97160273"
   )
   public static void method307(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1764302418"
   )
   protected final void vmethod2090() {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3636"
   )
   void method392() {
      if(class185.field2755 >= 4) {
         this.method2083("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2764 >= 4) {
            if(gameState <= 5) {
               this.method2083("js5io");
               gameState = 1000;
               return;
            }

            field313 = 3000;
            class185.field2764 = 3;
         }

         if(--field313 + 1 <= 0) {
            try {
               if(field389 == 0) {
                  class45.field922 = class41.field855.method1931(class5.host, class167.field2189);
                  ++field389;
               }

               if(field389 == 1) {
                  if(class45.field922.field1650 == 2) {
                     this.method247(-1);
                     return;
                  }

                  if(class45.field922.field1650 == 1) {
                     ++field389;
                  }
               }

               if(field389 == 2) {
                  class88.field1536 = new class110((Socket)class45.field922.field1652, class41.field855);
                  Buffer var1 = new Buffer(5);
                  var1.method2932(15);
                  var1.method2748(129);
                  class88.field1536.method2032(var1.payload, 0, 5);
                  ++field389;
                  Ignore.field201 = class72.method1385();
               }

               if(field389 == 3) {
                  if(gameState > 5 && class88.field1536.method2028() <= 0) {
                     if(class72.method1385() - Ignore.field201 > 30000L) {
                        this.method247(-2);
                        return;
                     }
                  } else {
                     int var2 = class88.field1536.method2030();
                     if(var2 != 0) {
                        this.method247(var2);
                        return;
                     }

                     ++field389;
                  }
               }

               if(field389 == 4) {
                  class173.method3181(class88.field1536, gameState > 20);
                  class45.field922 = null;
                  class88.field1536 = null;
                  field389 = 0;
                  field315 = 0;
               }
            } catch (IOException var3) {
               this.method247(-3);
            }

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1179563118"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method245();
      class1.method8();
      class0.method6();
      class115.method2194();
      class63.method1135();
      class115 var1 = class115.mouse;
      synchronized(class115.mouse) {
         class115.field1795 = class115.field1792;
         class115.field1794 = class115.field1793;
         class115.field1797 = class115.field1801;
         class115.field1802 = class115.field1806;
         class115.field1803 = class115.field1791;
         class115.field1804 = class115.field1800;
         class115.field1805 = class115.field1796;
         class115.field1806 = 0;
      }

      int var25;
      if(null != WidgetNode.field176) {
         var25 = WidgetNode.field176.vmethod2057();
         field394 = var25;
      }

      if(gameState == 0) {
         class112.method2067();
         class101.method1927();
      } else if(gameState == 5) {
         FileOnDisk.method1387(this);
         class112.method2067();
         class101.method1927();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            FileOnDisk.method1387(this);
            class6.method82();
         } else if(gameState == 25) {
            class174.method3183();
         }
      } else {
         FileOnDisk.method1387(this);
      }

      if(gameState != 30) {
         if(gameState == 40 || gameState == 45) {
            class6.method82();
         }
      } else {
         if(field300 > 1) {
            --field300;
         }

         if(field453 > 0) {
            --field453;
         }

         if(field411) {
            field411 = false;
            class177.method3192();
         } else {
            if(!isMenuOpen) {
               menuOptions[0] = "Cancel";
               menuTargets[0] = "";
               menuTypes[0] = 1006;
               menuOptionCount = 1;
            }

            int var3;
            int var4;
            int var7;
            int var8;
            int var9;
            int var10;
            int var12;
            boolean var26;
            int var27;
            int var28;
            int var32;
            Widget var41;
            String var65;
            Widget var72;
            String var73;
            int var109;
            String var127;
            long var131;
            String var135;
            for(var25 = 0; var25 < 100; ++var25) {
               if(null == class156.field2118) {
                  var26 = false;
               } else {
                  label4414: {
                     String var29;
                     try {
                        var3 = class156.field2118.method2028();
                        if(var3 == 0) {
                           var26 = false;
                           break label4414;
                        }

                        if(packetOpcode == -1) {
                           class156.field2118.method2031(field544.payload, 0, 1);
                           field544.offset = 0;
                           packetOpcode = field544.method2975();
                           field485 = class212.field3132[packetOpcode];
                           --var3;
                        }

                        if(field485 == -1) {
                           if(var3 <= 0) {
                              var26 = false;
                              break label4414;
                           }

                           class156.field2118.method2031(field544.payload, 0, 1);
                           field485 = field544.payload[0] & 255;
                           --var3;
                        }

                        if(field485 == -2) {
                           if(var3 <= 1) {
                              var26 = false;
                              break label4414;
                           }

                           class156.field2118.method2031(field544.payload, 0, 2);
                           field544.offset = 0;
                           field485 = field544.readUnsignedShort();
                           var3 -= 2;
                        }

                        if(var3 < field485) {
                           var26 = false;
                           break label4414;
                        }

                        field544.offset = 0;
                        class156.field2118.method2031(field544.payload, 0, field485);
                        field332 = 0;
                        field336 = field466;
                        field466 = field319;
                        field319 = packetOpcode;
                        Widget var67;
                        if(packetOpcode == 235) {
                           var4 = field544.method2890();
                           var65 = field544.method2767();
                           var67 = class191.method3433(var4);
                           if(!var65.equals(var67.text)) {
                              var67.text = var65;
                              class94.method1890(var67);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 183) {
                           class156.method2961();
                           energy = field544.readUnsignedByte();
                           field476 = field471;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 253) {
                           class36.field777 = field544.method2788();
                           GameObject.field1599 = field544.method2923();

                           while(field544.offset < field485) {
                              packetOpcode = field544.readUnsignedByte();
                              Item.method775();
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        long var84;
                        if(packetOpcode == 187) {
                           var4 = field544.method2890();
                           var27 = field544.method2797();
                           if(var27 == '\uffff') {
                              var27 = -1;
                           }

                           var28 = field544.method2890();
                           var7 = field544.readUnsignedShort();
                           if(var7 == '\uffff') {
                              var7 = -1;
                           }

                           for(var8 = var27; var8 <= var7; ++var8) {
                              var84 = (long)var8 + ((long)var4 << 32);
                              Node var85 = widgetFlags.method2311(var84);
                              if(null != var85) {
                                 var85.unlink();
                              }

                              widgetFlags.method2312(new class133(var28), var84);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 28) {
                           field300 = field544.method2750() * 30;
                           field476 = field471;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 117) {
                           field489 = field544.readUnsignedByte();
                           if(field489 == 1) {
                              field302 = field544.readUnsignedShort();
                           }

                           if(field489 >= 2 && field489 <= 6) {
                              if(field489 == 2) {
                                 field335 = 64;
                                 field308 = 64;
                              }

                              if(field489 == 3) {
                                 field335 = 0;
                                 field308 = 64;
                              }

                              if(field489 == 4) {
                                 field335 = 128;
                                 field308 = 64;
                              }

                              if(field489 == 5) {
                                 field335 = 64;
                                 field308 = 0;
                              }

                              if(field489 == 6) {
                                 field335 = 64;
                                 field308 = 128;
                              }

                              field489 = 2;
                              field304 = field544.readUnsignedShort();
                              field402 = field544.readUnsignedShort();
                              field306 = field544.readUnsignedByte();
                           }

                           if(field489 == 10) {
                              field303 = field544.readUnsignedShort();
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 190) {
                           var4 = field544.method2750();
                           if(var4 == '\uffff') {
                              var4 = -1;
                           }

                           class168.method3100(var4);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 15) {
                           var4 = field544.readUnsignedShort();
                           if(var4 == '\uffff') {
                              var4 = -1;
                           }

                           var27 = field544.method2800();
                           if(field373 != 0 && var4 != -1) {
                              class116.method2199(class105.field1706, var4, 0, field373, false);
                              field525 = true;
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 48) {
                           field534 = false;

                           for(var4 = 0; var4 < 5; ++var4) {
                              field535[var4] = false;
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 42) {
                           var4 = field544.readUnsignedByte();
                           if(field544.readUnsignedByte() == 0) {
                              grandExchangeOffers[var4] = new XGrandExchangeOffer();
                              field544.offset += 18;
                           } else {
                              --field544.offset;
                              grandExchangeOffers[var4] = new XGrandExchangeOffer(field544, false);
                           }

                           field481 = field471;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 94) {
                           var4 = field544.method2890();
                           var27 = field544.readUnsignedShort();
                           class165.settings[var27] = var4;
                           if(var4 != class165.widgetSettings[var27]) {
                              class165.widgetSettings[var27] = var4;
                           }

                           class47.method835(var27);
                           field472[++field432 - 1 & 31] = var27;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        class159 var116;
                        if(packetOpcode == 147) {
                           field544.offset += 28;
                           if(field544.method2929()) {
                              var116 = field544;
                              var27 = field544.offset - 28;
                              if(class104.field1668 != null) {
                                 try {
                                    class104.field1668.method1356(0L);
                                    class104.field1668.method1366(var116.payload, var27, 24);
                                 } catch (Exception var53) {
                                    ;
                                 }
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 127) {
                           for(var4 = 0; var4 < class187.field2779; ++var4) {
                              class187 var77 = class41.method751(var4);
                              if(var77 != null) {
                                 class165.settings[var4] = 0;
                                 class165.widgetSettings[var4] = 0;
                              }
                           }

                           class156.method2961();
                           field432 += 32;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 150) {
                           var4 = field544.method2844();
                           WidgetNode var76 = (WidgetNode)componentTable.method2311((long)var4);
                           if(var76 != null) {
                              class26.method560(var76, true);
                           }

                           if(null != field450) {
                              class94.method1890(field450);
                              field450 = null;
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 200) {
                           var4 = field544.method2806();
                           var27 = field544.method2798();
                           var67 = class191.method3433(var4);
                           if(var27 != var67.field2255 || var27 == -1) {
                              var67.field2255 = var27;
                              var67.field2330 = 0;
                              var67.field2251 = 0;
                              class94.method1890(var67);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        byte[] var13;
                        Buffer var14;
                        int var15;
                        int var16;
                        int var17;
                        int var18;
                        int var19;
                        String var20;
                        int var21;
                        byte[] var22;
                        String var23;
                        Player var30;
                        byte var31;
                        int var33;
                        Buffer var34;
                        class177 var87;
                        byte var92;
                        boolean var95;
                        boolean var119;
                        if(packetOpcode == 138) {
                           var116 = field544;
                           var27 = field485;
                           var28 = var116.offset;
                           class45.field924 = 0;
                           class171.method3175(var116);

                           for(var7 = 0; var7 < class45.field924; ++var7) {
                              var8 = class45.field917[var7];
                              var30 = cachedPlayers[var8];
                              var10 = var116.readUnsignedByte();
                              if((var10 & 64) != 0) {
                                 var10 += var116.readUnsignedByte() << 8;
                              }

                              var31 = -1;
                              if((var10 & 2) != 0) {
                                 var12 = var116.readUnsignedByte();
                                 var13 = new byte[var12];
                                 var14 = new Buffer(var13);
                                 var116.method2770(var13, 0, var12);
                                 class45.field907[var8] = var14;
                                 var30.method208(var14);
                              }

                              if((var10 & 32) != 0) {
                                 var12 = var116.readUnsignedShort();
                                 if(var12 == '\uffff') {
                                    var12 = -1;
                                 }

                                 var32 = var116.readUnsignedByte();
                                 XGrandExchangeOffer.method38(var30, var12, var32);
                              }

                              if((var10 & 4) != 0) {
                                 var30.interacting = var116.readUnsignedShort();
                                 if(var30.interacting == '\uffff') {
                                    var30.interacting = -1;
                                 }
                              }

                              if((var10 & 1) != 0) {
                                 var30.overhead = var116.method2767();
                                 if(var30.overhead.charAt(0) == 126) {
                                    var30.overhead = var30.overhead.substring(1);
                                    ObjectComposition.method3581(2, var30.name, var30.overhead);
                                 } else if(var30 == class39.localPlayer) {
                                    ObjectComposition.method3581(2, var30.name, var30.overhead);
                                 }

                                 var30.field612 = false;
                                 var30.field615 = 0;
                                 var30.field616 = 0;
                                 var30.field614 = 150;
                              }

                              if((var10 & 128) != 0) {
                                 var12 = var116.readUnsignedByte();
                                 if(var12 > 0) {
                                    for(var32 = 0; var32 < var12; ++var32) {
                                       var15 = -1;
                                       var16 = -1;
                                       var17 = -1;
                                       var33 = var116.method2772();
                                       if(var33 == 32767) {
                                          var33 = var116.method2772();
                                          var16 = var116.method2772();
                                          var15 = var116.method2772();
                                          var17 = var116.method2772();
                                       } else if(var33 != 32766) {
                                          var16 = var116.method2772();
                                       } else {
                                          var33 = -1;
                                       }

                                       var18 = var116.method2772();
                                       var30.method565(var33, var16, var15, var17, gameCycle, var18);
                                    }
                                 }

                                 var32 = var116.readUnsignedByte();
                                 if(var32 > 0) {
                                    for(var33 = 0; var33 < var32; ++var33) {
                                       var15 = var116.method2772();
                                       var16 = var116.method2772();
                                       if(var16 != 32767) {
                                          var17 = var116.method2772();
                                          var18 = var116.readUnsignedByte();
                                          var19 = var16 > 0?var116.readUnsignedByte():var18;
                                          var30.method566(var15, gameCycle, var16, var17, var18, var19);
                                       } else {
                                          var30.method567(var15);
                                       }
                                    }
                                 }
                              }

                              if((var10 & 8) != 0) {
                                 var30.field626 = var116.readUnsignedShort();
                                 if(var30.field652 == 0) {
                                    var30.field649 = var30.field626;
                                    var30.field626 = -1;
                                 }
                              }

                              if((var10 & 16) != 0) {
                                 var12 = var116.readUnsignedShort();
                                 var87 = (class177)XItemContainer.method161(class16.method181(), var116.readUnsignedByte());
                                 var119 = var116.readUnsignedByte() == 1;
                                 var15 = var116.readUnsignedByte();
                                 var16 = var116.offset;
                                 if(null != var30.name && null != var30.composition) {
                                    var95 = false;
                                    if(var87.field2668 && class189.method3399(var30.name)) {
                                       var95 = true;
                                    }

                                    if(!var95 && field407 == 0 && !var30.field245) {
                                       class45.field909.offset = 0;
                                       var116.method2770(class45.field909.payload, 0, var15);
                                       class45.field909.offset = 0;
                                       var34 = class45.field909;

                                       try {
                                          var21 = var34.method2772();
                                          if(var21 > 32767) {
                                             var21 = 32767;
                                          }

                                          var22 = new byte[var21];
                                          var34.offset += class210.field3114.method2688(var34.payload, var34.offset, var22, 0, var21);
                                          var23 = class139.method2528(var22, 0, var21);
                                          var20 = var23;
                                       } catch (Exception var52) {
                                          var20 = "Cabbage";
                                       }

                                       var20 = class209.method3778(class178.method3201(var20));
                                       var30.overhead = var20.trim();
                                       var30.field615 = var12 >> 8;
                                       var30.field616 = var12 & 255;
                                       var30.field614 = 150;
                                       var30.field612 = var119;
                                       var30.inSequence = class39.localPlayer != var30 && var87.field2668 && "" != field532 && var20.toLowerCase().indexOf(field532) == -1;
                                       if(var87.field2666) {
                                          var21 = var119?91:1;
                                       } else {
                                          var21 = var119?90:2;
                                       }

                                       if(var87.field2659 != -1) {
                                          ObjectComposition.method3581(var21, XGrandExchangeOffer.method56(var87.field2659) + var30.name, var20);
                                       } else {
                                          ObjectComposition.method3581(var21, var30.name, var20);
                                       }
                                    }
                                 }

                                 var116.offset = var16 + var15;
                              }

                              if((var10 & 4096) != 0) {
                                 var30.graphic = var116.readUnsignedShort();
                                 var12 = var116.method2844();
                                 var30.field639 = var12 >> 16;
                                 var30.field638 = gameCycle + (var12 & '\uffff');
                                 var30.field636 = 0;
                                 var30.field637 = 0;
                                 if(var30.field638 > gameCycle) {
                                    var30.field636 = -1;
                                 }

                                 if(var30.graphic == '\uffff') {
                                    var30.graphic = -1;
                                 }
                              }

                              if((var10 & 1024) != 0) {
                                 var30.field606 = var116.readByte();
                                 var30.field642 = var116.readByte();
                                 var30.field641 = var116.readByte();
                                 var30.field643 = var116.readByte();
                                 var30.field602 = var116.readUnsignedShort() + gameCycle;
                                 var30.field645 = var116.readUnsignedShort() + gameCycle;
                                 var30.field653 = var116.readUnsignedShort();
                                 if(var30.field263) {
                                    var30.field606 += var30.field264;
                                    var30.field642 += var30.field265;
                                    var30.field641 += var30.field264;
                                    var30.field643 += var30.field265;
                                    var30.field652 = 0;
                                 } else {
                                    var30.field606 += var30.pathX[0];
                                    var30.field642 += var30.pathY[0];
                                    var30.field641 += var30.pathX[0];
                                    var30.field643 += var30.pathY[0];
                                    var30.field652 = 1;
                                 }

                                 var30.field607 = 0;
                              }

                              if((var10 & 2048) != 0) {
                                 class45.field913[var8] = var116.readByte();
                              }

                              if((var10 & 512) != 0) {
                                 var31 = var116.readByte();
                              }

                              if((var10 & 256) != 0) {
                                 for(var12 = 0; var12 < 3; ++var12) {
                                    var30.actions[var12] = var116.method2767();
                                 }
                              }

                              if(var30.field263) {
                                 if(var31 == 127) {
                                    var30.method235(var30.field264, var30.field265);
                                 } else {
                                    if(var31 != -1) {
                                       var92 = var31;
                                    } else {
                                       var92 = class45.field913[var8];
                                    }

                                    var30.method221(var30.field264, var30.field265, var92);
                                 }
                              }
                           }

                           if(var116.offset - var28 != var27) {
                              throw new RuntimeException(var116.offset - var28 + " " + var27);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 255) {
                           var4 = field544.method2797();
                           var27 = field544.method2806();
                           var67 = class191.method3433(var27);
                           if(var67.modelType != 1 || var67.modelId != var4) {
                              var67.modelType = 1;
                              var67.modelId = var4;
                              class94.method1890(var67);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 211) {
                           GameObject.field1599 = field544.readUnsignedByte();
                           class36.field777 = field544.method2786();

                           for(var4 = class36.field777; var4 < 8 + class36.field777; ++var4) {
                              for(var27 = GameObject.field1599; var27 < 8 + GameObject.field1599; ++var27) {
                                 if(groundItemDeque[class171.plane][var4][var27] != null) {
                                    groundItemDeque[class171.plane][var4][var27] = null;
                                    class6.groundItemSpawned(var4, var27);
                                 }
                              }
                           }

                           for(class25 var114 = (class25)field370.method2359(); var114 != null; var114 = (class25)field370.method2361()) {
                              if(var114.field574 >= class36.field777 && var114.field574 < 8 + class36.field777 && var114.field581 >= GameObject.field1599 && var114.field581 < GameObject.field1599 + 8 && var114.field586 == class171.plane) {
                                 var114.field578 = 0;
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 71) {
                           class210.method3868(true);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        boolean var68;
                        if(packetOpcode == 57) {
                           var68 = field544.readUnsignedByte() == 1;
                           if(var68) {
                              Sequence.field3061 = class72.method1385() - field544.method2866();
                              CombatInfoListHolder.field749 = new class1(field544, true);
                           } else {
                              CombatInfoListHolder.field749 = null;
                           }

                           field446 = field471;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 125) {
                           class187.method3381(field544, field485);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        boolean var75;
                        boolean var130;
                        if(packetOpcode == 196) {
                           var4 = field544.method2772();
                           var130 = field544.readUnsignedByte() == 1;
                           var73 = "";
                           var75 = false;
                           if(var130) {
                              var73 = field544.method2767();
                              if(class189.method3399(var73)) {
                                 var75 = true;
                              }
                           }

                           String var129 = field544.method2767();
                           if(!var75) {
                              ObjectComposition.method3581(var4, var73, var129);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 73) {
                           field554 = 1;
                           field479 = field471;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        String var36;
                        long var94;
                        if(packetOpcode == 45) {
                           var29 = field544.method2767();
                           var131 = (long)field544.readUnsignedShort();
                           var94 = (long)field544.read24BitInt();
                           class177 var108 = (class177)XItemContainer.method161(class16.method181(), field544.readUnsignedByte());
                           long var91 = var94 + (var131 << 32);
                           boolean var98 = false;

                           for(var32 = 0; var32 < 100; ++var32) {
                              if(field443[var32] == var91) {
                                 var98 = true;
                                 break;
                              }
                           }

                           if(class189.method3399(var29)) {
                              var98 = true;
                           }

                           if(!var98 && field407 == 0) {
                              field443[field508] = var91;
                              field508 = (field508 + 1) % 100;
                              class159 var90 = field544;

                              try {
                                 var16 = var90.method2772();
                                 if(var16 > 32767) {
                                    var16 = 32767;
                                 }

                                 byte[] var125 = new byte[var16];
                                 var90.offset += class210.field3114.method2688(var90.payload, var90.offset, var125, 0, var16);
                                 var36 = class139.method2528(var125, 0, var16);
                                 var127 = var36;
                              } catch (Exception var51) {
                                 var127 = "Cabbage";
                              }

                              var127 = class209.method3778(class178.method3201(var127));
                              byte var97;
                              if(var108.field2666) {
                                 var97 = 7;
                              } else {
                                 var97 = 3;
                              }

                              if(var108.field2659 != -1) {
                                 var19 = var108.field2659;
                                 var36 = "<img=" + var19 + ">";
                                 ObjectComposition.method3581(var97, var36 + var29, var127);
                              } else {
                                 ObjectComposition.method3581(var97, var29, var127);
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 251) {
                           class156.method2961();
                           weight = field544.method2762();
                           field476 = field471;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        long var96;
                        if(packetOpcode == 19) {
                           var29 = field544.method2767();
                           var131 = field544.method2866();
                           var94 = (long)field544.readUnsignedShort();
                           var84 = (long)field544.read24BitInt();
                           class177 var11 = (class177)XItemContainer.method161(class16.method181(), field544.readUnsignedByte());
                           var96 = (var94 << 32) + var84;
                           var119 = false;

                           for(var15 = 0; var15 < 100; ++var15) {
                              if(field443[var15] == var96) {
                                 var119 = true;
                                 break;
                              }
                           }

                           if(var11.field2668 && class189.method3399(var29)) {
                              var119 = true;
                           }

                           if(!var119 && field407 == 0) {
                              field443[field508] = var96;
                              field508 = (field508 + 1) % 100;
                              class159 var40 = field544;

                              String var38;
                              try {
                                 var18 = var40.method2772();
                                 if(var18 > 32767) {
                                    var18 = 32767;
                                 }

                                 byte[] var117 = new byte[var18];
                                 var40.offset += class210.field3114.method2688(var40.payload, var40.offset, var117, 0, var18);
                                 var20 = class139.method2528(var117, 0, var18);
                                 var38 = var20;
                              } catch (Exception var50) {
                                 var38 = "Cabbage";
                              }

                              var38 = class209.method3778(class178.method3201(var38));
                              if(var11.field2659 != -1) {
                                 var19 = var11.field2659;
                                 var36 = "<img=" + var19 + ">";
                                 class13.addChatMessage(9, var36 + var29, var38, class172.method3177(var131));
                              } else {
                                 class13.addChatMessage(9, var29, var38, class172.method3177(var131));
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        String var138;
                        if(packetOpcode == 33) {
                           while(field544.offset < field485) {
                              var4 = field544.readUnsignedByte();
                              var130 = (var4 & 1) == 1;
                              var73 = field544.method2767();
                              var138 = field544.method2767();
                              field544.method2767();

                              for(var8 = 0; var8 < ignoreCount; ++var8) {
                                 Ignore var107 = ignores[var8];
                                 if(var130) {
                                    if(var138.equals(var107.name)) {
                                       var107.name = var73;
                                       var107.previousName = var138;
                                       var73 = null;
                                       break;
                                    }
                                 } else if(var73.equals(var107.name)) {
                                    var107.name = var73;
                                    var107.previousName = var138;
                                    var73 = null;
                                    break;
                                 }
                              }

                              if(null != var73 && ignoreCount < 400) {
                                 Ignore var128 = new Ignore();
                                 ignores[ignoreCount] = var128;
                                 var128.name = var73;
                                 var128.previousName = var138;
                                 ++ignoreCount;
                              }
                           }

                           field479 = field471;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 123) {
                           var4 = field544.method2807();
                           class6.field60 = class41.field855.method1928(var4);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        WidgetNode var132;
                        if(packetOpcode == 31) {
                           var4 = field544.method2806();
                           var27 = field544.readUnsignedShort();
                           var28 = field544.readUnsignedByte();
                           var132 = (WidgetNode)componentTable.method2311((long)var4);
                           if(null != var132) {
                              class26.method560(var132, var27 != var132.id);
                           }

                           Player.method234(var4, var27, var28);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 248) {
                           class36.field777 = field544.method2786();
                           GameObject.field1599 = field544.readUnsignedByte();
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 141) {
                           class165.method3061();

                           for(var4 = 0; var4 < 2048; ++var4) {
                              cachedPlayers[var4] = null;
                           }

                           method439(field544);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 43) {
                           var4 = field544.method2844();
                           var27 = field544.readUnsignedShort();
                           if(var4 < -70000) {
                              var27 += '耀';
                           }

                           if(var4 >= 0) {
                              var67 = class191.method3433(var4);
                           } else {
                              var67 = null;
                           }

                           if(null != var67) {
                              for(var7 = 0; var7 < var67.itemIds.length; ++var7) {
                                 var67.itemIds[var7] = 0;
                                 var67.itemQuantities[var7] = 0;
                              }
                           }

                           XItemContainer var143 = (XItemContainer)XItemContainer.itemContainers.method2311((long)var27);
                           if(var143 != null) {
                              for(var8 = 0; var8 < var143.itemIds.length; ++var8) {
                                 var143.itemIds[var8] = -1;
                                 var143.stackSizes[var8] = 0;
                              }
                           }

                           var7 = field544.readUnsignedShort();

                           for(var8 = 0; var8 < var7; ++var8) {
                              var9 = field544.method2786();
                              if(var9 == 255) {
                                 var9 = field544.method2844();
                              }

                              var10 = field544.readUnsignedShort();
                              if(var67 != null && var8 < var67.itemIds.length) {
                                 var67.itemIds[var8] = var10;
                                 var67.itemQuantities[var8] = var9;
                              }

                              ChatLineBuffer.method871(var27, var8, var10 - 1, var9);
                           }

                           if(null != var67) {
                              class94.method1890(var67);
                           }

                           class156.method2961();
                           field474[++field365 - 1 & 31] = var27 & 32767;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 177) {
                           class210.method3868(false);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 169) {
                           var4 = field485 + field544.offset;
                           var27 = field544.readUnsignedShort();
                           var28 = field544.readUnsignedShort();
                           if(widgetRoot != var27) {
                              widgetRoot = var27;
                              class39.method710(false);
                              class137.method2434(widgetRoot);
                              class176.method3185(widgetRoot);

                              for(var7 = 0; var7 < 100; ++var7) {
                                 field524[var7] = true;
                              }
                           }

                           WidgetNode var137;
                           for(; var28-- > 0; var137.field178 = true) {
                              var7 = field544.method2844();
                              var8 = field544.readUnsignedShort();
                              var9 = field544.readUnsignedByte();
                              var137 = (WidgetNode)componentTable.method2311((long)var7);
                              if(var137 != null && var137.id != var8) {
                                 class26.method560(var137, true);
                                 var137 = null;
                              }

                              if(null == var137) {
                                 var137 = Player.method234(var7, var8, var9);
                              }
                           }

                           for(var132 = (WidgetNode)componentTable.method2313(); null != var132; var132 = (WidgetNode)componentTable.method2321()) {
                              if(var132.field178) {
                                 var132.field178 = false;
                              } else {
                                 class26.method560(var132, true);
                              }
                           }

                           widgetFlags = new XHashTable(512);

                           while(field544.offset < var4) {
                              var7 = field544.method2844();
                              var8 = field544.readUnsignedShort();
                              var9 = field544.readUnsignedShort();
                              var10 = field544.method2844();

                              for(var109 = var8; var109 <= var9; ++var109) {
                                 var96 = (long)var109 + ((long)var7 << 32);
                                 widgetFlags.method2312(new class133(var10), var96);
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 112) {
                           var4 = field544.method2890();
                           var27 = field544.readUnsignedShort();
                           var67 = class191.method3433(var4);
                           if(var67.modelType != 2 || var27 != var67.modelId) {
                              var67.modelType = 2;
                              var67.modelId = var27;
                              class94.method1890(var67);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 24) {
                           var29 = field544.method2767();
                           class159 var82 = field544;

                           try {
                              var8 = var82.method2772();
                              if(var8 > 32767) {
                                 var8 = 32767;
                              }

                              byte[] var106 = new byte[var8];
                              var82.offset += class210.field3114.method2688(var82.payload, var82.offset, var106, 0, var8);
                              var135 = class139.method2528(var106, 0, var8);
                              var138 = var135;
                           } catch (Exception var49) {
                              var138 = "Cabbage";
                           }

                           var138 = class209.method3778(class178.method3201(var138));
                           ObjectComposition.method3581(6, var29, var138);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 113) {
                           flagX = field544.readUnsignedByte();
                           if(flagX == 255) {
                              flagX = 0;
                           }

                           flagY = field544.readUnsignedByte();
                           if(flagY == 255) {
                              flagY = 0;
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 35) {
                           var4 = field544.readUnsignedShort();
                           widgetRoot = var4;
                           class39.method710(false);
                           class137.method2434(var4);
                           class176.method3185(widgetRoot);

                           for(var27 = 0; var27 < 100; ++var27) {
                              field524[var27] = true;
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 137) {
                           field504 = field544.readUnsignedByte();
                           field505 = field544.readUnsignedByte();
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 128) {
                           for(var4 = 0; var4 < class165.widgetSettings.length; ++var4) {
                              if(class165.widgetSettings[var4] != class165.settings[var4]) {
                                 class165.widgetSettings[var4] = class165.settings[var4];
                                 class47.method835(var4);
                                 field472[++field432 - 1 & 31] = var4;
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 162) {
                           var4 = field544.method2844();
                           var72 = class191.method3433(var4);
                           var72.modelType = 3;
                           var72.modelId = class39.localPlayer.composition.method3087();
                           class94.method1890(var72);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 130) {
                           var4 = field544.method2844();
                           var27 = field544.method2795();
                           var28 = var27 >> 10 & 31;
                           var7 = var27 >> 5 & 31;
                           var8 = var27 & 31;
                           var9 = (var8 << 3) + (var28 << 19) + (var7 << 11);
                           Widget var134 = class191.method3433(var4);
                           if(var134.textColor != var9) {
                              var134.textColor = var9;
                              class94.method1890(var134);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 189) {
                           var4 = field544.method2844();
                           var27 = field544.readUnsignedShort();
                           if(var4 < -70000) {
                              var27 += '耀';
                           }

                           if(var4 >= 0) {
                              var67 = class191.method3433(var4);
                           } else {
                              var67 = null;
                           }

                           for(; field544.offset < field485; ChatLineBuffer.method871(var27, var7, var8 - 1, var9)) {
                              var7 = field544.method2772();
                              var8 = field544.readUnsignedShort();
                              var9 = 0;
                              if(var8 != 0) {
                                 var9 = field544.readUnsignedByte();
                                 if(var9 == 255) {
                                    var9 = field544.method2844();
                                 }
                              }

                              if(null != var67 && var7 >= 0 && var7 < var67.itemIds.length) {
                                 var67.itemIds[var7] = var8;
                                 var67.itemQuantities[var7] = var9;
                              }
                           }

                           if(var67 != null) {
                              class94.method1890(var67);
                           }

                           class156.method2961();
                           field474[++field365 - 1 & 31] = var27 & 32767;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 254) {
                           var4 = field544.readUnsignedShort();
                           var27 = field544.readUnsignedByte();
                           var28 = field544.readUnsignedShort();
                           if(field482 != 0 && var27 != 0 && field528 < 50) {
                              field529[field528] = var4;
                              field409[field528] = var27;
                              field439[field528] = var28;
                              field533[field528] = null;
                              field483[field528] = 0;
                              ++field528;
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 160) {
                           var29 = field544.method2767();
                           CombatInfoListHolder.field756 = var29;

                           try {
                              var65 = field282.getParameter(class214.field3156.field3159);
                              var73 = field282.getParameter(class214.field3147.field3159);
                              var138 = var65 + "settings=" + var29 + "; version=1; path=/; domain=" + var73;
                              if(var29.length() == 0) {
                                 var138 = var138 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                              } else {
                                 var138 = var138 + "; Expires=" + class5.method69(class72.method1385() + 94608000000L) + "; Max-Age=" + 94608000L;
                              }

                              class100.method1915(field282, "document.cookie=\"" + var138 + "\"");
                           } catch (Throwable var48) {
                              ;
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 111) {
                           field522 = field544.readUnsignedByte();
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 163) {
                           field534 = true;
                           class94.field1578 = field544.readUnsignedByte();
                           class33.field744 = field544.readUnsignedByte();
                           class148.field2038 = field544.readUnsignedShort();
                           class45.field921 = field544.readUnsignedByte();
                           class3.field34 = field544.readUnsignedByte();
                           if(class3.field34 >= 100) {
                              WidgetNode.cameraX = class94.field1578 * 128 + 64;
                              class2.cameraY = 64 + class33.field744 * 128;
                              MessageNode.cameraZ = class85.method1686(WidgetNode.cameraX, class2.cameraY, class171.plane) - class148.field2038;
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 103) {
                           var4 = field544.method2890();
                           var72 = class191.method3433(var4);

                           for(var28 = 0; var28 < var72.itemIds.length; ++var28) {
                              var72.itemIds[var28] = -1;
                              var72.itemIds[var28] = 0;
                           }

                           class94.method1890(var72);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 250) {
                           var4 = field544.method2844();
                           var27 = field544.method2844();
                           if(null == class181.field2699 || !class181.field2699.isValid()) {
                              try {
                                 Iterator var74 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                                 while(var74.hasNext()) {
                                    GarbageCollectorMXBean var136 = (GarbageCollectorMXBean)var74.next();
                                    if(var136.isValid()) {
                                       class181.field2699 = var136;
                                       field564 = -1L;
                                       field459 = -1L;
                                    }
                                 }
                              } catch (Throwable var56) {
                                 ;
                              }
                           }

                           long var111 = class72.method1385();
                           var8 = -1;
                           if(class181.field2699 != null) {
                              var84 = class181.field2699.getCollectionTime();
                              if(-1L != field459) {
                                 long var115 = var84 - field459;
                                 long var118 = var111 - field564;
                                 if(var118 != 0L) {
                                    var8 = (int)(100L * var115 / var118);
                                 }
                              }

                              field459 = var84;
                              field564 = var111;
                           }

                           field294.method2976(160);
                           field294.method2893(var4);
                           field294.method2893(var27);
                           field294.method2785(GameEngine.field1764);
                           field294.method2932(var8);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 133) {
                           var29 = field544.method2767();
                           var27 = field544.method2923();
                           var28 = field544.method2788();
                           if(var28 >= 1 && var28 <= 8) {
                              if(var29.equalsIgnoreCase("null")) {
                                 var29 = null;
                              }

                              field415[var28 - 1] = var29;
                              field416[var28 - 1] = var27 == 0;
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 51 || packetOpcode == 203 || packetOpcode == 18 || packetOpcode == 16 || packetOpcode == 215 || packetOpcode == 216 || packetOpcode == 83 || packetOpcode == 155 || packetOpcode == 218 || packetOpcode == 192) {
                           Item.method775();
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 53) {
                           var4 = field544.method2750();
                           XItemContainer var69 = (XItemContainer)XItemContainer.itemContainers.method2311((long)var4);
                           if(null != var69) {
                              var69.unlink();
                           }

                           field474[++field365 - 1 & 31] = var4 & 32767;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 180) {
                           if(widgetRoot != -1) {
                              class32.method656(widgetRoot, 0);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 238) {
                           while(field544.offset < field485) {
                              var68 = field544.readUnsignedByte() == 1;
                              var65 = field544.method2767();
                              var73 = field544.method2767();
                              var7 = field544.readUnsignedShort();
                              var8 = field544.readUnsignedByte();
                              var9 = field544.readUnsignedByte();
                              boolean var88 = (var9 & 2) != 0;
                              boolean var113 = (var9 & 1) != 0;
                              if(var7 > 0) {
                                 field544.method2767();
                                 field544.readUnsignedByte();
                                 field544.method2844();
                              }

                              field544.method2767();

                              for(var12 = 0; var12 < friendCount; ++var12) {
                                 Friend var89 = friends[var12];
                                 if(!var68) {
                                    if(var65.equals(var89.name)) {
                                       if(var89.world != var7) {
                                          var119 = true;

                                          for(class16 var39 = (class16)field556.method2399(); var39 != null; var39 = (class16)field556.method2395()) {
                                             if(var39.field169.equals(var65)) {
                                                if(var7 != 0 && var39.field175 == 0) {
                                                   var39.method2406();
                                                   var119 = false;
                                                } else if(var7 == 0 && var39.field175 != 0) {
                                                   var39.method2406();
                                                   var119 = false;
                                                }
                                             }
                                          }

                                          if(var119) {
                                             field556.method2393(new class16(var65, var7));
                                          }

                                          var89.world = var7;
                                       }

                                       var89.previousName = var73;
                                       var89.rank = var8;
                                       var89.field157 = var88;
                                       var89.field149 = var113;
                                       var65 = null;
                                       break;
                                    }
                                 } else if(var73.equals(var89.name)) {
                                    var89.name = var65;
                                    var89.previousName = var73;
                                    var65 = null;
                                    break;
                                 }
                              }

                              if(null != var65 && friendCount < 400) {
                                 Friend var43 = new Friend();
                                 friends[friendCount] = var43;
                                 var43.name = var65;
                                 var43.previousName = var73;
                                 var43.world = var7;
                                 var43.rank = var8;
                                 var43.field157 = var88;
                                 var43.field149 = var113;
                                 ++friendCount;
                              }
                           }

                           field554 = 2;
                           field479 = field471;
                           var68 = false;
                           var27 = friendCount;

                           while(var27 > 0) {
                              var68 = true;
                              --var27;

                              for(var28 = 0; var28 < var27; ++var28) {
                                 var75 = false;
                                 Friend var126 = friends[var28];
                                 Friend var105 = friends[1 + var28];
                                 if(world != var126.world && world == var105.world) {
                                    var75 = true;
                                 }

                                 if(!var75 && var126.world == 0 && var105.world != 0) {
                                    var75 = true;
                                 }

                                 if(!var75 && !var126.field157 && var105.field157) {
                                    var75 = true;
                                 }

                                 if(!var75 && !var126.field149 && var105.field149) {
                                    var75 = true;
                                 }

                                 if(var75) {
                                    Friend var42 = friends[var28];
                                    friends[var28] = friends[1 + var28];
                                    friends[1 + var28] = var42;
                                    var68 = false;
                                 }
                              }

                              if(var68) {
                                 break;
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 142) {
                           var4 = field544.method2750();
                           var27 = field544.readUnsignedShort();
                           var28 = field544.method2807();
                           var41 = class191.method3433(var28);
                           var41.field2244 = (var4 << 16) + var27;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 32) {
                           byte var80 = field544.method2920();
                           var27 = field544.method2750();
                           class165.settings[var27] = var80;
                           if(class165.widgetSettings[var27] != var80) {
                              class165.widgetSettings[var27] = var80;
                           }

                           class47.method835(var27);
                           field472[++field432 - 1 & 31] = var27;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 84) {
                           field534 = true;
                           class203.field3072 = field544.readUnsignedByte();
                           class178.field2680 = field544.readUnsignedByte();
                           class154.field2105 = field544.readUnsignedShort();
                           class118.field1842 = field544.readUnsignedByte();
                           Item.field891 = field544.readUnsignedByte();
                           if(Item.field891 >= 100) {
                              var4 = class203.field3072 * 128 + 64;
                              var27 = class178.field2680 * 128 + 64;
                              var28 = class85.method1686(var4, var27, class171.plane) - class154.field2105;
                              var7 = var4 - WidgetNode.cameraX;
                              var8 = var28 - MessageNode.cameraZ;
                              var9 = var27 - class2.cameraY;
                              var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                              Buffer.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                              class39.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                              if(Buffer.cameraPitch < 128) {
                                 Buffer.cameraPitch = 128;
                              }

                              if(Buffer.cameraPitch > 383) {
                                 Buffer.cameraPitch = 383;
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 27) {
                           class156.method2961();
                           var4 = field544.method2786();
                           var27 = field544.method2786();
                           var28 = field544.method2807();
                           skillExperiences[var27] = var28;
                           boostedSkillLevels[var27] = var4;
                           realSkillLevels[var27] = 1;

                           for(var7 = 0; var7 < 98; ++var7) {
                              if(var28 >= class172.field2357[var7]) {
                                 realSkillLevels[var27] = var7 + 2;
                              }
                           }

                           field285[++field379 - 1 & 31] = var27;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 131) {
                           var4 = field544.method2844();
                           var27 = field544.method2798();
                           var28 = field544.method2799();
                           var41 = class191.method3433(var4);
                           if(var41.field2288 != var27 || var41.field2218 != var28 || var41.field2213 != 0 || var41.field2214 != 0) {
                              var41.field2288 = var27;
                              var41.field2218 = var28;
                              var41.field2213 = 0;
                              var41.field2214 = 0;
                              class94.method1890(var41);
                              FrameMap.method1687(var41);
                              if(var41.type == 0) {
                                 class2.method18(Widget.widgets[var4 >> 16], var41, false);
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        class159 var5;
                        if(packetOpcode == 194) {
                           CollisionData.xteaChanged(false);
                           field544.method2975();
                           var4 = field544.readUnsignedShort();
                           var5 = field544;
                           var28 = var5.offset;
                           class45.field924 = 0;
                           class171.method3175(var5);

                           for(var7 = 0; var7 < class45.field924; ++var7) {
                              var8 = class45.field917[var7];
                              var30 = cachedPlayers[var8];
                              var10 = var5.readUnsignedByte();
                              if((var10 & 64) != 0) {
                                 var10 += var5.readUnsignedByte() << 8;
                              }

                              var31 = -1;
                              if((var10 & 2) != 0) {
                                 var12 = var5.readUnsignedByte();
                                 var13 = new byte[var12];
                                 var14 = new Buffer(var13);
                                 var5.method2770(var13, 0, var12);
                                 class45.field907[var8] = var14;
                                 var30.method208(var14);
                              }

                              if((var10 & 32) != 0) {
                                 var12 = var5.readUnsignedShort();
                                 if(var12 == '\uffff') {
                                    var12 = -1;
                                 }

                                 var32 = var5.readUnsignedByte();
                                 XGrandExchangeOffer.method38(var30, var12, var32);
                              }

                              if((var10 & 4) != 0) {
                                 var30.interacting = var5.readUnsignedShort();
                                 if(var30.interacting == '\uffff') {
                                    var30.interacting = -1;
                                 }
                              }

                              if((var10 & 1) != 0) {
                                 var30.overhead = var5.method2767();
                                 if(var30.overhead.charAt(0) == 126) {
                                    var30.overhead = var30.overhead.substring(1);
                                    ObjectComposition.method3581(2, var30.name, var30.overhead);
                                 } else if(var30 == class39.localPlayer) {
                                    ObjectComposition.method3581(2, var30.name, var30.overhead);
                                 }

                                 var30.field612 = false;
                                 var30.field615 = 0;
                                 var30.field616 = 0;
                                 var30.field614 = 150;
                              }

                              if((var10 & 128) != 0) {
                                 var12 = var5.readUnsignedByte();
                                 if(var12 > 0) {
                                    for(var32 = 0; var32 < var12; ++var32) {
                                       var15 = -1;
                                       var16 = -1;
                                       var17 = -1;
                                       var33 = var5.method2772();
                                       if(var33 == 32767) {
                                          var33 = var5.method2772();
                                          var16 = var5.method2772();
                                          var15 = var5.method2772();
                                          var17 = var5.method2772();
                                       } else if(var33 != 32766) {
                                          var16 = var5.method2772();
                                       } else {
                                          var33 = -1;
                                       }

                                       var18 = var5.method2772();
                                       var30.method565(var33, var16, var15, var17, gameCycle, var18);
                                    }
                                 }

                                 var32 = var5.readUnsignedByte();
                                 if(var32 > 0) {
                                    for(var33 = 0; var33 < var32; ++var33) {
                                       var15 = var5.method2772();
                                       var16 = var5.method2772();
                                       if(var16 != 32767) {
                                          var17 = var5.method2772();
                                          var18 = var5.readUnsignedByte();
                                          var19 = var16 > 0?var5.readUnsignedByte():var18;
                                          var30.method566(var15, gameCycle, var16, var17, var18, var19);
                                       } else {
                                          var30.method567(var15);
                                       }
                                    }
                                 }
                              }

                              if((var10 & 8) != 0) {
                                 var30.field626 = var5.readUnsignedShort();
                                 if(var30.field652 == 0) {
                                    var30.field649 = var30.field626;
                                    var30.field626 = -1;
                                 }
                              }

                              if((var10 & 16) != 0) {
                                 var12 = var5.readUnsignedShort();
                                 var87 = (class177)XItemContainer.method161(class16.method181(), var5.readUnsignedByte());
                                 var119 = var5.readUnsignedByte() == 1;
                                 var15 = var5.readUnsignedByte();
                                 var16 = var5.offset;
                                 if(null != var30.name && null != var30.composition) {
                                    var95 = false;
                                    if(var87.field2668 && class189.method3399(var30.name)) {
                                       var95 = true;
                                    }

                                    if(!var95 && field407 == 0 && !var30.field245) {
                                       class45.field909.offset = 0;
                                       var5.method2770(class45.field909.payload, 0, var15);
                                       class45.field909.offset = 0;
                                       var34 = class45.field909;

                                       try {
                                          var21 = var34.method2772();
                                          if(var21 > 32767) {
                                             var21 = 32767;
                                          }

                                          var22 = new byte[var21];
                                          var34.offset += class210.field3114.method2688(var34.payload, var34.offset, var22, 0, var21);
                                          var23 = class139.method2528(var22, 0, var21);
                                          var20 = var23;
                                       } catch (Exception var47) {
                                          var20 = "Cabbage";
                                       }

                                       var20 = class209.method3778(class178.method3201(var20));
                                       var30.overhead = var20.trim();
                                       var30.field615 = var12 >> 8;
                                       var30.field616 = var12 & 255;
                                       var30.field614 = 150;
                                       var30.field612 = var119;
                                       var30.inSequence = class39.localPlayer != var30 && var87.field2668 && "" != field532 && var20.toLowerCase().indexOf(field532) == -1;
                                       if(var87.field2666) {
                                          var21 = var119?91:1;
                                       } else {
                                          var21 = var119?90:2;
                                       }

                                       if(var87.field2659 != -1) {
                                          ObjectComposition.method3581(var21, XGrandExchangeOffer.method56(var87.field2659) + var30.name, var20);
                                       } else {
                                          ObjectComposition.method3581(var21, var30.name, var20);
                                       }
                                    }
                                 }

                                 var5.offset = var15 + var16;
                              }

                              if((var10 & 4096) != 0) {
                                 var30.graphic = var5.readUnsignedShort();
                                 var12 = var5.method2844();
                                 var30.field639 = var12 >> 16;
                                 var30.field638 = gameCycle + (var12 & '\uffff');
                                 var30.field636 = 0;
                                 var30.field637 = 0;
                                 if(var30.field638 > gameCycle) {
                                    var30.field636 = -1;
                                 }

                                 if(var30.graphic == '\uffff') {
                                    var30.graphic = -1;
                                 }
                              }

                              if((var10 & 1024) != 0) {
                                 var30.field606 = var5.readByte();
                                 var30.field642 = var5.readByte();
                                 var30.field641 = var5.readByte();
                                 var30.field643 = var5.readByte();
                                 var30.field602 = var5.readUnsignedShort() + gameCycle;
                                 var30.field645 = var5.readUnsignedShort() + gameCycle;
                                 var30.field653 = var5.readUnsignedShort();
                                 if(var30.field263) {
                                    var30.field606 += var30.field264;
                                    var30.field642 += var30.field265;
                                    var30.field641 += var30.field264;
                                    var30.field643 += var30.field265;
                                    var30.field652 = 0;
                                 } else {
                                    var30.field606 += var30.pathX[0];
                                    var30.field642 += var30.pathY[0];
                                    var30.field641 += var30.pathX[0];
                                    var30.field643 += var30.pathY[0];
                                    var30.field652 = 1;
                                 }

                                 var30.field607 = 0;
                              }

                              if((var10 & 2048) != 0) {
                                 class45.field913[var8] = var5.readByte();
                              }

                              if((var10 & 512) != 0) {
                                 var31 = var5.readByte();
                              }

                              if((var10 & 256) != 0) {
                                 for(var12 = 0; var12 < 3; ++var12) {
                                    var30.actions[var12] = var5.method2767();
                                 }
                              }

                              if(var30.field263) {
                                 if(var31 == 127) {
                                    var30.method235(var30.field264, var30.field265);
                                 } else {
                                    if(var31 != -1) {
                                       var92 = var31;
                                    } else {
                                       var92 = class45.field913[var8];
                                    }

                                    var30.method221(var30.field264, var30.field265, var92);
                                 }
                              }
                           }

                           if(var5.offset - var28 != var4) {
                              throw new RuntimeException(var5.offset - var28 + " " + var4);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 50) {
                           var27 = field544.readUnsignedByte();
                           class216[] var70 = class39.method711();
                           var7 = 0;

                           class216 var104;
                           while(true) {
                              if(var7 >= var70.length) {
                                 var104 = null;
                                 break;
                              }

                              class216 var124 = var70[var7];
                              if(var27 == var124.field3166) {
                                 var104 = var124;
                                 break;
                              }

                              ++var7;
                           }

                           Item.field889 = var104;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        boolean var78;
                        if(packetOpcode == 124) {
                           var29 = field544.method2767();
                           var27 = field544.readUnsignedShort();
                           byte var102 = field544.readByte();
                           var75 = false;
                           if(var102 == -128) {
                              var75 = true;
                           }

                           if(var75) {
                              if(class13.field136 == 0) {
                                 packetOpcode = -1;
                                 var26 = true;
                                 break label4414;
                              }

                              var78 = false;

                              for(var8 = 0; var8 < class13.field136 && (!class8.clanMembers[var8].username.equals(var29) || var27 != class8.clanMembers[var8].world); ++var8) {
                                 ;
                              }

                              if(var8 < class13.field136) {
                                 while(var8 < class13.field136 - 1) {
                                    class8.clanMembers[var8] = class8.clanMembers[var8 + 1];
                                    ++var8;
                                 }

                                 --class13.field136;
                                 class8.clanMembers[class13.field136] = null;
                              }
                           } else {
                              field544.method2767();
                              XClanMember var123 = new XClanMember();
                              var123.username = var29;
                              var123.field271 = class118.method2244(var123.username, class108.field1724);
                              var123.world = var27;
                              var123.rank = var102;

                              for(var9 = class13.field136 - 1; var9 >= 0; --var9) {
                                 var10 = class8.clanMembers[var9].field271.compareTo(var123.field271);
                                 if(var10 == 0) {
                                    class8.clanMembers[var9].world = var27;
                                    class8.clanMembers[var9].rank = var102;
                                    if(var29.equals(class39.localPlayer.name)) {
                                       class20.field218 = var102;
                                    }

                                    field480 = field471;
                                    packetOpcode = -1;
                                    var26 = true;
                                    break label4414;
                                 }

                                 if(var10 < 0) {
                                    break;
                                 }
                              }

                              if(class13.field136 >= class8.clanMembers.length) {
                                 packetOpcode = -1;
                                 var26 = true;
                                 break label4414;
                              }

                              for(var10 = class13.field136 - 1; var10 > var9; --var10) {
                                 class8.clanMembers[1 + var10] = class8.clanMembers[var10];
                              }

                              if(class13.field136 == 0) {
                                 class8.clanMembers = new XClanMember[100];
                              }

                              class8.clanMembers[var9 + 1] = var123;
                              ++class13.field136;
                              if(var29.equals(class39.localPlayer.name)) {
                                 class20.field218 = var102;
                              }
                           }

                           field480 = field471;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 237) {
                           var4 = field544.method2890();
                           var27 = field544.method2750();
                           var67 = class191.method3433(var4);
                           if(var67 != null && var67.type == 0) {
                              if(var27 > var67.scrollHeight - var67.height) {
                                 var27 = var67.scrollHeight - var67.height;
                              }

                              if(var27 < 0) {
                                 var27 = 0;
                              }

                              if(var67.scrollY != var27) {
                                 var67.scrollY = var27;
                                 class94.method1890(var67);
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 75) {
                           class10.method146();
                           packetOpcode = -1;
                           var26 = false;
                           break label4414;
                        }

                        if(packetOpcode == 167) {
                           field480 = field471;
                           if(field485 == 0) {
                              field513 = null;
                              clanChatOwner = null;
                              class13.field136 = 0;
                              class8.clanMembers = null;
                              packetOpcode = -1;
                              var26 = true;
                              break label4414;
                           }

                           clanChatOwner = field544.method2767();
                           long var71 = field544.method2866();
                           field513 = WallObject.method1863(var71);
                           World.field683 = field544.readByte();
                           var28 = field544.readUnsignedByte();
                           if(var28 == 255) {
                              packetOpcode = -1;
                              var26 = true;
                              break label4414;
                           }

                           class13.field136 = var28;
                           XClanMember[] var133 = new XClanMember[100];

                           for(var8 = 0; var8 < class13.field136; ++var8) {
                              var133[var8] = new XClanMember();
                              var133[var8].username = field544.method2767();
                              var133[var8].field271 = class118.method2244(var133[var8].username, class108.field1724);
                              var133[var8].world = field544.readUnsignedShort();
                              var133[var8].rank = field544.readByte();
                              field544.method2767();
                              if(var133[var8].username.equals(class39.localPlayer.name)) {
                                 class20.field218 = var133[var8].rank;
                              }
                           }

                           var78 = false;
                           var10 = class13.field136;

                           while(var10 > 0) {
                              var78 = true;
                              --var10;

                              for(var109 = 0; var109 < var10; ++var109) {
                                 if(var133[var109].field271.compareTo(var133[var109 + 1].field271) > 0) {
                                    XClanMember var103 = var133[var109];
                                    var133[var109] = var133[var109 + 1];
                                    var133[1 + var109] = var103;
                                    var78 = false;
                                 }
                              }

                              if(var78) {
                                 break;
                              }
                           }

                           class8.clanMembers = var133;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 153) {
                           var68 = field544.readUnsignedByte() == 1;
                           var27 = field544.method2807();
                           var67 = class191.method3433(var27);
                           if(var67.isHidden != var68) {
                              var67.isHidden = var68;
                              class94.method1890(var67);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 198) {
                           var4 = field544.readUnsignedByte();
                           var27 = field544.readUnsignedByte();
                           var28 = field544.readUnsignedByte();
                           var7 = field544.readUnsignedByte();
                           field535[var4] = true;
                           field420[var4] = var27;
                           field393[var4] = var28;
                           field538[var4] = var7;
                           field539[var4] = 0;
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 82) {
                           var29 = field544.method2767();
                           Object[] var64 = new Object[var29.length() + 1];

                           for(var28 = var29.length() - 1; var28 >= 0; --var28) {
                              if(var29.charAt(var28) == 115) {
                                 var64[var28 + 1] = field544.method2767();
                              } else {
                                 var64[var28 + 1] = new Integer(field544.method2844());
                              }
                           }

                           var64[0] = new Integer(field544.method2844());
                           class18 var66 = new class18();
                           var66.field188 = var64;
                           Ignore.method191(var66);
                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        Widget var122;
                        if(packetOpcode == 220) {
                           var4 = field544.method2806();
                           var27 = field544.method2750();
                           var28 = field544.method2750();
                           var7 = field544.readUnsignedShort();
                           var122 = class191.method3433(var4);
                           if(var7 != var122.rotationX || var122.rotationZ != var27 || var28 != var122.field2262) {
                              var122.rotationX = var7;
                              var122.rotationZ = var27;
                              var122.field2262 = var28;
                              class94.method1890(var122);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 176) {
                           World var101 = new World();
                           var101.address = field544.method2767();
                           var101.id = field544.readUnsignedShort();
                           var27 = field544.method2844();
                           var101.mask = var27;
                           XGrandExchangeOffer.setGameState(45);
                           class156.field2118.method2035();
                           class156.field2118 = null;
                           class47.selectWorld(var101);
                           packetOpcode = -1;
                           var26 = false;
                           break label4414;
                        }

                        if(packetOpcode == 170) {
                           for(var4 = 0; var4 < cachedPlayers.length; ++var4) {
                              if(null != cachedPlayers[var4]) {
                                 cachedPlayers[var4].animation = -1;
                              }
                           }

                           for(var4 = 0; var4 < cachedNPCs.length; ++var4) {
                              if(cachedNPCs[var4] != null) {
                                 cachedNPCs[var4].animation = -1;
                              }
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 100) {
                           var4 = field544.method2844();
                           var27 = field544.method2844();
                           WidgetNode var6 = (WidgetNode)componentTable.method2311((long)var27);
                           var132 = (WidgetNode)componentTable.method2311((long)var4);
                           if(var132 != null) {
                              class26.method560(var132, null == var6 || var132.id != var6.id);
                           }

                           if(var6 != null) {
                              var6.unlink();
                              componentTable.method2312(var6, (long)var4);
                           }

                           var122 = class191.method3433(var27);
                           if(var122 != null) {
                              class94.method1890(var122);
                           }

                           var122 = class191.method3433(var4);
                           if(null != var122) {
                              class94.method1890(var122);
                              class2.method18(Widget.widgets[var122.id >>> 16], var122, true);
                           }

                           if(widgetRoot != -1) {
                              class32.method656(widgetRoot, 1);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 61) {
                           CollisionData.xteaChanged(true);
                           field544.method2975();
                           var4 = field544.readUnsignedShort();
                           var5 = field544;
                           var28 = var5.offset;
                           class45.field924 = 0;
                           class171.method3175(var5);

                           for(var7 = 0; var7 < class45.field924; ++var7) {
                              var8 = class45.field917[var7];
                              var30 = cachedPlayers[var8];
                              var10 = var5.readUnsignedByte();
                              if((var10 & 64) != 0) {
                                 var10 += var5.readUnsignedByte() << 8;
                              }

                              var31 = -1;
                              if((var10 & 2) != 0) {
                                 var12 = var5.readUnsignedByte();
                                 var13 = new byte[var12];
                                 var14 = new Buffer(var13);
                                 var5.method2770(var13, 0, var12);
                                 class45.field907[var8] = var14;
                                 var30.method208(var14);
                              }

                              if((var10 & 32) != 0) {
                                 var12 = var5.readUnsignedShort();
                                 if(var12 == '\uffff') {
                                    var12 = -1;
                                 }

                                 var32 = var5.readUnsignedByte();
                                 XGrandExchangeOffer.method38(var30, var12, var32);
                              }

                              if((var10 & 4) != 0) {
                                 var30.interacting = var5.readUnsignedShort();
                                 if(var30.interacting == '\uffff') {
                                    var30.interacting = -1;
                                 }
                              }

                              if((var10 & 1) != 0) {
                                 var30.overhead = var5.method2767();
                                 if(var30.overhead.charAt(0) == 126) {
                                    var30.overhead = var30.overhead.substring(1);
                                    ObjectComposition.method3581(2, var30.name, var30.overhead);
                                 } else if(var30 == class39.localPlayer) {
                                    ObjectComposition.method3581(2, var30.name, var30.overhead);
                                 }

                                 var30.field612 = false;
                                 var30.field615 = 0;
                                 var30.field616 = 0;
                                 var30.field614 = 150;
                              }

                              if((var10 & 128) != 0) {
                                 var12 = var5.readUnsignedByte();
                                 if(var12 > 0) {
                                    for(var32 = 0; var32 < var12; ++var32) {
                                       var15 = -1;
                                       var16 = -1;
                                       var17 = -1;
                                       var33 = var5.method2772();
                                       if(var33 == 32767) {
                                          var33 = var5.method2772();
                                          var16 = var5.method2772();
                                          var15 = var5.method2772();
                                          var17 = var5.method2772();
                                       } else if(var33 != 32766) {
                                          var16 = var5.method2772();
                                       } else {
                                          var33 = -1;
                                       }

                                       var18 = var5.method2772();
                                       var30.method565(var33, var16, var15, var17, gameCycle, var18);
                                    }
                                 }

                                 var32 = var5.readUnsignedByte();
                                 if(var32 > 0) {
                                    for(var33 = 0; var33 < var32; ++var33) {
                                       var15 = var5.method2772();
                                       var16 = var5.method2772();
                                       if(var16 != 32767) {
                                          var17 = var5.method2772();
                                          var18 = var5.readUnsignedByte();
                                          var19 = var16 > 0?var5.readUnsignedByte():var18;
                                          var30.method566(var15, gameCycle, var16, var17, var18, var19);
                                       } else {
                                          var30.method567(var15);
                                       }
                                    }
                                 }
                              }

                              if((var10 & 8) != 0) {
                                 var30.field626 = var5.readUnsignedShort();
                                 if(var30.field652 == 0) {
                                    var30.field649 = var30.field626;
                                    var30.field626 = -1;
                                 }
                              }

                              if((var10 & 16) != 0) {
                                 var12 = var5.readUnsignedShort();
                                 var87 = (class177)XItemContainer.method161(class16.method181(), var5.readUnsignedByte());
                                 var119 = var5.readUnsignedByte() == 1;
                                 var15 = var5.readUnsignedByte();
                                 var16 = var5.offset;
                                 if(null != var30.name && null != var30.composition) {
                                    var95 = false;
                                    if(var87.field2668 && class189.method3399(var30.name)) {
                                       var95 = true;
                                    }

                                    if(!var95 && field407 == 0 && !var30.field245) {
                                       class45.field909.offset = 0;
                                       var5.method2770(class45.field909.payload, 0, var15);
                                       class45.field909.offset = 0;
                                       var34 = class45.field909;

                                       try {
                                          var21 = var34.method2772();
                                          if(var21 > 32767) {
                                             var21 = 32767;
                                          }

                                          var22 = new byte[var21];
                                          var34.offset += class210.field3114.method2688(var34.payload, var34.offset, var22, 0, var21);
                                          var23 = class139.method2528(var22, 0, var21);
                                          var20 = var23;
                                       } catch (Exception var46) {
                                          var20 = "Cabbage";
                                       }

                                       var20 = class209.method3778(class178.method3201(var20));
                                       var30.overhead = var20.trim();
                                       var30.field615 = var12 >> 8;
                                       var30.field616 = var12 & 255;
                                       var30.field614 = 150;
                                       var30.field612 = var119;
                                       var30.inSequence = var30 != class39.localPlayer && var87.field2668 && field532 != "" && var20.toLowerCase().indexOf(field532) == -1;
                                       if(var87.field2666) {
                                          var21 = var119?91:1;
                                       } else {
                                          var21 = var119?90:2;
                                       }

                                       if(var87.field2659 != -1) {
                                          ObjectComposition.method3581(var21, XGrandExchangeOffer.method56(var87.field2659) + var30.name, var20);
                                       } else {
                                          ObjectComposition.method3581(var21, var30.name, var20);
                                       }
                                    }
                                 }

                                 var5.offset = var15 + var16;
                              }

                              if((var10 & 4096) != 0) {
                                 var30.graphic = var5.readUnsignedShort();
                                 var12 = var5.method2844();
                                 var30.field639 = var12 >> 16;
                                 var30.field638 = (var12 & '\uffff') + gameCycle;
                                 var30.field636 = 0;
                                 var30.field637 = 0;
                                 if(var30.field638 > gameCycle) {
                                    var30.field636 = -1;
                                 }

                                 if(var30.graphic == '\uffff') {
                                    var30.graphic = -1;
                                 }
                              }

                              if((var10 & 1024) != 0) {
                                 var30.field606 = var5.readByte();
                                 var30.field642 = var5.readByte();
                                 var30.field641 = var5.readByte();
                                 var30.field643 = var5.readByte();
                                 var30.field602 = var5.readUnsignedShort() + gameCycle;
                                 var30.field645 = var5.readUnsignedShort() + gameCycle;
                                 var30.field653 = var5.readUnsignedShort();
                                 if(var30.field263) {
                                    var30.field606 += var30.field264;
                                    var30.field642 += var30.field265;
                                    var30.field641 += var30.field264;
                                    var30.field643 += var30.field265;
                                    var30.field652 = 0;
                                 } else {
                                    var30.field606 += var30.pathX[0];
                                    var30.field642 += var30.pathY[0];
                                    var30.field641 += var30.pathX[0];
                                    var30.field643 += var30.pathY[0];
                                    var30.field652 = 1;
                                 }

                                 var30.field607 = 0;
                              }

                              if((var10 & 2048) != 0) {
                                 class45.field913[var8] = var5.readByte();
                              }

                              if((var10 & 512) != 0) {
                                 var31 = var5.readByte();
                              }

                              if((var10 & 256) != 0) {
                                 for(var12 = 0; var12 < 3; ++var12) {
                                    var30.actions[var12] = var5.method2767();
                                 }
                              }

                              if(var30.field263) {
                                 if(var31 == 127) {
                                    var30.method235(var30.field264, var30.field265);
                                 } else {
                                    if(var31 != -1) {
                                       var92 = var31;
                                    } else {
                                       var92 = class45.field913[var8];
                                    }

                                    var30.method221(var30.field264, var30.field265, var92);
                                 }
                              }
                           }

                           if(var5.offset - var28 != var4) {
                              throw new RuntimeException(var5.offset - var28 + " " + var4);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        if(packetOpcode == 197) {
                           var4 = field544.method2807();
                           var27 = field544.method2750();
                           if(var27 == '\uffff') {
                              var27 = -1;
                           }

                           var28 = field544.method2806();
                           var41 = class191.method3433(var4);
                           ItemComposition var37;
                           if(!var41.field2198) {
                              if(var27 == -1) {
                                 var41.modelType = 0;
                                 packetOpcode = -1;
                                 var26 = true;
                                 break label4414;
                              }

                              var37 = class7.getItemDefinition(var27);
                              var41.modelType = 4;
                              var41.modelId = var27;
                              var41.rotationX = var37.field2960;
                              var41.rotationZ = var37.field2953;
                              var41.field2262 = var37.field2959 * 100 / var28;
                              class94.method1890(var41);
                           } else {
                              var41.item = var27;
                              var41.stackSize = var28;
                              var37 = class7.getItemDefinition(var27);
                              var41.rotationX = var37.field2960;
                              var41.rotationZ = var37.field2953;
                              var41.rotationY = var37.field2962;
                              var41.field2283 = var37.field2977;
                              var41.field2258 = var37.field2964;
                              var41.field2262 = var37.field2959;
                              if(var37.isStackable == 1) {
                                 var41.field2266 = 1;
                              } else {
                                 var41.field2266 = 2;
                              }

                              if(var41.field2292 > 0) {
                                 var41.field2262 = var41.field2262 * 32 / var41.field2292;
                              } else if(var41.field2219 > 0) {
                                 var41.field2262 = var41.field2262 * 32 / var41.field2219;
                              }

                              class94.method1890(var41);
                           }

                           packetOpcode = -1;
                           var26 = true;
                           break label4414;
                        }

                        FaceNormal.method1864("" + packetOpcode + "," + field466 + "," + field336 + "," + field485, (Throwable)null);
                        class10.method146();
                     } catch (IOException var57) {
                        class177.method3192();
                     } catch (Exception var58) {
                        var29 = "" + packetOpcode + "," + field466 + "," + field336 + "," + field485 + "," + (class39.localPlayer.pathX[0] + class15.baseX) + "," + (class20.baseY + class39.localPlayer.pathY[0]) + ",";

                        for(var27 = 0; var27 < field485 && var27 < 50; ++var27) {
                           var29 = var29 + field544.payload[var27] + ",";
                        }

                        FaceNormal.method1864(var29, var58);
                        class10.method146();
                     }

                     var26 = true;
                  }
               }

               if(!var26) {
                  break;
               }
            }

            if(gameState == 30) {
               while(true) {
                  ClassInfo var2 = (ClassInfo)class227.field3228.method2326();
                  boolean var99;
                  if(null == var2) {
                     var99 = false;
                  } else {
                     var99 = true;
                  }

                  int var145;
                  if(!var99) {
                     Object var59 = class26.field596.field217;
                     synchronized(class26.field596.field217) {
                        if(!field283) {
                           class26.field596.field210 = 0;
                        } else if(class115.field1802 != 0 || class26.field596.field210 >= 40) {
                           field294.method2976(90);
                           field294.method2932(0);
                           var145 = field294.offset;
                           var3 = 0;

                           for(var4 = 0; var4 < class26.field596.field210 && field294.offset - var145 < 240; ++var4) {
                              ++var3;
                              var27 = class26.field596.field219[var4];
                              if(var27 < 0) {
                                 var27 = 0;
                              } else if(var27 > 502) {
                                 var27 = 502;
                              }

                              var28 = class26.field596.field211[var4];
                              if(var28 < 0) {
                                 var28 = 0;
                              } else if(var28 > 764) {
                                 var28 = 764;
                              }

                              var7 = var28 + 765 * var27;
                              if(class26.field596.field219[var4] == -1 && class26.field596.field211[var4] == -1) {
                                 var28 = -1;
                                 var27 = -1;
                                 var7 = 524287;
                              }

                              if(field295 == var28 && var27 == field296) {
                                 if(field297 < 2047) {
                                    ++field297;
                                 }
                              } else {
                                 var8 = var28 - field295;
                                 field295 = var28;
                                 var9 = var27 - field296;
                                 field296 = var27;
                                 if(field297 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                    var8 += 32;
                                    var9 += 32;
                                    field294.method2746(var9 + (var8 << 6) + (field297 << 12));
                                    field297 = 0;
                                 } else if(field297 < 8) {
                                    field294.method2747(var7 + 8388608 + (field297 << 19));
                                    field297 = 0;
                                 } else {
                                    field294.method2748(var7 + (field297 << 19) + -1073741824);
                                    field297 = 0;
                                 }
                              }
                           }

                           field294.method2756(field294.offset - var145);
                           if(var3 >= class26.field596.field210) {
                              class26.field596.field210 = 0;
                           } else {
                              class26.field596.field210 -= var3;

                              for(var4 = 0; var4 < class26.field596.field210; ++var4) {
                                 class26.field596.field211[var4] = class26.field596.field211[var4 + var3];
                                 class26.field596.field219[var4] = class26.field596.field219[var3 + var4];
                              }
                           }
                        }
                     }

                     if(class115.field1802 == 1 || !class103.field1662 && class115.field1802 == 4 || class115.field1802 == 2) {
                        long var100 = (class115.field1805 - field563) / 50L;
                        if(var100 > 4095L) {
                           var100 = 4095L;
                        }

                        field563 = class115.field1805;
                        var3 = class115.field1804;
                        if(var3 < 0) {
                           var3 = 0;
                        } else if(var3 > class112.field1755) {
                           var3 = class112.field1755;
                        }

                        var4 = class115.field1803;
                        if(var4 < 0) {
                           var4 = 0;
                        } else if(var4 > ItemLayer.field1223) {
                           var4 = ItemLayer.field1223;
                        }

                        var27 = (int)var100;
                        field294.method2976(192);
                        field294.method2746((var27 << 1) + (class115.field1802 == 2?1:0));
                        field294.method2746(var4);
                        field294.method2746(var3);
                     }

                     if(class105.field1692 > 0) {
                        field294.method2976(187);
                        field294.method2746(0);
                        var25 = field294.offset;
                        long var146 = class72.method1385();

                        for(var4 = 0; var4 < class105.field1692; ++var4) {
                           var131 = var146 - field512;
                           if(var131 > 16777215L) {
                              var131 = 16777215L;
                           }

                           field512 = var146;
                           field294.method2850((int)var131);
                           field294.method2935(class105.field1699[var4]);
                        }

                        field294.method2755(field294.offset - var25);
                     }

                     if(field378 > 0) {
                        --field378;
                     }

                     if(class105.field1693[96] || class105.field1693[97] || class105.field1693[98] || class105.field1693[99]) {
                        field441 = true;
                     }

                     if(field441 && field378 <= 0) {
                        field378 = 20;
                        field441 = false;
                        field294.method2976(94);
                        field294.method2792(mapAngle);
                        field294.method2746(field371);
                     }

                     if(class9.field83 && !field298) {
                        field298 = true;
                        field294.method2976(65);
                        field294.method2932(1);
                     }

                     if(!class9.field83 && field298) {
                        field298 = false;
                        field294.method2976(65);
                        field294.method2932(0);
                     }

                     class38.method705();
                     if(gameState == 30) {
                        for(class25 var60 = (class25)field370.method2359(); var60 != null; var60 = (class25)field370.method2361()) {
                           if(var60.field578 > 0) {
                              --var60.field578;
                           }

                           ObjectComposition var81;
                           if(var60.field578 == 0) {
                              if(var60.field576 >= 0) {
                                 var3 = var60.field576;
                                 var4 = var60.field575;
                                 var81 = ItemLayer.getObjectDefinition(var3);
                                 if(var4 == 11) {
                                    var4 = 10;
                                 }

                                 if(var4 >= 5 && var4 <= 8) {
                                    var4 = 4;
                                 }

                                 var26 = var81.method3542(var4);
                                 if(!var26) {
                                    continue;
                                 }
                              }

                              ChatLineBuffer.method880(var60.field586, var60.field573, var60.field574, var60.field581, var60.field576, var60.field583, var60.field575);
                              var60.unlink();
                           } else {
                              if(var60.field582 > 0) {
                                 --var60.field582;
                              }

                              if(var60.field582 == 0 && var60.field574 >= 1 && var60.field581 >= 1 && var60.field574 <= 102 && var60.field581 <= 102) {
                                 if(var60.field579 >= 0) {
                                    var3 = var60.field579;
                                    var4 = var60.field572;
                                    var81 = ItemLayer.getObjectDefinition(var3);
                                    if(var4 == 11) {
                                       var4 = 10;
                                    }

                                    if(var4 >= 5 && var4 <= 8) {
                                       var4 = 4;
                                    }

                                    var26 = var81.method3542(var4);
                                    if(!var26) {
                                       continue;
                                    }
                                 }

                                 ChatLineBuffer.method880(var60.field586, var60.field573, var60.field574, var60.field581, var60.field579, var60.field580, var60.field572);
                                 var60.field582 = -1;
                                 if(var60.field579 == var60.field576 && var60.field576 == -1) {
                                    var60.unlink();
                                 } else if(var60.field576 == var60.field579 && var60.field583 == var60.field580 && var60.field572 == var60.field575) {
                                    var60.unlink();
                                 }
                              }
                           }
                        }

                        for(var25 = 0; var25 < field528; ++var25) {
                           --field439[var25];
                           if(field439[var25] >= -10) {
                              class53 var61 = field533[var25];
                              if(var61 == null) {
                                 Object var147 = null;
                                 var61 = class53.method950(VertexNormal.field1425, field529[var25], 0);
                                 if(null == var61) {
                                    continue;
                                 }

                                 field439[var25] += var61.method946();
                                 field533[var25] = var61;
                              }

                              if(field439[var25] < 0) {
                                 if(field483[var25] != 0) {
                                    var4 = 128 * (field483[var25] & 255);
                                    var27 = field483[var25] >> 16 & 255;
                                    var28 = 64 + var27 * 128 - class39.localPlayer.x;
                                    if(var28 < 0) {
                                       var28 = -var28;
                                    }

                                    var7 = field483[var25] >> 8 & 255;
                                    var8 = 64 + 128 * var7 - class39.localPlayer.y;
                                    if(var8 < 0) {
                                       var8 = -var8;
                                    }

                                    var9 = var28 + var8 - 128;
                                    if(var9 > var4) {
                                       field439[var25] = -100;
                                       continue;
                                    }

                                    if(var9 < 0) {
                                       var9 = 0;
                                    }

                                    var3 = field527 * (var4 - var9) / var4;
                                 } else {
                                    var3 = field482;
                                 }

                                 if(var3 > 0) {
                                    class55 var120 = var61.method938().method989(MessageNode.field229);
                                    class66 var83 = class66.method1159(var120, 100, var3);
                                    var83.method1162(field409[var25] - 1);
                                    class0.field3.method882(var83);
                                 }

                                 field439[var25] = -100;
                              }
                           } else {
                              --field528;

                              for(var145 = var25; var145 < field528; ++var145) {
                                 field529[var145] = field529[1 + var145];
                                 field533[var145] = field533[1 + var145];
                                 field409[var145] = field409[var145 + 1];
                                 field439[var145] = field439[1 + var145];
                                 field483[var145] = field483[var145 + 1];
                              }

                              --var25;
                           }
                        }

                        if(field525 && !class36.method696()) {
                           if(field373 != 0 && field414 != -1) {
                              class116.method2199(class204.field3079, field414, 0, field373, false);
                           }

                           field525 = false;
                        }

                        ++field332;
                        if(field332 > 750) {
                           class177.method3192();
                        } else {
                           class168.method3099();

                           for(var25 = 0; var25 < field322; ++var25) {
                              var145 = field323[var25];
                              NPC var44 = cachedNPCs[var145];
                              if(null != var44) {
                                 ChatMessages.method833(var44, var44.composition.field3012);
                              }
                           }

                           FaceNormal.method1865();
                           ++field364;
                           if(field398 != 0) {
                              field397 += 20;
                              if(field397 >= 400) {
                                 field398 = 0;
                              }
                           }

                           if(class10.field107 != null) {
                              ++field399;
                              if(field399 >= 15) {
                                 class94.method1890(class10.field107);
                                 class10.field107 = null;
                              }
                           }

                           Widget var62 = FaceNormal.field1558;
                           Widget var63 = class10.field105;
                           FaceNormal.field1558 = null;
                           class10.field105 = null;
                           field463 = null;
                           field467 = false;
                           field464 = false;
                           field509 = 0;

                           while(true) {
                              while(class44.method782() && field509 < 128) {
                                 if(field358 >= 2 && class105.field1693[82] && Tile.field1352 == 66) {
                                    String var139 = class88.method1854();
                                    class116.field1814.setContents(new StringSelection(var139), (ClipboardOwner)null);
                                 } else {
                                    field431[field509] = Tile.field1352;
                                    field458[field509] = XClanMember.field275;
                                    ++field509;
                                 }
                              }

                              if(widgetRoot != -1) {
                                 var3 = widgetRoot;
                                 var4 = ItemLayer.field1223;
                                 var27 = class112.field1755;
                                 if(class212.method3870(var3)) {
                                    class6.method86(Widget.widgets[var3], -1, 0, 0, var4, var27, 0, 0);
                                 }
                              }

                              ++field471;

                              while(true) {
                                 Widget var121;
                                 class18 var140;
                                 do {
                                    var140 = (class18)field486.method2357();
                                    if(null == var140) {
                                       while(true) {
                                          do {
                                             var140 = (class18)field552.method2357();
                                             if(var140 == null) {
                                                while(true) {
                                                   do {
                                                      var140 = (class18)field475.method2357();
                                                      if(var140 == null) {
                                                         boolean var79 = false;

                                                         while(!var79) {
                                                            var79 = true;

                                                            for(var4 = 0; var4 < menuOptionCount - 1; ++var4) {
                                                               if(menuTypes[var4] < 1000 && menuTypes[var4 + 1] > 1000) {
                                                                  var65 = menuTargets[var4];
                                                                  menuTargets[var4] = menuTargets[1 + var4];
                                                                  menuTargets[var4 + 1] = var65;
                                                                  var73 = menuOptions[var4];
                                                                  menuOptions[var4] = menuOptions[var4 + 1];
                                                                  menuOptions[var4 + 1] = var73;
                                                                  var7 = menuTypes[var4];
                                                                  menuTypes[var4] = menuTypes[var4 + 1];
                                                                  menuTypes[var4 + 1] = var7;
                                                                  var7 = menuActionParams0[var4];
                                                                  menuActionParams0[var4] = menuActionParams0[var4 + 1];
                                                                  menuActionParams0[var4 + 1] = var7;
                                                                  var7 = menuActionParams1[var4];
                                                                  menuActionParams1[var4] = menuActionParams1[1 + var4];
                                                                  menuActionParams1[var4 + 1] = var7;
                                                                  var7 = menuIdentifiers[var4];
                                                                  menuIdentifiers[var4] = menuIdentifiers[1 + var4];
                                                                  menuIdentifiers[var4 + 1] = var7;
                                                                  var79 = false;
                                                               }
                                                            }
                                                         }

                                                         if(WallObject.field1550 == null && field511 == null) {
                                                            var3 = class115.field1802;
                                                            if(isMenuOpen) {
                                                               if(var3 != 1 && (class103.field1662 || var3 != 4)) {
                                                                  var4 = class115.field1794;
                                                                  var27 = class115.field1797;
                                                                  if(var4 < FileOnDisk.menuX - 10 || var4 > 10 + FileOnDisk.menuX + class20.menuWidth || var27 < XGrandExchangeOffer.menuY - 10 || var27 > 10 + class101.menuHeight + XGrandExchangeOffer.menuY) {
                                                                     isMenuOpen = false;
                                                                     class148.method2733(FileOnDisk.menuX, XGrandExchangeOffer.menuY, class20.menuWidth, class101.menuHeight);
                                                                  }
                                                               }

                                                               if(var3 == 1 || !class103.field1662 && var3 == 4) {
                                                                  var4 = FileOnDisk.menuX;
                                                                  var27 = XGrandExchangeOffer.menuY;
                                                                  var28 = class20.menuWidth;
                                                                  var7 = class115.field1803;
                                                                  var8 = class115.field1804;
                                                                  var9 = -1;

                                                                  for(var10 = 0; var10 < menuOptionCount; ++var10) {
                                                                     var109 = 31 + var27 + 15 * (menuOptionCount - 1 - var10);
                                                                     if(var7 > var4 && var7 < var28 + var4 && var8 > var109 - 13 && var8 < var109 + 3) {
                                                                        var9 = var10;
                                                                     }
                                                                  }

                                                                  if(var9 != -1 && var9 >= 0) {
                                                                     var10 = menuActionParams0[var9];
                                                                     var109 = menuActionParams1[var9];
                                                                     var12 = menuTypes[var9];
                                                                     var32 = menuIdentifiers[var9];
                                                                     String var93 = menuOptions[var9];
                                                                     var127 = menuTargets[var9];
                                                                     class185.menuAction(var10, var109, var12, var32, var93, var127, class115.field1803, class115.field1804);
                                                                  }

                                                                  isMenuOpen = false;
                                                                  class148.method2733(FileOnDisk.menuX, XGrandExchangeOffer.menuY, class20.menuWidth, class101.menuHeight);
                                                               }
                                                            } else {
                                                               label4597: {
                                                                  if((var3 == 1 || !class103.field1662 && var3 == 4) && menuOptionCount > 0) {
                                                                     var4 = menuTypes[menuOptionCount - 1];
                                                                     if(var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                                                                        var27 = menuActionParams0[menuOptionCount - 1];
                                                                        var28 = menuActionParams1[menuOptionCount - 1];
                                                                        var41 = class191.method3433(var28);
                                                                        if(class40.method719(class143.method2647(var41)) || class160.method3004(class143.method2647(var41))) {
                                                                           if(WallObject.field1550 != null && !field457 && field426 != 1 && !class7.method94(menuOptionCount - 1) && menuOptionCount > 0) {
                                                                              var8 = field484;
                                                                              var9 = field403;
                                                                              class38 var141 = Player.field260;
                                                                              class185.menuAction(var141.field797, var141.field800, var141.field795, var141.field798, var141.field799, var141.field799, var8, var9);
                                                                              Player.field260 = null;
                                                                           }

                                                                           field457 = false;
                                                                           field406 = 0;
                                                                           if(WallObject.field1550 != null) {
                                                                              class94.method1890(WallObject.field1550);
                                                                           }

                                                                           WallObject.field1550 = class191.method3433(var28);
                                                                           field401 = var27;
                                                                           field484 = class115.field1803;
                                                                           field403 = class115.field1804;
                                                                           if(menuOptionCount > 0) {
                                                                              var8 = menuOptionCount - 1;
                                                                              Player.field260 = new class38();
                                                                              Player.field260.field797 = menuActionParams0[var8];
                                                                              Player.field260.field800 = menuActionParams1[var8];
                                                                              Player.field260.field795 = menuTypes[var8];
                                                                              Player.field260.field798 = menuIdentifiers[var8];
                                                                              Player.field260.field799 = menuOptions[var8];
                                                                           }

                                                                           class94.method1890(WallObject.field1550);
                                                                           break label4597;
                                                                        }
                                                                     }
                                                                  }

                                                                  if((var3 == 1 || !class103.field1662 && var3 == 4) && (field426 == 1 && menuOptionCount > 2 || class7.method94(menuOptionCount - 1))) {
                                                                     var3 = 2;
                                                                  }

                                                                  if((var3 == 1 || !class103.field1662 && var3 == 4) && menuOptionCount > 0) {
                                                                     var4 = menuOptionCount - 1;
                                                                     if(var4 >= 0) {
                                                                        var27 = menuActionParams0[var4];
                                                                        var28 = menuActionParams1[var4];
                                                                        var7 = menuTypes[var4];
                                                                        var8 = menuIdentifiers[var4];
                                                                        String var110 = menuOptions[var4];
                                                                        var135 = menuTargets[var4];
                                                                        class185.menuAction(var27, var28, var7, var8, var110, var135, class115.field1803, class115.field1804);
                                                                     }
                                                                  }

                                                                  if(var3 == 2 && menuOptionCount > 0) {
                                                                     class172.method3178(class115.field1803, class115.field1804);
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         if(null != field511) {
                                                            class20.method197();
                                                         }

                                                         if(WallObject.field1550 != null) {
                                                            class94.method1890(WallObject.field1550);
                                                            ++field406;
                                                            if(class115.field1795 != 0) {
                                                               if(field406 >= 5 && (class115.field1794 > 5 + field484 || class115.field1794 < field484 - 5 || class115.field1797 > 5 + field403 || class115.field1797 < field403 - 5)) {
                                                                  field457 = true;
                                                               }
                                                            } else {
                                                               if(field457) {
                                                                  if(WallObject.field1550 == class156.field2119 && field401 != field404) {
                                                                     Widget var142 = WallObject.field1550;
                                                                     byte var112 = 0;
                                                                     if(field449 == 1 && var142.contentType == 206) {
                                                                        var112 = 1;
                                                                     }

                                                                     if(var142.itemIds[field404] <= 0) {
                                                                        var112 = 0;
                                                                     }

                                                                     if(class160.method3004(class143.method2647(var142))) {
                                                                        var27 = field401;
                                                                        var28 = field404;
                                                                        var142.itemIds[var28] = var142.itemIds[var27];
                                                                        var142.itemQuantities[var28] = var142.itemQuantities[var27];
                                                                        var142.itemIds[var27] = -1;
                                                                        var142.itemQuantities[var27] = 0;
                                                                     } else if(var112 == 1) {
                                                                        var27 = field401;
                                                                        var28 = field404;

                                                                        while(var28 != var27) {
                                                                           if(var27 > var28) {
                                                                              var142.method3154(var27 - 1, var27);
                                                                              --var27;
                                                                           } else if(var27 < var28) {
                                                                              var142.method3154(1 + var27, var27);
                                                                              ++var27;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var142.method3154(field404, field401);
                                                                     }

                                                                     field294.method2976(118);
                                                                     field294.method2784(var112);
                                                                     field294.method2893(WallObject.field1550.id);
                                                                     field294.method2793(field404);
                                                                     field294.method2793(field401);
                                                                  }
                                                               } else if((field426 == 1 || class7.method94(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                                  class172.method3178(field484, field403);
                                                               } else if(menuOptionCount > 0) {
                                                                  var3 = field484;
                                                                  var4 = field403;
                                                                  class38 var86 = Player.field260;
                                                                  class185.menuAction(var86.field797, var86.field800, var86.field795, var86.field798, var86.field799, var86.field799, var3, var4);
                                                                  Player.field260 = null;
                                                               }

                                                               field399 = 10;
                                                               class115.field1802 = 0;
                                                               WallObject.field1550 = null;
                                                            }
                                                         }

                                                         if(Region.field1474 != -1) {
                                                            var3 = Region.field1474;
                                                            var4 = Region.field1493;
                                                            field294.method2976(123);
                                                            field294.method2932(5);
                                                            field294.method2932(class105.field1693[82]?(class105.field1693[81]?2:1):0);
                                                            field294.method2792(class20.baseY + var4);
                                                            field294.method2763(class15.baseX + var3);
                                                            Region.field1474 = -1;
                                                            field395 = class115.field1803;
                                                            field396 = class115.field1804;
                                                            field398 = 1;
                                                            field397 = 0;
                                                            flagX = var3;
                                                            flagY = var4;
                                                         }

                                                         if(var62 != FaceNormal.field1558) {
                                                            if(null != var62) {
                                                               class94.method1890(var62);
                                                            }

                                                            if(FaceNormal.field1558 != null) {
                                                               class94.method1890(FaceNormal.field1558);
                                                            }
                                                         }

                                                         if(class10.field105 != var63 && field437 == field493) {
                                                            if(null != var63) {
                                                               class94.method1890(var63);
                                                            }

                                                            if(null != class10.field105) {
                                                               class94.method1890(class10.field105);
                                                            }
                                                         }

                                                         if(class10.field105 != null) {
                                                            if(field437 < field493) {
                                                               ++field437;
                                                               if(field493 == field437) {
                                                                  class94.method1890(class10.field105);
                                                               }
                                                            }
                                                         } else if(field437 > 0) {
                                                            --field437;
                                                         }

                                                         var3 = field352 + class39.localPlayer.x;
                                                         var4 = class39.localPlayer.y + field354;
                                                         if(class37.field785 - var3 < -500 || class37.field785 - var3 > 500 || Player.field266 - var4 < -500 || Player.field266 - var4 > 500) {
                                                            class37.field785 = var3;
                                                            Player.field266 = var4;
                                                         }

                                                         if(class37.field785 != var3) {
                                                            class37.field785 += (var3 - class37.field785) / 16;
                                                         }

                                                         if(var4 != Player.field266) {
                                                            Player.field266 += (var4 - Player.field266) / 16;
                                                         }

                                                         if(class115.field1795 == 4 && class103.field1662) {
                                                            var27 = class115.field1797 - field478;
                                                            field374 = var27 * 2;
                                                            field478 = var27 != -1 && var27 != 1?(field478 + class115.field1797) / 2:class115.field1797;
                                                            var28 = field337 - class115.field1794;
                                                            field436 = var28 * 2;
                                                            field337 = var28 != -1 && var28 != 1?(class115.field1794 + field337) / 2:class115.field1794;
                                                         } else {
                                                            if(class105.field1693[96]) {
                                                               field436 += (-24 - field436) / 2;
                                                            } else if(class105.field1693[97]) {
                                                               field436 += (24 - field436) / 2;
                                                            } else {
                                                               field436 /= 2;
                                                            }

                                                            if(class105.field1693[98]) {
                                                               field374 += (12 - field374) / 2;
                                                            } else if(class105.field1693[99]) {
                                                               field374 += (-12 - field374) / 2;
                                                            } else {
                                                               field374 /= 2;
                                                            }

                                                            field478 = class115.field1797;
                                                            field337 = class115.field1794;
                                                         }

                                                         mapAngle = mapAngle + field436 / 2 & 2047;
                                                         field371 += field374 / 2;
                                                         if(field371 < 128) {
                                                            field371 = 128;
                                                         }

                                                         if(field371 > 383) {
                                                            field371 = 383;
                                                         }

                                                         var27 = class37.field785 >> 7;
                                                         var28 = Player.field266 >> 7;
                                                         var7 = class85.method1686(class37.field785, Player.field266, class171.plane);
                                                         var8 = 0;
                                                         if(var27 > 3 && var28 > 3 && var27 < 100 && var28 < 100) {
                                                            for(var9 = var27 - 4; var9 <= var27 + 4; ++var9) {
                                                               for(var10 = var28 - 4; var10 <= 4 + var28; ++var10) {
                                                                  var109 = class171.plane;
                                                                  if(var109 < 3 && (class10.tileSettings[1][var9][var10] & 2) == 2) {
                                                                     ++var109;
                                                                  }

                                                                  var12 = var7 - class10.tileHeights[var109][var9][var10];
                                                                  if(var12 > var8) {
                                                                     var8 = var12;
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         var9 = 192 * var8;
                                                         if(var9 > 98048) {
                                                            var9 = 98048;
                                                         }

                                                         if(var9 < '耀') {
                                                            var9 = '耀';
                                                         }

                                                         if(var9 > field380) {
                                                            field380 += (var9 - field380) / 24;
                                                         } else if(var9 < field380) {
                                                            field380 += (var9 - field380) / 80;
                                                         }

                                                         if(field534) {
                                                            var3 = class94.field1578 * 128 + 64;
                                                            var4 = class33.field744 * 128 + 64;
                                                            var27 = class85.method1686(var3, var4, class171.plane) - class148.field2038;
                                                            if(WidgetNode.cameraX < var3) {
                                                               WidgetNode.cameraX += class45.field921 + class3.field34 * (var3 - WidgetNode.cameraX) / 1000;
                                                               if(WidgetNode.cameraX > var3) {
                                                                  WidgetNode.cameraX = var3;
                                                               }
                                                            }

                                                            if(WidgetNode.cameraX > var3) {
                                                               WidgetNode.cameraX -= class45.field921 + class3.field34 * (WidgetNode.cameraX - var3) / 1000;
                                                               if(WidgetNode.cameraX < var3) {
                                                                  WidgetNode.cameraX = var3;
                                                               }
                                                            }

                                                            if(MessageNode.cameraZ < var27) {
                                                               MessageNode.cameraZ += (var27 - MessageNode.cameraZ) * class3.field34 / 1000 + class45.field921;
                                                               if(MessageNode.cameraZ > var27) {
                                                                  MessageNode.cameraZ = var27;
                                                               }
                                                            }

                                                            if(MessageNode.cameraZ > var27) {
                                                               MessageNode.cameraZ -= (MessageNode.cameraZ - var27) * class3.field34 / 1000 + class45.field921;
                                                               if(MessageNode.cameraZ < var27) {
                                                                  MessageNode.cameraZ = var27;
                                                               }
                                                            }

                                                            if(class2.cameraY < var4) {
                                                               class2.cameraY += (var4 - class2.cameraY) * class3.field34 / 1000 + class45.field921;
                                                               if(class2.cameraY > var4) {
                                                                  class2.cameraY = var4;
                                                               }
                                                            }

                                                            if(class2.cameraY > var4) {
                                                               class2.cameraY -= (class2.cameraY - var4) * class3.field34 / 1000 + class45.field921;
                                                               if(class2.cameraY < var4) {
                                                                  class2.cameraY = var4;
                                                               }
                                                            }

                                                            var3 = 64 + class203.field3072 * 128;
                                                            var4 = 64 + class178.field2680 * 128;
                                                            var27 = class85.method1686(var3, var4, class171.plane) - class154.field2105;
                                                            var28 = var3 - WidgetNode.cameraX;
                                                            var7 = var27 - MessageNode.cameraZ;
                                                            var8 = var4 - class2.cameraY;
                                                            var9 = (int)Math.sqrt((double)(var28 * var28 + var8 * var8));
                                                            var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                            var109 = (int)(Math.atan2((double)var28, (double)var8) * -325.949D) & 2047;
                                                            if(var10 < 128) {
                                                               var10 = 128;
                                                            }

                                                            if(var10 > 383) {
                                                               var10 = 383;
                                                            }

                                                            if(Buffer.cameraPitch < var10) {
                                                               Buffer.cameraPitch += Item.field891 * (var10 - Buffer.cameraPitch) / 1000 + class118.field1842;
                                                               if(Buffer.cameraPitch > var10) {
                                                                  Buffer.cameraPitch = var10;
                                                               }
                                                            }

                                                            if(Buffer.cameraPitch > var10) {
                                                               Buffer.cameraPitch -= class118.field1842 + (Buffer.cameraPitch - var10) * Item.field891 / 1000;
                                                               if(Buffer.cameraPitch < var10) {
                                                                  Buffer.cameraPitch = var10;
                                                               }
                                                            }

                                                            var12 = var109 - class39.cameraYaw;
                                                            if(var12 > 1024) {
                                                               var12 -= 2048;
                                                            }

                                                            if(var12 < -1024) {
                                                               var12 += 2048;
                                                            }

                                                            if(var12 > 0) {
                                                               class39.cameraYaw += class118.field1842 + Item.field891 * var12 / 1000;
                                                               class39.cameraYaw &= 2047;
                                                            }

                                                            if(var12 < 0) {
                                                               class39.cameraYaw -= class118.field1842 + -var12 * Item.field891 / 1000;
                                                               class39.cameraYaw &= 2047;
                                                            }

                                                            var32 = var109 - class39.cameraYaw;
                                                            if(var32 > 1024) {
                                                               var32 -= 2048;
                                                            }

                                                            if(var32 < -1024) {
                                                               var32 += 2048;
                                                            }

                                                            if(var32 < 0 && var12 > 0 || var32 > 0 && var12 < 0) {
                                                               class39.cameraYaw = var109;
                                                            }
                                                         }

                                                         for(var3 = 0; var3 < 5; ++var3) {
                                                            ++field539[var3];
                                                         }

                                                         Ignore.chatMessages.method825();
                                                         var3 = ++class115.mouseIdleTicks - 1;
                                                         var27 = class105.keyboardIdleTicks;
                                                         if(var3 > 15000 && var27 > 15000) {
                                                            field453 = 250;
                                                            class115.mouseIdleTicks = 14500;
                                                            field294.method2976(60);
                                                         }

                                                         ++field351;
                                                         if(field351 > 500) {
                                                            field351 = 0;
                                                            var7 = (int)(Math.random() * 8.0D);
                                                            if((var7 & 1) == 1) {
                                                               field352 += field353;
                                                            }

                                                            if((var7 & 2) == 2) {
                                                               field354 += field355;
                                                            }

                                                            if((var7 & 4) == 4) {
                                                               field356 += field465;
                                                            }
                                                         }

                                                         if(field352 < -50) {
                                                            field353 = 2;
                                                         }

                                                         if(field352 > 50) {
                                                            field353 = -2;
                                                         }

                                                         if(field354 < -55) {
                                                            field355 = 2;
                                                         }

                                                         if(field354 > 55) {
                                                            field355 = -2;
                                                         }

                                                         if(field356 < -40) {
                                                            field465 = 1;
                                                         }

                                                         if(field356 > 40) {
                                                            field465 = -1;
                                                         }

                                                         ++field363;
                                                         if(field363 > 500) {
                                                            field363 = 0;
                                                            var7 = (int)(Math.random() * 8.0D);
                                                            if((var7 & 1) == 1) {
                                                               mapScale += field360;
                                                            }

                                                            if((var7 & 2) == 2) {
                                                               mapScaleDelta += field301;
                                                            }
                                                         }

                                                         if(mapScale < -60) {
                                                            field360 = 2;
                                                         }

                                                         if(mapScale > 60) {
                                                            field360 = -2;
                                                         }

                                                         if(mapScaleDelta < -20) {
                                                            field301 = 1;
                                                         }

                                                         if(mapScaleDelta > 10) {
                                                            field301 = -1;
                                                         }

                                                         for(class16 var144 = (class16)field556.method2399(); null != var144; var144 = (class16)field556.method2395()) {
                                                            if((long)var144.field168 < class72.method1385() / 1000L - 5L) {
                                                               if(var144.field175 > 0) {
                                                                  ObjectComposition.method3581(5, "", var144.field169 + " has logged in.");
                                                               }

                                                               if(var144.field175 == 0) {
                                                                  ObjectComposition.method3581(5, "", var144.field169 + " has logged out.");
                                                               }

                                                               var144.method2406();
                                                            }
                                                         }

                                                         ++field333;
                                                         if(field333 > 50) {
                                                            field294.method2976(212);
                                                         }

                                                         try {
                                                            if(null != class156.field2118 && field294.offset > 0) {
                                                               class156.field2118.method2032(field294.payload, 0, field294.offset);
                                                               field294.offset = 0;
                                                               field333 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var45) {
                                                            class177.method3192();
                                                         }

                                                         return;
                                                      }

                                                      var121 = var140.field187;
                                                      if(var121.index < 0) {
                                                         break;
                                                      }

                                                      var72 = class191.method3433(var121.parentId);
                                                   } while(null == var72 || null == var72.children || var121.index >= var72.children.length || var121 != var72.children[var121.index]);

                                                   Ignore.method191(var140);
                                                }
                                             }

                                             var121 = var140.field187;
                                             if(var121.index < 0) {
                                                break;
                                             }

                                             var72 = class191.method3433(var121.parentId);
                                          } while(null == var72 || var72.children == null || var121.index >= var72.children.length || var121 != var72.children[var121.index]);

                                          Ignore.method191(var140);
                                       }
                                    }

                                    var121 = var140.field187;
                                    if(var121.index < 0) {
                                       break;
                                    }

                                    var72 = class191.method3433(var121.parentId);
                                 } while(var72 == null || var72.children == null || var121.index >= var72.children.length || var121 != var72.children[var121.index]);

                                 Ignore.method191(var140);
                              }
                           }
                        }
                     }
                     break;
                  }

                  field294.method2976(114);
                  field294.method2932(0);
                  var145 = field294.offset;
                  class112.method2069(field294);
                  field294.method2756(field294.offset - var145);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "-61"
   )
   static final void method439(class159 var0) {
      var0.method2977();
      int var1 = localInteractingIndex;
      Player var2 = class39.localPlayer = cachedPlayers[var1] = new Player();
      var2.field262 = var1;
      int var3 = var0.method2978(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class15.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method209() << 6);
      var2.pathY[0] = var6 - class20.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method209() << 6);
      var2.field261 = var4 * 310442017;
      class171.plane = var4;
      if(class45.field907[var1] != null) {
         var2.method208(class45.field907[var1]);
      }

      class45.field908 = 0;
      class45.field903[++class45.field908 - 1] = var1;
      class45.field905[var1] = 0;
      class45.field910 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2978(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class45.field912[var7] = (var9 << 28) + (var10 << 14) + var11;
            class45.field915[var7] = 0;
            class45.field904[var7] = -1;
            class45.field911[++class45.field910 - 1] = var7;
            class45.field905[var7] = 0;
         }
      }

      var0.method2982();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1061882622"
   )
   static final void method552() {
      Region.field1476 = false;
      field289 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "-1181862905"
   )
   public static void method553(class182 var0, class182 var1, class182 var2) {
      KitDefinition.field2826 = var0;
      Sequence.field3065 = var1;
      class149.field2041 = var2;
   }
}
