import net.runelite.mapping.*;
import net.runelite.rs.Reflection;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -438939199
   )
   static int field1032;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 1871303889
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      longValue = 6287174895427849209L
   )
   static long field942;
   @ObfuscatedName("oi")
   static boolean field1008;
   @ObfuscatedName("mp")
   static boolean[] field1033;
   @ObfuscatedName("mk")
   static boolean[] field970;
   @ObfuscatedName("lz")
   static boolean field1009;
   @ObfuscatedName("ml")
   static boolean[] field1019;
   @ObfuscatedName("kl")
   static boolean field992;
   @ObfuscatedName("mw")
   @Export("isResized")
   @Hook("resizeChanged")
   static boolean isResized;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 1832474861
   )
   static int field1007;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 1192519963
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -1350765555
   )
   static int field950;
   @ObfuscatedName("mt")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("mi")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("mr")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("mf")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "Lbd;"
   )
   static final class72 field1104;
   @ObfuscatedName("mb")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("oa")
   static boolean field930;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = 902425557
   )
   static int field1010;
   @ObfuscatedName("pr")
   static boolean[] field1075;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 2104366493
   )
   static int field1011;
   @ObfuscatedName("qy")
   static int[] field1105;
   @ObfuscatedName("qp")
   static int[] field1106;
   @ObfuscatedName("mq")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static Deque field1027;
   @ObfuscatedName("lo")
   static boolean field1012;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = -969521837
   )
   static int field1067;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = -1965739811
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -431615365
   )
   static int field1022;
   @ObfuscatedName("nl")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 1432195607
   )
   static int field850;
   @ObfuscatedName("np")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 1390268741
   )
   static int field1015;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1347960203
   )
   static int field1025;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 837825917
   )
   static int field1045;
   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   static PlayerComposition field1090;
   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field1005;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = -2097279347
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -710720663
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = -350418185
   )
   static int field1101;
   @ObfuscatedName("ps")
   static int[] field1076;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -118830161
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("pl")
   static int[] field1077;
   @ObfuscatedName("pc")
   static int[] field1078;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = -1582258605
   )
   static int field1068;
   @ObfuscatedName("pq")
   static int[] field1079;
   @ObfuscatedName("ok")
   static int[] field1069;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 1272394779
   )
   static int field1055;
   @ObfuscatedName("oz")
   static int[] field1070;
   @ObfuscatedName("lf")
   static int[] field1018;
   @ObfuscatedName("oo")
   static int[] field1071;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -1544179335
   )
   static int field1094;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 1278027101
   )
   static int field922;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      intValue = 903888751
   )
   static int field1062;
   @ObfuscatedName("oc")
   @ObfuscatedSignature(
      signature = "[Ldi;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -478473563
   )
   static int field1041;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      longValue = 5120197159114370821L
   )
   static long field1052;
   @ObfuscatedName("ow")
   static int[] field1072;
   @ObfuscatedName("lt")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 1957516805
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 1838091003
   )
   static int field1017;
   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "[Lbi;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -418877485
   )
   static int field1056;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = 379628735
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("ne")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "[Lbh;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("nm")
   static int[] field914;
   @ObfuscatedName("pw")
   static short field1081;
   @ObfuscatedName("pt")
   static short field1080;
   @ObfuscatedName("nx")
   static int[] field1058;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 604026349
   )
   static int field845;
   @ObfuscatedName("pk")
   static short field1086;
   @ObfuscatedName("px")
   static short field1006;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 981875525
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = 1916496795
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("py")
   static short field867;
   @ObfuscatedName("pb")
   static short field878;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = 789289861
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("ph")
   static short field1083;
   @ObfuscatedName("pf")
   static short field1084;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = -123028359
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 905998429
   )
   static int field1087;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -1020819321
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 967296413
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static LinkDeque field1096;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = 951336099
   )
   static int field1066;
   @ObfuscatedName("nz")
   static long[] field1047;
   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "[Lr;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("ng")
   static String field1046;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -1106808611
   )
   static int field1048;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -715831847
   )
   static int field1050;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -848987665
   )
   static int field1049;
   @ObfuscatedName("nc")
   static int[] field1051;
   @ObfuscatedName("ny")
   static int[] field1085;
   @ObfuscatedName("mm")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static Deque field1028;
   @ObfuscatedName("la")
   static int[] field988;
   @ObfuscatedName("mu")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static Deque field1029;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 574628353
   )
   static int field1024;
   @ObfuscatedName("mc")
   static int[] field1043;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = 254134351
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "Lba;"
   )
   static OwnWorldComparator field1103;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfp;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("au")
   static boolean field1099;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -516348683
   )
   @Export("world")
   static int world;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -600424845
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 402349077
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("be")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bx")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -628562359
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bf")
   static String field1107;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -41679833
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("bm")
   static boolean field853;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 400517435
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      longValue = 12100145674618081L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -976640333
   )
   static int field1016;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1466930267
   )
   static int field966;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1808630899
   )
   static int field858;
   @ObfuscatedName("bj")
   static boolean field859;
   @ObfuscatedName("ba")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 507124691
   )
   static int field861;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1519630183
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1297669925
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -392377251
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -288982181
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -645003167
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1138049719
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -1413170751
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1628051803
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -868419915
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 443603509
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 2128917275
   )
   static int field874;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 1474174251
   )
   static int field875;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = -1576936849
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 1245303919
   )
   static int field1013;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 833214401
   )
   static int field1004;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 1240460715
   )
   static int field879;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   static class150 field1063;
   @ObfuscatedName("dv")
   static byte[] field1034;
   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "[Lci;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 469759311
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dq")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -1005396313
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("eu")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   @Export("signlink")
   static final NetWriter signlink;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = -192900493
   )
   static int field881;
   @ObfuscatedName("ed")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("eg")
   static boolean field891;
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static class287 field892;
   @ObfuscatedName("ey")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -1694947901
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -933553913
   )
   static int field895;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = 1600152405
   )
   static int field896;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -528481081
   )
   static int field897;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -1339645505
   )
   static int field898;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 1913120701
   )
   static int field899;
   @ObfuscatedName("fl")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fv")
   static int[][][] field902;
   @ObfuscatedName("fr")
   static final int[] field903;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 1667747075
   )
   static int field847;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 1679826283
   )
   static int field905;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 1181970199
   )
   static int field906;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 490066025
   )
   static int field907;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1167133761
   )
   static int field908;
   @ObfuscatedName("gh")
   static boolean field909;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 203286251
   )
   static int field856;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -171098899
   )
   static int field998;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -1215179141
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1685751543
   )
   static int field987;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 999818629
   )
   static int field901;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -1104222623
   )
   static int field915;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 976118241
   )
   static int field916;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 1516909663
   )
   static int field1014;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1711858225
   )
   static int field1021;
   @ObfuscatedName("gp")
   static boolean field919;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 57030045
   )
   static int field920;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 1026399043
   )
   static int field921;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -1470627121
   )
   static int field1100;
   @ObfuscatedName("gi")
   static int[] field923;
   @ObfuscatedName("gv")
   static int[] field924;
   @ObfuscatedName("gc")
   static int[] field925;
   @ObfuscatedName("he")
   static int[] field926;
   @ObfuscatedName("hr")
   static int[] field927;
   @ObfuscatedName("hv")
   static int[] field900;
   @ObfuscatedName("hp")
   static int[] field929;
   @ObfuscatedName("hh")
   static String[] field997;
   @ObfuscatedName("ha")
   static int[][] field931;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -1337416231
   )
   static int field932;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = 277812439
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 1559491565
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 2061978077
   )
   static int field1003;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -372785863
   )
   static int field936;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 743789307
   )
   static int field1092;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 52368887
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 1535720689
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -1664407999
   )
   static int field940;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 534977433
   )
   static int field1073;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -2074643165
   )
   static int field857;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 1318118513
   )
   static int field1039;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1486430659
   )
   static int field935;
   @ObfuscatedName("hi")
   static boolean field945;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 1767007759
   )
   static int field1082;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 919353163
   )
   static int field947;
   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "[Lbj;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 273517695
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = 349506369
   )
   static int field918;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 931091535
   )
   @Export("localNpcsCount")
   static int localNpcsCount;
   @ObfuscatedName("ij")
   @Export("npcIndicesPendingRemoval")
   static int[] npcIndicesPendingRemoval;
   @ObfuscatedName("ia")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("in")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("ib")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("id")
   static int[] field956;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 143460259
   )
   static int field957;
   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "[[[Lgl;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("if")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ic")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("iw")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 491278425
   )
   static int field965;
   @ObfuscatedName("ip")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -1716599453
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("je")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jf")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jq")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("jr")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jn")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("jh")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jj")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("jl")
   static boolean field975;
   @ObfuscatedName("jm")
   static boolean field976;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -1616528901
   )
   static int field964;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 1945867611
   )
   static int field882;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = 769134599
   )
   static int field979;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = -248752429
   )
   static int field980;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 1247988347
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("jb")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -163707365
   )
   static int field984;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 208949321
   )
   static int field985;
   @ObfuscatedName("ku")
   static String field986;
   @ObfuscatedName("kd")
   static String field910;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 634425425
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 1018135391
   )
   static int field990;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -958270837
   )
   static int field991;
   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field958;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -1863294619
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -297847855
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = 810022409
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 1395017887
   )
   static int field996;
   @ObfuscatedName("kc")
   static boolean field871;
   @ObfuscatedName("ka")
   static boolean field978;
   @ObfuscatedName("kz")
   @Export("numberMenuOptions")
   static boolean numberMenuOptions;
   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field1000;
   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field1064;
   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   static Widget field1002;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -482455775
   )
   static int field889;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -231618739
   )
   static int field943;

   static {
      field1099 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field853 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = -1L;
      field1016 = -1;
      field966 = -1;
      field858 = -1;
      field859 = true;
      displayFps = false;
      field861 = 0;
      hintArrowTargetType = 0;
      hintArrowNpcTargetIdx = 0;
      hintArrowPlayerTargetIdx = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      hintArrowOffsetX = 0;
      hintArrowOffsetY = 0;
      playerAttackOption = AttackOption.AttackOption_hidden;
      npcAttackOption = AttackOption.AttackOption_hidden;
      loadingStage = 0;
      js5State = 0;
      field874 = 0;
      field875 = 0;
      loginState = 0;
      field1013 = 0;
      field1004 = 0;
      field879 = 0;
      field1063 = class150.field2091;
      field1034 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      signlink = new NetWriter();
      field881 = 0;
      socketError = false;
      field891 = true;
      field892 = new class287();
      fontsMap = new HashMap();
      field895 = 0;
      field896 = 1;
      field897 = 0;
      field898 = 1;
      field899 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field902 = new int[4][13][13];
      field903 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field847 = 0;
      field905 = 2301979;
      field906 = 5063219;
      field907 = 3353893;
      field908 = 7759444;
      field909 = false;
      field856 = 0;
      field998 = 128;
      mapAngle = 0;
      field987 = 0;
      field901 = 0;
      field915 = 0;
      field916 = 0;
      field1014 = 50;
      field1021 = 0;
      field919 = false;
      field920 = 0;
      field921 = 0;
      field1100 = 50;
      field923 = new int[field1100];
      field924 = new int[field1100];
      field925 = new int[field1100];
      field926 = new int[field1100];
      field927 = new int[field1100];
      field900 = new int[field1100];
      field929 = new int[field1100];
      field997 = new String[field1100];
      field931 = new int[104][104];
      field932 = 0;
      screenY = -1;
      screenX = -1;
      field1003 = 0;
      field936 = 0;
      field1092 = 0;
      cursorState = 0;
      mouseCrosshair = 0;
      field940 = 0;
      field1073 = 0;
      field857 = 0;
      field1039 = 0;
      field935 = 0;
      field945 = false;
      field1082 = 0;
      field947 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field918 = 0;
      localNpcsCount = 0;
      npcIndicesPendingRemoval = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field956 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field957 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field965 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field975 = false;
      field976 = false;
      field964 = -1;
      field882 = -1;
      field979 = 0;
      field980 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field984 = -1;
      field985 = -1;
      field986 = null;
      field910 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field990 = 0;
      field991 = 0;
      field958 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field996 = -1;
      field871 = false;
      field978 = false;
      numberMenuOptions = false;
      field1000 = null;
      field1064 = null;
      field1002 = null;
      field889 = 0;
      field943 = 0;
      field1005 = null;
      field992 = false;
      field1007 = -1;
      field950 = -1;
      field1009 = false;
      field1010 = -1;
      field1011 = -1;
      field1012 = false;
      cycleCntr = 1;
      field988 = new int[32];
      field1015 = 0;
      interfaceItemTriggers = new int[32];
      field1017 = 0;
      field1018 = new int[32];
      field922 = 0;
      chatCycle = 0;
      field1041 = 0;
      field1022 = 0;
      field1050 = 0;
      field1024 = 0;
      field1025 = 0;
      mouseWheelRotation = 0;
      field1027 = new Deque();
      field1028 = new Deque();
      field1029 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field1032 = -2;
      field1033 = new boolean[100];
      field1019 = new boolean[100];
      field970 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field942 = 0L;
      isResized = true;
      field1043 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field1087 = 0;
      field1046 = "";
      field1047 = new long[100];
      field1048 = 0;
      field1049 = 0;
      field1085 = new int[128];
      field1051 = new int[128];
      field1052 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1055 = -1;
      field1056 = 0;
      field914 = new int[1000];
      field1058 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1062 = 0;
      field845 = 255;
      field850 = -1;
      field1008 = false;
      field1066 = 127;
      field1067 = 127;
      field1068 = 0;
      field1069 = new int[50];
      field1070 = new int[50];
      field1071 = new int[50];
      field1072 = new int[50];
      audioEffects = new SoundEffect[50];
      field930 = false;
      field1075 = new boolean[5];
      field1076 = new int[5];
      field1077 = new int[5];
      field1078 = new int[5];
      field1079 = new int[5];
      field1080 = 256;
      field1081 = 205;
      field878 = 256;
      field1083 = 320;
      field1084 = 1;
      field867 = 32767;
      field1086 = 1;
      field1006 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1094 = 0;
      friends = new Friend[400];
      field1096 = new LinkDeque();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1090 = new PlayerComposition();
      field1045 = -1;
      field1101 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1103 = new OwnWorldComparator();
      field1104 = new class72();
      field1105 = new int[50];
      field1106 = new int[50];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-531735453"
   )
   protected final void vmethod1131() {
      field942 = Preferences.currentTimeMs() + 500L;
      this.method1322();
      if(widgetRoot != -1) {
         this.method1380(true);
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-990310815"
   )
   @Export("setUp")
   protected final void setUp() {
      class23.method172(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      GraphicsObject.port1 = socketType == 0?43594:world + 40000;
      FileOnDisk.port2 = socketType == 0?443:world + 50000;
      class268.myWorldPort = GraphicsObject.port1;
      FrameMap.colorsToFind = class225.field2743;
      PlayerComposition.colorsToReplace = class225.field2740;
      BoundingBox3D.field245 = class225.field2741;
      PlayerComposition.field2735 = class225.field2742;
      DState.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      WorldComparator.mouseWheel = this.mouseWheel();
      class56.indexStore255 = new IndexFile(255, class157.dat2File, class157.idx255File, 500000);
      class2.preferences = WidgetNode.method1045();
      this.setUpClipboard();
      String var2 = GameEngine.field656;
      class56.field622 = this;
      class56.field621 = var2;
      if(socketType != 0) {
         displayFps = true;
      }

      class35.method494(class2.preferences.screenType);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "972327216"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();

      while(true) {
         Deque var2 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         FileSystem var1;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var1 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
         }

         if(var1 == null) {
            int var45;
            try {
               if(class214.field2620 == 1) {
                  var45 = class282.field3753.method3844();
                  if(var45 > 0 && class282.field3753.method3903()) {
                     var45 -= Timer.field2159;
                     if(var45 < 0) {
                        var45 = 0;
                     }

                     class282.field3753.method3843(var45);
                  } else {
                     class282.field3753.method3849();
                     class282.field3753.method3847();
                     if(class214.field2623 != null) {
                        class214.field2620 = 2;
                     } else {
                        class214.field2620 = 0;
                     }

                     class214.field2622 = null;
                     class214.field2627 = null;
                  }
               }
            } catch (Exception var62) {
               var62.printStackTrace();
               class282.field3753.method3849();
               class214.field2620 = 0;
               class214.field2622 = null;
               class214.field2627 = null;
               class214.field2623 = null;
            }

            NPC.method1648();
            KeyFocusListener var63 = KeyFocusListener.keyboard;
            int var46;
            synchronized(KeyFocusListener.keyboard) {
               ++KeyFocusListener.keyboardIdleTicks;
               KeyFocusListener.field602 = KeyFocusListener.field604;
               KeyFocusListener.field601 = 0;
               if(KeyFocusListener.field597 >= 0) {
                  while(KeyFocusListener.field597 != KeyFocusListener.field596) {
                     var46 = KeyFocusListener.field607[KeyFocusListener.field596];
                     KeyFocusListener.field596 = KeyFocusListener.field596 + 1 & 127;
                     if(var46 < 0) {
                        KeyFocusListener.field593[~var46] = false;
                     } else {
                        if(!KeyFocusListener.field593[var46] && KeyFocusListener.field601 < KeyFocusListener.field600.length - 1) {
                           KeyFocusListener.field600[++KeyFocusListener.field601 - 1] = var46;
                        }

                        KeyFocusListener.field593[var46] = true;
                     }
                  }
               } else {
                  for(var46 = 0; var46 < 112; ++var46) {
                     KeyFocusListener.field593[var46] = false;
                  }

                  KeyFocusListener.field597 = KeyFocusListener.field596;
               }

               if(KeyFocusListener.field601 > 0) {
                  KeyFocusListener.keyboardIdleTicks = 0;
               }

               KeyFocusListener.field604 = KeyFocusListener.field590;
            }

            Timer.method3079();
            if(WorldComparator.mouseWheel != null) {
               var45 = WorldComparator.mouseWheel.useRotation();
               mouseWheelRotation = var45;
            }

            if(gameState == 0) {
               class27.load();
               LoginPacket.timer.vmethod3074();

               for(var45 = 0; var45 < 32; ++var45) {
                  GameEngine.field633[var45] = 0L;
               }

               for(var45 = 0; var45 < 32; ++var45) {
                  GameEngine.field662[var45] = 0L;
               }

               class225.field2739 = 0;
            } else if(gameState == 5) {
               class192.method3596(this);
               class27.load();
               LoginPacket.timer.vmethod3074();

               for(var45 = 0; var45 < 32; ++var45) {
                  GameEngine.field633[var45] = 0L;
               }

               for(var45 = 0; var45 < 32; ++var45) {
                  GameEngine.field662[var45] = 0L;
               }

               class225.field2739 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class192.method3596(this);
                  this.method1337();
               } else if(gameState == 25) {
                  class139.flush(false);
                  field895 = 0;
                  boolean var73 = true;

                  for(var46 = 0; var46 < ClanMember.field842.length; ++var46) {
                     if(class91.landMapFileIds[var46] != -1 && ClanMember.field842[var46] == null) {
                        ClanMember.field842[var46] = SceneComposition.indexMaps.getConfigData(class91.landMapFileIds[var46], 0);
                        if(ClanMember.field842[var46] == null) {
                           var73 = false;
                           ++field895;
                        }
                     }

                     if(GraphicsObject.landRegionFileIds[var46] != -1 && WorldMapType3.field365[var46] == null) {
                        WorldMapType3.field365[var46] = SceneComposition.indexMaps.getConfigData(GraphicsObject.landRegionFileIds[var46], 0, class21.xteaKeys[var46]);
                        if(WorldMapType3.field365[var46] == null) {
                           var73 = false;
                           ++field895;
                        }
                     }
                  }

                  if(!var73) {
                     field899 = 1;
                  } else {
                     field897 = 0;
                     var73 = true;

                     int var5;
                     Buffer var9;
                     int var10;
                     int var11;
                     int var12;
                     int var14;
                     int var15;
                     int var16;
                     int var17;
                     int var18;
                     int var19;
                     int var47;
                     for(var46 = 0; var46 < ClanMember.field842.length; ++var46) {
                        byte[] var3 = WorldMapType3.field365[var46];
                        if(var3 != null) {
                           var47 = (class64.mapRegions[var46] >> 8) * 64 - SceneChunkMetadata.baseX;
                           var5 = (class64.mapRegions[var46] & 255) * 64 - baseY;
                           if(isDynamicRegion) {
                              var47 = 10;
                              var5 = 10;
                           }

                           boolean var8 = true;
                           var9 = new Buffer(var3);
                           var10 = -1;

                           label1460:
                           while(true) {
                              var11 = var9.getUSmart();
                              if(var11 == 0) {
                                 var73 &= var8;
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;
                              boolean var13 = false;

                              while(true) {
                                 while(!var13) {
                                    var14 = var9.getUSmart();
                                    if(var14 == 0) {
                                       continue label1460;
                                    }

                                    var12 += var14 - 1;
                                    var15 = var12 & 63;
                                    var16 = var12 >> 6 & 63;
                                    var17 = var9.readUnsignedByte() >> 2;
                                    var18 = var47 + var16;
                                    var19 = var5 + var15;
                                    if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                       ObjectComposition var20 = CacheFile.getObjectDefinition(var10);
                                       if(var17 != 22 || !lowMemory || var20.int1 != 0 || var20.interactType == 1 || var20.boolean2) {
                                          if(!var20.method4663()) {
                                             ++field897;
                                             var8 = false;
                                          }

                                          var13 = true;
                                       }
                                    }
                                 }

                                 var14 = var9.getUSmart();
                                 if(var14 == 0) {
                                    break;
                                 }

                                 var9.readUnsignedByte();
                              }
                           }
                        }
                     }

                     if(!var73) {
                        field899 = 2;
                     } else {
                        if(field899 != 0) {
                           class185.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        NPC.method1648();
                        class5.method16();
                        NPC.method1648();
                        class48.region.reset();
                        NPC.method1648();
                        System.gc();

                        for(var46 = 0; var46 < 4; ++var46) {
                           collisionMaps[var46].reset();
                        }

                        int var48;
                        for(var46 = 0; var46 < 4; ++var46) {
                           for(var48 = 0; var48 < 104; ++var48) {
                              for(var47 = 0; var47 < 104; ++var47) {
                                 class61.tileSettings[var46][var48][var47] = 0;
                              }
                           }
                        }

                        NPC.method1648();
                        SocketSession2.method3072();
                        var46 = ClanMember.field842.length;
                        class27.method218();
                        class139.flush(true);
                        int var6;
                        int var21;
                        int var22;
                        int var52;
                        int var68;
                        if(!isDynamicRegion) {
                           byte[] var49;
                           for(var48 = 0; var48 < var46; ++var48) {
                              var47 = (class64.mapRegions[var48] >> 8) * 64 - SceneChunkMetadata.baseX;
                              var5 = (class64.mapRegions[var48] & 255) * 64 - baseY;
                              var49 = ClanMember.field842[var48];
                              if(var49 != null) {
                                 NPC.method1648();
                                 class87.method1662(var49, var47, var5, class2.field13 * 8 - 48, Frames.field2030 * 8 - 48, collisionMaps);
                              }
                           }

                           for(var48 = 0; var48 < var46; ++var48) {
                              var47 = (class64.mapRegions[var48] >> 8) * 64 - SceneChunkMetadata.baseX;
                              var5 = (class64.mapRegions[var48] & 255) * 64 - baseY;
                              var49 = ClanMember.field842[var48];
                              if(var49 == null && Frames.field2030 < 800) {
                                 NPC.method1648();
                                 class236.method4216(var47, var5, 64, 64);
                              }
                           }

                           class139.flush(true);

                           for(var48 = 0; var48 < var46; ++var48) {
                              byte[] var4 = WorldMapType3.field365[var48];
                              if(var4 != null) {
                                 var5 = (class64.mapRegions[var48] >> 8) * 64 - SceneChunkMetadata.baseX;
                                 var6 = (class64.mapRegions[var48] & 255) * 64 - baseY;
                                 NPC.method1648();
                                 Region var50 = class48.region;
                                 CollisionData[] var51 = collisionMaps;
                                 var9 = new Buffer(var4);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var9.getUSmart();
                                    if(var11 == 0) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var68 = var9.getUSmart();
                                       if(var68 == 0) {
                                          break;
                                       }

                                       var12 += var68 - 1;
                                       var14 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       var17 = var9.readUnsignedByte();
                                       var18 = var17 >> 2;
                                       var19 = var17 & 3;
                                       var52 = var5 + var15;
                                       var21 = var6 + var14;
                                       if(var52 > 0 && var21 > 0 && var52 < 103 && var21 < 103) {
                                          var22 = var16;
                                          if((class61.tileSettings[1][var52][var21] & 2) == 2) {
                                             var22 = var16 - 1;
                                          }

                                          CollisionData var23 = null;
                                          if(var22 >= 0) {
                                             var23 = var51[var22];
                                          }

                                          FriendLoginUpdate.addObject(var16, var52, var21, var10, var19, var18, var50, var23);
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        int var7;
                        int var27;
                        int var28;
                        int var29;
                        int var30;
                        int var53;
                        int var56;
                        int var67;
                        if(isDynamicRegion) {
                           var48 = 0;

                           label1365:
                           while(true) {
                              if(var48 >= 4) {
                                 for(var48 = 0; var48 < 13; ++var48) {
                                    for(var47 = 0; var47 < 13; ++var47) {
                                       var5 = field902[0][var48][var47];
                                       if(var5 == -1) {
                                          class236.method4216(var48 * 8, var47 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 class139.flush(true);
                                 var48 = 0;

                                 while(true) {
                                    if(var48 >= 4) {
                                       break label1365;
                                    }

                                    NPC.method1648();

                                    for(var47 = 0; var47 < 13; ++var47) {
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var6 = field902[var48][var47][var5];
                                          if(var6 != -1) {
                                             var7 = var6 >> 24 & 3;
                                             var67 = var6 >> 1 & 3;
                                             var53 = var6 >> 14 & 1023;
                                             var10 = var6 >> 3 & 2047;
                                             var11 = (var53 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < class64.mapRegions.length; ++var12) {
                                                if(class64.mapRegions[var12] == var11 && WorldMapType3.field365[var12] != null) {
                                                   class213.method3832(WorldMapType3.field365[var12], var48, var47 * 8, var5 * 8, var7, (var53 & 7) * 8, (var10 & 7) * 8, var67, class48.region, collisionMaps);
                                                   break;
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var48;
                                 }
                              }

                              NPC.method1648();

                              for(var47 = 0; var47 < 13; ++var47) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var66 = false;
                                    var7 = field902[var48][var47][var5];
                                    if(var7 != -1) {
                                       var67 = var7 >> 24 & 3;
                                       var53 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var68 = 0; var68 < class64.mapRegions.length; ++var68) {
                                          if(class64.mapRegions[var68] == var12 && ClanMember.field842[var68] != null) {
                                             byte[] var54 = ClanMember.field842[var68];
                                             var15 = var47 * 8;
                                             var16 = var5 * 8;
                                             var17 = (var10 & 7) * 8;
                                             var18 = (var11 & 7) * 8;
                                             CollisionData[] var55 = collisionMaps;

                                             for(var52 = 0; var52 < 8; ++var52) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var52 + var15 > 0 && var52 + var15 < 103 && var21 + var16 > 0 && var16 + var21 < 103) {
                                                      var55[var48].flags[var15 + var52][var21 + var16] &= -16777217;
                                                   }
                                                }
                                             }

                                             Buffer var69 = new Buffer(var54);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(var56 = 0; var56 < 64; ++var56) {
                                                      if(var67 == var21 && var22 >= var17 && var22 < var17 + 8 && var56 >= var18 && var56 < var18 + 8) {
                                                         var28 = var22 & 7;
                                                         var29 = var56 & 7;
                                                         var30 = var53 & 3;
                                                         if(var30 == 0) {
                                                            var27 = var28;
                                                         } else if(var30 == 1) {
                                                            var27 = var29;
                                                         } else if(var30 == 2) {
                                                            var27 = 7 - var28;
                                                         } else {
                                                            var27 = 7 - var29;
                                                         }

                                                         AttackOption.loadTerrain(var69, var48, var15 + var27, var16 + Friend.method1037(var22 & 7, var56 & 7, var53), 0, 0, var53);
                                                      } else {
                                                         AttackOption.loadTerrain(var69, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var66 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var66) {
                                       var67 = var48;
                                       var53 = var47 * 8;
                                       var10 = var5 * 8;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class61.tileHeights[var67][var53 + var11][var12 + var10] = 0;
                                          }
                                       }

                                       if(var53 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class61.tileHeights[var67][var53][var11 + var10] = class61.tileHeights[var67][var53 - 1][var10 + var11];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class61.tileHeights[var67][var11 + var53][var10] = class61.tileHeights[var67][var53 + var11][var10 - 1];
                                          }
                                       }

                                       if(var53 > 0 && class61.tileHeights[var67][var53 - 1][var10] != 0) {
                                          class61.tileHeights[var67][var53][var10] = class61.tileHeights[var67][var53 - 1][var10];
                                       } else if(var10 > 0 && class61.tileHeights[var67][var53][var10 - 1] != 0) {
                                          class61.tileHeights[var67][var53][var10] = class61.tileHeights[var67][var53][var10 - 1];
                                       } else if(var53 > 0 && var10 > 0 && class61.tileHeights[var67][var53 - 1][var10 - 1] != 0) {
                                          class61.tileHeights[var67][var53][var10] = class61.tileHeights[var67][var53 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var48;
                           }
                        }

                        class139.flush(true);
                        class5.method16();
                        NPC.method1648();
                        Region var64 = class48.region;
                        CollisionData[] var65 = collisionMaps;

                        for(var5 = 0; var5 < 4; ++var5) {
                           for(var6 = 0; var6 < 104; ++var6) {
                              for(var7 = 0; var7 < 104; ++var7) {
                                 if((class61.tileSettings[var5][var6][var7] & 1) == 1) {
                                    var67 = var5;
                                    if((class61.tileSettings[1][var6][var7] & 2) == 2) {
                                       var67 = var5 - 1;
                                    }

                                    if(var67 >= 0) {
                                       var65[var67].method3132(var6, var7);
                                    }
                                 }
                              }
                           }
                        }

                        class61.field707 += (int)(Math.random() * 5.0D) - 2;
                        if(class61.field707 < -8) {
                           class61.field707 = -8;
                        }

                        if(class61.field707 > 8) {
                           class61.field707 = 8;
                        }

                        class61.field708 += (int)(Math.random() * 5.0D) - 2;
                        if(class61.field708 < -16) {
                           class61.field708 = -16;
                        }

                        if(class61.field708 > 16) {
                           class61.field708 = 16;
                        }

                        for(var5 = 0; var5 < 4; ++var5) {
                           byte[][] var74 = class96.field1418[var5];
                           var12 = (int)Math.sqrt(5100.0D);
                           var68 = var12 * 768 >> 8;

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var16 = class61.tileHeights[var5][var15 + 1][var14] - class61.tileHeights[var5][var15 - 1][var14];
                                 var17 = class61.tileHeights[var5][var15][var14 + 1] - class61.tileHeights[var5][var15][var14 - 1];
                                 var18 = (int)Math.sqrt((double)(var16 * var16 + var17 * var17 + 65536));
                                 var19 = (var16 << 8) / var18;
                                 var52 = 65536 / var18;
                                 var21 = (var17 << 8) / var18;
                                 var22 = (var21 * -50 + var19 * -50 + var52 * -10) / var68 + 96;
                                 var56 = (var74[var15][var14 + 1] >> 3) + (var74[var15 - 1][var14] >> 2) + (var74[var15][var14 - 1] >> 2) + (var74[var15 + 1][var14] >> 3) + (var74[var15][var14] >> 1);
                                 class61.field696[var15][var14] = var22 - var56;
                              }
                           }

                           for(var14 = 0; var14 < 104; ++var14) {
                              class61.field697[var14] = 0;
                              class61.field698[var14] = 0;
                              class20.field310[var14] = 0;
                              class61.field699[var14] = 0;
                              BaseVarType.field28[var14] = 0;
                           }

                           for(var14 = -5; var14 < 109; ++var14) {
                              for(var15 = 0; var15 < 104; ++var15) {
                                 var16 = var14 + 5;
                                 if(var16 >= 0 && var16 < 104) {
                                    var17 = class61.field693[var5][var16][var15] & 255;
                                    if(var17 > 0) {
                                       FloorUnderlayDefinition var57 = class225.getUnderlayDefinition(var17 - 1);
                                       class61.field697[var15] += var57.hue;
                                       class61.field698[var15] += var57.saturation;
                                       class20.field310[var15] += var57.lightness;
                                       class61.field699[var15] += var57.hueMultiplier;
                                       ++BaseVarType.field28[var15];
                                    }
                                 }

                                 var17 = var14 - 5;
                                 if(var17 >= 0 && var17 < 104) {
                                    var18 = class61.field693[var5][var17][var15] & 255;
                                    if(var18 > 0) {
                                       FloorUnderlayDefinition var77 = class225.getUnderlayDefinition(var18 - 1);
                                       class61.field697[var15] -= var77.hue;
                                       class61.field698[var15] -= var77.saturation;
                                       class20.field310[var15] -= var77.lightness;
                                       class61.field699[var15] -= var77.hueMultiplier;
                                       --BaseVarType.field28[var15];
                                    }
                                 }
                              }

                              if(var14 >= 1 && var14 < 103) {
                                 var15 = 0;
                                 var16 = 0;
                                 var17 = 0;
                                 var18 = 0;
                                 var19 = 0;

                                 for(var52 = -5; var52 < 109; ++var52) {
                                    var21 = var52 + 5;
                                    if(var21 >= 0 && var21 < 104) {
                                       var15 += class61.field697[var21];
                                       var16 += class61.field698[var21];
                                       var17 += class20.field310[var21];
                                       var18 += class61.field699[var21];
                                       var19 += BaseVarType.field28[var21];
                                    }

                                    var22 = var52 - 5;
                                    if(var22 >= 0 && var22 < 104) {
                                       var15 -= class61.field697[var22];
                                       var16 -= class61.field698[var22];
                                       var17 -= class20.field310[var22];
                                       var18 -= class61.field699[var22];
                                       var19 -= BaseVarType.field28[var22];
                                    }

                                    if(var52 >= 1 && var52 < 103 && (!lowMemory || (class61.tileSettings[0][var14][var52] & 2) != 0 || (class61.tileSettings[var5][var14][var52] & 16) == 0)) {
                                       if(var5 < class61.field694) {
                                          class61.field694 = var5;
                                       }

                                       var56 = class61.field693[var5][var14][var52] & 255;
                                       int var58 = UrlRequest.field2083[var5][var14][var52] & 255;
                                       if(var56 > 0 || var58 > 0) {
                                          int var25 = class61.tileHeights[var5][var14][var52];
                                          int var26 = class61.tileHeights[var5][var14 + 1][var52];
                                          var27 = class61.tileHeights[var5][var14 + 1][var52 + 1];
                                          var28 = class61.tileHeights[var5][var14][var52 + 1];
                                          var29 = class61.field696[var14][var52];
                                          var30 = class61.field696[var14 + 1][var52];
                                          int var31 = class61.field696[var14 + 1][var52 + 1];
                                          int var32 = class61.field696[var14][var52 + 1];
                                          int var33 = -1;
                                          int var34 = -1;
                                          int var35;
                                          int var36;
                                          if(var56 > 0) {
                                             var35 = var15 * 256 / var18;
                                             var36 = var16 / var19;
                                             int var37 = var17 / var19;
                                             var33 = Player.method1100(var35, var36, var37);
                                             var35 = var35 + class61.field707 & 255;
                                             var37 += class61.field708;
                                             if(var37 < 0) {
                                                var37 = 0;
                                             } else if(var37 > 255) {
                                                var37 = 255;
                                             }

                                             var34 = Player.method1100(var35, var36, var37);
                                          }

                                          if(var5 > 0) {
                                             boolean var71 = true;
                                             if(var56 == 0 && class168.field2226[var5][var14][var52] != 0) {
                                                var71 = false;
                                             }

                                             if(var58 > 0 && !Varcs.getOverlayDefinition(var58 - 1).isHidden) {
                                                var71 = false;
                                             }

                                             if(var71 && var25 == var26 && var27 == var25 && var25 == var28) {
                                                TextureProvider.field1667[var5][var14][var52] |= 2340;
                                             }
                                          }

                                          var35 = 0;
                                          if(var34 != -1) {
                                             var35 = Graphics3D.colorPalette[CombatInfo1.method1490(var34, 96)];
                                          }

                                          if(var58 == 0) {
                                             var64.addTile(var5, var14, var52, 0, 0, -1, var25, var26, var27, var28, CombatInfo1.method1490(var33, var29), CombatInfo1.method1490(var33, var30), CombatInfo1.method1490(var33, var31), CombatInfo1.method1490(var33, var32), 0, 0, 0, 0, var35, 0);
                                          } else {
                                             var36 = class168.field2226[var5][var14][var52] + 1;
                                             byte var72 = SceneMapObject.field413[var5][var14][var52];
                                             Overlay var38 = Varcs.getOverlayDefinition(var58 - 1);
                                             int var39 = var38.texture;
                                             int var40;
                                             int var41;
                                             int var42;
                                             int var43;
                                             if(var39 >= 0) {
                                                var41 = Graphics3D.textureLoader.getAverageTextureRGB(var39);
                                                var40 = -1;
                                             } else if(var38.color == 16711935) {
                                                var40 = -2;
                                                var39 = -1;
                                                var41 = -2;
                                             } else {
                                                var40 = Player.method1100(var38.hue, var38.saturation, var38.lightness);
                                                var42 = var38.hue + class61.field707 & 255;
                                                var43 = var38.lightness + class61.field708;
                                                if(var43 < 0) {
                                                   var43 = 0;
                                                } else if(var43 > 255) {
                                                   var43 = 255;
                                                }

                                                var41 = Player.method1100(var42, var38.saturation, var43);
                                             }

                                             var42 = 0;
                                             if(var41 != -2) {
                                                var42 = Graphics3D.colorPalette[class167.adjustHSLListness0(var41, 96)];
                                             }

                                             if(var38.otherRgbColor != -1) {
                                                var43 = var38.otherHue + class61.field707 & 255;
                                                int var44 = var38.otherLightness + class61.field708;
                                                if(var44 < 0) {
                                                   var44 = 0;
                                                } else if(var44 > 255) {
                                                   var44 = 255;
                                                }

                                                var41 = Player.method1100(var43, var38.otherSaturation, var44);
                                                var42 = Graphics3D.colorPalette[class167.adjustHSLListness0(var41, 96)];
                                             }

                                             var64.addTile(var5, var14, var52, var36, var72, var39, var25, var26, var27, var28, CombatInfo1.method1490(var33, var29), CombatInfo1.method1490(var33, var30), CombatInfo1.method1490(var33, var31), CombatInfo1.method1490(var33, var32), class167.adjustHSLListness0(var40, var29), class167.adjustHSLListness0(var40, var30), class167.adjustHSLListness0(var40, var31), class167.adjustHSLListness0(var40, var32), var35, var42);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 if((class61.tileSettings[var5][var15][var14] & 8) != 0) {
                                    var52 = 0;
                                 } else if(var5 > 0 && (class61.tileSettings[1][var15][var14] & 2) != 0) {
                                    var52 = var5 - 1;
                                 } else {
                                    var52 = var5;
                                 }

                                 var64.setPhysicalLevel(var5, var15, var14, var52);
                              }
                           }

                           class61.field693[var5] = null;
                           UrlRequest.field2083[var5] = null;
                           class168.field2226[var5] = null;
                           SceneMapObject.field413[var5] = null;
                           class96.field1418[var5] = null;
                        }

                        var64.applyLighting(-50, -10, -50);

                        for(var5 = 0; var5 < 104; ++var5) {
                           for(var6 = 0; var6 < 104; ++var6) {
                              if((class61.tileSettings[1][var5][var6] & 2) == 2) {
                                 var64.setBridge(var5, var6);
                              }
                           }
                        }

                        var5 = 1;
                        var6 = 2;
                        var7 = 4;

                        for(var67 = 0; var67 < 4; ++var67) {
                           if(var67 > 0) {
                              var5 <<= 3;
                              var6 <<= 3;
                              var7 <<= 3;
                           }

                           for(var53 = 0; var53 <= var67; ++var53) {
                              for(var10 = 0; var10 <= 104; ++var10) {
                                 for(var11 = 0; var11 <= 104; ++var11) {
                                    short var70;
                                    if((TextureProvider.field1667[var53][var11][var10] & var5) != 0) {
                                       var12 = var10;
                                       var68 = var10;
                                       var14 = var53;

                                       for(var15 = var53; var12 > 0 && (TextureProvider.field1667[var53][var11][var12 - 1] & var5) != 0; --var12) {
                                          ;
                                       }

                                       while(var68 < 104 && (TextureProvider.field1667[var53][var11][var68 + 1] & var5) != 0) {
                                          ++var68;
                                       }

                                       label982:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var68; ++var16) {
                                             if((TextureProvider.field1667[var14 - 1][var11][var16] & var5) == 0) {
                                                break label982;
                                             }
                                          }

                                          --var14;
                                       }

                                       label971:
                                       while(var15 < var67) {
                                          for(var16 = var12; var16 <= var68; ++var16) {
                                             if((TextureProvider.field1667[var15 + 1][var11][var16] & var5) == 0) {
                                                break label971;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var68 - var12 + 1) * (var15 + 1 - var14);
                                       if(var16 >= 8) {
                                          var70 = 240;
                                          var18 = class61.tileHeights[var15][var11][var12] - var70;
                                          var19 = class61.tileHeights[var14][var11][var12];
                                          Region.addOcclude(var67, 1, var11 * 128, var11 * 128, var12 * 128, var68 * 128 + 128, var18, var19);

                                          for(var52 = var14; var52 <= var15; ++var52) {
                                             for(var21 = var12; var21 <= var68; ++var21) {
                                                TextureProvider.field1667[var52][var11][var21] &= ~var5;
                                             }
                                          }
                                       }
                                    }

                                    if((TextureProvider.field1667[var53][var11][var10] & var6) != 0) {
                                       var12 = var11;
                                       var68 = var11;
                                       var14 = var53;

                                       for(var15 = var53; var12 > 0 && (TextureProvider.field1667[var53][var12 - 1][var10] & var6) != 0; --var12) {
                                          ;
                                       }

                                       while(var68 < 104 && (TextureProvider.field1667[var53][var68 + 1][var10] & var6) != 0) {
                                          ++var68;
                                       }

                                       label1035:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var68; ++var16) {
                                             if((TextureProvider.field1667[var14 - 1][var16][var10] & var6) == 0) {
                                                break label1035;
                                             }
                                          }

                                          --var14;
                                       }

                                       label1024:
                                       while(var15 < var67) {
                                          for(var16 = var12; var16 <= var68; ++var16) {
                                             if((TextureProvider.field1667[var15 + 1][var16][var10] & var6) == 0) {
                                                break label1024;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var68 - var12 + 1) * (var15 + 1 - var14);
                                       if(var16 >= 8) {
                                          var70 = 240;
                                          var18 = class61.tileHeights[var15][var12][var10] - var70;
                                          var19 = class61.tileHeights[var14][var12][var10];
                                          Region.addOcclude(var67, 2, var12 * 128, var68 * 128 + 128, var10 * 128, var10 * 128, var18, var19);

                                          for(var52 = var14; var52 <= var15; ++var52) {
                                             for(var21 = var12; var21 <= var68; ++var21) {
                                                TextureProvider.field1667[var52][var21][var10] &= ~var6;
                                             }
                                          }
                                       }
                                    }

                                    if((TextureProvider.field1667[var53][var11][var10] & var7) != 0) {
                                       var12 = var11;
                                       var68 = var11;
                                       var14 = var10;

                                       for(var15 = var10; var14 > 0 && (TextureProvider.field1667[var53][var11][var14 - 1] & var7) != 0; --var14) {
                                          ;
                                       }

                                       while(var15 < 104 && (TextureProvider.field1667[var53][var11][var15 + 1] & var7) != 0) {
                                          ++var15;
                                       }

                                       label1088:
                                       while(var12 > 0) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if((TextureProvider.field1667[var53][var12 - 1][var16] & var7) == 0) {
                                                break label1088;
                                             }
                                          }

                                          --var12;
                                       }

                                       label1077:
                                       while(var68 < 104) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if((TextureProvider.field1667[var53][var68 + 1][var16] & var7) == 0) {
                                                break label1077;
                                             }
                                          }

                                          ++var68;
                                       }

                                       if((var15 - var14 + 1) * (var68 - var12 + 1) >= 4) {
                                          var16 = class61.tileHeights[var53][var12][var14];
                                          Region.addOcclude(var67, 4, var12 * 128, var68 * 128 + 128, var14 * 128, var15 * 128 + 128, var16, var16);

                                          for(var17 = var12; var17 <= var68; ++var17) {
                                             for(var18 = var14; var18 <= var15; ++var18) {
                                                TextureProvider.field1667[var53][var17][var18] &= ~var7;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        class139.flush(true);
                        var5 = class61.field694;
                        if(var5 > BoundingBox2D.plane) {
                           var5 = BoundingBox2D.plane;
                        }

                        if(var5 < BoundingBox2D.plane - 1) {
                           var5 = BoundingBox2D.plane - 1;
                        }

                        if(lowMemory) {
                           class48.region.setup(class61.field694);
                        } else {
                           class48.region.setup(0);
                        }

                        for(var6 = 0; var6 < 104; ++var6) {
                           for(var7 = 0; var7 < 104; ++var7) {
                              Player.groundItemSpawned(var6, var7);
                           }
                        }

                        NPC.method1648();

                        for(PendingSpawn var75 = (PendingSpawn)pendingSpawns.getFront(); var75 != null; var75 = (PendingSpawn)pendingSpawns.getNext()) {
                           if(var75.hitpoints == -1) {
                              var75.delay = 0;
                              AreaMapIconMetadata.method546(var75);
                           } else {
                              var75.unlink();
                           }
                        }

                        ObjectComposition.field3512.reset();
                        PacketNode var76;
                        if(TotalQuantityComparator.clientInstance.method840()) {
                           var76 = FileSystem.bufferForSize(ClientPacket.field2332, signlink.field1449);
                           var76.packetBuffer.putInt(1057001181);
                           signlink.method1862(var76);
                        }

                        if(!isDynamicRegion) {
                           var6 = (class2.field13 - 6) / 8;
                           var7 = (class2.field13 + 6) / 8;
                           var67 = (Frames.field2030 - 6) / 8;
                           var53 = (Frames.field2030 + 6) / 8;

                           for(var10 = var6 - 1; var10 <= var7 + 1; ++var10) {
                              for(var11 = var67 - 1; var11 <= var53 + 1; ++var11) {
                                 if(var10 < var6 || var10 > var7 || var11 < var67 || var11 > var53) {
                                    SceneComposition.indexMaps.method4277("m" + var10 + "_" + var11);
                                    SceneComposition.indexMaps.method4277("l" + var10 + "_" + var11);
                                 }
                              }
                           }
                        }

                        Friend.setGameState(30);
                        NPC.method1648();
                        class61.field693 = null;
                        UrlRequest.field2083 = null;
                        class168.field2226 = null;
                        SceneMapObject.field413 = null;
                        TextureProvider.field1667 = null;
                        class96.field1418 = null;
                        class61.field696 = null;
                        class61.field697 = null;
                        class61.field698 = null;
                        class20.field310 = null;
                        class61.field699 = null;
                        BaseVarType.field28 = null;
                        var76 = FileSystem.bufferForSize(ClientPacket.field2378, signlink.field1449);
                        signlink.method1862(var76);
                        LoginPacket.timer.vmethod3074();

                        for(var7 = 0; var7 < 32; ++var7) {
                           GameEngine.field633[var7] = 0L;
                        }

                        for(var7 = 0; var7 < 32; ++var7) {
                           GameEngine.field662[var7] = 0L;
                        }

                        class225.field2739 = 0;
                     }
                  }
               }
            } else {
               class192.method3596(this);
            }

            if(gameState == 30) {
               this.method1130();
            } else if(gameState == 40 || gameState == 45) {
               this.method1337();
            }

            return;
         }

         var1.data.load(var1.index, (int)var1.hash, var1.field3299, false);
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-910850089"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2 = PlayerComposition.method4105();
      if(var2 && field1008 && class36.soundSystem0 != null) {
         class36.soundSystem0.tryFlush();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && field942 != 0L && Preferences.currentTimeMs() > field942) {
         var3 = isResized?2:1;
         class35.method494(var3);
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1033[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class91.loadingBarPercentage, class91.loadingText, var1);
      } else if(gameState == 5) {
         class43.drawLoginScreen(Friend.fontBold12, class56.fontPlain11, BaseVarType.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class43.drawLoginScreen(Friend.fontBold12, class56.fontPlain11, BaseVarType.font_p12full, var1);
         } else if(gameState == 25) {
            if(field899 == 1) {
               if(field895 > field896) {
                  field896 = field895;
               }

               var3 = (field896 * 50 - field895 * 50) / field896;
               class185.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field899 == 2) {
               if(field897 > field898) {
                  field898 = field897;
               }

               var3 = (field898 * 50 - field897 * 50) / field898 + 50;
               class185.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               class185.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1133();
         } else if(gameState == 40) {
            class185.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class185.drawStatusBox("Please wait...", false);
         }
      } else {
         class43.drawLoginScreen(Friend.fontBold12, class56.fontPlain11, BaseVarType.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < widgetCount; ++var3) {
            if(field1019[var3]) {
               ScriptState.rasterProvider.draw(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field1019[var3] = false;
            }
         }
      } else if(gameState > 0) {
         ScriptState.rasterProvider.drawFull(0, 0);

         for(var3 = 0; var3 < widgetCount; ++var3) {
            field1019[var3] = false;
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   protected final void vmethod1125() {
      if(NetWriter.chatMessages.changed()) {
         NetWriter.chatMessages.serialize();
      }

      if(WorldMapMappings.mouseRecorder != null) {
         WorldMapMappings.mouseRecorder.isRunning = false;
      }

      WorldMapMappings.mouseRecorder = null;
      signlink.close();
      class179.removeKeyboardFocusListener();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      WorldComparator.mouseWheel = null;
      if(class36.soundSystem0 != null) {
         class36.soundSystem0.shutdown();
      }

      if(VertexNormal.soundSystem1 != null) {
         VertexNormal.soundSystem1.shutdown();
      }

      WorldMapType3.method208();
      Object var7 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3328 != 0) {
            IndexStoreActionHandler.field3328 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      if(DState.urlRequester != null) {
         DState.urlRequester.close();
         DState.urlRequester = null;
      }

      class34.method436();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2033473326"
   )
   protected final void vmethod1278() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = new Parameters[]{Parameters.field3783, Parameters.field3780, Parameters.field3779, Parameters.field3776, Parameters.field3785, Parameters.field3778, Parameters.field3786, Parameters.field3784, Parameters.field3789, Parameters.field3774, Parameters.field3777, Parameters.field3775, Parameters.field3788, Parameters.field3782, Parameters.field3787, Parameters.field3781};
         Parameters[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            Parameters var4 = var2[var3];
            String var5 = this.getParameter(var4.key);
            if(var5 != null) {
               switch(Integer.parseInt(var4.key)) {
               case 1:
                  field891 = Integer.parseInt(var5) != 0;
                  break;
               case 2:
                  field1107 = var5;
                  break;
               case 3:
                  socketType = Integer.parseInt(var5);
               case 4:
               case 9:
               case 10:
               default:
                  break;
               case 5:
                  BaseVarType.field31 = Integer.parseInt(var5);
                  break;
               case 6:
                  languageId = Integer.parseInt(var5);
                  break;
               case 7:
                  flags = Integer.parseInt(var5);
                  break;
               case 8:
                  world = Integer.parseInt(var5);
                  break;
               case 11:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 12:
                  WorldMapType1.field399 = Integer.parseInt(var5);
                  break;
               case 13:
                  IndexFile.field2175 = class34.method470(Integer.parseInt(var5));
                  break;
               case 14:
                  MilliTimer.sessionToken = var5;
                  break;
               case 15:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 16:
                  ItemContainer.field721 = (JagexGame)class91.forOrdinal(class60.method980(), Integer.parseInt(var5));
                  if(ItemContainer.field721 == JagexGame.field3289) {
                     PendingSpawn.jagexLoginType = JagexLoginType.field3931;
                  } else {
                     PendingSpawn.jagexLoginType = JagexLoginType.field3929;
                  }
               }
            }
         }

         Region.lowMemory = false;
         lowMemory = false;
         class11.host = this.getCodeBase().getHost();
         String var9 = IndexFile.field2175.identifier;
         byte var6 = 0;

         try {
            UrlRequester.method2917("oldschool", var9, var6, 17);
         } catch (Exception var8) {
            PendingSpawn.method1461((String)null, var8);
         }

         TotalQuantityComparator.clientInstance = this;
         this.initialize(765, 503, 160);
      }
   }

   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = JagexGame.method4243();
         if(!var1) {
            this.method1409();
         }

      }
   }

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2102776636"
   )
   void method1409() {
      if(class249.field3345 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class249.field3360 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field874 = 3000;
            class249.field3360 = 3;
         }

         if(--field874 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class175.socket = GameEngine.taskManager.createSocket(class11.host, class268.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class175.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class175.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field891) {
                     class3.rssocket = WorldMapData.method342((Socket)class175.socket.value, 40000, 5000);
                  } else {
                     class3.rssocket = new SocketSession((Socket)class175.socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(160);
                  class3.rssocket.vmethod3082(var1.payload, 0, 5);
                  ++js5State;
                  class3.field19 = Preferences.currentTimeMs();
               }

               if(js5State == 3) {
                  if(class3.rssocket.readable() > 0 || !field891 && gameState <= 5) {
                     int var5 = class3.rssocket.read();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  } else if(Preferences.currentTimeMs() - class3.field19 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  AbstractSocket var10 = class3.rssocket;
                  boolean var2 = gameState > 20;
                  if(class249.NetCache_socket != null) {
                     try {
                        class249.NetCache_socket.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class249.NetCache_socket = null;
                  }

                  class249.NetCache_socket = var10;
                  class27.sendConInfo(var2);
                  class249.NetCache_responseHeaderBuffer.offset = 0;
                  class61.currentRequest = null;
                  class287.NetCache_responseArchiveBuffer = null;
                  class249.field3356 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class249.NetCache_pendingPriorityResponses.first();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class249.NetCache_pendingResponses.first();
                           if(var3 == null) {
                              if(class249.field3358 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class249.field3358);
                                    var11.putShort(0);
                                    class249.NetCache_socket.vmethod3082(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class249.NetCache_socket.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class249.field3360;
                                    class249.NetCache_socket = null;
                                 }
                              }

                              class249.field3344 = 0;
                              class188.field2539 = Preferences.currentTimeMs();
                              class175.socket = null;
                              class3.rssocket = null;
                              js5State = 0;
                              field875 = 0;
                              return;
                           }

                           class249.NetCache_pendingWritesQueue.setHead(var3);
                           class249.NetCache_pendingWrites.put(var3, var3.hash);
                           ++class249.NetCache_pendingWritesCount;
                           --class249.NetCache_pendingResponsesCount;
                        }
                     }

                     class249.NetCache_pendingPriorityWrites.put(var3, var3.hash);
                     ++class249.NetCache_pendingPriorityWritesCount;
                     --class249.NetCache_pendingPriorityResponsesCount;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1701997282"
   )
   @Export("error")
   void error(int var1) {
      class175.socket = null;
      class3.rssocket = null;
      js5State = 0;
      if(class268.myWorldPort == GraphicsObject.port1) {
         class268.myWorldPort = FileOnDisk.port2;
      } else {
         class268.myWorldPort = GraphicsObject.port1;
      }

      ++field875;
      if(field875 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field874 = 3000;
         }
      } else if(field875 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field875 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field874 = 3000;
         }
      }

   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   final void method1337() {
      Object var1 = signlink.getSocket();
      PacketBuffer var2 = signlink.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((AbstractSocket)var1).close();
               var1 = null;
            }

            MapAreaMetadata.field560 = null;
            socketError = false;
            field1013 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(MapAreaMetadata.field560 == null) {
               MapAreaMetadata.field560 = GameEngine.taskManager.createSocket(class11.host, class268.myWorldPort);
            }

            if(MapAreaMetadata.field560.status == 2) {
               throw new IOException();
            }

            if(MapAreaMetadata.field560.status == 1) {
               if(field891) {
                  var1 = WorldMapData.method342((Socket) MapAreaMetadata.field560.value, 40000, 5000);
               } else {
                  var1 = new SocketSession((Socket) MapAreaMetadata.field560.value, GameEngine.taskManager, 5000);
               }

               signlink.setSocket((AbstractSocket)var1);
               MapAreaMetadata.field560 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            signlink.method1866();
            PacketNode var4 = SocketSession2.cachedOrNewPacketNode();
            var4.clientPacket = null;
            var4.field2432 = 0;
            var4.packetBuffer = new PacketBuffer(5000);
            var4.packetBuffer.putByte(LoginPacket.field2411.id);
            signlink.method1862(var4);
            signlink.method1861();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var14;
         int var15;
         if(loginState == 3) {
            if(class36.soundSystem0 != null) {
               class36.soundSystem0.method2004();
            }

            if(VertexNormal.soundSystem1 != null) {
               VertexNormal.soundSystem1.method2004();
            }

            var14 = true;
            if(field891 && !((AbstractSocket)var1).available(1)) {
               var14 = false;
            }

            if(var14) {
               var15 = ((AbstractSocket)var1).read();
               if(class36.soundSystem0 != null) {
                  class36.soundSystem0.method2004();
               }

               if(VertexNormal.soundSystem1 != null) {
                  VertexNormal.soundSystem1.method2004();
               }

               if(var15 != 0) {
                  class96.method1815(var15);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var35;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var35 = ((AbstractSocket)var1).readable();
               if(var35 > 8 - var2.offset) {
                  var35 = 8 - var2.offset;
               }

               if(var35 > 0) {
                  ((AbstractSocket)var1).vmethod3085(var2.payload, var2.offset, var35);
                  var2.offset += var35;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               class61.field709 = var2.readLong();
               loginState = 5;
            }
         }

         int var7;
         int var9;
         int var16;
         if(loginState == 5) {
            signlink.packetBuffer.offset = 0;
            signlink.method1866();
            PacketBuffer var3 = new PacketBuffer(500);
            int[] var27 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class61.field709 >> 32), (int)(class61.field709 & -1L)};
            var3.offset = 0;
            var3.putByte(1);
            var3.putByte(field1063.rsOrdinal());
            var3.putInt(var27[0]);
            var3.putInt(var27[1]);
            var3.putInt(var27[2]);
            var3.putInt(var27[3]);
            int var11;
            switch(field1063.field2093) {
            case 0:
            case 1:
               var3.put24bitInt(BoundingBox.field240);
               var3.offset += 5;
               break;
            case 2:
               var3.offset += 8;
               break;
            case 3:
               LinkedHashMap var6 = class2.preferences.preferences;
               String var8 = class91.username;
               var9 = var8.length();
               int var10 = 0;

               for(var11 = 0; var11 < var9; ++var11) {
                  var10 = (var10 << 5) - var10 + var8.charAt(var11);
               }

               var3.putInt(((Integer)var6.get(Integer.valueOf(var10))).intValue());
               var3.offset += 4;
            }

            var3.putString(class91.password);
            var3.encryptRsa(class89.field1303, class89.field1301);
            PacketNode var32 = SocketSession2.cachedOrNewPacketNode();
            var32.clientPacket = null;
            var32.field2432 = 0;
            var32.packetBuffer = new PacketBuffer(5000);
            var32.packetBuffer.offset = 0;
            if(gameState == 40) {
               var32.packetBuffer.putByte(LoginPacket.field2413.id);
            } else {
               var32.packetBuffer.putByte(LoginPacket.field2416.id);
            }

            var32.packetBuffer.putShort(0);
            var7 = var32.packetBuffer.offset;
            var32.packetBuffer.putInt(160);
            var32.packetBuffer.putBytes(var3.payload, 0, var3.offset);
            var16 = var32.packetBuffer.offset;
            var32.packetBuffer.putString(class91.username);
            var32.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var32.packetBuffer.putShort(Huffman.canvasWidth);
            var32.packetBuffer.putShort(VertexNormal.canvasHeight);
            PacketBuffer var17 = var32.packetBuffer;
            if(field1034 != null) {
               var17.putBytes(field1034, 0, field1034.length);
            } else {
               byte[] var18 = new byte[24];

               try {
                  class157.randomDat.seek(0L);
                  class157.randomDat.read(var18);

                  int var12;
                  for(var12 = 0; var12 < 24 && var18[var12] == 0; ++var12) {
                     ;
                  }

                  if(var12 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var23) {
                  for(int var13 = 0; var13 < 24; ++var13) {
                     var18[var13] = -1;
                  }
               }

               var17.putBytes(var18, 0, var18.length);
            }

            var32.packetBuffer.putString(MilliTimer.sessionToken);
            var32.packetBuffer.putInt(BaseVarType.field31);
            Buffer var20 = new Buffer(class48.platformInfo.method5531());
            class48.platformInfo.method5532(var20);
            var32.packetBuffer.putBytes(var20.payload, 0, var20.payload.length);
            var32.packetBuffer.putByte(WorldMapType1.field399);
            var32.packetBuffer.putInt(0);
            var32.packetBuffer.putInt(BoundingBox.indexInterfaces.crc);
            var32.packetBuffer.putInt(FrameMap.indexSoundEffects.crc);
            var32.packetBuffer.putInt(Fonts.configsIndex.crc);
            var32.packetBuffer.putInt(MouseInput.indexCache3.crc);
            var32.packetBuffer.putInt(class86.indexCache4.crc);
            var32.packetBuffer.putInt(SceneComposition.indexMaps.crc);
            var32.packetBuffer.putInt(class29.indexTrack1.crc);
            var32.packetBuffer.putInt(class37.indexModels.crc);
            var32.packetBuffer.putInt(class43.indexSprites.crc);
            var32.packetBuffer.putInt(class3.indexTextures.crc);
            var32.packetBuffer.putInt(class36.indexCache10.crc);
            var32.packetBuffer.putInt(class20.indexTrack2.crc);
            var32.packetBuffer.putInt(SocketSession2.indexScripts.crc);
            var32.packetBuffer.putInt(Preferences.indexCache13.crc);
            var32.packetBuffer.putInt(class231.vorbisIndex.crc);
            var32.packetBuffer.putInt(FontName.indexCache15.crc);
            var32.packetBuffer.putInt(FriendLoginUpdate.indexWorldMap.crc);
            var32.packetBuffer.encryptXtea(var27, var16, var32.packetBuffer.offset);
            var32.packetBuffer.method3257(var32.packetBuffer.offset - var7);
            signlink.method1862(var32);
            signlink.method1861();
            signlink.field1449 = new ISAACCipher(var27);

            for(var11 = 0; var11 < 4; ++var11) {
               var27[var11] += 50;
            }

            var2.seed(var27);
            loginState = 6;
         }

         if(loginState == 6 && ((AbstractSocket)var1).readable() > 0) {
            var35 = ((AbstractSocket)var1).read();
            if(var35 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var35 == 2) {
               loginState = 9;
            } else if(var35 == 15 && gameState == 40) {
               signlink.packetLength = -1;
               loginState = 13;
            } else if(var35 == 23 && field1004 < 1) {
               ++field1004;
               loginState = 0;
            } else {
               if(var35 != 29) {
                  class96.method1815(var35);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((AbstractSocket)var1).readable() > 0) {
            field879 = (((AbstractSocket)var1).read() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field1013 = 0;
            class64.method1033("You have only just left another world.", "Your profile will be transferred in:", field879 / 60 + " seconds.");
            if(--field879 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && ((AbstractSocket)var1).readable() >= 13) {
               var14 = ((AbstractSocket)var1).read() == 1;
               ((AbstractSocket)var1).vmethod3085(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var36 = false;
               if(var14) {
                  var15 = var2.readOpcode() << 24;
                  var15 |= var2.readOpcode() << 16;
                  var15 |= var2.readOpcode() << 8;
                  var15 |= var2.readOpcode();
                  String var33 = class91.username;
                  var7 = var33.length();
                  var16 = 0;
                  var9 = 0;

                  while(true) {
                     if(var9 >= var7) {
                        if(class2.preferences.preferences.size() >= 10 && !class2.preferences.preferences.containsKey(Integer.valueOf(var16))) {
                           Iterator var34 = class2.preferences.preferences.entrySet().iterator();
                           var34.next();
                           var34.remove();
                        }

                        class2.preferences.preferences.put(Integer.valueOf(var16), Integer.valueOf(var15));
                        break;
                     }

                     var16 = (var16 << 5) - var16 + var33.charAt(var9);
                     ++var9;
                  }
               }

               if(class91.Login_isUsernameRemembered) {
                  class2.preferences.rememberedUsername = class91.username;
               } else {
                  class2.preferences.rememberedUsername = null;
               }

               WorldComparator.method63();
               rights = ((AbstractSocket)var1).read();
               field871 = ((AbstractSocket)var1).read() == 1;
               localInteractingIndex = ((AbstractSocket)var1).read();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((AbstractSocket)var1).read();
               field918 = ((AbstractSocket)var1).read();
               ((AbstractSocket)var1).vmethod3085(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = new ServerPacket[]{ServerPacket.field2255, ServerPacket.field2229, ServerPacket.field2230, ServerPacket.field2231, ServerPacket.field2263, ServerPacket.field2233, ServerPacket.field2300, ServerPacket.field2235, ServerPacket.field2241, ServerPacket.field2237, ServerPacket.field2238, ServerPacket.field2239, ServerPacket.field2240, ServerPacket.field2302, ServerPacket.field2242, ServerPacket.field2257, ServerPacket.field2244, ServerPacket.field2245, ServerPacket.field2249, ServerPacket.field2247, ServerPacket.field2248, ServerPacket.field2296, ServerPacket.field2250, ServerPacket.field2251, ServerPacket.field2252, ServerPacket.field2253, ServerPacket.field2299, ServerPacket.field2258, ServerPacket.field2256, ServerPacket.field2228, ServerPacket.field2282, ServerPacket.field2259, ServerPacket.field2301, ServerPacket.field2261, ServerPacket.field2254, ServerPacket.field2236, ServerPacket.field2264, ServerPacket.field2265, ServerPacket.field2266, ServerPacket.field2306, ServerPacket.field2246, ServerPacket.field2269, ServerPacket.field2232, ServerPacket.field2271, ServerPacket.field2272, ServerPacket.field2273, ServerPacket.field2274, ServerPacket.field2275, ServerPacket.field2268, ServerPacket.field2277, ServerPacket.field2262, ServerPacket.field2279, ServerPacket.field2280, ServerPacket.field2281, ServerPacket.field2289, ServerPacket.field2283, ServerPacket.field2284, ServerPacket.field2285, ServerPacket.field2286, ServerPacket.field2287, ServerPacket.field2234, ServerPacket.field2295, ServerPacket.field2290, ServerPacket.field2291, ServerPacket.field2292, ServerPacket.field2243, ServerPacket.field2278, ServerPacket.field2288, ServerPacket.field2267, ServerPacket.field2297, ServerPacket.field2298, ServerPacket.field2276, ServerPacket.field2270, ServerPacket.field2304, ServerPacket.field2309, ServerPacket.field2303, ServerPacket.field2293, ServerPacket.field2305, ServerPacket.field2260, ServerPacket.field2294, ServerPacket.field2308};
               var7 = var2.readShortOpcode();
               if(var7 < 0 || var7 >= var5.length) {
                  throw new IOException(var7 + " " + var2.offset);
               }

               signlink.serverPacket = var5[var7];
               signlink.packetLength = signlink.serverPacket.packetLength;
               ((AbstractSocket)var1).vmethod3085(var2.payload, 0, 2);
               var2.offset = 0;
               signlink.packetLength = var2.readUnsignedShort();

               try {
                  class52.method755(TotalQuantityComparator.clientInstance, "zap");
               } catch (Throwable var22) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((AbstractSocket)var1).readable() >= signlink.packetLength) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).vmethod3085(var2.payload, 0, signlink.packetLength);
                  field892.method5032();
                  mouseLastLastPressedTimeMillis = -1L;
                  field858 = -1;
                  WorldMapMappings.mouseRecorder.index = 0;
                  class238.field3251 = true;
                  field859 = true;
                  field1052 = -1L;
                  ObjectComposition.method4706();
                  signlink.method1866();
                  signlink.packetBuffer.offset = 0;
                  signlink.serverPacket = null;
                  signlink.previousSecondPacket = null;
                  signlink.previousThirdPacket = null;
                  signlink.previousForthPacket = null;
                  signlink.packetLength = 0;
                  signlink.field1453 = 0;
                  field861 = 0;
                  field881 = 0;
                  hintArrowTargetType = 0;
                  class41.method574();
                  MouseInput.mouseIdleTicks = 0;
                  GrandExchangeOffer.method112();
                  itemSelectionState = 0;
                  spellSelected = false;
                  field1068 = 0;
                  mapAngle = 0;
                  field1062 = 0;
                  field1055 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  playerAttackOption = AttackOption.AttackOption_hidden;
                  npcAttackOption = AttackOption.AttackOption_hidden;
                  npcIndexesCount = 0;
                  OwnWorldComparator.method1114();

                  for(var35 = 0; var35 < 2048; ++var35) {
                     cachedPlayers[var35] = null;
                  }

                  for(var35 = 0; var35 < 32768; ++var35) {
                     cachedNPCs[var35] = null;
                  }

                  field957 = -1;
                  projectiles.clear();
                  graphicsObjectDeque.clear();

                  for(var35 = 0; var35 < 4; ++var35) {
                     for(var15 = 0; var15 < 104; ++var15) {
                        for(int var21 = 0; var21 < 104; ++var21) {
                           groundItemDeque[var35][var15][var21] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  field1094 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var35 = 0; var35 < Frames.field2028; ++var35) {
                     VarPlayerType var29 = class25.method182(var35);
                     if(var29 != null) {
                        class222.settings[var35] = 0;
                        class222.widgetSettings[var35] = 0;
                     }
                  }

                  NetWriter.chatMessages.reset();
                  field996 = -1;
                  if(widgetRoot != -1) {
                     Varbit.method4570(widgetRoot);
                  }

                  for(WidgetNode var26 = (WidgetNode)componentTable.first(); var26 != null; var26 = (WidgetNode)componentTable.next()) {
                     FriendLoginUpdate.method1042(var26, true);
                  }

                  widgetRoot = -1;
                  componentTable = new HashTable(8);
                  field958 = null;
                  class41.method574();
                  field1090.method4104((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var35 = 0; var35 < 8; ++var35) {
                     playerOptions[var35] = null;
                     playerOptionsPriorities[var35] = false;
                  }

                  ItemContainer.itemContainers = new HashTable(32);
                  field853 = true;

                  for(var35 = 0; var35 < 100; ++var35) {
                     field1033[var35] = true;
                  }

                  Ignore.method1058();
                  clanChatOwner = null;
                  class192.clanChatCount = 0;
                  GameEngine.clanMembers = null;

                  for(var35 = 0; var35 < 8; ++var35) {
                     grandExchangeOffers[var35] = new GrandExchangeOffer();
                  }

                  class56.grandExchangeEvents = null;
                  CombatInfo1.initializeGPI(var2);
                  class2.field13 = -1;
                  class56.xteaChanged(false, var2);
                  signlink.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((AbstractSocket)var1).readable() >= 2) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).vmethod3085(var2.payload, 0, 2);
                  var2.offset = 0;
                  class167.field2222 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((AbstractSocket)var1).readable() >= class167.field2222) {
                  var2.offset = 0;
                  ((AbstractSocket)var1).vmethod3085(var2.payload, 0, class167.field2222);
                  var2.offset = 0;
                  String var25 = var2.readString();
                  String var28 = var2.readString();
                  String var30 = var2.readString();
                  class64.method1033(var25, var28, var30);
                  Friend.setGameState(10);
               }

               if(loginState != 13) {
                  ++field1013;
                  if(field1013 > 2000) {
                     if(field1004 < 1) {
                        if(class268.myWorldPort == GraphicsObject.port1) {
                           class268.myWorldPort = FileOnDisk.port2;
                        } else {
                           class268.myWorldPort = GraphicsObject.port1;
                        }

                        ++field1004;
                        loginState = 0;
                     } else {
                        class96.method1815(-3);
                     }
                  }
               } else {
                  if(signlink.packetLength == -1) {
                     if(((AbstractSocket)var1).readable() < 2) {
                        return;
                     }

                     ((AbstractSocket)var1).vmethod3085(var2.payload, 0, 2);
                     var2.offset = 0;
                     signlink.packetLength = var2.readUnsignedShort();
                  }

                  if(((AbstractSocket)var1).readable() >= signlink.packetLength) {
                     ((AbstractSocket)var1).vmethod3085(var2.payload, 0, signlink.packetLength);
                     var2.offset = 0;
                     var35 = signlink.packetLength;
                     field892.method5044();
                     signlink.method1866();
                     signlink.packetBuffer.offset = 0;
                     signlink.serverPacket = null;
                     signlink.previousSecondPacket = null;
                     signlink.previousThirdPacket = null;
                     signlink.previousForthPacket = null;
                     signlink.packetLength = 0;
                     signlink.field1453 = 0;
                     field861 = 0;
                     class41.method574();
                     field1062 = 0;
                     destinationX = 0;

                     for(var15 = 0; var15 < 2048; ++var15) {
                        cachedPlayers[var15] = null;
                     }

                     UrlRequest.localPlayer = null;

                     for(var15 = 0; var15 < cachedNPCs.length; ++var15) {
                        NPC var31 = cachedNPCs[var15];
                        if(var31 != null) {
                           var31.interacting = -1;
                           var31.field1149 = false;
                        }
                     }

                     ItemContainer.itemContainers = new HashTable(32);
                     Friend.setGameState(30);

                     for(var15 = 0; var15 < 100; ++var15) {
                        field1033[var15] = true;
                     }

                     Ignore.method1058();
                     CombatInfo1.initializeGPI(var2);
                     if(var35 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var24) {
         if(field1004 < 1) {
            if(GraphicsObject.port1 == class268.myWorldPort) {
               class268.myWorldPort = FileOnDisk.port2;
            } else {
               class268.myWorldPort = GraphicsObject.port1;
            }

            ++field1004;
            loginState = 0;
         } else {
            class96.method1815(-2);
         }
      }
   }

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1407728074"
   )
   final void method1130() {
      if(field861 > 1) {
         --field861;
      }

      if(field881 > 0) {
         --field881;
      }

      if(socketError) {
         socketError = false;
         TotalQuantityComparator.method85();
      } else {
         if(!isMenuOpen) {
            OwnWorldComparator.method1102();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.readPacket(signlink); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class293.classInfos.last();
               boolean var27;
               if(var2 == null) {
                  var27 = false;
               } else {
                  var27 = true;
               }

               int var3;
               PacketNode var28;
               if(!var27) {
                  PacketNode var12;
                  int var13;
                  if(field892.field3796) {
                     var12 = FileSystem.bufferForSize(ClientPacket.field2345, signlink.field1449);
                     var12.packetBuffer.putByte(0);
                     var13 = var12.packetBuffer.offset;
                     field892.method5056(var12.packetBuffer);
                     var12.packetBuffer.method3258(var12.packetBuffer.offset - var13);
                     signlink.method1862(var12);
                     field892.method5035();
                  }

                  Object var33 = WorldMapMappings.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  synchronized(WorldMapMappings.mouseRecorder.lock) {
                     if(!field1099) {
                        WorldMapMappings.mouseRecorder.index = 0;
                     } else if(MouseInput.mouseLastButton != 0 || WorldMapMappings.mouseRecorder.index >= 40) {
                        var28 = FileSystem.bufferForSize(ClientPacket.field2356, signlink.field1449);
                        var28.packetBuffer.putByte(0);
                        var3 = var28.packetBuffer.offset;
                        var4 = 0;

                        for(var5 = 0; var5 < WorldMapMappings.mouseRecorder.index && var28.packetBuffer.offset - var3 < 240; ++var5) {
                           ++var4;
                           var6 = WorldMapMappings.mouseRecorder.ys[var5];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 502) {
                              var6 = 502;
                           }

                           var7 = WorldMapMappings.mouseRecorder.xs[var5];
                           if(var7 < 0) {
                              var7 = 0;
                           } else if(var7 > 764) {
                              var7 = 764;
                           }

                           var8 = var7 + var6 * 765;
                           if(WorldMapMappings.mouseRecorder.ys[var5] == -1 && WorldMapMappings.mouseRecorder.xs[var5] == -1) {
                              var7 = -1;
                              var6 = -1;
                              var8 = 524287;
                           }

                           if(var7 == field1016 && var6 == field966) {
                              if(field858 < 2047) {
                                 ++field858;
                              }
                           } else {
                              var9 = var7 - field1016;
                              field1016 = var7;
                              int var10 = var6 - field966;
                              field966 = var6;
                              if(field858 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                                 var9 += 32;
                                 var10 += 32;
                                 var28.packetBuffer.putShort(var10 + (field858 << 12) + (var9 << 6));
                                 field858 = 0;
                              } else if(field858 < 8) {
                                 var28.packetBuffer.put24bitInt((field858 << 19) + var8 + 8388608);
                                 field858 = 0;
                              } else {
                                 var28.packetBuffer.putInt((field858 << 19) + var8 + -1073741824);
                                 field858 = 0;
                              }
                           }
                        }

                        var28.packetBuffer.method3258(var28.packetBuffer.offset - var3);
                        signlink.method1862(var28);
                        if(var4 >= WorldMapMappings.mouseRecorder.index) {
                           WorldMapMappings.mouseRecorder.index = 0;
                        } else {
                           WorldMapMappings.mouseRecorder.index -= var4;

                           for(var5 = 0; var5 < WorldMapMappings.mouseRecorder.index; ++var5) {
                              WorldMapMappings.mouseRecorder.xs[var5] = WorldMapMappings.mouseRecorder.xs[var4 + var5];
                              WorldMapMappings.mouseRecorder.ys[var5] = WorldMapMappings.mouseRecorder.ys[var4 + var5];
                           }
                        }
                     }
                  }

                  PacketNode var16;
                  if(MouseInput.mouseLastButton == 1 || !class34.field455 && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
                     long var14 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis) / 50L;
                     if(var14 > 4095L) {
                        var14 = 4095L;
                     }

                     mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis;
                     var3 = MouseInput.mouseLastPressedY;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > VertexNormal.canvasHeight) {
                        var3 = VertexNormal.canvasHeight;
                     }

                     var4 = MouseInput.mouseLastPressedX;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > Huffman.canvasWidth) {
                        var4 = Huffman.canvasWidth;
                     }

                     var5 = (int)var14;
                     var16 = FileSystem.bufferForSize(ClientPacket.field2358, signlink.field1449);
                     var16.packetBuffer.putShort((MouseInput.mouseLastButton == 2?1:0) + (var5 << 1));
                     var16.packetBuffer.putShort(var4);
                     var16.packetBuffer.putShort(var3);
                     signlink.method1862(var16);
                  }

                  if(KeyFocusListener.field601 > 0) {
                     var12 = FileSystem.bufferForSize(ClientPacket.field2333, signlink.field1449);
                     var12.packetBuffer.putShort(0);
                     var13 = var12.packetBuffer.offset;
                     long var17 = Preferences.currentTimeMs();

                     for(var5 = 0; var5 < KeyFocusListener.field601; ++var5) {
                        long var19 = var17 - field1052;
                        if(var19 > 16777215L) {
                           var19 = 16777215L;
                        }

                        field1052 = var17;
                        var12.packetBuffer.method3287(KeyFocusListener.field600[var5]);
                        var12.packetBuffer.method3302((int)var19);
                     }

                     var12.packetBuffer.method3257(var12.packetBuffer.offset - var13);
                     signlink.method1862(var12);
                  }

                  if(field1021 > 0) {
                     --field1021;
                  }

                  if(KeyFocusListener.field593[96] || KeyFocusListener.field593[97] || KeyFocusListener.field593[98] || KeyFocusListener.field593[99]) {
                     field919 = true;
                  }

                  if(field919 && field1021 <= 0) {
                     field1021 = 20;
                     field919 = false;
                     var12 = FileSystem.bufferForSize(ClientPacket.field2375, signlink.field1449);
                     var12.packetBuffer.putShortLE(mapAngle);
                     var12.packetBuffer.writeShortLE(field998);
                     signlink.method1862(var12);
                  }

                  if(class238.field3251 && !field859) {
                     field859 = true;
                     var12 = FileSystem.bufferForSize(ClientPacket.field2316, signlink.field1449);
                     var12.packetBuffer.putByte(1);
                     signlink.method1862(var12);
                  }

                  if(!class238.field3251 && field859) {
                     field859 = false;
                     var12 = FileSystem.bufferForSize(ClientPacket.field2316, signlink.field1449);
                     var12.packetBuffer.putByte(0);
                     signlink.method1862(var12);
                  }

                  CollisionData.method3133();
                  if(gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var34 = (PendingSpawn)pendingSpawns.getFront(); var34 != null; var34 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var34.hitpoints > 0) {
                        --var34.hitpoints;
                     }

                     if(var34.hitpoints == 0) {
                        if(var34.field1112 < 0 || AbstractScene.method242(var34.field1112, var34.field1114)) {
                           FontName.method4871(var34.level, var34.type, var34.x, var34.y, var34.field1112, var34.field1113, var34.field1114);
                           var34.unlink();
                        }
                     } else {
                        if(var34.delay > 0) {
                           --var34.delay;
                        }

                        if(var34.delay == 0 && var34.x >= 1 && var34.y >= 1 && var34.x <= 102 && var34.y <= 102 && (var34.id < 0 || AbstractScene.method242(var34.id, var34.field1117))) {
                           FontName.method4871(var34.level, var34.type, var34.x, var34.y, var34.id, var34.orientation, var34.field1117);
                           var34.delay = -1;
                           if(var34.id == var34.field1112 && var34.field1112 == -1) {
                              var34.unlink();
                           } else if(var34.id == var34.field1112 && var34.field1113 == var34.orientation && var34.field1114 == var34.field1117) {
                              var34.unlink();
                           }
                        }
                     }
                  }

                  for(var1 = 0; var1 < field1068; ++var1) {
                     --field1071[var1];
                     if(field1071[var1] >= -10) {
                        SoundEffect var29 = audioEffects[var1];
                        if(var29 == null) {
                           Object var10000 = null;
                           var29 = SoundEffect.getTrack(class86.indexCache4, field1069[var1], 0);
                           if(var29 == null) {
                              continue;
                           }

                           field1071[var1] += var29.calculateDelay();
                           audioEffects[var1] = var29;
                        }

                        if(field1071[var1] < 0) {
                           if(field1072[var1] != 0) {
                              var4 = (field1072[var1] & 255) * 128;
                              var5 = field1072[var1] >> 16 & 255;
                              var6 = var5 * 128 + 64 - UrlRequest.localPlayer.x;
                              if(var6 < 0) {
                                 var6 = -var6;
                              }

                              var7 = field1072[var1] >> 8 & 255;
                              var8 = var7 * 128 + 64 - UrlRequest.localPlayer.y;
                              if(var8 < 0) {
                                 var8 = -var8;
                              }

                              var9 = var6 + var8 - 128;
                              if(var9 > var4) {
                                 field1071[var1] = -100;
                                 continue;
                              }

                              if(var9 < 0) {
                                 var9 = 0;
                              }

                              var3 = (var4 - var9) * field1067 / var4;
                           } else {
                              var3 = field1066;
                           }

                           if(var3 > 0) {
                              MusicTrack2 var21 = var29.method1942().method1979(class34.field457);
                              SongMetadata var22 = SongMetadata.method2160(var21, 100, var3);
                              var22.method2114(field1070[var1] - 1);
                              class214.field2628.method1885(var22);
                           }

                           field1071[var1] = -100;
                        }
                     } else {
                        --field1068;

                        for(var13 = var1; var13 < field1068; ++var13) {
                           field1069[var13] = field1069[var13 + 1];
                           audioEffects[var13] = audioEffects[var13 + 1];
                           field1070[var13] = field1070[var13 + 1];
                           field1071[var13] = field1071[var13 + 1];
                           field1072[var13] = field1072[var13 + 1];
                        }

                        --var1;
                     }
                  }

                  if(field1008) {
                     if(class214.field2620 != 0) {
                        var27 = true;
                     } else {
                        var27 = class282.field3753.method3903();
                     }

                     if(!var27) {
                        if(field845 != 0 && field850 != -1) {
                           class2.method3(class29.indexTrack1, field850, 0, field845, false);
                        }

                        field1008 = false;
                     }
                  }

                  ++signlink.field1453;
                  if(signlink.field1453 > 750) {
                     TotalQuantityComparator.method85();
                     return;
                  }

                  Buffer.method3397();

                  for(var1 = 0; var1 < npcIndexesCount; ++var1) {
                     var13 = npcIndices[var1];
                     NPC var23 = cachedNPCs[var13];
                     if(var23 != null) {
                        WallObject.method2881(var23, var23.composition.field3620);
                     }
                  }

                  int[] var35 = class94.playerIndices;

                  for(var13 = 0; var13 < class94.playerIndexesCount; ++var13) {
                     Player var41 = cachedPlayers[var35[var13]];
                     if(var41 != null && var41.overheadTextCyclesRemaining > 0) {
                        --var41.overheadTextCyclesRemaining;
                        if(var41.overheadTextCyclesRemaining == 0) {
                           var41.overhead = null;
                        }
                     }
                  }

                  for(var13 = 0; var13 < npcIndexesCount; ++var13) {
                     var3 = npcIndices[var13];
                     NPC var38 = cachedNPCs[var3];
                     if(var38 != null && var38.overheadTextCyclesRemaining > 0) {
                        --var38.overheadTextCyclesRemaining;
                        if(var38.overheadTextCyclesRemaining == 0) {
                           var38.overhead = null;
                        }
                     }
                  }

                  ++field847;
                  if(cursorState != 0) {
                     field1092 += 20;
                     if(field1092 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(Friend.field742 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        class33.method344(Friend.field742);
                        Friend.field742 = null;
                     }
                  }

                  Widget var36 = class29.field391;
                  Widget var30 = ContextMenuRow.field1299;
                  class29.field391 = null;
                  ContextMenuRow.field1299 = null;
                  field1005 = null;
                  field1009 = false;
                  field992 = false;
                  field1049 = 0;

                  while(class230.method4200() && field1049 < 128) {
                     if(rights >= 2 && KeyFocusListener.field593[82] && FileRequest.field3304 == 66) {
                        String var43 = class5.method15();
                        TotalQuantityComparator.clientInstance.method884(var43);
                     } else {
                        field1051[field1049] = FileRequest.field3304;
                        field1085[field1049] = GameSocket.field2186;
                        ++field1049;
                     }
                  }

                  if(FriendLoginUpdate.method1041() && KeyFocusListener.field593[82] && KeyFocusListener.field593[81] && mouseWheelRotation != 0) {
                     var3 = UrlRequest.localPlayer.field821 - mouseWheelRotation;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > 3) {
                        var3 = 3;
                     }

                     if(var3 != UrlRequest.localPlayer.field821) {
                        FontName.method4873(UrlRequest.localPlayer.pathX[0] + SceneChunkMetadata.baseX, UrlRequest.localPlayer.pathY[0] + baseY, var3);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     DecorativeObject.method2907(widgetRoot, 0, 0, Huffman.canvasWidth, VertexNormal.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var39;
                     Widget var40;
                     ScriptEvent var44;
                     do {
                        var44 = (ScriptEvent)field1028.popFront();
                        if(var44 == null) {
                           while(true) {
                              do {
                                 var44 = (ScriptEvent)field1029.popFront();
                                 if(var44 == null) {
                                    while(true) {
                                       do {
                                          var44 = (ScriptEvent)field1027.popFront();
                                          if(var44 == null) {
                                             this.method1390();
                                             if(class61.renderOverview != null) {
                                                class61.renderOverview.method5349(BoundingBox2D.plane, (UrlRequest.localPlayer.x >> 7) + SceneChunkMetadata.baseX, (UrlRequest.localPlayer.y >> 7) + baseY, false);
                                                class61.renderOverview.method5346();
                                             }

                                             if(field1064 != null) {
                                                this.method1140();
                                             }

                                             if(AreaMapIconMetadata.field506 != null) {
                                                class33.method344(AreaMapIconMetadata.field506);
                                                ++field1082;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(field945) {
                                                      if(AreaMapIconMetadata.field506 == MapAreaMetadata.field566 && field935 != field1073) {
                                                         Widget var45 = AreaMapIconMetadata.field506;
                                                         byte var31 = 0;
                                                         if(field991 == 1 && var45.contentType == 206) {
                                                            var31 = 1;
                                                         }

                                                         if(var45.itemIds[field935] <= 0) {
                                                            var31 = 0;
                                                         }

                                                         var6 = class36.getWidgetConfig(var45);
                                                         boolean var32 = (var6 >> 29 & 1) != 0;
                                                         if(var32) {
                                                            var7 = field1073;
                                                            var8 = field935;
                                                            var45.itemIds[var8] = var45.itemIds[var7];
                                                            var45.itemQuantities[var8] = var45.itemQuantities[var7];
                                                            var45.itemIds[var7] = -1;
                                                            var45.itemQuantities[var7] = 0;
                                                         } else if(var31 == 1) {
                                                            var7 = field1073;
                                                            var8 = field935;

                                                            while(var8 != var7) {
                                                               if(var7 > var8) {
                                                                  var45.method4143(var7 - 1, var7);
                                                                  --var7;
                                                               } else if(var7 < var8) {
                                                                  var45.method4143(var7 + 1, var7);
                                                                  ++var7;
                                                               }
                                                            }
                                                         } else {
                                                            var45.method4143(field935, field1073);
                                                         }

                                                         PacketNode var24 = FileSystem.bufferForSize(ClientPacket.field2334, signlink.field1449);
                                                         var24.packetBuffer.method3285(var31);
                                                         var24.packetBuffer.writeIntLE16(field935);
                                                         var24.packetBuffer.method3311(AreaMapIconMetadata.field506.id);
                                                         var24.packetBuffer.writeIntLE16(field1073);
                                                         signlink.method1862(var24);
                                                      }
                                                   } else if(this.method1136()) {
                                                      this.openMenu(field857, field1039);
                                                   } else if(menuOptionCount > 0) {
                                                      WorldMapMappings.method628(field857, field1039);
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   AreaMapIconMetadata.field506 = null;
                                                } else if(field1082 >= 5 && (MouseInput.field679 > field857 + 5 || MouseInput.field679 < field857 - 5 || MouseInput.field682 * -469125321 > field1039 + 5 || MouseInput.field682 * -469125321 < field1039 - 5)) {
                                                   field945 = true;
                                                }
                                             }

                                             if(Region.method2729()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                PacketNode var42 = FileSystem.bufferForSize(ClientPacket.field2352, signlink.field1449);
                                                var42.packetBuffer.putByte(5);
                                                var42.packetBuffer.method3287(KeyFocusListener.field593[82]?(KeyFocusListener.field593[81]?2:1):0);
                                                var42.packetBuffer.writeIntLE16(var3 + SceneChunkMetadata.baseX);
                                                var42.packetBuffer.putShortLE(var4 + baseY);
                                                signlink.method1862(var42);
                                                Region.method2800();
                                                field1003 = MouseInput.mouseLastPressedX;
                                                field936 = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field1092 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var36 != class29.field391) {
                                                if(var36 != null) {
                                                   class33.method344(var36);
                                                }

                                                if(class29.field391 != null) {
                                                   class33.method344(class29.field391);
                                                }
                                             }

                                             if(var30 != ContextMenuRow.field1299 && field979 == field980) {
                                                if(var30 != null) {
                                                   class33.method344(var30);
                                                }

                                                if(ContextMenuRow.field1299 != null) {
                                                   class33.method344(ContextMenuRow.field1299);
                                                }
                                             }

                                             if(ContextMenuRow.field1299 != null) {
                                                if(field979 < field980) {
                                                   ++field979;
                                                   if(field979 == field980) {
                                                      class33.method344(ContextMenuRow.field1299);
                                                   }
                                                }
                                             } else if(field979 > 0) {
                                                --field979;
                                             }

                                             ItemContainer.method1031();
                                             if(field930) {
                                                class282.method5026();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1079[var3];
                                             }

                                             NetWriter.chatMessages.process();
                                             var3 = class20.method147();
                                             var4 = KeyFocusListener.keyboardIdleTicks;
                                             if(var3 > 15000 && var4 > 15000) {
                                                field881 = 250;
                                                MouseInput.mouseIdleTicks = 14500;
                                                var16 = FileSystem.bufferForSize(ClientPacket.field2357, signlink.field1449);
                                                signlink.method1862(var16);
                                             }

                                             for(FriendLoginUpdate var37 = (FriendLoginUpdate)field1096.method3791(); var37 != null; var37 = (FriendLoginUpdate)field1096.method3794()) {
                                                if((long)var37.field758 < Preferences.currentTimeMs() / 1000L - 5L) {
                                                   if(var37.field753 > 0) {
                                                      class25.sendGameMessage(5, "", var37.field752 + " has logged in.");
                                                   }

                                                   if(var37.field753 == 0) {
                                                      class25.sendGameMessage(5, "", var37.field752 + " has logged out.");
                                                   }

                                                   var37.remove();
                                                }
                                             }

                                             ++signlink.field1455;
                                             if(signlink.field1455 > 50) {
                                                var16 = FileSystem.bufferForSize(ClientPacket.field2328, signlink.field1449);
                                                signlink.method1862(var16);
                                             }

                                             try {
                                                signlink.method1861();
                                             } catch (IOException var25) {
                                                TotalQuantityComparator.method85();
                                             }

                                             return;
                                          }

                                          var39 = var44.widget;
                                          if(var39.index < 0) {
                                             break;
                                          }

                                          var40 = VertexNormal.getWidget(var39.parentId);
                                       } while(var40 == null || var40.children == null || var39.index >= var40.children.length || var39 != var40.children[var39.index]);

                                       CacheFile.method2350(var44);
                                    }
                                 }

                                 var39 = var44.widget;
                                 if(var39.index < 0) {
                                    break;
                                 }

                                 var40 = VertexNormal.getWidget(var39.parentId);
                              } while(var40 == null || var40.children == null || var39.index >= var40.children.length || var39 != var40.children[var39.index]);

                              CacheFile.method2350(var44);
                           }
                        }

                        var39 = var44.widget;
                        if(var39.index < 0) {
                           break;
                        }

                        var40 = VertexNormal.getWidget(var39.parentId);
                     } while(var40 == null || var40.children == null || var39.index >= var40.children.length || var39 != var40.children[var39.index]);

                     CacheFile.method2350(var44);
                  }
               }

               var28 = FileSystem.bufferForSize(ClientPacket.field2364, signlink.field1449);
               var28.packetBuffer.putByte(0);
               var3 = var28.packetBuffer.offset;
               SpritePixels2.encodeClassVerifier(var28.packetBuffer);
               var28.packetBuffer.method3258(var28.packetBuffer.offset - var3);
               signlink.method1862(var28);
            }
         }
      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1721167409"
   )
   void method1322() {
      int var1 = Huffman.canvasWidth;
      int var2 = VertexNormal.canvasHeight;
      if(super.field648 < var1) {
         var1 = super.field648;
      }

      if(super.field642 < var2) {
         var2 = super.field642;
      }

      if(class2.preferences != null) {
         try {
            Client var3 = TotalQuantityComparator.clientInstance;
            int var4 = isResized?2:1;
            Object[] var5 = new Object[]{Integer.valueOf(var4)};
            JSObject.getWindow(var3).call("resize", var5);
         } catch (Throwable var6) {
            ;
         }
      }

   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "82"
   )
   final void method1133() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(GraphicsObject.loadWidget(var1)) {
            AbstractSoundSystem.method2057(Widget.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field1033[var1]) {
            field1019[var1] = true;
         }

         field970[var1] = field1033[var1];
         field1033[var1] = false;
      }

      field1032 = gameCycle;
      field964 = -1;
      field882 = -1;
      MapAreaMetadata.field566 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         class61.method1018(widgetRoot, 0, 0, Huffman.canvasWidth, VertexNormal.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      int var4;
      int var7;
      int var8;
      int var13;
      if(!isMenuOpen) {
         if(field964 != -1) {
            var1 = field964;
            var2 = field882;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               var3 = menuOptionCount - 1;
               String var5;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var5 = "Use" + " " + lastSelectedItemName + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var5 = field986 + " " + field910 + " " + "->";
               } else {
                  String var6;
                  if(var3 < 0) {
                     var6 = "";
                  } else if(menuTargets[var3].length() > 0) {
                     var6 = menuOptions[var3] + " " + menuTargets[var3];
                  } else {
                     var6 = menuOptions[var3];
                  }

                  var5 = var6;
               }

               if(menuOptionCount > 2) {
                  var5 = var5 + Buffer.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               Friend.fontBold12.drawRandomizedMouseoverText(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         var1 = WorldMapType1.menuX;
         var2 = ClientPacket.menuY;
         var3 = Item.menuWidth;
         var4 = Size.menuHeight;
         int var12 = 6116423;
         Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var12);
         Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         Friend.fontBold12.method4891("Choose Option", var1 + 3, var2 + 14, var12, -1);
         var13 = MouseInput.field679;
         var7 = MouseInput.field682 * -469125321;

         for(var8 = 0; var8 < menuOptionCount; ++var8) {
            int var9 = (menuOptionCount - 1 - var8) * 15 + var2 + 31;
            int var10 = 16777215;
            if(var13 > var1 && var13 < var1 + var3 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            Friend.fontBold12.method4891(class5.method18(var8), var1 + 3, var9, var10, 0);
         }

         SoundEffectWorker.method2084(WorldMapType1.menuX, ClientPacket.menuY, Item.menuWidth, Size.menuHeight);
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field970[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1019[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = BoundingBox2D.plane;
      var2 = UrlRequest.localPlayer.x;
      var3 = UrlRequest.localPlayer.y;
      var4 = field847;

      for(GameObjectTransformMetadata var17 = (GameObjectTransformMetadata) GameObjectTransformMetadata.field1235.getFront(); var17 != null; var17 = (GameObjectTransformMetadata) GameObjectTransformMetadata.field1235.getNext()) {
         if(var17.field1228 != -1 || var17.field1226 != null) {
            var13 = 0;
            if(var2 > var17.field1232) {
               var13 += var2 - var17.field1232;
            } else if(var2 < var17.field1223) {
               var13 += var17.field1223 - var2;
            }

            if(var3 > var17.field1236) {
               var13 += var3 - var17.field1236;
            } else if(var3 < var17.field1224) {
               var13 += var17.field1224 - var3;
            }

            if(var13 - 64 <= var17.field1221 && field1067 != 0 && var1 == var17.field1225) {
               var13 -= 64;
               if(var13 < 0) {
                  var13 = 0;
               }

               var7 = (var17.field1221 - var13) * field1067 / var17.field1221;
               Object var10000;
               if(var17.field1229 == null) {
                  if(var17.field1228 >= 0) {
                     var10000 = null;
                     SoundEffect var14 = SoundEffect.getTrack(class86.indexCache4, var17.field1228, 0);
                     if(var14 != null) {
                        MusicTrack2 var15 = var14.method1942().method1979(class34.field457);
                        SongMetadata var16 = SongMetadata.method2160(var15, 100, var7);
                        var16.method2114(-1);
                        class214.field2628.method1885(var16);
                        var17.field1229 = var16;
                     }
                  }
               } else {
                  var17.field1229.method2173(var7);
               }

               if(var17.field1234 == null) {
                  if(var17.field1226 != null && (var17.field1233 -= var4) <= 0) {
                     var8 = (int)(Math.random() * (double)var17.field1226.length);
                     var10000 = null;
                     SoundEffect var18 = SoundEffect.getTrack(class86.indexCache4, var17.field1226[var8], 0);
                     if(var18 != null) {
                        MusicTrack2 var19 = var18.method1942().method1979(class34.field457);
                        SongMetadata var11 = SongMetadata.method2160(var19, 100, var7);
                        var11.method2114(0);
                        class214.field2628.method1885(var11);
                        var17.field1234 = var11;
                        var17.field1233 = var17.field1230 + (int)(Math.random() * (double)(var17.field1231 - var17.field1230));
                     }
                  }
               } else {
                  var17.field1234.method2173(var7);
                  if(!var17.field1234.linked()) {
                     var17.field1234 = null;
                  }
               }
            } else {
               if(var17.field1229 != null) {
                  class214.field2628.method1882(var17.field1229);
                  var17.field1229 = null;
               }

               if(var17.field1234 != null) {
                  class214.field2628.method1882(var17.field1234);
                  var17.field1234 = null;
               }
            }
         }
      }

      field847 = 0;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(Lcx;I)Z",
      garbageValue = "944549849"
   )
   @Export("readPacket")
   final boolean readPacket(NetWriter var1) {
      AbstractSocket var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         String var5;
         int var6;
         try {
            if(var1.serverPacket == null) {
               if(var1.field1446) {
                  if(!var2.available(1)) {
                     return false;
                  }

                  var2.vmethod3085(var1.packetBuffer.payload, 0, 1);
                  var1.field1453 = 0;
                  var1.field1446 = false;
               }

               var3.offset = 0;
               if(var3.method3567()) {
                  if(!var2.available(1)) {
                     return false;
                  }

                  var2.vmethod3085(var1.packetBuffer.payload, 1, 1);
                  var1.field1453 = 0;
               }

               var1.field1446 = true;
               ServerPacket[] var4 = new ServerPacket[]{ServerPacket.field2255, ServerPacket.field2229, ServerPacket.field2230, ServerPacket.field2231, ServerPacket.field2263, ServerPacket.field2233, ServerPacket.field2300, ServerPacket.field2235, ServerPacket.field2241, ServerPacket.field2237, ServerPacket.field2238, ServerPacket.field2239, ServerPacket.field2240, ServerPacket.field2302, ServerPacket.field2242, ServerPacket.field2257, ServerPacket.field2244, ServerPacket.field2245, ServerPacket.field2249, ServerPacket.field2247, ServerPacket.field2248, ServerPacket.field2296, ServerPacket.field2250, ServerPacket.field2251, ServerPacket.field2252, ServerPacket.field2253, ServerPacket.field2299, ServerPacket.field2258, ServerPacket.field2256, ServerPacket.field2228, ServerPacket.field2282, ServerPacket.field2259, ServerPacket.field2301, ServerPacket.field2261, ServerPacket.field2254, ServerPacket.field2236, ServerPacket.field2264, ServerPacket.field2265, ServerPacket.field2266, ServerPacket.field2306, ServerPacket.field2246, ServerPacket.field2269, ServerPacket.field2232, ServerPacket.field2271, ServerPacket.field2272, ServerPacket.field2273, ServerPacket.field2274, ServerPacket.field2275, ServerPacket.field2268, ServerPacket.field2277, ServerPacket.field2262, ServerPacket.field2279, ServerPacket.field2280, ServerPacket.field2281, ServerPacket.field2289, ServerPacket.field2283, ServerPacket.field2284, ServerPacket.field2285, ServerPacket.field2286, ServerPacket.field2287, ServerPacket.field2234, ServerPacket.field2295, ServerPacket.field2290, ServerPacket.field2291, ServerPacket.field2292, ServerPacket.field2243, ServerPacket.field2278, ServerPacket.field2288, ServerPacket.field2267, ServerPacket.field2297, ServerPacket.field2298, ServerPacket.field2276, ServerPacket.field2270, ServerPacket.field2304, ServerPacket.field2309, ServerPacket.field2303, ServerPacket.field2293, ServerPacket.field2305, ServerPacket.field2260, ServerPacket.field2294, ServerPacket.field2308};
               var6 = var3.readShortOpcode();
               if(var6 < 0 || var6 >= var4.length) {
                  throw new IOException(var6 + " " + var3.offset);
               }

               var1.serverPacket = var4[var6];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.available(1)) {
                  return false;
               }

               var1.getSocket().vmethod3085(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.available(2)) {
                  return false;
               }

               var1.getSocket().vmethod3085(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.available(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3085(var3.payload, 0, var1.packetLength);
            var1.field1453 = 0;
            field892.markTimeMs();
            var1.previousForthPacket = var1.previousThirdPacket;
            var1.previousThirdPacket = var1.previousSecondPacket;
            var1.previousSecondPacket = var1.serverPacket;
            if(ServerPacket.field2259 == var1.serverPacket) {
               Friend.otherPackets(class173.field2430);
               var1.serverPacket = null;
               return true;
            }

            int var23;
            if(ServerPacket.field2265 == var1.serverPacket) {
               field930 = false;

               for(var23 = 0; var23 < 5; ++var23) {
                  field1075[var23] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            int var24;
            Widget var25;
            if(ServerPacket.field2305 == var1.serverPacket) {
               var23 = var3.method3299();
               var24 = var3.readInt();
               var25 = VertexNormal.getWidget(var24);
               if(var25.modelType != 2 || var23 != var25.modelId) {
                  var25.modelType = 2;
                  var25.modelId = var23;
                  class33.method344(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2252 == var1.serverPacket) {
               Friend.otherPackets(class173.field2420);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2255 == var1.serverPacket) {
               Friend.otherPackets(class173.field2427);
               var1.serverPacket = null;
               return true;
            }

            int var9;
            int var62;
            int var64;
            if(ServerPacket.field2249 == var1.serverPacket) {
               var23 = var1.packetLength;
               var24 = var3.offset;
               class94.field1400 = 0;
               var6 = 0;
               var3.bitAccess();

               for(var62 = 0; var62 < class94.playerIndexesCount; ++var62) {
                  var64 = class94.playerIndices[var62];
                  if((class94.field1389[var64] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = SceneComposition.method170(var3);
                           class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                        } else {
                           class61.decodeMovement(var3, var64);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var62 = 0; var62 < class94.playerIndexesCount; ++var62) {
                  var64 = class94.playerIndices[var62];
                  if((class94.field1389[var64] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = SceneComposition.method170(var3);
                           class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                        } else {
                           class61.decodeMovement(var3, var64);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var62 = 0; var62 < class94.field1394; ++var62) {
                  var64 = class94.field1395[var62];
                  if((class94.field1389[var64] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = SceneComposition.method170(var3);
                           class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                        } else if(class86.decodeRegionHash(var3, var64)) {
                           class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var62 = 0; var62 < class94.field1394; ++var62) {
                  var64 = class94.field1395[var62];
                  if((class94.field1389[var64] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = SceneComposition.method170(var3);
                           class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                        } else if(class86.decodeRegionHash(var3, var64)) {
                           class94.field1389[var64] = (byte)(class94.field1389[var64] | 2);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               class94.playerIndexesCount = 0;
               class94.field1394 = 0;

               for(var62 = 1; var62 < 2048; ++var62) {
                  class94.field1389[var62] = (byte)(class94.field1389[var62] >> 1);
                  Player var89 = cachedPlayers[var62];
                  if(var89 != null) {
                     class94.playerIndices[++class94.playerIndexesCount - 1] = var62;
                  } else {
                     class94.field1395[++class94.field1394 - 1] = var62;
                  }
               }

               TextureProvider.method2414(var3);
               if(var23 != var3.offset - var24) {
                  throw new RuntimeException(var3.offset - var24 + " " + var23);
               }

               var1.serverPacket = null;
               return true;
            }

            long var27;
            if(ServerPacket.field2256 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               if(var23 == 65535) {
                  var23 = -1;
               }

               var24 = var3.method3308();
               var6 = var3.readInt();
               var62 = var3.readUnsignedShort();
               if(var62 == 65535) {
                  var62 = -1;
               }

               for(var64 = var62; var64 <= var23; ++var64) {
                  var27 = (long)var64 + ((long)var24 << 32);
                  Node var69 = widgetFlags.get(var27);
                  if(var69 != null) {
                     var69.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var6), var27);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2286 == var1.serverPacket) {
               for(var23 = 0; var23 < cachedPlayers.length; ++var23) {
                  if(cachedPlayers[var23] != null) {
                     cachedPlayers[var23].animation = -1;
                  }
               }

               for(var23 = 0; var23 < cachedNPCs.length; ++var23) {
                  if(cachedNPCs[var23] != null) {
                     cachedNPCs[var23].animation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            long var10;
            long var31;
            int var34;
            int var35;
            int var73;
            String var79;
            boolean var90;
            if(ServerPacket.field2296 == var1.serverPacket) {
               field1022 = cycleCntr;
               if(var1.packetLength == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  class192.clanChatCount = 0;
                  GameEngine.clanMembers = null;
                  var1.serverPacket = null;
                  return true;
               }

               clanChatName = var3.readString();
               long var29 = var3.readLong();
               var31 = var29;
               if(var29 > 0L && var29 < 6582952005840035281L) {
                  if(0L == var29 % 37L) {
                     var79 = null;
                  } else {
                     var9 = 0;

                     for(var10 = var29; 0L != var10; var10 /= 37L) {
                        ++var9;
                     }

                     StringBuilder var71 = new StringBuilder(var9);

                     while(0L != var31) {
                        long var13 = var31;
                        var31 /= 37L;
                        var71.append(class279.field3739[(int)(var13 - var31 * 37L)]);
                     }

                     var79 = var71.reverse().toString();
                  }
               } else {
                  var79 = null;
               }

               clanChatOwner = var79;
               CollisionData.field2209 = var3.readByte();
               var9 = var3.readUnsignedByte();
               if(var9 == 255) {
                  var1.serverPacket = null;
                  return true;
               }

               class192.clanChatCount = var9;
               ClanMember[] var93 = new ClanMember[100];

               for(var34 = 0; var34 < class192.clanChatCount; ++var34) {
                  var93[var34] = new ClanMember();
                  var93[var34].username = var3.readString();
                  var93[var34].field840 = SpritePixels2.cleanUsername(var93[var34].username, PendingSpawn.jagexLoginType);
                  var93[var34].world = var3.readUnsignedShort();
                  var93[var34].rank = var3.readByte();
                  var3.readString();
                  if(var93[var34].username.equals(UrlRequest.localPlayer.name)) {
                     VertexNormal.clanChatRank = var93[var34].rank;
                  }
               }

               var90 = false;
               var35 = class192.clanChatCount;

               while(var35 > 0) {
                  var90 = true;
                  --var35;

                  for(var73 = 0; var73 < var35; ++var73) {
                     if(var93[var73].field840.compareTo(var93[var73 + 1].field840) > 0) {
                        ClanMember var72 = var93[var73];
                        var93[var73] = var93[var73 + 1];
                        var93[var73 + 1] = var72;
                        var90 = false;
                     }
                  }

                  if(var90) {
                     break;
                  }
               }

               GameEngine.clanMembers = var93;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               class56.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2260 == var1.serverPacket) {
               class64.field727 = IndexStoreActionHandler.socialStatusForId(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2248 == var1.serverPacket) {
               for(var23 = 0; var23 < Frames.field2028; ++var23) {
                  VarPlayerType var67 = class25.method182(var23);
                  if(var67 != null) {
                     class222.settings[var23] = 0;
                     class222.widgetSettings[var23] = 0;
                  }
               }

               CombatInfoListHolder.method1630();
               field1015 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2283 == var1.serverPacket) {
               CombatInfoListHolder.method1630();
               energy = var3.readUnsignedByte();
               field1025 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2237 == var1.serverPacket) {
               Friend.otherPackets(class173.field2421);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2292 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               var24 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var62 = var3.readUnsignedByte();
               field1075[var23] = true;
               field1076[var23] = var24;
               field1077[var23] = var6;
               field1078[var23] = var62;
               field1079[var23] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2302 == var1.serverPacket) {
               var23 = var3.method3300();
               var24 = var3.method3307();
               var25 = VertexNormal.getWidget(var24);
               if(var23 != var25.field2806 || var23 == -1) {
                  var25.field2806 = var23;
                  var25.field2881 = 0;
                  var25.field2892 = 0;
                  class33.method344(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2274 == var1.serverPacket) {
               CombatInfoListHolder.method1630();
               var23 = var3.readUnsignedByteNegate();
               var24 = var3.readUnsignedByteNegate();
               var6 = var3.readInt();
               skillExperiences[var24] = var6;
               boostedSkillLevels[var24] = var23;
               realSkillLevels[var24] = 1;

               for(var62 = 0; var62 < 98; ++var62) {
                  if(var6 >= class233.skillExperienceTable[var62]) {
                     realSkillLevels[var24] = var62 + 2;
                  }
               }

               field1018[++field922 - 1 & 31] = var24;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2270 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  var23 = widgetRoot;
                  if(GraphicsObject.loadWidget(var23)) {
                     SceneComposition.method165(Widget.widgets[var23], 0);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2239 == var1.serverPacket) {
               Friend.otherPackets(class173.field2428);
               var1.serverPacket = null;
               return true;
            }

            boolean var78;
            if(ServerPacket.field2275 == var1.serverPacket) {
               var78 = var3.method3335() == 1;
               var24 = var3.method3457();
               var25 = VertexNormal.getWidget(var24);
               if(var78 != var25.isHidden) {
                  var25.isHidden = var78;
                  class33.method344(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            int var36;
            if(ServerPacket.field2243 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var24 += 32768;
               }

               if(var23 >= 0) {
                  var25 = VertexNormal.getWidget(var23);
               } else {
                  var25 = null;
               }

               if(var25 != null) {
                  for(var62 = 0; var62 < var25.itemIds.length; ++var62) {
                     var25.itemIds[var62] = 0;
                     var25.itemQuantities[var62] = 0;
                  }
               }

               NamedRecord.method548(var24);
               var62 = var3.readUnsignedShort();

               for(var64 = 0; var64 < var62; ++var64) {
                  var9 = var3.readUnsignedByteNegate();
                  if(var9 == 255) {
                     var9 = var3.method3308();
                  }

                  var36 = var3.method3299();
                  if(var25 != null && var64 < var25.itemIds.length) {
                     var25.itemIds[var64] = var36;
                     var25.itemQuantities[var64] = var9;
                  }

                  UrlRequester.setItemTableSlot(var24, var64, var36 - 1, var9);
               }

               if(var25 != null) {
                  class33.method344(var25);
               }

               CombatInfoListHolder.method1630();
               interfaceItemTriggers[++field1017 - 1 & 31] = var24 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2245 == var1.serverPacket) {
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
               field1094 = 1;
               field1041 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            boolean var7;
            boolean var86;
            String var87;
            if(ServerPacket.field2262 == var1.serverPacket) {
               var23 = var3.getUSmart();
               var86 = var3.readUnsignedByte() == 1;
               var79 = "";
               var7 = false;
               if(var86) {
                  var79 = var3.readString();
                  if(class27.isIgnored(var79)) {
                     var7 = true;
                  }
               }

               var87 = var3.readString();
               if(!var7) {
                  class25.sendGameMessage(var23, var79, var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2268 == var1.serverPacket) {
               class35.field467 = var3.method3274();
               SceneChunkMetadata.field558 = var3.readUnsignedByteNegate();

               while(var3.offset < var1.packetLength) {
                  var23 = var3.readUnsignedByte();
                  class173 var66 = Size.method173()[var23];
                  Friend.otherPackets(var66);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2297 == var1.serverPacket) {
               class56.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2251 == var1.serverPacket) {
               var23 = var3.readUnsignedShortOb1();
               ItemContainer var65 = (ItemContainer)ItemContainer.itemContainers.get((long)var23);
               if(var65 != null) {
                  var65.unlink();
               }

               interfaceItemTriggers[++field1017 - 1 & 31] = var23 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2309 == var1.serverPacket) {
               var23 = var3.method3335();
               var5 = var3.readString();
               var6 = var3.readUnsignedByte();
               if(var6 >= 1 && var6 <= 8) {
                  if(var5.equalsIgnoreCase("null")) {
                     var5 = null;
                  }

                  playerOptions[var6 - 1] = var5;
                  playerOptionsPriorities[var6 - 1] = var23 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2284 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var24 = var3.method3308();
               var25 = VertexNormal.getWidget(var24);
               if(var25 != null && var25.type == 0) {
                  if(var23 > var25.scrollHeight - var25.height) {
                     var23 = var25.scrollHeight - var25.height;
                  }

                  if(var23 < 0) {
                     var23 = 0;
                  }

                  if(var23 != var25.scrollY) {
                     var25.scrollY = var23;
                     class33.method344(var25);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2247 == var1.serverPacket) {
               CombatInfoListHolder.method1630();
               weight = var3.readShort();
               field1025 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            boolean var14;
            int var37;
            if(ServerPacket.field2244 == var1.serverPacket) {
               while(var3.offset < var1.packetLength) {
                  var78 = var3.readUnsignedByte() == 1;
                  var5 = var3.readString();
                  var79 = var3.readString();
                  var62 = var3.readUnsignedShort();
                  var64 = var3.readUnsignedByte();
                  var9 = var3.readUnsignedByte();
                  boolean var97 = (var9 & 2) != 0;
                  var90 = (var9 & 1) != 0;
                  if(var62 > 0) {
                     var3.readString();
                     var3.readUnsignedByte();
                     var3.readInt();
                  }

                  var3.readString();

                  for(var37 = 0; var37 < friendCount; ++var37) {
                     Friend var96 = friends[var37];
                     if(!var78) {
                        if(var5.equals(var96.name)) {
                           if(var62 != var96.world) {
                              var14 = true;

                              for(FriendLoginUpdate var75 = (FriendLoginUpdate)field1096.method3791(); var75 != null; var75 = (FriendLoginUpdate)field1096.method3794()) {
                                 if(var75.field752.equals(var5)) {
                                    if(var62 != 0 && var75.field753 == 0) {
                                       var75.remove();
                                       var14 = false;
                                    } else if(var62 == 0 && var75.field753 != 0) {
                                       var75.remove();
                                       var14 = false;
                                    }
                                 }
                              }

                              if(var14) {
                                 field1096.method3790(new FriendLoginUpdate(var5, var62));
                              }

                              var96.world = var62;
                           }

                           var96.previousName = var79;
                           var96.rank = var64;
                           var96.field748 = var97;
                           var96.field747 = var90;
                           var5 = null;
                           break;
                        }
                     } else if(var79.equals(var96.name)) {
                        var96.name = var5;
                        var96.previousName = var79;
                        var5 = null;
                        break;
                     }
                  }

                  if(var5 != null && friendCount < 400) {
                     Friend var70 = new Friend();
                     friends[friendCount] = var70;
                     var70.name = var5;
                     var70.previousName = var79;
                     var70.world = var62;
                     var70.rank = var64;
                     var70.field748 = var97;
                     var70.field747 = var90;
                     ++friendCount;
                  }
               }

               field1094 = 2;
               field1041 = cycleCntr;
               var78 = false;
               var24 = friendCount;

               while(var24 > 0) {
                  var78 = true;
                  --var24;

                  for(var6 = 0; var6 < var24; ++var6) {
                     var7 = false;
                     Friend var88 = friends[var6];
                     Friend var100 = friends[var6 + 1];
                     if(var88.world != world && var100.world == world) {
                        var7 = true;
                     }

                     if(!var7 && var88.world == 0 && var100.world != 0) {
                        var7 = true;
                     }

                     if(!var7 && !var88.field748 && var100.field748) {
                        var7 = true;
                     }

                     if(!var7 && !var88.field747 && var100.field747) {
                        var7 = true;
                     }

                     if(var7) {
                        Friend var92 = friends[var6];
                        friends[var6] = friends[var6 + 1];
                        friends[var6 + 1] = var92;
                        var78 = false;
                     }
                  }

                  if(var78) {
                     break;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2276 == var1.serverPacket) {
               field1062 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2277 == var1.serverPacket) {
               var23 = var3.method3457();
               var24 = var3.readUnsignedShort();
               var6 = var24 >> 10 & 31;
               var62 = var24 >> 5 & 31;
               var64 = var24 & 31;
               var9 = (var62 << 11) + (var6 << 19) + (var64 << 3);
               Widget var91 = VertexNormal.getWidget(var23);
               if(var9 != var91.textColor) {
                  var91.textColor = var9;
                  class33.method344(var91);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var85;
            if(ServerPacket.field2304 == var1.serverPacket) {
               var23 = var3.method3308();
               var24 = var3.method3297();
               var6 = var3.method3299();
               var62 = var3.readUnsignedShort();
               var85 = VertexNormal.getWidget(var23);
               if(var24 != var85.rotationX || var6 != var85.rotationZ || var62 != var85.modelZoom) {
                  var85.rotationX = var24;
                  var85.rotationZ = var6;
                  var85.modelZoom = var62;
                  class33.method344(var85);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2232 == var1.serverPacket) {
               field930 = true;
               BaseVarType.field21 = var3.readUnsignedByte();
               BoundingBox3D.field253 = var3.readUnsignedByte();
               Projectile.field1380 = var3.readUnsignedShort();
               class11.field259 = var3.readUnsignedByte();
               class48.field577 = var3.readUnsignedByte();
               if(class48.field577 >= 100) {
                  MouseInput.cameraX = BaseVarType.field21 * 128 + 64;
                  GZipDecompressor.cameraY = BoundingBox3D.field253 * 128 + 64;
                  GrandExchangeEvent.cameraZ = WorldMapType2.getTileHeight(MouseInput.cameraX, GZipDecompressor.cameraY, BoundingBox2D.plane) - Projectile.field1380;
               }

               var1.serverPacket = null;
               return true;
            }

            String var16;
            int var17;
            long var40;
            String var55;
            if(ServerPacket.field2282 == var1.serverPacket) {
               var55 = var3.readString();
               var40 = (long)var3.readUnsignedShort();
               var31 = (long)var3.read24BitInt();
               Permission var99 = (Permission)class91.forOrdinal(GroundObject.method2493(), var3.readUnsignedByte());
               var10 = (var40 << 32) + var31;
               boolean var94 = false;

               for(var35 = 0; var35 < 100; ++var35) {
                  if(field1047[var35] == var10) {
                     var94 = true;
                     break;
                  }
               }

               if(class27.isIgnored(var55)) {
                  var94 = true;
               }

               if(!var94 && field947 == 0) {
                  field1047[field1048] = var10;
                  field1048 = (field1048 + 1) % 100;
                  String var95 = FontTypeFace.appendTags(SceneTilePaint.method2682(TotalQuantityComparator.method94(var3)));
                  byte var76;
                  if(var99.field3278) {
                     var76 = 7;
                  } else {
                     var76 = 3;
                  }

                  if(var99.field3279 != -1) {
                     var17 = var99.field3279;
                     var16 = "<img=" + var17 + ">";
                     class25.sendGameMessage(var76, var16 + var55, var95);
                  } else {
                     class25.sendGameMessage(var76, var55, var95);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2278 == var1.serverPacket) {
               field930 = true;
               class1.field9 = var3.readUnsignedByte();
               Buffer.field2516 = var3.readUnsignedByte();
               GrandExchangeEvents.field273 = var3.readUnsignedShort();
               class173.field2429 = var3.readUnsignedByte();
               FontName.field3698 = var3.readUnsignedByte();
               if(FontName.field3698 >= 100) {
                  var23 = class1.field9 * 128 + 64;
                  var24 = Buffer.field2516 * 128 + 64;
                  var6 = WorldMapType2.getTileHeight(var23, var24, BoundingBox2D.plane) - GrandExchangeEvents.field273;
                  var62 = var23 - MouseInput.cameraX;
                  var64 = var6 - GrandExchangeEvent.cameraZ;
                  var9 = var24 - GZipDecompressor.cameraY;
                  var36 = (int)Math.sqrt((double)(var9 * var9 + var62 * var62));
                  class160.cameraPitch = (int)(Math.atan2((double)var64, (double)var36) * 325.949D) & 2047;
                  class240.cameraYaw = (int)(Math.atan2((double)var62, (double)var9) * -325.949D) & 2047;
                  if(class160.cameraPitch < 128) {
                     class160.cameraPitch = 128;
                  }

                  if(class160.cameraPitch > 383) {
                     class160.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var59;
            if(ServerPacket.field2288 == var1.serverPacket) {
               var23 = var3.method3308();
               var59 = VertexNormal.getWidget(var23);
               var59.modelType = 3;
               var59.modelId = UrlRequest.localPlayer.composition.method4100();
               class33.method344(var59);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2287 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var24 += 32768;
               }

               if(var23 >= 0) {
                  var25 = VertexNormal.getWidget(var23);
               } else {
                  var25 = null;
               }

               for(; var3.offset < var1.packetLength; UrlRequester.setItemTableSlot(var24, var62, var64 - 1, var9)) {
                  var62 = var3.getUSmart();
                  var64 = var3.readUnsignedShort();
                  var9 = 0;
                  if(var64 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var25 != null && var62 >= 0 && var62 < var25.itemIds.length) {
                     var25.itemIds[var62] = var64;
                     var25.itemQuantities[var62] = var9;
                  }
               }

               if(var25 != null) {
                  class33.method344(var25);
               }

               CombatInfoListHolder.method1630();
               interfaceItemTriggers[++field1017 - 1 & 31] = var24 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2294 == var1.serverPacket) {
               publicChatMode = var3.method3335();
               field1087 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2273 == var1.serverPacket) {
               World var60 = new World();
               var60.address = var3.readString();
               var60.id = var3.readUnsignedShort();
               var24 = var3.readInt();
               var60.mask = var24;
               Friend.setGameState(45);
               var2.close();
               var2 = null;
               Size.method176(var60);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2264 == var1.serverPacket) {
               MessageNode.npcUpdatePacket(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2279 == var1.serverPacket) {
               Friend.otherPackets(class173.field2422);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2236 == var1.serverPacket) {
               MessageNode.npcUpdatePacket(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var24 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               class36.method498(var23, var24, var6);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2230 == var1.serverPacket) {
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

            if(ServerPacket.field2301 == var1.serverPacket) {
               UrlRequest.method2922(var3.readString());
               var1.serverPacket = null;
               return true;
            }

            int var42;
            if(ServerPacket.field2233 == var1.serverPacket) {
               var23 = var1.packetLength;
               ClassInfo var61 = new ClassInfo();
               var61.count = var3.readUnsignedByte();
               var61.field3819 = var3.readInt();
               var61.type = new int[var61.count];
               var61.errorIdentifiers = new int[var61.count];
               var61.fields = new Field[var61.count];
               var61.field3820 = new int[var61.count];
               var61.methods = new Method[var61.count];
               var61.args = new byte[var61.count][][];

               for(var6 = 0; var6 < var61.count; ++var6) {
                  try {
                     var62 = var3.readUnsignedByte();
                     String var98;
                     if(var62 != 0 && var62 != 1 && var62 != 2) {
                        if(var62 == 3 || var62 == 4) {
                           var87 = var3.readString();
                           var98 = var3.readString();
                           var36 = var3.readUnsignedByte();
                           String[] var68 = new String[var36];

                           for(var37 = 0; var37 < var36; ++var37) {
                              var68[var37] = var3.readString();
                           }

                           String var12 = var3.readString();
                           byte[][] var38 = new byte[var36][];
                           if(var62 == 3) {
                              for(var73 = 0; var73 < var36; ++var73) {
                                 var42 = var3.readInt();
                                 var38[var73] = new byte[var42];
                                 var3.readBytes(var38[var73], 0, var42);
                              }
                           }

                           var61.type[var6] = var62;
                           Class[] var43 = new Class[var36];

                           for(var42 = 0; var42 < var36; ++var42) {
                              var43[var42] = ClientPacket.loadClassFromDescriptor(var68[var42]);
                           }

                           Class var74 = ClientPacket.loadClassFromDescriptor(var12);
                           if(ClientPacket.loadClassFromDescriptor(var87).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var77 = ClientPacket.loadClassFromDescriptor(var87).getDeclaredMethods();
                           Method[] var44 = var77;

                           for(int var18 = 0; var18 < var44.length; ++var18) {
                              Method var19 = var44[var18];
                              if(Reflection.getMethodName(var19).equals(var98)) {
                                 Class[] var20 = Reflection.getParameterTypes(var19);
                                 if(var43.length == var20.length) {
                                    boolean var21 = true;

                                    for(int var22 = 0; var22 < var43.length; ++var22) {
                                       if(var43[var22] != var20[var22]) {
                                          var21 = false;
                                          break;
                                       }
                                    }

                                    if(var21 && var74 == var19.getReturnType()) {
                                       var61.methods[var6] = var19;
                                    }
                                 }
                              }
                           }

                           var61.args[var6] = var38;
                        }
                     } else {
                        var87 = var3.readString();
                        var98 = var3.readString();
                        var36 = 0;
                        if(var62 == 1) {
                           var36 = var3.readInt();
                        }

                        var61.type[var6] = var62;
                        var61.field3820[var6] = var36;
                        if(ClientPacket.loadClassFromDescriptor(var87).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var61.fields[var6] = Reflection.findField(ClientPacket.loadClassFromDescriptor(var87), var98);
                     }
                  } catch (ClassNotFoundException var48) {
                     var61.errorIdentifiers[var6] = -1;
                  } catch (SecurityException var49) {
                     var61.errorIdentifiers[var6] = -2;
                  } catch (NullPointerException var50) {
                     var61.errorIdentifiers[var6] = -3;
                  } catch (Exception var51) {
                     var61.errorIdentifiers[var6] = -4;
                  } catch (Throwable var52) {
                     var61.errorIdentifiers[var6] = -5;
                  }
               }

               class293.classInfos.addFirst(var61);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2293 == var1.serverPacket) {
               SceneChunkMetadata.field558 = var3.method3274();
               class35.field467 = var3.readUnsignedByte();

               for(var23 = SceneChunkMetadata.field558; var23 < SceneChunkMetadata.field558 + 8; ++var23) {
                  for(var24 = class35.field467; var24 < class35.field467 + 8; ++var24) {
                     if(groundItemDeque[BoundingBox2D.plane][var23][var24] != null) {
                        groundItemDeque[BoundingBox2D.plane][var23][var24] = null;
                        Player.groundItemSpawned(var23, var24);
                     }
                  }
               }

               for(PendingSpawn var57 = (PendingSpawn)pendingSpawns.getFront(); var57 != null; var57 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var57.x >= SceneChunkMetadata.field558 && var57.x < SceneChunkMetadata.field558 + 8 && var57.y >= class35.field467 && var57.y < class35.field467 + 8 && var57.level == BoundingBox2D.plane) {
                     var57.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2298 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var23] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var23] = new GrandExchangeOffer(var3, false);
               }

               field1050 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            Widget var45;
            if(ServerPacket.field2280 == var1.serverPacket) {
               var23 = var3.method3308();
               var24 = var3.method3300();
               var6 = var3.method3269();
               var45 = VertexNormal.getWidget(var23);
               if(var24 != var45.originalX || var6 != var45.originalY || var45.field2764 != 0 || var45.field2838 != 0) {
                  var45.originalX = var24;
                  var45.originalY = var6;
                  var45.field2764 = 0;
                  var45.field2838 = 0;
                  class33.method344(var45);
                  this.widgetMethod0(var45);
                  if(var45.type == 0) {
                     GrandExchangeOffer.method102(Widget.widgets[var23 >> 16], var45, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            WidgetNode var102;
            if(ServerPacket.field2242 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readInt();
               WidgetNode var84 = (WidgetNode)componentTable.get((long)var24);
               var102 = (WidgetNode)componentTable.get((long)var23);
               if(var102 != null) {
                  FriendLoginUpdate.method1042(var102, var84 == null || var84.id != var102.id);
               }

               if(var84 != null) {
                  var84.unlink();
                  componentTable.put(var84, (long)var23);
               }

               var85 = VertexNormal.getWidget(var24);
               if(var85 != null) {
                  class33.method344(var85);
               }

               var85 = VertexNormal.getWidget(var23);
               if(var85 != null) {
                  class33.method344(var85);
                  GrandExchangeOffer.method102(Widget.widgets[var85.id >>> 16], var85, true);
               }

               if(widgetRoot != -1) {
                  var9 = widgetRoot;
                  if(GraphicsObject.loadWidget(var9)) {
                     SceneComposition.method165(Widget.widgets[var9], 1);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2229 == var1.serverPacket) {
               class35.field467 = var3.method3335();
               SceneChunkMetadata.field558 = var3.readUnsignedByteNegate();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2285 == var1.serverPacket) {
               Friend.otherPackets(class173.field2426);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2272 == var1.serverPacket) {
               var55 = var3.readString();
               var5 = FontTypeFace.appendTags(SceneTilePaint.method2682(TotalQuantityComparator.method94(var3)));
               class25.sendGameMessage(6, var55, var5);
               var1.serverPacket = null;
               return true;
            }

            long var46;
            if(ServerPacket.field2240 == var1.serverPacket) {
               var23 = var3.offset + var1.packetLength;
               var24 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var24 != widgetRoot) {
                  widgetRoot = var24;
                  this.method1380(false);
                  class33.method343(widgetRoot);
                  class11.method52(widgetRoot);

                  for(var62 = 0; var62 < 100; ++var62) {
                     field1033[var62] = true;
                  }
               }

               WidgetNode var33;
               for(; var6-- > 0; var33.field764 = true) {
                  var62 = var3.readInt();
                  var64 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var33 = (WidgetNode)componentTable.get((long)var62);
                  if(var33 != null && var64 != var33.id) {
                     FriendLoginUpdate.method1042(var33, true);
                     var33 = null;
                  }

                  if(var33 == null) {
                     var33 = class96.method1828(var62, var64, var9);
                  }
               }

               for(var102 = (WidgetNode)componentTable.first(); var102 != null; var102 = (WidgetNode)componentTable.next()) {
                  if(var102.field764) {
                     var102.field764 = false;
                  } else {
                     FriendLoginUpdate.method1042(var102, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var23) {
                  var62 = var3.readInt();
                  var64 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var36 = var3.readInt();

                  for(var34 = var64; var34 <= var9; ++var34) {
                     var46 = ((long)var62 << 32) + (long)var34;
                     widgetFlags.put(new IntegerNode(var36), var46);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2241 == var1.serverPacket) {
               class96.method1831();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2281 == var1.serverPacket) {
               var23 = var3.readInt();
               var59 = VertexNormal.getWidget(var23);

               for(var6 = 0; var6 < var59.itemIds.length; ++var6) {
                  var59.itemIds[var6] = -1;
                  var59.itemIds[var6] = 0;
               }

               class33.method344(var59);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2290 == var1.serverPacket) {
               var23 = var3.method3297();
               var24 = var3.method3307();
               var25 = VertexNormal.getWidget(var24);
               if(var25.modelType != 1 || var23 != var25.modelId) {
                  var25.modelType = 1;
                  var25.modelId = var23;
                  class33.method344(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2261 == var1.serverPacket) {
               var23 = var3.method3297();
               if(var23 == 65535) {
                  var23 = -1;
               }

               if(var23 == -1 && !field1008) {
                  class282.field3753.method3849();
                  class214.field2620 = 1;
                  class214.field2623 = null;
               } else if(var23 != -1 && var23 != field850 && field845 != 0 && !field1008) {
                  CollisionData.method3152(2, class29.indexTrack1, var23, 0, field845, false);
               }

               field850 = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2246 == var1.serverPacket) {
               var23 = var3.method3303();
               var24 = var3.readUnsignedShort();
               if(var24 == 65535) {
                  var24 = -1;
               }

               if(field845 != 0 && var24 != -1) {
                  class2.method3(class20.indexTrack2, var24, 0, field845, false);
                  field1008 = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2271 == var1.serverPacket) {
               byte var80 = var3.method3347();
               var24 = var3.readUnsignedShort();
               class222.settings[var24] = var80;
               if(class222.widgetSettings[var24] != var80) {
                  class222.widgetSettings[var24] = var80;
               }

               class150.method2933(var24);
               field988[++field1015 - 1 & 31] = var24;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2235 == var1.serverPacket) {
               var55 = var3.readString();
               Object[] var58 = new Object[var55.length() + 1];

               for(var6 = var55.length() - 1; var6 >= 0; --var6) {
                  if(var55.charAt(var6) == 's') {
                     var58[var6 + 1] = var3.readString();
                  } else {
                     var58[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var58[0] = new Integer(var3.readInt());
               ScriptEvent var81 = new ScriptEvent();
               var81.objs = var58;
               CacheFile.method2350(var81);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2306 == var1.serverPacket) {
               Friend.otherPackets(class173.field2425);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2254 == var1.serverPacket) {
               var55 = var3.readString();
               var40 = var3.readLong();
               var31 = (long)var3.readUnsignedShort();
               var27 = (long)var3.read24BitInt();
               Permission var11 = (Permission)class91.forOrdinal(GroundObject.method2493(), var3.readUnsignedByte());
               var46 = (var31 << 32) + var27;
               var14 = false;

               for(var42 = 0; var42 < 100; ++var42) {
                  if(field1047[var42] == var46) {
                     var14 = true;
                     break;
                  }
               }

               if(var11.field3272 && class27.isIgnored(var55)) {
                  var14 = true;
               }

               if(!var14 && field947 == 0) {
                  field1047[field1048] = var46;
                  field1048 = (field1048 + 1) % 100;
                  String var15 = FontTypeFace.appendTags(SceneTilePaint.method2682(TotalQuantityComparator.method94(var3)));
                  if(var11.field3279 != -1) {
                     var17 = var11.field3279;
                     var16 = "<img=" + var17 + ">";
                     AbstractScene.addChatMessage(9, var16 + var55, var15, class96.method1808(var40));
                  } else {
                     AbstractScene.addChatMessage(9, var55, var15, class96.method1808(var40));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2238 == var1.serverPacket) {
               var23 = var3.readInt();
               WidgetNode var56 = (WidgetNode)componentTable.get((long)var23);
               if(var56 != null) {
                  FriendLoginUpdate.method1042(var56, true);
               }

               if(field958 != null) {
                  class33.method344(field958);
                  field958 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2250 == var1.serverPacket) {
               var23 = var3.method3297();
               widgetRoot = var23;
               this.method1380(false);
               class33.method343(var23);
               class11.method52(widgetRoot);

               for(var24 = 0; var24 < 100; ++var24) {
                  field1033[var24] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2228 == var1.serverPacket) {
               while(var3.offset < var1.packetLength) {
                  var23 = var3.readUnsignedByte();
                  var86 = (var23 & 1) == 1;
                  var79 = var3.readString();
                  String var103 = var3.readString();
                  var3.readString();

                  for(var64 = 0; var64 < ignoreCount; ++var64) {
                     Ignore var39 = ignores[var64];
                     if(var86) {
                        if(var103.equals(var39.name)) {
                           var39.name = var79;
                           var39.previousName = var103;
                           var79 = null;
                           break;
                        }
                     } else if(var79.equals(var39.name)) {
                        var39.name = var79;
                        var39.previousName = var103;
                        var79 = null;
                        break;
                     }
                  }

                  if(var79 != null && ignoreCount < 400) {
                     Ignore var83 = new Ignore();
                     ignores[ignoreCount] = var83;
                     var83.name = var79;
                     var83.previousName = var103;
                     ++ignoreCount;
                  }
               }

               field1041 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2257 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  Projectile.method1736(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2231 == var1.serverPacket) {
               var55 = var3.readString();
               var24 = var3.method3308();
               var25 = VertexNormal.getWidget(var24);
               if(!var55.equals(var25.text)) {
                  var25.text = var55;
                  class33.method344(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2300 == var1.serverPacket) {
               Friend.otherPackets(class173.field2424);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2258 == var1.serverPacket) {
               var55 = var3.readString();
               var24 = var3.readUnsignedShort();
               byte var63 = var3.readByte();
               var7 = false;
               if(var63 == -128) {
                  var7 = true;
               }

               if(var7) {
                  if(class192.clanChatCount == 0) {
                     var1.serverPacket = null;
                     return true;
                  }

                  boolean var8 = false;

                  for(var64 = 0; var64 < class192.clanChatCount && (!GameEngine.clanMembers[var64].username.equals(var55) || var24 != GameEngine.clanMembers[var64].world); ++var64) {
                     ;
                  }

                  if(var64 < class192.clanChatCount) {
                     while(var64 < class192.clanChatCount - 1) {
                        GameEngine.clanMembers[var64] = GameEngine.clanMembers[var64 + 1];
                        ++var64;
                     }

                     --class192.clanChatCount;
                     GameEngine.clanMembers[class192.clanChatCount] = null;
                  }
               } else {
                  var3.readString();
                  ClanMember var82 = new ClanMember();
                  var82.username = var55;
                  var82.field840 = SpritePixels2.cleanUsername(var82.username, PendingSpawn.jagexLoginType);
                  var82.world = var24;
                  var82.rank = var63;

                  for(var9 = class192.clanChatCount - 1; var9 >= 0; --var9) {
                     var36 = GameEngine.clanMembers[var9].field840.compareTo(var82.field840);
                     if(var36 == 0) {
                        GameEngine.clanMembers[var9].world = var24;
                        GameEngine.clanMembers[var9].rank = var63;
                        if(var55.equals(UrlRequest.localPlayer.name)) {
                           VertexNormal.clanChatRank = var63;
                        }

                        field1022 = cycleCntr;
                        var1.serverPacket = null;
                        return true;
                     }

                     if(var36 < 0) {
                        break;
                     }
                  }

                  if(class192.clanChatCount >= GameEngine.clanMembers.length) {
                     var1.serverPacket = null;
                     return true;
                  }

                  for(var36 = class192.clanChatCount - 1; var36 > var9; --var36) {
                     GameEngine.clanMembers[var36 + 1] = GameEngine.clanMembers[var36];
                  }

                  if(class192.clanChatCount == 0) {
                     GameEngine.clanMembers = new ClanMember[100];
                  }

                  GameEngine.clanMembers[var9 + 1] = var82;
                  ++class192.clanChatCount;
                  if(var55.equals(UrlRequest.localPlayer.name)) {
                     VertexNormal.clanChatRank = var63;
                  }
               }

               field1022 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2266 == var1.serverPacket) {
               Friend.otherPackets(class173.field2423);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2234 == var1.serverPacket) {
               var23 = var3.method3457();
               var24 = var3.method3297();
               class222.settings[var24] = var23;
               if(class222.widgetSettings[var24] != var23) {
                  class222.widgetSettings[var24] = var23;
               }

               class150.method2933(var24);
               field988[++field1015 - 1 & 31] = var24;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2269 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               var24 = var3.method3299();
               var6 = var3.method3308();
               var102 = (WidgetNode)componentTable.get((long)var6);
               if(var102 != null) {
                  FriendLoginUpdate.method1042(var102, var24 != var102.id);
               }

               class96.method1828(var6, var24, var23);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2303 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readInt();
               var6 = class232.method4205();
               PacketNode var101 = FileSystem.bufferForSize(ClientPacket.field2376, signlink.field1449);
               var101.packetBuffer.method3285(GameEngine.FPS);
               var101.packetBuffer.method3286(var6);
               var101.packetBuffer.method3311(var23);
               var101.packetBuffer.writeIntLE(var24);
               signlink.method1862(var101);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2253 == var1.serverPacket) {
               var78 = var3.readUnsignedByte() == 1;
               if(var78) {
                  class29.field392 = Preferences.currentTimeMs() - var3.readLong();
                  class56.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  class56.grandExchangeEvents = null;
               }

               field1024 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2291 == var1.serverPacket) {
               var23 = var3.method3308();
               var24 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShortOb1();
               var45 = VertexNormal.getWidget(var23);
               var45.field2815 = var6 + (var24 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2289 == var1.serverPacket) {
               var23 = var3.method3308();
               var24 = var3.method3297();
               if(var24 == 65535) {
                  var24 = -1;
               }

               var6 = var3.readInt();
               var45 = VertexNormal.getWidget(var6);
               ItemComposition var26;
               if(!var45.hasScript) {
                  if(var24 == -1) {
                     var45.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var26 = KitDefinition.getItemDefinition(var24);
                  var45.modelType = 4;
                  var45.modelId = var24;
                  var45.rotationX = var26.xan2d;
                  var45.rotationZ = var26.yan2d;
                  var45.modelZoom = var26.zoom2d * 100 / var23;
                  class33.method344(var45);
               } else {
                  var45.itemId = var24;
                  var45.itemQuantity = var23;
                  var26 = KitDefinition.getItemDefinition(var24);
                  var45.rotationX = var26.xan2d;
                  var45.rotationZ = var26.yan2d;
                  var45.rotationY = var26.zan2d;
                  var45.field2808 = var26.offsetX2d;
                  var45.field2809 = var26.offsetY2d;
                  var45.modelZoom = var26.zoom2d;
                  if(var26.isStackable == 1) {
                     var45.field2866 = 1;
                  } else {
                     var45.field2866 = 2;
                  }

                  if(var45.field2836 > 0) {
                     var45.modelZoom = var45.modelZoom * 32 / var45.field2836;
                  } else if(var45.originalWidth > 0) {
                     var45.modelZoom = var45.modelZoom * 32 / var45.originalWidth;
                  }

                  class33.method344(var45);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2263 == var1.serverPacket) {
               field861 = var3.method3299() * 30;
               field1025 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2308 == var1.serverPacket) {
               for(var23 = 0; var23 < class222.widgetSettings.length; ++var23) {
                  if(class222.widgetSettings[var23] != class222.settings[var23]) {
                     class222.widgetSettings[var23] = class222.settings[var23];
                     class150.method2933(var23);
                     field988[++field1015 - 1 & 31] = var23;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            PendingSpawn.method1461("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.previousThirdPacket != null?var1.previousThirdPacket.packetId:-1) + "," + (var1.previousForthPacket != null?var1.previousForthPacket.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            class96.method1831();
         } catch (IOException var53) {
            TotalQuantityComparator.method85();
         } catch (Exception var54) {
            var5 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.previousThirdPacket != null?var1.previousThirdPacket.packetId:-1) + "," + (var1.previousForthPacket != null?var1.previousForthPacket.packetId:-1) + "," + var1.packetLength + "," + (UrlRequest.localPlayer.pathX[0] + SceneChunkMetadata.baseX) + "," + (UrlRequest.localPlayer.pathY[0] + baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var5 = var5 + var3.payload[var6] + ",";
            }

            PendingSpawn.method1461(var5, var54);
            class96.method1831();
         }

         return true;
      }
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   final void method1390() {
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
               boolean var6 = menuBooleanArray[var2];
               menuBooleanArray[var2] = menuBooleanArray[var2 + 1];
               menuBooleanArray[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(AreaMapIconMetadata.field506 == null) {
         if(field1064 == null) {
            int var20;
            label275: {
               int var19 = MouseInput.mouseLastButton;
               int var7;
               int var9;
               int var15;
               if(isMenuOpen) {
                  int var14;
                  if(var19 != 1 && (class34.field455 || var19 != 4)) {
                     var2 = MouseInput.field679;
                     var14 = MouseInput.field682 * -469125321;
                     if(var2 < WorldMapType1.menuX - 10 || var2 > Item.menuWidth + WorldMapType1.menuX + 10 || var14 < ClientPacket.menuY - 10 || var14 > Size.menuHeight + ClientPacket.menuY + 10) {
                        isMenuOpen = false;
                        WorldMapData.method305(WorldMapType1.menuX, ClientPacket.menuY, Item.menuWidth, Size.menuHeight);
                     }
                  }

                  if(var19 == 1 || !class34.field455 && var19 == 4) {
                     var2 = WorldMapType1.menuX;
                     var14 = ClientPacket.menuY;
                     var15 = Item.menuWidth;
                     var5 = MouseInput.mouseLastPressedX;
                     var20 = MouseInput.mouseLastPressedY;
                     var7 = -1;

                     int var21;
                     for(var21 = 0; var21 < menuOptionCount; ++var21) {
                        var9 = var14 + (menuOptionCount - 1 - var21) * 15 + 31;
                        if(var5 > var2 && var5 < var2 + var15 && var20 > var9 - 13 && var20 < var9 + 3) {
                           var7 = var21;
                        }
                     }

                     if(var7 != -1 && var7 >= 0) {
                        var21 = menuActionParams0[var7];
                        var9 = menuActionParams1[var7];
                        int var10 = menuTypes[var7];
                        int var11 = menuIdentifiers[var7];
                        String var12 = menuOptions[var7];
                        String var13 = menuTargets[var7];
                        class27.menuAction(var21, var9, var10, var11, var12, var13, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                     }

                     isMenuOpen = false;
                     WorldMapData.method305(WorldMapType1.menuX, ClientPacket.menuY, Item.menuWidth, Size.menuHeight);
                  }
               } else {
                  var2 = menuOptionCount - 1;
                  if((var19 == 1 || !class34.field455 && var19 == 4) && var2 >= 0) {
                     var15 = menuTypes[var2];
                     if(var15 == 39 || var15 == 40 || var15 == 41 || var15 == 42 || var15 == 43 || var15 == 33 || var15 == 34 || var15 == 35 || var15 == 36 || var15 == 37 || var15 == 38 || var15 == 1005) {
                        var5 = menuActionParams0[var2];
                        var20 = menuActionParams1[var2];
                        Widget var16 = VertexNormal.getWidget(var20);
                        if(class225.method4132(class36.getWidgetConfig(var16))) {
                           break label275;
                        }

                        var9 = class36.getWidgetConfig(var16);
                        boolean var8 = (var9 >> 29 & 1) != 0;
                        if(var8) {
                           break label275;
                        }
                     }
                  }

                  if((var19 == 1 || !class34.field455 && var19 == 4) && this.method1136()) {
                     var19 = 2;
                  }

                  if((var19 == 1 || !class34.field455 && var19 == 4) && menuOptionCount > 0 && var2 >= 0) {
                     var15 = menuActionParams0[var2];
                     var5 = menuActionParams1[var2];
                     var20 = menuTypes[var2];
                     var7 = menuIdentifiers[var2];
                     String var17 = menuOptions[var2];
                     String var18 = menuTargets[var2];
                     class27.menuAction(var15, var5, var20, var7, var17, var18, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }

                  if(var19 == 2 && menuOptionCount > 0) {
                     this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }
               }

               return;
            }

            if(AreaMapIconMetadata.field506 != null && !field945 && menuOptionCount > 0 && !this.method1136()) {
               WorldMapMappings.method628(field857, field1039);
            }

            field945 = false;
            field1082 = 0;
            if(AreaMapIconMetadata.field506 != null) {
               class33.method344(AreaMapIconMetadata.field506);
            }

            AreaMapIconMetadata.field506 = VertexNormal.getWidget(var20);
            field1073 = var5;
            field857 = MouseInput.mouseLastPressedX;
            field1039 = MouseInput.mouseLastPressedY;
            if(var2 >= 0) {
               PendingSpawn.topContextMenuRow = new ContextMenuRow();
               PendingSpawn.topContextMenuRow.param0 = menuActionParams0[var2];
               PendingSpawn.topContextMenuRow.param1 = menuActionParams1[var2];
               PendingSpawn.topContextMenuRow.type = menuTypes[var2];
               PendingSpawn.topContextMenuRow.identifier = menuIdentifiers[var2];
               PendingSpawn.topContextMenuRow.option = menuOptions[var2];
            }

            class33.method344(AreaMapIconMetadata.field506);
         }
      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-632401288"
   )
   final boolean method1136() {
      int var1 = menuOptionCount - 1;
      if(menuOptionCount > 2) {
         if(field965 == 1 && !menuBooleanArray[var1]) {
            return true;
         }

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

         if(var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1370021772"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      int var3 = Friend.fontBold12.method4886("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = Friend.fontBold12.method4886(class5.method18(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var3 + var5 > Huffman.canvasWidth) {
         var5 = Huffman.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var2 + var4 > VertexNormal.canvasHeight) {
         var6 = VertexNormal.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class48.region.method2829(BoundingBox2D.plane, var1, var2, false);
      isMenuOpen = true;
      WorldMapType1.menuX = var5;
      ClientPacket.menuY = var6;
      Item.menuWidth = var3;
      Size.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1625496123"
   )
   final void method1380(boolean var1) {
      ScriptEvent.method1055(widgetRoot, Huffman.canvasWidth, VertexNormal.canvasHeight, var1);
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(Lhz;I)V",
      garbageValue = "1922371565"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:VertexNormal.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = Huffman.canvasWidth;
         var4 = VertexNormal.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class89.method1666(var1, var3, var4, false);
      class60.method985(var1, var3, var4);
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1302953646"
   )
   final void method1140() {
      class33.method344(field1064);
      ++FriendLoginUpdate.field751;
      if(field1009 && field992) {
         int var1 = MouseInput.field679;
         int var2 = MouseInput.field682 * -469125321;
         var1 -= field889;
         var2 -= field943;
         if(var1 < field1007) {
            var1 = field1007;
         }

         if(var1 + field1064.width > field1007 + field1002.width) {
            var1 = field1007 + field1002.width - field1064.width;
         }

         if(var2 < field950) {
            var2 = field950;
         }

         if(var2 + field1064.height > field950 + field1002.height) {
            var2 = field950 + field1002.height - field1064.height;
         }

         int var3 = var1 - field1010;
         int var4 = var2 - field1011;
         int var5 = field1064.field2835;
         if(FriendLoginUpdate.field751 > field1064.field2884 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1012 = true;
         }

         int var6 = var1 - field1007 + field1002.scrollX;
         int var7 = var2 - field950 + field1002.scrollY;
         ScriptEvent var8;
         if(field1064.field2848 != null && field1012) {
            var8 = new ScriptEvent();
            var8.widget = field1064;
            var8.field771 = var6;
            var8.field772 = var7;
            var8.objs = field1064.field2848;
            CacheFile.method2350(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(field1012) {
               if(field1064.field2849 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1064;
                  var8.field771 = var6;
                  var8.field772 = var7;
                  var8.field776 = field1005;
                  var8.objs = field1064.field2849;
                  CacheFile.method2350(var8);
               }

               if(field1005 != null) {
                  Widget var9 = field1064;
                  int var10 = Widget.method4188(class36.getWidgetConfig(var9));
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

                        var9 = VertexNormal.getWidget(var9.parentId);
                        if(var9 == null) {
                           var13 = null;
                           break;
                        }

                        ++var11;
                     }
                  }

                  if(var13 != null) {
                     PacketNode var12 = FileSystem.bufferForSize(ClientPacket.field2321, signlink.field1449);
                     var12.packetBuffer.method3306(field1064.id);
                     var12.packetBuffer.putShort(field1064.index);
                     var12.packetBuffer.putShortLE(field1005.itemId);
                     var12.packetBuffer.method3306(field1005.id);
                     var12.packetBuffer.writeShortLE(field1005.index);
                     var12.packetBuffer.putShort(field1064.itemId);
                     signlink.method1862(var12);
                  }
               }
            } else if(this.method1136()) {
               this.openMenu(field889 + field1010, field943 + field1011);
            } else if(menuOptionCount > 0) {
               WorldMapMappings.method628(field1010 + field889, field943 + field1011);
            }

            field1064 = null;
         }

      } else {
         if(FriendLoginUpdate.field751 > 1) {
            field1064 = null;
         }

      }
   }

   @ObfuscatedName("a")
   public static String method1457(long var0) {
      class193.field2562.setTime(new Date(var0));
      int var2 = class193.field2562.get(7);
      int var3 = class193.field2562.get(5);
      int var4 = class193.field2562.get(2);
      int var5 = class193.field2562.get(1);
      int var6 = class193.field2562.get(11);
      int var7 = class193.field2562.get(12);
      int var8 = class193.field2562.get(13);
      return class193.field2561[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class193.field2563[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Ljn;",
      garbageValue = "112"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "1570138462"
   )
   @Export("cs2_2600s")
   static int cs2_2600s(int var0, Script var1, boolean var2) {
      Widget var3 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
      if(var0 == 2600) {
         class82.intStack[++class82.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class82.intStack[++class82.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class82.intStack[++class82.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class82.intStack[++class82.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class82.intStack[++class82.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         class82.intStack[++class82.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class82.intStack[++class82.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class82.intStack[++class82.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class82.intStack[++class82.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class82.intStack[++class82.intStackSize - 1] = var3.field2874;
         return 1;
      } else if(var0 == 2611) {
         class82.intStack[++class82.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class82.intStack[++class82.intStackSize - 1] = var3.field2785;
         return 1;
      } else if(var0 == 2613) {
         class82.intStack[++class82.intStackSize - 1] = var3.field2789.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
