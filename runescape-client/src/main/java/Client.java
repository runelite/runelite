import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
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
public final class Client extends GameEngine {
   @ObfuscatedName("aa")
   static boolean field941;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1607420015
   )
   static int field931;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1762754293
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = -167353891
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lr")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field1117;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 478135509
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 64109625
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 1377019635
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 146054281
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 2000825599
   )
   static int field948;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -914377115
   )
   @Export("world")
   static int world;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 479915579
   )
   static int field1040;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = -2121991433
   )
   static int field1105;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 374028215
   )
   static int field1106;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      longValue = -3436229368979644931L
   )
   static long field1115;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 267895455
   )
   static int field944;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 779387761
   )
   static int field1039;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1512173125
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -1888179075
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("oy")
   static boolean field1141;
   @ObfuscatedName("jo")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ma")
   static boolean[] field1107;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 1379658357
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("mk")
   static boolean[] field1050;
   @ObfuscatedName("mr")
   static boolean[] field1159;
   @ObfuscatedName("js")
   static boolean[] field1048;
   @ObfuscatedName("jm")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 1731242427
   )
   static int field1051;
   @ObfuscatedName("jt")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = 457992647
   )
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("lb")
   static boolean field1083;
   @ObfuscatedName("bp")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("el")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 1886347127
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = -1962399071
   )
   static int field1052;
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("bi")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("jg")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -7776743
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("mt")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1018382807
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 1728419153
   )
   static int field945;
   @ObfuscatedName("le")
   static boolean field1080;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 2140839125
   )
   static int field947;
   @ObfuscatedName("kr")
   static boolean field1072;
   @ObfuscatedName("bm")
   static boolean field923;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -338175971
   )
   static int field1012;
   @ObfuscatedName("jj")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("jb")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("lg")
   @ObfuscatedGetter(
      intValue = -1284208463
   )
   static int field1078;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      longValue = -3151449539078378139L
   )
   static long field1181;
   @ObfuscatedName("mu")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -334040505
   )
   static int field1081;
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 1696413609
   )
   static int field1135;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1970407273
   )
   static int field927;
   @ObfuscatedName("jf")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 255379421
   )
   static int field937;
   @ObfuscatedName("lj")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field1076;
   @ObfuscatedName("bs")
   static boolean field1057;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 1047119341
   )
   static int field1020;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 434427951
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("mj")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("ie")
   static boolean field1104;
   @ObfuscatedName("ms")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("bh")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1494746275
   )
   static int field1079;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 1472972979
   )
   static int field1082;
   @ObfuscatedName("jn")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 1480935245
   )
   static int field973;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = 541883649
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("jy")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 892465057
   )
   static int field1103;
   @ObfuscatedName("rc")
   @ObfuscatedSignature(
      signature = "Lbh;"
   )
   static final class74 field1007;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -1661439637
   )
   static int field1123;
   @ObfuscatedName("kj")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 206701051
   )
   static int field933;
   @ObfuscatedName("mz")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("jk")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("mq")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field1169;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 708253497
   )
   static int field1016;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 151566979
   )
   static int field929;
   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "[Lbk;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1851248827
   )
   static int field996;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 607283773
   )
   static int field1017;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -872954659
   )
   static int field971;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 1368792023
   )
   static int field1029;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -935849841
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -882363613
   )
   static int field972;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 1331288801
   )
   static int field1010;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 2136749971
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("ku")
   static String field997;
   @ObfuscatedName("it")
   static String field1056;
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 2093783605
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1403926403
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 690264743
   )
   static int field1126;
   @ObfuscatedName("kh")
   static String field1061;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -1143448839
   )
   static int field1011;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 998187179
   )
   static int field938;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      intValue = -535030501
   )
   static int field1100;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = -2136114541
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1978192457
   )
   static int field1014;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfo;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = 838680335
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = 419805781
   )
   static int field1084;
   @ObfuscatedName("rj")
   static int[] field1180;
   @ObfuscatedName("rg")
   static int[] field1139;
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   static class92 field940;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 2135422397
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = 1999478699
   )
   static int field1085;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = -1563363859
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   static class92 field1089;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1495080747
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("mm")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static Deque field1101;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 1092272339
   )
   static int field1140;
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "[Lco;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1354935649
   )
   static int field968;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 1207400959
   )
   static int field1143;
   @ObfuscatedName("lq")
   static boolean field1086;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 1510897431
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = 1276256247
   )
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -383337525
   )
   static int field1155;
   @ObfuscatedName("da")
   static byte[] field950;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -182107811
   )
   static int field952;
   @ObfuscatedName("et")
   static HashMap field991;
   @ObfuscatedName("dn")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -687277073
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 460979091
   )
   static int field1058;
   @ObfuscatedName("eh")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("lt")
   @ObfuscatedGetter(
      intValue = 1357870825
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("my")
   @ObfuscatedGetter(
      intValue = -649679973
   )
   static int field1099;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 1830646431
   )
   static int field1176;
   @ObfuscatedName("qg")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static PlayerComposition field1035;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      intValue = 592923353
   )
   static int field1091;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = -408096055
   )
   static int field1177;
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   static PacketBuffer field1173;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 1698030539
   )
   static int field1025;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = 1732328253
   )
   static int field1170;
   @ObfuscatedName("lk")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field1120;
   @ObfuscatedName("fa")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -1705958981
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -1259070765
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 1728204665
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = -525532615
   )
   static int field992;
   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "[Lbr;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("qt")
   @ObfuscatedSignature(
      signature = "[Lbt;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("iv")
   static int[] field1026;
   @ObfuscatedName("hf")
   static boolean field993;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 361639071
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -444352655
   )
   static int field1109;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 1894690971
   )
   static int field1046;
   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -1590438877
   )
   static int field1006;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -799353817
   )
   static int field1144;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = -206818707
   )
   static int field1138;
   @ObfuscatedName("ll")
   static int[] field1088;
   @ObfuscatedName("oo")
   static int[] field1175;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -1290593227
   )
   static int field1174;
   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "[[[Lgv;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ks")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field1066;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      longValue = 8482340130748219537L
   )
   static long field943;
   @ObfuscatedName("ov")
   static int[] field1146;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = -1350610175
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("mh")
   @ObfuscatedGetter(
      intValue = -1831801425
   )
   static int field1096;
   @ObfuscatedName("ox")
   static int[] field1147;
   @ObfuscatedName("fr")
   static int[][][] field976;
   @ObfuscatedName("na")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("pw")
   @ObfuscatedSignature(
      signature = "[Ldf;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -289626455
   )
   static int field985;
   @ObfuscatedName("nt")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 175265101
   )
   static int field1054;
   @ObfuscatedName("pn")
   static int[] field1148;
   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   static class196 field1172;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = -786410725
   )
   static int field1053;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1328060915
   )
   static int field979;
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = 902016923
   )
   static int field1060;
   @ObfuscatedName("ia")
   static int[] field1030;
   @ObfuscatedName("ka")
   static boolean field1071;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -1664376307
   )
   static int field1031;
   @ObfuscatedName("nh")
   static byte field1137;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -374554821
   )
   static int field949;
   @ObfuscatedName("pc")
   static boolean field939;
   @ObfuscatedName("fk")
   static final int[] field977;
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = -1516853619
   )
   static int field1132;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -78827077
   )
   static int field980;
   @ObfuscatedName("lp")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1419835813
   )
   static int field1077;
   @ObfuscatedName("oc")
   static int[] field1133;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = -519023435
   )
   static int field1015;
   @ObfuscatedName("hl")
   @ObfuscatedGetter(
      intValue = -1994470513
   )
   static int field1156;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = -161534119
   )
   static int field957;
   @ObfuscatedName("nv")
   static long[] field1122;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -299142885
   )
   static int field982;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 1661912609
   )
   static int field970;
   @ObfuscatedName("om")
   static int[] field1134;
   @ObfuscatedName("gf")
   static boolean field983;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 1903093193
   )
   static int field1131;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 381064105
   )
   static int field984;
   @ObfuscatedName("op")
   @ObfuscatedSignature(
      signature = "[Lkn;"
   )
   static SpritePixels[] field1075;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -2123838057
   )
   static int field1065;
   @ObfuscatedName("ps")
   static boolean[] field1151;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1551138295
   )
   static int field1145;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 2096043475
   )
   static int field988;
   @ObfuscatedName("pz")
   static int[] field1152;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = -116483327
   )
   static int field989;
   @ObfuscatedName("pi")
   static int[] field1153;
   @ObfuscatedName("hs")
   static int[][] field1005;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -1237435505
   )
   static int field963;
   @ObfuscatedName("pb")
   static int[] field1154;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 1151618971
   )
   static int field978;
   @ObfuscatedName("pq")
   static int[] field962;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -1053350991
   )
   static int field1119;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -1377695649
   )
   static int field994;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 272945259
   )
   static int field1127;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = -1479384793
   )
   static int field1023;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -1584507971
   )
   static int field995;
   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = 1275233781
   )
   static int field1073;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -1597697047
   )
   static int field1150;
   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "[Lm;"
   )
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("hq")
   static int[] field1032;
   @ObfuscatedName("hn")
   static int[] field998;
   @ObfuscatedName("hk")
   static int[] field1064;
   @ObfuscatedName("pp")
   static short field1157;
   @ObfuscatedName("pe")
   static short field1183;
   @ObfuscatedName("hz")
   static int[] field1000;
   @ObfuscatedName("md")
   @ObfuscatedGetter(
      intValue = 1165158673
   )
   static int field1097;
   @ObfuscatedName("hg")
   static int[] field1001;
   @ObfuscatedName("ql")
   static short field1162;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = -65215313
   )
   @Export(
      value = "chatCycle",
      setter = true
   )
   static int chatCycle;
   @ObfuscatedName("hi")
   static int[] field1002;
   @ObfuscatedName("qy")
   static short field1163;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -1417854649
   )
   static int field954;
   @ObfuscatedName("ht")
   static int[] field1003;
   @ObfuscatedName("pl")
   static short field1161;
   @ObfuscatedName("pd")
   static short field1062;
   @ObfuscatedName("pk")
   static short field1158;
   @ObfuscatedName("pm")
   static short field964;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 1751449019
   )
   static int field1124;
   @ObfuscatedName("hc")
   static String[] field1004;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -1662116083
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -459950325
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = -421709209
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 1305312179
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("nz")
   static int[] field1113;
   @ObfuscatedName("mo")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static Deque field1102;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = -5518579
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("ng")
   static int[] field1125;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 2070490331
   )
   static int field1164;
   @ObfuscatedName("id")
   @ObfuscatedGetter(
      intValue = 2140715187
   )
   static int field1018;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 1339329889
   )
   static int field1165;
   @ObfuscatedName("mv")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static Deque field1041;
   @ObfuscatedName("iq")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("ip")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("nm")
   static String field1121;
   @ObfuscatedName("ls")
   static int[] field1092;
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = 91636735
   )
   static int field1093;
   @ObfuscatedName("iw")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("kd")
   static boolean field934;
   @ObfuscatedName("jz")
   static boolean field1142;
   @ObfuscatedName("jl")
   static boolean field1009;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -341143735
   )
   static int field920;
   @ObfuscatedName("nc")
   static int[] field1118;
   public static boolean RUNELITE_PACKET;

   static {
      field941 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field923 = true;
      gameCycle = 0;
      field1181 = -1L;
      field1135 = -1;
      field927 = -1;
      field937 = -1;
      field1057 = true;
      displayFps = false;
      field931 = 0;
      field1103 = 0;
      field933 = 0;
      field996 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field938 = 0;
      field1014 = 0;
      field940 = class92.field1410;
      field1089 = class92.field1410;
      loadingStage = 0;
      js5State = 0;
      field944 = 0;
      field945 = 0;
      loginState = 0;
      field947 = 0;
      field948 = 0;
      field1155 = 0;
      field950 = null;
      cachedNPCs = new NPC['耀'];
      field952 = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field1173 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field968 = 0;
      audioEffectCount = 0;
      lastFrameId = 0;
      secondLastFrameId = 0;
      thridLastFrameId = 0;
      field1040 = 0;
      socketError = false;
      field991 = new HashMap();
      field1123 = 0;
      field929 = 1;
      field971 = 0;
      field972 = 1;
      field973 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field976 = new int[4][13][13];
      field977 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1020 = 0;
      field979 = 2301979;
      field980 = 5063219;
      field970 = 3353893;
      field982 = 7759444;
      field983 = false;
      field984 = 0;
      field985 = 128;
      mapAngle = 0;
      field1145 = 0;
      field988 = 0;
      field989 = 0;
      field963 = 0;
      field978 = 50;
      field992 = 0;
      field993 = false;
      field994 = 0;
      field995 = 0;
      field1073 = 50;
      field1032 = new int[field1073];
      field998 = new int[field1073];
      field1064 = new int[field1073];
      field1000 = new int[field1073];
      field1001 = new int[field1073];
      field1002 = new int[field1073];
      field1003 = new int[field1073];
      field1004 = new String[field1073];
      field1005 = new int[104][104];
      field1006 = 0;
      screenY = -1;
      screenX = -1;
      field1029 = 0;
      field1010 = 0;
      field1011 = 0;
      cursorState = 0;
      field1156 = 0;
      field957 = 0;
      field1126 = 0;
      field1016 = 0;
      field1017 = 0;
      field1018 = 0;
      field1104 = false;
      field1079 = 0;
      field1131 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1077 = 0;
      field1025 = 0;
      field1026 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1030 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1031 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1039 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1048 = new boolean[500];
      field1142 = false;
      field1009 = false;
      field1051 = -1;
      field1052 = -1;
      field1053 = 0;
      field1054 = 50;
      itemSelectionState = 0;
      field1056 = null;
      spellSelected = false;
      field1058 = -1;
      field920 = -1;
      field997 = null;
      field1061 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field1023 = 0;
      field1150 = 0;
      field1066 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field954 = -1;
      field1071 = false;
      field1072 = false;
      field934 = false;
      field1169 = null;
      field1117 = null;
      field1076 = null;
      field1012 = 0;
      field1078 = 0;
      field1120 = null;
      field1080 = false;
      field1081 = -1;
      field1082 = -1;
      field1083 = false;
      field1084 = -1;
      field1085 = -1;
      field1086 = false;
      cycleCntr = 1;
      field1088 = new int[32];
      field1174 = 0;
      interfaceItemTriggers = new int[32];
      field1015 = 0;
      field1092 = new int[32];
      field1093 = 0;
      chatCycle = 0;
      field1091 = 0;
      field1096 = 0;
      field1097 = 0;
      field1046 = 0;
      field1099 = 0;
      field1100 = 0;
      field1101 = new Deque();
      field1102 = new Deque();
      field1041 = new Deque();
      widgetFlags = new XHashTable(512);
      field1105 = 0;
      field1106 = -2;
      field1107 = new boolean[100];
      field1159 = new boolean[100];
      field1050 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1115 = 0L;
      isResized = true;
      field1118 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1119 = 0;
      field1127 = 0;
      field1121 = "";
      field1122 = new long[100];
      field1065 = 0;
      field1124 = 0;
      field1125 = new int[128];
      field1113 = new int[128];
      field943 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field949 = -1;
      field1132 = 0;
      field1133 = new int[1000];
      field1134 = new int[1000];
      field1075 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1138 = 0;
      field1060 = 255;
      field1140 = -1;
      field1141 = false;
      field1109 = 127;
      field1143 = 127;
      field1144 = 0;
      field1175 = new int[50];
      field1146 = new int[50];
      field1147 = new int[50];
      field1148 = new int[50];
      audioEffects = new SoundEffect[50];
      field939 = false;
      field1151 = new boolean[5];
      field1152 = new int[5];
      field1153 = new int[5];
      field1154 = new int[5];
      field962 = new int[5];
      field1183 = 256;
      field1157 = 205;
      field1158 = 256;
      field1062 = 320;
      field964 = 1;
      field1161 = 32767;
      field1162 = 1;
      field1163 = 32767;
      field1164 = 0;
      field1165 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1170 = 0;
      friends = new Friend[400];
      field1172 = new class196();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1035 = new PlayerComposition();
      field1176 = -1;
      field1177 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field1007 = new class74();
      field1180 = new int[50];
      field1139 = new int[50];
   }

   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "71"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         long var2 = class170.currentTimeMs();
         int var4 = (int)(var2 - class239.field3239);
         class239.field3239 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class239.field3251 += var4;
         boolean var1;
         if(class239.field3246 == 0 && class239.field3241 == 0 && class239.field3235 == 0 && class239.field3249 == 0) {
            var1 = true;
         } else if(class239.field3237 == null) {
            var1 = false;
         } else {
            try {
               label245: {
                  if(class239.field3251 > 30000) {
                     throw new IOException();
                  }

                  FileRequest var5;
                  Buffer var6;
                  while(class239.field3241 < 20 && class239.field3249 > 0) {
                     var5 = (FileRequest)class239.field3238.method3549();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class239.field3237.queueForWrite(var6.payload, 0, 4);
                     class239.field3236.put(var5, var5.hash);
                     --class239.field3249;
                     ++class239.field3241;
                  }

                  while(class239.field3246 < 20 && class239.field3235 > 0) {
                     var5 = (FileRequest)class239.field3242.peek();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class239.field3237.queueForWrite(var6.payload, 0, 4);
                     var5.unlinkDual();
                     class239.field3240.put(var5, var5.hash);
                     --class239.field3235;
                     ++class239.field3246;
                  }

                  for(int var18 = 0; var18 < 100; ++var18) {
                     int var19 = class239.field3237.available();
                     if(var19 < 0) {
                        throw new IOException();
                     }

                     if(var19 == 0) {
                        break;
                     }

                     class239.field3251 = 0;
                     byte var7 = 0;
                     if(class89.currentRequest == null) {
                        var7 = 8;
                     } else if(class239.field3248 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class239.field3247.offset;
                        if(var8 > var19) {
                           var8 = var19;
                        }

                        class239.field3237.read(class239.field3247.payload, class239.field3247.offset, var8);
                        if(class239.field3243 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class239.field3247.payload[class239.field3247.offset + var9] ^= class239.field3243;
                           }
                        }

                        class239.field3247.offset += var8;
                        if(class239.field3247.offset < var7) {
                           break;
                        }

                        if(class89.currentRequest == null) {
                           class239.field3247.offset = 0;
                           var9 = class239.field3247.readUnsignedByte();
                           var10 = class239.field3247.readUnsignedShort();
                           int var20 = class239.field3247.readUnsignedByte();
                           var12 = class239.field3247.readInt();
                           long var21 = (long)(var10 + (var9 << 16));
                           FileRequest var15 = (FileRequest)class239.field3236.get(var21);
                           class170.field2328 = true;
                           if(var15 == null) {
                              var15 = (FileRequest)class239.field3240.get(var21);
                              class170.field2328 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var20 == 0?5:9;
                           class89.currentRequest = var15;
                           class266.field3650 = new Buffer(var12 + var16 + class89.currentRequest.padding);
                           class266.field3650.putByte(var20);
                           class266.field3650.putInt(var12);
                           class239.field3248 = 8;
                           class239.field3247.offset = 0;
                        } else if(class239.field3248 == 0) {
                           if(class239.field3247.payload[0] == -1) {
                              class239.field3248 = 1;
                              class239.field3247.offset = 0;
                           } else {
                              class89.currentRequest = null;
                           }
                        }
                     } else {
                        var8 = class266.field3650.payload.length - class89.currentRequest.padding;
                        var9 = 512 - class239.field3248;
                        if(var9 > var8 - class266.field3650.offset) {
                           var9 = var8 - class266.field3650.offset;
                        }

                        if(var9 > var19) {
                           var9 = var19;
                        }

                        class239.field3237.read(class266.field3650.payload, class266.field3650.offset, var9);
                        if(class239.field3243 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              class266.field3650.payload[class266.field3650.offset + var10] ^= class239.field3243;
                           }
                        }

                        class266.field3650.offset += var9;
                        class239.field3248 += var9;
                        if(var8 == class266.field3650.offset) {
                           if(class89.currentRequest.hash == 16711935L) {
                              class19.field323 = class266.field3650;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var11 = class239.field3250[var10];
                                 if(var11 != null) {
                                    class19.field323.offset = 5 + var10 * 8;
                                    var12 = class19.field323.readInt();
                                    int var13 = class19.field323.readInt();
                                    var11.setInformation(var12, var13);
                                 }
                              }
                           } else {
                              class239.field3244.reset();
                              class239.field3244.update(class266.field3650.payload, 0, var8);
                              var10 = (int)class239.field3244.getValue();
                              if(var10 != class89.currentRequest.crc) {
                                 try {
                                    class239.field3237.close();
                                 } catch (Exception var24) {
                                    ;
                                 }

                                 ++class239.field3252;
                                 class239.field3237 = null;
                                 class239.field3243 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label245;
                              }

                              class239.field3252 = 0;
                              class239.field3253 = 0;
                              class89.currentRequest.index.method4215((int)(class89.currentRequest.hash & 65535L), class266.field3650.payload, 16711680L == (class89.currentRequest.hash & 16711680L), class170.field2328);
                           }

                           class89.currentRequest.unlink();
                           if(class170.field2328) {
                              --class239.field3241;
                           } else {
                              --class239.field3246;
                           }

                           class239.field3248 = 0;
                           class89.currentRequest = null;
                           class266.field3650 = null;
                        } else {
                           if(class239.field3248 != 512) {
                              break;
                           }

                           class239.field3248 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var25) {
               try {
                  class239.field3237.close();
               } catch (Exception var23) {
                  ;
               }

               ++class239.field3253;
               class239.field3237 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1186();
         }

      }
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1132609013"
   )
   void method1191() {
      int var1 = NPC.canvasWidth;
      int var2 = InvType.canvasHeight;
      if(super.field682 < var1) {
         var1 = super.field682;
      }

      if(super.field704 < var2) {
         var2 = super.field704;
      }

      if(MilliTimer.preferences != null) {
         try {
            Client var3 = class5.clientInstance;
            Object[] var4 = new Object[]{Integer.valueOf(Tile.method2512())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1232631027"
   )
   protected final void vmethod1184() {
      if(class47.chatMessages.changed()) {
         class47.chatMessages.serialize();
      }

      if(class153.field2205 != null) {
         class153.field2205.field861 = false;
      }

      class153.field2205 = null;
      if(GZipDecompressor.rssocket != null) {
         GZipDecompressor.rssocket.close();
         GZipDecompressor.rssocket = null;
      }

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

      class46.field587 = null;
      if(Actor.soundSystem0 != null) {
         Actor.soundSystem0.method2042();
      }

      if(GroundObject.soundSystem1 != null) {
         GroundObject.soundSystem1.method2042();
      }

      class90.method1736();
      Object var10 = class237.field3217;
      synchronized(class237.field3217) {
         if(class237.field3216 != 0) {
            class237.field3216 = 1;

            try {
               class237.field3217.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(class21.field339 != null) {
         class21.field339.method1098();
         class21.field339 = null;
      }

      class228.method4087();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1931230529"
   )
   protected final void vmethod1181() {
      class225.field2823 = socketType == 0?'ꩊ':world + '鱀';
      class69.field832 = socketType == 0?443:world + '썐';
      class29.myWorldPort = class225.field2823;
      class258.colorsToFind = class215.field2608;
      PlayerComposition.colorsToReplace = class215.field2605;
      class135.field1990 = class215.field2606;
      ClassInfo.field3729 = class215.field2607;
      class21.field339 = new class69();
      this.method943();
      this.method841();
      class46.field587 = this.method840();
      RSCanvas.field650 = new IndexFile(255, class156.field2231, class156.field2232, 500000);
      FileOnDisk var2 = null;
      Preferences var3 = new Preferences();

      try {
         var2 = TextureProvider.getPreferencesFile("", class29.field424.field3175, false);
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

      MilliTimer.preferences = var3;
      this.method954();
      String var10 = class230.field3141;
      class56.field664 = this;
      class56.field661 = var10;
      if(socketType != 0) {
         displayFps = true;
      }

      int var7 = MilliTimer.preferences.screenType;
      field1115 = 0L;
      if(var7 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      if(Tile.method2512() == 1) {
         class5.clientInstance.method838(765, 503);
      } else {
         class5.clientInstance.method838(7680, 2160);
      }

      if(gameState >= 25) {
         XGrandExchangeOffer.method113();
      }

   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2119046660"
   )
   final void method1197(boolean var1) {
      int var2 = widgetRoot;
      int var3 = NPC.canvasWidth;
      int var4 = InvType.canvasHeight;
      if(class10.loadWidget(var2)) {
         class23.method171(Item.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "279911744"
   )
   @Export("error")
   void error(int var1) {
      SceneTilePaint.socket = null;
      class31.rssocket = null;
      js5State = 0;
      if(class225.field2823 == class29.myWorldPort) {
         class29.myWorldPort = class69.field832;
      } else {
         class29.myWorldPort = class225.field2823;
      }

      ++field945;
      if(field945 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field944 = 3000;
         }
      } else if(field945 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field945 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field944 = 3000;
         }
      }

   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2083212928"
   )
   final boolean method1195() {
      int var1 = menuOptionCount - 1;
      if(menuOptionCount > 2) {
         if(field1039 != 1 || field1048[var1]) {
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

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2048513642"
   )
   protected final void vmethod1178() {
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "12"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(GZipDecompressor.rssocket == null) {
         return false;
      } else {
         int var3;
         String var29;
         try {
            int var1 = GZipDecompressor.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = RUNELITE_PACKET?-2:class273.field3680[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field968 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId;
            lastFrameId = packetType;
            int var2;
            if(packetType == (RUNELITE_PACKET?0:100)) {
               field939 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1151[var2] = false;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?1:187)) {
               field1170 = 1;
               field1091 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?2:244)) {
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

            if(packetType == (RUNELITE_PACKET?3:186)) {
               Projectile.method1793();

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               class237.initializeGPI(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?4:69)) {
               for(var2 = 0; var2 < VarPlayerType.field3270; ++var2) {
                  VarPlayerType var111 = class36.method497(var2);
                  if(var111 != null) {
                     class212.settings[var2] = 0;
                     class212.widgetSettings[var2] = 0;
                  }
               }

               class3.method4();
               field1174 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?5:197)) {
               class27.method223();
               packetType = -1;
               return false;
            }

            int var6;
            int var24;
            int var45;
            int var46;
            int var50;
            int var54;
            int var80;
            String var114;
            PacketBuffer var118;
            if(packetType == (RUNELITE_PACKET?6:122)) {
               var118 = secretPacketBuffer2;
               var3 = packetLength;
               ClassInfo var87 = new ClassInfo();
               var87.count = var118.readUnsignedByte();
               var87.field3730 = var118.readInt();
               var87.type = new int[var87.count];
               var87.errorIdentifiers = new int[var87.count];
               var87.fields = new Field[var87.count];
               var87.field3731 = new int[var87.count];
               var87.methods = new Method[var87.count];
               var87.args = new byte[var87.count][][];

               for(var24 = 0; var24 < var87.count; ++var24) {
                  try {
                     var6 = var118.readUnsignedByte();
                     String var78;
                     if(var6 != 0 && var6 != 1 && var6 != 2) {
                        if(var6 == 3 || var6 == 4) {
                           var78 = var118.readString();
                           var114 = var118.readString();
                           var80 = var118.readUnsignedByte();
                           String[] var107 = new String[var80];

                           for(var50 = 0; var50 < var80; ++var50) {
                              var107[var50] = var118.readString();
                           }

                           String var84 = var118.readString();
                           byte[][] var121 = new byte[var80][];
                           if(var6 == 3) {
                              for(var45 = 0; var45 < var80; ++var45) {
                                 var54 = var118.readInt();
                                 var121[var45] = new byte[var54];
                                 var118.readBytes(var121[var45], 0, var54);
                              }
                           }

                           var87.type[var24] = var6;
                           Class[] var90 = new Class[var80];

                           for(var54 = 0; var54 < var80; ++var54) {
                              var90[var54] = class117.method2140(var107[var54]);
                           }

                           Class var89 = class117.method2140(var84);
                           if(class117.method2140(var78).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var92 = class117.method2140(var78).getDeclaredMethods();
                           Method[] var120 = var92;

                           for(var46 = 0; var46 < var120.length; ++var46) {
                              Method var93 = var120[var46];
                              if(Reflection.getMethodName(var93).equals(var114)) {
                                 Class[] var19 = Reflection.getParameterTypes(var93);
                                 if(var19.length == var90.length) {
                                    boolean var20 = true;

                                    for(int var21 = 0; var21 < var90.length; ++var21) {
                                       if(var90[var21] != var19[var21]) {
                                          var20 = false;
                                          break;
                                       }
                                    }

                                    if(var20 && var89 == var93.getReturnType()) {
                                       var87.methods[var24] = var93;
                                    }
                                 }
                              }
                           }

                           var87.args[var24] = var121;
                        }
                     } else {
                        var78 = var118.readString();
                        var114 = var118.readString();
                        var80 = 0;
                        if(var6 == 1) {
                           var80 = var118.readInt();
                        }

                        var87.type[var24] = var6;
                        var87.field3731[var24] = var80;
                        if(class117.method2140(var78).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var87.fields[var24] = Reflection.findField(class117.method2140(var78), var114);
                     }
                  } catch (ClassNotFoundException var60) {
                     var87.errorIdentifiers[var24] = -1;
                  } catch (SecurityException var61) {
                     var87.errorIdentifiers[var24] = -2;
                  } catch (NullPointerException var62) {
                     var87.errorIdentifiers[var24] = -3;
                  } catch (Exception var63) {
                     var87.errorIdentifiers[var24] = -4;
                  } catch (Throwable var64) {
                     var87.errorIdentifiers[var24] = -5;
                  }
               }

               class281.field3737.method3580(var87);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?7:125)) {
               for(var2 = 0; var2 < class212.widgetSettings.length; ++var2) {
                  if(class212.widgetSettings[var2] != class212.settings[var2]) {
                     class212.widgetSettings[var2] = class212.settings[var2];
                     class5.method10(var2);
                     field1088[++field1174 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?8:230)) {
               class14.method79(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?9:111)) {
               if(widgetRoot != -1) {
                  var2 = widgetRoot;
                  if(class10.loadWidget(var2)) {
                     class31.method280(Item.widgets[var2], 0);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?10:242)) {
               field1138 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?11:150)) {
               field931 = secretPacketBuffer2.method3212() * 30;
               field1099 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?12:118)) {
               class54.field653 = class171.method3153(secretPacketBuffer2.readUnsignedByte());
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?13:2)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3223();
               }

               class74.field877 = class15.taskManager.createHost(var2);
               packetType = -1;
               return true;
            }

            int var26;
            if(packetType == (RUNELITE_PACKET?14:212)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3337();
               }

               if(var2 == '\uffff') {
                  var2 = -1;
               }

               if(var2 == -1 && !field1141) {
                  class204.field2486.method3738();
                  class204.field2487 = 1;
                  class204.field2488 = null;
               } else if(var2 != -1 && var2 != field1140 && field1060 != 0 && !field1141) {
                  IndexData var110 = class244.indexTrack1;
                  var26 = field1060;
                  class204.field2487 = 1;
                  class204.field2488 = var110;
                  class12.field273 = var2;
                  class204.field2489 = 0;
                  class204.field2490 = var26;
                  class33.field472 = false;
                  class204.field2491 = 2;
               }

               field1140 = var2;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?15:38)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
               }

               XItemContainer var108 = (XItemContainer)XItemContainer.itemContainers.get((long)var2);
               if(var108 != null) {
                  var108.unlink();
               }

               interfaceItemTriggers[++field1015 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            Widget var105;
            if(packetType == (RUNELITE_PACKET?16:160)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
               }

               var105 = class266.method4862(var2);

               for(var26 = 0; var26 < var105.itemIds.length; ++var26) {
                  var105.itemIds[var26] = -1;
                  var105.itemIds[var26] = 0;
               }

               class255.method4531(var105);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?17:236)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3350();
               }

               var105 = class266.method4862(var2);
               var105.modelType = 3;
               var105.modelId = class54.localPlayer.composition.method3959();
               class255.method4531(var105);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?18:31)) {
               class3.method4();
               weight = secretPacketBuffer2.readShort();
               field1099 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?19:135)) {
               class3.method4();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1099 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?20:146)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
               }

               WidgetNode var103 = (WidgetNode)componentTable.get((long)var2);
               if(var103 != null) {
                  class18.method141(var103, true);
               }

               if(field1066 != null) {
                  class255.method4531(field1066);
                  field1066 = null;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?21:61)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
               }

               widgetRoot = var2;
               this.method1197(false);
               WidgetNode.method1093(var2);
               IndexData.method4242(widgetRoot);

               for(var3 = 0; var3 < 100; ++var3) {
                  field1107[var3] = true;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?22:145)) {
               class117.method2139(secretPacketBuffer2.readString());
               packetType = -1;
               return true;
            }

            String var69;
            if(packetType == (RUNELITE_PACKET?23:140)) {
               if(RUNELITE_PACKET) {
                  var29 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var29 = secretPacketBuffer2.readString();
               }

               PacketBuffer var85 = secretPacketBuffer2;

               try {
                  var6 = var85.getUSmart();
                  if(var6 > 32767) {
                     var6 = 32767;
                  }

                  byte[] var76 = new byte[var6];
                  var85.offset += class12.field274.decompress(var85.payload, var85.offset, var76, 0, var6);
                  var114 = class216.getString(var76, 0, var6);
                  var69 = var114;
               } catch (Exception var58) {
                  var69 = "Cabbage";
               }

               var69 = FontTypeFace.appendTags(class266.method4863(var69));
               WorldMapType3.sendGameMessage(6, var29, var69);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?24:222)) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.checkCrc()) {
                  var118 = secretPacketBuffer2;
                  var3 = secretPacketBuffer2.offset - 28;
                  class18.method140(var118.payload, var3);
                  method1501(var118, var3);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?25:207)) {
               byte var102;
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var102 = secretPacketBuffer2.runeliteReadByte();
               } else {
                  var102 = secretPacketBuffer2.method3207();
                  var3 = secretPacketBuffer2.method3337();
               }

               class212.settings[var3] = var102;
               if(class212.widgetSettings[var3] != var102) {
                  class212.widgetSettings[var3] = var102;
               }

               class5.method10(var3);
               field1088[++field1174 - 1 & 31] = var3;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?26:116)) {
               class64.field791 = secretPacketBuffer2.method3202();
               GameEngine.field672 = secretPacketBuffer2.method3203();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?27:8)) {
               field1119 = secretPacketBuffer2.readUnsignedByte();
               field1127 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?28:57)) {
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

            if(packetType == (RUNELITE_PACKET?29:97)) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3217();
                  var3 = secretPacketBuffer2.readUnsignedShort();
               }

               if(var3 == '\uffff') {
                  var3 = -1;
               }

               if(field1060 != 0 && var3 != -1) {
                  WorldMapType1.method276(class33.indexTrack2, var3, 0, field1060, false);
                  field1141 = true;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?30:11)) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1097 = cycleCntr;
               packetType = -1;
               return true;
            }

            long var32;
            long var34;
            if(packetType == (RUNELITE_PACKET?31:59)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readInt();
               }

               var24 = 0;
               if(class74.field878 == null || !class74.field878.isValid()) {
                  try {
                     Iterator var101 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var101.hasNext()) {
                        GarbageCollectorMXBean var75 = (GarbageCollectorMXBean)var101.next();
                        if(var75.isValid()) {
                           class74.field878 = var75;
                           GameEngine.field703 = -1L;
                           GameEngine.field702 = -1L;
                        }
                     }
                  } catch (Throwable var65) {
                     ;
                  }
               }

               if(class74.field878 != null) {
                  long var30 = class170.currentTimeMs();
                  var32 = class74.field878.getCollectionTime();
                  if(-1L != GameEngine.field702) {
                     var34 = var32 - GameEngine.field702;
                     long var36 = var30 - GameEngine.field703;
                     if(0L != var36) {
                        var24 = (int)(100L * var34 / var36);
                     }
                  }

                  GameEngine.field702 = var32;
                  GameEngine.field703 = var30;
               }

               secretPacketBuffer1.putOpcode(89);
               secretPacketBuffer1.method3199(GameEngine.FPS);
               secretPacketBuffer1.putLEShortA(var2);
               secretPacketBuffer1.putLEShortA(var3);
               secretPacketBuffer1.putByte(var24);
               packetType = -1;
               return true;
            }

            boolean var68;
            Widget var70;
            if(packetType == (RUNELITE_PACKET?32:20)) {
               var68 = secretPacketBuffer2.method3203() == 1;
               var3 = secretPacketBuffer2.readInt();
               var70 = class266.method4862(var3);
               if(var68 != var70.isHidden) {
                  var70.isHidden = var68;
                  class255.method4531(var70);
               }

               packetType = -1;
               return true;
            }

            int var25;
            if(packetType == (RUNELITE_PACKET?33:113)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3213();
                  var3 = secretPacketBuffer2.method3350();
               }

               var26 = var2 >> 10 & 31;
               var24 = var2 >> 5 & 31;
               var6 = var2 & 31;
               var25 = (var24 << 11) + (var26 << 19) + (var6 << 3);
               Widget var113 = class266.method4862(var3);
               if(var25 != var113.textColor) {
                  var113.textColor = var25;
                  class255.method4531(var113);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?34:148)) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3215();
                  var3 = secretPacketBuffer2.method3223();
               }

               var70 = class266.method4862(var3);
               if(var2 != var70.field2633 || var2 == -1) {
                  var70.field2633 = var2;
                  var70.field2745 = 0;
                  var70.field2746 = 0;
                  class255.method4531(var70);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?35:226)) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.method3350();
               }

               var70 = class266.method4862(var3);
               if(var70.modelType != 1 || var2 != var70.modelId) {
                  var70.modelType = 1;
                  var70.modelId = var2;
                  class255.method4531(var70);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?36:89)) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3212();
                  var3 = secretPacketBuffer2.readInt();
               }

               var70 = class266.method4862(var3);
               if(var70.modelType != 2 || var2 != var70.modelId) {
                  var70.modelType = 2;
                  var70.modelId = var2;
                  class255.method4531(var70);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?37:182)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3166();
                  var3 = secretPacketBuffer2.method3213();
               }

               var70 = class266.method4862(var2);
               if(var70 != null && var70.type == 0) {
                  if(var3 > var70.scrollHeight - var70.height) {
                     var3 = var70.scrollHeight - var70.height;
                  }

                  if(var3 < 0) {
                     var3 = 0;
                  }

                  if(var3 != var70.scrollY) {
                     var70.scrollY = var3;
                     class255.method4531(var70);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?40:211)) {
               class64.field791 = secretPacketBuffer2.readUnsignedShortOb1();
               GameEngine.field672 = secretPacketBuffer2.method3203();

               for(var2 = GameEngine.field672; var2 < GameEngine.field672 + 8; ++var2) {
                  for(var3 = class64.field791; var3 < class64.field791 + 8; ++var3) {
                     if(groundItemDeque[class29.plane][var2][var3] != null) {
                        groundItemDeque[class29.plane][var2][var3] = null;
                        class35.groundItemSpawned(var2, var3);
                     }
                  }
               }

               for(PendingSpawn var116 = (PendingSpawn)pendingSpawns.getFront(); var116 != null; var116 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var116.x >= GameEngine.field672 && var116.x < GameEngine.field672 + 8 && var116.y >= class64.field791 && var116.y < class64.field791 + 8 && var116.level == class29.plane) {
                     var116.hitpoints = 0;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?41:67)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3212();
                  var3 = secretPacketBuffer2.method3223();
               }

               class212.settings[var2] = var3;
               if(class212.widgetSettings[var2] != var3) {
                  class212.widgetSettings[var2] = var3;
               }

               class5.method10(var2);
               field1088[++field1174 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            WidgetNode var5;
            Widget var96;
            if(packetType == (RUNELITE_PACKET?42:214)) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3350();
                  var3 = secretPacketBuffer2.readInt();
               }

               WidgetNode var83 = (WidgetNode)componentTable.get((long)var3);
               var5 = (WidgetNode)componentTable.get((long)var2);
               if(var5 != null) {
                  class18.method141(var5, var83 == null || var5.id != var83.id);
               }

               if(var83 != null) {
                  var83.unlink();
                  componentTable.put(var83, (long)var2);
               }

               var96 = class266.method4862(var3);
               if(var96 != null) {
                  class255.method4531(var96);
               }

               var96 = class266.method4862(var2);
               if(var96 != null) {
                  class255.method4531(var96);
                  Player.method1171(Item.widgets[var96.id >>> 16], var96, true);
               }

               if(widgetRoot != -1) {
                  var25 = widgetRoot;
                  if(class10.loadWidget(var25)) {
                     class31.method280(Item.widgets[var25], 1);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?43:172)) {
               var68 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var68) {
                  class56.field665 = class170.currentTimeMs() - secretPacketBuffer2.readLong();
                  class170.field2327 = new class13(secretPacketBuffer2, true);
               } else {
                  class170.field2327 = null;
               }

               field1046 = cycleCntr;
               packetType = -1;
               return true;
            }

            String var23;
            if(packetType == (RUNELITE_PACKET?44:0)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var23 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var2 = secretPacketBuffer2.method3223();
                  var23 = secretPacketBuffer2.readString();
               }

               var70 = class266.method4862(var2);
               if(!var23.equals(var70.text)) {
                  var70.text = var23;
                  class255.method4531(var70);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?45:235)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var26 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.readUnsignedByte();
                  var26 = secretPacketBuffer2.readUnsignedShort();
               }

               if(field1109 != 0 && var3 != 0 && field1144 < 50) {
                  field1175[field1144] = var2;
                  field1146[field1144] = var3;
                  field1147[field1144] = var26;
                  audioEffects[field1144] = null;
                  field1148[field1144] = 0;
                  ++field1144;
               }

               packetType = -1;
               return true;
            }

            Widget var71;
            if(packetType == (RUNELITE_PACKET?47:167)) {
               if(RUNELITE_PACKET) {
                  var26 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3212();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  var26 = secretPacketBuffer2.method3350();
               }

               var71 = class266.method4862(var26);
               var71.field2679 = var3 + (var2 << 16);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?49:70)) {
               if(RUNELITE_PACKET) {
                  var26 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  class3.method4();
               } else {
                  class3.method4();
                  var2 = secretPacketBuffer2.method3350();
                  var3 = secretPacketBuffer2.method3202();
                  var26 = secretPacketBuffer2.readUnsignedShortOb1();
               }

               skillExperiences[var26] = var2;
               boostedSkillLevels[var26] = var3;
               realSkillLevels[var26] = 1;

               for(var24 = 0; var24 < 98; ++var24) {
                  if(var2 >= class223.field2808[var24]) {
                     realSkillLevels[var26] = var24 + 2;
                  }
               }

               field1092[++field1093 - 1 & 31] = var26;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?50:51)) {
               if(RUNELITE_PACKET) {
                  var26 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readShort();
                  var3 = secretPacketBuffer2.method3188();
                  var26 = secretPacketBuffer2.method3166();
               }

               var71 = class266.method4862(var26);
               if(var2 != var71.originalX || var3 != var71.originalY || var71.field2715 != 0 || var71.field2629 != 0) {
                  var71.originalX = var2;
                  var71.originalY = var3;
                  var71.field2715 = 0;
                  var71.field2629 = 0;
                  class255.method4531(var71);
                  this.method1198(var71);
                  if(var71.type == 0) {
                     Player.method1171(Item.widgets[var26 >> 16], var71, false);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?51:169)) {
               var2 = secretPacketBuffer2.method3213();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = secretPacketBuffer2.readInt();
               var26 = secretPacketBuffer2.method3166();
               var71 = class266.method4862(var26);
               ItemComposition var98;
               if(!var71.hasScript) {
                  if(var2 == -1) {
                     var71.modelType = 0;
                     packetType = -1;
                     return true;
                  }

                  var98 = ClassInfo.getItemDefinition(var2);
                  var71.modelType = 4;
                  var71.modelId = var2;
                  var71.rotationX = var98.xan2d;
                  var71.rotationZ = var98.yan2d;
                  var71.modelZoom = var98.zoom2d * 100 / var3;
                  class255.method4531(var71);
               } else {
                  var71.itemId = var2;
                  var71.itemQuantity = var3;
                  var98 = ClassInfo.getItemDefinition(var2);
                  var71.rotationX = var98.xan2d;
                  var71.rotationZ = var98.yan2d;
                  var71.rotationY = var98.zan2d;
                  var71.field2663 = var98.offsetX2d;
                  var71.field2621 = var98.offsetY2d;
                  var71.modelZoom = var98.zoom2d;
                  if(var98.isStackable == 1) {
                     var71.field2681 = 1;
                  } else {
                     var71.field2681 = 2;
                  }

                  if(var71.field2678 > 0) {
                     var71.modelZoom = var71.modelZoom * 32 / var71.field2678;
                  } else if(var71.originalWidth > 0) {
                     var71.modelZoom = var71.modelZoom * 32 / var71.originalWidth;
                  }

                  class255.method4531(var71);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?53:165)) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var26 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShortOb1();
                  var3 = secretPacketBuffer2.method3223();
                  var26 = secretPacketBuffer2.readUnsignedShort();
               }

               var5 = (WidgetNode)componentTable.get((long)var3);
               if(var5 != null) {
                  class18.method141(var5, var26 != var5.id);
               }

               GameObject.method2937(var3, var26, var2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?54:194)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var23 = secretPacketBuffer2.runeliteReadString();
                  var26 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3203();
                  var23 = secretPacketBuffer2.readString();
                  var26 = secretPacketBuffer2.method3202();
               }

               if(var2 >= 1 && var2 <= 8) {
                  if(var23.equalsIgnoreCase("null")) {
                     var23 = null;
                  }

                  playerOptions[var2 - 1] = var23;
                  playerOptionsPriorities[var2 - 1] = var26 == 0;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?55:237)) {
               World var115 = new World();
               var115.address = secretPacketBuffer2.readString();
               var115.id = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readInt();
               var115.mask = var3;
               WorldMapType1.setGameState(45);
               GZipDecompressor.rssocket.close();
               GZipDecompressor.rssocket = null;
               class60.method1019(var115);
               packetType = -1;
               return false;
            }

            int var77;
            boolean var100;
            if(packetType == (RUNELITE_PACKET?56:81)) {
               var29 = secretPacketBuffer2.readString();
               var3 = secretPacketBuffer2.readUnsignedShort();
               byte var117 = secretPacketBuffer2.readByte();
               var100 = false;
               if(var117 == -128) {
                  var100 = true;
               }

               if(var100) {
                  if(class5.clanChatCount == 0) {
                     packetType = -1;
                     return true;
                  }

                  boolean var81 = false;

                  for(var6 = 0; var6 < class5.clanChatCount && (!WorldMapData.clanMembers[var6].username.equals(var29) || var3 != WorldMapData.clanMembers[var6].world); ++var6) {
                     ;
                  }

                  if(var6 < class5.clanChatCount) {
                     while(var6 < class5.clanChatCount - 1) {
                        WorldMapData.clanMembers[var6] = WorldMapData.clanMembers[var6 + 1];
                        ++var6;
                     }

                     --class5.clanChatCount;
                     WorldMapData.clanMembers[class5.clanChatCount] = null;
                  }
               } else {
                  secretPacketBuffer2.readString();
                  XClanMember var97 = new XClanMember();
                  var97.username = var29;
                  var97.field912 = class9.method50(var97.username, class29.field422);
                  var97.world = var3;
                  var97.rank = var117;

                  for(var25 = class5.clanChatCount - 1; var25 >= 0; --var25) {
                     var77 = WorldMapData.clanMembers[var25].field912.compareTo(var97.field912);
                     if(var77 == 0) {
                        WorldMapData.clanMembers[var25].world = var3;
                        WorldMapData.clanMembers[var25].rank = var117;
                        if(var29.equals(class54.localPlayer.name)) {
                           Friend.clanChatRank = var117;
                        }

                        field1096 = cycleCntr;
                        packetType = -1;
                        return true;
                     }

                     if(var77 < 0) {
                        break;
                     }
                  }

                  if(class5.clanChatCount >= WorldMapData.clanMembers.length) {
                     packetType = -1;
                     return true;
                  }

                  for(var77 = class5.clanChatCount - 1; var77 > var25; --var77) {
                     WorldMapData.clanMembers[var77 + 1] = WorldMapData.clanMembers[var77];
                  }

                  if(class5.clanChatCount == 0) {
                     WorldMapData.clanMembers = new XClanMember[100];
                  }

                  WorldMapData.clanMembers[var25 + 1] = var97;
                  ++class5.clanChatCount;
                  if(var29.equals(class54.localPlayer.name)) {
                     Friend.clanChatRank = var117;
                  }
               }

               field1096 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?57:26)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var26 = secretPacketBuffer2.runeliteReadInt();
                  var24 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var3 = secretPacketBuffer2.readUnsignedByte();
                  var26 = secretPacketBuffer2.readUnsignedByte();
                  var24 = secretPacketBuffer2.readUnsignedByte();
               }

               field1151[var2] = true;
               field1152[var2] = var3;
               field1153[var2] = var26;
               field1154[var2] = var24;
               field962[var2] = 0;
               packetType = -1;
               return true;
            }

            long var42;
            if(packetType == (RUNELITE_PACKET?60:105)) {
               var2 = secretPacketBuffer2.method3350();
               var3 = secretPacketBuffer2.readInt();
               var26 = secretPacketBuffer2.method3212();
               if(var26 == '\uffff') {
                  var26 = -1;
               }

               var24 = secretPacketBuffer2.readUnsignedShort();
               if(var24 == '\uffff') {
                  var24 = -1;
               }

               for(var6 = var24; var6 <= var26; ++var6) {
                  var42 = ((long)var3 << 32) + (long)var6;
                  Node var119 = widgetFlags.get(var42);
                  if(var119 != null) {
                     var119.unlink();
                  }

                  widgetFlags.put(new IntegerNode(var2), var42);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?61:189)) {
               if(RUNELITE_PACKET) {
                  var24 = secretPacketBuffer2.runeliteReadInt();
                  var2 = secretPacketBuffer2.runeliteReadInt();
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var26 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3213();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  var26 = secretPacketBuffer2.method3337();
                  var24 = secretPacketBuffer2.method3223();
               }

               var96 = class266.method4862(var24);
               if(var2 != var96.rotationX || var3 != var96.rotationZ || var26 != var96.modelZoom) {
                  var96.rotationX = var2;
                  var96.rotationZ = var3;
                  var96.modelZoom = var26;
                  class255.method4531(var96);
               }

               packetType = -1;
               return true;
            }

            long var38;
            long var40;
            String var47;
            if(packetType == (RUNELITE_PACKET?63:227)) {
               var29 = secretPacketBuffer2.readString();
               var38 = (long)secretPacketBuffer2.readUnsignedShort();
               var40 = (long)secretPacketBuffer2.read24BitInt();
               Permission var74 = (Permission)GroundObject.forOrdinal(ScriptEvent.method1111(), secretPacketBuffer2.readUnsignedByte());
               var32 = (var38 << 32) + var40;
               boolean var82 = false;

               for(var50 = 0; var50 < 100; ++var50) {
                  if(var32 == field1122[var50]) {
                     var82 = true;
                     break;
                  }
               }

               if(class23.isIgnored(var29)) {
                  var82 = true;
               }

               if(!var82 && field1131 == 0) {
                  field1122[field1065] = var32;
                  field1065 = (field1065 + 1) % 100;
                  PacketBuffer var53 = secretPacketBuffer2;

                  String var88;
                  try {
                     var54 = var53.getUSmart();
                     if(var54 > 32767) {
                        var54 = 32767;
                     }

                     byte[] var91 = new byte[var54];
                     var53.offset += class12.field274.decompress(var53.payload, var53.offset, var91, 0, var54);
                     var47 = class216.getString(var91, 0, var54);
                     var88 = var47;
                  } catch (Exception var57) {
                     var88 = "Cabbage";
                  }

                  var88 = FontTypeFace.appendTags(class266.method4863(var88));
                  byte var122;
                  if(var74.field3163) {
                     var122 = 7;
                  } else {
                     var122 = 3;
                  }

                  if(var74.field3158 != -1) {
                     var46 = var74.field3158;
                     var47 = "<img=" + var46 + ">";
                     WorldMapType3.sendGameMessage(var122, var47 + var29, var88);
                  } else {
                     WorldMapType3.sendGameMessage(var122, var29, var88);
                  }
               }

               packetType = -1;
               return true;
            }

            String var4;
            boolean var72;
            if(packetType == (RUNELITE_PACKET?64:168)) {
               var2 = secretPacketBuffer2.getUSmart();
               var72 = secretPacketBuffer2.readUnsignedByte() == 1;
               var4 = "";
               var100 = false;
               if(var72) {
                  var4 = secretPacketBuffer2.readString();
                  if(class23.isIgnored(var4)) {
                     var100 = true;
                  }
               }

               String var95 = secretPacketBuffer2.readString();
               if(!var100) {
                  WorldMapType3.sendGameMessage(var2, var4, var95);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?65:104)) {
               var29 = secretPacketBuffer2.readString();
               Object[] var99 = new Object[var29.length() + 1];

               for(var26 = var29.length() - 1; var26 >= 0; --var26) {
                  if(var29.charAt(var26) == 115) {
                     var99[var26 + 1] = secretPacketBuffer2.readString();
                  } else {
                     var99[var26 + 1] = new Integer(secretPacketBuffer2.readInt());
                  }
               }

               var99[0] = new Integer(secretPacketBuffer2.readInt());
               ScriptEvent var79 = new ScriptEvent();
               var79.field849 = var99;
               PendingSpawn.method1525(var79);
               packetType = -1;
               return true;
            }

            if(packetType != 62 && packetType != 1 && packetType != 224 && packetType != 37 && packetType != 3 && packetType != 14 && packetType != 215 && packetType != 101 && packetType != 191) {
               if(packetType == (RUNELITE_PACKET?66:127)) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var72 = (var2 & 1) == 1;
                     var4 = secretPacketBuffer2.readString();
                     var69 = secretPacketBuffer2.readString();
                     secretPacketBuffer2.readString();

                     for(var6 = 0; var6 < ignoreCount; ++var6) {
                        Ignore var73 = ignores[var6];
                        if(var72) {
                           if(var69.equals(var73.name)) {
                              var73.name = var4;
                              var73.previousName = var69;
                              var4 = null;
                              break;
                           }
                        } else if(var4.equals(var73.name)) {
                           var73.name = var4;
                           var73.previousName = var69;
                           var4 = null;
                           break;
                        }
                     }

                     if(var4 != null && ignoreCount < 400) {
                        Ignore var94 = new Ignore();
                        ignores[ignoreCount] = var94;
                        var94.name = var4;
                        var94.previousName = var69;
                        ++ignoreCount;
                     }
                  }

                  field1091 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?67:141)) {
                  field939 = true;
                  class9.field248 = secretPacketBuffer2.readUnsignedByte();
                  WorldMapType2.field522 = secretPacketBuffer2.readUnsignedByte();
                  class36.field505 = secretPacketBuffer2.readUnsignedShort();
                  class18.field315 = secretPacketBuffer2.readUnsignedByte();
                  MessageNode.field874 = secretPacketBuffer2.readUnsignedByte();
                  if(MessageNode.field874 >= 100) {
                     class273.cameraX = class9.field248 * 128 + 64;
                     GZipDecompressor.cameraY = WorldMapType2.field522 * 128 + 64;
                     PendingSpawn.cameraZ = Friend.getTileHeight(class273.cameraX, GZipDecompressor.cameraY, class29.plane) - class36.field505;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?68:179)) {
                  field939 = true;
                  class158.field2239 = secretPacketBuffer2.readUnsignedByte();
                  class36.field510 = secretPacketBuffer2.readUnsignedByte();
                  class222.field2807 = secretPacketBuffer2.readUnsignedShort();
                  ISAACCipher.field2418 = secretPacketBuffer2.readUnsignedByte();
                  class150.field2180 = secretPacketBuffer2.readUnsignedByte();
                  if(class150.field2180 >= 100) {
                     var2 = class158.field2239 * 128 + 64;
                     var3 = class36.field510 * 128 + 64;
                     var26 = Friend.getTileHeight(var2, var3, class29.plane) - class222.field2807;
                     var24 = var2 - class273.cameraX;
                     var6 = var26 - PendingSpawn.cameraZ;
                     var25 = var3 - GZipDecompressor.cameraY;
                     var77 = (int)Math.sqrt((double)(var24 * var24 + var25 * var25));
                     class250.cameraPitch = (int)(Math.atan2((double)var6, (double)var77) * 325.949D) & 2047;
                     Player.cameraYaw = (int)(Math.atan2((double)var24, (double)var25) * -325.949D) & 2047;
                     if(class250.cameraPitch < 128) {
                        class250.cameraPitch = 128;
                     }

                     if(class250.cameraPitch > 383) {
                        class250.cameraPitch = 383;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               boolean var12;
               if(packetType == (RUNELITE_PACKET?69:4)) {
                  var29 = secretPacketBuffer2.readString();
                  var38 = secretPacketBuffer2.readLong();
                  var40 = (long)secretPacketBuffer2.readUnsignedShort();
                  var42 = (long)secretPacketBuffer2.read24BitInt();
                  Permission var44 = (Permission)GroundObject.forOrdinal(ScriptEvent.method1111(), secretPacketBuffer2.readUnsignedByte());
                  var34 = (var40 << 32) + var42;
                  var12 = false;

                  for(var45 = 0; var45 < 100; ++var45) {
                     if(field1122[var45] == var34) {
                        var12 = true;
                        break;
                     }
                  }

                  if(var44.field3152 && class23.isIgnored(var29)) {
                     var12 = true;
                  }

                  if(!var12 && field1131 == 0) {
                     field1122[field1065] = var34;
                     field1065 = (field1065 + 1) % 100;
                     PacketBuffer var14 = secretPacketBuffer2;

                     String var15;
                     try {
                        int var16 = var14.getUSmart();
                        if(var16 > 32767) {
                           var16 = 32767;
                        }

                        byte[] var17 = new byte[var16];
                        var14.offset += class12.field274.decompress(var14.payload, var14.offset, var17, 0, var16);
                        String var18 = class216.getString(var17, 0, var16);
                        var15 = var18;
                     } catch (Exception var59) {
                        var15 = "Cabbage";
                     }

                     var15 = FontTypeFace.appendTags(class266.method4863(var15));
                     if(var44.field3158 != -1) {
                        var46 = var44.field3158;
                        var47 = "<img=" + var46 + ">";
                        class17.addChatMessage(9, var47 + var29, var15, PacketBuffer.method3414(var38));
                     } else {
                        class17.addChatMessage(9, var29, var15, PacketBuffer.method3414(var38));
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?70:241)) {
                  field1103 = secretPacketBuffer2.readUnsignedByte();
                  if(field1103 == 1) {
                     field933 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(field1103 >= 2 && field1103 <= 6) {
                     if(field1103 == 2) {
                        field938 = 64;
                        field1014 = 64;
                     }

                     if(field1103 == 3) {
                        field938 = 0;
                        field1014 = 64;
                     }

                     if(field1103 == 4) {
                        field938 = 128;
                        field1014 = 64;
                     }

                     if(field1103 == 5) {
                        field938 = 64;
                        field1014 = 0;
                     }

                     if(field1103 == 6) {
                        field938 = 64;
                        field1014 = 128;
                     }

                     field1103 = 2;
                     hintArrowX = secretPacketBuffer2.readUnsignedShort();
                     hintArrowY = secretPacketBuffer2.readUnsignedShort();
                     hintArrowType = secretPacketBuffer2.readUnsignedByte();
                  }

                  if(field1103 == 10) {
                     field996 = secretPacketBuffer2.readUnsignedShort();
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?71:155)) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var70 = class266.method4862(var2);
                  } else {
                     var70 = null;
                  }

                  if(var70 != null) {
                     for(var24 = 0; var24 < var70.itemIds.length; ++var24) {
                        var70.itemIds[var24] = 0;
                        var70.itemQuantities[var24] = 0;
                     }
                  }

                  ScriptVarType.method27(var3);
                  var24 = secretPacketBuffer2.readUnsignedShort();

                  for(var6 = 0; var6 < var24; ++var6) {
                     var25 = secretPacketBuffer2.method3202();
                     if(var25 == 255) {
                        var25 = secretPacketBuffer2.method3350();
                     }

                     var77 = secretPacketBuffer2.method3212();
                     if(var70 != null && var6 < var70.itemIds.length) {
                        var70.itemIds[var6] = var77;
                        var70.itemQuantities[var6] = var25;
                     }

                     WorldMapType2.setItemTableSlot(var3, var6, var77 - 1, var25);
                  }

                  if(var70 != null) {
                     class255.method4531(var70);
                  }

                  class3.method4();
                  interfaceItemTriggers[++field1015 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?72:126)) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var70 = class266.method4862(var2);
                  } else {
                     var70 = null;
                  }

                  for(; secretPacketBuffer2.offset < packetLength; WorldMapType2.setItemTableSlot(var3, var24, var6 - 1, var25)) {
                     var24 = secretPacketBuffer2.getUSmart();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var25 = 0;
                     if(var6 != 0) {
                        var25 = secretPacketBuffer2.readUnsignedByte();
                        if(var25 == 255) {
                           var25 = secretPacketBuffer2.readInt();
                        }
                     }

                     if(var70 != null && var24 >= 0 && var24 < var70.itemIds.length) {
                        var70.itemIds[var24] = var6;
                        var70.itemQuantities[var24] = var25;
                     }
                  }

                  if(var70 != null) {
                     class255.method4531(var70);
                  }

                  class3.method4();
                  interfaceItemTriggers[++field1015 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               boolean var9;
               if(packetType == (RUNELITE_PACKET?73:233)) {
                  field1096 = cycleCntr;
                  if(packetLength == 0) {
                     clanChatOwner = null;
                     clanChatName = null;
                     class5.clanChatCount = 0;
                     WorldMapData.clanMembers = null;
                     packetType = -1;
                     return true;
                  }

                  clanChatName = secretPacketBuffer2.readString();
                  long var48 = secretPacketBuffer2.readLong();
                  var40 = var48;
                  if(var48 > 0L && var48 < 6582952005840035281L) {
                     if(0L == var48 % 37L) {
                        var4 = null;
                     } else {
                        var25 = 0;

                        for(var32 = var48; var32 != 0L; var32 /= 37L) {
                           ++var25;
                        }

                        StringBuilder var104 = new StringBuilder(var25);

                        while(0L != var40) {
                           long var51 = var40;
                           var40 /= 37L;
                           var104.append(class269.field3660[(int)(var51 - var40 * 37L)]);
                        }

                        var4 = var104.reverse().toString();
                     }
                  } else {
                     var4 = null;
                  }

                  clanChatOwner = var4;
                  field1137 = secretPacketBuffer2.readByte();
                  var25 = secretPacketBuffer2.readUnsignedByte();
                  if(var25 == 255) {
                     packetType = -1;
                     return true;
                  }

                  class5.clanChatCount = var25;
                  XClanMember[] var112 = new XClanMember[100];

                  for(var80 = 0; var80 < class5.clanChatCount; ++var80) {
                     var112[var80] = new XClanMember();
                     var112[var80].username = secretPacketBuffer2.readString();
                     var112[var80].field912 = class9.method50(var112[var80].username, class29.field422);
                     var112[var80].world = secretPacketBuffer2.readUnsignedShort();
                     var112[var80].rank = secretPacketBuffer2.readByte();
                     secretPacketBuffer2.readString();
                     if(var112[var80].username.equals(class54.localPlayer.name)) {
                        Friend.clanChatRank = var112[var80].rank;
                     }
                  }

                  var9 = false;
                  var50 = class5.clanChatCount;

                  while(var50 > 0) {
                     var9 = true;
                     --var50;

                     for(int var86 = 0; var86 < var50; ++var86) {
                        if(var112[var86].field912.compareTo(var112[var86 + 1].field912) > 0) {
                           XClanMember var106 = var112[var86];
                           var112[var86] = var112[var86 + 1];
                           var112[var86 + 1] = var106;
                           var9 = false;
                        }
                     }

                     if(var9) {
                        break;
                     }
                  }

                  WorldMapData.clanMembers = var112;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?74:181)) {
                  var2 = packetLength + secretPacketBuffer2.offset;
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  var26 = secretPacketBuffer2.readUnsignedShort();
                  if(var3 != widgetRoot) {
                     widgetRoot = var3;
                     this.method1197(false);
                     WidgetNode.method1093(widgetRoot);
                     IndexData.method4242(widgetRoot);

                     for(var24 = 0; var24 < 100; ++var24) {
                        field1107[var24] = true;
                     }
                  }

                  WidgetNode var109;
                  for(; var26-- > 0; var109.field822 = true) {
                     var24 = secretPacketBuffer2.readInt();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var25 = secretPacketBuffer2.readUnsignedByte();
                     var109 = (WidgetNode)componentTable.get((long)var24);
                     if(var109 != null && var6 != var109.id) {
                        class18.method141(var109, true);
                        var109 = null;
                     }

                     if(var109 == null) {
                        var109 = GameObject.method2937(var24, var6, var25);
                     }
                  }

                  for(var5 = (WidgetNode)componentTable.method3549(); var5 != null; var5 = (WidgetNode)componentTable.method3556()) {
                     if(var5.field822) {
                        var5.field822 = false;
                     } else {
                        class18.method141(var5, true);
                     }
                  }

                  widgetFlags = new XHashTable(512);

                  while(secretPacketBuffer2.offset < var2) {
                     var24 = secretPacketBuffer2.readInt();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var25 = secretPacketBuffer2.readUnsignedShort();
                     var77 = secretPacketBuffer2.readInt();

                     for(var80 = var6; var80 <= var25; ++var80) {
                        var34 = (long)var80 + ((long)var24 << 32);
                        widgetFlags.put(new IntegerNode(var77), var34);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?76:175)) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var68 = secretPacketBuffer2.readUnsignedByte() == 1;
                     var23 = secretPacketBuffer2.readString();
                     var4 = secretPacketBuffer2.readString();
                     var24 = secretPacketBuffer2.readUnsignedShort();
                     var6 = secretPacketBuffer2.readUnsignedByte();
                     var25 = secretPacketBuffer2.readUnsignedByte();
                     boolean var8 = (var25 & 2) != 0;
                     var9 = (var25 & 1) != 0;
                     if(var24 > 0) {
                        secretPacketBuffer2.readString();
                        secretPacketBuffer2.readUnsignedByte();
                        secretPacketBuffer2.readInt();
                     }

                     secretPacketBuffer2.readString();

                     for(int var10 = 0; var10 < friendCount; ++var10) {
                        Friend var11 = friends[var10];
                        if(!var68) {
                           if(var23.equals(var11.name)) {
                              if(var24 != var11.world) {
                                 var12 = true;

                                 for(class67 var13 = (class67)field1172.method3637(); var13 != null; var13 = (class67)field1172.method3638()) {
                                    if(var13.field814.equals(var23)) {
                                       if(var24 != 0 && var13.field818 == 0) {
                                          var13.method3644();
                                          var12 = false;
                                       } else if(var24 == 0 && var13.field818 != 0) {
                                          var13.method3644();
                                          var12 = false;
                                       }
                                    }
                                 }

                                 if(var12) {
                                    field1172.method3635(new class67(var23, var24));
                                 }

                                 var11.world = var24;
                              }

                              var11.previousName = var4;
                              var11.rank = var6;
                              var11.field799 = var8;
                              var11.field800 = var9;
                              var23 = null;
                              break;
                           }
                        } else if(var4.equals(var11.name)) {
                           var11.name = var23;
                           var11.previousName = var4;
                           var23 = null;
                           break;
                        }
                     }

                     if(var23 != null && friendCount < 400) {
                        Friend var27 = new Friend();
                        friends[friendCount] = var27;
                        var27.name = var23;
                        var27.previousName = var4;
                        var27.world = var24;
                        var27.rank = var6;
                        var27.field799 = var8;
                        var27.field800 = var9;
                        ++friendCount;
                     }
                  }

                  field1170 = 2;
                  field1091 = cycleCntr;
                  var68 = false;
                  var3 = friendCount;

                  while(var3 > 0) {
                     var68 = true;
                     --var3;

                     for(var26 = 0; var26 < var3; ++var26) {
                        var100 = false;
                        Friend var22 = friends[var26];
                        Friend var7 = friends[var26 + 1];
                        if(var22.world != world && var7.world == world) {
                           var100 = true;
                        }

                        if(!var100 && var22.world == 0 && var7.world != 0) {
                           var100 = true;
                        }

                        if(!var100 && !var22.field799 && var7.field799) {
                           var100 = true;
                        }

                        if(!var100 && !var22.field800 && var7.field800) {
                           var100 = true;
                        }

                        if(var100) {
                           Friend var28 = friends[var26];
                           friends[var26] = friends[var26 + 1];
                           friends[var26 + 1] = var28;
                           var68 = false;
                        }
                     }

                     if(var68) {
                        break;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?78:12)) {
                  class263.xteaChanged(true);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  class14.method79(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?79:22)) {
                  class263.xteaChanged(false);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  class14.method79(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?80:103)) {
                  class56.method811(false);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?81:29)) {
                  class56.method811(true);
                  packetType = -1;
                  return true;
               }

               if(packetType != (RUNELITE_PACKET?82:245)) {
                  if(packetType == (RUNELITE_PACKET?83:95)) {
                     GameEngine.field672 = secretPacketBuffer2.readUnsignedByte();
                     class64.field791 = secretPacketBuffer2.readUnsignedShortOb1();

                     while(secretPacketBuffer2.offset < packetLength) {
                        packetType = secretPacketBuffer2.readUnsignedByte();
                        class40.method540();
                     }

                     packetType = -1;
                     return true;
                  }

                  NPC.method1722("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
                  class27.method223();
                  return true;
               }
            }

            class40.method540();
            packetType = -1;
            return true;
         } catch (IOException var66) {
            class156.method2995();
         } catch (Exception var67) {
            var29 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (class54.localPlayer.pathX[0] + class25.baseX) + "," + (class54.localPlayer.pathY[0] + ScriptEvent.baseY) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var29 = var29 + secretPacketBuffer2.payload[var3] + ",";
            }

            NPC.method1722(var29, var67);
            class27.method223();
         }

         return true;
      }
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "946860655"
   )
   final void method1190(int var1, int var2) {
      int var3 = class28.field406.method4771("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = class28.field406;
         String var6;
         if(var4 < 0) {
            var6 = "";
         } else if(menuTargets[var4].length() > 0) {
            var6 = menuOptions[var4] + " " + menuTargets[var4];
         } else {
            var6 = menuOptions[var4];
         }

         int var7 = var5.method4771(var6);
         if(var7 > var3) {
            var3 = var7;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      int var8 = var1 - var3 / 2;
      if(var3 + var8 > NPC.canvasWidth) {
         var8 = NPC.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var2 + var4 > InvType.canvasHeight) {
         var9 = InvType.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      class84.region.method2747(class29.plane, var1, var2, false);
      isMenuOpen = true;
      CombatInfoListHolder.menuX = var8;
      class67.menuY = var9;
      class135.menuWidth = var3;
      MouseInput.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2073888540"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();

      while(true) {
         Deque var2 = class237.field3215;
         FileSystem var1;
         synchronized(class237.field3215) {
            var1 = (FileSystem)class237.field3214.popFront();
         }

         if(var1 == null) {
            class15.method93();
            class35.method495();
            class17.method127();
            MouseInput var8 = MouseInput.mouse;
            synchronized(MouseInput.mouse) {
               MouseInput.field711 = MouseInput.field729 * -1785346229;
               MouseInput.field718 = MouseInput.mouseX;
               MouseInput.field719 = MouseInput.mouseY;
               MouseInput.field734 = MouseInput.field720;
               MouseInput.field725 = MouseInput.field721;
               MouseInput.field726 = MouseInput.field722;
               MouseInput.field727 = MouseInput.field723;
               MouseInput.field720 = 0;
            }

            int var5;
            if(class46.field587 != null) {
               var5 = class46.field587.vmethod3010();
               field1100 = var5;
            }

            if(gameState == 0) {
               Player.load();
               class233.timer.vmethod3017();

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field679[var5] = 0L;
               }

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field708[var5] = 0L;
               }

               class211.field2580 = 0;
            } else if(gameState == 5) {
               GraphicsObject.method1692(this);
               Player.load();
               class233.timer.vmethod3017();

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field679[var5] = 0L;
               }

               for(var5 = 0; var5 < 32; ++var5) {
                  GameEngine.field708[var5] = 0L;
               }

               class211.field2580 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  GraphicsObject.method1692(this);
                  this.method1188();
               } else if(gameState == 25) {
                  class41.method564();
               }
            } else {
               GraphicsObject.method1692(this);
            }

            if(gameState == 30) {
               this.method1189();
            } else if(gameState == 40 || gameState == 45) {
               this.method1188();
            }

            return;
         }

         var1.data.method4207(var1.index, (int)var1.hash, var1.field3185, false);
      }
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1127974308"
   )
   void method1186() {
      if(class239.field3252 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class239.field3253 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field944 = 3000;
            class239.field3253 = 3;
         }

         if(--field944 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  SceneTilePaint.socket = class15.taskManager.createSocket(class64.host, class29.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(SceneTilePaint.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(SceneTilePaint.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  class31.rssocket = new RSSocket((Socket)SceneTilePaint.socket.value, class15.taskManager);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(152);
                  class31.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  class170.field2329 = class170.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && class31.rssocket.available() <= 0) {
                     if(class170.currentTimeMs() - class170.field2329 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var2 = class31.rssocket.readByte();
                     if(var2 != 0) {
                        this.error(var2);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  class262.method4746(class31.rssocket, gameState > 20);
                  SceneTilePaint.socket = null;
                  class31.rssocket = null;
                  js5State = 0;
                  field945 = 0;
               }
            } catch (IOException var3) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1667519457"
   )
   final void method1215() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(class10.loadWidget(var1)) {
            class233.method4107(Item.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1105; ++var1) {
         if(field1107[var1]) {
            field1159[var1] = true;
         }

         field1050[var1] = field1107[var1];
         field1107[var1] = false;
      }

      field1106 = gameCycle;
      field1051 = -1;
      field1052 = -1;
      MilliTimer.field2195 = null;
      if(widgetRoot != -1) {
         field1105 = 0;
         class33.drawWidget(widgetRoot, 0, 0, NPC.canvasWidth, InvType.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field1051 != -1) {
            var1 = field1051;
            var2 = field1052;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               var3 = menuOptionCount - 1;
               String var5;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var5 = "Use" + " " + field1056 + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var5 = field997 + " " + field1061 + " " + "->";
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
                  var5 = var5 + RSSocket.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class28.field406.drawRandomizedMouseoverText(var5, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         var1 = CombatInfoListHolder.menuX;
         var2 = class67.menuY;
         var3 = class135.menuWidth;
         int var4 = MouseInput.menuHeight;
         int var13 = 6116423;
         Rasterizer2D.method4973(var1, var2, var3, var4, var13);
         Rasterizer2D.method4973(var1 + 1, var2 + 1, var3 - 2, 16, 0);
         Rasterizer2D.drawRectangle(var1 + 1, var2 + 18, var3 - 2, var4 - 19, 0);
         class28.field406.method4776("Choose Option", var1 + 3, var2 + 14, var13, -1);
         int var14 = MouseInput.field718;
         int var7 = MouseInput.field719;

         for(int var8 = 0; var8 < menuOptionCount; ++var8) {
            int var9 = (menuOptionCount - 1 - var8) * 15 + var2 + 31;
            int var10 = 16777215;
            if(var14 > var1 && var14 < var3 + var1 && var7 > var9 - 13 && var7 < var9 + 3) {
               var10 = 16776960;
            }

            Font var11 = class28.field406;
            String var12;
            if(var8 < 0) {
               var12 = "";
            } else if(menuTargets[var8].length() > 0) {
               var12 = menuOptions[var8] + " " + menuTargets[var8];
            } else {
               var12 = menuOptions[var8];
            }

            var11.method4776(var12, var1 + 3, var9, var10, 0);
         }

         class60.method1024(CombatInfoListHolder.menuX, class67.menuY, class135.menuWidth, MouseInput.menuHeight);
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1105; ++var1) {
            if(field1050[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1159[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      class89.method1730(class29.plane, class54.localPlayer.x, class54.localPlayer.y, field1020);
      field1020 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1588282718"
   )
   protected final void vmethod1432() {
      field1115 = class170.currentTimeMs() + 500L;
      this.method1191();
      if(widgetRoot != -1) {
         this.method1197(true);
      }

   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1692496869"
   )
   final void method1188() {
      try {
         if(loginState == 0) {
            if(GZipDecompressor.rssocket != null) {
               GZipDecompressor.rssocket.close();
               GZipDecompressor.rssocket = null;
            }

            class34.field496 = null;
            socketError = false;
            field947 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class34.field496 == null) {
               class34.field496 = class15.taskManager.createSocket(class64.host, class29.myWorldPort);
            }

            if(class34.field496.status == 2) {
               throw new IOException();
            }

            if(class34.field496.status == 1) {
               GZipDecompressor.rssocket = new RSSocket((Socket)class34.field496.value, class15.taskManager);
               class34.field496 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            GZipDecompressor.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(Actor.soundSystem0 != null) {
               Actor.soundSystem0.method2040();
            }

            if(GroundObject.soundSystem1 != null) {
               GroundObject.soundSystem1.method2040();
            }

            var1 = GZipDecompressor.rssocket.readByte();
            if(Actor.soundSystem0 != null) {
               Actor.soundSystem0.method2040();
            }

            if(GroundObject.soundSystem1 != null) {
               GroundObject.soundSystem1.method2040();
            }

            if(var1 != 0) {
               class41.method580(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = GZipDecompressor.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               BaseVarType.field26 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var6 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(BaseVarType.field26 >> 32), (int)(BaseVarType.field26 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class93.field1447.rsOrdinal());
            secretPacketBuffer1.putInt(var6[0]);
            secretPacketBuffer1.putInt(var6[1]);
            secretPacketBuffer1.putInt(var6[2]);
            secretPacketBuffer1.putInt(var6[3]);
            switch(class93.field1447.field2182) {
            case 0:
            case 1:
               secretPacketBuffer1.put24bitInt(class47.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 2:
               secretPacketBuffer1.putInt(((Integer)MilliTimer.preferences.preferences.get(Integer.valueOf(class245.method4332(class93.username)))).intValue());
               secretPacketBuffer1.offset += 4;
               break;
            case 3:
               secretPacketBuffer1.offset += 8;
            }

            secretPacketBuffer1.putString(class93.password);
            secretPacketBuffer1.encryptRsa(class91.rsaKeyExponent, class91.rsaKeyModulus);
            field1173.offset = 0;
            if(gameState == 40) {
               field1173.putByte(18);
            } else {
               field1173.putByte(16);
            }

            field1173.putShort(0);
            var2 = field1173.offset;
            field1173.putInt(152);
            field1173.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field1173.offset;
            field1173.putString(class93.username);
            field1173.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            field1173.putShort(NPC.canvasWidth);
            field1173.putShort(InvType.canvasHeight);
            MessageNode.method1130(field1173);
            field1173.putString(class72.sessionToken);
            field1173.putInt(WorldMapType2.field523);
            Buffer var4 = new Buffer(MouseInput.field731.method5420());
            MouseInput.field731.method5428(var4);
            field1173.putBytes(var4.payload, 0, var4.payload.length);
            field1173.putByte(class33.field469);
            field1173.putInt(0);
            field1173.putInt(class64.indexInterfaces.crc);
            field1173.putInt(class291.indexSoundEffects.crc);
            field1173.putInt(WorldMapType1.configsIndex.crc);
            field1173.putInt(KitDefinition.field3353.crc);
            field1173.putInt(CombatInfo1.field1272.crc);
            field1173.putInt(class158.indexMaps.crc);
            field1173.putInt(class244.indexTrack1.crc);
            field1173.putInt(class19.indexModels.crc);
            field1173.putInt(WorldMapType1.indexSprites.crc);
            field1173.putInt(class61.indexTextures.crc);
            field1173.putInt(Ignore.field855.crc);
            field1173.putInt(class33.indexTrack2.crc);
            field1173.putInt(class253.indexScripts.crc);
            field1173.putInt(WidgetNode.field824.crc);
            field1173.putInt(class51.vorbisIndex.crc);
            field1173.putInt(class22.field342.crc);
            field1173.putInt(class14.indexWorldMap.crc);
            field1173.encryptXtea(var6, var3, field1173.offset);
            field1173.putShortLength(field1173.offset - var2);
            GZipDecompressor.rssocket.queueForWrite(field1173.payload, 0, field1173.offset);
            secretPacketBuffer1.seed(var6);

            for(int var5 = 0; var5 < 4; ++var5) {
               var6[var5] += 50;
            }

            secretPacketBuffer2.seed(var6);
            loginState = 6;
         }

         if(loginState == 6 && GZipDecompressor.rssocket.available() > 0) {
            var1 = GZipDecompressor.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field948 < 1) {
               ++field948;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class41.method580(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && GZipDecompressor.rssocket.available() > 0) {
            field1155 = (GZipDecompressor.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field947 = 0;
            class19.method154("You have only just left another world.", "Your profile will be transferred in:", field1155 / 60 + " seconds.");
            if(--field1155 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && GZipDecompressor.rssocket.available() >= 13) {
               boolean var12 = GZipDecompressor.rssocket.readByte() == 1;
               GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var11 = false;
               if(var12) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = class245.method4332(class93.username);
                  if(MilliTimer.preferences.preferences.size() >= 10 && !MilliTimer.preferences.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var13 = MilliTimer.preferences.preferences.entrySet().iterator();
                     var13.next();
                     var13.remove();
                  }

                  MilliTimer.preferences.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  Projectile.method1782();
               }

               rights = GZipDecompressor.rssocket.readByte();
               field1071 = GZipDecompressor.rssocket.readByte() == 1;
               localInteractingIndex = GZipDecompressor.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += GZipDecompressor.rssocket.readByte();
               field1077 = GZipDecompressor.rssocket.readByte();
               GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  Client var8 = class5.clientInstance;
                  JSObject.getWindow(var8).call("zap", (Object[])null);
               } catch (Throwable var9) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(GZipDecompressor.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  class223.method4074();
                  class237.initializeGPI(secretPacketBuffer2);
                  class48.field605 = -1;
                  class263.xteaChanged(false);
                  packetType = -1;
               }

            } else {
               if(loginState == 11 && GZipDecompressor.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  World.field1282 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && GZipDecompressor.rssocket.available() >= World.field1282) {
                  secretPacketBuffer2.offset = 0;
                  GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, World.field1282);
                  secretPacketBuffer2.offset = 0;
                  String var14 = secretPacketBuffer2.readString();
                  String var7 = secretPacketBuffer2.readString();
                  String var15 = secretPacketBuffer2.readString();
                  class19.method154(var14, var7, var15);
                  WorldMapType1.setGameState(10);
               }

               if(loginState == 13) {
                  if(packetLength == -1) {
                     if(GZipDecompressor.rssocket.available() < 2) {
                        return;
                     }

                     GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(GZipDecompressor.rssocket.available() >= packetLength) {
                     GZipDecompressor.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     class88.method1723();
                     class237.initializeGPI(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field947;
                  if(field947 > 2000) {
                     if(field948 < 1) {
                        if(class29.myWorldPort == class225.field2823) {
                           class29.myWorldPort = class69.field832;
                        } else {
                           class29.myWorldPort = class225.field2823;
                        }

                        ++field948;
                        loginState = 0;
                     } else {
                        class41.method580(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(field948 < 1) {
            if(class29.myWorldPort == class225.field2823) {
               class29.myWorldPort = class69.field832;
            } else {
               class29.myWorldPort = class225.field2823;
            }

            ++field948;
            loginState = 0;
         } else {
            class41.method580(-2);
         }
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2104820235"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1183(boolean var1) {
      boolean var2 = Varcs.method1846();
      if(var2 && field1141 && Actor.soundSystem0 != null) {
         Actor.soundSystem0.method2041();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && field1115 != 0L && class170.currentTimeMs() > field1115) {
         var3 = Tile.method2512();
         field1115 = 0L;
         if(var3 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         if(Tile.method2512() == 1) {
            class5.clientInstance.method838(765, 503);
         } else {
            class5.clientInstance.method838(7680, 2160);
         }

         if(gameState >= 25) {
            XGrandExchangeOffer.method113();
         }
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1107[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class93.loadingBarPercentage, class93.loadingText, var1);
      } else if(gameState == 5) {
         class3.drawLoginScreen(class28.field406, Ignore.field852, class290.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            class3.drawLoginScreen(class28.field406, Ignore.field852, class290.font_p12full, var1);
         } else if(gameState == 25) {
            if(field973 == 1) {
               if(field1123 > field929) {
                  field929 = field1123;
               }

               var3 = (field929 * 50 - field1123 * 50) / field929;
               class23.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field973 == 2) {
               if(field971 > field972) {
                  field972 = field971;
               }

               var3 = (field972 * 50 - field971 * 50) / field972 + 50;
               class23.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               class23.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1215();
         } else if(gameState == 40) {
            class23.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class23.drawStatusBox("Please wait...", false);
         }
      } else {
         class3.drawLoginScreen(class28.field406, Ignore.field852, class290.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < field1105; ++var3) {
            if(field1159[var3]) {
               class19.field322.vmethod5052(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field1159[var3] = false;
            }
         }
      } else if(gameState > 0) {
         class19.field322.vmethod5051(0, 0);

         for(var3 = 0; var3 < field1105; ++var3) {
            field1159[var3] = false;
         }
      }

   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   final void method1189() {
      if(field931 > 1) {
         --field931;
      }

      if(field1040 > 0) {
         --field1040;
      }

      if(socketError) {
         socketError = false;
         class156.method2995();
      } else {
         if(!isMenuOpen) {
            class5.method12();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.processServerPacket(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(true) {
               ClassInfo var2 = (ClassInfo)class281.field3737.method3567();
               boolean var27;
               if(var2 == null) {
                  var27 = false;
               } else {
                  var27 = true;
               }

               int var14;
               if(!var27) {
                  Object var13 = class153.field2205.field859;
                  int var3;
                  int var4;
                  int var5;
                  int var6;
                  int var7;
                  int var8;
                  int var9;
                  synchronized(class153.field2205.field859) {
                     if(!field941) {
                        class153.field2205.field857 = 0;
                     } else if(MouseInput.field734 != 0 || class153.field2205.field857 >= 40) {
                        secretPacketBuffer1.putOpcode(39);
                        secretPacketBuffer1.putByte(0);
                        var14 = secretPacketBuffer1.offset;
                        var3 = 0;

                        for(var4 = 0; var4 < class153.field2205.field857 && secretPacketBuffer1.offset - var14 < 240; ++var4) {
                           ++var3;
                           var5 = class153.field2205.field863[var4];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 502) {
                              var5 = 502;
                           }

                           var6 = class153.field2205.field860[var4];
                           if(var6 < 0) {
                              var6 = 0;
                           } else if(var6 > 764) {
                              var6 = 764;
                           }

                           var7 = var5 * 765 + var6;
                           if(class153.field2205.field863[var4] == -1 && class153.field2205.field860[var4] == -1) {
                              var6 = -1;
                              var5 = -1;
                              var7 = 524287;
                           }

                           if(var6 == field1135 && var5 == field927) {
                              if(field937 < 2047) {
                                 ++field937;
                              }
                           } else {
                              var8 = var6 - field1135;
                              field1135 = var6;
                              var9 = var5 - field927;
                              field927 = var5;
                              if(field937 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                                 var8 += 32;
                                 var9 += 32;
                                 secretPacketBuffer1.putShort(var9 + (field937 << 12) + (var8 << 6));
                                 field937 = 0;
                              } else if(field937 < 8) {
                                 secretPacketBuffer1.put24bitInt((field937 << 19) + var7 + 8388608);
                                 field937 = 0;
                              } else {
                                 secretPacketBuffer1.putInt((field937 << 19) + var7 + -1073741824);
                                 field937 = 0;
                              }
                           }
                        }

                        secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var14);
                        if(var3 >= class153.field2205.field857) {
                           class153.field2205.field857 = 0;
                        } else {
                           class153.field2205.field857 -= var3;

                           for(var4 = 0; var4 < class153.field2205.field857; ++var4) {
                              class153.field2205.field860[var4] = class153.field2205.field860[var4 + var3];
                              class153.field2205.field863[var4] = class153.field2205.field863[var4 + var3];
                           }
                        }
                     }
                  }

                  if(MouseInput.field734 == 1 || !class51.field645 && MouseInput.field734 == 4 || MouseInput.field734 == 2) {
                     long var15 = (MouseInput.field727 - field1181) / 50L;
                     if(var15 > 4095L) {
                        var15 = 4095L;
                     }

                     field1181 = MouseInput.field727;
                     var3 = MouseInput.field726;
                     if(var3 < 0) {
                        var3 = 0;
                     } else if(var3 > InvType.canvasHeight) {
                        var3 = InvType.canvasHeight;
                     }

                     var4 = MouseInput.field725;
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > NPC.canvasWidth) {
                        var4 = NPC.canvasWidth;
                     }

                     var5 = (int)var15;
                     secretPacketBuffer1.putOpcode(123);
                     secretPacketBuffer1.putShort((var5 << 1) + (MouseInput.field734 == 2?1:0));
                     secretPacketBuffer1.putShort(var4);
                     secretPacketBuffer1.putShort(var3);
                  }

                  if(KeyFocusListener.field643 > 0) {
                     secretPacketBuffer1.putOpcode(36);
                     secretPacketBuffer1.putShort(0);
                     var1 = secretPacketBuffer1.offset;
                     long var17 = class170.currentTimeMs();

                     for(var4 = 0; var4 < KeyFocusListener.field643; ++var4) {
                        long var19 = var17 - field943;
                        if(var19 > 16777215L) {
                           var19 = 16777215L;
                        }

                        field943 = var17;
                        secretPacketBuffer1.method3216((int)var19);
                        secretPacketBuffer1.method3201(KeyFocusListener.field637[var4]);
                     }

                     secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
                  }

                  if(field992 > 0) {
                     --field992;
                  }

                  if(KeyFocusListener.field631[96] || KeyFocusListener.field631[97] || KeyFocusListener.field631[98] || KeyFocusListener.field631[99]) {
                     field993 = true;
                  }

                  if(field993 && field992 <= 0) {
                     field992 = 20;
                     field993 = false;
                     secretPacketBuffer1.putOpcode(7);
                     secretPacketBuffer1.putShortLE(mapAngle);
                     secretPacketBuffer1.method3208(field985);
                  }

                  if(class7.field226 && !field1057) {
                     field1057 = true;
                     secretPacketBuffer1.putOpcode(205);
                     secretPacketBuffer1.putByte(1);
                  }

                  if(!class7.field226 && field1057) {
                     field1057 = false;
                     secretPacketBuffer1.putOpcode(205);
                     secretPacketBuffer1.putByte(0);
                  }

                  if(class29.plane != field949) {
                     field949 = class29.plane;
                     class29.method249(class29.plane);
                  }

                  if(gameState != 30) {
                     return;
                  }

                  for(PendingSpawn var32 = (PendingSpawn)pendingSpawns.getFront(); var32 != null; var32 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var32.hitpoints > 0) {
                        --var32.hitpoints;
                     }

                     ObjectComposition var21;
                     boolean var34;
                     if(var32.hitpoints == 0) {
                        if(var32.field1189 >= 0) {
                           var3 = var32.field1189;
                           var4 = var32.field1191;
                           var21 = WorldMapType1.getObjectDefinition(var3);
                           if(var4 == 11) {
                              var4 = 10;
                           }

                           if(var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           var34 = var21.method4536(var4);
                           if(!var34) {
                              continue;
                           }
                        }

                        class48.method727(var32.level, var32.type, var32.x, var32.y, var32.field1189, var32.field1202, var32.field1191);
                        var32.unlink();
                     } else {
                        if(var32.delay > 0) {
                           --var32.delay;
                        }

                        if(var32.delay == 0 && var32.x >= 1 && var32.y >= 1 && var32.x <= 102 && var32.y <= 102) {
                           if(var32.id >= 0) {
                              var3 = var32.id;
                              var4 = var32.field1194;
                              var21 = WorldMapType1.getObjectDefinition(var3);
                              if(var4 == 11) {
                                 var4 = 10;
                              }

                              if(var4 >= 5 && var4 <= 8) {
                                 var4 = 4;
                              }

                              var34 = var21.method4536(var4);
                              if(!var34) {
                                 continue;
                              }
                           }

                           class48.method727(var32.level, var32.type, var32.x, var32.y, var32.id, var32.orientation, var32.field1194);
                           var32.delay = -1;
                           if(var32.id == var32.field1189 && var32.field1189 == -1) {
                              var32.unlink();
                           } else if(var32.field1189 == var32.id && var32.orientation == var32.field1202 && var32.field1194 == var32.field1191) {
                              var32.unlink();
                           }
                        }
                     }
                  }

                  class45.method651();
                  ++field968;
                  if(field968 > 750) {
                     class156.method2995();
                     return;
                  }

                  var1 = class97.field1493;
                  int[] var28 = class97.field1494;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var22 = cachedPlayers[var28[var3]];
                     if(var22 != null) {
                        PendingSpawn.method1524(var22, 1);
                     }
                  }

                  for(var1 = 0; var1 < field952; ++var1) {
                     var14 = npcIndices[var1];
                     NPC var23 = cachedNPCs[var14];
                     if(var23 != null) {
                        PendingSpawn.method1524(var23, var23.composition.field3547);
                     }
                  }

                  class47.method700();
                  ++field1020;
                  if(cursorState != 0) {
                     field1011 += 20;
                     if(field1011 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class227.field3110 != null) {
                     ++field1156;
                     if(field1156 >= 15) {
                        class255.method4531(class227.field3110);
                        class227.field3110 = null;
                     }
                  }

                  Widget var33 = class43.field569;
                  Widget var29 = class47.field602;
                  class43.field569 = null;
                  class47.field602 = null;
                  field1120 = null;
                  field1083 = false;
                  field1080 = false;
                  field1124 = 0;

                  while(WorldMapType1.method279() && field1124 < 128) {
                     if(rights >= 2 && KeyFocusListener.field631[82] && Coordinates.field2589 == 66) {
                        String var38 = class19.method151();
                        class5.clientInstance.method858(var38);
                     } else {
                        field1113[field1124] = Coordinates.field2589;
                        field1125[field1124] = World.field1292;
                        ++field1124;
                     }
                  }

                  if(widgetRoot != -1) {
                     var3 = widgetRoot;
                     var4 = NPC.canvasWidth;
                     var5 = InvType.canvasHeight;
                     if(class10.loadWidget(var3)) {
                        BuildType.method4099(Item.widgets[var3], -1, 0, 0, var4, var5, 0, 0);
                     }
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var35;
                     Widget var36;
                     ScriptEvent var39;
                     do {
                        var39 = (ScriptEvent)field1102.popFront();
                        if(var39 == null) {
                           while(true) {
                              do {
                                 var39 = (ScriptEvent)field1041.popFront();
                                 if(var39 == null) {
                                    while(true) {
                                       do {
                                          var39 = (ScriptEvent)field1101.popFront();
                                          if(var39 == null) {
                                             this.method1491();
                                             if(BaseVarType.renderOverview != null) {
                                                BaseVarType.renderOverview.method5288(class29.plane, (class54.localPlayer.x >> 7) + class25.baseX, (class54.localPlayer.y >> 7) + ScriptEvent.baseY, false);
                                                BaseVarType.renderOverview.method5247();
                                             }

                                             if(field1117 != null) {
                                                this.method1199();
                                             }

                                             if(class31.field451 != null) {
                                                class255.method4531(class31.field451);
                                                ++field1079;
                                                if(MouseInput.field711 == 0) {
                                                   if(field1104) {
                                                      if(class31.field451 == MilliTimer.field2195 && field1126 != field1018) {
                                                         Widget var40 = class31.field451;
                                                         byte var31 = 0;
                                                         if(field1150 == 1 && var40.contentType == 206) {
                                                            var31 = 1;
                                                         }

                                                         if(var40.itemIds[field1018] <= 0) {
                                                            var31 = 0;
                                                         }

                                                         var6 = class15.getWidgetConfig(var40);
                                                         boolean var30 = (var6 >> 29 & 1) != 0;
                                                         if(var30) {
                                                            var7 = field1126;
                                                            var8 = field1018;
                                                            var40.itemIds[var8] = var40.itemIds[var7];
                                                            var40.itemQuantities[var8] = var40.itemQuantities[var7];
                                                            var40.itemIds[var7] = -1;
                                                            var40.itemQuantities[var7] = 0;
                                                         } else if(var31 == 1) {
                                                            var7 = field1126;
                                                            var8 = field1018;

                                                            while(var8 != var7) {
                                                               if(var7 > var8) {
                                                                  var40.method4003(var7 - 1, var7);
                                                                  --var7;
                                                               } else if(var7 < var8) {
                                                                  var40.method4003(var7 + 1, var7);
                                                                  ++var7;
                                                               }
                                                            }
                                                         } else {
                                                            var40.method4003(field1018, field1126);
                                                         }

                                                         secretPacketBuffer1.putOpcode(187);
                                                         secretPacketBuffer1.putShortLE(field1126);
                                                         secretPacketBuffer1.method3208(field1018);
                                                         secretPacketBuffer1.method3199(var31);
                                                         secretPacketBuffer1.method3177(class31.field451.id);
                                                      }
                                                   } else if(this.method1195()) {
                                                      this.method1190(field1016, field1017);
                                                   } else if(menuOptionCount > 0) {
                                                      var3 = field1016;
                                                      var4 = field1017;
                                                      class74.method1137(class7.field233, var3, var4);
                                                      class7.field233 = null;
                                                   }

                                                   field1156 = 10;
                                                   MouseInput.field734 = 0;
                                                   class31.field451 = null;
                                                } else if(field1079 >= 5 && (MouseInput.field718 > field1016 + 5 || MouseInput.field718 < field1016 - 5 || MouseInput.field719 > field1017 + 5 || MouseInput.field719 < field1017 - 5)) {
                                                   field1104 = true;
                                                }
                                             }

                                             if(Region.method2779()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(130);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?(KeyFocusListener.field631[81]?2:1):0);
                                                secretPacketBuffer1.putShortLE(var4 + ScriptEvent.baseY);
                                                secretPacketBuffer1.putShort(var3 + class25.baseX);
                                                Region.method2760();
                                                field1029 = MouseInput.field725;
                                                field1010 = MouseInput.field726;
                                                cursorState = 1;
                                                field1011 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var33 != class43.field569) {
                                                if(var33 != null) {
                                                   class255.method4531(var33);
                                                }

                                                if(class43.field569 != null) {
                                                   class255.method4531(class43.field569);
                                                }
                                             }

                                             if(var29 != class47.field602 && field1054 == field1053) {
                                                if(var29 != null) {
                                                   class255.method4531(var29);
                                                }

                                                if(class47.field602 != null) {
                                                   class255.method4531(class47.field602);
                                                }
                                             }

                                             if(class47.field602 != null) {
                                                if(field1053 < field1054) {
                                                   ++field1053;
                                                   if(field1053 == field1054) {
                                                      class255.method4531(class47.field602);
                                                   }
                                                }
                                             } else if(field1053 > 0) {
                                                --field1053;
                                             }

                                             var3 = class54.localPlayer.x;
                                             var4 = class54.localPlayer.y;
                                             if(Huffman.field2305 - var3 < -500 || Huffman.field2305 - var3 > 500 || AbstractSoundSystem.field1623 - var4 < -500 || AbstractSoundSystem.field1623 - var4 > 500) {
                                                Huffman.field2305 = var3;
                                                AbstractSoundSystem.field1623 = var4;
                                             }

                                             if(var3 != Huffman.field2305) {
                                                Huffman.field2305 += (var3 - Huffman.field2305) / 16;
                                             }

                                             if(var4 != AbstractSoundSystem.field1623) {
                                                AbstractSoundSystem.field1623 += (var4 - AbstractSoundSystem.field1623) / 16;
                                             }

                                             if(MouseInput.field711 == 4 && class51.field645) {
                                                var5 = MouseInput.field719 - field963;
                                                field988 = var5 * 2;
                                                field963 = var5 != -1 && var5 != 1?(field963 + MouseInput.field719) / 2:MouseInput.field719;
                                                var6 = field989 - MouseInput.field718;
                                                field1145 = var6 * 2;
                                                field989 = var6 != -1 && var6 != 1?(MouseInput.field718 + field989) / 2:MouseInput.field718;
                                             } else {
                                                if(KeyFocusListener.field631[96]) {
                                                   field1145 += (-24 - field1145) / 2;
                                                } else if(KeyFocusListener.field631[97]) {
                                                   field1145 += (24 - field1145) / 2;
                                                } else {
                                                   field1145 /= 2;
                                                }

                                                if(KeyFocusListener.field631[98]) {
                                                   field988 += (12 - field988) / 2;
                                                } else if(KeyFocusListener.field631[99]) {
                                                   field988 += (-12 - field988) / 2;
                                                } else {
                                                   field988 /= 2;
                                                }

                                                field963 = MouseInput.field719;
                                                field989 = MouseInput.field718;
                                             }

                                             mapAngle = field1145 / 2 + mapAngle & 2047;
                                             field985 += field988 / 2;
                                             if(field985 < 128) {
                                                field985 = 128;
                                             }

                                             if(field985 > 383) {
                                                field985 = 383;
                                             }

                                             var5 = Huffman.field2305 >> 7;
                                             var6 = AbstractSoundSystem.field1623 >> 7;
                                             var7 = Friend.getTileHeight(Huffman.field2305, AbstractSoundSystem.field1623, class29.plane);
                                             var8 = 0;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(int var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      int var11 = class29.plane;
                                                      if(var11 < 3 && (class61.tileSettings[1][var9][var10] & 2) == 2) {
                                                         ++var11;
                                                      }

                                                      int var12 = var7 - class61.tileHeights[var11][var9][var10];
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

                                             if(var9 > field994) {
                                                field994 += (var9 - field994) / 24;
                                             } else if(var9 < field994) {
                                                field994 += (var9 - field994) / 80;
                                             }

                                             if(field939) {
                                                ScriptEvent.method1106();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field962[var3];
                                             }

                                             class47.chatMessages.process();
                                             var3 = class216.method3996();
                                             var4 = VertexNormal.method2625();
                                             if(var3 > 15000 && var4 > 15000) {
                                                field1040 = 250;
                                                MouseInput.mouseIdleTicks = 14500;
                                                secretPacketBuffer1.putOpcode(134);
                                             }

                                             for(class67 var37 = (class67)field1172.method3637(); var37 != null; var37 = (class67)field1172.method3638()) {
                                                if((long)var37.field816 < class170.currentTimeMs() / 1000L - 5L) {
                                                   if(var37.field818 > 0) {
                                                      WorldMapType3.sendGameMessage(5, "", var37.field814 + " has logged in.");
                                                   }

                                                   if(var37.field818 == 0) {
                                                      WorldMapType3.sendGameMessage(5, "", var37.field814 + " has logged out.");
                                                   }

                                                   var37.method3644();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(98);
                                             }

                                             try {
                                                if(GZipDecompressor.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   GZipDecompressor.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var25) {
                                                class156.method2995();
                                             }

                                             return;
                                          }

                                          var36 = var39.widget;
                                          if(var36.index < 0) {
                                             break;
                                          }

                                          var35 = class266.method4862(var36.parentId);
                                       } while(var35 == null || var35.children == null || var36.index >= var35.children.length || var36 != var35.children[var36.index]);

                                       PendingSpawn.method1525(var39);
                                    }
                                 }

                                 var36 = var39.widget;
                                 if(var36.index < 0) {
                                    break;
                                 }

                                 var35 = class266.method4862(var36.parentId);
                              } while(var35 == null || var35.children == null || var36.index >= var35.children.length || var36 != var35.children[var36.index]);

                              PendingSpawn.method1525(var39);
                           }
                        }

                        var36 = var39.widget;
                        if(var36.index < 0) {
                           break;
                        }

                        var35 = class266.method4862(var36.parentId);
                     } while(var35 == null || var35.children == null || var36.index >= var35.children.length || var36 != var35.children[var36.index]);

                     PendingSpawn.method1525(var39);
                  }
               }

               secretPacketBuffer1.putOpcode(227);
               secretPacketBuffer1.putByte(0);
               var14 = secretPacketBuffer1.offset;
               class46.encodeClassVerifier(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var14);
            }
         }
      }
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Lhg;I)V",
      garbageValue = "960793832"
   )
   void method1198(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class266.method4862(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = NPC.canvasWidth;
         var4 = InvType.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class204.method3697(var1, var3, var4, false);
      class228.method4086(var1, var3, var4);
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-429609342"
   )
   final void method1491() {
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
               boolean var6 = field1048[var2];
               field1048[var2] = field1048[var2 + 1];
               field1048[var2 + 1] = var6;
               var1 = false;
            }
         }
      }

      if(class31.field451 == null) {
         if(field1117 == null) {
            int var13 = MouseInput.field734;
            int var9;
            int var11;
            int var14;
            int var15;
            if(isMenuOpen) {
               int var10;
               if(var13 != 1 && (class51.field645 || var13 != 4)) {
                  var2 = MouseInput.field718;
                  var10 = MouseInput.field719;
                  if(var2 < CombatInfoListHolder.menuX - 10 || var2 > class135.menuWidth + CombatInfoListHolder.menuX + 10 || var10 < class67.menuY - 10 || var10 > MouseInput.menuHeight + class67.menuY + 10) {
                     isMenuOpen = false;
                     RSSocket.method3044(CombatInfoListHolder.menuX, class67.menuY, class135.menuWidth, MouseInput.menuHeight);
                  }
               }

               if(var13 == 1 || !class51.field645 && var13 == 4) {
                  var2 = CombatInfoListHolder.menuX;
                  var10 = class67.menuY;
                  var11 = class135.menuWidth;
                  var5 = MouseInput.field725;
                  var14 = MouseInput.field726;
                  int var7 = -1;

                  for(var15 = 0; var15 < menuOptionCount; ++var15) {
                     var9 = 31 + var10 + (menuOptionCount - 1 - var15) * 15;
                     if(var5 > var2 && var5 < var11 + var2 && var14 > var9 - 13 && var14 < var9 + 3) {
                        var7 = var15;
                     }
                  }

                  if(var7 != -1) {
                     class51.method772(var7);
                  }

                  isMenuOpen = false;
                  RSSocket.method3044(CombatInfoListHolder.menuX, class67.menuY, class135.menuWidth, MouseInput.menuHeight);
               }
            } else {
               var2 = menuOptionCount - 1;
               if((var13 == 1 || !class51.field645 && var13 == 4) && var2 >= 0) {
                  var11 = menuTypes[var2];
                  if(var11 == 39 || var11 == 40 || var11 == 41 || var11 == 42 || var11 == 43 || var11 == 33 || var11 == 34 || var11 == 35 || var11 == 36 || var11 == 37 || var11 == 38 || var11 == 1005) {
                     label257: {
                        var5 = menuActionParams0[var2];
                        var14 = menuActionParams1[var2];
                        Widget var12 = class266.method4862(var14);
                        if(!class69.method1104(class15.getWidgetConfig(var12))) {
                           var9 = class15.getWidgetConfig(var12);
                           boolean var8 = (var9 >> 29 & 1) != 0;
                           if(!var8) {
                              break label257;
                           }
                        }

                        if(class31.field451 != null && !field1104 && menuOptionCount > 0 && !this.method1195()) {
                           var15 = field1016;
                           var9 = field1017;
                           class74.method1137(class7.field233, var15, var9);
                           class7.field233 = null;
                        }

                        field1104 = false;
                        field1079 = 0;
                        if(class31.field451 != null) {
                           class255.method4531(class31.field451);
                        }

                        class31.field451 = class266.method4862(var14);
                        field1126 = var5;
                        field1016 = MouseInput.field725;
                        field1017 = MouseInput.field726;
                        if(var2 >= 0) {
                           class74.method1135(var2);
                        }

                        class255.method4531(class31.field451);
                        return;
                     }
                  }
               }

               if((var13 == 1 || !class51.field645 && var13 == 4) && this.method1195()) {
                  var13 = 2;
               }

               if((var13 == 1 || !class51.field645 && var13 == 4) && menuOptionCount > 0) {
                  class51.method772(var2);
               }

               if(var13 == 2 && menuOptionCount > 0) {
                  this.method1190(MouseInput.field725, MouseInput.field726);
               }
            }

         }
      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "64"
   )
   final void method1199() {
      class255.method4531(field1117);
      ++ItemLayer.field1779;
      if(field1083 && field1080) {
         int var1 = MouseInput.field718;
         int var2 = MouseInput.field719;
         var1 -= field1012;
         var2 -= field1078;
         if(var1 < field1081) {
            var1 = field1081;
         }

         if(var1 + field1117.width > field1081 + field1076.width) {
            var1 = field1081 + field1076.width - field1117.width;
         }

         if(var2 < field1082) {
            var2 = field1082;
         }

         if(var2 + field1117.height > field1082 + field1076.height) {
            var2 = field1082 + field1076.height - field1117.height;
         }

         int var3 = var1 - field1084;
         int var4 = var2 - field1085;
         int var5 = field1117.field2699;
         if(ItemLayer.field1779 > field1117.field2700 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1086 = true;
         }

         int var6 = var1 - field1081 + field1076.scrollX;
         int var7 = var2 - field1082 + field1076.scrollY;
         ScriptEvent var8;
         if(field1117.field2712 != null && field1086) {
            var8 = new ScriptEvent();
            var8.widget = field1117;
            var8.field837 = var6;
            var8.field844 = var7;
            var8.field849 = field1117.field2712;
            PendingSpawn.method1525(var8);
         }

         if(MouseInput.field711 == 0) {
            if(field1086) {
               if(field1117.field2625 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1117;
                  var8.field837 = var6;
                  var8.field844 = var7;
                  var8.field835 = field1120;
                  var8.field849 = field1117.field2625;
                  PendingSpawn.method1525(var8);
               }

               if(field1120 != null && Ignore.method1115(field1117) != null) {
                  secretPacketBuffer1.putOpcode(178);
                  secretPacketBuffer1.method3208(field1117.index);
                  secretPacketBuffer1.method3208(field1117.itemId);
                  secretPacketBuffer1.method3208(field1120.index);
                  secretPacketBuffer1.method3177(field1117.id);
                  secretPacketBuffer1.putShortLE(field1120.itemId);
                  secretPacketBuffer1.putInt(field1120.id);
               }
            } else if(this.method1195()) {
               this.method1190(field1012 + field1084, field1078 + field1085);
            } else if(menuOptionCount > 0) {
               int var10 = field1084 + field1012;
               int var9 = field1078 + field1085;
               class74.method1137(class7.field233, var10, var9);
               class7.field233 = null;
            }

            field1117 = null;
         }

      } else {
         if(ItemLayer.field1779 > 1) {
            field1117 = null;
         }

      }
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = class239.method4258();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Parameters var3 = var1[var2];
            String var4 = this.getParameter(var3.key);
            if(var4 != null) {
               switch(Integer.parseInt(var3.key)) {
               case 1:
                  WorldMapType2.field523 = Integer.parseInt(var4);
                  break;
               case 2:
                  class66.field805 = var4;
                  break;
               case 3:
                  class33.field469 = Integer.parseInt(var4);
                  break;
               case 4:
                  world = Integer.parseInt(var4);
                  break;
               case 5:
                  class29.field424 = (class233)GroundObject.forOrdinal(XClanMember.method1176(), Integer.parseInt(var4));
                  if(class233.field3174 == class29.field424) {
                     class29.field422 = class290.field3841;
                  } else {
                     class29.field422 = class290.field3843;
                  }
               case 6:
               case 13:
               default:
                  break;
               case 7:
                  languageId = Integer.parseInt(var4);
                  break;
               case 8:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 9:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 10:
                  flags = Integer.parseInt(var4);
                  break;
               case 11:
                  IndexData.field3233 = class164.method3093(Integer.parseInt(var4));
                  break;
               case 12:
                  socketType = Integer.parseInt(var4);
                  break;
               case 14:
                  class72.sessionToken = var4;
               }
            }
         }

         Region.lowMemory = false;
         lowMemory = false;
         class64.host = this.getCodeBase().getHost();
         String var6 = IndexData.field3233.identifier;
         byte var7 = 0;

         try {
            class153.method2960("oldschool", var6, var7, 17);
         } catch (Exception var5) {
            NPC.method1722((String)null, var5);
         }

         class5.clientInstance = this;
         this.initialize(765, 503, 152);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "1868748321"
   )
   public static void method1501(Buffer var0, int var1) {
      if(class156.field2230 != null) {
         try {
            class156.field2230.seek(0L);
            class156.field2230.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-707062988"
   )
   public static final void method1520() {
      class135.field1984 = false;
      class135.field1988 = 0;
   }
}
