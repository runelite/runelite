import java.awt.Canvas;
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
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
   @ObfuscatedName("pt")
   static final class10 field280;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 194572879
   )
   static int field281 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1008530179
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1104984161
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("op")
   static short field284;
   @ObfuscatedName("d")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("nw")
   static int[] field286;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 530273035
   )
   static int field287;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -722650323
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("a")
   static boolean field289 = true;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 385698419
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 4432791997987708953L
   )
   static long field291 = -1L;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -75205661
   )
   static int field292;
   @ObfuscatedName("jq")
   static boolean field293;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1454890367
   )
   static int field294 = -1;
   @ObfuscatedName("an")
   static boolean field295 = true;
   @ObfuscatedName("ag")
   static boolean field296 = false;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 804704699
   )
   static int field297 = 0;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 146824329
   )
   static int field298;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 963816995
   )
   static int field299 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1009508165
   )
   static int field300 = 0;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = 2137223145
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1327167195
   )
   static int field302 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -46084849
   )
   static int field303 = 0;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 1749181465
   )
   static int field304;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1546925861
   )
   static int field305 = 0;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -989305437
   )
   static int field306;
   @ObfuscatedName("am")
   static class21 field307;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -708433125
   )
   static int field308;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -25650843
   )
   static int field309;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 69329251
   )
   static int field310;
   @ObfuscatedName("be")
   static class171 field311;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -2079563187
   )
   static int field312;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -2130946349
   )
   static int field313;
   @ObfuscatedName("v")
   static boolean field314 = false;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1232466015
   )
   static int field315 = -1;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1343107995
   )
   static int field316;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1649800971
   )
   static int field317;
   @ObfuscatedName("ca")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1185182235
   )
   static int field319;
   @ObfuscatedName("cd")
   static int[] field320;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 200015
   )
   static int field321;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 554969245
   )
   static int field322;
   @ObfuscatedName("cx")
   static class125 field323;
   @ObfuscatedName("cl")
   static class125 field324;
   @ObfuscatedName("ny")
   static int[] field325;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 823254853
   )
   static int field326;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -170044753
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 492379889
   )
   static int field328;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -1330095559
   )
   static int field329;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -424178115
   )
   static int field330;
   @ObfuscatedName("oh")
   static short field331;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1820620929
   )
   static int field332;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 1047700969
   )
   static int field333;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 2116540311
   )
   static int field334;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -1580094627
   )
   static int field335;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 5653409
   )
   static int field336;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1840687123
   )
   static int field337;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -1743276933
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("ku")
   static int[] field339;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("dv")
   static boolean field341;
   @ObfuscatedName("kp")
   static int[] field342;
   @ObfuscatedName("dp")
   static final int[] field343;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -1750042397
   )
   static int field344;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1141983261
   )
   static int field345;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -262259631
   )
   static int field346;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 142348687
   )
   static int field347;
   @ObfuscatedName("cs")
   static boolean field348;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1184473205
   )
   static int field349;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 1544574927
   )
   static int field350;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 942655067
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 270693953
   )
   static int field352;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 1449119755
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 1984281575
   )
   static int field354;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -679401097
   )
   static int field355 = 0;
   @ObfuscatedName("fd")
   static int[] field356;
   @ObfuscatedName("ha")
   static Deque field357;
   @ObfuscatedName("ey")
   static ModIcon[] field358;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1613743949
   )
   static int field359;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -133513567
   )
   static int field360;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 1397735629
   )
   static int field361;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1613193183
   )
   static int field362;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -2086753023
   )
   static int field363;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -124892215
   )
   static int field364;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -510311973
   )
   static int field365;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1063517301
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1126397233
   )
   static int field367;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -264592935
   )
   static int field368;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 986726317
   )
   static int field369;
   @ObfuscatedName("ie")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 671098279
   )
   static int field371;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -907875907
   )
   static int field372;
   @ObfuscatedName("fw")
   static boolean field373;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1659846273
   )
   static int field374;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -592569623
   )
   static int field375;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      longValue = -3581853632261568761L
   )
   static long field376;
   @ObfuscatedName("j")
   static Client field377;
   @ObfuscatedName("fj")
   static int[] field378;
   @ObfuscatedName("fr")
   static int[] field379;
   @ObfuscatedName("hx")
   static int[] field380;
   @ObfuscatedName("ho")
   static int[] field381;
   @ObfuscatedName("fk")
   static int[] field382;
   @ObfuscatedName("fg")
   static int[] field383;
   @ObfuscatedName("gl")
   static String[] field384;
   @ObfuscatedName("gq")
   static int[][] field385;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 339578525
   )
   static int field386;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1745773051
   )
   static int field387;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -919209869
   )
   static int field388;
   @ObfuscatedName("de")
   static int[][][] field389;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 297301773
   )
   static int field390;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -777008565
   )
   static int field391;
   @ObfuscatedName("oi")
   static short field392;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -2129726565
   )
   static int field393;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 1474989397
   )
   static int field394;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 1336997507
   )
   static int field395;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -947309555
   )
   static int field396;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -2118970559
   )
   static int field397;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -146064897
   )
   static int field398;
   @ObfuscatedName("gt")
   static boolean field399;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1441122587
   )
   static int field400;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1385189669
   )
   static int field401;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1717693909
   )
   static int field402;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -901799503
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ig")
   static boolean field404;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 345548655
   )
   static int field405;
   @ObfuscatedName("if")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("hq")
   static final int[] field407;
   @ObfuscatedName("hr")
   static String[] field408;
   @ObfuscatedName("hm")
   static boolean[] field409;
   @ObfuscatedName("z")
   static boolean field410 = true;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -1394913645
   )
   static int field411;
   @ObfuscatedName("hu")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("hw")
   static Deque field413;
   @ObfuscatedName("hv")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("ad")
   static class21 field415;
   @ObfuscatedName("hs")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("hl")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("na")
   static boolean field418;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 477551015
   )
   static int field419 = 0;
   @ObfuscatedName("hk")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 1637778817
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("hb")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("hc")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = -591339121
   )
   static int field424;
   @ObfuscatedName("ij")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("iw")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ik")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -1125177115
   )
   static int field428;
   @ObfuscatedName("ev")
   static boolean field429;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -716867445
   )
   static int field430;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 692572359
   )
   static int field431;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 532794265
   )
   static int field432;
   @ObfuscatedName("it")
   static String field433;
   @ObfuscatedName("np")
   static int[] field434;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = -858964925
   )
   static int field435;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -586960701
   )
   static int field436;
   @ObfuscatedName("io")
   static String field437;
   @ObfuscatedName("iy")
   static String field438;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -810262277
   )
   static int field439 = -1;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -358954437
   )
   static int field440;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 980157207
   )
   static int field441;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -190310669
   )
   static int field442;
   @ObfuscatedName("jv")
   static Widget field443;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -124783327
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ll")
   static int[] field445;
   @ObfuscatedName("ci")
   static class125 field446;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 1882265911
   )
   static int field447;
   @ObfuscatedName("jf")
   static boolean field448;
   @ObfuscatedName("jp")
   static boolean field449;
   @ObfuscatedName("ep")
   static SpritePixels[] field450;
   @ObfuscatedName("mm")
   static int[] field451;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1820525413
   )
   static int field452;
   @ObfuscatedName("ju")
   static Widget field453;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 2037151049
   )
   static int field454;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 193539787
   )
   static int field455;
   @ObfuscatedName("jo")
   static Widget field456;
   @ObfuscatedName("jc")
   static boolean field457;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 456622577
   )
   static int field458;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 236058945
   )
   static int field459;
   @ObfuscatedName("jt")
   static boolean field460;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 555104357
   )
   static int field461;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 820638461
   )
   static int field462;
   @ObfuscatedName("jr")
   static Widget field463;
   @ObfuscatedName("he")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -477545077
   )
   static int field465;
   @ObfuscatedName("cj")
   static int[] field466;
   @ObfuscatedName("km")
   static int[] field467;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -325160431
   )
   static int field468;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      longValue = 8311334862663859459L
   )
   static long field469;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 1884420497
   )
   static int field470;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 938220859
   )
   static int field471;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -542132481
   )
   static int field472;
   @ObfuscatedName("lf")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -524887947
   )
   static int field474;
   @ObfuscatedName("fx")
   static int[] field475;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -932570109
   )
   static int field476;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 1098719243
   )
   static int field477;
   @ObfuscatedName("ka")
   static Deque field478;
   @ObfuscatedName("kh")
   static Deque field479;
   @ObfuscatedName("kv")
   static Deque field480;
   @ObfuscatedName("ko")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 385914939
   )
   static int field482;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -1559658327
   )
   static int field483;
   @ObfuscatedName("kz")
   static boolean[] field484;
   @ObfuscatedName("lh")
   static boolean[] field485;
   @ObfuscatedName("lj")
   static boolean[] field486;
   @ObfuscatedName("lt")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("lq")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("lm")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 185156847
   )
   static int field490;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 1528398793
   )
   static int field491;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      longValue = -6567501698647375443L
   )
   static long field492;
   @ObfuscatedName("lc")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("jb")
   static Widget field494;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -849744807
   )
   static int field495;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -1138553569
   )
   static int field496;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 42308007
   )
   static int field497;
   @ObfuscatedName("oo")
   static short field498;
   @ObfuscatedName("lz")
   static String field499;
   @ObfuscatedName("li")
   static long[] field500;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 1961998185
   )
   static int field501;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = 1807639409
   )
   static int field502;
   @ObfuscatedName("ou")
   static int[] field503;
   @ObfuscatedName("me")
   static int[] field504;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      longValue = 230628507600917873L
   )
   static long field505;
   @ObfuscatedName("pj")
   static int[] field506;
   @ObfuscatedName("mk")
   static String field507;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -1943263639
   )
   static int field508;
   @ObfuscatedName("gg")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = -1874796939
   )
   static int field510;
   @ObfuscatedName("mh")
   static int[] field511;
   @ObfuscatedName("mi")
   static SpritePixels[] field512;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = 1778410729
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -1421130177
   )
   static int field515;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = -901727901
   )
   static int field516;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 261538811
   )
   static int field517;
   @ObfuscatedName("mq")
   static boolean field518;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = 874422005
   )
   static int field519;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -607553607
   )
   static int field520;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = 1509272005
   )
   static int field521;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1202790653
   )
   static int field522;
   @ObfuscatedName("nz")
   static int[] field523;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 2021397477
   )
   static int field524;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -480200669
   )
   static int field525 = 0;
   @ObfuscatedName("nv")
   static class61[] field526;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -23618241
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -2064815291
   )
   static int field528;
   @ObfuscatedName("nu")
   static boolean[] field529;
   @ObfuscatedName("os")
   static int[] field530;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -173883217
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -1703122049
   )
   static int field532;
   @ObfuscatedName("ow")
   static int[] field533;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -1325802117
   )
   static int field534;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 1393739365
   )
   static int field535;
   @ObfuscatedName("oa")
   static short field537;
   @ObfuscatedName("ov")
   static short field538;
   @ObfuscatedName("om")
   static short field539;
   @ObfuscatedName("ot")
   static short field540;
   @ObfuscatedName("ms")
   static String field541;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -2062985139
   )
   static int field542;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1124302475
   )
   static int field543;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = -1142447779
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 1106425703
   )
   static int field545;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -1548967697
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 1952850581
   )
   static int field547;
   @ObfuscatedName("jj")
   static boolean field548;
   @ObfuscatedName("oz")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("ob")
   static class198 field550;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -840300089
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("oc")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("ol")
   static PlayerComposition field553;
   @ObfuscatedName("lp")
   static int[] field554;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 1732331987
   )
   static int field555;
   @ObfuscatedName("pb")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -667440247
   )
   static int field557;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = -1044864361
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("fa")
   static int[] field559;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1180964201
   )
   static int field560 = 0;
   @ObfuscatedName("pl")
   static int[] field561;
   @ObfuscatedName("of")
   static int[] field562;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 76267449
   )
   static int field563;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -171972261
   )
   @Export("cameraYaw")
   static int cameraYaw;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "115775272"
   )
   protected final void vmethod3065() {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "25292714"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method252();
      Item.method658();

      int var1;
      try {
         if(class186.field3009 == 1) {
            var1 = class186.field3008.method3618();
            if(var1 > 0 && class186.field3008.method3624()) {
               var1 -= class35.field785;
               if(var1 < 0) {
                  var1 = 0;
               }

               class186.field3008.method3617(var1);
            } else {
               class186.field3008.method3670();
               class186.field3008.method3621();
               if(null != class186.field3010) {
                  class186.field3009 = 2;
               } else {
                  class186.field3009 = 0;
               }

               class186.field3017 = null;
               class186.field3006 = null;
            }
         }
      } catch (Exception var61) {
         var61.printStackTrace();
         class186.field3008.method3670();
         class186.field3009 = 0;
         class186.field3017 = null;
         class186.field3006 = null;
         class186.field3010 = null;
      }

      class92.method2127();
      class31.method666();
      class218.method3973();
      if(null != class5.field91) {
         var1 = class5.field91.vmethod3163();
         field477 = var1;
      }

      int var2;
      int var4;
      int var5;
      int var7;
      int var8;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var18;
      int var19;
      int var26;
      int var29;
      int var32;
      class16 var106;
      if(gameState == 0) {
         class51.method1055();
         class47.method970();
      } else if(gameState == 5) {
         class56.method1176(this);
         class51.method1055();
         class47.method970();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class56.method1176(this);
            class126.method2844();
         } else if(gameState == 25) {
            class14.method168(false);
            field335 = 0;
            boolean var62 = true;

            for(var2 = 0; var2 < class22.field587.length; ++var2) {
               if(class170.field2734[var2] != -1 && class22.field587[var2] == null) {
                  class22.field587[var2] = class140.field2165.method3290(class170.field2734[var2], 0);
                  if(class22.field587[var2] == null) {
                     var62 = false;
                     ++field335;
                  }
               }

               if(Renderable.field1505[var2] != -1 && Ignore.field126[var2] == null) {
                  Ignore.field126[var2] = class140.field2165.method3291(Renderable.field1505[var2], 0, class192.xteaKeys[var2]);
                  if(Ignore.field126[var2] == null) {
                     var62 = false;
                     ++field335;
                  }
               }
            }

            if(!var62) {
               field405 = 1;
            } else {
               field337 = 0;
               var62 = true;

               for(var2 = 0; var2 < class22.field587.length; ++var2) {
                  byte[] var3 = Ignore.field126[var2];
                  if(null != var3) {
                     var4 = 64 * (class175.mapRegions[var2] >> 8) - class28.baseX;
                     var5 = (class175.mapRegions[var2] & 255) * 64 - class159.baseY;
                     if(field341) {
                        var4 = 10;
                        var5 = 10;
                     }

                     var62 &= NPC.method730(var3, var4, var5);
                  }
               }

               if(!var62) {
                  field405 = 2;
               } else {
                  if(field405 != 0) {
                     KitDefinition.method941("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class92.method2127();
                  ChatMessages.method228();
                  class92.method2127();
                  Projectile.region.method1948();
                  class92.method2127();
                  System.gc();

                  for(var2 = 0; var2 < 4; ++var2) {
                     collisionMaps[var2].method2442();
                  }

                  for(var2 = 0; var2 < 4; ++var2) {
                     for(var26 = 0; var26 < 104; ++var26) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           class5.tileSettings[var2][var26][var4] = 0;
                        }
                     }
                  }

                  class92.method2127();
                  class24.method573();
                  var2 = class22.field587.length;

                  for(class24 var63 = (class24)class24.field604.method3850(); null != var63; var63 = (class24)class24.field604.method3852()) {
                     if(var63.field610 != null) {
                        class14.field205.method1180(var63.field610);
                        var63.field610 = null;
                     }

                     if(var63.field615 != null) {
                        class14.field205.method1180(var63.field615);
                        var63.field615 = null;
                     }
                  }

                  class24.field604.method3855();
                  class14.method168(true);
                  if(!field341) {
                     var26 = 0;

                     label3739:
                     while(true) {
                        byte[] var6;
                        if(var26 >= var2) {
                           for(var26 = 0; var26 < var2; ++var26) {
                              var4 = (class175.mapRegions[var26] >> 8) * 64 - class28.baseX;
                              var5 = 64 * (class175.mapRegions[var26] & 255) - class159.baseY;
                              var6 = class22.field587[var26];
                              if(null == var6 && class191.field3084 < 800) {
                                 class92.method2127();
                                 Tile.method2343(var4, var5, 64, 64);
                              }
                           }

                           class14.method168(true);
                           var26 = 0;

                           while(true) {
                              if(var26 >= var2) {
                                 break label3739;
                              }

                              byte[] var28 = Ignore.field126[var26];
                              if(var28 != null) {
                                 var5 = 64 * (class175.mapRegions[var26] >> 8) - class28.baseX;
                                 var29 = 64 * (class175.mapRegions[var26] & 255) - class159.baseY;
                                 class92.method2127();
                                 Region var30 = Projectile.region;
                                 CollisionData[] var31 = collisionMaps;
                                 Buffer var71 = new Buffer(var28);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var71.method2569();
                                    if(var11 == 0) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var13 = var71.method2569();
                                       if(var13 == 0) {
                                          break;
                                       }

                                       var12 += var13 - 1;
                                       var14 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       int var17 = var71.method2556();
                                       var18 = var17 >> 2;
                                       var19 = var17 & 3;
                                       int var20 = var15 + var5;
                                       int var21 = var14 + var29;
                                       if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                          int var22 = var16;
                                          if((class5.tileSettings[1][var20][var21] & 2) == 2) {
                                             var22 = var16 - 1;
                                          }

                                          CollisionData var23 = null;
                                          if(var22 >= 0) {
                                             var23 = var31[var22];
                                          }

                                          GameEngine.method3158(var16, var20, var21, var10, var19, var18, var30, var23);
                                       }
                                    }
                                 }
                              }

                              ++var26;
                           }
                        }

                        var4 = (class175.mapRegions[var26] >> 8) * 64 - class28.baseX;
                        var5 = 64 * (class175.mapRegions[var26] & 255) - class159.baseY;
                        var6 = class22.field587[var26];
                        if(null != var6) {
                           class92.method2127();
                           var7 = Tile.field1789 * 8 - 48;
                           var8 = class191.field3084 * 8 - 48;
                           CollisionData[] var9 = collisionMaps;
                           var10 = 0;

                           label3736:
                           while(true) {
                              if(var10 >= 4) {
                                 Buffer var27 = new Buffer(var6);
                                 var11 = 0;

                                 while(true) {
                                    if(var11 >= 4) {
                                       break label3736;
                                    }

                                    for(var12 = 0; var12 < 64; ++var12) {
                                       for(var13 = 0; var13 < 64; ++var13) {
                                          class16.method191(var27, var11, var12 + var4, var5 + var13, var7, var8, 0);
                                       }
                                    }

                                    ++var11;
                                 }
                              }

                              for(var11 = 0; var11 < 64; ++var11) {
                                 for(var12 = 0; var12 < 64; ++var12) {
                                    if(var11 + var4 > 0 && var4 + var11 < 103 && var12 + var5 > 0 && var5 + var12 < 103) {
                                       var9[var10].flags[var11 + var4][var5 + var12] &= -16777217;
                                    }
                                 }
                              }

                              ++var10;
                           }
                        }

                        ++var26;
                     }
                  }

                  if(field341) {
                     var26 = 0;

                     label3672:
                     while(true) {
                        if(var26 >= 4) {
                           for(var26 = 0; var26 < 13; ++var26) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = field389[0][var26][var4];
                                 if(var5 == -1) {
                                    Tile.method2343(var26 * 8, 8 * var4, 8, 8);
                                 }
                              }
                           }

                           class14.method168(true);
                           var26 = 0;

                           while(true) {
                              if(var26 >= 4) {
                                 break label3672;
                              }

                              class92.method2127();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var29 = field389[var26][var4][var5];
                                    if(var29 != -1) {
                                       var7 = var29 >> 24 & 3;
                                       var8 = var29 >> 1 & 3;
                                       var32 = var29 >> 14 & 1023;
                                       var10 = var29 >> 3 & 2047;
                                       var11 = var10 / 8 + (var32 / 8 << 8);

                                       for(var12 = 0; var12 < class175.mapRegions.length; ++var12) {
                                          if(var11 == class175.mapRegions[var12] && Ignore.field126[var12] != null) {
                                             class138.method2919(Ignore.field126[var12], var26, 8 * var4, var5 * 8, var7, (var32 & 7) * 8, (var10 & 7) * 8, var8, Projectile.region, collisionMaps);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var26;
                           }
                        }

                        class92.method2127();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var110 = false;
                              var7 = field389[var26][var4][var5];
                              if(var7 != -1) {
                                 var8 = var7 >> 24 & 3;
                                 var32 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = var11 / 8 + (var10 / 8 << 8);

                                 for(var13 = 0; var13 < class175.mapRegions.length; ++var13) {
                                    if(var12 == class175.mapRegions[var13] && null != class22.field587[var13]) {
                                       class156.method3194(class22.field587[var13], var26, 8 * var4, 8 * var5, var8, (var10 & 7) * 8, 8 * (var11 & 7), var32, collisionMaps);
                                       var110 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var110) {
                                 class92.method2126(var26, 8 * var4, 8 * var5);
                              }
                           }
                        }

                        ++var26;
                     }
                  }

                  class14.method168(true);
                  ChatMessages.method228();
                  class92.method2127();
                  class113.method2480(Projectile.region, collisionMaps);
                  class14.method168(true);
                  var26 = class5.field73;
                  if(var26 > FrameMap.plane) {
                     var26 = FrameMap.plane;
                  }

                  if(var26 < FrameMap.plane - 1) {
                     var26 = FrameMap.plane - 1;
                  }

                  if(field314) {
                     Projectile.region.method1949(class5.field73);
                  } else {
                     Projectile.region.method1949(0);
                  }

                  for(var4 = 0; var4 < 104; ++var4) {
                     for(var5 = 0; var5 < 104; ++var5) {
                        class116.groundItemSpawned(var4, var5);
                     }
                  }

                  class92.method2127();

                  for(var106 = (class16)field413.method3850(); var106 != null; var106 = (class16)field413.method3852()) {
                     if(var106.field241 == -1) {
                        var106.field240 = 0;
                        Actor.method759(var106);
                     } else {
                        var106.unlink();
                     }
                  }

                  ObjectComposition.field926.reset();
                  if(FaceNormal.field1496 != null) {
                     field323.method2818(74);
                     field323.method2544(1057001181);
                  }

                  if(!field341) {
                     var4 = (Tile.field1789 - 6) / 8;
                     var5 = (6 + Tile.field1789) / 8;
                     var29 = (class191.field3084 - 6) / 8;
                     var7 = (6 + class191.field3084) / 8;

                     for(var8 = var4 - 1; var8 <= var5 + 1; ++var8) {
                        for(var32 = var29 - 1; var32 <= var7 + 1; ++var32) {
                           if(var8 < var4 || var8 > var5 || var32 < var29 || var32 > var7) {
                              class140.field2165.method3309("m" + var8 + "_" + var32);
                              class140.field2165.method3309("l" + var8 + "_" + var32);
                           }
                        }
                     }
                  }

                  class130.setGameState(30);
                  class92.method2127();
                  class5.field85 = null;
                  class109.field1921 = null;
                  class5.field75 = null;
                  class5.field76 = null;
                  class220.field3214 = null;
                  class132.field2104 = null;
                  class5.field74 = null;
                  class18.field257 = null;
                  class5.field78 = null;
                  class5.field79 = null;
                  class172.field2766 = null;
                  class12.field184 = null;
                  field323.method2818(131);
                  class47.method970();
               }
            }
         }
      } else {
         class56.method1176(this);
      }

      if(gameState == 30) {
         if(field297 > 1) {
            --field297;
         }

         if(field440 > 0) {
            --field440;
         }

         if(field348) {
            field348 = false;
            if(field440 > 0) {
               class144.method3029();
            } else {
               class130.setGameState(40);
               class62.field1259 = Item.field694;
               Item.field694 = null;
            }
         } else {
            if(!isMenuOpen) {
               menuOptions[0] = "Cancel";
               menuTargets[0] = "";
               menuTypes[0] = 1006;
               menuOptionCount = 1;
            }

            Widget var36;
            boolean var98;
            long var100;
            String var108;
            for(var1 = 0; var1 < 100; ++var1) {
               boolean var65;
               if(null == Item.field694) {
                  var65 = false;
               } else {
                  label3974: {
                     try {
                        var26 = Item.field694.method3041();
                        if(var26 == 0) {
                           var65 = false;
                           break label3974;
                        }

                        if(packetOpcode == -1) {
                           Item.field694.method3042(field446.payload, 0, 1);
                           field446.offset = 0;
                           packetOpcode = field446.method2819();
                           field326 = class191.field3098[packetOpcode];
                           --var26;
                        }

                        if(field326 == -1) {
                           if(var26 <= 0) {
                              var65 = false;
                              break label3974;
                           }

                           Item.field694.method3042(field446.payload, 0, 1);
                           field326 = field446.payload[0] & 255;
                           --var26;
                        }

                        if(field326 == -2) {
                           if(var26 <= 1) {
                              var65 = false;
                              break label3974;
                           }

                           Item.field694.method3042(field446.payload, 0, 2);
                           field446.offset = 0;
                           field326 = field446.method2551();
                           var26 -= 2;
                        }

                        if(var26 < field326) {
                           var65 = false;
                           break label3974;
                        }

                        field446.offset = 0;
                        Item.field694.method3042(field446.payload, 0, field326);
                        field328 = 0;
                        field332 = field396;
                        field396 = field330 * -1;
                        field330 = packetOpcode * -1;
                        if(packetOpcode == 40) {
                           field418 = false;

                           for(var4 = 0; var4 < 5; ++var4) {
                              field529[var4] = false;
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        Widget var68;
                        if(packetOpcode == 206) {
                           var4 = field446.method2592();
                           var5 = field446.method2601();
                           var68 = World.method628(var5);
                           if(var68.modelType != 2 || var4 != var68.modelId) {
                              var68.modelType = 2;
                              var68.modelId = var4;
                              class75.method1606(var68);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 172) {
                           var4 = field446.method2593();
                           byte var103 = field446.method2557();
                           class179.settings[var4] = var103;
                           if(class179.widgetSettings[var4] != var103) {
                              class179.widgetSettings[var4] = var103;
                           }

                           Widget.method3468(var4);
                           field339[++field543 - 1 & 31] = var4;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 72) {
                           var4 = field446.method2551();
                           var5 = field446.method2556();
                           var29 = field446.method2551();
                           class10.method126(var4, var5, var29);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 151) {
                           class13.xteaChanged(true);
                           field446.method2819();
                           var4 = field446.method2551();
                           class14.method170(field446, var4);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 134) {
                           class144.method3029();
                           packetOpcode = -1;
                           var65 = false;
                           break label3974;
                        }

                        if(packetOpcode == 118) {
                           field297 = field446.method2591() * 30;
                           field476 = field532;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        boolean var78;
                        boolean var86;
                        if(packetOpcode == 63) {
                           var108 = field446.method2774();
                           var5 = field446.method2551();
                           byte var145 = field446.method2557();
                           var78 = false;
                           if(var145 == -128) {
                              var78 = true;
                           }

                           if(var78) {
                              if(class1.field25 == 0) {
                                 packetOpcode = -1;
                                 var65 = true;
                                 break label3974;
                              }

                              var86 = false;

                              for(var8 = 0; var8 < class1.field25 && (!class13.clanMembers[var8].username.equals(var108) || class13.clanMembers[var8].world != var5); ++var8) {
                                 ;
                              }

                              if(var8 < class1.field25) {
                                 while(var8 < class1.field25 - 1) {
                                    class13.clanMembers[var8] = class13.clanMembers[var8 + 1];
                                    ++var8;
                                 }

                                 --class1.field25;
                                 class13.clanMembers[class1.field25] = null;
                              }
                           } else {
                              field446.method2774();
                              XClanMember var126 = new XClanMember();
                              var126.username = var108;
                              var126.field628 = class10.method123(var126.username, class127.field2087);
                              var126.world = var5;
                              var126.rank = var145;

                              for(var32 = class1.field25 - 1; var32 >= 0; --var32) {
                                 var10 = class13.clanMembers[var32].field628.compareTo(var126.field628);
                                 if(var10 == 0) {
                                    class13.clanMembers[var32].world = var5;
                                    class13.clanMembers[var32].rank = var145;
                                    if(var108.equals(class48.localPlayer.name)) {
                                       class26.field636 = var145;
                                    }

                                    field534 = field532;
                                    packetOpcode = -1;
                                    var65 = true;
                                    break label3974;
                                 }

                                 if(var10 < 0) {
                                    break;
                                 }
                              }

                              if(class1.field25 >= class13.clanMembers.length) {
                                 packetOpcode = -1;
                                 var65 = true;
                                 break label3974;
                              }

                              for(var10 = class1.field25 - 1; var10 > var32; --var10) {
                                 class13.clanMembers[1 + var10] = class13.clanMembers[var10];
                              }

                              if(class1.field25 == 0) {
                                 class13.clanMembers = new XClanMember[100];
                              }

                              class13.clanMembers[1 + var32] = var126;
                              ++class1.field25;
                              if(var108.equals(class48.localPlayer.name)) {
                                 class26.field636 = var145;
                              }
                           }

                           field534 = field532;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        String var72;
                        String var119;
                        if(packetOpcode == 36) {
                           while(field446.offset < field326) {
                              var4 = field446.method2556();
                              var98 = (var4 & 1) == 1;
                              var72 = field446.method2774();
                              var119 = field446.method2774();
                              field446.method2774();

                              for(var8 = 0; var8 < ignoreCount; ++var8) {
                                 Ignore var80 = ignores[var8];
                                 if(var98) {
                                    if(var119.equals(var80.name)) {
                                       var80.name = var72;
                                       var80.previousName = var119;
                                       var68 = null;
                                       break;
                                    }
                                 } else if(var72.equals(var80.name)) {
                                    var80.name = var72;
                                    var80.previousName = var119;
                                    var68 = null;
                                    break;
                                 }
                              }
                           }

                           field472 = field532;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 6) {
                           if(widgetRoot != -1) {
                              var4 = widgetRoot;
                              if(class175.method3419(var4)) {
                                 class52.method1059(Widget.widgets[var4], 0);
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 113 || packetOpcode == 225 || packetOpcode == 95 || packetOpcode == 152 || packetOpcode == 250 || packetOpcode == 109 || packetOpcode == 82 || packetOpcode == 168 || packetOpcode == 42 || packetOpcode == 142) {
                           class129.method2870();
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 170) {
                           class34.field760 = 0;

                           for(var4 = 0; var4 < 2048; ++var4) {
                              class34.field759[var4] = null;
                              class34.field758[var4] = 1;
                           }

                           for(var4 = 0; var4 < 2048; ++var4) {
                              cachedPlayers[var4] = null;
                           }

                           VertexNormal.method2251(field446);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        long var92;
                        WidgetNode var114;
                        if(packetOpcode == 86) {
                           var4 = field446.offset + field326;
                           var5 = field446.method2551();
                           var29 = field446.method2551();
                           if(widgetRoot != var5) {
                              widgetRoot = var5;
                              var7 = widgetRoot;
                              var8 = FaceNormal.field1499;
                              var32 = class212.field3175;
                              if(class175.method3419(var7)) {
                                 method353(Widget.widgets[var7], -1, var8, var32, false);
                              }

                              class136.method2911(widgetRoot);
                              MessageNode.method735(widgetRoot);

                              for(var7 = 0; var7 < 100; ++var7) {
                                 field484[var7] = true;
                              }
                           }

                           WidgetNode var109;
                           for(; var29-- > 0; var109.field57 = true) {
                              var7 = field446.method2561();
                              var8 = field446.method2551();
                              var32 = field446.method2556();
                              var109 = (WidgetNode)componentTable.method3830((long)var7);
                              if(null != var109 && var109.id != var8) {
                                 class62.method1313(var109, true);
                                 var109 = null;
                              }

                              if(var109 == null) {
                                 WidgetNode var123 = new WidgetNode();
                                 var123.id = var8;
                                 var123.field53 = var32;
                                 componentTable.method3819(var123, (long)var7);
                                 class136.method2911(var8);
                                 Widget var129 = World.method628(var7);
                                 class75.method1606(var129);
                                 if(null != field443) {
                                    class75.method1606(field443);
                                    field443 = null;
                                 }

                                 class47.method971();
                                 class21.method554(Widget.widgets[var7 >> 16], var129, false);
                                 MessageNode.method735(var8);
                                 if(widgetRoot != -1) {
                                    var14 = widgetRoot;
                                    if(class175.method3419(var14)) {
                                       class52.method1059(Widget.widgets[var14], 1);
                                    }
                                 }

                                 var109 = var123;
                              }
                           }

                           for(var114 = (WidgetNode)componentTable.method3821(); var114 != null; var114 = (WidgetNode)componentTable.method3822()) {
                              if(var114.field57) {
                                 var114.field57 = false;
                              } else {
                                 class62.method1313(var114, true);
                              }
                           }

                           widgetFlags = new XHashTable(512);

                           while(field446.offset < var4) {
                              var7 = field446.method2561();
                              var8 = field446.method2551();
                              var32 = field446.method2551();
                              var10 = field446.method2561();

                              for(var11 = var8; var11 <= var32; ++var11) {
                                 var92 = ((long)var7 << 32) + (long)var11;
                                 widgetFlags.method3819(new class204(var10), var92);
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 77) {
                           var4 = field446.method2601();
                           var5 = field446.method2551();
                           var68 = World.method628(var4);
                           if(var68.modelType != 1 || var5 != var68.modelId) {
                              var68.modelType = 1;
                              var68.modelId = var5;
                              class75.method1606(var68);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 195) {
                           var4 = field446.method2556();
                           var5 = field446.method2556();
                           var29 = field446.method2556();
                           var7 = field446.method2556();
                           field529[var4] = true;
                           field530[var4] = var5;
                           field562[var4] = var29;
                           field503[var4] = var7;
                           field533[var4] = 0;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 117) {
                           var4 = field446.method2601();
                           var36 = World.method628(var4);

                           for(var29 = 0; var29 < var36.itemIds.length; ++var29) {
                              var36.itemIds[var29] = -1;
                              var36.itemIds[var29] = 0;
                           }

                           class75.method1606(var36);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        long var135;
                        if(packetOpcode == 185) {
                           var4 = field446.method2592();
                           if(var4 == '\uffff') {
                              var4 = -1;
                           }

                           var5 = field446.method2561();
                           var29 = field446.method2591();
                           if(var29 == '\uffff') {
                              var29 = -1;
                           }

                           var7 = field446.method2561();

                           for(var8 = var4; var8 <= var29; ++var8) {
                              var135 = ((long)var7 << 32) + (long)var8;
                              Node var131 = widgetFlags.method3830(var135);
                              if(var131 != null) {
                                 var131.unlink();
                              }

                              widgetFlags.method3819(new class204(var5), var135);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 164) {
                           field502 = 1;
                           field472 = field532;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 209) {
                           class112.field1969 = field446.method2583();
                           class13.field196 = field446.method2583();

                           while(field446.offset < field326) {
                              packetOpcode = field446.method2556();
                              class129.method2870();
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        boolean var96;
                        if(packetOpcode == 194) {
                           var96 = field446.method2556() == 1;
                           if(var96) {
                              class53.field1137 = class34.method713() - field446.method2562();
                              WidgetNode.field55 = new class224(field446, true);
                           } else {
                              WidgetNode.field55 = null;
                           }

                           field496 = field532;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 149) {
                           flagX = field446.method2556();
                           if(flagX == 255) {
                              flagX = 0;
                           }

                           flagY = field446.method2556();
                           if(flagY == 255) {
                              flagY = 0;
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 240) {
                           var4 = field446.method2592();
                           WidgetNode.method45(var4);
                           field467[++field557 - 1 & 31] = var4 & 32767;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 43) {
                           class13.xteaChanged(false);
                           field446.method2819();
                           var4 = field446.method2551();
                           class14.method170(field446, var4);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        class125 var112;
                        if(packetOpcode == 144) {
                           field446.offset += 28;
                           if(field446.method2579()) {
                              var112 = field446;
                              var5 = field446.offset - 28;
                              if(class152.field2286 != null) {
                                 try {
                                    class152.field2286.method4159(0L);
                                    class152.field2286.method4157(var112.payload, var5, 24);
                                 } catch (Exception var50) {
                                    ;
                                 }
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        String var134;
                        if(packetOpcode == 7) {
                           var4 = field446.method2556();
                           var134 = field446.method2774();
                           var29 = field446.method2752();
                           if(var29 >= 1 && var29 <= 8) {
                              if(var134.equalsIgnoreCase("null")) {
                                 var134 = null;
                              }

                              field408[var29 - 1] = var134;
                              field409[var29 - 1] = var4 == 0;
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 100) {
                           field525 = field446.method2556();
                           if(field525 == 1) {
                              field299 = field446.method2551();
                           }

                           if(field525 >= 2 && field525 <= 6) {
                              if(field525 == 2) {
                                 field355 = 64;
                                 field305 = 64;
                              }

                              if(field525 == 3) {
                                 field355 = 0;
                                 field305 = 64;
                              }

                              if(field525 == 4) {
                                 field355 = 128;
                                 field305 = 64;
                              }

                              if(field525 == 5) {
                                 field355 = 64;
                                 field305 = 0;
                              }

                              if(field525 == 6) {
                                 field355 = 64;
                                 field305 = 128;
                              }

                              field525 = 2;
                              field419 = field446.method2551();
                              field302 = field446.method2551();
                              field303 = field446.method2556();
                           }

                           if(field525 == 10) {
                              field300 = field446.method2551();
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 65) {
                           for(var4 = 0; var4 < cachedPlayers.length; ++var4) {
                              if(null != cachedPlayers[var4]) {
                                 cachedPlayers[var4].animation = -1;
                              }
                           }

                           for(var4 = 0; var4 < cachedNPCs.length; ++var4) {
                              if(null != cachedNPCs[var4]) {
                                 cachedNPCs[var4].animation = -1;
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 20) {
                           var4 = field446.method2561();
                           WidgetNode var140 = (WidgetNode)componentTable.method3830((long)var4);
                           if(null != var140) {
                              class62.method1313(var140, true);
                           }

                           if(field443 != null) {
                              class75.method1606(field443);
                              field443 = null;
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        String var104;
                        if(packetOpcode == 221) {
                           var108 = field446.method2774();
                           class125 var85 = field446;

                           try {
                              var8 = var85.method2569();
                              if(var8 > 32767) {
                                 var8 = 32767;
                              }

                              byte[] var79 = new byte[var8];
                              var85.offset += class225.field3232.method2495(var85.payload, var85.offset, var79, 0, var8);
                              var104 = class14.method169(var79, 0, var8);
                              var119 = var104;
                           } catch (Exception var49) {
                              var119 = "Cabbage";
                           }

                           var119 = class226.method4082(class26.method585(var119));
                           class23.sendGameMessage(6, var108, var119);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 175) {
                           var4 = field446.method2603();
                           var5 = field446.method2591();
                           var29 = var5 >> 10 & 31;
                           var7 = var5 >> 5 & 31;
                           var8 = var5 & 31;
                           var32 = (var8 << 3) + (var7 << 11) + (var29 << 19);
                           Widget var107 = World.method628(var4);
                           if(var32 != var107.textColor) {
                              var107.textColor = var32;
                              class75.method1606(var107);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 178) {
                           class20.method543(true);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 116) {
                           var4 = field446.method2599();
                           var5 = field446.method2591();
                           var29 = field446.method2727();
                           var114 = (WidgetNode)componentTable.method3830((long)var29);
                           if(var114 != null) {
                              class62.method1313(var114, var5 != var114.id);
                           }

                           WidgetNode var125 = new WidgetNode();
                           var125.id = var5;
                           var125.field53 = var4;
                           componentTable.method3819(var125, (long)var29);
                           class136.method2911(var5);
                           Widget var77 = World.method628(var29);
                           class75.method1606(var77);
                           if(field443 != null) {
                              class75.method1606(field443);
                              field443 = null;
                           }

                           class47.method971();
                           class21.method554(Widget.widgets[var29 >> 16], var77, false);
                           MessageNode.method735(var5);
                           if(widgetRoot != -1) {
                              var10 = widgetRoot;
                              if(class175.method3419(var10)) {
                                 class52.method1059(Widget.widgets[var10], 1);
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 208) {
                           field534 = field532;
                           if(field326 == 0) {
                              field541 = null;
                              field507 = null;
                              class1.field25 = 0;
                              class13.clanMembers = null;
                              packetOpcode = -1;
                              var65 = true;
                              break label3974;
                           }

                           field507 = field446.method2774();
                           long var99 = field446.method2562();
                           field541 = Tile.method2345(var99);
                           DecorativeObject.field1663 = field446.method2557();
                           var29 = field446.method2556();
                           if(var29 == 255) {
                              packetOpcode = -1;
                              var65 = true;
                              break label3974;
                           }

                           class1.field25 = var29;
                           XClanMember[] var117 = new XClanMember[100];

                           for(var8 = 0; var8 < class1.field25; ++var8) {
                              var117[var8] = new XClanMember();
                              var117[var8].username = field446.method2774();
                              var117[var8].field628 = class10.method123(var117[var8].username, class127.field2087);
                              var117[var8].world = field446.method2551();
                              var117[var8].rank = field446.method2557();
                              field446.method2774();
                              if(var117[var8].username.equals(class48.localPlayer.name)) {
                                 class26.field636 = var117[var8].rank;
                              }
                           }

                           var86 = false;
                           var10 = class1.field25;

                           while(var10 > 0) {
                              var86 = true;
                              --var10;

                              for(var11 = 0; var11 < var10; ++var11) {
                                 if(var117[var11].field628.compareTo(var117[var11 + 1].field628) > 0) {
                                    XClanMember var76 = var117[var11];
                                    var117[var11] = var117[1 + var11];
                                    var117[1 + var11] = var76;
                                    var86 = false;
                                 }
                              }

                              if(var86) {
                                 break;
                              }
                           }

                           class13.clanMembers = var117;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 201) {
                           var4 = field446.method2561();
                           var5 = field446.method2561();
                           if(null == class113.field1987 || !class113.field1987.isValid()) {
                              try {
                                 Iterator var83 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                                 while(var83.hasNext()) {
                                    GarbageCollectorMXBean var116 = (GarbageCollectorMXBean)var83.next();
                                    if(var116.isValid()) {
                                       class113.field1987 = var116;
                                       field376 = -1L;
                                       field469 = -1L;
                                    }
                                 }
                              } catch (Throwable var58) {
                                 ;
                              }
                           }

                           long var132 = class34.method713();
                           var8 = -1;
                           if(class113.field1987 != null) {
                              var135 = class113.field1987.getCollectionTime();
                              if(-1L != field469) {
                                 long var89 = var135 - field469;
                                 long var95 = var132 - field376;
                                 if(var95 != 0L) {
                                    var8 = (int)(100L * var89 / var95);
                                 }
                              }

                              field469 = var135;
                              field376 = var132;
                           }

                           field323.method2818(3);
                           field323.method2582(GameEngine.FPS);
                           field323.method2544(var4);
                           field323.method2544(var5);
                           field323.method2582(var8);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        Widget var113;
                        if(packetOpcode == 238) {
                           var4 = field446.method2603();
                           var5 = field446.method2601();
                           var29 = field446.method2551();
                           if(var29 == '\uffff') {
                              var29 = -1;
                           }

                           var113 = World.method628(var5);
                           ItemComposition var121;
                           if(!var113.field2809) {
                              if(var29 == -1) {
                                 var113.modelType = 0;
                                 packetOpcode = -1;
                                 var65 = true;
                                 break label3974;
                              }

                              var121 = MessageNode.getItemDefinition(var29);
                              var113.modelType = 4;
                              var113.modelId = var29;
                              var113.rotationX = var121.field1167;
                              var113.rotationZ = var121.field1171;
                              var113.field2864 = var121.field1169 * 100 / var4;
                              class75.method1606(var113);
                           } else {
                              var113.item = var29;
                              var113.stackSize = var4;
                              var121 = MessageNode.getItemDefinition(var29);
                              var113.rotationX = var121.field1167;
                              var113.rotationZ = var121.field1171;
                              var113.rotationY = var121.field1203;
                              var113.field2873 = var121.field1158;
                              var113.field2860 = var121.field1168;
                              var113.field2864 = var121.field1169;
                              if(var121.isStackable == 1) {
                                 var113.field2942 = 1;
                              } else {
                                 var113.field2942 = 2;
                              }

                              if(var113.field2929 > 0) {
                                 var113.field2864 = var113.field2864 * 32 / var113.field2929;
                              } else if(var113.field2884 > 0) {
                                 var113.field2864 = var113.field2864 * 32 / var113.field2884;
                              }

                              class75.method1606(var113);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        long var91;
                        if(packetOpcode == 182) {
                           var108 = field446.method2774();
                           var100 = (long)field446.method2551();
                           var91 = (long)field446.method2560();
                           class155 var75 = (class155)class5.method98(World.method611(), field446.method2556());
                           long var84 = (var100 << 32) + var91;
                           boolean var94 = false;

                           for(var13 = 0; var13 < 100; ++var13) {
                              if(var84 == field500[var13]) {
                                 var94 = true;
                                 break;
                              }
                           }

                           if(class140.method2968(var108)) {
                              var94 = true;
                           }

                           if(!var94 && field304 == 0) {
                              field500[field501] = var84;
                              field501 = (field501 + 1) % 100;
                              class125 var136 = field446;

                              String var148;
                              try {
                                 var16 = var136.method2569();
                                 if(var16 > 32767) {
                                    var16 = 32767;
                                 }

                                 byte[] var144 = new byte[var16];
                                 var136.offset += class225.field3232.method2495(var136.payload, var136.offset, var144, 0, var16);
                                 String var142 = class14.method169(var144, 0, var16);
                                 var148 = var142;
                              } catch (Exception var48) {
                                 var148 = "Cabbage";
                              }

                              var148 = class226.method4082(class26.method585(var148));
                              byte var97;
                              if(var75.field2317) {
                                 var97 = 7;
                              } else {
                                 var97 = 3;
                              }

                              if(var75.field2310 != -1) {
                                 class23.sendGameMessage(var97, class112.method2479(var75.field2310) + var108, var148);
                              } else {
                                 class23.sendGameMessage(var97, var108, var148);
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        boolean var87;
                        if(packetOpcode == 165) {
                           var108 = field446.method2774();
                           var100 = field446.method2562();
                           var91 = (long)field446.method2551();
                           var135 = (long)field446.method2560();
                           class155 var35 = (class155)class5.method98(World.method611(), field446.method2556());
                           var92 = (var91 << 32) + var135;
                           var87 = false;

                           for(var15 = 0; var15 < 100; ++var15) {
                              if(field500[var15] == var92) {
                                 var87 = true;
                                 break;
                              }
                           }

                           if(var35.field2316 && class140.method2968(var108)) {
                              var87 = true;
                           }

                           if(!var87 && field304 == 0) {
                              field500[field501] = var92;
                              field501 = (field501 + 1) % 100;
                              class125 var150 = field446;

                              String var141;
                              try {
                                 var18 = var150.method2569();
                                 if(var18 > 32767) {
                                    var18 = 32767;
                                 }

                                 byte[] var42 = new byte[var18];
                                 var150.offset += class225.field3232.method2495(var150.payload, var150.offset, var42, 0, var18);
                                 String var151 = class14.method169(var42, 0, var18);
                                 var141 = var151;
                              } catch (Exception var47) {
                                 var141 = "Cabbage";
                              }

                              var141 = class226.method4082(class26.method585(var141));
                              if(var35.field2310 != -1) {
                                 class13.addChatMessage(9, class112.method2479(var35.field2310) + var108, var141, class159.method3202(var100));
                              } else {
                                 class13.addChatMessage(9, var108, var141, class159.method3202(var100));
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 114) {
                           class112.field1969 = field446.method2599();
                           class13.field196 = field446.method2583();

                           for(var4 = class13.field196; var4 < class13.field196 + 8; ++var4) {
                              for(var5 = class112.field1969; var5 < class112.field1969 + 8; ++var5) {
                                 if(groundItemDeque[FrameMap.plane][var4][var5] != null) {
                                    groundItemDeque[FrameMap.plane][var4][var5] = null;
                                    class116.groundItemSpawned(var4, var5);
                                 }
                              }
                           }

                           for(var106 = (class16)field413.method3850(); var106 != null; var106 = (class16)field413.method3852()) {
                              if(var106.field244 >= class13.field196 && var106.field244 < class13.field196 + 8 && var106.field235 >= class112.field1969 && var106.field235 < 8 + class112.field1969 && FrameMap.plane == var106.field243) {
                                 var106.field241 = 0;
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 159) {
                           for(var4 = 0; var4 < class22.field583; ++var4) {
                              class56 var139 = class35.method714(var4);
                              if(var139 != null) {
                                 class179.settings[var4] = 0;
                                 class179.widgetSettings[var4] = 0;
                              }
                           }

                           World.method626();
                           field543 += 32;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 35) {
                           var108 = field446.method2774();
                           Object[] var137 = new Object[var108.length() + 1];

                           for(var29 = var108.length() - 1; var29 >= 0; --var29) {
                              if(var108.charAt(var29) == 115) {
                                 var137[var29 + 1] = field446.method2774();
                              } else {
                                 var137[var29 + 1] = new Integer(field446.method2561());
                              }
                           }

                           var137[0] = new Integer(field446.method2561());
                           class0 var81 = new class0();
                           var81.field8 = var137;
                           class158.method3201(var81, 200000);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 181) {
                           World.method626();
                           energy = field446.method2556();
                           field476 = field532;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 90) {
                           var4 = field446.method2569();
                           var98 = field446.method2556() == 1;
                           var72 = "";
                           var78 = false;
                           if(var98) {
                              var72 = field446.method2774();
                              if(class140.method2968(var72)) {
                                 var78 = true;
                              }
                           }

                           String var120 = field446.method2774();
                           if(!var78) {
                              class23.sendGameMessage(var4, var72, var120);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 60) {
                           class20.method543(false);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 5) {
                           field442 = field446.method2556();
                           field322 = field446.method2556();
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 147) {
                           field418 = true;
                           TextureProvider.field1667 = field446.method2556();
                           class20.field571 = field446.method2556();
                           XItemContainer.field222 = field446.method2551();
                           VertexNormal.field1685 = field446.method2556();
                           class143.field2214 = field446.method2556();
                           if(class143.field2214 >= 100) {
                              Ignore.cameraX = TextureProvider.field1667 * 128 + 64;
                              WallObject.cameraY = 64 + class20.field571 * 128;
                              class119.cameraZ = KitDefinition.method936(Ignore.cameraX, WallObject.cameraY, FrameMap.plane) - XItemContainer.field222;
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 30) {
                           var4 = field446.method2561();
                           var5 = field446.method2551();
                           if(var4 < -70000) {
                              var5 += '耀';
                           }

                           if(var4 >= 0) {
                              var68 = World.method628(var4);
                           } else {
                              var68 = null;
                           }

                           for(; field446.offset < field326; class144.method3035(var5, var7, var8 - 1, var32)) {
                              var7 = field446.method2569();
                              var8 = field446.method2551();
                              var32 = 0;
                              if(var8 != 0) {
                                 var32 = field446.method2556();
                                 if(var32 == 255) {
                                    var32 = field446.method2561();
                                 }
                              }

                              if(var68 != null && var7 >= 0 && var7 < var68.itemIds.length) {
                                 var68.itemIds[var7] = var8;
                                 var68.itemQuantities[var7] = var32;
                              }
                           }

                           if(var68 != null) {
                              class75.method1606(var68);
                           }

                           World.method626();
                           field467[++field557 - 1 & 31] = var5 & 32767;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 202) {
                           var4 = field446.method2594();
                           var5 = field446.method2561();
                           var68 = World.method628(var5);
                           if(var68.field2857 != var4 || var4 == -1) {
                              var68.field2857 = var4;
                              var68.field2932 = 0;
                              var68.field2945 = 0;
                              class75.method1606(var68);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 1) {
                           World.method626();
                           weight = field446.method2759();
                           field476 = field532;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 58) {
                           while(field446.offset < field326) {
                              var96 = field446.method2556() == 1;
                              var134 = field446.method2774();
                              var72 = field446.method2774();
                              var7 = field446.method2551();
                              var8 = field446.method2556();
                              var32 = field446.method2556();
                              boolean var82 = (var32 & 2) != 0;
                              boolean var88 = (var32 & 1) != 0;
                              if(var7 > 0) {
                                 field446.method2774();
                                 field446.method2556();
                                 field446.method2561();
                              }

                              field446.method2774();

                              for(var12 = 0; var12 < friendCount; ++var12) {
                                 Friend var128 = friends[var12];
                                 if(!var96) {
                                    if(var134.equals(var128.name)) {
                                       if(var128.world != var7) {
                                          var87 = true;

                                          for(class40 var147 = (class40)field550.method3809(); null != var147; var147 = (class40)field550.method3810()) {
                                             if(var147.field877.equals(var134)) {
                                                if(var7 != 0 && var147.field881 == 0) {
                                                   var147.method3941();
                                                   var87 = false;
                                                } else if(var7 == 0 && var147.field881 != 0) {
                                                   var147.method3941();
                                                   var87 = false;
                                                }
                                             }
                                          }

                                          if(var87) {
                                             field550.method3812(new class40(var134, var7));
                                          }

                                          var128.world = var7;
                                       }

                                       var128.previousName = var72;
                                       var128.rank = var8;
                                       var128.field256 = var82;
                                       var128.field252 = var88;
                                       var36 = null;
                                       break;
                                    }
                                 } else if(var72.equals(var128.name)) {
                                    var128.name = var134;
                                    var128.previousName = var72;
                                    var36 = null;
                                    break;
                                 }
                              }
                           }

                           field502 = 2;
                           field472 = field532;
                           var96 = false;
                           var5 = friendCount;

                           while(var5 > 0) {
                              var96 = true;
                              --var5;

                              for(var29 = 0; var29 < var5; ++var29) {
                                 var78 = false;
                                 Friend var118 = friends[var29];
                                 Friend var74 = friends[1 + var29];
                                 if(var118.world != world && var74.world == world) {
                                    var78 = true;
                                 }

                                 if(!var78 && var118.world == 0 && var74.world != 0) {
                                    var78 = true;
                                 }

                                 if(!var78 && !var118.field256 && var74.field256) {
                                    var78 = true;
                                 }

                                 if(!var78 && !var118.field252 && var74.field252) {
                                    var78 = true;
                                 }

                                 if(var78) {
                                    Friend var105 = friends[var29];
                                    friends[var29] = friends[1 + var29];
                                    friends[var29 + 1] = var105;
                                    var96 = false;
                                 }
                              }

                              if(var96) {
                                 break;
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 216) {
                           var4 = field446.method2561();
                           var98 = field446.method2556() == 1;
                           var68 = World.method628(var4);
                           if(var68.isHidden != var98) {
                              var68.isHidden = var98;
                              class75.method1606(var68);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 214) {
                           var4 = field446.method2551();
                           widgetRoot = var4;
                           var5 = widgetRoot;
                           var29 = FaceNormal.field1499;
                           var7 = class212.field3175;
                           if(class175.method3419(var5)) {
                              method353(Widget.widgets[var5], -1, var29, var7, false);
                           }

                           class136.method2911(var4);
                           MessageNode.method735(widgetRoot);

                           for(var5 = 0; var5 < 100; ++var5) {
                              field484[var5] = true;
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 96) {
                           class14.method170(field446, field326);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 67) {
                           var4 = field446.method2601();
                           var36 = World.method628(var4);
                           var36.modelType = 3;
                           var36.modelId = class48.localPlayer.composition.method3505();
                           class75.method1606(var36);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 25) {
                           var4 = field446.method2561();
                           var5 = field446.method2551();
                           if(var4 < -70000) {
                              var5 += '耀';
                           }

                           if(var4 >= 0) {
                              var68 = World.method628(var4);
                           } else {
                              var68 = null;
                           }

                           FrameMap.method2346(var5);
                           var7 = field446.method2551();

                           for(var8 = 0; var8 < var7; ++var8) {
                              var32 = field446.method2556();
                              if(var32 == 255) {
                                 var32 = field446.method2561();
                              }

                              var10 = field446.method2551();
                              if(null != var68 && var8 < var68.itemIds.length) {
                                 var68.itemIds[var8] = var10;
                                 var68.itemQuantities[var8] = var32;
                              }

                              class144.method3035(var5, var8, var10 - 1, var32);
                           }

                           if(var68 != null) {
                              class75.method1606(var68);
                           }

                           World.method626();
                           field467[++field557 - 1 & 31] = var5 & 32767;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 145) {
                           var4 = field446.method2551();
                           if(var4 == '\uffff') {
                              var4 = -1;
                           }

                           if(var4 == -1 && !field518) {
                              class186.field3008.method3670();
                              class186.field3009 = 1;
                              class186.field3010 = null;
                           } else if(var4 != -1 && var4 != field517 && field516 != 0 && !field518) {
                              class24.method578(2, class192.field3108, var4, 0, field516, false);
                           }

                           field517 = var4;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 207) {
                           var4 = field446.method2585();
                           var5 = field446.method2592();
                           if(var5 == '\uffff') {
                              var5 = -1;
                           }

                           if(field516 != 0 && var5 != -1) {
                              Buffer.method2775(class129.field2094, var5, 0, field516, false);
                              field518 = true;
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        Widget var115;
                        if(packetOpcode == 212) {
                           var4 = field446.method2551();
                           var5 = field446.method2592();
                           var29 = field446.method2561();
                           var7 = field446.method2593();
                           var115 = World.method628(var29);
                           if(var115.rotationX != var5 || var115.rotationZ != var7 || var115.field2864 != var4) {
                              var115.rotationX = var5;
                              var115.rotationZ = var7;
                              var115.field2864 = var4;
                              class75.method1606(var115);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 107) {
                           for(var4 = 0; var4 < class179.widgetSettings.length; ++var4) {
                              if(class179.widgetSettings[var4] != class179.settings[var4]) {
                                 class179.widgetSettings[var4] = class179.settings[var4];
                                 Widget.method3468(var4);
                                 field339[++field543 - 1 & 31] = var4;
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 156) {
                           field515 = field446.method2556();
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 45) {
                           var4 = field446.method2561();
                           var5 = field446.method2603();
                           WidgetNode var70 = (WidgetNode)componentTable.method3830((long)var4);
                           var114 = (WidgetNode)componentTable.method3830((long)var5);
                           if(null != var114) {
                              class62.method1313(var114, var70 == null || var70.id != var114.id);
                           }

                           if(null != var70) {
                              var70.unlink();
                              componentTable.method3819(var70, (long)var5);
                           }

                           var115 = World.method628(var4);
                           if(var115 != null) {
                              class75.method1606(var115);
                           }

                           var115 = World.method628(var5);
                           if(var115 != null) {
                              class75.method1606(var115);
                              class21.method554(Widget.widgets[var115.id >>> 16], var115, true);
                           }

                           if(widgetRoot != -1) {
                              var32 = widgetRoot;
                              if(class175.method3419(var32)) {
                                 class52.method1059(Widget.widgets[var32], 1);
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 239) {
                           var108 = field446.method2774();
                           var5 = field446.method2727();
                           var68 = World.method628(var5);
                           if(!var108.equals(var68.text)) {
                              var68.text = var108;
                              class75.method1606(var68);
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 125) {
                           var4 = field446.method2603();
                           var5 = field446.method2551();
                           class179.settings[var5] = var4;
                           if(class179.widgetSettings[var5] != var4) {
                              class179.widgetSettings[var5] = var4;
                           }

                           Widget.method3468(var5);
                           field339[++field543 - 1 & 31] = var5;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 111) {
                           var4 = field446.method2556();
                           if(field446.method2556() == 0) {
                              grandExchangeOffers[var4] = new XGrandExchangeOffer();
                              field446.offset += 18;
                           } else {
                              --field446.offset;
                              grandExchangeOffers[var4] = new XGrandExchangeOffer(field446, false);
                           }

                           field474 = field532;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 219) {
                           class8.field142 = WallObject.method2123(field446.method2556());
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 16) {
                           class53.method1077(field446.method2774());
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 105) {
                           World.method626();
                           var4 = field446.method2561();
                           var5 = field446.method2556();
                           var29 = field446.method2556();
                           skillExperiences[var29] = var4;
                           boostedSkillLevels[var29] = var5;
                           realSkillLevels[var29] = 1;

                           for(var7 = 0; var7 < 98; ++var7) {
                              if(var4 >= class158.field2351[var7]) {
                                 realSkillLevels[var29] = 2 + var7;
                              }
                           }

                           field342[++field458 - 1 & 31] = var29;
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 192) {
                           var4 = field446.method2561();
                           var5 = field446.method2592();
                           var29 = field446.method2592();
                           var113 = World.method628(var4);
                           var113.field2866 = var29 + (var5 << 16);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 231) {
                           var4 = field446.method2561();
                           class141.field2189 = class127.field2086.method2928(var4);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 12) {
                           class13.field196 = field446.method2556();
                           class112.field1969 = field446.method2556();
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 68) {
                           var112 = field446;
                           var5 = field326;
                           ClassInfo var69 = new ClassInfo();
                           var69.field3182 = var112.method2556();
                           var69.field3184 = var112.method2561();
                           var69.field3177 = new int[var69.field3182];
                           var69.field3179 = new int[var69.field3182];
                           var69.fields = new Field[var69.field3182];
                           var69.field3181 = new int[var69.field3182];
                           var69.methods = new Method[var69.field3182];
                           var69.args = new byte[var69.field3182][][];

                           for(var7 = 0; var7 < var69.field3182; ++var7) {
                              try {
                                 var8 = var112.method2556();
                                 String var73;
                                 if(var8 != 0 && var8 != 1 && var8 != 2) {
                                    if(var8 == 3 || var8 == 4) {
                                       var73 = var112.method2774();
                                       var104 = var112.method2774();
                                       var11 = var112.method2556();
                                       String[] var33 = new String[var11];

                                       for(var13 = 0; var13 < var11; ++var13) {
                                          var33[var13] = var112.method2774();
                                       }

                                       String var34 = var112.method2774();
                                       byte[][] var37 = new byte[var11][];
                                       if(var8 == 3) {
                                          for(var15 = 0; var15 < var11; ++var15) {
                                             var16 = var112.method2561();
                                             var37[var15] = new byte[var16];
                                             var112.method2567(var37[var15], 0, var16);
                                          }
                                       }

                                       var69.field3177[var7] = var8;
                                       Class[] var40 = new Class[var11];

                                       for(var16 = 0; var16 < var11; ++var16) {
                                          var40[var16] = class172.method3393(var33[var16]);
                                       }

                                       Class var41 = class172.method3393(var34);
                                       if(class172.method3393(var73).getClassLoader() == null) {
                                          throw new SecurityException();
                                       }

                                       Method[] var38 = class172.method3393(var73).getDeclaredMethods();
                                       Method[] var39 = var38;

                                       for(var19 = 0; var19 < var39.length; ++var19) {
                                          Method var43 = var39[var19];
                                          if(var43.getName().equals(var104)) {
                                             Class[] var44 = var43.getParameterTypes();
                                             if(var44.length == var40.length) {
                                                boolean var101 = true;

                                                for(int var45 = 0; var45 < var40.length; ++var45) {
                                                   if(var40[var45] != var44[var45]) {
                                                      var101 = false;
                                                      break;
                                                   }
                                                }

                                                if(var101 && var41 == var43.getReturnType()) {
                                                   var69.methods[var7] = var43;
                                                }
                                             }
                                          }
                                       }

                                       var69.args[var7] = var37;
                                    }
                                 } else {
                                    var73 = var112.method2774();
                                    var104 = var112.method2774();
                                    var11 = 0;
                                    if(var8 == 1) {
                                       var11 = var112.method2561();
                                    }

                                    var69.field3177[var7] = var8;
                                    var69.field3181[var7] = var11;
                                    if(class172.method3393(var73).getClassLoader() == null) {
                                       throw new SecurityException();
                                    }

                                    var69.fields[var7] = class172.method3393(var73).getDeclaredField(var104);
                                 }
                              } catch (ClassNotFoundException var53) {
                                 var69.field3179[var7] = -1;
                              } catch (SecurityException var54) {
                                 var69.field3179[var7] = -2;
                              } catch (NullPointerException var55) {
                                 var69.field3179[var7] = -3;
                              } catch (Exception var56) {
                                 var69.field3179[var7] = -4;
                              } catch (Throwable var57) {
                                 var69.field3179[var7] = -5;
                              }
                           }

                           class214.field3187.method3883(var69);
                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 54) {
                           World var111 = new World();
                           var111.address = field446.method2774();
                           var111.id = field446.method2551();
                           var5 = field446.method2561();
                           var111.mask = var5;
                           class130.setGameState(45);
                           Item.field694.method3044();
                           Item.field694 = null;
                           class85.selectWorld(var111);
                           packetOpcode = -1;
                           var65 = false;
                           break label3974;
                        }

                        if(packetOpcode == 56) {
                           field418 = true;
                           Frames.field1831 = field446.method2556();
                           field461 = field446.method2556();
                           class5.field86 = field446.method2551();
                           class35.field777 = field446.method2556();
                           class8.field141 = field446.method2556();
                           if(class8.field141 >= 100) {
                              var4 = Frames.field1831 * 128 + 64;
                              var5 = 64 + field461 * 128;
                              var29 = KitDefinition.method936(var4, var5, FrameMap.plane) - class5.field86;
                              var7 = var4 - Ignore.cameraX;
                              var8 = var29 - class119.cameraZ;
                              var32 = var5 - WallObject.cameraY;
                              var10 = (int)Math.sqrt((double)(var32 * var32 + var7 * var7));
                              class53.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                              cameraYaw = (int)(Math.atan2((double)var7, (double)var32) * -325.949D) & 2047;
                              if(class53.cameraPitch < 128) {
                                 class53.cameraPitch = 128;
                              }

                              if(class53.cameraPitch > 383) {
                                 class53.cameraPitch = 383;
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 203) {
                           var4 = field446.method2603();
                           var5 = field446.method2551();
                           var68 = World.method628(var4);
                           if(var68 != null && var68.type == 0) {
                              if(var5 > var68.scrollHeight - var68.height) {
                                 var5 = var68.scrollHeight - var68.height;
                              }

                              if(var5 < 0) {
                                 var5 = 0;
                              }

                              if(var5 != var68.scrollY) {
                                 var68.scrollY = var5;
                                 class75.method1606(var68);
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        if(packetOpcode == 131) {
                           var4 = field446.method2602();
                           var5 = field446.method2727();
                           var29 = field446.method2759();
                           var113 = World.method628(var5);
                           if(var29 != var113.field2819 || var113.field2820 != var4 || var113.field2909 != 0 || var113.field2920 != 0) {
                              var113.field2819 = var29;
                              var113.field2820 = var4;
                              var113.field2909 = 0;
                              var113.field2920 = 0;
                              class75.method1606(var113);
                              class16.method189(var113);
                              if(var113.type == 0) {
                                 class21.method554(Widget.widgets[var5 >> 16], var113, false);
                              }
                           }

                           packetOpcode = -1;
                           var65 = true;
                           break label3974;
                        }

                        class107.method2357("" + packetOpcode + "," + field396 + "," + field332 + "," + field326, (Throwable)null);
                        class144.method3029();
                     } catch (IOException var59) {
                        if(field440 > 0) {
                           class144.method3029();
                        } else {
                           class130.setGameState(40);
                           class62.field1259 = Item.field694;
                           Item.field694 = null;
                        }
                     } catch (Exception var60) {
                        var108 = "" + packetOpcode + "," + field396 + "," + field332 + "," + field326 + "," + (class48.localPlayer.pathX[0] + class28.baseX) + "," + (class159.baseY + class48.localPlayer.pathY[0]) + ",";

                        for(var5 = 0; var5 < field326 && var5 < 50; ++var5) {
                           var108 = var108 + field446.payload[var5] + ",";
                        }

                        class107.method2357(var108, var60);
                        class144.method3029();
                     }

                     var65 = true;
                  }
               }

               if(!var65) {
                  break;
               }
            }

            if(gameState == 30) {
               while(class165.method3226()) {
                  field323.method2818(49);
                  field323.method2715(0);
                  var1 = field323.offset;
                  class49.method1011(field323);
                  field323.method2553(field323.offset - var1);
               }

               Object var25 = class85.field1475.field190;
               synchronized(class85.field1475.field190) {
                  if(!field410) {
                     class85.field1475.field200 = 0;
                  } else if(class143.field2198 != 0 || class85.field1475.field200 >= 40) {
                     field323.method2818(207);
                     field323.method2715(0);
                     var2 = field323.offset;
                     var26 = 0;

                     for(var4 = 0; var4 < class85.field1475.field200 && field323.offset - var2 < 240; ++var4) {
                        ++var26;
                        var5 = class85.field1475.field194[var4];
                        if(var5 < 0) {
                           var5 = 0;
                        } else if(var5 > 502) {
                           var5 = 502;
                        }

                        var29 = class85.field1475.field193[var4];
                        if(var29 < 0) {
                           var29 = 0;
                        } else if(var29 > 764) {
                           var29 = 764;
                        }

                        var7 = var5 * 765 + var29;
                        if(class85.field1475.field194[var4] == -1 && class85.field1475.field193[var4] == -1) {
                           var29 = -1;
                           var5 = -1;
                           var7 = 524287;
                        }

                        if(field315 == var29 && field439 == var5) {
                           if(field294 < 2047) {
                              ++field294;
                           }
                        } else {
                           var8 = var29 - field315;
                           field315 = var29;
                           var32 = var5 - field439;
                           field439 = var5;
                           if(field294 < 8 && var8 >= -32 && var8 <= 31 && var32 >= -32 && var32 <= 31) {
                              var8 += 32;
                              var32 += 32;
                              field323.method2542((var8 << 6) + (field294 << 12) + var32);
                              field294 = 0;
                           } else if(field294 < 8) {
                              field323.method2742((field294 << 19) + 8388608 + var7);
                              field294 = 0;
                           } else {
                              field323.method2544(var7 + -1073741824 + (field294 << 19));
                              field294 = 0;
                           }
                        }
                     }

                     field323.method2553(field323.offset - var2);
                     if(var26 >= class85.field1475.field200) {
                        class85.field1475.field200 = 0;
                     } else {
                        class85.field1475.field200 -= var26;

                        for(var4 = 0; var4 < class85.field1475.field200; ++var4) {
                           class85.field1475.field193[var4] = class85.field1475.field193[var26 + var4];
                           class85.field1475.field194[var4] = class85.field1475.field194[var4 + var26];
                        }
                     }
                  }
               }

               if(class143.field2198 == 1 || !class134.field2117 && class143.field2198 == 4 || class143.field2198 == 2) {
                  long var67 = (class143.field2208 - field291) / 50L;
                  if(var67 > 4095L) {
                     var67 = 4095L;
                  }

                  field291 = class143.field2208;
                  var26 = class143.field2213;
                  if(var26 < 0) {
                     var26 = 0;
                  } else if(var26 > class212.field3175) {
                     var26 = class212.field3175;
                  }

                  var4 = class143.field2211;
                  if(var4 < 0) {
                     var4 = 0;
                  } else if(var4 > FaceNormal.field1499) {
                     var4 = FaceNormal.field1499;
                  }

                  var5 = (int)var67;
                  field323.method2818(101);
                  field323.method2542((class143.field2198 == 2?1:0) + (var5 << 1));
                  field323.method2542(var4);
                  field323.method2542(var26);
               }

               if(class140.field2174 > 0) {
                  field323.method2818(45);
                  field323.method2542(0);
                  var1 = field323.offset;
                  long var127 = class34.method713();

                  for(var4 = 0; var4 < class140.field2174; ++var4) {
                     var100 = var127 - field505;
                     if(var100 > 16777215L) {
                        var100 = 16777215L;
                     }

                     field505 = var127;
                     field323.method2715(class140.field2173[var4]);
                     field323.method2596((int)var100);
                  }

                  field323.method2552(field323.offset - var1);
               }

               if(field372 > 0) {
                  --field372;
               }

               if(class140.field2167[96] || class140.field2167[97] || class140.field2167[98] || class140.field2167[99]) {
                  field373 = true;
               }

               if(field373 && field372 <= 0) {
                  field372 = 20;
                  field373 = false;
                  field323.method2818(62);
                  field323.method2661(mapAngle);
                  field323.method2661(field365);
               }

               if(class184.field2991 && !field295) {
                  field295 = true;
                  field323.method2818(184);
                  field323.method2715(1);
               }

               if(!class184.field2991 && field295) {
                  field295 = false;
                  field323.method2818(184);
                  field323.method2715(0);
               }

               int[] var46;
               if(field435 != FrameMap.plane) {
                  field435 = FrameMap.plane;
                  var1 = FrameMap.plane;
                  var46 = class143.field2205.image;
                  var26 = var46.length;

                  for(var4 = 0; var4 < var26; ++var4) {
                     var46[var4] = 0;
                  }

                  var4 = 1;

                  while(true) {
                     if(var4 >= 103) {
                        var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                        var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                        class143.field2205.method1751();

                        for(var29 = 1; var29 < 103; ++var29) {
                           for(var7 = 1; var7 < 103; ++var7) {
                              if((class5.tileSettings[var1][var7][var29] & 24) == 0) {
                                 WidgetNode.method44(var1, var7, var29, var4, var5);
                              }

                              if(var1 < 3 && (class5.tileSettings[1 + var1][var7][var29] & 8) != 0) {
                                 WidgetNode.method44(var1 + 1, var7, var29, var4, var5);
                              }
                           }
                        }

                        field287 = 0;

                        for(var29 = 0; var29 < 104; ++var29) {
                           for(var7 = 0; var7 < 104; ++var7) {
                              var8 = Projectile.region.method2111(FrameMap.plane, var29, var7);
                              if(var8 != 0) {
                                 var8 = var8 >> 14 & 32767;
                                 var32 = class1.getObjectDefinition(var8).field951;
                                 if(var32 >= 0) {
                                    var10 = var29;
                                    var11 = var7;
                                    if(var32 != 22 && var32 != 29 && var32 != 34 && var32 != 36 && var32 != 46 && var32 != 47 && var32 != 48) {
                                       int[][] var138 = collisionMaps[FrameMap.plane].flags;

                                       for(var15 = 0; var15 < 10; ++var15) {
                                          var16 = (int)(Math.random() * 4.0D);
                                          if(var16 == 0 && var10 > 0 && var10 > var29 - 3 && (var138[var10 - 1][var11] & 19136776) == 0) {
                                             --var10;
                                          }

                                          if(var16 == 1 && var10 < 103 && var10 < var29 + 3 && (var138[var10 + 1][var11] & 19136896) == 0) {
                                             ++var10;
                                          }

                                          if(var16 == 2 && var11 > 0 && var11 > var7 - 3 && (var138[var10][var11 - 1] & 19136770) == 0) {
                                             --var11;
                                          }

                                          if(var16 == 3 && var11 < 103 && var11 < 3 + var7 && (var138[var10][1 + var11] & 19136800) == 0) {
                                             ++var11;
                                          }
                                       }
                                    }

                                    field512[field287] = class8.field140[var32];
                                    field451[field287] = var10;
                                    field511[field287] = var11;
                                    ++field287;
                                 }
                              }
                           }
                        }

                        class40.bufferProvider.method1711();
                        break;
                     }

                     var5 = 24628 + 2048 * (103 - var4);

                     for(var29 = 1; var29 < 103; ++var29) {
                        if((class5.tileSettings[var1][var29][var4] & 24) == 0) {
                           Projectile.region.method1982(var46, var5, 512, var1, var29, var4);
                        }

                        if(var1 < 3 && (class5.tileSettings[var1 + 1][var29][var4] & 8) != 0) {
                           Projectile.region.method1982(var46, var5, 512, 1 + var1, var29, var4);
                        }

                        var5 += 4;
                     }

                     ++var4;
                  }
               }

               if(gameState == 30) {
                  class75.method1604();

                  for(var1 = 0; var1 < field521; ++var1) {
                     --field286[var1];
                     if(field286[var1] >= -10) {
                        class61 var152 = field526[var1];
                        if(var152 == null) {
                           Object var154 = null;
                           var152 = class61.method1294(class51.field1111, field325[var1], 0);
                           if(var152 == null) {
                              continue;
                           }

                           field286[var1] += var152.method1296();
                           field526[var1] = var152;
                        }

                        if(field286[var1] < 0) {
                           if(field434[var1] != 0) {
                              var4 = 128 * (field434[var1] & 255);
                              var5 = field434[var1] >> 16 & 255;
                              var29 = 128 * var5 + 64 - class48.localPlayer.x;
                              if(var29 < 0) {
                                 var29 = -var29;
                              }

                              var7 = field434[var1] >> 8 & 255;
                              var8 = 128 * var7 + 64 - class48.localPlayer.y;
                              if(var8 < 0) {
                                 var8 = -var8;
                              }

                              var32 = var29 + var8 - 128;
                              if(var32 > var4) {
                                 field286[var1] = -100;
                                 continue;
                              }

                              if(var32 < 0) {
                                 var32 = 0;
                              }

                              var26 = (var4 - var32) * field520 / var4;
                           } else {
                              var26 = field519;
                           }

                           if(var26 > 0) {
                              class65 var122 = var152.method1293().method1322(class143.field2215);
                              class67 var143 = class67.method1342(var122, 100, var26);
                              var143.method1345(field523[var1] - 1);
                              class14.field205.method1179(var143);
                           }

                           field286[var1] = -100;
                        }
                     } else {
                        --field521;

                        for(var2 = var1; var2 < field521; ++var2) {
                           field325[var2] = field325[var2 + 1];
                           field526[var2] = field526[var2 + 1];
                           field523[var2] = field523[var2 + 1];
                           field286[var2] = field286[1 + var2];
                           field434[var2] = field434[var2 + 1];
                        }

                        --var1;
                     }
                  }

                  if(field518 && !class21.method555()) {
                     if(field516 != 0 && field517 != -1) {
                        Buffer.method2775(class192.field3108, field517, 0, field516, false);
                     }

                     field518 = false;
                  }

                  ++field328;
                  if(field328 > 750) {
                     if(field440 > 0) {
                        class144.method3029();
                     } else {
                        class130.setGameState(40);
                        class62.field1259 = Item.field694;
                        Item.field694 = null;
                     }
                  } else {
                     var1 = class34.field760;
                     var46 = class34.field755;

                     for(var26 = 0; var26 < var1; ++var26) {
                        Player var124 = cachedPlayers[var46[var26]];
                        if(null != var124) {
                           class0.method4(var124, 1);
                        }
                     }

                     class40.method772();
                     class126.method2842();
                     ++field329;
                     if(field465 != 0) {
                        field391 += 20;
                        if(field391 >= 400) {
                           field465 = 0;
                        }
                     }

                     if(class168.field2725 != null) {
                        ++field393;
                        if(field393 >= 15) {
                           class75.method1606(class168.field2725);
                           class168.field2725 = null;
                        }
                     }

                     Widget var102 = ItemComposition.field1180;
                     Widget var153 = BufferProvider.field1434;
                     ItemComposition.field1180 = null;
                     BufferProvider.field1434 = null;
                     field456 = null;
                     field460 = false;
                     field457 = false;
                     field528 = 0;

                     while(true) {
                        while(class10.method129() && field528 < 128) {
                           if(field312 >= 2 && class140.field2167[82] && class132.field2102 == 66) {
                              var108 = "";

                              MessageNode var90;
                              for(Iterator var146 = class11.field164.iterator(); var146.hasNext(); var108 = var108 + var90.name + ':' + var90.value + '\n') {
                                 var90 = (MessageNode)var146.next();
                              }

                              class56.field1216.setContents(new StringSelection(var108), (ClipboardOwner)null);
                           } else {
                              field504[field528] = class132.field2102;
                              field445[field528] = class113.field2009;
                              ++field528;
                           }
                        }

                        if(widgetRoot != -1) {
                           var26 = widgetRoot;
                           var4 = FaceNormal.field1499;
                           var5 = class212.field3175;
                           if(class175.method3419(var26)) {
                              class116.method2496(Widget.widgets[var26], -1, 0, 0, var4, var5, 0, 0);
                           }
                        }

                        ++field532;

                        while(true) {
                           class0 var64;
                           Widget var130;
                           do {
                              var64 = (class0)field479.method3848();
                              if(var64 == null) {
                                 while(true) {
                                    do {
                                       var64 = (class0)field480.method3848();
                                       if(var64 == null) {
                                          while(true) {
                                             do {
                                                var64 = (class0)field478.method3848();
                                                if(var64 == null) {
                                                   class4.method48();
                                                   if(null != field494) {
                                                      class79.method1708();
                                                   }

                                                   if(null != class180.field2965) {
                                                      class75.method1606(class180.field2965);
                                                      ++field400;
                                                      if(class143.field2203 != 0) {
                                                         if(field400 >= 5 && (class143.field2204 > field470 + 5 || class143.field2204 < field470 - 5 || class143.field2210 > field397 + 5 || class143.field2210 < field397 - 5)) {
                                                            field399 = true;
                                                         }
                                                      } else {
                                                         if(field399) {
                                                            if(class180.field2965 == class14.field208 && field395 != field398) {
                                                               Widget var66 = class180.field2965;
                                                               byte var133 = 0;
                                                               if(field292 == 1 && var66.contentType == 206) {
                                                                  var133 = 1;
                                                               }

                                                               if(var66.itemIds[field398] <= 0) {
                                                                  var133 = 0;
                                                               }

                                                               var29 = class132.method2880(var66);
                                                               var98 = (var29 >> 29 & 1) != 0;
                                                               if(var98) {
                                                                  var7 = field395;
                                                                  var8 = field398;
                                                                  var66.itemIds[var8] = var66.itemIds[var7];
                                                                  var66.itemQuantities[var8] = var66.itemQuantities[var7];
                                                                  var66.itemIds[var7] = -1;
                                                                  var66.itemQuantities[var7] = 0;
                                                               } else if(var133 == 1) {
                                                                  var7 = field395;
                                                                  var8 = field398;

                                                                  while(var8 != var7) {
                                                                     if(var7 > var8) {
                                                                        var66.method3421(var7 - 1, var7);
                                                                        --var7;
                                                                     } else if(var7 < var8) {
                                                                        var66.method3421(var7 + 1, var7);
                                                                        ++var7;
                                                                     }
                                                                  }
                                                               } else {
                                                                  var66.method3421(field398, field395);
                                                               }

                                                               field323.method2818(68);
                                                               field323.method2661(field395);
                                                               field323.method2589(field398);
                                                               field323.method2575(class180.field2965.id);
                                                               field323.method2582(var133);
                                                            }
                                                         } else if((field508 == 1 || class38.method738(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                            BufferProvider.method1725(field470, field397);
                                                         } else if(menuOptionCount > 0) {
                                                            var26 = field470;
                                                            var4 = field397;
                                                            class32 var149 = class59.field1242;
                                                            class143.menuAction(var149.field715, var149.field713, var149.field714, var149.field717, var149.field716, var149.field716, var26, var4);
                                                            class59.field1242 = null;
                                                         }

                                                         field393 = 10;
                                                         class143.field2198 = 0;
                                                         class180.field2965 = null;
                                                      }
                                                   }

                                                   if(Region.field1541 != -1) {
                                                      var26 = Region.field1541;
                                                      var4 = Region.field1542;
                                                      field323.method2818(44);
                                                      field323.method2715(5);
                                                      field323.method2661(var4 + class159.baseY);
                                                      field323.method2661(class28.baseX + var26);
                                                      field323.method2715(class140.field2167[82]?(class140.field2167[81]?2:1):0);
                                                      Region.field1541 = -1;
                                                      field334 = class143.field2211;
                                                      field390 = class143.field2213;
                                                      field465 = 1;
                                                      field391 = 0;
                                                      flagX = var26;
                                                      flagY = var4;
                                                   }

                                                   if(var102 != ItemComposition.field1180) {
                                                      if(var102 != null) {
                                                         class75.method1606(var102);
                                                      }

                                                      if(null != ItemComposition.field1180) {
                                                         class75.method1606(ItemComposition.field1180);
                                                      }
                                                   }

                                                   if(BufferProvider.field1434 != var153 && field430 == field431) {
                                                      if(null != var153) {
                                                         class75.method1606(var153);
                                                      }

                                                      if(null != BufferProvider.field1434) {
                                                         class75.method1606(BufferProvider.field1434);
                                                      }
                                                   }

                                                   if(BufferProvider.field1434 != null) {
                                                      if(field430 < field431) {
                                                         ++field430;
                                                         if(field431 == field430) {
                                                            class75.method1606(BufferProvider.field1434);
                                                         }
                                                      }
                                                   } else if(field430 > 0) {
                                                      --field430;
                                                   }

                                                   class16.method190();
                                                   if(field418) {
                                                      var26 = TextureProvider.field1667 * 128 + 64;
                                                      var4 = 64 + class20.field571 * 128;
                                                      var5 = KitDefinition.method936(var26, var4, FrameMap.plane) - XItemContainer.field222;
                                                      if(Ignore.cameraX < var26) {
                                                         Ignore.cameraX += (var26 - Ignore.cameraX) * class143.field2214 / 1000 + VertexNormal.field1685;
                                                         if(Ignore.cameraX > var26) {
                                                            Ignore.cameraX = var26;
                                                         }
                                                      }

                                                      if(Ignore.cameraX > var26) {
                                                         Ignore.cameraX -= VertexNormal.field1685 + (Ignore.cameraX - var26) * class143.field2214 / 1000;
                                                         if(Ignore.cameraX < var26) {
                                                            Ignore.cameraX = var26;
                                                         }
                                                      }

                                                      if(class119.cameraZ < var5) {
                                                         class119.cameraZ += class143.field2214 * (var5 - class119.cameraZ) / 1000 + VertexNormal.field1685;
                                                         if(class119.cameraZ > var5) {
                                                            class119.cameraZ = var5;
                                                         }
                                                      }

                                                      if(class119.cameraZ > var5) {
                                                         class119.cameraZ -= class143.field2214 * (class119.cameraZ - var5) / 1000 + VertexNormal.field1685;
                                                         if(class119.cameraZ < var5) {
                                                            class119.cameraZ = var5;
                                                         }
                                                      }

                                                      if(WallObject.cameraY < var4) {
                                                         WallObject.cameraY += VertexNormal.field1685 + (var4 - WallObject.cameraY) * class143.field2214 / 1000;
                                                         if(WallObject.cameraY > var4) {
                                                            WallObject.cameraY = var4;
                                                         }
                                                      }

                                                      if(WallObject.cameraY > var4) {
                                                         WallObject.cameraY -= VertexNormal.field1685 + (WallObject.cameraY - var4) * class143.field2214 / 1000;
                                                         if(WallObject.cameraY < var4) {
                                                            WallObject.cameraY = var4;
                                                         }
                                                      }

                                                      var26 = Frames.field1831 * 128 + 64;
                                                      var4 = field461 * 128 + 64;
                                                      var5 = KitDefinition.method936(var26, var4, FrameMap.plane) - class5.field86;
                                                      var29 = var26 - Ignore.cameraX;
                                                      var7 = var5 - class119.cameraZ;
                                                      var8 = var4 - WallObject.cameraY;
                                                      var32 = (int)Math.sqrt((double)(var8 * var8 + var29 * var29));
                                                      var10 = (int)(Math.atan2((double)var7, (double)var32) * 325.949D) & 2047;
                                                      var11 = (int)(Math.atan2((double)var29, (double)var8) * -325.949D) & 2047;
                                                      if(var10 < 128) {
                                                         var10 = 128;
                                                      }

                                                      if(var10 > 383) {
                                                         var10 = 383;
                                                      }

                                                      if(class53.cameraPitch < var10) {
                                                         class53.cameraPitch += class35.field777 + class8.field141 * (var10 - class53.cameraPitch) / 1000;
                                                         if(class53.cameraPitch > var10) {
                                                            class53.cameraPitch = var10;
                                                         }
                                                      }

                                                      if(class53.cameraPitch > var10) {
                                                         class53.cameraPitch -= (class53.cameraPitch - var10) * class8.field141 / 1000 + class35.field777;
                                                         if(class53.cameraPitch < var10) {
                                                            class53.cameraPitch = var10;
                                                         }
                                                      }

                                                      var12 = var11 - cameraYaw;
                                                      if(var12 > 1024) {
                                                         var12 -= 2048;
                                                      }

                                                      if(var12 < -1024) {
                                                         var12 += 2048;
                                                      }

                                                      if(var12 > 0) {
                                                         cameraYaw += class8.field141 * var12 / 1000 + class35.field777;
                                                         cameraYaw &= 2047;
                                                      }

                                                      if(var12 < 0) {
                                                         cameraYaw -= class35.field777 + -var12 * class8.field141 / 1000;
                                                         cameraYaw &= 2047;
                                                      }

                                                      var13 = var11 - cameraYaw;
                                                      if(var13 > 1024) {
                                                         var13 -= 2048;
                                                      }

                                                      if(var13 < -1024) {
                                                         var13 += 2048;
                                                      }

                                                      if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                         cameraYaw = var11;
                                                      }
                                                   }

                                                   for(var26 = 0; var26 < 5; ++var26) {
                                                      ++field533[var26];
                                                   }

                                                   class8.chatMessages.method209();
                                                   var26 = ++class143.mouseIdleTicks - 1;
                                                   var5 = GameObject.method2258();
                                                   if(var26 > 15000 && var5 > 15000) {
                                                      field440 = 250;
                                                      class130.method2876(14500);
                                                      field323.method2818(247);
                                                   }

                                                   ++field350;
                                                   if(field350 > 500) {
                                                      field350 = 0;
                                                      var29 = (int)(Math.random() * 8.0D);
                                                      if((var29 & 1) == 1) {
                                                         field344 += field345;
                                                      }

                                                      if((var29 & 2) == 2) {
                                                         field346 += field363;
                                                      }

                                                      if((var29 & 4) == 4) {
                                                         field490 += field349;
                                                      }
                                                   }

                                                   if(field344 < -50) {
                                                      field345 = 2;
                                                   }

                                                   if(field344 > 50) {
                                                      field345 = -2;
                                                   }

                                                   if(field346 < -55) {
                                                      field363 = 2;
                                                   }

                                                   if(field346 > 55) {
                                                      field363 = -2;
                                                   }

                                                   if(field490 < -40) {
                                                      field349 = 1;
                                                   }

                                                   if(field490 > 40) {
                                                      field349 = -1;
                                                   }

                                                   ++field352;
                                                   if(field352 > 500) {
                                                      field352 = 0;
                                                      var29 = (int)(Math.random() * 8.0D);
                                                      if((var29 & 1) == 1) {
                                                         mapScale += field424;
                                                      }

                                                      if((var29 & 2) == 2) {
                                                         mapScaleDelta += field354;
                                                      }
                                                   }

                                                   if(mapScale < -60) {
                                                      field424 = 2;
                                                   }

                                                   if(mapScale > 60) {
                                                      field424 = -2;
                                                   }

                                                   if(mapScaleDelta < -20) {
                                                      field354 = 1;
                                                   }

                                                   if(mapScaleDelta > 10) {
                                                      field354 = -1;
                                                   }

                                                   for(class40 var93 = (class40)field550.method3809(); var93 != null; var93 = (class40)field550.method3810()) {
                                                      if((long)var93.field879 < class34.method713() / 1000L - 5L) {
                                                         if(var93.field881 > 0) {
                                                            class23.sendGameMessage(5, "", var93.field877 + " has logged in.");
                                                         }

                                                         if(var93.field881 == 0) {
                                                            class23.sendGameMessage(5, "", var93.field877 + " has logged out.");
                                                         }

                                                         var93.method3941();
                                                      }
                                                   }

                                                   ++field313;
                                                   if(field313 > 50) {
                                                      field323.method2818(185);
                                                   }

                                                   try {
                                                      if(Item.field694 != null && field323.offset > 0) {
                                                         Item.field694.method3043(field323.payload, 0, field323.offset);
                                                         field323.offset = 0;
                                                         field313 = 0;
                                                         return;
                                                      }
                                                   } catch (IOException var51) {
                                                      if(field440 > 0) {
                                                         class144.method3029();
                                                      } else {
                                                         class130.setGameState(40);
                                                         class62.field1259 = Item.field694;
                                                         Item.field694 = null;
                                                      }

                                                      return;
                                                   }

                                                   return;
                                                }

                                                var130 = var64.field7;
                                                if(var130.index < 0) {
                                                   break;
                                                }

                                                var36 = World.method628(var130.parentId);
                                             } while(var36 == null || null == var36.children || var130.index >= var36.children.length || var130 != var36.children[var130.index]);

                                             class158.method3201(var64, 200000);
                                          }
                                       }

                                       var130 = var64.field7;
                                       if(var130.index < 0) {
                                          break;
                                       }

                                       var36 = World.method628(var130.parentId);
                                    } while(var36 == null || var36.children == null || var130.index >= var36.children.length || var130 != var36.children[var130.index]);

                                    class158.method3201(var64, 200000);
                                 }
                              }

                              var130 = var64.field7;
                              if(var130.index < 0) {
                                 break;
                              }

                              var36 = World.method628(var130.parentId);
                           } while(null == var36 || null == var36.children || var130.index >= var36.children.length || var36.children[var130.index] != var130);

                           class158.method3201(var64, 200000);
                        }
                     }
                  }
               }
            }
         }
      } else if(gameState == 40 || gameState == 45) {
         class126.method2844();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1038456919"
   )
   protected final void vmethod3133() {
      boolean var1;
      label226: {
         try {
            if(class186.field3009 == 2) {
               if(null == class186.field3017) {
                  class186.field3017 = class183.method3530(class186.field3010, class156.field2330, class128.field2091);
                  if(null == class186.field3017) {
                     var1 = false;
                     break label226;
                  }
               }

               if(null == class186.field3006) {
                  class186.field3006 = new class62(class186.field3014, class221.field3216);
               }

               if(class186.field3008.method3619(class186.field3017, class186.field3013, class186.field3006, 22050)) {
                  class186.field3008.method3650();
                  class186.field3008.method3617(class186.field3011);
                  class186.field3008.method3622(class186.field3017, class186.field3016);
                  class186.field3009 = 0;
                  class186.field3017 = null;
                  class186.field3006 = null;
                  class186.field3010 = null;
                  var1 = true;
                  break label226;
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
            class186.field3008.method3670();
            class186.field3009 = 0;
            class186.field3017 = null;
            class186.field3006 = null;
            class186.field3010 = null;
         }

         var1 = false;
      }

      if(var1 && field518 && null != FaceNormal.field1492) {
         FaceNormal.field1492.method1263();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(field492 != 0L && class34.method713() > field492) {
            class14.method167(class92.method2124());
         } else if(GameEngine.field2260) {
            RSCanvas.method2986();
         }
      }

      Dimension var3 = this.method3080();
      if(var3.width != class47.field1050 || class112.field1970 != var3.height || GameEngine.field2259) {
         class77.method1624();
         field492 = class34.method713() + 500L;
         GameEngine.field2259 = false;
      }

      boolean var4 = false;
      int var5;
      if(GameEngine.field2257) {
         GameEngine.field2257 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field484[var5] = true;
         }
      }

      if(var4) {
         WallObject.method2122();
      }

      if(gameState == 0) {
         var5 = class33.field737;
         String var6 = class33.field738;
         Color var7 = null;

         try {
            Graphics var8 = class129.canvas.getGraphics();
            if(null == class38.field815) {
               class38.field815 = new Font("Helvetica", 1, 13);
               class137.field2125 = class129.canvas.getFontMetrics(class38.field815);
            }

            if(var4) {
               var8.setColor(Color.black);
               var8.fillRect(0, 0, FaceNormal.field1499, class212.field3175);
            }

            if(null == var7) {
               var7 = new Color(140, 17, 17);
            }

            try {
               if(null == class53.field1138) {
                  class53.field1138 = class129.canvas.createImage(304, 34);
               }

               Graphics var9 = class53.field1138.getGraphics();
               var9.setColor(var7);
               var9.drawRect(0, 0, 303, 33);
               var9.fillRect(2, 2, var5 * 3, 30);
               var9.setColor(Color.black);
               var9.drawRect(1, 1, 301, 31);
               var9.fillRect(var5 * 3 + 2, 2, 300 - 3 * var5, 30);
               var9.setFont(class38.field815);
               var9.setColor(Color.white);
               var9.drawString(var6, (304 - class137.field2125.stringWidth(var6)) / 2, 22);
               var8.drawImage(class53.field1138, FaceNormal.field1499 / 2 - 152, class212.field3175 / 2 - 18, (ImageObserver)null);
            } catch (Exception var15) {
               int var10 = FaceNormal.field1499 / 2 - 152;
               int var11 = class212.field3175 / 2 - 18;
               var8.setColor(var7);
               var8.drawRect(var10, var11, 303, 33);
               var8.fillRect(var10 + 2, var11 + 2, var5 * 3, 30);
               var8.setColor(Color.black);
               var8.drawRect(var10 + 1, 1 + var11, 301, 31);
               var8.fillRect(var5 * 3 + 2 + var10, var11 + 2, 300 - 3 * var5, 30);
               var8.setFont(class38.field815);
               var8.setColor(Color.white);
               var8.drawString(var6, var10 + (304 - class137.field2125.stringWidth(var6)) / 2, var11 + 22);
            }
         } catch (Exception var16) {
            class129.canvas.repaint();
         }
      } else if(gameState == 5) {
         GameObject.method2256(VertexNormal.field1680, XItemContainer.field225, class158.field2347, var4);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            GameObject.method2256(VertexNormal.field1680, XItemContainer.field225, class158.field2347, var4);
         } else if(gameState == 25) {
            if(field405 == 1) {
               if(field335 > field336) {
                  field336 = field335;
               }

               var5 = (field336 * 50 - field335 * 50) / field336;
               KitDefinition.method941("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field405 == 2) {
               if(field337 > field535) {
                  field535 = field337;
               }

               var5 = 50 + (field535 * 50 - field337 * 50) / field535;
               KitDefinition.method941("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               KitDefinition.method941("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            class8.method113();
         } else if(gameState == 40) {
            KitDefinition.method941("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            KitDefinition.method941("Please wait...", false);
         }
      } else {
         GameObject.method2256(VertexNormal.field1680, XItemContainer.field225, class158.field2347, var4);
      }

      Graphics var13;
      int var14;
      if(gameState == 30 && field491 == 0 && !var4) {
         try {
            var13 = class129.canvas.getGraphics();

            for(var14 = 0; var14 < field547; ++var14) {
               if(field485[var14]) {
                  class40.bufferProvider.drawSub(var13, widgetPositionX[var14], widgetPositionY[var14], widgetBoundsWidth[var14], widgetBoundsHeight[var14]);
                  field485[var14] = false;
               }
            }
         } catch (Exception var18) {
            class129.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var13 = class129.canvas.getGraphics();
            class40.bufferProvider.draw(var13, 0, 0);

            for(var14 = 0; var14 < field547; ++var14) {
               field485[var14] = false;
            }
         } catch (Exception var17) {
            class129.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-224721789"
   )
   protected final void vmethod3077() {
      if(class8.chatMessages.method210()) {
         class8.chatMessages.method207();
      }

      if(class85.field1475 != null) {
         class85.field1475.field192 = false;
      }

      class85.field1475 = null;
      if(Item.field694 != null) {
         Item.field694.method3044();
         Item.field694 = null;
      }

      if(class140.keyboard != null) {
         class140 var1 = class140.keyboard;
         synchronized(class140.keyboard) {
            class140.keyboard = null;
         }
      }

      class16.method186();
      class5.field91 = null;
      if(null != FaceNormal.field1492) {
         FaceNormal.field1492.method1218();
      }

      if(class138.field2135 != null) {
         class138.field2135.method1218();
      }

      if(class174.field2774 != null) {
         class174.field2774.method3044();
      }

      Object var9 = class173.field2770;
      synchronized(class173.field2770) {
         if(class173.field2771 != 0) {
            class173.field2771 = 1;

            try {
               class173.field2770.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      try {
         class152.field2288.method4158();

         for(int var4 = 0; var4 < class152.field2281; ++var4) {
            class35.field790[var4].method4158();
         }

         class152.field2287.method4158();
         class152.field2286.method4158();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "840066724"
   )
   void method252() {
      if(gameState != 1000) {
         long var2 = class34.method713();
         int var4 = (int)(var2 - class174.field2776);
         class174.field2776 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class174.field2775 += var4;
         boolean var1;
         if(class174.field2793 == 0 && class174.field2785 == 0 && class174.field2786 == 0 && class174.field2794 == 0) {
            var1 = true;
         } else if(null == class174.field2774) {
            var1 = false;
         } else {
            try {
               label243: {
                  if(class174.field2775 > 30000) {
                     throw new IOException();
                  }

                  class175 var5;
                  Buffer var6;
                  while(class174.field2785 < 20 && class174.field2794 > 0) {
                     var5 = (class175)class174.field2777.method3821();
                     var6 = new Buffer(4);
                     var6.method2715(1);
                     var6.method2742((int)var5.hash);
                     class174.field2774.method3043(var6.payload, 0, 4);
                     class174.field2779.method3819(var5, var5.hash);
                     --class174.field2794;
                     ++class174.field2785;
                  }

                  while(class174.field2793 < 20 && class174.field2786 > 0) {
                     var5 = (class175)class174.field2783.method3908();
                     var6 = new Buffer(4);
                     var6.method2715(0);
                     var6.method2742((int)var5.hash);
                     class174.field2774.method3043(var6.payload, 0, 4);
                     var5.method3925();
                     class174.field2784.method3819(var5, var5.hash);
                     --class174.field2786;
                     ++class174.field2793;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class174.field2774.method3041();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class174.field2775 = 0;
                     byte var7 = 0;
                     if(null == class85.field1465) {
                        var7 = 8;
                     } else if(class174.field2787 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class174.field2789.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class174.field2774.method3042(class174.field2789.payload, class174.field2789.offset, var8);
                        if(class174.field2790 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class174.field2789.payload[var9 + class174.field2789.offset] ^= class174.field2790;
                           }
                        }

                        class174.field2789.offset += var8;
                        if(class174.field2789.offset < var7) {
                           break;
                        }

                        if(class85.field1465 == null) {
                           class174.field2789.offset = 0;
                           var9 = class174.field2789.method2556();
                           var10 = class174.field2789.method2551();
                           int var11 = class174.field2789.method2556();
                           var12 = class174.field2789.method2561();
                           long var13 = (long)((var9 << 16) + var10);
                           class175 var15 = (class175)class174.field2779.method3830(var13);
                           class114.field2011 = true;
                           if(null == var15) {
                              var15 = (class175)class174.field2784.method3830(var13);
                              class114.field2011 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class85.field1465 = var15;
                           XClanMember.field630 = new Buffer(class85.field1465.field2801 + var12 + var16);
                           XClanMember.field630.method2715(var11);
                           XClanMember.field630.method2544(var12);
                           class174.field2787 = 8;
                           class174.field2789.offset = 0;
                        } else if(class174.field2787 == 0) {
                           if(class174.field2789.payload[0] == -1) {
                              class174.field2787 = 1;
                              class174.field2789.offset = 0;
                           } else {
                              class85.field1465 = null;
                           }
                        }
                     } else {
                        var8 = XClanMember.field630.payload.length - class85.field1465.field2801;
                        var9 = 512 - class174.field2787;
                        if(var9 > var8 - XClanMember.field630.offset) {
                           var9 = var8 - XClanMember.field630.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class174.field2774.method3042(XClanMember.field630.payload, XClanMember.field630.offset, var9);
                        if(class174.field2790 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              XClanMember.field630.payload[XClanMember.field630.offset + var10] ^= class174.field2790;
                           }
                        }

                        XClanMember.field630.offset += var9;
                        class174.field2787 += var9;
                        if(XClanMember.field630.offset == var8) {
                           if(class85.field1465.hash == 16711935L) {
                              class28.field677 = XClanMember.field630;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class171 var19 = class174.field2781[var10];
                                 if(var19 != null) {
                                    class28.field677.offset = 5 + var10 * 8;
                                    var12 = class28.field677.method2561();
                                    int var23 = class28.field677.method2561();
                                    var19.method3366(var12, var23);
                                 }
                              }
                           } else {
                              class174.field2788.reset();
                              class174.field2788.update(XClanMember.field630.payload, 0, var8);
                              var10 = (int)class174.field2788.getValue();
                              if(class85.field1465.field2798 != var10) {
                                 try {
                                    class174.field2774.method3044();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class174.field2791;
                                 class174.field2774 = null;
                                 class174.field2790 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label243;
                              }

                              class174.field2791 = 0;
                              class174.field2792 = 0;
                              class85.field1465.field2797.method3367((int)(class85.field1465.hash & 65535L), XClanMember.field630.payload, 16711680L == (class85.field1465.hash & 16711680L), class114.field2011);
                           }

                           class85.field1465.unlink();
                           if(class114.field2011) {
                              --class174.field2785;
                           } else {
                              --class174.field2793;
                           }

                           class174.field2787 = 0;
                           class85.field1465 = null;
                           XClanMember.field630 = null;
                        } else {
                           if(class174.field2787 != 512) {
                              break;
                           }

                           class174.field2787 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class174.field2774.method3044();
               } catch (Exception var20) {
                  ;
               }

               ++class174.field2792;
               class174.field2774 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method253();
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "391977576"
   )
   void method253() {
      if(class174.field2791 >= 4) {
         this.method3078("js5crc");
         gameState = 1000;
      } else {
         if(class174.field2792 >= 4) {
            if(gameState <= 5) {
               this.method3078("js5io");
               gameState = 1000;
               return;
            }

            field402 = 3000;
            class174.field2792 = 3;
         }

         if(--field402 + 1 <= 0) {
            try {
               if(field309 == 0) {
                  Friend.field254 = class127.field2086.method2926(class59.host, field317);
                  ++field309;
               }

               if(field309 == 1) {
                  if(Friend.field254.field2266 == 2) {
                     this.method530(-1);
                     return;
                  }

                  if(Friend.field254.field2266 == 1) {
                     ++field309;
                  }
               }

               if(field309 == 2) {
                  class0.field0 = new class146((Socket)Friend.field254.field2270, class127.field2086);
                  Buffer var1 = new Buffer(5);
                  var1.method2715(15);
                  var1.method2544(121);
                  class0.field0.method3043(var1.payload, 0, 5);
                  ++field309;
                  class35.field780 = class34.method713();
               }

               if(field309 == 3) {
                  if(gameState > 5 && class0.field0.method3041() <= 0) {
                     if(class34.method713() - class35.field780 > 30000L) {
                        this.method530(-2);
                        return;
                     }
                  } else {
                     int var2 = class0.field0.method3040();
                     if(var2 != 0) {
                        this.method530(var2);
                        return;
                     }

                     ++field309;
                  }
               }

               if(field309 == 4) {
                  class159.method3203(class0.field0, gameState > 20);
                  Friend.field254 = null;
                  class0.field0 = null;
                  field309 = 0;
                  field452 = 0;
               }
            } catch (IOException var3) {
               this.method530(-3);
            }

         }
      }
   }

   static {
      field415 = class21.field577;
      field307 = class21.field577;
      field308 = 0;
      field309 = 0;
      field402 = 0;
      field452 = 0;
      field522 = 0;
      field468 = 0;
      field401 = 0;
      field316 = 0;
      cachedNPCs = new NPC['耀'];
      field319 = 0;
      field320 = new int['耀'];
      field321 = 0;
      field466 = new int[250];
      field323 = new class125(5000);
      field324 = new class125(5000);
      field446 = new class125(15000);
      field326 = 0;
      packetOpcode = 0;
      field328 = 0;
      field313 = 0;
      field330 = 0;
      field396 = 0;
      field332 = 0;
      field440 = 0;
      field348 = false;
      field335 = 0;
      field336 = 1;
      field337 = 0;
      field535 = 1;
      field405 = 0;
      collisionMaps = new CollisionData[4];
      field341 = false;
      field389 = new int[4][13][13];
      field343 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field344 = 0;
      field345 = 2;
      field346 = 0;
      field363 = 2;
      field490 = 0;
      field349 = 1;
      field350 = 0;
      mapScale = 0;
      field424 = 2;
      mapScaleDelta = 0;
      field354 = 1;
      field352 = 0;
      field329 = 0;
      field359 = 2301979;
      field360 = 5063219;
      field361 = 3353893;
      field555 = 7759444;
      field429 = false;
      field364 = 0;
      field365 = 128;
      mapAngle = 0;
      field367 = 0;
      field368 = 0;
      field369 = 0;
      field306 = 0;
      field371 = 50;
      field372 = 0;
      field373 = false;
      field374 = 0;
      field375 = 0;
      field362 = 50;
      field475 = new int[field362];
      field378 = new int[field362];
      field379 = new int[field362];
      field356 = new int[field362];
      field559 = new int[field362];
      field382 = new int[field362];
      field383 = new int[field362];
      field384 = new String[field362];
      field385 = new int[104][104];
      field386 = 0;
      field387 = -1;
      field388 = -1;
      field334 = 0;
      field390 = 0;
      field391 = 0;
      field465 = 0;
      field393 = 0;
      field394 = 0;
      field395 = 0;
      field470 = 0;
      field397 = 0;
      field398 = 0;
      field399 = false;
      field400 = 0;
      field304 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field563 = 0;
      field524 = 0;
      field380 = new int[1000];
      field407 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field408 = new String[8];
      field409 = new boolean[8];
      field381 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field411 = -1;
      groundItemDeque = new Deque[4][104][104];
      field413 = new Deque();
      projectiles = new Deque();
      field357 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field508 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field428 = -1;
      field510 = -1;
      field430 = 0;
      field431 = 50;
      field432 = 0;
      field433 = null;
      field404 = false;
      field482 = -1;
      field436 = -1;
      field437 = null;
      field438 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field441 = 0;
      field292 = 0;
      field443 = null;
      energy = 0;
      weight = 0;
      field312 = 0;
      field447 = -1;
      field448 = false;
      field449 = false;
      field293 = false;
      field463 = null;
      field494 = null;
      field453 = null;
      field454 = 0;
      field455 = 0;
      field456 = null;
      field457 = false;
      field310 = -1;
      field459 = -1;
      field460 = false;
      field298 = -1;
      field462 = -1;
      field548 = false;
      field532 = 1;
      field339 = new int[32];
      field543 = 0;
      field467 = new int[32];
      field557 = 0;
      field342 = new int[32];
      field458 = 0;
      field471 = 0;
      field472 = 0;
      field534 = 0;
      field474 = 0;
      field496 = 0;
      field476 = 0;
      field477 = 0;
      field478 = new Deque();
      field479 = new Deque();
      field480 = new Deque();
      widgetFlags = new XHashTable(512);
      field547 = 0;
      field483 = -2;
      field484 = new boolean[100];
      field485 = new boolean[100];
      field486 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field491 = 0;
      field492 = 0L;
      isResized = true;
      field333 = 765;
      field495 = 1;
      field554 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field442 = 0;
      field322 = 0;
      field499 = "";
      field500 = new long[100];
      field501 = 0;
      field528 = 0;
      field445 = new int[128];
      field504 = new int[128];
      field505 = -1L;
      field541 = null;
      field507 = null;
      field435 = -1;
      field287 = 0;
      field451 = new int[1000];
      field511 = new int[1000];
      field512 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field515 = 0;
      field516 = 255;
      field517 = -1;
      field518 = false;
      field519 = 127;
      field520 = 127;
      field521 = 0;
      field325 = new int[50];
      field523 = new int[50];
      field286 = new int[50];
      field434 = new int[50];
      field526 = new class61[50];
      field418 = false;
      field529 = new boolean[5];
      field530 = new int[5];
      field562 = new int[5];
      field503 = new int[5];
      field533 = new int[5];
      field498 = 256;
      field331 = 205;
      field392 = 256;
      field537 = 320;
      field538 = 1;
      field539 = 32767;
      field540 = 1;
      field284 = 32767;
      field542 = 0;
      field347 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field502 = 0;
      friends = new Friend[400];
      field550 = new class198();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field553 = new PlayerComposition();
      field545 = -1;
      field497 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field469 = -1L;
      field376 = -1L;
      field280 = new class10();
      field506 = new int[50];
      field561 = new int[50];
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZS)V",
      garbageValue = "-20775"
   )
   static void method353(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var6.parentId == var1) {
            ChatMessages.method240(var6, var2, var3, var4);
            class93.method2128(var6, var2, var3);
            if(var6.itemId > var6.scrollWidth - var6.width) {
               var6.itemId = var6.scrollWidth - var6.width;
            }

            if(var6.itemId < 0) {
               var6.itemId = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class21.method554(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "103"
   )
   static int method366(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3830((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1659072882"
   )
   protected final void vmethod3140() {
      NPCComposition.field920 = field560 == 0?'ꩊ':world + '鱀';
      class14.field207 = field560 == 0?443:'썐' + world;
      field317 = NPCComposition.field920;
      PlayerComposition.field2975 = class177.field2946;
      XClanMember.field624 = class177.field2947;
      class165.field2712 = class177.field2948;
      class12.field185 = class177.field2950;
      class177.method3472();
      Canvas var1 = class129.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class140.keyboard);
      var1.addFocusListener(class140.keyboard);
      class16.method188(class129.canvas);

      class148 var2;
      try {
         var2 = new class148();
      } catch (Throwable var10) {
         var2 = null;
      }

      class5.field91 = var2;
      if(null != class5.field91) {
         class5.field91.vmethod3166(class129.canvas);
      }

      FaceNormal.field1501 = new class137(255, class152.field2288, class152.field2287, 500000);
      FileOnDisk var4 = null;
      class8 var5 = new class8();

      try {
         var4 = DecorativeObject.method2222("", class35.field775.field2339, false);
         byte[] var6 = new byte[(int)var4.method4137()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.method4154(var6, var7, var6.length - var7);
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
            var4.method4136();
         }
      } catch (Exception var9) {
         ;
      }

      class161.field2659 = var5;
      class56.field1216 = this.getToolkit().getSystemClipboard();
      Sequence.method899(this, class145.field2230);
      if(field560 != 0) {
         field296 = true;
      }

      class14.method167(class161.field2659.field133);
   }

   public final void init() {
      if(this.method3064()) {
         class193[] var1 = class212.method3953();

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            class193 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3110);
            if(null != var4) {
               class156[] var7;
               int var8;
               switch(Integer.parseInt(var3.field3110)) {
               case 1:
                  ChatMessages.field278 = var4;
                  continue;
               case 2:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  continue;
               case 3:
                  field281 = Integer.parseInt(var4);
               case 4:
               case 5:
               case 13:
               default:
                  continue;
               case 6:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  continue;
               case 7:
                  class48.field1067 = Integer.parseInt(var4);
                  continue;
               case 8:
                  field560 = Integer.parseInt(var4);
                  continue;
               case 9:
                  class110.field1938 = Integer.parseInt(var4);
                  continue;
               case 10:
                  class40.field878 = var4;
                  continue;
               case 11:
                  flags = Integer.parseInt(var4);
                  continue;
               case 12:
                  class157[] var39 = new class157[]{class157.field2338, class157.field2336, class157.field2341, class157.field2342, class157.field2337, class157.field2335};
                  class35.field775 = (class157)class5.method98(var39, Integer.parseInt(var4));
                  if(class157.field2338 == class35.field775) {
                     class127.field2087 = class215.field3195;
                  } else {
                     class127.field2087 = class215.field3198;
                  }
                  continue;
               case 14:
                  world = Integer.parseInt(var4);
                  continue;
               case 15:
                  var6 = Integer.parseInt(var4);
                  var7 = class175.method3420();
                  var8 = 0;
               }

               class156 var5;
               while(true) {
                  if(var8 >= var7.length) {
                     var5 = null;
                     break;
                  }

                  class156 var9 = var7[var8];
                  if(var6 == var9.field2326) {
                     var5 = var9;
                     break;
                  }

                  ++var8;
               }

               class35.field772 = var5;
            }
         }

         class9.method121();
         class59.host = this.getCodeBase().getHost();
         String var35 = class35.field772.field2323;
         byte var36 = 0;

         try {
            class152.field2281 = 16;
            Frames.field1826 = var36;

            try {
               class1.field23 = System.getProperty("os.name");
            } catch (Exception var30) {
               class1.field23 = "Unknown";
            }

            Frames.field1833 = class1.field23.toLowerCase();

            try {
               class24.field620 = System.getProperty("user.home");
               if(null != class24.field620) {
                  class24.field620 = class24.field620 + "/";
               }
            } catch (Exception var29) {
               ;
            }

            try {
               if(Frames.field1833.startsWith("win")) {
                  if(class24.field620 == null) {
                     class24.field620 = System.getenv("USERPROFILE");
                  }
               } else if(null == class24.field620) {
                  class24.field620 = System.getenv("HOME");
               }

               if(null != class24.field620) {
                  class24.field620 = class24.field620 + "/";
               }
            } catch (Exception var28) {
               ;
            }

            if(null == class24.field620) {
               class24.field620 = "~/";
            }

            class152.field2289 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class24.field620, "/tmp/", ""};
            class152.field2283 = new String[]{".jagex_cache_" + Frames.field1826, ".file_store_" + Frames.field1826};
            int var17 = 0;

            File var38;
            label293:
            while(var17 < 4) {
               String var40 = var17 == 0?"":"" + var17;
               class9.field155 = new File(class24.field620, "jagex_cl_oldschool_" + var35 + var40 + ".dat");
               String var18 = null;
               String var43 = null;
               boolean var44 = false;
               Buffer var10;
               File var48;
               if(class9.field155.exists()) {
                  try {
                     FileOnDisk var46 = new FileOnDisk(class9.field155, "rw", 10000L);

                     int var11;
                     for(var10 = new Buffer((int)var46.method4137()); var10.offset < var10.payload.length; var10.offset += var11) {
                        var11 = var46.method4154(var10.payload, var10.offset, var10.payload.length - var10.offset);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var10.offset = 0;
                     var11 = var10.method2556();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var10.method2556();
                     }

                     if(var11 <= 2) {
                        var18 = var10.method2635();
                        if(var12 == 1) {
                           var43 = var10.method2635();
                        }
                     } else {
                        var18 = var10.method2555();
                        if(var12 == 1) {
                           var43 = var10.method2555();
                        }
                     }

                     var46.method4136();
                  } catch (IOException var33) {
                     var33.printStackTrace();
                  }

                  if(null != var18) {
                     var48 = new File(var18);
                     if(!var48.exists()) {
                        var18 = null;
                     }
                  }

                  if(var18 != null) {
                     var48 = new File(var18, "test.dat");
                     if(!class114.method2483(var48, true)) {
                        var18 = null;
                     }
                  }
               }

               if(null == var18 && var17 == 0) {
                  label268:
                  for(int var19 = 0; var19 < class152.field2283.length; ++var19) {
                     for(int var20 = 0; var20 < class152.field2289.length; ++var20) {
                        File var21 = new File(class152.field2289[var20] + class152.field2283[var19] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var21.exists() && class114.method2483(new File(var21, "test.dat"), true)) {
                           var18 = var21.toString();
                           var44 = true;
                           break label268;
                        }
                     }
                  }
               }

               if(var18 == null) {
                  var18 = class24.field620 + File.separatorChar + "jagexcache" + var40 + File.separatorChar + "oldschool" + File.separatorChar + var35 + File.separatorChar;
                  var44 = true;
               }

               File var47;
               if(var43 != null) {
                  var47 = new File(var43);
                  var48 = new File(var18);

                  try {
                     File[] var49 = var47.listFiles();
                     File[] var22 = var49;

                     for(int var13 = 0; var13 < var22.length; ++var13) {
                        File var14 = var22[var13];
                        File var15 = new File(var48, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var32) {
                     var32.printStackTrace();
                  }

                  var44 = true;
               }

               if(var44) {
                  var47 = new File(var18);
                  var10 = null;

                  try {
                     FileOnDisk var50 = new FileOnDisk(class9.field155, "rw", 10000L);
                     Buffer var51 = new Buffer(500);
                     var51.method2715(3);
                     Object var10001 = null;
                     var51.method2715(0);
                     var51.method2738(var47.getPath());
                     Object var10000 = null;
                     var50.method4135(var51.payload, 0, var51.offset);
                     var50.method4136();
                  } catch (IOException var27) {
                     var27.printStackTrace();
                  }
               }

               var38 = new File(var18);
               class192.field3107 = var38;
               if(!class192.field3107.exists()) {
                  class192.field3107.mkdirs();
               }

               File[] var41 = class192.field3107.listFiles();
               if(var41 != null) {
                  File[] var52 = var41;

                  for(int var23 = 0; var23 < var52.length; ++var23) {
                     File var24 = var52[var23];
                     if(!class114.method2483(var24, false)) {
                        ++var17;
                        continue label293;
                     }
                  }
               }
               break;
            }

            File var37 = class192.field3107;
            class138.field2129 = var37;
            if(!class138.field2129.exists()) {
               throw new RuntimeException("");
            }

            class138.field2131 = true;

            try {
               var38 = new File(class24.field620, "random.dat");
               if(var38.exists()) {
                  class152.field2286 = new class231(new FileOnDisk(var38, "rw", 25L), 24, 0);
               } else {
                  label217:
                  for(int var25 = 0; var25 < class152.field2283.length; ++var25) {
                     for(var6 = 0; var6 < class152.field2289.length; ++var6) {
                        File var45 = new File(class152.field2289[var6] + class152.field2283[var25] + File.separatorChar + "random.dat");
                        if(var45.exists()) {
                           class152.field2286 = new class231(new FileOnDisk(var45, "rw", 25L), 24, 0);
                           break label217;
                        }
                     }
                  }
               }

               if(class152.field2286 == null) {
                  RandomAccessFile var42 = new RandomAccessFile(var38, "rw");
                  var6 = var42.read();
                  var42.seek(0L);
                  var42.write(var6);
                  var42.seek(0L);
                  var42.close();
                  class152.field2286 = new class231(new FileOnDisk(var38, "rw", 25L), 24, 0);
               }
            } catch (IOException var31) {
               ;
            }

            class152.field2288 = new class231(new FileOnDisk(VertexNormal.method2252("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class152.field2287 = new class231(new FileOnDisk(VertexNormal.method2252("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class35.field790 = new class231[class152.field2281];

            for(int var26 = 0; var26 < class152.field2281; ++var26) {
               class35.field790[var26] = new class231(new FileOnDisk(VertexNormal.method2252("main_file_cache.idx" + var26), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var34) {
            class107.method2357((String)null, var34);
         }

         field377 = this;
         this.method3062(765, 503, 121);
      }
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "495879039"
   )
   static final void method508(Widget var0, int var1, int var2) {
      if(var0.field2813 == 1) {
         XItemContainer.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2813 == 2 && !field404) {
         var3 = Item.method656(var0);
         if(null != var3) {
            XItemContainer.addMenuEntry(var3, class154.method3185('\uff00') + var0.field2926, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2813 == 3) {
         XItemContainer.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2813 == 4) {
         XItemContainer.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2813 == 5) {
         XItemContainer.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2813 == 6 && field443 == null) {
         XItemContainer.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      int var16;
      if(var0.type == 2) {
         var16 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (32 + var0.field2918) * var5;
               int var7 = (32 + var0.field2877) * var4;
               if(var16 < 20) {
                  var6 += var0.field2878[var16];
                  var7 += var0.field2879[var16];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < var7 + 32) {
                  field398 = var16;
                  class14.field208 = var0;
                  if(var0.itemIds[var16] > 0) {
                     label360: {
                        ItemComposition var8 = MessageNode.getItemDefinition(var0.itemIds[var16] - 1);
                        int var10;
                        boolean var18;
                        if(field432 == 1) {
                           var10 = class132.method2880(var0);
                           var18 = (var10 >> 30 & 1) != 0;
                           if(var18) {
                              if(class119.field2040 != var0.id || var16 != class75.field1391) {
                                 XItemContainer.addMenuEntry("Use", field433 + " " + "->" + " " + class154.method3185(16748608) + var8.name, 31, var8.id, var16, var0.id);
                              }
                              break label360;
                           }
                        }

                        if(field404) {
                           var10 = class132.method2880(var0);
                           var18 = (var10 >> 30 & 1) != 0;
                           if(var18) {
                              if((class171.field2749 & 16) == 16) {
                                 XItemContainer.addMenuEntry(field437, field438 + " " + "->" + " " + class154.method3185(16748608) + var8.name, 32, var8.id, var16, var0.id);
                              }
                              break label360;
                           }
                        }

                        String[] var9 = var8.inventoryActions;
                        if(field293) {
                           var9 = class75.method1607(var9);
                        }

                        int var11 = class132.method2880(var0);
                        boolean var21 = (var11 >> 30 & 1) != 0;
                        if(var21) {
                           for(int var12 = 4; var12 >= 3; --var12) {
                              if(null != var9 && var9[var12] != null) {
                                 byte var13;
                                 if(var12 == 3) {
                                    var13 = 36;
                                 } else {
                                    var13 = 37;
                                 }

                                 XItemContainer.addMenuEntry(var9[var12], class154.method3185(16748608) + var8.name, var13, var8.id, var16, var0.id);
                              } else if(var12 == 4) {
                                 XItemContainer.addMenuEntry("Drop", class154.method3185(16748608) + var8.name, 37, var8.id, var16, var0.id);
                              }
                           }
                        }

                        Object var10000 = null;
                        if(class162.method3210(class132.method2880(var0))) {
                           XItemContainer.addMenuEntry("Use", class154.method3185(16748608) + var8.name, 38, var8.id, var16, var0.id);
                        }

                        int var23 = class132.method2880(var0);
                        boolean var22 = (var23 >> 30 & 1) != 0;
                        int var14;
                        byte var15;
                        if(var22 && null != var9) {
                           for(var14 = 2; var14 >= 0; --var14) {
                              if(null != var9[var14]) {
                                 var15 = 0;
                                 if(var14 == 0) {
                                    var15 = 33;
                                 }

                                 if(var14 == 1) {
                                    var15 = 34;
                                 }

                                 if(var14 == 2) {
                                    var15 = 35;
                                 }

                                 XItemContainer.addMenuEntry(var9[var14], class154.method3185(16748608) + var8.name, var15, var8.id, var16, var0.id);
                              }
                           }
                        }

                        var9 = var0.field2881;
                        if(field293) {
                           var9 = class75.method1607(var9);
                        }

                        if(null != var9) {
                           for(var14 = 4; var14 >= 0; --var14) {
                              if(var9[var14] != null) {
                                 var15 = 0;
                                 if(var14 == 0) {
                                    var15 = 39;
                                 }

                                 if(var14 == 1) {
                                    var15 = 40;
                                 }

                                 if(var14 == 2) {
                                    var15 = 41;
                                 }

                                 if(var14 == 3) {
                                    var15 = 42;
                                 }

                                 if(var14 == 4) {
                                    var15 = 43;
                                 }

                                 XItemContainer.addMenuEntry(var9[var14], class154.method3185(16748608) + var8.name, var15, var8.id, var16, var0.id);
                              }
                           }
                        }

                        XItemContainer.addMenuEntry("Examine", class154.method3185(16748608) + var8.name, 1005, var8.id, var16, var0.id);
                     }
                  }
               }

               ++var16;
            }
         }
      }

      if(var0.field2809) {
         if(field404) {
            if(class45.method920(class132.method2880(var0)) && (class171.field2749 & 32) == 32) {
               XItemContainer.addMenuEntry(field437, field438 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var16 = 9; var16 >= 5; --var16) {
               String var19 = class16.method187(var0, var16);
               if(var19 != null) {
                  XItemContainer.addMenuEntry(var19, var0.name, 1007, var16 + 1, var0.index, var0.id);
               }
            }

            var3 = Item.method656(var0);
            if(var3 != null) {
               XItemContainer.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var17 = class16.method187(var0, var4);
               if(null != var17) {
                  XItemContainer.addMenuEntry(var17, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            var5 = class132.method2880(var0);
            boolean var20 = (var5 & 1) != 0;
            if(var20) {
               XItemContainer.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void method530(int var1) {
      Friend.field254 = null;
      class0.field0 = null;
      field309 = 0;
      if(NPCComposition.field920 == field317) {
         field317 = class14.field207;
      } else {
         field317 = NPCComposition.field920;
      }

      ++field452;
      if(field452 < 2 || var1 != 7 && var1 != 9) {
         if(field452 >= 2 && var1 == 6) {
            this.method3078("js5connect_outofdate");
            gameState = 1000;
         } else if(field452 >= 4) {
            if(gameState <= 5) {
               this.method3078("js5connect");
               gameState = 1000;
            } else {
               field402 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method3078("js5connect_full");
         gameState = 1000;
      } else {
         field402 = 3000;
      }

   }
}
