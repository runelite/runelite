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
   @ObfuscatedName("ht")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("v")
   static boolean field284 = true;
   @ObfuscatedName("cj")
   static int[] field285;
   @ObfuscatedName("d")
   static class20 field286;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1184016907
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -1538884917
   )
   static int field288;
   @ObfuscatedName("k")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("f")
   static boolean field290 = false;
   @ObfuscatedName("ag")
   static boolean field291;
   @ObfuscatedName("ol")
   static int[] field292;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1109211635
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("u")
   static boolean field294 = true;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 23981631
   )
   static int field295 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -1474708543425619781L
   )
   static long field296 = -1L;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = -993810573
   )
   static int field297;
   @ObfuscatedName("md")
   static int[] field298;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 693523515
   )
   static int field299 = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -27456893
   )
   static int field300 = -1;
   @ObfuscatedName("jz")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("au")
   static boolean field302 = false;
   @ObfuscatedName("c")
   static String field303;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1168913043
   )
   static int field304 = 0;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1212888495
   )
   static int field305 = 0;
   @ObfuscatedName("br")
   static class184 field306;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -854790487
   )
   static int field307;
   @ObfuscatedName("lr")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1198428593
   )
   static int field309 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 2034513079
   )
   static int field310 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -723179779
   )
   static int field311 = 0;
   @ObfuscatedName("i")
   static class179 field312;
   @ObfuscatedName("aj")
   static class40 field313;
   @ObfuscatedName("ar")
   static class40 field314;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -354736429
   )
   static int field315;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -352617147
   )
   static int field316;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -118650793
   )
   static int field317;
   @ObfuscatedName("hy")
   static int[] field318;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 1843537213
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 2059712741
   )
   static int field320;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1135810403
   )
   static int field321;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 2074527639
   )
   static int field322;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 550244415
   )
   static int field323;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 2129165153
   )
   static int field324;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 407430861
   )
   static int field325;
   @ObfuscatedName("bc")
   static byte[] field326;
   @ObfuscatedName("ck")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1994924583
   )
   static int field328;
   @ObfuscatedName("du")
   static final int[] field329;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      longValue = -171790858973368309L
   )
   static long field330;
   @ObfuscatedName("cm")
   static int[] field331;
   @ObfuscatedName("cq")
   static class159 field332;
   @ObfuscatedName("cl")
   static class159 field333;
   @ObfuscatedName("cb")
   static class159 field334;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -2138832323
   )
   static int field335;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -869047179
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 946431793
   )
   static int field337;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -273314703
   )
   static int field338;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -247962751
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 489622959
   )
   static int field340;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1657638089
   )
   static int field341;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 995695119
   )
   static int field342;
   @ObfuscatedName("cy")
   static boolean field343;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 1498040005
   )
   static int field344;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1945449871
   )
   static int field345;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1985548743
   )
   static int field346 = 0;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 2000380233
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -948644775
   )
   static int field348;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("dy")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("do")
   static int[][][] field351;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -1218856443
   )
   static int field352;
   @ObfuscatedName("jn")
   static String field353;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -505031027
   )
   static int field354;
   @ObfuscatedName("pr")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 1111191761
   )
   static int field356;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -885766365
   )
   static int field357;
   @ObfuscatedName("mg")
   static SpritePixels[] field358;
   @ObfuscatedName("kt")
   static Deque field359;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -1396444535
   )
   static int field360;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -699425065
   )
   static int field361;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = 2064067611
   )
   static int field362;
   @ObfuscatedName("he")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("gq")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 1643218733
   )
   static int field365;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 1573731881
   )
   static int field366;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 141336007
   )
   static int field367;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 1386664719
   )
   static int field368;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 960065285
   )
   static int field369;
   @ObfuscatedName("el")
   static boolean field370;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 580064121
   )
   static int field371;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -101891347
   )
   static int field372;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -1291304565
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -765586547
   )
   static int field374;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 200173709
   )
   static int field375;
   @ObfuscatedName("fy")
   static boolean field376;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 66793585
   )
   static int field377;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -220955633
   )
   static int field378;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -981367613
   )
   static int field379;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -188297859
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1186135457
   )
   static int field381;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -564876613
   )
   static int field382 = 0;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 1272663833
   )
   static int field383;
   @ObfuscatedName("fa")
   static int[] field384;
   @ObfuscatedName("fx")
   static int[] field385;
   @ObfuscatedName("fn")
   static int[] field386;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -288833329
   )
   static int field387;
   @ObfuscatedName("fb")
   static int[] field388;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1952455329
   )
   static int field389 = -1;
   @ObfuscatedName("go")
   static int[] field390;
   @ObfuscatedName("gz")
   static String[] field391;
   @ObfuscatedName("hf")
   static Deque field392;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -389645389
   )
   static int field393;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1454023093
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1153196535
   )
   static int field395;
   @ObfuscatedName("mj")
   static int[] field396;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 1916946479
   )
   static int field397;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1423531439
   )
   static int field398;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -534533569
   )
   static int field399;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -38415915
   )
   static int field400;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1905618009
   )
   static int field401;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1754476879
   )
   static int field402;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1017479543
   )
   static int field403;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1210139587
   )
   static int field405;
   @ObfuscatedName("gk")
   static boolean field406;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1469338521
   )
   static int field407;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 1606332409
   )
   static int field408;
   @ObfuscatedName("ip")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 734493085
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = -587980563
   )
   static int field411;
   @ObfuscatedName("pi")
   static PlayerComposition field412;
   @ObfuscatedName("jq")
   static boolean field413;
   @ObfuscatedName("hc")
   static final int[] field414;
   @ObfuscatedName("hm")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1515260555
   )
   static int field416;
   @ObfuscatedName("hd")
   static int[] field417;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 1145014231
   )
   static int field418;
   @ObfuscatedName("hw")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -92386419
   )
   static int field420;
   @ObfuscatedName("hr")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hs")
   static Deque field422;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -1093779995
   )
   static int field423;
   @ObfuscatedName("hj")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 291597827
   )
   static int field425;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1880320021
   )
   static int field426;
   @ObfuscatedName("hz")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1227010705
   )
   static int field428 = 0;
   @ObfuscatedName("hl")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 437164369
   )
   static int field430;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -104344403
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("ik")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("if")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ft")
   static int[] field434;
   @ObfuscatedName("lc")
   static boolean[] field435;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 31470383
   )
   static int field436;
   @ObfuscatedName("iq")
   static boolean field437;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 828241711
   )
   static int field438;
   @ObfuscatedName("ns")
   static boolean field439;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 930138717
   )
   static int field440;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -529668551
   )
   static int field441;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -320659807
   )
   static int field442;
   @ObfuscatedName("it")
   static String field443;
   @ObfuscatedName("id")
   static boolean field444;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = 1700347065
   )
   static int field445;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 862470639
   )
   static int field446;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 1805242269
   )
   static int field447;
   @ObfuscatedName("ji")
   static String field448;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 1873791187
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("pu")
   static int[] field450;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -526387183
   )
   static int field451;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 225825819
   )
   static int field452;
   @ObfuscatedName("gj")
   static int[][] field453;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -2122874793
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 675943385
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("lq")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 1954413951
   )
   static int field457;
   @ObfuscatedName("jm")
   static boolean field458;
   @ObfuscatedName("ny")
   static boolean field459;
   @ObfuscatedName("jp")
   static boolean field460;
   @ObfuscatedName("jg")
   static Widget field461;
   @ObfuscatedName("jk")
   static Widget field462;
   @ObfuscatedName("jy")
   static Widget field463;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 59583983
   )
   static int field464;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1450265637
   )
   static int field465;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -2100666223
   )
   static int field466;
   @ObfuscatedName("jo")
   static boolean field467;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 709913355
   )
   static int field468;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -181109019
   )
   static int field469;
   @ObfuscatedName("jc")
   static boolean field470;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -844760649
   )
   static int field471;
   @ObfuscatedName("oa")
   static short field472;
   @ObfuscatedName("kd")
   static boolean field473;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -822551149
   )
   static int field474;
   @ObfuscatedName("mh")
   static int[] field475;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = 1647099805
   )
   static int field476;
   @ObfuscatedName("kb")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 304931833
   )
   static int field478;
   @ObfuscatedName("kx")
   static int[] field479;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 1538404515
   )
   static int field480;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 415927113
   )
   static int field481;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 102192921
   )
   static int field482;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -1399642433
   )
   static int field483;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1305733525
   )
   static int field484;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 1195195205
   )
   static int field485;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = 449792129
   )
   static int field486;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1619776509
   )
   static int field487;
   @ObfuscatedName("kq")
   static Deque field488;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -28675475
   )
   static int field489;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 912964205
   )
   static int field490;
   @ObfuscatedName("ln")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("la")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = -2018890389
   )
   static int field493;
   @ObfuscatedName("le")
   static boolean[] field494;
   @ObfuscatedName("lg")
   static boolean[] field495;
   @ObfuscatedName("kh")
   static int[] field496;
   @ObfuscatedName("is")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1286051055
   )
   static int field498 = 0;
   @ObfuscatedName("ak")
   static class184 field499;
   @ObfuscatedName("fr")
   static int[] field500;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -822849889
   )
   static int field501;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 58669911
   )
   static int field502;
   @ObfuscatedName("ld")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -1364998397
   )
   static int field504;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 260630099
   )
   static int field505;
   @ObfuscatedName("lz")
   static int[] field506;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = -768854015
   )
   static int field507;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 1978445865
   )
   static int field508;
   @ObfuscatedName("lj")
   static String field509;
   @ObfuscatedName("mk")
   static long[] field510;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 468495553
   )
   static int field511;
   @ObfuscatedName("lx")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 846560471
   )
   static int field513;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 928132619
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      longValue = 2819438349204956721L
   )
   static long field515;
   @ObfuscatedName("mn")
   static String field516;
   @ObfuscatedName("ml")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("mo")
   static byte field518;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 785381177
   )
   static int field519;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 8581449
   )
   static int field520;
   @ObfuscatedName("mt")
   static int[] field521;
   @ObfuscatedName("ac")
   static boolean field522 = true;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 1494885619
   )
   static int field523;
   @ObfuscatedName("pq")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = -1405464603
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 1336157117
   )
   static int field526;
   @ObfuscatedName("hk")
   @Export("playerOptionsPriority")
   static boolean[] playerOptionsPriority;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -2137861185
   )
   static int field528;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 2114831755
   )
   static int field529;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -250793899
   )
   static int field530;
   @ObfuscatedName("ki")
   static Deque field531;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = 858214945
   )
   static int field532;
   @ObfuscatedName("nj")
   static int[] field533;
   @ObfuscatedName("nt")
   static int[] field534;
   @ObfuscatedName("ni")
   static int[] field535;
   @ObfuscatedName("nx")
   static int[] field536;
   @ObfuscatedName("nl")
   static class53[] field537;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -779230609
   )
   static int field538;
   @ObfuscatedName("ou")
   static boolean[] field539;
   @ObfuscatedName("om")
   static int[] field540;
   @ObfuscatedName("op")
   static int[] field541;
   @ObfuscatedName("ow")
   static int[] field542;
   @ObfuscatedName("ja")
   static Widget field543;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -823232855
   )
   static int field544;
   @ObfuscatedName("ok")
   static short field545;
   @ObfuscatedName("in")
   static boolean field546;
   @ObfuscatedName("of")
   static short field547;
   @ObfuscatedName("oh")
   static short field548;
   @ObfuscatedName("oz")
   static short field549;
   @ObfuscatedName("oi")
   static short field550;
   @ObfuscatedName("on")
   static short field551;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -664145299
   )
   static int field552;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -1757031705
   )
   static int field553;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -1077553431
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 31164735
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("g")
   static Client field556;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -269690211
   )
   static int field557;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 469983847
   )
   static int field558;
   @ObfuscatedName("ov")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("pz")
   static class130 field560;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -163905765
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1139664399
   )
   static int field562 = 0;
   @ObfuscatedName("jj")
   static Widget field563;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -1286761685
   )
   static int field564;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -1418000867
   )
   static int field565;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = -1750467409
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      longValue = 483165909238575699L
   )
   static long field567;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      longValue = -9053513758738047497L
   )
   static long field568;
   @ObfuscatedName("pl")
   static final class22 field569;
   @ObfuscatedName("po")
   static int[] field570;
   @ObfuscatedName("og")
   static short field571;
   @ObfuscatedName("nq")
   static class51 field572;
   @ObfuscatedName("ia")
   @Export("menuActionParams1")
   static int[] menuActionParams1;

   public final void init() {
      if(this.method2196()) {
         class214[] var1 = new class214[]{class214.field3162, class214.field3173, class214.field3164, class214.field3166, class214.field3174, class214.field3172, class214.field3167, class214.field3165, class214.field3176, class214.field3163, class214.field3170, class214.field3168, class214.field3171, class214.field3175, class214.field3169};
         class214[] var2 = var1;

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class214 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3177);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3177)) {
               case 1:
                  class6.field44 = Integer.parseInt(var5);
               case 2:
               case 6:
               case 8:
               default:
                  break;
               case 3:
                  field428 = Integer.parseInt(var5);
                  break;
               case 4:
                  XClanMember.field278 = var5;
                  break;
               case 5:
                  int var7 = Integer.parseInt(var5);
                  class178[] var8 = CollisionData.method2379();
                  int var9 = 0;

                  class178 var6;
                  while(true) {
                     if(var9 >= var8.length) {
                        var6 = null;
                        break;
                     }

                     class178 var10 = var8[var9];
                     if(var10.field2672 == var7) {
                        var6 = var10;
                        break;
                     }

                     ++var9;
                  }

                  class206.field3099 = var6;
                  break;
               case 7:
                  class114.field1790 = Integer.parseInt(var5);
                  break;
               case 9:
                  field312 = (class179)Ignore.method207(class25.method613(), Integer.parseInt(var5));
                  if(class179.field2686 == field312) {
                     class149.field2037 = class228.field3256;
                  } else {
                     class149.field2037 = class228.field3255;
                  }
                  break;
               case 10:
                  flags = Integer.parseInt(var5);
                  break;
               case 11:
                  world = Integer.parseInt(var5);
                  break;
               case 12:
                  field309 = Integer.parseInt(var5);
                  break;
               case 13:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 14:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 15:
                  field303 = var5;
               }
            }
         }

         GameEngine.method2292();
         BufferProvider.host = this.getCodeBase().getHost();
         String var20 = class206.field3099.field2673;
         byte var11 = 0;

         try {
            class88.field1547 = 16;
            class171.field2347 = var11;

            try {
               class39.field804 = System.getProperty("os.name");
            } catch (Exception var18) {
               class39.field804 = "Unknown";
            }

            class32.field738 = class39.field804.toLowerCase();

            try {
               MessageNode.field229 = System.getProperty("user.home");
               if(MessageNode.field229 != null) {
                  MessageNode.field229 = MessageNode.field229 + "/";
               }
            } catch (Exception var17) {
               ;
            }

            try {
               if(class32.field738.startsWith("win")) {
                  if(null == MessageNode.field229) {
                     MessageNode.field229 = System.getenv("USERPROFILE");
                  }
               } else if(MessageNode.field229 == null) {
                  MessageNode.field229 = System.getenv("HOME");
               }

               if(MessageNode.field229 != null) {
                  MessageNode.field229 = MessageNode.field229 + "/";
               }
            } catch (Exception var16) {
               ;
            }

            if(null == MessageNode.field229) {
               MessageNode.field229 = "~/";
            }

            class176.field2655 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", MessageNode.field229, "/tmp/", ""};
            class9.field77 = new String[]{".jagex_cache_" + class171.field2347, ".file_store_" + class171.field2347};

            label122:
            for(var3 = 0; var3 < 4; ++var3) {
               class206.field3100 = class57.method1179("oldschool", var20, var3);
               if(!class206.field3100.exists()) {
                  class206.field3100.mkdirs();
               }

               File[] var21 = class206.field3100.listFiles();
               if(null == var21) {
                  break;
               }

               File[] var22 = var21;
               int var13 = 0;

               while(true) {
                  if(var13 >= var22.length) {
                     break label122;
                  }

                  File var14 = var22[var13];
                  if(!Player.method255(var14, false)) {
                     break;
                  }

                  ++var13;
               }
            }

            File var12 = class206.field3100;
            class107.field1733 = var12;
            if(!class107.field1733.exists()) {
               throw new RuntimeException("");
            }

            class107.field1734 = true;
            class7.method92();
            class104.field1699 = new class72(new FileOnDisk(class2.method32("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class104.field1695 = new class72(new FileOnDisk(class2.method32("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            WidgetNode.field182 = new class72[class88.field1547];

            for(int var15 = 0; var15 < class88.field1547; ++var15) {
               WidgetNode.field182[var15] = new class72(new FileOnDisk(class2.method32("main_file_cache.idx" + var15), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var19) {
            class97.method2025((String)null, var19);
         }

         field556 = this;
         this.method2188(765, 503, 136);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1084210149"
   )
   protected final void vmethod2198() {
      class212.field3145 = field309 == 0?'ꩊ':world + '鱀';
      class20.field217 = field309 == 0?443:world + '썐';
      field325 = class212.field3145;
      PlayerComposition.field2174 = class167.field2183;
      class164.field2159 = class167.field2188;
      class149.field2033 = class167.field2184;
      class65.field1124 = class167.field2185;
      if(class103.field1677.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1730[186] = 57;
         class105.field1730[187] = 27;
         class105.field1730[188] = 71;
         class105.field1730[189] = 26;
         class105.field1730[190] = 72;
         class105.field1730[191] = 73;
         class105.field1730[192] = 58;
         class105.field1730[219] = 42;
         class105.field1730[220] = 74;
         class105.field1730[221] = 43;
         class105.field1730[222] = 59;
         class105.field1730[223] = 28;
      } else {
         class105.field1730[44] = 71;
         class105.field1730[45] = 26;
         class105.field1730[46] = 72;
         class105.field1730[47] = 73;
         class105.field1730[59] = 57;
         class105.field1730[61] = 27;
         class105.field1730[91] = 42;
         class105.field1730[92] = 74;
         class105.field1730[93] = 43;
         class105.field1730[192] = 28;
         class105.field1730[222] = 58;
         class105.field1730[520] = 59;
      }

      Canvas var1 = class110.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class105.keyboard);
      var1.addFocusListener(class105.keyboard);
      class105.method2092(class110.canvas);
      class47.field948 = class2.method33();
      if(null != class47.field948) {
         class47.field948.vmethod2172(class110.canvas);
      }

      class18.field200 = new class116(255, class104.field1699, class104.field1695, 500000);
      FileOnDisk var3 = null;
      class30 var4 = new class30();

      try {
         var3 = CombatInfo2.method3608("", field312.field2687, false);
         byte[] var5 = new byte[(int)var3.method1489()];

         int var7;
         for(int var6 = 0; var6 < var5.length; var6 += var7) {
            var7 = var3.method1490(var5, var6, var5.length - var6);
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
            var3.method1488();
         }
      } catch (Exception var9) {
         ;
      }

      ObjectComposition.field2944 = var4;
      class99.field1655 = this.getToolkit().getSystemClipboard();
      String var11 = DecorativeObject.field1616;
      class114.field1787 = this;
      class114.field1786 = var11;
      if(field309 != 0) {
         field302 = true;
      }

      int var8 = ObjectComposition.field2944.field697;
      field330 = 0L;
      if(var8 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      FaceNormal.method1988();
      if(gameState >= 25) {
         class140.method2705();
      }

      GameEngine.field1778 = true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "79"
   )
   void method269() {
      if(gameState != 1000) {
         boolean var1 = Player.method234();
         if(!var1) {
            this.method270();
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1168816980"
   )
   void method270() {
      if(class185.field2765 >= 4) {
         this.method2201("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2747 >= 4) {
            if(gameState <= 5) {
               this.method2201("js5io");
               gameState = 1000;
               return;
            }

            field317 = 3000;
            class185.field2747 = 3;
         }

         if(--field317 + 1 <= 0) {
            try {
               if(field316 == 0) {
                  class164.field2158 = class114.field1793.method2055(BufferProvider.host, field325);
                  ++field316;
               }

               if(field316 == 1) {
                  if(class164.field2158.field1670 == 2) {
                     this.method496(-1);
                     return;
                  }

                  if(class164.field2158.field1670 == 1) {
                     ++field316;
                  }
               }

               if(field316 == 2) {
                  class47.field947 = new class110((Socket)class164.field2158.field1674, class114.field1793);
                  Buffer var1 = new Buffer(5);
                  var1.method2873(15);
                  var1.method2874(136);
                  class47.field947.method2148(var1.payload, 0, 5);
                  ++field316;
                  class175.field2642 = WallObject.method1985();
               }

               if(field316 == 3) {
                  if(gameState > 5 && class47.field947.method2138() <= 0) {
                     if(WallObject.method1985() - class175.field2642 > 30000L) {
                        this.method496(-2);
                        return;
                     }
                  } else {
                     int var2 = class47.field947.method2141();
                     if(var2 != 0) {
                        this.method496(var2);
                        return;
                     }

                     ++field316;
                  }
               }

               if(field316 == 4) {
                  class162.method3183(class47.field947, gameState > 20);
                  class164.field2158 = null;
                  class47.field947 = null;
                  field316 = 0;
                  field320 = 0;
               }
            } catch (IOException var3) {
               this.method496(-3);
            }

         }
      }
   }

   static {
      field313 = class40.field814;
      field314 = class40.field814;
      field315 = 0;
      field316 = 0;
      field317 = 0;
      field320 = 0;
      field321 = 0;
      field322 = 0;
      field323 = 0;
      field324 = 0;
      field326 = null;
      cachedNPCs = new NPC['耀'];
      field328 = 0;
      field285 = new int['耀'];
      field513 = 0;
      field331 = new int[250];
      field332 = new class159(5000);
      field333 = new class159(5000);
      field334 = new class159(15000);
      field335 = 0;
      packetOpcode = 0;
      field337 = 0;
      field338 = 0;
      field345 = 0;
      field340 = 0;
      field341 = 0;
      field342 = 0;
      field343 = false;
      field387 = 0;
      field474 = 1;
      field352 = 0;
      field508 = 1;
      field348 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field351 = new int[4][13][13];
      field329 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field430 = 0;
      field354 = 2;
      field398 = 0;
      field356 = 2;
      field357 = 0;
      field395 = 1;
      field393 = 0;
      mapScale = 0;
      field361 = 2;
      mapScaleDelta = 0;
      field297 = 1;
      field423 = 0;
      field365 = 0;
      field366 = 2301979;
      field367 = 5063219;
      field368 = 3353893;
      field369 = 7759444;
      field370 = false;
      field371 = 0;
      field372 = 128;
      mapAngle = 0;
      field374 = 0;
      field375 = 0;
      field538 = 0;
      field377 = 0;
      field378 = 50;
      field379 = 0;
      field376 = false;
      field381 = 0;
      field484 = 0;
      field383 = 50;
      field384 = new int[field383];
      field385 = new int[field383];
      field386 = new int[field383];
      field434 = new int[field383];
      field388 = new int[field383];
      field500 = new int[field383];
      field390 = new int[field383];
      field391 = new String[field383];
      field453 = new int[104][104];
      field502 = 0;
      field447 = -1;
      field469 = -1;
      field489 = 0;
      field490 = 0;
      field426 = 0;
      field399 = 0;
      field400 = 0;
      field401 = 0;
      field402 = 0;
      field403 = 0;
      field442 = 0;
      field405 = 0;
      field406 = false;
      field407 = 0;
      field408 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field411 = 0;
      field557 = 0;
      field318 = new int[1000];
      field414 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriority = new boolean[8];
      field417 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field418 = -1;
      groundItemDeque = new Deque[4][104][104];
      field392 = new Deque();
      projectiles = new Deque();
      field422 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field360 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field546 = false;
      field436 = -1;
      field437 = false;
      field438 = -1;
      field465 = -1;
      field440 = 0;
      field441 = 50;
      field416 = 0;
      field443 = null;
      field444 = false;
      field529 = -1;
      field446 = -1;
      field353 = null;
      field448 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field451 = 0;
      field452 = 0;
      field543 = null;
      energy = 0;
      weight = 0;
      field425 = 0;
      field457 = -1;
      field458 = false;
      field470 = false;
      field460 = false;
      field461 = null;
      field462 = null;
      field463 = null;
      field464 = 0;
      field466 = 0;
      field563 = null;
      field467 = false;
      field523 = -1;
      field307 = -1;
      field413 = false;
      field471 = -1;
      field344 = -1;
      field473 = false;
      field505 = 1;
      field496 = new int[32];
      field476 = 0;
      interfaceItemTriggers = new int[32];
      field478 = 0;
      field479 = new int[32];
      field480 = 0;
      field481 = 0;
      field482 = 0;
      field483 = 0;
      field288 = 0;
      field485 = 0;
      field486 = 0;
      field487 = 0;
      field488 = new Deque();
      field531 = new Deque();
      field359 = new Deque();
      widgetFlags = new XHashTable(512);
      field468 = 0;
      field493 = -2;
      field494 = new boolean[100];
      field495 = new boolean[100];
      field435 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field501 = 0;
      field330 = 0L;
      isResized = true;
      field504 = 765;
      field362 = 1;
      field506 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field507 = 0;
      field445 = 0;
      field509 = "";
      field510 = new long[100];
      field511 = 0;
      field420 = 0;
      field298 = new int[128];
      field521 = new int[128];
      field515 = -1L;
      field516 = null;
      clanChatOwner = null;
      field519 = -1;
      field520 = 0;
      field475 = new int[1000];
      field396 = new int[1000];
      field358 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field526 = 0;
      field544 = 255;
      field528 = -1;
      field439 = false;
      field530 = 127;
      field397 = 127;
      field532 = 0;
      field533 = new int[50];
      field534 = new int[50];
      field535 = new int[50];
      field536 = new int[50];
      field537 = new class53[50];
      field459 = false;
      field539 = new boolean[5];
      field540 = new int[5];
      field541 = new int[5];
      field542 = new int[5];
      field292 = new int[5];
      field472 = 256;
      field545 = 205;
      field571 = 256;
      field547 = 320;
      field548 = 1;
      field549 = 32767;
      field550 = 1;
      field551 = 32767;
      field552 = 0;
      field553 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field558 = 0;
      friends = new Friend[400];
      field560 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field412 = new PlayerComposition();
      field564 = -1;
      field565 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field567 = -1L;
      field568 = -1L;
      field569 = new class22();
      field570 = new int[50];
      field450 = new int[50];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)[Lclass40;",
      garbageValue = "-84"
   )
   static class40[] method296() {
      return new class40[]{class40.field813, class40.field816, class40.field814, class40.field812};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method269();

      while(true) {
         Deque var2 = class183.field2731;
         class180 var1;
         synchronized(class183.field2731) {
            var1 = (class180)class183.field2728.method2488();
         }

         if(var1 == null) {
            class110.method2162();
            class112.method2179();
            class105 var87 = class105.keyboard;
            int var48;
            synchronized(class105.keyboard) {
               ++class105.keyboardIdleTicks;
               class105.field1700 = class105.field1728;
               class105.field1727 = 0;
               if(class105.field1706 >= 0) {
                  while(class105.field1706 != class105.field1720) {
                     var48 = class105.field1719[class105.field1720];
                     class105.field1720 = 1 + class105.field1720 & 127;
                     if(var48 < 0) {
                        class105.field1718[~var48] = false;
                     } else {
                        if(!class105.field1718[var48] && class105.field1727 < class105.field1724.length - 1) {
                           class105.field1724[++class105.field1727 - 1] = var48;
                        }

                        class105.field1718[var48] = true;
                     }
                  }
               } else {
                  for(var48 = 0; var48 < 112; ++var48) {
                     class105.field1718[var48] = false;
                  }

                  class105.field1706 = class105.field1720;
               }

               class105.field1728 = class105.field1726;
            }

            class115 var88 = class115.mouse;
            synchronized(class115.mouse) {
               class115.field1802 = class115.field1801;
               class115.field1805 = class115.field1799;
               class115.field1806 = class115.field1807;
               class115.field1811 = class115.field1804;
               class115.field1812 = class115.field1808;
               class115.field1813 = class115.field1809;
               class115.field1814 = class115.field1810;
               class115.field1804 = 0;
            }

            int var49;
            if(class47.field948 != null) {
               var49 = class47.field948.vmethod2185();
               field487 = var49;
            }

            int var7;
            int var8;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var50;
            int var51;
            int var52;
            int var54;
            int var57;
            if(gameState == 0) {
               class20.method212();
               class118.method2384();
            } else if(gameState == 5) {
               class181.method3351(this);
               class20.method212();
               class118.method2384();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class181.method3351(this);
                  Spotanim.method3541();
               } else if(gameState == 25) {
                  class181.method3350(false);
                  field387 = 0;
                  boolean var111 = true;

                  for(var48 = 0; var48 < class145.field2009.length; ++var48) {
                     if(Script.field959[var48] != -1 && null == class145.field2009[var48]) {
                        class145.field2009[var48] = class154.field2094.getConfigData(Script.field959[var48], 0);
                        if(null == class145.field2009[var48]) {
                           var111 = false;
                           ++field387;
                        }
                     }

                     if(class118.field1847[var48] != -1 && null == Player.field267[var48]) {
                        Player.field267[var48] = class154.field2094.getConfigData(class118.field1847[var48], 0, XItemContainer.xteaKeys[var48]);
                        if(Player.field267[var48] == null) {
                           var111 = false;
                           ++field387;
                        }
                     }
                  }

                  if(!var111) {
                     field348 = 1;
                  } else {
                     field352 = 0;
                     var111 = true;

                     for(var48 = 0; var48 < class145.field2009.length; ++var48) {
                        byte[] var3 = Player.field267[var48];
                        if(var3 != null) {
                           var50 = (Buffer.mapRegions[var48] >> 8) * 64 - Player.baseX;
                           var51 = 64 * (Buffer.mapRegions[var48] & 255) - SecondaryBufferProvider.baseY;
                           if(isDynamicRegion) {
                              var50 = 10;
                              var51 = 10;
                           }

                           var111 &= class103.method2056(var3, var50, var51);
                        }
                     }

                     if(!var111) {
                        field348 = 2;
                     } else {
                        if(field348 != 0) {
                           XGrandExchangeOffer.method69("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class112.method2179();
                        class3.method37();
                        class112.method2179();
                        Friend.region.method1790();
                        class112.method2179();
                        System.gc();

                        for(var48 = 0; var48 < 4; ++var48) {
                           collisionMaps[var48].method2342();
                        }

                        for(var48 = 0; var48 < 4; ++var48) {
                           for(var52 = 0; var52 < 104; ++var52) {
                              for(var50 = 0; var50 < 104; ++var50) {
                                 class10.tileSettings[var48][var52][var50] = 0;
                              }
                           }
                        }

                        class112.method2179();
                        class65.method1250();
                        var48 = class145.field2009.length;
                        World.method693();
                        class181.method3350(true);
                        int var17;
                        int var18;
                        int var19;
                        int var20;
                        int var21;
                        int var22;
                        if(!isDynamicRegion) {
                           var52 = 0;

                           label2987:
                           while(true) {
                              byte[] var6;
                              if(var52 >= var48) {
                                 for(var52 = 0; var52 < var48; ++var52) {
                                    var50 = (Buffer.mapRegions[var52] >> 8) * 64 - Player.baseX;
                                    var51 = 64 * (Buffer.mapRegions[var52] & 255) - SecondaryBufferProvider.baseY;
                                    var6 = class145.field2009[var52];
                                    if(var6 == null && class10.field84 < 800) {
                                       class112.method2179();
                                       ScriptState.method164(var50, var51, 64, 64);
                                    }
                                 }

                                 class181.method3350(true);
                                 var52 = 0;

                                 while(true) {
                                    if(var52 >= var48) {
                                       break label2987;
                                    }

                                    byte[] var4 = Player.field267[var52];
                                    if(null != var4) {
                                       var51 = (Buffer.mapRegions[var52] >> 8) * 64 - Player.baseX;
                                       var54 = (Buffer.mapRegions[var52] & 255) * 64 - SecondaryBufferProvider.baseY;
                                       class112.method2179();
                                       Region var55 = Friend.region;
                                       CollisionData[] var56 = collisionMaps;
                                       Buffer var105 = new Buffer(var4);
                                       var10 = -1;

                                       while(true) {
                                          var11 = var105.method3039();
                                          if(var11 == 0) {
                                             break;
                                          }

                                          var10 += var11;
                                          var12 = 0;

                                          while(true) {
                                             var13 = var105.method3039();
                                             if(var13 == 0) {
                                                break;
                                             }

                                             var12 += var13 - 1;
                                             var14 = var12 & 63;
                                             var15 = var12 >> 6 & 63;
                                             var16 = var12 >> 12;
                                             var17 = var105.readUnsignedByte();
                                             var18 = var17 >> 2;
                                             var19 = var17 & 3;
                                             var20 = var15 + var51;
                                             var21 = var54 + var14;
                                             if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                                var22 = var16;
                                                if((class10.tileSettings[1][var20][var21] & 2) == 2) {
                                                   var22 = var16 - 1;
                                                }

                                                CollisionData var23 = null;
                                                if(var22 >= 0) {
                                                   var23 = var56[var22];
                                                }

                                                XItemContainer.method184(var16, var20, var21, var10, var19, var18, var55, var23);
                                             }
                                          }
                                       }
                                    }

                                    ++var52;
                                 }
                              }

                              var50 = 64 * (Buffer.mapRegions[var52] >> 8) - Player.baseX;
                              var51 = (Buffer.mapRegions[var52] & 255) * 64 - SecondaryBufferProvider.baseY;
                              var6 = class145.field2009[var52];
                              if(var6 != null) {
                                 class112.method2179();
                                 var7 = class9.field75 * 8 - 48;
                                 var8 = class10.field84 * 8 - 48;
                                 CollisionData[] var9 = collisionMaps;
                                 var10 = 0;

                                 label2984:
                                 while(true) {
                                    if(var10 >= 4) {
                                       Buffer var53 = new Buffer(var6);
                                       var11 = 0;

                                       while(true) {
                                          if(var11 >= 4) {
                                             break label2984;
                                          }

                                          for(var12 = 0; var12 < 64; ++var12) {
                                             for(var13 = 0; var13 < 64; ++var13) {
                                                class1.method21(var53, var11, var50 + var12, var51 + var13, var7, var8, 0);
                                             }
                                          }

                                          ++var11;
                                       }
                                    }

                                    for(var11 = 0; var11 < 64; ++var11) {
                                       for(var12 = 0; var12 < 64; ++var12) {
                                          if(var50 + var11 > 0 && var50 + var11 < 103 && var12 + var51 > 0 && var12 + var51 < 103) {
                                             var9[var10].flags[var50 + var11][var51 + var12] &= -16777217;
                                          }
                                       }
                                    }

                                    ++var10;
                                 }
                              }

                              ++var52;
                           }
                        }

                        int var25;
                        int var26;
                        int var27;
                        int var28;
                        int var29;
                        int var30;
                        int var32;
                        int var34;
                        int var35;
                        int var36;
                        int var37;
                        int var39;
                        int var41;
                        int var61;
                        int var64;
                        if(isDynamicRegion) {
                           var52 = 0;

                           label2920:
                           while(true) {
                              CollisionData[] var59;
                              Buffer var60;
                              if(var52 >= 4) {
                                 for(var52 = 0; var52 < 13; ++var52) {
                                    for(var50 = 0; var50 < 13; ++var50) {
                                       var51 = field351[0][var52][var50];
                                       if(var51 == -1) {
                                          ScriptState.method164(var52 * 8, 8 * var50, 8, 8);
                                       }
                                    }
                                 }

                                 class181.method3350(true);
                                 var52 = 0;

                                 while(true) {
                                    if(var52 >= 4) {
                                       break label2920;
                                    }

                                    class112.method2179();

                                    for(var50 = 0; var50 < 13; ++var50) {
                                       label2843:
                                       for(var51 = 0; var51 < 13; ++var51) {
                                          var54 = field351[var52][var50][var51];
                                          if(var54 != -1) {
                                             var7 = var54 >> 24 & 3;
                                             var8 = var54 >> 1 & 3;
                                             var57 = var54 >> 14 & 1023;
                                             var10 = var54 >> 3 & 2047;
                                             var11 = var10 / 8 + (var57 / 8 << 8);

                                             for(var12 = 0; var12 < Buffer.mapRegions.length; ++var12) {
                                                if(var11 == Buffer.mapRegions[var12] && Player.field267[var12] != null) {
                                                   byte[] var62 = Player.field267[var12];
                                                   var14 = var50 * 8;
                                                   var15 = 8 * var51;
                                                   var16 = 8 * (var57 & 7);
                                                   var17 = 8 * (var10 & 7);
                                                   Region var63 = Friend.region;
                                                   var59 = collisionMaps;
                                                   var60 = new Buffer(var62);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var60.method3039();
                                                      if(var22 == 0) {
                                                         continue label2843;
                                                      }

                                                      var21 += var22;
                                                      var61 = 0;

                                                      while(true) {
                                                         var64 = var60.method3039();
                                                         if(var64 == 0) {
                                                            break;
                                                         }

                                                         var61 += var64 - 1;
                                                         var25 = var61 & 63;
                                                         var26 = var61 >> 6 & 63;
                                                         var27 = var61 >> 12;
                                                         var28 = var60.readUnsignedByte();
                                                         var29 = var28 >> 2;
                                                         var30 = var28 & 3;
                                                         if(var7 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                            ObjectComposition var31 = ChatMessages.getObjectDefinition(var21);
                                                            var32 = var14 + CombatInfoListHolder.method787(var26 & 7, var25 & 7, var8, var31.sizeX, var31.sizeY, var30);
                                                            var35 = var26 & 7;
                                                            var36 = var25 & 7;
                                                            int var38 = var31.sizeX;
                                                            var39 = var31.sizeY;
                                                            int var40;
                                                            if((var30 & 1) == 1) {
                                                               var40 = var38;
                                                               var38 = var39;
                                                               var39 = var40;
                                                            }

                                                            var37 = var8 & 3;
                                                            if(var37 == 0) {
                                                               var34 = var36;
                                                            } else if(var37 == 1) {
                                                               var34 = 7 - var35 - (var38 - 1);
                                                            } else if(var37 == 2) {
                                                               var34 = 7 - var36 - (var39 - 1);
                                                            } else {
                                                               var34 = var35;
                                                            }

                                                            var40 = var15 + var34;
                                                            if(var32 > 0 && var40 > 0 && var32 < 103 && var40 < 103) {
                                                               var41 = var52;
                                                               if((class10.tileSettings[1][var32][var40] & 2) == 2) {
                                                                  var41 = var52 - 1;
                                                               }

                                                               CollisionData var42 = null;
                                                               if(var41 >= 0) {
                                                                  var42 = var59[var41];
                                                               }

                                                               XItemContainer.method184(var52, var32, var40, var21, var8 + var30 & 3, var29, var63, var42);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var52;
                                 }
                              }

                              class112.method2179();

                              for(var50 = 0; var50 < 13; ++var50) {
                                 for(var51 = 0; var51 < 13; ++var51) {
                                    boolean var114 = false;
                                    var7 = field351[var52][var50][var51];
                                    if(var7 != -1) {
                                       var8 = var7 >> 24 & 3;
                                       var57 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = var11 / 8 + (var10 / 8 << 8);

                                       for(var13 = 0; var13 < Buffer.mapRegions.length; ++var13) {
                                          if(var12 == Buffer.mapRegions[var13] && null != class145.field2009[var13]) {
                                             byte[] var58 = class145.field2009[var13];
                                             var15 = var50 * 8;
                                             var16 = 8 * var51;
                                             var17 = 8 * (var10 & 7);
                                             var18 = (var11 & 7) * 8;
                                             var59 = collisionMaps;

                                             for(var20 = 0; var20 < 8; ++var20) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var20 + var15 > 0 && var15 + var20 < 103 && var21 + var16 > 0 && var21 + var16 < 103) {
                                                      var59[var52].flags[var20 + var15][var21 + var16] &= -16777217;
                                                   }
                                                }
                                             }

                                             var60 = new Buffer(var58);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(var61 = 0; var61 < 64; ++var61) {
                                                      if(var8 == var21 && var22 >= var17 && var22 < var17 + 8 && var61 >= var18 && var61 < 8 + var18) {
                                                         var28 = var22 & 7;
                                                         var29 = var61 & 7;
                                                         var30 = var57 & 3;
                                                         if(var30 == 0) {
                                                            var27 = var28;
                                                         } else if(var30 == 1) {
                                                            var27 = var29;
                                                         } else if(var30 == 2) {
                                                            var27 = 7 - var28;
                                                         } else {
                                                            var27 = 7 - var29;
                                                         }

                                                         class1.method21(var60, var52, var15 + var27, var16 + class119.method2389(var22 & 7, var61 & 7, var57), 0, 0, var57);
                                                      } else {
                                                         class1.method21(var60, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var114 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var114) {
                                       class155.method3110(var52, 8 * var50, var51 * 8);
                                    }
                                 }
                              }

                              ++var52;
                           }
                        }

                        class181.method3350(true);
                        class3.method37();
                        class112.method2179();
                        Region var94 = Friend.region;
                        CollisionData[] var97 = collisionMaps;

                        for(var51 = 0; var51 < 4; ++var51) {
                           for(var54 = 0; var54 < 104; ++var54) {
                              for(var7 = 0; var7 < 104; ++var7) {
                                 if((class10.tileSettings[var51][var54][var7] & 1) == 1) {
                                    var8 = var51;
                                    if((class10.tileSettings[1][var54][var7] & 2) == 2) {
                                       var8 = var51 - 1;
                                    }

                                    if(var8 >= 0) {
                                       var97[var8].method2346(var54, var7);
                                    }
                                 }
                              }
                           }
                        }

                        class10.field91 += (int)(Math.random() * 5.0D) - 2;
                        if(class10.field91 < -8) {
                           class10.field91 = -8;
                        }

                        if(class10.field91 > 8) {
                           class10.field91 = 8;
                        }

                        class10.field92 += (int)(Math.random() * 5.0D) - 2;
                        if(class10.field92 < -16) {
                           class10.field92 = -16;
                        }

                        if(class10.field92 > 16) {
                           class10.field92 = 16;
                        }

                        for(var51 = 0; var51 < 4; ++var51) {
                           byte[][] var104 = class10.field83[var51];
                           var12 = (int)Math.sqrt(5100.0D);
                           var13 = 768 * var12 >> 8;

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var16 = class10.tileHeights[var51][1 + var15][var14] - class10.tileHeights[var51][var15 - 1][var14];
                                 var17 = class10.tileHeights[var51][var15][1 + var14] - class10.tileHeights[var51][var15][var14 - 1];
                                 var18 = (int)Math.sqrt((double)(var17 * var17 + var16 * var16 + 65536));
                                 var19 = (var16 << 8) / var18;
                                 var20 = 65536 / var18;
                                 var21 = (var17 << 8) / var18;
                                 var22 = (var19 * -50 + -10 * var20 + var21 * -50) / var13 + 96;
                                 var61 = (var104[1 + var15][var14] >> 3) + (var104[var15 - 1][var14] >> 2) + (var104[var15][var14 - 1] >> 2) + (var104[var15][1 + var14] >> 3) + (var104[var15][var14] >> 1);
                                 class22.field230[var15][var14] = var22 - var61;
                              }
                           }

                           for(var14 = 0; var14 < 104; ++var14) {
                              class10.field89[var14] = 0;
                              class7.field56[var14] = 0;
                              class65.field1127[var14] = 0;
                              class181.field2701[var14] = 0;
                              class7.field61[var14] = 0;
                           }

                           for(var14 = -5; var14 < 109; ++var14) {
                              for(var15 = 0; var15 < 104; ++var15) {
                                 var16 = var14 + 5;
                                 if(var16 >= 0 && var16 < 104) {
                                    var17 = class202.underlayIds[var51][var16][var15] & 255;
                                    if(var17 > 0) {
                                       var19 = var17 - 1;
                                       FloorUnderlayDefinition var121 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2816.get((long)var19);
                                       FloorUnderlayDefinition var123;
                                       if(null != var121) {
                                          var123 = var121;
                                       } else {
                                          byte[] var65 = FloorUnderlayDefinition.field2812.getConfigData(1, var19);
                                          var121 = new FloorUnderlayDefinition();
                                          if(var65 != null) {
                                             var121.method3548(new Buffer(var65), var19);
                                          }

                                          var121.method3553();
                                          FloorUnderlayDefinition.field2816.put(var121, (long)var19);
                                          var123 = var121;
                                       }

                                       class10.field89[var15] += var123.field2815;
                                       class7.field56[var15] += var123.field2811;
                                       class65.field1127[var15] += var123.field2814;
                                       class181.field2701[var15] += var123.field2817;
                                       ++class7.field61[var15];
                                    }
                                 }

                                 var17 = var14 - 5;
                                 if(var17 >= 0 && var17 < 104) {
                                    var18 = class202.underlayIds[var51][var17][var15] & 255;
                                    if(var18 > 0) {
                                       var20 = var18 - 1;
                                       FloorUnderlayDefinition var125 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2816.get((long)var20);
                                       FloorUnderlayDefinition var119;
                                       if(null != var125) {
                                          var119 = var125;
                                       } else {
                                          byte[] var66 = FloorUnderlayDefinition.field2812.getConfigData(1, var20);
                                          var125 = new FloorUnderlayDefinition();
                                          if(var66 != null) {
                                             var125.method3548(new Buffer(var66), var20);
                                          }

                                          var125.method3553();
                                          FloorUnderlayDefinition.field2816.put(var125, (long)var20);
                                          var119 = var125;
                                       }

                                       class10.field89[var15] -= var119.field2815;
                                       class7.field56[var15] -= var119.field2811;
                                       class65.field1127[var15] -= var119.field2814;
                                       class181.field2701[var15] -= var119.field2817;
                                       --class7.field61[var15];
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
                                       var15 += class10.field89[var21];
                                       var16 += class7.field56[var21];
                                       var17 += class65.field1127[var21];
                                       var18 += class181.field2701[var21];
                                       var19 += class7.field61[var21];
                                    }

                                    var22 = var20 - 5;
                                    if(var22 >= 0 && var22 < 104) {
                                       var15 -= class10.field89[var22];
                                       var16 -= class7.field56[var22];
                                       var17 -= class65.field1127[var22];
                                       var18 -= class181.field2701[var22];
                                       var19 -= class7.field61[var22];
                                    }

                                    if(var20 >= 1 && var20 < 103 && (!field290 || (class10.tileSettings[0][var14][var20] & 2) != 0 || (class10.tileSettings[var51][var14][var20] & 16) == 0)) {
                                       if(var51 < class10.field82) {
                                          class10.field82 = var51;
                                       }

                                       var61 = class202.underlayIds[var51][var14][var20] & 255;
                                       var64 = class10.overlayIds[var51][var14][var20] & 255;
                                       if(var61 > 0 || var64 > 0) {
                                          var25 = class10.tileHeights[var51][var14][var20];
                                          var26 = class10.tileHeights[var51][1 + var14][var20];
                                          var27 = class10.tileHeights[var51][1 + var14][1 + var20];
                                          var28 = class10.tileHeights[var51][var14][var20 + 1];
                                          var29 = class22.field230[var14][var20];
                                          var30 = class22.field230[1 + var14][var20];
                                          int var67 = class22.field230[1 + var14][1 + var20];
                                          var32 = class22.field230[var14][1 + var20];
                                          int var33 = -1;
                                          var34 = -1;
                                          if(var61 > 0) {
                                             var35 = 256 * var15 / var18;
                                             var36 = var16 / var19;
                                             var37 = var17 / var19;
                                             var33 = class155.method3109(var35, var36, var37);
                                             var35 = var35 + class10.field91 & 255;
                                             var37 += class10.field92;
                                             if(var37 < 0) {
                                                var37 = 0;
                                             } else if(var37 > 255) {
                                                var37 = 255;
                                             }

                                             var34 = class155.method3109(var35, var36, var37);
                                          }

                                          Overlay var68;
                                          if(var51 > 0) {
                                             boolean var109 = true;
                                             if(var61 == 0 && class3.overlayPaths[var51][var14][var20] != 0) {
                                                var109 = false;
                                             }

                                             if(var64 > 0) {
                                                var37 = var64 - 1;
                                                var68 = (Overlay)Overlay.field3047.get((long)var37);
                                                Overlay var69;
                                                if(var68 != null) {
                                                   var69 = var68;
                                                } else {
                                                   byte[] var70 = class5.field36.getConfigData(4, var37);
                                                   var68 = new Overlay();
                                                   if(var70 != null) {
                                                      var68.method3801(new Buffer(var70), var37);
                                                   }

                                                   var68.method3800();
                                                   Overlay.field3047.put(var68, (long)var37);
                                                   var69 = var68;
                                                }

                                                if(!var69.isHidden) {
                                                   var109 = false;
                                                }
                                             }

                                             if(var109 && var25 == var26 && var27 == var25 && var25 == var28) {
                                                class159.field2122[var51][var14][var20] |= 2340;
                                             }
                                          }

                                          var35 = 0;
                                          if(var34 != -1) {
                                             var35 = class84.colorPalette[FrameMap.method1788(var34, 96)];
                                          }

                                          if(var64 == 0) {
                                             var94.method1795(var51, var14, var20, 0, 0, -1, var25, var26, var27, var28, FrameMap.method1788(var33, var29), FrameMap.method1788(var33, var30), FrameMap.method1788(var33, var67), FrameMap.method1788(var33, var32), 0, 0, 0, 0, var35, 0);
                                          } else {
                                             var36 = 1 + class3.overlayPaths[var51][var14][var20];
                                             byte var110 = class6.overlayRotations[var51][var14][var20];
                                             var39 = var64 - 1;
                                             Overlay var71 = (Overlay)Overlay.field3047.get((long)var39);
                                             if(var71 != null) {
                                                var68 = var71;
                                             } else {
                                                byte[] var72 = class5.field36.getConfigData(4, var39);
                                                var71 = new Overlay();
                                                if(null != var72) {
                                                   var71.method3801(new Buffer(var72), var39);
                                                }

                                                var71.method3800();
                                                Overlay.field3047.put(var71, (long)var39);
                                                var68 = var71;
                                             }

                                             var41 = var68.texture;
                                             int var43;
                                             int var44;
                                             int var45;
                                             int var73;
                                             if(var41 >= 0) {
                                                var43 = class84.field1457.vmethod1999(var41);
                                                var73 = -1;
                                             } else if(var68.color == 16711935) {
                                                var73 = -2;
                                                var41 = -1;
                                                var43 = -2;
                                             } else {
                                                var73 = class155.method3109(var68.hue, var68.saturation, var68.lightness);
                                                var44 = var68.hue + class10.field91 & 255;
                                                var45 = var68.lightness + class10.field92;
                                                if(var45 < 0) {
                                                   var45 = 0;
                                                } else if(var45 > 255) {
                                                   var45 = 255;
                                                }

                                                var43 = class155.method3109(var44, var68.saturation, var45);
                                             }

                                             var44 = 0;
                                             if(var43 != -2) {
                                                var44 = class84.colorPalette[class6.method86(var43, 96)];
                                             }

                                             if(var68.field3048 != -1) {
                                                var45 = class10.field91 + var68.field3056 & 255;
                                                int var46 = class10.field92 + var68.field3054;
                                                if(var46 < 0) {
                                                   var46 = 0;
                                                } else if(var46 > 255) {
                                                   var46 = 255;
                                                }

                                                var43 = class155.method3109(var45, var68.field3053, var46);
                                                var44 = class84.colorPalette[class6.method86(var43, 96)];
                                             }

                                             var94.method1795(var51, var14, var20, var36, var110, var41, var25, var26, var27, var28, FrameMap.method1788(var33, var29), FrameMap.method1788(var33, var30), FrameMap.method1788(var33, var67), FrameMap.method1788(var33, var32), class6.method86(var73, var29), class6.method86(var73, var30), class6.method86(var73, var67), class6.method86(var73, var32), var35, var44);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var94.method1794(var51, var15, var14, class39.method821(var51, var15, var14));
                              }
                           }

                           class202.underlayIds[var51] = null;
                           class10.overlayIds[var51] = null;
                           class3.overlayPaths[var51] = null;
                           class6.overlayRotations[var51] = null;
                           class10.field83[var51] = null;
                        }

                        var94.method1820(-50, -10, -50);

                        for(var51 = 0; var51 < 104; ++var51) {
                           for(var54 = 0; var54 < 104; ++var54) {
                              if((class10.tileSettings[1][var51][var54] & 2) == 2) {
                                 var94.method1917(var51, var54);
                              }
                           }
                        }

                        var51 = 1;
                        var54 = 2;
                        var7 = 4;

                        for(var8 = 0; var8 < 4; ++var8) {
                           if(var8 > 0) {
                              var51 <<= 3;
                              var54 <<= 3;
                              var7 <<= 3;
                           }

                           for(var57 = 0; var57 <= var8; ++var57) {
                              for(var10 = 0; var10 <= 104; ++var10) {
                                 for(var11 = 0; var11 <= 104; ++var11) {
                                    short var108;
                                    if((class159.field2122[var57][var11][var10] & var51) != 0) {
                                       var12 = var10;
                                       var13 = var10;
                                       var14 = var57;

                                       for(var15 = var57; var12 > 0 && (class159.field2122[var57][var11][var12 - 1] & var51) != 0; --var12) {
                                          ;
                                       }

                                       while(var13 < 104 && (class159.field2122[var57][var11][1 + var13] & var51) != 0) {
                                          ++var13;
                                       }

                                       label2569:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class159.field2122[var14 - 1][var11][var16] & var51) == 0) {
                                                break label2569;
                                             }
                                          }

                                          --var14;
                                       }

                                       label2558:
                                       while(var15 < var8) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class159.field2122[1 + var15][var11][var16] & var51) == 0) {
                                                break label2558;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var13 - var12 + 1) * (var15 + 1 - var14);
                                       if(var16 >= 8) {
                                          var108 = 240;
                                          var18 = class10.tileHeights[var15][var11][var12] - var108;
                                          var19 = class10.tileHeights[var14][var11][var12];
                                          Region.method1793(var8, 1, var11 * 128, var11 * 128, var12 * 128, 128 * var13 + 128, var18, var19);

                                          for(var20 = var14; var20 <= var15; ++var20) {
                                             for(var21 = var12; var21 <= var13; ++var21) {
                                                class159.field2122[var20][var11][var21] &= ~var51;
                                             }
                                          }
                                       }
                                    }

                                    if((class159.field2122[var57][var11][var10] & var54) != 0) {
                                       var12 = var11;
                                       var13 = var11;
                                       var14 = var57;

                                       for(var15 = var57; var12 > 0 && (class159.field2122[var57][var12 - 1][var10] & var54) != 0; --var12) {
                                          ;
                                       }

                                       while(var13 < 104 && (class159.field2122[var57][var13 + 1][var10] & var54) != 0) {
                                          ++var13;
                                       }

                                       label2622:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class159.field2122[var14 - 1][var16][var10] & var54) == 0) {
                                                break label2622;
                                             }
                                          }

                                          --var14;
                                       }

                                       label2611:
                                       while(var15 < var8) {
                                          for(var16 = var12; var16 <= var13; ++var16) {
                                             if((class159.field2122[1 + var15][var16][var10] & var54) == 0) {
                                                break label2611;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var15 + 1 - var14) * (var13 - var12 + 1);
                                       if(var16 >= 8) {
                                          var108 = 240;
                                          var18 = class10.tileHeights[var15][var12][var10] - var108;
                                          var19 = class10.tileHeights[var14][var12][var10];
                                          Region.method1793(var8, 2, var12 * 128, var13 * 128 + 128, var10 * 128, var10 * 128, var18, var19);

                                          for(var20 = var14; var20 <= var15; ++var20) {
                                             for(var21 = var12; var21 <= var13; ++var21) {
                                                class159.field2122[var20][var21][var10] &= ~var54;
                                             }
                                          }
                                       }
                                    }

                                    if((class159.field2122[var57][var11][var10] & var7) != 0) {
                                       var12 = var11;
                                       var13 = var11;
                                       var14 = var10;

                                       for(var15 = var10; var14 > 0 && (class159.field2122[var57][var11][var14 - 1] & var7) != 0; --var14) {
                                          ;
                                       }

                                       while(var15 < 104 && (class159.field2122[var57][var11][var15 + 1] & var7) != 0) {
                                          ++var15;
                                       }

                                       label2675:
                                       while(var12 > 0) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if((class159.field2122[var57][var12 - 1][var16] & var7) == 0) {
                                                break label2675;
                                             }
                                          }

                                          --var12;
                                       }

                                       label2664:
                                       while(var13 < 104) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if((class159.field2122[var57][var13 + 1][var16] & var7) == 0) {
                                                break label2664;
                                             }
                                          }

                                          ++var13;
                                       }

                                       if((var13 - var12 + 1) * (1 + (var15 - var14)) >= 4) {
                                          var16 = class10.tileHeights[var57][var12][var14];
                                          Region.method1793(var8, 4, var12 * 128, 128 + 128 * var13, 128 * var14, 128 * var15 + 128, var16, var16);

                                          for(var17 = var12; var17 <= var13; ++var17) {
                                             for(var18 = var14; var18 <= var15; ++var18) {
                                                class159.field2122[var57][var17][var18] &= ~var7;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        class181.method3350(true);
                        var51 = class10.field82;
                        if(var51 > CollisionData.plane) {
                           var51 = CollisionData.plane;
                        }

                        if(var51 < CollisionData.plane - 1) {
                           var51 = CollisionData.plane - 1;
                        }

                        if(field290) {
                           Friend.region.method1791(class10.field82);
                        } else {
                           Friend.region.method1791(0);
                        }

                        for(var54 = 0; var54 < 104; ++var54) {
                           for(var7 = 0; var7 < 104; ++var7) {
                              class110.groundItemSpawned(var54, var7);
                           }
                        }

                        class112.method2179();
                        class145.method2809();
                        ObjectComposition.field2924.reset();
                        if(CollisionData.field1835 != null) {
                           field332.method3144(238);
                           field332.method2874(1057001181);
                        }

                        if(!isDynamicRegion) {
                           var54 = (class9.field75 - 6) / 8;
                           var7 = (6 + class9.field75) / 8;
                           var8 = (class10.field84 - 6) / 8;
                           var57 = (class10.field84 + 6) / 8;

                           for(var10 = var54 - 1; var10 <= 1 + var7; ++var10) {
                              for(var11 = var8 - 1; var11 <= var57 + 1; ++var11) {
                                 if(var10 < var54 || var10 > var7 || var11 < var8 || var11 > var57) {
                                    class154.field2094.method3374("m" + var10 + "_" + var11);
                                    class154.field2094.method3374("l" + var10 + "_" + var11);
                                 }
                              }
                           }
                        }

                        World.setGameState(30);
                        class112.method2179();
                        Item.method882();
                        field332.method3144(88);
                        class118.method2384();
                     }
                  }
               }
            } else {
               class181.method3351(this);
            }

            if(gameState == 30) {
               if(field498 > 1) {
                  --field498;
               }

               if(field342 > 0) {
                  --field342;
               }

               if(field343) {
                  field343 = false;
                  if(field342 > 0) {
                     class33.method773();
                  } else {
                     World.setGameState(40);
                     class22.field236 = XGrandExchangeOffer.field30;
                     XGrandExchangeOffer.field30 = null;
                  }
               } else {
                  if(!isMenuOpen) {
                     class108.method2131();
                     menuOptions[0] = "Cancel";
                     menuTargets[0] = "";
                     menuTypes[0] = 1006;
                     menuOptionCount = 1;
                  }

                  for(var49 = 0; var49 < 100 && class109.method2135(); ++var49) {
                     ;
                  }

                  if(gameState == 30) {
                     while(CombatInfoListHolder.method789()) {
                        field332.method3144(34);
                        field332.method2873(0);
                        var49 = field332.offset;
                        class203.method3856(field332);
                        field332.method2883(field332.offset - var49);
                     }

                     Object var89 = field286.field213;
                     synchronized(field286.field213) {
                        if(!field284) {
                           field286.field221 = 0;
                        } else if(class115.field1811 != 0 || field286.field221 >= 40) {
                           field332.method3144(106);
                           field332.method2873(0);
                           var48 = field332.offset;
                           var52 = 0;

                           for(var50 = 0; var50 < field286.field221 && field332.offset - var48 < 240; ++var50) {
                              ++var52;
                              var51 = field286.field212[var50];
                              if(var51 < 0) {
                                 var51 = 0;
                              } else if(var51 > 502) {
                                 var51 = 502;
                              }

                              var54 = field286.field215[var50];
                              if(var54 < 0) {
                                 var54 = 0;
                              } else if(var54 > 764) {
                                 var54 = 764;
                              }

                              var7 = var54 + var51 * 765;
                              if(field286.field212[var50] == -1 && field286.field215[var50] == -1) {
                                 var54 = -1;
                                 var51 = -1;
                                 var7 = 524287;
                              }

                              if(field389 == var54 && var51 == field299) {
                                 if(field300 < 2047) {
                                    ++field300;
                                 }
                              } else {
                                 var8 = var54 - field389;
                                 field389 = var54;
                                 var57 = var51 - field299;
                                 field299 = var51;
                                 if(field300 < 8 && var8 >= -32 && var8 <= 31 && var57 >= -32 && var57 <= 31) {
                                    var8 += 32;
                                    var57 += 32;
                                    field332.method2872(var57 + (field300 << 12) + (var8 << 6));
                                    field300 = 0;
                                 } else if(field300 < 8) {
                                    field332.method2871(var7 + 8388608 + (field300 << 19));
                                    field300 = 0;
                                 } else {
                                    field332.method2874(var7 + -1073741824 + (field300 << 19));
                                    field300 = 0;
                                 }
                              }
                           }

                           field332.method2883(field332.offset - var48);
                           if(var52 >= field286.field221) {
                              field286.field221 = 0;
                           } else {
                              field286.field221 -= var52;

                              for(var50 = 0; var50 < field286.field221; ++var50) {
                                 field286.field215[var50] = field286.field215[var50 + var52];
                                 field286.field212[var50] = field286.field212[var52 + var50];
                              }
                           }
                        }
                     }

                     if(class115.field1811 == 1 || !field291 && class115.field1811 == 4 || class115.field1811 == 2) {
                        long var74 = (class115.field1814 - field296) / 50L;
                        if(var74 > 4095L) {
                           var74 = 4095L;
                        }

                        field296 = class115.field1814;
                        var52 = class115.field1813;
                        if(var52 < 0) {
                           var52 = 0;
                        } else if(var52 > class65.field1128) {
                           var52 = class65.field1128;
                        }

                        var50 = class115.field1812;
                        if(var50 < 0) {
                           var50 = 0;
                        } else if(var50 > RSCanvas.field1756) {
                           var50 = RSCanvas.field1756;
                        }

                        var51 = (int)var74;
                        field332.method3144(0);
                        field332.method2872((var51 << 1) + (class115.field1811 == 2?1:0));
                        field332.method2872(var50);
                        field332.method2872(var52);
                     }

                     if(class105.field1727 > 0) {
                        field332.method3144(26);
                        field332.method2872(0);
                        var49 = field332.offset;
                        long var76 = WallObject.method1985();

                        for(var50 = 0; var50 < class105.field1727; ++var50) {
                           long var78 = var76 - field515;
                           if(var78 > 16777215L) {
                              var78 = 16777215L;
                           }

                           field515 = var76;
                           field332.method2871((int)var78);
                           field332.method2873(class105.field1724[var50]);
                        }

                        field332.method2882(field332.offset - var49);
                     }

                     if(field379 > 0) {
                        --field379;
                     }

                     if(class105.field1718[96] || class105.field1718[97] || class105.field1718[98] || class105.field1718[99]) {
                        field376 = true;
                     }

                     if(field376 && field379 <= 0) {
                        field379 = 20;
                        field376 = false;
                        field332.method3144(96);
                        field332.method2910(field372);
                        field332.method2921(mapAngle);
                     }

                     if(class13.field133 && !field522) {
                        field522 = true;
                        field332.method3144(171);
                        field332.method2873(1);
                     }

                     if(!class13.field133 && field522) {
                        field522 = false;
                        field332.method3144(171);
                        field332.method2873(0);
                     }

                     int[] var90;
                     if(field519 != CollisionData.plane) {
                        field519 = CollisionData.plane;
                        var49 = CollisionData.plane;
                        var90 = class26.field595.image;
                        var52 = var90.length;

                        for(var50 = 0; var50 < var52; ++var50) {
                           var90[var50] = 0;
                        }

                        var50 = 1;

                        while(true) {
                           if(var50 >= 103) {
                              var50 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                              var51 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                              class26.field595.method4164();

                              for(var54 = 1; var54 < 103; ++var54) {
                                 for(var7 = 1; var7 < 103; ++var7) {
                                    if((class10.tileSettings[var49][var7][var54] & 24) == 0) {
                                       class107.method2125(var49, var7, var54, var50, var51);
                                    }

                                    if(var49 < 3 && (class10.tileSettings[var49 + 1][var7][var54] & 8) != 0) {
                                       class107.method2125(1 + var49, var7, var54, var50, var51);
                                    }
                                 }
                              }

                              field520 = 0;

                              for(var54 = 0; var54 < 104; ++var54) {
                                 for(var7 = 0; var7 < 104; ++var7) {
                                    var8 = Friend.region.method1831(CollisionData.plane, var54, var7);
                                    if(var8 != 0) {
                                       var8 = var8 >> 14 & 32767;
                                       var57 = ChatMessages.getObjectDefinition(var8).mapIconId;
                                       if(var57 >= 0) {
                                          var10 = var54;
                                          var11 = var7;
                                          if(var57 != 22 && var57 != 29 && var57 != 34 && var57 != 36 && var57 != 46 && var57 != 47 && var57 != 48) {
                                             int[][] var117 = collisionMaps[CollisionData.plane].flags;

                                             for(var15 = 0; var15 < 10; ++var15) {
                                                var16 = (int)(Math.random() * 4.0D);
                                                if(var16 == 0 && var10 > 0 && var10 > var54 - 3 && (var117[var10 - 1][var11] & 19136776) == 0) {
                                                   --var10;
                                                }

                                                if(var16 == 1 && var10 < 103 && var10 < 3 + var54 && (var117[var10 + 1][var11] & 19136896) == 0) {
                                                   ++var10;
                                                }

                                                if(var16 == 2 && var11 > 0 && var11 > var7 - 3 && (var117[var10][var11 - 1] & 19136770) == 0) {
                                                   --var11;
                                                }

                                                if(var16 == 3 && var11 < 103 && var11 < 3 + var7 && (var117[var10][1 + var11] & 19136800) == 0) {
                                                   ++var11;
                                                }
                                             }
                                          }

                                          field358[field520] = class207.field3102[var57];
                                          field475[field520] = var10;
                                          field396[field520] = var11;
                                          ++field520;
                                       }
                                    }
                                 }
                              }

                              class57.bufferProvider.method4098();
                              break;
                           }

                           var51 = 24628 + (103 - var50) * 2048;

                           for(var54 = 1; var54 < 103; ++var54) {
                              if((class10.tileSettings[var49][var54][var50] & 24) == 0) {
                                 Friend.region.method1823(var90, var51, 512, var49, var54, var50);
                              }

                              if(var49 < 3 && (class10.tileSettings[1 + var49][var54][var50] & 8) != 0) {
                                 Friend.region.method1823(var90, var51, 512, var49 + 1, var54, var50);
                              }

                              var51 += 4;
                           }

                           ++var50;
                        }
                     }

                     if(gameState == 30) {
                        class1.method19();
                        class145.method2807();
                        ++field337;
                        if(field337 > 750) {
                           if(field342 > 0) {
                              class33.method773();
                           } else {
                              World.setGameState(40);
                              class22.field236 = XGrandExchangeOffer.field30;
                              XGrandExchangeOffer.field30 = null;
                           }
                        } else {
                           var49 = class45.field916;
                           var90 = class45.field913;

                           for(var52 = 0; var52 < var49; ++var52) {
                              Player var99 = cachedPlayers[var90[var52]];
                              if(null != var99) {
                                 class138.method2573(var99, 1);
                              }
                           }

                           class13.method188();
                           int[] var91 = class45.field913;

                           for(var48 = 0; var48 < class45.field916; ++var48) {
                              Player var95 = cachedPlayers[var91[var48]];
                              if(null != var95 && var95.field637 > 0) {
                                 --var95.field637;
                                 if(var95.field637 == 0) {
                                    var95.overhead = null;
                                 }
                              }
                           }

                           for(var48 = 0; var48 < field328; ++var48) {
                              var52 = field285[var48];
                              NPC var100 = cachedNPCs[var52];
                              if(null != var100 && var100.field637 > 0) {
                                 --var100.field637;
                                 if(var100.field637 == 0) {
                                    var100.overhead = null;
                                 }
                              }
                           }

                           ++field365;
                           if(field399 != 0) {
                              field426 += 20;
                              if(field426 >= 400) {
                                 field399 = 0;
                              }
                           }

                           if(class186.field2773 != null) {
                              ++field400;
                              if(field400 >= 15) {
                                 ChatLineBuffer.method996(class186.field2773);
                                 class186.field2773 = null;
                              }
                           }

                           Widget var92 = class45.field924;
                           Widget var93 = class5.field40;
                           class45.field924 = null;
                           class5.field40 = null;
                           field563 = null;
                           field413 = false;
                           field467 = false;
                           field420 = 0;

                           while(true) {
                              while(class16.method196() && field420 < 128) {
                                 if(field425 >= 2 && class105.field1718[82] && class13.field131 == 66) {
                                    String var96 = class179.method3347();
                                    class99.field1655.setContents(new StringSelection(var96), (ClipboardOwner)null);
                                 } else {
                                    field521[field420] = class13.field131;
                                    field298[field420] = class1.field8;
                                    ++field420;
                                 }
                              }

                              if(widgetRoot != -1) {
                                 var52 = widgetRoot;
                                 var50 = RSCanvas.field1756;
                                 var51 = class65.field1128;
                                 if(Projectile.method874(var52)) {
                                    NPCComposition.method3780(class231.widgets[var52], -1, 0, 0, var50, var51, 0, 0);
                                 }
                              }

                              ++field505;

                              while(true) {
                                 Widget var5;
                                 class18 var98;
                                 Widget var101;
                                 do {
                                    var98 = (class18)field531.method2488();
                                    if(null == var98) {
                                       while(true) {
                                          do {
                                             var98 = (class18)field359.method2488();
                                             if(var98 == null) {
                                                while(true) {
                                                   do {
                                                      var98 = (class18)field488.method2488();
                                                      if(var98 == null) {
                                                         XItemContainer.method172();
                                                         if(null == class15.field159 && null == field462) {
                                                            var52 = class115.field1811;
                                                            if(isMenuOpen) {
                                                               if(var52 != 1 && (field291 || var52 != 4)) {
                                                                  var50 = class115.field1805;
                                                                  var51 = class115.field1806;
                                                                  if(var50 < class162.menuX - 10 || var50 > 10 + class41.menuWidth + class162.menuX || var51 < class160.menuY - 10 || var51 > class160.menuY + XItemContainer.menuHeight + 10) {
                                                                     isMenuOpen = false;
                                                                     Item.method880(class162.menuX, class160.menuY, class41.menuWidth, XItemContainer.menuHeight);
                                                                  }
                                                               }

                                                               if(var52 == 1 || !field291 && var52 == 4) {
                                                                  var50 = class162.menuX;
                                                                  var51 = class160.menuY;
                                                                  var54 = class41.menuWidth;
                                                                  var7 = class115.field1812;
                                                                  var8 = class115.field1813;
                                                                  var57 = -1;

                                                                  for(var10 = 0; var10 < menuOptionCount; ++var10) {
                                                                     var11 = 15 * (menuOptionCount - 1 - var10) + var51 + 31;
                                                                     if(var7 > var50 && var7 < var54 + var50 && var8 > var11 - 13 && var8 < 3 + var11) {
                                                                        var57 = var10;
                                                                     }
                                                                  }

                                                                  if(var57 != -1 && var57 >= 0) {
                                                                     var10 = menuActionParams0[var57];
                                                                     var11 = menuActionParams1[var57];
                                                                     var12 = menuTypes[var57];
                                                                     var13 = menuIdentifiers[var57];
                                                                     String var118 = menuOptions[var57];
                                                                     String var80 = menuTargets[var57];
                                                                     class37.menuAction(var10, var11, var12, var13, var118, var80, class115.field1812, class115.field1813);
                                                                  }

                                                                  isMenuOpen = false;
                                                                  Item.method880(class162.menuX, class160.menuY, class41.menuWidth, XItemContainer.menuHeight);
                                                               }
                                                            } else {
                                                               label3237: {
                                                                  label3306: {
                                                                     var50 = class2.method23();
                                                                     if((var52 == 1 || !field291 && var52 == 4) && var50 >= 0) {
                                                                        var51 = menuTypes[var50];
                                                                        if(var51 == 39 || var51 == 40 || var51 == 41 || var51 == 42 || var51 == 43 || var51 == 33 || var51 == 34 || var51 == 35 || var51 == 36 || var51 == 37 || var51 == 38 || var51 == 1005) {
                                                                           var54 = menuActionParams0[var50];
                                                                           var7 = menuActionParams1[var50];
                                                                           Widget var116 = ChatLineBuffer.method993(var7);
                                                                           var10 = MessageNode.method220(var116);
                                                                           boolean var120 = (var10 >> 28 & 1) != 0;
                                                                           if(var120) {
                                                                              break label3306;
                                                                           }

                                                                           var12 = MessageNode.method220(var116);
                                                                           boolean var107 = (var12 >> 29 & 1) != 0;
                                                                           if(var107) {
                                                                              break label3306;
                                                                           }
                                                                        }
                                                                     }

                                                                     if((var52 == 1 || !field291 && var52 == 4) && (field360 == 1 && menuOptionCount > 2 && !class167.method3272() || class7.method101(var50))) {
                                                                        var52 = 2;
                                                                     }

                                                                     if((var52 == 1 || !field291 && var52 == 4) && menuOptionCount > 0 && var50 >= 0) {
                                                                        var51 = menuActionParams0[var50];
                                                                        var54 = menuActionParams1[var50];
                                                                        var7 = menuTypes[var50];
                                                                        var8 = menuIdentifiers[var50];
                                                                        String var106 = menuOptions[var50];
                                                                        String var112 = menuTargets[var50];
                                                                        class37.menuAction(var51, var54, var7, var8, var106, var112, class115.field1812, class115.field1813);
                                                                     }

                                                                     if(var52 == 2 && menuOptionCount > 0) {
                                                                        class9.method113(class115.field1812, class115.field1813);
                                                                     }
                                                                     break label3237;
                                                                  }

                                                                  if(null != class15.field159 && !field406) {
                                                                     var11 = class2.method23();
                                                                     if(field360 != 1 && !class7.method101(var11) && menuOptionCount > 0) {
                                                                        var12 = field403;
                                                                        var13 = field442;
                                                                        class3.method38(class15.field157, var12, var13);
                                                                        class15.field157 = null;
                                                                     }
                                                                  }

                                                                  field406 = false;
                                                                  field407 = 0;
                                                                  if(class15.field159 != null) {
                                                                     ChatLineBuffer.method996(class15.field159);
                                                                  }

                                                                  class15.field159 = ChatLineBuffer.method993(var7);
                                                                  field402 = var54;
                                                                  field403 = class115.field1812;
                                                                  field442 = class115.field1813;
                                                                  if(var50 >= 0) {
                                                                     class49.method979(var50);
                                                                  }

                                                                  ChatLineBuffer.method996(class15.field159);
                                                               }
                                                            }
                                                         }

                                                         if(null != field462) {
                                                            ChatLineBuffer.method996(field462);
                                                            ++class40.field815;
                                                            if(field413 && field467) {
                                                               var52 = class115.field1805;
                                                               var50 = class115.field1806;
                                                               var52 -= field464;
                                                               var50 -= field466;
                                                               if(var52 < field523) {
                                                                  var52 = field523;
                                                               }

                                                               if(field462.width + var52 > field523 + field463.width) {
                                                                  var52 = field523 + field463.width - field462.width;
                                                               }

                                                               if(var50 < field307) {
                                                                  var50 = field307;
                                                               }

                                                               if(var50 + field462.height > field463.height + field307) {
                                                                  var50 = field307 + field463.height - field462.height;
                                                               }

                                                               var51 = var52 - field471;
                                                               var54 = var50 - field344;
                                                               var7 = field462.field2326;
                                                               if(class40.field815 > field462.field2226 && (var51 > var7 || var51 < -var7 || var54 > var7 || var54 < -var7)) {
                                                                  field473 = true;
                                                               }

                                                               var8 = var52 - field523 + field463.scrollX;
                                                               var57 = field463.scrollY + (var50 - field307);
                                                               class18 var113;
                                                               if(null != field462.field2311 && field473) {
                                                                  var113 = new class18();
                                                                  var113.field188 = field462;
                                                                  var113.field189 = var8;
                                                                  var113.field190 = var57;
                                                                  var113.field196 = field462.field2311;
                                                                  class40.method828(var113);
                                                               }

                                                               if(class115.field1802 == 0) {
                                                                  if(field473) {
                                                                     if(null != field462.field2296) {
                                                                        var113 = new class18();
                                                                        var113.field188 = field462;
                                                                        var113.field189 = var8;
                                                                        var113.field190 = var57;
                                                                        var113.field192 = field563;
                                                                        var113.field196 = field462.field2296;
                                                                        class40.method828(var113);
                                                                     }

                                                                     if(field563 != null) {
                                                                        Widget var81 = field462;
                                                                        var13 = MessageNode.method220(var81);
                                                                        var12 = var13 >> 17 & 7;
                                                                        var14 = var12;
                                                                        Widget var115;
                                                                        if(var12 == 0) {
                                                                           var115 = null;
                                                                        } else {
                                                                           var15 = 0;

                                                                           while(true) {
                                                                              if(var15 >= var14) {
                                                                                 var115 = var81;
                                                                                 break;
                                                                              }

                                                                              var81 = ChatLineBuffer.method993(var81.parentId);
                                                                              if(var81 == null) {
                                                                                 var115 = null;
                                                                                 break;
                                                                              }

                                                                              ++var15;
                                                                           }
                                                                        }

                                                                        if(null != var115) {
                                                                           field332.method3144(22);
                                                                           field332.method2874(field563.id);
                                                                           field332.method2872(field462.item);
                                                                           field332.method2899(field462.id);
                                                                           field332.method2872(field563.index);
                                                                           field332.method2910(field462.index);
                                                                           field332.method2940(field563.item);
                                                                        }
                                                                     }
                                                                  } else {
                                                                     var10 = class2.method23();
                                                                     if(menuOptionCount > 2 && (field360 == 1 && !class167.method3272() || class7.method101(var10))) {
                                                                        class9.method113(field471 + field464, field344 + field466);
                                                                     } else if(menuOptionCount > 0) {
                                                                        var11 = field464 + field471;
                                                                        var12 = field344 + field466;
                                                                        class3.method38(class15.field157, var11, var12);
                                                                        class15.field157 = null;
                                                                     }
                                                                  }

                                                                  field462 = null;
                                                               }
                                                            } else if(class40.field815 > 1) {
                                                               field462 = null;
                                                            }
                                                         }

                                                         if(class15.field159 != null) {
                                                            ChatLineBuffer.method996(class15.field159);
                                                            ++field407;
                                                            if(class115.field1802 != 0) {
                                                               if(field407 >= 5 && (class115.field1805 > field403 + 5 || class115.field1805 < field403 - 5 || class115.field1806 > field442 + 5 || class115.field1806 < field442 - 5)) {
                                                                  field406 = true;
                                                               }
                                                            } else {
                                                               if(field406) {
                                                                  if(class22.field237 == class15.field159 && field402 != field405) {
                                                                     Widget var102 = class15.field159;
                                                                     byte var122 = 0;
                                                                     if(field452 == 1 && var102.contentType == 206) {
                                                                        var122 = 1;
                                                                     }

                                                                     if(var102.itemIds[field405] <= 0) {
                                                                        var122 = 0;
                                                                     }

                                                                     var54 = MessageNode.method220(var102);
                                                                     boolean var124 = (var54 >> 29 & 1) != 0;
                                                                     if(var124) {
                                                                        var7 = field402;
                                                                        var8 = field405;
                                                                        var102.itemIds[var8] = var102.itemIds[var7];
                                                                        var102.itemQuantities[var8] = var102.itemQuantities[var7];
                                                                        var102.itemIds[var7] = -1;
                                                                        var102.itemQuantities[var7] = 0;
                                                                     } else if(var122 == 1) {
                                                                        var7 = field402;
                                                                        var8 = field405;

                                                                        while(var7 != var8) {
                                                                           if(var7 > var8) {
                                                                              var102.method3322(var7 - 1, var7);
                                                                              --var7;
                                                                           } else if(var7 < var8) {
                                                                              var102.method3322(1 + var7, var7);
                                                                              ++var7;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var102.method3322(field405, field402);
                                                                     }

                                                                     field332.method3144(193);
                                                                     field332.method2940(field405);
                                                                     field332.method2899(class15.field159.id);
                                                                     field332.method2873(var122);
                                                                     field332.method2872(field402);
                                                                  }
                                                               } else {
                                                                  var52 = class2.method23();
                                                                  if(menuOptionCount > 2 && (field360 == 1 && !class167.method3272() || class7.method101(var52))) {
                                                                     class9.method113(field403, field442);
                                                                  } else if(menuOptionCount > 0) {
                                                                     var50 = field403;
                                                                     var51 = field442;
                                                                     class3.method38(class15.field157, var50, var51);
                                                                     class15.field157 = null;
                                                                  }
                                                               }

                                                               field400 = 10;
                                                               class115.field1811 = 0;
                                                               class15.field159 = null;
                                                            }
                                                         }

                                                         if(Region.method1959()) {
                                                            var52 = Region.field1513;
                                                            var50 = Region.field1501;
                                                            field332.method3144(105);
                                                            field332.method2873(5);
                                                            field332.method2872(Player.baseX + var52);
                                                            field332.method2921(SecondaryBufferProvider.baseY + var50);
                                                            field332.method3083(class105.field1718[82]?(class105.field1718[81]?2:1):0);
                                                            Region.method1929();
                                                            field489 = class115.field1812;
                                                            field490 = class115.field1813;
                                                            field399 = 1;
                                                            field426 = 0;
                                                            flagX = var52;
                                                            flagY = var50;
                                                         }

                                                         if(class45.field924 != var92) {
                                                            if(var92 != null) {
                                                               ChatLineBuffer.method996(var92);
                                                            }

                                                            if(null != class45.field924) {
                                                               ChatLineBuffer.method996(class45.field924);
                                                            }
                                                         }

                                                         if(class5.field40 != var93 && field440 == field441) {
                                                            if(null != var93) {
                                                               ChatLineBuffer.method996(var93);
                                                            }

                                                            if(class5.field40 != null) {
                                                               ChatLineBuffer.method996(class5.field40);
                                                            }
                                                         }

                                                         if(class5.field40 != null) {
                                                            if(field440 < field441) {
                                                               ++field440;
                                                               if(field441 == field440) {
                                                                  ChatLineBuffer.method996(class5.field40);
                                                               }
                                                            }
                                                         } else if(field440 > 0) {
                                                            --field440;
                                                         }

                                                         var52 = field430 + WidgetNode.localPlayer.x;
                                                         var50 = field398 + WidgetNode.localPlayer.y;
                                                         if(class49.field974 - var52 < -500 || class49.field974 - var52 > 500 || class189.field2791 - var50 < -500 || class189.field2791 - var50 > 500) {
                                                            class49.field974 = var52;
                                                            class189.field2791 = var50;
                                                         }

                                                         if(var52 != class49.field974) {
                                                            class49.field974 += (var52 - class49.field974) / 16;
                                                         }

                                                         if(var50 != class189.field2791) {
                                                            class189.field2791 += (var50 - class189.field2791) / 16;
                                                         }

                                                         if(class115.field1802 == 4 && field291) {
                                                            var51 = class115.field1806 - field377;
                                                            field375 = var51 * 2;
                                                            field377 = var51 != -1 && var51 != 1?(field377 + class115.field1806) / 2:class115.field1806;
                                                            var54 = field538 - class115.field1805;
                                                            field374 = var54 * 2;
                                                            field538 = var54 != -1 && var54 != 1?(field538 + class115.field1805) / 2:class115.field1805;
                                                         } else {
                                                            if(class105.field1718[96]) {
                                                               field374 += (-24 - field374) / 2;
                                                            } else if(class105.field1718[97]) {
                                                               field374 += (24 - field374) / 2;
                                                            } else {
                                                               field374 /= 2;
                                                            }

                                                            if(class105.field1718[98]) {
                                                               field375 += (12 - field375) / 2;
                                                            } else if(class105.field1718[99]) {
                                                               field375 += (-12 - field375) / 2;
                                                            } else {
                                                               field375 /= 2;
                                                            }

                                                            field377 = class115.field1806;
                                                            field538 = class115.field1805;
                                                         }

                                                         mapAngle = field374 / 2 + mapAngle & 2047;
                                                         field372 += field375 / 2;
                                                         if(field372 < 128) {
                                                            field372 = 128;
                                                         }

                                                         if(field372 > 383) {
                                                            field372 = 383;
                                                         }

                                                         var51 = class49.field974 >> 7;
                                                         var54 = class189.field2791 >> 7;
                                                         var7 = class25.method615(class49.field974, class189.field2791, CollisionData.plane);
                                                         var8 = 0;
                                                         if(var51 > 3 && var54 > 3 && var51 < 100 && var54 < 100) {
                                                            for(var57 = var51 - 4; var57 <= 4 + var51; ++var57) {
                                                               for(var10 = var54 - 4; var10 <= 4 + var54; ++var10) {
                                                                  var11 = CollisionData.plane;
                                                                  if(var11 < 3 && (class10.tileSettings[1][var57][var10] & 2) == 2) {
                                                                     ++var11;
                                                                  }

                                                                  var12 = var7 - class10.tileHeights[var11][var57][var10];
                                                                  if(var12 > var8) {
                                                                     var8 = var12;
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         var57 = var8 * 192;
                                                         if(var57 > 98048) {
                                                            var57 = 98048;
                                                         }

                                                         if(var57 < '耀') {
                                                            var57 = '耀';
                                                         }

                                                         if(var57 > field381) {
                                                            field381 += (var57 - field381) / 24;
                                                         } else if(var57 < field381) {
                                                            field381 += (var57 - field381) / 80;
                                                         }

                                                         if(field459) {
                                                            var52 = class157.field2116 * 128 + 64;
                                                            var50 = class118.field1849 * 128 + 64;
                                                            var51 = class25.method615(var52, var50, CollisionData.plane) - class6.field43;
                                                            if(FaceNormal.cameraX < var52) {
                                                               FaceNormal.cameraX += class13.field130 + Overlay.field3052 * (var52 - FaceNormal.cameraX) / 1000;
                                                               if(FaceNormal.cameraX > var52) {
                                                                  FaceNormal.cameraX = var52;
                                                               }
                                                            }

                                                            if(FaceNormal.cameraX > var52) {
                                                               FaceNormal.cameraX -= class13.field130 + Overlay.field3052 * (FaceNormal.cameraX - var52) / 1000;
                                                               if(FaceNormal.cameraX < var52) {
                                                                  FaceNormal.cameraX = var52;
                                                               }
                                                            }

                                                            if(class45.cameraZ < var51) {
                                                               class45.cameraZ += class13.field130 + Overlay.field3052 * (var51 - class45.cameraZ) / 1000;
                                                               if(class45.cameraZ > var51) {
                                                                  class45.cameraZ = var51;
                                                               }
                                                            }

                                                            if(class45.cameraZ > var51) {
                                                               class45.cameraZ -= class13.field130 + (class45.cameraZ - var51) * Overlay.field3052 / 1000;
                                                               if(class45.cameraZ < var51) {
                                                                  class45.cameraZ = var51;
                                                               }
                                                            }

                                                            if(ChatLineBuffer.cameraY < var50) {
                                                               ChatLineBuffer.cameraY += class13.field130 + Overlay.field3052 * (var50 - ChatLineBuffer.cameraY) / 1000;
                                                               if(ChatLineBuffer.cameraY > var50) {
                                                                  ChatLineBuffer.cameraY = var50;
                                                               }
                                                            }

                                                            if(ChatLineBuffer.cameraY > var50) {
                                                               ChatLineBuffer.cameraY -= class13.field130 + (ChatLineBuffer.cameraY - var50) * Overlay.field3052 / 1000;
                                                               if(ChatLineBuffer.cameraY < var50) {
                                                                  ChatLineBuffer.cameraY = var50;
                                                               }
                                                            }

                                                            var52 = 64 + class167.field2182 * 128;
                                                            var50 = 64 + class195.field2870 * 128;
                                                            var51 = class25.method615(var52, var50, CollisionData.plane) - Item.field893;
                                                            var54 = var52 - FaceNormal.cameraX;
                                                            var7 = var51 - class45.cameraZ;
                                                            var8 = var50 - ChatLineBuffer.cameraY;
                                                            var57 = (int)Math.sqrt((double)(var54 * var54 + var8 * var8));
                                                            var10 = (int)(Math.atan2((double)var7, (double)var57) * 325.949D) & 2047;
                                                            var11 = (int)(Math.atan2((double)var54, (double)var8) * -325.949D) & 2047;
                                                            if(var10 < 128) {
                                                               var10 = 128;
                                                            }

                                                            if(var10 > 383) {
                                                               var10 = 383;
                                                            }

                                                            if(class10.cameraPitch < var10) {
                                                               class10.cameraPitch += Ignore.field203 + (var10 - class10.cameraPitch) * class38.field801 / 1000;
                                                               if(class10.cameraPitch > var10) {
                                                                  class10.cameraPitch = var10;
                                                               }
                                                            }

                                                            if(class10.cameraPitch > var10) {
                                                               class10.cameraPitch -= Ignore.field203 + (class10.cameraPitch - var10) * class38.field801 / 1000;
                                                               if(class10.cameraPitch < var10) {
                                                                  class10.cameraPitch = var10;
                                                               }
                                                            }

                                                            var12 = var11 - Projectile.cameraYaw;
                                                            if(var12 > 1024) {
                                                               var12 -= 2048;
                                                            }

                                                            if(var12 < -1024) {
                                                               var12 += 2048;
                                                            }

                                                            if(var12 > 0) {
                                                               Projectile.cameraYaw += Ignore.field203 + var12 * class38.field801 / 1000;
                                                               Projectile.cameraYaw &= 2047;
                                                            }

                                                            if(var12 < 0) {
                                                               Projectile.cameraYaw -= -var12 * class38.field801 / 1000 + Ignore.field203;
                                                               Projectile.cameraYaw &= 2047;
                                                            }

                                                            var13 = var11 - Projectile.cameraYaw;
                                                            if(var13 > 1024) {
                                                               var13 -= 2048;
                                                            }

                                                            if(var13 < -1024) {
                                                               var13 += 2048;
                                                            }

                                                            if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                               Projectile.cameraYaw = var11;
                                                            }
                                                         }

                                                         for(var52 = 0; var52 < 5; ++var52) {
                                                            ++field292[var52];
                                                         }

                                                         class22.chatMessages.method918();
                                                         var52 = class57.method1161();
                                                         var50 = PlayerComposition.method3238();
                                                         if(var52 > 15000 && var50 > 15000) {
                                                            field342 = 250;
                                                            class115.mouseIdleTicks = 14500;
                                                            field332.method3144(241);
                                                         }

                                                         ++field393;
                                                         if(field393 > 500) {
                                                            field393 = 0;
                                                            var51 = (int)(Math.random() * 8.0D);
                                                            if((var51 & 1) == 1) {
                                                               field430 += field354;
                                                            }

                                                            if((var51 & 2) == 2) {
                                                               field398 += field356;
                                                            }

                                                            if((var51 & 4) == 4) {
                                                               field357 += field395;
                                                            }
                                                         }

                                                         if(field430 < -50) {
                                                            field354 = 2;
                                                         }

                                                         if(field430 > 50) {
                                                            field354 = -2;
                                                         }

                                                         if(field398 < -55) {
                                                            field356 = 2;
                                                         }

                                                         if(field398 > 55) {
                                                            field356 = -2;
                                                         }

                                                         if(field357 < -40) {
                                                            field395 = 1;
                                                         }

                                                         if(field357 > 40) {
                                                            field395 = -1;
                                                         }

                                                         ++field423;
                                                         if(field423 > 500) {
                                                            field423 = 0;
                                                            var51 = (int)(Math.random() * 8.0D);
                                                            if((var51 & 1) == 1) {
                                                               mapScale += field361;
                                                            }

                                                            if((var51 & 2) == 2) {
                                                               mapScaleDelta += field297;
                                                            }
                                                         }

                                                         if(mapScale < -60) {
                                                            field361 = 2;
                                                         }

                                                         if(mapScale > 60) {
                                                            field361 = -2;
                                                         }

                                                         if(mapScaleDelta < -20) {
                                                            field297 = 1;
                                                         }

                                                         if(mapScaleDelta > 10) {
                                                            field297 = -1;
                                                         }

                                                         for(class16 var103 = (class16)field560.method2516(); null != var103; var103 = (class16)field560.method2520()) {
                                                            if((long)var103.field169 < WallObject.method1985() / 1000L - 5L) {
                                                               if(var103.field173 > 0) {
                                                                  class88.sendGameMessage(5, "", var103.field166 + " has logged in.");
                                                               }

                                                               if(var103.field173 == 0) {
                                                                  class88.sendGameMessage(5, "", var103.field166 + " has logged out.");
                                                               }

                                                               var103.method2525();
                                                            }
                                                         }

                                                         ++field338;
                                                         if(field338 > 50) {
                                                            field332.method3144(25);
                                                         }

                                                         try {
                                                            if(XGrandExchangeOffer.field30 != null && field332.offset > 0) {
                                                               XGrandExchangeOffer.field30.method2148(field332.payload, 0, field332.offset);
                                                               field332.offset = 0;
                                                               field338 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var84) {
                                                            if(field342 > 0) {
                                                               class33.method773();
                                                            } else {
                                                               World.setGameState(40);
                                                               class22.field236 = XGrandExchangeOffer.field30;
                                                               XGrandExchangeOffer.field30 = null;
                                                            }

                                                            return;
                                                         }

                                                         return;
                                                      }

                                                      var101 = var98.field188;
                                                      if(var101.index < 0) {
                                                         break;
                                                      }

                                                      var5 = ChatLineBuffer.method993(var101.parentId);
                                                   } while(var5 == null || var5.children == null || var101.index >= var5.children.length || var5.children[var101.index] != var101);

                                                   class40.method828(var98);
                                                }
                                             }

                                             var101 = var98.field188;
                                             if(var101.index < 0) {
                                                break;
                                             }

                                             var5 = ChatLineBuffer.method993(var101.parentId);
                                          } while(null == var5 || null == var5.children || var101.index >= var5.children.length || var5.children[var101.index] != var101);

                                          class40.method828(var98);
                                       }
                                    }

                                    var101 = var98.field188;
                                    if(var101.index < 0) {
                                       break;
                                    }

                                    var5 = ChatLineBuffer.method993(var101.parentId);
                                 } while(null == var5 || null == var5.children || var101.index >= var5.children.length || var5.children[var101.index] != var101);

                                 class40.method828(var98);
                              }
                           }
                        }
                     }
                  }
               }
            } else if(gameState == 40 || gameState == 45) {
               Spotanim.method3541();
            }

            return;
         }

         var1.field2692.method3448(var1.field2691, (int)var1.hash, var1.field2690, false);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1255804382"
   )
   protected final void vmethod2280() {
      boolean var1 = class156.method3121();
      if(var1 && field439 && class36.field772 != null) {
         class36.field772.method1125();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field330 && WallObject.method1985() > field330) {
            int var2 = isResized?2:1;
            field330 = 0L;
            if(var2 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            FaceNormal.method1988();
            if(gameState >= 25) {
               class140.method2705();
            }

            GameEngine.field1778 = true;
         } else if(GameEngine.field1768) {
            Canvas var6 = class110.canvas;
            var6.removeKeyListener(class105.keyboard);
            var6.removeFocusListener(class105.keyboard);
            class105.field1706 = -1;
            Canvas var3 = class110.canvas;
            var3.removeMouseListener(class115.mouse);
            var3.removeMouseMotionListener(class115.mouse);
            var3.removeFocusListener(class115.mouse);
            class115.field1801 = 0;
            if(class47.field948 != null) {
               class47.field948.vmethod2174(class110.canvas);
            }

            field556.method2189();
            class110.canvas.setBackground(Color.black);
            Canvas var4 = class110.canvas;
            var4.setFocusTraversalKeysEnabled(false);
            var4.addKeyListener(class105.keyboard);
            var4.addFocusListener(class105.keyboard);
            class105.method2092(class110.canvas);
            if(class47.field948 != null) {
               class47.field948.vmethod2172(class110.canvas);
            }

            if(widgetRoot != -1) {
               class143.method2789(widgetRoot, RSCanvas.field1756, class65.field1128, false);
            }

            GameEngine.field1780 = true;
         }
      }

      Dimension var12 = this.method2203();
      if(var12.width != class63.field1106 || Friend.field149 != var12.height || GameEngine.field1780) {
         FaceNormal.method1988();
         field330 = WallObject.method1985() + 500L;
         GameEngine.field1780 = false;
      }

      boolean var7 = false;
      int var8;
      if(GameEngine.field1778) {
         GameEngine.field1778 = false;
         var7 = true;

         for(var8 = 0; var8 < 100; ++var8) {
            field494[var8] = true;
         }
      }

      if(var7) {
         class9.method111();
      }

      if(gameState == 0) {
         XGrandExchangeOffer.method47(class41.field853, class41.field855, (Color)null, var7);
      } else if(gameState == 5) {
         GameEngine.method2294(class217.field3188, Friend.field151, class15.field162, var7);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            GameEngine.method2294(class217.field3188, Friend.field151, class15.field162, var7);
         } else if(gameState == 25) {
            if(field348 == 1) {
               if(field387 > field474) {
                  field474 = field387;
               }

               var8 = (field474 * 50 - field387 * 50) / field474;
               XGrandExchangeOffer.method69("Loading - please wait." + "<br>" + " (" + var8 + "%" + ")", false);
            } else if(field348 == 2) {
               if(field352 > field508) {
                  field508 = field352;
               }

               var8 = (field508 * 50 - field352 * 50) / field508 + 50;
               XGrandExchangeOffer.method69("Loading - please wait." + "<br>" + " (" + var8 + "%" + ")", false);
            } else {
               XGrandExchangeOffer.method69("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            class185.method3491();
         } else if(gameState == 40) {
            XGrandExchangeOffer.method69("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            XGrandExchangeOffer.method69("Please wait...", false);
         }
      } else {
         GameEngine.method2294(class217.field3188, Friend.field151, class15.field162, var7);
      }

      int var5;
      Graphics var11;
      if(gameState == 30 && field501 == 0 && !var7) {
         try {
            var11 = class110.canvas.getGraphics();

            for(var5 = 0; var5 < field468; ++var5) {
               if(field495[var5]) {
                  class57.bufferProvider.drawSub(var11, widgetPositionX[var5], widgetPositionY[var5], widgetBoundsWidth[var5], widgetBoundsHeight[var5]);
                  field495[var5] = false;
               }
            }
         } catch (Exception var10) {
            class110.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var11 = class110.canvas.getGraphics();
            class57.bufferProvider.draw(var11, 0, 0);

            for(var5 = 0; var5 < field468; ++var5) {
               field495[var5] = false;
            }
         } catch (Exception var9) {
            class110.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2041303886"
   )
   void method496(int var1) {
      class164.field2158 = null;
      class47.field947 = null;
      field316 = 0;
      if(field325 == class212.field3145) {
         field325 = class20.field217;
      } else {
         field325 = class212.field3145;
      }

      ++field320;
      if(field320 < 2 || var1 != 7 && var1 != 9) {
         if(field320 >= 2 && var1 == 6) {
            this.method2201("js5connect_outofdate");
            gameState = 1000;
         } else if(field320 >= 4) {
            if(gameState <= 5) {
               this.method2201("js5connect");
               gameState = 1000;
            } else {
               field317 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2201("js5connect_full");
         gameState = 1000;
      } else {
         field317 = 3000;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1113671925"
   )
   protected final void vmethod2192() {
      if(class22.chatMessages.method927()) {
         class22.chatMessages.method925();
      }

      if(null != field286) {
         field286.field214 = false;
      }

      field286 = null;
      if(null != XGrandExchangeOffer.field30) {
         XGrandExchangeOffer.field30.method2139();
         XGrandExchangeOffer.field30 = null;
      }

      NPCComposition.method3798();
      if(class115.mouse != null) {
         class115 var1 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

      class47.field948 = null;
      if(null != class36.field772) {
         class36.field772.method1126();
      }

      if(FaceNormal.field1570 != null) {
         FaceNormal.field1570.method1126();
      }

      if(class185.field2757 != null) {
         class185.field2757.method2139();
      }

      class8.method108();
      Actor.method638();
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1028163153"
   )
   static final void method571(String var0) {
      if(var0 != null) {
         if((friendCount < 200 || field411 == 1) && friendCount < 400) {
            String var1 = class60.method1229(var0, class149.field2037);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < friendCount; ++var2) {
                  Friend var3 = friends[var2];
                  var4 = class60.method1229(var3.name, class149.field2037);
                  if(null != var4 && var4.equals(var1)) {
                     class88.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(null != var3.previousName) {
                     var5 = class60.method1229(var3.previousName, class149.field2037);
                     if(null != var5 && var5.equals(var1)) {
                        class88.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < ignoreCount; ++var2) {
                  Ignore var6 = ignores[var2];
                  var4 = class60.method1229(var6.name, class149.field2037);
                  if(null != var4 && var4.equals(var1)) {
                     class88.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.previousName) {
                     var5 = class60.method1229(var6.previousName, class149.field2037);
                     if(null != var5 && var5.equals(var1)) {
                        class88.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class60.method1229(WidgetNode.localPlayer.name, class149.field2037).equals(var1)) {
                  class88.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  field332.method3144(45);
                  field332.method2873(class165.method3233(var0));
                  field332.method2915(var0);
               }
            }
         } else {
            class88.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1564305344"
   )
   static int method608(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class32.field731:class108.field1738;
      if(var0 == 1700) {
         class32.field726[++class32.field735 - 1] = var3.item;
         return 1;
      } else if(var0 == 1701) {
         if(var3.item != -1) {
            class32.field726[++class32.field735 - 1] = var3.stackSize;
         } else {
            class32.field726[++class32.field735 - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class32.field726[++class32.field735 - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1652753660"
   )
   static void method610() {
      class45.field916 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class45.field911[var0] = null;
         class45.field928[var0] = 1;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
   )
   protected final void vmethod2295() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)[B",
      garbageValue = "19"
   )
   public static byte[] method612(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(var4 == 8364) {
            var2[var3] = -128;
         } else if(var4 == 8218) {
            var2[var3] = -126;
         } else if(var4 == 402) {
            var2[var3] = -125;
         } else if(var4 == 8222) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(var4 == 710) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(var4 == 8249) {
            var2[var3] = -117;
         } else if(var4 == 338) {
            var2[var3] = -116;
         } else if(var4 == 381) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(var4 == 8217) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(var4 == 353) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(var4 == 382) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }
}
