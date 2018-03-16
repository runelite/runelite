import java.io.File;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements class302 {
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 1345661747
   )
   static int field1026;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1108723771
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      longValue = 3118159769713057027L
   )
   static long field1059;
   @ObfuscatedName("nc")
   static boolean[] field1051;
   @ObfuscatedName("nj")
   static boolean[] field1053;
   @ObfuscatedName("nt")
   static boolean[] field904;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -924663017
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("ny")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("rh")
   @ObfuscatedGetter(
      intValue = -244859051
   )
   public static int field1114;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 51550435
   )
   static int field1039;
   @ObfuscatedName("oe")
   static boolean field956;
   @ObfuscatedName("mf")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -1262227893
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("nw")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("nk")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 784993213
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("nl")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ni")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("rp")
   static int[] field1118;
   @ObfuscatedName("re")
   static int[] field1119;
   @ObfuscatedName("rn")
   @ObfuscatedSignature(
      signature = "Lbv;"
   )
   static final class71 field1117;
   @ObfuscatedName("me")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   static Deque field1045;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 211065985
   )
   static int field981;
   @ObfuscatedName("rk")
   static ArrayList field1023;
   @ObfuscatedName("rm")
   @ObfuscatedGetter(
      intValue = -1117668251
   )
   static int field1116;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 1755842247
   )
   static int field1083;
   @ObfuscatedName("px")
   static boolean field851;
   @ObfuscatedName("pf")
   static boolean[] field1091;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -877704141
   )
   static int field1063;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1973211243
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("mk")
   static int[] field1032;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 588839031
   )
   static int field1033;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 1517857259
   )
   static int field1080;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 348193561
   )
   static int field1110;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 272967883
   )
   static int field1079;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      longValue = 1303448591199766015L
   )
   static long field1070;
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   static PlayerComposition field1109;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = 869469469
   )
   static int field1111;
   @ObfuscatedName("oj")
   @ObfuscatedGetter(
      intValue = 855710501
   )
   static int field1071;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 1098821161
   )
   @Export("queuedSoundEffectCount")
   static int queuedSoundEffectCount;
   @ObfuscatedName("po")
   @Export("queuedSoundEffectIDs")
   static int[] queuedSoundEffectIDs;
   @ObfuscatedName("pe")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("pt")
   @Export("unknownSoundValues2")
   static int[] unknownSoundValues2;
   @ObfuscatedName("ph")
   @ObfuscatedSignature(
      signature = "[Lck;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 1062284919
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("pl")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = -1922815723
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("mg")
   static int[] field894;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 944997939
   )
   static int field1003;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 1491953235
   )
   static int field1037;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 743366951
   )
   static int field899;
   @ObfuscatedName("mu")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = -644244849
   )
   static int field1048;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = -301241853
   )
   static int field1035;
   @ObfuscatedName("nx")
   static long[] field1065;
   @ObfuscatedName("ou")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1663138223
   )
   static int field1066;
   @ObfuscatedName("ov")
   static int[] field1073;
   @ObfuscatedName("od")
   static int[] field861;
   @ObfuscatedName("qk")
   static short field1097;
   @ObfuscatedName("qw")
   static short field1052;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -1107398325
   )
   static int field869;
   @ObfuscatedName("qf")
   static short field1102;
   @ObfuscatedName("qa")
   static short field1103;
   @ObfuscatedName("qd")
   static short field1101;
   @ObfuscatedName("qu")
   static short field1099;
   @ObfuscatedName("qr")
   static short field922;
   @ObfuscatedName("qm")
   static short field1100;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -180019799
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("pb")
   static int[] field1092;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 1858031039
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("qh")
   static int[] field1093;
   @ObfuscatedName("ql")
   static int[] field1094;
   @ObfuscatedName("qs")
   static int[] field1096;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = -976051999
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("ol")
   static int[] field1069;
   @ObfuscatedName("mh")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   static Deque field1046;
   @ObfuscatedName("or")
   static int[] field1068;
   @ObfuscatedName("ml")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   static Deque field1047;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 1465124157
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 399843099
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -206107611
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -44575271
   )
   static int field913;
   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "[Lk;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = -487344385
   )
   static int field1057;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -1663633151
   )
   static int field892;
   @ObfuscatedName("nz")
   static String field1064;
   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "Lbu;"
   )
   static OwnWorldComparator field1113;
   @ObfuscatedName("ne")
   static int[] field928;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfa;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("ad")
   static boolean field889;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 91654439
   )
   @Export("world")
   public static int world;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1606728987
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1721224331
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   static JagexGame field852;
   @ObfuscatedName("bm")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bh")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 472429785
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1804205789
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("bq")
   static boolean field949;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 2030486699
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      longValue = -2050626005704883933L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 679065349
   )
   static int field860;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -2042685549
   )
   static int field946;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1159635657
   )
   static int field1007;
   @ObfuscatedName("bu")
   static boolean field863;
   @ObfuscatedName("bl")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1574725903
   )
   static int field865;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -342200777
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -72615453
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 1155888817
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1018887393
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 714202543
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1618904797
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -1093573955
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1223732539
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -1624202401
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -291952173
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1598484817
   )
   static int field879;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -1611992441
   )
   static int field882;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = 1156380385
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -1502076389
   )
   static int field884;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -404505505
   )
   static int field848;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 597224083
   )
   static int field886;
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   static class158 field887;
   @ObfuscatedName("de")
   static byte[] field888;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "[Lch;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -1212101201
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("ds")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -620226191
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("eb")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   public static final NetWriter field1072;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = -738268917
   )
   static int field1036;
   @ObfuscatedName("ed")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ew")
   static boolean field1067;
   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static class294 field898;
   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   @Export("fonts")
   static Fonts fonts;
   @ObfuscatedName("es")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1535051025
   )
   static int field901;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -612764469
   )
   static int field902;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 1703270767
   )
   static int field934;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 1033118603
   )
   static int field1087;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 1392286069
   )
   static int field905;
   @ObfuscatedName("fl")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("ft")
   @Export("instanceTemplateChunks")
   static int[][][] instanceTemplateChunks;
   @ObfuscatedName("fb")
   static final int[] field909;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 282909235
   )
   static int field910;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 1520483463
   )
   static int field911;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1777896019
   )
   static int field1042;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1961722409
   )
   static int field907;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 1849470443
   )
   static int field914;
   @ObfuscatedName("gd")
   static boolean field915;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 1099232595
   )
   static int field1018;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 603031781
   )
   @Export("cameraPitchTarget")
   static int cameraPitchTarget;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -320954557
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -1977688959
   )
   static int field919;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -622371211
   )
   static int field920;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1714530041
   )
   static int field1041;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 294885501
   )
   static int field1082;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -1777436003
   )
   static int field923;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 1058350099
   )
   static int field924;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -64603113
   )
   static int field925;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 115103237
   )
   static int field871;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1097978371
   )
   static int field927;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = 897998447
   )
   static int field1115;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 1756389825
   )
   static int field857;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 1138577557
   )
   static int field930;
   @ObfuscatedName("hz")
   static boolean field954;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -666591607
   )
   static int field932;
   @ObfuscatedName("he")
   static boolean field995;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -1394329663
   )
   static int field992;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 60773457
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 1857505031
   )
   static int field936;
   @ObfuscatedName("hf")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("hh")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("hw")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("hn")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("ha")
   static int[] field978;
   @ObfuscatedName("hg")
   static int[] field942;
   @ObfuscatedName("hc")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("hs")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("hl")
   static int[][] field1078;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 68623703
   )
   static int field1043;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 572123569
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -2109471757
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 1624637747
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1645076847
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 1830523199
   )
   static int field1088;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -1606562095
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("ho")
   static boolean field953;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -1245061415
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -1755158949
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -998470043
   )
   static int field998;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -544549471
   )
   static int field957;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 1222624825
   )
   static int field958;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 764106237
   )
   static int field1090;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("iw")
   static boolean field960;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = -1611816681
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -868742559
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("ir")
   static boolean field963;
   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "[Lbi;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 1009101641
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 905831613
   )
   static int field966;
   @ObfuscatedName("iu")
   static boolean field967;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -1420231581
   )
   static int field968;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -1771055337
   )
   static int field969;
   @ObfuscatedName("jg")
   static int[] field970;
   @ObfuscatedName("ji")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("ja")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("jn")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("jj")
   static int[] field881;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1268203451
   )
   static int field890;
   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "[[[Lhf;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("jb")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jx")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("jr")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -340407431
   )
   static int field1022;
   @ObfuscatedName("jl")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 1486353277
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("kw")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("kf")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("kk")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ka")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("ko")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("kd")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("kc")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("kg")
   static boolean field993;
   @ObfuscatedName("ki")
   static boolean field994;
   @ObfuscatedName("kv")
   static boolean field877;
   @ObfuscatedName("ky")
   static boolean field996;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 361553513
   )
   static int field1004;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 24296525
   )
   static int field1089;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -659576441
   )
   static int field999;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -674128695
   )
   static int field1000;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 2094221981
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("kl")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -124105747
   )
   static int field1050;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -1835900309
   )
   static int field980;
   @ObfuscatedName("lj")
   static String field1006;
   @ObfuscatedName("lw")
   static String field1074;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -555288401
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lt")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 185252691
   )
   static int field1010;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 947177531
   )
   static int field1011;
   @ObfuscatedName("ls")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static Widget field1012;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 682841453
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -830557701
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = 1897930685
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1818861269
   )
   static int field1016;
   @ObfuscatedName("lb")
   static boolean field1017;
   @ObfuscatedName("lz")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static Widget field1061;
   @ObfuscatedName("ln")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   @Export("draggedWidget")
   static Widget draggedWidget;
   @ObfuscatedName("lm")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static Widget field1020;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -1643524351
   )
   static int field1021;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 76951549
   )
   static int field1015;
   @ObfuscatedName("ld")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   @Export("draggedOnWidget")
   static Widget draggedOnWidget;
   @ObfuscatedName("lk")
   static boolean field1024;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -1905564395
   )
   static int field1025;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -2118473521
   )
   static int field1098;
   @ObfuscatedName("lg")
   static boolean field1095;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -1826269025
   )
   static int field1028;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 587896159
   )
   static int field944;
   @ObfuscatedName("lr")
   @Export("draggingWidget")
   static boolean draggingWidget;

   static {
      field889 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field949 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = -1L;
      field860 = -1;
      field946 = -1;
      field1007 = -1;
      field863 = true;
      displayFps = false;
      field865 = 0;
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
      field879 = 0;
      field882 = 0;
      loginState = 0;
      field884 = 0;
      field848 = 0;
      field886 = 0;
      field887 = class158.field2124;
      field888 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field1072 = new NetWriter();
      field1036 = 0;
      socketError = false;
      field1067 = true;
      field898 = new class294();
      fontsMap = new HashMap();
      field901 = 0;
      field902 = 1;
      field934 = 0;
      field1087 = 1;
      field905 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      instanceTemplateChunks = new int[4][13][13];
      field909 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field910 = 0;
      field911 = 2301979;
      field1042 = 5063219;
      field907 = 3353893;
      field914 = 7759444;
      field915 = false;
      field1018 = 0;
      cameraPitchTarget = 128;
      mapAngle = 0;
      field919 = 0;
      field920 = 0;
      field1041 = 0;
      field1082 = 0;
      field923 = 0;
      field924 = 50;
      field925 = 0;
      field871 = 0;
      field927 = 0;
      field1115 = 12;
      field857 = 6;
      field930 = 0;
      field954 = false;
      field932 = 0;
      field995 = false;
      field992 = 0;
      overheadTextCount = 0;
      field936 = 50;
      overheadTextsX = new int[field936];
      overheadTextsY = new int[field936];
      overheadTextsOffsetY = new int[field936];
      overheadTextsOffsetX = new int[field936];
      field978 = new int[field936];
      field942 = new int[field936];
      overheadTextsCyclesRemaining = new int[field936];
      overheadTexts = new String[field936];
      field1078 = new int[104][104];
      field1043 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field1088 = 0;
      cursorState = 0;
      field953 = true;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field998 = 0;
      field957 = 0;
      field958 = 0;
      field1090 = 0;
      field960 = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      field963 = true;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field966 = 0;
      field967 = true;
      field968 = 0;
      field969 = 0;
      field970 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field881 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field890 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1022 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field993 = false;
      field994 = false;
      field877 = false;
      field996 = true;
      field1004 = -1;
      field1089 = -1;
      field999 = 0;
      field1000 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field1050 = -1;
      field980 = -1;
      field1006 = null;
      field1074 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1010 = 0;
      field1011 = 0;
      field1012 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1016 = -1;
      field1017 = false;
      field1061 = null;
      draggedWidget = null;
      field1020 = null;
      field1021 = 0;
      field1015 = 0;
      draggedOnWidget = null;
      field1024 = false;
      field1025 = -1;
      field1098 = -1;
      field1095 = false;
      field1028 = -1;
      field944 = -1;
      draggingWidget = false;
      cycleCntr = 1;
      field1032 = new int[32];
      field1033 = 0;
      interfaceItemTriggers = new int[32];
      field1035 = 0;
      field894 = new int[32];
      field1037 = 0;
      chatCycle = 0;
      field1039 = 0;
      field892 = 0;
      field1057 = 0;
      field913 = 0;
      field981 = 0;
      mouseWheelRotation = 0;
      field1045 = new Deque();
      field1046 = new Deque();
      field1047 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field1026 = -2;
      field1051 = new boolean[100];
      field904 = new boolean[100];
      field1053 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1059 = 0L;
      isResized = true;
      field928 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field1063 = 0;
      field1064 = "";
      field1065 = new long[100];
      field1066 = 0;
      field869 = 0;
      field1068 = new int[128];
      field1069 = new int[128];
      field1070 = -1L;
      field1071 = -1;
      field1048 = 0;
      field1073 = new int[1000];
      field861 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1003 = 0;
      field1079 = 255;
      field1080 = -1;
      field956 = false;
      field899 = 127;
      field1083 = 127;
      queuedSoundEffectCount = 0;
      queuedSoundEffectIDs = new int[50];
      unknownSoundValues1 = new int[50];
      unknownSoundValues2 = new int[50];
      soundLocations = new int[50];
      audioEffects = new SoundEffect[50];
      field851 = false;
      field1091 = new boolean[5];
      field1092 = new int[5];
      field1093 = new int[5];
      field1094 = new int[5];
      field1096 = new int[5];
      field1052 = 256;
      field1097 = 205;
      field922 = 256;
      field1099 = 320;
      field1100 = 1;
      field1101 = 32767;
      field1102 = 1;
      field1103 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      scale = 0;
      field1109 = new PlayerComposition();
      field1110 = -1;
      field1111 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1113 = new OwnWorldComparator();
      field1114 = -1;
      field1023 = new ArrayList(10);
      field1116 = 0;
      field1117 = new class71();
      field1118 = new int[50];
      field1119 = new int[50];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-823924703"
   )
   protected final void vmethod1265() {
      field1059 = WorldMapRegion.method465() + 500L;
      this.method1266();
      if(widgetRoot != -1) {
         this.method1272(true);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1938638739"
   )
   @Export("setUp")
   protected final void setUp() {
      int[] var1 = new int[]{20, 260, 10000};
      int[] var2 = new int[]{1000, 100, 500};
      if(var1 != null && var2 != null) {
         CombatInfo1.field1202 = var1;
         class195.field2558 = new int[var1.length];
         class195.field2559 = new byte[var1.length][][];

         for(int var3 = 0; var3 < CombatInfo1.field1202.length; ++var3) {
            class195.field2559[var3] = new byte[var2[var3]][];
         }
      } else {
         CombatInfo1.field1202 = null;
         class195.field2558 = null;
         class195.field2559 = null;
      }

      class110.port1 = socketType == 0?43594:world + 40000;
      Player.port2 = socketType == 0?443:world + 50000;
      class85.myWorldPort = class110.port1;
      PlayerComposition.colorsToFind = class240.field2795;
      PlayerComposition.colorsToReplace = class240.field2797;
      WorldComparator.field260 = class240.field2801;
      PlayerComposition.field2789 = class240.field2796;
      MapIconReference.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      class45.mouseWheel = this.mouseWheel();
      PacketNode.indexStore255 = new IndexFile(255, class167.dat2File, class167.idx255File, 500000);
      FileOnDisk var4 = null;
      Preferences var5 = new Preferences();

      try {
         var4 = class297.getPreferencesFile("", field852.name, false);
         byte[] var6 = new byte[(int)var4.length()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.read(var6, var7, var6.length - var7);
            if(var8 == -1) {
               throw new IOException();
            }
         }

         var5 = new Preferences(new Buffer(var6));
      } catch (Exception var11) {
         ;
      }

      try {
         if(var4 != null) {
            var4.close();
         }
      } catch (Exception var10) {
         ;
      }

      MapIcon.preferences = var5;
      this.setUpClipboard();
      class150.method3117(this, BoundingBox3DDrawMode.field253);
      if(socketType != 0) {
         displayFps = true;
      }

      MapIcon.method591(MapIcon.preferences.screenType);
      WallObject.friendManager = new FriendManager(KeyFocusListener.loginType);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "331738257"
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
            class153.method3134();
            MapIcon.method588();
            WorldMapType1.method288();
            class20.method164();
            if(class45.mouseWheel != null) {
               int var4 = class45.mouseWheel.useRotation();
               mouseWheelRotation = var4;
            }

            if(gameState == 0) {
               class88.load();
               BoundingBox2D.method36();
            } else if(gameState == 5) {
               class195.method3768(this);
               class88.load();
               BoundingBox2D.method36();
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class195.method3768(this);
                  this.method1263();
               } else if(gameState == 25) {
                  Player.method1223();
               }
            } else {
               class195.method3768(this);
            }

            if(gameState == 30) {
               this.method1552();
            } else if(gameState == 40 || gameState == 45) {
               this.method1263();
            }

            return;
         }

         var1.data.load(var1.index, (int)var1.hash, var1.field3367, false);
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "287492788"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2 = FontName.method5475();
      if(var2 && field956 && WorldComparator.soundSystem0 != null) {
         WorldComparator.soundSystem0.tryFlush();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1059 && WorldMapRegion.method465() > field1059) {
         MapIcon.method591(SoundTaskDataProvider.method838());
      }

      int var3;
      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1051[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class90.loadingBarPercentage, class90.loadingText, var1);
      } else if(gameState == 5) {
         class49.drawLoginScreen(class5.fontBold12, class178.fontPlain11, class178.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class49.drawLoginScreen(class5.fontBold12, class178.fontPlain11, class178.font_p12full, var1);
         } else if(gameState == 25) {
            if(field905 == 1) {
               if(field901 > field902) {
                  field902 = field901;
               }

               var3 = (field902 * 50 - field901 * 50) / field902;
               class21.method166("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field905 == 2) {
               if(field934 > field1087) {
                  field1087 = field934;
               }

               var3 = (field1087 * 50 - field934 * 50) / field1087 + 50;
               class21.method166("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               class21.method166("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1358();
         } else if(gameState == 40) {
            class21.method166("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class21.method166("Please wait...", false);
         }
      } else {
         class49.drawLoginScreen(class5.fontBold12, class178.fontPlain11, class178.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < widgetCount; ++var3) {
            if(field904[var3]) {
               KeyFocusListener.rasterProvider.draw(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field904[var3] = false;
            }
         }
      } else if(gameState > 0) {
         KeyFocusListener.rasterProvider.drawFull(0, 0);

         for(var3 = 0; var3 < widgetCount; ++var3) {
            field904[var3] = false;
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   protected final void vmethod1535() {
      if(BoundingBox.chatMessages.changed()) {
         BoundingBox.chatMessages.serialize();
      }

      if(WidgetNode.mouseRecorder != null) {
         WidgetNode.mouseRecorder.isRunning = false;
      }

      WidgetNode.mouseRecorder = null;
      field1072.close();
      WorldMapType1.method285();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      class45.mouseWheel = null;
      if(WorldComparator.soundSystem0 != null) {
         WorldComparator.soundSystem0.shutdown();
      }

      if(class195.soundSystem1 != null) {
         class195.soundSystem1.shutdown();
      }

      if(SoundTaskDataProvider.NetCache_socket != null) {
         SoundTaskDataProvider.NetCache_socket.vmethod3339();
      }

      class37.method541();
      if(MapIconReference.urlRequester != null) {
         MapIconReference.urlRequester.close();
         MapIconReference.urlRequester = null;
      }

      try {
         class167.dat2File.close();

         for(int var3 = 0; var3 < class167.idxCount; ++var3) {
            WorldMapManager.idxFiles[var3].close();
         }

         class167.idx255File.close();
         class167.randomDat.close();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "40"
   )
   protected final void vmethod1354() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      try {
         if(this.isValidHost()) {
            Parameters[] var1 = Timer.method3332();

            int var6;
            for(int var2 = 0; var2 < var1.length; ++var2) {
               Parameters var3 = var1[var2];
               String var4 = this.getParameter(var3.key);
               if(var4 != null) {
                  switch(Integer.parseInt(var3.key)) {
                  case 1:
                     GrandExchangeOffer.field290 = var4;
                     break;
                  case 2:
                     flags = Integer.parseInt(var4);
                     break;
                  case 3:
                     field852 = (JagexGame)WorldMapRectangle.forOrdinal(class246.method4530(), Integer.parseInt(var4));
                     if(field852 == JagexGame.field3363) {
                        KeyFocusListener.loginType = JagexLoginType.field4075;
                     } else {
                        KeyFocusListener.loginType = JagexLoginType.field4069;
                     }
                     break;
                  case 4:
                     Enum.field3558 = Integer.parseInt(var4);
                     break;
                  case 5:
                     languageId = Integer.parseInt(var4);
                     break;
                  case 6:
                     Projectile.sessionToken = var4;
                     break;
                  case 7:
                     if(var4.equalsIgnoreCase("true")) {
                        ;
                     }
                  case 8:
                  case 10:
                  case 15:
                  default:
                     break;
                  case 9:
                     field1067 = Integer.parseInt(var4) != 0;
                     break;
                  case 11:
                     var6 = Integer.parseInt(var4);
                     BuildType[] var7 = new BuildType[]{BuildType.WIP, BuildType.LIVE, BuildType.RC, BuildType.BUILD_LIVE};
                     BuildType[] var8 = var7;
                     int var9 = 0;

                     BuildType var5;
                     while(true) {
                        if(var9 >= var8.length) {
                           var5 = null;
                           break;
                        }

                        BuildType var10 = var8[var9];
                        if(var6 == var10.field3357) {
                           var5 = var10;
                           break;
                        }

                        ++var9;
                     }

                     class1.field1 = var5;
                     break;
                  case 12:
                     if(var4.equalsIgnoreCase("true")) {
                        isMembers = true;
                     } else {
                        isMembers = false;
                     }
                     break;
                  case 13:
                     socketType = Integer.parseInt(var4);
                     break;
                  case 14:
                     world = Integer.parseInt(var4);
                     break;
                  case 16:
                     class64.field739 = Integer.parseInt(var4);
                  }
               }
            }

            MapLabel.method384();
            GrandExchangeEvent.host = this.getCodeBase().getHost();
            String var17 = class1.field1.identifier;
            byte var18 = 0;

            try {
               class167.idxCount = 17;
               WorldMapType2.field507 = var18;

               try {
                  class44.osName = System.getProperty("os.name");
               } catch (Exception var14) {
                  class44.osName = "Unknown";
               }

               class167.osNameLC = class44.osName.toLowerCase();

               try {
                  class167.userHome = System.getProperty("user.home");
                  if(class167.userHome != null) {
                     class167.userHome = class167.userHome + "/";
                  }
               } catch (Exception var13) {
                  ;
               }

               try {
                  if(class167.osNameLC.startsWith("win")) {
                     if(class167.userHome == null) {
                        class167.userHome = System.getenv("USERPROFILE");
                     }
                  } else if(class167.userHome == null) {
                     class167.userHome = System.getenv("HOME");
                  }

                  if(class167.userHome != null) {
                     class167.userHome = class167.userHome + "/";
                  }
               } catch (Exception var12) {
                  ;
               }

               if(class167.userHome == null) {
                  class167.userHome = "~/";
               }

               class19.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class167.userHome, "/tmp/", ""};
               class169.field2186 = new String[]{".jagex_cache_" + WorldMapType2.field507, ".file_store_" + WorldMapType2.field507};

               int var11;
               label127:
               for(var11 = 0; var11 < 4; ++var11) {
                  UrlRequest.field2092 = FrameMap.method2864("oldschool", var17, var11);
                  if(!UrlRequest.field2092.exists()) {
                     UrlRequest.field2092.mkdirs();
                  }

                  File[] var19 = UrlRequest.field2092.listFiles();
                  if(var19 == null) {
                     break;
                  }

                  File[] var20 = var19;
                  var6 = 0;

                  while(true) {
                     if(var6 >= var20.length) {
                        break label127;
                     }

                     File var21 = var20[var6];
                     if(!KeyFocusListener.method829(var21, false)) {
                        break;
                     }

                     ++var6;
                  }
               }

               class85.method1908(UrlRequest.field2092);
               NPC.method1902();
               class167.dat2File = new CacheFile(new FileOnDisk(Enum.method4950("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
               class167.idx255File = new CacheFile(new FileOnDisk(Enum.method4950("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
               WorldMapManager.idxFiles = new CacheFile[class167.idxCount];

               for(var11 = 0; var11 < class167.idxCount; ++var11) {
                  WorldMapManager.idxFiles[var11] = new CacheFile(new FileOnDisk(Enum.method4950("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
               }
            } catch (Exception var15) {
               GroundObject.processClientError((String)null, var15);
            }

            class249.clientInstance = this;
            this.initialize(765, 503, 166);
         }
      } catch (RuntimeException var16) {
         throw class80.method1801(var16, "client.init(" + ')');
      }
   }

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1956514214"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         long var2 = WorldMapRegion.method465();
         int var4 = (int)(var2 - class151.field2101);
         class151.field2101 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class264.field3417 += var4;
         boolean var1;
         if(class264.NetCache_pendingResponsesCount == 0 && class264.NetCache_pendingPriorityResponsesCount == 0 && class264.NetCache_pendingWritesCount == 0 && class264.NetCache_pendingPriorityWritesCount == 0) {
            var1 = true;
         } else if(SoundTaskDataProvider.NetCache_socket == null) {
            var1 = false;
         } else {
            try {
               label241: {
                  if(class264.field3417 > 30000) {
                     throw new IOException();
                  }

                  FileRequest var5;
                  Buffer var6;
                  while(class264.NetCache_pendingPriorityResponsesCount < 200 && class264.NetCache_pendingPriorityWritesCount > 0) {
                     var5 = (FileRequest)class264.NetCache_pendingPriorityWrites.first();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     SoundTaskDataProvider.NetCache_socket.vmethod3340(var6.payload, 0, 4);
                     class264.NetCache_pendingPriorityResponses.put(var5, var5.hash);
                     --class264.NetCache_pendingPriorityWritesCount;
                     ++class264.NetCache_pendingPriorityResponsesCount;
                  }

                  while(class264.NetCache_pendingResponsesCount < 200 && class264.NetCache_pendingWritesCount > 0) {
                     var5 = (FileRequest)class264.NetCache_pendingWritesQueue.peek();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     SoundTaskDataProvider.NetCache_socket.vmethod3340(var6.payload, 0, 4);
                     var5.unlinkDual();
                     class264.NetCache_pendingResponses.put(var5, var5.hash);
                     --class264.NetCache_pendingWritesCount;
                     ++class264.NetCache_pendingResponsesCount;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = SoundTaskDataProvider.NetCache_socket.vmethod3336();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class264.field3417 = 0;
                     byte var7 = 0;
                     if(Signlink.currentRequest == null) {
                        var7 = 8;
                     } else if(class264.field3424 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class264.NetCache_responseHeaderBuffer.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        SoundTaskDataProvider.NetCache_socket.vmethod3338(class264.NetCache_responseHeaderBuffer.payload, class264.NetCache_responseHeaderBuffer.offset, var8);
                        if(class264.field3427 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class264.NetCache_responseHeaderBuffer.payload[class264.NetCache_responseHeaderBuffer.offset + var9] ^= class264.field3427;
                           }
                        }

                        class264.NetCache_responseHeaderBuffer.offset += var8;
                        if(class264.NetCache_responseHeaderBuffer.offset < var7) {
                           break;
                        }

                        if(Signlink.currentRequest == null) {
                           class264.NetCache_responseHeaderBuffer.offset = 0;
                           var9 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var10 = class264.NetCache_responseHeaderBuffer.readUnsignedShort();
                           int var11 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var12 = class264.NetCache_responseHeaderBuffer.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           FileRequest var15 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var13);
                           class264.field3422 = true;
                           if(var15 == null) {
                              var15 = (FileRequest)class264.NetCache_pendingResponses.get(var13);
                              class264.field3422 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           Signlink.currentRequest = var15;
                           CacheFile.NetCache_responseArchiveBuffer = new Buffer(var12 + var16 + Signlink.currentRequest.padding);
                           CacheFile.NetCache_responseArchiveBuffer.putByte(var11);
                           CacheFile.NetCache_responseArchiveBuffer.putInt(var12);
                           class264.field3424 = 8;
                           class264.NetCache_responseHeaderBuffer.offset = 0;
                        } else if(class264.field3424 == 0) {
                           if(class264.NetCache_responseHeaderBuffer.payload[0] == -1) {
                              class264.field3424 = 1;
                              class264.NetCache_responseHeaderBuffer.offset = 0;
                           } else {
                              Signlink.currentRequest = null;
                           }
                        }
                     } else {
                        var8 = CacheFile.NetCache_responseArchiveBuffer.payload.length - Signlink.currentRequest.padding;
                        var9 = 512 - class264.field3424;
                        if(var9 > var8 - CacheFile.NetCache_responseArchiveBuffer.offset) {
                           var9 = var8 - CacheFile.NetCache_responseArchiveBuffer.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        SoundTaskDataProvider.NetCache_socket.vmethod3338(CacheFile.NetCache_responseArchiveBuffer.payload, CacheFile.NetCache_responseArchiveBuffer.offset, var9);
                        if(class264.field3427 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              CacheFile.NetCache_responseArchiveBuffer.payload[CacheFile.NetCache_responseArchiveBuffer.offset + var10] ^= class264.field3427;
                           }
                        }

                        CacheFile.NetCache_responseArchiveBuffer.offset += var9;
                        class264.field3424 += var9;
                        if(var8 == CacheFile.NetCache_responseArchiveBuffer.offset) {
                           if(16711935L == Signlink.currentRequest.hash) {
                              class152.NetCache_reference = CacheFile.NetCache_responseArchiveBuffer;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var19 = class264.NetCache_indexCaches[var10];
                                 if(var19 != null) {
                                    class152.NetCache_reference.offset = var10 * 8 + 5;
                                    var12 = class152.NetCache_reference.readInt();
                                    int var20 = class152.NetCache_reference.readInt();
                                    var19.setInformation(var12, var20);
                                 }
                              }
                           } else {
                              class264.NetCache_crc.reset();
                              class264.NetCache_crc.update(CacheFile.NetCache_responseArchiveBuffer.payload, 0, var8);
                              var10 = (int)class264.NetCache_crc.getValue();
                              if(var10 != Signlink.currentRequest.crc) {
                                 try {
                                    SoundTaskDataProvider.NetCache_socket.vmethod3339();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class264.field3429;
                                 SoundTaskDataProvider.NetCache_socket = null;
                                 class264.field3427 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label241;
                              }

                              class264.field3429 = 0;
                              class264.field3413 = 0;
                              Signlink.currentRequest.index.write((int)(Signlink.currentRequest.hash & 65535L), CacheFile.NetCache_responseArchiveBuffer.payload, (Signlink.currentRequest.hash & 16711680L) == 16711680L, class264.field3422);
                           }

                           Signlink.currentRequest.unlink();
                           if(class264.field3422) {
                              --class264.NetCache_pendingPriorityResponsesCount;
                           } else {
                              --class264.NetCache_pendingResponsesCount;
                           }

                           class264.field3424 = 0;
                           Signlink.currentRequest = null;
                           CacheFile.NetCache_responseArchiveBuffer = null;
                        } else {
                           if(class264.field3424 != 512) {
                              break;
                           }

                           class264.field3424 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  SoundTaskDataProvider.NetCache_socket.vmethod3339();
               } catch (Exception var22) {
                  ;
               }

               ++class264.field3413;
               SoundTaskDataProvider.NetCache_socket = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1261();
         }

      }
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1112134816"
   )
   void method1261() {
      if(class264.field3429 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class264.field3413 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field879 = 3000;
            class264.field3413 = 3;
         }

         if(--field879 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  socket = GameEngine.taskManager.createSocket(GrandExchangeEvent.host, class85.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field1067) {
                     Socket var2 = (Socket)socket.value;
                     class171 var1 = new class171(var2, 40000, 5000);
                     class170.rssocket = var1;
                  } else {
                     class170.rssocket = new class173((Socket)socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var5 = new Buffer(5);
                  var5.putByte(15);
                  var5.putInt(166);
                  class170.rssocket.vmethod3340(var5.payload, 0, 5);
                  ++js5State;
                  class246.field2974 = WorldMapRegion.method465();
               }

               if(js5State == 3) {
                  if(class170.rssocket.vmethod3336() > 0 || !field1067 && gameState <= 5) {
                     int var3 = class170.rssocket.vmethod3335();
                     if(var3 != 0) {
                        this.error(var3);
                        return;
                     }

                     ++js5State;
                  } else if(WorldMapRegion.method465() - class246.field2974 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  Signlink.method3223(class170.rssocket, gameState > 20);
                  socket = null;
                  class170.rssocket = null;
                  js5State = 0;
                  field882 = 0;
               }
            } catch (IOException var4) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1042549205"
   )
   @Export("error")
   void error(int var1) {
      socket = null;
      class170.rssocket = null;
      js5State = 0;
      if(class85.myWorldPort == class110.port1) {
         class85.myWorldPort = Player.port2;
      } else {
         class85.myWorldPort = class110.port1;
      }

      ++field882;
      if(field882 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field879 = 3000;
         }
      } else if(field882 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field882 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field879 = 3000;
         }
      }

   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-55"
   )
   final void method1263() {
      Object var1 = field1072.getSocket();
      PacketBuffer var2 = field1072.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class169)var1).vmethod3339();
               var1 = null;
            }

            ISAACCipher.field2598 = null;
            socketError = false;
            field884 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(ISAACCipher.field2598 == null) {
               ISAACCipher.field2598 = GameEngine.taskManager.createSocket(GrandExchangeEvent.host, class85.myWorldPort);
            }

            if(ISAACCipher.field2598.status == 2) {
               throw new IOException();
            }

            if(ISAACCipher.field2598.status == 1) {
               if(field1067) {
                  Socket var4 = (Socket)ISAACCipher.field2598.value;
                  class171 var3 = new class171(var4, 40000, 5000);
                  var1 = var3;
               } else {
                  var1 = new class173((Socket)ISAACCipher.field2598.value, GameEngine.taskManager, 5000);
               }

               field1072.setSocket((class169)var1);
               ISAACCipher.field2598 = null;
               loginState = 2;
            }
         }

         PacketNode var19;
         if(loginState == 2) {
            field1072.method2067();
            var19 = UrlRequest.method3096();
            var19.packetBuffer.putByte(LoginPacket.field2453.id);
            field1072.method2073(var19);
            field1072.method2077();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var11;
         int var12;
         if(loginState == 3) {
            if(WorldComparator.soundSystem0 != null) {
               WorldComparator.soundSystem0.method2211();
            }

            if(class195.soundSystem1 != null) {
               class195.soundSystem1.method2211();
            }

            var11 = true;
            if(field1067 && !((class169)var1).vmethod3337(1)) {
               var11 = false;
            }

            if(var11) {
               var12 = ((class169)var1).vmethod3335();
               if(WorldComparator.soundSystem0 != null) {
                  WorldComparator.soundSystem0.method2211();
               }

               if(class195.soundSystem1 != null) {
                  class195.soundSystem1.method2211();
               }

               if(var12 != 0) {
                  ScriptVarType.method16(var12);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var28;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var28 = ((class169)var1).vmethod3336();
               if(var28 > 8 - var2.offset) {
                  var28 = 8 - var2.offset;
               }

               if(var28 > 0) {
                  ((class169)var1).vmethod3338(var2.payload, var2.offset, var28);
                  var2.offset += var28;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               SceneTilePaint.field1946 = var2.readLong();
               loginState = 5;
            }
         }

         int var8;
         int var13;
         if(loginState == 5) {
            field1072.packetBuffer.offset = 0;
            field1072.method2067();
            PacketBuffer var20 = new PacketBuffer(500);
            int[] var22 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(SceneTilePaint.field1946 >> 32), (int)(SceneTilePaint.field1946 & -1L)};
            var20.offset = 0;
            var20.putByte(1);
            var20.putByte(field887.rsOrdinal());
            var20.putInt(var22[0]);
            var20.putInt(var22[1]);
            var20.putInt(var22[2]);
            var20.putInt(var22[3]);
            switch(field887.field2128) {
            case 0:
            case 2:
               var20.put24bitInt(class80.field1251);
               var20.offset += 5;
               break;
            case 1:
               var20.putInt(((Integer)MapIcon.preferences.preferences.get(Integer.valueOf(class292.method5197(class90.username)))).intValue());
               var20.offset += 4;
               break;
            case 3:
               var20.offset += 8;
            }

            var20.putString(class90.password);
            var20.encryptRsa(class88.field1314, class88.field1315);
            PacketNode var6;
            if(PacketNode.field2473 == 0) {
               var6 = new PacketNode();
            } else {
               var6 = PacketNode.packetBufferNodes[--PacketNode.field2473];
            }

            var6.clientPacket = null;
            var6.field2469 = 0;
            var6.packetBuffer = new PacketBuffer(5000);
            var6.packetBuffer.offset = 0;
            if(gameState == 40) {
               var6.packetBuffer.putByte(LoginPacket.field2447.id);
            } else {
               var6.packetBuffer.putByte(LoginPacket.field2449.id);
            }

            var6.packetBuffer.putShort(0);
            var13 = var6.packetBuffer.offset;
            var6.packetBuffer.putInt(166);
            var6.packetBuffer.putBytes(var20.payload, 0, var20.offset);
            var8 = var6.packetBuffer.offset;
            var6.packetBuffer.putString(class90.username);
            var6.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var6.packetBuffer.putShort(WallObject.canvasWidth);
            var6.packetBuffer.putShort(GameEngine.canvasHeight);
            ScriptVarType.method22(var6.packetBuffer);
            var6.packetBuffer.putString(Projectile.sessionToken);
            var6.packetBuffer.putInt(Enum.field3558);
            Buffer var9 = new Buffer(BoundingBox3DDrawMode.platformInfo.method6190());
            BoundingBox3DDrawMode.platformInfo.method6183(var9);
            var6.packetBuffer.putBytes(var9.payload, 0, var9.payload.length);
            var6.packetBuffer.putByte(class64.field739);
            var6.packetBuffer.putInt(0);
            var6.packetBuffer.putInt(World.indexInterfaces.crc);
            var6.packetBuffer.putInt(ContextMenuRow.indexSoundEffects.crc);
            var6.packetBuffer.putInt(configsIndex.crc);
            var6.packetBuffer.putInt(class316.indexCache3.crc);
            var6.packetBuffer.putInt(WorldMapRectangle.indexCache4.crc);
            var6.packetBuffer.putInt(VertexNormal.indexMaps.crc);
            var6.packetBuffer.putInt(Varbit.indexTrack1.crc);
            var6.packetBuffer.putInt(class236.indexModels.crc);
            var6.packetBuffer.putInt(WorldMapRegion.indexSprites.crc);
            var6.packetBuffer.putInt(class62.indexTextures.crc);
            var6.packetBuffer.putInt(FileRequest.indexCache10.crc);
            var6.packetBuffer.putInt(class55.indexTrack2.crc);
            var6.packetBuffer.putInt(BoundingBox2D.indexScripts.crc);
            var6.packetBuffer.putInt(indexCache13.crc);
            var6.packetBuffer.putInt(FontName.vorbisIndex.crc);
            var6.packetBuffer.putInt(class64.indexCache15.crc);
            var6.packetBuffer.putInt(class196.indexWorldMap.crc);
            var6.packetBuffer.encryptXtea(var22, var8, var6.packetBuffer.offset);
            var6.packetBuffer.method3681(var6.packetBuffer.offset - var13);
            field1072.method2073(var6);
            field1072.method2077();
            field1072.field1456 = new ISAACCipher(var22);

            for(int var10 = 0; var10 < 4; ++var10) {
               var22[var10] += 50;
            }

            var2.seed(var22);
            loginState = 6;
         }

         if(loginState == 6 && ((class169)var1).vmethod3336() > 0) {
            var28 = ((class169)var1).vmethod3335();
            if(var28 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var28 == 2) {
               loginState = 9;
            } else if(var28 == 15 && gameState == 40) {
               field1072.packetLength = -1;
               loginState = 13;
            } else if(var28 == 23 && field848 < 1) {
               ++field848;
               loginState = 0;
            } else {
               if(var28 != 29) {
                  ScriptVarType.method16(var28);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class169)var1).vmethod3336() > 0) {
            field886 = (((class169)var1).vmethod3335() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field884 = 0;
            class93.method1974("You have only just left another world.", "Your profile will be transferred in:", field886 / 60 + " seconds.");
            if(--field886 <= 0) {
               loginState = 0;
            }

         } else {
            boolean var29;
            if(loginState == 9 && ((class169)var1).vmethod3336() >= 13) {
               var11 = ((class169)var1).vmethod3335() == 1;
               ((class169)var1).vmethod3338(var2.payload, 0, 4);
               var2.offset = 0;
               var29 = false;
               if(var11) {
                  var12 = var2.readOpcode() << 24;
                  var12 |= var2.readOpcode() << 16;
                  var12 |= var2.readOpcode() << 8;
                  var12 |= var2.readOpcode();
                  String var27 = class90.username;
                  var13 = var27.length();
                  var8 = 0;
                  int var14 = 0;

                  while(true) {
                     if(var14 >= var13) {
                        if(MapIcon.preferences.preferences.size() >= 10 && !MapIcon.preferences.preferences.containsKey(Integer.valueOf(var8))) {
                           Iterator var16 = MapIcon.preferences.preferences.entrySet().iterator();
                           var16.next();
                           var16.remove();
                        }

                        MapIcon.preferences.preferences.put(Integer.valueOf(var8), Integer.valueOf(var12));
                        break;
                     }

                     var8 = (var8 << 5) - var8 + var27.charAt(var14);
                     ++var14;
                  }
               }

               if(class90.Login_isUsernameRemembered) {
                  MapIcon.preferences.rememberedUsername = class90.username;
               } else {
                  MapIcon.preferences.rememberedUsername = null;
               }

               class37.method538();
               rights = ((class169)var1).vmethod3335();
               field1017 = ((class169)var1).vmethod3335() == 1;
               localInteractingIndex = ((class169)var1).vmethod3335();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class169)var1).vmethod3335();
               field966 = ((class169)var1).vmethod3335();
               ((class169)var1).vmethod3338(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = new ServerPacket[]{ServerPacket.field2303, ServerPacket.field2262, ServerPacket.field2263, ServerPacket.field2331, ServerPacket.field2265, ServerPacket.field2266, ServerPacket.field2294, ServerPacket.field2297, ServerPacket.field2280, ServerPacket.field2270, ServerPacket.field2271, ServerPacket.field2277, ServerPacket.field2273, ServerPacket.field2264, ServerPacket.field2275, ServerPacket.field2267, ServerPacket.field2305, ServerPacket.field2278, ServerPacket.field2279, ServerPacket.field2268, ServerPacket.field2281, ServerPacket.field2282, ServerPacket.field2283, ServerPacket.field2284, ServerPacket.field2285, ServerPacket.field2286, ServerPacket.field2287, ServerPacket.field2295, ServerPacket.field2289, ServerPacket.field2290, ServerPacket.field2276, ServerPacket.field2292, ServerPacket.field2293, ServerPacket.field2310, ServerPacket.field2336, ServerPacket.field2296, ServerPacket.field2300, ServerPacket.field2320, ServerPacket.field2338, ServerPacket.field2316, ServerPacket.field2301, ServerPacket.field2298, ServerPacket.field2274, ServerPacket.field2304, ServerPacket.field2330, ServerPacket.field2306, ServerPacket.field2307, ServerPacket.field2308, ServerPacket.field2313, ServerPacket.field2272, ServerPacket.field2311, ServerPacket.field2312, ServerPacket.field2328, ServerPacket.field2314, ServerPacket.field2315, ServerPacket.field2321, ServerPacket.field2317, ServerPacket.field2318, ServerPacket.field2319, ServerPacket.field2342, ServerPacket.field2302, ServerPacket.field2322, ServerPacket.field2323, ServerPacket.field2324, ServerPacket.field2325, ServerPacket.field2326, ServerPacket.field2327, ServerPacket.field2299, ServerPacket.field2329, ServerPacket.field2269, ServerPacket.field2309, ServerPacket.field2332, ServerPacket.field2333, ServerPacket.field2334, ServerPacket.field2335, ServerPacket.field2291, ServerPacket.field2337, ServerPacket.field2288, ServerPacket.field2339, ServerPacket.field2340, ServerPacket.field2341, ServerPacket.field2261, ServerPacket.field2343, ServerPacket.field2344};
               var13 = var2.method3826();
               if(var13 < 0 || var13 >= var5.length) {
                  throw new IOException(var13 + " " + var2.offset);
               }

               field1072.serverPacket = var5[var13];
               field1072.packetLength = field1072.serverPacket.packetLength;
               ((class169)var1).vmethod3338(var2.payload, 0, 2);
               var2.offset = 0;
               field1072.packetLength = var2.readUnsignedShort();

               try {
                  class53.method840(class249.clientInstance, "zap");
               } catch (Throwable var17) {
                  ;
               }

               loginState = 10;
            }

            if(loginState != 10) {
               if(loginState == 11 && ((class169)var1).vmethod3336() >= 2) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3338(var2.payload, 0, 2);
                  var2.offset = 0;
                  Size.field342 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class169)var1).vmethod3336() >= Size.field342) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3338(var2.payload, 0, Size.field342);
                  var2.offset = 0;
                  String var24 = var2.readString();
                  String var25 = var2.readString();
                  String var26 = var2.readString();
                  class93.method1974(var24, var25, var26);
                  class20.setGameState(10);
               }

               if(loginState == 13) {
                  if(field1072.packetLength == -1) {
                     if(((class169)var1).vmethod3336() < 2) {
                        return;
                     }

                     ((class169)var1).vmethod3338(var2.payload, 0, 2);
                     var2.offset = 0;
                     field1072.packetLength = var2.readUnsignedShort();
                  }

                  if(((class169)var1).vmethod3336() >= field1072.packetLength) {
                     ((class169)var1).vmethod3338(var2.payload, 0, field1072.packetLength);
                     var2.offset = 0;
                     var28 = field1072.packetLength;
                     field898.method5207();
                     class21.method173();
                     MessageNode.initializeGPI(var2);
                     if(var28 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field884;
                  if(field884 > 2000) {
                     if(field848 < 1) {
                        if(class110.port1 == class85.myWorldPort) {
                           class85.myWorldPort = Player.port2;
                        } else {
                           class85.myWorldPort = class110.port1;
                        }

                        ++field848;
                        loginState = 0;
                     } else {
                        ScriptVarType.method16(-3);
                     }
                  }
               }
            } else {
               if(((class169)var1).vmethod3336() >= field1072.packetLength) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3338(var2.payload, 0, field1072.packetLength);
                  field898.method5224();
                  mouseLastLastPressedTimeMillis = -1L;
                  field1007 = -1;
                  WidgetNode.mouseRecorder.index = 0;
                  Buffer.field2550 = true;
                  field863 = true;
                  field1070 = -1L;
                  class326.classInfos = new CombatInfoList();
                  field1072.method2067();
                  field1072.packetBuffer.offset = 0;
                  field1072.serverPacket = null;
                  field1072.field1463 = null;
                  field1072.field1457 = null;
                  field1072.field1465 = null;
                  field1072.packetLength = 0;
                  field1072.field1464 = 0;
                  field865 = 0;
                  field1036 = 0;
                  hintArrowTargetType = 0;
                  UnitPriceComparator.method130();
                  MouseInput.mouseIdleTicks = 0;
                  class173.method3363();
                  itemSelectionState = 0;
                  spellSelected = false;
                  queuedSoundEffectCount = 0;
                  mapAngle = 0;
                  field923 = 0;
                  NetWriter.field1467 = null;
                  field1003 = 0;
                  field1071 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  playerAttackOption = AttackOption.AttackOption_hidden;
                  npcAttackOption = AttackOption.AttackOption_hidden;
                  npcIndexesCount = 0;
                  class229.method4165();

                  for(var28 = 0; var28 < 2048; ++var28) {
                     cachedPlayers[var28] = null;
                  }

                  for(var28 = 0; var28 < 32768; ++var28) {
                     cachedNPCs[var28] = null;
                  }

                  field890 = -1;
                  projectiles.clear();
                  graphicsObjectDeque.clear();

                  int var15;
                  for(var28 = 0; var28 < 4; ++var28) {
                     for(var12 = 0; var12 < 104; ++var12) {
                        for(var15 = 0; var15 < 104; ++var15) {
                           groundItemDeque[var28][var12][var15] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  WallObject.friendManager.method1725();

                  for(var28 = 0; var28 < VarPlayerType.field3448; ++var28) {
                     VarPlayerType var23 = method1275(var28);
                     if(var23 != null) {
                        class237.settings[var28] = 0;
                        class237.widgetSettings[var28] = 0;
                     }
                  }

                  BoundingBox.chatMessages.reset();
                  field1016 = -1;
                  if(widgetRoot != -1) {
                     var28 = widgetRoot;
                     if(var28 != -1 && WorldComparator.validInterfaces[var28]) {
                        Widget.widgetIndex.method4589(var28);
                        if(Widget.widgets[var28] != null) {
                           var29 = true;

                           for(var15 = 0; var15 < Widget.widgets[var28].length; ++var15) {
                              if(Widget.widgets[var28][var15] != null) {
                                 if(Widget.widgets[var28][var15].type != 2) {
                                    Widget.widgets[var28][var15] = null;
                                 } else {
                                    var29 = false;
                                 }
                              }
                           }

                           if(var29) {
                              Widget.widgets[var28] = null;
                           }

                           WorldComparator.validInterfaces[var28] = false;
                        }
                     }
                  }

                  for(WidgetNode var21 = (WidgetNode)componentTable.first(); var21 != null; var21 = (WidgetNode)componentTable.next()) {
                     class93.closeWidget(var21, true);
                  }

                  widgetRoot = -1;
                  componentTable = new HashTable(8);
                  field1012 = null;
                  UnitPriceComparator.method130();
                  field1109.method4424((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var28 = 0; var28 < 8; ++var28) {
                     playerOptions[var28] = null;
                     playerOptionsPriorities[var28] = false;
                  }

                  UrlRequester.method3085();
                  field949 = true;

                  for(var28 = 0; var28 < 100; ++var28) {
                     field1051[var28] = true;
                  }

                  var19 = class33.method382(ClientPacket.field2427, field1072.field1456);
                  var19.packetBuffer.putByte(SoundTaskDataProvider.method838());
                  var19.packetBuffer.putShort(WallObject.canvasWidth);
                  var19.packetBuffer.putShort(GameEngine.canvasHeight);
                  field1072.method2073(var19);
                  KeyFocusListener.clanMemberManager = null;

                  for(var28 = 0; var28 < 8; ++var28) {
                     grandExchangeOffers[var28] = new GrandExchangeOffer();
                  }

                  Occluder.grandExchangeEvents = null;
                  MessageNode.initializeGPI(var2);
                  class49.field581 = -1;
                  class23.xteaChanged(false, var2);
                  field1072.serverPacket = null;
               }

            }
         }
      } catch (IOException var18) {
         if(field848 < 1) {
            if(class110.port1 == class85.myWorldPort) {
               class85.myWorldPort = Player.port2;
            } else {
               class85.myWorldPort = class110.port1;
            }

            ++field848;
            loginState = 0;
         } else {
            ScriptVarType.method16(-2);
         }
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-130067866"
   )
   final void method1552() {
      if(field865 > 1) {
         --field865;
      }

      if(field1036 > 0) {
         --field1036;
      }

      if(socketError) {
         socketError = false;
         class28.method253();
      } else {
         if(!isMenuOpen) {
            GrandExchangeEvents.method79();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1268(field1072); ++var1) {
            ;
         }

         if(gameState == 30) {
            int var2;
            PacketNode var15;
            while(class46.method717()) {
               var15 = class33.method382(ClientPacket.field2406, field1072.field1456);
               var15.packetBuffer.putByte(0);
               var2 = var15.packetBuffer.offset;
               WorldMapManager.encodeClassVerifier(var15.packetBuffer);
               var15.packetBuffer.method3534(var15.packetBuffer.offset - var2);
               field1072.method2073(var15);
            }

            if(field898.field3811) {
               var15 = class33.method382(ClientPacket.field2358, field1072.field1456);
               var15.packetBuffer.putByte(0);
               var2 = var15.packetBuffer.offset;
               field898.method5202(var15.packetBuffer);
               var15.packetBuffer.method3534(var15.packetBuffer.offset - var2);
               field1072.method2073(var15);
               field898.method5216();
            }

            Object var36 = WidgetNode.mouseRecorder.lock;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            synchronized(WidgetNode.mouseRecorder.lock) {
               if(!field889) {
                  WidgetNode.mouseRecorder.index = 0;
               } else if(MouseInput.mouseLastButton != 0 || WidgetNode.mouseRecorder.index >= 40) {
                  PacketNode var16 = class33.method382(ClientPacket.field2409, field1072.field1456);
                  var16.packetBuffer.putByte(0);
                  var3 = var16.packetBuffer.offset;
                  var4 = 0;

                  for(var5 = 0; var5 < WidgetNode.mouseRecorder.index && var16.packetBuffer.offset - var3 < 240; ++var5) {
                     ++var4;
                     var6 = WidgetNode.mouseRecorder.ys[var5];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 502) {
                        var6 = 502;
                     }

                     var7 = WidgetNode.mouseRecorder.xs[var5];
                     if(var7 < 0) {
                        var7 = 0;
                     } else if(var7 > 764) {
                        var7 = 764;
                     }

                     var8 = var6 * 765 + var7;
                     if(WidgetNode.mouseRecorder.ys[var5] == -1 && WidgetNode.mouseRecorder.xs[var5] == -1) {
                        var7 = -1;
                        var6 = -1;
                        var8 = 524287;
                     }

                     if(var7 == field860 && var6 == field946) {
                        if(field1007 < 2047) {
                           ++field1007;
                        }
                     } else {
                        var9 = var7 - field860;
                        field860 = var7;
                        var10 = var6 - field946;
                        field946 = var6;
                        if(field1007 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                           var9 += 32;
                           var10 += 32;
                           var16.packetBuffer.putShort(var10 + (field1007 << 12) + (var9 << 6));
                           field1007 = 0;
                        } else if(field1007 < 8) {
                           var16.packetBuffer.put24bitInt((field1007 << 19) + var8 + 8388608);
                           field1007 = 0;
                        } else {
                           var16.packetBuffer.putInt((field1007 << 19) + var8 + -1073741824);
                           field1007 = 0;
                        }
                     }
                  }

                  var16.packetBuffer.method3534(var16.packetBuffer.offset - var3);
                  field1072.method2073(var16);
                  if(var4 >= WidgetNode.mouseRecorder.index) {
                     WidgetNode.mouseRecorder.index = 0;
                  } else {
                     WidgetNode.mouseRecorder.index -= var4;

                     for(var5 = 0; var5 < WidgetNode.mouseRecorder.index; ++var5) {
                        WidgetNode.mouseRecorder.xs[var5] = WidgetNode.mouseRecorder.xs[var4 + var5];
                        WidgetNode.mouseRecorder.ys[var5] = WidgetNode.mouseRecorder.ys[var5 + var4];
                     }
                  }
               }
            }

            PacketNode var19;
            if(MouseInput.mouseLastButton == 1 || !class153.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
               long var17 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis) / 50L;
               if(var17 > 4095L) {
                  var17 = 4095L;
               }

               mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis;
               var3 = MouseInput.mouseLastPressedY;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > GameEngine.canvasHeight) {
                  var3 = GameEngine.canvasHeight;
               }

               var4 = MouseInput.mouseLastPressedX;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > WallObject.canvasWidth) {
                  var4 = WallObject.canvasWidth;
               }

               var5 = (int)var17;
               var19 = class33.method382(ClientPacket.field2349, field1072.field1456);
               var19.packetBuffer.putShort((var5 << 1) + (MouseInput.mouseLastButton == 2?1:0));
               var19.packetBuffer.putShort(var4);
               var19.packetBuffer.putShort(var3);
               field1072.method2073(var19);
            }

            if(KeyFocusListener.field600 > 0) {
               var15 = class33.method382(ClientPacket.field2348, field1072.field1456);
               var15.packetBuffer.putShort(0);
               var2 = var15.packetBuffer.offset;
               long var20 = WorldMapRegion.method465();

               for(var5 = 0; var5 < KeyFocusListener.field600; ++var5) {
                  long var22 = var20 - field1070;
                  if(var22 > 16777215L) {
                     var22 = 16777215L;
                  }

                  field1070 = var20;
                  var15.packetBuffer.putShortLE(KeyFocusListener.field606[var5]);
                  var15.packetBuffer.method3695((int)var22);
               }

               var15.packetBuffer.method3681(var15.packetBuffer.offset - var2);
               field1072.method2073(var15);
            }

            if(field932 > 0) {
               --field932;
            }

            if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
               field995 = true;
            }

            if(field995 && field932 <= 0) {
               field932 = 20;
               field995 = false;
               var15 = class33.method382(ClientPacket.field2384, field1072.field1456);
               var15.packetBuffer.method3519(cameraPitchTarget);
               var15.packetBuffer.putShort(mapAngle);
               field1072.method2073(var15);
            }

            if(Buffer.field2550 && !field863) {
               field863 = true;
               var15 = class33.method382(ClientPacket.field2352, field1072.field1456);
               var15.packetBuffer.putByte(1);
               field1072.method2073(var15);
            }

            if(!Buffer.field2550 && field863) {
               field863 = false;
               var15 = class33.method382(ClientPacket.field2352, field1072.field1456);
               var15.packetBuffer.putByte(0);
               field1072.method2073(var15);
            }

            if(class251.renderOverview != null) {
               class251.renderOverview.method5990();
            }

            AbstractSoundSystem.method2255();
            if(field1071 != Ignore.plane) {
               field1071 = Ignore.plane;
               class1.method0(Ignore.plane);
            }

            if(gameState == 30) {
               class183.method3433();

               for(var1 = 0; var1 < queuedSoundEffectCount; ++var1) {
                  --unknownSoundValues2[var1];
                  if(unknownSoundValues2[var1] >= -10) {
                     SoundEffect var37 = audioEffects[var1];
                     if(var37 == null) {
                        Object var10000 = null;
                        var37 = SoundEffect.getTrack(WorldMapRectangle.indexCache4, queuedSoundEffectIDs[var1], 0);
                        if(var37 == null) {
                           continue;
                        }

                        unknownSoundValues2[var1] += var37.calculateDelay();
                        audioEffects[var1] = var37;
                     }

                     if(unknownSoundValues2[var1] < 0) {
                        if(soundLocations[var1] != 0) {
                           var4 = (soundLocations[var1] & 255) * 128;
                           var5 = soundLocations[var1] >> 16 & 255;
                           var6 = var5 * 128 + 64 - WorldMapData.localPlayer.x;
                           if(var6 < 0) {
                              var6 = -var6;
                           }

                           var7 = soundLocations[var1] >> 8 & 255;
                           var8 = var7 * 128 + 64 - WorldMapData.localPlayer.y;
                           if(var8 < 0) {
                              var8 = -var8;
                           }

                           var9 = var6 + var8 - 128;
                           if(var9 > var4) {
                              unknownSoundValues2[var1] = -100;
                              continue;
                           }

                           if(var9 < 0) {
                              var9 = 0;
                           }

                           var3 = (var4 - var9) * field1083 / var4;
                        } else {
                           var3 = field899;
                        }

                        if(var3 > 0) {
                           RawAudioNode var24 = var37.method2143().applyResampler(MapCacheArchiveNames.field523);
                           class115 var25 = class115.method2316(var24, 100, var3);
                           var25.method2383(unknownSoundValues1[var1] - 1);
                           FontName.field3884.method2086(var25);
                        }

                        unknownSoundValues2[var1] = -100;
                     }
                  } else {
                     --queuedSoundEffectCount;

                     for(var2 = var1; var2 < queuedSoundEffectCount; ++var2) {
                        queuedSoundEffectIDs[var2] = queuedSoundEffectIDs[var2 + 1];
                        audioEffects[var2] = audioEffects[var2 + 1];
                        unknownSoundValues1[var2] = unknownSoundValues1[var2 + 1];
                        unknownSoundValues2[var2] = unknownSoundValues2[var2 + 1];
                        soundLocations[var2] = soundLocations[var2 + 1];
                     }

                     --var1;
                  }
               }

               if(field956) {
                  boolean var31;
                  if(class229.field2674 != 0) {
                     var31 = true;
                  } else {
                     var31 = class229.field2673.method4209();
                  }

                  if(!var31) {
                     if(field1079 != 0 && field1080 != -1) {
                        CombatInfo1.method1668(Varbit.indexTrack1, field1080, 0, field1079, false);
                     }

                     field956 = false;
                  }
               }

               ++field1072.field1464;
               if(field1072.field1464 > 750) {
                  class28.method253();
               } else {
                  class228.method4140();
                  class154.method3152();
                  ScriptState.method1126();
                  ++field910;
                  if(cursorState != 0) {
                     field1088 += 20;
                     if(field1088 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(MouseRecorder.field797 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        GameEngine.method1053(MouseRecorder.field797);
                        MouseRecorder.field797 = null;
                     }
                  }

                  Widget var38 = class28.field377;
                  Widget var39 = FileRequest.field3371;
                  class28.field377 = null;
                  FileRequest.field3371 = null;
                  draggedOnWidget = null;
                  field1095 = false;
                  field1024 = false;
                  field869 = 0;

                  while(class290.method5196() && field869 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && class85.field1295 == 66) {
                        String var26 = class61.method1092();
                        class249.clientInstance.method923(var26);
                     } else if(field923 != 1 || Size.field341 <= 0) {
                        field1069[field869] = class85.field1295;
                        field1068[field869] = Size.field341;
                        ++field869;
                     }
                  }

                  boolean var32 = rights >= 2;
                  if(var32 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var4 = WorldMapData.localPlayer.field836 - mouseWheelRotation;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != WorldMapData.localPlayer.field836) {
                        FileOnDisk.method2542(WorldMapData.localPlayer.pathX[0] + class38.baseX, WorldMapData.localPlayer.pathY[0] + PlayerComposition.baseY, var4, false);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     var4 = widgetRoot;
                     var5 = WallObject.canvasWidth;
                     var6 = GameEngine.canvasHeight;
                     if(Script.loadWidget(var4)) {
                        class190.method3504(Widget.widgets[var4], -1, 0, 0, var5, var6, 0, 0);
                     }
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var40;
                     ScriptEvent var41;
                     Widget var42;
                     do {
                        var41 = (ScriptEvent)field1046.popFront();
                        if(var41 == null) {
                           while(true) {
                              do {
                                 var41 = (ScriptEvent)field1047.popFront();
                                 if(var41 == null) {
                                    while(true) {
                                       do {
                                          var41 = (ScriptEvent)field1045.popFront();
                                          if(var41 == null) {
                                             this.method1264();
                                             if(class251.renderOverview != null) {
                                                class251.renderOverview.method6072(Ignore.plane, (WorldMapData.localPlayer.x >> 7) + class38.baseX, (WorldMapData.localPlayer.y >> 7) + PlayerComposition.baseY, false);
                                                class251.renderOverview.method6032();
                                             }

                                             if(draggedWidget != null) {
                                                this.method1432();
                                             }

                                             if(MapIconReference.field574 != null) {
                                                GameEngine.method1053(MapIconReference.field574);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(field960) {
                                                      if(MapIconReference.field574 == WorldComparator.field261 && field1090 != field998) {
                                                         Widget var43 = MapIconReference.field574;
                                                         byte var33 = 0;
                                                         if(field1011 == 1 && var43.contentType == 206) {
                                                            var33 = 1;
                                                         }

                                                         if(var43.itemIds[field1090] <= 0) {
                                                            var33 = 0;
                                                         }

                                                         if(class154.method3149(GrandExchangeEvent.getWidgetConfig(var43))) {
                                                            var6 = field998;
                                                            var7 = field1090;
                                                            var43.itemIds[var7] = var43.itemIds[var6];
                                                            var43.itemQuantities[var7] = var43.itemQuantities[var6];
                                                            var43.itemIds[var6] = -1;
                                                            var43.itemQuantities[var6] = 0;
                                                         } else if(var33 == 1) {
                                                            var6 = field998;
                                                            var7 = field1090;

                                                            while(var6 != var7) {
                                                               if(var6 > var7) {
                                                                  var43.method4465(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var43.method4465(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var43.method4465(field1090, field998);
                                                         }

                                                         var19 = class33.method382(ClientPacket.field2361, field1072.field1456);
                                                         var19.packetBuffer.method3584(MapIconReference.field574.id);
                                                         var19.packetBuffer.method3570(field998);
                                                         var19.packetBuffer.putShort(field1090);
                                                         var19.packetBuffer.putShortLE(var33);
                                                         field1072.method2073(var19);
                                                      }
                                                   } else if(this.method1270()) {
                                                      this.openMenu(field957, field958);
                                                   } else if(menuOptionCount > 0) {
                                                      class153.method3140(field957, field958);
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   MapIconReference.field574 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field957 + 5 || MouseInput.mouseLastX < field957 - 5 || MouseInput.mouseLastY > field958 + 5 || MouseInput.mouseLastY < field958 - 5)) {
                                                   field960 = true;
                                                }
                                             }

                                             if(Region.method2905()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                var19 = class33.method382(ClientPacket.field2397, field1072.field1456);
                                                var19.packetBuffer.putByte(5);
                                                var19.packetBuffer.method3519(var5 + PlayerComposition.baseY);
                                                var19.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                var19.packetBuffer.method3573(var4 + class38.baseX);
                                                field1072.method2073(var19);
                                                Region.method3032();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field1088 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var38 != class28.field377) {
                                                if(var38 != null) {
                                                   GameEngine.method1053(var38);
                                                }

                                                if(class28.field377 != null) {
                                                   GameEngine.method1053(class28.field377);
                                                }
                                             }

                                             if(var39 != FileRequest.field3371 && field1000 == field999) {
                                                if(var39 != null) {
                                                   GameEngine.method1053(var39);
                                                }

                                                if(FileRequest.field3371 != null) {
                                                   GameEngine.method1053(FileRequest.field3371);
                                                }
                                             }

                                             if(FileRequest.field3371 != null) {
                                                if(field999 < field1000) {
                                                   ++field999;
                                                   if(field999 == field1000) {
                                                      GameEngine.method1053(FileRequest.field3371);
                                                   }
                                                }
                                             } else if(field999 > 0) {
                                                --field999;
                                             }

                                             int var12;
                                             int var13;
                                             int var27;
                                             if(field923 == 0) {
                                                var4 = WorldMapData.localPlayer.x;
                                                var5 = WorldMapData.localPlayer.y;
                                                if(WorldMapDecoration.field415 - var4 < -500 || WorldMapDecoration.field415 - var4 > 500 || class196.field2569 - var5 < -500 || class196.field2569 - var5 > 500) {
                                                   WorldMapDecoration.field415 = var4;
                                                   class196.field2569 = var5;
                                                }

                                                if(var4 != WorldMapDecoration.field415) {
                                                   WorldMapDecoration.field415 += (var4 - WorldMapDecoration.field415) / 16;
                                                }

                                                if(var5 != class196.field2569) {
                                                   class196.field2569 += (var5 - class196.field2569) / 16;
                                                }

                                                var6 = WorldMapDecoration.field415 >> 7;
                                                var7 = class196.field2569 >> 7;
                                                var8 = class149.getTileHeight(WorldMapDecoration.field415, class196.field2569, Ignore.plane);
                                                var9 = 0;
                                                if(var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
                                                   for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      for(var27 = var7 - 4; var27 <= var7 + 4; ++var27) {
                                                         var12 = Ignore.plane;
                                                         if(var12 < 3 && (class62.tileSettings[1][var10][var27] & 2) == 2) {
                                                            ++var12;
                                                         }

                                                         var13 = var8 - class62.tileHeights[var12][var10][var27];
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

                                                if(var10 > field992) {
                                                   field992 += (var10 - field992) / 24;
                                                } else if(var10 < field992) {
                                                   field992 += (var10 - field992) / 80;
                                                }

                                                FaceNormal.field2033 = class149.getTileHeight(WorldMapData.localPlayer.x, WorldMapData.localPlayer.y, Ignore.plane) - field924;
                                             } else if(field923 == 1) {
                                                if(field954 && WorldMapData.localPlayer != null) {
                                                   var4 = WorldMapData.localPlayer.pathX[0];
                                                   var5 = WorldMapData.localPlayer.pathY[0];
                                                   if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                                                      WorldMapDecoration.field415 = WorldMapData.localPlayer.x;
                                                      FaceNormal.field2033 = class149.getTileHeight(WorldMapData.localPlayer.x, WorldMapData.localPlayer.y, Ignore.plane) - field924;
                                                      class196.field2569 = WorldMapData.localPlayer.y;
                                                      field954 = false;
                                                   }
                                                }

                                                short var34 = -1;
                                                if(KeyFocusListener.keyPressed[33]) {
                                                   var34 = 0;
                                                } else if(KeyFocusListener.keyPressed[49]) {
                                                   var34 = 1024;
                                                }

                                                if(KeyFocusListener.keyPressed[48]) {
                                                   if(var34 == 0) {
                                                      var34 = 1792;
                                                   } else if(var34 == 1024) {
                                                      var34 = 1280;
                                                   } else {
                                                      var34 = 1536;
                                                   }
                                                } else if(KeyFocusListener.keyPressed[50]) {
                                                   if(var34 == 0) {
                                                      var34 = 256;
                                                   } else if(var34 == 1024) {
                                                      var34 = 768;
                                                   } else {
                                                      var34 = 512;
                                                   }
                                                }

                                                byte var35 = 0;
                                                if(KeyFocusListener.keyPressed[35]) {
                                                   var35 = -1;
                                                } else if(KeyFocusListener.keyPressed[51]) {
                                                   var35 = 1;
                                                }

                                                var6 = 0;
                                                if(var34 >= 0 || var35 != 0) {
                                                   var6 = KeyFocusListener.keyPressed[81]?field857:field1115;
                                                   var6 *= 16;
                                                   field871 = var34;
                                                   field927 = var35;
                                                }

                                                if(field925 < var6) {
                                                   field925 += var6 / 8;
                                                   if(field925 > var6) {
                                                      field925 = var6;
                                                   }
                                                } else if(field925 > var6) {
                                                   field925 = field925 * 9 / 10;
                                                }

                                                if(field925 > 0) {
                                                   var7 = field925 / 16;
                                                   if(field871 >= 0) {
                                                      var4 = field871 - class62.cameraYaw & 2047;
                                                      var8 = Graphics3D.SINE[var4];
                                                      var9 = Graphics3D.COSINE[var4];
                                                      WorldMapDecoration.field415 += var8 * var7 / 65536;
                                                      class196.field2569 += var7 * var9 / 65536;
                                                   }

                                                   if(field927 != 0) {
                                                      FaceNormal.field2033 += var7 * field927;
                                                      if(FaceNormal.field2033 > 0) {
                                                         FaceNormal.field2033 = 0;
                                                      }
                                                   }
                                                } else {
                                                   field871 = -1;
                                                   field927 = -1;
                                                }

                                                if(KeyFocusListener.keyPressed[13]) {
                                                   BoundingBox3DDrawMode.method59();
                                                }
                                             }

                                             if(MouseInput.mouseCurrentButton == 4 && class153.middleMouseMovesCamera) {
                                                var4 = MouseInput.mouseLastY - field1082;
                                                field920 = var4 * 2;
                                                field1082 = var4 != -1 && var4 != 1?(MouseInput.mouseLastY + field1082) / 2:MouseInput.mouseLastY;
                                                var5 = field1041 - MouseInput.mouseLastX;
                                                field919 = var5 * 2;
                                                field1041 = var5 != -1 && var5 != 1?(field1041 + MouseInput.mouseLastX) / 2:MouseInput.mouseLastX;
                                             } else {
                                                if(KeyFocusListener.keyPressed[96]) {
                                                   field919 += (-24 - field919) / 2;
                                                } else if(KeyFocusListener.keyPressed[97]) {
                                                   field919 += (24 - field919) / 2;
                                                } else {
                                                   field919 /= 2;
                                                }

                                                if(KeyFocusListener.keyPressed[98]) {
                                                   field920 += (12 - field920) / 2;
                                                } else if(KeyFocusListener.keyPressed[99]) {
                                                   field920 += (-12 - field920) / 2;
                                                } else {
                                                   field920 /= 2;
                                                }

                                                field1082 = MouseInput.mouseLastY;
                                                field1041 = MouseInput.mouseLastX;
                                             }

                                             mapAngle = field919 / 2 + mapAngle & 2047;
                                             cameraPitchTarget += field920 / 2;
                                             if(cameraPitchTarget < 128) {
                                                cameraPitchTarget = 128;
                                             }

                                             if(cameraPitchTarget > 383) {
                                                cameraPitchTarget = 383;
                                             }

                                             if(field851) {
                                                var4 = class183.field2466 * 128 + 64;
                                                var5 = class22.field322 * 128 + 64;
                                                var6 = class149.getTileHeight(var4, var5, Ignore.plane) - WorldMapType1.field414;
                                                if(Varcs.cameraX < var4) {
                                                   Varcs.cameraX = (var4 - Varcs.cameraX) * class61.field701 / 1000 + Varcs.cameraX + BoundingBox3DDrawMode.field251;
                                                   if(Varcs.cameraX > var4) {
                                                      Varcs.cameraX = var4;
                                                   }
                                                }

                                                if(Varcs.cameraX > var4) {
                                                   Varcs.cameraX -= class61.field701 * (Varcs.cameraX - var4) / 1000 + BoundingBox3DDrawMode.field251;
                                                   if(Varcs.cameraX < var4) {
                                                      Varcs.cameraX = var4;
                                                   }
                                                }

                                                if(class160.cameraZ < var6) {
                                                   class160.cameraZ = (var6 - class160.cameraZ) * class61.field701 / 1000 + class160.cameraZ + BoundingBox3DDrawMode.field251;
                                                   if(class160.cameraZ > var6) {
                                                      class160.cameraZ = var6;
                                                   }
                                                }

                                                if(class160.cameraZ > var6) {
                                                   class160.cameraZ -= class61.field701 * (class160.cameraZ - var6) / 1000 + BoundingBox3DDrawMode.field251;
                                                   if(class160.cameraZ < var6) {
                                                      class160.cameraZ = var6;
                                                   }
                                                }

                                                if(BoundingBox3D.cameraY < var5) {
                                                   BoundingBox3D.cameraY = (var5 - BoundingBox3D.cameraY) * class61.field701 / 1000 + BoundingBox3D.cameraY + BoundingBox3DDrawMode.field251;
                                                   if(BoundingBox3D.cameraY > var5) {
                                                      BoundingBox3D.cameraY = var5;
                                                   }
                                                }

                                                if(BoundingBox3D.cameraY > var5) {
                                                   BoundingBox3D.cameraY -= class61.field701 * (BoundingBox3D.cameraY - var5) / 1000 + BoundingBox3DDrawMode.field251;
                                                   if(BoundingBox3D.cameraY < var5) {
                                                      BoundingBox3D.cameraY = var5;
                                                   }
                                                }

                                                var4 = class254.field3329 * 128 + 64;
                                                var5 = class27.field372 * 128 + 64;
                                                var6 = class149.getTileHeight(var4, var5, Ignore.plane) - class2.field15;
                                                var7 = var4 - Varcs.cameraX;
                                                var8 = var6 - class160.cameraZ;
                                                var9 = var5 - BoundingBox3D.cameraY;
                                                var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                                                var27 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                                                var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                                                if(var27 < 128) {
                                                   var27 = 128;
                                                }

                                                if(var27 > 383) {
                                                   var27 = 383;
                                                }

                                                if(class33.cameraPitch < var27) {
                                                   class33.cameraPitch = (var27 - class33.cameraPitch) * GameCanvas.field624 / 1000 + class33.cameraPitch + class21.field316;
                                                   if(class33.cameraPitch > var27) {
                                                      class33.cameraPitch = var27;
                                                   }
                                                }

                                                if(class33.cameraPitch > var27) {
                                                   class33.cameraPitch -= GameCanvas.field624 * (class33.cameraPitch - var27) / 1000 + class21.field316;
                                                   if(class33.cameraPitch < var27) {
                                                      class33.cameraPitch = var27;
                                                   }
                                                }

                                                var13 = var12 - class62.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 > 0) {
                                                   class62.cameraYaw = var13 * GameCanvas.field624 / 1000 + class62.cameraYaw + class21.field316;
                                                   class62.cameraYaw &= 2047;
                                                }

                                                if(var13 < 0) {
                                                   class62.cameraYaw -= class21.field316 + -var13 * GameCanvas.field624 / 1000;
                                                   class62.cameraYaw &= 2047;
                                                }

                                                int var14 = var12 - class62.cameraYaw;
                                                if(var14 > 1024) {
                                                   var14 -= 2048;
                                                }

                                                if(var14 < -1024) {
                                                   var14 += 2048;
                                                }

                                                if(var14 < 0 && var13 > 0 || var14 > 0 && var13 < 0) {
                                                   class62.cameraYaw = var12;
                                                }
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1096[var4];
                                             }

                                             BoundingBox.chatMessages.process();
                                             var4 = ++MouseInput.mouseIdleTicks - 1;
                                             var6 = class153.method3139();
                                             PacketNode var28;
                                             if(var4 > 15000 && var6 > 15000) {
                                                field1036 = 250;
                                                class33.method378(14500);
                                                var28 = class33.method382(ClientPacket.field2430, field1072.field1456);
                                                field1072.method2073(var28);
                                             }

                                             WallObject.friendManager.method1751();
                                             ++field1072.field1462;
                                             if(field1072.field1462 > 50) {
                                                var28 = class33.method382(ClientPacket.field2431, field1072.field1456);
                                                field1072.method2073(var28);
                                             }

                                             try {
                                                field1072.method2077();
                                             } catch (IOException var29) {
                                                class28.method253();
                                             }

                                             return;
                                          }

                                          var42 = var41.widget;
                                          if(var42.index < 0) {
                                             break;
                                          }

                                          var40 = GZipDecompressor.getWidget(var42.parentId);
                                       } while(var40 == null || var40.children == null || var42.index >= var40.children.length || var42 != var40.children[var42.index]);

                                       class25.runScript(var41, 500000);
                                    }
                                 }

                                 var42 = var41.widget;
                                 if(var42.index < 0) {
                                    break;
                                 }

                                 var40 = GZipDecompressor.getWidget(var42.parentId);
                              } while(var40 == null || var40.children == null || var42.index >= var40.children.length || var42 != var40.children[var42.index]);

                              class25.runScript(var41, 500000);
                           }
                        }

                        var42 = var41.widget;
                        if(var42.index < 0) {
                           break;
                        }

                        var40 = GZipDecompressor.getWidget(var42.parentId);
                     } while(var40 == null || var40.children == null || var42.index >= var40.children.length || var42 != var40.children[var42.index]);

                     class25.runScript(var41, 500000);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "11087744"
   )
   void method1266() {
      int var1 = WallObject.canvasWidth;
      int var2 = GameEngine.canvasHeight;
      if(super.field654 < var1) {
         var1 = super.field654;
      }

      if(super.field655 < var2) {
         var2 = super.field655;
      }

      if(MapIcon.preferences != null) {
         try {
            class53.method844(class249.clientInstance, "resize", new Object[]{Integer.valueOf(SoundTaskDataProvider.method838())});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1424231682"
   )
   final void method1358() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(Script.loadWidget(var1)) {
            class22.method183(Widget.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field1051[var1]) {
            field904[var1] = true;
         }

         field1053[var1] = field1051[var1];
         field1051[var1] = false;
      }

      field1026 = gameCycle;
      field1004 = -1;
      field1089 = -1;
      WorldComparator.field261 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         FontName.method5473(widgetRoot, 0, 0, WallObject.canvasWidth, GameEngine.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field1004 != -1) {
            var1 = field1004;
            var2 = field1089;
            if((menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) && field996) {
               var3 = menuOptionCount - 1;
               String var5;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var5 = "Use" + " " + lastSelectedItemName + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var5 = field1006 + " " + field1074 + " " + "->";
               } else {
                  var5 = class44.method677(var3);
               }

               if(menuOptionCount > 2) {
                  var5 = var5 + class37.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class5.fontBold12.drawRandomizedMouseoverText(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         class44.method681();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field1053[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field904[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = Ignore.plane;
      var2 = WorldMapData.localPlayer.x;
      var3 = WorldMapData.localPlayer.y;
      int var4 = field910;

      for(class80 var13 = (class80)class80.field1240.getFront(); var13 != null; var13 = (class80)class80.field1240.getNext()) {
         if(var13.field1241 != -1 || var13.field1236 != null) {
            int var6 = 0;
            if(var2 > var13.field1249) {
               var6 += var2 - var13.field1249;
            } else if(var2 < var13.field1243) {
               var6 += var13.field1243 - var2;
            }

            if(var3 > var13.field1245) {
               var6 += var3 - var13.field1245;
            } else if(var3 < var13.field1239) {
               var6 += var13.field1239 - var3;
            }

            if(var6 - 64 <= var13.field1242 && field1083 != 0 && var1 == var13.field1237) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               int var7 = (var13.field1242 - var6) * field1083 / var13.field1242;
               Object var10000;
               if(var13.field1244 == null) {
                  if(var13.field1241 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.getTrack(WorldMapRectangle.indexCache4, var13.field1241, 0);
                     if(var8 != null) {
                        RawAudioNode var9 = var8.method2143().applyResampler(MapCacheArchiveNames.field523);
                        class115 var10 = class115.method2316(var9, 100, var7);
                        var10.method2383(-1);
                        FontName.field3884.method2086(var10);
                        var13.field1244 = var10;
                     }
                  }
               } else {
                  var13.field1244.method2320(var7);
               }

               if(var13.field1238 == null) {
                  if(var13.field1236 != null && (var13.field1248 -= var4) <= 0) {
                     int var12 = (int)(Math.random() * (double)var13.field1236.length);
                     var10000 = null;
                     SoundEffect var14 = SoundEffect.getTrack(WorldMapRectangle.indexCache4, var13.field1236[var12], 0);
                     if(var14 != null) {
                        RawAudioNode var15 = var14.method2143().applyResampler(MapCacheArchiveNames.field523);
                        class115 var11 = class115.method2316(var15, 100, var7);
                        var11.method2383(0);
                        FontName.field3884.method2086(var11);
                        var13.field1238 = var11;
                        var13.field1248 = var13.field1246 + (int)(Math.random() * (double)(var13.field1247 - var13.field1246));
                     }
                  }
               } else {
                  var13.field1238.method2320(var7);
                  if(!var13.field1238.linked()) {
                     var13.field1238 = null;
                  }
               }
            } else {
               if(var13.field1244 != null) {
                  FontName.field3884.method2087(var13.field1244);
                  var13.field1244 = null;
               }

               if(var13.field1238 != null) {
                  FontName.field3884.method2087(var13.field1238);
                  var13.field1238 = null;
               }
            }
         }
      }

      field910 = 0;
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(Lcn;I)Z",
      garbageValue = "-101951722"
   )
   final boolean method1268(NetWriter var1) {
      class169 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         String var5;
         int var6;
         try {
            if(var1.serverPacket == null) {
               if(var1.field1453) {
                  if(!var2.vmethod3337(1)) {
                     return false;
                  }

                  var2.vmethod3338(var1.packetBuffer.payload, 0, 1);
                  var1.field1464 = 0;
                  var1.field1453 = false;
               }

               var3.offset = 0;
               if(var3.method3805()) {
                  if(!var2.vmethod3337(1)) {
                     return false;
                  }

                  var2.vmethod3338(var1.packetBuffer.payload, 1, 1);
                  var1.field1464 = 0;
               }

               var1.field1453 = true;
               ServerPacket[] var4 = new ServerPacket[]{ServerPacket.field2303, ServerPacket.field2262, ServerPacket.field2263, ServerPacket.field2331, ServerPacket.field2265, ServerPacket.field2266, ServerPacket.field2294, ServerPacket.field2297, ServerPacket.field2280, ServerPacket.field2270, ServerPacket.field2271, ServerPacket.field2277, ServerPacket.field2273, ServerPacket.field2264, ServerPacket.field2275, ServerPacket.field2267, ServerPacket.field2305, ServerPacket.field2278, ServerPacket.field2279, ServerPacket.field2268, ServerPacket.field2281, ServerPacket.field2282, ServerPacket.field2283, ServerPacket.field2284, ServerPacket.field2285, ServerPacket.field2286, ServerPacket.field2287, ServerPacket.field2295, ServerPacket.field2289, ServerPacket.field2290, ServerPacket.field2276, ServerPacket.field2292, ServerPacket.field2293, ServerPacket.field2310, ServerPacket.field2336, ServerPacket.field2296, ServerPacket.field2300, ServerPacket.field2320, ServerPacket.field2338, ServerPacket.field2316, ServerPacket.field2301, ServerPacket.field2298, ServerPacket.field2274, ServerPacket.field2304, ServerPacket.field2330, ServerPacket.field2306, ServerPacket.field2307, ServerPacket.field2308, ServerPacket.field2313, ServerPacket.field2272, ServerPacket.field2311, ServerPacket.field2312, ServerPacket.field2328, ServerPacket.field2314, ServerPacket.field2315, ServerPacket.field2321, ServerPacket.field2317, ServerPacket.field2318, ServerPacket.field2319, ServerPacket.field2342, ServerPacket.field2302, ServerPacket.field2322, ServerPacket.field2323, ServerPacket.field2324, ServerPacket.field2325, ServerPacket.field2326, ServerPacket.field2327, ServerPacket.field2299, ServerPacket.field2329, ServerPacket.field2269, ServerPacket.field2309, ServerPacket.field2332, ServerPacket.field2333, ServerPacket.field2334, ServerPacket.field2335, ServerPacket.field2291, ServerPacket.field2337, ServerPacket.field2288, ServerPacket.field2339, ServerPacket.field2340, ServerPacket.field2341, ServerPacket.field2261, ServerPacket.field2343, ServerPacket.field2344};
               var6 = var3.method3826();
               if(var6 < 0 || var6 >= var4.length) {
                  throw new IOException(var6 + " " + var3.offset);
               }

               var1.serverPacket = var4[var6];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3337(1)) {
                  return false;
               }

               var1.getSocket().vmethod3338(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3337(2)) {
                  return false;
               }

               var1.getSocket().vmethod3338(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3337(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3338(var3.payload, 0, var1.packetLength);
            var1.field1464 = 0;
            field898.method5208();
            var1.field1465 = var1.field1457;
            var1.field1457 = var1.field1463;
            var1.field1463 = var1.serverPacket;
            int var20;
            int var21;
            Widget var87;
            if(ServerPacket.field2294 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var21 = var3.method3585();
               var87 = GZipDecompressor.getWidget(var21);
               if(var87.modelType != 2 || var20 != var87.modelId) {
                  var87.modelType = 2;
                  var87.modelId = var20;
                  GameEngine.method1053(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2289 == var1.serverPacket) {
               for(var20 = 0; var20 < cachedPlayers.length; ++var20) {
                  if(cachedPlayers[var20] != null) {
                     cachedPlayers[var20].animation = -1;
                  }
               }

               for(var20 = 0; var20 < cachedNPCs.length; ++var20) {
                  if(cachedNPCs[var20] != null) {
                     cachedNPCs[var20].animation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               class23.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2333 == var1.serverPacket) {
               class38.method549();
               energy = var3.readUnsignedByte();
               field981 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2264 == var1.serverPacket) {
               WallObject.friendManager.field1233.method5288(var3, var1.packetLength);
               Size.method194();
               if(KeyFocusListener.clanMemberManager != null) {
                  KeyFocusListener.clanMemberManager.method5469();
               }

               field1039 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2297 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2462);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2292 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2457);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2305 == var1.serverPacket) {
               for(var20 = 0; var20 < class237.widgetSettings.length; ++var20) {
                  if(class237.settings[var20] != class237.widgetSettings[var20]) {
                     class237.widgetSettings[var20] = class237.settings[var20];
                     class5.method14(var20);
                     field1032[++field1033 - 1 & 31] = var20;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var65;
            if(ServerPacket.field2274 == var1.serverPacket) {
               var20 = var3.method3693();
               var21 = var3.method3579();
               var6 = var3.method3585();
               var65 = GZipDecompressor.getWidget(var6);
               if(var21 != var65.originalX || var20 != var65.originalY || var65.dynamicX != 0 || var65.dynamicY != 0) {
                  var65.originalX = var21;
                  var65.originalY = var20;
                  var65.dynamicX = 0;
                  var65.dynamicY = 0;
                  GameEngine.method1053(var65);
                  this.widgetMethod0(var65);
                  if(var65.type == 0) {
                     GameEngine.method1051(Widget.widgets[var6 >> 16], var65, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2276 == var1.serverPacket) {
               field851 = false;

               for(var20 = 0; var20 < 5; ++var20) {
                  field1091[var20] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            WidgetNode var7;
            Widget var68;
            if(ServerPacket.field2321 == var1.serverPacket) {
               var20 = var3.method3586();
               var21 = var3.method3587();
               WidgetNode var95 = (WidgetNode)componentTable.get((long)var21);
               var7 = (WidgetNode)componentTable.get((long)var20);
               if(var7 != null) {
                  class93.closeWidget(var7, var95 == null || var95.id != var7.id);
               }

               if(var95 != null) {
                  var95.unlink();
                  componentTable.put(var95, (long)var20);
               }

               var68 = GZipDecompressor.getWidget(var21);
               if(var68 != null) {
                  GameEngine.method1053(var68);
               }

               var68 = GZipDecompressor.getWidget(var20);
               if(var68 != null) {
                  GameEngine.method1053(var68);
                  GameEngine.method1051(Widget.widgets[var68.id >>> 16], var68, true);
               }

               if(widgetRoot != -1) {
                  BoundingBox.method50(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2280 == var1.serverPacket) {
               class64.field742 = var3.readUnsignedByte();
               FaceNormal.field2034 = var3.method3566();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2330 == var1.serverPacket) {
               field1063 = var3.method3566();
               publicChatMode = var3.method3567();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2266 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               if(var20 == 65535) {
                  var20 = -1;
               }

               WorldMapData.method363(var20);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2331 == var1.serverPacket) {
               var20 = var3.method3702();
               var21 = var3.method3574();
               if(var21 == 65535) {
                  var21 = -1;
               }

               class90.method1929(var21, var20);
               var1.serverPacket = null;
               return true;
            }

            Widget var60;
            if(ServerPacket.field2265 == var1.serverPacket) {
               var20 = var3.method3586();
               var60 = GZipDecompressor.getWidget(var20);
               var60.modelType = 3;
               var60.modelId = WorldMapData.localPlayer.composition.method4421();
               GameEngine.method1053(var60);
               var1.serverPacket = null;
               return true;
            }

            int var9;
            int var11;
            int var12;
            int var14;
            int var16;
            int var17;
            int var23;
            int var24;
            int var27;
            int var81;
            int var93;
            if(ServerPacket.field2269 == var1.serverPacket) {
               var20 = var1.packetLength;
               var21 = var3.offset;
               class93.field1395 = 0;
               var6 = 0;
               var3.bitAccess();

               for(var23 = 0; var23 < class93.playerIndexesCount; ++var23) {
                  var24 = class93.playerIndices[var23];
                  if((class93.field1394[var24] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = WorldMapManager.method645(var3);
                           class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                        } else {
                           PlayerComposition.decodeMovement(var3, var24);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var23 = 0; var23 < class93.playerIndexesCount; ++var23) {
                  var24 = class93.playerIndices[var23];
                  if((class93.field1394[var24] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = WorldMapManager.method645(var3);
                           class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                        } else {
                           PlayerComposition.decodeMovement(var3, var24);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var23 = 0; var23 < class93.field1398; ++var23) {
                  var24 = class93.field1399[var23];
                  if((class93.field1394[var24] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = WorldMapManager.method645(var3);
                           class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                        } else if(class163.decodeRegionHash(var3, var24)) {
                           class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var23 = 0; var23 < class93.field1398; ++var23) {
                  var24 = class93.field1399[var23];
                  if((class93.field1394[var24] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = WorldMapManager.method645(var3);
                           class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                        } else if(class163.decodeRegionHash(var3, var24)) {
                           class93.field1394[var24] = (byte)(class93.field1394[var24] | 2);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               class93.playerIndexesCount = 0;
               class93.field1398 = 0;

               Player var76;
               for(var23 = 1; var23 < 2048; ++var23) {
                  class93.field1394[var23] = (byte)(class93.field1394[var23] >> 1);
                  var76 = cachedPlayers[var23];
                  if(var76 != null) {
                     class93.playerIndices[++class93.playerIndexesCount - 1] = var23;
                  } else {
                     class93.field1399[++class93.field1398 - 1] = var23;
                  }
               }

               for(var6 = 0; var6 < class93.field1395; ++var6) {
                  var23 = class93.field1404[var6];
                  var76 = cachedPlayers[var23];
                  var9 = var3.readUnsignedByte();
                  if((var9 & 128) != 0) {
                     var9 += var3.readUnsignedByte() << 8;
                  }

                  byte var77 = -1;
                  if((var9 & 16) != 0) {
                     var11 = var3.method3574();
                     if(var11 == 65535) {
                        var11 = -1;
                     }

                     var12 = var3.method3567();
                     GZipDecompressor.method3473(var76, var11, var12);
                  }

                  if((var9 & 1024) != 0) {
                     var77 = var3.method3529();
                  }

                  if((var9 & 8) != 0) {
                     var76.interacting = var3.method3576();
                     if(var76.interacting == 65535) {
                        var76.interacting = -1;
                     }
                  }

                  if((var9 & 2048) != 0) {
                     var76.field1159 = var3.readByte();
                     var76.field1181 = var3.method3613();
                     var76.field1146 = var3.readByte();
                     var76.field1182 = var3.method3613();
                     var76.field1183 = var3.method3574() + gameCycle;
                     var76.field1184 = var3.readUnsignedShort() + gameCycle;
                     var76.field1185 = var3.readUnsignedShort();
                     if(var76.field820) {
                        var76.field1159 += var76.field821;
                        var76.field1181 += var76.field831;
                        var76.field1146 += var76.field821;
                        var76.field1182 += var76.field831;
                        var76.queueSize = 0;
                     } else {
                        var76.field1159 += var76.pathX[0];
                        var76.field1181 += var76.pathY[0];
                        var76.field1146 += var76.pathX[0];
                        var76.field1182 += var76.pathY[0];
                        var76.queueSize = 1;
                     }

                     var76.field1196 = 0;
                  }

                  if((var9 & 512) != 0) {
                     class93.field1393[var23] = var3.readByte();
                  }

                  if((var9 & 1) != 0) {
                     var76.field1142 = var3.readUnsignedShort();
                     if(var76.queueSize == 0) {
                        var76.orientation = var76.field1142;
                        var76.field1142 = -1;
                     }
                  }

                  if((var9 & 32) != 0) {
                     var11 = var3.readUnsignedShort();
                     Permission[] var89 = new Permission[]{Permission.field3341, Permission.field3345, Permission.field3344, Permission.field3342, Permission.field3340, Permission.field3343};
                     Permission var13 = (Permission)WorldMapRectangle.forOrdinal(var89, var3.method3567());
                     boolean var80 = var3.method3566() == 1;
                     var81 = var3.method3567();
                     var16 = var3.offset;
                     if(var76.name != null && var76.composition != null) {
                        boolean var83 = false;
                        if(var13.field3348 && WallObject.friendManager.method1727(var76.name)) {
                           var83 = true;
                        }

                        if(!var83 && myPlayerIndex == 0 && !var76.hidden) {
                           class93.field1392.offset = 0;
                           var3.method3588(class93.field1392.payload, 0, var81);
                           class93.field1392.offset = 0;
                           String var18 = FontTypeFace.appendTags(class303.method5404(WorldMapType1.method287(class93.field1392)));
                           var76.overhead = var18.trim();
                           var76.field1149 = var11 >> 8;
                           var76.field1155 = var11 & 255;
                           var76.overheadTextCyclesRemaining = 150;
                           var76.field1151 = var80;
                           var76.field1152 = var76 != WorldMapData.localPlayer && var13.field3348 && "" != field1064 && var18.toLowerCase().indexOf(field1064) == -1;
                           int var19;
                           if(var13.field3339) {
                              var19 = var80?91:1;
                           } else {
                              var19 = var80?90:2;
                           }

                           if(var13.field3346 != -1) {
                              TotalQuantityComparator.sendGameMessage(var19, class157.method3168(var13.field3346) + var76.name.getName(), var18);
                           } else {
                              TotalQuantityComparator.sendGameMessage(var19, var76.name.getName(), var18);
                           }
                        }
                     }

                     var3.offset = var16 + var81;
                  }

                  if((var9 & 256) != 0) {
                     var76.graphic = var3.method3576();
                     var11 = var3.method3586();
                     var76.field1178 = var11 >> 16;
                     var76.graphicsDelay = (var11 & 65535) + gameCycle;
                     var76.field1175 = 0;
                     var76.field1176 = 0;
                     if(var76.graphicsDelay > gameCycle) {
                        var76.field1175 = -1;
                     }

                     if(var76.graphic == 65535) {
                        var76.graphic = -1;
                     }
                  }

                  if((var9 & 64) != 0) {
                     var76.overhead = var3.readString();
                     if(var76.overhead.charAt(0) == '~') {
                        var76.overhead = var76.overhead.substring(1);
                        TotalQuantityComparator.sendGameMessage(2, var76.name.getName(), var76.overhead);
                     } else if(var76 == WorldMapData.localPlayer) {
                        TotalQuantityComparator.sendGameMessage(2, var76.name.getName(), var76.overhead);
                     }

                     var76.field1151 = false;
                     var76.field1149 = 0;
                     var76.field1155 = 0;
                     var76.overheadTextCyclesRemaining = 150;
                  }

                  if((var9 & 4) != 0) {
                     var11 = var3.readUnsignedByte();
                     byte[] var90 = new byte[var11];
                     Buffer var78 = new Buffer(var90);
                     var3.method3588(var90, 0, var11);
                     class93.field1405[var23] = var78;
                     var76.decodeApperance(var78);
                  }

                  if((var9 & 2) != 0) {
                     var11 = var3.readUnsignedByte();
                     if(var11 > 0) {
                        for(var12 = 0; var12 < var11; ++var12) {
                           var14 = -1;
                           var81 = -1;
                           var16 = -1;
                           var93 = var3.getUSmart();
                           if(var93 == 32767) {
                              var93 = var3.getUSmart();
                              var81 = var3.getUSmart();
                              var14 = var3.getUSmart();
                              var16 = var3.getUSmart();
                           } else if(var93 != 32766) {
                              var81 = var3.getUSmart();
                           } else {
                              var93 = -1;
                           }

                           var17 = var3.getUSmart();
                           var76.method1653(var93, var81, var14, var16, gameCycle, var17);
                        }
                     }

                     var12 = var3.readUnsignedByte();
                     if(var12 > 0) {
                        for(var93 = 0; var93 < var12; ++var93) {
                           var14 = var3.getUSmart();
                           var81 = var3.getUSmart();
                           if(var81 != 32767) {
                              var16 = var3.getUSmart();
                              var17 = var3.method3566();
                              var27 = var81 > 0?var3.method3565():var17;
                              var76.method1654(var14, gameCycle, var81, var16, var17, var27);
                           } else {
                              var76.method1655(var14);
                           }
                        }
                     }
                  }

                  if((var9 & 4096) != 0) {
                     for(var11 = 0; var11 < 3; ++var11) {
                        var76.actions[var11] = var3.readString();
                     }
                  }

                  if(var76.field820) {
                     if(var77 == 127) {
                        var76.method1214(var76.field821, var76.field831);
                     } else {
                        byte var79;
                        if(var77 != -1) {
                           var79 = var77;
                        } else {
                           var79 = class93.field1393[var23];
                        }

                        var76.method1210(var76.field821, var76.field831, var79);
                     }
                  }
               }

               if(var20 != var3.offset - var21) {
                  throw new RuntimeException(var3.offset - var21 + " " + var20);
               }

               class49.method789();
               var1.serverPacket = null;
               return true;
            }

            long var28;
            long var30;
            long var32;
            String var56;
            if(ServerPacket.field2281 == var1.serverPacket) {
               var56 = var3.readString();
               var28 = var3.readLong();
               var30 = (long)var3.readUnsignedShort();
               var32 = (long)var3.read24BitInt();
               Permission[] var96 = new Permission[]{Permission.field3341, Permission.field3345, Permission.field3344, Permission.field3342, Permission.field3340, Permission.field3343};
               Permission var25 = (Permission)WorldMapRectangle.forOrdinal(var96, var3.readUnsignedByte());
               long var35 = (var30 << 32) + var32;
               boolean var82 = false;

               for(var16 = 0; var16 < 100; ++var16) {
                  if(field1065[var16] == var35) {
                     var82 = true;
                     break;
                  }
               }

               if(var25.field3348 && WallObject.friendManager.method1727(new Name(var56, KeyFocusListener.loginType))) {
                  var82 = true;
               }

               if(!var82 && myPlayerIndex == 0) {
                  field1065[field1066] = var35;
                  field1066 = (field1066 + 1) % 100;
                  String var37 = FontTypeFace.appendTags(class303.method5404(WorldMapType1.method287(var3)));
                  if(var25.field3346 != -1) {
                     class64.addChatMessage(9, class157.method3168(var25.field3346) + var56, var37, class25.method200(var28));
                  } else {
                     class64.addChatMessage(9, var56, var37, class25.method200(var28));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2328 == var1.serverPacket) {
               for(var20 = 0; var20 < VarPlayerType.field3448; ++var20) {
                  VarPlayerType var67 = method1275(var20);
                  if(var67 != null) {
                     class237.settings[var20] = 0;
                     class237.widgetSettings[var20] = 0;
                  }
               }

               class38.method549();
               field1033 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2270 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2459);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2262 == var1.serverPacket) {
               var21 = var3.readUnsignedByte();
               class320[] var94 = new class320[]{class320.field3933, class320.field3935, class320.field3934};
               class320[] var74 = var94;
               var24 = 0;

               class320 var61;
               while(true) {
                  if(var24 >= var74.length) {
                     var61 = null;
                     break;
                  }

                  class320 var99 = var74[var24];
                  if(var21 == var99.field3936) {
                     var61 = var99;
                     break;
                  }

                  ++var24;
               }

               class196.field2568 = var61;
               var1.serverPacket = null;
               return true;
            }

            String var8;
            String var22;
            long var39;
            String var98;
            if(ServerPacket.field2303 == var1.serverPacket) {
               var56 = var3.readString();
               Projectile.sessionToken = var56;

               try {
                  var5 = class249.clientInstance.getParameter(Parameters.field3805.key);
                  var22 = class249.clientInstance.getParameter(Parameters.field3794.key);
                  String var69 = var5 + "settings=" + var56 + "; version=1; path=/; domain=" + var22;
                  if(var56.length() == 0) {
                     var69 = var69 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var8 = var69 + "; Expires=";
                     var39 = WorldMapRegion.method465() + 94608000000L;
                     class204.field2606.setTime(new Date(var39));
                     var12 = class204.field2606.get(7);
                     var93 = class204.field2606.get(5);
                     var14 = class204.field2606.get(2);
                     var81 = class204.field2606.get(1);
                     var16 = class204.field2606.get(11);
                     var17 = class204.field2606.get(12);
                     var27 = class204.field2606.get(13);
                     var98 = class204.field2602[var12 - 1] + ", " + var93 / 10 + var93 % 10 + "-" + class204.field2605[0][var14] + "-" + var81 + " " + var16 / 10 + var16 % 10 + ":" + var17 / 10 + var17 % 10 + ":" + var27 / 10 + var27 % 10 + " GMT";
                     var69 = var8 + var98 + "; Max-Age=" + 94608000L;
                  }

                  Client var75 = class249.clientInstance;
                  var98 = "document.cookie=\"" + var69 + "\"";
                  JSObject.getWindow(var75).eval(var98);
               } catch (Throwable var52) {
                  ;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2310 == var1.serverPacket) {
               class38.method549();
               var20 = var3.method3565();
               var21 = var3.method3566();
               var6 = var3.method3585();
               skillExperiences[var21] = var6;
               boostedSkillLevels[var21] = var20;
               realSkillLevels[var21] = 1;

               for(var23 = 0; var23 < 98; ++var23) {
                  if(var6 >= class248.field3006[var23]) {
                     realSkillLevels[var21] = var23 + 2;
                  }
               }

               field894[++field1037 - 1 & 31] = var21;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2322 == var1.serverPacket) {
               class23.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2268 == var1.serverPacket) {
               var20 = var3.method3587();
               var21 = var3.method3576();
               var6 = var3.method3576();
               var65 = GZipDecompressor.getWidget(var20);
               var65.field2815 = var6 + (var21 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2302 == var1.serverPacket) {
               var20 = var3.readInt();
               var21 = var3.readUnsignedShort();
               if(var20 < -70000) {
                  var21 += 32768;
               }

               if(var20 >= 0) {
                  var87 = GZipDecompressor.getWidget(var20);
               } else {
                  var87 = null;
               }

               for(; var3.offset < var1.packetLength; class21.setItemTableSlot(var21, var23, var24 - 1, var9)) {
                  var23 = var3.getUSmart();
                  var24 = var3.readUnsignedShort();
                  var9 = 0;
                  if(var24 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var87 != null && var23 >= 0 && var23 < var87.itemIds.length) {
                     var87.itemIds[var23] = var24;
                     var87.itemQuantities[var23] = var9;
                  }
               }

               if(var87 != null) {
                  GameEngine.method1053(var87);
               }

               class38.method549();
               interfaceItemTriggers[++field1035 - 1 & 31] = var21 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2340 == var1.serverPacket) {
               field851 = true;
               class183.field2466 = var3.readUnsignedByte();
               class22.field322 = var3.readUnsignedByte();
               WorldMapType1.field414 = var3.readUnsignedShort();
               BoundingBox3DDrawMode.field251 = var3.readUnsignedByte();
               class61.field701 = var3.readUnsignedByte();
               if(class61.field701 >= 100) {
                  Varcs.cameraX = class183.field2466 * 128 + 64;
                  BoundingBox3D.cameraY = class22.field322 * 128 + 64;
                  class160.cameraZ = class149.getTileHeight(Varcs.cameraX, BoundingBox3D.cameraY, Ignore.plane) - WorldMapType1.field414;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2317 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2455);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2293 == var1.serverPacket) {
               var20 = var3.method3585();
               var21 = var3.method3693();
               var87 = GZipDecompressor.getWidget(var20);
               if(var21 != var87.field2838 || var21 == -1) {
                  var87.field2838 = var21;
                  var87.field2939 = 0;
                  var87.field2940 = 0;
                  GameEngine.method1053(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var91;
            if(ServerPacket.field2344 == var1.serverPacket) {
               var91 = var3.method3544();
               if(var91) {
                  if(NetWriter.field1467 == null) {
                     NetWriter.field1467 = new class265();
                  }
               } else {
                  NetWriter.field1467 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2275 == var1.serverPacket) {
               var20 = var3.readInt();
               WidgetNode var64 = (WidgetNode)componentTable.get((long)var20);
               if(var64 != null) {
                  class93.closeWidget(var64, true);
               }

               if(field1012 != null) {
                  GameEngine.method1053(field1012);
                  field1012 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2342 == var1.serverPacket) {
               var20 = var3.method3587();
               var21 = var3.method3574();
               var87 = GZipDecompressor.getWidget(var20);
               if(var87 != null && var87.type == 0) {
                  if(var21 > var87.scrollHeight - var87.height) {
                     var21 = var87.scrollHeight - var87.height;
                  }

                  if(var21 < 0) {
                     var21 = 0;
                  }

                  if(var21 != var87.scrollY) {
                     var87.scrollY = var21;
                     GameEngine.method1053(var87);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2315 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2456);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2301 == var1.serverPacket) {
               var20 = var3.readUnsignedShortOb1();
               widgetRoot = var20;
               this.method1272(false);
               if(Script.loadWidget(var20)) {
                  Widget[] var63 = Widget.widgets[var20];

                  for(var6 = 0; var6 < var63.length; ++var6) {
                     var65 = var63[var6];
                     if(var65 != null) {
                        var65.field2939 = 0;
                        var65.field2940 = 0;
                     }
                  }
               }

               WorldMapData.method312(widgetRoot);

               for(var21 = 0; var21 < 100; ++var21) {
                  field1051[var21] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2329 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               if(var20 == 65535) {
                  var20 = -1;
               }

               var21 = var3.method3585();
               var6 = var3.method3587();
               var65 = GZipDecompressor.getWidget(var21);
               ItemComposition var73;
               if(!var65.hasScript) {
                  if(var20 == -1) {
                     var65.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var73 = class81.getItemDefinition(var20);
                  var65.modelType = 4;
                  var65.modelId = var20;
                  var65.rotationX = var73.xan2d;
                  var65.rotationZ = var73.yan2d;
                  var65.modelZoom = var73.zoom2d * 100 / var6;
                  GameEngine.method1053(var65);
               } else {
                  var65.itemId = var20;
                  var65.itemQuantity = var6;
                  var73 = class81.getItemDefinition(var20);
                  var65.rotationX = var73.xan2d;
                  var65.rotationZ = var73.yan2d;
                  var65.rotationY = var73.zan2d;
                  var65.field2866 = var73.offsetX2d;
                  var65.field2867 = var73.offsetY2d;
                  var65.modelZoom = var73.zoom2d;
                  if(var73.isStackable == 1) {
                     var65.field2864 = 1;
                  } else {
                     var65.field2864 = 2;
                  }

                  if(var65.field2872 > 0) {
                     var65.modelZoom = var65.modelZoom * 32 / var65.field2872;
                  } else if(var65.originalWidth > 0) {
                     var65.modelZoom = var65.modelZoom * 32 / var65.originalWidth;
                  }

                  GameEngine.method1053(var65);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2341 == var1.serverPacket) {
               AttackOption.method1924(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2291 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2458);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2287 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2461);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2283 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  BoundingBox.method50(widgetRoot, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2286 == var1.serverPacket) {
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

            if(ServerPacket.field2285 == var1.serverPacket) {
               class167.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2309 == var1.serverPacket) {
               FaceNormal.field2034 = var3.method3566();
               class64.field742 = var3.method3566();

               for(var20 = class64.field742; var20 < class64.field742 + 8; ++var20) {
                  for(var21 = FaceNormal.field2034; var21 < FaceNormal.field2034 + 8; ++var21) {
                     if(groundItemDeque[Ignore.plane][var20][var21] != null) {
                        groundItemDeque[Ignore.plane][var20][var21] = null;
                        GameCanvas.groundItemSpawned(var20, var21);
                     }
                  }
               }

               for(PendingSpawn var59 = (PendingSpawn)pendingSpawns.getFront(); var59 != null; var59 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var59.x >= class64.field742 && var59.x < class64.field742 + 8 && var59.y >= FaceNormal.field2034 && var59.y < FaceNormal.field2034 + 8 && var59.level == Ignore.plane) {
                     var59.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2326 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               var21 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var23 = var3.readUnsignedByte();
               field1091[var20] = true;
               field1092[var20] = var21;
               field1093[var20] = var6;
               field1094[var20] = var23;
               field1096[var20] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2313 == var1.serverPacket) {
               var56 = var3.readString();
               Object[] var62 = new Object[var56.length() + 1];

               for(var6 = var56.length() - 1; var6 >= 0; --var6) {
                  if(var56.charAt(var6) == 's') {
                     var62[var6 + 1] = var3.readString();
                  } else {
                     var62[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var62[0] = new Integer(var3.readInt());
               ScriptEvent var92 = new ScriptEvent();
               var92.objs = var62;
               class25.runScript(var92, 500000);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2324 == var1.serverPacket) {
               var20 = var3.method3585();
               var21 = var3.method3576();
               class237.settings[var21] = var20;
               if(class237.widgetSettings[var21] != var20) {
                  class237.widgetSettings[var21] = var20;
               }

               class5.method14(var21);
               field1032[++field1033 - 1 & 31] = var21;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2290 == var1.serverPacket) {
               var20 = var3.method3565();
               var5 = var3.readString();
               var6 = var3.method3566();
               if(var20 >= 1 && var20 <= 8) {
                  if(var5.equalsIgnoreCase("null")) {
                     var5 = null;
                  }

                  playerOptions[var20 - 1] = var5;
                  playerOptionsPriorities[var20 - 1] = var6 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2335 == var1.serverPacket) {
               var20 = var3.readUnsignedShortOb1();
               class25.method197(var20);
               interfaceItemTriggers[++field1035 - 1 & 31] = var20 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2338 == var1.serverPacket) {
               var56 = var3.readString();
               var21 = var3.method3585();
               var87 = GZipDecompressor.getWidget(var21);
               if(!var56.equals(var87.text)) {
                  var87.text = var56;
                  GameEngine.method1053(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2272 == var1.serverPacket) {
               World var57 = new World();
               var57.address = var3.readString();
               var57.id = var3.readUnsignedShort();
               var21 = var3.readInt();
               var57.mask = var21;
               class20.setGameState(45);
               var2.vmethod3339();
               var2 = null;
               class45.changeWorld(var57);
               var1.serverPacket = null;
               return false;
            }

            boolean var84;
            if(ServerPacket.field2282 == var1.serverPacket) {
               var20 = var3.method3585();
               var84 = var3.method3565() == 1;
               var87 = GZipDecompressor.getWidget(var20);
               if(var84 != var87.isHidden) {
                  var87.isHidden = var84;
                  GameEngine.method1053(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2325 == var1.serverPacket) {
               field1003 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2278 == var1.serverPacket) {
               var56 = var3.readString();

               try {
                  var23 = var3.getUSmart();
                  if(var23 > 32767) {
                     var23 = 32767;
                  }

                  byte[] var72 = new byte[var23];
                  var3.offset += class313.huffman.decompress(var3.payload, var3.offset, var72, 0, var23);
                  var98 = MessageNode.getString(var72, 0, var23);
                  var22 = var98;
               } catch (Exception var51) {
                  var22 = "Cabbage";
               }

               var22 = FontTypeFace.appendTags(class303.method5404(var22));
               TotalQuantityComparator.sendGameMessage(6, var56, var22);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2277 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2460);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2306 == var1.serverPacket) {
               var20 = var3.readUnsignedShortOb1();
               var21 = var3.method3586();
               var87 = GZipDecompressor.getWidget(var21);
               if(var87.modelType != 1 || var20 != var87.modelId) {
                  var87.modelType = 1;
                  var87.modelId = var20;
                  GameEngine.method1053(var87);
               }

               var1.serverPacket = null;
               return true;
            }

            int var10;
            if(ServerPacket.field2279 == var1.serverPacket) {
               var20 = var3.readInt();
               var21 = var3.readUnsignedShort();
               if(var20 < -70000) {
                  var21 += 32768;
               }

               if(var20 >= 0) {
                  var87 = GZipDecompressor.getWidget(var20);
               } else {
                  var87 = null;
               }

               if(var87 != null) {
                  for(var23 = 0; var23 < var87.itemIds.length; ++var23) {
                     var87.itemIds[var23] = 0;
                     var87.itemQuantities[var23] = 0;
                  }
               }

               class163.method3212(var21);
               var23 = var3.readUnsignedShort();

               for(var24 = 0; var24 < var23; ++var24) {
                  var9 = var3.method3574();
                  var10 = var3.method3567();
                  if(var10 == 255) {
                     var10 = var3.readInt();
                  }

                  if(var87 != null && var24 < var87.itemIds.length) {
                     var87.itemIds[var24] = var9;
                     var87.itemQuantities[var24] = var10;
                  }

                  class21.setItemTableSlot(var21, var24, var9 - 1, var10);
               }

               if(var87 != null) {
                  GameEngine.method1053(var87);
               }

               class38.method549();
               interfaceItemTriggers[++field1035 - 1 & 31] = var21 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2312 == var1.serverPacket) {
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

            if(ServerPacket.field2261 == var1.serverPacket) {
               var91 = var3.readUnsignedByte() == 1;
               if(var91) {
                  class204.field2603 = WorldMapRegion.method465() - var3.readLong();
                  Occluder.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  Occluder.grandExchangeEvents = null;
               }

               field913 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2267 == var1.serverPacket) {
               var20 = var3.readUnsignedShortOb1();
               if(var20 == 65535) {
                  var20 = -1;
               }

               var21 = var3.method3574();
               if(var21 == 65535) {
                  var21 = -1;
               }

               var6 = var3.readInt();
               var23 = var3.method3585();

               for(var24 = var21; var24 <= var20; ++var24) {
                  var32 = ((long)var6 << 32) + (long)var24;
                  Node var34 = widgetFlags.get(var32);
                  if(var34 != null) {
                     var34.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var23), var32);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2343 == var1.serverPacket) {
               class167.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2319 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var20] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var20] = new GrandExchangeOffer(var3, false);
               }

               field1057 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2300 == var1.serverPacket) {
               var20 = var3.readUnsignedByte();
               MapCacheArchiveNames.method594(var20);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2273 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var21 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               DynamicObject.method2052(var20, var21, var6);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2318 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2464);
               var1.serverPacket = null;
               return true;
            }

            long var43;
            if(ServerPacket.field2298 == var1.serverPacket) {
               var20 = var3.readInt();
               var21 = var3.readInt();
               var23 = 0;
               if(class5.field32 == null || !class5.field32.isValid()) {
                  try {
                     Iterator var70 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var70.hasNext()) {
                        GarbageCollectorMXBean var97 = (GarbageCollectorMXBean)var70.next();
                        if(var97.isValid()) {
                           class5.field32 = var97;
                           GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                           GameEngine.garbageCollectorLastCollectionTime = -1L;
                        }
                     }
                  } catch (Throwable var53) {
                     ;
                  }
               }

               if(class5.field32 != null) {
                  long var41 = WorldMapRegion.method465();
                  var39 = class5.field32.getCollectionTime();
                  if(GameEngine.garbageCollectorLastCollectionTime != -1L) {
                     var43 = var39 - GameEngine.garbageCollectorLastCollectionTime;
                     long var45 = var41 - GameEngine.garbageCollectorLastCheckTimeMs;
                     if(var45 != 0L) {
                        var23 = (int)(var43 * 100L / var45);
                     }
                  }

                  GameEngine.garbageCollectorLastCollectionTime = var39;
                  GameEngine.garbageCollectorLastCheckTimeMs = var41;
               }

               PacketNode var71 = class33.method382(ClientPacket.field2440, field1072.field1456);
               var71.packetBuffer.method3562(GameEngine.FPS);
               var71.packetBuffer.method3562(var23);
               var71.packetBuffer.method3584(var20);
               var71.packetBuffer.method3713(var21);
               field1072.method2073(var71);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2271 == var1.serverPacket) {
               WallObject.friendManager.method1723(var3, var1.packetLength);
               field1039 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2332 == var1.serverPacket) {
               WallObject.friendManager.method1752();
               field1039 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2334 == var1.serverPacket) {
               class132.method2765();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2296 == var1.serverPacket) {
               byte var85 = var3.method3613();
               var21 = var3.method3574();
               class237.settings[var21] = var85;
               if(class237.widgetSettings[var21] != var85) {
                  class237.widgetSettings[var21] = var85;
               }

               class5.method14(var21);
               field1032[++field1033 - 1 & 31] = var21;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2320 == var1.serverPacket) {
               class38.method549();
               weight = var3.readShort();
               field981 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2314 == var1.serverPacket) {
               var20 = var3.method3587();
               var60 = GZipDecompressor.getWidget(var20);

               for(var6 = 0; var6 < var60.itemIds.length; ++var6) {
                  var60.itemIds[var6] = -1;
                  var60.itemIds[var6] = 0;
               }

               GameEngine.method1053(var60);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2263 == var1.serverPacket) {
               var56 = var3.readString();
               var28 = (long)var3.readUnsignedShort();
               var30 = (long)var3.read24BitInt();
               Permission[] var38 = new Permission[]{Permission.field3341, Permission.field3345, Permission.field3344, Permission.field3342, Permission.field3340, Permission.field3343};
               Permission var101 = (Permission)WorldMapRectangle.forOrdinal(var38, var3.readUnsignedByte());
               long var48 = (var28 << 32) + var30;
               boolean var26 = false;

               for(var14 = 0; var14 < 100; ++var14) {
                  if(field1065[var14] == var48) {
                     var26 = true;
                     break;
                  }
               }

               if(WallObject.friendManager.method1727(new Name(var56, KeyFocusListener.loginType))) {
                  var26 = true;
               }

               if(!var26 && myPlayerIndex == 0) {
                  field1065[field1066] = var48;
                  field1066 = (field1066 + 1) % 100;
                  String var50 = FontTypeFace.appendTags(class303.method5404(WorldMapType1.method287(var3)));
                  byte var15;
                  if(var101.field3339) {
                     var15 = 7;
                  } else {
                     var15 = 3;
                  }

                  if(var101.field3346 != -1) {
                     TotalQuantityComparator.sendGameMessage(var15, class157.method3168(var101.field3346) + var56, var50);
                  } else {
                     TotalQuantityComparator.sendGameMessage(var15, var56, var50);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2304 == var1.serverPacket) {
               var20 = var3.readUnsignedShort();
               var21 = var3.readInt();
               var6 = var3.method3565();
               var7 = (WidgetNode)componentTable.get((long)var21);
               if(var7 != null) {
                  class93.closeWidget(var7, var20 != var7.id);
               }

               class132.openWidget(var21, var20, var6);
               var1.serverPacket = null;
               return true;
            }

            Widget var47;
            if(ServerPacket.field2307 == var1.serverPacket) {
               var20 = var3.method3576();
               var21 = var3.readInt();
               var6 = var20 >> 10 & 31;
               var23 = var20 >> 5 & 31;
               var24 = var20 & 31;
               var9 = (var23 << 11) + (var6 << 19) + (var24 << 3);
               var47 = GZipDecompressor.getWidget(var21);
               if(var9 != var47.textColor) {
                  var47.textColor = var9;
                  GameEngine.method1053(var47);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2311 == var1.serverPacket) {
               var20 = var3.method3576();
               var21 = var3.method3576();
               var6 = var3.readUnsignedShortOb1();
               var23 = var3.method3585();
               var68 = GZipDecompressor.getWidget(var23);
               if(var21 != var68.rotationX || var20 != var68.rotationZ || var6 != var68.modelZoom) {
                  var68.rotationX = var21;
                  var68.rotationZ = var20;
                  var68.modelZoom = var6;
                  GameEngine.method1053(var68);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               var20 = var3.offset + var1.packetLength;
               var21 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var21 != widgetRoot) {
                  widgetRoot = var21;
                  this.method1272(false);
                  var23 = widgetRoot;
                  if(Script.loadWidget(var23)) {
                     Widget[] var66 = Widget.widgets[var23];

                     for(var9 = 0; var9 < var66.length; ++var9) {
                        var47 = var66[var9];
                        if(var47 != null) {
                           var47.field2939 = 0;
                           var47.field2940 = 0;
                        }
                     }
                  }

                  WorldMapData.method312(widgetRoot);

                  for(var24 = 0; var24 < 100; ++var24) {
                     field1051[var24] = true;
                  }
               }

               WidgetNode var100;
               for(; var6-- > 0; var100.field773 = true) {
                  var23 = var3.readInt();
                  var24 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var100 = (WidgetNode)componentTable.get((long)var23);
                  if(var100 != null && var24 != var100.id) {
                     class93.closeWidget(var100, true);
                     var100 = null;
                  }

                  if(var100 == null) {
                     var100 = class132.openWidget(var23, var24, var9);
                  }
               }

               for(var7 = (WidgetNode)componentTable.first(); var7 != null; var7 = (WidgetNode)componentTable.next()) {
                  if(var7.field773) {
                     var7.field773 = false;
                  } else {
                     class93.closeWidget(var7, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var20) {
                  var23 = var3.readInt();
                  var24 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(var11 = var24; var11 <= var9; ++var11) {
                     var43 = (long)var11 + ((long)var23 << 32);
                     widgetFlags.put(new IntegerNode(var10), var43);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2288 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  Size.method188(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2323 == var1.serverPacket) {
               var20 = var3.readInt();
               if(var20 != field930) {
                  field930 = var20;
                  if(field923 == 1) {
                     field954 = true;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2316 == var1.serverPacket) {
               FaceNormal.field2034 = var3.readUnsignedByte();
               class64.field742 = var3.method3566();

               while(var3.offset < var1.packetLength) {
                  var20 = var3.readUnsignedByte();
                  class183[] var58 = new class183[]{class183.field2461, class183.field2456, class183.field2459, class183.field2458, class183.field2455, class183.field2460, class183.field2457, class183.field2462, class183.field2463, class183.field2464};
                  class183 var86 = var58[var20];
                  SceneTilePaint.method2862(var86);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2336 == var1.serverPacket) {
               SceneTilePaint.method2862(class183.field2463);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2284 == var1.serverPacket) {
               if(var1.packetLength == 0) {
                  KeyFocusListener.clanMemberManager = null;
               } else {
                  if(KeyFocusListener.clanMemberManager == null) {
                     KeyFocusListener.clanMemberManager = new ClanMemberManager(KeyFocusListener.loginType, class249.clientInstance);
                  }

                  KeyFocusListener.clanMemberManager.method5451(var3);
               }

               class204.method3855();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2339 == var1.serverPacket) {
               var20 = var3.getUSmart();
               var84 = var3.readUnsignedByte() == 1;
               var22 = "";
               boolean var88 = false;
               if(var84) {
                  var22 = var3.readString();
                  if(WallObject.friendManager.method1727(new Name(var22, KeyFocusListener.loginType))) {
                     var88 = true;
                  }
               }

               var8 = var3.readString();
               if(!var88) {
                  TotalQuantityComparator.sendGameMessage(var20, var22, var8);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2308 == var1.serverPacket) {
               if(KeyFocusListener.clanMemberManager != null) {
                  KeyFocusListener.clanMemberManager.method5452(var3);
               }

               class204.method3855();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2337 == var1.serverPacket) {
               field865 = var3.readUnsignedShort() * 30;
               field981 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2327 == var1.serverPacket) {
               field851 = true;
               class254.field3329 = var3.readUnsignedByte();
               class27.field372 = var3.readUnsignedByte();
               class2.field15 = var3.readUnsignedShort();
               class21.field316 = var3.readUnsignedByte();
               GameCanvas.field624 = var3.readUnsignedByte();
               if(GameCanvas.field624 >= 100) {
                  var20 = class254.field3329 * 128 + 64;
                  var21 = class27.field372 * 128 + 64;
                  var6 = class149.getTileHeight(var20, var21, Ignore.plane) - class2.field15;
                  var23 = var20 - Varcs.cameraX;
                  var24 = var6 - class160.cameraZ;
                  var9 = var21 - BoundingBox3D.cameraY;
                  var10 = (int)Math.sqrt((double)(var9 * var9 + var23 * var23));
                  class33.cameraPitch = (int)(Math.atan2((double)var24, (double)var10) * 325.949D) & 2047;
                  class62.cameraYaw = (int)(Math.atan2((double)var23, (double)var9) * -325.949D) & 2047;
                  if(class33.cameraPitch < 128) {
                     class33.cameraPitch = 128;
                  }

                  if(class33.cameraPitch > 383) {
                     class33.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            GroundObject.processClientError("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1457 != null?var1.field1457.packetId:-1) + "," + (var1.field1465 != null?var1.field1465.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            class132.method2765();
         } catch (IOException var54) {
            class28.method253();
         } catch (Exception var55) {
            var5 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1457 != null?var1.field1457.packetId:-1) + "," + (var1.field1465 != null?var1.field1465.packetId:-1) + "," + var1.packetLength + "," + (WorldMapData.localPlayer.pathX[0] + class38.baseX) + "," + (WorldMapData.localPlayer.pathY[0] + PlayerComposition.baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var5 = var5 + var3.payload[var6] + ",";
            }

            GroundObject.processClientError(var5, var55);
            class132.method2765();
         }

         return true;
      }
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "483955045"
   )
   final void method1264() {
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

      if(MapIconReference.field574 == null) {
         if(draggedWidget == null) {
            int var19 = MouseInput.mouseLastButton;
            int var7;
            int var15;
            int var20;
            if(isMenuOpen) {
               int var14;
               if(var19 != 1 && (class153.middleMouseMovesCamera || var19 != 4)) {
                  var2 = MouseInput.mouseLastX;
                  var14 = MouseInput.mouseLastY;
                  if(var2 < TextureProvider.menuX - 10 || var2 > TextureProvider.menuX + class23.field331 + 10 || var14 < class90.menuY - 10 || var14 > class90.menuY + MapIconReference.field571 + 10) {
                     isMenuOpen = false;
                     GameCanvas.method846(TextureProvider.menuX, class90.menuY, class23.field331, MapIconReference.field571);
                  }
               }

               if(var19 == 1 || !class153.middleMouseMovesCamera && var19 == 4) {
                  var2 = TextureProvider.menuX;
                  var14 = class90.menuY;
                  var15 = class23.field331;
                  var5 = MouseInput.mouseLastPressedX;
                  var20 = MouseInput.mouseLastPressedY;
                  var7 = -1;

                  int var8;
                  int var9;
                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = var14 + (menuOptionCount - 1 - var8) * 15 + 31;
                     if(var5 > var2 && var5 < var15 + var2 && var20 > var9 - 13 && var20 < var9 + 3) {
                        var7 = var8;
                     }
                  }

                  if(var7 != -1 && var7 >= 0) {
                     var8 = menuActionParams0[var7];
                     var9 = menuActionParams1[var7];
                     int var10 = menuTypes[var7];
                     int var11 = menuIdentifiers[var7];
                     String var12 = menuOptions[var7];
                     String var13 = menuTargets[var7];
                     class3.menuAction(var8, var9, var10, var11, var12, var13, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }

                  isMenuOpen = false;
                  GameCanvas.method846(TextureProvider.menuX, class90.menuY, class23.field331, MapIconReference.field571);
               }
            } else {
               var2 = menuOptionCount - 1;
               if((var19 == 1 || !class153.middleMouseMovesCamera && var19 == 4) && var2 >= 0) {
                  var15 = menuTypes[var2];
                  if(var15 == 39 || var15 == 40 || var15 == 41 || var15 == 42 || var15 == 43 || var15 == 33 || var15 == 34 || var15 == 35 || var15 == 36 || var15 == 37 || var15 == 38 || var15 == 1005) {
                     var5 = menuActionParams0[var2];
                     var20 = menuActionParams1[var2];
                     Widget var16 = GZipDecompressor.getWidget(var20);
                     if(class153.method3142(GrandExchangeEvent.getWidgetConfig(var16)) || class154.method3149(GrandExchangeEvent.getWidgetConfig(var16))) {
                        if(MapIconReference.field574 != null && !field960 && menuOptionCount > 0 && !this.method1270()) {
                           class153.method3140(field957, field958);
                        }

                        field960 = false;
                        itemPressedDuration = 0;
                        if(MapIconReference.field574 != null) {
                           GameEngine.method1053(MapIconReference.field574);
                        }

                        MapIconReference.field574 = GZipDecompressor.getWidget(var20);
                        field998 = var5;
                        field957 = MouseInput.mouseLastPressedX;
                        field958 = MouseInput.mouseLastPressedY;
                        if(var2 >= 0) {
                           WorldMapDecoration.topContextMenuRow = new ContextMenuRow();
                           WorldMapDecoration.topContextMenuRow.param0 = menuActionParams0[var2];
                           WorldMapDecoration.topContextMenuRow.param1 = menuActionParams1[var2];
                           WorldMapDecoration.topContextMenuRow.type = menuTypes[var2];
                           WorldMapDecoration.topContextMenuRow.identifier = menuIdentifiers[var2];
                           WorldMapDecoration.topContextMenuRow.option = menuOptions[var2];
                        }

                        GameEngine.method1053(MapIconReference.field574);
                        return;
                     }
                  }
               }

               if((var19 == 1 || !class153.middleMouseMovesCamera && var19 == 4) && this.method1270()) {
                  var19 = 2;
               }

               if((var19 == 1 || !class153.middleMouseMovesCamera && var19 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var15 = menuActionParams0[var2];
                  var5 = menuActionParams1[var2];
                  var20 = menuTypes[var2];
                  var7 = menuIdentifiers[var2];
                  String var17 = menuOptions[var2];
                  String var18 = menuTargets[var2];
                  class3.menuAction(var15, var5, var20, var7, var17, var18, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
               }

               if(var19 == 2 && menuOptionCount > 0) {
                  this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
               }
            }

         }
      }
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1106972606"
   )
   final boolean method1270() {
      int var1 = menuOptionCount - 1;
      return (field1022 == 1 && menuOptionCount > 2 || class153.method3144(var1)) && !menuBooleanArray[var1];
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-1976"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      int var3 = class5.fontBold12.getTextWidth("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = class5.fontBold12.getTextWidth(class44.method677(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var5 + var3 > WallObject.canvasWidth) {
         var5 = WallObject.canvasWidth - var3;
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

      class38.region.method2973(Ignore.plane, var1, var2, false);
      isMenuOpen = true;
      TextureProvider.menuX = var5;
      class90.menuY = var6;
      class23.field331 = var3;
      MapIconReference.field571 = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "351526665"
   )
   final void method1272(boolean var1) {
      int var2 = widgetRoot;
      int var3 = WallObject.canvasWidth;
      int var4 = GameEngine.canvasHeight;
      if(Script.loadWidget(var2)) {
         class55.method856(Widget.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(Lig;I)V",
      garbageValue = "-414978920"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:GZipDecompressor.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = WallObject.canvasWidth;
         var4 = GameEngine.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class44.method674(var1, var3, var4, false);
      class19.method159(var1, var3, var4);
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2078182693"
   )
   final void method1432() {
      GameEngine.method1053(draggedWidget);
      ++MapLabel.field446;
      if(field1095 && field1024) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field1021;
         var2 -= field1015;
         if(var1 < field1025) {
            var1 = field1025;
         }

         if(var1 + draggedWidget.width > field1025 + field1020.width) {
            var1 = field1025 + field1020.width - draggedWidget.width;
         }

         if(var2 < field1098) {
            var2 = field1098;
         }

         if(var2 + draggedWidget.height > field1098 + field1020.height) {
            var2 = field1098 + field1020.height - draggedWidget.height;
         }

         int var3 = var1 - field1028;
         int var4 = var2 - field944;
         int var5 = draggedWidget.field2817;
         if(MapLabel.field446 > draggedWidget.field2894 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            draggingWidget = true;
         }

         int var6 = var1 - field1025 + field1020.scrollX;
         int var7 = var2 - field1098 + field1020.scrollY;
         ScriptEvent var8;
         if(draggedWidget.field2906 != null && draggingWidget) {
            var8 = new ScriptEvent();
            var8.widget = draggedWidget;
            var8.field782 = var6;
            var8.field789 = var7;
            var8.objs = draggedWidget.field2906;
            class25.runScript(var8, 500000);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(draggingWidget) {
               if(draggedWidget.field2907 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = draggedWidget;
                  var8.field782 = var6;
                  var8.field789 = var7;
                  var8.field785 = draggedOnWidget;
                  var8.objs = draggedWidget.field2907;
                  class25.runScript(var8, 500000);
               }

               if(draggedOnWidget != null && RunException.method3217(draggedWidget) != null) {
                  PacketNode var9 = class33.method382(ClientPacket.field2422, field1072.field1456);
                  var9.packetBuffer.putShort(draggedWidget.itemId);
                  var9.packetBuffer.method3573(draggedOnWidget.index);
                  var9.packetBuffer.putInt(draggedWidget.id);
                  var9.packetBuffer.method3582(draggedOnWidget.id);
                  var9.packetBuffer.method3573(draggedWidget.index);
                  var9.packetBuffer.putShort(draggedOnWidget.itemId);
                  field1072.method2073(var9);
               }
            } else if(this.method1270()) {
               this.openMenu(field1028 + field1021, field1015 + field944);
            } else if(menuOptionCount > 0) {
               class153.method3140(field1028 + field1021, field1015 + field944);
            }

            draggedWidget = null;
         }

      } else {
         if(MapLabel.field446 > 1) {
            draggedWidget = null;
         }

      }
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(B)Lkb;",
      garbageValue = "0"
   )
   public Name vmethod5402() {
      return WorldMapData.localPlayer != null?WorldMapData.localPlayer.name:null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "2064360694"
   )
   public static String method1303(byte[] var0) {
      return class152.method3127(var0, 0, var0.length);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljn;",
      garbageValue = "-110964354"
   )
   public static VarPlayerType method1275(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1325610030"
   )
   static final String method1645(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1680452673"
   )
   static final void method1257() {
      PacketBuffer var0 = field1072.packetBuffer;
      var0.bitAccess();
      int var1 = var0.getBits(8);
      int var2;
      if(var1 < npcIndexesCount) {
         for(var2 = var1; var2 < npcIndexesCount; ++var2) {
            field970[++field969 - 1] = npcIndices[var2];
         }
      }

      if(var1 > npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         npcIndexesCount = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = npcIndices[var2];
            NPC var4 = cachedNPCs[var3];
            int var5 = var0.getBits(1);
            if(var5 == 0) {
               npcIndices[++npcIndexesCount - 1] = var3;
               var4.npcCycle = gameCycle;
            } else {
               int var6 = var0.getBits(2);
               if(var6 == 0) {
                  npcIndices[++npcIndexesCount - 1] = var3;
                  var4.npcCycle = gameCycle;
                  pendingNpcFlagsIndices[++pendingNpcFlagsCount - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     npcIndices[++npcIndexesCount - 1] = var3;
                     var4.npcCycle = gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1890(var7, (byte)1);
                     var8 = var0.getBits(1);
                     if(var8 == 1) {
                        pendingNpcFlagsIndices[++pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     npcIndices[++npcIndexesCount - 1] = var3;
                     var4.npcCycle = gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1890(var7, (byte)2);
                     var8 = var0.getBits(3);
                     var4.method1890(var8, (byte)2);
                     int var9 = var0.getBits(1);
                     if(var9 == 1) {
                        pendingNpcFlagsIndices[++pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     field970[++field969 - 1] = var3;
                  }
               }
            }
         }

      }
   }
}
