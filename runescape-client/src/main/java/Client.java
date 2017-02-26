import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -1670641667
   )
   static int field299;
   @ObfuscatedName("dv")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("h")
   static boolean field301 = true;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 103315253
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 207348809
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("n")
   static class178 field304;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 773585185
   )
   static int field305 = 0;
   @ObfuscatedName("c")
   static class179 field306;
   @ObfuscatedName("o")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("m")
   static boolean field308 = false;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1415673945
   )
   static int field309 = 0;
   @ObfuscatedName("b")
   static String field310;
   @ObfuscatedName("oi")
   static int[] field311;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 575583347
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("hx")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("iq")
   static boolean field314;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 5984898553201106829L
   )
   static long field315 = 1L;
   @ObfuscatedName("l")
   static class20 field316;
   @ObfuscatedName("ft")
   static int[] field317;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -302341733
   )
   static int field318 = -1;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 401862683
   )
   static int field319;
   @ObfuscatedName("aq")
   static boolean field320 = true;
   @ObfuscatedName("at")
   static boolean field321 = false;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -729925151
   )
   static int field322 = 0;
   @ObfuscatedName("mb")
   static int[] field323;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1645100057
   )
   static int field324 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1120323375
   )
   static int field325 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1119433905
   )
   static int field326 = 0;
   @ObfuscatedName("ow")
   static int[] field327;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 886377543
   )
   static int field328 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -473891733
   )
   static int field329 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -269770699
   )
   static int field330 = 0;
   @ObfuscatedName("ap")
   static class40 field331;
   @ObfuscatedName("ak")
   static class40 field332;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1047665189
   )
   static int field333;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1865120107
   )
   static int field334;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -516827083
   )
   static int field335;
   @ObfuscatedName("bp")
   static class184 field336;
   @ObfuscatedName("bt")
   static class184 field337;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -1870061337
   )
   static int field338;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -790834303
   )
   static int field339;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1031091663
   )
   static int field340;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 557157023
   )
   static int field341;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1663174777
   )
   static int field342;
   @ObfuscatedName("jc")
   static Widget field343;
   @ObfuscatedName("hj")
   static int[] field344;
   @ObfuscatedName("ct")
   static int[] field345;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -596709527
   )
   static int field346;
   @ObfuscatedName("cw")
   static int[] field347;
   @ObfuscatedName("cn")
   static class159 field348;
   @ObfuscatedName("nj")
   static class53[] field349;
   @ObfuscatedName("cg")
   static class159 field350;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1113768043
   )
   static int field351;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 198804175
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1776547597
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 33449875
   )
   static int field354;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 483895669
   )
   static int field355;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1012129407
   )
   static int field356;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 39033337
   )
   static int field357;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1137683653
   )
   static int field358;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1853275809
   )
   static int field359;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -758228155
   )
   static int field360;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1279231151
   )
   static int field361;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -1240548355
   )
   static int field362;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 1755563187
   )
   static int field364;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("hg")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("dw")
   static int[][][] field367;
   @ObfuscatedName("dz")
   static final int[] field368;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -1146202087
   )
   static int field369;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 816065777
   )
   static int field370;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -1194806887
   )
   static int field371;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 911001423
   )
   static int field372;
   @ObfuscatedName("t")
   static boolean field373 = true;
   @ObfuscatedName("hn")
   @Export("playerOptionsPriority")
   static boolean[] playerOptionsPriority;
   @ObfuscatedName("fe")
   static int[] field375;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -518214699
   )
   static int field376;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -861597371
   )
   static int field377;
   @ObfuscatedName("oe")
   static short field378;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 1503774891
   )
   static int field379;
   @ObfuscatedName("jy")
   static String field380;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1843897951
   )
   static int field381;
   @ObfuscatedName("fx")
   static int[] field382;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -1963355791
   )
   static int field383;
   @ObfuscatedName("hu")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ob")
   static short field385;
   @ObfuscatedName("er")
   static boolean field386;
   @ObfuscatedName("cv")
   static boolean field387;
   @ObfuscatedName("hd")
   static int[] field388;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 2109648011
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 372892955
   )
   static int field390;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -1685446879
   )
   static int field391;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 547128525
   )
   static int field392;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -828771879
   )
   static int field393;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 1757188675
   )
   static int field394;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1369408785
   )
   static int field395;
   @ObfuscatedName("fa")
   static boolean field396;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 86004013
   )
   static int field397;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 473504985
   )
   static int field398;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1229505317
   )
   static int field399;
   @ObfuscatedName("fb")
   static int[] field400;
   @ObfuscatedName("on")
   static short field401;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1608499249
   )
   static int field402;
   @ObfuscatedName("fz")
   static int[] field403;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 2007642197
   )
   static int field404;
   @ObfuscatedName("fw")
   static int[] field405;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1735042113
   )
   static int field406;
   @ObfuscatedName("gj")
   static String[] field407;
   @ObfuscatedName("ga")
   static int[][] field408;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 2080319311
   )
   static int field409;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 1194874067
   )
   static int field410;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -580233977
   )
   static int field411;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1523727461
   )
   static int field412;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1478085571
   )
   static int field413;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1329253401
   )
   static int field414;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 1135546945
   )
   static int field415;
   @ObfuscatedName("id")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1820799211
   )
   static int field417;
   @ObfuscatedName("he")
   static Deque field418;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      longValue = -5631197938844290013L
   )
   static long field419;
   @ObfuscatedName("lz")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = -558214871
   )
   static int field421;
   @ObfuscatedName("oz")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 2127817149
   )
   static int field423;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 641280965
   )
   static int field424;
   @ObfuscatedName("gb")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("lv")
   static boolean[] field426;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -1208090419
   )
   static int field427;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 261035629
   )
   static int field428;
   @ObfuscatedName("lw")
   static long[] field429;
   @ObfuscatedName("ht")
   static final int[] field430;
   @ObfuscatedName("hb")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("pn")
   static PlayerComposition field432;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = -1690559603
   )
   static int field433;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -1508086823
   )
   static int field434;
   @ObfuscatedName("ka")
   static Deque field435;
   @ObfuscatedName("hf")
   static Deque field436;
   @ObfuscatedName("hs")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1780436941
   )
   static int field438;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1034145251
   )
   static int field439;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -458800521
   )
   static int field440;
   @ObfuscatedName("hm")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1184781199
   )
   static int field442;
   @ObfuscatedName("ho")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 668341321
   )
   static int field444;
   @ObfuscatedName("ks")
   static int[] field445;
   @ObfuscatedName("ha")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("iy")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("hq")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1012430789
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("ij")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 11435929
   )
   static int field451;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -424967883
   )
   static int field452;
   @ObfuscatedName("ih")
   static boolean field453;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 812929063
   )
   static int field454;
   @ObfuscatedName("ja")
   static boolean field455;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      longValue = 424994714670421481L
   )
   static long field456;
   @ObfuscatedName("cs")
   static class159 field457;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 1559930361
   )
   static int field458;
   @ObfuscatedName("it")
   static String field459;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 182819067
   )
   static int field460;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 763940127
   )
   static int field461;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 191035241
   )
   static int field462;
   @ObfuscatedName("ia")
   static String field463;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -324727487
   )
   static int field464 = -1;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -2042758491
   )
   static int field465;
   @ObfuscatedName("ji")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("gi")
   static boolean field467;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 1742044295
   )
   static int field468;
   @ObfuscatedName("jl")
   static Widget field469;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -1436926433
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -791817503
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -71924963
   )
   static int field472;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 1929971211
   )
   static int field473;
   @ObfuscatedName("jf")
   static boolean field474;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1046266073
   )
   static int field475 = -1;
   @ObfuscatedName("jp")
   static boolean field476;
   @ObfuscatedName("jh")
   static Widget field477;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 580254067
   )
   static int field478;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 926793531
   )
   static int field479;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -595533363
   )
   static int field480;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 1878571045
   )
   static int field481;
   @ObfuscatedName("op")
   static short field482;
   @ObfuscatedName("cx")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ly")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 1201702571
   )
   static int field485;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -393416395
   )
   static int field486;
   @ObfuscatedName("lr")
   static boolean[] field487;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = -2132155281
   )
   static int field488;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 1519861285
   )
   static int field489;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1001546075
   )
   static int field490;
   @ObfuscatedName("ie")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jn")
   static boolean field492;
   @ObfuscatedName("kc")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 1055605155
   )
   static int field494;
   @ObfuscatedName("kw")
   static int[] field495;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 2057973257
   )
   static int field497;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1266356299
   )
   static int field498;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 939877195
   )
   static int field499;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -70681383
   )
   static int field500;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1324222321
   )
   static int field501;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 292507591
   )
   static int field502;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -1627049769
   )
   static int field503;
   @ObfuscatedName("pw")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("jj")
   static boolean field505;
   @ObfuscatedName("kq")
   static Deque field506;
   @ObfuscatedName("kh")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("d")
   static Client field508;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 711423993
   )
   static int field509;
   @ObfuscatedName("lp")
   static boolean[] field510;
   @ObfuscatedName("iu")
   static boolean field511;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 1753757413
   )
   static int field512;
   @ObfuscatedName("lc")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 991882533
   )
   static int field514;
   @ObfuscatedName("lo")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("jg")
   static boolean field516;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 297430693
   )
   static int field517;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1840692379
   )
   static int field518;
   @ObfuscatedName("ls")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1886500127
   )
   static int field520 = 0;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -1978348795
   )
   static int field521;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = 396591125
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("jq")
   static Widget field523;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = 629245627
   )
   static int field524;
   @ObfuscatedName("lu")
   static String field525;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -1580812667
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("oj")
   static int[] field527;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -269327721
   )
   static int field528;
   @ObfuscatedName("mq")
   static int[] field529;
   @ObfuscatedName("jd")
   static Widget field530;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -448267415
   )
   static int field531;
   @ObfuscatedName("mi")
   static String field532;
   @ObfuscatedName("mj")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 386830267
   )
   static int field534;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -1688854393
   )
   static int field535;
   @ObfuscatedName("mt")
   static int[] field536;
   @ObfuscatedName("mg")
   static int[] field537;
   @ObfuscatedName("mh")
   static SpritePixels[] field538;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 268182521
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 1737255437
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -1959714589
   )
   static int field541;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 1035024341
   )
   static int field542;
   @ObfuscatedName("ky")
   static Deque field543;
   @ObfuscatedName("lx")
   static int[] field544;
   @ObfuscatedName("nk")
   static boolean field545;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = 1745172401
   )
   static int field546;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = -516075077
   )
   static int field547;
   @ObfuscatedName("ng")
   static int[] field548;
   @ObfuscatedName("nu")
   static int[] field549;
   @ObfuscatedName("nr")
   static int[] field550;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 266117503
   )
   static int field551 = 0;
   @ObfuscatedName("fo")
   static int[] field552;
   @ObfuscatedName("nd")
   static boolean field553;
   @ObfuscatedName("oa")
   static boolean[] field554;
   @ObfuscatedName("nm")
   static int[] field555;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1256876103
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 250916963
   )
   static int field557;
   @ObfuscatedName("ox")
   static int[] field558;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 729365151
   )
   static int field559;
   @ObfuscatedName("om")
   static short field560;
   @ObfuscatedName("ol")
   static short field561;
   @ObfuscatedName("oq")
   static short field562;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1865651985
   )
   static int field563;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 791709795
   )
   static int field564;
   @ObfuscatedName("ot")
   static short field565;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      longValue = 2821780089161784903L
   )
   static long field566;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 457394951
   )
   static int field567;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 1611708091
   )
   static int field568;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = -1005835533
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = -1441762879
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = 1685228235
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 1562674117
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -552738339
   )
   static int field573;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -385435799
   )
   static int field574;
   @ObfuscatedName("oy")
   static class130 field575;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = -136301941
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -1909286703
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -342836785
   )
   static int field578;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 1398132205
   )
   static int field579;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 1932850643
   )
   static int field580;
   @ObfuscatedName("py")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("pc")
   static GarbageCollectorMXBean field582;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      longValue = -4270880874480483269L
   )
   static long field583;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1456311873
   )
   static int field584;
   @ObfuscatedName("ph")
   static final class22 field585;
   @ObfuscatedName("pa")
   static int[] field586;
   @ObfuscatedName("pz")
   static int[] field587;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = -1065065535
   )
   static int field588;

   public final void init() {
      if(this.method2163()) {
         class214[] var1 = new class214[]{class214.field3168, class214.field3163, class214.field3160, class214.field3159, class214.field3165, class214.field3167, class214.field3169, class214.field3164, class214.field3161, class214.field3162, class214.field3166, class214.field3158, class214.field3170, class214.field3172, class214.field3171};
         class214[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class214 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3173);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3173)) {
               case 2:
                  field305 = Integer.parseInt(var5);
                  break;
               case 3:
                  world = Integer.parseInt(var5);
                  break;
               case 4:
                  field306 = (class179)class119.method2341(class40.method825(), Integer.parseInt(var5));
                  if(field306 == class179.field2693) {
                     MessageNode.field244 = class228.field3246;
                  } else {
                     MessageNode.field244 = class228.field3254;
                  }
               case 5:
               case 11:
               default:
                  break;
               case 6:
                  class3.field34 = var5;
                  break;
               case 7:
                  field309 = Integer.parseInt(var5);
                  break;
               case 8:
                  flags = Integer.parseInt(var5);
                  break;
               case 9:
                  field438 = Integer.parseInt(var5);
                  break;
               case 10:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 12:
                  int var7 = Integer.parseInt(var5);
                  class178[] var8 = new class178[]{class178.field2678, class178.field2680, class178.field2677, class178.field2679};
                  class178[] var9 = var8;
                  int var10 = 0;

                  class178 var6;
                  while(true) {
                     if(var10 >= var9.length) {
                        var6 = null;
                        break;
                     }

                     class178 var11 = var9[var10];
                     if(var11.field2681 == var7) {
                        var6 = var11;
                        break;
                     }

                     ++var10;
                  }

                  field304 = var6;
                  break;
               case 13:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 14:
                  ScriptState.field133 = Integer.parseInt(var5);
                  break;
               case 15:
                  field310 = var5;
               }
            }
         }

         class114.method2261();
         class101.host = this.getCodeBase().getHost();
         String var15 = field304.field2676;
         byte var12 = 0;

         try {
            class170.method3259("oldschool", var15, var12, 16);
         } catch (Exception var14) {
            class37.method822((String)null, var14);
         }

         field508 = this;
         this.method2161(765, 503, 135);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1613505822"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method264();
      Buffer.method3032();

      int var1;
      try {
         if(class138.field1919 == 1) {
            var1 = class138.field1916.method2548();
            if(var1 > 0 && class138.field1916.method2607()) {
               var1 -= FileOnDisk.field1209;
               if(var1 < 0) {
                  var1 = 0;
               }

               class138.field1916.method2547(var1);
            } else {
               class138.field1916.method2620();
               class138.field1916.method2643();
               if(null != class167.field2182) {
                  class138.field1919 = 2;
               } else {
                  class138.field1919 = 0;
               }

               class138.field1921 = null;
               class178.field2682 = null;
            }
         }
      } catch (Exception var5) {
         var5.printStackTrace();
         class138.field1916.method2620();
         class138.field1919 = 0;
         class138.field1921 = null;
         class178.field2682 = null;
         class167.field2182 = null;
      }

      class7.method91();
      Player.method242();
      class115 var3 = class115.mouse;
      synchronized(class115.mouse) {
         class115.field1794 = class115.field1809;
         class115.field1792 = class115.field1795;
         class115.field1799 = class115.field1802;
         class115.field1804 = class115.field1800;
         class115.field1796 = class115.field1801;
         class115.field1806 = class115.field1797;
         class115.field1807 = class115.field1803;
         class115.field1800 = 0;
      }

      if(Player.field259 != null) {
         var1 = Player.field259.vmethod2153();
         field503 = var1;
      }

      if(gameState == 0) {
         WallObject.method1954();
         class159.field2135.vmethod2107();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1776[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1771[var1] = 0L;
         }

         ChatMessages.field944 = 0;
      } else if(gameState == 5) {
         XClanMember.method252(this);
         WallObject.method1954();
         class159.field2135.vmethod2107();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1776[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1771[var1] = 0L;
         }

         ChatMessages.field944 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            XClanMember.method252(this);
            Ignore.method202();
         } else if(gameState == 25) {
            class165.method3161();
         }
      } else {
         XClanMember.method252(this);
      }

      if(gameState == 30) {
         NPC.method814();
      } else if(gameState == 40 || gameState == 45) {
         Ignore.method202();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1800546571"
   )
   protected final void vmethod2175() {
      boolean var1;
      label269: {
         try {
            if(class138.field1919 == 2) {
               if(null == class138.field1921) {
                  class138.field1921 = class144.method2747(class167.field2182, ScriptState.field130, class138.field1918);
                  if(class138.field1921 == null) {
                     var1 = false;
                     break label269;
                  }
               }

               if(class178.field2682 == null) {
                  class178.field2682 = new class60(class138.field1915, class138.field1914);
               }

               if(class138.field1916.method2644(class138.field1921, class138.field1917, class178.field2682, 22050)) {
                  class138.field1916.method2550();
                  class138.field1916.method2547(class1.field16);
                  class138.field1916.method2582(class138.field1921, class165.field2163);
                  class138.field1919 = 0;
                  class138.field1921 = null;
                  class178.field2682 = null;
                  class167.field2182 = null;
                  var1 = true;
                  break label269;
               }
            }
         } catch (Exception var12) {
            var12.printStackTrace();
            class138.field1916.method2620();
            class138.field1919 = 0;
            class138.field1921 = null;
            class178.field2682 = null;
            class167.field2182 = null;
         }

         var1 = false;
      }

      if(var1 && field545 && null != class44.field914) {
         class44.field914.method1150();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(field566 != 0L && class0.method11() > field566) {
            class47.method966(class8.method97());
         } else if(GameEngine.field1782) {
            Canvas var3 = GameObject.canvas;
            var3.removeKeyListener(class105.keyboard);
            var3.removeFocusListener(class105.keyboard);
            class105.field1726 = -1;
            Canvas var4 = GameObject.canvas;
            var4.removeMouseListener(class115.mouse);
            var4.removeMouseMotionListener(class115.mouse);
            var4.removeFocusListener(class115.mouse);
            class115.field1809 = 0;
            if(null != Player.field259) {
               Player.field259.vmethod2146(GameObject.canvas);
            }

            field508.method2162();
            GameObject.canvas.setBackground(Color.black);
            Widget.method3217(GameObject.canvas);
            Canvas var5 = GameObject.canvas;
            var5.addMouseListener(class115.mouse);
            var5.addMouseMotionListener(class115.mouse);
            var5.addFocusListener(class115.mouse);
            if(null != Player.field259) {
               Player.field259.vmethod2149(GameObject.canvas);
            }

            if(widgetRoot != -1) {
               CombatInfoListHolder.method797(false);
            }

            GameEngine.field1781 = true;
         }
      }

      Dimension var13 = this.method2171();
      if(class49.field976 != var13.width || var13.height != class26.field619 || GameEngine.field1781) {
         WidgetNode.method193();
         field566 = class0.method11() + 500L;
         GameEngine.field1781 = false;
      }

      boolean var8 = false;
      int var9;
      if(GameEngine.field1783) {
         GameEngine.field1783 = false;
         var8 = true;

         for(var9 = 0; var9 < 100; ++var9) {
            field510[var9] = true;
         }
      }

      if(var8) {
         class26.method611();
      }

      if(gameState == 0) {
         class44.method890(class41.field851, class41.field876, (Color)null, var8);
      } else if(gameState == 5) {
         Projectile.method874(NPC.field786, class13.field154, class175.field2651, var8);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            Projectile.method874(NPC.field786, class13.field154, class175.field2651, var8);
         } else if(gameState == 25) {
            if(field364 == 1) {
               if(field360 > field486) {
                  field486 = field360;
               }

               var9 = (field486 * 50 - field360 * 50) / field486;
               Ignore.method203("Loading - please wait." + "<br>" + " (" + var9 + "%" + ")", false);
            } else if(field364 == 2) {
               if(field362 > field381) {
                  field381 = field362;
               }

               var9 = 50 + (field381 * 50 - field362 * 50) / field381;
               Ignore.method203("Loading - please wait." + "<br>" + " (" + var9 + "%" + ")", false);
            } else {
               Ignore.method203("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            if(widgetRoot != -1) {
               var9 = widgetRoot;
               if(class30.method696(var9)) {
                  class6.method81(Widget.widgets[var9], -1);
               }
            }

            for(var9 = 0; var9 < field489; ++var9) {
               if(field510[var9]) {
                  field426[var9] = true;
               }

               field487[var9] = field510[var9];
               field510[var9] = false;
            }

            field509 = gameCycle;
            field454 = -1;
            field473 = -1;
            class110.field1758 = null;
            if(widgetRoot != -1) {
               field489 = 0;
               Ignore.method204(widgetRoot, 0, 0, class32.field758, class47.field950, 0, 0, -1);
            }

            Rasterizer2D.method4058();
            if(!isMenuOpen) {
               if(field454 != -1) {
                  PlayerComposition.method3192(field454, field473);
               }
            } else {
               WidgetNode.method191();
            }

            if(field517 == 3) {
               for(var9 = 0; var9 < field489; ++var9) {
                  if(field487[var9]) {
                     Rasterizer2D.method4005(widgetPositionX[var9], widgetPositionY[var9], widgetBoundsWidth[var9], widgetBoundsHeight[var9], 16711935, 128);
                  } else if(field426[var9]) {
                     Rasterizer2D.method4005(widgetPositionX[var9], widgetPositionY[var9], widgetBoundsWidth[var9], widgetBoundsHeight[var9], 16711680, 128);
                  }
               }
            }

            class0.method1(WallObject.plane, class36.localPlayer.x, class36.localPlayer.y, field498);
            field498 = 0;
         } else if(gameState == 40) {
            Ignore.method203("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            Ignore.method203("Please wait...", false);
         }
      } else {
         Projectile.method874(NPC.field786, class13.field154, class175.field2651, var8);
      }

      int var6;
      Graphics var14;
      if(gameState == 30 && field517 == 0 && !var8) {
         try {
            var14 = GameObject.canvas.getGraphics();

            for(var6 = 0; var6 < field489; ++var6) {
               if(field426[var6]) {
                  CombatInfo1.bufferProvider.drawSub(var14, widgetPositionX[var6], widgetPositionY[var6], widgetBoundsWidth[var6], widgetBoundsHeight[var6]);
                  field426[var6] = false;
               }
            }
         } catch (Exception var11) {
            GameObject.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var14 = GameObject.canvas.getGraphics();
            CombatInfo1.bufferProvider.draw(var14, 0, 0);

            for(var6 = 0; var6 < field489; ++var6) {
               field426[var6] = false;
            }
         } catch (Exception var10) {
            GameObject.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1036839229"
   )
   protected final void vmethod2176() {
      if(class20.chatMessages.method919()) {
         class20.chatMessages.method913();
      }

      if(field316 != null) {
         field316.field233 = false;
      }

      field316 = null;
      if(class149.field2036 != null) {
         class149.field2036.method2118();
         class149.field2036 = null;
      }

      XGrandExchangeOffer.method57();
      if(null != class115.mouse) {
         class115 var1 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

      Player.field259 = null;
      if(null != class44.field914) {
         class44.field914.method1114();
      }

      if(class167.field2189 != null) {
         class167.field2189.method1114();
      }

      if(null != class185.field2759) {
         class185.field2759.method2118();
      }

      method567();
      Player.method236();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "83"
   )
   void method264() {
      if(gameState != 1000) {
         boolean var1 = class165.method3164();
         if(!var1) {
            this.method265();
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   void method265() {
      if(class185.field2764 >= 4) {
         this.method2160("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2765 >= 4) {
            if(gameState <= 5) {
               this.method2160("js5io");
               gameState = 1000;
               return;
            }

            field417 = 3000;
            class185.field2765 = 3;
         }

         if(--field417 + 1 <= 0) {
            try {
               if(field334 == 0) {
                  WidgetNode.field188 = class33.field775.method2024(class101.host, class142.field1999);
                  ++field334;
               }

               if(field334 == 1) {
                  if(WidgetNode.field188.field1671 == 2) {
                     this.method266(-1);
                     return;
                  }

                  if(WidgetNode.field188.field1671 == 1) {
                     ++field334;
                  }
               }

               if(field334 == 2) {
                  Item.field907 = new class110((Socket)WidgetNode.field188.field1672, class33.field775);
                  Buffer var1 = new Buffer(5);
                  var1.method2918(15);
                  var1.method2821(135);
                  Item.field907.method2114(var1.payload, 0, 5);
                  ++field334;
                  XClanMember.field292 = class0.method11();
               }

               if(field334 == 3) {
                  if(gameState > 5 && Item.field907.method2128() <= 0) {
                     if(class0.method11() - XClanMember.field292 > 30000L) {
                        this.method266(-2);
                        return;
                     }
                  } else {
                     int var5 = Item.field907.method2116();
                     if(var5 != 0) {
                        this.method266(var5);
                        return;
                     }

                     ++field334;
                  }
               }

               if(field334 == 4) {
                  class110 var10 = Item.field907;
                  boolean var2 = gameState > 20;
                  if(class185.field2759 != null) {
                     try {
                        class185.field2759.method2118();
                     } catch (Exception var8) {
                        ;
                     }

                     class185.field2759 = null;
                  }

                  class185.field2759 = var10;
                  class110.method2137(var2);
                  class185.field2758.offset = 0;
                  class181.field2706 = null;
                  class142.field2001 = null;
                  class185.field2748 = 0;

                  while(true) {
                     class181 var3 = (class181)class185.field2756.method2403();
                     if(null == var3) {
                        while(true) {
                           var3 = (class181)class185.field2767.method2403();
                           if(null == var3) {
                              if(class185.field2762 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.method2918(4);
                                    var11.method2918(class185.field2762);
                                    var11.method2831(0);
                                    class185.field2759.method2114(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class185.field2759.method2118();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class185.field2765;
                                    class185.field2759 = null;
                                 }
                              }

                              class185.field2747 = 0;
                              class185.field2757 = class0.method11();
                              WidgetNode.field188 = null;
                              Item.field907 = null;
                              field334 = 0;
                              field406 = 0;
                              return;
                           }

                           class185.field2753.method2346(var3);
                           class185.field2754.method2400(var3, var3.hash);
                           ++class185.field2751;
                           --class185.field2750;
                        }
                     }

                     class185.field2749.method2400(var3, var3.hash);
                     ++class185.field2763;
                     --class185.field2752;
                  }
               }
            } catch (IOException var9) {
               this.method266(-3);
            }

         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-57"
   )
   void method266(int var1) {
      WidgetNode.field188 = null;
      Item.field907 = null;
      field334 = 0;
      if(class142.field1999 == class16.field187) {
         class142.field1999 = class164.field2158;
      } else {
         class142.field1999 = class16.field187;
      }

      ++field406;
      if(field406 < 2 || var1 != 7 && var1 != 9) {
         if(field406 >= 2 && var1 == 6) {
            this.method2160("js5connect_outofdate");
            gameState = 1000;
         } else if(field406 >= 4) {
            if(gameState <= 5) {
               this.method2160("js5connect");
               gameState = 1000;
            } else {
               field417 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2160("js5connect_full");
         gameState = 1000;
      } else {
         field417 = 3000;
      }

   }

   static {
      field331 = class40.field836;
      field332 = class40.field836;
      field333 = 0;
      field334 = 0;
      field417 = 0;
      field406 = 0;
      field518 = 0;
      field361 = 0;
      field341 = 0;
      field342 = 0;
      cachedNPCs = new NPC['耀'];
      field340 = 0;
      field345 = new int['耀'];
      field346 = 0;
      field347 = new int[250];
      field348 = new class159(5000);
      field457 = new class159(5000);
      field350 = new class159(15000);
      field351 = 0;
      packetOpcode = 0;
      field559 = 0;
      field354 = 0;
      field355 = 0;
      field356 = 0;
      field574 = 0;
      field358 = 0;
      field387 = false;
      field360 = 0;
      field486 = 1;
      field362 = 0;
      field381 = 1;
      field364 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field367 = new int[4][13][13];
      field368 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field481 = 0;
      field370 = 2;
      field371 = 0;
      field372 = 2;
      field339 = 0;
      field439 = 1;
      field357 = 0;
      mapScale = 0;
      field377 = 2;
      mapScaleDelta = 0;
      field379 = 1;
      field578 = 0;
      field498 = 0;
      field335 = 2301979;
      field383 = 5063219;
      field376 = 3353893;
      field404 = 7759444;
      field386 = false;
      field478 = 0;
      field541 = 128;
      mapAngle = 0;
      field390 = 0;
      field391 = 0;
      field392 = 0;
      field393 = 0;
      field394 = 50;
      field395 = 0;
      field396 = false;
      field397 = 0;
      field398 = 0;
      field465 = 50;
      field400 = new int[field465];
      field375 = new int[field465];
      field317 = new int[field465];
      field403 = new int[field465];
      field382 = new int[field465];
      field405 = new int[field465];
      field552 = new int[field465];
      field407 = new String[field465];
      field408 = new int[104][104];
      field409 = 0;
      field410 = -1;
      field411 = -1;
      field412 = 0;
      field413 = 0;
      field414 = 0;
      field415 = 0;
      field452 = 0;
      field444 = 0;
      field402 = 0;
      field359 = 0;
      field399 = 0;
      field501 = 0;
      field467 = false;
      field423 = 0;
      field424 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field427 = 0;
      field428 = 0;
      field388 = new int[1000];
      field430 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriority = new boolean[8];
      field344 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field434 = -1;
      groundItemDeque = new Deque[4][104][104];
      field436 = new Deque();
      projectiles = new Deque();
      field418 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field442 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field314 = false;
      field433 = -1;
      field453 = false;
      field454 = -1;
      field473 = -1;
      field299 = 0;
      field584 = 50;
      field458 = 0;
      field459 = null;
      field511 = false;
      field461 = -1;
      field462 = -1;
      field463 = null;
      field380 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field338 = 0;
      field468 = 0;
      field469 = null;
      energy = 0;
      weight = 0;
      field472 = 0;
      field514 = -1;
      field474 = false;
      field505 = false;
      field476 = false;
      field477 = null;
      field523 = null;
      field530 = null;
      field480 = 0;
      field369 = 0;
      field343 = null;
      field516 = false;
      field319 = -1;
      field485 = -1;
      field455 = false;
      field531 = -1;
      field488 = -1;
      field492 = false;
      field490 = 1;
      field445 = new int[32];
      field535 = 0;
      interfaceItemTriggers = new int[32];
      field494 = 0;
      field495 = new int[32];
      field460 = 0;
      field497 = 0;
      field451 = 0;
      field499 = 0;
      field500 = 0;
      field440 = 0;
      field502 = 0;
      field503 = 0;
      field435 = new Deque();
      field543 = new Deque();
      field506 = new Deque();
      widgetFlags = new XHashTable(512);
      field489 = 0;
      field509 = -2;
      field510 = new boolean[100];
      field426 = new boolean[100];
      field487 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field517 = 0;
      field566 = 0L;
      isResized = true;
      field563 = 765;
      field521 = 503;
      field544 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field588 = 0;
      field524 = 0;
      field525 = "";
      field429 = new long[100];
      field557 = 0;
      field528 = 0;
      field529 = new int[128];
      field323 = new int[128];
      field419 = -1L;
      field532 = null;
      clanChatOwner = null;
      field534 = -1;
      field512 = 0;
      field536 = new int[1000];
      field537 = new int[1000];
      field538 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field564 = 0;
      field542 = 255;
      field421 = -1;
      field545 = false;
      field479 = 127;
      field546 = 127;
      field547 = 0;
      field548 = new int[50];
      field549 = new int[50];
      field550 = new int[50];
      field555 = new int[50];
      field349 = new class53[50];
      field553 = false;
      field554 = new boolean[5];
      field327 = new int[5];
      field527 = new int[5];
      field311 = new int[5];
      field558 = new int[5];
      field385 = 256;
      field560 = 205;
      field561 = 256;
      field562 = 320;
      field378 = 1;
      field482 = 32767;
      field565 = 1;
      field401 = 32767;
      field567 = 0;
      field568 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field573 = 0;
      friends = new Friend[400];
      field575 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field432 = new PlayerComposition();
      field579 = -1;
      field580 = 1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field583 = -1L;
      field456 = -1L;
      field585 = new class22();
      field586 = new int[50];
      field587 = new int[50];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "721112879"
   )
   public static String method343(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3077[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1205572676"
   )
   public static char method359(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1812159670"
   )
   protected final void vmethod2173() {
      class16.field187 = field305 == 0?'ꩊ':world + '鱀';
      class164.field2158 = field305 == 0?443:world + '썐';
      class142.field1999 = class16.field187;
      CombatInfoListHolder.field782 = class167.field2187;
      class114.field1788 = class167.field2186;
      PlayerComposition.field2180 = class167.field2183;
      class47.field952 = class167.field2185;
      ScriptState.method150();
      Widget.method3217(GameObject.canvas);
      Canvas var1 = GameObject.canvas;
      var1.addMouseListener(class115.mouse);
      var1.addMouseMotionListener(class115.mouse);
      var1.addFocusListener(class115.mouse);
      Player.field259 = class112.method2158();
      if(Player.field259 != null) {
         Player.field259.vmethod2149(GameObject.canvas);
      }

      class187.field2781 = new class116(255, class104.field1695, class104.field1696, 500000);
      class184.field2735 = class167.method3200();
      class115.field1810 = this.getToolkit().getSystemClipboard();
      class31.method704(this, class16.field186);
      if(field305 != 0) {
         field321 = true;
      }

      class47.method966(class184.field2735.field716);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "124"
   )
   public static void method567() {
      Object var0 = class183.field2732;
      synchronized(class183.field2732) {
         if(class183.field2729 != 0) {
            class183.field2729 = 1;

            try {
               class183.field2732.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1556589275"
   )
   protected final void vmethod2179() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1980649453"
   )
   static void method600(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = CombatInfo1.method641(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = CombatInfo1.method641(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method600(var0, var7 - 1, var2, var3, var4, var5);
         method600(1 + var7, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "763432481"
   )
   static void method601() {
      for(WidgetNode var0 = (WidgetNode)componentTable.method2403(); var0 != null; var0 = (WidgetNode)componentTable.method2411()) {
         int var1 = var0.id;
         if(class30.method696(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class179.method3296(var4);
               if(var5 != null) {
                  class174.method3276(var5);
               }
            }
         }
      }

   }
}
