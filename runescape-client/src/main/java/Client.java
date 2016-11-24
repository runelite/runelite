import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
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
   @ObfuscatedName("b")
   static boolean field280 = true;
   @ObfuscatedName("d")
   static Client field281;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 559474415
   )
   static int field282;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -262484747
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 75749795
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("c")
   static class178 field285;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -1623712907
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("aw")
   static boolean field287 = true;
   @ObfuscatedName("l")
   static boolean field288 = false;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -713593553
   )
   static int field289 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 592619673
   )
   static int field290;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1081564661
   )
   static int field291;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -638628455
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("fb")
   static int[] field293;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1972086809
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 7578398314250847121L
   )
   static long field295 = -1L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1007660173
   )
   static int field296 = -1;
   @ObfuscatedName("ii")
   static String field297;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -2045335471
   )
   static int field298 = -1;
   @ObfuscatedName("nc")
   static int[] field299;
   @ObfuscatedName("pi")
   static int[] field300;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -2014409129
   )
   static int field301 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 433368135
   )
   static int field302 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1552534715
   )
   static int field303 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1831681193
   )
   static int field304 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -103912179
   )
   static int field305 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1446453443
   )
   static int field306 = 0;
   @ObfuscatedName("gj")
   static String[] field307;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1595854915
   )
   static int field308 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1927501689
   )
   static int field309 = 0;
   @ObfuscatedName("ax")
   static class40 field310;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 823136145
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 616933137
   )
   static int field312;
   @ObfuscatedName("an")
   static class110 field313;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 64738889
   )
   static int field314;
   @ObfuscatedName("hr")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("m")
   static boolean field316 = true;
   @ObfuscatedName("by")
   static class184 field317;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = 1581340579
   )
   static int field318;
   @ObfuscatedName("be")
   static class184 field319;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 121932799
   )
   static int field320;
   @ObfuscatedName("lb")
   static int[] field321;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1347057093
   )
   static int field322;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1128973539
   )
   static int field323;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1524995537
   )
   static int field324;
   @ObfuscatedName("eh")
   static boolean field325;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1097111221
   )
   static int field326;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1290259283
   )
   static int field327;
   @ObfuscatedName("mn")
   static String field328;
   @ObfuscatedName("cc")
   static int[] field329;
   @ObfuscatedName("cu")
   static class166 field330;
   @ObfuscatedName("ce")
   static class166 field331;
   @ObfuscatedName("br")
   static class184 field332;
   @ObfuscatedName("jy")
   static boolean field333;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -35787607
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -315106025
   )
   static int field335;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1514815335
   )
   static int field336;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1884239145
   )
   static int field337;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -911641849
   )
   static int field338;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1458161653
   )
   static int field339;
   @ObfuscatedName("ja")
   static Widget field340;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -399765681
   )
   static int field341;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 1895899603
   )
   static int field342;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1806844819
   )
   static int field343;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -20301153
   )
   static int field344;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 616813061
   )
   static int field345;
   @ObfuscatedName("jh")
   static boolean field346;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 1467403607
   )
   static int field347;
   @ObfuscatedName("du")
   static boolean field348;
   @ObfuscatedName("dz")
   static int[][][] field349;
   @ObfuscatedName("dg")
   static final int[] field350;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 1074734245
   )
   static int field351;
   @ObfuscatedName("mi")
   static int[] field352;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -1161809519
   )
   static int field353;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 1099425033
   )
   static int field354;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -873824887
   )
   static int field355;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 448644595
   )
   static int field356;
   @ObfuscatedName("in")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -1549174541
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1080637571
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -1570367577
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1393809997
   )
   static int field361;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -539107223
   )
   static int field362;
   @ObfuscatedName("jl")
   static Widget field363;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -751824491
   )
   static int field364;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 1359250203
   )
   static int field365;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1268822601
   )
   static int field366;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -42968883
   )
   static int field367;
   @ObfuscatedName("lo")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 664822545
   )
   static int field369;
   @ObfuscatedName("cz")
   static class166 field370;
   @ObfuscatedName("it")
   static String field371;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -1980096251
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 1961972121
   )
   static int field373;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 760876761
   )
   static int field374;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 1718873085
   )
   static int field375;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 37953553
   )
   static int field376;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 593224259
   )
   static int field377;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -1392385113
   )
   static int field378;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 95773035
   )
   static int field379;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 1686463379
   )
   static int field380;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1153213937
   )
   static int field381;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1843003925
   )
   static int field382;
   @ObfuscatedName("je")
   static Widget field383;
   @ObfuscatedName("ft")
   static int[] field384;
   @ObfuscatedName("fh")
   static int[] field385;
   @ObfuscatedName("fn")
   static int[] field386;
   @ObfuscatedName("fv")
   static int[] field387;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -725871675
   )
   static int field388;
   @ObfuscatedName("fp")
   static int[] field389;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1640010805
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("gn")
   static int[][] field391;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2018076381
   )
   static int field392 = -1;
   @ObfuscatedName("mu")
   static int[] field393;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 256315375
   )
   static int field394;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -2012352027
   )
   static int field395;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 1652338639
   )
   static int field396;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1405246675
   )
   static int field397;
   @ObfuscatedName("iq")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 2112281141
   )
   static int field399;
   @ObfuscatedName("kl")
   static int[] field400;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1828790357
   )
   static int field401;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1974017277
   )
   static int field402;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 2043506287
   )
   static int field403;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1233978659
   )
   static int field404;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -1463206331
   )
   static int field405;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1100580463
   )
   static int field406;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1134217955
   )
   static int field407;
   @ObfuscatedName("gp")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -196634711
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 2125006473
   )
   static int field410;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 631686757
   )
   static int field411;
   @ObfuscatedName("hz")
   static int[] field412;
   @ObfuscatedName("bv")
   static class184 field413;
   @ObfuscatedName("hs")
   static String[] field414;
   @ObfuscatedName("oj")
   static PlayerComposition field415;
   @ObfuscatedName("hy")
   static int[] field416;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1666295105
   )
   static int field417;
   @ObfuscatedName("hk")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("hj")
   static Deque field419;
   @ObfuscatedName("oh")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("hw")
   static Deque field421;
   @ObfuscatedName("hn")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("hc")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -1752686349
   )
   static int field424;
   @ObfuscatedName("co")
   static boolean field425;
   @ObfuscatedName("hi")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1298992193
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("mh")
   static int[] field428;
   @ObfuscatedName("nx")
   static boolean[] field429;
   @ObfuscatedName("ib")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("nq")
   static int[] field431;
   @ObfuscatedName("ik")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("gu")
   static boolean field433;
   @ObfuscatedName("hd")
   static boolean[] field434;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 157781185
   )
   static int field435;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 877686585
   )
   static int field436;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 1244030569
   )
   static int field437;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 2082856159
   )
   static int field438;
   @ObfuscatedName("q")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("id")
   static boolean field440;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 301859297
   )
   static int field441;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -1078188881
   )
   static int field442;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1877305731
   )
   static int field443 = 0;
   @ObfuscatedName("ir")
   static String field444;
   @ObfuscatedName("ig")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 103590977
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -41681153
   )
   static int field448;
   @ObfuscatedName("jw")
   static Widget field449;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 2022750445
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 24924853
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 376627885
   )
   static int field452;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1667958447
   )
   static int field453 = 0;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 1173698947
   )
   static int field454;
   @ObfuscatedName("jj")
   static boolean field455;
   @ObfuscatedName("oa")
   static short field456;
   @ObfuscatedName("jf")
   static Widget field457;
   @ObfuscatedName("ol")
   static short field458;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -818784237
   )
   static int field459;
   @ObfuscatedName("cd")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 1188296779
   )
   static int field461;
   @ObfuscatedName("jm")
   static boolean field462;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 81328761
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = -1716002965
   )
   static int field464;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -772573085
   )
   static int field465;
   @ObfuscatedName("jx")
   static boolean field466;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 1538546695
   )
   static int field467;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = 1912162943
   )
   static int field468;
   @ObfuscatedName("js")
   static boolean field469;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -2016985183
   )
   static int field470;
   @ObfuscatedName("ob")
   static int[] field471;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -1489328555
   )
   static int field472;
   @ObfuscatedName("kp")
   static int[] field473;
   @ObfuscatedName("lf")
   static int[] field474;
   @ObfuscatedName("kt")
   static int[] field475;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 404402239
   )
   static int field476;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 893007911
   )
   static int field477;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 68158581
   )
   static int field478;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 2013241719
   )
   static int field479;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -584062927
   )
   static int field480;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -959627181
   )
   static int field481;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1258409033
   )
   static int field482;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 122746115
   )
   static int field483;
   @ObfuscatedName("ku")
   static Deque field484;
   @ObfuscatedName("kz")
   static Deque field485;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -933930627
   )
   static int field486;
   @ObfuscatedName("ad")
   static class40 field487;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 996998237
   )
   static int field488;
   @ObfuscatedName("hh")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("ks")
   static boolean[] field490;
   @ObfuscatedName("ll")
   static boolean[] field491;
   @ObfuscatedName("lx")
   static boolean[] field492;
   @ObfuscatedName("ld")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("lc")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 1673746829
   )
   static int field495;
   @ObfuscatedName("li")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 1839387197
   )
   static int field497;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      longValue = -9081094241712232583L
   )
   static long field498;
   @ObfuscatedName("lw")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -383364591
   )
   static int field500;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -699884145
   )
   static int field501;
   @ObfuscatedName("kw")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 1692857941
   )
   static int field503;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 507741153
   )
   static int field504;
   @ObfuscatedName("lr")
   static String field505;
   @ObfuscatedName("lg")
   static long[] field506;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -48788979
   )
   static int field507;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 1732969859
   )
   static int field508;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -1496655323
   )
   static int field509;
   @ObfuscatedName("hb")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      longValue = -6328410336570207629L
   )
   static long field511;
   @ObfuscatedName("mm")
   static String field512;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      longValue = -7233677891329059725L
   )
   static long field513;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 235395715
   )
   static int field514;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 707991407
   )
   static int field515;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 829453709
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = 580676107
   )
   static int field517;
   @ObfuscatedName("mr")
   static SpritePixels[] field518;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 1005452763
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 81757803
   )
   static int field520;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 1088390385
   )
   static int field521;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 1398946009
   )
   static int field522;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = -1891460613
   )
   static int field523;
   @ObfuscatedName("mt")
   static boolean field524;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -2104402277
   )
   static int field525;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 893735477
   )
   static int field526;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -1310337735
   )
   static int field527;
   @ObfuscatedName("nl")
   static int[] field528;
   @ObfuscatedName("ng")
   static int[] field529;
   @ObfuscatedName("fd")
   static int[] field530;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 430128635
   )
   static int field531;
   @ObfuscatedName("nb")
   static class53[] field532;
   @ObfuscatedName("nr")
   static boolean field533;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 1672520281
   )
   static int field534;
   @ObfuscatedName("oc")
   static int[] field535;
   @ObfuscatedName("op")
   static int[] field536;
   @ObfuscatedName("ok")
   static int[] field537;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 1530726071
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("on")
   static short field539;
   @ObfuscatedName("or")
   static short field540;
   @ObfuscatedName("oy")
   static short field541;
   @ObfuscatedName("hq")
   static final int[] field542;
   @ObfuscatedName("oq")
   static short field543;
   @ObfuscatedName("hg")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("ot")
   static short field545;
   @ObfuscatedName("of")
   static short field546;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 1015107197
   )
   static int field547;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 639993991
   )
   static int field548;
   @ObfuscatedName("pn")
   static int[] field549;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = 892314267
   )
   static int field550;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1552633791
   )
   static int field552;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 2055150761
   )
   static int field553;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 256971789
   )
   static int field554;
   @ObfuscatedName("os")
   static class130 field555;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = -1932678163
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("oi")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = -538137723
   )
   static int field558;
   @ObfuscatedName("cw")
   static int[] field559;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -1631891777
   )
   static int field560;
   @ObfuscatedName("pm")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      longValue = 5850395171988094841L
   )
   static long field562;
   @ObfuscatedName("ay")
   static boolean field563 = false;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1599546579
   )
   static int field564;
   @ObfuscatedName("fe")
   static boolean field565;
   @ObfuscatedName("ps")
   static final class22 field566;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -2136100077
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("la")
   static class216 field568;
   @ObfuscatedName("kj")
   static Deque field569;

   public final void init() {
      if(this.method2150()) {
         class214[] var1 = new class214[]{class214.field3141, class214.field3150, class214.field3137, class214.field3140, class214.field3138, class214.field3148, class214.field3149, class214.field3147, class214.field3144, class214.field3151, class214.field3146, class214.field3142, class214.field3143, class214.field3139, class214.field3145};
         class214[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class214 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3152);
            if(null != var5) {
               switch(Integer.parseInt(var4.field3152)) {
               case 1:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
               case 2:
               case 3:
               case 10:
               default:
                  break;
               case 4:
                  int var7 = Integer.parseInt(var5);
                  class178[] var8 = new class178[]{class178.field2683, class178.field2687, class178.field2686, class178.field2681};
                  class178[] var9 = var8;
                  int var10 = 0;

                  class178 var16;
                  while(true) {
                     if(var10 >= var9.length) {
                        var16 = null;
                        break;
                     }

                     class178 var11 = var9[var10];
                     if(var11.field2682 == var7) {
                        var16 = var11;
                        break;
                     }

                     ++var10;
                  }

                  field285 = var16;
                  break;
               case 5:
                  field443 = Integer.parseInt(var5);
                  break;
               case 6:
                  class179[] var6 = new class179[]{class179.field2697, class179.field2691, class179.field2690, class179.field2695, class179.field2693, class179.field2692};
                  NPC.field758 = (class179)class101.method1985(var6, Integer.parseInt(var5));
                  if(NPC.field758 == class179.field2697) {
                     class108.field1740 = class228.field3234;
                  } else {
                     class108.field1740 = class228.field3241;
                  }
                  break;
               case 7:
                  field289 = Integer.parseInt(var5);
                  break;
               case 8:
                  class97.field1629 = var5;
                  break;
               case 9:
                  field291 = Integer.parseInt(var5);
                  break;
               case 11:
                  field290 = Integer.parseInt(var5);
                  break;
               case 12:
                  flags = Integer.parseInt(var5);
                  break;
               case 13:
                  class10.field91 = var5;
                  break;
               case 14:
                  world = Integer.parseInt(var5);
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

         Region.field1480 = false;
         field288 = false;
         class18.host = this.getCodeBase().getHost();
         String var15 = field285.field2680;
         byte var12 = 0;

         try {
            class166.method3255("oldschool", var15, var12, 16);
         } catch (Exception var14) {
            class39.method772((String)null, var14);
         }

         field281 = this;
         this.method2209(765, 503, 127);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2510"
   )
   protected final void vmethod2159() {
      class20.field219 = field443 == 0?'ꩊ':world + '鱀';
      class36.field770 = field443 == 0?443:'썐' + world;
      class5.field55 = class20.field219;
      PlayerComposition.field2041 = class148.field2053;
      class116.field1823 = class148.field2052;
      MessageNode.field235 = class148.field2051;
      class137.field1908 = class148.field2049;
      if(class103.field1672.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1721[186] = 57;
         class105.field1721[187] = 27;
         class105.field1721[188] = 71;
         class105.field1721[189] = 26;
         class105.field1721[190] = 72;
         class105.field1721[191] = 73;
         class105.field1721[192] = 58;
         class105.field1721[219] = 42;
         class105.field1721[220] = 74;
         class105.field1721[221] = 43;
         class105.field1721[222] = 59;
         class105.field1721[223] = 28;
      } else {
         class105.field1721[44] = 71;
         class105.field1721[45] = 26;
         class105.field1721[46] = 72;
         class105.field1721[47] = 73;
         class105.field1721[59] = 57;
         class105.field1721[61] = 27;
         class105.field1721[91] = 42;
         class105.field1721[92] = 74;
         class105.field1721[93] = 43;
         class105.field1721[192] = 28;
         class105.field1721[222] = 58;
         class105.field1721[520] = 59;
      }

      class57.method1090(class107.canvas);
      Canvas var1 = class107.canvas;
      var1.addMouseListener(class115.mouse);
      var1.addMouseMotionListener(class115.mouse);
      var1.addFocusListener(class115.mouse);

      class106 var2;
      try {
         var2 = new class106();
      } catch (Throwable var10) {
         var2 = null;
      }

      class183.field2732 = var2;
      if(class183.field2732 != null) {
         class183.field2732.vmethod2134(class107.canvas);
      }

      class44.field895 = new class116(255, class104.field1680, class104.field1687, 500000);
      FileOnDisk var4 = null;
      class30 var5 = new class30();

      try {
         var4 = class118.method2341("", NPC.field758.field2696, false);
         byte[] var6 = new byte[(int)var4.method1439()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.method1444(var6, var7, var6.length - var7);
            if(var8 == -1) {
               throw new IOException();
            }
         }

         var5 = new class30(new Buffer(var6));
      } catch (Exception var11) {
         ;
      }

      try {
         if(null != var4) {
            var4.method1442();
         }
      } catch (Exception var9) {
         ;
      }

      Tile.field1343 = var5;
      DecorativeObject.field1600 = this.getToolkit().getSystemClipboard();
      String var12 = MessageNode.field234;
      class114.field1793 = this;
      class114.field1794 = var12;
      if(field443 != 0) {
         field563 = true;
      }

      class15.method194(Tile.field1343.field692);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-129346549"
   )
   protected final void vmethod2161() {
      if(class3.chatMessages.method877()) {
         class3.chatMessages.method851();
      }

      if(null != class107.field1729) {
         class107.field1729.field215 = false;
      }

      class107.field1729 = null;
      if(FileOnDisk.field1183 != null) {
         FileOnDisk.field1183.method2121();
         FileOnDisk.field1183 = null;
      }

      class34.method727();
      GameObject.method1952();
      class183.field2732 = null;
      if(null != class11.field114) {
         class11.field114.method1058();
      }

      if(null != class15.field156) {
         class15.field156.method1058();
      }

      if(null != class185.field2761) {
         class185.field2761.method2121();
      }

      World.method638();
      class36.method753();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-971020055"
   )
   void method273() {
      if(class185.field2757 >= 4) {
         this.method2208("js5crc");
         gameState = 1000;
      } else {
         if(class185.field2763 >= 4) {
            if(gameState <= 5) {
               this.method2208("js5io");
               gameState = 1000;
               return;
            }

            field282 = 3000;
            class185.field2763 = 3;
         }

         if(--field282 + 1 <= 0) {
            try {
               if(field314 == 0) {
                  class217.field3161 = class15.field159.method1994(class18.host, class5.field55);
                  ++field314;
               }

               if(field314 == 1) {
                  if(class217.field3161.field1661 == 2) {
                     this.method274(-1);
                     return;
                  }

                  if(class217.field3161.field1661 == 1) {
                     ++field314;
                  }
               }

               if(field314 == 2) {
                  field313 = new class110((Socket)class217.field3161.field1663, class15.field159);
                  Buffer var1 = new Buffer(5);
                  var1.method2975(15);
                  var1.method2978(127);
                  field313.method2107(var1.payload, 0, 5);
                  ++field314;
                  class138.field1922 = class202.method3838();
               }

               if(field314 == 3) {
                  if(gameState > 5 && field313.method2105() <= 0) {
                     if(class202.method3838() - class138.field1922 > 30000L) {
                        this.method274(-2);
                        return;
                     }
                  } else {
                     int var5 = field313.method2104();
                     if(var5 != 0) {
                        this.method274(var5);
                        return;
                     }

                     ++field314;
                  }
               }

               if(field314 == 4) {
                  class110 var10 = field313;
                  boolean var2 = gameState > 20;
                  if(class185.field2761 != null) {
                     try {
                        class185.field2761.method2121();
                     } catch (Exception var8) {
                        ;
                     }

                     class185.field2761 = null;
                  }

                  class185.field2761 = var10;
                  class7.method102(var2);
                  class185.field2758.offset = 0;
                  class162.field2308 = null;
                  PlayerComposition.field2046 = null;
                  class185.field2751 = 0;

                  while(true) {
                     class181 var3 = (class181)class185.field2750.method2414();
                     if(null == var3) {
                        while(true) {
                           var3 = (class181)class185.field2755.method2414();
                           if(var3 == null) {
                              if(class185.field2762 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.method2975(4);
                                    var11.method2975(class185.field2762);
                                    var11.method2976(0);
                                    class185.field2761.method2107(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class185.field2761.method2121();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class185.field2763;
                                    class185.field2761 = null;
                                 }
                              }

                              class185.field2746 = 0;
                              class185.field2747 = class202.method3838();
                              class217.field3161 = null;
                              field313 = null;
                              field314 = 0;
                              field320 = 0;
                              return;
                           }

                           class185.field2752.method2370(var3);
                           class185.field2753.method2406(var3, var3.hash);
                           ++class185.field2754;
                           --class185.field2756;
                        }
                     }

                     class185.field2748.method2406(var3, var3.hash);
                     ++class185.field2749;
                     --class185.field2745;
                  }
               }
            } catch (IOException var9) {
               this.method274(-3);
            }

         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1991592035"
   )
   void method274(int var1) {
      class217.field3161 = null;
      field313 = null;
      field314 = 0;
      if(class5.field55 == class20.field219) {
         class5.field55 = class36.field770;
      } else {
         class5.field55 = class20.field219;
      }

      ++field320;
      if(field320 < 2 || var1 != 7 && var1 != 9) {
         if(field320 >= 2 && var1 == 6) {
            this.method2208("js5connect_outofdate");
            gameState = 1000;
         } else if(field320 >= 4) {
            if(gameState <= 5) {
               this.method2208("js5connect");
               gameState = 1000;
            } else {
               field282 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method2208("js5connect_full");
         gameState = 1000;
      } else {
         field282 = 3000;
      }

   }

   static {
      field310 = class40.field806;
      field487 = class40.field806;
      field312 = 0;
      field314 = 0;
      field282 = 0;
      field320 = 0;
      field452 = 0;
      field322 = 0;
      field323 = 0;
      field324 = 0;
      cachedNPCs = new NPC['耀'];
      field326 = 0;
      field559 = new int['耀'];
      field337 = 0;
      field329 = new int[250];
      field330 = new class166(5000);
      field331 = new class166(5000);
      field370 = new class166(15000);
      field564 = 0;
      packetOpcode = 0;
      field335 = 0;
      field336 = 0;
      field482 = 0;
      field338 = 0;
      field339 = 0;
      field405 = 0;
      field425 = false;
      field342 = 0;
      field343 = 1;
      field344 = 0;
      field345 = 1;
      field367 = 0;
      collisionMaps = new CollisionData[4];
      field348 = false;
      field349 = new int[4][13][13];
      field350 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field351 = 0;
      field509 = 2;
      field353 = 0;
      field354 = 2;
      field355 = 0;
      field356 = 1;
      field495 = 0;
      mapScale = 0;
      field454 = 2;
      mapScaleDelta = 0;
      field361 = 1;
      field362 = 0;
      field517 = 0;
      field341 = 2301979;
      field365 = 5063219;
      field531 = 3353893;
      field327 = 7759444;
      field325 = false;
      field369 = 0;
      field534 = 128;
      mapAngle = 0;
      field486 = 0;
      field374 = 0;
      field375 = 0;
      field376 = 0;
      field377 = 50;
      field378 = 0;
      field565 = false;
      field380 = 0;
      field381 = 0;
      field382 = 50;
      field530 = new int[field382];
      field384 = new int[field382];
      field385 = new int[field382];
      field386 = new int[field382];
      field387 = new int[field382];
      field293 = new int[field382];
      field389 = new int[field382];
      field307 = new String[field382];
      field391 = new int[104][104];
      field548 = 0;
      field347 = -1;
      field394 = -1;
      field395 = 0;
      field396 = 0;
      field397 = 0;
      field501 = 0;
      field399 = 0;
      field552 = 0;
      field401 = 0;
      field402 = 0;
      field403 = 0;
      field404 = 0;
      field433 = false;
      field406 = 0;
      field366 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field410 = 0;
      field411 = 0;
      field412 = new int[1000];
      field542 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field414 = new String[8];
      field434 = new boolean[8];
      field416 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field525 = -1;
      groundItemDeque = new Deque[4][104][104];
      field419 = new Deque();
      projectiles = new Deque();
      field421 = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field437 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field407 = -1;
      field435 = -1;
      field436 = 0;
      field424 = 50;
      field438 = 0;
      field371 = null;
      field440 = false;
      field441 = -1;
      field442 = -1;
      field297 = null;
      field444 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field373 = 0;
      field448 = 0;
      field449 = null;
      energy = 0;
      weight = 0;
      field503 = 0;
      field459 = -1;
      field333 = false;
      field455 = false;
      field346 = false;
      field457 = null;
      field383 = null;
      field340 = null;
      field507 = 0;
      field461 = 0;
      field363 = null;
      field462 = false;
      field464 = -1;
      field465 = -1;
      field466 = false;
      field467 = -1;
      field417 = -1;
      field469 = false;
      field470 = 1;
      field400 = new int[32];
      field472 = 0;
      field473 = new int[32];
      field468 = 0;
      field475 = new int[32];
      field476 = 0;
      field477 = 0;
      field388 = 0;
      field479 = 0;
      field480 = 0;
      field481 = 0;
      field379 = 0;
      field483 = 0;
      field484 = new Deque();
      field485 = new Deque();
      field569 = new Deque();
      widgetFlags = new XHashTable(512);
      field488 = 0;
      field554 = -2;
      field490 = new boolean[100];
      field491 = new boolean[100];
      field492 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field497 = 0;
      field498 = 0L;
      isResized = true;
      field500 = 765;
      field520 = 1;
      field321 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field364 = 0;
      field504 = 0;
      field505 = "";
      field506 = new long[100];
      field550 = 0;
      field508 = 0;
      field474 = new int[128];
      field352 = new int[128];
      field511 = -1L;
      field512 = null;
      field328 = null;
      field514 = -1;
      field515 = 0;
      field393 = new int[1000];
      field428 = new int[1000];
      field518 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field521 = 0;
      field522 = 255;
      field318 = -1;
      field524 = false;
      field478 = 127;
      field526 = 127;
      field527 = 0;
      field528 = new int[50];
      field529 = new int[50];
      field431 = new int[50];
      field299 = new int[50];
      field532 = new class53[50];
      field533 = false;
      field429 = new boolean[5];
      field535 = new int[5];
      field536 = new int[5];
      field537 = new int[5];
      field471 = new int[5];
      field539 = 256;
      field456 = 205;
      field541 = 256;
      field458 = 320;
      field543 = 1;
      field540 = 32767;
      field545 = 1;
      field546 = 32767;
      field547 = 0;
      field523 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field553 = 0;
      friends = new Friend[400];
      field555 = new class130();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field415 = new PlayerComposition();
      field558 = -1;
      field560 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field562 = -1L;
      field513 = -1L;
      field566 = new class22();
      field549 = new int[50];
      field300 = new int[50];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1648613444"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method389();
      FileOnDisk.method1443();

      int var1;
      try {
         if(class138.field1917 == 1) {
            var1 = class138.field1919.method2551();
            if(var1 > 0 && class138.field1919.method2557()) {
               var1 -= class114.field1792;
               if(var1 < 0) {
                  var1 = 0;
               }

               class138.field1919.method2550(var1);
            } else {
               class138.field1919.method2556();
               class138.field1919.method2587();
               if(class1.field12 != null) {
                  class138.field1917 = 2;
               } else {
                  class138.field1917 = 0;
               }

               Buffer.field2288 = null;
               NPC.field760 = null;
            }
         }
      } catch (Exception var28) {
         var28.printStackTrace();
         class138.field1919.method2556();
         class138.field1917 = 0;
         Buffer.field2288 = null;
         NPC.field760 = null;
         class1.field12 = null;
      }

      class13.method185();
      class15.method192();
      class34.method729();
      if(null != class183.field2732) {
         var1 = class183.field2732.vmethod2133();
         field483 = var1;
      }

      if(gameState == 0) {
         class85.method1737();
         method604();
      } else if(gameState == 5) {
         class57.method1093(this);
         class85.method1737();
         method604();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class57.method1093(this);
            class110.method2102();
         } else if(gameState == 25) {
            class20.method211();
         }
      } else {
         class57.method1093(this);
      }

      if(gameState == 30) {
         if(field301 > 1) {
            --field301;
         }

         if(field405 > 0) {
            --field405;
         }

         if(field425) {
            field425 = false;
            if(field405 > 0) {
               GameEngine.method2223();
            } else {
               class186.setGameState(40);
               WidgetNode.field176 = FileOnDisk.field1183;
               FileOnDisk.field1183 = null;
            }
         } else {
            if(!isMenuOpen) {
               menuOptions[0] = "Cancel";
               menuTargets[0] = "";
               menuTypes[0] = 1006;
               menuOptionCount = 1;
            }

            for(var1 = 0; var1 < 100 && Actor.method630(); ++var1) {
               ;
            }

            if(gameState == 30) {
               while(class200.method3793()) {
                  field330.method3234(134);
                  field330.method2975(0);
                  var1 = field330.offset;
                  class213.method4023(field330);
                  field330.method2990(field330.offset - var1);
               }

               Object var16 = class107.field1729.field222;
               int var2;
               int var3;
               int var4;
               int var5;
               int var6;
               int var7;
               int var8;
               int var9;
               synchronized(class107.field1729.field222) {
                  if(!field316) {
                     class107.field1729.field214 = 0;
                  } else if(class115.field1808 != 0 || class107.field1729.field214 >= 40) {
                     field330.method3234(186);
                     field330.method2975(0);
                     var2 = field330.offset;
                     var3 = 0;

                     for(var4 = 0; var4 < class107.field1729.field214 && field330.offset - var2 < 240; ++var4) {
                        ++var3;
                        var5 = class107.field1729.field217[var4];
                        if(var5 < 0) {
                           var5 = 0;
                        } else if(var5 > 502) {
                           var5 = 502;
                        }

                        var6 = class107.field1729.field216[var4];
                        if(var6 < 0) {
                           var6 = 0;
                        } else if(var6 > 764) {
                           var6 = 764;
                        }

                        var7 = var5 * 765 + var6;
                        if(class107.field1729.field217[var4] == -1 && class107.field1729.field216[var4] == -1) {
                           var6 = -1;
                           var5 = -1;
                           var7 = 524287;
                        }

                        if(field296 == var6 && var5 == field392) {
                           if(field298 < 2047) {
                              ++field298;
                           }
                        } else {
                           var8 = var6 - field296;
                           field296 = var6;
                           var9 = var5 - field392;
                           field392 = var5;
                           if(field298 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                              var8 += 32;
                              var9 += 32;
                              field330.method2976(var9 + (field298 << 12) + (var8 << 6));
                              field298 = 0;
                           } else if(field298 < 8) {
                              field330.method2977(var7 + 8388608 + (field298 << 19));
                              field298 = 0;
                           } else {
                              field330.method2978(-1073741824 + (field298 << 19) + var7);
                              field298 = 0;
                           }
                        }
                     }

                     field330.method2990(field330.offset - var2);
                     if(var3 >= class107.field1729.field214) {
                        class107.field1729.field214 = 0;
                     } else {
                        class107.field1729.field214 -= var3;

                        for(var4 = 0; var4 < class107.field1729.field214; ++var4) {
                           class107.field1729.field216[var4] = class107.field1729.field216[var4 + var3];
                           class107.field1729.field217[var4] = class107.field1729.field217[var4 + var3];
                        }
                     }
                  }
               }

               if(class115.field1808 == 1 || !MessageNode.field229 && class115.field1808 == 4 || class115.field1808 == 2) {
                  long var31 = (class115.field1796 - field295) / 50L;
                  if(var31 > 4095L) {
                     var31 = 4095L;
                  }

                  field295 = class115.field1796;
                  var3 = class115.field1806;
                  if(var3 < 0) {
                     var3 = 0;
                  } else if(var3 > class65.field1103) {
                     var3 = class65.field1103;
                  }

                  var4 = class115.field1809;
                  if(var4 < 0) {
                     var4 = 0;
                  } else if(var4 > class16.field169) {
                     var4 = class16.field169;
                  }

                  var5 = (int)var31;
                  field330.method3234(55);
                  field330.method2976((class115.field1808 == 2?1:0) + (var5 << 1));
                  field330.method2976(var4);
                  field330.method2976(var3);
               }

               if(class105.field1716 > 0) {
                  field330.method3234(166);
                  field330.method2976(0);
                  var1 = field330.offset;
                  long var29 = class202.method3838();

                  for(var4 = 0; var4 < class105.field1716; ++var4) {
                     long var33 = var29 - field511;
                     if(var33 > 16777215L) {
                        var33 = 16777215L;
                     }

                     field511 = var29;
                     field330.method2986(class105.field1715[var4]);
                     field330.method3030((int)var33);
                  }

                  field330.method3127(field330.offset - var1);
               }

               if(field378 > 0) {
                  --field378;
               }

               if(class105.field1709[96] || class105.field1709[97] || class105.field1709[98] || class105.field1709[99]) {
                  field565 = true;
               }

               if(field565 && field378 <= 0) {
                  field378 = 20;
                  field565 = false;
                  field330.method3234(255);
                  field330.method2976(field534);
                  field330.method3023(mapAngle);
               }

               if(class63.field1083 && !field287) {
                  field287 = true;
                  field330.method3234(49);
                  field330.method2975(1);
               }

               if(!class63.field1083 && field287) {
                  field287 = false;
                  field330.method3234(49);
                  field330.method2975(0);
               }

               if(field514 != class166.plane) {
                  field514 = class166.plane;
                  class30.method685(class166.plane);
               }

               if(gameState == 30) {
                  for(class25 var39 = (class25)field419.method2466(); var39 != null; var39 = (class25)field419.method2461()) {
                     if(var39.field582 > 0) {
                        --var39.field582;
                     }

                     ObjectComposition var17;
                     boolean var30;
                     if(var39.field582 == 0) {
                        if(var39.field575 >= 0) {
                           var3 = var39.field575;
                           var4 = var39.field584;
                           var17 = class15.getObjectDefinition(var3);
                           if(var4 == 11) {
                              var4 = 10;
                           }

                           if(var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           var30 = var17.method3653(var4);
                           if(!var30) {
                              continue;
                           }
                        }

                        class172.method3302(var39.field573, var39.field577, var39.field578, var39.field574, var39.field575, var39.field572, var39.field584);
                        var39.unlink();
                     } else {
                        if(var39.field581 > 0) {
                           --var39.field581;
                        }

                        if(var39.field581 == 0 && var39.field578 >= 1 && var39.field574 >= 1 && var39.field578 <= 102 && var39.field574 <= 102) {
                           if(var39.field579 >= 0) {
                              var3 = var39.field579;
                              var4 = var39.field580;
                              var17 = class15.getObjectDefinition(var3);
                              if(var4 == 11) {
                                 var4 = 10;
                              }

                              if(var4 >= 5 && var4 <= 8) {
                                 var4 = 4;
                              }

                              var30 = var17.method3653(var4);
                              if(!var30) {
                                 continue;
                              }
                           }

                           class172.method3302(var39.field573, var39.field577, var39.field578, var39.field574, var39.field579, var39.field583, var39.field580);
                           var39.field581 = -1;
                           if(var39.field579 == var39.field575 && var39.field575 == -1) {
                              var39.unlink();
                           } else if(var39.field575 == var39.field579 && var39.field583 == var39.field572 && var39.field580 == var39.field584) {
                              var39.unlink();
                           }
                        }
                     }
                  }

                  for(var1 = 0; var1 < field527; ++var1) {
                     --field431[var1];
                     if(field431[var1] >= -10) {
                        class53 var18 = field532[var1];
                        if(var18 == null) {
                           Object var10000 = null;
                           var18 = class53.method975(PlayerComposition.field2036, field528[var1], 0);
                           if(null == var18) {
                              continue;
                           }

                           field431[var1] += var18.method970();
                           field532[var1] = var18;
                        }

                        if(field431[var1] < 0) {
                           if(field299[var1] != 0) {
                              var4 = 128 * (field299[var1] & 255);
                              var5 = field299[var1] >> 16 & 255;
                              var6 = 64 + 128 * var5 - class40.localPlayer.x;
                              if(var6 < 0) {
                                 var6 = -var6;
                              }

                              var7 = field299[var1] >> 8 & 255;
                              var8 = 64 + 128 * var7 - class40.localPlayer.y;
                              if(var8 < 0) {
                                 var8 = -var8;
                              }

                              var9 = var8 + var6 - 128;
                              if(var9 > var4) {
                                 field431[var1] = -100;
                                 continue;
                              }

                              if(var9 < 0) {
                                 var9 = 0;
                              }

                              var3 = (var4 - var9) * field526 / var4;
                           } else {
                              var3 = field478;
                           }

                           if(var3 > 0) {
                              class55 var19 = var18.method969().method1019(class3.field35);
                              class66 var41 = class66.method1174(var19, 100, var3);
                              var41.method1192(field529[var1] - 1);
                              class143.field2007.method914(var41);
                           }

                           field431[var1] = -100;
                        }
                     } else {
                        --field527;

                        for(var2 = var1; var2 < field527; ++var2) {
                           field528[var2] = field528[1 + var2];
                           field532[var2] = field532[var2 + 1];
                           field529[var2] = field529[1 + var2];
                           field431[var2] = field431[var2 + 1];
                           field299[var2] = field299[var2 + 1];
                        }

                        --var1;
                     }
                  }

                  if(field524 && !class161.method3188()) {
                     if(field522 != 0 && field318 != -1) {
                        class119.method2349(class34.field746, field318, 0, field522, false);
                     }

                     field524 = false;
                  }

                  ++field335;
                  if(field335 > 750) {
                     if(field405 > 0) {
                        GameEngine.method2223();
                     } else {
                        class186.setGameState(40);
                        WidgetNode.field176 = FileOnDisk.field1183;
                        FileOnDisk.field1183 = null;
                     }
                  } else {
                     class65.method1165();

                     for(var1 = 0; var1 < field326; ++var1) {
                        var2 = field559[var1];
                        NPC var20 = cachedNPCs[var2];
                        if(null != var20) {
                           class103.method1995(var20, var20.composition.field3009);
                        }
                     }

                     class15.method195();
                     ++field517;
                     if(field501 != 0) {
                        field397 += 20;
                        if(field397 >= 400) {
                           field501 = 0;
                        }
                     }

                     if(GameObject.field1614 != null) {
                        ++field399;
                        if(field399 >= 15) {
                           Tile.method1577(GameObject.field1614);
                           GameObject.field1614 = null;
                        }
                     }

                     Widget var40 = class39.field802;
                     Widget var44 = class105.field1723;
                     class39.field802 = null;
                     class105.field1723 = null;
                     field363 = null;
                     field466 = false;
                     field462 = false;
                     field508 = 0;

                     while(true) {
                        while(NPC.method748() && field508 < 128) {
                           if(field503 >= 2 && class105.field1709[82] && class2.field25 == 66) {
                              String var45 = "";

                              MessageNode var21;
                              for(Iterator var42 = class47.field925.iterator(); var42.hasNext(); var45 = var45 + var21.name + ':' + var21.value + '\n') {
                                 var21 = (MessageNode)var42.next();
                              }

                              DecorativeObject.field1600.setContents(new StringSelection(var45), (ClipboardOwner)null);
                           } else {
                              field352[field508] = class2.field25;
                              field474[field508] = class164.field2317;
                              ++field508;
                           }
                        }

                        if(widgetRoot != -1) {
                           var3 = widgetRoot;
                           var4 = class16.field169;
                           var5 = class65.field1103;
                           if(class60.method1127(var3)) {
                              GroundObject.method1570(Widget.widgets[var3], -1, 0, 0, var4, var5, 0, 0);
                           }
                        }

                        ++field470;

                        while(true) {
                           Widget var43;
                           Widget var47;
                           class18 var48;
                           do {
                              var48 = (class18)field485.method2474();
                              if(var48 == null) {
                                 while(true) {
                                    do {
                                       var48 = (class18)field569.method2474();
                                       if(var48 == null) {
                                          while(true) {
                                             do {
                                                var48 = (class18)field484.method2474();
                                                if(var48 == null) {
                                                   boolean var32 = false;

                                                   while(!var32) {
                                                      var32 = true;

                                                      for(var4 = 0; var4 < menuOptionCount - 1; ++var4) {
                                                         if(menuTypes[var4] < 1000 && menuTypes[1 + var4] > 1000) {
                                                            String var46 = menuTargets[var4];
                                                            menuTargets[var4] = menuTargets[var4 + 1];
                                                            menuTargets[1 + var4] = var46;
                                                            String var49 = menuOptions[var4];
                                                            menuOptions[var4] = menuOptions[var4 + 1];
                                                            menuOptions[var4 + 1] = var49;
                                                            var7 = menuTypes[var4];
                                                            menuTypes[var4] = menuTypes[var4 + 1];
                                                            menuTypes[1 + var4] = var7;
                                                            var7 = menuActionParams0[var4];
                                                            menuActionParams0[var4] = menuActionParams0[var4 + 1];
                                                            menuActionParams0[var4 + 1] = var7;
                                                            var7 = menuActionParams1[var4];
                                                            menuActionParams1[var4] = menuActionParams1[1 + var4];
                                                            menuActionParams1[1 + var4] = var7;
                                                            var7 = menuIdentifiers[var4];
                                                            menuIdentifiers[var4] = menuIdentifiers[var4 + 1];
                                                            menuIdentifiers[var4 + 1] = var7;
                                                            var32 = false;
                                                         }
                                                      }
                                                   }

                                                   int var12;
                                                   int var13;
                                                   if(class163.field2313 == null && field383 == null) {
                                                      var3 = class115.field1808;
                                                      if(isMenuOpen) {
                                                         if(var3 != 1 && (MessageNode.field229 || var3 != 4)) {
                                                            var4 = class115.field1811;
                                                            var5 = class115.field1810;
                                                            if(var4 < Projectile.menuX - 10 || var4 > class37.menuWidth + Projectile.menuX + 10 || var5 < XClanMember.menuY - 10 || var5 > class20.menuHeight + XClanMember.menuY + 10) {
                                                               isMenuOpen = false;
                                                               class45.method835(Projectile.menuX, XClanMember.menuY, class37.menuWidth, class20.menuHeight);
                                                            }
                                                         }

                                                         if(var3 == 1 || !MessageNode.field229 && var3 == 4) {
                                                            var4 = Projectile.menuX;
                                                            var5 = XClanMember.menuY;
                                                            var6 = class37.menuWidth;
                                                            var7 = class115.field1809;
                                                            var8 = class115.field1806;
                                                            var9 = -1;

                                                            int var11;
                                                            int var22;
                                                            for(var22 = 0; var22 < menuOptionCount; ++var22) {
                                                               var11 = 15 * (menuOptionCount - 1 - var22) + 31 + var5;
                                                               if(var7 > var4 && var7 < var4 + var6 && var8 > var11 - 13 && var8 < 3 + var11) {
                                                                  var9 = var22;
                                                               }
                                                            }

                                                            if(var9 != -1 && var9 >= 0) {
                                                               var22 = menuActionParams0[var9];
                                                               var11 = menuActionParams1[var9];
                                                               var12 = menuTypes[var9];
                                                               var13 = menuIdentifiers[var9];
                                                               String var14 = menuOptions[var9];
                                                               String var15 = menuTargets[var9];
                                                               KitDefinition.menuAction(var22, var11, var12, var13, var14, var15, class115.field1809, class115.field1806);
                                                            }

                                                            isMenuOpen = false;
                                                            class45.method835(Projectile.menuX, XClanMember.menuY, class37.menuWidth, class20.menuHeight);
                                                         }
                                                      } else {
                                                         label1454: {
                                                            label1492: {
                                                               if((var3 == 1 || !MessageNode.field229 && var3 == 4) && menuOptionCount > 0) {
                                                                  var4 = menuTypes[menuOptionCount - 1];
                                                                  if(var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                                                                     var5 = menuActionParams0[menuOptionCount - 1];
                                                                     var6 = menuActionParams1[menuOptionCount - 1];
                                                                     Widget var23 = class5.method79(var6);
                                                                     if(ChatMessages.method879(class185.method3463(var23))) {
                                                                        break label1492;
                                                                     }

                                                                     var9 = class185.method3463(var23);
                                                                     boolean var34 = (var9 >> 29 & 1) != 0;
                                                                     if(var34) {
                                                                        break label1492;
                                                                     }
                                                                  }
                                                               }

                                                               if((var3 == 1 || !MessageNode.field229 && var3 == 4) && (field437 == 1 && menuOptionCount > 2 || class34.method731(menuOptionCount - 1))) {
                                                                  var3 = 2;
                                                               }

                                                               if((var3 == 1 || !MessageNode.field229 && var3 == 4) && menuOptionCount > 0) {
                                                                  var4 = menuOptionCount - 1;
                                                                  if(var4 >= 0) {
                                                                     var5 = menuActionParams0[var4];
                                                                     var6 = menuActionParams1[var4];
                                                                     var7 = menuTypes[var4];
                                                                     var8 = menuIdentifiers[var4];
                                                                     String var24 = menuOptions[var4];
                                                                     String var10 = menuTargets[var4];
                                                                     KitDefinition.menuAction(var5, var6, var7, var8, var24, var10, class115.field1809, class115.field1806);
                                                                  }
                                                               }

                                                               if(var3 == 2 && menuOptionCount > 0) {
                                                                  TextureProvider.method1485(class115.field1809, class115.field1806);
                                                               }
                                                               break label1454;
                                                            }

                                                            if(null != class163.field2313 && !field433 && field437 != 1 && !class34.method731(menuOptionCount - 1) && menuOptionCount > 0) {
                                                               class25.method606(field402, field403);
                                                            }

                                                            field433 = false;
                                                            field406 = 0;
                                                            if(class163.field2313 != null) {
                                                               Tile.method1577(class163.field2313);
                                                            }

                                                            class163.field2313 = class5.method79(var6);
                                                            field401 = var5;
                                                            field402 = class115.field1809;
                                                            field403 = class115.field1806;
                                                            if(menuOptionCount > 0) {
                                                               var8 = menuOptionCount - 1;
                                                               class2.field19 = new class38();
                                                               class2.field19.field798 = menuActionParams0[var8];
                                                               class2.field19.field791 = menuActionParams1[var8];
                                                               class2.field19.field792 = menuTypes[var8];
                                                               class2.field19.field793 = menuIdentifiers[var8];
                                                               class2.field19.field790 = menuOptions[var8];
                                                            }

                                                            Tile.method1577(class163.field2313);
                                                         }
                                                      }
                                                   }

                                                   if(field383 != null) {
                                                      Tile.method1577(field383);
                                                      ++GroundObject.field1289;
                                                      if(field466 && field462) {
                                                         var3 = class115.field1811;
                                                         var4 = class115.field1810;
                                                         var3 -= field507;
                                                         var4 -= field461;
                                                         if(var3 < field464) {
                                                            var3 = field464;
                                                         }

                                                         if(field383.width + var3 > field340.width + field464) {
                                                            var3 = field340.width + field464 - field383.width;
                                                         }

                                                         if(var4 < field465) {
                                                            var4 = field465;
                                                         }

                                                         if(var4 + field383.height > field340.height + field465) {
                                                            var4 = field340.height + field465 - field383.height;
                                                         }

                                                         var5 = var3 - field467;
                                                         var6 = var4 - field417;
                                                         var7 = field383.field2125;
                                                         if(GroundObject.field1289 > field383.field2146 && (var5 > var7 || var5 < -var7 || var6 > var7 || var6 < -var7)) {
                                                            field469 = true;
                                                         }

                                                         var8 = field340.itemId + (var3 - field464);
                                                         var9 = var4 - field465 + field340.scrollY;
                                                         class18 var35;
                                                         if(field383.field2158 != null && field469) {
                                                            var35 = new class18();
                                                            var35.field192 = field383;
                                                            var35.field184 = var8;
                                                            var35.field185 = var9;
                                                            var35.field196 = field383.field2158;
                                                            class164.method3225(var35, 200000);
                                                         }

                                                         if(class115.field1801 == 0) {
                                                            if(field469) {
                                                               if(null != field383.field2058) {
                                                                  var35 = new class18();
                                                                  var35.field192 = field383;
                                                                  var35.field184 = var8;
                                                                  var35.field185 = var9;
                                                                  var35.field187 = field363;
                                                                  var35.field196 = field383.field2058;
                                                                  class164.method3225(var35, 200000);
                                                               }

                                                               if(null != field363) {
                                                                  Widget var25 = field383;
                                                                  var12 = class193.method3586(class185.method3463(var25));
                                                                  Widget var37;
                                                                  if(var12 == 0) {
                                                                     var37 = null;
                                                                  } else {
                                                                     var13 = 0;

                                                                     while(true) {
                                                                        if(var13 >= var12) {
                                                                           var37 = var25;
                                                                           break;
                                                                        }

                                                                        var25 = class5.method79(var25.parentId);
                                                                        if(var25 == null) {
                                                                           var37 = null;
                                                                           break;
                                                                        }

                                                                        ++var13;
                                                                     }
                                                                  }

                                                                  if(var37 != null) {
                                                                     field330.method3234(164);
                                                                     field330.method2976(field363.index);
                                                                     field330.method3023(field383.item);
                                                                     field330.method2978(field383.id);
                                                                     field330.method3183(field383.index);
                                                                     field330.method3011(field363.id);
                                                                     field330.method3183(field363.item);
                                                                  }
                                                               }
                                                            } else if((field437 == 1 || class34.method731(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                               TextureProvider.method1485(field467 + field507, field417 + field461);
                                                            } else if(menuOptionCount > 0) {
                                                               class25.method606(field507 + field467, field417 + field461);
                                                            }

                                                            field383 = null;
                                                         }
                                                      } else if(GroundObject.field1289 > 1) {
                                                         field383 = null;
                                                      }
                                                   }

                                                   if(null != class163.field2313) {
                                                      Tile.method1577(class163.field2313);
                                                      ++field406;
                                                      if(class115.field1801 != 0) {
                                                         if(field406 >= 5 && (class115.field1811 > field402 + 5 || class115.field1811 < field402 - 5 || class115.field1810 > field403 + 5 || class115.field1810 < field403 - 5)) {
                                                            field433 = true;
                                                         }
                                                      } else {
                                                         if(field433) {
                                                            if(class163.field2313 == DecorativeObject.field1603 && field401 != field404) {
                                                               Widget var50 = class163.field2313;
                                                               byte var38 = 0;
                                                               if(field448 == 1 && var50.contentType == 206) {
                                                                  var38 = 1;
                                                               }

                                                               if(var50.itemIds[field404] <= 0) {
                                                                  var38 = 0;
                                                               }

                                                               var6 = class185.method3463(var50);
                                                               boolean var36 = (var6 >> 29 & 1) != 0;
                                                               if(var36) {
                                                                  var7 = field401;
                                                                  var8 = field404;
                                                                  var50.itemIds[var8] = var50.itemIds[var7];
                                                                  var50.itemQuantities[var8] = var50.itemQuantities[var7];
                                                                  var50.itemIds[var7] = -1;
                                                                  var50.itemQuantities[var7] = 0;
                                                               } else if(var38 == 1) {
                                                                  var7 = field401;
                                                                  var8 = field404;

                                                                  while(var8 != var7) {
                                                                     if(var7 > var8) {
                                                                        var50.method2841(var7 - 1, var7);
                                                                        --var7;
                                                                     } else if(var7 < var8) {
                                                                        var50.method2841(1 + var7, var7);
                                                                        ++var7;
                                                                     }
                                                                  }
                                                               } else {
                                                                  var50.method2841(field404, field401);
                                                               }

                                                               field330.method3234(182);
                                                               field330.method3011(class163.field2313.id);
                                                               field330.method2976(field404);
                                                               field330.method3173(var38);
                                                               field330.method2976(field401);
                                                            }
                                                         } else if((field437 == 1 || class34.method731(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                            TextureProvider.method1485(field402, field403);
                                                         } else if(menuOptionCount > 0) {
                                                            class25.method606(field402, field403);
                                                         }

                                                         field399 = 10;
                                                         class115.field1808 = 0;
                                                         class163.field2313 = null;
                                                      }
                                                   }

                                                   if(Region.field1506 != -1) {
                                                      var3 = Region.field1506;
                                                      var4 = Region.field1507;
                                                      field330.method3234(214);
                                                      field330.method2975(5);
                                                      field330.method2976(class16.baseX + var3);
                                                      field330.method3098(class105.field1709[82]?(class105.field1709[81]?2:1):0);
                                                      field330.method3183(baseY + var4);
                                                      Region.field1506 = -1;
                                                      field395 = class115.field1809;
                                                      field396 = class115.field1806;
                                                      field501 = 1;
                                                      field397 = 0;
                                                      flagX = var3;
                                                      flagY = var4;
                                                   }

                                                   if(var40 != class39.field802) {
                                                      if(null != var40) {
                                                         Tile.method1577(var40);
                                                      }

                                                      if(class39.field802 != null) {
                                                         Tile.method1577(class39.field802);
                                                      }
                                                   }

                                                   if(var44 != class105.field1723 && field424 == field436) {
                                                      if(var44 != null) {
                                                         Tile.method1577(var44);
                                                      }

                                                      if(class105.field1723 != null) {
                                                         Tile.method1577(class105.field1723);
                                                      }
                                                   }

                                                   if(null != class105.field1723) {
                                                      if(field436 < field424) {
                                                         ++field436;
                                                         if(field436 == field424) {
                                                            Tile.method1577(class105.field1723);
                                                         }
                                                      }
                                                   } else if(field436 > 0) {
                                                      --field436;
                                                   }

                                                   class37.method768();
                                                   if(field533) {
                                                      class109.method2100();
                                                   }

                                                   for(var3 = 0; var3 < 5; ++var3) {
                                                      ++field471[var3];
                                                   }

                                                   class3.chatMessages.method853();
                                                   var3 = Friend.method189();
                                                   var4 = class105.keyboardIdleTicks;
                                                   if(var3 > 15000 && var4 > 15000) {
                                                      field405 = 250;
                                                      class26.method615(14500);
                                                      field330.method3234(4);
                                                   }

                                                   ++field495;
                                                   if(field495 > 500) {
                                                      field495 = 0;
                                                      var6 = (int)(Math.random() * 8.0D);
                                                      if((var6 & 1) == 1) {
                                                         field351 += field509;
                                                      }

                                                      if((var6 & 2) == 2) {
                                                         field353 += field354;
                                                      }

                                                      if((var6 & 4) == 4) {
                                                         field355 += field356;
                                                      }
                                                   }

                                                   if(field351 < -50) {
                                                      field509 = 2;
                                                   }

                                                   if(field351 > 50) {
                                                      field509 = -2;
                                                   }

                                                   if(field353 < -55) {
                                                      field354 = 2;
                                                   }

                                                   if(field353 > 55) {
                                                      field354 = -2;
                                                   }

                                                   if(field355 < -40) {
                                                      field356 = 1;
                                                   }

                                                   if(field355 > 40) {
                                                      field356 = -1;
                                                   }

                                                   ++field362;
                                                   if(field362 > 500) {
                                                      field362 = 0;
                                                      var6 = (int)(Math.random() * 8.0D);
                                                      if((var6 & 1) == 1) {
                                                         mapScale += field454;
                                                      }

                                                      if((var6 & 2) == 2) {
                                                         mapScaleDelta += field361;
                                                      }
                                                   }

                                                   if(mapScale < -60) {
                                                      field454 = 2;
                                                   }

                                                   if(mapScale > 60) {
                                                      field454 = -2;
                                                   }

                                                   if(mapScaleDelta < -20) {
                                                      field361 = 1;
                                                   }

                                                   if(mapScaleDelta > 10) {
                                                      field361 = -1;
                                                   }

                                                   for(class16 var51 = (class16)field555.method2489(); var51 != null; var51 = (class16)field555.method2488()) {
                                                      if((long)var51.field168 < class202.method3838() / 1000L - 5L) {
                                                         if(var51.field162 > 0) {
                                                            class10.method120(5, "", var51.field163 + " has logged in.");
                                                         }

                                                         if(var51.field162 == 0) {
                                                            class10.method120(5, "", var51.field163 + " has logged out.");
                                                         }

                                                         var51.method2501();
                                                      }
                                                   }

                                                   ++field336;
                                                   if(field336 > 50) {
                                                      field330.method3234(155);
                                                   }

                                                   try {
                                                      if(null != FileOnDisk.field1183 && field330.offset > 0) {
                                                         FileOnDisk.field1183.method2107(field330.payload, 0, field330.offset);
                                                         field330.offset = 0;
                                                         field336 = 0;
                                                         return;
                                                      }
                                                   } catch (IOException var26) {
                                                      if(field405 > 0) {
                                                         GameEngine.method2223();
                                                      } else {
                                                         class186.setGameState(40);
                                                         WidgetNode.field176 = FileOnDisk.field1183;
                                                         FileOnDisk.field1183 = null;
                                                      }

                                                      return;
                                                   }

                                                   return;
                                                }

                                                var47 = var48.field192;
                                                if(var47.index < 0) {
                                                   break;
                                                }

                                                var43 = class5.method79(var47.parentId);
                                             } while(null == var43 || var43.children == null || var47.index >= var43.children.length || var43.children[var47.index] != var47);

                                             class164.method3225(var48, 200000);
                                          }
                                       }

                                       var47 = var48.field192;
                                       if(var47.index < 0) {
                                          break;
                                       }

                                       var43 = class5.method79(var47.parentId);
                                    } while(var43 == null || var43.children == null || var47.index >= var43.children.length || var43.children[var47.index] != var47);

                                    class164.method3225(var48, 200000);
                                 }
                              }

                              var47 = var48.field192;
                              if(var47.index < 0) {
                                 break;
                              }

                              var43 = class5.method79(var47.parentId);
                           } while(var43 == null || null == var43.children || var47.index >= var43.children.length || var43.children[var47.index] != var47);

                           class164.method3225(var48, 200000);
                        }
                     }
                  }
               }
            }
         }
      } else if(gameState == 40 || gameState == 45) {
         class110.method2102();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "62"
   )
   protected final void vmethod2245() {
      boolean var1 = class28.method632();
      if(var1 && field524 && class11.field114 != null) {
         class11.field114.method1044();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(0L != field498 && class202.method3838() > field498) {
            int var2 = class105.method2061();
            field498 = 0L;
            if(var2 >= 2) {
               isResized = true;
            } else {
               isResized = false;
            }

            ItemComposition.method3726();
            if(gameState >= 25) {
               class34.method730();
            }

            GameEngine.field1780 = true;
         } else if(GameEngine.field1768) {
            class216.method4024();
         }
      }

      Dimension var6 = this.method2163();
      if(var6.width != class166.field2322 || class49.field953 != var6.height || GameEngine.field1782) {
         ItemComposition.method3726();
         field498 = class202.method3838() + 500L;
         GameEngine.field1782 = false;
      }

      boolean var3 = false;
      int var4;
      if(GameEngine.field1780) {
         GameEngine.field1780 = false;
         var3 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field490[var4] = true;
         }
      }

      if(var3) {
         WidgetNode.method203();
      }

      if(gameState == 0) {
         class156.method2955(class41.field833, class41.field826, (Color)null, var3);
      } else if(gameState == 5) {
         Widget.method2894(class156.field2236, GroundObject.field1293, XGrandExchangeOffer.field45, var3);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            Widget.method2894(class156.field2236, GroundObject.field1293, XGrandExchangeOffer.field45, var3);
         } else if(gameState == 25) {
            if(field367 == 1) {
               if(field342 > field343) {
                  field343 = field342;
               }

               var4 = (field343 * 50 - field342 * 50) / field343;
               World.method669("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field367 == 2) {
               if(field344 > field345) {
                  field345 = field344;
               }

               var4 = (field345 * 50 - field344 * 50) / field345 + 50;
               World.method669("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               World.method669("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            class13.method184();
         } else if(gameState == 40) {
            World.method669("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            World.method669("Please wait...", false);
         }
      } else {
         Widget.method2894(class156.field2236, GroundObject.field1293, XGrandExchangeOffer.field45, var3);
      }

      int var5;
      Graphics var7;
      if(gameState == 30 && field497 == 0 && !var3) {
         try {
            var7 = class107.canvas.getGraphics();

            for(var5 = 0; var5 < field488; ++var5) {
               if(field491[var5]) {
                  class34.bufferProvider.drawSub(var7, widgetPositionX[var5], widgetPositionY[var5], widgetBoundsWidth[var5], widgetBoundsHeight[var5]);
                  field491[var5] = false;
               }
            }
         } catch (Exception var9) {
            class107.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var7 = class107.canvas.getGraphics();
            class34.bufferProvider.draw(var7, 0, 0);

            for(var5 = 0; var5 < field488; ++var5) {
               field491[var5] = false;
            }
         } catch (Exception var8) {
            class107.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method389() {
      if(gameState != 1000) {
         boolean var1 = XClanMember.method263();
         if(!var1) {
            this.method273();
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "136392450"
   )
   protected final void vmethod2242() {
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "16711935"
   )
   static final void method603(int var0) {
      if(class60.method1127(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2057 = 0;
               var3.field2192 = 0;
            }
         }

      }
   }

   @ObfuscatedName("rs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1120186618"
   )
   protected static final void method604() {
      VertexNormal.field1414.vmethod2090();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1770[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1779[var0] = 0L;
      }

      class7.field60 = 0;
   }
}
