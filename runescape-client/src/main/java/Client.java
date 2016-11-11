import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
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
   @ObfuscatedName("oi")
   static short field297;
   @ObfuscatedName("e")
   static boolean field298 = true;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -808946005
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = -574512135
   )
   static int field300;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1448447225
   )
   static int field301;
   @ObfuscatedName("m")
   static class215 field302;
   @ObfuscatedName("j")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("s")
   static boolean field304 = false;
   @ObfuscatedName("ou")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -5236605
   )
   static int field306 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -546079461
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("fp")
   static boolean field308;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -1461263775
   )
   static int field309;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 558366549
   )
   static int field310 = 0;
   @ObfuscatedName("b")
   static class13 field311;
   @ObfuscatedName("it")
   static String field312;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1435048535
   )
   static int field313 = -1;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -443857475
   )
   static int field314;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -1751895323
   )
   static int field315;
   @ObfuscatedName("ad")
   static boolean field316 = false;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 821173907
   )
   static int field317 = 0;
   @ObfuscatedName("ow")
   static short field318;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 280201783
   )
   static int field319 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1175383087
   )
   static int field320 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 72219253
   )
   static int field321 = 0;
   @ObfuscatedName("ha")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1401523277
   )
   static int field323 = 0;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 106832477
   )
   static int field324;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1933788683
   )
   static int field325 = 0;
   @ObfuscatedName("ax")
   static class21 field326;
   @ObfuscatedName("ac")
   static class21 field327;
   @ObfuscatedName("lg")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -146143651
   )
   static int field329;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -424111813
   )
   static int field330;
   @ObfuscatedName("av")
   static class171 field331;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1930923593
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("bx")
   static class171 field333;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1009559773
   )
   static int field334;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 368342997
   )
   static int field335;
   @ObfuscatedName("lc")
   static int[] field336;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = -636663357
   )
   static int field337;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1744156491
   )
   static int field338;
   @ObfuscatedName("cj")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1164157667
   )
   static int field341;
   @ObfuscatedName("cm")
   static int[] field342;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1020311917
   )
   static int field343;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 688586131
   )
   static int field344;
   @ObfuscatedName("ig")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("cp")
   static class125 field346;
   @ObfuscatedName("cx")
   static class125 field347;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 442327309
   )
   static int field348;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1505187775
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1327444091
   )
   static int field350;
   @ObfuscatedName("du")
   static boolean field351;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 838317061
   )
   static int field352;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 1696981699
   )
   static int field353;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -389785527
   )
   static int field354;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1633253849
   )
   static int field355;
   @ObfuscatedName("cd")
   static boolean field356;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -1909494353
   )
   static int field357;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -877899457
   )
   static int field358;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -742178257
   )
   static int field359;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 2009034361
   )
   static int field360;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 113000873
   )
   static int field361;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -47187703
   )
   static int field362;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 261620757
   )
   static int field363;
   @ObfuscatedName("dm")
   static int[][][] field364;
   @ObfuscatedName("dn")
   static final int[] field365;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -2107231643
   )
   static int field366;
   @ObfuscatedName("hj")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -5750425
   )
   static int field368;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -1576085507
   )
   static int field369;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1732356751
   )
   static int field370 = -1;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -338908133
   )
   static int field371;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 204143
   )
   static int field372;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 890783063
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 1958894891
   )
   static int field374;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 1459277127
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("fn")
   static int[] field376;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -167473283
   )
   static int field377;
   @ObfuscatedName("cw")
   static class125 field378;
   @ObfuscatedName("ew")
   static ModIcon[] field379;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 2011088651
   )
   static int field380;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -500569935
   )
   static int field381;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -1448666931
   )
   static int field382;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 1587167297
   )
   static int field383;
   @ObfuscatedName("eg")
   static boolean field384;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -439683053
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 263458065
   )
   static int field386;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 106750717
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 702070917
   )
   static int field388;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 1777540035
   )
   static int field389;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 1217429273
   )
   static int field390;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -1125716497
   )
   static int field391;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1752660859
   )
   static int field392;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 999329327
   )
   static int field393;
   @ObfuscatedName("oo")
   static short field394;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -1858875995
   )
   static int field395;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -2101211985
   )
   static int field396;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -1843695867
   )
   static int field397;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 146341057
   )
   static int field398;
   @ObfuscatedName("fe")
   static int[] field399;
   @ObfuscatedName("fz")
   static int[] field400;
   @ObfuscatedName("fg")
   static int[] field401;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = -1403756209
   )
   static int field402;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 1140641059
   )
   static int field403;
   @ObfuscatedName("fh")
   static int[] field404;
   @ObfuscatedName("gh")
   static String[] field405;
   @ObfuscatedName("gk")
   static int[][] field406;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 1793681197
   )
   static int field407;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -1061042191
   )
   static int field408;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 2039098159
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1534390527
   )
   static int field411;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -778828867
   )
   static int field412;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1245590151
   )
   static int field413;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 290792177
   )
   static int field414;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -2091278819
   )
   static int field415;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 1786035421
   )
   static int field416;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -9006053
   )
   static int field417;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1371866335
   )
   static int field418;
   @ObfuscatedName("gf")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -1867105173
   )
   static int field420;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -2057644553
   )
   static int field421;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      longValue = 5864402986655782891L
   )
   static long field422;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 881224905
   )
   static int field423;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -585087771
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -455277547
   )
   static int field425;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 741283823
   )
   static int field426;
   @ObfuscatedName("hd")
   static int[] field427;
   @ObfuscatedName("hg")
   static final int[] field428;
   @ObfuscatedName("hb")
   static String[] field429;
   @ObfuscatedName("hf")
   static boolean[] field430;
   @ObfuscatedName("hu")
   static int[] field431;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -1711535183
   )
   static int field432;
   @ObfuscatedName("hl")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -622192023
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("hc")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hn")
   static Deque field436;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -459831409
   )
   static int field437;
   @ObfuscatedName("hq")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("q")
   static boolean field439 = true;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 1083228613
   )
   static int field440;
   @ObfuscatedName("ht")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 581168631
   )
   static int field442;
   @ObfuscatedName("hw")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("hr")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 122870043
   )
   static int field445;
   @ObfuscatedName("ie")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -631016797
   )
   static int field447;
   @ObfuscatedName("ib")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1016275687
   )
   static int field449;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      longValue = -1003417229567521803L
   )
   static long field450;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 1538526249
   )
   static int field451;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -1198938643
   )
   static int field452;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -772182347
   )
   static int field453;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1882258615
   )
   static int field454;
   @ObfuscatedName("iy")
   static boolean field455;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 141985913
   )
   static int field456;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1828535809
   )
   static int field457;
   @ObfuscatedName("iu")
   static String field458;
   @ObfuscatedName("ii")
   static String field459;
   @ObfuscatedName("ju")
   static Widget field460;
   @ObfuscatedName("ij")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 1892866931
   )
   static int field462;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -1556766383
   )
   static int field463;
   @ObfuscatedName("jy")
   static Widget field464;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 1366959407
   )
   static int field465;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 1488006721
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("fk")
   static int[] field467;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 2086279111
   )
   static int field468;
   @ObfuscatedName("ih")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("js")
   static boolean field470;
   @ObfuscatedName("jz")
   static boolean field471;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 405902161
   )
   static int field472;
   @ObfuscatedName("jp")
   static Widget field473;
   @ObfuscatedName("jw")
   static Widget field474;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -512213113
   )
   static int field475;
   @ObfuscatedName("by")
   static class171 field476;
   @ObfuscatedName("mb")
   static int[] field477;
   @ObfuscatedName("jc")
   static boolean field478;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 1066878995
   )
   static int field479;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -2090833581
   )
   static int field480;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -2059263161
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -981969143
   )
   static int field482;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -379904421
   )
   static int field483;
   @ObfuscatedName("jg")
   static boolean field484;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -112915353
   )
   static int field485;
   @ObfuscatedName("kh")
   static int[] field486;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -184446905
   )
   static int field487;
   @ObfuscatedName("kx")
   static int[] field488;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 616329895
   )
   static int field489;
   @ObfuscatedName("ki")
   static int[] field490;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 438370423
   )
   static int field491;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -1277289257
   )
   static int field492;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = 1900302599
   )
   static int field493;
   @ObfuscatedName("kg")
   static boolean[] field494;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 2126766827
   )
   static int field495;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -602528725
   )
   static int field496;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -643998113
   )
   static int field497;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 305599683
   )
   static int field498;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 1812748805
   )
   static int field499;
   @ObfuscatedName("ks")
   static Deque field500;
   @ObfuscatedName("kn")
   static Deque field501;
   @ObfuscatedName("kb")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("oj")
   static class198 field503;
   @ObfuscatedName("od")
   static int[] field504;
   @ObfuscatedName("lk")
   static String field505;
   @ObfuscatedName("lj")
   static boolean[] field506;
   @ObfuscatedName("lf")
   static boolean[] field507;
   @ObfuscatedName("ms")
   static int[] field508;
   @ObfuscatedName("le")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("lm")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("ld")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 1721644137
   )
   static int field512;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 1389736085
   )
   static int field513;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1312566703
   )
   static int field514 = 0;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1458439515
   )
   static int field515;
   @ObfuscatedName("je")
   static boolean field516;
   @ObfuscatedName("lt")
   static int[] field517;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -1657319363
   )
   static int field518;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 1522795337
   )
   static int field519;
   @ObfuscatedName("nr")
   static boolean[] field520;
   @ObfuscatedName("lw")
   static long[] field521;
   @ObfuscatedName("kl")
   static Deque field522;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -220819361
   )
   static int field523;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 711889975
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 148778466131676953L
   )
   static long field525 = -1L;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      longValue = -1052589943494085897L
   )
   static long field526;
   @ObfuscatedName("oq")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("mi")
   static String field528;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1954154535
   )
   static int field529 = 0;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 458098297
   )
   static int field530;
   @ObfuscatedName("mj")
   static int[] field532;
   @ObfuscatedName("mf")
   static SpritePixels[] field533;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -1273716173
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("jx")
   static Widget field535;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1434947687
   )
   static int field536 = -1;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 1026734741
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = -1346062811
   )
   static int field538;
   @ObfuscatedName("mu")
   static boolean field539;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1052372699
   )
   static int field540 = 0;
   @ObfuscatedName("mo")
   static String field541;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -780127321
   )
   static int field542;
   @ObfuscatedName("no")
   static int[] field543;
   @ObfuscatedName("nx")
   static int[] field544;
   @ObfuscatedName("ns")
   static int[] field545;
   @ObfuscatedName("np")
   static int[] field546;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1126356577
   )
   static int field547;
   @ObfuscatedName("ni")
   static boolean field548;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 1519925449
   )
   static int field549;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -82646827
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("of")
   static int[] field551;
   @ObfuscatedName("oz")
   static int[] field552;
   @ObfuscatedName("on")
   static int[] field553;
   @ObfuscatedName("nq")
   static class61[] field554;
   @ObfuscatedName("cs")
   static int[] field555;
   @ObfuscatedName("gl")
   static boolean field556;
   @ObfuscatedName("ov")
   static short field557;
   @ObfuscatedName("os")
   static short field558;
   @ObfuscatedName("om")
   static short field559;
   @ObfuscatedName("oc")
   static short field560;
   @ObfuscatedName("ob")
   static short field561;
   @ObfuscatedName("as")
   static boolean field562 = true;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 927724739
   )
   static int field563;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -1178917205
   )
   static int field564;
   @ObfuscatedName("fd")
   static int[] field565;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1940065779
   )
   static int field566;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 1778564539
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = 981303389
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 44514209
   )
   static int field569;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -909474595
   )
   static int field570;
   @ObfuscatedName("ho")
   static Deque field571;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 256214009
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 219523479
   )
   static int field573;
   @ObfuscatedName("ox")
   static PlayerComposition field574;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -445588215
   )
   static int field575;
   @ObfuscatedName("lu")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("ps")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      longValue = -1291216349884479841L
   )
   static long field578;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -1541054311
   )
   static int field579;
   @ObfuscatedName("pv")
   static final class10 field580;
   @ObfuscatedName("pz")
   static int[] field581;
   @ObfuscatedName("pf")
   static int[] field582;
   @ObfuscatedName("l")
   static ModIcon field583;
   @ObfuscatedName("jd")
   static boolean field585;
   @ObfuscatedName("dt")
   static int[] field586;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   protected final void vmethod3057() {
      if(class5.chatMessages.method236()) {
         class5.chatMessages.method210();
      }

      if(null != field311) {
         field311.field213 = false;
      }

      field311 = null;
      if(null != ObjectComposition.field993) {
         ObjectComposition.field993.method3029();
         ObjectComposition.field993 = null;
      }

      if(class140.keyboard != null) {
         class140 var1 = class140.keyboard;
         synchronized(class140.keyboard) {
            class140.keyboard = null;
         }
      }

      class4.method55();
      ItemComposition.field1217 = null;
      if(null != World.field683) {
         World.field683.method1258();
      }

      if(null != XClanMember.field652) {
         XClanMember.field652.method1258();
      }

      if(class174.field2768 != null) {
         class174.field2768.method3029();
      }

      BufferProvider.method1735();
      TextureProvider.method2240();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1483331480"
   )
   void method245() {
      if(gameState != 1000) {
         long var2 = class34.method738();
         int var4 = (int)(var2 - class168.field2707);
         class168.field2707 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class174.field2761 += var4;
         boolean var1;
         if(class174.field2770 == 0 && class174.field2760 == 0 && class174.field2777 == 0 && class174.field2763 == 0) {
            var1 = true;
         } else if(null == class174.field2768) {
            var1 = false;
         } else {
            try {
               label239: {
                  if(class174.field2761 > 30000) {
                     throw new IOException();
                  }

                  class175 var5;
                  Buffer var6;
                  while(class174.field2760 < 20 && class174.field2763 > 0) {
                     var5 = (class175)class174.field2762.method3815();
                     var6 = new Buffer(4);
                     var6.method2529(1);
                     var6.method2531((int)var5.hash);
                     class174.field2768.method3028(var6.payload, 0, 4);
                     class174.field2764.method3813(var5, var5.hash);
                     --class174.field2763;
                     ++class174.field2760;
                  }

                  while(class174.field2770 < 20 && class174.field2777 > 0) {
                     var5 = (class175)class174.field2765.method3907();
                     var6 = new Buffer(4);
                     var6.method2529(0);
                     var6.method2531((int)var5.hash);
                     class174.field2768.method3028(var6.payload, 0, 4);
                     var5.method3924();
                     class174.field2769.method3813(var5, var5.hash);
                     --class174.field2777;
                     ++class174.field2770;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class174.field2768.method3026();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class174.field2761 = 0;
                     byte var7 = 0;
                     if(class189.field3062 == null) {
                        var7 = 8;
                     } else if(class174.field2766 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class174.field2778.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class174.field2768.method3027(class174.field2778.payload, class174.field2778.offset, var8);
                        if(class174.field2776 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class174.field2778.payload[var9 + class174.field2778.offset] ^= class174.field2776;
                           }
                        }

                        class174.field2778.offset += var8;
                        if(class174.field2778.offset < var7) {
                           break;
                        }

                        if(null == class189.field3062) {
                           class174.field2778.offset = 0;
                           var9 = class174.field2778.method2544();
                           var10 = class174.field2778.method2546();
                           int var11 = class174.field2778.method2544();
                           var12 = class174.field2778.method2549();
                           long var13 = (long)(var10 + (var9 << 16));
                           class175 var15 = (class175)class174.field2764.method3812(var13);
                           class174.field2771 = true;
                           if(var15 == null) {
                              var15 = (class175)class174.field2769.method3812(var13);
                              class174.field2771 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class189.field3062 = var15;
                           class16.field255 = new Buffer(var16 + var12 + class189.field3062.field2784);
                           class16.field255.method2529(var11);
                           class16.field255.method2709(var12);
                           class174.field2766 = 8;
                           class174.field2778.offset = 0;
                        } else if(class174.field2766 == 0) {
                           if(class174.field2778.payload[0] == -1) {
                              class174.field2766 = 1;
                              class174.field2778.offset = 0;
                           } else {
                              class189.field3062 = null;
                           }
                        }
                     } else {
                        var8 = class16.field255.payload.length - class189.field3062.field2784;
                        var9 = 512 - class174.field2766;
                        if(var9 > var8 - class16.field255.offset) {
                           var9 = var8 - class16.field255.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class174.field2768.method3027(class16.field255.payload, class16.field255.offset, var9);
                        if(class174.field2776 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class16.field255.payload[class16.field255.offset + var10] ^= class174.field2776;
                           }
                        }

                        class16.field255.offset += var9;
                        class174.field2766 += var9;
                        if(var8 == class16.field255.offset) {
                           if(16711935L == class189.field3062.hash) {
                              ChatLineBuffer.field706 = class16.field255;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class171 var19 = class174.field2775[var10];
                                 if(null != var19) {
                                    ChatLineBuffer.field706.offset = 5 + var10 * 8;
                                    var12 = ChatLineBuffer.field706.method2549();
                                    int var23 = ChatLineBuffer.field706.method2549();
                                    var19.method3371(var12, var23);
                                 }
                              }
                           } else {
                              class174.field2774.reset();
                              class174.field2774.update(class16.field255.payload, 0, var8);
                              var10 = (int)class174.field2774.getValue();
                              if(var10 != class189.field3062.field2783) {
                                 try {
                                    class174.field2768.method3029();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class174.field2773;
                                 class174.field2768 = null;
                                 class174.field2776 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label239;
                              }

                              class174.field2773 = 0;
                              class174.field2772 = 0;
                              class189.field3062.field2790.method3372((int)(class189.field3062.hash & 65535L), class16.field255.payload, 16711680L == (class189.field3062.hash & 16711680L), class174.field2771);
                           }

                           class189.field3062.unlink();
                           if(class174.field2771) {
                              --class174.field2760;
                           } else {
                              --class174.field2770;
                           }

                           class174.field2766 = 0;
                           class189.field3062 = null;
                           class16.field255 = null;
                        } else {
                           if(class174.field2766 != 512) {
                              break;
                           }

                           class174.field2766 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class174.field2768.method3029();
               } catch (Exception var20) {
                  ;
               }

               ++class174.field2772;
               class174.field2768 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method246();
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1750218304"
   )
   void method246() {
      if(class174.field2773 >= 4) {
         this.method3051("js5crc");
         gameState = 1000;
      } else {
         if(class174.field2772 >= 4) {
            if(gameState <= 5) {
               this.method3051("js5io");
               gameState = 1000;
               return;
            }

            field330 = 3000;
            class174.field2772 = 3;
         }

         if(--field330 + 1 <= 0) {
            try {
               if(field329 == 0) {
                  class116.field2016 = class40.field898.method2919(class48.host, class75.field1408);
                  ++field329;
               }

               if(field329 == 1) {
                  if(class116.field2016.field2265 == 2) {
                     this.method247(-1);
                     return;
                  }

                  if(class116.field2016.field2265 == 1) {
                     ++field329;
                  }
               }

               if(field329 == 2) {
                  class26.field664 = new class146((Socket)class116.field2016.field2270, class40.field898);
                  Buffer var1 = new Buffer(5);
                  var1.method2529(15);
                  var1.method2709(126);
                  class26.field664.method3028(var1.payload, 0, 5);
                  ++field329;
                  MessageNode.field817 = class34.method738();
               }

               if(field329 == 3) {
                  if(gameState > 5 && class26.field664.method3026() <= 0) {
                     if(class34.method738() - MessageNode.field817 > 30000L) {
                        this.method247(-2);
                        return;
                     }
                  } else {
                     int var2 = class26.field664.method3025();
                     if(var2 != 0) {
                        this.method247(var2);
                        return;
                     }

                     ++field329;
                  }
               }

               if(field329 == 4) {
                  class40.method802(class26.field664, gameState > 20);
                  class116.field2016 = null;
                  class26.field664 = null;
                  field329 = 0;
                  field334 = 0;
               }
            } catch (IOException var3) {
               this.method247(-3);
            }

         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "871950288"
   )
   void method247(int var1) {
      class116.field2016 = null;
      class26.field664 = null;
      field329 = 0;
      if(class75.field1408 == class51.field1126) {
         class75.field1408 = ItemLayer.field1731;
      } else {
         class75.field1408 = class51.field1126;
      }

      ++field334;
      if(field334 < 2 || var1 != 7 && var1 != 9) {
         if(field334 >= 2 && var1 == 6) {
            this.method3051("js5connect_outofdate");
            gameState = 1000;
         } else if(field334 >= 4) {
            if(gameState <= 5) {
               this.method3051("js5connect");
               gameState = 1000;
            } else {
               field330 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method3051("js5connect_full");
         gameState = 1000;
      } else {
         field330 = 3000;
      }

   }

   static {
      field326 = class21.field607;
      field327 = class21.field607;
      field398 = 0;
      field329 = 0;
      field330 = 0;
      field334 = 0;
      field335 = 0;
      field366 = 0;
      field487 = 0;
      field338 = 0;
      cachedNPCs = new NPC['耀'];
      field341 = 0;
      field342 = new int['耀'];
      field343 = 0;
      field555 = new int[250];
      field378 = new class125(5000);
      field346 = new class125(5000);
      field347 = new class125(15000);
      field348 = 0;
      packetOpcode = 0;
      field350 = 0;
      field480 = 0;
      field352 = 0;
      field421 = 0;
      field354 = 0;
      field355 = 0;
      field356 = false;
      field357 = 0;
      field358 = 1;
      field359 = 0;
      field301 = 1;
      field361 = 0;
      collisionMaps = new CollisionData[4];
      field351 = false;
      field364 = new int[4][13][13];
      field365 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field300 = 0;
      field483 = 2;
      field368 = 0;
      field369 = 2;
      field498 = 0;
      field371 = 1;
      field372 = 0;
      mapScale = 0;
      field374 = 2;
      mapScaleDelta = 0;
      field437 = 1;
      field377 = 0;
      field420 = 0;
      field380 = 2301979;
      field381 = 5063219;
      field382 = 3353893;
      field383 = 7759444;
      field384 = false;
      field362 = 0;
      field386 = 128;
      mapAngle = 0;
      field388 = 0;
      field389 = 0;
      field390 = 0;
      field391 = 0;
      field579 = 50;
      field393 = 0;
      field308 = false;
      field395 = 0;
      field396 = 0;
      field397 = 50;
      field467 = new int[field397];
      field399 = new int[field397];
      field400 = new int[field397];
      field401 = new int[field397];
      field565 = new int[field397];
      field376 = new int[field397];
      field404 = new int[field397];
      field405 = new String[field397];
      field406 = new int[104][104];
      field407 = 0;
      field445 = -1;
      field418 = -1;
      field499 = 0;
      field411 = 0;
      field412 = 0;
      field413 = 0;
      field414 = 0;
      field415 = 0;
      field416 = 0;
      field417 = 0;
      field392 = 0;
      field454 = 0;
      field556 = false;
      field423 = 0;
      field442 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field353 = 0;
      field314 = 0;
      field427 = new int[1000];
      field428 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field429 = new String[8];
      field430 = new boolean[8];
      field431 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field432 = -1;
      groundItemDeque = new Deque[4][104][104];
      field571 = new Deque();
      projectiles = new Deque();
      field436 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field440 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field449 = -1;
      field495 = -1;
      field360 = 0;
      field452 = 50;
      field453 = 0;
      field312 = null;
      field455 = false;
      field456 = -1;
      field457 = -1;
      field458 = null;
      field459 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field462 = 0;
      field463 = 0;
      field464 = null;
      energy = 0;
      weight = 0;
      field465 = 0;
      field566 = -1;
      field516 = false;
      field470 = false;
      field471 = false;
      field535 = null;
      field473 = null;
      field474 = null;
      field475 = 0;
      field512 = 0;
      field460 = null;
      field478 = false;
      field479 = -1;
      field324 = -1;
      field585 = false;
      field482 = -1;
      field447 = -1;
      field484 = false;
      field485 = 1;
      field486 = new int[32];
      field426 = 0;
      field488 = new int[32];
      field489 = 0;
      field490 = new int[32];
      field491 = 0;
      field492 = 0;
      field493 = 0;
      field570 = 0;
      field575 = 0;
      field496 = 0;
      field497 = 0;
      field530 = 0;
      field522 = new Deque();
      field500 = new Deque();
      field501 = new Deque();
      widgetFlags = new XHashTable(512);
      field425 = 0;
      field451 = -2;
      field494 = new boolean[100];
      field506 = new boolean[100];
      field507 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field402 = 0;
      field422 = 0L;
      isResized = true;
      field515 = 765;
      field315 = 1;
      field517 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field518 = 0;
      field519 = 0;
      field505 = "";
      field521 = new long[100];
      field468 = 0;
      field523 = 0;
      field336 = new int[128];
      field477 = new int[128];
      field526 = -1L;
      field541 = null;
      field528 = null;
      field472 = -1;
      field309 = 0;
      field508 = new int[1000];
      field532 = new int[1000];
      field533 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field403 = 0;
      field513 = 255;
      field538 = -1;
      field539 = false;
      field547 = 127;
      field408 = 127;
      field542 = 0;
      field543 = new int[50];
      field544 = new int[50];
      field545 = new int[50];
      field546 = new int[50];
      field554 = new class61[50];
      field548 = false;
      field520 = new boolean[5];
      field551 = new int[5];
      field552 = new int[5];
      field553 = new int[5];
      field504 = new int[5];
      field318 = 256;
      field297 = 205;
      field557 = 256;
      field558 = 320;
      field559 = 1;
      field394 = 32767;
      field561 = 1;
      field560 = 32767;
      field337 = 0;
      field564 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field569 = 0;
      friends = new Friend[400];
      field503 = new class198();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field574 = new PlayerComposition();
      field573 = -1;
      field563 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field578 = -1L;
      field450 = -1L;
      field580 = new class10();
      field581 = new int[50];
      field582 = new int[50];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1338462384"
   )
   protected final void vmethod3061() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1748155642"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method245();

      while(true) {
         Deque var2 = class173.field2756;
         class172 var1;
         synchronized(class173.field2756) {
            var1 = (class172)class173.field2757.method3859();
         }

         if(var1 == null) {
            class22.method549();
            class212.method3957();
            class140 var64 = class140.keyboard;
            int var44;
            synchronized(class140.keyboard) {
               ++class140.keyboardIdleTicks;
               class140.field2159 = class140.field2175;
               class140.field2172 = 0;
               if(class140.field2168 >= 0) {
                  while(class140.field2168 != class140.field2167) {
                     var44 = class140.field2160[class140.field2167];
                     class140.field2167 = 1 + class140.field2167 & 127;
                     if(var44 < 0) {
                        class140.field2165[~var44] = false;
                     } else {
                        if(!class140.field2165[var44] && class140.field2172 < class140.field2156.length - 1) {
                           class140.field2156[++class140.field2172 - 1] = var44;
                        }

                        class140.field2165[var44] = true;
                     }
                  }
               } else {
                  for(var44 = 0; var44 < 112; ++var44) {
                     class140.field2165[var44] = false;
                  }

                  class140.field2168 = class140.field2167;
               }

               class140.field2175 = class140.field2174;
            }

            class143 var65 = class143.mouse;
            synchronized(class143.mouse) {
               class143.field2203 = class143.field2205;
               class143.field2204 = class143.field2201;
               class143.field2206 = class143.field2202;
               class143.field2210 = class143.field2200;
               class143.field2211 = class143.field2213;
               class143.field2212 = class143.field2208;
               class143.field2198 = class143.field2209;
               class143.field2200 = 0;
            }

            int var45;
            if(null != ItemComposition.field1217) {
               var45 = ItemComposition.field1217.vmethod3138();
               field530 = var45;
            }

            int var6;
            int var7;
            int var10;
            int var11;
            int var12;
            int var46;
            int var47;
            int var48;
            int var54;
            int var79;
            int var81;
            if(gameState == 0) {
               class79.method1714();
               class166.method3254();
            } else if(gameState == 5) {
               class59.method1264(this);
               class79.method1714();
               class166.method3254();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class59.method1264(this);
                  class129.method2848();
               } else if(gameState == 25) {
                  class22.method556(false);
                  field357 = 0;
                  boolean var83 = true;

                  for(var44 = 0; var44 < class4.field76.length; ++var44) {
                     if(class145.field2227[var44] != -1 && null == class4.field76[var44]) {
                        class4.field76[var44] = class9.field173.method3292(class145.field2227[var44], 0);
                        if(null == class4.field76[var44]) {
                           var83 = false;
                           ++field357;
                        }
                     }

                     if(field586[var44] != -1 && class174.field2779[var44] == null) {
                        class174.field2779[var44] = class9.field173.method3290(field586[var44], 0, class113.xteaKeys[var44]);
                        if(class174.field2779[var44] == null) {
                           var83 = false;
                           ++field357;
                        }
                     }
                  }

                  if(!var83) {
                     field361 = 1;
                  } else {
                     field359 = 0;
                     var83 = true;

                     Buffer var9;
                     int var14;
                     int var15;
                     int var16;
                     int var17;
                     int var18;
                     int var19;
                     for(var44 = 0; var44 < class4.field76.length; ++var44) {
                        byte[] var3 = class174.field2779[var44];
                        if(null != var3) {
                           var46 = (class16.mapRegions[var44] >> 8) * 64 - class193.baseX;
                           var47 = 64 * (class16.mapRegions[var44] & 255) - DecorativeObject.baseY;
                           if(field351) {
                              var46 = 10;
                              var47 = 10;
                           }

                           boolean var8 = true;
                           var9 = new Buffer(var3);
                           var10 = -1;

                           label1863:
                           while(true) {
                              var11 = var9.method2573();
                              if(var11 == 0) {
                                 var83 &= var8;
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;
                              boolean var13 = false;

                              while(true) {
                                 while(!var13) {
                                    var14 = var9.method2573();
                                    if(var14 == 0) {
                                       continue label1863;
                                    }

                                    var12 += var14 - 1;
                                    var15 = var12 & 63;
                                    var16 = var12 >> 6 & 63;
                                    var17 = var9.method2544() >> 2;
                                    var18 = var16 + var46;
                                    var19 = var47 + var15;
                                    if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                       ObjectComposition var20 = class9.getObjectDefinition(var10);
                                       if(var17 != 22 || !field304 || var20.field963 != 0 || var20.field961 == 1 || var20.field982) {
                                          if(!var20.method846()) {
                                             ++field359;
                                             var8 = false;
                                          }

                                          var13 = true;
                                       }
                                    }
                                 }

                                 var14 = var9.method2573();
                                 if(var14 == 0) {
                                    break;
                                 }

                                 var9.method2544();
                              }
                           }
                        }
                     }

                     if(!var83) {
                        field361 = 2;
                     } else {
                        if(field361 != 0) {
                           class165.method3226("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class212.method3957();
                        class59.method1267();
                        class212.method3957();
                        class128.region.method1952();
                        class212.method3957();
                        System.gc();

                        for(var44 = 0; var44 < 4; ++var44) {
                           collisionMaps[var44].method2419();
                        }

                        for(var44 = 0; var44 < 4; ++var44) {
                           for(var48 = 0; var48 < 104; ++var48) {
                              for(var46 = 0; var46 < 104; ++var46) {
                                 class5.tileSettings[var44][var48][var46] = 0;
                              }
                           }
                        }

                        class212.method3957();
                        class79.method1713();
                        var44 = class4.field76.length;
                        class8.method115();
                        class22.method556(true);
                        int var21;
                        int var22;
                        if(!field351) {
                           var48 = 0;

                           label1801:
                           while(true) {
                              byte[] var49;
                              if(var48 >= var44) {
                                 for(var48 = 0; var48 < var44; ++var48) {
                                    var46 = 64 * (class16.mapRegions[var48] >> 8) - class193.baseX;
                                    var47 = (class16.mapRegions[var48] & 255) * 64 - DecorativeObject.baseY;
                                    var49 = class4.field76[var48];
                                    if(var49 == null && class18.field280 < 800) {
                                       class212.method3957();
                                       NPC.method759(var46, var47, 64, 64);
                                    }
                                 }

                                 class22.method556(true);
                                 var48 = 0;

                                 while(true) {
                                    if(var48 >= var44) {
                                       break label1801;
                                    }

                                    byte[] var4 = class174.field2779[var48];
                                    if(null != var4) {
                                       var47 = 64 * (class16.mapRegions[var48] >> 8) - class193.baseX;
                                       var6 = (class16.mapRegions[var48] & 255) * 64 - DecorativeObject.baseY;
                                       class212.method3957();
                                       Region var51 = class128.region;
                                       CollisionData[] var52 = collisionMaps;
                                       var9 = new Buffer(var4);
                                       var10 = -1;

                                       while(true) {
                                          var11 = var9.method2573();
                                          if(var11 == 0) {
                                             break;
                                          }

                                          var10 += var11;
                                          var12 = 0;

                                          while(true) {
                                             var81 = var9.method2573();
                                             if(var81 == 0) {
                                                break;
                                             }

                                             var12 += var81 - 1;
                                             var14 = var12 & 63;
                                             var15 = var12 >> 6 & 63;
                                             var16 = var12 >> 12;
                                             var17 = var9.method2544();
                                             var18 = var17 >> 2;
                                             var19 = var17 & 3;
                                             int var53 = var47 + var15;
                                             var21 = var6 + var14;
                                             if(var53 > 0 && var21 > 0 && var53 < 103 && var21 < 103) {
                                                var22 = var16;
                                                if((class5.tileSettings[1][var53][var21] & 2) == 2) {
                                                   var22 = var16 - 1;
                                                }

                                                CollisionData var23 = null;
                                                if(var22 >= 0) {
                                                   var23 = var52[var22];
                                                }

                                                class21.method544(var16, var53, var21, var10, var19, var18, var51, var23);
                                             }
                                          }
                                       }
                                    }

                                    ++var48;
                                 }
                              }

                              var46 = 64 * (class16.mapRegions[var48] >> 8) - class193.baseX;
                              var47 = 64 * (class16.mapRegions[var48] & 255) - DecorativeObject.baseY;
                              var49 = class4.field76[var48];
                              if(null != var49) {
                                 class212.method3957();
                                 var7 = class125.field2065 * 8 - 48;
                                 var79 = class18.field280 * 8 - 48;
                                 CollisionData[] var80 = collisionMaps;
                                 var10 = 0;

                                 label1798:
                                 while(true) {
                                    if(var10 >= 4) {
                                       Buffer var50 = new Buffer(var49);
                                       var11 = 0;

                                       while(true) {
                                          if(var11 >= 4) {
                                             break label1798;
                                          }

                                          for(var12 = 0; var12 < 64; ++var12) {
                                             for(var81 = 0; var81 < 64; ++var81) {
                                                class156.method3186(var50, var11, var46 + var12, var47 + var81, var7, var79, 0);
                                             }
                                          }

                                          ++var11;
                                       }
                                    }

                                    for(var11 = 0; var11 < 64; ++var11) {
                                       for(var12 = 0; var12 < 64; ++var12) {
                                          if(var46 + var11 > 0 && var46 + var11 < 103 && var47 + var12 > 0 && var12 + var47 < 103) {
                                             var80[var10].flags[var46 + var11][var47 + var12] &= -16777217;
                                          }
                                       }
                                    }

                                    ++var10;
                                 }
                              }

                              ++var48;
                           }
                        }

                        if(field351) {
                           var48 = 0;

                           label1734:
                           while(true) {
                              if(var48 >= 4) {
                                 for(var48 = 0; var48 < 13; ++var48) {
                                    for(var46 = 0; var46 < 13; ++var46) {
                                       var47 = field364[0][var48][var46];
                                       if(var47 == -1) {
                                          NPC.method759(var48 * 8, 8 * var46, 8, 8);
                                       }
                                    }
                                 }

                                 class22.method556(true);
                                 var48 = 0;

                                 while(true) {
                                    if(var48 >= 4) {
                                       break label1734;
                                    }

                                    class212.method3957();

                                    for(var46 = 0; var46 < 13; ++var46) {
                                       label1657:
                                       for(var47 = 0; var47 < 13; ++var47) {
                                          var6 = field364[var48][var46][var47];
                                          if(var6 != -1) {
                                             var7 = var6 >> 24 & 3;
                                             var79 = var6 >> 1 & 3;
                                             var54 = var6 >> 14 & 1023;
                                             var10 = var6 >> 3 & 2047;
                                             var11 = (var54 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < class16.mapRegions.length; ++var12) {
                                                if(var11 == class16.mapRegions[var12] && null != class174.field2779[var12]) {
                                                   byte[] var55 = class174.field2779[var12];
                                                   var14 = 8 * var46;
                                                   var15 = 8 * var47;
                                                   var16 = 8 * (var54 & 7);
                                                   var17 = (var10 & 7) * 8;
                                                   Region var56 = class128.region;
                                                   CollisionData[] var57 = collisionMaps;
                                                   Buffer var82 = new Buffer(var55);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var82.method2573();
                                                      if(var22 == 0) {
                                                         continue label1657;
                                                      }

                                                      var21 += var22;
                                                      int var58 = 0;

                                                      while(true) {
                                                         int var24 = var82.method2573();
                                                         if(var24 == 0) {
                                                            break;
                                                         }

                                                         var58 += var24 - 1;
                                                         int var25 = var58 & 63;
                                                         int var26 = var58 >> 6 & 63;
                                                         int var27 = var58 >> 12;
                                                         int var28 = var82.method2544();
                                                         int var29 = var28 >> 2;
                                                         int var30 = var28 & 3;
                                                         if(var7 == var27 && var26 >= var16 && var26 < 8 + var16 && var25 >= var17 && var25 < var17 + 8) {
                                                            ObjectComposition var31 = class9.getObjectDefinition(var21);
                                                            int var34 = var26 & 7;
                                                            int var35 = var25 & 7;
                                                            int var37 = var31.field959;
                                                            int var38 = var31.field960;
                                                            int var39;
                                                            if((var30 & 1) == 1) {
                                                               var39 = var37;
                                                               var37 = var38;
                                                               var38 = var39;
                                                            }

                                                            int var36 = var79 & 3;
                                                            int var33;
                                                            if(var36 == 0) {
                                                               var33 = var34;
                                                            } else if(var36 == 1) {
                                                               var33 = var35;
                                                            } else if(var36 == 2) {
                                                               var33 = 7 - var34 - (var37 - 1);
                                                            } else {
                                                               var33 = 7 - var35 - (var38 - 1);
                                                            }

                                                            var39 = var33 + var14;
                                                            int var40 = var15 + class172.method3400(var26 & 7, var25 & 7, var79, var31.field959, var31.field960, var30);
                                                            if(var39 > 0 && var40 > 0 && var39 < 103 && var40 < 103) {
                                                               int var41 = var48;
                                                               if((class5.tileSettings[1][var39][var40] & 2) == 2) {
                                                                  var41 = var48 - 1;
                                                               }

                                                               CollisionData var42 = null;
                                                               if(var41 >= 0) {
                                                                  var42 = var57[var41];
                                                               }

                                                               class21.method544(var48, var39, var40, var21, var30 + var79 & 3, var29, var56, var42);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var48;
                                 }
                              }

                              class212.method3957();

                              for(var46 = 0; var46 < 13; ++var46) {
                                 for(var47 = 0; var47 < 13; ++var47) {
                                    boolean var78 = false;
                                    var7 = field364[var48][var46][var47];
                                    if(var7 != -1) {
                                       var79 = var7 >> 24 & 3;
                                       var54 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = var11 / 8 + (var10 / 8 << 8);

                                       for(var81 = 0; var81 < class16.mapRegions.length; ++var81) {
                                          if(class16.mapRegions[var81] == var12 && class4.field76[var81] != null) {
                                             class126.method2818(class4.field76[var81], var48, var46 * 8, 8 * var47, var79, 8 * (var10 & 7), 8 * (var11 & 7), var54, collisionMaps);
                                             var78 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var78) {
                                       var79 = var48;
                                       var54 = 8 * var46;
                                       var10 = var47 * 8;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class5.tileHeights[var79][var11 + var54][var12 + var10] = 0;
                                          }
                                       }

                                       if(var54 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.tileHeights[var79][var54][var10 + var11] = class5.tileHeights[var79][var54 - 1][var11 + var10];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.tileHeights[var79][var54 + var11][var10] = class5.tileHeights[var79][var11 + var54][var10 - 1];
                                          }
                                       }

                                       if(var54 > 0 && class5.tileHeights[var79][var54 - 1][var10] != 0) {
                                          class5.tileHeights[var79][var54][var10] = class5.tileHeights[var79][var54 - 1][var10];
                                       } else if(var10 > 0 && class5.tileHeights[var79][var54][var10 - 1] != 0) {
                                          class5.tileHeights[var79][var54][var10] = class5.tileHeights[var79][var54][var10 - 1];
                                       } else if(var54 > 0 && var10 > 0 && class5.tileHeights[var79][var54 - 1][var10 - 1] != 0) {
                                          class5.tileHeights[var79][var54][var10] = class5.tileHeights[var79][var54 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var48;
                           }
                        }

                        class22.method556(true);
                        class59.method1267();
                        class212.method3957();
                        ChatMessages.method234(class128.region, collisionMaps);
                        class22.method556(true);
                        var48 = class5.field86;
                        if(var48 > class173.plane) {
                           var48 = class173.plane;
                        }

                        if(var48 < class173.plane - 1) {
                           var48 = class173.plane - 1;
                        }

                        if(field304) {
                           class128.region.method2133(class5.field86);
                        } else {
                           class128.region.method2133(0);
                        }

                        for(var46 = 0; var46 < 104; ++var46) {
                           for(var47 = 0; var47 < 104; ++var47) {
                              class174.groundItemSpawned(var46, var47);
                           }
                        }

                        class212.method3957();
                        Buffer.method2744();
                        ObjectComposition.field947.reset();
                        if(null != class0.field15) {
                           field378.method2801(163);
                           field378.method2709(1057001181);
                        }

                        if(!field351) {
                           var46 = (class125.field2065 - 6) / 8;
                           var47 = (6 + class125.field2065) / 8;
                           var6 = (class18.field280 - 6) / 8;
                           var7 = (6 + class18.field280) / 8;

                           for(var79 = var46 - 1; var79 <= 1 + var47; ++var79) {
                              for(var54 = var6 - 1; var54 <= 1 + var7; ++var54) {
                                 if(var79 < var46 || var79 > var47 || var54 < var6 || var54 > var7) {
                                    class9.field173.method3309("m" + var79 + "_" + var54);
                                    class9.field173.method3309("l" + var79 + "_" + var54);
                                 }
                              }
                           }
                        }

                        class117.setGameState(30);
                        class212.method3957();
                        class5.field102 = null;
                        class5.field88 = null;
                        class5.field89 = null;
                        class5.field90 = null;
                        class5.field107 = null;
                        class35.field801 = null;
                        class5.field91 = null;
                        class5.field92 = null;
                        class172.field2751 = null;
                        class5.field93 = null;
                        class5.field94 = null;
                        class0.field1 = null;
                        field378.method2801(48);
                        class166.method3254();
                     }
                  }
               }
            } else {
               class59.method1264(this);
            }

            if(gameState == 30) {
               if(field317 > 1) {
                  --field317;
               }

               if(field355 > 0) {
                  --field355;
               }

               if(field356) {
                  field356 = false;
                  if(field355 > 0) {
                     Sequence.method902();
                  } else {
                     class117.setGameState(40);
                     class59.field1250 = ObjectComposition.field993;
                     ObjectComposition.field993 = null;
                  }
               } else {
                  if(!isMenuOpen) {
                     menuOptions[0] = "Cancel";
                     menuTargets[0] = "";
                     menuTypes[0] = 1006;
                     menuOptionCount = 1;
                  }

                  for(var45 = 0; var45 < 100 && class171.method3398(); ++var45) {
                     ;
                  }

                  if(gameState == 30) {
                     while(TextureProvider.method2239()) {
                        field378.method2801(146);
                        field378.method2529(0);
                        var45 = field378.offset;
                        class169.method3279(field378);
                        field378.method2563(field378.offset - var45);
                     }

                     Object var66 = field311.field216;
                     synchronized(field311.field216) {
                        if(!field298) {
                           field311.field211 = 0;
                        } else if(class143.field2210 != 0 || field311.field211 >= 40) {
                           field378.method2801(122);
                           field378.method2529(0);
                           var44 = field378.offset;
                           var48 = 0;

                           for(var46 = 0; var46 < field311.field211 && field378.offset - var44 < 240; ++var46) {
                              ++var48;
                              var47 = field311.field209[var46];
                              if(var47 < 0) {
                                 var47 = 0;
                              } else if(var47 > 502) {
                                 var47 = 502;
                              }

                              var6 = field311.field212[var46];
                              if(var6 < 0) {
                                 var6 = 0;
                              } else if(var6 > 764) {
                                 var6 = 764;
                              }

                              var7 = 765 * var47 + var6;
                              if(field311.field209[var46] == -1 && field311.field212[var46] == -1) {
                                 var6 = -1;
                                 var47 = -1;
                                 var7 = 524287;
                              }

                              if(var6 == field536 && field313 == var47) {
                                 if(field370 < 2047) {
                                    ++field370;
                                 }
                              } else {
                                 var79 = var6 - field536;
                                 field536 = var6;
                                 var54 = var47 - field313;
                                 field313 = var47;
                                 if(field370 < 8 && var79 >= -32 && var79 <= 31 && var54 >= -32 && var54 <= 31) {
                                    var79 += 32;
                                    var54 += 32;
                                    field378.method2701(var54 + (var79 << 6) + (field370 << 12));
                                    field370 = 0;
                                 } else if(field370 < 8) {
                                    field378.method2531((field370 << 19) + 8388608 + var7);
                                    field370 = 0;
                                 } else {
                                    field378.method2709(-1073741824 + (field370 << 19) + var7);
                                    field370 = 0;
                                 }
                              }
                           }

                           field378.method2563(field378.offset - var44);
                           if(var48 >= field311.field211) {
                              field311.field211 = 0;
                           } else {
                              field311.field211 -= var48;

                              for(var46 = 0; var46 < field311.field211; ++var46) {
                                 field311.field212[var46] = field311.field212[var46 + var48];
                                 field311.field209[var46] = field311.field209[var48 + var46];
                              }
                           }
                        }
                     }

                     if(class143.field2210 == 1 || !class4.field81 && class143.field2210 == 4 || class143.field2210 == 2) {
                        long var84 = (class143.field2198 - field525) / 50L;
                        if(var84 > 4095L) {
                           var84 = 4095L;
                        }

                        field525 = class143.field2198;
                        var48 = class143.field2212;
                        if(var48 < 0) {
                           var48 = 0;
                        } else if(var48 > class77.field1428) {
                           var48 = class77.field1428;
                        }

                        var46 = class143.field2211;
                        if(var46 < 0) {
                           var46 = 0;
                        } else if(var46 > class62.field1267) {
                           var46 = class62.field1267;
                        }

                        var47 = (int)var84;
                        field378.method2801(57);
                        field378.method2701((var47 << 1) + (class143.field2210 == 2?1:0));
                        field378.method2701(var46);
                        field378.method2701(var48);
                     }

                     if(class140.field2172 > 0) {
                        field378.method2801(224);
                        field378.method2701(0);
                        var45 = field378.offset;
                        long var85 = class34.method738();

                        for(var46 = 0; var46 < class140.field2172; ++var46) {
                           long var88 = var85 - field526;
                           if(var88 > 16777215L) {
                              var88 = 16777215L;
                           }

                           field526 = var85;
                           field378.method2584((int)var88);
                           field378.method2529(class140.field2156[var46]);
                        }

                        field378.method2636(field378.offset - var45);
                     }

                     if(field393 > 0) {
                        --field393;
                     }

                     if(class140.field2165[96] || class140.field2165[97] || class140.field2165[98] || class140.field2165[99]) {
                        field308 = true;
                     }

                     if(field308 && field393 <= 0) {
                        field393 = 20;
                        field308 = false;
                        field378.method2801(45);
                        field378.method2672(field386);
                        field378.method2701(mapAngle);
                     }

                     if(class38.field833 && !field562) {
                        field562 = true;
                        field378.method2801(56);
                        field378.method2529(1);
                     }

                     if(!class38.field833 && field562) {
                        field562 = false;
                        field378.method2801(56);
                        field378.method2529(0);
                     }

                     class23.method563();
                     if(gameState == 30) {
                        for(class16 var67 = (class16)field571.method3845(); null != var67; var67 = (class16)field571.method3847()) {
                           if(var67.field242 > 0) {
                              --var67.field242;
                           }

                           if(var67.field242 == 0) {
                              if(var67.field257 < 0 || class133.method2864(var67.field257, var67.field247)) {
                                 class168.method3274(var67.field252, var67.field246, var67.field243, var67.field260, var67.field257, var67.field241, var67.field247);
                                 var67.unlink();
                              }
                           } else {
                              if(var67.field244 > 0) {
                                 --var67.field244;
                              }

                              if(var67.field244 == 0 && var67.field243 >= 1 && var67.field260 >= 1 && var67.field243 <= 102 && var67.field260 <= 102 && (var67.field248 < 0 || class133.method2864(var67.field248, var67.field250))) {
                                 class168.method3274(var67.field252, var67.field246, var67.field243, var67.field260, var67.field248, var67.field249, var67.field250);
                                 var67.field244 = -1;
                                 if(var67.field257 == var67.field248 && var67.field257 == -1) {
                                    var67.unlink();
                                 } else if(var67.field257 == var67.field248 && var67.field249 == var67.field241 && var67.field247 == var67.field250) {
                                    var67.unlink();
                                 }
                              }
                           }
                        }

                        class31.method666();
                        ++field350;
                        if(field350 > 750) {
                           if(field355 > 0) {
                              Sequence.method902();
                           } else {
                              class117.setGameState(40);
                              class59.field1250 = ObjectComposition.field993;
                              ObjectComposition.field993 = null;
                           }
                        } else {
                           var45 = class34.field779;
                           int[] var68 = class34.field786;

                           for(var48 = 0; var48 < var45; ++var48) {
                              Player var73 = cachedPlayers[var68[var48]];
                              if(null != var73) {
                                 class14.method167(var73, 1);
                              }
                           }

                           for(var45 = 0; var45 < field341; ++var45) {
                              var44 = field342[var45];
                              NPC var71 = cachedNPCs[var44];
                              if(null != var71) {
                                 class14.method167(var71, var71.composition.field910);
                              }
                           }

                           class13.method162();
                           ++field420;
                           if(field413 != 0) {
                              field412 += 20;
                              if(field412 >= 400) {
                                 field413 = 0;
                              }
                           }

                           if(Actor.field895 != null) {
                              ++field414;
                              if(field414 >= 15) {
                                 class32.method673(Actor.field895);
                                 Actor.field895 = null;
                              }
                           }

                           Widget var70 = class53.field1153;
                           Widget var69 = Friend.field267;
                           class53.field1153 = null;
                           Friend.field267 = null;
                           field460 = null;
                           field585 = false;
                           field478 = false;
                           field523 = 0;

                           while(true) {
                              while(NPC.method758() && field523 < 128) {
                                 if(field465 >= 2 && class140.field2165[82] && class20.field597 == 66) {
                                    String var74 = "";

                                    MessageNode var86;
                                    for(Iterator var5 = class11.field192.iterator(); var5.hasNext(); var74 = var74 + var86.name + ':' + var86.value + '\n') {
                                       var86 = (MessageNode)var5.next();
                                    }

                                    GameObject.field1729.setContents(new StringSelection(var74), (ClipboardOwner)null);
                                 } else {
                                    field477[field523] = class20.field597;
                                    field336[field523] = class129.field2093;
                                    ++field523;
                                 }
                              }

                              if(widgetRoot != -1) {
                                 var48 = widgetRoot;
                                 var46 = class62.field1267;
                                 var47 = class77.field1428;
                                 if(class14.method172(var48)) {
                                    class119.method2492(Widget.widgets[var48], -1, 0, 0, var46, var47, 0, 0);
                                 }
                              }

                              ++field485;

                              while(true) {
                                 class0 var72;
                                 Widget var76;
                                 Widget var77;
                                 do {
                                    var72 = (class0)field500.method3859();
                                    if(null == var72) {
                                       while(true) {
                                          do {
                                             var72 = (class0)field501.method3859();
                                             if(null == var72) {
                                                while(true) {
                                                   do {
                                                      var72 = (class0)field522.method3859();
                                                      if(var72 == null) {
                                                         class5.method86();
                                                         if(null != field473) {
                                                            Player.method49();
                                                         }

                                                         if(null != FrameMap.field1821) {
                                                            class32.method673(FrameMap.field1821);
                                                            ++field423;
                                                            if(class143.field2203 != 0) {
                                                               if(field423 >= 5 && (class143.field2204 > field417 + 5 || class143.field2204 < field417 - 5 || class143.field2206 > 5 + field392 || class143.field2206 < field392 - 5)) {
                                                                  field556 = true;
                                                               }
                                                            } else {
                                                               if(field556) {
                                                                  if(FrameMap.field1821 == WidgetNode.field69 && field416 != field454) {
                                                                     Widget var75 = FrameMap.field1821;
                                                                     byte var89 = 0;
                                                                     if(field463 == 1 && var75.contentType == 206) {
                                                                        var89 = 1;
                                                                     }

                                                                     if(var75.itemIds[field454] <= 0) {
                                                                        var89 = 0;
                                                                     }

                                                                     if(class132.method2857(Projectile.method96(var75))) {
                                                                        var47 = field416;
                                                                        var6 = field454;
                                                                        var75.itemIds[var6] = var75.itemIds[var47];
                                                                        var75.itemQuantities[var6] = var75.itemQuantities[var47];
                                                                        var75.itemIds[var47] = -1;
                                                                        var75.itemQuantities[var47] = 0;
                                                                     } else if(var89 == 1) {
                                                                        var47 = field416;
                                                                        var6 = field454;

                                                                        while(var47 != var6) {
                                                                           if(var47 > var6) {
                                                                              var75.method3444(var47 - 1, var47);
                                                                              --var47;
                                                                           } else if(var47 < var6) {
                                                                              var75.method3444(1 + var47, var47);
                                                                              ++var47;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var75.method3444(field454, field416);
                                                                     }

                                                                     field378.method2801(117);
                                                                     field378.method2569(var89);
                                                                     field378.method2731(FrameMap.field1821.id);
                                                                     field378.method2700(field454);
                                                                     field378.method2577(field416);
                                                                  }
                                                               } else if((field440 == 1 || TextureProvider.method2237(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                                  ChatMessages.method235(field417, field392);
                                                               } else if(menuOptionCount > 0) {
                                                                  Frames.method2327(field417, field392);
                                                               }

                                                               field414 = 10;
                                                               class143.field2210 = 0;
                                                               FrameMap.field1821 = null;
                                                            }
                                                         }

                                                         if(Region.field1572 != -1) {
                                                            var48 = Region.field1572;
                                                            var46 = Region.field1511;
                                                            field378.method2801(12);
                                                            field378.method2529(5);
                                                            field378.method2569(class140.field2165[82]?(class140.field2165[81]?2:1):0);
                                                            field378.method2701(DecorativeObject.baseY + var46);
                                                            field378.method2577(class193.baseX + var48);
                                                            Region.field1572 = -1;
                                                            field499 = class143.field2211;
                                                            field411 = class143.field2212;
                                                            field413 = 1;
                                                            field412 = 0;
                                                            flagX = var48;
                                                            flagY = var46;
                                                         }

                                                         if(var70 != class53.field1153) {
                                                            if(var70 != null) {
                                                               class32.method673(var70);
                                                            }

                                                            if(class53.field1153 != null) {
                                                               class32.method673(class53.field1153);
                                                            }
                                                         }

                                                         if(Friend.field267 != var69 && field360 == field452) {
                                                            if(null != var69) {
                                                               class32.method673(var69);
                                                            }

                                                            if(Friend.field267 != null) {
                                                               class32.method673(Friend.field267);
                                                            }
                                                         }

                                                         if(Friend.field267 != null) {
                                                            if(field360 < field452) {
                                                               ++field360;
                                                               if(field360 == field452) {
                                                                  class32.method673(Friend.field267);
                                                               }
                                                            }
                                                         } else if(field360 > 0) {
                                                            --field360;
                                                         }

                                                         var48 = field300 + class138.localPlayer.x;
                                                         var46 = class138.localPlayer.y + field368;
                                                         if(class9.field175 - var48 < -500 || class9.field175 - var48 > 500 || class157.field2342 - var46 < -500 || class157.field2342 - var46 > 500) {
                                                            class9.field175 = var48;
                                                            class157.field2342 = var46;
                                                         }

                                                         if(class9.field175 != var48) {
                                                            class9.field175 += (var48 - class9.field175) / 16;
                                                         }

                                                         if(class157.field2342 != var46) {
                                                            class157.field2342 += (var46 - class157.field2342) / 16;
                                                         }

                                                         if(class143.field2203 == 4 && class4.field81) {
                                                            var47 = class143.field2206 - field391;
                                                            field389 = var47 * 2;
                                                            field391 = var47 != -1 && var47 != 1?(class143.field2206 + field391) / 2:class143.field2206;
                                                            var6 = field390 - class143.field2204;
                                                            field388 = var6 * 2;
                                                            field390 = var6 != -1 && var6 != 1?(field390 + class143.field2204) / 2:class143.field2204;
                                                         } else {
                                                            if(class140.field2165[96]) {
                                                               field388 += (-24 - field388) / 2;
                                                            } else if(class140.field2165[97]) {
                                                               field388 += (24 - field388) / 2;
                                                            } else {
                                                               field388 /= 2;
                                                            }

                                                            if(class140.field2165[98]) {
                                                               field389 += (12 - field389) / 2;
                                                            } else if(class140.field2165[99]) {
                                                               field389 += (-12 - field389) / 2;
                                                            } else {
                                                               field389 /= 2;
                                                            }

                                                            field391 = class143.field2206;
                                                            field390 = class143.field2204;
                                                         }

                                                         mapAngle = mapAngle + field388 / 2 & 2047;
                                                         field386 += field389 / 2;
                                                         if(field386 < 128) {
                                                            field386 = 128;
                                                         }

                                                         if(field386 > 383) {
                                                            field386 = 383;
                                                         }

                                                         var47 = class9.field175 >> 7;
                                                         var6 = class157.field2342 >> 7;
                                                         var7 = class16.method191(class9.field175, class157.field2342, class173.plane);
                                                         var79 = 0;
                                                         if(var47 > 3 && var6 > 3 && var47 < 100 && var6 < 100) {
                                                            for(var54 = var47 - 4; var54 <= var47 + 4; ++var54) {
                                                               for(var10 = var6 - 4; var10 <= 4 + var6; ++var10) {
                                                                  var11 = class173.plane;
                                                                  if(var11 < 3 && (class5.tileSettings[1][var54][var10] & 2) == 2) {
                                                                     ++var11;
                                                                  }

                                                                  var12 = var7 - class5.tileHeights[var11][var54][var10];
                                                                  if(var12 > var79) {
                                                                     var79 = var12;
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         var54 = 192 * var79;
                                                         if(var54 > 98048) {
                                                            var54 = 98048;
                                                         }

                                                         if(var54 < '耀') {
                                                            var54 = '耀';
                                                         }

                                                         if(var54 > field395) {
                                                            field395 += (var54 - field395) / 24;
                                                         } else if(var54 < field395) {
                                                            field395 += (var54 - field395) / 80;
                                                         }

                                                         if(field548) {
                                                            var48 = class117.field2018 * 128 + 64;
                                                            var46 = 64 + BufferProvider.field1445 * 128;
                                                            var47 = class16.method191(var48, var46, class173.plane) - class93.field1617;
                                                            if(ChatLineBuffer.cameraX < var48) {
                                                               ChatLineBuffer.cameraX += class20.field589 + (var48 - ChatLineBuffer.cameraX) * class156.field2330 / 1000;
                                                               if(ChatLineBuffer.cameraX > var48) {
                                                                  ChatLineBuffer.cameraX = var48;
                                                               }
                                                            }

                                                            if(ChatLineBuffer.cameraX > var48) {
                                                               ChatLineBuffer.cameraX -= class20.field589 + class156.field2330 * (ChatLineBuffer.cameraX - var48) / 1000;
                                                               if(ChatLineBuffer.cameraX < var48) {
                                                                  ChatLineBuffer.cameraX = var48;
                                                               }
                                                            }

                                                            if(class28.cameraZ < var47) {
                                                               class28.cameraZ += class20.field589 + (var47 - class28.cameraZ) * class156.field2330 / 1000;
                                                               if(class28.cameraZ > var47) {
                                                                  class28.cameraZ = var47;
                                                               }
                                                            }

                                                            if(class28.cameraZ > var47) {
                                                               class28.cameraZ -= class20.field589 + (class28.cameraZ - var47) * class156.field2330 / 1000;
                                                               if(class28.cameraZ < var47) {
                                                                  class28.cameraZ = var47;
                                                               }
                                                            }

                                                            if(class35.cameraY < var46) {
                                                               class35.cameraY += class156.field2330 * (var46 - class35.cameraY) / 1000 + class20.field589;
                                                               if(class35.cameraY > var46) {
                                                                  class35.cameraY = var46;
                                                               }
                                                            }

                                                            if(class35.cameraY > var46) {
                                                               class35.cameraY -= class20.field589 + class156.field2330 * (class35.cameraY - var46) / 1000;
                                                               if(class35.cameraY < var46) {
                                                                  class35.cameraY = var46;
                                                               }
                                                            }

                                                            var48 = class26.field657 * 128 + 64;
                                                            var46 = class189.field3065 * 128 + 64;
                                                            var47 = class16.method191(var48, var46, class173.plane) - field363;
                                                            var6 = var48 - ChatLineBuffer.cameraX;
                                                            var7 = var47 - class28.cameraZ;
                                                            var79 = var46 - class35.cameraY;
                                                            var54 = (int)Math.sqrt((double)(var6 * var6 + var79 * var79));
                                                            var10 = (int)(Math.atan2((double)var7, (double)var54) * 325.949D) & 2047;
                                                            var11 = (int)(Math.atan2((double)var6, (double)var79) * -325.949D) & 2047;
                                                            if(var10 < 128) {
                                                               var10 = 128;
                                                            }

                                                            if(var10 > 383) {
                                                               var10 = 383;
                                                            }

                                                            if(class22.cameraPitch < var10) {
                                                               class22.cameraPitch += field549 + class9.field172 * (var10 - class22.cameraPitch) / 1000;
                                                               if(class22.cameraPitch > var10) {
                                                                  class22.cameraPitch = var10;
                                                               }
                                                            }

                                                            if(class22.cameraPitch > var10) {
                                                               class22.cameraPitch -= field549 + class9.field172 * (class22.cameraPitch - var10) / 1000;
                                                               if(class22.cameraPitch < var10) {
                                                                  class22.cameraPitch = var10;
                                                               }
                                                            }

                                                            var12 = var11 - class168.cameraYaw;
                                                            if(var12 > 1024) {
                                                               var12 -= 2048;
                                                            }

                                                            if(var12 < -1024) {
                                                               var12 += 2048;
                                                            }

                                                            if(var12 > 0) {
                                                               class168.cameraYaw += class9.field172 * var12 / 1000 + field549;
                                                               class168.cameraYaw &= 2047;
                                                            }

                                                            if(var12 < 0) {
                                                               class168.cameraYaw -= -var12 * class9.field172 / 1000 + field549;
                                                               class168.cameraYaw &= 2047;
                                                            }

                                                            var81 = var11 - class168.cameraYaw;
                                                            if(var81 > 1024) {
                                                               var81 -= 2048;
                                                            }

                                                            if(var81 < -1024) {
                                                               var81 += 2048;
                                                            }

                                                            if(var81 < 0 && var12 > 0 || var81 > 0 && var12 < 0) {
                                                               class168.cameraYaw = var11;
                                                            }
                                                         }

                                                         for(var48 = 0; var48 < 5; ++var48) {
                                                            ++field504[var48];
                                                         }

                                                         class5.chatMessages.method226();
                                                         var48 = ++class143.mouseIdleTicks - 1;
                                                         var47 = class140.keyboardIdleTicks;
                                                         if(var48 > 15000 && var47 > 15000) {
                                                            field355 = 250;
                                                            class143.mouseIdleTicks = 14500;
                                                            field378.method2801(97);
                                                         }

                                                         ++field372;
                                                         if(field372 > 500) {
                                                            field372 = 0;
                                                            var7 = (int)(Math.random() * 8.0D);
                                                            if((var7 & 1) == 1) {
                                                               field300 += field483;
                                                            }

                                                            if((var7 & 2) == 2) {
                                                               field368 += field369;
                                                            }

                                                            if((var7 & 4) == 4) {
                                                               field498 += field371;
                                                            }
                                                         }

                                                         if(field300 < -50) {
                                                            field483 = 2;
                                                         }

                                                         if(field300 > 50) {
                                                            field483 = -2;
                                                         }

                                                         if(field368 < -55) {
                                                            field369 = 2;
                                                         }

                                                         if(field368 > 55) {
                                                            field369 = -2;
                                                         }

                                                         if(field498 < -40) {
                                                            field371 = 1;
                                                         }

                                                         if(field498 > 40) {
                                                            field371 = -1;
                                                         }

                                                         ++field377;
                                                         if(field377 > 500) {
                                                            field377 = 0;
                                                            var7 = (int)(Math.random() * 8.0D);
                                                            if((var7 & 1) == 1) {
                                                               mapScale += field374;
                                                            }

                                                            if((var7 & 2) == 2) {
                                                               mapScaleDelta += field437;
                                                            }
                                                         }

                                                         if(mapScale < -60) {
                                                            field374 = 2;
                                                         }

                                                         if(mapScale > 60) {
                                                            field374 = -2;
                                                         }

                                                         if(mapScaleDelta < -20) {
                                                            field437 = 1;
                                                         }

                                                         if(mapScaleDelta > 10) {
                                                            field437 = -1;
                                                         }

                                                         for(class40 var87 = (class40)field503.method3804(); var87 != null; var87 = (class40)field503.method3810()) {
                                                            if((long)var87.field897 < class34.method738() / 1000L - 5L) {
                                                               if(var87.field903 > 0) {
                                                                  class110.method2416(5, "", var87.field901 + " has logged in.");
                                                               }

                                                               if(var87.field903 == 0) {
                                                                  class110.method2416(5, "", var87.field901 + " has logged out.");
                                                               }

                                                               var87.method3944();
                                                            }
                                                         }

                                                         ++field480;
                                                         if(field480 > 50) {
                                                            field378.method2801(210);
                                                         }

                                                         try {
                                                            if(ObjectComposition.field993 != null && field378.offset > 0) {
                                                               ObjectComposition.field993.method3028(field378.payload, 0, field378.offset);
                                                               field378.offset = 0;
                                                               field480 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var61) {
                                                            if(field355 > 0) {
                                                               Sequence.method902();
                                                            } else {
                                                               class117.setGameState(40);
                                                               class59.field1250 = ObjectComposition.field993;
                                                               ObjectComposition.field993 = null;
                                                            }

                                                            return;
                                                         }

                                                         return;
                                                      }

                                                      var76 = var72.field13;
                                                      if(var76.index < 0) {
                                                         break;
                                                      }

                                                      var77 = class173.method3412(var76.parentId);
                                                   } while(var77 == null || var77.children == null || var76.index >= var77.children.length || var76 != var77.children[var76.index]);

                                                   class12.method155(var72);
                                                }
                                             }

                                             var76 = var72.field13;
                                             if(var76.index < 0) {
                                                break;
                                             }

                                             var77 = class173.method3412(var76.parentId);
                                          } while(null == var77 || null == var77.children || var76.index >= var77.children.length || var77.children[var76.index] != var76);

                                          class12.method155(var72);
                                       }
                                    }

                                    var76 = var72.field13;
                                    if(var76.index < 0) {
                                       break;
                                    }

                                    var77 = class173.method3412(var76.parentId);
                                 } while(var77 == null || var77.children == null || var76.index >= var77.children.length || var77.children[var76.index] != var76);

                                 class12.method155(var72);
                              }
                           }
                        }
                     }
                  }
               }
            } else if(gameState == 40 || gameState == 45) {
               class129.method2848();
            }

            return;
         }

         var1.field2749.method3373(var1.field2750, (int)var1.hash, var1.field2748, false);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-14217"
   )
   protected final void vmethod3054() {
      class51.field1126 = field514 == 0?'ꩊ':'鱀' + world;
      ItemLayer.field1731 = field514 == 0?443:world + '썐';
      class75.field1408 = class51.field1126;
      PlayerComposition.field2975 = class177.field2937;
      Friend.field272 = class177.field2938;
      PlayerComposition.field2976 = class177.field2939;
      PlayerComposition.field2977 = class177.field2940;
      if(class93.field1614.toLowerCase().indexOf("microsoft") != -1) {
         class140.field2176[186] = 57;
         class140.field2176[187] = 27;
         class140.field2176[188] = 71;
         class140.field2176[189] = 26;
         class140.field2176[190] = 72;
         class140.field2176[191] = 73;
         class140.field2176[192] = 58;
         class140.field2176[219] = 42;
         class140.field2176[220] = 74;
         class140.field2176[221] = 43;
         class140.field2176[222] = 59;
         class140.field2176[223] = 28;
      } else {
         class140.field2176[44] = 71;
         class140.field2176[45] = 26;
         class140.field2176[46] = 72;
         class140.field2176[47] = 73;
         class140.field2176[59] = 57;
         class140.field2176[61] = 27;
         class140.field2176[91] = 42;
         class140.field2176[92] = 74;
         class140.field2176[93] = 43;
         class140.field2176[192] = 28;
         class140.field2176[222] = 58;
         class140.field2176[520] = 59;
      }

      Renderable.method1949(class164.canvas);
      class75.method1612(class164.canvas);
      ItemComposition.field1217 = class14.method169();
      if(null != ItemComposition.field1217) {
         ItemComposition.field1217.vmethod3136(class164.canvas);
      }

      class56.field1221 = new class137(255, class152.field2286, class152.field2285, 500000);
      Player.field42 = class23.method561();
      GameObject.field1729 = this.getToolkit().getSystemClipboard();
      String var2 = class31.field726;
      class141.field2190 = this;
      class141.field2184 = var2;
      if(field514 != 0) {
         field316 = true;
      }

      int var3 = Player.field42.field161;
      field422 = 0L;
      if(var3 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      class143.method3010();
      if(gameState >= 25) {
         class75.method1610();
      }

      GameEngine.field2253 = true;
   }

   public final void init() {
      if(this.method3046()) {
         class193[] var1 = class140.method2942();

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            class193 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3125);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3125)) {
               case 1:
                  WidgetNode.field72 = var4;
                  break;
               case 2:
                  class175.field2785 = Integer.parseInt(var4);
                  break;
               case 3:
                  var6 = Integer.parseInt(var4);
                  class156[] var7 = new class156[]{class156.field2321, class156.field2322, class156.field2323, class156.field2326};
                  class156[] var8 = var7;
                  int var9 = 0;

                  class156 var21;
                  while(true) {
                     if(var9 >= var8.length) {
                        var21 = null;
                        break;
                     }

                     class156 var10 = var8[var9];
                     if(var6 == var10.field2327) {
                        var21 = var10;
                        break;
                     }

                     ++var9;
                  }

                  class112.field1955 = var21;
                  break;
               case 4:
                  world = Integer.parseInt(var4);
                  break;
               case 5:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 6:
                  class4.field79 = var4;
               case 7:
               case 8:
               case 13:
               default:
                  break;
               case 9:
                  field344 = Integer.parseInt(var4);
                  break;
               case 10:
                  class157[] var5 = new class157[]{class157.field2333, class157.field2339, class157.field2332, class157.field2340, class157.field2337, class157.field2334};
                  class114.field2004 = (class157)class140.method2957(var5, Integer.parseInt(var4));
                  if(class114.field2004 == class157.field2337) {
                     field302 = class215.field3189;
                  } else {
                     field302 = class215.field3196;
                  }
                  break;
               case 11:
                  field514 = Integer.parseInt(var4);
                  break;
               case 12:
                  flags = Integer.parseInt(var4);
                  break;
               case 14:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 15:
                  field310 = Integer.parseInt(var4);
               }
            }
         }

         Region.field1518 = false;
         field304 = false;
         class48.host = this.getCodeBase().getHost();
         String var17 = class112.field1955.field2325;
         byte var18 = 0;

         try {
            class152.field2282 = 16;
            class77.field1426 = var18;

            try {
               class124.field2059 = System.getProperty("os.name");
            } catch (Exception var15) {
               class124.field2059 = "Unknown";
            }

            DecorativeObject.field1657 = class124.field2059.toLowerCase();

            try {
               class152.field2280 = System.getProperty("user.home");
               if(class152.field2280 != null) {
                  class152.field2280 = class152.field2280 + "/";
               }
            } catch (Exception var14) {
               ;
            }

            try {
               if(DecorativeObject.field1657.startsWith("win")) {
                  if(class152.field2280 == null) {
                     class152.field2280 = System.getenv("USERPROFILE");
                  }
               } else if(class152.field2280 == null) {
                  class152.field2280 = System.getenv("HOME");
               }

               if(class152.field2280 != null) {
                  class152.field2280 = class152.field2280 + "/";
               }
            } catch (Exception var13) {
               ;
            }

            if(class152.field2280 == null) {
               class152.field2280 = "~/";
            }

            class124.field2050 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class152.field2280, "/tmp/", ""};
            FrameMap.field1817 = new String[]{".jagex_cache_" + class77.field1426, ".file_store_" + class77.field1426};

            label123:
            for(int var11 = 0; var11 < 4; ++var11) {
               class152.field2281 = class133.method2865("oldschool", var17, var11);
               if(!class152.field2281.exists()) {
                  class152.field2281.mkdirs();
               }

               File[] var20 = class152.field2281.listFiles();
               if(null == var20) {
                  break;
               }

               File[] var22 = var20;
               var6 = 0;

               while(true) {
                  if(var6 >= var22.length) {
                     break label123;
                  }

                  File var23 = var22[var6];
                  if(!class85.method1924(var23, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            File var19 = class152.field2281;
            Frames.field1829 = var19;
            if(!Frames.field1829.exists()) {
               throw new RuntimeException("");
            }

            class138.field2133 = true;
            class141.method2972();
            class152.field2286 = new class231(new FileOnDisk(class10.method130("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class152.field2285 = new class231(new FileOnDisk(class10.method130("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class118.field2025 = new class231[class152.field2282];

            for(int var12 = 0; var12 < class152.field2282; ++var12) {
               class118.field2025[var12] = new class231(new FileOnDisk(class10.method130("main_file_cache.idx" + var12), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var16) {
            class93.method2139((String)null, var16);
         }

         class168.field2706 = this;
         this.method3065(765, 503, 126);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-152826336"
   )
   protected final void vmethod3056() {
      boolean var1;
      label244: {
         try {
            if(class186.field3010 == 2) {
               if(null == class52.field1143) {
                  class52.field1143 = class183.method3551(class35.field800, FrameMap.field1823, class186.field3015);
                  if(class52.field1143 == null) {
                     var1 = false;
                     break label244;
                  }
               }

               if(class14.field219 == null) {
                  class14.field219 = new class62(class186.field3012, class186.field3014);
               }

               if(class186.field3013.method3664(class52.field1143, class186.field3011, class14.field219, 22050)) {
                  class186.field3013.method3628();
                  class186.field3013.method3625(class186.field3016);
                  class186.field3013.method3629(class52.field1143, class186.field3017);
                  class186.field3010 = 0;
                  class52.field1143 = null;
                  class14.field219 = null;
                  class35.field800 = null;
                  var1 = true;
                  break label244;
               }
            }
         } catch (Exception var20) {
            var20.printStackTrace();
            class186.field3013.method3725();
            class186.field3010 = 0;
            class52.field1143 = null;
            class14.field219 = null;
            class35.field800 = null;
         }

         var1 = false;
      }

      if(var1 && field539 && null != World.field683) {
         World.field683.method1217();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(field422 != 0L && class34.method738() > field422) {
            int var3 = isResized?2:1;
            field422 = 0L;
            if(var3 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            class143.method3010();
            if(gameState >= 25) {
               class75.method1610();
            }

            GameEngine.field2253 = true;
         } else if(GameEngine.field2246) {
            class152.method3163();
         }
      }

      Dimension var13 = this.method3060();
      if(var13.width != class116.field2012 || class18.field276 != var13.height || GameEngine.field2247) {
         class143.method3010();
         field422 = class34.method738() + 500L;
         GameEngine.field2247 = false;
      }

      boolean var4 = false;
      int var5;
      if(GameEngine.field2253) {
         GameEngine.field2253 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field494[var5] = true;
         }
      }

      if(var4) {
         Buffer.method2743();
      }

      if(gameState == 0) {
         var5 = class33.field756;
         String var6 = class33.field769;
         Color var7 = null;

         try {
            Graphics var8 = class164.canvas.getGraphics();
            if(World.field684 == null) {
               World.field684 = new Font("Helvetica", 1, 13);
               class171.field2746 = class164.canvas.getFontMetrics(World.field684);
            }

            if(var4) {
               var8.setColor(Color.black);
               var8.fillRect(0, 0, class62.field1267, class77.field1428);
            }

            if(var7 == null) {
               var7 = new Color(140, 17, 17);
            }

            try {
               if(FrameMap.field1824 == null) {
                  FrameMap.field1824 = class164.canvas.createImage(304, 34);
               }

               Graphics var9 = FrameMap.field1824.getGraphics();
               var9.setColor(var7);
               var9.drawRect(0, 0, 303, 33);
               var9.fillRect(2, 2, var5 * 3, 30);
               var9.setColor(Color.black);
               var9.drawRect(1, 1, 301, 31);
               var9.fillRect(var5 * 3 + 2, 2, 300 - 3 * var5, 30);
               var9.setFont(World.field684);
               var9.setColor(Color.white);
               var9.drawString(var6, (304 - class171.field2746.stringWidth(var6)) / 2, 22);
               var8.drawImage(FrameMap.field1824, class62.field1267 / 2 - 152, class77.field1428 / 2 - 18, (ImageObserver)null);
            } catch (Exception var16) {
               int var10 = class62.field1267 / 2 - 152;
               int var11 = class77.field1428 / 2 - 18;
               var8.setColor(var7);
               var8.drawRect(var10, var11, 303, 33);
               var8.fillRect(var10 + 2, 2 + var11, var5 * 3, 30);
               var8.setColor(Color.black);
               var8.drawRect(var10 + 1, var11 + 1, 301, 31);
               var8.fillRect(var10 + 2 + var5 * 3, 2 + var11, 300 - 3 * var5, 30);
               var8.setFont(World.field684);
               var8.setColor(Color.white);
               var8.drawString(var6, var10 + (304 - class171.field2746.stringWidth(var6)) / 2, var11 + 22);
            }
         } catch (Exception var17) {
            class164.canvas.repaint();
         }
      } else if(gameState == 5) {
         class128.method2840(MessageNode.field811, class32.field737, class136.field2123, var4);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class128.method2840(MessageNode.field811, class32.field737, class136.field2123, var4);
         } else if(gameState == 25) {
            if(field361 == 1) {
               if(field357 > field358) {
                  field358 = field357;
               }

               var5 = (field358 * 50 - field357 * 50) / field358;
               class165.method3226("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field361 == 2) {
               if(field359 > field301) {
                  field301 = field359;
               }

               var5 = (field301 * 50 - field359 * 50) / field301 + 50;
               class165.method3226("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class165.method3226("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            class162.method3198();
         } else if(gameState == 40) {
            class165.method3226("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class165.method3226("Please wait...", false);
         }
      } else {
         class128.method2840(MessageNode.field811, class32.field737, class136.field2123, var4);
      }

      Graphics var14;
      int var15;
      if(gameState == 30 && field402 == 0 && !var4) {
         try {
            var14 = class164.canvas.getGraphics();

            for(var15 = 0; var15 < field425; ++var15) {
               if(field506[var15]) {
                  class220.bufferProvider.drawSub(var14, widgetPositionX[var15], widgetPositionY[var15], widgetBoundsWidth[var15], widgetBoundsHeight[var15]);
                  field506[var15] = false;
               }
            }
         } catch (Exception var19) {
            class164.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var14 = class164.canvas.getGraphics();
            class220.bufferProvider.draw(var14, 0, 0);

            for(var15 = 0; var15 < field425; ++var15) {
               field506[var15] = false;
            }
         } catch (Exception var18) {
            class164.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1683293182"
   )
   static int method527() {
      return 9;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "-125819446"
   )
   public static byte[] method528(CharSequence var0) {
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
