import java.io.File;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
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
import net.runelite.rs.Opcodes;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("as")
   static boolean field930;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1194139549
   )
   static int field1030;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 925635829
   )
   @Export("rights")
   public static int rights;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -624485913
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 156445311
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lw")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field1158;
   @ObfuscatedName("ja")
   @ObfuscatedGetter(
      intValue = 1795462703
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = 670352251
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1443920379
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 556165409
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 792455139
   )
   static int field1184;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 395977137
   )
   @Export("world")
   static int world;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = -776554381
   )
   static int field977;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = 304407875
   )
   static int field1117;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = 1400520889
   )
   static int field1057;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      longValue = 350630029725795977L
   )
   static long field1141;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = 2095085853
   )
   static int field1051;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -247822361
   )
   static int field952;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1386750045
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 963848851
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("jv")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("me")
   static boolean[] field1119;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static class275 field979;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -1407458955
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("je")
   static boolean[] field1161;
   @ObfuscatedName("jm")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("mm")
   static boolean[] field1056;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = 1673508677
   )
   static int field1063;
   @ObfuscatedName("mk")
   static boolean[] field1120;
   @ObfuscatedName("jc")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("ly")
   static boolean field1153;
   @ObfuscatedName("bv")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -319547283
   )
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("ed")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1050522255
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -134781257
   )
   static int field1064;
   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("bi")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 1092470341
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("jx")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("nt")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1042426715
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 983929883
   )
   static int field955;
   @ObfuscatedName("lm")
   static boolean field1183;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 1825990261
   )
   static int field957;
   @ObfuscatedName("oa")
   static boolean field1151;
   @ObfuscatedName("bo")
   static boolean field931;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -808155241
   )
   static int field1089;
   @ObfuscatedName("kg")
   static boolean field1084;
   @ObfuscatedName("jj")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -1931316479
   )
   static int field1168;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      longValue = -5157390850567348901L
   )
   static long field1142;
   @ObfuscatedName("jb")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -150091683
   )
   static int field1093;
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   @Export("secretPacketBuffer1")
   public static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1519818971
   )
   static int field934;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 59258897
   )
   static int field972;
   @ObfuscatedName("mc")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -588252149
   )
   static int field978;
   @ObfuscatedName("lt")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field960;
   @ObfuscatedName("bk")
   static boolean field937;
   @ObfuscatedName("ju")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 151185423
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("mv")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("bh")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("mx")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = -372039383
   )
   static int field1004;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 259878579
   )
   static int field1094;
   @ObfuscatedName("il")
   static boolean field1031;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -483018189
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -2002714747
   )
   static int field940;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 1251584657
   )
   static int field1032;
   @ObfuscatedName("kd")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1317239145
   )
   static int field941;
   @ObfuscatedName("jw")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -601246665
   )
   static int field1053;
   @ObfuscatedName("ms")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("jl")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -862336093
   )
   static int field985;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -1875052433
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -1875013977
   )
   static int field1028;
   @ObfuscatedName("mw")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("rk")
   @ObfuscatedSignature(
      signature = "Lba;"
   )
   static final class72 field1189;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 151346705
   )
   static int field1131;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1734396213
   )
   static int field981;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1220664577
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("kj")
   static String field1072;
   @ObfuscatedName("it")
   static String field1068;
   @ObfuscatedName("jy")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -786807371
   )
   static int field929;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 2029135079
   )
   static int field982;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 601590259
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 1325096951
   )
   static int field983;
   @ObfuscatedName("ks")
   static String field1087;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 523814425
   )
   static int field984;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1732448659
   )
   static int field946;
   @ObfuscatedName("ln")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field1086;
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 19620641
   )
   static int field944;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -728024509
   )
   static int field1139;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -14083199
   )
   static int field1096;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfw;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   static class89 field948;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -128363469
   )
   static int field1097;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 464288435
   )
   static int field1150;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   static class89 field949;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 1810796633
   )
   static int field1025;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      longValue = 4665340147455594337L
   )
   static long field1006;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -620556913
   )
   static int field922;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -500023485
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("rs")
   static int[] field1190;
   @ObfuscatedName("rh")
   static int[] field1060;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 762145105
   )
   static int field1026;
   @ObfuscatedName("mg")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field1113;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1755357177
   )
   static int field1047;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = 1162611167
   )
   static int field1022;
   @ObfuscatedName("lb")
   static boolean field1090;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = 1448095401
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = -721611891
   )
   static int field1118;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 60819565
   )
   static int field959;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -1641365203
   )
   static int field1023;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 1811878805
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = -754676071
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   static class149 field1002;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 112151753
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = 1129370181
   )
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 2065840937
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("dc")
   static byte[] field942;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "[Lcm;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = -1592736269
   )
   static int field1112;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 1533738409
   )
   @Export("npcIndexesCount")
   static int npcIndexesCount;
   @ObfuscatedName("db")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -1235818651
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("eh")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -29115401
   )
   static int field956;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -640834877
   )
   static int field1037;
   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static PlayerComposition field1185;
   @ObfuscatedName("og")
   @ObfuscatedGetter(
      intValue = -1691115841
   )
   static int field1149;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 487968235
   )
   static int field1187;
   @ObfuscatedName("le")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field1091;
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field1078;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   static PacketBuffer field968;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = 853139205
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "[Lbk;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("in")
   static int[] field1038;
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = -1734198037
   )
   static int field1018;
   @ObfuscatedName("rr")
   @ObfuscatedSignature(
      signature = "Lkk;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 2025568875
   )
   static int field1148;
   @ObfuscatedName("lg")
   static int[] field1100;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -892682089
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 793646695
   )
   static int field999;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1070555481
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("em")
   static HashMap field980;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -1277417321
   )
   static int field1066;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 219076969
   )
   static int field1180;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = 552489235
   )
   static int field1065;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 495966881
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -470097057
   )
   static int field1043;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = 505003047
   )
   static int field1020;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = -1297157977
   )
   static int field1191;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 843522265
   )
   static int field991;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -729154477
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("fz")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "[Lbd;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("hx")
   static boolean field1005;
   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "[[[Lgz;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("fb")
   static int[][][] field988;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -2128565619
   )
   static int field923;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 349713
   )
   static int field1175;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 1924384103
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -1878811661
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("fd")
   static final int[] field989;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      longValue = 3277745938275033075L
   )
   static long field1138;
   @ObfuscatedName("ps")
   static short field1167;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = 365346821
   )
   static int field1088;
   @ObfuscatedName("kq")
   static boolean field1083;
   @ObfuscatedName("po")
   static short field1166;
   @ObfuscatedName("pw")
   static boolean field1160;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -1421466173
   )
   static int field992;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -580230511
   )
   static int field1071;
   @ObfuscatedName("hd")
   static int[][] field1017;
   @ObfuscatedName("qf")
   static short field998;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -2101581639
   )
   static int field933;
   @ObfuscatedName("qm")
   static short field1173;
   @ObfuscatedName("np")
   static long[] field1133;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 501971529
   )
   static int field1164;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -207024847
   )
   static int field997;
   @ObfuscatedName("qs")
   static short field1140;
   @ObfuscatedName("pm")
   static short field1147;
   @ObfuscatedName("ow")
   static int[] field1143;
   @ObfuscatedName("pz")
   static short field993;
   @ObfuscatedName("qi")
   static short field1003;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = -181040815
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "[Lbg;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 184142769
   )
   static int field1152;
   @ObfuscatedName("ia")
   static int[] field1042;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -688421113
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -1189453321
   )
   static int field1033;
   @ObfuscatedName("or")
   static int[] field1179;
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static class195 field1182;
   @ObfuscatedName("hg")
   @ObfuscatedGetter(
      intValue = -848304139
   )
   static int field958;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -960427853
   )
   static int field1036;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 538995593
   )
   static int field1134;
   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("pl")
   static boolean[] field1029;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = -700549805
   )
   static int field1061;
   @ObfuscatedName("pr")
   static int[] field1163;
   @ObfuscatedName("oj")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   static SpritePixels[] field1145;
   @ObfuscatedName("gp")
   static boolean field1132;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -976582771
   )
   static int field996;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = 126096789
   )
   static int field1092;
   @ObfuscatedName("om")
   @ObfuscatedGetter(
      intValue = 2060424865
   )
   static int field1116;
   @ObfuscatedName("pk")
   static int[] field1162;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = -1967308953
   )
   static int field1154;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -307186583
   )
   static int field1076;
   @ObfuscatedName("ii")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("lp")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1314148987
   )
   static int field1069;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -620115631
   )
   static int field1103;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -1012155827
   )
   static int field994;
   @ObfuscatedName("py")
   static int[] field935;
   @ObfuscatedName("im")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 1182432515
   )
   static int field1077;
   @ObfuscatedName("on")
   static int[] field1098;
   @ObfuscatedName("pu")
   static int[] field1165;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 622744567
   )
   static int field1000;
   @ObfuscatedName("px")
   static int[] field1156;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -1515136361
   )
   static int field1001;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 1556517605
   )
   static int field995;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1769032927
   )
   static int field1111;
   @ObfuscatedName("pg")
   static int[] field1136;
   @ObfuscatedName("pt")
   @ObfuscatedSignature(
      signature = "[Lcb;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("pe")
   static int[] field1040;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -1907149241
   )
   static int field1007;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 1619688925
   )
   static int field1008;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -789761887
   )
   static int field1082;
   @ObfuscatedName("hz")
   static int[] field1009;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = -1044601545
   )
   static int field1108;
   @ObfuscatedName("lf")
   static int[] field936;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = -1369971237
   )
   static int field1105;
   @ObfuscatedName("hj")
   static int[] field1010;
   @ObfuscatedName("nl")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("hf")
   static int[] field1011;
   @ObfuscatedName("nb")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("ht")
   static int[] field1012;
   @ObfuscatedName("hy")
   static int[] field1013;
   @ObfuscatedName("hv")
   static int[] field1014;
   @ObfuscatedName("hw")
   static int[] field1121;
   @ObfuscatedName("js")
   static boolean field961;
   @ObfuscatedName("hp")
   static String[] field1016;
   @ObfuscatedName("jq")
   static boolean field1174;
   @ObfuscatedName("ns")
   static String field990;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 2049973487
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -1141766617
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -1567737481
   )
   static int field1135;
   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "[Lh;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 1162299567
   )
   static int field1177;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = 1323363091
   )
   static int field1109;
   @ObfuscatedName("nc")
   static int[] field1110;
   @ObfuscatedName("nd")
   static int[] field1015;
   @ObfuscatedName("no")
   static int[] field1095;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = -36502463
   )
   @Export(
      value = "chatCycle",
      setter = true
   )
   static int chatCycle;
   @ObfuscatedName("iv")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("mj")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field1171;
   @ObfuscatedName("mu")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field1115;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -831010991
   )
   static int field1070;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = 2133224815
   )
   static int field1169;
   @ObfuscatedName("lx")
   static boolean field1085;
   public static boolean RUNELITE_PACKET;

   static {
      field930 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field931 = true;
      gameCycle = 0;
      field1142 = 1L;
      field934 = -1;
      field972 = -1;
      field978 = -1;
      field937 = true;
      displayFps = false;
      field1030 = 0;
      field940 = 0;
      field941 = 0;
      field1053 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field946 = 0;
      field1139 = 0;
      field948 = class89.field1406;
      field949 = class89.field1406;
      loadingStage = 0;
      js5State = 0;
      field952 = 0;
      field955 = 0;
      loginState = 0;
      field957 = 0;
      field1184 = 0;
      field959 = 0;
      field1002 = class149.field2196;
      field942 = null;
      cachedNPCs = new NPC['耀'];
      npcIndexesCount = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field968 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field1118 = 0;
      audioEffectCount = 0;
      lastFrameId = 0;
      secondLastFrameId = 0;
      thridLastFrameId = 0;
      field977 = 0;
      socketError = false;
      field979 = new class275();
      field980 = new HashMap();
      field981 = 0;
      field982 = 1;
      field983 = 0;
      field984 = 1;
      field985 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field988 = new int[4][13][13];
      field989 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1004 = 0;
      field991 = 2301979;
      field992 = 5063219;
      field1061 = 3353893;
      field933 = 7759444;
      field1132 = false;
      field996 = 0;
      field997 = 128;
      mapAngle = 0;
      field994 = 0;
      field1000 = 0;
      field1001 = 0;
      field995 = 0;
      field1069 = 50;
      field1020 = 0;
      field1005 = false;
      field958 = 0;
      field1007 = 0;
      field1008 = 50;
      field1009 = new int[field1008];
      field1010 = new int[field1008];
      field1011 = new int[field1008];
      field1012 = new int[field1008];
      field1013 = new int[field1008];
      field1014 = new int[field1008];
      field1121 = new int[field1008];
      field1016 = new String[field1008];
      field1017 = new int[104][104];
      field1018 = 0;
      screenY = -1;
      screenX = -1;
      field1047 = 0;
      field1022 = 0;
      field1023 = 0;
      cursorState = 0;
      field1025 = 0;
      field1026 = 0;
      field944 = 0;
      field1028 = 0;
      field1131 = 0;
      field1177 = 0;
      field1031 = false;
      field1032 = 0;
      field1033 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1036 = 0;
      field1037 = 0;
      field1038 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1042 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1043 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1051 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1161 = new boolean[500];
      field1174 = false;
      field961 = false;
      field1063 = -1;
      field1064 = -1;
      field1065 = 0;
      field1066 = 50;
      itemSelectionState = 0;
      field1068 = null;
      spellSelected = false;
      field1070 = -1;
      field1169 = -1;
      field1072 = null;
      field1087 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1076 = 0;
      field1077 = 0;
      field1078 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1082 = -1;
      field1083 = false;
      field1084 = false;
      field1085 = false;
      field1086 = null;
      field1158 = null;
      field960 = null;
      field1089 = 0;
      field1168 = 0;
      field1091 = null;
      field1183 = false;
      field1093 = -1;
      field1094 = -1;
      field1153 = false;
      field1096 = -1;
      field1097 = -1;
      field1090 = false;
      cycleCntr = 1;
      field1100 = new int[32];
      field999 = 0;
      interfaceItemTriggers = new int[32];
      field1103 = 0;
      field936 = new int[32];
      field1105 = 0;
      chatCycle = 0;
      field1191 = 0;
      field1108 = 0;
      field1109 = 0;
      field1092 = 0;
      field1111 = 0;
      field1112 = 0;
      field1113 = new Deque();
      field1171 = new Deque();
      field1115 = new Deque();
      widgetFlags = new HashTable(512);
      field1117 = 0;
      field1057 = -2;
      field1119 = new boolean[100];
      field1120 = new boolean[100];
      field1056 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1141 = 0L;
      isResized = true;
      field1110 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
      field1088 = 0;
      field1071 = 0;
      field990 = "";
      field1133 = new long[100];
      field1134 = 0;
      field1135 = 0;
      field1095 = new int[128];
      field1015 = new int[128];
      field1138 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1116 = -1;
      field1164 = 0;
      field1143 = new int[1000];
      field1179 = new int[1000];
      field1145 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1148 = 0;
      field1149 = 255;
      field1150 = -1;
      field1151 = false;
      field1152 = 127;
      field922 = 127;
      field1154 = 0;
      field1098 = new int[50];
      field1156 = new int[50];
      field1136 = new int[50];
      field1040 = new int[50];
      audioEffects = new SoundEffect[50];
      field1160 = false;
      field1029 = new boolean[5];
      field1162 = new int[5];
      field1163 = new int[5];
      field935 = new int[5];
      field1165 = new int[5];
      field1166 = 256;
      field1167 = 205;
      field993 = 256;
      field1147 = 320;
      field1003 = 1;
      field1140 = 32767;
      field998 = 1;
      field1173 = 32767;
      field923 = 0;
      field1175 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1180 = 0;
      friends = new Friend[400];
      field1182 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1185 = new PlayerComposition();
      field956 = -1;
      field1187 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field1189 = new class72();
      field1190 = new int[50];
      field1060 = new int[50];
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1470053024"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         boolean var1 = IndexDataBase.method4278();
         if(!var1) {
            this.method1149();
         }

      }
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2050074970"
   )
   void method1154() {
      int var1 = Timer.canvasWidth;
      int var2 = GameEngine.canvasHeight;
      if(super.field717 < var1) {
         var1 = super.field717;
      }

      if(super.field718 < var2) {
         var2 = super.field718;
      }

      if(class70.preferences != null) {
         try {
            Client var3 = class7.clientInstance;
            Object[] var4 = new Object[]{Integer.valueOf(SceneTilePaint.method2713())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2049908648"
   )
   protected final void vmethod1147() {
      if(class24.chatMessages.changed()) {
         class24.chatMessages.serialize();
      }

      if(class56.field695 != null) {
         class56.field695.field869 = false;
      }

      class56.field695 = null;
      if(class15.rssocket != null) {
         class15.rssocket.close();
         class15.rssocket = null;
      }

      WallObject.method2901();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      Actor.field1244 = null;
      if(ItemLayer.soundSystem0 != null) {
         ItemLayer.soundSystem0.method2062();
      }

      if(class1.soundSystem1 != null) {
         class1.soundSystem1.method2062();
      }

      if(class238.field3255 != null) {
         class238.field3255.close();
      }

      Object var7 = class236.field3231;
      synchronized(class236.field3231) {
         if(class236.field3228 != 0) {
            class236.field3228 = 1;

            try {
               class236.field3231.wait();
            } catch (InterruptedException var4) {
               ;
            }
         }
      }

      if(class60.field763 != null) {
         class60.field763.method2927();
         class60.field763 = null;
      }

      Player.method1137();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1676674157"
   )
   protected final void vmethod1144() {
      Frames.field2120 = socketType == 0?43594:world + 40000;
      Signlink.field2230 = socketType == 0?443:world + 50000;
      class51.myWorldPort = Frames.field2120;
      FaceNormal.colorsToFind = class214.field2626;
      PlayerComposition.colorsToReplace = class214.field2620;
      PlayerComposition.field2613 = class214.field2621;
      PlayerComposition.field2614 = class214.field2622;
      class60.field763 = new class147();
      this.method842();
      this.method847();
      Actor.field1244 = this.method839();
      class37.field534 = new IndexFile(255, class155.field2239, class155.field2241, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = Tile.getPreferencesFile("", WorldMapType1.field452.field3192, false);
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

      class70.preferences = var3;
      this.method840();
      class87.method1721(this, class276.field3741);
      if(socketType != 0) {
         displayFps = true;
      }

      int var7 = class70.preferences.screenType;
      field1141 = 0L;
      if(var7 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      if(SceneTilePaint.method2713() == 1) {
         class7.clientInstance.method837(765, 503);
      } else {
         class7.clientInstance.method837(7680, 2160);
      }

      if(gameState >= 25) {
         secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_RESIZE_CLIENT_FRAME);
         secretPacketBuffer1.putByte(SceneTilePaint.method2713());
         secretPacketBuffer1.putShort(Timer.canvasWidth);
         secretPacketBuffer1.putShort(GameEngine.canvasHeight);
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "701438966"
   )
   final void method1160(boolean var1) {
      class261.method4814(widgetRoot, Timer.canvasWidth, GameEngine.canvasHeight, var1);
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-394520260"
   )
   @Export("error")
   void error(int var1) {
      class224.socket = null;
      class174.rssocket = null;
      js5State = 0;
      if(Frames.field2120 == class51.myWorldPort) {
         class51.myWorldPort = Signlink.field2230;
      } else {
         class51.myWorldPort = Frames.field2120;
      }

      ++field955;
      if(field955 < 2 || var1 != 7 && var1 != 9) {
         if(field955 >= 2 && var1 == 6) {
            this.error("js5connect_outofdate");
            gameState = 1000;
         } else if(field955 >= 4) {
            if(gameState <= 5) {
               this.error("js5connect");
               gameState = 1000;
            } else {
               field952 = 3000;
            }
         }
      } else if(gameState <= 5) {
         this.error("js5connect_full");
         gameState = 1000;
      } else {
         field952 = 3000;
      }

   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1837326232"
   )
   final boolean method1199() {
      int var1 = menuOptionCount - 1;
      if(menuOptionCount > 2) {
         if(field1051 != 1 || field1161[var1]) {
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

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1870455738"
   )
   protected final void vmethod1142() {
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-642777627"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(class15.rssocket == null) {
         return false;
      } else {
         int var3;
         String var23;
         try {
            int var1 = class15.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               class15.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = RUNELITE_PACKET?-2:class272.field3703[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               class15.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               class15.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            class15.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field979.method4991();
            field1118 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId;
            lastFrameId = packetType;
            int var2;
            if(packetType == Opcodes.PACKET_SERVER_242) {
               field1160 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1029[var2] = false;
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_8) {
               field1180 = 1;
               field1191 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_233) {
               for(var2 = 0; var2 < cachedPlayers.length; ++var2) {
                  if(cachedPlayers[var2] != null) {
                     cachedPlayers[var2].animation = -1;
                  }
               }

               for(var2 = 0; var2 < cachedNPCs.length; ++var2) {
                  if(cachedNPCs[var2] != null) {
                     cachedNPCs[var2].animation = -1;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_101) {
               class223.method4149(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_83) {
               class94.playerIndexesCount = 0;

               for(var2 = 0; var2 < 2048; ++var2) {
                  class94.field1488[var2] = null;
                  class94.field1487[var2] = 1;
               }

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               class11.initializeGPI(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_71) {
               for(var2 = 0; var2 < VarPlayerType.field3280; ++var2) {
                  VarPlayerType var75 = Friend.method1084(var2);
                  if(var75 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               CombatInfoListHolder.method1688();
               field999 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_223) {
               ChatLineBuffer.method1916();
               packetType = -1;
               return false;
            }

            if(packetType == Opcodes.PACKET_SERVER_23) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.widgetSettings[var2] != class211.settings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     class45.method630(var2);
                     field1100[++field999 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_144) {
               class81.method1665(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_131) {
               if(widgetRoot != -1) {
                  PendingSpawn.method1523(widgetRoot, 0);
               }

               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_189) {
               field1148 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_136) {
               field1030 = secretPacketBuffer2.readUnsignedShort() * 30;
               field1111 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_217) {
               class244.field3317 = ItemLayer.method2453(secretPacketBuffer2.readUnsignedByte());
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_73) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3269();
               }

               class46.field609 = GameEngine.taskManager.createHost(var2);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_249) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3259();
               }

               if(var2 == 65535) {
                  var2 = -1;
               }

               class148.method2942(var2);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_16) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3259();
               }

               WorldMapType3.method210(var2);
               interfaceItemTriggers[++field1103 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            int var16;
            Widget var73;
            if(packetType == Opcodes.PACKET_SERVER_103) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3268();
               }

               var73 = ItemLayer.method2454(var2);

               for(var16 = 0; var16 < var73.itemIds.length; ++var16) {
                  var73.itemIds[var16] = -1;
                  var73.itemIds[var16] = 0;
               }

               class45.method647(var73);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_221) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3268();
               }

               var73 = ItemLayer.method2454(var2);
               var73.modelType = 3;
               var73.modelId = class66.localPlayer.composition.method4034();
               class45.method647(var73);
               packetType = -1;
               return true;
            }

            if(packetType == Opcodes.PACKET_SERVER_85) {
               CombatInfoListHolder.method1688();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1111 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType != 45 && packetType != 44 && packetType != 146 && packetType != 87 && packetType != 194 && packetType != 35 && packetType != 210 && packetType != 75 && packetType != 18) {
               if(packetType == Opcodes.PACKET_SERVER_122) {
                  CombatInfoListHolder.method1688();
                  weight = secretPacketBuffer2.readShort();
                  field1111 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_215) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                  }

                  WidgetNode var72 = (WidgetNode)componentTable.get((long)var2);
                  if(var72 != null) {
                     class110.method2145(var72, true);
                  }

                  if(field1078 != null) {
                     class45.method647(field1078);
                     field1078 = null;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_34) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3258();
                  }

                  widgetRoot = var2;
                  this.method1160(false);
                  class51.method760(var2);
                  class208.method3976(widgetRoot);

                  for(var3 = 0; var3 < 100; ++var3) {
                     field1119[var3] = true;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_110) {
                  class261.method4821(secretPacketBuffer2.readString());
                  packetType = -1;
                  return true;
               }

               String var15;
               if(packetType == Opcodes.PACKET_SERVER_164) {
                  if(RUNELITE_PACKET) {
                     var23 = secretPacketBuffer2.runeliteReadString();
                  } else {
                     var23 = secretPacketBuffer2.readString();
                  }

                  var15 = FontTypeFace.appendTags(CombatInfoListHolder.method1692(class3.method7(secretPacketBuffer2)));
                  class174.sendGameMessage(6, var23, var15);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_77) {
                  secretPacketBuffer2.offset += 28;
                  if(secretPacketBuffer2.checkCrc()) {
                     PacketBuffer var90 = secretPacketBuffer2;
                     var3 = secretPacketBuffer2.offset - 28;
                     ItemContainer.method1069(var90.payload, var3);
                     class85.method1708(var90, var3);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_20) {
                  byte var91;
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var91 = secretPacketBuffer2.runeliteReadByte();
                  } else {
                     var2 = secretPacketBuffer2.method3258();
                     var91 = secretPacketBuffer2.method3252();
                  }

                  class211.settings[var2] = var91;
                  if(class211.widgetSettings[var2] != var91) {
                     class211.widgetSettings[var2] = var91;
                  }

                  class45.method630(var2);
                  field1100[++field999 - 1 & 31] = var2;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_48) {
                  field1088 = secretPacketBuffer2.readUnsignedByte();
                  field1071 = secretPacketBuffer2.readUnsignedByte();
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_174) {
                  World.field1296 = secretPacketBuffer2.method3250();
                  class44.field596 = secretPacketBuffer2.method3248();
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_50) {
                  destinationX = secretPacketBuffer2.readUnsignedByte();
                  if(destinationX == 255) {
                     destinationX = 0;
                  }

                  destinationY = secretPacketBuffer2.readUnsignedByte();
                  if(destinationY == 255) {
                     destinationY = 0;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_70) {
                  var2 = secretPacketBuffer2.method3258();
                  if(var2 == 65535) {
                     var2 = -1;
                  }

                  var3 = secretPacketBuffer2.method3236();
                  if(field1149 != 0 && var2 != -1) {
                     CombatInfoListHolder.method1691(ScriptEvent.indexTrack2, var2, 0, field1149, false);
                     field1151 = true;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_113) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  if(secretPacketBuffer2.readUnsignedByte() == 0) {
                     grandExchangeOffers[var2] = new GrandExchangeOffer();
                     secretPacketBuffer2.offset += 18;
                  } else {
                     --secretPacketBuffer2.offset;
                     grandExchangeOffers[var2] = new GrandExchangeOffer(secretPacketBuffer2, false);
                  }

                  field1109 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               int var5;
               long var21;
               long var42;
               if(packetType == Opcodes.PACKET_SERVER_68) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                     var3 = secretPacketBuffer2.readInt();
                  }

                  var5 = 0;
                  if(class174.field2394 == null || !class174.field2394.isValid()) {
                     try {
                        Iterator var86 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                        while(var86.hasNext()) {
                           GarbageCollectorMXBean var95 = (GarbageCollectorMXBean)var86.next();
                           if(var95.isValid()) {
                              class174.field2394 = var95;
                              GameEngine.field739 = -1L;
                              GameEngine.field709 = -1L;
                           }
                        }
                     } catch (Throwable var49) {
                        ;
                     }
                  }

                  if(class174.field2394 != null) {
                     long var40 = class174.currentTimeMs();
                     var42 = class174.field2394.getCollectionTime();
                     if(GameEngine.field709 != -1L) {
                        var21 = var42 - GameEngine.field709;
                        long var44 = var40 - GameEngine.field739;
                        if(var44 != 0L) {
                           var5 = (int)(100L * var21 / var44);
                        }
                     }

                     GameEngine.field709 = var42;
                     GameEngine.field739 = var40;
                  }

                  secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_148);
                  if(RUNELITE_PACKET) {
                     secretPacketBuffer1.runeliteWriteInt(var2);
                     secretPacketBuffer1.runeliteWriteInt(var3);
                     secretPacketBuffer1.runeliteWriteInt(GameEngine.FPS);
                     secretPacketBuffer1.runeliteWriteInt(var5);
                  } else {
                     secretPacketBuffer1.method3275(var2);
                     secretPacketBuffer1.method3275(var3);
                     secretPacketBuffer1.putByte(GameEngine.FPS);
                     secretPacketBuffer1.method3225(var5);
                  }

                  packetType = -1;
                  return true;
               }

               boolean var52;
               Widget var54;
               if(packetType == Opcodes.PACKET_SERVER_209) {
                  var52 = secretPacketBuffer2.method3248() == 1;
                  var3 = secretPacketBuffer2.method3269();
                  var54 = ItemLayer.method2454(var3);
                  if(var52 != var54.isHidden) {
                     var54.isHidden = var52;
                     class45.method647(var54);
                  }

                  packetType = -1;
                  return true;
               }

               int var6;
               int var7;
               if(packetType == Opcodes.PACKET_SERVER_141) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3268();
                     var3 = secretPacketBuffer2.method3259();
                  }

                  var16 = var3 >> 10 & 31;
                  var5 = var3 >> 5 & 31;
                  var6 = var3 & 31;
                  var7 = (var5 << 11) + (var16 << 19) + (var6 << 3);
                  Widget var63 = ItemLayer.method2454(var2);
                  if(var7 != var63.textColor) {
                     var63.textColor = var7;
                     class45.method647(var63);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_126) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3260();
                     var3 = secretPacketBuffer2.method3267();
                  }

                  var54 = ItemLayer.method2454(var3);
                  if(var2 != var54.field2711 || var2 == -1) {
                     var54.field2711 = var2;
                     var54.field2680 = 0;
                     var54.field2765 = 0;
                     class45.method647(var54);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_132) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                     var3 = secretPacketBuffer2.method3344();
                  }

                  var54 = ItemLayer.method2454(var2);
                  if(var54.modelType != 2 || var3 != var54.modelId) {
                     var54.modelType = 2;
                     var54.modelId = var3;
                     class45.method647(var54);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_216) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                     var3 = secretPacketBuffer2.readUnsignedShort();
                  }

                  var54 = ItemLayer.method2454(var2);
                  if(var54.modelType != 1 || var3 != var54.modelId) {
                     var54.modelType = 1;
                     var54.modelId = var3;
                     class45.method647(var54);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_40) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3259();
                     var3 = secretPacketBuffer2.method3269();
                  }

                  var54 = ItemLayer.method2454(var3);
                  if(var54 != null && var54.type == 0) {
                     if(var2 > var54.scrollHeight - var54.height) {
                        var2 = var54.scrollHeight - var54.height;
                     }

                     if(var2 < 0) {
                        var2 = 0;
                     }

                     if(var2 != var54.scrollY) {
                        var54.scrollY = var2;
                        class45.method647(var54);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_182) {
                  class44.field596 = secretPacketBuffer2.method3248();
                  World.field1296 = secretPacketBuffer2.readUnsignedShortOb1();

                  for(var2 = class44.field596; var2 < class44.field596 + 8; ++var2) {
                     for(var3 = World.field1296; var3 < World.field1296 + 8; ++var3) {
                        if(groundItemDeque[class46.plane][var2][var3] != null) {
                           groundItemDeque[class46.plane][var2][var3] = null;
                           class87.groundItemSpawned(var2, var3);
                        }
                     }
                  }

                  for(PendingSpawn var89 = (PendingSpawn)pendingSpawns.getFront(); var89 != null; var89 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var89.x >= class44.field596 && var89.x < class44.field596 + 8 && var89.y >= World.field1296 && var89.y < World.field1296 + 8 && var89.level == class46.plane) {
                        var89.hitpoints = 0;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_94) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3267();
                     var3 = secretPacketBuffer2.method3258();
                  }

                  class211.settings[var3] = var2;
                  if(class211.widgetSettings[var3] != var2) {
                     class211.widgetSettings[var3] = var2;
                  }

                  class45.method630(var3);
                  field1100[++field999 - 1 & 31] = var3;
                  packetType = -1;
                  return true;
               }

               WidgetNode var17;
               Widget var80;
               if(packetType == Opcodes.PACKET_SERVER_105) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                     var3 = secretPacketBuffer2.method3269();
                  }

                  WidgetNode var68 = (WidgetNode)componentTable.get((long)var3);
                  var17 = (WidgetNode)componentTable.get((long)var2);
                  if(var17 != null) {
                     class110.method2145(var17, var68 == null || var68.id != var17.id);
                  }

                  if(var68 != null) {
                     var68.unlink();
                     componentTable.put(var68, (long)var2);
                  }

                  var80 = ItemLayer.method2454(var3);
                  if(var80 != null) {
                     class45.method647(var80);
                  }

                  var80 = ItemLayer.method2454(var2);
                  if(var80 != null) {
                     class45.method647(var80);
                     GZipDecompressor.method3159(class215.widgets[var80.id >>> 16], var80, true);
                  }

                  if(widgetRoot != -1) {
                     PendingSpawn.method1523(widgetRoot, 1);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_172) {
                  var52 = secretPacketBuffer2.readUnsignedByte() == 1;
                  if(var52) {
                     class31.field457 = class174.currentTimeMs() - secretPacketBuffer2.readLong();
                     class207.field2580 = new class13(secretPacketBuffer2, true);
                  } else {
                     class207.field2580 = null;
                  }

                  field1092 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_149) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var23 = secretPacketBuffer2.runeliteReadString();
                  } else {
                     var23 = secretPacketBuffer2.readString();
                     var3 = secretPacketBuffer2.method3267();
                  }

                  var54 = ItemLayer.method2454(var3);
                  if(!var23.equals(var54.text)) {
                     var54.text = var23;
                     class45.method647(var54);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_181) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var16 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var16 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(field1152 != 0 && var3 != 0 && field1154 < 50) {
                     field1098[field1154] = var2;
                     field1156[field1154] = var3;
                     field1136[field1154] = var16;
                     audioEffects[field1154] = null;
                     field1040[field1154] = 0;
                     ++field1154;
                  }

                  packetType = -1;
                  return true;
               }

               Widget var78;
               if(packetType == Opcodes.PACKET_SERVER_124) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var16 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3269();
                     var3 = secretPacketBuffer2.method3258();
                     var16 = secretPacketBuffer2.method3344();
                  }

                  var78 = ItemLayer.method2454(var2);
                  var78.field2746 = var16 + (var3 << 16);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_30) {
                  if(RUNELITE_PACKET) {
                     var16 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     CombatInfoListHolder.method1688();
                  } else {
                     CombatInfoListHolder.method1688();
                     var2 = secretPacketBuffer2.method3267();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var16 = secretPacketBuffer2.method3248();
                  }

                  skillExperiences[var16] = var2;
                  boostedSkillLevels[var16] = var3;
                  realSkillLevels[var16] = 1;

                  for(var5 = 0; var5 < 98; ++var5) {
                     if(var2 >= class222.field2826[var5]) {
                        realSkillLevels[var16] = var5 + 2;
                     }
                  }

                  field936[++field1105 - 1 & 31] = var16;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_69) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var16 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3261();
                     var3 = secretPacketBuffer2.method3267();
                     var16 = secretPacketBuffer2.method3261();
                  }

                  var78 = ItemLayer.method2454(var3);
                  if(var2 != var78.originalX || var16 != var78.originalY || var78.field2647 != 0 || var78.field2732 != 0) {
                     var78.originalX = var2;
                     var78.originalY = var16;
                     var78.field2647 = 0;
                     var78.field2732 = 0;
                     class45.method647(var78);
                     this.method1161(var78);
                     if(var78.type == 0) {
                        GZipDecompressor.method3159(class215.widgets[var3 >> 16], var78, false);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_125) {
                  var2 = secretPacketBuffer2.method3258();
                  if(var2 == 65535) {
                     var2 = -1;
                  }

                  var3 = secretPacketBuffer2.readInt();
                  var16 = secretPacketBuffer2.method3268();
                  var78 = ItemLayer.method2454(var3);
                  ItemComposition var84;
                  if(!var78.hasScript) {
                     if(var2 == -1) {
                        var78.modelType = 0;
                        packetType = -1;
                        return true;
                     }

                     var84 = FaceNormal.getItemDefinition(var2);
                     var78.modelType = 4;
                     var78.modelId = var2;
                     var78.rotationX = var84.xan2d;
                     var78.rotationZ = var84.yan2d;
                     var78.modelZoom = var84.zoom2d * 100 / var16;
                     class45.method647(var78);
                  } else {
                     var78.itemId = var2;
                     var78.itemQuantity = var16;
                     var84 = FaceNormal.getItemDefinition(var2);
                     var78.rotationX = var84.xan2d;
                     var78.rotationZ = var84.yan2d;
                     var78.rotationY = var84.zan2d;
                     var78.field2737 = var84.offsetX2d;
                     var78.field2692 = var84.offsetY2d;
                     var78.modelZoom = var84.zoom2d;
                     if(var84.isStackable == 1) {
                        var78.field2759 = 1;
                     } else {
                        var78.field2759 = 2;
                     }

                     if(var78.field2758 > 0) {
                        var78.modelZoom = var78.modelZoom * 32 / var78.field2758;
                     } else if(var78.originalWidth > 0) {
                        var78.modelZoom = var78.modelZoom * 32 / var78.originalWidth;
                     }

                     class45.method647(var78);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_188) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var16 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3268();
                     var3 = secretPacketBuffer2.method3344();
                     var16 = secretPacketBuffer2.method3248();
                  }

                  var17 = (WidgetNode)componentTable.get((long)var2);
                  if(var17 != null) {
                     class110.method2145(var17, var3 != var17.id);
                  }

                  WidgetNode var83 = new WidgetNode();
                  var83.id = var3;
                  var83.owner = var16;
                  componentTable.put(var83, (long)var2);
                  class51.method760(var3);
                  Widget var94 = ItemLayer.method2454(var2);
                  class45.method647(var94);
                  if(field1078 != null) {
                     class45.method647(field1078);
                     field1078 = null;
                  }

                  class224.method4154();
                  GZipDecompressor.method3159(class215.widgets[var2 >> 16], var94, false);
                  class208.method3976(var3);
                  if(widgetRoot != -1) {
                     PendingSpawn.method1523(widgetRoot, 1);
                  }

                  packetType = -1;
                  return true;
               }

               String var4;
               if(packetType == Opcodes.PACKET_SERVER_28) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadString();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3250();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var4 = secretPacketBuffer2.readString();
                  }

                  if(var3 >= 1 && var3 <= 8) {
                     if(var4.equalsIgnoreCase("null")) {
                        var4 = null;
                     }

                     playerOptions[var3 - 1] = var4;
                     playerOptionsPriorities[var3 - 1] = var2 == 0;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_63) {
                  World var88 = new World();
                  var88.address = secretPacketBuffer2.readString();
                  var88.id = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.readInt();
                  var88.mask = var3;
                  class72.setGameState(45);
                  class15.rssocket.close();
                  class15.rssocket = null;
                  CombatInfoListHolder.method1686(var88);
                  packetType = -1;
                  return false;
               }

               boolean var53;
               int var82;
               if(packetType == Opcodes.PACKET_SERVER_170) {
                  var23 = secretPacketBuffer2.readString();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  byte var87 = secretPacketBuffer2.readByte();
                  var53 = false;
                  if(var87 == -128) {
                     var53 = true;
                  }

                  if(var53) {
                     if(class2.clanChatCount == 0) {
                        packetType = -1;
                        return true;
                     }

                     boolean var60 = false;

                     for(var6 = 0; var6 < class2.clanChatCount && (!GraphicsObject.clanMembers[var6].username.equals(var23) || var3 != GraphicsObject.clanMembers[var6].world); ++var6) {
                        ;
                     }

                     if(var6 < class2.clanChatCount) {
                        while(var6 < class2.clanChatCount - 1) {
                           GraphicsObject.clanMembers[var6] = GraphicsObject.clanMembers[var6 + 1];
                           ++var6;
                        }

                        --class2.clanChatCount;
                        GraphicsObject.clanMembers[class2.clanChatCount] = null;
                     }
                  } else {
                     secretPacketBuffer2.readString();
                     ClanMember var81 = new ClanMember();
                     var81.username = var23;
                     var81.field919 = WidgetNode.method1087(var81.username, Permission.field3169);
                     var81.world = var3;
                     var81.rank = var87;

                     for(var7 = class2.clanChatCount - 1; var7 >= 0; --var7) {
                        var82 = GraphicsObject.clanMembers[var7].field919.compareTo(var81.field919);
                        if(var82 == 0) {
                           GraphicsObject.clanMembers[var7].world = var3;
                           GraphicsObject.clanMembers[var7].rank = var87;
                           if(var23.equals(class66.localPlayer.name)) {
                              InvType.clanChatRank = var87;
                           }

                           field1108 = cycleCntr;
                           packetType = -1;
                           return true;
                        }

                        if(var82 < 0) {
                           break;
                        }
                     }

                     if(class2.clanChatCount >= GraphicsObject.clanMembers.length) {
                        packetType = -1;
                        return true;
                     }

                     for(var82 = class2.clanChatCount - 1; var82 > var7; --var82) {
                        GraphicsObject.clanMembers[var82 + 1] = GraphicsObject.clanMembers[var82];
                     }

                     if(class2.clanChatCount == 0) {
                        GraphicsObject.clanMembers = new ClanMember[100];
                     }

                     GraphicsObject.clanMembers[var7 + 1] = var81;
                     ++class2.clanChatCount;
                     if(var23.equals(class66.localPlayer.name)) {
                        InvType.clanChatRank = var87;
                     }
                  }

                  field1108 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_161) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var16 = secretPacketBuffer2.runeliteReadInt();
                     var5 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var16 = secretPacketBuffer2.readUnsignedByte();
                     var5 = secretPacketBuffer2.readUnsignedByte();
                  }

                  field1029[var2] = true;
                  field1162[var2] = var3;
                  field1163[var2] = var16;
                  field935[var2] = var5;
                  field1165[var2] = 0;
                  packetType = -1;
                  return true;
               }

               long var35;
               if(packetType == Opcodes.PACKET_SERVER_120) {
                  var2 = secretPacketBuffer2.method3258();
                  if(var2 == 65535) {
                     var2 = -1;
                  }

                  var3 = secretPacketBuffer2.method3267();
                  var16 = secretPacketBuffer2.method3258();
                  if(var16 == 65535) {
                     var16 = -1;
                  }

                  var5 = secretPacketBuffer2.method3269();

                  for(var6 = var16; var6 <= var2; ++var6) {
                     var35 = ((long)var5 << 32) + (long)var6;
                     Node var57 = widgetFlags.get(var35);
                     if(var57 != null) {
                        var57.unlink();
                     }

                     widgetFlags.put(new IntegerNode(var3), var35);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_118) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var5 = secretPacketBuffer2.runeliteReadInt();
                     var16 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     var3 = secretPacketBuffer2.readInt();
                     var16 = secretPacketBuffer2.readUnsignedShort();
                     var5 = secretPacketBuffer2.method3344();
                  }

                  var80 = ItemLayer.method2454(var3);
                  if(var2 != var80.rotationX || var5 != var80.rotationZ || var16 != var80.modelZoom) {
                     var80.rotationX = var2;
                     var80.rotationZ = var5;
                     var80.modelZoom = var16;
                     class45.method647(var80);
                  }

                  packetType = -1;
                  return true;
               }

               long var24;
               long var26;
               int var69;
               if(packetType == Opcodes.PACKET_SERVER_98) {
                  var23 = secretPacketBuffer2.readString();
                  var24 = (long)secretPacketBuffer2.readUnsignedShort();
                  var26 = (long)secretPacketBuffer2.read24BitInt();
                  Permission[] var93 = new Permission[]{Permission.field3171, Permission.field3170, Permission.field3174, Permission.field3178, Permission.field3173, Permission.field3177};
                  Permission var61 = (Permission)class29.forOrdinal(var93, secretPacketBuffer2.readUnsignedByte());
                  long var29 = (var24 << 32) + var26;
                  boolean var96 = false;

                  for(var69 = 0; var69 < 100; ++var69) {
                     if(field1133[var69] == var29) {
                        var96 = true;
                        break;
                     }
                  }

                  if(class66.isIgnored(var23)) {
                     var96 = true;
                  }

                  if(!var96 && field1033 == 0) {
                     field1133[field1134] = var29;
                     field1134 = (field1134 + 1) % 100;
                     String var32 = FontTypeFace.appendTags(CombatInfoListHolder.method1692(class3.method7(secretPacketBuffer2)));
                     byte var70;
                     if(var61.field3179) {
                        var70 = 7;
                     } else {
                        var70 = 3;
                     }

                     if(var61.field3176 != -1) {
                        class174.sendGameMessage(var70, AbstractByteBuffer.method3475(var61.field3176) + var23, var32);
                     } else {
                        class174.sendGameMessage(var70, var23, var32);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               boolean var55;
               if(packetType == Opcodes.PACKET_SERVER_202) {
                  var2 = secretPacketBuffer2.getUSmart();
                  var55 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var4 = "";
                  var53 = false;
                  if(var55) {
                     var4 = secretPacketBuffer2.readString();
                     if(class66.isIgnored(var4)) {
                        var53 = true;
                     }
                  }

                  String var79 = secretPacketBuffer2.readString();
                  if(!var53) {
                     class174.sendGameMessage(var2, var4, var79);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_213) {
                  var23 = secretPacketBuffer2.readString();
                  Object[] var71 = new Object[var23.length() + 1];

                  for(var16 = var23.length() - 1; var16 >= 0; --var16) {
                     if(var23.charAt(var16) == 's') {
                        var71[var16 + 1] = secretPacketBuffer2.readString();
                     } else {
                        var71[var16 + 1] = new Integer(secretPacketBuffer2.readInt());
                     }
                  }

                  var71[0] = new Integer(secretPacketBuffer2.readInt());
                  ScriptEvent var58 = new ScriptEvent();
                  var58.field849 = var71;
                  class56.method817(var58);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_241) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var55 = (var2 & 1) == 1;
                     var4 = secretPacketBuffer2.readString();
                     String var76 = secretPacketBuffer2.readString();
                     secretPacketBuffer2.readString();

                     for(var6 = 0; var6 < ignoreCount; ++var6) {
                        Ignore var92 = ignores[var6];
                        if(var55) {
                           if(var76.equals(var92.name)) {
                              var92.name = var4;
                              var92.previousName = var76;
                              var4 = null;
                              break;
                           }
                        } else if(var4.equals(var92.name)) {
                           var92.name = var4;
                           var92.previousName = var76;
                           var4 = null;
                           break;
                        }
                     }

                     if(var4 != null && ignoreCount < 400) {
                        Ignore var77 = new Ignore();
                        ignores[ignoreCount] = var77;
                        var77.name = var4;
                        var77.previousName = var76;
                        ++ignoreCount;
                     }
                  }

                  field1191 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_99) {
                  field1160 = true;
                  class210.field2590 = secretPacketBuffer2.readUnsignedByte();
                  Frames.field2124 = secretPacketBuffer2.readUnsignedByte();
                  Actor.field1271 = secretPacketBuffer2.readUnsignedShort();
                  class47.field620 = secretPacketBuffer2.readUnsignedByte();
                  class90.field1448 = secretPacketBuffer2.readUnsignedByte();
                  if(class90.field1448 >= 100) {
                     AbstractByteBuffer.cameraX = class210.field2590 * 128 + 64;
                     World.cameraY = Frames.field2124 * 128 + 64;
                     class229.cameraZ = class41.getTileHeight(AbstractByteBuffer.cameraX, World.cameraY, class46.plane) - Actor.field1271;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_67) {
                  field1160 = true;
                  class203.field2497 = secretPacketBuffer2.readUnsignedByte();
                  class14.field292 = secretPacketBuffer2.readUnsignedByte();
                  class23.field366 = secretPacketBuffer2.readUnsignedShort();
                  Friend.field824 = secretPacketBuffer2.readUnsignedByte();
                  class66.field830 = secretPacketBuffer2.readUnsignedByte();
                  if(class66.field830 >= 100) {
                     var2 = class203.field2497 * 128 + 64;
                     var3 = class14.field292 * 128 + 64;
                     var16 = class41.getTileHeight(var2, var3, class46.plane) - class23.field366;
                     var5 = var2 - AbstractByteBuffer.cameraX;
                     var6 = var16 - class229.cameraZ;
                     var7 = var3 - World.cameraY;
                     var82 = (int)Math.sqrt((double)(var5 * var5 + var7 * var7));
                     class18.cameraPitch = (int)(Math.atan2((double)var6, (double)var82) * 325.949D) & 2047;
                     CombatInfo1.cameraYaw = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                     if(class18.cameraPitch < 128) {
                        class18.cameraPitch = 128;
                     }

                     if(class18.cameraPitch > 383) {
                        class18.cameraPitch = 383;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               long var37;
               if(packetType == Opcodes.PACKET_SERVER_205) {
                  var23 = secretPacketBuffer2.readString();
                  var24 = secretPacketBuffer2.readLong();
                  var26 = (long)secretPacketBuffer2.readUnsignedShort();
                  var35 = (long)secretPacketBuffer2.read24BitInt();
                  Permission[] var9 = new Permission[]{Permission.field3171, Permission.field3170, Permission.field3174, Permission.field3178, Permission.field3173, Permission.field3177};
                  Permission var66 = (Permission)class29.forOrdinal(var9, secretPacketBuffer2.readUnsignedByte());
                  var37 = (var26 << 32) + var35;
                  boolean var13 = false;

                  for(int var14 = 0; var14 < 100; ++var14) {
                     if(var37 == field1133[var14]) {
                        var13 = true;
                        break;
                     }
                  }

                  if(var66.field3172 && class66.isIgnored(var23)) {
                     var13 = true;
                  }

                  if(!var13 && field1033 == 0) {
                     field1133[field1134] = var37;
                     field1134 = (field1134 + 1) % 100;
                     String var39 = FontTypeFace.appendTags(CombatInfoListHolder.method1692(class3.method7(secretPacketBuffer2)));
                     if(var66.field3176 != -1) {
                        class39.addChatMessage(9, AbstractByteBuffer.method3475(var66.field3176) + var23, var39, Overlay.method4776(var24));
                     } else {
                        class39.addChatMessage(9, var23, var39, Overlay.method4776(var24));
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_140) {
                  field940 = secretPacketBuffer2.readUnsignedByte();
                  if(field940 == 1) {
                     field941 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(field940 >= 2 && field940 <= 6) {
                     if(field940 == 2) {
                        field946 = 64;
                        field1139 = 64;
                     }

                     if(field940 == 3) {
                        field946 = 0;
                        field1139 = 64;
                     }

                     if(field940 == 4) {
                        field946 = 128;
                        field1139 = 64;
                     }

                     if(field940 == 5) {
                        field946 = 64;
                        field1139 = 0;
                     }

                     if(field940 == 6) {
                        field946 = 64;
                        field1139 = 128;
                     }

                     field940 = 2;
                     hintArrowX = secretPacketBuffer2.readUnsignedShort();
                     hintArrowY = secretPacketBuffer2.readUnsignedShort();
                     hintArrowType = secretPacketBuffer2.readUnsignedByte();
                  }

                  if(field940 == 10) {
                     field1053 = secretPacketBuffer2.readUnsignedShort();
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_212) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += 32768;
                  }

                  if(var2 >= 0) {
                     var54 = ItemLayer.method2454(var2);
                  } else {
                     var54 = null;
                  }

                  if(var54 != null) {
                     for(var5 = 0; var5 < var54.itemIds.length; ++var5) {
                        var54.itemIds[var5] = 0;
                        var54.itemQuantities[var5] = 0;
                     }
                  }

                  ItemContainer var74 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
                  if(var74 != null) {
                     for(var6 = 0; var6 < var74.itemIds.length; ++var6) {
                        var74.itemIds[var6] = -1;
                        var74.stackSizes[var6] = 0;
                     }
                  }

                  var5 = secretPacketBuffer2.readUnsignedShort();

                  for(var6 = 0; var6 < var5; ++var6) {
                     var7 = secretPacketBuffer2.method3344();
                     var82 = secretPacketBuffer2.readUnsignedByte();
                     if(var82 == 255) {
                        var82 = secretPacketBuffer2.method3268();
                     }

                     if(var54 != null && var6 < var54.itemIds.length) {
                        var54.itemIds[var6] = var7;
                        var54.itemQuantities[var6] = var82;
                     }

                     GroundObject.setItemTableSlot(var3, var6, var7 - 1, var82);
                  }

                  if(var54 != null) {
                     class45.method647(var54);
                  }

                  CombatInfoListHolder.method1688();
                  interfaceItemTriggers[++field1103 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_60) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += 32768;
                  }

                  if(var2 >= 0) {
                     var54 = ItemLayer.method2454(var2);
                  } else {
                     var54 = null;
                  }

                  for(; secretPacketBuffer2.offset < packetLength; GroundObject.setItemTableSlot(var3, var5, var6 - 1, var7)) {
                     var5 = secretPacketBuffer2.getUSmart();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = 0;
                     if(var6 != 0) {
                        var7 = secretPacketBuffer2.readUnsignedByte();
                        if(var7 == 255) {
                           var7 = secretPacketBuffer2.readInt();
                        }
                     }

                     if(var54 != null && var5 >= 0 && var5 < var54.itemIds.length) {
                        var54.itemIds[var5] = var6;
                        var54.itemQuantities[var5] = var7;
                     }
                  }

                  if(var54 != null) {
                     class45.method647(var54);
                  }

                  CombatInfoListHolder.method1688();
                  interfaceItemTriggers[++field1103 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               boolean var20;
               int var85;
               if(packetType == Opcodes.PACKET_SERVER_111) {
                  field1108 = cycleCntr;
                  if(packetLength == 0) {
                     clanChatOwner = null;
                     clanChatName = null;
                     class2.clanChatCount = 0;
                     GraphicsObject.clanMembers = null;
                     packetType = -1;
                     return true;
                  }

                  clanChatName = secretPacketBuffer2.readString();
                  long var46 = secretPacketBuffer2.readLong();
                  var26 = var46;
                  if(var46 > 0L && var46 < 6582952005840035281L) {
                     if(0L == var46 % 37L) {
                        var4 = null;
                     } else {
                        var7 = 0;

                        for(var42 = var46; 0L != var42; var42 /= 37L) {
                           ++var7;
                        }

                        StringBuilder var64 = new StringBuilder(var7);

                        while(var26 != 0L) {
                           var37 = var26;
                           var26 /= 37L;
                           var64.append(class268.field3675[(int)(var37 - 37L * var26)]);
                        }

                        var4 = var64.reverse().toString();
                     }
                  } else {
                     var4 = null;
                  }

                  clanChatOwner = var4;
                  WallObject.field2109 = secretPacketBuffer2.readByte();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  if(var7 == 255) {
                     packetType = -1;
                     return true;
                  }

                  class2.clanChatCount = var7;
                  ClanMember[] var59 = new ClanMember[100];

                  for(var85 = 0; var85 < class2.clanChatCount; ++var85) {
                     var59[var85] = new ClanMember();
                     var59[var85].username = secretPacketBuffer2.readString();
                     var59[var85].field919 = WidgetNode.method1087(var59[var85].username, Permission.field3169);
                     var59[var85].world = secretPacketBuffer2.readUnsignedShort();
                     var59[var85].rank = secretPacketBuffer2.readByte();
                     secretPacketBuffer2.readString();
                     if(var59[var85].username.equals(class66.localPlayer.name)) {
                        InvType.clanChatRank = var59[var85].rank;
                     }
                  }

                  var20 = false;
                  int var31 = class2.clanChatCount;

                  while(var31 > 0) {
                     var20 = true;
                     --var31;

                     for(var69 = 0; var69 < var31; ++var69) {
                        if(var59[var69].field919.compareTo(var59[var69 + 1].field919) > 0) {
                           ClanMember var65 = var59[var69];
                           var59[var69] = var59[var69 + 1];
                           var59[var69 + 1] = var65;
                           var20 = false;
                        }
                     }

                     if(var20) {
                        break;
                     }
                  }

                  GraphicsObject.clanMembers = var59;
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_253) {
                  var2 = packetLength + secretPacketBuffer2.offset;
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  var16 = secretPacketBuffer2.readUnsignedShort();
                  if(var3 != widgetRoot) {
                     widgetRoot = var3;
                     this.method1160(false);
                     class51.method760(widgetRoot);
                     class208.method3976(widgetRoot);

                     for(var5 = 0; var5 < 100; ++var5) {
                        field1119[var5] = true;
                     }
                  }

                  WidgetNode var56;
                  for(; var16-- > 0; var56.field839 = true) {
                     var5 = secretPacketBuffer2.readInt();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     var56 = (WidgetNode)componentTable.get((long)var5);
                     if(var56 != null && var6 != var56.id) {
                        class110.method2145(var56, true);
                        var56 = null;
                     }

                     if(var56 == null) {
                        WidgetNode var62 = new WidgetNode();
                        var62.id = var6;
                        var62.owner = var7;
                        componentTable.put(var62, (long)var5);
                        class51.method760(var6);
                        Widget var67 = ItemLayer.method2454(var5);
                        class45.method647(var67);
                        if(field1078 != null) {
                           class45.method647(field1078);
                           field1078 = null;
                        }

                        class224.method4154();
                        GZipDecompressor.method3159(class215.widgets[var5 >> 16], var67, false);
                        class208.method3976(var6);
                        if(widgetRoot != -1) {
                           PendingSpawn.method1523(widgetRoot, 1);
                        }

                        var56 = var62;
                     }
                  }

                  for(var17 = (WidgetNode)componentTable.method3637(); var17 != null; var17 = (WidgetNode)componentTable.method3638()) {
                     if(var17.field839) {
                        var17.field839 = false;
                     } else {
                        class110.method2145(var17, true);
                     }
                  }

                  widgetFlags = new HashTable(512);

                  while(secretPacketBuffer2.offset < var2) {
                     var5 = secretPacketBuffer2.readInt();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = secretPacketBuffer2.readUnsignedShort();
                     var82 = secretPacketBuffer2.readInt();

                     for(var85 = var6; var85 <= var7; ++var85) {
                        var21 = ((long)var5 << 32) + (long)var85;
                        widgetFlags.put(new IntegerNode(var82), var21);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_142) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var52 = secretPacketBuffer2.readUnsignedByte() == 1;
                     var15 = secretPacketBuffer2.readString();
                     var4 = secretPacketBuffer2.readString();
                     var5 = secretPacketBuffer2.readUnsignedShort();
                     var6 = secretPacketBuffer2.readUnsignedByte();
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     boolean var19 = (var7 & 2) != 0;
                     var20 = (var7 & 1) != 0;
                     if(var5 > 0) {
                        secretPacketBuffer2.readString();
                        secretPacketBuffer2.readUnsignedByte();
                        secretPacketBuffer2.readInt();
                     }

                     secretPacketBuffer2.readString();

                     for(int var33 = 0; var33 < friendCount; ++var33) {
                        Friend var11 = friends[var33];
                        if(!var52) {
                           if(var15.equals(var11.name)) {
                              if(var5 != var11.world) {
                                 boolean var12 = true;

                                 for(class66 var34 = (class66)field1182.method3722(); var34 != null; var34 = (class66)field1182.method3725()) {
                                    if(var34.field828.equals(var15)) {
                                       if(var5 != 0 && var34.field829 == 0) {
                                          var34.method3726();
                                          var12 = false;
                                       } else if(var5 == 0 && var34.field829 != 0) {
                                          var34.method3726();
                                          var12 = false;
                                       }
                                    }
                                 }

                                 if(var12) {
                                    field1182.method3721(new class66(var15, var5));
                                 }

                                 var11.world = var5;
                              }

                              var11.previousName = var4;
                              var11.rank = var6;
                              var11.field819 = var19;
                              var11.field820 = var20;
                              var15 = null;
                              break;
                           }
                        } else if(var4.equals(var11.name)) {
                           var11.name = var15;
                           var11.previousName = var4;
                           var15 = null;
                           break;
                        }
                     }

                     if(var15 != null && friendCount < 400) {
                        Friend var10 = new Friend();
                        friends[friendCount] = var10;
                        var10.name = var15;
                        var10.previousName = var4;
                        var10.world = var5;
                        var10.rank = var6;
                        var10.field819 = var19;
                        var10.field820 = var20;
                        ++friendCount;
                     }
                  }

                  field1180 = 2;
                  field1191 = cycleCntr;
                  var52 = false;
                  var3 = friendCount;

                  while(var3 > 0) {
                     var52 = true;
                     --var3;

                     for(var16 = 0; var16 < var3; ++var16) {
                        var53 = false;
                        Friend var18 = friends[var16];
                        Friend var28 = friends[var16 + 1];
                        if(var18.world != world && var28.world == world) {
                           var53 = true;
                        }

                        if(!var53 && var18.world == 0 && var28.world != 0) {
                           var53 = true;
                        }

                        if(!var53 && !var18.field819 && var28.field819) {
                           var53 = true;
                        }

                        if(!var53 && !var18.field820 && var28.field820) {
                           var53 = true;
                        }

                        if(var53) {
                           Friend var8 = friends[var16];
                           friends[var16] = friends[var16 + 1];
                           friends[var16 + 1] = var8;
                           var52 = false;
                        }
                     }

                     if(var52) {
                        break;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_143) {
                  WidgetNode.xteaChanged(false);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  class81.method1665(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_168) {
                  WidgetNode.xteaChanged(true);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  class81.method1665(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_31) {
                  class23.method175(true);
                  packetType = -1;
                  return true;
               }

               if(packetType == Opcodes.PACKET_SERVER_220) {
                  class23.method175(false);
                  packetType = -1;
                  return true;
               }

               if(packetType != Opcodes.PACKET_SERVER_173) {
                  if(packetType == Opcodes.PACKET_SERVER_61) {
                     class44.field596 = secretPacketBuffer2.method3248();
                     World.field1296 = secretPacketBuffer2.readUnsignedShortOb1();

                     while(secretPacketBuffer2.offset < packetLength) {
                        packetType = secretPacketBuffer2.readUnsignedByte();
                        class72.method1109();
                     }

                     packetType = -1;
                     return true;
                  }

                  class46.method680("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
                  ChatLineBuffer.method1916();
                  return true;
               }
            }

            class72.method1109();
            packetType = -1;
            return true;
         } catch (IOException var50) {
            class60.method1028();
         } catch (Exception var51) {
            var23 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (class66.localPlayer.pathX[0] + class22.baseX * 411265) + "," + (class66.localPlayer.pathY[0] + class273.baseY) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var23 = var23 + secretPacketBuffer2.payload[var3] + ",";
            }

            class46.method680(var23, var51);
            ChatLineBuffer.method1916();
         }

         return true;
      }
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1718893102"
   )
   final void method1159(int var1, int var2) {
      int var3 = class155.field2238.method4848("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = class155.field2238;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargets[var4].length() > 0) {
            var6 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var6 = menuOptions[var4];
         }

         int var7 = var5.method4848(var6);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      int var8 = var1 - var3 / 2;
      if(var3 + var8 > Timer.canvasWidth) {
         var8 = Timer.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var2 + var4 > GameEngine.canvasHeight) {
         var9 = GameEngine.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      class3.region.method2754(class46.plane, var1, var2, false);
      isMenuOpen = true;
      class10.menuX = var8;
      class29.menuY = var9;
      ScriptVarType.menuWidth = var3;
      class17.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1709088746"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      class205.method3905();
      ScriptVarType.method29();
      KeyFocusListener.method756();
      KeyFocusListener var1 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field667 = KeyFocusListener.field639;
         KeyFocusListener.field666 = 0;
         int var2;
         if(KeyFocusListener.field662 >= 0) {
            while(KeyFocusListener.field653 != KeyFocusListener.field662) {
               var2 = KeyFocusListener.field660[KeyFocusListener.field653];
               KeyFocusListener.field653 = KeyFocusListener.field653 + 1 & 127;
               if(var2 < 0) {
                  KeyFocusListener.field659[~var2] = false;
               } else {
                  if(!KeyFocusListener.field659[var2] && KeyFocusListener.field666 < KeyFocusListener.field671.length - 1) {
                     KeyFocusListener.field671[++KeyFocusListener.field666 - 1] = var2;
                  }

                  KeyFocusListener.field659[var2] = true;
               }
            }
         } else {
            for(var2 = 0; var2 < 112; ++var2) {
               KeyFocusListener.field659[var2] = false;
            }

            KeyFocusListener.field662 = KeyFocusListener.field653;
         }

         if(KeyFocusListener.field666 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field639 = KeyFocusListener.field661;
      }

      MouseInput var8 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.field750 = MouseInput.field760 * -1725731803;
         MouseInput.field756 = MouseInput.mouseX;
         MouseInput.field741 = MouseInput.mouseY;
         MouseInput.field743 = MouseInput.field752;
         MouseInput.field757 = MouseInput.field753;
         MouseInput.field758 = MouseInput.field744;
         MouseInput.field759 = MouseInput.field755;
         MouseInput.field752 = 0;
      }

      if(Actor.field1244 != null) {
         int var5 = Actor.field1244.vmethod3019();
         field1112 = var5;
      }

      if(gameState == 0) {
         FileOnDisk.load();
         AbstractSoundSystem.method2116();
      } else if(gameState == 5) {
         Tile.method2551(this);
         FileOnDisk.load();
         AbstractSoundSystem.method2116();
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            Tile.method2551(this);
            this.method1272();
         } else if(gameState == 25) {
            WorldMapType2.method515();
         }
      } else {
         Tile.method2551(this);
      }

      if(gameState == 30) {
         this.method1152();
      } else if(gameState == 40 || gameState == 45) {
         this.method1272();
      }

   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-30"
   )
   void method1149() {
      if(class238.field3263 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3264 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field952 = 3000;
            class238.field3264 = 3;
         }

         if(--field952 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class224.socket = GameEngine.taskManager.createSocket(class35.host, class51.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class224.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class224.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  class174.rssocket = new RSSocket((Socket)class224.socket.value, GameEngine.taskManager);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(156);
                  class174.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  field1006 = class174.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && class174.rssocket.available() <= 0) {
                     if(class174.currentTimeMs() - field1006 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var5 = class174.rssocket.readByte();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var10 = class174.rssocket;
                  boolean var2 = gameState > 20;
                  if(class238.field3255 != null) {
                     try {
                        class238.field3255.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class238.field3255 = null;
                  }

                  class238.field3255 = var10;
                  class34.sendConInfo(var2);
                  class238.field3246.offset = 0;
                  class238.currentRequest = null;
                  ScriptEvent.field858 = null;
                  class238.field3251 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class238.field3244.method3637();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class238.field3254.method3637();
                           if(var3 == null) {
                              if(class238.field3262 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class238.field3262);
                                    var11.putShort(0);
                                    class238.field3255.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class238.field3255.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class238.field3264;
                                    class238.field3255 = null;
                                 }
                              }

                              class238.field3245 = 0;
                              class238.field3258 = class174.currentTimeMs();
                              class224.socket = null;
                              class174.rssocket = null;
                              js5State = 0;
                              field955 = 0;
                              return;
                           }

                           class238.field3261.setHead(var3);
                           class238.field3252.put(var3, var3.hash);
                           ++class238.field3253;
                           --class238.field3259;
                        }
                     }

                     class238.field3247.put(var3, var3.hash);
                     ++class238.field3248;
                     --class238.field3250;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "428682471"
   )
   final void method1467() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(WorldMapData.loadWidget(var1)) {
            WorldMapType3.method214(class215.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1117; ++var1) {
         if(field1119[var1]) {
            field1120[var1] = true;
         }

         field1056[var1] = field1119[var1];
         field1119[var1] = false;
      }

      field1057 = gameCycle;
      field1063 = -1;
      field1064 = -1;
      class94.field1498 = null;
      if(widgetRoot != -1) {
         field1117 = 0;
         class54.method778(widgetRoot, 0, 0, Timer.canvasWidth, GameEngine.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      int var4;
      int var6;
      int var7;
      int var8;
      if(!isMenuOpen) {
         if(field1063 != -1) {
            Frames.method2907(field1063, field1064);
         }
      } else {
         var1 = class10.menuX;
         var2 = class29.menuY;
         var3 = ScriptVarType.menuWidth;
         var4 = class17.menuHeight;
         int var5 = 6116423;
         Rasterizer2D.method5045(var1, var2, var3, var4, var5);
         Rasterizer2D.method5045(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         class155.field2238.method4842("Choose Option", var1 + 3, var2 + 14, var5, -1);
         var6 = MouseInput.field756;
         var7 = MouseInput.field741;

         int var9;
         int var10;
         for(var8 = 0; var8 < menuOptionCount; ++var8) {
            var9 = var2 + (menuOptionCount - 1 - var8) * 15 + 31;
            var10 = 16777215;
            if(var6 > var1 && var6 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            Font var11 = class155.field2238;
            String var12;
            if(var8 < 0) {
               var12 = "";
            } else if(menuTargets[var8].length() > 0) {
               var12 = menuOptions[var8] + " " + menuTargets[var8];
            } else {
               var12 = menuOptions[var8];
            }

            var11.method4842(var12, var1 + 3, var9, var10, 0);
         }

         var8 = class10.menuX;
         var9 = class29.menuY;
         var10 = ScriptVarType.menuWidth;
         int var13 = class17.menuHeight;

         for(int var14 = 0; var14 < field1117; ++var14) {
            if(widgetPositionX[var14] + widgetBoundsWidth[var14] > var8 && widgetPositionX[var14] < var8 + var10 && widgetBoundsHeight[var14] + widgetPositionY[var14] > var9 && widgetPositionY[var14] < var9 + var13) {
               field1120[var14] = true;
            }
         }
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1117; ++var1) {
            if(field1056[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1120[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class46.plane;
      var2 = class66.localPlayer.x;
      var3 = class66.localPlayer.y;
      var4 = field1004;

      for(class80 var15 = (class80)class80.field1323.getFront(); var15 != null; var15 = (class80)class80.field1323.getNext()) {
         if(var15.field1318 != -1 || var15.field1319 != null) {
            var6 = 0;
            if(var2 > var15.field1315) {
               var6 += var2 - var15.field1315;
            } else if(var2 < var15.field1313) {
               var6 += var15.field1313 - var2;
            }

            if(var3 > var15.field1316) {
               var6 += var3 - var15.field1316;
            } else if(var3 < var15.field1314) {
               var6 += var15.field1314 - var3;
            }

            if(var6 - 64 <= var15.field1311 && field922 != 0 && var1 == var15.field1312) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               var7 = (var15.field1311 - var6) * field922 / var15.field1311;
               Object var10000;
               if(var15.field1317 == null) {
                  if(var15.field1318 >= 0) {
                     var10000 = null;
                     SoundEffect var16 = SoundEffect.getTrack(class15.field310, var15.field1318, 0);
                     if(var16 != null) {
                        class105 var17 = var16.method1978().method2026(class251.field3390);
                        class115 var18 = class115.method2314(var17, 100, var7);
                        var18.method2175(-1);
                        class11.field278.method1919(var18);
                        var15.field1317 = var18;
                     }
                  }
               } else {
                  var15.field1317.method2176(var7);
               }

               if(var15.field1324 == null) {
                  if(var15.field1319 != null && (var15.field1322 -= var4) <= 0) {
                     var8 = (int)(Math.random() * (double)var15.field1319.length);
                     var10000 = null;
                     SoundEffect var20 = SoundEffect.getTrack(class15.field310, var15.field1319[var8], 0);
                     if(var20 != null) {
                        class105 var21 = var20.method1978().method2026(class251.field3390);
                        class115 var19 = class115.method2314(var21, 100, var7);
                        var19.method2175(0);
                        class11.field278.method1919(var19);
                        var15.field1324 = var19;
                        var15.field1322 = var15.field1320 + (int)(Math.random() * (double)(var15.field1321 - var15.field1320));
                     }
                  }
               } else {
                  var15.field1324.method2176(var7);
                  if(!var15.field1324.linked()) {
                     var15.field1324 = null;
                  }
               }
            } else {
               if(var15.field1317 != null) {
                  class11.field278.method1920(var15.field1317);
                  var15.field1317 = null;
               }

               if(var15.field1324 != null) {
                  class11.field278.method1920(var15.field1324);
                  var15.field1324 = null;
               }
            }
         }
      }

      field1004 = 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "93"
   )
   protected final void vmethod1264() {
      field1141 = class174.currentTimeMs() + 500L;
      this.method1154();
      if(widgetRoot != -1) {
         this.method1160(true);
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "187"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1146(boolean var1) {
      boolean var2;
      label186: {
         try {
            if(class203.field2500 == 2) {
               if(Ignore.field863 == null) {
                  Ignore.field863 = Track1.getMusicFile(class87.field1392, class203.field2502, class203.field2505);
                  if(Ignore.field863 == null) {
                     var2 = false;
                     break label186;
                  }
               }

               if(class203.field2504 == null) {
                  class203.field2504 = new class110(class203.field2503, class203.field2498);
               }

               if(class203.field2499.method3783(Ignore.field863, class203.field2501, class203.field2504, 22050)) {
                  class203.field2499.method3784();
                  class203.field2499.method3834(class10.field268);
                  class203.field2499.method3782(Ignore.field863, DynamicObject.field1539);
                  class203.field2500 = 0;
                  Ignore.field863 = null;
                  class203.field2504 = null;
                  class87.field1392 = null;
                  var2 = true;
                  break label186;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class203.field2499.method3787();
            class203.field2500 = 0;
            Ignore.field863 = null;
            class203.field2504 = null;
            class87.field1392 = null;
         }

         var2 = false;
      }

      if(var2 && field1151 && ItemLayer.soundSystem0 != null) {
         ItemLayer.soundSystem0.method2061();
      }

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1141 && class174.currentTimeMs() > field1141) {
         var4 = SceneTilePaint.method2713();
         field1141 = 0L;
         if(var4 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         if(SceneTilePaint.method2713() == 1) {
            class7.clientInstance.method837(765, 503);
         } else {
            class7.clientInstance.method837(7680, 2160);
         }

         if(gameState >= 25) {
            secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_RESIZE_CLIENT_FRAME);
            secretPacketBuffer1.putByte(SceneTilePaint.method2713());
            secretPacketBuffer1.putShort(Timer.canvasWidth);
            secretPacketBuffer1.putShort(GameEngine.canvasHeight);
         }
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1119[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class90.loadingBarPercentage, class90.loadingText, var1);
      } else if(gameState == 5) {
         class5.drawLoginScreen(class155.field2238, Projectile.field1477, class9.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class5.drawLoginScreen(class155.field2238, Projectile.field1477, class9.font_p12full, var1);
         } else if(gameState == 25) {
            if(field985 == 1) {
               if(field981 > field982) {
                  field982 = field981;
               }

               var4 = (field982 * 50 - field981 * 50) / field982;
               class24.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field985 == 2) {
               if(field983 > field984) {
                  field984 = field983;
               }

               var4 = (field984 * 50 - field983 * 50) / field984 + 50;
               class24.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class24.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1467();
         } else if(gameState == 40) {
            class24.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class24.drawStatusBox("Please wait...", false);
         }
      } else {
         class5.drawLoginScreen(class155.field2238, Projectile.field1477, class9.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < field1117; ++var4) {
            if(field1120[var4]) {
               GameEngine.field733.vmethod5123(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1120[var4] = false;
            }
         }
      } else if(gameState > 0) {
         GameEngine.field733.vmethod5121(0, 0);

         for(var4 = 0; var4 < field1117; ++var4) {
            field1120[var4] = false;
         }
      }

   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "12"
   )
   final void method1272() {
      try {
         if(loginState == 0) {
            if(class15.rssocket != null) {
               class15.rssocket.close();
               class15.rssocket = null;
            }

            class132.field1990 = null;
            socketError = false;
            field957 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class132.field1990 == null) {
               class132.field1990 = GameEngine.taskManager.createSocket(class35.host, class51.myWorldPort);
            }

            if(class132.field1990.status == 2) {
               throw new IOException();
            }

            if(class132.field1990.status == 1) {
               class15.rssocket = new RSSocket((Socket)class132.field1990.value, GameEngine.taskManager);
               class132.field1990 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            class15.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(ItemLayer.soundSystem0 != null) {
               ItemLayer.soundSystem0.method2089();
            }

            if(class1.soundSystem1 != null) {
               class1.soundSystem1.method2089();
            }

            var1 = class15.rssocket.readByte();
            if(ItemLayer.soundSystem0 != null) {
               ItemLayer.soundSystem0.method2089();
            }

            if(class1.soundSystem1 != null) {
               class1.soundSystem1.method2089();
            }

            if(var1 != 0) {
               class257.method4723(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = class15.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  class15.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class7.field243 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         int var6;
         int var7;
         if(loginState == 5) {
            int[] var9 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class7.field243 >> 32), (int)(class7.field243 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(field1002.rsOrdinal());
            secretPacketBuffer1.putInt(var9[0]);
            secretPacketBuffer1.putInt(var9[1]);
            secretPacketBuffer1.putInt(var9[2]);
            secretPacketBuffer1.putInt(var9[3]);
            switch(field1002.field2198) {
            case 0:
               secretPacketBuffer1.offset += 8;
               break;
            case 1:
               PacketBuffer var12 = secretPacketBuffer1;
               LinkedHashMap var13 = class70.preferences.preferences;
               String var5 = class90.username;
               var6 = var5.length();
               var7 = 0;

               for(int var8 = 0; var8 < var6; ++var8) {
                  var7 = (var7 << 5) - var7 + var5.charAt(var8);
               }

               var12.putInt(((Integer)var13.get(Integer.valueOf(var7))).intValue());
               secretPacketBuffer1.offset += 4;
               break;
            case 2:
            case 3:
               secretPacketBuffer1.put24bitInt(class41.field585);
               secretPacketBuffer1.offset += 5;
            }

            secretPacketBuffer1.putString(class90.password);
            secretPacketBuffer1.encryptRsa(class88.rsaKeyExponent, class88.rsaKeyModulus);
            field968.offset = 0;
            if(gameState == 40) {
               field968.putByte(18);
            } else {
               field968.putByte(16);
            }

            field968.putShort(0);
            var2 = field968.offset;
            field968.putInt(156);
            field968.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field968.offset;
            field968.putString(class90.username);
            field968.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            field968.putShort(Timer.canvasWidth);
            field968.putShort(GameEngine.canvasHeight);
            PacketBuffer var4 = field968;
            if(field942 != null) {
               var4.putBytes(field942, 0, field942.length);
            } else {
               byte[] var20 = class251.method4530();
               var4.putBytes(var20, 0, var20.length);
            }

            field968.putString(Timer.sessionToken);
            field968.putInt(field929);
            Buffer var21 = new Buffer(class226.field3137.method5502());
            class226.field3137.method5500(var21);
            field968.putBytes(var21.payload, 0, var21.payload.length);
            field968.putByte(WorldMapData.field473);
            field968.putInt(0);
            field968.putInt(class174.indexInterfaces.crc);
            field968.putInt(WorldMapData.indexSoundEffects.crc);
            field968.putInt(class8.configsIndex.crc);
            field968.putInt(DecorativeObject.field2162.crc);
            field968.putInt(class15.field310.crc);
            field968.putInt(class18.indexMaps.crc);
            field968.putInt(class37.indexTrack1.crc);
            field968.putInt(class14.indexModels.crc);
            field968.putInt(class3.indexSprites.crc);
            field968.putInt(indexTextures.crc);
            field968.putInt(class89.field1409.crc);
            field968.putInt(ScriptEvent.indexTrack2.crc);
            field968.putInt(WorldMapType1.indexScripts.crc);
            field968.putInt(BaseVarType.field41.crc);
            field968.putInt(ItemContainer.vorbisIndex.crc);
            field968.putInt(World.field1295.crc);
            field968.putInt(class232.indexWorldMap.crc);
            field968.encryptXtea(var9, var3, field968.offset);
            field968.putShortLength(field968.offset - var2);
            class15.rssocket.queueForWrite(field968.payload, 0, field968.offset);
            secretPacketBuffer1.seed(var9);

            for(var6 = 0; var6 < 4; ++var6) {
               var9[var6] += 50;
            }

            secretPacketBuffer2.seed(var9);
            loginState = 6;
         }

         if(loginState == 6 && class15.rssocket.available() > 0) {
            var1 = class15.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field1184 < 1) {
               ++field1184;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class257.method4723(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && class15.rssocket.available() > 0) {
            field959 = (class15.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field957 = 0;
            class36.method481("You have only just left another world.", "Your profile will be transferred in:", field959 / 60 + " seconds.");
            if(--field959 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && class15.rssocket.available() >= 13) {
               boolean var18 = class15.rssocket.readByte() == 1;
               class15.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var17 = false;
               if(var18) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  String var19 = class90.username;
                  int var10 = var19.length();
                  var6 = 0;

                  for(var7 = 0; var7 < var10; ++var7) {
                     var6 = (var6 << 5) - var6 + var19.charAt(var7);
                  }

                  if(class70.preferences.preferences.size() >= 10 && !class70.preferences.preferences.containsKey(Integer.valueOf(var6))) {
                     Iterator var11 = class70.preferences.preferences.entrySet().iterator();
                     var11.next();
                     var11.remove();
                  }

                  class70.preferences.preferences.put(Integer.valueOf(var6), Integer.valueOf(var2));
               }

               if(class90.field1439) {
                  class70.preferences.field1299 = class90.username;
               } else {
                  class70.preferences.field1299 = null;
               }

               WorldMapType3.method215();
               rights = class15.rssocket.readByte();
               field1083 = class15.rssocket.readByte() == 1;
               localInteractingIndex = class15.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += class15.rssocket.readByte();
               field1036 = class15.rssocket.readByte();
               class15.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               class15.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  Client var26 = class7.clientInstance;
                  JSObject.getWindow(var26).call("zap", (Object[])null);
               } catch (Throwable var15) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(class15.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  class15.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  field979.method4994();
                  field1142 = 1L;
                  field978 = -1;
                  class56.field695.field871 = 0;
                  RSSocket.field2267 = true;
                  field937 = true;
                  field1138 = -1L;
                  GrandExchangeOffer.method116();
                  secretPacketBuffer1.offset = 0;
                  secretPacketBuffer2.offset = 0;
                  packetType = -1;
                  lastFrameId = -1;
                  secondLastFrameId = -1;
                  thridLastFrameId = -1;
                  field1118 = 0;
                  field1030 = 0;
                  field977 = 0;
                  field940 = 0;
                  class148.method2940();
                  class175.method3455(0);
                  RSCanvas.method769();
                  itemSelectionState = 0;
                  spellSelected = false;
                  field1154 = 0;
                  mapAngle = 0;
                  field1148 = 0;
                  field1116 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  field948 = class89.field1406;
                  field949 = class89.field1406;
                  npcIndexesCount = 0;
                  ClanMember.method1140();

                  for(var1 = 0; var1 < 2048; ++var1) {
                     cachedPlayers[var1] = null;
                  }

                  for(var1 = 0; var1 < 32768; ++var1) {
                     cachedNPCs[var1] = null;
                  }

                  field1043 = -1;
                  projectiles.clear();
                  graphicsObjectDeque.clear();

                  for(var1 = 0; var1 < 4; ++var1) {
                     for(var2 = 0; var2 < 104; ++var2) {
                        for(var3 = 0; var3 < 104; ++var3) {
                           groundItemDeque[var1][var2][var3] = null;
                        }
                     }
                  }

                  pendingSpawns = new Deque();
                  field1180 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var1 = 0; var1 < VarPlayerType.field3280; ++var1) {
                     VarPlayerType var25 = Friend.method1084(var1);
                     if(var25 != null) {
                        class211.settings[var1] = 0;
                        class211.widgetSettings[var1] = 0;
                     }
                  }

                  class24.chatMessages.reset();
                  field1082 = -1;
                  if(widgetRoot != -1) {
                     class3.method5(widgetRoot);
                  }

                  for(WidgetNode var23 = (WidgetNode)componentTable.method3637(); var23 != null; var23 = (WidgetNode)componentTable.method3638()) {
                     class110.method2145(var23, true);
                  }

                  widgetRoot = -1;
                  componentTable = new HashTable(8);
                  field1078 = null;
                  class148.method2940();
                  field1185.method4030((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var1 = 0; var1 < 8; ++var1) {
                     playerOptions[var1] = null;
                     playerOptionsPriorities[var1] = false;
                  }

                  WorldMapType3.method200();
                  field931 = true;

                  for(var1 = 0; var1 < 100; ++var1) {
                     field1119[var1] = true;
                  }

                  secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_RESIZE_CLIENT_FRAME);
                  secretPacketBuffer1.putByte(SceneTilePaint.method2713());
                  secretPacketBuffer1.putShort(Timer.canvasWidth);
                  secretPacketBuffer1.putShort(GameEngine.canvasHeight);
                  clanChatOwner = null;
                  class2.clanChatCount = 0;
                  GraphicsObject.clanMembers = null;

                  for(var1 = 0; var1 < 8; ++var1) {
                     grandExchangeOffers[var1] = new GrandExchangeOffer();
                  }

                  class207.field2580 = null;
                  class11.initializeGPI(secretPacketBuffer2);
                  class51.field678 = -1;
                  WidgetNode.xteaChanged(false);
                  packetType = -1;
               }

            } else {
               if(loginState == 11 && class15.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  class15.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class93.field1482 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && class15.rssocket.available() >= class93.field1482) {
                  secretPacketBuffer2.offset = 0;
                  class15.rssocket.read(secretPacketBuffer2.payload, 0, class93.field1482);
                  secretPacketBuffer2.offset = 0;
                  String var22 = secretPacketBuffer2.readString();
                  String var24 = secretPacketBuffer2.readString();
                  String var27 = secretPacketBuffer2.readString();
                  class36.method481(var22, var24, var27);
                  class72.setGameState(10);
               }

               if(loginState != 13) {
                  ++field957;
                  if(field957 > 2000) {
                     if(field1184 < 1) {
                        if(Frames.field2120 == class51.myWorldPort) {
                           class51.myWorldPort = Signlink.field2230;
                        } else {
                           class51.myWorldPort = Frames.field2120;
                        }

                        ++field1184;
                        loginState = 0;
                     } else {
                        class257.method4723(-3);
                     }
                  }
               } else {
                  if(packetLength == -1) {
                     if(class15.rssocket.available() < 2) {
                        return;
                     }

                     class15.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(class15.rssocket.available() >= packetLength) {
                     class15.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     field979.method4996();
                     secretPacketBuffer1.offset = 0;
                     secretPacketBuffer2.offset = 0;
                     packetType = -1;
                     lastFrameId = -1;
                     secondLastFrameId = -1;
                     thridLastFrameId = -1;
                     packetLength = 0;
                     field1118 = 0;
                     field1030 = 0;
                     class148.method2940();
                     field1148 = 0;
                     destinationX = 0;

                     for(var2 = 0; var2 < 2048; ++var2) {
                        cachedPlayers[var2] = null;
                     }

                     class66.localPlayer = null;

                     for(var2 = 0; var2 < cachedNPCs.length; ++var2) {
                        NPC var28 = cachedNPCs[var2];
                        if(var28 != null) {
                           var28.interacting = -1;
                           var28.field1236 = false;
                        }
                     }

                     WorldMapType3.method200();
                     class72.setGameState(30);

                     for(var2 = 0; var2 < 100; ++var2) {
                        field1119[var2] = true;
                     }

                     secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_RESIZE_CLIENT_FRAME);
                     secretPacketBuffer1.putByte(SceneTilePaint.method2713());
                     secretPacketBuffer1.putShort(Timer.canvasWidth);
                     secretPacketBuffer1.putShort(GameEngine.canvasHeight);
                     class11.initializeGPI(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var16) {
         if(field1184 < 1) {
            if(Frames.field2120 == class51.myWorldPort) {
               class51.myWorldPort = Signlink.field2230;
            } else {
               class51.myWorldPort = Frames.field2120;
            }

            ++field1184;
            loginState = 0;
         } else {
            class257.method4723(-2);
         }
      }
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1967308953"
   )
   final void method1152() {
      if(field1030 > 1) {
         --field1030;
      }

      if(field977 > 0) {
         --field977;
      }

      if(socketError) {
         socketError = false;
         class60.method1028();
      } else {
         if(!isMenuOpen) {
            class44.method615();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.processServerPacket(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class281.field3766.method3655();
               boolean var31;
               if(var2 == null) {
                  var31 = false;
               } else {
                  var31 = true;
               }

               int var16;
               if(!var31) {
                  if(field979.field3732) {
                     secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_197);
                     if(RUNELITE_PACKET) {
                        secretPacketBuffer1.runeliteWriteInt(0);
                     } else {
                        secretPacketBuffer1.putByte(0);
                     }

                     var1 = secretPacketBuffer1.offset;
                     field979.method4997(secretPacketBuffer1);
                     secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
                     field979.method5009();
                  }

                  Object var15 = class56.field695.field867;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  synchronized(class56.field695.field867) {
                     if(!field930) {
                        class56.field695.field871 = 0;
                     } else if(MouseInput.field743 != 0 || class56.field695.field871 >= 40) {
                        secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_248);
                        if(RUNELITE_PACKET) {
                           secretPacketBuffer1.runeliteWriteInt(0);
                        } else {
                           secretPacketBuffer1.putByte(0);
                        }

                        var16 = secretPacketBuffer1.offset;
                        var3 = 0;

                        for(var4 = 0; var4 < class56.field695.field871 && secretPacketBuffer1.offset - var16 < 240; ++var4) {
                           ++var3;
                           var5 = class56.field695.field870[var4];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 502) {
                              var5 = 502;
                           }

                           var6 = class56.field695.field873[var4];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 764) {
                              var6 = 764;
                           }

                           var7 = var5 * 765 + var6;
                           if(class56.field695.field870[var4] == -1 && class56.field695.field873[var4] == -1) {
                              var6 = -1;
                              var5 = -1;
                              var7 = 524287;
                           }

                           if(var6 == field934 && var5 == field972) {
                              if(field978 < 2047) {
                                 ++field978;
                              }
                           } else {
                              var8 = var6 - field934;
                              field934 = var6;
                              var9 = var5 - field972;
                              field972 = var5;
                              if(field978 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                 var8 += 32;
                                 var9 += 32;
                                 secretPacketBuffer1.putShort(var9 + (field978 << 12) + (var8 << 6));
                                 field978 = 0;
                              } else if(field978 < 8) {
                                 secretPacketBuffer1.put24bitInt((field978 << 19) + var7 + 8388608);
                                 field978 = 0;
                              } else {
                                 secretPacketBuffer1.putInt((field978 << 19) + var7 + -1073741824);
                                 field978 = 0;
                              }
                           }
                        }

                        secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var16);
                        if(var3 >= class56.field695.field871) {
                           class56.field695.field871 = 0;
                        } else {
                           class56.field695.field871 -= var3;

                           for(var4 = 0; var4 < class56.field695.field871; ++var4) {
                              class56.field695.field873[var4] = class56.field695.field873[var4 + var3];
                              class56.field695.field870[var4] = class56.field695.field870[var4 + var3];
                           }
                        }
                     }
                  }

                  if(MouseInput.field743 == 1 || !class7.field244 && MouseInput.field743 == 4 || MouseInput.field743 == 2) {
                     long var17 = (MouseInput.field759 - field1142 * -1L) / 50L;
                     if(var17 > 4095L) {
                        var17 = 4095L;
                     }

                     field1142 = MouseInput.field759 * -1L;
                     var3 = MouseInput.field758;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > GameEngine.canvasHeight) {
                        var3 = GameEngine.canvasHeight;
                     }

                     var4 = MouseInput.field757;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > Timer.canvasWidth) {
                        var4 = Timer.canvasWidth;
                     }

                     var5 = (int)var17;
                     secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CLICK_ANYWHERE);
                     secretPacketBuffer1.putShort((var5 << 1) + (MouseInput.field743 == 2?1:0));
                     secretPacketBuffer1.putShort(var4);
                     secretPacketBuffer1.putShort(var3);
                  }

                  if(KeyFocusListener.field666 > 0) {
                     secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_TYPE_ON_KEYBOARD);
                     if(RUNELITE_PACKET) {
                        secretPacketBuffer1.runeliteWriteInt(0);
                     } else {
                        secretPacketBuffer1.putShort(0);
                     }

                     var1 = secretPacketBuffer1.offset;
                     long var19 = class174.currentTimeMs();

                     for(var4 = 0; var4 < KeyFocusListener.field666; ++var4) {
                        long var21 = var19 - field1138;
                        if(var21 > 16777215L) {
                           var21 = 16777215L;
                        }

                        field1138 = var19;
                        secretPacketBuffer1.method3262((int)var21);
                        secretPacketBuffer1.putLEInt(KeyFocusListener.field671[var4]);
                     }

                     secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
                  }

                  if(field1020 > 0) {
                     --field1020;
                  }

                  if(KeyFocusListener.field659[96] || KeyFocusListener.field659[97] || KeyFocusListener.field659[98] || KeyFocusListener.field659[99]) {
                     field1005 = true;
                  }

                  if(field1005 && field1020 <= 0) {
                     field1020 = 20;
                     field1005 = false;
                     secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_64);
                     if(RUNELITE_PACKET) {
                        secretPacketBuffer1.runeliteWriteInt(field997);
                        secretPacketBuffer1.runeliteWriteInt(mapAngle);
                     } else {
                        secretPacketBuffer1.method3254(field997);
                        secretPacketBuffer1.method3254(mapAngle);
                     }
                  }

                  if(RSSocket.field2267 && !field937) {
                     field937 = true;
                     secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_209);
                     if(RUNELITE_PACKET) {
                        secretPacketBuffer1.runeliteWriteInt(1);
                     } else {
                        secretPacketBuffer1.putByte(1);
                     }
                  }

                  if(!RSSocket.field2267 && field937) {
                     field937 = false;
                     secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_209);
                     if(RUNELITE_PACKET) {
                        secretPacketBuffer1.runeliteWriteInt(0);
                     } else {
                        secretPacketBuffer1.putByte(0);
                     }
                  }

                  if(field1116 != class46.plane) {
                     field1116 = class46.plane;
                     class219.method4134(class46.plane);
                  }

                  if(gameState != 30) {
                     return;
                  }

                  class222.method4147();

                  for(var1 = 0; var1 < field1154; ++var1) {
                     --field1136[var1];
                     if(field1136[var1] >= -10) {
                        SoundEffect var32 = audioEffects[var1];
                        if(var32 == null) {
                           Object var10000 = null;
                           var32 = SoundEffect.getTrack(class15.field310, field1098[var1], 0);
                           if(var32 == null) {
                              continue;
                           }

                           field1136[var1] += var32.calculateDelay();
                           audioEffects[var1] = var32;
                        }

                        if(field1136[var1] < 0) {
                           if(field1040[var1] != 0) {
                              var4 = (field1040[var1] & 255) * 128;
                              var5 = field1040[var1] >> 16 & 255;
                              var6 = var5 * 128 + 64 - class66.localPlayer.x;
                              if(var6 < 0) {
                                 var6 = -var6;
                              }

                              var7 = field1040[var1] >> 8 & 255;
                              var8 = var7 * 128 + 64 - class66.localPlayer.y;
                              if(var8 < 0) {
                                 var8 = -var8;
                              }

                              var9 = var6 + var8 - 128;
                              if(var9 > var4) {
                                 field1136[var1] = -100;
                                 continue;
                              }

                              if(var9 < 0) {
                                 var9 = 0;
                              }

                              var3 = (var4 - var9) * field922 / var4;
                           } else {
                              var3 = field1152;
                           }

                           if(var3 > 0) {
                              class105 var23 = var32.method1978().method2026(class251.field3390);
                              class115 var24 = class115.method2314(var23, 100, var3);
                              var24.method2175(field1156[var1] - 1);
                              class11.field278.method1919(var24);
                           }

                           field1136[var1] = -100;
                        }
                     } else {
                        --field1154;

                        for(var16 = var1; var16 < field1154; ++var16) {
                           field1098[var16] = field1098[var16 + 1];
                           audioEffects[var16] = audioEffects[var16 + 1];
                           field1156[var16] = field1156[var16 + 1];
                           field1136[var16] = field1136[var16 + 1];
                           field1040[var16] = field1040[var16 + 1];
                        }

                        --var1;
                     }
                  }

                  if(field1151) {
                     if(class203.field2500 != 0) {
                        var31 = true;
                     } else {
                        var31 = class203.field2499.method3877();
                     }

                     if(!var31) {
                        if(field1149 != 0 && field1150 != -1) {
                           CombatInfoListHolder.method1691(class37.indexTrack1, field1150, 0, field1149, false);
                        }

                        field1151 = false;
                     }
                  }

                  ++field1118;
                  if(field1118 > 750) {
                     class60.method1028();
                     return;
                  }

                  ItemContainer.method1077();

                  for(var1 = 0; var1 < npcIndexesCount; ++var1) {
                     var16 = npcIndices[var1];
                     NPC var25 = cachedNPCs[var16];
                     if(var25 != null) {
                        class36.method479(var25, var25.composition.field3555);
                     }
                  }

                  class7.method33();
                  ++field1004;
                  if(cursorState != 0) {
                     field1023 += 20;
                     if(field1023 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class72.field882 != null) {
                     ++field1025;
                     if(field1025 >= 15) {
                        class45.method647(class72.field882);
                        class72.field882 = null;
                     }
                  }

                  Widget var36 = Sequence.field3621;
                  Widget var33 = class162.field2303;
                  Sequence.field3621 = null;
                  class162.field2303 = null;
                  field1091 = null;
                  field1153 = false;
                  field1183 = false;
                  field1135 = 0;

                  while(class170.method3195() && field1135 < 128) {
                     if(rights >= 2 && KeyFocusListener.field659[82] && class261.field3630 == 66) {
                        String var40 = class17.method126();
                        class7.clientInstance.method910(var40);
                     } else {
                        field1015[field1135] = class261.field3630;
                        field1095[field1135] = class47.field618;
                        ++field1135;
                     }
                  }

                  boolean var34 = rights >= 2;
                  if(var34 && KeyFocusListener.field659[82] && KeyFocusListener.field659[81] && field1112 != 0) {
                     var4 = class66.localPlayer.field908 - field1112;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 3) {
                        var4 = 3;
                     }

                     if(var4 != class66.localPlayer.field908) {
                        var5 = class66.localPlayer.pathX[0] + class22.baseX * 411265;
                        var6 = class66.localPlayer.pathY[0] + class273.baseY;
                        secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_30);
                        if(RUNELITE_PACKET) {
                           secretPacketBuffer1.runeliteWriteInt(var6);
                           secretPacketBuffer1.runeliteWriteInt(var5);
                           secretPacketBuffer1.runeliteWriteInt(var4);
                        } else {
                           secretPacketBuffer1.method3342(var6);
                           secretPacketBuffer1.method3342(var5);
                           secretPacketBuffer1.putLEInt(var4);
                        }
                     }

                     field1112 = 0;
                  }

                  if(widgetRoot != -1) {
                     DynamicObject.method1904(widgetRoot, 0, 0, Timer.canvasWidth, GameEngine.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var26;
                     ScriptEvent var37;
                     Widget var38;
                     do {
                        var37 = (ScriptEvent)field1171.popFront();
                        if(var37 == null) {
                           while(true) {
                              do {
                                 var37 = (ScriptEvent)field1115.popFront();
                                 if(var37 == null) {
                                    while(true) {
                                       do {
                                          var37 = (ScriptEvent)field1113.popFront();
                                          if(var37 == null) {
                                             this.method1438();
                                             if(renderOverview != null) {
                                                renderOverview.method5366(class46.plane, (class66.localPlayer.x >> 7) + class22.baseX * 411265, (class66.localPlayer.y >> 7) + class273.baseY, false);
                                                renderOverview.method5367();
                                             }

                                             if(field1158 != null) {
                                                this.method1311();
                                             }

                                             if(ScriptState.field787 != null) {
                                                class45.method647(ScriptState.field787);
                                                ++field1032;
                                                if(MouseInput.field750 == 0) {
                                                   if(field1031) {
                                                      if(ScriptState.field787 == class94.field1498 && field1177 != field944) {
                                                         Widget var39 = ScriptState.field787;
                                                         byte var35 = 0;
                                                         if(field1077 == 1 && var39.contentType == 206) {
                                                            var35 = 1;
                                                         }

                                                         if(var39.itemIds[field1177] <= 0) {
                                                            var35 = 0;
                                                         }

                                                         if(FrameMap.method2715(class25.getWidgetConfig(var39))) {
                                                            var6 = field944;
                                                            var7 = field1177;
                                                            var39.itemIds[var7] = var39.itemIds[var6];
                                                            var39.itemQuantities[var7] = var39.itemQuantities[var6];
                                                            var39.itemIds[var6] = -1;
                                                            var39.itemQuantities[var6] = 0;
                                                         } else if(var35 == 1) {
                                                            var6 = field944;
                                                            var7 = field1177;

                                                            while(var6 != var7) {
                                                               if(var6 > var7) {
                                                                  var39.method4072(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var7) {
                                                                  var39.method4072(var6 + 1, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var39.method4072(field1177, field944);
                                                         }

                                                         secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_187);
                                                         if(RUNELITE_PACKET) {
                                                            secretPacketBuffer1.runeliteWriteInt(var35);
                                                            secretPacketBuffer1.runeliteWriteInt(field1177);
                                                            secretPacketBuffer1.runeliteWriteInt(field944);
                                                            secretPacketBuffer1.runeliteWriteInt(ScriptState.field787.id);
                                                         } else {
                                                            secretPacketBuffer1.method3225(var35);
                                                            secretPacketBuffer1.method3254(field1177);
                                                            secretPacketBuffer1.putShortLE(field944);
                                                            secretPacketBuffer1.method3275(ScriptState.field787.id);
                                                         }
                                                      }
                                                   } else if(this.method1199()) {
                                                      this.method1159(field1028, field1131);
                                                   } else if(menuOptionCount > 0) {
                                                      var4 = field1028;
                                                      var5 = field1131;
                                                      class87 var41 = class170.field2344;
                                                      class48.menuAction(var41.field1389, var41.field1396, var41.field1391, var41.field1390, var41.field1393, var41.field1393, var4, var5);
                                                      class170.field2344 = null;
                                                   }

                                                   field1025 = 10;
                                                   MouseInput.field743 = 0;
                                                   ScriptState.field787 = null;
                                                } else if(field1032 >= 5 && (MouseInput.field756 > field1028 + 5 || MouseInput.field756 < field1028 - 5 || MouseInput.field741 > field1131 + 5 || MouseInput.field741 < field1131 - 5)) {
                                                   field1031 = true;
                                                }
                                             }

                                             if(Region.method2756()) {
                                                var4 = Region.selectedRegionTileX;
                                                var5 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CLICK_IN_GAME_WALK);
                                                if(RUNELITE_PACKET) {
                                                   secretPacketBuffer1.runeliteWriteInt(5);
                                                } else {
                                                   secretPacketBuffer1.putByte(5);
                                                }

                                                secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?(KeyFocusListener.field659[81]?2:1):0);
                                                secretPacketBuffer1.putShortLE(var5 + class273.baseY);
                                                secretPacketBuffer1.method3342(var4 + class22.baseX * 411265);
                                                Region.method2731();
                                                field1047 = MouseInput.field757;
                                                field1022 = MouseInput.field758;
                                                cursorState = 1;
                                                field1023 = 0;
                                                destinationX = var4;
                                                destinationY = var5;
                                             }

                                             if(var36 != Sequence.field3621) {
                                                if(var36 != null) {
                                                   class45.method647(var36);
                                                }

                                                if(Sequence.field3621 != null) {
                                                   class45.method647(Sequence.field3621);
                                                }
                                             }

                                             if(var33 != class162.field2303 && field1066 == field1065) {
                                                if(var33 != null) {
                                                   class45.method647(var33);
                                                }

                                                if(class162.field2303 != null) {
                                                   class45.method647(class162.field2303);
                                                }
                                             }

                                             if(class162.field2303 != null) {
                                                if(field1065 < field1066) {
                                                   ++field1065;
                                                   if(field1065 == field1066) {
                                                      class45.method647(class162.field2303);
                                                   }
                                                }
                                             } else if(field1065 > 0) {
                                                --field1065;
                                             }

                                             WorldMapType2.method518();
                                             if(field1160) {
                                                var4 = class210.field2590 * 128 + 64;
                                                var5 = Frames.field2124 * 128 + 64;
                                                var6 = class41.getTileHeight(var4, var5, class46.plane) - Actor.field1271;
                                                if(AbstractByteBuffer.cameraX < var4) {
                                                   AbstractByteBuffer.cameraX = (var4 - AbstractByteBuffer.cameraX) * class90.field1448 / 1000 + AbstractByteBuffer.cameraX + class47.field620;
                                                   if(AbstractByteBuffer.cameraX > var4) {
                                                      AbstractByteBuffer.cameraX = var4;
                                                   }
                                                }

                                                if(AbstractByteBuffer.cameraX > var4) {
                                                   AbstractByteBuffer.cameraX -= class90.field1448 * (AbstractByteBuffer.cameraX - var4) / 1000 + class47.field620;
                                                   if(AbstractByteBuffer.cameraX < var4) {
                                                      AbstractByteBuffer.cameraX = var4;
                                                   }
                                                }

                                                if(class229.cameraZ < var6) {
                                                   class229.cameraZ = (var6 - class229.cameraZ) * class90.field1448 / 1000 + class229.cameraZ + class47.field620;
                                                   if(class229.cameraZ > var6) {
                                                      class229.cameraZ = var6;
                                                   }
                                                }

                                                if(class229.cameraZ > var6) {
                                                   class229.cameraZ -= class90.field1448 * (class229.cameraZ - var6) / 1000 + class47.field620;
                                                   if(class229.cameraZ < var6) {
                                                      class229.cameraZ = var6;
                                                   }
                                                }

                                                if(World.cameraY < var5) {
                                                   World.cameraY = (var5 - World.cameraY) * class90.field1448 / 1000 + World.cameraY + class47.field620;
                                                   if(World.cameraY > var5) {
                                                      World.cameraY = var5;
                                                   }
                                                }

                                                if(World.cameraY > var5) {
                                                   World.cameraY -= class90.field1448 * (World.cameraY - var5) / 1000 + class47.field620;
                                                   if(World.cameraY < var5) {
                                                      World.cameraY = var5;
                                                   }
                                                }

                                                var4 = class203.field2497 * 128 + 64;
                                                var5 = class14.field292 * 128 + 64;
                                                var6 = class41.getTileHeight(var4, var5, class46.plane) - class23.field366;
                                                var7 = var4 - AbstractByteBuffer.cameraX;
                                                var8 = var6 - class229.cameraZ;
                                                var9 = var5 - World.cameraY;
                                                int var10 = (int)Math.sqrt((double)(var9 * var9 + var7 * var7));
                                                int var11 = (int)(Math.atan2((double)var8, (double)var10) * 325.949D) & 2047;
                                                int var12 = (int)(Math.atan2((double)var7, (double)var9) * -325.949D) & 2047;
                                                if(var11 < 128) {
                                                   var11 = 128;
                                                }

                                                if(var11 > 383) {
                                                   var11 = 383;
                                                }

                                                if(class18.cameraPitch < var11) {
                                                   class18.cameraPitch = (var11 - class18.cameraPitch) * class66.field830 / 1000 + class18.cameraPitch + Friend.field824;
                                                   if(class18.cameraPitch > var11) {
                                                      class18.cameraPitch = var11;
                                                   }
                                                }

                                                if(class18.cameraPitch > var11) {
                                                   class18.cameraPitch -= class66.field830 * (class18.cameraPitch - var11) / 1000 + Friend.field824;
                                                   if(class18.cameraPitch < var11) {
                                                      class18.cameraPitch = var11;
                                                   }
                                                }

                                                int var13 = var12 - CombatInfo1.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 > 0) {
                                                   CombatInfo1.cameraYaw = var13 * class66.field830 / 1000 + CombatInfo1.cameraYaw + Friend.field824;
                                                   CombatInfo1.cameraYaw &= 2047;
                                                }

                                                if(var13 < 0) {
                                                   CombatInfo1.cameraYaw -= -var13 * class66.field830 / 1000 + Friend.field824;
                                                   CombatInfo1.cameraYaw &= 2047;
                                                }

                                                int var14 = var12 - CombatInfo1.cameraYaw;
                                                if(var14 > 1024) {
                                                   var14 -= 2048;
                                                }

                                                if(var14 < -1024) {
                                                   var14 += 2048;
                                                }

                                                if(var14 < 0 && var13 > 0 || var14 > 0 && var13 < 0) {
                                                   CombatInfo1.cameraYaw = var12;
                                                }
                                             }

                                             for(var4 = 0; var4 < 5; ++var4) {
                                                ++field1165[var4];
                                             }

                                             class24.chatMessages.process();
                                             var4 = ++MouseInput.mouseIdleTicks - 1;
                                             var6 = KeyFocusListener.keyboardIdleTicks;
                                             if(var4 > 15000 && var6 > 15000) {
                                                field977 = 250;
                                                class175.method3455(14500);
                                                secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_94);
                                             }

                                             for(class66 var27 = (class66)field1182.method3722(); var27 != null; var27 = (class66)field1182.method3725()) {
                                                if((long)var27.field832 < class174.currentTimeMs() / 1000L - 5L) {
                                                   if(var27.field829 > 0) {
                                                      class174.sendGameMessage(5, "", var27.field828 + " has logged in.");
                                                   }

                                                   if(var27.field829 == 0) {
                                                      class174.sendGameMessage(5, "", var27.field828 + " has logged out.");
                                                   }

                                                   var27.method3726();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_KEEPALIVE);
                                             }

                                             try {
                                                if(class15.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   class15.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var29) {
                                                class60.method1028();
                                             }

                                             return;
                                          }

                                          var38 = var37.widget;
                                          if(var38.index < 0) {
                                             break;
                                          }

                                          var26 = ItemLayer.method2454(var38.parentId);
                                       } while(var26 == null || var26.children == null || var38.index >= var26.children.length || var38 != var26.children[var38.index]);

                                       class56.method817(var37);
                                    }
                                 }

                                 var38 = var37.widget;
                                 if(var38.index < 0) {
                                    break;
                                 }

                                 var26 = ItemLayer.method2454(var38.parentId);
                              } while(var26 == null || var26.children == null || var38.index >= var26.children.length || var38 != var26.children[var38.index]);

                              class56.method817(var37);
                           }
                        }

                        var38 = var37.widget;
                        if(var38.index < 0) {
                           break;
                        }

                        var26 = ItemLayer.method2454(var38.parentId);
                     } while(var26 == null || var26.children == null || var38.index >= var26.children.length || var38 != var26.children[var38.index]);

                     class56.method817(var37);
                  }
               }

               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_220);
               if(RUNELITE_PACKET) {
                  secretPacketBuffer1.runeliteWriteInt(0);
               } else {
                  secretPacketBuffer1.putByte(0);
               }

               var16 = secretPacketBuffer1.offset;
               class232.encodeClassVerifier(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var16);
            }
         }
      }
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Lhj;I)V",
      garbageValue = "-234140643"
   )
   void method1161(Widget var1) {
      Widget var2 = var1.parentId == -1?null:ItemLayer.method2454(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = Timer.canvasWidth;
         var4 = GameEngine.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class61.method1065(var1, var3, var4, false);
      AbstractSoundSystem.method2114(var1, var3, var4);
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1151628131"
   )
   final void method1438() {
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
               boolean var6 = field1161[var2];
               field1161[var2] = field1161[var2 + 1];
               field1161[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(ScriptState.field787 == null) {
         if(field1158 == null) {
            int var14 = MouseInput.field743;
            int var8;
            int var9;
            int var12;
            int var15;
            if(isMenuOpen) {
               int var11;
               if(var14 != 1 && (class7.field244 || var14 != 4)) {
                  var2 = MouseInput.field756;
                  var11 = MouseInput.field741;
                  if(var2 < class10.menuX - 10 || var2 > class10.menuX + ScriptVarType.menuWidth + 10 || var11 < class29.menuY - 10 || var11 > class17.menuHeight + class29.menuY + 10) {
                     isMenuOpen = false;
                     class36.method480(class10.menuX, class29.menuY, ScriptVarType.menuWidth, class17.menuHeight);
                  }
               }

               if(var14 == 1 || !class7.field244 && var14 == 4) {
                  var2 = class10.menuX;
                  var11 = class29.menuY;
                  var12 = ScriptVarType.menuWidth;
                  var5 = MouseInput.field757;
                  var15 = MouseInput.field758;
                  int var7 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = var11 + (menuOptionCount - 1 - var8) * 15 + 31;
                     if(var5 > var2 && var5 < var12 + var2 && var15 > var9 - 13 && var15 < var9 + 3) {
                        var7 = var8;
                     }
                  }

                  if(var7 != -1) {
                     Friend.method1083(var7);
                  }

                  isMenuOpen = false;
                  class36.method480(class10.menuX, class29.menuY, ScriptVarType.menuWidth, class17.menuHeight);
               }
            } else {
               var2 = menuOptionCount - 1;
               if((var14 == 1 || !class7.field244 && var14 == 4) && var2 >= 0) {
                  var12 = menuTypes[var2];
                  if(var12 == 39 || var12 == 40 || var12 == 41 || var12 == 42 || var12 == 43 || var12 == 33 || var12 == 34 || var12 == 35 || var12 == 36 || var12 == 37 || var12 == 38 || var12 == 1005) {
                     var5 = menuActionParams0[var2];
                     var15 = menuActionParams1[var2];
                     Widget var13 = ItemLayer.method2454(var15);
                     if(class18.method137(class25.getWidgetConfig(var13)) || FrameMap.method2715(class25.getWidgetConfig(var13))) {
                        if(ScriptState.field787 != null && !field1031 && menuOptionCount > 0 && !this.method1199()) {
                           var8 = field1028;
                           var9 = field1131;
                           class87 var10 = class170.field2344;
                           class48.menuAction(var10.field1389, var10.field1396, var10.field1391, var10.field1390, var10.field1393, var10.field1393, var8, var9);
                           class170.field2344 = null;
                        }

                        field1031 = false;
                        field1032 = 0;
                        if(ScriptState.field787 != null) {
                           class45.method647(ScriptState.field787);
                        }

                        ScriptState.field787 = ItemLayer.method2454(var15);
                        field944 = var5;
                        field1028 = MouseInput.field757;
                        field1131 = MouseInput.field758;
                        if(var2 >= 0) {
                           class8.method40(var2);
                        }

                        class45.method647(ScriptState.field787);
                        return;
                     }
                  }
               }

               if((var14 == 1 || !class7.field244 && var14 == 4) && this.method1199()) {
                  var14 = 2;
               }

               if((var14 == 1 || !class7.field244 && var14 == 4) && menuOptionCount > 0) {
                  Friend.method1083(var2);
               }

               if(var14 == 2 && menuOptionCount > 0) {
                  this.method1159(MouseInput.field757, MouseInput.field758);
               }
            }

         }
      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2147391919"
   )
   final void method1311() {
      class45.method647(field1158);
      ++class39.field554;
      if(field1153 && field1183) {
         int var1 = MouseInput.field756;
         int var2 = MouseInput.field741;
         var1 -= field1089;
         var2 -= field1168;
         if(var1 < field1093) {
            var1 = field1093;
         }

         if(var1 + field1158.width > field1093 + field960.width) {
            var1 = field1093 + field960.width - field1158.width;
         }

         if(var2 < field1094) {
            var2 = field1094;
         }

         if(var2 + field1158.height > field1094 + field960.height) {
            var2 = field1094 + field960.height - field1158.height;
         }

         int var3 = var1 - field1096;
         int var4 = var2 - field1097;
         int var5 = field1158.field2718;
         if(class39.field554 > field1158.field2688 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1090 = true;
         }

         int var6 = var1 - field1093 + field960.scrollX;
         int var7 = var2 - field1094 + field960.scrollY;
         ScriptEvent var8;
         if(field1158.field2731 != null && field1090) {
            var8 = new ScriptEvent();
            var8.widget = field1158;
            var8.field847 = var6;
            var8.field848 = var7;
            var8.field849 = field1158.field2731;
            class56.method817(var8);
         }

         if(MouseInput.field750 == 0) {
            if(field1090) {
               if(field1158.field2750 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1158;
                  var8.field847 = var6;
                  var8.field848 = var7;
                  var8.field855 = field1091;
                  var8.field849 = field1158.field2750;
                  class56.method817(var8);
               }

               if(field1091 != null) {
                  Widget var9 = field1158;
                  int var10 = MilliTimer.method2964(class25.getWidgetConfig(var9));
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

                        var9 = ItemLayer.method2454(var9.parentId);
                        if(var9 == null) {
                           var15 = null;
                           break;
                        }

                        ++var11;
                     }
                  }

                  if(var15 != null) {
                     secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DRAG_ITEM_ACROSS_WIDGETS);
                     if(RUNELITE_PACKET) {
                        secretPacketBuffer1.runeliteWriteInt(field1158.index);
                        secretPacketBuffer1.runeliteWriteInt(field1091.index);
                        secretPacketBuffer1.runeliteWriteInt(field1158.itemId);
                        secretPacketBuffer1.runeliteWriteInt(field1158.id);
                        secretPacketBuffer1.runeliteWriteInt(field1091.itemId);
                        secretPacketBuffer1.runeliteWriteInt(field1091.id);
                     } else {
                        secretPacketBuffer1.putShort(field1158.index);
                        secretPacketBuffer1.putShort(field1091.index);
                        secretPacketBuffer1.method3254(field1158.itemId);
                        secretPacketBuffer1.method3392(field1158.id);
                        secretPacketBuffer1.method3342(field1091.itemId);
                        secretPacketBuffer1.putInt(field1091.id);
                     }
                  }
               }
            } else if(this.method1199()) {
               this.method1159(field1089 + field1096, field1168 + field1097);
            } else if(menuOptionCount > 0) {
               int var12 = field1096 + field1089;
               int var13 = field1168 + field1097;
               class87 var14 = class170.field2344;
               class48.menuAction(var14.field1389, var14.field1396, var14.field1391, var14.field1390, var14.field1393, var14.field1393, var12, var13);
               class170.field2344 = null;
            }

            field1158 = null;
         }

      } else {
         if(class39.field554 > 1) {
            field1158 = null;
         }

      }
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = class203.method3779();

         int var6;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            Parameters var3 = var1[var2];
            String var4 = this.getParameter(var3.key);
            if(var4 != null) {
               switch(Integer.parseInt(var3.key)) {
               case 1:
                  Timer.sessionToken = var4;
                  break;
               case 2:
                  WorldMapData.field473 = Integer.parseInt(var4);
               case 3:
               case 9:
               default:
                  break;
               case 4:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 5:
                  WorldMapType1.field452 = (class232)class29.forOrdinal(class222.method4145(), Integer.parseInt(var4));
                  if(class232.field3191 == WorldMapType1.field452) {
                     Permission.field3169 = class290.field3872;
                  } else {
                     Permission.field3169 = class290.field3873;
                  }
                  break;
               case 6:
                  field929 = Integer.parseInt(var4);
                  break;
               case 7:
                  class204.field2525 = var4;
                  break;
               case 8:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 10:
                  var6 = Integer.parseInt(var4);
                  BuildType[] var7 = Preferences.method1593();
                  int var8 = 0;

                  BuildType var5;
                  while(true) {
                     if(var8 >= var7.length) {
                        var5 = null;
                        break;
                     }

                     BuildType var9 = var7[var8];
                     if(var6 == var9.ordinal) {
                        var5 = var9;
                        break;
                     }

                     ++var8;
                  }

                  Preferences.field1308 = var5;
                  break;
               case 11:
                  world = Integer.parseInt(var4);
                  break;
               case 12:
                  languageId = Integer.parseInt(var4);
                  break;
               case 13:
                  socketType = Integer.parseInt(var4);
                  break;
               case 14:
                  flags = Integer.parseInt(var4);
               }
            }
         }

         Region.lowMemory = false;
         lowMemory = false;
         class35.host = this.getCodeBase().getHost();
         String var16 = Preferences.field1308.identifier;
         byte var17 = 0;

         try {
            class223.field2836 = 17;
            DynamicObject.field1533 = var17;

            try {
               class2.osName = System.getProperty("os.name");
            } catch (Exception var14) {
               class2.osName = "Unknown";
            }

            GraphicsObject.osNameLC = class2.osName.toLowerCase();

            try {
               class33.userHome = System.getProperty("user.home");
               if(class33.userHome != null) {
                  class33.userHome = class33.userHome + "/";
               }
            } catch (Exception var13) {
               ;
            }

            try {
               if(GraphicsObject.osNameLC.startsWith("win")) {
                  if(class33.userHome == null) {
                     class33.userHome = System.getenv("USERPROFILE");
                  }
               } else if(class33.userHome == null) {
                  class33.userHome = System.getenv("HOME");
               }

               if(class33.userHome != null) {
                  class33.userHome = class33.userHome + "/";
               }
            } catch (Exception var12) {
               ;
            }

            if(class33.userHome == null) {
               class33.userHome = "~/";
            }

            class277.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class33.userHome, "/tmp/", ""};
            class267.field3671 = new String[]{".jagex_cache_" + DynamicObject.field1533, ".file_store_" + DynamicObject.field1533};

            label118:
            for(int var10 = 0; var10 < 4; ++var10) {
               class155.field2237 = class12.method72("oldschool", var16, var10);
               if(!class155.field2237.exists()) {
                  class155.field2237.mkdirs();
               }

               File[] var19 = class155.field2237.listFiles();
               if(var19 == null) {
                  break;
               }

               File[] var20 = var19;
               var6 = 0;

               while(true) {
                  if(var6 >= var20.length) {
                     break label118;
                  }

                  File var21 = var20[var6];
                  if(!class43.method607(var21, false)) {
                     break;
                  }

                  ++var6;
               }
            }

            File var18 = class155.field2237;
            class157.field2245 = var18;
            if(!class157.field2245.exists()) {
               throw new RuntimeException("");
            }

            class157.field2248 = true;
            class80.method1594();
            class155.field2239 = new CacheFile(new FileOnDisk(WallObject.method2898("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class155.field2241 = new CacheFile(new FileOnDisk(WallObject.method2898("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            PacketBuffer.field2417 = new CacheFile[class223.field2836];

            for(int var11 = 0; var11 < class223.field2836; ++var11) {
               PacketBuffer.field2417[var11] = new CacheFile(new FileOnDisk(WallObject.method2898("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var15) {
            class46.method680((String)null, var15);
         }

         class7.clientInstance = this;
         this.initialize(765, 503, 156);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lky;",
      garbageValue = "-196925387"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = FaceNormal.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = FaceNormal.getItemDefinition(var10);
         }
      }

      Model var21 = var9.getModel(1);
      if(var21 == null) {
         return null;
      } else {
         SpritePixels var22 = null;
         if(var9.notedTemplate != -1) {
            var22 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var22 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var22 == null) {
               return null;
            }
         } else if(var9.field3543 != -1) {
            var22 = createSprite(var9.field3528, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.method2676();
         Graphics3D.method2644(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.field3543 != -1) {
            var22.drawAt(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var21.method2558();
         var21.method2571(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var21.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var22.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5170(1);
         }

         if(var2 >= 2) {
            var8.method5170(16777215);
         }

         if(var3 != 0) {
            var8.method5171(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var22.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            Font var19 = class114.field1673;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4842(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.method2676();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-779653126"
   )
   static final String method1521(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
