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
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
public final class client extends class147 {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1838686999
   )
   static int field288;
   @ObfuscatedName("l")
   static client field289;
   @ObfuscatedName("c")
   static boolean field290 = true;
   @ObfuscatedName("nr")
   static int[] field291;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1436718901
   )
   @Export("flags")
   static int field292 = 0;
   @ObfuscatedName("a")
   static class156 field293;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -248857831
   )
   static int field294 = 0;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -1231478833
   )
   static int field295;
   @ObfuscatedName("o")
   static class215 field296;
   @ObfuscatedName("mt")
   static byte field297;
   @ObfuscatedName("i")
   static boolean field298 = false;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1177329883
   )
   static int field299 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1266701355
   )
   static int field300;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1491043689
   )
   @Export("gameState")
   static int field301 = 0;
   @ObfuscatedName("m")
   static boolean field302 = true;
   @ObfuscatedName("if")
   @Export("menuIdentifiers")
   static int[] field303;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 5493591400019386565L
   )
   static long field304 = -1L;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 1861211345
   )
   static int field305;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 676787619
   )
   static int field306 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1563061845
   )
   static int field307 = -1;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -888914299
   )
   static int field308;
   @ObfuscatedName("as")
   static boolean field309 = false;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 861848223
   )
   static int field310 = 0;
   @ObfuscatedName("gv")
   static int[][] field311;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2143553137
   )
   static int field312 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1508259013
   )
   static int field313 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1043749859
   )
   static int field314 = 0;
   @ObfuscatedName("hm")
   static int[] field315;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 628572991
   )
   static int field316 = 0;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1947302245
   )
   static int field317 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -940025609
   )
   static int field318 = 0;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -132190789
   )
   static int field319;
   @ObfuscatedName("aq")
   static class21 field320;
   @ObfuscatedName("af")
   static class21 field321;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1446663811
   )
   static int field322;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 949992367
   )
   static int field323;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1516064557
   )
   static int field324;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 844545635
   )
   static int field325;
   @ObfuscatedName("eu")
   static class83[] field326;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -1364374247
   )
   @Export("mapScaleDelta")
   static int field327;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -869566465
   )
   static int field328;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1478799193
   )
   static int field329;
   @ObfuscatedName("br")
   @Export("host")
   static String field330;
   @ObfuscatedName("cb")
   @Export("cachedNPCs")
   static class36[] field331;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 153802289
   )
   static int field332;
   @ObfuscatedName("cf")
   static int[] field333;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1971832013
   )
   static int field334;
   @ObfuscatedName("cc")
   static int[] field335;
   @ObfuscatedName("cp")
   static class125 field336;
   @ObfuscatedName("hi")
   @Export("boostedSkillLevels")
   static int[] field337;
   @ObfuscatedName("cq")
   static class125 field338;
   @ObfuscatedName("ee")
   static boolean field339;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -169136453
   )
   static int field340;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1543542669
   )
   static int field341 = 0;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1122656323
   )
   static int field342;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1557152561
   )
   static int field343;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 664768297
   )
   static int field344;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 744002779
   )
   static int field345;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = 844490577
   )
   @Export("ignoreCount")
   static int field346;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 1998097215
   )
   static int field347;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -913038331
   )
   static int field348;
   @ObfuscatedName("oy")
   static short field349;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 1885333935
   )
   static int field350;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -1849537787
   )
   static int field351;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 1094969059
   )
   static int field352;
   @ObfuscatedName("dl")
   static byte[][] field353;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -226445295
   )
   static int field354;
   @ObfuscatedName("do")
   static boolean field355;
   @ObfuscatedName("dz")
   static int[][][] field356;
   @ObfuscatedName("kl")
   static class202 field357;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 2134789799
   )
   static int field358;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -2045202435
   )
   static int field359;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -1774927585
   )
   static int field360;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -417598933
   )
   static int field361;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -1576699193
   )
   static int field362;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -413640839
   )
   static int field363;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 371946699
   )
   static int field364;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 2077178331
   )
   @Export("mapScale")
   static int field365;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -1133057965
   )
   static int field366;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 1219575351
   )
   static int field367;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -799830447
   )
   static int field368;
   @ObfuscatedName("ig")
   static String field369;
   @ObfuscatedName("nj")
   static int[] field370;
   @ObfuscatedName("jn")
   static class176 field371;
   @ObfuscatedName("u")
   static class157 field372;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1028231255
   )
   static int field373;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1754848063
   )
   static int field374;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 1219107607
   )
   static int field375;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = 807994997
   )
   static int field376;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 1949117121
   )
   static int field377;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 553554903
   )
   static int field378;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 668234675
   )
   static int field379;
   @ObfuscatedName("ot")
   static int[] field380;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 496352477
   )
   static int field381;
   @ObfuscatedName("jp")
   static class176 field382;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -1025389309
   )
   static int field383;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 247696597
   )
   static int field384;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -3901867
   )
   static int field385;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1914777229
   )
   static int field386;
   @ObfuscatedName("fm")
   static boolean field387;
   @ObfuscatedName("p")
   @Export("isMembers")
   static boolean field388 = false;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1696704099
   )
   static int field389;
   @ObfuscatedName("er")
   static class81[] field390;
   @ObfuscatedName("fp")
   static int[] field391;
   @ObfuscatedName("fi")
   static int[] field392;
   @ObfuscatedName("fr")
   static int[] field393;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -964633799
   )
   static int field394;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1575281001
   )
   static int field395;
   @ObfuscatedName("om")
   static short field396;
   @ObfuscatedName("fq")
   static int[] field397;
   @ObfuscatedName("gs")
   static String[] field398;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1676277649
   )
   static int field399 = 0;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 99803349
   )
   static int field400;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -83239121
   )
   static int field401;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 645977055
   )
   static int field402;
   @ObfuscatedName("js")
   static class176 field403;
   @ObfuscatedName("la")
   static String field404;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -1138288781
   )
   static int field405;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -1922978225
   )
   static int field406;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class111[] field407;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 1396192867
   )
   static int field408;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 326554675
   )
   static int field409;
   @ObfuscatedName("ff")
   static int[] field410;
   @ObfuscatedName("mr")
   static boolean field411;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -1768506521
   )
   static int field412;
   @ObfuscatedName("gc")
   static boolean field413;
   @ObfuscatedName("kv")
   @Export("widgetFlags")
   static class199 field414;
   @ObfuscatedName("kr")
   static int[] field415;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = -1251952587
   )
   static int field416;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 168748615
   )
   @Export("localInteractingIndex")
   static int field417;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 448202175
   )
   static int field418;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -1906909475
   )
   static int field419;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1222995027
   )
   static int field420;
   @ObfuscatedName("hz")
   static final int[] field421;
   @ObfuscatedName("hc")
   static String[] field422;
   @ObfuscatedName("hn")
   static boolean[] field423;
   @ObfuscatedName("ju")
   static boolean field424;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -50277029
   )
   static int field425;
   @ObfuscatedName("ht")
   @Export("groundItemDeque")
   static class202[][][] field426;
   @ObfuscatedName("hx")
   static class202 field427;
   @ObfuscatedName("hb")
   @Export("projectiles")
   static class202 field428;
   @ObfuscatedName("hh")
   static class202 field429;
   @ObfuscatedName("ky")
   static int[] field430;
   @ObfuscatedName("hk")
   @Export("realSkillLevels")
   static int[] field431;
   @ObfuscatedName("hr")
   @Export("skillExperiences")
   static int[] field432;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -1175266331
   )
   static int field433;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1629797649
   )
   static int field434;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -641854283
   )
   @Export("menuOptionCount")
   static int field435;
   @ObfuscatedName("ha")
   @Export("menuActionParams0")
   static int[] field436;
   @ObfuscatedName("hw")
   @Export("menuActionParams1")
   static int[] field437;
   @ObfuscatedName("il")
   @Export("menuTypes")
   static int[] field438;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 1072895253
   )
   static int field439;
   @ObfuscatedName("iw")
   @Export("menuOptions")
   static String[] field440;
   @ObfuscatedName("is")
   @Export("menuTargets")
   static String[] field441;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -2114925481
   )
   static int field442;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = -1161468959
   )
   static int field443;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -1310364017
   )
   static int field444;
   @ObfuscatedName("jx")
   static class176 field445;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -1904594969
   )
   static int field446;
   @ObfuscatedName("ia")
   static String field447;
   @ObfuscatedName("ib")
   static boolean field448;
   @ObfuscatedName("nm")
   static int[] field449;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1472886299
   )
   static int field450;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 1550027581
   )
   static int field451;
   @ObfuscatedName("ie")
   static String field452;
   @ObfuscatedName("fs")
   static int[] field453;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -813994945
   )
   @Export("widgetRoot")
   static int field454;
   @ObfuscatedName("ip")
   @Export("componentTable")
   static class199 field455;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = 1582946729
   )
   static int field456;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -1501220183
   )
   static int field457;
   @ObfuscatedName("os")
   static short field458;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 670892857
   )
   static int field459;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -1930140653
   )
   @Export("weight")
   static int field460;
   @ObfuscatedName("dd")
   static final int[] field461;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -502475161
   )
   static int field462;
   @ObfuscatedName("jd")
   static boolean field463;
   @ObfuscatedName("jt")
   static boolean field464;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1212742215
   )
   static int field465;
   @ObfuscatedName("lg")
   @Export("widgetBoundsHeight")
   static int[] field466;
   @ObfuscatedName("gr")
   @Export("cachedPlayers")
   static class2[] field467;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1652359909
   )
   @Export("world")
   static int field468 = 1;
   @ObfuscatedName("ag")
   static boolean field469;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -190577751
   )
   static int field470;
   @ObfuscatedName("ol")
   static short field471;
   @ObfuscatedName("jy")
   static boolean field472;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 38862265
   )
   static int field473;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -7916941
   )
   static int field474;
   @ObfuscatedName("jg")
   static boolean field475;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 314338149
   )
   static int field476;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 116961951
   )
   static int field477;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 333106003
   )
   static int field478;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -907287195
   )
   static int field479;
   @ObfuscatedName("fg")
   static int[] field480;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -1714593483
   )
   static int field481;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -736485057
   )
   static int field482;
   @ObfuscatedName("kc")
   static int[] field483;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -1067470457
   )
   static int field484;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -1313031557
   )
   static int field485;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1513212355
   )
   static int field486;
   @ObfuscatedName("pk")
   @Export("grandExchangeOffers")
   static class223[] field487;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1792135079
   )
   @Export("energy")
   static int field489;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1297608573
   )
   static int field490;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1103895179
   )
   static int field491;
   @ObfuscatedName("jr")
   static class176 field492;
   @ObfuscatedName("cu")
   static class125 field493;
   @ObfuscatedName("nf")
   static class61[] field494;
   @ObfuscatedName("kw")
   static class202 field495;
   @ObfuscatedName("kh")
   static class202 field496;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -1323090891
   )
   static int field497;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = 78520827
   )
   static int field498;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 540681839
   )
   static int field499;
   @ObfuscatedName("kq")
   static boolean[] field500;
   @ObfuscatedName("lq")
   static boolean[] field501;
   @ObfuscatedName("ly")
   static boolean[] field502;
   @ObfuscatedName("ll")
   @Export("widgetPositionX")
   static int[] field503;
   @ObfuscatedName("ls")
   @Export("widgetPositionY")
   static int[] field504;
   @ObfuscatedName("lr")
   @Export("widgetBoundsWidth")
   static int[] field505;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -1148076255
   )
   static int field506;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -1466245033
   )
   static int field507;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      longValue = -7776046076010690675L
   )
   static long field508;
   @ObfuscatedName("lv")
   @Export("isResized")
   static boolean field509;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 405762845
   )
   static int field510;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 2097493189
   )
   @Export("friendCount")
   static int field511;
   @ObfuscatedName("lo")
   static int[] field512;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -1920227657
   )
   static int field513;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 164196777
   )
   @Export("mapAngle")
   static int field514;
   @ObfuscatedName("ks")
   static int field515;
   @ObfuscatedName("ld")
   static long[] field516;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 715966487
   )
   static int field517;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 680840901
   )
   static int field518;
   @ObfuscatedName("le")
   static int[] field519;
   @ObfuscatedName("mb")
   static int[] field520;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      longValue = -4614958156290007269L
   )
   static long field521;
   @ObfuscatedName("mv")
   static String field522;
   @ObfuscatedName("ml")
   static String field523;
   @ObfuscatedName("jf")
   static boolean field524;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = -383066387
   )
   static int field525;
   @ObfuscatedName("mo")
   static int[] field526;
   @ObfuscatedName("mq")
   static int[] field527;
   @ObfuscatedName("mh")
   static class81[] field528;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = -1877047287
   )
   @Export("flagX")
   static int field529;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 1343121419
   )
   @Export("flagY")
   static int field530;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -1483177241
   )
   static int field531;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1501385417
   )
   static int field532;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -565619933
   )
   static int field533;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 316412945
   )
   static int field534;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 1360841023
   )
   static int field535;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -1884679077
   )
   static int field536;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -1694496749
   )
   static int field537;
   @ObfuscatedName("ak")
   static boolean field538 = true;
   @ObfuscatedName("np")
   static int[] field539;
   @ObfuscatedName("hf")
   @Export("isMenuOpen")
   static boolean field540;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -1847072951
   )
   static int field541;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      longValue = 2052787603411167451L
   )
   static long field542;
   @ObfuscatedName("nq")
   static boolean field543;
   @ObfuscatedName("ng")
   static boolean[] field544;
   @ObfuscatedName("oj")
   static int[] field545;
   @ObfuscatedName("oq")
   static int[] field546;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 2030605649
   )
   static int field547;
   @ObfuscatedName("hd")
   static int[] field548;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -437543449
   )
   @Export("packetOpcode")
   static int field549;
   @ObfuscatedName("or")
   static short field550;
   @ObfuscatedName("ok")
   static short field551;
   @ObfuscatedName("oh")
   static short field552;
   @ObfuscatedName("ch")
   static boolean field553;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -486928599
   )
   static int field554;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1797439429
   )
   static int field555;
   @ObfuscatedName("oo")
   static short field556;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 827114835
   )
   static int field557;
   @ObfuscatedName("og")
   static class198 field558;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 1627405557
   )
   @Export("camera2")
   static int field559;
   @ObfuscatedName("oe")
   @Export("ignores")
   static class7[] field560;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 1279128467
   )
   @Export("scale")
   static int field561;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -2129340287
   )
   @Export("camera3")
   static int field562;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -636882671
   )
   static int field563;
   @ObfuscatedName("ox")
   @Export("friends")
   static class17[] field564;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1497377571
   )
   static int field565;
   @ObfuscatedName("ob")
   static int[] field566;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -225636609
   )
   @Export("gameCycle")
   static int field567 = 0;
   @ObfuscatedName("op")
   static class182 field568;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1916418003
   )
   static int field569 = -1;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = 527191319
   )
   static int field570;
   @ObfuscatedName("po")
   static class8 field571;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 1071337477
   )
   static int field572;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 1394106663
   )
   static int field573;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      longValue = 6441668184405026349L
   )
   static long field574;
   @ObfuscatedName("pt")
   static final class10 field575;
   @ObfuscatedName("pi")
   static int[] field576;
   @ObfuscatedName("pp")
   static int[] field577;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 209153831
   )
   static int field578;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "122"
   )
   protected final void vmethod3191() {
      class62.field1280 = field399 == 0?'ꩊ':field468 + '鱀';
      class40.field911 = field399 == 0?443:'썐' + field468;
      class101.field1745 = class62.field1280;
      class62.field1287 = class177.field2933;
      class40.field916 = class177.field2931;
      class157.field2340 = class177.field2930;
      class212.field3168 = class177.field2934;
      class39.method801();
      class93.method2181(class158.field2346);
      Canvas var1 = class158.field2346;
      var1.addMouseListener(class143.field2194);
      var1.addMouseMotionListener(class143.field2194);
      var1.addFocusListener(class143.field2194);
      class127.field2087 = class47.method1022();
      if(class127.field2087 != null) {
         class127.field2087.vmethod3196(class158.field2346);
      }

      class26.field669 = new class137(255, class152.field2284, class152.field2287, 500000);
      class230 var3 = null;
      class8 var4 = new class8();

      try {
         var3 = class110.method2465("", field372.field2335, false);
         byte[] var5 = new byte[(int)var3.method4214()];

         int var7;
         for(int var6 = 0; var6 < var5.length; var6 += var7) {
            var7 = var3.method4215(var5, var6, var5.length - var6);
            if(var7 == -1) {
               throw new IOException();
            }
         }

         var4 = new class8(new class122(var5));
      } catch (Exception var10) {
         ;
      }

      try {
         if(null != var3) {
            var3.method4213();
         }
      } catch (Exception var9) {
         ;
      }

      field571 = var4;
      class7.field133 = this.getToolkit().getSystemClipboard();
      String var11 = class134.field2119;
      class141.field2187 = this;
      class141.field2181 = var11;
      if(field399 != 0) {
         field309 = true;
      }

      int var8 = field571.field148;
      field508 = 0L;
      if(var8 >= 2) {
         field509 = true;
      } else {
         field509 = false;
      }

      class3.method36();
      if(field301 >= 25) {
         class87.method1995();
      }

      class147.field2251 = true;
   }

   public final void init() {
      if(this.method3143()) {
         class193[] var1 = class25.method588();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class193 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3108);
            if(null != var4) {
               switch(Integer.parseInt(var3.field3108)) {
               case 1:
                  class25.field650 = var4;
                  break;
               case 2:
                  field372 = (class157)class25.method585(class0.method0(), Integer.parseInt(var4));
                  if(field372 == class157.field2334) {
                     field296 = class215.field3180;
                  } else {
                     field296 = class215.field3187;
                  }
                  break;
               case 3:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 4:
                  field399 = Integer.parseInt(var4);
                  break;
               case 5:
                  class28.field702 = var4;
                  break;
               case 6:
                  field293 = class139.method3014(Integer.parseInt(var4));
                  break;
               case 7:
                  field299 = Integer.parseInt(var4);
               case 8:
               case 10:
               default:
                  break;
               case 9:
                  field300 = Integer.parseInt(var4);
                  break;
               case 11:
                  field292 = Integer.parseInt(var4);
                  break;
               case 12:
                  field468 = Integer.parseInt(var4);
                  break;
               case 13:
                  if(var4.equalsIgnoreCase("true")) {
                     field388 = true;
                  } else {
                     field388 = false;
                  }
                  break;
               case 14:
                  class155.field2308 = Integer.parseInt(var4);
               }
            }
         }

         class89.field1553 = false;
         field298 = false;
         field330 = this.getCodeBase().getHost();
         String var31 = field293.field2326;
         byte var32 = 0;

         try {
            class21.field592 = 16;
            class30.field726 = var32;

            try {
               class20.field587 = System.getProperty("os.name");
            } catch (Exception var27) {
               class20.field587 = "Unknown";
            }

            class34.field797 = class20.field587.toLowerCase();

            try {
               class12.field197 = System.getProperty("user.home");
               if(class12.field197 != null) {
                  class12.field197 = class12.field197 + "/";
               }
            } catch (Exception var26) {
               ;
            }

            try {
               if(class34.field797.startsWith("win")) {
                  if(class12.field197 == null) {
                     class12.field197 = System.getenv("USERPROFILE");
                  }
               } else if(null == class12.field197) {
                  class12.field197 = System.getenv("HOME");
               }

               if(null != class12.field197) {
                  class12.field197 = class12.field197 + "/";
               }
            } catch (Exception var25) {
               ;
            }

            if(class12.field197 == null) {
               class12.field197 = "~/";
            }

            class101.field1742 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class12.field197, "/tmp/", ""};
            class102.field1752 = new String[]{".jagex_cache_" + class30.field726, ".file_store_" + class30.field726};
            int var17 = 0;

            label244:
            while(var17 < 4) {
               String var5 = var17 == 0?"":"" + var17;
               class152.field2280 = new File(class12.field197, "jagex_cl_oldschool_" + var31 + var5 + ".dat");
               String var6 = null;
               String var7 = null;
               boolean var8 = false;
               File var37;
               if(class152.field2280.exists()) {
                  try {
                     class230 var9 = new class230(class152.field2280, "rw", 10000L);

                     class122 var10;
                     int var11;
                     for(var10 = new class122((int)var9.method4214()); var10.field2061 < var10.field2054.length; var10.field2061 += var11) {
                        var11 = var9.method4215(var10.field2054, var10.field2061, var10.field2054.length - var10.field2061);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var10.field2061 = 0;
                     var11 = var10.method2610();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var10.method2610();
                     }

                     if(var11 <= 2) {
                        var6 = var10.method2618();
                        if(var12 == 1) {
                           var7 = var10.method2618();
                        }
                     } else {
                        var6 = var10.method2619();
                        if(var12 == 1) {
                           var7 = var10.method2619();
                        }
                     }

                     var9.method4213();
                  } catch (IOException var29) {
                     var29.printStackTrace();
                  }

                  if(null != var6) {
                     var37 = new File(var6);
                     if(!var37.exists()) {
                        var6 = null;
                     }
                  }

                  if(null != var6) {
                     var37 = new File(var6, "test.dat");
                     if(!class33.method680(var37, true)) {
                        var6 = null;
                     }
                  }
               }

               if(var6 == null && var17 == 0) {
                  label219:
                  for(int var18 = 0; var18 < class102.field1752.length; ++var18) {
                     for(int var19 = 0; var19 < class101.field1742.length; ++var19) {
                        File var20 = new File(class101.field1742[var19] + class102.field1752[var18] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var20.exists() && class33.method680(new File(var20, "test.dat"), true)) {
                           var6 = var20.toString();
                           var8 = true;
                           break label219;
                        }
                     }
                  }
               }

               if(var6 == null) {
                  var6 = class12.field197 + File.separatorChar + "jagexcache" + var5 + File.separatorChar + "oldschool" + File.separatorChar + var31 + File.separatorChar;
                  var8 = true;
               }

               if(var7 != null) {
                  File var36 = new File(var7);
                  var37 = new File(var6);

                  try {
                     File[] var39 = var36.listFiles();
                     File[] var21 = var39;

                     for(int var13 = 0; var13 < var21.length; ++var13) {
                        File var14 = var21[var13];
                        File var15 = new File(var37, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var28) {
                     var28.printStackTrace();
                  }

                  var8 = true;
               }

               if(var8) {
                  class5.method74(new File(var6), (File)null);
               }

               File var34 = new File(var6);
               class152.field2281 = var34;
               if(!class152.field2281.exists()) {
                  class152.field2281.mkdirs();
               }

               File[] var35 = class152.field2281.listFiles();
               if(null == var35) {
                  break;
               }

               File[] var38 = var35;
               int var22 = 0;

               while(true) {
                  if(var22 >= var38.length) {
                     break label244;
                  }

                  File var23 = var38[var22];
                  if(!class33.method680(var23, false)) {
                     ++var17;
                     break;
                  }

                  ++var22;
               }
            }

            File var33 = class152.field2281;
            class134.field2118 = var33;
            if(!class134.field2118.exists()) {
               throw new RuntimeException("");
            }

            class138.field2135 = true;
            class142.method3047();
            class152.field2284 = new class231(new class230(class54.method1142("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class152.field2287 = new class231(new class230(class54.method1142("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class152.field2286 = new class231[class21.field592];

            for(int var24 = 0; var24 < class21.field592; ++var24) {
               class152.field2286[var24] = new class231(new class230(class54.method1142("main_file_cache.idx" + var24), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var30) {
            class46.method1008((String)null, var30);
         }

         field289 = this;
         this.method3187(765, 503, 118);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-56"
   )
   @Export("packetHandler")
   protected final void vmethod3118() {
      ++field567;
      this.method364();
      class3.method40();
      class184.method3619();
      class110.method2469();
      class140 var1 = class140.field2155;
      int var2;
      synchronized(class140.field2155) {
         ++class140.field2176;
         class140.field2173 = class140.field2175;
         class140.field2172 = 0;
         if(class140.field2156 >= 0) {
            while(class140.field2167 != class140.field2156) {
               var2 = class140.field2166[class140.field2167];
               class140.field2167 = 1 + class140.field2167 & 127;
               if(var2 < 0) {
                  class140.field2160[~var2] = false;
               } else {
                  if(!class140.field2160[var2] && class140.field2172 < class140.field2171.length - 1) {
                     class140.field2171[++class140.field2172 - 1] = var2;
                  }

                  class140.field2160[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               class140.field2160[var2] = false;
            }

            class140.field2156 = class140.field2167;
         }

         class140.field2175 = class140.field2174;
      }

      class118.method2541();
      int var40;
      if(null != class127.field2087) {
         var40 = class127.field2087.vmethod3197();
         field573 = var40;
      }

      int var4;
      int var5;
      int var6;
      int var7;
      int var10;
      int var11;
      int var12;
      int var41;
      class122 var43;
      int var48;
      int var68;
      int var71;
      if(field301 == 0) {
         class163.method3275();
         class158.field2347.vmethod3206();

         for(var40 = 0; var40 < 32; ++var40) {
            class147.field2255[var40] = 0L;
         }

         for(var40 = 0; var40 < 32; ++var40) {
            class147.field2248[var40] = 0L;
         }

         class113.field1974 = 0;
      } else if(field301 == 5) {
         class16.method164(this);
         class163.method3275();
         class158.field2347.vmethod3206();

         for(var40 = 0; var40 < 32; ++var40) {
            class147.field2255[var40] = 0L;
         }

         for(var40 = 0; var40 < 32; ++var40) {
            class147.field2248[var40] = 0L;
         }

         class113.field1974 = 0;
      } else if(field301 != 10 && field301 != 11) {
         if(field301 == 20) {
            class16.method164(this);
            class50.method1085();
         } else if(field301 == 25) {
            class105.method2369(false);
            field348 = 0;
            boolean var76 = true;

            for(var2 = 0; var2 < field353.length; ++var2) {
               if(class77.field1440[var2] != -1 && field353[var2] == null) {
                  field353[var2] = class4.field68.method3340(class77.field1440[var2], 0);
                  if(null == field353[var2]) {
                     var76 = false;
                     ++field348;
                  }
               }

               if(class24.field643[var2] != -1 && class96.field1662[var2] == null) {
                  class96.field1662[var2] = class4.field68.method3409(class24.field643[var2], 0, class151.field2272[var2]);
                  if(null == class96.field1662[var2]) {
                     var76 = false;
                     ++field348;
                  }
               }
            }

            if(!var76) {
               field352 = 1;
            } else {
               field350 = 0;
               var76 = true;

               class122 var9;
               int var14;
               int var15;
               int var16;
               int var17;
               int var18;
               int var19;
               for(var2 = 0; var2 < field353.length; ++var2) {
                  byte[] var3 = class96.field1662[var2];
                  if(null != var3) {
                     var4 = (class93.field1629[var2] >> 8) * 64 - class19.field286;
                     var5 = (class93.field1629[var2] & 255) * 64 - class6.field128;
                     if(field355) {
                        var4 = 10;
                        var5 = 10;
                     }

                     boolean var8 = true;
                     var9 = new class122(var3);
                     var10 = -1;

                     label1869:
                     while(true) {
                        var11 = var9.method2672();
                        if(var11 == 0) {
                           var76 &= var8;
                           break;
                        }

                        var10 += var11;
                        var12 = 0;
                        boolean var13 = false;

                        while(true) {
                           while(!var13) {
                              var14 = var9.method2672();
                              if(var14 == 0) {
                                 continue label1869;
                              }

                              var12 += var14 - 1;
                              var15 = var12 & 63;
                              var16 = var12 >> 6 & 63;
                              var17 = var9.method2610() >> 2;
                              var18 = var16 + var4;
                              var19 = var15 + var5;
                              if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                 class42 var20 = class146.method3102(var10);
                                 if(var17 != 22 || !field298 || var20.field971 != 0 || var20.field976 == 1 || var20.field997) {
                                    if(!var20.method842()) {
                                       ++field350;
                                       var8 = false;
                                    }

                                    var13 = true;
                                 }
                              }
                           }

                           var14 = var9.method2672();
                           if(var14 == 0) {
                              break;
                           }

                           var9.method2610();
                        }
                     }
                  }
               }

               if(!var76) {
                  field352 = 2;
               } else {
                  if(field352 != 0) {
                     class96.method2260("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class110.method2469();
                  class10.method115();
                  class110.method2469();
                  class79.field1453.method2009();
                  class110.method2469();
                  System.gc();

                  for(var2 = 0; var2 < 4; ++var2) {
                     field407[var2].method2486();
                  }

                  for(var2 = 0; var2 < 4; ++var2) {
                     for(var41 = 0; var41 < 104; ++var41) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           class5.field89[var2][var41][var4] = 0;
                        }
                     }
                  }

                  class110.method2469();
                  class5.field79 = 99;
                  class5.field80 = new byte[4][104][104];
                  class5.field91 = new byte[4][104][104];
                  class219.field3204 = new byte[4][104][104];
                  class5.field81 = new byte[4][104][104];
                  class133.field2117 = new int[4][105][105];
                  class5.field83 = new byte[4][105][105];
                  class1.field25 = new int[105][105];
                  class5.field84 = new int[104];
                  class5.field85 = new int[104];
                  class8.field155 = new int[104];
                  class225.field3228 = new int[104];
                  class32.field752 = new int[104];
                  var2 = field353.length;

                  for(class24 var61 = (class24)class24.field628.method3899(); null != var61; var61 = (class24)class24.field628.method3918()) {
                     if(null != var61.field634) {
                        class31.field742.method1254(var61.field634);
                        var61.field634 = null;
                     }

                     if(null != var61.field639) {
                        class31.field742.method1254(var61.field639);
                        var61.field639 = null;
                     }
                  }

                  class24.field628.method3917();
                  class105.method2369(true);
                  int var21;
                  int var22;
                  int var47;
                  if(!field355) {
                     var41 = 0;

                     label1801:
                     while(true) {
                        byte[] var42;
                        if(var41 >= var2) {
                           for(var41 = 0; var41 < var2; ++var41) {
                              var4 = (class93.field1629[var41] >> 8) * 64 - class19.field286;
                              var5 = (class93.field1629[var41] & 255) * 64 - class6.field128;
                              var42 = field353[var41];
                              if(null == var42 && class32.field751 < 800) {
                                 class110.method2469();
                                 class42.method854(var4, var5, 64, 64);
                              }
                           }

                           class105.method2369(true);
                           var41 = 0;

                           while(true) {
                              if(var41 >= var2) {
                                 break label1801;
                              }

                              byte[] var44 = class96.field1662[var41];
                              if(null != var44) {
                                 var5 = (class93.field1629[var41] >> 8) * 64 - class19.field286;
                                 var6 = (class93.field1629[var41] & 255) * 64 - class6.field128;
                                 class110.method2469();
                                 class89 var45 = class79.field1453;
                                 class111[] var46 = field407;
                                 var9 = new class122(var44);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var9.method2672();
                                    if(var11 == 0) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var71 = var9.method2672();
                                       if(var71 == 0) {
                                          break;
                                       }

                                       var12 += var71 - 1;
                                       var14 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       var17 = var9.method2610();
                                       var18 = var17 >> 2;
                                       var19 = var17 & 3;
                                       var47 = var5 + var15;
                                       var21 = var6 + var14;
                                       if(var47 > 0 && var21 > 0 && var47 < 103 && var21 < 103) {
                                          var22 = var16;
                                          if((class5.field89[1][var47][var21] & 2) == 2) {
                                             var22 = var16 - 1;
                                          }

                                          class111 var23 = null;
                                          if(var22 >= 0) {
                                             var23 = var46[var22];
                                          }

                                          class167.method3323(var16, var47, var21, var10, var19, var18, var45, var23);
                                       }
                                    }
                                 }
                              }

                              ++var41;
                           }
                        }

                        var4 = 64 * (class93.field1629[var41] >> 8) - class19.field286;
                        var5 = 64 * (class93.field1629[var41] & 255) - class6.field128;
                        var42 = field353[var41];
                        if(var42 != null) {
                           class110.method2469();
                           var7 = class13.field215 * 8 - 48;
                           var68 = class32.field751 * 8 - 48;
                           class111[] var69 = field407;
                           var10 = 0;

                           label1798:
                           while(true) {
                              if(var10 >= 4) {
                                 var43 = new class122(var42);
                                 var11 = 0;

                                 while(true) {
                                    if(var11 >= 4) {
                                       break label1798;
                                    }

                                    for(var12 = 0; var12 < 64; ++var12) {
                                       for(var71 = 0; var71 < 64; ++var71) {
                                          class51.method1123(var43, var11, var12 + var4, var71 + var5, var7, var68, 0);
                                       }
                                    }

                                    ++var11;
                                 }
                              }

                              for(var11 = 0; var11 < 64; ++var11) {
                                 for(var12 = 0; var12 < 64; ++var12) {
                                    if(var11 + var4 > 0 && var11 + var4 < 103 && var5 + var12 > 0 && var5 + var12 < 103) {
                                       var69[var10].field1969[var4 + var11][var12 + var5] &= -16777217;
                                    }
                                 }
                              }

                              ++var10;
                           }
                        }

                        ++var41;
                     }
                  }

                  if(field355) {
                     var41 = 0;

                     label1734:
                     while(true) {
                        if(var41 >= 4) {
                           for(var41 = 0; var41 < 13; ++var41) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = field356[0][var41][var4];
                                 if(var5 == -1) {
                                    class42.method854(8 * var41, 8 * var4, 8, 8);
                                 }
                              }
                           }

                           class105.method2369(true);
                           var41 = 0;

                           while(true) {
                              if(var41 >= 4) {
                                 break label1734;
                              }

                              class110.method2469();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var6 = field356[var41][var4][var5];
                                    if(var6 != -1) {
                                       var7 = var6 >> 24 & 3;
                                       var68 = var6 >> 1 & 3;
                                       var48 = var6 >> 14 & 1023;
                                       var10 = var6 >> 3 & 2047;
                                       var11 = (var48 / 8 << 8) + var10 / 8;

                                       for(var12 = 0; var12 < class93.field1629.length; ++var12) {
                                          if(var11 == class93.field1629[var12] && null != class96.field1662[var12]) {
                                             class17.method166(class96.field1662[var12], var41, 8 * var4, var5 * 8, var7, (var48 & 7) * 8, (var10 & 7) * 8, var68, class79.field1453, field407);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var41;
                           }
                        }

                        class110.method2469();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var67 = false;
                              var7 = field356[var41][var4][var5];
                              if(var7 != -1) {
                                 var68 = var7 >> 24 & 3;
                                 var48 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = var11 / 8 + (var10 / 8 << 8);

                                 for(var71 = 0; var71 < class93.field1629.length; ++var71) {
                                    if(var12 == class93.field1629[var71] && null != field353[var71]) {
                                       byte[] var49 = field353[var71];
                                       var15 = 8 * var4;
                                       var16 = 8 * var5;
                                       var17 = 8 * (var10 & 7);
                                       var18 = (var11 & 7) * 8;
                                       class111[] var50 = field407;

                                       for(var47 = 0; var47 < 8; ++var47) {
                                          for(var21 = 0; var21 < 8; ++var21) {
                                             if(var15 + var47 > 0 && var15 + var47 < 103 && var21 + var16 > 0 && var21 + var16 < 103) {
                                                var50[var41].field1969[var47 + var15][var16 + var21] &= -16777217;
                                             }
                                          }
                                       }

                                       class122 var74 = new class122(var49);

                                       for(var21 = 0; var21 < 4; ++var21) {
                                          for(var22 = 0; var22 < 64; ++var22) {
                                             for(int var51 = 0; var51 < 64; ++var51) {
                                                if(var68 == var21 && var22 >= var17 && var22 < 8 + var17 && var51 >= var18 && var51 < var18 + 8) {
                                                   int var28 = var22 & 7;
                                                   int var29 = var51 & 7;
                                                   int var30 = var48 & 3;
                                                   int var27;
                                                   if(var30 == 0) {
                                                      var27 = var28;
                                                   } else if(var30 == 1) {
                                                      var27 = var29;
                                                   } else if(var30 == 2) {
                                                      var27 = 7 - var28;
                                                   } else {
                                                      var27 = 7 - var29;
                                                   }

                                                   int var33 = var15 + var27;
                                                   int var36 = var22 & 7;
                                                   int var37 = var51 & 7;
                                                   int var38 = var48 & 3;
                                                   int var35;
                                                   if(var38 == 0) {
                                                      var35 = var37;
                                                   } else if(var38 == 1) {
                                                      var35 = 7 - var36;
                                                   } else if(var38 == 2) {
                                                      var35 = 7 - var37;
                                                   } else {
                                                      var35 = var36;
                                                   }

                                                   class51.method1123(var74, var41, var33, var35 + var16, 0, 0, var48);
                                                } else {
                                                   class51.method1123(var74, 0, -1, -1, 0, 0, 0);
                                                }
                                             }
                                          }
                                       }

                                       var67 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var67) {
                                 var68 = var41;
                                 var48 = 8 * var4;
                                 var10 = var5 * 8;

                                 for(var11 = 0; var11 < 8; ++var11) {
                                    for(var12 = 0; var12 < 8; ++var12) {
                                       class5.field78[var68][var48 + var11][var12 + var10] = 0;
                                    }
                                 }

                                 if(var48 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class5.field78[var68][var48][var10 + var11] = class5.field78[var68][var48 - 1][var11 + var10];
                                    }
                                 }

                                 if(var10 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class5.field78[var68][var11 + var48][var10] = class5.field78[var68][var11 + var48][var10 - 1];
                                    }
                                 }

                                 if(var48 > 0 && class5.field78[var68][var48 - 1][var10] != 0) {
                                    class5.field78[var68][var48][var10] = class5.field78[var68][var48 - 1][var10];
                                 } else if(var10 > 0 && class5.field78[var68][var48][var10 - 1] != 0) {
                                    class5.field78[var68][var48][var10] = class5.field78[var68][var48][var10 - 1];
                                 } else if(var48 > 0 && var10 > 0 && class5.field78[var68][var48 - 1][var10 - 1] != 0) {
                                    class5.field78[var68][var48][var10] = class5.field78[var68][var48 - 1][var10 - 1];
                                 }
                              }
                           }
                        }

                        ++var41;
                     }
                  }

                  class105.method2369(true);
                  class10.method115();
                  class110.method2469();
                  class28.method645(class79.field1453, field407);
                  class105.method2369(true);
                  var41 = class5.field79;
                  if(var41 > class50.field1119) {
                     var41 = class50.field1119;
                  }

                  if(var41 < class50.field1119 - 1) {
                     var41 = class50.field1119 - 1;
                  }

                  if(field298) {
                     class79.field1453.method2092(class5.field79);
                  } else {
                     class79.field1453.method2092(0);
                  }

                  for(var4 = 0; var4 < 104; ++var4) {
                     for(var5 = 0; var5 < 104; ++var5) {
                        class3.method38(var4, var5);
                     }
                  }

                  class110.method2469();
                  class175.method3483();
                  class42.field1006.method3835();
                  if(null != class105.field1845) {
                     field336.method2854(89);
                     field336.method2598(1057001181);
                  }

                  if(!field355) {
                     var4 = (class13.field215 - 6) / 8;
                     var5 = (class13.field215 + 6) / 8;
                     var6 = (class32.field751 - 6) / 8;
                     var7 = (class32.field751 + 6) / 8;

                     for(var68 = var4 - 1; var68 <= var5 + 1; ++var68) {
                        for(var48 = var6 - 1; var48 <= 1 + var7; ++var48) {
                           if(var68 < var4 || var68 > var5 || var48 < var6 || var48 > var7) {
                              class4.field68.method3361("m" + var68 + "_" + var48);
                              class4.field68.method3361("l" + var68 + "_" + var48);
                           }
                        }
                     }
                  }

                  class92.method2179(30);
                  class110.method2469();
                  class45.method976();
                  field336.method2854(178);
                  class158.field2347.vmethod3206();

                  for(var4 = 0; var4 < 32; ++var4) {
                     class147.field2255[var4] = 0L;
                  }

                  for(var4 = 0; var4 < 32; ++var4) {
                     class147.field2248[var4] = 0L;
                  }

                  class113.field1974 = 0;
               }
            }
         }
      } else {
         class16.method164(this);
      }

      if(field301 == 30) {
         if(field310 > 1) {
            --field310;
         }

         if(field478 > 0) {
            --field478;
         }

         if(field553) {
            field553 = false;
            class14.method154();
         } else {
            if(!field540) {
               field440[0] = "Cancel";
               field441[0] = "";
               field438[0] = 1006;
               field435 = 1;
            }

            for(var40 = 0; var40 < 100 && class125.method2877(); ++var40) {
               ;
            }

            if(field301 == 30) {
               while(class190.method3826()) {
                  field336.method2854(134);
                  field336.method2795(0);
                  var40 = field336.field2061;
                  class7.method93(field336);
                  field336.method2607(field336.field2061 - var40);
               }

               Object var58 = class175.field2782.field206;
               synchronized(class175.field2782.field206) {
                  if(!field290) {
                     class175.field2782.field214 = 0;
                  } else if(class143.field2208 != 0 || class175.field2782.field214 >= 40) {
                     field336.method2854(216);
                     field336.method2795(0);
                     var2 = field336.field2061;
                     var41 = 0;

                     for(var4 = 0; var4 < class175.field2782.field214 && field336.field2061 - var2 < 240; ++var4) {
                        ++var41;
                        var5 = class175.field2782.field209[var4];
                        if(var5 < 0) {
                           var5 = 0;
                        } else if(var5 > 502) {
                           var5 = 502;
                        }

                        var6 = class175.field2782.field208[var4];
                        if(var6 < 0) {
                           var6 = 0;
                        } else if(var6 > 764) {
                           var6 = 764;
                        }

                        var7 = var5 * 765 + var6;
                        if(class175.field2782.field209[var4] == -1 && class175.field2782.field208[var4] == -1) {
                           var6 = -1;
                           var5 = -1;
                           var7 = 524287;
                        }

                        if(var6 == field569 && var5 == field306) {
                           if(field307 < 2047) {
                              ++field307;
                           }
                        } else {
                           var68 = var6 - field569;
                           field569 = var6;
                           var48 = var5 - field306;
                           field306 = var5;
                           if(field307 < 8 && var68 >= -32 && var68 <= 31 && var48 >= -32 && var48 <= 31) {
                              var68 += 32;
                              var48 += 32;
                              field336.method2781((field307 << 12) + (var68 << 6) + var48);
                              field307 = 0;
                           } else if(field307 < 8) {
                              field336.method2675(8388608 + (field307 << 19) + var7);
                              field307 = 0;
                           } else {
                              field336.method2598((field307 << 19) + -1073741824 + var7);
                              field307 = 0;
                           }
                        }
                     }

                     field336.method2607(field336.field2061 - var2);
                     if(var41 >= class175.field2782.field214) {
                        class175.field2782.field214 = 0;
                     } else {
                        class175.field2782.field214 -= var41;

                        for(var4 = 0; var4 < class175.field2782.field214; ++var4) {
                           class175.field2782.field208[var4] = class175.field2782.field208[var4 + var41];
                           class175.field2782.field209[var4] = class175.field2782.field209[var4 + var41];
                        }
                     }
                  }
               }

               if(class143.field2208 == 1 || !field469 && class143.field2208 == 4 || class143.field2208 == 2) {
                  long var82 = (class143.field2209 - field304) / 50L;
                  if(var82 > 4095L) {
                     var82 = 4095L;
                  }

                  field304 = class143.field2209;
                  var41 = class143.field2213;
                  if(var41 < 0) {
                     var41 = 0;
                  } else if(var41 > class132.field2109) {
                     var41 = class132.field2109;
                  }

                  var4 = class143.field2207;
                  if(var4 < 0) {
                     var4 = 0;
                  } else if(var4 > class142.field2191) {
                     var4 = class142.field2191;
                  }

                  var5 = (int)var82;
                  field336.method2854(231);
                  field336.method2781((class143.field2208 == 2?1:0) + (var5 << 1));
                  field336.method2781(var4);
                  field336.method2781(var41);
               }

               if(class140.field2172 > 0) {
                  field336.method2854(196);
                  field336.method2781(0);
                  var40 = field336.field2061;
                  long var66 = method424();

                  for(var4 = 0; var4 < class140.field2172; ++var4) {
                     long var70 = var66 - field521;
                     if(var70 > 16777215L) {
                        var70 = 16777215L;
                     }

                     field521 = var66;
                     field336.method2807(class140.field2171[var4]);
                     field336.method2675((int)var70);
                  }

                  field336.method2606(field336.field2061 - var40);
               }

               if(field386 > 0) {
                  --field386;
               }

               if(class140.field2160[96] || class140.field2160[97] || class140.field2160[98] || class140.field2160[99]) {
                  field387 = true;
               }

               if(field387 && field386 <= 0) {
                  field386 = 20;
                  field387 = false;
                  field336.method2854(189);
                  field336.method2732(field514);
                  field336.method2732(field379);
               }

               if(class59.field1263 && !field538) {
                  field538 = true;
                  field336.method2854(183);
                  field336.method2795(1);
               }

               if(!class59.field1263 && field538) {
                  field538 = false;
                  field336.method2854(183);
                  field336.method2795(0);
               }

               class55.method1221();
               if(field301 == 30) {
                  class156.method3244();
                  class124.method2847();
                  ++field442;
                  if(field442 > 750) {
                     class14.method154();
                  } else {
                     class49.method1073();

                     for(var40 = 0; var40 < field332; ++var40) {
                        var2 = field333[var40];
                        class36 var62 = field331[var2];
                        if(var62 != null) {
                           class128.method2916(var62, var62.field825.field924);
                        }
                     }

                     int[] var59 = class34.field807;

                     for(var2 = 0; var2 < class34.field804; ++var2) {
                        class2 var63 = field467[var59[var2]];
                        if(var63 != null && var63.field866 > 0) {
                           --var63.field866;
                           if(var63.field866 == 0) {
                              var63.field873 = null;
                           }
                        }
                     }

                     for(var2 = 0; var2 < field332; ++var2) {
                        var41 = field333[var2];
                        class36 var78 = field331[var41];
                        if(var78 != null && var78.field866 > 0) {
                           --var78.field866;
                           if(var78.field866 == 0) {
                              var78.field873 = null;
                           }
                        }
                     }

                     ++field485;
                     if(field406 != 0) {
                        field405 += 20;
                        if(field405 >= 400) {
                           field406 = 0;
                        }
                     }

                     if(null != class9.field160) {
                        ++field578;
                        if(field578 >= 15) {
                           class51.method1124(class9.field160);
                           class9.field160 = null;
                        }
                     }

                     class176 var60 = class99.field1699;
                     class176 var52 = class170.field2726;
                     class99.field1699 = null;
                     class170.field2726 = null;
                     field382 = null;
                     field475 = false;
                     field472 = false;
                     field518 = 0;

                     while(true) {
                        while(class122.method2812() && field518 < 128) {
                           if(field439 >= 2 && class140.field2160[82] && class53.field1162 == 66) {
                              String var79 = "";

                              class37 var75;
                              for(Iterator var53 = class11.field188.iterator(); var53.hasNext(); var79 = var79 + var75.field831 + ':' + var75.field835 + '\n') {
                                 var75 = (class37)var53.next();
                              }

                              class7.field133.setContents(new StringSelection(var79), (ClipboardOwner)null);
                           } else {
                              field520[field518] = class53.field1162;
                              field519[field518] = class107.field1868;
                              ++field518;
                           }
                        }

                        if(field454 != -1) {
                           class24.method578(field454, 0, 0, class142.field2191, class132.field2109, 0, 0);
                        }

                        ++field506;

                        while(true) {
                           class0 var64;
                           class176 var80;
                           class176 var83;
                           do {
                              var64 = (class0)field495.method3897();
                              if(null == var64) {
                                 while(true) {
                                    do {
                                       var64 = (class0)field496.method3897();
                                       if(var64 == null) {
                                          while(true) {
                                             do {
                                                var64 = (class0)field357.method3897();
                                                if(var64 == null) {
                                                   class55.method1199();
                                                   if(field492 != null) {
                                                      class51.method1124(field492);
                                                      ++field479;
                                                      if(field475 && field472) {
                                                         var41 = class143.field2198;
                                                         var4 = class143.field2201;
                                                         var41 -= field481;
                                                         var4 -= field470;
                                                         if(var41 < field473) {
                                                            var41 = field473;
                                                         }

                                                         if(field492.field2866 + var41 > field403.field2866 + field473) {
                                                            var41 = field473 + field403.field2866 - field492.field2866;
                                                         }

                                                         if(var4 < field474) {
                                                            var4 = field474;
                                                         }

                                                         if(field492.field2810 + var4 > field403.field2810 + field474) {
                                                            var4 = field403.field2810 + field474 - field492.field2810;
                                                         }

                                                         var5 = var41 - field537;
                                                         var6 = var4 - field477;
                                                         var7 = field492.field2870;
                                                         if(field479 > field492.field2835 && (var5 > var7 || var5 < -var7 || var6 > var7 || var6 < -var7)) {
                                                            field424 = true;
                                                         }

                                                         var68 = var41 - field473 + field403.field2815;
                                                         var48 = var4 - field474 + field403.field2883;
                                                         class0 var77;
                                                         if(null != field492.field2797 && field424) {
                                                            var77 = new class0();
                                                            var77.field2 = field492;
                                                            var77.field3 = var68;
                                                            var77.field13 = var48;
                                                            var77.field4 = field492.field2797;
                                                            class143.method3071(var77);
                                                         }

                                                         if(class143.field2199 == 0) {
                                                            if(field424) {
                                                               if(field492.field2792 != null) {
                                                                  var77 = new class0();
                                                                  var77.field2 = field492;
                                                                  var77.field3 = var68;
                                                                  var77.field13 = var48;
                                                                  var77.field1 = field382;
                                                                  var77.field4 = field492.field2792;
                                                                  class143.method3071(var77);
                                                               }

                                                               if(field382 != null) {
                                                                  class176 var54 = field492;
                                                                  var12 = class157.method3255(class27.method644(var54));
                                                                  if(var12 == 0) {
                                                                     var43 = null;
                                                                  } else {
                                                                     var71 = 0;

                                                                     while(true) {
                                                                        if(var71 >= var12) {
                                                                           break;
                                                                        }

                                                                        var54 = class19.method212(var54.field2813);
                                                                        if(var54 == null) {
                                                                           var43 = null;
                                                                           break;
                                                                        }

                                                                        ++var71;
                                                                     }
                                                                  }

                                                                  Object var10000 = null;
                                                               }
                                                            } else if((field433 == 1 || class22.method562(field435 - 1)) && field435 > 2) {
                                                               method282(field481 + field537, field477 + field470);
                                                            } else if(field435 > 0) {
                                                               class75.method1663(field481 + field537, field477 + field470);
                                                            }

                                                            field492 = null;
                                                         }
                                                      } else if(field479 > 1) {
                                                         field492 = null;
                                                      }
                                                   }

                                                   if(null != class159.field2356) {
                                                      class51.method1124(class159.field2356);
                                                      ++field465;
                                                      if(class143.field2199 != 0) {
                                                         if(field465 >= 5 && (class143.field2198 > field377 + 5 || class143.field2198 < field377 - 5 || class143.field2201 > 5 + field395 || class143.field2201 < field395 - 5)) {
                                                            field413 = true;
                                                         }
                                                      } else {
                                                         if(field413) {
                                                            if(class0.field14 == class159.field2356 && field412 != field409) {
                                                               class176 var65 = class159.field2356;
                                                               byte var73 = 0;
                                                               if(field394 == 1 && var65.field2916 == 206) {
                                                                  var73 = 1;
                                                               }

                                                               if(var65.field2912[field412] <= 0) {
                                                                  var73 = 0;
                                                               }

                                                               var6 = class27.method644(var65);
                                                               boolean var72 = (var6 >> 29 & 1) != 0;
                                                               if(var72) {
                                                                  var7 = field409;
                                                                  var68 = field412;
                                                                  var65.field2912[var68] = var65.field2912[var7];
                                                                  var65.field2809[var68] = var65.field2809[var7];
                                                                  var65.field2912[var7] = -1;
                                                                  var65.field2809[var7] = 0;
                                                               } else if(var73 == 1) {
                                                                  var7 = field409;
                                                                  var68 = field412;

                                                                  while(var7 != var68) {
                                                                     if(var7 > var68) {
                                                                        var65.method3532(var7 - 1, var7);
                                                                        --var7;
                                                                     } else if(var7 < var68) {
                                                                        var65.method3532(var7 + 1, var7);
                                                                        ++var7;
                                                                     }
                                                                  }
                                                               } else {
                                                                  var65.method3532(field412, field409);
                                                               }

                                                               field336.method2854(63);
                                                               field336.method2642(field412);
                                                               field336.method2795(var73);
                                                               field336.method2653(class159.field2356.field2794);
                                                               field336.method2637(field409);
                                                            }
                                                         } else if((field433 == 1 || class22.method562(field435 - 1)) && field435 > 2) {
                                                            method282(field377, field395);
                                                         } else if(field435 > 0) {
                                                            class75.method1663(field377, field395);
                                                         }

                                                         field578 = 10;
                                                         class143.field2208 = 0;
                                                         class159.field2356 = null;
                                                      }
                                                   }

                                                   if(class89.field1554 != -1) {
                                                      var41 = class89.field1554;
                                                      var4 = class89.field1566;
                                                      field336.method2854(207);
                                                      field336.method2795(5);
                                                      field336.method2642(var4 + class6.field128);
                                                      field336.method2805(class140.field2160[82]?(class140.field2160[81]?2:1):0);
                                                      field336.method2637(var41 + class19.field286);
                                                      class89.field1554 = -1;
                                                      field491 = class143.field2207;
                                                      field547 = class143.field2213;
                                                      field406 = 1;
                                                      field405 = 0;
                                                      field529 = var41;
                                                      field530 = var4;
                                                   }

                                                   if(var60 != class99.field1699) {
                                                      if(var60 != null) {
                                                         class51.method1124(var60);
                                                      }

                                                      if(class99.field1699 != null) {
                                                         class51.method1124(class99.field1699);
                                                      }
                                                   }

                                                   if(class170.field2726 != var52 && field361 == field444) {
                                                      if(null != var52) {
                                                         class51.method1124(var52);
                                                      }

                                                      if(null != class170.field2726) {
                                                         class51.method1124(class170.field2726);
                                                      }
                                                   }

                                                   if(null != class170.field2726) {
                                                      if(field444 < field361) {
                                                         ++field444;
                                                         if(field361 == field444) {
                                                            class51.method1124(class170.field2726);
                                                         }
                                                      }
                                                   } else if(field444 > 0) {
                                                      --field444;
                                                   }

                                                   var41 = class118.field2035.field896 + field358;
                                                   var4 = field360 + class118.field2035.field879;
                                                   if(class6.field123 - var41 < -500 || class6.field123 - var41 > 500 || class9.field175 - var4 < -500 || class9.field175 - var4 > 500) {
                                                      class6.field123 = var41;
                                                      class9.field175 = var4;
                                                   }

                                                   if(var41 != class6.field123) {
                                                      class6.field123 += (var41 - class6.field123) / 16;
                                                   }

                                                   if(var4 != class9.field175) {
                                                      class9.field175 += (var4 - class9.field175) / 16;
                                                   }

                                                   if(class143.field2199 == 4 && field469) {
                                                      var5 = class143.field2201 - field384;
                                                      field305 = var5 * 2;
                                                      field384 = var5 != -1 && var5 != 1?(class143.field2201 + field384) / 2:class143.field2201;
                                                      var6 = field383 - class143.field2198;
                                                      field381 = var6 * 2;
                                                      field383 = var6 != -1 && var6 != 1?(field383 + class143.field2198) / 2:class143.field2198;
                                                   } else {
                                                      if(class140.field2160[96]) {
                                                         field381 += (-24 - field381) / 2;
                                                      } else if(class140.field2160[97]) {
                                                         field381 += (24 - field381) / 2;
                                                      } else {
                                                         field381 /= 2;
                                                      }

                                                      if(class140.field2160[98]) {
                                                         field305 += (12 - field305) / 2;
                                                      } else if(class140.field2160[99]) {
                                                         field305 += (-12 - field305) / 2;
                                                      } else {
                                                         field305 /= 2;
                                                      }

                                                      field384 = class143.field2201;
                                                      field383 = class143.field2198;
                                                   }

                                                   field514 = field514 + field381 / 2 & 2047;
                                                   field379 += field305 / 2;
                                                   if(field379 < 128) {
                                                      field379 = 128;
                                                   }

                                                   if(field379 > 383) {
                                                      field379 = 383;
                                                   }

                                                   var5 = class6.field123 >> 7;
                                                   var6 = class9.field175 >> 7;
                                                   var7 = class105.method2370(class6.field123, class9.field175, class50.field1119);
                                                   var68 = 0;
                                                   if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                      for(var48 = var5 - 4; var48 <= 4 + var5; ++var48) {
                                                         for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                            var11 = class50.field1119;
                                                            if(var11 < 3 && (class5.field89[1][var48][var10] & 2) == 2) {
                                                               ++var11;
                                                            }

                                                            var12 = var7 - class5.field78[var11][var48][var10];
                                                            if(var12 > var68) {
                                                               var68 = var12;
                                                            }
                                                         }
                                                      }
                                                   }

                                                   var48 = 192 * var68;
                                                   if(var48 > 98048) {
                                                      var48 = 98048;
                                                   }

                                                   if(var48 < '耀') {
                                                      var48 = '耀';
                                                   }

                                                   if(var48 > field563) {
                                                      field563 += (var48 - field563) / 24;
                                                   } else if(var48 < field563) {
                                                      field563 += (var48 - field563) / 80;
                                                   }

                                                   if(field543) {
                                                      class59.method1321();
                                                   }

                                                   for(var41 = 0; var41 < 5; ++var41) {
                                                      ++field380[var41];
                                                   }

                                                   class11.field187.method182();
                                                   var41 = ++class143.field2200 - 1;
                                                   var5 = class140.field2176;
                                                   if(var41 > 15000 && var5 > 15000) {
                                                      field478 = 250;
                                                      class218.method4041(14500);
                                                      field336.method2854(49);
                                                   }

                                                   ++field367;
                                                   if(field367 > 500) {
                                                      field367 = 0;
                                                      var7 = (int)(Math.random() * 8.0D);
                                                      if((var7 & 1) == 1) {
                                                         field358 += field359;
                                                      }

                                                      if((var7 & 2) == 2) {
                                                         field360 += field541;
                                                      }

                                                      if((var7 & 4) == 4) {
                                                         field362 += field363;
                                                      }
                                                   }

                                                   if(field358 < -50) {
                                                      field359 = 2;
                                                   }

                                                   if(field358 > 50) {
                                                      field359 = -2;
                                                   }

                                                   if(field360 < -55) {
                                                      field541 = 2;
                                                   }

                                                   if(field360 > 55) {
                                                      field541 = -2;
                                                   }

                                                   if(field362 < -40) {
                                                      field363 = 1;
                                                   }

                                                   if(field362 > 40) {
                                                      field363 = -1;
                                                   }

                                                   ++field347;
                                                   if(field347 > 500) {
                                                      field347 = 0;
                                                      var7 = (int)(Math.random() * 8.0D);
                                                      if((var7 & 1) == 1) {
                                                         field365 += field366;
                                                      }

                                                      if((var7 & 2) == 2) {
                                                         field327 += field368;
                                                      }
                                                   }

                                                   if(field365 < -60) {
                                                      field366 = 2;
                                                   }

                                                   if(field365 > 60) {
                                                      field366 = -2;
                                                   }

                                                   if(field327 < -20) {
                                                      field368 = 1;
                                                   }

                                                   if(field327 > 10) {
                                                      field368 = -1;
                                                   }

                                                   for(class40 var81 = (class40)field558.method3861(); var81 != null; var81 = (class40)field558.method3855()) {
                                                      if((long)var81.field913 < method424() / 1000L - 5L) {
                                                         if(var81.field912 > 0) {
                                                            class25.method586(5, "", var81.field914 + " has logged in.");
                                                         }

                                                         if(var81.field912 == 0) {
                                                            class25.method586(5, "", var81.field914 + " has logged out.");
                                                         }

                                                         var81.method3997();
                                                      }
                                                   }

                                                   ++field342;
                                                   if(field342 > 50) {
                                                      field336.method2854(35);
                                                   }

                                                   try {
                                                      if(class8.field150 != null && field336.field2061 > 0) {
                                                         class8.field150.method3083(field336.field2054, 0, field336.field2061);
                                                         field336.field2061 = 0;
                                                         field342 = 0;
                                                         return;
                                                      }
                                                   } catch (IOException var55) {
                                                      class14.method154();
                                                   }

                                                   return;
                                                }

                                                var80 = var64.field2;
                                                if(var80.field2795 < 0) {
                                                   break;
                                                }

                                                var83 = class19.method212(var80.field2813);
                                             } while(null == var83 || var83.field2827 == null || var80.field2795 >= var83.field2827.length || var80 != var83.field2827[var80.field2795]);

                                             class143.method3071(var64);
                                          }
                                       }

                                       var80 = var64.field2;
                                       if(var80.field2795 < 0) {
                                          break;
                                       }

                                       var83 = class19.method212(var80.field2813);
                                    } while(var83 == null || null == var83.field2827 || var80.field2795 >= var83.field2827.length || var80 != var83.field2827[var80.field2795]);

                                    class143.method3071(var64);
                                 }
                              }

                              var80 = var64.field2;
                              if(var80.field2795 < 0) {
                                 break;
                              }

                              var83 = class19.method212(var80.field2813);
                           } while(null == var83 || var83.field2827 == null || var80.field2795 >= var83.field2827.length || var80 != var83.field2827[var80.field2795]);

                           class143.method3071(var64);
                        }
                     }
                  }
               }
            }
         }
      } else if(field301 == 40 || field301 == 45) {
         class50.method1085();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   protected final void vmethod3120() {
      if(class11.field187.method187()) {
         class11.field187.method184();
      }

      if(class175.field2782 != null) {
         class175.field2782.field216 = false;
      }

      class175.field2782 = null;
      if(class8.field150 != null) {
         class8.field150.method3088();
         class8.field150 = null;
      }

      if(class140.field2155 != null) {
         class140 var1 = class140.field2155;
         synchronized(class140.field2155) {
            class140.field2155 = null;
         }
      }

      class134.method2958();
      class127.field2087 = null;
      if(class34.field809 != null) {
         class34.field809.method1280();
      }

      if(null != class31.field744) {
         class31.field744.method1280();
      }

      class30.method665();
      Object var9 = class173.field2753;
      synchronized(class173.field2753) {
         if(class173.field2752 != 0) {
            class173.field2752 = 1;

            try {
               class173.field2753.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      try {
         class152.field2284.method4231();

         for(int var4 = 0; var4 < class21.field592; ++var4) {
            class152.field2286[var4].method4231();
         }

         class152.field2287.method4231();
         class152.field2283.method4231();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1002359516"
   )
   void method222() {
      if(class174.field2774 >= 4) {
         this.method3121("js5crc");
         field301 = 1000;
      } else {
         if(class174.field2775 >= 4) {
            if(field301 <= 5) {
               this.method3121("js5io");
               field301 = 1000;
               return;
            }

            field324 = 3000;
            class174.field2775 = 3;
         }

         if(--field324 + 1 <= 0) {
            try {
               if(field323 == 0) {
                  class43.field1009 = class107.field1869.method2994(field330, class101.field1745);
                  ++field323;
               }

               if(field323 == 1) {
                  if(class43.field1009.field2264 == 2) {
                     this.method223(-1);
                     return;
                  }

                  if(class43.field1009.field2264 == 1) {
                     ++field323;
                  }
               }

               if(field323 == 2) {
                  class7.field132 = new class146((Socket)class43.field1009.field2260, class107.field1869);
                  class122 var1 = new class122(5);
                  var1.method2795(15);
                  var1.method2598(118);
                  class7.field132.method3083(var1.field2054, 0, 5);
                  ++field323;
                  class147.field2258 = method424();
               }

               if(field323 == 3) {
                  if(field301 > 5 && class7.field132.method3081() <= 0) {
                     if(method424() - class147.field2258 > 30000L) {
                        this.method223(-2);
                        return;
                     }
                  } else {
                     int var5 = class7.field132.method3080();
                     if(var5 != 0) {
                        this.method223(var5);
                        return;
                     }

                     ++field323;
                  }
               }

               if(field323 == 4) {
                  class146 var10 = class7.field132;
                  boolean var2 = field301 > 20;
                  if(class174.field2760 != null) {
                     try {
                        class174.field2760.method3088();
                     } catch (Exception var8) {
                        ;
                     }

                     class174.field2760 = null;
                  }

                  class174.field2760 = var10;
                  class62.method1369(var2);
                  class174.field2763.field2061 = 0;
                  class13.field217 = null;
                  class17.field259 = null;
                  class174.field2769 = 0;

                  while(true) {
                     class175 var3 = (class175)class174.field2768.method3867();
                     if(var3 == null) {
                        while(true) {
                           var3 = (class175)class174.field2766.method3867();
                           if(var3 == null) {
                              if(class174.field2773 != 0) {
                                 try {
                                    class122 var11 = new class122(4);
                                    var11.method2795(4);
                                    var11.method2795(class174.field2773);
                                    var11.method2781(0);
                                    class174.field2760.method3083(var11.field2054, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class174.field2760.method3088();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class174.field2775;
                                    class174.field2760 = null;
                                 }
                              }

                              class174.field2756 = 0;
                              class174.field2758 = method424();
                              class43.field1009 = null;
                              class7.field132 = null;
                              field323 = 0;
                              field325 = 0;
                              return;
                           }

                           class174.field2764.method3973(var3);
                           class174.field2772.method3865(var3, var3.field3161);
                           ++class174.field2765;
                           --class174.field2767;
                        }
                     }

                     class174.field2759.method3865(var3, var3.field3161);
                     ++class174.field2761;
                     --class174.field2762;
                  }
               }
            } catch (IOException var9) {
               this.method223(-3);
            }

         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2074583507"
   )
   void method223(int var1) {
      class43.field1009 = null;
      class7.field132 = null;
      field323 = 0;
      if(class62.field1280 == class101.field1745) {
         class101.field1745 = class40.field911;
      } else {
         class101.field1745 = class62.field1280;
      }

      ++field325;
      if(field325 < 2 || var1 != 7 && var1 != 9) {
         if(field325 >= 2 && var1 == 6) {
            this.method3121("js5connect_outofdate");
            field301 = 1000;
         } else if(field325 >= 4) {
            if(field301 <= 5) {
               this.method3121("js5connect");
               field301 = 1000;
            } else {
               field324 = 3000;
            }
         }
      } else if(field301 <= 5) {
         this.method3121("js5connect_full");
         field301 = 1000;
      } else {
         field324 = 3000;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1356024751"
   )
   protected final void vmethod3124() {
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-902503229"
   )
   static final void method282(int var0, int var1) {
      int var2 = class146.field2233.method4179("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < field435; ++var3) {
         var4 = class146.field2233.method4179(class146.method3106(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = field435 * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > class142.field2191) {
         var4 = class142.field2191 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class132.field2109) {
         var5 = class132.field2109 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      field540 = true;
      class145.field2224 = var4;
      class172.field2749 = var5;
      class13.field213 = var2;
      class113.field1979 = 22 + field435 * 15;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method364() {
      if(field301 != 1000) {
         long var2 = method424();
         int var4 = (int)(var2 - class174.field2758);
         class174.field2758 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class174.field2756 += var4;
         boolean var1;
         if(class174.field2767 == 0 && class174.field2762 == 0 && class174.field2765 == 0 && class174.field2761 == 0) {
            var1 = true;
         } else if(class174.field2760 == null) {
            var1 = false;
         } else {
            try {
               label244: {
                  if(class174.field2756 > 30000) {
                     throw new IOException();
                  }

                  class175 var5;
                  class122 var6;
                  while(class174.field2762 < 20 && class174.field2761 > 0) {
                     var5 = (class175)class174.field2759.method3867();
                     var6 = new class122(4);
                     var6.method2795(1);
                     var6.method2675((int)var5.field3161);
                     class174.field2760.method3083(var6.field2054, 0, 4);
                     class174.field2768.method3865(var5, var5.field3161);
                     --class174.field2761;
                     ++class174.field2762;
                  }

                  while(class174.field2767 < 20 && class174.field2765 > 0) {
                     var5 = (class175)class174.field2764.method3965();
                     var6 = new class122(4);
                     var6.method2795(0);
                     var6.method2675((int)var5.field3161);
                     class174.field2760.method3083(var6.field2054, 0, 4);
                     var5.method3978();
                     class174.field2766.method3865(var5, var5.field3161);
                     --class174.field2765;
                     ++class174.field2767;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class174.field2760.method3081();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class174.field2756 = 0;
                     byte var7 = 0;
                     if(class13.field217 == null) {
                        var7 = 8;
                     } else if(class174.field2769 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class174.field2763.field2061;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class174.field2760.method3082(class174.field2763.field2054, class174.field2763.field2061, var8);
                        if(class174.field2773 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class174.field2763.field2054[var9 + class174.field2763.field2061] ^= class174.field2773;
                           }
                        }

                        class174.field2763.field2061 += var8;
                        if(class174.field2763.field2061 < var7) {
                           break;
                        }

                        if(class13.field217 == null) {
                           class174.field2763.field2061 = 0;
                           var9 = class174.field2763.method2610();
                           var10 = class174.field2763.method2612();
                           int var11 = class174.field2763.method2610();
                           var12 = class174.field2763.method2614();
                           long var13 = (long)(var10 + (var9 << 16));
                           class175 var15 = (class175)class174.field2768.method3864(var13);
                           class54.field1170 = true;
                           if(var15 == null) {
                              var15 = (class175)class174.field2766.method3864(var13);
                              class54.field1170 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class13.field217 = var15;
                           class17.field259 = new class122(var16 + var12 + class13.field217.field2779);
                           class17.field259.method2795(var11);
                           class17.field259.method2598(var12);
                           class174.field2769 = 8;
                           class174.field2763.field2061 = 0;
                        } else if(class174.field2769 == 0) {
                           if(class174.field2763.field2054[0] == -1) {
                              class174.field2769 = 1;
                              class174.field2763.field2061 = 0;
                           } else {
                              class13.field217 = null;
                           }
                        }
                     } else {
                        var8 = class17.field259.field2054.length - class13.field217.field2779;
                        var9 = 512 - class174.field2769;
                        if(var9 > var8 - class17.field259.field2061) {
                           var9 = var8 - class17.field259.field2061;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class174.field2760.method3082(class17.field259.field2054, class17.field259.field2061, var9);
                        if(class174.field2773 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class17.field259.field2054[class17.field259.field2061 + var10] ^= class174.field2773;
                           }
                        }

                        class17.field259.field2061 += var9;
                        class174.field2769 += var9;
                        if(var8 == class17.field259.field2061) {
                           if(class13.field217.field3161 == 16711935L) {
                              class43.field1017 = class17.field259;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class171 var19 = class174.field2757[var10];
                                 if(null != var19) {
                                    class43.field1017.field2061 = 5 + 8 * var10;
                                    var12 = class43.field1017.method2614();
                                    int var23 = class43.field1017.method2614();
                                    var19.method3427(var12, var23);
                                 }
                              }
                           } else {
                              class174.field2771.reset();
                              class174.field2771.update(class17.field259.field2054, 0, var8);
                              var10 = (int)class174.field2771.getValue();
                              if(var10 != class13.field217.field2778) {
                                 try {
                                    class174.field2760.method3088();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class174.field2774;
                                 class174.field2760 = null;
                                 class174.field2773 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label244;
                              }

                              class174.field2774 = 0;
                              class174.field2775 = 0;
                              class13.field217.field2777.method3429((int)(class13.field217.field3161 & 65535L), class17.field259.field2054, (class13.field217.field3161 & 16711680L) == 16711680L, class54.field1170);
                           }

                           class13.field217.method4000();
                           if(class54.field1170) {
                              --class174.field2762;
                           } else {
                              --class174.field2767;
                           }

                           class174.field2769 = 0;
                           class13.field217 = null;
                           class17.field259 = null;
                        } else {
                           if(class174.field2769 != 512) {
                              break;
                           }

                           class174.field2769 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class174.field2760.method3088();
               } catch (Exception var20) {
                  ;
               }

               ++class174.field2775;
               class174.field2760 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method222();
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1112781284"
   )
   public static synchronized long method424() {
      long var0 = System.currentTimeMillis();
      if(var0 < class118.field2034) {
         class118.field2037 += class118.field2034 - var0;
      }

      class118.field2034 = var0;
      return var0 + class118.field2037;
   }

   static {
      field320 = class21.field594;
      field321 = class21.field594;
      field288 = 0;
      field323 = 0;
      field324 = 0;
      field325 = 0;
      field420 = 0;
      field565 = 0;
      field328 = 0;
      field329 = 0;
      field331 = new class36['耀'];
      field332 = 0;
      field333 = new int['耀'];
      field334 = 0;
      field335 = new int[250];
      field336 = new class125(5000);
      field493 = new class125(5000);
      field338 = new class125(15000);
      field532 = 0;
      field549 = 0;
      field442 = 0;
      field342 = 0;
      field343 = 0;
      field434 = 0;
      field345 = 0;
      field478 = 0;
      field553 = false;
      field348 = 0;
      field364 = 1;
      field350 = 0;
      field351 = 1;
      field352 = 0;
      field407 = new class111[4];
      field355 = false;
      field356 = new int[4][13][13];
      field461 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field358 = 0;
      field359 = 2;
      field360 = 0;
      field541 = 2;
      field362 = 0;
      field363 = 1;
      field367 = 0;
      field365 = 0;
      field366 = 2;
      field327 = 0;
      field368 = 1;
      field347 = 0;
      field485 = 0;
      field373 = 2301979;
      field374 = 5063219;
      field375 = 3353893;
      field319 = 7759444;
      field339 = false;
      field378 = 0;
      field379 = 128;
      field514 = 0;
      field381 = 0;
      field305 = 0;
      field383 = 0;
      field384 = 0;
      field385 = 50;
      field386 = 0;
      field387 = false;
      field563 = 0;
      field389 = 0;
      field534 = 50;
      field410 = new int[field534];
      field392 = new int[field534];
      field393 = new int[field534];
      field391 = new int[field534];
      field480 = new int[field534];
      field453 = new int[field534];
      field397 = new int[field534];
      field398 = new String[field534];
      field311 = new int[104][104];
      field400 = 0;
      field401 = -1;
      field322 = -1;
      field491 = 0;
      field547 = 0;
      field405 = 0;
      field406 = 0;
      field578 = 0;
      field555 = 0;
      field409 = 0;
      field377 = 0;
      field395 = 0;
      field412 = 0;
      field413 = false;
      field465 = 0;
      field490 = 0;
      field467 = new class2[2048];
      field417 = -1;
      field418 = 0;
      field419 = 0;
      field315 = new int[1000];
      field421 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field422 = new String[8];
      field423 = new boolean[8];
      field548 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field425 = -1;
      field426 = new class202[4][104][104];
      field427 = new class202();
      field428 = new class202();
      field429 = new class202();
      field337 = new int[25];
      field431 = new int[25];
      field432 = new int[25];
      field433 = 0;
      field540 = false;
      field435 = 0;
      field436 = new int[500];
      field437 = new int[500];
      field438 = new int[500];
      field303 = new int[500];
      field440 = new String[500];
      field441 = new String[500];
      field295 = -1;
      field443 = -1;
      field444 = 0;
      field361 = 50;
      field459 = 0;
      field447 = null;
      field448 = false;
      field450 = -1;
      field451 = -1;
      field452 = null;
      field369 = null;
      field454 = -1;
      field455 = new class199(8);
      field456 = 0;
      field394 = 0;
      field371 = null;
      field489 = 0;
      field460 = 0;
      field439 = 0;
      field462 = -1;
      field463 = false;
      field464 = false;
      field524 = false;
      field445 = null;
      field492 = null;
      field403 = null;
      field481 = 0;
      field470 = 0;
      field382 = null;
      field472 = false;
      field473 = -1;
      field474 = -1;
      field475 = false;
      field537 = -1;
      field477 = -1;
      field424 = false;
      field506 = 1;
      field415 = new int[32];
      field482 = 0;
      field483 = new int[32];
      field484 = 0;
      field430 = new int[32];
      field486 = 0;
      field308 = 0;
      field515 = 0;
      field446 = 0;
      field408 = 0;
      field402 = 0;
      field476 = 0;
      field573 = 0;
      field357 = new class202();
      field495 = new class202();
      field496 = new class202();
      field414 = new class199(512);
      field457 = 0;
      field499 = -2;
      field500 = new boolean[100];
      field501 = new boolean[100];
      field502 = new boolean[100];
      field503 = new int[100];
      field504 = new int[100];
      field505 = new int[100];
      field466 = new int[100];
      field507 = 0;
      field508 = 0L;
      field509 = true;
      field510 = 765;
      field497 = 503;
      field512 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field513 = 0;
      field498 = 0;
      field404 = "";
      field516 = new long[100];
      field517 = 0;
      field518 = 0;
      field519 = new int[128];
      field520 = new int[128];
      field521 = -1L;
      field522 = null;
      field523 = null;
      field554 = -1;
      field525 = 0;
      field526 = new int[1000];
      field527 = new int[1000];
      field528 = new class81[1000];
      field529 = 0;
      field530 = 0;
      field531 = 0;
      field354 = 255;
      field533 = -1;
      field411 = false;
      field376 = 127;
      field536 = 127;
      field535 = 0;
      field370 = new int[50];
      field539 = new int[50];
      field449 = new int[50];
      field291 = new int[50];
      field494 = new class61[50];
      field543 = false;
      field544 = new boolean[5];
      field545 = new int[5];
      field546 = new int[5];
      field566 = new int[5];
      field380 = new int[5];
      field396 = 256;
      field550 = 205;
      field551 = 256;
      field552 = 320;
      field349 = 1;
      field458 = 32767;
      field471 = 1;
      field556 = 32767;
      field557 = 0;
      field572 = 0;
      field559 = 0;
      field562 = 0;
      field561 = 0;
      field511 = 0;
      field416 = 0;
      field564 = new class17[400];
      field558 = new class198();
      field346 = 0;
      field560 = new class7[400];
      field568 = new class182();
      field340 = -1;
      field570 = 1;
      field487 = new class223[8];
      field542 = -1L;
      field574 = -1L;
      field575 = new class10();
      field576 = new int[50];
      field577 = new int[50];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   protected final void vmethod3119() {
      boolean var1;
      label251: {
         try {
            if(class186.field2993 == 2) {
               if(null == class186.field3000) {
                  class186.field3000 = class183.method3609(class186.field2998, class119.field2041, class145.field2223);
                  if(null == class186.field3000) {
                     var1 = false;
                     break label251;
                  }
               }

               if(class98.field1695 == null) {
                  class98.field1695 = new class62(class186.field2995, class186.field3001);
               }

               if(class186.field2996.method3685(class186.field3000, class186.field2994, class98.field1695, 22050)) {
                  class186.field2996.method3686();
                  class186.field2996.method3683(class28.field695);
                  class186.field2996.method3688(class186.field3000, class102.field1760);
                  class186.field2993 = 0;
                  class186.field3000 = null;
                  class98.field1695 = null;
                  class186.field2998 = null;
                  var1 = true;
                  break label251;
               }
            }
         } catch (Exception var21) {
            var21.printStackTrace();
            class186.field2996.method3689();
            class186.field2993 = 0;
            class186.field3000 = null;
            class98.field1695 = null;
            class186.field2998 = null;
         }

         var1 = false;
      }

      if(var1 && field411 && class34.field809 != null) {
         class34.field809.method1279();
      }

      if(field301 == 10 || field301 == 20 || field301 == 30) {
         if(field508 != 0L && method424() > field508) {
            int var3 = class14.method155();
            field508 = 0L;
            if(var3 >= 2) {
               field509 = true;
            } else {
               field509 = false;
            }

            class3.method36();
            if(field301 >= 25) {
               class87.method1995();
            }

            class147.field2251 = true;
         } else if(class147.field2254) {
            Canvas var13 = class158.field2346;
            var13.removeKeyListener(class140.field2155);
            var13.removeFocusListener(class140.field2155);
            class140.field2156 = -1;
            Canvas var4 = class158.field2346;
            var4.removeMouseListener(class143.field2194);
            var4.removeMouseMotionListener(class143.field2194);
            var4.removeFocusListener(class143.field2194);
            class143.field2196 = 0;
            if(class127.field2087 != null) {
               class127.field2087.vmethod3202(class158.field2346);
            }

            field289.method3109();
            class158.field2346.setBackground(Color.black);
            class93.method2181(class158.field2346);
            Canvas var5 = class158.field2346;
            var5.addMouseListener(class143.field2194);
            var5.addMouseMotionListener(class143.field2194);
            var5.addFocusListener(class143.field2194);
            if(class127.field2087 != null) {
               class127.field2087.vmethod3196(class158.field2346);
            }

            if(field454 != -1) {
               class118.method2544(field454, class142.field2191, class132.field2109, false);
            }

            class147.field2253 = true;
         }
      }

      Dimension var23 = this.method3107();
      if(class116.field2025 != var23.width || var23.height != class16.field246 || class147.field2253) {
         class3.method36();
         field508 = method424() + 500L;
         class147.field2253 = false;
      }

      boolean var14 = false;
      int var15;
      if(class147.field2251) {
         class147.field2251 = false;
         var14 = true;

         for(var15 = 0; var15 < 100; ++var15) {
            field500[var15] = true;
         }
      }

      if(var14) {
         class101.method2285();
      }

      if(field301 == 0) {
         var15 = class33.field776;
         String var6 = class33.field777;
         Color var7 = null;

         try {
            Graphics var8 = class158.field2346.getGraphics();
            if(class146.field2236 == null) {
               class146.field2236 = new Font("Helvetica", 1, 13);
               class26.field662 = class158.field2346.getFontMetrics(class146.field2236);
            }

            if(var14) {
               var8.setColor(Color.black);
               var8.fillRect(0, 0, class142.field2191, class132.field2109);
            }

            if(null == var7) {
               var7 = new Color(140, 17, 17);
            }

            try {
               if(class54.field1171 == null) {
                  class54.field1171 = class158.field2346.createImage(304, 34);
               }

               Graphics var9 = class54.field1171.getGraphics();
               var9.setColor(var7);
               var9.drawRect(0, 0, 303, 33);
               var9.fillRect(2, 2, 3 * var15, 30);
               var9.setColor(Color.black);
               var9.drawRect(1, 1, 301, 31);
               var9.fillRect(var15 * 3 + 2, 2, 300 - 3 * var15, 30);
               var9.setFont(class146.field2236);
               var9.setColor(Color.white);
               var9.drawString(var6, (304 - class26.field662.stringWidth(var6)) / 2, 22);
               var8.drawImage(class54.field1171, class142.field2191 / 2 - 152, class132.field2109 / 2 - 18, (ImageObserver)null);
            } catch (Exception var17) {
               int var10 = class142.field2191 / 2 - 152;
               int var11 = class132.field2109 / 2 - 18;
               var8.setColor(var7);
               var8.drawRect(var10, var11, 303, 33);
               var8.fillRect(2 + var10, 2 + var11, 3 * var15, 30);
               var8.setColor(Color.black);
               var8.drawRect(var10 + 1, 1 + var11, 301, 31);
               var8.fillRect(var15 * 3 + var10 + 2, var11 + 2, 300 - 3 * var15, 30);
               var8.setFont(class146.field2236);
               var8.setColor(Color.white);
               var8.drawString(var6, var10 + (304 - class26.field662.stringWidth(var6)) / 2, 22 + var11);
            }
         } catch (Exception var18) {
            class158.field2346.repaint();
         }
      } else if(field301 == 5) {
         class14.method156(class146.field2233, class164.field2683, class104.field1834, var14);
      } else if(field301 != 10 && field301 != 11) {
         if(field301 == 20) {
            class14.method156(class146.field2233, class164.field2683, class104.field1834, var14);
         } else if(field301 == 25) {
            if(field352 == 1) {
               if(field348 > field364) {
                  field364 = field348;
               }

               var15 = (field364 * 50 - field348 * 50) / field364;
               class96.method2260("Loading - please wait." + "<br>" + " (" + var15 + "%" + ")", false);
            } else if(field352 == 2) {
               if(field350 > field351) {
                  field351 = field350;
               }

               var15 = (field351 * 50 - field350 * 50) / field351 + 50;
               class96.method2260("Loading - please wait." + "<br>" + " (" + var15 + "%" + ")", false);
            } else {
               class96.method2260("Loading - please wait.", false);
            }
         } else if(field301 == 30) {
            class49.method1074();
         } else if(field301 == 40) {
            class96.method2260("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field301 == 45) {
            class96.method2260("Please wait...", false);
         }
      } else {
         class14.method156(class146.field2233, class164.field2683, class104.field1834, var14);
      }

      int var16;
      Graphics var22;
      if(field301 == 30 && field507 == 0 && !var14) {
         try {
            var22 = class158.field2346.getGraphics();

            for(var16 = 0; var16 < field457; ++var16) {
               if(field501[var16]) {
                  class44.field1039.vmethod1968(var22, field503[var16], field504[var16], field505[var16], field466[var16]);
                  field501[var16] = false;
               }
            }
         } catch (Exception var20) {
            class158.field2346.repaint();
         }
      } else if(field301 > 0) {
         try {
            var22 = class158.field2346.getGraphics();
            class44.field1039.vmethod1975(var22, 0, 0);

            for(var16 = 0; var16 < field457; ++var16) {
               field501[var16] = false;
            }
         } catch (Exception var19) {
            class158.field2346.repaint();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "-1053588769"
   )
   public static void method474(class170 var0, class170 var1) {
      class41.field951 = var0;
      class41.field919 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1249567602"
   )
   public static boolean method513(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
