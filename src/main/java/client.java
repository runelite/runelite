import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
public final class client extends class143 {
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 717061143
   )
   static int field283;
   @ObfuscatedName("l")
   static client field284;
   @ObfuscatedName("a")
   static boolean field285 = true;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1340762123
   )
   @Export("world")
   static int field286 = 1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1941286887
   )
   static int field287 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -861409755
   )
   static int field288 = 0;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -300498019
   )
   static int field289;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 497653333
   )
   static int field290 = 0;
   @ObfuscatedName("k")
   static boolean field291 = false;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 2017988837
   )
   static int field292;
   @ObfuscatedName("cd")
   static class121 field293;
   @ObfuscatedName("q")
   static String field294;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1285263801
   )
   @Export("gameState")
   static int field295 = 0;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 1815794433
   )
   static int field296;
   @ObfuscatedName("ja")
   static class172 field297;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 6219186742829385349L
   )
   static long field298 = 1L;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -791820881
   )
   static int field299 = -1;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 791373299
   )
   static int field300;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -1231690845
   )
   static int field301;
   @ObfuscatedName("ak")
   static boolean field302 = true;
   @ObfuscatedName("am")
   static boolean field303 = false;
   @ObfuscatedName("cf")
   static boolean field304;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 396782687
   )
   static int field305;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 988823881
   )
   static int field306 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1447489699
   )
   static int field307 = 0;
   @ObfuscatedName("hk")
   @Export("isMenuOpen")
   static boolean field308;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1634786639
   )
   static int field309 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1028733841
   )
   static int field310 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -844110161
   )
   static int field311 = 0;
   @ObfuscatedName("jo")
   static class172 field312;
   @ObfuscatedName("an")
   static class20 field313;
   @ObfuscatedName("jv")
   static boolean field314;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1595311433
   )
   static int field315;
   @ObfuscatedName("z")
   static boolean field316 = true;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -998858113
   )
   static int field317;
   @ObfuscatedName("lv")
   static int[] field318;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = -821745573
   )
   static int field319;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1752922435
   )
   static int field320;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -1558037953
   )
   static int field321;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1886484767
   )
   static int field322;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1839684447
   )
   static int field323;
   @ObfuscatedName("cx")
   @Export("cachedNPCs")
   static class34[] field324;
   @ObfuscatedName("hp")
   static final int[] field325;
   @ObfuscatedName("cg")
   static int[] field326;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1566637375
   )
   static int field327;
   @ObfuscatedName("cn")
   static int[] field328;
   @ObfuscatedName("cp")
   static class121 field329;
   @ObfuscatedName("co")
   static class121 field330;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1337130997
   )
   static int field331;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1345828173
   )
   static int field332;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 253004343
   )
   @Export("packetOpcode")
   static int field333;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -809122137
   )
   static int field334;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -1215768761
   )
   @Export("energy")
   static int field335;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 622643419
   )
   static int field336;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -1364588855
   )
   static int field337;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 880033893
   )
   static int field338;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 920574937
   )
   static int field339;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -795451025
   )
   static int field340;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 1701486941
   )
   static int field341;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 474597641
   )
   static int field342;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 1384522937
   )
   static int field343;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -791959
   )
   static int field344;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -2003983823
   )
   static int field345;
   @ObfuscatedName("w")
   @Export("collisionMaps")
   static class107[] field346;
   @ObfuscatedName("df")
   static boolean field347;
   @ObfuscatedName("hj")
   static boolean[] field348;
   @ObfuscatedName("dw")
   static final int[] field349;
   @ObfuscatedName("h")
   static class153 field350;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -131272455
   )
   static int field351 = 0;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1415632563
   )
   static int field352;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1102765801
   )
   static int field353;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 1558877889
   )
   static int field354;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -772526819
   )
   static int field355;
   @ObfuscatedName("fq")
   static int[] field356;
   @ObfuscatedName("at")
   static class20 field357;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 2003846363
   )
   static int field358;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 1082972379
   )
   static int field359;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1539416757
   )
   static int field360;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 483575333
   )
   static int field361;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 1058007097
   )
   static int field362;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 32238579
   )
   static int field363;
   @ObfuscatedName("eo")
   static class78[] field364;
   @ObfuscatedName("io")
   @Export("menuTargets")
   static String[] field365;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -257590125
   )
   static int field366;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 1662294599
   )
   static int field367;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -912017873
   )
   static int field368;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1277228683
   )
   static int field369;
   @ObfuscatedName("oi")
   static short field370;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 501115051
   )
   static int field371;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -1450275851
   )
   static int field372;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2119062099
   )
   static int field373 = -1;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -1793160455
   )
   @Export("mapAngle")
   static int field374;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 2123140593
   )
   static int field376;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 2119826945
   )
   static int field377;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1779217053
   )
   static int field378;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1592231723
   )
   static int field379;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 857924199
   )
   static int field380;
   @ObfuscatedName("fv")
   static boolean field381;
   @ObfuscatedName("lm")
   @Export("isResized")
   static boolean field382;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -875113099
   )
   static int field383;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -493203421
   )
   static int field384;
   @ObfuscatedName("mt")
   static int[] field385;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = -189823593
   )
   static int field386;
   @ObfuscatedName("fa")
   static int[] field387;
   @ObfuscatedName("fs")
   static int[] field388;
   @ObfuscatedName("fw")
   static int[] field389;
   @ObfuscatedName("fl")
   static int[] field390;
   @ObfuscatedName("ge")
   static int[] field391;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -1553817639
   )
   static int field392;
   @ObfuscatedName("gk")
   static int[][] field393;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1183949399
   )
   //@Export("currentPacketOpcode")
   @Export("gameCycle")
   static int field394 = 0;
   @ObfuscatedName("mq")
   static class78[] field395;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -1608938279
   )
   static int field396;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 247646449
   )
   static int field397;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 525012175
   )
   static int field398;
   @ObfuscatedName("ae")
   static class145 field399;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1889444595
   )
   static int field400;
   @ObfuscatedName("nt")
   static class58[] field401;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -290867315
   )
   static int field402;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1125618589
   )
   static int field403;
   @ObfuscatedName("om")
   static short field404;
   @ObfuscatedName("ew")
   static class78[] field405;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1338882407
   )
   static int field406;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -660600453
   )
   static int field407;
   @ObfuscatedName("it")
   static boolean field408;
   @ObfuscatedName("hz")
   static class198 field409;
   @ObfuscatedName("gb")
   @Export("cachedPlayers")
   static class2[] field410;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 1980978847
   )
   static int field411;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -885119437
   )
   static int field412;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -318229407
   )
   static int field413;
   @ObfuscatedName("hq")
   static int[] field414;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1526864063
   )
   static int field415;
   @ObfuscatedName("hr")
   static String[] field416;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 951139111
   )
   static int field417;
   @ObfuscatedName("he")
   static int[] field418;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 243081969
   )
   static int field419;
   @ObfuscatedName("hd")
   @Export("groundItemDeque")
   static class198[][][] field420;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -972304681
   )
   static int field421;
   @ObfuscatedName("hf")
   static class198 field422;
   @ObfuscatedName("hw")
   static class198 field423;
   @ObfuscatedName("hv")
   @Export("boostedSkillLevels")
   static int[] field424;
   @ObfuscatedName("hg")
   @Export("realSkillLevels")
   static int[] field425;
   @ObfuscatedName("hy")
   @Export("skillExperiences")
   static int[] field426;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -1862958195
   )
   static int field427;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -372565183
   )
   static int field428;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -141138207
   )
   static int field429;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 1597447929
   )
   @Export("menuOptionCount")
   static int field430;
   @ObfuscatedName("ht")
   static int[] field431;
   @ObfuscatedName("in")
   static int[] field432;
   @ObfuscatedName("ic")
   @Export("menuTypes")
   static int[] field433;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 232139393
   )
   static int field434;
   @ObfuscatedName("es")
   static boolean field435;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -2083029481
   )
   static int field436;
   @ObfuscatedName("il")
   @Export("menuOptions")
   static String[] field437;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2098033443
   )
   static int field438 = 0;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 2068956289
   )
   static int field439;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 1662560835
   )
   static int field440;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -1195224219
   )
   static int field441;
   @ObfuscatedName("ik")
   static String field442;
   @ObfuscatedName("np")
   static int[] field443;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 1766338671
   )
   static int field444;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1327649903
   )
   static int field445 = -1;
   @ObfuscatedName("ij")
   static String field446;
   @ObfuscatedName("iy")
   static String field447;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -1720752711
   )
   static int field448;
   @ObfuscatedName("id")
   @Export("componentTable")
   static class195 field449;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 1071093111
   )
   static int field450;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -1301710469
   )
   static int field451;
   @ObfuscatedName("jg")
   static class172 field452;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 1003685155
   )
   static int field453;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -1874130963
   )
   @Export("weight")
   static int field454;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = 1419156049
   )
   static int field455;
   @ObfuscatedName("la")
   @Export("widgetPositionY")
   static int[] field456;
   @ObfuscatedName("r")
   static boolean field457 = false;
   @ObfuscatedName("jb")
   static boolean field458;
   @ObfuscatedName("jn")
   static boolean field459;
   @ObfuscatedName("js")
   static class172 field460;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      longValue = 3047368536506426237L
   )
   static long field461;
   @ObfuscatedName("op")
   static short field462;
   @ObfuscatedName("ks")
   static int[] field463;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1348294597
   )
   static int field464;
   @ObfuscatedName("kc")
   static class198 field465;
   @ObfuscatedName("jj")
   static boolean field466;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 1894048321
   )
   static int field467;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 330677351
   )
   static int field468;
   @ObfuscatedName("jk")
   static boolean field469;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 462925995
   )
   static int field470;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -1919951081
   )
   static int field471;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1226623571
   )
   static int field472 = 0;
   @ObfuscatedName("n")
   static class211 field473;
   @ObfuscatedName("ko")
   static int[] field474;
   @ObfuscatedName("pe")
   static class178 field475;
   @ObfuscatedName("ky")
   static int[] field476;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 164889619
   )
   static int field477;
   @ObfuscatedName("ft")
   static int[] field478;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 994562869
   )
   static int field479;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -636585831
   )
   static int field480;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 1730665127
   )
   static int field481;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 586124363
   )
   static int field482;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -1199004491
   )
   static int field483;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1444838793
   )
   static int field484;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = 902448423
   )
   static int field485;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1405247817
   )
   static int field486;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 1750639481
   )
   @Export("scale")
   static int field487;
   @ObfuscatedName("ka")
   static class198 field488;
   @ObfuscatedName("kb")
   static class198 field489;
   @ObfuscatedName("kw")
   static class195 field490;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = -1138596957
   )
   static int field491;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 2124303713
   )
   static int field492;
   @ObfuscatedName("lx")
   static boolean[] field493;
   @ObfuscatedName("ef")
   static class78 field494;
   @ObfuscatedName("lj")
   static boolean[] field495;
   @ObfuscatedName("lf")
   @Export("widgetPositionX")
   static int[] field496;
   @ObfuscatedName("lq")
   static boolean[] field497;
   @ObfuscatedName("lh")
   static int[] field498;
   @ObfuscatedName("ld")
   static int[] field499;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 677410541
   )
   static int field500;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      longValue = -9176570608794692237L
   )
   static long field501;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 2087967571
   )
   static int field502;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 1601604175
   )
   static int field503;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 2106090863
   )
   static int field504;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 504434805
   )
   static int field505;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -739543421
   )
   static int field506;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -1200277391
   )
   static int field507;
   @ObfuscatedName("lt")
   static String field508;
   @ObfuscatedName("ly")
   static long[] field509;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -1580021679
   )
   static int field510;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = -1769746281
   )
   static int field511;
   @ObfuscatedName("my")
   static int[] field512;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -956314613
   )
   static int field513;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      longValue = -4319780829265630049L
   )
   static long field514;
   @ObfuscatedName("mn")
   static String field515;
   @ObfuscatedName("mf")
   static String field516;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 580290663
   )
   static int field517;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = -1028584731
   )
   static int field518;
   @ObfuscatedName("ml")
   static int[] field519;
   @ObfuscatedName("jt")
   static boolean field520;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -738116447
   )
   static int field521;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 269522371
   )
   @Export("mapScale")
   static int field522;
   @ObfuscatedName("im")
   @Export("menuIdentifiers")
   static int[] field523;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -1438079901
   )
   static int field524;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 449854225
   )
   static int field525;
   @ObfuscatedName("db")
   static int[][][] field526;
   @ObfuscatedName("mj")
   static boolean field527;
   @ObfuscatedName("nn")
   static boolean field528;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1958236625
   )
   static int field529;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 51452497
   )
   static int field530;
   @ObfuscatedName("nx")
   static int[] field531;
   @ObfuscatedName("ne")
   static int[] field532;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1205525629
   )
   static int field533;
   @ObfuscatedName("na")
   static int[] field534;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -2097883185
   )
   static int field535;
   @ObfuscatedName("jp")
   static class172 field536;
   @ObfuscatedName("ot")
   static boolean[] field537;
   @ObfuscatedName("oa")
   static int[] field538;
   @ObfuscatedName("oe")
   static int[] field539;
   @ObfuscatedName("ox")
   static int[] field540;
   @ObfuscatedName("oh")
   static int[] field541;
   @ObfuscatedName("go")
   static boolean field543;
   @ObfuscatedName("os")
   static short field544;
   @ObfuscatedName("ol")
   static short field545;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -1524534757
   )
   static int field546;
   @ObfuscatedName("or")
   static short field547;
   @ObfuscatedName("ou")
   static short field548;
   @ObfuscatedName("ob")
   static short field549;
   @ObfuscatedName("gh")
   static String[] field550;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 407028637
   )
   static int field551;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -586720657
   )
   @Export("camera2")
   static int field552;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -115979353
   )
   @Export("camera3")
   static int field553;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1194742283
   )
   static int field554;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 1405075031
   )
   static int field555;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1734781257
   )
   @Export("cameraPitch")
   static int field556;
   @ObfuscatedName("of")
   @Export("friends")
   static class17[] field557;
   @ObfuscatedName("oo")
   static class194 field558;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 880397537
   )
   static int field559;
   @ObfuscatedName("oj")
   @Export("ignores")
   static class7[] field560;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 630818085
   )
   static int field561;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = 1978725153
   )
   static int field562;
   @ObfuscatedName("md")
   static int[] field563;
   @ObfuscatedName("pn")
   @Export("grandExchangeOffers")
   static class219[] field564;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -436466415
   )
   static int field565 = 0;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      longValue = 1667923327796446961L
   )
   static long field566;
   @ObfuscatedName("pw")
   static final class10 field567;
   @ObfuscatedName("pm")
   static int[] field568;
   @ObfuscatedName("pq")
   static int[] field569;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -475903217
   )
   static int field570;
   @ObfuscatedName("mo")
   static byte field571;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1597283035
   )
   static int field572;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 439875143
   )
   static int field573;
   @ObfuscatedName("qt")
   protected static Frame field574;

   @ObfuscatedName("i")
   protected final void vmethod2963() {
   }

   public final void init() {
      if(this.method2959()) {
         class189[] var1 = new class189[]{class189.field3051, class189.field3053, class189.field3060, class189.field3048, class189.field3055, class189.field3059, class189.field3057, class189.field3056, class189.field3050, class189.field3054, class189.field3063, class189.field3052, class189.field3061, class189.field3058, class189.field3049};
         class189[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            class189 var4 = var2[var3];
            String var5 = this.getParameter(var4.field3062);
            if(var5 != null) {
               switch(Integer.parseInt(var4.field3062)) {
               case 1:
                  class24.field624 = Integer.parseInt(var5);
                  break;
               case 2:
                  if(var5.equalsIgnoreCase("true")) {
                     field291 = true;
                  } else {
                     field291 = false;
                  }
                  break;
               case 3:
                  field288 = Integer.parseInt(var5);
                  break;
               case 4:
                  field286 = Integer.parseInt(var5);
                  break;
               case 5:
                  class95.field1639 = var5;
                  break;
               case 6:
                  int var7 = Integer.parseInt(var5);
                  class152[] var8 = class147.method3084();
                  int var9 = 0;

                  class152 var14;
                  while(true) {
                     if(var9 >= var8.length) {
                        var14 = null;
                        break;
                     }

                     class152 var10 = var8[var9];
                     if(var10.field2288 == var7) {
                        var14 = var10;
                        break;
                     }

                     ++var9;
                  }

                  class160.field2648 = var14;
                  break;
               case 7:
                  class164.field2669 = Integer.parseInt(var5);
               case 8:
               case 11:
               case 13:
               default:
                  break;
               case 9:
                  field294 = var5;
                  break;
               case 10:
                  field472 = Integer.parseInt(var5);
                  break;
               case 12:
                  field287 = Integer.parseInt(var5);
                  break;
               case 14:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 15:
                  class153[] var6 = new class153[]{class153.field2291, class153.field2289, class153.field2293, class153.field2296, class153.field2292, class153.field2294};
                  field350 = (class153)class150.method3104(var6, Integer.parseInt(var5));
                  if(field350 == class153.field2294) {
                     field473 = class211.field3135;
                  } else {
                     field473 = class211.field3128;
                  }
               }
            }
         }

         class4.method36();
         class141.field2179 = this.getCodeBase().getHost();
         String var12 = class160.field2648.field2286;
         byte var13 = 0;

         try {
            class125.method2748("oldschool", var12, var13, 16);
         } catch (Exception var11) {
            class16.method184((String)null, var11);
         }

         field284 = this;
         this.method2957(765, 503, 108);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1876223875"
   )
   protected final void vmethod2967() {
      class215.field3152 = 0 == field288?'ꩊ':field286 + '鱀';
      class6.field111 = 0 == field288?443:'썐' + field286;
      field572 = class215.field3152;
      class178.field2919 = class173.field2895;
      class133.field2079 = class173.field2894;
      class178.field2920 = class173.field2898;
      class52.field1173 = class173.field2896;
      class11.method147();
      Canvas var1 = class125.field2039;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class136.field2113);
      var1.addFocusListener(class136.field2113);
      Canvas var2 = class125.field2039;
      var2.addMouseListener(class139.field2164);
      var2.addMouseMotionListener(class139.field2164);
      var2.addFocusListener(class139.field2164);

      class144 var3;
      try {
         var3 = new class144();
      } catch (Throwable var11) {
         var3 = null;
      }

      class185.field2998 = var3;
      if(class185.field2998 != null) {
         class185.field2998.vmethod3060(class125.field2039);
      }

      class123.field2034 = new class133(255, class148.field2243, class148.field2240, 500000);
      class226 var5 = null;
      class8 var6 = new class8();

      try {
         var5 = class0.method1("", field350.field2295, false);
         byte[] var7 = new byte[(int)var5.method4067()];

         int var9;
         for(int var8 = 0; var8 < var7.length; var8 += var9) {
            var9 = var5.method4068(var7, var8, var7.length - var8);
            if(var9 == -1) {
               throw new IOException();
            }
         }

         var6 = new class8(new class118(var7));
      } catch (Exception var12) {
         ;
      }

      try {
         if(var5 != null) {
            var5.method4069();
         }
      } catch (Exception var10) {
         ;
      }

      class10.field169 = var6;
      class8.field146 = this.getToolkit().getSystemClipboard();
      class107.method2369(this, class34.field773);
      if(0 != field288) {
         field303 = true;
      }

      int var13 = class10.field169.field144;
      field501 = 0L;
      if(var13 >= 2) {
         field382 = true;
      } else {
         field382 = false;
      }

      class41.method860();
      if(field295 >= 25) {
         field329.method2686(179);
         field329.method2438(class97.method2167());
         field329.method2541(class142.field2190);
         field329.method2541(class89.field1566);
      }

      class143.field2210 = true;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2111904229"
   )
   @Export("packetHandler")
   protected final void vmethod2968() {
      ++field394;
      this.method385();

      while(true) {
         class198 var2 = class169.field2717;
         class168 var1;
         synchronized(class169.field2717) {
            var1 = (class168)class169.field2720.method3771();
         }

         if(var1 == null) {
            class102.method2253();
            class38.method764();
            class30.method664();
            class139 var55 = class139.field2164;
            synchronized(class139.field2164) {
               class139.field2161 = class139.field2158;
               class139.field2162 = class139.field2157;
               class139.field2171 = class139.field2160;
               class139.field2168 = class139.field2159;
               class139.field2169 = class139.field2165;
               class139.field2163 = class139.field2166;
               class139.field2156 = class139.field2167;
               class139.field2159 = 0;
            }

            int var56;
            if(class185.field2998 != null) {
               var56 = class185.field2998.vmethod3058();
               field486 = var56;
            }

            int var4;
            int var5;
            boolean var8;
            int var10;
            int var11;
            int var12;
            int var14;
            int var15;
            int var16;
            int var17;
            int var58;
            int var59;
            int var66;
            int var68;
            int var74;
            int var76;
            int var88;
            if(0 == field295) {
               class149.method3103();
               class5.method80();
            } else if(field295 == 5) {
               class7.method98();
               class149.method3103();
               class5.method80();
            } else if(10 != field295 && 11 != field295) {
               if(field295 == 20) {
                  class7.method98();
                  class136.method2870();
               } else if(25 == field295) {
                  class2.method14(false);
                  field372 = 0;
                  boolean var57 = true;

                  for(var58 = 0; var58 < class22.field599.length; ++var58) {
                     if(-1 != class12.field192[var58] && null == class22.field599[var58]) {
                        class22.field599[var58] = class24.field623.method3214(class12.field192[var58], 0);
                        if(null == class22.field599[var58]) {
                           var57 = false;
                           ++field372;
                        }
                     }

                     if(class94.field1626[var58] != -1 && class162.field2656[var58] == null) {
                        class162.field2656[var58] = class24.field623.method3215(class94.field1626[var58], 0, class135.field2100[var58]);
                        if(null == class162.field2656[var58]) {
                           var57 = false;
                           ++field372;
                        }
                     }
                  }

                  if(!var57) {
                     field345 = 1;
                  } else {
                     field343 = 0;
                     var57 = true;

                     class118 var9;
                     int var18;
                     int var19;
                     for(var58 = 0; var58 < class22.field599.length; ++var58) {
                        byte[] var3 = class162.field2656[var58];
                        if(var3 != null) {
                           var4 = 64 * (class29.field678[var58] >> 8) - class98.field1683;
                           var5 = (class29.field678[var58] & 255) * 64 - class92.field1598;
                           if(field347) {
                              var4 = 10;
                              var5 = 10;
                           }

                           var8 = true;
                           var9 = new class118(var3);
                           var10 = -1;

                           label4425:
                           while(true) {
                              var11 = var9.method2466();
                              if(var11 == 0) {
                                 var57 &= var8;
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;
                              boolean var13 = false;

                              while(true) {
                                 while(!var13) {
                                    var14 = var9.method2466();
                                    if(0 == var14) {
                                       continue label4425;
                                    }

                                    var12 += var14 - 1;
                                    var15 = var12 & 63;
                                    var16 = var12 >> 6 & 63;
                                    var17 = var9.method2453() >> 2;
                                    var18 = var16 + var4;
                                    var19 = var15 + var5;
                                    if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                       class40 var20 = class48.method996(var10);
                                       if(var17 != 22 || !field457 || var20.field936 != 0 || var20.field934 == 1 || var20.field955) {
                                          if(!var20.method803()) {
                                             ++field343;
                                             var8 = false;
                                          }

                                          var13 = true;
                                       }
                                    }
                                 }

                                 var14 = var9.method2466();
                                 if(var14 == 0) {
                                    break;
                                 }

                                 var9.method2453();
                              }
                           }
                        }
                     }

                     if(!var57) {
                        field345 = 2;
                     } else {
                        if(0 != field345) {
                           class10.method128("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class38.method764();
                        class18.method191();
                        class38.method764();
                        class107.field1906.method1875();
                        class38.method764();
                        System.gc();

                        for(var58 = 0; var58 < 4; ++var58) {
                           field346[var58].method2341();
                        }

                        for(var58 = 0; var58 < 4; ++var58) {
                           for(var59 = 0; var59 < 104; ++var59) {
                              for(var4 = 0; var4 < 104; ++var4) {
                                 class5.field81[var58][var59][var4] = 0;
                              }
                           }
                        }

                        class38.method764();
                        class5.field82 = 99;
                        class5.field90 = new byte[4][104][104];
                        class114.field1972 = new byte[4][104][104];
                        class5.field84 = new byte[4][104][104];
                        class5.field85 = new byte[4][104][104];
                        class75.field1383 = new int[4][105][105];
                        class5.field97 = new byte[4][105][105];
                        class50.field1103 = new int[105][105];
                        class18.field264 = new int[104];
                        class114.field1974 = new int[104];
                        class5.field86 = new int[104];
                        class5.field87 = new int[104];
                        class171.field2744 = new int[104];
                        var58 = class22.field599.length;

                        for(class23 var60 = (class23)class23.field615.method3773(); var60 != null; var60 = (class23)class23.field615.method3772()) {
                           if(var60.field604 != null) {
                              class17.field252.method1137(var60.field604);
                              var60.field604 = null;
                           }

                           if(var60.field606 != null) {
                              class17.field252.method1137(var60.field606);
                              var60.field606 = null;
                           }
                        }

                        class23.field615.method3767();
                        class2.method14(true);
                        int var21;
                        int var22;
                        int var133;
                        if(!field347) {
                           byte[] var6;
                           for(var59 = 0; var59 < var58; ++var59) {
                              var4 = (class29.field678[var59] >> 8) * 64 - class98.field1683;
                              var5 = (class29.field678[var59] & 255) * 64 - class92.field1598;
                              var6 = class22.field599[var59];
                              if(var6 != null) {
                                 class38.method764();
                                 class118.method2646(var6, var4, var5, class130.field2065 * 8 - 48, class105.field1878 * 8 - 48, field346);
                              }
                           }

                           for(var59 = 0; var59 < var58; ++var59) {
                              var4 = 64 * (class29.field678[var59] >> 8) - class98.field1683;
                              var5 = 64 * (class29.field678[var59] & 255) - class92.field1598;
                              var6 = class22.field599[var59];
                              if(null == var6 && class105.field1878 < 800) {
                                 class38.method764();
                                 class3.method33(var4, var5, 64, 64);
                              }
                           }

                           class2.method14(true);

                           for(var59 = 0; var59 < var58; ++var59) {
                              byte[] var64 = class162.field2656[var59];
                              if(null != var64) {
                                 var5 = 64 * (class29.field678[var59] >> 8) - class98.field1683;
                                 var66 = 64 * (class29.field678[var59] & 255) - class92.field1598;
                                 class38.method764();
                                 class85 var7 = class107.field1906;
                                 class107[] var72 = field346;
                                 var9 = new class118(var64);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var9.method2466();
                                    if(0 == var11) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var88 = var9.method2466();
                                       if(var88 == 0) {
                                          break;
                                       }

                                       var12 += var88 - 1;
                                       var14 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       var17 = var9.method2453();
                                       var18 = var17 >> 2;
                                       var19 = var17 & 3;
                                       var133 = var15 + var5;
                                       var21 = var14 + var66;
                                       if(var133 > 0 && var21 > 0 && var133 < 103 && var21 < 103) {
                                          var22 = var16;
                                          if(2 == (class5.field81[1][var133][var21] & 2)) {
                                             var22 = var16 - 1;
                                          }

                                          class107 var23 = null;
                                          if(var22 >= 0) {
                                             var23 = var72[var22];
                                          }

                                          class121.method2706(var16, var133, var21, var10, var19, var18, var7, var23);
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        int var24;
                        int var25;
                        int var26;
                        int var27;
                        int var28;
                        int var29;
                        int var30;
                        int var32;
                        int var33;
                        int var34;
                        int var143;
                        if(field347) {
                           var59 = 0;

                           label4324:
                           while(true) {
                              if(var59 >= 4) {
                                 for(var59 = 0; var59 < 13; ++var59) {
                                    for(var4 = 0; var4 < 13; ++var4) {
                                       var5 = field526[0][var59][var4];
                                       if(var5 == -1) {
                                          class3.method33(var59 * 8, 8 * var4, 8, 8);
                                       }
                                    }
                                 }

                                 class2.method14(true);
                                 var59 = 0;

                                 while(true) {
                                    if(var59 >= 4) {
                                       break label4324;
                                    }

                                    class38.method764();

                                    for(var4 = 0; var4 < 13; ++var4) {
                                       label4247:
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var66 = field526[var59][var4][var5];
                                          if(-1 != var66) {
                                             var68 = var66 >> 24 & 3;
                                             var74 = var66 >> 1 & 3;
                                             var76 = var66 >> 14 & 1023;
                                             var10 = var66 >> 3 & 2047;
                                             var11 = (var76 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < class29.field678.length; ++var12) {
                                                if(var11 == class29.field678[var12] && class162.field2656[var12] != null) {
                                                   byte[] var94 = class162.field2656[var12];
                                                   var14 = var4 * 8;
                                                   var15 = var5 * 8;
                                                   var16 = 8 * (var76 & 7);
                                                   var17 = (var10 & 7) * 8;
                                                   class85 var120 = class107.field1906;
                                                   class107[] var128 = field346;
                                                   class118 var135 = new class118(var94);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var135.method2466();
                                                      if(var22 == 0) {
                                                         continue label4247;
                                                      }

                                                      var21 += var22;
                                                      var143 = 0;

                                                      while(true) {
                                                         var24 = var135.method2466();
                                                         if(0 == var24) {
                                                            break;
                                                         }

                                                         var143 += var24 - 1;
                                                         var25 = var143 & 63;
                                                         var26 = var143 >> 6 & 63;
                                                         var27 = var143 >> 12;
                                                         var28 = var135.method2453();
                                                         var29 = var28 >> 2;
                                                         var30 = var28 & 3;
                                                         if(var68 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < 8 + var17) {
                                                            class40 var31 = class48.method996(var21);
                                                            var32 = var14 + class18.method189(var26 & 7, var25 & 7, var74, var31.field932, var31.field933, var30);
                                                            var33 = var15 + class29.method662(var26 & 7, var25 & 7, var74, var31.field932, var31.field933, var30);
                                                            if(var32 > 0 && var33 > 0 && var32 < 103 && var33 < 103) {
                                                               var34 = var59;
                                                               if((class5.field81[1][var32][var33] & 2) == 2) {
                                                                  var34 = var59 - 1;
                                                               }

                                                               class107 var35 = null;
                                                               if(var34 >= 0) {
                                                                  var35 = var128[var34];
                                                               }

                                                               class121.method2706(var59, var32, var33, var21, var30 + var74 & 3, var29, var120, var35);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var59;
                                 }
                              }

                              class38.method764();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var67 = false;
                                    var68 = field526[var59][var4][var5];
                                    if(-1 != var68) {
                                       var74 = var68 >> 24 & 3;
                                       var76 = var68 >> 1 & 3;
                                       var10 = var68 >> 14 & 1023;
                                       var11 = var68 >> 3 & 2047;
                                       var12 = var11 / 8 + (var10 / 8 << 8);

                                       for(var88 = 0; var88 < class29.field678.length; ++var88) {
                                          if(class29.field678[var88] == var12 && null != class22.field599[var88]) {
                                             class5.method79(class22.field599[var88], var59, var4 * 8, 8 * var5, var74, 8 * (var10 & 7), (var11 & 7) * 8, var76, field346);
                                             var67 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var67) {
                                       var74 = var59;
                                       var76 = 8 * var4;
                                       var10 = 8 * var5;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class5.field93[var74][var11 + var76][var10 + var12] = 0;
                                          }
                                       }

                                       if(var76 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.field93[var74][var76][var10 + var11] = class5.field93[var74][var76 - 1][var11 + var10];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class5.field93[var74][var11 + var76][var10] = class5.field93[var74][var11 + var76][var10 - 1];
                                          }
                                       }

                                       if(var76 > 0 && class5.field93[var74][var76 - 1][var10] != 0) {
                                          class5.field93[var74][var76][var10] = class5.field93[var74][var76 - 1][var10];
                                       } else if(var10 > 0 && 0 != class5.field93[var74][var76][var10 - 1]) {
                                          class5.field93[var74][var76][var10] = class5.field93[var74][var76][var10 - 1];
                                       } else if(var76 > 0 && var10 > 0 && class5.field93[var74][var76 - 1][var10 - 1] != 0) {
                                          class5.field93[var74][var76][var10] = class5.field93[var74][var76 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var59;
                           }
                        }

                        class2.method14(true);
                        class18.method191();
                        class38.method764();
                        class85 var70 = class107.field1906;
                        class107[] var71 = field346;

                        for(var5 = 0; var5 < 4; ++var5) {
                           for(var66 = 0; var66 < 104; ++var66) {
                              for(var68 = 0; var68 < 104; ++var68) {
                                 if((class5.field81[var5][var66][var68] & 1) == 1) {
                                    var74 = var5;
                                    if(2 == (class5.field81[1][var66][var68] & 2)) {
                                       var74 = var5 - 1;
                                    }

                                    if(var74 >= 0) {
                                       var71[var74].method2344(var66, var68);
                                    }
                                 }
                              }
                           }
                        }

                        class5.field94 += (int)(Math.random() * 5.0D) - 2;
                        if(class5.field94 < -8) {
                           class5.field94 = -8;
                        }

                        if(class5.field94 > 8) {
                           class5.field94 = 8;
                        }

                        class5.field83 += (int)(Math.random() * 5.0D) - 2;
                        if(class5.field83 < -16) {
                           class5.field83 = -16;
                        }

                        if(class5.field83 > 16) {
                           class5.field83 = 16;
                        }

                        for(var5 = 0; var5 < 4; ++var5) {
                           byte[][] var75 = class5.field97[var5];
                           var12 = (int)Math.sqrt(5100.0D);
                           var88 = var12 * 768 >> 8;

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var16 = class5.field93[var5][var15 + 1][var14] - class5.field93[var5][var15 - 1][var14];
                                 var17 = class5.field93[var5][var15][1 + var14] - class5.field93[var5][var15][var14 - 1];
                                 var18 = (int)Math.sqrt((double)(var17 * var17 + 65536 + var16 * var16));
                                 var19 = (var16 << 8) / var18;
                                 var133 = 65536 / var18;
                                 var21 = (var17 << 8) / var18;
                                 var22 = (-50 * var21 + -50 * var19 + -10 * var133) / var88 + 96;
                                 var143 = (var75[var15][var14 + 1] >> 3) + (var75[var15][var14 - 1] >> 2) + (var75[var15 - 1][var14] >> 2) + (var75[1 + var15][var14] >> 3) + (var75[var15][var14] >> 1);
                                 class50.field1103[var15][var14] = var22 - var143;
                              }
                           }

                           for(var14 = 0; var14 < 104; ++var14) {
                              class18.field264[var14] = 0;
                              class114.field1974[var14] = 0;
                              class5.field86[var14] = 0;
                              class5.field87[var14] = 0;
                              class171.field2744[var14] = 0;
                           }

                           for(var14 = -5; var14 < 109; ++var14) {
                              for(var15 = 0; var15 < 104; ++var15) {
                                 var16 = 5 + var14;
                                 if(var16 >= 0 && var16 < 104) {
                                    var17 = class5.field90[var5][var16][var15] & 255;
                                    if(var17 > 0) {
                                       class41 var125 = class32.method721(var17 - 1);
                                       class18.field264[var15] += var125.field971;
                                       class114.field1974[var15] += var125.field968;
                                       class5.field86[var15] += var125.field969;
                                       class5.field87[var15] += var125.field972;
                                       ++class171.field2744[var15];
                                    }
                                 }

                                 var17 = var14 - 5;
                                 if(var17 >= 0 && var17 < 104) {
                                    var18 = class5.field90[var5][var17][var15] & 255;
                                    if(var18 > 0) {
                                       class41 var134 = class32.method721(var18 - 1);
                                       class18.field264[var15] -= var134.field971;
                                       class114.field1974[var15] -= var134.field968;
                                       class5.field86[var15] -= var134.field969;
                                       class5.field87[var15] -= var134.field972;
                                       --class171.field2744[var15];
                                    }
                                 }
                              }

                              if(var14 >= 1 && var14 < 103) {
                                 var15 = 0;
                                 var16 = 0;
                                 var17 = 0;
                                 var18 = 0;
                                 var19 = 0;

                                 for(var133 = -5; var133 < 109; ++var133) {
                                    var21 = 5 + var133;
                                    if(var21 >= 0 && var21 < 104) {
                                       var15 += class18.field264[var21];
                                       var16 += class114.field1974[var21];
                                       var17 += class5.field86[var21];
                                       var18 += class5.field87[var21];
                                       var19 += class171.field2744[var21];
                                    }

                                    var22 = var133 - 5;
                                    if(var22 >= 0 && var22 < 104) {
                                       var15 -= class18.field264[var22];
                                       var16 -= class114.field1974[var22];
                                       var17 -= class5.field86[var22];
                                       var18 -= class5.field87[var22];
                                       var19 -= class171.field2744[var22];
                                    }

                                    if(var133 >= 1 && var133 < 103 && (!field457 || (class5.field81[0][var14][var133] & 2) != 0 || 0 == (class5.field81[var5][var14][var133] & 16))) {
                                       if(var5 < class5.field82) {
                                          class5.field82 = var5;
                                       }

                                       var143 = class5.field90[var5][var14][var133] & 255;
                                       var24 = class114.field1972[var5][var14][var133] & 255;
                                       if(var143 > 0 || var24 > 0) {
                                          var25 = class5.field93[var5][var14][var133];
                                          var26 = class5.field93[var5][var14 + 1][var133];
                                          var27 = class5.field93[var5][1 + var14][var133 + 1];
                                          var28 = class5.field93[var5][var14][1 + var133];
                                          var29 = class50.field1103[var14][var133];
                                          var30 = class50.field1103[var14 + 1][var133];
                                          int var152 = class50.field1103[1 + var14][1 + var133];
                                          var32 = class50.field1103[var14][1 + var133];
                                          var33 = -1;
                                          var34 = -1;
                                          int var36;
                                          int var37;
                                          int var157;
                                          if(var143 > 0) {
                                             var157 = var15 * 256 / var18;
                                             var36 = var16 / var19;
                                             var37 = var17 / var19;
                                             var33 = class75.method1612(var157, var36, var37);
                                             var157 = class5.field94 + var157 & 255;
                                             var37 += class5.field83;
                                             if(var37 < 0) {
                                                var37 = 0;
                                             } else if(var37 > 255) {
                                                var37 = 255;
                                             }

                                             var34 = class75.method1612(var157, var36, var37);
                                          }

                                          class46 var38;
                                          if(var5 > 0) {
                                             boolean var159 = true;
                                             if(var143 == 0 && 0 != class5.field84[var5][var14][var133]) {
                                                var159 = false;
                                             }

                                             if(var24 > 0) {
                                                var37 = var24 - 1;
                                                var38 = (class46)class46.field1054.method3711((long)var37);
                                                class46 var158;
                                                if(null != var38) {
                                                   var158 = var38;
                                                } else {
                                                   byte[] var39 = class46.field1058.method3214(4, var37);
                                                   var38 = new class46();
                                                   if(var39 != null) {
                                                      var38.method954(new class118(var39));
                                                   }

                                                   var38.method953();
                                                   class46.field1054.method3713(var38, (long)var37);
                                                   var158 = var38;
                                                }

                                                if(!var158.field1052) {
                                                   var159 = false;
                                                }
                                             }

                                             if(var159 && var25 == var26 && var25 == var27 && var25 == var28) {
                                                class75.field1383[var5][var14][var133] |= 2340;
                                             }
                                          }

                                          var157 = 0;
                                          if(var34 != -1) {
                                             var157 = class90.field1586[class20.method563(var34, 96)];
                                          }

                                          if(0 == var24) {
                                             var70.method1880(var5, var14, var133, 0, 0, -1, var25, var26, var27, var28, class20.method563(var33, var29), class20.method563(var33, var30), class20.method563(var33, var152), class20.method563(var33, var32), 0, 0, 0, 0, var157, 0);
                                          } else {
                                             var36 = 1 + class5.field84[var5][var14][var133];
                                             byte var163 = class5.field85[var5][var14][var133];
                                             int var164 = var24 - 1;
                                             class46 var40 = (class46)class46.field1054.method3711((long)var164);
                                             if(null != var40) {
                                                var38 = var40;
                                             } else {
                                                byte[] var41 = class46.field1058.method3214(4, var164);
                                                var40 = new class46();
                                                if(null != var41) {
                                                   var40.method954(new class118(var41));
                                                }

                                                var40.method953();
                                                class46.field1054.method3713(var40, (long)var164);
                                                var38 = var40;
                                             }

                                             int var166 = var38.field1053;
                                             int var42;
                                             int var43;
                                             int var44;
                                             int var45;
                                             if(var166 >= 0) {
                                                var43 = class90.field1576.vmethod2157(var166);
                                                var42 = -1;
                                             } else if(16711935 == var38.field1051) {
                                                var42 = -2;
                                                var166 = -1;
                                                var43 = -2;
                                             } else {
                                                var42 = class75.method1612(var38.field1056, var38.field1057, var38.field1050);
                                                var44 = class5.field94 + var38.field1056 & 255;
                                                var45 = var38.field1050 + class5.field83;
                                                if(var45 < 0) {
                                                   var45 = 0;
                                                } else if(var45 > 255) {
                                                   var45 = 255;
                                                }

                                                var43 = class75.method1612(var44, var38.field1057, var45);
                                             }

                                             var44 = 0;
                                             if(-2 != var43) {
                                                var44 = class90.field1586[class14.method161(var43, 96)];
                                             }

                                             if(-1 != var38.field1055) {
                                                var45 = class5.field94 + var38.field1059 & 255;
                                                int var46 = class5.field83 + var38.field1061;
                                                if(var46 < 0) {
                                                   var46 = 0;
                                                } else if(var46 > 255) {
                                                   var46 = 255;
                                                }

                                                var43 = class75.method1612(var45, var38.field1060, var46);
                                                var44 = class90.field1586[class14.method161(var43, 96)];
                                             }

                                             var70.method1880(var5, var14, var133, var36, var163, var166, var25, var26, var27, var28, class20.method563(var33, var29), class20.method563(var33, var30), class20.method563(var33, var152), class20.method563(var33, var32), class14.method161(var42, var29), class14.method161(var42, var30), class14.method161(var42, var152), class14.method161(var42, var32), var157, var44);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var70.method2012(var5, var15, var14, class86.method2049(var5, var15, var14));
                              }
                           }

                           class5.field90[var5] = (byte[][])null;
                           class114.field1972[var5] = (byte[][])null;
                           class5.field84[var5] = (byte[][])null;
                           class5.field85[var5] = (byte[][])null;
                           class5.field97[var5] = (byte[][])null;
                        }

                        var70.method1906(-50, -10, -50);

                        for(var5 = 0; var5 < 104; ++var5) {
                           for(var66 = 0; var66 < 104; ++var66) {
                              if((class5.field81[1][var5][var66] & 2) == 2) {
                                 var70.method1877(var5, var66);
                              }
                           }
                        }

                        var5 = 1;
                        var66 = 2;
                        var68 = 4;

                        for(var74 = 0; var74 < 4; ++var74) {
                           if(var74 > 0) {
                              var5 <<= 3;
                              var66 <<= 3;
                              var68 <<= 3;
                           }

                           for(var76 = 0; var76 <= var74; ++var76) {
                              for(var10 = 0; var10 <= 104; ++var10) {
                                 for(var11 = 0; var11 <= 104; ++var11) {
                                    short var137;
                                    if((class75.field1383[var76][var11][var10] & var5) != 0) {
                                       var12 = var10;
                                       var88 = var10;
                                       var14 = var76;

                                       for(var15 = var76; var12 > 0 && 0 != (class75.field1383[var76][var11][var12 - 1] & var5); --var12) {
                                          ;
                                       }

                                       while(var88 < 104 && (class75.field1383[var76][var11][1 + var88] & var5) != 0) {
                                          ++var88;
                                       }

                                       label3973:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var88; ++var16) {
                                             if(0 == (class75.field1383[var14 - 1][var11][var16] & var5)) {
                                                break label3973;
                                             }
                                          }

                                          --var14;
                                       }

                                       label3962:
                                       while(var15 < var74) {
                                          for(var16 = var12; var16 <= var88; ++var16) {
                                             if(0 == (class75.field1383[1 + var15][var11][var16] & var5)) {
                                                break label3962;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var15 + 1 - var14) * (var88 - var12 + 1);
                                       if(var16 >= 8) {
                                          var137 = 240;
                                          var18 = class5.field93[var15][var11][var12] - var137;
                                          var19 = class5.field93[var14][var11][var12];
                                          class85.method1878(var74, 1, 128 * var11, 128 * var11, 128 * var12, 128 + 128 * var88, var18, var19);

                                          for(var133 = var14; var133 <= var15; ++var133) {
                                             for(var21 = var12; var21 <= var88; ++var21) {
                                                class75.field1383[var133][var11][var21] &= ~var5;
                                             }
                                          }
                                       }
                                    }

                                    if((class75.field1383[var76][var11][var10] & var66) != 0) {
                                       var12 = var11;
                                       var88 = var11;
                                       var14 = var76;

                                       for(var15 = var76; var12 > 0 && (class75.field1383[var76][var12 - 1][var10] & var66) != 0; --var12) {
                                          ;
                                       }

                                       while(var88 < 104 && (class75.field1383[var76][var88 + 1][var10] & var66) != 0) {
                                          ++var88;
                                       }

                                       label4026:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var88; ++var16) {
                                             if((class75.field1383[var14 - 1][var16][var10] & var66) == 0) {
                                                break label4026;
                                             }
                                          }

                                          --var14;
                                       }

                                       label4015:
                                       while(var15 < var74) {
                                          for(var16 = var12; var16 <= var88; ++var16) {
                                             if(0 == (class75.field1383[var15 + 1][var16][var10] & var66)) {
                                                break label4015;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (1 + (var88 - var12)) * (1 + var15 - var14);
                                       if(var16 >= 8) {
                                          var137 = 240;
                                          var18 = class5.field93[var15][var12][var10] - var137;
                                          var19 = class5.field93[var14][var12][var10];
                                          class85.method1878(var74, 2, 128 * var12, 128 + 128 * var88, var10 * 128, 128 * var10, var18, var19);

                                          for(var133 = var14; var133 <= var15; ++var133) {
                                             for(var21 = var12; var21 <= var88; ++var21) {
                                                class75.field1383[var133][var21][var10] &= ~var66;
                                             }
                                          }
                                       }
                                    }

                                    if(0 != (class75.field1383[var76][var11][var10] & var68)) {
                                       var12 = var11;
                                       var88 = var11;
                                       var14 = var10;

                                       for(var15 = var10; var14 > 0 && (class75.field1383[var76][var11][var14 - 1] & var68) != 0; --var14) {
                                          ;
                                       }

                                       while(var15 < 104 && 0 != (class75.field1383[var76][var11][1 + var15] & var68)) {
                                          ++var15;
                                       }

                                       label4079:
                                       while(var12 > 0) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if((class75.field1383[var76][var12 - 1][var16] & var68) == 0) {
                                                break label4079;
                                             }
                                          }

                                          --var12;
                                       }

                                       label4068:
                                       while(var88 < 104) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if(0 == (class75.field1383[var76][var88 + 1][var16] & var68)) {
                                                break label4068;
                                             }
                                          }

                                          ++var88;
                                       }

                                       if((var15 - var14 + 1) * (var88 - var12 + 1) >= 4) {
                                          var16 = class5.field93[var76][var12][var14];
                                          class85.method1878(var74, 4, var12 * 128, 128 + 128 * var88, var14 * 128, var15 * 128 + 128, var16, var16);

                                          for(var17 = var12; var17 <= var88; ++var17) {
                                             for(var18 = var14; var18 <= var15; ++var18) {
                                                class75.field1383[var76][var17][var18] &= ~var68;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        class2.method14(true);
                        var5 = class5.field82;
                        if(var5 > class75.field1386) {
                           var5 = class75.field1386;
                        }

                        if(var5 < class75.field1386 - 1) {
                           var5 = class75.field1386 - 1;
                        }

                        if(field457) {
                           class107.field1906.method1924(class5.field82);
                        } else {
                           class107.field1906.method1924(0);
                        }

                        for(var66 = 0; var66 < 104; ++var66) {
                           for(var68 = 0; var68 < 104; ++var68) {
                              class107.method2366(var66, var68);
                           }
                        }

                        class38.method764();
                        class121.method2707();
                        class40.field957.method3720();
                        if(null != field574) {
                           field329.method2686(121);
                           field329.method2441(1057001181);
                        }

                        if(!field347) {
                           var66 = (class130.field2065 - 6) / 8;
                           var68 = (class130.field2065 + 6) / 8;
                           var74 = (class105.field1878 - 6) / 8;
                           var76 = (6 + class105.field1878) / 8;

                           for(var10 = var66 - 1; var10 <= var68 + 1; ++var10) {
                              for(var11 = var74 - 1; var11 <= 1 + var76; ++var11) {
                                 if(var10 < var66 || var10 > var68 || var11 < var74 || var11 > var76) {
                                    class24.field623.method3234("m" + var10 + "_" + var11);
                                    class24.field623.method3234("l" + var10 + "_" + var11);
                                 }
                              }
                           }
                        }

                        method556(30);
                        class38.method764();
                        class47.method981();
                        field329.method2686(55);
                        class5.method80();
                     }
                  }
               }
            } else {
               class7.method98();
            }

            if(30 == field295) {
               if(field290 > 1) {
                  --field290;
               }

               if(field339 > 0) {
                  --field339;
               }

               if(field304) {
                  field304 = false;
                  class21.method570();
               } else {
                  if(!field308) {
                     field437[0] = "Cancel";
                     field365[0] = "";
                     field433[0] = 1006;
                     field430 = 1;
                  }

                  String var73;
                  long var98;
                  class172 var136;
                  for(var56 = 0; var56 < 100; ++var56) {
                     boolean var63;
                     if(null == class209.field3115) {
                        var63 = false;
                     } else {
                        label4675: {
                           try {
                              var59 = class209.field3115.method2940();
                              if(0 == var59) {
                                 var63 = false;
                                 break label4675;
                              }

                              if(field333 == -1) {
                                 class209.field3115.method2931(field293.field1995, 0, 1);
                                 field293.field1998 = 0;
                                 field333 = field293.method2687();
                                 field332 = class187.field3044[field333];
                                 --var59;
                              }

                              if(-1 == field332) {
                                 if(var59 <= 0) {
                                    var63 = false;
                                    break label4675;
                                 }

                                 class209.field3115.method2931(field293.field1995, 0, 1);
                                 field332 = field293.field1995[0] & 255;
                                 --var59;
                              }

                              if(field332 == -2) {
                                 if(var59 <= 1) {
                                    var63 = false;
                                    break label4675;
                                 }

                                 class209.field3115.method2931(field293.field1995, 0, 2);
                                 field293.field1998 = 0;
                                 field332 = field293.method2455();
                                 var59 -= 2;
                              }

                              if(var59 < field332) {
                                 var63 = false;
                                 break label4675;
                              }

                              field293.field1998 = 0;
                              class209.field3115.method2931(field293.field1995, 0, field332);
                              field334 = 0;
                              field554 = field546;
                              field546 = field336 * -1;
                              field336 = field333 * -1;
                              if(109 == field333) {
                                 var4 = field293.method2455();
                                 if('\uffff' == var4) {
                                    var4 = -1;
                                 }

                                 class18.method190(var4);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 135) {
                                 var4 = field293.method2493();
                                 var5 = field293.method2487();
                                 if('\uffff' == var5) {
                                    var5 = -1;
                                 }

                                 if(field525 != 0 && var5 != -1) {
                                    class108.method2379(class97.field1669, var5, 0, field525, false);
                                    field527 = true;
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(114 == field333) {
                                 for(var4 = 0; var4 < field410.length; ++var4) {
                                    if(field410[var4] != null) {
                                       field410[var4].field820 = -1;
                                    }
                                 }

                                 for(var4 = 0; var4 < field324.length; ++var4) {
                                    if(field324[var4] != null) {
                                       field324[var4].field820 = -1;
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              String var92;
                              if(field333 == 237) {
                                 var4 = field293.method2486();
                                 var5 = field293.method2453();
                                 var92 = field293.method2461();
                                 if(var5 >= 1 && var5 <= 8) {
                                    if(var92.equalsIgnoreCase("null")) {
                                       var92 = null;
                                    }

                                    field416[var5 - 1] = var92;
                                    field348[var5 - 1] = var4 == 0;
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              class3 var89;
                              class172 var126;
                              if(field333 == 161) {
                                 var4 = field293.method2458();
                                 var5 = field293.method2539();
                                 class3 var150 = (class3)field449.method3744((long)var4);
                                 var89 = (class3)field449.method3744((long)var5);
                                 if(null != var89) {
                                    class4.method39(var89, null == var150 || var89.field66 != var150.field66);
                                 }

                                 if(var150 != null) {
                                    var150.method3853();
                                    field449.method3746(var150, (long)var5);
                                 }

                                 var126 = class31.method698(var4);
                                 if(var126 != null) {
                                    class114.method2400(var126);
                                 }

                                 var126 = class31.method698(var5);
                                 if(null != var126) {
                                    class114.method2400(var126);
                                    class13.method154(class172.field2757[var126.field2759 * -1 >>> 16], var126, true);
                                 }

                                 if(-1 != field448) {
                                    class18.method192(field448, 1);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 144) {
                                 var4 = field293.method2487();
                                 var5 = field293.method2539();
                                 class175.field2904[var4] = var5;
                                 if(var5 != class175.field2906[var4]) {
                                    class175.field2906[var4] = var5;
                                 }

                                 class129.method2758(var4);
                                 field474[++field340 - 1 & 31] = var4;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 89) {
                                 class95.method2164();

                                 for(var4 = 0; var4 < 2048; ++var4) {
                                    field410[var4] = null;
                                 }

                                 class11.method145(field293);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(221 == field333) {
                                 var4 = field293.method2453();
                                 if(field293.method2453() == 0) {
                                    field564[var4] = new class219();
                                    field293.field1998 += 18;
                                 } else {
                                    --field293.field1998;
                                    field564[var4] = new class219(field293, false);
                                 }

                                 field483 = field392;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(177 == field333) {
                                 field506 = field293.method2453();
                                 field507 = field293.method2453();
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(129 == field333) {
                                 class13.field199 = field293.method2453();
                                 class32.field761 = field293.method2453();

                                 for(var4 = class13.field199; var4 < 8 + class13.field199; ++var4) {
                                    for(var5 = class32.field761; var5 < class32.field761 + 8; ++var5) {
                                       if(field420[class75.field1386][var4][var5] != null) {
                                          field420[class75.field1386][var4][var5] = null;
                                          class107.method2366(var4, var5);
                                       }
                                    }
                                 }

                                 for(class16 var146 = (class16)field409.method3773(); null != var146; var146 = (class16)field409.method3772()) {
                                    if(var146.field230 >= class13.field199 && var146.field230 < 8 + class13.field199 && var146.field235 >= class32.field761 && var146.field235 < 8 + class32.field761 && var146.field242 == class75.field1386) {
                                       var146.field244 = 0;
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 106) {
                                 for(var4 = 0; var4 < class52.field1166; ++var4) {
                                    class52 var151 = class7.method97(var4);
                                    if(var151 != null) {
                                       class175.field2904[var4] = 0;
                                       class175.field2906[var4] = 0;
                                    }
                                 }

                                 class83.method1864();
                                 field340 += 32;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 207) {
                                 field290 = field293.method2455() * 30;
                                 field363 = field392;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              boolean var115;
                              if(153 == field333) {
                                 var115 = field293.method2453() == 1;
                                 if(var115) {
                                    class4.field79 = class109.method2381() - field293.method2632();
                                    class32.field760 = new class220(field293, true);
                                 } else {
                                    class32.field760 = null;
                                 }

                                 field484 = field392;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              class172 var87;
                              if(field333 == 209) {
                                 var4 = field293.method2487();
                                 var5 = field293.method2509();
                                 var87 = class31.method698(var5);
                                 if(2 != var87.field2800 || var87.field2857 != var4) {
                                    var87.field2800 = 2;
                                    var87.field2857 = var4;
                                    class114.method2400(var87);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 140) {
                                 var4 = field293.method2481();
                                 var5 = field293.method2509();
                                 var66 = field293.method2487();
                                 var89 = (class3)field449.method3744((long)var5);
                                 if(var89 != null) {
                                    class4.method39(var89, var89.field66 != var66);
                                 }

                                 method460(var5, var66, var4);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(104 == field333) {
                                 var4 = field293.method2539();
                                 var136 = class31.method698(var4);

                                 for(var66 = 0; var66 < var136.field2875.length; ++var66) {
                                    var136.field2875[var66] = -1;
                                    var136.field2875[var66] = 0;
                                 }

                                 class114.method2400(var136);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(187 == field333) {
                                 var4 = field293.method2488();
                                 var5 = field293.method2497();
                                 var66 = var4 >> 10 & 31;
                                 var68 = var4 >> 5 & 31;
                                 var74 = var4 & 31;
                                 var76 = (var74 << 3) + (var68 << 11) + (var66 << 19);
                                 class172 var124 = class31.method698(var5);
                                 if(var124.field2859 != var76) {
                                    var124.field2859 = var76;
                                    class114.method2400(var124);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              class172 var132;
                              if(23 == field333) {
                                 var4 = field293.method2558();
                                 var5 = field293.method2458();
                                 var66 = field293.method2499();
                                 var132 = class31.method698(var5);
                                 if(var66 != var132.field2768 || var4 != var132.field2769 || 0 != var132.field2764 || var132.field2866 != 0) {
                                    var132.field2768 = var66;
                                    var132.field2769 = var4;
                                    var132.field2764 = 0;
                                    var132.field2866 = 0;
                                    class114.method2400(var132);
                                    class84.method1869(var132);
                                    if(var132.field2849 == 0) {
                                       class13.method154(class172.field2757[var5 >> 16], var132, false);
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(92 == field333) {
                                 var4 = field293.method2458();
                                 var5 = field293.method2455();
                                 if(var4 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var4 >= 0) {
                                    var87 = class31.method698(var4);
                                 } else {
                                    var87 = null;
                                 }

                                 if(null != var87) {
                                    for(var68 = 0; var68 < var87.field2875.length; ++var68) {
                                       var87.field2875[var68] = 0;
                                       var87.field2876[var68] = 0;
                                    }
                                 }

                                 class15 var142 = (class15)class15.field225.method3744((long)var5);
                                 if(null != var142) {
                                    for(var74 = 0; var74 < var142.field223.length; ++var74) {
                                       var142.field223[var74] = -1;
                                       var142.field229[var74] = 0;
                                    }
                                 }

                                 var68 = field293.method2455();

                                 for(var74 = 0; var74 < var68; ++var74) {
                                    var76 = field293.method2571();
                                    if(255 == var76) {
                                       var76 = field293.method2458();
                                    }

                                    var10 = field293.method2489();
                                    if(var87 != null && var74 < var87.field2875.length) {
                                       var87.field2875[var74] = var10;
                                       var87.field2876[var74] = var76;
                                    }

                                    class7.method95(var5, var74, var10 - 1, var76);
                                 }

                                 if(null != var87) {
                                    class114.method2400(var87);
                                 }

                                 class83.method1864();
                                 field476[++field411 - 1 & 31] = var5 & 32767;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 32) {
                                 field296 = field293.method2453();
                                 if(255 == field296) {
                                    field296 = 0;
                                 }

                                 field319 = field293.method2453();
                                 if(255 == field319) {
                                    field319 = 0;
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 165) {
                                 class83.method1864();
                                 field454 = field293.method2558();
                                 field363 = field392;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(65 == field333) {
                                 field386 = 1;
                                 field481 = field392;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 94) {
                                 class27.method649(true);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(110 == field333) {
                                 var4 = field293.method2458();
                                 class3 var148 = (class3)field449.method3744((long)var4);
                                 if(null != var148) {
                                    class4.method39(var148, true);
                                 }

                                 if(field452 != null) {
                                    class114.method2400(field452);
                                    field452 = null;
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(191 == field333) {
                                 var4 = field293.method2487();
                                 byte var147 = field293.method2576();
                                 class175.field2904[var4] = var147;
                                 if(var147 != class175.field2906[var4]) {
                                    class175.field2906[var4] = var147;
                                 }

                                 class129.method2758(var4);
                                 field474[++field340 - 1 & 31] = var4;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              long var78;
                              long var114;
                              if(113 == field333) {
                                 var73 = field293.method2461();
                                 var98 = (long)field293.method2455();
                                 var78 = (long)field293.method2553();
                                 class151 var118 = (class151)class150.method3104(class175.method3414(), field293.method2453());
                                 var114 = (var98 << 32) + var78;
                                 boolean var129 = false;

                                 for(var88 = 0; var88 < 100; ++var88) {
                                    if(var114 == field509[var88]) {
                                       var129 = true;
                                       break;
                                    }
                                 }

                                 if(class18.method194(var73)) {
                                    var129 = true;
                                 }

                                 if(!var129 && 0 == field471) {
                                    field509[field510] = var114;
                                    field510 = (field510 + 1) % 100;
                                    String var130 = class222.method3966(class190.method3705(class215.method3889(field293)));
                                    byte var141;
                                    if(var118.field2277) {
                                       var141 = 7;
                                    } else {
                                       var141 = 3;
                                    }

                                    if(var118.field2276 != -1) {
                                       var17 = var118.field2276;
                                       String var145 = "<img=" + var17 + ">";
                                       class16.method186(var141, var145 + var73, var130);
                                    } else {
                                       class16.method186(var141, var73, var130);
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(235 == field333) {
                                 var4 = field293.method2489();
                                 var5 = field293.method2509();
                                 var66 = field293.method2489();
                                 var132 = class31.method698(var5);
                                 var132.field2813 = var66 + (var4 << 16);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 96) {
                                 var4 = field293.method2455();
                                 var5 = field293.method2489();
                                 var66 = field293.method2487();
                                 var68 = field293.method2497();
                                 var126 = class31.method698(var68);
                                 if(var4 != var126.field2808 || var126.field2809 != var66 || var126.field2818 != var5) {
                                    var126.field2808 = var4;
                                    var126.field2809 = var66;
                                    var126.field2818 = var5;
                                    class114.method2400(var126);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              boolean var108;
                              long var109;
                              if(field333 == 174) {
                                 field482 = field392;
                                 if(field332 == 0) {
                                    field515 = null;
                                    field516 = null;
                                    class10.field163 = 0;
                                    class135.field2103 = null;
                                    field333 = -1;
                                    var63 = true;
                                    break label4675;
                                 }

                                 field516 = field293.method2461();
                                 long var138 = field293.method2632();
                                 var78 = var138;
                                 if(var138 > 0L && var138 < 6582952005840035281L) {
                                    if(var138 % 37L == 0L) {
                                       var92 = null;
                                    } else {
                                       var76 = 0;

                                       for(var114 = var138; 0L != var114; var114 /= 37L) {
                                          ++var76;
                                       }

                                       StringBuilder var123 = new StringBuilder(var76);

                                       while(0L != var78) {
                                          var109 = var78;
                                          var78 /= 37L;
                                          var123.append(class161.field2655[(int)(var109 - var78 * 37L)]);
                                       }

                                       var92 = var123.reverse().toString();
                                    }
                                 } else {
                                    var92 = null;
                                 }

                                 field515 = var92;
                                 field571 = field293.method2454();
                                 var76 = field293.method2453();
                                 if(var76 == 255) {
                                    field333 = -1;
                                    var63 = true;
                                    break label4675;
                                 }

                                 class10.field163 = var76;
                                 class24[] var119 = new class24[100];

                                 for(var11 = 0; var11 < class10.field163; ++var11) {
                                    var119[var11] = new class24();
                                    var119[var11].field626 = field293.method2461();
                                    var119[var11].field621 = class134.method2803(var119[var11].field626, field473);
                                    var119[var11].field620 = field293.method2455();
                                    var119[var11].field622 = field293.method2454();
                                    field293.method2461();
                                    if(var119[var11].field626.equals(class148.field2249.field48)) {
                                       class161.field2653 = var119[var11].field622;
                                    }
                                 }

                                 var108 = false;
                                 var88 = class10.field163;

                                 while(var88 > 0) {
                                    var108 = true;
                                    --var88;

                                    for(var14 = 0; var14 < var88; ++var14) {
                                       if(var119[var14].field621.compareTo(var119[1 + var14].field621) > 0) {
                                          class24 var127 = var119[var14];
                                          var119[var14] = var119[var14 + 1];
                                          var119[var14 + 1] = var127;
                                          var108 = false;
                                       }
                                    }

                                    if(var108) {
                                       break;
                                    }
                                 }

                                 class135.field2103 = var119;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(38 == field333) {
                                 field351 = field293.method2453();
                                 if(field351 == 1) {
                                    field306 = field293.method2455();
                                 }

                                 if(field351 >= 2 && field351 <= 6) {
                                    if(2 == field351) {
                                       field311 = 64;
                                       field565 = 64;
                                    }

                                    if(field351 == 3) {
                                       field311 = 0;
                                       field565 = 64;
                                    }

                                    if(4 == field351) {
                                       field311 = 128;
                                       field565 = 64;
                                    }

                                    if(field351 == 5) {
                                       field311 = 64;
                                       field565 = 0;
                                    }

                                    if(6 == field351) {
                                       field311 = 64;
                                       field565 = 128;
                                    }

                                    field351 = 2;
                                    field438 = field293.method2455();
                                    field309 = field293.method2455();
                                    field310 = field293.method2453();
                                 }

                                 if(10 == field351) {
                                    field307 = field293.method2455();
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(90 == field333) {
                                 var4 = field293.method2455();
                                 var5 = field293.method2453();
                                 var66 = field293.method2455();
                                 class38.method761(var4, var5, var66);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 251) {
                                 var4 = field293.method2453();
                                 var5 = field293.method2453();
                                 var66 = field293.method2453();
                                 var68 = field293.method2453();
                                 field537[var4] = true;
                                 field538[var4] = var5;
                                 field539[var4] = var66;
                                 field540[var4] = var68;
                                 field541[var4] = 0;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(213 == field333) {
                                 class51.field1143 = class36.method748(field293.method2453());
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              boolean var102;
                              if(field333 == 88) {
                                 var4 = field293.method2458();
                                 var102 = field293.method2486() == 1;
                                 var87 = class31.method698(var4);
                                 if(var102 != var87.field2794) {
                                    var87.field2794 = var102;
                                    class114.method2400(var87);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(155 == field333) {
                                 var4 = field293.method2458();
                                 var5 = field293.method2455();
                                 if(var4 < -70000) {
                                    var5 += '耀';
                                 }

                                 if(var4 >= 0) {
                                    var87 = class31.method698(var4);
                                 } else {
                                    var87 = null;
                                 }

                                 for(; field293.field1998 < field332; class7.method95(var5, var68, var74 - 1, var76)) {
                                    var68 = field293.method2466();
                                    var74 = field293.method2455();
                                    var76 = 0;
                                    if(var74 != 0) {
                                       var76 = field293.method2453();
                                       if(var76 == 255) {
                                          var76 = field293.method2458();
                                       }
                                    }

                                    if(null != var87 && var68 >= 0 && var68 < var87.field2875.length) {
                                       var87.field2875[var68] = var74;
                                       var87.field2876[var68] = var76;
                                    }
                                 }

                                 if(var87 != null) {
                                    class114.method2400(var87);
                                 }

                                 class83.method1864();
                                 field476[++field411 - 1 & 31] = var5 & 32767;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              long var80;
                              if(35 == field333) {
                                 var4 = field293.method2497();
                                 var5 = field293.method2489();
                                 if('\uffff' == var5) {
                                    var5 = -1;
                                 }

                                 var66 = field293.method2455();
                                 if(var66 == '\uffff') {
                                    var66 = -1;
                                 }

                                 var68 = field293.method2509();

                                 for(var74 = var5; var74 <= var66; ++var74) {
                                    var80 = ((long)var68 << 32) + (long)var74;
                                    class207 var110 = field490.method3744(var80);
                                    if(var110 != null) {
                                       var110.method3853();
                                    }

                                    field490.method3746(new class200(var4), var80);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(198 == field333) {
                                 class27.method649(false);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(149 == field333) {
                                 var4 = field293.method2458();
                                 class226.field3208 = class26.field648.method2810(var4);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 12) {
                                 var4 = field293.method2458();
                                 var5 = field293.method2458();
                                 var66 = field293.method2487();
                                 if('\uffff' == var66) {
                                    var66 = -1;
                                 }

                                 var132 = class31.method698(var5);
                                 class51 var116;
                                 if(!var132.field2758) {
                                    if(var66 == -1) {
                                       var132.field2800 = 0;
                                       field333 = -1;
                                       var63 = true;
                                       break label4675;
                                    }

                                    var116 = class22.method581(var66);
                                    var132.field2800 = 4;
                                    var132.field2857 = var66;
                                    var132.field2808 = var116.field1127;
                                    var132.field2809 = var116.field1128;
                                    var132.field2818 = var116.field1126 * 100 / var4;
                                    class114.method2400(var132);
                                 } else {
                                    var132.field2877 = var66;
                                    var132.field2878 = var4;
                                    var116 = class22.method581(var66);
                                    var132.field2808 = var116.field1127;
                                    var132.field2809 = var116.field1128;
                                    var132.field2810 = var116.field1142;
                                    var132.field2770 = var116.field1130;
                                    var132.field2839 = var116.field1163;
                                    var132.field2818 = var116.field1126;
                                    if(1 == var116.field1134) {
                                       var132.field2815 = 1;
                                    } else {
                                       var132.field2815 = 2;
                                    }

                                    if(var132.field2812 > 0) {
                                       var132.field2818 = var132.field2818 * 32 / var132.field2812;
                                    } else if(var132.field2781 > 0) {
                                       var132.field2818 = var132.field2818 * 32 / var132.field2781;
                                    }

                                    class114.method2400(var132);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              boolean var79;
                              String var121;
                              boolean var131;
                              if(146 == field333) {
                                 while(field293.field1998 < field332) {
                                    var115 = field293.method2453() == 1;
                                    var121 = field293.method2461();
                                    var92 = field293.method2461();
                                    var68 = field293.method2455();
                                    var74 = field293.method2453();
                                    var76 = field293.method2453();
                                    boolean var107 = (var76 & 2) != 0;
                                    var108 = 0 != (var76 & 1);
                                    if(var68 > 0) {
                                       field293.method2461();
                                       field293.method2453();
                                       field293.method2458();
                                    }

                                    field293.method2461();

                                    for(var12 = 0; var12 < field421; ++var12) {
                                       class17 var117 = field557[var12];
                                       if(!var115) {
                                          if(var121.equals(var117.field253)) {
                                             if(var117.field248 != var68) {
                                                var131 = true;

                                                for(class38 var140 = (class38)field558.method3740(); var140 != null; var140 = (class38)field558.method3736()) {
                                                   if(var140.field875.equals(var121)) {
                                                      if(var68 != 0 && var140.field871 == 0) {
                                                         var140.method3850();
                                                         var131 = false;
                                                      } else if(var68 == 0 && var140.field871 != 0) {
                                                         var140.method3850();
                                                         var131 = false;
                                                      }
                                                   }
                                                }

                                                if(var131) {
                                                   field558.method3734(new class38(var121, var68));
                                                }

                                                var117.field248 = var68;
                                             }

                                             var117.field247 = var92;
                                             var117.field249 = var74;
                                             var117.field246 = var107;
                                             var117.field251 = var108;
                                             var121 = null;
                                             break;
                                          }
                                       } else if(var92.equals(var117.field253)) {
                                          var117.field253 = var121;
                                          var117.field247 = var92;
                                          var121 = null;
                                          break;
                                       }
                                    }

                                    if(null != var121 && field421 < 400) {
                                       class17 var122 = new class17();
                                       field557[field421] = var122;
                                       var122.field253 = var121;
                                       var122.field247 = var92;
                                       var122.field248 = var68;
                                       var122.field249 = var74;
                                       var122.field246 = var107;
                                       var122.field251 = var108;
                                       ++field421;
                                    }
                                 }

                                 field386 = 2;
                                 field481 = field392;
                                 var115 = false;
                                 var5 = field421;

                                 while(var5 > 0) {
                                    var115 = true;
                                    --var5;

                                    for(var66 = 0; var66 < var5; ++var66) {
                                       var79 = false;
                                       class17 var112 = field557[var66];
                                       class17 var96 = field557[var66 + 1];
                                       if(var112.field248 != field286 && var96.field248 == field286) {
                                          var79 = true;
                                       }

                                       if(!var79 && var112.field248 == 0 && var96.field248 != 0) {
                                          var79 = true;
                                       }

                                       if(!var79 && !var112.field246 && var96.field246) {
                                          var79 = true;
                                       }

                                       if(!var79 && !var112.field251 && var96.field251) {
                                          var79 = true;
                                       }

                                       if(var79) {
                                          class17 var111 = field557[var66];
                                          field557[var66] = field557[var66 + 1];
                                          field557[var66 + 1] = var111;
                                          var115 = false;
                                       }
                                    }

                                    if(var115) {
                                       break;
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 190) {
                                 var4 = field293.method2539();
                                 var5 = field293.method2487();
                                 var87 = class31.method698(var4);
                                 if(var87.field2800 != 1 || var87.field2857 != var5) {
                                    var87.field2800 = 1;
                                    var87.field2857 = var5;
                                    class114.method2400(var87);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 230) {
                                 var4 = field293.method2509();
                                 var136 = class31.method698(var4);
                                 var136.field2800 = 3;
                                 var136.field2857 = class148.field2249.field34.method3445();
                                 class114.method2400(var136);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(166 == field333) {
                                 class24.method593(field293, field332);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 33) {
                                 for(var4 = 0; var4 < class175.field2906.length; ++var4) {
                                    if(class175.field2906[var4] != class175.field2904[var4]) {
                                       class175.field2906[var4] = class175.field2904[var4];
                                       class129.method2758(var4);
                                       field474[++field340 - 1 & 31] = var4;
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 39) {
                                 class167.method3305(false);
                                 field293.method2687();
                                 var4 = field293.method2455();
                                 class24.method593(field293, var4);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(8 == field333) {
                                 class32.field761 = field293.method2453();
                                 class13.field199 = field293.method2486();

                                 while(field293.field1998 < field332) {
                                    field333 = field293.method2453();
                                    class94.method2162();
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 98) {
                                 class25 var100 = new class25();
                                 var100.field640 = field293.method2461();
                                 var100.field637 = field293.method2455();
                                 var5 = field293.method2458();
                                 var100.field638 = var5;
                                 method556(45);
                                 class209.field3115.method2948();
                                 class209.field3115 = null;
                                 class1.method8(var100);
                                 field333 = -1;
                                 var63 = false;
                                 break label4675;
                              }

                              if(72 == field333) {
                                 var4 = field293.method2466();
                                 var102 = field293.method2453() == 1;
                                 var92 = "";
                                 var79 = false;
                                 if(var102) {
                                    var92 = field293.method2461();
                                    if(class18.method194(var92)) {
                                       var79 = true;
                                    }
                                 }

                                 String var106 = field293.method2461();
                                 if(!var79) {
                                    class16.method186(var4, var92, var106);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 243) {
                                 var4 = field293.method2489();
                                 field448 = var4;
                                 class51.method1078(false);
                                 class44.method939(var4);
                                 class42.method878(field448);

                                 for(var5 = 0; var5 < 100; ++var5) {
                                    field493[var5] = true;
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 91) {
                                 if(field448 != -1) {
                                    class18.method192(field448, 0);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(11 == field333) {
                                 var73 = field293.method2461();
                                 var5 = field293.method2539();
                                 var87 = class31.method698(var5);
                                 if(!var73.equals(var87.field2817)) {
                                    var87.field2817 = var73;
                                    class114.method2400(var87);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 101) {
                                 var73 = field293.method2461();
                                 var121 = class222.method3966(class190.method3705(class215.method3889(field293)));
                                 class16.method186(6, var73, var121);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(186 == field333) {
                                 class83.method1864();
                                 var4 = field293.method2486();
                                 var5 = field293.method2571();
                                 var66 = field293.method2509();
                                 field426[var4] = var66;
                                 field424[var4] = var5;
                                 field425[var4] = 1;

                                 for(var68 = 0; var68 < 98; ++var68) {
                                    if(var66 >= class154.field2301[var68]) {
                                       field425[var4] = 2 + var68;
                                    }
                                 }

                                 field463[++field521 - 1 & 31] = var4;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(67 == field333) {
                                 field528 = true;
                                 class101.field1769 = field293.method2453();
                                 class50.field1102 = field293.method2453();
                                 class105.field1883 = field293.method2455();
                                 class22.field597 = field293.method2453();
                                 class16.field233 = field293.method2453();
                                 if(class16.field233 >= 100) {
                                    var4 = class101.field1769 * 128 + 64;
                                    var5 = 64 + class50.field1102 * 128;
                                    var66 = class105.method2335(var4, var5, class75.field1386) - class105.field1883;
                                    var68 = var4 - class142.field2197;
                                    var74 = var66 - class36.field797;
                                    var76 = var5 - class147.field2228;
                                    var10 = (int)Math.sqrt((double)(var76 * var76 + var68 * var68));
                                    field556 = (int)(Math.atan2((double)var74, (double)var10) * 325.949D) & 2047;
                                    class74.field1371 = (int)(Math.atan2((double)var68, (double)var76) * -325.949D) & 2047;
                                    if(field556 < 128) {
                                       field556 = 128;
                                    }

                                    if(field556 > 383) {
                                       field556 = 383;
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 242) {
                                 field293.field1998 += 28;
                                 if(field293.method2475()) {
                                    class120.method2683(field293, field293.field1998 - 28);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(145 == field333) {
                                 var4 = field293.method2539();
                                 var5 = field293.method2488();
                                 var87 = class31.method698(var4);
                                 if(null != var87 && var87.field2849 == 0) {
                                    if(var5 > var87.field2783 - var87.field2890) {
                                       var5 = var87.field2783 - var87.field2890;
                                    }

                                    if(var5 < 0) {
                                       var5 = 0;
                                    }

                                    if(var87.field2886 != var5) {
                                       var87.field2886 = var5;
                                       class114.method2400(var87);
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              long var113;
                              if(field333 == 45) {
                                 var4 = field293.field1998 + field332;
                                 var5 = field293.method2455();
                                 var66 = field293.method2455();
                                 if(var5 != field448) {
                                    field448 = var5;
                                    class51.method1078(false);
                                    class44.method939(field448);
                                    class42.method878(field448);

                                    for(var68 = 0; var68 < 100; ++var68) {
                                       field493[var68] = true;
                                    }
                                 }

                                 class3 var97;
                                 for(; var66-- > 0; var97.field67 = true) {
                                    var68 = field293.method2458();
                                    var74 = field293.method2455();
                                    var76 = field293.method2453();
                                    var97 = (class3)field449.method3744((long)var68);
                                    if(null != var97 && var97.field66 != var74) {
                                       class4.method39(var97, true);
                                       var97 = null;
                                    }

                                    if(var97 == null) {
                                       var97 = method460(var68, var74, var76);
                                    }
                                 }

                                 for(var89 = (class3)field449.method3748(); null != var89; var89 = (class3)field449.method3747()) {
                                    if(var89.field67) {
                                       var89.field67 = false;
                                    } else {
                                       class4.method39(var89, true);
                                    }
                                 }

                                 field490 = new class195(512);

                                 while(field293.field1998 < var4) {
                                    var68 = field293.method2458();
                                    var74 = field293.method2455();
                                    var76 = field293.method2455();
                                    var10 = field293.method2458();

                                    for(var11 = var74; var11 <= var76; ++var11) {
                                       var113 = (long)var11 + ((long)var68 << 32);
                                       field490.method3746(new class200(var10), var113);
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 81 || 141 == field333 || field333 == 210 || 30 == field333 || 216 == field333 || field333 == 66 || field333 == 139 || field333 == 1 || 60 == field333 || 44 == field333) {
                                 class94.method2162();
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(122 == field333) {
                                 while(field293.field1998 < field332) {
                                    var4 = field293.method2453();
                                    var102 = 1 == (var4 & 1);
                                    var92 = field293.method2461();
                                    String var81 = field293.method2461();
                                    field293.method2461();

                                    for(var74 = 0; var74 < field559; ++var74) {
                                       class7 var83 = field560[var74];
                                       if(var102) {
                                          if(var81.equals(var83.field139)) {
                                             var83.field139 = var92;
                                             var83.field136 = var81;
                                             var92 = null;
                                             break;
                                          }
                                       } else if(var92.equals(var83.field139)) {
                                          var83.field139 = var92;
                                          var83.field136 = var81;
                                          var92 = null;
                                          break;
                                       }
                                    }

                                    if(var92 != null && field559 < 400) {
                                       class7 var99 = new class7();
                                       field560[field559] = var99;
                                       var99.field139 = var92;
                                       var99.field136 = var81;
                                       ++field559;
                                    }
                                 }

                                 field481 = field392;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 22) {
                                 field524 = field293.method2453();
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 248) {
                                 var73 = field293.method2461();
                                 var5 = field293.method2455();
                                 byte var91 = field293.method2454();
                                 var79 = false;
                                 if(var91 == -128) {
                                    var79 = true;
                                 }

                                 if(var79) {
                                    if(class10.field163 == 0) {
                                       field333 = -1;
                                       var63 = true;
                                       break label4675;
                                    }

                                    var8 = false;

                                    for(var74 = 0; var74 < class10.field163 && (!class135.field2103[var74].field626.equals(var73) || class135.field2103[var74].field620 != var5); ++var74) {
                                       ;
                                    }

                                    if(var74 < class10.field163) {
                                       while(var74 < class10.field163 - 1) {
                                          class135.field2103[var74] = class135.field2103[1 + var74];
                                          ++var74;
                                       }

                                       --class10.field163;
                                       class135.field2103[class10.field163] = null;
                                    }
                                 } else {
                                    field293.method2461();
                                    class24 var84 = new class24();
                                    var84.field626 = var73;
                                    var84.field621 = class134.method2803(var84.field626, field473);
                                    var84.field620 = var5;
                                    var84.field622 = var91;

                                    for(var76 = class10.field163 - 1; var76 >= 0; --var76) {
                                       var10 = class135.field2103[var76].field621.compareTo(var84.field621);
                                       if(0 == var10) {
                                          class135.field2103[var76].field620 = var5;
                                          class135.field2103[var76].field622 = var91;
                                          if(var73.equals(class148.field2249.field48)) {
                                             class161.field2653 = var91;
                                          }

                                          field482 = field392;
                                          field333 = -1;
                                          var63 = true;
                                          break label4675;
                                       }

                                       if(var10 < 0) {
                                          break;
                                       }
                                    }

                                    if(class10.field163 >= class135.field2103.length) {
                                       field333 = -1;
                                       var63 = true;
                                       break label4675;
                                    }

                                    for(var10 = class10.field163 - 1; var10 > var76; --var10) {
                                       class135.field2103[var10 + 1] = class135.field2103[var10];
                                    }

                                    if(0 == class10.field163) {
                                       class135.field2103 = new class24[100];
                                    }

                                    class135.field2103[var76 + 1] = var84;
                                    ++class10.field163;
                                    if(var73.equals(class148.field2249.field48)) {
                                       class161.field2653 = var91;
                                    }
                                 }

                                 field482 = field392;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(0 == field333) {
                                 var4 = field293.method2490();
                                 var5 = field293.method2497();
                                 var87 = class31.method698(var5);
                                 if(var87.field2836 != var4 || var4 == -1) {
                                    var87.field2836 = var4;
                                    var87.field2816 = 0;
                                    var87.field2760 = 0;
                                    class114.method2400(var87);
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(64 == field333) {
                                 class5.method57(field293);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 162) {
                                 var73 = field293.method2461();
                                 var98 = field293.method2632();
                                 var78 = (long)field293.method2455();
                                 var80 = (long)field293.method2553();
                                 class151 var104 = (class151)class150.method3104(class175.method3414(), field293.method2453());
                                 var113 = var80 + (var78 << 32);
                                 var131 = false;

                                 for(var15 = 0; var15 < 100; ++var15) {
                                    if(field509[var15] == var113) {
                                       var131 = true;
                                       break;
                                    }
                                 }

                                 if(var104.field2278 && class18.method194(var73)) {
                                    var131 = true;
                                 }

                                 if(!var131 && 0 == field471) {
                                    field509[field510] = var113;
                                    field510 = (field510 + 1) % 100;
                                    String var139 = class222.method3966(class190.method3705(class215.method3889(field293)));
                                    if(var104.field2276 != -1) {
                                       class44.method934(9, class18.method198(var104.field2276) + var73, var139, class189.method3702(var98));
                                    } else {
                                       class44.method934(9, var73, var139, class189.method3702(var98));
                                    }
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 9) {
                                 class83.method1864();
                                 field335 = field293.method2453();
                                 field363 = field392;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(176 == field333) {
                                 class32.field761 = field293.method2571();
                                 class13.field199 = field293.method2486();
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(97 == field333) {
                                 class27.method648();
                                 field333 = -1;
                                 var63 = false;
                                 break label4675;
                              }

                              if(217 == field333) {
                                 field528 = false;

                                 for(var4 = 0; var4 < 5; ++var4) {
                                    field537[var4] = false;
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(61 == field333) {
                                 class167.method3305(true);
                                 field293.method2687();
                                 var4 = field293.method2455();
                                 class24.method593(field293, var4);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 25) {
                                 var4 = field293.method2455();
                                 class15 var93 = (class15)class15.field225.method3744((long)var4);
                                 if(null != var93) {
                                    var93.method3853();
                                 }

                                 field476[++field411 - 1 & 31] = var4 & 32767;
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 36) {
                                 class77.method1674(field293.method2461());
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(159 == field333) {
                                 var4 = field293.method2458();
                                 var5 = field293.method2458();
                                 if(null == class180.field2935 || !class180.field2935.isValid()) {
                                    try {
                                       Iterator var85 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                                       while(var85.hasNext()) {
                                          GarbageCollectorMXBean var77 = (GarbageCollectorMXBean)var85.next();
                                          if(var77.isValid()) {
                                             class180.field2935 = var77;
                                             field566 = -1L;
                                             field461 = -1L;
                                          }
                                       }
                                    } catch (Throwable var52) {
                                       ;
                                    }
                                 }

                                 long var86 = class109.method2381();
                                 var74 = -1;
                                 if(class180.field2935 != null) {
                                    var80 = class180.field2935.getCollectionTime();
                                    if(field461 != -1L) {
                                       long var103 = var80 - field461;
                                       var109 = var86 - field566;
                                       if(var109 != 0L) {
                                          var74 = (int)(var103 * 100L / var109);
                                       }
                                    }

                                    field461 = var80;
                                    field566 = var86;
                                 }

                                 field329.method2686(1);
                                 field329.method2636(var4);
                                 field329.method2636(var5);
                                 field329.method2477(class143.field2205);
                                 field329.method2477(var74);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 171) {
                                 field528 = true;
                                 class7.field135 = field293.method2453();
                                 class108.field1910 = field293.method2453();
                                 class59.field1220 = field293.method2455();
                                 class115.field1977 = field293.method2453();
                                 class218.field3163 = field293.method2453();
                                 if(class218.field3163 >= 100) {
                                    class142.field2197 = class7.field135 * 128 + 64;
                                    class147.field2228 = class108.field1910 * 128 + 64;
                                    class36.field797 = class105.method2335(class142.field2197, class147.field2228, class75.field1386) - class59.field1220;
                                 }

                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              if(field333 == 154) {
                                 var73 = field293.method2461();
                                 Object[] var90 = new Object[var73.length() + 1];

                                 for(var66 = var73.length() - 1; var66 >= 0; --var66) {
                                    if(var73.charAt(var66) == 115) {
                                       var90[var66 + 1] = field293.method2461();
                                    } else {
                                       var90[1 + var66] = new Integer(field293.method2458());
                                    }
                                 }

                                 var90[0] = new Integer(field293.method2458());
                                 class0 var82 = new class0();
                                 var82.field5 = var90;
                                 class126.method2751(var82, 200000);
                                 field333 = -1;
                                 var63 = true;
                                 break label4675;
                              }

                              class16.method184("" + field333 + "," + field546 + "," + field554 + "," + field332, (Throwable)null);
                              class27.method648();
                           } catch (IOException var53) {
                              class21.method570();
                           } catch (Exception var54) {
                              var73 = "" + field333 + "," + field546 + "," + field554 + "," + field332 + "," + (class148.field2249.field864[0] + class98.field1683) + "," + (class92.field1598 + class148.field2249.field817[0]) + ",";

                              for(var5 = 0; var5 < field332 && var5 < 50; ++var5) {
                                 var73 = var73 + field293.field1995[var5] + ",";
                              }

                              class16.method184(var73, var54);
                              class27.method648();
                           }

                           var63 = true;
                        }
                     }

                     if(!var63) {
                        break;
                     }
                  }

                  if(30 == field295) {
                     while(class188.method3701()) {
                        field329.method2686(242);
                        field329.method2438(0);
                        var56 = field329.field1998;
                        class187.method3700(field329);
                        field329.method2450(field329.field1998 - var56);
                     }

                     Object var61 = class177.field2912.field198;
                     synchronized(class177.field2912.field198) {
                        if(!field285) {
                           class177.field2912.field205 = 0;
                        } else if(class139.field2168 != 0 || class177.field2912.field205 >= 40) {
                           field329.method2686(69);
                           field329.method2438(0);
                           var58 = field329.field1998;
                           var59 = 0;

                           for(var4 = 0; var4 < class177.field2912.field205 && field329.field1998 - var58 < 240; ++var4) {
                              ++var59;
                              var5 = class177.field2912.field206[var4];
                              if(var5 < 0) {
                                 var5 = 0;
                              } else if(var5 > 502) {
                                 var5 = 502;
                              }

                              var66 = class177.field2912.field202[var4];
                              if(var66 < 0) {
                                 var66 = 0;
                              } else if(var66 > 764) {
                                 var66 = 764;
                              }

                              var68 = var66 + 765 * var5;
                              if(-1 == class177.field2912.field206[var4] && -1 == class177.field2912.field202[var4]) {
                                 var66 = -1;
                                 var5 = -1;
                                 var68 = 524287;
                              }

                              if(field299 == var66 && var5 == field373) {
                                 if(field445 < 2047) {
                                    ++field445;
                                 }
                              } else {
                                 var74 = var66 - field299;
                                 field299 = var66;
                                 var76 = var5 - field373;
                                 field373 = var5;
                                 if(field445 < 8 && var74 >= -32 && var74 <= 31 && var76 >= -32 && var76 <= 31) {
                                    var74 += 32;
                                    var76 += 32;
                                    field329.method2541(var76 + (var74 << 6) + (field445 << 12));
                                    field445 = 0;
                                 } else if(field445 < 8) {
                                    field329.method2457((field445 << 19) + 8388608 + var68);
                                    field445 = 0;
                                 } else {
                                    field329.method2441((field445 << 19) + -1073741824 + var68);
                                    field445 = 0;
                                 }
                              }
                           }

                           field329.method2450(field329.field1998 - var58);
                           if(var59 >= class177.field2912.field205) {
                              class177.field2912.field205 = 0;
                           } else {
                              class177.field2912.field205 -= var59;

                              for(var4 = 0; var4 < class177.field2912.field205; ++var4) {
                                 class177.field2912.field202[var4] = class177.field2912.field202[var4 + var59];
                                 class177.field2912.field206[var4] = class177.field2912.field206[var4 + var59];
                              }
                           }
                        }
                     }

                     if(1 == class139.field2168 || !class94.field1617 && class139.field2168 == 4 || class139.field2168 == 2) {
                        long var62 = (class139.field2156 - field298 * -1L) / 50L;
                        if(var62 > 4095L) {
                           var62 = 4095L;
                        }

                        field298 = class139.field2156 * -1L;
                        var59 = class139.field2163;
                        if(var59 < 0) {
                           var59 = 0;
                        } else if(var59 > class89.field1566) {
                           var59 = class89.field1566;
                        }

                        var4 = class139.field2169;
                        if(var4 < 0) {
                           var4 = 0;
                        } else if(var4 > class142.field2190) {
                           var4 = class142.field2190;
                        }

                        var5 = (int)var62;
                        field329.method2686(200);
                        field329.method2541((class139.field2168 == 2?1:0) + (var5 << 1));
                        field329.method2541(var4);
                        field329.method2541(var59);
                     }

                     if(class136.field2128 > 0) {
                        field329.method2686(138);
                        field329.method2541(0);
                        var56 = field329.field1998;
                        long var153 = class109.method2381();

                        for(var4 = 0; var4 < class136.field2128; ++var4) {
                           var98 = var153 - field514;
                           if(var98 > 16777215L) {
                              var98 = 16777215L;
                           }

                           field514 = var153;
                           field329.method2478((int)var98);
                           field329.method2622(class136.field2127[var4]);
                        }

                        field329.method2514(field329.field1998 - var56);
                     }

                     if(field380 > 0) {
                        --field380;
                     }

                     if(class136.field2121[96] || class136.field2121[97] || class136.field2121[98] || class136.field2121[99]) {
                        field381 = true;
                     }

                     if(field381 && field380 <= 0) {
                        field380 = 20;
                        field381 = false;
                        field329.method2686(93);
                        field329.method2564(field555);
                        field329.method2484(field374);
                     }

                     if(class50.field1106 && !field302) {
                        field302 = true;
                        field329.method2686(82);
                        field329.method2438(1);
                     }

                     if(!class50.field1106 && field302) {
                        field302 = false;
                        field329.method2686(82);
                        field329.method2438(0);
                     }

                     int[] var154;
                     if(field517 * -1 != class75.field1386) {
                        field517 = class75.field1386 * -1;
                        var56 = class75.field1386;
                        var154 = class42.field1002.field1412;
                        var59 = var154.length;

                        for(var4 = 0; var4 < var59; ++var4) {
                           var154[var4] = 0;
                        }

                        var4 = 1;

                        while(true) {
                           if(var4 >= 103) {
                              var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                              var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                              class42.field1002.method1678();

                              for(var66 = 1; var66 < 103; ++var66) {
                                 for(var68 = 1; var68 < 103; ++var68) {
                                    if(0 == (class5.field81[var56][var68][var66] & 24)) {
                                       class108.method2377(var56, var68, var66, var4, var5);
                                    }

                                    if(var56 < 3 && 0 != (class5.field81[1 + var56][var68][var66] & 8)) {
                                       class108.method2377(1 + var56, var68, var66, var4, var5);
                                    }
                                 }
                              }

                              field518 = 0;

                              for(var66 = 0; var66 < 104; ++var66) {
                                 for(var68 = 0; var68 < 104; ++var68) {
                                    var74 = class107.field1906.method2010(class75.field1386, var66, var68);
                                    if(var74 != 0) {
                                       var74 = var74 >> 14 & 32767;
                                       var76 = class48.method996(var74).field945;
                                       if(var76 >= 0) {
                                          var10 = var66;
                                          var11 = var68;
                                          if(22 != var76 && 29 != var76 && var76 != 34 && 36 != var76 && 46 != var76 && 47 != var76 && var76 != 48) {
                                             int[][] var144 = field346[class75.field1386].field1904;

                                             for(var15 = 0; var15 < 10; ++var15) {
                                                var16 = (int)(Math.random() * 4.0D);
                                                if(0 == var16 && var10 > 0 && var10 > var66 - 3 && 0 == (var144[var10 - 1][var11] & 19136776)) {
                                                   --var10;
                                                }

                                                if(var16 == 1 && var10 < 103 && var10 < 3 + var66 && (var144[var10 + 1][var11] & 19136896) == 0) {
                                                   ++var10;
                                                }

                                                if(2 == var16 && var11 > 0 && var11 > var68 - 3 && 0 == (var144[var10][var11 - 1] & 19136770)) {
                                                   --var11;
                                                }

                                                if(var16 == 3 && var11 < 103 && var11 < 3 + var68 && (var144[var10][var11 + 1] & 19136800) == 0) {
                                                   ++var11;
                                                }
                                             }
                                          }

                                          field395[field518] = class40.field966[var76];
                                          field519[field518] = var10;
                                          field563[field518] = var11;
                                          ++field518;
                                       }
                                    }
                                 }
                              }

                              class75.field1385.method1667();
                              break;
                           }

                           var5 = 24628 + (103 - var4) * 2048;

                           for(var66 = 1; var66 < 103; ++var66) {
                              if(0 == (class5.field81[var56][var66][var4] & 24)) {
                                 class107.field1906.method1909(var154, var5, 512, var56, var66, var4);
                              }

                              if(var56 < 3 && (class5.field81[1 + var56][var66][var4] & 8) != 0) {
                                 class107.field1906.method1909(var154, var5, 512, var56 + 1, var66, var4);
                              }

                              var5 += 4;
                           }

                           ++var4;
                        }
                     }

                     if(field295 == 30) {
                        for(class16 var65 = (class16)field409.method3773(); var65 != null; var65 = (class16)field409.method3772()) {
                           if(var65.field244 > 0) {
                              --var65.field244;
                           }

                           if(var65.field244 == 0) {
                              if(var65.field241 < 0 || class14.method165(var65.field241, var65.field236)) {
                                 class15.method181(var65.field242, var65.field231, var65.field230, var65.field235, var65.field241, var65.field234, var65.field236);
                                 var65.method3853();
                              }
                           } else {
                              if(var65.field240 > 0) {
                                 --var65.field240;
                              }

                              if(0 == var65.field240 && var65.field230 >= 1 && var65.field235 >= 1 && var65.field230 <= 102 && var65.field235 <= 102 && (var65.field237 < 0 || class14.method165(var65.field237, var65.field239))) {
                                 class15.method181(var65.field242, var65.field231, var65.field230, var65.field235, var65.field237, var65.field238, var65.field239);
                                 var65.field240 = -1;
                                 if(var65.field241 == var65.field237 && var65.field241 == -1) {
                                    var65.method3853();
                                 } else if(var65.field237 == var65.field241 && var65.field234 == var65.field238 && var65.field239 == var65.field236) {
                                    var65.method3853();
                                 }
                              }
                           }
                        }

                        class217.method3916();
                        ++field334;
                        if(field334 > 750) {
                           class21.method570();
                        } else {
                           var56 = class32.field749;
                           var154 = class32.field755;

                           for(var59 = 0; var59 < var56; ++var59) {
                              class2 var160 = field410[var154[var59]];
                              if(var160 != null) {
                                 class162.method3179(var160);
                              }
                           }

                           class88.method2052();
                           class25.method634();
                           ++field362;
                           if(field400 != 0) {
                              field305 += 20;
                              if(field305 >= 400) {
                                 field400 = 0;
                              }
                           }

                           if(class8.field141 != null) {
                              ++field338;
                              if(field338 >= 15) {
                                 class114.method2400(class8.field141);
                                 class8.field141 = null;
                              }
                           }

                           class172 var69 = class74.field1376;
                           class172 var156 = class52.field1171;
                           class74.field1376 = null;
                           class52.field1171 = null;
                           field312 = null;
                           field469 = false;
                           field466 = false;
                           field500 = 0;

                           while(true) {
                              while(class190.method3703() && field500 < 128) {
                                 if(field455 >= 2 && class136.field2121[82] && 66 == class3.field70) {
                                    var73 = "";

                                    class35 var155;
                                    for(Iterator var162 = class11.field172.iterator(); var162.hasNext(); var73 = var73 + var155.field783 + ':' + var155.field785 + '\n') {
                                       var155 = (class35)var162.next();
                                    }

                                    class8.field146.setContents(new StringSelection(var73), (ClipboardOwner)null);
                                 } else {
                                    field385[field500] = class3.field70;
                                    field512[field500] = class18.field254;
                                    ++field500;
                                 }
                              }

                              if(field448 != -1) {
                                 var59 = field448;
                                 var4 = class142.field2190;
                                 var5 = class89.field1566;
                                 if(class149.method3102(var59)) {
                                    class16.method183(class172.field2757[var59], -1, 0, 0, var4, var5, 0, 0);
                                 }
                              }

                              ++field392;

                              while(true) {
                                 class0 var95;
                                 class172 var161;
                                 do {
                                    var95 = (class0)field488.method3771();
                                    if(var95 == null) {
                                       while(true) {
                                          do {
                                             var95 = (class0)field489.method3771();
                                             if(null == var95) {
                                                while(true) {
                                                   do {
                                                      var95 = (class0)field465.method3771();
                                                      if(null == var95) {
                                                         class139.method2913();
                                                         if(field536 != null) {
                                                            class126.method2750();
                                                         }

                                                         if(class132.field2073 != null) {
                                                            class114.method2400(class132.field2073);
                                                            ++field341;
                                                            if(class139.field2161 != 0) {
                                                               if(field341 >= 5 && (class139.field2162 > 5 + field533 || class139.field2162 < field533 - 5 || class139.field2171 > field292 + 5 || class139.field2171 < field292 - 5)) {
                                                                  field543 = true;
                                                               }
                                                            } else {
                                                               if(field543) {
                                                                  if(class141.field2181 == class132.field2073 && field406 != field535) {
                                                                     class172 var101 = class132.field2073;
                                                                     byte var165 = 0;
                                                                     if(1 == field451 && var101.field2763 == 206) {
                                                                        var165 = 1;
                                                                     }

                                                                     if(var101.field2875[field406] <= 0) {
                                                                        var165 = 0;
                                                                     }

                                                                     if(class83.method1866(class42.method898(var101))) {
                                                                        var5 = field535;
                                                                        var66 = field406;
                                                                        var101.field2875[var66] = var101.field2875[var5];
                                                                        var101.field2876[var66] = var101.field2876[var5];
                                                                        var101.field2875[var5] = -1;
                                                                        var101.field2876[var5] = 0;
                                                                     } else if(1 == var165) {
                                                                        var5 = field535;
                                                                        var66 = field406;

                                                                        while(var66 != var5) {
                                                                           if(var5 > var66) {
                                                                              var101.method3355(var5 - 1, var5);
                                                                              --var5;
                                                                           } else if(var5 < var66) {
                                                                              var101.method3355(var5 + 1, var5);
                                                                              ++var5;
                                                                           }
                                                                        }
                                                                     } else {
                                                                        var101.method3355(field406, field535);
                                                                     }

                                                                     field329.method2686(99);
                                                                     field329.method2541(field535);
                                                                     field329.method2636(class132.field2073.field2759 * -1);
                                                                     field329.method2622(var165);
                                                                     field329.method2440(field406);
                                                                  }
                                                               } else {
                                                                  label3062: {
                                                                     label3061: {
                                                                        if(field427 != 1) {
                                                                           var4 = field430 - 1;
                                                                           boolean var105;
                                                                           if(var4 < 0) {
                                                                              var105 = false;
                                                                           } else {
                                                                              var5 = field433[var4];
                                                                              if(var5 >= 2000) {
                                                                                 var5 -= 2000;
                                                                              }

                                                                              if(var5 == 1007) {
                                                                                 var105 = true;
                                                                              } else {
                                                                                 var105 = false;
                                                                              }
                                                                           }

                                                                           if(!var105) {
                                                                              break label3061;
                                                                           }
                                                                        }

                                                                        if(field430 > 2) {
                                                                           class19.method212(field533, field292);
                                                                           break label3062;
                                                                        }
                                                                     }

                                                                     if(field430 > 0) {
                                                                        class49.method1006(field533, field292);
                                                                     }
                                                                  }
                                                               }

                                                               field338 = 10;
                                                               class139.field2168 = 0;
                                                               class132.field2073 = null;
                                                            }
                                                         }

                                                         if(-1 != class85.field1470) {
                                                            var59 = class85.field1470;
                                                            var4 = class85.field1515;
                                                            field329.method2686(60);
                                                            field329.method2438(5);
                                                            field329.method2440(class92.field1598 + var4);
                                                            field329.method2564(class98.field1683 + var59);
                                                            field329.method2476(class136.field2121[82]?(class136.field2121[81]?2:1):0);
                                                            class85.field1470 = -1;
                                                            field397 = class139.field2169;
                                                            field479 = class139.field2163;
                                                            field400 = 1;
                                                            field305 = 0;
                                                            field296 = var59;
                                                            field319 = var4;
                                                         }

                                                         if(class74.field1376 != var69) {
                                                            if(null != var69) {
                                                               class114.method2400(var69);
                                                            }

                                                            if(class74.field1376 != null) {
                                                               class114.method2400(class74.field1376);
                                                            }
                                                         }

                                                         if(var156 != class52.field1171 && field440 == field439) {
                                                            if(var156 != null) {
                                                               class114.method2400(var156);
                                                            }

                                                            if(class52.field1171 != null) {
                                                               class114.method2400(class52.field1171);
                                                            }
                                                         }

                                                         if(null != class52.field1171) {
                                                            if(field439 < field440) {
                                                               ++field439;
                                                               if(field439 == field440) {
                                                                  class114.method2400(class52.field1171);
                                                               }
                                                            }
                                                         } else if(field439 > 0) {
                                                            --field439;
                                                         }

                                                         var59 = class148.field2249.field839 + field283;
                                                         var4 = field352 + class148.field2249.field848;
                                                         if(class98.field1695 - var59 < -500 || class98.field1695 - var59 > 500 || class138.field2153 - var4 < -500 || class138.field2153 - var4 > 500) {
                                                            class98.field1695 = var59;
                                                            class138.field2153 = var4;
                                                         }

                                                         if(var59 != class98.field1695) {
                                                            class98.field1695 += (var59 - class98.field1695) / 16;
                                                         }

                                                         if(class138.field2153 != var4) {
                                                            class138.field2153 += (var4 - class138.field2153) / 16;
                                                         }

                                                         if(class139.field2161 == 4 && class94.field1617) {
                                                            var5 = class139.field2171 - field378;
                                                            field376 = var5 * 2;
                                                            field378 = -1 != var5 && var5 != 1?(class139.field2171 + field378) / 2:class139.field2171;
                                                            var66 = field415 - class139.field2162;
                                                            field505 = var66 * 2;
                                                            field415 = var66 != -1 && var66 != 1?(class139.field2162 + field415) / 2:class139.field2162;
                                                         } else {
                                                            if(class136.field2121[96]) {
                                                               field505 += (-24 - field505) / 2;
                                                            } else if(class136.field2121[97]) {
                                                               field505 += (24 - field505) / 2;
                                                            } else {
                                                               field505 /= 2;
                                                            }

                                                            if(class136.field2121[98]) {
                                                               field376 += (12 - field376) / 2;
                                                            } else if(class136.field2121[99]) {
                                                               field376 += (-12 - field376) / 2;
                                                            } else {
                                                               field376 /= 2;
                                                            }

                                                            field378 = class139.field2171;
                                                            field415 = class139.field2162;
                                                         }

                                                         field374 = field374 + field505 / 2 & 2047;
                                                         field555 += field376 / 2;
                                                         if(field555 < 128) {
                                                            field555 = 128;
                                                         }

                                                         if(field555 > 383) {
                                                            field555 = 383;
                                                         }

                                                         var5 = class98.field1695 >> 7;
                                                         var66 = class138.field2153 >> 7;
                                                         var68 = class105.method2335(class98.field1695, class138.field2153, class75.field1386);
                                                         var74 = 0;
                                                         if(var5 > 3 && var66 > 3 && var5 < 100 && var66 < 100) {
                                                            for(var76 = var5 - 4; var76 <= 4 + var5; ++var76) {
                                                               for(var10 = var66 - 4; var10 <= var66 + 4; ++var10) {
                                                                  var11 = class75.field1386;
                                                                  if(var11 < 3 && 2 == (class5.field81[1][var76][var10] & 2)) {
                                                                     ++var11;
                                                                  }

                                                                  var12 = var68 - class5.field93[var11][var76][var10];
                                                                  if(var12 > var74) {
                                                                     var74 = var12;
                                                                  }
                                                               }
                                                            }
                                                         }

                                                         var76 = var74 * 192;
                                                         if(var76 > 98048) {
                                                            var76 = 98048;
                                                         }

                                                         if(var76 < '耀') {
                                                            var76 = '耀';
                                                         }

                                                         if(var76 > field551) {
                                                            field551 += (var76 - field551) / 24;
                                                         } else if(var76 < field551) {
                                                            field551 += (var76 - field551) / 80;
                                                         }

                                                         if(field528) {
                                                            class14.method160();
                                                         }

                                                         for(var59 = 0; var59 < 5; ++var59) {
                                                            ++field541[var59];
                                                         }

                                                         class3.field63.method222();
                                                         var59 = ++class139.field2170 - 1;
                                                         var5 = class136.field2132;
                                                         if(var59 > 15000 && var5 > 15000) {
                                                            field339 = 250;
                                                            class21.method576(14500);
                                                            field329.method2686(209);
                                                         }

                                                         ++field377;
                                                         if(field377 > 500) {
                                                            field377 = 0;
                                                            var68 = (int)(Math.random() * 8.0D);
                                                            if((var68 & 1) == 1) {
                                                               field283 += field342;
                                                            }

                                                            if(2 == (var68 & 2)) {
                                                               field352 += field353;
                                                            }

                                                            if((var68 & 4) == 4) {
                                                               field354 += field355;
                                                            }
                                                         }

                                                         if(field283 < -50) {
                                                            field342 = 2;
                                                         }

                                                         if(field283 > 50) {
                                                            field342 = -2;
                                                         }

                                                         if(field352 < -55) {
                                                            field353 = 2;
                                                         }

                                                         if(field352 > 55) {
                                                            field353 = -2;
                                                         }

                                                         if(field354 < -40) {
                                                            field355 = 1;
                                                         }

                                                         if(field354 > 40) {
                                                            field355 = -1;
                                                         }

                                                         ++field398;
                                                         if(field398 > 500) {
                                                            field398 = 0;
                                                            var68 = (int)(Math.random() * 8.0D);
                                                            if(1 == (var68 & 1)) {
                                                               field522 += field331;
                                                            }

                                                            if((var68 & 2) == 2) {
                                                               field359 += field360;
                                                            }
                                                         }

                                                         if(field522 < -60) {
                                                            field331 = 2;
                                                         }

                                                         if(field522 > 60) {
                                                            field331 = -2;
                                                         }

                                                         if(field359 < -20) {
                                                            field360 = 1;
                                                         }

                                                         if(field359 > 10) {
                                                            field360 = -1;
                                                         }

                                                         for(class38 var149 = (class38)field558.method3740(); var149 != null; var149 = (class38)field558.method3736()) {
                                                            if((long)var149.field870 < class109.method2381() / 1000L - 5L) {
                                                               if(var149.field871 > 0) {
                                                                  class16.method186(5, "", var149.field875 + " has logged in.");
                                                               }

                                                               if(var149.field871 == 0) {
                                                                  class16.method186(5, "", var149.field875 + " has logged out.");
                                                               }

                                                               var149.method3850();
                                                            }
                                                         }

                                                         ++field337;
                                                         if(field337 > 50) {
                                                            field329.method2686(149);
                                                         }

                                                         try {
                                                            if(null != class209.field3115 && field329.field1998 > 0) {
                                                               class209.field3115.method2932(field329.field1995, 0, field329.field1998);
                                                               field329.field1998 = 0;
                                                               field337 = 0;
                                                               return;
                                                            }
                                                         } catch (IOException var48) {
                                                            class21.method570();
                                                         }

                                                         return;
                                                      }

                                                      var161 = var95.field2;
                                                      if(var161.field2825 < 0) {
                                                         break;
                                                      }

                                                      var136 = class31.method698(var161.field2778);
                                                   } while(null == var136 || var136.field2881 == null || var161.field2825 >= var136.field2881.length || var161 != var136.field2881[var161.field2825]);

                                                   class126.method2751(var95, 200000);
                                                }
                                             }

                                             var161 = var95.field2;
                                             if(var161.field2825 < 0) {
                                                break;
                                             }

                                             var136 = class31.method698(var161.field2778);
                                          } while(var136 == null || null == var136.field2881 || var161.field2825 >= var136.field2881.length || var161 != var136.field2881[var161.field2825]);

                                          class126.method2751(var95, 200000);
                                       }
                                    }

                                    var161 = var95.field2;
                                    if(var161.field2825 < 0) {
                                       break;
                                    }

                                    var136 = class31.method698(var161.field2778);
                                 } while(var136 == null || null == var136.field2881 || var161.field2825 >= var136.field2881.length || var161 != var136.field2881[var161.field2825]);

                                 class126.method2751(var95, 200000);
                              }
                           }
                        }
                     }
                  }
               }
            } else if(field295 == 40 || field295 == 45) {
               class136.method2870();
            }

            return;
         }

         var1.field2712.method3320(var1.field2711, (int)var1.field3112, var1.field2710, false);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1828816496"
   )
   protected final void vmethod3033() {
      boolean var1;
      label384: {
         try {
            if(2 == class182.field2957) {
               if(null == class169.field2719) {
                  class169.field2719 = class179.method3467(class182.field2955, class125.field2043, class7.field138);
                  if(null == class169.field2719) {
                     var1 = false;
                     break label384;
                  }
               }

               if(class171.field2746 == null) {
                  class171.field2746 = new class59(class182.field2953, class182.field2951);
               }

               if(class182.field2954.method3551(class169.field2719, class182.field2952, class171.field2746, 22050)) {
                  class182.field2954.method3596();
                  class182.field2954.method3549(class75.field1388);
                  class182.field2954.method3554(class169.field2719, class11.field182);
                  class182.field2957 = 0;
                  class169.field2719 = null;
                  class171.field2746 = null;
                  class182.field2955 = null;
                  var1 = true;
                  break label384;
               }
            }
         } catch (Exception var20) {
            var20.printStackTrace();
            class182.field2954.method3637();
            class182.field2957 = 0;
            class169.field2719 = null;
            class171.field2746 = null;
            class182.field2955 = null;
         }

         var1 = false;
      }

      if(var1 && field527 && null != class47.field1070) {
         class47.field1070.method1177();
      }

      if(10 == field295 || field295 == 20 || field295 == 30) {
         if(field501 != 0L && class109.method2381() > field501) {
            int var3 = class97.method2167();
            field501 = 0L;
            if(var3 >= 2) {
               field382 = true;
            } else {
               field382 = false;
            }

            class41.method860();
            if(field295 >= 25) {
               field329.method2686(179);
               field329.method2438(class97.method2167());
               field329.method2541(class142.field2190);
               field329.method2541(class89.field1566);
            }

            class143.field2210 = true;
         } else if(class143.field2213) {
            class215.method3898();
         }
      }

      Dimension var21 = this.method2966();
      if(var21.width != class34.field775 || var21.height != class102.field1777 || class143.field2212) {
         class41.method860();
         field501 = class109.method2381() + 500L;
         class143.field2212 = false;
      }

      boolean var4 = false;
      int var5;
      if(class143.field2210) {
         class143.field2210 = false;
         var4 = true;

         for(var5 = 0; var5 < 100; ++var5) {
            field493[var5] = true;
         }
      }

      if(var4) {
         class208.method3862();
      }

      int var10;
      int var11;
      int var22;
      if(field295 == 0) {
         var5 = class31.field724;
         String var6 = class31.field723;
         Color var7 = null;

         try {
            Graphics var8 = class125.field2039.getGraphics();
            if(null == class31.field708) {
               class31.field708 = new Font("Helvetica", 1, 13);
               class132.field2070 = class125.field2039.getFontMetrics(class31.field708);
            }

            if(var4) {
               var8.setColor(Color.black);
               var8.fillRect(0, 0, class142.field2190, class89.field1566);
            }

            if(null == var7) {
               var7 = new Color(140, 17, 17);
            }

            try {
               if(class38.field872 == null) {
                  class38.field872 = class125.field2039.createImage(304, 34);
               }

               Graphics var9 = class38.field872.getGraphics();
               var9.setColor(var7);
               var9.drawRect(0, 0, 303, 33);
               var9.fillRect(2, 2, 3 * var5, 30);
               var9.setColor(Color.black);
               var9.drawRect(1, 1, 301, 31);
               var9.fillRect(2 + 3 * var5, 2, 300 - var5 * 3, 30);
               var9.setFont(class31.field708);
               var9.setColor(Color.white);
               var9.drawString(var6, (304 - class132.field2070.stringWidth(var6)) / 2, 22);
               var8.drawImage(class38.field872, class142.field2190 / 2 - 152, class89.field1566 / 2 - 18, (ImageObserver)null);
            } catch (Exception var16) {
               var10 = class142.field2190 / 2 - 152;
               var11 = class89.field1566 / 2 - 18;
               var8.setColor(var7);
               var8.drawRect(var10, var11, 303, 33);
               var8.fillRect(var10 + 2, var11 + 2, 3 * var5, 30);
               var8.setColor(Color.black);
               var8.drawRect(1 + var10, 1 + var11, 301, 31);
               var8.fillRect(var10 + 2 + var5 * 3, var11 + 2, 300 - 3 * var5, 30);
               var8.setFont(class31.field708);
               var8.setColor(Color.white);
               var8.drawString(var6, var10 + (304 - class132.field2070.stringWidth(var6)) / 2, 22 + var11);
            }
         } catch (Exception var17) {
            class125.field2039.repaint();
         }
      } else if(5 == field295) {
         class134.method2806(class1.field28, class0.field4, class29.field692, var4);
      } else if(field295 != 10 && 11 != field295) {
         if(field295 == 20) {
            class134.method2806(class1.field28, class0.field4, class29.field692, var4);
         } else if(field295 == 25) {
            if(field345 == 1) {
               if(field372 > field434) {
                  field434 = field372;
               }

               var5 = (field434 * 50 - field372 * 50) / field434;
               class10.method128("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else if(2 == field345) {
               if(field343 > field344) {
                  field344 = field343;
               }

               var5 = 50 + (field344 * 50 - field343 * 50) / field344;
               class10.method128("Loading - please wait." + "<br>" + " (" + var5 + "%" + ")", false);
            } else {
               class10.method128("Loading - please wait.", false);
            }
         } else if(30 == field295) {
            if(-1 != field448) {
               class36.method749(field448);
            }

            for(var5 = 0; var5 < field491; ++var5) {
               if(field493[var5]) {
                  field497[var5] = true;
               }

               field495[var5] = field493[var5];
               field493[var5] = false;
            }

            field492 = field394;
            field289 = -1;
            field315 = -1;
            class141.field2181 = null;
            if(field448 != -1) {
               field491 = 0;
               class89.method2055(field448, 0, 0, class142.field2190, class89.field1566, 0, 0, -1);
            }

            class79.method1769();
            if(!field308) {
               if(-1 != field289) {
                  class19.method230(field289, field315);
               }
            } else {
               class210.method3871();
            }

            if(field513 == 3) {
               for(var5 = 0; var5 < field491; ++var5) {
                  if(field495[var5]) {
                     class79.method1818(field496[var5], field456[var5], field498[var5], field499[var5], 16711935, 128);
                  } else if(field497[var5]) {
                     class79.method1818(field496[var5], field456[var5], field498[var5], field499[var5], 16711680, 128);
                  }
               }
            }

            var5 = class75.field1386;
            var22 = class148.field2249.field839;
            int var24 = class148.field2249.field848;
            int var25 = field362;

            for(class23 var26 = (class23)class23.field615.method3773(); null != var26; var26 = (class23)class23.field615.method3772()) {
               if(-1 != var26.field609 || var26.field619 != null) {
                  var10 = 0;
                  if(var22 > var26.field610) {
                     var10 += var22 - var26.field610;
                  } else if(var22 < var26.field602) {
                     var10 += var26.field602 - var22;
                  }

                  if(var24 > var26.field607) {
                     var10 += var24 - var26.field607;
                  } else if(var24 < var26.field605) {
                     var10 += var26.field605 - var24;
                  }

                  if(var10 - 64 <= var26.field608 && field502 != 0 && var26.field603 == var5) {
                     var10 -= 64;
                     if(var10 < 0) {
                        var10 = 0;
                     }

                     var11 = (var26.field608 - var10) * field502 / var26.field608;
                     class58 var10000;
                     if(var26.field604 == null) {
                        if(var26.field609 >= 0) {
                           var10000 = (class58)null;
                           class58 var12 = class58.method1247(class31.field740, var26.field609, 0);
                           if(null != var12) {
                              class62 var13 = var12.method1252().method1280(class24.field628);
                              class64 var14 = class64.method1415(var13, 100, var11);
                              var14.method1304(-1);
                              class17.field252.method1152(var14);
                              var26.field604 = var14;
                           }
                        }
                     } else {
                        var26.field604.method1305(var11);
                     }

                     if(null == var26.field606) {
                        if(var26.field619 != null && (var26.field612 -= var25) <= 0) {
                           int var27 = (int)(Math.random() * (double)var26.field619.length);
                           var10000 = (class58)null;
                           class58 var28 = class58.method1247(class31.field740, var26.field619[var27], 0);
                           if(null != var28) {
                              class62 var29 = var28.method1252().method1280(class24.field628);
                              class64 var15 = class64.method1415(var29, 100, var11);
                              var15.method1304(0);
                              class17.field252.method1152(var15);
                              var26.field606 = var15;
                              var26.field612 = var26.field611 + (int)(Math.random() * (double)(var26.field614 - var26.field611));
                           }
                        }
                     } else {
                        var26.field606.method1305(var11);
                        if(!var26.field606.method3854()) {
                           var26.field606 = null;
                        }
                     }
                  } else {
                     if(null != var26.field604) {
                        class17.field252.method1137(var26.field604);
                        var26.field604 = null;
                     }

                     if(null != var26.field606) {
                        class17.field252.method1137(var26.field606);
                        var26.field606 = null;
                     }
                  }
               }
            }

            field362 = 0;
         } else if(40 == field295) {
            class10.method128("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(field295 == 45) {
            class10.method128("Please wait...", false);
         }
      } else {
         class134.method2806(class1.field28, class0.field4, class29.field692, var4);
      }

      Graphics var23;
      if(30 == field295 && 0 == field513 && !var4) {
         try {
            var23 = class125.field2039.getGraphics();

            for(var22 = 0; var22 < field491; ++var22) {
               if(field497[var22]) {
                  class75.field1385.vmethod1847(var23, field496[var22], field456[var22], field498[var22], field499[var22]);
                  field497[var22] = false;
               }
            }
         } catch (Exception var19) {
            class125.field2039.repaint();
         }
      } else if(field295 > 0) {
         try {
            var23 = class125.field2039.getGraphics();
            class75.field1385.vmethod1842(var23, 0, 0);

            for(var22 = 0; var22 < field491; ++var22) {
               field497[var22] = false;
            }
         } catch (Exception var18) {
            class125.field2039.repaint();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "506223985"
   )
   void method242() {
      if(class170.field2738 >= 4) {
         this.method2970("js5crc");
         field295 = 1000;
      } else {
         if(class170.field2739 >= 4) {
            if(field295 <= 5) {
               this.method2970("js5io");
               field295 = 1000;
               return;
            }

            field529 = 3000;
            class170.field2739 = 3;
         }

         if(--field529 + 1 <= 0) {
            try {
               if(0 == field317) {
                  field399 = class26.field648.method2811(class141.field2179, field572);
                  ++field317;
               }

               if(field317 == 1) {
                  if(field399.field2222 == 2) {
                     this.method244(-1);
                     return;
                  }

                  if(field399.field2222 == 1) {
                     ++field317;
                  }
               }

               if(field317 == 2) {
                  class56.field1201 = new class142((Socket)field399.field2223, class26.field648);
                  class118 var1 = new class118(5);
                  var1.method2438(15);
                  var1.method2441(108);
                  class56.field1201.method2932(var1.field1995, 0, 5);
                  ++field317;
                  class122.field2028 = class109.method2381();
               }

               if(field317 == 3) {
                  if(field295 > 5 && class56.field1201.method2940() <= 0) {
                     if(class109.method2381() - class122.field2028 > 30000L) {
                        this.method244(-2);
                        return;
                     }
                  } else {
                     int var3 = class56.field1201.method2929();
                     if(0 != var3) {
                        this.method244(var3);
                        return;
                     }

                     ++field317;
                  }
               }

               if(field317 == 4) {
                  class42.method883(class56.field1201, field295 > 20);
                  field399 = null;
                  class56.field1201 = null;
                  field317 = 0;
                  field436 = 0;
               }
            } catch (IOException var2) {
               this.method244(-3);
            }

         }
      }
   }

   static {
      field313 = class20.field579;
      field357 = class20.field579;
      field403 = 0;
      field317 = 0;
      field529 = 0;
      field436 = 0;
      field320 = 0;
      field570 = 0;
      field322 = 0;
      field323 = 0;
      field324 = new class34['耀'];
      field561 = 0;
      field326 = new int['耀'];
      field327 = 0;
      field328 = new int[250];
      field329 = new class121(5000);
      field330 = new class121(5000);
      field293 = new class121(15000);
      field332 = 0;
      field333 = 0;
      field334 = 0;
      field337 = 0;
      field336 = 0;
      field546 = 0;
      field554 = 0;
      field339 = 0;
      field304 = false;
      field372 = 0;
      field434 = 1;
      field343 = 0;
      field344 = 1;
      field345 = 0;
      field346 = new class107[4];
      field347 = false;
      field526 = new int[4][13][13];
      field349 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field283 = 0;
      field342 = 2;
      field352 = 0;
      field353 = 2;
      field354 = 0;
      field355 = 1;
      field377 = 0;
      field522 = 0;
      field331 = 2;
      field359 = 0;
      field360 = 1;
      field398 = 0;
      field362 = 0;
      field366 = 2301979;
      field367 = 5063219;
      field368 = 3353893;
      field369 = 7759444;
      field435 = false;
      field371 = 0;
      field555 = 128;
      field374 = 0;
      field505 = 0;
      field376 = 0;
      field415 = 0;
      field378 = 0;
      field379 = 50;
      field380 = 0;
      field381 = false;
      field551 = 0;
      field383 = 0;
      field384 = 50;
      field478 = new int[field384];
      field356 = new int[field384];
      field387 = new int[field384];
      field388 = new int[field384];
      field389 = new int[field384];
      field390 = new int[field384];
      field391 = new int[field384];
      field550 = new String[field384];
      field393 = new int[104][104];
      field407 = 0;
      field358 = 1;
      field396 = 1;
      field397 = 0;
      field479 = 0;
      field305 = 0;
      field400 = 0;
      field338 = 0;
      field402 = 0;
      field535 = 0;
      field533 = 0;
      field292 = 0;
      field406 = 0;
      field543 = false;
      field341 = 0;
      field471 = 0;
      field410 = new class2[2048];
      field477 = -1;
      field412 = 0;
      field413 = 0;
      field414 = new int[1000];
      field325 = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      field416 = new String[8];
      field348 = new boolean[8];
      field418 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field419 = -1;
      field420 = new class198[4][104][104];
      field409 = new class198();
      field422 = new class198();
      field423 = new class198();
      field424 = new int[25];
      field425 = new int[25];
      field426 = new int[25];
      field427 = 0;
      field308 = false;
      field430 = 0;
      field431 = new int[500];
      field432 = new int[500];
      field433 = new int[500];
      field523 = new int[500];
      field437 = new String[500];
      field365 = new String[500];
      field289 = -1;
      field315 = -1;
      field439 = 0;
      field440 = 50;
      field301 = 0;
      field442 = null;
      field408 = false;
      field444 = -1;
      field511 = -1;
      field446 = null;
      field447 = null;
      field448 = -1;
      field449 = new class195(8);
      field361 = 0;
      field451 = 0;
      field452 = null;
      field335 = 0;
      field454 = 0;
      field455 = 0;
      field450 = -1;
      field520 = false;
      field458 = false;
      field459 = false;
      field460 = null;
      field536 = null;
      field297 = null;
      field428 = 0;
      field464 = 0;
      field312 = null;
      field466 = false;
      field467 = -1;
      field468 = -1;
      field469 = false;
      field470 = -1;
      field321 = -1;
      field314 = false;
      field392 = 1;
      field474 = new int[32];
      field340 = 0;
      field476 = new int[32];
      field411 = 0;
      field463 = new int[32];
      field521 = 0;
      field480 = 0;
      field481 = 0;
      field482 = 0;
      field483 = 0;
      field484 = 0;
      field363 = 0;
      field486 = 0;
      field465 = new class198();
      field488 = new class198();
      field489 = new class198();
      field490 = new class195(512);
      field491 = 0;
      field492 = -2;
      field493 = new boolean[100];
      field497 = new boolean[100];
      field495 = new boolean[100];
      field496 = new int[100];
      field456 = new int[100];
      field498 = new int[100];
      field499 = new int[100];
      field513 = 0;
      field501 = 0L;
      field382 = true;
      field503 = 1;
      field504 = 1;
      field318 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field506 = 0;
      field507 = 0;
      field508 = "";
      field509 = new long[100];
      field510 = 0;
      field500 = 0;
      field512 = new int[128];
      field385 = new int[128];
      field514 = -1L;
      field515 = null;
      field516 = null;
      field517 = 1;
      field518 = 0;
      field519 = new int[1000];
      field563 = new int[1000];
      field395 = new class78[1000];
      field296 = 0;
      field319 = 0;
      field524 = 0;
      field525 = 255;
      field453 = -1;
      field527 = false;
      field300 = 127;
      field502 = 127;
      field530 = 0;
      field531 = new int[50];
      field532 = new int[50];
      field443 = new int[50];
      field534 = new int[50];
      field401 = new class58[50];
      field528 = false;
      field537 = new boolean[5];
      field538 = new int[5];
      field539 = new int[5];
      field540 = new int[5];
      field541 = new int[5];
      field370 = 256;
      field404 = 205;
      field544 = 256;
      field545 = 320;
      field462 = 1;
      field547 = 32767;
      field548 = 1;
      field549 = 32767;
      field441 = 0;
      field417 = 0;
      field552 = 0;
      field553 = 0;
      field487 = 0;
      field421 = 0;
      field386 = 0;
      field557 = new class17[400];
      field558 = new class194();
      field559 = 0;
      field560 = new class7[400];
      field475 = new class178();
      field562 = 1;
      field485 = 1;
      field564 = new class219[8];
      field461 = -1L;
      field566 = -1L;
      field567 = new class10();
      field568 = new int[50];
      field569 = new int[50];
   }

   @ObfuscatedName("u")
   void method244(int var1) {
      field399 = null;
      class56.field1201 = null;
      field317 = 0;
      if(field572 == class215.field3152) {
         field572 = class6.field111;
      } else {
         field572 = class215.field3152;
      }

      ++field436;
      if(field436 < 2 || var1 != 7 && var1 != 9) {
         if(field436 >= 2 && 6 == var1) {
            this.method2970("js5connect_outofdate");
            field295 = 1000;
         } else if(field436 >= 4) {
            if(field295 <= 5) {
               this.method2970("js5connect");
               field295 = 1000;
            } else {
               field529 = 3000;
            }
         }
      } else if(field295 <= 5) {
         this.method2970("js5connect_full");
         field295 = 1000;
      } else {
         field529 = 3000;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1326546176"
   )
   protected final void vmethod2969() {
      if(class3.field63.method209()) {
         class3.field63.method213();
      }

      if(null != class177.field2912) {
         class177.field2912.field203 = false;
      }

      class177.field2912 = null;
      if(class209.field3115 != null) {
         class209.field3115.method2948();
         class209.field3115 = null;
      }

      if(class136.field2113 != null) {
         class136 var1 = class136.field2113;
         synchronized(class136.field2113) {
            class136.field2113 = null;
         }
      }

      if(class139.field2164 != null) {
         class139 var10 = class139.field2164;
         synchronized(class139.field2164) {
            class139.field2164 = null;
         }
      }

      class185.field2998 = null;
      if(class47.field1070 != null) {
         class47.field1070.method1178();
      }

      if(class77.field1403 != null) {
         class77.field1403.method1178();
      }

      class86.method2048();
      Object var11 = class169.field2716;
      synchronized(class169.field2716) {
         if(0 != class169.field2718) {
            class169.field2718 = 1;

            try {
               class169.field2716.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      try {
         class148.field2243.method4091();

         for(int var12 = 0; var12 < class148.field2239; ++var12) {
            class128.field2055[var12].method4091();
         }

         class148.field2240.method4091();
         class148.field2241.method4091();
      } catch (Exception var8) {
         ;
      }

   }

   @ObfuscatedName("bz")
   static final void method306(class30 var0, int var1, int var2) {
      class83.method1863(var0.field704, var0.field696, var0.field705, var0.field698, var0.field697, var1, var2);
   }

   @ObfuscatedName("b")
   void method385() {
      if(1000 != field295) {
         boolean var1 = class120.method2682();
         if(!var1) {
            this.method242();
         }

      }
   }

   @ObfuscatedName("dt")
   static final class3 method460(int var0, int var1, int var2) {
      class3 var3 = new class3();
      var3.field66 = var1;
      var3.field61 = var2;
      field449.method3746(var3, (long)var0);
      class44.method939(var1);
      class172 var4 = class31.method698(var0);
      class114.method2400(var4);
      if(field452 != null) {
         class114.method2400(field452);
         field452 = null;
      }

      class107.method2371();
      class13.method154(class172.field2757[var0 >> 16], var4, false);
      class42.method878(var1);
      if(field448 != -1) {
         class18.method192(field448, 1);
      }

      return var3;
   }

   @ObfuscatedName("l")
   public static class45 method463(int var0) {
      class45 var1 = (class45)class45.field1049.method3711((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class45.field1043.method3214(19, var0);
         var1 = new class45();
         if(null != var2) {
            var1.method943(new class118(var2));
         }

         class45.field1049.method3713(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1956286702"
   )
   static void method556(int var0) {
      if(var0 != field295) {
         if(0 == field295) {
            class95.method2163();
         }

         if(20 == var0 || 40 == var0 || var0 == 45) {
            field320 = 0;
            field570 = 0;
            field322 = 0;
         }

         if(var0 != 20 && 40 != var0 && class177.field2911 != null) {
            class177.field2911.method2948();
            class177.field2911 = null;
         }

         if(field295 == 25) {
            field345 = 0;
            field372 = 0;
            field434 = 1;
            field343 = 0;
            field344 = 1;
         }

         if(5 != var0 && var0 != 10) {
            if(20 == var0) {
               class28.method655(class125.field2039, class95.field1640, class157.field2595, true, field295 == 11?4:0);
            } else if(11 == var0) {
               class28.method655(class125.field2039, class95.field1640, class157.field2595, false, 4);
            } else {
               class28.method656();
            }
         } else {
            class28.method655(class125.field2039, class95.field1640, class157.field2595, true, 0);
         }

         field295 = var0;
      }
   }

   @ObfuscatedName("a")
   static boolean method559(String var0) {
      if(null == var0) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }
}
