import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 354760685
   )
   static int field1050;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -608019347
   )
   static int field866;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      longValue = 4519519307642444067L
   )
   static long field1016;
   @ObfuscatedName("mc")
   static boolean[] field1052;
   @ObfuscatedName("ml")
   static boolean[] field872;
   @ObfuscatedName("mj")
   static boolean[] field1053;
   @ObfuscatedName("kc")
   static boolean field1028;
   @ObfuscatedName("mw")
   @Export("isResized")
   @Hook("resizeChanged")
   static boolean isResized;
   @ObfuscatedName("kx")
   static boolean field1025;
   @ObfuscatedName("oo")
   static boolean field1084;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -1592015269
   )
   static int field1022;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -458246447
   )
   static int field1121;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 386787637
   )
   static int field1026;
   @ObfuscatedName("ob")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   static class101 field1087;
   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1021;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 1688788375
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("mx")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("mn")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 1714988881
   )
   static int field1059;
   @ObfuscatedName("mr")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("og")
   static boolean field1094;
   @ObfuscatedName("mf")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("pz")
   static boolean[] field1095;
   @ObfuscatedName("ms")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -1137486451
   )
   static int field985;
   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "Lbu;"
   )
   static final class72 field888;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = -1483228127
   )
   static int field1085;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -847219651
   )
   static int field1029;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = 1255000015
   )
   static int field1030;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 1340895321
   )
   static int field1031;
   @ObfuscatedName("of")
   static int[] field956;
   @ObfuscatedName("on")
   static int[] field986;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = 1882439481
   )
   static int field1083;
   @ObfuscatedName("op")
   static int[] field1086;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 1582995733
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1449806909
   )
   static int field864;
   @ObfuscatedName("lo")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static Deque field862;
   @ObfuscatedName("ok")
   @ObfuscatedSignature(
      signature = "[Ldq;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("qj")
   static int[] field1125;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 425078157
   )
   static int field1051;
   @ObfuscatedName("qo")
   static int[] field1126;
   @ObfuscatedName("ou")
   static int[] field1092;
   @ObfuscatedName("lu")
   static boolean field993;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -75012003
   )
   static int field1081;
   @ObfuscatedName("lm")
   static int[] field1033;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = -879275413
   )
   static int field1034;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 997794273
   )
   static int field1089;
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   static PlayerComposition field1119;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -1635876149
   )
   static int field874;
   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1024;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      longValue = 3619114740126650849L
   )
   static long field1071;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -929816071
   )
   static int field1075;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 149157167
   )
   static int field1046;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 1548862993
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = -2069103969
   )
   static int field1108;
   @ObfuscatedName("nx")
   static long[] field1066;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = -2053061239
   )
   static int field945;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = -36335785
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = 1505699649
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "[Lbx;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("nz")
   @ObfuscatedSignature(
      signature = "[Lkb;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -1731562557
   )
   static int field1067;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 1313321867
   )
   static int field1040;
   @ObfuscatedName("nb")
   static int[] field1060;
   @ObfuscatedName("nl")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("nt")
   static int[] field891;
   @ObfuscatedName("ng")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("pm")
   static short field1101;
   @ObfuscatedName("pl")
   static short field1100;
   @ObfuscatedName("pw")
   static short field1106;
   @ObfuscatedName("pp")
   static short field1107;
   @ObfuscatedName("ph")
   static short field1105;
   @ObfuscatedName("px")
   static short field1102;
   @ObfuscatedName("po")
   static short field1103;
   @ObfuscatedName("pg")
   static short field1104;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -1507826639
   )
   @Export(
      value = "chatCycle",
      setter = true
   )
   static int chatCycle;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 1126779973
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -620742599
   )
   static int field1063;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = 1804785165
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 223989977
   )
   static int field1068;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 223620855
   )
   static int field1064;
   @ObfuscatedName("np")
   static int[] field970;
   @ObfuscatedName("nj")
   static int[] field1069;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = -622143281
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("md")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static Deque field1047;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = 1064959553
   )
   static int field1099;
   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "[Lh;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -1126799589
   )
   static int field1109;
   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static Deque field1048;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 1337712495
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("lw")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 828573721
   )
   static int field1114;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1826860343
   )
   static int field973;
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "[Lbh;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1297827589
   )
   static int field1042;
   @ObfuscatedName("pb")
   static int[] field1074;
   @ObfuscatedName("pk")
   static int[] field868;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 1736187641
   )
   static int field967;
   @ObfuscatedName("pt")
   static int[] field1098;
   @ObfuscatedName("pj")
   static int[] field990;
   @ObfuscatedName("ln")
   static int[] field1037;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -1963790127
   )
   static int field1038;
   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   static class202 field1116;
   @ObfuscatedName("nf")
   static String field1065;
   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "Lbo;"
   )
   static class74 field1123;
   @ObfuscatedName("mt")
   static int[] field1062;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfy;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("ad")
   static boolean field1079;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -594959723
   )
   @Export("world")
   static int world;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -380435631
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -546972617
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bt")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("be")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -922963929
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -128959435
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("bp")
   static boolean field1005;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1527478573
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      longValue = -286638198342117477L
   )
   static long field1090;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1326408759
   )
   static int field989;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1125721451
   )
   static int field916;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 225684977
   )
   static int field875;
   @ObfuscatedName("bd")
   static boolean field876;
   @ObfuscatedName("bo")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 126529393
   )
   static int field910;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -83569217
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 978849539
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1300494335
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1334027659
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1186690647
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1319787991
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1914851789
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -1849793863
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   static class90 field1096;
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   static class90 field950;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1891921009
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 460098931
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -222891889
   )
   static int field1082;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      longValue = -5803781745778909445L
   )
   static long field863;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 1277200689
   )
   static int field893;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 2042333135
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -1907106279
   )
   static int field895;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = -995825443
   )
   static int field896;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 244747407
   )
   static int field897;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   static class150 field898;
   @ObfuscatedName("dz")
   static byte[] field983;
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "[Lcj;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -287658411
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("df")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 684614915
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("en")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lci;"
   )
   static final class100 field905;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1854997685
   )
   static int field906;
   @ObfuscatedName("ei")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "Ljg;"
   )
   static class283 field976;
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static class269 field932;
   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   static Font field909;
   @ObfuscatedName("et")
   static HashMap field1041;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 1603530547
   )
   static int field912;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -828891087
   )
   static int field913;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 517703053
   )
   static int field914;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1987845017
   )
   static int field1088;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 122207395
   )
   static int field1023;
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("fy")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fr")
   static int[][][] field1011;
   @ObfuscatedName("fp")
   static final int[] field1076;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1985976935
   )
   static int field922;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1533663247
   )
   static int field1061;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 243852239
   )
   static int field924;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -1871154093
   )
   static int field925;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 198693067
   )
   static int field926;
   @ObfuscatedName("gj")
   static boolean field927;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -642335799
   )
   static int field928;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 661127125
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1249876983
   )
   static int field930;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1999889571
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1766152667
   )
   static int field903;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1144887967
   )
   static int field933;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 1760369831
   )
   static int field934;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -426113343
   )
   static int field935;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 1189355587
   )
   static int field902;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1999028685
   )
   static int field937;
   @ObfuscatedName("gg")
   static boolean field938;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1508617623
   )
   static int field1055;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 401772267
   )
   static int field940;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1387736477
   )
   static int field1054;
   @ObfuscatedName("gw")
   static int[] field942;
   @ObfuscatedName("gc")
   static int[] field1120;
   @ObfuscatedName("gb")
   static int[] field944;
   @ObfuscatedName("gk")
   static int[] field904;
   @ObfuscatedName("hd")
   static int[] field900;
   @ObfuscatedName("hw")
   static int[] field947;
   @ObfuscatedName("hs")
   static int[] field931;
   @ObfuscatedName("hj")
   static String[] field949;
   @ObfuscatedName("hp")
   static int[][] field920;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -312315445
   )
   static int field951;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 2103505473
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 1433468253
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -703635221
   )
   static int field954;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1324954857
   )
   static int field955;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = -220416887
   )
   static int field968;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1676787985
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -1172591501
   )
   static int field958;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -244310291
   )
   static int field959;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -1355581733
   )
   static int field890;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 221557373
   )
   static int field923;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -262811849
   )
   static int field962;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 498257487
   )
   static int field1111;
   @ObfuscatedName("hz")
   static boolean field964;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -1085854147
   )
   static int field965;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 274423751
   )
   static int field966;
   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "[Lbd;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 43144119
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 520177251
   )
   static int field969;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 481796737
   )
   static int field1036;
   @ObfuscatedName("io")
   static int[] field971;
   @ObfuscatedName("il")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("ij")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("iu")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("is")
   static int[] field865;
   @ObfuscatedName("it")
   static String field1001;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 418731725
   )
   static int field1070;
   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "[[[Lgg;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("ie")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("if")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("iv")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 1156882463
   )
   static int field984;
   @ObfuscatedName("ig")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -1016488719
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("jp")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jc")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jx")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("jh")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("ju")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("jz")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jn")
   static boolean[] field943;
   @ObfuscatedName("js")
   static boolean field994;
   @ObfuscatedName("je")
   static boolean field995;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -40861257
   )
   static int field996;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 1728918267
   )
   static int field1124;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -1032251335
   )
   static int field998;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 1822981701
   )
   static int field975;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -203637335
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("jg")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 822884271
   )
   static int field1003;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -1818106769
   )
   static int field1004;
   @ObfuscatedName("kl")
   static String field1045;
   @ObfuscatedName("kv")
   static String field948;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 900552797
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 241041337
   )
   static int field1009;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -787753855
   )
   static int field1010;
   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field878;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 495608037
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 684307151
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1268508369
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1974233585
   )
   static int field1015;
   @ObfuscatedName("kk")
   static boolean field979;
   @ObfuscatedName("kp")
   static boolean field1017;
   @ObfuscatedName("kj")
   static boolean field1018;
   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1019;
   @ObfuscatedName("kh")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1020;

   static {
      field1079 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field1005 = true;
      gameCycle = 0;
      field1090 = -1L;
      field989 = -1;
      field916 = -1;
      field875 = -1;
      field876 = true;
      displayFps = false;
      field910 = 0;
      hintArrowTargetType = 0;
      hintArrowNpcTargetIdx = 0;
      hintArrowPlayerTargetIdx = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      hintArrowOffsetX = 0;
      hintArrowOffsetY = 0;
      field1096 = class90.field1328;
      field950 = class90.field1328;
      loadingStage = 0;
      js5State = 0;
      field1082 = 0;
      field893 = 0;
      loginState = 0;
      field895 = 0;
      field896 = 0;
      field897 = 0;
      field898 = class150.field2103;
      field983 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field905 = new class100();
      field906 = 0;
      socketError = false;
      field976 = new class283();
      field1041 = new HashMap();
      field912 = 0;
      field913 = 1;
      field914 = 0;
      field1088 = 1;
      field1023 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field1011 = new int[4][13][13];
      field1076 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field922 = 0;
      field1061 = 2301979;
      field924 = 5063219;
      field925 = 3353893;
      field926 = 7759444;
      field927 = false;
      field928 = 0;
      field930 = 128;
      mapAngle = 0;
      field903 = 0;
      field933 = 0;
      field934 = 0;
      field935 = 0;
      field902 = 50;
      field937 = 0;
      field938 = false;
      field1055 = 0;
      field940 = 0;
      field1054 = 50;
      field942 = new int[field1054];
      field1120 = new int[field1054];
      field944 = new int[field1054];
      field904 = new int[field1054];
      field900 = new int[field1054];
      field947 = new int[field1054];
      field931 = new int[field1054];
      field949 = new String[field1054];
      field920 = new int[104][104];
      field951 = 0;
      screenY = -1;
      screenX = -1;
      field954 = 0;
      field955 = 0;
      field968 = 0;
      cursorState = 0;
      field958 = 0;
      field959 = 0;
      field890 = 0;
      field923 = 0;
      field962 = 0;
      field1111 = 0;
      field964 = false;
      field965 = 0;
      field966 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field969 = 0;
      field1036 = 0;
      field971 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field865 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1070 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field984 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field943 = new boolean[500];
      field994 = false;
      field995 = false;
      field996 = -1;
      field1124 = -1;
      field998 = 0;
      field975 = 50;
      itemSelectionState = 0;
      field1001 = null;
      spellSelected = false;
      field1003 = -1;
      field1004 = -1;
      field1045 = null;
      field948 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1009 = 0;
      field1010 = 0;
      field878 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1015 = -1;
      field979 = false;
      field1017 = false;
      field1018 = false;
      field1019 = null;
      field1020 = null;
      field1021 = null;
      field1022 = 0;
      field1121 = 0;
      field1024 = null;
      field1025 = false;
      field1026 = -1;
      field1059 = -1;
      field1028 = false;
      field1029 = -1;
      field1030 = -1;
      field993 = false;
      cycleCntr = 1;
      field1033 = new int[32];
      field1034 = 0;
      interfaceItemTriggers = new int[32];
      field973 = 0;
      field1037 = new int[32];
      field1038 = 0;
      chatCycle = 0;
      field1040 = 0;
      field1046 = 0;
      field1042 = 0;
      field967 = 0;
      field864 = 0;
      field985 = 0;
      field862 = new Deque();
      field1047 = new Deque();
      field1048 = new Deque();
      widgetFlags = new HashTable(512);
      field1050 = 0;
      field866 = -2;
      field1052 = new boolean[100];
      field1053 = new boolean[100];
      field872 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1016 = 0L;
      isResized = true;
      field1062 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      field1063 = 0;
      field1064 = 0;
      field1065 = "";
      field1066 = new long[100];
      field1067 = 0;
      field1068 = 0;
      field1069 = new int[128];
      field970 = new int[128];
      field1071 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1081 = -1;
      field1075 = 0;
      field1060 = new int[1000];
      field891 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1108 = 0;
      field945 = 255;
      field1083 = -1;
      field1084 = false;
      field1085 = 127;
      field1051 = 127;
      field1031 = 0;
      field956 = new int[50];
      field986 = new int[50];
      field1086 = new int[50];
      field1092 = new int[50];
      audioEffects = new SoundEffect[50];
      field1094 = false;
      field1095 = new boolean[5];
      field868 = new int[5];
      field1074 = new int[5];
      field1098 = new int[5];
      field990 = new int[5];
      field1100 = 256;
      field1101 = 205;
      field1102 = 256;
      field1103 = 320;
      field1104 = 1;
      field1105 = 32767;
      field1106 = 1;
      field1107 = 32767;
      field1099 = 0;
      field1109 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1114 = 0;
      friends = new Friend[400];
      field1116 = new class202();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1119 = new PlayerComposition();
      field1089 = -1;
      field874 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1123 = new class74();
      field888 = new class72();
      field1125 = new int[50];
      field1126 = new int[50];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "62842239"
   )
   protected final void vmethod1351() {
      field1016 = ChatLineBuffer.currentTimeMs() + 500L;
      this.method1117();
      if(widgetRoot != -1) {
         this.method1123(true);
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   protected final void vmethod1107() {
      int[] var1 = new int[]{20, 260, 10000};
      int[] var2 = new int[]{1000, 100, 500};
      if(var1 != null && var2 != null) {
         FrameMap.field1954 = var1;
         class181.field2504 = new int[var1.length];
         class90.field1323 = new byte[var1.length][][];

         for(int var3 = 0; var3 < FrameMap.field1954.length; ++var3) {
            class90.field1323[var3] = new byte[var2[var3]][];
         }
      } else {
         FrameMap.field1954 = null;
         class181.field2504 = null;
         class90.field1323 = null;
      }

      Ignore.field790 = socketType == 0?43594:world + 40000;
      class12.field257 = socketType == 0?443:world + 50000;
      class70.myWorldPort = Ignore.field790;
      class91.colorsToFind = class221.field2698;
      PlayerComposition.colorsToReplace = class221.field2696;
      VertexNormal.field1910 = class221.field2699;
      class5.field26 = class221.field2697;
      InvType.field3331 = new class148();
      this.method797();
      this.method879();
      class274.field3717 = this.method820();
      class7.field223 = new IndexFile(255, class156.field2148, class156.field2153, 500000);
      class70.preferences = class5.method15();
      this.method847();
      class7.method37(this, class44.field537);
      if(socketType != 0) {
         displayFps = true;
      }

      World.method1532(class70.preferences.screenType);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();

      while(true) {
         Deque var2 = class243.field3291;
         FileSystem var1;
         synchronized(class243.field3291) {
            var1 = (FileSystem)class243.field3289.popFront();
         }

         if(var1 == null) {
            class268.method4740();
            class90.method1683();
            class44.method590();
            MouseInput var47 = MouseInput.mouse;
            synchronized(MouseInput.mouse) {
               MouseInput.field689 = MouseInput.field677;
               MouseInput.field681 = MouseInput.mouseX;
               MouseInput.field676 = MouseInput.mouseY;
               MouseInput.field687 = MouseInput.field683;
               MouseInput.field674 = MouseInput.field684;
               MouseInput.field688 = MouseInput.field691;
               MouseInput.field690 = MouseInput.field686;
               MouseInput.field683 = 0;
            }

            if(class274.field3717 != null) {
               int var32 = class274.field3717.vmethod2987();
               field985 = var32;
            }

            if(gameState == 0) {
               ScriptVarType.load();
               RSCanvas.method734();
            } else if(gameState == 5) {
               class87.method1677(this);
               ScriptVarType.load();
               RSCanvas.method734();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class87.method1677(this);
                  this.method1281();
               } else if(gameState == 25) {
                  class31.flush(false);
                  field912 = 0;
                  boolean var49 = true;

                  int var33;
                  for(var33 = 0; var33 < class111.field1578.length; ++var33) {
                     if(class91.landMapFileIds[var33] != -1 && class111.field1578[var33] == null) {
                        class111.field1578[var33] = RSCanvas.indexMaps.getConfigData(class91.landMapFileIds[var33], 0);
                        if(class111.field1578[var33] == null) {
                           var49 = false;
                           ++field912;
                        }
                     }

                     if(class41.landRegionFileIds[var33] != -1 && class89.field1320[var33] == null) {
                        class89.field1320[var33] = RSCanvas.indexMaps.getConfigData(class41.landRegionFileIds[var33], 0, class51.xteaKeys[var33]);
                        if(class89.field1320[var33] == null) {
                           var49 = false;
                           ++field912;
                        }
                     }
                  }

                  if(!var49) {
                     field1023 = 1;
                  } else {
                     field914 = 0;
                     var49 = true;

                     int var4;
                     int var5;
                     for(var33 = 0; var33 < class111.field1578.length; ++var33) {
                        byte[] var3 = class89.field1320[var33];
                        if(var3 != null) {
                           var4 = (class87.mapRegions[var33] >> 8) * 64 - class13.baseX;
                           var5 = (class87.mapRegions[var33] & 255) * 64 - ClanMember.baseY;
                           if(isDynamicRegion) {
                              var4 = 10;
                              var5 = 10;
                           }

                           var49 &= class215.method3924(var3, var4, var5);
                        }
                     }

                     if(!var49) {
                        field1023 = 2;
                     } else {
                        if(field1023 != 0) {
                           IndexFile.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        class90.method1683();
                        class48.method673();
                        class90.method1683();
                        region.reset();
                        class90.method1683();
                        System.gc();

                        for(var33 = 0; var33 < 4; ++var33) {
                           collisionMaps[var33].reset();
                        }

                        int var34;
                        for(var33 = 0; var33 < 4; ++var33) {
                           for(var34 = 0; var34 < 104; ++var34) {
                              for(var4 = 0; var4 < 104; ++var4) {
                                 class61.tileSettings[var33][var34][var4] = 0;
                              }
                           }
                        }

                        class90.method1683();
                        class61.field705 = 99;
                        class233.field3204 = new byte[4][104][104];
                        class37.field474 = new byte[4][104][104];
                        class61.field702 = new byte[4][104][104];
                        class19.field296 = new byte[4][104][104];
                        class27.field368 = new int[4][105][105];
                        class175.field2440 = new byte[4][105][105];
                        class61.field703 = new int[105][105];
                        class61.field706 = new int[104];
                        class61.field707 = new int[104];
                        class61.field719 = new int[104];
                        class47.field555 = new int[104];
                        FileOnDisk.field1680 = new int[104];
                        var33 = class111.field1578.length;
                        Widget.method4065();
                        class31.flush(true);
                        int var7;
                        int var8;
                        int var10;
                        int var11;
                        int var12;
                        int var13;
                        int var15;
                        int var16;
                        int var17;
                        int var18;
                        int var20;
                        int var21;
                        int var22;
                        int var37;
                        if(!isDynamicRegion) {
                           var34 = 0;

                           label653:
                           while(true) {
                              byte[] var6;
                              if(var34 >= var33) {
                                 for(var34 = 0; var34 < var33; ++var34) {
                                    var4 = (class87.mapRegions[var34] >> 8) * 64 - class13.baseX;
                                    var5 = (class87.mapRegions[var34] & 255) * 64 - ClanMember.baseY;
                                    var6 = class111.field1578[var34];
                                    if(var6 == null && class31.field411 < 800) {
                                       class90.method1683();
                                       class94.method1754(var4, var5, 64, 64);
                                    }
                                 }

                                 class31.flush(true);
                                 var34 = 0;

                                 while(true) {
                                    if(var34 >= var33) {
                                       break label653;
                                    }

                                    byte[] var36 = class89.field1320[var34];
                                    if(var36 != null) {
                                       var5 = (class87.mapRegions[var34] >> 8) * 64 - class13.baseX;
                                       var37 = (class87.mapRegions[var34] & 255) * 64 - ClanMember.baseY;
                                       class90.method1683();
                                       Region var38 = region;
                                       CollisionData[] var39 = collisionMaps;
                                       Buffer var48 = new Buffer(var36);
                                       var10 = -1;

                                       while(true) {
                                          var11 = var48.getUSmart();
                                          if(var11 == 0) {
                                             break;
                                          }

                                          var10 += var11;
                                          var12 = 0;

                                          while(true) {
                                             var13 = var48.getUSmart();
                                             if(var13 == 0) {
                                                break;
                                             }

                                             var12 += var13 - 1;
                                             int var42 = var12 & 63;
                                             var15 = var12 >> 6 & 63;
                                             var16 = var12 >> 12;
                                             var17 = var48.readUnsignedByte();
                                             var18 = var17 >> 2;
                                             int var43 = var17 & 3;
                                             var20 = var5 + var15;
                                             var21 = var42 + var37;
                                             if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                                var22 = var16;
                                                if((class61.tileSettings[1][var20][var21] & 2) == 2) {
                                                   var22 = var16 - 1;
                                                }

                                                CollisionData var44 = null;
                                                if(var22 >= 0) {
                                                   var44 = var39[var22];
                                                }

                                                class22.addObject(var16, var20, var21, var10, var43, var18, var38, var44);
                                             }
                                          }
                                       }
                                    }

                                    ++var34;
                                 }
                              }

                              var4 = (class87.mapRegions[var34] >> 8) * 64 - class13.baseX;
                              var5 = (class87.mapRegions[var34] & 255) * 64 - ClanMember.baseY;
                              var6 = class111.field1578[var34];
                              if(var6 != null) {
                                 class90.method1683();
                                 var7 = class36.field469 * 8 - 48;
                                 var8 = class31.field411 * 8 - 48;
                                 CollisionData[] var9 = collisionMaps;
                                 var10 = 0;

                                 label650:
                                 while(true) {
                                    if(var10 >= 4) {
                                       Buffer var35 = new Buffer(var6);
                                       var11 = 0;

                                       while(true) {
                                          if(var11 >= 4) {
                                             break label650;
                                          }

                                          for(var12 = 0; var12 < 64; ++var12) {
                                             for(var13 = 0; var13 < 64; ++var13) {
                                                class47.loadTerrain(var35, var11, var4 + var12, var13 + var5, var7, var8, 0);
                                             }
                                          }

                                          ++var11;
                                       }
                                    }

                                    for(var11 = 0; var11 < 64; ++var11) {
                                       for(var12 = 0; var12 < 64; ++var12) {
                                          if(var4 + var11 > 0 && var4 + var11 < 103 && var5 + var12 > 0 && var5 + var12 < 103) {
                                             var9[var10].flags[var11 + var4][var12 + var5] &= -16777217;
                                          }
                                       }
                                    }

                                    ++var10;
                                 }
                              }

                              ++var34;
                           }
                        }

                        int var40;
                        if(isDynamicRegion) {
                           var34 = 0;

                           label586:
                           while(true) {
                              if(var34 >= 4) {
                                 for(var34 = 0; var34 < 13; ++var34) {
                                    for(var4 = 0; var4 < 13; ++var4) {
                                       var5 = field1011[0][var34][var4];
                                       if(var5 == -1) {
                                          class94.method1754(var34 * 8, var4 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 class31.flush(true);
                                 var34 = 0;

                                 while(true) {
                                    if(var34 >= 4) {
                                       break label586;
                                    }

                                    class90.method1683();

                                    for(var4 = 0; var4 < 13; ++var4) {
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var37 = field1011[var34][var4][var5];
                                          if(var37 != -1) {
                                             var7 = var37 >> 24 & 3;
                                             var8 = var37 >> 1 & 3;
                                             var40 = var37 >> 14 & 1023;
                                             var10 = var37 >> 3 & 2047;
                                             var11 = (var40 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < class87.mapRegions.length; ++var12) {
                                                if(class87.mapRegions[var12] == var11 && class89.field1320[var12] != null) {
                                                   BaseVarType.method6(class89.field1320[var12], var34, var4 * 8, var5 * 8, var7, (var40 & 7) * 8, (var10 & 7) * 8, var8, region, collisionMaps);
                                                   break;
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var34;
                                 }
                              }

                              class90.method1683();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var51 = false;
                                    var7 = field1011[var34][var4][var5];
                                    if(var7 != -1) {
                                       var8 = var7 >> 24 & 3;
                                       var40 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var13 = 0; var13 < class87.mapRegions.length; ++var13) {
                                          if(class87.mapRegions[var13] == var12 && class111.field1578[var13] != null) {
                                             byte[] var14 = class111.field1578[var13];
                                             var15 = var4 * 8;
                                             var16 = var5 * 8;
                                             var17 = (var10 & 7) * 8;
                                             var18 = (var11 & 7) * 8;
                                             CollisionData[] var19 = collisionMaps;

                                             for(var20 = 0; var20 < 8; ++var20) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var20 + var15 > 0 && var20 + var15 < 103 && var16 + var21 > 0 && var21 + var16 < 103) {
                                                      var19[var34].flags[var15 + var20][var21 + var16] &= -16777217;
                                                   }
                                                }
                                             }

                                             Buffer var41 = new Buffer(var14);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(int var23 = 0; var23 < 64; ++var23) {
                                                      if(var8 == var21 && var22 >= var17 && var22 < var17 + 8 && var23 >= var18 && var23 < var18 + 8) {
                                                         int var26 = var15 + class72.method1061(var22 & 7, var23 & 7, var40);
                                                         int var29 = var22 & 7;
                                                         int var30 = var23 & 7;
                                                         int var31 = var40 & 3;
                                                         int var28;
                                                         if(var31 == 0) {
                                                            var28 = var30;
                                                         } else if(var31 == 1) {
                                                            var28 = 7 - var29;
                                                         } else if(var31 == 2) {
                                                            var28 = 7 - var30;
                                                         } else {
                                                            var28 = var29;
                                                         }

                                                         class47.loadTerrain(var41, var34, var26, var28 + var16, 0, 0, var40);
                                                      } else {
                                                         class47.loadTerrain(var41, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var51 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var51) {
                                       var8 = var34;
                                       var40 = var4 * 8;
                                       var10 = var5 * 8;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class61.tileHeights[var8][var11 + var40][var12 + var10] = 0;
                                          }
                                       }

                                       if(var40 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class61.tileHeights[var8][var40][var11 + var10] = class61.tileHeights[var8][var40 - 1][var11 + var10];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class61.tileHeights[var8][var11 + var40][var10] = class61.tileHeights[var8][var40 + var11][var10 - 1];
                                          }
                                       }

                                       if(var40 > 0 && class61.tileHeights[var8][var40 - 1][var10] != 0) {
                                          class61.tileHeights[var8][var40][var10] = class61.tileHeights[var8][var40 - 1][var10];
                                       } else if(var10 > 0 && class61.tileHeights[var8][var40][var10 - 1] != 0) {
                                          class61.tileHeights[var8][var40][var10] = class61.tileHeights[var8][var40][var10 - 1];
                                       } else if(var40 > 0 && var10 > 0 && class61.tileHeights[var8][var40 - 1][var10 - 1] != 0) {
                                          class61.tileHeights[var8][var40][var10] = class61.tileHeights[var8][var40 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var34;
                           }
                        }

                        class31.flush(true);
                        class48.method673();
                        class90.method1683();
                        class23.method164(region, collisionMaps);
                        class31.flush(true);
                        var34 = class61.field705;
                        if(var34 > class28.plane) {
                           var34 = class28.plane;
                        }

                        if(var34 < class28.plane - 1) {
                           var34 = class28.plane - 1;
                        }

                        if(lowMemory) {
                           region.setup(class61.field705);
                        } else {
                           region.setup(0);
                        }

                        for(var4 = 0; var4 < 104; ++var4) {
                           for(var5 = 0; var5 < 104; ++var5) {
                              ScriptEvent.groundItemSpawned(var4, var5);
                           }
                        }

                        class90.method1683();
                        class41.method559();
                        ObjectComposition.field3489.reset();
                        PacketNode var50;
                        if(class289.clientInstance.method824()) {
                           var50 = class18.method133(ClientPacket.field2367, field905.field1460);
                           var50.packetBuffer.putInt(1057001181);
                           field905.method1855(var50);
                        }

                        if(!isDynamicRegion) {
                           var4 = (class36.field469 - 6) / 8;
                           var5 = (class36.field469 + 6) / 8;
                           var37 = (class31.field411 - 6) / 8;
                           var7 = (class31.field411 + 6) / 8;

                           for(var8 = var4 - 1; var8 <= var5 + 1; ++var8) {
                              for(var40 = var37 - 1; var40 <= var7 + 1; ++var40) {
                                 if(var8 < var4 || var8 > var5 || var40 < var37 || var40 > var7) {
                                    RSCanvas.indexMaps.method4120("m" + var8 + "_" + var40);
                                    RSCanvas.indexMaps.method4120("l" + var8 + "_" + var40);
                                 }
                              }
                           }
                        }

                        class2.setGameState(30);
                        class90.method1683();
                        class233.field3204 = null;
                        class37.field474 = null;
                        class61.field702 = null;
                        class19.field296 = null;
                        class27.field368 = null;
                        class175.field2440 = null;
                        class61.field703 = null;
                        class61.field706 = null;
                        class61.field707 = null;
                        class61.field719 = null;
                        class47.field555 = null;
                        FileOnDisk.field1680 = null;
                        var50 = class18.method133(ClientPacket.field2357, field905.field1460);
                        field905.method1855(var50);
                        RSCanvas.method734();
                     }
                  }
               }
            } else {
               class87.method1677(this);
            }

            if(gameState == 30) {
               this.method1115();
            } else if(gameState == 40 || gameState == 45) {
               this.method1281();
            }

            return;
         }

         var1.data.method4213(var1.index, (int)var1.hash, var1.field3258, false);
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1081267098"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1109(boolean var1) {
      boolean var2;
      label168: {
         try {
            if(class210.field2585 == 2) {
               if(class210.field2588 == null) {
                  class210.field2588 = Track1.getMusicFile(class70.field802, class210.field2586, class31.field414);
                  if(class210.field2588 == null) {
                     var2 = false;
                     break label168;
                  }
               }

               if(class2.field12 == null) {
                  class2.field12 = new class111(class74.field845, class210.field2589);
               }

               if(class210.field2587.method3741(class210.field2588, class210.field2590, class2.field12, 22050)) {
                  class210.field2587.method3742();
                  class210.field2587.method3845(class230.field2909);
                  class210.field2587.method3763(class210.field2588, class230.field2905);
                  class210.field2585 = 0;
                  class210.field2588 = null;
                  class2.field12 = null;
                  class70.field802 = null;
                  var2 = true;
                  break label168;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class210.field2587.method3771();
            class210.field2585 = 0;
            class210.field2588 = null;
            class2.field12 = null;
            class70.field802 = null;
         }

         var2 = false;
      }

      if(var2 && field1084 && class3.soundSystem0 != null) {
         class3.soundSystem0.method2024();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1016 && ChatLineBuffer.currentTimeMs() > field1016) {
         World.method1532(PendingSpawn.method1494());
      }

      int var4;
      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1052[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class91.loadingBarPercentage, class91.loadingText, var1);
      } else if(gameState == 5) {
         class17.drawLoginScreen(field909, class27.field363, Tile.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class17.drawLoginScreen(field909, class27.field363, Tile.font_p12full, var1);
         } else if(gameState == 25) {
            if(field1023 == 1) {
               if(field912 > field913) {
                  field913 = field912;
               }

               var4 = (field913 * 50 - field912 * 50) / field913;
               IndexFile.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field1023 == 2) {
               if(field914 > field1088) {
                  field1088 = field914;
               }

               var4 = (field1088 * 50 - field914 * 50) / field1088 + 50;
               IndexFile.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               IndexFile.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1118();
         } else if(gameState == 40) {
            IndexFile.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            IndexFile.drawStatusBox("Please wait...", false);
         }
      } else {
         class17.drawLoginScreen(field909, class27.field363, Tile.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < field1050; ++var4) {
            if(field1053[var4]) {
               class236.field3227.vmethod5068(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1053[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class236.field3227.vmethod5065(0, 0);

         for(var4 = 0; var4 < field1050; ++var4) {
            field1053[var4] = false;
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "63"
   )
   protected final void vmethod1141() {
      if(Renderable.chatMessages.changed()) {
         Renderable.chatMessages.serialize();
      }

      if(class41.field519 != null) {
         class41.field519.field803 = false;
      }

      class41.field519 = null;
      field905.method1857();
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var1 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

      if(MouseInput.mouse != null) {
         MouseInput var9 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      class274.field3717 = null;
      if(class3.soundSystem0 != null) {
         class3.soundSystem0.method2046();
      }

      if(class226.soundSystem1 != null) {
         class226.soundSystem1.method2046();
      }

      class34.method472();
      Object var10 = class243.field3290;
      synchronized(class243.field3290) {
         if(class243.field3288 != 0) {
            class243.field3288 = 1;

            try {
               class243.field3290.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(InvType.field3331 != null) {
         InvType.field3331.method2900();
         InvType.field3331 = null;
      }

      IndexData.method4233();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1146681035"
   )
   protected final void vmethod1104() {
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = new Parameters[]{Parameters.field3768, Parameters.field3763, Parameters.field3759, Parameters.field3762, Parameters.field3766, Parameters.field3754, Parameters.field3761, Parameters.field3760, Parameters.field3756, Parameters.field3758, Parameters.field3753, Parameters.field3764, Parameters.field3757, Parameters.field3767, Parameters.field3765};
         Parameters[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            Parameters var4 = var2[var3];
            String var5 = this.getParameter(var4.key);
            if(var5 != null) {
               switch(Integer.parseInt(var4.key)) {
               case 2:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 3:
                  languageId = Integer.parseInt(var5);
                  break;
               case 4:
                  Buffer.field2495 = Projectile.method1741(Integer.parseInt(var5));
                  break;
               case 5:
                  class25.field339 = Integer.parseInt(var5);
                  break;
               case 6:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
               case 7:
               default:
                  break;
               case 8:
                  class239[] var6 = new class239[]{class239.field3254, class239.field3252, class239.field3257, class239.field3255, class239.field3253, class239.field3250};
                  FileSystem.field3262 = (class239)class153.forOrdinal(var6, Integer.parseInt(var5));
                  if(FileSystem.field3262 == class239.field3257) {
                     class189.field2529 = class298.field3918;
                  } else {
                     class189.field2529 = class298.field3908;
                  }
                  break;
               case 9:
                  class2.field13 = Integer.parseInt(var5);
                  break;
               case 10:
                  socketType = Integer.parseInt(var5);
                  break;
               case 11:
                  world = Integer.parseInt(var5);
                  break;
               case 12:
                  flags = Integer.parseInt(var5);
                  break;
               case 13:
                  PendingSpawn.field1139 = var5;
                  break;
               case 14:
                  SoundTask.sessionToken = var5;
               }
            }
         }

         Region.lowMemory = false;
         lowMemory = false;
         Varcs.host = this.getCodeBase().getHost();
         String var10 = Buffer.field2495.identifier;
         byte var7 = 0;

         try {
            Occluder.method2894("oldschool", var10, var7, 17);
         } catch (Exception var9) {
            class48.method690((String)null, var9);
         }

         class289.clientInstance = this;
         this.initialize(765, 503, 158);
      }
   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1602299502"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = Renderable.method2868();
         if(!var1) {
            this.method1454();
         }

      }
   }

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1833854514"
   )
   void method1454() {
      if(class245.field3323 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class245.field3324 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field1082 = 3000;
            class245.field3324 = 3;
         }

         if(--field1082 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  Timer.socket = GameEngine.taskManager.createSocket(Varcs.host, class70.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(Timer.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(Timer.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  class1.rssocket = new RSSocket((Socket)Timer.socket.value, GameEngine.taskManager, 5000);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(158);
                  class1.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  field863 = ChatLineBuffer.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && class1.rssocket.available() <= 0) {
                     if(ChatLineBuffer.currentTimeMs() - field863 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var2 = class1.rssocket.readByte();
                     if(var2 != 0) {
                        this.error(var2);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  class13.method74(class1.rssocket, gameState > 20);
                  Timer.socket = null;
                  class1.rssocket = null;
                  js5State = 0;
                  field893 = 0;
               }
            } catch (IOException var3) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1628998329"
   )
   @Export("error")
   void error(int var1) {
      Timer.socket = null;
      class1.rssocket = null;
      js5State = 0;
      if(Ignore.field790 == class70.myWorldPort) {
         class70.myWorldPort = class12.field257;
      } else {
         class70.myWorldPort = Ignore.field790;
      }

      ++field893;
      if(field893 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field1082 = 3000;
         }
      } else if(field893 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field893 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field1082 = 3000;
         }
      }

   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1899293142"
   )
   final void method1281() {
      RSSocket var1 = field905.method1873();
      PacketBuffer var2 = field905.field1461;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               var1.close();
               var1 = null;
            }

            class11.field252 = null;
            socketError = false;
            field895 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class11.field252 == null) {
               class11.field252 = GameEngine.taskManager.createSocket(Varcs.host, class70.myWorldPort);
            }

            if(class11.field252.status == 2) {
               throw new IOException();
            }

            if(class11.field252.status == 1) {
               field905.method1856(new RSSocket((Socket)class11.field252.value, GameEngine.taskManager, 5000));
               var1 = field905.method1873();
               class11.field252 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field905.method1868();
            PacketNode var4 = Varcs.method1804();
            var4.clientPacket = null;
            var4.field2416 = 0;
            var4.packetBuffer = new PacketBuffer(5000);
            var4.packetBuffer.putByte(class168.field2396.field2400);
            field905.method1855(var4);
            field905.method1866();
            var2.offset = 0;
            loginState = 3;
         }

         int var12;
         if(loginState == 3) {
            if(class3.soundSystem0 != null) {
               class3.soundSystem0.method2023();
            }

            if(class226.soundSystem1 != null) {
               class226.soundSystem1.method2023();
            }

            var12 = var1.readByte();
            if(class3.soundSystem0 != null) {
               class3.soundSystem0.method2023();
            }

            if(class226.soundSystem1 != null) {
               class226.soundSystem1.method2023();
            }

            if(var12 != 0) {
               WorldMapData.method322(var12);
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
               WorldMapData.field420 = var2.readLong();
               loginState = 5;
            }
         }

         int var7;
         int var8;
         int var14;
         if(loginState == 5) {
            field905.field1461.offset = 0;
            field905.method1868();
            PacketBuffer var3 = new PacketBuffer(500);
            int[] var23 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(WorldMapData.field420 >> 32), (int)(WorldMapData.field420 & -1L)};
            var3.offset = 0;
            var3.putByte(1);
            var3.putByte(field898.rsOrdinal());
            var3.putInt(var23[0]);
            var3.putInt(var23[1]);
            var3.putInt(var23[2]);
            var3.putInt(var23[3]);
            int var10;
            switch(field898.field2107) {
            case 0:
            case 1:
               var3.put24bitInt(class51.field609);
               var3.offset += 5;
               break;
            case 2:
               LinkedHashMap var6 = class70.preferences.preferences;
               String var16 = class91.username;
               var14 = var16.length();
               var10 = 0;

               for(int var11 = 0; var11 < var14; ++var11) {
                  var10 = (var10 << 5) - var10 + var16.charAt(var11);
               }

               var3.putInt(((Integer)var6.get(Integer.valueOf(var10))).intValue());
               var3.offset += 4;
               break;
            case 3:
               var3.offset += 8;
            }

            var3.putString(class91.password);
            var3.encryptRsa(class89.field1321, class89.field1319);
            PacketNode var27 = Varcs.method1804();
            var27.clientPacket = null;
            var27.field2416 = 0;
            var27.packetBuffer = new PacketBuffer(5000);
            var27.packetBuffer.offset = 0;
            if(gameState == 40) {
               var27.packetBuffer.putByte(class168.field2403.field2400);
            } else {
               var27.packetBuffer.putByte(class168.field2398.field2400);
            }

            var27.packetBuffer.putShort(0);
            var7 = var27.packetBuffer.offset;
            var27.packetBuffer.putInt(158);
            var27.packetBuffer.putBytes(var3.payload, 0, var3.offset);
            var8 = var27.packetBuffer.offset;
            var27.packetBuffer.putString(class91.username);
            var27.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var27.packetBuffer.putShort(class66.canvasWidth);
            var27.packetBuffer.putShort(Item.canvasHeight);
            class235.method4095(var27.packetBuffer);
            var27.packetBuffer.putString(SoundTask.sessionToken);
            var27.packetBuffer.putInt(class25.field339);
            Buffer var9 = new Buffer(Sequence.field3651.method5427());
            Sequence.field3651.method5433(var9);
            var27.packetBuffer.putBytes(var9.payload, 0, var9.payload.length);
            var27.packetBuffer.putByte(class2.field13);
            var27.packetBuffer.putInt(0);
            var27.packetBuffer.putInt(class139.indexInterfaces.crc);
            var27.packetBuffer.putInt(ChatLineBuffer.indexSoundEffects.crc);
            var27.packetBuffer.putInt(class229.configsIndex.crc);
            var27.packetBuffer.putInt(Friend.field759.crc);
            var27.packetBuffer.putInt(class23.field326.crc);
            var27.packetBuffer.putInt(RSCanvas.indexMaps.crc);
            var27.packetBuffer.putInt(class45.indexTrack1.crc);
            var27.packetBuffer.putInt(class22.indexModels.crc);
            var27.packetBuffer.putInt(Signlink.indexSprites.crc);
            var27.packetBuffer.putInt(FloorUnderlayDefinition.indexTextures.crc);
            var27.packetBuffer.putInt(Player.field840.crc);
            var27.packetBuffer.putInt(class61.indexTrack2.crc);
            var27.packetBuffer.putInt(class29.indexScripts.crc);
            var27.packetBuffer.putInt(DecorativeObject.field2071.crc);
            var27.packetBuffer.putInt(PendingSpawn.vorbisIndex.crc);
            var27.packetBuffer.putInt(class60.field697.crc);
            var27.packetBuffer.putInt(class23.indexWorldMap.crc);
            var27.packetBuffer.encryptXtea(var23, var8, var27.packetBuffer.offset);
            var27.packetBuffer.method3182(var27.packetBuffer.offset - var7);
            field905.method1855(var27);
            field905.method1866();
            field905.field1460 = new ISAACCipher(var23);

            for(var10 = 0; var10 < 4; ++var10) {
               var23[var10] += 50;
            }

            var2.seed(var23);
            loginState = 6;
         }

         if(loginState == 6 && var1.available() > 0) {
            var12 = var1.readByte();
            if(var12 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var12 == 2) {
               loginState = 9;
            } else if(var12 == 15 && gameState == 40) {
               field905.packetLength = -1;
               loginState = 13;
            } else if(var12 == 23 && field896 < 1) {
               ++field896;
               loginState = 0;
            } else {
               if(var12 != 29) {
                  WorldMapData.method322(var12);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && var1.available() > 0) {
            field897 = (var1.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field895 = 0;
            BaseVarType.method14("You have only just left another world.", "Your profile will be transferred in:", field897 / 60 + " seconds.");
            if(--field897 <= 0) {
               loginState = 0;
            }

         } else {
            int var29;
            if(loginState == 9 && var1.available() >= 13) {
               boolean var30 = var1.readByte() == 1;
               var1.read(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var13 = false;
               if(var30) {
                  var29 = var2.readOpcode() << 24;
                  var29 |= var2.readOpcode() << 16;
                  var29 |= var2.readOpcode() << 8;
                  var29 |= var2.readOpcode();
                  String var28 = class91.username;
                  var7 = var28.length();
                  var8 = 0;
                  var14 = 0;

                  while(true) {
                     if(var14 >= var7) {
                        if(class70.preferences.preferences.size() >= 10 && !class70.preferences.preferences.containsKey(Integer.valueOf(var8))) {
                           Iterator var31 = class70.preferences.preferences.entrySet().iterator();
                           var31.next();
                           var31.remove();
                        }

                        class70.preferences.preferences.put(Integer.valueOf(var8), Integer.valueOf(var29));
                        break;
                     }

                     var8 = (var8 << 5) - var8 + var28.charAt(var14);
                     ++var14;
                  }
               }

               if(class91.field1352) {
                  class70.preferences.field1232 = class91.username;
               } else {
                  class70.preferences.field1232 = null;
               }

               GameEngine.method925();
               rights = var1.readByte();
               field979 = var1.readByte() == 1;
               localInteractingIndex = var1.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += var1.readByte();
               field969 = var1.readByte();
               var1.read(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = class227.method4080();
               int var15 = var2.method3455();
               if(var15 < 0 || var15 >= var5.length) {
                  throw new IOException(var15 + " " + var2.offset);
               }

               field905.serverPacket = var5[var15];
               field905.packetLength = field905.serverPacket.packetLength;
               var1.read(var2.payload, 0, 2);
               var2.offset = 0;
               field905.packetLength = var2.readUnsignedShort();

               try {
                  class52.method726(class289.clientInstance, "zap");
               } catch (Throwable var19) {
                  ;
               }

               loginState = 10;
            }

            if(loginState != 10) {
               if(loginState == 11 && var1.available() >= 2) {
                  var2.offset = 0;
                  var1.read(var2.payload, 0, 2);
                  var2.offset = 0;
                  class70.field793 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && var1.available() >= class70.field793) {
                  var2.offset = 0;
                  var1.read(var2.payload, 0, class70.field793);
                  var2.offset = 0;
                  String var22 = var2.readString();
                  String var25 = var2.readString();
                  String var26 = var2.readString();
                  BaseVarType.method14(var22, var25, var26);
                  class2.setGameState(10);
               }

               if(loginState == 13) {
                  if(field905.packetLength == -1) {
                     if(var1.available() < 2) {
                        return;
                     }

                     var1.read(var2.payload, 0, 2);
                     var2.offset = 0;
                     field905.packetLength = var2.readUnsignedShort();
                  }

                  if(var1.available() >= field905.packetLength) {
                     var1.read(var2.payload, 0, field905.packetLength);
                     var2.offset = 0;
                     var12 = field905.packetLength;
                     field976.method4923();
                     class133.method2596();
                     class23.initializeGPI(var2);
                     if(var12 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field895;
                  if(field895 > 2000) {
                     if(field896 < 1) {
                        if(class70.myWorldPort == Ignore.field790) {
                           class70.myWorldPort = class12.field257;
                        } else {
                           class70.myWorldPort = Ignore.field790;
                        }

                        ++field896;
                        loginState = 0;
                     } else {
                        WorldMapData.method322(-3);
                     }
                  }
               }
            } else {
               if(var1.available() >= field905.packetLength) {
                  var2.offset = 0;
                  var1.read(var2.payload, 0, field905.packetLength);
                  field976.method4926();
                  field1090 = -1L;
                  field875 = -1;
                  class41.field519.field795 = 0;
                  KeyFocusListener.field608 = true;
                  field876 = true;
                  field1071 = -1L;
                  class236.method4096();
                  field905.method1868();
                  field905.field1461.offset = 0;
                  field905.serverPacket = null;
                  field905.field1467 = null;
                  field905.field1468 = null;
                  field905.field1459 = null;
                  field905.packetLength = 0;
                  field905.field1457 = 0;
                  field910 = 0;
                  field906 = 0;
                  hintArrowTargetType = 0;
                  menuOptionCount = 0;
                  isMenuOpen = false;
                  MouseInput.mouseIdleTicks = 0;
                  class8.method43();
                  itemSelectionState = 0;
                  spellSelected = false;
                  field1031 = 0;
                  mapAngle = 0;
                  field1108 = 0;
                  field1081 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  field1096 = class90.field1328;
                  field950 = class90.field1328;
                  npcIndexesCount = 0;
                  class94.playerIndexesCount = 0;

                  for(var12 = 0; var12 < 2048; ++var12) {
                     class94.field1408[var12] = null;
                     class94.field1398[var12] = 1;
                  }

                  for(var12 = 0; var12 < 2048; ++var12) {
                     cachedPlayers[var12] = null;
                  }

                  for(var12 = 0; var12 < 32768; ++var12) {
                     cachedNPCs[var12] = null;
                  }

                  field1070 = -1;
                  projectiles.clear();
                  graphicsObjectDeque.clear();

                  for(var12 = 0; var12 < 4; ++var12) {
                     for(var29 = 0; var29 < 104; ++var29) {
                        for(int var17 = 0; var17 < 104; ++var17) {
                           groundItemDeque[var12][var29][var17] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  field1114 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var12 = 0; var12 < VarPlayerType.field3338; ++var12) {
                     VarPlayerType var24 = class275.method4883(var12);
                     if(var24 != null) {
                        class218.settings[var12] = 0;
                        class218.widgetSettings[var12] = 0;
                     }
                  }

                  Renderable.chatMessages.reset();
                  field1015 = -1;
                  if(widgetRoot != -1) {
                     Enum.method4462(widgetRoot);
                  }

                  for(WidgetNode var21 = (WidgetNode)componentTable.method3592(); var21 != null; var21 = (WidgetNode)componentTable.method3593()) {
                     class74.method1100(var21, true);
                  }

                  widgetRoot = -1;
                  componentTable = new HashTable(8);
                  field878 = null;
                  menuOptionCount = 0;
                  isMenuOpen = false;
                  field1119.method3982((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var12 = 0; var12 < 8; ++var12) {
                     playerOptions[var12] = null;
                     playerOptionsPriorities[var12] = false;
                  }

                  class17.method121();
                  field1005 = true;

                  for(var12 = 0; var12 < 100; ++var12) {
                     field1052[var12] = true;
                  }

                  World.method1560();
                  clanChatOwner = null;
                  class34.clanChatCount = 0;
                  Varcs.clanMembers = null;

                  for(var12 = 0; var12 < 8; ++var12) {
                     grandExchangeOffers[var12] = new GrandExchangeOffer();
                  }

                  ClanMember.field855 = null;
                  class23.initializeGPI(var2);
                  class36.field469 = -1;
                  VertexNormal.xteaChanged(false, var2);
                  field905.serverPacket = null;
               }

            }
         }
      } catch (IOException var20) {
         if(field896 < 1) {
            if(Ignore.field790 == class70.myWorldPort) {
               class70.myWorldPort = class12.field257;
            } else {
               class70.myWorldPort = Ignore.field790;
            }

            ++field896;
            loginState = 0;
         } else {
            WorldMapData.method322(-2);
         }
      }
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   final void method1115() {
      if(field910 > 1) {
         --field910;
      }

      if(field906 > 0) {
         --field906;
      }

      if(socketError) {
         socketError = false;
         ScriptEvent.method1036();
      } else {
         if(!isMenuOpen) {
            WidgetNode.method1027();
         }

         for(int var1 = 0; var1 < 100 && this.method1119(field905); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class289.field3803.method3611();
               boolean var31;
               if(var2 == null) {
                  var31 = false;
               } else {
                  var31 = true;
               }

               int var3;
               PacketNode var32;
               if(!var31) {
                  PacketNode var15;
                  int var16;
                  if(field976.field3769) {
                     var15 = class18.method133(ClientPacket.field2361, field905.field1460);
                     var15.packetBuffer.putByte(0);
                     var16 = var15.packetBuffer.offset;
                     field976.method4924(var15.packetBuffer);
                     var15.packetBuffer.method3197(var15.packetBuffer.offset - var16);
                     field905.method1855(var15);
                     field976.method4932();
                  }

                  Object var37 = class41.field519.field797;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  synchronized(class41.field519.field797) {
                     if(!field1079) {
                        class41.field519.field795 = 0;
                     } else if(MouseInput.field687 != 0 || class41.field519.field795 >= 40) {
                        var32 = class18.method133(ClientPacket.field2302, field905.field1460);
                        var32.packetBuffer.putByte(0);
                        var3 = var32.packetBuffer.offset;
                        var4 = 0;

                        for(var5 = 0; var5 < class41.field519.field795 && var32.packetBuffer.offset - var3 < 240; ++var5) {
                           ++var4;
                           var6 = class41.field519.field794[var5];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 502) {
                              var6 = 502;
                           }

                           var7 = class41.field519.field799[var5];
                           if(var7 < 0) {
                              var7 = 0;
                           } else if(var7 > 764) {
                              var7 = 764;
                           }

                           var8 = var6 * 765 + var7;
                           if(class41.field519.field794[var5] == -1 && class41.field519.field799[var5] == -1) {
                              var7 = -1;
                              var6 = -1;
                              var8 = 524287;
                           }

                           if(var7 == field989 && var6 == field916) {
                              if(field875 < 2047) {
                                 ++field875;
                              }
                           } else {
                              var9 = var7 - field989;
                              field989 = var7;
                              var10 = var6 - field916;
                              field916 = var6;
                              if(field875 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                                 var9 += 32;
                                 var10 += 32;
                                 var32.packetBuffer.putShort(var10 + (field875 << 12) + (var9 << 6));
                                 field875 = 0;
                              } else if(field875 < 8) {
                                 var32.packetBuffer.put24bitInt((field875 << 19) + var8 + 8388608);
                                 field875 = 0;
                              } else {
                                 var32.packetBuffer.putInt((field875 << 19) + var8 + -1073741824);
                                 field875 = 0;
                              }
                           }
                        }

                        var32.packetBuffer.method3197(var32.packetBuffer.offset - var3);
                        field905.method1855(var32);
                        if(var4 >= class41.field519.field795) {
                           class41.field519.field795 = 0;
                        } else {
                           class41.field519.field795 -= var4;

                           for(var5 = 0; var5 < class41.field519.field795; ++var5) {
                              class41.field519.field799[var5] = class41.field519.field799[var5 + var4];
                              class41.field519.field794[var5] = class41.field519.field794[var5 + var4];
                           }
                        }
                     }
                  }

                  PacketNode var19;
                  if(MouseInput.field687 == 1 || !Signlink.field2142 && MouseInput.field687 == 4 || MouseInput.field687 == 2) {
                     long var17 = (MouseInput.field690 - field1090) / 50L;
                     if(var17 > 4095L) {
                        var17 = 4095L;
                     }

                     field1090 = MouseInput.field690;
                     var3 = MouseInput.field688;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > Item.canvasHeight) {
                        var3 = Item.canvasHeight;
                     }

                     var4 = MouseInput.field674;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > class66.canvasWidth) {
                        var4 = class66.canvasWidth;
                     }

                     var5 = (int)var17;
                     var19 = class18.method133(ClientPacket.field2385, field905.field1460);
                     var19.packetBuffer.putShort((MouseInput.field687 == 2?1:0) + (var5 << 1));
                     var19.packetBuffer.putShort(var4);
                     var19.packetBuffer.putShort(var3);
                     field905.method1855(var19);
                  }

                  if(KeyFocusListener.field601 > 0) {
                     var15 = class18.method133(ClientPacket.field2345, field905.field1460);
                     var15.packetBuffer.putShort(0);
                     var16 = var15.packetBuffer.offset;
                     long var20 = ChatLineBuffer.currentTimeMs();

                     for(var5 = 0; var5 < KeyFocusListener.field601; ++var5) {
                        long var22 = var20 - field1071;
                        if(var22 > 16777215L) {
                           var22 = 16777215L;
                        }

                        field1071 = var20;
                        var15.packetBuffer.method3226((int)var22);
                        var15.packetBuffer.method3210(KeyFocusListener.field594[var5]);
                     }

                     var15.packetBuffer.method3182(var15.packetBuffer.offset - var16);
                     field905.method1855(var15);
                  }

                  if(field937 > 0) {
                     --field937;
                  }

                  if(KeyFocusListener.field578[96] || KeyFocusListener.field578[97] || KeyFocusListener.field578[98] || KeyFocusListener.field578[99]) {
                     field938 = true;
                  }

                  if(field938 && field937 <= 0) {
                     field937 = 20;
                     field938 = false;
                     var15 = class18.method133(ClientPacket.field2363, field905.field1460);
                     var15.packetBuffer.putShort(mapAngle);
                     var15.packetBuffer.method3221(field930);
                     field905.method1855(var15);
                  }

                  if(KeyFocusListener.field608 && !field876) {
                     field876 = true;
                     var15 = class18.method133(ClientPacket.field2303, field905.field1460);
                     var15.packetBuffer.putByte(1);
                     field905.method1855(var15);
                  }

                  if(!KeyFocusListener.field608 && field876) {
                     field876 = false;
                     var15 = class18.method133(ClientPacket.field2303, field905.field1460);
                     var15.packetBuffer.putByte(0);
                     field905.method1855(var15);
                  }

                  Projectile.method1737();
                  if(gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var39 = (PendingSpawn)pendingSpawns.getFront(); var39 != null; var39 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var39.hitpoints > 0) {
                        --var39.hitpoints;
                     }

                     ObjectComposition var24;
                     boolean var38;
                     if(var39.hitpoints == 0) {
                        if(var39.field1133 >= 0) {
                           var3 = var39.field1133;
                           var4 = var39.field1138;
                           var24 = ClientPacket.getObjectDefinition(var3);
                           if(var4 == 11) {
                              var4 = 10;
                           }

                           if(var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           var38 = var24.method4515(var4);
                           if(!var38) {
                              continue;
                           }
                        }

                        class33.method324(var39.level, var39.type, var39.x, var39.y, var39.field1133, var39.field1132, var39.field1138);
                        var39.unlink();
                     } else {
                        if(var39.delay > 0) {
                           --var39.delay;
                        }

                        if(var39.delay == 0 && var39.x >= 1 && var39.y >= 1 && var39.x <= 102 && var39.y <= 102) {
                           if(var39.id >= 0) {
                              var3 = var39.id;
                              var4 = var39.field1136;
                              var24 = ClientPacket.getObjectDefinition(var3);
                              if(var4 == 11) {
                                 var4 = 10;
                              }

                              if(var4 >= 5 && var4 <= 8) {
                                 var4 = 4;
                              }

                              var38 = var24.method4515(var4);
                              if(!var38) {
                                 continue;
                              }
                           }

                           class33.method324(var39.level, var39.type, var39.x, var39.y, var39.id, var39.orientation, var39.field1136);
                           var39.delay = -1;
                           if(var39.id == var39.field1133 && var39.field1133 == -1) {
                              var39.unlink();
                           } else if(var39.field1133 == var39.id && var39.orientation == var39.field1132 && var39.field1138 == var39.field1136) {
                              var39.unlink();
                           }
                        }
                     }
                  }

                  BaseVarType.method12();
                  ++field905.field1457;
                  if(field905.field1457 > 750) {
                     ScriptEvent.method1036();
                     return;
                  }

                  ScriptVarType.method22();
                  class13.method80();
                  BufferProvider.method5078();
                  ++field922;
                  if(cursorState != 0) {
                     field968 += 20;
                     if(field968 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class175.field2442 != null) {
                     ++field958;
                     if(field958 >= 15) {
                        ScriptEvent.method1038(class175.field2442);
                        class175.field2442 = null;
                     }
                  }

                  Widget var40 = class13.field264;
                  Widget var33 = class29.field394;
                  class13.field264 = null;
                  class29.field394 = null;
                  field1024 = null;
                  field1028 = false;
                  field1025 = false;
                  field1068 = 0;

                  while(class251.method4307() && field1068 < 128) {
                     if(rights >= 2 && KeyFocusListener.field578[82] && class96.field1426 == 66) {
                        String var25 = "";

                        MessageNode var41;
                        for(Iterator var43 = class96.field1425.iterator(); var43.hasNext(); var25 = var25 + var41.name + ':' + var41.value + '\n') {
                           var41 = (MessageNode)var43.next();
                        }

                        class289.clientInstance.method812(var25);
                     } else {
                        field970[field1068] = class96.field1426;
                        field1069[field1068] = class233.field3200;
                        ++field1068;
                     }
                  }

                  boolean var34 = rights >= 2;
                  if(var34 && KeyFocusListener.field578[82] && KeyFocusListener.field578[81] && field985 != 0) {
                     var4 = class275.localPlayer.field835 - field985;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != class275.localPlayer.field835) {
                        class12.method72(class275.localPlayer.pathX[0] + class13.baseX, class275.localPlayer.pathY[0] + ClanMember.baseY, var4);
                     }

                     field985 = 0;
                  }

                  if(widgetRoot != -1) {
                     class264.method4631(widgetRoot, 0, 0, class66.canvasWidth, Item.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var42;
                     Widget var44;
                     ScriptEvent var45;
                     do {
                        var45 = (ScriptEvent)field1047.popFront();
                        if(var45 == null) {
                           while(true) {
                              do {
                                 var45 = (ScriptEvent)field1048.popFront();
                                 if(var45 == null) {
                                    while(true) {
                                       do {
                                          var45 = (ScriptEvent)field862.popFront();
                                          if(var45 == null) {
                                             this.method1120();
                                             if(ScriptState.renderOverview != null) {
                                                ScriptState.renderOverview.method5246(class28.plane, (class275.localPlayer.x >> 7) + class13.baseX, (class275.localPlayer.y >> 7) + ClanMember.baseY, false);
                                                ScriptState.renderOverview.method5260();
                                             }

                                             if(field1020 != null) {
                                                this.method1165();
                                             }

                                             PacketNode var27;
                                             if(class72.field812 != null) {
                                                ScriptEvent.method1038(class72.field812);
                                                ++field965;
                                                if(MouseInput.field689 == 0) {
                                                   if(field964) {
                                                      if(class72.field812 == Widget.field2709 && field1111 != field890) {
                                                         Widget var46 = class72.field812;
                                                         byte var35 = 0;
                                                         if(field1010 == 1 && var46.contentType == 206) {
                                                            var35 = 1;
                                                         }

                                                         if(var46.itemIds[field1111] <= 0) {
                                                            var35 = 0;
                                                         }

                                                         var7 = class12.getWidgetConfig(var46);
                                                         boolean var36 = (var7 >> 29 & 1) != 0;
                                                         if(var36) {
                                                            var8 = field890;
                                                            var9 = field1111;
                                                            var46.itemIds[var9] = var46.itemIds[var8];
                                                            var46.itemQuantities[var9] = var46.itemQuantities[var8];
                                                            var46.itemIds[var8] = -1;
                                                            var46.itemQuantities[var8] = 0;
                                                         } else if(var35 == 1) {
                                                            var8 = field890;
                                                            var9 = field1111;

                                                            while(var9 != var8) {
                                                               if(var8 > var9) {
                                                                  var46.method4022(var8 - 1, var8);
                                                                  --var8;
                                                               } else if(var8 < var9) {
                                                                  var46.method4022(var8 + 1, var8);
                                                                  ++var8;
                                                               }
                                                            }
                                                         } else {
                                                            var46.method4022(field1111, field890);
                                                         }

                                                         var27 = class18.method133(ClientPacket.field2340, field905.field1460);
                                                         var27.packetBuffer.putShort(field890);
                                                         var27.packetBuffer.method3219(field1111);
                                                         var27.packetBuffer.method3212(var35);
                                                         var27.packetBuffer.putInt(class72.field812.id);
                                                         field905.method1855(var27);
                                                      }
                                                   } else if(this.method1121()) {
                                                      this.method1122(field923, field962);
                                                   } else if(menuOptionCount > 0) {
                                                      WorldMapType2.method506(field923, field962);
                                                   }

                                                   field958 = 10;
                                                   MouseInput.field687 = 0;
                                                   class72.field812 = null;
                                                } else if(field965 >= 5 && (MouseInput.field681 > field923 + 5 || MouseInput.field681 < field923 - 5 || MouseInput.field676 > field962 + 5 || MouseInput.field676 < field962 - 5)) {
                                                   field964 = true;
                                                }
                                             }

                                             if(Region.method2727()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                var19 = class18.method133(ClientPacket.field2348, field905.field1460);
                                                var19.packetBuffer.putByte(5);
                                                var19.packetBuffer.method3219(var4 + class13.baseX);
                                                var19.packetBuffer.method3210(KeyFocusListener.field578[82]?(KeyFocusListener.field578[81]?2:1):0);
                                                var19.packetBuffer.putShortLE(var5 + ClanMember.baseY);
                                                field905.method1855(var19);
                                                Region.method2728();
                                                field954 = MouseInput.field674;
                                                field955 = MouseInput.field688;
                                                cursorState = 1;
                                                field968 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var40 != class13.field264) {
                                                if(var40 != null) {
                                                   ScriptEvent.method1038(var40);
                                                }

                                                if(class13.field264 != null) {
                                                   ScriptEvent.method1038(class13.field264);
                                                }
                                             }

                                             if(var33 != class29.field394 && field998 == field975) {
                                                if(var33 != null) {
                                                   ScriptEvent.method1038(var33);
                                                }

                                                if(class29.field394 != null) {
                                                   ScriptEvent.method1038(class29.field394);
                                                }
                                             }

                                             if(class29.field394 != null) {
                                                if(field998 < field975) {
                                                   ++field998;
                                                   if(field975 == field998) {
                                                      ScriptEvent.method1038(class29.field394);
                                                   }
                                                }
                                             } else if(field998 > 0) {
                                                --field998;
                                             }

                                             var4 = class275.localPlayer.x;
                                             var5 = class275.localPlayer.y;
                                             if(WorldMapType3.field360 - var4 < -500 || WorldMapType3.field360 - var4 > 500 || class74.field846 - var5 < -500 || class74.field846 - var5 > 500) {
                                                WorldMapType3.field360 = var4;
                                                class74.field846 = var5;
                                             }

                                             if(var4 != WorldMapType3.field360) {
                                                WorldMapType3.field360 += (var4 - WorldMapType3.field360) / 16;
                                             }

                                             if(var5 != class74.field846) {
                                                class74.field846 += (var5 - class74.field846) / 16;
                                             }

                                             if(MouseInput.field689 == 4 && Signlink.field2142) {
                                                var6 = MouseInput.field676 - field935;
                                                field933 = var6 * 2;
                                                field935 = var6 != -1 && var6 != 1?(field935 + MouseInput.field676) / 2:MouseInput.field676;
                                                var7 = field934 - MouseInput.field681;
                                                field903 = var7 * 2;
                                                field934 = var7 != -1 && var7 != 1?(MouseInput.field681 + field934) / 2:MouseInput.field681;
                                             } else {
                                                if(KeyFocusListener.field578[96]) {
                                                   field903 += (-24 - field903) / 2;
                                                } else if(KeyFocusListener.field578[97]) {
                                                   field903 += (24 - field903) / 2;
                                                } else {
                                                   field903 /= 2;
                                                }

                                                if(KeyFocusListener.field578[98]) {
                                                   field933 += (12 - field933) / 2;
                                                } else if(KeyFocusListener.field578[99]) {
                                                   field933 += (-12 - field933) / 2;
                                                } else {
                                                   field933 /= 2;
                                                }

                                                field935 = MouseInput.field676;
                                                field934 = MouseInput.field681;
                                             }

                                             mapAngle = field903 / 2 + mapAngle & 2047;
                                             field930 += field933 / 2;
                                             if(field930 < 128) {
                                                field930 = 128;
                                             }

                                             if(field930 > 383) {
                                                field930 = 383;
                                             }

                                             var6 = WorldMapType3.field360 >> 7;
                                             var7 = class74.field846 >> 7;
                                             var8 = class18.getTileHeight(WorldMapType3.field360, class74.field846, class28.plane);
                                             var9 = 0;
                                             int var11;
                                             int var12;
                                             int var13;
                                             if(var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
                                                for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                   for(var11 = var7 - 4; var11 <= var7 + 4; ++var11) {
                                                      var12 = class28.plane;
                                                      if(var12 < 3 && (class61.tileSettings[1][var10][var11] & 2) == 2) {
                                                         ++var12;
                                                      }

                                                      var13 = var8 - class61.tileHeights[var12][var10][var11];
                                                      if(var13 > var9) {
                                                         var9 = var13;
                                                      }
                                                   }
                                                }
                                             }

                                             var10 = var9 * 192;
                                             if(var10 > 98048) {
                                                var10 = 98048;
                                             }

                                             if(var10 < 32768) {
                                                var10 = 32768;
                                             }

                                             if(var10 > field1055) {
                                                field1055 += (var10 - field1055) / 24;
                                             } else if(var10 < field1055) {
                                                field1055 += (var10 - field1055) / 80;
                                             }

                                             if(field1094) {
                                                var4 = MilliTimer.field2117 * 128 + 64;
                                                var5 = BufferProvider.field3814 * 128 + 64;
                                                var6 = class18.getTileHeight(var4, var5, class28.plane) - class27.field370;
                                                if(class45.cameraX < var4) {
                                                   class45.cameraX = (var4 - class45.cameraX) * class2.field11 / 1000 + class45.cameraX + World.field1220;
                                                   if(class45.cameraX > var4) {
                                                      class45.cameraX = var4;
                                                   }
                                                }

                                                if(class45.cameraX > var4) {
                                                   class45.cameraX -= class2.field11 * (class45.cameraX - var4) / 1000 + World.field1220;
                                                   if(class45.cameraX < var4) {
                                                      class45.cameraX = var4;
                                                   }
                                                }

                                                if(class279.cameraZ < var6) {
                                                   class279.cameraZ = (var6 - class279.cameraZ) * class2.field11 / 1000 + class279.cameraZ + World.field1220;
                                                   if(class279.cameraZ > var6) {
                                                      class279.cameraZ = var6;
                                                   }
                                                }

                                                if(class279.cameraZ > var6) {
                                                   class279.cameraZ -= class2.field11 * (class279.cameraZ - var6) / 1000 + World.field1220;
                                                   if(class279.cameraZ < var6) {
                                                      class279.cameraZ = var6;
                                                   }
                                                }

                                                if(cameraY < var5) {
                                                   cameraY = (var5 - cameraY) * class2.field11 / 1000 + cameraY + World.field1220;
                                                   if(cameraY > var5) {
                                                      cameraY = var5;
                                                   }
                                                }

                                                if(cameraY > var5) {
                                                   cameraY -= class2.field11 * (cameraY - var5) / 1000 + World.field1220;
                                                   if(cameraY < var5) {
                                                      cameraY = var5;
                                                   }
                                                }

                                                var4 = class81.field1236 * 128 + 64;
                                                var5 = Enum.field3448 * 128 + 64;
                                                var6 = class18.getTileHeight(var4, var5, class28.plane) - Widget.field2848;
                                                var7 = var4 - class45.cameraX;
                                                var8 = var6 - class279.cameraZ;
                                                var9 = var5 - cameraY;
                                                var10 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
                                                var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                                                var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                                                if(var11 < 128) {
                                                   var11 = 128;
                                                }

                                                if(var11 > 383) {
                                                   var11 = 383;
                                                }

                                                if(class45.cameraPitch < var11) {
                                                   class45.cameraPitch = (var11 - class45.cameraPitch) * AbstractByteBuffer.field2511 / 1000 + class45.cameraPitch + CombatInfo1.field1209;
                                                   if(class45.cameraPitch > var11) {
                                                      class45.cameraPitch = var11;
                                                   }
                                                }

                                                if(class45.cameraPitch > var11) {
                                                   class45.cameraPitch -= AbstractByteBuffer.field2511 * (class45.cameraPitch - var11) / 1000 + CombatInfo1.field1209;
                                                   if(class45.cameraPitch < var11) {
                                                      class45.cameraPitch = var11;
                                                   }
                                                }

                                                var13 = var12 - class230.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 > 0) {
                                                   class230.cameraYaw = var13 * AbstractByteBuffer.field2511 / 1000 + class230.cameraYaw + CombatInfo1.field1209;
                                                   class230.cameraYaw &= 2047;
                                                }

                                                if(var13 < 0) {
                                                   class230.cameraYaw -= CombatInfo1.field1209 + -var13 * AbstractByteBuffer.field2511 / 1000;
                                                   class230.cameraYaw &= 2047;
                                                }

                                                int var14 = var12 - class230.cameraYaw;
                                                if(var14 > 1024) {
                                                   var14 -= 2048;
                                                }

                                                if(var14 < -1024) {
                                                   var14 += 2048;
                                                }

                                                if(var14 < 0 && var13 > 0 || var14 > 0 && var13 < 0) {
                                                   class230.cameraYaw = var12;
                                                }
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field990[var4];
                                             }

                                             Renderable.chatMessages.process();
                                             var4 = ++MouseInput.mouseIdleTicks - 1;
                                             var6 = KeyFocusListener.keyboardIdleTicks;
                                             if(var4 > 15000 && var6 > 15000) {
                                                field906 = 250;
                                                MouseInput.mouseIdleTicks = 14500;
                                                var27 = class18.method133(ClientPacket.field2343, field905.field1460);
                                                field905.method1855(var27);
                                             }

                                             for(class66 var47 = (class66)field1116.method3684(); var47 != null; var47 = (class66)field1116.method3681()) {
                                                if((long)var47.field761 < ChatLineBuffer.currentTimeMs() / 1000L - 5L) {
                                                   if(var47.field762 > 0) {
                                                      class3.sendGameMessage(5, "", var47.field769 + " has logged in.");
                                                   }

                                                   if(var47.field762 == 0) {
                                                      class3.sendGameMessage(5, "", var47.field769 + " has logged out.");
                                                   }

                                                   var47.method3689();
                                                }
                                             }

                                             ++field905.field1456;
                                             if(field905.field1456 > 50) {
                                                var27 = class18.method133(ClientPacket.field2354, field905.field1460);
                                                field905.method1855(var27);
                                             }

                                             try {
                                                field905.method1866();
                                             } catch (IOException var29) {
                                                ScriptEvent.method1036();
                                             }

                                             return;
                                          }

                                          var44 = var45.widget;
                                          if(var44.index < 0) {
                                             break;
                                          }

                                          var42 = class64.method1017(var44.parentId);
                                       } while(var42 == null || var42.children == null || var44.index >= var42.children.length || var44 != var42.children[var44.index]);

                                       BaseVarType.method11(var45);
                                    }
                                 }

                                 var44 = var45.widget;
                                 if(var44.index < 0) {
                                    break;
                                 }

                                 var42 = class64.method1017(var44.parentId);
                              } while(var42 == null || var42.children == null || var44.index >= var42.children.length || var44 != var42.children[var44.index]);

                              BaseVarType.method11(var45);
                           }
                        }

                        var44 = var45.widget;
                        if(var44.index < 0) {
                           break;
                        }

                        var42 = class64.method1017(var44.parentId);
                     } while(var42 == null || var42.children == null || var44.index >= var42.children.length || var44 != var42.children[var44.index]);

                     BaseVarType.method11(var45);
                  }
               }

               var32 = class18.method133(ClientPacket.field2373, field905.field1460);
               var32.packetBuffer.putByte(0);
               var3 = var32.packetBuffer.offset;
               class285.encodeClassVerifier(var32.packetBuffer);
               var32.packetBuffer.method3197(var32.packetBuffer.offset - var3);
               field905.method1855(var32);
            }
         }
      }
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1933499077"
   )
   void method1117() {
      int var1 = class66.canvasWidth;
      int var2 = Item.canvasHeight;
      if(super.field652 < var1) {
         var1 = super.field652;
      }

      if(super.field662 < var2) {
         var2 = super.field662;
      }

      if(class70.preferences != null) {
         try {
            class52.method730(class289.clientInstance, "resize", new Object[]{Integer.valueOf(PendingSpawn.method1494())});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-125"
   )
   final void method1118() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(class64.loadWidget(var1)) {
            ScriptVarType.method23(Widget.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1050; ++var1) {
         if(field1052[var1]) {
            field1053[var1] = true;
         }

         field872[var1] = field1052[var1];
         field1052[var1] = false;
      }

      field866 = gameCycle;
      field996 = -1;
      field1124 = -1;
      Widget.field2709 = null;
      if(widgetRoot != -1) {
         field1050 = 0;
         class43.method587(widgetRoot, 0, 0, class66.canvasWidth, Item.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field996 != -1) {
            var1 = field996;
            var2 = field1124;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               var3 = menuOptionCount - 1;
               String var5;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var5 = "Use" + " " + field1001 + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var5 = field1045 + " " + field948 + " " + "->";
               } else {
                  String var14;
                  if(var3 < 0) {
                     var14 = "";
                  } else if(menuTargets[var3].length() > 0) {
                     var14 = menuOptions[var3] + " " + menuTargets[var3];
                  } else {
                     var14 = menuOptions[var3];
                  }

                  var5 = var14;
               }

               if(menuOptionCount > 2) {
                  var5 = var5 + class222.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               field909.drawRandomizedMouseoverText(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         var1 = class48.menuX;
         var2 = class168.menuY;
         var3 = GraphicsObject.menuWidth;
         int var4 = class24.menuHeight;
         int var13 = 6116423;
         Rasterizer2D.method4981(var1, var2, var3, var4, var13);
         Rasterizer2D.method4981(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         field909.method4770("Choose Option", var1 + 3, var2 + 14, var13, -1);
         int var6 = MouseInput.field681;
         int var7 = MouseInput.field676;

         for(int var8 = 0; var8 < menuOptionCount; ++var8) {
            int var9 = var2 + (menuOptionCount - 1 - var8) * 15 + 31;
            int var10 = 16777215;
            if(var6 > var1 && var6 < var1 + var3 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            Font var11 = field909;
            String var12;
            if(var8 < 0) {
               var12 = "";
            } else if(menuTargets[var8].length() > 0) {
               var12 = menuOptions[var8] + " " + menuTargets[var8];
            } else {
               var12 = menuOptions[var8];
            }

            var11.method4770(var12, var1 + 3, var9, var10, 0);
         }

         class182.method3418(class48.menuX, class168.menuY, GraphicsObject.menuWidth, class24.menuHeight);
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1050; ++var1) {
            if(field872[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1053[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      class29.method218(class28.plane, class275.localPlayer.x, class275.localPlayer.y, field922);
      field922 = 0;
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(Lci;I)Z",
      garbageValue = "1790684632"
   )
   final boolean method1119(class100 var1) {
      RSSocket var2 = var1.method1873();
      PacketBuffer var3 = var1.field1461;
      if(var2 == null) {
         return false;
      } else {
         int var6;
         String var23;
         try {
            int var5;
            if(var1.serverPacket == null) {
               if(var1.field1464) {
                  if(!var2.method3003(1)) {
                     return false;
                  }

                  var2.read(var1.field1461.payload, 0, 1);
                  var1.field1457 = 0;
                  var1.field1464 = false;
               }

               var3.offset = 0;
               if(var3.method3479()) {
                  if(!var2.method3003(1)) {
                     return false;
                  }

                  var2.read(var1.field1461.payload, 1, 1);
                  var1.field1457 = 0;
               }

               var1.field1464 = true;
               ServerPacket[] var4 = class227.method4080();
               var5 = var3.method3455();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.serverPacket = var4[var5];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.method3003(1)) {
                  return false;
               }

               var1.method1873().read(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.method3003(2)) {
                  return false;
               }

               var1.method1873().read(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.method3003(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.read(var3.payload, 0, var1.packetLength);
            var1.field1457 = 0;
            field976.method4918();
            var1.field1459 = var1.field1468;
            var1.field1468 = var1.field1467;
            var1.field1467 = var1.serverPacket;
            if(ServerPacket.field2250 == var1.serverPacket) {
               class9.method46(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            int var21;
            if(ServerPacket.field2223 == var1.serverPacket) {
               field1094 = false;

               for(var21 = 0; var21 < 5; ++var21) {
                  field1095[var21] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2239 == var1.serverPacket) {
               var21 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               if(field1085 != 0 && var5 != 0 && field1031 < 50) {
                  field956[field1031] = var21;
                  field986[field1031] = var5;
                  field1086[field1031] = var6;
                  audioEffects[field1031] = null;
                  field1092[field1031] = 0;
                  ++field1031;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2285 == var1.serverPacket) {
               class61.method973(class169.field2407);
               var1.serverPacket = null;
               return true;
            }

            Widget var22;
            String var55;
            if(ServerPacket.field2279 == var1.serverPacket) {
               var55 = var3.readString();
               var5 = var3.method3233();
               var22 = class64.method1017(var5);
               if(!var55.equals(var22.text)) {
                  var22.text = var55;
                  ScriptEvent.method1038(var22);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2282 == var1.serverPacket) {
               ClanMember.method1102();
               energy = var3.readUnsignedByte();
               field864 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2232 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  var21 = var3.offset - 28;
                  class11.method63(var3.payload, var21);
                  class148.method2911(var3, var21);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2254 == var1.serverPacket) {
               byte var88 = var3.method3189();
               var5 = var3.method3224();
               class218.settings[var5] = var88;
               if(class218.widgetSettings[var5] != var88) {
                  class218.widgetSettings[var5] = var88;
               }

               class36.method476(var5);
               field1033[++field1034 - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            Widget var74;
            if(ServerPacket.field2260 == var1.serverPacket) {
               var21 = var3.readInt();
               var74 = class64.method1017(var21);
               var74.modelType = 3;
               var74.modelId = class275.localPlayer.composition.method3990();
               ScriptEvent.method1038(var74);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2220 == var1.serverPacket) {
               class72.method1054(var3.readString());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2215 == var1.serverPacket) {
               class94.playerIndexesCount = 0;

               for(var21 = 0; var21 < 2048; ++var21) {
                  class94.field1408[var21] = null;
                  class94.field1398[var21] = 1;
               }

               for(var21 = 0; var21 < 2048; ++var21) {
                  cachedPlayers[var21] = null;
               }

               class23.initializeGPI(var3);
               var1.serverPacket = null;
               return true;
            }

            int var16;
            long var24;
            long var26;
            if(ServerPacket.field2290 == var1.serverPacket) {
               var55 = var3.readString();
               var24 = (long)var3.readUnsignedShort();
               var26 = (long)var3.read24BitInt();
               Permission[] var80 = new Permission[]{Permission.field3237, Permission.field3235, Permission.field3234, Permission.field3233, Permission.field3240, Permission.field3232};
               Permission var59 = (Permission)class153.forOrdinal(var80, var3.readUnsignedByte());
               long var11 = (var24 << 32) + var26;
               boolean var13 = false;

               for(int var63 = 0; var63 < 100; ++var63) {
                  if(var11 == field1066[var63]) {
                     var13 = true;
                     break;
                  }
               }

               if(class13.isIgnored(var55)) {
                  var13 = true;
               }

               if(!var13 && field966 == 0) {
                  field1066[field1067] = var11;
                  field1067 = (field1067 + 1) % 100;

                  String var65;
                  try {
                     var16 = var3.getUSmart();
                     if(var16 > 32767) {
                        var16 = 32767;
                     }

                     byte[] var67 = new byte[var16];
                     var3.offset += class272.field3707.decompress(var3.payload, var3.offset, var67, 0, var16);
                     String var18 = class24.getString(var67, 0, var16);
                     var65 = var18;
                  } catch (Exception var50) {
                     var65 = "Cabbage";
                  }

                  var65 = FontTypeFace.appendTags(RSSocket.method3027(var65));
                  byte var66;
                  if(var59.field3231) {
                     var66 = 7;
                  } else {
                     var66 = 3;
                  }

                  if(var59.field3238 != -1) {
                     class3.sendGameMessage(var66, method1489(var59.field3238) + var55, var65);
                  } else {
                     class3.sendGameMessage(var66, var55, var65);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            long var29;
            if(ServerPacket.field2291 == var1.serverPacket) {
               var55 = var3.readString();
               var24 = var3.readLong();
               var26 = (long)var3.readUnsignedShort();
               var29 = (long)var3.read24BitInt();
               Permission[] var82 = new Permission[]{Permission.field3237, Permission.field3235, Permission.field3234, Permission.field3233, Permission.field3240, Permission.field3232};
               Permission var60 = (Permission)class153.forOrdinal(var82, var3.readUnsignedByte());
               long var33 = var29 + (var26 << 32);
               boolean var35 = false;

               for(var16 = 0; var16 < 100; ++var16) {
                  if(var33 == field1066[var16]) {
                     var35 = true;
                     break;
                  }
               }

               if(var60.field3239 && class13.isIgnored(var55)) {
                  var35 = true;
               }

               if(!var35 && field966 == 0) {
                  field1066[field1067] = var33;
                  field1067 = (field1067 + 1) % 100;

                  String var17;
                  try {
                     int var36 = var3.getUSmart();
                     if(var36 > 32767) {
                        var36 = 32767;
                     }

                     byte[] var19 = new byte[var36];
                     var3.offset += class272.field3707.decompress(var3.payload, var3.offset, var19, 0, var36);
                     String var20 = class24.getString(var19, 0, var36);
                     var17 = var20;
                  } catch (Exception var49) {
                     var17 = "Cabbage";
                  }

                  var17 = FontTypeFace.appendTags(RSSocket.method3027(var17));
                  if(var60.field3238 != -1) {
                     Friend.addChatMessage(9, method1489(var60.field3238) + var55, var17, class251.method4317(var24));
                  } else {
                     Friend.addChatMessage(9, var55, var17, class251.method4317(var24));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2293 == var1.serverPacket) {
               var21 = var3.readInt();
               WidgetNode var75 = (WidgetNode)componentTable.get((long)var21);
               if(var75 != null) {
                  class74.method1100(var75, true);
               }

               if(field878 != null) {
                  ScriptEvent.method1038(field878);
                  field878 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            int var7;
            int var8;
            int var9;
            if(ServerPacket.field2286 == var1.serverPacket) {
               var21 = var3.readInt();
               var5 = var3.method3224();
               var6 = var5 >> 10 & 31;
               var7 = var5 >> 5 & 31;
               var8 = var5 & 31;
               var9 = (var7 << 11) + (var6 << 19) + (var8 << 3);
               Widget var58 = class64.method1017(var21);
               if(var9 != var58.textColor) {
                  var58.textColor = var9;
                  ScriptEvent.method1038(var58);
               }

               var1.serverPacket = null;
               return true;
            }

            int var39;
            boolean var56;
            boolean var61;
            if(ServerPacket.field2262 == var1.serverPacket) {
               var55 = var3.readString();
               var5 = var3.readUnsignedShort();
               byte var62 = var3.readByte();
               var56 = false;
               if(var62 == -128) {
                  var56 = true;
               }

               if(var56) {
                  if(class34.clanChatCount == 0) {
                     var1.serverPacket = null;
                     return true;
                  }

                  var61 = false;

                  for(var8 = 0; var8 < class34.clanChatCount && (!Varcs.clanMembers[var8].username.equals(var55) || var5 != Varcs.clanMembers[var8].world); ++var8) {
                     ;
                  }

                  if(var8 < class34.clanChatCount) {
                     while(var8 < class34.clanChatCount - 1) {
                        Varcs.clanMembers[var8] = Varcs.clanMembers[var8 + 1];
                        ++var8;
                     }

                     --class34.clanChatCount;
                     Varcs.clanMembers[class34.clanChatCount] = null;
                  }
               } else {
                  var3.readString();
                  ClanMember var90 = new ClanMember();
                  var90.username = var55;
                  var90.field850 = class226.method4078(var90.username, class189.field2529);
                  var90.world = var5;
                  var90.rank = var62;

                  for(var9 = class34.clanChatCount - 1; var9 >= 0; --var9) {
                     var39 = Varcs.clanMembers[var9].field850.compareTo(var90.field850);
                     if(var39 == 0) {
                        Varcs.clanMembers[var9].world = var5;
                        Varcs.clanMembers[var9].rank = var62;
                        if(var55.equals(class275.localPlayer.name)) {
                           class111.clanChatRank = var62;
                        }

                        field1046 = cycleCntr;
                        var1.serverPacket = null;
                        return true;
                     }

                     if(var39 < 0) {
                        break;
                     }
                  }

                  if(class34.clanChatCount >= Varcs.clanMembers.length) {
                     var1.serverPacket = null;
                     return true;
                  }

                  for(var39 = class34.clanChatCount - 1; var39 > var9; --var39) {
                     Varcs.clanMembers[var39 + 1] = Varcs.clanMembers[var39];
                  }

                  if(class34.clanChatCount == 0) {
                     Varcs.clanMembers = new ClanMember[100];
                  }

                  Varcs.clanMembers[var9 + 1] = var90;
                  ++class34.clanChatCount;
                  if(var55.equals(class275.localPlayer.name)) {
                     class111.clanChatRank = var62;
                  }
               }

               field1046 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2221 == var1.serverPacket) {
               class61.method973(class169.field2405);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2253 == var1.serverPacket) {
               VertexNormal.xteaChanged(false, var1.field1461);
               var1.serverPacket = null;
               return true;
            }

            Widget var95;
            if(ServerPacket.field2261 == var1.serverPacket) {
               var21 = var3.method3231();
               var5 = var3.method3232();
               var6 = var3.method3290();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var95 = class64.method1017(var21);
               ItemComposition var89;
               if(!var95.hasScript) {
                  if(var6 == -1) {
                     var95.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var89 = class139.getItemDefinition(var6);
                  var95.modelType = 4;
                  var95.modelId = var6;
                  var95.rotationX = var89.xan2d;
                  var95.rotationZ = var89.yan2d;
                  var95.modelZoom = var89.zoom2d * 100 / var5;
                  ScriptEvent.method1038(var95);
               } else {
                  var95.itemId = var6;
                  var95.itemQuantity = var5;
                  var89 = class139.getItemDefinition(var6);
                  var95.rotationX = var89.xan2d;
                  var95.rotationZ = var89.yan2d;
                  var95.rotationY = var89.zan2d;
                  var95.field2762 = var89.offsetX2d;
                  var95.field2763 = var89.offsetY2d;
                  var95.modelZoom = var89.zoom2d;
                  if(var89.isStackable == 1) {
                     var95.field2787 = 1;
                  } else {
                     var95.field2787 = 2;
                  }

                  if(var95.field2768 > 0) {
                     var95.modelZoom = var95.modelZoom * 32 / var95.field2768;
                  } else if(var95.originalWidth > 0) {
                     var95.modelZoom = var95.modelZoom * 32 / var95.originalWidth;
                  }

                  ScriptEvent.method1038(var95);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2273 == var1.serverPacket) {
               var21 = var3.method3233();
               var74 = class64.method1017(var21);

               for(var6 = 0; var6 < var74.itemIds.length; ++var6) {
                  var74.itemIds[var6] = -1;
                  var74.itemIds[var6] = 0;
               }

               ScriptEvent.method1038(var74);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2275 == var1.serverPacket) {
               for(var21 = 0; var21 < VarPlayerType.field3338; ++var21) {
                  VarPlayerType var73 = class275.method4883(var21);
                  if(var73 != null) {
                     class218.settings[var21] = 0;
                     class218.widgetSettings[var21] = 0;
                  }
               }

               ClanMember.method1102();
               field1034 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2217 == var1.serverPacket) {
               var21 = var3.readUnsignedShort();
               var5 = var3.method3222();
               var6 = var3.method3231();
               var95 = class64.method1017(var6);
               var95.field2769 = var21 + (var5 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2224 == var1.serverPacket) {
               var21 = var3.method3233();
               var5 = var3.method3222();
               class218.settings[var5] = var21;
               if(class218.widgetSettings[var5] != var21) {
                  class218.widgetSettings[var5] = var21;
               }

               class36.method476(var5);
               field1033[++field1034 - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2288 == var1.serverPacket) {
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

            if(ServerPacket.field2267 == var1.serverPacket) {
               var21 = var3.method3233();
               var5 = var3.method3188();
               var6 = var3.readShort();
               var95 = class64.method1017(var21);
               if(var5 != var95.originalX || var6 != var95.originalY || var95.field2718 != 0 || var95.field2721 != 0) {
                  var95.originalX = var5;
                  var95.originalY = var6;
                  var95.field2718 = 0;
                  var95.field2721 = 0;
                  ScriptEvent.method1038(var95);
                  this.method1340(var95);
                  if(var95.type == 0) {
                     class90.method1686(Widget.widgets[var21 >> 16], var95, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2226 == var1.serverPacket) {
               PacketNode.field2415 = var3.readUnsignedByte();
               ClanMember.field861 = var3.method3214();

               while(var3.offset < var1.packetLength) {
                  var21 = var3.readUnsignedByte();
                  class169[] var72 = new class169[]{class169.field2414, class169.field2405, class169.field2406, class169.field2404, class169.field2407, class169.field2412, class169.field2410, class169.field2409, class169.field2408, class169.field2413};
                  class169 var81 = var72[var21];
                  class61.method973(var81);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2230 == var1.serverPacket) {
               WidgetNode.method1025(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            boolean var64;
            String var69;
            if(ServerPacket.field2292 == var1.serverPacket) {
               while(var3.offset < var1.packetLength) {
                  var21 = var3.readUnsignedByte();
                  var64 = (var21 & 1) == 1;
                  var69 = var3.readString();
                  String var94 = var3.readString();
                  var3.readString();

                  for(var8 = 0; var8 < ignoreCount; ++var8) {
                     Ignore var79 = ignores[var8];
                     if(var64) {
                        if(var94.equals(var79.name)) {
                           var79.name = var69;
                           var79.previousName = var94;
                           var69 = null;
                           break;
                        }
                     } else if(var69.equals(var79.name)) {
                        var79.name = var69;
                        var79.previousName = var94;
                        var69 = null;
                        break;
                     }
                  }

                  if(var69 != null && ignoreCount < 400) {
                     Ignore var87 = new Ignore();
                     ignores[ignoreCount] = var87;
                     var87.name = var69;
                     var87.previousName = var94;
                     ++ignoreCount;
                  }
               }

               field1040 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            int var43;
            if(ServerPacket.field2265 == var1.serverPacket) {
               field1046 = cycleCntr;
               if(var1.packetLength == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  class34.clanChatCount = 0;
                  Varcs.clanMembers = null;
                  var1.serverPacket = null;
                  return true;
               }

               clanChatName = var3.readString();
               long var41 = var3.readLong();
               clanChatOwner = class256.method4406(var41);
               class41.field517 = var3.readByte();
               var6 = var3.readUnsignedByte();
               if(var6 == 255) {
                  var1.serverPacket = null;
                  return true;
               }

               class34.clanChatCount = var6;
               ClanMember[] var93 = new ClanMember[100];

               for(var8 = 0; var8 < class34.clanChatCount; ++var8) {
                  var93[var8] = new ClanMember();
                  var93[var8].username = var3.readString();
                  var93[var8].field850 = class226.method4078(var93[var8].username, class189.field2529);
                  var93[var8].world = var3.readUnsignedShort();
                  var93[var8].rank = var3.readByte();
                  var3.readString();
                  if(var93[var8].username.equals(class275.localPlayer.name)) {
                     class111.clanChatRank = var93[var8].rank;
                  }
               }

               var61 = false;
               var39 = class34.clanChatCount;

               while(var39 > 0) {
                  var61 = true;
                  --var39;

                  for(var43 = 0; var43 < var39; ++var43) {
                     if(var93[var43].field850.compareTo(var93[var43 + 1].field850) > 0) {
                        ClanMember var78 = var93[var43];
                        var93[var43] = var93[var43 + 1];
                        var93[var43 + 1] = var78;
                        var61 = false;
                     }
                  }

                  if(var61) {
                     break;
                  }
               }

               Varcs.clanMembers = var93;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2214 == var1.serverPacket) {
               class36.method475(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2255 == var1.serverPacket) {
               var21 = var3.method3232();
               var5 = var3.method3290();
               var22 = class64.method1017(var21);
               if(var22 != null && var22.type == 0) {
                  if(var5 > var22.scrollHeight - var22.height) {
                     var5 = var22.scrollHeight - var22.height;
                  }

                  if(var5 < 0) {
                     var5 = 0;
                  }

                  if(var5 != var22.scrollY) {
                     var22.scrollY = var5;
                     ScriptEvent.method1038(var22);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2294 == var1.serverPacket) {
               class61.method973(class169.field2413);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2246 == var1.serverPacket) {
               var21 = var3.getUSmart();
               var64 = var3.readUnsignedByte() == 1;
               var69 = "";
               var56 = false;
               if(var64) {
                  var69 = var3.readString();
                  if(class13.isIgnored(var69)) {
                     var56 = true;
                  }
               }

               String var86 = var3.readString();
               if(!var56) {
                  class3.sendGameMessage(var21, var69, var86);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2249 == var1.serverPacket) {
               class61.method973(class169.field2412);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2264 == var1.serverPacket) {
               for(var21 = 0; var21 < cachedPlayers.length; ++var21) {
                  if(cachedPlayers[var21] != null) {
                     cachedPlayers[var21].animation = -1;
                  }
               }

               for(var21 = 0; var21 < cachedNPCs.length; ++var21) {
                  if(cachedNPCs[var21] != null) {
                     cachedNPCs[var21].animation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2268 == var1.serverPacket) {
               var55 = var3.readString();
               var5 = var3.readUnsignedByte();
               var6 = var3.method3214();
               if(var5 >= 1 && var5 <= 8) {
                  if(var55.equalsIgnoreCase("null")) {
                     var55 = null;
                  }

                  playerOptions[var5 - 1] = var55;
                  playerOptionsPriorities[var5 - 1] = var6 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2280 == var1.serverPacket) {
               class61.method973(class169.field2408);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2251 == var1.serverPacket) {
               var21 = var3.method3290();
               if(var21 == 65535) {
                  var21 = -1;
               }

               class56.method770(var21);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2235 == var1.serverPacket) {
               var21 = var3.method3222();
               if(var21 == 65535) {
                  var21 = -1;
               }

               var5 = var3.method3329();
               if(field945 != 0 && var21 != -1) {
                  class226.method4079(class61.indexTrack2, var21, 0, field945, false);
                  field1084 = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2296 == var1.serverPacket) {
               class61.method973(class169.field2409);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2278 == var1.serverPacket) {
               for(var21 = 0; var21 < class218.widgetSettings.length; ++var21) {
                  if(class218.widgetSettings[var21] != class218.settings[var21]) {
                     class218.widgetSettings[var21] = class218.settings[var21];
                     class36.method476(var21);
                     field1033[++field1034 - 1 & 31] = var21;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2228 == var1.serverPacket) {
               class36.method475(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2256 == var1.serverPacket) {
               VertexNormal.xteaChanged(true, var1.field1461);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2242 == var1.serverPacket) {
               field1063 = var3.method3215();
               field1064 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2244 == var1.serverPacket) {
               var55 = var3.readString();

               try {
                  var7 = var3.getUSmart();
                  if(var7 > 32767) {
                     var7 = 32767;
                  }

                  byte[] var84 = new byte[var7];
                  var3.offset += class272.field3707.decompress(var3.payload, var3.offset, var84, 0, var7);
                  String var77 = class24.getString(var84, 0, var7);
                  var69 = var77;
               } catch (Exception var48) {
                  var69 = "Cabbage";
               }

               var69 = FontTypeFace.appendTags(RSSocket.method3027(var69));
               class3.sendGameMessage(6, var55, var69);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2289 == var1.serverPacket) {
               var55 = var3.readString();
               Object[] var70 = new Object[var55.length() + 1];

               for(var6 = var55.length() - 1; var6 >= 0; --var6) {
                  if(var55.charAt(var6) == 's') {
                     var70[var6 + 1] = var3.readString();
                  } else {
                     var70[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var70[0] = new Integer(var3.readInt());
               ScriptEvent var76 = new ScriptEvent();
               var76.field785 = var70;
               BaseVarType.method11(var76);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2216 == var1.serverPacket) {
               field1108 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2240 == var1.serverPacket) {
               var21 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var21 < -70000) {
                  var5 += 32768;
               }

               if(var21 >= 0) {
                  var22 = class64.method1017(var21);
               } else {
                  var22 = null;
               }

               if(var22 != null) {
                  for(var7 = 0; var7 < var22.itemIds.length; ++var7) {
                     var22.itemIds[var7] = 0;
                     var22.itemQuantities[var7] = 0;
                  }
               }

               ItemContainer var92 = (ItemContainer)ItemContainer.itemContainers.get((long)var5);
               if(var92 != null) {
                  for(var8 = 0; var8 < var92.itemIds.length; ++var8) {
                     var92.itemIds[var8] = -1;
                     var92.stackSizes[var8] = 0;
                  }
               }

               var7 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var3.method3224();
                  var39 = var3.readUnsignedByte();
                  if(var39 == 255) {
                     var39 = var3.readInt();
                  }

                  if(var22 != null && var8 < var22.itemIds.length) {
                     var22.itemIds[var8] = var9;
                     var22.itemQuantities[var8] = var39;
                  }

                  class51.setItemTableSlot(var5, var8, var9 - 1, var39);
               }

               if(var22 != null) {
                  ScriptEvent.method1038(var22);
               }

               ClanMember.method1102();
               interfaceItemTriggers[++field973 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2274 == var1.serverPacket) {
               var21 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var21 < -70000) {
                  var5 += 32768;
               }

               if(var21 >= 0) {
                  var22 = class64.method1017(var21);
               } else {
                  var22 = null;
               }

               for(; var3.offset < var1.packetLength; class51.setItemTableSlot(var5, var7, var8 - 1, var9)) {
                  var7 = var3.getUSmart();
                  var8 = var3.readUnsignedShort();
                  var9 = 0;
                  if(var8 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var22 != null && var7 >= 0 && var7 < var22.itemIds.length) {
                     var22.itemIds[var7] = var8;
                     var22.itemQuantities[var7] = var9;
                  }
               }

               if(var22 != null) {
                  ScriptEvent.method1038(var22);
               }

               ClanMember.method1102();
               interfaceItemTriggers[++field973 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2270 == var1.serverPacket) {
               var21 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var21] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var21] = new GrandExchangeOffer(var3, false);
               }

               field1042 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2245 == var1.serverPacket) {
               field1094 = true;
               MilliTimer.field2117 = var3.readUnsignedByte();
               BufferProvider.field3814 = var3.readUnsignedByte();
               class27.field370 = var3.readUnsignedShort();
               World.field1220 = var3.readUnsignedByte();
               class2.field11 = var3.readUnsignedByte();
               if(class2.field11 >= 100) {
                  class45.cameraX = MilliTimer.field2117 * 128 + 64;
                  cameraY = BufferProvider.field3814 * 128 + 64;
                  class279.cameraZ = class18.getTileHeight(class45.cameraX, cameraY, class28.plane) - class27.field370;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2257 == var1.serverPacket) {
               field1094 = true;
               class81.field1236 = var3.readUnsignedByte();
               Enum.field3448 = var3.readUnsignedByte();
               Widget.field2848 = var3.readUnsignedShort();
               CombatInfo1.field1209 = var3.readUnsignedByte();
               AbstractByteBuffer.field2511 = var3.readUnsignedByte();
               if(AbstractByteBuffer.field2511 >= 100) {
                  var21 = class81.field1236 * 128 + 64;
                  var5 = Enum.field3448 * 128 + 64;
                  var6 = class18.getTileHeight(var21, var5, class28.plane) - Widget.field2848;
                  var7 = var21 - class45.cameraX;
                  var8 = var6 - class279.cameraZ;
                  var9 = var5 - cameraY;
                  var39 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                  class45.cameraPitch = (int)(Math.atan2((double)var8, (double)var39) * 325.949D) & 2047;
                  class230.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                  if(class45.cameraPitch < 128) {
                     class45.cameraPitch = 128;
                  }

                  if(class45.cameraPitch > 383) {
                     class45.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2252 == var1.serverPacket) {
               ClanMember.method1102();
               weight = var3.readShort();
               field864 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2233 == var1.serverPacket) {
               class61.method973(class169.field2406);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2259 == var1.serverPacket) {
               var21 = var3.method3224();
               class259.method4461(var21);
               interfaceItemTriggers[++field973 - 1 & 31] = var21 & 32767;
               var1.serverPacket = null;
               return true;
            }

            boolean var71;
            if(ServerPacket.field2271 == var1.serverPacket) {
               var71 = var3.readUnsignedShortOb1() == 1;
               var5 = var3.method3231();
               var22 = class64.method1017(var5);
               if(var71 != var22.isHidden) {
                  var22.isHidden = var71;
                  ScriptEvent.method1038(var22);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2277 == var1.serverPacket) {
               PacketNode.field2415 = var3.method3214();
               ClanMember.field861 = var3.method3214();

               for(var21 = PacketNode.field2415; var21 < PacketNode.field2415 + 8; ++var21) {
                  for(var5 = ClanMember.field861; var5 < ClanMember.field861 + 8; ++var5) {
                     if(groundItemDeque[class28.plane][var21][var5] != null) {
                        groundItemDeque[class28.plane][var21][var5] = null;
                        ScriptEvent.groundItemSpawned(var21, var5);
                     }
                  }
               }

               for(PendingSpawn var54 = (PendingSpawn)pendingSpawns.getFront(); var54 != null; var54 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var54.x >= PacketNode.field2415 && var54.x < PacketNode.field2415 + 8 && var54.y >= ClanMember.field861 && var54.y < ClanMember.field861 + 8 && var54.level == class28.plane) {
                     var54.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2222 == var1.serverPacket) {
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

            if(ServerPacket.field2243 == var1.serverPacket) {
               field910 = var3.method3222() * 30;
               field864 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2229 == var1.serverPacket) {
               var21 = var3.readUnsignedShort();
               widgetRoot = var21;
               this.method1123(false);
               class51.method724(var21);
               class37.method479(widgetRoot);

               for(var5 = 0; var5 < 100; ++var5) {
                  field1052[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2241 == var1.serverPacket) {
               var21 = var3.readInt();
               var5 = var3.readInt();
               var6 = class250.method4295();
               PacketNode var91 = class18.method133(ClientPacket.field2387, field905.field1460);
               var91.packetBuffer.putByte(GameEngine.FPS);
               var91.packetBuffer.method3220(var6);
               var91.packetBuffer.method3230(var21);
               var91.packetBuffer.method3353(var5);
               field905.method1855(var91);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2248 == var1.serverPacket) {
               PacketNode.field2415 = var3.readUnsignedByte();
               ClanMember.field861 = var3.readUnsignedShortOb1();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2283 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  var21 = widgetRoot;
                  if(class64.loadWidget(var21)) {
                     class19.method145(Widget.widgets[var21], 0);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2218 == var1.serverPacket) {
               class61.method973(class169.field2404);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2276 == var1.serverPacket) {
               while(var3.offset < var1.packetLength) {
                  var71 = var3.readUnsignedByte() == 1;
                  var23 = var3.readString();
                  var69 = var3.readString();
                  var7 = var3.readUnsignedShort();
                  var8 = var3.readUnsignedByte();
                  var9 = var3.readUnsignedByte();
                  boolean var85 = (var9 & 2) != 0;
                  boolean var96 = (var9 & 1) != 0;
                  if(var7 > 0) {
                     var3.readString();
                     var3.readUnsignedByte();
                     var3.readInt();
                  }

                  var3.readString();

                  for(int var44 = 0; var44 < friendCount; ++var44) {
                     Friend var45 = friends[var44];
                     if(!var71) {
                        if(var23.equals(var45.name)) {
                           if(var7 != var45.world) {
                              boolean var14 = true;

                              for(class66 var15 = (class66)field1116.method3684(); var15 != null; var15 = (class66)field1116.method3681()) {
                                 if(var15.field769.equals(var23)) {
                                    if(var7 != 0 && var15.field762 == 0) {
                                       var15.method3689();
                                       var14 = false;
                                    } else if(var7 == 0 && var15.field762 != 0) {
                                       var15.method3689();
                                       var14 = false;
                                    }
                                 }
                              }

                              if(var14) {
                                 field1116.method3680(new class66(var23, var7));
                              }

                              var45.world = var7;
                           }

                           var45.previousName = var69;
                           var45.rank = var8;
                           var45.field755 = var85;
                           var45.field757 = var96;
                           var23 = null;
                           break;
                        }
                     } else if(var69.equals(var45.name)) {
                        var45.name = var23;
                        var45.previousName = var69;
                        var23 = null;
                        break;
                     }
                  }

                  if(var23 != null && friendCount < 400) {
                     Friend var12 = new Friend();
                     friends[friendCount] = var12;
                     var12.name = var23;
                     var12.previousName = var69;
                     var12.world = var7;
                     var12.rank = var8;
                     var12.field755 = var85;
                     var12.field757 = var96;
                     ++friendCount;
                  }
               }

               field1114 = 2;
               field1040 = cycleCntr;
               var71 = false;
               var5 = friendCount;

               while(var5 > 0) {
                  var71 = true;
                  --var5;

                  for(var6 = 0; var6 < var5; ++var6) {
                     var56 = false;
                     Friend var83 = friends[var6];
                     Friend var28 = friends[var6 + 1];
                     if(var83.world != world && var28.world == world) {
                        var56 = true;
                     }

                     if(!var56 && var83.world == 0 && var28.world != 0) {
                        var56 = true;
                     }

                     if(!var56 && !var83.field755 && var28.field755) {
                        var56 = true;
                     }

                     if(!var56 && !var83.field757 && var28.field757) {
                        var56 = true;
                     }

                     if(var56) {
                        Friend var57 = friends[var6];
                        friends[var6] = friends[var6 + 1];
                        friends[var6 + 1] = var57;
                        var71 = false;
                     }
                  }

                  if(var71) {
                     break;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2284 == var1.serverPacket) {
               var71 = var3.readUnsignedByte() == 1;
               if(var71) {
                  ClanMember.field860 = ChatLineBuffer.currentTimeMs() - var3.readLong();
                  ClanMember.field855 = new class13(var3, true);
               } else {
                  ClanMember.field855 = null;
               }

               field967 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2227 == var1.serverPacket) {
               World var53 = new World();
               var53.address = var3.readString();
               var53.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var53.mask = var5;
               class2.setGameState(45);
               var2.close();
               var2 = null;
               class24.method176(var53);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2287 == var1.serverPacket) {
               field1114 = 1;
               field1040 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2238 == var1.serverPacket) {
               var21 = var3.method3232();
               var5 = var3.readUnsignedShort();
               var22 = class64.method1017(var21);
               if(var22.modelType != 1 || var5 != var22.modelId) {
                  var22.modelType = 1;
                  var22.modelId = var5;
                  ScriptEvent.method1038(var22);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var38;
            if(ServerPacket.field2247 == var1.serverPacket) {
               var21 = var3.method3224();
               var5 = var3.method3224();
               var6 = var3.readUnsignedShort();
               var7 = var3.method3231();
               var38 = class64.method1017(var7);
               if(var21 != var38.rotationX || var5 != var38.rotationZ || var6 != var38.modelZoom) {
                  var38.rotationX = var21;
                  var38.rotationZ = var5;
                  var38.modelZoom = var6;
                  ScriptEvent.method1038(var38);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               ClanMember.method1102();
               var21 = var3.readUnsignedShortOb1();
               var5 = var3.method3233();
               var6 = var3.method3214();
               skillExperiences[var21] = var5;
               boostedSkillLevels[var21] = var6;
               realSkillLevels[var21] = 1;

               for(var7 = 0; var7 < 98; ++var7) {
                  if(var5 >= class229.field2900[var7]) {
                     realSkillLevels[var21] = var7 + 2;
                  }
               }

               field1037[++field1038 - 1 & 31] = var21;
               var1.serverPacket = null;
               return true;
            }

            WidgetNode var40;
            if(ServerPacket.field2269 == var1.serverPacket) {
               var21 = var3.method3232();
               var5 = var3.method3231();
               WidgetNode var68 = (WidgetNode)componentTable.get((long)var21);
               var40 = (WidgetNode)componentTable.get((long)var5);
               if(var40 != null) {
                  class74.method1100(var40, var68 == null || var68.id != var40.id);
               }

               if(var68 != null) {
                  var68.unlink();
                  componentTable.put(var68, (long)var5);
               }

               var38 = class64.method1017(var21);
               if(var38 != null) {
                  ScriptEvent.method1038(var38);
               }

               var38 = class64.method1017(var5);
               if(var38 != null) {
                  ScriptEvent.method1038(var38);
                  class90.method1686(Widget.widgets[var38.id >>> 16], var38, true);
               }

               if(widgetRoot != -1) {
                  var9 = widgetRoot;
                  if(class64.loadWidget(var9)) {
                     class19.method145(Widget.widgets[var9], 1);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2234 == var1.serverPacket) {
               var21 = var3.method3222();
               var5 = var3.method3232();
               var22 = class64.method1017(var5);
               if(var22.modelType != 2 || var21 != var22.modelId) {
                  var22.modelType = 2;
                  var22.modelId = var21;
                  ScriptEvent.method1038(var22);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2272 == var1.serverPacket) {
               class61.method973(class169.field2410);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2237 == var1.serverPacket) {
               class12.method64();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2236 == var1.serverPacket) {
               var21 = var3.method3222();
               if(var21 == 65535) {
                  var21 = -1;
               }

               var5 = var3.readInt();
               var6 = var3.readInt();
               var7 = var3.readUnsignedShort();
               if(var7 == 65535) {
                  var7 = -1;
               }

               for(var8 = var21; var8 <= var7; ++var8) {
                  var29 = ((long)var6 << 32) + (long)var8;
                  Node var31 = widgetFlags.get(var29);
                  if(var31 != null) {
                     var31.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var5), var29);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2219 == var1.serverPacket) {
               var21 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var7 = var3.readUnsignedByte();
               field1095[var21] = true;
               field868[var21] = var5;
               field1074[var21] = var6;
               field1098[var21] = var7;
               field990[var21] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2258 == var1.serverPacket) {
               class61.method973(class169.field2414);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2231 == var1.serverPacket) {
               var21 = var3.offset + var1.packetLength;
               var5 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var5 != widgetRoot) {
                  widgetRoot = var5;
                  this.method1123(false);
                  class51.method724(widgetRoot);
                  class37.method479(widgetRoot);

                  for(var7 = 0; var7 < 100; ++var7) {
                     field1052[var7] = true;
                  }
               }

               WidgetNode var10;
               for(; var6-- > 0; var10.field772 = true) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var10 = (WidgetNode)componentTable.get((long)var7);
                  if(var10 != null && var8 != var10.id) {
                     class74.method1100(var10, true);
                     var10 = null;
                  }

                  if(var10 == null) {
                     var10 = class222.method4016(var7, var8, var9);
                  }
               }

               for(var40 = (WidgetNode)componentTable.method3592(); var40 != null; var40 = (WidgetNode)componentTable.method3593()) {
                  if(var40.field772) {
                     var40.field772 = false;
                  } else {
                     class74.method1100(var40, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var21) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var39 = var3.readInt();

                  for(var43 = var8; var43 <= var9; ++var43) {
                     long var46 = ((long)var7 << 32) + (long)var43;
                     widgetFlags.put(new IntegerNode(var39), var46);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2281 == var1.serverPacket) {
               var21 = var3.method3231();
               var5 = var3.method3214();
               var6 = var3.method3224();
               var40 = (WidgetNode)componentTable.get((long)var21);
               if(var40 != null) {
                  class74.method1100(var40, var6 != var40.id);
               }

               class222.method4016(var21, var6, var5);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2266 == var1.serverPacket) {
               var21 = var3.method3188();
               var5 = var3.method3231();
               var22 = class64.method1017(var5);
               if(var21 != var22.field2760 || var21 == -1) {
                  var22.field2760 = var21;
                  var22.field2835 = 0;
                  var22.field2723 = 0;
                  ScriptEvent.method1038(var22);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2263 == var1.serverPacket) {
               FloorUnderlayDefinition.field3397 = class217.method3960(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            class48.method690("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1468 != null?var1.field1468.packetId:-1) + "," + (var1.field1459 != null?var1.field1459.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            class12.method64();
         } catch (IOException var51) {
            ScriptEvent.method1036();
         } catch (Exception var52) {
            var23 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1468 != null?var1.field1468.packetId:-1) + "," + (var1.field1459 != null?var1.field1459.packetId:-1) + "," + var1.packetLength + "," + (class275.localPlayer.pathX[0] + class13.baseX) + "," + (class275.localPlayer.pathY[0] + ClanMember.baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var23 = var23 + var3.payload[var6] + ",";
            }

            class48.method690(var23, var52);
            class12.method64();
         }

         return true;
      }
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "846022435"
   )
   final void method1120() {
      WidgetNode.method1029();
      if(class72.field812 == null) {
         if(field1020 == null) {
            int var1 = MouseInput.field687;
            int var2;
            int var4;
            int var5;
            int var6;
            int var7;
            int var9;
            if(isMenuOpen) {
               int var3;
               if(var1 != 1 && (Signlink.field2142 || var1 != 4)) {
                  var2 = MouseInput.field681;
                  var3 = MouseInput.field676;
                  if(var2 < class48.menuX - 10 || var2 > class48.menuX + GraphicsObject.menuWidth + 10 || var3 < class168.menuY - 10 || var3 > class24.menuHeight + class168.menuY + 10) {
                     isMenuOpen = false;
                     method1490(class48.menuX, class168.menuY, GraphicsObject.menuWidth, class24.menuHeight);
                  }
               }

               if(var1 == 1 || !Signlink.field2142 && var1 == 4) {
                  var2 = class48.menuX;
                  var3 = class168.menuY;
                  var4 = GraphicsObject.menuWidth;
                  var5 = MouseInput.field674;
                  var6 = MouseInput.field688;
                  var7 = -1;

                  for(int var15 = 0; var15 < menuOptionCount; ++var15) {
                     var9 = var3 + (menuOptionCount - 1 - var15) * 15 + 31;
                     if(var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var7 = var15;
                     }
                  }

                  if(var7 != -1) {
                     class164.method3089(var7);
                  }

                  isMenuOpen = false;
                  method1490(class48.menuX, class168.menuY, GraphicsObject.menuWidth, class24.menuHeight);
               }
            } else {
               var2 = menuOptionCount - 1;
               if((var1 == 1 || !Signlink.field2142 && var1 == 4) && var2 >= 0) {
                  var4 = menuTypes[var2];
                  if(var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                     label264: {
                        var5 = menuActionParams0[var2];
                        var6 = menuActionParams1[var2];
                        Widget var12 = class64.method1017(var6);
                        var9 = class12.getWidgetConfig(var12);
                        boolean var8 = (var9 >> 28 & 1) != 0;
                        if(!var8) {
                           int var11 = class12.getWidgetConfig(var12);
                           boolean var10 = (var11 >> 29 & 1) != 0;
                           if(!var10) {
                              break label264;
                           }
                        }

                        if(class72.field812 != null && !field964 && menuOptionCount > 0 && !this.method1121()) {
                           WorldMapType2.method506(field923, field962);
                        }

                        field964 = false;
                        field965 = 0;
                        if(class72.field812 != null) {
                           ScriptEvent.method1038(class72.field812);
                        }

                        class72.field812 = class64.method1017(var6);
                        field890 = var5;
                        field923 = MouseInput.field674;
                        field962 = MouseInput.field688;
                        if(var2 >= 0) {
                           CacheFile.method2363(var2);
                        }

                        ScriptEvent.method1038(class72.field812);
                        return;
                     }
                  }
               }

               if((var1 == 1 || !Signlink.field2142 && var1 == 4) && this.method1121()) {
                  var1 = 2;
               }

               if((var1 == 1 || !Signlink.field2142 && var1 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var4 = menuActionParams0[var2];
                  var5 = menuActionParams1[var2];
                  var6 = menuTypes[var2];
                  var7 = menuIdentifiers[var2];
                  String var13 = menuOptions[var2];
                  String var14 = menuTargets[var2];
                  class14.menuAction(var4, var5, var6, var7, var13, var14, MouseInput.field674, MouseInput.field688);
               }

               if(var1 == 2 && menuOptionCount > 0) {
                  this.method1122(MouseInput.field674, MouseInput.field688);
               }
            }

         }
      }
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "118"
   )
   final boolean method1121() {
      int var1 = menuOptionCount - 1;
      if(menuOptionCount > 2) {
         if(field984 != 1 || field943[var1]) {
            boolean var3;
            if(var1 < 0) {
               var3 = false;
            } else {
               int var4 = menuTypes[var1];
               if(var4 >= 2000) {
                  var4 -= 2000;
               }

               if(var4 == 1007) {
                  var3 = true;
               } else {
                  var3 = false;
               }
            }

            if(!var3) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "575718167"
   )
   final void method1122(int var1, int var2) {
      int var3 = field909.method4790("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = field909;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargets[var4].length() > 0) {
            var6 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var6 = menuOptions[var4];
         }

         int var7 = var5.method4790(var6);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      int var8 = var1 - var3 / 2;
      if(var8 + var3 > class66.canvasWidth) {
         var8 = class66.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var2 + var4 > Item.canvasHeight) {
         var9 = Item.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      region.method2789(class28.plane, var1, var2, false);
      isMenuOpen = true;
      class48.menuX = var8;
      class168.menuY = var9;
      GraphicsObject.menuWidth = var3;
      class24.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1763843219"
   )
   final void method1123(boolean var1) {
      class86.method1670(widgetRoot, class66.canvasWidth, Item.canvasHeight, var1);
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Lhx;I)V",
      garbageValue = "-82997045"
   )
   void method1340(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class64.method1017(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class66.canvasWidth;
         var4 = Item.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class239.method4101(var1, var3, var4, false);
      class72.method1055(var1, var3, var4);
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2062339015"
   )
   final void method1165() {
      ScriptEvent.method1038(field1020);
      ++class61.field711;
      if(field1028 && field1025) {
         int var1 = MouseInput.field681;
         int var2 = MouseInput.field676;
         var1 -= field1022;
         var2 -= field1121;
         if(var1 < field1026) {
            var1 = field1026;
         }

         if(var1 + field1020.width > field1026 + field1021.width) {
            var1 = field1026 + field1021.width - field1020.width;
         }

         if(var2 < field1059) {
            var2 = field1059;
         }

         if(var2 + field1020.height > field1059 + field1021.height) {
            var2 = field1059 + field1021.height - field1020.height;
         }

         int var3 = var1 - field1029;
         int var4 = var2 - field1030;
         int var5 = field1020.field2789;
         if(class61.field711 > field1020.field2790 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field993 = true;
         }

         int var6 = var1 - field1026 + field1021.scrollX;
         int var7 = var2 - field1059 + field1021.scrollY;
         ScriptEvent var8;
         if(field1020.field2802 != null && field993) {
            var8 = new ScriptEvent();
            var8.widget = field1020;
            var8.field778 = var6;
            var8.field775 = var7;
            var8.field785 = field1020.field2802;
            BaseVarType.method11(var8);
         }

         if(MouseInput.field689 == 0) {
            if(field993) {
               if(field1020.field2801 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1020;
                  var8.field778 = var6;
                  var8.field775 = var7;
                  var8.field781 = field1024;
                  var8.field785 = field1020.field2801;
                  BaseVarType.method11(var8);
               }

               if(field1024 != null && class89.method1680(field1020) != null) {
                  PacketNode var9 = class18.method133(ClientPacket.field2359, field905.field1460);
                  var9.packetBuffer.putShortLE(field1024.index);
                  var9.packetBuffer.method3221(field1020.index);
                  var9.packetBuffer.method3297(field1020.id);
                  var9.packetBuffer.putShortLE(field1024.itemId);
                  var9.packetBuffer.method3221(field1020.itemId);
                  var9.packetBuffer.putInt(field1024.id);
                  field905.method1855(var9);
               }
            } else if(this.method1121()) {
               this.method1122(field1022 + field1029, field1030 + field1121);
            } else if(menuOptionCount > 0) {
               WorldMapType2.method506(field1022 + field1029, field1121 + field1030);
            }

            field1020 = null;
         }

      } else {
         if(class61.field711 > 1) {
            field1020 = null;
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1440135973"
   )
   static String method1489(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-196000215"
   )
   static final void method1490(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < field1050; ++var4) {
         if(widgetBoundsWidth[var4] + widgetPositionX[var4] > var0 && widgetPositionX[var4] < var0 + var2 && widgetBoundsHeight[var4] + widgetPositionY[var4] > var1 && widgetPositionY[var4] < var3 + var1) {
            field1052[var4] = true;
         }
      }

   }
}
