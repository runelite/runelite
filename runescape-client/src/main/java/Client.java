import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -886301553
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 677847007
   )
   static int field1028;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      longValue = 1748203429629159065L
   )
   static long field1037;
   @ObfuscatedName("mw")
   static boolean[] field1029;
   @ObfuscatedName("ma")
   static boolean[] field1031;
   @ObfuscatedName("mf")
   static boolean[] field906;
   @ObfuscatedName("ms")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -451380079
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -1418495149
   )
   static int field1017;
   @ObfuscatedName("on")
   static boolean field1059;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = -1345650125
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("mu")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("mz")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("mq")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("me")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("mk")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("qz")
   static int[] field1095;
   @ObfuscatedName("qd")
   static int[] field1096;
   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "Lbd;"
   )
   static final class70 field1094;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 1408318763
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 1224828783
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -1370475725
   )
   static int field1021;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -1412293835
   )
   static int field878;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = -86467163
   )
   static int field902;
   @ObfuscatedName("mt")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   static Deque field1023;
   @ObfuscatedName("oa")
   static boolean field1068;
   @ObfuscatedName("lg")
   static int[] field1014;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -865843009
   )
   static int field996;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = 1560532075
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = -2107715343
   )
   static int field1041;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -130100069
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 1131336757
   )
   static int field850;
   @ObfuscatedName("pw")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static PlayerComposition field1087;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = -625513759
   )
   static int field1057;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = -852659125
   )
   static int field1049;
   @ObfuscatedName("pc")
   static boolean[] field1069;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 427088125
   )
   static int field1089;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 215590393
   )
   @Export("queuedSoundEffectCount")
   static int queuedSoundEffectCount;
   @ObfuscatedName("ol")
   @Export("queuedSoundEffectIDs")
   static int[] queuedSoundEffectIDs;
   @ObfuscatedName("ql")
   static ArrayList field1092;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      longValue = 5732911183052152605L
   )
   static long field1048;
   @ObfuscatedName("oz")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -839646251
   )
   static int field991;
   @ObfuscatedName("ov")
   @Export("unknownSoundValues2")
   static int[] unknownSoundValues2;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = 765322907
   )
   static int field1058;
   @ObfuscatedName("op")
   @ObfuscatedSignature(
      signature = "[Ldr;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("os")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 656470305
   )
   static int field1030;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -434591277
   )
   static int field978;
   @ObfuscatedName("lk")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = -1116683011
   )
   static int field1090;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = 563393451
   )
   static int field1050;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 1035078651
   )
   static int field1011;
   @ObfuscatedName("ny")
   @ObfuscatedSignature(
      signature = "[Lki;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("la")
   static int[] field1010;
   @ObfuscatedName("nh")
   static int[] field1034;
   @ObfuscatedName("nt")
   static int[] field1052;
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = 789084865
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -1149306675
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = 1921245593
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -1548823151
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("pr")
   static short field1075;
   @ObfuscatedName("pg")
   static short field1082;
   @ObfuscatedName("ph")
   static short field982;
   @ObfuscatedName("pq")
   static short field1081;
   @ObfuscatedName("pa")
   static short field938;
   @ObfuscatedName("pn")
   static short field962;
   @ObfuscatedName("pt")
   static short field1076;
   @ObfuscatedName("pl")
   static short field1078;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -424217967
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("na")
   static long[] field1043;
   @ObfuscatedName("pi")
   static int[] field932;
   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "[Lx;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1226347259
   )
   static int field1045;
   @ObfuscatedName("pu")
   static int[] field998;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -1090716279
   )
   static int field899;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 606311181
   )
   static int field1019;
   @ObfuscatedName("pv")
   static int[] field1073;
   @ObfuscatedName("px")
   static int[] field1072;
   @ObfuscatedName("nf")
   static int[] field966;
   @ObfuscatedName("nk")
   static int[] field1046;
   @ObfuscatedName("mr")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   static Deque field1024;
   @ObfuscatedName("mx")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   static Deque field1025;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 684815259
   )
   static int field1020;
   @ObfuscatedName("no")
   static String field1042;
   @ObfuscatedName("mp")
   static int[] field1039;
   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "Lbw;"
   )
   static OwnWorldComparator field1074;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -2016104199
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfb;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("ac")
   static boolean field985;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1703909705
   )
   @Export("world")
   public static int world;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1092322909
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1766416267
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bt")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bi")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -551024861
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bn")
   static String field846;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -402239797
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("bl")
   static boolean field848;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1885393463
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      longValue = 4425878618475249369L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 859285271
   )
   static int field851;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1447953821
   )
   static int field852;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 427606385
   )
   static int field853;
   @ObfuscatedName("bu")
   static boolean field961;
   @ObfuscatedName("be")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 528065549
   )
   static int field994;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -412335873
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -2096799933
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 431008901
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1055318679
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 95805067
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1741770531
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1898714363
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 368454681
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lcp;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 464474699
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 961280815
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -514813499
   )
   static int field1018;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      longValue = -6252704273460752313L
   )
   static long field870;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 1394006317
   )
   static int field872;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -1935545703
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 2075793109
   )
   static int field874;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -1542080077
   )
   static int field875;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 1742077677
   )
   static int field876;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   static class148 field877;
   @ObfuscatedName("dp")
   static byte[] field1006;
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "[Lcd;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 2102069863
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("du")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 1130967957
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("es")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   public static final NetWriter field937;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 42539873
   )
   static int field943;
   @ObfuscatedName("ec")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("eq")
   static boolean field1054;
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   static class299 field888;
   @ObfuscatedName("en")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -892158935
   )
   static int field890;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 1925941631
   )
   static int field891;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 932096201
   )
   static int field892;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1871658147
   )
   static int field893;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = -750692635
   )
   static int field894;
   @ObfuscatedName("ff")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("fo")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fu")
   static int[][][] field897;
   @ObfuscatedName("fg")
   static final int[] field898;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -808343339
   )
   static int field1091;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "[Lki;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1514227067
   )
   static int field901;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 318846065
   )
   static int field905;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -1130631185
   )
   static int field931;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 290138751
   )
   static int field904;
   @ObfuscatedName("gy")
   static boolean field927;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -701650367
   )
   static int field1093;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1246437523
   )
   static int field907;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 1665038121
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -1872109915
   )
   static int field909;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -236336523
   )
   static int field910;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 2089546735
   )
   static int field911;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -209290061
   )
   static int field912;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 726395883
   )
   static int field1061;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -1530782261
   )
   static int field914;
   @ObfuscatedName("gs")
   static boolean field1044;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 747823165
   )
   static int field916;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1405529667
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1996527605
   )
   @Export("maxOverheadTexts")
   static int maxOverheadTexts;
   @ObfuscatedName("gv")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("gu")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("gr")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("he")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("hq")
   static int[] field1080;
   @ObfuscatedName("hp")
   static int[] field924;
   @ObfuscatedName("hb")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("hk")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("ht")
   static int[][] field1027;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -559551869
   )
   static int field928;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -49220437
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -1312726953
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 1771718745
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 602033929
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -575147169
   )
   static int field933;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 407645669
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -974740693
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 2060933701
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 169074513
   )
   static int field987;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 1265239177
   )
   static int field993;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 180020481
   )
   static int field939;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 375627783
   )
   static int field896;
   @ObfuscatedName("hj")
   @Export("itemBeingDragged")
   static boolean itemBeingDragged;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -1107284271
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = -1380506021
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "[Lby;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 1057401631
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = 631444271
   )
   static int field946;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 1419319059
   )
   static int field947;
   @ObfuscatedName("ik")
   static int[] field948;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("ih")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("ir")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("ij")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("id")
   static int[] field952;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1827830525
   )
   static int field953;
   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "[[[Lgw;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("iq")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("iv")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("il")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -1774278635
   )
   static int field855;
   @ObfuscatedName("iu")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 496720941
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("ju")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jc")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jo")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("jv")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jm")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("je")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jn")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("jq")
   static boolean field1013;
   @ObfuscatedName("jj")
   static boolean field972;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 1080348499
   )
   static int field973;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 1908820353
   )
   static int field974;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -670372661
   )
   static int field975;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 1648476181
   )
   static int field976;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -975307001
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("js")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 1563402749
   )
   static int field1038;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -1338244445
   )
   static int field1060;
   @ObfuscatedName("ko")
   static String field854;
   @ObfuscatedName("kn")
   static String field995;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -614269905
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -1175899419
   )
   static int field986;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 1916134811
   )
   static int field1065;
   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field885;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = 1503258615
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 1654851417
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -729588203
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 398010287
   )
   static int field992;
   @ObfuscatedName("kl")
   static boolean field857;
   @ObfuscatedName("kk")
   static boolean field1098;
   @ObfuscatedName("ku")
   @Export("numberMenuOptions")
   static boolean numberMenuOptions;
   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field1003;
   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field940;
   @ObfuscatedName("kd")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field930;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = 443333025
   )
   static int field999;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 1223278207
   )
   static int field921;
   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field1001;
   @ObfuscatedName("kz")
   static boolean field1002;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -653739431
   )
   static int field856;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 1010234539
   )
   static int field1070;
   @ObfuscatedName("ld")
   static boolean field980;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = -1771871883
   )
   static int field919;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -641282321
   )
   static int field1007;
   @ObfuscatedName("lp")
   static boolean field1008;

   static {
      field985 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field848 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = 1L;
      field851 = -1;
      field852 = -1;
      field853 = -1;
      field961 = true;
      displayFps = false;
      field994 = 0;
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
      field1018 = 0;
      field872 = 0;
      loginState = 0;
      field874 = 0;
      field875 = 0;
      field876 = 0;
      field877 = class148.field2086;
      field1006 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field937 = new NetWriter();
      field943 = 0;
      socketError = false;
      field1054 = true;
      field888 = new class299();
      fontsMap = new HashMap();
      field890 = 0;
      field891 = 1;
      field892 = 0;
      field893 = 1;
      field894 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field897 = new int[4][13][13];
      field898 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1091 = 0;
      field901 = 2301979;
      field905 = 5063219;
      field931 = 3353893;
      field904 = 7759444;
      field927 = false;
      field1093 = 0;
      field907 = 128;
      mapAngle = 0;
      field909 = 0;
      field910 = 0;
      field911 = 0;
      field912 = 0;
      field1061 = 50;
      field914 = 0;
      field1044 = false;
      field916 = 0;
      overheadTextCount = 0;
      maxOverheadTexts = 50;
      overheadTextsX = new int[maxOverheadTexts];
      overheadTextsY = new int[maxOverheadTexts];
      overheadTextsOffsetY = new int[maxOverheadTexts];
      overheadTextsOffsetX = new int[maxOverheadTexts];
      field1080 = new int[maxOverheadTexts];
      field924 = new int[maxOverheadTexts];
      overheadTextsCyclesRemaining = new int[maxOverheadTexts];
      overheadTexts = new String[maxOverheadTexts];
      field1027 = new int[104][104];
      field928 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field933 = 0;
      cursorState = 0;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field987 = 0;
      field993 = 0;
      field939 = 0;
      field896 = 0;
      itemBeingDragged = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field946 = 0;
      field947 = 0;
      field948 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field952 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field953 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field855 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field1013 = false;
      field972 = false;
      field973 = -1;
      field974 = -1;
      field975 = 0;
      field976 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field1038 = -1;
      field1060 = -1;
      field854 = null;
      field995 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field986 = 0;
      field1065 = 0;
      field885 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field992 = -1;
      field857 = false;
      field1098 = false;
      numberMenuOptions = false;
      field1003 = null;
      field940 = null;
      field930 = null;
      field999 = 0;
      field921 = 0;
      field1001 = null;
      field1002 = false;
      field856 = -1;
      field1070 = -1;
      field980 = false;
      field919 = -1;
      field1007 = -1;
      field1008 = false;
      cycleCntr = 1;
      field1010 = new int[32];
      field1011 = 0;
      interfaceItemTriggers = new int[32];
      field1090 = 0;
      field1014 = new int[32];
      field996 = 0;
      chatCycle = 0;
      field1017 = 0;
      field1030 = 0;
      field1019 = 0;
      field1020 = 0;
      field1021 = 0;
      mouseWheelRotation = 0;
      field1023 = new Deque();
      field1024 = new Deque();
      field1025 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field1028 = -2;
      field1029 = new boolean[100];
      field906 = new boolean[100];
      field1031 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1037 = 0L;
      isResized = true;
      field1039 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field1041 = 0;
      field1042 = "";
      field1043 = new long[100];
      field899 = 0;
      field1045 = 0;
      field1046 = new int[128];
      field966 = new int[128];
      field1048 = -1L;
      field1049 = -1;
      field1050 = 0;
      field1034 = new int[1000];
      field1052 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field978 = 0;
      field1057 = 255;
      field902 = -1;
      field1059 = false;
      field1058 = 127;
      field878 = 127;
      queuedSoundEffectCount = 0;
      queuedSoundEffectIDs = new int[50];
      unknownSoundValues1 = new int[50];
      unknownSoundValues2 = new int[50];
      soundLocations = new int[50];
      audioEffects = new SoundEffect[50];
      field1068 = false;
      field1069 = new boolean[5];
      field998 = new int[5];
      field932 = new int[5];
      field1072 = new int[5];
      field1073 = new int[5];
      field1082 = 256;
      field1075 = 205;
      field1076 = 256;
      field962 = 320;
      field1078 = 1;
      field938 = 32767;
      field982 = 1;
      field1081 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      scale = 0;
      field1087 = new PlayerComposition();
      field850 = -1;
      field1089 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1074 = new OwnWorldComparator();
      field1092 = new ArrayList(10);
      field991 = 0;
      field1094 = new class70();
      field1095 = new int[50];
      field1096 = new int[50];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   protected final void vmethod1446() {
      field1037 = SceneTilePaint.currentTimeMs() + 500L;
      this.method1190();
      if(widgetRoot != -1) {
         this.method1196(true);
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1602825637"
   )
   @Export("setUp")
   protected final void setUp() {
      class168.method3399(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      WorldMapType2.port1 = socketType == 0?43594:world + 40000;
      FaceNormal.port2 = socketType == 0?443:world + 50000;
      class43.myWorldPort = WorldMapType2.port1;
      PlayerComposition.colorsToFind = class225.field2735;
      BoundingBox.colorsToReplace = class225.field2732;
      class33.field449 = class225.field2737;
      PlayerComposition.field2728 = class225.field2734;
      NPC.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      class33.mouseWheel = this.mouseWheel();
      Tile.indexStore255 = new IndexFile(255, class157.dat2File, class157.idx255File, 500000);
      WorldComparator.preferences = KeyFocusListener.method731();
      this.setUpClipboard();
      String var2 = class84.field1273;
      class56.field639 = this;
      if(var2 != null) {
         class56.field638 = var2;
      }

      if(socketType != 0) {
         displayFps = true;
      }

      class283.method5349(WorldComparator.preferences.screenType);
      class35.friendManager = new FriendManager(class226.loginType);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "74"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      class186.method3766();
      class186.method3768();
      class186.method3767();
      KeyFocusListener var1 = KeyFocusListener.keyboard;
      int var2;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field622 = KeyFocusListener.field618;
         KeyFocusListener.field607 = 0;
         if(KeyFocusListener.field614 >= 0) {
            while(KeyFocusListener.field614 != KeyFocusListener.field610) {
               var2 = KeyFocusListener.field609[KeyFocusListener.field610];
               KeyFocusListener.field610 = KeyFocusListener.field610 + 1 & 127;
               if(var2 < 0) {
                  KeyFocusListener.keyPressed[~var2] = false;
               } else {
                  if(!KeyFocusListener.keyPressed[var2] && KeyFocusListener.field607 < KeyFocusListener.field615.length - 1) {
                     KeyFocusListener.field615[++KeyFocusListener.field607 - 1] = var2;
                  }

                  KeyFocusListener.keyPressed[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               KeyFocusListener.keyPressed[var2] = false;
            }

            KeyFocusListener.field614 = KeyFocusListener.field610;
         }

         if(KeyFocusListener.field607 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field618 = KeyFocusListener.field591;
      }

      MouseInput var52 = MouseInput.mouse;
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

      int var39;
      if(class33.mouseWheel != null) {
         var39 = class33.mouseWheel.useRotation();
         mouseWheelRotation = var39;
      }

      if(gameState == 0) {
         class293.load();
         WorldMapType2.timer.vmethod3287();

         for(var39 = 0; var39 < 32; ++var39) {
            GameEngine.field675[var39] = 0L;
         }

         for(var39 = 0; var39 < 32; ++var39) {
            GameEngine.field676[var39] = 0L;
         }

         GameEngine.field652 = 0;
      } else if(gameState == 5) {
         ClientPacket.method3405(this);
         class293.load();
         WorldMapType2.timer.vmethod3287();

         for(var39 = 0; var39 < 32; ++var39) {
            GameEngine.field675[var39] = 0L;
         }

         for(var39 = 0; var39 < 32; ++var39) {
            GameEngine.field676[var39] = 0L;
         }

         GameEngine.field652 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            ClientPacket.method3405(this);
            this.method1187();
         } else if(gameState == 25) {
            class237.flush(false);
            field890 = 0;
            boolean var60 = true;

            for(var2 = 0; var2 < class2.field13.length; ++var2) {
               if(class47.landMapFileIds[var2] != -1 && class2.field13[var2] == null) {
                  class2.field13[var2] = indexMaps.getConfigData(class47.landMapFileIds[var2], 0);
                  if(class2.field13[var2] == null) {
                     var60 = false;
                     ++field890;
                  }
               }

               if(class84.landRegionFileIds[var2] != -1 && class46.field571[var2] == null) {
                  class46.field571[var2] = indexMaps.getConfigDataKeys(class84.landRegionFileIds[var2], 0, xteaKeys[var2]);
                  if(class46.field571[var2] == null) {
                     var60 = false;
                     ++field890;
                  }
               }
            }

            if(!var60) {
               field894 = 1;
            } else {
               field892 = 0;
               var60 = true;

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
               int var40;
               for(var2 = 0; var2 < class2.field13.length; ++var2) {
                  byte[] var3 = class46.field571[var2];
                  if(var3 != null) {
                     var40 = (Item.mapRegions[var2] >> 8) * 64 - ClanMemberManager.baseX;
                     var5 = (Item.mapRegions[var2] & 255) * 64 - WorldMapData.baseY;
                     if(isDynamicRegion) {
                        var40 = 10;
                        var5 = 10;
                     }

                     boolean var8 = true;
                     var9 = new Buffer(var3);
                     var10 = -1;

                     label711:
                     while(true) {
                        var11 = var9.getUSmart();
                        if(var11 == 0) {
                           var60 &= var8;
                           break;
                        }

                        var10 += var11;
                        var12 = 0;
                        boolean var13 = false;

                        while(true) {
                           while(!var13) {
                              var14 = var9.getUSmart();
                              if(var14 == 0) {
                                 continue label711;
                              }

                              var12 += var14 - 1;
                              var15 = var12 & 63;
                              var16 = var12 >> 6 & 63;
                              var17 = var9.readUnsignedByte() >> 2;
                              var18 = var16 + var40;
                              var19 = var15 + var5;
                              if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                 ObjectComposition var20 = class219.getObjectDefinition(var10);
                                 if(var17 != 22 || !lowMemory || var20.int1 != 0 || var20.clipType == 1 || var20.obstructsGround) {
                                    if(!var20.method4920()) {
                                       ++field892;
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

               if(!var60) {
                  field894 = 2;
               } else {
                  if(field894 != 0) {
                     BoundingBox2D.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class186.method3767();
                  ObjectComposition.method4931();
                  class186.method3767();
                  TotalQuantityComparator.region.reset();
                  class186.method3767();
                  System.gc();

                  for(var2 = 0; var2 < 4; ++var2) {
                     collisionMaps[var2].reset();
                  }

                  int var41;
                  for(var2 = 0; var2 < 4; ++var2) {
                     for(var41 = 0; var41 < 104; ++var41) {
                        for(var40 = 0; var40 < 104; ++var40) {
                           class62.tileSettings[var2][var41][var40] = 0;
                        }
                     }
                  }

                  class186.method3767();
                  class263.method4867();
                  var2 = class2.field13.length;

                  for(class79 var53 = (class79)class79.field1233.getFront(); var53 != null; var53 = (class79)class79.field1233.getNext()) {
                     if(var53.field1231 != null) {
                        class33.field450.method2117(var53.field1231);
                        var53.field1231 = null;
                     }

                     if(var53.field1220 != null) {
                        class33.field450.method2117(var53.field1220);
                        var53.field1220 = null;
                     }
                  }

                  class79.field1233.clear();
                  class237.flush(true);
                  int var6;
                  int var21;
                  int var22;
                  int var45;
                  int var58;
                  if(!isDynamicRegion) {
                     byte[] var42;
                     for(var41 = 0; var41 < var2; ++var41) {
                        var40 = (Item.mapRegions[var41] >> 8) * 64 - ClanMemberManager.baseX;
                        var5 = (Item.mapRegions[var41] & 255) * 64 - WorldMapData.baseY;
                        var42 = class2.field13[var41];
                        if(var42 != null) {
                           class186.method3767();
                           class131.method2810(var42, var40, var5, MessageNode.field798 * 8 - 48, ChatLineBuffer.field1440 * 8 - 48, collisionMaps);
                        }
                     }

                     for(var41 = 0; var41 < var2; ++var41) {
                        var40 = (Item.mapRegions[var41] >> 8) * 64 - ClanMemberManager.baseX;
                        var5 = (Item.mapRegions[var41] & 255) * 64 - WorldMapData.baseY;
                        var42 = class2.field13[var41];
                        if(var42 == null && ChatLineBuffer.field1440 < 800) {
                           class186.method3767();
                           class43.method592(var40, var5, 64, 64);
                        }
                     }

                     class237.flush(true);

                     for(var41 = 0; var41 < var2; ++var41) {
                        byte[] var4 = class46.field571[var41];
                        if(var4 != null) {
                           var5 = (Item.mapRegions[var41] >> 8) * 64 - ClanMemberManager.baseX;
                           var6 = (Item.mapRegions[var41] & 255) * 64 - WorldMapData.baseY;
                           class186.method3767();
                           Region var43 = TotalQuantityComparator.region;
                           CollisionData[] var44 = collisionMaps;
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
                                 var58 = var9.getUSmart();
                                 if(var58 == 0) {
                                    break;
                                 }

                                 var12 += var58 - 1;
                                 var14 = var12 & 63;
                                 var15 = var12 >> 6 & 63;
                                 var16 = var12 >> 12;
                                 var17 = var9.readUnsignedByte();
                                 var18 = var17 >> 2;
                                 var19 = var17 & 3;
                                 var45 = var5 + var15;
                                 var21 = var14 + var6;
                                 if(var45 > 0 && var21 > 0 && var45 < 103 && var21 < 103) {
                                    var22 = var16;
                                    if((class62.tileSettings[1][var45][var21] & 2) == 2) {
                                       var22 = var16 - 1;
                                    }

                                    CollisionData var23 = null;
                                    if(var22 >= 0) {
                                       var23 = var44[var22];
                                    }

                                    Player.addObject(var16, var45, var21, var10, var19, var18, var43, var23);
                                 }
                              }
                           }
                        }
                     }
                  }

                  int var7;
                  int var46;
                  int var57;
                  if(isDynamicRegion) {
                     var41 = 0;

                     label610:
                     while(true) {
                        if(var41 >= 4) {
                           for(var41 = 0; var41 < 13; ++var41) {
                              for(var40 = 0; var40 < 13; ++var40) {
                                 var5 = field897[0][var41][var40];
                                 if(var5 == -1) {
                                    class43.method592(var41 * 8, var40 * 8, 8, 8);
                                 }
                              }
                           }

                           class237.flush(true);
                           var41 = 0;

                           while(true) {
                              if(var41 >= 4) {
                                 break label610;
                              }

                              class186.method3767();

                              for(var40 = 0; var40 < 13; ++var40) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var6 = field897[var41][var40][var5];
                                    if(var6 != -1) {
                                       var7 = var6 >> 24 & 3;
                                       var57 = var6 >> 1 & 3;
                                       var46 = var6 >> 14 & 1023;
                                       var10 = var6 >> 3 & 2047;
                                       var11 = (var46 / 8 << 8) + var10 / 8;

                                       for(var12 = 0; var12 < Item.mapRegions.length; ++var12) {
                                          if(Item.mapRegions[var12] == var11 && class46.field571[var12] != null) {
                                             class192.method3867(class46.field571[var12], var41, var40 * 8, var5 * 8, var7, (var46 & 7) * 8, (var10 & 7) * 8, var57, TotalQuantityComparator.region, collisionMaps);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var41;
                           }
                        }

                        class186.method3767();

                        for(var40 = 0; var40 < 13; ++var40) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var56 = false;
                              var7 = field897[var41][var40][var5];
                              if(var7 != -1) {
                                 var57 = var7 >> 24 & 3;
                                 var46 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(var58 = 0; var58 < Item.mapRegions.length; ++var58) {
                                    if(Item.mapRegions[var58] == var12 && class2.field13[var58] != null) {
                                       byte[] var47 = class2.field13[var58];
                                       var15 = var40 * 8;
                                       var16 = var5 * 8;
                                       var17 = (var10 & 7) * 8;
                                       var18 = (var11 & 7) * 8;
                                       CollisionData[] var48 = collisionMaps;

                                       for(var45 = 0; var45 < 8; ++var45) {
                                          for(var21 = 0; var21 < 8; ++var21) {
                                             if(var45 + var15 > 0 && var15 + var45 < 103 && var21 + var16 > 0 && var16 + var21 < 103) {
                                                var48[var41].flags[var15 + var45][var16 + var21] &= -16777217;
                                             }
                                          }
                                       }

                                       Buffer var59 = new Buffer(var47);

                                       for(var21 = 0; var21 < 4; ++var21) {
                                          for(var22 = 0; var22 < 64; ++var22) {
                                             for(int var49 = 0; var49 < 64; ++var49) {
                                                if(var21 == var57 && var22 >= var17 && var22 < var17 + 8 && var49 >= var18 && var49 < var18 + 8) {
                                                   int var28 = var22 & 7;
                                                   int var29 = var49 & 7;
                                                   int var30 = var46 & 3;
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

                                                   int var33 = var27 + var15;
                                                   int var36 = var22 & 7;
                                                   int var37 = var49 & 7;
                                                   int var38 = var46 & 3;
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

                                                   SceneTilePaint.loadTerrain(var59, var41, var33, var16 + var35, 0, 0, var46);
                                                } else {
                                                   SceneTilePaint.loadTerrain(var59, 0, -1, -1, 0, 0, 0);
                                                }
                                             }
                                          }
                                       }

                                       var56 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var56) {
                                 class34.method483(var41, var40 * 8, var5 * 8);
                              }
                           }
                        }

                        ++var41;
                     }
                  }

                  class237.flush(true);
                  ObjectComposition.method4931();
                  class186.method3767();
                  GrandExchangeOffer.method119(TotalQuantityComparator.region, collisionMaps);
                  class237.flush(true);
                  var41 = class62.field736;
                  if(var41 > class60.plane) {
                     var41 = class60.plane;
                  }

                  if(var41 < class60.plane - 1) {
                     var41 = class60.plane - 1;
                  }

                  if(lowMemory) {
                     TotalQuantityComparator.region.setup(class62.field736);
                  } else {
                     TotalQuantityComparator.region.setup(0);
                  }

                  for(var40 = 0; var40 < 104; ++var40) {
                     for(var5 = 0; var5 < 104; ++var5) {
                        TotalQuantityComparator.groundItemSpawned(var40, var5);
                     }
                  }

                  class186.method3767();

                  for(PendingSpawn var54 = (PendingSpawn)pendingSpawns.getFront(); var54 != null; var54 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var54.hitpoints == -1) {
                        var54.delay = 0;
                        method1589(var54);
                     } else {
                        var54.unlink();
                     }
                  }

                  ObjectComposition.field3520.reset();
                  PacketNode var55;
                  if(class175.clientInstance.method839()) {
                     var55 = Script.method2025(ClientPacket.field2366, field937.field1454);
                     var55.packetBuffer.putInt(1057001181);
                     field937.method2044(var55);
                  }

                  if(!isDynamicRegion) {
                     var40 = (MessageNode.field798 - 6) / 8;
                     var5 = (MessageNode.field798 + 6) / 8;
                     var6 = (ChatLineBuffer.field1440 - 6) / 8;
                     var7 = (ChatLineBuffer.field1440 + 6) / 8;

                     for(var57 = var40 - 1; var57 <= var5 + 1; ++var57) {
                        for(var46 = var6 - 1; var46 <= var7 + 1; ++var46) {
                           if(var57 < var40 || var57 > var5 || var46 < var6 || var46 > var7) {
                              indexMaps.method4580("m" + var57 + "_" + var46);
                              indexMaps.method4580("l" + var57 + "_" + var46);
                           }
                        }
                     }
                  }

                  class87.setGameState(30);
                  class186.method3767();
                  class65.method1058();
                  var55 = Script.method2025(ClientPacket.field2409, field937.field1454);
                  field937.method2044(var55);
                  WorldMapType2.timer.vmethod3287();

                  for(var5 = 0; var5 < 32; ++var5) {
                     GameEngine.field675[var5] = 0L;
                  }

                  for(var5 = 0; var5 < 32; ++var5) {
                     GameEngine.field676[var5] = 0L;
                  }

                  GameEngine.field652 = 0;
               }
            }
         }
      } else {
         ClientPacket.method3405(this);
      }

      if(gameState == 30) {
         this.method1381();
      } else if(gameState == 40 || gameState == 45) {
         this.method1187();
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2126801819"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2;
      label173: {
         try {
            if(class214.field2617 == 2) {
               if(class56.field637 == null) {
                  class56.field637 = Track1.getMusicFile(class214.field2614, class293.field3798, class23.field342);
                  if(class56.field637 == null) {
                     var2 = false;
                     break label173;
                  }
               }

               if(class168.field2232 == null) {
                  class168.field2232 = new class111(class214.field2619, class214.field2615);
               }

               if(class25.field356.method4135(class56.field637, class214.field2618, class168.field2232, 22050)) {
                  class25.field356.method4184();
                  class25.field356.method4133(IndexFile.field2192);
                  class25.field356.method4138(class56.field637, class33.field446);
                  class214.field2617 = 0;
                  class56.field637 = null;
                  class168.field2232 = null;
                  class214.field2614 = null;
                  var2 = true;
                  break label173;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class25.field356.method4139();
            class214.field2617 = 0;
            class56.field637 = null;
            class168.field2232 = null;
            class214.field2614 = null;
         }

         var2 = false;
      }

      if(var2 && field1059 && BoundingBox.soundSystem0 != null) {
         BoundingBox.soundSystem0.tryFlush();
      }

      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1037 && SceneTilePaint.currentTimeMs() > field1037) {
         class283.method5349(BoundingBox.method40());
      }

      int var4;
      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1029[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class89.loadingBarPercentage, class89.loadingText, var1);
      } else if(gameState == 5) {
         JagexGame.drawLoginScreen(IndexDataBase.fontBold12, class2.fontPlain11, TextureProvider.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            JagexGame.drawLoginScreen(IndexDataBase.fontBold12, class2.fontPlain11, TextureProvider.font_p12full, var1);
         } else if(gameState == 25) {
            if(field894 == 1) {
               if(field890 > field891) {
                  field891 = field890;
               }

               var4 = (field891 * 50 - field890 * 50) / field891;
               BoundingBox2D.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field894 == 2) {
               if(field892 > field893) {
                  field893 = field892;
               }

               var4 = (field893 * 50 - field892 * 50) / field893 + 50;
               BoundingBox2D.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               BoundingBox2D.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1191();
         } else if(gameState == 40) {
            BoundingBox2D.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            BoundingBox2D.drawStatusBox("Please wait...", false);
         }
      } else {
         JagexGame.drawLoginScreen(IndexDataBase.fontBold12, class2.fontPlain11, TextureProvider.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < widgetCount; ++var4) {
            if(field906[var4]) {
               class22.rasterProvider.draw(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field906[var4] = false;
            }
         }
      } else if(gameState > 0) {
         class22.rasterProvider.drawFull(0, 0);

         for(var4 = 0; var4 < widgetCount; ++var4) {
            field906[var4] = false;
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   protected final void vmethod1183() {
      if(class34.chatMessages.changed()) {
         class34.chatMessages.serialize();
      }

      if(class41.mouseRecorder != null) {
         class41.mouseRecorder.isRunning = false;
      }

      class41.mouseRecorder = null;
      field937.close();
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var1 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

      class47.method678();
      class33.mouseWheel = null;
      if(BoundingBox.soundSystem0 != null) {
         BoundingBox.soundSystem0.shutdown();
      }

      if(Enum.soundSystem1 != null) {
         Enum.soundSystem1.shutdown();
      }

      SceneTilePaint.method2898();
      GrandExchangeOffer.method105();
      if(NPC.urlRequester != null) {
         NPC.urlRequester.close();
         NPC.urlRequester = null;
      }

      class218.method4298();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-395723204"
   )
   protected final void vmethod1177() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = class62.method1033();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Parameters var3 = var1[var2];
            String var4 = this.getParameter(var3.key);
            if(var4 != null) {
               switch(Integer.parseInt(var3.key)) {
               case 1:
                  flags = Integer.parseInt(var4);
               case 2:
               case 3:
               default:
                  break;
               case 4:
                  IndexFile.sessionToken = var4;
                  break;
               case 5:
                  languageId = Integer.parseInt(var4);
                  break;
               case 6:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 7:
                  JagexGame[] var5 = new JagexGame[]{JagexGame.field3282, JagexGame.field3289, JagexGame.field3283, JagexGame.field3287, JagexGame.field3288, JagexGame.field3284};
                  AbstractSoundSystem.field1553 = (JagexGame)Projectile.forOrdinal(var5, Integer.parseInt(var4));
                  if(JagexGame.field3282 == AbstractSoundSystem.field1553) {
                     class226.loginType = JagexLoginType.field3966;
                  } else {
                     class226.loginType = JagexLoginType.field3974;
                  }
                  break;
               case 8:
                  class5.field30 = Integer.parseInt(var4);
                  break;
               case 9:
                  world = Integer.parseInt(var4);
                  break;
               case 10:
                  class265.field3502 = Integer.parseInt(var4);
                  break;
               case 11:
                  socketType = Integer.parseInt(var4);
                  break;
               case 12:
                  field1054 = Integer.parseInt(var4) != 0;
                  break;
               case 13:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 14:
                  class60.field706 = class43.method601(Integer.parseInt(var4));
                  break;
               case 15:
                  field846 = var4;
               }
            }
         }

         WorldMapData.method338();
         RunException.host = this.getCodeBase().getHost();
         String var7 = class60.field706.identifier;
         byte var8 = 0;

         try {
            class181.method3478("oldschool", var7, var8, 17);
         } catch (Exception var6) {
            GrandExchangeEvent.method78((String)null, var6);
         }

         class175.clientInstance = this;
         this.initialize(765, 503, 163);
      }
   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-28824"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = class137.method3102();
         if(!var1) {
            this.method1287();
         }

      }
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "56"
   )
   void method1287() {
      if(class249.field3354 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class249.field3355 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field1018 = 3000;
            class249.field3355 = 3;
         }

         if(--field1018 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class92.socket = GameEngine.taskManager.createSocket(RunException.host, class43.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class92.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class92.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field1054) {
                     Socket var2 = (Socket)class92.socket.value;
                     class161 var1 = new class161(var2, 40000, 5000);
                     Coordinates.rssocket = var1;
                  } else {
                     Coordinates.rssocket = new class163((Socket)class92.socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var11 = new Buffer(5);
                  var11.putByte(15);
                  var11.putInt(163);
                  Coordinates.rssocket.vmethod3304(var11.payload, 0, 5);
                  ++js5State;
                  field870 = SceneTilePaint.currentTimeMs();
               }

               if(js5State == 3) {
                  if(Coordinates.rssocket.vmethod3300() > 0 || !field1054 && gameState <= 5) {
                     int var5 = Coordinates.rssocket.vmethod3301();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  } else if(SceneTilePaint.currentTimeMs() - field870 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  class159 var12 = Coordinates.rssocket;
                  boolean var6 = gameState > 20;
                  if(class19.NetCache_socket != null) {
                     try {
                        class19.NetCache_socket.vmethod3299();
                     } catch (Exception var9) {
                        ;
                     }

                     class19.NetCache_socket = null;
                  }

                  class19.NetCache_socket = var12;
                  Timer.sendConInfo(var6);
                  class249.NetCache_responseHeaderBuffer.offset = 0;
                  VertexNormal.currentRequest = null;
                  class249.NetCache_responseArchiveBuffer = null;
                  class249.field3338 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class249.NetCache_pendingPriorityResponses.first();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class249.NetCache_pendingResponses.first();
                           if(var3 == null) {
                              if(class249.field3353 != 0) {
                                 try {
                                    Buffer var13 = new Buffer(4);
                                    var13.putByte(4);
                                    var13.putByte(class249.field3353);
                                    var13.putShort(0);
                                    class19.NetCache_socket.vmethod3304(var13.payload, 0, 4);
                                 } catch (IOException var8) {
                                    try {
                                       class19.NetCache_socket.vmethod3299();
                                    } catch (Exception var7) {
                                       ;
                                    }

                                    ++class249.field3355;
                                    class19.NetCache_socket = null;
                                 }
                              }

                              class249.field3342 = 0;
                              class249.field3337 = SceneTilePaint.currentTimeMs();
                              class92.socket = null;
                              Coordinates.rssocket = null;
                              js5State = 0;
                              field872 = 0;
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

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1135324903"
   )
   @Export("error")
   void error(int var1) {
      class92.socket = null;
      Coordinates.rssocket = null;
      js5State = 0;
      if(WorldMapType2.port1 == class43.myWorldPort) {
         class43.myWorldPort = FaceNormal.port2;
      } else {
         class43.myWorldPort = WorldMapType2.port1;
      }

      ++field872;
      if(field872 < 2 || var1 != 7 && var1 != 9) {
         if(field872 >= 2 && var1 == 6) {
            this.error("js5connect_outofdate");
            gameState = 1000;
         } else if(field872 >= 4) {
            if(gameState <= 5) {
               this.error("js5connect");
               gameState = 1000;
            } else {
               field1018 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.error("js5connect_full");
         gameState = 1000;
      } else {
         field1018 = 3000;
      }

   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1424853330"
   )
   final void method1187() {
      Object var1 = field937.getSocket();
      PacketBuffer var2 = field937.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class159)var1).vmethod3299();
               var1 = null;
            }

            class34.field454 = null;
            socketError = false;
            field874 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class34.field454 == null) {
               class34.field454 = GameEngine.taskManager.createSocket(RunException.host, class43.myWorldPort);
            }

            if(class34.field454.status == 2) {
               throw new IOException();
            }

            if(class34.field454.status == 1) {
               if(field1054) {
                  Socket var4 = (Socket)class34.field454.value;
                  class161 var3 = new class161(var4, 40000, 5000);
                  var1 = var3;
               } else {
                  var1 = new class163((Socket)class34.field454.value, GameEngine.taskManager, 5000);
               }

               field937.setSocket((class159)var1);
               class34.field454 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field937.method2041();
            PacketNode var29;
            if(PacketNode.field2441 == 0) {
               var29 = new PacketNode();
            } else {
               var29 = PacketNode.packetBufferNodes[--PacketNode.field2441];
            }

            var29.clientPacket = null;
            var29.field2442 = 0;
            var29.packetBuffer = new PacketBuffer(5000);
            var29.packetBuffer.putByte(LoginPacket.field2422.id);
            field937.method2044(var29);
            field937.method2043();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var14;
         int var15;
         if(loginState == 3) {
            if(BoundingBox.soundSystem0 != null) {
               BoundingBox.soundSystem0.method2263();
            }

            if(Enum.soundSystem1 != null) {
               Enum.soundSystem1.method2263();
            }

            var14 = true;
            if(field1054 && !((class159)var1).vmethod3297(1)) {
               var14 = false;
            }

            if(var14) {
               var15 = ((class159)var1).vmethod3301();
               if(BoundingBox.soundSystem0 != null) {
                  BoundingBox.soundSystem0.method2263();
               }

               if(Enum.soundSystem1 != null) {
                  Enum.soundSystem1.method2263();
               }

               if(var15 != 0) {
                  class29.method242(var15);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var37;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var37 = ((class159)var1).vmethod3300();
               if(var37 > 8 - var2.offset) {
                  var37 = 8 - var2.offset;
               }

               if(var37 > 0) {
                  ((class159)var1).vmethod3302(var2.payload, var2.offset, var37);
                  var2.offset += var37;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               class18.field310 = var2.readLong();
               loginState = 5;
            }
         }

         int var7;
         int var9;
         int var17;
         if(loginState == 5) {
            field937.packetBuffer.offset = 0;
            field937.method2041();
            PacketBuffer var27 = new PacketBuffer(500);
            int[] var30 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class18.field310 >> 32), (int)(class18.field310 & -1L)};
            var27.offset = 0;
            var27.putByte(1);
            var27.putByte(field877.rsOrdinal());
            var27.putInt(var30[0]);
            var27.putInt(var30[1]);
            var27.putInt(var30[2]);
            var27.putInt(var30[3]);
            int var11;
            switch(field877.field2082) {
            case 0:
            case 2:
               var27.put24bitInt(MouseInput.field687);
               var27.offset += 5;
               break;
            case 1:
               LinkedHashMap var6 = WorldComparator.preferences.preferences;
               String var8 = class89.username;
               var9 = var8.length();
               int var10 = 0;

               for(var11 = 0; var11 < var9; ++var11) {
                  var10 = (var10 << 5) - var10 + var8.charAt(var11);
               }

               var27.putInt(((Integer)var6.get(Integer.valueOf(var10))).intValue());
               var27.offset += 4;
               break;
            case 3:
               var27.offset += 8;
            }

            var27.putString(class89.password);
            var27.encryptRsa(class87.field1301, class87.field1306);
            PacketNode var34;
            if(PacketNode.field2441 == 0) {
               var34 = new PacketNode();
            } else {
               var34 = PacketNode.packetBufferNodes[--PacketNode.field2441];
            }

            var34.clientPacket = null;
            var34.field2442 = 0;
            var34.packetBuffer = new PacketBuffer(5000);
            var34.packetBuffer.offset = 0;
            if(gameState == 40) {
               var34.packetBuffer.putByte(LoginPacket.field2419.id);
            } else {
               var34.packetBuffer.putByte(LoginPacket.field2417.id);
            }

            var34.packetBuffer.putShort(0);
            var7 = var34.packetBuffer.offset;
            var34.packetBuffer.putInt(163);
            var34.packetBuffer.putBytes(var27.payload, 0, var27.offset);
            var17 = var34.packetBuffer.offset;
            var34.packetBuffer.putString(class89.username);
            var34.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var34.packetBuffer.putShort(GameEngine.canvasWidth);
            var34.packetBuffer.putShort(IndexFile.canvasHeight);
            PacketBuffer var18 = var34.packetBuffer;
            if(field1006 != null) {
               var18.putBytes(field1006, 0, field1006.length);
            } else {
               byte[] var19 = new byte[24];

               try {
                  class157.randomDat.seek(0L);
                  class157.randomDat.read(var19);

                  int var12;
                  for(var12 = 0; var12 < 24 && var19[var12] == 0; ++var12) {
                     ;
                  }

                  if(var12 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var25) {
                  for(int var13 = 0; var13 < 24; ++var13) {
                     var19[var13] = -1;
                  }
               }

               var18.putBytes(var19, 0, var19.length);
            }

            var34.packetBuffer.putString(IndexFile.sessionToken);
            var34.packetBuffer.putInt(class265.field3502);
            Buffer var21 = new Buffer(ItemContainer.platformInfo.method6012());
            ItemContainer.platformInfo.method6011(var21);
            var34.packetBuffer.putBytes(var21.payload, 0, var21.payload.length);
            var34.packetBuffer.putByte(class5.field30);
            var34.packetBuffer.putInt(0);
            var34.packetBuffer.putInt(class153.indexInterfaces.crc);
            var34.packetBuffer.putInt(BoundingBox2D.indexSoundEffects.crc);
            var34.packetBuffer.putInt(Frames.configsIndex.crc);
            var34.packetBuffer.putInt(class65.indexCache3.crc);
            var34.packetBuffer.putInt(class62.indexCache4.crc);
            var34.packetBuffer.putInt(indexMaps.crc);
            var34.packetBuffer.putInt(class231.indexTrack1.crc);
            var34.packetBuffer.putInt(class48.indexModels.crc);
            var34.packetBuffer.putInt(class37.indexSprites.crc);
            var34.packetBuffer.putInt(class153.indexTextures.crc);
            var34.packetBuffer.putInt(class65.indexCache10.crc);
            var34.packetBuffer.putInt(class54.indexTrack2.crc);
            var34.packetBuffer.putInt(class22.indexScripts.crc);
            var34.packetBuffer.putInt(class27.indexCache13.crc);
            var34.packetBuffer.putInt(class27.vorbisIndex.crc);
            var34.packetBuffer.putInt(class186.indexCache15.crc);
            var34.packetBuffer.putInt(class249.indexWorldMap.crc);
            var34.packetBuffer.encryptXtea(var30, var17, var34.packetBuffer.offset);
            var34.packetBuffer.method3504(var34.packetBuffer.offset - var7);
            field937.method2044(var34);
            field937.method2043();
            field937.field1454 = new ISAACCipher(var30);

            for(var11 = 0; var11 < 4; ++var11) {
               var30[var11] += 50;
            }

            var2.seed(var30);
            loginState = 6;
         }

         if(loginState == 6 && ((class159)var1).vmethod3300() > 0) {
            var37 = ((class159)var1).vmethod3301();
            if(var37 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var37 == 2) {
               loginState = 9;
            } else if(var37 == 15 && gameState == 40) {
               field937.packetLength = -1;
               loginState = 13;
            } else if(var37 == 23 && field875 < 1) {
               ++field875;
               loginState = 0;
            } else {
               if(var37 != 29) {
                  class29.method242(var37);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class159)var1).vmethod3300() > 0) {
            field876 = (((class159)var1).vmethod3301() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field874 = 0;
            class47.method679("You have only just left another world.", "Your profile will be transferred in:", field876 / 60 + " seconds.");
            if(--field876 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && ((class159)var1).vmethod3300() >= 13) {
               var14 = ((class159)var1).vmethod3301() == 1;
               ((class159)var1).vmethod3302(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var38 = false;
               if(var14) {
                  var15 = var2.readOpcode() << 24;
                  var15 |= var2.readOpcode() << 16;
                  var15 |= var2.readOpcode() << 8;
                  var15 |= var2.readOpcode();
                  String var35 = class89.username;
                  var7 = var35.length();
                  var17 = 0;
                  var9 = 0;

                  while(true) {
                     if(var9 >= var7) {
                        if(WorldComparator.preferences.preferences.size() >= 10 && !WorldComparator.preferences.preferences.containsKey(Integer.valueOf(var17))) {
                           Iterator var36 = WorldComparator.preferences.preferences.entrySet().iterator();
                           var36.next();
                           var36.remove();
                        }

                        WorldComparator.preferences.preferences.put(Integer.valueOf(var17), Integer.valueOf(var15));
                        break;
                     }

                     var17 = (var17 << 5) - var17 + var35.charAt(var9);
                     ++var9;
                  }
               }

               if(class89.Login_isUsernameRemembered) {
                  WorldComparator.preferences.rememberedUsername = class89.username;
               } else {
                  WorldComparator.preferences.rememberedUsername = null;
               }

               CombatInfo1.method1618();
               rights = ((class159)var1).vmethod3301();
               field857 = ((class159)var1).vmethod3301() == 1;
               localInteractingIndex = ((class159)var1).vmethod3301();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class159)var1).vmethod3301();
               field946 = ((class159)var1).vmethod3301();
               ((class159)var1).vmethod3302(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = GameSocket.method3340();
               int var23 = var2.method3838();
               if(var23 < 0 || var23 >= var5.length) {
                  throw new IOException(var23 + " " + var2.offset);
               }

               field937.serverPacket = var5[var23];
               field937.packetLength = field937.serverPacket.packetLength;
               ((class159)var1).vmethod3302(var2.payload, 0, 2);
               var2.offset = 0;
               field937.packetLength = var2.readUnsignedShort();

               try {
                  Client var16 = class175.clientInstance;
                  JSObject.getWindow(var16).call("zap", (Object[])null);
               } catch (Throwable var24) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((class159)var1).vmethod3300() >= field937.packetLength) {
                  var2.offset = 0;
                  ((class159)var1).vmethod3302(var2.payload, 0, field937.packetLength);
                  field888.method5519();
                  class173.method3411();
                  GrandExchangeEvent.initializeGPI(var2);
                  MessageNode.field798 = -1;
                  class23.xteaChanged(false, var2);
                  field937.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((class159)var1).vmethod3300() >= 2) {
                  var2.offset = 0;
                  ((class159)var1).vmethod3302(var2.payload, 0, 2);
                  var2.offset = 0;
                  Huffman.field2452 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class159)var1).vmethod3300() >= Huffman.field2452) {
                  var2.offset = 0;
                  ((class159)var1).vmethod3302(var2.payload, 0, Huffman.field2452);
                  var2.offset = 0;
                  String var28 = var2.readString();
                  String var32 = var2.readString();
                  String var31 = var2.readString();
                  class47.method679(var28, var32, var31);
                  class87.setGameState(10);
               }

               if(loginState != 13) {
                  ++field874;
                  if(field874 > 2000) {
                     if(field875 < 1) {
                        if(WorldMapType2.port1 == class43.myWorldPort) {
                           class43.myWorldPort = FaceNormal.port2;
                        } else {
                           class43.myWorldPort = WorldMapType2.port1;
                        }

                        ++field875;
                        loginState = 0;
                     } else {
                        class29.method242(-3);
                     }
                  }
               } else {
                  if(field937.packetLength == -1) {
                     if(((class159)var1).vmethod3300() < 2) {
                        return;
                     }

                     ((class159)var1).vmethod3302(var2.payload, 0, 2);
                     var2.offset = 0;
                     field937.packetLength = var2.readUnsignedShort();
                  }

                  if(((class159)var1).vmethod3300() >= field937.packetLength) {
                     ((class159)var1).vmethod3302(var2.payload, 0, field937.packetLength);
                     var2.offset = 0;
                     var37 = field937.packetLength;
                     field888.method5521();
                     field937.method2041();
                     field937.packetBuffer.offset = 0;
                     field937.serverPacket = null;
                     field937.field1455 = null;
                     field937.field1446 = null;
                     field937.field1457 = null;
                     field937.packetLength = 0;
                     field937.field1456 = 0;
                     field994 = 0;
                     menuOptionCount = 0;
                     isMenuOpen = false;
                     field978 = 0;
                     destinationX = 0;

                     for(var15 = 0; var15 < 2048; ++var15) {
                        cachedPlayers[var15] = null;
                     }

                     GroundObject.localPlayer = null;

                     for(var15 = 0; var15 < cachedNPCs.length; ++var15) {
                        NPC var33 = cachedNPCs[var15];
                        if(var33 != null) {
                           var33.interacting = -1;
                           var33.field1141 = false;
                        }
                     }

                     ItemContainer.itemContainers = new HashTable(32);
                     class87.setGameState(30);

                     for(var15 = 0; var15 < 100; ++var15) {
                        field1029[var15] = true;
                     }

                     ScriptState.method985();
                     GrandExchangeEvent.initializeGPI(var2);
                     if(var37 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var26) {
         if(field875 < 1) {
            if(WorldMapType2.port1 == class43.myWorldPort) {
               class43.myWorldPort = FaceNormal.port2;
            } else {
               class43.myWorldPort = WorldMapType2.port1;
            }

            ++field875;
            loginState = 0;
         } else {
            class29.method242(-2);
         }
      }
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-32"
   )
   final void method1381() {
      if(field994 > 1) {
         --field994;
      }

      if(field943 > 0) {
         --field943;
      }

      if(socketError) {
         socketError = false;
         class263.method4864();
      } else {
         if(!isMenuOpen) {
            menuOptionCount = 0;
            isMenuOpen = false;
            menuOptions[0] = "Cancel";
            menuTargets[0] = "";
            menuTypes[0] = 1006;
            menuBooleanArray[0] = false;
            menuOptionCount = 1;
         }

         for(int var1 = 0; var1 < 100 && this.method1192(field937); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class304.classInfos.last();
               boolean var30;
               if(var2 == null) {
                  var30 = false;
               } else {
                  var30 = true;
               }

               int var3;
               PacketNode var31;
               if(!var30) {
                  PacketNode var14;
                  int var15;
                  if(field888.field3844) {
                     var14 = Script.method2025(ClientPacket.field2330, field937.field1454);
                     var14.packetBuffer.putByte(0);
                     var15 = var14.packetBuffer.offset;
                     field888.method5529(var14.packetBuffer);
                     var14.packetBuffer.method3505(var14.packetBuffer.offset - var15);
                     field937.method2044(var14);
                     field888.method5520();
                  }

                  Object var35 = class41.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  synchronized(class41.mouseRecorder.lock) {
                     if(!field985) {
                        class41.mouseRecorder.index = 0;
                     } else if(MouseInput.mouseLastButton != 0 || class41.mouseRecorder.index >= 40) {
                        var31 = Script.method2025(ClientPacket.field2382, field937.field1454);
                        var31.packetBuffer.putByte(0);
                        var3 = var31.packetBuffer.offset;
                        var4 = 0;

                        for(var5 = 0; var5 < class41.mouseRecorder.index && var31.packetBuffer.offset - var3 < 240; ++var5) {
                           ++var4;
                           var6 = class41.mouseRecorder.ys[var5];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 502) {
                              var6 = 502;
                           }

                           var7 = class41.mouseRecorder.xs[var5];
                           if(var7 < 0) {
                              var7 = 0;
                           } else if(var7 > 764) {
                              var7 = 764;
                           }

                           var8 = var6 * 765 + var7;
                           if(class41.mouseRecorder.ys[var5] == -1 && class41.mouseRecorder.xs[var5] == -1) {
                              var7 = -1;
                              var6 = -1;
                              var8 = 524287;
                           }

                           if(var7 == field851 && var6 == field852) {
                              if(field853 < 2047) {
                                 ++field853;
                              }
                           } else {
                              var9 = var7 - field851;
                              field851 = var7;
                              var10 = var6 - field852;
                              field852 = var6;
                              if(field853 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                                 var9 += 32;
                                 var10 += 32;
                                 var31.packetBuffer.putShort(var10 + (field853 << 12) + (var9 << 6));
                                 field853 = 0;
                              } else if(field853 < 8) {
                                 var31.packetBuffer.put24bitInt((field853 << 19) + var8 + 8388608);
                                 field853 = 0;
                              } else {
                                 var31.packetBuffer.putInt((field853 << 19) + var8 + -1073741824);
                                 field853 = 0;
                              }
                           }
                        }

                        var31.packetBuffer.method3505(var31.packetBuffer.offset - var3);
                        field937.method2044(var31);
                        if(var4 >= class41.mouseRecorder.index) {
                           class41.mouseRecorder.index = 0;
                        } else {
                           class41.mouseRecorder.index -= var4;

                           for(var5 = 0; var5 < class41.mouseRecorder.index; ++var5) {
                              class41.mouseRecorder.xs[var5] = class41.mouseRecorder.xs[var4 + var5];
                              class41.mouseRecorder.ys[var5] = class41.mouseRecorder.ys[var4 + var5];
                           }
                        }
                     }
                  }

                  PacketNode var18;
                  if(MouseInput.mouseLastButton == 1 || !class29.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
                     long var16 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
                     if(var16 > 4095L) {
                        var16 = 4095L;
                     }

                     mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis * -1L;
                     var3 = MouseInput.mouseLastPressedY;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > IndexFile.canvasHeight) {
                        var3 = IndexFile.canvasHeight;
                     }

                     var4 = MouseInput.mouseLastPressedX;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > GameEngine.canvasWidth) {
                        var4 = GameEngine.canvasWidth;
                     }

                     var5 = (int)var16;
                     var18 = Script.method2025(ClientPacket.field2405, field937.field1454);
                     var18.packetBuffer.putShort((var5 << 1) + (MouseInput.mouseLastButton == 2?1:0));
                     var18.packetBuffer.putShort(var4);
                     var18.packetBuffer.putShort(var3);
                     field937.method2044(var18);
                  }

                  if(KeyFocusListener.field607 > 0) {
                     var14 = Script.method2025(ClientPacket.field2320, field937.field1454);
                     var14.packetBuffer.putShort(0);
                     var15 = var14.packetBuffer.offset;
                     long var19 = SceneTilePaint.currentTimeMs();

                     for(var5 = 0; var5 < KeyFocusListener.field607; ++var5) {
                        long var21 = var19 - field1048;
                        if(var21 > 16777215L) {
                           var21 = 16777215L;
                        }

                        field1048 = var19;
                        var14.packetBuffer.method3551((int)var21);
                        var14.packetBuffer.putShortLE(KeyFocusListener.field615[var5]);
                     }

                     var14.packetBuffer.method3504(var14.packetBuffer.offset - var15);
                     field937.method2044(var14);
                  }

                  if(field914 > 0) {
                     --field914;
                  }

                  if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
                     field1044 = true;
                  }

                  if(field1044 && field914 <= 0) {
                     field914 = 20;
                     field1044 = false;
                     var14 = Script.method2025(ClientPacket.field2401, field937.field1454);
                     var14.packetBuffer.writeIntLE16(mapAngle);
                     var14.packetBuffer.writeIntLE16(field907);
                     field937.method2044(var14);
                  }

                  if(class3.field14 && !field961) {
                     field961 = true;
                     var14 = Script.method2025(ClientPacket.field2324, field937.field1454);
                     var14.packetBuffer.putByte(1);
                     field937.method2044(var14);
                  }

                  if(!class3.field14 && field961) {
                     field961 = false;
                     var14 = Script.method2025(ClientPacket.field2324, field937.field1454);
                     var14.packetBuffer.putByte(0);
                     field937.method2044(var14);
                  }

                  UrlRequester.method3145();
                  FaceNormal.method3114();
                  if(gameState != 30) {
                     return;
                  }

                  World.method1660();
                  class131.method2811();
                  ++field937.field1456;
                  if(field937.field1456 > 750) {
                     class263.method4864();
                     return;
                  }

                  class56.method781();
                  class289.method5468();
                  int[] var36 = class92.playerIndices;

                  for(var15 = 0; var15 < class92.playerIndexesCount; ++var15) {
                     Player var23 = cachedPlayers[var36[var15]];
                     if(var23 != null && var23.overheadTextCyclesRemaining > 0) {
                        --var23.overheadTextCyclesRemaining;
                        if(var23.overheadTextCyclesRemaining == 0) {
                           var23.overhead = null;
                        }
                     }
                  }

                  for(var15 = 0; var15 < npcIndexesCount; ++var15) {
                     var3 = npcIndices[var15];
                     NPC var24 = cachedNPCs[var3];
                     if(var24 != null && var24.overheadTextCyclesRemaining > 0) {
                        --var24.overheadTextCyclesRemaining;
                        if(var24.overheadTextCyclesRemaining == 0) {
                           var24.overhead = null;
                        }
                     }
                  }

                  ++field1091;
                  if(cursorState != 0) {
                     field933 += 20;
                     if(field933 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class45.field566 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        class33.method341(class45.field566);
                        class45.field566 = null;
                     }
                  }

                  Widget var37 = KeyFocusListener.field624;
                  Widget var32 = FriendManager.field1216;
                  KeyFocusListener.field624 = null;
                  FriendManager.field1216 = null;
                  field1001 = null;
                  field980 = false;
                  field1002 = false;
                  field1045 = 0;

                  while(Occluder.method3140() && field1045 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && KeyFocusListener.field608 == 66) {
                        String var40 = "";

                        MessageNode var38;
                        for(Iterator var25 = class94.messages.iterator(); var25.hasNext(); var40 = var40 + var38.name + ':' + var38.value + '\n') {
                           var38 = (MessageNode)var25.next();
                        }

                        class175.clientInstance.method810(var40);
                     } else {
                        field966[field1045] = KeyFocusListener.field608;
                        field1046[field1045] = class237.field3235;
                        ++field1045;
                     }
                  }

                  if(BoundingBox.method46() && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var3 = GroundObject.localPlayer.field827 - mouseWheelRotation;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > 3) {
                        var3 = 3;
                     }

                     if(var3 != GroundObject.localPlayer.field827) {
                        var4 = GroundObject.localPlayer.pathX[0] + ClanMemberManager.baseX;
                        var5 = GroundObject.localPlayer.pathY[0] + WorldMapData.baseY;
                        var18 = Script.method2025(ClientPacket.field2383, field937.field1454);
                        var18.packetBuffer.writeShortLE(var5);
                        var18.packetBuffer.putShortLE(var3);
                        var18.packetBuffer.writeIntLE16(var4);
                        field937.method2044(var18);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     var3 = widgetRoot;
                     var4 = GameEngine.canvasWidth;
                     var5 = IndexFile.canvasHeight;
                     if(ServerPacket.loadWidget(var3)) {
                        class23.method174(ScriptState.widgets[var3], -1, 0, 0, var4, var5, 0, 0);
                     }
                  }

                  ++cycleCntr;

                  while(true) {
                     ScriptEvent var39;
                     Widget var42;
                     Widget var43;
                     do {
                        var39 = (ScriptEvent)field1024.popFront();
                        if(var39 == null) {
                           while(true) {
                              do {
                                 var39 = (ScriptEvent)field1025.popFront();
                                 if(var39 == null) {
                                    while(true) {
                                       do {
                                          var39 = (ScriptEvent)field1023.popFront();
                                          if(var39 == null) {
                                             this.method1193();
                                             class47.method676();
                                             if(field940 != null) {
                                                this.method1198();
                                             }

                                             if(class265.field3515 != null) {
                                                class33.method341(class265.field3515);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(itemBeingDragged) {
                                                      if(class45.field562 == class265.field3515 && field896 != field987) {
                                                         Widget var41 = class265.field3515;
                                                         byte var33 = 0;
                                                         if(field1065 == 1 && var41.contentType == 206) {
                                                            var33 = 1;
                                                         }

                                                         if(var41.itemIds[field896] <= 0) {
                                                            var33 = 0;
                                                         }

                                                         var6 = WorldComparator.getWidgetConfig(var41);
                                                         boolean var34 = (var6 >> 29 & 1) != 0;
                                                         if(var34) {
                                                            var7 = field987;
                                                            var8 = field896;
                                                            var41.itemIds[var8] = var41.itemIds[var7];
                                                            var41.itemQuantities[var8] = var41.itemQuantities[var7];
                                                            var41.itemIds[var7] = -1;
                                                            var41.itemQuantities[var7] = 0;
                                                         } else if(var33 == 1) {
                                                            var7 = field987;
                                                            var8 = field896;

                                                            while(var8 != var7) {
                                                               if(var7 > var8) {
                                                                  var41.method4412(var7 - 1, var7);
                                                                  --var7;
                                                               } else if(var7 < var8) {
                                                                  var41.method4412(var7 + 1, var7);
                                                                  ++var7;
                                                               }
                                                            }
                                                         } else {
                                                            var41.method4412(field896, field987);
                                                         }

                                                         PacketNode var26 = Script.method2025(ClientPacket.field2357, field937.field1454);
                                                         var26.packetBuffer.writeShortLE(field896);
                                                         var26.packetBuffer.writeIntLE(class265.field3515.id);
                                                         var26.packetBuffer.writeShortLE(field987);
                                                         var26.packetBuffer.method3533(var33);
                                                         field937.method2044(var26);
                                                      }
                                                   } else if(this.method1194()) {
                                                      this.openMenu(field993, field939);
                                                   } else if(menuOptionCount > 0) {
                                                      class89.method1899(field993, field939);
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   class265.field3515 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field993 + 5 || MouseInput.mouseLastX < field993 - 5 || MouseInput.mouseLastY > field939 + 5 || MouseInput.mouseLastY < field939 - 5)) {
                                                   itemBeingDragged = true;
                                                }
                                             }

                                             PacketNode var44;
                                             if(Region.method2943()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                var44 = Script.method2025(ClientPacket.field2347, field937.field1454);
                                                var44.packetBuffer.putByte(5);
                                                var44.packetBuffer.writeIntLE16(var4 + WorldMapData.baseY);
                                                var44.packetBuffer.putShort(var3 + ClanMemberManager.baseX);
                                                var44.packetBuffer.method3535(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                field937.method2044(var44);
                                                Region.method2944();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field933 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var37 != KeyFocusListener.field624) {
                                                if(var37 != null) {
                                                   class33.method341(var37);
                                                }

                                                if(KeyFocusListener.field624 != null) {
                                                   class33.method341(KeyFocusListener.field624);
                                                }
                                             }

                                             if(var32 != FriendManager.field1216 && field976 == field975) {
                                                if(var32 != null) {
                                                   class33.method341(var32);
                                                }

                                                if(FriendManager.field1216 != null) {
                                                   class33.method341(FriendManager.field1216);
                                                }
                                             }

                                             if(FriendManager.field1216 != null) {
                                                if(field975 < field976) {
                                                   ++field975;
                                                   if(field975 == field976) {
                                                      class33.method341(FriendManager.field1216);
                                                   }
                                                }
                                             } else if(field975 > 0) {
                                                --field975;
                                             }

                                             var3 = GroundObject.localPlayer.x;
                                             var4 = GroundObject.localPlayer.y;
                                             if(MouseRecorder.field789 - var3 < -500 || MouseRecorder.field789 - var3 > 500 || class5.field27 - var4 < -500 || class5.field27 - var4 > 500) {
                                                MouseRecorder.field789 = var3;
                                                class5.field27 = var4;
                                             }

                                             if(var3 != MouseRecorder.field789) {
                                                MouseRecorder.field789 += (var3 - MouseRecorder.field789) / 16;
                                             }

                                             if(var4 != class5.field27) {
                                                class5.field27 += (var4 - class5.field27) / 16;
                                             }

                                             if(MouseInput.mouseCurrentButton == 4 && class29.middleMouseMovesCamera) {
                                                var5 = MouseInput.mouseLastY - field912;
                                                field910 = var5 * 2;
                                                field912 = var5 != -1 && var5 != 1?(field912 + MouseInput.mouseLastY) / 2:MouseInput.mouseLastY;
                                                var6 = field911 - MouseInput.mouseLastX;
                                                field909 = var6 * 2;
                                                field911 = var6 != -1 && var6 != 1?(MouseInput.mouseLastX + field911) / 2:MouseInput.mouseLastX;
                                             } else {
                                                if(KeyFocusListener.keyPressed[96]) {
                                                   field909 += (-24 - field909) / 2;
                                                } else if(KeyFocusListener.keyPressed[97]) {
                                                   field909 += (24 - field909) / 2;
                                                } else {
                                                   field909 /= 2;
                                                }

                                                if(KeyFocusListener.keyPressed[98]) {
                                                   field910 += (12 - field910) / 2;
                                                } else if(KeyFocusListener.keyPressed[99]) {
                                                   field910 += (-12 - field910) / 2;
                                                } else {
                                                   field910 /= 2;
                                                }

                                                field912 = MouseInput.mouseLastY;
                                                field911 = MouseInput.mouseLastX;
                                             }

                                             mapAngle = field909 / 2 + mapAngle & 2047;
                                             field907 += field910 / 2;
                                             if(field907 < 128) {
                                                field907 = 128;
                                             }

                                             if(field907 > 383) {
                                                field907 = 383;
                                             }

                                             var5 = MouseRecorder.field789 >> 7;
                                             var6 = class5.field27 >> 7;
                                             var7 = MessageNode.getTileHeight(MouseRecorder.field789, class5.field27, class60.plane);
                                             var8 = 0;
                                             int var12;
                                             int var27;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      var27 = class60.plane;
                                                      if(var27 < 3 && (class62.tileSettings[1][var9][var10] & 2) == 2) {
                                                         ++var27;
                                                      }

                                                      var12 = var7 - class62.tileHeights[var27][var9][var10];
                                                      if(var12 > var8) {
                                                         var8 = var12;
                                                      }
                                                   }
                                                }
                                             }

                                             var9 = var8 * 192;
                                             if(var9 > 98048) {
                                                var9 = 98048;
                                             }

                                             if(var9 < 32768) {
                                                var9 = 32768;
                                             }

                                             if(var9 > field916) {
                                                field916 += (var9 - field916) / 24;
                                             } else if(var9 < field916) {
                                                field916 += (var9 - field916) / 80;
                                             }

                                             if(field1068) {
                                                var3 = AbstractByteBuffer.field2528 * 128 + 64;
                                                var4 = class296.field3815 * 128 + 64;
                                                var5 = MessageNode.getTileHeight(var3, var4, class60.plane) - class18.field311;
                                                if(class89.cameraX < var3) {
                                                   class89.cameraX = (var3 - class89.cameraX) * GrandExchangeEvents.field269 / 1000 + class89.cameraX + FileSystem.field3295;
                                                   if(class89.cameraX > var3) {
                                                      class89.cameraX = var3;
                                                   }
                                                }

                                                if(class89.cameraX > var3) {
                                                   class89.cameraX -= GrandExchangeEvents.field269 * (class89.cameraX - var3) / 1000 + FileSystem.field3295;
                                                   if(class89.cameraX < var3) {
                                                      class89.cameraX = var3;
                                                   }
                                                }

                                                if(class216.cameraZ < var5) {
                                                   class216.cameraZ = (var5 - class216.cameraZ) * GrandExchangeEvents.field269 / 1000 + class216.cameraZ + FileSystem.field3295;
                                                   if(class216.cameraZ > var5) {
                                                      class216.cameraZ = var5;
                                                   }
                                                }

                                                if(class216.cameraZ > var5) {
                                                   class216.cameraZ -= GrandExchangeEvents.field269 * (class216.cameraZ - var5) / 1000 + FileSystem.field3295;
                                                   if(class216.cameraZ < var5) {
                                                      class216.cameraZ = var5;
                                                   }
                                                }

                                                if(class3.cameraY < var4) {
                                                   class3.cameraY = (var4 - class3.cameraY) * GrandExchangeEvents.field269 / 1000 + class3.cameraY + FileSystem.field3295;
                                                   if(class3.cameraY > var4) {
                                                      class3.cameraY = var4;
                                                   }
                                                }

                                                if(class3.cameraY > var4) {
                                                   class3.cameraY -= GrandExchangeEvents.field269 * (class3.cameraY - var4) / 1000 + FileSystem.field3295;
                                                   if(class3.cameraY < var4) {
                                                      class3.cameraY = var4;
                                                   }
                                                }

                                                var3 = class5.field26 * 128 + 64;
                                                var4 = ScriptState.field715 * 128 + 64;
                                                var5 = MessageNode.getTileHeight(var3, var4, class60.plane) - class219.field2699;
                                                var6 = var3 - class89.cameraX;
                                                var7 = var5 - class216.cameraZ;
                                                var8 = var4 - class3.cameraY;
                                                var9 = (int)Math.sqrt((double)(var6 * var6 + var8 * var8));
                                                var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                var27 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                if(var10 < 128) {
                                                   var10 = 128;
                                                }

                                                if(var10 > 383) {
                                                   var10 = 383;
                                                }

                                                if(ScriptEvent.cameraPitch < var10) {
                                                   ScriptEvent.cameraPitch = (var10 - ScriptEvent.cameraPitch) * class2.field10 / 1000 + ScriptEvent.cameraPitch + class27.field381;
                                                   if(ScriptEvent.cameraPitch > var10) {
                                                      ScriptEvent.cameraPitch = var10;
                                                   }
                                                }

                                                if(ScriptEvent.cameraPitch > var10) {
                                                   ScriptEvent.cameraPitch -= class2.field10 * (ScriptEvent.cameraPitch - var10) / 1000 + class27.field381;
                                                   if(ScriptEvent.cameraPitch < var10) {
                                                      ScriptEvent.cameraPitch = var10;
                                                   }
                                                }

                                                var12 = var27 - class80.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 > 0) {
                                                   class80.cameraYaw = class80.cameraYaw + class27.field381 + var12 * class2.field10 / 1000;
                                                   class80.cameraYaw &= 2047;
                                                }

                                                if(var12 < 0) {
                                                   class80.cameraYaw -= -var12 * class2.field10 / 1000 + class27.field381;
                                                   class80.cameraYaw &= 2047;
                                                }

                                                int var13 = var27 - class80.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                   class80.cameraYaw = var27;
                                                }
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1073[var3];
                                             }

                                             class34.chatMessages.process();
                                             var3 = IndexFile.method3332();
                                             var4 = class5.method13();
                                             if(var3 > 15000 && var4 > 15000) {
                                                field943 = 250;
                                                class111.method2350(14500);
                                                var44 = Script.method2025(ClientPacket.field2403, field937.field1454);
                                                field937.method2044(var44);
                                             }

                                             class35.friendManager.method1686();
                                             ++field937.field1449;
                                             if(field937.field1449 > 50) {
                                                var44 = Script.method2025(ClientPacket.field2345, field937.field1454);
                                                field937.method2044(var44);
                                             }

                                             try {
                                                field937.method2043();
                                             } catch (IOException var28) {
                                                class263.method4864();
                                             }

                                             return;
                                          }

                                          var42 = var39.widget;
                                          if(var42.index < 0) {
                                             break;
                                          }

                                          var43 = class216.getWidget(var42.parentId);
                                       } while(var43 == null || var43.children == null || var42.index >= var43.children.length || var42 != var43.children[var42.index]);

                                       class84.method1868(var39);
                                    }
                                 }

                                 var42 = var39.widget;
                                 if(var42.index < 0) {
                                    break;
                                 }

                                 var43 = class216.getWidget(var42.parentId);
                              } while(var43 == null || var43.children == null || var42.index >= var43.children.length || var42 != var43.children[var42.index]);

                              class84.method1868(var39);
                           }
                        }

                        var42 = var39.widget;
                        if(var42.index < 0) {
                           break;
                        }

                        var43 = class216.getWidget(var42.parentId);
                     } while(var43 == null || var43.children == null || var42.index >= var43.children.length || var42 != var43.children[var42.index]);

                     class84.method1868(var39);
                  }
               }

               var31 = Script.method2025(ClientPacket.field2338, field937.field1454);
               var31.packetBuffer.putByte(0);
               var3 = var31.packetBuffer.offset;
               class299.encodeClassVerifier(var31.packetBuffer);
               var31.packetBuffer.method3505(var31.packetBuffer.offset - var3);
               field937.method2044(var31);
            }
         }
      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method1190() {
      int var1 = GameEngine.canvasWidth;
      int var2 = IndexFile.canvasHeight;
      if(super.field658 < var1) {
         var1 = super.field658;
      }

      if(super.field659 < var2) {
         var2 = super.field659;
      }

      if(WorldComparator.preferences != null) {
         try {
            Client var3 = class175.clientInstance;
            Object[] var4 = new Object[]{Integer.valueOf(BoundingBox.method40())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1555934612"
   )
   final void method1191() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(ServerPacket.loadWidget(var1)) {
            GrandExchangeEvent.method80(ScriptState.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field1029[var1]) {
            field906[var1] = true;
         }

         field1031[var1] = field1029[var1];
         field1029[var1] = false;
      }

      field1028 = gameCycle;
      field973 = -1;
      field974 = -1;
      class45.field562 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         LoginPacket.method3410(widgetRoot, 0, 0, GameEngine.canvasWidth, IndexFile.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      if(!isMenuOpen) {
         if(field973 != -1) {
            ItemContainer.method1053(field973, field974);
         }
      } else {
         KeyFocusListener.method732();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field1031[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field906[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      class37.method492(class60.plane, GroundObject.localPlayer.x, GroundObject.localPlayer.y, field1091);
      field1091 = 0;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(Lca;I)Z",
      garbageValue = "-1849971000"
   )
   final boolean method1192(NetWriter var1) {
      class159 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         int var6;
         String var20;
         try {
            int var5;
            if(var1.serverPacket == null) {
               if(var1.field1452) {
                  if(!var2.vmethod3297(1)) {
                     return false;
                  }

                  var2.vmethod3302(var1.packetBuffer.payload, 0, 1);
                  var1.field1456 = 0;
                  var1.field1452 = false;
               }

               var3.offset = 0;
               if(var3.method3813()) {
                  if(!var2.vmethod3297(1)) {
                     return false;
                  }

                  var2.vmethod3302(var1.packetBuffer.payload, 1, 1);
                  var1.field1456 = 0;
               }

               var1.field1452 = true;
               ServerPacket[] var4 = GameSocket.method3340();
               var5 = var3.method3838();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.serverPacket = var4[var5];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3297(1)) {
                  return false;
               }

               var1.getSocket().vmethod3302(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3297(2)) {
                  return false;
               }

               var1.getSocket().vmethod3302(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3297(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3302(var3.payload, 0, var1.packetLength);
            var1.field1456 = 0;
            field888.method5516();
            var1.field1457 = var1.field1446;
            var1.field1446 = var1.field1455;
            var1.field1455 = var1.serverPacket;
            if(ServerPacket.field2262 == var1.serverPacket) {
               class35.friendManager.method1684();
               field1017 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2265 == var1.serverPacket) {
               class39.method528(class173.field2427);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2241 == var1.serverPacket) {
               class20.method158();
               weight = var3.readShort();
               field1021 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2309 == var1.serverPacket) {
               class292.method5486(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2256 == var1.serverPacket) {
               WorldMapType2.method516();
               var1.serverPacket = null;
               return false;
            }

            int var7;
            int var18;
            if(ServerPacket.field2316 == var1.serverPacket) {
               class20.method158();
               var18 = var3.method3538();
               var5 = var3.method3538();
               var6 = var3.method3557();
               skillExperiences[var5] = var6;
               boostedSkillLevels[var5] = var18;
               realSkillLevels[var5] = 1;

               for(var7 = 0; var7 < 98; ++var7) {
                  if(var6 >= class233.field2941[var7]) {
                     realSkillLevels[var5] = var7 + 2;
                  }
               }

               field1014[++field996 - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            Widget var53;
            boolean var54;
            if(ServerPacket.field2250 == var1.serverPacket) {
               var54 = var3.readUnsignedByte() == 1;
               var5 = var3.method3556();
               var53 = class216.getWidget(var5);
               if(var54 != var53.isHidden) {
                  var53.isHidden = var54;
                  class33.method341(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2280 == var1.serverPacket) {
               var18 = var3.readUnsignedShort();
               widgetRoot = var18;
               this.method1196(false);
               TotalQuantityComparator.method91(var18);
               FrameMap.method2900(widgetRoot);

               for(var5 = 0; var5 < 100; ++var5) {
                  field1029[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2255 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  SoundTask.method2332(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            int var8;
            int var9;
            int var10;
            if(ServerPacket.field2291 == var1.serverPacket) {
               field1068 = true;
               class5.field26 = var3.readUnsignedByte();
               ScriptState.field715 = var3.readUnsignedByte();
               class219.field2699 = var3.readUnsignedShort();
               class27.field381 = var3.readUnsignedByte();
               class2.field10 = var3.readUnsignedByte();
               if(class2.field10 >= 100) {
                  var18 = class5.field26 * 128 + 64;
                  var5 = ScriptState.field715 * 128 + 64;
                  var6 = MessageNode.getTileHeight(var18, var5, class60.plane) - class219.field2699;
                  var7 = var18 - class89.cameraX;
                  var8 = var6 - class216.cameraZ;
                  var9 = var5 - class3.cameraY;
                  var10 = (int)Math.sqrt((double)(var7 * var7 + var9 * var9));
                  ScriptEvent.cameraPitch = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                  class80.cameraYaw = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                  if(ScriptEvent.cameraPitch < 128) {
                     ScriptEvent.cameraPitch = 128;
                  }

                  if(ScriptEvent.cameraPitch > 383) {
                     ScriptEvent.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2242 == var1.serverPacket) {
               var18 = var3.readInt();
               WidgetNode var68 = (WidgetNode)componentTable.get((long)var18);
               if(var68 != null) {
                  class137.method3103(var68, true);
               }

               if(field885 != null) {
                  class33.method341(field885);
                  field885 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2302 == var1.serverPacket) {
               for(var18 = 0; var18 < cachedPlayers.length; ++var18) {
                  if(cachedPlayers[var18] != null) {
                     cachedPlayers[var18].animation = -1;
                  }
               }

               for(var18 = 0; var18 < cachedNPCs.length; ++var18) {
                  if(cachedNPCs[var18] != null) {
                     cachedNPCs[var18].animation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2311 == var1.serverPacket) {
               field1041 = var3.method3536();
               publicChatMode = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2240 == var1.serverPacket) {
               class23.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               var18 = var3.readUnsignedShort();
               if(var18 == 65535) {
                  var18 = -1;
               }

               Varcs.method1998(var18);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2283 == var1.serverPacket) {
               var18 = var3.readUnsignedByteNegate();
               if(var18 == 65535) {
                  var18 = -1;
               }

               var5 = var3.method3552();
               if(field1057 != 0 && var18 != -1) {
                  class3.method7(class54.indexTrack2, var18, 0, field1057, false);
                  field1059 = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2258 == var1.serverPacket) {
               field1068 = false;

               for(var18 = 0; var18 < 5; ++var18) {
                  field1069[var18] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2236 == var1.serverPacket) {
               class39.method528(class173.field2433);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2278 == var1.serverPacket) {
               class39.method528(class173.field2434);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2307 == var1.serverPacket) {
               class39.method528(class173.field2431);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2308 == var1.serverPacket) {
               var18 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               if(field1058 != 0 && var5 != 0 && queuedSoundEffectCount < 50) {
                  queuedSoundEffectIDs[queuedSoundEffectCount] = var18;
                  unknownSoundValues1[queuedSoundEffectCount] = var5;
                  unknownSoundValues2[queuedSoundEffectCount] = var6;
                  audioEffects[queuedSoundEffectCount] = null;
                  soundLocations[queuedSoundEffectCount] = 0;
                  ++queuedSoundEffectCount;
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var56;
            if(ServerPacket.field2285 == var1.serverPacket) {
               var18 = var3.method3556();
               var56 = class216.getWidget(var18);
               var56.modelType = 3;
               var56.modelId = GroundObject.localPlayer.composition.method4385();
               class33.method341(var56);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2239 == var1.serverPacket) {
               var18 = var1.packetLength;
               var5 = var3.offset;
               class92.field1399 = 0;
               var6 = 0;
               var3.bitAccess();

               for(var7 = 0; var7 < class92.playerIndexesCount; ++var7) {
                  var8 = class92.playerIndices[var7];
                  if((class92.field1389[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = class80.method1817(var3);
                           class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                        } else {
                           class85.decodeMovement(var3, var8);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var7 = 0; var7 < class92.playerIndexesCount; ++var7) {
                  var8 = class92.playerIndices[var7];
                  if((class92.field1389[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = class80.method1817(var3);
                           class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                        } else {
                           class85.decodeMovement(var3, var8);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var7 = 0; var7 < class92.field1394; ++var7) {
                  var8 = class92.field1402[var7];
                  if((class92.field1389[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = class80.method1817(var3);
                           class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                        } else if(FriendManager.decodeRegionHash(var3, var8)) {
                           class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var7 = 0; var7 < class92.field1394; ++var7) {
                  var8 = class92.field1402[var7];
                  if((class92.field1389[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                     } else {
                        var9 = var3.getBits(1);
                        if(var9 == 0) {
                           var6 = class80.method1817(var3);
                           class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                        } else if(FriendManager.decodeRegionHash(var3, var8)) {
                           class92.field1389[var8] = (byte)(class92.field1389[var8] | 2);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               class92.playerIndexesCount = 0;
               class92.field1394 = 0;

               Player var66;
               for(var7 = 1; var7 < 2048; ++var7) {
                  class92.field1389[var7] = (byte)(class92.field1389[var7] >> 1);
                  var66 = cachedPlayers[var7];
                  if(var66 != null) {
                     class92.playerIndices[++class92.playerIndexesCount - 1] = var7;
                  } else {
                     class92.field1402[++class92.field1394 - 1] = var7;
                  }
               }

               for(var6 = 0; var6 < class92.field1399; ++var6) {
                  var7 = class92.field1400[var6];
                  var66 = cachedPlayers[var7];
                  var9 = var3.readUnsignedByte();
                  if((var9 & 2) != 0) {
                     var9 += var3.readUnsignedByte() << 8;
                  }

                  ClientPacket.method3404(var3, var7, var66, var9);
               }

               if(var18 != var3.offset - var5) {
                  throw new RuntimeException(var3.offset - var5 + " " + var18);
               }

               var1.serverPacket = null;
               return true;
            }

            String var45;
            if(ServerPacket.field2290 == var1.serverPacket) {
               var45 = var3.readString();
               Object[] var65 = new Object[var45.length() + 1];

               for(var6 = var45.length() - 1; var6 >= 0; --var6) {
                  if(var45.charAt(var6) == 's') {
                     var65[var6 + 1] = var3.readString();
                  } else {
                     var65[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var65[0] = new Integer(var3.readInt());
               ScriptEvent var71 = new ScriptEvent();
               var71.objs = var65;
               class84.method1868(var71);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2292 == var1.serverPacket) {
               var18 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var18 < -70000) {
                  var5 += 32768;
               }

               if(var18 >= 0) {
                  var53 = class216.getWidget(var18);
               } else {
                  var53 = null;
               }

               for(; var3.offset < var1.packetLength; Ignore.setItemTableSlot(var5, var7, var8 - 1, var9)) {
                  var7 = var3.getUSmart();
                  var8 = var3.readUnsignedShort();
                  var9 = 0;
                  if(var8 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var53 != null && var7 >= 0 && var7 < var53.itemIds.length) {
                     var53.itemIds[var7] = var8;
                     var53.itemQuantities[var7] = var9;
                  }
               }

               if(var53 != null) {
                  class33.method341(var53);
               }

               class20.method158();
               interfaceItemTriggers[++field1090 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2287 == var1.serverPacket) {
               var18 = var3.method3549();
               var5 = var3.method3557();
               var53 = class216.getWidget(var5);
               if(var18 != var53.field2801 || var18 == -1) {
                  var53.field2801 = var18;
                  var53.field2876 = 0;
                  var53.field2889 = 0;
                  class33.method341(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2271 == var1.serverPacket) {
               var18 = var3.readUnsignedByteNegate();
               var5 = var3.readInt();
               var53 = class216.getWidget(var5);
               if(var53.modelType != 1 || var18 != var53.modelId) {
                  var53.modelType = 1;
                  var53.modelId = var18;
                  class33.method341(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2288 == var1.serverPacket) {
               if(class22.clanMemberManager != null) {
                  class22.clanMemberManager.method5306(var3);
               }

               CollisionData.method3379();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2313 == var1.serverPacket) {
               for(var18 = 0; var18 < VarPlayerType.field3373; ++var18) {
                  VarPlayerType var63 = class160.method3258(var18);
                  if(var63 != null) {
                     class222.settings[var18] = 0;
                     class222.widgetSettings[var18] = 0;
                  }
               }

               class20.method158();
               field1011 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2274 == var1.serverPacket) {
               for(var18 = 0; var18 < class222.widgetSettings.length; ++var18) {
                  if(class222.settings[var18] != class222.widgetSettings[var18]) {
                     class222.widgetSettings[var18] = class222.settings[var18];
                     class1.method1(var18);
                     field1010[++field1011 - 1 & 31] = var18;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2252 == var1.serverPacket) {
               class35.friendManager.field1212.method5159(var3, var1.packetLength);
               DState.method3487();
               if(class22.clanMemberManager != null) {
                  class22.clanMemberManager.method5303();
               }

               field1017 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            long var12;
            WidgetNode var23;
            if(ServerPacket.field2289 == var1.serverPacket) {
               var18 = var3.offset + var1.packetLength;
               var5 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var5 != widgetRoot) {
                  widgetRoot = var5;
                  this.method1196(false);
                  TotalQuantityComparator.method91(widgetRoot);
                  FrameMap.method2900(widgetRoot);

                  for(var7 = 0; var7 < 100; ++var7) {
                     field1029[var7] = true;
                  }
               }

               WidgetNode var58;
               for(; var6-- > 0; var58.field768 = true) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var58 = (WidgetNode)componentTable.get((long)var7);
                  if(var58 != null && var8 != var58.id) {
                     class137.method3103(var58, true);
                     var58 = null;
                  }

                  if(var58 == null) {
                     var58 = SoundTask.method2331(var7, var8, var9);
                  }
               }

               for(var23 = (WidgetNode)componentTable.first(); var23 != null; var23 = (WidgetNode)componentTable.next()) {
                  if(var23.field768) {
                     var23.field768 = false;
                  } else {
                     class137.method3103(var23, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var18) {
                  var7 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(int var11 = var8; var11 <= var9; ++var11) {
                     var12 = (long)var11 + ((long)var7 << 32);
                     widgetFlags.put(new IntegerNode(var10), var12);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2266 == var1.serverPacket) {
               WorldMapType3.field371 = var3.method3538();
               class153.field2114 = var3.method3506();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2310 == var1.serverPacket) {
               class153.field2114 = var3.method3536();
               WorldMapType3.field371 = var3.method3536();

               while(var3.offset < var1.packetLength) {
                  var18 = var3.readUnsignedByte();
                  class173[] var60 = new class173[]{class173.field2429, class173.field2431, class173.field2432, class173.field2427, class173.field2426, class173.field2430, class173.field2425, class173.field2428, class173.field2433, class173.field2434};
                  class173 var61 = var60[var18];
                  class39.method528(var61);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2246 == var1.serverPacket) {
               class39.method528(class173.field2429);
               var1.serverPacket = null;
               return true;
            }

            String var16;
            int var17;
            long var24;
            long var26;
            long var29;
            if(ServerPacket.field2245 == var1.serverPacket) {
               var45 = var3.readString();
               var24 = (long)var3.readUnsignedShort();
               var26 = (long)var3.read24BitInt();
               Permission var73 = (Permission)Projectile.forOrdinal(class131.method2805(), var3.readUnsignedByte());
               var29 = (var24 << 32) + var26;
               boolean var31 = false;

               for(int var13 = 0; var13 < 100; ++var13) {
                  if(field1043[var13] == var29) {
                     var31 = true;
                     break;
                  }
               }

               if(class35.friendManager.method1689(new Name(var45, class226.loginType))) {
                  var31 = true;
               }

               if(!var31 && myPlayerIndex == 0) {
                  field1043[field899] = var29;
                  field899 = (field899 + 1) % 100;
                  String var32 = FontTypeFace.appendTags(class193.method3871(Enum.method4881(var3)));
                  byte var51;
                  if(var73.field3272) {
                     var51 = 7;
                  } else {
                     var51 = 3;
                  }

                  if(var73.field3270 != -1) {
                     var17 = var73.field3270;
                     var16 = "<img=" + var17 + ">";
                     SoundTaskDataProvider.sendGameMessage(var51, var16 + var45, var32);
                  } else {
                     SoundTaskDataProvider.sendGameMessage(var51, var45, var32);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2264 == var1.serverPacket) {
               World var47 = new World();
               var47.address = var3.readString();
               var47.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var47.mask = var5;
               class87.setGameState(45);
               var2.vmethod3299();
               var2 = null;
               class56.method773(var47);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2243 == var1.serverPacket) {
               field978 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2294 == var1.serverPacket) {
               var18 = var3.readInt();
               var20 = var3.readString();
               var53 = class216.getWidget(var18);
               if(!var20.equals(var53.text)) {
                  var53.text = var20;
                  class33.method341(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2293 == var1.serverPacket) {
               var45 = var3.readString();
               var20 = FontTypeFace.appendTags(class193.method3871(Enum.method4881(var3)));
               SoundTaskDataProvider.sendGameMessage(6, var45, var20);
               var1.serverPacket = null;
               return true;
            }

            Widget var69;
            if(ServerPacket.field2267 == var1.serverPacket) {
               var18 = var3.method3557();
               var5 = var3.method3556();
               var6 = var3.readUnsignedShort();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var69 = class216.getWidget(var5);
               ItemComposition var64;
               if(!var69.hasScript) {
                  if(var6 == -1) {
                     var69.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var64 = ItemContainer.getItemDefinition(var6);
                  var69.modelType = 4;
                  var69.modelId = var6;
                  var69.rotationX = var64.xan2d;
                  var69.rotationZ = var64.yan2d;
                  var69.modelZoom = var64.zoom2d * 100 / var18;
                  class33.method341(var69);
               } else {
                  var69.itemId = var6;
                  var69.itemQuantity = var18;
                  var64 = ItemContainer.getItemDefinition(var6);
                  var69.rotationX = var64.xan2d;
                  var69.rotationZ = var64.yan2d;
                  var69.rotationY = var64.zan2d;
                  var69.field2777 = var64.offsetX2d;
                  var69.field2864 = var64.offsetY2d;
                  var69.modelZoom = var64.zoom2d;
                  if(var64.isStackable == 1) {
                     var69.field2862 = 1;
                  } else {
                     var69.field2862 = 2;
                  }

                  if(var69.field2809 > 0) {
                     var69.modelZoom = var69.modelZoom * 32 / var69.field2809;
                  } else if(var69.originalWidth > 0) {
                     var69.modelZoom = var69.modelZoom * 32 / var69.originalWidth;
                  }

                  class33.method341(var69);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2300 == var1.serverPacket) {
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

            if(ServerPacket.field2305 == var1.serverPacket) {
               class153.method3201(var3.readString());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2281 == var1.serverPacket) {
               var18 = var3.method3506();
               var20 = var3.readString();
               var6 = var3.readUnsignedByte();
               if(var18 >= 1 && var18 <= 8) {
                  if(var20.equalsIgnoreCase("null")) {
                     var20 = null;
                  }

                  playerOptions[var18 - 1] = var20;
                  playerOptionsPriorities[var18 - 1] = var6 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2259 == var1.serverPacket) {
               var18 = var3.readUnsignedShortOb1();
               var5 = var3.method3556();
               var53 = class216.getWidget(var5);
               if(var53 != null && var53.type == 0) {
                  if(var18 > var53.scrollHeight - var53.height) {
                     var18 = var53.scrollHeight - var53.height;
                  }

                  if(var18 < 0) {
                     var18 = 0;
                  }

                  if(var18 != var53.scrollY) {
                     var53.scrollY = var18;
                     class33.method341(var53);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2277 == var1.serverPacket) {
               class39.method528(class173.field2430);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               class35.friendManager.method1723(var3, var1.packetLength);
               field1017 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2244 == var1.serverPacket) {
               if(var1.packetLength == 0) {
                  class22.clanMemberManager = null;
               } else {
                  if(class22.clanMemberManager == null) {
                     class22.clanMemberManager = new ClanMemberManager(class226.loginType, class175.clientInstance);
                  }

                  class22.clanMemberManager.method5307(var3);
               }

               CollisionData.method3379();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2298 == var1.serverPacket) {
               var18 = var3.readInt();
               var5 = var3.readUnsignedShort();
               var53 = class216.getWidget(var18);
               if(var53.modelType != 2 || var5 != var53.modelId) {
                  var53.modelType = 2;
                  var53.modelId = var5;
                  class33.method341(var53);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2275 == var1.serverPacket) {
               var18 = var3.getUSmart();
               boolean var50 = var3.readUnsignedByte() == 1;
               String var55 = "";
               boolean var49 = false;
               if(var50) {
                  var55 = var3.readString();
                  if(class35.friendManager.method1689(new Name(var55, class226.loginType))) {
                     var49 = true;
                  }
               }

               String var62 = var3.readString();
               if(!var49) {
                  SoundTaskDataProvider.sendGameMessage(var18, var55, var62);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2268 == var1.serverPacket) {
               var18 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var18] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var18] = new GrandExchangeOffer(var3, false);
               }

               field1019 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2282 == var1.serverPacket) {
               class39.method528(class173.field2428);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2314 == var1.serverPacket) {
               var18 = var3.readUnsignedShort();
               var5 = var3.method3722();
               var6 = var18 >> 10 & 31;
               var7 = var18 >> 5 & 31;
               var8 = var18 & 31;
               var9 = (var7 << 11) + (var6 << 19) + (var8 << 3);
               Widget var22 = class216.getWidget(var5);
               if(var9 != var22.textColor) {
                  var22.textColor = var9;
                  class33.method341(var22);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2263 == var1.serverPacket) {
               var18 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var18 < -70000) {
                  var5 += 32768;
               }

               if(var18 >= 0) {
                  var53 = class216.getWidget(var18);
               } else {
                  var53 = null;
               }

               if(var53 != null) {
                  for(var7 = 0; var7 < var53.itemIds.length; ++var7) {
                     var53.itemIds[var7] = 0;
                     var53.itemQuantities[var7] = 0;
                  }
               }

               ItemContainer var70 = (ItemContainer)ItemContainer.itemContainers.get((long)var5);
               if(var70 != null) {
                  for(var8 = 0; var8 < var70.itemIds.length; ++var8) {
                     var70.itemIds[var8] = -1;
                     var70.stackSizes[var8] = 0;
                  }
               }

               var7 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var3.method3536();
                  if(var9 == 255) {
                     var9 = var3.method3556();
                  }

                  var10 = var3.readUnsignedShort();
                  if(var53 != null && var8 < var53.itemIds.length) {
                     var53.itemIds[var8] = var10;
                     var53.itemQuantities[var8] = var9;
                  }

                  Ignore.setItemTableSlot(var5, var8, var10 - 1, var9);
               }

               if(var53 != null) {
                  class33.method341(var53);
               }

               class20.method158();
               interfaceItemTriggers[++field1090 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2276 == var1.serverPacket) {
               field1068 = true;
               AbstractByteBuffer.field2528 = var3.readUnsignedByte();
               class296.field3815 = var3.readUnsignedByte();
               class18.field311 = var3.readUnsignedShort();
               FileSystem.field3295 = var3.readUnsignedByte();
               GrandExchangeEvents.field269 = var3.readUnsignedByte();
               if(GrandExchangeEvents.field269 >= 100) {
                  class89.cameraX = AbstractByteBuffer.field2528 * 128 + 64;
                  class3.cameraY = class296.field3815 * 128 + 64;
                  class216.cameraZ = MessageNode.getTileHeight(class89.cameraX, class3.cameraY, class60.plane) - class18.field311;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2286 == var1.serverPacket) {
               var18 = var3.readUnsignedShortOb1();
               var5 = var3.method3722();
               class222.settings[var18] = var5;
               if(class222.widgetSettings[var18] != var5) {
                  class222.widgetSettings[var18] = var5;
               }

               class1.method1(var18);
               field1010[++field1011 - 1 & 31] = var18;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2269 == var1.serverPacket) {
               var18 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var7 = var3.readUnsignedByte();
               field1069[var18] = true;
               field998[var18] = var5;
               field932[var18] = var6;
               field1072[var18] = var7;
               field1073[var18] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2297 == var1.serverPacket) {
               field994 = var3.readUnsignedShortOb1() * 30;
               field1021 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2260 == var1.serverPacket) {
               var18 = var3.readUnsignedShort();
               byte var48 = var3.method3540();
               class222.settings[var18] = var48;
               if(class222.widgetSettings[var18] != var48) {
                  class222.widgetSettings[var18] = var48;
               }

               class1.method1(var18);
               field1010[++field1011 - 1 & 31] = var18;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2279 == var1.serverPacket) {
               var18 = var3.readUnsignedByteNegate();
               WidgetNode.method1063(var18);
               interfaceItemTriggers[++field1090 - 1 & 31] = var18 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2315 == var1.serverPacket) {
               var18 = var3.method3548();
               var5 = var3.readShort();
               var6 = var3.method3722();
               var69 = class216.getWidget(var6);
               if(var5 != var69.originalX || var18 != var69.originalY || var69.dynamicX != 0 || var69.dynamicY != 0) {
                  var69.originalX = var5;
                  var69.originalY = var18;
                  var69.dynamicX = 0;
                  var69.dynamicY = 0;
                  class33.method341(var69);
                  this.widgetMethod0(var69);
                  if(var69.type == 0) {
                     class5.method14(ScriptState.widgets[var6 >> 16], var69, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            long var33;
            if(ServerPacket.field2284 == var1.serverPacket) {
               var18 = var3.readInt();
               var5 = var3.method3547();
               if(var5 == 65535) {
                  var5 = -1;
               }

               var6 = var3.method3556();
               var7 = var3.readUnsignedShort();
               if(var7 == 65535) {
                  var7 = -1;
               }

               for(var8 = var5; var8 <= var7; ++var8) {
                  var33 = (long)var8 + ((long)var6 << 32);
                  Node var74 = widgetFlags.get(var33);
                  if(var74 != null) {
                     var74.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var18), var33);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2237 == var1.serverPacket) {
               class23.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2301 == var1.serverPacket) {
               class39.method528(class173.field2425);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2238 == var1.serverPacket) {
               var18 = var3.method3547();
               var5 = var3.readUnsignedByteNegate();
               var6 = var3.readInt();
               var69 = class216.getWidget(var6);
               var69.field2810 = var18 + (var5 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2306 == var1.serverPacket) {
               var18 = var3.method3722();
               var56 = class216.getWidget(var18);

               for(var6 = 0; var6 < var56.itemIds.length; ++var6) {
                  var56.itemIds[var6] = -1;
                  var56.itemIds[var6] = 0;
               }

               class33.method341(var56);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2257 == var1.serverPacket) {
               class20.method158();
               energy = var3.readUnsignedByte();
               field1021 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2261 == var1.serverPacket) {
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

            if(ServerPacket.field2249 == var1.serverPacket) {
               class39.method528(class173.field2432);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2247 == var1.serverPacket) {
               class20.method157(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2248 == var1.serverPacket) {
               var5 = var3.readUnsignedByte();
               class301[] var52 = new class301[]{class301.field3853, class301.field3854, class301.field3855};
               class301[] var67 = var52;
               var8 = 0;

               class301 var46;
               while(true) {
                  if(var8 >= var67.length) {
                     var46 = null;
                     break;
                  }

                  class301 var72 = var67[var8];
                  if(var5 == var72.field3856) {
                     var46 = var72;
                     break;
                  }

                  ++var8;
               }

               IndexFile.field2185 = var46;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2303 == var1.serverPacket) {
               var18 = var3.readUnsignedShort();
               var5 = var3.method3722();
               var6 = var3.method3538();
               var23 = (WidgetNode)componentTable.get((long)var5);
               if(var23 != null) {
                  class137.method3103(var23, var18 != var23.id);
               }

               SoundTask.method2331(var5, var18, var6);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2272 == var1.serverPacket) {
               var54 = var3.readUnsignedByte() == 1;
               if(var54) {
                  WidgetNode.field766 = SceneTilePaint.currentTimeMs() - var3.readLong();
                  VertexNormal.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  VertexNormal.grandExchangeEvents = null;
               }

               field1020 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2253 == var1.serverPacket) {
               var18 = var3.readInt();
               var5 = var3.readInt();
               var7 = 0;
               if(PacketBuffer.field2539 == null || !PacketBuffer.field2539.isValid()) {
                  try {
                     Iterator var57 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var57.hasNext()) {
                        GarbageCollectorMXBean var28 = (GarbageCollectorMXBean)var57.next();
                        if(var28.isValid()) {
                           PacketBuffer.field2539 = var28;
                           GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                           GameEngine.garbageCollectorLastCollectionTime = -1L;
                        }
                     }
                  } catch (Throwable var41) {
                     ;
                  }
               }

               if(PacketBuffer.field2539 != null) {
                  long var36 = SceneTilePaint.currentTimeMs();
                  var29 = PacketBuffer.field2539.getCollectionTime();
                  if(-1L != GameEngine.garbageCollectorLastCollectionTime) {
                     var12 = var29 - GameEngine.garbageCollectorLastCollectionTime;
                     long var38 = var36 - GameEngine.garbageCollectorLastCheckTimeMs;
                     if(0L != var38) {
                        var7 = (int)(var12 * 100L / var38);
                     }
                  }

                  GameEngine.garbageCollectorLastCollectionTime = var29;
                  GameEngine.garbageCollectorLastCheckTimeMs = var36;
               }

               PacketNode var59 = Script.method2025(ClientPacket.field2325, field937.field1454);
               var59.packetBuffer.putShortLE(var7);
               var59.packetBuffer.method3554(var18);
               var59.packetBuffer.method3554(var5);
               var59.packetBuffer.method3535(GameEngine.FPS);
               field937.method2044(var59);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2273 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  var18 = widgetRoot;
                  if(ServerPacket.loadWidget(var18)) {
                     WorldMapType1.method269(ScriptState.widgets[var18], 0);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2254 == var1.serverPacket) {
               var45 = var3.readString();
               var24 = var3.readLong();
               var26 = (long)var3.readUnsignedShort();
               var33 = (long)var3.read24BitInt();
               Permission var35 = (Permission)Projectile.forOrdinal(class131.method2805(), var3.readUnsignedByte());
               var12 = (var26 << 32) + var33;
               boolean var14 = false;

               for(int var15 = 0; var15 < 100; ++var15) {
                  if(field1043[var15] == var12) {
                     var14 = true;
                     break;
                  }
               }

               if(var35.field3273 && class35.friendManager.method1689(new Name(var45, class226.loginType))) {
                  var14 = true;
               }

               if(!var14 && myPlayerIndex == 0) {
                  field1043[field899] = var12;
                  field899 = (field899 + 1) % 100;
                  String var40 = FontTypeFace.appendTags(class193.method3871(Enum.method4881(var3)));
                  if(var35.field3270 != -1) {
                     var17 = var35.field3270;
                     var16 = "<img=" + var17 + ">";
                     CombatInfoListHolder.addChatMessage(9, var16 + var45, var40, NetWriter.method2045(var24));
                  } else {
                     CombatInfoListHolder.addChatMessage(9, var45, var40, NetWriter.method2045(var24));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var21;
            if(ServerPacket.field2312 == var1.serverPacket) {
               var18 = var3.readUnsignedShortOb1();
               var5 = var3.method3547();
               var6 = var3.readUnsignedShortOb1();
               var7 = var3.method3557();
               var21 = class216.getWidget(var7);
               if(var18 != var21.rotationX || var5 != var21.rotationZ || var6 != var21.modelZoom) {
                  var21.rotationX = var18;
                  var21.rotationZ = var5;
                  var21.modelZoom = var6;
                  class33.method341(var21);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2270 == var1.serverPacket) {
               class20.method157(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2251 == var1.serverPacket) {
               WorldMapType3.field371 = var3.readUnsignedByte();
               class153.field2114 = var3.method3506();

               for(var18 = WorldMapType3.field371; var18 < WorldMapType3.field371 + 8; ++var18) {
                  for(var5 = class153.field2114; var5 < class153.field2114 + 8; ++var5) {
                     if(groundItemDeque[class60.plane][var18][var5] != null) {
                        groundItemDeque[class60.plane][var18][var5] = null;
                        TotalQuantityComparator.groundItemSpawned(var18, var5);
                     }
                  }
               }

               for(PendingSpawn var44 = (PendingSpawn)pendingSpawns.getFront(); var44 != null; var44 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var44.x >= WorldMapType3.field371 && var44.x < WorldMapType3.field371 + 8 && var44.y >= class153.field2114 && var44.y < class153.field2114 + 8 && var44.level == class60.plane) {
                     var44.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2296 == var1.serverPacket) {
               var18 = var3.method3722();
               var5 = var3.method3557();
               WidgetNode var19 = (WidgetNode)componentTable.get((long)var18);
               var23 = (WidgetNode)componentTable.get((long)var5);
               if(var23 != null) {
                  class137.method3103(var23, var19 == null || var23.id != var19.id);
               }

               if(var19 != null) {
                  var19.unlink();
                  componentTable.put(var19, (long)var5);
               }

               var21 = class216.getWidget(var18);
               if(var21 != null) {
                  class33.method341(var21);
               }

               var21 = class216.getWidget(var5);
               if(var21 != null) {
                  class33.method341(var21);
                  class5.method14(ScriptState.widgets[var21.id >>> 16], var21, true);
               }

               if(widgetRoot != -1) {
                  var9 = widgetRoot;
                  if(ServerPacket.loadWidget(var9)) {
                     WorldMapType1.method269(ScriptState.widgets[var9], 1);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2304 == var1.serverPacket) {
               class39.method528(class173.field2426);
               var1.serverPacket = null;
               return true;
            }

            GrandExchangeEvent.method78("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1446 != null?var1.field1446.packetId:-1) + "," + (var1.field1457 != null?var1.field1457.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            WorldMapType2.method516();
         } catch (IOException var42) {
            class263.method4864();
         } catch (Exception var43) {
            var20 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1446 != null?var1.field1446.packetId:-1) + "," + (var1.field1457 != null?var1.field1457.packetId:-1) + "," + var1.packetLength + "," + (GroundObject.localPlayer.pathX[0] + ClanMemberManager.baseX) + "," + (GroundObject.localPlayer.pathY[0] + WorldMapData.baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var20 = var20 + var3.payload[var6] + ",";
            }

            GrandExchangeEvent.method78(var20, var43);
            WorldMapType2.method516();
         }

         return true;
      }
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-720658770"
   )
   final void method1193() {
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

      if(class265.field3515 == null) {
         if(field940 == null) {
            int var12;
            label281: {
               int var14 = MouseInput.mouseLastButton;
               int var8;
               int var11;
               if(isMenuOpen) {
                  if(var14 != 1 && (class29.middleMouseMovesCamera || var14 != 4)) {
                     var2 = MouseInput.mouseLastX;
                     var11 = MouseInput.mouseLastY;
                     if(var2 < class56.menuX - 10 || var2 > class56.menuX + WorldComparator.field265 + 10 || var11 < class225.menuY - 10 || var11 > ScriptEvent.field772 + class225.menuY + 10) {
                        isMenuOpen = false;
                        class188.method3796(class56.menuX, class225.menuY, WorldComparator.field265, ScriptEvent.field772);
                     }
                  }

                  if(var14 == 1 || !class29.middleMouseMovesCamera && var14 == 4) {
                     var2 = class56.menuX;
                     var11 = class225.menuY;
                     var12 = WorldComparator.field265;
                     var5 = MouseInput.mouseLastPressedX;
                     int var15 = MouseInput.mouseLastPressedY;
                     int var16 = -1;

                     for(var8 = 0; var8 < menuOptionCount; ++var8) {
                        int var17 = (menuOptionCount - 1 - var8) * 15 + var11 + 31;
                        if(var5 > var2 && var5 < var12 + var2 && var15 > var17 - 13 && var15 < var17 + 3) {
                           var16 = var8;
                        }
                     }

                     if(var16 != -1) {
                        BoundingBox3D.method52(var16);
                     }

                     isMenuOpen = false;
                     class188.method3796(class56.menuX, class225.menuY, WorldComparator.field265, ScriptEvent.field772);
                  }
               } else {
                  var2 = BoundingBox3D.method51();
                  if((var14 == 1 || !class29.middleMouseMovesCamera && var14 == 4) && var2 >= 0) {
                     var11 = menuTypes[var2];
                     if(var11 == 39 || var11 == 40 || var11 == 41 || var11 == 42 || var11 == 43 || var11 == 33 || var11 == 34 || var11 == 35 || var11 == 36 || var11 == 37 || var11 == 38 || var11 == 1005) {
                        var12 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var13 = class216.getWidget(var5);
                        var8 = WorldComparator.getWidgetConfig(var13);
                        boolean var7 = (var8 >> 28 & 1) != 0;
                        if(var7) {
                           break label281;
                        }

                        int var10 = WorldComparator.getWidgetConfig(var13);
                        boolean var9 = (var10 >> 29 & 1) != 0;
                        if(var9) {
                           break label281;
                        }
                     }
                  }

                  if((var14 == 1 || !class29.middleMouseMovesCamera && var14 == 4) && this.method1194()) {
                     var14 = 2;
                  }

                  if((var14 == 1 || !class29.middleMouseMovesCamera && var14 == 4) && menuOptionCount > 0) {
                     BoundingBox3D.method52(var2);
                  }

                  if(var14 == 2 && menuOptionCount > 0) {
                     this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }
               }

               return;
            }

            if(class265.field3515 != null && !itemBeingDragged && menuOptionCount > 0 && !this.method1194()) {
               class89.method1899(field993, field939);
            }

            itemBeingDragged = false;
            itemPressedDuration = 0;
            if(class265.field3515 != null) {
               class33.method341(class265.field3515);
            }

            class265.field3515 = class216.getWidget(var5);
            field987 = var12;
            field993 = MouseInput.mouseLastPressedX;
            field939 = MouseInput.mouseLastPressedY;
            if(var2 >= 0) {
               ItemContainer.method1055(var2);
            }

            class33.method341(class265.field3515);
         }
      }
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-78"
   )
   final boolean method1194() {
      int var1 = BoundingBox3D.method51();
      return menuOptionCount > 2 && (field855 == 1 && !menuBooleanArray[var1] || class186.method3765(var1));
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "30"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      int var3 = IndexDataBase.fontBold12.getTextWidth("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = IndexDataBase.fontBold12;
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
      if(var8 + var3 > GameEngine.canvasWidth) {
         var8 = GameEngine.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var2 + var4 > IndexFile.canvasHeight) {
         var9 = IndexFile.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      TotalQuantityComparator.region.method2997(class60.plane, var1, var2, false);
      isMenuOpen = true;
      class56.menuX = var8;
      class225.menuY = var9;
      WorldComparator.field265 = var3;
      ScriptEvent.field772 = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2103032529"
   )
   final void method1196(boolean var1) {
      WallObject.method3112(widgetRoot, GameEngine.canvasWidth, IndexFile.canvasHeight, var1);
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Lhs;I)V",
      garbageValue = "-947922450"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class216.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = GameEngine.canvasWidth;
         var4 = IndexFile.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      PendingSpawn.method1593(var1, var3, var4, false);
      class216.method4247(var1, var3, var4);
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "787129537"
   )
   final void method1198() {
      class33.method341(field940);
      ++UnitPriceComparator.field308;
      if(field980 && field1002) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field999;
         var2 -= field921;
         if(var1 < field856) {
            var1 = field856;
         }

         if(var1 + field940.width > field856 + field930.width) {
            var1 = field856 + field930.width - field940.width;
         }

         if(var2 < field1070) {
            var2 = field1070;
         }

         if(var2 + field940.height > field1070 + field930.height) {
            var2 = field1070 + field930.height - field940.height;
         }

         int var3 = var1 - field919;
         int var4 = var2 - field1007;
         int var5 = field940.field2830;
         if(UnitPriceComparator.field308 > field940.field2822 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1008 = true;
         }

         int var6 = var1 - field856 + field930.scrollX;
         int var7 = var2 - field1070 + field930.scrollY;
         ScriptEvent var8;
         if(field940.field2843 != null && field1008) {
            var8 = new ScriptEvent();
            var8.widget = field940;
            var8.field774 = var6;
            var8.field775 = var7;
            var8.objs = field940.field2843;
            class84.method1868(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(field1008) {
               if(field940.field2853 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field940;
                  var8.field774 = var6;
                  var8.field775 = var7;
                  var8.field777 = field1001;
                  var8.objs = field940.field2853;
                  class84.method1868(var8);
               }

               if(field1001 != null && class160.method3261(field940) != null) {
                  PacketNode var9 = Script.method2025(ClientPacket.field2348, field937.field1454);
                  var9.packetBuffer.method3554(field1001.id);
                  var9.packetBuffer.writeIntLE16(field940.index);
                  var9.packetBuffer.writeShortLE(field1001.itemId);
                  var9.packetBuffer.putShort(field1001.index);
                  var9.packetBuffer.method3554(field940.id);
                  var9.packetBuffer.putShort(field940.itemId);
                  field937.method2044(var9);
               }
            } else if(this.method1194()) {
               this.openMenu(field919 + field999, field1007 + field921);
            } else if(menuOptionCount > 0) {
               class89.method1899(field999 + field919, field1007 + field921);
            }

            field940 = null;
         }

      } else {
         if(UnitPriceComparator.field308 > 1) {
            field940 = null;
         }

      }
   }

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "(I)Lja;",
      garbageValue = "162914176"
   )
   public Name vmethod5253() {
      return GroundObject.localPlayer != null?GroundObject.localPlayer.name:null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "40"
   )
   @Export("loadClassFromDescriptor")
   static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(Lbu;I)V",
      garbageValue = "2036464270"
   )
   static final void method1589(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = TotalQuantityComparator.region.method2930(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = TotalQuantityComparator.region.method2931(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = TotalQuantityComparator.region.method2932(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = TotalQuantityComparator.region.method2933(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = TotalQuantityComparator.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1103 = var2;
      var0.field1105 = var3;
      var0.field1104 = var4;
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-454621341"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketNode var8;
      if(var2 == 1) {
         lastLeftClickX = var6;
         lastLeftClickY = var7;
         cursorState = 2;
         field933 = 0;
         destinationX = var0;
         destinationY = var1;
         var8 = Script.method2025(ClientPacket.field2380, field937.field1454);
         var8.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.method3542(ScriptVarType.field169);
         var8.packetBuffer.method3542(var0 + ClanMemberManager.baseX);
         var8.packetBuffer.writeShortLE(WorldMapData.baseY + var1);
         var8.packetBuffer.writeIntLE(class274.field3702);
         var8.packetBuffer.writeShortLE(class18.selectedItemIndex);
         field937.method2044(var8);
      } else if(var2 == 2) {
         lastLeftClickX = var6;
         lastLeftClickY = var7;
         cursorState = 2;
         field933 = 0;
         destinationX = var0;
         destinationY = var1;
         var8 = Script.method2025(ClientPacket.field2362, field937.field1454);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.writeShortLE(field1038);
         var8.packetBuffer.writeIntLE(class249.field3357);
         var8.packetBuffer.putShort(WorldMapData.baseY + var1);
         var8.packetBuffer.putShort(var0 + ClanMemberManager.baseX);
         field937.method2044(var8);
      } else if(var2 == 3) {
         lastLeftClickX = var6;
         lastLeftClickY = var7;
         cursorState = 2;
         field933 = 0;
         destinationX = var0;
         destinationY = var1;
         var8 = Script.method2025(ClientPacket.field2332, field937.field1454);
         var8.packetBuffer.method3542(var0 + ClanMemberManager.baseX);
         var8.packetBuffer.writeShortLE(WorldMapData.baseY + var1);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
         field937.method2044(var8);
      } else if(var2 == 4) {
         lastLeftClickX = var6;
         lastLeftClickY = var7;
         cursorState = 2;
         field933 = 0;
         destinationX = var0;
         destinationY = var1;
         var8 = Script.method2025(ClientPacket.field2364, field937.field1454);
         var8.packetBuffer.writeIntLE16(WorldMapData.baseY + var1);
         var8.packetBuffer.method3542(var0 + ClanMemberManager.baseX);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
         field937.method2044(var8);
      } else if(var2 == 5) {
         lastLeftClickX = var6;
         lastLeftClickY = var7;
         cursorState = 2;
         field933 = 0;
         destinationX = var0;
         destinationY = var1;
         var8 = Script.method2025(ClientPacket.field2346, field937.field1454);
         var8.packetBuffer.writeIntLE16(WorldMapData.baseY + var1);
         var8.packetBuffer.method3535(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.writeIntLE16(var3 >> 14 & 32767);
         var8.packetBuffer.writeIntLE16(var0 + ClanMemberManager.baseX);
         field937.method2044(var8);
      } else if(var2 == 6) {
         lastLeftClickX = var6;
         lastLeftClickY = var7;
         cursorState = 2;
         field933 = 0;
         destinationX = var0;
         destinationY = var1;
         var8 = Script.method2025(ClientPacket.field2400, field937.field1454);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(var0 + ClanMemberManager.baseX);
         var8.packetBuffer.method3542(WorldMapData.baseY + var1);
         field937.method2044(var8);
      } else {
         PacketNode var9;
         NPC var19;
         if(var2 == 7) {
            var19 = cachedNPCs[var3];
            if(var19 != null) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var9 = Script.method2025(ClientPacket.field2413, field937.field1454);
               var9.packetBuffer.writeIntLE16(class18.selectedItemIndex);
               var9.packetBuffer.writeShortLE(var3);
               var9.packetBuffer.putShort(ScriptVarType.field169);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3553(class274.field3702);
               field937.method2044(var9);
            }
         } else if(var2 == 8) {
            var19 = cachedNPCs[var3];
            if(var19 != null) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var9 = Script.method2025(ClientPacket.field2394, field937.field1454);
               var9.packetBuffer.putInt(class249.field3357);
               var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShort(field1038);
               var9.packetBuffer.writeShortLE(var3);
               field937.method2044(var9);
            }
         } else if(var2 == 9) {
            var19 = cachedNPCs[var3];
            if(var19 != null) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var9 = Script.method2025(ClientPacket.field2355, field937.field1454);
               var9.packetBuffer.writeIntLE16(var3);
               var9.packetBuffer.method3535(KeyFocusListener.keyPressed[82]?1:0);
               field937.method2044(var9);
            }
         } else if(var2 == 10) {
            var19 = cachedNPCs[var3];
            if(var19 != null) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var9 = Script.method2025(ClientPacket.field2375, field937.field1454);
               var9.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.writeShortLE(var3);
               field937.method2044(var9);
            }
         } else if(var2 == 11) {
            var19 = cachedNPCs[var3];
            if(var19 != null) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var9 = Script.method2025(ClientPacket.field2351, field937.field1454);
               var9.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.writeIntLE16(var3);
               field937.method2044(var9);
            }
         } else if(var2 == 12) {
            var19 = cachedNPCs[var3];
            if(var19 != null) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var9 = Script.method2025(ClientPacket.field2392, field937.field1454);
               var9.packetBuffer.writeShortLE(var3);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               field937.method2044(var9);
            }
         } else if(var2 == 13) {
            var19 = cachedNPCs[var3];
            if(var19 != null) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var9 = Script.method2025(ClientPacket.field2329, field937.field1454);
               var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3542(var3);
               field937.method2044(var9);
            }
         } else {
            Player var22;
            if(var2 == 14) {
               var22 = cachedPlayers[var3];
               if(var22 != null) {
                  lastLeftClickX = var6;
                  lastLeftClickY = var7;
                  cursorState = 2;
                  field933 = 0;
                  destinationX = var0;
                  destinationY = var1;
                  var9 = Script.method2025(ClientPacket.field2397, field937.field1454);
                  var9.packetBuffer.writeIntLE16(ScriptVarType.field169);
                  var9.packetBuffer.method3542(class18.selectedItemIndex);
                  var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.method3542(var3);
                  var9.packetBuffer.method3554(class274.field3702);
                  field937.method2044(var9);
               }
            } else if(var2 == 15) {
               var22 = cachedPlayers[var3];
               if(var22 != null) {
                  lastLeftClickX = var6;
                  lastLeftClickY = var7;
                  cursorState = 2;
                  field933 = 0;
                  destinationX = var0;
                  destinationY = var1;
                  var9 = Script.method2025(ClientPacket.field2371, field937.field1454);
                  var9.packetBuffer.writeIntLE16(var3);
                  var9.packetBuffer.putInt(class249.field3357);
                  var9.packetBuffer.putShort(field1038);
                  var9.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
                  field937.method2044(var9);
               }
            } else if(var2 == 16) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var8 = Script.method2025(ClientPacket.field2376, field937.field1454);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putInt(class274.field3702);
               var8.packetBuffer.method3542(WorldMapData.baseY + var1);
               var8.packetBuffer.writeIntLE16(class18.selectedItemIndex);
               var8.packetBuffer.method3542(ScriptVarType.field169);
               var8.packetBuffer.putShort(var0 + ClanMemberManager.baseX);
               var8.packetBuffer.writeShortLE(var3);
               field937.method2044(var8);
            } else if(var2 == 17) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var8 = Script.method2025(ClientPacket.field2365, field937.field1454);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(WorldMapData.baseY + var1);
               var8.packetBuffer.writeShortLE(var0 + ClanMemberManager.baseX);
               var8.packetBuffer.method3554(class249.field3357);
               var8.packetBuffer.writeShortLE(field1038);
               var8.packetBuffer.writeIntLE16(var3);
               field937.method2044(var8);
            } else if(var2 == 18) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var8 = Script.method2025(ClientPacket.field2412, field937.field1454);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3542(var0 + ClanMemberManager.baseX);
               var8.packetBuffer.method3542(var3);
               var8.packetBuffer.writeShortLE(WorldMapData.baseY + var1);
               field937.method2044(var8);
            } else if(var2 == 19) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var8 = Script.method2025(ClientPacket.field2416, field937.field1454);
               var8.packetBuffer.method3542(var3);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3542(var0 + ClanMemberManager.baseX);
               var8.packetBuffer.putShort(WorldMapData.baseY + var1);
               field937.method2044(var8);
            } else if(var2 == 20) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var8 = Script.method2025(ClientPacket.field2352, field937.field1454);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.writeIntLE16(WorldMapData.baseY + var1);
               var8.packetBuffer.writeShortLE(var0 + ClanMemberManager.baseX);
               var8.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
               field937.method2044(var8);
            } else if(var2 == 21) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var8 = Script.method2025(ClientPacket.field2402, field937.field1454);
               var8.packetBuffer.writeShortLE(var3);
               var8.packetBuffer.method3542(var0 + ClanMemberManager.baseX);
               var8.packetBuffer.putShort(WorldMapData.baseY + var1);
               var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
               field937.method2044(var8);
            } else if(var2 == 22) {
               lastLeftClickX = var6;
               lastLeftClickY = var7;
               cursorState = 2;
               field933 = 0;
               destinationX = var0;
               destinationY = var1;
               var8 = Script.method2025(ClientPacket.field2368, field937.field1454);
               var8.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(WorldMapData.baseY + var1);
               var8.packetBuffer.putShort(var0 + ClanMemberManager.baseX);
               var8.packetBuffer.putShort(var3);
               field937.method2044(var8);
            } else if(var2 == 23) {
               if(isMenuOpen) {
                  TotalQuantityComparator.region.method2942();
               } else {
                  TotalQuantityComparator.region.method2997(class60.plane, var0, var1, true);
               }
            } else {
               PacketNode var17;
               Widget var25;
               if(var2 == 24) {
                  var25 = class216.getWidget(var1);
                  boolean var16 = true;
                  if(var25.contentType > 0) {
                     var16 = class21.method160(var25);
                  }

                  if(var16) {
                     var17 = Script.method2025(ClientPacket.field2386, field937.field1454);
                     var17.packetBuffer.putInt(var1);
                     field937.method2044(var17);
                  }
               } else {
                  if(var2 == 25) {
                     var25 = class44.getWidgetChild(var1, var0);
                     if(var25 != null) {
                        World.method1632();
                        int var23 = WorldComparator.getWidgetConfig(var25);
                        int var20 = var23 >> 11 & 63;
                        TotalQuantityComparator.method89(var1, var0, var20, var25.itemId);
                        itemSelectionState = 0;
                        field854 = class28.method240(var25);
                        if(field854 == null) {
                           field854 = "Null";
                        }

                        if(var25.hasScript) {
                           field995 = var25.name + class70.getColTags(16777215);
                        } else {
                           field995 = class70.getColTags(65280) + var25.spellName + class70.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     var8 = Script.method2025(ClientPacket.field2411, field937.field1454);
                     field937.method2044(var8);

                     for(WidgetNode var21 = (WidgetNode)componentTable.first(); var21 != null; var21 = (WidgetNode)componentTable.next()) {
                        if(var21.owner == 0 || var21.owner == 3) {
                           class137.method3103(var21, true);
                        }
                     }

                     if(field885 != null) {
                        class33.method341(field885);
                        field885 = null;
                     }
                  } else {
                     int var10;
                     Widget var24;
                     if(var2 == 28) {
                        var8 = Script.method2025(ClientPacket.field2386, field937.field1454);
                        var8.packetBuffer.putInt(var1);
                        field937.method2044(var8);
                        var24 = class216.getWidget(var1);
                        if(var24.dynamicValues != null && var24.dynamicValues[0][0] == 5) {
                           var10 = var24.dynamicValues[0][1];
                           class222.widgetSettings[var10] = 1 - class222.widgetSettings[var10];
                           class1.method1(var10);
                        }
                     } else if(var2 == 29) {
                        var8 = Script.method2025(ClientPacket.field2386, field937.field1454);
                        var8.packetBuffer.putInt(var1);
                        field937.method2044(var8);
                        var24 = class216.getWidget(var1);
                        if(var24.dynamicValues != null && var24.dynamicValues[0][0] == 5) {
                           var10 = var24.dynamicValues[0][1];
                           if(class222.widgetSettings[var10] != var24.field2868[0]) {
                              class222.widgetSettings[var10] = var24.field2868[0];
                              class1.method1(var10);
                           }
                        }
                     } else if(var2 == 30) {
                        if(field885 == null) {
                           var8 = Script.method2025(ClientPacket.field2398, field937.field1454);
                           var8.packetBuffer.writeIntLE(var1);
                           var8.packetBuffer.writeShortLE(var0);
                           field937.method2044(var8);
                           field885 = class44.getWidgetChild(var1, var0);
                           class33.method341(field885);
                        }
                     } else if(var2 == 31) {
                        var8 = Script.method2025(ClientPacket.field2379, field937.field1454);
                        var8.packetBuffer.method3554(var1);
                        var8.packetBuffer.method3542(class18.selectedItemIndex);
                        var8.packetBuffer.putShort(ScriptVarType.field169);
                        var8.packetBuffer.writeShortLE(var0);
                        var8.packetBuffer.method3554(class274.field3702);
                        var8.packetBuffer.writeIntLE16(var3);
                        field937.method2044(var8);
                        mouseCrosshair = 0;
                        class45.field566 = class216.getWidget(var1);
                        pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = Script.method2025(ClientPacket.field2378, field937.field1454);
                        var8.packetBuffer.putInt(class249.field3357);
                        var8.packetBuffer.writeIntLE16(var3);
                        var8.packetBuffer.method3542(field1038);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.putInt(var1);
                        field937.method2044(var8);
                        mouseCrosshair = 0;
                        class45.field566 = class216.getWidget(var1);
                        pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = Script.method2025(ClientPacket.field2367, field937.field1454);
                        var8.packetBuffer.method3553(var1);
                        var8.packetBuffer.writeShortLE(var0);
                        var8.packetBuffer.method3542(var3);
                        field937.method2044(var8);
                        mouseCrosshair = 0;
                        class45.field566 = class216.getWidget(var1);
                        pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = Script.method2025(ClientPacket.field2410, field937.field1454);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.writeShortLE(var3);
                        var8.packetBuffer.putInt(var1);
                        field937.method2044(var8);
                        mouseCrosshair = 0;
                        class45.field566 = class216.getWidget(var1);
                        pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = Script.method2025(ClientPacket.field2361, field937.field1454);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3553(var1);
                        var8.packetBuffer.method3542(var3);
                        field937.method2044(var8);
                        mouseCrosshair = 0;
                        class45.field566 = class216.getWidget(var1);
                        pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = Script.method2025(ClientPacket.field2340, field937.field1454);
                        var8.packetBuffer.method3542(var0);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putShort(var3);
                        field937.method2044(var8);
                        mouseCrosshair = 0;
                        class45.field566 = class216.getWidget(var1);
                        pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = Script.method2025(ClientPacket.field2408, field937.field1454);
                        var8.packetBuffer.writeIntLE16(var0);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3553(var1);
                        field937.method2044(var8);
                        mouseCrosshair = 0;
                        class45.field566 = class216.getWidget(var1);
                        pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           World.method1632();
                           var25 = class216.getWidget(var1);
                           itemSelectionState = 1;
                           class18.selectedItemIndex = var0;
                           class274.field3702 = var1;
                           ScriptVarType.field169 = var3;
                           class33.method341(var25);
                           lastSelectedItemName = class70.getColTags(16748608) + ItemContainer.getItemDefinition(var3).name + class70.getColTags(16777215);
                           if(lastSelectedItemName == null) {
                              lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = Script.method2025(ClientPacket.field2387, field937.field1454);
                           var8.packetBuffer.method3554(var1);
                           var8.packetBuffer.method3542(var3);
                           var8.packetBuffer.writeShortLE(var0);
                           field937.method2044(var8);
                           mouseCrosshair = 0;
                           class45.field566 = class216.getWidget(var1);
                           pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = Script.method2025(ClientPacket.field2399, field937.field1454);
                           var8.packetBuffer.method3542(var0);
                           var8.packetBuffer.method3553(var1);
                           var8.packetBuffer.writeShortLE(var3);
                           field937.method2044(var8);
                           mouseCrosshair = 0;
                           class45.field566 = class216.getWidget(var1);
                           pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = Script.method2025(ClientPacket.field2354, field937.field1454);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.writeShortLE(var3);
                           field937.method2044(var8);
                           mouseCrosshair = 0;
                           class45.field566 = class216.getWidget(var1);
                           pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = Script.method2025(ClientPacket.field2343, field937.field1454);
                           var8.packetBuffer.writeShortLE(var0);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.method3553(var1);
                           field937.method2044(var8);
                           mouseCrosshair = 0;
                           class45.field566 = class216.getWidget(var1);
                           pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = Script.method2025(ClientPacket.field2363, field937.field1454);
                           var8.packetBuffer.method3542(var0);
                           var8.packetBuffer.method3542(var3);
                           var8.packetBuffer.method3554(var1);
                           field937.method2044(var8);
                           mouseCrosshair = 0;
                           class45.field566 = class216.getWidget(var1);
                           pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var22 = cachedPlayers[var3];
                           if(var22 != null) {
                              lastLeftClickX = var6;
                              lastLeftClickY = var7;
                              cursorState = 2;
                              field933 = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = Script.method2025(ClientPacket.field2384, field937.field1454);
                              var9.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeShortLE(var3);
                              field937.method2044(var9);
                           }
                        } else if(var2 == 45) {
                           var22 = cachedPlayers[var3];
                           if(var22 != null) {
                              lastLeftClickX = var6;
                              lastLeftClickY = var7;
                              cursorState = 2;
                              field933 = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = Script.method2025(ClientPacket.field2407, field937.field1454);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              field937.method2044(var9);
                           }
                        } else if(var2 == 46) {
                           var22 = cachedPlayers[var3];
                           if(var22 != null) {
                              lastLeftClickX = var6;
                              lastLeftClickY = var7;
                              cursorState = 2;
                              field933 = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = Script.method2025(ClientPacket.field2337, field937.field1454);
                              var9.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeShortLE(var3);
                              field937.method2044(var9);
                           }
                        } else if(var2 == 47) {
                           var22 = cachedPlayers[var3];
                           if(var22 != null) {
                              lastLeftClickX = var6;
                              lastLeftClickY = var7;
                              cursorState = 2;
                              field933 = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = Script.method2025(ClientPacket.field2349, field937.field1454);
                              var9.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeShortLE(var3);
                              field937.method2044(var9);
                           }
                        } else if(var2 == 48) {
                           var22 = cachedPlayers[var3];
                           if(var22 != null) {
                              lastLeftClickX = var6;
                              lastLeftClickY = var7;
                              cursorState = 2;
                              field933 = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = Script.method2025(ClientPacket.field2385, field937.field1454);
                              var9.packetBuffer.method3542(var3);
                              var9.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
                              field937.method2044(var9);
                           }
                        } else if(var2 == 49) {
                           var22 = cachedPlayers[var3];
                           if(var22 != null) {
                              lastLeftClickX = var6;
                              lastLeftClickY = var7;
                              cursorState = 2;
                              field933 = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = Script.method2025(ClientPacket.field2404, field937.field1454);
                              var9.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              field937.method2044(var9);
                           }
                        } else if(var2 == 50) {
                           var22 = cachedPlayers[var3];
                           if(var22 != null) {
                              lastLeftClickX = var6;
                              lastLeftClickY = var7;
                              cursorState = 2;
                              field933 = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = Script.method2025(ClientPacket.field2372, field937.field1454);
                              var9.packetBuffer.method3533(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeShortLE(var3);
                              field937.method2044(var9);
                           }
                        } else if(var2 == 51) {
                           var22 = cachedPlayers[var3];
                           if(var22 != null) {
                              lastLeftClickX = var6;
                              lastLeftClickY = var7;
                              cursorState = 2;
                              field933 = 0;
                              destinationX = var0;
                              destinationY = var1;
                              var9 = Script.method2025(ClientPacket.field2339, field937.field1454);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              field937.method2044(var9);
                           }
                        } else {
                           label1091: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var25 = class44.getWidgetChild(var1, var0);
                                    if(var25 != null) {
                                       var9 = Script.method2025(ClientPacket.field2377, field937.field1454);
                                       var9.packetBuffer.writeIntLE16(field1038);
                                       var9.packetBuffer.writeIntLE16(field1060);
                                       var9.packetBuffer.writeShortLE(var25.itemId);
                                       var9.packetBuffer.method3553(class249.field3357);
                                       var9.packetBuffer.putShort(var0);
                                       var9.packetBuffer.writeIntLE(var1);
                                       field937.method2044(var9);
                                    }
                                    break label1091;
                                 }

                                 if(var2 == 1001) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field933 = 0;
                                    destinationX = var0;
                                    destinationY = var1;
                                    var8 = Script.method2025(ClientPacket.field2341, field937.field1454);
                                    var8.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?1:0);
                                    var8.packetBuffer.method3542(WorldMapData.baseY + var1);
                                    var8.packetBuffer.writeShortLE(var0 + ClanMemberManager.baseX);
                                    var8.packetBuffer.method3542(var3 >> 14 & 32767);
                                    field937.method2044(var8);
                                    break label1091;
                                 }

                                 if(var2 == 1002) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field933 = 0;
                                    var8 = Script.method2025(ClientPacket.field2350, field937.field1454);
                                    var8.packetBuffer.putShort(var3 >> 14 & 32767);
                                    field937.method2044(var8);
                                    break label1091;
                                 }

                                 if(var2 == 1003) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field933 = 0;
                                    var19 = cachedNPCs[var3];
                                    if(var19 != null) {
                                       NPCComposition var26 = var19.composition;
                                       if(var26.configs != null) {
                                          var26 = var26.transform();
                                       }

                                       if(var26 != null) {
                                          var17 = Script.method2025(ClientPacket.field2327, field937.field1454);
                                          var17.packetBuffer.writeIntLE16(var26.id);
                                          field937.method2044(var17);
                                       }
                                    }
                                    break label1091;
                                 }

                                 if(var2 == 1004) {
                                    lastLeftClickX = var6;
                                    lastLeftClickY = var7;
                                    cursorState = 2;
                                    field933 = 0;
                                    var8 = Script.method2025(ClientPacket.field2391, field937.field1454);
                                    var8.packetBuffer.writeIntLE16(var3);
                                    field937.method2044(var8);
                                    break label1091;
                                 }

                                 if(var2 == 1005) {
                                    var25 = class216.getWidget(var1);
                                    if(var25 != null && var25.itemQuantities[var0] >= 100000) {
                                       SoundTaskDataProvider.sendGameMessage(27, "", var25.itemQuantities[var0] + " x " + ItemContainer.getItemDefinition(var3).name);
                                    } else {
                                       var9 = Script.method2025(ClientPacket.field2391, field937.field1454);
                                       var9.packetBuffer.writeIntLE16(var3);
                                       field937.method2044(var9);
                                    }

                                    mouseCrosshair = 0;
                                    class45.field566 = class216.getWidget(var1);
                                    pressedItemIndex = var0;
                                    break label1091;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1010 || var2 == 1011 || var2 == 1009 || var2 == 1008 || var2 == 1012) {
                                       class175.renderOverview.method5977(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label1091;
                                 }
                              }

                              var25 = class44.getWidgetChild(var1, var0);
                              if(var25 != null) {
                                 int var27 = var25.itemId;
                                 Widget var28 = class44.getWidgetChild(var1, var0);
                                 if(var28 != null) {
                                    if(var28.field2846 != null) {
                                       ScriptEvent var18 = new ScriptEvent();
                                       var18.widget = var28;
                                       var18.field781 = var3;
                                       var18.string = var5;
                                       var18.objs = var28.field2846;
                                       class84.method1868(var18);
                                    }

                                    boolean var11 = true;
                                    if(var28.contentType > 0) {
                                       var11 = class21.method160(var28);
                                    }

                                    if(var11) {
                                       int var13 = WorldComparator.getWidgetConfig(var28);
                                       int var14 = var3 - 1;
                                       boolean var12 = (var13 >> var14 + 1 & 1) != 0;
                                       if(var12) {
                                          PacketNode var15;
                                          if(var3 == 1) {
                                             var15 = Script.method2025(ClientPacket.field2395, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }

                                          if(var3 == 2) {
                                             var15 = Script.method2025(ClientPacket.field2360, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }

                                          if(var3 == 3) {
                                             var15 = Script.method2025(ClientPacket.field2335, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }

                                          if(var3 == 4) {
                                             var15 = Script.method2025(ClientPacket.field2336, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }

                                          if(var3 == 5) {
                                             var15 = Script.method2025(ClientPacket.field2381, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }

                                          if(var3 == 6) {
                                             var15 = Script.method2025(ClientPacket.field2353, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }

                                          if(var3 == 7) {
                                             var15 = Script.method2025(ClientPacket.field2358, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }

                                          if(var3 == 8) {
                                             var15 = Script.method2025(ClientPacket.field2321, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }

                                          if(var3 == 9) {
                                             var15 = Script.method2025(ClientPacket.field2359, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }

                                          if(var3 == 10) {
                                             var15 = Script.method2025(ClientPacket.field2344, field937.field1454);
                                             var15.packetBuffer.putInt(var1);
                                             var15.packetBuffer.putShort(var0);
                                             var15.packetBuffer.putShort(var27);
                                             field937.method2044(var15);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if(itemSelectionState != 0) {
         itemSelectionState = 0;
         class33.method341(class216.getWidget(class274.field3702));
      }

      if(spellSelected) {
         World.method1632();
      }

      if(class45.field566 != null && mouseCrosshair == 0) {
         class33.method341(class45.field566);
      }

   }
}
