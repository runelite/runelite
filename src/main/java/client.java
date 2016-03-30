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
public final class client extends class144 {
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = -1896470715
   )
   static int field293;
   @ObfuscatedName("p")
   static client field294;
   @ObfuscatedName("k")
   static boolean field295 = true;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -248904617
   )
   @Export("world")
   static int field296 = 1;
   @ObfuscatedName("ea")
   static boolean field297;
   @ObfuscatedName("v")
   static class153 field298;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 858353547
   )
   static int field299 = 0;
   @ObfuscatedName("j")
   static boolean field300 = false;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -161530669
   )
   @Export("packetOpcode")
   static int field301;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -984946883
   )
   static int field302 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2087962919
   )
   @Export("gameState")
   static int field303 = 0;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -318570271
   )
   static int field304;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1141184381
   )
   @Export("gameCycle")
   static int field305 = 0;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 2013820187
   )
   @Export("camera2")
   static int field306;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1046593833
   )
   static int field307 = -1;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 141413819
   )
   static int field308;
   @ObfuscatedName("pe")
   static class179 field309;
   @ObfuscatedName("ok")
   static class195 field310;
   @ObfuscatedName("ar")
   static boolean field311 = false;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -420435795
   )
   static int field312;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1506075263
   )
   static int field313 = 0;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -39191399
   )
   static int field314;
   @ObfuscatedName("ip")
   static String field315;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1845563825
   )
   static int field316 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2004174619
   )
   static int field317 = 0;
   @ObfuscatedName("cm")
   static class122 field318;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1816287011
   )
   static int field319 = 0;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = -469018229
   )
   static int field320;
   @ObfuscatedName("ad")
   static class20 field321;
   @ObfuscatedName("au")
   static class20 field322;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1354509733
   )
   static int field323;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 640067929
   )
   static int field324;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 463680949
   )
   static int field325;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1974635385
   )
   static int field326;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 2017539883
   )
   static int field327;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 602253039
   )
   static int field328;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 66537961
   )
   static int field329;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -727018807
   )
   static int field330;
   @ObfuscatedName("cs")
   @Export("cachedNPCs")
   static class34[] field331;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 745020257
   )
   static int field332;
   @ObfuscatedName("ci")
   static int[] field333;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -1140090713
   )
   static int field334;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -1043020137
   )
   static int field335;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 845002055
   )
   static int field336;
   @ObfuscatedName("cf")
   static class122 field337;
   @ObfuscatedName("mx")
   static String field338;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -2043270407
   )
   static int field339;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -1435415487
   )
   static int field340;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 287809199
   )
   static int field341;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -1438168341
   )
   static int field342;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -2054437077
   )
   static int field343;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -2144027123
   )
   static int field344;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -559322521
   )
   static int field345;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1195784011
   )
   static int field346;
   @ObfuscatedName("cg")
   static boolean field347;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -512024619
   )
   static int field348;
   @ObfuscatedName("oi")
   static int[] field349;
   @ObfuscatedName("nu")
   static int[] field350;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -845780201
   )
   static int field351;
   @ObfuscatedName("je")
   static class173 field352;
   @ObfuscatedName("jq")
   static class173 field353;
   @ObfuscatedName("dx")
   static boolean field354;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 1326881615
   )
   static int field355;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 129906115
   )
   static int field357 = -1;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 1623240943
   )
   static int field358;
   @ObfuscatedName("kr")
   static class199 field359;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 1287767891
   )
   static int field360;
   @ObfuscatedName("lk")
   @Export("widgetPositionX")
   static int[] field361;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 874303825
   )
   static int field362;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -1719011463
   )
   static int field363;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -1736960393
   )
   static int field364;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -1052709331
   )
   @Export("mapScale")
   static int field365;
   @ObfuscatedName("it")
   static String field366;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 1584082181
   )
   static int field367;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 1113535401
   )
   static int field368;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = -1937609835
   )
   static int field369;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 25998453
   )
   static int field370;
   @ObfuscatedName("ev")
   static class80[] field371;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class108[] field372;
   @ObfuscatedName("px")
   static final class10 field373;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -1537400105
   )
   static int field374;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 882976611
   )
   static int field375;
   @ObfuscatedName("fl")
   static int[] field376;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -1276105249
   )
   static int field377;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 295627145
   )
   static int field378;
   @ObfuscatedName("e")
   static boolean field379 = true;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -669691771
   )
   static int field380;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -894306409
   )
   static int field381;
   @ObfuscatedName("jm")
   static boolean field382;
   @ObfuscatedName("od")
   static short field383;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 1543274757
   )
   static int field384;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 1014608063
   )
   static int field385;
   @ObfuscatedName("fm")
   static boolean field386;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1453913779
   )
   static int field387;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -322851319
   )
   @Export("mapAngle")
   static int field388;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = -711950301
   )
   static int field389;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -348348075
   )
   static int field390;
   @ObfuscatedName("fk")
   static int[] field391;
   @ObfuscatedName("fq")
   static int[] field392;
   @ObfuscatedName("fy")
   static int[] field393;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -134976879
   )
   static int field394 = 0;
   @ObfuscatedName("cl")
   static int[] field395;
   @ObfuscatedName("oq")
   static short field396;
   @ObfuscatedName("gg")
   static String[] field397;
   @ObfuscatedName("gq")
   static int[][] field398;
   @ObfuscatedName("mk")
   static int[] field399;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1018647575
   )
   static int field400;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 608778293
   )
   static int field401;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1736096325
   )
   static int field402;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1617599387
   )
   static int field403;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1277890765
   )
   static int field404;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -670794151
   )
   static int field405;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -256041999
   )
   static int field406 = 0;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -2145165185
   )
   static int field407;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -2091331409
   )
   static int field408;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 2080417381
   )
   static int field409;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1164779909
   )
   static int field410;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 363866615
   )
   static int field411;
   @ObfuscatedName("gw")
   static boolean field412;
   @ObfuscatedName("q")
   static boolean field413 = false;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1257148703
   )
   static int field414;
   @ObfuscatedName("gb")
   @Export("cachedPlayers")
   static class2[] field415;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1674291007
   )
   static int field416;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -1867944781
   )
   static int field417;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -36850657
   )
   static int field418;
   @ObfuscatedName("hm")
   static int[] field419;
   @ObfuscatedName("hr")
   static final int[] field420;
   @ObfuscatedName("hn")
   static String[] field421;
   @ObfuscatedName("he")
   static boolean[] field422;
   @ObfuscatedName("jz")
   static boolean field423;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 2095278595
   )
   static int field424;
   @ObfuscatedName("hh")
   @Export("groundItemDeque")
   static class199[][][] field425;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -1755532559
   )
   static int field426;
   @ObfuscatedName("hp")
   static class199 field427;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 132178177
   )
   static int field428;
   @ObfuscatedName("hu")
   @Export("boostedSkillLevels")
   static int[] field429;
   @ObfuscatedName("am")
   static boolean field430 = true;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 1287315376615900049L
   )
   static long field431 = -1L;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -2032663889
   )
   static int field432;
   @ObfuscatedName("ht")
   @Export("isMenuOpen")
   static boolean field433;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 864984103
   )
   static int field434 = -1;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 646868637
   )
   @Export("menuOptionCount")
   static int field435;
   @ObfuscatedName("hk")
   static int[] field436;
   @ObfuscatedName("il")
   static int[] field437;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -977280199
   )
   static int field438;
   @ObfuscatedName("iw")
   @Export("menuIdentifiers")
   static int[] field439;
   @ObfuscatedName("if")
   @Export("menuOptions")
   static String[] field440;
   @ObfuscatedName("iq")
   @Export("menuTargets")
   static String[] field441;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 2055727911
   )
   static int field442;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -1270594953
   )
   static int field443;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -2068519463
   )
   static int field444;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 1232565063
   )
   static int field445;
   @ObfuscatedName("dt")
   static int[][][] field446;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1846480715
   )
   static int field447 = 0;
   @ObfuscatedName("io")
   @Export("menuTypes")
   static int[] field448;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -1611040013
   )
   static int field449;
   @ObfuscatedName("mv")
   static String field450;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1169837689
   )
   static int field451;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      longValue = 519364659862092983L
   )
   static long field452;
   @ObfuscatedName("ik")
   static String field453;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 495167737
   )
   static int field454;
   @ObfuscatedName("ii")
   @Export("componentTable")
   static class196 field455;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -730888421
   )
   static int field456;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 1225808405
   )
   static int field457;
   @ObfuscatedName("jo")
   static class173 field458;
   @ObfuscatedName("ln")
   static boolean[] field459;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 1515749435
   )
   @Export("weight")
   static int field460;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -1591740721
   )
   static int field461;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -1779436847
   )
   static int field462;
   @ObfuscatedName("jd")
   static boolean field463;
   @ObfuscatedName("hg")
   @Export("skillExperiences")
   static int[] field464;
   @ObfuscatedName("jv")
   static boolean field465;
   @ObfuscatedName("jb")
   static class173 field466;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1140260119
   )
   static int field467;
   @ObfuscatedName("jh")
   static class173 field468;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -533896787
   )
   static int field469;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -2117695009
   )
   static int field470;
   @ObfuscatedName("ft")
   static int[] field471;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -1273928911
   )
   static int field472;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 2024985673
   )
   static int field473;
   @ObfuscatedName("ot")
   @Export("friends")
   static class17[] field474;
   @ObfuscatedName("jw")
   static boolean field475;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 273636059
   )
   static int field476;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 892679091
   )
   static int field477;
   @ObfuscatedName("hz")
   static class199 field478;
   @ObfuscatedName("or")
   static int[] field479;
   @ObfuscatedName("kt")
   static int[] field480;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -760228067
   )
   static int field481;
   @ObfuscatedName("hv")
   static class199 field482;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 1034263675
   )
   static int field483;
   @ObfuscatedName("km")
   static int[] field484;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -992170937
   )
   static int field485;
   @ObfuscatedName("lt")
   @Export("widgetPositionY")
   static int[] field486;
   @ObfuscatedName("mz")
   static class78[] field487;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -2000370519
   )
   static int field488;
   @ObfuscatedName("ko")
   static class199 field489;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -1788032337
   )
   static int field490;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 1851922235
   )
   static int field491;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 2035273083
   )
   static int field492;
   @ObfuscatedName("kk")
   static class199 field493;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -784395801
   )
   static int field494;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 891859529
   )
   static int field495;
   @ObfuscatedName("mo")
   static boolean field496;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 442769437
   )
   static int field497;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 628886475
   )
   static int field498;
   @ObfuscatedName("li")
   static boolean[] field499;
   @ObfuscatedName("lc")
   static boolean[] field500;
   @ObfuscatedName("kg")
   static class196 field501;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -2084781903
   )
   static int field502 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -135351015
   )
   static int field503 = 0;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1525968431
   )
   static int field504;
   @ObfuscatedName("ls")
   static int[] field505;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 1337113293
   )
   static int field506;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      longValue = -1531415371244774889L
   )
   static long field507;
   @ObfuscatedName("lf")
   @Export("isResized")
   static boolean field508;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -807849859
   )
   static int field509;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -409624897
   )
   static int field510;
   @ObfuscatedName("lo")
   static int[] field511;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -283935095
   )
   static int field512;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -158785921
   )
   static int field513;
   @ObfuscatedName("ll")
   static String field514;
   @ObfuscatedName("la")
   static long[] field515;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1698734385
   )
   static int field516;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -512926723
   )
   static int field517;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -465077369
   )
   static int field518;
   @ObfuscatedName("mm")
   static int[] field519;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      longValue = 1834486798398188703L
   )
   static long field520;
   @ObfuscatedName("jk")
   static boolean field521;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 1186131127
   )
   @Export("energy")
   static int field522;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 1579902265
   )
   static int field523;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -1902158415
   )
   static int field524;
   @ObfuscatedName("mu")
   static int[] field525;
   @ObfuscatedName("ml")
   static int[] field526;
   @ObfuscatedName("oy")
   static short field527;
   @ObfuscatedName("cd")
   static class122 field528;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = 75555665
   )
   static int field529;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 2126417963
   )
   static int field530;
   @ObfuscatedName("gy")
   static int[] field531;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = -644501605
   )
   static int field532;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = -2025585781
   )
   static int field533;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = 1591801665
   )
   static int field534;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = -1944816489
   )
   static int field535;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 407832075
   )
   static int field536;
   @ObfuscatedName("hc")
   @Export("realSkillLevels")
   static int[] field537;
   @ObfuscatedName("nb")
   static int[] field538;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 1880322827
   )
   static int field539;
   @ObfuscatedName("nr")
   static int[] field540;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 201239377
   )
   static int field541;
   @ObfuscatedName("nx")
   static boolean field542;
   @ObfuscatedName("nd")
   static int[] field543;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -2069114275
   )
   static int field544;
   @ObfuscatedName("oa")
   static int[] field545;
   @ObfuscatedName("os")
   static int[] field546;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -2035099955
   )
   static int field547 = 0;
   @ObfuscatedName("ol")
   static short field549;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -1069762265
   )
   static int field550;
   @ObfuscatedName("om")
   static short field551;
   @ObfuscatedName("nt")
   static class58[] field552;
   @ObfuscatedName("op")
   static short field553;
   @ObfuscatedName("ky")
   static int[] field554;
   @ObfuscatedName("og")
   static short field555;
   @ObfuscatedName("ds")
   static final int[] field556;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = -908696357
   )
   static int field557;
   @ObfuscatedName("lw")
   static int[] field558;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = -1636970835
   )
   @Export("camera3")
   static int field559;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 1751822829
   )
   @Export("scale")
   static int field560;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -328020493
   )
   static int field561;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 407581241
   )
   static int field562;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 538593427
   )
   static int field563;
   @ObfuscatedName("on")
   static short field564;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 1377238943
   )
   static int field565;
   @ObfuscatedName("ov")
   @Export("ignores")
   static class7[] field566;
   @ObfuscatedName("fz")
   static int[] field567;
   @ObfuscatedName("of")
   static boolean[] field568;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -948783587
   )
   static int field569;
   @ObfuscatedName("pv")
   @Export("grandExchangeOffers")
   static class220[] field570;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      longValue = 3606399042333526101L
   )
   static long field571;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 129631901
   )
   static int field572;
   @ObfuscatedName("ib")
   static boolean field573;
   @ObfuscatedName("py")
   static int[] field574;
   @ObfuscatedName("pu")
   static int[] field575;
   @ObfuscatedName("hb")
   static int[] field576;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "29"
   )
   @Export("packetHandler")
   protected final void vmethod3035() {
      ++field305;
      this.method370();

      while(true) {
         class199 var2 = class170.field2729;
         class169 var1;
         synchronized(class170.field2729) {
            var1 = (class169)class170.field2731.method3837();
         }

         if(null == var1) {
            int var37;
            try {
               if(1 == class183.field2968) {
                  var37 = class183.field2967.method3676();
                  if(var37 > 0 && class183.field2967.method3622()) {
                     var37 -= class75.field1384;
                     if(var37 < 0) {
                        var37 = 0;
                     }

                     class183.field2967.method3615(var37);
                  } else {
                     class183.field2967.method3652();
                     class183.field2967.method3619();
                     if(class151.field2279 != null) {
                        class183.field2968 = 2;
                     } else {
                        class183.field2968 = 0;
                     }

                     class159.field2623 = null;
                     class5.field95 = null;
                  }
               }
            } catch (Exception var36) {
               var36.printStackTrace();
               class183.field2967.method3652();
               class183.field2968 = 0;
               class159.field2623 = null;
               class5.field95 = null;
               class151.field2279 = null;
            }

            class59.method1272();
            class9.method121();
            class84.method1897();
            if(class8.field159 != null) {
               var37 = class8.field159.vmethod3129();
               field492 = var37;
            }

            if(0 == field303) {
               class9.method118();
               class27.field679.vmethod3139();

               for(var37 = 0; var37 < 32; ++var37) {
                  class144.field2222[var37] = 0L;
               }

               for(var37 = 0; var37 < 32; ++var37) {
                  class144.field2220[var37] = 0L;
               }

               class124.field2039 = 0;
            } else if(field303 == 5) {
               class41.method896();
               class9.method118();
               class27.field679.vmethod3139();

               for(var37 = 0; var37 < 32; ++var37) {
                  class144.field2222[var37] = 0L;
               }

               for(var37 = 0; var37 < 32; ++var37) {
                  class144.field2220[var37] = 0L;
               }

               class124.field2039 = 0;
            } else if(10 != field303 && field303 != 11) {
               if(20 == field303) {
                  class41.method896();
                  class75.method1626();
               } else if(25 == field303) {
                  class162.method3221();
               }
            } else {
               class41.method896();
            }

            if(field303 == 30) {
               if(field394 > 1) {
                  --field394;
               }

               if(field346 > 0) {
                  --field346;
               }

               if(field347) {
                  field347 = false;
                  class3.method44();
               } else {
                  if(!field433) {
                     field440[0] = "Cancel";
                     field441[0] = "";
                     field448[0] = 1006;
                     field435 = 1;
                  }

                  int var3;
                  String var4;
                  int var5;
                  int var8;
                  int var39;
                  long var41;
                  class173 var43;
                  int var46;
                  int var49;
                  int var58;
                  boolean var69;
                  int var71;
                  int var72;
                  int var75;
                  for(var37 = 0; var37 < 100; ++var37) {
                     boolean var38;
                     if(class9.field173 == null) {
                        var38 = false;
                     } else {
                        label3430: {
                           try {
                              var3 = class9.field173.method3000();
                              if(var3 == 0) {
                                 var38 = false;
                                 break label3430;
                              }

                              if(-1 == field301) {
                                 class9.field173.method3001(field528.field2012, 0, 1);
                                 field528.field2011 = 0;
                                 field301 = field528.method2751();
                                 field339 = class188.field3058[field301];
                                 --var3;
                              }

                              if(-1 == field339) {
                                 if(var3 <= 0) {
                                    var38 = false;
                                    break label3430;
                                 }

                                 class9.field173.method3001(field528.field2012, 0, 1);
                                 field339 = field528.field2012[0] & 255;
                                 --var3;
                              }

                              if(field339 == -2) {
                                 if(var3 <= 1) {
                                    var38 = false;
                                    break label3430;
                                 }

                                 class9.field173.method3001(field528.field2012, 0, 2);
                                 field528.field2011 = 0;
                                 field339 = field528.method2508();
                                 var3 -= 2;
                              }

                              if(var3 < field339) {
                                 var38 = false;
                                 break label3430;
                              }

                              field528.field2011 = 0;
                              class9.field173.method3001(field528.field2012, 0, field339);
                              field341 = 0;
                              field345 = field344;
                              field344 = field343 * -1;
                              field343 = field301 * -1;
                              if(field301 == 50) {
                                 field304 = field528.method2597();
                                 class10.field177 = field528.method2533();

                                 for(var39 = class10.field177; var39 < class10.field177 + 8; ++var39) {
                                    for(var5 = field304; var5 < field304 + 8; ++var5) {
                                       if(null != field425[class82.field1437][var39][var5]) {
                                          field425[class82.field1437][var39][var5] = null;
                                          class122.method2760(var39, var5);
                                       }
                                    }
                                 }

                                 for(class16 var123 = (class16)field482.method3836(); var123 != null; var123 = (class16)field482.method3841()) {
                                    if(var123.field238 >= class10.field177 && var123.field238 < 8 + class10.field177 && var123.field239 >= field304 && var123.field239 < field304 + 8 && class82.field1437 == var123.field243) {
                                       var123.field247 = 0;
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(222 == field301) {
                                 class10.field177 = field528.method2533();
                                 field304 = field528.method2506();

                                 while(field528.field2011 < field339) {
                                    field301 = field528.method2506();
                                    class96.method2186();
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              class173 var89;
                              class3 var91;
                              if(172 == field301) {
                                 var39 = field528.method2511();
                                 var5 = field528.method2511();
                                 class3 var116 = (class3)field455.method3806((long)var5);
                                 var91 = (class3)field455.method3806((long)var39);
                                 if(var91 != null) {
                                    class5.method93(var91, null == var116 || var91.field74 != var116.field74);
                                 }

                                 if(var116 != null) {
                                    var116.method3935();
                                    field455.method3807(var116, (long)var39);
                                 }

                                 var89 = class52.method1115(var5);
                                 if(null != var89) {
                                    class134.method2877(var89);
                                 }

                                 var89 = class52.method1115(var39);
                                 if(null != var89) {
                                    class134.method2877(var89);
                                    class34.method746(class173.field2830[var89.field2838 >>> 16], var89, true);
                                 }

                                 if(-1 != field454) {
                                    class39.method797(field454, 1);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 252) {
                                 for(var39 = 0; var39 < class176.field2916.length; ++var39) {
                                    if(class176.field2916[var39] != class176.field2917[var39]) {
                                       class176.field2916[var39] = class176.field2917[var39];
                                       class95.method2184(var39);
                                       field480[++field481 - 1 & 31] = var39;
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 82) {
                                 var39 = field528.method2541();
                                 var5 = field528.method2511();
                                 var46 = var39 >> 10 & 31;
                                 var49 = var39 >> 5 & 31;
                                 var8 = var39 & 31;
                                 var58 = (var46 << 19) + (var49 << 11) + (var8 << 3);
                                 class173 var100 = class52.method1115(var5);
                                 if(var58 != var100.field2884) {
                                    var100.field2884 = var58;
                                    class134.method2877(var100);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(175 == field301) {
                                 var39 = field528.method2511();
                                 class3 var119 = (class3)field455.method3806((long)var39);
                                 if(var119 != null) {
                                    class5.method93(var119, true);
                                 }

                                 if(null != field458) {
                                    class134.method2877(field458);
                                    field458 = null;
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 250) {
                                 field528.field2011 += 28;
                                 if(field528.method2528()) {
                                    class156.method3193(field528, field528.field2011 - 28);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(38 == field301) {
                                 var39 = field528.method2600();
                                 class15 var118 = (class15)class15.field234.method3806((long)var39);
                                 if(var118 != null) {
                                    var118.method3935();
                                 }

                                 field554[++field483 - 1 & 31] = var39 & 32767;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 162) {
                                 field542 = true;
                                 class18.field277 = field528.method2506();
                                 class36.field813 = field528.method2506();
                                 class29.field699 = field528.method2508();
                                 class10.field184 = field528.method2506();
                                 class28.field687 = field528.method2506();
                                 if(class28.field687 >= 100) {
                                    var39 = 64 + class18.field277 * 128;
                                    var5 = class36.field813 * 128 + 64;
                                    var46 = class43.method938(var39, var5, class82.field1437) - class29.field699;
                                    var49 = var39 - class148.field2249;
                                    var8 = var46 - class156.field2333;
                                    var58 = var5 - class173.field2868;
                                    var71 = (int)Math.sqrt((double)(var49 * var49 + var58 * var58));
                                    class29.field698 = (int)(Math.atan2((double)var8, (double)var71) * 325.949D) & 2047;
                                    class16.field237 = (int)(Math.atan2((double)var49, (double)var58) * -325.949D) & 2047;
                                    if(class29.field698 < 128) {
                                       class29.field698 = 128;
                                    }

                                    if(class29.field698 > 383) {
                                       class29.field698 = 383;
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 232) {
                                 class168.method3372();
                                 field522 = field528.method2506();
                                 field495 = field491;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(1 == field301) {
                                 var4 = field528.method2683();
                                 Object[] var117 = new Object[var4.length() + 1];

                                 for(var46 = var4.length() - 1; var46 >= 0; --var46) {
                                    if(var4.charAt(var46) == 115) {
                                       var117[var46 + 1] = field528.method2683();
                                    } else {
                                       var117[1 + var46] = new Integer(field528.method2511());
                                    }
                                 }

                                 var117[0] = new Integer(field528.method2511());
                                 class0 var114 = new class0();
                                 var114.field7 = var117;
                                 class3.method48(var114);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 7) {
                                 class26.method646(field528, field339);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              class173 var63;
                              if(field301 == 231) {
                                 var39 = field528.method2689();
                                 var5 = field528.method2542();
                                 if(var5 == '\uffff') {
                                    var5 = -1;
                                 }

                                 var46 = field528.method2663();
                                 var63 = class52.method1115(var39);
                                 class51 var103;
                                 if(!var63.field2766) {
                                    if(var5 == -1) {
                                       var63.field2810 = 0;
                                       field301 = -1;
                                       var38 = true;
                                       break label3430;
                                    }

                                    var103 = class50.method1055(var5);
                                    var63.field2810 = 4;
                                    var63.field2811 = var5;
                                    var63.field2763 = var103.field1140;
                                    var63.field2819 = var103.field1129;
                                    var63.field2821 = var103.field1158 * 100 / var46;
                                    class134.method2877(var63);
                                 } else {
                                    var63.field2883 = var5;
                                    var63.field2888 = var46;
                                    var103 = class50.method1055(var5);
                                    var63.field2763 = var103.field1140;
                                    var63.field2819 = var103.field1129;
                                    var63.field2836 = var103.field1130;
                                    var63.field2816 = var103.field1131;
                                    var63.field2817 = var103.field1132;
                                    var63.field2821 = var103.field1158;
                                    if(1 == var103.field1133) {
                                       var63.field2807 = 1;
                                    } else {
                                       var63.field2807 = 2;
                                    }

                                    if(var63.field2822 > 0) {
                                       var63.field2821 = var63.field2821 * 32 / var63.field2822;
                                    } else if(var63.field2778 > 0) {
                                       var63.field2821 = var63.field2821 * 32 / var63.field2778;
                                    }

                                    class134.method2877(var63);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              String var42;
                              if(21 == field301) {
                                 while(field528.field2011 < field339) {
                                    var39 = field528.method2506();
                                    var69 = 1 == (var39 & 1);
                                    var42 = field528.method2683();
                                    String var115 = field528.method2683();
                                    field528.method2683();

                                    for(var8 = 0; var8 < field565; ++var8) {
                                       class7 var104 = field566[var8];
                                       if(var69) {
                                          if(var115.equals(var104.field146)) {
                                             var104.field146 = var42;
                                             var104.field140 = var115;
                                             var42 = null;
                                             break;
                                          }
                                       } else if(var42.equals(var104.field146)) {
                                          var104.field146 = var42;
                                          var104.field140 = var115;
                                          var42 = null;
                                          break;
                                       }
                                    }

                                    if(var42 != null && field565 < 400) {
                                       class7 var101 = new class7();
                                       field566[field565] = var101;
                                       var101.field146 = var42;
                                       var101.field140 = var115;
                                       ++field565;
                                    }
                                 }

                                 field572 = field491;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 73) {
                                 field562 = 1;
                                 field572 = field491;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 136) {
                                 field512 = field528.method2506();
                                 field513 = field528.method2506();
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              String var45;
                              if(44 == field301) {
                                 var39 = field528.method2532();
                                 var45 = field528.method2683();
                                 var46 = field528.method2532();
                                 if(var39 >= 1 && var39 <= 8) {
                                    if(var45.equalsIgnoreCase("null")) {
                                       var45 = null;
                                    }

                                    field421[var39 - 1] = var45;
                                    field422[var39 - 1] = 0 == var46;
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 57) {
                                 class142.method2996(field528.method2683());
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 201) {
                                 class168.method3372();
                                 field460 = field528.method2509();
                                 field495 = field491;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(19 == field301) {
                                 var39 = field528.method2508();
                                 if(var39 == '\uffff') {
                                    var39 = -1;
                                 }

                                 if(var39 == -1 && !field496) {
                                    class183.field2967.method3652();
                                    class183.field2968 = 1;
                                    class151.field2279 = null;
                                 } else if(var39 != -1 && var39 != field532 && field369 != 0 && !field496) {
                                    class168 var112 = class19.field289;
                                    var46 = field369;
                                    class183.field2968 = 1;
                                    class151.field2279 = var112;
                                    class72.field1358 = var39;
                                    class183.field2964 = 0;
                                    class183.field2970 = var46;
                                    class14.field225 = false;
                                    class75.field1384 = 2;
                                 }

                                 field532 = var39;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 101) {
                                 var39 = field528.method2542();
                                 if('\uffff' == var39) {
                                    var39 = -1;
                                 }

                                 var5 = field528.method2510();
                                 class76.method1667(var39);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(130 == field301) {
                                 field533 = field528.method2506();
                                 if(field533 == 255) {
                                    field533 = 0;
                                 }

                                 field529 = field528.method2506();
                                 if(255 == field529) {
                                    field529 = 0;
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 93) {
                                 var39 = field528.method2600();
                                 var5 = field528.method2541();
                                 var46 = field528.method2508();
                                 var49 = field528.method2689();
                                 var89 = class52.method1115(var49);
                                 if(var39 != var89.field2763 || var89.field2819 != var5 || var46 != var89.field2821) {
                                    var89.field2763 = var39;
                                    var89.field2819 = var5;
                                    var89.field2821 = var46;
                                    class134.method2877(var89);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              long var9;
                              if(field301 == 237) {
                                 var39 = field528.method2542();
                                 if('\uffff' == var39) {
                                    var39 = -1;
                                 }

                                 var5 = field528.method2551();
                                 var46 = field528.method2689();
                                 var49 = field528.method2600();
                                 if(var49 == '\uffff') {
                                    var49 = -1;
                                 }

                                 for(var8 = var49; var8 <= var39; ++var8) {
                                    var9 = ((long)var46 << 32) + (long)var8;
                                    class208 var93 = field501.method3806(var9);
                                    if(var93 != null) {
                                       var93.method3935();
                                    }

                                    field501.method3807(new class201(var5), var9);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 135) {
                                 class26.method644(true);
                                 field528.method2751();
                                 var39 = field528.method2508();
                                 class26.method646(field528, var39);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(245 == field301) {
                                 var39 = field528.method2508();
                                 var5 = field528.method2506();
                                 var46 = field528.method2508();
                                 class103.method2290(var39, var5, var46);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(35 == field301) {
                                 var39 = field528.method2544();
                                 var5 = field528.method2511();
                                 var46 = field528.method2545();
                                 var63 = class52.method1115(var5);
                                 if(var46 != var63.field2776 || var63.field2873 != var39 || var63.field2857 != 0 || var63.field2840 != 0) {
                                    var63.field2776 = var46;
                                    var63.field2873 = var39;
                                    var63.field2857 = 0;
                                    var63.field2840 = 0;
                                    class134.method2877(var63);
                                    class43.method950(var63);
                                    if(var63.field2814 == 0) {
                                       class34.method746(class173.field2830[var5 >> 16], var63, false);
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(166 == field301) {
                                 class25 var113 = new class25();
                                 var113.field649 = field528.method2683();
                                 var113.field650 = field528.method2508();
                                 var5 = field528.method2511();
                                 var113.field647 = var5;
                                 class138.method2937(45);
                                 class9.field173.method3005();
                                 class9.field173 = null;
                                 class115.method2447(var113);
                                 field301 = -1;
                                 var38 = false;
                                 break label3430;
                              }

                              class173 var6;
                              if(190 == field301) {
                                 var39 = field528.method2689();
                                 var45 = field528.method2683();
                                 var6 = class52.method1115(var39);
                                 if(!var45.equals(var6.field2771)) {
                                    var6.field2771 = var45;
                                    class134.method2877(var6);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 8) {
                                 var39 = field528.method2600();
                                 var5 = field528.method2689();
                                 var6 = class52.method1115(var5);
                                 if(null != var6 && var6.field2814 == 0) {
                                    if(var39 > var6.field2791 - var6.field2783) {
                                       var39 = var6.field2791 - var6.field2783;
                                    }

                                    if(var39 < 0) {
                                       var39 = 0;
                                    }

                                    if(var6.field2882 != var39) {
                                       var6.field2882 = var39;
                                       class134.method2877(var6);
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(207 == field301) {
                                 var39 = field528.method2506();
                                 var5 = field528.method2506();
                                 var46 = field528.method2506();
                                 var49 = field528.method2506();
                                 field568[var39] = true;
                                 field479[var39] = var5;
                                 field545[var39] = var46;
                                 field546[var39] = var49;
                                 field349[var39] = 0;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 67) {
                                 class46.method1008(false);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(96 == field301) {
                                 field304 = field528.method2597();
                                 class10.field177 = field528.method2532();
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(63 == field301) {
                                 for(var39 = 0; var39 < class52.field1165; ++var39) {
                                    class52 var107 = class56.method1237(var39);
                                    if(var107 != null) {
                                       class176.field2917[var39] = 0;
                                       class176.field2916[var39] = 0;
                                    }
                                 }

                                 class168.method3372();
                                 field481 += 32;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(87 == field301) {
                                 var39 = field528.method2506();
                                 var5 = field528.method2663();
                                 var46 = field528.method2508();
                                 var91 = (class3)field455.method3806((long)var5);
                                 if(var91 != null) {
                                    class5.method93(var91, var46 != var91.field74);
                                 }

                                 class72.method1577(var5, var46, var39);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(199 == field301) {
                                 class38.method785();
                                 field301 = -1;
                                 var38 = false;
                                 break label3430;
                              }

                              int var15;
                              int var84;
                              String var88;
                              if(field301 == 103) {
                                 class122 var109 = field528;
                                 var5 = field339;
                                 class210 var99 = new class210();
                                 var99.field3133 = var109.method2506();
                                 var99.field3131 = var109.method2511();
                                 var99.field3137 = new int[var99.field3133];
                                 var99.field3130 = new int[var99.field3133];
                                 var99.field3134 = new Field[var99.field3133];
                                 var99.field3135 = new int[var99.field3133];
                                 var99.field3136 = new Method[var99.field3133];
                                 var99.field3132 = new byte[var99.field3133][][];

                                 for(var49 = 0; var49 < var99.field3133; ++var49) {
                                    try {
                                       var8 = var109.method2506();
                                       String var90;
                                       String var96;
                                       if(var8 != 0 && 1 != var8 && 2 != var8) {
                                          if(var8 == 3 || 4 == var8) {
                                             var96 = var109.method2683();
                                             var90 = var109.method2683();
                                             var72 = var109.method2506();
                                             String[] var92 = new String[var72];

                                             for(var84 = 0; var84 < var72; ++var84) {
                                                var92[var84] = var109.method2683();
                                             }

                                             var88 = var109.method2683();
                                             byte[][] var110 = new byte[var72][];
                                             int var16;
                                             if(var8 == 3) {
                                                for(var15 = 0; var15 < var72; ++var15) {
                                                   var16 = var109.method2511();
                                                   var110[var15] = new byte[var16];
                                                   var109.method2531(var110[var15], 0, var16);
                                                }
                                             }

                                             var99.field3137[var49] = var8;
                                             Class[] var108 = new Class[var72];

                                             for(var16 = 0; var16 < var72; ++var16) {
                                                var108[var16] = class153.method3184(var92[var16]);
                                             }

                                             Class var105 = class153.method3184(var88);
                                             if(class153.method3184(var96).getClassLoader() == null) {
                                                throw new SecurityException();
                                             }

                                             Method[] var17 = class153.method3184(var96).getDeclaredMethods();
                                             Method[] var18 = var17;

                                             for(int var19 = 0; var19 < var18.length; ++var19) {
                                                Method var20 = var18[var19];
                                                if(var20.getName().equals(var90)) {
                                                   Class[] var21 = var20.getParameterTypes();
                                                   if(var21.length == var108.length) {
                                                      boolean var22 = true;

                                                      for(int var23 = 0; var23 < var108.length; ++var23) {
                                                         if(var21[var23] != var108[var23]) {
                                                            var22 = false;
                                                            break;
                                                         }
                                                      }

                                                      if(var22 && var105 == var20.getReturnType()) {
                                                         var99.field3136[var49] = var20;
                                                      }
                                                   }
                                                }
                                             }

                                             var99.field3132[var49] = var110;
                                          }
                                       } else {
                                          var96 = var109.method2683();
                                          var90 = var109.method2683();
                                          var72 = 0;
                                          if(var8 == 1) {
                                             var72 = var109.method2511();
                                          }

                                          var99.field3137[var49] = var8;
                                          var99.field3135[var49] = var72;
                                          if(class153.method3184(var96).getClassLoader() == null) {
                                             throw new SecurityException();
                                          }

                                          var99.field3134[var49] = class153.method3184(var96).getDeclaredField(var90);
                                       }
                                    } catch (ClassNotFoundException var29) {
                                       var99.field3130[var49] = -1;
                                    } catch (SecurityException var30) {
                                       var99.field3130[var49] = -2;
                                    } catch (NullPointerException var31) {
                                       var99.field3130[var49] = -3;
                                    } catch (Exception var32) {
                                       var99.field3130[var49] = -4;
                                    } catch (Throwable var33) {
                                       var99.field3130[var49] = -5;
                                    }
                                 }

                                 class211.field3139.method3877(var99);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(195 == field301) {
                                 field394 = field528.method2600() * 30;
                                 field495 = field491;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              long var82;
                              if(22 == field301) {
                                 var39 = field528.method2511();
                                 var5 = field528.method2511();
                                 if(class85.field1466 == null || !class85.field1466.isValid()) {
                                    try {
                                       Iterator var94 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                                       while(var94.hasNext()) {
                                          GarbageCollectorMXBean var111 = (GarbageCollectorMXBean)var94.next();
                                          if(var111.isValid()) {
                                             class85.field1466 = var111;
                                             field452 = -1L;
                                             field571 = -1L;
                                          }
                                       }
                                    } catch (Throwable var28) {
                                       ;
                                    }
                                 }

                                 long var97 = class14.method165();
                                 var8 = -1;
                                 if(class85.field1466 != null) {
                                    var9 = class85.field1466.getCollectionTime();
                                    if(field571 != -1L) {
                                       long var86 = var9 - field571;
                                       var82 = var97 - field452;
                                       if(var82 != 0L) {
                                          var8 = (int)(var86 * 100L / var82);
                                       }
                                    }

                                    field571 = var9;
                                    field452 = var97;
                                 }

                                 field318.method2757(227);
                                 field318.method2610(var39);
                                 field318.method2610(var5);
                                 field318.method2529(var8);
                                 field318.method2529(class144.field2218);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 230) {
                                 var39 = field528.method2511();
                                 var5 = field528.method2508();
                                 if(var39 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var39 >= 0) {
                                    var6 = class52.method1115(var39);
                                 } else {
                                    var6 = null;
                                 }

                                 for(; field528.field2011 < field339; class89.method2076(var5, var49, var8 - 1, var58)) {
                                    var49 = field528.method2571();
                                    var8 = field528.method2508();
                                    var58 = 0;
                                    if(0 != var8) {
                                       var58 = field528.method2506();
                                       if(255 == var58) {
                                          var58 = field528.method2511();
                                       }
                                    }

                                    if(var6 != null && var49 >= 0 && var49 < var6.field2885.length) {
                                       var6.field2885[var49] = var8;
                                       var6.field2886[var49] = var58;
                                    }
                                 }

                                 if(var6 != null) {
                                    class134.method2877(var6);
                                 }

                                 class168.method3372();
                                 field554[++field483 - 1 & 31] = var5 & 32767;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(56 == field301) {
                                 class168.method3372();
                                 var39 = field528.method2551();
                                 var5 = field528.method2506();
                                 var46 = field528.method2506();
                                 field464[var46] = var39;
                                 field429[var46] = var5;
                                 field537[var46] = 1;

                                 for(var49 = 0; var49 < 98; ++var49) {
                                    if(var39 >= class155.field2319[var49]) {
                                       field537[var46] = var49 + 2;
                                    }
                                 }

                                 field484[++field410 - 1 & 31] = var46;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(118 == field301) {
                                 field334 = field528.method2506();
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 85) {
                                 var39 = field528.method2508();
                                 var5 = field528.method2511();
                                 var6 = class52.method1115(var5);
                                 if(1 != var6.field2810 || var6.field2811 != var39) {
                                    var6.field2810 = 1;
                                    var6.field2811 = var39;
                                    class134.method2877(var6);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 48) {
                                 var39 = field528.method2511();
                                 class104.field1805 = class123.field2036.method2897(var39);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              boolean var40;
                              if(160 == field301) {
                                 var40 = field528.method2506() == 1;
                                 if(var40) {
                                    class1.field26 = class14.method165() - field528.method2512();
                                    class52.field1164 = new class221(field528, true);
                                 } else {
                                    class52.field1164 = null;
                                 }

                                 field490 = field491;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(141 == field301) {
                                 var39 = field528.method2600();
                                 field454 = var39;
                                 class14.method168(field454, class15.field235, class15.field233, false);
                                 class77.method1671(var39);
                                 class47.method1021(field454);

                                 for(var5 = 0; var5 < 100; ++var5) {
                                    field499[var5] = true;
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 61) {
                                 var39 = field528.method2511();
                                 var69 = field528.method2597() == 1;
                                 var6 = class52.method1115(var39);
                                 if(var69 != var6.field2787) {
                                    var6.field2787 = var69;
                                    class134.method2877(var6);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 247) {
                                 var39 = field528.method2600();
                                 byte var77 = field528.method2639();
                                 class176.field2917[var39] = var77;
                                 if(var77 != class176.field2916[var39]) {
                                    class176.field2916[var39] = var77;
                                 }

                                 class95.method2184(var39);
                                 field480[++field481 - 1 & 31] = var39;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(206 == field301) {
                                 var39 = field528.method2663();
                                 var43 = class52.method1115(var39);

                                 for(var46 = 0; var46 < var43.field2885.length; ++var46) {
                                    var43.field2885[var46] = -1;
                                    var43.field2885[var46] = 0;
                                 }

                                 class134.method2877(var43);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(240 == field301) {
                                 var39 = field528.method2544();
                                 var5 = field528.method2511();
                                 var6 = class52.method1115(var5);
                                 if(var39 != var6.field2851 || var39 == -1) {
                                    var6.field2851 = var39;
                                    var6.field2889 = 0;
                                    var6.field2898 = 0;
                                    class134.method2877(var6);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 26) {
                                 class46.method1008(true);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 84) {
                                 var5 = field528.method2506();
                                 class130[] var73 = class8.method110();
                                 var49 = 0;

                                 class130 var80;
                                 while(true) {
                                    if(var49 >= var73.length) {
                                       var80 = null;
                                       break;
                                    }

                                    class130 var76 = var73[var49];
                                    if(var76.field2067 == var5) {
                                       var80 = var76;
                                       break;
                                    }

                                    ++var49;
                                 }

                                 class103.field1785 = var80;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 131) {
                                 for(var39 = 0; var39 < field415.length; ++var39) {
                                    if(null != field415[var39]) {
                                       field415[var39].field821 = -1;
                                    }
                                 }

                                 for(var39 = 0; var39 < field331.length; ++var39) {
                                    if(null != field331[var39]) {
                                       field331[var39].field821 = -1;
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              boolean var50;
                              if(151 == field301) {
                                 var39 = field528.method2571();
                                 var69 = field528.method2506() == 1;
                                 var42 = "";
                                 var50 = false;
                                 if(var69) {
                                    var42 = field528.method2683();
                                    if(class45.method991(var42)) {
                                       var50 = true;
                                    }
                                 }

                                 String var74 = field528.method2683();
                                 if(!var50) {
                                    class103.method2289(var39, var42, var74);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(183 == field301) {
                                 field542 = false;

                                 for(var39 = 0; var39 < 5; ++var39) {
                                    field568[var39] = false;
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              long var12;
                              if(244 == field301) {
                                 var39 = field339 + field528.field2011;
                                 var5 = field528.method2508();
                                 var46 = field528.method2508();
                                 if(var5 != field454) {
                                    field454 = var5;
                                    class14.method168(field454, class15.field235, class15.field233, false);
                                    class77.method1671(field454);
                                    class47.method1021(field454);

                                    for(var49 = 0; var49 < 100; ++var49) {
                                       field499[var49] = true;
                                    }
                                 }

                                 class3 var81;
                                 for(; var46-- > 0; var81.field71 = true) {
                                    var49 = field528.method2511();
                                    var8 = field528.method2508();
                                    var58 = field528.method2506();
                                    var81 = (class3)field455.method3806((long)var49);
                                    if(null != var81 && var81.field74 != var8) {
                                       class5.method93(var81, true);
                                       var81 = null;
                                    }

                                    if(null == var81) {
                                       var81 = class72.method1577(var49, var8, var58);
                                    }
                                 }

                                 for(var91 = (class3)field455.method3805(); null != var91; var91 = (class3)field455.method3809()) {
                                    if(var91.field71) {
                                       var91.field71 = false;
                                    } else {
                                       class5.method93(var91, true);
                                    }
                                 }

                                 field501 = new class196(512);

                                 while(field528.field2011 < var39) {
                                    var49 = field528.method2511();
                                    var8 = field528.method2508();
                                    var58 = field528.method2508();
                                    var71 = field528.method2511();

                                    for(var72 = var8; var72 <= var58; ++var72) {
                                       var12 = (long)var72 + ((long)var49 << 32);
                                       field501.method3807(new class201(var71), var12);
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 185) {
                                 var39 = field528.method2542();
                                 var5 = field528.method2689();
                                 class176.field2917[var39] = var5;
                                 if(class176.field2916[var39] != var5) {
                                    class176.field2916[var39] = var5;
                                 }

                                 class95.method2184(var39);
                                 field480[++field481 - 1 & 31] = var39;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 210) {
                                 class131.method2846();

                                 for(var39 = 0; var39 < 2048; ++var39) {
                                    field415[var39] = null;
                                 }

                                 class82.method1886(field528);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 115 || field301 == 81 || field301 == 224 || 52 == field301 || field301 == 198 || field301 == 36 || 95 == field301 || field301 == 196 || field301 == 153 || 154 == field301) {
                                 class96.method2186();
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(33 == field301) {
                                 var39 = field528.method2511();
                                 var5 = field528.method2508();
                                 if(var39 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var39 >= 0) {
                                    var6 = class52.method1115(var39);
                                 } else {
                                    var6 = null;
                                 }

                                 if(null != var6) {
                                    for(var49 = 0; var49 < var6.field2885.length; ++var49) {
                                       var6.field2885[var49] = 0;
                                       var6.field2886[var49] = 0;
                                    }
                                 }

                                 class15 var83 = (class15)class15.field234.method3806((long)var5);
                                 if(null != var83) {
                                    for(var8 = 0; var8 < var83.field228.length; ++var8) {
                                       var83.field228[var8] = -1;
                                       var83.field229[var8] = 0;
                                    }
                                 }

                                 var49 = field528.method2508();

                                 for(var8 = 0; var8 < var49; ++var8) {
                                    var58 = field528.method2532();
                                    if(255 == var58) {
                                       var58 = field528.method2551();
                                    }

                                    var71 = field528.method2508();
                                    if(null != var6 && var8 < var6.field2885.length) {
                                       var6.field2885[var8] = var71;
                                       var6.field2886[var8] = var58;
                                    }

                                    class89.method2076(var5, var8, var71 - 1, var58);
                                 }

                                 if(var6 != null) {
                                    class134.method2877(var6);
                                 }

                                 class168.method3372();
                                 field554[++field483 - 1 & 31] = var5 & 32767;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(173 == field301) {
                                 class26.method644(false);
                                 field528.method2751();
                                 var39 = field528.method2508();
                                 class26.method646(field528, var39);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              long var7;
                              long var64;
                              if(24 == field301) {
                                 var4 = field528.method2683();
                                 var41 = (long)field528.method2508();
                                 var7 = (long)field528.method2510();
                                 class152 var70 = (class152)class23.method606(class96.method2188(), field528.method2506());
                                 var64 = (var41 << 32) + var7;
                                 boolean var87 = false;

                                 for(var84 = 0; var84 < 100; ++var84) {
                                    if(var64 == field515[var84]) {
                                       var87 = true;
                                       break;
                                    }
                                 }

                                 if(class45.method991(var4)) {
                                    var87 = true;
                                 }

                                 if(!var87 && field414 == 0) {
                                    field515[field293] = var64;
                                    field293 = (field293 + 1) % 100;
                                    var88 = class223.method4103(class75.method1600(class106.method2377(field528)));
                                    byte var106;
                                    if(var70.field2291) {
                                       var106 = 7;
                                    } else {
                                       var106 = 3;
                                    }

                                    if(-1 != var70.field2284) {
                                       class103.method2289(var106, class134.method2878(var70.field2284) + var4, var88);
                                    } else {
                                       class103.method2289(var106, var4, var88);
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 41) {
                                 var4 = field528.method2683();
                                 var5 = field528.method2508();
                                 byte var55 = field528.method2524();
                                 var50 = false;
                                 if(-128 == var55) {
                                    var50 = true;
                                 }

                                 if(var50) {
                                    if(0 == class11.field189) {
                                       field301 = -1;
                                       var38 = true;
                                       break label3430;
                                    }

                                    boolean var56 = false;

                                    for(var8 = 0; var8 < class11.field189 && (!class8.field162[var8].field634.equals(var4) || class8.field162[var8].field627 != var5); ++var8) {
                                       ;
                                    }

                                    if(var8 < class11.field189) {
                                       while(var8 < class11.field189 - 1) {
                                          class8.field162[var8] = class8.field162[var8 + 1];
                                          ++var8;
                                       }

                                       --class11.field189;
                                       class8.field162[class11.field189] = null;
                                    }
                                 } else {
                                    field528.method2683();
                                    class24 var54 = new class24();
                                    var54.field634 = var4;
                                    var54.field628 = class142.method2997(var54.field634, class164.field2678);
                                    var54.field627 = var5;
                                    var54.field630 = var55;

                                    for(var58 = class11.field189 - 1; var58 >= 0; --var58) {
                                       var71 = class8.field162[var58].field628.compareTo(var54.field628);
                                       if(var71 == 0) {
                                          class8.field162[var58].field627 = var5;
                                          class8.field162[var58].field630 = var55;
                                          if(var4.equals(class167.field2692.field59)) {
                                             class157.field2502 = var55;
                                          }

                                          field472 = field491;
                                          field301 = -1;
                                          var38 = true;
                                          break label3430;
                                       }

                                       if(var71 < 0) {
                                          break;
                                       }
                                    }

                                    if(class11.field189 >= class8.field162.length) {
                                       field301 = -1;
                                       var38 = true;
                                       break label3430;
                                    }

                                    for(var71 = class11.field189 - 1; var71 > var58; --var71) {
                                       class8.field162[var71 + 1] = class8.field162[var71];
                                    }

                                    if(0 == class11.field189) {
                                       class8.field162 = new class24[100];
                                    }

                                    class8.field162[var58 + 1] = var54;
                                    ++class11.field189;
                                    if(var4.equals(class167.field2692.field59)) {
                                       class157.field2502 = var55;
                                    }
                                 }

                                 field472 = field491;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(174 == field301) {
                                 var4 = field528.method2683();
                                 var45 = class223.method4103(class75.method1600(class106.method2377(field528)));
                                 class103.method2289(6, var4, var45);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 9) {
                                 var39 = field528.method2506();
                                 if(field528.method2506() == 0) {
                                    field570[var39] = new class220();
                                    field528.field2011 += 18;
                                 } else {
                                    --field528.field2011;
                                    field570[var39] = new class220(field528, false);
                                 }

                                 field314 = field491;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 228) {
                                 field313 = field528.method2506();
                                 if(1 == field313) {
                                    field447 = field528.method2508();
                                 }

                                 if(field313 >= 2 && field313 <= 6) {
                                    if(field313 == 2) {
                                       field319 = 64;
                                       field547 = 64;
                                    }

                                    if(field313 == 3) {
                                       field319 = 0;
                                       field547 = 64;
                                    }

                                    if(field313 == 4) {
                                       field319 = 128;
                                       field547 = 64;
                                    }

                                    if(5 == field313) {
                                       field319 = 64;
                                       field547 = 0;
                                    }

                                    if(field313 == 6) {
                                       field319 = 64;
                                       field547 = 128;
                                    }

                                    field313 = 2;
                                    field316 = field528.method2508();
                                    field317 = field528.method2508();
                                    field502 = field528.method2506();
                                 }

                                 if(field313 == 10) {
                                    field406 = field528.method2508();
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              boolean var67;
                              if(field301 == 246) {
                                 field472 = field491;
                                 if(0 == field339) {
                                    field338 = null;
                                    field450 = null;
                                    class11.field189 = 0;
                                    class8.field162 = null;
                                    field301 = -1;
                                    var38 = true;
                                    break label3430;
                                 }

                                 field450 = field528.method2683();
                                 long var48 = field528.method2512();
                                 var7 = var48;
                                 if(var48 > 0L && var48 < 6582952005840035281L) {
                                    if(var48 % 37L == 0L) {
                                       var42 = null;
                                    } else {
                                       var58 = 0;

                                       for(var64 = var48; 0L != var64; var64 /= 37L) {
                                          ++var58;
                                       }

                                       StringBuilder var79 = new StringBuilder(var58);

                                       while(var7 != 0L) {
                                          var82 = var7;
                                          var7 /= 37L;
                                          var79.append(class162.field2670[(int)(var82 - 37L * var7)]);
                                       }

                                       var42 = var79.reverse().toString();
                                    }
                                 } else {
                                    var42 = null;
                                 }

                                 field338 = var42;
                                 class184.field3001 = field528.method2524();
                                 var58 = field528.method2506();
                                 if(255 == var58) {
                                    field301 = -1;
                                    var38 = true;
                                    break label3430;
                                 }

                                 class11.field189 = var58;
                                 class24[] var66 = new class24[100];

                                 for(var72 = 0; var72 < class11.field189; ++var72) {
                                    var66[var72] = new class24();
                                    var66[var72].field634 = field528.method2683();
                                    var66[var72].field628 = class142.method2997(var66[var72].field634, class164.field2678);
                                    var66[var72].field627 = field528.method2508();
                                    var66[var72].field630 = field528.method2524();
                                    field528.method2683();
                                    if(var66[var72].field634.equals(class167.field2692.field59)) {
                                       class157.field2502 = var66[var72].field630;
                                    }
                                 }

                                 var67 = false;
                                 var84 = class11.field189;

                                 while(var84 > 0) {
                                    var67 = true;
                                    --var84;

                                    for(int var102 = 0; var102 < var84; ++var102) {
                                       if(var66[var102].field628.compareTo(var66[1 + var102].field628) > 0) {
                                          class24 var85 = var66[var102];
                                          var66[var102] = var66[1 + var102];
                                          var66[var102 + 1] = var85;
                                          var67 = false;
                                       }
                                    }

                                    if(var67) {
                                       break;
                                    }
                                 }

                                 class8.field162 = var66;
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 97) {
                                 if(field454 != -1) {
                                    class39.method797(field454, 0);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 138) {
                                 var39 = field528.method2541();
                                 var5 = field528.method2508();
                                 var46 = field528.method2689();
                                 var63 = class52.method1115(var46);
                                 var63.field2823 = var5 + (var39 << 16);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 92) {
                                 field542 = true;
                                 class3.field78 = field528.method2506();
                                 class47.field1084 = field528.method2506();
                                 class12.field202 = field528.method2508();
                                 class137.field2143 = field528.method2506();
                                 class0.field13 = field528.method2506();
                                 if(class0.field13 >= 100) {
                                    class148.field2249 = 64 + class3.field78 * 128;
                                    class173.field2868 = 64 + class47.field1084 * 128;
                                    class156.field2333 = class43.method938(class148.field2249, class173.field2868, class82.field1437) - class12.field202;
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              boolean var14;
                              if(255 == field301) {
                                 while(field528.field2011 < field339) {
                                    var40 = field528.method2506() == 1;
                                    var45 = field528.method2683();
                                    var42 = field528.method2683();
                                    var49 = field528.method2508();
                                    var8 = field528.method2506();
                                    var58 = field528.method2506();
                                    boolean var10 = (var58 & 2) != 0;
                                    var67 = 0 != (var58 & 1);
                                    if(var49 > 0) {
                                       field528.method2683();
                                       field528.method2506();
                                       field528.method2511();
                                    }

                                    field528.method2683();

                                    for(var75 = 0; var75 < field561; ++var75) {
                                       class17 var13 = field474[var75];
                                       if(!var40) {
                                          if(var45.equals(var13.field260)) {
                                             if(var13.field255 != var49) {
                                                var14 = true;

                                                for(class38 var98 = (class38)field310.method3798(); var98 != null; var98 = (class38)field310.method3801()) {
                                                   if(var98.field877.equals(var45)) {
                                                      if(var49 != 0 && 0 == var98.field884) {
                                                         var98.method3929();
                                                         var14 = false;
                                                      } else if(0 == var49 && 0 != var98.field884) {
                                                         var98.method3929();
                                                         var14 = false;
                                                      }
                                                   }
                                                }

                                                if(var14) {
                                                   field310.method3797(new class38(var45, var49));
                                                }

                                                var13.field255 = var49;
                                             }

                                             var13.field254 = var42;
                                             var13.field261 = var8;
                                             var13.field257 = var10;
                                             var13.field258 = var67;
                                             var45 = null;
                                             break;
                                          }
                                       } else if(var42.equals(var13.field260)) {
                                          var13.field260 = var45;
                                          var13.field254 = var42;
                                          var45 = null;
                                          break;
                                       }
                                    }

                                    if(var45 != null && field561 < 400) {
                                       class17 var78 = new class17();
                                       field474[field561] = var78;
                                       var78.field260 = var45;
                                       var78.field254 = var42;
                                       var78.field255 = var49;
                                       var78.field261 = var8;
                                       var78.field257 = var10;
                                       var78.field258 = var67;
                                       ++field561;
                                    }
                                 }

                                 field562 = 2;
                                 field572 = field491;
                                 var40 = false;
                                 var5 = field561;

                                 while(var5 > 0) {
                                    var40 = true;
                                    --var5;

                                    for(var46 = 0; var46 < var5; ++var46) {
                                       var50 = false;
                                       class17 var53 = field474[var46];
                                       class17 var59 = field474[1 + var46];
                                       if(var53.field255 != field296 && var59.field255 == field296) {
                                          var50 = true;
                                       }

                                       if(!var50 && 0 == var53.field255 && var59.field255 != 0) {
                                          var50 = true;
                                       }

                                       if(!var50 && !var53.field257 && var59.field257) {
                                          var50 = true;
                                       }

                                       if(!var50 && !var53.field258 && var59.field258) {
                                          var50 = true;
                                       }

                                       if(var50) {
                                          class17 var62 = field474[var46];
                                          field474[var46] = field474[1 + var46];
                                          field474[var46 + 1] = var62;
                                          var40 = false;
                                       }
                                    }

                                    if(var40) {
                                       break;
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 126) {
                                 var39 = field528.method2663();
                                 var43 = class52.method1115(var39);
                                 var43.field2810 = 3;
                                 var43.field2811 = class167.field2692.field47.method3490();
                                 class134.method2877(var43);
                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 71) {
                                 var39 = field528.method2600();
                                 var5 = field528.method2663();
                                 var6 = class52.method1115(var5);
                                 if(2 != var6.field2810 || var6.field2811 != var39) {
                                    var6.field2810 = 2;
                                    var6.field2811 = var39;
                                    class134.method2877(var6);
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              if(field301 == 116) {
                                 var4 = field528.method2683();
                                 var41 = field528.method2512();
                                 var7 = (long)field528.method2508();
                                 var9 = (long)field528.method2510();
                                 class152 var11 = (class152)class23.method606(class96.method2188(), field528.method2506());
                                 var12 = var9 + (var7 << 32);
                                 var14 = false;

                                 for(var15 = 0; var15 < 100; ++var15) {
                                    if(var12 == field515[var15]) {
                                       var14 = true;
                                       break;
                                    }
                                 }

                                 if(var11.field2292 && class45.method991(var4)) {
                                    var14 = true;
                                 }

                                 if(!var14 && field414 == 0) {
                                    field515[field293] = var12;
                                    field293 = (1 + field293) % 100;
                                    String var95 = class223.method4103(class75.method1600(class106.method2377(field528)));
                                    if(-1 != var11.field2284) {
                                       class104.method2293(9, class134.method2878(var11.field2284) + var4, var95, class104.method2296(var41));
                                    } else {
                                       class104.method2293(9, var4, var95, class104.method2296(var41));
                                    }
                                 }

                                 field301 = -1;
                                 var38 = true;
                                 break label3430;
                              }

                              class0.method0("" + field301 + "," + field344 + "," + field345 + "," + field339, (Throwable)null);
                              class38.method785();
                           } catch (IOException var34) {
                              class3.method44();
                           } catch (Exception var35) {
                              var4 = "" + field301 + "," + field344 + "," + field345 + "," + field339 + "," + (class41.field990 + class167.field2692.field872[0]) + "," + (class167.field2692.field873[0] + class2.field37) + ",";

                              for(var5 = 0; var5 < field339 && var5 < 50; ++var5) {
                                 var4 = var4 + field528.field2012[var5] + ",";
                              }

                              class0.method0(var4, var35);
                              class38.method785();
                           }

                           var38 = true;
                        }
                     }

                     if(!var38) {
                        break;
                     }
                  }

                  if(field303 == 30) {
                     while(class167.method3349()) {
                        field318.method2757(122);
                        field318.method2573(0);
                        var37 = field318.field2011;
                        class2.method41(field318);
                        field318.method2635(field318.field2011 - var37);
                     }

                     Object var44 = class150.field2275.field207;
                     int var125;
                     synchronized(class150.field2275.field207) {
                        if(!field379) {
                           class150.field2275.field206 = 0;
                        } else if(class140.field2177 != 0 || class150.field2275.field206 >= 40) {
                           field318.method2757(180);
                           field318.method2573(0);
                           var125 = field318.field2011;
                           var3 = 0;

                           for(var39 = 0; var39 < class150.field2275.field206 && field318.field2011 - var125 < 240; ++var39) {
                              ++var3;
                              var5 = class150.field2275.field210[var39];
                              if(var5 < 0) {
                                 var5 = 0;
                              } else if(var5 > 502) {
                                 var5 = 502;
                              }

                              var46 = class150.field2275.field209[var39];
                              if(var46 < 0) {
                                 var46 = 0;
                              } else if(var46 > 764) {
                                 var46 = 764;
                              }

                              var49 = var5 * 765 + var46;
                              if(-1 == class150.field2275.field210[var39] && class150.field2275.field209[var39] == -1) {
                                 var46 = -1;
                                 var5 = -1;
                                 var49 = 524287;
                              }

                              if(field307 == var46 && field434 == var5) {
                                 if(field357 < 2047) {
                                    ++field357;
                                 }
                              } else {
                                 var8 = var46 - field307;
                                 field307 = var46;
                                 var58 = var5 - field434;
                                 field434 = var5;
                                 if(field357 < 8 && var8 >= -32 && var8 <= 31 && var58 >= -32 && var58 <= 31) {
                                    var8 += 32;
                                    var58 += 32;
                                    field318.method2492(var58 + (field357 << 12) + (var8 << 6));
                                    field357 = 0;
                                 } else if(field357 < 8) {
                                    field318.method2653(8388608 + (field357 << 19) + var49);
                                    field357 = 0;
                                 } else {
                                    field318.method2494(var49 + -1073741824 + (field357 << 19));
                                    field357 = 0;
                                 }
                              }
                           }

                           field318.method2635(field318.field2011 - var125);
                           if(var3 >= class150.field2275.field206) {
                              class150.field2275.field206 = 0;
                           } else {
                              class150.field2275.field206 -= var3;

                              for(var39 = 0; var39 < class150.field2275.field206; ++var39) {
                                 class150.field2275.field209[var39] = class150.field2275.field209[var3 + var39];
                                 class150.field2275.field210[var39] = class150.field2275.field210[var3 + var39];
                              }
                           }
                        }
                     }

                     if(class140.field2177 == 1 || !class39.field922 && class140.field2177 == 4 || class140.field2177 == 2) {
                        long var47 = (class140.field2178 - field431) / 50L;
                        if(var47 > 4095L) {
                           var47 = 4095L;
                        }

                        field431 = class140.field2178;
                        var3 = class140.field2167;
                        if(var3 < 0) {
                           var3 = 0;
                        } else if(var3 > class15.field233) {
                           var3 = class15.field233;
                        }

                        var39 = class140.field2176;
                        if(var39 < 0) {
                           var39 = 0;
                        } else if(var39 > class15.field235) {
                           var39 = class15.field235;
                        }

                        var5 = (int)var47;
                        field318.method2757(195);
                        field318.method2492((var5 << 1) + (2 == class140.field2177?1:0));
                        field318.method2492(var39);
                        field318.method2492(var3);
                     }

                     if(class137.field2137 > 0) {
                        field318.method2757(140);
                        field318.method2492(0);
                        var37 = field318.field2011;
                        long var126 = class14.method165();

                        for(var39 = 0; var39 < class137.field2137; ++var39) {
                           var41 = var126 - field520;
                           if(var41 > 16777215L) {
                              var41 = 16777215L;
                           }

                           field520 = var126;
                           field318.method2491((int)var41);
                           field318.method2573(class137.field2130[var39]);
                        }

                        field318.method2589(field318.field2011 - var37);
                     }

                     if(field385 > 0) {
                        --field385;
                     }

                     if(class137.field2135[96] || class137.field2135[97] || class137.field2135[98] || class137.field2135[99]) {
                        field386 = true;
                     }

                     if(field386 && field385 <= 0) {
                        field385 = 20;
                        field386 = false;
                        field318.method2757(121);
                        field318.method2540(field378);
                        field318.method2539(field388);
                     }

                     if(class136.field2103 && !field430) {
                        field430 = true;
                        field318.method2757(225);
                        field318.method2573(1);
                     }

                     if(!class136.field2103 && field430) {
                        field430 = false;
                        field318.method2757(225);
                        field318.method2573(0);
                     }

                     class47.method1015();
                     if(field303 == 30) {
                        for(class16 var51 = (class16)field482.method3836(); null != var51; var51 = (class16)field482.method3841()) {
                           if(var51.field247 > 0) {
                              --var51.field247;
                           }

                           if(var51.field247 == 0) {
                              if(var51.field240 < 0 || class143.method3020(var51.field240, var51.field242)) {
                                 class98.method2189(var51.field243, var51.field249, var51.field238, var51.field239, var51.field240, var51.field241, var51.field242);
                                 var51.method3935();
                              }
                           } else {
                              if(var51.field246 > 0) {
                                 --var51.field246;
                              }

                              if(0 == var51.field246 && var51.field238 >= 1 && var51.field239 >= 1 && var51.field238 <= 102 && var51.field239 <= 102 && (var51.field250 < 0 || class143.method3020(var51.field250, var51.field245))) {
                                 class98.method2189(var51.field243, var51.field249, var51.field238, var51.field239, var51.field250, var51.field251, var51.field245);
                                 var51.field246 = -1;
                                 if(var51.field250 == var51.field240 && var51.field240 == -1) {
                                    var51.method3935();
                                 } else if(var51.field250 == var51.field240 && var51.field241 == var51.field251 && var51.field242 == var51.field245) {
                                    var51.method3935();
                                 }
                              }
                           }
                        }

                        for(var37 = 0; var37 < field536; ++var37) {
                           --field543[var37];
                           if(field543[var37] >= -10) {
                              class58 var127 = field552[var37];
                              if(var127 == null) {
                                 class58 var133 = (class58)null;
                                 var127 = class58.method1254(class47.field1086, field350[var37], 0);
                                 if(var127 == null) {
                                    continue;
                                 }

                                 field543[var37] += var127.method1265();
                                 field552[var37] = var127;
                              }

                              if(field543[var37] < 0) {
                                 if(0 != field540[var37]) {
                                    var39 = 128 * (field540[var37] & 255);
                                    var5 = field540[var37] >> 16 & 255;
                                    var46 = 64 + var5 * 128 - class167.field2692.field849;
                                    if(var46 < 0) {
                                       var46 = -var46;
                                    }

                                    var49 = field540[var37] >> 8 & 255;
                                    var8 = 64 + 128 * var49 - class167.field2692.field819;
                                    if(var8 < 0) {
                                       var8 = -var8;
                                    }

                                    var58 = var46 + var8 - 128;
                                    if(var58 > var39) {
                                       field543[var37] = -100;
                                       continue;
                                    }

                                    if(var58 < 0) {
                                       var58 = 0;
                                    }

                                    var3 = (var39 - var58) * field535 / var39;
                                 } else {
                                    var3 = field534;
                                 }

                                 if(var3 > 0) {
                                    class62 var128 = var127.method1264().method1295(class3.field73);
                                    class64 var122 = class64.method1318(var128, 100, var3);
                                    var122.method1322(field538[var37] - 1);
                                    class72.field1353.method1188(var122);
                                 }

                                 field543[var37] = -100;
                              }
                           } else {
                              --field536;

                              for(var125 = var37; var125 < field536; ++var125) {
                                 field350[var125] = field350[1 + var125];
                                 field552[var125] = field552[var125 + 1];
                                 field538[var125] = field538[1 + var125];
                                 field543[var125] = field543[var125 + 1];
                                 field540[var125] = field540[1 + var125];
                              }

                              --var37;
                           }
                        }

                        if(field496) {
                           boolean var60;
                           if(0 != class183.field2968) {
                              var60 = true;
                           } else {
                              var60 = class183.field2967.method3622();
                           }

                           if(!var60) {
                              if(0 != field369 && field532 != -1) {
                                 class39.method819(class19.field289, field532, 0, field369, false);
                              }

                              field496 = false;
                           }
                        }

                        ++field341;
                        if(field341 > 750) {
                           class3.method44();
                        } else {
                           class154.method3187();
                           class16.method182();
                           int[] var65 = class32.field757;

                           for(var125 = 0; var125 < class32.field751; ++var125) {
                              class2 var52 = field415[var65[var125]];
                              if(var52 != null && var52.field834 > 0) {
                                 --var52.field834;
                                 if(var52.field834 == 0) {
                                    var52.field831 = null;
                                 }
                              }
                           }

                           for(var125 = 0; var125 < field332; ++var125) {
                              var3 = field333[var125];
                              class34 var130 = field331[var3];
                              if(var130 != null && var130.field834 > 0) {
                                 --var130.field834;
                                 if(var130.field834 == 0) {
                                    var130.field831 = null;
                                 }
                              }
                           }

                           ++field370;
                           if(0 != field405) {
                              field438 += 20;
                              if(field438 >= 400) {
                                 field405 = 0;
                              }
                           }

                           if(null != class52.field1167) {
                              ++field494;
                              if(field494 >= 15) {
                                 class134.method2877(class52.field1167);
                                 class52.field1167 = null;
                              }
                           }

                           class173 var68 = class99.field1693;
                           class173 var129 = class0.field12;
                           class99.field1693 = null;
                           class0.field12 = null;
                           field352 = null;
                           field475 = false;
                           field382 = false;
                           field517 = 0;

                           while(true) {
                              while(class124.method2790() && field517 < 128) {
                                 if(field461 >= 2 && class137.field2135[82] && class137.field2118 == 66) {
                                    var4 = "";

                                    class35 var120;
                                    for(Iterator var124 = class11.field186.iterator(); var124.hasNext(); var4 = var4 + var120.field796 + ':' + var120.field792 + '\n') {
                                       var120 = (class35)var124.next();
                                    }

                                    class2.field65.setContents(new StringSelection(var4), (ClipboardOwner)null);
                                 } else {
                                    field519[field517] = class137.field2118;
                                    field399[field517] = class33.field772;
                                    ++field517;
                                 }
                              }

                              if(field454 != -1) {
                                 var3 = field454;
                                 var39 = class15.field235;
                                 var5 = class15.field233;
                                 if(class39.method817(var3)) {
                                    class2.method40(class173.field2830[var3], -1, 0, 0, var39, var5, 0, 0);
                                 }
                              }

                              ++field491;

                              while(true) {
                                 class0 var57;
                                 class173 var131;
                                 do {
                                    var57 = (class0)field359.method3837();
                                    if(null == var57) {
                                       while(true) {
                                          do {
                                             var57 = (class0)field489.method3837();
                                             if(var57 == null) {
                                                while(true) {
                                                   do {
                                                      var57 = (class0)field493.method3837();
                                                      if(null == var57) {
                                                         class9.method122();
                                                         if(null != field353) {
                                                            class167.method3358();
                                                         }

                                                         if(null != class9.field175) {
                                                            class134.method2877(class9.field175);
                                                            ++field550;
                                                            if(class140.field2184 != 0) {
                                                               if(field550 >= 5 && (class140.field2168 > field467 + 5 || class140.field2168 < field467 - 5 || class140.field2182 > 5 + field308 || class140.field2182 < field308 - 5)) {
                                                                  field412 = true;
                                                               }
                                                            } else {
                                                               if(field412) {
                                                                  if(class35.field790 == class9.field175 && field408 != field541) {
                                                                     class173 var61 = class9.field175;
                                                                     byte var132 = 0;
                                                                     if(field544 == 1 && 206 == var61.field2890) {
                                                                        var132 = 1;
                                                                     }

                                                                     if(var61.field2885[field541] <= 0) {
                                                                        var132 = 0;
                                                                     }

                                                                     var46 = class169.method3395(var61);
                                                                     var69 = (var46 >> 29 & 1) != 0;
                                                                     if(var69) {
                                                                        var49 = field408;
                                                                        var8 = field541;
                                                                        var61.field2885[var8] = var61.field2885[var49];
                                                                        var61.field2886[var8] = var61.field2886[var49];
                                                                        var61.field2885[var49] = -1;
                                                                        var61.field2886[var49] = 0;
                                                                     } else if(var132 == 1) {
                                                                        var49 = field408;
                                                                        var8 = field541;

                                                                        while(var49 != var8) {
                                                                           if(var49 > var8) {
                                                                              var61.method3419(var49 - 1, var49);
                                                                              --var49;
                                                                           } else if(var49 < var8) {
                                                                              var61.method3419(1 + var49, var49);
                                                                              ++var49;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var61.method3419(field541, field408);
                                                                     }

                                                                     field318.method2757(230);
                                                                     field318.method2492(field408);
                                                                     field318.method2492(field541);
                                                                     field318.method2530(var132);
                                                                     field318.method2549(class9.field175.field2838);
                                                                  }
                                                               } else if((1 == field432 || class170.method3396(field435 - 1)) && field435 > 2) {
                                                                  class116.method2456(field467, field308);
                                                               } else if(field435 > 0) {
                                                                  class17.method187(field467, field308);
                                                               }

                                                               field494 = 10;
                                                               class140.field2177 = 0;
                                                               class9.field175 = null;
                                                            }
                                                         }

                                                         if(-1 != class86.field1504) {
                                                            var3 = class86.field1504;
                                                            var39 = class86.field1505;
                                                            field318.method2757(111);
                                                            field318.method2573(5);
                                                            field318.method2573(class137.field2135[82]?(class137.field2135[81]?2:1):0);
                                                            field318.method2538(var39 + class2.field37);
                                                            field318.method2540(var3 + class41.field990);
                                                            class86.field1504 = -1;
                                                            field402 = class140.field2176;
                                                            field403 = class140.field2167;
                                                            field405 = 1;
                                                            field438 = 0;
                                                            field533 = var3;
                                                            field529 = var39;
                                                         }

                                                         if(var68 != class99.field1693) {
                                                            if(var68 != null) {
                                                               class134.method2877(var68);
                                                            }

                                                            if(null != class99.field1693) {
                                                               class134.method2877(class99.field1693);
                                                            }
                                                         }

                                                         if(class0.field12 != var129 && field445 == field444) {
                                                            if(var129 != null) {
                                                               class134.method2877(var129);
                                                            }

                                                            if(null != class0.field12) {
                                                               class134.method2877(class0.field12);
                                                            }
                                                         }

                                                         if(null != class0.field12) {
                                                            if(field444 < field445) {
                                                               ++field444;
                                                               if(field444 == field445) {
                                                                  class134.method2877(class0.field12);
                                                               }
                                                            }
                                                         } else if(field444 > 0) {
                                                            --field444;
                                                         }

                                                         var3 = class167.field2692.field849 + field358;
                                                         var39 = field360 + class167.field2692.field819;
                                                         if(class90.field1567 - var3 < -500 || class90.field1567 - var3 > 500 || class96.field1643 - var39 < -500 || class96.field1643 - var39 > 500) {
                                                            class90.field1567 = var3;
                                                            class96.field1643 = var39;
                                                         }

                                                         if(class90.field1567 != var3) {
                                                            class90.field1567 += (var3 - class90.field1567) / 16;
                                                         }

                                                         if(var39 != class96.field1643) {
                                                            class96.field1643 += (var39 - class96.field1643) / 16;
                                                         }

                                                         if(4 == class140.field2184 && class39.field922) {
                                                            var5 = class140.field2182 - field518;
                                                            field539 = var5 * 2;
                                                            field518 = var5 != -1 && var5 != 1?(class140.field2182 + field518) / 2:class140.field2182;
                                                            var46 = field355 - class140.field2168;
                                                            field380 = var46 * 2;
                                                            field355 = var46 != -1 && var46 != 1?(field355 + class140.field2168) / 2:class140.field2168;
                                                         } else {
                                                            if(class137.field2135[96]) {
                                                               field380 += (-24 - field380) / 2;
                                                            } else if(class137.field2135[97]) {
                                                               field380 += (24 - field380) / 2;
                                                            } else {
                                                               field380 /= 2;
                                                            }

                                                            if(class137.field2135[98]) {
                                                               field539 += (12 - field539) / 2;
                                                            } else if(class137.field2135[99]) {
                                                               field539 += (-12 - field539) / 2;
                                                            } else {
                                                               field539 /= 2;
                                                            }

                                                            field518 = class140.field2182;
                                                            field355 = class140.field2168;
                                                         }

                                                         field388 = field388 + field380 / 2 & 2047;
                                                         field378 += field539 / 2;
                                                         if(field378 < 128) {
                                                            field378 = 128;
                                                         }

                                                         if(field378 > 383) {
                                                            field378 = 383;
                                                         }

                                                         var5 = class90.field1567 >> 7;
                                                         var46 = class96.field1643 >> 7;
                                                         var49 = class43.method938(class90.field1567, class96.field1643, class82.field1437);
                                                         var8 = 0;
                                                         if(var5 > 3 && var46 > 3 && var5 < 100 && var46 < 100) {
                                                            for(var58 = var5 - 4; var58 <= 4 + var5; ++var58) {
                                                               for(var71 = var46 - 4; var71 <= var46 + 4; ++var71) {
                                                                  var72 = class82.field1437;
                                                                  if(var72 < 3 && (class5.field109[1][var58][var71] & 2) == 2) {
                                                                     ++var72;
                                                                  }

                                                                  var75 = var49 - class5.field96[var72][var58][var71];
                                                                  if(var75 > var8) {
                                                                     var8 = var75;
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         var58 = var8 * 192;
                                                         if(var58 > 98048) {
                                                            var58 = 98048;
                                                         }

                                                         if(var58 < '耀') {
                                                            var58 = '耀';
                                                         }

                                                         if(var58 > field387) {
                                                            field387 += (var58 - field387) / 24;
                                                         } else if(var58 < field387) {
                                                            field387 += (var58 - field387) / 80;
                                                         }

                                                         if(field542) {
                                                            class12.method159();
                                                         }

                                                         for(var3 = 0; var3 < 5; ++var3) {
                                                            ++field349[var3];
                                                         }

                                                         class74.field1375.method204();
                                                         var3 = class8.method111();
                                                         var39 = class137.field2141;
                                                         if(var3 > 15000 && var39 > 15000) {
                                                            field346 = 250;
                                                            class142.method2994(14500);
                                                            field318.method2757(113);
                                                         }

                                                         ++field364;
                                                         if(field364 > 500) {
                                                            field364 = 0;
                                                            var46 = (int)(Math.random() * 8.0D);
                                                            if(1 == (var46 & 1)) {
                                                               field358 += field485;
                                                            }

                                                            if(2 == (var46 & 2)) {
                                                               field360 += field488;
                                                            }

                                                            if((var46 & 4) == 4) {
                                                               field362 += field363;
                                                            }
                                                         }

                                                         if(field358 < -50) {
                                                            field485 = 2;
                                                         }

                                                         if(field358 > 50) {
                                                            field485 = -2;
                                                         }

                                                         if(field360 < -55) {
                                                            field488 = 2;
                                                         }

                                                         if(field360 > 55) {
                                                            field488 = -2;
                                                         }

                                                         if(field362 < -40) {
                                                            field363 = 1;
                                                         }

                                                         if(field362 > 40) {
                                                            field363 = -1;
                                                         }

                                                         ++field411;
                                                         if(field411 > 500) {
                                                            field411 = 0;
                                                            var46 = (int)(Math.random() * 8.0D);
                                                            if((var46 & 1) == 1) {
                                                               field365 += field417;
                                                            }

                                                            if((var46 & 2) == 2) {
                                                               field367 += field368;
                                                            }
                                                         }

                                                         if(field365 < -60) {
                                                            field417 = 2;
                                                         }

                                                         if(field365 > 60) {
                                                            field417 = -2;
                                                         }

                                                         if(field367 < -20) {
                                                            field368 = 1;
                                                         }

                                                         if(field367 > 10) {
                                                            field368 = -1;
                                                         }

                                                         for(class38 var121 = (class38)field310.method3798(); null != var121; var121 = (class38)field310.method3801()) {
                                                            if((long)var121.field881 < class14.method165() / 1000L - 5L) {
                                                               if(var121.field884 > 0) {
                                                                  class103.method2289(5, "", var121.field877 + " has logged in.");
                                                               }

                                                               if(0 == var121.field884) {
                                                                  class103.method2289(5, "", var121.field877 + " has logged out.");
                                                               }

                                                               var121.method3929();
                                                            }
                                                         }

                                                         ++field342;
                                                         if(field342 > 50) {
                                                            field318.method2757(249);
                                                         }

                                                         try {
                                                            if(class9.field173 != null && field318.field2011 > 0) {
                                                               class9.field173.method3002(field318.field2012, 0, field318.field2011);
                                                               field318.field2011 = 0;
                                                               field342 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var25) {
                                                            class3.method44();
                                                         }

                                                         return;
                                                      }

                                                      var131 = var57.field2;
                                                      if(var131.field2802 < 0) {
                                                         break;
                                                      }

                                                      var43 = class52.method1115(var131.field2786);
                                                   } while(var43 == null || var43.field2891 == null || var131.field2802 >= var43.field2891.length || var43.field2891[var131.field2802] != var131);

                                                   class3.method48(var57);
                                                }
                                             }

                                             var131 = var57.field2;
                                             if(var131.field2802 < 0) {
                                                break;
                                             }

                                             var43 = class52.method1115(var131.field2786);
                                          } while(var43 == null || null == var43.field2891 || var131.field2802 >= var43.field2891.length || var43.field2891[var131.field2802] != var131);

                                          class3.method48(var57);
                                       }
                                    }

                                    var131 = var57.field2;
                                    if(var131.field2802 < 0) {
                                       break;
                                    }

                                    var43 = class52.method1115(var131.field2786);
                                 } while(var43 == null || null == var43.field2891 || var131.field2802 >= var43.field2891.length || var43.field2891[var131.field2802] != var131);

                                 class3.method48(var57);
                              }
                           }
                        }
                     }
                  }
               }
            } else if(40 == field303 || 45 == field303) {
               class75.method1626();
            }

            return;
         }

         var1.field2720.method3368(var1.field2722, (int)var1.field3123, var1.field2721, false);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-571028762"
   )
   protected final void vmethod3103() {
      boolean var1;
      label229: {
         try {
            if(class183.field2968 == 2) {
               if(null == class159.field2623) {
                  class159.field2623 = class180.method3534(class151.field2279, class72.field1358, class183.field2964);
                  if(class159.field2623 == null) {
                     var1 = false;
                     break label229;
                  }
               }

               if(null == class5.field95) {
                  class5.field95 = new class59(class183.field2966, class183.field2965);
               }

               if(class183.field2967.method3722(class159.field2623, class183.field2969, class5.field95, 22050)) {
                  class183.field2967.method3618();
                  class183.field2967.method3615(class183.field2970);
                  class183.field2967.method3694(class159.field2623, class14.field225);
                  class183.field2968 = 0;
                  class159.field2623 = null;
                  class5.field95 = null;
                  class151.field2279 = null;
                  var1 = true;
                  break label229;
               }
            }
         } catch (Exception var16) {
            var16.printStackTrace();
            class183.field2967.method3652();
            class183.field2968 = 0;
            class159.field2623 = null;
            class5.field95 = null;
            class151.field2279 = null;
         }

         var1 = false;
      }

      if(var1 && field496 && class17.field253 != null) {
         class17.field253.method1196();
      }

      if(10 == field303 || 20 == field303 || field303 == 30) {
         if(0L != field507 && class14.method165() > field507) {
            class15.method171(class44.method979());
         } else if(class144.field2229) {
            class46.method998();
         }
      }

      Dimension var3 = this.method3040();
      if(var3.width != class16.field252 || var3.height != class90.field1568 || class144.field2225) {
         class31.method698();
         field507 = class14.method165() + 500L;
         class144.field2225 = false;
      }

      boolean var4 = false;
      int var5;
      if(class144.field2223) {
         class144.field2223 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field499[var5] = true;
         }
      }

      if(var4) {
         class36.method766();
      }

      if(0 == field303) {
         var5 = class31.field727;
         String var6 = class31.field728;
         Color var7 = null;

         try {
            Graphics var8 = class87.field1537.getGraphics();
            if(class22.field606 == null) {
               class22.field606 = new Font("Helvetica", 1, 13);
               class13.field212 = class87.field1537.getFontMetrics(class22.field606);
            }

            if(var4) {
               var8.setColor(Color.black);
               var8.fillRect(0, 0, class15.field235, class15.field233);
            }

            if(null == var7) {
               var7 = new Color(140, 17, 17);
            }

            try {
               if(class109.field1916 == null) {
                  class109.field1916 = class87.field1537.createImage(304, 34);
               }

               Graphics var9 = class109.field1916.getGraphics();
               var9.setColor(var7);
               var9.drawRect(0, 0, 303, 33);
               var9.fillRect(2, 2, var5 * 3, 30);
               var9.setColor(Color.black);
               var9.drawRect(1, 1, 301, 31);
               var9.fillRect(2 + var5 * 3, 2, 300 - 3 * var5, 30);
               var9.setFont(class22.field606);
               var9.setColor(Color.white);
               var9.drawString(var6, (304 - class13.field212.stringWidth(var6)) / 2, 22);
               var8.drawImage(class109.field1916, class15.field235 / 2 - 152, class15.field233 / 2 - 18, (ImageObserver)null);
            } catch (Exception var12) {
               int var10 = class15.field235 / 2 - 152;
               int var11 = class15.field233 / 2 - 18;
               var8.setColor(var7);
               var8.drawRect(var10, var11, 303, 33);
               var8.fillRect(2 + var10, 2 + var11, var5 * 3, 30);
               var8.setColor(Color.black);
               var8.drawRect(1 + var10, 1 + var11, 301, 31);
               var8.fillRect(2 + var10 + var5 * 3, var11 + 2, 300 - 3 * var5, 30);
               var8.setFont(class22.field606);
               var8.setColor(Color.white);
               var8.drawString(var6, var10 + (304 - class13.field212.stringWidth(var6)) / 2, 22 + var11);
            }
         } catch (Exception var13) {
            class87.field1537.repaint();
         }
      } else if(field303 == 5) {
         class48.method1026(class89.field1561, class104.field1807, class3.field76, var4);
      } else if(10 != field303 && 11 != field303) {
         if(field303 == 20) {
            class48.method1026(class89.field1561, class104.field1807, class3.field76, var4);
         } else if(field303 == 25) {
            if(field524 == 1) {
               if(field348 > field530) {
                  field530 = field348;
               }

               var5 = (field530 * 50 - field348 * 50) / field530;
               class19.method228("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(2 == field524) {
               if(field563 > field351) {
                  field351 = field563;
               }

               var5 = 50 + (field351 * 50 - field563 * 50) / field351;
               class19.method228("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class19.method228("Loading - please wait.", false);
            }
         } else if(field303 == 30) {
            class129.method2830();
         } else if(field303 == 40) {
            class19.method228("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(45 == field303) {
            class19.method228("Please wait...", false);
         }
      } else {
         class48.method1026(class89.field1561, class104.field1807, class3.field76, var4);
      }

      int var17;
      Graphics var18;
      if(field303 == 30 && 0 == field506 && !var4) {
         try {
            var18 = class87.field1537.getGraphics();

            for(var17 = 0; var17 < field497; ++var17) {
               if(field500[var17]) {
                  class42.field991.vmethod1871(var18, field361[var17], field486[var17], field558[var17], field505[var17]);
                  field500[var17] = false;
               }
            }
         } catch (Exception var15) {
            class87.field1537.repaint();
         }
      } else if(field303 > 0) {
         try {
            var18 = class87.field1537.getGraphics();
            class42.field991.vmethod1870(var18, 0, 0);

            for(var17 = 0; var17 < field497; ++var17) {
               field500[var17] = false;
            }
         } catch (Exception var14) {
            class87.field1537.repaint();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   void method241() {
      if(class171.field2753 >= 4) {
         this.method3093("js5crc");
         field303 = 1000;
      } else {
         if(class171.field2750 >= 4) {
            if(field303 <= 5) {
               this.method3093("js5io");
               field303 = 1000;
               return;
            }

            field325 = 3000;
            class171.field2750 = 3;
         }

         if(--field325 + 1 <= 0) {
            try {
               if(0 == field324) {
                  class102.field1775 = class123.field2036.method2885(class107.field1891, class93.field1607);
                  ++field324;
               }

               if(1 == field324) {
                  if(class102.field1775.field2235 == 2) {
                     this.method242(-1);
                     return;
                  }

                  if(1 == class102.field1775.field2235) {
                     ++field324;
                  }
               }

               if(field324 == 2) {
                  class107.field1886 = new class143((Socket)class102.field1775.field2234, class123.field2036);
                  class119 var1 = new class119(5);
                  var1.method2573(15);
                  var1.method2494(110);
                  class107.field1886.method3002(var1.field2012, 0, 5);
                  ++field324;
                  class148.field2250 = class14.method165();
               }

               if(field324 == 3) {
                  if(field303 > 5 && class107.field1886.method3000() <= 0) {
                     if(class14.method165() - class148.field2250 > 30000L) {
                        this.method242(-2);
                        return;
                     }
                  } else {
                     int var9 = class107.field1886.method2999();
                     if(0 != var9) {
                        this.method242(var9);
                        return;
                     }

                     ++field324;
                  }
               }

               if(field324 == 4) {
                  class143 var10 = class107.field1886;
                  boolean var2 = field303 > 20;
                  if(class171.field2742 != null) {
                     try {
                        class171.field2742.method3005();
                     } catch (Exception var7) {
                        ;
                     }

                     class171.field2742 = null;
                  }

                  class171.field2742 = var10;
                  class77.method1685(var2);
                  class171.field2733.field2011 = 0;
                  class21.field590 = null;
                  class13.field213 = null;
                  class171.field2745 = 0;

                  while(true) {
                     class172 var3 = (class172)class171.field2749.method3805();
                     if(var3 == null) {
                        while(true) {
                           var3 = (class172)class171.field2734.method3805();
                           if(null == var3) {
                              if(class171.field2748 != 0) {
                                 try {
                                    class119 var11 = new class119(4);
                                    var11.method2573(4);
                                    var11.method2573(class171.field2748);
                                    var11.method2492(0);
                                    class171.field2742.method3002(var11.field2012, 0, 4);
                                 } catch (IOException var6) {
                                    try {
                                       class171.field2742.method3005();
                                    } catch (Exception var5) {
                                       ;
                                    }

                                    ++class171.field2750;
                                    class171.field2742 = null;
                                 }
                              }

                              class171.field2735 = 0;
                              class142.field2198 = class14.method165();
                              class102.field1775 = null;
                              class107.field1886 = null;
                              field324 = 0;
                              field326 = 0;
                              return;
                           }

                           class171.field2741.method3907(var3);
                           class171.field2738.method3807(var3, var3.field3123);
                           ++class171.field2740;
                           --class171.field2736;
                        }
                     }

                     class171.field2752.method3807(var3, var3.field3123);
                     ++class171.field2739;
                     --class171.field2737;
                  }
               }
            } catch (IOException var8) {
               this.method242(-3);
            }

         }
      }
   }

   @ObfuscatedName("z")
   void method242(int var1) {
      class102.field1775 = null;
      class107.field1886 = null;
      field324 = 0;
      if(class21.field592 == class93.field1607) {
         class93.field1607 = class18.field267;
      } else {
         class93.field1607 = class21.field592;
      }

      ++field326;
      if(field326 >= 2 && (var1 == 7 || var1 == 9)) {
         if(field303 <= 5) {
            this.method3093("js5connect_full");
            field303 = 1000;
         } else {
            field325 = 3000;
         }
      } else if(field326 >= 2 && var1 == 6) {
         this.method3093("js5connect_outofdate");
         field303 = 1000;
      } else if(field326 >= 4) {
         if(field303 <= 5) {
            this.method3093("js5connect");
            field303 = 1000;
         } else {
            field325 = 3000;
         }
      }

   }

   static {
      field321 = class20.field586;
      field322 = class20.field586;
      field323 = 0;
      field324 = 0;
      field325 = 0;
      field326 = 0;
      field327 = 0;
      field328 = 0;
      field336 = 0;
      field330 = 0;
      field331 = new class34['耀'];
      field332 = 0;
      field333 = new int['耀'];
      field504 = 0;
      field395 = new int[250];
      field318 = new class122(5000);
      field337 = new class122(5000);
      field528 = new class122(15000);
      field339 = 0;
      field301 = 0;
      field341 = 0;
      field342 = 0;
      field343 = 0;
      field344 = 0;
      field345 = 0;
      field346 = 0;
      field347 = false;
      field348 = 0;
      field530 = 1;
      field563 = 0;
      field351 = 1;
      field524 = 0;
      field372 = new class108[4];
      field354 = false;
      field446 = new int[4][13][13];
      field556 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field358 = 0;
      field485 = 2;
      field360 = 0;
      field488 = 2;
      field362 = 0;
      field363 = 1;
      field364 = 0;
      field365 = 0;
      field417 = 2;
      field367 = 0;
      field368 = 1;
      field411 = 0;
      field370 = 0;
      field312 = 2301979;
      field569 = 5063219;
      field374 = 3353893;
      field375 = 7759444;
      field297 = false;
      field377 = 0;
      field378 = 128;
      field388 = 0;
      field380 = 0;
      field539 = 0;
      field355 = 0;
      field518 = 0;
      field384 = 50;
      field385 = 0;
      field386 = false;
      field387 = 0;
      field340 = 0;
      field389 = 50;
      field471 = new int[field389];
      field391 = new int[field389];
      field392 = new int[field389];
      field393 = new int[field389];
      field376 = new int[field389];
      field567 = new int[field389];
      field531 = new int[field389];
      field397 = new String[field389];
      field398 = new int[104][104];
      field329 = 0;
      field400 = -1;
      field401 = -1;
      field402 = 0;
      field403 = 0;
      field438 = 0;
      field405 = 0;
      field494 = 0;
      field407 = 0;
      field408 = 0;
      field467 = 0;
      field308 = 0;
      field541 = 0;
      field412 = false;
      field550 = 0;
      field414 = 0;
      field415 = new class2[2048];
      field416 = -1;
      field409 = 0;
      field418 = 0;
      field419 = new int[1000];
      field420 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field421 = new String[8];
      field422 = new boolean[8];
      field576 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field424 = -1;
      field425 = new class199[4][104][104];
      field482 = new class199();
      field427 = new class199();
      field478 = new class199();
      field429 = new int[25];
      field537 = new int[25];
      field464 = new int[25];
      field432 = 0;
      field433 = false;
      field435 = 0;
      field436 = new int[500];
      field437 = new int[500];
      field448 = new int[500];
      field439 = new int[500];
      field440 = new String[500];
      field441 = new String[500];
      field516 = -1;
      field443 = -1;
      field444 = 0;
      field445 = 50;
      field381 = 0;
      field366 = null;
      field573 = false;
      field442 = -1;
      field451 = -1;
      field315 = null;
      field453 = null;
      field454 = -1;
      field455 = new class196(8);
      field456 = 0;
      field544 = 0;
      field458 = null;
      field522 = 0;
      field460 = 0;
      field461 = 0;
      field462 = -1;
      field463 = false;
      field521 = false;
      field465 = false;
      field466 = null;
      field353 = null;
      field468 = null;
      field469 = 0;
      field470 = 0;
      field352 = null;
      field382 = false;
      field473 = -1;
      field335 = -1;
      field475 = false;
      field476 = -1;
      field477 = -1;
      field423 = false;
      field491 = 1;
      field480 = new int[32];
      field481 = 0;
      field554 = new int[32];
      field483 = 0;
      field484 = new int[32];
      field410 = 0;
      field457 = 0;
      field572 = 0;
      field472 = 0;
      field314 = 0;
      field490 = 0;
      field495 = 0;
      field492 = 0;
      field493 = new class199();
      field359 = new class199();
      field489 = new class199();
      field501 = new class196(512);
      field497 = 0;
      field498 = -2;
      field499 = new boolean[100];
      field500 = new boolean[100];
      field459 = new boolean[100];
      field361 = new int[100];
      field486 = new int[100];
      field558 = new int[100];
      field505 = new int[100];
      field506 = 0;
      field507 = 0L;
      field508 = true;
      field509 = 765;
      field510 = 1;
      field511 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field512 = 0;
      field513 = 0;
      field514 = "";
      field515 = new long[100];
      field293 = 0;
      field517 = 0;
      field399 = new int[128];
      field519 = new int[128];
      field520 = -1L;
      field338 = null;
      field450 = null;
      field523 = -1;
      field390 = 0;
      field525 = new int[1000];
      field526 = new int[1000];
      field487 = new class78[1000];
      field533 = 0;
      field529 = 0;
      field334 = 0;
      field369 = 255;
      field532 = -1;
      field496 = false;
      field534 = 127;
      field535 = 127;
      field536 = 0;
      field350 = new int[50];
      field538 = new int[50];
      field543 = new int[50];
      field540 = new int[50];
      field552 = new class58[50];
      field542 = false;
      field568 = new boolean[5];
      field479 = new int[5];
      field545 = new int[5];
      field546 = new int[5];
      field349 = new int[5];
      field396 = 256;
      field549 = 205;
      field564 = 256;
      field551 = 320;
      field383 = 1;
      field553 = 32767;
      field527 = 1;
      field555 = 32767;
      field428 = 0;
      field557 = 0;
      field306 = 0;
      field559 = 0;
      field560 = 0;
      field561 = 0;
      field562 = 0;
      field474 = new class17[400];
      field310 = new class195();
      field565 = 0;
      field566 = new class7[400];
      field309 = new class179();
      field320 = -1;
      field426 = -1;
      field570 = new class220[8];
      field571 = -1L;
      field452 = -1L;
      field373 = new class10();
      field574 = new int[50];
      field575 = new int[50];
   }

   public final void init() {
      if(this.method3104()) {
         class190[] var1 = new class190[]{class190.field3065, class190.field3066, class190.field3069, class190.field3070, class190.field3068, class190.field3067, class190.field3074, class190.field3073, class190.field3077, class190.field3075, class190.field3076, class190.field3071, class190.field3072, class190.field3078, class190.field3081};
         class190[] var2 = var1;

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class190 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3079);
            if(var5 != null) {
               int var7;
               class153[] var8;
               int var9;
               switch(Integer.parseInt(var4.field3079)) {
               case 1:
                  class82.field1432 = Integer.parseInt(var5);
                  continue;
               case 2:
                  class93.field1604 = var5;
                  continue;
               case 3:
                  field299 = Integer.parseInt(var5);
                  continue;
               case 4:
                  class8.field163 = var5;
                  continue;
               case 5:
                  class18.field270 = (class154)class23.method606(class77.method1668(), Integer.parseInt(var5));
                  if(class18.field270 == class154.field2312) {
                     class164.field2678 = class212.field3150;
                  } else {
                     class164.field2678 = class212.field3146;
                  }
               case 6:
               case 8:
               case 9:
               default:
                  continue;
               case 7:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  continue;
               case 10:
                  class155.field2322 = Integer.parseInt(var5);
                  continue;
               case 11:
                  field503 = Integer.parseInt(var5);
                  continue;
               case 12:
                  if(var5.equalsIgnoreCase("true")) {
                     field300 = true;
                  } else {
                     field300 = false;
                  }
                  continue;
               case 13:
                  field302 = Integer.parseInt(var5);
                  continue;
               case 14:
                  field296 = Integer.parseInt(var5);
                  continue;
               case 15:
                  var7 = Integer.parseInt(var5);
                  var8 = class127.method2828();
                  var9 = 0;
               }

               class153 var6;
               while(true) {
                  if(var9 >= var8.length) {
                     var6 = null;
                     break;
                  }

                  class153 var10 = var8[var9];
                  if(var10.field2303 == var7) {
                     var6 = var10;
                     break;
                  }

                  ++var9;
               }

               field298 = var6;
            }
         }

         class86.field1483 = false;
         field413 = false;
         class107.field1891 = this.getCodeBase().getHost();
         String var15 = field298.field2302;
         byte var16 = 0;

         try {
            class149.field2263 = 16;
            class149.field2262 = var16;

            try {
               class126.field2050 = System.getProperty("os.name");
            } catch (Exception var13) {
               class126.field2050 = "Unknown";
            }

            class52.field1168 = class126.field2050.toLowerCase();

            try {
               class48.field1098 = System.getProperty("user.home");
               if(class48.field1098 != null) {
                  class48.field1098 = class48.field1098 + "/";
               }
            } catch (Exception var12) {
               ;
            }

            try {
               if(class52.field1168.startsWith("win")) {
                  if(class48.field1098 == null) {
                     class48.field1098 = System.getenv("USERPROFILE");
                  }
               } else if(null == class48.field1098) {
                  class48.field1098 = System.getenv("HOME");
               }

               if(class48.field1098 != null) {
                  class48.field1098 = class48.field1098 + "/";
               }
            } catch (Exception var11) {
               ;
            }

            if(null == class48.field1098) {
               class48.field1098 = "~/";
            }

            class72.field1361 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class48.field1098, "/tmp/", ""};
            class111.field1967 = new String[]{".jagex_cache_" + class149.field2262, ".file_store_" + class149.field2262};

            label119:
            for(var3 = 0; var3 < 4; ++var3) {
               class149.field2255 = class28.method659("oldschool", var15, var3);
               if(!class149.field2255.exists()) {
                  class149.field2255.mkdirs();
               }

               File[] var17 = class149.field2255.listFiles();
               if(null == var17) {
                  break;
               }

               File[] var18 = var17;
               int var19 = 0;

               while(true) {
                  if(var19 >= var18.length) {
                     break label119;
                  }

                  File var20 = var18[var19];
                  if(!class25.method638(var20, false)) {
                     break;
                  }

                  ++var19;
               }
            }

            class6.method100(class149.field2255);
            class30.method672();
            class149.field2260 = new class228(new class227(class16.method180("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class149.field2261 = new class228(new class227(class16.method180("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class177.field2920 = new class228[class149.field2263];

            for(var3 = 0; var3 < class149.field2263; ++var3) {
               class177.field2920[var3] = new class228(new class227(class16.method180("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var14) {
            class0.method0((String)null, var14);
         }

         field294 = this;
         this.method3080(765, 503, 110);
      }
   }

   @ObfuscatedName("w")
   public static void method357(class167 var0) {
      class41.field982 = var0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-68"
   )
   void method370() {
      if(field303 != 1000) {
         boolean var1 = class8.method112();
         if(!var1) {
            this.method241();
         }

      }
   }

   @ObfuscatedName("p")
   protected final void vmethod3034() {
      class21.field592 = field299 == 0?'ꩊ':field296 + '鱀';
      class18.field267 = field299 == 0?443:field296 + '썐';
      class93.field1607 = class21.field592;
      class34.field787 = class174.field2903;
      class20.field584 = class174.field2904;
      class179.field2932 = class174.field2905;
      class109.field1920 = class174.field2906;
      if(class136.field2112.toLowerCase().indexOf("microsoft") != -1) {
         class137.field2139[186] = 57;
         class137.field2139[187] = 27;
         class137.field2139[188] = 71;
         class137.field2139[189] = 26;
         class137.field2139[190] = 72;
         class137.field2139[191] = 73;
         class137.field2139[192] = 58;
         class137.field2139[219] = 42;
         class137.field2139[220] = 74;
         class137.field2139[221] = 43;
         class137.field2139[222] = 59;
         class137.field2139[223] = 28;
      } else {
         class137.field2139[44] = 71;
         class137.field2139[45] = 26;
         class137.field2139[46] = 72;
         class137.field2139[47] = 73;
         class137.field2139[59] = 57;
         class137.field2139[61] = 27;
         class137.field2139[91] = 42;
         class137.field2139[92] = 74;
         class137.field2139[93] = 43;
         class137.field2139[192] = 28;
         class137.field2139[222] = 58;
         class137.field2139[520] = 59;
      }

      Canvas var1 = class87.field1537;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class137.field2131);
      var1.addFocusListener(class137.field2131);
      Canvas var2 = class87.field1537;
      var2.addMouseListener(class140.field2163);
      var2.addMouseMotionListener(class140.field2163);
      var2.addFocusListener(class140.field2163);

      class145 var3;
      try {
         var3 = new class145();
      } catch (Throwable var11) {
         var3 = null;
      }

      class8.field159 = var3;
      if(null != class8.field159) {
         class8.field159.vmethod3122(class87.field1537);
      }

      class101.field1770 = new class134(255, class149.field2260, class149.field2261, 500000);
      class227 var5 = null;
      class8 var6 = new class8();

      try {
         var5 = class104.method2295("", class18.field270.field2311, false);
         byte[] var7 = new byte[(int)var5.method4132()];

         int var9;
         for(int var8 = 0; var8 < var7.length; var8 += var9) {
            var9 = var5.method4131(var7, var8, var7.length - var8);
            if(-1 == var9) {
               throw new IOException();
            }
         }

         var6 = new class8(new class119(var7));
      } catch (Exception var12) {
         ;
      }

      try {
         if(var5 != null) {
            var5.method4130();
         }
      } catch (Exception var10) {
         ;
      }

      class41.field989 = var6;
      class2.field65 = this.getToolkit().getSystemClipboard();
      String var13 = class127.field2054;
      class138.field2148 = this;
      class138.field2151 = var13;
      if(0 != field299) {
         field311 = true;
      }

      class15.method171(class41.field989.field155);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   protected final void vmethod3037() {
      if(class74.field1375.method206()) {
         class74.field1375.method202();
      }

      if(class150.field2275 != null) {
         class150.field2275.field215 = false;
      }

      class150.field2275 = null;
      if(null != class9.field173) {
         class9.field173.method3005();
         class9.field173 = null;
      }

      class37.method780();
      class108.method2424();
      class8.field159 = null;
      if(class17.field253 != null) {
         class17.field253.method1228();
      }

      if(null != class153.field2299) {
         class153.field2299.method1228();
      }

      class109.method2429();
      class153.method3180();
      class34.method731();
   }

   @ObfuscatedName("x")
   protected final void vmethod3113() {
   }
}
