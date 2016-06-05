import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
public final class client extends class144 {
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -1780989547
   )
   static int field279;
   @ObfuscatedName("i")
   static client field280;
   @ObfuscatedName("os")
   static int[] field281;
   @ObfuscatedName("mc")
   static String field282;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -365358679
   )
   @Export("flags")
   static int field283 = 0;
   @ObfuscatedName("r")
   static class153 field284;
   @ObfuscatedName("ci")
   static int[] field285;
   @ObfuscatedName("l")
   @Export("isMembers")
   static boolean field286 = false;
   @ObfuscatedName("p")
   static boolean field287 = false;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -470759267
   )
   static int field288 = 0;
   @ObfuscatedName("b")
   static String field289;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 473326675
   )
   static int field290;
   @ObfuscatedName("ga")
   static class173 field291;
   @ObfuscatedName("c")
   static boolean field292 = true;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1843656437
   )
   static int field293;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -27661733
   )
   @Export("menuOptionCount")
   static int field294;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 106881905
   )
   static int field295 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 531267151
   )
   static int field296 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -690620301
   )
   static int field297 = -1;
   @ObfuscatedName("as")
   static boolean field298 = true;
   @ObfuscatedName("lp")
   static String field299;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -185144799
   )
   static int field300 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 641109005
   )
   static int field301 = 0;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1291288389
   )
   @Export("mapAngle")
   static int field302;
   @ObfuscatedName("hm")
   @Export("boostedSkillLevels")
   static int[] field303;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 796123429
   )
   static int field304 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -571304389
   )
   static int field305 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 323501019
   )
   static int field306 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 215107255
   )
   static int field307 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 1530821725616589519L
   )
   static long field308 = -1L;
   @ObfuscatedName("ao")
   static class20 field309;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = 1031701843
   )
   static int field310;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1351958307
   )
   static int field311;
   @ObfuscatedName("aa")
   static class146 field312;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -829652203
   )
   static int field313;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1722847533
   )
   static int field314;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 348598841
   )
   static int field315;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1618229173
   )
   static int field316;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -970417141
   )
   static int field317;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1800881677
   )
   static int field318;
   @ObfuscatedName("np")
   static int[] field319;
   @ObfuscatedName("cv")
   @Export("cachedNPCs")
   static class34[] field320;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1455880101
   )
   static int field321;
   @ObfuscatedName("cf")
   static int[] field322;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -156724689
   )
   static int field323;
   @ObfuscatedName("pc")
   static final class10 field324;
   @ObfuscatedName("cc")
   static class122 field325;
   @ObfuscatedName("cm")
   static class122 field326;
   @ObfuscatedName("cy")
   static class122 field327;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1872963271
   )
   static int field328;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1550084629
   )
   @Export("packetOpcode")
   static int field329;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = -799640159
   )
   static int field330;
   @ObfuscatedName("no")
   static class56 field331;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2087513409
   )
   @Export("gameCycle")
   static int field332 = 0;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 12611361
   )
   static int field333;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1153608755
   )
   static int field334;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 940035901
   )
   static int field335;
   @ObfuscatedName("ce")
   static boolean field336;
   @ObfuscatedName("if")
   @Export("menuTargets")
   static String[] field337;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -475639683
   )
   static int field338;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -1214771511
   )
   static int field339;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -1141242125
   )
   static int field340;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -1654805475
   )
   static int field341;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -1523065157
   )
   static int field342;
   @ObfuscatedName("dp")
   static int[] field343;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class108[] field344;
   @ObfuscatedName("dj")
   static boolean field345;
   @ObfuscatedName("dv")
   static int[][][] field346;
   @ObfuscatedName("dx")
   static final int[] field347;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -1353706689
   )
   static int field348;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 882800515
   )
   static int field349;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 1767176747
   )
   static int field350;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -1445770263
   )
   static int field351;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -13801719
   )
   static int field352;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -1380053801
   )
   static int field353;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = -1919112169
   )
   static int field354;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 888264905
   )
   @Export("mapScale")
   static int field355;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 58964603
   )
   static int field356;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -888683135
   )
   @Export("mapScaleDelta")
   static int field357;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -317090627
   )
   @Export("baseY")
   static int field358;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -1248576131
   )
   static int field359;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -684920703
   )
   static int field360;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 158711937
   )
   static int field361;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 119671907
   )
   static int field362;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1626344317
   )
   static int field363;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1574689723
   )
   static int field364;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 1720363351
   )
   static int field365;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -67602453
   )
   static int field366;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 1280658017
   )
   static int field367;
   @ObfuscatedName("fy")
   static int[] field368;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1383973579
   )
   static int field369;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1520293143
   )
   static int field370;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -912685913
   )
   static int field371;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1616263859
   )
   static int field372;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 2102134257
   )
   static int field373;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 127369407
   )
   static int field374;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 1573446999
   )
   static int field375;
   @ObfuscatedName("ag")
   static boolean field376 = false;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 927339469
   )
   static int field377;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1809770179
   )
   static int field378;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 852864277
   )
   static int field379;
   @ObfuscatedName("fk")
   static int[] field380;
   @ObfuscatedName("fc")
   static int[] field381;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -772563109
   )
   static int field382;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = -2009445591
   )
   static int field383;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1796217735
   )
   static int field384 = 0;
   @ObfuscatedName("gl")
   static int[] field385;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -65257885
   )
   static int field386;
   @ObfuscatedName("gj")
   static int[][] field387;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -586899427
   )
   static int field388;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -1915120949
   )
   static int field389;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1290132017
   )
   static int field390;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 16249023
   )
   static int field391;
   @ObfuscatedName("iw")
   @Export("menuTypes")
   static int[] field392;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -1975463141
   )
   static int field393;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -485146089
   )
   static int field394;
   @ObfuscatedName("ka")
   static class199 field395;
   @ObfuscatedName("ld")
   static boolean[] field396;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -220082429
   )
   static int field397;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -160939107
   )
   static int field398;
   @ObfuscatedName("jg")
   static class173 field399;
   @ObfuscatedName("ok")
   @Export("ignores")
   static class7[] field400;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -83894261
   )
   static int field401;
   @ObfuscatedName("ge")
   static boolean field402;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -1343094381
   )
   static int field403;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -2053577081
   )
   static int field404;
   @ObfuscatedName("gu")
   @Export("cachedPlayers")
   static class2[] field405;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1214603937
   )
   static int field406 = 0;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 7613277
   )
   static int field407;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -2091782353
   )
   static int field408;
   @ObfuscatedName("hn")
   static int[] field409;
   @ObfuscatedName("ht")
   static final int[] field410;
   @ObfuscatedName("mz")
   static int[] field411;
   @ObfuscatedName("hr")
   static boolean[] field412;
   @ObfuscatedName("g")
   static boolean field413 = true;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 1706561931
   )
   @Export("camera2")
   static int field414;
   @ObfuscatedName("hq")
   @Export("groundItemDeque")
   static class199[][][] field415;
   @ObfuscatedName("jv")
   static boolean field416;
   @ObfuscatedName("hu")
   @Export("projectiles")
   static class199 field417;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = -476389841
   )
   @Export("friendCount")
   static int field418;
   @ObfuscatedName("oe")
   static short field419;
   @ObfuscatedName("hs")
   @Export("realSkillLevels")
   static int[] field420;
   @ObfuscatedName("hv")
   @Export("skillExperiences")
   static int[] field421;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -183513051
   )
   static int field422;
   @ObfuscatedName("hy")
   @Export("isMenuOpen")
   static boolean field423;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1349553549
   )
   static int field424;
   @ObfuscatedName("hk")
   @Export("menuActionParams0")
   static int[] field425;
   @ObfuscatedName("il")
   @Export("menuActionParams1")
   static int[] field426;
   @ObfuscatedName("jw")
   static boolean field427;
   @ObfuscatedName("kb")
   @Export("widgetFlags")
   static class196 field428;
   @ObfuscatedName("ij")
   @Export("menuOptions")
   static String[] field429;
   @ObfuscatedName("fs")
   static int[] field430;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 209348981
   )
   static int field431;
   @ObfuscatedName("ie")
   static String field432;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 2008559975
   )
   static int field433;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 323335595
   )
   static int field434;
   @ObfuscatedName("px")
   static int[] field435;
   @ObfuscatedName("lb")
   @Export("widgetPositionY")
   static int[] field436;
   @ObfuscatedName("in")
   static boolean field437;
   @ObfuscatedName("hp")
   static int[] field438;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 862070635
   )
   static int field439;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -499540873
   )
   static int field440;
   @ObfuscatedName("iv")
   static String field441;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -373828141
   )
   @Export("widgetRoot")
   static int field442;
   @ObfuscatedName("ik")
   @Export("componentTable")
   static class196 field443;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 833311353
   )
   static int field444;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 674941011
   )
   static int field445;
   @ObfuscatedName("ho")
   static class199 field446;
   @ObfuscatedName("gd")
   static String[] field447;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -512809511
   )
   @Export("weight")
   static int field448;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 2121651635
   )
   static int field449;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 1655534275
   )
   static int field450;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -714639043
   )
   static int field451;
   @ObfuscatedName("jp")
   static boolean field452;
   @ObfuscatedName("ji")
   static boolean field453;
   @ObfuscatedName("jk")
   static class173 field454;
   @ObfuscatedName("je")
   static class173 field455;
   @ObfuscatedName("jf")
   static class173 field456;
   @ObfuscatedName("ec")
   static boolean field457;
   @ObfuscatedName("aj")
   static class20 field458;
   @ObfuscatedName("jd")
   static class173 field459;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -2011230305
   )
   @Export("localInteractingIndex")
   static int field460;
   @ObfuscatedName("hw")
   static String[] field461;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -202743379
   )
   @Export("gameState")
   static int field462 = 0;
   @ObfuscatedName("it")
   static String field463;
   @ObfuscatedName("mv")
   static class78[] field464;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -563968809
   )
   static int field465;
   @ObfuscatedName("op")
   static int[] field466;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1086148947
   )
   static int field467;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 928928137
   )
   static int field468;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -699506609
   )
   static int field469;
   @ObfuscatedName("km")
   static int[] field470;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -673652737
   )
   static int field471;
   @ObfuscatedName("ks")
   static int[] field472;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 1663611445
   )
   static int field473;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -880083601
   )
   static int field474;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 1693526991
   )
   static int field475;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      longValue = -6377695844977944711L
   )
   static long field476;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 933474375
   )
   static int field477;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1456836257
   )
   @Export("world")
   static int field478 = 1;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -669678219
   )
   static int field479;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -783617427
   )
   static int field480;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1936122785
   )
   static int field481;
   @ObfuscatedName("kq")
   static class199 field482;
   @ObfuscatedName("kx")
   static class199 field483;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1663592569
   )
   static int field484;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -1181984659
   )
   static int field485;
   @ObfuscatedName("on")
   static boolean[] field486;
   @ObfuscatedName("lg")
   static long[] field487;
   @ObfuscatedName("lr")
   static boolean[] field488;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 1551166179
   )
   static int field489;
   @ObfuscatedName("lm")
   @Export("widgetPositionX")
   static int[] field490;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 1523510931
   )
   static int field491;
   @ObfuscatedName("mm")
   static int[] field492;
   @ObfuscatedName("lu")
   @Export("widgetBoundsHeight")
   static int[] field493;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -1770219779
   )
   static int field494;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      longValue = 1880820936967599723L
   )
   static long field495;
   @ObfuscatedName("ls")
   @Export("isResized")
   static boolean field496;
   @ObfuscatedName("fb")
   static boolean field497;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1957546045
   )
   static int field498;
   @ObfuscatedName("lw")
   static int[] field499;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -731714325
   )
   static int field500;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 1286036897
   )
   static int field501;
   @ObfuscatedName("ir")
   @Export("menuIdentifiers")
   static int[] field502;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -107986673
   )
   static int field503;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 983169577
   )
   static int field504;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = 2081470537
   )
   static int field505;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1991529709
   )
   static int field506 = 0;
   @ObfuscatedName("mf")
   static int[] field507;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      longValue = 7615584822738676441L
   )
   static long field508;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 1419872225
   )
   static int field509;
   @ObfuscatedName("mw")
   static String field510;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 2117438721
   )
   static int field511;
   @ObfuscatedName("kh")
   static int[] field512;
   @ObfuscatedName("jq")
   static boolean field513;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 807571175
   )
   static int field514;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -853591443
   )
   static int field516;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 710646029
   )
   @Export("flagY")
   static int field517;
   @ObfuscatedName("oq")
   static short field518;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = -665768565
   )
   static int field519;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 1869511651
   )
   static int field520;
   @ObfuscatedName("mn")
   static boolean field521;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -1649295119
   )
   static int field522;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -2098818907
   )
   static int field523 = 0;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -799887771
   )
   static int field524;
   @ObfuscatedName("nc")
   static int[] field525;
   @ObfuscatedName("ow")
   static short field526;
   @ObfuscatedName("nx")
   static int[] field527;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -309781061
   )
   static int field528;
   @ObfuscatedName("ni")
   static class58[] field529;
   @ObfuscatedName("nu")
   static boolean field530;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -2080163749
   )
   @Export("energy")
   static int field531;
   @ObfuscatedName("nv")
   static int[] field532;
   @ObfuscatedName("ol")
   static int[] field533;
   @ObfuscatedName("oi")
   static int[] field534;
   @ObfuscatedName("lf")
   @Export("widgetBoundsWidth")
   static int[] field535;
   @ObfuscatedName("ou")
   static short field536;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -16993171
   )
   static int field537;
   @ObfuscatedName("ox")
   static short field538;
   @ObfuscatedName("jh")
   static boolean field539;
   @ObfuscatedName("or")
   static short field540;
   @ObfuscatedName("oj")
   static short field541;
   @ObfuscatedName("hi")
   static class199 field542;
   @ObfuscatedName("om")
   static short field543;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 2055675749
   )
   static int field544;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 148566581
   )
   @Export("flagX")
   static int field545;
   @ObfuscatedName("ly")
   static boolean[] field546;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 1145920753
   )
   @Export("camera3")
   static int field547;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 2060101893
   )
   @Export("scale")
   static int field548;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 1209575659
   )
   static int field549;
   @ObfuscatedName("fd")
   static int[] field550;
   @ObfuscatedName("ob")
   @Export("friends")
   static class17[] field551;
   @ObfuscatedName("of")
   static class195 field552;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 1297670833
   )
   @Export("ignoreCount")
   static int field553;
   @ObfuscatedName("fz")
   static int[] field554;
   @ObfuscatedName("pb")
   static class179 field555;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = 1378841977
   )
   static int field556;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = -1563289093
   )
   static int field557;
   @ObfuscatedName("pq")
   @Export("grandExchangeOffers")
   static class220[] field558;
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      longValue = -6181708966222864323L
   )
   static long field559;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -1580698317
   )
   static int field560;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = -2197659621840988917L
   )
   static long field561;
   @ObfuscatedName("mb")
   static int[] field562;
   @ObfuscatedName("pa")
   static int[] field563;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1248760045
   )
   static int field564;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 964287945
   )
   static int field565;
   @ObfuscatedName("iq")
   static class30 field566;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1817936179"
   )
   protected final void vmethod2984() {
   }

   public final void init() {
      if(this.method2981()) {
         class190[] var1 = new class190[]{class190.field3071, class190.field3078, class190.field3069, class190.field3065, class190.field3072, class190.field3075, class190.field3070, class190.field3073, class190.field3068, class190.field3077, class190.field3079, class190.field3080, class190.field3076, class190.field3066, class190.field3074};
         class190[] var2 = var1;

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            class190 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3067);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3067)) {
               case 1:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 2:
                  class7.field131 = Integer.parseInt(var5);
                  break;
               case 3:
                  field478 = Integer.parseInt(var5);
                  break;
               case 4:
                  field288 = Integer.parseInt(var5);
                  break;
               case 5:
                  field283 = Integer.parseInt(var5);
               case 6:
               case 9:
               case 11:
               default:
                  break;
               case 7:
                  field289 = var5;
                  break;
               case 8:
                  int var7 = Integer.parseInt(var5);
                  class153[] var8 = class99.method2159();
                  int var9 = 0;

                  class153 var26;
                  while(true) {
                     if(var9 >= var8.length) {
                        var26 = null;
                        break;
                     }

                     class153 var10 = var8[var9];
                     if(var10.field2303 == var7) {
                        var26 = var10;
                        break;
                     }

                     ++var9;
                  }

                  field284 = var26;
                  break;
               case 10:
                  field290 = Integer.parseInt(var5);
                  break;
               case 12:
                  class154[] var6 = new class154[]{class154.field2319, class154.field2313, class154.field2311, class154.field2310, class154.field2314, class154.field2312};
                  class214.field3158 = (class154)class30.method651(var6, Integer.parseInt(var5));
                  if(class214.field3158 == class154.field2310) {
                     class96.field1641 = class212.field3153;
                  } else {
                     class96.field1641 = class212.field3151;
                  }
                  break;
               case 13:
                  if(var5.equalsIgnoreCase("true")) {
                     field286 = true;
                  } else {
                     field286 = false;
                  }
                  break;
               case 14:
                  field384 = Integer.parseInt(var5);
                  break;
               case 15:
                  class172.field2766 = var5;
               }
            }
         }

         class86.field1530 = false;
         field287 = false;
         class161.field2670 = this.getCodeBase().getHost();
         String var22 = field284.field2307;
         byte var11 = 0;

         try {
            class149.field2265 = 16;
            class111.field1957 = var11;

            try {
               class124.field2040 = System.getProperty("os.name");
            } catch (Exception var19) {
               class124.field2040 = "Unknown";
            }

            class102.field1776 = class124.field2040.toLowerCase();

            try {
               class149.field2272 = System.getProperty("user.home");
               if(null != class149.field2272) {
                  class149.field2272 = class149.field2272 + "/";
               }
            } catch (Exception var18) {
               ;
            }

            try {
               if(class102.field1776.startsWith("win")) {
                  if(class149.field2272 == null) {
                     class149.field2272 = System.getenv("USERPROFILE");
                  }
               } else if(class149.field2272 == null) {
                  class149.field2272 = System.getenv("HOME");
               }

               if(class149.field2272 != null) {
                  class149.field2272 = class149.field2272 + "/";
               }
            } catch (Exception var17) {
               ;
            }

            if(class149.field2272 == null) {
               class149.field2272 = "~/";
            }

            class149.field2271 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class149.field2272, "/tmp/", ""};
            class8.field143 = new String[]{".jagex_cache_" + class111.field1957, ".file_store_" + class111.field1957};

            label154:
            for(var3 = 0; var3 < 4; ++var3) {
               class149.field2270 = class104.method2251("oldschool", var22, var3);
               if(!class149.field2270.exists()) {
                  class149.field2270.mkdirs();
               }

               File[] var23 = class149.field2270.listFiles();
               if(null == var23) {
                  break;
               }

               File[] var25 = var23;
               int var13 = 0;

               while(true) {
                  if(var13 >= var25.length) {
                     break label154;
                  }

                  File var14 = var25[var13];
                  if(!class131.method2810(var14, false)) {
                     break;
                  }

                  ++var13;
               }
            }

            class42.method878(class149.field2270);

            try {
               File var12 = new File(class149.field2272, "random.dat");
               int var16;
               if(var12.exists()) {
                  class149.field2269 = new class228(new class227(var12, "rw", 25L), 24, 0);
               } else {
                  label134:
                  for(int var15 = 0; var15 < class8.field143.length; ++var15) {
                     for(var16 = 0; var16 < class149.field2271.length; ++var16) {
                        File var27 = new File(class149.field2271[var16] + class8.field143[var15] + File.separatorChar + "random.dat");
                        if(var27.exists()) {
                           class149.field2269 = new class228(new class227(var27, "rw", 25L), 24, 0);
                           break label134;
                        }
                     }
                  }
               }

               if(null == class149.field2269) {
                  RandomAccessFile var24 = new RandomAccessFile(var12, "rw");
                  var16 = var24.read();
                  var24.seek(0L);
                  var24.write(var16);
                  var24.seek(0L);
                  var24.close();
                  class149.field2269 = new class228(new class227(var12, "rw", 25L), 24, 0);
               }
            } catch (IOException var20) {
               ;
            }

            class149.field2264 = new class228(new class227(class39.method775("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class149.field2268 = new class228(new class227(class39.method775("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class134.field2093 = new class228[class149.field2265];

            for(var3 = 0; var3 < class149.field2265; ++var3) {
               class134.field2093[var3] = new class228(new class227(class39.method775("main_file_cache.idx" + var3), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var21) {
            class30.method654((String)null, var21);
         }

         field280 = this;
         this.method2991(765, 503, 115);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-65"
   )
   @Export("packetHandler")
   protected final void vmethod2994() {
      ++field332;
      this.method222();
      class107.method2346();

      int var1;
      try {
         if(class183.field2981 == 1) {
            var1 = class183.field2976.method3548();
            if(var1 > 0 && class183.field2976.method3554()) {
               var1 -= class183.field2980;
               if(var1 < 0) {
                  var1 = 0;
               }

               class183.field2976.method3613(var1);
            } else {
               class183.field2976.method3574();
               class183.field2976.method3647();
               if(null != class24.field614) {
                  class183.field2981 = 2;
               } else {
                  class183.field2981 = 0;
               }

               class183.field2974 = null;
               class22.field590 = null;
            }
         }
      } catch (Exception var6) {
         var6.printStackTrace();
         class183.field2976.method3574();
         class183.field2981 = 0;
         class183.field2974 = null;
         class22.field590 = null;
         class24.field614 = null;
      }

      class135.method2845();
      class137 var4 = class137.field2137;
      synchronized(class137.field2137) {
         ++class137.field2153;
         class137.field2150 = class137.field2139;
         class137.field2149 = 0;
         int var2;
         if(class137.field2145 >= 0) {
            while(class137.field2145 != class137.field2148) {
               var2 = class137.field2143[class137.field2148];
               class137.field2148 = 1 + class137.field2148 & 127;
               if(var2 < 0) {
                  class137.field2133[~var2] = false;
               } else {
                  if(!class137.field2133[var2] && class137.field2149 < class137.field2146.length - 1) {
                     class137.field2146[++class137.field2149 - 1] = var2;
                  }

                  class137.field2133[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               class137.field2133[var2] = false;
            }

            class137.field2145 = class137.field2148;
         }

         class137.field2139 = class137.field2144;
      }

      class21.method558();
      if(null != class46.field1068) {
         var1 = class46.field1068.vmethod3074();
         field480 = var1;
      }

      if(field462 == 0) {
         class113.method2401();
         class216.method3903();
      } else if(field462 == 5) {
         class24.method573(this);
         class113.method2401();
         class216.method3903();
      } else if(field462 != 10 && field462 != 11) {
         if(field462 == 20) {
            class24.method573(this);
            class123.method2734();
         } else if(field462 == 25) {
            class77.method1656();
         }
      } else {
         class24.method573(this);
      }

      if(field462 == 30) {
         class166.method3217();
      } else if(field462 == 40 || field462 == 45) {
         class123.method2734();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-905979487"
   )
   protected final void vmethod3030() {
      if(class106.field1879.method184()) {
         class106.field1879.method206();
      }

      if(null != class47.field1082) {
         class47.field1082.field208 = false;
      }

      class47.field1082 = null;
      if(null != class51.field1112) {
         class51.field1112.method2960();
         class51.field1112 = null;
      }

      if(class137.field2137 != null) {
         class137 var1 = class137.field2137;
         synchronized(class137.field2137) {
            class137.field2137 = null;
         }
      }

      class107.method2350();
      class46.field1068 = null;
      if(class17.field247 != null) {
         class17.field247.method1138();
      }

      if(null != field331) {
         field331.method1138();
      }

      if(class43.field1023 != null) {
         class43.field1023.method2960();
      }

      class136.method2864();
      class98.method2152();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-147333044"
   )
   void method222() {
      if(field462 != 1000) {
         boolean var1 = class101.method2232();
         if(!var1) {
            this.method520();
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1231343033"
   )
   void method224(int var1) {
      field312 = null;
      class139.field2167 = null;
      field313 = 0;
      if(class110.field1939 == class35.field782) {
         class35.field782 = class107.field1886;
      } else {
         class35.field782 = class110.field1939;
      }

      ++field528;
      if(field528 < 2 || var1 != 7 && var1 != 9) {
         if(field528 >= 2 && var1 == 6) {
            this.method2997("js5connect_outofdate");
            field462 = 1000;
         } else if(field528 >= 4) {
            if(field462 <= 5) {
               this.method2997("js5connect");
               field462 = 1000;
            } else {
               field314 = 3000;
            }
         }
      } else if(field462 <= 5) {
         this.method2997("js5connect_full");
         field462 = 1000;
      } else {
         field314 = 3000;
      }

   }

   static {
      field309 = class20.field570;
      field458 = class20.field570;
      field311 = 0;
      field313 = 0;
      field314 = 0;
      field528 = 0;
      field316 = 0;
      field317 = 0;
      field318 = 0;
      field360 = 0;
      field320 = new class34['耀'];
      field293 = 0;
      field322 = new int['耀'];
      field323 = 0;
      field285 = new int[250];
      field325 = new class122(5000);
      field326 = new class122(5000);
      field327 = new class122(15000);
      field328 = 0;
      field329 = 0;
      field481 = 0;
      field514 = 0;
      field390 = 0;
      field333 = 0;
      field334 = 0;
      field335 = 0;
      field336 = false;
      field338 = 0;
      field339 = 1;
      field340 = 0;
      field341 = 1;
      field403 = 0;
      field344 = new class108[4];
      field345 = false;
      field346 = new int[4][13][13];
      field347 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field445 = 0;
      field349 = 2;
      field350 = 0;
      field351 = 2;
      field352 = 0;
      field353 = 1;
      field354 = 0;
      field355 = 0;
      field356 = 2;
      field357 = 0;
      field407 = 1;
      field359 = 0;
      field330 = 0;
      field361 = 2301979;
      field362 = 5063219;
      field363 = 3353893;
      field364 = 7759444;
      field457 = false;
      field366 = 0;
      field367 = 128;
      field302 = 0;
      field369 = 0;
      field509 = 0;
      field371 = 0;
      field372 = 0;
      field373 = 50;
      field383 = 0;
      field497 = false;
      field471 = 0;
      field377 = 0;
      field378 = 50;
      field554 = new int[field378];
      field380 = new int[field378];
      field381 = new int[field378];
      field430 = new int[field378];
      field550 = new int[field378];
      field368 = new int[field378];
      field385 = new int[field378];
      field447 = new String[field378];
      field387 = new int[104][104];
      field388 = 0;
      field389 = -1;
      field365 = -1;
      field391 = 0;
      field321 = 0;
      field393 = 0;
      field394 = 0;
      field564 = 0;
      field397 = 0;
      field398 = 0;
      field424 = 0;
      field315 = 0;
      field401 = 0;
      field402 = false;
      field440 = 0;
      field404 = 0;
      field405 = new class2[2048];
      field460 = -1;
      field451 = 0;
      field516 = 0;
      field409 = new int[1000];
      field410 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field461 = new String[8];
      field412 = new boolean[8];
      field438 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field484 = -1;
      field415 = new class199[4][104][104];
      field542 = new class199();
      field417 = new class199();
      field446 = new class199();
      field303 = new int[25];
      field420 = new int[25];
      field421 = new int[25];
      field422 = 0;
      field423 = false;
      field294 = 0;
      field425 = new int[500];
      field426 = new int[500];
      field392 = new int[500];
      field502 = new int[500];
      field429 = new String[500];
      field337 = new String[500];
      field431 = -1;
      field375 = -1;
      field433 = 0;
      field434 = 50;
      field379 = 0;
      field463 = null;
      field437 = false;
      field342 = -1;
      field439 = -1;
      field432 = null;
      field441 = null;
      field442 = -1;
      field443 = new class196(8);
      field444 = 0;
      field450 = 0;
      field399 = null;
      field531 = 0;
      field448 = 0;
      field449 = 0;
      field370 = -1;
      field539 = false;
      field452 = false;
      field453 = false;
      field454 = null;
      field455 = null;
      field456 = null;
      field491 = 0;
      field348 = 0;
      field459 = null;
      field416 = false;
      field279 = -1;
      field408 = -1;
      field427 = false;
      field503 = -1;
      field465 = -1;
      field513 = false;
      field467 = 1;
      field512 = new int[32];
      field469 = 0;
      field470 = new int[32];
      field386 = 0;
      field472 = new int[32];
      field473 = 0;
      field474 = 0;
      field475 = 0;
      field382 = 0;
      field477 = 0;
      field537 = 0;
      field479 = 0;
      field480 = 0;
      field395 = new class199();
      field482 = new class199();
      field483 = new class199();
      field428 = new class196(512);
      field485 = 0;
      field468 = -2;
      field396 = new boolean[100];
      field488 = new boolean[100];
      field546 = new boolean[100];
      field490 = new int[100];
      field436 = new int[100];
      field535 = new int[100];
      field493 = new int[100];
      field494 = 0;
      field495 = 0L;
      field496 = true;
      field565 = 765;
      field498 = 1;
      field499 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field500 = 0;
      field501 = 0;
      field299 = "";
      field487 = new long[100];
      field504 = 0;
      field505 = 0;
      field562 = new int[128];
      field507 = new int[128];
      field508 = -1L;
      field282 = null;
      field510 = null;
      field511 = -1;
      field310 = 0;
      field411 = new int[1000];
      field492 = new int[1000];
      field464 = new class78[1000];
      field545 = 0;
      field517 = 0;
      field549 = 0;
      field519 = 255;
      field520 = -1;
      field521 = false;
      field560 = 127;
      field374 = 127;
      field524 = 0;
      field525 = new int[50];
      field319 = new int[50];
      field527 = new int[50];
      field532 = new int[50];
      field529 = new class58[50];
      field530 = false;
      field486 = new boolean[5];
      field281 = new int[5];
      field533 = new int[5];
      field534 = new int[5];
      field466 = new int[5];
      field536 = 256;
      field419 = 205;
      field538 = 256;
      field518 = 320;
      field540 = 1;
      field541 = 32767;
      field526 = 1;
      field543 = 32767;
      field544 = 0;
      field489 = 0;
      field414 = 0;
      field547 = 0;
      field548 = 0;
      field418 = 0;
      field522 = 0;
      field551 = new class17[400];
      field552 = new class195();
      field553 = 0;
      field400 = new class7[400];
      field555 = new class179();
      field556 = -1;
      field557 = -1;
      field558 = new class220[8];
      field476 = -1L;
      field561 = -1L;
      field324 = new class10();
      field563 = new int[50];
      field435 = new int[50];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "74"
   )
   @Export("addChatMessage")
   static void method325(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field175.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new class27();
         class11.field175.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method618(var0, var1, var2, var3);
      class11.field180.method3762(var5, (long)var5.field780);
      class11.field174.method3808(var5);
      field474 = field467;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-67"
   )
   public static void method417() {
      if(class136.field2114.toLowerCase().indexOf("microsoft") != -1) {
         class137.field2154[186] = 57;
         class137.field2154[187] = 27;
         class137.field2154[188] = 71;
         class137.field2154[189] = 26;
         class137.field2154[190] = 72;
         class137.field2154[191] = 73;
         class137.field2154[192] = 58;
         class137.field2154[219] = 42;
         class137.field2154[220] = 74;
         class137.field2154[221] = 43;
         class137.field2154[222] = 59;
         class137.field2154[223] = 28;
      } else {
         class137.field2154[44] = 71;
         class137.field2154[45] = 26;
         class137.field2154[46] = 72;
         class137.field2154[47] = 73;
         class137.field2154[59] = 57;
         class137.field2154[61] = 27;
         class137.field2154[91] = 42;
         class137.field2154[92] = 74;
         class137.field2154[93] = 43;
         class137.field2154[192] = 28;
         class137.field2154[222] = 58;
         class137.field2154[520] = 59;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "36418783"
   )
   protected final void vmethod2993() {
      class110.field1939 = field384 == 0?'ꩊ':'鱀' + field478;
      class107.field1886 = field384 == 0?443:field478 + '썐';
      class35.field782 = class110.field1939;
      class45.field1049 = class174.field2912;
      class127.field2060 = class174.field2911;
      class135.field2106 = class174.field2913;
      class179.field2940 = class174.field2914;
      method417();
      class82.method1845(class59.field1221);
      class106.method2342(class59.field1221);
      class46.field1068 = class82.method1843();
      if(class46.field1068 != null) {
         class46.field1068.vmethod3072(class59.field1221);
      }

      class24.field620 = new class134(255, class149.field2264, class149.field2268, 500000);
      class227 var2 = null;
      class8 var3 = new class8();

      try {
         var2 = class17.method170("", class214.field3158.field2316, false);
         byte[] var4 = new byte[(int)var2.method4075()];

         int var6;
         for(int var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.method4086(var4, var5, var4.length - var5);
            if(var6 == -1) {
               throw new IOException();
            }
         }

         var3 = new class8(new class119(var4));
      } catch (Exception var8) {
         ;
      }

      try {
         if(var2 != null) {
            var2.method4074();
         }
      } catch (Exception var7) {
         ;
      }

      class116.field1988 = var3;
      class158.field2623 = this.getToolkit().getSystemClipboard();
      String var9 = class56.field1204;
      class138.field2156 = this;
      class138.field2155 = var9;
      if(field384 != 0) {
         field376 = true;
      }

      class56.method1188(class116.field1988.field140);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "50269187"
   )
   protected final void vmethod2995() {
      boolean var1 = class119.method2668();
      if(var1 && field521 && null != class17.field247) {
         class17.field247.method1137();
      }

      if(field462 == 10 || field462 == 20 || field462 == 30) {
         if(field495 != 0L && class124.method2746() > field495) {
            int var2 = field496?2:1;
            class56.method1188(var2);
         } else if(class144.field2234) {
            class99.method2154();
         }
      }

      Dimension var11 = this.method2999();
      if(class126.field2049 != var11.width || class109.field1915 != var11.height || class144.field2237) {
         class113.method2405();
         field495 = class124.method2746() + 500L;
         class144.field2237 = false;
      }

      boolean var3 = false;
      int var4;
      if(class144.field2235) {
         class144.field2235 = false;
         var3 = true;

         for(var4 = 0; var4 < 100; ++var4) {
            field396[var4] = true;
         }
      }

      if(var3) {
         class94.method2124();
      }

      if(field462 == 0) {
         var4 = class31.field715;
         String var5 = class31.field735;
         Color var6 = null;

         try {
            Graphics var7 = class59.field1221.getGraphics();
            if(null == class148.field2262) {
               class148.field2262 = new Font("Helvetica", 1, 13);
               class45.field1050 = class59.field1221.getFontMetrics(class148.field2262);
            }

            if(var3) {
               var7.setColor(Color.black);
               var7.fillRect(0, 0, class10.field162, class41.field966);
            }

            if(null == var6) {
               var6 = new Color(140, 17, 17);
            }

            try {
               if(null == class159.field2626) {
                  class159.field2626 = class59.field1221.createImage(304, 34);
               }

               Graphics var8 = class159.field2626.getGraphics();
               var8.setColor(var6);
               var8.drawRect(0, 0, 303, 33);
               var8.fillRect(2, 2, 3 * var4, 30);
               var8.setColor(Color.black);
               var8.drawRect(1, 1, 301, 31);
               var8.fillRect(2 + 3 * var4, 2, 300 - 3 * var4, 30);
               var8.setFont(class148.field2262);
               var8.setColor(Color.white);
               var8.drawString(var5, (304 - class45.field1050.stringWidth(var5)) / 2, 22);
               var7.drawImage(class159.field2626, class10.field162 / 2 - 152, class41.field966 / 2 - 18, (ImageObserver)null);
            } catch (Exception var14) {
               int var9 = class10.field162 / 2 - 152;
               int var10 = class41.field966 / 2 - 18;
               var7.setColor(var6);
               var7.drawRect(var9, var10, 303, 33);
               var7.fillRect(var9 + 2, 2 + var10, var4 * 3, 30);
               var7.setColor(Color.black);
               var7.drawRect(var9 + 1, var10 + 1, 301, 31);
               var7.fillRect(3 * var4 + var9 + 2, 2 + var10, 300 - var4 * 3, 30);
               var7.setFont(class148.field2262);
               var7.setColor(Color.white);
               var7.drawString(var5, var9 + (304 - class45.field1050.stringWidth(var5)) / 2, 22 + var10);
            }
         } catch (Exception var15) {
            class59.field1221.repaint();
         }
      } else if(field462 == 5) {
         class33.method703(class4.field79, class1.field26, class82.field1440, var3);
      } else if(field462 != 10 && field462 != 11) {
         if(field462 == 20) {
            class33.method703(class4.field79, class1.field26, class82.field1440, var3);
         } else if(field462 == 25) {
            if(field403 == 1) {
               if(field338 > field339) {
                  field339 = field338;
               }

               var4 = (field339 * 50 - field338 * 50) / field339;
               class76.method1632("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field403 == 2) {
               if(field340 > field341) {
                  field341 = field340;
               }

               var4 = (field341 * 50 - field340 * 50) / field341 + 50;
               class76.method1632("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class76.method1632("Loading - please wait.", false);
            }
         } else if(field462 == 30) {
            class19.method189();
         } else if(field462 == 40) {
            class76.method1632("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field462 == 45) {
            class76.method1632("Please wait...", false);
         }
      } else {
         class33.method703(class4.field79, class1.field26, class82.field1440, var3);
      }

      Graphics var12;
      int var13;
      if(field462 == 30 && field494 == 0 && !var3) {
         try {
            var12 = class59.field1221.getGraphics();

            for(var13 = 0; var13 < field485; ++var13) {
               if(field488[var13]) {
                  class96.field1646.vmethod1830(var12, field490[var13], field436[var13], field535[var13], field493[var13]);
                  field488[var13] = false;
               }
            }
         } catch (Exception var17) {
            class59.field1221.repaint();
         }
      } else if(field462 > 0) {
         try {
            var12 = class59.field1221.getGraphics();
            class96.field1646.vmethod1829(var12, 0, 0);

            for(var13 = 0; var13 < field485; ++var13) {
               field488[var13] = false;
            }
         } catch (Exception var16) {
            class59.field1221.repaint();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2064799166"
   )
   void method520() {
      if(class171.field2758 >= 4) {
         this.method2997("js5crc");
         field462 = 1000;
      } else {
         if(class171.field2752 >= 4) {
            if(field462 <= 5) {
               this.method2997("js5io");
               field462 = 1000;
               return;
            }

            field314 = 3000;
            class171.field2752 = 3;
         }

         if(--field314 + 1 <= 0) {
            try {
               if(field313 == 0) {
                  field312 = class77.field1400.method2867(class161.field2670, class35.field782);
                  ++field313;
               }

               if(field313 == 1) {
                  if(field312.field2249 == 2) {
                     this.method224(-1);
                     return;
                  }

                  if(field312.field2249 == 1) {
                     ++field313;
                  }
               }

               if(field313 == 2) {
                  class139.field2167 = new class143((Socket)field312.field2246, class77.field1400);
                  class119 var1 = new class119(5);
                  var1.method2453(15);
                  var1.method2456(115);
                  class139.field2167.method2964(var1.field2001, 0, 5);
                  ++field313;
                  class0.field11 = class124.method2746();
               }

               if(field313 == 3) {
                  if(field462 > 5 && class139.field2167.method2980() <= 0) {
                     if(class124.method2746() - class0.field11 > 30000L) {
                        this.method224(-2);
                        return;
                     }
                  } else {
                     int var2 = class139.field2167.method2961();
                     if(var2 != 0) {
                        this.method224(var2);
                        return;
                     }

                     ++field313;
                  }
               }

               if(field313 == 4) {
                  class12.method132(class139.field2167, field462 > 20);
                  field312 = null;
                  class139.field2167 = null;
                  field313 = 0;
                  field528 = 0;
               }
            } catch (IOException var3) {
               this.method224(-3);
            }

         }
      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "59"
   )
   static final void method541(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class173.method3380(var0)) {
         class7.method86(class216.field3168[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lclass78;",
      garbageValue = "1621223549"
   )
   @Export("createSprite")
   public static final class78 method542(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var4 << 40) + ((long)var3 << 42);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1133.method3716(var6);
         if(var8 != null) {
            return var8;
         }
      }

      class51 var9 = class123.method2743(var0);
      if(var1 > 1 && null != var9.field1148) {
         int var10 = -1;

         for(int var19 = 0; var19 < 10; ++var19) {
            if(var1 >= var9.field1149[var19] && var9.field1149[var19] != 0) {
               var10 = var9.field1148[var19];
            }
         }

         if(var10 != -1) {
            var9 = class123.method2743(var10);
         }
      }

      class105 var20 = var9.method998(1);
      if(null == var20) {
         return null;
      } else {
         class78 var11 = null;
         if(var9.field1151 != -1) {
            var11 = method542(var9.field1150, 10, 1, 0, 0, true);
            if(null == var11) {
               return null;
            }
         } else if(var9.field1128 != -1) {
            var11 = method542(var9.field1159, var1, var2, var3, 0, false);
            if(null == var11) {
               return null;
            }
         } else if(var9.field1162 != -1) {
            var11 = method542(var9.field1161, var1, 0, 0, 0, false);
            if(null == var11) {
               return null;
            }
         }

         int[] var12 = class79.field1418;
         int var13 = class79.field1421;
         int var14 = class79.field1417;
         int[] var15 = new int[4];
         class79.method1755(var15);
         var8 = new class78(36, 32);
         class79.method1751(var8.field1409, 36, 32);
         class79.method1757();
         class91.method2084();
         class91.method2102(16, 16);
         class91.field1582 = false;
         if(var9.field1162 != -1) {
            var11.method1667(0, 0);
         }

         int var16 = var9.field1111;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * class91.field1602[var9.field1126] >> 16;
         int var18 = class91.field1603[var9.field1126] * var16 >> 16;
         var20.method2258();
         var20.method2269(0, var9.field1127, var9.field1144, var9.field1126, var9.field1110, var9.field1130 + var17 + var20.field1466 / 2, var18 + var9.field1130);
         if(var9.field1128 != -1) {
            var11.method1667(0, 0);
         }

         if(var2 >= 1) {
            var8.method1671(1);
         }

         if(var2 >= 2) {
            var8.method1671(16777215);
         }

         if(var3 != 0) {
            var8.method1694(var3);
         }

         class79.method1751(var8.field1409, 36, 32);
         if(var9.field1151 != -1) {
            var11.method1667(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.field1131 == 1) {
            class51.field1132.method3968(class95.method2131(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1133.method3724(var8, var6);
         }

         class79.method1751(var12, var13, var14);
         class79.method1756(var15);
         class91.method2084();
         class91.field1582 = true;
         return var8;
      }
   }
}
