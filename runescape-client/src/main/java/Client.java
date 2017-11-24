import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -1790512893
   )
   static int field1058;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = 582161343
   )
   static int field1035;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      longValue = -4737036638527304955L
   )
   static long field1067;
   @ObfuscatedName("mu")
   static boolean[] field1059;
   @ObfuscatedName("ma")
   static boolean[] field1132;
   @ObfuscatedName("mm")
   static boolean[] field1099;
   @ObfuscatedName("kh")
   static boolean field991;
   @ObfuscatedName("mx")
   @Export("isResized")
   @Hook("resizeChanged")
   static boolean isResized;
   @ObfuscatedName("kx")
   static boolean field1046;
   @ObfuscatedName("om")
   static boolean field1095;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -60318167
   )
   static int field1029;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -770855971
   )
   static int field953;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -977613857
   )
   static int field1033;
   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1028;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 1507246697
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("ms")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("mp")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -1595218995
   )
   static int field1034;
   @ObfuscatedName("mw")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("mh")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 1783559357
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1698847697
   )
   static int field1052;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 1546874675
   )
   static int field1048;
   @ObfuscatedName("ml")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 1460382479
   )
   static int field1051;
   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "Lbd;"
   )
   static final class72 field875;
   @ObfuscatedName("ne")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("nr")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -340014319
   )
   static int field1103;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -1505801385
   )
   static int field1037;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = -1734200437
   )
   static int field1090;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 1775675247
   )
   static int field1022;
   @ObfuscatedName("lc")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field1010;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -107024293
   )
   static int field977;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = 1140311481
   )
   static int field1093;
   @ObfuscatedName("qr")
   static int[] field1131;
   @ObfuscatedName("qn")
   static int[] field888;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 1215870457
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("li")
   static boolean field1014;
   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "[Lbc;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = -2145716741
   )
   static int field1070;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 238768487
   )
   static int field986;
   @ObfuscatedName("lx")
   static int[] field1040;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -745694611
   )
   static int field1041;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 2060472277
   )
   static int field1104;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = -914443459
   )
   static int field1081;
   @ObfuscatedName("ob")
   static boolean field1100;
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   static PlayerComposition field1125;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -402874783
   )
   static int field985;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -1337344681
   )
   static int field1127;
   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field890;
   @ObfuscatedName("ot")
   static int[] field970;
   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   static class202 field1122;
   @ObfuscatedName("ox")
   static int[] field1096;
   @ObfuscatedName("ol")
   static int[] field930;
   @ObfuscatedName("ou")
   @ObfuscatedSignature(
      signature = "[Ldf;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 1314737925
   )
   static int field1113;
   @ObfuscatedName("oy")
   static int[] field1098;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -772373357
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -797410031
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 910605079
   )
   static int field1088;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      longValue = 6897632263343277765L
   )
   static long field1078;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -1439506157
   )
   static int field1009;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -756268797
   )
   static int field1024;
   @ObfuscatedName("nj")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("ns")
   static int[] field994;
   @ObfuscatedName("ny")
   static int[] field1084;
   @ObfuscatedName("ps")
   static short field1107;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -304413655
   )
   static int field1075;
   @ObfuscatedName("pv")
   static short field1106;
   @ObfuscatedName("lr")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("pi")
   static short field1112;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = 850391595
   )
   static int field961;
   @ObfuscatedName("pb")
   static short field1061;
   @ObfuscatedName("pd")
   static short field1111;
   @ObfuscatedName("pw")
   static short field1109;
   @ObfuscatedName("pa")
   static short field1036;
   @ObfuscatedName("pe")
   static short field926;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -2101807985
   )
   static int field1114;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = -818548393
   )
   static int field1115;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 143084651
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = -820592493
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("nb")
   static int[] field1077;
   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "[Lf;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("nl")
   static int[] field1055;
   @ObfuscatedName("mc")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field1054;
   @ObfuscatedName("na")
   static long[] field1073;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -1954891267
   )
   static int field1049;
   @ObfuscatedName("mo")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field1105;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 1564382179
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 432751581
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("qs")
   @ObfuscatedSignature(
      signature = "[Lbe;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -313770805
   )
   static int field1074;
   @ObfuscatedName("pk")
   static boolean[] field1101;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = 84686147
   )
   static int field1050;
   @ObfuscatedName("pf")
   static int[] field935;
   @ObfuscatedName("pu")
   static int[] field1102;
   @ObfuscatedName("pl")
   static int[] field1091;
   @ObfuscatedName("pm")
   static int[] field872;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = 1173838659
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("la")
   static int[] field1092;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -529373895
   )
   static int field894;
   @ObfuscatedName("nv")
   static String field1072;
   @ObfuscatedName("mj")
   static int[] field1008;
   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "Lbp;"
   )
   static class74 field1129;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfb;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("at")
   static boolean field940;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -2044727567
   )
   @Export("world")
   static int world;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1725016439
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -490533031
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bs")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bg")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 581783243
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 892934841
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("bf")
   static boolean field879;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 837440703
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      longValue = 8025919914142602797L
   )
   static long field1066;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -286327277
   )
   static int field1023;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -874930851
   )
   static int field883;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 818224087
   )
   static int field884;
   @ObfuscatedName("bw")
   static boolean field885;
   @ObfuscatedName("bp")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1428147207
   )
   static int field931;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -2082509017
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1582726851
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1199776299
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1484236507
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1157367515
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -2136533363
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1768129789
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -341051989
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("cb")
   static boolean field956;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   static class90 field897;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   static class90 field898;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1383724123
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1475503079
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1774530045
   )
   static int field902;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 137298663
   )
   static int field903;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 1365447793
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -747143869
   )
   static int field905;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1514555913
   )
   static int field896;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = -1670429849
   )
   static int field983;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   static class150 field1043;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 1022051695
   )
   static int field909;
   @ObfuscatedName("dl")
   static byte[] field1083;
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "[Lcj;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 1745601251
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dd")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -2031267283
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ep")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   public static final class100 field916;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 1242047419
   )
   static int field1108;
   @ObfuscatedName("ea")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static class283 field919;
   @ObfuscatedName("ej")
   static HashMap field920;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -1477034621
   )
   static int field921;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 13833023
   )
   static int field922;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -945563747
   )
   static int field923;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -611829937
   )
   static int field924;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1173542741
   )
   static int field955;
   @ObfuscatedName("fb")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fu")
   static int[][][] field928;
   @ObfuscatedName("fd")
   static final int[] field929;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 1563004509
   )
   static int field992;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = -2022525301
   )
   static int field1038;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 33072777
   )
   static int field982;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -977443699
   )
   static int field933;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -159386797
   )
   static int field934;
   @ObfuscatedName("gc")
   static boolean field973;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 855128903
   )
   static int field936;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 893030065
   )
   static int field997;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -479093555
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -513234043
   )
   static int field939;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -194024123
   )
   static int field1031;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 327089973
   )
   static int field941;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1761385709
   )
   static int field942;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -769728239
   )
   static int field943;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -265933753
   )
   static int field911;
   @ObfuscatedName("gs")
   static boolean field945;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1939339175
   )
   static int field946;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1459060307
   )
   static int field947;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -856806621
   )
   static int field948;
   @ObfuscatedName("gz")
   static int[] field949;
   @ObfuscatedName("gp")
   static int[] field950;
   @ObfuscatedName("gg")
   static int[] field951;
   @ObfuscatedName("ge")
   static int[] field952;
   @ObfuscatedName("hu")
   static int[] field910;
   @ObfuscatedName("hc")
   static int[] field954;
   @ObfuscatedName("hr")
   static int[] field913;
   @ObfuscatedName("hf")
   static String[] field876;
   @ObfuscatedName("ha")
   static int[][] field957;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 675749211
   )
   static int field958;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 1558668091
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 1527207807
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1039152631
   )
   static int field1064;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 1403144511
   )
   static int field962;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -515439579
   )
   static int field963;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 105515995
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 1942157077
   )
   static int field965;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1252061983
   )
   static int field966;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 975323595
   )
   static int field1076;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 207035995
   )
   static int field968;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 994921461
   )
   static int field969;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -1496419035
   )
   static int field1001;
   @ObfuscatedName("hz")
   static boolean field971;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -246957173
   )
   static int field1012;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 1115692699
   )
   static int field908;
   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "[Lbw;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1109771377
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -374141509
   )
   static int field976;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -134583033
   )
   static int field932;
   @ObfuscatedName("im")
   static int[] field978;
   @ObfuscatedName("it")
   static String field974;
   @ObfuscatedName("id")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("in")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("iv")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("ir")
   static int[] field944;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1005975397
   )
   static int field1094;
   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "[[[Lgs;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("iw")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ik")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("is")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1131076857
   )
   static int field1021;
   @ObfuscatedName("il")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 385951891
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("jn")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jd")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jc")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("jj")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jk")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ju")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jp")
   static boolean[] field889;
   @ObfuscatedName("jq")
   static boolean field1060;
   @ObfuscatedName("jm")
   static boolean field1002;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -699208551
   )
   static int field1003;
   @ObfuscatedName("jr")
   @ObfuscatedGetter(
      intValue = -466722593
   )
   static int field1004;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 146443757
   )
   static int field882;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -1751910463
   )
   static int field1006;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -702011731
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("jf")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 639806797
   )
   static int field917;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 843521337
   )
   static int field1011;
   @ObfuscatedName("km")
   static String field1042;
   @ObfuscatedName("kk")
   static String field1013;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 614260453
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 1618853897
   )
   static int field1016;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -1949809853
   )
   static int field927;
   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1018;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1323797235
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -476166197
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1968102981
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 1324260663
   )
   static int field1082;
   @ObfuscatedName("kf")
   static boolean field1079;
   @ObfuscatedName("ka")
   static boolean field967;
   @ObfuscatedName("kt")
   static boolean field907;
   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1026;
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1027;

   static {
      field940 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field879 = true;
      gameCycle = 0;
      field1066 = -1L;
      field1023 = -1;
      field883 = -1;
      field884 = -1;
      field885 = true;
      displayFps = false;
      field931 = 0;
      hintArrowTargetType = 0;
      hintArrowNpcTargetIdx = 0;
      hintArrowPlayerTargetIdx = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      hintArrowOffsetX = 0;
      hintArrowOffsetY = 0;
      field897 = class90.field1336;
      field898 = class90.field1336;
      loadingStage = 0;
      js5State = 0;
      field902 = 0;
      field903 = 0;
      loginState = 0;
      field905 = 0;
      field896 = 0;
      field983 = 0;
      field1043 = class150.field2112;
      field1083 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field916 = new class100();
      field1108 = 0;
      socketError = false;
      field919 = new class283();
      field920 = new HashMap();
      field921 = 0;
      field922 = 1;
      field923 = 0;
      field924 = 1;
      field955 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field928 = new int[4][13][13];
      field929 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field992 = 0;
      field1038 = 2301979;
      field982 = 5063219;
      field933 = 3353893;
      field934 = 7759444;
      field973 = false;
      field936 = 0;
      field997 = 128;
      mapAngle = 0;
      field939 = 0;
      field1031 = 0;
      field941 = 0;
      field942 = 0;
      field943 = 50;
      field911 = 0;
      field945 = false;
      field946 = 0;
      field947 = 0;
      field948 = 50;
      field949 = new int[field948];
      field950 = new int[field948];
      field951 = new int[field948];
      field952 = new int[field948];
      field910 = new int[field948];
      field954 = new int[field948];
      field913 = new int[field948];
      field876 = new String[field948];
      field957 = new int[104][104];
      field958 = 0;
      screenY = -1;
      screenX = -1;
      field1064 = 0;
      field962 = 0;
      field963 = 0;
      cursorState = 0;
      field965 = 0;
      field966 = 0;
      field1076 = 0;
      field968 = 0;
      field969 = 0;
      field1001 = 0;
      field971 = false;
      field1012 = 0;
      field908 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field976 = 0;
      field932 = 0;
      field978 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field944 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1094 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1021 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field889 = new boolean[500];
      field1060 = false;
      field1002 = false;
      field1003 = -1;
      field1004 = -1;
      field882 = 0;
      field1006 = 50;
      itemSelectionState = 0;
      field974 = null;
      spellSelected = false;
      field917 = -1;
      field1011 = -1;
      field1042 = null;
      field1013 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1016 = 0;
      field927 = 0;
      field1018 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1082 = -1;
      field1079 = false;
      field967 = false;
      field907 = false;
      field1026 = null;
      field1027 = null;
      field1028 = null;
      field1029 = 0;
      field953 = 0;
      field890 = null;
      field1046 = false;
      field1033 = -1;
      field1034 = -1;
      field991 = false;
      field1103 = -1;
      field1037 = -1;
      field1014 = false;
      cycleCntr = 1;
      field1040 = new int[32];
      field1041 = 0;
      interfaceItemTriggers = new int[32];
      field961 = 0;
      field1092 = new int[32];
      field894 = 0;
      chatCycle = 0;
      field977 = 0;
      field1048 = 0;
      field1049 = 0;
      field1050 = 0;
      field1051 = 0;
      field1052 = 0;
      field1010 = new Deque();
      field1054 = new Deque();
      field1105 = new Deque();
      widgetFlags = new HashTable(512);
      field1035 = 0;
      field1058 = -2;
      field1059 = new boolean[100];
      field1099 = new boolean[100];
      field1132 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1067 = 0L;
      isResized = true;
      field1008 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      field1070 = 0;
      field986 = 0;
      field1072 = "";
      field1073 = new long[100];
      field1074 = 0;
      field1075 = 0;
      field1055 = new int[128];
      field1077 = new int[128];
      field1078 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1081 = -1;
      field1024 = 0;
      field994 = new int[1000];
      field1084 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1088 = 0;
      field1113 = 255;
      field1090 = -1;
      field1095 = false;
      field1009 = 127;
      field1093 = 127;
      field985 = 0;
      field970 = new int[50];
      field1096 = new int[50];
      field930 = new int[50];
      field1098 = new int[50];
      audioEffects = new SoundEffect[50];
      field1100 = false;
      field1101 = new boolean[5];
      field1102 = new int[5];
      field935 = new int[5];
      field872 = new int[5];
      field1091 = new int[5];
      field1106 = 256;
      field1107 = 205;
      field1036 = 256;
      field1109 = 320;
      field926 = 1;
      field1111 = 32767;
      field1112 = 1;
      field1061 = 32767;
      field1114 = 0;
      field1115 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1022 = 0;
      friends = new Friend[400];
      field1122 = new class202();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1125 = new PlayerComposition();
      field1104 = -1;
      field1127 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1129 = new class74();
      field875 = new class72();
      field1131 = new int[50];
      field888 = new int[50];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-318420935"
   )
   protected final void vmethod1205() {
      field1067 = ServerPacket.currentTimeMs() + 500L;
      this.method1206();
      if(widgetRoot != -1) {
         this.method1257(true);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-84214018"
   )
   protected final void vmethod1196() {
      class86.method1751(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      class48.field591 = socketType == 0?43594:world + 40000;
      field909 = socketType == 0?443:world + 50000;
      class184.myWorldPort = class48.field591;
      PlayerComposition.colorsToFind = class221.field2708;
      PlayerComposition.colorsToReplace = class221.field2710;
      class54.field635 = class221.field2706;
      PlayerComposition.field2692 = class221.field2707;
      class221.field2711 = new class148();
      this.method858();
      this.method859();
      class44.field555 = this.method856();
      GrandExchangeOffer.field299 = new IndexFile(255, class156.field2157, class156.field2154, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = class46.getPreferencesFile("", class36.field483.field3276, false);
         byte[] var4 = new byte[(int)var2.length()];

         int var6;
         for(int var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.read(var4, var5, var4.length - var5);
            if(var6 == -1) {
               throw new IOException();
            }
         }

         var3 = new Preferences(new Buffer(var4));
      } catch (Exception var9) {
         ;
      }

      try {
         if(var2 != null) {
            var2.close();
         }
      } catch (Exception var8) {
         ;
      }

      RSCanvas.preferences = var3;
      this.method857();
      ScriptVarType.method26(this, ItemContainer.field749);
      if(socketType != 0) {
         displayFps = true;
      }

      int var7 = RSCanvas.preferences.screenType;
      field1067 = 0L;
      if(var7 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      if(ISAACCipher.method3604() == 1) {
         class287.clientInstance.method854(765, 503);
      } else {
         class287.clientInstance.method854(7680, 2160);
      }

      if(gameState >= 25) {
         PacketNode var10 = class218.method4105(ClientPacket.field2321, field916.field1470);
         var10.packetBuffer.putByte(ISAACCipher.method3604());
         var10.packetBuffer.putShort(class86.canvasWidth);
         var10.packetBuffer.putShort(GameEngine.canvasHeight);
         field916.method1925(var10);
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "713150438"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      class61.method1088();
      MilliTimer.method3053();
      class25.method190();
      ItemLayer.method2508();
      IndexData.method4405();
      int var1;
      if(class44.field555 != null) {
         var1 = class44.field555.vmethod3103();
         field1052 = var1;
      }

      if(gameState == 0) {
         class72.load();
         CombatInfoListHolder.timer.vmethod3107();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field667[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field668[var1] = 0L;
         }

         GameEngine.field681 = 0;
      } else if(gameState == 5) {
         class22.method173(this);
         class72.load();
         CombatInfoListHolder.timer.vmethod3107();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field667[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field668[var1] = 0L;
         }

         GameEngine.field681 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class22.method173(this);
            this.method1203();
         } else if(gameState == 25) {
            class90.method1773();
         }
      } else {
         class22.method173(this);
      }

      if(gameState == 30) {
         this.method1204();
      } else if(gameState == 40 || gameState == 45) {
         this.method1203();
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1225770057"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1198(boolean var1) {
      boolean var2;
      label190: {
         try {
            if(class210.field2598 == 2) {
               if(class182.field2513 == null) {
                  class182.field2513 = Track1.getMusicFile(class3.field22, class8.field237, class210.field2599);
                  if(class182.field2513 == null) {
                     var2 = false;
                     break label190;
                  }
               }

               if(class87.field1316 == null) {
                  class87.field1316 = new class111(class210.field2597, class210.field2594);
               }

               if(class210.field2595.method3859(class182.field2513, class210.field2596, class87.field1316, 22050)) {
                  class210.field2595.method3864();
                  class210.field2595.method3857(class111.field1588);
                  class210.field2595.method3892(class182.field2513, class20.field322);
                  class210.field2598 = 0;
                  class182.field2513 = null;
                  class87.field1316 = null;
                  class3.field22 = null;
                  var2 = true;
                  break label190;
               }
            }
         } catch (Exception var7) {
            var7.printStackTrace();
            class210.field2595.method3863();
            class210.field2598 = 0;
            class182.field2513 = null;
            class87.field1316 = null;
            class3.field22 = null;
         }

         var2 = false;
      }

      if(var2 && field1095 && class3.soundSystem0 != null) {
         class3.soundSystem0.method2140();
      }

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1067 && ServerPacket.currentTimeMs() > field1067) {
         var4 = ISAACCipher.method3604();
         field1067 = 0L;
         if(var4 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         if(ISAACCipher.method3604() == 1) {
            class287.clientInstance.method854(765, 503);
         } else {
            class287.clientInstance.method854(7680, 2160);
         }

         if(gameState >= 25) {
            PacketNode var5 = class218.method4105(ClientPacket.field2321, field916.field1470);
            var5.packetBuffer.putByte(ISAACCipher.method3604());
            var5.packetBuffer.putShort(class86.canvasWidth);
            var5.packetBuffer.putShort(GameEngine.canvasHeight);
            field916.method1925(var5);
         }
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1059[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class91.loadingBarPercentage, class91.loadingText, var1);
      } else if(gameState == 5) {
         GroundObject.drawLoginScreen(World.field1226, class13.field262, KeyFocusListener.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            GroundObject.drawLoginScreen(World.field1226, class13.field262, KeyFocusListener.font_p12full, var1);
         } else if(gameState == 25) {
            if(field955 == 1) {
               if(field921 > field922) {
                  field922 = field921;
               }

               var4 = (field922 * 50 - field921 * 50) / field922;
               class148.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field955 == 2) {
               if(field923 > field924) {
                  field924 = field923;
               }

               var4 = (field924 * 50 - field923 * 50) / field924 + 50;
               class148.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class148.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1207();
         } else if(gameState == 40) {
            class148.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class148.drawStatusBox("Please wait...", false);
         }
      } else {
         GroundObject.drawLoginScreen(World.field1226, class13.field262, KeyFocusListener.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < field1035; ++var4) {
            if(field1099[var4]) {
               class86.field1309.vmethod5225(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1099[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class86.field1309.vmethod5222(0, 0);

         for(var4 = 0; var4 < field1035; ++var4) {
            field1099[var4] = false;
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "20949"
   )
   protected final void vmethod1199() {
      if(class28.chatMessages.changed()) {
         class28.chatMessages.serialize();
      }

      if(class269.field3696 != null) {
         class269.field3696.field823 = false;
      }

      class269.field3696 = null;
      field916.method1930();
      MessageNode.method1139();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      class44.field555 = null;
      if(class3.soundSystem0 != null) {
         class3.soundSystem0.method2097();
      }

      if(FileOnDisk.soundSystem1 != null) {
         FileOnDisk.soundSystem1.method2097();
      }

      if(class245.field3327 != null) {
         class245.field3327.close();
      }

      FaceNormal.method2996();
      if(class221.field2711 != null) {
         class221.field2711.method3023();
         class221.field2711 = null;
      }

      class139.method2983();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1585253082"
   )
   protected final void vmethod1194() {
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = new Parameters[]{Parameters.field3761, Parameters.field3756, Parameters.field3755, Parameters.field3758, Parameters.field3766, Parameters.field3759, Parameters.field3769, Parameters.field3764, Parameters.field3754, Parameters.field3767, Parameters.field3765, Parameters.field3760, Parameters.field3757, Parameters.field3768, Parameters.field3763};
         Parameters[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            Parameters var4 = var2[var3];
            String var5 = this.getParameter(var4.key);
            if(var5 != null) {
               switch(Integer.parseInt(var4.key)) {
               case 1:
                  InvType.field3356 = var5;
               case 2:
               case 5:
               case 11:
               default:
                  break;
               case 3:
                  class29.field397 = Integer.parseInt(var5);
                  break;
               case 4:
                  Preferences.sessionToken = var5;
                  break;
               case 6:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 7:
                  languageId = Integer.parseInt(var5);
                  break;
               case 8:
                  class239[] var6 = new class239[]{class239.field3274, class239.field3270, class239.field3271, class239.field3272, class239.field3275, class239.field3273};
                  class36.field483 = (class239)class94.forOrdinal(var6, Integer.parseInt(var5));
                  if(class36.field483 == class239.field3275) {
                     class236.field3239 = class298.field3916;
                  } else {
                     class236.field3239 = class298.field3915;
                  }
                  break;
               case 9:
                  class61.field738 = CacheFile.method2451(Integer.parseInt(var5));
                  break;
               case 10:
                  Ignore.field816 = Integer.parseInt(var5);
                  break;
               case 12:
                  socketType = Integer.parseInt(var5);
                  break;
               case 13:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 14:
                  flags = Integer.parseInt(var5);
                  break;
               case 15:
                  world = Integer.parseInt(var5);
               }
            }
         }

         class39.method551();
         class19.host = this.getCodeBase().getHost();
         String var10 = class61.field738.identifier;
         byte var7 = 0;

         try {
            class14.method89("oldschool", var10, var7, 17);
         } catch (Exception var9) {
            Item.method1829((String)null, var9);
         }

         class287.clientInstance = this;
         this.initialize(765, 503, 159);
      }
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         long var2 = ServerPacket.currentTimeMs();
         int var4 = (int)(var2 - class245.field3334);
         class245.field3334 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class245.field3336 += var4;
         boolean var1;
         if(class245.field3333 == 0 && class245.field3328 == 0 && class245.field3331 == 0 && class245.field3341 == 0) {
            var1 = true;
         } else if(class245.field3327 == null) {
            var1 = false;
         } else {
            try {
               label247: {
                  if(class245.field3336 > 30000) {
                     throw new IOException();
                  }

                  FileRequest var5;
                  Buffer var6;
                  while(class245.field3328 < 20 && class245.field3341 > 0) {
                     var5 = (FileRequest)class245.field3323.method3707();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class245.field3327.queueForWrite(var6.payload, 0, 4);
                     class245.field3338.put(var5, var5.hash);
                     --class245.field3341;
                     ++class245.field3328;
                  }

                  while(class245.field3333 < 20 && class245.field3331 > 0) {
                     var5 = (FileRequest)class245.field3329.peek();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class245.field3327.queueForWrite(var6.payload, 0, 4);
                     var5.unlinkDual();
                     class245.field3332.put(var5, var5.hash);
                     --class245.field3331;
                     ++class245.field3333;
                  }

                  for(int var18 = 0; var18 < 100; ++var18) {
                     int var19 = class245.field3327.available();
                     if(var19 < 0) {
                        throw new IOException();
                     }

                     if(var19 == 0) {
                        break;
                     }

                     class245.field3336 = 0;
                     byte var7 = 0;
                     if(class259.currentRequest == null) {
                        var7 = 8;
                     } else if(class245.field3326 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class245.field3322.offset;
                        if(var8 > var19) {
                           var8 = var19;
                        }

                        class245.field3327.read(class245.field3322.payload, class245.field3322.offset, var8);
                        if(class245.field3340 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class245.field3322.payload[class245.field3322.offset + var9] ^= class245.field3340;
                           }
                        }

                        class245.field3322.offset += var8;
                        if(class245.field3322.offset < var7) {
                           break;
                        }

                        if(class259.currentRequest == null) {
                           class245.field3322.offset = 0;
                           var9 = class245.field3322.readUnsignedByte();
                           var10 = class245.field3322.readUnsignedShort();
                           int var11 = class245.field3322.readUnsignedByte();
                           var12 = class245.field3322.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           FileRequest var15 = (FileRequest)class245.field3338.get(var13);
                           class243.field3311 = true;
                           if(var15 == null) {
                              var15 = (FileRequest)class245.field3332.get(var13);
                              class243.field3311 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class259.currentRequest = var15;
                           class245.field3335 = new Buffer(var12 + var16 + class259.currentRequest.padding);
                           class245.field3335.putByte(var11);
                           class245.field3335.putInt(var12);
                           class245.field3326 = 8;
                           class245.field3322.offset = 0;
                        } else if(class245.field3326 == 0) {
                           if(class245.field3322.payload[0] == -1) {
                              class245.field3326 = 1;
                              class245.field3322.offset = 0;
                           } else {
                              class259.currentRequest = null;
                           }
                        }
                     } else {
                        var8 = class245.field3335.payload.length - class259.currentRequest.padding;
                        var9 = 512 - class245.field3326;
                        if(var9 > var8 - class245.field3335.offset) {
                           var9 = var8 - class245.field3335.offset;
                        }

                        if(var9 > var19) {
                           var9 = var19;
                        }

                        class245.field3327.read(class245.field3335.payload, class245.field3335.offset, var9);
                        if(class245.field3340 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class245.field3335.payload[class245.field3335.offset + var10] ^= class245.field3340;
                           }
                        }

                        class245.field3335.offset += var9;
                        class245.field3326 += var9;
                        if(var8 == class245.field3335.offset) {
                           if(class259.currentRequest.hash == 16711935L) {
                              class245.field3339 = class245.field3335;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var20 = class245.field3324[var10];
                                 if(var20 != null) {
                                    class245.field3339.offset = var10 * 8 + 5;
                                    var12 = class245.field3339.readInt();
                                    int var21 = class245.field3339.readInt();
                                    var20.setInformation(var12, var21);
                                 }
                              }
                           } else {
                              class245.field3337.reset();
                              class245.field3337.update(class245.field3335.payload, 0, var8);
                              var10 = (int)class245.field3337.getValue();
                              if(var10 != class259.currentRequest.crc) {
                                 try {
                                    class245.field3327.close();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class245.field3325;
                                 class245.field3327 = null;
                                 class245.field3340 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label247;
                              }

                              class245.field3325 = 0;
                              class245.field3342 = 0;
                              class259.currentRequest.index.method4384((int)(class259.currentRequest.hash & 65535L), class245.field3335.payload, (class259.currentRequest.hash & 16711680L) == 16711680L, class243.field3311);
                           }

                           class259.currentRequest.unlink();
                           if(class243.field3311) {
                              --class245.field3328;
                           } else {
                              --class245.field3333;
                           }

                           class245.field3326 = 0;
                           class259.currentRequest = null;
                           class245.field3335 = null;
                        } else {
                           if(class245.field3326 != 512) {
                              break;
                           }

                           class245.field3326 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class245.field3327.close();
               } catch (Exception var22) {
                  ;
               }

               ++class245.field3342;
               class245.field3327 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1341();
         }

      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1088742199"
   )
   void method1341() {
      if(class245.field3325 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class245.field3342 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field902 = 3000;
            class245.field3342 = 3;
         }

         if(--field902 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class86.socket = class277.taskManager.createSocket(class19.host, class184.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class86.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class86.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  rssocket = new RSSocket((Socket)class86.socket.value, class277.taskManager, 5000);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(159);
                  rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  class96.field1437 = ServerPacket.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && rssocket.available() <= 0) {
                     if(ServerPacket.currentTimeMs() - class96.field1437 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var5 = rssocket.readByte();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var10 = rssocket;
                  boolean var2 = gameState > 20;
                  if(class245.field3327 != null) {
                     try {
                        class245.field3327.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class245.field3327 = null;
                  }

                  class245.field3327 = var10;
                  class156.sendConInfo(var2);
                  class245.field3322.offset = 0;
                  class259.currentRequest = null;
                  class245.field3335 = null;
                  class245.field3326 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class245.field3338.method3707();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class245.field3332.method3707();
                           if(var3 == null) {
                              if(class245.field3340 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class245.field3340);
                                    var11.putShort(0);
                                    class245.field3327.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class245.field3327.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class245.field3342;
                                    class245.field3327 = null;
                                 }
                              }

                              class245.field3336 = 0;
                              class245.field3334 = ServerPacket.currentTimeMs();
                              class86.socket = null;
                              rssocket = null;
                              js5State = 0;
                              field903 = 0;
                              return;
                           }

                           class245.field3329.setHead(var3);
                           class245.field3330.put(var3, var3.hash);
                           ++class245.field3331;
                           --class245.field3333;
                        }
                     }

                     class245.field3323.put(var3, var3.hash);
                     ++class245.field3341;
                     --class245.field3328;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1369622276"
   )
   @Export("error")
   void error(int var1) {
      class86.socket = null;
      rssocket = null;
      js5State = 0;
      if(class184.myWorldPort == class48.field591) {
         class184.myWorldPort = field909;
      } else {
         class184.myWorldPort = class48.field591;
      }

      ++field903;
      if(field903 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field902 = 3000;
         }
      } else if(field903 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field903 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field902 = 3000;
         }
      }

   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1382813056"
   )
   final void method1203() {
      RSSocket var1 = field916.method1933();
      PacketBuffer var2 = field916.field1465;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               var1.close();
               var1 = null;
            }

            FrameMap.field1951 = null;
            socketError = false;
            field905 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(FrameMap.field1951 == null) {
               FrameMap.field1951 = class277.taskManager.createSocket(class19.host, class184.myWorldPort);
            }

            if(FrameMap.field1951.status == 2) {
               throw new IOException();
            }

            if(FrameMap.field1951.status == 1) {
               field916.method1929(new RSSocket((Socket)FrameMap.field1951.value, class277.taskManager, 5000));
               var1 = field916.method1933();
               FrameMap.field1951 = null;
               loginState = 2;
            }
         }

         PacketNode var3;
         if(loginState == 2) {
            field916.method1926();
            var3 = class189.method3610();
            var3.packetBuffer.putByte(class168.field2406.field2403);
            field916.method1925(var3);
            field916.method1927();
            var2.offset = 0;
            loginState = 3;
         }

         int var12;
         if(loginState == 3) {
            if(class3.soundSystem0 != null) {
               class3.soundSystem0.method2096();
            }

            if(FileOnDisk.soundSystem1 != null) {
               FileOnDisk.soundSystem1.method2096();
            }

            var12 = var1.readByte();
            if(class3.soundSystem0 != null) {
               class3.soundSystem0.method2096();
            }

            if(FileOnDisk.soundSystem1 != null) {
               FileOnDisk.soundSystem1.method2096();
            }

            if(var12 != 0) {
               class28.method236(var12);
               return;
            }

            var2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(var2.offset < 8) {
               var12 = var1.available();
               if(var12 > 8 - var2.offset) {
                  var12 = 8 - var2.offset;
               }

               if(var12 > 0) {
                  var1.read(var2.payload, var2.offset, var12);
                  var2.offset += var12;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               Occluder.field2064 = var2.readLong();
               loginState = 5;
            }
         }

         int var7;
         int var9;
         if(loginState == 5) {
            field916.field1465.offset = 0;
            field916.method1926();
            PacketBuffer var19 = new PacketBuffer(500);
            int[] var4 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Occluder.field2064 >> 32), (int)(Occluder.field2064 & -1L)};
            var19.offset = 0;
            var19.putByte(1);
            var19.putByte(field1043.rsOrdinal());
            var19.putInt(var4[0]);
            var19.putInt(var4[1]);
            var19.putInt(var4[2]);
            var19.putInt(var4[3]);
            switch(field1043.field2113) {
            case 0:
               LinkedHashMap var14 = RSCanvas.preferences.preferences;
               String var8 = class91.username;
               var9 = var8.length();
               int var10 = 0;

               for(int var11 = 0; var11 < var9; ++var11) {
                  var10 = (var10 << 5) - var10 + var8.charAt(var11);
               }

               var19.putInt(((Integer)var14.get(Integer.valueOf(var10))).intValue());
               var19.offset += 4;
               break;
            case 1:
            case 2:
               var19.put24bitInt(class28.field390);
               var19.offset += 5;
               break;
            case 3:
               var19.offset += 8;
            }

            var19.putString(class91.password);
            var19.encryptRsa(class89.field1331, class89.field1330);
            PacketNode var5 = class189.method3610();
            var5.packetBuffer.offset = 0;
            if(gameState == 40) {
               var5.packetBuffer.putByte(class168.field2400.field2403);
            } else {
               var5.packetBuffer.putByte(class168.field2402.field2403);
            }

            var5.packetBuffer.putShort(0);
            int var6 = var5.packetBuffer.offset;
            var5.packetBuffer.putInt(159);
            var5.packetBuffer.putBytes(var19.payload, 0, var19.offset);
            var7 = var5.packetBuffer.offset;
            var5.packetBuffer.putString(class91.username);
            var5.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var5.packetBuffer.putShort(class86.canvasWidth);
            var5.packetBuffer.putShort(GameEngine.canvasHeight);
            class90.method1776(var5.packetBuffer);
            var5.packetBuffer.putString(Preferences.sessionToken);
            var5.packetBuffer.putInt(class29.field397);
            Buffer var29 = new Buffer(class256.field3447.method5587());
            class256.field3447.method5589(var29);
            var5.packetBuffer.putBytes(var29.payload, 0, var29.payload.length);
            var5.packetBuffer.putByte(Ignore.field816);
            var5.packetBuffer.putInt(0);
            var5.packetBuffer.putInt(class163.indexInterfaces.crc);
            var5.packetBuffer.putInt(class10.indexSoundEffects.crc);
            var5.packetBuffer.putInt(Player.configsIndex.crc);
            var5.packetBuffer.putInt(class45.field561.crc);
            var5.packetBuffer.putInt(class47.field576.crc);
            var5.packetBuffer.putInt(PlayerComposition.indexMaps.crc);
            var5.packetBuffer.putInt(RSCanvas.indexTrack1.crc);
            var5.packetBuffer.putInt(MouseInput.indexModels.crc);
            var5.packetBuffer.putInt(ContextMenuRow.indexSprites.crc);
            var5.packetBuffer.putInt(class64.indexTextures.crc);
            var5.packetBuffer.putInt(WorldMapType2.field500.crc);
            var5.packetBuffer.putInt(class35.indexTrack2.crc);
            var5.packetBuffer.putInt(class1.indexScripts.crc);
            var5.packetBuffer.putInt(class44.field550.crc);
            var5.packetBuffer.putInt(class18.vorbisIndex.crc);
            var5.packetBuffer.putInt(Player.field861.crc);
            var5.packetBuffer.putInt(class46.indexWorldMap.crc);
            var5.packetBuffer.encryptXtea(var4, var7, var5.packetBuffer.offset);
            var5.packetBuffer.method3498(var5.packetBuffer.offset - var6);
            field916.method1925(var5);
            field916.method1927();
            field916.field1470 = new ISAACCipher(var4);

            for(var9 = 0; var9 < 4; ++var9) {
               var4[var9] += 50;
            }

            var2.seed(var4);
            loginState = 6;
         }

         if(loginState == 6 && var1.available() > 0) {
            var12 = var1.readByte();
            if(var12 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var12 == 2) {
               loginState = 9;
            } else if(var12 == 15 && gameState == 40) {
               field916.packetLength = -1;
               loginState = 13;
            } else if(var12 == 23 && field896 < 1) {
               ++field896;
               loginState = 0;
            } else {
               if(var12 != 29) {
                  class28.method236(var12);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && var1.available() > 0) {
            field983 = (var1.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field905 = 0;
            NPC.method1749("You have only just left another world.", "Your profile will be transferred in:", field983 / 60 + " seconds.");
            if(--field983 <= 0) {
               loginState = 0;
            }

         } else {
            boolean var13;
            int var31;
            if(loginState == 9 && var1.available() >= 13) {
               boolean var32 = var1.readByte() == 1;
               var1.read(var2.payload, 0, 4);
               var2.offset = 0;
               var13 = false;
               if(var32) {
                  var31 = var2.readOpcode() << 24;
                  var31 |= var2.readOpcode() << 16;
                  var31 |= var2.readOpcode() << 8;
                  var31 |= var2.readOpcode();
                  String var33 = class91.username;
                  var7 = var33.length();
                  int var15 = 0;
                  var9 = 0;

                  while(true) {
                     if(var9 >= var7) {
                        if(RSCanvas.preferences.preferences.size() >= 10 && !RSCanvas.preferences.preferences.containsKey(Integer.valueOf(var15))) {
                           Iterator var30 = RSCanvas.preferences.preferences.entrySet().iterator();
                           var30.next();
                           var30.remove();
                        }

                        RSCanvas.preferences.preferences.put(Integer.valueOf(var15), Integer.valueOf(var31));
                        break;
                     }

                     var15 = (var15 << 5) - var15 + var33.charAt(var9);
                     ++var9;
                  }
               }

               if(class91.field1366) {
                  RSCanvas.preferences.field1234 = class91.username;
               } else {
                  RSCanvas.preferences.field1234 = null;
               }

               class64.method1103();
               rights = var1.readByte();
               field1079 = var1.readByte() == 1;
               localInteractingIndex = var1.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += var1.readByte();
               field976 = var1.readByte();
               var1.read(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var25 = new ServerPacket[]{ServerPacket.field2264, ServerPacket.field2230, ServerPacket.field2221, ServerPacket.field2293, ServerPacket.field2222, ServerPacket.field2224, ServerPacket.field2275, ServerPacket.field2226, ServerPacket.field2227, ServerPacket.field2228, ServerPacket.field2229, ServerPacket.field2282, ServerPacket.field2265, ServerPacket.field2241, ServerPacket.field2269, ServerPacket.field2234, ServerPacket.field2268, ServerPacket.field2236, ServerPacket.field2237, ServerPacket.field2238, ServerPacket.field2239, ServerPacket.field2240, ServerPacket.field2260, ServerPacket.field2242, ServerPacket.field2243, ServerPacket.field2231, ServerPacket.field2245, ServerPacket.field2246, ServerPacket.field2247, ServerPacket.field2232, ServerPacket.field2249, ServerPacket.field2250, ServerPacket.field2251, ServerPacket.field2252, ServerPacket.field2262, ServerPacket.field2254, ServerPacket.field2255, ServerPacket.field2244, ServerPacket.field2258, ServerPacket.field2233, ServerPacket.field2259, ServerPacket.field2286, ServerPacket.field2261, ServerPacket.field2219, ServerPacket.field2263, ServerPacket.field2301, ServerPacket.field2223, ServerPacket.field2266, ServerPacket.field2267, ServerPacket.field2235, ServerPacket.field2272, ServerPacket.field2270, ServerPacket.field2271, ServerPacket.field2276, ServerPacket.field2273, ServerPacket.field2274, ServerPacket.field2256, ServerPacket.field2248, ServerPacket.field2277, ServerPacket.field2278, ServerPacket.field2279, ServerPacket.field2280, ServerPacket.field2281, ServerPacket.field2290, ServerPacket.field2283, ServerPacket.field2284, ServerPacket.field2285, ServerPacket.field2257, ServerPacket.field2287, ServerPacket.field2288, ServerPacket.field2225, ServerPacket.field2289, ServerPacket.field2291, ServerPacket.field2292, ServerPacket.field2253, ServerPacket.field2294, ServerPacket.field2295, ServerPacket.field2296, ServerPacket.field2297, ServerPacket.field2298, ServerPacket.field2299};
               var7 = var2.method3564();
               if(var7 < 0 || var7 >= var25.length) {
                  throw new IOException(var7 + " " + var2.offset);
               }

               field916.serverPacket = var25[var7];
               field916.packetLength = field916.serverPacket.packetLength;
               var1.read(var2.payload, 0, 2);
               var2.offset = 0;
               field916.packetLength = var2.readUnsignedShort();

               try {
                  class52.method783(class287.clientInstance, "zap");
               } catch (Throwable var17) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(var1.available() >= field916.packetLength) {
                  var2.offset = 0;
                  var1.read(var2.payload, 0, field916.packetLength);
                  field919.method5093();
                  field1066 = -1L;
                  field884 = -1;
                  class269.field3696.field818 = 0;
                  class43.field548 = true;
                  field885 = true;
                  field1078 = -1L;
                  CombatInfo1.method1590();
                  field916.method1926();
                  field916.field1465.offset = 0;
                  field916.serverPacket = null;
                  field916.field1476 = null;
                  field916.field1475 = null;
                  field916.field1478 = null;
                  field916.packetLength = 0;
                  field916.field1474 = 0;
                  field931 = 0;
                  field1108 = 0;
                  hintArrowTargetType = 0;
                  ItemContainer.method1100();
                  class31.method272(0);
                  class96.chatLineMap.clear();
                  class96.field1434.clear();
                  class96.field1435.method3821();
                  class96.field1436 = 0;
                  itemSelectionState = 0;
                  spellSelected = false;
                  field985 = 0;
                  mapAngle = 0;
                  field1088 = 0;
                  field1081 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  field897 = class90.field1336;
                  field898 = class90.field1336;
                  npcIndexesCount = 0;
                  Player.method1174();

                  for(var12 = 0; var12 < 2048; ++var12) {
                     cachedPlayers[var12] = null;
                  }

                  for(var12 = 0; var12 < 32768; ++var12) {
                     cachedNPCs[var12] = null;
                  }

                  field1094 = -1;
                  projectiles.clear();
                  graphicsObjectDeque.clear();

                  int var16;
                  for(var12 = 0; var12 < 4; ++var12) {
                     for(var31 = 0; var31 < 104; ++var31) {
                        for(var16 = 0; var16 < 104; ++var16) {
                           groundItemDeque[var12][var31][var16] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  field1022 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var12 = 0; var12 < VarPlayerType.field3357; ++var12) {
                     VarPlayerType var28 = (VarPlayerType)VarPlayerType.varplayers.get((long)var12);
                     VarPlayerType var24;
                     if(var28 != null) {
                        var24 = var28;
                     } else {
                        byte[] var34 = VarPlayerType.varplayer_ref.getConfigData(16, var12);
                        var28 = new VarPlayerType();
                        if(var34 != null) {
                           var28.decode(new Buffer(var34));
                        }

                        VarPlayerType.varplayers.put(var28, (long)var12);
                        var24 = var28;
                     }

                     if(var24 != null) {
                        class218.settings[var12] = 0;
                        class218.widgetSettings[var12] = 0;
                     }
                  }

                  class28.chatMessages.reset();
                  field1082 = -1;
                  if(widgetRoot != -1) {
                     var12 = widgetRoot;
                     if(var12 != -1 && class56.validInterfaces[var12]) {
                        ItemContainer.widgetIndex.method4278(var12);
                        if(class11.widgets[var12] != null) {
                           var13 = true;

                           for(var16 = 0; var16 < class11.widgets[var12].length; ++var16) {
                              if(class11.widgets[var12][var16] != null) {
                                 if(class11.widgets[var12][var16].type != 2) {
                                    class11.widgets[var12][var16] = null;
                                 } else {
                                    var13 = false;
                                 }
                              }
                           }

                           if(var13) {
                              class11.widgets[var12] = null;
                           }

                           class56.validInterfaces[var12] = false;
                        }
                     }
                  }

                  for(WidgetNode var21 = (WidgetNode)componentTable.method3707(); var21 != null; var21 = (WidgetNode)componentTable.method3703()) {
                     class39.method552(var21, true);
                  }

                  widgetRoot = -1;
                  componentTable = new HashTable(8);
                  field1018 = null;
                  ItemContainer.method1100();
                  field1125.method4125((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var12 = 0; var12 < 8; ++var12) {
                     playerOptions[var12] = null;
                     playerOptionsPriorities[var12] = false;
                  }

                  ItemContainer.itemContainers = new HashTable(32);
                  field879 = true;

                  for(var12 = 0; var12 < 100; ++var12) {
                     field1059[var12] = true;
                  }

                  var3 = class218.method4105(ClientPacket.field2321, field916.field1470);
                  var3.packetBuffer.putByte(ISAACCipher.method3604());
                  var3.packetBuffer.putShort(class86.canvasWidth);
                  var3.packetBuffer.putShort(GameEngine.canvasHeight);
                  field916.method1925(var3);
                  clanChatOwner = null;
                  class61.clanChatCount = 0;
                  class188.clanMembers = null;

                  for(var12 = 0; var12 < 8; ++var12) {
                     grandExchangeOffers[var12] = new GrandExchangeOffer();
                  }

                  BaseVarType.field27 = null;
                  class81.initializeGPI(var2);
                  class44.field554 = -1;
                  Tile.xteaChanged(false, var2);
                  field916.serverPacket = null;
               }

            } else {
               if(loginState == 11 && var1.available() >= 2) {
                  var2.offset = 0;
                  var1.read(var2.payload, 0, 2);
                  var2.offset = 0;
                  class3.field19 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && var1.available() >= class3.field19) {
                  var2.offset = 0;
                  var1.read(var2.payload, 0, class3.field19);
                  var2.offset = 0;
                  String var20 = var2.readString();
                  String var22 = var2.readString();
                  String var26 = var2.readString();
                  NPC.method1749(var20, var22, var26);
                  class12.setGameState(10);
               }

               if(loginState != 13) {
                  ++field905;
                  if(field905 > 2000) {
                     if(field896 < 1) {
                        if(class48.field591 == class184.myWorldPort) {
                           class184.myWorldPort = field909;
                        } else {
                           class184.myWorldPort = class48.field591;
                        }

                        ++field896;
                        loginState = 0;
                     } else {
                        class28.method236(-3);
                     }
                  }
               } else {
                  if(field916.packetLength == -1) {
                     if(var1.available() < 2) {
                        return;
                     }

                     var1.read(var2.payload, 0, 2);
                     var2.offset = 0;
                     field916.packetLength = var2.readUnsignedShort();
                  }

                  if(var1.available() >= field916.packetLength) {
                     var1.read(var2.payload, 0, field916.packetLength);
                     var2.offset = 0;
                     var12 = field916.packetLength;
                     field919.method5099();
                     field916.method1926();
                     field916.field1465.offset = 0;
                     field916.serverPacket = null;
                     field916.field1476 = null;
                     field916.field1475 = null;
                     field916.field1478 = null;
                     field916.packetLength = 0;
                     field916.field1474 = 0;
                     field931 = 0;
                     ItemContainer.method1100();
                     field1088 = 0;
                     destinationX = 0;

                     for(var31 = 0; var31 < 2048; ++var31) {
                        cachedPlayers[var31] = null;
                     }

                     class181.localPlayer = null;

                     for(var31 = 0; var31 < cachedNPCs.length; ++var31) {
                        NPC var27 = cachedNPCs[var31];
                        if(var27 != null) {
                           var27.interacting = -1;
                           var27.field1173 = false;
                        }
                     }

                     ItemContainer.itemContainers = new HashTable(32);
                     class12.setGameState(30);

                     for(var31 = 0; var31 < 100; ++var31) {
                        field1059[var31] = true;
                     }

                     PacketNode var23 = class218.method4105(ClientPacket.field2321, field916.field1470);
                     var23.packetBuffer.putByte(ISAACCipher.method3604());
                     var23.packetBuffer.putShort(class86.canvasWidth);
                     var23.packetBuffer.putShort(GameEngine.canvasHeight);
                     field916.method1925(var23);
                     class81.initializeGPI(var2);
                     if(var12 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var18) {
         if(field896 < 1) {
            if(class48.field591 == class184.myWorldPort) {
               class184.myWorldPort = field909;
            } else {
               class184.myWorldPort = class48.field591;
            }

            ++field896;
            loginState = 0;
         } else {
            class28.method236(-2);
         }
      }
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "657480624"
   )
   final void method1204() {
      if(field931 > 1) {
         --field931;
      }

      if(field1108 > 0) {
         --field1108;
      }

      if(socketError) {
         socketError = false;
         class111.method2179();
      } else {
         if(!isMenuOpen) {
            FileRequest.method4261();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1358(field916); ++var1) {
            ;
         }

         if(gameState == 30) {
            int var2;
            PacketNode var15;
            while(class277.method5091()) {
               var15 = class218.method4105(ClientPacket.field2324, field916.field1470);
               var15.packetBuffer.putByte(0);
               var2 = var15.packetBuffer.offset;
               class111.encodeClassVerifier(var15.packetBuffer);
               var15.packetBuffer.method3293(var15.packetBuffer.offset - var2);
               field916.method1925(var15);
            }

            if(field919.field3776) {
               var15 = class218.method4105(ClientPacket.field2355, field916.field1470);
               var15.packetBuffer.putByte(0);
               var2 = var15.packetBuffer.offset;
               field919.method5097(var15.packetBuffer);
               var15.packetBuffer.method3293(var15.packetBuffer.offset - var2);
               field916.method1925(var15);
               field919.method5098();
            }

            Object var33 = class269.field3696.field819;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            synchronized(class269.field3696.field819) {
               if(!field940) {
                  class269.field3696.field818 = 0;
               } else if(MouseInput.field708 != 0 || class269.field3696.field818 >= 40) {
                  PacketNode var16 = class218.method4105(ClientPacket.field2361, field916.field1470);
                  var16.packetBuffer.putByte(0);
                  var3 = var16.packetBuffer.offset;
                  var4 = 0;

                  for(var5 = 0; var5 < class269.field3696.field818 && var16.packetBuffer.offset - var3 < 240; ++var5) {
                     ++var4;
                     var6 = class269.field3696.field822[var5];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 502) {
                        var6 = 502;
                     }

                     var7 = class269.field3696.field824[var5];
                     if(var7 < 0) {
                        var7 = 0;
                     } else if(var7 > 764) {
                        var7 = 764;
                     }

                     var8 = var6 * 765 + var7;
                     if(class269.field3696.field822[var5] == -1 && class269.field3696.field824[var5] == -1) {
                        var7 = -1;
                        var6 = -1;
                        var8 = 524287;
                     }

                     if(var7 == field1023 && var6 == field883) {
                        if(field884 < 2047) {
                           ++field884;
                        }
                     } else {
                        var9 = var7 - field1023;
                        field1023 = var7;
                        var10 = var6 - field883;
                        field883 = var6;
                        if(field884 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                           var9 += 32;
                           var10 += 32;
                           var16.packetBuffer.putShort(var10 + (field884 << 12) + (var9 << 6));
                           field884 = 0;
                        } else if(field884 < 8) {
                           var16.packetBuffer.put24bitInt((field884 << 19) + var8 + 8388608);
                           field884 = 0;
                        } else {
                           var16.packetBuffer.putInt((field884 << 19) + var8 + -1073741824);
                           field884 = 0;
                        }
                     }
                  }

                  var16.packetBuffer.method3293(var16.packetBuffer.offset - var3);
                  field916.method1925(var16);
                  if(var4 >= class269.field3696.field818) {
                     class269.field3696.field818 = 0;
                  } else {
                     class269.field3696.field818 -= var4;

                     for(var5 = 0; var5 < class269.field3696.field818; ++var5) {
                        class269.field3696.field824[var5] = class269.field3696.field824[var5 + var4];
                        class269.field3696.field822[var5] = class269.field3696.field822[var4 + var5];
                     }
                  }
               }
            }

            PacketNode var19;
            if(MouseInput.field708 == 1 || !field956 && MouseInput.field708 == 4 || MouseInput.field708 == 2) {
               long var17 = (MouseInput.field697 - field1066) / 50L;
               if(var17 > 4095L) {
                  var17 = 4095L;
               }

               field1066 = MouseInput.field697;
               var3 = MouseInput.field710;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > GameEngine.canvasHeight) {
                  var3 = GameEngine.canvasHeight;
               }

               var4 = MouseInput.field709;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class86.canvasWidth) {
                  var4 = class86.canvasWidth;
               }

               var5 = (int)var17;
               var19 = class218.method4105(ClientPacket.field2352, field916.field1470);
               var19.packetBuffer.putShort((var5 << 1) + (MouseInput.field708 == 2?1:0));
               var19.packetBuffer.putShort(var4);
               var19.packetBuffer.putShort(var3);
               field916.method1925(var19);
            }

            if(KeyFocusListener.field613 > 0) {
               var15 = class218.method4105(ClientPacket.field2311, field916.field1470);
               var15.packetBuffer.putShort(0);
               var2 = var15.packetBuffer.offset;
               long var20 = ServerPacket.currentTimeMs();

               for(var5 = 0; var5 < KeyFocusListener.field613; ++var5) {
                  long var22 = var20 - field1078;
                  if(var22 > 16777215L) {
                     var22 = 16777215L;
                  }

                  field1078 = var20;
                  var15.packetBuffer.put24bitInt((int)var22);
                  var15.packetBuffer.putByte(KeyFocusListener.field612[var5]);
               }

               var15.packetBuffer.method3498(var15.packetBuffer.offset - var2);
               field916.method1925(var15);
            }

            if(field911 > 0) {
               --field911;
            }

            if(KeyFocusListener.field606[96] || KeyFocusListener.field606[97] || KeyFocusListener.field606[98] || KeyFocusListener.field606[99]) {
               field945 = true;
            }

            if(field945 && field911 <= 0) {
               field911 = 20;
               field945 = false;
               var15 = class218.method4105(ClientPacket.field2397, field916.field1470);
               var15.packetBuffer.putShortLE(field997);
               var15.packetBuffer.putShortLE(mapAngle);
               field916.method1925(var15);
            }

            if(class43.field548 && !field885) {
               field885 = true;
               var15 = class218.method4105(ClientPacket.field2364, field916.field1470);
               var15.packetBuffer.putByte(1);
               field916.method1925(var15);
            }

            if(!class43.field548 && field885) {
               field885 = false;
               var15 = class218.method4105(ClientPacket.field2364, field916.field1470);
               var15.packetBuffer.putByte(0);
               field916.method1925(var15);
            }

            if(field1081 != class233.plane) {
               field1081 = class233.plane;
               class48.method739(class233.plane);
            }

            if(gameState == 30) {
               class181.method3523();
               BuildType.method4254();
               ++field916.field1474;
               if(field916.field1474 > 750) {
                  class111.method2179();
               } else {
                  GameObject.method3019();

                  for(var1 = 0; var1 < npcIndexesCount; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var24 = cachedNPCs[var2];
                     if(var24 != null) {
                        class70.method1129(var24, var24.composition.field3619);
                     }
                  }

                  int[] var35 = class94.playerIndices;

                  for(var2 = 0; var2 < class94.playerIndexesCount; ++var2) {
                     Player var38 = cachedPlayers[var35[var2]];
                     if(var38 != null && var38.field1177 > 0) {
                        --var38.field1177;
                        if(var38.field1177 == 0) {
                           var38.overhead = null;
                        }
                     }
                  }

                  for(var2 = 0; var2 < npcIndexesCount; ++var2) {
                     var3 = npcIndices[var2];
                     NPC var25 = cachedNPCs[var3];
                     if(var25 != null && var25.field1177 > 0) {
                        --var25.field1177;
                        if(var25.field1177 == 0) {
                           var25.overhead = null;
                        }
                     }
                  }

                  ++field992;
                  if(cursorState != 0) {
                     field963 += 20;
                     if(field963 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class51.field622 != null) {
                     ++field965;
                     if(field965 >= 15) {
                        class40.method556(class51.field622);
                        class51.field622 = null;
                     }
                  }

                  Widget var36 = FloorUnderlayDefinition.field3409;
                  Widget var34 = class14.field279;
                  FloorUnderlayDefinition.field3409 = null;
                  class14.field279 = null;
                  field890 = null;
                  field991 = false;
                  field1046 = false;
                  field1075 = 0;

                  while(ScriptEvent.method1123() && field1075 < 128) {
                     if(rights >= 2 && KeyFocusListener.field606[82] && class35.field473 == 66) {
                        String var39 = class91.method1812();
                        class287.clientInstance.method867(var39);
                     } else {
                        field1077[field1075] = class35.field473;
                        field1055[field1075] = class20.field320;
                        ++field1075;
                     }
                  }

                  boolean var31 = rights >= 2;
                  PacketNode var26;
                  if(var31 && KeyFocusListener.field606[82] && KeyFocusListener.field606[81] && field1052 != 0) {
                     var4 = class181.localPlayer.field853 - field1052;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != class181.localPlayer.field853) {
                        var5 = class181.localPlayer.pathX[0] + IndexDataBase.baseX;
                        var6 = class181.localPlayer.pathY[0] + Occluder.baseY;
                        var26 = class218.method4105(ClientPacket.field2375, field916.field1470);
                        var26.packetBuffer.method3343(var4);
                        var26.packetBuffer.putShortLE(var5);
                        var26.packetBuffer.method3332(var6);
                        field916.method1925(var26);
                     }

                     field1052 = 0;
                  }

                  if(widgetRoot != -1) {
                     var4 = widgetRoot;
                     var5 = class86.canvasWidth;
                     var6 = GameEngine.canvasHeight;
                     if(ISAACCipher.loadWidget(var4)) {
                        DynamicObject.method1910(class11.widgets[var4], -1, 0, 0, var5, var6, 0, 0);
                     }
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var27;
                     Widget var37;
                     ScriptEvent var40;
                     do {
                        var40 = (ScriptEvent)field1054.popFront();
                        if(var40 == null) {
                           while(true) {
                              do {
                                 var40 = (ScriptEvent)field1105.popFront();
                                 if(var40 == null) {
                                    while(true) {
                                       do {
                                          var40 = (ScriptEvent)field1010.popFront();
                                          if(var40 == null) {
                                             this.method1209();
                                             RSCanvas.method793();
                                             if(field1027 != null) {
                                                this.method1214();
                                             }

                                             if(WorldMapType2.field492 != null) {
                                                class40.method556(WorldMapType2.field492);
                                                ++field1012;
                                                if(MouseInput.field705 == 0) {
                                                   if(field971) {
                                                      if(WorldMapType2.field497 == WorldMapType2.field492 && field1076 != field1001) {
                                                         Widget var41 = WorldMapType2.field492;
                                                         byte var32 = 0;
                                                         if(field927 == 1 && var41.contentType == 206) {
                                                            var32 = 1;
                                                         }

                                                         if(var41.itemIds[field1001] <= 0) {
                                                            var32 = 0;
                                                         }

                                                         if(class156.method3091(ClanMember.getWidgetConfig(var41))) {
                                                            var6 = field1076;
                                                            var7 = field1001;
                                                            var41.itemIds[var7] = var41.itemIds[var6];
                                                            var41.itemQuantities[var7] = var41.itemQuantities[var6];
                                                            var41.itemIds[var6] = -1;
                                                            var41.itemQuantities[var6] = 0;
                                                         } else if(var32 == 1) {
                                                            var6 = field1076;
                                                            var7 = field1001;

                                                            while(var7 != var6) {
                                                               if(var6 > var7) {
                                                                  var41.method4164(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var41.method4164(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var41.method4164(field1001, field1076);
                                                         }

                                                         var19 = class218.method4105(ClientPacket.field2385, field916.field1470);
                                                         var19.packetBuffer.putInt(WorldMapType2.field492.id);
                                                         var19.packetBuffer.method3330(field1001);
                                                         var19.packetBuffer.putByte(var32);
                                                         var19.packetBuffer.putShort(field1076);
                                                         field916.method1925(var19);
                                                      }
                                                   } else if(this.method1210()) {
                                                      this.method1211(field968, field969);
                                                   } else if(menuOptionCount > 0) {
                                                      SoundTask.method2175(field968, field969);
                                                   }

                                                   field965 = 10;
                                                   MouseInput.field708 = 0;
                                                   WorldMapType2.field492 = null;
                                                } else if(field1012 >= 5 && (MouseInput.field703 > field968 + 5 || MouseInput.field703 < field968 - 5 || MouseInput.field715 * 10625923 > field969 + 5 || MouseInput.field715 * 10625923 < field969 - 5)) {
                                                   field971 = true;
                                                }
                                             }

                                             if(Region.method2835()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                var19 = class218.method4105(ClientPacket.field2345, field916.field1470);
                                                var19.packetBuffer.putByte(5);
                                                var19.packetBuffer.putShort(var4 + IndexDataBase.baseX);
                                                var19.packetBuffer.putShortLE(var5 + Occluder.baseY);
                                                var19.packetBuffer.putByte(KeyFocusListener.field606[82]?(KeyFocusListener.field606[81]?2:1):0);
                                                field916.method1925(var19);
                                                Region.method2836();
                                                field1064 = MouseInput.field709;
                                                field962 = MouseInput.field710;
                                                cursorState = 1;
                                                field963 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var36 != FloorUnderlayDefinition.field3409) {
                                                if(var36 != null) {
                                                   class40.method556(var36);
                                                }

                                                if(FloorUnderlayDefinition.field3409 != null) {
                                                   class40.method556(FloorUnderlayDefinition.field3409);
                                                }
                                             }

                                             if(var34 != class14.field279 && field882 == field1006) {
                                                if(var34 != null) {
                                                   class40.method556(var34);
                                                }

                                                if(class14.field279 != null) {
                                                   class40.method556(class14.field279);
                                                }
                                             }

                                             if(class14.field279 != null) {
                                                if(field882 < field1006) {
                                                   ++field882;
                                                   if(field1006 == field882) {
                                                      class40.method556(class14.field279);
                                                   }
                                                }
                                             } else if(field882 > 0) {
                                                --field882;
                                             }

                                             class23.method181();
                                             if(field1100) {
                                                var4 = Friend.field777 * 128 + 64;
                                                var5 = class163.field2206 * 128 + 64;
                                                var6 = class41.getTileHeight(var4, var5, class233.plane) - class25.field350;
                                                if(class214.cameraX < var4) {
                                                   class214.cameraX = (var4 - class214.cameraX) * class21.field328 / 1000 + class214.cameraX + class218.field2685;
                                                   if(class214.cameraX > var4) {
                                                      class214.cameraX = var4;
                                                   }
                                                }

                                                if(class214.cameraX > var4) {
                                                   class214.cameraX -= class21.field328 * (class214.cameraX - var4) / 1000 + class218.field2685;
                                                   if(class214.cameraX < var4) {
                                                      class214.cameraX = var4;
                                                   }
                                                }

                                                if(GameEngine.cameraZ < var6) {
                                                   GameEngine.cameraZ = (var6 - GameEngine.cameraZ) * class21.field328 / 1000 + GameEngine.cameraZ + class218.field2685;
                                                   if(GameEngine.cameraZ > var6) {
                                                      GameEngine.cameraZ = var6;
                                                   }
                                                }

                                                if(GameEngine.cameraZ > var6) {
                                                   GameEngine.cameraZ -= class21.field328 * (GameEngine.cameraZ - var6) / 1000 + class218.field2685;
                                                   if(GameEngine.cameraZ < var6) {
                                                      GameEngine.cameraZ = var6;
                                                   }
                                                }

                                                if(class289.cameraY < var5) {
                                                   class289.cameraY = (var5 - class289.cameraY) * class21.field328 / 1000 + class289.cameraY + class218.field2685;
                                                   if(class289.cameraY > var5) {
                                                      class289.cameraY = var5;
                                                   }
                                                }

                                                if(class289.cameraY > var5) {
                                                   class289.cameraY -= class21.field328 * (class289.cameraY - var5) / 1000 + class218.field2685;
                                                   if(class289.cameraY < var5) {
                                                      class289.cameraY = var5;
                                                   }
                                                }

                                                var4 = class36.field479 * 128 + 64;
                                                var5 = RSCanvas.field629 * 128 + 64;
                                                var6 = class41.getTileHeight(var4, var5, class233.plane) - class18.field304;
                                                var7 = var4 - class214.cameraX;
                                                var8 = var6 - GameEngine.cameraZ;
                                                var9 = var5 - class289.cameraY;
                                                var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                                                int var28 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                                                int var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                                                if(var28 < 128) {
                                                   var28 = 128;
                                                }

                                                if(var28 > 383) {
                                                   var28 = 383;
                                                }

                                                if(class18.cameraPitch < var28) {
                                                   class18.cameraPitch = (var28 - class18.cameraPitch) * class234.field3226 / 1000 + class18.cameraPitch + class158.field2165;
                                                   if(class18.cameraPitch > var28) {
                                                      class18.cameraPitch = var28;
                                                   }
                                                }

                                                if(class18.cameraPitch > var28) {
                                                   class18.cameraPitch -= class234.field3226 * (class18.cameraPitch - var28) / 1000 + class158.field2165;
                                                   if(class18.cameraPitch < var28) {
                                                      class18.cameraPitch = var28;
                                                   }
                                                }

                                                int var13 = var12 - class51.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 > 0) {
                                                   class51.cameraYaw = class51.cameraYaw + class158.field2165 + var13 * class234.field3226 / 1000;
                                                   class51.cameraYaw &= 2047;
                                                }

                                                if(var13 < 0) {
                                                   class51.cameraYaw -= -var13 * class234.field3226 / 1000 + class158.field2165;
                                                   class51.cameraYaw &= 2047;
                                                }

                                                int var14 = var12 - class51.cameraYaw;
                                                if(var14 > 1024) {
                                                   var14 -= 2048;
                                                }

                                                if(var14 < -1024) {
                                                   var14 += 2048;
                                                }

                                                if(var14 < 0 && var13 > 0 || var14 > 0 && var13 < 0) {
                                                   class51.cameraYaw = var12;
                                                }
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1091[var4];
                                             }

                                             class28.chatMessages.process();
                                             var4 = VarPlayerType.method4439();
                                             var5 = KeyFocusListener.keyboardIdleTicks;
                                             if(var4 > 15000 && var5 > 15000) {
                                                field1108 = 250;
                                                class31.method272(14500);
                                                var26 = class218.method4105(ClientPacket.field2304, field916.field1470);
                                                field916.method1925(var26);
                                             }

                                             for(class66 var42 = (class66)field1122.method3788(); var42 != null; var42 = (class66)field1122.method3798()) {
                                                if((long)var42.field788 < ServerPacket.currentTimeMs() / 1000L - 5L) {
                                                   if(var42.field786 > 0) {
                                                      class54.sendGameMessage(5, "", var42.field785 + " has logged in.");
                                                   }

                                                   if(var42.field786 == 0) {
                                                      class54.sendGameMessage(5, "", var42.field785 + " has logged out.");
                                                   }

                                                   var42.method3799();
                                                }
                                             }

                                             ++field916.field1468;
                                             if(field916.field1468 > 50) {
                                                var26 = class218.method4105(ClientPacket.field2351, field916.field1470);
                                                field916.method1925(var26);
                                             }

                                             try {
                                                field916.method1927();
                                             } catch (IOException var29) {
                                                class111.method2179();
                                             }

                                             return;
                                          }

                                          var27 = var40.widget;
                                          if(var27.index < 0) {
                                             break;
                                          }

                                          var37 = class87.method1762(var27.parentId);
                                       } while(var37 == null || var37.children == null || var27.index >= var37.children.length || var27 != var37.children[var27.index]);

                                       class14.method95(var40);
                                    }
                                 }

                                 var27 = var40.widget;
                                 if(var27.index < 0) {
                                    break;
                                 }

                                 var37 = class87.method1762(var27.parentId);
                              } while(var37 == null || var37.children == null || var27.index >= var37.children.length || var27 != var37.children[var27.index]);

                              class14.method95(var40);
                           }
                        }

                        var27 = var40.widget;
                        if(var27.index < 0) {
                           break;
                        }

                        var37 = class87.method1762(var27.parentId);
                     } while(var37 == null || var37.children == null || var27.index >= var37.children.length || var27 != var37.children[var27.index]);

                     class14.method95(var40);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "18032"
   )
   void method1206() {
      int var1 = class86.canvasWidth;
      int var2 = GameEngine.canvasHeight;
      if(super.field670 < var1) {
         var1 = super.field670;
      }

      if(super.field663 < var2) {
         var2 = super.field663;
      }

      if(RSCanvas.preferences != null) {
         try {
            Client var3 = class287.clientInstance;
            int var4 = isResized?2:1;
            class52.method784(var3, "resize", new Object[]{Integer.valueOf(var4)});
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void method1207() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(ISAACCipher.loadWidget(var1)) {
            class70.method1131(class11.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1035; ++var1) {
         if(field1059[var1]) {
            field1099[var1] = true;
         }

         field1132[var1] = field1059[var1];
         field1059[var1] = false;
      }

      field1058 = gameCycle;
      field1003 = -1;
      field1004 = -1;
      WorldMapType2.field497 = null;
      if(widgetRoot != -1) {
         field1035 = 0;
         MilliTimer.method3057(widgetRoot, 0, 0, class86.canvasWidth, GameEngine.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      int var4;
      int var6;
      int var7;
      int var13;
      if(!isMenuOpen) {
         if(field1003 != -1) {
            var1 = field1003;
            var2 = field1004;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               var3 = menuOptionCount - 1;
               String var5;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var5 = "Use" + " " + field974 + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var5 = field1042 + " " + field1013 + " " + "->";
               } else {
                  String var17;
                  if(var3 < 0) {
                     var17 = "";
                  } else if(menuTargets[var3].length() > 0) {
                     var17 = menuOptions[var3] + " " + menuTargets[var3];
                  } else {
                     var17 = menuOptions[var3];
                  }

                  var5 = var17;
               }

               if(menuOptionCount > 2) {
                  var5 = var5 + ISAACCipher.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               World.field1226.drawRandomizedMouseoverText(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         var1 = class177.menuX;
         var2 = class1.menuY;
         var3 = WorldMapType1.menuWidth;
         var4 = class91.menuHeight;
         int var14 = 6116423;
         Rasterizer2D.method5173(var1, var2, var3, var4, var14);
         Rasterizer2D.method5173(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         World.field1226.method4931("Choose Option", var1 + 3, var2 + 14, var14, -1);
         var6 = MouseInput.field703;
         var7 = MouseInput.field715 * 10625923;

         for(var13 = 0; var13 < menuOptionCount; ++var13) {
            int var15 = var2 + (menuOptionCount - 1 - var13) * 15 + 31;
            int var16 = 16777215;
            if(var6 > var1 && var6 < var1 + var3 && var7 > var15 - 13 && var7 < var15 + 3) {
               var16 = 16776960;
            }

            Font var11 = World.field1226;
            String var12;
            if(var13 < 0) {
               var12 = "";
            } else if(menuTargets[var13].length() > 0) {
               var12 = menuOptions[var13] + " " + menuTargets[var13];
            } else {
               var12 = menuOptions[var13];
            }

            var11.method4931(var12, var1 + 3, var15, var16, 0);
         }

         DState.method3276(class177.menuX, class1.menuY, WorldMapType1.menuWidth, class91.menuHeight);
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1035; ++var1) {
            if(field1132[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1099[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class233.plane;
      var2 = class181.localPlayer.x;
      var3 = class181.localPlayer.y;
      var4 = field992;

      for(class81 var18 = (class81)class81.field1248.getFront(); var18 != null; var18 = (class81)class81.field1248.getNext()) {
         if(var18.field1247 != -1 || var18.field1240 != null) {
            var6 = 0;
            if(var2 > var18.field1251) {
               var6 += var2 - var18.field1251;
            } else if(var2 < var18.field1242) {
               var6 += var18.field1242 - var2;
            }

            if(var3 > var18.field1245) {
               var6 += var3 - var18.field1245;
            } else if(var3 < var18.field1244) {
               var6 += var18.field1244 - var3;
            }

            if(var6 - 64 <= var18.field1246 && field1093 != 0 && var1 == var18.field1241) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = (var18.field1246 - var6) * field1093 / var18.field1246;
               Object var10000;
               if(var18.field1253 == null) {
                  if(var18.field1247 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.getTrack(class47.field576, var18.field1247, 0);
                     if(var8 != null) {
                        class106 var9 = var8.method2013().method2066(SoundTask.field1583);
                        class116 var10 = class116.method2227(var9, 100, var7);
                        var10.method2230(-1);
                        class70.field821.method1953(var10);
                        var18.field1253 = var10;
                     }
                  }
               } else {
                  var18.field1253.method2231(var7);
               }

               if(var18.field1250 == null) {
                  if(var18.field1240 != null && (var18.field1252 -= var4) <= 0) {
                     var13 = (int)(Math.random() * (double)var18.field1240.length);
                     var10000 = null;
                     SoundEffect var19 = SoundEffect.getTrack(class47.field576, var18.field1240[var13], 0);
                     if(var19 != null) {
                        class106 var20 = var19.method2013().method2066(SoundTask.field1583);
                        class116 var21 = class116.method2227(var20, 100, var7);
                        var21.method2230(0);
                        class70.field821.method1953(var21);
                        var18.field1250 = var21;
                        var18.field1252 = var18.field1249 + (int)(Math.random() * (double)(var18.field1243 - var18.field1249));
                     }
                  }
               } else {
                  var18.field1250.method2231(var7);
                  if(!var18.field1250.linked()) {
                     var18.field1250 = null;
                  }
               }
            } else {
               if(var18.field1253 != null) {
                  class70.field821.method1954(var18.field1253);
                  var18.field1253 = null;
               }

               if(var18.field1250 != null) {
                  class70.field821.method1954(var18.field1250);
                  var18.field1250 = null;
               }
            }
         }
      }

      field992 = 0;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(Lct;I)Z",
      garbageValue = "845043588"
   )
   final boolean method1358(class100 var1) {
      RSSocket var2 = var1.method1933();
      PacketBuffer var3 = var1.field1465;
      if(var2 == null) {
         return false;
      } else {
         String var5;
         int var6;
         try {
            if(var1.serverPacket == null) {
               if(var1.field1473) {
                  if(!var2.method3119(1)) {
                     return false;
                  }

                  var2.read(var1.field1465.payload, 0, 1);
                  var1.field1474 = 0;
                  var1.field1473 = false;
               }

               var3.offset = 0;
               if(var3.method3563()) {
                  if(!var2.method3119(1)) {
                     return false;
                  }

                  var2.read(var1.field1465.payload, 1, 1);
                  var1.field1474 = 0;
               }

               var1.field1473 = true;
               ServerPacket[] var4 = new ServerPacket[]{ServerPacket.field2264, ServerPacket.field2230, ServerPacket.field2221, ServerPacket.field2293, ServerPacket.field2222, ServerPacket.field2224, ServerPacket.field2275, ServerPacket.field2226, ServerPacket.field2227, ServerPacket.field2228, ServerPacket.field2229, ServerPacket.field2282, ServerPacket.field2265, ServerPacket.field2241, ServerPacket.field2269, ServerPacket.field2234, ServerPacket.field2268, ServerPacket.field2236, ServerPacket.field2237, ServerPacket.field2238, ServerPacket.field2239, ServerPacket.field2240, ServerPacket.field2260, ServerPacket.field2242, ServerPacket.field2243, ServerPacket.field2231, ServerPacket.field2245, ServerPacket.field2246, ServerPacket.field2247, ServerPacket.field2232, ServerPacket.field2249, ServerPacket.field2250, ServerPacket.field2251, ServerPacket.field2252, ServerPacket.field2262, ServerPacket.field2254, ServerPacket.field2255, ServerPacket.field2244, ServerPacket.field2258, ServerPacket.field2233, ServerPacket.field2259, ServerPacket.field2286, ServerPacket.field2261, ServerPacket.field2219, ServerPacket.field2263, ServerPacket.field2301, ServerPacket.field2223, ServerPacket.field2266, ServerPacket.field2267, ServerPacket.field2235, ServerPacket.field2272, ServerPacket.field2270, ServerPacket.field2271, ServerPacket.field2276, ServerPacket.field2273, ServerPacket.field2274, ServerPacket.field2256, ServerPacket.field2248, ServerPacket.field2277, ServerPacket.field2278, ServerPacket.field2279, ServerPacket.field2280, ServerPacket.field2281, ServerPacket.field2290, ServerPacket.field2283, ServerPacket.field2284, ServerPacket.field2285, ServerPacket.field2257, ServerPacket.field2287, ServerPacket.field2288, ServerPacket.field2225, ServerPacket.field2289, ServerPacket.field2291, ServerPacket.field2292, ServerPacket.field2253, ServerPacket.field2294, ServerPacket.field2295, ServerPacket.field2296, ServerPacket.field2297, ServerPacket.field2298, ServerPacket.field2299};
               var6 = var3.method3564();
               if(var6 < 0 || var6 >= var4.length) {
                  throw new IOException(var6 + " " + var3.offset);
               }

               var1.serverPacket = var4[var6];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.method3119(1)) {
                  return false;
               }

               var1.method1933().read(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.method3119(2)) {
                  return false;
               }

               var1.method1933().read(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.method3119(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.read(var3.payload, 0, var1.packetLength);
            var1.field1474 = 0;
            field919.method5094();
            var1.field1478 = var1.field1475;
            var1.field1475 = var1.field1476;
            var1.field1476 = var1.serverPacket;
            if(ServerPacket.field2273 == var1.serverPacket) {
               class72.method1149(class169.field2408);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2277 == var1.serverPacket) {
               field931 = var3.method3333() * 30;
               field1051 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            int var10;
            int var11;
            int var24;
            boolean var85;
            if(ServerPacket.field2259 == var1.serverPacket) {
               field1048 = cycleCntr;
               if(var1.packetLength == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  class61.clanChatCount = 0;
                  class188.clanMembers = null;
                  var1.serverPacket = null;
                  return true;
               }

               clanChatName = var3.readString();
               long var21 = var3.readLong();
               clanChatOwner = FloorUnderlayDefinition.method4521(var21);
               class60.field720 = var3.readByte();
               var6 = var3.readUnsignedByte();
               if(var6 == 255) {
                  var1.serverPacket = null;
                  return true;
               }

               class61.clanChatCount = var6;
               ClanMember[] var75 = new ClanMember[100];

               for(var24 = 0; var24 < class61.clanChatCount; ++var24) {
                  var75[var24] = new ClanMember();
                  var75[var24].username = var3.readString();
                  var75[var24].field867 = GraphicsObject.method1726(var75[var24].username, class236.field3239);
                  var75[var24].world = var3.readUnsignedShort();
                  var75[var24].rank = var3.readByte();
                  var3.readString();
                  if(var75[var24].username.equals(class181.localPlayer.name)) {
                     class14.clanChatRank = var75[var24].rank;
                  }
               }

               var85 = false;
               var10 = class61.clanChatCount;

               while(var10 > 0) {
                  var85 = true;
                  --var10;

                  for(var11 = 0; var11 < var10; ++var11) {
                     if(var75[var11].field867.compareTo(var75[var11 + 1].field867) > 0) {
                        ClanMember var73 = var75[var11];
                        var75[var11] = var75[var11 + 1];
                        var75[var11 + 1] = var73;
                        var85 = false;
                     }
                  }

                  if(var85) {
                     break;
                  }
               }

               class188.clanMembers = var75;
               var1.serverPacket = null;
               return true;
            }

            int var19;
            int var20;
            Widget var56;
            if(ServerPacket.field2296 == var1.serverPacket) {
               var19 = var3.method3279();
               var20 = var3.method3337();
               var6 = var3.method3337();
               var56 = class87.method1762(var19);
               if(var20 != var56.originalX || var6 != var56.originalY || var56.field2788 != 0 || var56.field2730 != 0) {
                  var56.originalX = var20;
                  var56.originalY = var6;
                  var56.field2788 = 0;
                  var56.field2730 = 0;
                  class40.method556(var56);
                  this.method1213(var56);
                  if(var56.type == 0) {
                     NPCComposition.method4864(class11.widgets[var19 >> 16], var56, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            long var12;
            int var23;
            long var27;
            if(ServerPacket.field2224 == var1.serverPacket) {
               var19 = var3.readInt();
               var20 = var3.readInt();
               var23 = 0;
               if(class239.field3279 == null || !class239.field3279.isValid()) {
                  try {
                     Iterator var78 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var78.hasNext()) {
                        GarbageCollectorMXBean var72 = (GarbageCollectorMXBean)var78.next();
                        if(var72.isValid()) {
                           class239.field3279 = var72;
                           GameEngine.field691 = -1L;
                           GameEngine.field658 = -1L;
                        }
                     }
                  } catch (Throwable var45) {
                     ;
                  }
               }

               if(class239.field3279 != null) {
                  long var25 = ServerPacket.currentTimeMs();
                  var27 = class239.field3279.getCollectionTime();
                  if(GameEngine.field658 != -1L) {
                     var12 = var27 - GameEngine.field658;
                     long var14 = var25 - GameEngine.field691;
                     if(var14 != 0L) {
                        var23 = (int)(100L * var12 / var14);
                     }
                  }

                  GameEngine.field658 = var27;
                  GameEngine.field691 = var25;
               }

               PacketNode var79 = class218.method4105(ClientPacket.field2322, field916.field1470);
               var79.packetBuffer.method3322(var23);
               var79.packetBuffer.method3365(var19);
               var79.packetBuffer.method3400(var20);
               var79.packetBuffer.method3322(GameEngine.FPS);
               field916.method1925(var79);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2271 == var1.serverPacket) {
               class72.method1149(class169.field2412);
               var1.serverPacket = null;
               return true;
            }

            int var13;
            int var15;
            String var53;
            String var55;
            String var63;
            int var88;
            String var89;
            if(ServerPacket.field2228 == var1.serverPacket) {
               var53 = var3.readString();
               Preferences.sessionToken = var53;

               try {
                  var5 = class287.clientInstance.getParameter(Parameters.field3766.key);
                  var89 = class287.clientInstance.getParameter(Parameters.field3755.key);
                  var55 = var5 + "settings=" + var53 + "; version=1; path=/; domain=" + var89;
                  String var70;
                  if(var53.length() == 0) {
                     var55 = var55 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var63 = var55 + "; Expires=";
                     var27 = ServerPacket.currentTimeMs() + 94608000000L;
                     class189.field2537.setTime(new Date(var27));
                     var88 = class189.field2537.get(7);
                     var13 = class189.field2537.get(5);
                     int var96 = class189.field2537.get(2);
                     var15 = class189.field2537.get(1);
                     int var16 = class189.field2537.get(11);
                     int var17 = class189.field2537.get(12);
                     int var18 = class189.field2537.get(13);
                     var70 = class189.field2539[var88 - 1] + ", " + var13 / 10 + var13 % 10 + "-" + class189.field2538[0][var96] + "-" + var15 + " " + var16 / 10 + var16 % 10 + ":" + var17 / 10 + var17 % 10 + ":" + var18 / 10 + var18 % 10 + " GMT";
                     var55 = var63 + var70 + "; Max-Age=" + 94608000L;
                  }

                  Client var77 = class287.clientInstance;
                  var70 = "document.cookie=\"" + var55 + "\"";
                  JSObject.getWindow(var77).eval(var70);
               } catch (Throwable var44) {
                  ;
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var31;
            int var32;
            boolean var83;
            boolean var84;
            if(ServerPacket.field2255 == var1.serverPacket) {
               while(var3.offset < var1.packetLength) {
                  var83 = var3.readUnsignedByte() == 1;
                  var5 = var3.readString();
                  var89 = var3.readString();
                  var23 = var3.readUnsignedShort();
                  var24 = var3.readUnsignedByte();
                  var32 = var3.readUnsignedByte();
                  boolean var80 = (var32 & 2) != 0;
                  boolean var76 = (var32 & 1) != 0;
                  if(var23 > 0) {
                     var3.readString();
                     var3.readUnsignedByte();
                     var3.readInt();
                  }

                  var3.readString();

                  for(var88 = 0; var88 < friendCount; ++var88) {
                     Friend var94 = friends[var88];
                     if(!var83) {
                        if(var5.equals(var94.name)) {
                           if(var23 != var94.world) {
                              var31 = true;

                              for(class66 var95 = (class66)field1122.method3788(); var95 != null; var95 = (class66)field1122.method3798()) {
                                 if(var95.field785.equals(var5)) {
                                    if(var23 != 0 && var95.field786 == 0) {
                                       var95.method3799();
                                       var31 = false;
                                    } else if(var23 == 0 && var95.field786 != 0) {
                                       var95.method3799();
                                       var31 = false;
                                    }
                                 }
                              }

                              if(var31) {
                                 field1122.method3787(new class66(var5, var23));
                              }

                              var94.world = var23;
                           }

                           var94.previousName = var89;
                           var94.rank = var24;
                           var94.field783 = var80;
                           var94.field781 = var76;
                           var5 = null;
                           break;
                        }
                     } else if(var89.equals(var94.name)) {
                        var94.name = var5;
                        var94.previousName = var89;
                        var5 = null;
                        break;
                     }
                  }

                  if(var5 != null && friendCount < 400) {
                     Friend var97 = new Friend();
                     friends[friendCount] = var97;
                     var97.name = var5;
                     var97.previousName = var89;
                     var97.world = var23;
                     var97.rank = var24;
                     var97.field783 = var80;
                     var97.field781 = var76;
                     ++friendCount;
                  }
               }

               field1022 = 2;
               field977 = cycleCntr;
               var83 = false;
               var20 = friendCount;

               while(var20 > 0) {
                  var83 = true;
                  --var20;

                  for(var6 = 0; var6 < var20; ++var6) {
                     var84 = false;
                     Friend var74 = friends[var6];
                     Friend var69 = friends[var6 + 1];
                     if(var74.world != world && var69.world == world) {
                        var84 = true;
                     }

                     if(!var84 && var74.world == 0 && var69.world != 0) {
                        var84 = true;
                     }

                     if(!var84 && !var74.field783 && var69.field783) {
                        var84 = true;
                     }

                     if(!var84 && !var74.field781 && var69.field781) {
                        var84 = true;
                     }

                     if(var84) {
                        Friend var100 = friends[var6];
                        friends[var6] = friends[var6 + 1];
                        friends[var6 + 1] = var100;
                        var83 = false;
                     }
                  }

                  if(var83) {
                     break;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2287 == var1.serverPacket) {
               class44.playerUpdatePacketHandler(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2251 == var1.serverPacket) {
               var19 = var3.method3334();
               byte var90 = var3.readByte();
               class218.settings[var19] = var90;
               if(class218.widgetSettings[var19] != var90) {
                  class218.widgetSettings[var19] = var90;
               }

               GraphicsObject.method1724(var19);
               field1040[++field1041 - 1 & 31] = var19;
               var1.serverPacket = null;
               return true;
            }

            Widget var87;
            if(ServerPacket.field2285 == var1.serverPacket) {
               var83 = var3.method3422() == 1;
               var20 = var3.readInt();
               var87 = class87.method1762(var20);
               if(var83 != var87.isHidden) {
                  var87.isHidden = var83;
                  class40.method556(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               class72.method1149(class169.field2417);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2219 == var1.serverPacket) {
               field1070 = var3.method3422();
               field986 = var3.method3422();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2289 == var1.serverPacket) {
               Tile.xteaChanged(true, var1.field1465);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2234 == var1.serverPacket) {
               MessageNode.method1136(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            WidgetNode var59;
            Widget var64;
            if(ServerPacket.field2274 == var1.serverPacket) {
               var19 = var3.method3279();
               var20 = var3.method3342();
               WidgetNode var99 = (WidgetNode)componentTable.get((long)var20);
               var59 = (WidgetNode)componentTable.get((long)var19);
               if(var59 != null) {
                  class39.method552(var59, var99 == null || var99.id != var59.id);
               }

               if(var99 != null) {
                  var99.unlink();
                  componentTable.put(var99, (long)var19);
               }

               var64 = class87.method1762(var20);
               if(var64 != null) {
                  class40.method556(var64);
               }

               var64 = class87.method1762(var19);
               if(var64 != null) {
                  class40.method556(var64);
                  NPCComposition.method4864(class11.widgets[var64.id >>> 16], var64, true);
               }

               if(widgetRoot != -1) {
                  class14.method88(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2222 == var1.serverPacket) {
               var53 = var3.readString();
               var20 = var3.readUnsignedShort();
               byte var81 = var3.readByte();
               var84 = false;
               if(var81 == -128) {
                  var84 = true;
               }

               if(var84) {
                  if(class61.clanChatCount == 0) {
                     var1.serverPacket = null;
                     return true;
                  }

                  var85 = false;

                  for(var24 = 0; var24 < class61.clanChatCount && (!class188.clanMembers[var24].username.equals(var53) || var20 != class188.clanMembers[var24].world); ++var24) {
                     ;
                  }

                  if(var24 < class61.clanChatCount) {
                     while(var24 < class61.clanChatCount - 1) {
                        class188.clanMembers[var24] = class188.clanMembers[var24 + 1];
                        ++var24;
                     }

                     --class61.clanChatCount;
                     class188.clanMembers[class61.clanChatCount] = null;
                  }
               } else {
                  var3.readString();
                  ClanMember var71 = new ClanMember();
                  var71.username = var53;
                  var71.field867 = GraphicsObject.method1726(var71.username, class236.field3239);
                  var71.world = var20;
                  var71.rank = var81;

                  for(var32 = class61.clanChatCount - 1; var32 >= 0; --var32) {
                     var10 = class188.clanMembers[var32].field867.compareTo(var71.field867);
                     if(var10 == 0) {
                        class188.clanMembers[var32].world = var20;
                        class188.clanMembers[var32].rank = var81;
                        if(var53.equals(class181.localPlayer.name)) {
                           class14.clanChatRank = var81;
                        }

                        field1048 = cycleCntr;
                        var1.serverPacket = null;
                        return true;
                     }

                     if(var10 < 0) {
                        break;
                     }
                  }

                  if(class61.clanChatCount >= class188.clanMembers.length) {
                     var1.serverPacket = null;
                     return true;
                  }

                  for(var10 = class61.clanChatCount - 1; var10 > var32; --var10) {
                     class188.clanMembers[var10 + 1] = class188.clanMembers[var10];
                  }

                  if(class61.clanChatCount == 0) {
                     class188.clanMembers = new ClanMember[100];
                  }

                  class188.clanMembers[var32 + 1] = var71;
                  ++class61.clanChatCount;
                  if(var53.equals(class181.localPlayer.name)) {
                     class14.clanChatRank = var81;
                  }
               }

               field1048 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2246 == var1.serverPacket) {
               field1100 = true;
               Friend.field777 = var3.readUnsignedByte();
               class163.field2206 = var3.readUnsignedByte();
               class25.field350 = var3.readUnsignedShort();
               class218.field2685 = var3.readUnsignedByte();
               class21.field328 = var3.readUnsignedByte();
               if(class21.field328 >= 100) {
                  class214.cameraX = Friend.field777 * 128 + 64;
                  class289.cameraY = class163.field2206 * 128 + 64;
                  GameEngine.cameraZ = class41.getTileHeight(class214.cameraX, class289.cameraY, class233.plane) - class25.field350;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2232 == var1.serverPacket) {
               var19 = var3.method3334();
               var20 = var3.method3279();
               var87 = class87.method1762(var20);
               if(var87.modelType != 1 || var19 != var87.modelId) {
                  var87.modelType = 1;
                  var87.modelId = var19;
                  class40.method556(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2290 == var1.serverPacket) {
               field1022 = 1;
               field977 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2239 == var1.serverPacket) {
               var19 = var3.readInt();
               var20 = var3.readInt();
               var6 = var3.readUnsignedShortOb1();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var56 = class87.method1762(var20);
               ItemComposition var67;
               if(!var56.hasScript) {
                  if(var6 == -1) {
                     var56.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var67 = WorldMapType2.getItemDefinition(var6);
                  var56.modelType = 4;
                  var56.modelId = var6;
                  var56.rotationX = var67.xan2d;
                  var56.rotationZ = var67.yan2d;
                  var56.modelZoom = var67.zoom2d * 100 / var19;
                  class40.method556(var56);
               } else {
                  var56.itemId = var6;
                  var56.itemQuantity = var19;
                  var67 = WorldMapType2.getItemDefinition(var6);
                  var56.rotationX = var67.xan2d;
                  var56.rotationZ = var67.yan2d;
                  var56.rotationY = var67.zan2d;
                  var56.field2773 = var67.offsetX2d;
                  var56.field2774 = var67.offsetY2d;
                  var56.modelZoom = var67.zoom2d;
                  if(var67.isStackable == 1) {
                     var56.field2782 = 1;
                  } else {
                     var56.field2782 = 2;
                  }

                  if(var56.field2779 > 0) {
                     var56.modelZoom = var56.modelZoom * 32 / var56.field2779;
                  } else if(var56.originalWidth > 0) {
                     var56.modelZoom = var56.modelZoom * 32 / var56.originalWidth;
                  }

                  class40.method556(var56);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2280 == var1.serverPacket) {
               var19 = var3.method3342();
               var20 = var3.method3336();
               var87 = class87.method1762(var19);
               if(var20 != var87.field2844 || var20 == -1) {
                  var87.field2844 = var20;
                  var87.field2846 = 0;
                  var87.field2783 = 0;
                  class40.method556(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2223 == var1.serverPacket) {
               var19 = var3.method3342();
               var20 = var3.readUnsignedByte();
               var6 = var3.method3333();
               var59 = (WidgetNode)componentTable.get((long)var19);
               if(var59 != null) {
                  class39.method552(var59, var6 != var59.id);
               }

               WidgetNode var65 = new WidgetNode();
               var65.id = var6;
               var65.owner = var20;
               componentTable.put(var65, (long)var19);
               WorldMapType1.method246(var6);
               Widget var68 = class87.method1762(var19);
               class40.method556(var68);
               if(field1018 != null) {
                  class40.method556(field1018);
                  field1018 = null;
               }

               ContextMenuRow.method1764();
               NPCComposition.method4864(class11.widgets[var19 >> 16], var68, false);
               MouseInput.method1012(var6);
               if(widgetRoot != -1) {
                  class14.method88(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2278 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  method1568(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2263 == var1.serverPacket) {
               var19 = var3.readUnsignedShort();
               var20 = var3.method3342();
               class218.settings[var19] = var20;
               if(class218.widgetSettings[var19] != var20) {
                  class218.widgetSettings[var19] = var20;
               }

               GraphicsObject.method1724(var19);
               field1040[++field1041 - 1 & 31] = var19;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2279 == var1.serverPacket) {
               var19 = var3.method3333();
               if(var19 == 65535) {
                  var19 = -1;
               }

               class64.method1104(var19);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2292 == var1.serverPacket) {
               var19 = var3.method3334();
               if(var19 == 65535) {
                  var19 = -1;
               }

               var20 = var3.method3338();
               CombatInfoListHolder.method1730(var19, var20);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2264 == var1.serverPacket) {
               class211.field2628 = var3.method3380();
               class23.field339 = var3.method3422();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2225 == var1.serverPacket) {
               var19 = var3.method3334();
               var20 = var3.readUnsignedShort();
               var6 = var3.readInt();
               var23 = var3.method3334();
               var64 = class87.method1762(var6);
               if(var20 != var64.rotationX || var23 != var64.rotationZ || var19 != var64.modelZoom) {
                  var64.rotationX = var20;
                  var64.rotationZ = var23;
                  var64.modelZoom = var19;
                  class40.method556(var64);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2236 == var1.serverPacket) {
               var19 = var3.offset + var1.packetLength;
               var20 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var20 != widgetRoot) {
                  widgetRoot = var20;
                  this.method1257(false);
                  WorldMapType1.method246(widgetRoot);
                  MouseInput.method1012(widgetRoot);

                  for(var23 = 0; var23 < 100; ++var23) {
                     field1059[var23] = true;
                  }
               }

               WidgetNode var98;
               for(; var6-- > 0; var98.field791 = true) {
                  var23 = var3.readInt();
                  var24 = var3.readUnsignedShort();
                  var32 = var3.readUnsignedByte();
                  var98 = (WidgetNode)componentTable.get((long)var23);
                  if(var98 != null && var24 != var98.id) {
                     class39.method552(var98, true);
                     var98 = null;
                  }

                  if(var98 == null) {
                     WidgetNode var35 = new WidgetNode();
                     var35.id = var24;
                     var35.owner = var32;
                     componentTable.put(var35, (long)var23);
                     WorldMapType1.method246(var24);
                     Widget var92 = class87.method1762(var23);
                     class40.method556(var92);
                     if(field1018 != null) {
                        class40.method556(field1018);
                        field1018 = null;
                     }

                     ContextMenuRow.method1764();
                     NPCComposition.method4864(class11.widgets[var23 >> 16], var92, false);
                     MouseInput.method1012(var24);
                     if(widgetRoot != -1) {
                        class14.method88(widgetRoot, 1);
                     }

                     var98 = var35;
                  }
               }

               for(var59 = (WidgetNode)componentTable.method3707(); var59 != null; var59 = (WidgetNode)componentTable.method3703()) {
                  if(var59.field791) {
                     var59.field791 = false;
                  } else {
                     class39.method552(var59, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var19) {
                  var23 = var3.readInt();
                  var24 = var3.readUnsignedShort();
                  var32 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(var11 = var24; var11 <= var32; ++var11) {
                     var12 = (long)var11 + ((long)var23 << 32);
                     widgetFlags.put(new IntegerNode(var10), var12);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2227 == var1.serverPacket) {
               class211.field2628 = var3.method3380();
               class23.field339 = var3.method3457();

               while(var3.offset < var1.packetLength) {
                  var19 = var3.readUnsignedByte();
                  class169 var62 = class25.method187()[var19];
                  class72.method1149(var62);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2298 == var1.serverPacket) {
               hintArrowTargetType = var3.readUnsignedByte();
               if(hintArrowTargetType == 1) {
                  hintArrowNpcTargetIdx = var3.readUnsignedShort();
               }

               if(hintArrowTargetType >= 2 && hintArrowTargetType <= 6) {
                  if(hintArrowTargetType == 2) {
                     hintArrowOffsetX = 64;
                     hintArrowOffsetY = 64;
                  }

                  if(hintArrowTargetType == 3) {
                     hintArrowOffsetX = 0;
                     hintArrowOffsetY = 64;
                  }

                  if(hintArrowTargetType == 4) {
                     hintArrowOffsetX = 128;
                     hintArrowOffsetY = 64;
                  }

                  if(hintArrowTargetType == 5) {
                     hintArrowOffsetX = 64;
                     hintArrowOffsetY = 0;
                  }

                  if(hintArrowTargetType == 6) {
                     hintArrowOffsetX = 64;
                     hintArrowOffsetY = 128;
                  }

                  hintArrowTargetType = 2;
                  hintArrowX = var3.readUnsignedShort();
                  hintArrowY = var3.readUnsignedShort();
                  hintArrowType = var3.readUnsignedByte();
               }

               if(hintArrowTargetType == 10) {
                  hintArrowPlayerTargetIdx = var3.readUnsignedShort();
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2275 == var1.serverPacket) {
               var19 = var3.readInt();
               var20 = var3.readUnsignedShort();
               if(var19 < -70000) {
                  var20 += 32768;
               }

               if(var19 >= 0) {
                  var87 = class87.method1762(var19);
               } else {
                  var87 = null;
               }

               if(var87 != null) {
                  for(var23 = 0; var23 < var87.itemIds.length; ++var23) {
                     var87.itemIds[var23] = 0;
                     var87.itemQuantities[var23] = 0;
                  }
               }

               ItemContainer var58 = (ItemContainer)ItemContainer.itemContainers.get((long)var20);
               if(var58 != null) {
                  for(var24 = 0; var24 < var58.itemIds.length; ++var24) {
                     var58.itemIds[var24] = -1;
                     var58.stackSizes[var24] = 0;
                  }
               }

               var23 = var3.readUnsignedShort();

               for(var24 = 0; var24 < var23; ++var24) {
                  var32 = var3.readUnsignedShort();
                  var10 = var3.method3457();
                  if(var10 == 255) {
                     var10 = var3.method3279();
                  }

                  if(var87 != null && var24 < var87.itemIds.length) {
                     var87.itemIds[var24] = var32;
                     var87.itemQuantities[var24] = var10;
                  }

                  WorldMapType2.setItemTableSlot(var20, var24, var32 - 1, var10);
               }

               if(var87 != null) {
                  class40.method556(var87);
               }

               WorldMapType2.method529();
               interfaceItemTriggers[++field961 - 1 & 31] = var20 & 32767;
               var1.serverPacket = null;
               return true;
            }

            long var37;
            long var39;
            if(ServerPacket.field2258 == var1.serverPacket) {
               var53 = var3.readString();
               var37 = (long)var3.readUnsignedShort();
               var39 = (long)var3.read24BitInt();
               Permission var66 = (Permission)class94.forOrdinal(class61.method1087(), var3.readUnsignedByte());
               var27 = (var37 << 32) + var39;
               boolean var30 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if(var27 == field1073[var13]) {
                     var30 = true;
                     break;
                  }
               }

               if(class29.isIgnored(var53)) {
                  var30 = true;
               }

               if(!var30 && field908 == 0) {
                  field1073[field1074] = var27;
                  field1074 = (field1074 + 1) % 100;
                  String var33 = FontTypeFace.appendTags(class28.method240(class64.method1107(var3)));
                  byte var91;
                  if(var66.field3257) {
                     var91 = 7;
                  } else {
                     var91 = 3;
                  }

                  if(var66.field3251 != -1) {
                     class54.sendGameMessage(var91, method1570(var66.field3251) + var53, var33);
                  } else {
                     class54.sendGameMessage(var91, var53, var33);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2269 == var1.serverPacket) {
               var19 = var3.readInt();
               WidgetNode var60 = (WidgetNode)componentTable.get((long)var19);
               if(var60 != null) {
                  class39.method552(var60, true);
               }

               if(field1018 != null) {
                  class40.method556(field1018);
                  field1018 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               var19 = var3.readUnsignedShort();
               var20 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               class46.method706(var19, var20, var6);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2237 == var1.serverPacket) {
               class72.method1149(class169.field2414);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2245 == var1.serverPacket) {
               var19 = var3.method3380();
               var20 = var3.method3457();
               var89 = var3.readString();
               if(var20 >= 1 && var20 <= 8) {
                  if(var89.equalsIgnoreCase("null")) {
                     var89 = null;
                  }

                  playerOptions[var20 - 1] = var89;
                  playerOptionsPriorities[var20 - 1] = var19 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            long var42;
            if(ServerPacket.field2235 == var1.serverPacket) {
               var53 = var3.readString();
               var37 = var3.readLong();
               var39 = (long)var3.readUnsignedShort();
               var42 = (long)var3.read24BitInt();
               Permission var101 = (Permission)class94.forOrdinal(class61.method1087(), var3.readUnsignedByte());
               var12 = (var39 << 32) + var42;
               var31 = false;

               for(var15 = 0; var15 < 100; ++var15) {
                  if(var12 == field1073[var15]) {
                     var31 = true;
                     break;
                  }
               }

               if(var101.field3259 && class29.isIgnored(var53)) {
                  var31 = true;
               }

               if(!var31 && field908 == 0) {
                  field1073[field1074] = var12;
                  field1074 = (field1074 + 1) % 100;
                  String var34 = FontTypeFace.appendTags(class28.method240(class64.method1107(var3)));
                  if(var101.field3251 != -1) {
                     class81.addChatMessage(9, method1570(var101.field3251) + var53, var34, class182.method3529(var37));
                  } else {
                     class81.addChatMessage(9, var53, var34, class182.method3529(var37));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var50;
            if(ServerPacket.field2276 == var1.serverPacket) {
               var19 = var3.readInt();
               var50 = class87.method1762(var19);

               for(var6 = 0; var6 < var50.itemIds.length; ++var6) {
                  var50.itemIds[var6] = -1;
                  var50.itemIds[var6] = 0;
               }

               class40.method556(var50);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2265 == var1.serverPacket) {
               class72.method1149(class169.field2409);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2254 == var1.serverPacket) {
               var19 = var3.method3333();
               var20 = var3.readInt();
               var87 = class87.method1762(var20);
               if(var87 != null && var87.type == 0) {
                  if(var19 > var87.scrollHeight - var87.height) {
                     var19 = var87.scrollHeight - var87.height;
                  }

                  if(var19 < 0) {
                     var19 = 0;
                  }

                  if(var19 != var87.scrollY) {
                     var87.scrollY = var19;
                     class40.method556(var87);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2257 == var1.serverPacket) {
               var19 = var3.method3342();
               var20 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               var56 = class87.method1762(var19);
               var56.field2780 = var20 + (var6 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2281 == var1.serverPacket) {
               var19 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var19] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var19] = new GrandExchangeOffer(var3, false);
               }

               field1049 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            boolean var82;
            if(ServerPacket.field2291 == var1.serverPacket) {
               var19 = var3.getUSmart();
               var82 = var3.readUnsignedByte() == 1;
               var89 = "";
               var84 = false;
               if(var82) {
                  var89 = var3.readString();
                  if(class29.isIgnored(var89)) {
                     var84 = true;
                  }
               }

               var63 = var3.readString();
               if(!var84) {
                  class54.sendGameMessage(var19, var89, var63);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2284 == var1.serverPacket) {
               var53 = var3.readString();
               Object[] var57 = new Object[var53.length() + 1];

               for(var6 = var53.length() - 1; var6 >= 0; --var6) {
                  if(var53.charAt(var6) == 's') {
                     var57[var6 + 1] = var3.readString();
                  } else {
                     var57[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var57[0] = new Integer(var3.readInt());
               ScriptEvent var93 = new ScriptEvent();
               var93.field797 = var57;
               class14.method95(var93);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2231 == var1.serverPacket) {
               Renderable.method2993();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2260 == var1.serverPacket) {
               var19 = var3.readUnsignedShort();
               widgetRoot = var19;
               this.method1257(false);
               WorldMapType1.method246(var19);
               MouseInput.method1012(widgetRoot);

               for(var20 = 0; var20 < 100; ++var20) {
                  field1059[var20] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2282 == var1.serverPacket) {
               WorldMapType2.method529();
               energy = var3.readUnsignedByte();
               field1051 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2230 == var1.serverPacket) {
               var83 = var3.readUnsignedByte() == 1;
               if(var83) {
                  ISAACCipher.field2533 = ServerPacket.currentTimeMs() - var3.readLong();
                  BaseVarType.field27 = new class13(var3, true);
               } else {
                  BaseVarType.field27 = null;
               }

               field1050 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2250 == var1.serverPacket) {
               var19 = var3.method3278();
               var20 = var3.method3279();
               var6 = var3.method3334();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var23 = var3.method3334();
               if(var23 == 65535) {
                  var23 = -1;
               }

               for(var24 = var23; var24 <= var6; ++var24) {
                  var42 = ((long)var20 << 32) + (long)var24;
                  Node var41 = widgetFlags.get(var42);
                  if(var41 != null) {
                     var41.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var19), var42);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2297 == var1.serverPacket) {
               class72.method1149(class169.field2416);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2238 == var1.serverPacket) {
               var19 = var3.method3333();
               var20 = var3.method3279();
               var87 = class87.method1762(var20);
               if(var87.modelType != 2 || var19 != var87.modelId) {
                  var87.modelType = 2;
                  var87.modelId = var19;
                  class40.method556(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2247 == var1.serverPacket) {
               for(var19 = 0; var19 < cachedPlayers.length; ++var19) {
                  if(cachedPlayers[var19] != null) {
                     cachedPlayers[var19].animation = -1;
                  }
               }

               for(var19 = 0; var19 < cachedNPCs.length; ++var19) {
                  if(cachedNPCs[var19] != null) {
                     cachedNPCs[var19].animation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2243 == var1.serverPacket) {
               var53 = var3.readString();
               var5 = FontTypeFace.appendTags(class28.method240(class64.method1107(var3)));
               class54.sendGameMessage(6, var53, var5);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2233 == var1.serverPacket) {
               class2.method4(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2240 == var1.serverPacket) {
               field1100 = false;

               for(var19 = 0; var19 < 5; ++var19) {
                  field1101[var19] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2266 == var1.serverPacket) {
               field1100 = true;
               class36.field479 = var3.readUnsignedByte();
               RSCanvas.field629 = var3.readUnsignedByte();
               class18.field304 = var3.readUnsignedShort();
               class158.field2165 = var3.readUnsignedByte();
               class234.field3226 = var3.readUnsignedByte();
               if(class234.field3226 >= 100) {
                  var19 = class36.field479 * 128 + 64;
                  var20 = RSCanvas.field629 * 128 + 64;
                  var6 = class41.getTileHeight(var19, var20, class233.plane) - class18.field304;
                  var23 = var19 - class214.cameraX;
                  var24 = var6 - GameEngine.cameraZ;
                  var32 = var20 - class289.cameraY;
                  var10 = (int)Math.sqrt((double)(var32 * var32 + var23 * var23));
                  class18.cameraPitch = (int)(Math.atan2((double)var24, (double)var10) * 325.949D) & 2047;
                  class51.cameraYaw = (int)(Math.atan2((double)var23, (double)var32) * -325.949D) & 2047;
                  if(class18.cameraPitch < 128) {
                     class18.cameraPitch = 128;
                  }

                  if(class18.cameraPitch > 383) {
                     class18.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2249 == var1.serverPacket) {
               class2.method4(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2283 == var1.serverPacket) {
               var53 = var3.readString();
               var20 = var3.method3278();
               var87 = class87.method1762(var20);
               if(!var53.equals(var87.text)) {
                  var87.text = var53;
                  class40.method556(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2256 == var1.serverPacket) {
               while(var3.offset < var1.packetLength) {
                  var19 = var3.readUnsignedByte();
                  var82 = (var19 & 1) == 1;
                  var89 = var3.readString();
                  var55 = var3.readString();
                  var3.readString();

                  for(var24 = 0; var24 < ignoreCount; ++var24) {
                     Ignore var9 = ignores[var24];
                     if(var82) {
                        if(var55.equals(var9.name)) {
                           var9.name = var89;
                           var9.previousName = var55;
                           var89 = null;
                           break;
                        }
                     } else if(var89.equals(var9.name)) {
                        var9.name = var89;
                        var9.previousName = var55;
                        var89 = null;
                        break;
                     }
                  }

                  if(var89 != null && ignoreCount < 400) {
                     Ignore var61 = new Ignore();
                     ignores[ignoreCount] = var61;
                     var61.name = var89;
                     var61.previousName = var55;
                     ++ignoreCount;
                  }
               }

               field977 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2301 == var1.serverPacket) {
               var19 = var3.readInt();
               var20 = var3.readUnsignedShort();
               if(var19 < -70000) {
                  var20 += 32768;
               }

               if(var19 >= 0) {
                  var87 = class87.method1762(var19);
               } else {
                  var87 = null;
               }

               for(; var3.offset < var1.packetLength; WorldMapType2.setItemTableSlot(var20, var23, var24 - 1, var32)) {
                  var23 = var3.getUSmart();
                  var24 = var3.readUnsignedShort();
                  var32 = 0;
                  if(var24 != 0) {
                     var32 = var3.readUnsignedByte();
                     if(var32 == 255) {
                        var32 = var3.readInt();
                     }
                  }

                  if(var87 != null && var23 >= 0 && var23 < var87.itemIds.length) {
                     var87.itemIds[var23] = var24;
                     var87.itemQuantities[var23] = var32;
                  }
               }

               if(var87 != null) {
                  class40.method556(var87);
               }

               WorldMapType2.method529();
               interfaceItemTriggers[++field961 - 1 & 31] = var20 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2262 == var1.serverPacket) {
               World var51 = new World();
               var51.address = var3.readString();
               var51.id = var3.readUnsignedShort();
               var20 = var3.readInt();
               var51.mask = var20;
               class12.setGameState(45);
               var2.close();
               var2 = null;
               class82.method1683(var51);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2226 == var1.serverPacket) {
               for(var19 = 0; var19 < VarPlayerType.field3357; ++var19) {
                  VarPlayerType var86 = (VarPlayerType)VarPlayerType.varplayers.get((long)var19);
                  VarPlayerType var54;
                  if(var86 != null) {
                     var54 = var86;
                  } else {
                     byte[] var7 = VarPlayerType.varplayer_ref.getConfigData(16, var19);
                     var86 = new VarPlayerType();
                     if(var7 != null) {
                        var86.decode(new Buffer(var7));
                     }

                     VarPlayerType.varplayers.put(var86, (long)var19);
                     var54 = var86;
                  }

                  if(var54 != null) {
                     class218.settings[var19] = 0;
                     class218.widgetSettings[var19] = 0;
                  }
               }

               WorldMapType2.method529();
               field1041 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2261 == var1.serverPacket) {
               var19 = var3.readUnsignedByte();
               var20 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var23 = var3.readUnsignedByte();
               field1101[var19] = true;
               field1102[var19] = var20;
               field935[var19] = var6;
               field872[var19] = var23;
               field1091[var19] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2270 == var1.serverPacket) {
               WorldMapType2.method529();
               var19 = var3.method3279();
               var20 = var3.method3422();
               var6 = var3.method3380();
               skillExperiences[var6] = var19;
               boostedSkillLevels[var6] = var20;
               realSkillLevels[var6] = 1;

               for(var23 = 0; var23 < 98; ++var23) {
                  if(var19 >= class229.field2912[var23]) {
                     realSkillLevels[var6] = var23 + 2;
                  }
               }

               field1092[++field894 - 1 & 31] = var6;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2242 == var1.serverPacket) {
               destinationX = var3.readUnsignedByte();
               if(destinationX == 255) {
                  destinationX = 0;
               }

               destinationY = var3.readUnsignedByte();
               if(destinationY == 255) {
                  destinationY = 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2293 == var1.serverPacket) {
               var19 = var3.method3279();
               var20 = var3.readUnsignedShortOb1();
               var6 = var20 >> 10 & 31;
               var23 = var20 >> 5 & 31;
               var24 = var20 & 31;
               var32 = (var23 << 11) + (var6 << 19) + (var24 << 3);
               Widget var36 = class87.method1762(var19);
               if(var32 != var36.textColor) {
                  var36.textColor = var32;
                  class40.method556(var36);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2229 == var1.serverPacket) {
               class72.method1149(class169.field2411);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2253 == var1.serverPacket) {
               WorldMapType2.method529();
               weight = var3.readShort();
               field1051 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2244 == var1.serverPacket) {
               field1088 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2268 == var1.serverPacket) {
               Tile.xteaChanged(false, var1.field1465);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2286 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               class285[] var29 = class177.method3269();
               var23 = 0;

               class285 var49;
               while(true) {
                  if(var23 >= var29.length) {
                     var49 = null;
                     break;
                  }

                  class285 var8 = var29[var23];
                  if(var20 == var8.field3784) {
                     var49 = var8;
                     break;
                  }

                  ++var23;
               }

               class221.field2705 = var49;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2294 == var1.serverPacket) {
               for(var19 = 0; var19 < class218.widgetSettings.length; ++var19) {
                  if(class218.settings[var19] != class218.widgetSettings[var19]) {
                     class218.widgetSettings[var19] = class218.settings[var19];
                     GraphicsObject.method1724(var19);
                     field1040[++field1041 - 1 & 31] = var19;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2288 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  class14.method88(widgetRoot, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2267 == var1.serverPacket) {
               var19 = var3.method3334();
               ItemContainer var52 = (ItemContainer)ItemContainer.itemContainers.get((long)var19);
               if(var52 != null) {
                  var52.unlink();
               }

               interfaceItemTriggers[++field961 - 1 & 31] = var19 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2252 == var1.serverPacket) {
               class72.method1149(class169.field2413);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2248 == var1.serverPacket) {
               class72.method1149(class169.field2410);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2272 == var1.serverPacket) {
               var19 = var3.method3278();
               var50 = class87.method1762(var19);
               var50.modelType = 3;
               var50.modelId = class181.localPlayer.composition.method4141();
               class40.method556(var50);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2221 == var1.serverPacket) {
               class23.field339 = var3.readUnsignedByte();
               class211.field2628 = var3.readUnsignedByte();

               for(var19 = class23.field339; var19 < class23.field339 + 8; ++var19) {
                  for(var20 = class211.field2628; var20 < class211.field2628 + 8; ++var20) {
                     if(groundItemDeque[class233.plane][var19][var20] != null) {
                        groundItemDeque[class233.plane][var19][var20] = null;
                        class139.groundItemSpawned(var19, var20);
                     }
                  }
               }

               for(PendingSpawn var48 = (PendingSpawn)pendingSpawns.getFront(); var48 != null; var48 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var48.x >= class23.field339 && var48.x < class23.field339 + 8 && var48.y >= class211.field2628 && var48.y < class211.field2628 + 8 && var48.level == class233.plane) {
                     var48.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2241 == var1.serverPacket) {
               class72.method1149(class169.field2415);
               var1.serverPacket = null;
               return true;
            }

            Item.method1829("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1475 != null?var1.field1475.packetId:-1) + "," + (var1.field1478 != null?var1.field1478.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            Renderable.method2993();
         } catch (IOException var46) {
            class111.method2179();
         } catch (Exception var47) {
            var5 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1475 != null?var1.field1475.packetId:-1) + "," + (var1.field1478 != null?var1.field1478.packetId:-1) + "," + var1.packetLength + "," + (class181.localPlayer.pathX[0] + IndexDataBase.baseX) + "," + (class181.localPlayer.pathY[0] + Occluder.baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var5 = var5 + var3.payload[var6] + ",";
            }

            Item.method1829(var5, var47);
            Renderable.method2993();
         }

         return true;
      }
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1731443372"
   )
   final void method1209() {
      boolean var1 = false;

      int var2;
      int var5;
      while(!var1) {
         var1 = true;

         for(var2 = 0; var2 < menuOptionCount - 1; ++var2) {
            if(menuTypes[var2] < 1000 && menuTypes[var2 + 1] > 1000) {
               String var3 = menuTargets[var2];
               menuTargets[var2] = menuTargets[var2 + 1];
               menuTargets[var2 + 1] = var3;
               String var4 = menuOptions[var2];
               menuOptions[var2] = menuOptions[var2 + 1];
               menuOptions[var2 + 1] = var4;
               var5 = menuTypes[var2];
               menuTypes[var2] = menuTypes[var2 + 1];
               menuTypes[var2 + 1] = var5;
               var5 = menuActionParams0[var2];
               menuActionParams0[var2] = menuActionParams0[var2 + 1];
               menuActionParams0[var2 + 1] = var5;
               var5 = menuActionParams1[var2];
               menuActionParams1[var2] = menuActionParams1[var2 + 1];
               menuActionParams1[var2 + 1] = var5;
               var5 = menuIdentifiers[var2];
               menuIdentifiers[var2] = menuIdentifiers[var2 + 1];
               menuIdentifiers[var2 + 1] = var5;
               boolean var6 = field889[var2];
               field889[var2] = field889[var2 + 1];
               field889[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(WorldMapType2.field492 == null) {
         if(field1027 == null) {
            int var13 = MouseInput.field708;
            int var9;
            int var11;
            int var14;
            if(isMenuOpen) {
               int var10;
               if(var13 != 1 && (field956 || var13 != 4)) {
                  var2 = MouseInput.field703;
                  var10 = MouseInput.field715 * 10625923;
                  if(var2 < class177.menuX - 10 || var2 > WorldMapType1.menuWidth + class177.menuX + 10 || var10 < class1.menuY - 10 || var10 > class91.menuHeight + class1.menuY + 10) {
                     isMenuOpen = false;
                     class44.method636(class177.menuX, class1.menuY, WorldMapType1.menuWidth, class91.menuHeight);
                  }
               }

               if(var13 == 1 || !field956 && var13 == 4) {
                  var2 = class177.menuX;
                  var10 = class1.menuY;
                  var11 = WorldMapType1.menuWidth;
                  var5 = MouseInput.field709;
                  var14 = MouseInput.field710;
                  int var7 = -1;

                  for(int var15 = 0; var15 < menuOptionCount; ++var15) {
                     var9 = (menuOptionCount - 1 - var15) * 15 + var10 + 31;
                     if(var5 > var2 && var5 < var2 + var11 && var14 > var9 - 13 && var14 < var9 + 3) {
                        var7 = var15;
                     }
                  }

                  if(var7 != -1) {
                     ScriptEvent.method1121(var7);
                  }

                  isMenuOpen = false;
                  class44.method636(class177.menuX, class1.menuY, WorldMapType1.menuWidth, class91.menuHeight);
               }
            } else {
               label293: {
                  var2 = menuOptionCount - 1;
                  if((var13 == 1 || !field956 && var13 == 4) && var2 >= 0) {
                     var11 = menuTypes[var2];
                     if(var11 == 39 || var11 == 40 || var11 == 41 || var11 == 42 || var11 == 43 || var11 == 33 || var11 == 34 || var11 == 35 || var11 == 36 || var11 == 37 || var11 == 38 || var11 == 1005) {
                        var5 = menuActionParams0[var2];
                        var14 = menuActionParams1[var2];
                        Widget var12 = class87.method1762(var14);
                        var9 = ClanMember.getWidgetConfig(var12);
                        boolean var8 = (var9 >> 28 & 1) != 0;
                        if(var8) {
                           break label293;
                        }

                        Object var10000 = null;
                        if(class156.method3091(ClanMember.getWidgetConfig(var12))) {
                           break label293;
                        }
                     }
                  }

                  if((var13 == 1 || !field956 && var13 == 4) && this.method1210()) {
                     var13 = 2;
                  }

                  if((var13 == 1 || !field956 && var13 == 4) && menuOptionCount > 0) {
                     ScriptEvent.method1121(var2);
                  }

                  if(var13 == 2 && menuOptionCount > 0) {
                     this.method1211(MouseInput.field709, MouseInput.field710);
                  }

                  return;
               }

               if(WorldMapType2.field492 != null && !field971 && menuOptionCount > 0 && !this.method1210()) {
                  SoundTask.method2175(field968, field969);
               }

               field971 = false;
               field1012 = 0;
               if(WorldMapType2.field492 != null) {
                  class40.method556(WorldMapType2.field492);
               }

               WorldMapType2.field492 = class87.method1762(var14);
               field1076 = var5;
               field968 = MouseInput.field709;
               field969 = MouseInput.field710;
               if(var2 >= 0) {
                  class8.method48(var2);
               }

               class40.method556(WorldMapType2.field492);
               return;
            }

         }
      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2147483645"
   )
   final boolean method1210() {
      int var1 = menuOptionCount - 1;
      return menuOptionCount > 2 && (field1021 == 1 && !field889[var1] || Occluder.method3015(var1));
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1439279793"
   )
   final void method1211(int var1, int var2) {
      int var3 = World.field1226.method4925("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = World.field1226.method4925(GameObject.method3020(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var3 + var5 > class86.canvasWidth) {
         var5 = class86.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var2 + var4 > GameEngine.canvasHeight) {
         var6 = GameEngine.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class14.region.method2970(class233.plane, var1, var2, false);
      isMenuOpen = true;
      class177.menuX = var5;
      class1.menuY = var6;
      WorldMapType1.menuWidth = var3;
      class91.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "238602006"
   )
   final void method1257(boolean var1) {
      class47.method711(widgetRoot, class86.canvasWidth, GameEngine.canvasHeight, var1);
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(Lhx;I)V",
      garbageValue = "416104499"
   )
   void method1213(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class87.method1762(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class86.canvasWidth;
         var4 = GameEngine.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class11.method64(var1, var3, var4, false);
      SoundTask.method2177(var1, var3, var4);
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1004139382"
   )
   final void method1214() {
      class40.method556(field1027);
      ++class37.field488;
      if(field991 && field1046) {
         int var1 = MouseInput.field703;
         int var2 = MouseInput.field715 * 10625923;
         var1 -= field1029;
         var2 -= field953;
         if(var1 < field1033) {
            var1 = field1033;
         }

         if(var1 + field1027.width > field1033 + field1028.width) {
            var1 = field1033 + field1028.width - field1027.width;
         }

         if(var2 < field1034) {
            var2 = field1034;
         }

         if(var2 + field1027.height > field1034 + field1028.height) {
            var2 = field1034 + field1028.height - field1027.height;
         }

         int var3 = var1 - field1103;
         int var4 = var2 - field1037;
         int var5 = field1027.field2800;
         if(class37.field488 > field1027.field2801 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1014 = true;
         }

         int var6 = var1 - field1033 + field1028.scrollX;
         int var7 = var2 - field1034 + field1028.scrollY;
         ScriptEvent var8;
         if(field1027.field2813 != null && field1014) {
            var8 = new ScriptEvent();
            var8.widget = field1027;
            var8.field800 = var6;
            var8.field801 = var7;
            var8.field797 = field1027.field2813;
            class14.method95(var8);
         }

         if(MouseInput.field705 == 0) {
            if(field1014) {
               if(field1027.field2814 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1027;
                  var8.field800 = var6;
                  var8.field801 = var7;
                  var8.field803 = field890;
                  var8.field797 = field1027.field2814;
                  class14.method95(var8);
               }

               if(field890 != null) {
                  Widget var9 = field1027;
                  int var10 = class17.method146(ClanMember.getWidgetConfig(var9));
                  Widget var13;
                  if(var10 == 0) {
                     var13 = null;
                  } else {
                     int var11 = 0;

                     while(true) {
                        if(var11 >= var10) {
                           var13 = var9;
                           break;
                        }

                        var9 = class87.method1762(var9.parentId);
                        if(var9 == null) {
                           var13 = null;
                           break;
                        }

                        ++var11;
                     }
                  }

                  if(var13 != null) {
                     PacketNode var12 = class218.method4105(ClientPacket.field2350, field916.field1470);
                     var12.packetBuffer.putShortLE(field1027.itemId);
                     var12.packetBuffer.method3330(field890.index);
                     var12.packetBuffer.method3341(field1027.id);
                     var12.packetBuffer.method3341(field890.id);
                     var12.packetBuffer.method3332(field890.itemId);
                     var12.packetBuffer.putShortLE(field1027.index);
                     field916.method1925(var12);
                  }
               }
            } else if(this.method1210()) {
               this.method1211(field1029 + field1103, field1037 + field953);
            } else if(menuOptionCount > 0) {
               SoundTask.method2175(field1029 + field1103, field953 + field1037);
            }

            field1027 = null;
         }

      } else {
         if(class37.field488 > 1) {
            field1027 = null;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1367319984"
   )
   static String method1570(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-53"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class25.method190();
      ++field916.field1468;
      if(field916.field1468 >= 50 || var0) {
         field916.field1468 = 0;
         if(!socketError && field916.method1933() != null) {
            PacketNode var1 = class218.method4105(ClientPacket.field2351, field916.field1470);
            field916.method1925(var1);

            try {
               field916.method1927();
            } catch (IOException var3) {
               socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("kl")
   @ObfuscatedSignature(
      signature = "(Lfr;IB)V",
      garbageValue = "104"
   )
   static void method1568(Buffer var0, int var1) {
      byte[] var2 = var0.payload;
      if(field1083 == null) {
         field1083 = new byte[24];
      }

      class190.method3621(var2, var1, field1083, 0, 24);
      if(class156.field2155 != null) {
         try {
            class156.field2155.seek(0L);
            class156.field2155.write(var0.payload, var1, 24);
         } catch (Exception var4) {
            ;
         }
      }

   }
}
