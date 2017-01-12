import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
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
   @ObfuscatedName("ar")
   static class110 field278;
   @ObfuscatedName("i")
   static Client field279;
   @ObfuscatedName("a")
   static boolean field280 = true;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -863394603
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("ib")
   static String field282;
   @ObfuscatedName("d")
   static class178 field283;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 1348002049
   )
   static int field284;
   @ObfuscatedName("t")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("m")
   static boolean field286 = false;
   @ObfuscatedName("kn")
   static int[] field287;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 490826049
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 490677517
   )
   static int field289;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1635420199
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 307406003199022027L
   )
   static long field291 = -1L;
   @ObfuscatedName("ns")
   static int[] field292;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -793507107
   )
   static int field293 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1200953329
   )
   static int field294 = -1;
   @ObfuscatedName("ag")
   static boolean field295 = true;
   @ObfuscatedName("al")
   static boolean field296 = false;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1806158543
   )
   static int field297 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1044261811
   )
   static int field298 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1938708767
   )
   static int field299 = 0;
   @ObfuscatedName("jg")
   static boolean field300;
   @ObfuscatedName("r")
   static boolean field301 = true;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -598242883
   )
   static int field302;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -816200395
   )
   static int field303;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 633963837
   )
   static int field304 = 0;
   @ObfuscatedName("mb")
   static SpritePixels[] field305;
   @ObfuscatedName("ak")
   static class40 field306;
   @ObfuscatedName("aq")
   static class40 field307;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -36355961
   )
   static int field308;
   @ObfuscatedName("hu")
   static int[] field309;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 827669711
   )
   static int field310;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1890763021
   )
   static int field311;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      longValue = 1109494364431627755L
   )
   static long field312;
   @ObfuscatedName("il")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("bt")
   static class184 field314;
   @ObfuscatedName("ob")
   static int[] field315;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1308256019
   )
   static int field316;
   @ObfuscatedName("hh")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1925844909
   )
   static int field318;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -465554323
   )
   static int field319;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 53054149
   )
   static int field320;
   @ObfuscatedName("ci")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1405881213
   )
   static int field322;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 765698805
   )
   static int field323 = 0;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1529544359
   )
   static int field324;
   @ObfuscatedName("kj")
   static Deque field325;
   @ObfuscatedName("cb")
   static class159 field326;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -566455045
   )
   static int field328;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 561709601
   )
   static int field329;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 719041449
   )
   static int field330;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -312116293
   )
   static int field331;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1015712589
   )
   static int field332;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 229621363
   )
   static int field333;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -134656997
   )
   static int field334;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -633428807
   )
   static int field335;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -614050823
   )
   static int field336;
   @ObfuscatedName("ca")
   static boolean field337;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -65423699
   )
   static int field338;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1667349077
   )
   static int field339 = -1;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1304462997
   )
   static int field340;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -1066981531
   )
   static int field341;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 850078289
   )
   static int field342;
   @ObfuscatedName("bo")
   static class184 field343;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 659296647
   )
   static int field344;
   @ObfuscatedName("dt")
   static int[][][] field345;
   @ObfuscatedName("dx")
   static final int[] field346;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -2082374559
   )
   static int field347;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -748447941
   )
   static int field348;
   @ObfuscatedName("bw")
   static class184 field349;
   @ObfuscatedName("op")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 181022785
   )
   static int field351;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -1339252929
   )
   static int field352;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -376832575
   )
   static int field353;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -1966574171
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -501165225
   )
   static int field355;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -677502381
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 1691065495
   )
   static int field357;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -771760403
   )
   static int field358;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 276923485
   )
   static int field359;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1071646305
   )
   static int field360;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 351840273
   )
   static int field361;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = 206843445
   )
   static int field362;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 662236177
   )
   static int field363;
   @ObfuscatedName("ez")
   static boolean field364;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1733829553
   )
   static int field365;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      longValue = 6179084772064095153L
   )
   static long field366;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 915090425
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("ok")
   static int[] field368;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -463986143
   )
   static int field369;
   @ObfuscatedName("cl")
   static int[] field370;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1988772133
   )
   static int field371;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 1421602039
   )
   static int field372;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1908106247
   )
   static int field373;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 659465405
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("hg")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 2134078485
   )
   static int field376;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -1222467333
   )
   static int field377;
   @ObfuscatedName("fc")
   static int[] field378;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      longValue = -6999610115471340813L
   )
   static long field379;
   @ObfuscatedName("fl")
   static int[] field380;
   @ObfuscatedName("ff")
   static int[] field381;
   @ObfuscatedName("pw")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("ov")
   static class130 field383;
   @ObfuscatedName("ft")
   static int[] field384;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 1001392823
   )
   static int field385;
   @ObfuscatedName("ge")
   static int[][] field386;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -640701571
   )
   static int field387;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1703461871
   )
   static int field388;
   @ObfuscatedName("ol")
   static short field389;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1547379321
   )
   static int field390;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -422920213
   )
   static int field391;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1926990289
   )
   static int field392;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 1789054731
   )
   static int field393;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -413358233
   )
   static int field394;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 1644554825
   )
   static int field395;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 86803557
   )
   static int field396;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 2014130989
   )
   static int field397;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -1933678649
   )
   static int field398;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 261944455
   )
   static int field399;
   @ObfuscatedName("gc")
   static boolean field400;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1231540231
   )
   static int field401;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1966380943
   )
   static int field402;
   @ObfuscatedName("pi")
   static final class22 field403;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1572225281
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("hm")
   static Deque field405;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 590749157
   )
   static int field406;
   @ObfuscatedName("fu")
   static int[] field407;
   @ObfuscatedName("hd")
   static final int[] field408;
   @ObfuscatedName("cm")
   static class159 field409;
   @ObfuscatedName("hc")
   static boolean[] field410;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -1631458499
   )
   static int field412;
   @ObfuscatedName("he")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("jo")
   static boolean field414;
   @ObfuscatedName("hr")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1578328973
   )
   static int field416 = 0;
   @ObfuscatedName("cv")
   static class159 field417;
   @ObfuscatedName("hl")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("hp")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 29212517
   )
   static int field420;
   @ObfuscatedName("hw")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 321341557
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("gt")
   static String[] field423;
   @ObfuscatedName("ho")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("iv")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1489240735
   )
   static int field426 = 0;
   @ObfuscatedName("ir")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ia")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 655839589
   )
   static int field429;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1012975033
   )
   static int field430;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -1097756523
   )
   static int field431;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -1061615663
   )
   static int field432;
   @ObfuscatedName("gp")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("dg")
   static boolean field434;
   @ObfuscatedName("io")
   static boolean field435;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 2006273801
   )
   static int field436;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -1719462049
   )
   static int field437;
   @ObfuscatedName("ii")
   static String field438;
   @ObfuscatedName("fp")
   static int[] field439;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 304719981
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ij")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -1335827745
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("fz")
   static int[] field443;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = 623130301
   )
   static int field444;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1352383577
   )
   static int field445;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1276964411
   )
   static int field446;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -10843161
   )
   static int field447;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -1976172219
   )
   static int field448;
   @ObfuscatedName("ju")
   static boolean field449;
   @ObfuscatedName("lk")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 449498141
   )
   static int field451;
   @ObfuscatedName("ja")
   static Widget field452;
   @ObfuscatedName("jq")
   static Widget field453;
   @ObfuscatedName("jc")
   static Widget field454;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -837207997
   )
   static int field455;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 1600745765
   )
   static int field456;
   @ObfuscatedName("je")
   static Widget field457;
   @ObfuscatedName("js")
   static boolean field458;
   @ObfuscatedName("hv")
   static int[] field459;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -5475757
   )
   static int field460;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1386520803
   )
   static int field461;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 962989797
   )
   static int field462;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -382875953
   )
   static int field463;
   @ObfuscatedName("jx")
   static boolean field464;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 1858141683
   )
   static int field465;
   @ObfuscatedName("hj")
   static String[] field466;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -1694604883
   )
   static int field467;
   @ObfuscatedName("it")
   static String field468;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 1996459991
   )
   static int field469;
   @ObfuscatedName("kq")
   static int[] field470;
   @ObfuscatedName("kt")
   static int[] field471;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1618722341
   )
   static int field472 = 0;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -1206498843
   )
   static int field473;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = 481604667
   )
   static int field474;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 120726363
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 1565960557
   )
   static int field476;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -253306945
   )
   static int field477;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 2132491463
   )
   static int field478;
   @ObfuscatedName("kc")
   static Deque field479;
   @ObfuscatedName("kp")
   static Deque field480;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1289852599
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("kv")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("cr")
   static int[] field483;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -592275799
   )
   static int field484;
   @ObfuscatedName("kf")
   static boolean[] field485;
   @ObfuscatedName("lz")
   static boolean[] field486;
   @ObfuscatedName("lc")
   static boolean[] field487;
   @ObfuscatedName("lo")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("lb")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 580770471
   )
   static int field490;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 743019347
   )
   static int field491;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 1476080017
   )
   static int field492;
   @ObfuscatedName("nl")
   static boolean[] field493;
   @ObfuscatedName("lm")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = 1118039397
   )
   static int field495;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 1019693827
   )
   static int field496;
   @ObfuscatedName("ly")
   static int[] field497;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 688825347
   )
   static int field498;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -1480906621
   )
   static int field499;
   @ObfuscatedName("nw")
   static int[] field500;
   @ObfuscatedName("lr")
   static long[] field501;
   @ObfuscatedName("lp")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -766704937
   )
   static int field503;
   @ObfuscatedName("lw")
   static int[] field504;
   @ObfuscatedName("mp")
   static int[] field505;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      longValue = -7396607726961267665L
   )
   static long field506;
   @ObfuscatedName("me")
   static String field507;
   @ObfuscatedName("my")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 954663375
   )
   static int field509;
   @ObfuscatedName("oj")
   static int[] field510;
   @ObfuscatedName("mw")
   static int[] field511;
   @ObfuscatedName("mr")
   static int[] field512;
   @ObfuscatedName("oq")
   static short field513;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = -16441653
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("fm")
   static boolean field515;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = -1875281189
   )
   static int field516;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 2103918219
   )
   static int field517;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -1843018085
   )
   static int field518;
   @ObfuscatedName("mn")
   static boolean field519;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 297165351
   )
   static int field520;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 1542768195
   )
   static int field521;
   @ObfuscatedName("ne")
   static class57 field522;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -1849640865
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 887851351
   )
   static int field524;
   @ObfuscatedName("jw")
   static boolean field525;
   @ObfuscatedName("nu")
   static int[] field526;
   @ObfuscatedName("nn")
   static int[] field527;
   @ObfuscatedName("np")
   static class53[] field528;
   @ObfuscatedName("nv")
   static boolean field529;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 954125567
   )
   static int field530 = 0;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1214668437
   )
   static int field531;
   @ObfuscatedName("od")
   static int[] field532;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -314030857
   )
   static int field533;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 76236419
   )
   static int field534 = 0;
   @ObfuscatedName("om")
   static short field535;
   @ObfuscatedName("og")
   static short field536;
   @ObfuscatedName("jl")
   static Widget field537;
   @ObfuscatedName("oc")
   static short field538;
   @ObfuscatedName("ou")
   static short field539;
   @ObfuscatedName("or")
   static short field540;
   @ObfuscatedName("of")
   static short field541;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2005991835
   )
   static int field542;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 588972749
   )
   static int field543;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 928018049
   )
   static int field544 = 0;
   @ObfuscatedName("ha")
   static Deque field545;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 742160489
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -595449069
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -933731
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1351237311
   )
   static int field549;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -828793613
   )
   static int field550;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 1662832671
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 1209902895
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("ox")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("lx")
   static String field554;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = 2005491565
   )
   static int field555;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -31823799
   )
   static int field556;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 1642979513
   )
   static int field557;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -1423457147
   )
   static int field558;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      longValue = 2831409402904947007L
   )
   static long field559;
   @ObfuscatedName("ot")
   static PlayerComposition field560;
   @ObfuscatedName("pa")
   static int[] field561;
   @ObfuscatedName("pj")
   static int[] field562;
   @ObfuscatedName("bz")
   static class184 field563;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1839628547"
   )
   protected final void vmethod2076() {
   }

   public final void init() {
      if(this.method2091()) {
         class214[] var1 = class45.method819();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class214 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3156);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3156)) {
               case 1:
                  class217.field3167 = var4;
                  break;
               case 2:
                  field472 = Integer.parseInt(var4);
                  break;
               case 3:
                  field283 = class97.method1877(Integer.parseInt(var4));
                  break;
               case 4:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 5:
                  class15.field170 = var4;
                  break;
               case 6:
                  flags = Integer.parseInt(var4);
                  break;
               case 7:
                  Overlay.field3034 = Integer.parseInt(var4);
                  break;
               case 8:
                  world = Integer.parseInt(var4);
                  break;
               case 9:
                  field416 = Integer.parseInt(var4);
               case 10:
               case 12:
               case 13:
               default:
                  break;
               case 11:
                  class171.field2331 = Integer.parseInt(var4);
                  break;
               case 14:
                  class179[] var5 = new class179[]{class179.field2666, class179.field2664, class179.field2660, class179.field2662, class179.field2661, class179.field2665};
                  class13.field139 = (class179)class181.method3258(var5, Integer.parseInt(var4));
                  if(class13.field139 == class179.field2660) {
                     Ignore.field209 = class228.field3241;
                  } else {
                     Ignore.field209 = class228.field3238;
                  }
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

         Region.field1522 = false;
         field286 = false;
         class152.host = this.getCodeBase().getHost();
         String var7 = field283.field2656;
         byte var8 = 0;

         try {
            Sequence.method3784("oldschool", var7, var8, 16);
         } catch (Exception var6) {
            class174.method3240((String)null, var6);
         }

         field279 = this;
         this.method2087(765, 503, 130);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   protected final void vmethod2086() {
      class107.field1719 = field416 == 0?'ꩊ':world + '鱀';
      class9.field90 = field416 == 0?443:world + '썐';
      Tile.field1351 = class107.field1719;
      class156.field2098 = class167.field2166;
      class227.field3229 = class167.field2171;
      PlayerComposition.field2161 = class167.field2172;
      CombatInfo1.field665 = class167.field2168;
      CombatInfo1.method617();
      class145.method2707(class165.canvas);
      Canvas var1 = class165.canvas;
      var1.addMouseListener(class115.mouse);
      var1.addMouseMotionListener(class115.mouse);
      var1.addFocusListener(class115.mouse);
      class179.field2663 = GameObject.method1873();
      if(class179.field2663 != null) {
         class179.field2663.vmethod2053(class165.canvas);
      }

      class7.field60 = new class116(255, class104.field1676, class104.field1677, 500000);
      FileOnDisk var3 = null;
      class30 var4 = new class30();

      try {
         var3 = class47.method856("", class13.field139.field2669, false);
         byte[] var5 = new byte[(int)var3.method1367()];

         int var7;
         for(int var6 = 0; var6 < var5.length; var6 += var7) {
            var7 = var3.method1368(var5, var6, var5.length - var6);
            if(var7 == -1) {
               throw new IOException();
            }
         }

         var4 = new class30(new Buffer(var5));
      } catch (Exception var10) {
         ;
      }

      try {
         if(null != var3) {
            var3.method1365();
         }
      } catch (Exception var9) {
         ;
      }

      class2.field21 = var4;
      class160.field2118 = this.getToolkit().getSystemClipboard();
      class49.method873(this, class101.field1642);
      if(field416 != 0) {
         field296 = true;
      }

      int var8 = class2.field21.field687;
      field379 = 0L;
      if(var8 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      class31.method682();
      if(gameState >= 25) {
         field326.method3029(112);
         field326.method2760(class182.method3335());
         field326.method2918(class0.field1);
         field326.method2918(class65.field1099);
      }

      GameEngine.field1768 = true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "329861939"
   )
   protected final void vmethod2066() {
      boolean var1;
      label211: {
         try {
            if(class138.field1900 == 2) {
               if(ChatMessages.field914 == null) {
                  ChatMessages.field914 = class144.method2698(class138.field1903, class47.field920, class0.field2);
                  if(ChatMessages.field914 == null) {
                     var1 = false;
                     break label211;
                  }
               }

               if(null == class107.field1725) {
                  class107.field1725 = new class60(Ignore.field210, class138.field1902);
               }

               if(class138.field1899.method2479(ChatMessages.field914, class138.field1901, class107.field1725, 22050)) {
                  class138.field1899.method2492();
                  class138.field1899.method2544(FrameMap.field1466);
                  class138.field1899.method2482(ChatMessages.field914, ChatMessages.field916);
                  class138.field1900 = 0;
                  ChatMessages.field914 = null;
                  class107.field1725 = null;
                  class138.field1903 = null;
                  var1 = true;
                  break label211;
               }
            }
         } catch (Exception var12) {
            var12.printStackTrace();
            class138.field1899.method2570();
            class138.field1900 = 0;
            ChatMessages.field914 = null;
            class107.field1725 = null;
            class138.field1903 = null;
         }

         var1 = false;
      }

      if(var1 && field519 && null != field522) {
         field522.method1021();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(field379 != 0L && class9.method117() > field379) {
            int var3 = class182.method3335();
            field379 = 0L;
            if(var3 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            class31.method682();
            if(gameState >= 25) {
               field326.method3029(112);
               field326.method2760(class182.method3335());
               field326.method2918(class0.field1);
               field326.method2918(class65.field1099);
            }

            GameEngine.field1768 = true;
         } else if(GameEngine.field1771) {
            Buffer.method2987();
         }
      }

      Dimension var8 = this.method2075();
      if(var8.width != ItemLayer.field1211 || class11.field115 != var8.height || GameEngine.field1770) {
         class31.method682();
         field379 = class9.method117() + 500L;
         GameEngine.field1770 = false;
      }

      boolean var4 = false;
      int var5;
      if(GameEngine.field1768) {
         GameEngine.field1768 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field485[var5] = true;
         }
      }

      if(var4) {
         method588();
      }

      if(gameState == 0) {
         FrameMap.method1668(class41.field825, class41.field826, (Color)null, var4);
      } else if(gameState == 5) {
         class9.method116(class97.field1621, FileOnDisk.field1186, class22.field235, var4);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class9.method116(class97.field1621, FileOnDisk.field1186, class22.field235, var4);
         } else if(gameState == 25) {
            if(field342 == 1) {
               if(field338 > field456) {
                  field456 = field338;
               }

               var5 = (field456 * 50 - field338 * 50) / field456;
               VertexNormal.method1599("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field342 == 2) {
               if(field340 > field341) {
                  field341 = field340;
               }

               var5 = (field341 * 50 - field340 * 50) / field341 + 50;
               VertexNormal.method1599("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               VertexNormal.method1599("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            class22.method207();
         } else if(gameState == 40) {
            VertexNormal.method1599("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            VertexNormal.method1599("Please wait...", false);
         }
      } else {
         class9.method116(class97.field1621, FileOnDisk.field1186, class22.field235, var4);
      }

      int var6;
      Graphics var9;
      if(gameState == 30 && field492 == 0 && !var4) {
         try {
            var9 = class165.canvas.getGraphics();

            for(var6 = 0; var6 < field533; ++var6) {
               if(field486[var6]) {
                  GameEngine.bufferProvider.drawSub(var9, widgetPositionX[var6], widgetPositionY[var6], widgetBoundsWidth[var6], widgetBoundsHeight[var6]);
                  field486[var6] = false;
               }
            }
         } catch (Exception var11) {
            class165.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var9 = class165.canvas.getGraphics();
            GameEngine.bufferProvider.draw(var9, 0, 0);

            for(var6 = 0; var6 < field533; ++var6) {
               field486[var6] = false;
            }
         } catch (Exception var10) {
            class165.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1952209440"
   )
   void method251(int var1) {
      class45.field902 = null;
      field278 = null;
      field310 = 0;
      if(Tile.field1351 == class107.field1719) {
         Tile.field1351 = class9.field90;
      } else {
         Tile.field1351 = class107.field1719;
      }

      ++field316;
      if(field316 < 2 || var1 != 7 && var1 != 9) {
         if(field316 >= 2 && var1 == 6) {
            this.method2073("js5connect_outofdate");
            gameState = 1000;
         } else if(field316 >= 4) {
            if(gameState <= 5) {
               this.method2073("js5connect");
               gameState = 1000;
            } else {
               field311 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2073("js5connect_full");
         gameState = 1000;
      } else {
         field311 = 3000;
      }

   }

   static {
      field306 = class40.field798;
      field307 = class40.field798;
      field542 = 0;
      field310 = 0;
      field311 = 0;
      field316 = 0;
      field329 = 0;
      field318 = 0;
      field319 = 0;
      field320 = 0;
      cachedNPCs = new NPC['耀'];
      field322 = 0;
      field483 = new int['耀'];
      field324 = 0;
      field370 = new int[250];
      field326 = new class159(5000);
      field417 = new class159(5000);
      field409 = new class159(15000);
      field328 = 0;
      packetOpcode = 0;
      field308 = 0;
      field332 = 0;
      field333 = 0;
      field334 = 0;
      field335 = 0;
      field336 = 0;
      field337 = false;
      field338 = 0;
      field456 = 1;
      field340 = 0;
      field341 = 1;
      field342 = 0;
      collisionMaps = new CollisionData[4];
      field434 = false;
      field345 = new int[4][13][13];
      field346 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field347 = 0;
      field348 = 2;
      field394 = 0;
      field331 = 2;
      field351 = 0;
      field353 = 1;
      field302 = 0;
      mapScale = 0;
      field355 = 2;
      mapScaleDelta = 0;
      field357 = 1;
      field473 = 0;
      field462 = 0;
      field360 = 2301979;
      field478 = 5063219;
      field451 = 3353893;
      field363 = 7759444;
      field364 = false;
      field365 = 0;
      field520 = 128;
      mapAngle = 0;
      field385 = 0;
      field369 = 0;
      field521 = 0;
      field371 = 0;
      field372 = 50;
      field373 = 0;
      field515 = false;
      field406 = 0;
      field376 = 0;
      field377 = 50;
      field378 = new int[field377];
      field439 = new int[field377];
      field380 = new int[field377];
      field381 = new int[field377];
      field443 = new int[field377];
      field407 = new int[field377];
      field384 = new int[field377];
      field423 = new String[field377];
      field386 = new int[104][104];
      field387 = 0;
      field388 = -1;
      field491 = -1;
      field390 = 0;
      field391 = 0;
      field392 = 0;
      field393 = 0;
      field531 = 0;
      field395 = 0;
      field396 = 0;
      field397 = 0;
      field398 = 0;
      field399 = 0;
      field400 = false;
      field401 = 0;
      field402 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field461 = 0;
      field330 = 0;
      field459 = new int[1000];
      field408 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field466 = new String[8];
      field410 = new boolean[8];
      field309 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field412 = -1;
      groundItemDeque = new Deque[4][104][104];
      field545 = new Deque();
      projectiles = new Deque();
      field405 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field303 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field429 = -1;
      field430 = -1;
      field431 = 0;
      field361 = 50;
      field447 = 0;
      field468 = null;
      field435 = false;
      field436 = -1;
      field437 = -1;
      field438 = null;
      field282 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field445 = 0;
      field558 = 0;
      field537 = null;
      energy = 0;
      weight = 0;
      field352 = 0;
      field448 = -1;
      field449 = false;
      field414 = false;
      field300 = false;
      field452 = null;
      field453 = null;
      field454 = null;
      field455 = 0;
      field550 = 0;
      field457 = null;
      field458 = false;
      field490 = -1;
      field284 = -1;
      field525 = false;
      field509 = -1;
      field463 = -1;
      field464 = false;
      field446 = 1;
      field287 = new int[32];
      field467 = 0;
      field471 = new int[32];
      field469 = 0;
      field470 = new int[32];
      field344 = 0;
      field289 = 0;
      field460 = 0;
      field474 = 0;
      field549 = 0;
      field476 = 0;
      field477 = 0;
      field524 = 0;
      field479 = new Deque();
      field480 = new Deque();
      field325 = new Deque();
      widgetFlags = new XHashTable(512);
      field533 = 0;
      field484 = -2;
      field485 = new boolean[100];
      field486 = new boolean[100];
      field487 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field492 = 0;
      field379 = 0L;
      isResized = true;
      field495 = 765;
      field496 = 503;
      field497 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field498 = 0;
      field499 = 0;
      field554 = "";
      field501 = new long[100];
      field432 = 0;
      field503 = 0;
      field504 = new int[128];
      field505 = new int[128];
      field506 = -1L;
      field507 = null;
      clanChatOwner = null;
      field359 = -1;
      field362 = 0;
      field511 = new int[1000];
      field512 = new int[1000];
      field305 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field543 = 0;
      field517 = 255;
      field444 = -1;
      field519 = false;
      field358 = 127;
      field557 = 127;
      field516 = 0;
      field500 = new int[50];
      field292 = new int[50];
      field526 = new int[50];
      field527 = new int[50];
      field528 = new class53[50];
      field529 = false;
      field493 = new boolean[5];
      field368 = new int[5];
      field532 = new int[5];
      field315 = new int[5];
      field510 = new int[5];
      field535 = 256;
      field536 = 205;
      field389 = 256;
      field538 = 320;
      field539 = 1;
      field540 = 32767;
      field541 = 1;
      field513 = 32767;
      field420 = 0;
      field518 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field465 = 0;
      friends = new Friend[400];
      field383 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field560 = new PlayerComposition();
      field555 = -1;
      field556 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field366 = -1L;
      field559 = -1L;
      field403 = new class22();
      field561 = new int[50];
      field562 = new int[50];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected final void vmethod2157() {
      if(Renderable.chatMessages.method838()) {
         Renderable.chatMessages.method842();
      }

      if(null != class191.field2796) {
         class191.field2796.field218 = false;
      }

      class191.field2796 = null;
      if(class37.field774 != null) {
         class37.field774.method2026();
         class37.field774 = null;
      }

      class105.method1982();
      if(null != class115.mouse) {
         class115 var1 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

      class179.field2663 = null;
      if(null != field522) {
         field522.method1022();
      }

      if(class13.field150 != null) {
         class13.field150.method1022();
      }

      CombatInfoListHolder.method708();
      class179.method3256();
      ChatMessages.method826();
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-26469"
   )
   static final void method312(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field533; ++var4) {
         if(widgetPositionX[var4] + widgetBoundsWidth[var4] > var0 && widgetPositionX[var4] < var2 + var0 && widgetPositionY[var4] + widgetBoundsHeight[var4] > var1 && widgetPositionY[var4] < var3 + var1) {
            field485[var4] = true;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "165592333"
   )
   void method452() {
      if(gameState != 1000) {
         boolean var1 = class178.method3253();
         if(!var1) {
            this.method503();
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method452();
      class7.method110();

      int var1;
      try {
         if(class138.field1900 == 1) {
            var1 = class138.field1899.method2577();
            if(var1 > 0 && class138.field1899.method2484()) {
               var1 -= class138.field1904;
               if(var1 < 0) {
                  var1 = 0;
               }

               class138.field1899.method2544(var1);
            } else {
               class138.field1899.method2570();
               class138.field1899.method2481();
               if(class138.field1903 != null) {
                  class138.field1900 = 2;
               } else {
                  class138.field1900 = 0;
               }

               ChatMessages.field914 = null;
               class107.field1725 = null;
            }
         }
      } catch (Exception var3) {
         var3.printStackTrace();
         class138.field1899.method2570();
         class138.field1900 = 0;
         ChatMessages.field914 = null;
         class107.field1725 = null;
         class138.field1903 = null;
      }

      class40.method741();
      class94.method1871();
      ChatLineBuffer.method879();
      if(null != class179.field2663) {
         var1 = class179.field2663.vmethod2042();
         field524 = var1;
      }

      if(gameState == 0) {
         class173.method3236();
         class8.field79.vmethod2003();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1772[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1755[var1] = 0L;
         }

         CombatInfoListHolder.field753 = 0;
      } else if(gameState == 5) {
         class11.method152(this);
         class173.method3236();
         class8.field79.vmethod2003();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1772[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field1755[var1] = 0L;
         }

         CombatInfoListHolder.field753 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class11.method152(this);
            class60.method1097();
         } else if(gameState == 25) {
            class48.method869();
         }
      } else {
         class11.method152(this);
      }

      if(gameState == 30) {
         class145.method2711();
      } else if(gameState == 40 || gameState == 45) {
         class60.method1097();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1124349482"
   )
   void method503() {
      if(class185.field2740 >= 4) {
         this.method2073("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2736 >= 4) {
            if(gameState <= 5) {
               this.method2073("js5io");
               gameState = 1000;
               return;
            }

            field311 = 3000;
            class185.field2736 = 3;
         }

         if(--field311 + 1 <= 0) {
            try {
               if(field310 == 0) {
                  class45.field902 = class44.field881.method1915(class152.host, Tile.field1351);
                  ++field310;
               }

               if(field310 == 1) {
                  if(class45.field902.field1648 == 2) {
                     this.method251(-1);
                     return;
                  }

                  if(class45.field902.field1648 == 1) {
                     ++field310;
                  }
               }

               if(field310 == 2) {
                  field278 = new class110((Socket)class45.field902.field1652, class44.field881);
                  Buffer var1 = new Buffer(5);
                  var1.method2760(15);
                  var1.method2763(130);
                  field278.method2018(var1.payload, 0, 5);
                  ++field310;
                  field312 = class9.method117();
               }

               if(field310 == 3) {
                  if(gameState > 5 && field278.method2017() <= 0) {
                     if(class9.method117() - field312 > 30000L) {
                        this.method251(-2);
                        return;
                     }
                  } else {
                     int var2 = field278.method2021();
                     if(var2 != 0) {
                        this.method251(var2);
                        return;
                     }

                     ++field310;
                  }
               }

               if(field310 == 4) {
                  CombatInfoListHolder.method711(field278, gameState > 20);
                  class45.field902 = null;
                  field278 = null;
                  field310 = 0;
                  field316 = 0;
               }
            } catch (IOException var3) {
               this.method251(-3);
            }

         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1694588022"
   )
   static void method588() {
      int var0 = GameEngine.field1765;
      int var1 = GameEngine.field1766;
      int var2 = ItemLayer.field1211 - class0.field1 - var0;
      int var3 = class11.field115 - class65.field1099 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = field279.method2074();
            int var5 = 0;
            int var6 = 0;
            if(var4 == GameObject.field1615) {
               Insets var7 = GameObject.field1615.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class11.field115);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, ItemLayer.field1211, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + ItemLayer.field1211 - var2, var6, var2, class11.field115);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class11.field115 + var6 - var3, ItemLayer.field1211, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1645395183"
   )
   public static String method589(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
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
               if(var3 != 2) {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "16711680"
   )
   public static Class method590(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
