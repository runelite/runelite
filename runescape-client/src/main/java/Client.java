import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1439342253
   )
   static int field263;
   @ObfuscatedName("t")
   static boolean field264 = true;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -27650683
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 300835801
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 366512275
   )
   static int field267 = 0;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -595737969
   )
   static int field268;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 943141275
   )
   static int field269;
   @ObfuscatedName("im")
   static boolean field270;
   @ObfuscatedName("u")
   static boolean field271 = false;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -2130317395
   )
   static int field272;
   @ObfuscatedName("a")
   static String field273;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1610985325
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("c")
   static boolean field275 = true;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = 696997369
   )
   static int field276;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 7119236675331104561L
   )
   static long field277 = 1L;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 381798659
   )
   static int field278 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -719900277
   )
   static int field279 = -1;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -891400247
   )
   static int field280;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("am")
   static boolean field282 = false;
   @ObfuscatedName("jd")
   static Widget field283;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -674578981
   )
   static int field284;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1539027811
   )
   static int field285 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1002954577
   )
   static int field286 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1795757091
   )
   static int field287 = 0;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -1000444261
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 2110724747
   )
   static int field289;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 2018681585
   )
   static int field290 = 0;
   @ObfuscatedName("hz")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("ad")
   static class21 field292;
   @ObfuscatedName("aj")
   static class21 field293;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1594186805
   )
   static int field295;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 781320281
   )
   static int field296;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 1699546725
   )
   static int field297;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -759712527
   )
   static int field298;
   @ObfuscatedName("bm")
   static class171 field299;
   @ObfuscatedName("cw")
   static class125 field300;
   @ObfuscatedName("kl")
   static Deque field301;
   @ObfuscatedName("om")
   static short field302;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -294856613
   )
   static int field303;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1335501827
   )
   static int field304;
   @ObfuscatedName("cg")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ih")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ca")
   static int[] field307;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1012111181
   )
   static int field308;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -482556729
   )
   static int field309;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -982425021
   )
   static int field310 = 0;
   @ObfuscatedName("cl")
   static class125 field311;
   @ObfuscatedName("ce")
   static class125 field312;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -656595967
   )
   static int field313;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1032485077
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("nl")
   static int[] field315;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -883883365
   )
   static int field316;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 135190555
   )
   static int field317;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -110830309
   )
   static int field318;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1489558301
   )
   static int field319;
   @ObfuscatedName("lr")
   static boolean[] field320;
   @ObfuscatedName("kt")
   static int[] field321;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 1962041659
   )
   static int field322;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -955581583
   )
   static int field323;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = -315343643
   )
   static int field324;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1297910143
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = -1720464835
   )
   static int field326;
   @ObfuscatedName("dv")
   static int[] field327;
   @ObfuscatedName("hc")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 881764005
   )
   static int field329;
   @ObfuscatedName("dm")
   static int[][][] field330;
   @ObfuscatedName("dy")
   static final int[] field331;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -1824346085
   )
   static int field332;
   @ObfuscatedName("ii")
   static String field333;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 1452124293
   )
   static int field334;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 1798066125
   )
   static int field335;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -998784665
   )
   static int field336;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 469838479
   )
   static int field337;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 1261421987
   )
   static int field338;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1535343967
   )
   static int field339;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -815032095
   )
   static int field340;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -860849801
   )
   static int field341;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1235593125
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -211032909
   )
   static int field343;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -360793291
   )
   static int field344;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 840176913
   )
   static int field345;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1810642859
   )
   static int field346 = 0;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 360143909
   )
   static int field347;
   @ObfuscatedName("ek")
   static SpritePixels[] field348;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 714466175
   )
   static int field349;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1735515935
   )
   static int field350 = 0;
   @ObfuscatedName("gv")
   static String[] field351;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 2058228943
   )
   static int field352;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 881009527
   )
   static int field353;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -1768273647
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("or")
   static int[] field355;
   @ObfuscatedName("gs")
   static boolean field356;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -325084943
   )
   static int field357;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 906511533
   )
   static int field358;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 1575218617
   )
   static int field359;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 1185999703
   )
   static int field360;
   @ObfuscatedName("ff")
   static boolean field361;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 471594075
   )
   static int field362;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -756866445
   )
   static int field363;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1631692739
   )
   static int field364;
   @ObfuscatedName("fo")
   static int[] field365;
   @ObfuscatedName("fw")
   static int[] field366;
   @ObfuscatedName("fx")
   static int[] field367;
   @ObfuscatedName("fp")
   static int[] field368;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 1560791917
   )
   static int field369;
   @ObfuscatedName("fa")
   static int[] field370;
   @ObfuscatedName("fh")
   static int[] field371;
   @ObfuscatedName("hw")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("gr")
   static int[][] field373;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 452010545
   )
   static int field374;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 210295757
   )
   static int field375;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1721135065
   )
   static int field376;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 789422399
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -710921089
   )
   static int field378;
   @ObfuscatedName("ki")
   static boolean[] field379;
   @ObfuscatedName("lj")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 1086575053
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ez")
   static boolean field382;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1020373369
   )
   static int field383;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 2143951197
   )
   static int field384;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 1748087525
   )
   static int field385;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 8889297
   )
   static int field386;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -549485015
   )
   static int field387;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -777811075
   )
   static int field388;
   @ObfuscatedName("z")
   static Client field389;
   @ObfuscatedName("gy")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("jr")
   static Widget field391;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 2138605177
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 706032123
   )
   static int field393;
   @ObfuscatedName("he")
   static int[] field394;
   @ObfuscatedName("hl")
   static final int[] field395;
   @ObfuscatedName("hi")
   static String[] field396;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1519729931
   )
   static int field397;
   @ObfuscatedName("hj")
   static int[] field398;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -517702005
   )
   static int field399;
   @ObfuscatedName("hk")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("hf")
   static Deque field401;
   @ObfuscatedName("hb")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hu")
   static Deque field403;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 1700458273
   )
   static int field404;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 1865209919
   )
   static int field405;
   @ObfuscatedName("hm")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1181139831
   )
   static int field407;
   @ObfuscatedName("hv")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 1893421765
   )
   static int field409;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1568320443
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 1383374845
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("hx")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("fd")
   static int[] field413;
   @ObfuscatedName("iq")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("ia")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("iv")
   static String field416;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1769529721
   )
   static int field417 = 0;
   @ObfuscatedName("cb")
   static int[] field418;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 1844550179
   )
   static int field419;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -442078463
   )
   static int field420;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 232807091
   )
   static int field421;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 1945669857
   )
   static int field422;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -1404095145
   )
   static int field423;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = -1724046203
   )
   static int field424;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 1537840203
   )
   static int field425;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 976539595
   )
   static int field426;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 1805320179
   )
   static int field427;
   @ObfuscatedName("dq")
   static boolean field428;
   @ObfuscatedName("it")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -1640243977
   )
   static int field430;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 719170801
   )
   static int field431;
   @ObfuscatedName("jl")
   static Widget field432;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1687702319
   )
   static int field433 = 0;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -459897289
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -282504369
   )
   static int field435;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 1284506355
   )
   static int field436;
   @ObfuscatedName("jq")
   static boolean field437;
   @ObfuscatedName("jb")
   static boolean field438;
   @ObfuscatedName("ji")
   static boolean field439;
   @ObfuscatedName("je")
   static Widget field440;
   @ObfuscatedName("jt")
   static Widget field441;
   @ObfuscatedName("lg")
   static int[] field442;
   @ObfuscatedName("bh")
   static class171 field443;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 108461539
   )
   static int field444;
   @ObfuscatedName("pm")
   static int[] field445;
   @ObfuscatedName("ja")
   static boolean field446;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -895467373
   )
   static int field447;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 1748949043
   )
   static int field448;
   @ObfuscatedName("jw")
   static boolean field449;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 958898471
   )
   static int field450;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 575839345
   )
   static int field451;
   @ObfuscatedName("ld")
   static boolean[] field452;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -804258041
   )
   static int field453;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1181113669
   )
   static int field454;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 1992237373
   )
   static int field455;
   @ObfuscatedName("ko")
   static int[] field456;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -1293453117
   )
   static int field457;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 1700109093
   )
   static int field458;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -1463063933
   )
   static int field459;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -1152609825
   )
   static int field460;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -762128447
   )
   static int field461;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -435672157
   )
   static int field462;
   @ObfuscatedName("oq")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -2004525771
   )
   static int field464;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 695601873
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("k")
   static class157 field466;
   @ObfuscatedName("kk")
   static Deque field467;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -1881878523
   )
   static int field468;
   @ObfuscatedName("ka")
   static Deque field469;
   @ObfuscatedName("kw")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1674155801
   )
   static int field471 = -1;
   @ObfuscatedName("km")
   static int[] field472;
   @ObfuscatedName("jh")
   static boolean field473;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -793436299
   )
   static int field474;
   @ObfuscatedName("ah")
   static boolean field475 = true;
   @ObfuscatedName("lb")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("lp")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("li")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("lw")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = -1759279853
   )
   static int field480;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      longValue = -6370830948397793763L
   )
   static long field481;
   @ObfuscatedName("nq")
   static int[] field482;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 602233973
   )
   static int field483;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = 330708781
   )
   static int field484;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 951187873
   )
   static int field485;
   @ObfuscatedName("r")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -280566827
   )
   static int field487;
   @ObfuscatedName("la")
   static String field488;
   @ObfuscatedName("lh")
   static long[] field489;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -2081796557
   )
   static int field490;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 67347887
   )
   static int field491;
   @ObfuscatedName("ll")
   static int[] field492;
   @ObfuscatedName("mo")
   static int[] field493;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      longValue = -56692684970300159L
   )
   static long field494;
   @ObfuscatedName("mm")
   static String field495;
   @ObfuscatedName("mr")
   static String field496;
   @ObfuscatedName("ic")
   static String field497;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = 205764765
   )
   static int field498;
   @ObfuscatedName("mf")
   static int[] field499;
   @ObfuscatedName("mc")
   static int[] field500;
   @ObfuscatedName("mk")
   static SpritePixels[] field501;
   @ObfuscatedName("io")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 1793789763
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -483184759
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 889467593
   )
   static int field505;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 729923435
   )
   static int field506;
   @ObfuscatedName("ms")
   static boolean field507;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -1158477991
   )
   static int field508;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 183512349
   )
   static int field509;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 78926835
   )
   static int field510;
   @ObfuscatedName("np")
   static int[] field511;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 1763357873
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ha")
   static boolean[] field513;
   @ObfuscatedName("no")
   static int[] field514;
   @ObfuscatedName("nc")
   static class61[] field515;
   @ObfuscatedName("nm")
   static boolean field516;
   @ObfuscatedName("nn")
   static boolean[] field517;
   @ObfuscatedName("h")
   static class215 field518;
   @ObfuscatedName("oh")
   static int[] field519;
   @ObfuscatedName("on")
   static short field520;
   @ObfuscatedName("og")
   static int[] field521;
   @ObfuscatedName("oc")
   static short field522;
   @ObfuscatedName("ox")
   static short field523;
   @ObfuscatedName("oa")
   static short field524;
   @ObfuscatedName("os")
   static short field525;
   @ObfuscatedName("ob")
   static int[] field526;
   @ObfuscatedName("ni")
   static class59 field527;
   @ObfuscatedName("of")
   static short field528;
   @ObfuscatedName("oy")
   static short field529;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = -1231946963
   )
   static int field530;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 1608903213
   )
   static int field531;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = -504930707
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("cn")
   static boolean field533;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = -1103651653
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -1497134611
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = -1516356205
   )
   static int field536;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = -491275259
   )
   static int field537;
   @ObfuscatedName("ov")
   static class198 field538;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1670469351
   )
   static int field539;
   @ObfuscatedName("ok")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("ow")
   static PlayerComposition field541;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = -1104068657
   )
   static int field542;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -389536143
   )
   static int field543;
   @ObfuscatedName("pj")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      longValue = 2126954329985699445L
   )
   static long field545;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      longValue = 5426990256613018911L
   )
   static long field546;
   @ObfuscatedName("ps")
   static final class10 field547;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 2110304335
   )
   static int field548;
   @ObfuscatedName("pt")
   static int[] field549;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 515966877
   )
   static int field550 = 0;
   @ObfuscatedName("dd")
   static byte[][] field551;

   public final void init() {
      if(this.method3092()) {
         class193[] var1 = new class193[]{class193.field3105, class193.field3114, class193.field3108, class193.field3113, class193.field3106, class193.field3115, class193.field3117, class193.field3112, class193.field3110, class193.field3111, class193.field3107, class193.field3116, class193.field3104, class193.field3109, class193.field3118};
         class193[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class193 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3119);
            if(null != var5) {
               switch(Integer.parseInt(var4.field3119)) {
               case 2:
                  field346 = Integer.parseInt(var5);
                  break;
               case 3:
                  world = Integer.parseInt(var5);
                  break;
               case 4:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 5:
                  flags = Integer.parseInt(var5);
                  break;
               case 6:
                  World.field642 = Integer.parseInt(var5);
                  break;
               case 7:
                  int var7 = Integer.parseInt(var5);
                  class156[] var8 = new class156[]{class156.field2323, class156.field2319, class156.field2317, class156.field2320};
                  class156[] var9 = var8;
                  int var10 = 0;

                  class156 var16;
                  while(true) {
                     if(var10 >= var9.length) {
                        var16 = null;
                        break;
                     }

                     class156 var11 = var9[var10];
                     if(var11.field2321 == var7) {
                        var16 = var11;
                        break;
                     }

                     ++var10;
                  }

                  GameEngine.field2247 = var16;
                  break;
               case 8:
                  field267 = Integer.parseInt(var5);
                  break;
               case 9:
                  field273 = var5;
                  break;
               case 10:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 11:
                  class75.field1395 = Integer.parseInt(var5);
                  break;
               case 12:
                  class157[] var6 = new class157[]{class157.field2332, class157.field2329, class157.field2327, class157.field2336, class157.field2328, class157.field2331};
                  field466 = (class157)SecondaryBufferProvider.method1646(var6, Integer.parseInt(var5));
                  if(class157.field2329 == field466) {
                     field518 = class215.field3190;
                  } else {
                     field518 = class215.field3185;
                  }
               case 13:
               case 14:
               default:
                  break;
               case 15:
                  class178.field2947 = var5;
               }
            }
         }

         Region.field1521 = false;
         field271 = false;
         class38.host = this.getCodeBase().getHost();
         String var15 = GameEngine.field2247.field2316;
         byte var12 = 0;

         try {
            method530("oldschool", var15, var12, 16);
         } catch (Exception var14) {
            class144.method2970((String)null, var14);
         }

         field389 = this;
         this.method3010(765, 503, 123);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method232();
      class161.method3160();
      VertexNormal.method2177();
      class12.method162();
      class54.method1067();
      class143 var1 = class143.mouse;
      synchronized(class143.mouse) {
         class143.field2184 = class143.field2182;
         class143.field2192 = class143.field2187;
         class143.field2189 = class143.field2186;
         class143.field2198 = class143.field2190;
         class143.field2188 = class143.field2191;
         class143.field2196 = class143.field2183;
         class143.field2197 = class143.field2193;
         class143.field2190 = 0;
      }

      int var17;
      if(null != class168.field2712) {
         var17 = class168.field2712.vmethod3100();
         field335 = var17;
      }

      if(gameState == 0) {
         class114.method2397();
         ItemLayer.method2181();
      } else if(gameState == 5) {
         class20.method538(this);
         class114.method2397();
         ItemLayer.method2181();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class20.method538(this);
            class22.method565();
         } else if(gameState == 25) {
            Actor.method775();
         }
      } else {
         class20.method538(this);
      }

      if(gameState == 30) {
         if(field290 > 1) {
            --field290;
         }

         if(field548 > 0) {
            --field548;
         }

         if(field533) {
            field533 = false;
            if(field548 > 0) {
               class152.method3138();
            } else {
               class112.setGameState(40);
               class75.field1394 = class32.field695;
               class32.field695 = null;
            }
         } else {
            if(!isMenuOpen) {
               menuOptions[0] = "Cancel";
               menuTargets[0] = "";
               menuTypes[0] = 1006;
               menuOptionCount = 1;
            }

            for(var17 = 0; var17 < 100 && WidgetNode.method42(); ++var17) {
               ;
            }

            if(gameState == 30) {
               while(true) {
                  ClassInfo var2 = (ClassInfo)class214.field3181.method3850();
                  boolean var35;
                  if(var2 == null) {
                     var35 = false;
                  } else {
                     var35 = true;
                  }

                  int var18;
                  if(!var35) {
                     Object var28 = class18.field244.field185;
                     int var3;
                     int var4;
                     int var5;
                     int var6;
                     int var7;
                     int var8;
                     int var9;
                     synchronized(class18.field244.field185) {
                        if(!field264) {
                           class18.field244.field187 = 0;
                        } else if(class143.field2198 != 0 || class18.field244.field187 >= 40) {
                           field300.method2748(155);
                           field300.method2467(0);
                           var18 = field300.offset;
                           var3 = 0;

                           for(var4 = 0; var4 < class18.field244.field187 && field300.offset - var18 < 240; ++var4) {
                              ++var3;
                              var5 = class18.field244.field188[var4];
                              if(var5 < 0) {
                                 var5 = 0;
                              } else if(var5 > 502) {
                                 var5 = 502;
                              }

                              var6 = class18.field244.field186[var4];
                              if(var6 < 0) {
                                 var6 = 0;
                              } else if(var6 > 764) {
                                 var6 = 764;
                              }

                              var7 = 765 * var5 + var6;
                              if(class18.field244.field188[var4] == -1 && class18.field244.field186[var4] == -1) {
                                 var6 = -1;
                                 var5 = -1;
                                 var7 = 524287;
                              }

                              if(field278 == var6 && var5 == field279) {
                                 if(field471 < 2047) {
                                    ++field471;
                                 }
                              } else {
                                 var8 = var6 - field278;
                                 field278 = var6;
                                 var9 = var5 - field279;
                                 field279 = var5;
                                 if(field471 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                    var8 += 32;
                                    var9 += 32;
                                    field300.method2468(var9 + (field471 << 12) + (var8 << 6));
                                    field471 = 0;
                                 } else if(field471 < 8) {
                                    field300.method2523(var7 + 8388608 + (field471 << 19));
                                    field471 = 0;
                                 } else {
                                    field300.method2642(-1073741824 + (field471 << 19) + var7);
                                    field471 = 0;
                                 }
                              }
                           }

                           field300.method2478(field300.offset - var18);
                           if(var3 >= class18.field244.field187) {
                              class18.field244.field187 = 0;
                           } else {
                              class18.field244.field187 -= var3;

                              for(var4 = 0; var4 < class18.field244.field187; ++var4) {
                                 class18.field244.field186[var4] = class18.field244.field186[var4 + var3];
                                 class18.field244.field188[var4] = class18.field244.field188[var3 + var4];
                              }
                           }
                        }
                     }

                     if(class143.field2198 == 1 || !class18.field245 && class143.field2198 == 4 || class143.field2198 == 2) {
                        long var37 = (class143.field2197 - field277 * -1L) / 50L;
                        if(var37 > 4095L) {
                           var37 = 4095L;
                        }

                        field277 = class143.field2197 * -1L;
                        var3 = class143.field2196;
                        if(var3 < 0) {
                           var3 = 0;
                        } else if(var3 > class139.field2143) {
                           var3 = class139.field2143;
                        }

                        var4 = class143.field2188;
                        if(var4 < 0) {
                           var4 = 0;
                        } else if(var4 > class50.field1069) {
                           var4 = class50.field1069;
                        }

                        var5 = (int)var37;
                        field300.method2748(77);
                        field300.method2468((var5 << 1) + (class143.field2198 == 2?1:0));
                        field300.method2468(var4);
                        field300.method2468(var3);
                     }

                     if(class140.field2164 > 0) {
                        field300.method2748(227);
                        field300.method2468(0);
                        var17 = field300.offset;
                        long var36 = class113.method2394();

                        for(var4 = 0; var4 < class140.field2164; ++var4) {
                           long var33 = var36 - field494;
                           if(var33 > 16777215L) {
                              var33 = 16777215L;
                           }

                           field494 = var36;
                           field300.method2521((int)var33);
                           field300.method2466(class140.field2168[var4]);
                        }

                        field300.method2632(field300.offset - var17);
                     }

                     if(field360 > 0) {
                        --field360;
                     }

                     if(class140.field2157[96] || class140.field2157[97] || class140.field2157[98] || class140.field2157[99]) {
                        field361 = true;
                     }

                     if(field361 && field360 <= 0) {
                        field360 = 20;
                        field361 = false;
                        field300.method2748(159);
                        field300.method2513(field353);
                        field300.method2514(mapAngle);
                     }

                     if(class85.field1475 && !field475) {
                        field475 = true;
                        field300.method2748(52);
                        field300.method2467(1);
                     }

                     if(!class85.field1475 && field475) {
                        field475 = false;
                        field300.method2748(52);
                        field300.method2467(0);
                     }

                     int var11;
                     int var19;
                     int[] var30;
                     if(class59.plane != field451) {
                        field451 = class59.plane;
                        var17 = class59.plane;
                        var30 = class11.field166.image;
                        var3 = var30.length;

                        for(var4 = 0; var4 < var3; ++var4) {
                           var30[var4] = 0;
                        }

                        var4 = 1;

                        while(true) {
                           if(var4 >= 103) {
                              var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                              var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                              class11.field166.method1702();

                              for(var6 = 1; var6 < 103; ++var6) {
                                 for(var7 = 1; var7 < 103; ++var7) {
                                    if((class5.tileSettings[var17][var7][var6] & 24) == 0) {
                                       TextureProvider.method2174(var17, var7, var6, var4, var5);
                                    }

                                    if(var17 < 3 && (class5.tileSettings[var17 + 1][var7][var6] & 8) != 0) {
                                       TextureProvider.method2174(1 + var17, var7, var6, var4, var5);
                                    }
                                 }
                              }

                              field498 = 0;

                              for(var6 = 0; var6 < 104; ++var6) {
                                 for(var7 = 0; var7 < 104; ++var7) {
                                    var8 = class114.region.method1944(class59.plane, var6, var7);
                                    if(var8 != 0) {
                                       var8 = var8 >> 14 & 32767;
                                       var9 = class40.getObjectDefinition(var8).field936;
                                       if(var9 >= 0) {
                                          var19 = var6;
                                          var11 = var7;
                                          if(var9 != 22 && var9 != 29 && var9 != 34 && var9 != 36 && var9 != 46 && var9 != 47 && var9 != 48) {
                                             int[][] var14 = collisionMaps[class59.plane].flags;

                                             for(int var15 = 0; var15 < 10; ++var15) {
                                                int var16 = (int)(Math.random() * 4.0D);
                                                if(var16 == 0 && var19 > 0 && var19 > var6 - 3 && (var14[var19 - 1][var11] & 19136776) == 0) {
                                                   --var19;
                                                }

                                                if(var16 == 1 && var19 < 103 && var19 < var6 + 3 && (var14[var19 + 1][var11] & 19136896) == 0) {
                                                   ++var19;
                                                }

                                                if(var16 == 2 && var11 > 0 && var11 > var7 - 3 && (var14[var19][var11 - 1] & 19136770) == 0) {
                                                   --var11;
                                                }

                                                if(var16 == 3 && var11 < 103 && var11 < var7 + 3 && (var14[var19][var11 + 1] & 19136800) == 0) {
                                                   ++var11;
                                                }
                                             }
                                          }

                                          field501[field498] = class172.field2753[var9];
                                          field499[field498] = var19;
                                          field500[field498] = var11;
                                          ++field498;
                                       }
                                    }
                                 }
                              }

                              Player.bufferProvider.method1682();
                              break;
                           }

                           var5 = 2048 * (103 - var4) + 24628;

                           for(var6 = 1; var6 < 103; ++var6) {
                              if((class5.tileSettings[var17][var6][var4] & 24) == 0) {
                                 class114.region.method1958(var30, var5, 512, var17, var6, var4);
                              }

                              if(var17 < 3 && (class5.tileSettings[var17 + 1][var6][var4] & 8) != 0) {
                                 class114.region.method1958(var30, var5, 512, var17 + 1, var6, var4);
                              }

                              var5 += 4;
                           }

                           ++var4;
                        }
                     }

                     if(gameState == 30) {
                        for(class16 var29 = (class16)field401.method3808(); var29 != null; var29 = (class16)field401.method3810()) {
                           if(var29.field211 > 0) {
                              --var29.field211;
                           }

                           if(var29.field211 == 0) {
                              if(var29.field207 < 0 || class160.method3159(var29.field207, var29.field213)) {
                                 class22.method569(var29.field215, var29.field208, var29.field209, var29.field221, var29.field207, var29.field212, var29.field213);
                                 var29.unlink();
                              }
                           } else {
                              if(var29.field210 > 0) {
                                 --var29.field210;
                              }

                              if(var29.field210 == 0 && var29.field209 >= 1 && var29.field221 >= 1 && var29.field209 <= 102 && var29.field221 <= 102) {
                                 if(var29.field214 >= 0) {
                                    var3 = var29.field214;
                                    var4 = var29.field218;
                                    ObjectComposition var20 = class40.getObjectDefinition(var3);
                                    if(var4 == 11) {
                                       var4 = 10;
                                    }

                                    if(var4 >= 5 && var4 <= 8) {
                                       var4 = 4;
                                    }

                                    boolean var38 = var20.method826(var4);
                                    if(!var38) {
                                       continue;
                                    }
                                 }

                                 class22.method569(var29.field215, var29.field208, var29.field209, var29.field221, var29.field214, var29.field217, var29.field218);
                                 var29.field210 = -1;
                                 if(var29.field214 == var29.field207 && var29.field207 == -1) {
                                    var29.unlink();
                                 } else if(var29.field207 == var29.field214 && var29.field217 == var29.field212 && var29.field213 == var29.field218) {
                                    var29.unlink();
                                 }
                              }
                           }
                        }

                        class16.method189();
                        ++field272;
                        if(field272 > 750) {
                           if(field548 > 0) {
                              class152.method3138();
                           } else {
                              class112.setGameState(40);
                              class75.field1394 = class32.field695;
                              class32.field695 = null;
                           }
                        } else {
                           var17 = class34.field743;
                           var30 = class34.field739;

                           for(var3 = 0; var3 < var17; ++var3) {
                              Player var21 = cachedPlayers[var30[var3]];
                              if(var21 != null) {
                                 class16.method188(var21, 1);
                              }
                           }

                           class166.method3214();
                           class9.method122();
                           ++field297;
                           if(field468 != 0) {
                              field539 += 20;
                              if(field539 >= 400) {
                                 field468 = 0;
                              }
                           }

                           if(NPCComposition.field873 != null) {
                              ++field334;
                              if(field334 >= 15) {
                                 class32.method685(NPCComposition.field873);
                                 NPCComposition.field873 = null;
                              }
                           }

                           Widget var31 = ItemComposition.field1196;
                           Widget var32 = class38.field793;
                           ItemComposition.field1196 = null;
                           class38.field793 = null;
                           field283 = null;
                           field449 = false;
                           field446 = false;
                           field491 = 0;

                           while(true) {
                              while(class4.method44() && field491 < 128) {
                                 if(field435 >= 2 && class140.field2157[82] && class162.field2650 == 66) {
                                    String var41 = "";

                                    MessageNode var22;
                                    for(Iterator var39 = class11.field168.iterator(); var39.hasNext(); var41 = var41 + var22.name + ':' + var22.value + '\n') {
                                       var22 = (MessageNode)var39.next();
                                    }

                                    Friend.field229.setContents(new StringSelection(var41), (ClipboardOwner)null);
                                 } else {
                                    field493[field491] = class162.field2650;
                                    field492[field491] = class130.field2084;
                                    ++field491;
                                 }
                              }

                              if(widgetRoot != -1) {
                                 var3 = widgetRoot;
                                 var4 = class50.field1069;
                                 var5 = class139.field2143;
                                 if(class174.method3393(var3)) {
                                    class22.method567(Widget.widgets[var3], -1, 0, 0, var4, var5, 0, 0);
                                 }
                              }

                              ++field453;

                              while(true) {
                                 class0 var23;
                                 Widget var40;
                                 Widget var43;
                                 do {
                                    var23 = (class0)field301.method3806();
                                    if(var23 == null) {
                                       while(true) {
                                          do {
                                             var23 = (class0)field469.method3806();
                                             if(var23 == null) {
                                                while(true) {
                                                   do {
                                                      var23 = (class0)field467.method3806();
                                                      if(null == var23) {
                                                         class53.method1061();
                                                         if(null != field441) {
                                                            class32.method685(field441);
                                                            ++class155.field2311;
                                                            if(field449 && field446) {
                                                               var3 = class143.field2192;
                                                               var4 = class143.field2189;
                                                               var3 -= field280;
                                                               var4 -= field444;
                                                               if(var3 < field404) {
                                                                  var3 = field404;
                                                               }

                                                               if(field441.width + var3 > field391.width + field404) {
                                                                  var3 = field404 + field391.width - field441.width;
                                                               }

                                                               if(var4 < field336) {
                                                                  var4 = field336;
                                                               }

                                                               if(field441.height + var4 > field336 + field391.height) {
                                                                  var4 = field336 + field391.height - field441.height;
                                                               }

                                                               var5 = var3 - field450;
                                                               var6 = var4 - field474;
                                                               var7 = field441.field2874;
                                                               if(class155.field2311 > field441.field2909 && (var5 > var7 || var5 < -var7 || var6 > var7 || var6 < -var7)) {
                                                                  field473 = true;
                                                               }

                                                               var8 = var3 - field404 + field391.itemId;
                                                               var9 = field391.scrollY + (var4 - field336);
                                                               class0 var10;
                                                               if(field441.field2848 != null && field473) {
                                                                  var10 = new class0();
                                                                  var10.field2 = field441;
                                                                  var10.field10 = var8;
                                                                  var10.field1 = var9;
                                                                  var10.field5 = field441.field2848;
                                                                  MessageNode.method754(var10);
                                                               }

                                                               if(class143.field2184 == 0) {
                                                                  if(field473) {
                                                                     if(field441.field2888 != null) {
                                                                        var10 = new class0();
                                                                        var10.field2 = field441;
                                                                        var10.field10 = var8;
                                                                        var10.field1 = var9;
                                                                        var10.field3 = field283;
                                                                        var10.field5 = field441.field2888;
                                                                        MessageNode.method754(var10);
                                                                     }

                                                                     if(field283 != null && class35.method730(field441) != null) {
                                                                        field300.method2748(22);
                                                                        field300.method2468(field283.item);
                                                                        field300.method2565(field283.id);
                                                                        field300.method2524(field441.id);
                                                                        field300.method2513(field441.index);
                                                                        field300.method2514(field441.item);
                                                                        field300.method2655(field283.index);
                                                                     }
                                                                  } else if((field407 == 1 || class75.method1584(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                                     World.method654(field280 + field450, field444 + field474);
                                                                  } else if(menuOptionCount > 0) {
                                                                     var19 = field450 + field280;
                                                                     var11 = field444 + field474;
                                                                     class32 var12 = class47.field1022;
                                                                     class43.menuAction(var12.field699, var12.field691, var12.field692, var12.field693, var12.field694, var12.field694, var19, var11);
                                                                     class47.field1022 = null;
                                                                  }

                                                                  field441 = null;
                                                               }
                                                            } else if(class155.field2311 > 1) {
                                                               field441 = null;
                                                            }
                                                         }

                                                         if(SecondaryBufferProvider.field1414 != null) {
                                                            class32.method685(SecondaryBufferProvider.field1414);
                                                            ++field388;
                                                            if(class143.field2184 != 0) {
                                                               if(field388 >= 5 && (class143.field2192 > 5 + field384 || class143.field2192 < field384 - 5 || class143.field2189 > field385 + 5 || class143.field2189 < field385 - 5)) {
                                                                  field356 = true;
                                                               }
                                                            } else {
                                                               if(field356) {
                                                                  if(class35.field762 == SecondaryBufferProvider.field1414 && field386 != field383) {
                                                                     Widget var45 = SecondaryBufferProvider.field1414;
                                                                     byte var34 = 0;
                                                                     if(field458 == 1 && var45.contentType == 206) {
                                                                        var34 = 1;
                                                                     }

                                                                     if(var45.itemIds[field386] <= 0) {
                                                                        var34 = 0;
                                                                     }

                                                                     if(class20.method532(class11.method138(var45))) {
                                                                        var5 = field383;
                                                                        var6 = field386;
                                                                        var45.itemIds[var6] = var45.itemIds[var5];
                                                                        var45.itemQuantities[var6] = var45.itemQuantities[var5];
                                                                        var45.itemIds[var5] = -1;
                                                                        var45.itemQuantities[var5] = 0;
                                                                     } else if(var34 == 1) {
                                                                        var5 = field383;
                                                                        var6 = field386;

                                                                        while(var5 != var6) {
                                                                           if(var5 > var6) {
                                                                              var45.method3402(var5 - 1, var5);
                                                                              --var5;
                                                                           } else if(var5 < var6) {
                                                                              var45.method3402(var5 + 1, var5);
                                                                              ++var5;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var45.method3402(field386, field383);
                                                                     }

                                                                     field300.method2748(222);
                                                                     field300.method2514(field383);
                                                                     field300.method2557(SecondaryBufferProvider.field1414.id);
                                                                     field300.method2468(field386);
                                                                     field300.method2611(var34);
                                                                  }
                                                               } else if((field407 == 1 || class75.method1584(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                                  World.method654(field384, field385);
                                                               } else if(menuOptionCount > 0) {
                                                                  var3 = field384;
                                                                  var4 = field385;
                                                                  class32 var42 = class47.field1022;
                                                                  class43.menuAction(var42.field699, var42.field691, var42.field692, var42.field693, var42.field694, var42.field694, var3, var4);
                                                                  class47.field1022 = null;
                                                               }

                                                               field334 = 10;
                                                               class143.field2198 = 0;
                                                               SecondaryBufferProvider.field1414 = null;
                                                            }
                                                         }

                                                         if(Region.field1507 != -1) {
                                                            var3 = Region.field1507;
                                                            var4 = Region.field1541;
                                                            field300.method2748(144);
                                                            field300.method2467(5);
                                                            field300.method2513(class8.baseY + var4);
                                                            field300.method2514(var3 + class23.baseX);
                                                            field300.method2505(class140.field2157[82]?(class140.field2157[81]?2:1):0);
                                                            Region.field1507 = -1;
                                                            field454 = class143.field2188;
                                                            field378 = class143.field2196;
                                                            field468 = 1;
                                                            field539 = 0;
                                                            flagX = var3;
                                                            flagY = var4;
                                                         }

                                                         if(ItemComposition.field1196 != var31) {
                                                            if(null != var31) {
                                                               class32.method685(var31);
                                                            }

                                                            if(null != ItemComposition.field1196) {
                                                               class32.method685(ItemComposition.field1196);
                                                            }
                                                         }

                                                         if(class38.field793 != var32 && field448 == field419) {
                                                            if(null != var32) {
                                                               class32.method685(var32);
                                                            }

                                                            if(class38.field793 != null) {
                                                               class32.method685(class38.field793);
                                                            }
                                                         }

                                                         if(null != class38.field793) {
                                                            if(field419 < field448) {
                                                               ++field419;
                                                               if(field419 == field448) {
                                                                  class32.method685(class38.field793);
                                                               }
                                                            }
                                                         } else if(field419 > 0) {
                                                            --field419;
                                                         }

                                                         var3 = TextureProvider.localPlayer.x + field485;
                                                         var4 = TextureProvider.localPlayer.y + field447;
                                                         if(XClanMember.field614 - var3 < -500 || XClanMember.field614 - var3 > 500 || class116.field1996 - var4 < -500 || class116.field1996 - var4 > 500) {
                                                            XClanMember.field614 = var3;
                                                            class116.field1996 = var4;
                                                         }

                                                         if(var3 != XClanMember.field614) {
                                                            XClanMember.field614 += (var3 - XClanMember.field614) / 16;
                                                         }

                                                         if(class116.field1996 != var4) {
                                                            class116.field1996 += (var4 - class116.field1996) / 16;
                                                         }

                                                         if(class143.field2184 == 4 && class18.field245) {
                                                            var5 = class143.field2189 - field358;
                                                            field289 = var5 * 2;
                                                            field358 = var5 != -1 && var5 != 1?(class143.field2189 + field358) / 2:class143.field2189;
                                                            var6 = field357 - class143.field2192;
                                                            field422 = var6 * 2;
                                                            field357 = var6 != -1 && var6 != 1?(class143.field2192 + field357) / 2:class143.field2192;
                                                         } else {
                                                            if(class140.field2157[96]) {
                                                               field422 += (-24 - field422) / 2;
                                                            } else if(class140.field2157[97]) {
                                                               field422 += (24 - field422) / 2;
                                                            } else {
                                                               field422 /= 2;
                                                            }

                                                            if(class140.field2157[98]) {
                                                               field289 += (12 - field289) / 2;
                                                            } else if(class140.field2157[99]) {
                                                               field289 += (-12 - field289) / 2;
                                                            } else {
                                                               field289 /= 2;
                                                            }

                                                            field358 = class143.field2189;
                                                            field357 = class143.field2192;
                                                         }

                                                         mapAngle = mapAngle + field422 / 2 & 2047;
                                                         field353 += field289 / 2;
                                                         if(field353 < 128) {
                                                            field353 = 128;
                                                         }

                                                         if(field353 > 383) {
                                                            field353 = 383;
                                                         }

                                                         var5 = XClanMember.field614 >> 7;
                                                         var6 = class116.field1996 >> 7;
                                                         var7 = class79.method1656(XClanMember.field614, class116.field1996, class59.plane);
                                                         var8 = 0;
                                                         if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                            for(var9 = var5 - 4; var9 <= 4 + var5; ++var9) {
                                                               for(var19 = var6 - 4; var19 <= var6 + 4; ++var19) {
                                                                  var11 = class59.plane;
                                                                  if(var11 < 3 && (class5.tileSettings[1][var9][var19] & 2) == 2) {
                                                                     ++var11;
                                                                  }

                                                                  int var24 = var7 - class5.tileHeights[var11][var9][var19];
                                                                  if(var24 > var8) {
                                                                     var8 = var24;
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         var9 = var8 * 192;
                                                         if(var9 > 98048) {
                                                            var9 = 98048;
                                                         }

                                                         if(var9 < '耀') {
                                                            var9 = '耀';
                                                         }

                                                         if(var9 > field490) {
                                                            field490 += (var9 - field490) / 24;
                                                         } else if(var9 < field490) {
                                                            field490 += (var9 - field490) / 80;
                                                         }

                                                         if(field516) {
                                                            Ignore.method103();
                                                         }

                                                         for(var3 = 0; var3 < 5; ++var3) {
                                                            ++field521[var3];
                                                         }

                                                         class141.chatMessages.method204();
                                                         var3 = Tile.method2257();
                                                         var4 = class132.method2824();
                                                         if(var3 > 15000 && var4 > 15000) {
                                                            field548 = 250;
                                                            class143.mouseIdleTicks = 14500;
                                                            field300.method2748(110);
                                                         }

                                                         ++field339;
                                                         if(field339 > 500) {
                                                            field339 = 0;
                                                            var5 = (int)(Math.random() * 8.0D);
                                                            if((var5 & 1) == 1) {
                                                               field485 += field431;
                                                            }

                                                            if((var5 & 2) == 2) {
                                                               field447 += field409;
                                                            }

                                                            if((var5 & 4) == 4) {
                                                               field337 += field338;
                                                            }
                                                         }

                                                         if(field485 < -50) {
                                                            field431 = 2;
                                                         }

                                                         if(field485 > 50) {
                                                            field431 = -2;
                                                         }

                                                         if(field447 < -55) {
                                                            field409 = 2;
                                                         }

                                                         if(field447 > 55) {
                                                            field409 = -2;
                                                         }

                                                         if(field337 < -40) {
                                                            field338 = 1;
                                                         }

                                                         if(field337 > 40) {
                                                            field338 = -1;
                                                         }

                                                         ++field344;
                                                         if(field344 > 500) {
                                                            field344 = 0;
                                                            var5 = (int)(Math.random() * 8.0D);
                                                            if((var5 & 1) == 1) {
                                                               mapScale += field341;
                                                            }

                                                            if((var5 & 2) == 2) {
                                                               mapScaleDelta += field343;
                                                            }
                                                         }

                                                         if(mapScale < -60) {
                                                            field341 = 2;
                                                         }

                                                         if(mapScale > 60) {
                                                            field341 = -2;
                                                         }

                                                         if(mapScaleDelta < -20) {
                                                            field343 = 1;
                                                         }

                                                         if(mapScaleDelta > 10) {
                                                            field343 = -1;
                                                         }

                                                         for(class40 var44 = (class40)field538.method3768(); null != var44; var44 = (class40)field538.method3770()) {
                                                            if((long)var44.field866 < class113.method2394() / 1000L - 5L) {
                                                               if(var44.field865 > 0) {
                                                                  Player.sendGameMessage(5, "", var44.field863 + " has logged in.");
                                                               }

                                                               if(var44.field865 == 0) {
                                                                  Player.sendGameMessage(5, "", var44.field863 + " has logged out.");
                                                               }

                                                               var44.method3916();
                                                            }
                                                         }

                                                         ++field316;
                                                         if(field316 > 50) {
                                                            field300.method2748(91);
                                                         }

                                                         try {
                                                            if(class32.field695 != null && field300.offset > 0) {
                                                               class32.field695.method2987(field300.payload, 0, field300.offset);
                                                               field300.offset = 0;
                                                               field316 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var26) {
                                                            if(field548 > 0) {
                                                               class152.method3138();
                                                            } else {
                                                               class112.setGameState(40);
                                                               class75.field1394 = class32.field695;
                                                               class32.field695 = null;
                                                            }

                                                            return;
                                                         }

                                                         return;
                                                      }

                                                      var43 = var23.field2;
                                                      if(var43.index < 0) {
                                                         break;
                                                      }

                                                      var40 = class92.method2078(var43.parentId);
                                                   } while(null == var40 || var40.children == null || var43.index >= var40.children.length || var43 != var40.children[var43.index]);

                                                   MessageNode.method754(var23);
                                                }
                                             }

                                             var43 = var23.field2;
                                             if(var43.index < 0) {
                                                break;
                                             }

                                             var40 = class92.method2078(var43.parentId);
                                          } while(null == var40 || null == var40.children || var43.index >= var40.children.length || var40.children[var43.index] != var43);

                                          MessageNode.method754(var23);
                                       }
                                    }

                                    var43 = var23.field2;
                                    if(var43.index < 0) {
                                       break;
                                    }

                                    var40 = class92.method2078(var43.parentId);
                                 } while(null == var40 || var40.children == null || var43.index >= var40.children.length || var43 != var40.children[var43.index]);

                                 MessageNode.method754(var23);
                              }
                           }
                        }
                     }
                     break;
                  }

                  field300.method2748(212);
                  field300.method2467(0);
                  var18 = field300.offset;
                  class171.method3368(field300);
                  field300.method2478(field300.offset - var18);
               }
            }
         }
      } else if(gameState == 40 || gameState == 45) {
         class22.method565();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   protected final void vmethod3020() {
      boolean var1 = FrameMap.method2260();
      if(var1 && field507 && null != class22.field576) {
         class22.field576.method1179();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field481 && class113.method2394() > field481) {
            class23.method576(class158.method3158());
         } else if(GameEngine.field2244) {
            TextureProvider.method2173(Frames.canvas);
            class45.method913(Frames.canvas);
            if(class168.field2712 != null) {
               class168.field2712.vmethod3097(Frames.canvas);
            }

            field389.method3008();
            Frames.canvas.setBackground(Color.black);
            class40.method782(Frames.canvas);
            class145.method2980(Frames.canvas);
            if(class168.field2712 != null) {
               class168.field2712.vmethod3107(Frames.canvas);
            }

            if(widgetRoot != -1) {
               class11.method135(widgetRoot, class50.field1069, class139.field2143, false);
            }

            GameEngine.field2230 = true;
         }
      }

      Dimension var2 = this.method3033();
      if(var2.width != class177.field2942 || class137.field2111 != var2.height || GameEngine.field2230) {
         class118.method2422();
         field481 = class113.method2394() + 500L;
         GameEngine.field2230 = false;
      }

      boolean var3 = false;
      int var4;
      if(GameEngine.field2229) {
         GameEngine.field2229 = false;
         var3 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field379[var4] = true;
         }
      }

      if(var3) {
         class9.method121();
      }

      int var9;
      int var10;
      int var16;
      if(gameState == 0) {
         var4 = class33.field718;
         String var5 = class33.field719;
         Color var6 = null;

         try {
            Graphics var7 = Frames.canvas.getGraphics();
            if(null == class8.field131) {
               class8.field131 = new Font("Helvetica", 1, 13);
               class47.field1028 = Frames.canvas.getFontMetrics(class8.field131);
            }

            if(var3) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, class50.field1069, class139.field2143);
            }

            if(var6 == null) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(null == class59.field1236) {
                  class59.field1236 = Frames.canvas.createImage(304, 34);
               }

               Graphics var8 = class59.field1236.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, 3 * var4, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(2 + var4 * 3, 2, 300 - var4 * 3, 30);
               var8.setFont(class8.field131);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - class47.field1028.stringWidth(var5)) / 2, 22);
               var7.drawImage(class59.field1236, class50.field1069 / 2 - 152, class139.field2143 / 2 - 18, (ImageObserver)null);
            } catch (Exception var24) {
               var9 = class50.field1069 / 2 - 152;
               var10 = class139.field2143 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(var9 + 2, 2 + var10, var4 * 3, 30);
               var7.setColor(Color.black);
               var7.drawRect(1 + var9, var10 + 1, 301, 31);
               var7.fillRect(2 + var9 + 3 * var4, 2 + var10, 300 - var4 * 3, 30);
               var7.setFont(class8.field131);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - class47.field1028.stringWidth(var5)) / 2, var10 + 22);
            }
         } catch (Exception var25) {
            Frames.canvas.repaint();
         }
      } else if(gameState == 5) {
         class50.method992(class117.field2001, class92.field1590, class218.field3204, var3);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class50.method992(class117.field2001, class92.field1590, class218.field3204, var3);
         } else if(gameState == 25) {
            if(field329 == 1) {
               if(field322 > field323) {
                  field323 = field322;
               }

               var4 = (field323 * 50 - field322 * 50) / field323;
               class22.method555("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field329 == 2) {
               if(field324 > field340) {
                  field340 = field324;
               }

               var4 = 50 + (field340 * 50 - field324 * 50) / field340;
               class22.method555("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class22.method555("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            if(widgetRoot != -1) {
               var4 = widgetRoot;
               if(class174.method3393(var4)) {
                  MessageNode.method748(Widget.widgets[var4], -1);
               }
            }

            for(var4 = 0; var4 < field298; ++var4) {
               if(field379[var4]) {
                  field452[var4] = true;
               }

               field320[var4] = field379[var4];
               field379[var4] = false;
            }

            field505 = gameCycle;
            field427 = -1;
            field405 = -1;
            class35.field762 = null;
            if(widgetRoot != -1) {
               field298 = 0;
               class151.method3122(widgetRoot, 0, 0, class50.field1069, class139.field2143, 0, 0, -1);
            }

            class82.method1794();
            int var11;
            int var17;
            int var18;
            if(!isMenuOpen) {
               if(field427 != -1) {
                  class53.method1059(field427, field405);
               }
            } else {
               var4 = menuX;
               var16 = class54.menuY;
               var17 = class129.menuWidth;
               var18 = class192.menuHeight;
               int var19 = 6116423;
               class82.method1801(var4, var16, var17, var18, var19);
               class82.method1801(var4 + 1, var16 + 1, var17 - 2, 16, 0);
               class82.method1815(1 + var4, var16 + 18, var17 - 2, var18 - 19, 0);
               class117.field2001.method4032("Choose Option", 3 + var4, var16 + 14, var19, -1);
               var9 = class143.field2192;
               var10 = class143.field2189;

               for(var11 = 0; var11 < menuOptionCount; ++var11) {
                  int var12 = 31 + var16 + (menuOptionCount - 1 - var11) * 15;
                  int var13 = 16777215;
                  if(var9 > var4 && var9 < var17 + var4 && var10 > var12 - 13 && var10 < var12 + 3) {
                     var13 = 16776960;
                  }

                  class227 var14 = class117.field2001;
                  String var15;
                  if(menuTargets[var11].length() > 0) {
                     var15 = menuOptions[var11] + " " + menuTargets[var11];
                  } else {
                     var15 = menuOptions[var11];
                  }

                  var14.method4032(var15, var4 + 3, var12, var13, 0);
               }

               class48.method961(menuX, class54.menuY, class129.menuWidth, class192.menuHeight);
            }

            if(field480 == 3) {
               for(var4 = 0; var4 < field298; ++var4) {
                  if(field320[var4]) {
                     class82.method1800(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4], 16711935, 128);
                  } else if(field452[var4]) {
                     class82.method1800(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4], 16711680, 128);
                  }
               }
            }

            var4 = class59.plane;
            var16 = TextureProvider.localPlayer.x;
            var17 = TextureProvider.localPlayer.y;
            var18 = field297;

            for(class24 var28 = (class24)class24.field590.method3808(); null != var28; var28 = (class24)class24.field590.method3810()) {
               if(var28.field597 != -1 || var28.field605 != null) {
                  var9 = 0;
                  if(var16 > var28.field601) {
                     var9 += var16 - var28.field601;
                  } else if(var16 < var28.field594) {
                     var9 += var28.field594 - var16;
                  }

                  if(var17 > var28.field595) {
                     var9 += var17 - var28.field595;
                  } else if(var17 < var28.field593) {
                     var9 += var28.field593 - var17;
                  }

                  if(var9 - 64 <= var28.field596 && field303 != 0 && var4 == var28.field591) {
                     var9 -= 64;
                     if(var9 < 0) {
                        var9 = 0;
                     }

                     var10 = field303 * (var28.field596 - var9) / var28.field596;
                     Object var10000;
                     if(var28.field598 == null) {
                        if(var28.field597 >= 0) {
                           var10000 = null;
                           class61 var20 = class61.method1254(field443, var28.field597, 0);
                           if(var20 != null) {
                              class65 var21 = var20.method1245().method1288(KitDefinition.field1004);
                              class67 var22 = class67.method1308(var21, 100, var10);
                              var22.method1311(-1);
                              class75.field1389.method1143(var22);
                              var28.field598 = var22;
                           }
                        }
                     } else {
                        var28.field598.method1312(var10);
                     }

                     if(null == var28.field599) {
                        if(var28.field605 != null && (var28.field602 -= var18) <= 0) {
                           var11 = (int)(Math.random() * (double)var28.field605.length);
                           var10000 = null;
                           class61 var30 = class61.method1254(field443, var28.field605[var11], 0);
                           if(var30 != null) {
                              class65 var31 = var30.method1245().method1288(KitDefinition.field1004);
                              class67 var29 = class67.method1308(var31, 100, var10);
                              var29.method1311(0);
                              class75.field1389.method1143(var29);
                              var28.field599 = var29;
                              var28.field602 = var28.field592 + (int)(Math.random() * (double)(var28.field600 - var28.field592));
                           }
                        }
                     } else {
                        var28.field599.method1312(var10);
                        if(!var28.field599.linked()) {
                           var28.field599 = null;
                        }
                     }
                  } else {
                     if(var28.field598 != null) {
                        class75.field1389.method1144(var28.field598);
                        var28.field598 = null;
                     }

                     if(null != var28.field599) {
                        class75.field1389.method1144(var28.field599);
                        var28.field599 = null;
                     }
                  }
               }
            }

            field297 = 0;
         } else if(gameState == 40) {
            class22.method555("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class22.method555("Please wait...", false);
         }
      } else {
         class50.method992(class117.field2001, class92.field1590, class218.field3204, var3);
      }

      Graphics var23;
      if(gameState == 30 && field480 == 0 && !var3) {
         try {
            var23 = Frames.canvas.getGraphics();

            for(var16 = 0; var16 < field298; ++var16) {
               if(field452[var16]) {
                  Player.bufferProvider.drawSub(var23, widgetPositionX[var16], widgetPositionY[var16], widgetBoundsWidth[var16], widgetBoundsHeight[var16]);
                  field452[var16] = false;
               }
            }
         } catch (Exception var27) {
            Frames.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var23 = Frames.canvas.getGraphics();
            Player.bufferProvider.draw(var23, 0, 0);

            for(var16 = 0; var16 < field298; ++var16) {
               field452[var16] = false;
            }
         } catch (Exception var26) {
            Frames.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "96"
   )
   protected final void vmethod3021() {
      if(class141.chatMessages.method201()) {
         class141.chatMessages.method202();
      }

      if(null != class18.field244) {
         class18.field244.field189 = false;
      }

      class18.field244 = null;
      if(null != class32.field695) {
         class32.field695.method2986();
         class32.field695 = null;
      }

      class31.method683();
      RSCanvas.method2933();
      class168.field2712 = null;
      if(class22.field576 != null) {
         class22.field576.method1180();
      }

      if(null != field527) {
         field527.method1180();
      }

      ItemLayer.method2182();
      FrameMap.method2259();
      class124.method2741();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1743207183"
   )
   void method232() {
      if(gameState != 1000) {
         long var2 = class113.method2394();
         int var4 = (int)(var2 - class219.field3208);
         class219.field3208 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class174.field2764 += var4;
         boolean var1;
         if(class174.field2776 == 0 && class174.field2768 == 0 && class174.field2774 == 0 && class174.field2766 == 0) {
            var1 = true;
         } else if(null == class174.field2772) {
            var1 = false;
         } else {
            try {
               label240: {
                  if(class174.field2764 > 30000) {
                     throw new IOException();
                  }

                  class175 var5;
                  Buffer var6;
                  while(class174.field2768 < 20 && class174.field2766 > 0) {
                     var5 = (class175)class174.field2773.method3780();
                     var6 = new Buffer(4);
                     var6.method2467(1);
                     var6.method2523((int)var5.hash);
                     class174.field2772.method2987(var6.payload, 0, 4);
                     class174.field2765.method3776(var5, var5.hash);
                     --class174.field2766;
                     ++class174.field2768;
                  }

                  while(class174.field2776 < 20 && class174.field2774 > 0) {
                     var5 = (class175)class174.field2769.method3871();
                     var6 = new Buffer(4);
                     var6.method2467(0);
                     var6.method2523((int)var5.hash);
                     class174.field2772.method2987(var6.payload, 0, 4);
                     var5.method3894();
                     class174.field2771.method3776(var5, var5.hash);
                     --class174.field2774;
                     ++class174.field2776;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class174.field2772.method2988();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class174.field2764 = 0;
                     byte var7 = 0;
                     if(null == SecondaryBufferProvider.field1416) {
                        var7 = 8;
                     } else if(class174.field2767 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class174.field2775.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class174.field2772.method2996(class174.field2775.payload, class174.field2775.offset, var8);
                        if(class174.field2779 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class174.field2775.payload[var9 + class174.field2775.offset] ^= class174.field2779;
                           }
                        }

                        class174.field2775.offset += var8;
                        if(class174.field2775.offset < var7) {
                           break;
                        }

                        if(SecondaryBufferProvider.field1416 == null) {
                           class174.field2775.offset = 0;
                           var9 = class174.field2775.method2481();
                           var10 = class174.field2775.method2668();
                           int var11 = class174.field2775.method2481();
                           var12 = class174.field2775.method2526();
                           long var13 = (long)((var9 << 16) + var10);
                           class175 var15 = (class175)class174.field2765.method3775(var13);
                           class174.field2763 = true;
                           if(null == var15) {
                              var15 = (class175)class174.field2771.method3775(var13);
                              class174.field2763 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           SecondaryBufferProvider.field1416 = var15;
                           class43.field962 = new Buffer(var12 + var16 + SecondaryBufferProvider.field1416.field2783);
                           class43.field962.method2467(var11);
                           class43.field962.method2642(var12);
                           class174.field2767 = 8;
                           class174.field2775.offset = 0;
                        } else if(class174.field2767 == 0) {
                           if(class174.field2775.payload[0] == -1) {
                              class174.field2767 = 1;
                              class174.field2775.offset = 0;
                           } else {
                              SecondaryBufferProvider.field1416 = null;
                           }
                        }
                     } else {
                        var8 = class43.field962.payload.length - SecondaryBufferProvider.field1416.field2783;
                        var9 = 512 - class174.field2767;
                        if(var9 > var8 - class43.field962.offset) {
                           var9 = var8 - class43.field962.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class174.field2772.method2996(class43.field962.payload, class43.field962.offset, var9);
                        if(class174.field2779 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class43.field962.payload[var10 + class43.field962.offset] ^= class174.field2779;
                           }
                        }

                        class43.field962.offset += var9;
                        class174.field2767 += var9;
                        if(var8 == class43.field962.offset) {
                           if(16711935L == SecondaryBufferProvider.field1416.hash) {
                              MessageNode.field781 = class43.field962;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class171 var19 = class174.field2778[var10];
                                 if(var19 != null) {
                                    MessageNode.field781.offset = 5 + 8 * var10;
                                    var12 = MessageNode.field781.method2526();
                                    int var23 = MessageNode.field781.method2526();
                                    var19.method3347(var12, var23);
                                 }
                              }
                           } else {
                              class174.field2777.reset();
                              class174.field2777.update(class43.field962.payload, 0, var8);
                              var10 = (int)class174.field2777.getValue();
                              if(var10 != SecondaryBufferProvider.field1416.field2782) {
                                 try {
                                    class174.field2772.method2986();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class174.field2780;
                                 class174.field2772 = null;
                                 class174.field2779 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label240;
                              }

                              class174.field2780 = 0;
                              class174.field2781 = 0;
                              SecondaryBufferProvider.field1416.field2785.method3336((int)(SecondaryBufferProvider.field1416.hash & 65535L), class43.field962.payload, (SecondaryBufferProvider.field1416.hash & 16711680L) == 16711680L, class174.field2763);
                           }

                           SecondaryBufferProvider.field1416.unlink();
                           if(class174.field2763) {
                              --class174.field2768;
                           } else {
                              --class174.field2776;
                           }

                           class174.field2767 = 0;
                           SecondaryBufferProvider.field1416 = null;
                           class43.field962 = null;
                        } else {
                           if(class174.field2767 != 512) {
                              break;
                           }

                           class174.field2767 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class174.field2772.method2986();
               } catch (Exception var20) {
                  ;
               }

               ++class174.field2781;
               class174.field2772 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method233();
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "691523464"
   )
   void method233() {
      if(class174.field2780 >= 4) {
         this.method3022("js5crc");
         gameState = 1000;
      } else {
         if(class174.field2781 >= 4) {
            if(gameState <= 5) {
               this.method3022("js5io");
               gameState = 1000;
               return;
            }

            field509 = 3000;
            class174.field2781 = 3;
         }

         if(--field509 + 1 <= 0) {
            try {
               if(field296 == 0) {
                  GameEngine.field2249 = class8.field121.method2891(class38.host, ItemLayer.field1726);
                  ++field296;
               }

               if(field296 == 1) {
                  if(GameEngine.field2249.field2257 == 2) {
                     this.method234(-1);
                     return;
                  }

                  if(GameEngine.field2249.field2257 == 1) {
                     ++field296;
                  }
               }

               if(field296 == 2) {
                  class113.field1946 = new class146((Socket)GameEngine.field2249.field2261, class8.field121);
                  Buffer var1 = new Buffer(5);
                  var1.method2467(15);
                  var1.method2642(123);
                  class113.field1946.method2987(var1.payload, 0, 5);
                  ++field296;
                  class130.field2085 = class113.method2394();
               }

               if(field296 == 3) {
                  if(gameState > 5 && class113.field1946.method2988() <= 0) {
                     if(class113.method2394() - class130.field2085 > 30000L) {
                        this.method234(-2);
                        return;
                     }
                  } else {
                     int var5 = class113.field1946.method2991();
                     if(var5 != 0) {
                        this.method234(var5);
                        return;
                     }

                     ++field296;
                  }
               }

               if(field296 == 4) {
                  class146 var10 = class113.field1946;
                  boolean var2 = gameState > 20;
                  if(class174.field2772 != null) {
                     try {
                        class174.field2772.method2986();
                     } catch (Exception var8) {
                        ;
                     }

                     class174.field2772 = null;
                  }

                  class174.field2772 = var10;
                  class157.method3155(var2);
                  class174.field2775.offset = 0;
                  SecondaryBufferProvider.field1416 = null;
                  class43.field962 = null;
                  class174.field2767 = 0;

                  while(true) {
                     class175 var3 = (class175)class174.field2765.method3780();
                     if(null == var3) {
                        while(true) {
                           var3 = (class175)class174.field2771.method3780();
                           if(null == var3) {
                              if(class174.field2779 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.method2467(4);
                                    var11.method2467(class174.field2779);
                                    var11.method2468(0);
                                    class174.field2772.method2987(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class174.field2772.method2986();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class174.field2781;
                                    class174.field2772 = null;
                                 }
                              }

                              class174.field2764 = 0;
                              class219.field3208 = class113.method2394();
                              GameEngine.field2249 = null;
                              class113.field1946 = null;
                              field296 = 0;
                              field263 = 0;
                              return;
                           }

                           class174.field2769.method3873(var3);
                           class174.field2770.method3776(var3, var3.hash);
                           ++class174.field2774;
                           --class174.field2776;
                        }
                     }

                     class174.field2773.method3776(var3, var3.hash);
                     ++class174.field2766;
                     --class174.field2768;
                  }
               }
            } catch (IOException var9) {
               this.method234(-3);
            }

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-19"
   )
   void method234(int var1) {
      GameEngine.field2249 = null;
      class113.field1946 = null;
      field296 = 0;
      if(class20.field558 == ItemLayer.field1726) {
         ItemLayer.field1726 = class156.field2318;
      } else {
         ItemLayer.field1726 = class20.field558;
      }

      ++field263;
      if(field263 < 2 || var1 != 7 && var1 != 9) {
         if(field263 >= 2 && var1 == 6) {
            this.method3022("js5connect_outofdate");
            gameState = 1000;
         } else if(field263 >= 4) {
            if(gameState <= 5) {
               this.method3022("js5connect");
               gameState = 1000;
            } else {
               field509 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method3022("js5connect_full");
         gameState = 1000;
      } else {
         field509 = 3000;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "152621234"
   )
   protected final void vmethod3025() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "79"
   )
   protected final void vmethod3018() {
      class20.field558 = field267 == 0?'ꩊ':world + '鱀';
      class156.field2318 = field267 == 0?443:world + '썐';
      ItemLayer.field1726 = class20.field558;
      class137.field2121 = class177.field2938;
      PlayerComposition.field2964 = class177.field2940;
      PlayerComposition.field2968 = class177.field2935;
      class112.field1942 = class177.field2936;
      if(class139.field2137.toLowerCase().indexOf("microsoft") != -1) {
         class140.field2156[186] = 57;
         class140.field2156[187] = 27;
         class140.field2156[188] = 71;
         class140.field2156[189] = 26;
         class140.field2156[190] = 72;
         class140.field2156[191] = 73;
         class140.field2156[192] = 58;
         class140.field2156[219] = 42;
         class140.field2156[220] = 74;
         class140.field2156[221] = 43;
         class140.field2156[222] = 59;
         class140.field2156[223] = 28;
      } else {
         class140.field2156[44] = 71;
         class140.field2156[45] = 26;
         class140.field2156[46] = 72;
         class140.field2156[47] = 73;
         class140.field2156[59] = 57;
         class140.field2156[61] = 27;
         class140.field2156[91] = 42;
         class140.field2156[92] = 74;
         class140.field2156[93] = 43;
         class140.field2156[192] = 28;
         class140.field2156[222] = 58;
         class140.field2156[520] = 59;
      }

      class40.method782(Frames.canvas);
      class145.method2980(Frames.canvas);

      class148 var1;
      try {
         var1 = new class148();
      } catch (Throwable var4) {
         var1 = null;
      }

      class168.field2712 = var1;
      if(class168.field2712 != null) {
         class168.field2712.vmethod3107(Frames.canvas);
      }

      class10.field159 = new class137(255, class152.field2279, class152.field2278, 500000);
      Sequence.field984 = Frames.method2265();
      Friend.field229 = this.getToolkit().getSystemClipboard();
      String var3 = class119.field2013;
      class141.field2172 = this;
      class141.field2176 = var3;
      if(field267 != 0) {
         field282 = true;
      }

      class23.method576(Sequence.field984.field125);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "278432677"
   )
   static World method392() {
      return World.field641 < World.field630?World.worldList[++World.field641 - 1]:null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-971480230"
   )
   static final void method423(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class94.field1631[var6];
         var12 = class94.field1621[var6];
         var13 = var12 * var9 - var5 * var11 >> 16;
         var10 = var9 * var11 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class94.field1631[var7];
         var12 = class94.field1621[var7];
         var13 = var11 * var10 + var8 * var12 >> 16;
         var10 = var12 * var10 - var11 * var8 >> 16;
         var8 = var13;
      }

      class13.cameraX = var0 - var8;
      Ignore.cameraZ = var1 - var9;
      class154.cameraY = var2 - var10;
      class125.cameraPitch = var3;
      class166.cameraYaw = var4;
   }

   static {
      field292 = class21.field564;
      field293 = class21.field564;
      field295 = 0;
      field296 = 0;
      field509 = 0;
      field263 = 0;
      field420 = 0;
      field352 = 0;
      field268 = 0;
      field304 = 0;
      cachedNPCs = new NPC['耀'];
      field309 = 0;
      field307 = new int['耀'];
      field308 = 0;
      field418 = new int[250];
      field300 = new class125(5000);
      field311 = new class125(5000);
      field312 = new class125(15000);
      field313 = 0;
      packetOpcode = 0;
      field272 = 0;
      field316 = 0;
      field345 = 0;
      field318 = 0;
      field319 = 0;
      field548 = 0;
      field533 = false;
      field322 = 0;
      field323 = 1;
      field324 = 0;
      field340 = 1;
      field329 = 0;
      collisionMaps = new CollisionData[4];
      field428 = false;
      field330 = new int[4][13][13];
      field331 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field485 = 0;
      field431 = 2;
      field447 = 0;
      field409 = 2;
      field337 = 0;
      field338 = 1;
      field339 = 0;
      mapScale = 0;
      field341 = 2;
      mapScaleDelta = 0;
      field343 = 1;
      field344 = 0;
      field297 = 0;
      field347 = 2301979;
      field397 = 5063219;
      field349 = 3353893;
      field369 = 7759444;
      field382 = false;
      field423 = 0;
      field353 = 128;
      mapAngle = 0;
      field422 = 0;
      field289 = 0;
      field357 = 0;
      field358 = 0;
      field359 = 50;
      field360 = 0;
      field361 = false;
      field490 = 0;
      field363 = 0;
      field364 = 50;
      field365 = new int[field364];
      field366 = new int[field364];
      field367 = new int[field364];
      field368 = new int[field364];
      field413 = new int[field364];
      field370 = new int[field364];
      field371 = new int[field364];
      field351 = new String[field364];
      field373 = new int[104][104];
      field374 = 0;
      field375 = -1;
      field376 = -1;
      field454 = 0;
      field378 = 0;
      field539 = 0;
      field468 = 0;
      field334 = 0;
      field317 = 0;
      field383 = 0;
      field384 = 0;
      field385 = 0;
      field386 = 0;
      field356 = false;
      field388 = 0;
      field426 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field387 = 0;
      field393 = 0;
      field394 = new int[1000];
      field395 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field396 = new String[8];
      field513 = new boolean[8];
      field398 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field399 = -1;
      groundItemDeque = new Deque[4][104][104];
      field401 = new Deque();
      projectiles = new Deque();
      field403 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field407 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field427 = -1;
      field405 = -1;
      field419 = 0;
      field448 = 50;
      field421 = 0;
      field416 = null;
      field270 = false;
      field269 = -1;
      field425 = -1;
      field333 = null;
      field497 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field430 = 0;
      field458 = 0;
      field432 = null;
      energy = 0;
      weight = 0;
      field435 = 0;
      field436 = -1;
      field437 = false;
      field438 = false;
      field439 = false;
      field440 = null;
      field441 = null;
      field391 = null;
      field280 = 0;
      field444 = 0;
      field283 = null;
      field446 = false;
      field404 = -1;
      field336 = -1;
      field449 = false;
      field450 = -1;
      field474 = -1;
      field473 = false;
      field453 = 1;
      field472 = new int[32];
      field455 = 0;
      field456 = new int[32];
      field457 = 0;
      field321 = new int[32];
      field459 = 0;
      field460 = 0;
      field461 = 0;
      field462 = 0;
      field284 = 0;
      field464 = 0;
      field332 = 0;
      field335 = 0;
      field467 = new Deque();
      field301 = new Deque();
      field469 = new Deque();
      widgetFlags = new XHashTable(512);
      field298 = 0;
      field505 = -2;
      field379 = new boolean[100];
      field452 = new boolean[100];
      field320 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field480 = 0;
      field481 = 0L;
      isResized = true;
      field483 = 765;
      field484 = 1;
      field442 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field537 = 0;
      field487 = 0;
      field488 = "";
      field489 = new long[100];
      field276 = 0;
      field491 = 0;
      field492 = new int[128];
      field493 = new int[128];
      field494 = -1L;
      field495 = null;
      field496 = null;
      field451 = -1;
      field498 = 0;
      field499 = new int[1000];
      field500 = new int[1000];
      field501 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field326 = 0;
      field424 = 255;
      field506 = -1;
      field507 = false;
      field508 = 127;
      field303 = 127;
      field510 = 0;
      field511 = new int[50];
      field315 = new int[50];
      field482 = new int[50];
      field514 = new int[50];
      field515 = new class61[50];
      field516 = false;
      field517 = new boolean[5];
      field526 = new int[5];
      field519 = new int[5];
      field355 = new int[5];
      field521 = new int[5];
      field522 = 256;
      field523 = 205;
      field524 = 256;
      field525 = 320;
      field302 = 1;
      field520 = 32767;
      field528 = 1;
      field529 = 32767;
      field530 = 0;
      field531 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field536 = 0;
      friends = new Friend[400];
      field538 = new class198();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field541 = new PlayerComposition();
      field542 = -1;
      field543 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field545 = -1L;
      field546 = -1L;
      field547 = new class10();
      field445 = new int[50];
      field549 = new int[50];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "-504044647"
   )
   public static SpritePixels[] method493(class170 var0, String var1, String var2) {
      int var3 = var0.method3265(var1);
      int var4 = var0.method3266(var3, var2);
      return method528(var0, var3, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIB)[LSpritePixels;",
      garbageValue = "5"
   )
   static SpritePixels[] method528(class170 var0, int var1, int var2) {
      return !class35.method729(var0, var1, var2)?null:class49.method989();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "-71"
   )
   public static void method530(String var0, String var1, int var2, int var3) throws IOException {
      class152.field2277 = var3;
      GameEngine.field2232 = var2;

      try {
         class146.field2221 = System.getProperty("os.name");
      } catch (Exception var30) {
         class146.field2221 = "Unknown";
      }

      class24.field606 = class146.field2221.toLowerCase();

      try {
         class92.field1598 = System.getProperty("user.home");
         if(class92.field1598 != null) {
            class92.field1598 = class92.field1598 + "/";
         }
      } catch (Exception var29) {
         ;
      }

      try {
         if(class24.field606.startsWith("win")) {
            if(null == class92.field1598) {
               class92.field1598 = System.getenv("USERPROFILE");
            }
         } else if(class92.field1598 == null) {
            class92.field1598 = System.getenv("HOME");
         }

         if(null != class92.field1598) {
            class92.field1598 = class92.field1598 + "/";
         }
      } catch (Exception var28) {
         ;
      }

      if(class92.field1598 == null) {
         class92.field1598 = "~/";
      }

      class152.field2274 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class92.field1598, "/tmp/", ""};
      class52.field1116 = new String[]{".jagex_cache_" + GameEngine.field2232, ".file_store_" + GameEngine.field2232};
      int var18 = 0;

      label293:
      while(var18 < 4) {
         String var6 = var18 == 0?"":"" + var18;
         class152.field2272 = new File(class92.field1598, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var11;
         File var37;
         if(class152.field2272.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class152.field2272, "rw", 10000L);

               int var12;
               for(var11 = new Buffer((int)var10.method4130()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.method4127(var11.payload, var11.offset, var11.payload.length - var11.offset);
                  if(var12 == -1) {
                     throw new IOException();
                  }
               }

               var11.offset = 0;
               var12 = var11.method2481();
               if(var12 < 1 || var12 > 3) {
                  throw new IOException("" + var12);
               }

               int var13 = 0;
               if(var12 > 1) {
                  var13 = var11.method2481();
               }

               if(var12 <= 2) {
                  var7 = var11.method2490();
                  if(var13 == 1) {
                     var8 = var11.method2490();
                  }
               } else {
                  var7 = var11.method2491();
                  if(var13 == 1) {
                     var8 = var11.method2491();
                  }
               }

               var10.method4128();
            } catch (IOException var33) {
               var33.printStackTrace();
            }

            if(null != var7) {
               var37 = new File(var7);
               if(!var37.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var37 = new File(var7, "test.dat");
               if(!class52.method1043(var37, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var18 == 0) {
            label267:
            for(int var19 = 0; var19 < class52.field1116.length; ++var19) {
               for(int var20 = 0; var20 < class152.field2274.length; ++var20) {
                  File var21 = new File(class152.field2274[var20] + class52.field1116[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && class52.method1043(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label267;
                  }
               }
            }
         }

         if(null == var7) {
            var7 = class92.field1598 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         File var36;
         if(var8 != null) {
            var36 = new File(var8);
            var37 = new File(var7);

            try {
               File[] var40 = var36.listFiles();
               File[] var22 = var40;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
                  File var16 = new File(var37, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var32) {
               var32.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            var36 = new File(var7);
            var11 = null;

            try {
               FileOnDisk var41 = new FileOnDisk(class152.field2272, "rw", 10000L);
               Buffer var42 = new Buffer(500);
               var42.method2467(3);
               var42.method2467(null != var11?1:0);
               var42.method2593(var36.getPath());
               if(null != var11) {
                  var42.method2593("");
               }

               var41.method4124(var42.payload, 0, var42.offset);
               var41.method4128();
            } catch (IOException var27) {
               var27.printStackTrace();
            }
         }

         File var5 = new File(var7);
         class152.field2273 = var5;
         if(!class152.field2273.exists()) {
            class152.field2273.mkdirs();
         }

         File[] var35 = class152.field2273.listFiles();
         if(var35 != null) {
            File[] var38 = var35;

            for(int var23 = 0; var23 < var38.length; ++var23) {
               File var24 = var38[var23];
               if(!class52.method1043(var24, false)) {
                  ++var18;
                  continue label293;
               }
            }
         }
         break;
      }

      class34.method727(class152.field2273);

      try {
         File var4 = new File(class92.field1598, "random.dat");
         int var26;
         if(var4.exists()) {
            class152.field2276 = new class231(new FileOnDisk(var4, "rw", 25L), 24, 0);
         } else {
            label220:
            for(int var25 = 0; var25 < class52.field1116.length; ++var25) {
               for(var26 = 0; var26 < class152.field2274.length; ++var26) {
                  File var39 = new File(class152.field2274[var26] + class52.field1116[var25] + File.separatorChar + "random.dat");
                  if(var39.exists()) {
                     class152.field2276 = new class231(new FileOnDisk(var39, "rw", 25L), 24, 0);
                     break label220;
                  }
               }
            }
         }

         if(class152.field2276 == null) {
            RandomAccessFile var34 = new RandomAccessFile(var4, "rw");
            var26 = var34.read();
            var34.seek(0L);
            var34.write(var26);
            var34.seek(0L);
            var34.close();
            class152.field2276 = new class231(new FileOnDisk(var4, "rw", 25L), 24, 0);
         }
      } catch (IOException var31) {
         ;
      }

      class152.field2279 = new class231(new FileOnDisk(class177.method3445("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class152.field2278 = new class231(new FileOnDisk(class177.method3445("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class152.field2271 = new class231[class152.field2277];

      for(var18 = 0; var18 < class152.field2277; ++var18) {
         class152.field2271[var18] = new class231(new FileOnDisk(class177.method3445("main_file_cache.idx" + var18), "rw", 1048576L), 6000, 0);
      }

   }
}
