import java.io.File;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Date;
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
import net.runelite.rs.Reflection;
import netscape.javascript.JSObject;

@Implements("Client")
@ObfuscatedName("client")
public final class Client extends GameEngine {
   @ObfuscatedName("au")
   static boolean field978;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -2143656229
   )
   static int field1059;
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1807100711
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -792981527
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("lg")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1111;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 934830305
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 384730897
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = -2101567971
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 24181023
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -815314525
   )
   static int field1175;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -125937821
   )
   @Export("world")
   static int world;
   @ObfuscatedName("eq")
   @ObfuscatedGetter(
      intValue = -1255882663
   )
   static int field1058;
   @ObfuscatedName("mb")
   @ObfuscatedGetter(
      intValue = -201251183
   )
   static int field1065;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 1016861011
   )
   static int field1071;
   @ObfuscatedName("mw")
   @ObfuscatedGetter(
      longValue = 8051316246863501915L
   )
   static long field1104;
   @ObfuscatedName("op")
   static boolean field1169;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 508893895
   )
   static int field1155;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = 1465970475
   )
   static int field1068;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1862746503
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1137981277
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "Lbb;"
   )
   static class71 field970;
   @ObfuscatedName("jv")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("ma")
   static boolean[] field1110;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1960513
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("mr")
   static boolean[] field1138;
   @ObfuscatedName("ji")
   static boolean[] field1077;
   @ObfuscatedName("mz")
   static boolean[] field966;
   @ObfuscatedName("jg")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("ls")
   static boolean field1112;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 708046525
   )
   static int field1080;
   @ObfuscatedName("jd")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 1718090573
   )
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("bx")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("ef")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 998219071
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -276549253
   )
   static int field1126;
   @ObfuscatedName("lq")
   static boolean field1209;
   @ObfuscatedName("cw")
   static boolean field951;
   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("br")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("jk")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("mf")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 1027802101
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1761726965
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -1275606153
   )
   static int field945;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1107286705
   )
   static int field1106;
   @ObfuscatedName("ke")
   static boolean field1101;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = -421171063
   )
   static int field975;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = 946783975
   )
   static int field1107;
   @ObfuscatedName("bn")
   static boolean field1100;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -1364302657
   )
   static int field1011;
   @ObfuscatedName("jj")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfh;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("jr")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      longValue = -9150598525097753441L
   )
   static long field1082;
   @ObfuscatedName("mv")
   @ObfuscatedGetter(
      intValue = -2013680713
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("od")
   @ObfuscatedGetter(
      intValue = 1003818377
   )
   static int field1168;
   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -789092603
   )
   static int field1207;
   @ObfuscatedName("lo")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1045;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 2014737909
   )
   static int field953;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = 699272729
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1221231917
   )
   static int field954;
   @ObfuscatedName("jn")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("mj")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("widgetFlags")
   static HashTable widgetFlags;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -444890029
   )
   static int field1007;
   @ObfuscatedName("kn")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("bu")
   static boolean field955;
   @ObfuscatedName("io")
   static boolean field1048;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = 1235720779
   )
   static int field1182;
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 1124427209
   )
   static int field1002;
   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("componentTable")
   static HashTable componentTable;
   @ObfuscatedName("bo")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 581536873
   )
   static int field998;
   @ObfuscatedName("jt")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 1518337279
   )
   static int field999;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 756575777
   )
   static int field1033;
   @ObfuscatedName("jm")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1500179311
   )
   static int field958;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 89728113
   )
   static int field1128;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -564245123
   )
   static int field1069;
   @ObfuscatedName("rj")
   @ObfuscatedSignature(
      signature = "Lbu;"
   )
   static final class73 field963;
   @ObfuscatedName("mu")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("ku")
   static String field1089;
   @ObfuscatedName("it")
   static String field1085;
   @ObfuscatedName("jh")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -2047736699
   )
   static int field959;
   @ObfuscatedName("mq")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = -58063575
   )
   static int field1081;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 971077903
   )
   static int field1046;
   @ObfuscatedName("mh")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 253074441
   )
   static int field960;
   @ObfuscatedName("mg")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("kk")
   static String field1090;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -809706175
   )
   static int field1038;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1037131807
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -983285047
   )
   static int field995;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -2063080573
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 477186871
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 43929341
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 2017210139
   )
   static int field1040;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1529248129
   )
   static int field987;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = 902524861
   )
   static int field1127;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -868896859
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("lb")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1103;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1346336677
   )
   static int field965;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 553843857
   )
   static int field1114;
   @ObfuscatedName("oi")
   @ObfuscatedGetter(
      intValue = 806107889
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("rp")
   static int[] field1208;
   @ObfuscatedName("rd")
   static int[] field1203;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 2110563017
   )
   static int field1044;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   static class90 field967;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -5077745
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 1722053053
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   static class90 field968;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -1914502795
   )
   static int field1171;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1893087483
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("mn")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   static Deque field1130;
   @ObfuscatedName("ec")
   @ObfuscatedGetter(
      intValue = 425591927
   )
   static int field990;
   @ObfuscatedName("lt")
   static boolean field1115;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 757395781
   )
   static int field1129;
   @ObfuscatedName("eg")
   @ObfuscatedGetter(
      intValue = -905395105
   )
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 216527507
   )
   static int field977;
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   static class150 field1135;
   @ObfuscatedName("dc")
   static byte[] field979;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "[Lcw;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "[Lbo;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("pz")
   static boolean field1178;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 442393483
   )
   static int field946;
   @ObfuscatedName("ka")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1086;
   @ObfuscatedName("dk")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -1777030627
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("ee")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -1305868971
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 1317584593
   )
   static int field1204;
   @ObfuscatedName("lm")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1108;
   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static PlayerComposition field1078;
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   static PacketBuffer field1076;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 46201673
   )
   static int field1205;
   @ObfuscatedName("ek")
   static HashMap field997;
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -1671766293
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("iv")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = 1759157073
   )
   static int field1021;
   @ObfuscatedName("ip")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "[Lz;"
   )
   @Export("grandExchangeOffers")
   static GrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 407661695
   )
   static int field1035;
   @ObfuscatedName("hl")
   static boolean field1206;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 1776337699
   )
   static int field1079;
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -1028008789
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("fw")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 1564368545
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -2083361213
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = -220615481
   )
   static int field974;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = 361420001
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("pk")
   static boolean[] field1179;
   @ObfuscatedName("qm")
   @ObfuscatedSignature(
      signature = "[Lbl;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("pe")
   static int[] field1180;
   @ObfuscatedName("lw")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("pr")
   static int[] field1181;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = -1907982551
   )
   static int field1120;
   @ObfuscatedName("pn")
   static int[] field1145;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -475887619
   )
   static int field1083;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -505423387
   )
   static int field973;
   @ObfuscatedName("pj")
   static int[] field1183;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -1464163839
   )
   static int field1008;
   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      longValue = -4255474924237484191L
   )
   static long field1156;
   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "[[[Lgt;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -1488982023
   )
   static int field1148;
   @ObfuscatedName("ia")
   @ObfuscatedGetter(
      intValue = 1548721911
   )
   static int field1060;
   @ObfuscatedName("fi")
   static int[][][] field1005;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -1131035675
   )
   static int field956;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -554276895
   )
   static int field1149;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 1090049977
   )
   static int field1124;
   @ObfuscatedName("kg")
   @ObfuscatedGetter(
      intValue = -115089077
   )
   static int field1087;
   @ObfuscatedName("ox")
   @ObfuscatedGetter(
      intValue = 515811893
   )
   static int field1160;
   @ObfuscatedName("fp")
   static final int[] field1134;
   @ObfuscatedName("oe")
   static int[] field1161;
   @ObfuscatedName("kh")
   static boolean field952;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -459135523
   )
   static int field1073;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 994920705
   )
   static int field1043;
   @ObfuscatedName("oc")
   static int[] field1162;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -1158423591
   )
   static int field1159;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 508320923
   )
   static int field1006;
   @ObfuscatedName("og")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   static SpritePixels[] field1163;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = 1864609485
   )
   static int field1042;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -1587662079
   )
   static int field981;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = 1277022079
   )
   static int field1053;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1324745469
   )
   static int field1010;
   @ObfuscatedName("hm")
   static int[][] field1034;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = -1975784753
   )
   static int field1172;
   @ObfuscatedName("gs")
   static boolean field1012;
   @ObfuscatedName("pa")
   static int[] field1001;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1561299337
   )
   static int field1013;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -1950914343
   )
   static int field1054;
   @ObfuscatedName("pb")
   @ObfuscatedSignature(
      signature = "[Ldj;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = -33925355
   )
   static int field1167;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -1426648713
   )
   static int field989;
   @ObfuscatedName("oa")
   static int[] field1173;
   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 236545259
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 217542983
   )
   static int field1017;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 1623952551
   )
   static int field1116;
   @ObfuscatedName("pi")
   static int[] field1176;
   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "[Lbf;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("ga")
   @ObfuscatedGetter(
      intValue = -630905769
   )
   static int field1018;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = -1629146407
   )
   static int field1185;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 908202541
   )
   static int field1019;
   @ObfuscatedName("ov")
   static int[] field1174;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -309081103
   )
   static int field1020;
   @ObfuscatedName("mp")
   @ObfuscatedGetter(
      intValue = 1142860681
   )
   static int field1146;
   @ObfuscatedName("po")
   static short field1184;
   @ObfuscatedName("ie")
   static int[] field1055;
   @ObfuscatedName("pv")
   static short field1097;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 1341118727
   )
   static int field1023;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -25499957
   )
   static int field1024;
   @ObfuscatedName("qj")
   static short field1190;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -1424066313
   )
   static int field1025;
   @ObfuscatedName("ql")
   static short field1191;
   @ObfuscatedName("hg")
   static int[] field1026;
   @ObfuscatedName("qk")
   static short field1189;
   @ObfuscatedName("pw")
   static short field1052;
   @ObfuscatedName("pu")
   static short field1186;
   @ObfuscatedName("ho")
   static int[] field1201;
   @ObfuscatedName("ps")
   static short field1188;
   @ObfuscatedName("hv")
   static int[] field1118;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = -394250123
   )
   static int field1125;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -86008381
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("hx")
   static int[] field1029;
   @ObfuscatedName("np")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -586879525
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("nf")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -97820691
   )
   static int field1050;
   @ObfuscatedName("hi")
   static int[] field1030;
   @ObfuscatedName("lz")
   static int[] field1022;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      intValue = -81168309
   )
   static int field1198;
   @ObfuscatedName("hb")
   static int[] field1031;
   @ObfuscatedName("hp")
   static int[] field1032;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -1586263119
   )
   static int field1153;
   @ObfuscatedName("hw")
   static String[] field993;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = 1268391099
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = 1710727379
   )
   static int field1099;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 1017508459
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -588332599
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("nk")
   static int[] field1131;
   @ObfuscatedName("la")
   static int[] field1121;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 1292851753
   )
   static int field1192;
   @ObfuscatedName("nr")
   static long[] field1151;
   @ObfuscatedName("ml")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   static Deque field1000;
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = 624991203
   )
   static int field1122;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 2077274899
   )
   static int field1193;
   @ObfuscatedName("nj")
   static int[] field1154;
   @ObfuscatedName("my")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   static Deque field1132;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 760332937
   )
   static int field1152;
   @ObfuscatedName("iq")
   static int[] field1051;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = 1118793445
   )
   static int field1133;
   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   static class196 field1200;
   @ObfuscatedName("nb")
   static String field1150;
   @ObfuscatedName("iw")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 1915355459
   )
   static int field1093;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = 1454582555
   )
   static int field1144;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 1385860693
   )
   @Export(
      value = "chatCycle",
      setter = true
   )
   static int chatCycle;
   @ObfuscatedName("km")
   static boolean field1102;
   @ObfuscatedName("jb")
   static boolean field1047;
   @ObfuscatedName("jc")
   static boolean field969;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 1264577965
   )
   static int field1016;
   @ObfuscatedName("ng")
   static int[] field1147;
   public static boolean RUNELITE_PACKET;

   static {
      field978 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field1100 = true;
      gameCycle = 0;
      field1082 = -1L;
      field1207 = -1;
      field953 = -1;
      field954 = -1;
      field955 = true;
      displayFps = false;
      field1059 = 0;
      field958 = 0;
      field959 = 0;
      field960 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field987 = 0;
      field965 = 0;
      field967 = class90.field1426;
      field968 = class90.field1426;
      loadingStage = 0;
      js5State = 0;
      field1155 = 0;
      field945 = 0;
      loginState = 0;
      field975 = 0;
      field1175 = 0;
      field977 = 0;
      field1135 = class150.field2206;
      field979 = null;
      cachedNPCs = new NPC['耀'];
      field946 = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field1076 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field990 = 0;
      audioEffectCount = 0;
      lastFrameId = 0;
      secondLastFrameId = 0;
      thridLastFrameId = 0;
      field1058 = 0;
      socketError = false;
      field997 = new HashMap();
      field998 = 0;
      field999 = 1;
      field1033 = 0;
      field1128 = 1;
      field1002 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field1005 = new int[4][13][13];
      field1134 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1007 = 0;
      field1008 = 2301979;
      field1073 = 5063219;
      field1010 = 3353893;
      field1006 = 7759444;
      field1012 = false;
      field1013 = 0;
      field956 = 128;
      mapAngle = 0;
      field989 = 0;
      field1017 = 0;
      field1018 = 0;
      field1019 = 0;
      field1020 = 50;
      field1021 = 0;
      field1206 = false;
      field1023 = 0;
      field1024 = 0;
      field1025 = 50;
      field1026 = new int[field1025];
      field1201 = new int[field1025];
      field1118 = new int[field1025];
      field1029 = new int[field1025];
      field1030 = new int[field1025];
      field1031 = new int[field1025];
      field1032 = new int[field1025];
      field993 = new String[field1025];
      field1034 = new int[104][104];
      field1035 = 0;
      screenY = -1;
      screenX = -1;
      field1038 = 0;
      field995 = 0;
      field1040 = 0;
      cursorState = 0;
      field1042 = 0;
      field1043 = 0;
      field1044 = 0;
      field1069 = 0;
      field1046 = 0;
      field1133 = 0;
      field1048 = false;
      field1081 = 0;
      field1050 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1053 = 0;
      field1054 = 0;
      field1055 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field1051 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1060 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1068 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field1077 = new boolean[500];
      field1047 = false;
      field969 = false;
      field1080 = -1;
      field1126 = -1;
      field973 = 0;
      field1083 = 50;
      itemSelectionState = 0;
      field1085 = null;
      spellSelected = false;
      field1087 = -1;
      field1016 = -1;
      field1089 = null;
      field1090 = null;
      widgetRoot = -1;
      componentTable = new HashTable(8);
      field1093 = 0;
      field1144 = 0;
      field1086 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1099 = -1;
      field952 = false;
      field1101 = false;
      field1102 = false;
      field1103 = null;
      field1111 = null;
      field1045 = null;
      field1106 = 0;
      field1107 = 0;
      field1108 = null;
      field1209 = false;
      field1011 = -1;
      field1182 = -1;
      field1112 = false;
      field1127 = -1;
      field1114 = -1;
      field1115 = false;
      cycleCntr = 1;
      field1022 = new int[32];
      field981 = 0;
      interfaceItemTriggers = new int[32];
      field1120 = 0;
      field1121 = new int[32];
      field1122 = 0;
      chatCycle = 0;
      field1124 = 0;
      field1125 = 0;
      field974 = 0;
      field1116 = 0;
      field1146 = 0;
      field1129 = 0;
      field1130 = new Deque();
      field1000 = new Deque();
      field1132 = new Deque();
      widgetFlags = new HashTable(512);
      field1065 = 0;
      field1071 = -2;
      field1110 = new boolean[100];
      field966 = new boolean[100];
      field1138 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1104 = 0L;
      isResized = true;
      field1147 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1148 = 0;
      field1149 = 0;
      field1150 = "";
      field1151 = new long[100];
      field1152 = 0;
      field1153 = 0;
      field1154 = new int[128];
      field1131 = new int[128];
      field1156 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1159 = -1;
      field1160 = 0;
      field1161 = new int[1000];
      field1162 = new int[1000];
      field1163 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1079 = 0;
      field1167 = 255;
      field1168 = -1;
      field1169 = false;
      field1185 = 127;
      field1171 = 127;
      field1172 = 0;
      field1173 = new int[50];
      field1174 = new int[50];
      field1001 = new int[50];
      field1176 = new int[50];
      audioEffects = new SoundEffect[50];
      field1178 = false;
      field1179 = new boolean[5];
      field1180 = new int[5];
      field1181 = new int[5];
      field1145 = new int[5];
      field1183 = new int[5];
      field1184 = 256;
      field1097 = 205;
      field1186 = 256;
      field1052 = 320;
      field1188 = 1;
      field1189 = 32767;
      field1190 = 1;
      field1191 = 32767;
      field1192 = 0;
      field1193 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1198 = 0;
      friends = new Friend[400];
      field1200 = new class196();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1078 = new PlayerComposition();
      field1204 = -1;
      field1205 = -1;
      grandExchangeOffers = new GrandExchangeOffer[8];
      field963 = new class73();
      field1208 = new int[50];
      field1203 = new int[50];
   }

   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1880731514"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         long var2 = class45.currentTimeMs();
         int var4 = (int)(var2 - class239.field3255);
         class239.field3255 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class239.field3265 += var4;
         boolean var1;
         if(class239.field3266 == 0 && class239.field3259 == 0 && class239.field3254 == 0 && class239.field3257 == 0) {
            var1 = true;
         } else if(class294.field3904 == null) {
            var1 = false;
         } else {
            try {
               label241: {
                  if(class239.field3265 > 30000) {
                     throw new IOException();
                  }

                  FileRequest var5;
                  Buffer var6;
                  while(class239.field3259 < 20 && class239.field3257 > 0) {
                     var5 = (FileRequest)class239.field3256.method3628();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class294.field3904.queueForWrite(var6.payload, 0, 4);
                     class239.field3273.put(var5, var5.hash);
                     --class239.field3257;
                     ++class239.field3259;
                  }

                  while(class239.field3266 < 20 && class239.field3254 > 0) {
                     var5 = (FileRequest)class239.field3258.peek();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class294.field3904.queueForWrite(var6.payload, 0, 4);
                     var5.unlinkDual();
                     class239.field3263.put(var5, var5.hash);
                     --class239.field3254;
                     ++class239.field3266;
                  }

                  for(int var18 = 0; var18 < 100; ++var18) {
                     int var19 = class294.field3904.available();
                     if(var19 < 0) {
                        throw new IOException();
                     }

                     if(var19 == 0) {
                        break;
                     }

                     class239.field3265 = 0;
                     byte var7 = 0;
                     if(class29.currentRequest == null) {
                        var7 = 8;
                     } else if(class239.field3260 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class239.field3261.offset;
                        if(var8 > var19) {
                           var8 = var19;
                        }

                        class294.field3904.read(class239.field3261.payload, class239.field3261.offset, var8);
                        if(class239.field3269 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class239.field3261.payload[var9 + class239.field3261.offset] ^= class239.field3269;
                           }
                        }

                        class239.field3261.offset += var8;
                        if(class239.field3261.offset < var7) {
                           break;
                        }

                        if(class29.currentRequest == null) {
                           class239.field3261.offset = 0;
                           var9 = class239.field3261.readUnsignedByte();
                           var10 = class239.field3261.readUnsignedShort();
                           int var11 = class239.field3261.readUnsignedByte();
                           var12 = class239.field3261.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           FileRequest var15 = (FileRequest)class239.field3273.get(var13);
                           CacheFile.field1774 = true;
                           if(var15 == null) {
                              var15 = (FileRequest)class239.field3263.get(var13);
                              CacheFile.field1774 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class29.currentRequest = var15;
                           BuildType.field3190 = new Buffer(var16 + var12 + class29.currentRequest.padding);
                           BuildType.field3190.putByte(var11);
                           BuildType.field3190.putInt(var12);
                           class239.field3260 = 8;
                           class239.field3261.offset = 0;
                        } else if(class239.field3260 == 0) {
                           if(class239.field3261.payload[0] == -1) {
                              class239.field3260 = 1;
                              class239.field3261.offset = 0;
                           } else {
                              class29.currentRequest = null;
                           }
                        }
                     } else {
                        var8 = BuildType.field3190.payload.length - class29.currentRequest.padding;
                        var9 = 512 - class239.field3260;
                        if(var9 > var8 - BuildType.field3190.offset) {
                           var9 = var8 - BuildType.field3190.offset;
                        }

                        if(var9 > var19) {
                           var9 = var19;
                        }

                        class294.field3904.read(BuildType.field3190.payload, BuildType.field3190.offset, var9);
                        if(class239.field3269 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              BuildType.field3190.payload[var10 + BuildType.field3190.offset] ^= class239.field3269;
                           }
                        }

                        BuildType.field3190.offset += var9;
                        class239.field3260 += var9;
                        if(var8 == BuildType.field3190.offset) {
                           if(16711935L == class29.currentRequest.hash) {
                              CollisionData.field2303 = BuildType.field3190;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var20 = class239.field3268[var10];
                                 if(var20 != null) {
                                    CollisionData.field2303.offset = var10 * 8 + 5;
                                    var12 = CollisionData.field2303.readInt();
                                    int var21 = CollisionData.field2303.readInt();
                                    var20.setInformation(var12, var21);
                                 }
                              }
                           } else {
                              class239.field3267.reset();
                              class239.field3267.update(BuildType.field3190.payload, 0, var8);
                              var10 = (int)class239.field3267.getValue();
                              if(var10 != class29.currentRequest.crc) {
                                 try {
                                    class294.field3904.close();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class239.field3270;
                                 class294.field3904 = null;
                                 class239.field3269 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label241;
                              }

                              class239.field3270 = 0;
                              class239.field3274 = 0;
                              class29.currentRequest.index.method4230((int)(class29.currentRequest.hash & 65535L), BuildType.field3190.payload, 16711680L == (class29.currentRequest.hash & 16711680L), CacheFile.field1774);
                           }

                           class29.currentRequest.unlink();
                           if(CacheFile.field1774) {
                              --class239.field3259;
                           } else {
                              --class239.field3266;
                           }

                           class239.field3260 = 0;
                           class29.currentRequest = null;
                           BuildType.field3190 = null;
                        } else {
                           if(class239.field3260 != 512) {
                              break;
                           }

                           class239.field3260 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class294.field3904.close();
               } catch (Exception var22) {
                  ;
               }

               ++class239.field3274;
               class294.field3904 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1178();
         }

      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   void method1183() {
      int var1 = class91.canvasWidth;
      int var2 = class64.canvasHeight;
      if(super.field701 < var1) {
         var1 = super.field701;
      }

      if(super.field714 < var2) {
         var2 = super.field714;
      }

      if(Buffer.preferences != null) {
         try {
            Client var3 = class87.clientInstance;
            int var4 = isResized?2:1;
            Object[] var5 = new Object[]{Integer.valueOf(var4)};
            JSObject.getWindow(var3).call("resize", var5);
         } catch (Throwable var6) {
            ;
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1663779438"
   )
   protected final void vmethod1176() {
      if(class2.chatMessages.changed()) {
         class2.chatMessages.serialize();
      }

      if(field970 != null) {
         field970.field881 = false;
      }

      field970 = null;
      if(ScriptEvent.rssocket != null) {
         ScriptEvent.rssocket.close();
         ScriptEvent.rssocket = null;
      }

      GroundObject.method2498();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      class61.field777 = null;
      if(CacheFile.soundSystem0 != null) {
         CacheFile.soundSystem0.method2028();
      }

      if(class8.soundSystem1 != null) {
         class8.soundSystem1.method2028();
      }

      class223.method4101();
      Object var9 = class237.field3239;
      synchronized(class237.field3239) {
         if(class237.field3237 != 0) {
            class237.field3237 = 1;

            try {
               class237.field3239.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }
      }

      if(class10.field264 != null) {
         class10.field264.method2946();
         class10.field264 = null;
      }

      try {
         class156.field2250.method2334();

         for(int var4 = 0; var4 < class281.field3756; ++var4) {
            class54.field685[var4].method2334();
         }

         class156.field2255.method2334();
         class156.field2253.method2334();
      } catch (Exception var7) {
         ;
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1249507264"
   )
   protected final void vmethod1350() {
      class262.field3628 = socketType == 0?'ꩊ':world + '鱀';
      WorldMapData.field472 = socketType == 0?443:world + '썐';
      class111.myWorldPort = class262.field3628;
      class8.colorsToFind = class215.field2640;
      PlayerComposition.colorsToReplace = class215.field2638;
      class64.field798 = class215.field2639;
      PlayerComposition.field2629 = class215.field2642;
      class10.field264 = new class148();
      this.method1021();
      this.method962();
      class61.field777 = this.method890();
      class228.field3151 = new IndexFile(255, class156.field2250, class156.field2255, 500000);
      Buffer.preferences = class1.method0();
      this.method955();
      class229.method4118(this, MessageNode.field888);
      if(socketType != 0) {
         displayFps = true;
      }

      int var1 = Buffer.preferences.screenType;
      field1104 = 0L;
      if(var1 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      if(class41.method595() == 1) {
         class87.clientInstance.method888(765, 503);
      } else {
         class87.clientInstance.method888(7680, 2160);
      }

      if(gameState >= 25) {
         class17.method144();
      }

   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1241868663"
   )
   final void method1189(boolean var1) {
      int var2 = widgetRoot;
      int var3 = class91.canvasWidth;
      int var4 = class64.canvasHeight;
      if(class13.loadWidget(var2)) {
         class5.method11(class268.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-127"
   )
   @Export("error")
   void error(int var1) {
      socket = null;
      IndexDataBase.rssocket = null;
      js5State = 0;
      if(class262.field3628 == class111.myWorldPort) {
         class111.myWorldPort = WorldMapData.field472;
      } else {
         class111.myWorldPort = class262.field3628;
      }

      ++field945;
      if(field945 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field1155 = 3000;
         }
      } else if(field945 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field945 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field1155 = 3000;
         }
      }

   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1626423477"
   )
   final boolean method1187() {
      int var1 = class51.method817();
      if(menuOptionCount > 2) {
         if(field1068 != 1 || field1077[var1]) {
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

            if(!var2) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1378790770"
   )
   protected final void vmethod1171() {
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "10642"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(ScriptEvent.rssocket == null) {
         return false;
      } else {
         int var3;
         String var25;
         try {
            int var1 = ScriptEvent.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = RUNELITE_PACKET?-2:class273.field3686[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field990 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId * -1;
            lastFrameId = packetType * -1;
            int var2;
            if(packetType == (RUNELITE_PACKET?0:171)) {
               field1178 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field1179[var2] = false;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?1:233)) {
               field1198 = 1;
               field1124 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?2:20)) {
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

            if(packetType == (RUNELITE_PACKET?3:2)) {
               class95.field1507 = 0;

               for(var2 = 0; var2 < 2048; ++var2) {
                  class95.field1506[var2] = null;
                  class95.field1513[var2] = 1;
               }

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               class183.initializeGPI(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?4:200)) {
               for(var2 = 0; var2 < VarPlayerType.field3291; ++var2) {
                  VarPlayerType var109 = class36.method520(var2);
                  if(var109 != null) {
                     class212.settings[var2] = 0;
                     class212.widgetSettings[var2] = 0;
                  }
               }

               class9.method54();
               field981 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?5:104)) {
               class35.method518();
               packetType = -1;
               return false;
            }

            int var5;
            int var6;
            int var11;
            int var14;
            int var72;
            int var82;
            String var89;
            if(packetType == (RUNELITE_PACKET?6:239)) {
               PacketBuffer var114 = secretPacketBuffer2;
               var3 = packetLength;
               ClassInfo var118 = new ClassInfo();
               var118.count = var114.readUnsignedByte();
               var118.field3749 = var114.readInt();
               var118.type = new int[var118.count];
               var118.errorIdentifiers = new int[var118.count];
               var118.fields = new Field[var118.count];
               var118.field3748 = new int[var118.count];
               var118.methods = new Method[var118.count];
               var118.args = new byte[var118.count][][];

               for(var5 = 0; var5 < var118.count; ++var5) {
                  try {
                     var6 = var114.readUnsignedByte();
                     String var115;
                     if(var6 != 0 && var6 != 1 && var6 != 2) {
                        if(var6 == 3 || var6 == 4) {
                           var89 = var114.readString();
                           var115 = var114.readString();
                           var72 = var114.readUnsignedByte();
                           String[] var77 = new String[var72];

                           for(var11 = 0; var11 < var72; ++var11) {
                              var77[var11] = var114.readString();
                           }

                           String var102 = var114.readString();
                           byte[][] var79 = new byte[var72][];
                           if(var6 == 3) {
                              for(var82 = 0; var82 < var72; ++var82) {
                                 var14 = var114.readInt();
                                 var79[var82] = new byte[var14];
                                 var114.readBytes(var79[var82], 0, var14);
                              }
                           }

                           var118.type[var5] = var6;
                           Class[] var111 = new Class[var72];

                           for(var14 = 0; var14 < var72; ++var14) {
                              var111[var14] = class39.method571(var77[var14]);
                           }

                           Class var116 = class39.method571(var102);
                           if(class39.method571(var89).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var81 = class39.method571(var89).getDeclaredMethods();
                           Method[] var16 = var81;

                           for(int var17 = 0; var17 < var16.length; ++var17) {
                              Method var18 = var16[var17];
                              if(Reflection.getMethodName(var18).equals(var115)) {
                                 Class[] var19 = Reflection.getParameterTypes(var18);
                                 if(var111.length == var19.length) {
                                    boolean var20 = true;

                                    for(int var21 = 0; var21 < var111.length; ++var21) {
                                       if(var19[var21] != var111[var21]) {
                                          var20 = false;
                                          break;
                                       }
                                    }

                                    if(var20 && var116 == var18.getReturnType()) {
                                       var118.methods[var5] = var18;
                                    }
                                 }
                              }
                           }

                           var118.args[var5] = var79;
                        }
                     } else {
                        var89 = var114.readString();
                        var115 = var114.readString();
                        var72 = 0;
                        if(var6 == 1) {
                           var72 = var114.readInt();
                        }

                        var118.type[var5] = var6;
                        var118.field3748[var5] = var72;
                        if(class39.method571(var89).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var118.fields[var5] = Reflection.findField(class39.method571(var89), var115);
                     }
                  } catch (ClassNotFoundException var60) {
                     var118.errorIdentifiers[var5] = -1;
                  } catch (SecurityException var61) {
                     var118.errorIdentifiers[var5] = -2;
                  } catch (NullPointerException var62) {
                     var118.errorIdentifiers[var5] = -3;
                  } catch (Exception var63) {
                     var118.errorIdentifiers[var5] = -4;
                  } catch (Throwable var64) {
                     var118.errorIdentifiers[var5] = -5;
                  }
               }

               class281.field3757.method3638(var118);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?7:168)) {
               for(var2 = 0; var2 < class212.widgetSettings.length; ++var2) {
                  if(class212.widgetSettings[var2] != class212.settings[var2]) {
                     class212.widgetSettings[var2] = class212.settings[var2];
                     WorldMapType1.method301(var2);
                     field1022[++field981 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?8:39)) {
               class43.method644(secretPacketBuffer2, packetLength);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?9:17)) {
               if(widgetRoot != -1) {
                  var2 = widgetRoot;
                  if(class13.loadWidget(var2)) {
                     ScriptEvent.method1133(class268.widgets[var2], 0);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?10:101)) {
               field1079 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?11:65)) {
               field1059 = secretPacketBuffer2.readUnsignedShort() * 30;
               field1146 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?12:52)) {
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var3 = secretPacketBuffer2.readUnsignedByte();
               }

               class277[] var117 = new class277[]{class277.field3736, class277.field3737, class277.field3735};
               class277[] var91 = var117;
               var6 = 0;

               class277 var106;
               while(true) {
                  if(var6 >= var91.length) {
                     var106 = null;
                     break;
                  }

                  class277 var90 = var91[var6];
                  if(var3 == var90.field3738) {
                     var106 = var90;
                     break;
                  }

                  ++var6;
               }

               class13.field293 = var106;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?13:210)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3293();
               }

               World.field1297 = GameEngine.taskManager.createHost(var2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?14:230)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3282();
               }

               if(var2 == '\uffff') {
                  var2 = -1;
               }

               class148.method2956(var2);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?15:209)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readUnsignedShort();
               }

               class1.method1(var2);
               interfaceItemTriggers[++field1120 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            int var4;
            Widget var105;
            if(packetType == (RUNELITE_PACKET?16:251)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3291();
               }

               var105 = GZipDecompressor.method3177(var2);

               for(var4 = 0; var4 < var105.itemIds.length; ++var4) {
                  var105.itemIds[var4] = -1;
                  var105.itemIds[var4] = 0;
               }

               class7.method34(var105);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?17:249)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
               }

               var105 = GZipDecompressor.method3177(var2);
               var105.modelType = 3;
               var105.modelId = Player.localPlayer.composition.method4002();
               class7.method34(var105);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?18:231)) {
               class9.method54();
               weight = secretPacketBuffer2.readShort();
               field1146 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?19:186)) {
               class9.method54();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1146 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?20:112)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.readInt();
               }

               WidgetNode var103 = (WidgetNode)componentTable.get((long)var2);
               if(var103 != null) {
                  MessageNode.method1143(var103, true);
               }

               if(field1086 != null) {
                  class7.method34(field1086);
                  field1086 = null;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?21:90)) {
               if(RUNELITE_PACKET) {
                  var2 = secretPacketBuffer2.runeliteReadInt();
               } else {
                  var2 = secretPacketBuffer2.method3282();
               }

               widgetRoot = var2;
               this.method1189(false);
               IndexDataBase.method4169(var2);
               GameEngine.method907(widgetRoot);

               for(var3 = 0; var3 < 100; ++var3) {
                  field1110[var3] = true;
               }

               packetType = -1;
               return true;
            }

            String var22;
            String var26;
            long var34;
            int var40;
            int var43;
            String var83;
            String var97;
            int var119;
            if(packetType == (RUNELITE_PACKET?22:121)) {
               if(RUNELITE_PACKET) {
                  var25 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var25 = secretPacketBuffer2.readString();
               }

               class25.sessionToken = var25;

               try {
                  var26 = class87.clientInstance.getParameter(Parameters.field3726.key);
                  var22 = class87.clientInstance.getParameter(Parameters.field3714.key);
                  var83 = var26 + "settings=" + var25 + "; version=1; path=/; domain=" + var22;
                  if(var25.length() == 0) {
                     var83 = var83 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var97 = var83 + "; Expires=";
                     var34 = class45.currentTimeMs() + 94608000000L;
                     class183.field2448.setTime(new Date(var34));
                     var40 = class183.field2448.get(7);
                     var11 = class183.field2448.get(5);
                     var119 = class183.field2448.get(2);
                     var82 = class183.field2448.get(1);
                     var14 = class183.field2448.get(11);
                     int var42 = class183.field2448.get(12);
                     var43 = class183.field2448.get(13);
                     var89 = class183.field2446[var40 - 1] + ", " + var11 / 10 + var11 % 10 + "-" + class183.field2445[0][var119] + "-" + var82 + " " + var14 / 10 + var14 % 10 + ":" + var42 / 10 + var42 % 10 + ":" + var43 / 10 + var43 % 10 + " GMT";
                     var83 = var97 + var89 + "; Max-Age=" + 94608000L;
                  }

                  class52.method818(class87.clientInstance, "document.cookie=\"" + var83 + "\"");
               } catch (Throwable var58) {
                  ;
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?23:74)) {
               if(RUNELITE_PACKET) {
                  var25 = secretPacketBuffer2.runeliteReadString();
               } else {
                  var25 = secretPacketBuffer2.readString();
               }

               var26 = FontTypeFace.appendTags(class61.method1100(class165.method3151(secretPacketBuffer2)));
               sendGameMessage(6, var25, var26);
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?24:252)) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.checkCrc()) {
                  WorldMapType3.method237(secretPacketBuffer2, secretPacketBuffer2.offset - 28);
               }

               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?25:218)) {
               byte var104;
               if(RUNELITE_PACKET) {
                  var3 = secretPacketBuffer2.runeliteReadInt();
                  var104 = secretPacketBuffer2.runeliteReadByte();
               } else {
                  var104 = secretPacketBuffer2.method3277();
                  var3 = secretPacketBuffer2.method3309();
               }

               class212.settings[var3] = var104;
               if(class212.widgetSettings[var3] != var104) {
                  class212.widgetSettings[var3] = var104;
               }

               WorldMapType1.method301(var3);
               field1022[++field981 - 1 & 31] = var3;
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?26:97)) {
               class37.field529 = secretPacketBuffer2.readUnsignedByte();
               class21.field353 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == (RUNELITE_PACKET?27:131)) {
               field1148 = secretPacketBuffer2.readUnsignedByte();
               field1149 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType != 243 && packetType != 170 && packetType != 37 && packetType != 157 && packetType != 28 && packetType != 56 && packetType != 0 && packetType != 136 && packetType != 184) {
               if(packetType == (RUNELITE_PACKET?28:166)) {
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

               if(packetType == (RUNELITE_PACKET?29:161)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3283();
                     var3 = secretPacketBuffer2.method3309();
                  }

                  if(var3 == '\uffff') {
                     var3 = -1;
                  }

                  class9.method55(var3, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?30:89)) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  if(secretPacketBuffer2.readUnsignedByte() == 0) {
                     grandExchangeOffers[var2] = new GrandExchangeOffer();
                     secretPacketBuffer2.offset += 18;
                  } else {
                     --secretPacketBuffer2.offset;
                     grandExchangeOffers[var2] = new GrandExchangeOffer(secretPacketBuffer2, false);
                  }

                  field974 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               long var36;
               if(packetType == (RUNELITE_PACKET?31:46)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readInt();
                     var3 = secretPacketBuffer2.readInt();
                  }

                  var5 = 0;
                  if(class9.field254 == null || !class9.field254.isValid()) {
                     try {
                        Iterator var107 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                        while(var107.hasNext()) {
                           GarbageCollectorMXBean var88 = (GarbageCollectorMXBean)var107.next();
                           if(var88.isValid()) {
                              class9.field254 = var88;
                              GameEngine.field734 = -1L;
                              GameEngine.field733 = -1L;
                           }
                        }
                     } catch (Throwable var59) {
                        ;
                     }
                  }

                  if(class9.field254 != null) {
                     long var32 = class45.currentTimeMs();
                     var34 = class9.field254.getCollectionTime();
                     if(GameEngine.field733 != -1L) {
                        var36 = var34 - GameEngine.field733;
                        long var38 = var32 - GameEngine.field734;
                        if(0L != var38) {
                           var5 = (int)(100L * var36 / var38);
                        }
                     }

                     GameEngine.field733 = var34;
                     GameEngine.field734 = var32;
                  }

                  secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_STATISTICS);
                  secretPacketBuffer1.putLEInt(GameEngine.FPS);
                  secretPacketBuffer1.putLEShortA(var2);
                  secretPacketBuffer1.putLEShortA(var3);
                  secretPacketBuffer1.method3410(var5);
                  packetType = -1;
                  return true;
               }

               boolean var69;
               Widget var84;
               if(packetType == (RUNELITE_PACKET?32:84)) {
                  var2 = secretPacketBuffer2.method3292();
                  var69 = secretPacketBuffer2.method3391() == 1;
                  var84 = GZipDecompressor.method3177(var2);
                  if(var69 != var84.isHidden) {
                     var84.isHidden = var69;
                     class7.method34(var84);
                  }

                  packetType = -1;
                  return true;
               }

               int var7;
               if(packetType == (RUNELITE_PACKET?33:235)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3293();
                     var3 = secretPacketBuffer2.method3451();
                  }

                  var4 = var3 >> 10 & 31;
                  var5 = var3 >> 5 & 31;
                  var6 = var3 & 31;
                  var7 = (var5 << 11) + (var4 << 19) + (var6 << 3);
                  Widget var112 = GZipDecompressor.method3177(var2);
                  if(var7 != var112.textColor) {
                     var112.textColor = var7;
                     class7.method34(var112);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?34:135)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3285();
                     var3 = secretPacketBuffer2.readInt();
                  }

                  var84 = GZipDecompressor.method3177(var3);
                  if(var2 != var84.field2783 || var2 == -1) {
                     var84.field2783 = var2;
                     var84.field2780 = 0;
                     var84.field2734 = 0;
                     class7.method34(var84);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?35:226)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3291();
                     var3 = secretPacketBuffer2.readUnsignedShort();
                  }

                  var84 = GZipDecompressor.method3177(var2);
                  if(var84.modelType != 2 || var3 != var84.modelId) {
                     var84.modelType = 2;
                     var84.modelId = var3;
                     class7.method34(var84);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?36:57)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3293();
                     var3 = secretPacketBuffer2.method3451();
                  }

                  var84 = GZipDecompressor.method3177(var2);
                  if(var84.modelType != 1 || var3 != var84.modelId) {
                     var84.modelType = 1;
                     var84.modelId = var3;
                     class7.method34(var84);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?37:187)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3309();
                     var3 = secretPacketBuffer2.readInt();
                  }

                  var84 = GZipDecompressor.method3177(var3);
                  if(var84 != null && var84.type == 0) {
                     if(var2 > var84.scrollHeight - var84.height) {
                        var2 = var84.scrollHeight - var84.height;
                     }

                     if(var2 < 0) {
                        var2 = 0;
                     }

                     if(var2 != var84.scrollY) {
                        var84.scrollY = var2;
                        class7.method34(var84);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?40:144)) {
                  class21.field353 = secretPacketBuffer2.readUnsignedShortOb1();
                  class37.field529 = secretPacketBuffer2.readUnsignedShortOb1();

                  for(var2 = class21.field353; var2 < class21.field353 + 8; ++var2) {
                     for(var3 = class37.field529; var3 < class37.field529 + 8; ++var3) {
                        if(groundItemDeque[class27.plane][var2][var3] != null) {
                           groundItemDeque[class27.plane][var2][var3] = null;
                           class204.groundItemSpawned(var2, var3);
                        }
                     }
                  }

                  for(PendingSpawn var93 = (PendingSpawn)pendingSpawns.getFront(); var93 != null; var93 = (PendingSpawn)pendingSpawns.getNext()) {
                     if(var93.x >= class21.field353 && var93.x < class21.field353 + 8 && var93.y >= class37.field529 && var93.y < class37.field529 + 8 && var93.level == class27.plane) {
                        var93.hitpoints = 0;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?41:177)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     var3 = secretPacketBuffer2.method3293();
                  }

                  class212.settings[var2] = var3;
                  if(class212.widgetSettings[var2] != var3) {
                     class212.widgetSettings[var2] = var3;
                  }

                  WorldMapType1.method301(var2);
                  field1022[++field981 - 1 & 31] = var2;
                  packetType = -1;
                  return true;
               }

               WidgetNode var23;
               Widget var98;
               if(packetType == (RUNELITE_PACKET?42:236)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3291();
                     var3 = secretPacketBuffer2.method3292();
                  }

                  WidgetNode var113 = (WidgetNode)componentTable.get((long)var3);
                  var23 = (WidgetNode)componentTable.get((long)var2);
                  if(var23 != null) {
                     MessageNode.method1143(var23, var113 == null || var23.id != var113.id);
                  }

                  if(var113 != null) {
                     var113.unlink();
                     componentTable.put(var113, (long)var2);
                  }

                  var98 = GZipDecompressor.method3177(var3);
                  if(var98 != null) {
                     class7.method34(var98);
                  }

                  var98 = GZipDecompressor.method3177(var2);
                  if(var98 != null) {
                     class7.method34(var98);
                     class64.method1114(class268.widgets[var98.id >>> 16], var98, true);
                  }

                  if(widgetRoot != -1) {
                     var7 = widgetRoot;
                     if(class13.loadWidget(var7)) {
                        ScriptEvent.method1133(class268.widgets[var7], 1);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               boolean var67;
               if(packetType == (RUNELITE_PACKET?43:68)) {
                  var67 = secretPacketBuffer2.readUnsignedByte() == 1;
                  if(var67) {
                     class19.field334 = class45.currentTimeMs() - secretPacketBuffer2.readLong();
                     ISAACCipher.field2441 = new class13(secretPacketBuffer2, true);
                  } else {
                     ISAACCipher.field2441 = null;
                  }

                  field1116 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?44:53)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var26 = secretPacketBuffer2.runeliteReadString();
                  } else {
                     var2 = secretPacketBuffer2.method3293();
                     var26 = secretPacketBuffer2.readString();
                  }

                  var84 = GZipDecompressor.method3177(var2);
                  if(!var26.equals(var84.text)) {
                     var84.text = var26;
                     class7.method34(var84);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?45:254)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var4 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(field1185 != 0 && var3 != 0 && field1172 < 50) {
                     field1173[field1172] = var2;
                     field1174[field1172] = var3;
                     field1001[field1172] = var4;
                     audioEffects[field1172] = null;
                     field1176[field1172] = 0;
                     ++field1172;
                  }

                  packetType = -1;
                  return true;
               }

               Widget var85;
               if(packetType == (RUNELITE_PACKET?47:141)) {
                  if(RUNELITE_PACKET) {
                     var4 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3451();
                     var3 = secretPacketBuffer2.method3282();
                     var4 = secretPacketBuffer2.method3291();
                  }

                  var85 = GZipDecompressor.method3177(var4);
                  var85.field2714 = var3 + (var2 << 16);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?49:164)) {
                  if(RUNELITE_PACKET) {
                     var4 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     class9.method54();
                  } else {
                     class9.method54();
                     var2 = secretPacketBuffer2.method3391();
                     var3 = secretPacketBuffer2.method3292();
                     var4 = secretPacketBuffer2.method3391();
                  }

                  skillExperiences[var4] = var3;
                  boostedSkillLevels[var4] = var2;
                  realSkillLevels[var4] = 1;

                  for(var5 = 0; var5 < 98; ++var5) {
                     if(var3 >= class223.field2847[var5]) {
                        realSkillLevels[var4] = var5 + 2;
                     }
                  }

                  field1121[++field1122 - 1 & 31] = var4;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?50:70)) {
                  if(RUNELITE_PACKET) {
                     var4 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readShort();
                     var3 = secretPacketBuffer2.method3285();
                     var4 = secretPacketBuffer2.readInt();
                  }

                  var85 = GZipDecompressor.method3177(var4);
                  if(var2 != var85.originalX || var3 != var85.originalY || var85.field2663 != 0 || var85.field2664 != 0) {
                     var85.originalX = var2;
                     var85.originalY = var3;
                     var85.field2663 = 0;
                     var85.field2664 = 0;
                     class7.method34(var85);
                     this.method1426(var85);
                     if(var85.type == 0) {
                        class64.method1114(class268.widgets[var4 >> 16], var85, false);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?51:34)) {
                  var2 = secretPacketBuffer2.method3309();
                  if(var2 == '\uffff') {
                     var2 = -1;
                  }

                  var3 = secretPacketBuffer2.method3293();
                  var4 = secretPacketBuffer2.method3293();
                  var85 = GZipDecompressor.method3177(var4);
                  ItemComposition var101;
                  if(!var85.hasScript) {
                     if(var2 == -1) {
                        var85.modelType = 0;
                        packetType = -1;
                        return true;
                     }

                     var101 = class169.getItemDefinition(var2);
                     var85.modelType = 4;
                     var85.modelId = var2;
                     var85.rotationX = var101.xan2d;
                     var85.rotationZ = var101.yan2d;
                     var85.modelZoom = var101.zoom2d * 100 / var3;
                     class7.method34(var85);
                  } else {
                     var85.itemId = var2;
                     var85.itemQuantity = var3;
                     var101 = class169.getItemDefinition(var2);
                     var85.rotationX = var101.xan2d;
                     var85.rotationZ = var101.yan2d;
                     var85.rotationY = var101.zan2d;
                     var85.field2707 = var101.offsetX2d;
                     var85.field2647 = var101.offsetY2d;
                     var85.modelZoom = var101.zoom2d;
                     if(var101.isStackable == 1) {
                        var85.field2716 = 1;
                     } else {
                        var85.field2716 = 2;
                     }

                     if(var85.field2713 > 0) {
                        var85.modelZoom = var85.modelZoom * 32 / var85.field2713;
                     } else if(var85.originalWidth > 0) {
                        var85.modelZoom = var85.modelZoom * 32 / var85.originalWidth;
                     }

                     class7.method34(var85);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?53:191)) {
                  if(RUNELITE_PACKET) {
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3276();
                     var3 = secretPacketBuffer2.method3292();
                     var4 = secretPacketBuffer2.readUnsignedShort();
                  }

                  var23 = (WidgetNode)componentTable.get((long)var3);
                  if(var23 != null) {
                     MessageNode.method1143(var23, var4 != var23.id);
                  }

                  class82.method1644(var3, var4, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?54:64)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var22 = secretPacketBuffer2.runeliteReadString();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3276();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var22 = secretPacketBuffer2.readString();
                  }

                  if(var2 >= 1 && var2 <= 8) {
                     if(var22.equalsIgnoreCase("null")) {
                        var22 = null;
                     }

                     playerOptions[var2 - 1] = var22;
                     playerOptionsPriorities[var2 - 1] = var3 == 0;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?55:105)) {
                  World var92 = new World();
                  var92.address = secretPacketBuffer2.readString();
                  var92.id = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.readInt();
                  var92.mask = var3;
                  WorldMapType2.setGameState(45);
                  ScriptEvent.rssocket.close();
                  ScriptEvent.rssocket = null;
                  DynamicObject.method1864(var92);
                  packetType = -1;
                  return false;
               }

               boolean var68;
               int var70;
               if(packetType == (RUNELITE_PACKET?56:207)) {
                  var25 = secretPacketBuffer2.readString();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  byte var71 = secretPacketBuffer2.readByte();
                  var68 = false;
                  if(var71 == -128) {
                     var68 = true;
                  }

                  if(var68) {
                     if(class13.clanChatCount == 0) {
                        packetType = -1;
                        return true;
                     }

                     boolean var73 = false;

                     for(var6 = 0; var6 < class13.clanChatCount && (!class223.clanMembers[var6].username.equals(var25) || var3 != class223.clanMembers[var6].world); ++var6) {
                        ;
                     }

                     if(var6 < class13.clanChatCount) {
                        while(var6 < class13.clanChatCount - 1) {
                           class223.clanMembers[var6] = class223.clanMembers[var6 + 1];
                           ++var6;
                        }

                        --class13.clanChatCount;
                        class223.clanMembers[class13.clanChatCount] = null;
                     }
                  } else {
                     secretPacketBuffer2.readString();
                     ClanMember var99 = new ClanMember();
                     var99.username = var25;
                     var99.field932 = Frames.method2925(var99.username, class8.field243);
                     var99.world = var3;
                     var99.rank = var71;

                     for(var7 = class13.clanChatCount - 1; var7 >= 0; --var7) {
                        var70 = class223.clanMembers[var7].field932.compareTo(var99.field932);
                        if(var70 == 0) {
                           class223.clanMembers[var7].world = var3;
                           class223.clanMembers[var7].rank = var71;
                           if(var25.equals(Player.localPlayer.name)) {
                              class35.clanChatRank = var71;
                           }

                           field1125 = cycleCntr;
                           packetType = -1;
                           return true;
                        }

                        if(var70 < 0) {
                           break;
                        }
                     }

                     if(class13.clanChatCount >= class223.clanMembers.length) {
                        packetType = -1;
                        return true;
                     }

                     for(var70 = class13.clanChatCount - 1; var70 > var7; --var70) {
                        class223.clanMembers[var70 + 1] = class223.clanMembers[var70];
                     }

                     if(class13.clanChatCount == 0) {
                        class223.clanMembers = new ClanMember[100];
                     }

                     class223.clanMembers[var7 + 1] = var99;
                     ++class13.clanChatCount;
                     if(var25.equals(Player.localPlayer.name)) {
                        class35.clanChatRank = var71;
                     }
                  }

                  field1125 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?57:24)) {
                  if(RUNELITE_PACKET) {
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var4 = secretPacketBuffer2.runeliteReadInt();
                     var5 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var3 = secretPacketBuffer2.readUnsignedByte();
                     var4 = secretPacketBuffer2.readUnsignedByte();
                     var5 = secretPacketBuffer2.readUnsignedByte();
                  }

                  field1179[var2] = true;
                  field1180[var2] = var3;
                  field1181[var2] = var4;
                  field1145[var2] = var5;
                  field1183[var2] = 0;
                  packetType = -1;
                  return true;
               }

               long var48;
               if(packetType == (RUNELITE_PACKET?60:29)) {
                  var2 = secretPacketBuffer2.method3451();
                  if(var2 == '\uffff') {
                     var2 = -1;
                  }

                  var3 = secretPacketBuffer2.method3309();
                  if(var3 == '\uffff') {
                     var3 = -1;
                  }

                  var4 = secretPacketBuffer2.method3292();
                  var5 = secretPacketBuffer2.method3291();

                  for(var6 = var3; var6 <= var2; ++var6) {
                     var48 = ((long)var4 << 32) + (long)var6;
                     Node var120 = widgetFlags.get(var48);
                     if(var120 != null) {
                        var120.unlink();
                     }

                     widgetFlags.put(new IntegerNode(var5), var48);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?61:197)) {
                  if(RUNELITE_PACKET) {
                     var4 = secretPacketBuffer2.runeliteReadInt();
                     var2 = secretPacketBuffer2.runeliteReadInt();
                     var3 = secretPacketBuffer2.runeliteReadInt();
                     var5 = secretPacketBuffer2.runeliteReadInt();
                  } else {
                     var2 = secretPacketBuffer2.method3451();
                     var3 = secretPacketBuffer2.method3451();
                     var4 = secretPacketBuffer2.method3292();
                     var5 = secretPacketBuffer2.method3282();
                  }

                  var98 = GZipDecompressor.method3177(var4);
                  if(var3 != var98.rotationX || var5 != var98.rotationZ || var2 != var98.modelZoom) {
                     var98.rotationX = var3;
                     var98.rotationZ = var5;
                     var98.modelZoom = var2;
                     class7.method34(var98);
                  }

                  packetType = -1;
                  return true;
               }

               String var15;
               long var44;
               long var46;
               if(packetType == (RUNELITE_PACKET?63:222)) {
                  var25 = secretPacketBuffer2.readString();
                  var44 = (long)secretPacketBuffer2.readUnsignedShort();
                  var46 = (long)secretPacketBuffer2.read24BitInt();
                  Permission[] var87 = new Permission[]{Permission.field3175, Permission.field3174, Permission.field3177, Permission.field3179, Permission.field3178, Permission.field3181};
                  Permission var110 = (Permission)class88.forOrdinal(var87, secretPacketBuffer2.readUnsignedByte());
                  long var55 = var46 + (var44 << 32);
                  boolean var78 = false;

                  for(var119 = 0; var119 < 100; ++var119) {
                     if(field1151[var119] == var55) {
                        var78 = true;
                        break;
                     }
                  }

                  if(class24.isIgnored(var25)) {
                     var78 = true;
                  }

                  if(!var78 && field1050 == 0) {
                     field1151[field1152] = var55;
                     field1152 = (field1152 + 1) % 100;
                     String var12 = FontTypeFace.appendTags(class61.method1100(class165.method3151(secretPacketBuffer2)));
                     byte var80;
                     if(var110.field3182) {
                        var80 = 7;
                     } else {
                        var80 = 3;
                     }

                     if(var110.field3176 != -1) {
                        var43 = var110.field3176;
                        var15 = "<img=" + var43 + ">";
                        sendGameMessage(var80, var15 + var25, var12);
                     } else {
                        sendGameMessage(var80, var25, var12);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?64:145)) {
                  var2 = secretPacketBuffer2.getUSmart();
                  var69 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var22 = "";
                  var68 = false;
                  if(var69) {
                     var22 = secretPacketBuffer2.readString();
                     if(class24.isIgnored(var22)) {
                        var68 = true;
                     }
                  }

                  var97 = secretPacketBuffer2.readString();
                  if(!var68) {
                     sendGameMessage(var2, var22, var97);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?65:129)) {
                  var25 = secretPacketBuffer2.readString();
                  Object[] var94 = new Object[var25.length() + 1];

                  for(var4 = var25.length() - 1; var4 >= 0; --var4) {
                     if(var25.charAt(var4) == 115) {
                        var94[var4 + 1] = secretPacketBuffer2.readString();
                     } else {
                        var94[var4 + 1] = new Integer(secretPacketBuffer2.readInt());
                     }
                  }

                  var94[0] = new Integer(secretPacketBuffer2.readInt());
                  ScriptEvent var95 = new ScriptEvent();
                  var95.field864 = var94;
                  class153.method3002(var95);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?66:78)) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var2 = secretPacketBuffer2.readUnsignedByte();
                     var69 = (var2 & 1) == 1;
                     var22 = secretPacketBuffer2.readString();
                     var83 = secretPacketBuffer2.readString();
                     secretPacketBuffer2.readString();

                     for(var6 = 0; var6 < ignoreCount; ++var6) {
                        Ignore var86 = ignores[var6];
                        if(var69) {
                           if(var83.equals(var86.name)) {
                              var86.name = var22;
                              var86.previousName = var83;
                              var22 = null;
                              break;
                           }
                        } else if(var22.equals(var86.name)) {
                           var86.name = var22;
                           var86.previousName = var83;
                           var22 = null;
                           break;
                        }
                     }

                     if(var22 != null && ignoreCount < 400) {
                        Ignore var96 = new Ignore();
                        ignores[ignoreCount] = var96;
                        var96.name = var22;
                        var96.previousName = var83;
                        ++ignoreCount;
                     }
                  }

                  field1124 = cycleCntr;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?67:63)) {
                  field1178 = true;
                  class271.field3678 = secretPacketBuffer2.readUnsignedByte();
                  class87.field1393 = secretPacketBuffer2.readUnsignedByte();
                  GroundObject.field1881 = secretPacketBuffer2.readUnsignedShort();
                  class86.field1392 = secretPacketBuffer2.readUnsignedByte();
                  class9.field250 = secretPacketBuffer2.readUnsignedByte();
                  if(class9.field250 >= 100) {
                     class82.cameraX = class271.field3678 * 128 + 64;
                     class158.cameraY = class87.field1393 * 128 + 64;
                     Ignore.cameraZ = class227.getTileHeight(class82.cameraX, class158.cameraY, class27.plane) - GroundObject.field1881;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?68:179)) {
                  field1178 = true;
                  class89.field1421 = secretPacketBuffer2.readUnsignedByte();
                  ItemContainer.field790 = secretPacketBuffer2.readUnsignedByte();
                  class169.field2340 = secretPacketBuffer2.readUnsignedShort();
                  class64.field812 = secretPacketBuffer2.readUnsignedByte();
                  MilliTimer.field2218 = secretPacketBuffer2.readUnsignedByte();
                  if(MilliTimer.field2218 >= 100) {
                     var2 = class89.field1421 * 128 + 64;
                     var3 = ItemContainer.field790 * 128 + 64;
                     var4 = class227.getTileHeight(var2, var3, class27.plane) - class169.field2340;
                     var5 = var2 - class82.cameraX;
                     var6 = var4 - Ignore.cameraZ;
                     var7 = var3 - class158.cameraY;
                     var70 = (int)Math.sqrt((double)(var7 * var7 + var5 * var5));
                     Friend.cameraPitch = (int)(Math.atan2((double)var6, (double)var70) * 325.949D) & 2047;
                     Ignore.cameraYaw = (int)(Math.atan2((double)var5, (double)var7) * -325.949D) & 2047;
                     if(Friend.cameraPitch < 128) {
                        Friend.cameraPitch = 128;
                     }

                     if(Friend.cameraPitch > 383) {
                        Friend.cameraPitch = 383;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               long var51;
               if(packetType == (RUNELITE_PACKET?69:128)) {
                  var25 = secretPacketBuffer2.readString();
                  var44 = secretPacketBuffer2.readLong();
                  var46 = (long)secretPacketBuffer2.readUnsignedShort();
                  var48 = (long)secretPacketBuffer2.read24BitInt();
                  Permission[] var50 = new Permission[]{Permission.field3175, Permission.field3174, Permission.field3177, Permission.field3179, Permission.field3178, Permission.field3181};
                  Permission var76 = (Permission)class88.forOrdinal(var50, secretPacketBuffer2.readUnsignedByte());
                  var51 = var48 + (var46 << 32);
                  boolean var13 = false;

                  for(var14 = 0; var14 < 100; ++var14) {
                     if(var51 == field1151[var14]) {
                        var13 = true;
                        break;
                     }
                  }

                  if(var76.field3183 && class24.isIgnored(var25)) {
                     var13 = true;
                  }

                  if(!var13 && field1050 == 0) {
                     field1151[field1152] = var51;
                     field1152 = (field1152 + 1) % 100;
                     String var31 = FontTypeFace.appendTags(class61.method1100(class165.method3151(secretPacketBuffer2)));
                     if(var76.field3176 != -1) {
                        var43 = var76.field3176;
                        var15 = "<img=" + var43 + ">";
                        class29.addChatMessage(9, var15 + var25, var31, class252.method4440(var44));
                     } else {
                        class29.addChatMessage(9, var25, var31, class252.method4440(var44));
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?70:107)) {
                  field958 = secretPacketBuffer2.readUnsignedByte();
                  if(field958 == 1) {
                     field959 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(field958 >= 2 && field958 <= 6) {
                     if(field958 == 2) {
                        field987 = 64;
                        field965 = 64;
                     }

                     if(field958 == 3) {
                        field987 = 0;
                        field965 = 64;
                     }

                     if(field958 == 4) {
                        field987 = 128;
                        field965 = 64;
                     }

                     if(field958 == 5) {
                        field987 = 64;
                        field965 = 0;
                     }

                     if(field958 == 6) {
                        field987 = 64;
                        field965 = 128;
                     }

                     field958 = 2;
                     hintArrowX = secretPacketBuffer2.readUnsignedShort();
                     hintArrowY = secretPacketBuffer2.readUnsignedShort();
                     hintArrowType = secretPacketBuffer2.readUnsignedByte();
                  }

                  if(field958 == 10) {
                     field960 = secretPacketBuffer2.readUnsignedShort();
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?71:98)) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var84 = GZipDecompressor.method3177(var2);
                  } else {
                     var84 = null;
                  }

                  if(var84 != null) {
                     for(var5 = 0; var5 < var84.itemIds.length; ++var5) {
                        var84.itemIds[var5] = 0;
                        var84.itemQuantities[var5] = 0;
                     }
                  }

                  VertexNormal.method2613(var3);
                  var5 = secretPacketBuffer2.readUnsignedShort();

                  for(var6 = 0; var6 < var5; ++var6) {
                     var7 = secretPacketBuffer2.readUnsignedShort();
                     var70 = secretPacketBuffer2.method3276();
                     if(var70 == 255) {
                        var70 = secretPacketBuffer2.method3293();
                     }

                     if(var84 != null && var6 < var84.itemIds.length) {
                        var84.itemIds[var6] = var7;
                        var84.itemQuantities[var6] = var70;
                     }

                     class253.setItemTableSlot(var3, var6, var7 - 1, var70);
                  }

                  if(var84 != null) {
                     class7.method34(var84);
                  }

                  class9.method54();
                  interfaceItemTriggers[++field1120 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?72:76)) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var84 = GZipDecompressor.method3177(var2);
                  } else {
                     var84 = null;
                  }

                  for(; secretPacketBuffer2.offset < packetLength; class253.setItemTableSlot(var3, var5, var6 - 1, var7)) {
                     var5 = secretPacketBuffer2.getUSmart();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = 0;
                     if(var6 != 0) {
                        var7 = secretPacketBuffer2.readUnsignedByte();
                        if(var7 == 255) {
                           var7 = secretPacketBuffer2.readInt();
                        }
                     }

                     if(var84 != null && var5 >= 0 && var5 < var84.itemIds.length) {
                        var84.itemIds[var5] = var6;
                        var84.itemQuantities[var5] = var7;
                     }
                  }

                  if(var84 != null) {
                     class7.method34(var84);
                  }

                  class9.method54();
                  interfaceItemTriggers[++field1120 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               boolean var9;
               if(packetType == (RUNELITE_PACKET?73:75)) {
                  field1125 = cycleCntr;
                  if(packetLength == 0) {
                     clanChatOwner = null;
                     clanChatName = null;
                     class13.clanChatCount = 0;
                     class223.clanMembers = null;
                     packetType = -1;
                     return true;
                  }

                  clanChatName = secretPacketBuffer2.readString();
                  long var53 = secretPacketBuffer2.readLong();
                  var46 = var53;
                  if(var53 > 0L && var53 < 6582952005840035281L) {
                     if(var53 % 37L == 0L) {
                        var22 = null;
                     } else {
                        var7 = 0;

                        for(var34 = var53; 0L != var34; var34 /= 37L) {
                           ++var7;
                        }

                        StringBuilder var74 = new StringBuilder(var7);

                        while(var46 != 0L) {
                           var51 = var46;
                           var46 /= 37L;
                           var74.append(class269.field3672[(int)(var51 - 37L * var46)]);
                        }

                        var22 = var74.reverse().toString();
                     }
                  } else {
                     var22 = null;
                  }

                  clanChatOwner = var22;
                  class8.field244 = secretPacketBuffer2.readByte();
                  var7 = secretPacketBuffer2.readUnsignedByte();
                  if(var7 == 255) {
                     packetType = -1;
                     return true;
                  }

                  class13.clanChatCount = var7;
                  ClanMember[] var108 = new ClanMember[100];

                  for(var72 = 0; var72 < class13.clanChatCount; ++var72) {
                     var108[var72] = new ClanMember();
                     var108[var72].username = secretPacketBuffer2.readString();
                     var108[var72].field932 = Frames.method2925(var108[var72].username, class8.field243);
                     var108[var72].world = secretPacketBuffer2.readUnsignedShort();
                     var108[var72].rank = secretPacketBuffer2.readByte();
                     secretPacketBuffer2.readString();
                     if(var108[var72].username.equals(Player.localPlayer.name)) {
                        class35.clanChatRank = var108[var72].rank;
                     }
                  }

                  var9 = false;
                  var11 = class13.clanChatCount;

                  while(var11 > 0) {
                     var9 = true;
                     --var11;

                     for(var119 = 0; var119 < var11; ++var119) {
                        if(var108[var119].field932.compareTo(var108[var119 + 1].field932) > 0) {
                           ClanMember var75 = var108[var119];
                           var108[var119] = var108[var119 + 1];
                           var108[var119 + 1] = var75;
                           var9 = false;
                        }
                     }

                     if(var9) {
                        break;
                     }
                  }

                  class223.clanMembers = var108;
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?74:169)) {
                  var2 = packetLength + secretPacketBuffer2.offset;
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  var4 = secretPacketBuffer2.readUnsignedShort();
                  if(var3 != widgetRoot) {
                     widgetRoot = var3;
                     this.method1189(false);
                     IndexDataBase.method4169(widgetRoot);
                     GameEngine.method907(widgetRoot);

                     for(var5 = 0; var5 < 100; ++var5) {
                        field1110[var5] = true;
                     }
                  }

                  WidgetNode var100;
                  for(; var4-- > 0; var100.field854 = true) {
                     var5 = secretPacketBuffer2.readInt();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     var100 = (WidgetNode)componentTable.get((long)var5);
                     if(var100 != null && var6 != var100.id) {
                        MessageNode.method1143(var100, true);
                        var100 = null;
                     }

                     if(var100 == null) {
                        var100 = class82.method1644(var5, var6, var7);
                     }
                  }

                  for(var23 = (WidgetNode)componentTable.method3628(); var23 != null; var23 = (WidgetNode)componentTable.method3625()) {
                     if(var23.field854) {
                        var23.field854 = false;
                     } else {
                        MessageNode.method1143(var23, true);
                     }
                  }

                  widgetFlags = new HashTable(512);

                  while(secretPacketBuffer2.offset < var2) {
                     var5 = secretPacketBuffer2.readInt();
                     var6 = secretPacketBuffer2.readUnsignedShort();
                     var7 = secretPacketBuffer2.readUnsignedShort();
                     var70 = secretPacketBuffer2.readInt();

                     for(var72 = var6; var72 <= var7; ++var72) {
                        var36 = (long)var72 + ((long)var5 << 32);
                        widgetFlags.put(new IntegerNode(var70), var36);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?76:253)) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var67 = secretPacketBuffer2.readUnsignedByte() == 1;
                     var26 = secretPacketBuffer2.readString();
                     var22 = secretPacketBuffer2.readString();
                     var5 = secretPacketBuffer2.readUnsignedShort();
                     var6 = secretPacketBuffer2.readUnsignedByte();
                     var7 = secretPacketBuffer2.readUnsignedByte();
                     boolean var8 = (var7 & 2) != 0;
                     var9 = (var7 & 1) != 0;
                     if(var5 > 0) {
                        secretPacketBuffer2.readString();
                        secretPacketBuffer2.readUnsignedByte();
                        secretPacketBuffer2.readInt();
                     }

                     secretPacketBuffer2.readString();

                     for(var40 = 0; var40 < friendCount; ++var40) {
                        Friend var29 = friends[var40];
                        if(!var67) {
                           if(var26.equals(var29.name)) {
                              if(var5 != var29.world) {
                                 boolean var41 = true;

                                 for(class67 var30 = (class67)field1200.method3711(); var30 != null; var30 = (class67)field1200.method3712()) {
                                    if(var30.field842.equals(var26)) {
                                       if(var5 != 0 && var30.field838 == 0) {
                                          var30.method3726();
                                          var41 = false;
                                       } else if(var5 == 0 && var30.field838 != 0) {
                                          var30.method3726();
                                          var41 = false;
                                       }
                                    }
                                 }

                                 if(var41) {
                                    field1200.method3710(new class67(var26, var5));
                                 }

                                 var29.world = var5;
                              }

                              var29.previousName = var22;
                              var29.rank = var6;
                              var29.field815 = var8;
                              var29.field820 = var9;
                              var26 = null;
                              break;
                           }
                        } else if(var22.equals(var29.name)) {
                           var29.name = var26;
                           var29.previousName = var22;
                           var26 = null;
                           break;
                        }
                     }

                     if(var26 != null && friendCount < 400) {
                        Friend var10 = new Friend();
                        friends[friendCount] = var10;
                        var10.name = var26;
                        var10.previousName = var22;
                        var10.world = var5;
                        var10.rank = var6;
                        var10.field815 = var8;
                        var10.field820 = var9;
                        ++friendCount;
                     }
                  }

                  field1198 = 2;
                  field1124 = cycleCntr;
                  var67 = false;
                  var3 = friendCount;

                  while(var3 > 0) {
                     var67 = true;
                     --var3;

                     for(var4 = 0; var4 < var3; ++var4) {
                        var68 = false;
                        Friend var27 = friends[var4];
                        Friend var24 = friends[var4 + 1];
                        if(var27.world != world && var24.world == world) {
                           var68 = true;
                        }

                        if(!var68 && var27.world == 0 && var24.world != 0) {
                           var68 = true;
                        }

                        if(!var68 && !var27.field815 && var24.field815) {
                           var68 = true;
                        }

                        if(!var68 && !var27.field820 && var24.field820) {
                           var68 = true;
                        }

                        if(var68) {
                           Friend var28 = friends[var4];
                           friends[var4] = friends[var4 + 1];
                           friends[var4 + 1] = var28;
                           var67 = false;
                        }
                     }

                     if(var67) {
                        break;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?78:174)) {
                  class87.xteaChanged(false);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  class43.method644(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?79:36)) {
                  class87.xteaChanged(true);
                  secretPacketBuffer2.readOpcode();
                  var2 = secretPacketBuffer2.readUnsignedShort();
                  class43.method644(secretPacketBuffer2, var2);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?80:32)) {
                  class28.method263(true);
                  packetType = -1;
                  return true;
               }

               if(packetType == (RUNELITE_PACKET?81:225)) {
                  class28.method263(false);
                  packetType = -1;
                  return true;
               }

               if(packetType != (RUNELITE_PACKET?82:201)) {
                  if(packetType == (RUNELITE_PACKET?83:42)) {
                     class21.field353 = secretPacketBuffer2.method3276();
                     class37.field529 = secretPacketBuffer2.method3276();

                     while(secretPacketBuffer2.offset < packetLength) {
                        packetType = secretPacketBuffer2.readUnsignedByte();
                        class17.method143();
                     }

                     packetType = -1;
                     return true;
                  }

                  class150.method2975("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
                  class35.method518();
                  return true;
               }
            }

            class17.method143();
            packetType = -1;
            return true;
         } catch (IOException var65) {
            if(field1058 > 0) {
               class35.method518();
            } else {
               WorldMapType2.setGameState(40);
               class206.field2565 = ScriptEvent.rssocket;
               ScriptEvent.rssocket = null;
            }
         } catch (Exception var66) {
            var25 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (Player.localPlayer.pathX[0] + class149.baseX) + "," + (Player.localPlayer.pathY[0] + class67.baseY) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var25 = var25 + secretPacketBuffer2.payload[var3] + ",";
            }

            class150.method2975(var25, var66);
            class35.method518();
         }

         return true;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-38373875"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();

      while(true) {
         Deque var2 = class237.field3243;
         FileSystem var1;
         synchronized(class237.field3243) {
            var1 = (FileSystem)class237.field3235.popFront();
         }

         if(var1 == null) {
            int var43;
            try {
               if(class204.field2507 == 1) {
                  var43 = class225.field2856.method3767();
                  if(var43 > 0 && class225.field2856.method3827()) {
                     var43 -= class115.field1694;
                     if(var43 < 0) {
                        var43 = 0;
                     }

                     class225.field2856.method3793(var43);
                  } else {
                     class225.field2856.method3772();
                     class225.field2856.method3770();
                     if(class204.field2508 != null) {
                        class204.field2507 = 2;
                     } else {
                        class204.field2507 = 0;
                     }

                     Coordinates.field2620 = null;
                     class204.field2511 = null;
                  }
               }
            } catch (Exception var59) {
               var59.printStackTrace();
               class225.field2856.method3772();
               class204.field2507 = 0;
               Coordinates.field2620 = null;
               class204.field2511 = null;
               class204.field2508 = null;
            }

            WorldMapType3.method239();
            method1311();
            class47.method739();
            if(class61.field777 != null) {
               var43 = class61.field777.vmethod3044();
               field1129 = var43;
            }

            if(gameState == 0) {
               class182.load();
               GameEngine.timer.vmethod3050();

               for(var43 = 0; var43 < 32; ++var43) {
                  GameEngine.field711[var43] = 0L;
               }

               for(var43 = 0; var43 < 32; ++var43) {
                  GameEngine.field706[var43] = 0L;
               }

               class15.field305 = 0;
            } else if(gameState == 5) {
               class224.method4102(this);
               class182.load();
               GameEngine.timer.vmethod3050();

               for(var43 = 0; var43 < 32; ++var43) {
                  GameEngine.field711[var43] = 0L;
               }

               for(var43 = 0; var43 < 32; ++var43) {
                  GameEngine.field706[var43] = 0L;
               }

               class15.field305 = 0;
            } else if(gameState != 10 && gameState != 11) {
               if(gameState == 20) {
                  class224.method4102(this);
                  this.method1180();
               } else if(gameState == 25) {
                  class51.flush(false);
                  field998 = 0;
                  boolean var61 = true;

                  int var44;
                  for(var44 = 0; var44 < TextureProvider.field1793.length; ++var44) {
                     if(ScriptEvent.field869[var44] != -1 && TextureProvider.field1793[var44] == null) {
                        TextureProvider.field1793[var44] = RSCanvas.indexMaps.getConfigData(ScriptEvent.field869[var44], 0);
                        if(TextureProvider.field1793[var44] == null) {
                           var61 = false;
                           ++field998;
                        }
                     }

                     if(class175.landRegionFielIds[var44] != -1 && WidgetNode.field850[var44] == null) {
                        WidgetNode.field850[var44] = RSCanvas.indexMaps.getConfigData(class175.landRegionFielIds[var44], 0, GameEngine.xteaKeys[var44]);
                        if(WidgetNode.field850[var44] == null) {
                           var61 = false;
                           ++field998;
                        }
                     }
                  }

                  if(!var61) {
                     field1002 = 1;
                  } else {
                     field1033 = 0;
                     var61 = true;

                     int var4;
                     int var5;
                     for(var44 = 0; var44 < TextureProvider.field1793.length; ++var44) {
                        byte[] var3 = WidgetNode.field850[var44];
                        if(var3 != null) {
                           var4 = (class36.mapRegions[var44] >> 8) * 64 - class149.baseX;
                           var5 = (class36.mapRegions[var44] & 255) * 64 - class67.baseY;
                           if(isDynamicRegion) {
                              var4 = 10;
                              var5 = 10;
                           }

                           var61 &= ChatLineBuffer.method1876(var3, var4, var5);
                        }
                     }

                     if(!var61) {
                        field1002 = 2;
                     } else {
                        if(field1002 != 0) {
                           ScriptState.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                        }

                        WorldMapType3.method239();
                        class19.method171();
                        WorldMapType3.method239();
                        ScriptState.region.reset();
                        WorldMapType3.method239();
                        System.gc();

                        for(var44 = 0; var44 < 4; ++var44) {
                           collisionMaps[var44].reset();
                        }

                        int var45;
                        for(var44 = 0; var44 < 4; ++var44) {
                           for(var45 = 0; var45 < 104; ++var45) {
                              for(var4 = 0; var4 < 104; ++var4) {
                                 class61.tileSettings[var44][var45][var4] = 0;
                              }
                           }
                        }

                        WorldMapType3.method239();
                        class61.field770 = 99;
                        class54.underlayIds = new byte[4][104][104];
                        class178.overlayIds = new byte[4][104][104];
                        class61.overlayPaths = new byte[4][104][104];
                        class215.overlayRotations = new byte[4][104][104];
                        class14.field300 = new int[4][105][105];
                        VertexNormal.field2018 = new byte[4][105][105];
                        class61.field773 = new int[105][105];
                        Varcs.blendedHue = new int[104];
                        class150.blendedSaturation = new int[104];
                        class27.field401 = new int[104];
                        class244.field3318 = new int[104];
                        class61.field769 = new int[104];
                        var44 = TextureProvider.field1793.length;
                        class204.method3749();
                        class51.flush(true);
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
                        int var46;
                        int var53;
                        if(!isDynamicRegion) {
                           byte[] var6;
                           for(var45 = 0; var45 < var44; ++var45) {
                              var4 = (class36.mapRegions[var45] >> 8) * 64 - class149.baseX;
                              var5 = (class36.mapRegions[var45] & 255) * 64 - class67.baseY;
                              var6 = TextureProvider.field1793[var45];
                              if(var6 != null) {
                                 WorldMapType3.method239();
                                 class41.method616(var6, var4, var5, class27.field407 * 8 - 48, class15.field303 * 8 - 48, collisionMaps);
                              }
                           }

                           for(var45 = 0; var45 < var44; ++var45) {
                              var4 = (class36.mapRegions[var45] >> 8) * 64 - class149.baseX;
                              var5 = (class36.mapRegions[var45] & 255) * 64 - class67.baseY;
                              var6 = TextureProvider.field1793[var45];
                              if(var6 == null && class15.field303 < 800) {
                                 WorldMapType3.method239();
                                 class88.method1716(var4, var5, 64, 64);
                              }
                           }

                           class51.flush(true);

                           for(var45 = 0; var45 < var44; ++var45) {
                              byte[] var48 = WidgetNode.field850[var45];
                              if(var48 != null) {
                                 var5 = (class36.mapRegions[var45] >> 8) * 64 - class149.baseX;
                                 var46 = (class36.mapRegions[var45] & 255) * 64 - class67.baseY;
                                 WorldMapType3.method239();
                                 Region var49 = ScriptState.region;
                                 CollisionData[] var50 = collisionMaps;
                                 Buffer var51 = new Buffer(var48);
                                 var10 = -1;

                                 while(true) {
                                    var11 = var51.getUSmart();
                                    if(var11 == 0) {
                                       break;
                                    }

                                    var10 += var11;
                                    var12 = 0;

                                    while(true) {
                                       var13 = var51.getUSmart();
                                       if(var13 == 0) {
                                          break;
                                       }

                                       var12 += var13 - 1;
                                       var53 = var12 & 63;
                                       var15 = var12 >> 6 & 63;
                                       var16 = var12 >> 12;
                                       var17 = var51.readUnsignedByte();
                                       var18 = var17 >> 2;
                                       int var56 = var17 & 3;
                                       var20 = var15 + var5;
                                       var21 = var53 + var46;
                                       if(var20 > 0 && var21 > 0 && var20 < 103 && var21 < 103) {
                                          var22 = var16;
                                          if((class61.tileSettings[1][var20][var21] & 2) == 2) {
                                             var22 = var16 - 1;
                                          }

                                          CollisionData var57 = null;
                                          if(var22 >= 0) {
                                             var57 = var50[var22];
                                          }

                                          FloorUnderlayDefinition.addObject(var16, var20, var21, var10, var56, var18, var49, var57);
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        int var7;
                        int var8;
                        int var9;
                        if(isDynamicRegion) {
                           var45 = 0;

                           label675:
                           while(true) {
                              CollisionData[] var19;
                              int var23;
                              int var27;
                              int var28;
                              int var29;
                              int var30;
                              Buffer var47;
                              if(var45 >= 4) {
                                 for(var45 = 0; var45 < 13; ++var45) {
                                    for(var4 = 0; var4 < 13; ++var4) {
                                       var5 = field1005[0][var45][var4];
                                       if(var5 == -1) {
                                          class88.method1716(var45 * 8, var4 * 8, 8, 8);
                                       }
                                    }
                                 }

                                 class51.flush(true);
                                 var45 = 0;

                                 while(true) {
                                    if(var45 >= 4) {
                                       break label675;
                                    }

                                    WorldMapType3.method239();

                                    for(var4 = 0; var4 < 13; ++var4) {
                                       label564:
                                       for(var5 = 0; var5 < 13; ++var5) {
                                          var46 = field1005[var45][var4][var5];
                                          if(var46 != -1) {
                                             var7 = var46 >> 24 & 3;
                                             var8 = var46 >> 1 & 3;
                                             var9 = var46 >> 14 & 1023;
                                             var10 = var46 >> 3 & 2047;
                                             var11 = (var9 / 8 << 8) + var10 / 8;

                                             for(var12 = 0; var12 < class36.mapRegions.length; ++var12) {
                                                if(class36.mapRegions[var12] == var11 && WidgetNode.field850[var12] != null) {
                                                   byte[] var52 = WidgetNode.field850[var12];
                                                   var53 = var4 * 8;
                                                   var15 = var5 * 8;
                                                   var16 = (var9 & 7) * 8;
                                                   var17 = (var10 & 7) * 8;
                                                   Region var54 = ScriptState.region;
                                                   var19 = collisionMaps;
                                                   var47 = new Buffer(var52);
                                                   var21 = -1;

                                                   while(true) {
                                                      var22 = var47.getUSmart();
                                                      if(var22 == 0) {
                                                         continue label564;
                                                      }

                                                      var21 += var22;
                                                      var23 = 0;

                                                      while(true) {
                                                         int var55 = var47.getUSmart();
                                                         if(var55 == 0) {
                                                            break;
                                                         }

                                                         var23 += var55 - 1;
                                                         int var25 = var23 & 63;
                                                         int var26 = var23 >> 6 & 63;
                                                         var27 = var23 >> 12;
                                                         var28 = var47.readUnsignedByte();
                                                         var29 = var28 >> 2;
                                                         var30 = var28 & 3;
                                                         if(var7 == var27 && var26 >= var16 && var26 < var16 + 8 && var25 >= var17 && var25 < var17 + 8) {
                                                            ObjectComposition var31 = GameObject.getObjectDefinition(var21);
                                                            int var34 = var26 & 7;
                                                            int var35 = var25 & 7;
                                                            int var37 = var31.sizeX;
                                                            int var38 = var31.sizeY;
                                                            int var39;
                                                            if((var30 & 1) == 1) {
                                                               var39 = var37;
                                                               var37 = var38;
                                                               var38 = var39;
                                                            }

                                                            int var36 = var8 & 3;
                                                            int var33;
                                                            if(var36 == 0) {
                                                               var33 = var34;
                                                            } else if(var36 == 1) {
                                                               var33 = var35;
                                                            } else if(var36 == 2) {
                                                               var33 = 7 - var34 - (var37 - 1);
                                                            } else {
                                                               var33 = 7 - var35 - (var38 - 1);
                                                            }

                                                            var39 = var53 + var33;
                                                            int var40 = var15 + Area.method4314(var26 & 7, var25 & 7, var8, var31.sizeX, var31.sizeY, var30);
                                                            if(var39 > 0 && var40 > 0 && var39 < 103 && var40 < 103) {
                                                               int var41 = var45;
                                                               if((class61.tileSettings[1][var39][var40] & 2) == 2) {
                                                                  var41 = var45 - 1;
                                                               }

                                                               CollisionData var42 = null;
                                                               if(var41 >= 0) {
                                                                  var42 = var19[var41];
                                                               }

                                                               FloorUnderlayDefinition.addObject(var45, var39, var40, var21, var8 + var30 & 3, var29, var54, var42);
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++var45;
                                 }
                              }

                              WorldMapType3.method239();

                              for(var4 = 0; var4 < 13; ++var4) {
                                 for(var5 = 0; var5 < 13; ++var5) {
                                    boolean var60 = false;
                                    var7 = field1005[var45][var4][var5];
                                    if(var7 != -1) {
                                       var8 = var7 >> 24 & 3;
                                       var9 = var7 >> 1 & 3;
                                       var10 = var7 >> 14 & 1023;
                                       var11 = var7 >> 3 & 2047;
                                       var12 = (var10 / 8 << 8) + var11 / 8;

                                       for(var13 = 0; var13 < class36.mapRegions.length; ++var13) {
                                          if(class36.mapRegions[var13] == var12 && TextureProvider.field1793[var13] != null) {
                                             byte[] var14 = TextureProvider.field1793[var13];
                                             var15 = var4 * 8;
                                             var16 = var5 * 8;
                                             var17 = (var10 & 7) * 8;
                                             var18 = (var11 & 7) * 8;
                                             var19 = collisionMaps;

                                             for(var20 = 0; var20 < 8; ++var20) {
                                                for(var21 = 0; var21 < 8; ++var21) {
                                                   if(var20 + var15 > 0 && var20 + var15 < 103 && var21 + var16 > 0 && var21 + var16 < 103) {
                                                      var19[var45].flags[var15 + var20][var16 + var21] &= -16777217;
                                                   }
                                                }
                                             }

                                             var47 = new Buffer(var14);

                                             for(var21 = 0; var21 < 4; ++var21) {
                                                for(var22 = 0; var22 < 64; ++var22) {
                                                   for(var23 = 0; var23 < 64; ++var23) {
                                                      if(var21 == var8 && var22 >= var17 && var22 < var17 + 8 && var23 >= var18 && var23 < var18 + 8) {
                                                         var28 = var22 & 7;
                                                         var29 = var23 & 7;
                                                         var30 = var9 & 3;
                                                         if(var30 == 0) {
                                                            var27 = var28;
                                                         } else if(var30 == 1) {
                                                            var27 = var29;
                                                         } else if(var30 == 2) {
                                                            var27 = 7 - var28;
                                                         } else {
                                                            var27 = 7 - var29;
                                                         }

                                                         class9.loadTerrain(var47, var45, var15 + var27, var16 + AbstractSoundSystem.method2024(var22 & 7, var23 & 7, var9), 0, 0, var9);
                                                      } else {
                                                         class9.loadTerrain(var47, 0, -1, -1, 0, 0, 0);
                                                      }
                                                   }
                                                }
                                             }

                                             var60 = true;
                                             break;
                                          }
                                       }
                                    }

                                    if(!var60) {
                                       var8 = var45;
                                       var9 = var4 * 8;
                                       var10 = var5 * 8;

                                       for(var11 = 0; var11 < 8; ++var11) {
                                          for(var12 = 0; var12 < 8; ++var12) {
                                             class61.tileHeights[var8][var11 + var9][var10 + var12] = 0;
                                          }
                                       }

                                       if(var9 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class61.tileHeights[var8][var9][var10 + var11] = class61.tileHeights[var8][var9 - 1][var11 + var10];
                                          }
                                       }

                                       if(var10 > 0) {
                                          for(var11 = 1; var11 < 8; ++var11) {
                                             class61.tileHeights[var8][var9 + var11][var10] = class61.tileHeights[var8][var9 + var11][var10 - 1];
                                          }
                                       }

                                       if(var9 > 0 && class61.tileHeights[var8][var9 - 1][var10] != 0) {
                                          class61.tileHeights[var8][var9][var10] = class61.tileHeights[var8][var9 - 1][var10];
                                       } else if(var10 > 0 && class61.tileHeights[var8][var9][var10 - 1] != 0) {
                                          class61.tileHeights[var8][var9][var10] = class61.tileHeights[var8][var9][var10 - 1];
                                       } else if(var9 > 0 && var10 > 0 && class61.tileHeights[var8][var9 - 1][var10 - 1] != 0) {
                                          class61.tileHeights[var8][var9][var10] = class61.tileHeights[var8][var9 - 1][var10 - 1];
                                       }
                                    }
                                 }
                              }

                              ++var45;
                           }
                        }

                        class51.flush(true);
                        class19.method171();
                        WorldMapType3.method239();
                        class7.method33(ScriptState.region, collisionMaps);
                        class51.flush(true);
                        var45 = class61.field770;
                        if(var45 > class27.plane) {
                           var45 = class27.plane;
                        }

                        if(var45 < class27.plane - 1) {
                           var45 = class27.plane - 1;
                        }

                        if(lowMemory) {
                           ScriptState.region.setup(class61.field770);
                        } else {
                           ScriptState.region.setup(0);
                        }

                        for(var4 = 0; var4 < 104; ++var4) {
                           for(var5 = 0; var5 < 104; ++var5) {
                              class204.groundItemSpawned(var4, var5);
                           }
                        }

                        WorldMapType3.method239();
                        Player.method1160();
                        ObjectComposition.field3437.reset();
                        if(class87.clientInstance.method922()) {
                           secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_69);
                           secretPacketBuffer1.putInt(1057001181);
                        }

                        if(!isDynamicRegion) {
                           var4 = (class27.field407 - 6) / 8;
                           var5 = (class27.field407 + 6) / 8;
                           var46 = (class15.field303 - 6) / 8;
                           var7 = (class15.field303 + 6) / 8;

                           for(var8 = var4 - 1; var8 <= var5 + 1; ++var8) {
                              for(var9 = var46 - 1; var9 <= var7 + 1; ++var9) {
                                 if(var8 < var4 || var8 > var5 || var9 < var46 || var9 > var7) {
                                    RSCanvas.indexMaps.method4157("m" + var8 + "_" + var9);
                                    RSCanvas.indexMaps.method4157("l" + var8 + "_" + var9);
                                 }
                              }
                           }
                        }

                        WorldMapType2.setGameState(30);
                        WorldMapType3.method239();
                        class54.underlayIds = null;
                        class178.overlayIds = null;
                        class61.overlayPaths = null;
                        class215.overlayRotations = null;
                        class14.field300 = null;
                        VertexNormal.field2018 = null;
                        class61.field773 = null;
                        Varcs.blendedHue = null;
                        class150.blendedSaturation = null;
                        class27.field401 = null;
                        class244.field3318 = null;
                        class61.field769 = null;
                        secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_241);
                        GameEngine.timer.vmethod3050();

                        for(var4 = 0; var4 < 32; ++var4) {
                           GameEngine.field711[var4] = 0L;
                        }

                        for(var4 = 0; var4 < 32; ++var4) {
                           GameEngine.field706[var4] = 0L;
                        }

                        class15.field305 = 0;
                     }
                  }
               }
            } else {
               class224.method4102(this);
            }

            if(gameState == 30) {
               this.method1346();
            } else if(gameState == 40 || gameState == 45) {
               this.method1180();
            }

            return;
         }

         var1.data.method4235(var1.index, (int)var1.hash, var1.field3206, false);
      }
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1991308835"
   )
   final void method1170() {
      int var1;
      if(widgetRoot != -1) {
         var1 = widgetRoot;
         if(class13.loadWidget(var1)) {
            class34.method399(class268.widgets[var1], -1);
         }
      }

      for(var1 = 0; var1 < field1065; ++var1) {
         if(field1110[var1]) {
            field966[var1] = true;
         }

         field1138[var1] = field1110[var1];
         field1110[var1] = false;
      }

      field1071 = gameCycle;
      field1080 = -1;
      field1126 = -1;
      class11.field278 = null;
      if(widgetRoot != -1) {
         field1065 = 0;
         class5.method8(widgetRoot, 0, 0, class91.canvasWidth, class64.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      if(!isMenuOpen) {
         if(field1080 != -1) {
            var1 = field1080;
            int var2 = field1126;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               int var3 = class51.method817();
               String var4;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var4 = "Use" + " " + field1085 + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var4 = field1089 + " " + field1090 + " " + "->";
               } else {
                  String var5;
                  if(var3 < 0) {
                     var5 = "";
                  } else if(menuTargets[var3].length() > 0) {
                     var5 = menuOptions[var3] + " " + menuTargets[var3];
                  } else {
                     var5 = menuOptions[var3];
                  }

                  var4 = var5;
               }

               if(menuOptionCount > 2) {
                  var4 = var4 + Friend.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               class73.field897.drawRandomizedMouseoverText(var4, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         class5.method9();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1065; ++var1) {
            if(field1138[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field966[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      Friend.method1115(class27.plane, Player.localPlayer.x, Player.localPlayer.y, field1007);
      field1007 = 0;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1907393303"
   )
   final void method1188(int var1, int var2) {
      int var3 = class73.field897.method4775("Choose Option");

      int var4;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         Font var5 = class73.field897;
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
      if(var8 + var3 > class91.canvasWidth) {
         var8 = class91.canvasWidth - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var9 = var2;
      if(var2 + var4 > class64.canvasHeight) {
         var9 = class64.canvasHeight - var4;
      }

      if(var9 < 0) {
         var9 = 0;
      }

      ScriptState.region.method2793(class27.plane, var1, var2, false);
      isMenuOpen = true;
      class239.menuX = var8;
      class43.menuY = var9;
      class88.menuWidth = var3;
      class12.menuHeight = 22 + menuOptionCount * 15;
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "764916597"
   )
   void method1178() {
      if(class239.field3270 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class239.field3274 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field1155 = 3000;
            class239.field3274 = 3;
         }

         if(--field1155 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  socket = GameEngine.taskManager.createSocket(class22.host, class111.myWorldPort);
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
                  IndexDataBase.rssocket = new RSSocket((Socket)socket.value, GameEngine.taskManager);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(154);
                  IndexDataBase.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  class89.field1419 = class45.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && IndexDataBase.rssocket.available() <= 0) {
                     if(class45.currentTimeMs() - class89.field1419 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var2 = IndexDataBase.rssocket.readByte();
                     if(var2 != 0) {
                        this.error(var2);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  class56.method868(IndexDataBase.rssocket, gameState > 20);
                  socket = null;
                  IndexDataBase.rssocket = null;
                  js5State = 0;
                  field945 = 0;
               }
            } catch (IOException var3) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1252570597"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1407(boolean var1) {
      boolean var2 = class13.method80();
      if(var2 && field1169 && CacheFile.soundSystem0 != null) {
         CacheFile.soundSystem0.method2013();
      }

      int var3;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1104 && class45.currentTimeMs() > field1104) {
         var3 = class41.method595();
         field1104 = 0L;
         if(var3 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         if(class41.method595() == 1) {
            class87.clientInstance.method888(765, 503);
         } else {
            class87.clientInstance.method888(7680, 2160);
         }

         if(gameState >= 25) {
            class17.method144();
         }
      }

      if(var1) {
         for(var3 = 0; var3 < 100; ++var3) {
            field1110[var3] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class91.loadingBarPercentage, class91.loadingText, var1);
      } else if(gameState == 5) {
         SoundTask.drawLoginScreen(class73.field897, class31.field447, WorldMapType2.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            SoundTask.drawLoginScreen(class73.field897, class31.field447, WorldMapType2.font_p12full, var1);
         } else if(gameState == 25) {
            if(field1002 == 1) {
               if(field998 > field999) {
                  field999 = field998;
               }

               var3 = (field999 * 50 - field998 * 50) / field999;
               ScriptState.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else if(field1002 == 2) {
               if(field1033 > field1128) {
                  field1128 = field1033;
               }

               var3 = (field1128 * 50 - field1033 * 50) / field1128 + 50;
               ScriptState.drawStatusBox("Loading - please wait." + "<br>" + " (" + var3 + "%" + ")", false);
            } else {
               ScriptState.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1170();
         } else if(gameState == 40) {
            ScriptState.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            ScriptState.drawStatusBox("Please wait...", false);
         }
      } else {
         SoundTask.drawLoginScreen(class73.field897, class31.field447, WorldMapType2.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var3 = 0; var3 < field1065; ++var3) {
            if(field966[var3]) {
               class20.field342.vmethod4971(widgetPositionX[var3], widgetPositionY[var3], widgetBoundsWidth[var3], widgetBoundsHeight[var3]);
               field966[var3] = false;
            }
         }
      } else if(gameState > 0) {
         class20.field342.vmethod4967(0, 0);

         for(var3 = 0; var3 < field1065; ++var3) {
            field966[var3] = false;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   protected final void vmethod1182() {
      field1104 = class45.currentTimeMs() + 500L;
      this.method1183();
      if(widgetRoot != -1) {
         this.method1189(true);
      }

   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-96"
   )
   final void method1346() {
      if(field1059 > 1) {
         --field1059;
      }

      if(field1058 > 0) {
         --field1058;
      }

      if(socketError) {
         socketError = false;
         if(field1058 > 0) {
            class35.method518();
         } else {
            WorldMapType2.setGameState(40);
            class206.field2565 = ScriptEvent.rssocket;
            ScriptEvent.rssocket = null;
         }

      } else {
         if(!isMenuOpen) {
            GraphicsObject.method1675();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.processServerPacket(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(GraphicsObject.method1683()) {
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_79);
               secretPacketBuffer1.putByte(0);
               var1 = secretPacketBuffer1.offset;
               class208.encodeClassVerifier(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
            }

            Object var13 = field970.field878;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(field970.field878) {
               if(!field978) {
                  field970.field880 = 0;
               } else if(MouseInput.field754 != 0 || field970.field880 >= 40) {
                  secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_208);
                  secretPacketBuffer1.putByte(0);
                  var2 = secretPacketBuffer1.offset;
                  var3 = 0;

                  for(var4 = 0; var4 < field970.field880 && secretPacketBuffer1.offset - var2 < 240; ++var4) {
                     ++var3;
                     var5 = field970.field882[var4];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 502) {
                        var5 = 502;
                     }

                     var6 = field970.field879[var4];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 764) {
                        var6 = 764;
                     }

                     var7 = var5 * 765 + var6;
                     if(field970.field882[var4] == -1 && field970.field879[var4] == -1) {
                        var6 = -1;
                        var5 = -1;
                        var7 = 524287;
                     }

                     if(var6 == field1207 && var5 == field953) {
                        if(field954 < 2047) {
                           ++field954;
                        }
                     } else {
                        var8 = var6 - field1207;
                        field1207 = var6;
                        var9 = var5 - field953;
                        field953 = var5;
                        if(field954 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                           var8 += 32;
                           var9 += 32;
                           secretPacketBuffer1.putShort(var9 + (field954 << 12) + (var8 << 6));
                           field954 = 0;
                        } else if(field954 < 8) {
                           secretPacketBuffer1.put24bitInt((field954 << 19) + var7 + 8388608);
                           field954 = 0;
                        } else {
                           secretPacketBuffer1.putInt((field954 << 19) + var7 + -1073741824);
                           field954 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var2);
                  if(var3 >= field970.field880) {
                     field970.field880 = 0;
                  } else {
                     field970.field880 -= var3;

                     for(var4 = 0; var4 < field970.field880; ++var4) {
                        field970.field879[var4] = field970.field879[var4 + var3];
                        field970.field882[var4] = field970.field882[var3 + var4];
                     }
                  }
               }
            }

            if(MouseInput.field754 == 1 || !field951 && MouseInput.field754 == 4 || MouseInput.field754 == 2) {
               long var14 = (MouseInput.field755 - field1082) / 50L;
               if(var14 > 4095L) {
                  var14 = 4095L;
               }

               field1082 = MouseInput.field755;
               var3 = MouseInput.field739;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class64.canvasHeight) {
                  var3 = class64.canvasHeight;
               }

               var4 = MouseInput.field753;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class91.canvasWidth) {
                  var4 = class91.canvasWidth;
               }

               var5 = (int)var14;
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_26);
               secretPacketBuffer1.putShort((MouseInput.field754 == 2?1:0) + (var5 << 1));
               secretPacketBuffer1.putShort(var4);
               secretPacketBuffer1.putShort(var3);
            }

            if(KeyFocusListener.field652 > 0) {
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_22);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               long var16 = class45.currentTimeMs();

               for(var4 = 0; var4 < KeyFocusListener.field652; ++var4) {
                  long var18 = var16 - field1156;
                  if(var18 > 16777215L) {
                     var18 = 16777215L;
                  }

                  field1156 = var16;
                  secretPacketBuffer1.method3410(KeyFocusListener.field646[var4]);
                  secretPacketBuffer1.method3286((int)var18);
               }

               secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
            }

            if(field1021 > 0) {
               --field1021;
            }

            if(KeyFocusListener.field651[96] || KeyFocusListener.field651[97] || KeyFocusListener.field651[98] || KeyFocusListener.field651[99]) {
               field1206 = true;
            }

            if(field1206 && field1021 <= 0) {
               field1021 = 20;
               field1206 = false;
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_134);
               secretPacketBuffer1.method3273(mapAngle);
               secretPacketBuffer1.method3280(field956);
            }

            if(GameEngine.field732 && !field955) {
               field955 = true;
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_62);
               secretPacketBuffer1.putByte(1);
            }

            if(!GameEngine.field732 && field955) {
               field955 = false;
               secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_62);
               secretPacketBuffer1.putByte(0);
            }

            int[] var20;
            if(class27.plane != field1159) {
               field1159 = class27.plane;
               var1 = class27.plane;
               var20 = GrandExchangeOffer.field315.image;
               var3 = var20.length;

               for(var4 = 0; var4 < var3; ++var4) {
                  var20[var4] = 0;
               }

               for(var4 = 1; var4 < 103; ++var4) {
                  var5 = 24628 + (103 - var4) * 2048;

                  for(var6 = 1; var6 < 103; ++var6) {
                     if((class61.tileSettings[var1][var6][var4] & 24) == 0) {
                        ScriptState.region.method2745(var20, var5, 512, var1, var6, var4);
                     }

                     if(var1 < 3 && (class61.tileSettings[var1 + 1][var6][var4] & 8) != 0) {
                        ScriptState.region.method2745(var20, var5, 512, var1 + 1, var6, var4);
                     }

                     var5 += 4;
                  }
               }

               var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
               var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
               GrandExchangeOffer.field315.method5010();

               for(var6 = 1; var6 < 103; ++var6) {
                  for(var7 = 1; var7 < 103; ++var7) {
                     if((class61.tileSettings[var1][var7][var6] & 24) == 0) {
                        GroundObject.method2494(var1, var7, var6, var4, var5);
                     }

                     if(var1 < 3 && (class61.tileSettings[var1 + 1][var7][var6] & 8) != 0) {
                        GroundObject.method2494(var1 + 1, var7, var6, var4, var5);
                     }
                  }
               }

               field1160 = 0;

               for(var6 = 0; var6 < 104; ++var6) {
                  for(var7 = 0; var7 < 104; ++var7) {
                     var8 = ScriptState.region.method2762(class27.plane, var6, var7);
                     if(var8 != 0) {
                        var8 = var8 >> 14 & 32767;
                        var9 = GameObject.getObjectDefinition(var8).mapIconId;
                        if(var9 >= 0) {
                           field1163[field1160] = Area.field3294[var9].method4302(false);
                           field1161[field1160] = var6;
                           field1162[field1160] = var7;
                           ++field1160;
                        }
                     }
                  }
               }

               class20.field342.setRaster();
            }

            if(gameState == 30) {
               for(PendingSpawn var31 = (PendingSpawn)pendingSpawns.getFront(); var31 != null; var31 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var31.hitpoints > 0) {
                     --var31.hitpoints;
                  }

                  ObjectComposition var21;
                  boolean var29;
                  if(var31.hitpoints == 0) {
                     if(var31.field1227 >= 0) {
                        var3 = var31.field1227;
                        var4 = var31.field1212;
                        var21 = GameObject.getObjectDefinition(var3);
                        if(var4 == 11) {
                           var4 = 10;
                        }

                        if(var4 >= 5 && var4 <= 8) {
                           var4 = 4;
                        }

                        var29 = var21.method4520(var4);
                        if(!var29) {
                           continue;
                        }
                     }

                     class56.method854(var31.level, var31.type, var31.x, var31.y, var31.field1227, var31.field1221, var31.field1212);
                     var31.unlink();
                  } else {
                     if(var31.delay > 0) {
                        --var31.delay;
                     }

                     if(var31.delay == 0 && var31.x >= 1 && var31.y >= 1 && var31.x <= 102 && var31.y <= 102) {
                        if(var31.id >= 0) {
                           var3 = var31.id;
                           var4 = var31.field1224;
                           var21 = GameObject.getObjectDefinition(var3);
                           if(var4 == 11) {
                              var4 = 10;
                           }

                           if(var4 >= 5 && var4 <= 8) {
                              var4 = 4;
                           }

                           var29 = var21.method4520(var4);
                           if(!var29) {
                              continue;
                           }
                        }

                        class56.method854(var31.level, var31.type, var31.x, var31.y, var31.id, var31.orientation, var31.field1224);
                        var31.delay = -1;
                        if(var31.field1227 == var31.id && var31.field1227 == -1) {
                           var31.unlink();
                        } else if(var31.field1227 == var31.id && var31.orientation == var31.field1221 && var31.field1212 == var31.field1224) {
                           var31.unlink();
                        }
                     }
                  }
               }

               class21.method181();
               ++field990;
               if(field990 > 750) {
                  if(field1058 > 0) {
                     class35.method518();
                  } else {
                     WorldMapType2.setGameState(40);
                     class206.field2565 = ScriptEvent.rssocket;
                     ScriptEvent.rssocket = null;
                  }

               } else {
                  var1 = class95.field1507;
                  var20 = class95.field1511;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var22 = cachedPlayers[var20[var3]];
                     if(var22 != null) {
                        CombatInfo1.method1545(var22, 1);
                     }
                  }

                  for(var1 = 0; var1 < field946; ++var1) {
                     var2 = npcIndices[var1];
                     NPC var23 = cachedNPCs[var2];
                     if(var23 != null) {
                        CombatInfo1.method1545(var23, var23.composition.field3574);
                     }
                  }

                  int[] var32 = class95.field1511;

                  for(var2 = 0; var2 < class95.field1507; ++var2) {
                     Player var40 = cachedPlayers[var32[var2]];
                     if(var40 != null && var40.field1245 > 0) {
                        --var40.field1245;
                        if(var40.field1245 == 0) {
                           var40.overhead = null;
                        }
                     }
                  }

                  for(var2 = 0; var2 < field946; ++var2) {
                     var3 = npcIndices[var2];
                     NPC var37 = cachedNPCs[var3];
                     if(var37 != null && var37.field1245 > 0) {
                        --var37.field1245;
                        if(var37.field1245 == 0) {
                           var37.overhead = null;
                        }
                     }
                  }

                  ++field1007;
                  if(cursorState != 0) {
                     field1040 += 20;
                     if(field1040 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class262.field3618 != null) {
                     ++field1042;
                     if(field1042 >= 15) {
                        class7.method34(class262.field3618);
                        class262.field3618 = null;
                     }
                  }

                  Widget var33 = class56.field696;
                  Widget var34 = class48.field629;
                  class56.field696 = null;
                  class48.field629 = null;
                  field1108 = null;
                  field1112 = false;
                  field1209 = false;
                  field1153 = 0;

                  while(class20.method175() && field1153 < 128) {
                     if(rights >= 2 && KeyFocusListener.field651[82] && class203.field2493 == 66) {
                        String var38 = "";

                        MessageNode var24;
                        for(Iterator var35 = class97.field1532.iterator(); var35.hasNext(); var38 = var38 + var24.name + ':' + var24.value + '\n') {
                           var24 = (MessageNode)var35.next();
                        }

                        class87.clientInstance.method916(var38);
                     } else {
                        field1131[field1153] = class203.field2493;
                        field1154[field1153] = WorldMapType1.field444;
                        ++field1153;
                     }
                  }

                  if(widgetRoot != -1) {
                     var3 = widgetRoot;
                     var4 = class91.canvasWidth;
                     var5 = class64.canvasHeight;
                     if(class13.loadWidget(var3)) {
                        class211.method3962(class268.widgets[var3], -1, 0, 0, var4, var5, 0, 0);
                     }
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var36;
                     Widget var41;
                     ScriptEvent var42;
                     do {
                        var42 = (ScriptEvent)field1000.popFront();
                        if(var42 == null) {
                           while(true) {
                              do {
                                 var42 = (ScriptEvent)field1132.popFront();
                                 if(var42 == null) {
                                    while(true) {
                                       do {
                                          var42 = (ScriptEvent)field1130.popFront();
                                          if(var42 == null) {
                                             this.method1186();
                                             if(KeyFocusListener.renderOverview != null) {
                                                KeyFocusListener.renderOverview.method5175(class27.plane, (Player.localPlayer.x >> 7) + class149.baseX, (Player.localPlayer.y >> 7) + class67.baseY, false);
                                                KeyFocusListener.renderOverview.method5174();
                                             }

                                             if(field1111 != null) {
                                                this.method1405();
                                             }

                                             if(class18.field325 != null) {
                                                class7.method34(class18.field325);
                                                ++field1081;
                                                if(MouseInput.field745 == 0) {
                                                   if(field1048) {
                                                      if(class18.field325 == class11.field278 && field1044 != field1133) {
                                                         Widget var43 = class18.field325;
                                                         byte var30 = 0;
                                                         if(field1144 == 1 && var43.contentType == 206) {
                                                            var30 = 1;
                                                         }

                                                         if(var43.itemIds[field1133] <= 0) {
                                                            var30 = 0;
                                                         }

                                                         if(class169.method3212(Coordinates.getWidgetConfig(var43))) {
                                                            var5 = field1044;
                                                            var6 = field1133;
                                                            var43.itemIds[var6] = var43.itemIds[var5];
                                                            var43.itemQuantities[var6] = var43.itemQuantities[var5];
                                                            var43.itemIds[var5] = -1;
                                                            var43.itemQuantities[var5] = 0;
                                                         } else if(var30 == 1) {
                                                            var5 = field1044;
                                                            var6 = field1133;

                                                            while(var5 != var6) {
                                                               if(var5 > var6) {
                                                                  var43.method4074(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var43.method4074(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var43.method4074(field1133, field1044);
                                                         }

                                                         secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DRAG_ITEM);
                                                         secretPacketBuffer1.putLEInt(var30);
                                                         secretPacketBuffer1.putShortLE(field1133);
                                                         secretPacketBuffer1.putInt(class18.field325.id);
                                                         secretPacketBuffer1.putShortLE(field1044);
                                                      }
                                                   } else if(this.method1187()) {
                                                      this.method1188(field1069, field1046);
                                                   } else if(menuOptionCount > 0) {
                                                      var3 = field1069;
                                                      var4 = field1046;
                                                      class88 var39 = ScriptVarType.field178;
                                                      class66.menuAction(var39.field1404, var39.field1409, var39.field1406, var39.field1407, var39.field1408, var39.field1408, var3, var4);
                                                      ScriptVarType.field178 = null;
                                                   }

                                                   field1042 = 10;
                                                   MouseInput.field754 = 0;
                                                   class18.field325 = null;
                                                } else if(field1081 >= 5 && (MouseInput.field752 > field1069 + 5 || MouseInput.field752 < field1069 - 5 || MouseInput.field747 > field1046 + 5 || MouseInput.field747 < field1046 - 5)) {
                                                   field1048 = true;
                                                }
                                             }

                                             if(Region.method2750()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_246);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putShortLE(var3 + class149.baseX);
                                                secretPacketBuffer1.putShort(var4 + class67.baseY);
                                                secretPacketBuffer1.putLEInt(KeyFocusListener.field651[82]?(KeyFocusListener.field651[81]?2:1):0);
                                                Region.method2751();
                                                field1038 = MouseInput.field753;
                                                field995 = MouseInput.field739;
                                                cursorState = 1;
                                                field1040 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var33 != class56.field696) {
                                                if(var33 != null) {
                                                   class7.method34(var33);
                                                }

                                                if(class56.field696 != null) {
                                                   class7.method34(class56.field696);
                                                }
                                             }

                                             if(var34 != class48.field629 && field973 == field1083) {
                                                if(var34 != null) {
                                                   class7.method34(var34);
                                                }

                                                if(class48.field629 != null) {
                                                   class7.method34(class48.field629);
                                                }
                                             }

                                             if(class48.field629 != null) {
                                                if(field973 < field1083) {
                                                   ++field973;
                                                   if(field973 == field1083) {
                                                      class7.method34(class48.field629);
                                                   }
                                                }
                                             } else if(field973 > 0) {
                                                --field973;
                                             }

                                             var3 = Player.localPlayer.x;
                                             var4 = Player.localPlayer.y;
                                             if(WidgetNode.field851 - var3 < -500 || WidgetNode.field851 - var3 > 500 || BaseVarType.field34 - var4 < -500 || BaseVarType.field34 - var4 > 500) {
                                                WidgetNode.field851 = var3;
                                                BaseVarType.field34 = var4;
                                             }

                                             if(var3 != WidgetNode.field851) {
                                                WidgetNode.field851 += (var3 - WidgetNode.field851) / 16;
                                             }

                                             if(var4 != BaseVarType.field34) {
                                                BaseVarType.field34 += (var4 - BaseVarType.field34) / 16;
                                             }

                                             if(MouseInput.field745 == 4 && field951) {
                                                var5 = MouseInput.field747 - field1019;
                                                field1017 = var5 * 2;
                                                field1019 = var5 != -1 && var5 != 1?(MouseInput.field747 + field1019) / 2:MouseInput.field747;
                                                var6 = field1018 - MouseInput.field752;
                                                field989 = var6 * 2;
                                                field1018 = var6 != -1 && var6 != 1?(MouseInput.field752 + field1018) / 2:MouseInput.field752;
                                             } else {
                                                if(KeyFocusListener.field651[96]) {
                                                   field989 += (-24 - field989) / 2;
                                                } else if(KeyFocusListener.field651[97]) {
                                                   field989 += (24 - field989) / 2;
                                                } else {
                                                   field989 /= 2;
                                                }

                                                if(KeyFocusListener.field651[98]) {
                                                   field1017 += (12 - field1017) / 2;
                                                } else if(KeyFocusListener.field651[99]) {
                                                   field1017 += (-12 - field1017) / 2;
                                                } else {
                                                   field1017 /= 2;
                                                }

                                                field1019 = MouseInput.field747;
                                                field1018 = MouseInput.field752;
                                             }

                                             mapAngle = field989 / 2 + mapAngle & 2047;
                                             field956 += field1017 / 2;
                                             if(field956 < 128) {
                                                field956 = 128;
                                             }

                                             if(field956 > 383) {
                                                field956 = 383;
                                             }

                                             var5 = WidgetNode.field851 >> 7;
                                             var6 = BaseVarType.field34 >> 7;
                                             var7 = class227.getTileHeight(WidgetNode.field851, BaseVarType.field34, class27.plane);
                                             var8 = 0;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(int var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      int var11 = class27.plane;
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

                                             if(var9 > field1023) {
                                                field1023 += (var9 - field1023) / 24;
                                             } else if(var9 < field1023) {
                                                field1023 += (var9 - field1023) / 80;
                                             }

                                             if(field1178) {
                                                CacheFile.method2362();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1183[var3];
                                             }

                                             class2.chatMessages.process();
                                             var3 = ++MouseInput.mouseIdleTicks - 1;
                                             var5 = KeyFocusListener.keyboardIdleTicks;
                                             if(var3 > 15000 && var5 > 15000) {
                                                field1058 = 250;
                                                class91.method1761(14500);
                                                secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_217);
                                             }

                                             for(class67 var25 = (class67)field1200.method3711(); var25 != null; var25 = (class67)field1200.method3712()) {
                                                if((long)var25.field843 < class45.currentTimeMs() / 1000L - 5L) {
                                                   if(var25.field838 > 0) {
                                                      sendGameMessage(5, "", var25.field842 + " has logged in.");
                                                   }

                                                   if(var25.field838 == 0) {
                                                      sendGameMessage(5, "", var25.field842 + " has logged out.");
                                                   }

                                                   var25.method3726();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_80);
                                             }

                                             try {
                                                if(ScriptEvent.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   ScriptEvent.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var27) {
                                                if(field1058 > 0) {
                                                   class35.method518();
                                                } else {
                                                   WorldMapType2.setGameState(40);
                                                   class206.field2565 = ScriptEvent.rssocket;
                                                   ScriptEvent.rssocket = null;
                                                }
                                             }

                                             return;
                                          }

                                          var41 = var42.widget;
                                          if(var41.index < 0) {
                                             break;
                                          }

                                          var36 = GZipDecompressor.method3177(var41.parentId);
                                       } while(var36 == null || var36.children == null || var41.index >= var36.children.length || var41 != var36.children[var41.index]);

                                       class153.method3002(var42);
                                    }
                                 }

                                 var41 = var42.widget;
                                 if(var41.index < 0) {
                                    break;
                                 }

                                 var36 = GZipDecompressor.method3177(var41.parentId);
                              } while(var36 == null || var36.children == null || var41.index >= var36.children.length || var41 != var36.children[var41.index]);

                              class153.method3002(var42);
                           }
                        }

                        var41 = var42.widget;
                        if(var41.index < 0) {
                           break;
                        }

                        var36 = GZipDecompressor.method3177(var41.parentId);
                     } while(var36 == null || var36.children == null || var41.index >= var36.children.length || var41 != var36.children[var41.index]);

                     class153.method3002(var42);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "110745375"
   )
   final void method1180() {
      try {
         if(loginState == 0) {
            if(ScriptEvent.rssocket != null) {
               ScriptEvent.rssocket.close();
               ScriptEvent.rssocket = null;
            }

            Renderable.field2127 = null;
            socketError = false;
            field975 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(Renderable.field2127 == null) {
               Renderable.field2127 = GameEngine.taskManager.createSocket(class22.host, class111.myWorldPort);
            }

            if(Renderable.field2127.status == 2) {
               throw new IOException();
            }

            if(Renderable.field2127.status == 1) {
               ScriptEvent.rssocket = new RSSocket((Socket)Renderable.field2127.value, GameEngine.taskManager);
               Renderable.field2127 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            ScriptEvent.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(CacheFile.soundSystem0 != null) {
               CacheFile.soundSystem0.method2011();
            }

            if(class8.soundSystem1 != null) {
               class8.soundSystem1.method2011();
            }

            var1 = ScriptEvent.rssocket.readByte();
            if(CacheFile.soundSystem0 != null) {
               CacheFile.soundSystem0.method2011();
            }

            if(class8.soundSystem1 != null) {
               class8.soundSystem1.method2011();
            }

            if(var1 != 0) {
               class7.method35(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = ScriptEvent.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  ScriptEvent.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class67.field835 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         int var6;
         int var7;
         if(loginState == 5) {
            int[] var9 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class67.field835 >> 32), (int)(class67.field835 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(field1135.rsOrdinal());
            secretPacketBuffer1.putInt(var9[0]);
            secretPacketBuffer1.putInt(var9[1]);
            secretPacketBuffer1.putInt(var9[2]);
            secretPacketBuffer1.putInt(var9[3]);
            switch(field1135.field2211) {
            case 0:
               PacketBuffer var11 = secretPacketBuffer1;
               LinkedHashMap var12 = Buffer.preferences.preferences;
               String var5 = class91.username;
               var6 = var5.length();
               var7 = 0;

               for(int var8 = 0; var8 < var6; ++var8) {
                  var7 = (var7 << 5) - var7 + var5.charAt(var8);
               }

               var11.putInt(((Integer)var12.get(Integer.valueOf(var7))).intValue());
               secretPacketBuffer1.offset += 4;
               break;
            case 1:
            case 3:
               secretPacketBuffer1.put24bitInt(GroundObject.field1875);
               secretPacketBuffer1.offset += 5;
               break;
            case 2:
               secretPacketBuffer1.offset += 8;
            }

            secretPacketBuffer1.putString(class91.password);
            secretPacketBuffer1.encryptRsa(class89.rsaKeyExponent, class89.rsaKeyModulus);
            field1076.offset = 0;
            if(gameState == 40) {
               field1076.putByte(18);
            } else {
               field1076.putByte(16);
            }

            field1076.putShort(0);
            var2 = field1076.offset;
            field1076.putInt(154);
            field1076.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field1076.offset;
            field1076.putString(class91.username);
            field1076.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            field1076.putShort(class91.canvasWidth);
            field1076.putShort(class64.canvasHeight);
            PacketBuffer var4 = field1076;
            if(field979 != null) {
               var4.putBytes(field979, 0, field979.length);
            } else {
               byte[] var20 = Widget.method4075();
               var4.putBytes(var20, 0, var20.length);
            }

            field1076.putString(class25.sessionToken);
            field1076.putInt(MouseInput.field756);
            Buffer var21 = new Buffer(class3.field21.method5345());
            class3.field21.method5342(var21);
            field1076.putBytes(var21.payload, 0, var21.payload.length);
            field1076.putByte(class9.field251);
            field1076.putInt(0);
            field1076.putInt(Player.indexInterfaces.crc);
            field1076.putInt(class89.indexSoundEffects.crc);
            field1076.putInt(GameEngine.configsIndex.crc);
            field1076.putInt(DState.field2389.crc);
            field1076.putInt(class178.field2419.crc);
            field1076.putInt(RSCanvas.indexMaps.crc);
            field1076.putInt(class45.indexTrack1.crc);
            field1076.putInt(class272.indexModels.crc);
            field1076.putInt(GrandExchangeOffer.indexSprites.crc);
            field1076.putInt(class18.indexTextures.crc);
            field1076.putInt(InvType.field3283.crc);
            field1076.putInt(class46.indexTrack2.crc);
            field1076.putInt(class67.indexScripts.crc);
            field1076.putInt(class216.field2644.crc);
            field1076.putInt(class34.vorbisIndex.crc);
            field1076.putInt(class7.field235.crc);
            field1076.putInt(class111.indexWorldMap.crc);
            field1076.encryptXtea(var9, var3, field1076.offset);
            field1076.putShortLength(field1076.offset - var2);
            ScriptEvent.rssocket.queueForWrite(field1076.payload, 0, field1076.offset);
            secretPacketBuffer1.seed(var9);

            for(var6 = 0; var6 < 4; ++var6) {
               var9[var6] += 50;
            }

            secretPacketBuffer2.seed(var9);
            loginState = 6;
         }

         if(loginState == 6 && ScriptEvent.rssocket.available() > 0) {
            var1 = ScriptEvent.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field1175 < 1) {
               ++field1175;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class7.method35(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && ScriptEvent.rssocket.available() > 0) {
            field977 = (ScriptEvent.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field975 = 0;
            class228.method4112("You have only just left another world.", "Your profile will be transferred in:", field977 / 60 + " seconds.");
            if(--field977 <= 0) {
               loginState = 0;
            }

         } else {
            boolean var17;
            if(loginState == 9 && ScriptEvent.rssocket.available() >= 13) {
               boolean var18 = ScriptEvent.rssocket.readByte() == 1;
               ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               var17 = false;
               if(var18) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  String var19 = class91.username;
                  int var10 = var19.length();
                  var6 = 0;

                  for(var7 = 0; var7 < var10; ++var7) {
                     var6 = (var6 << 5) - var6 + var19.charAt(var7);
                  }

                  if(Buffer.preferences.preferences.size() >= 10 && !Buffer.preferences.preferences.containsKey(Integer.valueOf(var6))) {
                     Iterator var14 = Buffer.preferences.preferences.entrySet().iterator();
                     var14.next();
                     var14.remove();
                  }

                  Buffer.preferences.preferences.put(Integer.valueOf(var6), Integer.valueOf(var2));
               }

               if(class91.field1457) {
                  Buffer.preferences.field1319 = class91.username;
               } else {
                  Buffer.preferences.field1319 = null;
               }

               class20.method176();
               rights = ScriptEvent.rssocket.readByte();
               field952 = ScriptEvent.rssocket.readByte() == 1;
               localInteractingIndex = ScriptEvent.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += ScriptEvent.rssocket.readByte();
               field1053 = ScriptEvent.rssocket.readByte();
               ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  class52.method819(class87.clientInstance, "zap");
               } catch (Throwable var15) {
                  ;
               }

               loginState = 10;
            }

            if(loginState != 10) {
               if(loginState == 11 && ScriptEvent.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  RSCanvas.field676 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && ScriptEvent.rssocket.available() >= RSCanvas.field676) {
                  secretPacketBuffer2.offset = 0;
                  ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, RSCanvas.field676);
                  secretPacketBuffer2.offset = 0;
                  String var23 = secretPacketBuffer2.readString();
                  String var25 = secretPacketBuffer2.readString();
                  String var26 = secretPacketBuffer2.readString();
                  class228.method4112(var23, var25, var26);
                  WorldMapType2.setGameState(10);
               }

               if(loginState == 13) {
                  if(packetLength == -1) {
                     if(ScriptEvent.rssocket.available() < 2) {
                        return;
                     }

                     ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(ScriptEvent.rssocket.available() >= packetLength) {
                     ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     Frames.method2920();
                     class183.initializeGPI(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field975;
                  if(field975 > 2000) {
                     if(field1175 < 1) {
                        if(class111.myWorldPort == class262.field3628) {
                           class111.myWorldPort = WorldMapData.field472;
                        } else {
                           class111.myWorldPort = class262.field3628;
                        }

                        ++field1175;
                        loginState = 0;
                     } else {
                        class7.method35(-3);
                     }
                  }
               }
            } else {
               if(ScriptEvent.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  ScriptEvent.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  field1082 = -1L;
                  field954 = -1;
                  field970.field880 = 0;
                  GameEngine.field732 = true;
                  field955 = true;
                  field1156 = -1L;
                  GameObject.method2943();
                  secretPacketBuffer1.offset = 0;
                  secretPacketBuffer2.offset = 0;
                  packetType = -1;
                  lastFrameId = 1;
                  secondLastFrameId = -1;
                  thridLastFrameId = -1;
                  field990 = 0;
                  field1059 = 0;
                  field1058 = 0;
                  field958 = 0;
                  menuOptionCount = 0;
                  isMenuOpen = false;
                  class91.method1761(0);
                  class41.method615();
                  itemSelectionState = 0;
                  spellSelected = false;
                  field1172 = 0;
                  mapAngle = 0;
                  field1079 = 0;
                  field1159 = -1;
                  destinationX = 0;
                  destinationY = 0;
                  field967 = class90.field1426;
                  field968 = class90.field1426;
                  field946 = 0;
                  class95.field1507 = 0;

                  for(var1 = 0; var1 < 2048; ++var1) {
                     class95.field1506[var1] = null;
                     class95.field1513[var1] = 1;
                  }

                  for(var1 = 0; var1 < 2048; ++var1) {
                     cachedPlayers[var1] = null;
                  }

                  for(var1 = 0; var1 < '耀'; ++var1) {
                     cachedNPCs[var1] = null;
                  }

                  field1060 = -1;
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
                  field1198 = 0;
                  friendCount = 0;
                  ignoreCount = 0;

                  for(var1 = 0; var1 < VarPlayerType.field3291; ++var1) {
                     VarPlayerType var24 = class36.method520(var1);
                     if(var24 != null) {
                        class212.settings[var1] = 0;
                        class212.widgetSettings[var1] = 0;
                     }
                  }

                  class2.chatMessages.reset();
                  field1099 = -1;
                  if(widgetRoot != -1) {
                     var1 = widgetRoot;
                     if(var1 != -1 && class2.validInterfaces[var1]) {
                        Coordinates.widgetIndex.method4148(var1);
                        if(class268.widgets[var1] != null) {
                           var17 = true;

                           for(var3 = 0; var3 < class268.widgets[var1].length; ++var3) {
                              if(class268.widgets[var1][var3] != null) {
                                 if(class268.widgets[var1][var3].type != 2) {
                                    class268.widgets[var1][var3] = null;
                                 } else {
                                    var17 = false;
                                 }
                              }
                           }

                           if(var17) {
                              class268.widgets[var1] = null;
                           }

                           class2.validInterfaces[var1] = false;
                        }
                     }
                  }

                  for(WidgetNode var22 = (WidgetNode)componentTable.method3628(); var22 != null; var22 = (WidgetNode)componentTable.method3625()) {
                     MessageNode.method1143(var22, true);
                  }

                  widgetRoot = -1;
                  componentTable = new HashTable(8);
                  field1086 = null;
                  menuOptionCount = 0;
                  isMenuOpen = false;
                  field1078.method3994((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var1 = 0; var1 < 8; ++var1) {
                     playerOptions[var1] = null;
                     playerOptionsPriorities[var1] = false;
                  }

                  ItemContainer.itemContainers = new HashTable(32);
                  field1100 = true;

                  for(var1 = 0; var1 < 100; ++var1) {
                     field1110[var1] = true;
                  }

                  class17.method144();
                  clanChatOwner = null;
                  class13.clanChatCount = 0;
                  class223.clanMembers = null;

                  for(var1 = 0; var1 < 8; ++var1) {
                     grandExchangeOffers[var1] = new GrandExchangeOffer();
                  }

                  ISAACCipher.field2441 = null;
                  class183.initializeGPI(secretPacketBuffer2);
                  class27.field407 = -1;
                  class87.xteaChanged(false);
                  packetType = -1;
               }

            }
         }
      } catch (IOException var16) {
         if(field1175 < 1) {
            if(class111.myWorldPort == class262.field3628) {
               class111.myWorldPort = WorldMapData.field472;
            } else {
               class111.myWorldPort = class262.field3628;
            }

            ++field1175;
            loginState = 0;
         } else {
            class7.method35(-2);
         }
      }
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(Lhx;I)V",
      garbageValue = "371434410"
   )
   void method1426(Widget var1) {
      Widget var2 = var1.parentId == -1?null:GZipDecompressor.method3177(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class91.canvasWidth;
         var4 = class64.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class13.method82(var1, var3, var4, false);
      class237.method4225(var1, var3, var4);
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   final void method1186() {
      class212.method3969();
      if(class18.field325 == null) {
         if(field1111 == null) {
            int var1 = MouseInput.field754;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var8;
            int var9;
            int var10;
            if(isMenuOpen) {
               if(var1 != 1 && (field951 || var1 != 4)) {
                  var2 = MouseInput.field752;
                  var3 = MouseInput.field747;
                  if(var2 < class239.menuX - 10 || var2 > class239.menuX + class88.menuWidth + 10 || var3 < class43.menuY - 10 || var3 > class12.menuHeight + class43.menuY + 10) {
                     isMenuOpen = false;
                     ChatLineBuffer.method1867(class239.menuX, class43.menuY, class88.menuWidth, class12.menuHeight);
                  }
               }

               if(var1 == 1 || !field951 && var1 == 4) {
                  var2 = class239.menuX;
                  var3 = class43.menuY;
                  var4 = class88.menuWidth;
                  var5 = MouseInput.field753;
                  var6 = MouseInput.field739;
                  int var18 = -1;

                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = (menuOptionCount - 1 - var8) * 15 + var3 + 31;
                     if(var5 > var2 && var5 < var2 + var4 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var18 = var8;
                     }
                  }

                  if(var18 != -1 && var18 >= 0) {
                     var8 = menuActionParams0[var18];
                     var9 = menuActionParams1[var18];
                     var10 = menuTypes[var18];
                     int var17 = menuIdentifiers[var18];
                     String var12 = menuOptions[var18];
                     String var13 = menuTargets[var18];
                     class66.menuAction(var8, var9, var10, var17, var12, var13, MouseInput.field753, MouseInput.field739);
                  }

                  isMenuOpen = false;
                  ChatLineBuffer.method1867(class239.menuX, class43.menuY, class88.menuWidth, class12.menuHeight);
               }
            } else {
               var2 = class51.method817();
               if((var1 == 1 || !field951 && var1 == 4) && var2 >= 0) {
                  var3 = menuTypes[var2];
                  if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                     label263: {
                        var4 = menuActionParams0[var2];
                        var5 = menuActionParams1[var2];
                        Widget var16 = GZipDecompressor.method3177(var5);
                        var8 = Coordinates.getWidgetConfig(var16);
                        boolean var7 = (var8 >> 28 & 1) != 0;
                        if(!var7) {
                           Object var10000 = null;
                           if(!class169.method3212(Coordinates.getWidgetConfig(var16))) {
                              break label263;
                           }
                        }

                        if(class18.field325 != null && !field1048 && menuOptionCount > 0 && !this.method1187()) {
                           var9 = field1069;
                           var10 = field1046;
                           class88 var11 = ScriptVarType.field178;
                           class66.menuAction(var11.field1404, var11.field1409, var11.field1406, var11.field1407, var11.field1408, var11.field1408, var9, var10);
                           ScriptVarType.field178 = null;
                        }

                        field1048 = false;
                        field1081 = 0;
                        if(class18.field325 != null) {
                           class7.method34(class18.field325);
                        }

                        class18.field325 = GZipDecompressor.method3177(var5);
                        field1044 = var4;
                        field1069 = MouseInput.field753;
                        field1046 = MouseInput.field739;
                        if(var2 >= 0) {
                           class34.method514(var2);
                        }

                        class7.method34(class18.field325);
                        return;
                     }
                  }
               }

               if((var1 == 1 || !field951 && var1 == 4) && this.method1187()) {
                  var1 = 2;
               }

               if((var1 == 1 || !field951 && var1 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var3 = menuActionParams0[var2];
                  var4 = menuActionParams1[var2];
                  var5 = menuTypes[var2];
                  var6 = menuIdentifiers[var2];
                  String var14 = menuOptions[var2];
                  String var15 = menuTargets[var2];
                  class66.menuAction(var3, var4, var5, var6, var14, var15, MouseInput.field753, MouseInput.field739);
               }

               if(var1 == 2 && menuOptionCount > 0) {
                  this.method1188(MouseInput.field753, MouseInput.field739);
               }
            }

         }
      }
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1646701605"
   )
   final void method1405() {
      class7.method34(field1111);
      ++class54.field682;
      if(field1112 && field1209) {
         int var1 = MouseInput.field752;
         int var2 = MouseInput.field747;
         var1 -= field1106;
         var2 -= field1107;
         if(var1 < field1011) {
            var1 = field1011;
         }

         if(var1 + field1111.width > field1011 + field1045.width) {
            var1 = field1011 + field1045.width - field1111.width;
         }

         if(var2 < field1182) {
            var2 = field1182;
         }

         if(var2 + field1111.height > field1182 + field1045.height) {
            var2 = field1182 + field1045.height - field1111.height;
         }

         int var3 = var1 - field1127;
         int var4 = var2 - field1114;
         int var5 = field1111.field2659;
         if(class54.field682 > field1111.field2649 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1115 = true;
         }

         int var6 = var1 - field1011 + field1045.scrollX;
         int var7 = var2 - field1182 + field1045.scrollY;
         ScriptEvent var8;
         if(field1111.field2747 != null && field1115) {
            var8 = new ScriptEvent();
            var8.widget = field1111;
            var8.field859 = var6;
            var8.field860 = var7;
            var8.field864 = field1111.field2747;
            class153.method3002(var8);
         }

         if(MouseInput.field745 == 0) {
            if(field1115) {
               if(field1111.field2730 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1111;
                  var8.field859 = var6;
                  var8.field860 = var7;
                  var8.field862 = field1108;
                  var8.field864 = field1111.field2730;
                  class153.method3002(var8);
               }

               if(field1108 != null) {
                  Widget var9 = field1111;
                  int var10 = Actor.method1537(Coordinates.getWidgetConfig(var9));
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

                        var9 = GZipDecompressor.method3177(var9.parentId);
                        if(var9 == null) {
                           var15 = null;
                           break;
                        }

                        ++var11;
                     }
                  }

                  if(var15 != null) {
                     secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DRAG_ITEM_ACROSS_WIDGETS);
                     secretPacketBuffer1.method3273(field1111.index);
                     secretPacketBuffer1.method3273(field1108.index);
                     secretPacketBuffer1.method3288(field1108.id);
                     secretPacketBuffer1.putShort(field1111.itemId);
                     secretPacketBuffer1.putShort(field1108.itemId);
                     secretPacketBuffer1.method3288(field1111.id);
                  }
               }
            } else if(this.method1187()) {
               this.method1188(field1127 + field1106, field1107 + field1114);
            } else if(menuOptionCount > 0) {
               int var12 = field1106 + field1127;
               int var13 = field1114 + field1107;
               class88 var14 = ScriptVarType.field178;
               class66.menuAction(var14.field1404, var14.field1409, var14.field1406, var14.field1407, var14.field1408, var14.field1408, var12, var13);
               ScriptVarType.field178 = null;
            }

            field1111 = null;
         }

      } else {
         if(class54.field682 > 1) {
            field1111 = null;
         }

      }
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = ScriptEvent.method1130();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Parameters var3 = var1[var2];
            String var4 = this.getParameter(var3.key);
            if(var4 != null) {
               switch(Integer.parseInt(var3.key)) {
               case 1:
                  socketType = Integer.parseInt(var4);
               case 2:
               case 7:
               default:
                  break;
               case 3:
                  class233[] var5 = new class233[]{class233.field3192, class233.field3197, class233.field3194, class233.field3195, class233.field3201, class233.field3191};
                  class56.field695 = (class233)class88.forOrdinal(var5, Integer.parseInt(var4));
                  if(class233.field3197 == class56.field695) {
                     class8.field243 = class290.field3859;
                  } else {
                     class8.field243 = class290.field3860;
                  }
                  break;
               case 4:
                  world = Integer.parseInt(var4);
                  break;
               case 5:
                  class17.field321 = var4;
                  break;
               case 6:
                  class25.sessionToken = var4;
                  break;
               case 8:
                  if(var4.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 9:
                  flags = Integer.parseInt(var4);
                  break;
               case 10:
                  if(var4.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 11:
                  class111.field1671 = class226.method4107(Integer.parseInt(var4));
                  break;
               case 12:
                  MouseInput.field756 = Integer.parseInt(var4);
                  break;
               case 13:
                  class9.field251 = Integer.parseInt(var4);
                  break;
               case 14:
                  languageId = Integer.parseInt(var4);
               }
            }
         }

         Region.lowMemory = false;
         lowMemory = false;
         class22.host = this.getCodeBase().getHost();
         String var32 = class111.field1671.identifier;
         byte var33 = 0;

         try {
            class281.field3756 = 17;
            class39.field551 = var33;

            try {
               CacheFile.osName = System.getProperty("os.name");
            } catch (Exception var28) {
               CacheFile.osName = "Unknown";
            }

            Parameters.osNameLC = CacheFile.osName.toLowerCase();

            try {
               class156.userHome = System.getProperty("user.home");
               if(class156.userHome != null) {
                  class156.userHome = class156.userHome + "/";
               }
            } catch (Exception var27) {
               ;
            }

            try {
               if(Parameters.osNameLC.startsWith("win")) {
                  if(class156.userHome == null) {
                     class156.userHome = System.getenv("USERPROFILE");
                  }
               } else if(class156.userHome == null) {
                  class156.userHome = System.getenv("HOME");
               }

               if(class156.userHome != null) {
                  class156.userHome = class156.userHome + "/";
               }
            } catch (Exception var26) {
               ;
            }

            if(class156.userHome == null) {
               class156.userHome = "~/";
            }

            class139.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class156.userHome, "/tmp/", ""};
            Huffman.field2323 = new String[]{".jagex_cache_" + class39.field551, ".file_store_" + class39.field551};
            int var17 = 0;

            label258:
            while(var17 < 4) {
               String var36 = var17 == 0?"":"" + var17;
               class212.field2609 = new File(class156.userHome, "jagex_cl_oldschool_" + var32 + var36 + ".dat");
               String var6 = null;
               String var7 = null;
               boolean var8 = false;
               Buffer var10;
               File var39;
               if(class212.field2609.exists()) {
                  try {
                     FileOnDisk var9 = new FileOnDisk(class212.field2609, "rw", 10000L);

                     int var11;
                     for(var10 = new Buffer((int)var9.length()); var10.offset < var10.payload.length; var10.offset += var11) {
                        var11 = var9.read(var10.payload, var10.offset, var10.payload.length - var10.offset);
                        if(var11 == -1) {
                           throw new IOException();
                        }
                     }

                     var10.offset = 0;
                     var11 = var10.readUnsignedByte();
                     if(var11 < 1 || var11 > 3) {
                        throw new IOException("" + var11);
                     }

                     int var12 = 0;
                     if(var11 > 1) {
                        var12 = var10.readUnsignedByte();
                     }

                     if(var11 <= 2) {
                        var6 = var10.getJagString();
                        if(var12 == 1) {
                           var7 = var10.getJagString();
                        }
                     } else {
                        var6 = var10.getCESU8();
                        if(var12 == 1) {
                           var7 = var10.getCESU8();
                        }
                     }

                     var9.close();
                  } catch (IOException var30) {
                     var30.printStackTrace();
                  }

                  if(var6 != null) {
                     var39 = new File(var6);
                     if(!var39.exists()) {
                        var6 = null;
                     }
                  }

                  if(var6 != null) {
                     var39 = new File(var6, "test.dat");
                     if(!ScriptEvent.method1122(var39, true)) {
                        var6 = null;
                     }
                  }
               }

               if(var6 == null && var17 == 0) {
                  label233:
                  for(int var18 = 0; var18 < Huffman.field2323.length; ++var18) {
                     for(int var19 = 0; var19 < class139.cacheLocations.length; ++var19) {
                        File var20 = new File(class139.cacheLocations[var19] + Huffman.field2323[var18] + File.separatorChar + "oldschool" + File.separatorChar);
                        if(var20.exists() && ScriptEvent.method1122(new File(var20, "test.dat"), true)) {
                           var6 = var20.toString();
                           var8 = true;
                           break label233;
                        }
                     }
                  }
               }

               if(var6 == null) {
                  var6 = class156.userHome + File.separatorChar + "jagexcache" + var36 + File.separatorChar + "oldschool" + File.separatorChar + var32 + File.separatorChar;
                  var8 = true;
               }

               File var38;
               if(var7 != null) {
                  var38 = new File(var7);
                  var39 = new File(var6);

                  try {
                     File[] var41 = var38.listFiles();
                     File[] var21 = var41;

                     for(int var13 = 0; var13 < var21.length; ++var13) {
                        File var14 = var21[var13];
                        File var15 = new File(var39, var14.getName());
                        boolean var16 = var14.renameTo(var15);
                        if(!var16) {
                           throw new IOException();
                        }
                     }
                  } catch (Exception var29) {
                     var29.printStackTrace();
                  }

                  var8 = true;
               }

               if(var8) {
                  var38 = new File(var6);
                  var10 = null;

                  try {
                     FileOnDisk var42 = new FileOnDisk(class212.field2609, "rw", 10000L);
                     Buffer var43 = new Buffer(500);
                     var43.putByte(3);
                     var43.putByte(var10 != null?1:0);
                     var43.putCESU8(var38.getPath());
                     if(var10 != null) {
                        var43.putCESU8("");
                     }

                     var42.write(var43.payload, 0, var43.offset);
                     var42.close();
                  } catch (IOException var25) {
                     var25.printStackTrace();
                  }
               }

               File var35 = new File(var6);
               class46.field612 = var35;
               if(!class46.field612.exists()) {
                  class46.field612.mkdirs();
               }

               File[] var37 = class46.field612.listFiles();
               if(var37 != null) {
                  File[] var40 = var37;

                  for(int var22 = 0; var22 < var40.length; ++var22) {
                     File var23 = var40[var22];
                     if(!ScriptEvent.method1122(var23, false)) {
                        ++var17;
                        continue label258;
                     }
                  }
               }
               break;
            }

            File var34 = class46.field612;
            class158.field2265 = var34;
            if(!class158.field2265.exists()) {
               throw new RuntimeException("");
            }

            class158.field2260 = true;
            class64.method1113();
            class156.field2250 = new CacheFile(new FileOnDisk(class29.method273("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
            class156.field2255 = new CacheFile(new FileOnDisk(class29.method273("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            class54.field685 = new CacheFile[class281.field3756];

            for(int var24 = 0; var24 < class281.field3756; ++var24) {
               class54.field685[var24] = new CacheFile(new FileOnDisk(class29.method273("main_file_cache.idx" + var24), "rw", 1048576L), 6000, 0);
            }
         } catch (Exception var31) {
            class150.method2975((String)null, var31);
         }

         class87.clientInstance = this;
         this.initialize(765, 503, 154);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "349791608"
   )
   public static void method1311() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field657 = KeyFocusListener.field661;
         KeyFocusListener.field652 = 0;
         int var1;
         if(KeyFocusListener.field654 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.field651[var1] = false;
            }

            KeyFocusListener.field654 = KeyFocusListener.field653;
         } else {
            while(KeyFocusListener.field654 != KeyFocusListener.field653) {
               var1 = KeyFocusListener.field642[KeyFocusListener.field653];
               KeyFocusListener.field653 = KeyFocusListener.field653 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.field651[~var1] = false;
               } else {
                  if(!KeyFocusListener.field651[var1] && KeyFocusListener.field652 < KeyFocusListener.field646.length - 1) {
                     KeyFocusListener.field646[++KeyFocusListener.field652 - 1] = var1;
                  }

                  KeyFocusListener.field651[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field652 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field661 = KeyFocusListener.field658;
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-22787"
   )
   static final void method1515(int var0, int var1, int var2, int var3) {
      ++field1035;
      class19.method173(class66.field828);
      boolean var4 = false;
      int var5;
      int var7;
      if(field1060 >= 0) {
         var5 = class95.field1507;
         int[] var6 = class95.field1511;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == field1060) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class19.method173(class66.field829);
      }

      class27.method249(true);
      class19.method173(var4?class66.field830:class66.field831);
      class27.method249(false);
      class48.method753();

      for(GraphicsObject var19 = (GraphicsObject)graphicsObjectDeque.getFront(); var19 != null; var19 = (GraphicsObject)graphicsObjectDeque.getNext()) {
         if(var19.level == class27.plane && !var19.finished) {
            if(gameCycle >= var19.startCycle) {
               var19.method1685(field1007);
               if(var19.finished) {
                  var19.unlink();
               } else {
                  ScriptState.region.method2877(var19.level, var19.x, var19.y, var19.height, 60, var19, 0, -1, false);
               }
            }
         } else {
            var19.unlink();
         }
      }

      class33.method383(var0, var1, var2, var3, true);
      var0 = field1192;
      var1 = field1193;
      var2 = viewportHeight;
      var3 = viewportWidth;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2616();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var20;
      if(!field1178) {
         var5 = field956;
         if(field1023 / 256 > var5) {
            var5 = field1023 / 256;
         }

         if(field1179[4] && field1181[4] + 128 > var5) {
            var5 = field1181[4] + 128;
         }

         var20 = mapAngle & 2047;
         var7 = WidgetNode.field851;
         var8 = class227.getTileHeight(Player.localPlayer.x, Player.localPlayer.y, class27.plane) - field1020;
         var9 = BaseVarType.field34;
         var10 = 600 + var5 * 3;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var20 & 2047;
         var13 = 0;
         var14 = 0;
         int var15 = var10;
         int var16;
         int var17;
         int var18;
         if(var11 != 0) {
            var16 = Graphics3D.SINE[var11];
            var17 = Graphics3D.COSINE[var11];
            var18 = var14 * var17 - var10 * var16 >> 16;
            var15 = var10 * var17 + var14 * var16 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = Graphics3D.SINE[var12];
            var17 = Graphics3D.COSINE[var12];
            var18 = var17 * var13 + var16 * var15 >> 16;
            var15 = var15 * var17 - var13 * var16 >> 16;
            var13 = var18;
         }

         class82.cameraX = var7 - var13;
         Ignore.cameraZ = var8 - var14;
         class158.cameraY = var9 - var15;
         Friend.cameraPitch = var5;
         Ignore.cameraYaw = var20;
      }

      if(!field1178) {
         var5 = class45.method696();
      } else {
         var5 = class9.method48();
      }

      var20 = class82.cameraX;
      var7 = Ignore.cameraZ;
      var8 = class158.cameraY;
      var9 = Friend.cameraPitch;
      var10 = Ignore.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(field1179[var11]) {
            var12 = (int)(Math.random() * (double)(1 + field1180[var11] * 2) - (double)field1180[var11] + Math.sin((double)field1183[var11] * ((double)field1145[var11] / 100.0D)) * (double)field1181[var11]);
            if(var11 == 0) {
               class82.cameraX += var12;
            }

            if(var11 == 1) {
               Ignore.cameraZ += var12;
            }

            if(var11 == 2) {
               class158.cameraY += var12;
            }

            if(var11 == 3) {
               Ignore.cameraYaw = var12 + Ignore.cameraYaw & 2047;
            }

            if(var11 == 4) {
               Friend.cameraPitch += var12;
               if(Friend.cameraPitch < 128) {
                  Friend.cameraPitch = 128;
               }

               if(Friend.cameraPitch > 383) {
                  Friend.cameraPitch = 383;
               }
            }
         }
      }

      var11 = MouseInput.field752;
      var12 = MouseInput.field747;
      if(MouseInput.field754 != 0) {
         var11 = MouseInput.field753;
         var12 = MouseInput.field739;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         var13 = var11 - var0;
         var14 = var12 - var1;
         class133.field2002 = var13;
         class133.field2001 = var14;
         class133.field2011 = true;
         class133.field2009 = 0;
         class133.field2004 = false;
      } else {
         class133.field2011 = false;
         class133.field2009 = 0;
      }

      WorldMapType3.method239();
      Rasterizer2D.method4890(var0, var1, var2, var3, 0);
      WorldMapType3.method239();
      var13 = Graphics3D.field2030;
      Graphics3D.field2030 = scale;
      ScriptState.region.draw(class82.cameraX, Ignore.cameraZ, class158.cameraY, Friend.cameraPitch, Ignore.cameraYaw, var5);

      while(true) {
         class9 var21 = (class9)class7.field231.method3654();
         if(var21 == null) {
            Graphics3D.field2030 = var13;
            WorldMapType3.method239();
            ScriptState.region.clearEntities();
            class182.method3529(var0, var1, var2, var3);
            method1425(var0, var1);
            ((TextureProvider)Graphics3D.textureLoader).method2398(field1007);
            class23.method196(var0, var1, var2, var3);
            class82.cameraX = var20;
            Ignore.cameraZ = var7;
            class158.cameraY = var8;
            Friend.cameraPitch = var9;
            Ignore.cameraYaw = var10;
            if(field1100 && class56.method869(true, false) == 0) {
               field1100 = false;
            }

            if(field1100) {
               Rasterizer2D.method4890(var0, var1, var2, var3, 0);
               ScriptState.drawStatusBox("Loading - please wait.", false);
            }

            return;
         }

         var21.vmethod58();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-153778953"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class29.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lii;Ljava/lang/String;Ljava/lang/String;I)Ljx;",
      garbageValue = "-819845241"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!class178.method3474(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class46.method730();
      }

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-39"
   )
   static final int method1517(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (var2 * var2 * 15731 + 789221) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "745358040"
   )
   static final String method1514(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?Friend.getColTags(16711680):(var2 < -6?Friend.getColTags(16723968):(var2 < -3?Friend.getColTags(16740352):(var2 < 0?Friend.getColTags(16756736):(var2 > 9?Friend.getColTags('\uff00'):(var2 > 6?Friend.getColTags(4259584):(var2 > 3?Friend.getColTags(8453888):(var2 > 0?Friend.getColTags(12648192):Friend.getColTags(16776960))))))));
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-644667398"
   )
   static final void method1425(int var0, int var1) {
      if(field958 == 2) {
         class56.method865((hintArrowX - class149.baseX << 7) + field987, (hintArrowY - class67.baseY << 7) + field965, hintArrowType * 2);
         if(screenY > -1 && gameCycle % 20 < 10) {
            class10.pkIcons[0].method5019(var0 + screenY - 12, screenX + var1 - 28);
         }

      }
   }
}
