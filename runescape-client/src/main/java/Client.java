import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
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
public final class Client extends GameEngine {
   @ObfuscatedName("ay")
   static boolean field1060;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 467909937
   )
   static int field950;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1742040257
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 1593233303
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lb")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field1107;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 2108833509
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -246571337
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = 629206993
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1932771507
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1996149045
   )
   static int field969;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 312013413
   )
   @Export("world")
   static int world;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 1222487521
   )
   static int field987;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 1357651803
   )
   static int field1129;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 1954948429
   )
   static int field1080;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      longValue = -4372030688823795277L
   )
   static long field1139;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = 1191869253
   )
   static int field1062;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1183248971
   )
   static int field1047;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 316946719
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1990275913
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("jj")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("mb")
   static boolean[] field1112;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 966349381
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("ml")
   static boolean[] field1133;
   @ObfuscatedName("ma")
   static boolean[] field1132;
   @ObfuscatedName("ju")
   static boolean[] field1131;
   @ObfuscatedName("je")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -854196691
   )
   static int field1075;
   @ObfuscatedName("jb")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("lo")
   static boolean field1099;
   @ObfuscatedName("ey")
   @ObfuscatedGetter(
      intValue = 898935891
   )
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("bh")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("ee")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 683431109
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 739284105
   )
   static int field1076;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -66956623
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("bw")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("jx")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = -1584661137
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("mj")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -712587933
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 2819847
   )
   static int field966;
   @ObfuscatedName("lk")
   static boolean field1104;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 631947323
   )
   static int field968;
   @ObfuscatedName("ki")
   static boolean field1096;
   @ObfuscatedName("ok")
   static boolean field1163;
   @ObfuscatedName("bq")
   static boolean field942;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = -227864129
   )
   static int field1101;
   @ObfuscatedName("jm")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfc;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -808490707
   )
   static int field1102;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      longValue = 7172754357909486141L
   )
   static long field944;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 2061205543
   )
   static int field1105;
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 244515203
   )
   static int field945;
   @ObfuscatedName("jl")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -120963505
   )
   static int field1029;
   @ObfuscatedName("js")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1140665751
   )
   static int field947;
   @ObfuscatedName("lf")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field1173;
   @ObfuscatedName("bv")
   static boolean field1050;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -296100235
   )
   static int field957;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = 903091061
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("mw")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("bx")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("mc")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -234918025
   )
   static int field1106;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 374868051
   )
   static int field995;
   @ObfuscatedName("jy")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 1363946263
   )
   static int field1095;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 1786843751
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1380641001
   )
   static int field951;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -1116824681
   )
   static int field991;
   @ObfuscatedName("jc")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("ke")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("jh")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 301256769
   )
   static int field952;
   @ObfuscatedName("ms")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("mz")
   @ObfuscatedGetter(
      intValue = 1239249355
   )
   static int field1124;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -915162149
   )
   static int field992;
   @ObfuscatedName("mp")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1033670093
   )
   static int field1141;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1732265799
   )
   static int field953;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = -171679855
   )
   static int field981;
   @ObfuscatedName("mu")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1547929597
   )
   static int field1033;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1244685713
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -1629125657
   )
   static int field1091;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -968311563
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("bu")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 2020154263
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("ry")
   @ObfuscatedSignature(
      signature = "Lbx;"
   )
   static final class74 field1201;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -162043607
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("it")
   static String field1084;
   @ObfuscatedName("km")
   static String field993;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 861816669
   )
   static int field940;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 602563815
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("kb")
   static String field1085;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1048555581
   )
   static int field1032;
   @ObfuscatedName("il")
   static boolean field1042;
   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field1098;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1119404505
   )
   static int field1161;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -1968230037
   )
   static int field1043;
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -464790499
   )
   static int field948;
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   static class92 field959;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -96690769
   )
   static int field1109;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = 821949169
   )
   static int field975;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -708892945
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 998075115
   )
   static int field1073;
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   static class92 field1117;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = -2099085345
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = 892534537
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("rh")
   static int[] field1149;
   @ObfuscatedName("rb")
   static int[] field1122;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 301189575
   )
   static int field1092;
   @ObfuscatedName("of")
   @ObfuscatedGetter(
      intValue = 1918714199
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("mt")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field964;
   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   static IndexedSprite[] field1001;
   @ObfuscatedName("oc")
   @ObfuscatedGetter(
      intValue = 1188387233
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      intValue = -1736110999
   )
   static int field982;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -1227593771
   )
   static int field1148;
   @ObfuscatedName("lm")
   static boolean field1110;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   static IndexData field965;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = 476656021
   )
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = -1624194967
   )
   static int field1031;
   @ObfuscatedName("dd")
   static byte[] field971;
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "[Lcs;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -1572894707
   )
   static int field958;
   @ObfuscatedName("di")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("er")
   static HashMap field989;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -446959265
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ed")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -1085309297
   )
   static int field961;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = -834192519
   )
   static int field1198;
   @ObfuscatedName("fh")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static PlayerComposition field1008;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 1358515401
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("mq")
   @ObfuscatedGetter(
      intValue = 1854199789
   )
   static int field1123;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -1102363693
   )
   static int field1100;
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   static PacketBuffer field978;
   @ObfuscatedName("lg")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("ly")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field1185;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 1117260603
   )
   static int field1115;
   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "[Lbz;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 1306524455
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1684591187
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("lv")
   static int[] field1078;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 426278541
   )
   static int field1015;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 1737133585
   )
   static int field1071;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = -1745427761
   )
   static int field1160;
   @ObfuscatedName("ln")
   static int[] field1116;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = 232643367
   )
   static int field1064;
   @ObfuscatedName("ht")
   static boolean field1016;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = -31947695
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 1081020495
   )
   static int field1119;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = 748007903
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -1207050277
   )
   static int field974;
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "[Lbo;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = -5658533
   )
   static int field1166;
   @ObfuscatedName("om")
   static int[] field1167;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -628607787
   )
   static int field1077;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = 1949257823
   )
   static int field1061;
   @ObfuscatedName("oh")
   static int[] field1168;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -2142819733
   )
   static int field1002;
   @ObfuscatedName("ob")
   static int[] field1169;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = -1150643863
   )
   static int field1054;
   @ObfuscatedName("pv")
   @ObfuscatedSignature(
      signature = "[Ldb;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("nb")
   static long[] field1145;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      longValue = 6328505419514135599L
   )
   static long field1150;
   @ObfuscatedName("pn")
   static int[] field1170;
   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field1090;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1159662831
   )
   static int field1068;
   @ObfuscatedName("fy")
   static int[][][] field998;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = -1315018639
   )
   static int field1036;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -671885663
   )
   static int field1136;
   @ObfuscatedName("oa")
   @ObfuscatedGetter(
      intValue = 504345757
   )
   static int field1024;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -100749703
   )
   static int field1108;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1122065317
   )
   static int field1037;
   @ObfuscatedName("pi")
   static boolean field1172;
   @ObfuscatedName("ky")
   static boolean field1158;
   @ObfuscatedName("pf")
   static boolean[] field1000;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 473180473
   )
   static int field973;
   @ObfuscatedName("na")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "[La;"
   )
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 296242837
   )
   static int field1153;
   @ObfuscatedName("nf")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -1340778335
   )
   static int field1154;
   @ObfuscatedName("oy")
   static int[] field935;
   @ObfuscatedName("fn")
   static final int[] field999;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1851921083
   )
   static int field1003;
   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "[[[Lgi;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -489649719
   )
   static int field1120;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -890554343
   )
   static int field1121;
   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("ou")
   static int[] field946;
   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("hz")
   static int[][] field1028;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 1482702845
   )
   static int field1179;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 2052822557
   )
   static int field1004;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -74028715
   )
   static int field1186;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = -2090191795
   )
   static int field1187;
   @ObfuscatedName("ol")
   @ObfuscatedSignature(
      signature = "[Lkp;"
   )
   static SpritePixels[] field1113;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = 497227525
   )
   static int field1088;
   @ObfuscatedName("go")
   static boolean field1065;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = 1852926601
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -2033979647
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = 1457833095
   )
   static int field1007;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = -825617959
   )
   static int field1089;
   @ObfuscatedName("pl")
   static short field1152;
   @ObfuscatedName("pk")
   static short field1178;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = 285305647
   )
   static int field1030;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -102117683
   )
   static int field1097;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1838283943
   )
   static int field1014;
   @ObfuscatedName("qr")
   static short field1184;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 1213619545
   )
   static int field1012;
   @ObfuscatedName("qe")
   static short field1086;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1149908797
   )
   static int field1013;
   @ObfuscatedName("po")
   static short field1183;
   @ObfuscatedName("pe")
   static short field1200;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 1422086895
   )
   static int field1191;
   @ObfuscatedName("pw")
   static short field1180;
   @ObfuscatedName("pb")
   static short field1126;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1324727259
   )
   static int field1199;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -241312159
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -362822949
   )
   static int field1094;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -1031852149
   )
   static int field1017;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 1012007219
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("qd")
   @ObfuscatedSignature(
      signature = "[Lbd;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -36131001
   )
   static int field936;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 737953827
   )
   static int field1048;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 1604669689
   )
   static int field1053;
   @ObfuscatedName("hh")
   static int[] field1019;
   @ObfuscatedName("px")
   static int[] field1175;
   @ObfuscatedName("hg")
   static int[] field1021;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -542949663
   )
   static int field1083;
   @ObfuscatedName("hj")
   static int[] field1022;
   @ObfuscatedName("hd")
   static int[] field1165;
   @ObfuscatedName("id")
   static int[] field1049;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -114396355
   )
   static int field1082;
   @ObfuscatedName("hi")
   static int[] field1130;
   @ObfuscatedName("hl")
   static int[] field1025;
   @ObfuscatedName("ik")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = 843338289
   )
   static int field1147;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -1128066893
   )
   static int field1192;
   @ObfuscatedName("hs")
   static int[] field1026;
   @ObfuscatedName("ib")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("hn")
   static String[] field1190;
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = 355110255
   )
   static int field949;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 1858794595
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -718987163
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("pr")
   static int[] field1174;
   @ObfuscatedName("pz")
   static int[] field1176;
   @ObfuscatedName("ih")
   static int[] field976;
   @ObfuscatedName("pg")
   static int[] field1177;
   @ObfuscatedName("nr")
   static int[] field960;
   @ObfuscatedName("mk")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field1044;
   @ObfuscatedName("ny")
   static int[] field1011;
   @ObfuscatedName("my")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field1127;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 540163977
   )
   static int field1146;
   @ObfuscatedName("ic")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 1226895339
   )
   @Export(
      value = "chatCycle",
      setter = true
   )
   static int chatCycle;
   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static class196 field1194;
   @ObfuscatedName("ku")
   static boolean field1027;
   @ObfuscatedName("np")
   static int[] field1181;
   @ObfuscatedName("jz")
   static boolean field1074;
   @ObfuscatedName("ji")
   static boolean field1046;
   @ObfuscatedName("nm")
   static String field1144;
   public static boolean RUNELITE_PACKET;

   static {
      field1060 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field942 = true;
      gameCycle = 0;
      field944 = -1L;
      field945 = -1;
      field1029 = -1;
      field947 = -1;
      field1050 = true;
      displayFps = false;
      field950 = 0;
      field951 = 0;
      field952 = 0;
      field953 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field1032 = 0;
      field1161 = 0;
      field959 = class92.field1424;
      field1117 = class92.field1424;
      loadingStage = 0;
      js5State = 0;
      field1047 = 0;
      field966 = 0;
      loginState = 0;
      field968 = 0;
      field969 = 0;
      field1031 = 0;
      field971 = null;
      cachedNPCs = new NPC['耀'];
      field958 = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field978 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field982 = 0;
      audioEffectCount = 0;
      lastFrameId = 0;
      secondLastFrameId = 0;
      thridLastFrameId = 0;
      field987 = 0;
      socketError = false;
      field989 = new HashMap();
      field991 = 0;
      field992 = 1;
      field981 = 0;
      field1091 = 1;
      field995 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field998 = new int[4][13][13];
      field999 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field957 = 0;
      field1002 = 2301979;
      field1003 = 5063219;
      field1004 = 3353893;
      field1179 = 7759444;
      field1065 = false;
      field1007 = 0;
      field1068 = 128;
      mapAngle = 0;
      field1030 = 0;
      field1014 = 0;
      field1012 = 0;
      field1013 = 0;
      field1199 = 50;
      field1015 = 0;
      field1016 = false;
      field1017 = 0;
      field936 = 0;
      field1053 = 50;
      field1019 = new int[field1053];
      field1021 = new int[field1053];
      field1022 = new int[field1053];
      field1165 = new int[field1053];
      field1130 = new int[field1053];
      field1025 = new int[field1053];
      field1026 = new int[field1053];
      field1190 = new String[field1053];
      field1028 = new int[104][104];
      field1071 = 0;
      screenY = -1;
      screenX = -1;
      field1141 = 0;
      field1033 = 0;
      field940 = 0;
      cursorState = 0;
      field1036 = 0;
      field1037 = 0;
      field1092 = 0;
      field975 = 0;
      field1073 = 0;
      field1146 = 0;
      field1042 = false;
      field1043 = 0;
      field1136 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1120 = 0;
      field1048 = 0;
      field1049 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field976 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1054 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1062 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1131 = new boolean[500];
      field1046 = false;
      field1074 = false;
      field1075 = -1;
      field1076 = -1;
      field1077 = 0;
      field1061 = 50;
      itemSelectionState = 0;
      field1084 = null;
      spellSelected = false;
      field1082 = -1;
      field1083 = -1;
      field993 = null;
      field1085 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field1088 = 0;
      field1089 = 0;
      field1090 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1094 = -1;
      field1158 = false;
      field1096 = false;
      field1027 = false;
      field1098 = null;
      field1107 = null;
      field1173 = null;
      field1101 = 0;
      field1102 = 0;
      field1185 = null;
      field1104 = false;
      field1105 = -1;
      field1106 = -1;
      field1099 = false;
      field948 = -1;
      field1109 = -1;
      field1110 = false;
      cycleCntr = 1;
      field1078 = new int[32];
      field961 = 0;
      interfaceItemTriggers = new int[32];
      field1115 = 0;
      field1116 = new int[32];
      field1064 = 0;
      chatCycle = 0;
      field1119 = 0;
      field973 = 0;
      field1121 = 0;
      field949 = 0;
      field1123 = 0;
      field1124 = 0;
      field964 = new Deque();
      field1044 = new Deque();
      field1127 = new Deque();
      widgetFlags = new XHashTable(512);
      field1129 = 0;
      field1080 = -2;
      field1112 = new boolean[100];
      field1132 = new boolean[100];
      field1133 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1139 = 0L;
      isResized = true;
      field1181 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1097 = 0;
      field1191 = 0;
      field1144 = "";
      field1145 = new long[100];
      field1108 = 0;
      field1147 = 0;
      field1011 = new int[128];
      field960 = new int[128];
      field1150 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1153 = -1;
      field1154 = 0;
      field935 = new int[1000];
      field946 = new int[1000];
      field1113 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1160 = 0;
      field1024 = 255;
      field1095 = -1;
      field1163 = false;
      field974 = 127;
      field1148 = 127;
      field1166 = 0;
      field1167 = new int[50];
      field1168 = new int[50];
      field1169 = new int[50];
      field1170 = new int[50];
      audioEffects = new SoundEffect[50];
      field1172 = false;
      field1000 = new boolean[5];
      field1174 = new int[5];
      field1175 = new int[5];
      field1176 = new int[5];
      field1177 = new int[5];
      field1178 = 256;
      field1152 = 205;
      field1180 = 256;
      field1200 = 320;
      field1126 = 1;
      field1183 = 32767;
      field1184 = 1;
      field1086 = 32767;
      field1186 = 0;
      field1187 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1192 = 0;
      friends = new Friend[400];
      field1194 = new class196();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1008 = new PlayerComposition();
      field1198 = -1;
      field1100 = 1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field1201 = new class74();
      field1149 = new int[50];
      field1122 = new int[50];
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2145160168"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         long var2 = class74.currentTimeMs();
         int var4 = (int)(var2 - class239.field3252);
         class239.field3252 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class239.field3237 += var4;
         boolean var1;
         if(class239.field3247 == 0 && class239.field3242 == 0 && class239.field3245 == 0 && class239.field3240 == 0) {
            var1 = true;
         } else if(class239.field3246 == null) {
            var1 = false;
         } else {
            try {
               label244: {
                  if(class239.field3237 > 30000) {
                     throw new IOException();
                  }

                  FileRequest var5;
                  Buffer var6;
                  while(class239.field3242 < 20 && class239.field3240 > 0) {
                     var5 = (FileRequest)class239.field3250.method3558();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class239.field3246.queueForWrite(var6.payload, 0, 4);
                     class239.field3241.put(var5, var5.hash);
                     --class239.field3240;
                     ++class239.field3242;
                  }

                  while(class239.field3247 < 20 && class239.field3245 > 0) {
                     var5 = (FileRequest)class239.field3243.peek();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class239.field3246.queueForWrite(var6.payload, 0, 4);
                     var5.unlinkDual();
                     class239.field3253.put(var5, var5.hash);
                     --class239.field3245;
                     ++class239.field3247;
                  }

                  for(int var18 = 0; var18 < 100; ++var18) {
                     int var19 = class239.field3246.available();
                     if(var19 < 0) {
                        throw new IOException();
                     }

                     if(var19 == 0) {
                        break;
                     }

                     class239.field3237 = 0;
                     byte var7 = 0;
                     if(class239.currentRequest == null) {
                        var7 = 8;
                     } else if(class239.field3251 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class239.field3238.offset;
                        if(var8 > var19) {
                           var8 = var19;
                        }

                        class239.field3246.read(class239.field3238.payload, class239.field3238.offset, var8);
                        if(class239.field3254 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class239.field3238.payload[class239.field3238.offset + var9] ^= class239.field3254;
                           }
                        }

                        class239.field3238.offset += var8;
                        if(class239.field3238.offset < var7) {
                           break;
                        }

                        if(class239.currentRequest == null) {
                           class239.field3238.offset = 0;
                           var9 = class239.field3238.readUnsignedByte();
                           var10 = class239.field3238.readUnsignedShort();
                           int var11 = class239.field3238.readUnsignedByte();
                           var12 = class239.field3238.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           FileRequest var15 = (FileRequest)class239.field3241.get(var13);
                           class239.field3248 = true;
                           if(var15 == null) {
                              var15 = (FileRequest)class239.field3253.get(var13);
                              class239.field3248 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class239.currentRequest = var15;
                           class40.field555 = new Buffer(var12 + var16 + class239.currentRequest.padding);
                           class40.field555.putByte(var11);
                           class40.field555.putInt(var12);
                           class239.field3251 = 8;
                           class239.field3238.offset = 0;
                        } else if(class239.field3251 == 0) {
                           if(class239.field3238.payload[0] == -1) {
                              class239.field3251 = 1;
                              class239.field3238.offset = 0;
                           } else {
                              class239.currentRequest = null;
                           }
                        }
                     } else {
                        var8 = class40.field555.payload.length - class239.currentRequest.padding;
                        var9 = 512 - class239.field3251;
                        if(var9 > var8 - class40.field555.offset) {
                           var9 = var8 - class40.field555.offset;
                        }

                        if(var9 > var19) {
                           var9 = var19;
                        }

                        class239.field3246.read(class40.field555.payload, class40.field555.offset, var9);
                        if(class239.field3254 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class40.field555.payload[var10 + class40.field555.offset] ^= class239.field3254;
                           }
                        }

                        class40.field555.offset += var9;
                        class239.field3251 += var9;
                        if(var8 == class40.field555.offset) {
                           if(16711935L == class239.currentRequest.hash) {
                              class113.field1679 = class40.field555;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var20 = class239.field3236[var10];
                                 if(var20 != null) {
                                    class113.field1679.offset = var10 * 8 + 5;
                                    var12 = class113.field1679.readInt();
                                    int var21 = class113.field1679.readInt();
                                    var20.setInformation(var12, var21);
                                 }
                              }
                           } else {
                              class239.field3249.reset();
                              class239.field3249.update(class40.field555.payload, 0, var8);
                              var10 = (int)class239.field3249.getValue();
                              if(var10 != class239.currentRequest.crc) {
                                 try {
                                    class239.field3246.close();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class239.field3255;
                                 class239.field3246 = null;
                                 class239.field3254 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label244;
                              }

                              class239.field3255 = 0;
                              class239.field3256 = 0;
                              class239.currentRequest.index.method4230((int)(class239.currentRequest.hash & 65535L), class40.field555.payload, (class239.currentRequest.hash & 16711680L) == 16711680L, class239.field3248);
                           }

                           class239.currentRequest.unlink();
                           if(class239.field3248) {
                              --class239.field3242;
                           } else {
                              --class239.field3247;
                           }

                           class239.field3251 = 0;
                           class239.currentRequest = null;
                           class40.field555 = null;
                        } else {
                           if(class239.field3251 != 512) {
                              break;
                           }

                           class239.field3251 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class239.field3246.close();
               } catch (Exception var22) {
                  ;
               }

               ++class239.field3256;
               class239.field3246 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1216();
         }

      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-467640113"
   )
   void method1221() {
      int var1 = GameEngine.canvasWidth;
      int var2 = class1.canvasHeight;
      if(super.field713 < var1) {
         var1 = super.field713;
      }

      if(super.field702 < var2) {
         var2 = super.field702;
      }

      if(class3.preferences != null) {
         try {
            class52.method815(class27.clientInstance, "resize", new Object[]{Integer.valueOf(class13.method77())});
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-893701307"
   )
   protected final void vmethod1399() {
      if(class156.chatMessages.changed()) {
         class156.chatMessages.serialize();
      }

      if(class84.field1357 != null) {
         class84.field1357.field877 = false;
      }

      class84.field1357 = null;
      if(VertexNormal.rssocket != null) {
         VertexNormal.rssocket.close();
         VertexNormal.rssocket = null;
      }

      WorldMapType3.method213();
      RSCanvas.method829();
      FileRequest.field3197 = null;
      if(class84.soundSystem0 != null) {
         class84.soundSystem0.method2034();
      }

      if(WorldMapType1.soundSystem1 != null) {
         WorldMapType1.soundSystem1.method2034();
      }

      SceneTilePaint.method2699();
      class221.method4072();
      if(class11.field264 != null) {
         class11.field264.method1150();
         class11.field264 = null;
      }

      World.method1587();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1833788586"
   )
   protected final void vmethod1272() {
      class281.field3741 = socketType == 0?'ꩊ':world + '鱀';
      class25.field377 = socketType == 0?443:world + '썐';
      WidgetNode.myWorldPort = class281.field3741;
      PlayerComposition.colorsToFind = class215.field2628;
      PlayerComposition.colorsToReplace = class215.field2633;
      PlayerComposition.field2621 = class215.field2630;
      PlayerComposition.field2613 = class215.field2631;
      class11.field264 = new class69();
      this.method928();
      this.method1003();
      FileRequest.field3197 = this.method905();
      XClanMember.field929 = new IndexFile(255, class156.field2257, class156.field2253, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = class12.getPreferencesFile("", class35.field505.field3183, false);
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

      class3.preferences = var3;
      this.method914();
      String var10 = class61.field778;
      class56.field678 = this;
      class56.field686 = var10;
      if(socketType != 0) {
         displayFps = true;
      }

      int var7 = class3.preferences.screenType;
      field1139 = 0L;
      if(var7 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      if(class13.method77() == 1) {
         class27.clientInstance.method888(765, 503);
      } else {
         class27.clientInstance.method888(7680, 2160);
      }

      if(gameState >= 25) {
         class88.method1705();
      }

   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-837875140"
   )
   final void method1437(boolean var1) {
      Widget.method4049(widgetRoot, GameEngine.canvasWidth, class1.canvasHeight, var1);
   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "2254"
   )
   @Export("error")
   void error(int var1) {
      socket = null;
      class262.rssocket = null;
      js5State = 0;
      if(WidgetNode.myWorldPort == class281.field3741) {
         WidgetNode.myWorldPort = class25.field377;
      } else {
         WidgetNode.myWorldPort = class281.field3741;
      }

      ++field966;
      if(field966 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field1047 = 3000;
         }
      } else if(field966 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field966 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field1047 = 3000;
         }
      }

   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "83"
   )
   final boolean method1365() {
      int var1 = menuOptionCount - 1;
      if(menuOptionCount > 2) {
         if(field1062 != 1 || field1131[var1]) {
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

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-109"
   )
   protected final void vmethod1219() {
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "69"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(VertexNormal.rssocket == null) {
         return false;
      } else {
         int var15;
         String var16;
         try {
            int var1 = VertexNormal.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = RUNELITE_PACKET?-2:class273.field3683[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field982 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId;
            lastFrameId = packetType;
            int var2;
            if(packetType == (RUNELITE_PACKET?0:78)) {
               field1172 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1000[var2] = false;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?1:247)) {
               field1192 = 1;
               field1119 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?2:56)) {
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

            if(packetType == (RUNELITE_PACKET?3:18)) {
               class2.method5(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?4:223)) {
               class36.method508();

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               TextureProvider.initializeGPI(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?5:135)) {
               for(var2 = 0; var2 < class171.field2344; ++var2) {
                  VarPlayerType var51 = class169.method3137(var2);
                  if(var51 != null) {
                     class212.settings[var2] = 0;
                     class212.widgetSettings[var2] = 0;
                  }
               }

               CollisionData.method3075();
               field961 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?6:5)) {
               class33.method374();
               packetType = -1;
               return false;
            }

            if(packetType == (RUNELITE_PACKET?7:4)) {
               for(var2 = 0; var2 < class212.widgetSettings.length; ++var2) {
                  if(class212.settings[var2] != class212.widgetSettings[var2]) {
                     class212.widgetSettings[var2] = class212.settings[var2];
                     class12.method60(var2);
                     field1078[++field961 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?8:51)) {
               class69.method1152(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?9:58)) {
               if(widgetRoot != -1) {
                  Friend.method1140(widgetRoot, 0);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?10:65)) {
               field1160 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?11:164)) {
               field950 = secretPacketBuffer2.method3210() * 30;
               field1123 = cycleCntr;
               packetType = -1;
               return true;
            }

            int var22;
            if(packetType == (RUNELITE_PACKET?12:129)) {
               if(RUNELITE_PACKET) {
                  var15 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var15 = secretPacketBuffer2.readUnsignedByte();
               }

               class277[] var90 = new class277[]{class277.field3720, class277.field3719, class277.field3722};
               class277[] var89 = var90;
               var22 = 0;

               class277 var78;
               while(true) {
                  if(var22 >= var89.length) {
                     var78 = null;
                     break;
                  }

                  class277 var63 = var89[var22];
                  if(var15 == var63.field3721) {
                     var78 = var63;
                     break;
                  }

                  ++var22;
               }

               Projectile.field1488 = var78;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?13:253)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3219();
               }

               class69.field850 = GameEngine.taskManager.createHost(var2);
               packetType = -1;
               return true;
            }

            int var4;
            if(packetType == (RUNELITE_PACKET?14:239)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
               }

               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(var2 == -1 && !field1163) {
                  class204.field2501.method3758();
                  class204.field2507 = 1;
                  class204.field2502 = null;
               } else if(var2 != -1 && var2 != field1095 && field1024 != 0 && !field1163) {
                  IndexData var49 = class253.indexTrack1;
                  var4 = field1024;
                  class204.field2507 = 1;
                  class204.field2502 = var49;
                  class150.field2205 = var2;
                  class153.field2222 = 0;
                  class204.field2504 = var4;
                  class99.field1532 = false;
                  class204.field2505 = 2;
               }

               field1095 = var2;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?15:169)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3209();
               }

               KeyFocusListener.method806(var2);
               interfaceItemTriggers[++field1115 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            Widget var48;
            if(packetType == (RUNELITE_PACKET?16:249)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
               }

               var48 = class84.method1670(var2);

               for(var4 = 0; var4 < var48.itemIds.length; ++var4) {
                  var48.itemIds[var4] = -1;
                  var48.itemIds[var4] = 0;
               }

               class90.method1723(var48);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?17:68)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3218();
               }

               var48 = class84.method1670(var2);
               var48.modelType = 3;
               var48.modelId = XGrandExchangeOffer.localPlayer.composition.method3966();
               class90.method1723(var48);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?18:101)) {
               CollisionData.method3075();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1123 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?19:25)) {
               CollisionData.method3075();
               weight = secretPacketBuffer2.readShort();
               field1123 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?20:179)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
               }

               WidgetNode var47 = (WidgetNode)componentTable.get((long)var2);
               if(var47 != null) {
                  class17.method127(var47, true);
               }

               if(field1090 != null) {
                  class90.method1723(field1090);
                  field1090 = null;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?21:112)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3329();
               }

               widgetRoot = var2;
               this.method1437(false);
               class163.method3086(var2);
               class205.method3813(widgetRoot);

               for(var15 = 0; var15 < 100; ++var15) {
                  field1112[var15] = true;
               }

               packetType = -1;
               return true;
            }

            String var3;
            if(packetType == (RUNELITE_PACKET?22:74)) {
               if(RUNELITE_PACKET) {
                  var16 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var16 = secretPacketBuffer2.readString();
               }

               var3 = FontTypeFace.appendTags(VarPlayerType.method4301(class229.method4091(secretPacketBuffer2)));
               NPC.sendGameMessage(6, var16, var3);
               packetType = -1;
               return true;
            }

            String var21;
            String var83;
            if(packetType == (RUNELITE_PACKET?23:217)) {
               if(RUNELITE_PACKET) {
                  var16 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var16 = secretPacketBuffer2.readString();
               }

               sessionToken = var16;

               try {
                  var3 = class27.clientInstance.getParameter(Parameters.field3712.key);
                  var21 = class27.clientInstance.getParameter(Parameters.field3715.key);
                  var83 = var3 + "settings=" + var16 + "; version=1; path=/; domain=" + var21;
                  if(var16.length() == 0) {
                     var83 = var83 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var83 = var83 + "; Expires=" + class158.method3001(class74.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
                  }

                  Client var64 = class27.clientInstance;
                  String var62 = "document.cookie=\"" + var83 + "\"";
                  JSObject.getWindow(var64).eval(var62);
               } catch (Throwable var42) {
                  ;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?24:98)) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.checkCrc()) {
                  PacketBuffer var75 = secretPacketBuffer2;
                  var15 = secretPacketBuffer2.offset - 28;
                  Tile.method2520(var75.payload, var15);
                  if(class156.field2249 != null) {
                     try {
                        class156.field2249.seek(0L);
                        class156.field2249.write(var75.payload, var15, 24);
                     } catch (Exception var41) {
                        ;
                     }
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?25:42)) {
               byte var91;
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var91 = secretPacketBuffer2.runeliteReadByte();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var91 = secretPacketBuffer2.method3345();
               }

               class212.settings[var2] = var91;
               if(class212.widgetSettings[var2] != var91) {
                  class212.widgetSettings[var2] = var91;
               }

               class12.method60(var2);
               field1078[++field961 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?26:96)) {
               class34.field498 = secretPacketBuffer2.method3185();
               TextureProvider.field1788 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?27:31)) {
               field1097 = secretPacketBuffer2.readUnsignedByte();
               field1191 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?28:216)) {
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

            if(packetType == (RUNELITE_PACKET?29:83)) {
               if(RUNELITE_PACKET) {
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3337();
                  var15 = secretPacketBuffer2.readUnsignedShort();
               }

               if(var15 == '\uffff') {
                  var15 = -1;
               }

               if(field1024 != 0 && var15 != -1) {
                  class66.method1144(DState.indexTrack2, var15, 0, field1024, false);
                  field1163 = true;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?30:254)) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1121 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?31:71)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
                  var15 = secretPacketBuffer2.readInt();
               }

               var4 = class14.method84();
               secretPacketBuffer1.putOpcode(40);
               secretPacketBuffer1.method3215(var2);
               secretPacketBuffer1.method3215(var15);
               secretPacketBuffer1.method3262(GameEngine.FPS);
               secretPacketBuffer1.putLEInt(var4);
               packetType = -1;
               return true;
            }

            int var20;
            int var23;
            if(packetType == (RUNELITE_PACKET?32:191)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3209();
                  var15 = secretPacketBuffer2.method3351();
               }

               var4 = var2 >> 10 & 31;
               var20 = var2 >> 5 & 31;
               var22 = var2 & 31;
               var23 = (var20 << 11) + (var4 << 19) + (var22 << 3);
               Widget var67 = class84.method1670(var15);
               if(var23 != var67.textColor) {
                  var67.textColor = var23;
                  class90.method1723(var67);
               }

               packetType = -1;
               return true;
            }

            boolean var74;
            Widget var77;
            if(packetType == (RUNELITE_PACKET?33:140)) {
               var2 = secretPacketBuffer2.readInt();
               var74 = secretPacketBuffer2.method3185() == 1;
               var77 = class84.method1670(var2);
               if(var74 != var77.isHidden) {
                  var77.isHidden = var74;
                  class90.method1723(var77);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?34:77)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3351();
                  var15 = secretPacketBuffer2.method3367();
               }

               var77 = class84.method1670(var2);
               if(var15 != var77.field2775 || var15 == -1) {
                  var77.field2775 = var15;
                  var77.field2771 = 0;
                  var77.field2747 = 0;
                  class90.method1723(var77);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?35:244)) {
               if(RUNELITE_PACKET) {
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3209();
                  var15 = secretPacketBuffer2.readInt();
               }

               var77 = class84.method1670(var15);
               if(var77.modelType != 2 || var2 != var77.modelId) {
                  var77.modelType = 2;
                  var77.modelId = var2;
                  class90.method1723(var77);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?36:219)) {
               if(RUNELITE_PACKET) {
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3209();
                  var15 = secretPacketBuffer2.method3219();
               }

               var77 = class84.method1670(var15);
               if(var77.modelType != 1 || var2 != var77.modelId) {
                  var77.modelType = 1;
                  var77.modelId = var2;
                  class90.method1723(var77);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?37:208)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3351();
                  var15 = secretPacketBuffer2.readUnsignedShort();
               }

               var77 = class84.method1670(var2);
               if(var77 != null && var77.type == 0) {
                  if(var15 > var77.scrollHeight - var77.height) {
                     var15 = var77.scrollHeight - var77.height;
                  }

                  if(var15 < 0) {
                     var15 = 0;
                  }

                  if(var15 != var77.scrollY) {
                     var77.scrollY = var15;
                     class90.method1723(var77);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?40:102)) {
               TextureProvider.field1788 = secretPacketBuffer2.readUnsignedShortOb1();
               class34.field498 = secretPacketBuffer2.method3185();

               for(var2 = TextureProvider.field1788; var2 < TextureProvider.field1788 + 8; ++var2) {
                  for(var15 = class34.field498; var15 < class34.field498 + 8; ++var15) {
                     if(groundItemDeque[class35.plane][var2][var15] != null) {
                        groundItemDeque[class35.plane][var2][var15] = null;
                        class209.groundItemSpawned(var2, var15);
                     }
                  }
               }

               for(PendingSpawn var73 = (PendingSpawn)pendingSpawns.getFront(); var73 != null; var73 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var73.x >= TextureProvider.field1788 && var73.x < TextureProvider.field1788 + 8 && var73.y >= class34.field498 && var73.y < class34.field498 + 8 && var73.level == class35.plane) {
                     var73.hitpoints = 0;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?41:242)) {
               if(RUNELITE_PACKET) {
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3351();
                  var15 = secretPacketBuffer2.method3329();
               }

               class212.settings[var15] = var2;
               if(class212.widgetSettings[var15] != var2) {
                  class212.widgetSettings[var15] = var2;
               }

               class12.method60(var15);
               field1078[++field961 - 1 & 31] = var15;
               packetType = -1;
               return true;
            }

            WidgetNode var25;
            Widget var53;
            if(packetType == (RUNELITE_PACKET?42:109)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
                  var15 = secretPacketBuffer2.readInt();
               }

               WidgetNode var87 = (WidgetNode)componentTable.get((long)var2);
               var25 = (WidgetNode)componentTable.get((long)var15);
               if(var25 != null) {
                  class17.method127(var25, var87 == null || var87.id != var25.id);
               }

               if(var87 != null) {
                  var87.unlink();
                  componentTable.put(var87, (long)var15);
               }

               var53 = class84.method1670(var2);
               if(var53 != null) {
                  class90.method1723(var53);
               }

               var53 = class84.method1670(var15);
               if(var53 != null) {
                  class90.method1723(var53);
                  class51.method812(class176.widgets[var53.id >>> 16], var53, true);
               }

               if(widgetRoot != -1) {
                  Friend.method1140(widgetRoot, 1);
               }

               packetType = -1;
               return true;
            }

            boolean var45;
            if(packetType == (RUNELITE_PACKET?43:172)) {
               var45 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var45) {
                  class29.field429 = class74.currentTimeMs() - secretPacketBuffer2.readLong();
                  class61.field779 = new class13(secretPacketBuffer2, true);
               } else {
                  class61.field779 = null;
               }

               field949 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?44:200)) {
               if(RUNELITE_PACKET) {
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var16 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var16 = secretPacketBuffer2.readString();
                  var15 = secretPacketBuffer2.readInt();
               }

               var77 = class84.method1670(var15);
               if(!var16.equals(var77.text)) {
                  var77.text = var16;
                  class90.method1723(var77);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?45:187)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var4 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var15 = secretPacketBuffer2.readUnsignedByte();
                  var4 = secretPacketBuffer2.readUnsignedShort();
               }

               class2.method4(var2, var15, var4);
               packetType = -1;
               return true;
            }

            Widget var85;
            if(packetType == (RUNELITE_PACKET?47:52)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var4 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3218();
                  var15 = secretPacketBuffer2.method3210();
                  var4 = secretPacketBuffer2.method3329();
               }

               var85 = class84.method1670(var2);
               var85.field2705 = var4 + (var15 << 16);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?49:82)) {
               if(RUNELITE_PACKET) {
                  var4 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  CollisionData.method3075();
               } else {
                  CollisionData.method3075();
                  var2 = secretPacketBuffer2.method3201();
                  var15 = secretPacketBuffer2.method3185();
                  var4 = secretPacketBuffer2.method3218();
               }

               skillExperiences[var2] = var4;
               boostedSkillLevels[var2] = var15;
               realSkillLevels[var2] = 1;

               for(var20 = 0; var20 < 98; ++var20) {
                  if(var4 >= class223.field2835[var20]) {
                     realSkillLevels[var2] = var20 + 2;
                  }
               }

               field1116[++field1064 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?50:12)) {
               if(RUNELITE_PACKET) {
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var4 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3367();
                  var15 = secretPacketBuffer2.method3219();
                  var4 = secretPacketBuffer2.method3212();
               }

               var85 = class84.method1670(var15);
               if(var2 != var85.originalX || var4 != var85.originalY || var85.field2654 != 0 || var85.field2734 != 0) {
                  var85.originalX = var2;
                  var85.originalY = var4;
                  var85.field2654 = 0;
                  var85.field2734 = 0;
                  class90.method1723(var85);
                  this.method1228(var85);
                  if(var85.type == 0) {
                     class51.method812(class176.widgets[var15 >> 16], var85, false);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?51:60)) {
               var2 = secretPacketBuffer2.method3218();
               var15 = secretPacketBuffer2.method3329();
               if(var15 == '\uffff') {
                  var15 = -1;
               }

               var4 = secretPacketBuffer2.readInt();
               var85 = class84.method1670(var4);
               ItemComposition var58;
               if(!var85.hasScript) {
                  if(var15 == -1) {
                     var85.modelType = 0;
                     packetType = -1;
                     return true;
                  }

                  var58 = SoundTask.getItemDefinition(var15);
                  var85.modelType = 4;
                  var85.modelId = var15;
                  var85.rotationX = var58.xan2d;
                  var85.rotationZ = var58.yan2d;
                  var85.modelZoom = var58.zoom2d * 100 / var2;
                  class90.method1723(var85);
               } else {
                  var85.itemId = var15;
                  var85.itemQuantity = var2;
                  var58 = SoundTask.getItemDefinition(var15);
                  var85.rotationX = var58.xan2d;
                  var85.rotationZ = var58.yan2d;
                  var85.rotationY = var58.zan2d;
                  var85.field2698 = var58.offsetX2d;
                  var85.field2699 = var58.offsetY2d;
                  var85.modelZoom = var58.zoom2d;
                  if(var58.isStackable == 1) {
                     var85.field2707 = 1;
                  } else {
                     var85.field2707 = 2;
                  }

                  if(var85.field2704 > 0) {
                     var85.modelZoom = var85.modelZoom * 32 / var85.field2704;
                  } else if(var85.originalWidth > 0) {
                     var85.modelZoom = var85.modelZoom * 32 / var85.originalWidth;
                  }

                  class90.method1723(var85);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?53:176)) {
               if(RUNELITE_PACKET) {
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var4 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShortOb1();
                  var15 = secretPacketBuffer2.readInt();
                  var4 = secretPacketBuffer2.method3210();
               }

               var25 = (WidgetNode)componentTable.get((long)var15);
               if(var25 != null) {
                  class17.method127(var25, var4 != var25.id);
               }

               WidgetNode var56 = new WidgetNode();
               var56.id = var4;
               var56.owner = var2;
               componentTable.put(var56, (long)var15);
               class163.method3086(var4);
               Widget var60 = class84.method1670(var15);
               class90.method1723(var60);
               if(field1090 != null) {
                  class90.method1723(field1090);
                  field1090 = null;
               }

               class74.method1183();
               class51.method812(class176.widgets[var15 >> 16], var60, false);
               class205.method3813(var4);
               if(widgetRoot != -1) {
                  Friend.method1140(widgetRoot, 1);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?54:177)) {
               if(RUNELITE_PACKET) {
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var21 = secretPacketBuffer2.runeliteReadString();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var15 = secretPacketBuffer2.readUnsignedShortOb1();
                  var21 = secretPacketBuffer2.readString();
               }

               if(var15 >= 1 && var15 <= 8) {
                  if(var21.equalsIgnoreCase("null")) {
                     var21 = null;
                  }

                  playerOptions[var15 - 1] = var21;
                  playerOptionsPriorities[var15 - 1] = var2 == 0;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?55:75)) {
               World var72 = new World();
               var72.address = secretPacketBuffer2.readString();
               var72.id = secretPacketBuffer2.readUnsignedShort();
               var15 = secretPacketBuffer2.readInt();
               var72.mask = var15;
               MouseInput.setGameState(45);
               VertexNormal.rssocket.close();
               VertexNormal.rssocket = null;
               SoundTask.method2101(var72);
               packetType = -1;
               return false;
            }

            boolean var76;
            boolean var79;
            int var80;
            if(packetType == (RUNELITE_PACKET?56:167)) {
               var16 = secretPacketBuffer2.readString();
               var15 = secretPacketBuffer2.readUnsignedShort();
               byte var65 = secretPacketBuffer2.readByte();
               var76 = false;
               if(var65 == -128) {
                  var76 = true;
               }

               if(var76) {
                  if(class82.clanChatCount == 0) {
                     packetType = -1;
                     return true;
                  }

                  var79 = false;

                  for(var22 = 0; var22 < class82.clanChatCount && (!class28.clanMembers[var22].username.equals(var16) || var15 != class28.clanMembers[var22].world); ++var22) {
                     ;
                  }

                  if(var22 < class82.clanChatCount) {
                     while(var22 < class82.clanChatCount - 1) {
                        class28.clanMembers[var22] = class28.clanMembers[var22 + 1];
                        ++var22;
                     }

                     --class82.clanChatCount;
                     class28.clanMembers[class82.clanChatCount] = null;
                  }
               } else {
                  secretPacketBuffer2.readString();
                  XClanMember var54 = new XClanMember();
                  var54.username = var16;
                  var54.field927 = FloorUnderlayDefinition.method4398(var54.username, class22.field354);
                  var54.world = var15;
                  var54.rank = var65;

                  for(var23 = class82.clanChatCount - 1; var23 >= 0; --var23) {
                     var80 = class28.clanMembers[var23].field927.compareTo(var54.field927);
                     if(var80 == 0) {
                        class28.clanMembers[var23].world = var15;
                        class28.clanMembers[var23].rank = var65;
                        if(var16.equals(XGrandExchangeOffer.localPlayer.name)) {
                           class84.clanChatRank = var65;
                        }

                        field973 = cycleCntr;
                        packetType = -1;
                        return true;
                     }

                     if(var80 < 0) {
                        break;
                     }
                  }

                  if(class82.clanChatCount >= class28.clanMembers.length) {
                     packetType = -1;
                     return true;
                  }

                  for(var80 = class82.clanChatCount - 1; var80 > var23; --var80) {
                     class28.clanMembers[var80 + 1] = class28.clanMembers[var80];
                  }

                  if(class82.clanChatCount == 0) {
                     class28.clanMembers = new XClanMember[100];
                  }

                  class28.clanMembers[var23 + 1] = var54;
                  ++class82.clanChatCount;
                  if(var16.equals(XGrandExchangeOffer.localPlayer.name)) {
                     class84.clanChatRank = var65;
                  }
               }

               field973 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?57:114)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var4 = secretPacketBuffer2.runeliteReadInt();
                  var20 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var15 = secretPacketBuffer2.readUnsignedByte();
                  var4 = secretPacketBuffer2.readUnsignedByte();
                  var20 = secretPacketBuffer2.readUnsignedByte();
               }

               field1000[var2] = true;
               field1174[var2] = var15;
               field1175[var2] = var4;
               field1176[var2] = var20;
               field1177[var2] = 0;
               packetType = -1;
               return true;
            }

            long var33;
            if(packetType == (RUNELITE_PACKET?60:22)) {
               var2 = secretPacketBuffer2.readInt();
               var15 = secretPacketBuffer2.method3329();
               if(var15 == '\uffff') {
                  var15 = -1;
               }

               var4 = secretPacketBuffer2.method3210();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               var20 = secretPacketBuffer2.method3219();

               for(var22 = var15; var22 <= var4; ++var22) {
                  var33 = (long)var22 + ((long)var20 << 32);
                  Node var88 = widgetFlags.get(var33);
                  if(var88 != null) {
                     var88.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var2), var33);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?61:14)) {
               if(RUNELITE_PACKET) {
                  var20 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var15 = secretPacketBuffer2.runeliteReadInt();
                  var4 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3209();
                  var15 = secretPacketBuffer2.readUnsignedShort();
                  var4 = secretPacketBuffer2.method3210();
                  var20 = secretPacketBuffer2.readInt();
               }

               var53 = class84.method1670(var20);
               if(var2 != var53.rotationX || var15 != var53.rotationZ || var4 != var53.modelZoom) {
                  var53.rotationX = var2;
                  var53.rotationZ = var15;
                  var53.modelZoom = var4;
                  class90.method1723(var53);
               }

               packetType = -1;
               return true;
            }

            long var5;
            long var17;
            if(packetType == (RUNELITE_PACKET?63:41)) {
               var16 = secretPacketBuffer2.readString();
               var17 = (long)secretPacketBuffer2.readUnsignedShort();
               var5 = (long)secretPacketBuffer2.read24BitInt();
               Permission[] var59 = new Permission[]{Permission.field3168, Permission.field3169, Permission.field3164, Permission.field3167, Permission.field3166, Permission.field3165};
               Permission var66 = (Permission)PlayerComposition.forOrdinal(var59, secretPacketBuffer2.readUnsignedByte());
               long var9 = (var17 << 32) + var5;
               boolean var11 = false;

               for(int var70 = 0; var70 < 100; ++var70) {
                  if(field1145[var70] == var9) {
                     var11 = true;
                     break;
                  }
               }

               if(class27.isIgnored(var16)) {
                  var11 = true;
               }

               if(!var11 && field1136 == 0) {
                  field1145[field1108] = var9;
                  field1108 = (field1108 + 1) % 100;
                  String var19 = FontTypeFace.appendTags(VarPlayerType.method4301(class229.method4091(secretPacketBuffer2)));
                  byte var71;
                  if(var66.field3171) {
                     var71 = 7;
                  } else {
                     var71 = 3;
                  }

                  if(var66.field3170 != -1) {
                     NPC.sendGameMessage(var71, class89.method1717(var66.field3170) + var16, var19);
                  } else {
                     NPC.sendGameMessage(var71, var16, var19);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?64:178)) {
               var2 = secretPacketBuffer2.getUSmart();
               var74 = secretPacketBuffer2.readUnsignedByte() == 1;
               var21 = "";
               var76 = false;
               if(var74) {
                  var21 = secretPacketBuffer2.readString();
                  if(class27.isIgnored(var21)) {
                     var76 = true;
                  }
               }

               String var52 = secretPacketBuffer2.readString();
               if(!var76) {
                  NPC.sendGameMessage(var2, var21, var52);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?65:237)) {
               var16 = secretPacketBuffer2.readString();
               Object[] var46 = new Object[var16.length() + 1];

               for(var4 = var16.length() - 1; var4 >= 0; --var4) {
                  if(var16.charAt(var4) == 115) {
                     var46[var4 + 1] = secretPacketBuffer2.readString();
                  } else {
                     var46[var4 + 1] = new Integer(secretPacketBuffer2.readInt());
                  }
               }

               var46[0] = new Integer(secretPacketBuffer2.readInt());
               ScriptEvent var81 = new ScriptEvent();
               var81.field856 = var46;
               Coordinates.method3942(var81);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?66:207)) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var74 = (var2 & 1) == 1;
                  var21 = secretPacketBuffer2.readString();
                  var83 = secretPacketBuffer2.readString();
                  secretPacketBuffer2.readString();

                  for(var22 = 0; var22 < ignoreCount; ++var22) {
                     Ignore var57 = ignores[var22];
                     if(var74) {
                        if(var83.equals(var57.name)) {
                           var57.name = var21;
                           var57.previousName = var83;
                           var21 = null;
                           break;
                        }
                     } else if(var21.equals(var57.name)) {
                        var57.name = var21;
                        var57.previousName = var83;
                        var21 = null;
                        break;
                     }
                  }

                  if(var21 != null && ignoreCount < 400) {
                     Ignore var50 = new Ignore();
                     ignores[ignoreCount] = var50;
                     var50.name = var21;
                     var50.previousName = var83;
                     ++ignoreCount;
                  }
               }

               field1119 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?67:139)) {
               field1172 = true;
               class2.field13 = secretPacketBuffer2.readUnsignedByte();
               MouseInput.field748 = secretPacketBuffer2.readUnsignedByte();
               Player.field915 = secretPacketBuffer2.readUnsignedShort();
               XItemContainer.field802 = secretPacketBuffer2.readUnsignedByte();
               class8.field237 = secretPacketBuffer2.readUnsignedByte();
               if(class8.field237 >= 100) {
                  ISAACCipher.cameraX = class2.field13 * 128 + 64;
                  class25.cameraY = MouseInput.field748 * 128 + 64;
                  WorldMapData.cameraZ = class25.getTileHeight(ISAACCipher.cameraX, class25.cameraY, class35.plane) - Player.field915;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?68:87)) {
               field1172 = true;
               class22.field350 = secretPacketBuffer2.readUnsignedByte();
               Timer.field2270 = secretPacketBuffer2.readUnsignedByte();
               class117.field1698 = secretPacketBuffer2.readUnsignedShort();
               class21.field344 = secretPacketBuffer2.readUnsignedByte();
               KeyFocusListener.field657 = secretPacketBuffer2.readUnsignedByte();
               if(KeyFocusListener.field657 >= 100) {
                  var2 = 64 + class22.field350 * 128;
                  var15 = 64 + Timer.field2270 * 128;
                  var4 = class25.getTileHeight(var2, var15, class35.plane) - class117.field1698;
                  var20 = var2 - ISAACCipher.cameraX;
                  var22 = var4 - WorldMapData.cameraZ;
                  var23 = var15 - class25.cameraY;
                  var80 = (int)Math.sqrt((double)(var23 * var23 + var20 * var20));
                  KeyFocusListener.cameraPitch = (int)(Math.atan2((double)var22, (double)var80) * 325.949D) & 2047;
                  class47.cameraYaw = (int)(Math.atan2((double)var20, (double)var23) * -325.949D) & 2047;
                  if(KeyFocusListener.cameraPitch < 128) {
                     KeyFocusListener.cameraPitch = 128;
                  }

                  if(KeyFocusListener.cameraPitch > 383) {
                     KeyFocusListener.cameraPitch = 383;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?69:24)) {
               var16 = secretPacketBuffer2.readString();
               var17 = secretPacketBuffer2.readLong();
               var5 = (long)secretPacketBuffer2.readUnsignedShort();
               var33 = (long)secretPacketBuffer2.read24BitInt();
               Permission[] var28 = new Permission[]{Permission.field3168, Permission.field3169, Permission.field3164, Permission.field3167, Permission.field3166, Permission.field3165};
               Permission var69 = (Permission)PlayerComposition.forOrdinal(var28, secretPacketBuffer2.readUnsignedByte());
               long var35 = var33 + (var5 << 32);
               boolean var13 = false;

               for(int var14 = 0; var14 < 100; ++var14) {
                  if(field1145[var14] == var35) {
                     var13 = true;
                     break;
                  }
               }

               if(var69.field3172 && class27.isIgnored(var16)) {
                  var13 = true;
               }

               if(!var13 && field1136 == 0) {
                  field1145[field1108] = var35;
                  field1108 = (field1108 + 1) % 100;
                  String var37 = FontTypeFace.appendTags(VarPlayerType.method4301(class229.method4091(secretPacketBuffer2)));
                  if(var69.field3170 != -1) {
                     class34.addChatMessage(9, class89.method1717(var69.field3170) + var16, var37, class22.method181(var17));
                  } else {
                     class34.addChatMessage(9, var16, var37, class22.method181(var17));
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?70:241)) {
               field951 = secretPacketBuffer2.readUnsignedByte();
               if(field951 == 1) {
                  field952 = secretPacketBuffer2.readUnsignedShort();
               }

               if(field951 >= 2 && field951 <= 6) {
                  if(field951 == 2) {
                     field1032 = 64;
                     field1161 = 64;
                  }

                  if(field951 == 3) {
                     field1032 = 0;
                     field1161 = 64;
                  }

                  if(field951 == 4) {
                     field1032 = 128;
                     field1161 = 64;
                  }

                  if(field951 == 5) {
                     field1032 = 64;
                     field1161 = 0;
                  }

                  if(field951 == 6) {
                     field1032 = 64;
                     field1161 = 128;
                  }

                  field951 = 2;
                  hintArrowX = secretPacketBuffer2.readUnsignedShort();
                  hintArrowY = secretPacketBuffer2.readUnsignedShort();
                  hintArrowType = secretPacketBuffer2.readUnsignedByte();
               }

               if(field951 == 10) {
                  field953 = secretPacketBuffer2.readUnsignedShort();
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?71:17)) {
               var2 = secretPacketBuffer2.readInt();
               var15 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var15 += '耀';
               }

               if(var2 >= 0) {
                  var77 = class84.method1670(var2);
               } else {
                  var77 = null;
               }

               if(var77 != null) {
                  for(var20 = 0; var20 < var77.itemIds.length; ++var20) {
                     var77.itemIds[var20] = 0;
                     var77.itemQuantities[var20] = 0;
                  }
               }

               VarPlayerType.method4302(var15);
               var20 = secretPacketBuffer2.readUnsignedShort();

               for(var22 = 0; var22 < var20; ++var22) {
                  var23 = secretPacketBuffer2.method3185();
                  if(var23 == 255) {
                     var23 = secretPacketBuffer2.method3219();
                  }

                  var80 = secretPacketBuffer2.method3329();
                  if(var77 != null && var22 < var77.itemIds.length) {
                     var77.itemIds[var22] = var80;
                     var77.itemQuantities[var22] = var23;
                  }

                  class47.setItemTableSlot(var15, var22, var80 - 1, var23);
               }

               if(var77 != null) {
                  class90.method1723(var77);
               }

               CollisionData.method3075();
               interfaceItemTriggers[++field1115 - 1 & 31] = var15 & 32767;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?72:107)) {
               var2 = secretPacketBuffer2.readInt();
               var15 = secretPacketBuffer2.readUnsignedShort();
               if(var2 < -70000) {
                  var15 += '耀';
               }

               if(var2 >= 0) {
                  var77 = class84.method1670(var2);
               } else {
                  var77 = null;
               }

               for(; secretPacketBuffer2.offset < packetLength; class47.setItemTableSlot(var15, var20, var22 - 1, var23)) {
                  var20 = secretPacketBuffer2.getUSmart();
                  var22 = secretPacketBuffer2.readUnsignedShort();
                  var23 = 0;
                  if(var22 != 0) {
                     var23 = secretPacketBuffer2.readUnsignedByte();
                     if(var23 == 255) {
                        var23 = secretPacketBuffer2.readInt();
                     }
                  }

                  if(var77 != null && var20 >= 0 && var20 < var77.itemIds.length) {
                     var77.itemIds[var20] = var22;
                     var77.itemQuantities[var20] = var23;
                  }
               }

               if(var77 != null) {
                  class90.method1723(var77);
               }

               CollisionData.method3075();
               interfaceItemTriggers[++field1115 - 1 & 31] = var15 & 32767;
               packetType = -1;
               return true;
            }

            int var86;
            if(packetType == (RUNELITE_PACKET?73:80)) {
               field973 = cycleCntr;
               if(packetLength == 0) {
                  clanChatOwner = null;
                  clanChatName = null;
                  class82.clanChatCount = 0;
                  class28.clanMembers = null;
                  packetType = -1;
                  return true;
               }

               clanChatName = secretPacketBuffer2.readString();
               long var31 = secretPacketBuffer2.readLong();
               clanChatOwner = class215.method3993(var31);
               MouseInput.field728 = secretPacketBuffer2.readByte();
               var4 = secretPacketBuffer2.readUnsignedByte();
               if(var4 == 255) {
                  packetType = -1;
                  return true;
               }

               class82.clanChatCount = var4;
               XClanMember[] var82 = new XClanMember[100];

               for(var22 = 0; var22 < class82.clanChatCount; ++var22) {
                  var82[var22] = new XClanMember();
                  var82[var22].username = secretPacketBuffer2.readString();
                  var82[var22].field927 = FloorUnderlayDefinition.method4398(var82[var22].username, class22.field354);
                  var82[var22].world = secretPacketBuffer2.readUnsignedShort();
                  var82[var22].rank = secretPacketBuffer2.readByte();
                  secretPacketBuffer2.readString();
                  if(var82[var22].username.equals(XGrandExchangeOffer.localPlayer.name)) {
                     class84.clanChatRank = var82[var22].rank;
                  }
               }

               var79 = false;
               var80 = class82.clanChatCount;

               while(var80 > 0) {
                  var79 = true;
                  --var80;

                  for(var86 = 0; var86 < var80; ++var86) {
                     if(var82[var86].field927.compareTo(var82[var86 + 1].field927) > 0) {
                        XClanMember var55 = var82[var86];
                        var82[var86] = var82[var86 + 1];
                        var82[var86 + 1] = var55;
                        var79 = false;
                     }
                  }

                  if(var79) {
                     break;
                  }
               }

               class28.clanMembers = var82;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?74:165)) {
               var2 = packetLength + secretPacketBuffer2.offset;
               var15 = secretPacketBuffer2.readUnsignedShort();
               var4 = secretPacketBuffer2.readUnsignedShort();
               if(var15 != widgetRoot) {
                  widgetRoot = var15;
                  this.method1437(false);
                  class163.method3086(widgetRoot);
                  class205.method3813(widgetRoot);

                  for(var20 = 0; var20 < 100; ++var20) {
                     field1112[var20] = true;
                  }
               }

               WidgetNode var61;
               for(; var4-- > 0; var61.field841 = true) {
                  var20 = secretPacketBuffer2.readInt();
                  var22 = secretPacketBuffer2.readUnsignedShort();
                  var23 = secretPacketBuffer2.readUnsignedByte();
                  var61 = (WidgetNode)componentTable.get((long)var20);
                  if(var61 != null && var22 != var61.id) {
                     class17.method127(var61, true);
                     var61 = null;
                  }

                  if(var61 == null) {
                     WidgetNode var68 = new WidgetNode();
                     var68.id = var22;
                     var68.owner = var23;
                     componentTable.put(var68, (long)var20);
                     class163.method3086(var22);
                     Widget var84 = class84.method1670(var20);
                     class90.method1723(var84);
                     if(field1090 != null) {
                        class90.method1723(field1090);
                        field1090 = null;
                     }

                     class74.method1183();
                     class51.method812(class176.widgets[var20 >> 16], var84, false);
                     class205.method3813(var22);
                     if(widgetRoot != -1) {
                        Friend.method1140(widgetRoot, 1);
                     }

                     var61 = var68;
                  }
               }

               for(var25 = (WidgetNode)componentTable.method3558(); var25 != null; var25 = (WidgetNode)componentTable.method3559()) {
                  if(var25.field841) {
                     var25.field841 = false;
                  } else {
                     class17.method127(var25, true);
                  }
               }

               widgetFlags = new XHashTable(512);

               while(secretPacketBuffer2.offset < var2) {
                  var20 = secretPacketBuffer2.readInt();
                  var22 = secretPacketBuffer2.readUnsignedShort();
                  var23 = secretPacketBuffer2.readUnsignedShort();
                  var80 = secretPacketBuffer2.readInt();

                  for(var86 = var22; var86 <= var23; ++var86) {
                     long var29 = ((long)var20 << 32) + (long)var86;
                     widgetFlags.put(new IntegerNode(var80), var29);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?76:62)) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var45 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var3 = secretPacketBuffer2.readString();
                  var21 = secretPacketBuffer2.readString();
                  var20 = secretPacketBuffer2.readUnsignedShort();
                  var22 = secretPacketBuffer2.readUnsignedByte();
                  var23 = secretPacketBuffer2.readUnsignedByte();
                  boolean var24 = (var23 & 2) != 0;
                  boolean var27 = (var23 & 1) != 0;
                  if(var20 > 0) {
                     secretPacketBuffer2.readString();
                     secretPacketBuffer2.readUnsignedByte();
                     secretPacketBuffer2.readInt();
                  }

                  secretPacketBuffer2.readString();

                  for(int var38 = 0; var38 < friendCount; ++var38) {
                     Friend var26 = friends[var38];
                     if(!var45) {
                        if(var3.equals(var26.name)) {
                           if(var20 != var26.world) {
                              boolean var12 = true;

                              for(class67 var39 = (class67)field1194.method3634(); var39 != null; var39 = (class67)field1194.method3642()) {
                                 if(var39.field833.equals(var3)) {
                                    if(var20 != 0 && var39.field836 == 0) {
                                       var39.method3644();
                                       var12 = false;
                                    } else if(var20 == 0 && var39.field836 != 0) {
                                       var39.method3644();
                                       var12 = false;
                                    }
                                 }
                              }

                              if(var12) {
                                 field1194.method3636(new class67(var3, var20));
                              }

                              var26.world = var20;
                           }

                           var26.previousName = var21;
                           var26.rank = var22;
                           var26.field818 = var24;
                           var26.field819 = var27;
                           var3 = null;
                           break;
                        }
                     } else if(var21.equals(var26.name)) {
                        var26.name = var3;
                        var26.previousName = var21;
                        var3 = null;
                        break;
                     }
                  }

                  if(var3 != null && friendCount < 400) {
                     Friend var10 = new Friend();
                     friends[friendCount] = var10;
                     var10.name = var3;
                     var10.previousName = var21;
                     var10.world = var20;
                     var10.rank = var22;
                     var10.field818 = var24;
                     var10.field819 = var27;
                     ++friendCount;
                  }
               }

               field1192 = 2;
               field1119 = cycleCntr;
               var45 = false;
               var15 = friendCount;

               while(var15 > 0) {
                  var45 = true;
                  --var15;

                  for(var4 = 0; var4 < var15; ++var4) {
                     var76 = false;
                     Friend var6 = friends[var4];
                     Friend var7 = friends[var4 + 1];
                     if(var6.world != world && var7.world == world) {
                        var76 = true;
                     }

                     if(!var76 && var6.world == 0 && var7.world != 0) {
                        var76 = true;
                     }

                     if(!var76 && !var6.field818 && var7.field818) {
                        var76 = true;
                     }

                     if(!var76 && !var6.field819 && var7.field819) {
                        var76 = true;
                     }

                     if(var76) {
                        Friend var8 = friends[var4];
                        friends[var4] = friends[var4 + 1];
                        friends[var4 + 1] = var8;
                        var45 = false;
                     }
                  }

                  if(var45) {
                     break;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?78:104)) {
               class25.xteaChanged(false);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               class69.method1152(secretPacketBuffer2, var2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?79:127)) {
               class25.xteaChanged(true);
               secretPacketBuffer2.readOpcode();
               var2 = secretPacketBuffer2.readUnsignedShort();
               class69.method1152(secretPacketBuffer2, var2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?80:130)) {
               class88.method1708(true);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?81:8)) {
               class88.method1708(false);
               packetType = -1;
               return true;
            }

            if(packetType == 92 || packetType == 115 || packetType == 73 || packetType == 156 || packetType == 13 || packetType == 79 || packetType == 212 || packetType == 131 || packetType == 113 || packetType == (RUNELITE_PACKET?82:231)) {
               class237.method4222();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?83:198)) {
               TextureProvider.field1788 = secretPacketBuffer2.readUnsignedShortOb1();
               class34.field498 = secretPacketBuffer2.readUnsignedShortOb1();

               while(secretPacketBuffer2.offset < packetLength) {
                  packetType = secretPacketBuffer2.readUnsignedByte();
                  class237.method4222();
               }

               packetType = -1;
               return true;
            }

            Varcs.method1853("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
            class33.method374();
         } catch (IOException var43) {
            if(field987 > 0) {
               class33.method374();
            } else {
               MouseInput.setGameState(40);
               class20.field337 = VertexNormal.rssocket;
               VertexNormal.rssocket = null;
            }
         } catch (Exception var44) {
            var16 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (XGrandExchangeOffer.localPlayer.pathX[0] + class47.baseX) + "," + (XGrandExchangeOffer.localPlayer.pathY[0] + class44.baseY) + ",";

            for(var15 = 0; var15 < packetLength && var15 < 50; ++var15) {
               var16 = var16 + secretPacketBuffer2.payload[var15] + ",";
            }

            Varcs.method1853(var16, var44);
            class33.method374();
         }

         return true;
      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1922355300"
   )
   final void method1226(int var1, int var2) {
      int var3 = class61.field765.method4775("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = class61.field765;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargets[var4].length() > 0) {
            var6 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var6 = menuOptions[var4];
         }

         int var7 = var5.method4775(var6);
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
      if(var4 + var2 > class1.canvasHeight) {
         var9 = class1.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      class36.region.method2739(class35.plane, var1, var2, false);
      isMenuOpen = true;
      menuX = var8;
      Sequence.menuY = var9;
      XGrandExchangeOffer.menuWidth = var3;
      class15.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1954258505"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      class223.method4085();
      class163.method3084();
      class182.method3458();
      class230.method4094();
      class18.method143();
      int var1;
      if(FileRequest.field3197 != null) {
         var1 = FileRequest.field3197.vmethod2993();
         field1124 = var1;
      }

      if(gameState == 0) {
         class24.load();
         GameEngine.timer.vmethod3010();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field700[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field701[var1] = 0L;
         }

         GameEngine.field695 = 0;
      } else if(gameState == 5) {
         World.method1581(this);
         class24.load();
         GameEngine.timer.vmethod3010();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field700[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field701[var1] = 0L;
         }

         GameEngine.field695 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            World.method1581(this);
            this.method1218();
         } else if(gameState == 25) {
            class252.method4469();
         }
      } else {
         World.method1581(this);
      }

      if(gameState == 30) {
         this.method1304();
      } else if(gameState == 40 || gameState == 45) {
         this.method1218();
      }

   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-78"
   )
   void method1216() {
      if(class239.field3255 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class239.field3256 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field1047 = 3000;
            class239.field3256 = 3;
         }

         if(--field1047 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  socket = GameEngine.taskManager.createSocket(class165.host, WidgetNode.myWorldPort);
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
                  class262.rssocket = new RSSocket((Socket)socket.value, GameEngine.taskManager);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(153);
                  class262.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  class22.field352 = class74.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && class262.rssocket.available() <= 0) {
                     if(class74.currentTimeMs() - class22.field352 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var5 = class262.rssocket.readByte();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var10 = class262.rssocket;
                  boolean var2 = gameState > 20;
                  if(class239.field3246 != null) {
                     try {
                        class239.field3246.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class239.field3246 = null;
                  }

                  class239.field3246 = var10;
                  class43.sendConInfo(var2);
                  class239.field3238.offset = 0;
                  class239.currentRequest = null;
                  class40.field555 = null;
                  class239.field3251 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class239.field3241.method3558();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class239.field3253.method3558();
                           if(var3 == null) {
                              if(class239.field3254 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class239.field3254);
                                    var11.putShort(0);
                                    class239.field3246.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class239.field3246.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class239.field3256;
                                    class239.field3246 = null;
                                 }
                              }

                              class239.field3237 = 0;
                              class239.field3252 = class74.currentTimeMs();
                              socket = null;
                              class262.rssocket = null;
                              js5State = 0;
                              field966 = 0;
                              return;
                           }

                           class239.field3243.setHead(var3);
                           class239.field3239.put(var3, var3.hash);
                           ++class239.field3245;
                           --class239.field3247;
                        }
                     }

                     class239.field3250.put(var3, var3.hash);
                     ++class239.field3240;
                     --class239.field3242;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-142634199"
   )
   final void method1222() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(Ignore.loadWidget(var1)) {
            class61.method1116(class176.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1129; ++var1) {
         if(field1112[var1]) {
            field1132[var1] = true;
         }

         field1133[var1] = field1112[var1];
         field1112[var1] = false;
      }

      field1080 = gameCycle;
      field1075 = -1;
      field1076 = -1;
      class277.field3718 = null;
      int var2;
      int var3;
      int var4;
      if(widgetRoot != -1) {
         field1129 = 0;
         var1 = widgetRoot;
         var2 = GameEngine.canvasWidth;
         var3 = class1.canvasHeight;
         if(!Ignore.loadWidget(var1)) {
            for(var4 = 0; var4 < 100; ++var4) {
               field1112[var4] = true;
            }
         } else {
            class20.field338 = null;
            WidgetNode.gameDraw(class176.widgets[var1], -1, 0, 0, var2, var3, 0, 0, -1);
            if(class20.field338 != null) {
               WidgetNode.gameDraw(class20.field338, -1412584499, 0, 0, var2, var3, class66.field830, class47.field608, -1);
               class20.field338 = null;
            }
         }
      }

      Rasterizer2D.noClip();
      if(!isMenuOpen) {
         if(field1075 != -1) {
            var1 = field1075;
            var2 = field1076;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               var3 = menuOptionCount - 1;
               String var5;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var5 = "Use" + " " + field1084 + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var5 = field993 + " " + field1085 + " " + "->";
               } else {
                  String var13;
                  if(var3 < 0) {
                     var13 = "";
                  } else if(menuTargets[var3].length() > 0) {
                     var13 = menuOptions[var3] + " " + menuTargets[var3];
                  } else {
                     var13 = menuOptions[var3];
                  }

                  var5 = var13;
               }

               if(menuOptionCount > 2) {
                  var5 = var5 + Tile.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class61.field765.drawRandomizedMouseoverText(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         XGrandExchangeOffer.method98();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1129; ++var1) {
            if(field1133[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1132[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class35.plane;
      var2 = XGrandExchangeOffer.localPlayer.x;
      var3 = XGrandExchangeOffer.localPlayer.y;
      var4 = field957;

      for(class82 var14 = (class82)class82.field1330.getFront(); var14 != null; var14 = (class82)class82.field1330.getNext()) {
         if(var14.field1326 != -1 || var14.field1316 != null) {
            int var6 = 0;
            if(var2 > var14.field1319) {
               var6 += var2 - var14.field1319;
            } else if(var2 < var14.field1317) {
               var6 += var14.field1317 - var2;
            }

            if(var3 > var14.field1322) {
               var6 += var3 - var14.field1322;
            } else if(var3 < var14.field1327) {
               var6 += var14.field1327 - var3;
            }

            if(var6 - 64 <= var14.field1325 && field1148 != 0 && var1 == var14.field1321) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               int var7 = (var14.field1325 - var6) * field1148 / var14.field1325;
               Object var10000;
               if(var14.field1323 == null) {
                  if(var14.field1326 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.getTrack(field965, var14.field1326, 0);
                     if(var8 != null) {
                        class108 var9 = var8.method1961().method2005(class11.field262);
                        class118 var10 = class118.method2232(var9, 100, var7);
                        var10.method2184(-1);
                        class56.field679.method1894(var10);
                        var14.field1323 = var10;
                     }
                  }
               } else {
                  var14.field1323.method2146(var7);
               }

               if(var14.field1328 == null) {
                  if(var14.field1316 != null && (var14.field1315 -= var4) <= 0) {
                     int var12 = (int)(Math.random() * (double)var14.field1316.length);
                     var10000 = null;
                     SoundEffect var15 = SoundEffect.getTrack(field965, var14.field1316[var12], 0);
                     if(var15 != null) {
                        class108 var16 = var15.method1961().method2005(class11.field262);
                        class118 var11 = class118.method2232(var16, 100, var7);
                        var11.method2184(0);
                        class56.field679.method1894(var11);
                        var14.field1328 = var11;
                        var14.field1315 = var14.field1324 + (int)(Math.random() * (double)(var14.field1331 - var14.field1324));
                     }
                  }
               } else {
                  var14.field1328.method2146(var7);
                  if(!var14.field1328.linked()) {
                     var14.field1328 = null;
                  }
               }
            } else {
               if(var14.field1323 != null) {
                  class56.field679.method1923(var14.field1323);
                  var14.field1323 = null;
               }

               if(var14.field1328 != null) {
                  class56.field679.method1923(var14.field1328);
                  var14.field1328 = null;
               }
            }
         }
      }

      field957 = 0;
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-293994632"
   )
   final void method1304() {
      if(field950 > 1) {
         --field950;
      }

      if(field987 > 0) {
         --field987;
      }

      if(socketError) {
         socketError = false;
         if(field987 > 0) {
            class33.method374();
         } else {
            MouseInput.setGameState(40);
            class20.field337 = VertexNormal.rssocket;
            VertexNormal.rssocket = null;
         }

      } else {
         if(!isMenuOpen) {
            class37.method519();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.processServerPacket(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(class206.method3818()) {
               secretPacketBuffer1.putOpcode(35);
               secretPacketBuffer1.putByte(0);
               var1 = secretPacketBuffer1.offset;
               class44.encodeClassVerifier(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
            }

            Object var14 = class84.field1357.field875;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(class84.field1357.field875) {
               if(!field1060) {
                  class84.field1357.field876 = 0;
               } else if(MouseInput.field740 != 0 || class84.field1357.field876 >= 40) {
                  secretPacketBuffer1.putOpcode(252);
                  secretPacketBuffer1.putByte(0);
                  var2 = secretPacketBuffer1.offset;
                  var3 = 0;

                  for(var4 = 0; var4 < class84.field1357.field876 && secretPacketBuffer1.offset - var2 < 240; ++var4) {
                     ++var3;
                     var5 = class84.field1357.field874[var4];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 502) {
                        var5 = 502;
                     }

                     var6 = class84.field1357.field878[var4];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 764) {
                        var6 = 764;
                     }

                     var7 = var6 + var5 * 765;
                     if(class84.field1357.field874[var4] == -1 && class84.field1357.field878[var4] == -1) {
                        var6 = -1;
                        var5 = -1;
                        var7 = 524287;
                     }

                     if(var6 == field945 && var5 == field1029) {
                        if(field947 < 2047) {
                           ++field947;
                        }
                     } else {
                        var8 = var6 - field945;
                        field945 = var6;
                        var9 = var5 - field1029;
                        field1029 = var5;
                        if(field947 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                           var8 += 32;
                           var9 += 32;
                           secretPacketBuffer1.putShort(var9 + (field947 << 12) + (var8 << 6));
                           field947 = 0;
                        } else if(field947 < 8) {
                           secretPacketBuffer1.put24bitInt((field947 << 19) + var7 + 8388608);
                           field947 = 0;
                        } else {
                           secretPacketBuffer1.putInt((field947 << 19) + var7 + -1073741824);
                           field947 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var2);
                  if(var3 >= class84.field1357.field876) {
                     class84.field1357.field876 = 0;
                  } else {
                     class84.field1357.field876 -= var3;

                     for(var4 = 0; var4 < class84.field1357.field876; ++var4) {
                        class84.field1357.field878[var4] = class84.field1357.field878[var3 + var4];
                        class84.field1357.field874[var4] = class84.field1357.field874[var4 + var3];
                     }
                  }
               }
            }

            if(MouseInput.field740 == 1 || !XGrandExchangeOffer.field302 && MouseInput.field740 == 4 || MouseInput.field740 == 2) {
               long var15 = (MouseInput.field736 - field944) / 50L;
               if(var15 > 4095L) {
                  var15 = 4095L;
               }

               field944 = MouseInput.field736;
               var3 = MouseInput.field742;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class1.canvasHeight) {
                  var3 = class1.canvasHeight;
               }

               var4 = MouseInput.field741;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > GameEngine.canvasWidth) {
                  var4 = GameEngine.canvasWidth;
               }

               var5 = (int)var15;
               secretPacketBuffer1.putOpcode(65);
               secretPacketBuffer1.putShort((var5 << 1) + (MouseInput.field740 == 2?1:0));
               secretPacketBuffer1.putShort(var4);
               secretPacketBuffer1.putShort(var3);
            }

            if(KeyFocusListener.field649 > 0) {
               secretPacketBuffer1.putOpcode(118);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               long var17 = class74.currentTimeMs();

               for(var4 = 0; var4 < KeyFocusListener.field649; ++var4) {
                  long var19 = var17 - field1150;
                  if(var19 > 16777215L) {
                     var19 = 16777215L;
                  }

                  field1150 = var17;
                  secretPacketBuffer1.put24bitInt((int)var19);
                  secretPacketBuffer1.putByte(KeyFocusListener.field637[var4]);
               }

               secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
            }

            if(field1015 > 0) {
               --field1015;
            }

            if(KeyFocusListener.field642[96] || KeyFocusListener.field642[97] || KeyFocusListener.field642[98] || KeyFocusListener.field642[99]) {
               field1016 = true;
            }

            if(field1016 && field1015 <= 0) {
               field1015 = 20;
               field1016 = false;
               secretPacketBuffer1.putOpcode(21);
               secretPacketBuffer1.method3312(field1068);
               secretPacketBuffer1.putShortLE(mapAngle);
            }

            if(Area.field3297 && !field1050) {
               field1050 = true;
               secretPacketBuffer1.putOpcode(85);
               secretPacketBuffer1.putByte(1);
            }

            if(!Area.field3297 && field1050) {
               field1050 = false;
               secretPacketBuffer1.putOpcode(85);
               secretPacketBuffer1.putByte(0);
            }

            class61.method1115();
            if(gameState == 30) {
               for(PendingSpawn var30 = (PendingSpawn)pendingSpawns.getFront(); var30 != null; var30 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var30.hitpoints > 0) {
                     --var30.hitpoints;
                  }

                  if(var30.hitpoints == 0) {
                     if(var30.field1209 < 0 || MessageNode.method1177(var30.field1209, var30.field1206)) {
                        class64.method1137(var30.level, var30.type, var30.x, var30.y, var30.field1209, var30.field1210, var30.field1206);
                        var30.unlink();
                     }
                  } else {
                     if(var30.delay > 0) {
                        --var30.delay;
                     }

                     if(var30.delay == 0 && var30.x >= 1 && var30.y >= 1 && var30.x <= 102 && var30.y <= 102 && (var30.id < 0 || MessageNode.method1177(var30.id, var30.field1214))) {
                        class64.method1137(var30.level, var30.type, var30.x, var30.y, var30.id, var30.orientation, var30.field1214);
                        var30.delay = -1;
                        if(var30.id == var30.field1209 && var30.field1209 == -1) {
                           var30.unlink();
                        } else if(var30.id == var30.field1209 && var30.field1210 == var30.orientation && var30.field1206 == var30.field1214) {
                           var30.unlink();
                        }
                     }
                  }
               }

               MilliTimer.method2939();
               ++field982;
               if(field982 > 750) {
                  if(field987 > 0) {
                     class33.method374();
                  } else {
                     MouseInput.setGameState(40);
                     class20.field337 = VertexNormal.rssocket;
                     VertexNormal.rssocket = null;
                  }

               } else {
                  var1 = class97.field1510;
                  int[] var21 = class97.field1511;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var22 = cachedPlayers[var21[var3]];
                     if(var22 != null) {
                        class268.method4890(var22, 1);
                     }
                  }

                  class21.method167();
                  int[] var31 = class97.field1511;

                  for(var2 = 0; var2 < class97.field1510; ++var2) {
                     Player var23 = cachedPlayers[var31[var2]];
                     if(var23 != null && var23.field1274 > 0) {
                        --var23.field1274;
                        if(var23.field1274 == 0) {
                           var23.overhead = null;
                        }
                     }
                  }

                  for(var2 = 0; var2 < field958; ++var2) {
                     var3 = npcIndices[var2];
                     NPC var34 = cachedNPCs[var3];
                     if(var34 != null && var34.field1274 > 0) {
                        --var34.field1274;
                        if(var34.field1274 == 0) {
                           var34.overhead = null;
                        }
                     }
                  }

                  ++field957;
                  if(cursorState != 0) {
                     field940 += 20;
                     if(field940 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class72.field879 != null) {
                     ++field1036;
                     if(field1036 >= 15) {
                        class90.method1723(class72.field879);
                        class72.field879 = null;
                     }
                  }

                  Widget var32 = class2.field12;
                  Widget var33 = class23.field359;
                  class2.field12 = null;
                  class23.field359 = null;
                  field1185 = null;
                  field1099 = false;
                  field1104 = false;
                  field1147 = 0;

                  while(XClanMember.method1207() && field1147 < 128) {
                     if(rights >= 2 && KeyFocusListener.field642[82] && class48.field625 == 66) {
                        String var35 = "";

                        MessageNode var25;
                        for(Iterator var24 = class99.field1530.iterator(); var24.hasNext(); var35 = var35 + var25.name + ':' + var25.value + '\n') {
                           var25 = (MessageNode)var24.next();
                        }

                        class27.clientInstance.method892(var35);
                     } else {
                        field960[field1147] = class48.field625;
                        field1011[field1147] = class221.field2807;
                        ++field1147;
                     }
                  }

                  if(widgetRoot != -1) {
                     AbstractByteBuffer.method3407(widgetRoot, 0, 0, GameEngine.canvasWidth, class1.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     ScriptEvent var36;
                     Widget var37;
                     Widget var38;
                     do {
                        var36 = (ScriptEvent)field1044.popFront();
                        if(var36 == null) {
                           while(true) {
                              do {
                                 var36 = (ScriptEvent)field1127.popFront();
                                 if(var36 == null) {
                                    while(true) {
                                       do {
                                          var36 = (ScriptEvent)field964.popFront();
                                          if(var36 == null) {
                                             this.method1224();
                                             FrameMap.method2700();
                                             if(field1107 != null) {
                                                this.method1229();
                                             }

                                             if(class25.field373 != null) {
                                                class90.method1723(class25.field373);
                                                ++field1043;
                                                if(MouseInput.field733 == 0) {
                                                   if(field1042) {
                                                      if(class25.field373 == class277.field3718 && field1092 != field1146) {
                                                         Widget var39 = class25.field373;
                                                         byte var29 = 0;
                                                         if(field1089 == 1 && var39.contentType == 206) {
                                                            var29 = 1;
                                                         }

                                                         if(var39.itemIds[field1146] <= 0) {
                                                            var29 = 0;
                                                         }

                                                         if(class56.method867(class262.getWidgetConfig(var39))) {
                                                            var5 = field1092;
                                                            var6 = field1146;
                                                            var39.itemIds[var6] = var39.itemIds[var5];
                                                            var39.itemQuantities[var6] = var39.itemQuantities[var5];
                                                            var39.itemIds[var5] = -1;
                                                            var39.itemQuantities[var5] = 0;
                                                         } else if(var29 == 1) {
                                                            var5 = field1092;
                                                            var6 = field1146;

                                                            while(var6 != var5) {
                                                               if(var5 > var6) {
                                                                  var39.method4008(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var39.method4008(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var39.method4008(field1146, field1092);
                                                         }

                                                         secretPacketBuffer1.putOpcode(241);
                                                         secretPacketBuffer1.method3215(class25.field373.id);
                                                         secretPacketBuffer1.method3200(var29);
                                                         secretPacketBuffer1.putShortLE(field1092);
                                                         secretPacketBuffer1.putShort(field1146);
                                                      }
                                                   } else if(this.method1365()) {
                                                      this.method1226(field975, field1073);
                                                   } else if(menuOptionCount > 0) {
                                                      var3 = field975;
                                                      var4 = field1073;
                                                      class90 var40 = class17.field318;
                                                      class262.menuAction(var40.field1408, var40.field1406, var40.field1407, var40.field1409, var40.field1411, var40.field1411, var3, var4);
                                                      class17.field318 = null;
                                                   }

                                                   field1036 = 10;
                                                   MouseInput.field740 = 0;
                                                   class25.field373 = null;
                                                } else if(field1043 >= 5 && (MouseInput.field734 > field975 + 5 || MouseInput.field734 < field975 - 5 || MouseInput.field735 > field1073 + 5 || MouseInput.field735 < field1073 - 5)) {
                                                   field1042 = true;
                                                }
                                             }

                                             if(Region.method2741()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(195);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?(KeyFocusListener.field642[81]?2:1):0);
                                                secretPacketBuffer1.method3208(var3 + class47.baseX);
                                                secretPacketBuffer1.putShort(var4 + class44.baseY);
                                                Region.method2742();
                                                field1141 = MouseInput.field741;
                                                field1033 = MouseInput.field742;
                                                cursorState = 1;
                                                field940 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var32 != class2.field12) {
                                                if(var32 != null) {
                                                   class90.method1723(var32);
                                                }

                                                if(class2.field12 != null) {
                                                   class90.method1723(class2.field12);
                                                }
                                             }

                                             if(var33 != class23.field359 && field1077 == field1061) {
                                                if(var33 != null) {
                                                   class90.method1723(var33);
                                                }

                                                if(class23.field359 != null) {
                                                   class90.method1723(class23.field359);
                                                }
                                             }

                                             if(class23.field359 != null) {
                                                if(field1077 < field1061) {
                                                   ++field1077;
                                                   if(field1061 == field1077) {
                                                      class90.method1723(class23.field359);
                                                   }
                                                }
                                             } else if(field1077 > 0) {
                                                --field1077;
                                             }

                                             var3 = XGrandExchangeOffer.localPlayer.x;
                                             var4 = XGrandExchangeOffer.localPlayer.y;
                                             if(class36.field513 - var3 < -500 || class36.field513 - var3 > 500 || WorldMapData.field472 - var4 < -500 || WorldMapData.field472 - var4 > 500) {
                                                class36.field513 = var3;
                                                WorldMapData.field472 = var4;
                                             }

                                             if(var3 != class36.field513) {
                                                class36.field513 += (var3 - class36.field513) / 16;
                                             }

                                             if(var4 != WorldMapData.field472) {
                                                WorldMapData.field472 += (var4 - WorldMapData.field472) / 16;
                                             }

                                             if(MouseInput.field733 == 4 && XGrandExchangeOffer.field302) {
                                                var5 = MouseInput.field735 - field1013;
                                                field1014 = var5 * 2;
                                                field1013 = var5 != -1 && var5 != 1?(MouseInput.field735 + field1013) / 2:MouseInput.field735;
                                                var6 = field1012 - MouseInput.field734;
                                                field1030 = var6 * 2;
                                                field1012 = var6 != -1 && var6 != 1?(MouseInput.field734 + field1012) / 2:MouseInput.field734;
                                             } else {
                                                if(KeyFocusListener.field642[96]) {
                                                   field1030 += (-24 - field1030) / 2;
                                                } else if(KeyFocusListener.field642[97]) {
                                                   field1030 += (24 - field1030) / 2;
                                                } else {
                                                   field1030 /= 2;
                                                }

                                                if(KeyFocusListener.field642[98]) {
                                                   field1014 += (12 - field1014) / 2;
                                                } else if(KeyFocusListener.field642[99]) {
                                                   field1014 += (-12 - field1014) / 2;
                                                } else {
                                                   field1014 /= 2;
                                                }

                                                field1013 = MouseInput.field735;
                                                field1012 = MouseInput.field734;
                                             }

                                             mapAngle = field1030 / 2 + mapAngle & 2047;
                                             field1068 += field1014 / 2;
                                             if(field1068 < 128) {
                                                field1068 = 128;
                                             }

                                             if(field1068 > 383) {
                                                field1068 = 383;
                                             }

                                             var5 = class36.field513 >> 7;
                                             var6 = WorldMapData.field472 >> 7;
                                             var7 = class25.getTileHeight(class36.field513, WorldMapData.field472, class35.plane);
                                             var8 = 0;
                                             int var10;
                                             int var11;
                                             int var12;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      var11 = class35.plane;
                                                      if(var11 < 3 && (class61.tileSettings[1][var9][var10] & 2) == 2) {
                                                         ++var11;
                                                      }

                                                      var12 = var7 - class61.tileHeights[var11][var9][var10];
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

                                             if(var9 < '耀') {
                                                var9 = '耀';
                                             }

                                             if(var9 > field1017) {
                                                field1017 += (var9 - field1017) / 24;
                                             } else if(var9 < field1017) {
                                                field1017 += (var9 - field1017) / 80;
                                             }

                                             if(field1172) {
                                                var3 = class2.field13 * 128 + 64;
                                                var4 = MouseInput.field748 * 128 + 64;
                                                var5 = class25.getTileHeight(var3, var4, class35.plane) - Player.field915;
                                                if(ISAACCipher.cameraX < var3) {
                                                   ISAACCipher.cameraX += XItemContainer.field802 + (var3 - ISAACCipher.cameraX) * class8.field237 / 1000;
                                                   if(ISAACCipher.cameraX > var3) {
                                                      ISAACCipher.cameraX = var3;
                                                   }
                                                }

                                                if(ISAACCipher.cameraX > var3) {
                                                   ISAACCipher.cameraX -= class8.field237 * (ISAACCipher.cameraX - var3) / 1000 + XItemContainer.field802;
                                                   if(ISAACCipher.cameraX < var3) {
                                                      ISAACCipher.cameraX = var3;
                                                   }
                                                }

                                                if(WorldMapData.cameraZ < var5) {
                                                   WorldMapData.cameraZ += (var5 - WorldMapData.cameraZ) * class8.field237 / 1000 + XItemContainer.field802;
                                                   if(WorldMapData.cameraZ > var5) {
                                                      WorldMapData.cameraZ = var5;
                                                   }
                                                }

                                                if(WorldMapData.cameraZ > var5) {
                                                   WorldMapData.cameraZ -= class8.field237 * (WorldMapData.cameraZ - var5) / 1000 + XItemContainer.field802;
                                                   if(WorldMapData.cameraZ < var5) {
                                                      WorldMapData.cameraZ = var5;
                                                   }
                                                }

                                                if(class25.cameraY < var4) {
                                                   class25.cameraY += (var4 - class25.cameraY) * class8.field237 / 1000 + XItemContainer.field802;
                                                   if(class25.cameraY > var4) {
                                                      class25.cameraY = var4;
                                                   }
                                                }

                                                if(class25.cameraY > var4) {
                                                   class25.cameraY -= class8.field237 * (class25.cameraY - var4) / 1000 + XItemContainer.field802;
                                                   if(class25.cameraY < var4) {
                                                      class25.cameraY = var4;
                                                   }
                                                }

                                                var3 = class22.field350 * 128 + 64;
                                                var4 = Timer.field2270 * 128 + 64;
                                                var5 = class25.getTileHeight(var3, var4, class35.plane) - class117.field1698;
                                                var6 = var3 - ISAACCipher.cameraX;
                                                var7 = var5 - WorldMapData.cameraZ;
                                                var8 = var4 - class25.cameraY;
                                                var9 = (int)Math.sqrt((double)(var8 * var8 + var6 * var6));
                                                var10 = (int)(Math.atan2((double)var7, (double)var9) * 325.949D) & 2047;
                                                var11 = (int)(Math.atan2((double)var6, (double)var8) * -325.949D) & 2047;
                                                if(var10 < 128) {
                                                   var10 = 128;
                                                }

                                                if(var10 > 383) {
                                                   var10 = 383;
                                                }

                                                if(KeyFocusListener.cameraPitch < var10) {
                                                   KeyFocusListener.cameraPitch = (var10 - KeyFocusListener.cameraPitch) * KeyFocusListener.field657 / 1000 + KeyFocusListener.cameraPitch + class21.field344;
                                                   if(KeyFocusListener.cameraPitch > var10) {
                                                      KeyFocusListener.cameraPitch = var10;
                                                   }
                                                }

                                                if(KeyFocusListener.cameraPitch > var10) {
                                                   KeyFocusListener.cameraPitch -= KeyFocusListener.field657 * (KeyFocusListener.cameraPitch - var10) / 1000 + class21.field344;
                                                   if(KeyFocusListener.cameraPitch < var10) {
                                                      KeyFocusListener.cameraPitch = var10;
                                                   }
                                                }

                                                var12 = var11 - class47.cameraYaw;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 > 0) {
                                                   class47.cameraYaw += class21.field344 + var12 * KeyFocusListener.field657 / 1000;
                                                   class47.cameraYaw &= 2047;
                                                }

                                                if(var12 < 0) {
                                                   class47.cameraYaw -= class21.field344 + -var12 * KeyFocusListener.field657 / 1000;
                                                   class47.cameraYaw &= 2047;
                                                }

                                                int var13 = var11 - class47.cameraYaw;
                                                if(var13 > 1024) {
                                                   var13 -= 2048;
                                                }

                                                if(var13 < -1024) {
                                                   var13 += 2048;
                                                }

                                                if(var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
                                                   class47.cameraYaw = var11;
                                                }
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1177[var3];
                                             }

                                             class156.chatMessages.process();
                                             var3 = class218.method4051();
                                             var4 = KeyFocusListener.keyboardIdleTicks;
                                             if(var3 > 15000 && var4 > 15000) {
                                                field987 = 250;
                                                MouseInput.mouseIdleTicks = 14500;
                                                secretPacketBuffer1.putOpcode(250);
                                             }

                                             for(class67 var41 = (class67)field1194.method3634(); var41 != null; var41 = (class67)field1194.method3642()) {
                                                if((long)var41.field835 < class74.currentTimeMs() / 1000L - 5L) {
                                                   if(var41.field836 > 0) {
                                                      NPC.sendGameMessage(5, "", var41.field833 + " has logged in.");
                                                   }

                                                   if(var41.field836 == 0) {
                                                      NPC.sendGameMessage(5, "", var41.field833 + " has logged out.");
                                                   }

                                                   var41.method3644();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(143);
                                             }

                                             try {
                                                if(VertexNormal.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   VertexNormal.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var27) {
                                                if(field987 > 0) {
                                                   class33.method374();
                                                } else {
                                                   MouseInput.setGameState(40);
                                                   class20.field337 = VertexNormal.rssocket;
                                                   VertexNormal.rssocket = null;
                                                }
                                             }

                                             return;
                                          }

                                          var37 = var36.widget;
                                          if(var37.index < 0) {
                                             break;
                                          }

                                          var38 = class84.method1670(var37.parentId);
                                       } while(var38 == null || var38.children == null || var37.index >= var38.children.length || var37 != var38.children[var37.index]);

                                       Coordinates.method3942(var36);
                                    }
                                 }

                                 var37 = var36.widget;
                                 if(var37.index < 0) {
                                    break;
                                 }

                                 var38 = class84.method1670(var37.parentId);
                              } while(var38 == null || var38.children == null || var37.index >= var38.children.length || var37 != var38.children[var37.index]);

                              Coordinates.method3942(var36);
                           }
                        }

                        var37 = var36.widget;
                        if(var37.index < 0) {
                           break;
                        }

                        var38 = class84.method1670(var37.parentId);
                     } while(var38 == null || var38.children == null || var37.index >= var38.children.length || var37 != var38.children[var37.index]);

                     Coordinates.method3942(var36);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-27578"
   )
   final void method1218() {
      try {
         if(loginState == 0) {
            if(VertexNormal.rssocket != null) {
               VertexNormal.rssocket.close();
               VertexNormal.rssocket = null;
            }

            WallObject.field2130 = null;
            socketError = false;
            field968 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(WallObject.field2130 == null) {
               WallObject.field2130 = GameEngine.taskManager.createSocket(class165.host, WidgetNode.myWorldPort);
            }

            if(WallObject.field2130.status == 2) {
               throw new IOException();
            }

            if(WallObject.field2130.status == 1) {
               VertexNormal.rssocket = new RSSocket((Socket)WallObject.field2130.value, GameEngine.taskManager);
               WallObject.field2130 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            VertexNormal.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(class84.soundSystem0 != null) {
               class84.soundSystem0.method2032();
            }

            if(WorldMapType1.soundSystem1 != null) {
               WorldMapType1.soundSystem1.method2032();
            }

            var1 = VertexNormal.rssocket.readByte();
            if(class84.soundSystem0 != null) {
               class84.soundSystem0.method2032();
            }

            if(WorldMapType1.soundSystem1 != null) {
               WorldMapType1.soundSystem1.method2032();
            }

            if(var1 != 0) {
               class19.method156(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = VertexNormal.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  VertexNormal.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class21.field345 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class21.field345 >> 32), (int)(class21.field345 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class93.field1443.rsOrdinal());
            secretPacketBuffer1.putInt(var7[0]);
            secretPacketBuffer1.putInt(var7[1]);
            secretPacketBuffer1.putInt(var7[2]);
            secretPacketBuffer1.putInt(var7[3]);
            switch(class93.field1443.field2200) {
            case 0:
            case 3:
               secretPacketBuffer1.put24bitInt(ClassInfo.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 1:
               secretPacketBuffer1.putInt(((Integer)class3.preferences.preferences.get(Integer.valueOf(FaceNormal.method2897(class93.username)))).intValue());
               secretPacketBuffer1.offset += 4;
               break;
            case 2:
               secretPacketBuffer1.offset += 8;
            }

            secretPacketBuffer1.putString(class93.password);
            secretPacketBuffer1.encryptRsa(class91.rsaKeyExponent, class91.rsaKeyModulus);
            field978.offset = 0;
            if(gameState == 40) {
               field978.putByte(18);
            } else {
               field978.putByte(16);
            }

            field978.putShort(0);
            var2 = field978.offset;
            field978.putInt(153);
            field978.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field978.offset;
            field978.putString(class93.username);
            field978.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            field978.putShort(GameEngine.canvasWidth);
            field978.putShort(class1.canvasHeight);
            PacketBuffer var4 = field978;
            if(field971 != null) {
               var4.putBytes(field971, 0, field971.length);
            } else {
               byte[] var5 = class163.method3085();
               var4.putBytes(var5, 0, var5.length);
            }

            field978.putString(sessionToken);
            field978.putInt(class96.field1501);
            Buffer var15 = new Buffer(ChatLineBuffer.field1564.method5421());
            ChatLineBuffer.field1564.method5419(var15);
            field978.putBytes(var15.payload, 0, var15.payload.length);
            field978.putByte(Friend.field821);
            field978.putInt(0);
            field978.putInt(class33.indexInterfaces.crc);
            field978.putInt(ScriptState.indexSoundEffects.crc);
            field978.putInt(class28.configsIndex.crc);
            field978.putInt(class83.field1337.crc);
            field978.putInt(field965.crc);
            field978.putInt(class14.indexMaps.crc);
            field978.putInt(class253.indexTrack1.crc);
            field978.putInt(class47.indexModels.crc);
            field978.putInt(class176.indexSprites.crc);
            field978.putInt(Tile.indexTextures.crc);
            field978.putInt(MouseInput.field744.crc);
            field978.putInt(DState.indexTrack2.crc);
            field978.putInt(FrameMap.indexScripts.crc);
            field978.putInt(class262.field3617.crc);
            field978.putInt(Enum.vorbisIndex.crc);
            field978.putInt(class212.field2606.crc);
            field978.putInt(VertexNormal.indexWorldMap.crc);
            field978.encryptXtea(var7, var3, field978.offset);
            field978.putShortLength(field978.offset - var2);
            VertexNormal.rssocket.queueForWrite(field978.payload, 0, field978.offset);
            secretPacketBuffer1.seed(var7);

            for(int var6 = 0; var6 < 4; ++var6) {
               var7[var6] += 50;
            }

            secretPacketBuffer2.seed(var7);
            loginState = 6;
         }

         if(loginState == 6 && VertexNormal.rssocket.available() > 0) {
            var1 = VertexNormal.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field969 < 1) {
               ++field969;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class19.method156(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && VertexNormal.rssocket.available() > 0) {
            field1031 = (VertexNormal.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field968 = 0;
            class69.method1159("You have only just left another world.", "Your profile will be transferred in:", field1031 / 60 + " seconds.");
            if(--field1031 <= 0) {
               loginState = 0;
            }

         } else {
            boolean var12;
            if(loginState == 9 && VertexNormal.rssocket.available() >= 13) {
               boolean var13 = VertexNormal.rssocket.readByte() == 1;
               VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               var12 = false;
               if(var13) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = FaceNormal.method2897(class93.username);
                  if(class3.preferences.preferences.size() >= 10 && !class3.preferences.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var14 = class3.preferences.preferences.entrySet().iterator();
                     var14.next();
                     var14.remove();
                  }

                  class3.preferences.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  class33.method372();
               }

               rights = VertexNormal.rssocket.readByte();
               field1158 = VertexNormal.rssocket.readByte() == 1;
               localInteractingIndex = VertexNormal.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += VertexNormal.rssocket.readByte();
               field1120 = VertexNormal.rssocket.readByte();
               VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  class52.method814(class27.clientInstance, "zap");
               } catch (Throwable var10) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(VertexNormal.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  field944 = -1L;
                  field947 = -1;
                  class84.field1357.field876 = 0;
                  Area.field3297 = true;
                  field1050 = true;
                  field1150 = -1L;
                  class281.field3740 = new CombatInfoList();
                  secretPacketBuffer1.offset = 0;
                  secretPacketBuffer2.offset = 0;
                  packetType = -1;
                  lastFrameId = -1;
                  secondLastFrameId = -1;
                  thridLastFrameId = -1;
                  field982 = 0;
                  field950 = 0;
                  field987 = 0;
                  field951 = 0;
                  menuOptionCount = 0;
                  isMenuOpen = false;
                  MouseInput.mouseIdleTicks = 0;
                  class99.chatLineMap.clear();
                  class99.field1530.clear();
                  class99.field1531.method3662();
                  class99.field1534 = 0;
                  itemSelectionState = 0;
                  spellSelected = false;
                  field1166 = 0;
                  mapAngle = 0;
                  field1160 = 0;
                  field1153 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  field959 = class92.field1424;
                  field1117 = class92.field1424;
                  field958 = 0;
                  class36.method508();

                  for(var1 = 0; var1 < 2048; ++var1) {
                     cachedPlayers[var1] = null;
                  }

                  for(var1 = 0; var1 < '耀'; ++var1) {
                     cachedNPCs[var1] = null;
                  }

                  field1054 = -1;
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
                  field1192 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var1 = 0; var1 < class171.field2344; ++var1) {
                     VarPlayerType var18 = class169.method3137(var1);
                     if(var18 != null) {
                        class212.settings[var1] = 0;
                        class212.widgetSettings[var1] = 0;
                     }
                  }

                  class156.chatMessages.reset();
                  field1094 = -1;
                  if(widgetRoot != -1) {
                     var1 = widgetRoot;
                     if(var1 != -1 && BaseVarType.validInterfaces[var1]) {
                        SoundTask.widgetIndex.method4126(var1);
                        if(class176.widgets[var1] != null) {
                           var12 = true;

                           for(var3 = 0; var3 < class176.widgets[var1].length; ++var3) {
                              if(class176.widgets[var1][var3] != null) {
                                 if(class176.widgets[var1][var3].type != 2) {
                                    class176.widgets[var1][var3] = null;
                                 } else {
                                    var12 = false;
                                 }
                              }
                           }

                           if(var12) {
                              class176.widgets[var1] = null;
                           }

                           BaseVarType.validInterfaces[var1] = false;
                        }
                     }
                  }

                  for(WidgetNode var17 = (WidgetNode)componentTable.method3558(); var17 != null; var17 = (WidgetNode)componentTable.method3559()) {
                     class17.method127(var17, true);
                  }

                  widgetRoot = -1;
                  componentTable = new XHashTable(8);
                  field1090 = null;
                  menuOptionCount = 0;
                  isMenuOpen = false;
                  field1008.method3990((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var1 = 0; var1 < 8; ++var1) {
                     playerOptions[var1] = null;
                     playerOptionsPriorities[var1] = false;
                  }

                  BuildType.method4101();
                  field942 = true;

                  for(var1 = 0; var1 < 100; ++var1) {
                     field1112[var1] = true;
                  }

                  class88.method1705();
                  clanChatOwner = null;
                  class82.clanChatCount = 0;
                  class28.clanMembers = null;

                  for(var1 = 0; var1 < 8; ++var1) {
                     grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  }

                  class61.field779 = null;
                  TextureProvider.initializeGPI(secretPacketBuffer2);
                  class13.field278 = -1;
                  class25.xteaChanged(false);
                  packetType = -1;
               }

            } else {
               if(loginState == 11 && VertexNormal.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class37.field522 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && VertexNormal.rssocket.available() >= class37.field522) {
                  secretPacketBuffer2.offset = 0;
                  VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, class37.field522);
                  secretPacketBuffer2.offset = 0;
                  String var16 = secretPacketBuffer2.readString();
                  String var8 = secretPacketBuffer2.readString();
                  String var9 = secretPacketBuffer2.readString();
                  class69.method1159(var16, var8, var9);
                  MouseInput.setGameState(10);
               }

               if(loginState != 13) {
                  ++field968;
                  if(field968 > 2000) {
                     if(field969 < 1) {
                        if(class281.field3741 == WidgetNode.myWorldPort) {
                           WidgetNode.myWorldPort = class25.field377;
                        } else {
                           WidgetNode.myWorldPort = class281.field3741;
                        }

                        ++field969;
                        loginState = 0;
                     } else {
                        class19.method156(-3);
                     }
                  }
               } else {
                  if(packetLength == -1) {
                     if(VertexNormal.rssocket.available() < 2) {
                        return;
                     }

                     VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(VertexNormal.rssocket.available() >= packetLength) {
                     VertexNormal.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     secretPacketBuffer1.offset = 0;
                     secretPacketBuffer2.offset = 0;
                     packetType = -1;
                     lastFrameId = -1;
                     secondLastFrameId = -1;
                     thridLastFrameId = -1;
                     packetLength = 0;
                     field982 = 0;
                     field950 = 0;
                     menuOptionCount = 0;
                     isMenuOpen = false;
                     field1160 = 0;
                     destinationX = 0;

                     for(var2 = 0; var2 < 2048; ++var2) {
                        cachedPlayers[var2] = null;
                     }

                     XGrandExchangeOffer.localPlayer = null;

                     for(var2 = 0; var2 < cachedNPCs.length; ++var2) {
                        NPC var19 = cachedNPCs[var2];
                        if(var19 != null) {
                           var19.interacting = -1;
                           var19.field1245 = false;
                        }
                     }

                     BuildType.method4101();
                     MouseInput.setGameState(30);

                     for(var2 = 0; var2 < 100; ++var2) {
                        field1112[var2] = true;
                     }

                     class88.method1705();
                     TextureProvider.initializeGPI(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var11) {
         if(field969 < 1) {
            if(class281.field3741 == WidgetNode.myWorldPort) {
               WidgetNode.myWorldPort = class25.field377;
            } else {
               WidgetNode.myWorldPort = class281.field3741;
            }

            ++field969;
            loginState = 0;
         } else {
            class19.method156(-2);
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   protected final void vmethod1211() {
      field1139 = class74.currentTimeMs() + 500L;
      this.method1221();
      if(widgetRoot != -1) {
         this.method1437(true);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "758013495"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1214(boolean var1) {
      boolean var2;
      label182: {
         try {
            if(class204.field2507 == 2) {
               if(class204.field2506 == null) {
                  class204.field2506 = Track1.getMusicFile(class204.field2502, class150.field2205, class153.field2222);
                  if(class204.field2506 == null) {
                     var2 = false;
                     break label182;
                  }
               }

               if(class204.field2509 == null) {
                  class204.field2509 = new class113(class204.field2500, class204.field2499);
               }

               if(class204.field2501.method3690(class204.field2506, class204.field2503, class204.field2509, 22050)) {
                  class204.field2501.method3692();
                  class204.field2501.method3689(class204.field2504);
                  class204.field2501.method3717(class204.field2506, class99.field1532);
                  class204.field2507 = 0;
                  class204.field2506 = null;
                  class204.field2509 = null;
                  class204.field2502 = null;
                  var2 = true;
                  break label182;
               }
            }
         } catch (Exception var6) {
            var6.printStackTrace();
            class204.field2501.method3758();
            class204.field2507 = 0;
            class204.field2506 = null;
            class204.field2509 = null;
            class204.field2502 = null;
         }

         var2 = false;
      }

      if(var2 && field1163 && class84.soundSystem0 != null) {
         class84.soundSystem0.method2033();
      }

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1139 && class74.currentTimeMs() > field1139) {
         var4 = class13.method77();
         field1139 = 0L;
         if(var4 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         if(class13.method77() == 1) {
            class27.clientInstance.method888(765, 503);
         } else {
            class27.clientInstance.method888(7680, 2160);
         }

         if(gameState >= 25) {
            class88.method1705();
         }
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1112[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class93.loadingBarPercentage, class93.loadingText, var1);
      } else if(gameState == 5) {
         class209.drawLoginScreen(class61.field765, VertexNormal.field2006, class35.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class209.drawLoginScreen(class61.field765, VertexNormal.field2006, class35.font_p12full, var1);
         } else if(gameState == 25) {
            if(field995 == 1) {
               if(field991 > field992) {
                  field992 = field991;
               }

               var4 = (field992 * 50 - field991 * 50) / field992;
               class88.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field995 == 2) {
               if(field981 > field1091) {
                  field1091 = field981;
               }

               var4 = (field1091 * 50 - field981 * 50) / field1091 + 50;
               class88.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class88.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1222();
         } else if(gameState == 40) {
            class88.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class88.drawStatusBox("Please wait...", false);
         }
      } else {
         class209.drawLoginScreen(class61.field765, VertexNormal.field2006, class35.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < field1129; ++var4) {
            if(field1132[var4]) {
               IndexFile.field2286.vmethod5042(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1132[var4] = false;
            }
         }
      } else if(gameState > 0) {
         IndexFile.field2286.vmethod5043(0, 0);

         for(var4 = 0; var4 < field1129; ++var4) {
            field1132[var4] = false;
         }
      }

   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(Lhi;I)V",
      garbageValue = "-1997561763"
   )
   void method1228(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class84.method1670(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = GameEngine.canvasWidth;
         var4 = class1.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      WorldMapType2.method555(var1, var3, var4, false);
      class17.method131(var1, var3, var4);
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-806568518"
   )
   final void method1224() {
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
               boolean var6 = field1131[var2];
               field1131[var2] = field1131[var2 + 1];
               field1131[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(class25.field373 == null) {
         if(field1107 == null) {
            int var14 = MouseInput.field740;
            int var8;
            int var9;
            int var12;
            int var15;
            if(isMenuOpen) {
               int var11;
               if(var14 != 1 && (XGrandExchangeOffer.field302 || var14 != 4)) {
                  var2 = MouseInput.field734;
                  var11 = MouseInput.field735;
                  if(var2 < menuX - 10 || var2 > XGrandExchangeOffer.menuWidth + menuX + 10 || var11 < Sequence.menuY - 10 || var11 > class15.menuHeight + Sequence.menuY + 10) {
                     isMenuOpen = false;
                     class91.method1724(menuX, Sequence.menuY, XGrandExchangeOffer.menuWidth, class15.menuHeight);
                  }
               }

               if(var14 == 1 || !XGrandExchangeOffer.field302 && var14 == 4) {
                  var2 = menuX;
                  var11 = Sequence.menuY;
                  var12 = XGrandExchangeOffer.menuWidth;
                  var5 = MouseInput.field741;
                  var15 = MouseInput.field742;
                  int var7 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = (menuOptionCount - 1 - var8) * 15 + var11 + 31;
                     if(var5 > var2 && var5 < var12 + var2 && var15 > var9 - 13 && var15 < var9 + 3) {
                        var7 = var8;
                     }
                  }

                  if(var7 != -1) {
                     Coordinates.method3956(var7);
                  }

                  isMenuOpen = false;
                  class91.method1724(menuX, Sequence.menuY, XGrandExchangeOffer.menuWidth, class15.menuHeight);
               }
            } else {
               var2 = menuOptionCount - 1;
               if((var14 == 1 || !XGrandExchangeOffer.field302 && var14 == 4) && var2 >= 0) {
                  var12 = menuTypes[var2];
                  if(var12 == 39 || var12 == 40 || var12 == 41 || var12 == 42 || var12 == 43 || var12 == 33 || var12 == 34 || var12 == 35 || var12 == 36 || var12 == 37 || var12 == 38 || var12 == 1005) {
                     var5 = menuActionParams0[var2];
                     var15 = menuActionParams1[var2];
                     Widget var13 = class84.method1670(var15);
                     if(class96.method1784(class262.getWidgetConfig(var13)) || class56.method867(class262.getWidgetConfig(var13))) {
                        if(class25.field373 != null && !field1042 && menuOptionCount > 0 && !this.method1365()) {
                           var8 = field975;
                           var9 = field1073;
                           class90 var10 = class17.field318;
                           class262.menuAction(var10.field1408, var10.field1406, var10.field1407, var10.field1409, var10.field1411, var10.field1411, var8, var9);
                           class17.field318 = null;
                        }

                        field1042 = false;
                        field1043 = 0;
                        if(class25.field373 != null) {
                           class90.method1723(class25.field373);
                        }

                        class25.field373 = class84.method1670(var15);
                        field1092 = var5;
                        field975 = MouseInput.field741;
                        field1073 = MouseInput.field742;
                        if(var2 >= 0) {
                           class17.field318 = new class90();
                           class17.field318.field1408 = menuActionParams0[var2];
                           class17.field318.field1406 = menuActionParams1[var2];
                           class17.field318.field1407 = menuTypes[var2];
                           class17.field318.field1409 = menuIdentifiers[var2];
                           class17.field318.field1411 = menuOptions[var2];
                        }

                        class90.method1723(class25.field373);
                        return;
                     }
                  }
               }

               if((var14 == 1 || !XGrandExchangeOffer.field302 && var14 == 4) && this.method1365()) {
                  var14 = 2;
               }

               if((var14 == 1 || !XGrandExchangeOffer.field302 && var14 == 4) && menuOptionCount > 0) {
                  Coordinates.method3956(var2);
               }

               if(var14 == 2 && menuOptionCount > 0) {
                  this.method1226(MouseInput.field741, MouseInput.field742);
               }
            }

         }
      }
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "79498071"
   )
   final void method1229() {
      class90.method1723(field1107);
      ++class48.field621;
      if(field1099 && field1104) {
         int var1 = MouseInput.field734;
         int var2 = MouseInput.field735;
         var1 -= field1101;
         var2 -= field1102;
         if(var1 < field1105) {
            var1 = field1105;
         }

         if(var1 + field1107.width > field1105 + field1173.width) {
            var1 = field1105 + field1173.width - field1107.width;
         }

         if(var2 < field1106) {
            var2 = field1106;
         }

         if(var2 + field1107.height > field1106 + field1173.height) {
            var2 = field1106 + field1173.height - field1107.height;
         }

         int var3 = var1 - field948;
         int var4 = var2 - field1109;
         int var5 = field1107.field2725;
         if(class48.field621 > field1107.field2648 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1110 = true;
         }

         int var6 = var1 - field1105 + field1173.scrollX;
         int var7 = var2 - field1106 + field1173.scrollY;
         ScriptEvent var8;
         if(field1107.field2738 != null && field1110) {
            var8 = new ScriptEvent();
            var8.widget = field1107;
            var8.field857 = var6;
            var8.field858 = var7;
            var8.field856 = field1107.field2738;
            Coordinates.method3942(var8);
         }

         if(MouseInput.field733 == 0) {
            if(field1110) {
               if(field1107.field2739 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1107;
                  var8.field857 = var6;
                  var8.field858 = var7;
                  var8.field860 = field1185;
                  var8.field856 = field1107.field2739;
                  Coordinates.method3942(var8);
               }

               if(field1185 != null && Preferences.method1598(field1107) != null) {
                  secretPacketBuffer1.putOpcode(47);
                  secretPacketBuffer1.method3208(field1107.itemId);
                  secretPacketBuffer1.putLEShortA(field1185.id);
                  secretPacketBuffer1.method3312(field1107.index);
                  secretPacketBuffer1.method3215(field1107.id);
                  secretPacketBuffer1.method3312(field1185.index);
                  secretPacketBuffer1.putShort(field1185.itemId);
               }
            } else if(this.method1365()) {
               this.method1226(field1101 + field948, field1102 + field1109);
            } else if(menuOptionCount > 0) {
               int var11 = field948 + field1101;
               int var9 = field1109 + field1102;
               class90 var10 = class17.field318;
               class262.menuAction(var10.field1408, var10.field1406, var10.field1407, var10.field1409, var10.field1411, var10.field1411, var11, var9);
               class17.field318 = null;
            }

            field1107 = null;
         }

      } else {
         if(class48.field621 > 1) {
            field1107 = null;
         }

      }
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = Occluder.method2920();

         int var18;
         for(int var2 = 0; var2 < var1.length; ++var2) {
            Parameters var3 = var1[var2];
            String var4 = this.getParameter(var3.key);
            if(var4 != null) {
               switch(Integer.parseInt(var3.key)) {
               case 1:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 2:
                  int var26 = Integer.parseInt(var4);
                  BuildType[] var7 = new BuildType[]{BuildType.WIP, BuildType.LIVE, BuildType.BUILD_LIVE, BuildType.RC};
                  BuildType[] var23 = var7;
                  var18 = 0;

                  BuildType var5;
                  while(true) {
                     if(var18 >= var23.length) {
                        var5 = null;
                        break;
                     }

                     BuildType var10 = var23[var18];
                     if(var26 == var10.ordinal) {
                        var5 = var10;
                        break;
                     }

                     ++var18;
                  }

                  class18.field326 = var5;
               case 3:
               case 10:
               case 11:
               default:
                  break;
               case 4:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 5:
                  flags = Integer.parseInt(var4);
                  break;
               case 6:
                  Friend.field821 = Integer.parseInt(var4);
                  break;
               case 7:
                  languageId = Integer.parseInt(var4);
                  break;
               case 8:
                  class61.field777 = var4;
                  break;
               case 9:
                  class96.field1501 = Integer.parseInt(var4);
                  break;
               case 12:
                  world = Integer.parseInt(var4);
                  break;
               case 13:
                  socketType = Integer.parseInt(var4);
                  break;
               case 14:
                  sessionToken = var4;
                  break;
               case 15:
                  class35.field505 = (class233)PlayerComposition.forOrdinal(class11.method56(), Integer.parseInt(var4));
                  if(class35.field505 == class233.field3188) {
                     class22.field354 = class290.field3841;
                  } else {
                     class22.field354 = class290.field3844;
                  }
               }
            }
         }

         class93.method1767();
         class165.host = this.getCodeBase().getHost();
         String var34 = class18.field326.identifier;
         byte var35 = 0;

         try {
            class156.field2247 = 17;
            class91.field1417 = var35;

            try {
               AbstractByteBuffer.osName = System.getProperty("os.name");
            } catch (Exception var29) {
               AbstractByteBuffer.osName = "Unknown";
            }

            class13.osNameLC = AbstractByteBuffer.osName.toLowerCase();

            try {
               WorldMapType1.userHome = System.getProperty("user.home");
               if(WorldMapType1.userHome != null) {
                  WorldMapType1.userHome = WorldMapType1.userHome + "/";
               }
            } catch (Exception var28) {
               ;
            }

            try {
               if(class13.osNameLC.startsWith("win")) {
                  if(WorldMapType1.userHome == null) {
                     WorldMapType1.userHome = System.getenv("USERPROFILE");
                  }
               } else if(WorldMapType1.userHome == null) {
                  WorldMapType1.userHome = System.getenv("HOME");
               }

               if(WorldMapType1.userHome != null) {
                  WorldMapType1.userHome = WorldMapType1.userHome + "/";
               }
            } catch (Exception var27) {
               ;
            }

            if(WorldMapType1.userHome == null) {
               WorldMapType1.userHome = "~/";
            }

            class156.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", WorldMapType1.userHome, "/tmp/", ""};
            class156.field2255 = new String[]{".jagex_cache_" + class91.field1417, ".file_store_" + class91.field1417};
            int var17 = 0;

            label273:
            while(var17 < 4) {
               String var39 = var17 == 0?"":"" + var17;
               class156.field2256 = new File(WorldMapType1.userHome, "jagex_cl_oldschool_" + var34 + var39 + ".dat");
               String var6 = null;
               String var41 = null;
               boolean var8 = false;
               File var44;
               if(class156.field2256.exists()) {
                  try {
                     FileOnDisk var9 = new FileOnDisk(class156.field2256, "rw", 10000L);

                     int var11;
                     Buffer var43;
                     for(var43 = new Buffer((int)var9.length()); var43.offset < var43.payload.length; var43.offset += var11) {
                        var11 = var9.read(var43.payload, var43.offset, var43.payload.length - var43.offset);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var43.offset = 0;
                     var11 = var43.readUnsignedByte();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var43.readUnsignedByte();
                     }

                     if(var11 <= 2) {
                        var6 = var43.getJagString();
                        if(var12 == 1) {
                           var41 = var43.getJagString();
                        }
                     } else {
                        var6 = var43.getCESU8();
                        if(var12 == 1) {
                           var41 = var43.getCESU8();
                        }
                     }

                     var9.close();
                  } catch (IOException var32) {
                     var32.printStackTrace();
                  }

                  if(var6 != null) {
                     var44 = new File(var6);
                     if(!var44.exists()) {
                        var6 = null;
                     }
                  }

                  if(var6 != null) {
                     var44 = new File(var6, "test.dat");
                     if(!class51.method813(var44, true)) {
                        var6 = null;
                     }
                  }
               }

               if(var6 == null && var17 == 0) {
                  label248:
                  for(var18 = 0; var18 < class156.field2255.length; ++var18) {
                     for(int var19 = 0; var19 < class156.cacheLocations.length; ++var19) {
                        File var20 = new File(class156.cacheLocations[var19] + class156.field2255[var18] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var20.exists() && class51.method813(new File(var20, "test.dat"), true)) {
                           var6 = var20.toString();
                           var8 = true;
                           break label248;
                        }
                     }
                  }
               }

               if(var6 == null) {
                  var6 = WorldMapType1.userHome + File.separatorChar + "jagexcache" + var39 + File.separatorChar + "oldschool" + File.separatorChar + var34 + File.separatorChar;
                  var8 = true;
               }

               if(var41 != null) {
                  File var42 = new File(var41);
                  var44 = new File(var6);

                  try {
                     File[] var47 = var42.listFiles();
                     File[] var21 = var47;

                     for(int var13 = 0; var13 < var21.length; ++var13) {
                        File var14 = var21[var13];
                        File var15 = new File(var44, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var31) {
                     var31.printStackTrace();
                  }

                  var8 = true;
               }

               if(var8) {
                  class13.method78(new File(var6), (File)null);
               }

               File var37 = new File(var6);
               class156.field2245 = var37;
               if(!class156.field2245.exists()) {
                  class156.field2245.mkdirs();
               }

               File[] var40 = class156.field2245.listFiles();
               if(var40 == null) {
                  break;
               }

               File[] var45 = var40;
               int var22 = 0;

               while(true) {
                  if(var22 >= var45.length) {
                     break label273;
                  }

                  File var48 = var45[var22];
                  if(!class51.method813(var48, false)) {
                     ++var17;
                     break;
                  }

                  ++var22;
               }
            }

            Renderable.method2894(class156.field2245);

            try {
               File var36 = new File(WorldMapType1.userHome, "random.dat");
               int var24;
               if(var36.exists()) {
                  class156.field2249 = new CacheFile(new FileOnDisk(var36, "rw", 25L), 24, 0);
               } else {
                  label203:
                  for(int var25 = 0; var25 < class156.field2255.length; ++var25) {
                     for(var24 = 0; var24 < class156.cacheLocations.length; ++var24) {
                        File var46 = new File(class156.cacheLocations[var24] + class156.field2255[var25] + File.separatorChar + "random.dat");
                        if(var46.exists()) {
                           class156.field2249 = new CacheFile(new FileOnDisk(var46, "rw", 25L), 24, 0);
                           break label203;
                        }
                     }
                  }
               }

               if(class156.field2249 == null) {
                  RandomAccessFile var38 = new RandomAccessFile(var36, "rw");
                  var24 = var38.read();
                  var38.seek(0L);
                  var38.write(var24);
                  var38.seek(0L);
                  var38.close();
                  class156.field2249 = new CacheFile(new FileOnDisk(var36, "rw", 25L), 24, 0);
               }
            } catch (IOException var30) {
               ;
            }

            class156.field2257 = new CacheFile(new FileOnDisk(class31.method295("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class156.field2253 = new CacheFile(new FileOnDisk(class31.method295("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            ISAACCipher.field2429 = new CacheFile[class156.field2247];

            for(var17 = 0; var17 < class156.field2247; ++var17) {
               ISAACCipher.field2429[var17] = new CacheFile(new FileOnDisk(class31.method295("main_file_cache.idx" + var17), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var33) {
            Varcs.method1853((String)null, var33);
         }

         class27.clientInstance = this;
         this.initialize(765, 503, 153);
      }
   }
}
