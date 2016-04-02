import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
public final class client extends class144 {
   @ObfuscatedName("os")
   static int[] field276;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1800205333
   )
   static int field277;
   @ObfuscatedName("ln")
   static int[] field278;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1555627675
   )
   @Export("world")
   static int field279 = 1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1403886911
   )
   static int field280 = 0;
   @ObfuscatedName("g")
   static class153 field281;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1453317513
   )
   static int field282 = 0;
   @ObfuscatedName("k")
   static class212 field283;
   @ObfuscatedName("m")
   static boolean field284 = false;
   @ObfuscatedName("n")
   static boolean field285 = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -459180087
   )
   static int field286 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 14597701
   )
   @Export("gameState")
   static int field287 = 0;
   @ObfuscatedName("q")
   static boolean field288 = true;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 701790207
   )
   @Export("gameCycle")
   static int field289 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 4202642194741981205L
   )
   static long field290 = -1L;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 699538663
   )
   static int field291 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1162623519
   )
   static int field292 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -920397321
   )
   static int field293 = -1;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 1446671899
   )
   static int field294;
   @ObfuscatedName("ai")
   static boolean field295 = false;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 71992549
   )
   static int field296;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -14465295
   )
   static int field297 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1553524723
   )
   static int field298 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1915348621
   )
   static int field299 = 0;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -836285779
   )
   static int field300;
   @ObfuscatedName("ig")
   @Export("menuTypes")
   static int[] field301;
   @ObfuscatedName("s")
   static boolean field302 = true;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2047977377
   )
   static int field303 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 737347793
   )
   static int field304 = 0;
   @ObfuscatedName("af")
   static class146 field305;
   @ObfuscatedName("mo")
   static int[] field306;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -947631545
   )
   static int field307;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -1735592613
   )
   static int field308;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1948531063
   )
   static int field309;
   @ObfuscatedName("pw")
   static final class10 field310;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -2124321407
   )
   static int field311;
   @ObfuscatedName("ap")
   static boolean field312 = true;
   @ObfuscatedName("ns")
   static boolean field313;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 214467303
   )
   static int field314;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -105150723
   )
   static int field315;
   @ObfuscatedName("ca")
   @Export("cachedNPCs")
   static class34[] field316;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -846680755
   )
   static int field317;
   @ObfuscatedName("ce")
   static int[] field318;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 753962509
   )
   static int field319;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -1705754977
   )
   static int field320;
   @ObfuscatedName("cm")
   static class122 field321;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -186934625
   )
   static int field322;
   @ObfuscatedName("cw")
   static class122 field323;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 907194983
   )
   static int field324;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1167389857
   )
   @Export("packetOpcode")
   static int field325;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 665873723
   )
   static int field326;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -380439877
   )
   static int field327;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1508728745
   )
   static int field328;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1786455807
   )
   static int field329;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 13059557
   )
   static int field330;
   @ObfuscatedName("hm")
   @Export("isMenuOpen")
   static boolean field331;
   @ObfuscatedName("co")
   static boolean field332;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = -901294519
   )
   static int field333;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 861086171
   )
   static int field334;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -1494796909
   )
   static int field335;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 1753004429
   )
   static int field336;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1696495027
   )
   static int field337;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class108[] field338;
   @ObfuscatedName("dl")
   static boolean field339;
   @ObfuscatedName("lb")
   static long[] field340;
   @ObfuscatedName("dm")
   static final int[] field341;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 1507452787
   )
   static int field342;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -907291671
   )
   static int field343;
   @ObfuscatedName("gd")
   static String[] field344;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -1241966913
   )
   static int field345;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1077163049
   )
   static int field346 = 0;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1052345987
   )
   static int field347;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 1671104313
   )
   static int field348;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 309657007
   )
   static int field349;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1299504623
   )
   @Export("mapScale")
   static int field350;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -740746765
   )
   static int field351;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -778838685
   )
   static int field352;
   @ObfuscatedName("hf")
   static final int[] field353;
   @ObfuscatedName("lz")
   static int[] field354;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = -281576665
   )
   static int field355;
   @ObfuscatedName("fe")
   static int[] field356;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 990798477
   )
   static int field357;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 577490419
   )
   static int field359;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 413073223
   )
   static int field360;
   @ObfuscatedName("ef")
   static boolean field361;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 1849521019
   )
   static int field362;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -442146079
   )
   static int field363;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 1412190281
   )
   static int field364;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 2005803557
   )
   @Export("weight")
   static int field365;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 1486302427
   )
   static int field366;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 2136809173
   )
   static int field367;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -686685239
   )
   @Export("mapAngle")
   static int field368;
   @ObfuscatedName("gl")
   static int[][] field369;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -166044595
   )
   static int field370;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = -190052485
   )
   @Export("camera2")
   static int field371;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -376380125
   )
   static int field372;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 637697947
   )
   static int field373;
   @ObfuscatedName("f")
   static client field374;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -2041366429
   )
   static int field375;
   @ObfuscatedName("fc")
   static int[] field376;
   @ObfuscatedName("iu")
   static String field377;
   @ObfuscatedName("fq")
   static int[] field378;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -1951424561
   )
   static int field379;
   @ObfuscatedName("fb")
   static int[] field380;
   @ObfuscatedName("gp")
   static int[] field381;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 49409241
   )
   static int field382;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 284197265
   )
   static int field383;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -1032202967
   )
   static int field384;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 15856973
   )
   static int field385;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -2091628169
   )
   static int field386;
   @ObfuscatedName("gf")
   @Export("cachedPlayers")
   static class2[] field387;
   @ObfuscatedName("og")
   static boolean[] field388;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 772500107
   )
   static int field389;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1145663329
   )
   static int field390;
   @ObfuscatedName("io")
   @Export("menuIdentifiers")
   static int[] field391;
   @ObfuscatedName("iy")
   static String field392;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 339561103
   )
   static int field393;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1983403145
   )
   static int field394;
   @ObfuscatedName("fw")
   static int[] field395;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -1583677523
   )
   static int field396;
   @ObfuscatedName("gj")
   static boolean field397;
   @ObfuscatedName("ls")
   @Export("isResized")
   static boolean field398;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -2069646003
   )
   static int field399;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 792304045
   )
   static int field400;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -1804719031
   )
   static int field401;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 1973763503
   )
   static int field402;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 1796594999
   )
   static int field403;
   @ObfuscatedName("hr")
   static int[] field404;
   @ObfuscatedName("fo")
   static int[] field405;
   @ObfuscatedName("hx")
   static String[] field406;
   @ObfuscatedName("hc")
   static boolean[] field407;
   @ObfuscatedName("hs")
   static int[] field408;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 1587929829
   )
   static int field409;
   @ObfuscatedName("hj")
   @Export("groundItemDeque")
   static class199[][][] field410;
   @ObfuscatedName("hi")
   static class199 field411;
   @ObfuscatedName("hb")
   static class199 field412;
   @ObfuscatedName("hg")
   static class199 field413;
   @ObfuscatedName("lv")
   static boolean[] field414;
   @ObfuscatedName("hh")
   @Export("realSkillLevels")
   static int[] field415;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 92098315
   )
   static int field416;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -872754815
   )
   static int field417;
   @ObfuscatedName("mb")
   static int[] field418;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 426829697
   )
   static int field419;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 942271797
   )
   @Export("menuOptionCount")
   static int field420;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 515162041
   )
   static int field421;
   @ObfuscatedName("ie")
   static int[] field422;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 1198953007
   )
   static int field423;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1285844517
   )
   static int field424;
   @ObfuscatedName("ir")
   @Export("menuOptions")
   static String[] field425;
   @ObfuscatedName("ib")
   @Export("menuTargets")
   static String[] field426;
   @ObfuscatedName("ml")
   static boolean field427;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -185839333
   )
   static int field428;
   @ObfuscatedName("ck")
   static class122 field429;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1042778511
   )
   static int field430 = 0;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 319255411
   )
   static int field431;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -420085551
   )
   static int field432;
   @ObfuscatedName("is")
   static boolean field433;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 251573539
   )
   static int field434;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 25613843
   )
   static int field435;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -344455511
   )
   static int field436;
   @ObfuscatedName("id")
   static String field437;
   @ObfuscatedName("it")
   @ObfuscatedGetter(
      intValue = 1864038559
   )
   static int field438;
   @ObfuscatedName("iz")
   @Export("componentTable")
   static class196 field439;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -1805851965
   )
   static int field440;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -2081898583
   )
   static int field441;
   @ObfuscatedName("jz")
   static class173 field442;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 199950107
   )
   @Export("energy")
   static int field443;
   @ObfuscatedName("nz")
   static class58[] field444;
   @ObfuscatedName("cf")
   static int[] field445;
   @ObfuscatedName("nc")
   static int[] field446;
   @ObfuscatedName("jo")
   static boolean field447;
   @ObfuscatedName("jq")
   static boolean field448;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -231413149
   )
   static int field449;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1057022379
   )
   static int field450;
   @ObfuscatedName("ju")
   static class173 field451;
   @ObfuscatedName("jj")
   static class173 field452;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 528857245
   )
   static int field453;
   @ObfuscatedName("aw")
   static class20 field454;
   @ObfuscatedName("jh")
   static class173 field455;
   @ObfuscatedName("oq")
   static short field456;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -1083208163
   )
   static int field457;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 837779191
   )
   static int field458;
   @ObfuscatedName("jy")
   static boolean field459;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -1300467795
   )
   static int field460;
   @ObfuscatedName("od")
   static short field461;
   @ObfuscatedName("ja")
   static boolean field462;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -1233877663
   )
   static int field463;
   @ObfuscatedName("kl")
   static int[] field464;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -565887519
   )
   static int field465;
   @ObfuscatedName("kr")
   static class199 field466;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -1585334607
   )
   static int field467;
   @ObfuscatedName("kx")
   static int[] field468;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -2034626487
   )
   static int field469;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -2085947975
   )
   static int field470;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -2079825849
   )
   static int field471;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1975117175
   )
   static int field472;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 1018834815
   )
   static int field473;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -1260306989
   )
   static int field474;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -1450065417
   )
   static int field475;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -799638195
   )
   static int field476;
   @ObfuscatedName("fr")
   static boolean field477;
   @ObfuscatedName("km")
   static class199 field478;
   @ObfuscatedName("kc")
   static class199 field479;
   @ObfuscatedName("kf")
   static class196 field480;
   @ObfuscatedName("ky")
   static int[] field481;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 979598911
   )
   static int field482;
   @ObfuscatedName("lg")
   static boolean[] field483;
   @ObfuscatedName("lw")
   static boolean[] field484;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1223602289
   )
   static int field485 = -1;
   @ObfuscatedName("lj")
   @Export("widgetPositionX")
   static int[] field486;
   @ObfuscatedName("lt")
   @Export("widgetPositionY")
   static int[] field487;
   @ObfuscatedName("ad")
   static class20 field488;
   @ObfuscatedName("lp")
   static int[] field489;
   @ObfuscatedName("lm")
   static int field490;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      longValue = -3867066298585849779L
   )
   static long field491;
   @ObfuscatedName("ha")
   @Export("boostedSkillLevels")
   static int[] field492;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 1033197807
   )
   static int field493;
   @ObfuscatedName("hk")
   static int[] field494;
   @ObfuscatedName("la")
   static String field495;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -2119761099
   )
   static int field496;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -1006138609
   )
   static int field497;
   @ObfuscatedName("ds")
   static int[][][] field498;
   @ObfuscatedName("mk")
   static int[] field499;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -1308949573
   )
   static int field500;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 588136651
   )
   static int field501;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1982818493
   )
   static int field502;
   @ObfuscatedName("mq")
   static int[] field503;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      longValue = -1465655951015151199L
   )
   static long field504;
   @ObfuscatedName("mp")
   static String field505;
   @ObfuscatedName("mm")
   static String field506;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 1553446595
   )
   static int field507;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 1342921451
   )
   static int field508;
   @ObfuscatedName("js")
   static boolean field509;
   @ObfuscatedName("ji")
   static class173 field510;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 806247661
   )
   static int field511;
   @ObfuscatedName("ed")
   static class78[] field512;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 1772791285
   )
   static int field513;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = 945787319
   )
   static int field514;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -1363057805
   )
   static int field515;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 2054883279
   )
   static int field516;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 1011983979
   )
   static int field517;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -1894185737
   )
   static int field518;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = 1899438201
   )
   static int field519;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -794139999
   )
   static int field520;
   @ObfuscatedName("no")
   static int[] field521;
   @ObfuscatedName("na")
   static int[] field522;
   @ObfuscatedName("ng")
   static int[] field523;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 280566859
   )
   static int field524;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 631583905
   )
   static int field525;
   @ObfuscatedName("ob")
   static short field526;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -1172298559
   )
   static int field527;
   @ObfuscatedName("ow")
   static int[] field528;
   @ObfuscatedName("oc")
   static int[] field529;
   @ObfuscatedName("mw")
   static class78[] field530;
   @ObfuscatedName("or")
   static int[] field531;
   @ObfuscatedName("oa")
   static short field532;
   @ObfuscatedName("oe")
   static short field533;
   @ObfuscatedName("oi")
   static short field534;
   @ObfuscatedName("ok")
   static short field535;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1552506739
   )
   static int field536 = 0;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 1760058723
   )
   static int field537;
   @ObfuscatedName("oo")
   static short field538;
   @ObfuscatedName("je")
   static boolean field539;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 961942655
   )
   static int field540;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = -1636854177
   )
   static int field541;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1917934951
   )
   static int field542;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -466003263
   )
   @Export("camera3")
   static int field543;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 1204648801
   )
   @Export("scale")
   static int field544;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = -39512017
   )
   static int field545;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -1267438877
   )
   static int field546;
   @ObfuscatedName("oh")
   @Export("friends")
   static class17[] field547;
   @ObfuscatedName("ox")
   static class195 field548;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -843684993
   )
   static int field549;
   @ObfuscatedName("ot")
   @Export("ignores")
   static class7[] field550;
   @ObfuscatedName("pi")
   static class179 field551;
   @ObfuscatedName("hu")
   @Export("skillExperiences")
   static int[] field552;
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = -1248264437
   )
   static int field553;
   @ObfuscatedName("pq")
   @Export("grandExchangeOffers")
   static class220[] field554;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      longValue = 7044905122269679881L
   )
   static long field555;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      longValue = -297121674198628217L
   )
   static long field556;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -1203015971
   )
   static int field557;
   @ObfuscatedName("pv")
   static int[] field558;
   @ObfuscatedName("pz")
   static int[] field559;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   protected final void vmethod3018() {
      class155.field2281 = field282 == 0?'ꩊ':'鱀' + field279;
      class113.field1947 = field282 == 0?443:'썐' + field279;
      class51.field1103 = class155.field2281;
      class179.field2922 = class174.field2895;
      class179.field2923 = class174.field2891;
      class174.field2894 = class174.field2890;
      class84.field1433 = class174.field2892;
      if(class226.field3212.toLowerCase().indexOf("microsoft") != -1) {
         class137.field2115[186] = 57;
         class137.field2115[187] = 27;
         class137.field2115[188] = 71;
         class137.field2115[189] = 26;
         class137.field2115[190] = 72;
         class137.field2115[191] = 73;
         class137.field2115[192] = 58;
         class137.field2115[219] = 42;
         class137.field2115[220] = 74;
         class137.field2115[221] = 43;
         class137.field2115[222] = 59;
         class137.field2115[223] = 28;
      } else {
         class137.field2115[44] = 71;
         class137.field2115[45] = 26;
         class137.field2115[46] = 72;
         class137.field2115[47] = 73;
         class137.field2115[59] = 57;
         class137.field2115[61] = 27;
         class137.field2115[91] = 42;
         class137.field2115[92] = 74;
         class137.field2115[93] = 43;
         class137.field2115[192] = 28;
         class137.field2115[222] = 58;
         class137.field2115[520] = 59;
      }

      Canvas var1 = class12.field192;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class137.field2104);
      var1.addFocusListener(class137.field2104);
      class74.method1601(class12.field192);
      class142.field2166 = class99.method2216();
      if(null != class142.field2166) {
         class142.field2166.vmethod3110(class12.field192);
      }

      class169.field2698 = new class134(255, class149.field2227, class149.field2234, 500000);
      class227 var3 = null;
      class8 var4 = new class8();

      try {
         var3 = class143.method3003("", class164.field2657.field2278, false);
         byte[] var5 = new byte[(int)var3.method4115()];

         int var7;
         for(int var6 = 0; var6 < var5.length; var6 += var7) {
            var7 = var3.method4121(var5, var6, var5.length - var6);
            if(var7 == -1) {
               throw new IOException();
            }
         }

         var4 = new class8(new class119(var5));
      } catch (Exception var9) {
         ;
      }

      try {
         if(null != var3) {
            var3.method4114();
         }
      } catch (Exception var8) {
         ;
      }

      class39.field865 = var4;
      class16.field236 = this.getToolkit().getSystemClipboard();
      String var10 = class47.field1042;
      class138.field2123 = this;
      class138.field2122 = var10;
      if(field282 != 0) {
         field295 = true;
      }

      class8.method119(class39.field865.field148);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "972000505"
   )
   protected final void vmethod3020() {
      boolean var1;
      label248: {
         try {
            if(class183.field2958 == 2) {
               if(class183.field2955 == null) {
                  class183.field2955 = class180.method3499(class14.field209, class148.field2219, class164.field2656);
                  if(null == class183.field2955) {
                     var1 = false;
                     break label248;
                  }
               }

               if(class226.field3214 == null) {
                  class226.field3214 = new class59(class183.field2956, class183.field2960);
               }

               if(class183.field2957.method3590(class183.field2955, class183.field2961, class226.field3214, 22050)) {
                  class183.field2957.method3647();
                  class183.field2957.method3588(class96.field1611);
                  class183.field2957.method3593(class183.field2955, class125.field2030);
                  class183.field2958 = 0;
                  class183.field2955 = null;
                  class226.field3214 = null;
                  class14.field209 = null;
                  var1 = true;
                  break label248;
               }
            }
         } catch (Exception var16) {
            var16.printStackTrace();
            class183.field2957.method3679();
            class183.field2958 = 0;
            class183.field2955 = null;
            class226.field3214 = null;
            class14.field209 = null;
         }

         var1 = false;
      }

      if(var1 && field427 && class221.field3179 != null) {
         class221.field3179.method1177();
      }

      int var5;
      int var6;
      if(10 == field287 || field287 == 20 || 30 == field287) {
         if(field491 != 0L && class140.method2967() > field491) {
            class8.method119(class89.method2098());
         } else if(class144.field2190) {
            class82.method1901(class12.field192);
            class172.method3369(class12.field192);
            if(null != class142.field2166) {
               class142.field2166.vmethod3113(class12.field192);
            }

            field374.method3073();
            class12.field192.setBackground(Color.black);
            Canvas var3 = class12.field192;
            var3.setFocusTraversalKeysEnabled(false);
            var3.addKeyListener(class137.field2104);
            var3.addFocusListener(class137.field2104);
            class74.method1601(class12.field192);
            if(class142.field2166 != null) {
               class142.field2166.vmethod3110(class12.field192);
            }

            if(-1 != field438) {
               int var4 = field438;
               var5 = class35.field762;
               var6 = class21.field575;
               if(class113.method2462(var4)) {
                  class51.method1062(class173.field2837[var4], -1, var5, var6, false);
               }
            }

            class144.field2202 = true;
         }
      }

      Dimension var17 = this.method3032();
      if(var17.width != class38.field854 || var17.height != class51.field1132 || class144.field2202) {
         class156.method3167();
         field491 = class140.method2967() + 500L;
         class144.field2202 = false;
      }

      boolean var18 = false;
      if(class144.field2204) {
         class144.field2204 = false;
         var18 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field483[var5] = true;
         }
      }

      if(var18) {
         class156.method3166();
      }

      if(field287 == 0) {
         var5 = class31.field707;
         String var19 = class31.field722;
         Color var7 = null;

         try {
            Graphics var8 = class12.field192.getGraphics();
            if(null == class34.field754) {
               class34.field754 = new Font("Helvetica", 1, 13);
               class135.field2076 = class12.field192.getFontMetrics(class34.field754);
            }

            if(var18) {
               var8.setColor(Color.black);
               var8.fillRect(0, 0, class35.field762, class21.field575);
            }

            if(null == var7) {
               var7 = new Color(140, 17, 17);
            }

            try {
               if(class13.field206 == null) {
                  class13.field206 = class12.field192.createImage(304, 34);
               }

               Graphics var9 = class13.field206.getGraphics();
               var9.setColor(var7);
               var9.drawRect(0, 0, 303, 33);
               var9.fillRect(2, 2, var5 * 3, 30);
               var9.setColor(Color.black);
               var9.drawRect(1, 1, 301, 31);
               var9.fillRect(var5 * 3 + 2, 2, 300 - var5 * 3, 30);
               var9.setFont(class34.field754);
               var9.setColor(Color.white);
               var9.drawString(var19, (304 - class135.field2076.stringWidth(var19)) / 2, 22);
               var8.drawImage(class13.field206, class35.field762 / 2 - 152, class21.field575 / 2 - 18, (ImageObserver)null);
            } catch (Exception var12) {
               int var10 = class35.field762 / 2 - 152;
               int var11 = class21.field575 / 2 - 18;
               var8.setColor(var7);
               var8.drawRect(var10, var11, 303, 33);
               var8.fillRect(2 + var10, var11 + 2, var5 * 3, 30);
               var8.setColor(Color.black);
               var8.drawRect(1 + var10, var11 + 1, 301, 31);
               var8.fillRect(var10 + 2 + var5 * 3, 2 + var11, 300 - 3 * var5, 30);
               var8.setFont(class34.field754);
               var8.setColor(Color.white);
               var8.drawString(var19, var10 + (304 - class135.field2076.stringWidth(var19)) / 2, var11 + 22);
            }
         } catch (Exception var13) {
            class12.field192.repaint();
         }
      } else if(5 == field287) {
         class108.method2415(class124.field2022, class34.field753, class25.field628, var18);
      } else if(field287 != 10 && field287 != 11) {
         if(field287 == 20) {
            class108.method2415(class124.field2022, class34.field753, class25.field628, var18);
         } else if(25 == field287) {
            if(1 == field337) {
               if(field333 > field334) {
                  field334 = field333;
               }

               var5 = (field334 * 50 - field333 * 50) / field334;
               class123.method2787("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(field337 == 2) {
               if(field335 > field336) {
                  field336 = field335;
               }

               var5 = (field336 * 50 - field335 * 50) / field336 + 50;
               class123.method2787("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class123.method2787("Loading - please wait.", false);
            }
         } else if(30 == field287) {
            class12.method161();
         } else if(40 == field287) {
            class123.method2787("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field287 == 45) {
            class123.method2787("Please wait...", false);
         }
      } else {
         class108.method2415(class124.field2022, class34.field753, class25.field628, var18);
      }

      Graphics var20;
      if(field287 == 30 && 0 == -755309 * field490 && !var18) {
         try {
            var20 = class12.field192.getGraphics();

            for(var6 = 0; var6 < field465; ++var6) {
               if(field484[var6]) {
                  class134.field2070.vmethod1897(var20, field486[var6], field487[var6], field354[var6], field489[var6]);
                  field484[var6] = false;
               }
            }
         } catch (Exception var15) {
            class12.field192.repaint();
         }
      } else if(field287 > 0) {
         try {
            var20 = class12.field192.getGraphics();
            class134.field2070.vmethod1886(var20, 0, 0);

            for(var6 = 0; var6 < field465; ++var6) {
               field484[var6] = false;
            }
         } catch (Exception var14) {
            class12.field192.repaint();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1369273826"
   )
   void method236(int var1) {
      class36.field783 = null;
      class82.field1405 = null;
      field309 = 0;
      if(class155.field2281 == class51.field1103) {
         class51.field1103 = class113.field1947;
      } else {
         class51.field1103 = class155.field2281;
      }

      ++field311;
      if(field311 < 2 || 7 != var1 && 9 != var1) {
         if(field311 >= 2 && 6 == var1) {
            this.method3099("js5connect_outofdate");
            field287 = 1000;
         } else if(field311 >= 4) {
            if(field287 <= 5) {
               this.method3099("js5connect");
               field287 = 1000;
            } else {
               field385 = 3000;
            }
         }
      } else if(field287 <= 5) {
         this.method3099("js5connect_full");
         field287 = 1000;
      } else {
         field385 = 3000;
      }

   }

   static {
      field454 = class20.field569;
      field488 = class20.field569;
      field450 = 0;
      field309 = 0;
      field385 = 0;
      field311 = 0;
      field542 = 0;
      field424 = 0;
      field314 = 0;
      field315 = 0;
      field316 = new class34['耀'];
      field317 = 0;
      field318 = new int['耀'];
      field502 = 0;
      field445 = new int[250];
      field321 = new class122(5000);
      field429 = new class122(5000);
      field323 = new class122(15000);
      field324 = 0;
      field325 = 0;
      field326 = 0;
      field347 = 0;
      field328 = 0;
      field329 = 0;
      field419 = 0;
      field472 = 0;
      field332 = false;
      field333 = 0;
      field334 = 1;
      field335 = 0;
      field336 = 1;
      field337 = 0;
      field338 = new class108[4];
      field339 = false;
      field498 = new int[4][13][13];
      field341 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field343 = 0;
      field457 = 2;
      field345 = 0;
      field496 = 2;
      field525 = 0;
      field348 = 1;
      field349 = 0;
      field350 = 0;
      field351 = 2;
      field352 = 0;
      field399 = 1;
      field434 = 0;
      field355 = 0;
      field357 = 2301979;
      field330 = 5063219;
      field475 = 3353893;
      field360 = 7759444;
      field361 = false;
      field362 = 0;
      field449 = 128;
      field368 = 0;
      field363 = 0;
      field366 = 0;
      field367 = 0;
      field319 = 0;
      field322 = 50;
      field296 = 0;
      field477 = false;
      field372 = 0;
      field373 = 0;
      field537 = 50;
      field356 = new int[field537];
      field376 = new int[field537];
      field405 = new int[field537];
      field378 = new int[field537];
      field395 = new int[field537];
      field380 = new int[field537];
      field381 = new int[field537];
      field344 = new String[field537];
      field369 = new int[104][104];
      field384 = 0;
      field300 = -1;
      field386 = -1;
      field421 = 0;
      field277 = 0;
      field389 = 0;
      field390 = 0;
      field436 = 0;
      field359 = 0;
      field393 = 0;
      field394 = 0;
      field375 = 0;
      field400 = 0;
      field397 = false;
      field524 = 0;
      field307 = 0;
      field387 = new class2[2048];
      field401 = -1;
      field402 = 0;
      field403 = 0;
      field404 = new int[1000];
      field353 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field406 = new String[8];
      field407 = new boolean[8];
      field408 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field409 = -1;
      field410 = new class199[4][104][104];
      field411 = new class199();
      field412 = new class199();
      field413 = new class199();
      field492 = new int[25];
      field415 = new int[25];
      field552 = new int[25];
      field417 = 0;
      field331 = false;
      field420 = 0;
      field494 = new int[500];
      field422 = new int[500];
      field301 = new int[500];
      field391 = new int[500];
      field425 = new String[500];
      field426 = new String[500];
      field511 = -1;
      field428 = -1;
      field370 = 0;
      field501 = 50;
      field431 = 0;
      field392 = null;
      field433 = false;
      field416 = -1;
      field435 = -1;
      field377 = null;
      field437 = null;
      field438 = -1;
      field439 = new class196(8);
      field440 = 0;
      field441 = 0;
      field442 = null;
      field443 = 0;
      field365 = 0;
      field482 = 0;
      field327 = -1;
      field447 = false;
      field448 = false;
      field539 = false;
      field510 = null;
      field451 = null;
      field452 = null;
      field453 = 0;
      field517 = 0;
      field455 = null;
      field509 = false;
      field527 = -1;
      field458 = -1;
      field459 = false;
      field460 = -1;
      field294 = -1;
      field462 = false;
      field463 = 1;
      field464 = new int[32];
      field557 = 0;
      field481 = new int[32];
      field467 = 0;
      field468 = new int[32];
      field469 = 0;
      field470 = 0;
      field471 = 0;
      field474 = 0;
      field473 = 0;
      field364 = 0;
      field546 = 0;
      field476 = 0;
      field466 = new class199();
      field478 = new class199();
      field479 = new class199();
      field480 = new class196(512);
      field465 = 0;
      field379 = -2;
      field483 = new boolean[100];
      field484 = new boolean[100];
      field414 = new boolean[100];
      field486 = new int[100];
      field487 = new int[100];
      field354 = new int[100];
      field489 = new int[100];
      field490 = 0;
      field491 = 0L;
      field398 = true;
      field493 = 765;
      field308 = 1;
      field278 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field518 = 0;
      field497 = 0;
      field495 = "";
      field340 = new long[100];
      field500 = 0;
      field520 = 0;
      field306 = new int[128];
      field503 = new int[128];
      field504 = -1L;
      field505 = null;
      field506 = null;
      field507 = -1;
      field508 = 0;
      field499 = new int[1000];
      field418 = new int[1000];
      field530 = new class78[1000];
      field432 = 0;
      field513 = 0;
      field514 = 0;
      field515 = 255;
      field516 = -1;
      field427 = false;
      field396 = 127;
      field519 = 127;
      field383 = 0;
      field521 = new int[50];
      field522 = new int[50];
      field523 = new int[50];
      field446 = new int[50];
      field444 = new class58[50];
      field313 = false;
      field388 = new boolean[5];
      field528 = new int[5];
      field529 = new int[5];
      field276 = new int[5];
      field531 = new int[5];
      field532 = 256;
      field533 = 205;
      field534 = 256;
      field535 = 320;
      field461 = 1;
      field456 = 32767;
      field538 = 1;
      field526 = 32767;
      field540 = 0;
      field541 = 0;
      field371 = 0;
      field543 = 0;
      field544 = 0;
      field545 = 0;
      field382 = 0;
      field547 = new class17[400];
      field548 = new class195();
      field549 = 0;
      field550 = new class7[400];
      field551 = new class179();
      field423 = -1;
      field553 = -1;
      field554 = new class220[8];
      field555 = -1L;
      field556 = -1L;
      field310 = new class10();
      field558 = new int[50];
      field559 = new int[50];
   }

   @ObfuscatedName("w")
   protected final void vmethod3025() {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-778548191"
   )
   void method263() {
      if(1000 != field287) {
         long var2 = class140.method2967();
         int var4 = (int)(var2 - class171.field2714);
         class171.field2714 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class171.field2713 += var4;
         boolean var1;
         if(class171.field2723 == 0 && 0 == class171.field2718 && class171.field2721 == 0 && 0 == class171.field2730) {
            var1 = true;
         } else if(null == class171.field2728) {
            var1 = false;
         } else {
            try {
               label244: {
                  if(class171.field2713 > 30000) {
                     throw new IOException();
                  }

                  class172 var5;
                  class119 var6;
                  while(class171.field2718 < 20 && class171.field2730 > 0) {
                     var5 = (class172)class171.field2715.method3794();
                     var6 = new class119(4);
                     var6.method2565(1);
                     var6.method2510((int)var5.field3115);
                     class171.field2728.method2983(var6.field1980, 0, 4);
                     class171.field2725.method3789(var5, var5.field3115);
                     --class171.field2730;
                     ++class171.field2718;
                  }

                  while(class171.field2723 < 20 && class171.field2721 > 0) {
                     var5 = (class172)class171.field2719.method3878();
                     var6 = new class119(4);
                     var6.method2565(0);
                     var6.method2510((int)var5.field3115);
                     class171.field2728.method2983(var6.field1980, 0, 4);
                     var5.method3891();
                     class171.field2712.method3789(var5, var5.field3115);
                     --class171.field2721;
                     ++class171.field2723;
                  }

                  for(int var20 = 0; var20 < 100; ++var20) {
                     int var21 = class171.field2728.method2985();
                     if(var21 < 0) {
                        throw new IOException();
                     }

                     if(var21 == 0) {
                        break;
                     }

                     class171.field2713 = 0;
                     byte var7 = 0;
                     if(class171.field2724 == null) {
                        var7 = 8;
                     } else if(0 == class171.field2726) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class171.field2727.field1976;
                        if(var8 > var21) {
                           var8 = var21;
                        }

                        class171.field2728.method2991(class171.field2727.field1980, class171.field2727.field1976, var8);
                        if(class171.field2733 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class171.field2727.field1980[var9 + class171.field2727.field1976] ^= class171.field2733;
                           }
                        }

                        class171.field2727.field1976 += var8;
                        if(class171.field2727.field1976 < var7) {
                           break;
                        }

                        if(class171.field2724 == null) {
                           class171.field2727.field1976 = 0;
                           var9 = class171.field2727.method2523();
                           var10 = class171.field2727.method2700();
                           int var11 = class171.field2727.method2523();
                           var12 = class171.field2727.method2528();
                           long var13 = (long)((var9 << 16) + var10);
                           class172 var15 = (class172)class171.field2725.method3788(var13);
                           class155.field2289 = true;
                           if(null == var15) {
                              var15 = (class172)class171.field2712.method3788(var13);
                              class155.field2289 = false;
                           }

                           if(null == var15) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class171.field2724 = var15;
                           class28.field667 = new class119(var12 + var16 + class171.field2724.field2739);
                           class28.field667.method2565(var11);
                           class28.field667.method2617(var12);
                           class171.field2726 = 8;
                           class171.field2727.field1976 = 0;
                        } else if(class171.field2726 == 0) {
                           if(-1 == class171.field2727.field1980[0]) {
                              class171.field2726 = 1;
                              class171.field2727.field1976 = 0;
                           } else {
                              class171.field2724 = null;
                           }
                        }
                     } else {
                        var8 = class28.field667.field1980.length - class171.field2724.field2739;
                        var9 = 512 - class171.field2726;
                        if(var9 > var8 - class28.field667.field1976) {
                           var9 = var8 - class28.field667.field1976;
                        }

                        if(var9 > var21) {
                           var9 = var21;
                        }

                        class171.field2728.method2991(class28.field667.field1980, class28.field667.field1976, var9);
                        if(class171.field2733 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class28.field667.field1980[var10 + class28.field667.field1976] ^= class171.field2733;
                           }
                        }

                        class28.field667.field1976 += var9;
                        class171.field2726 += var9;
                        if(class28.field667.field1976 == var8) {
                           if(16711935L == class171.field2724.field3115) {
                              class171.field2722 = class28.field667;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 class168 var22 = class171.field2729[var10];
                                 if(null != var22) {
                                    class171.field2722.field1976 = var10 * 8 + 5;
                                    var12 = class171.field2722.method2528();
                                    int var23 = class171.field2722.method2528();
                                    var22.method3340(var12, var23);
                                 }
                              }
                           } else {
                              class171.field2716.reset();
                              class171.field2716.update(class28.field667.field1980, 0, var8);
                              var10 = (int)class171.field2716.getValue();
                              if(class171.field2724.field2738 != var10) {
                                 try {
                                    class171.field2728.method2982();
                                 } catch (Exception var18) {
                                    ;
                                 }

                                 ++class171.field2731;
                                 class171.field2728 = null;
                                 class171.field2733 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label244;
                              }

                              class171.field2731 = 0;
                              class171.field2732 = 0;
                              class171.field2724.field2737.method3335((int)(class171.field2724.field3115 & 65535L), class28.field667.field1980, (class171.field2724.field3115 & 16711680L) == 16711680L, class155.field2289);
                           }

                           class171.field2724.method3913();
                           if(class155.field2289) {
                              --class171.field2718;
                           } else {
                              --class171.field2723;
                           }

                           class171.field2726 = 0;
                           class171.field2724 = null;
                           class28.field667 = null;
                        } else {
                           if(class171.field2726 != 512) {
                              break;
                           }

                           class171.field2726 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var19) {
               try {
                  class171.field2728.method2982();
               } catch (Exception var17) {
                  ;
               }

               ++class171.field2732;
               class171.field2728 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method357();
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-23224"
   )
   @Export("packetHandler")
   protected final void vmethod3019() {
      ++field289;
      this.method263();
      class87.method2095();
      class39.method786();
      class11.method155();
      class137 var1 = class137.field2104;
      synchronized(class137.field2104) {
         ++class137.field2114;
         class137.field2093 = class137.field2109;
         class137.field2119 = 0;
         int var2;
         if(class137.field2111 >= 0) {
            while(class137.field2111 != class137.field2116) {
               var2 = class137.field2099[class137.field2116];
               class137.field2116 = class137.field2116 + 1 & 127;
               if(var2 < 0) {
                  class137.field2103[~var2] = false;
               } else {
                  if(!class137.field2103[var2] && class137.field2119 < class137.field2102.length - 1) {
                     class137.field2102[++class137.field2119 - 1] = var2;
                  }

                  class137.field2103[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               class137.field2103[var2] = false;
            }

            class137.field2111 = class137.field2116;
         }

         class137.field2109 = class137.field2112;
      }

      class34.method725();
      int var5;
      if(class142.field2166 != null) {
         var5 = class142.field2166.vmethod3105();
         field476 = var5;
      }

      if(field287 == 0) {
         class16.method179();
         class4.field75.vmethod3115();

         for(var5 = 0; var5 < 32; ++var5) {
            class144.field2196[var5] = 0L;
         }

         for(var5 = 0; var5 < 32; ++var5) {
            class144.field2197[var5] = 0L;
         }

         class143.field2185 = 0;
      } else if(field287 == 5) {
         class56.method1225();
         class16.method179();
         class4.field75.vmethod3115();

         for(var5 = 0; var5 < 32; ++var5) {
            class144.field2196[var5] = 0L;
         }

         for(var5 = 0; var5 < 32; ++var5) {
            class144.field2197[var5] = 0L;
         }

         class143.field2185 = 0;
      } else if(field287 != 10 && 11 != field287) {
         if(field287 == 20) {
            class56.method1225();
            class99.method2214();
         } else if(25 == field287) {
            class16.method180();
         }
      } else {
         class56.method1225();
      }

      if(field287 == 30) {
         class77.method1683();
      } else if(field287 == 40 || field287 == 45) {
         class99.method2214();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1222001218"
   )
   void method357() {
      if(class171.field2731 >= 4) {
         this.method3099("js5crc");
         field287 = 1000;
      } else {
         if(class171.field2732 >= 4) {
            if(field287 <= 5) {
               this.method3099("js5io");
               field287 = 1000;
               return;
            }

            field385 = 3000;
            class171.field2732 = 3;
         }

         if(--field385 + 1 <= 0) {
            try {
               if(0 == field309) {
                  class36.field783 = class125.field2028.method2874(class101.field1732, class51.field1103);
                  ++field309;
               }

               if(field309 == 1) {
                  if(class36.field783.field2213 == 2) {
                     this.method236(-1);
                     return;
                  }

                  if(1 == class36.field783.field2213) {
                     ++field309;
                  }
               }

               if(field309 == 2) {
                  class82.field1405 = new class143((Socket)class36.field783.field2216, class125.field2028);
                  class119 var1 = new class119(5);
                  var1.method2565(15);
                  var1.method2617(111);
                  class82.field1405.method2983(var1.field1980, 0, 5);
                  ++field309;
                  class77.field1365 = class140.method2967();
               }

               if(field309 == 3) {
                  if(field287 > 5 && class82.field1405.method2985() <= 0) {
                     if(class140.method2967() - class77.field1365 > 30000L) {
                        this.method236(-2);
                        return;
                     }
                  } else {
                     int var9 = class82.field1405.method2984();
                     if(var9 != 0) {
                        this.method236(var9);
                        return;
                     }

                     ++field309;
                  }
               }

               if(4 == field309) {
                  class143 var10 = class82.field1405;
                  boolean var2 = field287 > 20;
                  if(null != class171.field2728) {
                     try {
                        class171.field2728.method2982();
                     } catch (Exception var7) {
                        ;
                     }

                     class171.field2728 = null;
                  }

                  class171.field2728 = var10;
                  class22.method585(var2);
                  class171.field2727.field1976 = 0;
                  class171.field2724 = null;
                  class28.field667 = null;
                  class171.field2726 = 0;

                  while(true) {
                     class172 var3 = (class172)class171.field2725.method3794();
                     if(var3 == null) {
                        while(true) {
                           var3 = (class172)class171.field2712.method3794();
                           if(var3 == null) {
                              if(class171.field2733 != 0) {
                                 try {
                                    class119 var11 = new class119(4);
                                    var11.method2565(4);
                                    var11.method2565(class171.field2733);
                                    var11.method2713(0);
                                    class171.field2728.method2983(var11.field1980, 0, 4);
                                 } catch (IOException var6) {
                                    try {
                                       class171.field2728.method2982();
                                    } catch (Exception var5) {
                                       ;
                                    }

                                    ++class171.field2732;
                                    class171.field2728 = null;
                                 }
                              }

                              class171.field2713 = 0;
                              class171.field2714 = class140.method2967();
                              class36.field783 = null;
                              class82.field1405 = null;
                              field309 = 0;
                              field311 = 0;
                              return;
                           }

                           class171.field2719.method3876(var3);
                           class171.field2720.method3789(var3, var3.field3115);
                           ++class171.field2721;
                           --class171.field2723;
                        }
                     }

                     class171.field2715.method3789(var3, var3.field3115);
                     ++class171.field2730;
                     --class171.field2718;
                  }
               }
            } catch (IOException var8) {
               this.method236(-3);
            }

         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   protected final void vmethod3075() {
      if(class125.field2027.method203()) {
         class125.field2027.method196();
      }

      if(class32.field728 != null) {
         class32.field728.field194 = false;
      }

      class32.field728 = null;
      if(null != class46.field1040) {
         class46.field1040.method2982();
         class46.field1040 = null;
      }

      class133.method2839();
      class36.method736();
      class142.field2166 = null;
      if(class221.field3179 != null) {
         class221.field3179.method1178();
      }

      if(null != class5.field94) {
         class5.field94.method1178();
      }

      if(null != class171.field2728) {
         class171.field2728.method2982();
      }

      Object var1 = class170.field2709;
      synchronized(class170.field2709) {
         if(0 != class170.field2707) {
            class170.field2707 = 1;

            try {
               class170.field2709.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      class37.method753();
   }

   @ObfuscatedName("dl")
   static final void method484(String var0, int var1) {
      field321.method2762(176);
      field321.method2565(class47.method982(var0) + 1);
      field321.method2555(var1);
      field321.method2514(var0);
   }

   public final void init() {
      if(this.method3007()) {
         class190[] var1 = class151.method3149();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class190 var3 = var1[var2];
            String var4 = this.getParameter(var3.field3063);
            if(var4 != null) {
               switch(Integer.parseInt(var3.field3063)) {
               case 1:
                  class10.field166 = Integer.parseInt(var4);
                  break;
               case 2:
                  int var6 = Integer.parseInt(var4);
                  class153[] var7 = class59.method1262();
                  int var8 = 0;

                  class153 var13;
                  while(true) {
                     if(var8 >= var7.length) {
                        var13 = null;
                        break;
                     }

                     class153 var9 = var7[var8];
                     if(var6 == var9.field2267) {
                        var13 = var9;
                        break;
                     }

                     ++var8;
                  }

                  field281 = var13;
                  break;
               case 3:
                  if(var4.equalsIgnoreCase("true")) {
                     field284 = true;
                  } else {
                     field284 = false;
                  }
                  break;
               case 4:
                  field286 = Integer.parseInt(var4);
                  break;
               case 5:
                  class0.field8 = var4;
                  break;
               case 6:
                  field280 = Integer.parseInt(var4);
               case 7:
               case 8:
               case 13:
               default:
                  break;
               case 9:
                  class107.field1860 = Integer.parseInt(var4);
                  break;
               case 10:
                  field282 = Integer.parseInt(var4);
                  break;
               case 11:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 12:
                  class142.field2165 = var4;
                  break;
               case 14:
                  class154[] var5 = new class154[]{class154.field2276, class154.field2274, class154.field2277, class154.field2275, class154.field2273, class154.field2272};
                  class164.field2657 = (class154)class35.method731(var5, Integer.parseInt(var4));
                  if(class154.field2277 == class164.field2657) {
                     field283 = class212.field3138;
                  } else {
                     field283 = class212.field3139;
                  }
                  break;
               case 15:
                  field279 = Integer.parseInt(var4);
               }
            }
         }

         class42.method881();
         class101.field1732 = this.getCodeBase().getHost();
         String var11 = field281.field2264;
         byte var12 = 0;

         try {
            class123.method2777("oldschool", var11, var12, 16);
         } catch (Exception var10) {
            class1.method16((String)null, var10);
         }

         field374 = this;
         this.method3066(765, 503, 111);
      }
   }
}
