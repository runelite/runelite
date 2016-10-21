import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
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
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1971139993
   )
   static int field278 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1922336471
   )
   static int field279 = 0;
   @ObfuscatedName("n")
   static boolean field280 = true;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = 134862273
   )
   static int field281;
   @ObfuscatedName("cz")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1817895783
   )
   static int field283 = -1;
   @ObfuscatedName("fh")
   static int[] field284;
   @ObfuscatedName("l")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("h")
   static boolean field286 = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 750142315
   )
   static int field287 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 635249463
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1047746507
   )
   static int field289;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1989590907
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -2825795128899775303L
   )
   static long field291 = -1L;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2012565313
   )
   static int field292 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1690810831
   )
   static int field293 = -1;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 1990496517
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 2112388289
   )
   static int field295;
   @ObfuscatedName("ah")
   static boolean field296 = false;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 1994936515
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -2085106287
   )
   static int field298 = 0;
   @ObfuscatedName("dj")
   static int[][][] field299;
   @ObfuscatedName("lf")
   static int[] field300;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -934327671
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -339311595
   )
   static int field302;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 313879917
   )
   static int field303 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1280342549
   )
   static int field304 = 0;
   @ObfuscatedName("ob")
   static PlayerComposition field305;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -442324849
   )
   static int field306;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 1083363485
   )
   static int field307;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -189247151
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1902782511
   )
   static int field309;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -84914791
   )
   static int field310;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      longValue = -825978707469491479L
   )
   static long field311;
   @ObfuscatedName("ab")
   static class171 field312;
   @ObfuscatedName("na")
   static class61[] field313;
   @ObfuscatedName("bg")
   static class171 field314;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1279381969
   )
   static int field315;
   @ObfuscatedName("ou")
   static class198 field316;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1069708263
   )
   static int field317;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1367871719
   )
   static int field318;
   @ObfuscatedName("ap")
   static class21 field320;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -2046870129
   )
   static int field321;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 1515965009
   )
   static int field322;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1384418161
   )
   static int field323;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -371529883
   )
   static int field324;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -167295073
   )
   static int field325;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1079330147
   )
   static int field326;
   @ObfuscatedName("ct")
   static class125 field327;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1176653805
   )
   static int field328;
   @ObfuscatedName("ej")
   static boolean field329;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 464573635
   )
   static int field330;
   @ObfuscatedName("gf")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ot")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -366256175
   )
   static int field333;
   @ObfuscatedName("ki")
   static Deque field334;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1143176383
   )
   static int field335;
   @ObfuscatedName("cf")
   static boolean field336;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 13225295
   )
   static int field337;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -1059219301
   )
   static int field338;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 1200784645
   )
   static int field339;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -266561877
   )
   static int field340;
   @ObfuscatedName("li")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1467711357
   )
   static int field343 = 0;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 1214434311
   )
   static int field344;
   @ObfuscatedName("dx")
   static final int[] field345;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -629083547
   )
   static int field346;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 1277447009
   )
   static int field347;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -2032987605
   )
   static int field348;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -1051694623
   )
   static int field349;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 1029723857
   )
   static int field350;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1879226631
   )
   static int field351;
   @ObfuscatedName("hb")
   static int[] field352;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1963721289
   )
   static int field353 = 0;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -517322051
   )
   static int field354;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -289321773
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -346789341
   )
   static int field356;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -786585365
   )
   static int field357 = 0;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 714182049
   )
   static int field358;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1931976119
   )
   static int field359;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 1656217681
   )
   static int field360;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1237993027
   )
   static int field361;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -2061425077
   )
   static int field362;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -1470004197
   )
   static int field363;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -1626870889
   )
   static int field364;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 939458425
   )
   static int field365;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -1467868453
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 1277776789
   )
   static int field367;
   @ObfuscatedName("he")
   static boolean[] field368;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 1174790097
   )
   static int field369;
   @ObfuscatedName("ju")
   static Widget field370;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 301510113
   )
   static int field371;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -689902027
   )
   static int field372;
   @ObfuscatedName("fu")
   static boolean field373;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 1979682437
   )
   static int field374;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1862724197
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -680271419
   )
   static int field376;
   @ObfuscatedName("fy")
   static int[] field377;
   @ObfuscatedName("fe")
   static int[] field378;
   @ObfuscatedName("kg")
   static Deque field379;
   @ObfuscatedName("fr")
   static int[] field380;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 102763553
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1431565683
   )
   static int field382;
   @ObfuscatedName("fd")
   static int[] field383;
   @ObfuscatedName("gy")
   static String[] field384;
   @ObfuscatedName("gx")
   static int[][] field385;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1458738751
   )
   static int field386;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1718429031
   )
   static int field387;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -502901287
   )
   static int field388;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 1793417699
   )
   static int field389;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1171153033
   )
   static int field390;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 249015625
   )
   static int field391;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 349238785
   )
   static int field392;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 2056485443
   )
   static int field393;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -356478371
   )
   static int field394;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1937644783
   )
   static int field395;
   @ObfuscatedName("jr")
   static boolean field396;
   @ObfuscatedName("cj")
   static class125 field397;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 478102433
   )
   static int field398;
   @ObfuscatedName("gt")
   static boolean field399;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 959968725
   )
   static int field400;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 814813547
   )
   static int field401;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -968425249
   )
   static int field402;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 732871009
   )
   static int field403;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 353263075
   )
   static int field404;
   @ObfuscatedName("cw")
   static int[] field405;
   @ObfuscatedName("hh")
   static int[] field406;
   @ObfuscatedName("hx")
   static final int[] field407;
   @ObfuscatedName("hg")
   static String[] field408;
   @ObfuscatedName("ay")
   static boolean field409 = true;
   @ObfuscatedName("og")
   static short field410;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 1725714545
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("hn")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("hd")
   static Deque field413;
   @ObfuscatedName("ht")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hf")
   static Deque field415;
   @ObfuscatedName("hw")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1829263913
   )
   static int field417;
   @ObfuscatedName("hk")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 2017189999
   )
   static int field419;
   @ObfuscatedName("hi")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 1443053701
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("oy")
   static int[] field422;
   @ObfuscatedName("hy")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("iq")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("cx")
   static class125 field425;
   @ObfuscatedName("id")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("iu")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -610459885
   )
   static int field428;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1120242351
   )
   static int field429;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 1258655329
   )
   static int field430;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -2053060397
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 642476295
   )
   static int field432;
   @ObfuscatedName("ir")
   static String field433;
   @ObfuscatedName("ig")
   static boolean field434;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -1375081513
   )
   static int field435;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1700948309
   )
   static int field436;
   @ObfuscatedName("kf")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("ib")
   static String field438;
   @ObfuscatedName("nh")
   static boolean[] field439;
   @ObfuscatedName("ij")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = 242796391
   )
   static int field441;
   @ObfuscatedName("e")
   static Client field442;
   @ObfuscatedName("jj")
   static Widget field443;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -1875312665
   )
   static int field444;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -1214828581
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -1112796597
   )
   static int field446;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1450549245
   )
   static int field447;
   @ObfuscatedName("ja")
   static boolean field448;
   @ObfuscatedName("je")
   static boolean field449;
   @ObfuscatedName("jm")
   static boolean field450;
   @ObfuscatedName("jp")
   static Widget field451;
   @ObfuscatedName("jl")
   static Widget field452;
   @ObfuscatedName("jn")
   static Widget field453;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      longValue = 3196258930564551239L
   )
   static long field454;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 1734122989
   )
   static int field455;
   @ObfuscatedName("cl")
   static int[] field456;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1426417013
   )
   static int field457 = 0;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 1198683977
   )
   static int field458;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 1489737345
   )
   static int field459;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 1018892807
   )
   static int field461;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -471743941
   )
   static int field462;
   @ObfuscatedName("jy")
   static boolean field463;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = -984349759
   )
   static int field464;
   @ObfuscatedName("kx")
   static int[] field465;
   @ObfuscatedName("oo")
   static int[] field467;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 557222353
   )
   static int field468;
   @ObfuscatedName("kv")
   static int[] field469;
   @ObfuscatedName("mf")
   static boolean field470;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 1993621611
   )
   static int field471;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 2015459217
   )
   static int field472;
   @ObfuscatedName("dz")
   static boolean field473;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -549143981
   )
   static int field474;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -1791102935
   )
   static int field475;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -1410156863
   )
   static int field476;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -1874503609
   )
   static int field477;
   @ObfuscatedName("ia")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("km")
   static Deque field479;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -1308481749
   )
   static int field480;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -326672187
   )
   static int field481;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 2090912703
   )
   static int field482;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -1254308607
   )
   static int field483;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 640787859
   )
   static int field484;
   @ObfuscatedName("lp")
   static boolean[] field485;
   @ObfuscatedName("lh")
   static boolean[] field486;
   @ObfuscatedName("lq")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("lb")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -918337519
   )
   static int field489;
   @ObfuscatedName("lw")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -911972583
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("im")
   static String field492;
   @ObfuscatedName("lo")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = -922914653
   )
   static int field494;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 1739457595
   )
   static int field495;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 1256343781
   )
   static int field496;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -1544034261
   )
   static int field497;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 509560599
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("lz")
   static String field499;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = -1955355595
   )
   static int field500;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -548995077
   )
   static int field501;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -1136628915
   )
   static int field502;
   @ObfuscatedName("ln")
   static int[] field503;
   @ObfuscatedName("mn")
   static int[] field504;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      longValue = 3787814506818482991L
   )
   static long field505;
   @ObfuscatedName("md")
   static String field506;
   @ObfuscatedName("mc")
   static String field507;
   @ObfuscatedName("jb")
   static boolean field508;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 2134850343
   )
   static int field509;
   @ObfuscatedName("ai")
   static class21 field510;
   @ObfuscatedName("mx")
   static int[] field511;
   @ObfuscatedName("mo")
   static SpritePixels[] field512;
   @ObfuscatedName("or")
   static short field513;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -838753319
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("pt")
   static int[] field515;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -1968665553
   )
   static int field516;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 219472815
   )
   static int field517;
   @ObfuscatedName("fa")
   static int[] field518;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -1156446615
   )
   static int field519;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -2020307389
   )
   static int field520;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -543242379
   )
   static int field521;
   @ObfuscatedName("nv")
   static int[] field522;
   @ObfuscatedName("nd")
   static int[] field523;
   @ObfuscatedName("ne")
   static int[] field524;
   @ObfuscatedName("ni")
   static int[] field525;
   @ObfuscatedName("ko")
   static boolean[] field526;
   @ObfuscatedName("r")
   static boolean field527 = true;
   @ObfuscatedName("b")
   static class156 field528;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 584133051
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("os")
   static int[] field530;
   @ObfuscatedName("bw")
   static class171 field531;
   @ObfuscatedName("oa")
   static int[] field532;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 2138876049
   )
   static int field533 = 0;
   @ObfuscatedName("me")
   static int[] field534;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      longValue = -8112272787625825525L
   )
   static long field535;
   @ObfuscatedName("of")
   static short field536;
   @ObfuscatedName("ok")
   static short field537;
   @ObfuscatedName("od")
   static short field538;
   @ObfuscatedName("on")
   static short field539;
   @ObfuscatedName("oh")
   static short field540;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -881550167
   )
   static int field541;
   @ObfuscatedName("oc")
   static short field542;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 258558157
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("lj")
   static long[] field544;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 925821393
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("hj")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -1819880181
   )
   static int field547;
   @ObfuscatedName("op")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -1601841041
   )
   static int field549;
   @ObfuscatedName("kh")
   static int[] field550;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 114158221
   )
   static int field551;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1931322257
   )
   static int field552;
   @ObfuscatedName("fn")
   static int[] field553;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -1931452651
   )
   static int field554;
   @ObfuscatedName("pz")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 544242239
   )
   static int field556;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      longValue = 3660580808768404115L
   )
   static long field557;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      longValue = -8397278843619947851L
   )
   static long field558;
   @ObfuscatedName("pg")
   static final class10 field559;
   @ObfuscatedName("pj")
   static int[] field560;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 1707741757
   )
   static int field561;
   @ObfuscatedName("nz")
   static boolean field562;
   @ObfuscatedName("hr")
   @Export("menuActionParams0")
   static int[] menuActionParams0;

   public final void init() {
      if(this.method3034()) {
         class193[] var1 = new class193[]{class193.field3115, class193.field3112, class193.field3107, class193.field3116, class193.field3106, class193.field3114, class193.field3110, class193.field3117, class193.field3113, class193.field3103, class193.field3109, class193.field3108, class193.field3104, class193.field3111, class193.field3105};
         class193[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class193 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3118);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3118)) {
               case 1:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 2:
                  int var7 = Integer.parseInt(var5);
                  class156[] var8 = class138.method2898();
                  int var9 = 0;

                  class156 var15;
                  while(true) {
                     if(var9 >= var8.length) {
                        var15 = null;
                        break;
                     }

                     class156 var10 = var8[var9];
                     if(var10.field2323 == var7) {
                        var15 = var10;
                        break;
                     }

                     ++var9;
                  }

                  field528 = var15;
                  break;
               case 3:
                  XItemContainer.field219 = var5;
                  break;
               case 4:
                  flags = Integer.parseInt(var5);
                  break;
               case 5:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
               case 6:
               case 8:
               default:
                  break;
               case 7:
                  class157[] var6 = new class157[]{class157.field2329, class157.field2331, class157.field2327, class157.field2326, class157.field2330, class157.field2328};
                  class164.field2676 = (class157)class168.method3262(var6, Integer.parseInt(var5));
                  if(class157.field2331 == class164.field2676) {
                     RSCanvas.field2188 = class215.field3180;
                  } else {
                     RSCanvas.field2188 = class215.field3181;
                  }
                  break;
               case 9:
                  NPC.field788 = Integer.parseInt(var5);
                  break;
               case 10:
                  field287 = Integer.parseInt(var5);
                  break;
               case 11:
                  field343 = Integer.parseInt(var5);
                  break;
               case 12:
                  world = Integer.parseInt(var5);
                  break;
               case 13:
                  class13.field196 = var5;
                  break;
               case 14:
                  class75.field1401 = Integer.parseInt(var5);
               }
            }
         }

         class54.method1092();
         World.host = this.getCodeBase().getHost();
         String var14 = field528.field2324;
         byte var11 = 0;

         try {
            GameObject.method2234("oldschool", var14, var11, 16);
         } catch (Exception var13) {
            Frames.method2316((String)null, var13);
         }

         field442 = this;
         this.method3032(765, 503, 124);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "76"
   )
   protected final void vmethod3031() {
      class28.field673 = field343 == 0?'ꩊ':world + '鱀';
      class35.field781 = field343 == 0?443:world + '썐';
      class114.field2013 = class28.field673;
      class169.field2701 = class177.field2925;
      class134.field2120 = class177.field2928;
      FrameMap.field1824 = class177.field2926;
      PlayerComposition.field2960 = class177.field2927;
      if(class139.field2146.toLowerCase().indexOf("microsoft") != -1) {
         class140.field2165[186] = 57;
         class140.field2165[187] = 27;
         class140.field2165[188] = 71;
         class140.field2165[189] = 26;
         class140.field2165[190] = 72;
         class140.field2165[191] = 73;
         class140.field2165[192] = 58;
         class140.field2165[219] = 42;
         class140.field2165[220] = 74;
         class140.field2165[221] = 43;
         class140.field2165[222] = 59;
         class140.field2165[223] = 28;
      } else {
         class140.field2165[44] = 71;
         class140.field2165[45] = 26;
         class140.field2165[46] = 72;
         class140.field2165[47] = 73;
         class140.field2165[59] = 57;
         class140.field2165[61] = 27;
         class140.field2165[91] = 42;
         class140.field2165[92] = 74;
         class140.field2165[93] = 43;
         class140.field2165[192] = 28;
         class140.field2165[222] = 58;
         class140.field2165[520] = 59;
      }

      Canvas var1 = GameObject.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class140.keyboard);
      var1.addFocusListener(class140.keyboard);
      Canvas var2 = GameObject.canvas;
      var2.addMouseListener(class143.mouse);
      var2.addMouseMotionListener(class143.mouse);
      var2.addFocusListener(class143.mouse);
      class112.field1965 = class40.method789();
      if(class112.field1965 != null) {
         class112.field1965.vmethod3129(GameObject.canvas);
      }

      class59.field1228 = new class137(255, class152.field2281, class152.field2283, 500000);
      FileOnDisk var4 = null;
      class8 var5 = new class8();

      try {
         var4 = Actor.method786("", class164.field2676.field2332, false);
         byte[] var6 = new byte[(int)var4.method4206()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.method4193(var6, var7, var6.length - var7);
            if(var8 == -1) {
               throw new IOException();
            }
         }

         var5 = new class8(new Buffer(var6));
      } catch (Exception var11) {
         ;
      }

      try {
         if(var4 != null) {
            var4.method4191();
         }
      } catch (Exception var10) {
         ;
      }

      class16.field232 = var5;
      class8.field144 = this.getToolkit().getSystemClipboard();
      String var12 = class0.field4;
      class141.field2182 = this;
      class141.field2180 = var12;
      if(field343 != 0) {
         field296 = true;
      }

      int var9 = class16.field232.field136;
      field454 = 0L;
      if(var9 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      class49.method1009();
      if(gameState >= 25) {
         class14.method158();
      }

      GameEngine.field2250 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1378080876"
   )
   protected final void vmethod3045() {
      if(class126.chatMessages.method204()) {
         class126.chatMessages.method201();
      }

      if(null != class222.field3213) {
         class222.field3213.field192 = false;
      }

      class222.field3213 = null;
      if(null != class23.field604) {
         class23.field604.method3010();
         class23.field604 = null;
      }

      class1.method15();
      if(null != class143.mouse) {
         class143 var1 = class143.mouse;
         synchronized(class143.mouse) {
            class143.mouse = null;
         }
      }

      class112.field1965 = null;
      if(class0.field14 != null) {
         class0.field14.method1225();
      }

      if(class134.field2119 != null) {
         class134.field2119.method1225();
      }

      if(null != class174.field2755) {
         class174.field2755.method3010();
      }

      Object var9 = class173.field2746;
      synchronized(class173.field2746) {
         if(class173.field2743 != 0) {
            class173.field2743 = 1;

            try {
               class173.field2746.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      try {
         class152.field2281.method4211();

         for(int var4 = 0; var4 < class152.field2280; ++var4) {
            class23.field606[var4].method4211();
         }

         class152.field2283.method4211();
         class152.field2275.method4211();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1718483584"
   )
   void method240() {
      if(class174.field2765 >= 4) {
         this.method3046("js5crc");
         gameState = 1000;
      } else {
         if(class174.field2766 >= 4) {
            if(gameState <= 5) {
               this.method3046("js5io");
               gameState = 1000;
               return;
            }

            field310 = 3000;
            class174.field2766 = 3;
         }

         if(--field310 + 1 <= 0) {
            try {
               if(field309 == 0) {
                  class140.field2166 = class54.field1146.method2909(World.host, class114.field2013);
                  ++field309;
               }

               if(field309 == 1) {
                  if(class140.field2166.field2262 == 2) {
                     this.method461(-1);
                     return;
                  }

                  if(class140.field2166.field2262 == 1) {
                     ++field309;
                  }
               }

               if(field309 == 2) {
                  class188.field3045 = new class146((Socket)class140.field2166.field2266, class54.field1146);
                  Buffer var1 = new Buffer(5);
                  var1.method2518(15);
                  var1.method2521(124);
                  class188.field3045.method3009(var1.payload, 0, 5);
                  ++field309;
                  field311 = class11.method139();
               }

               if(field309 == 3) {
                  if(gameState > 5 && class188.field3045.method3013() <= 0) {
                     if(class11.method139() - field311 > 30000L) {
                        this.method461(-2);
                        return;
                     }
                  } else {
                     int var5 = class188.field3045.method3029();
                     if(var5 != 0) {
                        this.method461(var5);
                        return;
                     }

                     ++field309;
                  }
               }

               if(field309 == 4) {
                  class146 var10 = class188.field3045;
                  boolean var2 = gameState > 20;
                  if(null != class174.field2755) {
                     try {
                        class174.field2755.method3010();
                     } catch (Exception var8) {
                        ;
                     }

                     class174.field2755 = null;
                  }

                  class174.field2755 = var10;
                  XItemContainer.method174(var2);
                  class174.field2770.offset = 0;
                  class5.field95 = null;
                  class32.field707 = null;
                  class174.field2762 = 0;

                  while(true) {
                     class175 var3 = (class175)class174.field2753.method3852();
                     if(null == var3) {
                        while(true) {
                           var3 = (class175)class174.field2760.method3852();
                           if(var3 == null) {
                              if(class174.field2764 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.method2518(4);
                                    var11.method2518(class174.field2764);
                                    var11.method2519(0);
                                    class174.field2755.method3009(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class174.field2755.method3010();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class174.field2766;
                                    class174.field2755 = null;
                                 }
                              }

                              class174.field2749 = 0;
                              class174.field2750 = class11.method139();
                              class140.field2166 = null;
                              class188.field3045 = null;
                              field309 = 0;
                              field315 = 0;
                              return;
                           }

                           class174.field2758.method3955(var3);
                           class174.field2756.method3850(var3, var3.hash);
                           ++class174.field2769;
                           --class174.field2757;
                        }
                     }

                     class174.field2751.method3850(var3, var3.hash);
                     ++class174.field2748;
                     --class174.field2754;
                  }
               }
            } catch (IOException var9) {
               this.method461(-3);
            }

         }
      }
   }

   static {
      field510 = class21.field578;
      field320 = class21.field578;
      field302 = 0;
      field309 = 0;
      field310 = 0;
      field315 = 0;
      field556 = 0;
      field317 = 0;
      field318 = 0;
      field429 = 0;
      cachedNPCs = new NPC['耀'];
      field321 = 0;
      field405 = new int['耀'];
      field323 = 0;
      field456 = new int[250];
      field397 = new class125(5000);
      field425 = new class125(5000);
      field327 = new class125(15000);
      field328 = 0;
      packetOpcode = 0;
      field330 = 0;
      field552 = 0;
      field326 = 0;
      field333 = 0;
      field289 = 0;
      field335 = 0;
      field336 = false;
      field337 = 0;
      field338 = 1;
      field339 = 0;
      field340 = 1;
      field561 = 0;
      collisionMaps = new CollisionData[4];
      field473 = false;
      field299 = new int[4][13][13];
      field345 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field346 = 0;
      field347 = 2;
      field348 = 0;
      field349 = 2;
      field350 = 0;
      field351 = 1;
      field489 = 0;
      mapScale = 0;
      field354 = 2;
      mapScaleDelta = 0;
      field356 = 1;
      field481 = 0;
      field358 = 0;
      field359 = 1;
      field360 = 1;
      field361 = 1;
      field362 = 7759444;
      field329 = false;
      field364 = 0;
      field365 = 128;
      mapAngle = 0;
      field367 = 0;
      field476 = 0;
      field322 = 0;
      field306 = 0;
      field371 = 50;
      field372 = 0;
      field373 = false;
      field374 = 0;
      field382 = 0;
      field376 = 50;
      field377 = new int[field376];
      field378 = new int[field376];
      field553 = new int[field376];
      field380 = new int[field376];
      field518 = new int[field376];
      field284 = new int[field376];
      field383 = new int[field376];
      field384 = new String[field376];
      field385 = new int[104][104];
      field386 = 0;
      field387 = -1;
      field388 = -1;
      field389 = 0;
      field390 = 0;
      field391 = 0;
      field392 = 0;
      field551 = 0;
      field394 = 0;
      field395 = 0;
      field393 = 0;
      field417 = 0;
      field398 = 0;
      field399 = false;
      field402 = 0;
      field401 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field404 = 0;
      field496 = 0;
      field406 = new int[1000];
      field407 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field408 = new String[8];
      field368 = new boolean[8];
      field352 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field471 = -1;
      groundItemDeque = new Deque[4][104][104];
      field413 = new Deque();
      projectiles = new Deque();
      field415 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field419 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field428 = -1;
      field500 = -1;
      field458 = 0;
      field403 = 50;
      field432 = 0;
      field433 = null;
      field434 = false;
      field344 = -1;
      field484 = -1;
      field492 = null;
      field438 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field441 = 0;
      field549 = 0;
      field443 = null;
      energy = 0;
      weight = 0;
      field446 = 0;
      field447 = -1;
      field448 = false;
      field449 = false;
      field450 = false;
      field451 = null;
      field452 = null;
      field453 = null;
      field521 = 0;
      field455 = 0;
      field370 = null;
      field396 = false;
      field400 = -1;
      field459 = -1;
      field508 = false;
      field461 = -1;
      field462 = -1;
      field463 = false;
      field295 = 1;
      field465 = new int[32];
      field435 = 0;
      field550 = new int[32];
      field468 = 0;
      field469 = new int[32];
      field444 = 0;
      field325 = 0;
      field472 = 0;
      field281 = 0;
      field474 = 0;
      field475 = 0;
      field480 = 0;
      field477 = 0;
      field379 = new Deque();
      field479 = new Deque();
      field334 = new Deque();
      widgetFlags = new XHashTable(512);
      field482 = 0;
      field483 = -2;
      field526 = new boolean[100];
      field485 = new boolean[100];
      field486 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field307 = 0;
      field454 = 0L;
      isResized = true;
      field436 = 765;
      field495 = 503;
      field300 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field497 = 0;
      field324 = 0;
      field499 = "";
      field544 = new long[100];
      field501 = 0;
      field502 = 0;
      field503 = new int[128];
      field504 = new int[128];
      field505 = -1L;
      field506 = null;
      field507 = null;
      field430 = -1;
      field509 = 0;
      field534 = new int[1000];
      field511 = new int[1000];
      field512 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field369 = 0;
      field516 = 255;
      field517 = -1;
      field470 = false;
      field519 = 127;
      field520 = 127;
      field363 = 0;
      field522 = new int[50];
      field523 = new int[50];
      field524 = new int[50];
      field525 = new int[50];
      field313 = new class61[50];
      field562 = false;
      field439 = new boolean[5];
      field467 = new int[5];
      field530 = new int[5];
      field422 = new int[5];
      field532 = new int[5];
      field410 = 256;
      field542 = 205;
      field513 = 256;
      field536 = 320;
      field537 = 1;
      field538 = 32767;
      field539 = 1;
      field540 = 32767;
      field541 = 0;
      field547 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field494 = 0;
      friends = new Friend[400];
      field316 = new class198();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field305 = new PlayerComposition();
      field464 = -1;
      field554 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field557 = -1L;
      field535 = -1L;
      field559 = new class10();
      field560 = new int[50];
      field515 = new int[50];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-41"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method526();

      while(true) {
         Deque var2 = class173.field2744;
         class172 var1;
         synchronized(class173.field2744) {
            var1 = (class172)class173.field2742.method3904();
         }

         if(null == var1) {
            int var47;
            try {
               if(class186.field3005 == 1) {
                  var47 = class28.field670.method3767();
                  if(var47 > 0 && class28.field670.method3664()) {
                     var47 -= class186.field3002;
                     if(var47 < 0) {
                        var47 = 0;
                     }

                     class28.field670.method3697(var47);
                  } else {
                     class28.field670.method3663();
                     class28.field670.method3721();
                     if(class186.field2996 != null) {
                        class186.field3005 = 2;
                     } else {
                        class186.field3005 = 0;
                     }

                     class186.field3001 = null;
                     class186.field3000 = null;
                  }
               }
            } catch (Exception var68) {
               var68.printStackTrace();
               class28.field670.method3663();
               class186.field3005 = 0;
               class186.field3001 = null;
               class186.field3000 = null;
               class186.field2996 = null;
            }

            class49.method1012();
            class140 var69 = class140.keyboard;
            int var48;
            synchronized(class140.keyboard) {
               ++class140.keyboardIdleTicks;
               class140.field2173 = class140.field2175;
               class140.field2172 = 0;
               if(class140.field2168 >= 0) {
                  while(class140.field2167 != class140.field2168) {
                     var48 = class140.field2158[class140.field2167];
                     class140.field2167 = class140.field2167 + 1 & 127;
                     if(var48 < 0) {
                        class140.field2153[~var48] = false;
                     } else {
                        if(!class140.field2153[var48] && class140.field2172 < class140.field2171.length - 1) {
                           class140.field2171[++class140.field2172 - 1] = var48;
                        }

                        class140.field2153[var48] = true;
                     }
                  }
               } else {
                  for(var48 = 0; var48 < 112; ++var48) {
                     class140.field2153[var48] = false;
                  }

                  class140.field2168 = class140.field2167;
               }

               class140.field2175 = class140.field2174;
            }

            class143 var70 = class143.mouse;
            synchronized(class143.mouse) {
               class143.field2205 = class143.field2194;
               class143.field2192 = class143.field2208;
               class143.field2199 = class143.field2196;
               class143.field2198 = class143.field2200;
               class143.field2197 = class143.field2201;
               class143.field2207 = class143.field2202;
               class143.field2195 = class143.field2203;
               class143.field2200 = 0;
            }

            if(class112.field1965 != null) {
               var47 = class112.field1965.vmethod3131();
               field477 = var47;
            }

            if(gameState == 0) {
               class20.method559();
               class54.field1148.vmethod3141();

               for(var47 = 0; var47 < 32; ++var47) {
                  GameEngine.field2246[var47] = 0L;
               }

               for(var47 = 0; var47 < 32; ++var47) {
                  GameEngine.field2247[var47] = 0L;
               }

               Tile.field1807 = 0;
            } else if(gameState == 5) {
               class116.method2467(this);
               class20.method559();
               class54.field1148.vmethod3141();

               for(var47 = 0; var47 < 32; ++var47) {
                  GameEngine.field2246[var47] = 0L;
               }

               for(var47 = 0; var47 < 32; ++var47) {
                  GameEngine.field2247[var47] = 0L;
               }

               Tile.field1807 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class116.method2467(this);
                  class160.method3194();
               } else if(gameState == 25) {
                  class8.method110(false);
                  field337 = 0;
                  boolean var80 = true;

                  for(var48 = 0; var48 < class8.field148.length; ++var48) {
                     if(XGrandExchangeOffer.field3222[var48] != -1 && null == class8.field148[var48]) {
                        class8.field148[var48] = class62.field1267.method3304(XGrandExchangeOffer.field3222[var48], 0);
                        if(null == class8.field148[var48]) {
                           var80 = false;
                           ++field337;
                        }
                     }

                     if(FrameMap.field1826[var48] != -1 && null == MessageNode.field798[var48]) {
                        MessageNode.field798[var48] = class62.field1267.method3318(FrameMap.field1826[var48], 0, class143.xteaKeys[var48]);
                        if(MessageNode.field798[var48] == null) {
                           var80 = false;
                           ++field337;
                        }
                     }
                  }

                  if(!var80) {
                     field561 = 1;
                  } else {
                     field339 = 0;
                     var80 = true;

                     int var10;
                     int var11;
                     int var12;
                     int var14;
                     int var15;
                     int var16;
                     int var17;
                     int var18;
                     int var19;
                     int var49;
                     int var50;
                     for(var48 = 0; var48 < class8.field148.length; ++var48) {
                        byte[] var3 = MessageNode.field798[var48];
                        if(var3 != null) {
                           var49 = (VertexNormal.mapRegions[var48] >> 8) * 64 - class32.baseX;
                           var50 = (VertexNormal.mapRegions[var48] & 255) * 64 - class8.baseY;
                           if(field473) {
                              var49 = 10;
                              var50 = 10;
                           }

                           boolean var8 = true;
                           Buffer var9 = new Buffer(var3);
                           var10 = -1;

                           label1454:
                           while(true) {
                              var11 = var9.method2546();
                              if(var11 == 0) {
                                 var80 &= var8;
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;
                              boolean var13 = false;

                              while(true) {
                                 while(!var13) {
                                    var14 = var9.method2546();
                                    if(var14 == 0) {
                                       continue label1454;
                                    }

                                    var12 += var14 - 1;
                                    var15 = var12 & 63;
                                    var16 = var12 >> 6 & 63;
                                    var17 = var9.method2656() >> 2;
                                    var18 = var16 + var49;
                                    var19 = var50 + var15;
                                    if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                       ObjectComposition var20 = class8.getObjectDefinition(var10);
                                       if(var17 != 22 || !field286 || var20.field958 != 0 || var20.field938 == 1 || var20.field931) {
                                          if(!var20.method832()) {
                                             ++field339;
                                             var8 = false;
                                          }

                                          var13 = true;
                                       }
                                    }
                                 }

                                 var14 = var9.method2546();
                                 if(var14 == 0) {
                                    break;
                                 }

                                 var9.method2656();
                              }
                           }
                        }
                     }

                     if(!var80) {
                        field561 = 2;
                     } else {
                        if(field561 != 0) {
                           class12.method145("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class49.method1012();
                        BufferProvider.method1746();
                        class49.method1012();
                        class9.region.method1965();
                        class49.method1012();
                        System.gc();

                        for(var48 = 0; var48 < 4; ++var48) {
                           collisionMaps[var48].method2432();
                        }

                        int var51;
                        for(var48 = 0; var48 < 4; ++var48) {
                           for(var51 = 0; var51 < 104; ++var51) {
                              for(var49 = 0; var49 < 104; ++var49) {
                                 class5.tileSettings[var48][var51][var49] = 0;
                              }
                           }
                        }

                        class49.method1012();
                        class118.method2471();
                        var48 = class8.field148.length;
                        class21.method574();
                        class8.method110(true);
                        int var6;
                        int var7;
                        int var74;
                        int var76;
                        if(!field473) {
                           var51 = 0;

                           label1392:
                           while(true) {
                              byte[] var52;
                              if(var51 >= var48) {
                                 for(var51 = 0; var51 < var48; ++var51) {
                                    var49 = 64 * (VertexNormal.mapRegions[var51] >> 8) - class32.baseX;
                                    var50 = (VertexNormal.mapRegions[var51] & 255) * 64 - class8.baseY;
                                    var52 = class8.field148[var51];
                                    if(null == var52 && class4.field72 < 800) {
                                       class49.method1012();
                                       class23.method588(var49, var50, 64, 64);
                                    }
                                 }

                                 class8.method110(true);
                                 var51 = 0;

                                 while(true) {
                                    if(var51 >= var48) {
                                       break label1392;
                                    }

                                    byte[] var4 = MessageNode.field798[var51];
                                    if(null != var4) {
                                       var50 = 64 * (VertexNormal.mapRegions[var51] >> 8) - class32.baseX;
                                       var6 = (VertexNormal.mapRegions[var51] & 255) * 64 - class8.baseY;
                                       class49.method1012();
                                       class79.method1727(var4, var50, var6, class9.region, collisionMaps);
                                    }

                                    ++var51;
                                 }
                              }

                              var49 = (VertexNormal.mapRegions[var51] >> 8) * 64 - class32.baseX;
                              var50 = (VertexNormal.mapRegions[var51] & 255) * 64 - class8.baseY;
                              var52 = class8.field148[var51];
                              if(null != var52) {
                                 class49.method1012();
                                 var7 = ItemLayer.field1737 * 8 - 48;
                                 var74 = class4.field72 * 8 - 48;
                                 CollisionData[] var75 = collisionMaps;
                                 var10 = 0;

                                 label1389:
                                 while(true) {
                                    if(var10 >= 4) {
                                       Buffer var53 = new Buffer(var52);
                                       var11 = 0;

                                       while(true) {
                                          if(var11 >= 4) {
                                             break label1389;
                                          }

                                          for(var12 = 0; var12 < 64; ++var12) {
                                             for(var76 = 0; var76 < 64; ++var76) {
                                                class143.method2998(var53, var11, var49 + var12, var76 + var50, var7, var74, 0);
                                             }
                                          }

                                          ++var11;
                                       }
                                    }

                                    for(var11 = 0; var11 < 64; ++var11) {
                                       for(var12 = 0; var12 < 64; ++var12) {
                                          if(var11 + var49 > 0 && var11 + var49 < 103 && var12 + var50 > 0 && var12 + var50 < 103) {
                                             var75[var10].flags[var49 + var11][var12 + var50] &= -16777217;
                                          }
                                       }
                                    }

                                    ++var10;
                                 }
                              }

                              ++var51;
                           }
                        }

                        int var21;
                        int var22;
                        int var23;
                        int var24;
                        int var25;
                        int var26;
                        int var27;
                        int var28;
                        int var29;
                        int var30;
                        int var32;
                        int var33;
                        int var34;
                        int var54;
                        if(field473) {
                           var51 = 0;

                           label1338:
                           while(true) {
                              if(var51 >= 4) {
                                 for(var51 = 0; var51 < 13; ++var51) {
                                    for(var49 = 0; var49 < 13; ++var49) {
                                       var50 = field299[0][var51][var49];
                                       if(var50 == -1) {
                                          class23.method588(8 * var51, 8 * var49, 8, 8);
                                       }
                                    }
                                 }

                                 class8.method110(true);
                                 var51 = 0;

                                 while(true) {
                                    if(var51 >= 4) {
                                       break label1338;
                                    }

                                    class49.method1012();

                                    for(var49 = 0; var49 < 13; ++var49) {
                                       label1261:
                                       for(var50 = 0; var50 < 13; ++var50) {
                                          var6 = field299[var51][var49][var50];
                                          if(var6 != -1) {
                                             var7 = var6 >> 24 & 3;
                                             var74 = var6 >> 1 & 3;
                                             var54 = var6 >> 14 & 1023;
                                             var10 = var6 >> 3 & 2047;
                                             var11 = var10 / 8 + (var54 / 8 << 8);

                                             for(var12 = 0; var12 < VertexNormal.mapRegions.length; ++var12) {
                                                if(var11 == VertexNormal.mapRegions[var12] && MessageNode.field798[var12] != null) {
                                                   byte[] var55 = MessageNode.field798[var12];
                                                   var14 = var49 * 8;
                                                   var15 = 8 * var50;
                                                   var16 = (var54 & 7) * 8;
                                                   var17 = 8 * (var10 & 7);
                                                   Region var56 = class9.region;
                                                   CollisionData[] var57 = collisionMaps;
                                                   Buffer var77 = new Buffer(var55);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var77.method2546();
                                                      if(var22 == 0) {
                                                         continue label1261;
                                                      }

                                                      var21 += var22;
                                                      var23 = 0;

                                                      while(true) {
                                                         var24 = var77.method2546();
                                                         if(var24 == 0) {
                                                            break;
                                                         }

                                                         var23 += var24 - 1;
                                                         var25 = var23 & 63;
                                                         var26 = var23 >> 6 & 63;
                                                         var27 = var23 >> 12;
                                                         var28 = var77.method2656();
                                                         var29 = var28 >> 2;
                                                         var30 = var28 & 3;
                                                         if(var27 == var7 && var26 >= var16 && var26 < 8 + var16 && var25 >= var17 && var25 < var17 + 8) {
                                                            ObjectComposition var31 = class8.getObjectDefinition(var21);
                                                            var32 = var14 + class50.method1027(var26 & 7, var25 & 7, var74, var31.field936, var31.field937, var30);
                                                            var33 = var15 + XItemContainer.method183(var26 & 7, var25 & 7, var74, var31.field936, var31.field937, var30);
                                                            if(var32 > 0 && var33 > 0 && var32 < 103 && var33 < 103) {
                                                               var34 = var51;
                                                               if((class5.tileSettings[1][var32][var33] & 2) == 2) {
                                                                  var34 = var51 - 1;
                                                               }

                                                               CollisionData var35 = null;
                                                               if(var34 >= 0) {
                                                                  var35 = var57[var34];
                                                               }

                                                               ItemComposition.method1112(var51, var32, var33, var21, var74 + var30 & 3, var29, var56, var35);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var51;
                                 }
                              }

                              class49.method1012();

                              for(var49 = 0; var49 < 13; ++var49) {
                                 for(var50 = 0; var50 < 13; ++var50) {
                                    boolean var73 = false;
                                    var7 = field299[var51][var49][var50];
                                    if(var7 != -1) {
                                       var74 = var7 >> 24 & 3;
                                       var54 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var76 = 0; var76 < VertexNormal.mapRegions.length; ++var76) {
                                          if(var12 == VertexNormal.mapRegions[var76] && null != class8.field148[var76]) {
                                             class59.method1274(class8.field148[var76], var51, var49 * 8, 8 * var50, var74, 8 * (var10 & 7), (var11 & 7) * 8, var54, collisionMaps);
                                             var73 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var73) {
                                       var74 = var51;
                                       var54 = 8 * var49;
                                       var10 = var50 * 8;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class5.tileHeights[var74][var11 + var54][var10 + var12] = 0;
                                          }
                                       }

                                       if(var54 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.tileHeights[var74][var54][var10 + var11] = class5.tileHeights[var74][var54 - 1][var11 + var10];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.tileHeights[var74][var54 + var11][var10] = class5.tileHeights[var74][var11 + var54][var10 - 1];
                                          }
                                       }

                                       if(var54 > 0 && class5.tileHeights[var74][var54 - 1][var10] != 0) {
                                          class5.tileHeights[var74][var54][var10] = class5.tileHeights[var74][var54 - 1][var10];
                                       } else if(var10 > 0 && class5.tileHeights[var74][var54][var10 - 1] != 0) {
                                          class5.tileHeights[var74][var54][var10] = class5.tileHeights[var74][var54][var10 - 1];
                                       } else if(var54 > 0 && var10 > 0 && class5.tileHeights[var74][var54 - 1][var10 - 1] != 0) {
                                          class5.tileHeights[var74][var54][var10] = class5.tileHeights[var74][var54 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var51;
                           }
                        }

                        class8.method110(true);
                        BufferProvider.method1746();
                        class49.method1012();
                        Region var71 = class9.region;
                        CollisionData[] var72 = collisionMaps;

                        for(var50 = 0; var50 < 4; ++var50) {
                           for(var6 = 0; var6 < 104; ++var6) {
                              for(var7 = 0; var7 < 104; ++var7) {
                                 if((class5.tileSettings[var50][var6][var7] & 1) == 1) {
                                    var74 = var50;
                                    if((class5.tileSettings[1][var6][var7] & 2) == 2) {
                                       var74 = var50 - 1;
                                    }

                                    if(var74 >= 0) {
                                       var72[var74].method2414(var6, var7);
                                    }
                                 }
                              }
                           }
                        }

                        class5.field94 += (int)(Math.random() * 5.0D) - 2;
                        if(class5.field94 < -8) {
                           class5.field94 = -8;
                        }

                        if(class5.field94 > 8) {
                           class5.field94 = 8;
                        }

                        class5.field93 += (int)(Math.random() * 5.0D) - 2;
                        if(class5.field93 < -16) {
                           class5.field93 = -16;
                        }

                        if(class5.field93 > 16) {
                           class5.field93 = 16;
                        }

                        int var58;
                        for(var50 = 0; var50 < 4; ++var50) {
                           byte[][] var81 = class5.field81[var50];
                           var12 = (int)Math.sqrt(5100.0D);
                           var76 = 768 * var12 >> 8;

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var16 = class5.tileHeights[var50][1 + var15][var14] - class5.tileHeights[var50][var15 - 1][var14];
                                 var17 = class5.tileHeights[var50][var15][1 + var14] - class5.tileHeights[var50][var15][var14 - 1];
                                 var18 = (int)Math.sqrt((double)(var16 * var16 + 65536 + var17 * var17));
                                 var19 = (var16 << 8) / var18;
                                 var58 = 65536 / var18;
                                 var21 = (var17 << 8) / var18;
                                 var22 = (-10 * var58 + var19 * -50 + -50 * var21) / var76 + 96;
                                 var23 = (var81[var15][var14] >> 1) + (var81[var15][1 + var14] >> 3) + (var81[var15 - 1][var14] >> 2) + (var81[var15 + 1][var14] >> 3) + (var81[var15][var14 - 1] >> 2);
                                 class35.field780[var15][var14] = var22 - var23;
                              }
                           }

                           for(var14 = 0; var14 < 104; ++var14) {
                              class5.field88[var14] = 0;
                              class5.field83[var14] = 0;
                              class5.field90[var14] = 0;
                              Frames.field1832[var14] = 0;
                              class119.field2036[var14] = 0;
                           }

                           for(var14 = -5; var14 < 109; ++var14) {
                              for(var15 = 0; var15 < 104; ++var15) {
                                 var16 = var14 + 5;
                                 if(var16 >= 0 && var16 < 104) {
                                    var17 = class54.field1144[var50][var16][var15] & 255;
                                    if(var17 > 0) {
                                       class43 var82 = ChatLineBuffer.method661(var17 - 1);
                                       class5.field88[var15] += var82.field977;
                                       class5.field83[var15] += var82.field978;
                                       class5.field90[var15] += var82.field983;
                                       Frames.field1832[var15] += var82.field980;
                                       ++class119.field2036[var15];
                                    }
                                 }

                                 var17 = var14 - 5;
                                 if(var17 >= 0 && var17 < 104) {
                                    var18 = class54.field1144[var50][var17][var15] & 255;
                                    if(var18 > 0) {
                                       class43 var83 = ChatLineBuffer.method661(var18 - 1);
                                       class5.field88[var15] -= var83.field977;
                                       class5.field83[var15] -= var83.field978;
                                       class5.field90[var15] -= var83.field983;
                                       Frames.field1832[var15] -= var83.field980;
                                       --class119.field2036[var15];
                                    }
                                 }
                              }

                              if(var14 >= 1 && var14 < 103) {
                                 var15 = 0;
                                 var16 = 0;
                                 var17 = 0;
                                 var18 = 0;
                                 var19 = 0;

                                 for(var58 = -5; var58 < 109; ++var58) {
                                    var21 = 5 + var58;
                                    if(var21 >= 0 && var21 < 104) {
                                       var15 += class5.field88[var21];
                                       var16 += class5.field83[var21];
                                       var17 += class5.field90[var21];
                                       var18 += Frames.field1832[var21];
                                       var19 += class119.field2036[var21];
                                    }

                                    var22 = var58 - 5;
                                    if(var22 >= 0 && var22 < 104) {
                                       var15 -= class5.field88[var22];
                                       var16 -= class5.field83[var22];
                                       var17 -= class5.field90[var22];
                                       var18 -= Frames.field1832[var22];
                                       var19 -= class119.field2036[var22];
                                    }

                                    if(var58 >= 1 && var58 < 103 && (!field286 || (class5.tileSettings[0][var14][var58] & 2) != 0 || (class5.tileSettings[var50][var14][var58] & 16) == 0)) {
                                       if(var50 < class5.field79) {
                                          class5.field79 = var50;
                                       }

                                       var23 = class54.field1144[var50][var14][var58] & 255;
                                       var24 = class177.field2924[var50][var14][var58] & 255;
                                       if(var23 > 0 || var24 > 0) {
                                          var25 = class5.tileHeights[var50][var14][var58];
                                          var26 = class5.tileHeights[var50][var14 + 1][var58];
                                          var27 = class5.tileHeights[var50][var14 + 1][1 + var58];
                                          var28 = class5.tileHeights[var50][var14][1 + var58];
                                          var29 = class35.field780[var14][var58];
                                          var30 = class35.field780[var14 + 1][var58];
                                          int var59 = class35.field780[1 + var14][1 + var58];
                                          var32 = class35.field780[var14][1 + var58];
                                          var33 = -1;
                                          var34 = -1;
                                          int var36;
                                          int var37;
                                          int var60;
                                          if(var23 > 0) {
                                             var60 = 256 * var15 / var18;
                                             var36 = var16 / var19;
                                             var37 = var17 / var19;
                                             var33 = XItemContainer.method184(var60, var36, var37);
                                             var60 = var60 + class5.field94 & 255;
                                             var37 += class5.field93;
                                             if(var37 < 0) {
                                                var37 = 0;
                                             } else if(var37 > 255) {
                                                var37 = 255;
                                             }

                                             var34 = XItemContainer.method184(var60, var36, var37);
                                          }

                                          class48 var38;
                                          if(var50 > 0) {
                                             boolean var84 = true;
                                             if(var23 == 0 && class5.field76[var50][var14][var58] != 0) {
                                                var84 = false;
                                             }

                                             if(var24 > 0) {
                                                var37 = var24 - 1;
                                                var38 = (class48)class48.field1062.get((long)var37);
                                                class48 var61;
                                                if(null != var38) {
                                                   var61 = var38;
                                                } else {
                                                   byte[] var39 = class48.field1057.method3304(4, var37);
                                                   var38 = new class48();
                                                   if(var39 != null) {
                                                      var38.method970(new Buffer(var39), var37);
                                                   }

                                                   var38.method982();
                                                   class48.field1062.put(var38, (long)var37);
                                                   var61 = var38;
                                                }

                                                if(!var61.field1059) {
                                                   var84 = false;
                                                }
                                             }

                                             if(var84 && var25 == var26 && var25 == var27 && var28 == var25) {
                                                class32.field715[var50][var14][var58] |= 2340;
                                             }
                                          }

                                          var60 = 0;
                                          if(var34 != -1) {
                                             var60 = class94.colorPalette[class109.method2399(var34, 96)];
                                          }

                                          if(var24 == 0) {
                                             var71.method1980(var50, var14, var58, 0, 0, -1, var25, var26, var27, var28, class109.method2399(var33, var29), class109.method2399(var33, var30), class109.method2399(var33, var59), class109.method2399(var33, var32), 0, 0, 0, 0, var60, 0);
                                          } else {
                                             var36 = 1 + class5.field76[var50][var14][var58];
                                             byte var79 = class5.field80[var50][var14][var58];
                                             int var62 = var24 - 1;
                                             class48 var40 = (class48)class48.field1062.get((long)var62);
                                             if(null != var40) {
                                                var38 = var40;
                                             } else {
                                                byte[] var41 = class48.field1057.method3304(4, var62);
                                                var40 = new class48();
                                                if(var41 != null) {
                                                   var40.method970(new Buffer(var41), var62);
                                                }

                                                var40.method982();
                                                class48.field1062.put(var40, (long)var62);
                                                var38 = var40;
                                             }

                                             int var63 = var38.field1058;
                                             int var42;
                                             int var43;
                                             int var44;
                                             int var45;
                                             if(var63 >= 0) {
                                                var43 = class94.field1642.vmethod2209(var63);
                                                var42 = -1;
                                             } else if(var38.field1069 == 16711935) {
                                                var42 = -2;
                                                var63 = -1;
                                                var43 = -2;
                                             } else {
                                                var42 = XItemContainer.method184(var38.field1065, var38.field1055, var38.field1063);
                                                var44 = var38.field1065 + class5.field94 & 255;
                                                var45 = var38.field1063 + class5.field93;
                                                if(var45 < 0) {
                                                   var45 = 0;
                                                } else if(var45 > 255) {
                                                   var45 = 255;
                                                }

                                                var43 = XItemContainer.method184(var44, var38.field1055, var45);
                                             }

                                             var44 = 0;
                                             if(var43 != -2) {
                                                var44 = class94.colorPalette[class170.method3378(var43, 96)];
                                             }

                                             if(var38.field1060 != -1) {
                                                var45 = var38.field1064 + class5.field94 & 255;
                                                int var46 = class5.field93 + var38.field1066;
                                                if(var46 < 0) {
                                                   var46 = 0;
                                                } else if(var46 > 255) {
                                                   var46 = 255;
                                                }

                                                var43 = XItemContainer.method184(var45, var38.field1070, var46);
                                                var44 = class94.colorPalette[class170.method3378(var43, 96)];
                                             }

                                             var71.method1980(var50, var14, var58, var36, var79, var63, var25, var26, var27, var28, class109.method2399(var33, var29), class109.method2399(var33, var30), class109.method2399(var33, var59), class109.method2399(var33, var32), class170.method3378(var42, var29), class170.method3378(var42, var30), class170.method3378(var42, var59), class170.method3378(var42, var32), var60, var44);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 if((class5.tileSettings[var50][var15][var14] & 8) != 0) {
                                    var58 = 0;
                                 } else if(var50 > 0 && (class5.tileSettings[1][var15][var14] & 2) != 0) {
                                    var58 = var50 - 1;
                                 } else {
                                    var58 = var50;
                                 }

                                 var71.method1968(var50, var15, var14, var58);
                              }
                           }

                           class54.field1144[var50] = null;
                           class177.field2924[var50] = null;
                           class5.field76[var50] = null;
                           class5.field80[var50] = null;
                           class5.field81[var50] = null;
                        }

                        var71.method2003(-50, -10, -50);

                        for(var50 = 0; var50 < 104; ++var50) {
                           for(var6 = 0; var6 < 104; ++var6) {
                              if((class5.tileSettings[1][var50][var6] & 2) == 2) {
                                 var71.method1967(var50, var6);
                              }
                           }
                        }

                        var50 = 1;
                        var6 = 2;
                        var7 = 4;

                        for(var74 = 0; var74 < 4; ++var74) {
                           if(var74 > 0) {
                              var50 <<= 3;
                              var6 <<= 3;
                              var7 <<= 3;
                           }

                           for(var54 = 0; var54 <= var74; ++var54) {
                              for(var10 = 0; var10 <= 104; ++var10) {
                                 for(var11 = 0; var11 <= 104; ++var11) {
                                    short var78;
                                    if((class32.field715[var54][var11][var10] & var50) != 0) {
                                       var12 = var10;
                                       var76 = var10;
                                       var14 = var54;

                                       for(var15 = var54; var12 > 0 && (class32.field715[var54][var11][var12 - 1] & var50) != 0; --var12) {
                                          ;
                                       }

                                       while(var76 < 104 && (class32.field715[var54][var11][1 + var76] & var50) != 0) {
                                          ++var76;
                                       }

                                       label980:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var76; ++var16) {
                                             if((class32.field715[var14 - 1][var11][var16] & var50) == 0) {
                                                break label980;
                                             }
                                          }

                                          --var14;
                                       }

                                       label969:
                                       while(var15 < var74) {
                                          for(var16 = var12; var16 <= var76; ++var16) {
                                             if((class32.field715[1 + var15][var11][var16] & var50) == 0) {
                                                break label969;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var15 + 1 - var14) * (1 + (var76 - var12));
                                       if(var16 >= 8) {
                                          var78 = 240;
                                          var18 = class5.tileHeights[var15][var11][var12] - var78;
                                          var19 = class5.tileHeights[var14][var11][var12];
                                          Region.method2006(var74, 1, var11 * 128, 128 * var11, 128 * var12, 128 * var76 + 128, var18, var19);

                                          for(var58 = var14; var58 <= var15; ++var58) {
                                             for(var21 = var12; var21 <= var76; ++var21) {
                                                class32.field715[var58][var11][var21] &= ~var50;
                                             }
                                          }
                                       }
                                    }

                                    if((class32.field715[var54][var11][var10] & var6) != 0) {
                                       var12 = var11;
                                       var76 = var11;
                                       var14 = var54;

                                       for(var15 = var54; var12 > 0 && (class32.field715[var54][var12 - 1][var10] & var6) != 0; --var12) {
                                          ;
                                       }

                                       while(var76 < 104 && (class32.field715[var54][1 + var76][var10] & var6) != 0) {
                                          ++var76;
                                       }

                                       label1033:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var76; ++var16) {
                                             if((class32.field715[var14 - 1][var16][var10] & var6) == 0) {
                                                break label1033;
                                             }
                                          }

                                          --var14;
                                       }

                                       label1022:
                                       while(var15 < var74) {
                                          for(var16 = var12; var16 <= var76; ++var16) {
                                             if((class32.field715[1 + var15][var16][var10] & var6) == 0) {
                                                break label1022;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (1 + var15 - var14) * (var76 - var12 + 1);
                                       if(var16 >= 8) {
                                          var78 = 240;
                                          var18 = class5.tileHeights[var15][var12][var10] - var78;
                                          var19 = class5.tileHeights[var14][var12][var10];
                                          Region.method2006(var74, 2, var12 * 128, 128 + 128 * var76, 128 * var10, var10 * 128, var18, var19);

                                          for(var58 = var14; var58 <= var15; ++var58) {
                                             for(var21 = var12; var21 <= var76; ++var21) {
                                                class32.field715[var58][var21][var10] &= ~var6;
                                             }
                                          }
                                       }
                                    }

                                    if((class32.field715[var54][var11][var10] & var7) != 0) {
                                       var12 = var11;
                                       var76 = var11;
                                       var14 = var10;

                                       for(var15 = var10; var14 > 0 && (class32.field715[var54][var11][var14 - 1] & var7) != 0; --var14) {
                                          ;
                                       }

                                       while(var15 < 104 && (class32.field715[var54][var11][var15 + 1] & var7) != 0) {
                                          ++var15;
                                       }

                                       label1086:
                                       while(var12 > 0) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if((class32.field715[var54][var12 - 1][var16] & var7) == 0) {
                                                break label1086;
                                             }
                                          }

                                          --var12;
                                       }

                                       label1075:
                                       while(var76 < 104) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if((class32.field715[var54][1 + var76][var16] & var7) == 0) {
                                                break label1075;
                                             }
                                          }

                                          ++var76;
                                       }

                                       if((1 + (var76 - var12)) * (1 + (var15 - var14)) >= 4) {
                                          var16 = class5.tileHeights[var54][var12][var14];
                                          Region.method2006(var74, 4, 128 * var12, 128 * var76 + 128, 128 * var14, 128 + 128 * var15, var16, var16);

                                          for(var17 = var12; var17 <= var76; ++var17) {
                                             for(var18 = var14; var18 <= var15; ++var18) {
                                                class32.field715[var54][var17][var18] &= ~var7;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        class8.method110(true);
                        var50 = class5.field79;
                        if(var50 > XItemContainer.plane) {
                           var50 = XItemContainer.plane;
                        }

                        if(var50 < XItemContainer.plane - 1) {
                           var50 = XItemContainer.plane - 1;
                        }

                        if(field286) {
                           class9.region.method1969(class5.field79);
                        } else {
                           class9.region.method1969(0);
                        }

                        for(var6 = 0; var6 < 104; ++var6) {
                           for(var7 = 0; var7 < 104; ++var7) {
                              class23.groundItemSpawned(var6, var7);
                           }
                        }

                        class49.method1012();
                        NPCComposition.method819();
                        ObjectComposition.field924.reset();
                        if(CollisionData.field1956 != null) {
                           field397.method2768(2);
                           field397.method2521(1057001181);
                        }

                        if(!field473) {
                           var6 = (ItemLayer.field1737 - 6) / 8;
                           var7 = (ItemLayer.field1737 + 6) / 8;
                           var74 = (class4.field72 - 6) / 8;
                           var54 = (class4.field72 + 6) / 8;

                           for(var10 = var6 - 1; var10 <= 1 + var7; ++var10) {
                              for(var11 = var74 - 1; var11 <= 1 + var54; ++var11) {
                                 if(var10 < var6 || var10 > var7 || var11 < var74 || var11 > var54) {
                                    class62.field1267.method3287("m" + var10 + "_" + var11);
                                    class62.field1267.method3287("l" + var10 + "_" + var11);
                                 }
                              }
                           }
                        }

                        KitDefinition.setGameState(30);
                        class49.method1012();
                        class54.field1144 = null;
                        class177.field2924 = null;
                        class5.field76 = null;
                        class5.field80 = null;
                        class32.field715 = null;
                        class5.field81 = null;
                        class35.field780 = null;
                        class5.field88 = null;
                        class5.field83 = null;
                        class5.field90 = null;
                        Frames.field1832 = null;
                        class119.field2036 = null;
                        field397.method2768(199);
                        class54.field1148.vmethod3141();

                        for(var6 = 0; var6 < 32; ++var6) {
                           GameEngine.field2246[var6] = 0L;
                        }

                        for(var6 = 0; var6 < 32; ++var6) {
                           GameEngine.field2247[var6] = 0L;
                        }

                        Tile.field1807 = 0;
                     }
                  }
               }
            } else {
               class116.method2467(this);
            }

            if(gameState == 30) {
               class75.method1627();
            } else if(gameState == 40 || gameState == 45) {
               class160.method3194();
            }

            return;
         }

         var1.field2734.method3415(var1.field2736, (int)var1.hash, var1.field2735, false);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1927887775"
   )
   protected final void vmethod3099() {
      boolean var1 = class173.method3423();
      if(var1 && field470 && null != class0.field14) {
         class0.field14.method1224();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(field454 != 0L && class11.method139() > field454) {
            int var2 = class158.method3187();
            field454 = 0L;
            if(var2 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            class49.method1009();
            if(gameState >= 25) {
               class14.method158();
            }

            GameEngine.field2250 = true;
         } else if(GameEngine.field2253) {
            class31.method673(GameObject.canvas);
            Canvas var15 = GameObject.canvas;
            var15.removeMouseListener(class143.mouse);
            var15.removeMouseMotionListener(class143.mouse);
            var15.removeFocusListener(class143.mouse);
            class143.field2194 = 0;
            if(null != class112.field1965) {
               class112.field1965.vmethod3139(GameObject.canvas);
            }

            field442.method3033();
            GameObject.canvas.setBackground(Color.black);
            Canvas var3 = GameObject.canvas;
            var3.setFocusTraversalKeysEnabled(false);
            var3.addKeyListener(class140.keyboard);
            var3.addFocusListener(class140.keyboard);
            Canvas var4 = GameObject.canvas;
            var4.addMouseListener(class143.mouse);
            var4.addMouseMotionListener(class143.mouse);
            var4.addFocusListener(class143.mouse);
            if(class112.field1965 != null) {
               class112.field1965.vmethod3129(GameObject.canvas);
            }

            if(widgetRoot != -1) {
               class8.method109(widgetRoot, class153.field2296, class93.field1616, false);
            }

            GameEngine.field2243 = true;
         }
      }

      Dimension var33 = this.method3048();
      if(var33.width != Sequence.field1010 || var33.height != class130.field2099 || GameEngine.field2243) {
         class49.method1009();
         field454 = class11.method139() + 500L;
         GameEngine.field2243 = false;
      }

      boolean var16 = false;
      int var17;
      if(GameEngine.field2250) {
         GameEngine.field2250 = false;
         var16 = true;

         for(var17 = 0; var17 < 100; ++var17) {
            field526[var17] = true;
         }
      }

      if(var16) {
         class50.method1030();
      }

      int var9;
      int var10;
      int var18;
      if(gameState == 0) {
         var17 = class33.field741;
         String var5 = class33.field742;
         Color var6 = null;

         try {
            Graphics var7 = GameObject.canvas.getGraphics();
            if(null == Tile.field1819) {
               Tile.field1819 = new Font("Helvetica", 1, 13);
               class48.field1061 = GameObject.canvas.getFontMetrics(Tile.field1819);
            }

            if(var16) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, class153.field2296, class93.field1616);
            }

            if(null == var6) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(null == class20.field573) {
                  class20.field573 = GameObject.canvas.createImage(304, 34);
               }

               Graphics var8 = class20.field573.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, var17 * 3, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(2 + 3 * var17, 2, 300 - 3 * var17, 30);
               var8.setFont(Tile.field1819);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - class48.field1061.stringWidth(var5)) / 2, 22);
               var7.drawImage(class20.field573, class153.field2296 / 2 - 152, class93.field1616 / 2 - 18, (ImageObserver)null);
            } catch (Exception var23) {
               var9 = class153.field2296 / 2 - 152;
               var10 = class93.field1616 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(var9 + 2, var10 + 2, var17 * 3, 30);
               var7.setColor(Color.black);
               var7.drawRect(1 + var9, var10 + 1, 301, 31);
               var7.fillRect(var17 * 3 + 2 + var9, var10 + 2, 300 - 3 * var17, 30);
               var7.setFont(Tile.field1819);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - class48.field1061.stringWidth(var5)) / 2, var10 + 22);
            }
         } catch (Exception var24) {
            GameObject.canvas.repaint();
         }
      } else if(gameState == 5) {
         class145.method3008(class79.field1434, XItemContainer.field225, class112.field1962, var16);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class145.method3008(class79.field1434, XItemContainer.field225, class112.field1962, var16);
         } else if(gameState == 25) {
            if(field561 == 1) {
               if(field337 > field338) {
                  field338 = field337;
               }

               var17 = (field338 * 50 - field337 * 50) / field338;
               class12.method145("Loading - please wait." + "<br>" + " (" + var17 + "%" + ")", false);
            } else if(field561 == 2) {
               if(field339 > field340) {
                  field340 = field339;
               }

               var17 = (field340 * 50 - field339 * 50) / field340 + 50;
               class12.method145("Loading - please wait." + "<br>" + " (" + var17 + "%" + ")", false);
            } else {
               class12.method145("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            if(widgetRoot != -1) {
               var17 = widgetRoot;
               if(class171.method3404(var17)) {
                  Player.method20(Widget.widgets[var17], -1);
               }
            }

            for(var17 = 0; var17 < field482; ++var17) {
               if(field526[var17]) {
                  field485[var17] = true;
               }

               field486[var17] = field526[var17];
               field526[var17] = false;
            }

            field483 = gameCycle;
            field428 = -1;
            field500 = -1;
            NPC.field787 = null;
            int var19;
            int var20;
            if(widgetRoot != -1) {
               field482 = 0;
               var17 = widgetRoot;
               var18 = class153.field2296;
               var19 = class93.field1616;
               if(!class171.method3404(var17)) {
                  for(var20 = 0; var20 < 100; ++var20) {
                     field526[var20] = true;
                  }
               } else {
                  class9.field158 = null;
                  class31.gameDraw(Widget.widgets[var17], -1, 0, 0, var18, var19, 0, 0, -1);
                  if(class9.field158 != null) {
                     class31.gameDraw(class9.field158, -1412584499, 0, 0, var18, var19, ChatMessages.field272, class125.field2077, -1);
                     class9.field158 = null;
                  }
               }
            }

            class82.method1839();
            if(!isMenuOpen) {
               if(field428 != -1) {
                  var17 = field428;
                  var18 = field500;
                  if(menuOptionCount >= 2 || field432 != 0 || field434) {
                     String var28;
                     if(field432 == 1 && menuOptionCount < 2) {
                        var28 = "Use" + " " + field433 + " " + "->";
                     } else if(field434 && menuOptionCount < 2) {
                        var28 = field492 + " " + field438 + " " + "->";
                     } else {
                        int var21 = menuOptionCount - 1;
                        String var29;
                        if(menuTargets[var21].length() > 0) {
                           var29 = menuOptions[var21] + " " + menuTargets[var21];
                        } else {
                           var29 = menuOptions[var21];
                        }

                        var28 = var29;
                     }

                     if(menuOptionCount > 2) {
                        var28 = var28 + class92.method2126(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
                     }

                     class79.field1434.method4127(var28, var17 + 4, var18 + 15, 16777215, 0, gameCycle / 1000);
                  }
               }
            } else {
               Renderable.method1961();
            }

            if(field307 == 3) {
               for(var17 = 0; var17 < field482; ++var17) {
                  if(field486[var17]) {
                     class82.method1845(widgetPositionX[var17], widgetPositionY[var17], widgetBoundsWidth[var17], widgetBoundsHeight[var17], 16711935, 128);
                  } else if(field485[var17]) {
                     class82.method1845(widgetPositionX[var17], widgetPositionY[var17], widgetBoundsWidth[var17], widgetBoundsHeight[var17], 16711680, 128);
                  }
               }
            }

            var17 = XItemContainer.plane;
            var18 = class34.localPlayer.x;
            var19 = class34.localPlayer.y;
            var20 = field358;

            for(class24 var30 = (class24)class24.field626.method3890(); var30 != null; var30 = (class24)class24.field626.method3892()) {
               if(var30.field618 != -1 || var30.field622 != null) {
                  var9 = 0;
                  if(var18 > var30.field615) {
                     var9 += var18 - var30.field615;
                  } else if(var18 < var30.field613) {
                     var9 += var30.field613 - var18;
                  }

                  if(var19 > var30.field616) {
                     var9 += var19 - var30.field616;
                  } else if(var19 < var30.field614) {
                     var9 += var30.field614 - var19;
                  }

                  if(var9 - 64 <= var30.field617 && field520 != 0 && var17 == var30.field627) {
                     var9 -= 64;
                     if(var9 < 0) {
                        var9 = 0;
                     }

                     var10 = field520 * (var30.field617 - var9) / var30.field617;
                     Object var10000;
                     if(var30.field619 == null) {
                        if(var30.field618 >= 0) {
                           var10000 = null;
                           class61 var11 = class61.method1299(class5.field77, var30.field618, 0);
                           if(var11 != null) {
                              class65 var12 = var11.method1288().method1331(class59.field1234);
                              class67 var13 = class67.method1355(var12, 100, var10);
                              var13.method1384(-1);
                              WidgetNode.field59.method1184(var13);
                              var30.field619 = var13;
                           }
                        }
                     } else {
                        var30.field619.method1424(var10);
                     }

                     if(var30.field624 == null) {
                        if(var30.field622 != null && (var30.field611 -= var20) <= 0) {
                           int var22 = (int)(Math.random() * (double)var30.field622.length);
                           var10000 = null;
                           class61 var31 = class61.method1299(class5.field77, var30.field622[var22], 0);
                           if(null != var31) {
                              class65 var32 = var31.method1288().method1331(class59.field1234);
                              class67 var14 = class67.method1355(var32, 100, var10);
                              var14.method1384(0);
                              WidgetNode.field59.method1184(var14);
                              var30.field624 = var14;
                              var30.field611 = var30.field628 + (int)(Math.random() * (double)(var30.field620 - var30.field628));
                           }
                        }
                     } else {
                        var30.field624.method1424(var10);
                        if(!var30.field624.linked()) {
                           var30.field624 = null;
                        }
                     }
                  } else {
                     if(var30.field619 != null) {
                        WidgetNode.field59.method1173(var30.field619);
                        var30.field619 = null;
                     }

                     if(var30.field624 != null) {
                        WidgetNode.field59.method1173(var30.field624);
                        var30.field624 = null;
                     }
                  }
               }
            }

            field358 = 0;
         } else if(gameState == 40) {
            class12.method145("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class12.method145("Please wait...", false);
         }
      } else {
         class145.method3008(class79.field1434, XItemContainer.field225, class112.field1962, var16);
      }

      Graphics var27;
      if(gameState == 30 && field307 == 0 && !var16) {
         try {
            var27 = GameObject.canvas.getGraphics();

            for(var18 = 0; var18 < field482; ++var18) {
               if(field485[var18]) {
                  XClanMember.bufferProvider.drawSub(var27, widgetPositionX[var18], widgetPositionY[var18], widgetBoundsWidth[var18], widgetBoundsHeight[var18]);
                  field485[var18] = false;
               }
            }
         } catch (Exception var26) {
            GameObject.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var27 = GameObject.canvas.getGraphics();
            XClanMember.bufferProvider.draw(var27, 0, 0);

            for(var18 = 0; var18 < field482; ++var18) {
               field485[var18] = false;
            }
         } catch (Exception var25) {
            GameObject.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "69"
   )
   void method461(int var1) {
      class140.field2166 = null;
      class188.field3045 = null;
      field309 = 0;
      if(class114.field2013 == class28.field673) {
         class114.field2013 = class35.field781;
      } else {
         class114.field2013 = class28.field673;
      }

      ++field315;
      if(field315 < 2 || var1 != 7 && var1 != 9) {
         if(field315 >= 2 && var1 == 6) {
            this.method3046("js5connect_outofdate");
            gameState = 1000;
         } else if(field315 >= 4) {
            if(gameState <= 5) {
               this.method3046("js5connect");
               gameState = 1000;
            } else {
               field310 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method3046("js5connect_full");
         gameState = 1000;
      } else {
         field310 = 3000;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1000163604"
   )
   protected final void vmethod3049() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method526() {
      if(gameState != 1000) {
         long var2 = class11.method139();
         int var4 = (int)(var2 - class174.field2750);
         class174.field2750 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class174.field2749 += var4;
         boolean var1;
         if(class174.field2757 == 0 && class174.field2754 == 0 && class174.field2769 == 0 && class174.field2748 == 0) {
            var1 = true;
         } else if(null == class174.field2755) {
            var1 = false;
         } else {
            try {
               label240: {
                  if(class174.field2749 > 30000) {
                     throw new IOException();
                  }

                  class175 var5;
                  Buffer var6;
                  while(class174.field2754 < 20 && class174.field2748 > 0) {
                     var5 = (class175)class174.field2751.method3852();
                     var6 = new Buffer(4);
                     var6.method2518(1);
                     var6.method2520((int)var5.hash);
                     class174.field2755.method3009(var6.payload, 0, 4);
                     class174.field2753.method3850(var5, var5.hash);
                     --class174.field2748;
                     ++class174.field2754;
                  }

                  while(class174.field2757 < 20 && class174.field2769 > 0) {
                     var5 = (class175)class174.field2758.method3957();
                     var6 = new Buffer(4);
                     var6.method2518(0);
                     var6.method2520((int)var5.hash);
                     class174.field2755.method3009(var6.payload, 0, 4);
                     var5.method3968();
                     class174.field2760.method3850(var5, var5.hash);
                     --class174.field2769;
                     ++class174.field2757;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class174.field2755.method3013();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class174.field2749 = 0;
                     byte var7 = 0;
                     if(null == class5.field95) {
                        var7 = 8;
                     } else if(class174.field2762 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class174.field2770.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class174.field2755.method3014(class174.field2770.payload, class174.field2770.offset, var8);
                        if(class174.field2764 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class174.field2770.payload[var9 + class174.field2770.offset] ^= class174.field2764;
                           }
                        }

                        class174.field2770.offset += var8;
                        if(class174.field2770.offset < var7) {
                           break;
                        }

                        if(null == class5.field95) {
                           class174.field2770.offset = 0;
                           var9 = class174.field2770.method2656();
                           var10 = class174.field2770.method2535();
                           int var11 = class174.field2770.method2656();
                           var12 = class174.field2770.method2538();
                           long var13 = (long)(var10 + (var9 << 16));
                           class175 var15 = (class175)class174.field2753.method3849(var13);
                           class35.field782 = true;
                           if(var15 == null) {
                              var15 = (class175)class174.field2760.method3849(var13);
                              class35.field782 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class5.field95 = var15;
                           class32.field707 = new Buffer(class5.field95.field2775 + var16 + var12);
                           class32.field707.method2518(var11);
                           class32.field707.method2521(var12);
                           class174.field2762 = 8;
                           class174.field2770.offset = 0;
                        } else if(class174.field2762 == 0) {
                           if(class174.field2770.payload[0] == -1) {
                              class174.field2762 = 1;
                              class174.field2770.offset = 0;
                           } else {
                              class5.field95 = null;
                           }
                        }
                     } else {
                        var8 = class32.field707.payload.length - class5.field95.field2775;
                        var9 = 512 - class174.field2762;
                        if(var9 > var8 - class32.field707.offset) {
                           var9 = var8 - class32.field707.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class174.field2755.method3014(class32.field707.payload, class32.field707.offset, var9);
                        if(class174.field2764 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class32.field707.payload[var10 + class32.field707.offset] ^= class174.field2764;
                           }
                        }

                        class32.field707.offset += var9;
                        class174.field2762 += var9;
                        if(class32.field707.offset == var8) {
                           if(16711935L == class5.field95.hash) {
                              class166.field2686 = class32.field707;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class171 var19 = class174.field2752[var10];
                                 if(null != var19) {
                                    class166.field2686.offset = 5 + var10 * 8;
                                    var12 = class166.field2686.method2538();
                                    int var23 = class166.field2686.method2538();
                                    var19.method3383(var12, var23);
                                 }
                              }
                           } else {
                              class174.field2759.reset();
                              class174.field2759.update(class32.field707.payload, 0, var8);
                              var10 = (int)class174.field2759.getValue();
                              if(var10 != class5.field95.field2774) {
                                 try {
                                    class174.field2755.method3010();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class174.field2765;
                                 class174.field2755 = null;
                                 class174.field2764 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label240;
                              }

                              class174.field2765 = 0;
                              class174.field2766 = 0;
                              class5.field95.field2776.method3384((int)(class5.field95.hash & 65535L), class32.field707.payload, (class5.field95.hash & 16711680L) == 16711680L, class35.field782);
                           }

                           class5.field95.unlink();
                           if(class35.field782) {
                              --class174.field2754;
                           } else {
                              --class174.field2757;
                           }

                           class174.field2762 = 0;
                           class5.field95 = null;
                           class32.field707 = null;
                        } else {
                           if(class174.field2762 != 512) {
                              break;
                           }

                           class174.field2762 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class174.field2755.method3010();
               } catch (Exception var20) {
                  ;
               }

               ++class174.field2766;
               class174.field2755 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method240();
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "-104"
   )
   public static String method556(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(1 + var7 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(1 + var7 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(27 + var7 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var3 % 37L && 0L != var3) {
         var3 /= 37L;
      }

      String var8 = class93.method2128(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "9610720"
   )
   public static boolean method557(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
