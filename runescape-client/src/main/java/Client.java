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
   @ObfuscatedName("jg")
   static boolean field278;
   @ObfuscatedName("c")
   static Client field279;
   @ObfuscatedName("n")
   static boolean field280 = true;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1816947923
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("fx")
   static boolean field282;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1924016183
   )
   static int field283 = 0;
   @ObfuscatedName("v")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("g")
   static boolean field285 = false;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1956331919
   )
   static int field286 = 0;
   @ObfuscatedName("k")
   static String field287;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 866888665
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("a")
   static boolean field289 = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1396766197
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -406057445
   )
   static int field292;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -1324253143
   )
   static int field293;
   @ObfuscatedName("mx")
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("ax")
   static boolean field295 = true;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      longValue = -5668015000734699877L
   )
   static long field296;
   @ObfuscatedName("bd")
   static byte[] field297;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 359047565
   )
   static int field298 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -783659701
   )
   static int field299 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -359221685
   )
   static int field300 = 0;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1926662735
   )
   static int field301 = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 806008629
   )
   static int field302 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1614107269
   )
   static int field303 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -326035417
   )
   static int field304 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1594135925
   )
   static int field305 = 0;
   @ObfuscatedName("af")
   static class40 field306;
   @ObfuscatedName("ar")
   static class40 field307;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -611034957
   )
   static int field308;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 2107636007
   )
   static int field309;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 1445330509
   )
   static int field310;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -1823287213
   )
   static int field311;
   @ObfuscatedName("by")
   static IndexData field312;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1529683861
   )
   static int field313;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1630028329
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 343206235
   )
   static int field315;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -65196489
   )
   static int field316;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1322036975
   )
   static int field317;
   @ObfuscatedName("oa")
   static short field318;
   @ObfuscatedName("ou")
   static short field320;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1415717891
   )
   static int field321;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -234105351
   )
   static int field322;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -614910889
   )
   static int field323;
   @ObfuscatedName("cu")
   static int[] field324;
   @ObfuscatedName("cy")
   @Export("egressBuffer")
   static PacketBuffer egressBuffer;
   @ObfuscatedName("cl")
   @Export("loginBuffer")
   static PacketBuffer loginBuffer;
   @ObfuscatedName("cg")
   @Export("ingressBuffer")
   static PacketBuffer ingressBuffer;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1452082135
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1106741671
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -224404139
   )
   static int field330;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -776395173
   )
   static int field331;
   @ObfuscatedName("mj")
   static byte field332;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -424401177
   )
   static int field333;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 1220137595
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("gd")
   static String[] field335;
   @ObfuscatedName("ca")
   static boolean field336;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 724709517
   )
   static int field337;
   @ObfuscatedName("iv")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("ad")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -1582589111
   )
   static int field340;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 407929937
   )
   static int field341;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("de")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("dn")
   static int[][][] field344;
   @ObfuscatedName("dm")
   static final int[] field345;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 1840964505
   )
   static int field346;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -379197301
   )
   static int field347;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -597011145
   )
   static int field348;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -365062925
   )
   static int field349;
   @ObfuscatedName("cf")
   static int[] field350;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -216886261
   )
   static int field351;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 259946761
   )
   static int field352;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 234149063
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 486702655
   )
   @Export("mapOffset")
   static int mapOffset;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 1887626479
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 1539462957
   )
   static int field356;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 1574871593
   )
   static int field357;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -893993819
   )
   static int field358;
   @ObfuscatedName("ep")
   static SpritePixels field359;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 1933993985
   )
   static int field360;
   @ObfuscatedName("ly")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 1147286187
   )
   static int field362;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -2045064857
   )
   static int field363;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -784687181
   )
   static int field364;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -2000264509
   )
   static int field365;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -506391229
   )
   static int field366;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1271017521
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("le")
   static boolean[] field368;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -2011512197
   )
   static int field369;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -1386264559
   )
   static int field370;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1838596109
   )
   static int field371;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 590822485
   )
   static int field372;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = -1497174155
   )
   static int field373;
   @ObfuscatedName("fn")
   static boolean field374;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 707036665
   )
   static int field375;
   @ObfuscatedName("jx")
   static boolean field376;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -618156227
   )
   static int field377;
   @ObfuscatedName("fo")
   static int[] field378;
   @ObfuscatedName("ff")
   static int[] field379;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 1415203181
   )
   static int field380;
   @ObfuscatedName("fy")
   static int[] field381;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -1547018247
   )
   static int field382;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -475975155
   )
   static int field383;
   @ObfuscatedName("ge")
   static int[] field384;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = -501169
   )
   static int field385;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1641179633
   )
   static int field386;
   @ObfuscatedName("iq")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 77095409
   )
   static int field388;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -592846245
   )
   static int field389;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 1942954045
   )
   static int field391;
   @ObfuscatedName("jm")
   static String field392;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1634269283
   )
   static int field393;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -218678325
   )
   static int field394;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1968491523
   )
   static int field395;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1313084945
   )
   static int field396;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -2039421023
   )
   static int field397;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 43237905
   )
   static int field398;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -2002357677
   )
   static int field399;
   @ObfuscatedName("gy")
   static boolean field400;
   @ObfuscatedName("on")
   static int[] field401;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1830716705
   )
   static int field402;
   @ObfuscatedName("gg")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -165065255
   )
   static int field404;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 3937000523909092665L
   )
   static long field405 = -1L;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 93724565
   )
   static int field406;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -287289913
   )
   static int field407;
   @ObfuscatedName("hq")
   static int[] field408;
   @ObfuscatedName("ht")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("hh")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("hz")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("hl")
   static int[] field412;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -1043335821
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("hj")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("he")
   static Deque field415;
   @ObfuscatedName("hx")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1634346213
   )
   static int field417;
   @ObfuscatedName("hc")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("hs")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("hk")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -371292195
   )
   static int field421;
   @ObfuscatedName("hi")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -627183775
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("ie")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 1819841445
   )
   static int field425;
   @ObfuscatedName("io")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("lc")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -1199895255
   )
   static int field428;
   @ObfuscatedName("iu")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("ig")
   static boolean field430;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 896019419
   )
   static int field431;
   @ObfuscatedName("ih")
   static boolean field432;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 109818391
   )
   static int field433;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 527949403
   )
   static int field434;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1318334875
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1213795697
   )
   static int field436;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -986943115
   )
   static int field437;
   @ObfuscatedName("jo")
   static String field438;
   @ObfuscatedName("ix")
   static String field439;
   @ObfuscatedName("ip")
   static boolean field440;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = -28368023
   )
   static int field441;
   @ObfuscatedName("nq")
   static int[] field442;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 689654771
   )
   static int field443;
   @ObfuscatedName("mk")
   static int[] field444;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 925646415
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ja")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 1486619903
   )
   static int field447;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 451919399
   )
   static int field448;
   @ObfuscatedName("jq")
   static Widget field449;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -998150623
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 1041892549
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("lq")
   static boolean[] field452;
   @ObfuscatedName("kk")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("ps")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("jr")
   static boolean field455;
   @ObfuscatedName("jp")
   static boolean field456;
   @ObfuscatedName("jv")
   static Widget field457;
   @ObfuscatedName("ju")
   static Widget field458;
   @ObfuscatedName("ob")
   static short field459;
   @ObfuscatedName("li")
   static String field460;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -1711375345
   )
   static int field461;
   @ObfuscatedName("jw")
   static Widget field462;
   @ObfuscatedName("jn")
   static boolean field463;
   @ObfuscatedName("pz")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 433810653
   )
   static int field465;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 274222149
   )
   static int field466;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 1804514319
   )
   static int field467;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -1389462083
   )
   static int field468;
   @ObfuscatedName("kq")
   static boolean field469;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 1294125793
   )
   static int field470;
   @ObfuscatedName("kl")
   static int[] field471;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -1733842663
   )
   static int field472;
   @ObfuscatedName("fl")
   static int[] field473;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 184546131
   )
   static int field474;
   @ObfuscatedName("ka")
   static int[] field475;
   @ObfuscatedName("ko")
   static Deque field476;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 850950447
   )
   static int field477;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 253802407
   )
   static int field478;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1879562405
   )
   static int field479;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -629797903
   )
   static int field480;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 356507531
   )
   static int field481;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -601626219
   )
   static int field482;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 2100509231
   )
   static int field483;
   @ObfuscatedName("kt")
   static Deque field484;
   @ObfuscatedName("mb")
   static String field485;
   @ObfuscatedName("ld")
   static Deque field486;
   @ObfuscatedName("ib")
   static class38 field487;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -1714115537
   )
   static int field488;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -365609411
   )
   static int field489;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = 1352642749
   )
   static int field490;
   @ObfuscatedName("lo")
   static boolean[] field491;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -2113425187
   )
   static int field492;
   @ObfuscatedName("np")
   static int[] field493;
   @ObfuscatedName("lf")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1171060333
   )
   static int field495 = 0;
   @ObfuscatedName("jt")
   static Widget field496;
   @ObfuscatedName("gk")
   static int[][] field497;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1876333521
   )
   static int field498 = -1;
   @ObfuscatedName("lz")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("oi")
   static short field500;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -814248997
   )
   static int field501;
   @ObfuscatedName("ll")
   static int[] field502;
   @ObfuscatedName("gj")
   static int[] field503;
   @ObfuscatedName("nh")
   static SoundEffect[] field504;
   @ObfuscatedName("mm")
   static int[] field505;
   @ObfuscatedName("ml")
   static long[] field506;
   @ObfuscatedName("fw")
   static int[] field507;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 1535629211
   )
   static int field508;
   @ObfuscatedName("oz")
   static short field509;
   @ObfuscatedName("mi")
   static int[] field510;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      longValue = -4631926127166022295L
   )
   static long field511;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -378887547
   )
   static int field512;
   @ObfuscatedName("mr")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = -1387025351
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 160187433
   )
   static int field515;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -2110325813
   )
   static int field516;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 796030611
   )
   static int field517;
   @ObfuscatedName("mo")
   static int[] field518;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2030936517
   )
   static int field519 = -1;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = -1458248867
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -1920630505
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -891866847
   )
   static int field522;
   @ObfuscatedName("id")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 1416375469
   )
   static int field524;
   @ObfuscatedName("nw")
   static boolean field525;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 303332151
   )
   static int field526;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -1771620161
   )
   static int field527;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -170207829
   )
   static int field528;
   @ObfuscatedName("nr")
   static int[] field529;
   @ObfuscatedName("nb")
   static int[] field530;
   @ObfuscatedName("hv")
   static Deque field531;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 1603146097
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("cm")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("nx")
   static boolean field534;
   @ObfuscatedName("og")
   static boolean[] field535;
   @ObfuscatedName("or")
   static int[] field536;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -1404797723
   )
   static int field537;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1531484421
   )
   static int field538;
   @ObfuscatedName("om")
   static int[] field539;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1533688429
   )
   static int field540;
   @ObfuscatedName("ow")
   static short field541;
   @ObfuscatedName("ok")
   static short field542;
   @ObfuscatedName("lm")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 207933801
   )
   static int field544;
   @ObfuscatedName("ov")
   static int[] field545;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 242968703
   )
   static int field546;
   @ObfuscatedName("oe")
   static short field547;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 2026937331
   )
   static int field548;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 183480007
   )
   static int field549;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -777721841
   )
   static int field550;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -999749057
   )
   static int field551;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -1889770523
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 2051367089
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 1653389485
   )
   static int field554;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 95200599
   )
   static int field555 = -1;
   @ObfuscatedName("pw")
   static class151 field556;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -776811613
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("ac")
   static boolean field558 = false;
   @ObfuscatedName("px")
   static PlayerComposition field559;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 2027299005
   )
   static int field560;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = 2072597773
   )
   static int field561;
   @ObfuscatedName("pk")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      longValue = -8889369907692927465L
   )
   static long field563;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      longValue = -3261680325837317629L
   )
   static long field564;
   @ObfuscatedName("ph")
   static final class22 field565;
   @ObfuscatedName("pg")
   static int[] field566;
   @ObfuscatedName("pt")
   static int[] field567;
   @ObfuscatedName("lp")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ap")
   static SpritePixels[] field569;
   @ObfuscatedName("mq")
   static SpritePixels[] field570;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1854662748"
   )
   protected final void vmethod2132() {
   }

   public final void init() {
      if(this.method2151()) {
         class218[] var1 = new class218[]{class218.field3181, class218.field3187, class218.field3189, class218.field3184, class218.field3194, class218.field3192, class218.field3183, class218.field3182, class218.field3195, class218.field3191, class218.field3190, class218.field3186, class218.field3188, class218.field3185, class218.field3180};
         class218[] var2 = var1;

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class218 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3193);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3193)) {
               case 1:
                  flags = Integer.parseInt(var5);
                  break;
               case 2:
                  class10.field97 = Integer.parseInt(var5);
                  break;
               case 3:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 4:
                  Game[] var6 = new Game[]{Game.field2688, Game.field2682, Game.field2683, Game.field2694, Game.field2681, Game.field2684};
                  class188.field2778 = (Game)class32.method708(var6, Integer.parseInt(var5));
                  if(Game.field2694 == class188.field2778) {
                     NPC.field757 = class232.field3276;
                  } else {
                     NPC.field757 = class232.field3274;
                  }
               case 5:
               case 10:
               case 13:
               default:
                  break;
               case 6:
                  class108.field1728 = class85.method1714(Integer.parseInt(var5));
                  break;
               case 7:
                  class7.field64 = var5;
                  break;
               case 8:
                  world = Integer.parseInt(var5);
                  break;
               case 9:
                  field283 = Integer.parseInt(var5);
                  break;
               case 11:
                  class10.field106 = Integer.parseInt(var5);
                  break;
               case 12:
                  field286 = Integer.parseInt(var5);
                  break;
               case 14:
                  field287 = var5;
                  break;
               case 15:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
               }
            }
         }

         class138.method2675();
         Script.host = this.getCodeBase().getHost();
         String var18 = class108.field1728.field2676;
         byte var8 = 0;

         try {
            class104.field1677 = 16;
            class16.field176 = var8;

            try {
               class3.field34 = System.getProperty("os.name");
            } catch (Exception var15) {
               class3.field34 = "Unknown";
            }

            Frames.field1553 = class3.field34.toLowerCase();

            try {
               class20.field216 = System.getProperty("user.home");
               if(class20.field216 != null) {
                  class20.field216 = class20.field216 + "/";
               }
            } catch (Exception var14) {
               ;
            }

            try {
               if(Frames.field1553.startsWith("win")) {
                  if(class20.field216 == null) {
                     class20.field216 = System.getenv("USERPROFILE");
                  }
               } else if(class20.field216 == null) {
                  class20.field216 = System.getenv("HOME");
               }

               if(class20.field216 != null) {
                  class20.field216 = class20.field216 + "/";
               }
            } catch (Exception var13) {
               ;
            }

            if(class20.field216 == null) {
               class20.field216 = "~/";
            }

            class104.field1678 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class20.field216, "/tmp/", ""};
            class190.field2792 = new String[]{".jagex_cache_" + class16.field176, ".file_store_" + class16.field176};

            label154:
            for(var3 = 0; var3 < 4; ++var3) {
               class104.field1676 = IndexData.method3410("oldschool", var18, var3);
               if(!class104.field1676.exists()) {
                  class104.field1676.mkdirs();
               }

               File[] var19 = class104.field1676.listFiles();
               if(var19 == null) {
                  break;
               }

               File[] var21 = var19;
               int var10 = 0;

               while(true) {
                  if(var10 >= var21.length) {
                     break label154;
                  }

                  File var7 = var21[var10];
                  if(!Preferences.method642(var7, false)) {
                     break;
                  }

                  ++var10;
               }
            }

            class200.method3639(class104.field1676);

            try {
               File var9 = new File(class20.field216, "random.dat");
               int var12;
               if(var9.exists()) {
                  class104.field1679 = new class72(new FileOnDisk(var9, "rw", 25L), 24, 0);
               } else {
                  label134:
                  for(int var11 = 0; var11 < class190.field2792.length; ++var11) {
                     for(var12 = 0; var12 < class104.field1678.length; ++var12) {
                        File var22 = new File(class104.field1678[var12] + class190.field2792[var11] + File.separatorChar + "random.dat");
                        if(var22.exists()) {
                           class104.field1679 = new class72(new FileOnDisk(var22, "rw", 25L), 24, 0);
                           break label134;
                        }
                     }
                  }
               }

               if(class104.field1679 == null) {
                  RandomAccessFile var20 = new RandomAccessFile(var9, "rw");
                  var12 = var20.read();
                  var20.seek(0L);
                  var20.write(var12);
                  var20.seek(0L);
                  var20.close();
                  class104.field1679 = new class72(new FileOnDisk(var9, "rw", 25L), 24, 0);
               }
            } catch (IOException var16) {
               ;
            }

            class104.field1680 = new class72(new FileOnDisk(WidgetNode.method197("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class104.field1681 = new class72(new FileOnDisk(WidgetNode.method197("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class104.field1683 = new class72[class104.field1677];

            for(var3 = 0; var3 < class104.field1677; ++var3) {
               class104.field1683[var3] = new class72(new FileOnDisk(WidgetNode.method197("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var17) {
            class173.method3259((String)null, var17);
         }

         field279 = this;
         this.method2116(765, 503, 140);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "189"
   )
   protected final void vmethod2125() {
      class18.field194 = field283 == 0?'ꩊ':world + '鱀';
      RSSocket.field1747 = field283 == 0?443:world + '썐';
      class109.field1736 = class18.field194;
      Friend.field155 = class169.field2193;
      class112.field1761 = class169.field2190;
      class114.field1794 = class169.field2191;
      PlayerComposition.field2183 = class169.field2192;
      class38.method771();
      class20.method214(class65.canvas);
      Canvas var1 = class65.canvas;
      var1.addMouseListener(class115.mouse);
      var1.addMouseMotionListener(class115.mouse);
      var1.addFocusListener(class115.mouse);

      class106 var2;
      try {
         var2 = new class106();
      } catch (Throwable var10) {
         var2 = null;
      }

      FloorUnderlayDefinition.field2828 = var2;
      if(FloorUnderlayDefinition.field2828 != null) {
         FloorUnderlayDefinition.field2828.vmethod2102(class65.canvas);
      }

      ChatMessages.field919 = new IndexFile(255, class104.field1680, class104.field1681, 500000);
      FileOnDisk var4 = null;
      Preferences var5 = new Preferences();

      try {
         var4 = class59.getPreferencesFile("", class188.field2778.name, false);
         byte[] var6 = new byte[(int)var4.method1438()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.method1427(var6, var7, var6.length - var7);
            if(var8 == -1) {
               throw new IOException();
            }
         }

         var5 = new Preferences(new Buffer(var6));
      } catch (Exception var11) {
         ;
      }

      try {
         if(var4 != null) {
            var4.method1425();
         }
      } catch (Exception var9) {
         ;
      }

      Actor.field656 = var5;
      class3.field28 = this.getToolkit().getSystemClipboard();
      Projectile.method817(this, class108.field1730);
      if(field283 != 0) {
         field558 = true;
      }

      ItemComposition.method3798(Actor.field656.field692);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1115395829"
   )
   void method262() {
      if(class187.field2769 >= 4) {
         this.method2129("js5crc");
         gameState = 1000;
      } else {
         if(class187.field2770 >= 4) {
            if(gameState <= 5) {
               this.method2129("js5io");
               gameState = 1000;
               return;
            }

            field386 = 3000;
            class187.field2770 = 3;
         }

         if(--field386 + 1 <= 0) {
            try {
               if(field396 == 0) {
                  Friend.field156 = class45.field896.method1975(Script.host, class109.field1736);
                  ++field396;
               }

               if(field396 == 1) {
                  if(Friend.field156.field1653 == 2) {
                     this.method370(-1);
                     return;
                  }

                  if(Friend.field156.field1653 == 1) {
                     ++field396;
                  }
               }

               if(field396 == 2) {
                  rssocket = new RSSocket((Socket)Friend.field156.field1657, class45.field896);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(140);
                  rssocket.queueForWrite(var1.payload, 0, 5);
                  ++field396;
                  class196.field2864 = class72.method1421();
               }

               if(field396 == 3) {
                  if(gameState > 5 && rssocket.available() <= 0) {
                     if(class72.method1421() - class196.field2864 > 30000L) {
                        this.method370(-2);
                        return;
                     }
                  } else {
                     int var2 = rssocket.readByte();
                     if(var2 != 0) {
                        this.method370(var2);
                        return;
                     }

                     ++field396;
                  }
               }

               if(field396 == 4) {
                  class59.method1141(rssocket, gameState > 20);
                  Friend.field156 = null;
                  rssocket = null;
                  field396 = 0;
                  field313 = 0;
               }
            } catch (IOException var3) {
               this.method370(-3);
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-4555"
   )
   protected final void vmethod2128() {
      if(XClanMember.chatMessages.method866()) {
         XClanMember.chatMessages.method863();
      }

      if(class180.field2678 != null) {
         class180.field2678.field219 = false;
      }

      class180.field2678 = null;
      if(Friend.rssocket != null) {
         Friend.rssocket.method2093();
         Friend.rssocket = null;
      }

      class104.method2001();
      if(class115.mouse != null) {
         class115 var1 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

      FloorUnderlayDefinition.field2828 = null;
      if(class8.field70 != null) {
         class8.field70.method1069();
      }

      if(class6.field56 != null) {
         class6.field56.method1069();
      }

      if(class187.field2759 != null) {
         class187.field2759.method2093();
      }

      CombatInfoListHolder.method731();
      Script.method912();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-553630013"
   )
   void method328() {
      if(gameState != 1000) {
         long var2 = class72.method1421();
         int var4 = (int)(var2 - class187.field2753);
         class187.field2753 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class187.field2752 += var4;
         boolean var1;
         if(class187.field2762 == 0 && class187.field2768 == 0 && class187.field2767 == 0 && class187.field2755 == 0) {
            var1 = true;
         } else if(class187.field2759 == null) {
            var1 = false;
         } else {
            try {
               label241: {
                  if(class187.field2752 > 30000) {
                     throw new IOException();
                  }

                  class183 var5;
                  Buffer var6;
                  while(class187.field2768 < 20 && class187.field2755 > 0) {
                     var5 = (class183)class187.field2772.method2776();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class187.field2759.queueForWrite(var6.payload, 0, 4);
                     class187.field2756.method2774(var5, var5.hash);
                     --class187.field2755;
                     ++class187.field2768;
                  }

                  while(class187.field2762 < 20 && class187.field2767 > 0) {
                     var5 = (class183)class187.field2758.method2716();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class187.field2759.queueForWrite(var6.payload, 0, 4);
                     var5.method2851();
                     class187.field2761.method2774(var5, var5.hash);
                     --class187.field2767;
                     ++class187.field2762;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class187.field2759.available();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class187.field2752 = 0;
                     byte var7 = 0;
                     if(class199.field2881 == null) {
                        var7 = 8;
                     } else if(class187.field2765 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class187.field2763.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class187.field2759.read(class187.field2763.payload, class187.field2763.offset, var8);
                        if(class187.field2764 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class187.field2763.payload[class187.field2763.offset + var9] ^= class187.field2764;
                           }
                        }

                        class187.field2763.offset += var8;
                        if(class187.field2763.offset < var7) {
                           break;
                        }

                        if(class199.field2881 == null) {
                           class187.field2763.offset = 0;
                           var9 = class187.field2763.readUnsignedByte();
                           var10 = class187.field2763.readUnsignedShort();
                           int var11 = class187.field2763.readUnsignedByte();
                           var12 = class187.field2763.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           class183 var15 = (class183)class187.field2756.method2773(var13);
                           class108.field1729 = true;
                           if(var15 == null) {
                              var15 = (class183)class187.field2761.method2773(var13);
                              class108.field1729 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class199.field2881 = var15;
                           class187.field2751 = new Buffer(var12 + var16 + class199.field2881.field2705);
                           class187.field2751.putByte(var11);
                           class187.field2751.putInt(var12);
                           class187.field2765 = 8;
                           class187.field2763.offset = 0;
                        } else if(class187.field2765 == 0) {
                           if(class187.field2763.payload[0] == -1) {
                              class187.field2765 = 1;
                              class187.field2763.offset = 0;
                           } else {
                              class199.field2881 = null;
                           }
                        }
                     } else {
                        var8 = class187.field2751.payload.length - class199.field2881.field2705;
                        var9 = 512 - class187.field2765;
                        if(var9 > var8 - class187.field2751.offset) {
                           var9 = var8 - class187.field2751.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class187.field2759.read(class187.field2751.payload, class187.field2751.offset, var9);
                        if(class187.field2764 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class187.field2751.payload[class187.field2751.offset + var10] ^= class187.field2764;
                           }
                        }

                        class187.field2751.offset += var9;
                        class187.field2765 += var9;
                        if(class187.field2751.offset == var8) {
                           if(16711935L == class199.field2881.hash) {
                              class3.field35 = class187.field2751;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var19 = class187.field2757[var10];
                                 if(var19 != null) {
                                    class3.field35.offset = var10 * 8 + 5;
                                    var12 = class3.field35.readInt();
                                    int var20 = class3.field35.readInt();
                                    var19.method3385(var12, var20);
                                 }
                              }
                           } else {
                              class187.field2766.reset();
                              class187.field2766.update(class187.field2751.payload, 0, var8);
                              var10 = (int)class187.field2766.getValue();
                              if(class199.field2881.field2707 != var10) {
                                 try {
                                    class187.field2759.method2093();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class187.field2769;
                                 class187.field2759 = null;
                                 class187.field2764 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label241;
                              }

                              class187.field2769 = 0;
                              class187.field2770 = 0;
                              class199.field2881.field2704.method3386((int)(class199.field2881.hash & 65535L), class187.field2751.payload, (class199.field2881.hash & 16711680L) == 16711680L, class108.field1729);
                           }

                           class199.field2881.unlink();
                           if(class108.field1729) {
                              --class187.field2768;
                           } else {
                              --class187.field2762;
                           }

                           class187.field2765 = 0;
                           class199.field2881 = null;
                           class187.field2751 = null;
                        } else {
                           if(class187.field2765 != 512) {
                              break;
                           }

                           class187.field2765 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class187.field2759.method2093();
               } catch (Exception var22) {
                  ;
               }

               ++class187.field2770;
               class187.field2759 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method262();
         }

      }
   }

   static {
      field306 = class40.field807;
      field307 = class40.field807;
      field308 = 0;
      field396 = 0;
      field386 = 0;
      field313 = 0;
      loginState = 0;
      field315 = 0;
      field316 = 0;
      field317 = 0;
      field297 = null;
      cachedNPCs = new NPC['耀'];
      field321 = 0;
      field350 = new int['耀'];
      field292 = 0;
      field324 = new int[250];
      egressBuffer = new PacketBuffer(5000);
      loginBuffer = new PacketBuffer(5000);
      ingressBuffer = new PacketBuffer(15000);
      packetLength = 0;
      packetOpcode = 0;
      field330 = 0;
      field331 = 0;
      field538 = 0;
      field417 = 0;
      field466 = 0;
      field489 = 0;
      field336 = false;
      field337 = 0;
      field544 = 1;
      field369 = 0;
      field340 = 1;
      field341 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field344 = new int[4][13][13];
      field345 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field346 = 0;
      field347 = 2;
      field526 = 0;
      field349 = 2;
      field425 = 0;
      field512 = 1;
      field352 = 0;
      mapScale = 0;
      mapOffset = 2;
      mapScaleDelta = 0;
      field356 = 1;
      field357 = 0;
      field358 = 0;
      field360 = 2301979;
      field434 = 5063219;
      field362 = 3353893;
      field363 = 7759444;
      field282 = false;
      field365 = 0;
      field366 = 128;
      mapAngle = 0;
      field373 = 0;
      field470 = 0;
      field370 = 0;
      field371 = 0;
      field372 = 50;
      field383 = 0;
      field374 = false;
      field375 = 0;
      field428 = 0;
      field377 = 50;
      field378 = new int[field377];
      field379 = new int[field377];
      field473 = new int[field377];
      field381 = new int[field377];
      field507 = new int[field377];
      field503 = new int[field377];
      field384 = new int[field377];
      field335 = new String[field377];
      field497 = new int[104][104];
      field309 = 0;
      field388 = -1;
      field389 = -1;
      field550 = 0;
      field391 = 0;
      field333 = 0;
      field393 = 0;
      field394 = 0;
      field395 = 0;
      field488 = 0;
      field540 = 0;
      field398 = 0;
      field399 = 0;
      field400 = false;
      field404 = 0;
      field402 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field406 = 0;
      field407 = 0;
      field408 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field412 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field472 = -1;
      groundItemDeque = new Deque[4][104][104];
      field415 = new Deque();
      projectiles = new Deque();
      field531 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field421 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field430 = false;
      field431 = -1;
      field432 = false;
      field433 = -1;
      field546 = -1;
      field436 = 0;
      field437 = 50;
      field351 = 0;
      field439 = null;
      field440 = false;
      field441 = -1;
      field537 = -1;
      field438 = null;
      field392 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field447 = 0;
      field448 = 0;
      field449 = null;
      energy = 0;
      weight = 0;
      field517 = 0;
      field310 = -1;
      field278 = false;
      field455 = false;
      field456 = false;
      field457 = null;
      field458 = null;
      field496 = null;
      field492 = 0;
      field461 = 0;
      field462 = null;
      field463 = false;
      field380 = -1;
      field465 = -1;
      field376 = false;
      field467 = -1;
      field397 = -1;
      field469 = false;
      field311 = 1;
      field471 = new int[32];
      field443 = 0;
      interfaceItemTriggers = new int[32];
      field474 = 0;
      field475 = new int[32];
      field364 = 0;
      field477 = 0;
      field478 = 0;
      field479 = 0;
      field480 = 0;
      field481 = 0;
      field482 = 0;
      field483 = 0;
      field484 = new Deque();
      field476 = new Deque();
      field486 = new Deque();
      widgetFlags = new XHashTable(512);
      field490 = 0;
      field385 = -2;
      field368 = new boolean[100];
      field491 = new boolean[100];
      field452 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field382 = 0;
      field296 = 0L;
      isResized = true;
      field293 = 765;
      field322 = 1;
      field502 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field323 = 0;
      field468 = 0;
      field460 = "";
      field506 = new long[100];
      field348 = 0;
      field508 = 0;
      field444 = new int[128];
      field510 = new int[128];
      field511 = -1L;
      field485 = null;
      clanChatOwner = null;
      field515 = -1;
      field516 = 0;
      field505 = new int[1000];
      field518 = new int[1000];
      field570 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field522 = 0;
      field501 = 255;
      field524 = -1;
      field525 = false;
      field551 = 127;
      field527 = 127;
      field528 = 0;
      field529 = new int[50];
      field530 = new int[50];
      field442 = new int[50];
      field493 = new int[50];
      field504 = new SoundEffect[50];
      field534 = false;
      field535 = new boolean[5];
      field536 = new int[5];
      field401 = new int[5];
      field545 = new int[5];
      field539 = new int[5];
      field500 = 256;
      field541 = 205;
      field542 = 256;
      field318 = 320;
      field509 = 1;
      field459 = 32767;
      field320 = 1;
      field547 = 32767;
      field548 = 0;
      field549 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field554 = 0;
      friends = new Friend[400];
      field556 = new class151();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field559 = new PlayerComposition();
      field560 = -1;
      field561 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field563 = -1L;
      field564 = -1L;
      field565 = new class22();
      field566 = new int[50];
      field567 = new int[50];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-776543387"
   )
   void method370(int var1) {
      Friend.field156 = null;
      rssocket = null;
      field396 = 0;
      if(class109.field1736 == class18.field194) {
         class109.field1736 = RSSocket.field1747;
      } else {
         class109.field1736 = class18.field194;
      }

      ++field313;
      if(field313 < 2 || var1 != 7 && var1 != 9) {
         if(field313 >= 2 && var1 == 6) {
            this.method2129("js5connect_outofdate");
            gameState = 1000;
         } else if(field313 >= 4) {
            if(gameState <= 5) {
               this.method2129("js5connect");
               gameState = 1000;
            } else {
               field386 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2129("js5connect_full");
         gameState = 1000;
      } else {
         field386 = 3000;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "790676773"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method328();

      while(true) {
         Deque var2 = class185.field2727;
         class182 var1;
         synchronized(class185.field2727) {
            var1 = (class182)class185.field2728.method2826();
         }

         if(var1 == null) {
            class10.method149();
            GameEngine.method2201();
            class8.method104();
            class115 var8 = class115.mouse;
            synchronized(class115.mouse) {
               class115.field1799 = class115.field1801;
               class115.field1805 = class115.field1812;
               class115.field1806 = class115.field1803;
               class115.field1811 = class115.field1807;
               class115.field1802 = class115.field1810;
               class115.field1813 = class115.field1809;
               class115.field1814 = class115.field1817;
               class115.field1807 = 0;
            }

            int var5;
            if(FloorUnderlayDefinition.field2828 != null) {
               var5 = FloorUnderlayDefinition.field2828.vmethod2113();
               field483 = var5;
            }

            if(gameState == 0) {
               class188.method3430();
               ChatMessages.field916.vmethod2062();

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field1773[var5] = 0L;
               }

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field1774[var5] = 0L;
               }

               XItemContainer.field130 = 0;
            } else if(gameState == 5) {
               class20.method213(this);
               class188.method3430();
               ChatMessages.field916.vmethod2062();

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field1773[var5] = 0L;
               }

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field1774[var5] = 0L;
               }

               XItemContainer.field130 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class20.method213(this);
                  class20.method211();
               } else if(gameState == 25) {
                  ChatLineBuffer.method933();
               }
            } else {
               class20.method213(this);
            }

            if(gameState == 30) {
               Tile.method1566();
            } else if(gameState == 40 || gameState == 45) {
               class20.method211();
            }

            return;
         }

         var1.field2698.method3401(var1.field2697, (int)var1.hash, var1.field2695, false);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-907029996"
   )
   protected final void vmethod2154() {
      boolean var1;
      label231: {
         try {
            if(class159.field2063 == 2) {
               if(class13.field145 == null) {
                  class13.field145 = Track1.method3124(class159.field2067, PacketBuffer.field1989, class190.field2791);
                  if(class13.field145 == null) {
                     var1 = false;
                     break label231;
                  }
               }

               if(class3.field32 == null) {
                  class3.field32 = new class61(class159.field2070, class159.field2064);
               }

               if(class159.field2066.method2983(class13.field145, class159.field2068, class3.field32, 22050)) {
                  class159.field2066.method2976();
                  class159.field2066.method3002(class159.field2069);
                  class159.field2066.method2912(class13.field145, class15.field164);
                  class159.field2063 = 0;
                  class13.field145 = null;
                  class3.field32 = null;
                  class159.field2067 = null;
                  var1 = true;
                  break label231;
               }
            }
         } catch (Exception var20) {
            var20.printStackTrace();
            class159.field2066.method2939();
            class159.field2063 = 0;
            class13.field145 = null;
            class3.field32 = null;
            class159.field2067 = null;
         }

         var1 = false;
      }

      if(var1 && field525 && class8.field70 != null) {
         class8.field70.method1089();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field296 && class72.method1421() > field296) {
            int var3 = isResized?2:1;
            ItemComposition.method3798(var3);
         } else if(GameEngine.field1780) {
            class214.method4050();
         }
      }

      Dimension var13 = this.method2131();
      if(var13.width != GroundObject.field1285 || var13.height != class20.field221 || GameEngine.field1779) {
         class138.method2672();
         field296 = class72.method1421() + 500L;
         GameEngine.field1779 = false;
      }

      boolean var4 = false;
      int var5;
      if(GameEngine.field1777) {
         GameEngine.field1777 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field368[var5] = true;
         }
      }

      if(var4) {
         RSSocket.method2095();
      }

      if(gameState == 0) {
         var5 = class41.field817;
         String var6 = class41.field829;
         Color var7 = null;

         try {
            Graphics var8 = class65.canvas.getGraphics();
            if(Buffer.field1962 == null) {
               Buffer.field1962 = new java.awt.Font("Helvetica", 1, 13);
               class121.field1878 = class65.canvas.getFontMetrics(Buffer.field1962);
            }

            if(var4) {
               var8.setColor(Color.black);
               var8.fillRect(0, 0, class187.field2760, IndexDataBase.field2726);
            }

            if(var7 == null) {
               var7 = new Color(140, 17, 17);
            }

            try {
               if(WidgetNode.field183 == null) {
                  WidgetNode.field183 = class65.canvas.createImage(304, 34);
               }

               Graphics var9 = WidgetNode.field183.getGraphics();
               var9.setColor(var7);
               var9.drawRect(0, 0, 303, 33);
               var9.fillRect(2, 2, var5 * 3, 30);
               var9.setColor(Color.black);
               var9.drawRect(1, 1, 301, 31);
               var9.fillRect(var5 * 3 + 2, 2, 300 - var5 * 3, 30);
               var9.setFont(Buffer.field1962);
               var9.setColor(Color.white);
               var9.drawString(var6, (304 - class121.field1878.stringWidth(var6)) / 2, 22);
               var8.drawImage(WidgetNode.field183, class187.field2760 / 2 - 152, IndexDataBase.field2726 / 2 - 18, (ImageObserver)null);
            } catch (Exception var16) {
               int var10 = class187.field2760 / 2 - 152;
               int var11 = IndexDataBase.field2726 / 2 - 18;
               var8.setColor(var7);
               var8.drawRect(var10, var11, 303, 33);
               var8.fillRect(var10 + 2, var11 + 2, var5 * 3, 30);
               var8.setColor(Color.black);
               var8.drawRect(var10 + 1, var11 + 1, 301, 31);
               var8.fillRect(var5 * 3 + var10 + 2, var11 + 2, 300 - var5 * 3, 30);
               var8.setFont(Buffer.field1962);
               var8.setColor(Color.white);
               var8.drawString(var6, var10 + (304 - class121.field1878.stringWidth(var6)) / 2, var11 + 22);
            }
         } catch (Exception var17) {
            class65.canvas.repaint();
         }
      } else if(gameState == 5) {
         class9.method110(TextureProvider.field1192, class36.field766, WallObject.field1542, var4);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class9.method110(TextureProvider.field1192, class36.field766, WallObject.field1542, var4);
         } else if(gameState == 25) {
            if(field341 == 1) {
               if(field337 > field544) {
                  field544 = field337;
               }

               var5 = (field544 * 50 - field337 * 50) / field544;
               class38.method769("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field341 == 2) {
               if(field369 > field340) {
                  field340 = field369;
               }

               var5 = (field340 * 50 - field369 * 50) / field340 + 50;
               class38.method769("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class38.method769("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            class6.method88();
         } else if(gameState == 40) {
            class38.method769("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class38.method769("Please wait...", false);
         }
      } else {
         class9.method110(TextureProvider.field1192, class36.field766, WallObject.field1542, var4);
      }

      Graphics var14;
      int var15;
      if(gameState == 30 && field382 == 0 && !var4) {
         try {
            var14 = class65.canvas.getGraphics();

            for(var15 = 0; var15 < field490; ++var15) {
               if(field491[var15]) {
                  class88.bufferProvider.drawSub(var14, widgetPositionX[var15], widgetPositionY[var15], widgetBoundsWidth[var15], widgetBoundsHeight[var15]);
                  field491[var15] = false;
               }
            }
         } catch (Exception var19) {
            class65.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var14 = class65.canvas.getGraphics();
            class88.bufferProvider.draw(var14, 0, 0);

            for(var15 = 0; var15 < field490; ++var15) {
               field491[var15] = false;
            }
         } catch (Exception var18) {
            class65.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-16"
   )
   static final void method572(int var0, int var1) {
      if(class112.method2112(var0)) {
         FileOnDisk.method1445(class133.widgets[var0], var1);
      }
   }
}
