import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine implements class302 {
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = 1492071727
   )
   @Export("widgetCount")
   static int widgetCount;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 1234853395
   )
   static int field1054;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      longValue = 5597796236252295033L
   )
   static long field1092;
   @ObfuscatedName("nx")
   static boolean[] field1055;
   @ObfuscatedName("no")
   static boolean[] field1101;
   @ObfuscatedName("ni")
   static boolean[] field1056;
   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "Lce;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -602851879
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("np")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("rj")
   @ObfuscatedGetter(
      intValue = 1584099299
   )
   public static int field1053;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = -1386672905
   )
   static int field1045;
   @ObfuscatedName("oo")
   static boolean field1085;
   @ObfuscatedName("mg")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -184200351
   )
   @Export("gameDrawingMode")
   static int gameDrawingMode;
   @ObfuscatedName("nf")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("nm")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 1394035325
   )
   @Export("mouseWheelRotation")
   static int mouseWheelRotation;
   @ObfuscatedName("nb")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("rv")
   @ObfuscatedSignature(
      signature = "Lbu;"
   )
   static final class71 field1122;
   @ObfuscatedName("nq")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("mv")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Deque field1049;
   @ObfuscatedName("ov")
   @ObfuscatedGetter(
      intValue = 151434451
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = -1267929833
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 637739797
   )
   static int field1082;
   @ObfuscatedName("ro")
   static int[] field1123;
   @ObfuscatedName("rz")
   static int[] field1124;
   @ObfuscatedName("ri")
   static ArrayList field1120;
   @ObfuscatedName("ra")
   @ObfuscatedGetter(
      intValue = 854628565
   )
   static int field1121;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 761035375
   )
   static int field1018;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 268376243
   )
   static int field1075;
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -2037787477
   )
   @Export("queuedSoundEffectCount")
   static int queuedSoundEffectCount;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 1821499163
   )
   static int field1077;
   @ObfuscatedName("ol")
   @ObfuscatedGetter(
      longValue = 6771194003225185173L
   )
   static long field1074;
   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "[Lf;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("pw")
   @Export("unknownSoundValues2")
   static int[] unknownSoundValues2;
   @ObfuscatedName("ql")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static PlayerComposition field1113;
   @ObfuscatedName("pj")
   static boolean field1094;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 282014119
   )
   static int field1115;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -2142698515
   )
   static int field1083;
   @ObfuscatedName("mf")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("ps")
   @Export("queuedSoundEffectIDs")
   static int[] queuedSoundEffectIDs;
   @ObfuscatedName("pf")
   @ObfuscatedSignature(
      signature = "[Lcl;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = -1410388909
   )
   static int field1084;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = 741492831
   )
   static int field1032;
   @ObfuscatedName("mu")
   @ObfuscatedGetter(
      intValue = 1683406349
   )
   static int field881;
   @ObfuscatedName("pq")
   @Export("unknownSoundValues1")
   static int[] unknownSoundValues1;
   @ObfuscatedName("ph")
   @Export("soundLocations")
   static int[] soundLocations;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 1563498425
   )
   static int field1086;
   @ObfuscatedName("mk")
   @Export("pendingVarbitChanges")
   static int[] pendingVarbitChanges;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 1714947173
   )
   @Export("pendingVarbitCount")
   static int pendingVarbitCount;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 775348733
   )
   static int field1114;
   @ObfuscatedName("ng")
   static long[] field1069;
   @ObfuscatedName("ma")
   @Export("changedSkills")
   static int[] changedSkills;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = 1955143427
   )
   @Export("changedSkillsCount")
   static int changedSkillsCount;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 185562589
   )
   static int field987;
   @ObfuscatedName("or")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("mapIcons")
   static SpritePixels[] mapIcons;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = 1977427857
   )
   static int field1089;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = -1820766829
   )
   static int field1070;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 1538566677
   )
   static int field1046;
   @ObfuscatedName("oq")
   static int[] field1105;
   @ObfuscatedName("oh")
   static int[] field1087;
   @ObfuscatedName("qn")
   static short field1125;
   @ObfuscatedName("qy")
   static short field1100;
   @ObfuscatedName("qm")
   static short field1106;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -617024621
   )
   @Export("Viewport_xOffset")
   static int Viewport_xOffset;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 1280799455
   )
   @Export("Viewport_yOffset")
   static int Viewport_yOffset;
   @ObfuscatedName("qq")
   static short field940;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 1801453823
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("qo")
   static short field1026;
   @ObfuscatedName("qu")
   static short field1103;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 860099463
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("qi")
   static short field1102;
   @ObfuscatedName("qc")
   static short field883;
   @ObfuscatedName("pz")
   static boolean[] field860;
   @ObfuscatedName("oj")
   static int[] field1039;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 300069947
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("ox")
   static int[] field957;
   @ObfuscatedName("mz")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Deque field976;
   @ObfuscatedName("mb")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Deque field1051;
   @ObfuscatedName("qs")
   static int[] field966;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = -1088343303
   )
   static int field891;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 877664699
   )
   @Export("chatCycle")
   static int chatCycle;
   @ObfuscatedName("qp")
   static int[] field1043;
   @ObfuscatedName("qb")
   static int[] field1099;
   @ObfuscatedName("qa")
   static int[] field991;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -957250671
   )
   @Export("publicChatMode")
   static int publicChatMode;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -1172445203
   )
   static int field1067;
   @ObfuscatedName("nt")
   static String field1068;
   @ObfuscatedName("rp")
   @ObfuscatedSignature(
      signature = "Lby;"
   )
   static OwnWorldComparator field1118;
   @ObfuscatedName("nv")
   static int[] field1076;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lff;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("aq")
   static boolean field861;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1179995685
   )
   @Export("world")
   public static int world;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 2136811437
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1438536063
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("bh")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("bz")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 100634793
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -174607561
   )
   static int field1016;
   @ObfuscatedName("bc")
   static boolean field859;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1022124991
   )
   @Export("gameState")
   static int gameState;
   @ObfuscatedName("bt")
   static boolean field995;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 67520779
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      longValue = 6984858604072712713L
   )
   @Export("mouseLastLastPressedTimeMillis")
   static long mouseLastLastPressedTimeMillis;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1614522115
   )
   static int field872;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -448499255
   )
   static int field865;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -623813607
   )
   static int field866;
   @ObfuscatedName("be")
   static boolean field867;
   @ObfuscatedName("bm")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1453541973
   )
   static int field869;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1051841981
   )
   @Export("hintArrowTargetType")
   static int hintArrowTargetType;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -477345115
   )
   @Export("hintArrowNpcTargetIdx")
   static int hintArrowNpcTargetIdx;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -2003334159
   )
   @Export("hintArrowPlayerTargetIdx")
   static int hintArrowPlayerTargetIdx;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 399226479
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1518547587
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -893009185
   )
   @Export("hintArrowOffsetZ")
   static int hintArrowOffsetZ;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1750764811
   )
   @Export("hintArrowOffsetX")
   static int hintArrowOffsetX;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1612097713
   )
   @Export("hintArrowOffsetY")
   static int hintArrowOffsetY;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   @Export("playerAttackOption")
   static AttackOption playerAttackOption;
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   @Export("npcAttackOption")
   static AttackOption npcAttackOption;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 279807879
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1172359421
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -376985799
   )
   static int field882;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      longValue = -7677932609527413101L
   )
   static long field952;
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = -1643267219
   )
   static int field885;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -155450989
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -1524937241
   )
   static int field1095;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -313748731
   )
   static int field888;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 1308593157
   )
   static int field1041;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   static class158 field1050;
   @ObfuscatedName("dx")
   static byte[] field1071;
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "[Lcy;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -745170435
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("dz")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -1438777113
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ee")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   public static final NetWriter field911;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -1459662459
   )
   static int field899;
   @ObfuscatedName("eb")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ep")
   static boolean field1060;
   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static class294 field902;
   @ObfuscatedName("eh")
   @Export("fontsMap")
   static HashMap fontsMap;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 596027335
   )
   static int field904;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1419615395
   )
   static int field905;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -595376423
   )
   static int field910;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 2023998249
   )
   static int field907;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1300539371
   )
   static int field1002;
   @ObfuscatedName("fd")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("fi")
   @Export("instanceTemplateChunks")
   static int[][][] instanceTemplateChunks;
   @ObfuscatedName("fl")
   static final int[] field1109;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 742517239
   )
   static int field913;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 1437705945
   )
   static int field914;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 374466113
   )
   static int field1065;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 1148002825
   )
   static int field1107;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1894318385
   )
   static int field903;
   @ObfuscatedName("ge")
   static boolean field918;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = -2107396255
   )
   static int field919;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1578892505
   )
   @Export("cameraPitchTarget")
   static int cameraPitchTarget;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 930770023
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -1693213787
   )
   static int field922;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 2106768265
   )
   static int field923;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 183768935
   )
   static int field924;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = -1735267799
   )
   static int field925;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1770047585
   )
   static int field926;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -942147751
   )
   static int field927;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 2072012359
   )
   static int field965;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 252089455
   )
   static int field929;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -2062433811
   )
   static int field930;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -559810125
   )
   static int field931;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 1584350765
   )
   static int field858;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 1047820767
   )
   static int field933;
   @ObfuscatedName("hi")
   static boolean field934;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -701825211
   )
   static int field916;
   @ObfuscatedName("hu")
   static boolean field936;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 92845587
   )
   static int field937;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -161441497
   )
   @Export("overheadTextCount")
   static int overheadTextCount;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 704396309
   )
   static int field939;
   @ObfuscatedName("hf")
   @Export("overheadTextsX")
   static int[] overheadTextsX;
   @ObfuscatedName("hl")
   @Export("overheadTextsY")
   static int[] overheadTextsY;
   @ObfuscatedName("hm")
   @Export("overheadTextsOffsetY")
   static int[] overheadTextsOffsetY;
   @ObfuscatedName("hv")
   @Export("overheadTextsOffsetX")
   static int[] overheadTextsOffsetX;
   @ObfuscatedName("hp")
   static int[] field944;
   @ObfuscatedName("hq")
   static int[] field945;
   @ObfuscatedName("hz")
   @Export("overheadTextsCyclesRemaining")
   static int[] overheadTextsCyclesRemaining;
   @ObfuscatedName("hj")
   @Export("overheadTexts")
   static String[] overheadTexts;
   @ObfuscatedName("hw")
   static int[][] field948;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1124654007
   )
   static int field1093;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 447824889
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = 1093246555
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = 71872341
   )
   @Export("lastLeftClickX")
   static int lastLeftClickX;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -1495632705
   )
   @Export("lastLeftClickY")
   static int lastLeftClickY;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -636433745
   )
   static int field1080;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -2082551175
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("ie")
   static boolean field997;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 1774169673
   )
   @Export("mouseCrosshair")
   static int mouseCrosshair;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 1649306219
   )
   @Export("pressedItemIndex")
   static int pressedItemIndex;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1124716061
   )
   static int field959;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 315185293
   )
   static int field960;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 1293582563
   )
   static int field961;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 574905613
   )
   static int field962;
   @ObfuscatedName("iv")
   static boolean field963;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -29760891
   )
   @Export("itemPressedDuration")
   static int itemPressedDuration;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = 2123560703
   )
   @Export("myPlayerIndex")
   static int myPlayerIndex;
   @ObfuscatedName("ik")
   static boolean field964;
   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "[Lbd;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 336775081
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 322233879
   )
   static int field969;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -802664277
   )
   static int field1005;
   @ObfuscatedName("iy")
   static boolean field928;
   @ObfuscatedName("it")
   @Export("lastSelectedItemName")
   static String lastSelectedItemName;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 2119041443
   )
   @Export("playerNameMask")
   static int playerNameMask;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = 281119309
   )
   static int field972;
   @ObfuscatedName("jd")
   static int[] field973;
   @ObfuscatedName("jw")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("jk")
   @Export("playerOptions")
   static String[] playerOptions;
   @ObfuscatedName("jx")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("jf")
   static int[] field851;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = -1136751885
   )
   static int field978;
   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "[[[Lhn;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("jy")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("jc")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("jh")
   @Export("skillExperiences")
   static int[] skillExperiences;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1698726475
   )
   static int field986;
   @ObfuscatedName("jz")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = 803789639
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("kc")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("ko")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("ks")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("kq")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("kw")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("kt")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("kz")
   @Export("menuBooleanArray")
   static boolean[] menuBooleanArray;
   @ObfuscatedName("kj")
   static boolean field1111;
   @ObfuscatedName("kg")
   static boolean field1079;
   @ObfuscatedName("kl")
   static boolean field998;
   @ObfuscatedName("km")
   static boolean field1112;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = -1688766901
   )
   static int field1000;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -1850805321
   )
   static int field1001;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 796278179
   )
   static int field915;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -1327403063
   )
   static int field1072;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -1219510021
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("kp")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -653916659
   )
   static int field1008;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 411818165
   )
   static int field1009;
   @ObfuscatedName("ln")
   static String field1010;
   @ObfuscatedName("lk")
   static String field1063;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 276232757
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lf")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1688647169
   )
   static int field1014;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = 1432922367
   )
   static int field970;
   @ObfuscatedName("lb")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static Widget field1017;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -205318591
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 1453695781
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = 1917556713
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -1320762443
   )
   static int field1057;
   @ObfuscatedName("le")
   static boolean field1021;
   @ObfuscatedName("lu")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static Widget field862;
   @ObfuscatedName("lt")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("draggedWidget")
   static Widget draggedWidget;
   @ObfuscatedName("lw")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static Widget field1024;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1593807685
   )
   static int field1025;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = 585061169
   )
   static int field892;
   @ObfuscatedName("lh")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("draggedOnWidget")
   static Widget draggedOnWidget;
   @ObfuscatedName("lv")
   static boolean field1028;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = 1914959863
   )
   static int field1029;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 523841581
   )
   static int field954;
   @ObfuscatedName("li")
   static boolean field1031;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = 1708008833
   )
   static int field901;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -924515835
   )
   static int field1098;
   @ObfuscatedName("lo")
   @Export("draggingWidget")
   static boolean draggingWidget;

   static {
      field861 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      field1016 = -1;
      field859 = false;
      gameState = 0;
      field995 = true;
      gameCycle = 0;
      mouseLastLastPressedTimeMillis = 1L;
      field872 = -1;
      field865 = -1;
      field866 = -1;
      field867 = true;
      displayFps = false;
      field869 = 0;
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
      field882 = 0;
      field885 = 0;
      loginState = 0;
      field1095 = 0;
      field888 = 0;
      field1041 = 0;
      field1050 = class158.field2141;
      field1071 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      field911 = new NetWriter();
      field899 = 0;
      socketError = false;
      field1060 = true;
      field902 = new class294();
      fontsMap = new HashMap();
      field904 = 0;
      field905 = 1;
      field910 = 0;
      field907 = 1;
      field1002 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      instanceTemplateChunks = new int[4][13][13];
      field1109 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field913 = 0;
      field914 = 2301979;
      field1065 = 5063219;
      field1107 = 3353893;
      field903 = 7759444;
      field918 = false;
      field919 = 0;
      cameraPitchTarget = 128;
      mapAngle = 0;
      field922 = 0;
      field923 = 0;
      field924 = 0;
      field925 = 0;
      field926 = 0;
      field927 = 50;
      field965 = 0;
      field929 = 0;
      field930 = 0;
      field931 = 12;
      field858 = 6;
      field933 = 0;
      field934 = false;
      field916 = 0;
      field936 = false;
      field937 = 0;
      overheadTextCount = 0;
      field939 = 50;
      overheadTextsX = new int[field939];
      overheadTextsY = new int[field939];
      overheadTextsOffsetY = new int[field939];
      overheadTextsOffsetX = new int[field939];
      field944 = new int[field939];
      field945 = new int[field939];
      overheadTextsCyclesRemaining = new int[field939];
      overheadTexts = new String[field939];
      field948 = new int[104][104];
      field1093 = 0;
      screenX = -1;
      screenY = -1;
      lastLeftClickX = 0;
      lastLeftClickY = 0;
      field1080 = 0;
      cursorState = 0;
      field997 = true;
      mouseCrosshair = 0;
      pressedItemIndex = 0;
      field959 = 0;
      field960 = 0;
      field961 = 0;
      field962 = 0;
      field963 = false;
      itemPressedDuration = 0;
      myPlayerIndex = 0;
      field964 = true;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field969 = 0;
      field928 = true;
      playerNameMask = 0;
      field972 = 0;
      field973 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field851 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field978 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field986 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      menuBooleanArray = new boolean[500];
      field1111 = false;
      field1079 = false;
      field998 = false;
      field1112 = true;
      field1000 = -1;
      field1001 = -1;
      field915 = 0;
      field1072 = 50;
      itemSelectionState = 0;
      lastSelectedItemName = null;
      spellSelected = false;
      field1008 = -1;
      field1009 = -1;
      field1010 = null;
      field1063 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1014 = 0;
      field970 = 0;
      field1017 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1057 = -1;
      field1021 = false;
      field862 = null;
      draggedWidget = null;
      field1024 = null;
      field1025 = 0;
      field892 = 0;
      draggedOnWidget = null;
      field1028 = false;
      field1029 = -1;
      field954 = -1;
      field1031 = false;
      field901 = -1;
      field1098 = -1;
      draggingWidget = false;
      cycleCntr = 1;
      pendingVarbitChanges = new int[32];
      pendingVarbitCount = 0;
      interfaceItemTriggers = new int[32];
      field1032 = 0;
      changedSkills = new int[32];
      changedSkillsCount = 0;
      chatCycle = 0;
      field1045 = 0;
      field891 = 0;
      field881 = 0;
      field1046 = 0;
      field987 = 0;
      mouseWheelRotation = 0;
      field1049 = new Deque();
      field976 = new Deque();
      field1051 = new Deque();
      widgetFlags = new HashTable(512);
      widgetCount = 0;
      field1054 = -2;
      field1055 = new boolean[100];
      field1056 = new boolean[100];
      field1101 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1092 = 0L;
      isResized = true;
      field1076 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      publicChatMode = 0;
      field1067 = 0;
      field1068 = "";
      field1069 = new long[100];
      field1070 = 0;
      field1089 = 0;
      field957 = new int[128];
      field1039 = new int[128];
      field1074 = -1L;
      field1075 = -1;
      field1114 = 0;
      field1105 = new int[1000];
      field1087 = new int[1000];
      mapIcons = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1082 = 0;
      field1083 = 255;
      field1084 = -1;
      field1085 = false;
      field1086 = 127;
      field1018 = 127;
      queuedSoundEffectCount = 0;
      queuedSoundEffectIDs = new int[50];
      unknownSoundValues1 = new int[50];
      unknownSoundValues2 = new int[50];
      soundLocations = new int[50];
      audioEffects = new SoundEffect[50];
      field1094 = false;
      field860 = new boolean[5];
      field1043 = new int[5];
      field966 = new int[5];
      field991 = new int[5];
      field1099 = new int[5];
      field1100 = 256;
      field1125 = 205;
      field1102 = 256;
      field1103 = 320;
      field883 = 1;
      field1026 = 32767;
      field1106 = 1;
      field940 = 32767;
      Viewport_xOffset = 0;
      Viewport_yOffset = 0;
      viewportWidth = 0;
      viewportHeight = 0;
      scale = 0;
      field1113 = new PlayerComposition();
      field1077 = -1;
      field1115 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1118 = new OwnWorldComparator();
      field1053 = -1;
      field1120 = new ArrayList(10);
      field1121 = 0;
      field1122 = new class71();
      field1123 = new int[50];
      field1124 = new int[50];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-94772277"
   )
   protected final void vmethod1282() {
      field1092 = class289.method5267() + 500L;
      this.method1283();
      if(widgetRoot != -1) {
         this.method1483(true);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1316786070"
   )
   @Export("setUp")
   protected final void setUp() {
      ItemContainer.method1142(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
      class18.port1 = socketType == 0?43594:world + 40000;
      class18.port2 = socketType == 0?443:world + 50000;
      class47.myWorldPort = class18.port1;
      PlayerComposition.colorsToFind = class240.field2806;
      class229.colorsToReplace = class240.field2805;
      class197.field2591 = class240.field2807;
      class153.field2121 = class240.field2808;
      class2.urlRequester = new UrlRequester();
      this.setUpKeyboard();
      this.setUpMouse();
      BaseVarType.mouseWheel = this.mouseWheel();
      ScriptEvent.indexStore255 = new IndexFile(255, class167.dat2File, class167.idx255File, 500000);
      preferences = class5.method17();
      this.setUpClipboard();
      Fonts.method5551(this, BoundingBox2D.field244);
      if(socketType != 0) {
         displayFps = true;
      }

      int var1 = preferences.screenType;
      field1092 = 0L;
      if(var1 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      int var2 = isResized?2:1;
      if(var2 == 1) {
         InvType.clientInstance.method902(765, 503);
      } else {
         InvType.clientInstance.method902(7680, 2160);
      }

      if(gameState >= 25) {
         PacketNode var3 = AbstractSoundSystem.method2350(ClientPacket.field2422, field911.field1460);
         PacketBuffer var4 = var3.packetBuffer;
         int var5 = isResized?2:1;
         var4.putByte(var5);
         var3.packetBuffer.putShort(FaceNormal.canvasWidth);
         var3.packetBuffer.putShort(class19.canvasHeight);
         field911.method2135(var3);
      }

      CacheFile.friendManager = new FriendManager(DecorativeObject.loginType);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "87302511"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      class85.method1957();
      NetWriter.method2159();
      class36.method545();
      Frames.method3149();
      WidgetNode.method1151();
      if(BaseVarType.mouseWheel != null) {
         int var1 = BaseVarType.mouseWheel.useRotation();
         mouseWheelRotation = var1;
      }

      if(gameState == 0) {
         AttackOption.load();
         class155.method3236();
      } else if(gameState == 5) {
         class23.method181(this);
         AttackOption.load();
         class155.method3236();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class23.method181(this);
            this.method1280();
         } else if(gameState == 25) {
            class47.method757();
         }
      } else {
         class23.method181(this);
      }

      if(gameState == 30) {
         this.method1281();
      } else if(gameState == 40 || gameState == 45) {
         this.method1280();
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1429341575"
   )
   @Hook("clientMainLoop")
   @Export("methodDraw")
   protected final void methodDraw(boolean var1) {
      boolean var2 = DynamicObject.method2112();
      if(var2 && field1085 && Resampler.soundSystem0 != null) {
         Resampler.soundSystem0.tryFlush();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1092 && class289.method5267() > field1092) {
         var3 = isResized?2:1;
         field1092 = 0L;
         if(var3 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         int var4 = isResized?2:1;
         if(var4 == 1) {
            InvType.clientInstance.method902(765, 503);
         } else {
            InvType.clientInstance.method902(7680, 2160);
         }

         if(gameState >= 25) {
            PacketNode var5 = AbstractSoundSystem.method2350(ClientPacket.field2422, field911.field1460);
            PacketBuffer var6 = var5.packetBuffer;
            int var7 = isResized?2:1;
            var6.putByte(var7);
            var5.packetBuffer.putShort(FaceNormal.canvasWidth);
            var5.packetBuffer.putShort(class19.canvasHeight);
            field911.method2135(var5);
         }
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1055[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class90.loadingBarPercentage, class90.loadingText, var1);
      } else if(gameState == 5) {
         WorldMapDecoration.drawLoginScreen(class22.fontBold12, UnitPriceComparator.fontPlain11, class249.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            WorldMapDecoration.drawLoginScreen(class22.fontBold12, UnitPriceComparator.fontPlain11, class249.font_p12full, var1);
         } else if(gameState == 25) {
            if(field1002 == 1) {
               if(field904 > field905) {
                  field905 = field904;
               }

               var3 = (field905 * 50 - field904 * 50) / field905;
               class5.method16("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field1002 == 2) {
               if(field910 > field907) {
                  field907 = field910;
               }

               var3 = (field907 * 50 - field910 * 50) / field907 + 50;
               class5.method16("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               class5.method16("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1669();
         } else if(gameState == 40) {
            class5.method16("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class5.method16("Please wait...", false);
         }
      } else {
         WorldMapDecoration.drawLoginScreen(class22.fontBold12, UnitPriceComparator.fontPlain11, class249.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < widgetCount; ++var3) {
            if(field1056[var3]) {
               GrandExchangeOffer.rasterProvider.draw(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field1056[var3] = false;
            }
         }
      } else if(gameState > 0) {
         GrandExchangeOffer.rasterProvider.drawFull(0, 0);

         for(var3 = 0; var3 < widgetCount; ++var3) {
            field1056[var3] = false;
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1055216285"
   )
   protected final void vmethod1276() {
      if(class160.varcs.changed()) {
         class160.varcs.serialize();
      }

      if(MapLabel.mouseRecorder != null) {
         MapLabel.mouseRecorder.isRunning = false;
      }

      MapLabel.mouseRecorder = null;
      field911.close();
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var1 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

      GrandExchangeEvents.method84();
      BaseVarType.mouseWheel = null;
      if(Resampler.soundSystem0 != null) {
         Resampler.soundSystem0.shutdown();
      }

      if(MapIconReference.soundSystem1 != null) {
         MapIconReference.soundSystem1.shutdown();
      }

      if(class264.NetCache_socket != null) {
         class264.NetCache_socket.vmethod3404();
      }

      PacketNode.method3515();
      if(class2.urlRequester != null) {
         class2.urlRequester.close();
         class2.urlRequester = null;
      }

      try {
         class167.dat2File.close();

         for(int var3 = 0; var3 < class250.idxCount; ++var3) {
            class7.idxFiles[var3].close();
         }

         class167.idx255File.close();
         class167.randomDat.close();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "594976712"
   )
   protected final void vmethod1271() {
   }

   @Export("init")
   @ObfuscatedName("init")
   public final void init() {
      try {
         if(this.isValidHost()) {
            Parameters[] var1 = class86.method1964();

            int var6;
            for(int var2 = 0; var2 < var1.length; ++var2) {
               Parameters var3 = var1[var2];
               String var4 = this.getParameter(var3.key);
               if(var4 != null) {
                  switch(Integer.parseInt(var3.key)) {
                  case 1:
                     class23.sessionToken = var4;
                     break;
                  case 2:
                     if(var4.equalsIgnoreCase("true")) {
                        isMembers = true;
                     } else {
                        isMembers = false;
                     }
                     break;
                  case 3:
                     MapIcon.field531 = var4;
                     break;
                  case 4:
                     field1060 = Integer.parseInt(var4) != 0;
                     break;
                  case 5:
                     if(var4.equalsIgnoreCase("true")) {
                        ;
                     }
                     break;
                  case 6:
                     world = Integer.parseInt(var4);
                     break;
                  case 7:
                     if(field1016 == -1) {
                        field1016 = Integer.parseInt(var4);
                     }
                     break;
                  case 8:
                     socketType = Integer.parseInt(var4);
                     break;
                  case 9:
                     var6 = Integer.parseInt(var4);
                     BuildType[] var7 = new BuildType[]{BuildType.BUILD_LIVE, BuildType.WIP, BuildType.LIVE, BuildType.RC};
                     BuildType[] var8 = var7;
                     int var9 = 0;

                     BuildType var26;
                     while(true) {
                        if(var9 >= var8.length) {
                           var26 = null;
                           break;
                        }

                        BuildType var10 = var8[var9];
                        if(var6 == var10.field3349) {
                           var26 = var10;
                           break;
                        }

                        ++var9;
                     }

                     class90.field1348 = var26;
                     break;
                  case 10:
                     languageId = Integer.parseInt(var4);
                     break;
                  case 11:
                     JagexGame[] var5 = new JagexGame[]{JagexGame.field3350, JagexGame.field3357, JagexGame.field3352, JagexGame.field3355, JagexGame.field3354, JagexGame.field3353};
                     TotalQuantityComparator.field296 = (JagexGame)class185.forOrdinal(var5, Integer.parseInt(var4));
                     if(TotalQuantityComparator.field296 == JagexGame.field3355) {
                        DecorativeObject.loginType = JagexLoginType.field4069;
                     } else {
                        DecorativeObject.loginType = JagexLoginType.field4068;
                     }
                  case 12:
                  case 14:
                  case 15:
                  default:
                     break;
                  case 13:
                     class190.field2515 = Integer.parseInt(var4);
                     break;
                  case 16:
                     flags = Integer.parseInt(var4);
                  }
               }
            }

            WidgetNode.method1152();
            class185.host = this.getCodeBase().getHost();
            String var21 = class90.field1348.identifier;
            byte var22 = 0;

            try {
               class250.idxCount = 17;
               OwnWorldComparator.field847 = var22;

               try {
                  class339.osName = System.getProperty("os.name");
               } catch (Exception var17) {
                  class339.osName = "Unknown";
               }

               class167.osNameLC = class339.osName.toLowerCase();

               try {
                  class167.userHome = System.getProperty("user.home");
                  if(class167.userHome != null) {
                     class167.userHome = class167.userHome + "/";
                  }
               } catch (Exception var16) {
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
               } catch (Exception var15) {
                  ;
               }

               if(class167.userHome == null) {
                  class167.userHome = "~/";
               }

               WorldMapDecoration.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class167.userHome, "/tmp/", ""};
               PendingSpawn.field1134 = new String[]{".jagex_cache_" + OwnWorldComparator.field847, ".file_store_" + OwnWorldComparator.field847};

               int var11;
               label165:
               for(var11 = 0; var11 < 4; ++var11) {
                  VertexNormal.field1912 = class93.method2023("oldschool", var21, var11);
                  if(!VertexNormal.field1912.exists()) {
                     VertexNormal.field1912.mkdirs();
                  }

                  File[] var24 = VertexNormal.field1912.listFiles();
                  if(var24 == null) {
                     break;
                  }

                  File[] var27 = var24;
                  var6 = 0;

                  while(true) {
                     if(var6 >= var27.length) {
                        break label165;
                     }

                     File var28 = var27[var6];
                     if(!BoundingBox.method50(var28, false)) {
                        break;
                     }

                     ++var6;
                  }
               }

               class110.method2375(VertexNormal.field1912);

               try {
                  File var23 = new File(class167.userHome, "random.dat");
                  int var13;
                  if(var23.exists()) {
                     class167.randomDat = new CacheFile(new FileOnDisk(var23, "rw", 25L), 24, 0);
                  } else {
                     label145:
                     for(int var12 = 0; var12 < PendingSpawn.field1134.length; ++var12) {
                        for(var13 = 0; var13 < WorldMapDecoration.cacheLocations.length; ++var13) {
                           File var14 = new File(WorldMapDecoration.cacheLocations[var13] + PendingSpawn.field1134[var12] + File.separatorChar + "random.dat");
                           if(var14.exists()) {
                              class167.randomDat = new CacheFile(new FileOnDisk(var14, "rw", 25L), 24, 0);
                              break label145;
                           }
                        }
                     }
                  }

                  if(class167.randomDat == null) {
                     RandomAccessFile var25 = new RandomAccessFile(var23, "rw");
                     var13 = var25.read();
                     var25.seek(0L);
                     var25.write(var13);
                     var25.seek(0L);
                     var25.close();
                     class167.randomDat = new CacheFile(new FileOnDisk(var23, "rw", 25L), 24, 0);
                  }
               } catch (IOException var18) {
                  ;
               }

               class167.dat2File = new CacheFile(new FileOnDisk(class151.method3201("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
               class167.idx255File = new CacheFile(new FileOnDisk(class151.method3201("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
               class7.idxFiles = new CacheFile[class250.idxCount];

               for(var11 = 0; var11 < class250.idxCount; ++var11) {
                  class7.idxFiles[var11] = new CacheFile(new FileOnDisk(class151.method3201("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
               }
            } catch (Exception var19) {
               class253.processClientError((String)null, var19);
            }

            InvType.clientInstance = this;
            RunException.field2170 = field1016;
            this.initialize(765, 503, 169);
         }
      } catch (RuntimeException var20) {
         throw WorldComparator.method75(var20, "client.init(" + ')');
      }
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "36"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = WorldComparator.method76();
         if(!var1) {
            this.method1657();
         }

      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "293287158"
   )
   void method1657() {
      if(class264.field3420 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class264.field3415 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field882 = 3000;
            class264.field3415 = 3;
         }

         if(--field882 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class183.socket = GameEngine.taskManager.createSocket(class185.host, class47.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class183.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class183.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  if(field1060) {
                     Socket var2 = (Socket)class183.socket.value;
                     class171 var1 = new class171(var2, 40000, 5000);
                     class25.rssocket = var1;
                  } else {
                     class25.rssocket = new class173((Socket)class183.socket.value, GameEngine.taskManager, 5000);
                  }

                  Buffer var11 = new Buffer(5);
                  var11.putByte(15);
                  var11.putInt(169);
                  class25.rssocket.vmethod3411(var11.payload, 0, 5);
                  ++js5State;
                  field952 = class289.method5267();
               }

               if(js5State == 3) {
                  if(class25.rssocket.vmethod3406() > 0 || !field1060 && gameState <= 5) {
                     int var5 = class25.rssocket.vmethod3405();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  } else if(class289.method5267() - field952 > 30000L) {
                     this.error(-2);
                     return;
                  }
               }

               if(js5State == 4) {
                  class169 var12 = class25.rssocket;
                  boolean var6 = gameState > 20;
                  if(class264.NetCache_socket != null) {
                     try {
                        class264.NetCache_socket.vmethod3404();
                     } catch (Exception var9) {
                        ;
                     }

                     class264.NetCache_socket = null;
                  }

                  class264.NetCache_socket = var12;
                  class19.sendConInfo(var6);
                  class264.NetCache_responseHeaderBuffer.offset = 0;
                  Buffer.currentRequest = null;
                  Frames.NetCache_responseArchiveBuffer = null;
                  class264.field3423 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class264.NetCache_pendingPriorityResponses.first();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class264.NetCache_pendingResponses.first();
                           if(var3 == null) {
                              if(class264.field3419 != 0) {
                                 try {
                                    Buffer var13 = new Buffer(4);
                                    var13.putByte(4);
                                    var13.putByte(class264.field3419);
                                    var13.putShort(0);
                                    class264.NetCache_socket.vmethod3411(var13.payload, 0, 4);
                                 } catch (IOException var8) {
                                    try {
                                       class264.NetCache_socket.vmethod3404();
                                    } catch (Exception var7) {
                                       ;
                                    }

                                    ++class264.field3415;
                                    class264.NetCache_socket = null;
                                 }
                              }

                              class264.field3403 = 0;
                              class264.field3404 = class289.method5267();
                              class183.socket = null;
                              class25.rssocket = null;
                              js5State = 0;
                              field885 = 0;
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

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1090754497"
   )
   @Export("error")
   void error(int var1) {
      class183.socket = null;
      class25.rssocket = null;
      js5State = 0;
      if(class47.myWorldPort == class18.port1) {
         class47.myWorldPort = class18.port2;
      } else {
         class47.myWorldPort = class18.port1;
      }

      ++field885;
      if(field885 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field882 = 3000;
         }
      } else if(field885 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field885 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field882 = 3000;
         }
      }

   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2123044369"
   )
   final void method1280() {
      Object var1 = field911.getSocket();
      PacketBuffer var2 = field911.packetBuffer;

      try {
         if(loginState == 0) {
            if(var1 != null) {
               ((class169)var1).vmethod3404();
               var1 = null;
            }

            Spotanim.field3497 = null;
            socketError = false;
            field1095 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(Spotanim.field3497 == null) {
               Spotanim.field3497 = GameEngine.taskManager.createSocket(class185.host, class47.myWorldPort);
            }

            if(Spotanim.field3497.status == 2) {
               throw new IOException();
            }

            if(Spotanim.field3497.status == 1) {
               if(field1060) {
                  Socket var4 = (Socket)Spotanim.field3497.value;
                  class171 var3 = new class171(var4, 40000, 5000);
                  var1 = var3;
               } else {
                  var1 = new class173((Socket)Spotanim.field3497.value, GameEngine.taskManager, 5000);
               }

               field911.setSocket((class169)var1);
               Spotanim.field3497 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            field911.method2133();
            PacketNode var20;
            if(PacketNode.field2491 == 0) {
               var20 = new PacketNode();
            } else {
               var20 = PacketNode.packetBufferNodes[--PacketNode.field2491];
            }

            var20.clientPacket = null;
            var20.field2487 = 0;
            var20.packetBuffer = new PacketBuffer(5000);
            var20.packetBuffer.putByte(LoginPacket.field2465.id);
            field911.method2135(var20);
            field911.method2134();
            var2.offset = 0;
            loginState = 3;
         }

         boolean var11;
         int var12;
         if(loginState == 3) {
            if(Resampler.soundSystem0 != null) {
               Resampler.soundSystem0.method2299();
            }

            if(MapIconReference.soundSystem1 != null) {
               MapIconReference.soundSystem1.method2299();
            }

            var11 = true;
            if(field1060 && !((class169)var1).vmethod3407(1)) {
               var11 = false;
            }

            if(var11) {
               var12 = ((class169)var1).vmethod3405();
               if(Resampler.soundSystem0 != null) {
                  Resampler.soundSystem0.method2299();
               }

               if(MapIconReference.soundSystem1 != null) {
                  MapIconReference.soundSystem1.method2299();
               }

               if(var12 != 0) {
                  class28.method242(var12);
                  return;
               }

               var2.offset = 0;
               loginState = 4;
            }
         }

         int var25;
         if(loginState == 4) {
            if(var2.offset < 8) {
               var25 = ((class169)var1).vmethod3406();
               if(var25 > 8 - var2.offset) {
                  var25 = 8 - var2.offset;
               }

               if(var25 > 0) {
                  ((class169)var1).vmethod3426(var2.payload, var2.offset, var25);
                  var2.offset += var25;
               }
            }

            if(var2.offset == 8) {
               var2.offset = 0;
               class64.field749 = var2.readLong();
               loginState = 5;
            }
         }

         if(loginState == 5) {
            field911.packetBuffer.offset = 0;
            field911.method2133();
            PacketBuffer var18 = new PacketBuffer(500);
            int[] var21 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class64.field749 >> 32), (int)(class64.field749 & -1L)};
            var18.offset = 0;
            var18.putByte(1);
            var18.putByte(field1050.rsOrdinal());
            var18.putInt(var21[0]);
            var18.putInt(var21[1]);
            var18.putInt(var21[2]);
            var18.putInt(var21[3]);
            switch(field1050.field2140) {
            case 0:
            case 3:
               var18.put24bitInt(class21.field338);
               var18.offset += 5;
               break;
            case 1:
               var18.putInt(((Integer)preferences.preferences.get(Integer.valueOf(IndexStoreActionHandler.method4752(class90.username)))).intValue());
               var18.offset += 4;
               break;
            case 2:
               var18.offset += 8;
            }

            var18.putString(class90.password);
            var18.encryptRsa(class88.field1327, class88.field1324);
            PacketNode var6;
            if(PacketNode.field2491 == 0) {
               var6 = new PacketNode();
            } else {
               var6 = PacketNode.packetBufferNodes[--PacketNode.field2491];
            }

            var6.clientPacket = null;
            var6.field2487 = 0;
            var6.packetBuffer = new PacketBuffer(5000);
            var6.packetBuffer.offset = 0;
            if(gameState == 40) {
               var6.packetBuffer.putByte(LoginPacket.field2468.id);
            } else {
               var6.packetBuffer.putByte(LoginPacket.field2470.id);
            }

            var6.packetBuffer.putShort(0);
            int var13 = var6.packetBuffer.offset;
            var6.packetBuffer.putInt(169);
            var6.packetBuffer.putBytes(var18.payload, 0, var18.offset);
            int var8 = var6.packetBuffer.offset;
            var6.packetBuffer.putString(class90.username);
            var6.packetBuffer.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            var6.packetBuffer.putShort(FaceNormal.canvasWidth);
            var6.packetBuffer.putShort(class19.canvasHeight);
            Tile.method2777(var6.packetBuffer);
            var6.packetBuffer.putString(class23.sessionToken);
            var6.packetBuffer.putInt(class190.field2515);
            Buffer var9 = new Buffer(class153.platformInfo.method6288());
            class153.platformInfo.method6281(var9);
            var6.packetBuffer.putBytes(var9.payload, 0, var9.payload.length);
            var6.packetBuffer.putByte(field1016);
            var6.packetBuffer.putInt(0);
            var6.packetBuffer.putInt(MouseInput.indexInterfaces.crc);
            var6.packetBuffer.putInt(CombatInfoListHolder.indexSoundEffects.crc);
            var6.packetBuffer.putInt(configsIndex.crc);
            var6.packetBuffer.putInt(class7.indexCache3.crc);
            var6.packetBuffer.putInt(class27.indexCache4.crc);
            var6.packetBuffer.putInt(SoundTaskDataProvider.indexMaps.crc);
            var6.packetBuffer.putInt(class7.indexTrack1.crc);
            var6.packetBuffer.putInt(class28.indexModels.crc);
            var6.packetBuffer.putInt(UnitPriceComparator.indexSprites.crc);
            var6.packetBuffer.putInt(WorldMapRectangle.indexTextures.crc);
            var6.packetBuffer.putInt(Occluder.indexCache10.crc);
            var6.packetBuffer.putInt(class190.indexTrack2.crc);
            var6.packetBuffer.putInt(MapIcon.indexScripts.crc);
            var6.packetBuffer.putInt(class36.indexCache13.crc);
            var6.packetBuffer.putInt(class228.vorbisIndex.crc);
            var6.packetBuffer.putInt(KeyFocusListener.indexCache15.crc);
            var6.packetBuffer.putInt(MapLabel.indexWorldMap.crc);
            var6.packetBuffer.encryptXtea(var21, var8, var6.packetBuffer.offset);
            var6.packetBuffer.method3594(var6.packetBuffer.offset - var13);
            field911.method2135(var6);
            field911.method2134();
            field911.field1460 = new ISAACCipher(var21);

            for(int var10 = 0; var10 < 4; ++var10) {
               var21[var10] += 50;
            }

            var2.seed(var21);
            loginState = 6;
         }

         if(loginState == 6 && ((class169)var1).vmethod3406() > 0) {
            var25 = ((class169)var1).vmethod3405();
            if(var25 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var25 == 2) {
               loginState = 9;
            } else if(var25 == 15 && gameState == 40) {
               field911.packetLength = -1;
               loginState = 13;
            } else if(var25 == 23 && field888 < 1) {
               ++field888;
               loginState = 0;
            } else {
               if(var25 != 29) {
                  class28.method242(var25);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ((class169)var1).vmethod3406() > 0) {
            field1041 = (((class169)var1).vmethod3405() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field1095 = 0;
            VerticalAlignment.method4829("You have only just left another world.", "Your profile will be transferred in:", field1041 / 60 + " seconds.");
            if(--field1041 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && ((class169)var1).vmethod3406() >= 13) {
               var11 = ((class169)var1).vmethod3405() == 1;
               ((class169)var1).vmethod3426(var2.payload, 0, 4);
               var2.offset = 0;
               boolean var26 = false;
               if(var11) {
                  var12 = var2.readOpcode() << 24;
                  var12 |= var2.readOpcode() << 16;
                  var12 |= var2.readOpcode() << 8;
                  var12 |= var2.readOpcode();
                  int var14 = IndexStoreActionHandler.method4752(class90.username);
                  if(preferences.preferences.size() >= 10 && !preferences.preferences.containsKey(Integer.valueOf(var14))) {
                     Iterator var24 = preferences.preferences.entrySet().iterator();
                     var24.next();
                     var24.remove();
                  }

                  preferences.preferences.put(Integer.valueOf(var14), Integer.valueOf(var12));
               }

               if(class90.Login_isUsernameRemembered) {
                  preferences.rememberedUsername = class90.username;
               } else {
                  preferences.rememberedUsername = null;
               }

               Widget.method4541();
               rights = ((class169)var1).vmethod3405();
               field1021 = ((class169)var1).vmethod3405() == 1;
               localInteractingIndex = ((class169)var1).vmethod3405();
               localInteractingIndex <<= 8;
               localInteractingIndex += ((class169)var1).vmethod3405();
               field969 = ((class169)var1).vmethod3405();
               ((class169)var1).vmethod3426(var2.payload, 0, 1);
               var2.offset = 0;
               ServerPacket[] var5 = class163.method3298();
               int var15 = var2.method3860();
               if(var15 < 0 || var15 >= var5.length) {
                  throw new IOException(var15 + " " + var2.offset);
               }

               field911.serverPacket = var5[var15];
               field911.packetLength = field911.serverPacket.packetLength;
               ((class169)var1).vmethod3426(var2.payload, 0, 2);
               var2.offset = 0;
               field911.packetLength = var2.readUnsignedShort();

               try {
                  class53.method833(InvType.clientInstance, "zap");
               } catch (Throwable var16) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(((class169)var1).vmethod3406() >= field911.packetLength) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3426(var2.payload, 0, field911.packetLength);
                  field902.method5275();
                  Spotanim.method4910();
                  PendingSpawn.initializeGPI(var2);
                  class169.field2206 = -1;
                  MapLabel.xteaChanged(false, var2);
                  field911.serverPacket = null;
               }

            } else {
               if(loginState == 11 && ((class169)var1).vmethod3406() >= 2) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3426(var2.payload, 0, 2);
                  var2.offset = 0;
                  RunException.field2173 = var2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ((class169)var1).vmethod3406() >= RunException.field2173) {
                  var2.offset = 0;
                  ((class169)var1).vmethod3426(var2.payload, 0, RunException.field2173);
                  var2.offset = 0;
                  String var19 = var2.readString();
                  String var23 = var2.readString();
                  String var22 = var2.readString();
                  VerticalAlignment.method4829(var19, var23, var22);
                  class55.setGameState(10);
               }

               if(loginState == 13) {
                  if(field911.packetLength == -1) {
                     if(((class169)var1).vmethod3406() < 2) {
                        return;
                     }

                     ((class169)var1).vmethod3426(var2.payload, 0, 2);
                     var2.offset = 0;
                     field911.packetLength = var2.readUnsignedShort();
                  }

                  if(((class169)var1).vmethod3406() >= field911.packetLength) {
                     ((class169)var1).vmethod3426(var2.payload, 0, field911.packetLength);
                     var2.offset = 0;
                     var25 = field911.packetLength;
                     field902.method5277();
                     class5.method15();
                     PendingSpawn.initializeGPI(var2);
                     if(var25 != var2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field1095;
                  if(field1095 > 2000) {
                     if(field888 < 1) {
                        if(class47.myWorldPort == class18.port1) {
                           class47.myWorldPort = class18.port2;
                        } else {
                           class47.myWorldPort = class18.port1;
                        }

                        ++field888;
                        loginState = 0;
                     } else {
                        class28.method242(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var17) {
         if(field888 < 1) {
            if(class18.port1 == class47.myWorldPort) {
               class47.myWorldPort = class18.port2;
            } else {
               class47.myWorldPort = class18.port1;
            }

            ++field888;
            loginState = 0;
         } else {
            class28.method242(-2);
         }
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1205392465"
   )
   final void method1281() {
      if(field869 > 1) {
         --field869;
      }

      if(field899 > 0) {
         --field899;
      }

      if(socketError) {
         socketError = false;
         class28.method240();
      } else {
         if(!isMenuOpen) {
            Signlink.method3322();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.method1309(field911); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class326.classInfos.last();
               boolean var29;
               if(var2 == null) {
                  var29 = false;
               } else {
                  var29 = true;
               }

               int var3;
               PacketNode var30;
               if(!var29) {
                  PacketNode var14;
                  int var15;
                  if(field902.field3819) {
                     var14 = AbstractSoundSystem.method2350(ClientPacket.field2437, field911.field1460);
                     var14.packetBuffer.putByte(0);
                     var15 = var14.packetBuffer.offset;
                     field902.method5278(var14.packetBuffer);
                     var14.packetBuffer.method3749(var14.packetBuffer.offset - var15);
                     field911.method2135(var14);
                     field902.method5276();
                  }

                  Object var34 = MapLabel.mouseRecorder.lock;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  int var10;
                  synchronized(MapLabel.mouseRecorder.lock) {
                     if(!field861) {
                        MapLabel.mouseRecorder.index = 0;
                     } else if(MouseInput.mouseLastButton != 0 || MapLabel.mouseRecorder.index >= 40) {
                        var30 = AbstractSoundSystem.method2350(ClientPacket.field2370, field911.field1460);
                        var30.packetBuffer.putByte(0);
                        var3 = var30.packetBuffer.offset;
                        var4 = 0;

                        for(var5 = 0; var5 < MapLabel.mouseRecorder.index && var30.packetBuffer.offset - var3 < 240; ++var5) {
                           ++var4;
                           var6 = MapLabel.mouseRecorder.ys[var5];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 502) {
                              var6 = 502;
                           }

                           var7 = MapLabel.mouseRecorder.xs[var5];
                           if(var7 < 0) {
                              var7 = 0;
                           } else if(var7 > 764) {
                              var7 = 764;
                           }

                           var8 = var6 * 765 + var7;
                           if(MapLabel.mouseRecorder.ys[var5] == -1 && MapLabel.mouseRecorder.xs[var5] == -1) {
                              var7 = -1;
                              var6 = -1;
                              var8 = 524287;
                           }

                           if(var7 == field872 && var6 == field865) {
                              if(field866 < 2047) {
                                 ++field866;
                              }
                           } else {
                              var9 = var7 - field872;
                              field872 = var7;
                              var10 = var6 - field865;
                              field865 = var6;
                              if(field866 < 8 && var9 >= -32 && var9 <= 31 && var10 >= -32 && var10 <= 31) {
                                 var9 += 32;
                                 var10 += 32;
                                 var30.packetBuffer.putShort(var10 + (field866 << 12) + (var9 << 6));
                                 field866 = 0;
                              } else if(field866 < 8) {
                                 var30.packetBuffer.put24bitInt((field866 << 19) + var8 + 8388608);
                                 field866 = 0;
                              } else {
                                 var30.packetBuffer.putInt((field866 << 19) + var8 + -1073741824);
                                 field866 = 0;
                              }
                           }
                        }

                        var30.packetBuffer.method3749(var30.packetBuffer.offset - var3);
                        field911.method2135(var30);
                        if(var4 >= MapLabel.mouseRecorder.index) {
                           MapLabel.mouseRecorder.index = 0;
                        } else {
                           MapLabel.mouseRecorder.index -= var4;

                           for(var5 = 0; var5 < MapLabel.mouseRecorder.index; ++var5) {
                              MapLabel.mouseRecorder.xs[var5] = MapLabel.mouseRecorder.xs[var4 + var5];
                              MapLabel.mouseRecorder.ys[var5] = MapLabel.mouseRecorder.ys[var5 + var4];
                           }
                        }
                     }
                  }

                  if(MouseInput.mouseLastButton == 1 || !Occluder.middleMouseMovesCamera && MouseInput.mouseLastButton == 4 || MouseInput.mouseLastButton == 2) {
                     long var16 = (MouseInput.mouseLastPressedTimeMillis - mouseLastLastPressedTimeMillis * -1L) / 50L;
                     if(var16 > 4095L) {
                        var16 = 4095L;
                     }

                     mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis * -1L;
                     var3 = MouseInput.mouseLastPressedY;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > class19.canvasHeight) {
                        var3 = class19.canvasHeight;
                     }

                     var4 = MouseInput.mouseLastPressedX;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > FaceNormal.canvasWidth) {
                        var4 = FaceNormal.canvasWidth;
                     }

                     var5 = (int)var16;
                     PacketNode var18 = AbstractSoundSystem.method2350(ClientPacket.field2373, field911.field1460);
                     var18.packetBuffer.putShort((var5 << 1) + (MouseInput.mouseLastButton == 2?1:0));
                     var18.packetBuffer.putShort(var4);
                     var18.packetBuffer.putShort(var3);
                     field911.method2135(var18);
                  }

                  if(KeyFocusListener.field626 > 0) {
                     var14 = AbstractSoundSystem.method2350(ClientPacket.field2447, field911.field1460);
                     var14.packetBuffer.putShort(0);
                     var15 = var14.packetBuffer.offset;
                     long var19 = class289.method5267();

                     for(var5 = 0; var5 < KeyFocusListener.field626; ++var5) {
                        long var21 = var19 - field1074;
                        if(var21 > 16777215L) {
                           var21 = 16777215L;
                        }

                        field1074 = var19;
                        var14.packetBuffer.method3641((int)var21);
                        var14.packetBuffer.method3624(KeyFocusListener.field625[var5]);
                     }

                     var14.packetBuffer.method3594(var14.packetBuffer.offset - var15);
                     field911.method2135(var14);
                  }

                  if(field916 > 0) {
                     --field916;
                  }

                  if(KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97] || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
                     field936 = true;
                  }

                  if(field936 && field916 <= 0) {
                     field916 = 20;
                     field936 = false;
                     var14 = AbstractSoundSystem.method2350(ClientPacket.field2409, field911.field1460);
                     var14.packetBuffer.method3634(mapAngle);
                     var14.packetBuffer.method3633(cameraPitchTarget);
                     field911.method2135(var14);
                  }

                  if(GameCanvas.field643 && !field867) {
                     field867 = true;
                     var14 = AbstractSoundSystem.method2350(ClientPacket.field2385, field911.field1460);
                     var14.packetBuffer.putByte(1);
                     field911.method2135(var14);
                  }

                  if(!GameCanvas.field643 && field867) {
                     field867 = false;
                     var14 = AbstractSoundSystem.method2350(ClientPacket.field2385, field911.field1460);
                     var14.packetBuffer.putByte(0);
                     field911.method2135(var14);
                  }

                  if(class196.renderOverview != null) {
                     class196.renderOverview.method6124();
                  }

                  class49.method773();
                  class46.method708();
                  if(gameState != 30) {
                     return;
                  }

                  class45.method673();

                  for(var1 = 0; var1 < queuedSoundEffectCount; ++var1) {
                     --unknownSoundValues2[var1];
                     if(unknownSoundValues2[var1] >= -10) {
                        SoundEffect var31 = audioEffects[var1];
                        if(var31 == null) {
                           Object var10000 = null;
                           var31 = SoundEffect.getTrack(class27.indexCache4, queuedSoundEffectIDs[var1], 0);
                           if(var31 == null) {
                              continue;
                           }

                           unknownSoundValues2[var1] += var31.calculateDelay();
                           audioEffects[var1] = var31;
                        }

                        if(unknownSoundValues2[var1] < 0) {
                           if(soundLocations[var1] != 0) {
                              var4 = (soundLocations[var1] & 255) * 128;
                              var5 = soundLocations[var1] >> 16 & 255;
                              var6 = var5 * 128 + 64 - class265.localPlayer.x;
                              if(var6 < 0) {
                                 var6 = -var6;
                              }

                              var7 = soundLocations[var1] >> 8 & 255;
                              var8 = var7 * 128 + 64 - class265.localPlayer.y;
                              if(var8 < 0) {
                                 var8 = -var8;
                              }

                              var9 = var8 + var6 - 128;
                              if(var9 > var4) {
                                 unknownSoundValues2[var1] = -100;
                                 continue;
                              }

                              if(var9 < 0) {
                                 var9 = 0;
                              }

                              var3 = (var4 - var9) * field1018 / var4;
                           } else {
                              var3 = field1086;
                           }

                           if(var3 > 0) {
                              RawAudioNode var23 = var31.method2231().applyResampler(class18.field320);
                              class115 var24 = class115.method2398(var23, 100, var3);
                              var24.method2401(unknownSoundValues1[var1] - 1);
                              BoundingBox2D.field238.method2166(var24);
                           }

                           unknownSoundValues2[var1] = -100;
                        }
                     } else {
                        --queuedSoundEffectCount;

                        for(var15 = var1; var15 < queuedSoundEffectCount; ++var15) {
                           queuedSoundEffectIDs[var15] = queuedSoundEffectIDs[var15 + 1];
                           audioEffects[var15] = audioEffects[var15 + 1];
                           unknownSoundValues1[var15] = unknownSoundValues1[var15 + 1];
                           unknownSoundValues2[var15] = unknownSoundValues2[var15 + 1];
                           soundLocations[var15] = soundLocations[var15 + 1];
                        }

                        --var1;
                     }
                  }

                  if(field1085) {
                     if(class229.field2694 != 0) {
                        var29 = true;
                     } else {
                        var29 = class38.field507.method4242();
                     }

                     if(!var29) {
                        if(field1083 != 0 && field1084 != -1) {
                           MilliTimer.method3279(class7.indexTrack1, field1084, 0, field1083, false);
                        }

                        field1085 = false;
                     }
                  }

                  ++field911.field1465;
                  if(field911.field1465 > 750) {
                     class28.method240();
                     return;
                  }

                  NPCComposition.method5206();
                  FileSystem.method4637();
                  int[] var35 = class93.playerIndices;

                  for(var15 = 0; var15 < class93.playerIndexesCount; ++var15) {
                     Player var25 = cachedPlayers[var35[var15]];
                     if(var25 != null && var25.overheadTextCyclesRemaining > 0) {
                        --var25.overheadTextCyclesRemaining;
                        if(var25.overheadTextCyclesRemaining == 0) {
                           var25.overhead = null;
                        }
                     }
                  }

                  for(var15 = 0; var15 < npcIndexesCount; ++var15) {
                     var3 = npcIndices[var15];
                     NPC var37 = cachedNPCs[var3];
                     if(var37 != null && var37.overheadTextCyclesRemaining > 0) {
                        --var37.overheadTextCyclesRemaining;
                        if(var37.overheadTextCyclesRemaining == 0) {
                           var37.overhead = null;
                        }
                     }
                  }

                  ++field913;
                  if(cursorState != 0) {
                     field1080 += 20;
                     if(field1080 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(BoundingBox2D.field241 != null) {
                     ++mouseCrosshair;
                     if(mouseCrosshair >= 15) {
                        TotalQuantityComparator.method100(BoundingBox2D.field241);
                        BoundingBox2D.field241 = null;
                     }
                  }

                  Widget var36 = GameCanvas.field642;
                  Widget var32 = FrameMap.field1950;
                  GameCanvas.field642 = null;
                  FrameMap.field1950 = null;
                  draggedOnWidget = null;
                  field1031 = false;
                  field1028 = false;
                  field1089 = 0;

                  while(class298.method5361() && field1089 < 128) {
                     if(rights >= 2 && KeyFocusListener.keyPressed[82] && class303.currentPressedKey == 66) {
                        String var40 = class19.method162();
                        InvType.clientInstance.method905(var40);
                     } else if(field926 != 1 || BoundingBox2D.currentTypedKey <= 0) {
                        field1039[field1089] = class303.currentPressedKey;
                        field957[field1089] = BoundingBox2D.currentTypedKey;
                        ++field1089;
                     }
                  }

                  if(class44.method670() && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81] && mouseWheelRotation != 0) {
                     var3 = class265.localPlayer.field831 - mouseWheelRotation;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > 3) {
                        var3 = 3;
                     }

                     if(var3 != class265.localPlayer.field831) {
                        MapIcon.method596(class265.localPlayer.pathX[0] + ClientPacket.baseX, class265.localPlayer.pathY[0] + MapIconReference.baseY, var3, false);
                     }

                     mouseWheelRotation = 0;
                  }

                  if(widgetRoot != -1) {
                     var3 = widgetRoot;
                     var4 = FaceNormal.canvasWidth;
                     var5 = class19.canvasHeight;
                     if(class85.loadWidget(var3)) {
                        WorldMapRectangle.method248(GZipDecompressor.widgets[var3], -1, 0, 0, var4, var5, 0, 0);
                     }
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var38;
                     Widget var39;
                     ScriptEvent var42;
                     do {
                        var42 = (ScriptEvent)field976.popFront();
                        if(var42 == null) {
                           while(true) {
                              do {
                                 var42 = (ScriptEvent)field1051.popFront();
                                 if(var42 == null) {
                                    while(true) {
                                       do {
                                          var42 = (ScriptEvent)field1049.popFront();
                                          if(var42 == null) {
                                             this.method1675();
                                             if(class196.renderOverview != null) {
                                                class196.renderOverview.method6077(ScriptVarType.plane, (class265.localPlayer.x >> 7) + ClientPacket.baseX, (class265.localPlayer.y >> 7) + MapIconReference.baseY, false);
                                                class196.renderOverview.method6177();
                                             }

                                             if(draggedWidget != null) {
                                                this.method1291();
                                             }

                                             PacketNode var41;
                                             if(KeyFocusListener.field635 != null) {
                                                TotalQuantityComparator.method100(KeyFocusListener.field635);
                                                ++itemPressedDuration;
                                                if(MouseInput.mouseCurrentButton == 0) {
                                                   if(field963) {
                                                      if(KeyFocusListener.field635 == FileOnDisk.field1676 && field959 != field962) {
                                                         Widget var43 = KeyFocusListener.field635;
                                                         byte var33 = 0;
                                                         if(field970 == 1 && var43.contentType == 206) {
                                                            var33 = 1;
                                                         }

                                                         if(var43.itemIds[field962] <= 0) {
                                                            var33 = 0;
                                                         }

                                                         if(GrandExchangeEvents.method81(class1.getWidgetClickMask(var43))) {
                                                            var5 = field959;
                                                            var6 = field962;
                                                            var43.itemIds[var6] = var43.itemIds[var5];
                                                            var43.itemQuantities[var6] = var43.itemQuantities[var5];
                                                            var43.itemIds[var5] = -1;
                                                            var43.itemQuantities[var5] = 0;
                                                         } else if(var33 == 1) {
                                                            var5 = field959;
                                                            var6 = field962;

                                                            while(var5 != var6) {
                                                               if(var5 > var6) {
                                                                  var43.method4554(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var43.method4554(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var43.method4554(field962, field959);
                                                         }

                                                         var41 = AbstractSoundSystem.method2350(ClientPacket.field2404, field911.field1460);
                                                         var41.packetBuffer.putByte(var33);
                                                         var41.packetBuffer.method3736(KeyFocusListener.field635.id);
                                                         var41.packetBuffer.method3633(field959);
                                                         var41.packetBuffer.method3634(field962);
                                                         field911.method2135(var41);
                                                      }
                                                   } else if(this.method1287()) {
                                                      this.openMenu(field960, field961);
                                                   } else if(menuOptionCount > 0) {
                                                      ScriptState.method1130(field960, field961);
                                                   }

                                                   mouseCrosshair = 10;
                                                   MouseInput.mouseLastButton = 0;
                                                   KeyFocusListener.field635 = null;
                                                } else if(itemPressedDuration >= 5 && (MouseInput.mouseLastX > field960 + 5 || MouseInput.mouseLastX < field960 - 5 || MouseInput.mouseLastY > field961 + 5 || MouseInput.mouseLastY < field961 - 5)) {
                                                   field963 = true;
                                                }
                                             }

                                             if(Region.method2961()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                var41 = AbstractSoundSystem.method2350(ClientPacket.field2389, field911.field1460);
                                                var41.packetBuffer.putByte(5);
                                                var41.packetBuffer.putShort(var4 + MapIconReference.baseY);
                                                var41.packetBuffer.method3634(var3 + ClientPacket.baseX);
                                                var41.packetBuffer.method3624(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
                                                field911.method2135(var41);
                                                Region.method2986();
                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                cursorState = 1;
                                                field1080 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var36 != GameCanvas.field642) {
                                                if(var36 != null) {
                                                   TotalQuantityComparator.method100(var36);
                                                }

                                                if(GameCanvas.field642 != null) {
                                                   TotalQuantityComparator.method100(GameCanvas.field642);
                                                }
                                             }

                                             if(var32 != FrameMap.field1950 && field915 == field1072) {
                                                if(var32 != null) {
                                                   TotalQuantityComparator.method100(var32);
                                                }

                                                if(FrameMap.field1950 != null) {
                                                   TotalQuantityComparator.method100(FrameMap.field1950);
                                                }
                                             }

                                             if(FrameMap.field1950 != null) {
                                                if(field915 < field1072) {
                                                   ++field915;
                                                   if(field915 == field1072) {
                                                      TotalQuantityComparator.method100(FrameMap.field1950);
                                                   }
                                                }
                                             } else if(field915 > 0) {
                                                --field915;
                                             }

                                             class25.method191();
                                             if(field1094) {
                                                var3 = MapIconReference.field590 * 128 + 64;
                                                var4 = UnitPriceComparator.field315 * 128 + 64;
                                                var5 = GrandExchangeEvent.getTileHeight(var3, var4, ScriptVarType.plane) - World.field1224;
                                                if(UrlRequest.cameraX < var3) {
                                                   UrlRequest.cameraX = (var3 - UrlRequest.cameraX) * ScriptState.field742 / 1000 + UrlRequest.cameraX + class265.field3431;
                                                   if(UrlRequest.cameraX > var3) {
                                                      UrlRequest.cameraX = var3;
                                                   }
                                                }

                                                if(UrlRequest.cameraX > var3) {
                                                   UrlRequest.cameraX -= ScriptState.field742 * (UrlRequest.cameraX - var3) / 1000 + class265.field3431;
                                                   if(UrlRequest.cameraX < var3) {
                                                      UrlRequest.cameraX = var3;
                                                   }
                                                }

                                                if(class86.cameraZ < var5) {
                                                   class86.cameraZ = (var5 - class86.cameraZ) * ScriptState.field742 / 1000 + class86.cameraZ + class265.field3431;
                                                   if(class86.cameraZ > var5) {
                                                      class86.cameraZ = var5;
                                                   }
                                                }

                                                if(class86.cameraZ > var5) {
                                                   class86.cameraZ -= ScriptState.field742 * (class86.cameraZ - var5) / 1000 + class265.field3431;
                                                   if(class86.cameraZ < var5) {
                                                      class86.cameraZ = var5;
                                                   }
                                                }

                                                if(Signlink.cameraY < var4) {
                                                   Signlink.cameraY = (var4 - Signlink.cameraY) * ScriptState.field742 / 1000 + Signlink.cameraY + class265.field3431;
                                                   if(Signlink.cameraY > var4) {
                                                      Signlink.cameraY = var4;
                                                   }
                                                }

                                                if(Signlink.cameraY > var4) {
                                                   Signlink.cameraY -= ScriptState.field742 * (Signlink.cameraY - var4) / 1000 + class265.field3431;
                                                   if(Signlink.cameraY < var4) {
                                                      Signlink.cameraY = var4;
                                                   }
                                                }

                                                var3 = class19.field325 * 128 + 64;
                                                var4 = class7.field233 * 128 + 64;
                                                var5 = GrandExchangeEvent.getTileHeight(var3, var4, ScriptVarType.plane) - class23.field354;
                                                var6 = var3 - UrlRequest.cameraX;
                                                var7 = var5 - class86.cameraZ;
                                                var8 = var4 - Signlink.cameraY;
                                                var9 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
                                                var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                int var26 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                if(var10 < 128) {
                                                   var10 = 128;
                                                }

                                                if(var10 > 383) {
                                                   var10 = 383;
                                                }

                                                if(class18.cameraPitch < var10) {
                                                   class18.cameraPitch = (var10 - class18.cameraPitch) * GrandExchangeOffer.field311 / 1000 + class18.cameraPitch + class265.field3432;
                                                   if(class18.cameraPitch > var10) {
                                                      class18.cameraPitch = var10;
                                                   }
                                                }

                                                if(class18.cameraPitch > var10) {
                                                   class18.cameraPitch -= GrandExchangeOffer.field311 * (class18.cameraPitch - var10) / 1000 + class265.field3432;
                                                   if(class18.cameraPitch < var10) {
                                                      class18.cameraPitch = var10;
                                                   }
                                                }

                                                int var12 = var26 - class33.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 > 0) {
                                                   class33.cameraYaw = class33.cameraYaw + class265.field3432 + var12 * GrandExchangeOffer.field311 / 1000;
                                                   class33.cameraYaw &= 2047;
                                                }

                                                if(var12 < 0) {
                                                   class33.cameraYaw -= -var12 * GrandExchangeOffer.field311 / 1000 + class265.field3432;
                                                   class33.cameraYaw &= 2047;
                                                }

                                                int var13 = var26 - class33.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                   class33.cameraYaw = var26;
                                                }
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1099[var3];
                                             }

                                             class160.varcs.process();
                                             var3 = class21.method168();
                                             var4 = class47.method755();
                                             if(var3 > 15000 && var4 > 15000) {
                                                field899 = 250;
                                                MouseInput.mouseIdleTicks = 14500;
                                                var41 = AbstractSoundSystem.method2350(ClientPacket.field2451, field911.field1460);
                                                field911.method2135(var41);
                                             }

                                             CacheFile.friendManager.method1785();
                                             ++field911.field1466;
                                             if(field911.field1466 > 50) {
                                                var41 = AbstractSoundSystem.method2350(ClientPacket.field2383, field911.field1460);
                                                field911.method2135(var41);
                                             }

                                             try {
                                                field911.method2134();
                                             } catch (IOException var27) {
                                                class28.method240();
                                             }

                                             return;
                                          }

                                          var38 = var42.source;
                                          if(var38.index < 0) {
                                             break;
                                          }

                                          var39 = UnitPriceComparator.getWidget(var38.parentId);
                                       } while(var39 == null || var39.children == null || var38.index >= var39.children.length || var38 != var39.children[var38.index]);

                                       class71.method1203(var42);
                                    }
                                 }

                                 var38 = var42.source;
                                 if(var38.index < 0) {
                                    break;
                                 }

                                 var39 = UnitPriceComparator.getWidget(var38.parentId);
                              } while(var39 == null || var39.children == null || var38.index >= var39.children.length || var38 != var39.children[var38.index]);

                              class71.method1203(var42);
                           }
                        }

                        var38 = var42.source;
                        if(var38.index < 0) {
                           break;
                        }

                        var39 = UnitPriceComparator.getWidget(var38.parentId);
                     } while(var39 == null || var39.children == null || var38.index >= var39.children.length || var38 != var39.children[var38.index]);

                     class71.method1203(var42);
                  }
               }

               var30 = AbstractSoundSystem.method2350(ClientPacket.field2418, field911.field1460);
               var30.packetBuffer.putByte(0);
               var3 = var30.packetBuffer.offset;
               SoundTaskDataProvider.encodeClassVerifier(var30.packetBuffer);
               var30.packetBuffer.method3749(var30.packetBuffer.offset - var3);
               field911.method2135(var30);
            }
         }
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1714741646"
   )
   void method1283() {
      int var1 = FaceNormal.canvasWidth;
      int var2 = class19.canvasHeight;
      if(super.field681 < var1) {
         var1 = super.field681;
      }

      if(super.field684 < var2) {
         var2 = super.field684;
      }

      if(preferences != null) {
         try {
            Client var3 = InvType.clientInstance;
            int var4 = isResized?2:1;
            Object[] var5 = new Object[]{Integer.valueOf(var4)};
            JSObject.getWindow(var3).call("resize", var5);
         } catch (Throwable var6) {
            ;
         }
      }

   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "131998733"
   )
   final void method1669() {
      if(widgetRoot != -1) {
         UnitPriceComparator.method142(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < widgetCount; ++var1) {
         if(field1055[var1]) {
            field1056[var1] = true;
         }

         field1101[var1] = field1055[var1];
         field1055[var1] = false;
      }

      field1054 = gameCycle;
      field1000 = -1;
      field1001 = -1;
      FileOnDisk.field1676 = null;
      if(widgetRoot != -1) {
         widgetCount = 0;
         class276.method4980(widgetRoot, 0, 0, FaceNormal.canvasWidth, class19.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field1000 != -1) {
            var1 = field1000;
            var2 = field1001;
            if((menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) && field1112) {
               var3 = class57.method878();
               String var12;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var12 = "Use" + " " + lastSelectedItemName + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var12 = field1010 + " " + field1063 + " " + "->";
               } else {
                  var12 = Huffman.method3524(var3);
               }

               if(menuOptionCount > 2) {
                  var12 = var12 + DynamicObject.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class22.fontBold12.drawRandomizedMouseoverText(var12, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         class49.method788();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < widgetCount; ++var1) {
            if(field1101[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1056[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = ScriptVarType.plane;
      var2 = class265.localPlayer.x;
      var3 = class265.localPlayer.y;
      int var4 = field913;

      for(class80 var5 = (class80)class80.field1247.getFront(); var5 != null; var5 = (class80)class80.field1247.getNext()) {
         if(var5.field1248 != -1 || var5.field1254 != null) {
            int var6 = 0;
            if(var2 > var5.field1253) {
               var6 += var2 - var5.field1253;
            } else if(var2 < var5.field1245) {
               var6 += var5.field1245 - var2;
            }

            if(var3 > var5.field1250) {
               var6 += var3 - var5.field1250;
            } else if(var3 < var5.field1246) {
               var6 += var5.field1246 - var3;
            }

            if(var6 - 64 <= var5.field1249 && field1018 != 0 && var1 == var5.field1243) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               int var7 = (var5.field1249 - var6) * field1018 / var5.field1249;
               Object var10000;
               if(var5.field1251 == null) {
                  if(var5.field1248 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.getTrack(class27.indexCache4, var5.field1248, 0);
                     if(var8 != null) {
                        RawAudioNode var9 = var8.method2231().applyResampler(class18.field320);
                        class115 var10 = class115.method2398(var9, 100, var7);
                        var10.method2401(-1);
                        BoundingBox2D.field238.method2166(var10);
                        var5.field1251 = var10;
                     }
                  }
               } else {
                  var5.field1251.method2532(var7);
               }

               if(var5.field1244 == null) {
                  if(var5.field1254 != null && (var5.field1255 -= var4) <= 0) {
                     int var13 = (int)(Math.random() * (double)var5.field1254.length);
                     var10000 = null;
                     SoundEffect var14 = SoundEffect.getTrack(class27.indexCache4, var5.field1254[var13], 0);
                     if(var14 != null) {
                        RawAudioNode var15 = var14.method2231().applyResampler(class18.field320);
                        class115 var11 = class115.method2398(var15, 100, var7);
                        var11.method2401(0);
                        BoundingBox2D.field238.method2166(var11);
                        var5.field1244 = var11;
                        var5.field1255 = var5.field1252 + (int)(Math.random() * (double)(var5.field1256 - var5.field1252));
                     }
                  }
               } else {
                  var5.field1244.method2532(var7);
                  if(!var5.field1244.linked()) {
                     var5.field1244 = null;
                  }
               }
            } else {
               if(var5.field1251 != null) {
                  BoundingBox2D.field238.method2167(var5.field1251);
                  var5.field1251 = null;
               }

               if(var5.field1244 != null) {
                  BoundingBox2D.field238.method2167(var5.field1244);
                  var5.field1244 = null;
               }
            }
         }
      }

      field913 = 0;
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(Lcq;B)Z",
      garbageValue = "2"
   )
   final boolean method1309(NetWriter var1) {
      class169 var2 = var1.getSocket();
      PacketBuffer var3 = var1.packetBuffer;
      if(var2 == null) {
         return false;
      } else {
         int var6;
         String var19;
         try {
            int var5;
            if(var1.serverPacket == null) {
               if(var1.field1461) {
                  if(!var2.vmethod3407(1)) {
                     return false;
                  }

                  var2.vmethod3426(var1.packetBuffer.payload, 0, 1);
                  var1.field1465 = 0;
                  var1.field1461 = false;
               }

               var3.offset = 0;
               if(var3.method3854()) {
                  if(!var2.vmethod3407(1)) {
                     return false;
                  }

                  var2.vmethod3426(var1.packetBuffer.payload, 1, 1);
                  var1.field1465 = 0;
               }

               var1.field1461 = true;
               ServerPacket[] var4 = class163.method3298();
               var5 = var3.method3860();
               if(var5 < 0 || var5 >= var4.length) {
                  throw new IOException(var5 + " " + var3.offset);
               }

               var1.serverPacket = var4[var5];
               var1.packetLength = var1.serverPacket.packetLength;
            }

            if(var1.packetLength == -1) {
               if(!var2.vmethod3407(1)) {
                  return false;
               }

               var1.getSocket().vmethod3426(var3.payload, 0, 1);
               var1.packetLength = var3.payload[0] & 255;
            }

            if(var1.packetLength == -2) {
               if(!var2.vmethod3407(2)) {
                  return false;
               }

               var1.getSocket().vmethod3426(var3.payload, 0, 2);
               var3.offset = 0;
               var1.packetLength = var3.readUnsignedShort();
            }

            if(!var2.vmethod3407(var1.packetLength)) {
               return false;
            }

            var3.offset = 0;
            var2.vmethod3426(var3.payload, 0, var1.packetLength);
            var1.field1465 = 0;
            field902.method5272();
            var1.field1458 = var1.field1468;
            var1.field1468 = var1.field1467;
            var1.field1467 = var1.serverPacket;
            int var17;
            Widget var43;
            if(ServerPacket.field2296 == var1.serverPacket) {
               var17 = var3.method3635();
               var5 = var3.method3627();
               var6 = var3.method3646();
               var43 = UnitPriceComparator.getWidget(var6);
               var43.field2907 = var5 + (var17 << 16);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2305 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2476);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2359 == var1.serverPacket) {
               MapLabel.xteaChanged(true, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2314 == var1.serverPacket) {
               field1082 = var3.readUnsignedByte();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2287 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2474);
               var1.serverPacket = null;
               return true;
            }

            boolean var60;
            if(ServerPacket.field2313 == var1.serverPacket) {
               var60 = var3.method3605();
               if(var60) {
                  if(class19.field326 == null) {
                     class19.field326 = new class265();
                  }
               } else {
                  class19.field326 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var8;
            int var18;
            if(ServerPacket.field2353 == var1.serverPacket) {
               var17 = var3.method3635();
               var5 = var3.method3646();
               var6 = var3.method3627();
               var18 = var3.method3627();
               var8 = UnitPriceComparator.getWidget(var5);
               if(var17 != var8.rotationX || var6 != var8.rotationZ || var18 != var8.modelZoom) {
                  var8.rotationX = var17;
                  var8.rotationZ = var6;
                  var8.modelZoom = var18;
                  TotalQuantityComparator.method100(var8);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2288 == var1.serverPacket) {
               MapLabel.xteaChanged(false, var1.packetBuffer);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2317 == var1.serverPacket) {
               var17 = var3.method3636();
               if(var17 == 65535) {
                  var17 = -1;
               }

               var5 = var3.method3646();
               var6 = var3.readInt();
               var43 = UnitPriceComparator.getWidget(var5);
               ItemComposition var46;
               if(!var43.hasScript) {
                  if(var17 == -1) {
                     var43.modelType = 0;
                     var1.serverPacket = null;
                     return true;
                  }

                  var46 = NetWriter.getItemDefinition(var17);
                  var43.modelType = 4;
                  var43.modelId = var17;
                  var43.rotationX = var46.xan2d;
                  var43.rotationZ = var46.yan2d;
                  var43.modelZoom = var46.zoom2d * 100 / var6;
                  TotalQuantityComparator.method100(var43);
               } else {
                  var43.itemId = var17;
                  var43.itemQuantity = var6;
                  var46 = NetWriter.getItemDefinition(var17);
                  var43.rotationX = var46.xan2d;
                  var43.rotationZ = var46.yan2d;
                  var43.rotationY = var46.zan2d;
                  var43.offsetX2d = var46.offsetX2d;
                  var43.offsetY2d = var46.offsetY2d;
                  var43.modelZoom = var46.zoom2d;
                  if(var46.isStackable == 1) {
                     var43.field2879 = 1;
                  } else {
                     var43.field2879 = 2;
                  }

                  if(var43.field2876 > 0) {
                     var43.modelZoom = var43.modelZoom * 32 / var43.field2876;
                  } else if(var43.originalWidth > 0) {
                     var43.modelZoom = var43.modelZoom * 32 / var43.originalWidth;
                  }

                  TotalQuantityComparator.method100(var43);
               }

               var1.serverPacket = null;
               return true;
            }

            Widget var54;
            if(ServerPacket.field2290 == var1.serverPacket) {
               var17 = var3.method3647();
               var54 = UnitPriceComparator.getWidget(var17);
               var54.modelType = 3;
               var54.modelId = class265.localPlayer.composition.method4496();
               TotalQuantityComparator.method100(var54);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2328 == var1.serverPacket) {
               if(widgetRoot != -1) {
                  GraphicsObject.method1920(widgetRoot, 0);
               }

               var1.serverPacket = null;
               return true;
            }

            int var9;
            int var10;
            int var21;
            Widget var52;
            if(ServerPacket.field2315 == var1.serverPacket) {
               var17 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var17 < -70000) {
                  var5 += 32768;
               }

               if(var17 >= 0) {
                  var52 = UnitPriceComparator.getWidget(var17);
               } else {
                  var52 = null;
               }

               if(var52 != null) {
                  for(var18 = 0; var18 < var52.itemIds.length; ++var18) {
                     var52.itemIds[var18] = 0;
                     var52.itemQuantities[var18] = 0;
                  }
               }

               Renderable.method3142(var5);
               var18 = var3.readUnsignedShort();

               for(var21 = 0; var21 < var18; ++var21) {
                  var9 = var3.method3626();
                  if(var9 == 255) {
                     var9 = var3.method3645();
                  }

                  var10 = var3.method3627();
                  if(var52 != null && var21 < var52.itemIds.length) {
                     var52.itemIds[var21] = var10;
                     var52.itemQuantities[var21] = var9;
                  }

                  WorldMapData.setItemTableSlot(var5, var21, var10 - 1, var9);
               }

               if(var52 != null) {
                  TotalQuantityComparator.method100(var52);
               }

               GroundObject.method2767();
               interfaceItemTriggers[++field1032 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            String var40;
            String var59;
            if(ServerPacket.field2301 == var1.serverPacket) {
               var40 = var3.readString();
               var19 = ScriptState.method1131(var3, 32767);
               var59 = FontTypeFace.appendTags(UnitPriceComparator.method138(var19));
               ChatPlayer.sendGameMessage(6, var40, var59);
               var1.serverPacket = null;
               return true;
            }

            long var22;
            long var24;
            if(ServerPacket.field2277 == var1.serverPacket) {
               var40 = var3.readString();
               var22 = (long)var3.readUnsignedShort();
               var24 = (long)var3.read24BitInt();
               Permission var26 = (Permission)class185.forOrdinal(TextureProvider.method2688(), var3.readUnsignedByte());
               long var27 = (var22 << 32) + var24;
               boolean var12 = false;

               for(int var13 = 0; var13 < 100; ++var13) {
                  if(var27 == field1069[var13]) {
                     var12 = true;
                     break;
                  }
               }

               if(CacheFile.friendManager.isIgnored(new Name(var40, DecorativeObject.loginType))) {
                  var12 = true;
               }

               if(!var12 && myPlayerIndex == 0) {
                  field1069[field1070] = var27;
                  field1070 = (field1070 + 1) % 100;
                  String var29 = ScriptState.method1131(var3, 32767);
                  String var14 = FontTypeFace.appendTags(UnitPriceComparator.method138(var29));
                  byte var49;
                  if(var26.field3341) {
                     var49 = 7;
                  } else {
                     var49 = 3;
                  }

                  if(var26.field3334 != -1) {
                     ChatPlayer.sendGameMessage(var49, class241.method4532(var26.field3334) + var40, var14);
                  } else {
                     ChatPlayer.sendGameMessage(var49, var40, var14);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2332 == var1.serverPacket) {
               var17 = var3.readUnsignedByte();
               if(var3.readUnsignedByte() == 0) {
                  grandExchangeOffers[var17] = new GrandExchangeOffer();
                  var3.offset += 18;
               } else {
                  --var3.offset;
                  grandExchangeOffers[var17] = new GrandExchangeOffer(var3, false);
               }

               field881 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2303 == var1.serverPacket) {
               var17 = var3.method3627();
               widgetRoot = var17;
               this.method1483(false);
               WorldMapType1.method274(var17);
               class95.runWidgetOnLoadListener(widgetRoot);

               for(var5 = 0; var5 < 100; ++var5) {
                  field1055[var5] = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2354 == var1.serverPacket) {
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

            if(ServerPacket.field2349 == var1.serverPacket) {
               field1094 = true;
               class19.field325 = var3.readUnsignedByte();
               class7.field233 = var3.readUnsignedByte();
               class23.field354 = var3.readUnsignedShort();
               class265.field3432 = var3.readUnsignedByte();
               GrandExchangeOffer.field311 = var3.readUnsignedByte();
               if(GrandExchangeOffer.field311 >= 100) {
                  var17 = class19.field325 * 128 + 64;
                  var5 = class7.field233 * 128 + 64;
                  var6 = GrandExchangeEvent.getTileHeight(var17, var5, ScriptVarType.plane) - class23.field354;
                  var18 = var17 - UrlRequest.cameraX;
                  var21 = var6 - class86.cameraZ;
                  var9 = var5 - Signlink.cameraY;
                  var10 = (int)Math.sqrt((double)(var18 * var18 + var9 * var9));
                  class18.cameraPitch = (int)(Math.atan2((double)var21, (double)var10) * 325.949D) & 2047;
                  class33.cameraYaw = (int)(Math.atan2((double)var18, (double)var9) * -325.949D) & 2047;
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

            if(ServerPacket.field2281 == var1.serverPacket) {
               byte var61 = var3.method3631();
               var5 = var3.method3636();
               class237.serverVarps[var5] = var61;
               if(class237.clientVarps[var5] != var61) {
                  class237.clientVarps[var5] = var61;
               }

               DynamicObject.method2113(var5);
               pendingVarbitChanges[++pendingVarbitCount - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            long var30;
            long var32;
            if(ServerPacket.field2331 == var1.serverPacket) {
               var40 = var3.readString();
               var22 = var3.readLong();
               var24 = (long)var3.readUnsignedShort();
               var30 = (long)var3.read24BitInt();
               Permission var47 = (Permission)class185.forOrdinal(TextureProvider.method2688(), var3.readUnsignedByte());
               var32 = (var24 << 32) + var30;
               boolean var34 = false;

               for(int var15 = 0; var15 < 100; ++var15) {
                  if(field1069[var15] == var32) {
                     var34 = true;
                     break;
                  }
               }

               if(var47.field3342 && CacheFile.friendManager.isIgnored(new Name(var40, DecorativeObject.loginType))) {
                  var34 = true;
               }

               if(!var34 && myPlayerIndex == 0) {
                  field1069[field1070] = var32;
                  field1070 = (field1070 + 1) % 100;
                  String var35 = ScriptState.method1131(var3, 32767);
                  String var16 = FontTypeFace.appendTags(UnitPriceComparator.method138(var35));
                  if(var47.field3334 != -1) {
                     WorldMapRegion.addChatMessage(9, class241.method4532(var47.field3334) + var40, var16, Resampler.method2393(var22));
                  } else {
                     WorldMapRegion.addChatMessage(9, var40, var16, Resampler.method2393(var22));
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2294 == var1.serverPacket) {
               var17 = var3.getUSmart();
               boolean var48 = var3.readUnsignedByte() == 1;
               var59 = "";
               boolean var53 = false;
               if(var48) {
                  var59 = var3.readString();
                  if(CacheFile.friendManager.isIgnored(new Name(var59, DecorativeObject.loginType))) {
                     var53 = true;
                  }
               }

               String var44 = var3.readString();
               if(!var53) {
                  ChatPlayer.sendGameMessage(var17, var59, var44);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2291 == var1.serverPacket) {
               var17 = var3.readInt();
               if(var17 != field933) {
                  field933 = var17;
                  if(field926 == 1) {
                     field934 = true;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2356 == var1.serverPacket) {
               var17 = var3.method3627();
               var5 = var3.method3647();
               var52 = UnitPriceComparator.getWidget(var5);
               if(var52.modelType != 2 || var17 != var52.modelId) {
                  var52.modelType = 2;
                  var52.modelId = var17;
                  TotalQuantityComparator.method100(var52);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2335 == var1.serverPacket) {
               GroundObject.method2767();
               var17 = var3.method3646();
               var5 = var3.method3628();
               var6 = var3.readUnsignedByte();
               skillExperiences[var5] = var17;
               boostedSkillLevels[var5] = var6;
               realSkillLevels[var5] = 1;

               for(var18 = 0; var18 < 98; ++var18) {
                  if(var17 >= class248.field3007[var18]) {
                     realSkillLevels[var5] = var18 + 2;
                  }
               }

               changedSkills[++changedSkillsCount - 1 & 31] = var5;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2323 == var1.serverPacket) {
               BoundingBox2D.field246 = WorldMapType2.method581(var3.readUnsignedByte());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2302 == var1.serverPacket) {
               var17 = var3.method3627();
               if(var17 == 65535) {
                  var17 = -1;
               }

               MapIconReference.method759(var17);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2358 == var1.serverPacket) {
               var17 = var3.read24BitInt();
               var5 = var3.readUnsignedShort();
               if(var5 == 65535) {
                  var5 = -1;
               }

               if(field1083 != 0 && var5 != -1) {
                  MilliTimer.method3279(class190.indexTrack2, var5, 0, field1083, false);
                  field1085 = true;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2278 == var1.serverPacket) {
               GroundObject.method2767();
               weight = var3.readShort();
               field987 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2347 == var1.serverPacket) {
               var40 = var3.readString();
               Object[] var56 = new Object[var40.length() + 1];

               for(var6 = var40.length() - 1; var6 >= 0; --var6) {
                  if(var40.charAt(var6) == 's') {
                     var56[var6 + 1] = var3.readString();
                  } else {
                     var56[var6 + 1] = new Integer(var3.readInt());
                  }
               }

               var56[0] = new Integer(var3.readInt());
               ScriptEvent var58 = new ScriptEvent();
               var58.params = var56;
               class71.method1203(var58);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2355 == var1.serverPacket) {
               field869 = var3.method3627() * 30;
               field987 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2312 == var1.serverPacket) {
               var60 = var3.readUnsignedByte() == 1;
               if(var60) {
                  class33.field455 = class289.method5267() - var3.readLong();
                  WorldMapType2.grandExchangeEvents = new GrandExchangeEvents(var3, true);
               } else {
                  WorldMapType2.grandExchangeEvents = null;
               }

               field1046 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2292 == var1.serverPacket) {
               var60 = var3.readUnsignedShortOb1() == 1;
               var5 = var3.method3647();
               var52 = UnitPriceComparator.getWidget(var5);
               if(var60 != var52.isHidden) {
                  var52.isHidden = var60;
                  TotalQuantityComparator.method100(var52);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2309 == var1.serverPacket) {
               CacheFile.friendManager.method1784(var3, var1.packetLength);
               field1045 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2285 == var1.serverPacket) {
               class288.method5266(var3, var1.packetLength);
               class22.method178();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2308 == var1.serverPacket) {
               var17 = var3.readInt();
               WidgetNode var55 = (WidgetNode)componentTable.get((long)var17);
               if(var55 != null) {
                  IndexFile.closeWidget(var55, true);
               }

               if(field1017 != null) {
                  TotalQuantityComparator.method100(field1017);
                  field1017 = null;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2357 == var1.serverPacket) {
               CacheFile.friendManager.field1238.method5351(var3, var1.packetLength);
               Size.method183();
               field1045 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2336 == var1.serverPacket) {
               var17 = var3.method3635();
               var5 = var3.method3646();
               class237.serverVarps[var17] = var5;
               if(class237.clientVarps[var17] != var5) {
                  class237.clientVarps[var17] = var5;
               }

               DynamicObject.method2113(var17);
               pendingVarbitChanges[++pendingVarbitCount - 1 & 31] = var17;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2329 == var1.serverPacket) {
               GraphicsObject.updateNpcs(false, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2339 == var1.serverPacket) {
               CacheFile.friendManager.method1827();
               field1045 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2341 == var1.serverPacket) {
               field1094 = false;

               for(var17 = 0; var17 < 5; ++var17) {
                  field860[var17] = false;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2338 == var1.serverPacket) {
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

            if(ServerPacket.field2324 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2482);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2319 == var1.serverPacket) {
               var17 = var3.readUnsignedShort();
               var5 = var3.readInt();
               var52 = UnitPriceComparator.getWidget(var5);
               if(var52.modelType != 1 || var17 != var52.modelId) {
                  var52.modelType = 1;
                  var52.modelId = var17;
                  TotalQuantityComparator.method100(var52);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2320 == var1.serverPacket) {
               FrameMap.method2945(var3.readString());
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2295 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2484);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2311 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2475);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2289 == var1.serverPacket) {
               var17 = var3.method3646();
               var54 = UnitPriceComparator.getWidget(var17);

               for(var6 = 0; var6 < var54.itemIds.length; ++var6) {
                  var54.itemIds[var6] = -1;
                  var54.itemIds[var6] = 0;
               }

               TotalQuantityComparator.method100(var54);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2306 == var1.serverPacket) {
               GraphicsObject.updateNpcs(true, var3);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2352 == var1.serverPacket) {
               var17 = var3.method3626();
               var19 = var3.readString();
               var6 = var3.method3626();
               if(var17 >= 1 && var17 <= 8) {
                  if(var19.equalsIgnoreCase("null")) {
                     var19 = null;
                  }

                  playerOptions[var17 - 1] = var19;
                  playerOptionsPriorities[var17 - 1] = var6 == 0;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2310 == var1.serverPacket) {
               var17 = var3.readUnsignedByte();
               field926 = var17;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2362 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2485);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2327 == var1.serverPacket) {
               if(LoginPacket.clanMemberManager != null) {
                  LoginPacket.clanMemberManager.method5539(var3);
               }

               field891 = cycleCntr;
               Size.field361 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2343 == var1.serverPacket) {
               class158.method3259(var3, var1.packetLength);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2360 == var1.serverPacket) {
               VarCString.field3477 = var3.method3628();
               ServerPacket.field2363 = var3.readUnsignedByte();

               while(var3.offset < var1.packetLength) {
                  var17 = var3.readUnsignedByte();
                  class183[] var51 = new class183[]{class183.field2475, class183.field2484, class183.field2476, class183.field2477, class183.field2485, class183.field2478, class183.field2480, class183.field2474, class183.field2482, class183.field2483};
                  class183 var57 = var51[var17];
                  SoundTaskDataProvider.method831(var57);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2351 == var1.serverPacket) {
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

            if(ServerPacket.field2337 == var1.serverPacket) {
               var17 = var3.readUnsignedShort();
               var5 = var3.readUnsignedByte();
               var6 = var3.readUnsignedShort();
               if(field1086 != 0 && var5 != 0 && queuedSoundEffectCount < 50) {
                  queuedSoundEffectIDs[queuedSoundEffectCount] = var17;
                  unknownSoundValues1[queuedSoundEffectCount] = var5;
                  unknownSoundValues2[queuedSoundEffectCount] = var6;
                  audioEffects[queuedSoundEffectCount] = null;
                  soundLocations[queuedSoundEffectCount] = 0;
                  ++queuedSoundEffectCount;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2279 == var1.serverPacket) {
               World var42 = new World();
               var42.address = var3.readString();
               var42.id = var3.readUnsignedShort();
               var5 = var3.readInt();
               var42.mask = var5;
               class55.setGameState(45);
               var2.vmethod3404();
               var2 = null;
               WorldMapType2.changeWorld(var42);
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2340 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2477);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2297 == var1.serverPacket) {
               var17 = var3.readUnsignedByte();
               var5 = var3.readUnsignedByte();
               var6 = var3.readUnsignedByte();
               var18 = var3.readUnsignedByte();
               field860[var17] = true;
               field1043[var17] = var5;
               field966[var17] = var6;
               field991[var17] = var18;
               field1099[var17] = 0;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2300 == var1.serverPacket) {
               var17 = var3.readInt();
               var5 = var3.readUnsignedShort();
               if(var17 < -70000) {
                  var5 += 32768;
               }

               if(var17 >= 0) {
                  var52 = UnitPriceComparator.getWidget(var17);
               } else {
                  var52 = null;
               }

               for(; var3.offset < var1.packetLength; WorldMapData.setItemTableSlot(var5, var18, var21 - 1, var9)) {
                  var18 = var3.getUSmart();
                  var21 = var3.readUnsignedShort();
                  var9 = 0;
                  if(var21 != 0) {
                     var9 = var3.readUnsignedByte();
                     if(var9 == 255) {
                        var9 = var3.readInt();
                     }
                  }

                  if(var52 != null && var18 >= 0 && var18 < var52.itemIds.length) {
                     var52.itemIds[var18] = var21;
                     var52.itemQuantities[var18] = var9;
                  }
               }

               if(var52 != null) {
                  TotalQuantityComparator.method100(var52);
               }

               GroundObject.method2767();
               interfaceItemTriggers[++field1032 - 1 & 31] = var5 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2346 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2478);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2293 == var1.serverPacket) {
               if(var1.packetLength == 0) {
                  LoginPacket.clanMemberManager = null;
               } else {
                  if(LoginPacket.clanMemberManager == null) {
                     LoginPacket.clanMemberManager = new ClanMemberManager(DecorativeObject.loginType, InvType.clientInstance);
                  }

                  LoginPacket.clanMemberManager.method5524(var3);
               }

               field891 = cycleCntr;
               Size.field361 = true;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2299 == var1.serverPacket) {
               var17 = var3.readInt();
               var5 = var3.method3636();
               if(var5 == 65535) {
                  var5 = -1;
               }

               var6 = var3.readUnsignedShort();
               if(var6 == 65535) {
                  var6 = -1;
               }

               var18 = var3.method3647();

               for(var21 = var5; var21 <= var6; ++var21) {
                  var30 = (long)var21 + ((long)var18 << 32);
                  Node var11 = widgetFlags.get(var30);
                  if(var11 != null) {
                     var11.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var17), var30);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2330 == var1.serverPacket) {
               VarCString.field3477 = var3.method3626();
               ServerPacket.field2363 = var3.method3628();

               for(var17 = ServerPacket.field2363; var17 < ServerPacket.field2363 + 8; ++var17) {
                  for(var5 = VarCString.field3477; var5 < VarCString.field3477 + 8; ++var5) {
                     if(groundItemDeque[ScriptVarType.plane][var17][var5] != null) {
                        groundItemDeque[ScriptVarType.plane][var17][var5] = null;
                        class177.groundItemSpawned(var17, var5);
                     }
                  }
               }

               for(PendingSpawn var41 = (PendingSpawn)pendingSpawns.getFront(); var41 != null; var41 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var41.x >= ServerPacket.field2363 && var41.x < ServerPacket.field2363 + 8 && var41.y >= VarCString.field3477 && var41.y < VarCString.field3477 + 8 && var41.level == ScriptVarType.plane) {
                     var41.hitpoints = 0;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2282 == var1.serverPacket) {
               var17 = var3.readInt();
               var5 = var3.readInt();
               var6 = MapCacheArchiveNames.method599();
               PacketNode var45 = AbstractSoundSystem.method2350(ClientPacket.field2388, field911.field1460);
               var45.packetBuffer.method3670(GameEngine.FPS);
               var45.packetBuffer.putByte(var6);
               var45.packetBuffer.method3643(var17);
               var45.packetBuffer.method3736(var5);
               field911.method2135(var45);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2298 == var1.serverPacket) {
               var17 = var3.method3647();
               var5 = var3.method3627();
               var6 = var5 >> 10 & 31;
               var18 = var5 >> 5 & 31;
               var21 = var5 & 31;
               var9 = (var18 << 11) + (var6 << 19) + (var21 << 3);
               Widget var62 = UnitPriceComparator.getWidget(var17);
               if(var9 != var62.textColor) {
                  var62.textColor = var9;
                  TotalQuantityComparator.method100(var62);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2350 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2483);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2344 == var1.serverPacket) {
               var17 = var3.method3636();
               class234.method4452(var17);
               interfaceItemTriggers[++field1032 - 1 & 31] = var17 & 32767;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2284 == var1.serverPacket) {
               class1.method1();
               var1.serverPacket = null;
               return false;
            }

            if(ServerPacket.field2318 == var1.serverPacket) {
               for(var17 = 0; var17 < VarPlayerType.field3446; ++var17) {
                  VarPlayerType var50 = class71.method1204(var17);
                  if(var50 != null) {
                     class237.serverVarps[var17] = 0;
                     class237.clientVarps[var17] = 0;
                  }
               }

               GroundObject.method2767();
               pendingVarbitCount += 32;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2316 == var1.serverPacket) {
               var17 = var3.method3636();
               var5 = var3.method3646();
               var52 = UnitPriceComparator.getWidget(var5);
               if(var52 != null && var52.type == 0) {
                  if(var17 > var52.scrollHeight - var52.height) {
                     var17 = var52.scrollHeight - var52.height;
                  }

                  if(var17 < 0) {
                     var17 = 0;
                  }

                  if(var17 != var52.scrollY) {
                     var52.scrollY = var17;
                     TotalQuantityComparator.method100(var52);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2286 == var1.serverPacket) {
               var40 = var3.readString();
               var5 = var3.method3647();
               var52 = UnitPriceComparator.getWidget(var5);
               if(!var40.equals(var52.text)) {
                  var52.text = var40;
                  TotalQuantityComparator.method100(var52);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2322 == var1.serverPacket) {
               publicChatMode = var3.method3626();
               field1067 = var3.readUnsignedShortOb1();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2333 == var1.serverPacket) {
               var3.offset += 28;
               if(var3.checkCrc()) {
                  class189.method3559(var3, var3.offset - 28);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2280 == var1.serverPacket) {
               field1094 = true;
               MapIconReference.field590 = var3.readUnsignedByte();
               UnitPriceComparator.field315 = var3.readUnsignedByte();
               World.field1224 = var3.readUnsignedShort();
               class265.field3431 = var3.readUnsignedByte();
               ScriptState.field742 = var3.readUnsignedByte();
               if(ScriptState.field742 >= 100) {
                  UrlRequest.cameraX = MapIconReference.field590 * 128 + 64;
                  Signlink.cameraY = UnitPriceComparator.field315 * 128 + 64;
                  class86.cameraZ = GrandExchangeEvent.getTileHeight(UrlRequest.cameraX, Signlink.cameraY, ScriptVarType.plane) - World.field1224;
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2326 == var1.serverPacket) {
               var17 = var3.method3640();
               var5 = var3.method3638();
               var6 = var3.method3647();
               var43 = UnitPriceComparator.getWidget(var6);
               if(var5 != var43.originalX || var17 != var43.originalY || var43.dynamicX != 0 || var43.dynamicY != 0) {
                  var43.originalX = var5;
                  var43.originalY = var17;
                  var43.dynamicX = 0;
                  var43.dynamicY = 0;
                  TotalQuantityComparator.method100(var43);
                  this.widgetMethod0(var43);
                  if(var43.type == 0) {
                     class33.method372(GZipDecompressor.widgets[var6 >> 16], var43, false);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2304 == var1.serverPacket) {
               GroundObject.method2767();
               energy = var3.readUnsignedByte();
               field987 = cycleCntr;
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2348 == var1.serverPacket) {
               for(var17 = 0; var17 < class237.clientVarps.length; ++var17) {
                  if(class237.serverVarps[var17] != class237.clientVarps[var17]) {
                     class237.clientVarps[var17] = class237.serverVarps[var17];
                     DynamicObject.method2113(var17);
                     pendingVarbitChanges[++pendingVarbitCount - 1 & 31] = var17;
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2345 == var1.serverPacket) {
               SoundTaskDataProvider.method831(class183.field2480);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2325 == var1.serverPacket) {
               var17 = var3.method3645();
               var5 = var3.method3639();
               var52 = UnitPriceComparator.getWidget(var17);
               if(var5 != var52.field2868 || var5 == -1) {
                  var52.field2868 = var5;
                  var52.field2943 = 0;
                  var52.field2896 = 0;
                  TotalQuantityComparator.method100(var52);
               }

               var1.serverPacket = null;
               return true;
            }

            WidgetNode var7;
            if(ServerPacket.field2334 == var1.serverPacket) {
               var17 = var3.method3626();
               var5 = var3.method3627();
               var6 = var3.method3647();
               var7 = (WidgetNode)componentTable.get((long)var6);
               if(var7 != null) {
                  IndexFile.closeWidget(var7, var5 != var7.id);
               }

               class25.method192(var6, var5, var17);
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2283 == var1.serverPacket) {
               VarCString.field3477 = var3.method3628();
               ServerPacket.field2363 = var3.method3628();
               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2342 == var1.serverPacket) {
               var17 = var3.method3646();
               var5 = var3.method3647();
               WidgetNode var20 = (WidgetNode)componentTable.get((long)var17);
               var7 = (WidgetNode)componentTable.get((long)var5);
               if(var7 != null) {
                  IndexFile.closeWidget(var7, var20 == null || var7.id != var20.id);
               }

               if(var20 != null) {
                  var20.unlink();
                  componentTable.put(var20, (long)var5);
               }

               var8 = UnitPriceComparator.getWidget(var17);
               if(var8 != null) {
                  TotalQuantityComparator.method100(var8);
               }

               var8 = UnitPriceComparator.getWidget(var5);
               if(var8 != null) {
                  TotalQuantityComparator.method100(var8);
                  class33.method372(GZipDecompressor.widgets[var8.id >>> 16], var8, true);
               }

               if(widgetRoot != -1) {
                  GraphicsObject.method1920(widgetRoot, 1);
               }

               var1.serverPacket = null;
               return true;
            }

            if(ServerPacket.field2321 == var1.serverPacket) {
               var17 = var3.offset + var1.packetLength;
               var5 = var3.readUnsignedShort();
               var6 = var3.readUnsignedShort();
               if(var5 != widgetRoot) {
                  widgetRoot = var5;
                  this.method1483(false);
                  WorldMapType1.method274(widgetRoot);
                  class95.runWidgetOnLoadListener(widgetRoot);

                  for(var18 = 0; var18 < 100; ++var18) {
                     field1055[var18] = true;
                  }
               }

               WidgetNode var36;
               for(; var6-- > 0; var36.field769 = true) {
                  var18 = var3.readInt();
                  var21 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedByte();
                  var36 = (WidgetNode)componentTable.get((long)var18);
                  if(var36 != null && var21 != var36.id) {
                     IndexFile.closeWidget(var36, true);
                     var36 = null;
                  }

                  if(var36 == null) {
                     var36 = class25.method192(var18, var21, var9);
                  }
               }

               for(var7 = (WidgetNode)componentTable.first(); var7 != null; var7 = (WidgetNode)componentTable.next()) {
                  if(var7.field769) {
                     var7.field769 = false;
                  } else {
                     IndexFile.closeWidget(var7, true);
                  }
               }

               widgetFlags = new HashTable(512);

               while(var3.offset < var17) {
                  var18 = var3.readInt();
                  var21 = var3.readUnsignedShort();
                  var9 = var3.readUnsignedShort();
                  var10 = var3.readInt();

                  for(int var37 = var21; var37 <= var9; ++var37) {
                     var32 = ((long)var18 << 32) + (long)var37;
                     widgetFlags.put(new IntegerNode(var10), var32);
                  }
               }

               var1.serverPacket = null;
               return true;
            }

            class253.processClientError("" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1468 != null?var1.field1468.packetId:-1) + "," + (var1.field1458 != null?var1.field1458.packetId:-1) + "," + var1.packetLength, (Throwable)null);
            class1.method1();
         } catch (IOException var38) {
            class28.method240();
         } catch (Exception var39) {
            var19 = "" + (var1.serverPacket != null?var1.serverPacket.packetId:-1) + "," + (var1.field1468 != null?var1.field1468.packetId:-1) + "," + (var1.field1458 != null?var1.field1458.packetId:-1) + "," + var1.packetLength + "," + (class265.localPlayer.pathX[0] + ClientPacket.baseX) + "," + (class265.localPlayer.pathY[0] + MapIconReference.baseY) + ",";

            for(var6 = 0; var6 < var1.packetLength && var6 < 50; ++var6) {
               var19 = var19 + var3.payload[var6] + ",";
            }

            class253.processClientError(var19, var39);
            class1.method1();
         }

         return true;
      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-74"
   )
   final void method1675() {
      class7.method26();
      if(KeyFocusListener.field635 == null) {
         if(draggedWidget == null) {
            int var1 = MouseInput.mouseLastButton;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var8;
            if(isMenuOpen) {
               if(var1 != 1 && (Occluder.middleMouseMovesCamera || var1 != 4)) {
                  var2 = MouseInput.mouseLastX;
                  var3 = MouseInput.mouseLastY;
                  if(var2 < Varcs.menuX - 10 || var2 > ISAACCipher.field2620 + Varcs.menuX + 10 || var3 < class90.menuY - 10 || var3 > GameEngine.field685 + class90.menuY + 10) {
                     isMenuOpen = false;
                     class22.method177(Varcs.menuX, class90.menuY, ISAACCipher.field2620, GameEngine.field685);
                  }
               }

               if(var1 == 1 || !Occluder.middleMouseMovesCamera && var1 == 4) {
                  var2 = Varcs.menuX;
                  var3 = class90.menuY;
                  var4 = ISAACCipher.field2620;
                  var5 = MouseInput.mouseLastPressedX;
                  var6 = MouseInput.mouseLastPressedY;
                  int var17 = -1;

                  int var9;
                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = var3 + (menuOptionCount - 1 - var8) * 15 + 31;
                     if(var5 > var2 && var5 < var4 + var2 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var17 = var8;
                     }
                  }

                  if(var17 != -1 && var17 >= 0) {
                     var8 = menuActionParams0[var17];
                     var9 = menuActionParams1[var17];
                     int var10 = menuTypes[var17];
                     int var11 = menuIdentifiers[var17];
                     String var12 = menuOptions[var17];
                     String var13 = menuTargets[var17];
                     GameCanvas.menuAction(var8, var9, var10, var11, var12, var13, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                  }

                  isMenuOpen = false;
                  class22.method177(Varcs.menuX, class90.menuY, ISAACCipher.field2620, GameEngine.field685);
               }
            } else {
               var2 = class57.method878();
               if((var1 == 1 || !Occluder.middleMouseMovesCamera && var1 == 4) && var2 >= 0) {
                  var3 = menuTypes[var2];
                  if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                     label248: {
                        var4 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var14 = UnitPriceComparator.getWidget(var5);
                        if(!class138.method3135(class1.getWidgetClickMask(var14))) {
                           var8 = class1.getWidgetClickMask(var14);
                           boolean var7 = (var8 >> 29 & 1) != 0;
                           if(!var7) {
                              break label248;
                           }
                        }

                        if(KeyFocusListener.field635 != null && !field963 && menuOptionCount > 0 && !this.method1287()) {
                           ScriptState.method1130(field960, field961);
                        }

                        field963 = false;
                        itemPressedDuration = 0;
                        if(KeyFocusListener.field635 != null) {
                           TotalQuantityComparator.method100(KeyFocusListener.field635);
                        }

                        KeyFocusListener.field635 = UnitPriceComparator.getWidget(var5);
                        field959 = var4;
                        field960 = MouseInput.mouseLastPressedX;
                        field961 = MouseInput.mouseLastPressedY;
                        if(var2 >= 0) {
                           class86.method1965(var2);
                        }

                        TotalQuantityComparator.method100(KeyFocusListener.field635);
                        return;
                     }
                  }
               }

               if((var1 == 1 || !Occluder.middleMouseMovesCamera && var1 == 4) && this.method1287()) {
                  var1 = 2;
               }

               if((var1 == 1 || !Occluder.middleMouseMovesCamera && var1 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var3 = menuActionParams0[var2];
                  var4 = menuActionParams1[var2];
                  var5 = menuTypes[var2];
                  var6 = menuIdentifiers[var2];
                  String var15 = menuOptions[var2];
                  String var16 = menuTargets[var2];
                  GameCanvas.menuAction(var3, var4, var5, var6, var15, var16, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
               }

               if(var1 == 2 && menuOptionCount > 0) {
                  this.openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
               }
            }

         }
      }
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1921756967"
   )
   final boolean method1287() {
      int var1 = class57.method878();
      boolean var2 = field986 == 1 && menuOptionCount > 2;
      if(!var2) {
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

         var2 = var3;
      }

      return var2 && !menuBooleanArray[var1];
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1261943914"
   )
   @Export("openMenu")
   @Hook("menuOpened")
   final void openMenu(int var1, int var2) {
      class57.method880(var1, var2);
      GameSocket.region.method2983(ScriptVarType.plane, var1, var2, false);
      isMenuOpen = true;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "-15901"
   )
   final void method1483(boolean var1) {
      PendingSpawn.method1698(widgetRoot, FaceNormal.canvasWidth, class19.canvasHeight, var1);
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Liz;I)V",
      garbageValue = "337321387"
   )
   @Export("widgetMethod0")
   void widgetMethod0(Widget var1) {
      Widget var2 = var1.parentId == -1?null:UnitPriceComparator.getWidget(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = FaceNormal.canvasWidth;
         var4 = class19.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class90.method1991(var1, var3, var4, false);
      class297.method5347(var1, var3, var4);
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1562192278"
   )
   final void method1291() {
      TotalQuantityComparator.method100(draggedWidget);
      ++class23.field352;
      if(field1031 && field1028) {
         int var1 = MouseInput.mouseLastX;
         int var2 = MouseInput.mouseLastY;
         var1 -= field1025;
         var2 -= field892;
         if(var1 < field1029) {
            var1 = field1029;
         }

         if(var1 + draggedWidget.width > field1029 + field1024.width) {
            var1 = field1029 + field1024.width - draggedWidget.width;
         }

         if(var2 < field954) {
            var2 = field954;
         }

         if(var2 + draggedWidget.height > field954 + field1024.height) {
            var2 = field954 + field1024.height - draggedWidget.height;
         }

         int var3 = var1 - field901;
         int var4 = var2 - field1098;
         int var5 = draggedWidget.dragDeadZone;
         if(class23.field352 > draggedWidget.dragDeadTime && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            draggingWidget = true;
         }

         int var6 = var1 - field1029 + field1024.scrollX;
         int var7 = var2 - field954 + field1024.scrollY;
         ScriptEvent var8;
         if(draggedWidget.onDragListener != null && draggingWidget) {
            var8 = new ScriptEvent();
            var8.source = draggedWidget;
            var8.mouseX = var6;
            var8.mouseY = var7;
            var8.params = draggedWidget.onDragListener;
            class71.method1203(var8);
         }

         if(MouseInput.mouseCurrentButton == 0) {
            if(draggingWidget) {
               if(draggedWidget.onDragCompleteListener != null) {
                  var8 = new ScriptEvent();
                  var8.source = draggedWidget;
                  var8.mouseX = var6;
                  var8.mouseY = var7;
                  var8.target = draggedOnWidget;
                  var8.params = draggedWidget.onDragCompleteListener;
                  class71.method1203(var8);
               }

               if(draggedOnWidget != null) {
                  Widget var9 = draggedWidget;
                  int var11 = class1.getWidgetClickMask(var9);
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

                        var9 = UnitPriceComparator.getWidget(var9.parentId);
                        if(var9 == null) {
                           var15 = null;
                           break;
                        }

                        ++var13;
                     }
                  }

                  if(var15 != null) {
                     PacketNode var14 = AbstractSoundSystem.method2350(ClientPacket.field2403, field911.field1460);
                     var14.packetBuffer.method3644(draggedOnWidget.id);
                     var14.packetBuffer.method3632(draggedOnWidget.index);
                     var14.packetBuffer.method3633(draggedWidget.index);
                     var14.packetBuffer.method3632(draggedOnWidget.itemId);
                     var14.packetBuffer.method3643(draggedWidget.id);
                     var14.packetBuffer.method3633(draggedWidget.itemId);
                     field911.method2135(var14);
                  }
               }
            } else if(this.method1287()) {
               this.openMenu(field901 + field1025, field1098 + field892);
            } else if(menuOptionCount > 0) {
               ScriptState.method1130(field901 + field1025, field892 + field1098);
            }

            draggedWidget = null;
         }

      } else {
         if(class23.field352 > 1) {
            draggedWidget = null;
         }

      }
   }

   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "(I)Lkb;",
      garbageValue = "-769931180"
   )
   public Name vmethod5463() {
      return class265.localPlayer != null?class265.localPlayer.name:null;
   }
}
