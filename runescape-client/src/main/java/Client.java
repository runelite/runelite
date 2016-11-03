import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.image.ImageObserver;
import java.io.IOException;
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
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1350326915
   )
   @Export("packetOpcode")
   static int packetOpcode;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1206638557
   )
   static int field276;
   @ObfuscatedName("cc")
   static class149 field277;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1883557159
   )
   static int field278 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -455642155
   )
   static int field279 = 0;
   @ObfuscatedName("u")
   static class157 field280;
   @ObfuscatedName("l")
   @Export("isMembers")
   static boolean isMembers = false;
   @ObfuscatedName("b")
   static boolean field282 = false;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1966914965
   )
   static int field283 = 0;
   @ObfuscatedName("e")
   static String field284;
   @ObfuscatedName("p")
   static String field285;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1261681517
   )
   @Export("gameState")
   static int gameState = 0;
   @ObfuscatedName("a")
   static boolean field287 = true;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -368760707
   )
   @Export("gameCycle")
   static int gameCycle = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 3046536626578623561L
   )
   static long field289 = -1L;
   @ObfuscatedName("kx")
   static Deque field290;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1018464477
   )
   static int field291 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1628984807
   )
   static int field292 = -1;
   @ObfuscatedName("al")
   static boolean field293 = true;
   @ObfuscatedName("av")
   static boolean field294 = false;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1685460291
   )
   static int field295;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 445552271
   )
   static int field296;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = 837585647
   )
   @Export("camera3")
   static int camera3;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 2086502207
   )
   static int field298;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = -8206945
   )
   static int field299;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -92561233
   )
   static int field300 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1989253033
   )
   static int field301 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1812958527
   )
   static int field302 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 710916061
   )
   static int field303 = 0;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1431914209
   )
   static int field304 = 0;
   @ObfuscatedName("aw")
   static class21 field305;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -431129333
   )
   static int field306;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 703853985
   )
   static int field307;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -475859233
   )
   static int field308;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = 8564447213549548281L
   )
   static long field309;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -942929823
   )
   static int field310;
   @ObfuscatedName("bu")
   static class171 field311;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1655792371
   )
   static int field312;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1576602137
   )
   static int field313;
   @ObfuscatedName("cp")
   static class125 field314;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 405981715
   )
   static int field315;
   @ObfuscatedName("jv")
   static boolean field316;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1275616859
   )
   static int field317;
   @ObfuscatedName("cs")
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 752509227
   )
   static int field319;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1852270109
   )
   static int field320;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -1860904671
   )
   static int field321;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1190316483
   )
   static int field322;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -1721510029
   )
   static int field323;
   @ObfuscatedName("cm")
   static class125 field324;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1640131477
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -129026041
   )
   static int field326;
   @ObfuscatedName("nl")
   static int[] field327;
   @ObfuscatedName("il")
   static String field328;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1554049399
   )
   static int field329;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -581412203
   )
   static int field330;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 516072325
   )
   static int field331;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1636929473
   )
   static int field332;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 807679837
   )
   static int field333;
   @ObfuscatedName("dc")
   static int[][][] field334;
   @ObfuscatedName("cz")
   static boolean field335;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -1819312163
   )
   static int field336;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 382938247
   )
   static int field337;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 47703343
   )
   static int field338 = -1;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 2114346781
   )
   static int field339;
   @ObfuscatedName("cg")
   static class125 field340;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("dk")
   static boolean field342;
   @ObfuscatedName("je")
   static Widget field343;
   @ObfuscatedName("oi")
   static short field344;
   @ObfuscatedName("fe")
   static int[] field345;
   @ObfuscatedName("lp")
   static int[] field346;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 701927737
   )
   static int field347;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 924381473
   )
   static int field348;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 116362659
   )
   static int field349;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -1703524543
   )
   static int field350;
   @ObfuscatedName("ny")
   static boolean[] field351;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1173472887
   )
   @Export("mapScale")
   static int mapScale;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1001950159
   )
   static int field353;
   @ObfuscatedName("fw")
   static int[] field354;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 1151782321
   )
   static int field355;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1514417495
   )
   static int field356;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -923008475
   )
   static int field357;
   @ObfuscatedName("eb")
   static ModIcon[] field358;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 1451311951
   )
   static int field359;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 1575173947
   )
   static int field360;
   @ObfuscatedName("jp")
   static Widget field361;
   @ObfuscatedName("ow")
   static int[] field362;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 533413567
   )
   static int field363;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -6921273
   )
   static int field364;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -271268193
   )
   static int field365;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1191302897
   )
   @Export("flags")
   static int flags = 0;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -989211699
   )
   static int field367;
   @ObfuscatedName("mf")
   static int[] field368;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -1278644031
   )
   static int field369;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 381620951
   )
   static int field370;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1024085285
   )
   static int field371;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 313998667
   )
   static int field372;
   @ObfuscatedName("fx")
   static boolean field373;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 433114323
   )
   static int field374;
   @ObfuscatedName("ja")
   static boolean field375;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -1371960965
   )
   static int field376;
   @ObfuscatedName("fp")
   static int[] field377;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 1870377801
   )
   static int field378;
   @ObfuscatedName("fu")
   static int[] field379;
   @ObfuscatedName("fs")
   static int[] field380;
   @ObfuscatedName("fk")
   static int[] field381;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1827692537
   )
   @Export("world")
   static int world = 1;
   @ObfuscatedName("fz")
   static int[] field383;
   @ObfuscatedName("gs")
   static String[] field384;
   @ObfuscatedName("gx")
   static int[][] field385;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 505423087
   )
   static int field386;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -630302275
   )
   static int field387;
   @ObfuscatedName("jc")
   static Widget field388;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1968736525
   )
   static int field389;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 2056150055
   )
   static int field390;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -1602610469
   )
   static int field391;
   @ObfuscatedName("nf")
   static int[] field392;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -345199549
   )
   static int field393;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -1532863157
   )
   static int field394;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -68832819
   )
   static int field395;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1439483433
   )
   static int field396;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1451220559
   )
   static int field397;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 1157926369
   )
   static int field398;
   @ObfuscatedName("ge")
   static boolean field399;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -1600312497
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -267797247
   )
   static int field401;
   @ObfuscatedName("gc")
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 848297079
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -1001371893
   )
   static int field404;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 671937861
   )
   static int field405;
   @ObfuscatedName("hb")
   static int[] field406;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -1964444737
   )
   static int field407;
   @ObfuscatedName("hy")
   static String[] field408;
   @ObfuscatedName("hc")
   static boolean[] field409;
   @ObfuscatedName("hg")
   static int[] field410;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 303646911
   )
   static int field411;
   @ObfuscatedName("hp")
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("hn")
   static Deque field413;
   @ObfuscatedName("hx")
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hw")
   static Deque field415;
   @ObfuscatedName("he")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ha")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("hs")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = 2133434915
   )
   static int field419;
   @ObfuscatedName("ho")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 638526351
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1306430371
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("bg")
   static class171 field423;
   @ObfuscatedName("hi")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("iu")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ic")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1068931405
   )
   static int field427 = 0;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -855887667
   )
   static int field428;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -68288339
   )
   static int field429;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1642803611
   )
   static int field430;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1951273291
   )
   static int field431;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -98879805
   )
   static int field432;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 450280093
   )
   static int field433;
   @ObfuscatedName("ix")
   static String field434;
   @ObfuscatedName("ig")
   static boolean field435;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -2122939081
   )
   static int field436;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = 1775055387
   )
   static int field437;
   @ObfuscatedName("kn")
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("ik")
   static String field439;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -151612619
   )
   @Export("flagX")
   static int flagX;
   @ObfuscatedName("ir")
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -42331899
   )
   static int field442;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -891759937
   )
   static int field443;
   @ObfuscatedName("ie")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 347405099
   )
   static int field445;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -541489289
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -920805965
   )
   static int field447;
   @ObfuscatedName("od")
   static short field448;
   @ObfuscatedName("jd")
   static boolean field449;
   @ObfuscatedName("pv")
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("jl")
   static boolean field451;
   @ObfuscatedName("ji")
   static Widget field452;
   @ObfuscatedName("jn")
   static Widget field453;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -1148018291
   )
   @Export("mapScaleDelta")
   static int mapScaleDelta;
   @ObfuscatedName("mm")
   static String field455;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -640875729
   )
   static int field456;
   @ObfuscatedName("ob")
   static short field457;
   @ObfuscatedName("jq")
   static boolean field458;
   @ObfuscatedName("hq")
   static final int[] field459;
   @ObfuscatedName("lw")
   static long[] field460;
   @ObfuscatedName("jz")
   static boolean field461;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 181144739
   )
   static int field462;
   @ObfuscatedName("oh")
   static class198 field463;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 1789017917
   )
   static int field464;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1398840285
   )
   static int field465;
   @ObfuscatedName("ku")
   static int[] field466;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1903603219
   )
   static int field467 = 0;
   @ObfuscatedName("kh")
   static int[] field468;
   @ObfuscatedName("pq")
   static final class10 field469;
   @ObfuscatedName("kz")
   static int[] field470;
   @ObfuscatedName("oz")
   static int[] field471;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -1460595685
   )
   static int field472;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -1827576117
   )
   static int field473;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -849876599
   )
   static int field474;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1707604449
   )
   static int field475;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 614566661
   )
   static int field476;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = 1560618873
   )
   static int field477;
   @ObfuscatedName("le")
   static int[] field478;
   @ObfuscatedName("cu")
   static int[] field479;
   @ObfuscatedName("q")
   static Client field480;
   @ObfuscatedName("kg")
   static Deque field481;
   @ObfuscatedName("hz")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -1108119119
   )
   static int field483;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1640661649
   )
   static int field484;
   @ObfuscatedName("kv")
   static boolean[] field485;
   @ObfuscatedName("lb")
   static boolean[] field486;
   @ObfuscatedName("lc")
   static boolean[] field487;
   @ObfuscatedName("lh")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("lf")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("lg")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("la")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -19938033
   )
   static int field492;
   @ObfuscatedName("op")
   static int[] field493;
   @ObfuscatedName("ln")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 801409277
   )
   static int field495;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 1959478737
   )
   static int field496;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 1379890693
   )
   static int field497;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -1003357179
   )
   static int field498;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -384882645
   )
   static int field499;
   @ObfuscatedName("li")
   static String field500;
   @ObfuscatedName("cn")
   static int[] field501;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -670040907
   )
   static int field502;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      longValue = 5645897362371761143L
   )
   static long field503;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -937572043
   )
   static int field504;
   @ObfuscatedName("ma")
   static int[] field505;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      longValue = -1291083534739135365L
   )
   static long field506;
   @ObfuscatedName("ek")
   static boolean field507;
   @ObfuscatedName("mh")
   static String field508;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 740642431
   )
   static int field509;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 1537086577
   )
   static int field510;
   @ObfuscatedName("mb")
   static int[] field511;
   @ObfuscatedName("oe")
   static short field512;
   @ObfuscatedName("mv")
   static SpritePixels[] field513;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -1503402371
   )
   static int field514;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 316320577
   )
   @Export("flagY")
   static int flagY;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = 91229819
   )
   static int field516;
   @ObfuscatedName("de")
   static final int[] field517;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = 1071720795
   )
   static int field518;
   @ObfuscatedName("mq")
   static boolean field519;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = -714023485
   )
   static int field520;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -163752291
   )
   static int field521;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 1302303659
   )
   static int field522;
   @ObfuscatedName("no")
   static int[] field523;
   @ObfuscatedName("nk")
   static int[] field524;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1820027519
   )
   static int field525 = 0;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -1787741641
   )
   static int field526;
   @ObfuscatedName("nq")
   static class61[] field527;
   @ObfuscatedName("nt")
   static boolean field528;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1348531359
   )
   static int field529;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -1696745631
   )
   static int field530;
   @ObfuscatedName("if")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("ky")
   static Deque field532;
   @ObfuscatedName("oy")
   static int[] field533;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -651258727
   )
   static int field534;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 1380247027
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("of")
   static short field536;
   @ObfuscatedName("ol")
   static short field537;
   @ObfuscatedName("ox")
   static short field538;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -316278559
   )
   static int field539;
   @ObfuscatedName("ot")
   static short field540;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = -563684897
   )
   static int field541;
   @ObfuscatedName("f")
   static boolean field542 = true;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 1776151463
   )
   static int field543;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 520330021
   )
   @Export("camera2")
   static int camera2;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 347923139
   )
   static int field545;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = -1844765623
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -438078729
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1735384933
   )
   static int field548;
   @ObfuscatedName("ov")
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 295191651
   )
   static int field550;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 1299369617
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("oc")
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("og")
   static PlayerComposition field553;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = -440183355
   )
   static int field554;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -1994925865
   )
   static int field555;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      longValue = -3119238685781585165L
   )
   static long field556;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      longValue = -8412052594995111239L
   )
   static long field557;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 232220839
   )
   static int field558;
   @ObfuscatedName("ao")
   static class21 field559;
   @ObfuscatedName("pi")
   static int[] field560;
   @ObfuscatedName("ph")
   static int[] field561;

   public final void init() {
      if(this.method3046()) {
         class193[] var1 = new class193[]{class193.field3116, class193.field3112, class193.field3110, class193.field3108, class193.field3102, class193.field3111, class193.field3109, class193.field3105, class193.field3115, class193.field3104, class193.field3106, class193.field3114, class193.field3101, class193.field3107, class193.field3103};
         class193[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class193 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3113);
            if(null != var5) {
               switch(Integer.parseInt(var4.field3113)) {
               case 2:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 3:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 4:
                  field283 = Integer.parseInt(var5);
                  break;
               case 5:
                  XItemContainer.field219 = Integer.parseInt(var5);
                  break;
               case 6:
                  field279 = Integer.parseInt(var5);
                  break;
               case 7:
                  field284 = var5;
               case 8:
               case 12:
               default:
                  break;
               case 9:
                  SecondaryBufferProvider.field1430 = Integer.parseInt(var5);
                  break;
               case 10:
                  flags = Integer.parseInt(var5);
                  break;
               case 11:
                  world = Integer.parseInt(var5);
                  break;
               case 13:
                  class154.field2300 = class93.method2155(Integer.parseInt(var5));
                  break;
               case 14:
                  field280 = (class157)class77.method1656(BufferProvider.method1733(), Integer.parseInt(var5));
                  if(field280 == class157.field2330) {
                     class43.field996 = class215.field3193;
                  } else {
                     class43.field996 = class215.field3194;
                  }
                  break;
               case 15:
                  field285 = var5;
               }
            }
         }

         class114.method2490();
         class124.host = this.getCodeBase().getHost();
         String var9 = class154.field2300.field2324;
         byte var6 = 0;

         try {
            FrameMap.method2353("oldschool", var9, var6, 16);
         } catch (Exception var8) {
            RSCanvas.method2969((String)null, var8);
         }

         field480 = this;
         this.method3044(765, 503, 125);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1223229248"
   )
   protected final void vmethod3056() {
      field317 = field279 == 0?'ꩊ':'鱀' + world;
      MessageNode.field803 = field279 == 0?443:'썐' + world;
      class119.field2041 = field317;
      class109.field1925 = class177.field2937;
      PlayerComposition.field2968 = class177.field2935;
      class112.field1966 = class177.field2936;
      class4.field72 = class177.field2938;
      if(class139.field2144.toLowerCase().indexOf("microsoft") != -1) {
         class140.field2175[186] = 57;
         class140.field2175[187] = 27;
         class140.field2175[188] = 71;
         class140.field2175[189] = 26;
         class140.field2175[190] = 72;
         class140.field2175[191] = 73;
         class140.field2175[192] = 58;
         class140.field2175[219] = 42;
         class140.field2175[220] = 74;
         class140.field2175[221] = 43;
         class140.field2175[222] = 59;
         class140.field2175[223] = 28;
      } else {
         class140.field2175[44] = 71;
         class140.field2175[45] = 26;
         class140.field2175[46] = 72;
         class140.field2175[47] = 73;
         class140.field2175[59] = 57;
         class140.field2175[61] = 27;
         class140.field2175[91] = 42;
         class140.field2175[92] = 74;
         class140.field2175[93] = 43;
         class140.field2175[192] = 28;
         class140.field2175[222] = 58;
         class140.field2175[520] = 59;
      }

      class16.method169(VertexNormal.canvas);
      Canvas var1 = VertexNormal.canvas;
      var1.addMouseListener(class143.mouse);
      var1.addMouseMotionListener(class143.mouse);
      var1.addFocusListener(class143.mouse);
      class13.field201 = Item.method674();
      if(null != class13.field201) {
         class13.field201.vmethod3134(VertexNormal.canvas);
      }

      class31.field709 = new class137(255, class152.field2279, class152.field2284, 500000);
      FileOnDisk var3 = null;
      class8 var4 = new class8();

      try {
         var3 = class116.method2507("", field280.field2328, false);
         byte[] var5 = new byte[(int)var3.method4147()];

         int var7;
         for(int var6 = 0; var6 < var5.length; var6 += var7) {
            var7 = var3.method4143(var5, var6, var5.length - var6);
            if(var7 == -1) {
               throw new IOException();
            }
         }

         var4 = new class8(new Buffer(var5));
      } catch (Exception var9) {
         ;
      }

      try {
         if(null != var3) {
            var3.method4146();
         }
      } catch (Exception var8) {
         ;
      }

      class130.field2102 = var4;
      class16.field237 = this.getToolkit().getSystemClipboard();
      String var10 = class38.field821;
      class141.field2188 = this;
      class141.field2182 = var10;
      if(field279 != 0) {
         field294 = true;
      }

      class45.method942(class130.field2102.field136);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-958207511"
   )
   protected final void vmethod3052() {
      if(class50.chatMessages.method198()) {
         class50.chatMessages.method195();
      }

      if(class161.field2639 != null) {
         class161.field2639.field189 = false;
      }

      class161.field2639 = null;
      if(null != class28.field671) {
         class28.field671.method3020();
         class28.field671 = null;
      }

      class38.method770();
      if(class143.mouse != null) {
         class143 var1 = class143.mouse;
         synchronized(class143.mouse) {
            class143.mouse = null;
         }
      }

      class13.field201 = null;
      if(null != class141.field2184) {
         class141.field2184.method1257();
      }

      if(null != class178.field2948) {
         class178.field2948.method1257();
      }

      class33.method718();
      ChatMessages.method189();
      TextureProvider.method2264();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1804222606"
   )
   void method235() {
      if(gameState != 1000) {
         boolean var1 = XItemContainer.method164();
         if(!var1) {
            this.method236();
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "73"
   )
   void method236() {
      if(class174.field2777 >= 4) {
         this.method3060("js5crc");
         gameState = 1000;
      } else {
         if(class174.field2778 >= 4) {
            if(gameState <= 5) {
               this.method3060("js5io");
               gameState = 1000;
               return;
            }

            field308 = 3000;
            class174.field2778 = 3;
         }

         if(--field308 + 1 <= 0) {
            try {
               if(field307 == 0) {
                  class12.field179 = Item.field699.method2917(class124.host, class119.field2041);
                  ++field307;
               }

               if(field307 == 1) {
                  if(class12.field179.field2268 == 2) {
                     this.method237(-1);
                     return;
                  }

                  if(class12.field179.field2268 == 1) {
                     ++field307;
                  }
               }

               if(field307 == 2) {
                  class28.field675 = new class146((Socket)class12.field179.field2262, Item.field699);
                  Buffer var1 = new Buffer(5);
                  var1.method2556(15);
                  var1.method2559(125);
                  class28.field675.method3027(var1.payload, 0, 5);
                  ++field307;
                  field309 = class169.method3276();
               }

               if(field307 == 3) {
                  if(gameState > 5 && class28.field675.method3022() <= 0) {
                     if(class169.method3276() - field309 > 30000L) {
                        this.method237(-2);
                        return;
                     }
                  } else {
                     int var2 = class28.field675.method3021();
                     if(var2 != 0) {
                        this.method237(var2);
                        return;
                     }

                     ++field307;
                  }
               }

               if(field307 == 4) {
                  class163.method3209(class28.field675, gameState > 20);
                  class12.field179 = null;
                  class28.field675 = null;
                  field307 = 0;
                  field312 = 0;
               }
            } catch (IOException var3) {
               this.method237(-3);
            }

         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-409232567"
   )
   void method237(int var1) {
      class12.field179 = null;
      class28.field675 = null;
      field307 = 0;
      if(field317 == class119.field2041) {
         class119.field2041 = MessageNode.field803;
      } else {
         class119.field2041 = field317;
      }

      ++field312;
      if(field312 < 2 || var1 != 7 && var1 != 9) {
         if(field312 >= 2 && var1 == 6) {
            this.method3060("js5connect_outofdate");
            gameState = 1000;
         } else if(field312 >= 4) {
            if(gameState <= 5) {
               this.method3060("js5connect");
               gameState = 1000;
            } else {
               field308 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.method3060("js5connect_full");
         gameState = 1000;
      } else {
         field308 = 3000;
      }

   }

   static {
      field559 = class21.field573;
      field305 = class21.field573;
      field306 = 0;
      field307 = 0;
      field308 = 0;
      field312 = 0;
      field313 = 0;
      field529 = 0;
      field310 = 0;
      field322 = 0;
      cachedNPCs = new NPC['耀'];
      field319 = 0;
      field501 = new int['耀'];
      field321 = 0;
      field479 = new int[250];
      field324 = new class125(5000);
      field340 = new class125(5000);
      field314 = new class125(15000);
      field276 = 0;
      packetOpcode = 0;
      field329 = 0;
      field330 = 0;
      field331 = 0;
      field332 = 0;
      field430 = 0;
      field397 = 0;
      field335 = false;
      field336 = 0;
      field337 = 1;
      field514 = 0;
      field296 = 1;
      field548 = 0;
      collisionMaps = new CollisionData[4];
      field342 = false;
      field334 = new int[4][13][13];
      field517 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field378 = 0;
      field298 = 2;
      field347 = 0;
      field363 = 2;
      field349 = 0;
      field350 = 1;
      field404 = 0;
      mapScale = 0;
      field353 = 2;
      mapScaleDelta = 0;
      field355 = 1;
      field356 = 0;
      field357 = 0;
      field374 = 2301979;
      field360 = 5063219;
      field407 = 3353893;
      field558 = 7759444;
      field507 = false;
      field364 = 0;
      field365 = 128;
      mapAngle = 0;
      field367 = 0;
      field473 = 0;
      field369 = 0;
      field370 = 0;
      field371 = 50;
      field372 = 0;
      field373 = false;
      field348 = 0;
      field530 = 0;
      field376 = 50;
      field377 = new int[field376];
      field354 = new int[field376];
      field379 = new int[field376];
      field380 = new int[field376];
      field381 = new int[field376];
      field345 = new int[field376];
      field383 = new int[field376];
      field384 = new String[field376];
      field385 = new int[104][104];
      field386 = 0;
      field387 = -1;
      field333 = -1;
      field320 = 0;
      field390 = 0;
      field389 = 0;
      field326 = 0;
      field393 = 0;
      field394 = 0;
      field395 = 0;
      field396 = 0;
      field295 = 0;
      field398 = 0;
      field399 = false;
      field428 = 0;
      field401 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field521 = 0;
      field405 = 0;
      field406 = new int[1000];
      field459 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field408 = new String[8];
      field409 = new boolean[8];
      field410 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field411 = -1;
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
      field429 = -1;
      field437 = -1;
      field431 = 0;
      field432 = 50;
      field497 = 0;
      field434 = null;
      field435 = false;
      field436 = -1;
      field299 = -1;
      field328 = null;
      field439 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field442 = 0;
      field443 = 0;
      field361 = null;
      energy = 0;
      weight = 0;
      field447 = 0;
      field315 = -1;
      field449 = false;
      field316 = false;
      field451 = false;
      field452 = null;
      field453 = null;
      field388 = null;
      field504 = 0;
      field456 = 0;
      field343 = null;
      field458 = false;
      field545 = -1;
      field526 = -1;
      field461 = false;
      field462 = -1;
      field445 = -1;
      field375 = false;
      field465 = 1;
      field466 = new int[32];
      field464 = 0;
      field468 = new int[32];
      field496 = 0;
      field470 = new int[32];
      field323 = 0;
      field472 = 0;
      field359 = 0;
      field555 = 0;
      field475 = 0;
      field476 = 0;
      field477 = 0;
      field539 = 0;
      field532 = new Deque();
      field290 = new Deque();
      field481 = new Deque();
      widgetFlags = new XHashTable(512);
      field483 = 0;
      field484 = -2;
      field485 = new boolean[100];
      field486 = new boolean[100];
      field487 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      field492 = 0;
      field503 = 0L;
      isResized = true;
      field495 = 765;
      field339 = 1;
      field346 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field498 = 0;
      field499 = 0;
      field500 = "";
      field460 = new long[100];
      field502 = 0;
      field391 = 0;
      field478 = new int[128];
      field505 = new int[128];
      field506 = -1L;
      field455 = null;
      field508 = null;
      field509 = -1;
      field510 = 0;
      field511 = new int[1000];
      field368 = new int[1000];
      field513 = new SpritePixels[1000];
      flagX = 0;
      flagY = 0;
      field516 = 0;
      field433 = 255;
      field541 = -1;
      field519 = false;
      field520 = 127;
      field518 = 127;
      field522 = 0;
      field523 = new int[50];
      field524 = new int[50];
      field327 = new int[50];
      field392 = new int[50];
      field527 = new class61[50];
      field528 = false;
      field351 = new boolean[5];
      field471 = new int[5];
      field493 = new int[5];
      field362 = new int[5];
      field533 = new int[5];
      field537 = 256;
      field448 = 205;
      field512 = 256;
      field344 = 320;
      field538 = 1;
      field536 = 32767;
      field540 = 1;
      field457 = 32767;
      field474 = 0;
      field543 = 0;
      camera2 = 0;
      camera3 = 0;
      scale = 0;
      friendCount = 0;
      field534 = 0;
      friends = new Friend[400];
      field463 = new class198();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field553 = new PlayerComposition();
      field554 = -1;
      field550 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field557 = -1L;
      field556 = -1L;
      field469 = new class10();
      field560 = new int[50];
      field561 = new int[50];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1247559991"
   )
   protected final void vmethod3058() {
      boolean var1 = class47.method976();
      if(var1 && field519 && class141.field2184 != null) {
         class141.field2184.method1251();
      }

      if(gameState == 10 || gameState == 20 || gameState == 30) {
         if(field503 != 0L && class169.method3276() > field503) {
            int var2 = isResized?2:1;
            class45.method942(var2);
         } else if(GameEngine.field2256) {
            class154.method3164();
         }
      }

      Dimension var11 = this.method3107();
      if(var11.width != class13.field198 || class11.field169 != var11.height || GameEngine.field2255) {
         class0.method0();
         field503 = class169.method3276() + 500L;
         GameEngine.field2255 = false;
      }

      boolean var3 = false;
      int var4;
      if(GameEngine.field2253) {
         GameEngine.field2253 = false;
         var3 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field485[var4] = true;
         }
      }

      if(var3) {
         class167.method3258();
      }

      if(gameState == 0) {
         var4 = class33.field744;
         String var5 = class33.field742;
         Color var6 = null;

         try {
            Graphics var7 = VertexNormal.canvas.getGraphics();
            if(null == class43.field1000) {
               class43.field1000 = new Font("Helvetica", 1, 13);
               KitDefinition.field1064 = VertexNormal.canvas.getFontMetrics(class43.field1000);
            }

            if(var3) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, GroundObject.field1652, VertexNormal.field1689);
            }

            if(var6 == null) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(null == class59.field1256) {
                  class59.field1256 = VertexNormal.canvas.createImage(304, 34);
               }

               Graphics var8 = class59.field1256.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, 3 * var4, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(2 + 3 * var4, 2, 300 - var4 * 3, 30);
               var8.setFont(class43.field1000);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - KitDefinition.field1064.stringWidth(var5)) / 2, 22);
               var7.drawImage(class59.field1256, GroundObject.field1652 / 2 - 152, VertexNormal.field1689 / 2 - 18, (ImageObserver)null);
            } catch (Exception var14) {
               int var9 = GroundObject.field1652 / 2 - 152;
               int var10 = VertexNormal.field1689 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(var9 + 2, 2 + var10, var4 * 3, 30);
               var7.setColor(Color.black);
               var7.drawRect(1 + var9, var10 + 1, 301, 31);
               var7.fillRect(2 + var9 + var4 * 3, 2 + var10, 300 - 3 * var4, 30);
               var7.setFont(class43.field1000);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - KitDefinition.field1064.stringWidth(var5)) / 2, 22 + var10);
            }
         } catch (Exception var15) {
            VertexNormal.canvas.repaint();
         }
      } else if(gameState == 5) {
         class38.method763(PlayerComposition.field2977, class52.field1149, MessageNode.field800, var3);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class38.method763(PlayerComposition.field2977, class52.field1149, MessageNode.field800, var3);
         } else if(gameState == 25) {
            if(field548 == 1) {
               if(field336 > field337) {
                  field337 = field336;
               }

               var4 = (field337 * 50 - field336 * 50) / field337;
               class20.method570("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field548 == 2) {
               if(field514 > field296) {
                  field296 = field514;
               }

               var4 = 50 + (field296 * 50 - field514 * 50) / field296;
               class20.method570("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class20.method570("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            XClanMember.method605();
         } else if(gameState == 40) {
            class20.method570("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class20.method570("Please wait...", false);
         }
      } else {
         class38.method763(PlayerComposition.field2977, class52.field1149, MessageNode.field800, var3);
      }

      Graphics var12;
      int var13;
      if(gameState == 30 && field492 == 0 && !var3) {
         try {
            var12 = VertexNormal.canvas.getGraphics();

            for(var13 = 0; var13 < field483; ++var13) {
               if(field486[var13]) {
                  Sequence.bufferProvider.drawSub(var12, widgetPositionX[var13], widgetPositionY[var13], widgetBoundsWidth[var13], widgetBoundsHeight[var13]);
                  field486[var13] = false;
               }
            }
         } catch (Exception var17) {
            VertexNormal.canvas.repaint();
         }
      } else if(gameState > 0) {
         try {
            var12 = VertexNormal.canvas.getGraphics();
            Sequence.bufferProvider.draw(var12, 0, 0);

            for(var13 = 0; var13 < field483; ++var13) {
               field486[var13] = false;
            }
         } catch (Exception var16) {
            VertexNormal.canvas.repaint();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "526392498"
   )
   static final void method361() {
      int[] var0 = class34.field773;

      int var1;
      for(var1 = 0; var1 < class34.field777; ++var1) {
         Player var2 = cachedPlayers[var0[var1]];
         if(null != var2 && var2.field884 > 0) {
            --var2.field884;
            if(var2.field884 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < field319; ++var1) {
         int var4 = field501[var1];
         NPC var3 = cachedNPCs[var4];
         if(null != var3 && var3.field884 > 0) {
            --var3.field884;
            if(var3.field884 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "1387133660"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field1005.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         class170 var3 = Sequence.field1028;
         class170 var4 = Sequence.field1020;
         boolean var5 = true;
         int[] var6 = var3.method3289(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3286(var0, var6[var7]);
            if(null == var8) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3286(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            Sequence.field1005.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1478774694"
   )
   protected final void vmethod3063() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)LSpritePixels;",
      garbageValue = "421077574"
   )
   public static SpritePixels method428(class170 var0, int var1, int var2) {
      return !XClanMember.method604(var0, var1, var2)?null:class93.method2156();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1685336898"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.method235();

      while(true) {
         Deque var2 = class173.field2759;
         class172 var1;
         synchronized(class173.field2759) {
            var1 = (class172)class173.field2755.method3860();
         }

         if(null == var1) {
            int var25;
            try {
               if(class186.field3007 == 1) {
                  var25 = class186.field3008.method3640();
                  if(var25 > 0 && class186.field3008.method3646()) {
                     var25 -= class165.field2689;
                     if(var25 < 0) {
                        var25 = 0;
                     }

                     class186.field3008.method3639(var25);
                  } else {
                     class186.field3008.method3735();
                     class186.field3008.method3721();
                     if(null != class133.field2114) {
                        class186.field3007 = 2;
                     } else {
                        class186.field3007 = 0;
                     }

                     class218.field3209 = null;
                     class117.field2031 = null;
                  }
               }
            } catch (Exception var54) {
               var54.printStackTrace();
               class186.field3008.method3735();
               class186.field3007 = 0;
               class218.field3209 = null;
               class117.field2031 = null;
               class133.field2114 = null;
            }

            class110.method2445();
            class140 var55 = class140.keyboard;
            int var26;
            synchronized(class140.keyboard) {
               ++class140.keyboardIdleTicks;
               class140.field2173 = class140.field2167;
               class140.field2170 = 0;
               if(class140.field2166 >= 0) {
                  while(class140.field2166 != class140.field2160) {
                     var26 = class140.field2164[class140.field2160];
                     class140.field2160 = 1 + class140.field2160 & 127;
                     if(var26 < 0) {
                        class140.field2163[~var26] = false;
                     } else {
                        if(!class140.field2163[var26] && class140.field2170 < class140.field2169.length - 1) {
                           class140.field2169[++class140.field2170 - 1] = var26;
                        }

                        class140.field2163[var26] = true;
                     }
                  }
               } else {
                  for(var26 = 0; var26 < 112; ++var26) {
                     class140.field2163[var26] = false;
                  }

                  class140.field2166 = class140.field2160;
               }

               class140.field2167 = class140.field2177;
            }

            class143 var56 = class143.mouse;
            synchronized(class143.mouse) {
               class143.field2199 = class143.field2211;
               class143.field2200 = class143.field2197;
               class143.field2204 = class143.field2198;
               class143.field2206 = class143.field2202;
               class143.field2207 = class143.field2203;
               class143.field2196 = class143.field2208;
               class143.field2209 = class143.field2201;
               class143.field2202 = 0;
            }

            if(class13.field201 != null) {
               var25 = class13.field201.vmethod3133();
               field539 = var25;
            }

            if(gameState == 0) {
               class127.method2849();
               class132.method2876();
            } else if(gameState == 5) {
               Projectile.method96(this);
               class127.method2849();
               class132.method2876();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  Projectile.method96(this);
                  class184.method3560();
               } else if(gameState == 25) {
                  class8.method111();
               }
            } else {
               Projectile.method96(this);
            }

            if(gameState == 30) {
               if(field304 > 1) {
                  --field304;
               }

               if(field397 > 0) {
                  --field397;
               }

               if(field335) {
                  field335 = false;
                  class48.method1004();
               } else {
                  if(!isMenuOpen) {
                     menuOptions[0] = "Cancel";
                     menuTargets[0] = "";
                     menuTypes[0] = 1006;
                     menuOptionCount = 1;
                  }

                  String var4;
                  int var8;
                  int var9;
                  int var11;
                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  Widget var66;
                  int var70;
                  int var82;
                  int var91;
                  long var100;
                  boolean var102;
                  for(var25 = 0; var25 < 100; ++var25) {
                     boolean var97;
                     if(null == class28.field671) {
                        var97 = false;
                     } else {
                        label3361: {
                           try {
                              var27 = class28.field671.method3022();
                              if(var27 == 0) {
                                 var97 = false;
                                 break label3361;
                              }

                              if(packetOpcode == -1) {
                                 class28.field671.method3024(field314.payload, 0, 1);
                                 field314.offset = 0;
                                 packetOpcode = field314.method2820();
                                 field276 = class191.field3098[packetOpcode];
                                 --var27;
                              }

                              if(field276 == -1) {
                                 if(var27 <= 0) {
                                    var97 = false;
                                    break label3361;
                                 }

                                 class28.field671.method3024(field314.payload, 0, 1);
                                 field276 = field314.payload[0] & 255;
                                 --var27;
                              }

                              if(field276 == -2) {
                                 if(var27 <= 1) {
                                    var97 = false;
                                    break label3361;
                                 }

                                 class28.field671.method3024(field314.payload, 0, 2);
                                 field314.offset = 0;
                                 field276 = field314.method2691();
                                 var27 -= 2;
                              }

                              if(var27 < field276) {
                                 var97 = false;
                                 break label3361;
                              }

                              field314.offset = 0;
                              class28.field671.method3024(field314.payload, 0, field276);
                              field329 = 0;
                              field430 = field332;
                              field332 = field331 * -1;
                              field331 = packetOpcode * -1;
                              if(packetOpcode == 8) {
                                 for(var28 = 0; var28 < class56.field1222; ++var28) {
                                    class56 var75 = class26.method606(var28);
                                    if(var75 != null) {
                                       class179.settings[var28] = 0;
                                       class179.widgetSettings[var28] = 0;
                                    }
                                 }

                                 class10.method122();
                                 field464 += 32;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              boolean var120;
                              if(packetOpcode == 178) {
                                 var120 = field314.method2571() == 1;
                                 if(var120) {
                                    class184.field2990 = class169.method3276() - field314.method2704();
                                    Tile.field1816 = new class224(field314, true);
                                 } else {
                                    Tile.field1816 = null;
                                 }

                                 field476 = field465;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 16) {
                                 ItemComposition.method1163(field314.method2579());
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              Widget var77;
                              if(packetOpcode == 108) {
                                 var28 = field314.method2586();
                                 var29 = field314.method2618();
                                 var77 = class144.method3012(var29);
                                 if(var77 != null && var77.type == 0) {
                                    if(var28 > var77.scrollHeight - var77.height) {
                                       var28 = var77.scrollHeight - var77.height;
                                    }

                                    if(var28 < 0) {
                                       var28 = 0;
                                    }

                                    if(var28 != var77.scrollY) {
                                       var77.scrollY = var28;
                                       class166.method3253(var77);
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 120) {
                                 field314.offset += 28;
                                 if(field314.method2594()) {
                                    GameObject.method2270(field314, field314.offset - 28);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 190) {
                                 class10.method122();
                                 energy = field314.method2571();
                                 field477 = field465;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 155) {
                                 class16.method171();
                                 packetOpcode = -1;
                                 var97 = false;
                                 break label3361;
                              }

                              if(packetOpcode == 17) {
                                 var28 = field314.method2576();
                                 class5.field94 = Item.field699.method2919(var28);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 112) {
                                 var28 = field314.method2576();
                                 var29 = field314.method2691();
                                 if(var28 < -70000) {
                                    var29 += '耀';
                                 }

                                 if(var28 >= 0) {
                                    var77 = class144.method3012(var28);
                                 } else {
                                    var77 = null;
                                 }

                                 if(var77 != null) {
                                    for(var70 = 0; var70 < var77.itemIds.length; ++var70) {
                                       var77.itemIds[var70] = 0;
                                       var77.itemQuantities[var70] = 0;
                                    }
                                 }

                                 class220.method3996(var29);
                                 var70 = field314.method2691();

                                 for(var8 = 0; var8 < var70; ++var8) {
                                    var9 = field314.method2608();
                                    var82 = field314.method2598();
                                    if(var82 == 255) {
                                       var82 = field314.method2616();
                                    }

                                    if(var77 != null && var8 < var77.itemIds.length) {
                                       var77.itemIds[var8] = var9;
                                       var77.itemQuantities[var8] = var82;
                                    }

                                    class9.method117(var29, var8, var9 - 1, var82);
                                 }

                                 if(var77 != null) {
                                    class166.method3253(var77);
                                 }

                                 class10.method122();
                                 field468[++field496 - 1 & 31] = var29 & 32767;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 32) {
                                 World var73 = new World();
                                 var73.address = field314.method2579();
                                 var73.id = field314.method2691();
                                 var29 = field314.method2576();
                                 var73.mask = var29;
                                 class127.setGameState(45);
                                 class28.field671.method3020();
                                 class28.field671 = null;
                                 class125.selectWorld(var73);
                                 packetOpcode = -1;
                                 var97 = false;
                                 break label3361;
                              }

                              if(packetOpcode == 173) {
                                 var28 = field314.method2616();
                                 var102 = field314.method2571() == 1;
                                 var77 = class144.method3012(var28);
                                 if(var102 != var77.isHidden) {
                                    var77.isHidden = var102;
                                    class166.method3253(var77);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              long var93;
                              WidgetNode var108;
                              if(packetOpcode == 38) {
                                 var28 = field314.offset + field276;
                                 var29 = field314.method2691();
                                 var30 = field314.method2691();
                                 if(widgetRoot != var29) {
                                    widgetRoot = var29;
                                    ObjectComposition.method874(widgetRoot, GroundObject.field1652, VertexNormal.field1689, false);
                                    ItemLayer.method2271(widgetRoot);
                                    class8.method112(widgetRoot);

                                    for(var70 = 0; var70 < 100; ++var70) {
                                       field485[var70] = true;
                                    }
                                 }

                                 WidgetNode var105;
                                 for(; var30-- > 0; var105.field58 = true) {
                                    var70 = field314.method2576();
                                    var8 = field314.method2691();
                                    var9 = field314.method2571();
                                    var105 = (WidgetNode)componentTable.method3828((long)var70);
                                    if(var105 != null && var105.id != var8) {
                                       class16.method175(var105, true);
                                       var105 = null;
                                    }

                                    if(var105 == null) {
                                       var105 = class179.method3480(var70, var8, var9);
                                    }
                                 }

                                 for(var108 = (WidgetNode)componentTable.method3825(); var108 != null; var108 = (WidgetNode)componentTable.method3826()) {
                                    if(var108.field58) {
                                       var108.field58 = false;
                                    } else {
                                       class16.method175(var108, true);
                                    }
                                 }

                                 widgetFlags = new XHashTable(512);

                                 while(field314.offset < var28) {
                                    var70 = field314.method2576();
                                    var8 = field314.method2691();
                                    var9 = field314.method2691();
                                    var82 = field314.method2576();

                                    for(var11 = var8; var11 <= var9; ++var11) {
                                       var93 = ((long)var70 << 32) + (long)var11;
                                       widgetFlags.method3822(new class204(var82), var93);
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 252) {
                                 field498 = field314.method2571();
                                 field499 = field314.method2571();
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 4) {
                                 var28 = field314.method2617();
                                 var66 = class144.method3012(var28);
                                 var66.modelType = 3;
                                 var66.modelId = class165.localPlayer.composition.method3516();
                                 class166.method3253(var66);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              boolean var84;
                              if(packetOpcode == 167) {
                                 field555 = field465;
                                 if(field276 == 0) {
                                    field455 = null;
                                    field508 = null;
                                    class16.field235 = 0;
                                    class114.clanMembers = null;
                                    packetOpcode = -1;
                                    var97 = true;
                                    break label3361;
                                 }

                                 field508 = field314.method2579();
                                 long var131 = field314.method2704();
                                 field455 = class45.method951(var131);
                                 class134.field2116 = field314.method2572();
                                 var30 = field314.method2571();
                                 if(var30 == 255) {
                                    packetOpcode = -1;
                                    var97 = true;
                                    break label3361;
                                 }

                                 class16.field235 = var30;
                                 XClanMember[] var116 = new XClanMember[100];

                                 for(var8 = 0; var8 < class16.field235; ++var8) {
                                    var116[var8] = new XClanMember();
                                    var116[var8].username = field314.method2579();
                                    var116[var8].field625 = class112.method2486(var116[var8].username, class43.field996);
                                    var116[var8].world = field314.method2691();
                                    var116[var8].rank = field314.method2572();
                                    field314.method2579();
                                    if(var116[var8].username.equals(class165.localPlayer.name)) {
                                       class43.field991 = var116[var8].rank;
                                    }
                                 }

                                 var84 = false;
                                 var82 = class16.field235;

                                 while(var82 > 0) {
                                    var84 = true;
                                    --var82;

                                    for(var11 = 0; var11 < var82; ++var11) {
                                       if(var116[var11].field625.compareTo(var116[var11 + 1].field625) > 0) {
                                          XClanMember var118 = var116[var11];
                                          var116[var11] = var116[var11 + 1];
                                          var116[var11 + 1] = var118;
                                          var84 = false;
                                       }
                                    }

                                    if(var84) {
                                       break;
                                    }
                                 }

                                 class114.clanMembers = var116;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 124) {
                                 field528 = true;
                                 Actor.field887 = field314.method2571();
                                 XItemContainer.field217 = field314.method2571();
                                 ChatLineBuffer.field688 = field314.method2691();
                                 class180.field2958 = field314.method2571();
                                 class21.field576 = field314.method2571();
                                 if(class21.field576 >= 100) {
                                    class79.cameraX = Actor.field887 * 128 + 64;
                                    class170.cameraY = XItemContainer.field217 * 128 + 64;
                                    class10.cameraZ = class109.method2439(class79.cameraX, class170.cameraY, class145.plane) - ChatLineBuffer.field688;
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 62) {
                                 field534 = 1;
                                 field359 = field465;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 106) {
                                 field528 = false;

                                 for(var28 = 0; var28 < 5; ++var28) {
                                    field351[var28] = false;
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 47) {
                                 class10.xteaChanged(false);
                                 field314.method2820();
                                 var28 = field314.method2691();
                                 class28.method660(field314, var28);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              long var80;
                              if(packetOpcode == 207) {
                                 var28 = field314.method2586();
                                 if(var28 == '\uffff') {
                                    var28 = -1;
                                 }

                                 var29 = field314.method2576();
                                 var30 = field314.method2691();
                                 if(var30 == '\uffff') {
                                    var30 = -1;
                                 }

                                 var70 = field314.method2618();

                                 for(var8 = var28; var8 <= var30; ++var8) {
                                    var80 = ((long)var70 << 32) + (long)var8;
                                    Node var114 = widgetFlags.method3828(var80);
                                    if(null != var114) {
                                       var114.unlink();
                                    }

                                    widgetFlags.method3822(new class204(var29), var80);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 147) {
                                 flagX = field314.method2571();
                                 if(flagX == 255) {
                                    flagX = 0;
                                 }

                                 flagY = field314.method2571();
                                 if(flagY == 255) {
                                    flagY = 0;
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 229) {
                                 class34.field777 = 0;

                                 for(var28 = 0; var28 < 2048; ++var28) {
                                    class34.field771[var28] = null;
                                    class34.field770[var28] = 1;
                                 }

                                 for(var28 = 0; var28 < 2048; ++var28) {
                                    cachedPlayers[var28] = null;
                                 }

                                 ItemComposition.method1162(field314);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 98) {
                                 class146.field2240 = field314.method2598();
                                 class138.field2142 = field314.method2599();

                                 while(field314.offset < field276) {
                                    packetOpcode = field314.method2571();
                                    class53.method1091();
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 253) {
                                 byte var130 = field314.method2762();
                                 var29 = field314.method2608();
                                 class179.settings[var29] = var130;
                                 if(var130 != class179.widgetSettings[var29]) {
                                    class179.widgetSettings[var29] = var130;
                                 }

                                 class10.method119(var29);
                                 field466[++field464 - 1 & 31] = var29;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 10) {
                                 field304 = field314.method2691() * 30;
                                 field477 = field465;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 84) {
                                 field516 = field314.method2571();
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 208) {
                                 class10.method122();
                                 var28 = field314.method2619();
                                 var29 = field314.method2599();
                                 var30 = field314.method2576();
                                 skillExperiences[var29] = var30;
                                 boostedSkillLevels[var29] = var28;
                                 realSkillLevels[var29] = 1;

                                 for(var70 = 0; var70 < 98; ++var70) {
                                    if(var30 >= class158.field2335[var70]) {
                                       realSkillLevels[var29] = 2 + var70;
                                    }
                                 }

                                 field470[++field323 - 1 & 31] = var29;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 145) {
                                 var28 = field314.method2609();
                                 var29 = field314.method2617();
                                 var77 = class144.method3012(var29);
                                 if(var77.field2845 != var28 || var28 == -1) {
                                    var77.field2845 = var28;
                                    var77.field2920 = 0;
                                    var77.field2873 = 0;
                                    class166.method3253(var77);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              long var7;
                              int var15;
                              boolean var94;
                              if(packetOpcode == 9) {
                                 var4 = field314.method2579();
                                 var100 = field314.method2704();
                                 var7 = (long)field314.method2691();
                                 var80 = (long)field314.method2575();
                                 class155 var34 = (class155)class77.method1656(World.method657(), field314.method2571());
                                 var93 = var80 + (var7 << 32);
                                 var94 = false;

                                 for(var15 = 0; var15 < 100; ++var15) {
                                    if(field460[var15] == var93) {
                                       var94 = true;
                                       break;
                                    }
                                 }

                                 if(var34.field2305 && class187.method3736(var4)) {
                                    var94 = true;
                                 }

                                 if(!var94 && field401 == 0) {
                                    field460[field502] = var93;
                                    field502 = (1 + field502) % 100;
                                    String var121 = class226.method4060(Actor.method791(class143.method2981(field314)));
                                    if(var34.field2302 != -1) {
                                       class116.addChatMessage(9, class154.method3165(var34.field2302) + var4, var121, NPCComposition.method831(var100));
                                    } else {
                                       class116.addChatMessage(9, var4, var121, NPCComposition.method831(var100));
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 54) {
                                 if(widgetRoot != -1) {
                                    class158.method3191(widgetRoot, 0);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 119) {
                                 var28 = field314.method2571();
                                 var29 = field314.method2571();
                                 var30 = field314.method2571();
                                 var70 = field314.method2571();
                                 field351[var28] = true;
                                 field471[var28] = var29;
                                 field493[var28] = var30;
                                 field362[var28] = var70;
                                 field533[var28] = 0;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              Widget var106;
                              if(packetOpcode == 211) {
                                 var28 = field314.method2617();
                                 var29 = field314.method2608();
                                 if(var29 == '\uffff') {
                                    var29 = -1;
                                 }

                                 var30 = field314.method2576();
                                 var106 = class144.method3012(var28);
                                 ItemComposition var128;
                                 if(!var106.field2815) {
                                    if(var29 == -1) {
                                       var106.modelType = 0;
                                       packetOpcode = -1;
                                       var97 = true;
                                       break label3361;
                                    }

                                    var128 = class22.getItemDefinition(var29);
                                    var106.modelType = 4;
                                    var106.modelId = var29;
                                    var106.rotationX = var128.field1183;
                                    var106.rotationZ = var128.field1184;
                                    var106.field2852 = var128.field1182 * 100 / var30;
                                    class166.method3253(var106);
                                 } else {
                                    var106.item = var29;
                                    var106.stackSize = var30;
                                    var128 = class22.getItemDefinition(var29);
                                    var106.rotationX = var128.field1183;
                                    var106.rotationZ = var128.field1184;
                                    var106.rotationY = var128.field1201;
                                    var106.field2903 = var128.field1186;
                                    var106.field2848 = var128.field1187;
                                    var106.field2852 = var128.field1182;
                                    if(var128.isStackable == 1) {
                                       var106.field2810 = 1;
                                    } else {
                                       var106.field2810 = 2;
                                    }

                                    if(var106.field2853 > 0) {
                                       var106.field2852 = var106.field2852 * 32 / var106.field2853;
                                    } else if(var106.field2798 > 0) {
                                       var106.field2852 = var106.field2852 * 32 / var106.field2798;
                                    }

                                    class166.method3253(var106);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 66) {
                                 var28 = field314.method2586();
                                 var29 = field314.method2616();
                                 var30 = field314.method2608();
                                 var106 = class144.method3012(var29);
                                 var106.field2874 = (var28 << 16) + var30;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 179) {
                                 var28 = field314.method2606();
                                 XItemContainer var72 = (XItemContainer)XItemContainer.itemContainers.method3828((long)var28);
                                 if(null != var72) {
                                    var72.unlink();
                                 }

                                 field468[++field496 - 1 & 31] = var28 & 32767;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 113) {
                                 var28 = field314.method2691();
                                 var29 = field314.method2571();
                                 var30 = field314.method2691();
                                 class54.method1108(var28, var29, var30);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 129) {
                                 class138.field2142 = field314.method2571();
                                 class146.field2240 = field314.method2571();
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 204) {
                                 var28 = field314.method2616();
                                 var29 = field314.method2606();
                                 var77 = class144.method3012(var28);
                                 if(var77.modelType != 1 || var77.modelId != var29) {
                                    var77.modelType = 1;
                                    var77.modelId = var29;
                                    class166.method3253(var77);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 130) {
                                 var28 = field314.method2586();
                                 widgetRoot = var28;
                                 ObjectComposition.method874(widgetRoot, GroundObject.field1652, VertexNormal.field1689, false);
                                 ItemLayer.method2271(var28);
                                 class8.method112(widgetRoot);

                                 for(var29 = 0; var29 < 100; ++var29) {
                                    field485[var29] = true;
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              Widget var122;
                              if(packetOpcode == 12) {
                                 var28 = field314.method2618();
                                 var29 = field314.method2606();
                                 var30 = field314.method2608();
                                 var70 = field314.method2608();
                                 var122 = class144.method3012(var28);
                                 if(var30 != var122.rotationX || var70 != var122.rotationZ || var29 != var122.field2852) {
                                    var122.rotationX = var30;
                                    var122.rotationZ = var70;
                                    var122.field2852 = var29;
                                    class166.method3253(var122);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 243) {
                                 var29 = field314.method2571();
                                 class133[] var90 = new class133[]{class133.field2112, class133.field2110, class133.field2115};
                                 class133[] var111 = var90;
                                 var8 = 0;

                                 class133 var67;
                                 while(true) {
                                    if(var8 >= var111.length) {
                                       var67 = null;
                                       break;
                                    }

                                    class133 var117 = var111[var8];
                                    if(var117.field2113 == var29) {
                                       var67 = var117;
                                       break;
                                    }

                                    ++var8;
                                 }

                                 class160.field2635 = var67;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 214) {
                                 var4 = field314.method2579();
                                 Object[] var71 = new Object[var4.length() + 1];

                                 for(var30 = var4.length() - 1; var30 >= 0; --var30) {
                                    if(var4.charAt(var30) == 115) {
                                       var71[1 + var30] = field314.method2579();
                                    } else {
                                       var71[var30 + 1] = new Integer(field314.method2576());
                                    }
                                 }

                                 var71[0] = new Integer(field314.method2576());
                                 class0 var88 = new class0();
                                 var88.field0 = var71;
                                 SecondaryBufferProvider.method1661(var88);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 174) {
                                 class138.field2142 = field314.method2598();
                                 class146.field2240 = field314.method2599();

                                 for(var28 = class146.field2240; var28 < 8 + class146.field2240; ++var28) {
                                    for(var29 = class138.field2142; var29 < class138.field2142 + 8; ++var29) {
                                       if(groundItemDeque[class145.plane][var28][var29] != null) {
                                          groundItemDeque[class145.plane][var28][var29] = null;
                                          BufferProvider.groundItemSpawned(var28, var29);
                                       }
                                    }
                                 }

                                 for(class16 var65 = (class16)field413.method3864(); var65 != null; var65 = (class16)field413.method3851()) {
                                    if(var65.field228 >= class146.field2240 && var65.field228 < 8 + class146.field2240 && var65.field225 >= class138.field2142 && var65.field225 < 8 + class138.field2142 && class145.plane == var65.field226) {
                                       var65.field234 = 0;
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              String var6;
                              if(packetOpcode == 222) {
                                 while(field314.offset < field276) {
                                    var28 = field314.method2571();
                                    var102 = (var28 & 1) == 1;
                                    var6 = field314.method2579();
                                    String var109 = field314.method2579();
                                    field314.method2579();

                                    for(var8 = 0; var8 < ignoreCount; ++var8) {
                                       Ignore var115 = ignores[var8];
                                       if(var102) {
                                          if(var109.equals(var115.name)) {
                                             var115.name = var6;
                                             var115.previousName = var109;
                                             var6 = null;
                                             break;
                                          }
                                       } else if(var6.equals(var115.name)) {
                                          var115.name = var6;
                                          var115.previousName = var109;
                                          var6 = null;
                                          break;
                                       }
                                    }

                                    if(var6 != null && ignoreCount < 400) {
                                       Ignore var127 = new Ignore();
                                       ignores[ignoreCount] = var127;
                                       var127.name = var6;
                                       var127.previousName = var109;
                                       ++ignoreCount;
                                    }
                                 }

                                 field359 = field465;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 26) {
                                 var28 = field314.method2586();
                                 var29 = field314.method2618();
                                 var30 = field314.method2599();
                                 var108 = (WidgetNode)componentTable.method3828((long)var29);
                                 if(var108 != null) {
                                    class16.method175(var108, var28 != var108.id);
                                 }

                                 class179.method3480(var29, var28, var30);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 251) {
                                 field278 = field314.method2571();
                                 if(field278 == 1) {
                                    field427 = field314.method2691();
                                 }

                                 if(field278 >= 2 && field278 <= 6) {
                                    if(field278 == 2) {
                                       field302 = 64;
                                       field303 = 64;
                                    }

                                    if(field278 == 3) {
                                       field302 = 0;
                                       field303 = 64;
                                    }

                                    if(field278 == 4) {
                                       field302 = 128;
                                       field303 = 64;
                                    }

                                    if(field278 == 5) {
                                       field302 = 64;
                                       field303 = 0;
                                    }

                                    if(field278 == 6) {
                                       field302 = 64;
                                       field303 = 128;
                                    }

                                    field278 = 2;
                                    field525 = field314.method2691();
                                    field300 = field314.method2691();
                                    field301 = field314.method2571();
                                 }

                                 if(field278 == 10) {
                                    field467 = field314.method2691();
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 42) {
                                 var28 = field314.method2691();
                                 var29 = field314.method2576();
                                 class179.settings[var28] = var29;
                                 if(var29 != class179.widgetSettings[var28]) {
                                    class179.widgetSettings[var28] = var29;
                                 }

                                 class10.method119(var28);
                                 field466[++field464 - 1 & 31] = var28;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              boolean var74;
                              if(packetOpcode == 161) {
                                 var4 = field314.method2579();
                                 var29 = field314.method2691();
                                 byte var107 = field314.method2572();
                                 var74 = false;
                                 if(var107 == -128) {
                                    var74 = true;
                                 }

                                 if(var74) {
                                    if(class16.field235 == 0) {
                                       packetOpcode = -1;
                                       var97 = true;
                                       break label3361;
                                    }

                                    var84 = false;

                                    for(var8 = 0; var8 < class16.field235 && (!class114.clanMembers[var8].username.equals(var4) || var29 != class114.clanMembers[var8].world); ++var8) {
                                       ;
                                    }

                                    if(var8 < class16.field235) {
                                       while(var8 < class16.field235 - 1) {
                                          class114.clanMembers[var8] = class114.clanMembers[1 + var8];
                                          ++var8;
                                       }

                                       --class16.field235;
                                       class114.clanMembers[class16.field235] = null;
                                    }
                                 } else {
                                    field314.method2579();
                                    XClanMember var124 = new XClanMember();
                                    var124.username = var4;
                                    var124.field625 = class112.method2486(var124.username, class43.field996);
                                    var124.world = var29;
                                    var124.rank = var107;

                                    for(var9 = class16.field235 - 1; var9 >= 0; --var9) {
                                       var82 = class114.clanMembers[var9].field625.compareTo(var124.field625);
                                       if(var82 == 0) {
                                          class114.clanMembers[var9].world = var29;
                                          class114.clanMembers[var9].rank = var107;
                                          if(var4.equals(class165.localPlayer.name)) {
                                             class43.field991 = var107;
                                          }

                                          field555 = field465;
                                          packetOpcode = -1;
                                          var97 = true;
                                          break label3361;
                                       }

                                       if(var82 < 0) {
                                          break;
                                       }
                                    }

                                    if(class16.field235 >= class114.clanMembers.length) {
                                       packetOpcode = -1;
                                       var97 = true;
                                       break label3361;
                                    }

                                    for(var82 = class16.field235 - 1; var82 > var9; --var82) {
                                       class114.clanMembers[1 + var82] = class114.clanMembers[var82];
                                    }

                                    if(class16.field235 == 0) {
                                       class114.clanMembers = new XClanMember[100];
                                    }

                                    class114.clanMembers[var9 + 1] = var124;
                                    ++class16.field235;
                                    if(var4.equals(class165.localPlayer.name)) {
                                       class43.field991 = var107;
                                    }
                                 }

                                 field555 = field465;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 104) {
                                 XItemContainer.method157(true);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 91) {
                                 var28 = field314.method2691();
                                 var29 = field314.method2617();
                                 var30 = var28 >> 10 & 31;
                                 var70 = var28 >> 5 & 31;
                                 var8 = var28 & 31;
                                 var9 = (var8 << 3) + (var70 << 11) + (var30 << 19);
                                 Widget var104 = class144.method3012(var29);
                                 if(var9 != var104.textColor) {
                                    var104.textColor = var9;
                                    class166.method3253(var104);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              String var5;
                              if(packetOpcode == 153) {
                                 while(field314.offset < field276) {
                                    var120 = field314.method2571() == 1;
                                    var5 = field314.method2579();
                                    var6 = field314.method2579();
                                    var70 = field314.method2691();
                                    var8 = field314.method2571();
                                    var9 = field314.method2571();
                                    boolean var85 = (var9 & 2) != 0;
                                    boolean var89 = (var9 & 1) != 0;
                                    if(var70 > 0) {
                                       field314.method2579();
                                       field314.method2571();
                                       field314.method2576();
                                    }

                                    field314.method2579();

                                    for(var91 = 0; var91 < friendCount; ++var91) {
                                       Friend var92 = friends[var91];
                                       if(!var120) {
                                          if(var5.equals(var92.name)) {
                                             if(var70 != var92.world) {
                                                var94 = true;

                                                for(class40 var119 = (class40)field463.method3810(); var119 != null; var119 = (class40)field463.method3811()) {
                                                   if(var119.field891.equals(var5)) {
                                                      if(var70 != 0 && var119.field890 == 0) {
                                                         var119.method3945();
                                                         var94 = false;
                                                      } else if(var70 == 0 && var119.field890 != 0) {
                                                         var119.method3945();
                                                         var94 = false;
                                                      }
                                                   }
                                                }

                                                if(var94) {
                                                   field463.method3816(new class40(var5, var70));
                                                }

                                                var92.world = var70;
                                             }

                                             var92.previousName = var6;
                                             var92.rank = var8;
                                             var92.field246 = var85;
                                             var92.field249 = var89;
                                             var5 = null;
                                             break;
                                          }
                                       } else if(var6.equals(var92.name)) {
                                          var92.name = var5;
                                          var92.previousName = var6;
                                          var5 = null;
                                          break;
                                       }
                                    }

                                    if(var5 != null && friendCount < 400) {
                                       Friend var125 = new Friend();
                                       friends[friendCount] = var125;
                                       var125.name = var5;
                                       var125.previousName = var6;
                                       var125.world = var70;
                                       var125.rank = var8;
                                       var125.field246 = var85;
                                       var125.field249 = var89;
                                       ++friendCount;
                                    }
                                 }

                                 field534 = 2;
                                 field359 = field465;
                                 var120 = false;
                                 var29 = friendCount;

                                 while(var29 > 0) {
                                    var120 = true;
                                    --var29;

                                    for(var30 = 0; var30 < var29; ++var30) {
                                       var74 = false;
                                       Friend var123 = friends[var30];
                                       Friend var113 = friends[var30 + 1];
                                       if(var123.world != world && var113.world == world) {
                                          var74 = true;
                                       }

                                       if(!var74 && var123.world == 0 && var113.world != 0) {
                                          var74 = true;
                                       }

                                       if(!var74 && !var123.field246 && var113.field246) {
                                          var74 = true;
                                       }

                                       if(!var74 && !var123.field249 && var113.field249) {
                                          var74 = true;
                                       }

                                       if(var74) {
                                          Friend var103 = friends[var30];
                                          friends[var30] = friends[var30 + 1];
                                          friends[var30 + 1] = var103;
                                          var120 = false;
                                       }
                                    }

                                    if(var120) {
                                       break;
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 121) {
                                 var28 = field314.method2608();
                                 if(var28 == '\uffff') {
                                    var28 = -1;
                                 }

                                 if(var28 == -1 && !field519) {
                                    class186.field3008.method3735();
                                    class186.field3007 = 1;
                                    class133.field2114 = null;
                                 } else if(var28 != -1 && field541 != var28 && field433 != 0 && !field519) {
                                    class162.method3196(2, field423, var28, 0, field433, false);
                                 }

                                 field541 = var28;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 247) {
                                 var28 = field314.method2645();
                                 var29 = field314.method2606();
                                 if(var29 == '\uffff') {
                                    var29 = -1;
                                 }

                                 if(field433 != 0 && var29 != -1) {
                                    class140.method2961(class9.field151, var29, 0, field433, false);
                                    field519 = true;
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 170) {
                                 var28 = field314.method2616();
                                 var66 = class144.method3012(var28);

                                 for(var30 = 0; var30 < var66.itemIds.length; ++var30) {
                                    var66.itemIds[var30] = -1;
                                    var66.itemIds[var30] = 0;
                                 }

                                 class166.method3253(var66);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 235) {
                                 class10.method122();
                                 weight = field314.method2574();
                                 field477 = field465;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 65) {
                                 XItemContainer.method157(false);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 11) {
                                 var28 = field314.method2576();
                                 WidgetNode var64 = (WidgetNode)componentTable.method3828((long)var28);
                                 if(null != var64) {
                                    class16.method175(var64, true);
                                 }

                                 if(field361 != null) {
                                    class166.method3253(field361);
                                    field361 = null;
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 158) {
                                 var28 = field314.method2618();
                                 var29 = field314.method2576();
                                 WidgetNode var86 = (WidgetNode)componentTable.method3828((long)var28);
                                 var108 = (WidgetNode)componentTable.method3828((long)var29);
                                 if(var108 != null) {
                                    class16.method175(var108, var86 == null || var108.id != var86.id);
                                 }

                                 if(var86 != null) {
                                    var86.unlink();
                                    componentTable.method3822(var86, (long)var29);
                                 }

                                 var122 = class144.method3012(var28);
                                 if(null != var122) {
                                    class166.method3253(var122);
                                 }

                                 var122 = class144.method3012(var29);
                                 if(var122 != null) {
                                    class166.method3253(var122);
                                    Projectile.method93(Widget.widgets[var122.id >>> 16], var122, true);
                                 }

                                 if(widgetRoot != -1) {
                                    class158.method3191(widgetRoot, 1);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 37) {
                                 var28 = field314.method2576();
                                 var29 = field314.method2691();
                                 if(var28 < -70000) {
                                    var29 += '耀';
                                 }

                                 if(var28 >= 0) {
                                    var77 = class144.method3012(var28);
                                 } else {
                                    var77 = null;
                                 }

                                 for(; field314.offset < field276; class9.method117(var29, var70, var8 - 1, var9)) {
                                    var70 = field314.method2554();
                                    var8 = field314.method2691();
                                    var9 = 0;
                                    if(var8 != 0) {
                                       var9 = field314.method2571();
                                       if(var9 == 255) {
                                          var9 = field314.method2576();
                                       }
                                    }

                                    if(null != var77 && var70 >= 0 && var70 < var77.itemIds.length) {
                                       var77.itemIds[var70] = var8;
                                       var77.itemQuantities[var70] = var9;
                                    }
                                 }

                                 if(var77 != null) {
                                    class166.method3253(var77);
                                 }

                                 class10.method122();
                                 field468[++field496 - 1 & 31] = var29 & 32767;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 71) {
                                 var28 = field314.method2617();
                                 var29 = field314.method2691();
                                 var77 = class144.method3012(var28);
                                 if(var77.modelType != 2 || var77.modelId != var29) {
                                    var77.modelType = 2;
                                    var77.modelId = var29;
                                    class166.method3253(var77);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 74) {
                                 var28 = field314.method2617();
                                 var29 = field314.method2595();
                                 var30 = field314.method2611();
                                 var106 = class144.method3012(var28);
                                 if(var30 != var106.field2807 || var29 != var106.field2808 || var106.field2803 != 0 || var106.field2804 != 0) {
                                    var106.field2807 = var30;
                                    var106.field2808 = var29;
                                    var106.field2803 = 0;
                                    var106.field2804 = 0;
                                    class166.method3253(var106);
                                    class11.method127(var106);
                                    if(var106.type == 0) {
                                       Projectile.method93(Widget.widgets[var28 >> 16], var106, false);
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 160) {
                                 var28 = field314.method2616();
                                 var5 = field314.method2579();
                                 var77 = class144.method3012(var28);
                                 if(!var5.equals(var77.text)) {
                                    var77.text = var5;
                                    class166.method3253(var77);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 255) {
                                 var28 = field314.method2554();
                                 var102 = field314.method2571() == 1;
                                 var6 = "";
                                 var74 = false;
                                 if(var102) {
                                    var6 = field314.method2579();
                                    if(class187.method3736(var6)) {
                                       var74 = true;
                                    }
                                 }

                                 String var36 = field314.method2579();
                                 if(!var74) {
                                    Widget.sendGameMessage(var28, var6, var36);
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 188) {
                                 var28 = field314.method2576();
                                 var29 = field314.method2576();
                                 if(class14.field213 == null || !class14.field213.isValid()) {
                                    try {
                                       Iterator var69 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                                       while(var69.hasNext()) {
                                          GarbageCollectorMXBean var32 = (GarbageCollectorMXBean)var69.next();
                                          if(var32.isValid()) {
                                             class14.field213 = var32;
                                             field556 = -1L;
                                             field557 = -1L;
                                          }
                                       }
                                    } catch (Throwable var50) {
                                       ;
                                    }
                                 }

                                 long var101 = class169.method3276();
                                 var8 = -1;
                                 if(class14.field213 != null) {
                                    var80 = class14.field213.getCollectionTime();
                                    if(-1L != field557) {
                                       long var87 = var80 - field557;
                                       long var129 = var101 - field556;
                                       if(0L != var129) {
                                          var8 = (int)(var87 * 100L / var129);
                                       }
                                    }

                                    field557 = var80;
                                    field556 = var101;
                                 }

                                 field324.method2828(252);
                                 field324.method2556(var8);
                                 field324.method2596(GameEngine.FPS);
                                 field324.method2614(var28);
                                 field324.method2559(var29);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 55) {
                                 var4 = field314.method2579();
                                 var5 = class226.method4060(Actor.method791(class143.method2981(field314)));
                                 Widget.sendGameMessage(6, var4, var5);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 238) {
                                 var28 = field314.method2571();
                                 if(field314.method2571() == 0) {
                                    grandExchangeOffers[var28] = new XGrandExchangeOffer();
                                    field314.offset += 18;
                                 } else {
                                    --field314.offset;
                                    grandExchangeOffers[var28] = new XGrandExchangeOffer(field314, false);
                                 }

                                 field475 = field465;
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 14) {
                                 class28.method660(field314, field276);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              String var13;
                              int var38;
                              if(packetOpcode == 48) {
                                 class125 var63 = field314;
                                 var29 = field276;
                                 ClassInfo var68 = new ClassInfo();
                                 var68.field3178 = var63.method2571();
                                 var68.field3176 = var63.method2576();
                                 var68.field3172 = new int[var68.field3178];
                                 var68.field3173 = new int[var68.field3178];
                                 var68.fields = new Field[var68.field3178];
                                 var68.field3170 = new int[var68.field3178];
                                 var68.methods = new Method[var68.field3178];
                                 var68.args = new byte[var68.field3178][][];

                                 for(var70 = 0; var70 < var68.field3178; ++var70) {
                                    try {
                                       var8 = var63.method2571();
                                       String var31;
                                       String var110;
                                       if(var8 != 0 && var8 != 1 && var8 != 2) {
                                          if(var8 == 3 || var8 == 4) {
                                             var110 = var63.method2579();
                                             var31 = var63.method2579();
                                             var11 = var63.method2571();
                                             String[] var37 = new String[var11];

                                             for(var38 = 0; var38 < var11; ++var38) {
                                                var37[var38] = var63.method2579();
                                             }

                                             var13 = var63.method2579();
                                             byte[][] var39 = new byte[var11][];
                                             int var16;
                                             if(var8 == 3) {
                                                for(var15 = 0; var15 < var11; ++var15) {
                                                   var16 = var63.method2576();
                                                   var39[var15] = new byte[var16];
                                                   var63.method2582(var39[var15], 0, var16);
                                                }
                                             }

                                             var68.field3172[var70] = var8;
                                             Class[] var35 = new Class[var11];

                                             for(var16 = 0; var16 < var11; ++var16) {
                                                var35[var16] = class212.method3957(var37[var16]);
                                             }

                                             Class var40 = class212.method3957(var13);
                                             if(class212.method3957(var110).getClassLoader() == null) {
                                                throw new SecurityException();
                                             }

                                             Method[] var17 = class212.method3957(var110).getDeclaredMethods();
                                             Method[] var18 = var17;

                                             for(int var19 = 0; var19 < var18.length; ++var19) {
                                                Method var20 = var18[var19];
                                                if(var20.getName().equals(var31)) {
                                                   Class[] var21 = var20.getParameterTypes();
                                                   if(var35.length == var21.length) {
                                                      boolean var22 = true;

                                                      for(int var23 = 0; var23 < var35.length; ++var23) {
                                                         if(var35[var23] != var21[var23]) {
                                                            var22 = false;
                                                            break;
                                                         }
                                                      }

                                                      if(var22 && var40 == var20.getReturnType()) {
                                                         var68.methods[var70] = var20;
                                                      }
                                                   }
                                                }
                                             }

                                             var68.args[var70] = var39;
                                          }
                                       } else {
                                          var110 = var63.method2579();
                                          var31 = var63.method2579();
                                          var11 = 0;
                                          if(var8 == 1) {
                                             var11 = var63.method2576();
                                          }

                                          var68.field3172[var70] = var8;
                                          var68.field3170[var70] = var11;
                                          if(class212.method3957(var110).getClassLoader() == null) {
                                             throw new SecurityException();
                                          }

                                          var68.fields[var70] = class212.method3957(var110).getDeclaredField(var31);
                                       }
                                    } catch (ClassNotFoundException var45) {
                                       var68.field3173[var70] = -1;
                                    } catch (SecurityException var46) {
                                       var68.field3173[var70] = -2;
                                    } catch (NullPointerException var47) {
                                       var68.field3173[var70] = -3;
                                    } catch (Exception var48) {
                                       var68.field3173[var70] = -4;
                                    } catch (Throwable var49) {
                                       var68.field3173[var70] = -5;
                                    }
                                 }

                                 class214.field3183.method3884(var68);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 148) {
                                 field528 = true;
                                 class13.field196 = field314.method2571();
                                 class110.field1945 = field314.method2571();
                                 class26.field630 = field314.method2691();
                                 Sequence.field1024 = field314.method2571();
                                 FrameMap.field1827 = field314.method2571();
                                 if(FrameMap.field1827 >= 100) {
                                    var28 = 64 + class13.field196 * 128;
                                    var29 = class110.field1945 * 128 + 64;
                                    var30 = class109.method2439(var28, var29, class145.plane) - class26.field630;
                                    var70 = var28 - class79.cameraX;
                                    var8 = var30 - class10.cameraZ;
                                    var9 = var29 - class170.cameraY;
                                    var82 = (int)Math.sqrt((double)(var9 * var9 + var70 * var70));
                                    class116.cameraPitch = (int)(Math.atan2((double)var8, (double)var82) * 325.949D) & 2047;
                                    SecondaryBufferProvider.cameraYaw = (int)(Math.atan2((double)var70, (double)var9) * -325.949D) & 2047;
                                    if(class116.cameraPitch < 128) {
                                       class116.cameraPitch = 128;
                                    }

                                    if(class116.cameraPitch > 383) {
                                       class116.cameraPitch = 383;
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 234) {
                                 for(var28 = 0; var28 < class179.widgetSettings.length; ++var28) {
                                    if(class179.settings[var28] != class179.widgetSettings[var28]) {
                                       class179.widgetSettings[var28] = class179.settings[var28];
                                       class10.method119(var28);
                                       field466[++field464 - 1 & 31] = var28;
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 169) {
                                 var28 = field314.method2598();
                                 var29 = field314.method2599();
                                 var6 = field314.method2579();
                                 if(var29 >= 1 && var29 <= 8) {
                                    if(var6.equalsIgnoreCase("null")) {
                                       var6 = null;
                                    }

                                    field408[var29 - 1] = var6;
                                    field409[var29 - 1] = var28 == 0;
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 25 || packetOpcode == 209 || packetOpcode == 218 || packetOpcode == 88 || packetOpcode == 233 || packetOpcode == 242 || packetOpcode == 31 || packetOpcode == 189 || packetOpcode == 111 || packetOpcode == 35) {
                                 class53.method1091();
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 140) {
                                 class10.xteaChanged(true);
                                 field314.method2820();
                                 var28 = field314.method2691();
                                 class28.method660(field314, var28);
                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 78) {
                                 var4 = field314.method2579();
                                 var100 = (long)field314.method2691();
                                 var7 = (long)field314.method2575();
                                 class155 var33 = (class155)class77.method1656(World.method657(), field314.method2571());
                                 long var10 = var7 + (var100 << 32);
                                 boolean var12 = false;

                                 for(var38 = 0; var38 < 100; ++var38) {
                                    if(field460[var38] == var10) {
                                       var12 = true;
                                       break;
                                    }
                                 }

                                 if(class187.method3736(var4)) {
                                    var12 = true;
                                 }

                                 if(!var12 && field401 == 0) {
                                    field460[field502] = var10;
                                    field502 = (field502 + 1) % 100;
                                    var13 = class226.method4060(Actor.method791(class143.method2981(field314)));
                                    byte var14;
                                    if(var33.field2309) {
                                       var14 = 7;
                                    } else {
                                       var14 = 3;
                                    }

                                    if(var33.field2302 != -1) {
                                       Widget.sendGameMessage(var14, class154.method3165(var33.field2302) + var4, var13);
                                    } else {
                                       Widget.sendGameMessage(var14, var4, var13);
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              if(packetOpcode == 53) {
                                 for(var28 = 0; var28 < cachedPlayers.length; ++var28) {
                                    if(null != cachedPlayers[var28]) {
                                       cachedPlayers[var28].animation = -1;
                                    }
                                 }

                                 for(var28 = 0; var28 < cachedNPCs.length; ++var28) {
                                    if(null != cachedNPCs[var28]) {
                                       cachedNPCs[var28].animation = -1;
                                    }
                                 }

                                 packetOpcode = -1;
                                 var97 = true;
                                 break label3361;
                              }

                              RSCanvas.method2969("" + packetOpcode + "," + field332 + "," + field430 + "," + field276, (Throwable)null);
                              class16.method171();
                           } catch (IOException var51) {
                              class48.method1004();
                           } catch (Exception var52) {
                              var4 = "" + packetOpcode + "," + field332 + "," + field430 + "," + field276 + "," + (class165.localPlayer.pathX[0] + class47.baseX) + "," + (class165.localPlayer.pathY[0] + class21.baseY) + ",";

                              for(var29 = 0; var29 < field276 && var29 < 50; ++var29) {
                                 var4 = var4 + field314.payload[var29] + ",";
                              }

                              RSCanvas.method2969(var4, var52);
                              class16.method171();
                           }

                           var97 = true;
                        }
                     }

                     if(!var97) {
                        break;
                     }
                  }

                  if(gameState == 30) {
                     while(true) {
                        ClassInfo var58 = (ClassInfo)class214.field3183.method3893();
                        boolean var98;
                        if(null == var58) {
                           var98 = false;
                        } else {
                           var98 = true;
                        }

                        if(!var98) {
                           Object var57 = class161.field2639.field190;
                           synchronized(class161.field2639.field190) {
                              if(!field542) {
                                 class161.field2639.field191 = 0;
                              } else if(class143.field2206 != 0 || class161.field2639.field191 >= 40) {
                                 field324.method2828(239);
                                 field324.method2556(0);
                                 var26 = field324.offset;
                                 var27 = 0;

                                 for(var28 = 0; var28 < class161.field2639.field191 && field324.offset - var26 < 240; ++var28) {
                                    ++var27;
                                    var29 = class161.field2639.field193[var28];
                                    if(var29 < 0) {
                                       var29 = 0;
                                    } else if(var29 > 502) {
                                       var29 = 502;
                                    }

                                    var30 = class161.field2639.field192[var28];
                                    if(var30 < 0) {
                                       var30 = 0;
                                    } else if(var30 > 764) {
                                       var30 = 764;
                                    }

                                    var70 = var30 + var29 * 765;
                                    if(class161.field2639.field193[var28] == -1 && class161.field2639.field192[var28] == -1) {
                                       var30 = -1;
                                       var29 = -1;
                                       var70 = 524287;
                                    }

                                    if(field338 == var30 && var29 == field291) {
                                       if(field292 < 2047) {
                                          ++field292;
                                       }
                                    } else {
                                       var8 = var30 - field338;
                                       field338 = var30;
                                       var9 = var29 - field291;
                                       field291 = var29;
                                       if(field292 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                          var8 += 32;
                                          var9 += 32;
                                          field324.method2638(var9 + (field292 << 12) + (var8 << 6));
                                          field292 = 0;
                                       } else if(field292 < 8) {
                                          field324.method2558((field292 << 19) + 8388608 + var70);
                                          field292 = 0;
                                       } else {
                                          field324.method2559(var70 + (field292 << 19) + -1073741824);
                                          field292 = 0;
                                       }
                                    }
                                 }

                                 field324.method2568(field324.offset - var26);
                                 if(var27 >= class161.field2639.field191) {
                                    class161.field2639.field191 = 0;
                                 } else {
                                    class161.field2639.field191 -= var27;

                                    for(var28 = 0; var28 < class161.field2639.field191; ++var28) {
                                       class161.field2639.field192[var28] = class161.field2639.field192[var28 + var27];
                                       class161.field2639.field193[var28] = class161.field2639.field193[var27 + var28];
                                    }
                                 }
                              }
                           }

                           if(class143.field2206 == 1 || !class124.field2066 && class143.field2206 == 4 || class143.field2206 == 2) {
                              long var99 = (class143.field2209 - field289) / 50L;
                              if(var99 > 4095L) {
                                 var99 = 4095L;
                              }

                              field289 = class143.field2209;
                              var27 = class143.field2196;
                              if(var27 < 0) {
                                 var27 = 0;
                              } else if(var27 > VertexNormal.field1689) {
                                 var27 = VertexNormal.field1689;
                              }

                              var28 = class143.field2207;
                              if(var28 < 0) {
                                 var28 = 0;
                              } else if(var28 > GroundObject.field1652) {
                                 var28 = GroundObject.field1652;
                              }

                              var29 = (int)var99;
                              field324.method2828(175);
                              field324.method2638((class143.field2206 == 2?1:0) + (var29 << 1));
                              field324.method2638(var28);
                              field324.method2638(var27);
                           }

                           if(class140.field2170 > 0) {
                              field324.method2828(216);
                              field324.method2638(0);
                              var25 = field324.offset;
                              long var132 = class169.method3276();

                              for(var28 = 0; var28 < class140.field2170; ++var28) {
                                 var100 = var132 - field506;
                                 if(var100 > 16777215L) {
                                    var100 = 16777215L;
                                 }

                                 field506 = var132;
                                 field324.method2558((int)var100);
                                 field324.method2556(class140.field2169[var28]);
                              }

                              field324.method2754(field324.offset - var25);
                           }

                           if(field372 > 0) {
                              --field372;
                           }

                           if(class140.field2163[96] || class140.field2163[97] || class140.field2163[98] || class140.field2163[99]) {
                              field373 = true;
                           }

                           if(field373 && field372 <= 0) {
                              field372 = 20;
                              field373 = false;
                              field324.method2828(109);
                              field324.method2603(mapAngle);
                              field324.method2638(field365);
                           }

                           if(class107.field1854 && !field293) {
                              field293 = true;
                              field324.method2828(174);
                              field324.method2556(1);
                           }

                           if(!class107.field1854 && field293) {
                              field293 = false;
                              field324.method2828(174);
                              field324.method2556(0);
                           }

                           class92.method2152();
                           if(gameState == 30) {
                              DecorativeObject.method2238();

                              for(var25 = 0; var25 < field522; ++var25) {
                                 --field327[var25];
                                 if(field327[var25] >= -10) {
                                    class61 var60 = field527[var25];
                                    if(var60 == null) {
                                       Object var134 = null;
                                       var60 = class61.method1292(class13.field195, field523[var25], 0);
                                       if(null == var60) {
                                          continue;
                                       }

                                       field327[var25] += var60.method1285();
                                       field527[var25] = var60;
                                    }

                                    if(field327[var25] < 0) {
                                       if(field392[var25] != 0) {
                                          var28 = 128 * (field392[var25] & 255);
                                          var29 = field392[var25] >> 16 & 255;
                                          var30 = 64 + var29 * 128 - class165.localPlayer.x;
                                          if(var30 < 0) {
                                             var30 = -var30;
                                          }

                                          var70 = field392[var25] >> 8 & 255;
                                          var8 = 128 * var70 + 64 - class165.localPlayer.y;
                                          if(var8 < 0) {
                                             var8 = -var8;
                                          }

                                          var9 = var30 + var8 - 128;
                                          if(var9 > var28) {
                                             field327[var25] = -100;
                                             continue;
                                          }

                                          if(var9 < 0) {
                                             var9 = 0;
                                          }

                                          var27 = (var28 - var9) * field518 / var28;
                                       } else {
                                          var27 = field520;
                                       }

                                       if(var27 > 0) {
                                          class65 var76 = var60.method1284().method1322(class166.field2695);
                                          class67 var78 = class67.method1425(var76, 100, var27);
                                          var78.method1347(field524[var25] - 1);
                                          class112.field1970.method1176(var78);
                                       }

                                       field327[var25] = -100;
                                    }
                                 } else {
                                    --field522;

                                    for(var26 = var25; var26 < field522; ++var26) {
                                       field523[var26] = field523[var26 + 1];
                                       field527[var26] = field527[1 + var26];
                                       field524[var26] = field524[var26 + 1];
                                       field327[var26] = field327[1 + var26];
                                       field392[var26] = field392[var26 + 1];
                                    }

                                    --var25;
                                 }
                              }

                              if(field519 && !class109.method2442()) {
                                 if(field433 != 0 && field541 != -1) {
                                    class140.method2961(field423, field541, 0, field433, false);
                                 }

                                 field519 = false;
                              }

                              ++field329;
                              if(field329 > 750) {
                                 class48.method1004();
                              } else {
                                 class49.method1029();
                                 class16.method174();
                                 method361();
                                 ++field357;
                                 if(field326 != 0) {
                                    field389 += 20;
                                    if(field389 >= 400) {
                                       field326 = 0;
                                    }
                                 }

                                 if(class53.field1157 != null) {
                                    ++field393;
                                    if(field393 >= 15) {
                                       class166.method3253(class53.field1157);
                                       class53.field1157 = null;
                                    }
                                 }

                                 Widget var59 = Player.field31;
                                 Widget var61 = Actor.field885;
                                 Player.field31 = null;
                                 Actor.field885 = null;
                                 field343 = null;
                                 field461 = false;
                                 field458 = false;
                                 field391 = 0;

                                 while(true) {
                                    while(class0.method2() && field391 < 128) {
                                       if(field447 >= 2 && class140.field2163[82] && class13.field197 == 66) {
                                          var4 = "";

                                          MessageNode var95;
                                          for(Iterator var79 = class11.field167.iterator(); var79.hasNext(); var4 = var4 + var95.name + ':' + var95.value + '\n') {
                                             var95 = (MessageNode)var79.next();
                                          }

                                          class16.field237.setContents(new StringSelection(var4), (ClipboardOwner)null);
                                       } else {
                                          field505[field391] = class13.field197;
                                          field478[field391] = ItemLayer.field1744;
                                          ++field391;
                                       }
                                    }

                                    if(widgetRoot != -1) {
                                       var27 = widgetRoot;
                                       var28 = GroundObject.field1652;
                                       var29 = VertexNormal.field1689;
                                       if(class85.method1938(var27)) {
                                          class28.method659(Widget.widgets[var27], -1, 0, 0, var28, var29, 0, 0);
                                       }
                                    }

                                    ++field465;

                                    while(true) {
                                       class0 var3;
                                       Widget var81;
                                       do {
                                          var3 = (class0)field290.method3860();
                                          if(null == var3) {
                                             while(true) {
                                                do {
                                                   var3 = (class0)field481.method3860();
                                                   if(null == var3) {
                                                      while(true) {
                                                         do {
                                                            var3 = (class0)field532.method3860();
                                                            if(null == var3) {
                                                               class18.method188();
                                                               if(field453 != null) {
                                                                  class166.method3253(field453);
                                                                  ++Friend.field248;
                                                                  if(field461 && field458) {
                                                                     var27 = class143.field2200;
                                                                     var28 = class143.field2204;
                                                                     var27 -= field504;
                                                                     var28 -= field456;
                                                                     if(var27 < field545) {
                                                                        var27 = field545;
                                                                     }

                                                                     if(var27 + field453.width > field545 + field388.width) {
                                                                        var27 = field388.width + field545 - field453.width;
                                                                     }

                                                                     if(var28 < field526) {
                                                                        var28 = field526;
                                                                     }

                                                                     if(field453.height + var28 > field388.height + field526) {
                                                                        var28 = field388.height + field526 - field453.height;
                                                                     }

                                                                     var29 = var27 - field462;
                                                                     var30 = var28 - field445;
                                                                     var70 = field453.field2897;
                                                                     if(Friend.field248 > field453.field2875 && (var29 > var70 || var29 < -var70 || var30 > var70 || var30 < -var70)) {
                                                                        field375 = true;
                                                                     }

                                                                     var8 = var27 - field545 + field388.itemId;
                                                                     var9 = var28 - field526 + field388.scrollY;
                                                                     class0 var112;
                                                                     if(field453.field2887 != null && field375) {
                                                                        var112 = new class0();
                                                                        var112.field11 = field453;
                                                                        var112.field10 = var8;
                                                                        var112.field3 = var9;
                                                                        var112.field0 = field453.field2887;
                                                                        SecondaryBufferProvider.method1661(var112);
                                                                     }

                                                                     if(class143.field2199 == 0) {
                                                                        if(field375) {
                                                                           if(null != field453.field2921) {
                                                                              var112 = new class0();
                                                                              var112.field11 = field453;
                                                                              var112.field10 = var8;
                                                                              var112.field3 = var9;
                                                                              var112.field6 = field343;
                                                                              var112.field0 = field453.field2921;
                                                                              SecondaryBufferProvider.method1661(var112);
                                                                           }

                                                                           if(null != field343 && class21.method573(field453) != null) {
                                                                              field324.method2828(74);
                                                                              field324.method2638(field453.index);
                                                                              field324.method2605(field453.item);
                                                                              field324.method2756(field343.index);
                                                                              field324.method2605(field343.item);
                                                                              field324.method2613(field343.id);
                                                                              field324.method2614(field453.id);
                                                                           }
                                                                        } else if((field419 == 1 || class24.method603(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                                           XItemContainer.method165(field462 + field504, field456 + field445);
                                                                        } else if(menuOptionCount > 0) {
                                                                           var82 = field462 + field504;
                                                                           var11 = field456 + field445;
                                                                           class32 var126 = class4.field67;
                                                                           Friend.menuAction(var126.field726, var126.field722, var126.field721, var126.field724, var126.field725, var126.field725, var82, var11);
                                                                           class4.field67 = null;
                                                                        }

                                                                        field453 = null;
                                                                     }
                                                                  } else if(Friend.field248 > 1) {
                                                                     field453 = null;
                                                                  }
                                                               }

                                                               if(class12.field182 != null) {
                                                                  class166.method3253(class12.field182);
                                                                  ++field428;
                                                                  if(class143.field2199 != 0) {
                                                                     if(field428 >= 5 && (class143.field2200 > 5 + field396 || class143.field2200 < field396 - 5 || class143.field2204 > 5 + field295 || class143.field2204 < field295 - 5)) {
                                                                        field399 = true;
                                                                     }
                                                                  } else {
                                                                     if(field399) {
                                                                        if(class12.field182 == class117.field2030 && field398 != field395) {
                                                                           Widget var62 = class12.field182;
                                                                           byte var133 = 0;
                                                                           if(field443 == 1 && var62.contentType == 206) {
                                                                              var133 = 1;
                                                                           }

                                                                           if(var62.itemIds[field398] <= 0) {
                                                                              var133 = 0;
                                                                           }

                                                                           var30 = FrameMap.method2356(var62);
                                                                           var102 = (var30 >> 29 & 1) != 0;
                                                                           if(var102) {
                                                                              var70 = field395;
                                                                              var8 = field398;
                                                                              var62.itemIds[var8] = var62.itemIds[var70];
                                                                              var62.itemQuantities[var8] = var62.itemQuantities[var70];
                                                                              var62.itemIds[var70] = -1;
                                                                              var62.itemQuantities[var70] = 0;
                                                                           } else if(var133 == 1) {
                                                                              var70 = field395;
                                                                              var8 = field398;

                                                                              while(var8 != var70) {
                                                                                 if(var70 > var8) {
                                                                                    var62.method3420(var70 - 1, var70);
                                                                                    --var70;
                                                                                 } else if(var70 < var8) {
                                                                                    var62.method3420(1 + var70, var70);
                                                                                    ++var70;
                                                                                 }
                                                                              }
                                                                           } else {
                                                                              var62.method3420(field398, field395);
                                                                           }

                                                                           field324.method2828(232);
                                                                           field324.method2559(class12.field182.id);
                                                                           field324.method2638(field398);
                                                                           field324.method2756(field395);
                                                                           field324.method2596(var133);
                                                                        }
                                                                     } else if((field419 == 1 || class24.method603(menuOptionCount - 1)) && menuOptionCount > 2) {
                                                                        XItemContainer.method165(field396, field295);
                                                                     } else if(menuOptionCount > 0) {
                                                                        var27 = field396;
                                                                        var28 = field295;
                                                                        class32 var83 = class4.field67;
                                                                        Friend.menuAction(var83.field726, var83.field722, var83.field721, var83.field724, var83.field725, var83.field725, var27, var28);
                                                                        class4.field67 = null;
                                                                     }

                                                                     field393 = 10;
                                                                     class143.field2206 = 0;
                                                                     class12.field182 = null;
                                                                  }
                                                               }

                                                               if(Region.field1565 != -1) {
                                                                  var27 = Region.field1565;
                                                                  var28 = Region.field1555;
                                                                  field324.method2828(230);
                                                                  field324.method2556(5);
                                                                  field324.method2603(var27 + class47.baseX);
                                                                  field324.method2756(var28 + class21.baseY);
                                                                  field324.method2700(class140.field2163[82]?(class140.field2163[81]?2:1):0);
                                                                  Region.field1565 = -1;
                                                                  field320 = class143.field2207;
                                                                  field390 = class143.field2196;
                                                                  field326 = 1;
                                                                  field389 = 0;
                                                                  flagX = var27;
                                                                  flagY = var28;
                                                               }

                                                               if(var59 != Player.field31) {
                                                                  if(null != var59) {
                                                                     class166.method3253(var59);
                                                                  }

                                                                  if(null != Player.field31) {
                                                                     class166.method3253(Player.field31);
                                                                  }
                                                               }

                                                               if(Actor.field885 != var61 && field432 == field431) {
                                                                  if(null != var61) {
                                                                     class166.method3253(var61);
                                                                  }

                                                                  if(Actor.field885 != null) {
                                                                     class166.method3253(Actor.field885);
                                                                  }
                                                               }

                                                               if(Actor.field885 != null) {
                                                                  if(field431 < field432) {
                                                                     ++field431;
                                                                     if(field432 == field431) {
                                                                        class166.method3253(Actor.field885);
                                                                     }
                                                                  }
                                                               } else if(field431 > 0) {
                                                                  --field431;
                                                               }

                                                               var27 = field378 + class165.localPlayer.x;
                                                               var28 = class165.localPlayer.y + field347;
                                                               if(class168.field2706 - var27 < -500 || class168.field2706 - var27 > 500 || class75.field1406 - var28 < -500 || class75.field1406 - var28 > 500) {
                                                                  class168.field2706 = var27;
                                                                  class75.field1406 = var28;
                                                               }

                                                               if(var27 != class168.field2706) {
                                                                  class168.field2706 += (var27 - class168.field2706) / 16;
                                                               }

                                                               if(class75.field1406 != var28) {
                                                                  class75.field1406 += (var28 - class75.field1406) / 16;
                                                               }

                                                               if(class143.field2199 == 4 && class124.field2066) {
                                                                  var29 = class143.field2204 - field370;
                                                                  field473 = var29 * 2;
                                                                  field370 = var29 != -1 && var29 != 1?(field370 + class143.field2204) / 2:class143.field2204;
                                                                  var30 = field369 - class143.field2200;
                                                                  field367 = var30 * 2;
                                                                  field369 = var30 != -1 && var30 != 1?(field369 + class143.field2200) / 2:class143.field2200;
                                                               } else {
                                                                  if(class140.field2163[96]) {
                                                                     field367 += (-24 - field367) / 2;
                                                                  } else if(class140.field2163[97]) {
                                                                     field367 += (24 - field367) / 2;
                                                                  } else {
                                                                     field367 /= 2;
                                                                  }

                                                                  if(class140.field2163[98]) {
                                                                     field473 += (12 - field473) / 2;
                                                                  } else if(class140.field2163[99]) {
                                                                     field473 += (-12 - field473) / 2;
                                                                  } else {
                                                                     field473 /= 2;
                                                                  }

                                                                  field370 = class143.field2204;
                                                                  field369 = class143.field2200;
                                                               }

                                                               mapAngle = field367 / 2 + mapAngle & 2047;
                                                               field365 += field473 / 2;
                                                               if(field365 < 128) {
                                                                  field365 = 128;
                                                               }

                                                               if(field365 > 383) {
                                                                  field365 = 383;
                                                               }

                                                               var29 = class168.field2706 >> 7;
                                                               var30 = class75.field1406 >> 7;
                                                               var70 = class109.method2439(class168.field2706, class75.field1406, class145.plane);
                                                               var8 = 0;
                                                               if(var29 > 3 && var30 > 3 && var29 < 100 && var30 < 100) {
                                                                  for(var9 = var29 - 4; var9 <= var29 + 4; ++var9) {
                                                                     for(var82 = var30 - 4; var82 <= var30 + 4; ++var82) {
                                                                        var11 = class145.plane;
                                                                        if(var11 < 3 && (class5.tileSettings[1][var9][var82] & 2) == 2) {
                                                                           ++var11;
                                                                        }

                                                                        var91 = var70 - class5.tileHeights[var11][var9][var82];
                                                                        if(var91 > var8) {
                                                                           var8 = var91;
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

                                                               if(var9 > field348) {
                                                                  field348 += (var9 - field348) / 24;
                                                               } else if(var9 < field348) {
                                                                  field348 += (var9 - field348) / 80;
                                                               }

                                                               if(field528) {
                                                                  class16.method172();
                                                               }

                                                               for(var27 = 0; var27 < 5; ++var27) {
                                                                  ++field533[var27];
                                                               }

                                                               class50.chatMessages.method211();
                                                               var27 = class32.method690();
                                                               var28 = class140.keyboardIdleTicks;
                                                               if(var27 > 15000 && var28 > 15000) {
                                                                  field397 = 250;
                                                                  class143.mouseIdleTicks = 14500;
                                                                  field324.method2828(81);
                                                               }

                                                               ++field404;
                                                               if(field404 > 500) {
                                                                  field404 = 0;
                                                                  var30 = (int)(Math.random() * 8.0D);
                                                                  if((var30 & 1) == 1) {
                                                                     field378 += field298;
                                                                  }

                                                                  if((var30 & 2) == 2) {
                                                                     field347 += field363;
                                                                  }

                                                                  if((var30 & 4) == 4) {
                                                                     field349 += field350;
                                                                  }
                                                               }

                                                               if(field378 < -50) {
                                                                  field298 = 2;
                                                               }

                                                               if(field378 > 50) {
                                                                  field298 = -2;
                                                               }

                                                               if(field347 < -55) {
                                                                  field363 = 2;
                                                               }

                                                               if(field347 > 55) {
                                                                  field363 = -2;
                                                               }

                                                               if(field349 < -40) {
                                                                  field350 = 1;
                                                               }

                                                               if(field349 > 40) {
                                                                  field350 = -1;
                                                               }

                                                               ++field356;
                                                               if(field356 > 500) {
                                                                  field356 = 0;
                                                                  var30 = (int)(Math.random() * 8.0D);
                                                                  if((var30 & 1) == 1) {
                                                                     mapScale += field353;
                                                                  }

                                                                  if((var30 & 2) == 2) {
                                                                     mapScaleDelta += field355;
                                                                  }
                                                               }

                                                               if(mapScale < -60) {
                                                                  field353 = 2;
                                                               }

                                                               if(mapScale > 60) {
                                                                  field353 = -2;
                                                               }

                                                               if(mapScaleDelta < -20) {
                                                                  field355 = 1;
                                                               }

                                                               if(mapScaleDelta > 10) {
                                                                  field355 = -1;
                                                               }

                                                               for(class40 var96 = (class40)field463.method3810(); var96 != null; var96 = (class40)field463.method3811()) {
                                                                  if((long)var96.field889 < class169.method3276() / 1000L - 5L) {
                                                                     if(var96.field890 > 0) {
                                                                        Widget.sendGameMessage(5, "", var96.field891 + " has logged in.");
                                                                     }

                                                                     if(var96.field890 == 0) {
                                                                        Widget.sendGameMessage(5, "", var96.field891 + " has logged out.");
                                                                     }

                                                                     var96.method3945();
                                                                  }
                                                               }

                                                               ++field330;
                                                               if(field330 > 50) {
                                                                  field324.method2828(45);
                                                               }

                                                               try {
                                                                  if(class28.field671 != null && field324.offset > 0) {
                                                                     class28.field671.method3027(field324.payload, 0, field324.offset);
                                                                     field324.offset = 0;
                                                                     field330 = 0;
                                                                     return;
                                                                  }
                                                               } catch (IOException var41) {
                                                                  class48.method1004();
                                                               }

                                                               return;
                                                            }

                                                            var81 = var3.field11;
                                                            if(var81.index < 0) {
                                                               break;
                                                            }

                                                            var66 = class144.method3012(var81.parentId);
                                                         } while(null == var66 || null == var66.children || var81.index >= var66.children.length || var66.children[var81.index] != var81);

                                                         SecondaryBufferProvider.method1661(var3);
                                                      }
                                                   }

                                                   var81 = var3.field11;
                                                   if(var81.index < 0) {
                                                      break;
                                                   }

                                                   var66 = class144.method3012(var81.parentId);
                                                } while(null == var66 || var66.children == null || var81.index >= var66.children.length || var81 != var66.children[var81.index]);

                                                SecondaryBufferProvider.method1661(var3);
                                             }
                                          }

                                          var81 = var3.field11;
                                          if(var81.index < 0) {
                                             break;
                                          }

                                          var66 = class144.method3012(var81.parentId);
                                       } while(var66 == null || var66.children == null || var81.index >= var66.children.length || var81 != var66.children[var81.index]);

                                       SecondaryBufferProvider.method1661(var3);
                                    }
                                 }
                              }
                           }
                           break;
                        }

                        field324.method2828(11);
                        field324.method2556(0);
                        var26 = field324.offset;
                        class134.method2880(field324);
                        field324.method2568(field324.offset - var26);
                     }
                  }
               }
            } else if(gameState == 40 || gameState == 45) {
               class184.method3560();
            }

            return;
         }

         var1.field2750.method3368(var1.field2748, (int)var1.hash, var1.field2747, false);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1591754231"
   )
   public static int method475(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }
}
