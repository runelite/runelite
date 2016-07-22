import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.management.GarbageCollectorMXBean;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
public final class client extends class147 {
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      longValue = -3153052468216480239L
   )
   static long field269;
   @ObfuscatedName("e")
   static client field270;
   @ObfuscatedName("o")
   static boolean field271 = true;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 869185865
   )
   @Export("world")
   static int field272 = 1;
   @ObfuscatedName("ov")
   @Export("friends")
   static class17[] field273;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 1671355869
   )
   static int field274;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1417382813
   )
   static int field275 = 0;
   @ObfuscatedName("h")
   @Export("isMembers")
   static boolean field276 = false;
   @ObfuscatedName("u")
   static boolean field277 = false;
   @ObfuscatedName("mm")
   static int[] field278;
   @ObfuscatedName("fn")
   static int[] field279;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -572146141
   )
   @Export("gameState")
   static int field280 = 0;
   @ObfuscatedName("c")
   static boolean field281 = true;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -300383021
   )
   @Export("gameCycle")
   static int field282 = 0;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 180078651
   )
   static int field283;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1956414181
   )
   static int field284;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 1301952611
   )
   static int field285;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 353776771
   )
   static int field286 = -1;
   @ObfuscatedName("an")
   static boolean field287 = true;
   @ObfuscatedName("nf")
   static int[] field288;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 747760845
   )
   static int field289 = 0;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1248729405
   )
   static int field290;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2133851127
   )
   static int field291 = 0;
   @ObfuscatedName("jj")
   static class176 field292;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -877858147
   )
   static int field293 = 0;
   @ObfuscatedName("ha")
   @Export("menuActionParams0")
   static int[] field294;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1397489507
   )
   static int field295 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1969137849
   )
   static int field296 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 2113874663
   )
   static int field297 = 0;
   @ObfuscatedName("ay")
   static class21 field298;
   @ObfuscatedName("px")
   static int[] field299;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 1159192801
   )
   static int field300;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -321265113
   )
   static int field301;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -380548087
   )
   static int field302;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 477632591
   )
   static int field303;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -904341883
   )
   static int field304;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1502196443
   )
   static int field305;
   @ObfuscatedName("hu")
   static int[] field306;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -2085630119
   )
   static int field307;
   @ObfuscatedName("cx")
   @Export("cachedNPCs")
   static class36[] field308;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1412417255
   )
   static int field309 = 0;
   @ObfuscatedName("cz")
   static int[] field310;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -967358817
   )
   static int field311;
   @ObfuscatedName("cf")
   static int[] field312;
   @ObfuscatedName("cl")
   static class125 field313;
   @ObfuscatedName("ce")
   static class125 field314;
   @ObfuscatedName("cu")
   static class125 field315;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 1887358047
   )
   static int field316;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -43709387
   )
   @Export("packetOpcode")
   static int field317;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 853224701
   )
   static int field318;
   @ObfuscatedName("lz")
   static int[] field319;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1233213837
   )
   static int field320;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 1070197663
   )
   static int field321;
   @ObfuscatedName("id")
   @Export("menuIdentifiers")
   static int[] field322;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 673023625
   )
   static int field323;
   @ObfuscatedName("cq")
   static boolean field324;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -687491513
   )
   static int field325;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -1978811959
   )
   static int field326;
   @ObfuscatedName("ku")
   static class202 field327;
   @ObfuscatedName("ig")
   @Export("menuTargets")
   static String[] field328;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -789650661
   )
   static int field329;
   @ObfuscatedName("dl")
   @Export("xteaKeys")
   static int[][] field330;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class111[] field331;
   @ObfuscatedName("dd")
   static boolean field332;
   @ObfuscatedName("dn")
   static int[][][] field333;
   @ObfuscatedName("dj")
   static final int[] field334;
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      longValue = 6974825323065872211L
   )
   static long field335;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -31391405
   )
   static int field336 = 0;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 1390425381
   )
   static int field337;
   @ObfuscatedName("ap")
   static boolean field338 = false;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1425333537
   )
   static int field339;
   @ObfuscatedName("gy")
   static boolean field340;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = -1949582363
   )
   static int field341;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1413032325
   )
   @Export("mapScale")
   static int field342;
   @ObfuscatedName("ff")
   static int[] field343;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -140509005
   )
   static int field344;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 2129124615
   )
   static int field345;
   @ObfuscatedName("nv")
   static int[] field346;
   @ObfuscatedName("oq")
   static short field347;
   @ObfuscatedName("ew")
   static class81[] field348;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1762523663
   )
   static int field349;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -554304307
   )
   static int field350;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -1460066319
   )
   static int field351;
   @ObfuscatedName("jz")
   static class176 field352;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -236435365
   )
   static int field353;
   @ObfuscatedName("ef")
   static boolean field354;
   @ObfuscatedName("ah")
   static class21 field355;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 1107001689
   )
   static int field356;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -485763403
   )
   @Export("mapAngle")
   static int field357;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1807383083
   )
   static int field358;
   @ObfuscatedName("ld")
   @Export("widgetBoundsWidth")
   static int[] field359;
   @ObfuscatedName("ll")
   @Export("isResized")
   static boolean field360;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -1390431231
   )
   static int field361;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -535185551
   )
   static int field362;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 73425379
   )
   static int field363;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -1735824489
   )
   @Export("camera3")
   static int field364;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 2005239973
   )
   static int field365;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 284040327
   )
   static int field366;
   @ObfuscatedName("ow")
   static short field367;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = -781154785
   )
   static int field368;
   @ObfuscatedName("hd")
   static class202 field369;
   @ObfuscatedName("fb")
   static int[] field370;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1320585829
   )
   static int field371 = -1;
   @ObfuscatedName("fw")
   static int[] field372;
   @ObfuscatedName("fg")
   static int[] field373;
   @ObfuscatedName("fm")
   static int[] field374;
   @ObfuscatedName("gp")
   static String[] field375;
   @ObfuscatedName("gl")
   static int[][] field376;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -2141146527
   )
   static int field377;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 345020051
   )
   static int field378;
   @ObfuscatedName("em")
   static class83[] field379;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -1776301027
   )
   static int field380;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = 1261029531
   )
   static int field381;
   @ObfuscatedName("ka")
   static class202 field382;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -72223281
   )
   static int field383;
   @ObfuscatedName("ok")
   @Export("ignores")
   static class7[] field384;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1702475975
   )
   static int field385;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -1064496831
   )
   static int field386;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1770016599
   )
   static int field387;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1215125845
   )
   static int field388;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 486685087
   )
   static int field389;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -1558925797
   )
   static int field390;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -533778743
   )
   static int field391;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -422230707
   )
   static int field392;
   @ObfuscatedName("gv")
   @Export("cachedPlayers")
   static class2[] field393;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -505276575
   )
   static int field394;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 138110521
   )
   static int field395;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -1750002533
   )
   static int field396;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 211907837
   )
   static int field397;
   @ObfuscatedName("hy")
   static final int[] field398;
   @ObfuscatedName("hj")
   static String[] field399;
   @ObfuscatedName("hp")
   static boolean[] field400;
   @ObfuscatedName("oy")
   static class198 field401;
   @ObfuscatedName("jb")
   static class176 field402;
   @ObfuscatedName("ht")
   @Export("groundItemDeque")
   static class202[][][] field403;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 268136119
   )
   static int field404;
   @ObfuscatedName("hs")
   @Export("projectiles")
   static class202 field405;
   @ObfuscatedName("hx")
   static class202 field406;
   @ObfuscatedName("hh")
   @Export("boostedSkillLevels")
   static int[] field407;
   @ObfuscatedName("hn")
   @Export("realSkillLevels")
   static int[] field408;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 386920039
   )
   static int field409;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 502433493
   )
   static int field410;
   @ObfuscatedName("j")
   static class156 field411;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1553635037
   )
   @Export("menuOptionCount")
   static int field412;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 1657727961
   )
   static int field413;
   @ObfuscatedName("hl")
   @Export("menuActionParams1")
   static int[] field414;
   @ObfuscatedName("iv")
   @Export("menuTypes")
   static int[] field415;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 2048135747
   )
   static int field416;
   @ObfuscatedName("is")
   @Export("menuOptions")
   static String[] field417;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1261049993
   )
   static int field418 = 0;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = 1900488459
   )
   static int field419;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 2043186111
   )
   static int field420;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 510102015
   )
   static int field421;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -1249250405
   )
   static int field422;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -556065979
   )
   static int field423;
   @ObfuscatedName("ix")
   static String field424;
   @ObfuscatedName("om")
   static short field425;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1576168705
   )
   static int field426;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 1209754207
   )
   static int field427;
   @ObfuscatedName("ii")
   static String field428;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -258150501
   )
   static int field429;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = -1301130953
   )
   @Export("widgetRoot")
   static int field430;
   @ObfuscatedName("hi")
   static int[] field431;
   @ObfuscatedName("fi")
   static boolean field432;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -559600341
   )
   static int field433;
   @ObfuscatedName("ns")
   static int[] field434;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 78614851
   )
   @Export("energy")
   static int field435;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -129372113
   )
   @Export("weight")
   static int field436;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1043991111
   )
   static int field437;
   @ObfuscatedName("if")
   static String field438;
   @ObfuscatedName("jc")
   static boolean field439;
   @ObfuscatedName("jm")
   static boolean field440;
   @ObfuscatedName("jq")
   static boolean field441;
   @ObfuscatedName("pw")
   static int[] field442;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 2022144373
   )
   static int field443;
   @ObfuscatedName("iy")
   static boolean field444;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -806230079
   )
   static int field445;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 419720351
   )
   static int field446;
   @ObfuscatedName("jh")
   static class176 field447;
   @ObfuscatedName("ji")
   static boolean field448;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -1893511925
   )
   static int field449;
   @ObfuscatedName("nl")
   static class61[] field450;
   @ObfuscatedName("ju")
   static boolean field451;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 610910503
   )
   static int field452;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -583170075
   )
   static int field453;
   @ObfuscatedName("jw")
   static boolean field454;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -409508631
   )
   static int field455;
   @ObfuscatedName("ke")
   static int[] field456;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 1214357163
   )
   static int field457;
   @ObfuscatedName("kd")
   static int[] field458;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 1722412903
   )
   static int field459;
   @ObfuscatedName("kh")
   static boolean[] field460;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 2124193381
   )
   static int field461;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -1493427795
   )
   static int field462;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -2094818595
   )
   static int field463;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = -1740047135
   )
   @Export("flagY")
   static int field464;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -360676219
   )
   static int field465;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -1858452663
   )
   static int field466;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1153144061
   )
   static int field467;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 1050953353
   )
   static int field468;
   @ObfuscatedName("hv")
   @Export("skillExperiences")
   static int[] field469;
   @ObfuscatedName("kg")
   static class202 field470;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -870302527
   )
   static int field471;
   @ObfuscatedName("kw")
   @Export("widgetFlags")
   static class199 field472;
   @ObfuscatedName("s")
   static String field473;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -543272685
   )
   static int field474;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -599977069
   )
   static int field475;
   @ObfuscatedName("li")
   static boolean[] field476;
   @ObfuscatedName("lm")
   static boolean[] field477;
   @ObfuscatedName("ly")
   @Export("widgetPositionX")
   static int[] field478;
   @ObfuscatedName("lb")
   @Export("widgetPositionY")
   static int[] field479;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1879387297
   )
   @Export("flags")
   static int field480 = 0;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1365162231
   )
   static int field481;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -742522279
   )
   static int field482;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      longValue = -7189012272728344083L
   )
   static long field483;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 1387517637
   )
   @Export("mapScaleDelta")
   static int field484;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = 1675507571
   )
   static int field485;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -42623835
   )
   static int field486;
   @ObfuscatedName("lo")
   static int[] field487;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 1331106253
   )
   static int field488;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = -1060316783
   )
   static int field489;
   @ObfuscatedName("lh")
   static String field490;
   @ObfuscatedName("oz")
   static int[] field491;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 1318931393
   )
   static int field492;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -432762587
   )
   static int field493;
   @ObfuscatedName("le")
   @Export("widgetBoundsHeight")
   static int[] field495;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      longValue = -2516104124406783925L
   )
   static long field496;
   @ObfuscatedName("mz")
   static String field497;
   @ObfuscatedName("mg")
   static String field498;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -1956615969
   )
   static int field499;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 2107309933
   )
   static int field500;
   @ObfuscatedName("mq")
   static int[] field501;
   @ObfuscatedName("mw")
   static int[] field502;
   @ObfuscatedName("mt")
   static class81[] field503;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 165872229
   )
   @Export("flagX")
   static int field504;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 282195949
   )
   static int field505;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = -58029295
   )
   static int field506;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 841774165
   )
   static int field507;
   @ObfuscatedName("of")
   static short field508;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -725876287
   )
   static int field509;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -959764437
   )
   static int field510;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 1603928217
   )
   static int field511;
   @ObfuscatedName("fh")
   static int[] field512;
   @ObfuscatedName("nx")
   static int[] field513;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 352425545
   )
   static int field514;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 1389705477
   )
   static int field515;
   @ObfuscatedName("os")
   static class182 field516;
   @ObfuscatedName("hb")
   @Export("isMenuOpen")
   static boolean field517;
   @ObfuscatedName("np")
   static boolean field518;
   @ObfuscatedName("nw")
   static boolean[] field519;
   @ObfuscatedName("on")
   static int[] field520;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -3497571
   )
   static int field521;
   @ObfuscatedName("oo")
   static int[] field522;
   @ObfuscatedName("od")
   static int[] field523;
   @ObfuscatedName("ou")
   static short field524;
   @ObfuscatedName("og")
   static short field525;
   @ObfuscatedName("lx")
   static long[] field526;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1462362313
   )
   static int field527;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -218594067
   )
   static int field528;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2120374821
   )
   static int field529 = -1;
   @ObfuscatedName("ot")
   static short field530;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 1505725041
   )
   static int field531;
   @ObfuscatedName("my")
   static boolean field532;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1332624125
   )
   static int field533 = 0;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 1612658683
   )
   @Export("camera2")
   static int field534;
   @ObfuscatedName("ia")
   @Export("componentTable")
   static class199 field535;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = -1608738983
   )
   @Export("scale")
   static int field536;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 262468143
   )
   @Export("friendCount")
   static int field537;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -2114374121
   )
   static int field538;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 7506719446450225363L
   )
   static long field539 = -1L;
   @ObfuscatedName("jl")
   static class176 field540;
   @ObfuscatedName("kv")
   static int[] field541;
   @ObfuscatedName("ol")
   static short field542;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 2057268275
   )
   @Export("ignoreCount")
   static int field543;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 1314774827
   )
   static int field544;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 1360597075
   )
   static int field545;
   @ObfuscatedName("ph")
   @Export("grandExchangeOffers")
   static class223[] field546;
   @ObfuscatedName("py")
   static GarbageCollectorMXBean field547;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -41440565
   )
   static int field548;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1795847481
   )
   static int field549;
   @ObfuscatedName("pe")
   static final class10 field550;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 576488953
   )
   @Export("localInteractingIndex")
   static int field551;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 1915209877
   )
   static int field552;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1092113035
   )
   static int field553;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 1750658663
   )
   static int field554;

   public final void init() {
      if(this.method3068()) {
         class193[] var1 = class119.method2518();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class193 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3111);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3111)) {
               case 1:
                  class106.field1839 = var4;
               case 2:
               case 12:
               case 14:
               default:
                  break;
               case 3:
                  field275 = Integer.parseInt(var4);
                  break;
               case 4:
                  field533 = Integer.parseInt(var4);
                  break;
               case 5:
                  field473 = var4;
                  break;
               case 6:
                  class56.field1240 = (class157)class5.method77(class160.method3216(), Integer.parseInt(var4));
                  if(class56.field1240 == class157.field2342) {
                     class134.field2117 = class215.field3191;
                  } else {
                     class134.field2117 = class215.field3187;
                  }
                  break;
               case 7:
                  field411 = class102.method2283(Integer.parseInt(var4));
                  break;
               case 8:
                  if(var4.equalsIgnoreCase("true")) {
                     field276 = true;
                  } else {
                     field276 = false;
                  }
                  break;
               case 9:
                  field272 = Integer.parseInt(var4);
                  break;
               case 10:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 11:
                  class35.field796 = Integer.parseInt(var4);
                  break;
               case 13:
                  field480 = Integer.parseInt(var4);
                  break;
               case 15:
                  class145.field2237 = Integer.parseInt(var4);
               }
            }
         }

         class1.method6();
         class124.field2060 = this.getCodeBase().getHost();
         String var17 = field411.field2334;
         byte var18 = 0;

         try {
            class152.field2294 = 16;
            class21.field574 = var18;

            try {
               class169.field2721 = System.getProperty("os.name");
            } catch (Exception var14) {
               class169.field2721 = "Unknown";
            }

            class98.field1693 = class169.field2721.toLowerCase();

            try {
               class52.field1155 = System.getProperty("user.home");
               if(class52.field1155 != null) {
                  class52.field1155 = class52.field1155 + "/";
               }
            } catch (Exception var13) {
               ;
            }

            try {
               if(class98.field1693.startsWith("win")) {
                  if(class52.field1155 == null) {
                     class52.field1155 = System.getenv("USERPROFILE");
                  }
               } else if(null == class52.field1155) {
                  class52.field1155 = System.getenv("HOME");
               }

               if(null != class52.field1155) {
                  class52.field1155 = class52.field1155 + "/";
               }
            } catch (Exception var12) {
               ;
            }

            if(null == class52.field1155) {
               class52.field1155 = "~/";
            }

            class53.field1159 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class52.field1155, "/tmp/", ""};
            class52.field1154 = new String[]{".jagex_cache_" + class21.field574, ".file_store_" + class21.field574};

            int var8;
            label154:
            for(var8 = 0; var8 < 4; ++var8) {
               class152.field2291 = class8.method118("oldschool", var17, var8);
               if(!class152.field2291.exists()) {
                  class152.field2291.mkdirs();
               }

               File[] var20 = class152.field2291.listFiles();
               if(null == var20) {
                  break;
               }

               File[] var5 = var20;
               int var6 = 0;

               while(true) {
                  if(var6 >= var5.length) {
                     break label154;
                  }

                  File var7 = var5[var6];
                  if(!class114.method2490(var7, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            class102.method2281(class152.field2291);

            try {
               File var19 = new File(class52.field1155, "random.dat");
               int var10;
               if(var19.exists()) {
                  class152.field2295 = new class231(new class230(var19, "rw", 25L), 24, 0);
               } else {
                  label134:
                  for(int var9 = 0; var9 < class52.field1154.length; ++var9) {
                     for(var10 = 0; var10 < class53.field1159.length; ++var10) {
                        File var11 = new File(class53.field1159[var10] + class52.field1154[var9] + File.separatorChar + "random.dat");
                        if(var11.exists()) {
                           class152.field2295 = new class231(new class230(var11, "rw", 25L), 24, 0);
                           break label134;
                        }
                     }
                  }
               }

               if(null == class152.field2295) {
                  RandomAccessFile var21 = new RandomAccessFile(var19, "rw");
                  var10 = var21.read();
                  var21.seek(0L);
                  var21.write(var10);
                  var21.seek(0L);
                  var21.close();
                  class152.field2295 = new class231(new class230(var19, "rw", 25L), 24, 0);
               }
            } catch (IOException var15) {
               ;
            }

            class152.field2290 = new class231(new class230(class15.method173("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class152.field2289 = new class231(new class230(class15.method173("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class99.field1702 = new class231[class152.field2294];

            for(var8 = 0; var8 < class152.field2294; ++var8) {
               class99.field1702[var8] = new class231(new class230(class15.method173("main_file_cache.idx" + var8), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var16) {
            class54.method1130((String)null, var16);
         }

         field270 = this;
         this.method3131(765, 503, 119);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1323697636"
   )
   protected final void vmethod3075() {
      class116.field2019 = field275 == 0?'ꩊ':'鱀' + field272;
      class0.field6 = field275 == 0?443:field272 + '썐';
      class42.field991 = class116.field2019;
      class182.field2968 = class177.field2933;
      class182.field2969 = class177.field2936;
      class50.field1111 = class177.field2932;
      class17.field225 = class177.field2931;
      if(class139.field2147.toLowerCase().indexOf("microsoft") != -1) {
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

      class90.method2159(class112.field1965);
      class1.method4(class112.field1965);
      class212.field3171 = class0.method2();
      if(class212.field3171 != null) {
         class212.field3171.vmethod3155(class112.field1965);
      }

      class217.field3196 = new class137(255, class152.field2290, class152.field2289, 500000);
      class230 var2 = null;
      class8 var3 = new class8();

      try {
         var2 = class7.method96("", class56.field1240.field2343, false);
         byte[] var4 = new byte[(int)var2.method4214()];

         int var6;
         for(int var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.method4210(var4, var5, var4.length - var5);
            if(var6 == -1) {
               throw new IOException();
            }
         }

         var3 = new class8(new class122(var4));
      } catch (Exception var9) {
         ;
      }

      try {
         if(var2 != null) {
            var2.method4223();
         }
      } catch (Exception var8) {
         ;
      }

      class12.field162 = var3;
      class4.field73 = this.getToolkit().getSystemClipboard();
      class23.method578(this, class116.field2011);
      if(field275 != 0) {
         field338 = true;
      }

      int var7 = class12.field162.field136;
      field483 = 0L;
      if(var7 >= 2) {
         field360 = true;
      } else {
         field360 = false;
      }

      class16.method181();
      if(field280 >= 25) {
         class177.method3493();
      }

      class147.field2265 = true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "22050"
   )
   protected final void vmethod3107() {
      boolean var1;
      label229: {
         try {
            if(class186.field3004 == 2) {
               if(null == class10.field152) {
                  class10.field152 = class183.method3568(class128.field2089, class105.field1834, class186.field3009);
                  if(class10.field152 == null) {
                     var1 = false;
                     break label229;
                  }
               }

               if(class138.field2137 == null) {
                  class138.field2137 = new class62(class186.field3006, class186.field3005);
               }

               if(class186.field3007.method3684(class10.field152, class186.field3011, class138.field2137, 22050)) {
                  class186.field3007.method3656();
                  class186.field3007.method3653(class40.field903);
                  class186.field3007.method3722(class10.field152, class133.field2111);
                  class186.field3004 = 0;
                  class10.field152 = null;
                  class138.field2137 = null;
                  class128.field2089 = null;
                  var1 = true;
                  break label229;
               }
            }
         } catch (Exception var12) {
            var12.printStackTrace();
            class186.field3007.method3750();
            class186.field3004 = 0;
            class10.field152 = null;
            class138.field2137 = null;
            class128.field2089 = null;
         }

         var1 = false;
      }

      if(var1 && field532 && null != class36.field799) {
         class36.field799.method1299();
      }

      int var5;
      int var6;
      if(field280 == 10 || field280 == 20 || field280 == 30) {
         if(field483 != 0L && class193.method3805() > field483) {
            int var3 = field360?2:1;
            field483 = 0L;
            if(var3 >= 2) {
               field360 = true;
            } else {
               field360 = false;
            }

            class16.method181();
            if(field280 >= 25) {
               class177.method3493();
            }

            class147.field2265 = true;
         } else if(class147.field2258) {
            class90.method2160(class112.field1965);
            Canvas var8 = class112.field1965;
            var8.removeMouseListener(class143.field2212);
            var8.removeMouseMotionListener(class143.field2212);
            var8.removeFocusListener(class143.field2212);
            class143.field2209 = 0;
            if(class212.field3171 != null) {
               class212.field3171.vmethod3156(class112.field1965);
            }

            field270.method3125();
            class112.field1965.setBackground(Color.black);
            class90.method2159(class112.field1965);
            class1.method4(class112.field1965);
            if(null != class212.field3171) {
               class212.field3171.vmethod3155(class112.field1965);
            }

            if(field430 != -1) {
               int var4 = field430;
               var5 = class12.field174;
               var6 = class19.field264;
               if(class122.method2739(var4)) {
                  class6.method93(class176.field2814[var4], -1, var5, var6, false);
               }
            }

            class147.field2257 = true;
         }
      }

      Dimension var14 = this.method3081();
      if(var14.width != class128.field2092 || var14.height != class112.field1962 || class147.field2257) {
         class16.method181();
         field483 = class193.method3805() + 500L;
         class147.field2257 = false;
      }

      boolean var13 = false;
      if(class147.field2265) {
         class147.field2265 = false;
         var13 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field460[var5] = true;
         }
      }

      if(var13) {
         class7.method102();
      }

      if(field280 == 0) {
         class140.method2982(class33.field747, class33.field746, (Color)null, var13);
      } else if(field280 == 5) {
         class143.method3028(class1.field25, class12.field171, class15.field201, var13);
      } else if(field280 != 10 && field280 != 11) {
         if(field280 == 20) {
            class143.method3028(class1.field25, class12.field171, class15.field201, var13);
         } else if(field280 == 25) {
            if(field416 == 1) {
               if(field325 > field326) {
                  field326 = field325;
               }

               var5 = (field326 * 50 - field325 * 50) / field326;
               class15.method175("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field416 == 2) {
               if(field459 > field521) {
                  field521 = field459;
               }

               var5 = 50 + (field521 * 50 - field459 * 50) / field521;
               class15.method175("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class15.method175("Loading - please wait.", false);
            }
         } else if(field280 == 30) {
            class55.method1190();
         } else if(field280 == 40) {
            class15.method175("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field280 == 45) {
            class15.method175("Please wait...", false);
         }
      } else {
         class143.method3028(class1.field25, class12.field171, class15.field201, var13);
      }

      Graphics var9;
      if(field280 == 30 && field482 == 0 && !var13) {
         try {
            var9 = class112.field1965.getGraphics();

            for(var6 = 0; var6 < field413; ++var6) {
               if(field476[var6]) {
                  class78.field1454.vmethod1960(var9, field478[var6], field479[var6], field359[var6], field495[var6]);
                  field476[var6] = false;
               }
            }
         } catch (Exception var11) {
            class112.field1965.repaint();
         }
      } else if(field280 > 0) {
         try {
            var9 = class112.field1965.getGraphics();
            class78.field1454.vmethod1959(var9, 0, 0);

            for(var6 = 0; var6 < field413; ++var6) {
               field476[var6] = false;
            }
         } catch (Exception var10) {
            class112.field1965.repaint();
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-56"
   )
   void method238() {
      if(class174.field2777 >= 4) {
         this.method3079("js5crc");
         field280 = 1000;
      } else {
         if(class174.field2767 >= 4) {
            if(field280 <= 5) {
               this.method3079("js5io");
               field280 = 1000;
               return;
            }

            field302 = 3000;
            class174.field2767 = 3;
         }

         if(--field302 + 1 <= 0) {
            try {
               if(field301 == 0) {
                  class47.field1067 = class40.field900.method2936(class124.field2060, class42.field991);
                  ++field301;
               }

               if(field301 == 1) {
                  if(class47.field1067.field2278 == 2) {
                     this.method438(-1);
                     return;
                  }

                  if(class47.field1067.field2278 == 1) {
                     ++field301;
                  }
               }

               if(field301 == 2) {
                  class44.field1021 = new class146((Socket)class47.field1067.field2282, class40.field900);
                  class122 var1 = new class122(5);
                  var1.method2557(15);
                  var1.method2560(119);
                  class44.field1021.method3045(var1.field2047, 0, 5);
                  ++field301;
                  class212.field3170 = class193.method3805();
               }

               if(field301 == 3) {
                  if(field280 > 5 && class44.field1021.method3044() <= 0) {
                     if(class193.method3805() - class212.field3170 > 30000L) {
                        this.method438(-2);
                        return;
                     }
                  } else {
                     int var2 = class44.field1021.method3042();
                     if(var2 != 0) {
                        this.method438(var2);
                        return;
                     }

                     ++field301;
                  }
               }

               if(field301 == 4) {
                  class163.method3222(class44.field1021, field280 > 20);
                  class47.field1067 = null;
                  class44.field1021 = null;
                  field301 = 0;
                  field303 = 0;
               }
            } catch (IOException var3) {
               this.method438(-3);
            }

         }
      }
   }

   static {
      field298 = class21.field581;
      field355 = class21.field581;
      field509 = 0;
      field301 = 0;
      field302 = 0;
      field303 = 0;
      field304 = 0;
      field305 = 0;
      field420 = 0;
      field307 = 0;
      field308 = new class36['耀'];
      field394 = 0;
      field310 = new int['耀'];
      field311 = 0;
      field312 = new int[250];
      field313 = new class125(5000);
      field314 = new class125(5000);
      field315 = new class125(15000);
      field283 = 0;
      field317 = 0;
      field318 = 0;
      field362 = 0;
      field320 = 0;
      field321 = 0;
      field290 = 0;
      field323 = 0;
      field324 = false;
      field325 = 0;
      field326 = 1;
      field459 = 0;
      field521 = 1;
      field416 = 0;
      field331 = new class111[4];
      field332 = false;
      field333 = new int[4][13][13];
      field334 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field341 = 0;
      field545 = 2;
      field337 = 0;
      field285 = 2;
      field339 = 0;
      field368 = 1;
      field381 = 0;
      field342 = 0;
      field421 = 2;
      field484 = 0;
      field345 = 1;
      field499 = 0;
      field329 = 0;
      field350 = 2301979;
      field481 = 5063219;
      field349 = 3353893;
      field353 = 7759444;
      field354 = false;
      field505 = 0;
      field356 = 128;
      field357 = 0;
      field358 = 0;
      field475 = 0;
      field471 = 0;
      field361 = 0;
      field437 = 50;
      field363 = 0;
      field432 = false;
      field365 = 0;
      field366 = 0;
      field300 = 50;
      field343 = new int[field300];
      field279 = new int[field300];
      field370 = new int[field300];
      field512 = new int[field300];
      field372 = new int[field300];
      field373 = new int[field300];
      field374 = new int[field300];
      field375 = new String[field300];
      field376 = new int[104][104];
      field377 = 0;
      field378 = -1;
      field397 = -1;
      field380 = 0;
      field351 = 0;
      field423 = 0;
      field383 = 0;
      field488 = 0;
      field385 = 0;
      field386 = 0;
      field387 = 0;
      field388 = 0;
      field389 = 0;
      field340 = false;
      field391 = 0;
      field392 = 0;
      field393 = new class2[2048];
      field551 = -1;
      field549 = 0;
      field396 = 0;
      field431 = new int[1000];
      field398 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field399 = new String[8];
      field400 = new boolean[8];
      field306 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field344 = -1;
      field403 = new class202[4][104][104];
      field369 = new class202();
      field405 = new class202();
      field406 = new class202();
      field407 = new int[25];
      field408 = new int[25];
      field469 = new int[25];
      field528 = 0;
      field517 = false;
      field412 = 0;
      field294 = new int[500];
      field414 = new int[500];
      field415 = new int[500];
      field322 = new int[500];
      field417 = new String[500];
      field328 = new String[500];
      field419 = -1;
      field527 = -1;
      field390 = 0;
      field422 = 50;
      field531 = 0;
      field424 = null;
      field444 = false;
      field426 = -1;
      field427 = -1;
      field428 = null;
      field438 = null;
      field430 = -1;
      field535 = new class199(8);
      field429 = 0;
      field433 = 0;
      field402 = null;
      field435 = 0;
      field436 = 0;
      field409 = 0;
      field463 = -1;
      field439 = false;
      field440 = false;
      field441 = false;
      field292 = null;
      field540 = null;
      field352 = null;
      field445 = 0;
      field446 = 0;
      field447 = null;
      field448 = false;
      field449 = -1;
      field515 = -1;
      field451 = false;
      field452 = -1;
      field453 = -1;
      field454 = false;
      field455 = 1;
      field456 = new int[32];
      field284 = 0;
      field458 = new int[32];
      field457 = 0;
      field541 = new int[32];
      field461 = 0;
      field462 = 0;
      field548 = 0;
      field404 = 0;
      field465 = 0;
      field466 = 0;
      field467 = 0;
      field468 = 0;
      field327 = new class202();
      field470 = new class202();
      field382 = new class202();
      field472 = new class199(512);
      field413 = 0;
      field474 = -2;
      field460 = new boolean[100];
      field476 = new boolean[100];
      field477 = new boolean[100];
      field478 = new int[100];
      field479 = new int[100];
      field359 = new int[100];
      field495 = new int[100];
      field482 = 0;
      field483 = 0L;
      field360 = true;
      field485 = 765;
      field486 = 1;
      field487 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field395 = 0;
      field552 = 0;
      field490 = "";
      field526 = new long[100];
      field492 = 0;
      field493 = 0;
      field319 = new int[128];
      field278 = new int[128];
      field496 = -1L;
      field497 = null;
      field498 = null;
      field410 = -1;
      field500 = 0;
      field501 = new int[1000];
      field502 = new int[1000];
      field503 = new class81[1000];
      field504 = 0;
      field464 = 0;
      field506 = 0;
      field507 = 255;
      field443 = -1;
      field532 = false;
      field510 = 127;
      field511 = 127;
      field274 = 0;
      field513 = new int[50];
      field346 = new int[50];
      field434 = new int[50];
      field288 = new int[50];
      field450 = new class61[50];
      field518 = false;
      field519 = new boolean[5];
      field520 = new int[5];
      field491 = new int[5];
      field522 = new int[5];
      field523 = new int[5];
      field524 = 256;
      field525 = 205;
      field347 = 256;
      field367 = 320;
      field508 = 1;
      field425 = 32767;
      field530 = 1;
      field542 = 32767;
      field514 = 0;
      field316 = 0;
      field534 = 0;
      field364 = 0;
      field536 = 0;
      field537 = 0;
      field538 = 0;
      field273 = new class17[400];
      field401 = new class198();
      field543 = 0;
      field384 = new class7[400];
      field516 = new class182();
      field544 = -1;
      field489 = -1;
      field546 = new class223[8];
      field335 = -1L;
      field269 = -1L;
      field550 = new class10();
      field442 = new int[50];
      field299 = new int[50];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass170;Lclass170;ZII)V",
      garbageValue = "-652036882"
   )
   static void method361(Component var0, class170 var1, class170 var2, boolean var3, int var4) {
      if(class33.field756) {
         if(var4 == 4) {
            class33.field759 = 4;
         }

      } else {
         class33.field759 = var4;
         class82.method1923();
         byte[] var5 = var1.method3334("title.jpg", "");
         class189.field3054 = new class81(var5, var0);
         class141.field2199 = class189.field3054.method1788();
         if((field480 & 536870912) != 0) {
            class30.field698 = class85.method1974(var2, "logo_deadman_mode", "");
         } else {
            class30.field698 = class85.method1974(var2, "logo", "");
         }

         class33.field745 = class85.method1974(var2, "titlebox", "");
         class33.field731 = class85.method1974(var2, "titlebutton", "");
         class75.field1421 = class9.method121(var2, "runes", "");
         class29.field684 = class9.method121(var2, "title_mute", "");
         class33.field732 = class85.method1974(var2, "options_radio_buttons,0", "");
         class30.field696 = class85.method1974(var2, "options_radio_buttons,2", "");
         class33.field755 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class33.field755[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field755[var6 + 64] = 16711680 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field755[128 + var6] = var6 * 4 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field755[192 + var6] = 16777215;
         }

         class33.field736 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field736[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field736[64 + var6] = 4 * var6 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field736[var6 + 128] = '\uffff' + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field736[192 + var6] = 16777215;
         }

         class98.field1694 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class98.field1694[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class98.field1694[var6 + 64] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class98.field1694[var6 + 128] = 16711935 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class98.field1694[192 + var6] = 16777215;
         }

         class132.field2104 = new int[256];
         class33.field739 = new int['耀'];
         class96.field1672 = new int['耀'];
         class137.method2923((class83)null);
         class47.field1064 = new int['耀'];
         class33.field740 = new int['耀'];
         if(var3) {
            class33.field758 = "";
            class33.field735 = "";
         }

         class17.field232 = 0;
         class33.field760 = "";
         class33.field749 = true;
         class33.field728 = false;
         if(!class12.field162.field132) {
            class80.method1781(2, class38.field814, "scape main", "", 255, false);
         } else {
            class186.field3004 = 1;
            class128.field2089 = null;
            class105.field1834 = -1;
            class186.field3009 = -1;
            class40.field903 = 0;
            class133.field2111 = false;
            class186.field3010 = 2;
         }

         class13.method156(false);
         class33.field756 = true;
         class33.field730 = (class12.field174 - field485) / 2;
         class33.field733 = 202 + class33.field730;
         class189.field3054.method1798(class33.field730, 0);
         class141.field2199.method1798(382 + class33.field730, 0);
         class30.field698.method1946(382 + class33.field730 - class30.field698.field1500 / 2, 18);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "326728924"
   )
   void method362() {
      if(field280 != 1000) {
         long var2 = class193.method3805();
         int var4 = (int)(var2 - class221.field3213);
         class221.field3213 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class174.field2761 += var4;
         boolean var1;
         if(class174.field2770 == 0 && class174.field2765 == 0 && class174.field2768 == 0 && class174.field2763 == 0) {
            var1 = true;
         } else if(null == class174.field2766) {
            var1 = false;
         } else {
            try {
               label238: {
                  if(class174.field2761 > 30000) {
                     throw new IOException();
                  }

                  class175 var5;
                  class122 var6;
                  while(class174.field2765 < 20 && class174.field2763 > 0) {
                     var5 = (class175)class174.field2762.method3847();
                     var6 = new class122(4);
                     var6.method2557(1);
                     var6.method2559((int)var5.field3167);
                     class174.field2766.method3045(var6.field2047, 0, 4);
                     class174.field2778.method3849(var5, var5.field3167);
                     --class174.field2763;
                     ++class174.field2765;
                  }

                  while(class174.field2770 < 20 && class174.field2768 > 0) {
                     var5 = (class175)class174.field2764.method3944();
                     var6 = new class122(4);
                     var6.method2557(0);
                     var6.method2559((int)var5.field3167);
                     class174.field2766.method3045(var6.field2047, 0, 4);
                     var5.method3960();
                     class174.field2760.method3849(var5, var5.field3167);
                     --class174.field2768;
                     ++class174.field2770;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class174.field2766.method3044();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class174.field2761 = 0;
                     byte var7 = 0;
                     if(class174.field2771 == null) {
                        var7 = 8;
                     } else if(class174.field2775 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class174.field2772.field2045;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class174.field2766.method3061(class174.field2772.field2047, class174.field2772.field2045, var8);
                        if(class174.field2776 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class174.field2772.field2047[class174.field2772.field2045 + var9] ^= class174.field2776;
                           }
                        }

                        class174.field2772.field2045 += var8;
                        if(class174.field2772.field2045 < var7) {
                           break;
                        }

                        if(null == class174.field2771) {
                           class174.field2772.field2045 = 0;
                           var9 = class174.field2772.method2556();
                           var10 = class174.field2772.method2706();
                           int var11 = class174.field2772.method2556();
                           var12 = class174.field2772.method2577();
                           long var13 = (long)(var10 + (var9 << 16));
                           class175 var15 = (class175)class174.field2778.method3856(var13);
                           class75.field1427 = true;
                           if(var15 == null) {
                              var15 = (class175)class174.field2760.method3856(var13);
                              class75.field1427 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class174.field2771 = var15;
                           class117.field2020 = new class122(class174.field2771.field2781 + var12 + var16);
                           class117.field2020.method2557(var11);
                           class117.field2020.method2560(var12);
                           class174.field2775 = 8;
                           class174.field2772.field2045 = 0;
                        } else if(class174.field2775 == 0) {
                           if(class174.field2772.field2047[0] == -1) {
                              class174.field2775 = 1;
                              class174.field2772.field2045 = 0;
                           } else {
                              class174.field2771 = null;
                           }
                        }
                     } else {
                        var8 = class117.field2020.field2047.length - class174.field2771.field2781;
                        var9 = 512 - class174.field2775;
                        if(var9 > var8 - class117.field2020.field2045) {
                           var9 = var8 - class117.field2020.field2045;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class174.field2766.method3061(class117.field2020.field2047, class117.field2020.field2045, var9);
                        if(class174.field2776 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class117.field2020.field2047[var10 + class117.field2020.field2045] ^= class174.field2776;
                           }
                        }

                        class117.field2020.field2045 += var9;
                        class174.field2775 += var9;
                        if(var8 == class117.field2020.field2045) {
                           if(16711935L == class174.field2771.field3167) {
                              class167.field2716 = class117.field2020;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class171 var19 = class174.field2769[var10];
                                 if(var19 != null) {
                                    class167.field2716.field2045 = 5 + var10 * 8;
                                    var12 = class167.field2716.method2577();
                                    int var23 = class167.field2716.method2577();
                                    var19.method3394(var12, var23);
                                 }
                              }
                           } else {
                              class174.field2774.reset();
                              class174.field2774.update(class117.field2020.field2047, 0, var8);
                              var10 = (int)class174.field2774.getValue();
                              if(class174.field2771.field2782 != var10) {
                                 try {
                                    class174.field2766.method3050();
                                 } catch (Exception var21) {
                                    ;
                                 }

                                 ++class174.field2777;
                                 class174.field2766 = null;
                                 class174.field2776 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label238;
                              }

                              class174.field2777 = 0;
                              class174.field2767 = 0;
                              class174.field2771.field2784.method3387((int)(class174.field2771.field3167 & 65535L), class117.field2020.field2047, (class174.field2771.field3167 & 16711680L) == 16711680L, class75.field1427);
                           }

                           class174.field2771.method3990();
                           if(class75.field1427) {
                              --class174.field2765;
                           } else {
                              --class174.field2770;
                           }

                           class174.field2775 = 0;
                           class174.field2771 = null;
                           class117.field2020 = null;
                        } else {
                           if(class174.field2775 != 512) {
                              break;
                           }

                           class174.field2775 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var22) {
               try {
                  class174.field2766.method3050();
               } catch (Exception var20) {
                  ;
               }

               ++class174.field2767;
               class174.field2766 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method238();
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-257870777"
   )
   protected final void vmethod3078() {
      if(class33.field764.method205()) {
         class33.field764.method202();
      }

      if(null != class62.field1289) {
         class62.field1289.field186 = false;
      }

      class62.field1289 = null;
      if(class38.field829 != null) {
         class38.field829.method3050();
         class38.field829 = null;
      }

      if(null != class140.field2189) {
         class140 var1 = class140.field2189;
         synchronized(class140.field2189) {
            class140.field2189 = null;
         }
      }

      if(null != class143.field2212) {
         class143 var11 = class143.field2212;
         synchronized(class143.field2212) {
            class143.field2212 = null;
         }
      }

      class212.field3171 = null;
      if(class36.field799 != null) {
         class36.field799.method1253();
      }

      if(null != class158.field2354) {
         class158.field2354.method1253();
      }

      class105.method2359();
      Object var12 = class173.field2756;
      synchronized(class173.field2756) {
         if(class173.field2758 != 0) {
            class173.field2758 = 1;

            try {
               class173.field2756.wait();
            } catch (InterruptedException var6) {
               ;
            }
         }
      }

      try {
         class152.field2290.method4226();

         for(int var5 = 0; var5 < class152.field2294; ++var5) {
            class99.field1702[var5].method4226();
         }

         class152.field2289.method4226();
         class152.field2295.method4226();
      } catch (Exception var9) {
         ;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-69"
   )
   protected final void vmethod3137() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "301"
   )
   void method438(int var1) {
      class47.field1067 = null;
      class44.field1021 = null;
      field301 = 0;
      if(class116.field2019 == class42.field991) {
         class42.field991 = class0.field6;
      } else {
         class42.field991 = class116.field2019;
      }

      ++field303;
      if(field303 < 2 || var1 != 7 && var1 != 9) {
         if(field303 >= 2 && var1 == 6) {
            this.method3079("js5connect_outofdate");
            field280 = 1000;
         } else if(field303 >= 4) {
            if(field280 <= 5) {
               this.method3079("js5connect");
               field280 = 1000;
            } else {
               field302 = 3000;
            }
         }
      } else if(field280 <= 5) {
         this.method3079("js5connect_full");
         field280 = 1000;
      } else {
         field302 = 3000;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   @Export("packetHandler")
   protected final void vmethod3076() {
      ++field282;
      this.method362();

      while(true) {
         class202 var2 = class173.field2759;
         class172 var1;
         synchronized(class173.field2759) {
            var1 = (class172)class173.field2757.method3880();
         }

         if(var1 == null) {
            class25.method594();
            class20.method553();
            class140 var54 = class140.field2189;
            int var36;
            synchronized(class140.field2189) {
               ++class140.field2185;
               class140.field2180 = class140.field2184;
               class140.field2181 = 0;
               if(class140.field2177 >= 0) {
                  while(class140.field2177 != class140.field2176) {
                     var36 = class140.field2158[class140.field2176];
                     class140.field2176 = 1 + class140.field2176 & 127;
                     if(var36 < 0) {
                        class140.field2186[~var36] = false;
                     } else {
                        if(!class140.field2186[var36] && class140.field2181 < class140.field2178.length - 1) {
                           class140.field2178[++class140.field2181 - 1] = var36;
                        }

                        class140.field2186[var36] = true;
                     }
                  }
               } else {
                  for(var36 = 0; var36 < 112; ++var36) {
                     class140.field2186[var36] = false;
                  }

                  class140.field2177 = class140.field2176;
               }

               class140.field2184 = class140.field2183;
            }

            class143 var55 = class143.field2212;
            synchronized(class143.field2212) {
               class143.field2216 = class143.field2209;
               class143.field2213 = class143.field2210;
               class143.field2214 = class143.field2211;
               class143.field2224 = class143.field2215;
               class143.field2220 = class143.field2218;
               class143.field2222 = class143.field2217;
               class143.field2208 = class143.field2223;
               class143.field2215 = 0;
            }

            int var37;
            if(class212.field3171 != null) {
               var37 = class212.field3171.vmethod3159();
               field468 = var37;
            }

            if(field280 == 0) {
               class17.method184();
               class43.field1003.vmethod3165();

               for(var37 = 0; var37 < 32; ++var37) {
                  class147.field2260[var37] = 0L;
               }

               for(var37 = 0; var37 < 32; ++var37) {
                  class147.field2261[var37] = 0L;
               }

               class6.field118 = 0;
            } else if(field280 == 5) {
               class52.method1111(this);
               class17.method184();
               class43.field1003.vmethod3165();

               for(var37 = 0; var37 < 32; ++var37) {
                  class147.field2260[var37] = 0L;
               }

               for(var37 = 0; var37 < 32; ++var37) {
                  class147.field2261[var37] = 0L;
               }

               class6.field118 = 0;
            } else if(field280 != 10 && field280 != 11) {
               if(field280 == 20) {
                  class52.method1111(this);
                  class2.method18();
               } else if(field280 == 25) {
                  class92.method2163(false);
                  field325 = 0;
                  boolean var61 = true;

                  for(var36 = 0; var36 < class79.field1466.length; ++var36) {
                     if(class62.field1295[var36] != -1 && class79.field1466[var36] == null) {
                        class79.field1466[var36] = class129.field2097.method3304(class62.field1295[var36], 0);
                        if(null == class79.field1466[var36]) {
                           var61 = false;
                           ++field325;
                        }
                     }

                     if(class146.field2251[var36] != -1 && class25.field632[var36] == null) {
                        class25.field632[var36] = class129.field2097.method3305(class146.field2251[var36], 0, field330[var36]);
                        if(null == class25.field632[var36]) {
                           var61 = false;
                           ++field325;
                        }
                     }
                  }

                  if(!var61) {
                     field416 = 1;
                  } else {
                     field459 = 0;
                     var61 = true;

                     class122 var9;
                     int var10;
                     int var11;
                     int var12;
                     int var14;
                     int var15;
                     int var16;
                     int var17;
                     int var18;
                     int var19;
                     int var38;
                     int var39;
                     for(var36 = 0; var36 < class79.field1466.length; ++var36) {
                        byte[] var3 = class25.field632[var36];
                        if(var3 != null) {
                           var38 = (class124.field2054[var36] >> 8) * 64 - class39.field838;
                           var39 = (class124.field2054[var36] & 255) * 64 - class13.field184;
                           if(field332) {
                              var38 = 10;
                              var39 = 10;
                           }

                           boolean var8 = true;
                           var9 = new class122(var3);
                           var10 = -1;

                           label797:
                           while(true) {
                              var11 = var9.method2585();
                              if(var11 == 0) {
                                 var61 &= var8;
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;
                              boolean var13 = false;

                              while(true) {
                                 while(!var13) {
                                    var14 = var9.method2585();
                                    if(var14 == 0) {
                                       continue label797;
                                    }

                                    var12 += var14 - 1;
                                    var15 = var12 & 63;
                                    var16 = var12 >> 6 & 63;
                                    var17 = var9.method2556() >> 2;
                                    var18 = var16 + var38;
                                    var19 = var15 + var39;
                                    if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                       class42 var20 = class7.method100(var10);
                                       if(var17 != 22 || !field277 || var20.field974 != 0 || var20.field959 == 1 || var20.field971) {
                                          if(!var20.method834()) {
                                             ++field459;
                                             var8 = false;
                                          }

                                          var13 = true;
                                       }
                                    }
                                 }

                                 var14 = var9.method2585();
                                 if(var14 == 0) {
                                    break;
                                 }

                                 var9.method2556();
                              }
                           }
                        }
                     }

                     if(!var61) {
                        field416 = 2;
                     } else {
                        if(field416 != 0) {
                           class15.method175("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class20.method553();
                        class97.method2249();
                        class20.method553();
                        class5.field91.method1999();
                        class20.method553();
                        System.gc();

                        for(var36 = 0; var36 < 4; ++var36) {
                           field331[var36].method2479();
                        }

                        int var40;
                        for(var36 = 0; var36 < 4; ++var36) {
                           for(var40 = 0; var40 < 104; ++var40) {
                              for(var38 = 0; var38 < 104; ++var38) {
                                 class5.field78[var36][var40][var38] = 0;
                              }
                           }
                        }

                        class20.method553();
                        class5.field87 = 99;
                        class5.field80 = new byte[4][104][104];
                        class5.field81 = new byte[4][104][104];
                        class158.field2353 = new byte[4][104][104];
                        class138.field2141 = new byte[4][104][104];
                        class33.field762 = new int[4][105][105];
                        class78.field1455 = new byte[4][105][105];
                        class161.field2650 = new int[105][105];
                        class189.field3053 = new int[104];
                        class19.field260 = new int[104];
                        class124.field2052 = new int[104];
                        class4.field67 = new int[104];
                        class182.field2964 = new int[104];
                        var36 = class79.field1466.length;
                        class26.method611();
                        class92.method2163(true);
                        int var6;
                        int var21;
                        int var22;
                        int var44;
                        int var59;
                        if(!field332) {
                           byte[] var41;
                           for(var40 = 0; var40 < var36; ++var40) {
                              var38 = 64 * (class124.field2054[var40] >> 8) - class39.field838;
                              var39 = 64 * (class124.field2054[var40] & 255) - class13.field184;
                              var41 = class79.field1466[var40];
                              if(null != var41) {
                                 class20.method553();
                                 class25.method596(var41, var38, var39, class9.field149 * 8 - 48, class36.field803 * 8 - 48, field331);
                              }
                           }

                           for(var40 = 0; var40 < var36; ++var40) {
                              var38 = (class124.field2054[var40] >> 8) * 64 - class39.field838;
                              var39 = (class124.field2054[var40] & 255) * 64 - class13.field184;
                              var41 = class79.field1466[var40];
                              if(null == var41 && class36.field803 < 800) {
                                 class20.method553();
                                 class12.method147(var38, var39, 64, 64);
                              }
                           }

                           class92.method2163(true);

                           for(var40 = 0; var40 < var36; ++var40) {
                              byte[] var4 = class25.field632[var40];
                              if(null != var4) {
                                 var39 = (class124.field2054[var40] >> 8) * 64 - class39.field838;
                                 var6 = (class124.field2054[var40] & 255) * 64 - class13.field184;
                                 class20.method553();
                                 class89 var42 = class5.field91;
                                 class111[] var43 = field331;
                                 var9 = new class122(var4);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var9.method2585();
                                    if(var11 == 0) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var59 = var9.method2585();
                                       if(var59 == 0) {
                                          break;
                                       }

                                       var12 += var59 - 1;
                                       var14 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       var17 = var9.method2556();
                                       var18 = var17 >> 2;
                                       var19 = var17 & 3;
                                       var44 = var39 + var15;
                                       var21 = var14 + var6;
                                       if(var44 > 0 && var21 > 0 && var44 < 103 && var21 < 103) {
                                          var22 = var16;
                                          if((class5.field78[1][var44][var21] & 2) == 2) {
                                             var22 = var16 - 1;
                                          }

                                          class111 var23 = null;
                                          if(var22 >= 0) {
                                             var23 = var43[var22];
                                          }

                                          class138.method2931(var16, var44, var21, var10, var19, var18, var42, var23);
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        int var7;
                        int var45;
                        int var58;
                        if(field332) {
                           var40 = 0;

                           label702:
                           while(true) {
                              class111[] var47;
                              int var48;
                              class122 var60;
                              if(var40 >= 4) {
                                 for(var40 = 0; var40 < 13; ++var40) {
                                    for(var38 = 0; var38 < 13; ++var38) {
                                       var39 = field333[0][var40][var38];
                                       if(var39 == -1) {
                                          class12.method147(8 * var40, 8 * var38, 8, 8);
                                       }
                                    }
                                 }

                                 class92.method2163(true);
                                 var40 = 0;

                                 while(true) {
                                    if(var40 >= 4) {
                                       break label702;
                                    }

                                    class20.method553();

                                    for(var38 = 0; var38 < 13; ++var38) {
                                       label591:
                                       for(var39 = 0; var39 < 13; ++var39) {
                                          var6 = field333[var40][var38][var39];
                                          if(var6 != -1) {
                                             var7 = var6 >> 24 & 3;
                                             var58 = var6 >> 1 & 3;
                                             var45 = var6 >> 14 & 1023;
                                             var10 = var6 >> 3 & 2047;
                                             var11 = var10 / 8 + (var45 / 8 << 8);

                                             for(var12 = 0; var12 < class124.field2054.length; ++var12) {
                                                if(class124.field2054[var12] == var11 && class25.field632[var12] != null) {
                                                   byte[] var49 = class25.field632[var12];
                                                   var14 = var38 * 8;
                                                   var15 = var39 * 8;
                                                   var16 = 8 * (var45 & 7);
                                                   var17 = 8 * (var10 & 7);
                                                   class89 var50 = class5.field91;
                                                   var47 = field331;
                                                   var60 = new class122(var49);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var60.method2585();
                                                      if(var22 == 0) {
                                                         continue label591;
                                                      }

                                                      var21 += var22;
                                                      var48 = 0;

                                                      while(true) {
                                                         int var24 = var60.method2585();
                                                         if(var24 == 0) {
                                                            break;
                                                         }

                                                         var48 += var24 - 1;
                                                         int var25 = var48 & 63;
                                                         int var26 = var48 >> 6 & 63;
                                                         int var27 = var48 >> 12;
                                                         int var28 = var60.method2556();
                                                         int var29 = var28 >> 2;
                                                         int var30 = var28 & 3;
                                                         if(var7 == var27 && var26 >= var16 && var26 < 8 + var16 && var25 >= var17 && var25 < var17 + 8) {
                                                            class42 var31 = class7.method100(var21);
                                                            int var32 = var14 + class116.method2506(var26 & 7, var25 & 7, var58, var31.field976, var31.field980, var30);
                                                            int var33 = var15 + class168.method3292(var26 & 7, var25 & 7, var58, var31.field976, var31.field980, var30);
                                                            if(var32 > 0 && var33 > 0 && var32 < 103 && var33 < 103) {
                                                               int var34 = var40;
                                                               if((class5.field78[1][var32][var33] & 2) == 2) {
                                                                  var34 = var40 - 1;
                                                               }

                                                               class111 var35 = null;
                                                               if(var34 >= 0) {
                                                                  var35 = var47[var34];
                                                               }

                                                               class138.method2931(var40, var32, var33, var21, var30 + var58 & 3, var29, var50, var35);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var40;
                                 }
                              }

                              class20.method553();

                              for(var38 = 0; var38 < 13; ++var38) {
                                 for(var39 = 0; var39 < 13; ++var39) {
                                    boolean var57 = false;
                                    var7 = field333[var40][var38][var39];
                                    if(var7 != -1) {
                                       var58 = var7 >> 24 & 3;
                                       var45 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var59 = 0; var59 < class124.field2054.length; ++var59) {
                                          if(class124.field2054[var59] == var12 && class79.field1466[var59] != null) {
                                             byte[] var46 = class79.field1466[var59];
                                             var15 = 8 * var38;
                                             var16 = 8 * var39;
                                             var17 = 8 * (var10 & 7);
                                             var18 = 8 * (var11 & 7);
                                             var47 = field331;

                                             for(var44 = 0; var44 < 8; ++var44) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var15 + var44 > 0 && var44 + var15 < 103 && var21 + var16 > 0 && var16 + var21 < 103) {
                                                      var47[var40].field1954[var44 + var15][var16 + var21] &= -16777217;
                                                   }
                                                }
                                             }

                                             var60 = new class122(var46);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(var48 = 0; var48 < 64; ++var48) {
                                                      if(var21 == var58 && var22 >= var17 && var22 < 8 + var17 && var48 >= var18 && var48 < var18 + 8) {
                                                         class181.method3534(var60, var40, var15 + class31.method668(var22 & 7, var48 & 7, var45), var16 + class160.method3215(var22 & 7, var48 & 7, var45), 0, 0, var45);
                                                      } else {
                                                         class181.method3534(var60, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var57 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var57) {
                                       var58 = var40;
                                       var45 = 8 * var38;
                                       var10 = 8 * var39;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class5.field77[var58][var45 + var11][var10 + var12] = 0;
                                          }
                                       }

                                       if(var45 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.field77[var58][var45][var11 + var10] = class5.field77[var58][var45 - 1][var10 + var11];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.field77[var58][var11 + var45][var10] = class5.field77[var58][var11 + var45][var10 - 1];
                                          }
                                       }

                                       if(var45 > 0 && class5.field77[var58][var45 - 1][var10] != 0) {
                                          class5.field77[var58][var45][var10] = class5.field77[var58][var45 - 1][var10];
                                       } else if(var10 > 0 && class5.field77[var58][var45][var10 - 1] != 0) {
                                          class5.field77[var58][var45][var10] = class5.field77[var58][var45][var10 - 1];
                                       } else if(var45 > 0 && var10 > 0 && class5.field77[var58][var45 - 1][var10 - 1] != 0) {
                                          class5.field77[var58][var45][var10] = class5.field77[var58][var45 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var40;
                           }
                        }

                        class92.method2163(true);
                        class97.method2249();
                        class20.method553();
                        class6.method95(class5.field91, field331);
                        class92.method2163(true);
                        var40 = class5.field87;
                        if(var40 > class51.field1119) {
                           var40 = class51.field1119;
                        }

                        if(var40 < class51.field1119 - 1) {
                           var40 = class51.field1119 - 1;
                        }

                        if(field277) {
                           class5.field91.method2000(class5.field87);
                        } else {
                           class5.field91.method2000(0);
                        }

                        for(var38 = 0; var38 < 104; ++var38) {
                           for(var39 = 0; var39 < 104; ++var39) {
                              class142.method3001(var38, var39);
                           }
                        }

                        class20.method553();

                        for(class16 var56 = (class16)field369.method3882(); null != var56; var56 = (class16)field369.method3891()) {
                           if(var56.field221 == -1) {
                              var56.field217 = 0;
                              class44.method922(var56);
                           } else {
                              var56.method3990();
                           }
                        }

                        class42.field945.method3814();
                        if(null != class39.field835) {
                           field313.method2797(76);
                           field313.method2560(1057001181);
                        }

                        if(!field332) {
                           var38 = (class9.field149 - 6) / 8;
                           var39 = (6 + class9.field149) / 8;
                           var6 = (class36.field803 - 6) / 8;
                           var7 = (class36.field803 + 6) / 8;

                           for(var58 = var38 - 1; var58 <= 1 + var39; ++var58) {
                              for(var45 = var6 - 1; var45 <= 1 + var7; ++var45) {
                                 if(var58 < var38 || var58 > var39 || var45 < var6 || var45 > var7) {
                                    class129.field2097.method3324("m" + var58 + "_" + var45);
                                    class129.field2097.method3324("l" + var58 + "_" + var45);
                                 }
                              }
                           }
                        }

                        class171.method3414(30);
                        class20.method553();
                        class5.field80 = null;
                        class5.field81 = null;
                        class158.field2353 = null;
                        class138.field2141 = null;
                        class33.field762 = null;
                        class78.field1455 = null;
                        class161.field2650 = null;
                        class189.field3053 = null;
                        class19.field260 = null;
                        class124.field2052 = null;
                        class4.field67 = null;
                        class182.field2964 = null;
                        field313.method2797(120);
                        class43.field1003.vmethod3165();

                        for(var38 = 0; var38 < 32; ++var38) {
                           class147.field2260[var38] = 0L;
                        }

                        for(var38 = 0; var38 < 32; ++var38) {
                           class147.field2261[var38] = 0L;
                        }

                        class6.field118 = 0;
                     }
                  }
               }
            } else {
               class52.method1111(this);
            }

            if(field280 == 30) {
               class7.method99();
            } else if(field280 == 40 || field280 == 45) {
               class2.method18();
            }

            return;
         }

         var1.field2752.method3396(var1.field2754, (int)var1.field3167, var1.field2755, false);
      }
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "([Lclass176;Lclass176;ZB)V",
      garbageValue = "1"
   )
   static void method551(class176[] var0, class176 var1, boolean var2) {
      int var3 = var1.field2818 != 0?var1.field2818:var1.field2926;
      int var4 = var1.field2819 != 0?var1.field2819:var1.field2877;
      class6.method93(var0, var1.field2795, var3, var4, var2);
      if(var1.field2919 != null) {
         class6.method93(var1.field2919, var1.field2795, var3, var4, var2);
      }

      class3 var5 = (class3)field535.method3856((long)var1.field2795);
      if(null != var5) {
         int var6 = var5.field66;
         if(class122.method2739(var6)) {
            class6.method93(class176.field2814[var6], -1, var3, var4, var2);
         }
      }

      if(var1.field2799 == 1337) {
         ;
      }

   }
}
