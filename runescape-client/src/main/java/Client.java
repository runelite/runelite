import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import net.runelite.rs.Reflection;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements class302 {
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = -299381207
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 1888993837
   )
   static int field1071;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      longValue = 4983722533511454649L
   )
   static long field1080;
   @ObfuscatedName("nh")
   static boolean[] field1072;
   @ObfuscatedName("ny")
   static boolean[] field1074;
   @ObfuscatedName("np")
   static boolean[] field1073;
   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 876764695
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("ns")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("re")
   @ObfuscatedGetter(
      intValue = -60576271
   )
   public static int field1135;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = 1593093589
   )
   static int field1060;
   @ObfuscatedName("oh")
   static boolean field1102;
   @ObfuscatedName("ma")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -1013102711
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("ni")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("nl")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("nj")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("nr")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("rj")
   @ObfuscatedSignature(
      signature = "Lby;"
   )
   static final class71 field901;
   @ObfuscatedName("mq")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   static Deque field1066;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = 1447726933
   )
   static int field1084;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -221165305
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -290223619
   )
   static int field951;
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "[Lv;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("rr")
   static int[] field1034;
   @ObfuscatedName("rc")
   static int[] field1131;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1706115197
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -1985891123
   )
   static int field1062;
   @ObfuscatedName("mn")
   static int[] field984;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 1214508087
   )
   static int field1054;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -391075689
   )
   static int field1099;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 2062415053
   )
   static int field881;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 2145658385
   )
   static int field1044;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 819559807
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("rs")
   static ArrayList field871;
   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   static PlayerComposition field1132;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 1554057687
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("rn")
   @ObfuscatedGetter(
      intValue = 85476745
   )
   static int field935;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -614511355
   )
   @Export("queuedSoundEffectCount")
   static int queuedSoundEffectCount;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 319740773
   )
   static int field1138;
   @ObfuscatedName("po")
   @Export("unknownSoundValues2")
   static int[] unknownSoundValues2;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -560919923
   )
   static int field996;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 1938466231
   )
   static int field1064;
   @ObfuscatedName("ph")
   @ObfuscatedSignature(
      signature = "[Lcj;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 464570941
   )
   static int field1026;
   @ObfuscatedName("pd")
   @Export("queuedSoundEffectIDs")
   static int[] queuedSoundEffectIDs;
   @ObfuscatedName("pe")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = -946689099
   )
   static int field1075;
   @ObfuscatedName("pw")
   static boolean field1111;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = -1341333607
   )
   static int field1093;
   @ObfuscatedName("pq")
   static boolean[] field955;
   @ObfuscatedName("pi")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 1942746473
   )
   static int field967;
   @ObfuscatedName("oj")
   @ObfuscatedSignature(
      signature = "[Lld;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("ox")
   static int[] field1094;
   @ObfuscatedName("oy")
   static int[] field1095;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      longValue = -4587210699600681837L
   )
   static long field1091;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 369049527
   )
   static int field952;
   @ObfuscatedName("ok")
   static int[] field968;
   @ObfuscatedName("my")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   static Deque field1067;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -1814238315
   )
   static int field1056;
   @ObfuscatedName("ob")
   static int[] field1089;
   @ObfuscatedName("mj")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   static Deque field1125;
   @ObfuscatedName("qk")
   static short field1118;
   @ObfuscatedName("ql")
   static short field1120;
   @ObfuscatedName("qb")
   static short field1123;
   @ObfuscatedName("qz")
   static short field911;
   @ObfuscatedName("qp")
   static short field1122;
   @ObfuscatedName("qo")
   static short field1018;
   @ObfuscatedName("qi")
   static short field1104;
   @ObfuscatedName("qw")
   static short field1121;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -1199540007
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 868408529
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = 775620137
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -850286801
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 2010585181
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = -450294415
   )
   static int field1063;
   @ObfuscatedName("nw")
   static String field1085;
   @ObfuscatedName("ng")
   static long[] field1077;
   @ObfuscatedName("qa")
   static int[] field1006;
   @ObfuscatedName("qd")
   static int[] field942;
   @ObfuscatedName("qe")
   static int[] field939;
   @ObfuscatedName("qh")
   static int[] field1116;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = -1224685451
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = 53483825
   )
   static int field1087;
   @ObfuscatedName("rf")
   @ObfuscatedSignature(
      signature = "Lbw;"
   )
   static OwnWorldComparator field1134;
   @ObfuscatedName("ml")
   static int[] field1057;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -40742901
   )
   static int field1052;
   @ObfuscatedName("ne")
   static int[] field1082;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfb;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("ay")
   static boolean field1045;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -2064296299
   )
   @Export("world")
   public static int world;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -889664501
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1361512767
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bu")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("br")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1460381727
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bn")
   static String field876;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -245672033
   )
   static int field877;
   @ObfuscatedName("bq")
   static boolean field878;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 298418965
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("bt")
   static boolean field880;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -858081889
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      longValue = 7874491365707417991L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1885195203
   )
   static int field883;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 459368251
   )
   static int field1113;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -114846217
   )
   static int field885;
   @ObfuscatedName("bb")
   static boolean field886;
   @ObfuscatedName("ba")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1960122111
   )
   static int field888;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -450655845
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -236953905
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1269496963
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -838009041
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1841886051
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 70088115
   )
   @Export("hintArrowOffsetZ")
   static int hintArrowOffsetZ;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 248662451
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 143076755
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "Lci;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Lci;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -189645031
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1922660187
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 2025044507
   )
   static int field1046;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 760114903
   )
   static int field902;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1776966261
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -345135963
   )
   static int field983;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -1171839297
   )
   static int field905;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = -803981493
   )
   static int field906;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   static class158 field907;
   @ObfuscatedName("db")
   static byte[] field908;
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "[Lcv;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -1341580853
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dj")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1441129373
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ei")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   public static final NetWriter field957;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 1571140927
   )
   static int field915;
   @ObfuscatedName("el")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ex")
   static boolean field917;
   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static class294 field918;
   @ObfuscatedName("es")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -788607299
   )
   static int field920;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 506784567
   )
   static int field921;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -1547405121
   )
   static int field922;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1864044801
   )
   static int field923;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 1496574453
   )
   static int field924;
   @ObfuscatedName("fw")
   static byte[][] field1139;
   @ObfuscatedName("fn")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fo")
   @Export("instanceTemplateChunks")
   static int[][][] instanceTemplateChunks;
   @ObfuscatedName("fe")
   static final int[] field929;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -1637986591
   )
   static int field930;
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 567339711
   )
   static int field932;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -88598437
   )
   static int field933;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1079685359
   )
   static int field869;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -1803128295
   )
   static int field875;
   @ObfuscatedName("gq")
   static boolean field936;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -2109372337
   )
   static int field919;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -1460739719
   )
   @Export("cameraPitchTarget")
   static int cameraPitchTarget;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1181284281
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 556345375
   )
   static int field940;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 484624189
   )
   static int field941;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 926001113
   )
   static int field897;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1433881953
   )
   static int field943;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 74683111
   )
   static int field960;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1064118689
   )
   static int field945;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -2011028317
   )
   static int field946;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 132725631
   )
   static int field947;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 189321669
   )
   static int field948;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -180126681
   )
   static int field1059;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -1899759423
   )
   static int field950;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = 1841051693
   )
   static int field970;
   @ObfuscatedName("hd")
   static boolean field1061;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 1215154181
   )
   static int field953;
   @ObfuscatedName("hh")
   static boolean field954;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -1295918469
   )
   static int field884;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 1858361243
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -1125716121
   )
   static int field944;
   @ObfuscatedName("ht")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("hp")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("hs")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("hl")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("hc")
   static int[] field962;
   @ObfuscatedName("he")
   static int[] field963;
   @ObfuscatedName("hv")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("hy")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("hb")
   static int[][] field966;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 433251189
   )
   static int field1137;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -2016859333
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 1158186781
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 1594277511
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 1249117373
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 624945091
   )
   static int field972;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -219277759
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("iw")
   static boolean field974;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 184958147
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 1197792015
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -1387762031
   )
   static int field977;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1174515377
   )
   static int field978;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -675831127
   )
   static int field912;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = -1294238151
   )
   static int field980;
   @ObfuscatedName("iv")
   static boolean field1051;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 1926743265
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = -674130997
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("ig")
   static boolean field1097;
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "[Lbz;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 657393709
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 216071251
   )
   static int field987;
   @ObfuscatedName("io")
   static boolean field988;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 1160745695
   )
   @Export("playerNameMask")
   static int playerNameMask;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 1473777291
   )
   static int field990;
   @ObfuscatedName("jh")
   static int[] field1027;
   @ObfuscatedName("jb")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("js")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("jw")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("jm")
   static int[] field995;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = 519565977
   )
   static int field1112;
   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "[[[Lhr;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("jl")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jt")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("jp")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = -759590463
   )
   static int field1004;
   @ObfuscatedName("jd")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = 1938402333
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("ke")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("ks")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("ko")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("km")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("kd")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ka")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("kw")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("kb")
   static boolean field1014;
   @ObfuscatedName("ku")
   static boolean field981;
   @ObfuscatedName("kr")
   static boolean field1016;
   @ObfuscatedName("kx")
   static boolean field1017;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 1250195087
   )
   static int field991;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 2089976861
   )
   static int field1019;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 1103759249
   )
   static int field1115;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -568759773
   )
   static int field1021;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -1386896171
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("kk")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 642039377
   )
   static int field1025;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -1088603595
   )
   static int field893;
   @ObfuscatedName("li")
   static String field1092;
   @ObfuscatedName("lq")
   static String field1028;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -1366454627
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("la")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("lk")
   @ObfuscatedGetter(
      intValue = -1412805203
   )
   static int field1031;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -97591309
   )
   static int field1096;
   @ObfuscatedName("le")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   static Widget field1033;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -382455575
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = 493257701
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 2090815955
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 819574757
   )
   static int field1048;
   @ObfuscatedName("lm")
   static boolean field1020;
   @ObfuscatedName("lf")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   static Widget field1039;
   @ObfuscatedName("lv")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   @Export("draggedWidget")
   static Widget draggedWidget;
   @ObfuscatedName("lc")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   static Widget field937;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -629047013
   )
   static int field1042;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -905027443
   )
   static int field1114;
   @ObfuscatedName("ll")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   @Export("draggedOnWidget")
   static Widget draggedOnWidget;
   @ObfuscatedName("ld")
   static boolean field1053;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = -100852741
   )
   static int field1008;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = 1591600079
   )
   static int field1047;
   @ObfuscatedName("lp")
   static boolean field958;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -697906631
   )
   static int field1049;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 595924593
   )
   static int field882;
   @ObfuscatedName("ls")
   @Export("draggingWidget")
   static boolean draggingWidget;

   static {
      field1045 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      field877 = -1;
      field878 = false;
      gameState = 0;
      field880 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = 1L;
      field883 = -1;
      field1113 = -1;
      field885 = -1;
      field886 = true;
      displayFps = false;
      field888 = 0;
      hintArrowTargetType = 0;
      hintArrowNpcTargetIdx = 0;
      hintArrowPlayerTargetIdx = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowOffsetZ = 0;
      hintArrowOffsetX = 0;
      hintArrowOffsetY = 0;
      playerAttackOption = AttackOption.AttackOption_hidden;
      npcAttackOption = AttackOption.AttackOption_hidden;
      loadingStage = 0;
      js5State = 0;
      field1046 = 0;
      field902 = 0;
      loginState = 0;
      field983 = 0;
      field905 = 0;
      field906 = 0;
      field907 = class158.field2172;
      field908 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field957 = new NetWriter();
      field915 = 0;
      socketError = false;
      field917 = true;
      field918 = new class294();
      fontsMap = new HashMap();
      field920 = 0;
      field921 = 1;
      field922 = 0;
      field923 = 1;
      field924 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      instanceTemplateChunks = new int[4][13][13];
      field929 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field930 = 0;
      field932 = 2301979;
      field933 = 5063219;
      field869 = 3353893;
      field875 = 7759444;
      field936 = false;
      field919 = 0;
      cameraPitchTarget = 128;
      mapAngle = 0;
      field940 = 0;
      field941 = 0;
      field897 = 0;
      field943 = 0;
      field960 = 0;
      field945 = 50;
      field946 = 0;
      field947 = 0;
      field948 = 0;
      field1059 = 12;
      field950 = 6;
      field970 = 0;
      field1061 = false;
      field953 = 0;
      field954 = false;
      field884 = 0;
      overheadTextCount = 0;
      field944 = 50;
      overheadTextsX = new int[field944];
      overheadTextsY = new int[field944];
      overheadTextsOffsetY = new int[field944];
      overheadTextsOffsetX = new int[field944];
      field962 = new int[field944];
      field963 = new int[field944];
      overheadTextsCyclesRemaining = new int[field944];
      overheadTexts = new String[field944];
      field966 = new int[104][104];
      field1137 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field972 = 0;
      cursorState = 0;
      field974 = true;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field977 = 0;
      field978 = 0;
      field912 = 0;
      field980 = 0;
      field1051 = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      field1097 = true;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field987 = 0;
      field988 = true;
      playerNameMask = 0;
      field990 = 0;
      field1027 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field995 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1112 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1004 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field1014 = false;
      field981 = false;
      field1016 = false;
      field1017 = true;
      field991 = -1;
      field1019 = -1;
      field1115 = 0;
      field1021 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field1025 = -1;
      field893 = -1;
      field1092 = null;
      field1028 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1031 = 0;
      field1096 = 0;
      field1033 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1048 = -1;
      field1020 = false;
      field1039 = null;
      draggedWidget = null;
      field937 = null;
      field1042 = 0;
      field1114 = 0;
      draggedOnWidget = null;
      field1053 = false;
      field1008 = -1;
      field1047 = -1;
      field958 = false;
      field1049 = -1;
      field882 = -1;
      draggingWidget = false;
      cycleCntr = 1;
      field984 = new int[32];
      field1054 = 0;
      interfaceItemTriggers = new int[32];
      field1056 = 0;
      field1057 = new int[32];
      field1052 = 0;
      chatCycle = 0;
      field1060 = 0;
      field967 = 0;
      field1062 = 0;
      field1063 = 0;
      field1064 = 0;
      mouseWheelRotation = 0;
      field1066 = new Deque();
      field1067 = new Deque();
      field1125 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field1071 = -2;
      field1072 = new boolean[100];
      field1073 = new boolean[100];
      field1074 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1080 = 0L;
      isResized = true;
      field1082 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field1084 = 0;
      field1085 = "";
      field1077 = new long[100];
      field1087 = 0;
      field952 = 0;
      field1089 = new int[128];
      field968 = new int[128];
      field1091 = -1L;
      field881 = -1;
      field1093 = 0;
      field1094 = new int[1000];
      field1095 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1099 = 0;
      field996 = 255;
      field1026 = -1;
      field1102 = false;
      field1075 = 127;
      field951 = 127;
      queuedSoundEffectCount = 0;
      queuedSoundEffectIDs = new int[50];
      unknownSoundValues1 = new int[50];
      unknownSoundValues2 = new int[50];
      soundLocations = new int[50];
      audioEffects = new SoundEffect[50];
      field1111 = false;
      field955 = new boolean[5];
      field942 = new int[5];
      field1006 = new int[5];
      field939 = new int[5];
      field1116 = new int[5];
      field1120 = 256;
      field1118 = 205;
      field1018 = 256;
      field1104 = 320;
      field1121 = 1;
      field1122 = 32767;
      field1123 = 1;
      field911 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      scale = 0;
      field1132 = new PlayerComposition();
      field1044 = -1;
      field1138 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1134 = new OwnWorldComparator();
      field1135 = -1;
      field871 = new ArrayList(10);
      field935 = 0;
      field901 = new class71();
      field1034 = new int[50];
      field1131 = new int[50];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "318028838"
   )
   protected final void vmethod1262() {
      field1080 = class64.method1118() + 500L;
      this.method1263();
      if(widgetRoot != -1) {
         this.method1345(true);
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   @Export("setUp")
   protected final void setUp() {
      Renderable.method3051(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      class228.port1 = socketType == 0?43594:world + 40000;
      class243.port2 = socketType == 0?443:world + 50000;
      class138.myWorldPort = class228.port1;
      PlayerComposition.colorsToFind = class240.field2805;
      PlayerComposition.colorsToReplace = class240.field2800;
      BoundingBox2D.field246 = class240.field2801;
      UrlRequest.field2135 = class240.field2802;
      MapIconReference.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      class90.mouseWheel = this.mouseWheel();
      class19.indexStore255 = new IndexFile(255, class167.dat2File, class167.idx255File, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = NPC.getPreferencesFile("", class265.field3435.name, false);
         byte[] var4 = new byte[(int)var2.length()];

         int var6;
         for(int var5 = 0; var5 < var4.length; var5 += var6) {
            var6 = var2.read(var4, var5, var4.length - var5);
            if(var6 == -1) {
               throw new IOException();
            }
         }

         var3 = new Preferences(new Buffer(var4));
      } catch (Exception var8) {
         ;
      }

      try {
         if(var2 != null) {
            var2.close();
         }
      } catch (Exception var7) {
         ;
      }

      preferences = var3;
      this.setUpClipboard();
      GrandExchangeEvents.method76(this, WorldMapType2.field515);
      if(socketType != 0) {
         displayFps = true;
      }

      GameCanvas.method832(preferences.screenType);
      WorldMapRectangle.friendManager = new FriendManager(GZipDecompressor.loginType);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
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
            int var50;
            try {
               if(class229.field2687 == 1) {
                  var50 = class229.field2690.method4250();
                  if(var50 > 0 && class229.field2690.method4151()) {
                     var50 -= class2.field11;
                     if(var50 < 0) {
                        var50 = 0;
                     }

                     class229.field2690.method4134(var50);
                  } else {
                     class229.field2690.method4140();
                     class229.field2690.method4141();
                     if(class185.field2511 != null) {
                        class229.field2687 = 2;
                     } else {
                        class229.field2687 = 0;
                     }

                     GraphicsObject.field1300 = null;
                     SceneTilePaint.field1965 = null;
                  }
               }
            } catch (Exception var68) {
               var68.printStackTrace();
               class229.field2690.method4140();
               class229.field2687 = 0;
               GraphicsObject.field1300 = null;
               SceneTilePaint.field1965 = null;
               class185.field2511 = null;
            }

            BoundingBox2D.method36();
            DecorativeObject.method3081();
            MouseInput var69 = MouseInput.mouse;
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

            if(class90.mouseWheel != null) {
               var50 = class90.mouseWheel.useRotation();
               mouseWheelRotation = var50;
            }

            if(gameState == 0) {
               MilliTimer.load();
               UrlRequester.timer.vmethod3326();

               for(var50 = 0; var50 < 32; ++var50) {
                  GameEngine.field688[var50] = 0L;
               }

               for(var50 = 0; var50 < 32; ++var50) {
                  GameEngine.field709[var50] = 0L;
               }

               GameEngine.field684 = 0;
            } else if(gameState == 5) {
               class171.method3299(this);
               MilliTimer.load();
               UrlRequester.timer.vmethod3326();

               for(var50 = 0; var50 < 32; ++var50) {
                  GameEngine.field688[var50] = 0L;
               }

               for(var50 = 0; var50 < 32; ++var50) {
                  GameEngine.field709[var50] = 0L;
               }

               GameEngine.field684 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class171.method3299(this);
                  this.method1260();
               } else if(gameState == 25) {
                  class55.flush(false);
                  field920 = 0;
                  boolean var80 = true;

                  int var51;
                  for(var51 = 0; var51 < Varbit.field3544.length; ++var51) {
                     if(ItemContainer.landMapFileIds[var51] != -1 && Varbit.field3544[var51] == null) {
                        Varbit.field3544[var51] = MouseRecorder.indexMaps.getConfigData(ItemContainer.landMapFileIds[var51], 0);
                        if(Varbit.field3544[var51] == null) {
                           var80 = false;
                           ++field920;
                        }
                     }

                     if(FontName.landRegionFileIds[var51] != -1 && field1139[var51] == null) {
                        field1139[var51] = MouseRecorder.indexMaps.getConfigDataKeys(FontName.landRegionFileIds[var51], 0, class152.xteaKeys[var51]);
                        if(field1139[var51] == null) {
                           var80 = false;
                           ++field920;
                        }
                     }
                  }

                  if(!var80) {
                     field924 = 1;
                  } else {
                     field922 = 0;
                     var80 = true;

                     int var5;
                     int var10;
                     int var11;
                     int var12;
                     int var14;
                     int var15;
                     int var16;
                     int var17;
                     int var18;
                     int var19;
                     int var52;
                     for(var51 = 0; var51 < Varbit.field3544.length; ++var51) {
                        byte[] var3 = field1139[var51];
                        if(var3 != null) {
                           var52 = (class298.mapRegions[var51] >> 8) * 64 - class138.baseX;
                           var5 = (class298.mapRegions[var51] & 255) * 64 - class23.baseY;
                           if(isDynamicRegion) {
                              var52 = 10;
                              var5 = 10;
                           }

                           boolean var8 = true;
                           Buffer var9 = new Buffer(var3);
                           var10 = -1;

                           label1485:
                           while(true) {
                              var11 = var9.getUSmart();
                              if(var11 == 0) {
                                 var80 &= var8;
                                 break;
                              }

                              var10 += var11;
                              var12 = 0;
                              boolean var13 = false;

                              while(true) {
                                 while(!var13) {
                                    var14 = var9.getUSmart();
                                    if(var14 == 0) {
                                       continue label1485;
                                    }

                                    var12 += var14 - 1;
                                    var15 = var12 & 63;
                                    var16 = var12 >> 6 & 63;
                                    var17 = var9.readUnsignedByte() >> 2;
                                    var18 = var16 + var52;
                                    var19 = var15 + var5;
                                    if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                       ObjectComposition var20 = GameCanvas.getObjectDefinition(var10);
                                       if(var17 != 22 || !lowMemory || var20.int1 != 0 || var20.clipType == 1 || var20.obstructsGround) {
                                          if(!var20.method5027()) {
                                             ++field922;
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

                     if(!var80) {
                        field924 = 2;
                     } else {
                        if(field924 != 0) {
                           CombatInfo1.method1681("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        BoundingBox2D.method36();
                        class255.region.reset();

                        for(var51 = 0; var51 < 4; ++var51) {
                           collisionMaps[var51].reset();
                        }

                        int var53;
                        for(var51 = 0; var51 < 4; ++var51) {
                           for(var53 = 0; var53 < 104; ++var53) {
                              for(var52 = 0; var52 < 104; ++var52) {
                                 class62.tileSettings[var51][var53][var52] = 0;
                              }
                           }
                        }

                        BoundingBox2D.method36();
                        class62.field747 = 99;
                        class62.tileUnderlayIds = new byte[4][104][104];
                        class62.tileOverlayIds = new byte[4][104][104];
                        class62.tileOverlayPath = new byte[4][104][104];
                        class62.overlayRotations = new byte[4][104][104];
                        GZipDecompressor.field2520 = new int[4][105][105];
                        class297.field3831 = new byte[4][105][105];
                        AttackOption.field1354 = new int[105][105];
                        class55.floorHues = new int[104];
                        class183.floorSaturations = new int[104];
                        class253.field3314 = new int[104];
                        class36.floorMultiplier = new int[104];
                        AttackOption.field1356 = new int[104];
                        var51 = Varbit.field3544.length;
                        class61.method1071();
                        class55.flush(true);
                        int var6;
                        int var7;
                        int var73;
                        int var75;
                        if(!isDynamicRegion) {
                           var53 = 0;

                           label1423:
                           while(true) {
                              byte[] var54;
                              if(var53 >= var51) {
                                 for(var53 = 0; var53 < var51; ++var53) {
                                    var52 = (class298.mapRegions[var53] >> 8) * 64 - class138.baseX;
                                    var5 = (class298.mapRegions[var53] & 255) * 64 - class23.baseY;
                                    var54 = Varbit.field3544[var53];
                                    if(var54 == null && GrandExchangeEvent.field301 < 800) {
                                       BoundingBox2D.method36();
                                       BoundingBox3DDrawMode.method54(var52, var5, 64, 64);
                                    }
                                 }

                                 class55.flush(true);
                                 var53 = 0;

                                 while(true) {
                                    if(var53 >= var51) {
                                       break label1423;
                                    }

                                    byte[] var4 = field1139[var53];
                                    if(var4 != null) {
                                       var5 = (class298.mapRegions[var53] >> 8) * 64 - class138.baseX;
                                       var6 = (class298.mapRegions[var53] & 255) * 64 - class23.baseY;
                                       BoundingBox2D.method36();
                                       GrandExchangeEvent.method85(var4, var5, var6, class255.region, collisionMaps);
                                    }

                                    ++var53;
                                 }
                              }

                              var52 = (class298.mapRegions[var53] >> 8) * 64 - class138.baseX;
                              var5 = (class298.mapRegions[var53] & 255) * 64 - class23.baseY;
                              var54 = Varbit.field3544[var53];
                              if(var54 != null) {
                                 BoundingBox2D.method36();
                                 var7 = ScriptState.field761 * 8 - 48;
                                 var73 = GrandExchangeEvent.field301 * 8 - 48;
                                 CollisionData[] var74 = collisionMaps;
                                 var10 = 0;

                                 label1420:
                                 while(true) {
                                    if(var10 >= 4) {
                                       Buffer var55 = new Buffer(var54);
                                       var11 = 0;

                                       while(true) {
                                          if(var11 >= 4) {
                                             break label1420;
                                          }

                                          for(var12 = 0; var12 < 64; ++var12) {
                                             for(var75 = 0; var75 < 64; ++var75) {
                                                class229.loadTerrain(var55, var11, var12 + var52, var75 + var5, var7, var73, 0);
                                             }
                                          }

                                          ++var11;
                                       }
                                    }

                                    for(var11 = 0; var11 < 64; ++var11) {
                                       for(var12 = 0; var12 < 64; ++var12) {
                                          if(var11 + var52 > 0 && var52 + var11 < 103 && var5 + var12 > 0 && var5 + var12 < 103) {
                                             var74[var10].flags[var52 + var11][var12 + var5] &= -16777217;
                                          }
                                       }
                                    }

                                    ++var10;
                                 }
                              }

                              ++var53;
                           }
                        }

                        int var21;
                        int var22;
                        int var23;
                        int var25;
                        int var26;
                        int var27;
                        int var28;
                        int var29;
                        int var30;
                        int var33;
                        int var34;
                        int var35;
                        int var36;
                        int var37;
                        int var39;
                        int var41;
                        int var42;
                        int var43;
                        int var44;
                        int var56;
                        int var59;
                        int var62;
                        if(isDynamicRegion) {
                           var53 = 0;

                           label1369:
                           while(true) {
                              CollisionData[] var58;
                              Buffer var76;
                              if(var53 >= 4) {
                                 for(var53 = 0; var53 < 13; ++var53) {
                                    for(var52 = 0; var52 < 13; ++var52) {
                                       var5 = instanceTemplateChunks[0][var53][var52];
                                       if(var5 == -1) {
                                          BoundingBox3DDrawMode.method54(var53 * 8, var52 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 class55.flush(true);
                                 var53 = 0;

                                 while(true) {
                                    if(var53 >= 4) {
                                       break label1369;
                                    }

                                    BoundingBox2D.method36();

                                    for(var52 = 0; var52 < 13; ++var52) {
                                       label1292:
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var6 = instanceTemplateChunks[var53][var52][var5];
                                          if(var6 != -1) {
                                             var7 = var6 >> 24 & 3;
                                             var73 = var6 >> 1 & 3;
                                             var56 = var6 >> 14 & 1023;
                                             var10 = var6 >> 3 & 2047;
                                             var11 = (var56 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < class298.mapRegions.length; ++var12) {
                                                if(class298.mapRegions[var12] == var11 && field1139[var12] != null) {
                                                   byte[] var60 = field1139[var12];
                                                   var14 = var52 * 8;
                                                   var15 = var5 * 8;
                                                   var16 = (var56 & 7) * 8;
                                                   var17 = (var10 & 7) * 8;
                                                   Region var61 = class255.region;
                                                   var58 = collisionMaps;
                                                   var76 = new Buffer(var60);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var76.getUSmart();
                                                      if(var22 == 0) {
                                                         continue label1292;
                                                      }

                                                      var21 += var22;
                                                      var23 = 0;

                                                      while(true) {
                                                         var62 = var76.getUSmart();
                                                         if(var62 == 0) {
                                                            break;
                                                         }

                                                         var23 += var62 - 1;
                                                         var25 = var23 & 63;
                                                         var26 = var23 >> 6 & 63;
                                                         var27 = var23 >> 12;
                                                         var28 = var76.readUnsignedByte();
                                                         var29 = var28 >> 2;
                                                         var30 = var28 & 3;
                                                         if(var7 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                            ObjectComposition var31 = GameCanvas.getObjectDefinition(var21);
                                                            var34 = var26 & 7;
                                                            var35 = var25 & 7;
                                                            var37 = var31.width;
                                                            int var38 = var31.length;
                                                            if((var30 & 1) == 1) {
                                                               var39 = var37;
                                                               var37 = var38;
                                                               var38 = var39;
                                                            }

                                                            var36 = var73 & 3;
                                                            if(var36 == 0) {
                                                               var33 = var34;
                                                            } else if(var36 == 1) {
                                                               var33 = var35;
                                                            } else if(var36 == 2) {
                                                               var33 = 7 - var34 - (var37 - 1);
                                                            } else {
                                                               var33 = 7 - var35 - (var38 - 1);
                                                            }

                                                            var39 = var14 + var33;
                                                            var42 = var26 & 7;
                                                            var43 = var25 & 7;
                                                            int var45 = var31.width;
                                                            int var46 = var31.length;
                                                            int var47;
                                                            if((var30 & 1) == 1) {
                                                               var47 = var45;
                                                               var45 = var46;
                                                               var46 = var47;
                                                            }

                                                            var44 = var73 & 3;
                                                            if(var44 == 0) {
                                                               var41 = var43;
                                                            } else if(var44 == 1) {
                                                               var41 = 7 - var42 - (var45 - 1);
                                                            } else if(var44 == 2) {
                                                               var41 = 7 - var43 - (var46 - 1);
                                                            } else {
                                                               var41 = var42;
                                                            }

                                                            var47 = var15 + var41;
                                                            if(var39 > 0 && var47 > 0 && var39 < 103 && var47 < 103) {
                                                               int var48 = var53;
                                                               if((class62.tileSettings[1][var39][var47] & 2) == 2) {
                                                                  var48 = var53 - 1;
                                                               }

                                                               CollisionData var49 = null;
                                                               if(var48 >= 0) {
                                                                  var49 = var58[var48];
                                                               }

                                                               class44.addObject(var53, var39, var47, var21, var30 + var73 & 3, var29, var61, var49);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var53;
                                 }
                              }

                              BoundingBox2D.method36();

                              for(var52 = 0; var52 < 13; ++var52) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var72 = false;
                                    var7 = instanceTemplateChunks[var53][var52][var5];
                                    if(var7 != -1) {
                                       var73 = var7 >> 24 & 3;
                                       var56 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var75 = 0; var75 < class298.mapRegions.length; ++var75) {
                                          if(class298.mapRegions[var75] == var12 && Varbit.field3544[var75] != null) {
                                             byte[] var57 = Varbit.field3544[var75];
                                             var15 = var52 * 8;
                                             var16 = var5 * 8;
                                             var17 = (var10 & 7) * 8;
                                             var18 = (var11 & 7) * 8;
                                             var58 = collisionMaps;

                                             for(var59 = 0; var59 < 8; ++var59) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var59 + var15 > 0 && var15 + var59 < 103 && var21 + var16 > 0 && var16 + var21 < 103) {
                                                      var58[var53].flags[var15 + var59][var21 + var16] &= -16777217;
                                                   }
                                                }
                                             }

                                             var76 = new Buffer(var57);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(var23 = 0; var23 < 64; ++var23) {
                                                      if(var73 == var21 && var22 >= var17 && var22 < var17 + 8 && var23 >= var18 && var23 < var18 + 8) {
                                                         var28 = var22 & 7;
                                                         var29 = var23 & 7;
                                                         var30 = var56 & 3;
                                                         if(var30 == 0) {
                                                            var27 = var28;
                                                         } else if(var30 == 1) {
                                                            var27 = var29;
                                                         } else if(var30 == 2) {
                                                            var27 = 7 - var28;
                                                         } else {
                                                            var27 = 7 - var29;
                                                         }

                                                         class229.loadTerrain(var76, var53, var15 + var27, var16 + class154.method3157(var22 & 7, var23 & 7, var56), 0, 0, var56);
                                                      } else {
                                                         class229.loadTerrain(var76, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var72 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var72) {
                                       class138.method3049(var53, var52 * 8, var5 * 8);
                                    }
                                 }
                              }

                              ++var53;
                           }
                        }

                        class55.flush(true);
                        BoundingBox2D.method36();
                        Region var70 = class255.region;
                        CollisionData[] var71 = collisionMaps;

                        for(var5 = 0; var5 < 4; ++var5) {
                           for(var6 = 0; var6 < 104; ++var6) {
                              for(var7 = 0; var7 < 104; ++var7) {
                                 if((class62.tileSettings[var5][var6][var7] & 1) == 1) {
                                    var73 = var5;
                                    if((class62.tileSettings[1][var6][var7] & 2) == 2) {
                                       var73 = var5 - 1;
                                    }

                                    if(var73 >= 0) {
                                       var71[var73].method3384(var6, var7);
                                    }
                                 }
                              }
                           }
                        }

                        class62.field751 += (int)(Math.random() * 5.0D) - 2;
                        if(class62.field751 < -8) {
                           class62.field751 = -8;
                        }

                        if(class62.field751 > 8) {
                           class62.field751 = 8;
                        }

                        class62.field745 += (int)(Math.random() * 5.0D) - 2;
                        if(class62.field745 < -16) {
                           class62.field745 = -16;
                        }

                        if(class62.field745 > 16) {
                           class62.field745 = 16;
                        }

                        for(var5 = 0; var5 < 4; ++var5) {
                           byte[][] var81 = class297.field3831[var5];
                           var12 = (int)Math.sqrt(5100.0D);
                           var75 = var12 * 768 >> 8;

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 var16 = class62.tileHeights[var5][var15 + 1][var14] - class62.tileHeights[var5][var15 - 1][var14];
                                 var17 = class62.tileHeights[var5][var15][var14 + 1] - class62.tileHeights[var5][var15][var14 - 1];
                                 var18 = (int)Math.sqrt((double)(var16 * var16 + var17 * var17 + 65536));
                                 var19 = (var16 << 8) / var18;
                                 var59 = 65536 / var18;
                                 var21 = (var17 << 8) / var18;
                                 var22 = (var21 * -50 + var19 * -50 + var59 * -10) / var75 + 96;
                                 var23 = (var81[var15 - 1][var14] >> 2) + (var81[var15][var14 - 1] >> 2) + (var81[var15 + 1][var14] >> 3) + (var81[var15][var14 + 1] >> 3) + (var81[var15][var14] >> 1);
                                 AttackOption.field1354[var15][var14] = var22 - var23;
                              }
                           }

                           for(var14 = 0; var14 < 104; ++var14) {
                              class55.floorHues[var14] = 0;
                              class183.floorSaturations[var14] = 0;
                              class253.field3314[var14] = 0;
                              class36.floorMultiplier[var14] = 0;
                              AttackOption.field1356[var14] = 0;
                           }

                           for(var14 = -5; var14 < 109; ++var14) {
                              for(var15 = 0; var15 < 104; ++var15) {
                                 var16 = var14 + 5;
                                 if(var16 >= 0 && var16 < 104) {
                                    var17 = class62.tileUnderlayIds[var5][var16][var15] & 255;
                                    if(var17 > 0) {
                                       FloorUnderlayDefinition var85 = Tile.getUnderlayDefinition(var17 - 1);
                                       class55.floorHues[var15] += var85.hue;
                                       class183.floorSaturations[var15] += var85.saturation;
                                       class253.field3314[var15] += var85.lightness;
                                       class36.floorMultiplier[var15] += var85.hueMultiplier;
                                       ++AttackOption.field1356[var15];
                                    }
                                 }

                                 var17 = var14 - 5;
                                 if(var17 >= 0 && var17 < 104) {
                                    var18 = class62.tileUnderlayIds[var5][var17][var15] & 255;
                                    if(var18 > 0) {
                                       FloorUnderlayDefinition var84 = Tile.getUnderlayDefinition(var18 - 1);
                                       class55.floorHues[var15] -= var84.hue;
                                       class183.floorSaturations[var15] -= var84.saturation;
                                       class253.field3314[var15] -= var84.lightness;
                                       class36.floorMultiplier[var15] -= var84.hueMultiplier;
                                       --AttackOption.field1356[var15];
                                    }
                                 }
                              }

                              if(var14 >= 1 && var14 < 103) {
                                 var15 = 0;
                                 var16 = 0;
                                 var17 = 0;
                                 var18 = 0;
                                 var19 = 0;

                                 for(var59 = -5; var59 < 109; ++var59) {
                                    var21 = var59 + 5;
                                    if(var21 >= 0 && var21 < 104) {
                                       var15 += class55.floorHues[var21];
                                       var16 += class183.floorSaturations[var21];
                                       var17 += class253.field3314[var21];
                                       var18 += class36.floorMultiplier[var21];
                                       var19 += AttackOption.field1356[var21];
                                    }

                                    var22 = var59 - 5;
                                    if(var22 >= 0 && var22 < 104) {
                                       var15 -= class55.floorHues[var22];
                                       var16 -= class183.floorSaturations[var22];
                                       var17 -= class253.field3314[var22];
                                       var18 -= class36.floorMultiplier[var22];
                                       var19 -= AttackOption.field1356[var22];
                                    }

                                    if(var59 >= 1 && var59 < 103 && (!lowMemory || (class62.tileSettings[0][var14][var59] & 2) != 0 || (class62.tileSettings[var5][var14][var59] & 16) == 0)) {
                                       if(var5 < class62.field747) {
                                          class62.field747 = var5;
                                       }

                                       var23 = class62.tileUnderlayIds[var5][var14][var59] & 255;
                                       var62 = class62.tileOverlayIds[var5][var14][var59] & 255;
                                       if(var23 > 0 || var62 > 0) {
                                          var25 = class62.tileHeights[var5][var14][var59];
                                          var26 = class62.tileHeights[var5][var14 + 1][var59];
                                          var27 = class62.tileHeights[var5][var14 + 1][var59 + 1];
                                          var28 = class62.tileHeights[var5][var14][var59 + 1];
                                          var29 = AttackOption.field1354[var14][var59];
                                          var30 = AttackOption.field1354[var14 + 1][var59];
                                          int var63 = AttackOption.field1354[var14 + 1][var59 + 1];
                                          int var32 = AttackOption.field1354[var14][var59 + 1];
                                          var33 = -1;
                                          var34 = -1;
                                          if(var23 > 0) {
                                             var35 = var15 * 256 / var18;
                                             var36 = var16 / var19;
                                             var37 = var17 / var19;
                                             var33 = class246.method4490(var35, var36, var37);
                                             var35 = var35 + class62.field751 & 255;
                                             var37 += class62.field745;
                                             if(var37 < 0) {
                                                var37 = 0;
                                             } else if(var37 > 255) {
                                                var37 = 255;
                                             }

                                             var34 = class246.method4490(var35, var36, var37);
                                          }

                                          if(var5 > 0) {
                                             boolean var78 = true;
                                             if(var23 == 0 && class62.tileOverlayPath[var5][var14][var59] != 0) {
                                                var78 = false;
                                             }

                                             if(var62 > 0 && !class95.getOverlayDefinition(var62 - 1).isHidden) {
                                                var78 = false;
                                             }

                                             if(var78 && var26 == var25 && var27 == var25 && var28 == var25) {
                                                GZipDecompressor.field2520[var5][var14][var59] |= 2340;
                                             }
                                          }

                                          var35 = 0;
                                          if(var34 != -1) {
                                             var35 = Graphics3D.colorPalette[Renderable.method3058(var34, 96)];
                                          }

                                          if(var62 == 0) {
                                             var70.addTile(var5, var14, var59, 0, 0, -1, var25, var26, var27, var28, Renderable.method3058(var33, var29), Renderable.method3058(var33, var30), Renderable.method3058(var33, var63), Renderable.method3058(var33, var32), 0, 0, 0, 0, var35, 0);
                                          } else {
                                             var36 = class62.tileOverlayPath[var5][var14][var59] + 1;
                                             byte var79 = class62.overlayRotations[var5][var14][var59];
                                             Overlay var64 = class95.getOverlayDefinition(var62 - 1);
                                             var39 = var64.texture;
                                             int var40;
                                             if(var39 >= 0) {
                                                var41 = Graphics3D.textureLoader.getAverageTextureRGB(var39);
                                                var40 = -1;
                                             } else if(var64.color == 16711935) {
                                                var40 = -2;
                                                var39 = -1;
                                                var41 = -2;
                                             } else {
                                                var40 = class246.method4490(var64.hue, var64.saturation, var64.lightness);
                                                var42 = var64.hue + class62.field751 & 255;
                                                var43 = var64.lightness + class62.field745;
                                                if(var43 < 0) {
                                                   var43 = 0;
                                                } else if(var43 > 255) {
                                                   var43 = 255;
                                                }

                                                var41 = class246.method4490(var42, var64.saturation, var43);
                                             }

                                             var42 = 0;
                                             if(var41 != -2) {
                                                var42 = Graphics3D.colorPalette[GameEngine.adjustHSLListness0(var41, 96)];
                                             }

                                             if(var64.otherRgbColor != -1) {
                                                var43 = var64.otherHue + class62.field751 & 255;
                                                var44 = var64.otherLightness + class62.field745;
                                                if(var44 < 0) {
                                                   var44 = 0;
                                                } else if(var44 > 255) {
                                                   var44 = 255;
                                                }

                                                var41 = class246.method4490(var43, var64.otherSaturation, var44);
                                                var42 = Graphics3D.colorPalette[GameEngine.adjustHSLListness0(var41, 96)];
                                             }

                                             var70.addTile(var5, var14, var59, var36, var79, var39, var25, var26, var27, var28, Renderable.method3058(var33, var29), Renderable.method3058(var33, var30), Renderable.method3058(var33, var63), Renderable.method3058(var33, var32), GameEngine.adjustHSLListness0(var40, var29), GameEngine.adjustHSLListness0(var40, var30), GameEngine.adjustHSLListness0(var40, var63), GameEngine.adjustHSLListness0(var40, var32), var35, var42);
                                          }
                                       }
                                    }
                                 }
                              }
                           }

                           for(var14 = 1; var14 < 103; ++var14) {
                              for(var15 = 1; var15 < 103; ++var15) {
                                 if((class62.tileSettings[var5][var15][var14] & 8) != 0) {
                                    var59 = 0;
                                 } else if(var5 > 0 && (class62.tileSettings[1][var15][var14] & 2) != 0) {
                                    var59 = var5 - 1;
                                 } else {
                                    var59 = var5;
                                 }

                                 var70.setPhysicalLevel(var5, var15, var14, var59);
                              }
                           }

                           class62.tileUnderlayIds[var5] = null;
                           class62.tileOverlayIds[var5] = null;
                           class62.tileOverlayPath[var5] = null;
                           class62.overlayRotations[var5] = null;
                           class297.field3831[var5] = null;
                        }

                        var70.applyLighting(-50, -10, -50);

                        for(var5 = 0; var5 < 104; ++var5) {
                           for(var6 = 0; var6 < 104; ++var6) {
                              if((class62.tileSettings[1][var5][var6] & 2) == 2) {
                                 var70.setBridge(var5, var6);
                              }
                           }
                        }

                        var5 = 1;
                        var6 = 2;
                        var7 = 4;

                        for(var73 = 0; var73 < 4; ++var73) {
                           if(var73 > 0) {
                              var5 <<= 3;
                              var6 <<= 3;
                              var7 <<= 3;
                           }

                           for(var56 = 0; var56 <= var73; ++var56) {
                              for(var10 = 0; var10 <= 104; ++var10) {
                                 for(var11 = 0; var11 <= 104; ++var11) {
                                    short var77;
                                    if((GZipDecompressor.field2520[var56][var11][var10] & var5) != 0) {
                                       var12 = var10;
                                       var75 = var10;
                                       var14 = var56;

                                       for(var15 = var56; var12 > 0 && (GZipDecompressor.field2520[var56][var11][var12 - 1] & var5) != 0; --var12) {
                                          ;
                                       }

                                       while(var75 < 104 && (GZipDecompressor.field2520[var56][var11][var75 + 1] & var5) != 0) {
                                          ++var75;
                                       }

                                       label1011:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var75; ++var16) {
                                             if((GZipDecompressor.field2520[var14 - 1][var11][var16] & var5) == 0) {
                                                break label1011;
                                             }
                                          }

                                          --var14;
                                       }

                                       label1000:
                                       while(var15 < var73) {
                                          for(var16 = var12; var16 <= var75; ++var16) {
                                             if((GZipDecompressor.field2520[var15 + 1][var11][var16] & var5) == 0) {
                                                break label1000;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var15 + 1 - var14) * (var75 - var12 + 1);
                                       if(var16 >= 8) {
                                          var77 = 240;
                                          var18 = class62.tileHeights[var15][var11][var12] - var77;
                                          var19 = class62.tileHeights[var14][var11][var12];
                                          Region.addOcclude(var73, 1, var11 * 128, var11 * 128, var12 * 128, var75 * 128 + 128, var18, var19);

                                          for(var59 = var14; var59 <= var15; ++var59) {
                                             for(var21 = var12; var21 <= var75; ++var21) {
                                                GZipDecompressor.field2520[var59][var11][var21] &= ~var5;
                                             }
                                          }
                                       }
                                    }

                                    if((GZipDecompressor.field2520[var56][var11][var10] & var6) != 0) {
                                       var12 = var11;
                                       var75 = var11;
                                       var14 = var56;

                                       for(var15 = var56; var12 > 0 && (GZipDecompressor.field2520[var56][var12 - 1][var10] & var6) != 0; --var12) {
                                          ;
                                       }

                                       while(var75 < 104 && (GZipDecompressor.field2520[var56][var75 + 1][var10] & var6) != 0) {
                                          ++var75;
                                       }

                                       label1064:
                                       while(var14 > 0) {
                                          for(var16 = var12; var16 <= var75; ++var16) {
                                             if((GZipDecompressor.field2520[var14 - 1][var16][var10] & var6) == 0) {
                                                break label1064;
                                             }
                                          }

                                          --var14;
                                       }

                                       label1053:
                                       while(var15 < var73) {
                                          for(var16 = var12; var16 <= var75; ++var16) {
                                             if((GZipDecompressor.field2520[var15 + 1][var16][var10] & var6) == 0) {
                                                break label1053;
                                             }
                                          }

                                          ++var15;
                                       }

                                       var16 = (var75 - var12 + 1) * (var15 + 1 - var14);
                                       if(var16 >= 8) {
                                          var77 = 240;
                                          var18 = class62.tileHeights[var15][var12][var10] - var77;
                                          var19 = class62.tileHeights[var14][var12][var10];
                                          Region.addOcclude(var73, 2, var12 * 128, var75 * 128 + 128, var10 * 128, var10 * 128, var18, var19);

                                          for(var59 = var14; var59 <= var15; ++var59) {
                                             for(var21 = var12; var21 <= var75; ++var21) {
                                                GZipDecompressor.field2520[var59][var21][var10] &= ~var6;
                                             }
                                          }
                                       }
                                    }

                                    if((GZipDecompressor.field2520[var56][var11][var10] & var7) != 0) {
                                       var12 = var11;
                                       var75 = var11;
                                       var14 = var10;

                                       for(var15 = var10; var14 > 0 && (GZipDecompressor.field2520[var56][var11][var14 - 1] & var7) != 0; --var14) {
                                          ;
                                       }

                                       while(var15 < 104 && (GZipDecompressor.field2520[var56][var11][var15 + 1] & var7) != 0) {
                                          ++var15;
                                       }

                                       label1117:
                                       while(var12 > 0) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if((GZipDecompressor.field2520[var56][var12 - 1][var16] & var7) == 0) {
                                                break label1117;
                                             }
                                          }

                                          --var12;
                                       }

                                       label1106:
                                       while(var75 < 104) {
                                          for(var16 = var14; var16 <= var15; ++var16) {
                                             if((GZipDecompressor.field2520[var56][var75 + 1][var16] & var7) == 0) {
                                                break label1106;
                                             }
                                          }

                                          ++var75;
                                       }

                                       if((var75 - var12 + 1) * (var15 - var14 + 1) >= 4) {
                                          var16 = class62.tileHeights[var56][var12][var14];
                                          Region.addOcclude(var73, 4, var12 * 128, var75 * 128 + 128, var14 * 128, var15 * 128 + 128, var16, var16);

                                          for(var17 = var12; var17 <= var75; ++var17) {
                                             for(var18 = var14; var18 <= var15; ++var18) {
                                                GZipDecompressor.field2520[var56][var17][var18] &= ~var7;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        class55.flush(true);
                        var5 = class62.field747;
                        if(var5 > BoundingBox3DDrawMode.plane) {
                           var5 = BoundingBox3DDrawMode.plane;
                        }

                        if(var5 < BoundingBox3DDrawMode.plane - 1) {
                           var5 = BoundingBox3DDrawMode.plane - 1;
                        }

                        if(lowMemory) {
                           class255.region.setup(class62.field747);
                        } else {
                           class255.region.setup(0);
                        }

                        for(var6 = 0; var6 < 104; ++var6) {
                           for(var7 = 0; var7 < 104; ++var7) {
                              class18.groundItemSpawned(var6, var7);
                           }
                        }

                        BoundingBox2D.method36();

                        for(PendingSpawn var82 = (PendingSpawn)pendingSpawns.getFront(); var82 != null; var82 = (PendingSpawn)pendingSpawns.getNext()) {
                           if(var82.hitpoints == -1) {
                              var82.delay = 0;
                              OwnWorldComparator.method1247(var82);
                           } else {
                              var82.unlink();
                           }
                        }

                        ObjectComposition.field3593.reset();
                        PacketNode var83;
                        if(class23.clientInstance.method926()) {
                           var83 = WorldMapRectangle.method280(ClientPacket.field2433, field957.field1484);
                           var83.packetBuffer.putInt(1057001181);
                           field957.method2052(var83);
                        }

                        if(!isDynamicRegion) {
                           var6 = (ScriptState.field761 - 6) / 8;
                           var7 = (ScriptState.field761 + 6) / 8;
                           var73 = (GrandExchangeEvent.field301 - 6) / 8;
                           var56 = (GrandExchangeEvent.field301 + 6) / 8;

                           for(var10 = var6 - 1; var10 <= var7 + 1; ++var10) {
                              for(var11 = var73 - 1; var11 <= var56 + 1; ++var11) {
                                 if(var10 < var6 || var10 > var7 || var11 < var73 || var11 > var56) {
                                    MouseRecorder.indexMaps.method4552("m" + var10 + "_" + var11);
                                    MouseRecorder.indexMaps.method4552("l" + var10 + "_" + var11);
                                 }
                              }
                           }
                        }

                        class64.setGameState(30);
                        BoundingBox2D.method36();
                        CombatInfoListHolder.method1870();
                        var83 = WorldMapRectangle.method280(ClientPacket.field2464, field957.field1484);
                        field957.method2052(var83);
                        UrlRequester.timer.vmethod3326();

                        for(var7 = 0; var7 < 32; ++var7) {
                           GameEngine.field688[var7] = 0L;
                        }

                        for(var7 = 0; var7 < 32; ++var7) {
                           GameEngine.field709[var7] = 0L;
                        }

                        GameEngine.field684 = 0;
                     }
                  }
               }
            } else {
               class171.method3299(this);
            }

            if(gameState == 30) {
               this.method1261();
            } else if(gameState == 40 || gameState == 45) {
               this.method1260();
            }

            return;
         }

         var1.data.load(var1.index, (int)var1.hash, var1.field3367, false);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-66"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2;
      label174: {
         try {
            if(class229.field2687 == 2) {
               if(GraphicsObject.field1300 == null) {
                  GraphicsObject.field1300 = Track1.getMusicFile(class185.field2511, VertexNormal.field1931, GrandExchangeEvents.field284);
                  if(GraphicsObject.field1300 == null) {
                     var2 = false;
                     break label174;
                  }
               }

               if(SceneTilePaint.field1965 == null) {
                  SceneTilePaint.field1965 = new class110(class229.field2689, class229.field2691);
               }

               if(class229.field2690.method4136(GraphicsObject.field1300, class229.field2688, SceneTilePaint.field1965, 22050)) {
                  class229.field2690.method4137();
                  class229.field2690.method4134(class86.field1330);
                  class229.field2690.method4139(GraphicsObject.field1300, class229.field2692);
                  class229.field2687 = 0;
                  GraphicsObject.field1300 = null;
                  SceneTilePaint.field1965 = null;
                  class185.field2511 = null;
                  var2 = true;
                  break label174;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class229.field2690.method4140();
            class229.field2687 = 0;
            GraphicsObject.field1300 = null;
            SceneTilePaint.field1965 = null;
            class185.field2511 = null;
         }

         var2 = false;
      }

      if(var2 && field1102 && class155.soundSystem0 != null) {
         class155.soundSystem0.tryFlush();
      }

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && field1080 != 0L && class64.method1118() > field1080) {
         var4 = isResized?2:1;
         GameCanvas.method832(var4);
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1072[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class90.loadingBarPercentage, class90.loadingText, var1);
      } else if(gameState == 5) {
         class234.drawLoginScreen(MessageNode.fontBold12, class55.fontPlain11, class20.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class234.drawLoginScreen(MessageNode.fontBold12, class55.fontPlain11, class20.font_p12full, var1);
         } else if(gameState == 25) {
            if(field924 == 1) {
               if(field920 > field921) {
                  field921 = field920;
               }

               var4 = (field921 * 50 - field920 * 50) / field921;
               CombatInfo1.method1681("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field924 == 2) {
               if(field922 > field923) {
                  field923 = field922;
               }

               var4 = (field923 * 50 - field922 * 50) / field923 + 50;
               CombatInfo1.method1681("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               CombatInfo1.method1681("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1264();
         } else if(gameState == 40) {
            CombatInfo1.method1681("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            CombatInfo1.method1681("Please wait...", false);
         }
      } else {
         class234.drawLoginScreen(MessageNode.fontBold12, class55.fontPlain11, class20.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < widgetCount; ++var4) {
            if(field1073[var4]) {
               MapCacheArchiveNames.rasterProvider.draw(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1073[var4] = false;
            }
         }
      } else if(gameState > 0) {
         MapCacheArchiveNames.rasterProvider.drawFull(0, 0);

         for(var4 = 0; var4 < widgetCount; ++var4) {
            field1073[var4] = false;
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   protected final void vmethod1256() {
      if(SceneTilePaint.varcs.changed()) {
         SceneTilePaint.varcs.serialize();
      }

      if(WorldMapType2.mouseRecorder != null) {
         WorldMapType2.mouseRecorder.isRunning = false;
      }

      WorldMapType2.mouseRecorder = null;
      field957.close();
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

      class90.mouseWheel = null;
      if(class155.soundSystem0 != null) {
         class155.soundSystem0.shutdown();
      }

      if(class71.soundSystem1 != null) {
         class71.soundSystem1.shutdown();
      }

      if(class264.NetCache_socket != null) {
         class264.NetCache_socket.vmethod3331();
      }

      Object var10 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3401 != 0) {
            IndexStoreActionHandler.field3401 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(MapIconReference.urlRequester != null) {
         MapIconReference.urlRequester.close();
         MapIconReference.urlRequester = null;
      }

      MapIcon.method587();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-242123961"
   )
   protected final void vmethod1251() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      try {
         if(this.isValidHost()) {
            Parameters[] var1 = new Parameters[]{Parameters.field3812, Parameters.field3811, Parameters.field3810, Parameters.field3801, Parameters.field3809, Parameters.field3799, Parameters.field3807, Parameters.field3814, Parameters.field3805, Parameters.field3808, Parameters.field3813, Parameters.field3804, Parameters.field3803, Parameters.field3806, Parameters.field3800, Parameters.field3802};
            Parameters[] var2 = var1;

            for(int var3 = 0; var3 < var2.length; ++var3) {
               Parameters var4 = var2[var3];
               String var5 = this.getParameter(var4.key);
               if(var5 != null) {
                  switch(Integer.parseInt(var4.key)) {
                  case 1:
                     flags = Integer.parseInt(var5);
                     break;
                  case 2:
                     if(field877 == -1) {
                        field877 = Integer.parseInt(var5);
                     }
                  case 3:
                  case 6:
                  default:
                     break;
                  case 4:
                     world = Integer.parseInt(var5);
                     break;
                  case 5:
                     if(var5.equalsIgnoreCase("true")) {
                        isMembers = true;
                     } else {
                        isMembers = false;
                     }
                     break;
                  case 7:
                     if(var5.equalsIgnoreCase("true")) {
                        ;
                     }
                     break;
                  case 8:
                     WidgetNode.field795 = Integer.parseInt(var5);
                     break;
                  case 9:
                     field876 = var5;
                     break;
                  case 10:
                     class132.field1920 = ScriptVarType.method17(Integer.parseInt(var5));
                     break;
                  case 11:
                     languageId = Integer.parseInt(var5);
                     break;
                  case 12:
                     class55.sessionToken = var5;
                     break;
                  case 13:
                     class265.field3435 = (JagexGame)Permission.forOrdinal(class253.method4506(), Integer.parseInt(var5));
                     if(class265.field3435 == JagexGame.field3366) {
                        GZipDecompressor.loginType = JagexLoginType.field4069;
                     } else {
                        GZipDecompressor.loginType = JagexLoginType.field4070;
                     }
                     break;
                  case 14:
                     socketType = Integer.parseInt(var5);
                     break;
                  case 15:
                     field917 = Integer.parseInt(var5) != 0;
                  }
               }
            }

            Region.regionLowMemory = false;
            lowMemory = false;
            Projectile.host = this.getCodeBase().getHost();
            String var10 = class132.field1920.identifier;
            byte var6 = 0;

            try {
               Tile.method2684("oldschool", var10, var6, 17);
            } catch (Exception var8) {
               AttackOption.processClientError((String)null, var8);
            }

            class23.clientInstance = this;
            this.initialize(765, 503, 168);
         }
      } catch (RuntimeException var9) {
         throw class44.method664(var9, "client.init(" + ')');
      }
   }

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2100696516"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = GameEngine.method984();
         if(!var1) {
            this.method1258();
         }

      }
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-567153608"
   )
   void method1258() {
      if(class264.field3430 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class264.field3431 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field1046 = 3000;
            class264.field3431 = 3;
         }

         if(--field1046 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  GrandExchangeEvent.socket = GameEngine.taskManager.createSocket(Projectile.host, class138.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(GrandExchangeEvent.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(GrandExchangeEvent.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field917) {
                     class3.rssocket = class64.method1119((Socket)GrandExchangeEvent.socket.value, 40000, 5000);
                  } else {
                     class3.rssocket = new class173((Socket)GrandExchangeEvent.socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(168);
                  class3.rssocket.vmethod3337(var1.payload, 0, 5);
                  ++js5State;
                  WorldMapData.field463 = class64.method1118();
               }

               if(js5State == 3) {
                  if(class3.rssocket.vmethod3334() > 0 || !field917 && gameState <= 5) {
                     int var2 = class3.rssocket.vmethod3349();
                     if(var2 != 0) {
                        this.error(var2);
                        return;
                     }

                     ++js5State;
                  } else if(class64.method1118() - WorldMapData.field463 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  ScriptEvent.method1143(class3.rssocket, gameState > 20);
                  GrandExchangeEvent.socket = null;
                  class3.rssocket = null;
                  js5State = 0;
                  field902 = 0;
               }
            } catch (IOException var3) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "116"
   )
   @Export("error")
   void error(int var1) {
      GrandExchangeEvent.socket = null;
      class3.rssocket = null;
      js5State = 0;
      if(class228.port1 == class138.myWorldPort) {
         class138.myWorldPort = class243.port2;
      } else {
         class138.myWorldPort = class228.port1;
      }

      ++field902;
      if(field902 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field1046 = 3000;
         }
      } else if(field902 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field902 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field1046 = 3000;
         }
      }

   }

   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "70"
   )
   final void method1260() {
      Object var1 = field957.getSocket();
      PacketBuffer var2 = field957.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class169)var1).vmethod3331();
               var1 = null;
            }

            Size.field364 = null;
            socketError = false;
            field983 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(Size.field364 == null) {
               Size.field364 = GameEngine.taskManager.createSocket(Projectile.host, class138.myWorldPort);
            }

            if(Size.field364.status == 2) {
               throw new IOException();
            }

            if(Size.field364.status == 1) {
               if(field917) {
                  var1 = class64.method1119((Socket)Size.field364.value, 40000, 5000);
               } else {
                  var1 = new class173((Socket)Size.field364.value, GameEngine.taskManager, 5000);
               }

               field957.setSocket((class169)var1);
               Size.field364 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field957.method2038();
            PacketNode var4 = ServerPacket.method3433();
            var4.clientPacket = null;
            var4.field2503 = 0;
            var4.packetBuffer = new PacketBuffer(5000);
            var4.packetBuffer.putByte(LoginPacket.field2488.id);
            field957.method2052(var4);
            field957.method2039();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var12;
         int var13;
         if(loginState == 3) {
            if(class155.soundSystem0 != null) {
               class155.soundSystem0.method2214();
            }

            if(class71.soundSystem1 != null) {
               class71.soundSystem1.method2214();
            }

            var12 = true;
            if(field917 && !((class169)var1).vmethod3335(1)) {
               var12 = false;
            }

            if(var12) {
               var13 = ((class169)var1).vmethod3349();
               if(class155.soundSystem0 != null) {
                  class155.soundSystem0.method2214();
               }

               if(class71.soundSystem1 != null) {
                  class71.soundSystem1.method2214();
               }

               if(var13 != 0) {
                  MouseInput.method1051(var13);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var24;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var24 = ((class169)var1).vmethod3334();
               if(var24 > 8 - var2.offset) {
                  var24 = 8 - var2.offset;
               }

               if(var24 > 0) {
                  ((class169)var1).vmethod3348(var2.payload, var2.offset, var24);
                  var2.offset += var24;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               UrlRequester.field2126 = var2.readLong();
               loginState = 5;
            }
         }

         int var7;
         if(loginState == 5) {
            field957.packetBuffer.offset = 0;
            field957.method2038();
            PacketBuffer var3 = new PacketBuffer(500);
            int[] var19 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(UrlRequester.field2126 >> 32), (int)(UrlRequester.field2126 & -1L)};
            var3.offset = 0;
            var3.putByte(1);
            var3.putByte(field907.rsOrdinal());
            var3.putInt(var19[0]);
            var3.putInt(var19[1]);
            var3.putInt(var19[2]);
            var3.putInt(var19[3]);
            switch(field907.field2174) {
            case 0:
               var3.putInt(((Integer)preferences.preferences.get(Integer.valueOf(class228.method4120(class90.username)))).intValue());
               var3.offset += 4;
               break;
            case 1:
            case 3:
               var3.put24bitInt(Size.field369);
               var3.offset += 5;
               break;
            case 2:
               var3.offset += 8;
            }

            var3.putString(class90.password);
            var3.encryptRsa(class88.field1345, class88.field1346);
            PacketNode var6 = ServerPacket.method3433();
            var6.clientPacket = null;
            var6.field2503 = 0;
            var6.packetBuffer = new PacketBuffer(5000);
            var6.packetBuffer.offset = 0;
            if(gameState == 40) {
               var6.packetBuffer.putByte(LoginPacket.field2486.id);
            } else {
               var6.packetBuffer.putByte(LoginPacket.field2485.id);
            }

            var6.packetBuffer.putShort(0);
            var7 = var6.packetBuffer.offset;
            var6.packetBuffer.putInt(168);
            var6.packetBuffer.putBytes(var3.payload, 0, var3.offset);
            int var8 = var6.packetBuffer.offset;
            var6.packetBuffer.putString(class90.username);
            var6.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var6.packetBuffer.putShort(MapLabel.canvasWidth);
            var6.packetBuffer.putShort(FloorUnderlayDefinition.canvasHeight);
            PacketBuffer var9 = var6.packetBuffer;
            if(field908 != null) {
               var9.putBytes(field908, 0, field908.length);
            } else {
               byte[] var10 = MilliTimer.method3192();
               var9.putBytes(var10, 0, var10.length);
            }

            var6.packetBuffer.putString(class55.sessionToken);
            var6.packetBuffer.putInt(WidgetNode.field795);
            Buffer var23 = new Buffer(CombatInfo1.platformInfo.method6184());
            CombatInfo1.platformInfo.method6183(var23);
            var6.packetBuffer.putBytes(var23.payload, 0, var23.payload.length);
            var6.packetBuffer.putByte(field877);
            var6.packetBuffer.putInt(0);
            var6.packetBuffer.putInt(class71.indexInterfaces.crc);
            var6.packetBuffer.putInt(class93.indexSoundEffects.crc);
            var6.packetBuffer.putInt(Size.configsIndex.crc);
            var6.packetBuffer.putInt(WorldMapType3.indexCache3.crc);
            var6.packetBuffer.putInt(class55.indexCache4.crc);
            var6.packetBuffer.putInt(MouseRecorder.indexMaps.crc);
            var6.packetBuffer.putInt(PacketBuffer.indexTrack1.crc);
            var6.packetBuffer.putInt(class18.indexModels.crc);
            var6.packetBuffer.putInt(class151.indexSprites.crc);
            var6.packetBuffer.putInt(GameCanvas.indexTextures.crc);
            var6.packetBuffer.putInt(ClanMember.indexCache10.crc);
            var6.packetBuffer.putInt(class189.indexTrack2.crc);
            var6.packetBuffer.putInt(class190.indexScripts.crc);
            var6.packetBuffer.putInt(KeyFocusListener.indexCache13.crc);
            var6.packetBuffer.putInt(MapCacheArchiveNames.vorbisIndex.crc);
            var6.packetBuffer.putInt(MouseRecorder.indexCache15.crc);
            var6.packetBuffer.putInt(class95.indexWorldMap.crc);
            var6.packetBuffer.encryptXtea(var19, var8, var6.packetBuffer.offset);
            var6.packetBuffer.method3513(var6.packetBuffer.offset - var7);
            field957.method2052(var6);
            field957.method2039();
            field957.field1484 = new ISAACCipher(var19);

            for(int var11 = 0; var11 < 4; ++var11) {
               var19[var11] += 50;
            }

            var2.seed(var19);
            loginState = 6;
         }

         if(loginState == 6 && ((class169)var1).vmethod3334() > 0) {
            var24 = ((class169)var1).vmethod3349();
            if(var24 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var24 == 2) {
               loginState = 9;
            } else if(var24 == 15 && gameState == 40) {
               field957.packetLength = -1;
               loginState = 13;
            } else if(var24 == 23 && field905 < 1) {
               ++field905;
               loginState = 0;
            } else {
               if(var24 != 29) {
                  MouseInput.method1051(var24);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class169)var1).vmethod3334() > 0) {
            field906 = (((class169)var1).vmethod3349() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field983 = 0;
            BoundingBox3DDrawMode.method53("You have only just left another world.", "Your profile will be transferred in:", field906 / 60 + " seconds.");
            if(--field906 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && ((class169)var1).vmethod3334() >= 13) {
               var12 = ((class169)var1).vmethod3349() == 1;
               ((class169)var1).vmethod3348(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var25 = false;
               if(var12) {
                  var13 = var2.readOpcode() << 24;
                  var13 |= var2.readOpcode() << 16;
                  var13 |= var2.readOpcode() << 8;
                  var13 |= var2.readOpcode();
                  int var14 = class228.method4120(class90.username);
                  if(preferences.preferences.size() >= 10 && !preferences.preferences.containsKey(Integer.valueOf(var14))) {
                     Iterator var22 = preferences.preferences.entrySet().iterator();
                     var22.next();
                     var22.remove();
                  }

                  preferences.preferences.put(Integer.valueOf(var14), Integer.valueOf(var13));
               }

               if(class90.Login_isUsernameRemembered) {
                  preferences.rememberedUsername = class90.username;
               } else {
                  preferences.rememberedUsername = null;
               }

               MouseInput.method1062();
               rights = ((class169)var1).vmethod3349();
               field1020 = ((class169)var1).vmethod3349() == 1;
               localInteractingIndex = ((class169)var1).vmethod3349();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class169)var1).vmethod3349();
               field987 = ((class169)var1).vmethod3349();
               ((class169)var1).vmethod3348(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = new ServerPacket[]{ServerPacket.field2325, ServerPacket.field2304, ServerPacket.field2375, ServerPacket.field2300, ServerPacket.field2301, ServerPacket.field2351, ServerPacket.field2303, ServerPacket.field2341, ServerPacket.field2305, ServerPacket.field2306, ServerPacket.field2307, ServerPacket.field2362, ServerPacket.field2309, ServerPacket.field2310, ServerPacket.field2311, ServerPacket.field2312, ServerPacket.field2313, ServerPacket.field2314, ServerPacket.field2344, ServerPacket.field2330, ServerPacket.field2326, ServerPacket.field2318, ServerPacket.field2319, ServerPacket.field2320, ServerPacket.field2321, ServerPacket.field2322, ServerPacket.field2328, ServerPacket.field2302, ServerPacket.field2333, ServerPacket.field2316, ServerPacket.field2327, ServerPacket.field2336, ServerPacket.field2329, ServerPacket.field2377, ServerPacket.field2331, ServerPacket.field2332, ServerPacket.field2379, ServerPacket.field2299, ServerPacket.field2335, ServerPacket.field2298, ServerPacket.field2337, ServerPacket.field2297, ServerPacket.field2339, ServerPacket.field2340, ServerPacket.field2369, ServerPacket.field2342, ServerPacket.field2343, ServerPacket.field2357, ServerPacket.field2345, ServerPacket.field2346, ServerPacket.field2347, ServerPacket.field2348, ServerPacket.field2349, ServerPacket.field2350, ServerPacket.field2361, ServerPacket.field2352, ServerPacket.field2353, ServerPacket.field2360, ServerPacket.field2338, ServerPacket.field2356, ServerPacket.field2317, ServerPacket.field2358, ServerPacket.field2324, ServerPacket.field2334, ServerPacket.field2368, ServerPacket.field2355, ServerPacket.field2363, ServerPacket.field2364, ServerPacket.field2365, ServerPacket.field2366, ServerPacket.field2367, ServerPacket.field2323, ServerPacket.field2381, ServerPacket.field2370, ServerPacket.field2371, ServerPacket.field2372, ServerPacket.field2373, ServerPacket.field2374, ServerPacket.field2315, ServerPacket.field2376, ServerPacket.field2354, ServerPacket.field2378, ServerPacket.field2359, ServerPacket.field2380};
               var7 = var2.method3783();
               if(var7 < 0 || var7 >= var5.length) {
                  throw new IOException(var7 + " " + var2.offset);
               }

               field957.serverPacket = var5[var7];
               field957.packetLength = field957.serverPacket.packetLength;
               ((class169)var1).vmethod3348(var2.payload, 0, 2);
               var2.offset = 0;
               field957.packetLength = var2.readUnsignedShort();

               try {
                  class53.method824(class23.clientInstance, "zap");
               } catch (Throwable var16) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((class169)var1).vmethod3334() >= field957.packetLength) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3348(var2.payload, 0, field957.packetLength);
                  field918.method5213();
                  WidgetNode.method1136();
                  class3.initializeGPI(var2);
                  ScriptState.field761 = -1;
                  class3.xteaChanged(false, var2);
                  field957.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((class169)var1).vmethod3334() >= 2) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3348(var2.payload, 0, 2);
                  var2.offset = 0;
                  Bounds.field3945 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class169)var1).vmethod3334() >= Bounds.field3945) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3348(var2.payload, 0, Bounds.field3945);
                  var2.offset = 0;
                  String var18 = var2.readString();
                  String var20 = var2.readString();
                  String var21 = var2.readString();
                  BoundingBox3DDrawMode.method53(var18, var20, var21);
                  class64.setGameState(10);
               }

               if(loginState == 13) {
                  if(field957.packetLength == -1) {
                     if(((class169)var1).vmethod3334() < 2) {
                        return;
                     }

                     ((class169)var1).vmethod3348(var2.payload, 0, 2);
                     var2.offset = 0;
                     field957.packetLength = var2.readUnsignedShort();
                  }

                  if(((class169)var1).vmethod3334() >= field957.packetLength) {
                     ((class169)var1).vmethod3348(var2.payload, 0, field957.packetLength);
                     var2.offset = 0;
                     var24 = field957.packetLength;
                     field918.method5230();
                     class38.method549();
                     class3.initializeGPI(var2);
                     if(var24 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field983;
                  if(field983 > 2000) {
                     if(field905 < 1) {
                        if(class228.port1 == class138.myWorldPort) {
                           class138.myWorldPort = class243.port2;
                        } else {
                           class138.myWorldPort = class228.port1;
                        }

                        ++field905;
                        loginState = 0;
                     } else {
                        MouseInput.method1051(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var17) {
         if(field905 < 1) {
            if(class138.myWorldPort == class228.port1) {
               class138.myWorldPort = class243.port2;
            } else {
               class138.myWorldPort = class228.port1;
            }

            ++field905;
            loginState = 0;
         } else {
            MouseInput.method1051(-2);
         }
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-37921944"
   )
   final void method1261() {
      if(field888 > 1) {
         --field888;
      }

      if(field915 > 0) {
         --field915;
      }

      if(socketError) {
         socketError = false;
         if(field915 > 0) {
            VarPlayerType.method4736();
         } else {
            field918.method5211();
            class64.setGameState(40);
            FaceNormal.field2069 = field957.getSocket();
            field957.method2043();
         }

      } else {
         if(!isMenuOpen) {
            Size.method198();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1265(field957); ++var1) {
            ;
         }

         if(gameState == 30) {
            int var2;
            PacketNode var12;
            while(class28.method268()) {
               var12 = WorldMapRectangle.method280(ClientPacket.field2450, field957.field1484);
               var12.packetBuffer.putByte(0);
               var2 = var12.packetBuffer.offset;
               GrandExchangeEvents.encodeClassVerifier(var12.packetBuffer);
               var12.packetBuffer.method3514(var12.packetBuffer.offset - var2);
               field957.method2052(var12);
            }

            if(field918.field3825) {
               var12 = WorldMapRectangle.method280(ClientPacket.field2414, field957.field1484);
               var12.packetBuffer.putByte(0);
               var2 = var12.packetBuffer.offset;
               field918.method5225(var12.packetBuffer);
               var12.packetBuffer.method3514(var12.packetBuffer.offset - var2);
               field957.method2052(var12);
               field918.method5214();
            }

            Object var30 = WorldMapType2.mouseRecorder.lock;
            int var3;
            int var4;
            int var5;
            int var7;
            int var8;
            int var9;
            synchronized(WorldMapType2.mouseRecorder.lock) {
               if(!field1045) {
                  WorldMapType2.mouseRecorder.index = 0;
               } else if(MouseInput.mouseLastButton != 0 || WorldMapType2.mouseRecorder.index >= 40) {
                  PacketNode var13 = WorldMapRectangle.method280(ClientPacket.field2476, field957.field1484);
                  var13.packetBuffer.putByte(0);
                  var3 = var13.packetBuffer.offset;
                  var4 = 0;

                  for(var5 = 0; var5 < WorldMapType2.mouseRecorder.index && var13.packetBuffer.offset - var3 < 240; ++var5) {
                     ++var4;
                     int var6 = WorldMapType2.mouseRecorder.ys[var5];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 502) {
                        var6 = 502;
                     }

                     var7 = WorldMapType2.mouseRecorder.xs[var5];
                     if(var7 < 0) {
                        var7 = 0;
                     } else if(var7 > 764) {
                        var7 = 764;
                     }

                     var8 = var7 + var6 * 765;
                     if(WorldMapType2.mouseRecorder.ys[var5] == -1 && WorldMapType2.mouseRecorder.xs[var5] == -1) {
                        var7 = -1;
                        var6 = -1;
                        var8 = 524287;
                     }

                     if(var7 == field883 && var6 == field1113) {
                        if(field885 < 2047) {
                           ++field885;
                        }
                     } else {
                        var9 = var7 - field883;
                        field883 = var7;
                        int var10 = var6 - field1113;
                        field1113 = var6;
                        if(field885 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                           var9 += 32;
                           var10 += 32;
                           var13.packetBuffer.putShort(var10 + (field885 << 12) + (var9 << 6));
                           field885 = 0;
                        } else if(field885 < 8) {
                           var13.packetBuffer.put24bitInt((field885 << 19) + var8 + 8388608);
                           field885 = 0;
                        } else {
                           var13.packetBuffer.putInt((field885 << 19) + var8 + -1073741824);
                           field885 = 0;
                        }
                     }
                  }

                  var13.packetBuffer.method3514(var13.packetBuffer.offset - var3);
                  field957.method2052(var13);
                  if(var4 >= WorldMapType2.mouseRecorder.index) {
                     WorldMapType2.mouseRecorder.index = 0;
                  } else {
                     WorldMapType2.mouseRecorder.index -= var4;

                     for(var5 = 0; var5 < WorldMapType2.mouseRecorder.index; ++var5) {
                        WorldMapType2.mouseRecorder.xs[var5] = WorldMapType2.mouseRecorder.xs[var5 + var4];
                        WorldMapType2.mouseRecorder.ys[var5] = WorldMapType2.mouseRecorder.ys[var5 + var4];
                     }
                  }
               }
            }

            PacketNode var16;
            if(MouseInput.mouseLastButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
               long var14 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
               if(var14 > 4095L) {
                  var14 = 4095L;
               }

               mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis * -1L;
               var3 = MouseInput.mouseLastPressedY;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > FloorUnderlayDefinition.canvasHeight) {
                  var3 = FloorUnderlayDefinition.canvasHeight;
               }

               var4 = MouseInput.mouseLastPressedX;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > MapLabel.canvasWidth) {
                  var4 = MapLabel.canvasWidth;
               }

               var5 = (int)var14;
               var16 = WorldMapRectangle.method280(ClientPacket.field2447, field957.field1484);
               var16.packetBuffer.putShort((MouseInput.mouseLastButton == 2?1:0) + (var5 << 1));
               var16.packetBuffer.putShort(var4);
               var16.packetBuffer.putShort(var3);
               field957.method2052(var16);
            }

            if(KeyFocusListener.field638 > 0) {
               var12 = WorldMapRectangle.method280(ClientPacket.field2384, field957.field1484);
               var12.packetBuffer.putShort(0);
               var2 = var12.packetBuffer.offset;
               long var17 = class64.method1118();

               for(var5 = 0; var5 < KeyFocusListener.field638; ++var5) {
                  long var19 = var17 - field1091;
                  if(var19 > 16777215L) {
                     var19 = 16777215L;
                  }

                  field1091 = var17;
                  var12.packetBuffer.method3543(KeyFocusListener.field630[var5]);
                  var12.packetBuffer.method3722((int)var19);
               }

               var12.packetBuffer.method3513(var12.packetBuffer.offset - var2);
               field957.method2052(var12);
            }

            if(field953 > 0) {
               --field953;
            }

            if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
               field954 = true;
            }

            if(field954 && field953 <= 0) {
               field953 = 20;
               field954 = false;
               var12 = WorldMapRectangle.method280(ClientPacket.field2402, field957.field1484);
               var12.packetBuffer.putShort(cameraPitchTarget);
               var12.packetBuffer.method3528(mapAngle);
               field957.method2052(var12);
            }

            if(PlayerComposition.field2798 && !field886) {
               field886 = true;
               var12 = WorldMapRectangle.method280(ClientPacket.field2408, field957.field1484);
               var12.packetBuffer.putByte(1);
               field957.method2052(var12);
            }

            if(!PlayerComposition.field2798 && field886) {
               field886 = false;
               var12 = WorldMapRectangle.method280(ClientPacket.field2408, field957.field1484);
               var12.packetBuffer.putByte(0);
               field957.method2052(var12);
            }

            if(Preferences.renderOverview != null) {
               Preferences.renderOverview.method6008();
            }

            if(BoundingBox.field249) {
               if(GameEngine.clanMemberManager != null) {
                  GameEngine.clanMemberManager.method5331();
               }

               MapCacheArchiveNames.method588();
               BoundingBox.field249 = false;
            }

            if(BoundingBox3DDrawMode.plane != field881) {
               field881 = BoundingBox3DDrawMode.plane;
               ScriptEvent.method1141(BoundingBox3DDrawMode.plane);
            }

            if(gameState == 30) {
               for(PendingSpawn var33 = (PendingSpawn)pendingSpawns.getFront(); var33 != null; var33 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var33.hitpoints > 0) {
                     --var33.hitpoints;
                  }

                  if(var33.hitpoints == 0) {
                     if(var33.field1146 < 0 || MessageNode.method1179(var33.field1146, var33.field1147)) {
                        class167.method3256(var33.level, var33.type, var33.x, var33.y, var33.field1146, var33.field1144, var33.field1147);
                        var33.unlink();
                     }
                  } else {
                     if(var33.delay > 0) {
                        --var33.delay;
                     }

                     if(var33.delay == 0 && var33.x >= 1 && var33.y >= 1 && var33.x <= 102 && var33.y <= 102 && (var33.id < 0 || MessageNode.method1179(var33.id, var33.field1151))) {
                        class167.method3256(var33.level, var33.type, var33.x, var33.y, var33.id, var33.orientation, var33.field1151);
                        var33.delay = -1;
                        if(var33.field1146 == var33.id && var33.field1146 == -1) {
                           var33.unlink();
                        } else if(var33.id == var33.field1146 && var33.field1144 == var33.orientation && var33.field1147 == var33.field1151) {
                           var33.unlink();
                        }
                     }
                  }
               }

               class28.method275();
               ++field957.field1480;
               if(field957.field1480 > 750) {
                  if(field915 > 0) {
                     VarPlayerType.method4736();
                  } else {
                     field918.method5211();
                     class64.setGameState(40);
                     FaceNormal.field2069 = field957.getSocket();
                     field957.method2043();
                  }

               } else {
                  var1 = class93.playerIndexesCount;
                  int[] var31 = class93.playerIndices;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var21 = cachedPlayers[var31[var3]];
                     if(var21 != null) {
                        WorldMapType3.method234(var21, 1);
                     }
                  }

                  for(var1 = 0; var1 < npcIndexesCount; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var22 = cachedNPCs[var2];
                     if(var22 != null) {
                        WorldMapType3.method234(var22, var22.composition.size);
                     }
                  }

                  int[] var34 = class93.playerIndices;

                  for(var2 = 0; var2 < class93.playerIndexesCount; ++var2) {
                     Player var41 = cachedPlayers[var34[var2]];
                     if(var41 != null && var41.overheadTextCyclesRemaining > 0) {
                        --var41.overheadTextCyclesRemaining;
                        if(var41.overheadTextCyclesRemaining == 0) {
                           var41.overhead = null;
                        }
                     }
                  }

                  for(var2 = 0; var2 < npcIndexesCount; ++var2) {
                     var3 = npcIndices[var2];
                     NPC var39 = cachedNPCs[var3];
                     if(var39 != null && var39.overheadTextCyclesRemaining > 0) {
                        --var39.overheadTextCyclesRemaining;
                        if(var39.overheadTextCyclesRemaining == 0) {
                           var39.overhead = null;
                        }
                     }
                  }

                  ++field930;
                  if(cursorState != 0) {
                     field972 += 20;
                     if(field972 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class2.field17 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        FontName.method5490(class2.field17);
                        class2.field17 = null;
                     }
                  }

                  Widget var35 = BoundingBox3D.field259;
                  Widget var32 = class7.field234;
                  BoundingBox3D.field259 = null;
                  class7.field234 = null;
                  draggedOnWidget = null;
                  field958 = false;
                  field1053 = false;
                  field952 = 0;

                  while(class160.method3183() && field952 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && Item.currentPressedKey == 66) {
                        String var40 = "";

                        MessageNode var36;
                        for(Iterator var23 = class95.messages.iterator(); var23.hasNext(); var40 = var40 + var36.name + ':' + var36.value + '\n') {
                           var36 = (MessageNode)var23.next();
                        }

                        class23.clientInstance.method898(var40);
                     } else if(field960 != 1 || class38.currentTypedKey <= 0) {
                        field968[field952] = Item.currentPressedKey;
                        field1089[field952] = class38.currentTypedKey;
                        ++field952;
                     }
                  }

                  boolean var27 = rights >= 2;
                  if(var27 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var4 = SoundTaskDataProvider.localPlayer.field856 - mouseWheelRotation;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != SoundTaskDataProvider.localPlayer.field856) {
                        class19.method166(SoundTaskDataProvider.localPlayer.pathX[0] + class138.baseX, SoundTaskDataProvider.localPlayer.pathY[0] + class23.baseY, var4, false);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     WorldMapData.method400(widgetRoot, 0, 0, MapLabel.canvasWidth, FloorUnderlayDefinition.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var37;
                     ScriptEvent var42;
                     Widget var43;
                     do {
                        var42 = (ScriptEvent)field1067.popFront();
                        if(var42 == null) {
                           while(true) {
                              do {
                                 var42 = (ScriptEvent)field1125.popFront();
                                 if(var42 == null) {
                                    while(true) {
                                       do {
                                          var42 = (ScriptEvent)field1066.popFront();
                                          if(var42 == null) {
                                             this.method1446();
                                             if(Preferences.renderOverview != null) {
                                                Preferences.renderOverview.method6018(BoundingBox3DDrawMode.plane, (SoundTaskDataProvider.localPlayer.x >> 7) + class138.baseX, (SoundTaskDataProvider.localPlayer.y >> 7) + class23.baseY, false);
                                                Preferences.renderOverview.method6034();
                                             }

                                             if(draggedWidget != null) {
                                                this.method1271();
                                             }

                                             if(UrlRequest.field2137 != null) {
                                                FontName.method5490(UrlRequest.field2137);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(field1051) {
                                                      if(class36.field492 == UrlRequest.field2137 && field977 != field980) {
                                                         Widget var44 = UrlRequest.field2137;
                                                         byte var28 = 0;
                                                         if(field1096 == 1 && var44.contentType == 206) {
                                                            var28 = 1;
                                                         }

                                                         if(var44.itemIds[field980] <= 0) {
                                                            var28 = 0;
                                                         }

                                                         var7 = GroundObject.getWidgetClickMask(var44);
                                                         boolean var29 = (var7 >> 29 & 1) != 0;
                                                         if(var29) {
                                                            var8 = field977;
                                                            var9 = field980;
                                                            var44.itemIds[var9] = var44.itemIds[var8];
                                                            var44.itemQuantities[var9] = var44.itemQuantities[var8];
                                                            var44.itemIds[var8] = -1;
                                                            var44.itemQuantities[var8] = 0;
                                                         } else if(var28 == 1) {
                                                            var8 = field977;
                                                            var9 = field980;

                                                            while(var8 != var9) {
                                                               if(var8 > var9) {
                                                                  var44.method4461(var8 - 1, var8);
                                                                  --var8;
                                                               } else if(var8 < var9) {
                                                                  var44.method4461(var8 + 1, var8);
                                                                  ++var8;
                                                               }
                                                            }
                                                         } else {
                                                            var44.method4461(field980, field977);
                                                         }

                                                         PacketNode var24 = WorldMapRectangle.method280(ClientPacket.field2423, field957.field1484);
                                                         var24.packetBuffer.putByte(var28);
                                                         var24.packetBuffer.putShort(field977);
                                                         var24.packetBuffer.method3551(field980);
                                                         var24.packetBuffer.method3552(UrlRequest.field2137.id);
                                                         field957.method2052(var24);
                                                      }
                                                   } else if(this.method1267()) {
                                                      this.openMenu(field978, field912);
                                                   } else if(menuOptionCount > 0) {
                                                      var4 = field978;
                                                      var5 = field912;
                                                      ContextMenuRow var38 = Projectile.topContextMenuRow;
                                                      PacketBuffer.menuAction(var38.param0, var38.param1, var38.type, var38.identifier, var38.option, var38.option, var4, var5);
                                                      Projectile.topContextMenuRow = null;
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   UrlRequest.field2137 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field978 + 5 || MouseInput.mouseLastX < field978 - 5 || MouseInput.mouseLastY > field912 + 5 || MouseInput.mouseLastY < field912 - 5)) {
                                                   field1051 = true;
                                                }
                                             }

                                             if(Region.method2906()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                var16 = WorldMapRectangle.method280(ClientPacket.field2395, field957.field1484);
                                                var16.packetBuffer.putByte(5);
                                                var16.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                var16.packetBuffer.method3550(var5 + class23.baseY);
                                                var16.packetBuffer.method3551(var4 + class138.baseX);
                                                field957.method2052(var16);
                                                Region.method2892();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field972 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var35 != BoundingBox3D.field259) {
                                                if(var35 != null) {
                                                   FontName.method5490(var35);
                                                }

                                                if(BoundingBox3D.field259 != null) {
                                                   FontName.method5490(BoundingBox3D.field259);
                                                }
                                             }

                                             if(var32 != class7.field234 && field1115 == field1021) {
                                                if(var32 != null) {
                                                   FontName.method5490(var32);
                                                }

                                                if(class7.field234 != null) {
                                                   FontName.method5490(class7.field234);
                                                }
                                             }

                                             if(class7.field234 != null) {
                                                if(field1115 < field1021) {
                                                   ++field1115;
                                                   if(field1115 == field1021) {
                                                      FontName.method5490(class7.field234);
                                                   }
                                                }
                                             } else if(field1115 > 0) {
                                                --field1115;
                                             }

                                             Ignore.method5385();
                                             if(field1111) {
                                                Widget.method4465();
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1116[var4];
                                             }

                                             SceneTilePaint.varcs.process();
                                             var4 = Frames.method3065();
                                             var5 = WorldMapType3.method235();
                                             if(var4 > 15000 && var5 > 15000) {
                                                field915 = 250;
                                                class25.method200(14500);
                                                var16 = WorldMapRectangle.method280(ClientPacket.field2482, field957.field1484);
                                                field957.method2052(var16);
                                             }

                                             WorldMapRectangle.friendManager.method1735();
                                             ++field957.field1485;
                                             if(field957.field1485 > 50) {
                                                var16 = WorldMapRectangle.method280(ClientPacket.field2452, field957.field1484);
                                                field957.method2052(var16);
                                             }

                                             try {
                                                field957.method2039();
                                             } catch (IOException var25) {
                                                if(field915 > 0) {
                                                   VarPlayerType.method4736();
                                                } else {
                                                   field918.method5211();
                                                   class64.setGameState(40);
                                                   FaceNormal.field2069 = field957.getSocket();
                                                   field957.method2043();
                                                }
                                             }

                                             return;
                                          }

                                          var43 = var42.widget;
                                          if(var43.index < 0) {
                                             break;
                                          }

                                          var37 = class44.getWidget(var43.parentId);
                                       } while(var37 == null || var37.children == null || var43.index >= var37.children.length || var43 != var37.children[var43.index]);

                                       AbstractSoundSystem.method2256(var42);
                                    }
                                 }

                                 var43 = var42.widget;
                                 if(var43.index < 0) {
                                    break;
                                 }

                                 var37 = class44.getWidget(var43.parentId);
                              } while(var37 == null || var37.children == null || var43.index >= var37.children.length || var43 != var37.children[var43.index]);

                              AbstractSoundSystem.method2256(var42);
                           }
                        }

                        var43 = var42.widget;
                        if(var43.index < 0) {
                           break;
                        }

                        var37 = class44.getWidget(var43.parentId);
                     } while(var37 == null || var37.children == null || var43.index >= var37.children.length || var43 != var37.children[var43.index]);

                     AbstractSoundSystem.method2256(var42);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-22142"
   )
   void method1263() {
      int var1 = MapLabel.canvasWidth;
      int var2 = FloorUnderlayDefinition.canvasHeight;
      if(super.field680 < var1) {
         var1 = super.field680;
      }

      if(super.field712 < var2) {
         var2 = super.field712;
      }

      if(preferences != null) {
         try {
            Client var3 = class23.clientInstance;
            int var4 = isResized?2:1;
            class53.method820(var3, "resize", new Object[]{Integer.valueOf(var4)});
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "397274736"
   )
   final void method1264() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(class189.loadWidget(var1)) {
            class47.method739(MouseRecorder.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field1072[var1]) {
            field1073[var1] = true;
         }

         field1074[var1] = field1072[var1];
         field1072[var1] = false;
      }

      field1071 = gameCycle;
      field991 = -1;
      field1019 = -1;
      class36.field492 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         class88.method1893(widgetRoot, 0, 0, MapLabel.canvasWidth, FloorUnderlayDefinition.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      if(!isMenuOpen) {
         if(field991 != -1) {
            AttackOption.method1903(field991, field1019);
         }
      } else {
         class195.method3741();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field1074[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1073[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = BoundingBox3DDrawMode.plane;
      int var2 = SoundTaskDataProvider.localPlayer.x;
      int var3 = SoundTaskDataProvider.localPlayer.y;
      int var4 = field930;

      for(class80 var5 = (class80)class80.field1263.getFront(); var5 != null; var5 = (class80)class80.field1263.getNext()) {
         if(var5.field1264 != -1 || var5.field1274 != null) {
            int var6 = 0;
            if(var2 > var5.field1269) {
               var6 += var2 - var5.field1269;
            } else if(var2 < var5.field1265) {
               var6 += var5.field1265 - var2;
            }

            if(var3 > var5.field1262) {
               var6 += var3 - var5.field1262;
            } else if(var3 < var5.field1261) {
               var6 += var5.field1261 - var3;
            }

            if(var6 - 64 <= var5.field1273 && field951 != 0 && var1 == var5.field1259) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               int var7 = (var5.field1273 - var6) * field951 / var5.field1273;
               Object var10000;
               if(var5.field1266 == null) {
                  if(var5.field1264 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.getTrack(class55.indexCache4, var5.field1264, 0);
                     if(var8 != null) {
                        RawAudioNode var9 = var8.method2124().applyResampler(WorldMapDecoration.field446);
                        class115 var10 = class115.method2317(var9, 100, var7);
                        var10.method2320(-1);
                        MouseInput.field727.method2059(var10);
                        var5.field1266 = var10;
                     }
                  }
               } else {
                  var5.field1266.method2321(var7);
               }

               if(var5.field1271 == null) {
                  if(var5.field1274 != null && (var5.field1270 -= var4) <= 0) {
                     int var12 = (int)(Math.random() * (double)var5.field1274.length);
                     var10000 = null;
                     SoundEffect var13 = SoundEffect.getTrack(class55.indexCache4, var5.field1274[var12], 0);
                     if(var13 != null) {
                        RawAudioNode var14 = var13.method2124().applyResampler(WorldMapDecoration.field446);
                        class115 var11 = class115.method2317(var14, 100, var7);
                        var11.method2320(0);
                        MouseInput.field727.method2059(var11);
                        var5.field1271 = var11;
                        var5.field1270 = var5.field1267 + (int)(Math.random() * (double)(var5.field1268 - var5.field1267));
                     }
                  }
               } else {
                  var5.field1271.method2321(var7);
                  if(!var5.field1271.linked()) {
                     var5.field1271 = null;
                  }
               }
            } else {
               if(var5.field1266 != null) {
                  MouseInput.field727.method2060(var5.field1266);
                  var5.field1266 = null;
               }

               if(var5.field1271 != null) {
                  MouseInput.field727.method2060(var5.field1271);
                  var5.field1271 = null;
               }
            }
         }
      }

      field930 = 0;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(Lcq;I)Z",
      garbageValue = "2084259347"
   )
   final boolean method1265(NetWriter var1) {
      class169 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         String var5;
         int var6;
         try {
            if(var1.serverPacket == null) {
               if(var1.field1489) {
                  if(!var2.vmethod3335(1)) {
                     return false;
                  }

                  var2.vmethod3348(var1.packetBuffer.payload, 0, 1);
                  var1.field1480 = 0;
                  var1.field1489 = false;
               }

               var3.offset = 0;
               if(var3.method3780()) {
                  if(!var2.vmethod3335(1)) {
                     return false;
                  }

                  var2.vmethod3348(var1.packetBuffer.payload, 1, 1);
                  var1.field1480 = 0;
               }

               var1.field1489 = true;
               ServerPacket[] var4 = new ServerPacket[]{ServerPacket.field2325, ServerPacket.field2304, ServerPacket.field2375, ServerPacket.field2300, ServerPacket.field2301, ServerPacket.field2351, ServerPacket.field2303, ServerPacket.field2341, ServerPacket.field2305, ServerPacket.field2306, ServerPacket.field2307, ServerPacket.field2362, ServerPacket.field2309, ServerPacket.field2310, ServerPacket.field2311, ServerPacket.field2312, ServerPacket.field2313, ServerPacket.field2314, ServerPacket.field2344, ServerPacket.field2330, ServerPacket.field2326, ServerPacket.field2318, ServerPacket.field2319, ServerPacket.field2320, ServerPacket.field2321, ServerPacket.field2322, ServerPacket.field2328, ServerPacket.field2302, ServerPacket.field2333, ServerPacket.field2316, ServerPacket.field2327, ServerPacket.field2336, ServerPacket.field2329, ServerPacket.field2377, ServerPacket.field2331, ServerPacket.field2332, ServerPacket.field2379, ServerPacket.field2299, ServerPacket.field2335, ServerPacket.field2298, ServerPacket.field2337, ServerPacket.field2297, ServerPacket.field2339, ServerPacket.field2340, ServerPacket.field2369, ServerPacket.field2342, ServerPacket.field2343, ServerPacket.field2357, ServerPacket.field2345, ServerPacket.field2346, ServerPacket.field2347, ServerPacket.field2348, ServerPacket.field2349, ServerPacket.field2350, ServerPacket.field2361, ServerPacket.field2352, ServerPacket.field2353, ServerPacket.field2360, ServerPacket.field2338, ServerPacket.field2356, ServerPacket.field2317, ServerPacket.field2358, ServerPacket.field2324, ServerPacket.field2334, ServerPacket.field2368, ServerPacket.field2355, ServerPacket.field2363, ServerPacket.field2364, ServerPacket.field2365, ServerPacket.field2366, ServerPacket.field2367, ServerPacket.field2323, ServerPacket.field2381, ServerPacket.field2370, ServerPacket.field2371, ServerPacket.field2372, ServerPacket.field2373, ServerPacket.field2374, ServerPacket.field2315, ServerPacket.field2376, ServerPacket.field2354, ServerPacket.field2378, ServerPacket.field2359, ServerPacket.field2380};
               var6 = var3.method3783();
               if(var6 < 0 || var6 >= var4.length) {
                  throw new IOException(var6 + " " + var3.offset);
               }

               var1.serverPacket = var4[var6];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3335(1)) {
                  return false;
               }

               var1.getSocket().vmethod3348(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3335(2)) {
                  return false;
               }

               var1.getSocket().vmethod3348(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3335(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3348(var3.payload, 0, var1.packetLength);
            var1.field1480 = 0;
            field918.method5210();
            var1.field1493 = var1.field1492;
            var1.field1492 = var1.field1495;
            var1.field1495 = var1.serverPacket;
            int var23;
            Widget var68;
            if(ServerPacket.field2298 == var1.serverPacket) {
               var23 = var3.readInt();
               var68 = class44.getWidget(var23);
               var68.modelType = 3;
               var68.modelId = SoundTaskDataProvider.localPlayer.composition.method4385();
               FontName.method5490(var68);
               var1.serverPacket = null;
               return true;
            }

            int var24;
            Widget var70;
            if(ServerPacket.field2364 == var1.serverPacket) {
               var23 = var3.method3556();
               var24 = var3.method3562();
               var6 = var3.method3595();
               var70 = class44.getWidget(var24);
               if(var23 != var70.originalX || var6 != var70.originalY || var70.dynamicX != 0 || var70.dynamicY != 0) {
                  var70.originalX = var23;
                  var70.originalY = var6;
                  var70.dynamicX = 0;
                  var70.dynamicY = 0;
                  FontName.method5490(var70);
                  this.widgetMethod0(var70);
                  if(var70.type == 0) {
                     class86.method1889(MouseRecorder.widgets[var24 >> 16], var70, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2327 == var1.serverPacket) {
               var23 = var3.readInt();
               WidgetNode var72 = (WidgetNode)componentTable.get((long)var23);
               if(var72 != null) {
                  class57.closeWidget(var72, true);
               }

               if(field1033 != null) {
                  FontName.method5490(field1033);
                  field1033 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2343 == var1.serverPacket) {
               field1084 = var3.method3538();
               publicChatMode = var3.readUnsignedShortOb1();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2342 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readUnsignedShort();
               class237.serverVarps[var24] = var23;
               if(class237.clientVarps[var24] != var23) {
                  class237.clientVarps[var24] = var23;
               }

               class18.method142(var24);
               field984[++field1054 - 1 & 31] = var24;
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

               field1062 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            String var62;
            if(ServerPacket.field2371 == var1.serverPacket) {
               var62 = var3.readString();
               Object[] var71 = new Object[var62.length() + 1];

               for(var6 = var62.length() - 1; var6 >= 0; --var6) {
                  if(var62.charAt(var6) == 's') {
                     var71[var6 + 1] = var3.readString();
                  } else {
                     var71[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var71[0] = new Integer(var3.readInt());
               ScriptEvent var92 = new ScriptEvent();
               var92.objs = var71;
               AbstractSoundSystem.method2256(var92);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2312 == var1.serverPacket) {
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

            if(ServerPacket.field2358 == var1.serverPacket) {
               class278.field3551 = var3.method3636();
               WidgetNode.field794 = var3.method3538();
               var1.serverPacket = null;
               return true;
            }

            int var8;
            long var9;
            int var26;
            if(ServerPacket.field2335 == var1.serverPacket) {
               var23 = var3.method3562();
               var24 = var3.method3553();
               if(var24 == 65535) {
                  var24 = -1;
               }

               var6 = var3.method3564();
               var26 = var3.method3553();
               if(var26 == 65535) {
                  var26 = -1;
               }

               for(var8 = var24; var8 <= var26; ++var8) {
                  var9 = (long)var8 + ((long)var23 << 32);
                  Node var76 = widgetFlags.get(var9);
                  if(var76 != null) {
                     var76.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var6), var9);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2331 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               field960 = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2355 == var1.serverPacket) {
               var62 = var3.readString();
               var24 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               if(var24 >= 1 && var24 <= 8) {
                  if(var62.equalsIgnoreCase("null")) {
                     var62 = null;
                  }

                  playerOptions[var24 - 1] = var62;
                  playerOptionsPriorities[var24 - 1] = var6 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2297 == var1.serverPacket) {
               class3.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2354 == var1.serverPacket) {
               field1099 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            Widget var25;
            boolean var81;
            if(ServerPacket.field2365 == var1.serverPacket) {
               var81 = var3.method3538() == 1;
               var24 = var3.method3564();
               var25 = class44.getWidget(var24);
               if(var81 != var25.isHidden) {
                  var25.isHidden = var81;
                  FontName.method5490(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2307 == var1.serverPacket) {
               class3.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2350 == var1.serverPacket) {
               class57.method869(class183.field2491);
               var1.serverPacket = null;
               return true;
            }

            WidgetNode var7;
            if(ServerPacket.field2316 == var1.serverPacket) {
               var23 = var3.method3563();
               var24 = var3.readUnsignedShortOb1();
               var6 = var3.method3553();
               var7 = (WidgetNode)componentTable.get((long)var23);
               if(var7 != null) {
                  class57.closeWidget(var7, var6 != var7.id);
               }

               FileSystem.method4523(var23, var6, var24);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2370 == var1.serverPacket) {
               field888 = var3.method3555() * 30;
               field1064 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2322 == var1.serverPacket) {
               WidgetNode.field794 = var3.method3636();
               class278.field3551 = var3.method3538();

               while(var3.offset < var1.packetLength) {
                  var23 = var3.readUnsignedByte();
                  class183[] var69 = new class183[]{class183.field2491, class183.field2490, class183.field2501, class183.field2492, class183.field2489, class183.field2494, class183.field2493, class183.field2495, class183.field2497, class183.field2498};
                  class183 var91 = var69[var23];
                  class57.method869(var91);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2320 == var1.serverPacket) {
               class57.method869(class183.field2493);
               var1.serverPacket = null;
               return true;
            }

            int var27;
            if(ServerPacket.field2337 == var1.serverPacket) {
               var23 = var1.packetLength;
               var24 = var3.offset;
               class93.field1438 = 0;
               var6 = 0;
               var3.bitAccess();

               for(var26 = 0; var26 < class93.playerIndexesCount; ++var26) {
                  var8 = class93.playerIndices[var26];
                  if((class93.field1428[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                     } else {
                        var27 = var3.getBits(1);
                        if(var27 == 0) {
                           var6 = FriendManager.method1789(var3);
                           class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                        } else {
                           class22.decodeMovement(var3, var8);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var26 = 0; var26 < class93.playerIndexesCount; ++var26) {
                  var8 = class93.playerIndices[var26];
                  if((class93.field1428[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                     } else {
                        var27 = var3.getBits(1);
                        if(var27 == 0) {
                           var6 = FriendManager.method1789(var3);
                           class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                        } else {
                           class22.decodeMovement(var3, var8);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var26 = 0; var26 < class93.field1433; ++var26) {
                  var8 = class93.field1435[var26];
                  if((class93.field1428[var8] & 1) != 0) {
                     if(var6 > 0) {
                        --var6;
                        class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                     } else {
                        var27 = var3.getBits(1);
                        if(var27 == 0) {
                           var6 = FriendManager.method1789(var3);
                           class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                        } else if(ScriptEvent.decodeRegionHash(var3, var8)) {
                           class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               var3.bitAccess();

               for(var26 = 0; var26 < class93.field1433; ++var26) {
                  var8 = class93.field1435[var26];
                  if((class93.field1428[var8] & 1) == 0) {
                     if(var6 > 0) {
                        --var6;
                        class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                     } else {
                        var27 = var3.getBits(1);
                        if(var27 == 0) {
                           var6 = FriendManager.method1789(var3);
                           class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                        } else if(ScriptEvent.decodeRegionHash(var3, var8)) {
                           class93.field1428[var8] = (byte)(class93.field1428[var8] | 2);
                        }
                     }
                  }
               }

               var3.byteAccess();
               if(var6 != 0) {
                  throw new RuntimeException();
               }

               class93.playerIndexesCount = 0;
               class93.field1433 = 0;

               Player var95;
               for(var26 = 1; var26 < 2048; ++var26) {
                  class93.field1428[var26] = (byte)(class93.field1428[var26] >> 1);
                  var95 = cachedPlayers[var26];
                  if(var95 != null) {
                     class93.playerIndices[++class93.playerIndexesCount - 1] = var26;
                  } else {
                     class93.field1435[++class93.field1433 - 1] = var26;
                  }
               }

               for(var6 = 0; var6 < class93.field1438; ++var6) {
                  var26 = class93.field1439[var6];
                  var95 = cachedPlayers[var26];
                  var27 = var3.readUnsignedByte();
                  if((var27 & 32) != 0) {
                     var27 += var3.readUnsignedByte() << 8;
                  }

                  CombatInfo2.method4869(var3, var26, var95, var27);
               }

               if(var23 != var3.offset - var24) {
                  throw new RuntimeException(var3.offset - var24 + " " + var23);
               }

               if(BaseVarType.field25 != null) {
                  field1135 = gameCycle;
                  BaseVarType.field25.method4688();

                  for(var24 = 0; var24 < cachedPlayers.length; ++var24) {
                     if(cachedPlayers[var24] != null) {
                        BaseVarType.field25.method4703((cachedPlayers[var24].x >> 7) + class138.baseX, (cachedPlayers[var24].y >> 7) + class23.baseY);
                     }
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2318 == var1.serverPacket) {
               var23 = var3.readInt();
               if(var23 != field970) {
                  field970 = var23;
                  BoundingBox2D.method32();
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2368 == var1.serverPacket) {
               field1111 = false;

               for(var23 = 0; var23 < 5; ++var23) {
                  field955[var23] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2369 == var1.serverPacket) {
               class57.method869(class183.field2490);
               var1.serverPacket = null;
               return true;
            }

            long var10;
            int var12;
            int var14;
            int var16;
            int var18;
            int var79;
            String var80;
            String var84;
            String var88;
            if(ServerPacket.field2344 == var1.serverPacket) {
               var62 = var3.readString();
               class55.sessionToken = var62;

               try {
                  var5 = class23.clientInstance.getParameter(Parameters.field3811.key);
                  var80 = class23.clientInstance.getParameter(Parameters.field3808.key);
                  String var74 = var5 + "settings=" + var62 + "; version=1; path=/; domain=" + var80;
                  if(var62.length() == 0) {
                     var74 = var74 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var84 = var74 + "; Expires=";
                     var10 = class64.method1118() + 94608000000L;
                     class204.field2620.setTime(new Date(var10));
                     var12 = class204.field2620.get(7);
                     int var77 = class204.field2620.get(5);
                     var14 = class204.field2620.get(2);
                     var79 = class204.field2620.get(1);
                     var16 = class204.field2620.get(11);
                     int var17 = class204.field2620.get(12);
                     var18 = class204.field2620.get(13);
                     var88 = class204.field2619[var12 - 1] + ", " + var77 / 10 + var77 % 10 + "-" + class204.field2621[0][var14] + "-" + var79 + " " + var16 / 10 + var16 % 10 + ":" + var17 / 10 + var17 % 10 + ":" + var18 / 10 + var18 % 10 + " GMT";
                     var74 = var84 + var88 + "; Max-Age=" + 94608000L;
                  }

                  Client var94 = class23.clientInstance;
                  var88 = "document.cookie=\"" + var74 + "\"";
                  JSObject.getWindow(var94).eval(var88);
               } catch (Throwable var53) {
                  ;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2326 == var1.serverPacket) {
               if(GameEngine.clanMemberManager != null) {
                  GameEngine.clanMemberManager.method5459(var3);
               }

               field967 = cycleCntr;
               BoundingBox.field249 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2348 == var1.serverPacket) {
               World var65 = new World();
               var65.address = var3.readString();
               var65.id = var3.readUnsignedShort();
               var24 = var3.readInt();
               var65.mask = var24;
               class64.setGameState(45);
               var2.vmethod3331();
               var2 = null;
               class45.changeWorld(var65);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2372 == var1.serverPacket) {
               class57.method869(class183.field2494);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2302 == var1.serverPacket) {
               var23 = var3.method3556();
               var24 = var3.method3564();
               var25 = class44.getWidget(var24);
               if(var23 != var25.field2869 || var23 == -1) {
                  var25.field2869 = var23;
                  var25.field2935 = 0;
                  var25.field2945 = 0;
                  FontName.method5490(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2375 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var24 = var3.method3562();
               var25 = class44.getWidget(var24);
               if(var25 != null && var25.type == 0) {
                  if(var23 > var25.scrollHeight - var25.height) {
                     var23 = var25.scrollHeight - var25.height;
                  }

                  if(var23 < 0) {
                     var23 = 0;
                  }

                  if(var23 != var25.scrollY) {
                     var25.scrollY = var23;
                     FontName.method5490(var25);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2379 == var1.serverPacket) {
               var23 = var3.method3563();
               var24 = var3.readUnsignedShort();
               var25 = class44.getWidget(var23);
               if(var25.modelType != 2 || var24 != var25.modelId) {
                  var25.modelType = 2;
                  var25.modelId = var24;
                  FontName.method5490(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2314 == var1.serverPacket) {
               var23 = var3.readInt();
               var68 = class44.getWidget(var23);

               for(var6 = 0; var6 < var68.itemIds.length; ++var6) {
                  var68.itemIds[var6] = -1;
                  var68.itemIds[var6] = 0;
               }

               FontName.method5490(var68);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2311 == var1.serverPacket) {
               var23 = var3.method3554();
               byte var96 = var3.readByte();
               class237.serverVarps[var23] = var96;
               if(class237.clientVarps[var23] != var96) {
                  class237.clientVarps[var23] = var96;
               }

               class18.method142(var23);
               field984[++field1054 - 1 & 31] = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2340 == var1.serverPacket) {
               class250.method4503();
               energy = var3.readUnsignedByte();
               field1064 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            Widget var86;
            if(ServerPacket.field2305 == var1.serverPacket) {
               var23 = var3.method3563();
               var24 = var3.method3564();
               WidgetNode var85 = (WidgetNode)componentTable.get((long)var24);
               var7 = (WidgetNode)componentTable.get((long)var23);
               if(var7 != null) {
                  class57.closeWidget(var7, var85 == null || var7.id != var85.id);
               }

               if(var85 != null) {
                  var85.unlink();
                  componentTable.put(var85, (long)var23);
               }

               var86 = class44.getWidget(var24);
               if(var86 != null) {
                  FontName.method5490(var86);
               }

               var86 = class44.getWidget(var23);
               if(var86 != null) {
                  FontName.method5490(var86);
                  class86.method1889(MouseRecorder.widgets[var86.id >>> 16], var86, true);
               }

               if(widgetRoot != -1) {
                  DynamicObject.method2026(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            int var30;
            if(ServerPacket.field2310 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var24 += 32768;
               }

               if(var23 >= 0) {
                  var25 = class44.getWidget(var23);
               } else {
                  var25 = null;
               }

               if(var25 != null) {
                  for(var26 = 0; var26 < var25.itemIds.length; ++var26) {
                     var25.itemIds[var26] = 0;
                     var25.itemQuantities[var26] = 0;
                  }
               }

               ItemContainer var73 = (ItemContainer)ItemContainer.itemContainers.get((long)var24);
               if(var73 != null) {
                  for(var8 = 0; var8 < var73.itemIds.length; ++var8) {
                     var73.itemIds[var8] = -1;
                     var73.stackSizes[var8] = 0;
                  }
               }

               var26 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var26; ++var8) {
                  var27 = var3.method3538();
                  if(var27 == 255) {
                     var27 = var3.method3562();
                  }

                  var30 = var3.method3555();
                  if(var25 != null && var8 < var25.itemIds.length) {
                     var25.itemIds[var8] = var30;
                     var25.itemQuantities[var8] = var27;
                  }

                  Actor.setItemTableSlot(var24, var8, var30 - 1, var27);
               }

               if(var25 != null) {
                  FontName.method5490(var25);
               }

               class250.method4503();
               interfaceItemTriggers[++field1056 - 1 & 31] = var24 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2338 == var1.serverPacket) {
               var23 = var3.method3564();
               var24 = var3.method3555();
               var6 = var3.method3554();
               var70 = class44.getWidget(var23);
               var70.field2904 = var6 + (var24 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2359 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               if(var23 == 65535) {
                  var23 = -1;
               }

               if(var23 == -1 && !field1102) {
                  class155.method3165();
               } else if(var23 != -1 && var23 != field1026 && field996 != 0 && !field1102) {
                  class163.method3213(2, PacketBuffer.indexTrack1, var23, 0, field996, false);
               }

               field1026 = var23;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2378 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               if(var23 == 65535) {
                  var23 = -1;
               }

               var24 = var3.method3558();
               if(field996 != 0 && var23 != -1) {
                  PacketNode.method3442(class189.indexTrack2, var23, 0, field996, false);
                  field1102 = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2366 == var1.serverPacket) {
               if(var1.packetLength == 0) {
                  GameEngine.clanMemberManager = null;
               } else {
                  if(GameEngine.clanMemberManager == null) {
                     GameEngine.clanMemberManager = new ClanMemberManager(GZipDecompressor.loginType, class23.clientInstance);
                  }

                  GameEngine.clanMemberManager.method5469(var3);
               }

               field967 = cycleCntr;
               BoundingBox.field249 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2360 == var1.serverPacket) {
               var23 = var3.method3553();
               if(var23 == 65535) {
                  var23 = -1;
               }

               var24 = var3.method3563();
               var6 = var3.method3563();
               var70 = class44.getWidget(var6);
               ItemComposition var89;
               if(!var70.hasScript) {
                  if(var23 == -1) {
                     var70.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var89 = class47.getItemDefinition(var23);
                  var70.modelType = 4;
                  var70.modelId = var23;
                  var70.rotationX = var89.xan2d;
                  var70.rotationZ = var89.yan2d;
                  var70.modelZoom = var89.zoom2d * 100 / var24;
                  FontName.method5490(var70);
               } else {
                  var70.itemId = var23;
                  var70.itemQuantity = var24;
                  var89 = class47.getItemDefinition(var23);
                  var70.rotationX = var89.xan2d;
                  var70.rotationZ = var89.yan2d;
                  var70.rotationY = var89.zan2d;
                  var70.offsetX2d = var89.offsetX2d;
                  var70.offsetY2d = var89.offsetY2d;
                  var70.modelZoom = var89.zoom2d;
                  if(var89.isStackable == 1) {
                     var70.field2853 = 1;
                  } else {
                     var70.field2853 = 2;
                  }

                  if(var70.field2880 > 0) {
                     var70.modelZoom = var70.modelZoom * 32 / var70.field2880;
                  } else if(var70.originalWidth > 0) {
                     var70.modelZoom = var70.modelZoom * 32 / var70.originalWidth;
                  }

                  FontName.method5490(var70);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2377 == var1.serverPacket) {
               WorldMapRegion.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2303 == var1.serverPacket) {
               var23 = var1.packetLength;
               ClassInfo var67 = new ClassInfo();
               var67.count = var3.readUnsignedByte();
               var67.field3947 = var3.readInt();
               var67.type = new int[var67.count];
               var67.errorIdentifiers = new int[var67.count];
               var67.fields = new Field[var67.count];
               var67.field3951 = new int[var67.count];
               var67.methods = new Method[var67.count];
               var67.args = new byte[var67.count][][];

               for(var6 = 0; var6 < var67.count; ++var6) {
                  try {
                     var26 = var3.readUnsignedByte();
                     if(var26 != 0 && var26 != 1 && var26 != 2) {
                        if(var26 == 3 || var26 == 4) {
                           var84 = var3.readString();
                           var88 = var3.readString();
                           var30 = var3.readUnsignedByte();
                           String[] var75 = new String[var30];

                           for(var12 = 0; var12 < var30; ++var12) {
                              var75[var12] = var3.readString();
                           }

                           String var93 = var3.readString();
                           byte[][] var32 = new byte[var30][];
                           if(var26 == 3) {
                              for(var14 = 0; var14 < var30; ++var14) {
                                 var79 = var3.readInt();
                                 var32[var14] = new byte[var79];
                                 var3.readBytes(var32[var14], 0, var79);
                              }
                           }

                           var67.type[var6] = var26;
                           Class[] var97 = new Class[var30];

                           for(var79 = 0; var79 < var30; ++var79) {
                              var97[var79] = Name.loadClassFromDescriptor(var75[var79]);
                           }

                           Class var34 = Name.loadClassFromDescriptor(var93);
                           if(Name.loadClassFromDescriptor(var84).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var98 = Name.loadClassFromDescriptor(var84).getDeclaredMethods();
                           Method[] var99 = var98;

                           for(var18 = 0; var18 < var99.length; ++var18) {
                              Method var19 = var99[var18];
                              if(Reflection.getMethodName(var19).equals(var88)) {
                                 Class[] var20 = Reflection.getParameterTypes(var19);
                                 if(var97.length == var20.length) {
                                    boolean var21 = true;

                                    for(int var22 = 0; var22 < var97.length; ++var22) {
                                       if(var20[var22] != var97[var22]) {
                                          var21 = false;
                                          break;
                                       }
                                    }

                                    if(var21 && var34 == var19.getReturnType()) {
                                       var67.methods[var6] = var19;
                                    }
                                 }
                              }
                           }

                           var67.args[var6] = var32;
                        }
                     } else {
                        var84 = var3.readString();
                        var88 = var3.readString();
                        var30 = 0;
                        if(var26 == 1) {
                           var30 = var3.readInt();
                        }

                        var67.type[var6] = var26;
                        var67.field3951[var6] = var30;
                        if(Name.loadClassFromDescriptor(var84).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var67.fields[var6] = Reflection.findField(Name.loadClassFromDescriptor(var84), var88);
                     }
                  } catch (ClassNotFoundException var55) {
                     var67.errorIdentifiers[var6] = -1;
                  } catch (SecurityException var56) {
                     var67.errorIdentifiers[var6] = -2;
                  } catch (NullPointerException var57) {
                     var67.errorIdentifiers[var6] = -3;
                  } catch (Exception var58) {
                     var67.errorIdentifiers[var6] = -4;
                  } catch (Throwable var59) {
                     var67.errorIdentifiers[var6] = -5;
                  }
               }

               class326.classInfos.addFirst(var67);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2332 == var1.serverPacket) {
               var62 = var3.readString();
               var24 = var3.readInt();
               var25 = class44.getWidget(var24);
               if(!var62.equals(var25.text)) {
                  var25.text = var62;
                  FontName.method5490(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2374 == var1.serverPacket) {
               for(var23 = 0; var23 < class237.clientVarps.length; ++var23) {
                  if(class237.clientVarps[var23] != class237.serverVarps[var23]) {
                     class237.clientVarps[var23] = class237.serverVarps[var23];
                     class18.method142(var23);
                     field984[++field1054 - 1 & 31] = var23;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2334 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  class255.method4512(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2317 == var1.serverPacket) {
               class57.method869(class183.field2498);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2323 == var1.serverPacket) {
               class57.method869(class183.field2495);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2363 == var1.serverPacket) {
               var23 = var3.method3554();
               widgetRoot = var23;
               this.method1345(false);
               BoundingBox.method45(var23);
               class20.runWidgetOnLoadListener(widgetRoot);

               for(var24 = 0; var24 < 100; ++var24) {
                  field1072[var24] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2329 == var1.serverPacket) {
               class278.field3551 = var3.readUnsignedShortOb1();
               WidgetNode.field794 = var3.readUnsignedByte();

               for(var23 = WidgetNode.field794; var23 < WidgetNode.field794 + 8; ++var23) {
                  for(var24 = class278.field3551; var24 < class278.field3551 + 8; ++var24) {
                     if(groundItemDeque[BoundingBox3DDrawMode.plane][var23][var24] != null) {
                        groundItemDeque[BoundingBox3DDrawMode.plane][var23][var24] = null;
                        class18.groundItemSpawned(var23, var24);
                     }
                  }
               }

               for(PendingSpawn var63 = (PendingSpawn)pendingSpawns.getFront(); var63 != null; var63 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var63.x >= WidgetNode.field794 && var63.x < WidgetNode.field794 + 8 && var63.y >= class278.field3551 && var63.y < class278.field3551 + 8 && var63.level == BoundingBox3DDrawMode.plane) {
                     var63.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2367 == var1.serverPacket) {
               var81 = var3.method3524();
               if(var81) {
                  if(BaseVarType.field25 == null) {
                     BaseVarType.field25 = new class265();
                  }
               } else {
                  BaseVarType.field25 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2361 == var1.serverPacket) {
               class57.method869(class183.field2501);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2381 == var1.serverPacket) {
               class46.field579 = class1.method1(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2333 == var1.serverPacket) {
               var23 = var3.method3554();
               var24 = var3.method3554();
               var6 = var3.method3563();
               var26 = var3.method3554();
               var86 = class44.getWidget(var6);
               if(var23 != var86.rotationX || var26 != var86.rotationZ || var24 != var86.modelZoom) {
                  var86.rotationX = var23;
                  var86.rotationZ = var26;
                  var86.modelZoom = var24;
                  FontName.method5490(var86);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2336 == var1.serverPacket) {
               WorldMapRectangle.friendManager.method1734(var3, var1.packetLength);
               field1060 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2346 == var1.serverPacket) {
               WorldMapRegion.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2373 == var1.serverPacket) {
               class57.method869(class183.field2489);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2306 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var24 = var3.method3563();
               var6 = var23 >> 10 & 31;
               var26 = var23 >> 5 & 31;
               var8 = var23 & 31;
               var27 = (var26 << 11) + (var6 << 19) + (var8 << 3);
               Widget var101 = class44.getWidget(var24);
               if(var27 != var101.textColor) {
                  var101.textColor = var27;
                  FontName.method5490(var101);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2330 == var1.serverPacket) {
               var81 = var3.readUnsignedByte() == 1;
               if(var81) {
                  class71.field834 = class64.method1118() - var3.readLong();
                  class55.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  class55.grandExchangeEvents = null;
               }

               field1063 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            String var36;
            long var38;
            long var40;
            if(ServerPacket.field2339 == var1.serverPacket) {
               var62 = var3.readString();
               var38 = (long)var3.readUnsignedShort();
               var40 = (long)var3.read24BitInt();
               Permission[] var87 = new Permission[]{Permission.field3345, Permission.field3344, Permission.field3346, Permission.field3349, Permission.field3350, Permission.field3347};
               Permission var100 = (Permission)Permission.forOrdinal(var87, var3.readUnsignedByte());
               long var42 = var40 + (var38 << 32);
               boolean var13 = false;

               for(var14 = 0; var14 < 100; ++var14) {
                  if(field1077[var14] == var42) {
                     var13 = true;
                     break;
                  }
               }

               if(WorldMapRectangle.friendManager.isIgnored(new Name(var62, GZipDecompressor.loginType))) {
                  var13 = true;
               }

               if(!var13 && myPlayerIndex == 0) {
                  field1077[field1087] = var42;
                  field1087 = (field1087 + 1) % 100;
                  String var33 = FontTypeFace.appendTags(class303.method5406(WallObject.method3061(var3)));
                  byte var78;
                  if(var100.field3351) {
                     var78 = 7;
                  } else {
                     var78 = 3;
                  }

                  if(var100.field3348 != -1) {
                     var18 = var100.field3348;
                     var36 = "<img=" + var18 + ">";
                     class57.sendGameMessage(var78, var36 + var62, var33);
                  } else {
                     class57.sendGameMessage(var78, var62, var33);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2324 == var1.serverPacket) {
               var23 = var3.method3554();
               var24 = var3.method3563();
               var25 = class44.getWidget(var24);
               if(var25.modelType != 1 || var23 != var25.modelId) {
                  var25.modelType = 1;
                  var25.modelId = var23;
                  FontName.method5490(var25);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2341 == var1.serverPacket) {
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
                  hintArrowOffsetZ = var3.readUnsignedByte();
               }

               if(hintArrowTargetType == 10) {
                  hintArrowPlayerTargetIdx = var3.readUnsignedShort();
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2300 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  DynamicObject.method2026(widgetRoot, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2347 == var1.serverPacket) {
               var23 = var3.method3555();
               ItemContainer var66 = (ItemContainer)ItemContainer.itemContainers.get((long)var23);
               if(var66 != null) {
                  var66.unlink();
               }

               interfaceItemTriggers[++field1056 - 1 & 31] = var23 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2351 == var1.serverPacket) {
               var62 = var3.readString();
               var5 = FontTypeFace.appendTags(class303.method5406(WallObject.method3061(var3)));
               class57.sendGameMessage(6, var62, var5);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2376 == var1.serverPacket) {
               var23 = var3.getUSmart();
               boolean var82 = var3.readUnsignedByte() == 1;
               var80 = "";
               boolean var90 = false;
               if(var82) {
                  var80 = var3.readString();
                  if(WorldMapRectangle.friendManager.isIgnored(new Name(var80, GZipDecompressor.loginType))) {
                     var90 = true;
                  }
               }

               var84 = var3.readString();
               if(!var90) {
                  class57.sendGameMessage(var23, var80, var84);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2321 == var1.serverPacket) {
               WorldMapRectangle.friendManager.field1254.method5294(var3, var1.packetLength);
               class197.method3746();
               field1060 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2345 == var1.serverPacket) {
               field1111 = true;
               HorizontalAlignment.field3697 = var3.readUnsignedByte();
               BoundingBox2D.field248 = var3.readUnsignedByte();
               Signlink.field2217 = var3.readUnsignedShort();
               TotalQuantityComparator.field302 = var3.readUnsignedByte();
               ScriptVarType.field230 = var3.readUnsignedByte();
               if(ScriptVarType.field230 >= 100) {
                  var23 = HorizontalAlignment.field3697 * 128 + 64;
                  var24 = BoundingBox2D.field248 * 128 + 64;
                  var6 = class265.getTileHeight(var23, var24, BoundingBox3DDrawMode.plane) - Signlink.field2217;
                  var26 = var23 - Player.cameraX;
                  var8 = var6 - GameObject.cameraZ;
                  var27 = var24 - class20.cameraY;
                  var30 = (int)Math.sqrt((double)(var26 * var26 + var27 * var27));
                  GrandExchangeOffer.cameraPitch = (int)(Math.atan2((double)var8, (double)var30) * 325.949D) & 2047;
                  class28.cameraYaw = (int)(Math.atan2((double)var26, (double)var27) * -325.949D) & 2047;
                  if(GrandExchangeOffer.cameraPitch < 128) {
                     GrandExchangeOffer.cameraPitch = 128;
                  }

                  if(GrandExchangeOffer.cameraPitch > 383) {
                     GrandExchangeOffer.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2315 == var1.serverPacket) {
               for(var23 = 0; var23 < class289.field3777; ++var23) {
                  VarPlayerType var64 = class150.method3119(var23);
                  if(var64 != null) {
                     class237.serverVarps[var23] = 0;
                     class237.clientVarps[var23] = 0;
                  }
               }

               class250.method4503();
               field1054 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2319 == var1.serverPacket) {
               var62 = var3.readString();
               var38 = var3.readLong();
               var40 = (long)var3.readUnsignedShort();
               var9 = (long)var3.read24BitInt();
               Permission[] var11 = new Permission[]{Permission.field3345, Permission.field3344, Permission.field3346, Permission.field3349, Permission.field3350, Permission.field3347};
               Permission var31 = (Permission)Permission.forOrdinal(var11, var3.readUnsignedByte());
               long var44 = var9 + (var40 << 32);
               boolean var15 = false;

               for(var16 = 0; var16 < 100; ++var16) {
                  if(var44 == field1077[var16]) {
                     var15 = true;
                     break;
                  }
               }

               if(var31.field3352 && WorldMapRectangle.friendManager.isIgnored(new Name(var62, GZipDecompressor.loginType))) {
                  var15 = true;
               }

               if(!var15 && myPlayerIndex == 0) {
                  field1077[field1087] = var44;
                  field1087 = (field1087 + 1) % 100;
                  String var35 = FontTypeFace.appendTags(class303.method5406(WallObject.method3061(var3)));
                  if(var31.field3348 != -1) {
                     var18 = var31.field3348;
                     var36 = "<img=" + var18 + ">";
                     class20.addChatMessage(9, var36 + var62, var35, class252.method4505(var38));
                  } else {
                     class20.addChatMessage(9, var62, var35, class252.method4505(var38));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2309 == var1.serverPacket) {
               var23 = var3.readUnsignedByte();
               var24 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var26 = var3.readUnsignedByte();
               field955[var23] = true;
               field942[var23] = var24;
               field1006[var23] = var6;
               field939[var23] = var26;
               field1116[var23] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2362 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readUnsignedShort();
               if(var23 < -70000) {
                  var24 += 32768;
               }

               if(var23 >= 0) {
                  var25 = class44.getWidget(var23);
               } else {
                  var25 = null;
               }

               for(; var3.offset < var1.packetLength; Actor.setItemTableSlot(var24, var26, var8 - 1, var27)) {
                  var26 = var3.getUSmart();
                  var8 = var3.readUnsignedShort();
                  var27 = 0;
                  if(var8 != 0) {
                     var27 = var3.readUnsignedByte();
                     if(var27 == 255) {
                        var27 = var3.readInt();
                     }
                  }

                  if(var25 != null && var26 >= 0 && var26 < var25.itemIds.length) {
                     var25.itemIds[var26] = var8;
                     var25.itemQuantities[var26] = var27;
                  }
               }

               if(var25 != null) {
                  FontName.method5490(var25);
               }

               class250.method4503();
               interfaceItemTriggers[++field1056 - 1 & 31] = var24 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2304 == var1.serverPacket) {
               class57.method869(class183.field2497);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2357 == var1.serverPacket) {
               field1111 = true;
               ScriptState.field755 = var3.readUnsignedByte();
               class37.field497 = var3.readUnsignedByte();
               Renderable.field2051 = var3.readUnsignedShort();
               class28.field416 = var3.readUnsignedByte();
               class255.field3331 = var3.readUnsignedByte();
               if(class255.field3331 >= 100) {
                  Player.cameraX = ScriptState.field755 * 128 + 64;
                  class20.cameraY = class37.field497 * 128 + 64;
                  GameObject.cameraZ = class265.getTileHeight(Player.cameraX, class20.cameraY, BoundingBox3DDrawMode.plane) - Renderable.field2051;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2353 == var1.serverPacket) {
               var23 = var3.readUnsignedShort();
               var24 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               if(field1075 != 0 && var24 != 0 && queuedSoundEffectCount < 50) {
                  queuedSoundEffectIDs[queuedSoundEffectCount] = var23;
                  unknownSoundValues1[queuedSoundEffectCount] = var24;
                  unknownSoundValues2[queuedSoundEffectCount] = var6;
                  audioEffects[queuedSoundEffectCount] = null;
                  soundLocations[queuedSoundEffectCount] = 0;
                  ++queuedSoundEffectCount;
               }

               var1.serverPacket = null;
               return true;
            }

            long var47;
            if(ServerPacket.field2380 == var1.serverPacket) {
               var23 = var3.offset + var1.packetLength;
               var24 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var24 != widgetRoot) {
                  widgetRoot = var24;
                  this.method1345(false);
                  BoundingBox.method45(widgetRoot);
                  class20.runWidgetOnLoadListener(widgetRoot);

                  for(var26 = 0; var26 < 100; ++var26) {
                     field1072[var26] = true;
                  }
               }

               WidgetNode var37;
               for(; var6-- > 0; var37.field793 = true) {
                  var26 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var27 = var3.readUnsignedByte();
                  var37 = (WidgetNode)componentTable.get((long)var26);
                  if(var37 != null && var8 != var37.id) {
                     class57.closeWidget(var37, true);
                     var37 = null;
                  }

                  if(var37 == null) {
                     var37 = FileSystem.method4523(var26, var8, var27);
                  }
               }

               for(var7 = (WidgetNode)componentTable.first(); var7 != null; var7 = (WidgetNode)componentTable.next()) {
                  if(var7.field793) {
                     var7.field793 = false;
                  } else {
                     class57.closeWidget(var7, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var23) {
                  var26 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var27 = var3.readUnsignedShort();
                  var30 = var3.readInt();

                  for(int var46 = var8; var46 <= var27; ++var46) {
                     var47 = ((long)var26 << 32) + (long)var46;
                     widgetFlags.put(new IntegerNode(var30), var47);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2328 == var1.serverPacket) {
               class57.method869(class183.field2492);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2356 == var1.serverPacket) {
               var23 = var3.readInt();
               var24 = var3.readInt();
               var26 = 0;
               if(IndexStoreActionHandler.field3402 == null || !IndexStoreActionHandler.field3402.isValid()) {
                  try {
                     Iterator var28 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var28.hasNext()) {
                        GarbageCollectorMXBean var29 = (GarbageCollectorMXBean)var28.next();
                        if(var29.isValid()) {
                           IndexStoreActionHandler.field3402 = var29;
                           GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                           GameEngine.garbageCollectorLastCollectionTime = -1L;
                        }
                     }
                  } catch (Throwable var54) {
                     ;
                  }
               }

               if(IndexStoreActionHandler.field3402 != null) {
                  long var49 = class64.method1118();
                  var10 = IndexStoreActionHandler.field3402.getCollectionTime();
                  if(-1L != GameEngine.garbageCollectorLastCollectionTime) {
                     var47 = var10 - GameEngine.garbageCollectorLastCollectionTime;
                     long var51 = var49 - GameEngine.garbageCollectorLastCheckTimeMs;
                     if(var51 != 0L) {
                        var26 = (int)(100L * var47 / var51);
                     }
                  }

                  GameEngine.garbageCollectorLastCollectionTime = var10;
                  GameEngine.garbageCollectorLastCheckTimeMs = var49;
               }

               PacketNode var83 = WorldMapRectangle.method280(ClientPacket.field2411, field957.field1484);
               var83.packetBuffer.putByte(GameEngine.FPS);
               var83.packetBuffer.method3559(var23);
               var83.packetBuffer.putInt(var24);
               var83.packetBuffer.method3543(var26);
               field957.method2052(var83);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2349 == var1.serverPacket) {
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

            if(ServerPacket.field2301 == var1.serverPacket) {
               WorldMapRectangle.friendManager.method1733();
               field1060 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2325 == var1.serverPacket) {
               VarPlayerType.method4736();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2352 == var1.serverPacket) {
               class250.method4503();
               weight = var3.readShort();
               field1064 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               class250.method4503();
               var23 = var3.method3562();
               var24 = var3.method3538();
               var6 = var3.method3636();
               skillExperiences[var24] = var23;
               boostedSkillLevels[var24] = var6;
               realSkillLevels[var24] = 1;

               for(var26 = 0; var26 < 98; ++var26) {
                  if(var23 >= class248.field3012[var26]) {
                     realSkillLevels[var24] = var26 + 2;
                  }
               }

               field1057[++field1052 - 1 & 31] = var24;
               var1.serverPacket = null;
               return true;
            }

            AttackOption.processClientError("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1492 != null?var1.field1492.packetId:-1) + "," + (var1.field1493 != null?var1.field1493.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            VarPlayerType.method4736();
         } catch (IOException var60) {
            if(field915 > 0) {
               VarPlayerType.method4736();
            } else {
               field918.method5211();
               class64.setGameState(40);
               FaceNormal.field2069 = field957.getSocket();
               field957.method2043();
            }
         } catch (Exception var61) {
            var5 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1492 != null?var1.field1492.packetId:-1) + "," + (var1.field1493 != null?var1.field1493.packetId:-1) + "," + var1.packetLength + "," + (SoundTaskDataProvider.localPlayer.pathX[0] + class138.baseX) + "," + (SoundTaskDataProvider.localPlayer.pathY[0] + class23.baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var5 = var5 + var3.payload[var6] + ",";
            }

            AttackOption.processClientError(var5, var61);
            VarPlayerType.method4736();
         }

         return true;
      }
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1146828755"
   )
   final void method1446() {
      WidgetNode.method1133();
      if(UrlRequest.field2137 == null) {
         if(draggedWidget == null) {
            int var1 = MouseInput.mouseLastButton;
            int var2;
            int var4;
            int var5;
            int var6;
            int var9;
            if(isMenuOpen) {
               int var3;
               if(var1 != 1 && (MapIconReference.middleMouseMovesCamera || var1 != 4)) {
                  var2 = MouseInput.mouseLastX;
                  var3 = MouseInput.mouseLastY;
                  if(var2 < class55.menuX - 10 || var2 > class55.menuX + class245.field2975 + 10 || var3 < ScriptState.menuY - 10 || var3 > ScriptState.menuY + Script.field1455 + 10) {
                     isMenuOpen = false;
                     MapLabel.method411(class55.menuX, ScriptState.menuY, class245.field2975, Script.field1455);
                  }
               }

               if(var1 == 1 || !MapIconReference.middleMouseMovesCamera && var1 == 4) {
                  var2 = class55.menuX;
                  var3 = ScriptState.menuY;
                  var4 = class245.field2975;
                  var5 = MouseInput.mouseLastPressedX;
                  var6 = MouseInput.mouseLastPressedY;
                  int var7 = -1;

                  for(int var14 = 0; var14 < menuOptionCount; ++var14) {
                     var9 = (menuOptionCount - 1 - var14) * 15 + var3 + 31;
                     if(var5 > var2 && var5 < var4 + var2 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var7 = var14;
                     }
                  }

                  if(var7 != -1) {
                     class178.method3432(var7);
                  }

                  isMenuOpen = false;
                  MapLabel.method411(class55.menuX, ScriptState.menuY, class245.field2975, Script.field1455);
               }
            } else {
               var2 = menuOptionCount - 1;
               if((var1 == 1 || !MapIconReference.middleMouseMovesCamera && var1 == 4) && var2 >= 0) {
                  var4 = menuTypes[var2];
                  if(var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                     label255: {
                        var5 = menuActionParams0[var2];
                        var6 = menuActionParams1[var2];
                        Widget var13 = class44.getWidget(var6);
                        var9 = GroundObject.getWidgetClickMask(var13);
                        boolean var8 = (var9 >> 28 & 1) != 0;
                        int var11;
                        if(!var8) {
                           var11 = GroundObject.getWidgetClickMask(var13);
                           boolean var10 = (var11 >> 29 & 1) != 0;
                           if(!var10) {
                              break label255;
                           }
                        }

                        if(UrlRequest.field2137 != null && !field1051 && menuOptionCount > 0 && !this.method1267()) {
                           int var15 = field978;
                           var11 = field912;
                           ContextMenuRow var12 = Projectile.topContextMenuRow;
                           PacketBuffer.menuAction(var12.param0, var12.param1, var12.type, var12.identifier, var12.option, var12.option, var15, var11);
                           Projectile.topContextMenuRow = null;
                        }

                        field1051 = false;
                        itemPressedDuration = 0;
                        if(UrlRequest.field2137 != null) {
                           FontName.method5490(UrlRequest.field2137);
                        }

                        UrlRequest.field2137 = class44.getWidget(var6);
                        field977 = var5;
                        field978 = MouseInput.mouseLastPressedX;
                        field912 = MouseInput.mouseLastPressedY;
                        if(var2 >= 0) {
                           class22.method184(var2);
                        }

                        FontName.method5490(UrlRequest.field2137);
                        return;
                     }
                  }
               }

               if((var1 == 1 || !MapIconReference.middleMouseMovesCamera && var1 == 4) && this.method1267()) {
                  var1 = 2;
               }

               if((var1 == 1 || !MapIconReference.middleMouseMovesCamera && var1 == 4) && menuOptionCount > 0) {
                  class178.method3432(var2);
               }

               if(var1 == 2 && menuOptionCount > 0) {
                  this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
               }
            }

         }
      }
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "95"
   )
   final boolean method1267() {
      int var1 = menuOptionCount - 1;
      boolean var3 = field1004 == 1 && menuOptionCount > 2;
      if(!var3) {
         boolean var4;
         if(var1 < 0) {
            var4 = false;
         } else {
            int var5 = menuTypes[var1];
            if(var5 >= 2000) {
               var5 -= 2000;
            }

            if(var5 == 1007) {
               var4 = true;
            } else {
               var4 = false;
            }
         }

         var3 = var4;
      }

      return var3 && !menuBooleanArray[var1];
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1938426547"
   )
   @Export("openMenu")
   @Hook("menuOpened")
   final void openMenu(int var1, int var2) {
      int var3 = MessageNode.fontBold12.getTextWidth("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = MessageNode.fontBold12;
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
      if(var8 + var3 > MapLabel.canvasWidth) {
         var8 = MapLabel.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var2 + var4 > FloorUnderlayDefinition.canvasHeight) {
         var9 = FloorUnderlayDefinition.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      class255.region.method2889(BoundingBox3DDrawMode.plane, var1, var2, false);
      isMenuOpen = true;
      class55.menuX = var8;
      ScriptState.menuY = var9;
      class245.field2975 = var3;
      Script.field1455 = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1588895343"
   )
   final void method1345(boolean var1) {
      class44.method666(widgetRoot, MapLabel.canvasWidth, FloorUnderlayDefinition.canvasHeight, var1);
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(Lin;I)V",
      garbageValue = "1206972143"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class44.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = MapLabel.canvasWidth;
         var4 = FloorUnderlayDefinition.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      BoundingBox3D.method48(var1, var3, var4, false);
      BoundingBox3D.method52(var1, var3, var4);
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1136926244"
   )
   final void method1271() {
      FontName.method5490(draggedWidget);
      ++class55.field660;
      if(field958 && field1053) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field1042;
         var2 -= field1114;
         if(var1 < field1008) {
            var1 = field1008;
         }

         if(var1 + draggedWidget.width > field1008 + field937.width) {
            var1 = field1008 + field937.width - draggedWidget.width;
         }

         if(var2 < field1047) {
            var2 = field1047;
         }

         if(var2 + draggedWidget.height > field1047 + field937.height) {
            var2 = field1047 + field937.height - draggedWidget.height;
         }

         int var3 = var1 - field1049;
         int var4 = var2 - field882;
         int var5 = draggedWidget.dragDeadZone;
         if(class55.field660 > draggedWidget.dragDeadTime && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            draggingWidget = true;
         }

         int var6 = var1 - field1008 + field937.scrollX;
         int var7 = var2 - field1047 + field937.scrollY;
         ScriptEvent var8;
         if(draggedWidget.onDragListener != null && draggingWidget) {
            var8 = new ScriptEvent();
            var8.widget = draggedWidget;
            var8.field799 = var6;
            var8.field798 = var7;
            var8.objs = draggedWidget.onDragListener;
            AbstractSoundSystem.method2256(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(draggingWidget) {
               if(draggedWidget.onDragCompleteListener != null) {
                  var8 = new ScriptEvent();
                  var8.widget = draggedWidget;
                  var8.field799 = var6;
                  var8.field798 = var7;
                  var8.field802 = draggedOnWidget;
                  var8.objs = draggedWidget.onDragCompleteListener;
                  AbstractSoundSystem.method2256(var8);
               }

               if(draggedOnWidget != null && class265.method4692(draggedWidget) != null) {
                  PacketNode var12 = WorldMapRectangle.method280(ClientPacket.field2465, field957.field1484);
                  var12.packetBuffer.putShort(draggedOnWidget.itemId);
                  var12.packetBuffer.method3528(draggedOnWidget.index);
                  var12.packetBuffer.method3550(draggedWidget.index);
                  var12.packetBuffer.putInt(draggedWidget.id);
                  var12.packetBuffer.putShort(draggedWidget.itemId);
                  var12.packetBuffer.method3552(draggedOnWidget.id);
                  field957.method2052(var12);
               }
            } else if(this.method1267()) {
               this.openMenu(field1042 + field1049, field1114 + field882);
            } else if(menuOptionCount > 0) {
               int var11 = field1049 + field1042;
               int var9 = field882 + field1114;
               ContextMenuRow var10 = Projectile.topContextMenuRow;
               PacketBuffer.menuAction(var10.param0, var10.param1, var10.type, var10.identifier, var10.option, var10.option, var11, var9);
               Projectile.topContextMenuRow = null;
            }

            draggedWidget = null;
         }

      } else {
         if(class55.field660 > 1) {
            draggedWidget = null;
         }

      }
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(B)Lkz;",
      garbageValue = "2"
   )
   public Name vmethod5404() {
      return SoundTaskDataProvider.localPlayer != null?SoundTaskDataProvider.localPlayer.name:null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "-22"
   )
   @Export("charToByteCp1252")
   public static byte charToByteCp1252(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lbg;Lbg;IZIZI)I",
      garbageValue = "1312492053"
   )
   static int method1503(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = ScriptState.method1110(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = ScriptState.method1110(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
