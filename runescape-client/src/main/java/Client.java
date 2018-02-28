import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
public final class Client extends GameEngine implements class288 {
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = 1793331451
   )
   static int field877;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -391969985
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      longValue = -3606005832061712495L
   )
   static long field1017;
   @ObfuscatedName("ol")
   static boolean field1039;
   @ObfuscatedName("mu")
   static boolean[] field979;
   @ObfuscatedName("mb")
   static boolean[] field1031;
   @ObfuscatedName("mx")
   static boolean[] field820;
   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "Lbv;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("mm")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 162971697
   )
   static int field997;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = -609217635
   )
   static int field1015;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 894791415
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("mt")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("mw")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("mk")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("mj")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ml")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = 530430155
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   static final class70 field1076;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = 1538109163
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 365270837
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 1798026239
   )
   static int field1040;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 1281380049
   )
   static int field1041;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 33453099
   )
   @Export("queuedSoundEffectCount")
   static int queuedSoundEffectCount;
   @ObfuscatedName("oa")
   @Export("queuedSoundEffectIDs")
   static int[] queuedSoundEffectIDs;
   @ObfuscatedName("mg")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   static Deque field821;
   @ObfuscatedName("qr")
   static int[] field1053;
   @ObfuscatedName("om")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("qy")
   static int[] field1078;
   @ObfuscatedName("ox")
   @Export("unknownSoundValues2")
   static int[] unknownSoundValues2;
   @ObfuscatedName("oi")
   @ObfuscatedSignature(
      signature = "[Lch;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("ql")
   static ArrayList field932;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 1102764251
   )
   static int field1075;
   @ObfuscatedName("oq")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 1885788119
   )
   static int field1077;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = 161815229
   )
   static int field907;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -1102419375
   )
   static int field955;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      longValue = 2098680528327451847L
   )
   static long field909;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -1585803661
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("pk")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   static PlayerComposition field1068;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = -172350585
   )
   static int field1021;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -97632921
   )
   static int field1070;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 962226607
   )
   static int field998;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 957301637
   )
   static int field834;
   @ObfuscatedName("oj")
   static boolean field983;
   @ObfuscatedName("pb")
   static boolean[] field1050;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = -7020957
   )
   static int field971;
   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "[Lf;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -1718438401
   )
   static int field999;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = -742928007
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 1080202703
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("pu")
   static int[] field1051;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = -1930907711
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 1194188119
   )
   static int field1030;
   @ObfuscatedName("pi")
   static int[] field1052;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 1136606733
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("pv")
   static int[] field889;
   @ObfuscatedName("pn")
   static int[] field1054;
   @ObfuscatedName("nx")
   static int[] field850;
   @ObfuscatedName("nv")
   @ObfuscatedSignature(
      signature = "[Llm;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("nt")
   static int[] field1037;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 238310697
   )
   static int field884;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 883643001
   )
   static int field1025;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -2131594845
   )
   static int field1038;
   @ObfuscatedName("nq")
   static int[] field956;
   @ObfuscatedName("np")
   static int[] field896;
   @ObfuscatedName("mq")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   static Deque field992;
   @ObfuscatedName("me")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   static Deque field1049;
   @ObfuscatedName("pt")
   static short field947;
   @ObfuscatedName("pd")
   static short field1055;
   @ObfuscatedName("ph")
   static short field1061;
   @ObfuscatedName("pl")
   static short field1062;
   @ObfuscatedName("pg")
   static short field1060;
   @ObfuscatedName("pm")
   static short field1058;
   @ObfuscatedName("ps")
   static short field899;
   @ObfuscatedName("pz")
   static short field1059;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 480223811
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("nz")
   static long[] field882;
   @ObfuscatedName("nw")
   static String field1022;
   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   static OwnWorldComparator field860;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 1982090083
   )
   static int field1024;
   @ObfuscatedName("mc")
   static int[] field1019;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfq;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("an")
   static boolean field905;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1198879397
   )
   @Export("world")
   public static int world;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1814297257
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1356640039
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bi")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("br")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -717029529
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1388518439
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("bw")
   static boolean field828;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1400660375
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      longValue = -485939503905638407L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 2116663591
   )
   static int field831;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 420234793
   )
   static int field832;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1256168609
   )
   static int field833;
   @ObfuscatedName("by")
   static boolean field1018;
   @ObfuscatedName("bq")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -2060890807
   )
   static int field836;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1098805457
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 981203675
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -674445403
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -804537629
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -236597103
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 216448995
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 227062285
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -122850543
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1196209403
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1348062823
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -502405949
   )
   static int field849;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -24041151
   )
   static int field946;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -872721677
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 1926260239
   )
   static int field853;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -1294786383
   )
   static int field861;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 246791085
   )
   static int field1008;
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   static class157 field856;
   @ObfuscatedName("dk")
   static byte[] field857;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "[Lcg;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 527236495
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dz")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -2120922057
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ee")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   public static final NetWriter field863;
   @ObfuscatedName("ei")
   @ObfuscatedGetter(
      intValue = 1903432239
   )
   static int field864;
   @ObfuscatedName("ev")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("el")
   static boolean field866;
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   static class310 field912;
   @ObfuscatedName("ew")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 1656482861
   )
   static int field862;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -2026860921
   )
   static int field870;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -1359625111
   )
   static int field844;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -397481267
   )
   static int field872;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = -452761493
   )
   static int field873;
   @ObfuscatedName("fc")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fk")
   @Export("instanceTemplateChunks")
   static int[][][] instanceTemplateChunks;
   @ObfuscatedName("ff")
   static final int[] field851;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -1019330535
   )
   static int field878;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -1026527071
   )
   static int field957;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -975494823
   )
   static int field880;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 489595851
   )
   static int field881;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = 845008321
   )
   static int field1035;
   @ObfuscatedName("gr")
   static boolean field883;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1261890445
   )
   static int field855;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -2142302445
   )
   @Export("cameraPitchTarget")
   static int cameraPitchTarget;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -289845751
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 692394475
   )
   static int field964;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 1339136823
   )
   static int field944;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1956551873
   )
   static int field1011;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1077779239
   )
   static int field890;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 497071917
   )
   static int field891;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -1226944167
   )
   static int field927;
   @ObfuscatedName("gg")
   static boolean field893;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 2026661663
   )
   static int field894;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 699356231
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -853695983
   )
   @Export("maxOverheadTexts")
   static int maxOverheadTexts;
   @ObfuscatedName("gw")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("gv")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("ga")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("hz")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("hj")
   static int[] field901;
   @ObfuscatedName("hk")
   static int[] field902;
   @ObfuscatedName("hl")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("he")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("hh")
   static int[][] field1057;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1920717027
   )
   static int field868;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 589277841
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 1514984809
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -1918347083
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = -564693961
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 1983141171
   )
   static int field911;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 1190999025
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -1732853731
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 1643068893
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 82305643
   )
   static int field934;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 881000237
   )
   static int field916;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 302631927
   )
   static int field917;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 1930142575
   )
   static int field918;
   @ObfuscatedName("hq")
   @Export("itemBeingDragged")
   static boolean itemBeingDragged;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 1016298759
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -1771893549
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "[Lbl;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -48282309
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 980567585
   )
   static int field1028;
   @ObfuscatedName("ic")
   static boolean field925;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = 2020362047
   )
   static int field926;
   @ObfuscatedName("il")
   static int[] field892;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("id")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("ih")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("ik")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("ib")
   static int[] field993;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 1210901719
   )
   static int field972;
   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "[[[Lhh;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("in")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ia")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("io")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1271474807
   )
   static int field940;
   @ObfuscatedName("jt")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 846521463
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("je")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jn")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jf")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("jm")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("jr")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("jy")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("jh")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("js")
   static boolean field950;
   @ObfuscatedName("jx")
   static boolean field951;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = 1146771313
   )
   static int field952;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 882035257
   )
   static int field953;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -578920363
   )
   static int field933;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -920901797
   )
   static int field879;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 1264128599
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("kc")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -1188339327
   )
   static int field959;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = -431746265
   )
   static int field960;
   @ObfuscatedName("kp")
   static String field961;
   @ObfuscatedName("km")
   static String field962;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -734045005
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -1850550749
   )
   static int field965;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -1868639811
   )
   static int field966;
   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field930;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 1122382749
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -655743757
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -77541857
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -1488050381
   )
   static int field996;
   @ObfuscatedName("ks")
   static boolean field1027;
   @ObfuscatedName("ka")
   static boolean field1000;
   @ObfuscatedName("ke")
   @Export("numberMenuOptions")
   static boolean numberMenuOptions;
   @ObfuscatedName("kl")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field975;
   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field976;
   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field977;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 133843135
   )
   static int field1023;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -1633969939
   )
   static int field914;
   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field980;
   @ObfuscatedName("ko")
   static boolean field978;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -2074565833
   )
   static int field982;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 991074049
   )
   static int field1004;
   @ObfuscatedName("lj")
   static boolean field984;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -1654070271
   )
   static int field1014;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -470498387
   )
   static int field986;
   @ObfuscatedName("lt")
   static boolean field987;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = 1647702211
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("ll")
   static int[] field990;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = 1590942153
   )
   static int field991;
   @ObfuscatedName("lx")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -1975432743
   )
   static int field1016;
   @ObfuscatedName("la")
   static int[] field994;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1512203095
   )
   static int field995;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -726235303
   )
   @Export("chatCycle")
   static int chatCycle;

   static {
      field905 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field828 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = 1L;
      field831 = -1;
      field832 = -1;
      field833 = -1;
      field1018 = true;
      displayFps = false;
      field836 = 0;
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
      field849 = 0;
      field946 = 0;
      loginState = 0;
      field853 = 0;
      field861 = 0;
      field1008 = 0;
      field856 = class157.field2119;
      field857 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field863 = new NetWriter();
      field864 = 0;
      socketError = false;
      field866 = true;
      field912 = new class310();
      fontsMap = new HashMap();
      field862 = 0;
      field870 = 1;
      field844 = 0;
      field872 = 1;
      field873 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      instanceTemplateChunks = new int[4][13][13];
      field851 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field878 = 0;
      field957 = 2301979;
      field880 = 5063219;
      field881 = 3353893;
      field1035 = 7759444;
      field883 = false;
      field855 = 0;
      cameraPitchTarget = 128;
      mapAngle = 0;
      field964 = 0;
      field944 = 0;
      field1011 = 0;
      field890 = 0;
      field891 = 50;
      field927 = 0;
      field893 = false;
      field894 = 0;
      overheadTextCount = 0;
      maxOverheadTexts = 50;
      overheadTextsX = new int[maxOverheadTexts];
      overheadTextsY = new int[maxOverheadTexts];
      overheadTextsOffsetY = new int[maxOverheadTexts];
      overheadTextsOffsetX = new int[maxOverheadTexts];
      field901 = new int[maxOverheadTexts];
      field902 = new int[maxOverheadTexts];
      overheadTextsCyclesRemaining = new int[maxOverheadTexts];
      overheadTexts = new String[maxOverheadTexts];
      field1057 = new int[104][104];
      field868 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field911 = 0;
      cursorState = 0;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field934 = 0;
      field916 = 0;
      field917 = 0;
      field918 = 0;
      itemBeingDragged = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1028 = 0;
      field925 = true;
      field926 = 0;
      field892 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field993 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field972 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field940 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field950 = false;
      field951 = false;
      field952 = -1;
      field953 = -1;
      field933 = 0;
      field879 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field959 = -1;
      field960 = -1;
      field961 = null;
      field962 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field965 = 0;
      field966 = 0;
      field930 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field996 = -1;
      field1027 = false;
      field1000 = false;
      numberMenuOptions = false;
      field975 = null;
      field976 = null;
      field977 = null;
      field1023 = 0;
      field914 = 0;
      field980 = null;
      field978 = false;
      field982 = -1;
      field1004 = -1;
      field984 = false;
      field1014 = -1;
      field986 = -1;
      field987 = false;
      cycleCntr = 1;
      field990 = new int[32];
      field991 = 0;
      interfaceItemTriggers = new int[32];
      field1016 = 0;
      field994 = new int[32];
      field995 = 0;
      chatCycle = 0;
      field997 = 0;
      field998 = 0;
      field999 = 0;
      field884 = 0;
      field907 = 0;
      mouseWheelRotation = 0;
      field821 = new Deque();
      field992 = new Deque();
      field1049 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field877 = -2;
      field979 = new boolean[100];
      field820 = new boolean[100];
      field1031 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1017 = 0L;
      isResized = true;
      field1019 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field1021 = 0;
      field1022 = "";
      field882 = new long[100];
      field1024 = 0;
      field1025 = 0;
      field896 = new int[128];
      field956 = new int[128];
      field909 = -1L;
      field1077 = -1;
      field1030 = 0;
      field850 = new int[1000];
      field1037 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field834 = 0;
      field971 = 255;
      field1015 = -1;
      field1039 = false;
      field1040 = 127;
      field1041 = 127;
      queuedSoundEffectCount = 0;
      queuedSoundEffectIDs = new int[50];
      unknownSoundValues1 = new int[50];
      unknownSoundValues2 = new int[50];
      soundLocations = new int[50];
      audioEffects = new SoundEffect[50];
      field983 = false;
      field1050 = new boolean[5];
      field1051 = new int[5];
      field1052 = new int[5];
      field889 = new int[5];
      field1054 = new int[5];
      field1055 = 256;
      field947 = 205;
      field899 = 256;
      field1058 = 320;
      field1059 = 1;
      field1060 = 32767;
      field1061 = 1;
      field1062 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      scale = 0;
      field1068 = new PlayerComposition();
      field955 = -1;
      field1070 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field860 = new OwnWorldComparator();
      field932 = new ArrayList(10);
      field1075 = 0;
      field1076 = new class70();
      field1053 = new int[50];
      field1078 = new int[50];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1654758683"
   )
   protected final void vmethod1242() {
      field1017 = class188.currentTimeMs() + 500L;
      this.method1243();
      if(widgetRoot != -1) {
         this.method1491(true);
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1837026212"
   )
   @Export("setUp")
   protected final void setUp() {
      int[] var1 = new int[]{20, 260, 10000};
      int[] var2 = new int[]{1000, 100, 500};
      if(var1 != null && var2 != null) {
         class194.field2547 = var1;
         class249.field3284 = new int[var1.length];
         class317.field3873 = new byte[var1.length][][];

         for(int var3 = 0; var3 < class194.field2547.length; ++var3) {
            class317.field3873[var3] = new byte[var2[var3]][];
         }
      } else {
         class194.field2547 = null;
         class249.field3284 = null;
         class317.field3873 = null;
      }

      class79.port1 = socketType == 0?43594:world + 40000;
      class3.port2 = socketType == 0?443:world + 50000;
      ScriptEvent.myWorldPort = class79.port1;
      PlayerComposition.colorsToFind = class234.field2762;
      PlayerComposition.colorsToReplace = class234.field2756;
      PlayerComposition.field2743 = class234.field2757;
      PlayerComposition.field2748 = class234.field2761;
      class46.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      class18.mouseWheel = this.mouseWheel();
      class162.indexStore255 = new IndexFile(255, class166.dat2File, class166.idx255File, 500000);
      FileOnDisk var4 = null;
      Preferences var5 = new Preferences();

      try {
         var4 = WorldComparator.getPreferencesFile("", class35.field456.name, false);
         byte[] var6 = new byte[(int)var4.length()];

         int var8;
         for(int var7 = 0; var7 < var6.length; var7 += var8) {
            var8 = var4.read(var6, var7, var6.length - var7);
            if(var8 == -1) {
               throw new IOException();
            }
         }

         var5 = new Preferences(new Buffer(var6));
      } catch (Exception var12) {
         ;
      }

      try {
         if(var4 != null) {
            var4.close();
         }
      } catch (Exception var11) {
         ;
      }

      preferences = var5;
      this.setUpClipboard();
      String var13 = BoundingBox3DDrawMode.field254;
      class56.field612 = this;
      if(var13 != null) {
         class56.field616 = var13;
      }

      if(socketType != 0) {
         displayFps = true;
      }

      int var10 = preferences.screenType;
      field1017 = 0L;
      if(var10 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      if(class70.method1179() == 1) {
         RenderOverview.clientInstance.method862(765, 503);
      } else {
         RenderOverview.clientInstance.method862(7680, 2160);
      }

      if(gameState >= 25) {
         Resampler.method2310();
      }

      ContextMenuRow.friendManager = new FriendManager(class234.loginType);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1630438028"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      DState.method3525();
      ScriptState.method1103();
      class45.method681();
      SoundTask.method2271();
      MouseInput var1 = MouseInput.mouse;
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

      int var32;
      if(class18.mouseWheel != null) {
         var32 = class18.mouseWheel.useRotation();
         mouseWheelRotation = var32;
      }

      if(gameState == 0) {
         class94.load();
         GameEngine.timer.vmethod3305();

         for(var32 = 0; var32 < 32; ++var32) {
            GameEngine.field639[var32] = 0L;
         }

         for(var32 = 0; var32 < 32; ++var32) {
            GameEngine.field634[var32] = 0L;
         }

         GameEngine.field624 = 0;
      } else if(gameState == 5) {
         LoginPacket.method3436(this);
         class94.load();
         GameEngine.timer.vmethod3305();

         for(var32 = 0; var32 < 32; ++var32) {
            GameEngine.field639[var32] = 0L;
         }

         for(var32 = 0; var32 < 32; ++var32) {
            GameEngine.field634[var32] = 0L;
         }

         GameEngine.field624 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            LoginPacket.method3436(this);
            this.method1240();
         } else if(gameState == 25) {
            MapIconReference.flush(false);
            field862 = 0;
            boolean var46 = true;

            int var33;
            for(var33 = 0; var33 < class157.field2120.length; ++var33) {
               if(class43.landMapFileIds[var33] != -1 && class157.field2120[var33] == null) {
                  class157.field2120[var33] = Script.indexMaps.getConfigData(class43.landMapFileIds[var33], 0);
                  if(class157.field2120[var33] == null) {
                     var46 = false;
                     ++field862;
                  }
               }

               if(class40.landRegionFileIds[var33] != -1 && KeyFocusListener.field589[var33] == null) {
                  KeyFocusListener.field589[var33] = Script.indexMaps.getConfigDataKeys(class40.landRegionFileIds[var33], 0, FriendManager.xteaKeys[var33]);
                  if(KeyFocusListener.field589[var33] == null) {
                     var46 = false;
                     ++field862;
                  }
               }
            }

            if(!var46) {
               field873 = 1;
            } else {
               field844 = 0;
               var46 = true;

               int var4;
               int var5;
               for(var33 = 0; var33 < class157.field2120.length; ++var33) {
                  byte[] var3 = KeyFocusListener.field589[var33];
                  if(var3 != null) {
                     var4 = (IndexData.mapRegions[var33] >> 8) * 64 - ScriptState.baseX;
                     var5 = (IndexData.mapRegions[var33] & 255) * 64 - WorldMapType1.baseY;
                     if(isDynamicRegion) {
                        var4 = 10;
                        var5 = 10;
                     }

                     var46 &= WorldMapManager.method610(var3, var4, var5);
                  }
               }

               if(!var46) {
                  field873 = 2;
               } else {
                  if(field873 != 0) {
                     class235.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  class45.method681();
                  class184.method3455();
                  class45.method681();
                  GameObject.region.reset();
                  class45.method681();
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

                  class45.method681();
                  class61.field686 = 99;
                  class61.field687 = new byte[4][104][104];
                  class235.field2764 = new byte[4][104][104];
                  ContextMenuRow.field1282 = new byte[4][104][104];
                  BaseVarType.field27 = new byte[4][104][104];
                  class56.field619 = new int[4][105][105];
                  class188.field2488 = new byte[4][105][105];
                  PacketNode.field2469 = new int[105][105];
                  class231.field2738 = new int[104];
                  Size.field334 = new int[104];
                  class61.field684 = new int[104];
                  class61.field692 = new int[104];
                  ScriptState.field700 = new int[104];
                  var33 = class157.field2120.length;

                  for(class79 var45 = (class79)class79.field1210.getFront(); var45 != null; var45 = (class79)class79.field1210.getNext()) {
                     if(var45.field1201 != null) {
                        KeyFocusListener.field583.method2069(var45.field1201);
                        var45.field1201 = null;
                     }

                     if(var45.field1213 != null) {
                        KeyFocusListener.field583.method2069(var45.field1213);
                        var45.field1213 = null;
                     }
                  }

                  class79.field1210.clear();
                  MapIconReference.flush(true);
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
                  int var36;
                  if(!isDynamicRegion) {
                     byte[] var6;
                     for(var34 = 0; var34 < var33; ++var34) {
                        var4 = (IndexData.mapRegions[var34] >> 8) * 64 - ScriptState.baseX;
                        var5 = (IndexData.mapRegions[var34] & 255) * 64 - WorldMapType1.baseY;
                        var6 = class157.field2120[var34];
                        if(var6 != null) {
                           class45.method681();
                           Varcs.method1983(var6, var4, var5, class152.field2090 * 8 - 48, class151.field2086 * 8 - 48, collisionMaps);
                        }
                     }

                     for(var34 = 0; var34 < var33; ++var34) {
                        var4 = (IndexData.mapRegions[var34] >> 8) * 64 - ScriptState.baseX;
                        var5 = (IndexData.mapRegions[var34] & 255) * 64 - WorldMapType1.baseY;
                        var6 = class157.field2120[var34];
                        if(var6 == null && class151.field2086 < 800) {
                           class45.method681();
                           Widget.method4469(var4, var5, 64, 64);
                        }
                     }

                     MapIconReference.flush(true);

                     for(var34 = 0; var34 < var33; ++var34) {
                        byte[] var35 = KeyFocusListener.field589[var34];
                        if(var35 != null) {
                           var5 = (IndexData.mapRegions[var34] >> 8) * 64 - ScriptState.baseX;
                           var36 = (IndexData.mapRegions[var34] & 255) * 64 - WorldMapType1.baseY;
                           class45.method681();
                           Region var7 = GameObject.region;
                           CollisionData[] var8 = collisionMaps;
                           Buffer var9 = new Buffer(var35);
                           var10 = -1;

                           while(true) {
                              var11 = var9.getUSmart();
                              if(var11 == 0) {
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;

                              while(true) {
                                 var13 = var9.getUSmart();
                                 if(var13 == 0) {
                                    break;
                                 }

                                 var12 += var13 - 1;
                                 int var14 = var12 & 63;
                                 var15 = var12 >> 6 & 63;
                                 var16 = var12 >> 12;
                                 var17 = var9.readUnsignedByte();
                                 var18 = var17 >> 2;
                                 int var19 = var17 & 3;
                                 var20 = var5 + var15;
                                 var21 = var36 + var14;
                                 if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                    var22 = var16;
                                    if((class61.tileSettings[1][var20][var21] & 2) == 2) {
                                       var22 = var16 - 1;
                                    }

                                    CollisionData var23 = null;
                                    if(var22 >= 0) {
                                       var23 = var8[var22];
                                    }

                                    class19.addObject(var16, var20, var21, var10, var19, var18, var7, var23);
                                 }
                              }
                           }
                        }
                     }
                  }

                  int var37;
                  int var38;
                  int var39;
                  if(isDynamicRegion) {
                     var34 = 0;

                     label584:
                     while(true) {
                        if(var34 >= 4) {
                           for(var34 = 0; var34 < 13; ++var34) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = instanceTemplateChunks[0][var34][var4];
                                 if(var5 == -1) {
                                    Widget.method4469(var34 * 8, var4 * 8, 8, 8);
                                 }
                              }
                           }

                           MapIconReference.flush(true);
                           var34 = 0;

                           while(true) {
                              if(var34 >= 4) {
                                 break label584;
                              }

                              class45.method681();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var36 = instanceTemplateChunks[var34][var4][var5];
                                    if(var36 != -1) {
                                       var37 = var36 >> 24 & 3;
                                       var38 = var36 >> 1 & 3;
                                       var39 = var36 >> 14 & 1023;
                                       var10 = var36 >> 3 & 2047;
                                       var11 = (var39 / 8 << 8) + var10 / 8;

                                       for(var12 = 0; var12 < IndexData.mapRegions.length; ++var12) {
                                          if(IndexData.mapRegions[var12] == var11 && KeyFocusListener.field589[var12] != null) {
                                             class80.method1814(KeyFocusListener.field589[var12], var34, var4 * 8, var5 * 8, var37, (var39 & 7) * 8, (var10 & 7) * 8, var38, GameObject.region, collisionMaps);
                                             break;
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var34;
                           }
                        }

                        class45.method681();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var48 = false;
                              var37 = instanceTemplateChunks[var34][var4][var5];
                              if(var37 != -1) {
                                 var38 = var37 >> 24 & 3;
                                 var39 = var37 >> 1 & 3;
                                 var10 = var37 >> 14 & 1023;
                                 var11 = var37 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(var13 = 0; var13 < IndexData.mapRegions.length; ++var13) {
                                    if(IndexData.mapRegions[var13] == var12 && class157.field2120[var13] != null) {
                                       byte[] var40 = class157.field2120[var13];
                                       var15 = var4 * 8;
                                       var16 = var5 * 8;
                                       var17 = (var10 & 7) * 8;
                                       var18 = (var11 & 7) * 8;
                                       CollisionData[] var41 = collisionMaps;

                                       for(var20 = 0; var20 < 8; ++var20) {
                                          for(var21 = 0; var21 < 8; ++var21) {
                                             if(var20 + var15 > 0 && var15 + var20 < 103 && var21 + var16 > 0 && var21 + var16 < 103) {
                                                var41[var34].flags[var15 + var20][var21 + var16] &= -16777217;
                                             }
                                          }
                                       }

                                       Buffer var42 = new Buffer(var40);

                                       for(var21 = 0; var21 < 4; ++var21) {
                                          for(var22 = 0; var22 < 64; ++var22) {
                                             for(int var43 = 0; var43 < 64; ++var43) {
                                                if(var21 == var38 && var22 >= var17 && var22 < var17 + 8 && var43 >= var18 && var43 < var18 + 8) {
                                                   int var26 = var15 + class23.method187(var22 & 7, var43 & 7, var39);
                                                   int var29 = var22 & 7;
                                                   int var30 = var43 & 7;
                                                   int var31 = var39 & 3;
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

                                                   Resampler.loadTerrain(var42, var34, var26, var28 + var16, 0, 0, var39);
                                                } else {
                                                   Resampler.loadTerrain(var42, 0, -1, -1, 0, 0, 0);
                                                }
                                             }
                                          }
                                       }

                                       var48 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var48) {
                                 var38 = var34;
                                 var39 = var4 * 8;
                                 var10 = var5 * 8;

                                 for(var11 = 0; var11 < 8; ++var11) {
                                    for(var12 = 0; var12 < 8; ++var12) {
                                       class61.tileHeights[var38][var11 + var39][var12 + var10] = 0;
                                    }
                                 }

                                 if(var39 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class61.tileHeights[var38][var39][var10 + var11] = class61.tileHeights[var38][var39 - 1][var10 + var11];
                                    }
                                 }

                                 if(var10 > 0) {
                                    for(var11 = 1; var11 < 8; ++var11) {
                                       class61.tileHeights[var38][var39 + var11][var10] = class61.tileHeights[var38][var11 + var39][var10 - 1];
                                    }
                                 }

                                 if(var39 > 0 && class61.tileHeights[var38][var39 - 1][var10] != 0) {
                                    class61.tileHeights[var38][var39][var10] = class61.tileHeights[var38][var39 - 1][var10];
                                 } else if(var10 > 0 && class61.tileHeights[var38][var39][var10 - 1] != 0) {
                                    class61.tileHeights[var38][var39][var10] = class61.tileHeights[var38][var39][var10 - 1];
                                 } else if(var39 > 0 && var10 > 0 && class61.tileHeights[var38][var39 - 1][var10 - 1] != 0) {
                                    class61.tileHeights[var38][var39][var10] = class61.tileHeights[var38][var39 - 1][var10 - 1];
                                 }
                              }
                           }
                        }

                        ++var34;
                     }
                  }

                  MapIconReference.flush(true);
                  class184.method3455();
                  class45.method681();
                  WorldMapManager.method611(GameObject.region, collisionMaps);
                  MapIconReference.flush(true);
                  var34 = class61.field686;
                  if(var34 > class230.plane) {
                     var34 = class230.plane;
                  }

                  if(var34 < class230.plane - 1) {
                     var34 = class230.plane - 1;
                  }

                  if(lowMemory) {
                     GameObject.region.setup(class61.field686);
                  } else {
                     GameObject.region.setup(0);
                  }

                  for(var4 = 0; var4 < 104; ++var4) {
                     for(var5 = 0; var5 < 104; ++var5) {
                        class22.groundItemSpawned(var4, var5);
                     }
                  }

                  class45.method681();
                  OwnWorldComparator.method1221();
                  ObjectComposition.field3520.reset();
                  PacketNode var47;
                  if(RenderOverview.clientInstance.method895()) {
                     var47 = class61.method1076(ClientPacket.field2373, field863.field1434);
                     var47.packetBuffer.putInt(1057001181);
                     field863.method2039(var47);
                  }

                  if(!isDynamicRegion) {
                     var4 = (class152.field2090 - 6) / 8;
                     var5 = (class152.field2090 + 6) / 8;
                     var36 = (class151.field2086 - 6) / 8;
                     var37 = (class151.field2086 + 6) / 8;

                     for(var38 = var4 - 1; var38 <= var5 + 1; ++var38) {
                        for(var39 = var36 - 1; var39 <= var37 + 1; ++var39) {
                           if(var38 < var4 || var38 > var5 || var39 < var36 || var39 > var37) {
                              Script.indexMaps.method4547("m" + var38 + "_" + var39);
                              Script.indexMaps.method4547("l" + var38 + "_" + var39);
                           }
                        }
                     }
                  }

                  WorldMapType1.setGameState(30);
                  class45.method681();
                  FloorUnderlayDefinition.method4809();
                  var47 = class61.method1076(ClientPacket.field2416, field863.field1434);
                  field863.method2039(var47);
                  GameEngine.timer.vmethod3305();

                  for(var5 = 0; var5 < 32; ++var5) {
                     GameEngine.field639[var5] = 0L;
                  }

                  for(var5 = 0; var5 < 32; ++var5) {
                     GameEngine.field634[var5] = 0L;
                  }

                  GameEngine.field624 = 0;
               }
            }
         }
      } else {
         LoginPacket.method3436(this);
      }

      if(gameState == 30) {
         this.method1241();
      } else if(gameState == 40 || gameState == 45) {
         this.method1240();
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-1"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2 = MouseRecorder.method1140();
      if(var2 && field1039 && WorldMapData.soundSystem0 != null) {
         WorldMapData.soundSystem0.tryFlush();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1017 && class188.currentTimeMs() > field1017) {
         var3 = isResized?2:1;
         field1017 = 0L;
         if(var3 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         if(class70.method1179() == 1) {
            RenderOverview.clientInstance.method862(765, 503);
         } else {
            RenderOverview.clientInstance.method862(7680, 2160);
         }

         if(gameState >= 25) {
            Resampler.method2310();
         }
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field979[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class89.loadingBarPercentage, class89.loadingText, var1);
      } else if(gameState == 5) {
         class31.drawLoginScreen(class153.fontBold12, class259.fontPlain11, ClanMemberManager.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class31.drawLoginScreen(class153.fontBold12, class259.fontPlain11, ClanMemberManager.font_p12full, var1);
         } else if(gameState == 25) {
            if(field873 == 1) {
               if(field862 > field870) {
                  field870 = field862;
               }

               var3 = (field870 * 50 - field862 * 50) / field870;
               class235.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field873 == 2) {
               if(field844 > field872) {
                  field872 = field844;
               }

               var3 = (field872 * 50 - field844 * 50) / field872 + 50;
               class235.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               class235.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1393();
         } else if(gameState == 40) {
            class235.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class235.drawStatusBox("Please wait...", false);
         }
      } else {
         class31.drawLoginScreen(class153.fontBold12, class259.fontPlain11, ClanMemberManager.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < widgetCount; ++var3) {
            if(field820[var3]) {
               class324.rasterProvider.draw(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field820[var3] = false;
            }
         }
      } else if(gameState > 0) {
         class324.rasterProvider.drawFull(0, 0);

         for(var3 = 0; var3 < widgetCount; ++var3) {
            field820[var3] = false;
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1263323561"
   )
   protected final void vmethod1236() {
      if(class60.chatMessages.changed()) {
         class60.chatMessages.serialize();
      }

      if(class31.mouseRecorder != null) {
         class31.mouseRecorder.isRunning = false;
      }

      class31.mouseRecorder = null;
      field863.close();
      RunException.method3226();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      class18.mouseWheel = null;
      if(WorldMapData.soundSystem0 != null) {
         WorldMapData.soundSystem0.shutdown();
      }

      if(class87.soundSystem1 != null) {
         class87.soundSystem1.shutdown();
      }

      class43.method642();
      Object var9 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3338 != 0) {
            IndexStoreActionHandler.field3338 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(class46.urlRequester != null) {
         class46.urlRequester.close();
         class46.urlRequester = null;
      }

      try {
         class166.dat2File.close();

         for(int var4 = 0; var4 < class166.idxCount; ++var4) {
            class151.idxFiles[var4].close();
         }

         class166.idx255File.close();
         class166.randomDat.close();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-295132082"
   )
   protected final void vmethod1391() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = new Parameters[]{Parameters.field3824, Parameters.field3833, Parameters.field3828, Parameters.field3838, Parameters.field3835, Parameters.field3836, Parameters.field3829, Parameters.field3823, Parameters.field3827, Parameters.field3831, Parameters.field3825, Parameters.field3837, Parameters.field3834, Parameters.field3826, Parameters.field3832, Parameters.field3830};
         Parameters[] var2 = var1;

         int var3;
         String var5;
         int var7;
         int var10;
         for(var3 = 0; var3 < var2.length; ++var3) {
            Parameters var4 = var2[var3];
            var5 = this.getParameter(var4.key);
            if(var5 != null) {
               switch(Integer.parseInt(var4.key)) {
               case 1:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 2:
                  var7 = Integer.parseInt(var5);
                  BuildType[] var8 = new BuildType[]{BuildType.WIP, BuildType.LIVE, BuildType.RC, BuildType.BUILD_LIVE};
                  BuildType[] var9 = var8;
                  var10 = 0;

                  BuildType var36;
                  while(true) {
                     if(var10 >= var9.length) {
                        var36 = null;
                        break;
                     }

                     BuildType var11 = var9[var10];
                     if(var7 == var11.ordinal) {
                        var36 = var11;
                        break;
                     }

                     ++var10;
                  }

                  Timer.field2194 = var36;
                  break;
               case 3:
                  world = Integer.parseInt(var5);
                  break;
               case 4:
                  JagexGame[] var6 = new JagexGame[]{JagexGame.field3304, JagexGame.field3305, JagexGame.field3307, JagexGame.field3306, JagexGame.field3309, JagexGame.field3308};
                  class35.field456 = (JagexGame)Tile.forOrdinal(var6, Integer.parseInt(var5));
                  if(JagexGame.field3306 == class35.field456) {
                     class234.loginType = JagexLoginType.field3973;
                  } else {
                     class234.loginType = JagexLoginType.field3977;
                  }
                  break;
               case 5:
                  WorldMapManager.field512 = Integer.parseInt(var5);
                  break;
               case 6:
                  languageId = Integer.parseInt(var5);
                  break;
               case 7:
                  class31.field407 = var5;
               case 8:
               case 12:
               default:
                  break;
               case 9:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 10:
                  field866 = Integer.parseInt(var5) != 0;
                  break;
               case 11:
                  class45.sessionToken = var5;
                  break;
               case 13:
                  flags = Integer.parseInt(var5);
                  break;
               case 14:
                  socketType = Integer.parseInt(var5);
                  break;
               case 15:
                  class259.field3381 = Integer.parseInt(var5);
               }
            }
         }

         Region.regionLowMemory = false;
         lowMemory = false;
         class40.host = this.getCodeBase().getHost();
         String var33 = Timer.field2194.identifier;
         byte var17 = 0;

         try {
            class166.idxCount = 17;
            UnitPriceComparator.field297 = var17;

            try {
               class190.osName = System.getProperty("os.name");
            } catch (Exception var29) {
               class190.osName = "Unknown";
            }

            class188.osNameLC = class190.osName.toLowerCase();

            try {
               Occluder.userHome = System.getProperty("user.home");
               if(Occluder.userHome != null) {
                  Occluder.userHome = Occluder.userHome + "/";
               }
            } catch (Exception var28) {
               ;
            }

            try {
               if(class188.osNameLC.startsWith("win")) {
                  if(Occluder.userHome == null) {
                     Occluder.userHome = System.getenv("USERPROFILE");
                  }
               } else if(Occluder.userHome == null) {
                  Occluder.userHome = System.getenv("HOME");
               }

               if(Occluder.userHome != null) {
                  Occluder.userHome = Occluder.userHome + "/";
               }
            } catch (Exception var27) {
               ;
            }

            if(Occluder.userHome == null) {
               Occluder.userHome = "~/";
            }

            GrandExchangeEvents.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Occluder.userHome, "/tmp/", ""};
            class156.field2108 = new String[]{".jagex_cache_" + UnitPriceComparator.field297, ".file_store_" + UnitPriceComparator.field297};
            var3 = 0;

            label270:
            while(var3 < 4) {
               var5 = var3 == 0?"":"" + var3;
               class166.jagexClDat = new File(Occluder.userHome, "jagex_cl_oldschool_" + var33 + var5 + ".dat");
               String var37 = null;
               String var19 = null;
               boolean var20 = false;
               Buffer var21;
               File var45;
               if(class166.jagexClDat.exists()) {
                  try {
                     FileOnDisk var39 = new FileOnDisk(class166.jagexClDat, "rw", 10000L);

                     int var22;
                     for(var21 = new Buffer((int)var39.length()); var21.offset < var21.payload.length; var21.offset += var22) {
                        var22 = var39.read(var21.payload, var21.offset, var21.payload.length - var21.offset);
                        if(var22 == -1) {
                           throw new IOException();
                        }
                     }

                     var21.offset = 0;
                     var22 = var21.readUnsignedByte();
                     if(var22 < 1 || var22 > 3) {
                        throw new IOException("" + var22);
                     }

                     int var12 = 0;
                     if(var22 > 1) {
                        var12 = var21.readUnsignedByte();
                     }

                     if(var22 <= 2) {
                        var37 = var21.getJagString();
                        if(var12 == 1) {
                           var19 = var21.getJagString();
                        }
                     } else {
                        var37 = var21.getCESU8();
                        if(var12 == 1) {
                           var19 = var21.getCESU8();
                        }
                     }

                     var39.close();
                  } catch (IOException var31) {
                     var31.printStackTrace();
                  }

                  if(var37 != null) {
                     var45 = new File(var37);
                     if(!var45.exists()) {
                        var37 = null;
                     }
                  }

                  if(var37 != null) {
                     var45 = new File(var37, "test.dat");
                     if(!MapIconReference.method730(var45, true)) {
                        var37 = null;
                     }
                  }
               }

               if(var37 == null && var3 == 0) {
                  label245:
                  for(int var23 = 0; var23 < class156.field2108.length; ++var23) {
                     for(var10 = 0; var10 < GrandExchangeEvents.cacheLocations.length; ++var10) {
                        File var41 = new File(GrandExchangeEvents.cacheLocations[var10] + class156.field2108[var23] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var41.exists() && MapIconReference.method730(new File(var41, "test.dat"), true)) {
                           var37 = var41.toString();
                           var20 = true;
                           break label245;
                        }
                     }
                  }
               }

               if(var37 == null) {
                  var37 = Occluder.userHome + File.separatorChar + "jagexcache" + var5 + File.separatorChar + "oldschool" + File.separatorChar + var33 + File.separatorChar;
                  var20 = true;
               }

               File var40;
               if(var19 != null) {
                  var40 = new File(var19);
                  var45 = new File(var37);

                  try {
                     File[] var42 = var40.listFiles();
                     File[] var24 = var42;

                     for(int var13 = 0; var13 < var24.length; ++var13) {
                        File var14 = var24[var13];
                        File var15 = new File(var45, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var30) {
                     var30.printStackTrace();
                  }

                  var20 = true;
               }

               if(var20) {
                  var40 = new File(var37);
                  var21 = null;

                  try {
                     FileOnDisk var43 = new FileOnDisk(class166.jagexClDat, "rw", 10000L);
                     Buffer var46 = new Buffer(500);
                     var46.putByte(3);
                     var46.putByte(var21 != null?1:0);
                     var46.putCESU8(var40.getPath());
                     if(var21 != null) {
                        var46.putCESU8("");
                     }

                     var43.write(var46.payload, 0, var46.offset);
                     var43.close();
                  } catch (IOException var26) {
                     var26.printStackTrace();
                  }
               }

               File var34 = new File(var37);
               class29.field387 = var34;
               if(!class29.field387.exists()) {
                  class29.field387.mkdirs();
               }

               File[] var35 = class29.field387.listFiles();
               if(var35 != null) {
                  File[] var44 = var35;

                  for(var7 = 0; var7 < var44.length; ++var7) {
                     File var38 = var44[var7];
                     if(!MapIconReference.method730(var38, false)) {
                        ++var3;
                        continue label270;
                     }
                  }
               }
               break;
            }

            File var18 = class29.field387;
            class169.field2182 = var18;
            if(!class169.field2182.exists()) {
               throw new RuntimeException("");
            }

            class169.field2185 = true;
            LoginPacket.method3434();
            class166.dat2File = new CacheFile(new FileOnDisk(TextureProvider.method2596("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class166.idx255File = new CacheFile(new FileOnDisk(TextureProvider.method2596("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class151.idxFiles = new CacheFile[class166.idxCount];

            for(int var25 = 0; var25 < class166.idxCount; ++var25) {
               class151.idxFiles[var25] = new CacheFile(new FileOnDisk(TextureProvider.method2596("main_file_cache.idx" + var25), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var32) {
            class37.method519((String)null, var32);
         }

         RenderOverview.clientInstance = this;
         this.initialize(765, 503, 164);
      }
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-58"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         long var2 = class188.currentTimeMs();
         int var4 = (int)(var2 - class258.field3358);
         class258.field3358 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class258.field3373 += var4;
         boolean var1;
         if(class258.NetCache_pendingResponsesCount == 0 && class258.NetCache_pendingPriorityResponsesCount == 0 && class258.NetCache_pendingWritesCount == 0 && class258.NetCache_pendingPriorityWritesCount == 0) {
            var1 = true;
         } else if(class258.NetCache_socket == null) {
            var1 = false;
         } else {
            try {
               label243: {
                  if(class258.field3373 > 30000) {
                     throw new IOException();
                  }

                  FileRequest var5;
                  Buffer var6;
                  while(class258.NetCache_pendingPriorityResponsesCount < 200 && class258.NetCache_pendingPriorityWritesCount > 0) {
                     var5 = (FileRequest)class258.NetCache_pendingPriorityWrites.first();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class258.NetCache_socket.vmethod3323(var6.payload, 0, 4);
                     class258.NetCache_pendingPriorityResponses.put(var5, var5.hash);
                     --class258.NetCache_pendingPriorityWritesCount;
                     ++class258.NetCache_pendingPriorityResponsesCount;
                  }

                  while(class258.NetCache_pendingResponsesCount < 200 && class258.NetCache_pendingWritesCount > 0) {
                     var5 = (FileRequest)class258.NetCache_pendingWritesQueue.peek();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class258.NetCache_socket.vmethod3323(var6.payload, 0, 4);
                     var5.unlinkDual();
                     class258.NetCache_pendingResponses.put(var5, var5.hash);
                     --class258.NetCache_pendingWritesCount;
                     ++class258.NetCache_pendingResponsesCount;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class258.NetCache_socket.vmethod3346();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class258.field3373 = 0;
                     byte var7 = 0;
                     if(class168.currentRequest == null) {
                        var7 = 8;
                     } else if(class258.field3369 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class258.NetCache_responseHeaderBuffer.offset;
                        if(var8 > var18) {
                           var8 = var18;
                        }

                        class258.NetCache_socket.vmethod3321(class258.NetCache_responseHeaderBuffer.payload, class258.NetCache_responseHeaderBuffer.offset, var8);
                        if(class258.field3372 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class258.NetCache_responseHeaderBuffer.payload[var9 + class258.NetCache_responseHeaderBuffer.offset] ^= class258.field3372;
                           }
                        }

                        class258.NetCache_responseHeaderBuffer.offset += var8;
                        if(class258.NetCache_responseHeaderBuffer.offset < var7) {
                           break;
                        }

                        if(class168.currentRequest == null) {
                           class258.NetCache_responseHeaderBuffer.offset = 0;
                           var9 = class258.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var10 = class258.NetCache_responseHeaderBuffer.readUnsignedShort();
                           int var11 = class258.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var12 = class258.NetCache_responseHeaderBuffer.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           FileRequest var15 = (FileRequest)class258.NetCache_pendingPriorityResponses.get(var13);
                           class248.field3276 = true;
                           if(var15 == null) {
                              var15 = (FileRequest)class258.NetCache_pendingResponses.get(var13);
                              class248.field3276 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class168.currentRequest = var15;
                           VertexNormal.NetCache_responseArchiveBuffer = new Buffer(var16 + var12 + class168.currentRequest.padding);
                           VertexNormal.NetCache_responseArchiveBuffer.putByte(var11);
                           VertexNormal.NetCache_responseArchiveBuffer.putInt(var12);
                           class258.field3369 = 8;
                           class258.NetCache_responseHeaderBuffer.offset = 0;
                        } else if(class258.field3369 == 0) {
                           if(class258.NetCache_responseHeaderBuffer.payload[0] == -1) {
                              class258.field3369 = 1;
                              class258.NetCache_responseHeaderBuffer.offset = 0;
                           } else {
                              class168.currentRequest = null;
                           }
                        }
                     } else {
                        var8 = VertexNormal.NetCache_responseArchiveBuffer.payload.length - class168.currentRequest.padding;
                        var9 = 512 - class258.field3369;
                        if(var9 > var8 - VertexNormal.NetCache_responseArchiveBuffer.offset) {
                           var9 = var8 - VertexNormal.NetCache_responseArchiveBuffer.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class258.NetCache_socket.vmethod3321(VertexNormal.NetCache_responseArchiveBuffer.payload, VertexNormal.NetCache_responseArchiveBuffer.offset, var9);
                        if(class258.field3372 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              VertexNormal.NetCache_responseArchiveBuffer.payload[var10 + VertexNormal.NetCache_responseArchiveBuffer.offset] ^= class258.field3372;
                           }
                        }

                        VertexNormal.NetCache_responseArchiveBuffer.offset += var9;
                        class258.field3369 += var9;
                        if(var8 == VertexNormal.NetCache_responseArchiveBuffer.offset) {
                           if(16711935L == class168.currentRequest.hash) {
                              FontName.NetCache_reference = VertexNormal.NetCache_responseArchiveBuffer;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var19 = class258.NetCache_indexCaches[var10];
                                 if(var19 != null) {
                                    FontName.NetCache_reference.offset = var10 * 8 + 5;
                                    var12 = FontName.NetCache_reference.readInt();
                                    int var20 = FontName.NetCache_reference.readInt();
                                    var19.setInformation(var12, var20);
                                 }
                              }
                           } else {
                              class258.NetCache_crc.reset();
                              class258.NetCache_crc.update(VertexNormal.NetCache_responseArchiveBuffer.payload, 0, var8);
                              var10 = (int)class258.NetCache_crc.getValue();
                              if(var10 != class168.currentRequest.crc) {
                                 try {
                                    class258.NetCache_socket.vmethod3317();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class258.field3367;
                                 class258.NetCache_socket = null;
                                 class258.field3372 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label243;
                              }

                              class258.field3367 = 0;
                              class258.field3374 = 0;
                              class168.currentRequest.index.write((int)(class168.currentRequest.hash & 65535L), VertexNormal.NetCache_responseArchiveBuffer.payload, 16711680L == (class168.currentRequest.hash & 16711680L), class248.field3276);
                           }

                           class168.currentRequest.unlink();
                           if(class248.field3276) {
                              --class258.NetCache_pendingPriorityResponsesCount;
                           } else {
                              --class258.NetCache_pendingResponsesCount;
                           }

                           class258.field3369 = 0;
                           class168.currentRequest = null;
                           VertexNormal.NetCache_responseArchiveBuffer = null;
                        } else {
                           if(class258.field3369 != 512) {
                              break;
                           }

                           class258.field3369 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class258.NetCache_socket.vmethod3317();
               } catch (Exception var22) {
                  ;
               }

               ++class258.field3374;
               class258.NetCache_socket = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1360();
         }

      }
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "23920"
   )
   void method1360() {
      if(class258.field3367 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class258.field3374 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field849 = 3000;
            class258.field3374 = 3;
         }

         if(--field849 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  WorldMapManager.socket = GameEngine.taskManager.createSocket(class40.host, ScriptEvent.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(WorldMapManager.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(WorldMapManager.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field866) {
                     Socket var2 = (Socket) WorldMapManager.socket.value;
                     class170 var1 = new class170(var2, 40000, 5000);
                     UrlRequester.rssocket = var1;
                  } else {
                     UrlRequester.rssocket = new class172((Socket) WorldMapManager.socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var5 = new Buffer(5);
                  var5.putByte(15);
                  var5.putInt(164);
                  UrlRequester.rssocket.vmethod3323(var5.payload, 0, 5);
                  ++js5State;
                  class23.field314 = class188.currentTimeMs();
               }

               if(js5State == 3) {
                  if(UrlRequester.rssocket.vmethod3346() > 0 || !field866 && gameState <= 5) {
                     int var3 = UrlRequester.rssocket.vmethod3318();
                     if(var3 != 0) {
                        this.error(var3);
                        return;
                     }

                     ++js5State;
                  } else if(class188.currentTimeMs() - class23.field314 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  Resampler.method2306(UrlRequester.rssocket, gameState > 20);
                  WorldMapManager.socket = null;
                  UrlRequester.rssocket = null;
                  js5State = 0;
                  field946 = 0;
               }
            } catch (IOException var4) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "82"
   )
   @Export("error")
   void error(int var1) {
      WorldMapManager.socket = null;
      UrlRequester.rssocket = null;
      js5State = 0;
      if(ScriptEvent.myWorldPort == class79.port1) {
         ScriptEvent.myWorldPort = class3.port2;
      } else {
         ScriptEvent.myWorldPort = class79.port1;
      }

      ++field946;
      if(field946 < 2 || var1 != 7 && var1 != 9) {
         if(field946 >= 2 && var1 == 6) {
            this.error("js5connect_outofdate");
            gameState = 1000;
         } else if(field946 >= 4) {
            if(gameState <= 5) {
               this.error("js5connect");
               gameState = 1000;
            } else {
               field849 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.error("js5connect_full");
         gameState = 1000;
      } else {
         field849 = 3000;
      }

   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2121601890"
   )
   final void method1240() {
      Object var1 = field863.getSocket();
      PacketBuffer var2 = field863.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class168)var1).vmethod3317();
               var1 = null;
            }

            class190.field2491 = null;
            socketError = false;
            field853 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class190.field2491 == null) {
               class190.field2491 = GameEngine.taskManager.createSocket(class40.host, ScriptEvent.myWorldPort);
            }

            if(class190.field2491.status == 2) {
               throw new IOException();
            }

            if(class190.field2491.status == 1) {
               if(field866) {
                  Socket var4 = (Socket)class190.field2491.value;
                  class170 var3 = new class170(var4, 40000, 5000);
                  var1 = var3;
               } else {
                  var1 = new class172((Socket)class190.field2491.value, GameEngine.taskManager, 5000);
               }

               field863.setSocket((class168)var1);
               class190.field2491 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field863.method2031();
            PacketNode var18 = Actor.method1634();
            var18.packetBuffer.putByte(LoginPacket.field2436.id);
            field863.method2039(var18);
            field863.method2057();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var11;
         int var12;
         if(loginState == 3) {
            if(WorldMapData.soundSystem0 != null) {
               WorldMapData.soundSystem0.method2216();
            }

            if(class87.soundSystem1 != null) {
               class87.soundSystem1.method2216();
            }

            var11 = true;
            if(field866 && !((class168)var1).vmethod3341(1)) {
               var11 = false;
            }

            if(var11) {
               var12 = ((class168)var1).vmethod3318();
               if(WorldMapData.soundSystem0 != null) {
                  WorldMapData.soundSystem0.method2216();
               }

               if(class87.soundSystem1 != null) {
                  class87.soundSystem1.method2216();
               }

               if(var12 != 0) {
                  class18.method146(var12);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var26;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var26 = ((class168)var1).vmethod3346();
               if(var26 > 8 - var2.offset) {
                  var26 = 8 - var2.offset;
               }

               if(var26 > 0) {
                  ((class168)var1).vmethod3321(var2.payload, var2.offset, var26);
                  var2.offset += var26;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               VertexNormal.field1889 = var2.readLong();
               loginState = 5;
            }
         }

         int var6;
         if(loginState == 5) {
            field863.packetBuffer.offset = 0;
            field863.method2031();
            PacketBuffer var19 = new PacketBuffer(500);
            int[] var21 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(VertexNormal.field1889 >> 32), (int)(VertexNormal.field1889 & -1L)};
            var19.offset = 0;
            var19.putByte(1);
            var19.putByte(field856.rsOrdinal());
            var19.putInt(var21[0]);
            var19.putInt(var21[1]);
            var19.putInt(var21[2]);
            var19.putInt(var21[3]);
            switch(field856.field2114) {
            case 0:
               var19.offset += 8;
               break;
            case 1:
            case 3:
               var19.put24bitInt(BoundingBox3DDrawMode.field253);
               var19.offset += 5;
               break;
            case 2:
               var19.putInt(((Integer)preferences.preferences.get(Integer.valueOf(class240.method4493(class89.username)))).intValue());
               var19.offset += 4;
            }

            var19.putString(class89.password);
            var19.encryptRsa(class87.field1292, class87.field1287);
            PacketNode var5 = Actor.method1634();
            var5.packetBuffer.offset = 0;
            if(gameState == 40) {
               var5.packetBuffer.putByte(LoginPacket.field2439.id);
            } else {
               var5.packetBuffer.putByte(LoginPacket.field2444.id);
            }

            var5.packetBuffer.putShort(0);
            var6 = var5.packetBuffer.offset;
            var5.packetBuffer.putInt(164);
            var5.packetBuffer.putBytes(var19.payload, 0, var19.offset);
            int var7 = var5.packetBuffer.offset;
            var5.packetBuffer.putString(class89.username);
            var5.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var5.packetBuffer.putShort(class1.canvasWidth);
            var5.packetBuffer.putShort(class25.canvasHeight);
            PacketBuffer var8 = var5.packetBuffer;
            if(field857 != null) {
               var8.putBytes(field857, 0, field857.length);
            } else {
               byte[] var9 = class155.method3154();
               var8.putBytes(var9, 0, var9.length);
            }

            var5.packetBuffer.putString(class45.sessionToken);
            var5.packetBuffer.putInt(WorldMapManager.field512);
            Buffer var25 = new Buffer(class63.platformInfo.method6155());
            class63.platformInfo.method6154(var25);
            var5.packetBuffer.putBytes(var25.payload, 0, var25.payload.length);
            var5.packetBuffer.putByte(class259.field3381);
            var5.packetBuffer.putInt(0);
            var5.packetBuffer.putInt(indexInterfaces.crc);
            var5.packetBuffer.putInt(class155.indexSoundEffects.crc);
            var5.packetBuffer.putInt(class109.configsIndex.crc);
            var5.packetBuffer.putInt(GameCanvas.indexCache3.crc);
            var5.packetBuffer.putInt(class54.indexCache4.crc);
            var5.packetBuffer.putInt(Script.indexMaps.crc);
            var5.packetBuffer.putInt(class155.indexTrack1.crc);
            var5.packetBuffer.putInt(DynamicObject.indexModels.crc);
            var5.packetBuffer.putInt(MessageNode.indexSprites.crc);
            var5.packetBuffer.putInt(class63.indexTextures.crc);
            var5.packetBuffer.putInt(class85.indexCache10.crc);
            var5.packetBuffer.putInt(GrandExchangeOffer.indexTrack2.crc);
            var5.packetBuffer.putInt(class80.indexScripts.crc);
            var5.packetBuffer.putInt(class2.indexCache13.crc);
            var5.packetBuffer.putInt(class194.vorbisIndex.crc);
            var5.packetBuffer.putInt(class27.indexCache15.crc);
            var5.packetBuffer.putInt(class36.indexWorldMap.crc);
            var5.packetBuffer.encryptXtea(var21, var7, var5.packetBuffer.offset);
            var5.packetBuffer.method3655(var5.packetBuffer.offset - var6);
            field863.method2039(var5);
            field863.method2057();
            field863.field1434 = new ISAACCipher(var21);

            for(int var10 = 0; var10 < 4; ++var10) {
               var21[var10] += 50;
            }

            var2.seed(var21);
            loginState = 6;
         }

         if(loginState == 6 && ((class168)var1).vmethod3346() > 0) {
            var26 = ((class168)var1).vmethod3318();
            if(var26 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var26 == 2) {
               loginState = 9;
            } else if(var26 == 15 && gameState == 40) {
               field863.packetLength = -1;
               loginState = 13;
            } else if(var26 == 23 && field861 < 1) {
               ++field861;
               loginState = 0;
            } else {
               if(var26 != 29) {
                  class18.method146(var26);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class168)var1).vmethod3346() > 0) {
            field1008 = (((class168)var1).vmethod3318() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field853 = 0;
            class194.method3794("You have only just left another world.", "Your profile will be transferred in:", field1008 / 60 + " seconds.");
            if(--field1008 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && ((class168)var1).vmethod3346() >= 13) {
               var11 = ((class168)var1).vmethod3318() == 1;
               ((class168)var1).vmethod3321(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var27 = false;
               if(var11) {
                  var12 = var2.readOpcode() << 24;
                  var12 |= var2.readOpcode() << 16;
                  var12 |= var2.readOpcode() << 8;
                  var12 |= var2.readOpcode();
                  int var13 = class240.method4493(class89.username);
                  if(preferences.preferences.size() >= 10 && !preferences.preferences.containsKey(Integer.valueOf(var13))) {
                     Iterator var14 = preferences.preferences.entrySet().iterator();
                     var14.next();
                     var14.remove();
                  }

                  preferences.preferences.put(Integer.valueOf(var13), Integer.valueOf(var12));
               }

               if(class89.Login_isUsernameRemembered) {
                  preferences.rememberedUsername = class89.username;
               } else {
                  preferences.rememberedUsername = null;
               }

               VertexNormal.method2802();
               rights = ((class168)var1).vmethod3318();
               field1027 = ((class168)var1).vmethod3318() == 1;
               localInteractingIndex = ((class168)var1).vmethod3318();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class168)var1).vmethod3318();
               field1028 = ((class168)var1).vmethod3318();
               ((class168)var1).vmethod3321(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var23 = ScriptEvent.method1137();
               var6 = var2.method3836();
               if(var6 < 0 || var6 >= var23.length) {
                  throw new IOException(var6 + " " + var2.offset);
               }

               field863.serverPacket = var23[var6];
               field863.packetLength = field863.serverPacket.packetLength;
               ((class168)var1).vmethod3321(var2.payload, 0, 2);
               var2.offset = 0;
               field863.packetLength = var2.readUnsignedShort();

               try {
                  Client var15 = RenderOverview.clientInstance;
                  JSObject.getWindow(var15).call("zap", (Object[])null);
               } catch (Throwable var16) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((class168)var1).vmethod3346() >= field863.packetLength) {
                  var2.offset = 0;
                  ((class168)var1).vmethod3321(var2.payload, 0, field863.packetLength);
                  field912.method5601();
                  MapIcon.method557();
                  WorldMapManager.initializeGPI(var2);
                  class152.field2090 = -1;
                  MouseRecorder.xteaChanged(false, var2);
                  field863.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((class168)var1).vmethod3346() >= 2) {
                  var2.offset = 0;
                  ((class168)var1).vmethod3321(var2.payload, 0, 2);
                  var2.offset = 0;
                  BuildType.field3303 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class168)var1).vmethod3346() >= BuildType.field3303) {
                  var2.offset = 0;
                  ((class168)var1).vmethod3321(var2.payload, 0, BuildType.field3303);
                  var2.offset = 0;
                  String var20 = var2.readString();
                  String var22 = var2.readString();
                  String var24 = var2.readString();
                  class194.method3794(var20, var22, var24);
                  WorldMapType1.setGameState(10);
               }

               if(loginState == 13) {
                  if(field863.packetLength == -1) {
                     if(((class168)var1).vmethod3346() < 2) {
                        return;
                     }

                     ((class168)var1).vmethod3321(var2.payload, 0, 2);
                     var2.offset = 0;
                     field863.packetLength = var2.readUnsignedShort();
                  }

                  if(((class168)var1).vmethod3346() >= field863.packetLength) {
                     ((class168)var1).vmethod3321(var2.payload, 0, field863.packetLength);
                     var2.offset = 0;
                     var26 = field863.packetLength;
                     field912.method5620();
                     WidgetNode.method1126();
                     WorldMapManager.initializeGPI(var2);
                     if(var26 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field853;
                  if(field853 > 2000) {
                     if(field861 < 1) {
                        if(class79.port1 == ScriptEvent.myWorldPort) {
                           ScriptEvent.myWorldPort = class3.port2;
                        } else {
                           ScriptEvent.myWorldPort = class79.port1;
                        }

                        ++field861;
                        loginState = 0;
                     } else {
                        class18.method146(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var17) {
         if(field861 < 1) {
            if(ScriptEvent.myWorldPort == class79.port1) {
               ScriptEvent.myWorldPort = class3.port2;
            } else {
               ScriptEvent.myWorldPort = class79.port1;
            }

            ++field861;
            loginState = 0;
         } else {
            class18.method146(-2);
         }
      }
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1606770379"
   )
   final void method1241() {
      if(field836 > 1) {
         --field836;
      }

      if(field864 > 0) {
         --field864;
      }

      if(socketError) {
         socketError = false;
         if(field864 > 0) {
            VertexNormal.method2800();
         } else {
            field912.method5599();
            WorldMapType1.setGameState(40);
            class1.field11 = field863.getSocket();
            field863.method2035();
         }

      } else {
         if(!isMenuOpen) {
            BoundingBox2D.method36();
         }

         for(int var1 = 0; var1 < 100 && this.method1261(field863); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class317.classInfos.last();
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
                  if(field912.field3843) {
                     var14 = class61.method1076(ClientPacket.field2400, field863.field1434);
                     var14.packetBuffer.putByte(0);
                     var15 = var14.packetBuffer.offset;
                     field912.method5604(var14.packetBuffer);
                     var14.packetBuffer.method3545(var14.packetBuffer.offset - var15);
                     field863.method2039(var14);
                     field912.method5602();
                  }

                  Object var35 = class31.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  synchronized(class31.mouseRecorder.lock) {
                     if(!field905) {
                        class31.mouseRecorder.index = 0;
                     } else if(MouseInput.mouseLastButton != 0 || class31.mouseRecorder.index >= 40) {
                        var31 = class61.method1076(ClientPacket.field2403, field863.field1434);
                        var31.packetBuffer.putByte(0);
                        var3 = var31.packetBuffer.offset;
                        var4 = 0;

                        for(var5 = 0; var5 < class31.mouseRecorder.index && var31.packetBuffer.offset - var3 < 240; ++var5) {
                           ++var4;
                           var6 = class31.mouseRecorder.ys[var5];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 502) {
                              var6 = 502;
                           }

                           var7 = class31.mouseRecorder.xs[var5];
                           if(var7 < 0) {
                              var7 = 0;
                           } else if(var7 > 764) {
                              var7 = 764;
                           }

                           var8 = var6 * 765 + var7;
                           if(class31.mouseRecorder.ys[var5] == -1 && class31.mouseRecorder.xs[var5] == -1) {
                              var7 = -1;
                              var6 = -1;
                              var8 = 524287;
                           }

                           if(var7 == field831 && var6 == field832) {
                              if(field833 < 2047) {
                                 ++field833;
                              }
                           } else {
                              var9 = var7 - field831;
                              field831 = var7;
                              var10 = var6 - field832;
                              field832 = var6;
                              if(field833 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                                 var9 += 32;
                                 var10 += 32;
                                 var31.packetBuffer.putShort(var10 + (field833 << 12) + (var9 << 6));
                                 field833 = 0;
                              } else if(field833 < 8) {
                                 var31.packetBuffer.put24bitInt((field833 << 19) + var8 + 8388608);
                                 field833 = 0;
                              } else {
                                 var31.packetBuffer.putInt((field833 << 19) + var8 + -1073741824);
                                 field833 = 0;
                              }
                           }
                        }

                        var31.packetBuffer.method3545(var31.packetBuffer.offset - var3);
                        field863.method2039(var31);
                        if(var4 >= class31.mouseRecorder.index) {
                           class31.mouseRecorder.index = 0;
                        } else {
                           class31.mouseRecorder.index -= var4;

                           for(var5 = 0; var5 < class31.mouseRecorder.index; ++var5) {
                              class31.mouseRecorder.xs[var5] = class31.mouseRecorder.xs[var5 + var4];
                              class31.mouseRecorder.ys[var5] = class31.mouseRecorder.ys[var5 + var4];
                           }
                        }
                     }
                  }

                  PacketNode var18;
                  if(MouseInput.mouseLastButton == 1 || !Size.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
                     long var16 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
                     if(var16 > 4095L) {
                        var16 = 4095L;
                     }

                     mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis * -1L;
                     var3 = MouseInput.mouseLastPressedY;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class25.canvasHeight) {
                        var3 = class25.canvasHeight;
                     }

                     var4 = MouseInput.mouseLastPressedX;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > class1.canvasWidth) {
                        var4 = class1.canvasWidth;
                     }

                     var5 = (int)var16;
                     var18 = class61.method1076(ClientPacket.field2415, field863.field1434);
                     var18.packetBuffer.putShort((MouseInput.mouseLastButton == 2?1:0) + (var5 << 1));
                     var18.packetBuffer.putShort(var4);
                     var18.packetBuffer.putShort(var3);
                     field863.method2039(var18);
                  }

                  if(KeyFocusListener.field593 > 0) {
                     var14 = class61.method1076(ClientPacket.field2387, field863.field1434);
                     var14.packetBuffer.putShort(0);
                     var15 = var14.packetBuffer.offset;
                     long var19 = class188.currentTimeMs();

                     for(var5 = 0; var5 < KeyFocusListener.field593; ++var5) {
                        long var21 = var19 - field909;
                        if(var21 > 16777215L) {
                           var21 = 16777215L;
                        }

                        field909 = var19;
                        var14.packetBuffer.method3574(KeyFocusListener.field585[var5]);
                        var14.packetBuffer.put24bitInt((int)var21);
                     }

                     var14.packetBuffer.method3655(var14.packetBuffer.offset - var15);
                     field863.method2039(var14);
                  }

                  if(field927 > 0) {
                     --field927;
                  }

                  if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
                     field893 = true;
                  }

                  if(field893 && field927 <= 0) {
                     field927 = 20;
                     field893 = false;
                     var14 = class61.method1076(ClientPacket.field2340, field863.field1434);
                     var14.packetBuffer.putShort(cameraPitchTarget);
                     var14.packetBuffer.method3641(mapAngle);
                     field863.method2039(var14);
                  }

                  if(class166.field2176 && !field1018) {
                     field1018 = true;
                     var14 = class61.method1076(ClientPacket.field2391, field863.field1434);
                     var14.packetBuffer.putByte(1);
                     field863.method2039(var14);
                  }

                  if(!class166.field2176 && field1018) {
                     field1018 = false;
                     var14 = class61.method1076(ClientPacket.field2391, field863.field1434);
                     var14.packetBuffer.putByte(0);
                     field863.method2039(var14);
                  }

                  ISAACCipher.method3869();
                  if(class230.plane != field1077) {
                     field1077 = class230.plane;
                     SoundTask.method2269(class230.plane);
                  }

                  if(gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var36 = (PendingSpawn)pendingSpawns.getFront(); var36 != null; var36 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var36.hitpoints > 0) {
                        --var36.hitpoints;
                     }

                     if(var36.hitpoints == 0) {
                        if(var36.field1090 < 0 || class231.method4364(var36.field1090, var36.field1086)) {
                           GrandExchangeOffer.method112(var36.level, var36.type, var36.x, var36.y, var36.field1090, var36.field1085, var36.field1086);
                           var36.unlink();
                        }
                     } else {
                        if(var36.delay > 0) {
                           --var36.delay;
                        }

                        if(var36.delay == 0 && var36.x >= 1 && var36.y >= 1 && var36.x <= 102 && var36.y <= 102 && (var36.id < 0 || class231.method4364(var36.id, var36.field1084))) {
                           GrandExchangeOffer.method112(var36.level, var36.type, var36.x, var36.y, var36.id, var36.orientation, var36.field1084);
                           var36.delay = -1;
                           if(var36.field1090 == var36.id && var36.field1090 == -1) {
                              var36.unlink();
                           } else if(var36.field1090 == var36.id && var36.orientation == var36.field1085 && var36.field1084 == var36.field1086) {
                              var36.unlink();
                           }
                        }
                     }
                  }

                  class166.method3260();
                  ++field863.field1439;
                  if(field863.field1439 > 750) {
                     if(field864 > 0) {
                        VertexNormal.method2800();
                     } else {
                        field912.method5599();
                        WorldMapType1.setGameState(40);
                        class1.field11 = field863.getSocket();
                        field863.method2035();
                     }

                     return;
                  }

                  UrlRequest.method3089();
                  class201.method3888();
                  Resampler.method2309();
                  ++field878;
                  if(cursorState != 0) {
                     field911 += 20;
                     if(field911 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(UnitPriceComparator.field298 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        ScriptEvent.method1132(UnitPriceComparator.field298);
                        UnitPriceComparator.field298 = null;
                     }
                  }

                  Widget var37 = Varcs.field1389;
                  Widget var32 = WorldComparator.field258;
                  Varcs.field1389 = null;
                  WorldComparator.field258 = null;
                  field980 = null;
                  field984 = false;
                  field978 = false;
                  field1025 = 0;

                  while(class46.method712() && field1025 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && Resampler.field1563 == 66) {
                        String var23 = "";

                        MessageNode var38;
                        for(Iterator var24 = class94.messages.iterator(); var24.hasNext(); var23 = var23 + var38.name + ':' + var38.value + '\n') {
                           var38 = (MessageNode)var24.next();
                        }

                        RenderOverview.clientInstance.method866(var23);
                     } else {
                        field956[field1025] = Resampler.field1563;
                        field896[field1025] = class5.field29;
                        ++field1025;
                     }
                  }

                  boolean var33 = rights >= 2;
                  if(var33 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var4 = OwnWorldComparator.localPlayer.field802 - mouseWheelRotation;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != OwnWorldComparator.localPlayer.field802) {
                        var5 = OwnWorldComparator.localPlayer.pathX[0] + ScriptState.baseX;
                        var6 = OwnWorldComparator.localPlayer.pathY[0] + WorldMapType1.baseY;
                        PacketNode var26 = class61.method1076(ClientPacket.field2379, field863.field1434);
                        var26.packetBuffer.writeShortLE(var5);
                        var26.packetBuffer.putByte(var4);
                        var26.packetBuffer.method3641(var6);
                        field863.method2039(var26);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     var4 = widgetRoot;
                     var5 = class1.canvasWidth;
                     var6 = class25.canvasHeight;
                     if(class2.loadWidget(var4)) {
                        class188.method3507(Widget.widgets[var4], -1, 0, 0, var5, var6, 0, 0);
                     }
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var39;
                     ScriptEvent var40;
                     Widget var41;
                     do {
                        var40 = (ScriptEvent)field992.popFront();
                        if(var40 == null) {
                           while(true) {
                              do {
                                 var40 = (ScriptEvent)field1049.popFront();
                                 if(var40 == null) {
                                    while(true) {
                                       do {
                                          var40 = (ScriptEvent)field821.popFront();
                                          if(var40 == null) {
                                             this.method1294();
                                             SoundTask.method2272();
                                             if(field976 != null) {
                                                this.method1389();
                                             }

                                             if(class25.field348 != null) {
                                                ScriptEvent.method1132(class25.field348);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(itemBeingDragged) {
                                                      if(class109.field1552 == class25.field348 && field934 != field918) {
                                                         Widget var42 = class25.field348;
                                                         byte var34 = 0;
                                                         if(field966 == 1 && var42.contentType == 206) {
                                                            var34 = 1;
                                                         }

                                                         if(var42.itemIds[field918] <= 0) {
                                                            var34 = 0;
                                                         }

                                                         if(class61.method1064(class230.getWidgetConfig(var42))) {
                                                            var6 = field934;
                                                            var7 = field918;
                                                            var42.itemIds[var7] = var42.itemIds[var6];
                                                            var42.itemQuantities[var7] = var42.itemQuantities[var6];
                                                            var42.itemIds[var6] = -1;
                                                            var42.itemQuantities[var6] = 0;
                                                         } else if(var34 == 1) {
                                                            var6 = field934;
                                                            var7 = field918;

                                                            while(var6 != var7) {
                                                               if(var6 > var7) {
                                                                  var42.method4438(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var42.method4438(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var42.method4438(field918, field934);
                                                         }

                                                         var18 = class61.method1076(ClientPacket.field2421, field863.field1434);
                                                         var18.packetBuffer.method3574(var34);
                                                         var18.packetBuffer.method3641(field934);
                                                         var18.packetBuffer.putInt(class25.field348.id);
                                                         var18.packetBuffer.method3641(field918);
                                                         field863.method2039(var18);
                                                      }
                                                   } else if(this.method1247()) {
                                                      this.openMenu(field916, field917);
                                                   } else if(menuOptionCount > 0) {
                                                      class308.method5596(field916, field917);
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   class25.field348 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field916 + 5 || MouseInput.mouseLastX < field916 - 5 || MouseInput.mouseLastY > field917 + 5 || MouseInput.mouseLastY < field917 - 5)) {
                                                   itemBeingDragged = true;
                                                }
                                             }

                                             if(Region.method2922()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                var18 = class61.method1076(ClientPacket.field2394, field863.field1434);
                                                var18.packetBuffer.putByte(5);
                                                var18.packetBuffer.writeIntLE16(var4 + ScriptState.baseX);
                                                var18.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                var18.packetBuffer.writeIntLE16(var5 + WorldMapType1.baseY);
                                                field863.method2039(var18);
                                                Region.method2923();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field911 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var37 != Varcs.field1389) {
                                                if(var37 != null) {
                                                   ScriptEvent.method1132(var37);
                                                }

                                                if(Varcs.field1389 != null) {
                                                   ScriptEvent.method1132(Varcs.field1389);
                                                }
                                             }

                                             if(var32 != WorldComparator.field258 && field879 == field933) {
                                                if(var32 != null) {
                                                   ScriptEvent.method1132(var32);
                                                }

                                                if(WorldComparator.field258 != null) {
                                                   ScriptEvent.method1132(WorldComparator.field258);
                                                }
                                             }

                                             if(WorldComparator.field258 != null) {
                                                if(field933 < field879) {
                                                   ++field933;
                                                   if(field933 == field879) {
                                                      ScriptEvent.method1132(WorldComparator.field258);
                                                   }
                                                }
                                             } else if(field933 > 0) {
                                                --field933;
                                             }

                                             var4 = OwnWorldComparator.localPlayer.x;
                                             var5 = OwnWorldComparator.localPlayer.y;
                                             if(AbstractByteBuffer.field2564 - var4 < -500 || AbstractByteBuffer.field2564 - var4 > 500 || BaseVarType.field25 - var5 < -500 || BaseVarType.field25 - var5 > 500) {
                                                AbstractByteBuffer.field2564 = var4;
                                                BaseVarType.field25 = var5;
                                             }

                                             if(var4 != AbstractByteBuffer.field2564) {
                                                AbstractByteBuffer.field2564 += (var4 - AbstractByteBuffer.field2564) / 16;
                                             }

                                             if(var5 != BaseVarType.field25) {
                                                BaseVarType.field25 += (var5 - BaseVarType.field25) / 16;
                                             }

                                             if(MouseInput.mouseCurrentButton == 4 && Size.middleMouseMovesCamera) {
                                                var6 = MouseInput.mouseLastY - field890;
                                                field944 = var6 * 2;
                                                field890 = var6 != -1 && var6 != 1?(field890 + MouseInput.mouseLastY) / 2:MouseInput.mouseLastY;
                                                var7 = field1011 - MouseInput.mouseLastX;
                                                field964 = var7 * 2;
                                                field1011 = var7 != -1 && var7 != 1?(field1011 + MouseInput.mouseLastX) / 2:MouseInput.mouseLastX;
                                             } else {
                                                if(KeyFocusListener.keyPressed[96]) {
                                                   field964 += (-24 - field964) / 2;
                                                } else if(KeyFocusListener.keyPressed[97]) {
                                                   field964 += (24 - field964) / 2;
                                                } else {
                                                   field964 /= 2;
                                                }

                                                if(KeyFocusListener.keyPressed[98]) {
                                                   field944 += (12 - field944) / 2;
                                                } else if(KeyFocusListener.keyPressed[99]) {
                                                   field944 += (-12 - field944) / 2;
                                                } else {
                                                   field944 /= 2;
                                                }

                                                field890 = MouseInput.mouseLastY;
                                                field1011 = MouseInput.mouseLastX;
                                             }

                                             mapAngle = field964 / 2 + mapAngle & 2047;
                                             cameraPitchTarget += field944 / 2;
                                             if(cameraPitchTarget < 128) {
                                                cameraPitchTarget = 128;
                                             }

                                             if(cameraPitchTarget > 383) {
                                                cameraPitchTarget = 383;
                                             }

                                             var6 = AbstractByteBuffer.field2564 >> 7;
                                             var7 = BaseVarType.field25 >> 7;
                                             var8 = WorldMapType1.getTileHeight(AbstractByteBuffer.field2564, BaseVarType.field25, class230.plane);
                                             var9 = 0;
                                             if(var6 > 3 && var7 > 3 && var6 < 100 && var7 < 100) {
                                                for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                   for(int var27 = var7 - 4; var27 <= var7 + 4; ++var27) {
                                                      int var12 = class230.plane;
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

                                             if(var10 > field894) {
                                                field894 += (var10 - field894) / 24;
                                             } else if(var10 < field894) {
                                                field894 += (var10 - field894) / 80;
                                             }

                                             if(field983) {
                                                MapLabel.method375();
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1054[var4];
                                             }

                                             class60.chatMessages.process();
                                             var4 = class84.method1853();
                                             var5 = class31.method303();
                                             if(var4 > 15000 && var5 > 15000) {
                                                field864 = 250;
                                                class223.method4132(14500);
                                                var18 = class61.method1076(ClientPacket.field2411, field863.field1434);
                                                field863.method2039(var18);
                                             }

                                             ContextMenuRow.friendManager.method1699();
                                             ++field863.field1440;
                                             if(field863.field1440 > 50) {
                                                var18 = class61.method1076(ClientPacket.field2385, field863.field1434);
                                                field863.method2039(var18);
                                             }

                                             try {
                                                field863.method2057();
                                             } catch (IOException var28) {
                                                if(field864 > 0) {
                                                   VertexNormal.method2800();
                                                } else {
                                                   field912.method5599();
                                                   WorldMapType1.setGameState(40);
                                                   class1.field11 = field863.getSocket();
                                                   field863.method2035();
                                                }
                                             }

                                             return;
                                          }

                                          var41 = var40.widget;
                                          if(var41.index < 0) {
                                             break;
                                          }

                                          var39 = NetWriter.getWidget(var41.parentId);
                                       } while(var39 == null || var39.children == null || var41.index >= var39.children.length || var41 != var39.children[var41.index]);

                                       class194.method3791(var40);
                                    }
                                 }

                                 var41 = var40.widget;
                                 if(var41.index < 0) {
                                    break;
                                 }

                                 var39 = NetWriter.getWidget(var41.parentId);
                              } while(var39 == null || var39.children == null || var41.index >= var39.children.length || var41 != var39.children[var41.index]);

                              class194.method3791(var40);
                           }
                        }

                        var41 = var40.widget;
                        if(var41.index < 0) {
                           break;
                        }

                        var39 = NetWriter.getWidget(var41.parentId);
                     } while(var39 == null || var39.children == null || var41.index >= var39.children.length || var41 != var39.children[var41.index]);

                     class194.method3791(var40);
                  }
               }

               var31 = class61.method1076(ClientPacket.field2433, field863.field1434);
               var31.packetBuffer.putByte(0);
               var3 = var31.packetBuffer.offset;
               class63.encodeClassVerifier(var31.packetBuffer);
               var31.packetBuffer.method3545(var31.packetBuffer.offset - var3);
               field863.method2039(var31);
            }
         }
      }
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-46"
   )
   void method1243() {
      int var1 = class1.canvasWidth;
      int var2 = class25.canvasHeight;
      if(super.field652 < var1) {
         var1 = super.field652;
      }

      if(super.field632 < var2) {
         var2 = super.field632;
      }

      if(preferences != null) {
         try {
            class52.method802(RenderOverview.clientInstance, "resize", new Object[]{Integer.valueOf(class70.method1179())});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-996507123"
   )
   final void method1393() {
      if(widgetRoot != -1) {
         Renderable.method3050(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field979[var1]) {
            field820[var1] = true;
         }

         field1031[var1] = field979[var1];
         field979[var1] = false;
      }

      field877 = gameCycle;
      field952 = -1;
      field953 = -1;
      class109.field1552 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         Spotanim.method4793(widgetRoot, 0, 0, class1.canvasWidth, class25.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      int var4;
      int var6;
      int var7;
      int var12;
      if(!isMenuOpen) {
         if(field952 != -1) {
            GameEngine.method890(field952, field953);
         }
      } else {
         var1 = class25.menuX;
         var2 = Size.menuY;
         var3 = class166.field2172;
         var4 = BoundingBox2D.field231;
         int var13 = 6116423;
         Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var13);
         Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         class153.fontBold12.method5451("Choose Option", var1 + 3, var2 + 14, var13, -1);
         var6 = MouseInput.mouseLastX;
         var7 = MouseInput.mouseLastY;

         for(var12 = 0; var12 < menuOptionCount; ++var12) {
            int var14 = (menuOptionCount - 1 - var12) * 15 + var2 + 31;
            int var15 = 16777215;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var14 - 13 && var7 < var14 + 3) {
               var15 = 16776960;
            }

            class153.fontBold12.method5451(WorldComparator.method71(var12), var1 + 3, var14, var15, 0);
         }

         class70.method1177(class25.menuX, Size.menuY, class166.field2172, BoundingBox2D.field231);
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field1031[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field820[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class230.plane;
      var2 = OwnWorldComparator.localPlayer.x;
      var3 = OwnWorldComparator.localPlayer.y;
      var4 = field878;

      for(class79 var5 = (class79)class79.field1210.getFront(); var5 != null; var5 = (class79)class79.field1210.getNext()) {
         if(var5.field1207 != -1 || var5.field1211 != null) {
            var6 = 0;
            if(var2 > var5.field1204) {
               var6 += var2 - var5.field1204;
            } else if(var2 < var5.field1202) {
               var6 += var5.field1202 - var2;
            }

            if(var3 > var5.field1208) {
               var6 += var3 - var5.field1208;
            } else if(var3 < var5.field1203) {
               var6 += var5.field1203 - var3;
            }

            if(var6 - 64 <= var5.field1206 && field1041 != 0 && var1 == var5.field1205) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = (var5.field1206 - var6) * field1041 / var5.field1206;
               Object var10000;
               if(var5.field1201 == null) {
                  if(var5.field1207 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.getTrack(class54.indexCache4, var5.field1207, 0);
                     if(var8 != null) {
                        RawAudioNode var9 = var8.method2124().applyResampler(class197.field2565);
                        class114 var10 = class114.method2315(var9, 100, var7);
                        var10.method2318(-1);
                        KeyFocusListener.field583.method2064(var10);
                        var5.field1201 = var10;
                     }
                  }
               } else {
                  var5.field1201.method2319(var7);
               }

               if(var5.field1213 == null) {
                  if(var5.field1211 != null && (var5.field1216 -= var4) <= 0) {
                     var12 = (int)(Math.random() * (double)var5.field1211.length);
                     var10000 = null;
                     SoundEffect var16 = SoundEffect.getTrack(class54.indexCache4, var5.field1211[var12], 0);
                     if(var16 != null) {
                        RawAudioNode var17 = var16.method2124().applyResampler(class197.field2565);
                        class114 var11 = class114.method2315(var17, 100, var7);
                        var11.method2318(0);
                        KeyFocusListener.field583.method2064(var11);
                        var5.field1213 = var11;
                        var5.field1216 = var5.field1209 + (int)(Math.random() * (double)(var5.field1212 - var5.field1209));
                     }
                  }
               } else {
                  var5.field1213.method2319(var7);
                  if(!var5.field1213.linked()) {
                     var5.field1213 = null;
                  }
               }
            } else {
               if(var5.field1201 != null) {
                  KeyFocusListener.field583.method2069(var5.field1201);
                  var5.field1201 = null;
               }

               if(var5.field1213 != null) {
                  KeyFocusListener.field583.method2069(var5.field1213);
                  var5.field1213 = null;
               }
            }
         }
      }

      field878 = 0;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Lcf;I)Z",
      garbageValue = "1447303370"
   )
   final boolean method1261(NetWriter var1) {
      class168 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         String var24;
         int var25;
         try {
            int var5;
            if(var1.serverPacket == null) {
               if(var1.field1444) {
                  if(!var2.vmethod3341(1)) {
                     return false;
                  }

                  var2.vmethod3321(var1.packetBuffer.payload, 0, 1);
                  var1.field1439 = 0;
                  var1.field1444 = false;
               }

               var3.offset = 0;
               if(var3.method3863()) {
                  if(!var2.vmethod3341(1)) {
                     return false;
                  }

                  var2.vmethod3321(var1.packetBuffer.payload, 1, 1);
                  var1.field1439 = 0;
               }

               var1.field1444 = true;
               ServerPacket[] var4 = ScriptEvent.method1137();
               var5 = var3.method3836();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.serverPacket = var4[var5];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3341(1)) {
                  return false;
               }

               var1.getSocket().vmethod3321(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3341(2)) {
                  return false;
               }

               var1.getSocket().vmethod3321(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3341(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3321(var3.payload, 0, var1.packetLength);
            var1.field1439 = 0;
            field912.method5603();
            var1.field1443 = var1.field1442;
            var1.field1442 = var1.field1441;
            var1.field1441 = var1.serverPacket;
            int var23;
            if(ServerPacket.field2279 == var1.serverPacket) {
               class65.field734 = var3.readUnsignedByteNegate();
               MessageNode.field774 = var3.method3575();

               while(var3.offset < var1.packetLength) {
                  var23 = var3.readUnsignedByte();
                  class182[] var84 = new class182[]{class182.field2453, class182.field2445, class182.field2447, class182.field2448, class182.field2449, class182.field2450, class182.field2456, class182.field2455, class182.field2451, class182.field2452};
                  class182 var73 = var84[var23];
                  class272.method4891(var73);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2327 == var1.serverPacket) {
               var23 = var3.readInt();
               var5 = var3.readInt();
               var25 = class29.method272();
               PacketNode var66 = class61.method1076(ClientPacket.field2405, field863.field1434);
               var66.packetBuffer.putInt(var23);
               var66.packetBuffer.method3624(var5);
               var66.packetBuffer.method3574(var25);
               var66.packetBuffer.method3573(GameEngine.FPS);
               field863.method2039(var66);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2291 == var1.serverPacket) {
               for(var23 = 0; var23 < class197.field2566; ++var23) {
                  VarPlayerType var82 = PendingSpawn.method1617(var23);
                  if(var82 != null) {
                     class231.settings[var23] = 0;
                     class231.widgetSettings[var23] = 0;
                  }
               }

               NetWriter.method2041();
               field991 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2294 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var25 = var3.readUnsignedShort();
               if(field1040 != 0 && var5 != 0 && queuedSoundEffectCount < 50) {
                  queuedSoundEffectIDs[queuedSoundEffectCount] = var23;
                  unknownSoundValues1[queuedSoundEffectCount] = var5;
                  unknownSoundValues2[queuedSoundEffectCount] = var25;
                  audioEffects[queuedSoundEffectCount] = null;
                  soundLocations[queuedSoundEffectCount] = 0;
                  ++queuedSoundEffectCount;
               }

               var1.serverPacket = null;
               return true;
            }

            int var8;
            int var9;
            int var26;
            Widget var63;
            if(ServerPacket.field2289 == var1.serverPacket) {
               var23 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var5 += 32768;
               }

               if(var23 >= 0) {
                  var63 = NetWriter.getWidget(var23);
               } else {
                  var63 = null;
               }

               for(; var3.offset < var1.packetLength; ChatLineBuffer.setItemTableSlot(var5, var26, var8 - 1, var9)) {
                  var26 = var3.getUSmart();
                  var8 = var3.readUnsignedShort();
                  var9 = 0;
                  if(var8 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var63 != null && var26 >= 0 && var26 < var63.itemIds.length) {
                     var63.itemIds[var26] = var8;
                     var63.itemQuantities[var26] = var9;
                  }
               }

               if(var63 != null) {
                  ScriptEvent.method1132(var63);
               }

               NetWriter.method2041();
               interfaceItemTriggers[++field1016 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            String var6;
            String var55;
            String var87;
            if(ServerPacket.field2326 == var1.serverPacket) {
               var55 = var3.readString();
               class45.sessionToken = var55;

               try {
                  var24 = RenderOverview.clientInstance.getParameter(Parameters.field3825.key);
                  var6 = RenderOverview.clientInstance.getParameter(Parameters.field3833.key);
                  String var64 = var24 + "settings=" + var55 + "; version=1; path=/; domain=" + var6;
                  if(var55.length() == 0) {
                     var64 = var64 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var64 = var64 + "; Expires=" + class166.method3258(class188.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
                  }

                  Client var91 = RenderOverview.clientInstance;
                  var87 = "document.cookie=\"" + var64 + "\"";
                  JSObject.getWindow(var91).eval(var87);
               } catch (Throwable var47) {
                  ;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2307 == var1.serverPacket) {
               VarPlayerType.method4722(false, var3);
               var1.serverPacket = null;
               return true;
            }

            Widget var81;
            if(ServerPacket.field2314 == var1.serverPacket) {
               var23 = var3.method3594();
               var81 = NetWriter.getWidget(var23);
               var81.modelType = 3;
               var81.modelId = OwnWorldComparator.localPlayer.composition.method4400();
               ScriptEvent.method1132(var81);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2280 == var1.serverPacket) {
               var23 = var3.method3594();
               var5 = var3.method3699();
               var63 = NetWriter.getWidget(var23);
               if(var63.modelType != 2 || var5 != var63.modelId) {
                  var63.modelType = 2;
                  var63.modelId = var5;
                  ScriptEvent.method1132(var63);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2324 == var1.serverPacket) {
               var23 = var3.method3699();
               var5 = var3.method3594();
               class231.settings[var23] = var5;
               if(class231.widgetSettings[var23] != var5) {
                  class231.widgetSettings[var23] = var5;
               }

               AbstractSoundSystem.method2232(var23);
               field990[++field991 - 1 & 31] = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2309 == var1.serverPacket) {
               NetWriter.method2041();
               weight = var3.readShort();
               field907 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2263 == var1.serverPacket) {
               for(var23 = 0; var23 < class231.widgetSettings.length; ++var23) {
                  if(class231.widgetSettings[var23] != class231.settings[var23]) {
                     class231.widgetSettings[var23] = class231.settings[var23];
                     AbstractSoundSystem.method2232(var23);
                     field990[++field991 - 1 & 31] = var23;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2272 == var1.serverPacket) {
               var23 = var3.readInt();
               var81 = NetWriter.getWidget(var23);

               for(var25 = 0; var25 < var81.itemIds.length; ++var25) {
                  var81.itemIds[var25] = -1;
                  var81.itemIds[var25] = 0;
               }

               ScriptEvent.method1132(var81);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2303 == var1.serverPacket) {
               World var59 = new World();
               var59.address = var3.readString();
               var59.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var59.mask = var5;
               WorldMapType1.setGameState(45);
               var2.vmethod3317();
               var2 = null;
               class44.method656(var59);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2281 == var1.serverPacket) {
               class272.method4891(class182.field2453);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2332 == var1.serverPacket) {
               publicChatMode = var3.readUnsignedByte();
               field1021 = var3.readUnsignedByteNegate();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2275 == var1.serverPacket) {
               class272.method4891(class182.field2452);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2262 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readString();
               var63 = NetWriter.getWidget(var23);
               if(!var24.equals(var63.text)) {
                  var63.text = var24;
                  ScriptEvent.method1132(var63);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2265 == var1.serverPacket) {
               if(var1.packetLength == 0) {
                  class2.clanMemberManager = null;
               } else {
                  if(class2.clanMemberManager == null) {
                     class2.clanMemberManager = new ClanMemberManager(class234.loginType, RenderOverview.clientInstance);
                  }

                  class2.clanMemberManager.method5397(var3);
               }

               field998 = cycleCntr;
               SceneTilePaint.field1924 = true;
               var1.serverPacket = null;
               return true;
            }

            boolean var92;
            if(ServerPacket.field2285 == var1.serverPacket) {
               var92 = var3.readUnsignedByte() == 1;
               var5 = var3.method3594();
               var63 = NetWriter.getWidget(var5);
               if(var92 != var63.isHidden) {
                  var63.isHidden = var92;
                  ScriptEvent.method1132(var63);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2320 == var1.serverPacket) {
               var23 = var3.method3595();
               var5 = var3.method3699();
               var63 = NetWriter.getWidget(var23);
               if(var63.modelType != 1 || var5 != var63.modelId) {
                  var63.modelType = 1;
                  var63.modelId = var5;
                  ScriptEvent.method1132(var63);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2301 == var1.serverPacket) {
               var5 = var3.readUnsignedByte();
               class312[] var65 = Player.method1210();
               var26 = 0;

               class312 var57;
               while(true) {
                  if(var26 >= var65.length) {
                     var57 = null;
                     break;
                  }

                  class312 var90 = var65[var26];
                  if(var5 == var90.field3853) {
                     var57 = var90;
                     break;
                  }

                  ++var26;
               }

               class70.field779 = var57;
               var1.serverPacket = null;
               return true;
            }

            WidgetNode var7;
            if(ServerPacket.field2317 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByteNegate();
               var25 = var3.method3595();
               var7 = (WidgetNode)componentTable.get((long)var25);
               if(var7 != null) {
                  AbstractByteBuffer.method3808(var7, var23 != var7.id);
               }

               WidgetNode var89 = new WidgetNode();
               var89.id = var23;
               var89.owner = var5;
               componentTable.put(var89, (long)var25);
               class245.method4508(var23);
               Widget var88 = NetWriter.getWidget(var25);
               ScriptEvent.method1132(var88);
               if(field930 != null) {
                  ScriptEvent.method1132(field930);
                  field930 = null;
               }

               ItemLayer.method2598();
               GrandExchangeOffer.method119(Widget.widgets[var25 >> 16], var88, false);
               ScriptVarType.method25(var23);
               if(widgetRoot != -1) {
                  FrameMap.method2881(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2310 == var1.serverPacket) {
               if(class2.clanMemberManager != null) {
                  class2.clanMemberManager.method5424(var3);
               }

               field998 = cycleCntr;
               SceneTilePaint.field1924 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2298 == var1.serverPacket) {
               class272.method4891(class182.field2451);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2293 == var1.serverPacket) {
               field983 = false;

               for(var23 = 0; var23 < 5; ++var23) {
                  field1050[var23] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2278 == var1.serverPacket) {
               class272.method4891(class182.field2445);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2313 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var23] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var23] = new GrandExchangeOffer(var3, false);
               }

               field999 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2333 == var1.serverPacket) {
               var23 = var3.readInt();
               WidgetNode var80 = (WidgetNode)componentTable.get((long)var23);
               if(var80 != null) {
                  AbstractByteBuffer.method3808(var80, true);
               }

               if(field930 != null) {
                  ScriptEvent.method1132(field930);
                  field930 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2325 == var1.serverPacket) {
               var23 = var3.method3564();
               var5 = var3.method3595();
               var63 = NetWriter.getWidget(var5);
               if(var23 != var63.field2824 || var23 == -1) {
                  var63.field2824 = var23;
                  var63.field2899 = 0;
                  var63.field2800 = 0;
                  ScriptEvent.method1132(var63);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var60;
            if(ServerPacket.field2260 == var1.serverPacket) {
               var23 = var3.method3699();
               var5 = var3.method3696();
               var25 = var3.method3666();
               var60 = NetWriter.getWidget(var5);
               var60.field2833 = var23 + (var25 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2268 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var25 = var3.readUnsignedByte();
               var26 = var3.readUnsignedByte();
               field1050[var23] = true;
               field1051[var23] = var5;
               field1052[var23] = var25;
               field889[var23] = var26;
               field1054[var23] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2312 == var1.serverPacket) {
               var23 = var3.method3666();
               var5 = var3.readInt();
               var25 = var23 >> 10 & 31;
               var26 = var23 >> 5 & 31;
               var8 = var23 & 31;
               var9 = (var26 << 11) + (var25 << 19) + (var8 << 3);
               Widget var68 = NetWriter.getWidget(var5);
               if(var9 != var68.textColor) {
                  var68.textColor = var9;
                  ScriptEvent.method1132(var68);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2283 == var1.serverPacket) {
               class65.field734 = var3.readUnsignedByteNegate();
               MessageNode.field774 = var3.method3577();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2319 == var1.serverPacket) {
               MouseRecorder.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2300 == var1.serverPacket) {
               class272.method4891(class182.field2456);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2266 == var1.serverPacket) {
               var55 = var3.readString();
               var24 = FontTypeFace.appendTags(class61.method1062(ISAACCipher.method3887(var3)));
               class149.sendGameMessage(6, var55, var24);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               var23 = var3.method3699();
               byte var69 = var3.method3685();
               class231.settings[var23] = var69;
               if(class231.widgetSettings[var23] != var69) {
                  class231.widgetSettings[var23] = var69;
               }

               AbstractSoundSystem.method2232(var23);
               field990[++field991 - 1 & 31] = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2316 == var1.serverPacket) {
               var23 = var3.method3699();
               class45.method677(var23);
               interfaceItemTriggers[++field1016 - 1 & 31] = var23 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2256 == var1.serverPacket) {
               var23 = var3.method3699();
               var5 = var3.method3595();
               var63 = NetWriter.getWidget(var5);
               if(var63 != null && var63.type == 0) {
                  if(var23 > var63.scrollHeight - var63.height) {
                     var23 = var63.scrollHeight - var63.height;
                  }

                  if(var23 < 0) {
                     var23 = 0;
                  }

                  if(var23 != var63.scrollY) {
                     var63.scrollY = var23;
                     ScriptEvent.method1132(var63);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            int var29;
            if(ServerPacket.field2322 == var1.serverPacket) {
               var23 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var5 += 32768;
               }

               if(var23 >= 0) {
                  var63 = NetWriter.getWidget(var23);
               } else {
                  var63 = null;
               }

               if(var63 != null) {
                  for(var26 = 0; var26 < var63.itemIds.length; ++var26) {
                     var63.itemIds[var26] = 0;
                     var63.itemQuantities[var26] = 0;
                  }
               }

               class40.method561(var5);
               var26 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var26; ++var8) {
                  var9 = var3.method3666();
                  var29 = var3.readUnsignedByte();
                  if(var29 == 255) {
                     var29 = var3.method3594();
                  }

                  if(var63 != null && var8 < var63.itemIds.length) {
                     var63.itemIds[var8] = var9;
                     var63.itemQuantities[var8] = var29;
                  }

                  ChatLineBuffer.setItemTableSlot(var5, var8, var9 - 1, var29);
               }

               if(var63 != null) {
                  ScriptEvent.method1132(var63);
               }

               NetWriter.method2041();
               interfaceItemTriggers[++field1016 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2311 == var1.serverPacket) {
               var92 = var3.readUnsignedByte() == 1;
               if(var92) {
                  class1.field0 = class188.currentTimeMs() - var3.readLong();
                  class1.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  class1.grandExchangeEvents = null;
               }

               field884 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2331 == var1.serverPacket) {
               class272.method4891(class182.field2447);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               field983 = true;
               class157.field2116 = var3.readUnsignedByte();
               field1038 = var3.readUnsignedByte();
               class224.field2650 = var3.readUnsignedShort();
               Script.field1412 = var3.readUnsignedByte();
               DynamicObject.field1425 = var3.readUnsignedByte();
               if(DynamicObject.field1425 >= 100) {
                  MapIcon.cameraX = class157.field2116 * 128 + 64;
                  CombatInfo1.cameraY = field1038 * 128 + 64;
                  class159.cameraZ = WorldMapType1.getTileHeight(MapIcon.cameraX, CombatInfo1.cameraY, class230.plane) - class224.field2650;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2330 == var1.serverPacket) {
               field836 = var3.readUnsignedShortOb1() * 30;
               field907 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2267 == var1.serverPacket) {
               ContextMenuRow.friendManager.method1702(var3, var1.packetLength);
               field997 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2288 == var1.serverPacket) {
               NetWriter.method2041();
               var23 = var3.readInt();
               var5 = var3.method3575();
               var25 = var3.method3577();
               skillExperiences[var5] = var23;
               boostedSkillLevels[var5] = var25;
               realSkillLevels[var5] = 1;

               for(var26 = 0; var26 < 98; ++var26) {
                  if(var23 >= class242.field2961[var26]) {
                     realSkillLevels[var5] = var26 + 2;
                  }
               }

               field994[++field995 - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            Widget var27;
            if(ServerPacket.field2269 == var1.serverPacket) {
               var23 = var3.method3696();
               var5 = var3.method3594();
               WidgetNode var62 = (WidgetNode)componentTable.get((long)var5);
               var7 = (WidgetNode)componentTable.get((long)var23);
               if(var7 != null) {
                  AbstractByteBuffer.method3808(var7, var62 == null || var62.id != var7.id);
               }

               if(var62 != null) {
                  var62.unlink();
                  componentTable.put(var62, (long)var23);
               }

               var27 = NetWriter.getWidget(var5);
               if(var27 != null) {
                  ScriptEvent.method1132(var27);
               }

               var27 = NetWriter.getWidget(var23);
               if(var27 != null) {
                  ScriptEvent.method1132(var27);
                  GrandExchangeOffer.method119(Widget.widgets[var27.id >>> 16], var27, true);
               }

               if(widgetRoot != -1) {
                  FrameMap.method2881(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2302 == var1.serverPacket) {
               var23 = var3.method3699();
               widgetRoot = var23;
               this.method1491(false);
               class245.method4508(var23);
               ScriptVarType.method25(widgetRoot);

               for(var5 = 0; var5 < 100; ++var5) {
                  field979[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            long var30;
            if(ServerPacket.field2271 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               if(var23 == 65535) {
                  var23 = -1;
               }

               var5 = var3.method3594();
               var25 = var3.method3696();
               var26 = var3.readUnsignedShort();
               if(var26 == 65535) {
                  var26 = -1;
               }

               for(var8 = var26; var8 <= var23; ++var8) {
                  var30 = (long)var8 + ((long)var25 << 32);
                  Node var70 = widgetFlags.get(var30);
                  if(var70 != null) {
                     var70.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var5), var30);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2259 == var1.serverPacket) {
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

            int var15;
            String var83;
            if(ServerPacket.field2292 == var1.serverPacket) {
               var23 = var1.packetLength;
               ClassInfo var79 = new ClassInfo();
               var79.count = var3.readUnsignedByte();
               var79.field3865 = var3.readInt();
               var79.type = new int[var79.count];
               var79.errorIdentifiers = new int[var79.count];
               var79.fields = new Field[var79.count];
               var79.field3870 = new int[var79.count];
               var79.methods = new Method[var79.count];
               var79.args = new byte[var79.count][][];

               for(var25 = 0; var25 < var79.count; ++var25) {
                  try {
                     var26 = var3.readUnsignedByte();
                     if(var26 != 0 && var26 != 1 && var26 != 2) {
                        if(var26 == 3 || var26 == 4) {
                           var83 = var3.readString();
                           var87 = var3.readString();
                           var29 = var3.readUnsignedByte();
                           String[] var67 = new String[var29];

                           for(int var71 = 0; var71 < var29; ++var71) {
                              var67[var71] = var3.readString();
                           }

                           String var93 = var3.readString();
                           byte[][] var74 = new byte[var29][];
                           if(var26 == 3) {
                              for(int var76 = 0; var76 < var29; ++var76) {
                                 var15 = var3.readInt();
                                 var74[var76] = new byte[var15];
                                 var3.readBytes(var74[var76], 0, var15);
                              }
                           }

                           var79.type[var25] = var26;
                           Class[] var33 = new Class[var29];

                           for(var15 = 0; var15 < var29; ++var15) {
                              var33[var15] = class2.loadClassFromDescriptor(var67[var15]);
                           }

                           Class var94 = class2.loadClassFromDescriptor(var93);
                           if(class2.loadClassFromDescriptor(var83).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var77 = class2.loadClassFromDescriptor(var83).getDeclaredMethods();
                           Method[] var17 = var77;

                           for(int var18 = 0; var18 < var17.length; ++var18) {
                              Method var19 = var17[var18];
                              if(Reflection.getMethodName(var19).equals(var87)) {
                                 Class[] var20 = Reflection.getParameterTypes(var19);
                                 if(var20.length == var33.length) {
                                    boolean var21 = true;

                                    for(int var22 = 0; var22 < var33.length; ++var22) {
                                       if(var20[var22] != var33[var22]) {
                                          var21 = false;
                                          break;
                                       }
                                    }

                                    if(var21 && var94 == var19.getReturnType()) {
                                       var79.methods[var25] = var19;
                                    }
                                 }
                              }
                           }

                           var79.args[var25] = var74;
                        }
                     } else {
                        var83 = var3.readString();
                        var87 = var3.readString();
                        var29 = 0;
                        if(var26 == 1) {
                           var29 = var3.readInt();
                        }

                        var79.type[var25] = var26;
                        var79.field3870[var25] = var29;
                        if(class2.loadClassFromDescriptor(var83).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var79.fields[var25] = Reflection.findField(class2.loadClassFromDescriptor(var83), var87);
                     }
                  } catch (ClassNotFoundException var48) {
                     var79.errorIdentifiers[var25] = -1;
                  } catch (SecurityException var49) {
                     var79.errorIdentifiers[var25] = -2;
                  } catch (NullPointerException var50) {
                     var79.errorIdentifiers[var25] = -3;
                  } catch (Exception var51) {
                     var79.errorIdentifiers[var25] = -4;
                  } catch (Throwable var52) {
                     var79.errorIdentifiers[var25] = -5;
                  }
               }

               class317.classInfos.addFirst(var79);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2290 == var1.serverPacket) {
               var23 = var3.method3666();
               if(var23 == 65535) {
                  var23 = -1;
               }

               class20.method168(var23);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2304 == var1.serverPacket) {
               var23 = var3.method3666();
               if(var23 == 65535) {
                  var23 = -1;
               }

               var5 = var3.method3589();
               class5.method12(var23, var5);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2276 == var1.serverPacket) {
               MouseRecorder.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2261 == var1.serverPacket) {
               class162.method3217(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2258 == var1.serverPacket) {
               var23 = var3.method3696();
               var5 = var3.method3696();
               var25 = var3.method3666();
               if(var25 == 65535) {
                  var25 = -1;
               }

               var60 = NetWriter.getWidget(var5);
               ItemComposition var85;
               if(!var60.hasScript) {
                  if(var25 == -1) {
                     var60.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var85 = ContextMenuRow.getItemDefinition(var25);
                  var60.modelType = 4;
                  var60.modelId = var25;
                  var60.rotationX = var85.xan2d;
                  var60.rotationZ = var85.yan2d;
                  var60.modelZoom = var85.zoom2d * 100 / var23;
                  ScriptEvent.method1132(var60);
               } else {
                  var60.itemId = var25;
                  var60.itemQuantity = var23;
                  var85 = ContextMenuRow.getItemDefinition(var25);
                  var60.rotationX = var85.xan2d;
                  var60.rotationZ = var85.yan2d;
                  var60.rotationY = var85.zan2d;
                  var60.field2835 = var85.offsetX2d;
                  var60.field2795 = var85.offsetY2d;
                  var60.modelZoom = var85.zoom2d;
                  if(var85.isStackable == 1) {
                     var60.field2858 = 1;
                  } else {
                     var60.field2858 = 2;
                  }

                  if(var60.field2832 > 0) {
                     var60.modelZoom = var60.modelZoom * 32 / var60.field2832;
                  } else if(var60.originalWidth > 0) {
                     var60.modelZoom = var60.modelZoom * 32 / var60.originalWidth;
                  }

                  ScriptEvent.method1132(var60);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2296 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  var23 = var3.offset - 28;
                  class21.method171(var3.payload, var23);
                  if(class166.randomDat != null) {
                     try {
                        class166.randomDat.seek(0L);
                        class166.randomDat.write(var3.payload, var23, 24);
                     } catch (Exception var46) {
                        ;
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2306 == var1.serverPacket) {
               class272.method4891(class182.field2455);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2273 == var1.serverPacket) {
               var55 = var3.readString();
               Object[] var78 = new Object[var55.length() + 1];

               for(var25 = var55.length() - 1; var25 >= 0; --var25) {
                  if(var55.charAt(var25) == 's') {
                     var78[var25 + 1] = var3.readString();
                  } else {
                     var78[var25 + 1] = new Integer(var3.readInt());
                  }
               }

               var78[0] = new Integer(var3.readInt());
               ScriptEvent var61 = new ScriptEvent();
               var61.objs = var78;
               class194.method3791(var61);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2270 == var1.serverPacket) {
               MessageNode.field774 = var3.method3575();
               class65.field734 = var3.readUnsignedByteNegate();

               for(var23 = MessageNode.field774; var23 < MessageNode.field774 + 8; ++var23) {
                  for(var5 = class65.field734; var5 < class65.field734 + 8; ++var5) {
                     if(groundItemDeque[class230.plane][var23][var5] != null) {
                        groundItemDeque[class230.plane][var23][var5] = null;
                        class22.groundItemSpawned(var23, var5);
                     }
                  }
               }

               for(PendingSpawn var56 = (PendingSpawn)pendingSpawns.getFront(); var56 != null; var56 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var56.x >= MessageNode.field774 && var56.x < MessageNode.field774 + 8 && var56.y >= class65.field734 && var56.y < class65.field734 + 8 && var56.level == class230.plane) {
                     var56.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2308 == var1.serverPacket) {
               var23 = var3.getUSmart();
               boolean var58 = var3.readUnsignedByte() == 1;
               var6 = "";
               boolean var86 = false;
               if(var58) {
                  var6 = var3.readString();
                  if(ContextMenuRow.friendManager.method1701(new Name(var6, class234.loginType))) {
                     var86 = true;
                  }
               }

               var83 = var3.readString();
               if(!var86) {
                  class149.sendGameMessage(var23, var6, var83);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2323 == var1.serverPacket) {
               VarPlayerType.method4722(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2257 == var1.serverPacket) {
               VertexNormal.method2800();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2286 == var1.serverPacket) {
               class272.method4891(class182.field2450);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2329 == var1.serverPacket) {
               ContextMenuRow.friendManager.method1696();
               field997 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2277 == var1.serverPacket) {
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

            if(ServerPacket.field2282 == var1.serverPacket) {
               NetWriter.method2041();
               energy = var3.readUnsignedByte();
               field907 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2264 == var1.serverPacket) {
               field834 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2321 == var1.serverPacket) {
               field983 = true;
               class131.field1879 = var3.readUnsignedByte();
               class304.field3804 = var3.readUnsignedByte();
               AbstractSoundSystem.field1524 = var3.readUnsignedShort();
               MapLabel.field435 = var3.readUnsignedByte();
               MouseRecorder.field759 = var3.readUnsignedByte();
               if(MouseRecorder.field759 >= 100) {
                  var23 = class131.field1879 * 128 + 64;
                  var5 = class304.field3804 * 128 + 64;
                  var25 = WorldMapType1.getTileHeight(var23, var5, class230.plane) - AbstractSoundSystem.field1524;
                  var26 = var23 - MapIcon.cameraX;
                  var8 = var25 - class159.cameraZ;
                  var9 = var5 - CombatInfo1.cameraY;
                  var29 = (int)Math.sqrt((double)(var9 * var9 + var26 * var26));
                  DecorativeObject.cameraPitch = (int)(Math.atan2((double)var8, (double)var29) * 325.949D) & 2047;
                  class60.cameraYaw = (int)(Math.atan2((double)var26, (double)var9) * -325.949D) & 2047;
                  if(DecorativeObject.cameraPitch < 128) {
                     DecorativeObject.cameraPitch = 128;
                  }

                  if(DecorativeObject.cameraPitch > 383) {
                     DecorativeObject.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2305 == var1.serverPacket) {
               var23 = var3.method3577();
               var5 = var3.method3575();
               var6 = var3.readString();
               if(var23 >= 1 && var23 <= 8) {
                  if(var6.equalsIgnoreCase("null")) {
                     var6 = null;
                  }

                  playerOptions[var23 - 1] = var6;
                  playerOptionsPriorities[var23 - 1] = var5 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2284 == var1.serverPacket) {
               ContextMenuRow.friendManager.field1193.method5227(var3, var1.packetLength);
               class84.method1854();
               if(class2.clanMemberManager != null) {
                  class2.clanMemberManager.method5399();
               }

               field997 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2328 == var1.serverPacket) {
               var23 = var3.method3695();
               var5 = var3.readInt();
               var25 = var3.method3695();
               var60 = NetWriter.getWidget(var5);
               if(var23 != var60.originalX || var25 != var60.originalY || var60.dynamicX != 0 || var60.dynamicY != 0) {
                  var60.originalX = var23;
                  var60.originalY = var25;
                  var60.dynamicX = 0;
                  var60.dynamicY = 0;
                  ScriptEvent.method1132(var60);
                  this.widgetMethod0(var60);
                  if(var60.type == 0) {
                     GrandExchangeOffer.method119(Widget.widgets[var5 >> 16], var60, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2274 == var1.serverPacket) {
               class272.method4891(class182.field2448);
               var1.serverPacket = null;
               return true;
            }

            String var16;
            long var35;
            long var37;
            int var42;
            if(ServerPacket.field2315 == var1.serverPacket) {
               var55 = var3.readString();
               var35 = (long)var3.readUnsignedShort();
               var37 = (long)var3.read24BitInt();
               Permission var28 = (Permission)Tile.forOrdinal(class34.method395(), var3.readUnsignedByte());
               long var39 = (var35 << 32) + var37;
               boolean var12 = false;

               for(int var41 = 0; var41 < 100; ++var41) {
                  if(var39 == field882[var41]) {
                     var12 = true;
                     break;
                  }
               }

               if(ContextMenuRow.friendManager.method1701(new Name(var55, class234.loginType))) {
                  var12 = true;
               }

               if(!var12 && myPlayerIndex == 0) {
                  field882[field1024] = var39;
                  field1024 = (field1024 + 1) % 100;
                  String var72 = FontTypeFace.appendTags(class61.method1062(ISAACCipher.method3887(var3)));
                  byte var75;
                  if(var28.field3294) {
                     var75 = 7;
                  } else {
                     var75 = 3;
                  }

                  if(var28.field3293 != -1) {
                     var42 = var28.field3293;
                     var16 = "<img=" + var42 + ">";
                     class149.sendGameMessage(var75, var16 + var55, var72);
                  } else {
                     class149.sendGameMessage(var75, var55, var72);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            long var43;
            if(ServerPacket.field2287 == var1.serverPacket) {
               var55 = var3.readString();
               var35 = var3.readLong();
               var37 = (long)var3.readUnsignedShort();
               var30 = (long)var3.read24BitInt();
               Permission var11 = (Permission)Tile.forOrdinal(class34.method395(), var3.readUnsignedByte());
               var43 = (var37 << 32) + var30;
               boolean var14 = false;

               for(var15 = 0; var15 < 100; ++var15) {
                  if(var43 == field882[var15]) {
                     var14 = true;
                     break;
                  }
               }

               if(var11.field3295 && ContextMenuRow.friendManager.method1701(new Name(var55, class234.loginType))) {
                  var14 = true;
               }

               if(!var14 && myPlayerIndex == 0) {
                  field882[field1024] = var43;
                  field1024 = (field1024 + 1) % 100;
                  String var34 = FontTypeFace.appendTags(class61.method1062(ISAACCipher.method3887(var3)));
                  if(var11.field3293 != -1) {
                     var42 = var11.field3293;
                     var16 = "<img=" + var42 + ">";
                     class48.addChatMessage(9, var16 + var55, var34, MapIconReference.method728(var35));
                  } else {
                     class48.addChatMessage(9, var55, var34, MapIconReference.method728(var35));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2318 == var1.serverPacket) {
               class272.method4891(class182.field2449);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2297 == var1.serverPacket) {
               var23 = var3.method3699();
               var5 = var3.method3594();
               var25 = var3.readUnsignedShortOb1();
               var26 = var3.method3666();
               var27 = NetWriter.getWidget(var5);
               if(var23 != var27.rotationX || var25 != var27.rotationZ || var26 != var27.modelZoom) {
                  var27.rotationX = var23;
                  var27.rotationZ = var25;
                  var27.modelZoom = var26;
                  ScriptEvent.method1132(var27);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2335 == var1.serverPacket) {
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

            if(ServerPacket.field2334 == var1.serverPacket) {
               var23 = var3.offset + var1.packetLength;
               var5 = var3.readUnsignedShort();
               var25 = var3.readUnsignedShort();
               if(var5 != widgetRoot) {
                  widgetRoot = var5;
                  this.method1491(false);
                  class245.method4508(widgetRoot);
                  ScriptVarType.method25(widgetRoot);

                  for(var26 = 0; var26 < 100; ++var26) {
                     field979[var26] = true;
                  }
               }

               WidgetNode var10;
               for(; var25-- > 0; var10.field739 = true) {
                  var26 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var10 = (WidgetNode)componentTable.get((long)var26);
                  if(var10 != null && var8 != var10.id) {
                     AbstractByteBuffer.method3808(var10, true);
                     var10 = null;
                  }

                  if(var10 == null) {
                     WidgetNode var32 = new WidgetNode();
                     var32.id = var8;
                     var32.owner = var9;
                     componentTable.put(var32, (long)var26);
                     class245.method4508(var8);
                     Widget var13 = NetWriter.getWidget(var26);
                     ScriptEvent.method1132(var13);
                     if(field930 != null) {
                        ScriptEvent.method1132(field930);
                        field930 = null;
                     }

                     ItemLayer.method2598();
                     GrandExchangeOffer.method119(Widget.widgets[var26 >> 16], var13, false);
                     ScriptVarType.method25(var8);
                     if(widgetRoot != -1) {
                        FrameMap.method2881(widgetRoot, 1);
                     }

                     var10 = var32;
                  }
               }

               for(var7 = (WidgetNode)componentTable.first(); var7 != null; var7 = (WidgetNode)componentTable.next()) {
                  if(var7.field739) {
                     var7.field739 = false;
                  } else {
                     AbstractByteBuffer.method3808(var7, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var23) {
                  var26 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var29 = var3.readInt();

                  for(int var45 = var8; var45 <= var9; ++var45) {
                     var43 = ((long)var26 << 32) + (long)var45;
                     widgetFlags.put(new IntegerNode(var29), var43);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2337 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  FrameMap.method2881(widgetRoot, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            class37.method519("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1442 != null?var1.field1442.packetId:-1) + "," + (var1.field1443 != null?var1.field1443.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            VertexNormal.method2800();
         } catch (IOException var53) {
            if(field864 > 0) {
               VertexNormal.method2800();
            } else {
               field912.method5599();
               WorldMapType1.setGameState(40);
               class1.field11 = field863.getSocket();
               field863.method2035();
            }
         } catch (Exception var54) {
            var24 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1442 != null?var1.field1442.packetId:-1) + "," + (var1.field1443 != null?var1.field1443.packetId:-1) + "," + var1.packetLength + "," + (OwnWorldComparator.localPlayer.pathX[0] + ScriptState.baseX) + "," + (OwnWorldComparator.localPlayer.pathY[0] + WorldMapType1.baseY) + ",";

            for(var25 = 0; var25 < var1.packetLength && var25 < 50; ++var25) {
               var24 = var24 + var3.payload[var25] + ",";
            }

            class37.method519(var24, var54);
            VertexNormal.method2800();
         }

         return true;
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "410503257"
   )
   final void method1294() {
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

      if(class25.field348 == null) {
         if(field976 == null) {
            int var11;
            label262: {
               int var13 = MouseInput.mouseLastButton;
               int var8;
               int var10;
               if(isMenuOpen) {
                  if(var13 != 1 && (Size.middleMouseMovesCamera || var13 != 4)) {
                     var2 = MouseInput.mouseLastX;
                     var10 = MouseInput.mouseLastY;
                     if(var2 < class25.menuX - 10 || var2 > class166.field2172 + class25.menuX + 10 || var10 < Size.menuY - 10 || var10 > Size.menuY + BoundingBox2D.field231 + 10) {
                        isMenuOpen = false;
                        BuildType.method4528(class25.menuX, Size.menuY, class166.field2172, BoundingBox2D.field231);
                     }
                  }

                  if(var13 == 1 || !Size.middleMouseMovesCamera && var13 == 4) {
                     var2 = class25.menuX;
                     var10 = Size.menuY;
                     var11 = class166.field2172;
                     var5 = MouseInput.mouseLastPressedX;
                     int var14 = MouseInput.mouseLastPressedY;
                     int var15 = -1;

                     for(var8 = 0; var8 < menuOptionCount; ++var8) {
                        int var9 = var10 + (menuOptionCount - 1 - var8) * 15 + 31;
                        if(var5 > var2 && var5 < var2 + var11 && var14 > var9 - 13 && var14 < var9 + 3) {
                           var15 = var8;
                        }
                     }

                     if(var15 != -1) {
                        WorldComparator.method67(var15);
                     }

                     isMenuOpen = false;
                     BuildType.method4528(class25.menuX, Size.menuY, class166.field2172, BoundingBox2D.field231);
                  }
               } else {
                  var2 = WorldComparator.method62();
                  if((var13 == 1 || !Size.middleMouseMovesCamera && var13 == 4) && var2 >= 0) {
                     var10 = menuTypes[var2];
                     if(var10 == 39 || var10 == 40 || var10 == 41 || var10 == 42 || var10 == 43 || var10 == 33 || var10 == 34 || var10 == 35 || var10 == 36 || var10 == 37 || var10 == 38 || var10 == 1005) {
                        var11 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var12 = NetWriter.getWidget(var5);
                        if(LoginPacket.method3438(class230.getWidgetConfig(var12))) {
                           break label262;
                        }

                        var8 = class230.getWidgetConfig(var12);
                        boolean var7 = (var8 >> 29 & 1) != 0;
                        if(var7) {
                           break label262;
                        }
                     }
                  }

                  if((var13 == 1 || !Size.middleMouseMovesCamera && var13 == 4) && this.method1247()) {
                     var13 = 2;
                  }

                  if((var13 == 1 || !Size.middleMouseMovesCamera && var13 == 4) && menuOptionCount > 0) {
                     WorldComparator.method67(var2);
                  }

                  if(var13 == 2 && menuOptionCount > 0) {
                     this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }
               }

               return;
            }

            if(class25.field348 != null && !itemBeingDragged && menuOptionCount > 0 && !this.method1247()) {
               class308.method5596(field916, field917);
            }

            itemBeingDragged = false;
            itemPressedDuration = 0;
            if(class25.field348 != null) {
               ScriptEvent.method1132(class25.field348);
            }

            class25.field348 = NetWriter.getWidget(var5);
            field934 = var11;
            field916 = MouseInput.mouseLastPressedX;
            field917 = MouseInput.mouseLastPressedY;
            if(var2 >= 0) {
               class45.method682(var2);
            }

            ScriptEvent.method1132(class25.field348);
         }
      }
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "540455230"
   )
   final boolean method1247() {
      int var1 = WorldComparator.method62();
      return (field940 == 1 && menuOptionCount > 2 || CacheFile.method2534(var1)) && !menuBooleanArray[var1];
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-53"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      int var3 = class153.fontBold12.getTextWidth("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = class153.fontBold12.getTextWidth(WorldComparator.method71(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var5 + var3 > class1.canvasWidth) {
         var5 = class1.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var4 + var2 > class25.canvasHeight) {
         var6 = class25.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      GameObject.region.method2972(class230.plane, var1, var2, false);
      isMenuOpen = true;
      class25.menuX = var5;
      Size.menuY = var6;
      class166.field2172 = var3;
      BoundingBox2D.field231 = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1713165551"
   )
   final void method1491(boolean var1) {
      int var2 = widgetRoot;
      int var3 = class1.canvasWidth;
      int var4 = class25.canvasHeight;
      if(class2.loadWidget(var2)) {
         class92.method1939(Widget.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(Lim;I)V",
      garbageValue = "759909381"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:NetWriter.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class1.canvasWidth;
         var4 = class25.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class227.method4318(var1, var3, var4, false);
      WorldComparator.method55(var1, var3, var4);
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   final void method1389() {
      ScriptEvent.method1132(field976);
      ++Projectile.field1361;
      if(field984 && field978) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field1023;
         var2 -= field914;
         if(var1 < field982) {
            var1 = field982;
         }

         if(var1 + field976.width > field982 + field977.width) {
            var1 = field982 + field977.width - field976.width;
         }

         if(var2 < field1004) {
            var2 = field1004;
         }

         if(var2 + field976.height > field1004 + field977.height) {
            var2 = field1004 + field977.height - field976.height;
         }

         int var3 = var1 - field1014;
         int var4 = var2 - field986;
         int var5 = field976.field2853;
         if(Projectile.field1361 > field976.field2854 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field987 = true;
         }

         int var6 = var1 - field982 + field977.scrollX;
         int var7 = var2 - field1004 + field977.scrollY;
         ScriptEvent var8;
         if(field976.field2906 != null && field987) {
            var8 = new ScriptEvent();
            var8.widget = field976;
            var8.field744 = var6;
            var8.field745 = var7;
            var8.objs = field976.field2906;
            class194.method3791(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(field987) {
               if(field976.field2867 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field976;
                  var8.field744 = var6;
                  var8.field745 = var7;
                  var8.field747 = field980;
                  var8.objs = field976.field2867;
                  class194.method3791(var8);
               }

               if(field980 != null) {
                  Widget var9 = field976;
                  int var11 = class230.getWidgetConfig(var9);
                  int var10 = var11 >> 17 & 7;
                  int var12 = var10;
                  Widget var15;
                  if(var10 == 0) {
                     var15 = null;
                  } else {
                     int var13 = 0;

                     while(true) {
                        if(var13 >= var12) {
                           var15 = var9;
                           break;
                        }

                        var9 = NetWriter.getWidget(var9.parentId);
                        if(var9 == null) {
                           var15 = null;
                           break;
                        }

                        ++var13;
                     }
                  }

                  if(var15 != null) {
                     PacketNode var14 = class61.method1076(ClientPacket.field2367, field863.field1434);
                     var14.packetBuffer.method3591(field980.id);
                     var14.packetBuffer.putShort(field976.index);
                     var14.packetBuffer.method3779(field976.id);
                     var14.packetBuffer.method3641(field976.itemId);
                     var14.packetBuffer.writeIntLE16(field980.index);
                     var14.packetBuffer.method3641(field980.itemId);
                     field863.method2039(var14);
                  }
               }
            } else if(this.method1247()) {
               this.openMenu(field1014 + field1023, field914 + field986);
            } else if(menuOptionCount > 0) {
               class308.method5596(field1023 + field1014, field914 + field986);
            }

            field976 = null;
         }

      } else {
         if(Projectile.field1361 > 1) {
            field976 = null;
         }

      }
   }

   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      signature = "(I)Lkp;",
      garbageValue = "1881283594"
   )
   public Name vmethod5341() {
      return OwnWorldComparator.localPlayer != null?OwnWorldComparator.localPlayer.name:null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILca;ZB)I",
      garbageValue = "17"
   )
   static int method1616(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class223.field2643:class80.field1228;
      if(var0 == 1800) {
         class80.intStack[++class80.intStackSize - 1] = class89.method1879(class230.getWidgetConfig(var3));
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
            } else {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class80.intStack[--class80.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
