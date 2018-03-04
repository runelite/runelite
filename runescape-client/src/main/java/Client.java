import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
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

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements class302 {
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = -1121906083
   )
   static int field1052;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = -247673825
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      longValue = -2644665517797494299L
   )
   static long field1061;
   @ObfuscatedName("ov")
   static boolean field970;
   @ObfuscatedName("mz")
   static boolean[] field1053;
   @ObfuscatedName("nv")
   static boolean[] field1043;
   @ObfuscatedName("nh")
   static boolean[] field1055;
   @ObfuscatedName("ns")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 2138792525
   )
   static int field1041;
   @ObfuscatedName("rd")
   @ObfuscatedGetter(
      intValue = 1229010799
   )
   public static int field1116;
   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -61783445
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("nz")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("nn")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("nt")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("nx")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 969423133
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("rz")
   @ObfuscatedSignature(
      signature = "Lba;"
   )
   static final class71 field1119;
   @ObfuscatedName("mt")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   static Deque field1047;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = -1444080179
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -1674426437
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("pd")
   static boolean field1092;
   @ObfuscatedName("mc")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 401586351
   )
   static int field1037;
   @ObfuscatedName("pz")
   static boolean[] field1093;
   @ObfuscatedName("mm")
   static int[] field1054;
   @ObfuscatedName("mg")
   @ObfuscatedGetter(
      intValue = 1187231345
   )
   static int field1112;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 1097011183
   )
   static int field911;
   @ObfuscatedName("rp")
   static int[] field1095;
   @ObfuscatedName("rf")
   static int[] field1121;
   @ObfuscatedName("rx")
   static ArrayList field1117;
   @ObfuscatedName("ru")
   @ObfuscatedGetter(
      intValue = 599877771
   )
   static int field1118;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 1064618259
   )
   static int field1044;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 47080309
   )
   static int field1073;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -422675999
   )
   static int field967;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      longValue = 8776726934747110893L
   )
   static long field1072;
   @ObfuscatedName("qs")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static PlayerComposition field1009;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = 887115417
   )
   @Export("queuedSoundEffectCount")
   static int queuedSoundEffectCount;
   @ObfuscatedName("py")
   @Export("unknownSoundValues2")
   static int[] unknownSoundValues2;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -1508842935
   )
   static int field1113;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -176496437
   )
   static int field981;
   @ObfuscatedName("pm")
   @ObfuscatedSignature(
      signature = "[Lcv;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 2060864557
   )
   static int field1115;
   @ObfuscatedName("pj")
   static int[] field995;
   @ObfuscatedName("pp")
   @Export("queuedSoundEffectIDs")
   static int[] queuedSoundEffectIDs;
   @ObfuscatedName("pb")
   static int[] field894;
   @ObfuscatedName("pk")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("pv")
   static int[] field903;
   @ObfuscatedName("pr")
   static int[] field1091;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -1009326595
   )
   static int field1084;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 1544302249
   )
   static int field1080;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 752102131
   )
   static int field1006;
   @ObfuscatedName("po")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("on")
   @ObfuscatedSignature(
      signature = "[Lly;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -448653085
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("oq")
   static int[] field1075;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 426050153
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 496229549
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -1882402985
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("oa")
   static int[] field1064;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = -726487731
   )
   static int field980;
   @ObfuscatedName("mn")
   static int[] field1038;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = -1186610307
   )
   static int field1039;
   @ObfuscatedName("os")
   static int[] field1071;
   @ObfuscatedName("ma")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   static Deque field1018;
   @ObfuscatedName("ne")
   static int[] field1070;
   @ObfuscatedName("mx")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   static Deque field977;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 742316243
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -390982361
   )
   static int field1065;
   @ObfuscatedName("qp")
   static short field1099;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -923069533
   )
   static int field1035;
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "[Lv;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("qy")
   static short field871;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 1684799051
   )
   static int field1045;
   @ObfuscatedName("qv")
   static short field1104;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1380282537
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("qi")
   static short field992;
   @ObfuscatedName("qw")
   static short field860;
   @ObfuscatedName("qo")
   static short field1100;
   @ObfuscatedName("qg")
   static short field1101;
   @ObfuscatedName("qa")
   static short field893;
   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "Lbp;"
   )
   static OwnWorldComparator field858;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 799532677
   )
   static int field944;
   @ObfuscatedName("ni")
   static String field1066;
   @ObfuscatedName("no")
   static long[] field1067;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = -1097183903
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("nr")
   static int[] field1063;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = 1982864483
   )
   static int field921;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfb;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("av")
   static boolean field878;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 571815617
   )
   @Export("world")
   public static int world;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -450010715
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -646271015
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bz")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bt")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 614229017
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 700797113
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("bw")
   static boolean field1068;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -674094647
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      longValue = -5935186538508849677L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1560826979
   )
   static int field910;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -946326719
   )
   static int field868;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 429912853
   )
   static int field869;
   @ObfuscatedName("bp")
   static boolean field864;
   @ObfuscatedName("bh")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1817964279
   )
   static int field1069;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 194337049
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 165246831
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 705546823
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1940372867
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 2136534851
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 266689881
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1500973717
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -31147613
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1361950867
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 2061960199
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 965011081
   )
   static int field873;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -837361783
   )
   static int field887;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 1982635111
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1678029847
   )
   static int field1076;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1473097477
   )
   static int field890;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = -593937291
   )
   static int field891;
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   static class158 field1040;
   @ObfuscatedName("di")
   static byte[] field889;
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "[Lcu;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -336597611
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("du")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 315552265
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ew")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Lcb;"
   )
   public static final NetWriter field899;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = -1451910987
   )
   static int field886;
   @ObfuscatedName("ej")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ec")
   static boolean field902;
   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static class294 field1077;
   @ObfuscatedName("ea")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 1322157629
   )
   static int field1105;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -763442161
   )
   static int field906;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -452624307
   )
   static int field907;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -297454021
   )
   static int field908;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -353659151
   )
   static int field909;
   @ObfuscatedName("fs")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fm")
   @Export("instanceTemplateChunks")
   static int[][][] instanceTemplateChunks;
   @ObfuscatedName("fa")
   static final int[] field913;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 307086543
   )
   static int field914;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -1437404305
   )
   static int field989;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = -1043358665
   )
   static int field916;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 1961018695
   )
   static int field917;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 2014788965
   )
   static int field955;
   @ObfuscatedName("gl")
   static boolean field1024;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 1915094439
   )
   static int field920;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 2110224621
   )
   @Export("cameraPitchTarget")
   static int cameraPitchTarget;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -623844995
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = -1651231081
   )
   static int field923;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -2118364207
   )
   static int field1096;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1769689399
   )
   static int field925;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1825430997
   )
   static int field926;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 109160909
   )
   static int field927;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -2009981115
   )
   static int field928;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1344645885
   )
   static int field892;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -903226217
   )
   static int field897;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -308080529
   )
   static int field931;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -1639951869
   )
   static int field932;
   @ObfuscatedName("hq")
   static boolean field933;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -1366842105
   )
   static int field934;
   @ObfuscatedName("hb")
   static boolean field1120;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -1625186359
   )
   static int field936;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -592663975
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -165354753
   )
   static int field938;
   @ObfuscatedName("he")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("hs")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("ho")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("hv")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("hu")
   static int[] field943;
   @ObfuscatedName("hf")
   static int[] field915;
   @ObfuscatedName("hh")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("ha")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("hx")
   static int[][] field947;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = -814642373
   )
   static int field1108;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1783477777
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 988896427
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 1928717177
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 58351901
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 1006637669
   )
   static int field953;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 1467863909
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("hl")
   static boolean field978;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -1612333871
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1025434537
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -1097688065
   )
   static int field958;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 1118506659
   )
   static int field1048;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -573326245
   )
   static int field960;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 333580237
   )
   static int field918;
   @ObfuscatedName("in")
   static boolean field962;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 403251557
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 365627069
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("im")
   static boolean field965;
   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "[Lbd;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -209144053
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -469533573
   )
   static int field968;
   @ObfuscatedName("iv")
   static boolean field969;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -1813777241
   )
   static int field988;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 779860609
   )
   static int field998;
   @ObfuscatedName("jk")
   static int[] field972;
   @ObfuscatedName("js")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("jv")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("jj")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("jh")
   static int[] field976;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -397406633
   )
   static int field1103;
   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "[[[Lhv;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("jq")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jy")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("je")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 636345983
   )
   static int field924;
   @ObfuscatedName("jl")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = 1229401137
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("jx")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jz")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("jg")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("kg")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("ki")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("kk")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("kc")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("ka")
   static boolean field937;
   @ObfuscatedName("kh")
   static boolean field996;
   @ObfuscatedName("kt")
   static boolean field997;
   @ObfuscatedName("ky")
   static boolean field1049;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -90778099
   )
   static int field999;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 1083472731
   )
   static int field919;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 374886871
   )
   static int field1001;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 523893645
   )
   static int field1002;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 2002092583
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("kv")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -1964763335
   )
   static int field1042;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 704458777
   )
   static int field1007;
   @ObfuscatedName("kr")
   static String field1097;
   @ObfuscatedName("kp")
   static String field941;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -651070067
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lk")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 793717051
   )
   static int field1012;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -915994813
   )
   static int field1013;
   @ObfuscatedName("ld")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field1014;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -1918027401
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -969727081
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -68758579
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = -203788091
   )
   static int field1008;
   @ObfuscatedName("lh")
   static boolean field1019;
   @ObfuscatedName("ll")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field1020;
   @ObfuscatedName("lm")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field1021;
   @ObfuscatedName("lj")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field1022;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -126888287
   )
   static int field1023;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 1788967577
   )
   static int field1056;
   @ObfuscatedName("lx")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field1025;
   @ObfuscatedName("lc")
   static boolean field1026;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -529452835
   )
   static int field1027;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = -259314651
   )
   static int field1028;
   @ObfuscatedName("lv")
   static boolean field1029;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1061949259
   )
   static int field945;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 609145999
   )
   static int field1031;
   @ObfuscatedName("ls")
   static boolean field1032;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 1667334939
   )
   @Export("cycleCntr")
   static int cycleCntr;

   static {
      field878 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field1068 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = -1L;
      field910 = -1;
      field868 = -1;
      field869 = -1;
      field864 = true;
      displayFps = false;
      field1069 = 0;
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
      field873 = 0;
      field887 = 0;
      loginState = 0;
      field1076 = 0;
      field890 = 0;
      field891 = 0;
      field1040 = class158.field2145;
      field889 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field899 = new NetWriter();
      field886 = 0;
      socketError = false;
      field902 = true;
      field1077 = new class294();
      fontsMap = new HashMap();
      field1105 = 0;
      field906 = 1;
      field907 = 0;
      field908 = 1;
      field909 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      instanceTemplateChunks = new int[4][13][13];
      field913 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field914 = 0;
      field989 = 2301979;
      field916 = 5063219;
      field917 = 3353893;
      field955 = 7759444;
      field1024 = false;
      field920 = 0;
      cameraPitchTarget = 128;
      mapAngle = 0;
      field923 = 0;
      field1096 = 0;
      field925 = 0;
      field926 = 0;
      field927 = 0;
      field928 = 50;
      field892 = 0;
      field897 = 0;
      field931 = 0;
      field932 = 0;
      field933 = false;
      field934 = 0;
      field1120 = false;
      field936 = 0;
      overheadTextCount = 0;
      field938 = 50;
      overheadTextsX = new int[field938];
      overheadTextsY = new int[field938];
      overheadTextsOffsetY = new int[field938];
      overheadTextsOffsetX = new int[field938];
      field943 = new int[field938];
      field915 = new int[field938];
      overheadTextsCyclesRemaining = new int[field938];
      overheadTexts = new String[field938];
      field947 = new int[104][104];
      field1108 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field953 = 0;
      cursorState = 0;
      field978 = true;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field958 = 0;
      field1048 = 0;
      field960 = 0;
      field918 = 0;
      field962 = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      field965 = true;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field968 = 0;
      field969 = true;
      field988 = 0;
      field998 = 0;
      field972 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field976 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1103 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field924 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field937 = false;
      field996 = false;
      field997 = false;
      field1049 = true;
      field999 = -1;
      field919 = -1;
      field1001 = 0;
      field1002 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field1042 = -1;
      field1007 = -1;
      field1097 = null;
      field941 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1012 = 0;
      field1013 = 0;
      field1014 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1008 = -1;
      field1019 = false;
      field1020 = null;
      field1021 = null;
      field1022 = null;
      field1023 = 0;
      field1056 = 0;
      field1025 = null;
      field1026 = false;
      field1027 = -1;
      field1028 = -1;
      field1029 = false;
      field945 = -1;
      field1031 = -1;
      field1032 = false;
      cycleCntr = 1;
      field1054 = new int[32];
      field1112 = 0;
      interfaceItemTriggers = new int[32];
      field1037 = 0;
      field1038 = new int[32];
      field1039 = 0;
      chatCycle = 0;
      field1041 = 0;
      field1035 = 0;
      field944 = 0;
      field1044 = 0;
      field1045 = 0;
      mouseWheelRotation = 0;
      field1047 = new Deque();
      field1018 = new Deque();
      field977 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field1052 = -2;
      field1053 = new boolean[100];
      field1043 = new boolean[100];
      field1055 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1061 = 0L;
      isResized = true;
      field1063 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field1065 = 0;
      field1066 = "";
      field1067 = new long[100];
      field921 = 0;
      field980 = 0;
      field1070 = new int[128];
      field1071 = new int[128];
      field1072 = -1L;
      field1073 = -1;
      field1006 = 0;
      field1075 = new int[1000];
      field1064 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1080 = 0;
      field981 = 255;
      field1115 = -1;
      field970 = false;
      field1084 = 127;
      field911 = 127;
      queuedSoundEffectCount = 0;
      queuedSoundEffectIDs = new int[50];
      unknownSoundValues1 = new int[50];
      unknownSoundValues2 = new int[50];
      soundLocations = new int[50];
      audioEffects = new SoundEffect[50];
      field1092 = false;
      field1093 = new boolean[5];
      field995 = new int[5];
      field894 = new int[5];
      field903 = new int[5];
      field1091 = new int[5];
      field871 = 256;
      field1099 = 205;
      field1100 = 256;
      field1101 = 320;
      field893 = 1;
      field860 = 32767;
      field1104 = 1;
      field992 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      scale = 0;
      field1009 = new PlayerComposition();
      field967 = -1;
      field1113 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field858 = new OwnWorldComparator();
      field1116 = -1;
      field1117 = new ArrayList(10);
      field1118 = 0;
      field1119 = new class71();
      field1095 = new int[50];
      field1121 = new int[50];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1383330883"
   )
   protected final void vmethod1207() {
      field1061 = PendingSpawn.currentTimeMs() + 500L;
      this.method1208();
      if(widgetRoot != -1) {
         this.method1214(true);
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   @Export("setUp")
   protected final void setUp() {
      CollisionData.method3441(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      class233.port1 = socketType == 0?43594:world + 40000;
      class44.port2 = socketType == 0?443:world + 50000;
      class247.myWorldPort = class233.port1;
      GrandExchangeOffer.colorsToFind = class240.field2807;
      class236.colorsToReplace = class240.field2802;
      class71.field821 = class240.field2803;
      class195.field2580 = class240.field2804;
      class45.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      WorldMapType3.mouseWheel = this.mouseWheel();
      ContextMenuRow.indexStore255 = new IndexFile(255, class167.dat2File, class167.idx255File, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = Item.getPreferencesFile("", class150.field2118.name, false);
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

      class55.preferences = var3;
      this.setUpClipboard();
      String var9 = class28.field425;
      class57.field667 = this;
      if(var9 != null) {
         class57.field668 = var9;
      }

      if(socketType != 0) {
         displayFps = true;
      }

      class291.method5314(class55.preferences.screenType);
      ContextMenuRow.friendManager = new FriendManager(class21.loginType);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-500765769"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      Actor.method1636();
      GameEngine.method984();
      Huffman.method3510();
      class157.method3245();
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

      if(WorldMapType3.mouseWheel != null) {
         int var39 = WorldMapType3.mouseWheel.useRotation();
         mouseWheelRotation = var39;
      }

      if(gameState == 0) {
         Timer.load();
         class64.method1065();
      } else if(gameState == 5) {
         UrlRequester.method3168(this);
         Timer.load();
         class64.method1065();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            UrlRequester.method3168(this);
            this.method1205();
         } else if(gameState == 25) {
            class243.flush(false);
            field1105 = 0;
            boolean var57 = true;

            int var40;
            for(var40 = 0; var40 < Buffer.field2570.length; ++var40) {
               if(MapLabel.landMapFileIds[var40] != -1 && Buffer.field2570[var40] == null) {
                  Buffer.field2570[var40] = BuildType.indexMaps.getConfigData(MapLabel.landMapFileIds[var40], 0);
                  if(Buffer.field2570[var40] == null) {
                     var57 = false;
                     ++field1105;
                  }
               }

               if(TotalQuantityComparator.landRegionFileIds[var40] != -1 && UnitPriceComparator.field320[var40] == null) {
                  UnitPriceComparator.field320[var40] = BuildType.indexMaps.getConfigDataKeys(TotalQuantityComparator.landRegionFileIds[var40], 0, class158.xteaKeys[var40]);
                  if(UnitPriceComparator.field320[var40] == null) {
                     var57 = false;
                     ++field1105;
                  }
               }
            }

            if(!var57) {
               field909 = 1;
            } else {
               field907 = 0;
               var57 = true;

               int var4;
               int var5;
               int var10;
               int var11;
               int var12;
               int var14;
               int var15;
               int var16;
               int var17;
               int var18;
               for(var40 = 0; var40 < Buffer.field2570.length; ++var40) {
                  byte[] var3 = UnitPriceComparator.field320[var40];
                  if(var3 != null) {
                     var4 = (WorldMapData.mapRegions[var40] >> 8) * 64 - WorldMapType1.baseX;
                     var5 = (WorldMapData.mapRegions[var40] & 255) * 64 - Enum.baseY;
                     if(isDynamicRegion) {
                        var4 = 10;
                        var5 = 10;
                     }

                     boolean var8 = true;
                     Buffer var9 = new Buffer(var3);
                     var10 = -1;

                     label632:
                     while(true) {
                        var11 = var9.getUSmart();
                        if(var11 == 0) {
                           var57 &= var8;
                           break;
                        }

                        var10 += var11;
                        var12 = 0;
                        boolean var13 = false;

                        while(true) {
                           while(!var13) {
                              var14 = var9.getUSmart();
                              if(var14 == 0) {
                                 continue label632;
                              }

                              var12 += var14 - 1;
                              var15 = var12 & 63;
                              var16 = var12 >> 6 & 63;
                              var17 = var9.readUnsignedByte() >> 2;
                              var18 = var4 + var16;
                              int var19 = var15 + var5;
                              if(var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                                 ObjectComposition var20 = class169.getObjectDefinition(var10);
                                 if(var17 != 22 || !lowMemory || var20.int1 != 0 || var20.clipType == 1 || var20.obstructsGround) {
                                    if(!var20.method5115()) {
                                       ++field907;
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

               if(!var57) {
                  field909 = 2;
               } else {
                  if(field909 != 0) {
                     SoundTaskDataProvider.method783("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                  }

                  Huffman.method3510();
                  class86.region.reset();

                  for(var40 = 0; var40 < 4; ++var40) {
                     collisionMaps[var40].reset();
                  }

                  int var41;
                  for(var40 = 0; var40 < 4; ++var40) {
                     for(var41 = 0; var41 < 104; ++var41) {
                        for(var4 = 0; var4 < 104; ++var4) {
                           class62.tileSettings[var40][var41][var4] = 0;
                        }
                     }
                  }

                  Huffman.method3510();
                  class62.field736 = 99;
                  UrlRequest.field2107 = new byte[4][104][104];
                  class62.field744 = new byte[4][104][104];
                  class62.field734 = new byte[4][104][104];
                  class62.field739 = new byte[4][104][104];
                  class62.field738 = new int[4][105][105];
                  class62.field740 = new byte[4][105][105];
                  class62.field741 = new int[105][105];
                  class19.field327 = new int[104];
                  class318.field3919 = new int[104];
                  UnitPriceComparator.field321 = new int[104];
                  class29.field430 = new int[104];
                  UnitPriceComparator.field316 = new int[104];
                  var40 = Buffer.field2570.length;
                  class5.method16();
                  class243.flush(true);
                  int var6;
                  if(!isDynamicRegion) {
                     byte[] var42;
                     for(var41 = 0; var41 < var40; ++var41) {
                        var4 = (WorldMapData.mapRegions[var41] >> 8) * 64 - WorldMapType1.baseX;
                        var5 = (WorldMapData.mapRegions[var41] & 255) * 64 - Enum.baseY;
                        var42 = Buffer.field2570[var41];
                        if(var42 != null) {
                           Huffman.method3510();
                           WorldMapManager.method601(var42, var4, var5, class62.field751 * 8 - 48, class1.field9 * 8 - 48, collisionMaps);
                        }
                     }

                     for(var41 = 0; var41 < var40; ++var41) {
                        var4 = (WorldMapData.mapRegions[var41] >> 8) * 64 - WorldMapType1.baseX;
                        var5 = (WorldMapData.mapRegions[var41] & 255) * 64 - Enum.baseY;
                        var42 = Buffer.field2570[var41];
                        if(var42 == null && class1.field9 < 800) {
                           Huffman.method3510();
                           UrlRequester.method3177(var4, var5, 64, 64);
                        }
                     }

                     class243.flush(true);

                     for(var41 = 0; var41 < var40; ++var41) {
                        byte[] var43 = UnitPriceComparator.field320[var41];
                        if(var43 != null) {
                           var5 = (WorldMapData.mapRegions[var41] >> 8) * 64 - WorldMapType1.baseX;
                           var6 = (WorldMapData.mapRegions[var41] & 255) * 64 - Enum.baseY;
                           Huffman.method3510();
                           class185.method3499(var43, var5, var6, class86.region, collisionMaps);
                        }
                     }
                  }

                  int var7;
                  int var44;
                  int var54;
                  if(isDynamicRegion) {
                     var41 = 0;

                     label550:
                     while(true) {
                        int var21;
                        int var22;
                        int var23;
                        int var27;
                        int var28;
                        int var29;
                        int var30;
                        int var33;
                        CollisionData[] var46;
                        Buffer var56;
                        if(var41 >= 4) {
                           for(var41 = 0; var41 < 13; ++var41) {
                              for(var4 = 0; var4 < 13; ++var4) {
                                 var5 = instanceTemplateChunks[0][var41][var4];
                                 if(var5 == -1) {
                                    UrlRequester.method3177(var41 * 8, var4 * 8, 8, 8);
                                 }
                              }
                           }

                           class243.flush(true);
                           var41 = 0;

                           while(true) {
                              if(var41 >= 4) {
                                 break label550;
                              }

                              Huffman.method3510();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 label473:
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    var6 = instanceTemplateChunks[var41][var4][var5];
                                    if(var6 != -1) {
                                       var7 = var6 >> 24 & 3;
                                       var54 = var6 >> 1 & 3;
                                       var44 = var6 >> 14 & 1023;
                                       var10 = var6 >> 3 & 2047;
                                       var11 = (var44 / 8 << 8) + var10 / 8;

                                       for(var12 = 0; var12 < WorldMapData.mapRegions.length; ++var12) {
                                          if(WorldMapData.mapRegions[var12] == var11 && UnitPriceComparator.field320[var12] != null) {
                                             byte[] var48 = UnitPriceComparator.field320[var12];
                                             var14 = var4 * 8;
                                             var15 = var5 * 8;
                                             var16 = (var44 & 7) * 8;
                                             var17 = (var10 & 7) * 8;
                                             Region var49 = class86.region;
                                             var46 = collisionMaps;
                                             var56 = new Buffer(var48);
                                             var21 = -1;

                                             while(true) {
                                                var22 = var56.getUSmart();
                                                if(var22 == 0) {
                                                   continue label473;
                                                }

                                                var21 += var22;
                                                var23 = 0;

                                                while(true) {
                                                   int var50 = var56.getUSmart();
                                                   if(var50 == 0) {
                                                      break;
                                                   }

                                                   var23 += var50 - 1;
                                                   int var25 = var23 & 63;
                                                   int var26 = var23 >> 6 & 63;
                                                   var27 = var23 >> 12;
                                                   var28 = var56.readUnsignedByte();
                                                   var29 = var28 >> 2;
                                                   var30 = var28 & 3;
                                                   if(var7 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                      ObjectComposition var31 = class169.getObjectDefinition(var21);
                                                      int var32 = var14 + CombatInfoListHolder.method1862(var26 & 7, var25 & 7, var54, var31.width, var31.length, var30);
                                                      var33 = var15 + KitDefinition.method4974(var26 & 7, var25 & 7, var54, var31.width, var31.length, var30);
                                                      if(var32 > 0 && var33 > 0 && var32 < 103 && var33 < 103) {
                                                         int var34 = var41;
                                                         if((class62.tileSettings[1][var32][var33] & 2) == 2) {
                                                            var34 = var41 - 1;
                                                         }

                                                         CollisionData var51 = null;
                                                         if(var34 >= 0) {
                                                            var51 = var46[var34];
                                                         }

                                                         ScriptVarType.addObject(var41, var32, var33, var21, var54 + var30 & 3, var29, var49, var51);
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }

                              ++var41;
                           }
                        }

                        Huffman.method3510();

                        for(var4 = 0; var4 < 13; ++var4) {
                           for(var5 = 0; var5 < 13; ++var5) {
                              boolean var53 = false;
                              var7 = instanceTemplateChunks[var41][var4][var5];
                              if(var7 != -1) {
                                 var54 = var7 >> 24 & 3;
                                 var44 = var7 >> 1 & 3;
                                 var10 = var7 >> 14 & 1023;
                                 var11 = var7 >> 3 & 2047;
                                 var12 = (var10 / 8 << 8) + var11 / 8;

                                 for(int var55 = 0; var55 < WorldMapData.mapRegions.length; ++var55) {
                                    if(WorldMapData.mapRegions[var55] == var12 && Buffer.field2570[var55] != null) {
                                       byte[] var45 = Buffer.field2570[var55];
                                       var15 = var4 * 8;
                                       var16 = var5 * 8;
                                       var17 = (var10 & 7) * 8;
                                       var18 = (var11 & 7) * 8;
                                       var46 = collisionMaps;

                                       for(int var47 = 0; var47 < 8; ++var47) {
                                          for(var21 = 0; var21 < 8; ++var21) {
                                             if(var47 + var15 > 0 && var47 + var15 < 103 && var16 + var21 > 0 && var16 + var21 < 103) {
                                                var46[var41].flags[var15 + var47][var16 + var21] &= -16777217;
                                             }
                                          }
                                       }

                                       var56 = new Buffer(var45);

                                       for(var21 = 0; var21 < 4; ++var21) {
                                          for(var22 = 0; var22 < 64; ++var22) {
                                             for(var23 = 0; var23 < 64; ++var23) {
                                                if(var54 == var21 && var22 >= var17 && var22 < var17 + 8 && var23 >= var18 && var23 < var18 + 8) {
                                                   var28 = var22 & 7;
                                                   var29 = var23 & 7;
                                                   var30 = var44 & 3;
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
                                                   int var36 = var22 & 7;
                                                   int var37 = var23 & 7;
                                                   int var38 = var44 & 3;
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

                                                   class171.loadTerrain(var56, var41, var33, var35 + var16, 0, 0, var44);
                                                } else {
                                                   class171.loadTerrain(var56, 0, -1, -1, 0, 0, 0);
                                                }
                                             }
                                          }
                                       }

                                       var53 = true;
                                       break;
                                    }
                                 }
                              }

                              if(!var53) {
                                 ChatLineBuffer.method2077(var41, var4 * 8, var5 * 8);
                              }
                           }
                        }

                        ++var41;
                     }
                  }

                  class243.flush(true);
                  Huffman.method3510();
                  class25.method191(class86.region, collisionMaps);
                  class243.flush(true);
                  var41 = class62.field736;
                  if(var41 > class36.plane) {
                     var41 = class36.plane;
                  }

                  if(var41 < class36.plane - 1) {
                     var41 = class36.plane - 1;
                  }

                  if(lowMemory) {
                     class86.region.setup(class62.field736);
                  } else {
                     class86.region.setup(0);
                  }

                  for(var4 = 0; var4 < 104; ++var4) {
                     for(var5 = 0; var5 < 104; ++var5) {
                        Size.groundItemSpawned(var4, var5);
                     }
                  }

                  Huffman.method3510();
                  ScriptEvent.method1092();
                  ObjectComposition.field3591.reset();
                  PacketNode var58;
                  if(class23.clientInstance.method908()) {
                     var58 = class31.method285(ClientPacket.field2421, field899.field1470);
                     var58.packetBuffer.putInt(1057001181);
                     field899.method2082(var58);
                  }

                  if(!isDynamicRegion) {
                     var4 = (class62.field751 - 6) / 8;
                     var5 = (class62.field751 + 6) / 8;
                     var6 = (class1.field9 - 6) / 8;
                     var7 = (class1.field9 + 6) / 8;

                     for(var54 = var4 - 1; var54 <= var5 + 1; ++var54) {
                        for(var44 = var6 - 1; var44 <= var7 + 1; ++var44) {
                           if(var54 < var4 || var54 > var5 || var44 < var6 || var44 > var7) {
                              BuildType.indexMaps.method4693("m" + var54 + "_" + var44);
                              BuildType.indexMaps.method4693("l" + var54 + "_" + var44);
                           }
                        }
                     }
                  }

                  Enum.setGameState(30);
                  Huffman.method3510();
                  class21.method159();
                  var58 = class31.method285(ClientPacket.field2457, field899.field1470);
                  field899.method2082(var58);
                  class64.method1065();
               }
            }
         }
      } else {
         UrlRequester.method3168(this);
      }

      if(gameState == 30) {
         this.method1331();
      } else if(gameState == 40 || gameState == 45) {
         this.method1205();
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1293800771"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2 = class61.method1024();
      if(var2 && field970 && class284.soundSystem0 != null) {
         class284.soundSystem0.tryFlush();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1061 && PendingSpawn.currentTimeMs() > field1061) {
         var3 = class29.method249();
         field1061 = 0L;
         if(var3 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         if(class29.method249() == 1) {
            class23.clientInstance.method891(765, 503);
         } else {
            class23.clientInstance.method891(7680, 2160);
         }

         if(gameState >= 25) {
            PacketNode var4 = class31.method285(ClientPacket.field2415, field899.field1470);
            var4.packetBuffer.putByte(class29.method249());
            var4.packetBuffer.putShort(GameEngine.canvasWidth);
            var4.packetBuffer.putShort(class195.canvasHeight);
            field899.method2082(var4);
         }
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1053[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class90.loadingBarPercentage, class90.loadingText, var1);
      } else if(gameState == 5) {
         PacketBuffer.drawLoginScreen(DecorativeObject.fontBold12, class41.fontPlain11, SoundTaskDataProvider.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            PacketBuffer.drawLoginScreen(DecorativeObject.fontBold12, class41.fontPlain11, SoundTaskDataProvider.font_p12full, var1);
         } else if(gameState == 25) {
            if(field909 == 1) {
               if(field1105 > field906) {
                  field906 = field1105;
               }

               var3 = (field906 * 50 - field1105 * 50) / field906;
               SoundTaskDataProvider.method783("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field909 == 2) {
               if(field907 > field908) {
                  field908 = field907;
               }

               var3 = (field908 * 50 - field907 * 50) / field908 + 50;
               SoundTaskDataProvider.method783("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               SoundTaskDataProvider.method783("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1312();
         } else if(gameState == 40) {
            SoundTaskDataProvider.method783("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            SoundTaskDataProvider.method783("Please wait...", false);
         }
      } else {
         PacketBuffer.drawLoginScreen(DecorativeObject.fontBold12, class41.fontPlain11, SoundTaskDataProvider.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < widgetCount; ++var3) {
            if(field1043[var3]) {
               class20.rasterProvider.draw(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field1043[var3] = false;
            }
         }
      } else if(gameState > 0) {
         class20.rasterProvider.drawFull(0, 0);

         for(var3 = 0; var3 < widgetCount; ++var3) {
            field1043[var3] = false;
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-25189"
   )
   protected final void vmethod1201() {
      if(Script.chatMessages.changed()) {
         Script.chatMessages.serialize();
      }

      if(BoundingBox3D.mouseRecorder != null) {
         BoundingBox3D.mouseRecorder.isRunning = false;
      }

      BoundingBox3D.mouseRecorder = null;
      field899.close();
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var1 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

      if(MouseInput.mouse != null) {
         MouseInput var11 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      WorldMapType3.mouseWheel = null;
      if(class284.soundSystem0 != null) {
         class284.soundSystem0.shutdown();
      }

      if(ChatLineBuffer.soundSystem1 != null) {
         ChatLineBuffer.soundSystem1.shutdown();
      }

      if(class264.NetCache_socket != null) {
         class264.NetCache_socket.vmethod3379();
      }

      Object var12 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3394 != 0) {
            IndexStoreActionHandler.field3394 = 1;

            try {
               IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
            } catch (InterruptedException var6) {
               ;
            }
         }
      }

      if(class45.urlRequester != null) {
         class45.urlRequester.close();
         class45.urlRequester = null;
      }

      try {
         class167.dat2File.close();

         for(int var5 = 0; var5 < class167.idxCount; ++var5) {
            SoundTaskDataProvider.idxFiles[var5].close();
         }

         class167.idx255File.close();
         class167.randomDat.close();
      } catch (Exception var9) {
         ;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   protected final void vmethod1196() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = new Parameters[]{Parameters.field3809, Parameters.field3803, Parameters.field3799, Parameters.field3801, Parameters.field3796, Parameters.field3794, Parameters.field3806, Parameters.field3800, Parameters.field3797, Parameters.field3798, Parameters.field3810, Parameters.field3795, Parameters.field3808, Parameters.field3807, Parameters.field3802, Parameters.field3804};
         Parameters[] var2 = var1;

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            Parameters var4 = var2[var3];
            String var5 = this.getParameter(var4.key);
            if(var5 != null) {
               switch(Integer.parseInt(var4.key)) {
               case 1:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 2:
                  ScriptState.field759 = Integer.parseInt(var5);
                  break;
               case 3:
                  flags = Integer.parseInt(var5);
                  break;
               case 4:
                  languageId = Integer.parseInt(var5);
                  break;
               case 5:
                  class150.field2118 = (JagexGame)MapIcon.forOrdinal(class37.method505(), Integer.parseInt(var5));
                  if(class150.field2118 == JagexGame.field3352) {
                     class21.loginType = JagexLoginType.field4066;
                  } else {
                     class21.loginType = JagexLoginType.field4070;
                  }
                  break;
               case 6:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 7:
                  field902 = Integer.parseInt(var5) != 0;
                  break;
               case 8:
                  WorldMapManager.field563 = class251.method4636(Integer.parseInt(var5));
                  break;
               case 9:
                  AbstractByteBuffer.field2602 = Integer.parseInt(var5);
               case 10:
               case 12:
               default:
                  break;
               case 11:
                  class25.sessionToken = var5;
                  break;
               case 13:
                  class49.field613 = var5;
                  break;
               case 14:
                  socketType = Integer.parseInt(var5);
                  break;
               case 15:
                  world = Integer.parseInt(var5);
               }
            }
         }

         Region.regionLowMemory = false;
         lowMemory = false;
         BoundingBox.host = this.getCodeBase().getHost();
         String var17 = WorldMapManager.field563.identifier;
         byte var8 = 0;

         try {
            class167.idxCount = 17;
            GameCanvas.field655 = var8;

            try {
               PendingSpawn.osName = System.getProperty("os.name");
            } catch (Exception var14) {
               PendingSpawn.osName = "Unknown";
            }

            class167.osNameLC = PendingSpawn.osName.toLowerCase();

            try {
               AttackOption.userHome = System.getProperty("user.home");
               if(AttackOption.userHome != null) {
                  AttackOption.userHome = AttackOption.userHome + "/";
               }
            } catch (Exception var13) {
               ;
            }

            try {
               if(class167.osNameLC.startsWith("win")) {
                  if(AttackOption.userHome == null) {
                     AttackOption.userHome = System.getenv("USERPROFILE");
                  }
               } else if(AttackOption.userHome == null) {
                  AttackOption.userHome = System.getenv("HOME");
               }

               if(AttackOption.userHome != null) {
                  AttackOption.userHome = AttackOption.userHome + "/";
               }
            } catch (Exception var12) {
               ;
            }

            if(AttackOption.userHome == null) {
               AttackOption.userHome = "~/";
            }

            class167.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", AttackOption.userHome, "/tmp/", ""};
            class167.field2194 = new String[]{".jagex_cache_" + GameCanvas.field655, ".file_store_" + GameCanvas.field655};

            int var6;
            File var7;
            label164:
            for(var3 = 0; var3 < 4; ++var3) {
               class167.field2197 = WallObject.method3131("oldschool", var17, var3);
               if(!class167.field2197.exists()) {
                  class167.field2197.mkdirs();
               }

               File[] var18 = class167.field2197.listFiles();
               if(var18 == null) {
                  break;
               }

               File[] var20 = var18;
               var6 = 0;

               while(true) {
                  if(var6 >= var20.length) {
                     break label164;
                  }

                  var7 = var20[var6];
                  if(!class27.method221(var7, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            File var9 = class167.field2197;
            class170.field2212 = var9;
            if(!class170.field2212.exists()) {
               throw new RuntimeException("");
            }

            class170.field2214 = true;

            try {
               File var19 = new File(AttackOption.userHome, "random.dat");
               if(var19.exists()) {
                  class167.randomDat = new CacheFile(new FileOnDisk(var19, "rw", 25L), 24, 0);
               } else {
                  label142:
                  for(int var10 = 0; var10 < class167.field2194.length; ++var10) {
                     for(var6 = 0; var6 < class167.cacheLocations.length; ++var6) {
                        var7 = new File(class167.cacheLocations[var6] + class167.field2194[var10] + File.separatorChar + "random.dat");
                        if(var7.exists()) {
                           class167.randomDat = new CacheFile(new FileOnDisk(var7, "rw", 25L), 24, 0);
                           break label142;
                        }
                     }
                  }
               }

               if(class167.randomDat == null) {
                  RandomAccessFile var21 = new RandomAccessFile(var19, "rw");
                  var6 = var21.read();
                  var21.seek(0L);
                  var21.write(var6);
                  var21.seek(0L);
                  var21.close();
                  class167.randomDat = new CacheFile(new FileOnDisk(var19, "rw", 25L), 24, 0);
               }
            } catch (IOException var15) {
               ;
            }

            class167.dat2File = new CacheFile(new FileOnDisk(class1.method5("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class167.idx255File = new CacheFile(new FileOnDisk(class1.method5("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            SoundTaskDataProvider.idxFiles = new CacheFile[class167.idxCount];

            for(int var11 = 0; var11 < class167.idxCount; ++var11) {
               SoundTaskDataProvider.idxFiles[var11] = new CacheFile(new FileOnDisk(class1.method5("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var16) {
            ItemLayer.method2658((String)null, var16);
         }

         class23.clientInstance = this;
         this.initialize(765, 503, 165);
      }
   }

   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-50683471"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         long var2 = PendingSpawn.currentTimeMs();
         int var4 = (int)(var2 - class264.field3414);
         class264.field3414 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class264.field3407 += var4;
         boolean var1;
         if(class264.NetCache_pendingResponsesCount == 0 && class264.NetCache_pendingPriorityResponsesCount == 0 && class264.NetCache_pendingWritesCount == 0 && class264.NetCache_pendingPriorityWritesCount == 0) {
            var1 = true;
         } else if(class264.NetCache_socket == null) {
            var1 = false;
         } else {
            try {
               label240: {
                  if(class264.field3407 > 30000) {
                     throw new IOException();
                  }

                  FileRequest var5;
                  Buffer var6;
                  while(class264.NetCache_pendingPriorityResponsesCount < 200 && class264.NetCache_pendingPriorityWritesCount > 0) {
                     var5 = (FileRequest)class264.NetCache_pendingPriorityWrites.first();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class264.NetCache_socket.vmethod3387(var6.payload, 0, 4);
                     class264.NetCache_pendingPriorityResponses.put(var5, var5.hash);
                     --class264.NetCache_pendingPriorityWritesCount;
                     ++class264.NetCache_pendingPriorityResponsesCount;
                  }

                  while(class264.NetCache_pendingResponsesCount < 200 && class264.NetCache_pendingWritesCount > 0) {
                     var5 = (FileRequest)class264.NetCache_pendingWritesQueue.peek();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class264.NetCache_socket.vmethod3387(var6.payload, 0, 4);
                     var5.unlinkDual();
                     class264.NetCache_pendingResponses.put(var5, var5.hash);
                     --class264.NetCache_pendingWritesCount;
                     ++class264.NetCache_pendingResponsesCount;
                  }

                  for(int var17 = 0; var17 < 100; ++var17) {
                     int var18 = class264.NetCache_socket.vmethod3389();
                     if(var18 < 0) {
                        throw new IOException();
                     }

                     if(var18 == 0) {
                        break;
                     }

                     class264.field3407 = 0;
                     byte var7 = 0;
                     if(TotalQuantityComparator.currentRequest == null) {
                        var7 = 8;
                     } else if(class264.field3412 == 0) {
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

                        class264.NetCache_socket.vmethod3399(class264.NetCache_responseHeaderBuffer.payload, class264.NetCache_responseHeaderBuffer.offset, var8);
                        if(class264.field3422 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class264.NetCache_responseHeaderBuffer.payload[var9 + class264.NetCache_responseHeaderBuffer.offset] ^= class264.field3422;
                           }
                        }

                        class264.NetCache_responseHeaderBuffer.offset += var8;
                        if(class264.NetCache_responseHeaderBuffer.offset < var7) {
                           break;
                        }

                        if(TotalQuantityComparator.currentRequest == null) {
                           class264.NetCache_responseHeaderBuffer.offset = 0;
                           var9 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var10 = class264.NetCache_responseHeaderBuffer.readUnsignedShort();
                           int var11 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                           var12 = class264.NetCache_responseHeaderBuffer.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           FileRequest var15 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var13);
                           GrandExchangeEvents.field281 = true;
                           if(var15 == null) {
                              var15 = (FileRequest)class264.NetCache_pendingResponses.get(var13);
                              GrandExchangeEvents.field281 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           TotalQuantityComparator.currentRequest = var15;
                           class264.NetCache_responseArchiveBuffer = new Buffer(var12 + var16 + TotalQuantityComparator.currentRequest.padding);
                           class264.NetCache_responseArchiveBuffer.putByte(var11);
                           class264.NetCache_responseArchiveBuffer.putInt(var12);
                           class264.field3412 = 8;
                           class264.NetCache_responseHeaderBuffer.offset = 0;
                        } else if(class264.field3412 == 0) {
                           if(class264.NetCache_responseHeaderBuffer.payload[0] == -1) {
                              class264.field3412 = 1;
                              class264.NetCache_responseHeaderBuffer.offset = 0;
                           } else {
                              TotalQuantityComparator.currentRequest = null;
                           }
                        }
                     } else {
                        var8 = class264.NetCache_responseArchiveBuffer.payload.length - TotalQuantityComparator.currentRequest.padding;
                        var9 = 512 - class264.field3412;
                        if(var9 > var8 - class264.NetCache_responseArchiveBuffer.offset) {
                           var9 = var8 - class264.NetCache_responseArchiveBuffer.offset;
                        }

                        if(var9 > var18) {
                           var9 = var18;
                        }

                        class264.NetCache_socket.vmethod3399(class264.NetCache_responseArchiveBuffer.payload, class264.NetCache_responseArchiveBuffer.offset, var9);
                        if(class264.field3422 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class264.NetCache_responseArchiveBuffer.payload[class264.NetCache_responseArchiveBuffer.offset + var10] ^= class264.field3422;
                           }
                        }

                        class264.NetCache_responseArchiveBuffer.offset += var9;
                        class264.field3412 += var9;
                        if(var8 == class264.NetCache_responseArchiveBuffer.offset) {
                           if(TotalQuantityComparator.currentRequest.hash == 16711935L) {
                              class20.NetCache_reference = class264.NetCache_responseArchiveBuffer;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var19 = class264.NetCache_indexCaches[var10];
                                 if(var19 != null) {
                                    class20.NetCache_reference.offset = var10 * 8 + 5;
                                    var12 = class20.NetCache_reference.readInt();
                                    int var20 = class20.NetCache_reference.readInt();
                                    var19.setInformation(var12, var20);
                                 }
                              }
                           } else {
                              class264.NetCache_crc.reset();
                              class264.NetCache_crc.update(class264.NetCache_responseArchiveBuffer.payload, 0, var8);
                              var10 = (int)class264.NetCache_crc.getValue();
                              if(var10 != TotalQuantityComparator.currentRequest.crc) {
                                 try {
                                    class264.NetCache_socket.vmethod3379();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class264.field3423;
                                 class264.NetCache_socket = null;
                                 class264.field3422 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label240;
                              }

                              class264.field3423 = 0;
                              class264.field3421 = 0;
                              TotalQuantityComparator.currentRequest.index.write((int)(TotalQuantityComparator.currentRequest.hash & 65535L), class264.NetCache_responseArchiveBuffer.payload, (TotalQuantityComparator.currentRequest.hash & 16711680L) == 16711680L, GrandExchangeEvents.field281);
                           }

                           TotalQuantityComparator.currentRequest.unlink();
                           if(GrandExchangeEvents.field281) {
                              --class264.NetCache_pendingPriorityResponsesCount;
                           } else {
                              --class264.NetCache_pendingResponsesCount;
                           }

                           class264.field3412 = 0;
                           TotalQuantityComparator.currentRequest = null;
                           class264.NetCache_responseArchiveBuffer = null;
                        } else {
                           if(class264.field3412 != 512) {
                              break;
                           }

                           class264.field3412 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class264.NetCache_socket.vmethod3379();
               } catch (Exception var22) {
                  ;
               }

               ++class264.field3421;
               class264.NetCache_socket = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1203();
         }

      }
   }

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1517883516"
   )
   void method1203() {
      if(class264.field3423 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class264.field3421 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field873 = 3000;
            class264.field3421 = 3;
         }

         if(--field873 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  OwnWorldComparator.socket = GameEngine.taskManager.createSocket(BoundingBox.host, class247.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(OwnWorldComparator.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(OwnWorldComparator.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field902) {
                     Socket var2 = (Socket)OwnWorldComparator.socket.value;
                     class171 var1 = new class171(var2, 40000, 5000);
                     Size.rssocket = var1;
                  } else {
                     Size.rssocket = new class173((Socket)OwnWorldComparator.socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var11 = new Buffer(5);
                  var11.putByte(15);
                  var11.putInt(165);
                  Size.rssocket.vmethod3387(var11.payload, 0, 5);
                  ++js5State;
                  class321.field3929 = PendingSpawn.currentTimeMs();
               }

               if(js5State == 3) {
                  if(Size.rssocket.vmethod3389() > 0 || !field902 && gameState <= 5) {
                     int var5 = Size.rssocket.vmethod3381();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  } else if(PendingSpawn.currentTimeMs() - class321.field3929 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  class169 var12 = Size.rssocket;
                  boolean var6 = gameState > 20;
                  if(class264.NetCache_socket != null) {
                     try {
                        class264.NetCache_socket.vmethod3379();
                     } catch (Exception var9) {
                        ;
                     }

                     class264.NetCache_socket = null;
                  }

                  class264.NetCache_socket = var12;
                  class36.sendConInfo(var6);
                  class264.NetCache_responseHeaderBuffer.offset = 0;
                  TotalQuantityComparator.currentRequest = null;
                  class264.NetCache_responseArchiveBuffer = null;
                  class264.field3412 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class264.NetCache_pendingPriorityResponses.first();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class264.NetCache_pendingResponses.first();
                           if(var3 == null) {
                              if(class264.field3422 != 0) {
                                 try {
                                    Buffer var13 = new Buffer(4);
                                    var13.putByte(4);
                                    var13.putByte(class264.field3422);
                                    var13.putShort(0);
                                    class264.NetCache_socket.vmethod3387(var13.payload, 0, 4);
                                 } catch (IOException var8) {
                                    try {
                                       class264.NetCache_socket.vmethod3379();
                                    } catch (Exception var7) {
                                       ;
                                    }

                                    ++class264.field3421;
                                    class264.NetCache_socket = null;
                                 }
                              }

                              class264.field3407 = 0;
                              class264.field3414 = PendingSpawn.currentTimeMs();
                              OwnWorldComparator.socket = null;
                              Size.rssocket = null;
                              js5State = 0;
                              field887 = 0;
                              return;
                           }

                           class264.NetCache_pendingWritesQueue.setHead(var3);
                           class264.NetCache_pendingWrites.put(var3, var3.hash);
                           ++class264.NetCache_pendingWritesCount;
                           --class264.NetCache_pendingResponsesCount;
                        }
                     }

                     class264.NetCache_pendingPriorityWrites.put(var3, var3.hash);
                     ++class264.NetCache_pendingPriorityWritesCount;
                     --class264.NetCache_pendingPriorityResponsesCount;
                  }
               }
            } catch (IOException var10) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   @Export("error")
   void error(int var1) {
      OwnWorldComparator.socket = null;
      Size.rssocket = null;
      js5State = 0;
      if(class247.myWorldPort == class233.port1) {
         class247.myWorldPort = class44.port2;
      } else {
         class247.myWorldPort = class233.port1;
      }

      ++field887;
      if(field887 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field873 = 3000;
         }
      } else if(field887 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field887 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field873 = 3000;
         }
      }

   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1398997195"
   )
   final void method1205() {
      Object var1 = field899.getSocket();
      PacketBuffer var2 = field899.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class169)var1).vmethod3379();
               var1 = null;
            }

            class7.field233 = null;
            socketError = false;
            field1076 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class7.field233 == null) {
               class7.field233 = GameEngine.taskManager.createSocket(BoundingBox.host, class247.myWorldPort);
            }

            if(class7.field233.status == 2) {
               throw new IOException();
            }

            if(class7.field233.status == 1) {
               if(field902) {
                  Socket var4 = (Socket)class7.field233.value;
                  class171 var3 = new class171(var4, 40000, 5000);
                  var1 = var3;
               } else {
                  var1 = new class173((Socket)class7.field233.value, GameEngine.taskManager, 5000);
               }

               field899.setSocket((class169)var1);
               class7.field233 = null;
               loginState = 2;
            }
         }

         PacketNode var21;
         if(loginState == 2) {
            field899.method2079();
            if(PacketNode.field2497 == 0) {
               var21 = new PacketNode();
            } else {
               var21 = PacketNode.packetBufferNodes[--PacketNode.field2497];
            }

            var21.clientPacket = null;
            var21.field2493 = 0;
            var21.packetBuffer = new PacketBuffer(5000);
            var21.packetBuffer.putByte(LoginPacket.field2479.id);
            field899.method2082(var21);
            field899.method2080();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var11;
         int var12;
         if(loginState == 3) {
            if(class284.soundSystem0 != null) {
               class284.soundSystem0.method2259();
            }

            if(ChatLineBuffer.soundSystem1 != null) {
               ChatLineBuffer.soundSystem1.method2259();
            }

            var11 = true;
            if(field902 && !((class169)var1).vmethod3383(1)) {
               var11 = false;
            }

            if(var11) {
               var12 = ((class169)var1).vmethod3381();
               if(class284.soundSystem0 != null) {
                  class284.soundSystem0.method2259();
               }

               if(ChatLineBuffer.soundSystem1 != null) {
                  ChatLineBuffer.soundSystem1.method2259();
               }

               if(var12 != 0) {
                  WallObject.method3132(var12);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var29;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var29 = ((class169)var1).vmethod3389();
               if(var29 > 8 - var2.offset) {
                  var29 = 8 - var2.offset;
               }

               if(var29 > 0) {
                  ((class169)var1).vmethod3399(var2.payload, var2.offset, var29);
                  var2.offset += var29;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               class49.field603 = var2.readLong();
               loginState = 5;
            }
         }

         if(loginState == 5) {
            field899.packetBuffer.offset = 0;
            field899.method2079();
            PacketBuffer var18 = new PacketBuffer(500);
            int[] var23 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class49.field603 >> 32), (int)(class49.field603 & -1L)};
            var18.offset = 0;
            var18.putByte(1);
            var18.putByte(field1040.rsOrdinal());
            var18.putInt(var23[0]);
            var18.putInt(var23[1]);
            var18.putInt(var23[2]);
            var18.putInt(var23[3]);
            switch(field1040.field2144) {
            case 0:
               var18.putInt(((Integer)class55.preferences.preferences.get(Integer.valueOf(NameableContainer.method5436(class90.username)))).intValue());
               var18.offset += 4;
               break;
            case 1:
            case 3:
               var18.put24bitInt(class2.field14);
               var18.offset += 5;
               break;
            case 2:
               var18.offset += 8;
            }

            var18.putString(class90.password);
            var18.encryptRsa(class88.field1321, class88.field1322);
            PacketNode var6;
            if(PacketNode.field2497 == 0) {
               var6 = new PacketNode();
            } else {
               var6 = PacketNode.packetBufferNodes[--PacketNode.field2497];
            }

            var6.clientPacket = null;
            var6.field2493 = 0;
            var6.packetBuffer = new PacketBuffer(5000);
            var6.packetBuffer.offset = 0;
            if(gameState == 40) {
               var6.packetBuffer.putByte(LoginPacket.field2481.id);
            } else {
               var6.packetBuffer.putByte(LoginPacket.field2474.id);
            }

            var6.packetBuffer.putShort(0);
            int var13 = var6.packetBuffer.offset;
            var6.packetBuffer.putInt(165);
            var6.packetBuffer.putBytes(var18.payload, 0, var18.offset);
            int var8 = var6.packetBuffer.offset;
            var6.packetBuffer.putString(class90.username);
            var6.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var6.packetBuffer.putShort(GameEngine.canvasWidth);
            var6.packetBuffer.putShort(class195.canvasHeight);
            MouseRecorder.method1099(var6.packetBuffer);
            var6.packetBuffer.putString(class25.sessionToken);
            var6.packetBuffer.putInt(ScriptState.field759);
            Buffer var9 = new Buffer(class21.platformInfo.method6251());
            class21.platformInfo.method6253(var9);
            var6.packetBuffer.putBytes(var9.payload, 0, var9.payload.length);
            var6.packetBuffer.putByte(AbstractByteBuffer.field2602);
            var6.packetBuffer.putInt(0);
            var6.packetBuffer.putInt(class21.indexInterfaces.crc);
            var6.packetBuffer.putInt(class5.indexSoundEffects.crc);
            var6.packetBuffer.putInt(BoundingBox2D.configsIndex.crc);
            var6.packetBuffer.putInt(class195.indexCache3.crc);
            var6.packetBuffer.putInt(class178.indexCache4.crc);
            var6.packetBuffer.putInt(BuildType.indexMaps.crc);
            var6.packetBuffer.putInt(class154.indexTrack1.crc);
            var6.packetBuffer.putInt(indexModels.crc);
            var6.packetBuffer.putInt(Renderable.indexSprites.crc);
            var6.packetBuffer.putInt(class86.indexTextures.crc);
            var6.packetBuffer.putInt(GrandExchangeOffer.indexCache10.crc);
            var6.packetBuffer.putInt(class66.indexTrack2.crc);
            var6.packetBuffer.putInt(class1.indexScripts.crc);
            var6.packetBuffer.putInt(class20.indexCache13.crc);
            var6.packetBuffer.putInt(class152.vorbisIndex.crc);
            var6.packetBuffer.putInt(class55.indexCache15.crc);
            var6.packetBuffer.putInt(ServerPacket.indexWorldMap.crc);
            var6.packetBuffer.encryptXtea(var23, var8, var6.packetBuffer.offset);
            var6.packetBuffer.method3593(var6.packetBuffer.offset - var13);
            field899.method2082(var6);
            field899.method2080();
            field899.field1470 = new ISAACCipher(var23);

            for(int var10 = 0; var10 < 4; ++var10) {
               var23[var10] += 50;
            }

            var2.seed(var23);
            loginState = 6;
         }

         if(loginState == 6 && ((class169)var1).vmethod3389() > 0) {
            var29 = ((class169)var1).vmethod3381();
            if(var29 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var29 == 2) {
               loginState = 9;
            } else if(var29 == 15 && gameState == 40) {
               field899.packetLength = -1;
               loginState = 13;
            } else if(var29 == 23 && field890 < 1) {
               ++field890;
               loginState = 0;
            } else {
               if(var29 != 29) {
                  WallObject.method3132(var29);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class169)var1).vmethod3389() > 0) {
            field891 = (((class169)var1).vmethod3381() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field1076 = 0;
            KeyFocusListener.method770("You have only just left another world.", "Your profile will be transferred in:", field891 / 60 + " seconds.");
            if(--field891 <= 0) {
               loginState = 0;
            }

         } else {
            int var14;
            if(loginState == 9 && ((class169)var1).vmethod3389() >= 13) {
               var11 = ((class169)var1).vmethod3381() == 1;
               ((class169)var1).vmethod3399(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var30 = false;
               if(var11) {
                  var12 = var2.readOpcode() << 24;
                  var12 |= var2.readOpcode() << 16;
                  var12 |= var2.readOpcode() << 8;
                  var12 |= var2.readOpcode();
                  var14 = NameableContainer.method5436(class90.username);
                  if(class55.preferences.preferences.size() >= 10 && !class55.preferences.preferences.containsKey(Integer.valueOf(var14))) {
                     Iterator var28 = class55.preferences.preferences.entrySet().iterator();
                     var28.next();
                     var28.remove();
                  }

                  class55.preferences.preferences.put(Integer.valueOf(var14), Integer.valueOf(var12));
               }

               if(class90.Login_isUsernameRemembered) {
                  class55.preferences.rememberedUsername = class90.username;
               } else {
                  class55.preferences.rememberedUsername = null;
               }

               MessageNode.method1130();
               rights = ((class169)var1).vmethod3381();
               field1019 = ((class169)var1).vmethod3381() == 1;
               localInteractingIndex = ((class169)var1).vmethod3381();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class169)var1).vmethod3381();
               field968 = ((class169)var1).vmethod3381();
               ((class169)var1).vmethod3399(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = class245.method4619();
               int var15 = var2.method3877();
               if(var15 < 0 || var15 >= var5.length) {
                  throw new IOException(var15 + " " + var2.offset);
               }

               field899.serverPacket = var5[var15];
               field899.packetLength = field899.serverPacket.packetLength;
               ((class169)var1).vmethod3399(var2.payload, 0, 2);
               var2.offset = 0;
               field899.packetLength = var2.readUnsignedShort();

               try {
                  class53.method786(class23.clientInstance, "zap");
               } catch (Throwable var16) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((class169)var1).vmethod3389() >= field899.packetLength) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3399(var2.payload, 0, field899.packetLength);
                  field1077.method5320();
                  mouseLastLastPressedTimeMillis = -1L;
                  field869 = -1;
                  BoundingBox3D.mouseRecorder.index = 0;
                  Parameters.field3805 = true;
                  field864 = true;
                  field1072 = -1L;
                  class278.method5044();
                  field899.method2079();
                  field899.packetBuffer.offset = 0;
                  field899.serverPacket = null;
                  field899.field1478 = null;
                  field899.field1479 = null;
                  field899.field1480 = null;
                  field899.packetLength = 0;
                  field899.field1476 = 0;
                  field1069 = 0;
                  field886 = 0;
                  hintArrowTargetType = 0;
                  class38.method508();
                  GameEngine.method983(0);
                  class95.chatLineMap.clear();
                  class95.messages.clear();
                  class95.field1431.clear();
                  class95.field1434 = 0;
                  itemSelectionState = 0;
                  spellSelected = false;
                  queuedSoundEffectCount = 0;
                  mapAngle = 0;
                  field927 = 0;
                  OwnWorldComparator.field852 = null;
                  field1080 = 0;
                  field1073 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  playerAttackOption = AttackOption.AttackOption_hidden;
                  npcAttackOption = AttackOption.AttackOption_hidden;
                  npcIndexesCount = 0;
                  class93.method1988();

                  for(var29 = 0; var29 < 2048; ++var29) {
                     cachedPlayers[var29] = null;
                  }

                  for(var29 = 0; var29 < 32768; ++var29) {
                     cachedNPCs[var29] = null;
                  }

                  field1103 = -1;
                  projectiles.clear();
                  graphicsObjectDeque.clear();

                  for(var29 = 0; var29 < 4; ++var29) {
                     for(var12 = 0; var12 < 104; ++var12) {
                        for(var14 = 0; var14 < 104; ++var14) {
                           groundItemDeque[var29][var12][var14] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  ContextMenuRow.friendManager.method1749();

                  for(var29 = 0; var29 < VarPlayerType.field3446; ++var29) {
                     VarPlayerType var27 = class252.method4638(var29);
                     if(var27 != null) {
                        class237.settings[var29] = 0;
                        class237.widgetSettings[var29] = 0;
                     }
                  }

                  Script.chatMessages.reset();
                  field1008 = -1;
                  if(widgetRoot != -1) {
                     class95.method2042(widgetRoot);
                  }

                  for(WidgetNode var20 = (WidgetNode)componentTable.first(); var20 != null; var20 = (WidgetNode)componentTable.next()) {
                     class254.method4639(var20, true);
                  }

                  widgetRoot = -1;
                  componentTable = new HashTable(8);
                  field1014 = null;
                  class38.method508();
                  field1009.method4512((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var29 = 0; var29 < 8; ++var29) {
                     playerOptions[var29] = null;
                     playerOptionsPriorities[var29] = false;
                  }

                  class27.method224();
                  field1068 = true;

                  for(var29 = 0; var29 < 100; ++var29) {
                     field1053[var29] = true;
                  }

                  PacketNode var22 = class31.method285(ClientPacket.field2415, field899.field1470);
                  var22.packetBuffer.putByte(class29.method249());
                  var22.packetBuffer.putShort(GameEngine.canvasWidth);
                  var22.packetBuffer.putShort(class195.canvasHeight);
                  field899.method2082(var22);
                  WidgetNode.clanMemberManager = null;

                  for(var29 = 0; var29 < 8; ++var29) {
                     grandExchangeOffers[var29] = new GrandExchangeOffer();
                  }

                  GameObject.grandExchangeEvents = null;
                  class288.initializeGPI(var2);
                  class62.field751 = -1;
                  class90.xteaChanged(false, var2);
                  field899.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((class169)var1).vmethod3389() >= 2) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3399(var2.payload, 0, 2);
                  var2.offset = 0;
                  FrameMap.field1960 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class169)var1).vmethod3389() >= FrameMap.field1960) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3399(var2.payload, 0, FrameMap.field1960);
                  var2.offset = 0;
                  String var19 = var2.readString();
                  String var25 = var2.readString();
                  String var24 = var2.readString();
                  KeyFocusListener.method770(var19, var25, var24);
                  Enum.setGameState(10);
               }

               if(loginState != 13) {
                  ++field1076;
                  if(field1076 > 2000) {
                     if(field890 < 1) {
                        if(class247.myWorldPort == class233.port1) {
                           class247.myWorldPort = class44.port2;
                        } else {
                           class247.myWorldPort = class233.port1;
                        }

                        ++field890;
                        loginState = 0;
                     } else {
                        WallObject.method3132(-3);
                     }
                  }
               } else {
                  if(field899.packetLength == -1) {
                     if(((class169)var1).vmethod3389() < 2) {
                        return;
                     }

                     ((class169)var1).vmethod3399(var2.payload, 0, 2);
                     var2.offset = 0;
                     field899.packetLength = var2.readUnsignedShort();
                  }

                  if(((class169)var1).vmethod3389() >= field899.packetLength) {
                     ((class169)var1).vmethod3399(var2.payload, 0, field899.packetLength);
                     var2.offset = 0;
                     var29 = field899.packetLength;
                     field1077.method5342();
                     field899.method2079();
                     field899.packetBuffer.offset = 0;
                     field899.serverPacket = null;
                     field899.field1478 = null;
                     field899.field1479 = null;
                     field899.field1480 = null;
                     field899.packetLength = 0;
                     field899.field1476 = 0;
                     field1069 = 0;
                     class38.method508();
                     field1080 = 0;
                     destinationX = 0;

                     for(var12 = 0; var12 < 2048; ++var12) {
                        cachedPlayers[var12] = null;
                     }

                     TotalQuantityComparator.localPlayer = null;

                     for(var12 = 0; var12 < cachedNPCs.length; ++var12) {
                        NPC var26 = cachedNPCs[var12];
                        if(var26 != null) {
                           var26.interacting = -1;
                           var26.field1166 = false;
                        }
                     }

                     class27.method224();
                     Enum.setGameState(30);

                     for(var12 = 0; var12 < 100; ++var12) {
                        field1053[var12] = true;
                     }

                     var21 = class31.method285(ClientPacket.field2415, field899.field1470);
                     var21.packetBuffer.putByte(class29.method249());
                     var21.packetBuffer.putShort(GameEngine.canvasWidth);
                     var21.packetBuffer.putShort(class195.canvasHeight);
                     field899.method2082(var21);
                     class288.initializeGPI(var2);
                     if(var29 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var17) {
         if(field890 < 1) {
            if(class247.myWorldPort == class233.port1) {
               class247.myWorldPort = class44.port2;
            } else {
               class247.myWorldPort = class233.port1;
            }

            ++field890;
            loginState = 0;
         } else {
            WallObject.method3132(-2);
         }
      }
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   final void method1331() {
      if(field1069 > 1) {
         --field1069;
      }

      if(field886 > 0) {
         --field886;
      }

      if(socketError) {
         socketError = false;
         SoundTaskDataProvider.method781();
      } else {
         if(!isMenuOpen) {
            class38.method508();
            menuOptions[0] = "Cancel";
            menuTargets[0] = "";
            menuTypes[0] = 1006;
            menuBooleanArray[0] = false;
            menuOptionCount = 1;
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1210(field899); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class326.classInfos.last();
               boolean var30;
               if(var2 == null) {
                  var30 = false;
               } else {
                  var30 = true;
               }

               int var3;
               PacketNode var31;
               if(!var30) {
                  PacketNode var15;
                  int var16;
                  if(field1077.field3813) {
                     var15 = class31.method285(ClientPacket.field2404, field899.field1470);
                     var15.packetBuffer.putByte(0);
                     var16 = var15.packetBuffer.offset;
                     field1077.method5323(var15.packetBuffer);
                     var15.packetBuffer.method3578(var15.packetBuffer.offset - var16);
                     field899.method2082(var15);
                     field1077.method5322();
                  }

                  Object var36 = BoundingBox3D.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  synchronized(BoundingBox3D.mouseRecorder.lock) {
                     if(!field878) {
                        BoundingBox3D.mouseRecorder.index = 0;
                     } else if(MouseInput.mouseLastButton != 0 || BoundingBox3D.mouseRecorder.index >= 40) {
                        var31 = class31.method285(ClientPacket.field2445, field899.field1470);
                        var31.packetBuffer.putByte(0);
                        var3 = var31.packetBuffer.offset;
                        var4 = 0;

                        for(var5 = 0; var5 < BoundingBox3D.mouseRecorder.index && var31.packetBuffer.offset - var3 < 240; ++var5) {
                           ++var4;
                           var6 = BoundingBox3D.mouseRecorder.ys[var5];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 502) {
                              var6 = 502;
                           }

                           var7 = BoundingBox3D.mouseRecorder.xs[var5];
                           if(var7 < 0) {
                              var7 = 0;
                           } else if(var7 > 764) {
                              var7 = 764;
                           }

                           var8 = var7 + var6 * 765;
                           if(BoundingBox3D.mouseRecorder.ys[var5] == -1 && BoundingBox3D.mouseRecorder.xs[var5] == -1) {
                              var7 = -1;
                              var6 = -1;
                              var8 = 524287;
                           }

                           if(var7 == field910 && var6 == field868) {
                              if(field869 < 2047) {
                                 ++field869;
                              }
                           } else {
                              var9 = var7 - field910;
                              field910 = var7;
                              var10 = var6 - field868;
                              field868 = var6;
                              if(field869 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                                 var9 += 32;
                                 var10 += 32;
                                 var31.packetBuffer.putShort(var10 + (field869 << 12) + (var9 << 6));
                                 field869 = 0;
                              } else if(field869 < 8) {
                                 var31.packetBuffer.put24bitInt((field869 << 19) + var8 + 8388608);
                                 field869 = 0;
                              } else {
                                 var31.packetBuffer.putInt((field869 << 19) + var8 + -1073741824);
                                 field869 = 0;
                              }
                           }
                        }

                        var31.packetBuffer.method3578(var31.packetBuffer.offset - var3);
                        field899.method2082(var31);
                        if(var4 >= BoundingBox3D.mouseRecorder.index) {
                           BoundingBox3D.mouseRecorder.index = 0;
                        } else {
                           BoundingBox3D.mouseRecorder.index -= var4;

                           for(var5 = 0; var5 < BoundingBox3D.mouseRecorder.index; ++var5) {
                              BoundingBox3D.mouseRecorder.xs[var5] = BoundingBox3D.mouseRecorder.xs[var5 + var4];
                              BoundingBox3D.mouseRecorder.ys[var5] = BoundingBox3D.mouseRecorder.ys[var4 + var5];
                           }
                        }
                     }
                  }

                  PacketNode var19;
                  if(MouseInput.mouseLastButton == 1 || !Enum.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
                     long var17 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis) / 50L;
                     if(var17 > 4095L) {
                        var17 = 4095L;
                     }

                     mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis;
                     var3 = MouseInput.mouseLastPressedY;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class195.canvasHeight) {
                        var3 = class195.canvasHeight;
                     }

                     var4 = MouseInput.mouseLastPressedX;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > GameEngine.canvasWidth) {
                        var4 = GameEngine.canvasWidth;
                     }

                     var5 = (int)var17;
                     var19 = class31.method285(ClientPacket.field2430, field899.field1470);
                     var19.packetBuffer.putShort((var5 << 1) + (MouseInput.mouseLastButton == 2?1:0));
                     var19.packetBuffer.putShort(var4);
                     var19.packetBuffer.putShort(var3);
                     field899.method2082(var19);
                  }

                  if(KeyFocusListener.field639 > 0) {
                     var15 = class31.method285(ClientPacket.field2376, field899.field1470);
                     var15.packetBuffer.putShort(0);
                     var16 = var15.packetBuffer.offset;
                     long var20 = PendingSpawn.currentTimeMs();

                     for(var5 = 0; var5 < KeyFocusListener.field639; ++var5) {
                        long var22 = var20 - field1072;
                        if(var22 > 16777215L) {
                           var22 = 16777215L;
                        }

                        field1072 = var20;
                        var15.packetBuffer.method3596(KeyFocusListener.field638[var5]);
                        var15.packetBuffer.put24bitInt((int)var22);
                     }

                     var15.packetBuffer.method3593(var15.packetBuffer.offset - var16);
                     field899.method2082(var15);
                  }

                  if(field934 > 0) {
                     --field934;
                  }

                  if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
                     field1120 = true;
                  }

                  if(field1120 && field934 <= 0) {
                     field934 = 20;
                     field1120 = false;
                     var15 = class31.method285(ClientPacket.field2470, field899.field1470);
                     var15.packetBuffer.putShort(cameraPitchTarget);
                     var15.packetBuffer.putShort(mapAngle);
                     field899.method2082(var15);
                  }

                  if(Parameters.field3805 && !field864) {
                     field864 = true;
                     var15 = class31.method285(ClientPacket.field2379, field899.field1470);
                     var15.packetBuffer.putByte(1);
                     field899.method2082(var15);
                  }

                  if(!Parameters.field3805 && field864) {
                     field864 = false;
                     var15 = class31.method285(ClientPacket.field2379, field899.field1470);
                     var15.packetBuffer.putByte(0);
                     field899.method2082(var15);
                  }

                  if(class248.renderOverview != null) {
                     class248.renderOverview.method6068();
                  }

                  if(class47.field588) {
                     if(WidgetNode.clanMemberManager != null) {
                        WidgetNode.clanMemberManager.method5421();
                     }

                     GrandExchangeOffer.method117();
                     class47.field588 = false;
                  }

                  int[] var32;
                  if(class36.plane != field1073) {
                     field1073 = class36.plane;
                     var1 = class36.plane;
                     var32 = class25.minimapSprite.pixels;
                     var3 = var32.length;

                     for(var4 = 0; var4 < var3; ++var4) {
                        var32[var4] = 0;
                     }

                     for(var4 = 1; var4 < 103; ++var4) {
                        var5 = (103 - var4) * 2048 + 24628;

                        for(var6 = 1; var6 < 103; ++var6) {
                           if((class62.tileSettings[var1][var6][var4] & 24) == 0) {
                              class86.region.method2996(var32, var5, 512, var1, var6, var4);
                           }

                           if(var1 < 3 && (class62.tileSettings[var1 + 1][var6][var4] & 8) != 0) {
                              class86.region.method2996(var32, var5, 512, var1 + 1, var6, var4);
                           }

                           var5 += 4;
                        }
                     }

                     var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
                     var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
                     class25.minimapSprite.method5912();

                     for(var6 = 1; var6 < 103; ++var6) {
                        for(var7 = 1; var7 < 103; ++var7) {
                           if((class62.tileSettings[var1][var7][var6] & 24) == 0) {
                              ScriptVarType.method31(var1, var7, var6, var4, var5);
                           }

                           if(var1 < 3 && (class62.tileSettings[var1 + 1][var7][var6] & 8) != 0) {
                              ScriptVarType.method31(var1 + 1, var7, var6, var4, var5);
                           }
                        }
                     }

                     field1006 = 0;

                     for(var6 = 0; var6 < 104; ++var6) {
                        for(var7 = 0; var7 < 104; ++var7) {
                           var8 = class86.region.method3084(class36.plane, var6, var7);
                           if(var8 != 0) {
                              var8 = var8 >> 14 & 32767;
                              var9 = class169.getObjectDefinition(var8).mapIconId;
                              if(var9 >= 0) {
                                 mapIcons[field1006] = Area.mapAreaType[var9].getMapIcon(false);
                                 field1075[field1006] = var6;
                                 field1064[field1006] = var7;
                                 ++field1006;
                              }
                           }
                        }
                     }

                     class20.rasterProvider.setRaster();
                  }

                  if(gameState != 30) {
                     return;
                  }

                  class5.method18();
                  MapIcon.method552();
                  ++field899.field1476;
                  if(field899.field1476 > 750) {
                     SoundTaskDataProvider.method781();
                     return;
                  }

                  var1 = class93.playerIndexesCount;
                  var32 = class93.playerIndices;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var24 = cachedPlayers[var32[var3]];
                     if(var24 != null) {
                        class171.method3367(var24, 1);
                     }
                  }

                  class190.method3548();
                  DState.method3561();
                  ++field914;
                  if(cursorState != 0) {
                     field953 += 20;
                     if(field953 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(MapLabel.field477 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        class171.method3363(MapLabel.field477);
                        MapLabel.field477 = null;
                     }
                  }

                  Widget var37 = class45.field579;
                  Widget var33 = class35.field497;
                  class45.field579 = null;
                  class35.field497 = null;
                  field1025 = null;
                  field1029 = false;
                  field1026 = false;
                  field980 = 0;

                  while(class25.method190() && field980 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && AbstractSoundSystem.field1569 == 66) {
                        String var25 = GraphicsObject.method1842();
                        class23.clientInstance.method856(var25);
                     } else if(field927 != 1 || class22.field351 <= 0) {
                        field1071[field980] = AbstractSoundSystem.field1569;
                        field1070[field980] = class22.field351;
                        ++field980;
                     }
                  }

                  boolean var34 = rights >= 2;
                  if(var34 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var4 = TotalQuantityComparator.localPlayer.field844 - mouseWheelRotation;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != TotalQuantityComparator.localPlayer.field844) {
                        class3.method8(TotalQuantityComparator.localPlayer.pathX[0] + WorldMapType1.baseX, TotalQuantityComparator.localPlayer.pathY[0] + Enum.baseY, var4, false);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     UnitPriceComparator.method126(widgetRoot, 0, 0, GameEngine.canvasWidth, class195.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var26;
                     Widget var38;
                     ScriptEvent var39;
                     do {
                        var39 = (ScriptEvent)field1018.popFront();
                        if(var39 == null) {
                           while(true) {
                              do {
                                 var39 = (ScriptEvent)field977.popFront();
                                 if(var39 == null) {
                                    while(true) {
                                       do {
                                          var39 = (ScriptEvent)field1047.popFront();
                                          if(var39 == null) {
                                             this.method1211();
                                             MapLabel.method368();
                                             if(field1021 != null) {
                                                this.method1216();
                                             }

                                             if(class160.field2147 != null) {
                                                class171.method3363(class160.field2147);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(field962) {
                                                      if(class149.field2114 == class160.field2147 && field918 != field958) {
                                                         Widget var40 = class160.field2147;
                                                         byte var35 = 0;
                                                         if(field1013 == 1 && var40.contentType == 206) {
                                                            var35 = 1;
                                                         }

                                                         if(var40.itemIds[field918] <= 0) {
                                                            var35 = 0;
                                                         }

                                                         if(class248.method4630(class85.getWidgetConfig(var40))) {
                                                            var6 = field958;
                                                            var7 = field918;
                                                            var40.itemIds[var7] = var40.itemIds[var6];
                                                            var40.itemQuantities[var7] = var40.itemQuantities[var6];
                                                            var40.itemIds[var6] = -1;
                                                            var40.itemQuantities[var6] = 0;
                                                         } else if(var35 == 1) {
                                                            var6 = field958;
                                                            var7 = field918;

                                                            while(var7 != var6) {
                                                               if(var6 > var7) {
                                                                  var40.method4585(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var40.method4585(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var40.method4585(field918, field958);
                                                         }

                                                         var19 = class31.method285(ClientPacket.field2447, field899.field1470);
                                                         var19.packetBuffer.method3596(var35);
                                                         var19.packetBuffer.method3626(class160.field2147.id);
                                                         var19.packetBuffer.method3754(field958);
                                                         var19.packetBuffer.putShort(field918);
                                                         field899.method2082(var19);
                                                      }
                                                   } else if(this.method1277()) {
                                                      this.openMenu(field1048, field960);
                                                   } else if(menuOptionCount > 0) {
                                                      var4 = field1048;
                                                      var5 = field960;
                                                      class38.method516(UrlRequester.topContextMenuRow, var4, var5);
                                                      UrlRequester.topContextMenuRow = null;
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   class160.field2147 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field1048 + 5 || MouseInput.mouseLastX < field1048 - 5 || MouseInput.mouseLastY > field960 + 5 || MouseInput.mouseLastY < field960 - 5)) {
                                                   field962 = true;
                                                }
                                             }

                                             if(Region.method3007()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                var19 = class31.method285(ClientPacket.field2460, field899.field1470);
                                                var19.packetBuffer.putByte(5);
                                                var19.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                var19.packetBuffer.method3616(var5 + Enum.baseY);
                                                var19.packetBuffer.putShort(var4 + WorldMapType1.baseX);
                                                field899.method2082(var19);
                                                Region.method2972();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field953 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var37 != class45.field579) {
                                                if(var37 != null) {
                                                   class171.method3363(var37);
                                                }

                                                if(class45.field579 != null) {
                                                   class171.method3363(class45.field579);
                                                }
                                             }

                                             if(var33 != class35.field497 && field1002 == field1001) {
                                                if(var33 != null) {
                                                   class171.method3363(var33);
                                                }

                                                if(class35.field497 != null) {
                                                   class171.method3363(class35.field497);
                                                }
                                             }

                                             if(class35.field497 != null) {
                                                if(field1001 < field1002) {
                                                   ++field1001;
                                                   if(field1001 == field1002) {
                                                      class171.method3363(class35.field497);
                                                   }
                                                }
                                             } else if(field1001 > 0) {
                                                --field1001;
                                             }

                                             class44.method629();
                                             if(field1092) {
                                                var4 = MapIcon.field530 * 128 + 64;
                                                var5 = class38.field520 * 128 + 64;
                                                var6 = class35.getTileHeight(var4, var5, class36.plane) - RunException.field2173;
                                                if(Resampler.cameraX < var4) {
                                                   Resampler.cameraX = (var4 - Resampler.cameraX) * UnitPriceComparator.field315 / 1000 + Resampler.cameraX + BoundingBox3D.field264;
                                                   if(Resampler.cameraX > var4) {
                                                      Resampler.cameraX = var4;
                                                   }
                                                }

                                                if(Resampler.cameraX > var4) {
                                                   Resampler.cameraX -= UnitPriceComparator.field315 * (Resampler.cameraX - var4) / 1000 + BoundingBox3D.field264;
                                                   if(Resampler.cameraX < var4) {
                                                      Resampler.cameraX = var4;
                                                   }
                                                }

                                                if(class49.cameraZ < var6) {
                                                   class49.cameraZ = (var6 - class49.cameraZ) * UnitPriceComparator.field315 / 1000 + class49.cameraZ + BoundingBox3D.field264;
                                                   if(class49.cameraZ > var6) {
                                                      class49.cameraZ = var6;
                                                   }
                                                }

                                                if(class49.cameraZ > var6) {
                                                   class49.cameraZ -= UnitPriceComparator.field315 * (class49.cameraZ - var6) / 1000 + BoundingBox3D.field264;
                                                   if(class49.cameraZ < var6) {
                                                      class49.cameraZ = var6;
                                                   }
                                                }

                                                if(class31.cameraY < var5) {
                                                   class31.cameraY = (var5 - class31.cameraY) * UnitPriceComparator.field315 / 1000 + class31.cameraY + BoundingBox3D.field264;
                                                   if(class31.cameraY > var5) {
                                                      class31.cameraY = var5;
                                                   }
                                                }

                                                if(class31.cameraY > var5) {
                                                   class31.cameraY -= UnitPriceComparator.field315 * (class31.cameraY - var5) / 1000 + BoundingBox3D.field264;
                                                   if(class31.cameraY < var5) {
                                                      class31.cameraY = var5;
                                                   }
                                                }

                                                var4 = class3.field17 * 128 + 64;
                                                var5 = BoundingBox3DDrawMode.field275 * 128 + 64;
                                                var6 = class35.getTileHeight(var4, var5, class36.plane) - class228.field2685;
                                                var7 = var4 - Resampler.cameraX;
                                                var8 = var6 - class49.cameraZ;
                                                var9 = var5 - class31.cameraY;
                                                var10 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
                                                int var27 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                                                int var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                                                if(var27 < 128) {
                                                   var27 = 128;
                                                }

                                                if(var27 > 383) {
                                                   var27 = 383;
                                                }

                                                if(GameCanvas.cameraPitch < var27) {
                                                   GameCanvas.cameraPitch = (var27 - GameCanvas.cameraPitch) * Tile.field1832 / 1000 + GameCanvas.cameraPitch + class61.field733;
                                                   if(GameCanvas.cameraPitch > var27) {
                                                      GameCanvas.cameraPitch = var27;
                                                   }
                                                }

                                                if(GameCanvas.cameraPitch > var27) {
                                                   GameCanvas.cameraPitch -= Tile.field1832 * (GameCanvas.cameraPitch - var27) / 1000 + class61.field733;
                                                   if(GameCanvas.cameraPitch < var27) {
                                                      GameCanvas.cameraPitch = var27;
                                                   }
                                                }

                                                int var13 = var12 - IndexDataBase.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 > 0) {
                                                   IndexDataBase.cameraYaw = IndexDataBase.cameraYaw + class61.field733 + var13 * Tile.field1832 / 1000;
                                                   IndexDataBase.cameraYaw &= 2047;
                                                }

                                                if(var13 < 0) {
                                                   IndexDataBase.cameraYaw -= -var13 * Tile.field1832 / 1000 + class61.field733;
                                                   IndexDataBase.cameraYaw &= 2047;
                                                }

                                                int var14 = var12 - IndexDataBase.cameraYaw;
                                                if(var14 > 1024) {
                                                   var14 -= 2048;
                                                }

                                                if(var14 < -1024) {
                                                   var14 += 2048;
                                                }

                                                if(var14 < 0 && var13 > 0 || var14 > 0 && var13 < 0) {
                                                   IndexDataBase.cameraYaw = var12;
                                                }
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1091[var4];
                                             }

                                             Script.chatMessages.process();
                                             var4 = NPCComposition.method5264();
                                             var5 = FaceNormal.method3137();
                                             if(var4 > 15000 && var5 > 15000) {
                                                field886 = 250;
                                                GameEngine.method983(14500);
                                                var19 = class31.method285(ClientPacket.field2455, field899.field1470);
                                                field899.method2082(var19);
                                             }

                                             ContextMenuRow.friendManager.method1704();
                                             ++field899.field1477;
                                             if(field899.field1477 > 50) {
                                                var19 = class31.method285(ClientPacket.field2451, field899.field1470);
                                                field899.method2082(var19);
                                             }

                                             try {
                                                field899.method2080();
                                             } catch (IOException var28) {
                                                SoundTaskDataProvider.method781();
                                             }

                                             return;
                                          }

                                          var26 = var39.widget;
                                          if(var26.index < 0) {
                                             break;
                                          }

                                          var38 = class5.getWidget(var26.parentId);
                                       } while(var38 == null || var38.children == null || var26.index >= var38.children.length || var26 != var38.children[var26.index]);

                                       GameCanvas.method800(var39);
                                    }
                                 }

                                 var26 = var39.widget;
                                 if(var26.index < 0) {
                                    break;
                                 }

                                 var38 = class5.getWidget(var26.parentId);
                              } while(var38 == null || var38.children == null || var26.index >= var38.children.length || var26 != var38.children[var26.index]);

                              GameCanvas.method800(var39);
                           }
                        }

                        var26 = var39.widget;
                        if(var26.index < 0) {
                           break;
                        }

                        var38 = class5.getWidget(var26.parentId);
                     } while(var38 == null || var38.children == null || var26.index >= var38.children.length || var26 != var38.children[var26.index]);

                     GameCanvas.method800(var39);
                  }
               }

               var31 = class31.method285(ClientPacket.field2388, field899.field1470);
               var31.packetBuffer.putByte(0);
               var3 = var31.packetBuffer.offset;
               FaceNormal.encodeClassVerifier(var31.packetBuffer);
               var31.packetBuffer.method3578(var31.packetBuffer.offset - var3);
               field899.method2082(var31);
            }
         }
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method1208() {
      int var1 = GameEngine.canvasWidth;
      int var2 = class195.canvasHeight;
      if(super.field678 < var1) {
         var1 = super.field678;
      }

      if(super.field691 < var2) {
         var2 = super.field691;
      }

      if(class55.preferences != null) {
         try {
            class53.method787(class23.clientInstance, "resize", new Object[]{Integer.valueOf(class29.method249())});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   final void method1312() {
      if(widgetRoot != -1) {
         class204.method3928(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field1053[var1]) {
            field1043[var1] = true;
         }

         field1055[var1] = field1053[var1];
         field1053[var1] = false;
      }

      field1052 = gameCycle;
      field999 = -1;
      field919 = -1;
      class149.field2114 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         class1.method0(widgetRoot, 0, 0, GameEngine.canvasWidth, class195.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field999 != -1) {
            var1 = field999;
            var2 = field919;
            if((menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) && field1049) {
               var3 = menuOptionCount - 1;
               String var5;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var5 = "Use" + " " + lastSelectedItemName + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var5 = field1097 + " " + field941 + " " + "->";
               } else {
                  var5 = class22.method170(var3);
               }

               if(menuOptionCount > 2) {
                  var5 = var5 + IndexFile.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               DecorativeObject.fontBold12.drawRandomizedMouseoverText(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         var1 = MouseRecorder.menuX;
         var2 = IndexDataBase.menuY;
         var3 = CombatInfoListHolder.field1289;
         int var4 = Fonts.field3877;
         int var11 = 6116423;
         Rasterizer2D.Rasterizer2D_fillRectangle(var1, var2, var3, var4, var11);
         Rasterizer2D.Rasterizer2D_fillRectangle(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         DecorativeObject.fontBold12.method5689("Choose Option", var1 + 3, var2 + 14, var11, -1);
         int var6 = MouseInput.mouseLastX;
         int var7 = MouseInput.mouseLastY;

         for(int var8 = 0; var8 < menuOptionCount; ++var8) {
            int var9 = var2 + (menuOptionCount - 1 - var8) * 15 + 31;
            int var10 = 16777215;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            DecorativeObject.fontBold12.method5689(class22.method170(var8), var1 + 3, var9, var10, 0);
         }

         LoginPacket.method3483(MouseRecorder.menuX, IndexDataBase.menuY, CombatInfoListHolder.field1289, Fonts.field3877);
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field1055[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1043[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      WorldComparator.method73(class36.plane, TotalQuantityComparator.localPlayer.x, TotalQuantityComparator.localPlayer.y, field914);
      field914 = 0;
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(Lcb;I)Z",
      garbageValue = "-1734026593"
   )
   final boolean method1210(NetWriter var1) {
      class169 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         int var20;
         String var21;
         try {
            int var5;
            if(var1.serverPacket == null) {
               if(var1.field1474) {
                  if(!var2.vmethod3383(1)) {
                     return false;
                  }

                  var2.vmethod3399(var1.packetBuffer.payload, 0, 1);
                  var1.field1476 = 0;
                  var1.field1474 = false;
               }

               var3.offset = 0;
               if(var3.method3876()) {
                  if(!var2.vmethod3383(1)) {
                     return false;
                  }

                  var2.vmethod3399(var1.packetBuffer.payload, 1, 1);
                  var1.field1476 = 0;
               }

               var1.field1474 = true;
               ServerPacket[] var4 = class245.method4619();
               var5 = var3.method3877();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.serverPacket = var4[var5];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3383(1)) {
                  return false;
               }

               var1.getSocket().vmethod3399(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3383(2)) {
                  return false;
               }

               var1.getSocket().vmethod3399(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3383(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3399(var3.payload, 0, var1.packetLength);
            var1.field1476 = 0;
            field1077.method5317();
            var1.field1480 = var1.field1479;
            var1.field1479 = var1.field1478;
            var1.field1478 = var1.serverPacket;
            if(ServerPacket.field2340 == var1.serverPacket) {
               GrandExchangeOffer.method103(var3.readString());
               var1.serverPacket = null;
               return true;
            }

            int var8;
            int var9;
            int var17;
            Widget var48;
            int var50;
            if(ServerPacket.field2305 == var1.serverPacket) {
               var17 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var17 < -70000) {
                  var5 += 32768;
               }

               if(var17 >= 0) {
                  var48 = class5.getWidget(var17);
               } else {
                  var48 = null;
               }

               for(; var3.offset < var1.packetLength; class37.setItemTableSlot(var5, var50, var8 - 1, var9)) {
                  var50 = var3.getUSmart();
                  var8 = var3.readUnsignedShort();
                  var9 = 0;
                  if(var8 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var48 != null && var50 >= 0 && var50 < var48.itemIds.length) {
                     var48.itemIds[var50] = var8;
                     var48.itemQuantities[var50] = var9;
                  }
               }

               if(var48 != null) {
                  class171.method3363(var48);
               }

               class2.method6();
               interfaceItemTriggers[++field1037 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2346 == var1.serverPacket) {
               ContextMenuRow.friendManager.method1703();
               field1041 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2338 == var1.serverPacket) {
               byte var73 = var3.readByte();
               var5 = var3.readUnsignedShort();
               class237.settings[var5] = var73;
               if(class237.widgetSettings[var5] != var73) {
                  class237.widgetSettings[var5] = var73;
               }

               class149.method3193(var5);
               field1054[++field1112 - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            WidgetNode var58;
            Widget var64;
            if(ServerPacket.field2319 == var1.serverPacket) {
               var17 = var3.method3627();
               var5 = var3.method3629();
               WidgetNode var53 = (WidgetNode)componentTable.get((long)var17);
               var58 = (WidgetNode)componentTable.get((long)var5);
               if(var58 != null) {
                  class254.method4639(var58, var53 == null || var53.id != var58.id);
               }

               if(var53 != null) {
                  var53.unlink();
                  componentTable.put(var53, (long)var5);
               }

               var64 = class5.getWidget(var17);
               if(var64 != null) {
                  class171.method3363(var64);
               }

               var64 = class5.getWidget(var5);
               if(var64 != null) {
                  class171.method3363(var64);
                  class183.method3484(Widget.widgets[var64.id >>> 16], var64, true);
               }

               if(widgetRoot != -1) {
                  var9 = widgetRoot;
                  if(class18.loadWidget(var9)) {
                     CombatInfo1.method1644(Widget.widgets[var9], 1);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2329 == var1.serverPacket) {
               field1092 = false;

               for(var17 = 0; var17 < 5; ++var17) {
                  field1093[var17] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2308 == var1.serverPacket) {
               var17 = var3.readUnsignedShort();
               var5 = var3.method3618();
               var20 = var3.readUnsignedShortOb1();
               var50 = var3.method3629();
               var64 = class5.getWidget(var50);
               if(var20 != var64.rotationX || var5 != var64.rotationZ || var17 != var64.modelZoom) {
                  var64.rotationX = var20;
                  var64.rotationZ = var5;
                  var64.modelZoom = var17;
                  class171.method3363(var64);
               }

               var1.serverPacket = null;
               return true;
            }

            String var43;
            if(ServerPacket.field2290 == var1.serverPacket) {
               var43 = var3.readString();
               Object[] var72 = new Object[var43.length() + 1];

               for(var20 = var43.length() - 1; var20 >= 0; --var20) {
                  if(var43.charAt(var20) == 's') {
                     var72[var20 + 1] = var3.readString();
                  } else {
                     var72[var20 + 1] = new Integer(var3.readInt());
                  }
               }

               var72[0] = new Integer(var3.readInt());
               ScriptEvent var52 = new ScriptEvent();
               var52.objs = var72;
               GameCanvas.method800(var52);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2306 == var1.serverPacket) {
               var17 = var3.method3618();
               var5 = var3.readInt();
               var20 = var17 >> 10 & 31;
               var50 = var17 >> 5 & 31;
               var8 = var17 & 31;
               var9 = (var50 << 11) + (var20 << 19) + (var8 << 3);
               Widget var55 = class5.getWidget(var5);
               if(var9 != var55.textColor) {
                  var55.textColor = var9;
                  class171.method3363(var55);
               }

               var1.serverPacket = null;
               return true;
            }

            int var22;
            if(ServerPacket.field2366 == var1.serverPacket) {
               field1092 = true;
               class3.field17 = var3.readUnsignedByte();
               BoundingBox3DDrawMode.field275 = var3.readUnsignedByte();
               class228.field2685 = var3.readUnsignedShort();
               class61.field733 = var3.readUnsignedByte();
               Tile.field1832 = var3.readUnsignedByte();
               if(Tile.field1832 >= 100) {
                  var17 = class3.field17 * 128 + 64;
                  var5 = BoundingBox3DDrawMode.field275 * 128 + 64;
                  var20 = class35.getTileHeight(var17, var5, class36.plane) - class228.field2685;
                  var50 = var17 - Resampler.cameraX;
                  var8 = var20 - class49.cameraZ;
                  var9 = var5 - class31.cameraY;
                  var22 = (int)Math.sqrt((double)(var9 * var9 + var50 * var50));
                  GameCanvas.cameraPitch = (int)(Math.atan2((double)var8, (double)var22) * 325.949D) & 2047;
                  IndexDataBase.cameraYaw = (int)(Math.atan2((double)var50, (double)var9) * -325.949D) & 2047;
                  if(GameCanvas.cameraPitch < 128) {
                     GameCanvas.cameraPitch = 128;
                  }

                  if(GameCanvas.cameraPitch > 383) {
                     GameCanvas.cameraPitch = 383;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            boolean var57;
            if(ServerPacket.field2312 == var1.serverPacket) {
               var57 = var3.readUnsignedByte() == 1;
               if(var57) {
                  class252.field3303 = PendingSpawn.currentTimeMs() - var3.readLong();
                  GameObject.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  GameObject.grandExchangeEvents = null;
               }

               field1044 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2327 == var1.serverPacket) {
               var17 = var3.method3627();
               var5 = var3.readUnsignedShortOb1();
               var20 = var3.readUnsignedByte();
               var58 = (WidgetNode)componentTable.get((long)var17);
               if(var58 != null) {
                  class254.method4639(var58, var5 != var58.id);
               }

               GameEngine.method985(var17, var5, var20);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               var17 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var17 < -70000) {
                  var5 += 32768;
               }

               if(var17 >= 0) {
                  var48 = class5.getWidget(var17);
               } else {
                  var48 = null;
               }

               if(var48 != null) {
                  for(var50 = 0; var50 < var48.itemIds.length; ++var50) {
                     var48.itemIds[var50] = 0;
                     var48.itemQuantities[var50] = 0;
                  }
               }

               ItemContainer var62 = (ItemContainer)ItemContainer.itemContainers.get((long)var5);
               if(var62 != null) {
                  for(var8 = 0; var8 < var62.itemIds.length; ++var8) {
                     var62.itemIds[var8] = -1;
                     var62.stackSizes[var8] = 0;
                  }
               }

               var50 = var3.readUnsignedShort();

               for(var8 = 0; var8 < var50; ++var8) {
                  var9 = var3.method3618();
                  var22 = var3.readUnsignedByte();
                  if(var22 == 255) {
                     var22 = var3.readInt();
                  }

                  if(var48 != null && var8 < var48.itemIds.length) {
                     var48.itemIds[var8] = var9;
                     var48.itemQuantities[var8] = var22;
                  }

                  class37.setItemTableSlot(var5, var8, var9 - 1, var22);
               }

               if(var48 != null) {
                  class171.method3363(var48);
               }

               class2.method6();
               interfaceItemTriggers[++field1037 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2293 == var1.serverPacket) {
               var17 = var3.readInt();
               var5 = var3.readUnsignedShort();
               var48 = class5.getWidget(var17);
               if(var48.modelType != 1 || var5 != var48.modelId) {
                  var48.modelType = 1;
                  var48.modelId = var5;
                  class171.method3363(var48);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2287 == var1.serverPacket) {
               class28.field412 = var3.method3609();
               class80.field1239 = var3.method3610();

               while(var3.offset < var1.packetLength) {
                  var17 = var3.readUnsignedByte();
                  class183[] var71 = new class183[]{class183.field2484, class183.field2483, class183.field2485, class183.field2482, class183.field2486, class183.field2487, class183.field2488, class183.field2490, class183.field2489, class183.field2491};
                  class183 var51 = var71[var17];
                  ItemContainer.method1080(var51);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2323 == var1.serverPacket) {
               FileSystem.method4665(var3, var1.packetLength);
               class27.method223();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2297 == var1.serverPacket) {
               class28.field412 = var3.method3609();
               class80.field1239 = var3.method3610();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2355 == var1.serverPacket) {
               var17 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var20 = var3.readUnsignedByte();
               var50 = var3.readUnsignedByte();
               field1093[var17] = true;
               field995[var17] = var5;
               field894[var17] = var20;
               field903[var17] = var50;
               field1091[var17] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2294 == var1.serverPacket) {
               var17 = var3.readInt();
               if(var17 != field932) {
                  field932 = var17;
                  class18.method137();
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2352 == var1.serverPacket) {
               class80.field1239 = var3.method3609();
               class28.field412 = var3.readUnsignedByte();

               for(var17 = class28.field412; var17 < class28.field412 + 8; ++var17) {
                  for(var5 = class80.field1239; var5 < class80.field1239 + 8; ++var5) {
                     if(groundItemDeque[class36.plane][var17][var5] != null) {
                        groundItemDeque[class36.plane][var17][var5] = null;
                        Size.groundItemSpawned(var17, var5);
                     }
                  }
               }

               for(PendingSpawn var47 = (PendingSpawn)pendingSpawns.getFront(); var47 != null; var47 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var47.x >= class28.field412 && var47.x < class28.field412 + 8 && var47.y >= class80.field1239 && var47.y < class80.field1239 + 8 && var47.level == class36.plane) {
                     var47.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2371 == var1.serverPacket) {
               var17 = var3.method3629();
               var5 = var3.method3618();
               var48 = class5.getWidget(var17);
               if(var48 != null && var48.type == 0) {
                  if(var5 > var48.scrollHeight - var48.height) {
                     var5 = var48.scrollHeight - var48.height;
                  }

                  if(var5 < 0) {
                     var5 = 0;
                  }

                  if(var5 != var48.scrollY) {
                     var48.scrollY = var5;
                     class171.method3363(var48);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2369 == var1.serverPacket) {
               var17 = var3.readUnsignedShort();
               if(var17 == 65535) {
                  var17 = -1;
               }

               if(var17 == -1 && !field970) {
                  class197.method3836();
               } else if(var17 != -1 && var17 != field1115 && field981 != 0 && !field970) {
                  class248.method4631(2, class154.indexTrack1, var17, 0, field981, false);
               }

               field1115 = var17;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               var17 = var3.method3658();
               var5 = var3.readUnsignedShortOb1();
               if(var5 == 65535) {
                  var5 = -1;
               }

               if(field981 != 0 && var5 != -1) {
                  MouseRecorder.method1095(class66.indexTrack2, var5, 0, field981, false);
                  field970 = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2342 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2484);
               var1.serverPacket = null;
               return true;
            }

            Widget var18;
            if(ServerPacket.field2317 == var1.serverPacket) {
               var17 = var3.method3618();
               if(var17 == 65535) {
                  var17 = -1;
               }

               var5 = var3.method3627();
               var20 = var3.method3627();
               var18 = class5.getWidget(var20);
               ItemComposition var63;
               if(!var18.hasScript) {
                  if(var17 == -1) {
                     var18.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var63 = class251.getItemDefinition(var17);
                  var18.modelType = 4;
                  var18.modelId = var17;
                  var18.rotationX = var63.xan2d;
                  var18.rotationZ = var63.yan2d;
                  var18.modelZoom = var63.zoom2d * 100 / var5;
                  class171.method3363(var18);
               } else {
                  var18.itemId = var17;
                  var18.itemQuantity = var5;
                  var63 = class251.getItemDefinition(var17);
                  var18.rotationX = var63.xan2d;
                  var18.rotationZ = var63.yan2d;
                  var18.rotationY = var63.zan2d;
                  var18.field2874 = var63.offsetX2d;
                  var18.field2875 = var63.offsetY2d;
                  var18.modelZoom = var63.zoom2d;
                  if(var63.isStackable == 1) {
                     var18.field2958 = 1;
                  } else {
                     var18.field2958 = 2;
                  }

                  if(var18.field2880 > 0) {
                     var18.modelZoom = var18.modelZoom * 32 / var18.field2880;
                  } else if(var18.originalWidth > 0) {
                     var18.modelZoom = var18.modelZoom * 32 / var18.originalWidth;
                  }

                  class171.method3363(var18);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2316 == var1.serverPacket) {
               class90.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2301 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2485);
               var1.serverPacket = null;
               return true;
            }

            String var6;
            if(ServerPacket.field2349 == var1.serverPacket) {
               var43 = var3.readString();
               var21 = PacketNode.method3492(var3, 32767);
               var6 = FontTypeFace.appendTags(class71.method1133(var21));
               class19.sendGameMessage(6, var43, var6);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2322 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2486);
               var1.serverPacket = null;
               return true;
            }

            long var12;
            long var26;
            if(ServerPacket.field2365 == var1.serverPacket) {
               var17 = var3.readInt();
               var5 = var3.readInt();
               var50 = 0;
               if(class28.field421 == null || !class28.field421.isValid()) {
                  try {
                     Iterator var60 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var60.hasNext()) {
                        GarbageCollectorMXBean var70 = (GarbageCollectorMXBean)var60.next();
                        if(var70.isValid()) {
                           class28.field421 = var70;
                           GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                           GameEngine.garbageCollectorLastCollectionTime = -1L;
                        }
                     }
                  } catch (Throwable var40) {
                     ;
                  }
               }

               if(class28.field421 != null) {
                  long var24 = PendingSpawn.currentTimeMs();
                  var26 = class28.field421.getCollectionTime();
                  if(GameEngine.garbageCollectorLastCollectionTime != -1L) {
                     var12 = var26 - GameEngine.garbageCollectorLastCollectionTime;
                     long var14 = var24 - GameEngine.garbageCollectorLastCheckTimeMs;
                     if(var14 != 0L) {
                        var50 = (int)(var12 * 100L / var14);
                     }
                  }

                  GameEngine.garbageCollectorLastCollectionTime = var26;
                  GameEngine.garbageCollectorLastCheckTimeMs = var24;
               }

               PacketNode var61 = class31.method285(ClientPacket.field2391, field899.field1470);
               var61.packetBuffer.putByte(var50);
               var61.packetBuffer.method3790(var17);
               var61.packetBuffer.method3790(var5);
               var61.packetBuffer.method3596(GameEngine.FPS);
               field899.method2082(var61);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2289 == var1.serverPacket) {
               FriendManager.method1768(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2347 == var1.serverPacket) {
               class2.method6();
               var17 = var3.method3609();
               var5 = var3.readInt();
               var20 = var3.method3583();
               skillExperiences[var17] = var5;
               boostedSkillLevels[var17] = var20;
               realSkillLevels[var17] = 1;

               for(var50 = 0; var50 < 98; ++var50) {
                  if(var5 >= class248.field3010[var50]) {
                     realSkillLevels[var17] = var50 + 2;
                  }
               }

               field1038[++field1039 - 1 & 31] = var17;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2321 == var1.serverPacket) {
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
               class90.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2348 == var1.serverPacket) {
               var17 = var3.readShort();
               var5 = var3.method3628();
               var48 = class5.getWidget(var5);
               if(var17 != var48.field2820 || var17 == -1) {
                  var48.field2820 = var17;
                  var48.field2947 = 0;
                  var48.field2948 = 0;
                  class171.method3363(var48);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2368 == var1.serverPacket) {
               var17 = var3.method3618();
               widgetRoot = var17;
               this.method1214(false);
               class29.method253(var17);
               MapLabel.method367(widgetRoot);

               for(var5 = 0; var5 < 100; ++var5) {
                  field1053[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2362 == var1.serverPacket) {
               var17 = var3.method3784();
               var5 = var3.readShort();
               var20 = var3.method3627();
               var18 = class5.getWidget(var20);
               if(var17 != var18.originalX || var5 != var18.originalY || var18.dynamicX != 0 || var18.dynamicY != 0) {
                  var18.originalX = var17;
                  var18.originalY = var5;
                  var18.dynamicX = 0;
                  var18.dynamicY = 0;
                  class171.method3363(var18);
                  this.widgetMethod0(var18);
                  if(var18.type == 0) {
                     class183.method3484(Widget.widgets[var20 >> 16], var18, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2309 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2483);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2300 == var1.serverPacket) {
               field1092 = true;
               MapIcon.field530 = var3.readUnsignedByte();
               class38.field520 = var3.readUnsignedByte();
               RunException.field2173 = var3.readUnsignedShort();
               BoundingBox3D.field264 = var3.readUnsignedByte();
               UnitPriceComparator.field315 = var3.readUnsignedByte();
               if(UnitPriceComparator.field315 >= 100) {
                  Resampler.cameraX = MapIcon.field530 * 128 + 64;
                  class31.cameraY = class38.field520 * 128 + 64;
                  class49.cameraZ = class35.getTileHeight(Resampler.cameraX, class31.cameraY, class36.plane) - RunException.field2173;
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var66;
            if(ServerPacket.field2330 == var1.serverPacket) {
               var17 = var3.method3627();
               var66 = class5.getWidget(var17);

               for(var20 = 0; var20 < var66.itemIds.length; ++var20) {
                  var66.itemIds[var20] = -1;
                  var66.itemIds[var20] = 0;
               }

               class171.method3363(var66);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2315 == var1.serverPacket) {
               for(var17 = 0; var17 < cachedPlayers.length; ++var17) {
                  if(cachedPlayers[var17] != null) {
                     cachedPlayers[var17].animation = -1;
                  }
               }

               for(var17 = 0; var17 < cachedNPCs.length; ++var17) {
                  if(cachedNPCs[var17] != null) {
                     cachedNPCs[var17].animation = -1;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2333 == var1.serverPacket) {
               World var46 = new World();
               var46.address = var3.readString();
               var46.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var46.mask = var5;
               Enum.setGameState(45);
               var2.vmethod3379();
               var2 = null;
               TotalQuantityComparator.method99(var46);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2354 == var1.serverPacket) {
               var17 = var3.method3583();
               var21 = var3.readString();
               var20 = var3.method3609();
               if(var17 >= 1 && var17 <= 8) {
                  if(var21.equalsIgnoreCase("null")) {
                     var21 = null;
                  }

                  playerOptions[var17 - 1] = var21;
                  playerOptionsPriorities[var17 - 1] = var20 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2324 == var1.serverPacket) {
               publicChatMode = var3.method3610();
               field1065 = var3.method3583();
               var1.serverPacket = null;
               return true;
            }

            long var28;
            if(ServerPacket.field2304 == var1.serverPacket) {
               var17 = var3.method3618();
               if(var17 == 65535) {
                  var17 = -1;
               }

               var5 = var3.method3629();
               var20 = var3.method3627();
               var50 = var3.readUnsignedShortOb1();
               if(var50 == 65535) {
                  var50 = -1;
               }

               for(var8 = var50; var8 <= var17; ++var8) {
                  var28 = (long)var8 + ((long)var20 << 32);
                  Node var54 = widgetFlags.get(var28);
                  if(var54 != null) {
                     var54.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var5), var28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2296 == var1.serverPacket) {
               var5 = var3.readUnsignedByte();
               class320[] var49 = new class320[]{class320.field3926, class320.field3928, class320.field3924};
               class320[] var59 = var49;
               var8 = 0;

               class320 var44;
               while(true) {
                  if(var8 >= var59.length) {
                     var44 = null;
                     break;
                  }

                  class320 var69 = var59[var8];
                  if(var5 == var69.field3927) {
                     var44 = var69;
                     break;
                  }

                  ++var8;
               }

               BoundingBox.field250 = var44;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2356 == var1.serverPacket) {
               field1080 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2320 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2491);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2367 == var1.serverPacket) {
               for(var17 = 0; var17 < class237.widgetSettings.length; ++var17) {
                  if(class237.settings[var17] != class237.widgetSettings[var17]) {
                     class237.widgetSettings[var17] = class237.settings[var17];
                     class149.method3193(var17);
                     field1054[++field1112 - 1 & 31] = var17;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2351 == var1.serverPacket) {
               var17 = var3.offset + var1.packetLength;
               var5 = var3.readUnsignedShort();
               var20 = var3.readUnsignedShort();
               if(var5 != widgetRoot) {
                  widgetRoot = var5;
                  this.method1214(false);
                  class29.method253(widgetRoot);
                  MapLabel.method367(widgetRoot);

                  for(var50 = 0; var50 < 100; ++var50) {
                     field1053[var50] = true;
                  }
               }

               WidgetNode var10;
               for(; var20-- > 0; var10.field780 = true) {
                  var50 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var10 = (WidgetNode)componentTable.get((long)var50);
                  if(var10 != null && var8 != var10.id) {
                     class254.method4639(var10, true);
                     var10 = null;
                  }

                  if(var10 == null) {
                     var10 = GameEngine.method985(var50, var8, var9);
                  }
               }

               for(var58 = (WidgetNode)componentTable.first(); var58 != null; var58 = (WidgetNode)componentTable.next()) {
                  if(var58.field780) {
                     var58.field780 = false;
                  } else {
                     class254.method4639(var58, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var17) {
                  var50 = var3.readInt();
                  var8 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var22 = var3.readInt();

                  for(int var30 = var8; var30 <= var9; ++var30) {
                     var12 = ((long)var50 << 32) + (long)var30;
                     widgetFlags.put(new IntegerNode(var22), var12);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2343 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2482);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2313 == var1.serverPacket) {
               var57 = var3.readUnsignedByte() == 1;
               var5 = var3.method3628();
               var48 = class5.getWidget(var5);
               if(var57 != var48.isHidden) {
                  var48.isHidden = var57;
                  class171.method3363(var48);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2357 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  var17 = widgetRoot;
                  if(class18.loadWidget(var17)) {
                     CombatInfo1.method1644(Widget.widgets[var17], 0);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2325 == var1.serverPacket) {
               var17 = var3.readInt();
               var21 = var3.readString();
               var48 = class5.getWidget(var17);
               if(!var21.equals(var48.text)) {
                  var48.text = var21;
                  class171.method3363(var48);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2353 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2490);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2361 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2489);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2307 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  SoundTaskDataProvider.method784(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2298 == var1.serverPacket) {
               var17 = var3.readUnsignedShortOb1();
               var5 = var3.method3628();
               var20 = var3.readUnsignedShort();
               var18 = class5.getWidget(var5);
               var18.field2881 = var17 + (var20 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2345 == var1.serverPacket) {
               if(var1.packetLength == 0) {
                  WidgetNode.clanMemberManager = null;
               } else {
                  if(WidgetNode.clanMemberManager == null) {
                     WidgetNode.clanMemberManager = new ClanMemberManager(class21.loginType, class23.clientInstance);
                  }

                  WidgetNode.clanMemberManager.method5581(var3);
               }

               field1035 = cycleCntr;
               class47.field588 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2370 == var1.serverPacket) {
               class2.method6();
               weight = var3.readShort();
               field1045 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2292 == var1.serverPacket) {
               FriendManager.method1768(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2341 == var1.serverPacket) {
               class2.method6();
               energy = var3.readUnsignedByte();
               field1045 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2332 == var1.serverPacket) {
               if(WidgetNode.clanMemberManager != null) {
                  WidgetNode.clanMemberManager.method5566(var3);
               }

               field1035 = cycleCntr;
               class47.field588 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2331 == var1.serverPacket) {
               ContextMenuRow.friendManager.method1711(var3, var1.packetLength);
               field1041 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2314 == var1.serverPacket) {
               var17 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var17] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var17] = new GrandExchangeOffer(var3, false);
               }

               field944 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2310 == var1.serverPacket) {
               for(var17 = 0; var17 < VarPlayerType.field3446; ++var17) {
                  VarPlayerType var68 = class252.method4638(var17);
                  if(var68 != null) {
                     class237.settings[var17] = 0;
                     class237.widgetSettings[var17] = 0;
                  }
               }

               class2.method6();
               field1112 += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2303 == var1.serverPacket) {
               var17 = var3.method3620();
               var5 = var3.method3629();
               class237.settings[var17] = var5;
               if(class237.widgetSettings[var17] != var5) {
                  class237.widgetSettings[var17] = var5;
               }

               class149.method3193(var17);
               field1054[++field1112 - 1 & 31] = var17;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2350 == var1.serverPacket) {
               var17 = var3.readUnsignedShortOb1();
               var5 = var3.method3628();
               var48 = class5.getWidget(var5);
               if(var48.modelType != 2 || var17 != var48.modelId) {
                  var48.modelType = 2;
                  var48.modelId = var17;
                  class171.method3363(var48);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2358 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2487);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2335 == var1.serverPacket) {
               var17 = var3.readInt();
               WidgetNode var67 = (WidgetNode)componentTable.get((long)var17);
               if(var67 != null) {
                  class254.method4639(var67, true);
               }

               if(field1014 != null) {
                  class171.method3363(field1014);
                  field1014 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            long var31;
            long var33;
            if(ServerPacket.field2318 == var1.serverPacket) {
               var43 = var3.readString();
               var31 = var3.readLong();
               var33 = (long)var3.readUnsignedShort();
               var28 = (long)var3.read24BitInt();
               Permission var11 = (Permission)MapIcon.forOrdinal(class241.method4552(), var3.readUnsignedByte());
               var12 = (var33 << 32) + var28;
               boolean var35 = false;

               for(int var56 = 0; var56 < 100; ++var56) {
                  if(field1067[var56] == var12) {
                     var35 = true;
                     break;
                  }
               }

               if(var11.field3333 && ContextMenuRow.friendManager.method1707(new Name(var43, class21.loginType))) {
                  var35 = true;
               }

               if(!var35 && myPlayerIndex == 0) {
                  field1067[field921] = var12;
                  field921 = (field921 + 1) % 100;
                  String var36 = PacketNode.method3492(var3, 32767);
                  String var16 = FontTypeFace.appendTags(class71.method1133(var36));
                  if(var11.field3338 != -1) {
                     Projectile.addChatMessage(9, GameCanvas.method796(var11.field3338) + var43, var16, class62.method1058(var31));
                  } else {
                     Projectile.addChatMessage(9, var43, var16, class62.method1058(var31));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2337 == var1.serverPacket) {
               ContextMenuRow.friendManager.field1233.method5398(var3, var1.packetLength);
               class36.method502();
               field1041 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2359 == var1.serverPacket) {
               field1069 = var3.readUnsignedShort() * 30;
               field1045 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2326 == var1.serverPacket) {
               var17 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var20 = var3.readUnsignedShort();
               class64.method1067(var17, var5, var20);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2339 == var1.serverPacket) {
               var17 = var3.method3629();
               var66 = class5.getWidget(var17);
               var66.modelType = 3;
               var66.modelId = TotalQuantityComparator.localPlayer.composition.method4519();
               class171.method3363(var66);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2288 == var1.serverPacket) {
               var43 = var3.readString();
               var31 = (long)var3.readUnsignedShort();
               var33 = (long)var3.read24BitInt();
               Permission var23 = (Permission)MapIcon.forOrdinal(class241.method4552(), var3.readUnsignedByte());
               var26 = (var31 << 32) + var33;
               boolean var37 = false;

               for(int var13 = 0; var13 < 100; ++var13) {
                  if(var26 == field1067[var13]) {
                     var37 = true;
                     break;
                  }
               }

               if(ContextMenuRow.friendManager.method1707(new Name(var43, class21.loginType))) {
                  var37 = true;
               }

               if(!var37 && myPlayerIndex == 0) {
                  field1067[field921] = var26;
                  field921 = (field921 + 1) % 100;
                  String var38 = PacketNode.method3492(var3, 32767);
                  String var39 = FontTypeFace.appendTags(class71.method1133(var38));
                  byte var15;
                  if(var23.field3339) {
                     var15 = 7;
                  } else {
                     var15 = 3;
                  }

                  if(var23.field3338 != -1) {
                     class19.sendGameMessage(var15, GameCanvas.method796(var23.field3338) + var43, var39);
                  } else {
                     class19.sendGameMessage(var15, var43, var39);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2363 == var1.serverPacket) {
               ItemContainer.method1080(class183.field2488);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2344 == var1.serverPacket) {
               var17 = var3.readUnsignedShortOb1();
               ItemContainer var65 = (ItemContainer)ItemContainer.itemContainers.get((long)var17);
               if(var65 != null) {
                  var65.unlink();
               }

               interfaceItemTriggers[++field1037 - 1 & 31] = var17 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2360 == var1.serverPacket) {
               var57 = var3.method3588();
               if(var57) {
                  if(OwnWorldComparator.field852 == null) {
                     OwnWorldComparator.field852 = new class265();
                  }
               } else {
                  OwnWorldComparator.field852 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2302 == var1.serverPacket) {
               GrandExchangeEvents.method80();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2364 == var1.serverPacket) {
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

            if(ServerPacket.field2291 == var1.serverPacket) {
               class255.method4647(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2336 == var1.serverPacket) {
               var17 = var3.getUSmart();
               boolean var45 = var3.readUnsignedByte() == 1;
               var6 = "";
               boolean var7 = false;
               if(var45) {
                  var6 = var3.readString();
                  if(ContextMenuRow.friendManager.method1707(new Name(var6, class21.loginType))) {
                     var7 = true;
                  }
               }

               String var19 = var3.readString();
               if(!var7) {
                  class19.sendGameMessage(var17, var6, var19);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2311 == var1.serverPacket) {
               var17 = var3.readUnsignedByte();
               field927 = var17;
               var1.serverPacket = null;
               return true;
            }

            ItemLayer.method2658("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1479 != null?var1.field1479.packetId:-1) + "," + (var1.field1480 != null?var1.field1480.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            GrandExchangeEvents.method80();
         } catch (IOException var41) {
            SoundTaskDataProvider.method781();
         } catch (Exception var42) {
            var21 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1479 != null?var1.field1479.packetId:-1) + "," + (var1.field1480 != null?var1.field1480.packetId:-1) + "," + var1.packetLength + "," + (TotalQuantityComparator.localPlayer.pathX[0] + WorldMapType1.baseX) + "," + (TotalQuantityComparator.localPlayer.pathY[0] + Enum.baseY) + ",";

            for(var20 = 0; var20 < var1.packetLength && var20 < 50; ++var20) {
               var21 = var21 + var3.payload[var20] + ",";
            }

            ItemLayer.method2658(var21, var42);
            GrandExchangeEvents.method80();
         }

         return true;
      }
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "929069504"
   )
   final void method1211() {
      class245.method4622();
      if(class160.field2147 == null) {
         if(field1021 == null) {
            int var2;
            int var5;
            int var6;
            int var10;
            int var11;
            label250: {
               int var1 = MouseInput.mouseLastButton;
               int var4;
               int var7;
               int var9;
               if(isMenuOpen) {
                  int var3;
                  if(var1 != 1 && (Enum.middleMouseMovesCamera || var1 != 4)) {
                     var2 = MouseInput.mouseLastX;
                     var3 = MouseInput.mouseLastY;
                     if(var2 < MouseRecorder.menuX - 10 || var2 > CombatInfoListHolder.field1289 + MouseRecorder.menuX + 10 || var3 < IndexDataBase.menuY - 10 || var3 > IndexDataBase.menuY + Fonts.field3877 + 10) {
                        isMenuOpen = false;
                        class149.method3192(MouseRecorder.menuX, IndexDataBase.menuY, CombatInfoListHolder.field1289, Fonts.field3877);
                     }
                  }

                  if(var1 == 1 || !Enum.middleMouseMovesCamera && var1 == 4) {
                     var2 = MouseRecorder.menuX;
                     var3 = IndexDataBase.menuY;
                     var4 = CombatInfoListHolder.field1289;
                     var5 = MouseInput.mouseLastPressedX;
                     var6 = MouseInput.mouseLastPressedY;
                     var7 = -1;

                     int var17;
                     for(var17 = 0; var17 < menuOptionCount; ++var17) {
                        var9 = var3 + (menuOptionCount - 1 - var17) * 15 + 31;
                        if(var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
                           var7 = var17;
                        }
                     }

                     if(var7 != -1 && var7 >= 0) {
                        var17 = menuActionParams0[var7];
                        var9 = menuActionParams1[var7];
                        var10 = menuTypes[var7];
                        var11 = menuIdentifiers[var7];
                        String var12 = menuOptions[var7];
                        String var13 = menuTargets[var7];
                        class62.menuAction(var17, var9, var10, var11, var12, var13, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                     }

                     isMenuOpen = false;
                     class149.method3192(MouseRecorder.menuX, IndexDataBase.menuY, CombatInfoListHolder.field1289, Fonts.field3877);
                  }
               } else {
                  var2 = menuOptionCount - 1;
                  if((var1 == 1 || !Enum.middleMouseMovesCamera && var1 == 4) && var2 >= 0) {
                     var4 = menuTypes[var2];
                     if(var4 == 39 || var4 == 40 || var4 == 41 || var4 == 42 || var4 == 43 || var4 == 33 || var4 == 34 || var4 == 35 || var4 == 36 || var4 == 37 || var4 == 38 || var4 == 1005) {
                        var5 = menuActionParams0[var2];
                        var6 = menuActionParams1[var2];
                        Widget var14 = class5.getWidget(var6);
                        var9 = class85.getWidgetConfig(var14);
                        boolean var8 = (var9 >> 28 & 1) != 0;
                        if(var8) {
                           break label250;
                        }

                        Object var10000 = null;
                        if(class248.method4630(class85.getWidgetConfig(var14))) {
                           break label250;
                        }
                     }
                  }

                  if((var1 == 1 || !Enum.middleMouseMovesCamera && var1 == 4) && this.method1277()) {
                     var1 = 2;
                  }

                  if((var1 == 1 || !Enum.middleMouseMovesCamera && var1 == 4) && menuOptionCount > 0 && var2 >= 0) {
                     var4 = menuActionParams0[var2];
                     var5 = menuActionParams1[var2];
                     var6 = menuTypes[var2];
                     var7 = menuIdentifiers[var2];
                     String var15 = menuOptions[var2];
                     String var16 = menuTargets[var2];
                     class62.menuAction(var4, var5, var6, var7, var15, var16, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }

                  if(var1 == 2 && menuOptionCount > 0) {
                     this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }
               }

               return;
            }

            if(class160.field2147 != null && !field962 && menuOptionCount > 0 && !this.method1277()) {
               var10 = field1048;
               var11 = field960;
               class38.method516(UrlRequester.topContextMenuRow, var10, var11);
               UrlRequester.topContextMenuRow = null;
            }

            field962 = false;
            itemPressedDuration = 0;
            if(class160.field2147 != null) {
               class171.method3363(class160.field2147);
            }

            class160.field2147 = class5.getWidget(var6);
            field958 = var5;
            field1048 = MouseInput.mouseLastPressedX;
            field960 = MouseInput.mouseLastPressedY;
            if(var2 >= 0) {
               WorldMapType1.method264(var2);
            }

            class171.method3363(class160.field2147);
         }
      }
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "67"
   )
   final boolean method1277() {
      int var1 = menuOptionCount - 1;
      return (field924 == 1 && menuOptionCount > 2 || class7.method35(var1)) && !menuBooleanArray[var1];
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-588637419"
   )
   @Export("openMenu")
   final void openMenu(int var1, int var2) {
      int var3 = DecorativeObject.fontBold12.getTextWidth("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = DecorativeObject.fontBold12.getTextWidth(class22.method170(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var3 + var5 > GameEngine.canvasWidth) {
         var5 = GameEngine.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var4 + var2 > class195.canvasHeight) {
         var6 = class195.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class86.region.method2969(class36.plane, var1, var2, false);
      isMenuOpen = true;
      MouseRecorder.menuX = var5;
      IndexDataBase.menuY = var6;
      CombatInfoListHolder.field1289 = var3;
      Fonts.field3877 = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1803139579"
   )
   final void method1214(boolean var1) {
      int var2 = widgetRoot;
      int var3 = GameEngine.canvasWidth;
      int var4 = class195.canvasHeight;
      if(class18.loadWidget(var2)) {
         MessageNode.method1128(Widget.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(Liw;I)V",
      garbageValue = "-1036287495"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class5.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = GameEngine.canvasWidth;
         var4 = class195.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      Huffman.method3509(var1, var3, var4, false);
      MessageNode.method1108(var1, var3, var4);
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1242835390"
   )
   final void method1216() {
      class171.method3363(field1021);
      ++class31.field449;
      if(field1029 && field1026) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field1023;
         var2 -= field1056;
         if(var1 < field1027) {
            var1 = field1027;
         }

         if(var1 + field1021.width > field1027 + field1022.width) {
            var1 = field1027 + field1022.width - field1021.width;
         }

         if(var2 < field1028) {
            var2 = field1028;
         }

         if(var2 + field1021.height > field1028 + field1022.height) {
            var2 = field1028 + field1022.height - field1021.height;
         }

         int var3 = var1 - field945;
         int var4 = var2 - field1031;
         int var5 = field1021.field2827;
         if(class31.field449 > field1021.field2833 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1032 = true;
         }

         int var6 = var1 - field1027 + field1022.scrollX;
         int var7 = var2 - field1028 + field1022.scrollY;
         ScriptEvent var8;
         if(field1021.field2914 != null && field1032) {
            var8 = new ScriptEvent();
            var8.widget = field1021;
            var8.field791 = var6;
            var8.field790 = var7;
            var8.objs = field1021.field2914;
            GameCanvas.method800(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(field1032) {
               if(field1021.field2841 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1021;
                  var8.field791 = var6;
                  var8.field790 = var7;
                  var8.field792 = field1025;
                  var8.objs = field1021.field2841;
                  GameCanvas.method800(var8);
               }

               if(field1025 != null) {
                  Widget var9 = field1021;
                  int var10 = class28.method226(class85.getWidgetConfig(var9));
                  Widget var15;
                  if(var10 == 0) {
                     var15 = null;
                  } else {
                     int var11 = 0;

                     while(true) {
                        if(var11 >= var10) {
                           var15 = var9;
                           break;
                        }

                        var9 = class5.getWidget(var9.parentId);
                        if(var9 == null) {
                           var15 = null;
                           break;
                        }

                        ++var11;
                     }
                  }

                  if(var15 != null) {
                     PacketNode var12 = class31.method285(ClientPacket.field2374, field899.field1470);
                     var12.packetBuffer.method3746(field1025.itemId);
                     var12.packetBuffer.putShort(field1021.itemId);
                     var12.packetBuffer.method3746(field1021.index);
                     var12.packetBuffer.method3790(field1025.id);
                     var12.packetBuffer.method3626(field1021.id);
                     var12.packetBuffer.method3616(field1025.index);
                     field899.method2082(var12);
                  }
               }
            } else if(this.method1277()) {
               this.openMenu(field1023 + field945, field1056 + field1031);
            } else if(menuOptionCount > 0) {
               int var13 = field945 + field1023;
               int var14 = field1056 + field1031;
               class38.method516(UrlRequester.topContextMenuRow, var13, var14);
               UrlRequester.topContextMenuRow = null;
            }

            field1021 = null;
         }

      } else {
         if(class31.field449 > 1) {
            field1021 = null;
         }

      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(S)Lko;",
      garbageValue = "-11323"
   )
   public Name vmethod5510() {
      return TotalQuantityComparator.localPlayer != null?TotalQuantityComparator.localPlayer.name:null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-844063813"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-608350218"
   )
   public static int method1623(CharSequence var0) {
      return class132.parseInt(var0, 10, true);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2044293033"
   )
   static int method1282(int var0) {
      MessageNode var1 = (MessageNode)class95.messages.get((long)var0);
      return var1 == null?-1:(var1.previous == class95.field1431.sentinel?-1:((MessageNode)var1.previous).id);
   }
}
