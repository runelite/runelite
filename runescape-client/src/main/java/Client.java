import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements class277 {
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 2094846361
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -1084032149
   )
   static int field1024;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      longValue = 840202343473913989L
   )
   static long field1020;
   @ObfuscatedName("on")
   static boolean field1014;
   @ObfuscatedName("mj")
   static boolean[] field1012;
   @ObfuscatedName("mx")
   static boolean[] field833;
   @ObfuscatedName("mq")
   static boolean[] field1013;
   @ObfuscatedName("mf")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -1692762871
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -128745931
   )
   static int field1000;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -1804347033
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("ms")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("mz")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("mk")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("mp")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("md")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "Lbo;"
   )
   static final class70 field896;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 1741560539
   )
   static int field879;
   @ObfuscatedName("mt")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   static Deque field1006;
   @ObfuscatedName("qe")
   static int[] field848;
   @ObfuscatedName("qv")
   static int[] field1079;
   @ObfuscatedName("ou")
   static boolean field1051;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -227498671
   )
   static int field949;
   @ObfuscatedName("pj")
   static boolean[] field1052;
   @ObfuscatedName("lx")
   static int[] field993;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 1603216553
   )
   static int field1041;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -1302850221
   )
   static int field994;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 1327056173
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -1844876615
   )
   static int field952;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      longValue = -6379804159142143153L
   )
   static long field822;
   @ObfuscatedName("lm")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 1824127255
   )
   static int field1071;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = -734988735
   )
   static int field1073;
   @ObfuscatedName("pq")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static PlayerComposition field1081;
   @ObfuscatedName("nu")
   static long[] field965;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 1980602369
   )
   static int field1072;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1821173107
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("qk")
   static ArrayList field1075;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 445602891
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -1411913659
   )
   static int field1031;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = 1715248067
   )
   static int field1040;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = 374600687
   )
   static int field1027;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -441918997
   )
   static int field1008;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 15748205
   )
   @Export("queuedSoundEffectCount")
   static int queuedSoundEffectCount;
   @ObfuscatedName("oe")
   @Export("unknownSoundValues2")
   static int[] unknownSoundValues2;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 1899135241
   )
   static int field1050;
   @ObfuscatedName("oh")
   @ObfuscatedSignature(
      signature = "[Lcr;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("oj")
   @Export("queuedSoundEffectIDs")
   static int[] queuedSoundEffectIDs;
   @ObfuscatedName("of")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("ov")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 547651317
   )
   static int field1033;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1873974225
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("no")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("nt")
   static int[] field1034;
   @ObfuscatedName("pl")
   static short field1057;
   @ObfuscatedName("pn")
   static short field1058;
   @ObfuscatedName("np")
   static int[] field1035;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = 1105944961
   )
   static int field1028;
   @ObfuscatedName("ph")
   static short field1063;
   @ObfuscatedName("pu")
   static short field1064;
   @ObfuscatedName("pw")
   static short field1062;
   @ObfuscatedName("pz")
   static short field856;
   @ObfuscatedName("pd")
   static short field1060;
   @ObfuscatedName("ps")
   static short field1061;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = 429082419
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = 1448475199
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("nn")
   static int[] field1030;
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "[Ld;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("nz")
   static int[] field1029;
   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   static Deque field1007;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -1233222399
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 1193666511
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 581593573
   )
   static int field1021;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -1696979475
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("mv")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   static Deque field917;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 290677317
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 105161503
   )
   static int field975;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -4903439
   )
   static int field862;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 561688211
   )
   static int field859;
   @ObfuscatedName("pb")
   static int[] field1054;
   @ObfuscatedName("pc")
   static int[] field908;
   @ObfuscatedName("pk")
   static int[] field1056;
   @ObfuscatedName("pe")
   static int[] field1055;
   @ObfuscatedName("lu")
   static int[] field1059;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 675760441
   )
   static int field998;
   @ObfuscatedName("na")
   static String field857;
   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "Lbv;"
   )
   static OwnWorldComparator field841;
   @ObfuscatedName("mn")
   static int[] field1022;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfg;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("ay")
   static int[] field1080;
   @ObfuscatedName("al")
   static boolean field913;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1175710119
   )
   @Export("world")
   public static int world;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1964263443
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("by")
   static String field1032;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1693808523
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bn")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bb")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 954547551
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bg")
   static String field828;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1819204289
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("be")
   static boolean field830;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1883652155
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      longValue = -6526915402365895675L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 986371673
   )
   static int field1065;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 498822995
   )
   static int field834;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1770218311
   )
   static int field915;
   @ObfuscatedName("ba")
   static boolean field845;
   @ObfuscatedName("bx")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 56101083
   )
   static int field904;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1780415617
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -627408461
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 492675569
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -697896405
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -31696545
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -139684783
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -619408453
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1686601581
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("ca")
   @Export("middleMouseMovesCamera")
   static boolean middleMouseMovesCamera;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lcu;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Lcu;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1168549313
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("rssocket")
   static class159 rssocket;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1706256281
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -846520535
   )
   static int field853;
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexCache10")
   static IndexData indexCache10;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 119573889
   )
   static int field1053;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 448265143
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -1345119029
   )
   static int field1078;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -1913563303
   )
   static int field843;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 300885933
   )
   static int field1036;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   static class148 field860;
   @ObfuscatedName("dx")
   static byte[] field1015;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "[Lch;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -1679141653
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dz")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 62868457
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("en")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   public static final NetWriter field867;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -1962935547
   )
   static int field1043;
   @ObfuscatedName("ee")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("em")
   static boolean field870;
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   static class299 field1076;
   @ObfuscatedName("ek")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -898925285
   )
   static int field873;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 551454231
   )
   static int field874;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = 1688004283
   )
   static int field875;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -1555036375
   )
   static int field1068;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -2114327577
   )
   static int field877;
   @ObfuscatedName("fl")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fx")
   static int[][][] field880;
   @ObfuscatedName("fb")
   static final int[] field1070;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -364785733
   )
   static int field882;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -1785106699
   )
   static int field885;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1619043467
   )
   static int field884;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 427713817
   )
   static int field925;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1911831131
   )
   static int field886;
   @ObfuscatedName("gj")
   static boolean field958;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1263785559
   )
   static int field888;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 853416861
   )
   static int field889;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 979556569
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -578927293
   )
   static int field891;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -990515193
   )
   static int field892;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -971664079
   )
   static int field893;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1930265393
   )
   static int field837;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1333605653
   )
   static int field895;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -2063762331
   )
   static int field1077;
   @ObfuscatedName("gr")
   static boolean field897;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1242533529
   )
   static int field898;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -621437409
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -1055872791
   )
   @Export("maxOverheadTexts")
   static int maxOverheadTexts;
   @ObfuscatedName("gf")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("gb")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("gu")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("hd")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("hw")
   static int[] field905;
   @ObfuscatedName("hp")
   static int[] field887;
   @ObfuscatedName("hg")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("hc")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("hh")
   static int[][] field909;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -469715911
   )
   static int field821;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -1408405743
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -1312710679
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 731050197
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 1396230931
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -1039288309
   )
   static int field871;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -740914869
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1214563041
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -1809503493
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -1739281729
   )
   static int field1002;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -1751269527
   )
   static int field914;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 2041847127
   )
   static int field1044;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -1089304719
   )
   static int field922;
   @ObfuscatedName("he")
   @Export("itemBeingDragged")
   static boolean itemBeingDragged;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 1442913363
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 921636061
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "[Lbc;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -1987045263
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -573894403
   )
   static int field928;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 726133351
   )
   static int field929;
   @ObfuscatedName("iu")
   static int[] field930;
   @ObfuscatedName("ic")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("if")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("ik")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("iy")
   static int[] field934;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -345075601
   )
   static int field935;
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "[[[Lgy;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -136257399
   )
   static int field960;
   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("il")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ib")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("ie")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -175514083
   )
   static int field1049;
   @ObfuscatedName("ij")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 1126535699
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("jv")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jj")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jl")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("jp")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jn")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("jm")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jy")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("ju")
   static boolean field953;
   @ObfuscatedName("ja")
   static boolean field954;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -466878303
   )
   static int field955;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -1201732285
   )
   static int field1025;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = -436626677
   )
   static int field1011;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -1195272047
   )
   static int field1003;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 951903423
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("je")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -878780549
   )
   static int field963;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -551629503
   )
   static int field964;
   @ObfuscatedName("ks")
   static String field1001;
   @ObfuscatedName("ke")
   static String field966;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 2045559477
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1055069109
   )
   static int field1042;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -1531038581
   )
   static int field970;
   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field971;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -272300141
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 2066527767
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 1657385803
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -1251208701
   )
   static int field890;
   @ObfuscatedName("kx")
   static boolean field976;
   @ObfuscatedName("kw")
   static boolean field977;
   @ObfuscatedName("kf")
   @Export("numberMenuOptions")
   static boolean numberMenuOptions;
   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field979;
   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field980;
   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field981;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 246679199
   )
   static int field982;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 1498799737
   )
   static int field983;
   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field858;
   @ObfuscatedName("kp")
   static boolean field985;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -210644879
   )
   static int field986;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -1675530265
   )
   static int field987;
   @ObfuscatedName("ld")
   static boolean field988;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 523412311
   )
   static int field989;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -880391061
   )
   static int field990;
   @ObfuscatedName("lk")
   static boolean field991;

   static {
      field913 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field830 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = 1L;
      field1065 = -1;
      field834 = -1;
      field915 = -1;
      field845 = true;
      displayFps = false;
      field904 = 0;
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
      field853 = 0;
      field1053 = 0;
      loginState = 0;
      field1078 = 0;
      field843 = 0;
      field1036 = 0;
      field860 = class148.field2075;
      field1015 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field867 = new NetWriter();
      field1043 = 0;
      socketError = false;
      field870 = true;
      field1076 = new class299();
      fontsMap = new HashMap();
      field873 = 0;
      field874 = 1;
      field875 = 0;
      field1068 = 1;
      field877 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field880 = new int[4][13][13];
      field1070 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field882 = 0;
      field885 = 2301979;
      field884 = 5063219;
      field925 = 3353893;
      field886 = 7759444;
      field958 = false;
      field888 = 0;
      field889 = 128;
      mapAngle = 0;
      field891 = 0;
      field892 = 0;
      field893 = 0;
      field837 = 0;
      field895 = 50;
      field1077 = 0;
      field897 = false;
      field898 = 0;
      overheadTextCount = 0;
      maxOverheadTexts = 50;
      overheadTextsX = new int[maxOverheadTexts];
      overheadTextsY = new int[maxOverheadTexts];
      overheadTextsOffsetY = new int[maxOverheadTexts];
      overheadTextsOffsetX = new int[maxOverheadTexts];
      field905 = new int[maxOverheadTexts];
      field887 = new int[maxOverheadTexts];
      overheadTextsCyclesRemaining = new int[maxOverheadTexts];
      overheadTexts = new String[maxOverheadTexts];
      field909 = new int[104][104];
      field821 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field871 = 0;
      cursorState = 0;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field1002 = 0;
      field914 = 0;
      field1044 = 0;
      field922 = 0;
      itemBeingDragged = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field928 = 0;
      field929 = 0;
      field930 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field934 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field935 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1049 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field953 = false;
      field954 = false;
      field955 = -1;
      field1025 = -1;
      field1011 = 0;
      field1003 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field963 = -1;
      field964 = -1;
      field1001 = null;
      field966 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1042 = 0;
      field970 = 0;
      field971 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field890 = -1;
      field976 = false;
      field977 = false;
      numberMenuOptions = false;
      field979 = null;
      field980 = null;
      field981 = null;
      field982 = 0;
      field983 = 0;
      field858 = null;
      field985 = false;
      field986 = -1;
      field987 = -1;
      field988 = false;
      field989 = -1;
      field990 = -1;
      field991 = false;
      cycleCntr = 1;
      field993 = new int[32];
      field994 = 0;
      interfaceItemTriggers = new int[32];
      field1073 = 0;
      field1059 = new int[32];
      field998 = 0;
      chatCycle = 0;
      field1000 = 0;
      field949 = 0;
      field1021 = 0;
      field859 = 0;
      field862 = 0;
      mouseWheelRotation = 0;
      field1006 = new Deque();
      field1007 = new Deque();
      field917 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field1024 = -2;
      field1012 = new boolean[100];
      field1013 = new boolean[100];
      field833 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1020 = 0L;
      isResized = true;
      field1022 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field975 = 0;
      field857 = "";
      field965 = new long[100];
      field1027 = 0;
      field1028 = 0;
      field1029 = new int[128];
      field1030 = new int[128];
      field822 = -1L;
      field952 = -1;
      field1033 = 0;
      field1034 = new int[1000];
      field1035 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1050 = 0;
      field1040 = 255;
      field1041 = -1;
      field1014 = false;
      field1008 = 127;
      field879 = 127;
      queuedSoundEffectCount = 0;
      queuedSoundEffectIDs = new int[50];
      unknownSoundValues1 = new int[50];
      unknownSoundValues2 = new int[50];
      soundLocations = new int[50];
      audioEffects = new SoundEffect[50];
      field1051 = false;
      field1052 = new boolean[5];
      field908 = new int[5];
      field1054 = new int[5];
      field1055 = new int[5];
      field1056 = new int[5];
      field1057 = 256;
      field1058 = 205;
      field856 = 256;
      field1060 = 320;
      field1061 = 1;
      field1062 = 32767;
      field1063 = 1;
      field1064 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      scale = 0;
      field1081 = new PlayerComposition();
      field1071 = -1;
      field1072 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field841 = new OwnWorldComparator();
      field1075 = new ArrayList(10);
      field1031 = 0;
      field896 = new class70();
      field848 = new int[50];
      field1079 = new int[50];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   protected final void vmethod1196() {
      field1020 = ScriptVarType.currentTimeMs() + 500L;
      this.method1197();
      if(widgetRoot != -1) {
         this.method1203(true);
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2126532400"
   )
   @Export("setUp")
   protected final void setUp() {
      IndexData.method4513(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      MouseRecorder.port1 = socketType == 0?43594:world + 40000;
      BoundingBox3D.port2 = socketType == 0?443:world + 50000;
      ItemContainer.myWorldPort = MouseRecorder.port1;
      class31.colorsToFind = class225.field2710;
      class70.colorsToReplace = class225.field2716;
      BoundingBox3D.field245 = class225.field2712;
      class310.field3890 = class225.field2713;
      class63.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      MouseRecorder.mouseWheel = this.mouseWheel();
      class235.indexStore255 = new IndexFile(255, class157.dat2File, class157.idx255File, 500000);
      class221.preferences = class7.method50();
      this.setUpClipboard();
      class33.method364(this, SoundTask.field1547);
      if(socketType != 0) {
         displayFps = true;
      }

      class80.method1775(class221.preferences.screenType);
      ServerPacket.friendManager = new FriendManager(class34.loginType);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1531470648"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      class60.method1016();
      class89.method1880();
      Friend.method5158();
      KeyFocusListener var1 = KeyFocusListener.keyboard;
      int var2;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field593 = KeyFocusListener.field595;
         KeyFocusListener.field592 = 0;
         if(KeyFocusListener.field588 >= 0) {
            while(KeyFocusListener.field588 != KeyFocusListener.field587) {
               var2 = KeyFocusListener.field586[KeyFocusListener.field587];
               KeyFocusListener.field587 = KeyFocusListener.field587 + 1 & 127;
               if(var2 < 0) {
                  KeyFocusListener.keyPressed[~var2] = false;
               } else {
                  if(!KeyFocusListener.keyPressed[var2] && KeyFocusListener.field592 < KeyFocusListener.field591.length - 1) {
                     KeyFocusListener.field591[++KeyFocusListener.field592 - 1] = var2;
                  }

                  KeyFocusListener.keyPressed[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               KeyFocusListener.keyPressed[var2] = false;
            }

            KeyFocusListener.field588 = KeyFocusListener.field587;
         }

         if(KeyFocusListener.field592 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field595 = KeyFocusListener.field590;
      }

      MouseInput var64 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.mouseCurrentButton = MouseInput.MouseHandler_currentButton;
         MouseInput.mouseLastX = MouseInput.mouseX;
         MouseInput.mouseLastY = MouseInput.mouseY;
         MouseInput.mouseLastButton = MouseInput.MouseHandler_lastButton;
         MouseInput.mouseLastPressedX = MouseInput.MouseHandler_lastPressedX;
         MouseInput.mouseLastPressedY = MouseInput.MouseHandler_lastPressedY;
         MouseInput.mouseLastPressedTimeMillis = MouseInput.MouseHandler_lastPressedTimeMillis;
         MouseInput.MouseHandler_lastButton = 0;
      }

      if(MouseRecorder.mouseWheel != null) {
         int var45 = MouseRecorder.mouseWheel.useRotation();
         mouseWheelRotation = var45;
      }

      if(gameState == 0) {
         MouseRecorder.load();
         class65.method1072();
      } else if(gameState == 5) {
         class5.method24(this);
         MouseRecorder.load();
         class65.method1072();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class5.method24(this);
            this.method1194();
         } else if(gameState == 25) {
            class19.flush(false);
            field873 = 0;
            boolean var75 = true;

            for(var2 = 0; var2 < class180.field2437.length; ++var2) {
               if(SceneTilePaint.landMapFileIds[var2] != -1 && class180.field2437[var2] == null) {
                  class180.field2437[var2] = FontName.indexMaps.getConfigData(SceneTilePaint.landMapFileIds[var2], 0);
                  if(class180.field2437[var2] == null) {
                     var75 = false;
                     ++field873;
                  }
               }

               if(BaseVarType.landRegionFileIds[var2] != -1 && class160.field2132[var2] == null) {
                  class160.field2132[var2] = FontName.indexMaps.getConfigDataKeys(BaseVarType.landRegionFileIds[var2], 0, class80.xteaKeys[var2]);
                  if(class160.field2132[var2] == null) {
                     var75 = false;
                     ++field873;
                  }
               }
            }

            if(!var75) {
               field877 = 1;
            } else {
               field875 = 0;
               var75 = true;

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
               int var46;
               for(var2 = 0; var2 < class180.field2437.length; ++var2) {
                  byte[] var3 = class160.field2132[var2];
                  if(var3 != null) {
                     var46 = (FileOnDisk.mapRegions[var2] >> 8) * 64 - WorldMapType1.baseX;
                     var5 = (FileOnDisk.mapRegions[var2] & 255) * 64 - class85.baseY;
                     if(isDynamicRegion) {
                        var46 = 10;
                        var5 = 10;
                     }

                     boolean var8 = true;
                     var9 = new Buffer(var3);
                     var10 = -1;

                     label1412:
                     while(true) {
                        var11 = var9.getUSmart();
                        if(var11 == 0) {
                           var75 &= var8;
                           break;
                        }

                        var10 += var11;
                        var12 = 0;
                        boolean var13 = false;

                        while(true) {
                           while(!var13) {
                              var14 = var9.getUSmart();
                              if(var14 == 0) {
                                 continue label1412;
                              }

                              var12 += var14 - 1;
                              var15 = var12 & 63;
                              var16 = var12 >> 6 & 63;
                              var17 = var9.readUnsignedByte() >> 2;
                              var18 = var46 + var16;
                              var19 = var5 + var15;
                              if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                 ObjectComposition var20 = TextureProvider.getObjectDefinition(var10);
                                 if(var17 != 22 || !lowMemory || var20.int1 != 0 || var20.clipType == 1 || var20.obstructsGround) {
                                    if(!var20.method4822()) {
                                       ++field875;
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

               if(!var75) {
                  field877 = 2;
               } else {
                  if(field877 != 0) {
                     ScriptEvent.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  Friend.method5158();
                  class7.method49();
                  Friend.method5158();
                  class48.region.reset();
                  Friend.method5158();
                  System.gc();

                  for(var2 = 0; var2 < 4; ++var2) {
                     collisionMaps[var2].reset();
                  }

                  int var47;
                  for(var2 = 0; var2 < 4; ++var2) {
                     for(var47 = 0; var47 < 104; ++var47) {
                        for(var46 = 0; var46 < 104; ++var46) {
                           class61.tileSettings[var2][var47][var46] = 0;
                        }
                     }
                  }

                  Friend.method5158();
                  GameEngine.method981();
                  var2 = class180.field2437.length;
                  TextureProvider.method2557();
                  class19.flush(true);
                  int var6;
                  int var7;
                  int var21;
                  int var22;
                  int var52;
                  int var68;
                  int var70;
                  if(!isDynamicRegion) {
                     var47 = 0;

                     label1350:
                     while(true) {
                        byte[] var48;
                        if(var47 >= var2) {
                           for(var47 = 0; var47 < var2; ++var47) {
                              var46 = (FileOnDisk.mapRegions[var47] >> 8) * 64 - WorldMapType1.baseX;
                              var5 = (FileOnDisk.mapRegions[var47] & 255) * 64 - class85.baseY;
                              var48 = class180.field2437[var47];
                              if(var48 == null && Size.field345 < 800) {
                                 Friend.method5158();
                                 class254.method4588(var46, var5, 64, 64);
                              }
                           }

                           class19.flush(true);
                           var47 = 0;

                           while(true) {
                              if(var47 >= var2) {
                                 break label1350;
                              }

                              byte[] var4 = class160.field2132[var47];
                              if(var4 != null) {
                                 var5 = (FileOnDisk.mapRegions[var47] >> 8) * 64 - WorldMapType1.baseX;
                                 var6 = (FileOnDisk.mapRegions[var47] & 255) * 64 - class85.baseY;
                                 Friend.method5158();
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
                                       var70 = var9.getUSmart();
                                       if(var70 == 0) {
                                          break;
                                       }

                                       var12 += var70 - 1;
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

                                          class22.addObject(var16, var52, var21, var10, var19, var18, var50, var23);
                                       }
                                    }
                                 }
                              }

                              ++var47;
                           }
                        }

                        var46 = (FileOnDisk.mapRegions[var47] >> 8) * 64 - WorldMapType1.baseX;
                        var5 = (FileOnDisk.mapRegions[var47] & 255) * 64 - class85.baseY;
                        var48 = class180.field2437[var47];
                        if(var48 != null) {
                           Friend.method5158();
                           var7 = GrandExchangeEvents.field269 * 8 - 48;
                           var68 = Size.field345 * 8 - 48;
                           CollisionData[] var69 = collisionMaps;
                           var10 = 0;

                           label1347:
                           while(true) {
                              if(var10 >= 4) {
                                 Buffer var49 = new Buffer(var48);
                                 var11 = 0;

                                 while(true) {
                                    if(var11 >= 4) {
                                       break label1347;
                                    }

                                    for(var12 = 0; var12 < 64; ++var12) {
                                       for(var70 = 0; var70 < 64; ++var70) {
                                          class249.loadTerrain(var49, var11, var12 + var46, var70 + var5, var7, var68, 0);
                                       }
                                    }

                                    ++var11;
                                 }
                              }

                              for(var11 = 0; var11 < 64; ++var11) {
                                 for(var12 = 0; var12 < 64; ++var12) {
                                    if(var11 + var46 > 0 && var11 + var46 < 103 && var5 + var12 > 0 && var12 + var5 < 103) {
                                       var69[var10].flags[var11 + var46][var5 + var12] &= -16777217;
                                    }
                                 }
                              }

                              ++var10;
                           }
                        }

                        ++var47;
                     }
                  }

                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  int var33;
                  int var35;
                  int var36;
                  int var37;
                  int var53;
                  int var56;
                  if(isDynamicRegion) {
                     var47 = 0;

                     label1283:
                     while(true) {
                        if(var47 >= 4) {
                           for(var47 = 0; var47 < 13; ++var47) {
                              for(var46 = 0; var46 < 13; ++var46) {
                                 var5 = field880[0][var47][var46];
                                 if(var5 == -1) {
                                    class254.method4588(var47 * 8, var46 * 8, 8, 8);
                                 }
                              }
                           }

                           class19.flush(true);
                           var47 = 0;

                           while(true) {
                              if(var47 >= 4) {
                                 break label1283;
                              }

                              Friend.method5158();

                              for(var46 = 0; var46 < 13; ++var46) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var6 = field880[var47][var46][var5];
                                    if(var6 != -1) {
                                       var7 = var6 >> 24 & 3;
                                       var68 = var6 >> 1 & 3;
                                       var53 = var6 >> 14 & 1023;
                                       var10 = var6 >> 3 & 2047;
                                       var11 = (var53 / 8 << 8) + var10 / 8;

                                       for(var12 = 0; var12 < FileOnDisk.mapRegions.length; ++var12) {
                                          if(FileOnDisk.mapRegions[var12] == var11 && class160.field2132[var12] != null) {
                                             PlayerComposition.method4210(class160.field2132[var12], var47, var46 * 8, var5 * 8, var7, (var53 & 7) * 8, (var10 & 7) * 8, var68, class48.region, collisionMaps);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var47;
                           }
                        }

                        Friend.method5158();

                        for(var46 = 0; var46 < 13; ++var46) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var67 = false;
                              var7 = field880[var47][var46][var5];
                              if(var7 != -1) {
                                 var68 = var7 >> 24 & 3;
                                 var53 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(var70 = 0; var70 < FileOnDisk.mapRegions.length; ++var70) {
                                    if(FileOnDisk.mapRegions[var70] == var12 && class180.field2437[var70] != null) {
                                       byte[] var54 = class180.field2437[var70];
                                       var15 = var46 * 8;
                                       var16 = var5 * 8;
                                       var17 = (var10 & 7) * 8;
                                       var18 = (var11 & 7) * 8;
                                       CollisionData[] var55 = collisionMaps;

                                       for(var52 = 0; var52 < 8; ++var52) {
                                          for(var21 = 0; var21 < 8; ++var21) {
                                             if(var52 + var15 > 0 && var15 + var52 < 103 && var21 + var16 > 0 && var16 + var21 < 103) {
                                                var55[var47].flags[var15 + var52][var21 + var16] &= -16777217;
                                             }
                                          }
                                       }

                                       Buffer var71 = new Buffer(var54);

                                       for(var21 = 0; var21 < 4; ++var21) {
                                          for(var22 = 0; var22 < 64; ++var22) {
                                             for(var56 = 0; var56 < 64; ++var56) {
                                                if(var68 == var21 && var22 >= var17 && var22 < var17 + 8 && var56 >= var18 && var56 < var18 + 8) {
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

                                                   var33 = var27 + var15;
                                                   var36 = var22 & 7;
                                                   var37 = var56 & 7;
                                                   int var38 = var53 & 3;
                                                   if(var38 == 0) {
                                                      var35 = var37;
                                                   } else if(var38 == 1) {
                                                      var35 = 7 - var36;
                                                   } else if(var38 == 2) {
                                                      var35 = 7 - var37;
                                                   } else {
                                                      var35 = var36;
                                                   }

                                                   class249.loadTerrain(var71, var47, var33, var16 + var35, 0, 0, var53);
                                                } else {
                                                   class249.loadTerrain(var71, 0, -1, -1, 0, 0, 0);
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
                                 class33.method363(var47, var46 * 8, var5 * 8);
                              }
                           }
                        }

                        ++var47;
                     }
                  }

                  class19.flush(true);
                  class7.method49();
                  Friend.method5158();
                  Region var65 = class48.region;
                  CollisionData[] var66 = collisionMaps;

                  for(var5 = 0; var5 < 4; ++var5) {
                     for(var6 = 0; var6 < 104; ++var6) {
                        for(var7 = 0; var7 < 104; ++var7) {
                           if((class61.tileSettings[var5][var6][var7] & 1) == 1) {
                              var68 = var5;
                              if((class61.tileSettings[1][var6][var7] & 2) == 2) {
                                 var68 = var5 - 1;
                              }

                              if(var68 >= 0) {
                                 var66[var68].method3249(var6, var7);
                              }
                           }
                        }
                     }
                  }

                  class61.field699 += (int)(Math.random() * 5.0D) - 2;
                  if(class61.field699 < -8) {
                     class61.field699 = -8;
                  }

                  if(class61.field699 > 8) {
                     class61.field699 = 8;
                  }

                  class61.field684 += (int)(Math.random() * 5.0D) - 2;
                  if(class61.field684 < -16) {
                     class61.field684 = -16;
                  }

                  if(class61.field684 > 16) {
                     class61.field684 = 16;
                  }

                  for(var5 = 0; var5 < 4; ++var5) {
                     byte[][] var76 = class29.field392[var5];
                     var12 = (int)Math.sqrt(5100.0D);
                     var70 = var12 * 768 >> 8;

                     for(var14 = 1; var14 < 103; ++var14) {
                        for(var15 = 1; var15 < 103; ++var15) {
                           var16 = class61.tileHeights[var5][var15 + 1][var14] - class61.tileHeights[var5][var15 - 1][var14];
                           var17 = class61.tileHeights[var5][var15][var14 + 1] - class61.tileHeights[var5][var15][var14 - 1];
                           var18 = (int)Math.sqrt((double)(var17 * var17 + var16 * var16 + 65536));
                           var19 = (var16 << 8) / var18;
                           var52 = 65536 / var18;
                           var21 = (var17 << 8) / var18;
                           var22 = (var21 * -50 + var19 * -50 + var52 * -10) / var70 + 96;
                           var56 = (var76[var15][var14 + 1] >> 3) + (var76[var15 - 1][var14] >> 2) + (var76[var15][var14 - 1] >> 2) + (var76[var15 + 1][var14] >> 3) + (var76[var15][var14] >> 1);
                           Item.field1371[var15][var14] = var22 - var56;
                        }
                     }

                     for(var14 = 0; var14 < 104; ++var14) {
                        class31.field413[var14] = 0;
                        BaseVarType.field24[var14] = 0;
                        class61.field685[var14] = 0;
                        ItemLayer.field1669[var14] = 0;
                        Ignore.field3688[var14] = 0;
                     }

                     for(var14 = -5; var14 < 109; ++var14) {
                        for(var15 = 0; var15 < 104; ++var15) {
                           var16 = var14 + 5;
                           if(var16 >= 0 && var16 < 104) {
                              var17 = class25.field352[var5][var16][var15] & 255;
                              if(var17 > 0) {
                                 FloorUnderlayDefinition var57 = class5.getUnderlayDefinition(var17 - 1);
                                 class31.field413[var15] += var57.hue;
                                 BaseVarType.field24[var15] += var57.saturation;
                                 class61.field685[var15] += var57.lightness;
                                 ItemLayer.field1669[var15] += var57.hueMultiplier;
                                 ++Ignore.field3688[var15];
                              }
                           }

                           var17 = var14 - 5;
                           if(var17 >= 0 && var17 < 104) {
                              var18 = class25.field352[var5][var17][var15] & 255;
                              if(var18 > 0) {
                                 FloorUnderlayDefinition var79 = class5.getUnderlayDefinition(var18 - 1);
                                 class31.field413[var15] -= var79.hue;
                                 BaseVarType.field24[var15] -= var79.saturation;
                                 class61.field685[var15] -= var79.lightness;
                                 ItemLayer.field1669[var15] -= var79.hueMultiplier;
                                 --Ignore.field3688[var15];
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
                                 var15 += class31.field413[var21];
                                 var16 += BaseVarType.field24[var21];
                                 var17 += class61.field685[var21];
                                 var18 += ItemLayer.field1669[var21];
                                 var19 += Ignore.field3688[var21];
                              }

                              var22 = var52 - 5;
                              if(var22 >= 0 && var22 < 104) {
                                 var15 -= class31.field413[var22];
                                 var16 -= BaseVarType.field24[var22];
                                 var17 -= class61.field685[var22];
                                 var18 -= ItemLayer.field1669[var22];
                                 var19 -= Ignore.field3688[var22];
                              }

                              if(var52 >= 1 && var52 < 103 && (!lowMemory || (class61.tileSettings[0][var14][var52] & 2) != 0 || (class61.tileSettings[var5][var14][var52] & 16) == 0)) {
                                 if(var5 < class61.field686) {
                                    class61.field686 = var5;
                                 }

                                 var56 = class25.field352[var5][var14][var52] & 255;
                                 int var58 = class61.field687[var5][var14][var52] & 255;
                                 if(var56 > 0 || var58 > 0) {
                                    int var25 = class61.tileHeights[var5][var14][var52];
                                    int var26 = class61.tileHeights[var5][var14 + 1][var52];
                                    var27 = class61.tileHeights[var5][var14 + 1][var52 + 1];
                                    var28 = class61.tileHeights[var5][var14][var52 + 1];
                                    var29 = Item.field1371[var14][var52];
                                    var30 = Item.field1371[var14 + 1][var52];
                                    int var59 = Item.field1371[var14 + 1][var52 + 1];
                                    int var32 = Item.field1371[var14][var52 + 1];
                                    var33 = -1;
                                    int var34 = -1;
                                    if(var56 > 0) {
                                       var35 = var15 * 256 / var18;
                                       var36 = var16 / var19;
                                       var37 = var17 / var19;
                                       var33 = class43.method617(var35, var36, var37);
                                       var35 = var35 + class61.field699 & 255;
                                       var37 += class61.field684;
                                       if(var37 < 0) {
                                          var37 = 0;
                                       } else if(var37 > 255) {
                                          var37 = 255;
                                       }

                                       var34 = class43.method617(var35, var36, var37);
                                    }

                                    if(var5 > 0) {
                                       boolean var73 = true;
                                       if(var56 == 0 && class61.field688[var5][var14][var52] != 0) {
                                          var73 = false;
                                       }

                                       if(var58 > 0 && !KitDefinition.getOverlayDefinition(var58 - 1).isHidden) {
                                          var73 = false;
                                       }

                                       if(var73 && var26 == var25 && var27 == var25 && var28 == var25) {
                                          class61.field690[var5][var14][var52] |= 2340;
                                       }
                                    }

                                    var35 = 0;
                                    if(var34 != -1) {
                                       var35 = Graphics3D.colorPalette[class40.method548(var34, 96)];
                                    }

                                    if(var58 == 0) {
                                       var65.addTile(var5, var14, var52, 0, 0, -1, var25, var26, var27, var28, class40.method548(var33, var29), class40.method548(var33, var30), class40.method548(var33, var59), class40.method548(var33, var32), 0, 0, 0, 0, var35, 0);
                                    } else {
                                       var36 = class61.field688[var5][var14][var52] + 1;
                                       byte var74 = IndexFile.field2159[var5][var14][var52];
                                       Overlay var60 = KitDefinition.getOverlayDefinition(var58 - 1);
                                       int var39 = var60.texture;
                                       int var40;
                                       int var41;
                                       int var42;
                                       int var43;
                                       if(var39 >= 0) {
                                          var41 = Graphics3D.textureLoader.getAverageTextureRGB(var39);
                                          var40 = -1;
                                       } else if(var60.color == 16711935) {
                                          var40 = -2;
                                          var39 = -1;
                                          var41 = -2;
                                       } else {
                                          var40 = class43.method617(var60.hue, var60.saturation, var60.lightness);
                                          var42 = var60.hue + class61.field699 & 255;
                                          var43 = var60.lightness + class61.field684;
                                          if(var43 < 0) {
                                             var43 = 0;
                                          } else if(var43 > 255) {
                                             var43 = 255;
                                          }

                                          var41 = class43.method617(var42, var60.saturation, var43);
                                       }

                                       var42 = 0;
                                       if(var41 != -2) {
                                          var42 = Graphics3D.colorPalette[WorldMapData.adjustHSLListness0(var41, 96)];
                                       }

                                       if(var60.otherRgbColor != -1) {
                                          var43 = var60.otherHue + class61.field699 & 255;
                                          int var44 = var60.otherLightness + class61.field684;
                                          if(var44 < 0) {
                                             var44 = 0;
                                          } else if(var44 > 255) {
                                             var44 = 255;
                                          }

                                          var41 = class43.method617(var43, var60.otherSaturation, var44);
                                          var42 = Graphics3D.colorPalette[WorldMapData.adjustHSLListness0(var41, 96)];
                                       }

                                       var65.addTile(var5, var14, var52, var36, var74, var39, var25, var26, var27, var28, class40.method548(var33, var29), class40.method548(var33, var30), class40.method548(var33, var59), class40.method548(var33, var32), WorldMapData.adjustHSLListness0(var40, var29), WorldMapData.adjustHSLListness0(var40, var30), WorldMapData.adjustHSLListness0(var40, var59), WorldMapData.adjustHSLListness0(var40, var32), var35, var42);
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

                           var65.setPhysicalLevel(var5, var15, var14, var52);
                        }
                     }

                     class25.field352[var5] = null;
                     class61.field687[var5] = null;
                     class61.field688[var5] = null;
                     IndexFile.field2159[var5] = null;
                     class29.field392[var5] = null;
                  }

                  var65.applyLighting(-50, -10, -50);

                  for(var5 = 0; var5 < 104; ++var5) {
                     for(var6 = 0; var6 < 104; ++var6) {
                        if((class61.tileSettings[1][var5][var6] & 2) == 2) {
                           var65.setBridge(var5, var6);
                        }
                     }
                  }

                  var5 = 1;
                  var6 = 2;
                  var7 = 4;

                  for(var68 = 0; var68 < 4; ++var68) {
                     if(var68 > 0) {
                        var5 <<= 3;
                        var6 <<= 3;
                        var7 <<= 3;
                     }

                     for(var53 = 0; var53 <= var68; ++var53) {
                        for(var10 = 0; var10 <= 104; ++var10) {
                           for(var11 = 0; var11 <= 104; ++var11) {
                              short var72;
                              if((class61.field690[var53][var11][var10] & var5) != 0) {
                                 var12 = var10;
                                 var70 = var10;
                                 var14 = var53;

                                 for(var15 = var53; var12 > 0 && (class61.field690[var53][var11][var12 - 1] & var5) != 0; --var12) {
                                    ;
                                 }

                                 while(var70 < 104 && (class61.field690[var53][var11][var70 + 1] & var5) != 0) {
                                    ++var70;
                                 }

                                 label934:
                                 while(var14 > 0) {
                                    for(var16 = var12; var16 <= var70; ++var16) {
                                       if((class61.field690[var14 - 1][var11][var16] & var5) == 0) {
                                          break label934;
                                       }
                                    }

                                    --var14;
                                 }

                                 label923:
                                 while(var15 < var68) {
                                    for(var16 = var12; var16 <= var70; ++var16) {
                                       if((class61.field690[var15 + 1][var11][var16] & var5) == 0) {
                                          break label923;
                                       }
                                    }

                                    ++var15;
                                 }

                                 var16 = (var70 - var12 + 1) * (var15 + 1 - var14);
                                 if(var16 >= 8) {
                                    var72 = 240;
                                    var18 = class61.tileHeights[var15][var11][var12] - var72;
                                    var19 = class61.tileHeights[var14][var11][var12];
                                    Region.addOcclude(var68, 1, var11 * 128, var11 * 128, var12 * 128, var70 * 128 + 128, var18, var19);

                                    for(var52 = var14; var52 <= var15; ++var52) {
                                       for(var21 = var12; var21 <= var70; ++var21) {
                                          class61.field690[var52][var11][var21] &= ~var5;
                                       }
                                    }
                                 }
                              }

                              if((class61.field690[var53][var11][var10] & var6) != 0) {
                                 var12 = var11;
                                 var70 = var11;
                                 var14 = var53;

                                 for(var15 = var53; var12 > 0 && (class61.field690[var53][var12 - 1][var10] & var6) != 0; --var12) {
                                    ;
                                 }

                                 while(var70 < 104 && (class61.field690[var53][var70 + 1][var10] & var6) != 0) {
                                    ++var70;
                                 }

                                 label987:
                                 while(var14 > 0) {
                                    for(var16 = var12; var16 <= var70; ++var16) {
                                       if((class61.field690[var14 - 1][var16][var10] & var6) == 0) {
                                          break label987;
                                       }
                                    }

                                    --var14;
                                 }

                                 label976:
                                 while(var15 < var68) {
                                    for(var16 = var12; var16 <= var70; ++var16) {
                                       if((class61.field690[var15 + 1][var16][var10] & var6) == 0) {
                                          break label976;
                                       }
                                    }

                                    ++var15;
                                 }

                                 var16 = (var70 - var12 + 1) * (var15 + 1 - var14);
                                 if(var16 >= 8) {
                                    var72 = 240;
                                    var18 = class61.tileHeights[var15][var12][var10] - var72;
                                    var19 = class61.tileHeights[var14][var12][var10];
                                    Region.addOcclude(var68, 2, var12 * 128, var70 * 128 + 128, var10 * 128, var10 * 128, var18, var19);

                                    for(var52 = var14; var52 <= var15; ++var52) {
                                       for(var21 = var12; var21 <= var70; ++var21) {
                                          class61.field690[var52][var21][var10] &= ~var6;
                                       }
                                    }
                                 }
                              }

                              if((class61.field690[var53][var11][var10] & var7) != 0) {
                                 var12 = var11;
                                 var70 = var11;
                                 var14 = var10;

                                 for(var15 = var10; var14 > 0 && (class61.field690[var53][var11][var14 - 1] & var7) != 0; --var14) {
                                    ;
                                 }

                                 while(var15 < 104 && (class61.field690[var53][var11][var15 + 1] & var7) != 0) {
                                    ++var15;
                                 }

                                 label1040:
                                 while(var12 > 0) {
                                    for(var16 = var14; var16 <= var15; ++var16) {
                                       if((class61.field690[var53][var12 - 1][var16] & var7) == 0) {
                                          break label1040;
                                       }
                                    }

                                    --var12;
                                 }

                                 label1029:
                                 while(var70 < 104) {
                                    for(var16 = var14; var16 <= var15; ++var16) {
                                       if((class61.field690[var53][var70 + 1][var16] & var7) == 0) {
                                          break label1029;
                                       }
                                    }

                                    ++var70;
                                 }

                                 if((var70 - var12 + 1) * (var15 - var14 + 1) >= 4) {
                                    var16 = class61.tileHeights[var53][var12][var14];
                                    Region.addOcclude(var68, 4, var12 * 128, var70 * 128 + 128, var14 * 128, var15 * 128 + 128, var16, var16);

                                    for(var17 = var12; var17 <= var70; ++var17) {
                                       for(var18 = var14; var18 <= var15; ++var18) {
                                          class61.field690[var53][var17][var18] &= ~var7;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  class19.flush(true);
                  var5 = class61.field686;
                  if(var5 > MessageNode.plane) {
                     var5 = MessageNode.plane;
                  }

                  if(var5 < MessageNode.plane - 1) {
                     var5 = MessageNode.plane - 1;
                  }

                  if(lowMemory) {
                     class48.region.setup(class61.field686);
                  } else {
                     class48.region.setup(0);
                  }

                  for(var6 = 0; var6 < 104; ++var6) {
                     for(var7 = 0; var7 < 104; ++var7) {
                        AbstractSoundSystem.groundItemSpawned(var6, var7);
                     }
                  }

                  Friend.method5158();

                  for(PendingSpawn var77 = (PendingSpawn)pendingSpawns.getFront(); var77 != null; var77 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var77.hitpoints == -1) {
                        var77.delay = 0;
                        KeyFocusListener.method760(var77);
                     } else {
                        var77.unlink();
                     }
                  }

                  ObjectComposition.field3498.reset();
                  PacketNode var78;
                  if(class37.clientInstance.method856()) {
                     var78 = class35.method501(ClientPacket.field2289, field867.field1439);
                     var78.packetBuffer.putInt(1057001181);
                     field867.method2021(var78);
                  }

                  if(!isDynamicRegion) {
                     var6 = (GrandExchangeEvents.field269 - 6) / 8;
                     var7 = (GrandExchangeEvents.field269 + 6) / 8;
                     var68 = (Size.field345 - 6) / 8;
                     var53 = (Size.field345 + 6) / 8;

                     for(var10 = var6 - 1; var10 <= var7 + 1; ++var10) {
                        for(var11 = var68 - 1; var11 <= var53 + 1; ++var11) {
                           if(var10 < var6 || var10 > var7 || var11 < var68 || var11 > var53) {
                              FontName.indexMaps.method4364("m" + var10 + "_" + var11);
                              FontName.indexMaps.method4364("l" + var10 + "_" + var11);
                           }
                        }
                     }
                  }

                  class5.setGameState(30);
                  Friend.method5158();
                  class89.method1904();
                  var78 = class35.method501(ClientPacket.field2367, field867.field1439);
                  field867.method2021(var78);
                  class65.method1072();
               }
            }
         }
      } else {
         class5.method24(this);
      }

      if(gameState == 30) {
         this.method1513();
      } else if(gameState == 40 || gameState == 45) {
         this.method1194();
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "868698548"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2;
      label168: {
         try {
            if(class214.field2596 == 2) {
               if(class214.field2599 == null) {
                  class214.field2599 = Track1.getMusicFile(Item.field1369, GZipDecompressor.field2420, class186.field2505);
                  if(class214.field2599 == null) {
                     var2 = false;
                     break label168;
                  }
               }

               if(ContextMenuRow.field1281 == null) {
                  ContextMenuRow.field1281 = new class109(class214.field2592, class214.field2593);
               }

               if(class214.field2595.method4057(class214.field2599, class214.field2598, ContextMenuRow.field1281, 22050)) {
                  class214.field2595.method4044();
                  class214.field2595.method3956(class214.field2597);
                  class214.field2595.method3961(class214.field2599, class214.field2594);
                  class214.field2596 = 0;
                  class214.field2599 = null;
                  ContextMenuRow.field1281 = null;
                  Item.field1369 = null;
                  var2 = true;
                  break label168;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class214.field2595.method3962();
            class214.field2596 = 0;
            class214.field2599 = null;
            ContextMenuRow.field1281 = null;
            Item.field1369 = null;
         }

         var2 = false;
      }

      if(var2 && field1014 && CombatInfoListHolder.soundSystem0 != null) {
         CombatInfoListHolder.soundSystem0.tryFlush();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1020 && ScriptVarType.currentTimeMs() > field1020) {
         class80.method1775(World.method1644());
      }

      int var4;
      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1012[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class89.loadingBarPercentage, class89.loadingText, var1);
      } else if(gameState == 5) {
         FrameMap.drawLoginScreen(ContextMenuRow.fontBold12, GrandExchangeOffer.fontPlain11, BoundingBox2D.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            FrameMap.drawLoginScreen(ContextMenuRow.fontBold12, GrandExchangeOffer.fontPlain11, BoundingBox2D.font_p12full, var1);
         } else if(gameState == 25) {
            if(field877 == 1) {
               if(field873 > field874) {
                  field874 = field873;
               }

               var4 = (field874 * 50 - field873 * 50) / field874;
               ScriptEvent.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field877 == 2) {
               if(field875 > field1068) {
                  field1068 = field875;
               }

               var4 = (field1068 * 50 - field875 * 50) / field1068 + 50;
               ScriptEvent.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               ScriptEvent.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1198();
         } else if(gameState == 40) {
            ScriptEvent.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            ScriptEvent.drawStatusBox("Please wait...", false);
         }
      } else {
         FrameMap.drawLoginScreen(ContextMenuRow.fontBold12, GrandExchangeOffer.fontPlain11, BoundingBox2D.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < widgetCount; ++var4) {
            if(field1013[var4]) {
               CombatInfo2.rasterProvider.draw(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1013[var4] = false;
            }
         }
      } else if(gameState > 0) {
         CombatInfo2.rasterProvider.drawFull(0, 0);

         for(var4 = 0; var4 < widgetCount; ++var4) {
            field1013[var4] = false;
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "951535909"
   )
   protected final void vmethod1365() {
      if(class61.chatMessages.changed()) {
         class61.chatMessages.serialize();
      }

      if(class3.mouseRecorder != null) {
         class3.mouseRecorder.isRunning = false;
      }

      class3.mouseRecorder = null;
      field867.close();
      class3.method7();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      MouseRecorder.mouseWheel = null;
      if(CombatInfoListHolder.soundSystem0 != null) {
         CombatInfoListHolder.soundSystem0.shutdown();
      }

      if(DecorativeObject.soundSystem1 != null) {
         DecorativeObject.soundSystem1.shutdown();
      }

      if(class249.NetCache_socket != null) {
         class249.NetCache_socket.vmethod3186();
      }

      class163.method3218();
      if(class63.urlRequester != null) {
         class63.urlRequester.close();
         class63.urlRequester = null;
      }

      try {
         class157.dat2File.close();

         for(int var3 = 0; var3 < class157.idxCount; ++var3) {
            class3.idxFiles[var3].close();
         }

         class157.idx255File.close();
         class157.randomDat.close();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-951477235"
   )
   protected final void vmethod1185() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = class296.method5332();

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            Parameters var3 = var1[var2];
            String var4 = this.getParameter(var3.key);
            if(var4 != null) {
               switch(Integer.parseInt(var3.key)) {
               case 1:
                  class61.sessionToken = var4;
                  break;
               case 2:
                  languageId = Integer.parseInt(var4);
                  break;
               case 3:
                  world = Integer.parseInt(var4);
                  break;
               case 4:
                  field828 = var4;
                  break;
               case 5:
                  var6 = Integer.parseInt(var4);
                  BuildType[] var7 = new BuildType[]{BuildType.WIP, BuildType.RC, BuildType.BUILD_LIVE, BuildType.LIVE};
                  BuildType[] var8 = var7;
                  int var9 = 0;

                  BuildType var5;
                  while(true) {
                     if(var9 >= var8.length) {
                        var5 = null;
                        break;
                     }

                     BuildType var10 = var8[var9];
                     if(var6 == var10.ordinal) {
                        var5 = var10;
                        break;
                     }

                     ++var9;
                  }

                  class36.field472 = var5;
                  break;
               case 6:
                  WorldComparator.field261 = (JagexGame)ClanMember.forOrdinal(ChatLineBuffer.method2010(), Integer.parseInt(var4));
                  if(WorldComparator.field261 == JagexGame.field3272) {
                     class34.loginType = JagexLoginType.field3962;
                  } else {
                     class34.loginType = JagexLoginType.field3955;
                  }
               case 7:
               case 10:
               case 11:
               default:
                  break;
               case 8:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 9:
                  field870 = Integer.parseInt(var4) != 0;
                  break;
               case 12:
                  flags = Integer.parseInt(var4);
                  break;
               case 13:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 14:
                  class37.field477 = Integer.parseInt(var4);
                  break;
               case 15:
                  class150.field2081 = Integer.parseInt(var4);
                  break;
               case 16:
                  socketType = Integer.parseInt(var4);
               }
            }
         }

         Region.regionLowMemory = false;
         lowMemory = false;
         FrameMap.host = this.getCodeBase().getHost();
         String var24 = class36.field472.identifier;
         byte var25 = 0;

         try {
            class157.idxCount = 17;
            class45.field545 = var25;

            try {
               Permission.osName = System.getProperty("os.name");
            } catch (Exception var21) {
               Permission.osName = "Unknown";
            }

            VertexNormal.osNameLC = Permission.osName.toLowerCase();

            try {
               class299.userHome = System.getProperty("user.home");
               if(class299.userHome != null) {
                  class299.userHome = class299.userHome + "/";
               }
            } catch (Exception var20) {
               ;
            }

            try {
               if(VertexNormal.osNameLC.startsWith("win")) {
                  if(class299.userHome == null) {
                     class299.userHome = System.getenv("USERPROFILE");
                  }
               } else if(class299.userHome == null) {
                  class299.userHome = System.getenv("HOME");
               }

               if(class299.userHome != null) {
                  class299.userHome = class299.userHome + "/";
               }
            } catch (Exception var19) {
               ;
            }

            if(class299.userHome == null) {
               class299.userHome = "~/";
            }

            Size.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class299.userHome, "/tmp/", ""};
            WorldMapType2.field490 = new String[]{".jagex_cache_" + class45.field545, ".file_store_" + class45.field545};

            int var11;
            label169:
            for(var11 = 0; var11 < 4; ++var11) {
               class291.field3769 = Buffer.method3610("oldschool", var24, var11);
               if(!class291.field3769.exists()) {
                  class291.field3769.mkdirs();
               }

               File[] var27 = class291.field3769.listFiles();
               if(var27 == null) {
                  break;
               }

               File[] var29 = var27;
               var6 = 0;

               while(true) {
                  if(var6 >= var29.length) {
                     break label169;
                  }

                  File var30 = var29[var6];

                  boolean var14;
                  try {
                     RandomAccessFile var12 = new RandomAccessFile(var30, "rw");
                     int var13 = var12.read();
                     var12.seek(0L);
                     var12.write(var13);
                     var12.seek(0L);
                     var12.close();
                     var14 = true;
                  } catch (Exception var18) {
                     var14 = false;
                  }

                  if(!var14) {
                     break;
                  }

                  ++var6;
               }
            }

            JagexGame.method4361(class291.field3769);

            try {
               File var26 = new File(class299.userHome, "random.dat");
               int var16;
               if(var26.exists()) {
                  class157.randomDat = new CacheFile(new FileOnDisk(var26, "rw", 25L), 24, 0);
               } else {
                  label148:
                  for(int var15 = 0; var15 < WorldMapType2.field490.length; ++var15) {
                     for(var16 = 0; var16 < Size.cacheLocations.length; ++var16) {
                        File var17 = new File(Size.cacheLocations[var16] + WorldMapType2.field490[var15] + File.separatorChar + "random.dat");
                        if(var17.exists()) {
                           class157.randomDat = new CacheFile(new FileOnDisk(var17, "rw", 25L), 24, 0);
                           break label148;
                        }
                     }
                  }
               }

               if(class157.randomDat == null) {
                  RandomAccessFile var28 = new RandomAccessFile(var26, "rw");
                  var16 = var28.read();
                  var28.seek(0L);
                  var28.write(var16);
                  var28.seek(0L);
                  var28.close();
                  class157.randomDat = new CacheFile(new FileOnDisk(var26, "rw", 25L), 24, 0);
               }
            } catch (IOException var22) {
               ;
            }

            class157.dat2File = new CacheFile(new FileOnDisk(WorldMapType3.method222("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class157.idx255File = new CacheFile(new FileOnDisk(WorldMapType3.method222("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class3.idxFiles = new CacheFile[class157.idxCount];

            for(var11 = 0; var11 < class157.idxCount; ++var11) {
               class3.idxFiles[var11] = new CacheFile(new FileOnDisk(WorldMapType3.method222("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var23) {
            class89.method1900((String)null, var23);
         }

         class37.clientInstance = this;
         this.initialize(765, 503, 162);
      }
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1464360377"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = BoundingBox2D.method53();
         if(!var1) {
            this.method1269();
         }

      }
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   void method1269() {
      if(class249.field3336 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class249.field3337 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field853 = 3000;
            class249.field3337 = 3;
         }

         if(--field853 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  GrandExchangeOffer.socket = GameEngine.taskManager.createSocket(FrameMap.host, ItemContainer.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(GrandExchangeOffer.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(GrandExchangeOffer.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field870) {
                     Socket var2 = (Socket)GrandExchangeOffer.socket.value;
                     class161 var1 = new class161(var2, 40000, 5000);
                     rssocket = var1;
                  } else {
                     rssocket = new class163((Socket)GrandExchangeOffer.socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var11 = new Buffer(5);
                  var11.putByte(15);
                  var11.putInt(162);
                  rssocket.vmethod3192(var11.payload, 0, 5);
                  ++js5State;
                  DState.field2485 = ScriptVarType.currentTimeMs();
               }

               if(js5State == 3) {
                  if(rssocket.vmethod3188() > 0 || !field870 && gameState <= 5) {
                     int var5 = rssocket.vmethod3215();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  } else if(ScriptVarType.currentTimeMs() - DState.field2485 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  class159 var12 = rssocket;
                  boolean var6 = gameState > 20;
                  if(class249.NetCache_socket != null) {
                     try {
                        class249.NetCache_socket.vmethod3186();
                     } catch (Exception var9) {
                        ;
                     }

                     class249.NetCache_socket = null;
                  }

                  class249.NetCache_socket = var12;
                  class31.sendConInfo(var6);
                  class249.NetCache_responseHeaderBuffer.offset = 0;
                  class19.currentRequest = null;
                  class94.NetCache_responseArchiveBuffer = null;
                  class249.field3332 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class249.NetCache_pendingPriorityResponses.first();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class249.NetCache_pendingResponses.first();
                           if(var3 == null) {
                              if(class249.field3335 != 0) {
                                 try {
                                    Buffer var13 = new Buffer(4);
                                    var13.putByte(4);
                                    var13.putByte(class249.field3335);
                                    var13.putShort(0);
                                    class249.NetCache_socket.vmethod3192(var13.payload, 0, 4);
                                 } catch (IOException var8) {
                                    try {
                                       class249.NetCache_socket.vmethod3186();
                                    } catch (Exception var7) {
                                       ;
                                    }

                                    ++class249.field3337;
                                    class249.NetCache_socket = null;
                                 }
                              }

                              class249.field3321 = 0;
                              class25.field351 = ScriptVarType.currentTimeMs();
                              GrandExchangeOffer.socket = null;
                              rssocket = null;
                              js5State = 0;
                              field1053 = 0;
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
            } catch (IOException var10) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "940332376"
   )
   @Export("error")
   void error(int var1) {
      GrandExchangeOffer.socket = null;
      rssocket = null;
      js5State = 0;
      if(MouseRecorder.port1 == ItemContainer.myWorldPort) {
         ItemContainer.myWorldPort = BoundingBox3D.port2;
      } else {
         ItemContainer.myWorldPort = MouseRecorder.port1;
      }

      ++field1053;
      if(field1053 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field853 = 3000;
         }
      } else if(field1053 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field1053 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field853 = 3000;
         }
      }

   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "690579889"
   )
   final void method1194() {
      Object var1 = field867.getSocket();
      PacketBuffer var2 = field867.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class159)var1).vmethod3186();
               var1 = null;
            }

            class232.field2904 = null;
            socketError = false;
            field1078 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class232.field2904 == null) {
               class232.field2904 = GameEngine.taskManager.createSocket(FrameMap.host, ItemContainer.myWorldPort);
            }

            if(class232.field2904.status == 2) {
               throw new IOException();
            }

            if(class232.field2904.status == 1) {
               if(field870) {
                  Socket var4 = (Socket)class232.field2904.value;
                  class161 var3 = new class161(var4, 40000, 5000);
                  var1 = var3;
               } else {
                  var1 = new class163((Socket)class232.field2904.value, GameEngine.taskManager, 5000);
               }

               field867.setSocket((class159)var1);
               class232.field2904 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field867.method2040();
            PacketNode var26 = class186.method3627();
            var26.clientPacket = null;
            var26.field2399 = 0;
            var26.packetBuffer = new PacketBuffer(5000);
            var26.packetBuffer.putByte(LoginPacket.field2385.id);
            field867.method2021(var26);
            field867.method2020();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var14;
         int var15;
         if(loginState == 3) {
            if(CombatInfoListHolder.soundSystem0 != null) {
               CombatInfoListHolder.soundSystem0.method2214();
            }

            if(DecorativeObject.soundSystem1 != null) {
               DecorativeObject.soundSystem1.method2214();
            }

            var14 = true;
            if(field870 && !((class159)var1).vmethod3220(1)) {
               var14 = false;
            }

            if(var14) {
               var15 = ((class159)var1).vmethod3215();
               if(CombatInfoListHolder.soundSystem0 != null) {
                  CombatInfoListHolder.soundSystem0.method2214();
               }

               if(DecorativeObject.soundSystem1 != null) {
                  DecorativeObject.soundSystem1.method2214();
               }

               if(var15 != 0) {
                  class5.method18(var15);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var32;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var32 = ((class159)var1).vmethod3188();
               if(var32 > 8 - var2.offset) {
                  var32 = 8 - var2.offset;
               }

               if(var32 > 0) {
                  ((class159)var1).vmethod3190(var2.payload, var2.offset, var32);
                  var2.offset += var32;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               Name.field3701 = var2.readLong();
               loginState = 5;
            }
         }

         if(loginState == 5) {
            field867.packetBuffer.offset = 0;
            field867.method2040();
            PacketBuffer var24 = new PacketBuffer(500);
            int[] var27 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Name.field3701 >> 32), (int)(Name.field3701 & -1L)};
            var24.offset = 0;
            var24.putByte(1);
            var24.putByte(field860.rsOrdinal());
            var24.putInt(var27[0]);
            var24.putInt(var27[1]);
            var24.putInt(var27[2]);
            var24.putInt(var27[3]);
            switch(field860.field2077) {
            case 0:
               var24.offset += 8;
               break;
            case 1:
            case 3:
               var24.put24bitInt(Ignore.field3689);
               var24.offset += 5;
               break;
            case 2:
               var24.putInt(((Integer)class221.preferences.preferences.get(Integer.valueOf(class185.method3623(class89.username)))).intValue());
               var24.offset += 4;
            }

            var24.putString(class89.password);
            var24.encryptRsa(class87.field1291, class87.field1289);
            PacketNode var6 = class186.method3627();
            var6.clientPacket = null;
            var6.field2399 = 0;
            var6.packetBuffer = new PacketBuffer(5000);
            var6.packetBuffer.offset = 0;
            if(gameState == 40) {
               var6.packetBuffer.putByte(LoginPacket.field2382.id);
            } else {
               var6.packetBuffer.putByte(LoginPacket.field2380.id);
            }

            var6.packetBuffer.putShort(0);
            int var7 = var6.packetBuffer.offset;
            var6.packetBuffer.putInt(162);
            var6.packetBuffer.putBytes(var24.payload, 0, var24.offset);
            int var8 = var6.packetBuffer.offset;
            var6.packetBuffer.putString(class89.username);
            var6.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var6.packetBuffer.putShort(WorldMapType1.canvasWidth);
            var6.packetBuffer.putShort(class263.canvasHeight);
            PacketBuffer var9 = var6.packetBuffer;
            if(field1015 != null) {
               var9.putBytes(field1015, 0, field1015.length);
            } else {
               byte[] var11 = new byte[24];

               try {
                  class157.randomDat.seek(0L);
                  class157.randomDat.read(var11);

                  int var12;
                  for(var12 = 0; var12 < 24 && var11[var12] == 0; ++var12) {
                     ;
                  }

                  if(var12 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var22) {
                  for(int var13 = 0; var13 < 24; ++var13) {
                     var11[var13] = -1;
                  }
               }

               var9.putBytes(var11, 0, var11.length);
            }

            var6.packetBuffer.putString(class61.sessionToken);
            var6.packetBuffer.putInt(class150.field2081);
            Buffer var10 = new Buffer(class27.platformInfo.method5855());
            class27.platformInfo.method5854(var10);
            var6.packetBuffer.putBytes(var10.payload, 0, var10.payload.length);
            var6.packetBuffer.putByte(class37.field477);
            var6.packetBuffer.putInt(0);
            var6.packetBuffer.putInt(GameCanvas.indexInterfaces.crc);
            var6.packetBuffer.putInt(GroundObject.indexSoundEffects.crc);
            var6.packetBuffer.putInt(class293.configsIndex.crc);
            var6.packetBuffer.putInt(AttackOption.indexCache3.crc);
            var6.packetBuffer.putInt(class23.indexCache4.crc);
            var6.packetBuffer.putInt(FontName.indexMaps.crc);
            var6.packetBuffer.putInt(class148.indexTrack1.crc);
            var6.packetBuffer.putInt(MouseRecorder.indexModels.crc);
            var6.packetBuffer.putInt(Tile.indexSprites.crc);
            var6.packetBuffer.putInt(BoundingBox3D.indexTextures.crc);
            var6.packetBuffer.putInt(indexCache10.crc);
            var6.packetBuffer.putInt(class70.indexTrack2.crc);
            var6.packetBuffer.putInt(class28.indexScripts.crc);
            var6.packetBuffer.putInt(class304.indexCache13.crc);
            var6.packetBuffer.putInt(class45.vorbisIndex.crc);
            var6.packetBuffer.putInt(class265.indexCache15.crc);
            var6.packetBuffer.putInt(class283.indexWorldMap.crc);
            var6.packetBuffer.encryptXtea(var27, var8, var6.packetBuffer.offset);
            var6.packetBuffer.method3492(var6.packetBuffer.offset - var7);
            field867.method2021(var6);
            field867.method2020();
            field867.field1439 = new ISAACCipher(var27);

            for(int var17 = 0; var17 < 4; ++var17) {
               var27[var17] += 50;
            }

            var2.seed(var27);
            loginState = 6;
         }

         if(loginState == 6 && ((class159)var1).vmethod3188() > 0) {
            var32 = ((class159)var1).vmethod3215();
            if(var32 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var32 == 2) {
               loginState = 9;
            } else if(var32 == 15 && gameState == 40) {
               field867.packetLength = -1;
               loginState = 13;
            } else if(var32 == 23 && field843 < 1) {
               ++field843;
               loginState = 0;
            } else {
               if(var32 != 29) {
                  class5.method18(var32);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class159)var1).vmethod3188() > 0) {
            field1036 = (((class159)var1).vmethod3215() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field1078 = 0;
            PacketNode.method3314("You have only just left another world.", "Your profile will be transferred in:", field1036 / 60 + " seconds.");
            if(--field1036 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && ((class159)var1).vmethod3188() >= 13) {
               var14 = ((class159)var1).vmethod3215() == 1;
               ((class159)var1).vmethod3190(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var33 = false;
               if(var14) {
                  var15 = var2.readOpcode() << 24;
                  var15 |= var2.readOpcode() << 16;
                  var15 |= var2.readOpcode() << 8;
                  var15 |= var2.readOpcode();
                  int var18 = class185.method3623(class89.username);
                  if(class221.preferences.preferences.size() >= 10 && !class221.preferences.preferences.containsKey(Integer.valueOf(var18))) {
                     Iterator var31 = class221.preferences.preferences.entrySet().iterator();
                     var31.next();
                     var31.remove();
                  }

                  class221.preferences.preferences.put(Integer.valueOf(var18), Integer.valueOf(var15));
               }

               if(class89.Login_isUsernameRemembered) {
                  class221.preferences.rememberedUsername = class89.username;
               } else {
                  class221.preferences.rememberedUsername = null;
               }

               class70.method1121();
               rights = ((class159)var1).vmethod3215();
               field976 = ((class159)var1).vmethod3215() == 1;
               localInteractingIndex = ((class159)var1).vmethod3215();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class159)var1).vmethod3215();
               field928 = ((class159)var1).vmethod3215();
               ((class159)var1).vmethod3190(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = class131.method2739();
               int var19 = var2.method3672();
               if(var19 < 0 || var19 >= var5.length) {
                  throw new IOException(var19 + " " + var2.offset);
               }

               field867.serverPacket = var5[var19];
               field867.packetLength = field867.serverPacket.packetLength;
               ((class159)var1).vmethod3190(var2.payload, 0, 2);
               var2.offset = 0;
               field867.packetLength = var2.readUnsignedShort();

               try {
                  class52.method764(class37.clientInstance, "zap");
               } catch (Throwable var21) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((class159)var1).vmethod3188() >= field867.packetLength) {
                  var2.offset = 0;
                  ((class159)var1).vmethod3190(var2.payload, 0, field867.packetLength);
                  field1076.method5349();
                  class41.method587();
                  class216.initializeGPI(var2);
                  GrandExchangeEvents.field269 = -1;
                  class19.xteaChanged(false, var2);
                  field867.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((class159)var1).vmethod3188() >= 2) {
                  var2.offset = 0;
                  ((class159)var1).vmethod3190(var2.payload, 0, 2);
                  var2.offset = 0;
                  PlayerComposition.field2701 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class159)var1).vmethod3188() >= PlayerComposition.field2701) {
                  var2.offset = 0;
                  ((class159)var1).vmethod3190(var2.payload, 0, PlayerComposition.field2701);
                  var2.offset = 0;
                  String var25 = var2.readString();
                  String var28 = var2.readString();
                  String var29 = var2.readString();
                  PacketNode.method3314(var25, var28, var29);
                  class5.setGameState(10);
               }

               if(loginState != 13) {
                  ++field1078;
                  if(field1078 > 2000) {
                     if(field843 < 1) {
                        if(ItemContainer.myWorldPort == MouseRecorder.port1) {
                           ItemContainer.myWorldPort = BoundingBox3D.port2;
                        } else {
                           ItemContainer.myWorldPort = MouseRecorder.port1;
                        }

                        ++field843;
                        loginState = 0;
                     } else {
                        class5.method18(-3);
                     }
                  }
               } else {
                  if(field867.packetLength == -1) {
                     if(((class159)var1).vmethod3188() < 2) {
                        return;
                     }

                     ((class159)var1).vmethod3190(var2.payload, 0, 2);
                     var2.offset = 0;
                     field867.packetLength = var2.readUnsignedShort();
                  }

                  if(((class159)var1).vmethod3188() >= field867.packetLength) {
                     ((class159)var1).vmethod3190(var2.payload, 0, field867.packetLength);
                     var2.offset = 0;
                     var32 = field867.packetLength;
                     field1076.method5351();
                     field867.method2040();
                     field867.packetBuffer.offset = 0;
                     field867.serverPacket = null;
                     field867.field1446 = null;
                     field867.field1435 = null;
                     field867.field1448 = null;
                     field867.packetLength = 0;
                     field867.field1450 = 0;
                     field904 = 0;
                     class61.method1048();
                     field1050 = 0;
                     destinationX = 0;

                     for(var15 = 0; var15 < 2048; ++var15) {
                        cachedPlayers[var15] = null;
                     }

                     class36.localPlayer = null;

                     for(var15 = 0; var15 < cachedNPCs.length; ++var15) {
                        NPC var30 = cachedNPCs[var15];
                        if(var30 != null) {
                           var30.interacting = -1;
                           var30.field1124 = false;
                        }
                     }

                     class1.method0();
                     class5.setGameState(30);

                     for(var15 = 0; var15 < 100; ++var15) {
                        field1012[var15] = true;
                     }

                     class237.method4338();
                     class216.initializeGPI(var2);
                     if(var32 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var23) {
         if(field843 < 1) {
            if(MouseRecorder.port1 == ItemContainer.myWorldPort) {
               ItemContainer.myWorldPort = BoundingBox3D.port2;
            } else {
               ItemContainer.myWorldPort = MouseRecorder.port1;
            }

            ++field843;
            loginState = 0;
         } else {
            class5.method18(-2);
         }
      }
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1971522788"
   )
   final void method1513() {
      if(field904 > 1) {
         --field904;
      }

      if(field1043 > 0) {
         --field1043;
      }

      if(socketError) {
         socketError = false;
         UnitPriceComparator.method138();
      } else {
         if(!isMenuOpen) {
            Widget.method4302();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1199(field867); ++var1) {
            ;
         }

         if(gameState == 30) {
            int var2;
            PacketNode var14;
            while(CombatInfoListHolder.method1818()) {
               var14 = class35.method501(ClientPacket.field2374, field867.field1439);
               var14.packetBuffer.putByte(0);
               var2 = var14.packetBuffer.offset;
               class37.encodeClassVerifier(var14.packetBuffer);
               var14.packetBuffer.method3402(var14.packetBuffer.offset - var2);
               field867.method2021(var14);
            }

            if(field1076.field3815) {
               var14 = class35.method501(ClientPacket.field2359, field867.field1439);
               var14.packetBuffer.putByte(0);
               var2 = var14.packetBuffer.offset;
               field1076.method5344(var14.packetBuffer);
               var14.packetBuffer.method3402(var14.packetBuffer.offset - var2);
               field867.method2021(var14);
               field1076.method5341();
            }

            Object var32 = class3.mouseRecorder.lock;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            synchronized(class3.mouseRecorder.lock) {
               if(!field913) {
                  class3.mouseRecorder.index = 0;
               } else if(MouseInput.mouseLastButton != 0 || class3.mouseRecorder.index >= 40) {
                  PacketNode var15 = class35.method501(ClientPacket.field2340, field867.field1439);
                  var15.packetBuffer.putByte(0);
                  var3 = var15.packetBuffer.offset;
                  var4 = 0;

                  for(var5 = 0; var5 < class3.mouseRecorder.index && var15.packetBuffer.offset - var3 < 240; ++var5) {
                     ++var4;
                     var6 = class3.mouseRecorder.ys[var5];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 502) {
                        var6 = 502;
                     }

                     var7 = class3.mouseRecorder.xs[var5];
                     if(var7 < 0) {
                        var7 = 0;
                     } else if(var7 > 764) {
                        var7 = 764;
                     }

                     var8 = var6 * 765 + var7;
                     if(class3.mouseRecorder.ys[var5] == -1 && class3.mouseRecorder.xs[var5] == -1) {
                        var7 = -1;
                        var6 = -1;
                        var8 = 524287;
                     }

                     if(var7 == field1065 && var6 == field834) {
                        if(field915 < 2047) {
                           ++field915;
                        }
                     } else {
                        var9 = var7 - field1065;
                        field1065 = var7;
                        var10 = var6 - field834;
                        field834 = var6;
                        if(field915 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                           var9 += 32;
                           var10 += 32;
                           var15.packetBuffer.putShort(var10 + (field915 << 12) + (var9 << 6));
                           field915 = 0;
                        } else if(field915 < 8) {
                           var15.packetBuffer.put24bitInt((field915 << 19) + var8 + 8388608);
                           field915 = 0;
                        } else {
                           var15.packetBuffer.putInt((field915 << 19) + var8 + -1073741824);
                           field915 = 0;
                        }
                     }
                  }

                  var15.packetBuffer.method3402(var15.packetBuffer.offset - var3);
                  field867.method2021(var15);
                  if(var4 >= class3.mouseRecorder.index) {
                     class3.mouseRecorder.index = 0;
                  } else {
                     class3.mouseRecorder.index -= var4;

                     for(var5 = 0; var5 < class3.mouseRecorder.index; ++var5) {
                        class3.mouseRecorder.xs[var5] = class3.mouseRecorder.xs[var5 + var4];
                        class3.mouseRecorder.ys[var5] = class3.mouseRecorder.ys[var5 + var4];
                     }
                  }
               }
            }

            PacketNode var18;
            if(MouseInput.mouseLastButton == 1 || !middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
               long var16 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
               if(var16 > 4095L) {
                  var16 = 4095L;
               }

               mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis * -1L;
               var3 = MouseInput.mouseLastPressedY;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class263.canvasHeight) {
                  var3 = class263.canvasHeight;
               }

               var4 = MouseInput.mouseLastPressedX;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > WorldMapType1.canvasWidth) {
                  var4 = WorldMapType1.canvasWidth;
               }

               var5 = (int)var16;
               var18 = class35.method501(ClientPacket.field2343, field867.field1439);
               var18.packetBuffer.putShort((MouseInput.mouseLastButton == 2?1:0) + (var5 << 1));
               var18.packetBuffer.putShort(var4);
               var18.packetBuffer.putShort(var3);
               field867.method2021(var18);
            }

            if(KeyFocusListener.field592 > 0) {
               var14 = class35.method501(ClientPacket.field2362, field867.field1439);
               var14.packetBuffer.putShort(0);
               var2 = var14.packetBuffer.offset;
               long var19 = ScriptVarType.currentTimeMs();

               for(var5 = 0; var5 < KeyFocusListener.field592; ++var5) {
                  long var21 = var19 - field822;
                  if(var21 > 16777215L) {
                     var21 = 16777215L;
                  }

                  field822 = var19;
                  var14.packetBuffer.method3430(KeyFocusListener.field591[var5]);
                  var14.packetBuffer.method3445((int)var21);
               }

               var14.packetBuffer.method3492(var14.packetBuffer.offset - var2);
               field867.method2021(var14);
            }

            if(field1077 > 0) {
               --field1077;
            }

            if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
               field897 = true;
            }

            if(field897 && field1077 <= 0) {
               field1077 = 20;
               field897 = false;
               var14 = class35.method501(ClientPacket.field2330, field867.field1439);
               var14.packetBuffer.writeIntLE16(mapAngle);
               var14.packetBuffer.writeIntLE16(field889);
               field867.method2021(var14);
            }

            if(class18.field305 && !field845) {
               field845 = true;
               var14 = class35.method501(ClientPacket.field2315, field867.field1439);
               var14.packetBuffer.putByte(1);
               field867.method2021(var14);
            }

            if(!class18.field305 && field845) {
               field845 = false;
               var14 = class35.method501(ClientPacket.field2315, field867.field1439);
               var14.packetBuffer.putByte(0);
               field867.method2021(var14);
            }

            class54.method775();
            if(MessageNode.plane != field952) {
               field952 = MessageNode.plane;
               WorldMapType1.method285(MessageNode.plane);
            }

            if(gameState == 30) {
               class137.method2993();
               class213.method3941();
               ++field867.field1450;
               if(field867.field1450 > 750) {
                  UnitPriceComparator.method138();
               } else {
                  class45.method640();

                  for(var1 = 0; var1 < npcIndexesCount; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var23 = cachedNPCs[var2];
                     if(var23 != null) {
                        class25.method190(var23, var23.composition.field3611);
                     }
                  }

                  class21.method167();
                  ++field882;
                  if(cursorState != 0) {
                     field871 += 20;
                     if(field871 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class25.field349 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        class60.method1015(class25.field349);
                        class25.field349 = null;
                     }
                  }

                  Widget var34 = FileRequest.field3287;
                  Widget var33 = BaseVarType.field25;
                  FileRequest.field3287 = null;
                  BaseVarType.field25 = null;
                  field858 = null;
                  field988 = false;
                  field985 = false;
                  field1028 = 0;

                  while(Varbit.method4683() && field1028 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && WorldMapData.field427 == 66) {
                        String var24 = "";

                        MessageNode var35;
                        for(Iterator var25 = class94.messages.iterator(); var25.hasNext(); var24 = var24 + var35.name + ':' + var35.value + '\n') {
                           var35 = (MessageNode)var25.next();
                        }

                        class37.clientInstance.method912(var24);
                     } else {
                        field1030[field1028] = WorldMapData.field427;
                        field1029[field1028] = class63.field722;
                        ++field1028;
                     }
                  }

                  boolean var30 = rights >= 2;
                  PacketNode var26;
                  if(var30 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var4 = class36.localPlayer.field808 - mouseWheelRotation;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != class36.localPlayer.field808) {
                        var5 = class36.localPlayer.pathX[0] + WorldMapType1.baseX;
                        var6 = class36.localPlayer.pathY[0] + class85.baseY;
                        var26 = class35.method501(ClientPacket.field2375, field867.field1439);
                        var26.packetBuffer.putByte(var4);
                        var26.packetBuffer.putShortLE(var5);
                        var26.packetBuffer.putShort(var6);
                        field867.method2021(var26);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     CombatInfo2.method4674(widgetRoot, 0, 0, WorldMapType1.canvasWidth, class263.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var36;
                     ScriptEvent var37;
                     Widget var38;
                     do {
                        var37 = (ScriptEvent)field1007.popFront();
                        if(var37 == null) {
                           while(true) {
                              do {
                                 var37 = (ScriptEvent)field917.popFront();
                                 if(var37 == null) {
                                    while(true) {
                                       do {
                                          var37 = (ScriptEvent)field1006.popFront();
                                          if(var37 == null) {
                                             this.method1200();
                                             if(ScriptState.renderOverview != null) {
                                                ScriptState.renderOverview.method5670(MessageNode.plane, (class36.localPlayer.x >> 7) + WorldMapType1.baseX, (class36.localPlayer.y >> 7) + class85.baseY, false);
                                                ScriptState.renderOverview.method5684();
                                             }

                                             if(field980 != null) {
                                                this.method1205();
                                             }

                                             if(class37.field479 != null) {
                                                class60.method1015(class37.field479);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(itemBeingDragged) {
                                                      if(FontName.field3732 == class37.field479 && field1002 != field922) {
                                                         Widget var39 = class37.field479;
                                                         byte var31 = 0;
                                                         if(field970 == 1 && var39.contentType == 206) {
                                                            var31 = 1;
                                                         }

                                                         if(var39.itemIds[field922] <= 0) {
                                                            var31 = 0;
                                                         }

                                                         if(FileOnDisk.method2530(class60.getWidgetConfig(var39))) {
                                                            var6 = field1002;
                                                            var7 = field922;
                                                            var39.itemIds[var7] = var39.itemIds[var6];
                                                            var39.itemQuantities[var7] = var39.itemQuantities[var6];
                                                            var39.itemIds[var6] = -1;
                                                            var39.itemQuantities[var6] = 0;
                                                         } else if(var31 == 1) {
                                                            var6 = field1002;
                                                            var7 = field922;

                                                            while(var7 != var6) {
                                                               if(var6 > var7) {
                                                                  var39.method4279(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var39.method4279(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var39.method4279(field922, field1002);
                                                         }

                                                         var18 = class35.method501(ClientPacket.field2321, field867.field1439);
                                                         var18.packetBuffer.method3401(class37.field479.id);
                                                         var18.packetBuffer.method3429(var31);
                                                         var18.packetBuffer.putShortLE(field922);
                                                         var18.packetBuffer.writeShortLE(field1002);
                                                         field867.method2021(var18);
                                                      }
                                                   } else if(this.method1201()) {
                                                      this.openMenu(field914, field1044);
                                                   } else if(menuOptionCount > 0) {
                                                      ScriptEvent.method1082(field914, field1044);
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   class37.field479 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field914 + 5 || MouseInput.mouseLastX < field914 - 5 || MouseInput.mouseLastY > field1044 + 5 || MouseInput.mouseLastY < field1044 - 5)) {
                                                   itemBeingDragged = true;
                                                }
                                             }

                                             if(Region.method2850()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                var18 = class35.method501(ClientPacket.field2327, field867.field1439);
                                                var18.packetBuffer.putByte(5);
                                                var18.packetBuffer.writeIntLE16(var5 + class85.baseY);
                                                var18.packetBuffer.writeShortLE(var4 + WorldMapType1.baseX);
                                                var18.packetBuffer.method3430(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                field867.method2021(var18);
                                                Region.method2851();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field871 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var34 != FileRequest.field3287) {
                                                if(var34 != null) {
                                                   class60.method1015(var34);
                                                }

                                                if(FileRequest.field3287 != null) {
                                                   class60.method1015(FileRequest.field3287);
                                                }
                                             }

                                             if(var33 != BaseVarType.field25 && field1011 == field1003) {
                                                if(var33 != null) {
                                                   class60.method1015(var33);
                                                }

                                                if(BaseVarType.field25 != null) {
                                                   class60.method1015(BaseVarType.field25);
                                                }
                                             }

                                             if(BaseVarType.field25 != null) {
                                                if(field1011 < field1003) {
                                                   ++field1011;
                                                   if(field1011 == field1003) {
                                                      class60.method1015(BaseVarType.field25);
                                                   }
                                                }
                                             } else if(field1011 > 0) {
                                                --field1011;
                                             }

                                             var4 = class36.localPlayer.x;
                                             var5 = class36.localPlayer.y;
                                             if(class43.field535 - var4 < -500 || class43.field535 - var4 > 500 || FontName.field3729 - var5 < -500 || FontName.field3729 - var5 > 500) {
                                                class43.field535 = var4;
                                                FontName.field3729 = var5;
                                             }

                                             if(var4 != class43.field535) {
                                                class43.field535 += (var4 - class43.field535) / 16;
                                             }

                                             if(var5 != FontName.field3729) {
                                                FontName.field3729 += (var5 - FontName.field3729) / 16;
                                             }

                                             if(MouseInput.mouseCurrentButton == 4 && middleMouseMovesCamera) {
                                                var6 = MouseInput.mouseLastY - field837;
                                                field892 = var6 * 2;
                                                field837 = var6 != -1 && var6 != 1?(MouseInput.mouseLastY + field837) / 2:MouseInput.mouseLastY;
                                                var7 = field893 - MouseInput.mouseLastX;
                                                field891 = var7 * 2;
                                                field893 = var7 != -1 && var7 != 1?(field893 + MouseInput.mouseLastX) / 2:MouseInput.mouseLastX;
                                             } else {
                                                if(KeyFocusListener.keyPressed[96]) {
                                                   field891 += (-24 - field891) / 2;
                                                } else if(KeyFocusListener.keyPressed[97]) {
                                                   field891 += (24 - field891) / 2;
                                                } else {
                                                   field891 /= 2;
                                                }

                                                if(KeyFocusListener.keyPressed[98]) {
                                                   field892 += (12 - field892) / 2;
                                                } else if(KeyFocusListener.keyPressed[99]) {
                                                   field892 += (-12 - field892) / 2;
                                                } else {
                                                   field892 /= 2;
                                                }

                                                field837 = MouseInput.mouseLastY;
                                                field893 = MouseInput.mouseLastX;
                                             }

                                             mapAngle = field891 / 2 + mapAngle & 2047;
                                             field889 += field892 / 2;
                                             if(field889 < 128) {
                                                field889 = 128;
                                             }

                                             if(field889 > 383) {
                                                field889 = 383;
                                             }

                                             var6 = class43.field535 >> 7;
                                             var7 = FontName.field3729 >> 7;
                                             var8 = GameCanvas.getTileHeight(class43.field535, FontName.field3729, MessageNode.plane);
                                             var9 = 0;
                                             if(var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
                                                for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                   for(int var27 = var7 - 4; var27 <= var7 + 4; ++var27) {
                                                      int var12 = MessageNode.plane;
                                                      if(var12 < 3 && (class61.tileSettings[1][var10][var27] & 2) == 2) {
                                                         ++var12;
                                                      }

                                                      int var13 = var8 - class61.tileHeights[var12][var10][var27];
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

                                             if(var10 > field898) {
                                                field898 += (var10 - field898) / 24;
                                             } else if(var10 < field898) {
                                                field898 += (var10 - field898) / 80;
                                             }

                                             if(field1051) {
                                                SoundTaskDataProvider.method763();
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1056[var4];
                                             }

                                             class61.chatMessages.process();
                                             var4 = ++MouseInput.mouseIdleTicks - 1;
                                             var6 = class61.method1026();
                                             if(var4 > 15000 && var6 > 15000) {
                                                field1043 = 250;
                                                class45.method653(14500);
                                                var26 = class35.method501(ClientPacket.field2292, field867.field1439);
                                                field867.method2021(var26);
                                             }

                                             ServerPacket.friendManager.method1671();
                                             ++field867.field1438;
                                             if(field867.field1438 > 50) {
                                                var26 = class35.method501(ClientPacket.field2325, field867.field1439);
                                                field867.method2021(var26);
                                             }

                                             try {
                                                field867.method2020();
                                             } catch (IOException var28) {
                                                UnitPriceComparator.method138();
                                             }

                                             return;
                                          }

                                          var38 = var37.widget;
                                          if(var38.index < 0) {
                                             break;
                                          }

                                          var36 = class35.getWidget(var38.parentId);
                                       } while(var36 == null || var36.children == null || var38.index >= var36.children.length || var38 != var36.children[var38.index]);

                                       class87.method1851(var37);
                                    }
                                 }

                                 var38 = var37.widget;
                                 if(var38.index < 0) {
                                    break;
                                 }

                                 var36 = class35.getWidget(var38.parentId);
                              } while(var36 == null || var36.children == null || var38.index >= var36.children.length || var38 != var36.children[var38.index]);

                              class87.method1851(var37);
                           }
                        }

                        var38 = var37.widget;
                        if(var38.index < 0) {
                           break;
                        }

                        var36 = class35.getWidget(var38.parentId);
                     } while(var36 == null || var36.children == null || var38.index >= var36.children.length || var38 != var36.children[var38.index]);

                     class87.method1851(var37);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "41930237"
   )
   void method1197() {
      int var1 = WorldMapType1.canvasWidth;
      int var2 = class263.canvasHeight;
      if(super.field656 < var1) {
         var1 = super.field656;
      }

      if(super.field640 < var2) {
         var2 = super.field640;
      }

      if(class221.preferences != null) {
         try {
            Client var3 = class37.clientInstance;
            Object[] var4 = new Object[]{Integer.valueOf(World.method1644())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-9518"
   )
   final void method1198() {
      if(widgetRoot != -1) {
         Actor.method1595(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field1012[var1]) {
            field1013[var1] = true;
         }

         field833[var1] = field1012[var1];
         field1012[var1] = false;
      }

      field1024 = gameCycle;
      field955 = -1;
      field1025 = -1;
      FontName.field3732 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         class254.method4589(widgetRoot, 0, 0, WorldMapType1.canvasWidth, class263.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field955 != -1) {
            var1 = field955;
            var2 = field1025;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               var3 = class34.method365();
               String var4;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var4 = "Use" + " " + lastSelectedItemName + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var4 = field1001 + " " + field966 + " " + "->";
               } else {
                  String var16;
                  if(var3 < 0) {
                     var16 = "";
                  } else if(menuTargets[var3].length() > 0) {
                     var16 = menuOptions[var3] + " " + menuTargets[var3];
                  } else {
                     var16 = menuOptions[var3];
                  }

                  var4 = var16;
               }

               if(menuOptionCount > 2) {
                  var4 = var4 + class1.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               ContextMenuRow.fontBold12.drawRandomizedMouseoverText(var4, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         var1 = class31.menuX;
         var2 = WorldComparator.menuY;
         var3 = Player.field794;
         int var13 = WallObject.field2000;
         int var5 = 6116423;
         Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var13, var5);
         Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var13 - 19, 0);
         ContextMenuRow.fontBold12.method5225("Choose Option", var1 + 3, var2 + 14, var5, -1);
         int var6 = MouseInput.mouseLastX;
         int var7 = MouseInput.mouseLastY;

         int var8;
         int var9;
         int var10;
         for(var8 = 0; var8 < menuOptionCount; ++var8) {
            var9 = var2 + (menuOptionCount - 1 - var8) * 15 + 31;
            var10 = 16777215;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            Font var11 = ContextMenuRow.fontBold12;
            String var12;
            if(var8 < 0) {
               var12 = "";
            } else if(menuTargets[var8].length() > 0) {
               var12 = menuOptions[var8] + " " + menuTargets[var8];
            } else {
               var12 = menuOptions[var8];
            }

            var11.method5225(var12, var1 + 3, var9, var10, 0);
         }

         var8 = class31.menuX;
         var9 = WorldComparator.menuY;
         var10 = Player.field794;
         int var14 = WallObject.field2000;

         for(int var15 = 0; var15 < widgetCount; ++var15) {
            if(widgetPositionX[var15] + widgetBoundsWidth[var15] > var8 && widgetPositionX[var15] < var8 + var10 && widgetBoundsHeight[var15] + widgetPositionY[var15] > var9 && widgetPositionY[var15] < var9 + var14) {
               field1013[var15] = true;
            }
         }
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field833[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1013[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      class70.method1122(MessageNode.plane, class36.localPlayer.x, class36.localPlayer.y, field882);
      field882 = 0;
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(Lcj;I)Z",
      garbageValue = "1121871626"
   )
   final boolean method1199(NetWriter var1) {
      class159 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         int var6;
         String var23;
         try {
            int var5;
            if(var1.serverPacket == null) {
               if(var1.field1443) {
                  if(!var2.vmethod3220(1)) {
                     return false;
                  }

                  var2.vmethod3190(var1.packetBuffer.payload, 0, 1);
                  var1.field1450 = 0;
                  var1.field1443 = false;
               }

               var3.offset = 0;
               if(var3.method3657()) {
                  if(!var2.vmethod3220(1)) {
                     return false;
                  }

                  var2.vmethod3190(var1.packetBuffer.payload, 1, 1);
                  var1.field1450 = 0;
               }

               var1.field1443 = true;
               ServerPacket[] var4 = class131.method2739();
               var5 = var3.method3672();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.serverPacket = var4[var5];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3220(1)) {
                  return false;
               }

               var1.getSocket().vmethod3190(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3220(2)) {
                  return false;
               }

               var1.getSocket().vmethod3190(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3220(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3190(var3.payload, 0, var1.packetLength);
            var1.field1450 = 0;
            field1076.method5338();
            var1.field1448 = var1.field1435;
            var1.field1435 = var1.field1446;
            var1.field1446 = var1.serverPacket;
            String var58;
            if(ServerPacket.field2216 == var1.serverPacket) {
               var58 = var3.readString();
               Object[] var81 = new Object[var58.length() + 1];

               for(var6 = var58.length() - 1; var6 >= 0; --var6) {
                  if(var58.charAt(var6) == 's') {
                     var81[var6 + 1] = var3.readString();
                  } else {
                     var81[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var81[0] = new Integer(var3.readInt());
               ScriptEvent var85 = new ScriptEvent();
               var85.objs = var81;
               class87.method1851(var85);
               var1.serverPacket = null;
               return true;
            }

            String var8;
            int var25;
            boolean var60;
            String var79;
            if(ServerPacket.field2250 == var1.serverPacket) {
               var25 = var3.getUSmart();
               var60 = var3.readUnsignedByte() == 1;
               var79 = "";
               boolean var66 = false;
               if(var60) {
                  var79 = var3.readString();
                  if(ServerPacket.friendManager.method1670(new Name(var79, class34.loginType))) {
                     var66 = true;
                  }
               }

               var8 = var3.readString();
               if(!var66) {
                  class240.sendGameMessage(var25, var79, var8);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var24;
            if(ServerPacket.field2261 == var1.serverPacket) {
               var25 = var3.method3450();
               var23 = var3.readString();
               var24 = class35.getWidget(var25);
               if(!var23.equals(var24.text)) {
                  var24.text = var23;
                  class60.method1015(var24);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2229 == var1.serverPacket) {
               var25 = var3.method3442();
               byte var70 = var3.readByte();
               class222.settings[var25] = var70;
               if(class222.widgetSettings[var25] != var70) {
                  class222.widgetSettings[var25] = var70;
               }

               WorldMapType1.method283(var25);
               field993[++field994 - 1 & 31] = var25;
               var1.serverPacket = null;
               return true;
            }

            long var9;
            String var18;
            int var19;
            long var26;
            long var28;
            if(ServerPacket.field2203 == var1.serverPacket) {
               var58 = var3.readString();
               var26 = var3.readLong();
               var28 = (long)var3.readUnsignedShort();
               var9 = (long)var3.read24BitInt();
               Permission[] var65 = new Permission[]{Permission.field3257, Permission.field3253, Permission.field3248, Permission.field3252, Permission.field3251, Permission.field3250};
               Permission var68 = (Permission)ClanMember.forOrdinal(var65, var3.readUnsignedByte());
               long var13 = var9 + (var28 << 32);
               boolean var69 = false;

               for(int var71 = 0; var71 < 100; ++var71) {
                  if(field965[var71] == var13) {
                     var69 = true;
                     break;
                  }
               }

               if(var68.field3256 && ServerPacket.friendManager.method1670(new Name(var58, class34.loginType))) {
                  var69 = true;
               }

               if(!var69 && myPlayerIndex == 0) {
                  field965[field1027] = var13;
                  field1027 = (field1027 + 1) % 100;
                  String var84 = IndexData.method4484(var3, 32767);
                  String var72 = FontTypeFace.appendTags(PlayerComposition.method4246(var84));
                  if(var68.field3254 != -1) {
                     var19 = var68.field3254;
                     var18 = "<img=" + var19 + ">";
                     class221.addChatMessage(9, var18 + var58, var72, class268.method4895(var26));
                  } else {
                     class221.addChatMessage(9, var58, var72, class268.method4895(var26));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2209 == var1.serverPacket) {
               class19.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            int var7;
            int var31;
            if(ServerPacket.field2246 == var1.serverPacket) {
               var25 = var3.readUnsignedShort();
               if(var25 == 65535) {
                  var25 = -1;
               }

               var5 = var3.method3450();
               var6 = var3.readUnsignedShortOb1();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var7 = var3.method3451();

               for(var31 = var25; var31 <= var6; ++var31) {
                  var9 = (long)var31 + ((long)var5 << 32);
                  Node var64 = widgetFlags.get(var9);
                  if(var64 != null) {
                     var64.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var7), var9);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2201 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  var25 = var3.offset - 28;
                  byte[] var80 = var3.payload;
                  if(field1015 == null) {
                     field1015 = new byte[24];
                  }

                  class194.method3712(var80, var25, field1015, 0, 24);
                  if(class157.randomDat != null) {
                     try {
                        class157.randomDat.seek(0L);
                        class157.randomDat.write(var3.payload, var25, 24);
                     } catch (Exception var49) {
                        ;
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2266 == var1.serverPacket) {
               if(var1.packetLength == 0) {
                  class234.clanMemberManager = null;
               } else {
                  if(class234.clanMemberManager == null) {
                     class234.clanMemberManager = new ClanMemberManager(class34.loginType, class37.clientInstance);
                  }

                  class234.clanMemberManager.method5164(var3);
               }

               field949 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2204 == var1.serverPacket) {
               field1051 = false;

               for(var25 = 0; var25 < 5; ++var25) {
                  field1052[var25] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2270 == var1.serverPacket) {
               class36.field465 = var3.readUnsignedByteNegate();
               GZipDecompressor.field2423 = var3.method3432();

               for(var25 = GZipDecompressor.field2423; var25 < GZipDecompressor.field2423 + 8; ++var25) {
                  for(var5 = class36.field465; var5 < class36.field465 + 8; ++var5) {
                     if(groundItemDeque[MessageNode.plane][var25][var5] != null) {
                        groundItemDeque[MessageNode.plane][var25][var5] = null;
                        AbstractSoundSystem.groundItemSpawned(var25, var5);
                     }
                  }
               }

               for(PendingSpawn var59 = (PendingSpawn)pendingSpawns.getFront(); var59 != null; var59 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var59.x >= GZipDecompressor.field2423 && var59.x < GZipDecompressor.field2423 + 8 && var59.y >= class36.field465 && var59.y < class36.field465 + 8 && var59.level == MessageNode.plane) {
                     var59.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            int var32;
            if(ServerPacket.field2211 == var1.serverPacket) {
               var25 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var25 < -70000) {
                  var5 += 32768;
               }

               if(var25 >= 0) {
                  var24 = class35.getWidget(var25);
               } else {
                  var24 = null;
               }

               for(; var3.offset < var1.packetLength; class29.setItemTableSlot(var5, var7, var31 - 1, var32)) {
                  var7 = var3.getUSmart();
                  var31 = var3.readUnsignedShort();
                  var32 = 0;
                  if(var31 != 0) {
                     var32 = var3.readUnsignedByte();
                     if(var32 == 255) {
                        var32 = var3.readInt();
                     }
                  }

                  if(var24 != null && var7 >= 0 && var7 < var24.itemIds.length) {
                     var24.itemIds[var7] = var31;
                     var24.itemQuantities[var7] = var32;
                  }
               }

               if(var24 != null) {
                  class60.method1015(var24);
               }

               WorldMapType3.method219();
               interfaceItemTriggers[++field1073 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2228 == var1.serverPacket) {
               class29.method259(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2272 == var1.serverPacket) {
               ServerPacket.friendManager.field1196.method5029(var3, var1.packetLength);
               ScriptState.method1051();
               field1000 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2221 == var1.serverPacket) {
               for(var25 = 0; var25 < VarPlayerType.field3351; ++var25) {
                  VarPlayerType var82 = (VarPlayerType)VarPlayerType.varplayers.get((long)var25);
                  VarPlayerType var78;
                  if(var82 != null) {
                     var78 = var82;
                  } else {
                     byte[] var92 = class175.varplayer_ref.getConfigData(16, var25);
                     var82 = new VarPlayerType();
                     if(var92 != null) {
                        var82.decode(new Buffer(var92));
                     }

                     VarPlayerType.varplayers.put(var82, (long)var25);
                     var78 = var82;
                  }

                  if(var78 != null) {
                     class222.settings[var25] = 0;
                     class222.widgetSettings[var25] = 0;
                  }
               }

               WorldMapType3.method219();
               field994 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2243 == var1.serverPacket) {
               var25 = var3.readInt();
               WidgetNode var77 = (WidgetNode)componentTable.get((long)var25);
               if(var77 != null) {
                  GraphicsObject.method1797(var77, true);
               }

               if(field971 != null) {
                  class60.method1015(field971);
                  field971 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2213 == var1.serverPacket) {
               var58 = var3.readString();
               var5 = var3.method3432();
               var6 = var3.readUnsignedByte();
               if(var5 >= 1 && var5 <= 8) {
                  if(var58.equalsIgnoreCase("null")) {
                     var58 = null;
                  }

                  playerOptions[var5 - 1] = var58;
                  playerOptionsPriorities[var5 - 1] = var6 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2256 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2396);
               var1.serverPacket = null;
               return true;
            }

            int var10;
            if(ServerPacket.field2260 == var1.serverPacket) {
               var25 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var25 < -70000) {
                  var5 += 32768;
               }

               if(var25 >= 0) {
                  var24 = class35.getWidget(var25);
               } else {
                  var24 = null;
               }

               if(var24 != null) {
                  for(var7 = 0; var7 < var24.itemIds.length; ++var7) {
                     var24.itemIds[var7] = 0;
                     var24.itemQuantities[var7] = 0;
                  }
               }

               ItemContainer var91 = (ItemContainer)ItemContainer.itemContainers.get((long)var5);
               if(var91 != null) {
                  for(var31 = 0; var31 < var91.itemIds.length; ++var31) {
                     var91.itemIds[var31] = -1;
                     var91.stackSizes[var31] = 0;
                  }
               }

               var7 = var3.readUnsignedShort();

               for(var31 = 0; var31 < var7; ++var31) {
                  var32 = var3.readUnsignedByte();
                  if(var32 == 255) {
                     var32 = var3.method3451();
                  }

                  var10 = var3.readUnsignedShortOb1();
                  if(var24 != null && var31 < var24.itemIds.length) {
                     var24.itemIds[var31] = var10;
                     var24.itemQuantities[var31] = var32;
                  }

                  class29.setItemTableSlot(var5, var31, var10 - 1, var32);
               }

               if(var24 != null) {
                  class60.method1015(var24);
               }

               WorldMapType3.method219();
               interfaceItemTriggers[++field1073 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2274 == var1.serverPacket) {
               field1051 = true;
               Script.field1409 = var3.readUnsignedByte();
               Actor.field1158 = var3.readUnsignedByte();
               KeyFocusListener.field598 = var3.readUnsignedShort();
               class283.field3718 = var3.readUnsignedByte();
               GrandExchangeOffer.field294 = var3.readUnsignedByte();
               if(GrandExchangeOffer.field294 >= 100) {
                  var25 = Script.field1409 * 128 + 64;
                  var5 = Actor.field1158 * 128 + 64;
                  var6 = GameCanvas.getTileHeight(var25, var5, MessageNode.plane) - KeyFocusListener.field598;
                  var7 = var25 - Actor.cameraX;
                  var31 = var6 - class60.cameraZ;
                  var32 = var5 - GameCanvas.cameraY;
                  var10 = (int)Math.sqrt((double)(var32 * var32 + var7 * var7));
                  SceneTilePaint.cameraPitch = (int)(Math.atan2((double)var31, (double)var10) * 325.949D) & 2047;
                  class33.cameraYaw = (int)(Math.atan2((double)var7, (double)var32) * -325.949D) & 2047;
                  if(SceneTilePaint.cameraPitch < 128) {
                     SceneTilePaint.cameraPitch = 128;
                  }

                  if(SceneTilePaint.cameraPitch > 383) {
                     SceneTilePaint.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var33;
            if(ServerPacket.field2233 == var1.serverPacket) {
               var25 = var3.method3440();
               if(var25 == 65535) {
                  var25 = -1;
               }

               var5 = var3.method3452();
               var6 = var3.readInt();
               var33 = class35.getWidget(var5);
               ItemComposition var63;
               if(!var33.hasScript) {
                  if(var25 == -1) {
                     var33.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var63 = CombatInfo1.getItemDefinition(var25);
                  var33.modelType = 4;
                  var33.modelId = var25;
                  var33.rotationX = var63.xan2d;
                  var33.rotationZ = var63.yan2d;
                  var33.modelZoom = var63.zoom2d * 100 / var6;
                  class60.method1015(var33);
               } else {
                  var33.itemId = var25;
                  var33.itemQuantity = var6;
                  var63 = CombatInfo1.getItemDefinition(var25);
                  var33.rotationX = var63.xan2d;
                  var33.rotationZ = var63.yan2d;
                  var33.rotationY = var63.zan2d;
                  var33.field2787 = var63.offsetX2d;
                  var33.field2782 = var63.offsetY2d;
                  var33.modelZoom = var63.zoom2d;
                  if(var63.isStackable == 1) {
                     var33.field2739 = 1;
                  } else {
                     var33.field2739 = 2;
                  }

                  if(var33.field2724 > 0) {
                     var33.modelZoom = var33.modelZoom * 32 / var33.field2724;
                  } else if(var33.originalWidth > 0) {
                     var33.modelZoom = var33.modelZoom * 32 / var33.originalWidth;
                  }

                  class60.method1015(var33);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2253 == var1.serverPacket) {
               GrandExchangeEvents.method89();
               var1.serverPacket = null;
               return false;
            }

            Widget var61;
            if(ServerPacket.field2208 == var1.serverPacket) {
               var25 = var3.method3452();
               var5 = var3.method3442();
               var6 = var3.readUnsignedShort();
               var7 = var3.readUnsignedShort();
               var61 = class35.getWidget(var25);
               if(var7 != var61.rotationX || var5 != var61.rotationZ || var6 != var61.modelZoom) {
                  var61.rotationX = var7;
                  var61.rotationZ = var5;
                  var61.modelZoom = var6;
                  class60.method1015(var61);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2251 == var1.serverPacket) {
               var25 = var3.readInt();
               var5 = var3.readInt();
               var6 = ISAACCipher.method3691();
               PacketNode var88 = class35.method501(ClientPacket.field2312, field867.field1439);
               var88.packetBuffer.method3387(var25);
               var88.packetBuffer.writeIntLE(var5);
               var88.packetBuffer.method3397(GameEngine.FPS);
               var88.packetBuffer.putByte(var6);
               field867.method2021(var88);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2218 == var1.serverPacket) {
               if(class234.clanMemberManager != null) {
                  class234.clanMemberManager.method5165(var3);
               }

               field949 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2252 == var1.serverPacket) {
               var25 = var3.method3442();
               if(var25 == 65535) {
                  var25 = -1;
               }

               ItemContainer.method1067(var25);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2202 == var1.serverPacket) {
               var25 = var3.method3446();
               var5 = var3.method3440();
               if(var5 == 65535) {
                  var5 = -1;
               }

               if(field1040 != 0 && var5 != -1) {
                  class163.method3202(class70.indexTrack2, var5, 0, field1040, false);
                  field1014 = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2199 == var1.serverPacket) {
               class31.field415 = CollisionData.method3285(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            WidgetNode var86;
            if(ServerPacket.field2227 == var1.serverPacket) {
               var25 = var3.method3432();
               var5 = var3.method3452();
               var6 = var3.readUnsignedShort();
               var86 = (WidgetNode)componentTable.get((long)var5);
               if(var86 != null) {
                  GraphicsObject.method1797(var86, var6 != var86.id);
               }

               WidgetNode var62 = new WidgetNode();
               var62.id = var6;
               var62.owner = var25;
               componentTable.put(var62, (long)var5);
               class28.method255(var6);
               Widget var89 = class35.getWidget(var5);
               class60.method1015(var89);
               if(field971 != null) {
                  class60.method1015(field971);
                  field971 = null;
               }

               BoundingBox2D.method55();
               class33.method362(FileRequest.widgets[var5 >> 16], var89, false);
               class180.method3377(var6);
               if(widgetRoot != -1) {
                  var10 = widgetRoot;
                  if(class213.loadWidget(var10)) {
                     Overlay.method4945(FileRequest.widgets[var10], 1);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2245 == var1.serverPacket) {
               var25 = var3.readInt();
               var5 = var3.method3457();
               var24 = class35.getWidget(var25);
               if(var5 != var24.field2785 || var5 == -1) {
                  var24.field2785 = var5;
                  var24.field2860 = 0;
                  var24.field2871 = 0;
                  class60.method1015(var24);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2268 == var1.serverPacket) {
               var25 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               if(field1008 != 0 && var5 != 0 && queuedSoundEffectCount < 50) {
                  queuedSoundEffectIDs[queuedSoundEffectCount] = var25;
                  unknownSoundValues1[queuedSoundEffectCount] = var5;
                  unknownSoundValues2[queuedSoundEffectCount] = var6;
                  audioEffects[queuedSoundEffectCount] = null;
                  soundLocations[queuedSoundEffectCount] = 0;
                  ++queuedSoundEffectCount;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2267 == var1.serverPacket) {
               var58 = var3.readString();
               var23 = IndexData.method4484(var3, 32767);
               var79 = FontTypeFace.appendTags(PlayerComposition.method4246(var23));
               class240.sendGameMessage(6, var58, var79);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2222 == var1.serverPacket) {
               ServerPacket.friendManager.method1665();
               field1000 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2232 == var1.serverPacket) {
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

            if(ServerPacket.field2278 == var1.serverPacket) {
               var25 = var3.method3442();
               var5 = var3.method3451();
               var24 = class35.getWidget(var5);
               if(var24.modelType != 1 || var25 != var24.modelId) {
                  var24.modelType = 1;
                  var24.modelId = var25;
                  class60.method1015(var24);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2249 == var1.serverPacket) {
               var25 = var3.readUnsignedShortOb1();
               BoundingBox3DDrawMode.method72(var25);
               interfaceItemTriggers[++field1073 - 1 & 31] = var25 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2275 == var1.serverPacket) {
               for(var25 = 0; var25 < class222.widgetSettings.length; ++var25) {
                  if(class222.widgetSettings[var25] != class222.settings[var25]) {
                     class222.widgetSettings[var25] = class222.settings[var25];
                     WorldMapType1.method283(var25);
                     field993[++field994 - 1 & 31] = var25;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2224 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2389);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2205 == var1.serverPacket) {
               var25 = var3.method3452();
               var5 = var3.method3442();
               var6 = var3.method3442();
               var33 = class35.getWidget(var25);
               var33.field2794 = var5 + (var6 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2234 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  var25 = widgetRoot;
                  if(class213.loadWidget(var25)) {
                     Overlay.method4945(FileRequest.widgets[var25], 0);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2207 == var1.serverPacket) {
               var25 = var3.readUnsignedShort();
               widgetRoot = var25;
               this.method1203(false);
               class28.method255(var25);
               class180.method3377(widgetRoot);

               for(var5 = 0; var5 < 100; ++var5) {
                  field1012[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var74;
            if(ServerPacket.field2271 == var1.serverPacket) {
               var25 = var3.readInt();
               var74 = class35.getWidget(var25);

               for(var6 = 0; var6 < var74.itemIds.length; ++var6) {
                  var74.itemIds[var6] = -1;
                  var74.itemIds[var6] = 0;
               }

               class60.method1015(var74);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2247 == var1.serverPacket) {
               ServerPacket.friendManager.method1694(var3, var1.packetLength);
               field1000 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2214 == var1.serverPacket) {
               field1050 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2215 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2395);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2236 == var1.serverPacket) {
               for(var25 = 0; var25 < cachedPlayers.length; ++var25) {
                  if(cachedPlayers[var25] != null) {
                     cachedPlayers[var25].animation = -1;
                  }
               }

               for(var25 = 0; var25 < cachedNPCs.length; ++var25) {
                  if(cachedNPCs[var25] != null) {
                     cachedNPCs[var25].animation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2231 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2388);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2244 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2391);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2240 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2390);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2257 == var1.serverPacket) {
               class19.method162(var3.readString());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2276 == var1.serverPacket) {
               var25 = var3.method3442();
               var5 = var3.method3450();
               var24 = class35.getWidget(var5);
               if(var24.modelType != 2 || var25 != var24.modelId) {
                  var24.modelType = 2;
                  var24.modelId = var25;
                  class60.method1015(var24);
               }

               var1.serverPacket = null;
               return true;
            }

            int var14;
            if(ServerPacket.field2198 == var1.serverPacket) {
               var58 = var3.readString();
               var26 = (long)var3.readUnsignedShort();
               var28 = (long)var3.read24BitInt();
               Permission[] var87 = new Permission[]{Permission.field3257, Permission.field3253, Permission.field3248, Permission.field3252, Permission.field3251, Permission.field3250};
               Permission var93 = (Permission)ClanMember.forOrdinal(var87, var3.readUnsignedByte());
               long var36 = (var26 << 32) + var28;
               boolean var38 = false;

               for(var14 = 0; var14 < 100; ++var14) {
                  if(var36 == field965[var14]) {
                     var38 = true;
                     break;
                  }
               }

               if(ServerPacket.friendManager.method1670(new Name(var58, class34.loginType))) {
                  var38 = true;
               }

               if(!var38 && myPlayerIndex == 0) {
                  field965[field1027] = var36;
                  field1027 = (field1027 + 1) % 100;
                  String var94 = IndexData.method4484(var3, 32767);
                  String var95 = FontTypeFace.appendTags(PlayerComposition.method4246(var94));
                  byte var16;
                  if(var93.field3255) {
                     var16 = 7;
                  } else {
                     var16 = 3;
                  }

                  if(var93.field3254 != -1) {
                     var19 = var93.field3254;
                     var18 = "<img=" + var19 + ">";
                     class240.sendGameMessage(var16, var18 + var58, var95);
                  } else {
                     class240.sendGameMessage(var16, var58, var95);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2219 == var1.serverPacket) {
               var25 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var25] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var25] = new GrandExchangeOffer(var3, false);
               }

               field1021 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2220 == var1.serverPacket) {
               class36.field465 = var3.readUnsignedByteNegate();
               GZipDecompressor.field2423 = var3.method3433();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2206 == var1.serverPacket) {
               var25 = var3.method3452();
               var60 = var3.method3432() == 1;
               var24 = class35.getWidget(var25);
               if(var60 != var24.isHidden) {
                  var24.isHidden = var60;
                  class60.method1015(var24);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2277 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2394);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2230 == var1.serverPacket) {
               World var57 = new World();
               var57.address = var3.readString();
               var57.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var57.mask = var5;
               class5.setGameState(45);
               var2.vmethod3186();
               var2 = null;
               LoginPacket.method3293(var57);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2265 == var1.serverPacket) {
               var25 = var3.offset + var1.packetLength;
               var5 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var5 != widgetRoot) {
                  widgetRoot = var5;
                  this.method1203(false);
                  class28.method255(widgetRoot);
                  class180.method3377(widgetRoot);

                  for(var7 = 0; var7 < 100; ++var7) {
                     field1012[var7] = true;
                  }
               }

               WidgetNode var90;
               for(; var6-- > 0; var90.field744 = true) {
                  var7 = var3.readInt();
                  var31 = var3.readUnsignedShort();
                  var32 = var3.readUnsignedByte();
                  var90 = (WidgetNode)componentTable.get((long)var7);
                  if(var90 != null && var31 != var90.id) {
                     GraphicsObject.method1797(var90, true);
                     var90 = null;
                  }

                  if(var90 == null) {
                     WidgetNode var67 = new WidgetNode();
                     var67.id = var31;
                     var67.owner = var32;
                     componentTable.put(var67, (long)var7);
                     class28.method255(var31);
                     Widget var96 = class35.getWidget(var7);
                     class60.method1015(var96);
                     if(field971 != null) {
                        class60.method1015(field971);
                        field971 = null;
                     }

                     BoundingBox2D.method55();
                     class33.method362(FileRequest.widgets[var7 >> 16], var96, false);
                     class180.method3377(var31);
                     if(widgetRoot != -1) {
                        var14 = widgetRoot;
                        if(class213.loadWidget(var14)) {
                           Overlay.method4945(FileRequest.widgets[var14], 1);
                        }
                     }

                     var90 = var67;
                  }
               }

               for(var86 = (WidgetNode)componentTable.first(); var86 != null; var86 = (WidgetNode)componentTable.next()) {
                  if(var86.field744) {
                     var86.field744 = false;
                  } else {
                     GraphicsObject.method1797(var86, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var25) {
                  var7 = var3.readInt();
                  var31 = var3.readUnsignedShort();
                  var32 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(int var43 = var31; var43 <= var32; ++var43) {
                     long var44 = (long)var43 + ((long)var7 << 32);
                     widgetFlags.put(new IntegerNode(var10), var44);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2226 == var1.serverPacket) {
               publicChatMode = var3.readUnsignedByteNegate();
               field975 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2248 == var1.serverPacket) {
               field904 = var3.method3440() * 30;
               field862 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2264 == var1.serverPacket) {
               field1051 = true;
               class295.field3781 = var3.readUnsignedByte();
               class22.field322 = var3.readUnsignedByte();
               class60.field681 = var3.readUnsignedShort();
               Occluder.field2036 = var3.readUnsignedByte();
               WorldMapType2.field491 = var3.readUnsignedByte();
               if(WorldMapType2.field491 >= 100) {
                  Actor.cameraX = class295.field3781 * 128 + 64;
                  GameCanvas.cameraY = class22.field322 * 128 + 64;
                  class60.cameraZ = GameCanvas.getTileHeight(Actor.cameraX, GameCanvas.cameraY, MessageNode.plane) - class60.field681;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2254 == var1.serverPacket) {
               boolean var83 = var3.readUnsignedByte() == 1;
               if(var83) {
                  class37.field473 = ScriptVarType.currentTimeMs() - var3.readLong();
                  Varcs.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  Varcs.grandExchangeEvents = null;
               }

               field859 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2255 == var1.serverPacket) {
               var25 = var3.method3452();
               var5 = var3.method3450();
               WidgetNode var75 = (WidgetNode)componentTable.get((long)var25);
               var86 = (WidgetNode)componentTable.get((long)var5);
               if(var86 != null) {
                  GraphicsObject.method1797(var86, var75 == null || var86.id != var75.id);
               }

               if(var75 != null) {
                  var75.unlink();
                  componentTable.put(var75, (long)var5);
               }

               var61 = class35.getWidget(var25);
               if(var61 != null) {
                  class60.method1015(var61);
               }

               var61 = class35.getWidget(var5);
               if(var61 != null) {
                  class60.method1015(var61);
                  class33.method362(FileRequest.widgets[var61.id >>> 16], var61, true);
               }

               if(widgetRoot != -1) {
                  var32 = widgetRoot;
                  if(class213.loadWidget(var32)) {
                     Overlay.method4945(FileRequest.widgets[var32], 1);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2225 == var1.serverPacket) {
               WorldMapType3.method219();
               energy = var3.readUnsignedByte();
               field862 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2239 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2393);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2263 == var1.serverPacket) {
               var25 = var3.method3451();
               var5 = var3.readUnsignedShort();
               class222.settings[var5] = var25;
               if(class222.widgetSettings[var5] != var25) {
                  class222.widgetSettings[var5] = var25;
               }

               WorldMapType1.method283(var5);
               field993[++field994 - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2217 == var1.serverPacket) {
               var25 = var3.readShort();
               var5 = var3.method3443();
               var6 = var3.method3450();
               var33 = class35.getWidget(var6);
               if(var25 != var33.originalX || var5 != var33.originalY || var33.dynamicX != 0 || var33.dynamicY != 0) {
                  var33.originalX = var25;
                  var33.originalY = var5;
                  var33.dynamicX = 0;
                  var33.dynamicY = 0;
                  class60.method1015(var33);
                  this.widgetMethod0(var33);
                  if(var33.type == 0) {
                     class33.method362(FileRequest.widgets[var6 >> 16], var33, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2237 == var1.serverPacket) {
               class19.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2210 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2392);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2223 == var1.serverPacket) {
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

            if(ServerPacket.field2241 == var1.serverPacket) {
               var25 = var3.method3442();
               var5 = var3.method3452();
               var6 = var25 >> 10 & 31;
               var7 = var25 >> 5 & 31;
               var31 = var25 & 31;
               var32 = (var7 << 11) + (var6 << 19) + (var31 << 3);
               Widget var35 = class35.getWidget(var5);
               if(var32 != var35.textColor) {
                  var35.textColor = var32;
                  class60.method1015(var35);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2200 == var1.serverPacket) {
               class36.field465 = var3.readUnsignedByteNegate();
               GZipDecompressor.field2423 = var3.readUnsignedByte();

               while(var3.offset < var1.packetLength) {
                  var25 = var3.readUnsignedByte();
                  class173 var76 = ContextMenuRow.method1847()[var25];
                  UnitPriceComparator.method139(var76);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2258 == var1.serverPacket) {
               class29.method259(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2238 == var1.serverPacket) {
               Preferences.method1662(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2242 == var1.serverPacket) {
               UnitPriceComparator.method139(class173.field2397);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2259 == var1.serverPacket) {
               var25 = var3.method3451();
               var74 = class35.getWidget(var25);
               var74.modelType = 3;
               var74.modelId = class36.localPlayer.composition.method4216();
               class60.method1015(var74);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2273 == var1.serverPacket) {
               WorldMapType3.method219();
               weight = var3.readShort();
               field862 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2235 == var1.serverPacket) {
               WorldMapType3.method219();
               var25 = var3.method3433();
               var5 = var3.readUnsignedByte();
               var6 = var3.method3452();
               skillExperiences[var25] = var6;
               boostedSkillLevels[var25] = var5;
               realSkillLevels[var25] = 1;

               for(var7 = 0; var7 < 98; ++var7) {
                  if(var6 >= class233.field2920[var7]) {
                     realSkillLevels[var25] = var7 + 2;
                  }
               }

               field1059[++field998 - 1 & 31] = var25;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2269 == var1.serverPacket) {
               var25 = var3.method3440();
               var5 = var3.method3450();
               var24 = class35.getWidget(var5);
               if(var24 != null && var24.type == 0) {
                  if(var25 > var24.scrollHeight - var24.height) {
                     var25 = var24.scrollHeight - var24.height;
                  }

                  if(var25 < 0) {
                     var25 = 0;
                  }

                  if(var25 != var24.scrollY) {
                     var24.scrollY = var25;
                     class60.method1015(var24);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2262 == var1.serverPacket) {
               var25 = var1.packetLength;
               ClassInfo var73 = new ClassInfo();
               var73.count = var3.readUnsignedByte();
               var73.field3836 = var3.readInt();
               var73.type = new int[var73.count];
               var73.errorIdentifiers = new int[var73.count];
               var73.fields = new Field[var73.count];
               var73.field3841 = new int[var73.count];
               var73.methods = new Method[var73.count];
               var73.args = new byte[var73.count][][];

               for(var6 = 0; var6 < var73.count; ++var6) {
                  try {
                     var7 = var3.readUnsignedByte();
                     String var34;
                     if(var7 != 0 && var7 != 1 && var7 != 2) {
                        if(var7 == 3 || var7 == 4) {
                           var8 = var3.readString();
                           var34 = var3.readString();
                           var10 = var3.readUnsignedByte();
                           String[] var11 = new String[var10];

                           for(int var46 = 0; var46 < var10; ++var46) {
                              var11[var46] = var3.readString();
                           }

                           String var12 = var3.readString();
                           byte[][] var42 = new byte[var10][];
                           int var15;
                           if(var7 == 3) {
                              for(var14 = 0; var14 < var10; ++var14) {
                                 var15 = var3.readInt();
                                 var42[var14] = new byte[var15];
                                 var3.readBytes(var42[var14], 0, var15);
                              }
                           }

                           var73.type[var6] = var7;
                           Class[] var39 = new Class[var10];

                           for(var15 = 0; var15 < var10; ++var15) {
                              var39[var15] = class46.loadClassFromDescriptor(var11[var15]);
                           }

                           Class var40 = class46.loadClassFromDescriptor(var12);
                           if(class46.loadClassFromDescriptor(var8).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var30 = class46.loadClassFromDescriptor(var8).getDeclaredMethods();
                           Method[] var17 = var30;

                           for(int var47 = 0; var47 < var17.length; ++var47) {
                              Method var48 = var17[var47];
                              if(Reflection.getMethodName(var48).equals(var34)) {
                                 Class[] var20 = Reflection.getParameterTypes(var48);
                                 if(var39.length == var20.length) {
                                    boolean var21 = true;

                                    for(int var22 = 0; var22 < var39.length; ++var22) {
                                       if(var39[var22] != var20[var22]) {
                                          var21 = false;
                                          break;
                                       }
                                    }

                                    if(var21 && var40 == var48.getReturnType()) {
                                       var73.methods[var6] = var48;
                                    }
                                 }
                              }
                           }

                           var73.args[var6] = var42;
                        }
                     } else {
                        var8 = var3.readString();
                        var34 = var3.readString();
                        var10 = 0;
                        if(var7 == 1) {
                           var10 = var3.readInt();
                        }

                        var73.type[var6] = var7;
                        var73.field3841[var6] = var10;
                        if(class46.loadClassFromDescriptor(var8).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var73.fields[var6] = Reflection.findField(class46.loadClassFromDescriptor(var8), var34);
                     }
                  } catch (ClassNotFoundException var50) {
                     var73.errorIdentifiers[var6] = -1;
                  } catch (SecurityException var51) {
                     var73.errorIdentifiers[var6] = -2;
                  } catch (NullPointerException var52) {
                     var73.errorIdentifiers[var6] = -3;
                  } catch (Exception var53) {
                     var73.errorIdentifiers[var6] = -4;
                  } catch (Throwable var54) {
                     var73.errorIdentifiers[var6] = -5;
                  }
               }

               class304.classInfos.addFirst(var73);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2212 == var1.serverPacket) {
               var25 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var7 = var3.readUnsignedByte();
               field1052[var25] = true;
               field908[var25] = var5;
               field1054[var25] = var6;
               field1055[var25] = var7;
               field1056[var25] = 0;
               var1.serverPacket = null;
               return true;
            }

            class89.method1900("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1435 != null?var1.field1435.packetId:-1) + "," + (var1.field1448 != null?var1.field1448.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            GrandExchangeEvents.method89();
         } catch (IOException var55) {
            UnitPriceComparator.method138();
         } catch (Exception var56) {
            var23 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1435 != null?var1.field1435.packetId:-1) + "," + (var1.field1448 != null?var1.field1448.packetId:-1) + "," + var1.packetLength + "," + (class36.localPlayer.pathX[0] + WorldMapType1.baseX) + "," + (class36.localPlayer.pathY[0] + class85.baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var23 = var23 + var3.payload[var6] + ",";
            }

            class89.method1900(var23, var56);
            GrandExchangeEvents.method89();
         }

         return true;
      }
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-16724"
   )
   final void method1200() {
      class45.method655();
      if(class37.field479 == null) {
         if(field980 == null) {
            int var1 = MouseInput.mouseLastButton;
            int var2;
            int var3;
            int var4;
            int var5;
            if(isMenuOpen) {
               if(var1 != 1 && (middleMouseMovesCamera || var1 != 4)) {
                  var2 = MouseInput.mouseLastX;
                  var3 = MouseInput.mouseLastY;
                  if(var2 < class31.menuX - 10 || var2 > Player.field794 + class31.menuX + 10 || var3 < WorldComparator.menuY - 10 || var3 > WorldComparator.menuY + WallObject.field2000 + 10) {
                     isMenuOpen = false;
                     OwnWorldComparator.method1182(class31.menuX, WorldComparator.menuY, Player.field794, WallObject.field2000);
                  }
               }

               if(var1 == 1 || !middleMouseMovesCamera && var1 == 4) {
                  var2 = class31.menuX;
                  var3 = WorldComparator.menuY;
                  var4 = Player.field794;
                  var5 = MouseInput.mouseLastPressedX;
                  int var6 = MouseInput.mouseLastPressedY;
                  int var7 = -1;

                  for(int var8 = 0; var8 < menuOptionCount; ++var8) {
                     int var9 = (menuOptionCount - 1 - var8) * 15 + var3 + 31;
                     if(var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var7 = var8;
                     }
                  }

                  if(var7 != -1) {
                     Preferences.method1661(var7);
                  }

                  isMenuOpen = false;
                  OwnWorldComparator.method1182(class31.menuX, WorldComparator.menuY, Player.field794, WallObject.field2000);
               }
            } else {
               var2 = class34.method365();
               if((var1 == 1 || !middleMouseMovesCamera && var1 == 4) && var2 >= 0) {
                  var3 = menuTypes[var2];
                  if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                     var4 = menuActionParams0[var2];
                     var5 = menuActionParams1[var2];
                     Widget var10 = class35.getWidget(var5);
                     if(ItemLayer.method2565(class60.getWidgetConfig(var10)) || FileOnDisk.method2530(class60.getWidgetConfig(var10))) {
                        if(class37.field479 != null && !itemBeingDragged && menuOptionCount > 0 && !this.method1201()) {
                           ScriptEvent.method1082(field914, field1044);
                        }

                        itemBeingDragged = false;
                        itemPressedDuration = 0;
                        if(class37.field479 != null) {
                           class60.method1015(class37.field479);
                        }

                        class37.field479 = class35.getWidget(var5);
                        field1002 = var4;
                        field914 = MouseInput.mouseLastPressedX;
                        field1044 = MouseInput.mouseLastPressedY;
                        if(var2 >= 0) {
                           Widget.method4303(var2);
                        }

                        class60.method1015(class37.field479);
                        return;
                     }
                  }
               }

               if((var1 == 1 || !middleMouseMovesCamera && var1 == 4) && this.method1201()) {
                  var1 = 2;
               }

               if((var1 == 1 || !middleMouseMovesCamera && var1 == 4) && menuOptionCount > 0) {
                  Preferences.method1661(var2);
               }

               if(var1 == 2 && menuOptionCount > 0) {
                  this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
               }
            }

         }
      }
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2083927164"
   )
   final boolean method1201() {
      int var1 = class34.method365();
      if(menuOptionCount > 2) {
         if(field1049 == 1 && !menuBooleanArray[var1]) {
            return true;
         }

         boolean var2;
         if(var1 < 0) {
            var2 = false;
         } else {
            int var3 = menuTypes[var1];
            if(var3 >= 2000) {
               var3 -= 2000;
            }

            if(var3 == 1007) {
               var2 = true;
            } else {
               var2 = false;
            }
         }

         if(var2) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1039515318"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      int var3 = ContextMenuRow.fontBold12.getTextWidth("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = ContextMenuRow.fontBold12;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargets[var4].length() > 0) {
            var6 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var6 = menuOptions[var4];
         }

         int var7 = var5.getTextWidth(var6);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      int var8 = var1 - var3 / 2;
      if(var8 + var3 > WorldMapType1.canvasWidth) {
         var8 = WorldMapType1.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var4 + var2 > class263.canvasHeight) {
         var9 = class263.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      class48.region.method2946(MessageNode.plane, var1, var2, false);
      isMenuOpen = true;
      class31.menuX = var8;
      WorldComparator.menuY = var9;
      Player.field794 = var3;
      WallObject.field2000 = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "113177620"
   )
   final void method1203(boolean var1) {
      Preferences.method1657(widgetRoot, WorldMapType1.canvasWidth, class263.canvasHeight, var1);
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(Lho;B)V",
      garbageValue = "-24"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class35.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = WorldMapType1.canvasWidth;
         var4 = class263.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      ScriptVarType.method27(var1, var3, var4, false);
      class150.method3042(var1, var3, var4);
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "869463364"
   )
   final void method1205() {
      class60.method1015(field980);
      ++VarPlayerType.field3350;
      if(field988 && field985) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field982;
         var2 -= field983;
         if(var1 < field986) {
            var1 = field986;
         }

         if(var1 + field980.width > field986 + field981.width) {
            var1 = field986 + field981.width - field980.width;
         }

         if(var2 < field987) {
            var2 = field987;
         }

         if(var2 + field980.height > field987 + field981.height) {
            var2 = field987 + field981.height - field980.height;
         }

         int var3 = var1 - field989;
         int var4 = var2 - field990;
         int var5 = field980.field2814;
         if(VarPlayerType.field3350 > field980.field2802 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field991 = true;
         }

         int var6 = var1 - field986 + field981.scrollX;
         int var7 = var2 - field987 + field981.scrollY;
         ScriptEvent var8;
         if(field980.field2832 != null && field991) {
            var8 = new ScriptEvent();
            var8.widget = field980;
            var8.field748 = var6;
            var8.field746 = var7;
            var8.objs = field980.field2832;
            class87.method1851(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(field991) {
               if(field980.field2849 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field980;
                  var8.field748 = var6;
                  var8.field746 = var7;
                  var8.field752 = field858;
                  var8.objs = field980.field2849;
                  class87.method1851(var8);
               }

               if(field858 != null && BoundingBox3DDrawMode.method73(field980) != null) {
                  PacketNode var9 = class35.method501(ClientPacket.field2304, field867.field1439);
                  var9.packetBuffer.writeShortLE(field858.itemId);
                  var9.packetBuffer.writeIntLE16(field858.index);
                  var9.packetBuffer.method3387(field980.id);
                  var9.packetBuffer.method3401(field858.id);
                  var9.packetBuffer.writeIntLE16(field980.index);
                  var9.packetBuffer.writeShortLE(field980.itemId);
                  field867.method2021(var9);
               }
            } else if(this.method1201()) {
               this.openMenu(field989 + field982, field990 + field983);
            } else if(menuOptionCount > 0) {
               ScriptEvent.method1082(field982 + field989, field983 + field990);
            }

            field980 = null;
         }

      } else {
         if(VarPlayerType.field3350 > 1) {
            field980 = null;
         }

      }
   }

   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "(B)Ljr;",
      garbageValue = "-57"
   )
   public Name vmethod5106() {
      return class36.localPlayer != null?class36.localPlayer.name:null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)Lcd;",
      garbageValue = "277729321"
   )
   @Export("newScript")
   static Script newScript(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1989(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(RunException.nextPowerOfTwo(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "939671767"
   )
   public static int method1576(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfw;IIB)Ldo;",
      garbageValue = "108"
   )
   public static final AbstractSoundSystem method1465(Signlink var0, int var1, int var2) {
      if(class20.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = DecorativeObject.soundTaskDataProvider.taskData();
            var3.samples = new int[(BoundingBox3DDrawMode.highMemory?2:1) * 256];
            var3.field1531 = var2;
            var3.vmethod2190();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(AbstractSoundSystem.priority > 0 && class188.task == null) {
               class188.task = new SoundTask();
               GrandExchangeOffer.field295 = Executors.newScheduledThreadPool(1);
               GrandExchangeOffer.field295.scheduleAtFixedRate(class188.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class188.task != null) {
               if(class188.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class188.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
