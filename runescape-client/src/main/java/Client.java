import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
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
   @ObfuscatedName("ao")
   static boolean field1060;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 631890557
   )
   static int field1070;
   @ObfuscatedName("ks")
   @ObfuscatedGetter(
      intValue = -1836472213
   )
   @Export("widgetRoot")
   static int widgetRoot;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -987665585
   )
   @Export("socketType")
   static int socketType;
   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field1077;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1915155765
   )
   @Export("gameCycle")
   static int gameCycle;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = -362932465
   )
   @Export("loginState")
   static int loginState;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 1371415955
   )
   @Export("menuOptionCount")
   static int menuOptionCount;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -959153159
   )
   @Export("gameState")
   @Hook("gameStateChanged")
   static int gameState;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -2106757991
   )
   static int field949;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -2119042967
   )
   @Export("world")
   static int world;
   @ObfuscatedName("eh")
   @ObfuscatedGetter(
      intValue = 590954829
   )
   static int field967;
   @ObfuscatedName("ma")
   @ObfuscatedGetter(
      intValue = 892618013
   )
   static int field1107;
   @ObfuscatedName("mn")
   @ObfuscatedGetter(
      intValue = 667756971
   )
   static int field1108;
   @ObfuscatedName("mf")
   @ObfuscatedGetter(
      longValue = 5728630551881342987L
   )
   static long field1050;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -451990819
   )
   static int field932;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1360784625
   )
   @Export("js5State")
   static int js5State;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 150933929
   )
   static int field1041;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 420879351
   )
   @Export("flags")
   static int flags;
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "Lbe;"
   )
   static class71 field1038;
   @ObfuscatedName("jr")
   @Export("menuTypes")
   static int[] menuTypes;
   @ObfuscatedName("md")
   static boolean[] field1109;
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = 1285107477
   )
   @Export("packetType")
   static int packetType;
   @ObfuscatedName("mr")
   static boolean[] field1111;
   @ObfuscatedName("mb")
   static boolean[] field1064;
   @ObfuscatedName("je")
   static boolean[] field984;
   @ObfuscatedName("jh")
   @Export("isMenuOpen")
   static boolean isMenuOpen;
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = 449517677
   )
   static int field1053;
   @ObfuscatedName("jl")
   @Export("menuTargets")
   static String[] menuTargets;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = 41788003
   )
   @Export("secondLastFrameId")
   static int secondLastFrameId;
   @ObfuscatedName("lt")
   static boolean field1085;
   @ObfuscatedName("bo")
   @Export("isMembers")
   public static boolean isMembers;
   @ObfuscatedName("eq")
   @Export("socketError")
   static boolean socketError;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = 1562974981
   )
   @Export("packetLength")
   static int packetLength;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = 1341460123
   )
   static int field1054;
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("secretPacketBuffer2")
   static PacketBuffer secretPacketBuffer2;
   @ObfuscatedName("lw")
   static boolean field1082;
   @ObfuscatedName("bi")
   @Export("lowMemory")
   static boolean lowMemory;
   @ObfuscatedName("jb")
   @Export("menuOptions")
   static String[] menuOptions;
   @ObfuscatedName("ea")
   @ObfuscatedGetter(
      intValue = 1207065919
   )
   @Export("thridLastFrameId")
   static int thridLastFrameId;
   @ObfuscatedName("mi")
   @Export("isResized")
   static boolean isResized;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1974399939
   )
   @Export("languageId")
   static int languageId;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -120928697
   )
   static int field976;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -1234183383
   )
   static int field946;
   @ObfuscatedName("kc")
   static boolean field1074;
   @ObfuscatedName("ox")
   static boolean field1141;
   @ObfuscatedName("bc")
   static boolean field922;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = 1803365847
   )
   static int field1079;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lfu;"
   )
   @Export("collisionMaps")
   static CollisionData[] collisionMaps;
   @ObfuscatedName("jo")
   @Export("menuActionParams0")
   static int[] menuActionParams0;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = 1061379059
   )
   static int field1160;
   @ObfuscatedName("jg")
   @Export("menuActionParams1")
   static int[] menuActionParams1;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      longValue = 319301329601290405L
   )
   static long field924;
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = 1901629823
   )
   static int field1083;
   @ObfuscatedName("ob")
   @ObfuscatedGetter(
      intValue = -1429432627
   )
   static int field1140;
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("secretPacketBuffer1")
   static PacketBuffer secretPacketBuffer1;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1718737551
   )
   static int field926;
   @ObfuscatedName("mg")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("widgetFlags")
   static XHashTable widgetFlags;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1301532035
   )
   static int field927;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1474613431
   )
   static int field974;
   @ObfuscatedName("jz")
   @Export("menuIdentifiers")
   static int[] menuIdentifiers;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1704582815
   )
   static int field969;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 1288956057
   )
   static int field970;
   @ObfuscatedName("lk")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field1147;
   @ObfuscatedName("bb")
   static boolean field929;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1899908157
   )
   static int field1066;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 337763345
   )
   static int field971;
   @ObfuscatedName("ml")
   @ObfuscatedGetter(
      intValue = -1535531061
   )
   @Export(
      value = "gameDrawingMode",
      setter = true
   )
   static int gameDrawingMode;
   @ObfuscatedName("bt")
   @Export("displayFps")
   static boolean displayFps;
   @ObfuscatedName("mk")
   @Export("widgetPositionX")
   static int[] widgetPositionX;
   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("componentTable")
   static XHashTable componentTable;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = 1710870965
   )
   static int field972;
   @ObfuscatedName("ig")
   static boolean field1101;
   @ObfuscatedName("mh")
   @Export("widgetBoundsWidth")
   static int[] widgetBoundsWidth;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -55884511
   )
   static int field1084;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -455091179
   )
   static int field1024;
   @ObfuscatedName("jp")
   @Export("boostedSkillLevels")
   static int[] boostedSkillLevels;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -681215707
   )
   static int field1022;
   @ObfuscatedName("kb")
   @ObfuscatedGetter(
      intValue = -1294562773
   )
   @Export("itemSelectionState")
   static int itemSelectionState;
   @ObfuscatedName("jn")
   @Export("realSkillLevels")
   static int[] realSkillLevels;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -210700517
   )
   static int field992;
   @ObfuscatedName("rl")
   @ObfuscatedSignature(
      signature = "Lbb;"
   )
   static final class73 field1179;
   @ObfuscatedName("ku")
   @Export("spellSelected")
   static boolean spellSelected;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1708772725
   )
   static int field933;
   @ObfuscatedName("jt")
   @Export("skillExperiences")
   @Hook("experienceChanged")
   static int[] skillExperiences;
   @ObfuscatedName("mo")
   @Export("widgetPositionY")
   static int[] widgetPositionY;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -508008355
   )
   static int field1143;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1689948637
   )
   static int field1150;
   @ObfuscatedName("mz")
   @Export("widgetBoundsHeight")
   static int[] widgetBoundsHeight;
   @ObfuscatedName("ip")
   @ObfuscatedGetter(
      intValue = -44592377
   )
   static int field1019;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 451976645
   )
   @Export("hintArrowX")
   static int hintArrowX;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1536848869
   )
   static int field941;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -414384217
   )
   @Export("hintArrowY")
   static int hintArrowY;
   @ObfuscatedName("kp")
   static String field1062;
   @ObfuscatedName("it")
   static String field1058;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1305478273
   )
   @Export("hintArrowType")
   static int hintArrowType;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 487913581
   )
   static int field988;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1205094599
   )
   static int field938;
   @ObfuscatedName("kl")
   static String field1063;
   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field977;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1935581019
   )
   static int field1117;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -77701057
   )
   static int field1086;
   @ObfuscatedName("rh")
   static int[] field1180;
   @ObfuscatedName("ri")
   static int[] field1181;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   static class91 field940;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = 31223383
   )
   static int field931;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 128802421
   )
   static int field1075;
   @ObfuscatedName("kq")
   @ObfuscatedGetter(
      intValue = 194705209
   )
   @Export("energy")
   static int energy;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   static class91 field1161;
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = -900394913
   )
   @Export("weight")
   static int weight;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -351004891
   )
   @Export("loadingStage")
   static int loadingStage;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = -424494199
   )
   static int field1182;
   @ObfuscatedName("mx")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   static Deque field1103;
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "[Lbt;"
   )
   @Export("cachedPlayers")
   static Player[] cachedPlayers;
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static PlayerComposition field1080;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = -408316381
   )
   static int field962;
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 1794836053
   )
   static int field1035;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -1611247881
   )
   static int field1011;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 770836871
   )
   static int field1102;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -989783171
   )
   static int field1012;
   @ObfuscatedName("li")
   static boolean field1088;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -777050145
   )
   @Export("cursorState")
   static int cursorState;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -507593661
   )
   @Export("lastFrameId")
   static int lastFrameId;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -1386234939
   )
   static int field950;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -1402677733
   )
   static int field1013;
   @ObfuscatedName("dz")
   static byte[] field951;
   @ObfuscatedName("ou")
   @ObfuscatedGetter(
      intValue = 1528364403
   )
   @Export("destinationX")
   static int destinationX;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "[Lcj;"
   )
   @Export("cachedNPCs")
   static NPC[] cachedNPCs;
   @ObfuscatedName("oh")
   @ObfuscatedGetter(
      intValue = 1095308317
   )
   @Export("destinationY")
   static int destinationY;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 815205045
   )
   static int field953;
   @ObfuscatedName("dd")
   @Export("npcIndices")
   static int[] npcIndices;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -1826893443
   )
   @Export("pendingNpcFlagsCount")
   static int pendingNpcFlagsCount;
   @ObfuscatedName("eg")
   @Export("pendingNpcFlagsIndices")
   static int[] pendingNpcFlagsIndices;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 526105725
   )
   static int field1156;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = 1097252769
   )
   @Export("audioEffectCount")
   static int audioEffectCount;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -1744874451
   )
   static int field1017;
   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field1068;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -1929896955
   )
   static int field1177;
   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   static PacketBuffer field1132;
   @ObfuscatedName("pj")
   static boolean field1008;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 1698714861
   )
   @Export("ignoreCount")
   static int ignoreCount;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 994270733
   )
   static int field1003;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 579743609
   )
   static int field1055;
   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("pendingSpawns")
   static Deque pendingSpawns;
   @ObfuscatedName("qo")
   @ObfuscatedSignature(
      signature = "[Lbq;"
   )
   @Export("ignores")
   static Ignore[] ignores;
   @ObfuscatedName("ep")
   static HashMap field1002;
   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "[[[Lge;"
   )
   @Export("groundItemDeque")
   static Deque[][][] groundItemDeque;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = 586267617
   )
   @Export("rights")
   static int rights;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 1232279817
   )
   static int field1027;
   @ObfuscatedName("lf")
   static int[] field1090;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = 1612806221
   )
   @Export("cycleCntr")
   static int cycleCntr;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -220669979
   )
   static int field994;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -1491227463
   )
   static int field1142;
   @ObfuscatedName("lz")
   @ObfuscatedGetter(
      intValue = 2080319813
   )
   static int field1091;
   @ObfuscatedName("ld")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field923;
   @ObfuscatedName("rm")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "[Le;"
   )
   @Export("grandExchangeOffers")
   static XGrandExchangeOffer[] grandExchangeOffers;
   @ObfuscatedName("fa")
   @Export("isDynamicRegion")
   static boolean isDynamicRegion;
   @ObfuscatedName("hf")
   static boolean field1146;
   @ObfuscatedName("in")
   static int[] field1028;
   @ObfuscatedName("mt")
   @ObfuscatedGetter(
      intValue = 1404170393
   )
   static int field1099;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -2137757855
   )
   static int field1170;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 61175583
   )
   static int field1021;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = -1895231685
   )
   static int field1138;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 723248743
   )
   @Export("friendCount")
   static int friendCount;
   @ObfuscatedName("qz")
   @ObfuscatedSignature(
      signature = "[Lbs;"
   )
   @Export("friends")
   static Friend[] friends;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = 1040194387
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      longValue = 1368073319280919519L
   )
   static long field1128;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 1830253099
   )
   @Export("mapAngle")
   static int mapAngle;
   @ObfuscatedName("fj")
   static int[][][] field1133;
   @ObfuscatedName("lh")
   @Export("interfaceItemTriggers")
   static int[] interfaceItemTriggers;
   @ObfuscatedName("lx")
   @ObfuscatedGetter(
      intValue = -1793190369
   )
   static int field1145;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -1107554525
   )
   static int field987;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1043679663
   )
   static int field917;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 2131174069
   )
   @Export("localInteractingIndex")
   static int localInteractingIndex;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -116884765
   )
   static int field1121;
   @ObfuscatedName("ok")
   @ObfuscatedGetter(
      intValue = 1463588311
   )
   static int field1139;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 2034413371
   )
   static int field980;
   @ObfuscatedName("ms")
   @ObfuscatedGetter(
      intValue = 370647979
   )
   static int field1098;
   @ObfuscatedName("kd")
   static boolean field1073;
   @ObfuscatedName("nl")
   static long[] field1123;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = 591608777
   )
   static int field1033;
   @ObfuscatedName("pd")
   static boolean[] field959;
   @ObfuscatedName("if")
   @ObfuscatedGetter(
      intValue = 376520549
   )
   static int field1023;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = -944287637
   )
   static int field1114;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -1805657029
   )
   static int field1131;
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = 1289603715
   )
   static int field1136;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = 186539865
   )
   static int field937;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 1174687615
   )
   static int field1100;
   @ObfuscatedName("fs")
   static final int[] field978;
   @ObfuscatedName("na")
   @Export("clanChatOwner")
   static String clanChatOwner;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 314765233
   )
   static int field1056;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 2103844655
   )
   static int field1032;
   @ObfuscatedName("nj")
   @Export("clanChatName")
   static String clanChatName;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1605992205
   )
   static int field1026;
   @ObfuscatedName("nh")
   static int[] field1039;
   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   static class195 field1172;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -202814243
   )
   static int field982;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1904256261
   )
   static int field1127;
   @ObfuscatedName("oj")
   static int[] field1134;
   @ObfuscatedName("id")
   static int[] field983;
   @ObfuscatedName("gg")
   static boolean field1076;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = 1281435697
   )
   static int field985;
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -797129391
   )
   static int field916;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = -1429088321
   )
   static int field935;
   @ObfuscatedName("od")
   @ObfuscatedSignature(
      signature = "[Ljj;"
   )
   static SpritePixels[] field1135;
   @ObfuscatedName("on")
   static int[] field1010;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = -1705923857
   )
   static int field1067;
   @ObfuscatedName("ls")
   static int[] field1094;
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 1463757417
   )
   static int field989;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -1743423055
   )
   static int field943;
   @ObfuscatedName("pn")
   @ObfuscatedSignature(
      signature = "[Ldc;"
   )
   @Export("audioEffects")
   static SoundEffect[] audioEffects;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1807157605
   )
   static int field1015;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = 1220771367
   )
   static int field991;
   @ObfuscatedName("op")
   static int[] field1081;
   @ObfuscatedName("hk")
   static int[][] field1007;
   @ObfuscatedName("oz")
   static int[] field1148;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 1578326893
   )
   static int field1078;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 786449289
   )
   static int field993;
   @ObfuscatedName("ht")
   @ObfuscatedGetter(
      intValue = -1223536169
   )
   static int field996;
   @ObfuscatedName("oq")
   static int[] field1151;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 1757271713
   )
   static int field1072;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = -2083939143
   )
   @Export(
      value = "chatCycle",
      setter = true
   )
   static int chatCycle;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 914184987
   )
   static int field961;
   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("projectiles")
   static Deque projectiles;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -680393127
   )
   static int field998;
   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("graphicsObjectDeque")
   static Deque graphicsObjectDeque;
   @ObfuscatedName("hs")
   static int[] field999;
   @ObfuscatedName("hp")
   static int[] field1000;
   @ObfuscatedName("ha")
   static int[] field981;
   @ObfuscatedName("pq")
   static short field1157;
   @ObfuscatedName("pk")
   static short field1163;
   @ObfuscatedName("hw")
   static int[] field1051;
   @ObfuscatedName("ho")
   static int[] field1087;
   @ObfuscatedName("ph")
   static int[] field1152;
   @ObfuscatedName("py")
   static short field1162;
   @ObfuscatedName("hc")
   static int[] field1004;
   @ObfuscatedName("pw")
   static int[] field1153;
   @ObfuscatedName("qg")
   static short field965;
   @ObfuscatedName("pp")
   static int[] field1093;
   @ObfuscatedName("hy")
   static int[] field1005;
   @ObfuscatedName("pc")
   static short field979;
   @ObfuscatedName("pg")
   static short field1159;
   @ObfuscatedName("px")
   static short field1158;
   @ObfuscatedName("pl")
   static int[] field1155;
   @ObfuscatedName("pe")
   static short field913;
   @ObfuscatedName("hg")
   static String[] field1006;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -427228419
   )
   static int field1125;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 1344388827
   )
   @Export("scale")
   static int scale;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -307516803
   )
   @Export("viewportHeight")
   static int viewportHeight;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 1697520415
   )
   @Export("screenY")
   static int screenY;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 1180440807
   )
   @Export("screenX")
   static int screenX;
   @ObfuscatedName("iv")
   @Export("playerOptions")
   @Hook("playerMenuOptionsChanged")
   static String[] playerOptions;
   @ObfuscatedName("ih")
   @Export("playerOptionsPriorities")
   static boolean[] playerOptionsPriorities;
   @ObfuscatedName("nx")
   static int[] field1120;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -481660425
   )
   @Export("viewportWidth")
   static int viewportWidth;
   @ObfuscatedName("mj")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   static Deque field1104;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 200421447
   )
   static int field1164;
   @ObfuscatedName("nk")
   static int[] field1126;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -305344925
   )
   static int field1020;
   @ObfuscatedName("jf")
   static boolean field1097;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -1174280451
   )
   static int field1165;
   @ObfuscatedName("mw")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   static Deque field1105;
   @ObfuscatedName("nf")
   static String field1122;
   @ObfuscatedName("ij")
   @Export("playerMenuTypes")
   static final int[] playerMenuTypes;
   @ObfuscatedName("ka")
   static boolean field1174;
   @ObfuscatedName("jq")
   static boolean field1052;
   @ObfuscatedName("kj")
   @ObfuscatedGetter(
      intValue = -1949344889
   )
   static int field1061;
   @ObfuscatedName("nr")
   static int[] field942;

   static {
      field1060 = true;
      world = 1;
      flags = 0;
      socketType = 0;
      isMembers = false;
      lowMemory = false;
      languageId = 0;
      gameState = 0;
      field922 = true;
      gameCycle = 0;
      field924 = -1L;
      field926 = -1;
      field927 = -1;
      field969 = -1;
      field929 = true;
      displayFps = false;
      field1070 = 0;
      field992 = 0;
      field933 = 0;
      field1150 = 0;
      hintArrowX = 0;
      hintArrowY = 0;
      hintArrowType = 0;
      field938 = 0;
      field1117 = 0;
      field940 = class91.field1393;
      field1161 = class91.field1393;
      loadingStage = 0;
      js5State = 0;
      field932 = 0;
      field976 = 0;
      loginState = 0;
      field946 = 0;
      field949 = 0;
      field950 = 0;
      field951 = null;
      cachedNPCs = new NPC['耀'];
      field953 = 0;
      npcIndices = new int['耀'];
      pendingNpcFlagsCount = 0;
      pendingNpcFlagsIndices = new int[250];
      secretPacketBuffer1 = new PacketBuffer(5000);
      field1132 = new PacketBuffer(5000);
      secretPacketBuffer2 = new PacketBuffer(15000);
      packetLength = 0;
      packetType = 0;
      field962 = 0;
      audioEffectCount = 0;
      lastFrameId = 0;
      secondLastFrameId = 0;
      thridLastFrameId = 0;
      field967 = 0;
      socketError = false;
      field1002 = new HashMap();
      field970 = 0;
      field971 = 1;
      field972 = 0;
      field1024 = 1;
      field974 = 0;
      collisionMaps = new CollisionData[4];
      isDynamicRegion = false;
      field1133 = new int[4][13][13];
      field978 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      field1066 = 0;
      field980 = 2301979;
      field1032 = 5063219;
      field982 = 3353893;
      field1127 = 7759444;
      field1076 = false;
      field985 = 0;
      field987 = 128;
      mapAngle = 0;
      field989 = 0;
      field1015 = 0;
      field991 = 0;
      field1078 = 0;
      field993 = 50;
      field994 = 0;
      field1146 = false;
      field996 = 0;
      field961 = 0;
      field998 = 50;
      field999 = new int[field998];
      field1000 = new int[field998];
      field981 = new int[field998];
      field1051 = new int[field998];
      field1087 = new int[field998];
      field1004 = new int[field998];
      field1005 = new int[field998];
      field1006 = new String[field998];
      field1007 = new int[104][104];
      field1021 = 0;
      screenY = -1;
      screenX = -1;
      field1011 = 0;
      field1012 = 0;
      field1013 = 0;
      cursorState = 0;
      field1075 = 0;
      field1182 = 0;
      field988 = 0;
      field1143 = 0;
      field1019 = 0;
      field1020 = 0;
      field1101 = false;
      field1022 = 0;
      field1023 = 0;
      cachedPlayers = new Player[2048];
      localInteractingIndex = -1;
      field1026 = 0;
      field1027 = 0;
      field1028 = new int[1000];
      playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
      playerOptions = new String[8];
      playerOptionsPriorities = new boolean[8];
      field983 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
      field1033 = -1;
      groundItemDeque = new Deque[4][104][104];
      pendingSpawns = new Deque();
      projectiles = new Deque();
      graphicsObjectDeque = new Deque();
      boostedSkillLevels = new int[25];
      realSkillLevels = new int[25];
      skillExperiences = new int[25];
      field1041 = 0;
      isMenuOpen = false;
      menuOptionCount = 0;
      menuActionParams0 = new int[500];
      menuActionParams1 = new int[500];
      menuTypes = new int[500];
      menuIdentifiers = new int[500];
      menuOptions = new String[500];
      menuTargets = new String[500];
      field984 = new boolean[500];
      field1097 = false;
      field1052 = false;
      field1053 = -1;
      field1054 = -1;
      field917 = 0;
      field1121 = 50;
      itemSelectionState = 0;
      field1058 = null;
      spellSelected = false;
      field1055 = -1;
      field1061 = -1;
      field1062 = null;
      field1063 = null;
      widgetRoot = -1;
      componentTable = new XHashTable(8);
      field916 = 0;
      field1067 = 0;
      field1068 = null;
      energy = 0;
      weight = 0;
      rights = 0;
      field1072 = -1;
      field1073 = false;
      field1074 = false;
      field1174 = false;
      field977 = null;
      field1077 = null;
      field1147 = null;
      field1079 = 0;
      field1160 = 0;
      field923 = null;
      field1082 = false;
      field1083 = -1;
      field1084 = -1;
      field1085 = false;
      field1086 = -1;
      field931 = -1;
      field1088 = false;
      cycleCntr = 1;
      field1090 = new int[32];
      field1091 = 0;
      interfaceItemTriggers = new int[32];
      field1145 = 0;
      field1094 = new int[32];
      field943 = 0;
      chatCycle = 0;
      field1142 = 0;
      field937 = 0;
      field1099 = 0;
      field1100 = 0;
      field1098 = 0;
      field1102 = 0;
      field1103 = new Deque();
      field1104 = new Deque();
      field1105 = new Deque();
      widgetFlags = new XHashTable(512);
      field1107 = 0;
      field1108 = -2;
      field1109 = new boolean[100];
      field1064 = new boolean[100];
      field1111 = new boolean[100];
      widgetPositionX = new int[100];
      widgetPositionY = new int[100];
      widgetBoundsWidth = new int[100];
      widgetBoundsHeight = new int[100];
      gameDrawingMode = 0;
      field1050 = 0L;
      isResized = true;
      field942 = new int[]{16776960, 16711680, '\uff00', '\uffff', 16711935, 16777215};
      field1017 = 0;
      field1003 = 0;
      field1122 = "";
      field1123 = new long[100];
      field1114 = 0;
      field1125 = 0;
      field1126 = new int[128];
      field1120 = new int[128];
      field1128 = -1L;
      clanChatOwner = null;
      clanChatName = null;
      field1131 = -1;
      field1056 = 0;
      field1039 = new int[1000];
      field1134 = new int[1000];
      field1135 = new SpritePixels[1000];
      destinationX = 0;
      destinationY = 0;
      field1138 = 0;
      field1139 = 255;
      field1140 = -1;
      field1141 = false;
      field1136 = 127;
      field1035 = 127;
      field935 = 0;
      field1081 = new int[50];
      field1151 = new int[50];
      field1010 = new int[50];
      field1148 = new int[50];
      audioEffects = new SoundEffect[50];
      field1008 = false;
      field959 = new boolean[5];
      field1152 = new int[5];
      field1153 = new int[5];
      field1093 = new int[5];
      field1155 = new int[5];
      field1163 = 256;
      field1157 = 205;
      field1158 = 256;
      field1159 = 320;
      field913 = 1;
      field979 = 32767;
      field1162 = 1;
      field965 = 32767;
      field1164 = 0;
      field1165 = 0;
      viewportHeight = 0;
      viewportWidth = 0;
      scale = 0;
      friendCount = 0;
      field1170 = 0;
      friends = new Friend[400];
      field1172 = new class195();
      ignoreCount = 0;
      ignores = new Ignore[400];
      field1080 = new PlayerComposition();
      field1156 = -1;
      field1177 = -1;
      grandExchangeOffers = new XGrandExchangeOffer[8];
      field1179 = new class73();
      field1180 = new int[50];
      field1181 = new int[50];
   }

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "552715575"
   )
   @Export("processJS5Connection")
   void processJS5Connection() {
      if(gameState != 1000) {
         long var2 = class157.currentTimeMs();
         int var4 = (int)(var2 - class238.field3223);
         class238.field3223 = var2;
         if(var4 > 200) {
            var4 = 200;
         }

         class238.field3229 += var4;
         boolean var1;
         if(class238.field3228 == 0 && class238.field3238 == 0 && class238.field3221 == 0 && class238.field3225 == 0) {
            var1 = true;
         } else if(class238.field3226 == null) {
            var1 = false;
         } else {
            try {
               label243: {
                  if(class238.field3229 > 30000) {
                     throw new IOException();
                  }

                  FileRequest var5;
                  Buffer var6;
                  while(class238.field3238 < 20 && class238.field3225 > 0) {
                     var5 = (FileRequest)class238.field3224.method3492();
                     var6 = new Buffer(4);
                     var6.putByte(1);
                     var6.put24bitInt((int)var5.hash);
                     class238.field3226.queueForWrite(var6.payload, 0, 4);
                     class238.field3233.put(var5, var5.hash);
                     --class238.field3225;
                     ++class238.field3238;
                  }

                  while(class238.field3228 < 20 && class238.field3221 > 0) {
                     var5 = (FileRequest)class238.field3232.peek();
                     var6 = new Buffer(4);
                     var6.putByte(0);
                     var6.put24bitInt((int)var5.hash);
                     class238.field3226.queueForWrite(var6.payload, 0, 4);
                     var5.unlinkDual();
                     class238.field3231.put(var5, var5.hash);
                     --class238.field3221;
                     ++class238.field3228;
                  }

                  for(int var18 = 0; var18 < 100; ++var18) {
                     int var19 = class238.field3226.available();
                     if(var19 < 0) {
                        throw new IOException();
                     }

                     if(var19 == 0) {
                        break;
                     }

                     class238.field3229 = 0;
                     byte var7 = 0;
                     if(class238.currentRequest == null) {
                        var7 = 8;
                     } else if(class238.field3235 == 0) {
                        var7 = 1;
                     }

                     int var8;
                     int var9;
                     int var10;
                     int var12;
                     if(var7 > 0) {
                        var8 = var7 - class238.field3234.offset;
                        if(var8 > var19) {
                           var8 = var19;
                        }

                        class238.field3226.read(class238.field3234.payload, class238.field3234.offset, var8);
                        if(class238.field3239 != 0) {
                           for(var9 = 0; var9 < var8; ++var9) {
                              class238.field3234.payload[var9 + class238.field3234.offset] ^= class238.field3239;
                           }
                        }

                        class238.field3234.offset += var8;
                        if(class238.field3234.offset < var7) {
                           break;
                        }

                        if(class238.currentRequest == null) {
                           class238.field3234.offset = 0;
                           var9 = class238.field3234.readUnsignedByte();
                           var10 = class238.field3234.readUnsignedShort();
                           int var11 = class238.field3234.readUnsignedByte();
                           var12 = class238.field3234.readInt();
                           long var13 = (long)(var10 + (var9 << 16));
                           FileRequest var15 = (FileRequest)class238.field3233.get(var13);
                           class208.field2558 = true;
                           if(var15 == null) {
                              var15 = (FileRequest)class238.field3231.get(var13);
                              class208.field2558 = false;
                           }

                           if(var15 == null) {
                              throw new IOException();
                           }

                           int var16 = var11 == 0?5:9;
                           class238.currentRequest = var15;
                           GameObject.field2154 = new Buffer(var12 + var16 + class238.currentRequest.padding);
                           GameObject.field2154.putByte(var11);
                           GameObject.field2154.putInt(var12);
                           class238.field3235 = 8;
                           class238.field3234.offset = 0;
                        } else if(class238.field3235 == 0) {
                           if(class238.field3234.payload[0] == -1) {
                              class238.field3235 = 1;
                              class238.field3234.offset = 0;
                           } else {
                              class238.currentRequest = null;
                           }
                        }
                     } else {
                        var8 = GameObject.field2154.payload.length - class238.currentRequest.padding;
                        var9 = 512 - class238.field3235;
                        if(var9 > var8 - GameObject.field2154.offset) {
                           var9 = var8 - GameObject.field2154.offset;
                        }

                        if(var9 > var19) {
                           var9 = var19;
                        }

                        class238.field3226.read(GameObject.field2154.payload, GameObject.field2154.offset, var9);
                        if(class238.field3239 != 0) {
                           for(var10 = 0; var10 < var9; ++var10) {
                              GameObject.field2154.payload[var10 + GameObject.field2154.offset] ^= class238.field3239;
                           }
                        }

                        GameObject.field2154.offset += var9;
                        class238.field3235 += var9;
                        if(var8 == GameObject.field2154.offset) {
                           if(16711935L == class238.currentRequest.hash) {
                              class48.field620 = GameObject.field2154;

                              for(var10 = 0; var10 < 256; ++var10) {
                                 IndexData var20 = class238.field3242[var10];
                                 if(var20 != null) {
                                    class48.field620.offset = var10 * 8 + 5;
                                    var12 = class48.field620.readInt();
                                    int var21 = class48.field620.readInt();
                                    var20.setInformation(var12, var21);
                                 }
                              }
                           } else {
                              class238.field3222.reset();
                              class238.field3222.update(GameObject.field2154.payload, 0, var8);
                              var10 = (int)class238.field3222.getValue();
                              if(var10 != class238.currentRequest.crc) {
                                 try {
                                    class238.field3226.close();
                                 } catch (Exception var23) {
                                    ;
                                 }

                                 ++class238.field3240;
                                 class238.field3226 = null;
                                 class238.field3239 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                                 var1 = false;
                                 break label243;
                              }

                              class238.field3240 = 0;
                              class238.field3241 = 0;
                              class238.currentRequest.index.method4123((int)(class238.currentRequest.hash & 65535L), GameObject.field2154.payload, (class238.currentRequest.hash & 16711680L) == 16711680L, class208.field2558);
                           }

                           class238.currentRequest.unlink();
                           if(class208.field2558) {
                              --class238.field3238;
                           } else {
                              --class238.field3228;
                           }

                           class238.field3235 = 0;
                           class238.currentRequest = null;
                           GameObject.field2154 = null;
                        } else {
                           if(class238.field3235 != 512) {
                              break;
                           }

                           class238.field3235 = 0;
                        }
                     }
                  }

                  var1 = true;
               }
            } catch (IOException var24) {
               try {
                  class238.field3226.close();
               } catch (Exception var22) {
                  ;
               }

               ++class238.field3241;
               class238.field3226 = null;
               var1 = false;
            }
         }

         if(!var1) {
            this.method1318();
         }

      }
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2092146463"
   )
   void method1108() {
      int var1 = class45.canvasWidth;
      int var2 = class10.canvasHeight;
      if(super.field709 < var1) {
         var1 = super.field709;
      }

      if(super.field708 < var2) {
         var2 = super.field708;
      }

      if(class34.preferences != null) {
         try {
            Client var3 = CombatInfoListHolder.clientInstance;
            Object[] var4 = new Object[]{Integer.valueOf(class36.method487())};
            JSObject.getWindow(var3).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1989896526"
   )
   protected final void vmethod1254() {
      if(Varcs.chatMessages.changed()) {
         Varcs.chatMessages.serialize();
      }

      if(field1038 != null) {
         field1038.field854 = false;
      }

      field1038 = null;
      if(class13.rssocket != null) {
         class13.rssocket.close();
         class13.rssocket = null;
      }

      class51.method743();
      if(MouseInput.mouse != null) {
         MouseInput var1 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

      WorldMapData.field438 = null;
      if(VertexNormal.soundSystem0 != null) {
         VertexNormal.soundSystem0.method1944();
      }

      if(MessageNode.soundSystem1 != null) {
         MessageNode.soundSystem1.method1944();
      }

      Script.method1786();
      MessageNode.method1062();

      try {
         class155.field2211.method2282();

         for(int var3 = 0; var3 < class7.field223; ++var3) {
            Signlink.field2199[var3].method2282();
         }

         class155.field2203.method2282();
         class155.field2207.method2282();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   protected final void vmethod1149() {
      WidgetNode.field827 = socketType == 0?'ꩊ':world + '鱀';
      class33.field456 = socketType == 0?443:world + '썐';
      class18.myWorldPort = WidgetNode.field827;
      PlayerComposition.colorsToFind = class214.field2597;
      PlayerComposition.colorsToReplace = class214.field2595;
      class244.field3296 = class214.field2596;
      PlayerComposition.field2591 = class214.field2599;
      this.method811();
      this.method812();
      WorldMapData.field438 = this.method808();
      GraphicsObject.field1347 = new IndexFile(255, class155.field2211, class155.field2203, 500000);
      class34.preferences = MouseInput.method971();
      this.method809();
      class35.method484(this, class182.field2412);
      if(socketType != 0) {
         displayFps = true;
      }

      int var1 = class34.preferences.screenType;
      field1050 = 0L;
      if(var1 >= 2) {
         isResized = true;
      } else {
         isResized = false;
      }

      int var2 = isResized?2:1;
      if(var2 == 1) {
         CombatInfoListHolder.clientInstance.method916(765, 503);
      } else {
         CombatInfoListHolder.clientInstance.method916(7680, 2160);
      }

      if(gameState >= 25) {
         XItemContainer.method1031();
      }

   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1517634055"
   )
   final void method1161(boolean var1) {
      int var2 = widgetRoot;
      int var3 = class45.canvasWidth;
      int var4 = class10.canvasHeight;
      if(class9.loadWidget(var2)) {
         class41.method555(Widget.widgets[var2], -1, var3, var4, var1);
      }

   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-99"
   )
   @Export("error")
   void error(int var1) {
      class18.socket = null;
      class21.rssocket = null;
      js5State = 0;
      if(WidgetNode.field827 == class18.myWorldPort) {
         class18.myWorldPort = class33.field456;
      } else {
         class18.myWorldPort = WidgetNode.field827;
      }

      ++field976;
      if(field976 >= 2 && (var1 == 7 || var1 == 9)) {
         if(gameState <= 5) {
            this.error("js5connect_full");
            gameState = 1000;
         } else {
            field932 = 3000;
         }
      } else if(field976 >= 2 && var1 == 6) {
         this.error("js5connect_outofdate");
         gameState = 1000;
      } else if(field976 >= 4) {
         if(gameState <= 5) {
            this.error("js5connect");
            gameState = 1000;
         } else {
            field932 = 3000;
         }
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "3"
   )
   final boolean method1372() {
      int var1 = class37.method492();
      return menuOptionCount > 2 && (field1041 == 1 && !field984[var1] || Friend.method1040(var1));
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-10"
   )
   protected final void vmethod1096() {
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "630433161"
   )
   @Export("processServerPacket")
   final boolean processServerPacket() {
      if(class13.rssocket == null) {
         return false;
      } else {
         int var3;
         String var19;
         try {
            int var1 = class13.rssocket.available();
            if(var1 == 0) {
               return false;
            }

            if(packetType == -1) {
               class13.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               packetLength = class272.field3690[packetType];
               --var1;
            }

            if(packetLength == -1) {
               if(var1 <= 0) {
                  return false;
               }

               class13.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               packetLength = secretPacketBuffer2.payload[0] & 255;
               --var1;
            }

            if(packetLength == -2) {
               if(var1 <= 1) {
                  return false;
               }

               class13.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();
               var1 -= 2;
            }

            if(var1 < packetLength) {
               return false;
            }

            secretPacketBuffer2.offset = 0;
            class13.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
            field962 = 0;
            thridLastFrameId = secondLastFrameId;
            secondLastFrameId = lastFrameId;
            lastFrameId = packetType;
            int var2;
            if(packetType == 22) {
               field1008 = false;

               for(var2 = 0; var2 < 5; ++var2) {
                  field959[var2] = false;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 72) {
               field1170 = 1;
               field1142 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == 211) {
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

            if(packetType == 20) {
               for(var2 = 0; var2 < class215.field2605; ++var2) {
                  VarPlayerType var77 = class92.method1695(var2);
                  if(var77 != null) {
                     class211.settings[var2] = 0;
                     class211.widgetSettings[var2] = 0;
                  }
               }

               class18.method139();
               field1091 += 32;
               packetType = -1;
               return true;
            }

            if(packetType == 84) {
               for(var2 = 0; var2 < class211.widgetSettings.length; ++var2) {
                  if(class211.settings[var2] != class211.widgetSettings[var2]) {
                     class211.widgetSettings[var2] = class211.settings[var2];
                     class164.method3010(var2);
                     field1090[++field1091 - 1 & 31] = var2;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 192) {
               field1138 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == 113) {
               field1070 = secretPacketBuffer2.readUnsignedShortOb1() * 30;
               field1098 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == 67) {
               class51.field654 = CombatInfo1.method1505(secretPacketBuffer2.readUnsignedByte());
               packetType = -1;
               return true;
            }

            if(packetType == 170) {
               var2 = secretPacketBuffer2.method3285();
               WorldMapType3.field373 = GameEngine.taskManager.createHost(var2);
               packetType = -1;
               return true;
            }

            if(packetType == 101) {
               var2 = secretPacketBuffer2.method3132();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               WorldMapType3.method207(var2);
               packetType = -1;
               return true;
            }

            if(packetType == 248) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               XItemContainer var75 = (XItemContainer)XItemContainer.itemContainers.get((long)var2);
               if(var75 != null) {
                  var75.unlink();
               }

               interfaceItemTriggers[++field1145 - 1 & 31] = var2 & 32767;
               packetType = -1;
               return true;
            }

            if(packetType == 123) {
               secretPacketBuffer2.offset += 28;
               if(secretPacketBuffer2.checkCrc()) {
                  PacketBuffer var79 = secretPacketBuffer2;
                  var3 = secretPacketBuffer2.offset - 28;
                  byte[] var69 = var79.payload;
                  if(field951 == null) {
                     field951 = new byte[24];
                  }

                  class183.method3393(var69, var3, field951, 0, 24);
                  class19.method140(var79, var3);
               }

               packetType = -1;
               return true;
            }

            int var20;
            Widget var74;
            if(packetType == 168) {
               var2 = secretPacketBuffer2.method3285();
               var74 = class239.method4167(var2);

               for(var20 = 0; var20 < var74.itemIds.length; ++var20) {
                  var74.itemIds[var20] = -1;
                  var74.itemIds[var20] = 0;
               }

               class21.method156(var74);
               packetType = -1;
               return true;
            }

            if(packetType == 242) {
               var2 = secretPacketBuffer2.method3141();
               var74 = class239.method4167(var2);
               var74.modelType = 3;
               var74.modelId = class226.localPlayer.composition.method3891();
               class21.method156(var74);
               packetType = -1;
               return true;
            }

            if(packetType == 159) {
               class18.method139();
               weight = secretPacketBuffer2.readShort();
               field1098 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == 70) {
               class18.method139();
               energy = secretPacketBuffer2.readUnsignedByte();
               field1098 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == 243) {
               field1017 = secretPacketBuffer2.readUnsignedByte();
               field1003 = secretPacketBuffer2.readUnsignedByte();
               packetType = -1;
               return true;
            }

            if(packetType == 201) {
               World.field1293 = secretPacketBuffer2.method3124();
               Signlink.field2193 = secretPacketBuffer2.method3122();
               packetType = -1;
               return true;
            }

            if(packetType == 2) {
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

            if(packetType == 18) {
               var2 = secretPacketBuffer2.readUnsignedShortOb1();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               var3 = secretPacketBuffer2.method3136();
               class1.method3(var2, var3);
               packetType = -1;
               return true;
            }

            boolean var51;
            if(packetType == 117) {
               var51 = secretPacketBuffer2.readUnsignedByte() == 1;
               if(var51) {
                  class14.field280 = class157.currentTimeMs() - secretPacketBuffer2.readLong();
                  InvType.field3251 = new class13(secretPacketBuffer2, true);
               } else {
                  InvType.field3251 = null;
               }

               field1100 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == 26) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               if(secretPacketBuffer2.readUnsignedByte() == 0) {
                  grandExchangeOffers[var2] = new XGrandExchangeOffer();
                  secretPacketBuffer2.offset += 18;
               } else {
                  --secretPacketBuffer2.offset;
                  grandExchangeOffers[var2] = new XGrandExchangeOffer(secretPacketBuffer2, false);
               }

               field1099 = cycleCntr;
               packetType = -1;
               return true;
            }

            String var72;
            String var78;
            if(packetType == 73) {
               var19 = secretPacketBuffer2.readString();
               PacketBuffer var68 = secretPacketBuffer2;
               var72 = class28.method239(var68, 32767);
               var78 = FontTypeFace.appendTags(class210.method3856(var72));
               Item.sendGameMessage(6, var19, var78);
               packetType = -1;
               return true;
            }

            Widget var54;
            if(packetType == 12) {
               var51 = secretPacketBuffer2.method3280() == 1;
               var3 = secretPacketBuffer2.method3142();
               var54 = class239.method4167(var3);
               if(var51 != var54.isHidden) {
                  var54.isHidden = var51;
                  class21.method156(var54);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 9) {
               var2 = secretPacketBuffer2.method3141();
               var72 = secretPacketBuffer2.readString();
               var54 = class239.method4167(var2);
               if(!var72.equals(var54.text)) {
                  var54.text = var72;
                  class21.method156(var54);
               }

               packetType = -1;
               return true;
            }

            int var5;
            int var26;
            int var29;
            if(packetType == 178) {
               var2 = secretPacketBuffer2.readUnsignedShortOb1();
               var3 = secretPacketBuffer2.method3141();
               var20 = var2 >> 10 & 31;
               var5 = var2 >> 5 & 31;
               var26 = var2 & 31;
               var29 = (var5 << 11) + (var20 << 19) + (var26 << 3);
               Widget var66 = class239.method4167(var3);
               if(var29 != var66.textColor) {
                  var66.textColor = var29;
                  class21.method156(var66);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 219) {
               var2 = secretPacketBuffer2.method3084();
               var3 = secretPacketBuffer2.method3141();
               var54 = class239.method4167(var3);
               if(var2 != var54.field2664 || var2 == -1) {
                  var54.field2664 = var2;
                  var54.field2739 = 0;
                  var54.field2676 = 0;
                  class21.method156(var54);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 199) {
               var2 = secretPacketBuffer2.readByteOb1();
               var3 = secretPacketBuffer2.method3142();
               var54 = class239.method4167(var3);
               if(var54.modelType != 1 || var2 != var54.modelId) {
                  var54.modelType = 1;
                  var54.modelId = var2;
                  class21.method156(var54);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 139) {
               var2 = secretPacketBuffer2.method3141();
               var3 = secretPacketBuffer2.method3132();
               var54 = class239.method4167(var2);
               if(var54.modelType != 2 || var3 != var54.modelId) {
                  var54.modelType = 2;
                  var54.modelId = var3;
                  class21.method156(var54);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 90) {
               var2 = secretPacketBuffer2.method3285();
               var3 = secretPacketBuffer2.method3132();
               var54 = class239.method4167(var2);
               if(var54 != null && var54.type == 0) {
                  if(var3 > var54.scrollHeight - var54.height) {
                     var3 = var54.scrollHeight - var54.height;
                  }

                  if(var3 < 0) {
                     var3 = 0;
                  }

                  if(var3 != var54.scrollY) {
                     var54.scrollY = var3;
                     class21.method156(var54);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 104) {
               Signlink.field2193 = secretPacketBuffer2.method3122();
               World.field1293 = secretPacketBuffer2.readUnsignedByte();

               for(var2 = World.field1293; var2 < World.field1293 + 8; ++var2) {
                  for(var3 = Signlink.field2193; var3 < Signlink.field2193 + 8; ++var3) {
                     if(groundItemDeque[class10.plane][var2][var3] != null) {
                        groundItemDeque[class10.plane][var2][var3] = null;
                        ChatLineBuffer.groundItemSpawned(var2, var3);
                     }
                  }
               }

               for(PendingSpawn var76 = (PendingSpawn)pendingSpawns.getFront(); var76 != null; var76 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var76.x >= World.field1293 && var76.x < World.field1293 + 8 && var76.y >= Signlink.field2193 && var76.y < Signlink.field2193 + 8 && var76.level == class10.plane) {
                     var76.hitpoints = 0;
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 21) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               byte var70 = secretPacketBuffer2.readByte();
               class211.settings[var2] = var70;
               if(class211.widgetSettings[var2] != var70) {
                  class211.widgetSettings[var2] = var70;
               }

               class164.method3010(var2);
               field1090[++field1091 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            if(packetType == 209) {
               var2 = secretPacketBuffer2.readByteOb1();
               var3 = secretPacketBuffer2.method3285();
               class211.settings[var2] = var3;
               if(class211.widgetSettings[var2] != var3) {
                  class211.widgetSettings[var2] = var3;
               }

               class164.method3010(var2);
               field1090[++field1091 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            String var53;
            if(packetType == 125) {
               var2 = secretPacketBuffer2.method3124();
               var3 = secretPacketBuffer2.method3280();
               var53 = secretPacketBuffer2.readString();
               if(var3 >= 1 && var3 <= 8) {
                  if(var53.equalsIgnoreCase("null")) {
                     var53 = null;
                  }

                  playerOptions[var3 - 1] = var53;
                  playerOptionsPriorities[var3 - 1] = var2 == 0;
               }

               packetType = -1;
               return true;
            }

            if(packetType == 107) {
               var2 = secretPacketBuffer2.readUnsignedShort();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var20 = secretPacketBuffer2.readUnsignedShort();
               WallObject.method2805(var2, var3, var20);
               packetType = -1;
               return true;
            }

            Widget var83;
            if(packetType == 158) {
               var2 = secretPacketBuffer2.method3142();
               var3 = secretPacketBuffer2.readUnsignedShort();
               var20 = secretPacketBuffer2.method3132();
               var83 = class239.method4167(var2);
               var83.field2673 = var3 + (var20 << 16);
               packetType = -1;
               return true;
            }

            if(packetType == 241) {
               class18.method139();
               var2 = secretPacketBuffer2.readUnsignedByte();
               var3 = secretPacketBuffer2.method3142();
               var20 = secretPacketBuffer2.method3124();
               skillExperiences[var2] = var3;
               boostedSkillLevels[var2] = var20;
               realSkillLevels[var2] = 1;

               for(var5 = 0; var5 < 98; ++var5) {
                  if(var3 >= class222.field2817[var5]) {
                     realSkillLevels[var2] = var5 + 2;
                  }
               }

               field1094[++field943 - 1 & 31] = var2;
               packetType = -1;
               return true;
            }

            if(packetType == 79) {
               var2 = secretPacketBuffer2.method3142();
               var3 = secretPacketBuffer2.readShort();
               var20 = secretPacketBuffer2.method3134();
               var83 = class239.method4167(var2);
               if(var20 != var83.originalX || var3 != var83.originalY || var83.field2714 != 0 || var83.field2623 != 0) {
                  var83.originalX = var20;
                  var83.originalY = var3;
                  var83.field2714 = 0;
                  var83.field2623 = 0;
                  class21.method156(var83);
                  this.method1252(var83);
                  if(var83.type == 0) {
                     WorldListFetcher.method1465(Widget.widgets[var2 >> 16], var83, false);
                  }
               }

               packetType = -1;
               return true;
            }

            if(packetType == 138) {
               var2 = secretPacketBuffer2.method3142();
               var3 = secretPacketBuffer2.readUnsignedShortOb1();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var20 = secretPacketBuffer2.method3141();
               var83 = class239.method4167(var2);
               ItemComposition var62;
               if(!var83.hasScript) {
                  if(var3 == -1) {
                     var83.modelType = 0;
                     packetType = -1;
                     return true;
                  }

                  var62 = class10.getItemDefinition(var3);
                  var83.modelType = 4;
                  var83.modelId = var3;
                  var83.rotationX = var62.xan2d;
                  var83.rotationZ = var62.yan2d;
                  var83.modelZoom = var62.zoom2d * 100 / var20;
                  class21.method156(var83);
               } else {
                  var83.itemId = var3;
                  var83.itemQuantity = var20;
                  var62 = class10.getItemDefinition(var3);
                  var83.rotationX = var62.xan2d;
                  var83.rotationZ = var62.yan2d;
                  var83.rotationY = var62.zan2d;
                  var83.field2661 = var62.offsetX2d;
                  var83.field2667 = var62.offsetY2d;
                  var83.modelZoom = var62.zoom2d;
                  if(var62.isStackable == 1) {
                     var83.field2675 = 1;
                  } else {
                     var83.field2675 = 2;
                  }

                  if(var83.field2744 > 0) {
                     var83.modelZoom = var83.modelZoom * 32 / var83.field2744;
                  } else if(var83.originalWidth > 0) {
                     var83.modelZoom = var83.modelZoom * 32 / var83.originalWidth;
                  }

                  class21.method156(var83);
               }

               packetType = -1;
               return true;
            }

            if(packetType == 58) {
               var2 = secretPacketBuffer2.readUnsignedByte();
               var3 = secretPacketBuffer2.readUnsignedByte();
               var20 = secretPacketBuffer2.readUnsignedByte();
               var5 = secretPacketBuffer2.readUnsignedByte();
               field959[var2] = true;
               field1152[var2] = var3;
               field1153[var2] = var20;
               field1093[var2] = var5;
               field1155[var2] = 0;
               packetType = -1;
               return true;
            }

            boolean var64;
            if(packetType == 198) {
               while(secretPacketBuffer2.offset < packetLength) {
                  var2 = secretPacketBuffer2.readUnsignedByte();
                  var64 = (var2 & 1) == 1;
                  var53 = secretPacketBuffer2.readString();
                  var78 = secretPacketBuffer2.readString();
                  secretPacketBuffer2.readString();

                  for(var26 = 0; var26 < ignoreCount; ++var26) {
                     Ignore var90 = ignores[var26];
                     if(var64) {
                        if(var78.equals(var90.name)) {
                           var90.name = var53;
                           var90.previousName = var78;
                           var53 = null;
                           break;
                        }
                     } else if(var53.equals(var90.name)) {
                        var90.name = var53;
                        var90.previousName = var78;
                        var53 = null;
                        break;
                     }
                  }

                  if(var53 != null && ignoreCount < 400) {
                     Ignore var61 = new Ignore();
                     ignores[ignoreCount] = var61;
                     var61.name = var53;
                     var61.previousName = var78;
                     ++ignoreCount;
                  }
               }

               field1142 = cycleCntr;
               packetType = -1;
               return true;
            }

            int var30;
            boolean var55;
            boolean var85;
            if(packetType == 225) {
               var19 = secretPacketBuffer2.readString();
               var3 = secretPacketBuffer2.readUnsignedShort();
               byte var82 = secretPacketBuffer2.readByte();
               var55 = false;
               if(var82 == -128) {
                  var55 = true;
               }

               if(var55) {
                  if(VarPlayerType.clanChatCount == 0) {
                     packetType = -1;
                     return true;
                  }

                  var85 = false;

                  for(var26 = 0; var26 < VarPlayerType.clanChatCount && (!KeyFocusListener.clanMembers[var26].username.equals(var19) || var3 != KeyFocusListener.clanMembers[var26].world); ++var26) {
                     ;
                  }

                  if(var26 < VarPlayerType.clanChatCount) {
                     while(var26 < VarPlayerType.clanChatCount - 1) {
                        KeyFocusListener.clanMembers[var26] = KeyFocusListener.clanMembers[var26 + 1];
                        ++var26;
                     }

                     --VarPlayerType.clanChatCount;
                     KeyFocusListener.clanMembers[VarPlayerType.clanChatCount] = null;
                  }
               } else {
                  secretPacketBuffer2.readString();
                  XClanMember var60 = new XClanMember();
                  var60.username = var19;
                  var60.field906 = class215.method3908(var60.username, class22.field331);
                  var60.world = var3;
                  var60.rank = var82;

                  for(var29 = VarPlayerType.clanChatCount - 1; var29 >= 0; --var29) {
                     var30 = KeyFocusListener.clanMembers[var29].field906.compareTo(var60.field906);
                     if(var30 == 0) {
                        KeyFocusListener.clanMembers[var29].world = var3;
                        KeyFocusListener.clanMembers[var29].rank = var82;
                        if(var19.equals(class226.localPlayer.name)) {
                           CombatInfo1.clanChatRank = var82;
                        }

                        field937 = cycleCntr;
                        packetType = -1;
                        return true;
                     }

                     if(var30 < 0) {
                        break;
                     }
                  }

                  if(VarPlayerType.clanChatCount >= KeyFocusListener.clanMembers.length) {
                     packetType = -1;
                     return true;
                  }

                  for(var30 = VarPlayerType.clanChatCount - 1; var30 > var29; --var30) {
                     KeyFocusListener.clanMembers[var30 + 1] = KeyFocusListener.clanMembers[var30];
                  }

                  if(VarPlayerType.clanChatCount == 0) {
                     KeyFocusListener.clanMembers = new XClanMember[100];
                  }

                  KeyFocusListener.clanMembers[var29 + 1] = var60;
                  ++VarPlayerType.clanChatCount;
                  if(var19.equals(class226.localPlayer.name)) {
                     CombatInfo1.clanChatRank = var82;
                  }
               }

               field937 = cycleCntr;
               packetType = -1;
               return true;
            }

            if(packetType == 203) {
               class44.method604();

               for(var2 = 0; var2 < 2048; ++var2) {
                  cachedPlayers[var2] = null;
               }

               BufferProvider.initializeGPI(secretPacketBuffer2);
               packetType = -1;
               return true;
            }

            if(packetType != 239 && packetType != 23 && packetType != 217 && packetType != 234 && packetType != 183 && packetType != 240 && packetType != 153 && packetType != 76 && packetType != 45) {
               long var7;
               if(packetType == 54) {
                  var2 = secretPacketBuffer2.method3141();
                  var3 = secretPacketBuffer2.readUnsignedShortOb1();
                  if(var3 == '\uffff') {
                     var3 = -1;
                  }

                  var20 = secretPacketBuffer2.readUnsignedShort();
                  if(var20 == '\uffff') {
                     var20 = -1;
                  }

                  var5 = secretPacketBuffer2.method3141();

                  for(var26 = var3; var26 <= var20; ++var26) {
                     var7 = (long)var26 + ((long)var2 << 32);
                     Node var63 = widgetFlags.get(var7);
                     if(var63 != null) {
                        var63.unlink();
                     }

                     widgetFlags.put(new IntegerNode(var5), var7);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 49) {
                  var2 = secretPacketBuffer2.getUSmart();
                  var64 = secretPacketBuffer2.readUnsignedByte() == 1;
                  var53 = "";
                  var55 = false;
                  if(var64) {
                     var53 = secretPacketBuffer2.readString();
                     if(KeyFocusListener.isIgnored(var53)) {
                        var55 = true;
                     }
                  }

                  String var59 = secretPacketBuffer2.readString();
                  if(!var55) {
                     Item.sendGameMessage(var2, var53, var59);
                  }

                  packetType = -1;
                  return true;
               }

               Widget var6;
               if(packetType == 195) {
                  var2 = secretPacketBuffer2.readByteOb1();
                  var3 = secretPacketBuffer2.readByteOb1();
                  var20 = secretPacketBuffer2.readUnsignedShortOb1();
                  var5 = secretPacketBuffer2.method3142();
                  var6 = class239.method4167(var5);
                  if(var2 != var6.rotationX || var3 != var6.rotationZ || var20 != var6.modelZoom) {
                     var6.rotationX = var2;
                     var6.rotationZ = var3;
                     var6.modelZoom = var20;
                     class21.method156(var6);
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 187) {
                  field1008 = true;
                  Player.field902 = secretPacketBuffer2.readUnsignedByte();
                  class40.field550 = secretPacketBuffer2.readUnsignedByte();
                  WorldMapData.field448 = secretPacketBuffer2.readUnsignedShort();
                  DecorativeObject.field2136 = secretPacketBuffer2.readUnsignedByte();
                  Friend.field798 = secretPacketBuffer2.readUnsignedByte();
                  if(Friend.field798 >= 100) {
                     class73.cameraX = Player.field902 * 128 + 64;
                     cameraY = class40.field550 * 128 + 64;
                     WidgetNode.cameraZ = class23.getTileHeight(class73.cameraX, cameraY, class10.plane) - WorldMapData.field448;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 81) {
                  field1008 = true;
                  class12.field258 = secretPacketBuffer2.readUnsignedByte();
                  class96.field1481 = secretPacketBuffer2.readUnsignedByte();
                  class177.field2380 = secretPacketBuffer2.readUnsignedShort();
                  class269.field3659 = secretPacketBuffer2.readUnsignedByte();
                  class22.field333 = secretPacketBuffer2.readUnsignedByte();
                  if(class22.field333 >= 100) {
                     var2 = class12.field258 * 128 + 64;
                     var3 = class96.field1481 * 128 + 64;
                     var20 = class23.getTileHeight(var2, var3, class10.plane) - class177.field2380;
                     var5 = var2 - class73.cameraX;
                     var26 = var20 - WidgetNode.cameraZ;
                     var29 = var3 - cameraY;
                     var30 = (int)Math.sqrt((double)(var5 * var5 + var29 * var29));
                     class10.cameraPitch = (int)(Math.atan2((double)var26, (double)var30) * 325.949D) & 2047;
                     class236.cameraYaw = (int)(Math.atan2((double)var5, (double)var29) * -325.949D) & 2047;
                     if(class10.cameraPitch < 128) {
                        class10.cameraPitch = 128;
                     }

                     if(class10.cameraPitch > 383) {
                        class10.cameraPitch = 383;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               String var16;
               int var17;
               long var22;
               long var24;
               long var36;
               String var84;
               if(packetType == 172) {
                  var19 = secretPacketBuffer2.readString();
                  var22 = (long)secretPacketBuffer2.readUnsignedShort();
                  var24 = (long)secretPacketBuffer2.read24BitInt();
                  Permission var89 = (Permission)class36.forOrdinal(class252.method4350(), secretPacketBuffer2.readUnsignedByte());
                  var36 = var24 + (var22 << 32);
                  boolean var93 = false;

                  for(int var38 = 0; var38 < 100; ++var38) {
                     if(var36 == field1123[var38]) {
                        var93 = true;
                        break;
                     }
                  }

                  if(KeyFocusListener.isIgnored(var19)) {
                     var93 = true;
                  }

                  if(!var93 && field1023 == 0) {
                     field1123[field1114] = var36;
                     field1114 = (field1114 + 1) % 100;
                     PacketBuffer var39 = secretPacketBuffer2;
                     String var67 = class28.method239(var39, 32767);
                     var84 = FontTypeFace.appendTags(class210.method3856(var67));
                     byte var40;
                     if(var89.field3147) {
                        var40 = 7;
                     } else {
                        var40 = 3;
                     }

                     if(var89.field3146 != -1) {
                        var17 = var89.field3146;
                        var16 = "<img=" + var17 + ">";
                        Item.sendGameMessage(var40, var16 + var19, var84);
                     } else {
                        Item.sendGameMessage(var40, var19, var84);
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 64) {
                  field992 = secretPacketBuffer2.readUnsignedByte();
                  if(field992 == 1) {
                     field933 = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(field992 >= 2 && field992 <= 6) {
                     if(field992 == 2) {
                        field938 = 64;
                        field1117 = 64;
                     }

                     if(field992 == 3) {
                        field938 = 0;
                        field1117 = 64;
                     }

                     if(field992 == 4) {
                        field938 = 128;
                        field1117 = 64;
                     }

                     if(field992 == 5) {
                        field938 = 64;
                        field1117 = 0;
                     }

                     if(field992 == 6) {
                        field938 = 64;
                        field1117 = 128;
                     }

                     field992 = 2;
                     hintArrowX = secretPacketBuffer2.readUnsignedShort();
                     hintArrowY = secretPacketBuffer2.readUnsignedShort();
                     hintArrowType = secretPacketBuffer2.readUnsignedByte();
                  }

                  if(field992 == 10) {
                     field1150 = secretPacketBuffer2.readUnsignedShort();
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 44) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var54 = class239.method4167(var2);
                  } else {
                     var54 = null;
                  }

                  if(var54 != null) {
                     for(var5 = 0; var5 < var54.itemIds.length; ++var5) {
                        var54.itemIds[var5] = 0;
                        var54.itemQuantities[var5] = 0;
                     }
                  }

                  XItemContainer var81 = (XItemContainer)XItemContainer.itemContainers.get((long)var3);
                  if(var81 != null) {
                     for(var26 = 0; var26 < var81.itemIds.length; ++var26) {
                        var81.itemIds[var26] = -1;
                        var81.stackSizes[var26] = 0;
                     }
                  }

                  var5 = secretPacketBuffer2.readUnsignedShort();

                  for(var26 = 0; var26 < var5; ++var26) {
                     var29 = secretPacketBuffer2.method3124();
                     if(var29 == 255) {
                        var29 = secretPacketBuffer2.readInt();
                     }

                     var30 = secretPacketBuffer2.readUnsignedShort();
                     if(var54 != null && var26 < var54.itemIds.length) {
                        var54.itemIds[var26] = var30;
                        var54.itemQuantities[var26] = var29;
                     }

                     class225.setItemTableSlot(var3, var26, var30 - 1, var29);
                  }

                  if(var54 != null) {
                     class21.method156(var54);
                  }

                  class18.method139();
                  interfaceItemTriggers[++field1145 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               if(packetType == 148) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readUnsignedShort();
                  if(var2 < -70000) {
                     var3 += '耀';
                  }

                  if(var2 >= 0) {
                     var54 = class239.method4167(var2);
                  } else {
                     var54 = null;
                  }

                  for(; secretPacketBuffer2.offset < packetLength; class225.setItemTableSlot(var3, var5, var26 - 1, var29)) {
                     var5 = secretPacketBuffer2.getUSmart();
                     var26 = secretPacketBuffer2.readUnsignedShort();
                     var29 = 0;
                     if(var26 != 0) {
                        var29 = secretPacketBuffer2.readUnsignedByte();
                        if(var29 == 255) {
                           var29 = secretPacketBuffer2.readInt();
                        }
                     }

                     if(var54 != null && var5 >= 0 && var5 < var54.itemIds.length) {
                        var54.itemIds[var5] = var26;
                        var54.itemQuantities[var5] = var29;
                     }
                  }

                  if(var54 != null) {
                     class21.method156(var54);
                  }

                  class18.method139();
                  interfaceItemTriggers[++field1145 - 1 & 31] = var3 & 32767;
                  packetType = -1;
                  return true;
               }

               long var10;
               boolean var12;
               if(packetType == 152) {
                  var19 = secretPacketBuffer2.readString();
                  var22 = secretPacketBuffer2.readLong();
                  var24 = (long)secretPacketBuffer2.readUnsignedShort();
                  var7 = (long)secretPacketBuffer2.read24BitInt();
                  Permission var9 = (Permission)class36.forOrdinal(class252.method4350(), secretPacketBuffer2.readUnsignedByte());
                  var10 = (var24 << 32) + var7;
                  var12 = false;

                  for(int var13 = 0; var13 < 100; ++var13) {
                     if(var10 == field1123[var13]) {
                        var12 = true;
                        break;
                     }
                  }

                  if(var9.field3139 && KeyFocusListener.isIgnored(var19)) {
                     var12 = true;
                  }

                  if(!var12 && field1023 == 0) {
                     field1123[field1114] = var10;
                     field1114 = (field1114 + 1) % 100;
                     PacketBuffer var14 = secretPacketBuffer2;
                     var84 = class28.method239(var14, 32767);
                     String var15 = FontTypeFace.appendTags(class210.method3856(var84));
                     if(var9.field3146 != -1) {
                        var17 = var9.field3146;
                        var16 = "<img=" + var17 + ">";
                        FileOnDisk.addChatMessage(9, var16 + var19, var15, DecorativeObject.method2833(var22));
                     } else {
                        FileOnDisk.addChatMessage(9, var19, var15, DecorativeObject.method2833(var22));
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 161) {
                  var2 = secretPacketBuffer2.readInt();
                  var3 = secretPacketBuffer2.readInt();
                  var5 = 0;
                  if(class19.field315 == null || !class19.field315.isValid()) {
                     try {
                        Iterator var58 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                        while(var58.hasNext()) {
                           GarbageCollectorMXBean var88 = (GarbageCollectorMXBean)var58.next();
                           if(var88.isValid()) {
                              class19.field315 = var88;
                              GameEngine.field718 = -1L;
                              GameEngine.field717 = -1L;
                           }
                        }
                     } catch (Throwable var48) {
                        ;
                     }
                  }

                  if(class19.field315 != null) {
                     long var42 = class157.currentTimeMs();
                     var36 = class19.field315.getCollectionTime();
                     if(-1L != GameEngine.field717) {
                        var10 = var36 - GameEngine.field717;
                        long var44 = var42 - GameEngine.field718;
                        if(var44 != 0L) {
                           var5 = (int)(100L * var10 / var44);
                        }
                     }

                     GameEngine.field717 = var36;
                     GameEngine.field718 = var42;
                  }

                  secretPacketBuffer1.putOpcode(160);
                  secretPacketBuffer1.method3120(GameEngine.FPS);
                  secretPacketBuffer1.method3167(var2);
                  secretPacketBuffer1.method3139(var3);
                  secretPacketBuffer1.putByte(var5);
                  packetType = -1;
                  return true;
               }

               int var31;
               if(packetType == 102) {
                  field937 = cycleCntr;
                  if(packetLength == 0) {
                     clanChatOwner = null;
                     clanChatName = null;
                     VarPlayerType.clanChatCount = 0;
                     KeyFocusListener.clanMembers = null;
                     packetType = -1;
                     return true;
                  }

                  clanChatName = secretPacketBuffer2.readString();
                  long var34 = secretPacketBuffer2.readLong();
                  clanChatOwner = class208.method3829(var34);
                  WorldMapType3.field372 = secretPacketBuffer2.readByte();
                  var20 = secretPacketBuffer2.readUnsignedByte();
                  if(var20 == 255) {
                     packetType = -1;
                     return true;
                  }

                  VarPlayerType.clanChatCount = var20;
                  XClanMember[] var80 = new XClanMember[100];

                  for(var26 = 0; var26 < VarPlayerType.clanChatCount; ++var26) {
                     var80[var26] = new XClanMember();
                     var80[var26].username = secretPacketBuffer2.readString();
                     var80[var26].field906 = class215.method3908(var80[var26].username, class22.field331);
                     var80[var26].world = secretPacketBuffer2.readUnsignedShort();
                     var80[var26].rank = secretPacketBuffer2.readByte();
                     secretPacketBuffer2.readString();
                     if(var80[var26].username.equals(class226.localPlayer.name)) {
                        CombatInfo1.clanChatRank = var80[var26].rank;
                     }
                  }

                  var85 = false;
                  var30 = VarPlayerType.clanChatCount;

                  while(var30 > 0) {
                     var85 = true;
                     --var30;

                     for(var31 = 0; var31 < var30; ++var31) {
                        if(var80[var31].field906.compareTo(var80[var31 + 1].field906) > 0) {
                           XClanMember var87 = var80[var31];
                           var80[var31] = var80[var31 + 1];
                           var80[var31 + 1] = var87;
                           var85 = false;
                        }
                     }

                     if(var85) {
                        break;
                     }
                  }

                  KeyFocusListener.clanMembers = var80;
                  packetType = -1;
                  return true;
               }

               if(packetType == 156) {
                  while(secretPacketBuffer2.offset < packetLength) {
                     var51 = secretPacketBuffer2.readUnsignedByte() == 1;
                     var72 = secretPacketBuffer2.readString();
                     var53 = secretPacketBuffer2.readString();
                     var5 = secretPacketBuffer2.readUnsignedShort();
                     var26 = secretPacketBuffer2.readUnsignedByte();
                     var29 = secretPacketBuffer2.readUnsignedByte();
                     boolean var91 = (var29 & 2) != 0;
                     boolean var92 = (var29 & 1) != 0;
                     if(var5 > 0) {
                        secretPacketBuffer2.readString();
                        secretPacketBuffer2.readUnsignedByte();
                        secretPacketBuffer2.readInt();
                     }

                     secretPacketBuffer2.readString();

                     for(int var32 = 0; var32 < friendCount; ++var32) {
                        Friend var11 = friends[var32];
                        if(!var51) {
                           if(var72.equals(var11.name)) {
                              if(var5 != var11.world) {
                                 var12 = true;

                                 for(class67 var27 = (class67)field1172.method3576(); var27 != null; var27 = (class67)field1172.method3577()) {
                                    if(var27.field813.equals(var72)) {
                                       if(var5 != 0 && var27.field815 == 0) {
                                          var27.method3588();
                                          var12 = false;
                                       } else if(var5 == 0 && var27.field815 != 0) {
                                          var27.method3588();
                                          var12 = false;
                                       }
                                    }
                                 }

                                 if(var12) {
                                    field1172.method3580(new class67(var72, var5));
                                 }

                                 var11.world = var5;
                              }

                              var11.previousName = var53;
                              var11.rank = var26;
                              var11.field802 = var91;
                              var11.field803 = var92;
                              var72 = null;
                              break;
                           }
                        } else if(var53.equals(var11.name)) {
                           var11.name = var72;
                           var11.previousName = var53;
                           var72 = null;
                           break;
                        }
                     }

                     if(var72 != null && friendCount < 400) {
                        Friend var33 = new Friend();
                        friends[friendCount] = var33;
                        var33.name = var72;
                        var33.previousName = var53;
                        var33.world = var5;
                        var33.rank = var26;
                        var33.field802 = var91;
                        var33.field803 = var92;
                        ++friendCount;
                     }
                  }

                  field1170 = 2;
                  field1142 = cycleCntr;
                  var51 = false;
                  var3 = friendCount;

                  while(var3 > 0) {
                     var51 = true;
                     --var3;

                     for(var20 = 0; var20 < var3; ++var20) {
                        var55 = false;
                        Friend var57 = friends[var20];
                        Friend var86 = friends[var20 + 1];
                        if(var57.world != world && var86.world == world) {
                           var55 = true;
                        }

                        if(!var55 && var57.world == 0 && var86.world != 0) {
                           var55 = true;
                        }

                        if(!var55 && !var57.field802 && var86.field802) {
                           var55 = true;
                        }

                        if(!var55 && !var57.field803 && var86.field803) {
                           var55 = true;
                        }

                        if(var55) {
                           Friend var65 = friends[var20];
                           friends[var20] = friends[var20 + 1];
                           friends[var20 + 1] = var65;
                           var51 = false;
                        }
                     }

                     if(var51) {
                        break;
                     }
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 24) {
                  class7.decodeClassVerifier(secretPacketBuffer2, packetLength);
                  packetType = -1;
                  return true;
               }

               if(packetType == 166) {
                  class48.method674();
                  packetType = -1;
                  return false;
               }

               if(packetType == 249) {
                  var19 = secretPacketBuffer2.readString();
                  class31.sessionToken = var19;

                  try {
                     var72 = CombatInfoListHolder.clientInstance.getParameter(Parameters.field3708.key);
                     var53 = CombatInfoListHolder.clientInstance.getParameter(Parameters.field3710.key);
                     var78 = var72 + "settings=" + var19 + "; version=1; path=/; domain=" + var53;
                     if(var19.length() == 0) {
                        var78 = var78 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                     } else {
                        var78 = var78 + "; Expires=" + class116.method2050(class157.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
                     }

                     Client var56 = CombatInfoListHolder.clientInstance;
                     String var28 = "document.cookie=\"" + var78 + "\"";
                     JSObject.getWindow(var56).eval(var28);
                  } catch (Throwable var47) {
                     ;
                  }

                  packetType = -1;
                  return true;
               }

               if(packetType == 126) {
                  World var73 = new World();
                  var73.address = secretPacketBuffer2.readString();
                  var73.id = secretPacketBuffer2.readUnsignedShort();
                  var3 = secretPacketBuffer2.readInt();
                  var73.mask = var3;
                  class152.setGameState(45);
                  class13.rssocket.close();
                  class13.rssocket = null;
                  IndexDataBase.method4052(var73);
                  packetType = -1;
                  return false;
               }

               if(packetType == 218) {
                  class223.method3979(false);
                  packetType = -1;
                  return true;
               }

               if(packetType == 202) {
                  class223.method3979(true);
                  packetType = -1;
                  return true;
               }

               if(packetType != 157) {
                  if(packetType == 6) {
                     World.field1293 = secretPacketBuffer2.readUnsignedByte();
                     Signlink.field2193 = secretPacketBuffer2.method3280();

                     while(secretPacketBuffer2.offset < packetLength) {
                        packetType = secretPacketBuffer2.readUnsignedByte();
                        MessageNode.method1063();
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 68) {
                     class140.method2790(secretPacketBuffer2, packetLength);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 140) {
                     GroundObject.xteaChanged(false);
                     secretPacketBuffer2.readOpcode();
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     class140.method2790(secretPacketBuffer2, var2);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 19) {
                     GroundObject.xteaChanged(true);
                     secretPacketBuffer2.readOpcode();
                     var2 = secretPacketBuffer2.readUnsignedShort();
                     class140.method2790(secretPacketBuffer2, var2);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 46) {
                     if(widgetRoot != -1) {
                        class208.method3824(widgetRoot, 0);
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 231) {
                     var2 = secretPacketBuffer2.readInt();
                     WidgetNode var71 = (WidgetNode)componentTable.get((long)var2);
                     if(var71 != null) {
                        ScriptState.method1021(var71, true);
                     }

                     if(field1068 != null) {
                        class21.method156(field1068);
                        field1068 = null;
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 162) {
                     var2 = secretPacketBuffer2.readByteOb1();
                     widgetRoot = var2;
                     this.method1161(false);
                     class44.method599(var2);
                     class157.method2907(widgetRoot);

                     for(var3 = 0; var3 < 100; ++var3) {
                        field1109[var3] = true;
                     }

                     packetType = -1;
                     return true;
                  }

                  WidgetNode var21;
                  if(packetType == 206) {
                     var2 = secretPacketBuffer2.method3285();
                     var3 = secretPacketBuffer2.method3141();
                     WidgetNode var52 = (WidgetNode)componentTable.get((long)var3);
                     var21 = (WidgetNode)componentTable.get((long)var2);
                     if(var21 != null) {
                        ScriptState.method1021(var21, var52 == null || var52.id != var21.id);
                     }

                     if(var52 != null) {
                        var52.unlink();
                        componentTable.put(var52, (long)var2);
                     }

                     var6 = class239.method4167(var3);
                     if(var6 != null) {
                        class21.method156(var6);
                     }

                     var6 = class239.method4167(var2);
                     if(var6 != null) {
                        class21.method156(var6);
                        WorldListFetcher.method1465(Widget.widgets[var6.id >>> 16], var6, true);
                     }

                     if(widgetRoot != -1) {
                        class208.method3824(widgetRoot, 1);
                     }

                     packetType = -1;
                     return true;
                  }

                  if(packetType == 143) {
                     var2 = secretPacketBuffer2.readByteOb1();
                     var3 = secretPacketBuffer2.readInt();
                     var20 = secretPacketBuffer2.method3124();
                     var21 = (WidgetNode)componentTable.get((long)var3);
                     if(var21 != null) {
                        ScriptState.method1021(var21, var2 != var21.id);
                     }

                     class11.method54(var3, var2, var20);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 96) {
                     var19 = secretPacketBuffer2.readString();
                     Object[] var18 = new Object[var19.length() + 1];

                     for(var20 = var19.length() - 1; var20 >= 0; --var20) {
                        if(var19.charAt(var20) == 115) {
                           var18[var20 + 1] = secretPacketBuffer2.readString();
                        } else {
                           var18[var20 + 1] = new Integer(secretPacketBuffer2.readInt());
                        }
                     }

                     var18[0] = new Integer(secretPacketBuffer2.readInt());
                     ScriptEvent var4 = new ScriptEvent();
                     var4.field831 = var18;
                     Ignore.method1054(var4);
                     packetType = -1;
                     return true;
                  }

                  if(packetType == 52) {
                     var2 = packetLength + secretPacketBuffer2.offset;
                     var3 = secretPacketBuffer2.readUnsignedShort();
                     var20 = secretPacketBuffer2.readUnsignedShort();
                     if(var3 != widgetRoot) {
                        widgetRoot = var3;
                        this.method1161(false);
                        class44.method599(widgetRoot);
                        class157.method2907(widgetRoot);

                        for(var5 = 0; var5 < 100; ++var5) {
                           field1109[var5] = true;
                        }
                     }

                     WidgetNode var8;
                     for(; var20-- > 0; var8.field823 = true) {
                        var5 = secretPacketBuffer2.readInt();
                        var26 = secretPacketBuffer2.readUnsignedShort();
                        var29 = secretPacketBuffer2.readUnsignedByte();
                        var8 = (WidgetNode)componentTable.get((long)var5);
                        if(var8 != null && var26 != var8.id) {
                           ScriptState.method1021(var8, true);
                           var8 = null;
                        }

                        if(var8 == null) {
                           var8 = class11.method54(var5, var26, var29);
                        }
                     }

                     for(var21 = (WidgetNode)componentTable.method3492(); var21 != null; var21 = (WidgetNode)componentTable.method3493()) {
                        if(var21.field823) {
                           var21.field823 = false;
                        } else {
                           ScriptState.method1021(var21, true);
                        }
                     }

                     widgetFlags = new XHashTable(512);

                     while(secretPacketBuffer2.offset < var2) {
                        var5 = secretPacketBuffer2.readInt();
                        var26 = secretPacketBuffer2.readUnsignedShort();
                        var29 = secretPacketBuffer2.readUnsignedShort();
                        var30 = secretPacketBuffer2.readInt();

                        for(var31 = var26; var31 <= var29; ++var31) {
                           var10 = ((long)var5 << 32) + (long)var31;
                           widgetFlags.put(new IntegerNode(var30), var10);
                        }
                     }

                     packetType = -1;
                     return true;
                  }

                  WorldMapType2.method495("" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength, (Throwable)null);
                  class48.method674();
                  return true;
               }
            }

            MessageNode.method1063();
            packetType = -1;
            return true;
         } catch (IOException var49) {
            if(field967 > 0) {
               class48.method674();
            } else {
               class152.setGameState(40);
               class56.field680 = class13.rssocket;
               class13.rssocket = null;
            }
         } catch (Exception var50) {
            var19 = "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength + "," + (class226.localPlayer.pathX[0] + class21.baseX) + "," + (class226.localPlayer.pathY[0] + class164.baseY) + ",";

            for(var3 = 0; var3 < packetLength && var3 < 50; ++var3) {
               var19 = var19 + secretPacketBuffer2.payload[var3] + ",";
            }

            WorldMapType2.method495(var19, var50);
            class48.method674();
         }

         return true;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16777215"
   )
   @Export("packetHandler")
   protected final void packetHandler() {
      ++gameCycle;
      this.processJS5Connection();
      CollisionData.method2977();

      int var1;
      try {
         if(class203.field2471 == 1) {
            var1 = class203.field2470.method3643();
            if(var1 > 0 && class203.field2470.method3649()) {
               var1 -= ChatLineBuffer.field1524;
               if(var1 < 0) {
                  var1 = 0;
               }

               class203.field2470.method3642(var1);
            } else {
               class203.field2470.method3648();
               class203.field2470.method3646();
               if(class222.field2815 != null) {
                  class203.field2471 = 2;
               } else {
                  class203.field2471 = 0;
               }

               class203.field2475 = null;
               class12.field260 = null;
            }
         }
      } catch (Exception var5) {
         var5.printStackTrace();
         class203.field2470.method3648();
         class203.field2471 = 0;
         class203.field2475 = null;
         class12.field260 = null;
         class222.field2815 = null;
      }

      class140.method2791();
      class44.method601();
      MouseInput var3 = MouseInput.mouse;
      synchronized(MouseInput.mouse) {
         MouseInput.field733 = MouseInput.field726 * -1165717537;
         MouseInput.field730 = MouseInput.mouseX;
         MouseInput.field731 = MouseInput.mouseY;
         MouseInput.field729 = MouseInput.field732;
         MouseInput.field737 = MouseInput.field739;
         MouseInput.field723 = MouseInput.field734;
         MouseInput.field722 = MouseInput.field735;
         MouseInput.field732 = 0;
      }

      if(WorldMapData.field438 != null) {
         var1 = WorldMapData.field438.vmethod2900();
         field1102 = var1;
      }

      if(gameState == 0) {
         Signlink.load();
         ItemLayer.timer.vmethod2909();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field696[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field686[var1] = 0L;
         }

         GameEngine.field692 = 0;
      } else if(gameState == 5) {
         Signlink.method2887(this);
         Signlink.load();
         ItemLayer.timer.vmethod2909();

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field696[var1] = 0L;
         }

         for(var1 = 0; var1 < 32; ++var1) {
            GameEngine.field686[var1] = 0L;
         }

         GameEngine.field692 = 0;
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            Signlink.method2887(this);
            this.method1105();
         } else if(gameState == 25) {
            class40.method528();
         }
      } else {
         Signlink.method2887(this);
      }

      if(gameState == 30) {
         this.method1106();
      } else if(gameState == 40 || gameState == 45) {
         this.method1105();
      }

   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1325413359"
   )
   final void method1113(int var1, int var2) {
      int var3 = Area.field3285.method4635("Choose Option");

      int var4;
      int var5;
      for(var4 = 0; var4 < menuOptionCount; ++var4) {
         var5 = Area.field3285.method4635(MessageNode.method1060(var4));
         if(var5 > var3) {
            var3 = var5;
         }
      }

      var3 += 8;
      var4 = menuOptionCount * 15 + 22;
      var5 = var1 - var3 / 2;
      if(var5 + var3 > class45.canvasWidth) {
         var5 = class45.canvasWidth - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      int var6 = var2;
      if(var2 + var4 > class10.canvasHeight) {
         var6 = class10.canvasHeight - var4;
      }

      if(var6 < 0) {
         var6 = 0;
      }

      class19.region.method2654(class10.plane, var1, var2, false);
      isMenuOpen = true;
      class37.menuX = var5;
      IndexDataBase.menuY = var6;
      WorldMapData.menuWidth = var3;
      MilliTimer.menuHeight = menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1270267513"
   )
   void method1318() {
      if(class238.field3240 >= 4) {
         this.error("js5crc");
         gameState = 1000;
      } else {
         if(class238.field3241 >= 4) {
            if(gameState <= 5) {
               this.error("js5io");
               gameState = 1000;
               return;
            }

            field932 = 3000;
            class238.field3241 = 3;
         }

         if(--field932 + 1 <= 0) {
            try {
               if(js5State == 0) {
                  class18.socket = GameEngine.taskManager.createSocket(DynamicObject.host, class18.myWorldPort);
                  ++js5State;
               }

               if(js5State == 1) {
                  if(class18.socket.status == 2) {
                     this.error(-1);
                     return;
                  }

                  if(class18.socket.status == 1) {
                     ++js5State;
                  }
               }

               if(js5State == 2) {
                  class21.rssocket = new RSSocket((Socket)class18.socket.value, GameEngine.taskManager);
                  Buffer var1 = new Buffer(5);
                  var1.putByte(15);
                  var1.putInt(150);
                  class21.rssocket.queueForWrite(var1.payload, 0, 5);
                  ++js5State;
                  class96.field1479 = class157.currentTimeMs();
               }

               if(js5State == 3) {
                  if(gameState > 5 && class21.rssocket.available() <= 0) {
                     if(class157.currentTimeMs() - class96.field1479 > 30000L) {
                        this.error(-2);
                        return;
                     }
                  } else {
                     int var5 = class21.rssocket.readByte();
                     if(var5 != 0) {
                        this.error(var5);
                        return;
                     }

                     ++js5State;
                  }
               }

               if(js5State == 4) {
                  RSSocket var10 = class21.rssocket;
                  boolean var2 = gameState > 20;
                  if(class238.field3226 != null) {
                     try {
                        class238.field3226.close();
                     } catch (Exception var8) {
                        ;
                     }

                     class238.field3226 = null;
                  }

                  class238.field3226 = var10;
                  CombatInfoListHolder.sendConInfo(var2);
                  class238.field3234.offset = 0;
                  class238.currentRequest = null;
                  GameObject.field2154 = null;
                  class238.field3235 = 0;

                  while(true) {
                     FileRequest var3 = (FileRequest)class238.field3233.method3492();
                     if(var3 == null) {
                        while(true) {
                           var3 = (FileRequest)class238.field3231.method3492();
                           if(var3 == null) {
                              if(class238.field3239 != 0) {
                                 try {
                                    Buffer var11 = new Buffer(4);
                                    var11.putByte(4);
                                    var11.putByte(class238.field3239);
                                    var11.putShort(0);
                                    class238.field3226.queueForWrite(var11.payload, 0, 4);
                                 } catch (IOException var7) {
                                    try {
                                       class238.field3226.close();
                                    } catch (Exception var6) {
                                       ;
                                    }

                                    ++class238.field3241;
                                    class238.field3226 = null;
                                 }
                              }

                              class238.field3229 = 0;
                              class238.field3223 = class157.currentTimeMs();
                              class18.socket = null;
                              class21.rssocket = null;
                              js5State = 0;
                              field976 = 0;
                              return;
                           }

                           class238.field3232.setHead(var3);
                           class238.field3227.put(var3, var3.hash);
                           ++class238.field3221;
                           --class238.field3228;
                        }
                     }

                     class238.field3224.put(var3, var3.hash);
                     ++class238.field3225;
                     --class238.field3238;
                  }
               }
            } catch (IOException var9) {
               this.error(-3);
            }

         }
      }
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2140598815"
   )
   final void method1109() {
      if(widgetRoot != -1) {
         class56.method788(widgetRoot);
      }

      int var1;
      for(var1 = 0; var1 < field1107; ++var1) {
         if(field1109[var1]) {
            field1064[var1] = true;
         }

         field1111[var1] = field1109[var1];
         field1109[var1] = false;
      }

      field1108 = gameCycle;
      field1053 = -1;
      field1054 = -1;
      class175.field2370 = null;
      if(widgetRoot != -1) {
         field1107 = 0;
         Renderable.drawWidget(widgetRoot, 0, 0, class45.canvasWidth, class10.canvasHeight, 0, 0, -1);
      }

      Rasterizer2D.noClip();
      int var2;
      int var3;
      if(!isMenuOpen) {
         if(field1053 != -1) {
            var1 = field1053;
            var2 = field1054;
            if(menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
               var3 = class37.method492();
               String var4;
               if(itemSelectionState == 1 && menuOptionCount < 2) {
                  var4 = "Use" + " " + field1058 + " " + "->";
               } else if(spellSelected && menuOptionCount < 2) {
                  var4 = field1062 + " " + field1063 + " " + "->";
               } else {
                  var4 = MessageNode.method1060(var3);
               }

               if(menuOptionCount > 2) {
                  var4 = var4 + class8.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2) + " more options";
               }

               Area.field3285.drawRandomizedMouseoverText(var4, var1 + 4, var2 + 15, 16777215, 0, gameCycle / 1000);
            }
         }
      } else {
         ScriptEvent.method1046();
      }

      if(gameDrawingMode == 3) {
         for(var1 = 0; var1 < field1107; ++var1) {
            if(field1111[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711935, 128);
            } else if(field1064[var1]) {
               Rasterizer2D.fillRectangle(widgetPositionX[var1], widgetPositionY[var1], widgetBoundsWidth[var1], widgetBoundsHeight[var1], 16711680, 128);
            }
         }
      }

      var1 = class10.plane;
      var2 = class226.localPlayer.x;
      var3 = class226.localPlayer.y;
      int var12 = field1066;

      for(class82 var5 = (class82)class82.field1311.getFront(); var5 != null; var5 = (class82)class82.field1311.getNext()) {
         if(var5.field1312 != -1 || var5.field1314 != null) {
            int var6 = 0;
            if(var2 > var5.field1307) {
               var6 += var2 - var5.field1307;
            } else if(var2 < var5.field1315) {
               var6 += var5.field1315 - var2;
            }

            if(var3 > var5.field1317) {
               var6 += var3 - var5.field1317;
            } else if(var3 < var5.field1306) {
               var6 += var5.field1306 - var3;
            }

            if(var6 - 64 <= var5.field1309 && field1035 != 0 && var1 == var5.field1304) {
               var6 -= 64;
               if(var6 < 0) {
                  var6 = 0;
               }

               int var7 = (var5.field1309 - var6) * field1035 / var5.field1309;
               Object var10000;
               if(var5.field1308 == null) {
                  if(var5.field1312 >= 0) {
                     var10000 = null;
                     SoundEffect var8 = SoundEffect.getTrack(class25.field353, var5.field1312, 0);
                     if(var8 != null) {
                        class107 var9 = var8.method1867().method1913(class9.field237);
                        class117 var10 = class117.method2054(var9, 100, var7);
                        var10.method2057(-1);
                        class1.field4.method1808(var10);
                        var5.field1308 = var10;
                     }
                  }
               } else {
                  var5.field1308.method2058(var7);
               }

               if(var5.field1316 == null) {
                  if(var5.field1314 != null && (var5.field1303 -= var12) <= 0) {
                     int var13 = (int)(Math.random() * (double)var5.field1314.length);
                     var10000 = null;
                     SoundEffect var14 = SoundEffect.getTrack(class25.field353, var5.field1314[var13], 0);
                     if(var14 != null) {
                        class107 var15 = var14.method1867().method1913(class9.field237);
                        class117 var11 = class117.method2054(var15, 100, var7);
                        var11.method2057(0);
                        class1.field4.method1808(var11);
                        var5.field1316 = var11;
                        var5.field1303 = var5.field1305 + (int)(Math.random() * (double)(var5.field1313 - var5.field1305));
                     }
                  }
               } else {
                  var5.field1316.method2058(var7);
                  if(!var5.field1316.linked()) {
                     var5.field1316 = null;
                  }
               }
            } else {
               if(var5.field1308 != null) {
                  class1.field4.method1809(var5.field1308);
                  var5.field1308 = null;
               }

               if(var5.field1316 != null) {
                  class1.field4.method1809(var5.field1316);
                  var5.field1316 = null;
               }
            }
         }
      }

      field1066 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1831915263"
   )
   protected final void vmethod1107() {
      field1050 = class157.currentTimeMs() + 500L;
      this.method1108();
      if(widgetRoot != -1) {
         this.method1161(true);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1449216411"
   )
   @Hook("clientMainLoop")
   protected final void vmethod1100(boolean var1) {
      boolean var2;
      label193: {
         try {
            if(class203.field2471 == 2) {
               if(class203.field2475 == null) {
                  class203.field2475 = Track1.getMusicFile(class222.field2815, class203.field2468, class203.field2473);
                  if(class203.field2475 == null) {
                     var2 = false;
                     break label193;
                  }
               }

               if(class12.field260 == null) {
                  class12.field260 = new class112(class266.field3644, class203.field2469);
               }

               if(class203.field2470.method3644(class203.field2475, class203.field2476, class12.field260, 22050)) {
                  class203.field2470.method3691();
                  class203.field2470.method3642(WorldMapType2.field513);
                  class203.field2470.method3647(class203.field2475, class203.field2474);
                  class203.field2471 = 0;
                  class203.field2475 = null;
                  class12.field260 = null;
                  class222.field2815 = null;
                  var2 = true;
                  break label193;
               }
            }
         } catch (Exception var7) {
            var7.printStackTrace();
            class203.field2470.method3648();
            class203.field2471 = 0;
            class203.field2475 = null;
            class12.field260 = null;
            class222.field2815 = null;
         }

         var2 = false;
      }

      if(var2 && field1141 && VertexNormal.soundSystem0 != null) {
         VertexNormal.soundSystem0.method1971();
      }

      int var4;
      if((gameState == 10 || gameState == 20 || gameState == 30) && 0L != field1050 && class157.currentTimeMs() > field1050) {
         var4 = isResized?2:1;
         field1050 = 0L;
         if(var4 >= 2) {
            isResized = true;
         } else {
            isResized = false;
         }

         int var5 = isResized?2:1;
         if(var5 == 1) {
            CombatInfoListHolder.clientInstance.method916(765, 503);
         } else {
            CombatInfoListHolder.clientInstance.method916(7680, 2160);
         }

         if(gameState >= 25) {
            XItemContainer.method1031();
         }
      }

      if(var1) {
         for(var4 = 0; var4 < 100; ++var4) {
            field1109[var4] = true;
         }
      }

      if(gameState == 0) {
         this.drawLoadingScreen(class92.loadingBarPercentage, class92.loadingText, var1);
      } else if(gameState == 5) {
         Permission.drawLoginScreen(Area.field3285, class15.field293, class112.font_p12full, var1);
      } else if(gameState != 10 && gameState != 11) {
         if(gameState == 20) {
            Permission.drawLoginScreen(Area.field3285, class15.field293, class112.font_p12full, var1);
         } else if(gameState == 25) {
            if(field974 == 1) {
               if(field970 > field971) {
                  field971 = field970;
               }

               var4 = (field971 * 50 - field970 * 50) / field971;
               class163.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else if(field974 == 2) {
               if(field972 > field1024) {
                  field1024 = field972;
               }

               var4 = (field1024 * 50 - field972 * 50) / field1024 + 50;
               class163.drawStatusBox("Loading - please wait." + "<br>" + " (" + var4 + "%" + ")", false);
            } else {
               class163.drawStatusBox("Loading - please wait.", false);
            }
         } else if(gameState == 30) {
            this.method1109();
         } else if(gameState == 40) {
            class163.drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
         } else if(gameState == 45) {
            class163.drawStatusBox("Please wait...", false);
         }
      } else {
         Permission.drawLoginScreen(Area.field3285, class15.field293, class112.font_p12full, var1);
      }

      if(gameState == 30 && gameDrawingMode == 0 && !var1 && !isResized) {
         for(var4 = 0; var4 < field1107; ++var4) {
            if(field1064[var4]) {
               WorldMapType1.field417.vmethod4910(widgetPositionX[var4], widgetPositionY[var4], widgetBoundsWidth[var4], widgetBoundsHeight[var4]);
               field1064[var4] = false;
            }
         }
      } else if(gameState > 0) {
         WorldMapType1.field417.vmethod4917(0, 0);

         for(var4 = 0; var4 < field1107; ++var4) {
            field1064[var4] = false;
         }
      }

   }

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "865805453"
   )
   final void method1105() {
      try {
         if(loginState == 0) {
            if(class13.rssocket != null) {
               class13.rssocket.close();
               class13.rssocket = null;
            }

            class11.field256 = null;
            socketError = false;
            field946 = 0;
            loginState = 1;
         }

         if(loginState == 1) {
            if(class11.field256 == null) {
               class11.field256 = GameEngine.taskManager.createSocket(DynamicObject.host, class18.myWorldPort);
            }

            if(class11.field256.status == 2) {
               throw new IOException();
            }

            if(class11.field256.status == 1) {
               class13.rssocket = new RSSocket((Socket)class11.field256.value, GameEngine.taskManager);
               class11.field256 = null;
               loginState = 2;
            }
         }

         if(loginState == 2) {
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(14);
            class13.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, 1);
            secretPacketBuffer2.offset = 0;
            loginState = 3;
         }

         int var1;
         if(loginState == 3) {
            if(VertexNormal.soundSystem0 != null) {
               VertexNormal.soundSystem0.method1976();
            }

            if(MessageNode.soundSystem1 != null) {
               MessageNode.soundSystem1.method1976();
            }

            var1 = class13.rssocket.readByte();
            if(VertexNormal.soundSystem0 != null) {
               VertexNormal.soundSystem0.method1976();
            }

            if(MessageNode.soundSystem1 != null) {
               MessageNode.soundSystem1.method1976();
            }

            if(var1 != 0) {
               class11.method53(var1);
               return;
            }

            secretPacketBuffer2.offset = 0;
            loginState = 4;
         }

         if(loginState == 4) {
            if(secretPacketBuffer2.offset < 8) {
               var1 = class13.rssocket.available();
               if(var1 > 8 - secretPacketBuffer2.offset) {
                  var1 = 8 - secretPacketBuffer2.offset;
               }

               if(var1 > 0) {
                  class13.rssocket.read(secretPacketBuffer2.payload, secretPacketBuffer2.offset, var1);
                  secretPacketBuffer2.offset += var1;
               }
            }

            if(secretPacketBuffer2.offset == 8) {
               secretPacketBuffer2.offset = 0;
               class157.field2215 = secretPacketBuffer2.readLong();
               loginState = 5;
            }
         }

         int var2;
         int var3;
         if(loginState == 5) {
            int[] var9 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(class157.field2215 >> 32), (int)(class157.field2215 & -1L)};
            secretPacketBuffer1.offset = 0;
            secretPacketBuffer1.putByte(1);
            secretPacketBuffer1.putByte(class92.field1422.rsOrdinal());
            secretPacketBuffer1.putInt(var9[0]);
            secretPacketBuffer1.putInt(var9[1]);
            secretPacketBuffer1.putInt(var9[2]);
            secretPacketBuffer1.putInt(var9[3]);
            switch(class92.field1422.field2159) {
            case 0:
               secretPacketBuffer1.offset += 8;
               break;
            case 1:
            case 2:
               secretPacketBuffer1.put24bitInt(Ignore.authCodeForLogin);
               secretPacketBuffer1.offset += 5;
               break;
            case 3:
               secretPacketBuffer1.putInt(((Integer)class34.preferences.preferences.get(Integer.valueOf(class244.method4222(class92.username)))).intValue());
               secretPacketBuffer1.offset += 4;
            }

            secretPacketBuffer1.putString(class92.password);
            secretPacketBuffer1.encryptRsa(class90.rsaKeyExponent, class90.rsaKeyModulus);
            field1132.offset = 0;
            if(gameState == 40) {
               field1132.putByte(18);
            } else {
               field1132.putByte(16);
            }

            field1132.putShort(0);
            var2 = field1132.offset;
            field1132.putInt(150);
            field1132.putBytes(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
            var3 = field1132.offset;
            field1132.putString(class92.username);
            field1132.putByte((isResized?1:0) << 1 | (lowMemory?1:0));
            field1132.putShort(class45.canvasWidth);
            field1132.putShort(class10.canvasHeight);
            PacketBuffer var4 = field1132;
            if(field951 != null) {
               var4.putBytes(field951, 0, field951.length);
            } else {
               byte[] var11 = new byte[24];

               try {
                  class155.field2207.seek(0L);
                  class155.field2207.read(var11);

                  int var7;
                  for(var7 = 0; var7 < 24 && var11[var7] == 0; ++var7) {
                     ;
                  }

                  if(var7 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var15) {
                  for(int var8 = 0; var8 < 24; ++var8) {
                     var11[var8] = -1;
                  }
               }

               var4.putBytes(var11, 0, var11.length);
            }

            field1132.putString(class31.sessionToken);
            field1132.putInt(class20.field323);
            Buffer var5 = new Buffer(class214.field2600.method5268());
            class214.field2600.method5267(var5);
            field1132.putBytes(var5.payload, 0, var5.payload.length);
            field1132.putByte(field941);
            field1132.putInt(0);
            field1132.putInt(class37.indexInterfaces.crc);
            field1132.putInt(class112.indexSoundEffects.crc);
            field1132.putInt(configsIndex.crc);
            field1132.putInt(Overlay.field3568.crc);
            field1132.putInt(class25.field353.crc);
            field1132.putInt(ISAACCipher.indexMaps.crc);
            field1132.putInt(class8.indexTrack1.crc);
            field1132.putInt(class1.indexModels.crc);
            field1132.putInt(class271.indexSprites.crc);
            field1132.putInt(WorldMapType3.indexTextures.crc);
            field1132.putInt(class27.field387.crc);
            field1132.putInt(class222.indexTrack2.crc);
            field1132.putInt(class13.indexScripts.crc);
            field1132.putInt(class60.field744.crc);
            field1132.putInt(ChatLineBuffer.vorbisIndex.crc);
            field1132.putInt(class92.field1431.crc);
            field1132.putInt(Item.indexWorldMap.crc);
            field1132.encryptXtea(var9, var3, field1132.offset);
            field1132.putShortLength(field1132.offset - var2);
            class13.rssocket.queueForWrite(field1132.payload, 0, field1132.offset);
            secretPacketBuffer1.seed(var9);

            for(int var6 = 0; var6 < 4; ++var6) {
               var9[var6] += 50;
            }

            secretPacketBuffer2.seed(var9);
            loginState = 6;
         }

         if(loginState == 6 && class13.rssocket.available() > 0) {
            var1 = class13.rssocket.readByte();
            if(var1 == 21 && gameState == 20) {
               loginState = 7;
            } else if(var1 == 2) {
               loginState = 9;
            } else if(var1 == 15 && gameState == 40) {
               packetLength = -1;
               loginState = 13;
            } else if(var1 == 23 && field949 < 1) {
               ++field949;
               loginState = 0;
            } else {
               if(var1 != 29) {
                  class11.method53(var1);
                  return;
               }

               loginState = 11;
            }
         }

         if(loginState == 7 && class13.rssocket.available() > 0) {
            field950 = (class13.rssocket.readByte() + 3) * 60;
            loginState = 8;
         }

         if(loginState == 8) {
            field946 = 0;
            class22.method165("You have only just left another world.", "Your profile will be transferred in:", field950 / 60 + " seconds.");
            if(--field950 <= 0) {
               loginState = 0;
            }

         } else {
            if(loginState == 9 && class13.rssocket.available() >= 13) {
               boolean var18 = class13.rssocket.readByte() == 1;
               class13.rssocket.read(secretPacketBuffer2.payload, 0, 4);
               secretPacketBuffer2.offset = 0;
               boolean var17 = false;
               if(var18) {
                  var2 = secretPacketBuffer2.readOpcode() << 24;
                  var2 |= secretPacketBuffer2.readOpcode() << 16;
                  var2 |= secretPacketBuffer2.readOpcode() << 8;
                  var2 |= secretPacketBuffer2.readOpcode();
                  var3 = class244.method4222(class92.username);
                  if(class34.preferences.preferences.size() >= 10 && !class34.preferences.preferences.containsKey(Integer.valueOf(var3))) {
                     Iterator var19 = class34.preferences.preferences.entrySet().iterator();
                     var19.next();
                     var19.remove();
                  }

                  class34.preferences.preferences.put(Integer.valueOf(var3), Integer.valueOf(var2));
                  class10.method51();
               }

               rights = class13.rssocket.readByte();
               field1073 = class13.rssocket.readByte() == 1;
               localInteractingIndex = class13.rssocket.readByte();
               localInteractingIndex <<= 8;
               localInteractingIndex += class13.rssocket.readByte();
               field1026 = class13.rssocket.readByte();
               class13.rssocket.read(secretPacketBuffer2.payload, 0, 1);
               secretPacketBuffer2.offset = 0;
               packetType = secretPacketBuffer2.readOpcode();
               class13.rssocket.read(secretPacketBuffer2.payload, 0, 2);
               secretPacketBuffer2.offset = 0;
               packetLength = secretPacketBuffer2.readUnsignedShort();

               try {
                  Client var10 = CombatInfoListHolder.clientInstance;
                  JSObject.getWindow(var10).call("zap", (Object[])null);
               } catch (Throwable var14) {
                  ;
               }

               loginState = 10;
            }

            if(loginState == 10) {
               if(class13.rssocket.available() >= packetLength) {
                  secretPacketBuffer2.offset = 0;
                  class13.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                  class261.method4617();
                  BufferProvider.initializeGPI(secretPacketBuffer2);
                  class181.field2404 = -1;
                  GroundObject.xteaChanged(false);
                  packetType = -1;
               }

            } else {
               if(loginState == 11 && class13.rssocket.available() >= 2) {
                  secretPacketBuffer2.offset = 0;
                  class13.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                  secretPacketBuffer2.offset = 0;
                  class17.field305 = secretPacketBuffer2.readUnsignedShort();
                  loginState = 12;
               }

               if(loginState == 12 && class13.rssocket.available() >= class17.field305) {
                  secretPacketBuffer2.offset = 0;
                  class13.rssocket.read(secretPacketBuffer2.payload, 0, class17.field305);
                  secretPacketBuffer2.offset = 0;
                  String var20 = secretPacketBuffer2.readString();
                  String var12 = secretPacketBuffer2.readString();
                  String var21 = secretPacketBuffer2.readString();
                  class22.method165(var20, var12, var21);
                  class152.setGameState(10);
               }

               if(loginState == 13) {
                  if(packetLength == -1) {
                     if(class13.rssocket.available() < 2) {
                        return;
                     }

                     class13.rssocket.read(secretPacketBuffer2.payload, 0, 2);
                     secretPacketBuffer2.offset = 0;
                     packetLength = secretPacketBuffer2.readUnsignedShort();
                  }

                  if(class13.rssocket.available() >= packetLength) {
                     class13.rssocket.read(secretPacketBuffer2.payload, 0, packetLength);
                     secretPacketBuffer2.offset = 0;
                     var1 = packetLength;
                     Player.method1093();
                     BufferProvider.initializeGPI(secretPacketBuffer2);
                     if(var1 != secretPacketBuffer2.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++field946;
                  if(field946 > 2000) {
                     if(field949 < 1) {
                        if(class18.myWorldPort == WidgetNode.field827) {
                           class18.myWorldPort = class33.field456;
                        } else {
                           class18.myWorldPort = WidgetNode.field827;
                        }

                        ++field949;
                        loginState = 0;
                     } else {
                        class11.method53(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var16) {
         if(field949 < 1) {
            if(class18.myWorldPort == WidgetNode.field827) {
               class18.myWorldPort = class33.field456;
            } else {
               class18.myWorldPort = WidgetNode.field827;
            }

            ++field949;
            loginState = 0;
         } else {
            class11.method53(-2);
         }
      }
   }

   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   final void method1106() {
      if(field1070 > 1) {
         --field1070;
      }

      if(field967 > 0) {
         --field967;
      }

      if(socketError) {
         socketError = false;
         if(field967 > 0) {
            class48.method674();
         } else {
            class152.setGameState(40);
            class56.field680 = class13.rssocket;
            class13.rssocket = null;
         }

      } else {
         if(!isMenuOpen) {
            class48.method698();
         }

         int var1;
         for(var1 = 0; var1 < 100 && this.processServerPacket(); ++var1) {
            ;
         }

         if(gameState == 30) {
            while(class182.method3387()) {
               secretPacketBuffer1.putOpcode(203);
               secretPacketBuffer1.putByte(0);
               var1 = secretPacketBuffer1.offset;
               class217.encodeClassVerifier(secretPacketBuffer1);
               secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var1);
            }

            Object var13 = field1038.field849;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            synchronized(field1038.field849) {
               if(!field1060) {
                  field1038.field850 = 0;
               } else if(MouseInput.field729 != 0 || field1038.field850 >= 40) {
                  secretPacketBuffer1.putOpcode(44);
                  secretPacketBuffer1.putByte(0);
                  int var2 = secretPacketBuffer1.offset;
                  var3 = 0;

                  for(var4 = 0; var4 < field1038.field850 && secretPacketBuffer1.offset - var2 < 240; ++var4) {
                     ++var3;
                     var5 = field1038.field852[var4];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 502) {
                        var5 = 502;
                     }

                     var6 = field1038.field853[var4];
                     if(var6 < 0) {
                        var6 = 0;
                     } else if(var6 > 764) {
                        var6 = 764;
                     }

                     var7 = var6 + var5 * 765;
                     if(field1038.field852[var4] == -1 && field1038.field853[var4] == -1) {
                        var6 = -1;
                        var5 = -1;
                        var7 = 524287;
                     }

                     if(var6 == field926 && var5 == field927) {
                        if(field969 < 2047) {
                           ++field969;
                        }
                     } else {
                        var8 = var6 - field926;
                        field926 = var6;
                        var9 = var5 - field927;
                        field927 = var5;
                        if(field969 < 8 && var8 >= -32 && var8 <= 31 && var9 >= -32 && var9 <= 31) {
                           var8 += 32;
                           var9 += 32;
                           secretPacketBuffer1.putShort(var9 + (field969 << 12) + (var8 << 6));
                           field969 = 0;
                        } else if(field969 < 8) {
                           secretPacketBuffer1.put24bitInt(var7 + (field969 << 19) + 8388608);
                           field969 = 0;
                        } else {
                           secretPacketBuffer1.putInt(var7 + (field969 << 19) + -1073741824);
                           field969 = 0;
                        }
                     }
                  }

                  secretPacketBuffer1.putLength(secretPacketBuffer1.offset - var2);
                  if(var3 >= field1038.field850) {
                     field1038.field850 = 0;
                  } else {
                     field1038.field850 -= var3;

                     for(var4 = 0; var4 < field1038.field850; ++var4) {
                        field1038.field853[var4] = field1038.field853[var3 + var4];
                        field1038.field852[var4] = field1038.field852[var4 + var3];
                     }
                  }
               }
            }

            if(MouseInput.field729 == 1 || !GameEngine.field699 && MouseInput.field729 == 4 || MouseInput.field729 == 2) {
               long var14 = (MouseInput.field722 - field924) / 50L;
               if(var14 > 4095L) {
                  var14 = 4095L;
               }

               field924 = MouseInput.field722;
               var3 = MouseInput.field723;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class10.canvasHeight) {
                  var3 = class10.canvasHeight;
               }

               var4 = MouseInput.field737;
               if(var4 < 0) {
                  var4 = 0;
               } else if(var4 > class45.canvasWidth) {
                  var4 = class45.canvasWidth;
               }

               var5 = (int)var14;
               secretPacketBuffer1.putOpcode(178);
               secretPacketBuffer1.putShort((var5 << 1) + (MouseInput.field729 == 2?1:0));
               secretPacketBuffer1.putShort(var4);
               secretPacketBuffer1.putShort(var3);
            }

            if(KeyFocusListener.field627 > 0) {
               secretPacketBuffer1.putOpcode(88);
               secretPacketBuffer1.putShort(0);
               var1 = secretPacketBuffer1.offset;
               long var16 = class157.currentTimeMs();

               for(var4 = 0; var4 < KeyFocusListener.field627; ++var4) {
                  long var18 = var16 - field1128;
                  if(var18 > 16777215L) {
                     var18 = 16777215L;
                  }

                  field1128 = var16;
                  secretPacketBuffer1.method3217(KeyFocusListener.field642[var4]);
                  secretPacketBuffer1.method3135((int)var18);
               }

               secretPacketBuffer1.putShortLength(secretPacketBuffer1.offset - var1);
            }

            if(field994 > 0) {
               --field994;
            }

            if(KeyFocusListener.field636[96] || KeyFocusListener.field636[97] || KeyFocusListener.field636[98] || KeyFocusListener.field636[99]) {
               field1146 = true;
            }

            if(field1146 && field994 <= 0) {
               field994 = 20;
               field1146 = false;
               secretPacketBuffer1.putOpcode(229);
               secretPacketBuffer1.putLEInt(mapAngle);
               secretPacketBuffer1.method3129(field987);
            }

            if(class31.field425 && !field929) {
               field929 = true;
               secretPacketBuffer1.putOpcode(116);
               secretPacketBuffer1.putByte(1);
            }

            if(!class31.field425 && field929) {
               field929 = false;
               secretPacketBuffer1.putOpcode(116);
               secretPacketBuffer1.putByte(0);
            }

            if(class10.plane != field1131) {
               field1131 = class10.plane;
               class203.method3640(class10.plane);
            }

            if(gameState == 30) {
               for(PendingSpawn var29 = (PendingSpawn)pendingSpawns.getFront(); var29 != null; var29 = (PendingSpawn)pendingSpawns.getNext()) {
                  if(var29.hitpoints > 0) {
                     --var29.hitpoints;
                  }

                  if(var29.hitpoints == 0) {
                     if(var29.field1196 < 0 || WorldMapType1.method268(var29.field1196, var29.field1190)) {
                        class29.method240(var29.level, var29.type, var29.x, var29.y, var29.field1196, var29.field1189, var29.field1190);
                        var29.unlink();
                     }
                  } else {
                     if(var29.delay > 0) {
                        --var29.delay;
                     }

                     if(var29.delay == 0 && var29.x >= 1 && var29.y >= 1 && var29.x <= 102 && var29.y <= 102 && (var29.id < 0 || WorldMapType1.method268(var29.id, var29.field1188))) {
                        class29.method240(var29.level, var29.type, var29.x, var29.y, var29.id, var29.orientation, var29.field1188);
                        var29.delay = -1;
                        if(var29.field1196 == var29.id && var29.field1196 == -1) {
                           var29.unlink();
                        } else if(var29.field1196 == var29.id && var29.field1189 == var29.orientation && var29.field1190 == var29.field1188) {
                           var29.unlink();
                        }
                     }
                  }
               }

               XClanMember.method1094();
               ++field962;
               if(field962 > 750) {
                  if(field967 > 0) {
                     class48.method674();
                  } else {
                     class152.setGameState(40);
                     class56.field680 = class13.rssocket;
                     class13.rssocket = null;
                  }

               } else {
                  var1 = class96.field1469;
                  int[] var20 = class96.field1470;

                  for(var3 = 0; var3 < var1; ++var3) {
                     Player var21 = cachedPlayers[var20[var3]];
                     if(var21 != null) {
                        class82.method1554(var21, 1);
                     }
                  }

                  class54.method752();
                  class96.method1732();
                  ++field1066;
                  if(cursorState != 0) {
                     field1013 += 20;
                     if(field1013 >= 400) {
                        cursorState = 0;
                     }
                  }

                  if(class12.field262 != null) {
                     ++field1075;
                     if(field1075 >= 15) {
                        class21.method156(class12.field262);
                        class12.field262 = null;
                     }
                  }

                  Widget var30 = class3.field14;
                  Widget var31 = class48.field616;
                  class3.field14 = null;
                  class48.field616 = null;
                  field923 = null;
                  field1085 = false;
                  field1082 = false;
                  field1125 = 0;

                  while(class36.method486() && field1125 < 128) {
                     if(rights >= 2 && KeyFocusListener.field636[82] && class219.field2771 == 66) {
                        String var22 = CacheFile.method2283();
                        CombatInfoListHolder.clientInstance.method810(var22);
                     } else {
                        field1120[field1125] = class219.field2771;
                        field1126[field1125] = class227.field3118;
                        ++field1125;
                     }
                  }

                  if(widgetRoot != -1) {
                     class29.method241(widgetRoot, 0, 0, class45.canvasWidth, class10.canvasHeight, 0, 0);
                  }

                  ++cycleCntr;

                  while(true) {
                     Widget var23;
                     Widget var32;
                     ScriptEvent var33;
                     do {
                        var33 = (ScriptEvent)field1104.popFront();
                        if(var33 == null) {
                           while(true) {
                              do {
                                 var33 = (ScriptEvent)field1105.popFront();
                                 if(var33 == null) {
                                    while(true) {
                                       do {
                                          var33 = (ScriptEvent)field1103.popFront();
                                          if(var33 == null) {
                                             this.method1111();
                                             if(renderOverview != null) {
                                                renderOverview.method5240(class10.plane, (class226.localPlayer.x >> 7) + class21.baseX, (class226.localPlayer.y >> 7) + class164.baseY, false);
                                                renderOverview.method5136();
                                             }

                                             if(field1077 != null) {
                                                this.method1116();
                                             }

                                             if(class14.field281 != null) {
                                                class21.method156(class14.field281);
                                                ++field1022;
                                                if(MouseInput.field733 == 0) {
                                                   if(field1101) {
                                                      if(class14.field281 == class175.field2370 && field988 != field1020) {
                                                         Widget var34 = class14.field281;
                                                         byte var28 = 0;
                                                         if(field1067 == 1 && var34.contentType == 206) {
                                                            var28 = 1;
                                                         }

                                                         if(var34.itemIds[field1020] <= 0) {
                                                            var28 = 0;
                                                         }

                                                         if(XGrandExchangeOffer.method99(class60.getWidgetConfig(var34))) {
                                                            var5 = field988;
                                                            var6 = field1020;
                                                            var34.itemIds[var6] = var34.itemIds[var5];
                                                            var34.itemQuantities[var6] = var34.itemQuantities[var5];
                                                            var34.itemIds[var5] = -1;
                                                            var34.itemQuantities[var5] = 0;
                                                         } else if(var28 == 1) {
                                                            var5 = field988;
                                                            var6 = field1020;

                                                            while(var6 != var5) {
                                                               if(var5 > var6) {
                                                                  var34.method3915(var5 - 1, var5);
                                                                  --var5;
                                                               } else if(var5 < var6) {
                                                                  var34.method3915(var5 + 1, var5);
                                                                  ++var5;
                                                               }
                                                            }
                                                         } else {
                                                            var34.method3915(field1020, field988);
                                                         }

                                                         secretPacketBuffer1.putOpcode(52);
                                                         secretPacketBuffer1.putLEShortA(class14.field281.id);
                                                         secretPacketBuffer1.putShortLE(var28);
                                                         secretPacketBuffer1.putShortOb2(field1020);
                                                         secretPacketBuffer1.method3129(field988);
                                                      }
                                                   } else if(this.method1372()) {
                                                      this.method1113(field1143, field1019);
                                                   } else if(menuOptionCount > 0) {
                                                      class44.method595(field1143, field1019);
                                                   }

                                                   field1075 = 10;
                                                   MouseInput.field729 = 0;
                                                   class14.field281 = null;
                                                } else if(field1022 >= 5 && (MouseInput.field730 > field1143 + 5 || MouseInput.field730 < field1143 - 5 || MouseInput.field731 > field1019 + 5 || MouseInput.field731 < field1019 - 5)) {
                                                   field1101 = true;
                                                }
                                             }

                                             if(Region.method2656()) {
                                                var3 = Region.selectedRegionTileX;
                                                var4 = Region.selectedRegionTileY;
                                                secretPacketBuffer1.putOpcode(54);
                                                secretPacketBuffer1.putByte(5);
                                                secretPacketBuffer1.putShort(var3 + class21.baseX);
                                                secretPacketBuffer1.putLEInt(var4 + class164.baseY);
                                                secretPacketBuffer1.method3217(KeyFocusListener.field636[82]?(KeyFocusListener.field636[81]?2:1):0);
                                                Region.method2717();
                                                field1011 = MouseInput.field737;
                                                field1012 = MouseInput.field723;
                                                cursorState = 1;
                                                field1013 = 0;
                                                destinationX = var3;
                                                destinationY = var4;
                                             }

                                             if(var30 != class3.field14) {
                                                if(var30 != null) {
                                                   class21.method156(var30);
                                                }

                                                if(class3.field14 != null) {
                                                   class21.method156(class3.field14);
                                                }
                                             }

                                             if(var31 != class48.field616 && field917 == field1121) {
                                                if(var31 != null) {
                                                   class21.method156(var31);
                                                }

                                                if(class48.field616 != null) {
                                                   class21.method156(class48.field616);
                                                }
                                             }

                                             if(class48.field616 != null) {
                                                if(field917 < field1121) {
                                                   ++field917;
                                                   if(field1121 == field917) {
                                                      class21.method156(class48.field616);
                                                   }
                                                }
                                             } else if(field917 > 0) {
                                                --field917;
                                             }

                                             var3 = class226.localPlayer.x;
                                             var4 = class226.localPlayer.y;
                                             if(class232.field3168 - var3 < -500 || class232.field3168 - var3 > 500 || class155.field2213 - var4 < -500 || class155.field2213 - var4 > 500) {
                                                class232.field3168 = var3;
                                                class155.field2213 = var4;
                                             }

                                             if(var3 != class232.field3168) {
                                                class232.field3168 += (var3 - class232.field3168) / 16;
                                             }

                                             if(var4 != class155.field2213) {
                                                class155.field2213 += (var4 - class155.field2213) / 16;
                                             }

                                             if(MouseInput.field733 == 4 && GameEngine.field699) {
                                                var5 = MouseInput.field731 - field1078;
                                                field1015 = var5 * 2;
                                                field1078 = var5 != -1 && var5 != 1?(field1078 + MouseInput.field731) / 2:MouseInput.field731;
                                                var6 = field991 - MouseInput.field730;
                                                field989 = var6 * 2;
                                                field991 = var6 != -1 && var6 != 1?(MouseInput.field730 + field991) / 2:MouseInput.field730;
                                             } else {
                                                if(KeyFocusListener.field636[96]) {
                                                   field989 += (-24 - field989) / 2;
                                                } else if(KeyFocusListener.field636[97]) {
                                                   field989 += (24 - field989) / 2;
                                                } else {
                                                   field989 /= 2;
                                                }

                                                if(KeyFocusListener.field636[98]) {
                                                   field1015 += (12 - field1015) / 2;
                                                } else if(KeyFocusListener.field636[99]) {
                                                   field1015 += (-12 - field1015) / 2;
                                                } else {
                                                   field1015 /= 2;
                                                }

                                                field1078 = MouseInput.field731;
                                                field991 = MouseInput.field730;
                                             }

                                             mapAngle = field989 / 2 + mapAngle & 2047;
                                             field987 += field1015 / 2;
                                             if(field987 < 128) {
                                                field987 = 128;
                                             }

                                             if(field987 > 383) {
                                                field987 = 383;
                                             }

                                             var5 = class232.field3168 >> 7;
                                             var6 = class155.field2213 >> 7;
                                             var7 = class23.getTileHeight(class232.field3168, class155.field2213, class10.plane);
                                             var8 = 0;
                                             if(var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
                                                for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                   for(int var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                                                      int var11 = class10.plane;
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

                                             if(var9 > field996) {
                                                field996 += (var9 - field996) / 24;
                                             } else if(var9 < field996) {
                                                field996 += (var9 - field996) / 80;
                                             }

                                             if(field1008) {
                                                class18.method138();
                                             }

                                             for(var3 = 0; var3 < 5; ++var3) {
                                                ++field1155[var3];
                                             }

                                             Varcs.chatMessages.process();
                                             var3 = ++MouseInput.mouseIdleTicks - 1;
                                             var5 = DynamicObject.method1791();
                                             if(var3 > 15000 && var5 > 15000) {
                                                field967 = 250;
                                                class82.method1564(14500);
                                                secretPacketBuffer1.putOpcode(157);
                                             }

                                             for(class67 var24 = (class67)field1172.method3576(); var24 != null; var24 = (class67)field1172.method3577()) {
                                                if((long)var24.field819 < class157.currentTimeMs() / 1000L - 5L) {
                                                   if(var24.field815 > 0) {
                                                      Item.sendGameMessage(5, "", var24.field813 + " has logged in.");
                                                   }

                                                   if(var24.field815 == 0) {
                                                      Item.sendGameMessage(5, "", var24.field813 + " has logged out.");
                                                   }

                                                   var24.method3588();
                                                }
                                             }

                                             ++audioEffectCount;
                                             if(audioEffectCount > 50) {
                                                secretPacketBuffer1.putOpcode(251);
                                             }

                                             try {
                                                if(class13.rssocket != null && secretPacketBuffer1.offset > 0) {
                                                   class13.rssocket.queueForWrite(secretPacketBuffer1.payload, 0, secretPacketBuffer1.offset);
                                                   secretPacketBuffer1.offset = 0;
                                                   audioEffectCount = 0;
                                                }
                                             } catch (IOException var26) {
                                                if(field967 > 0) {
                                                   class48.method674();
                                                } else {
                                                   class152.setGameState(40);
                                                   class56.field680 = class13.rssocket;
                                                   class13.rssocket = null;
                                                }
                                             }

                                             return;
                                          }

                                          var32 = var33.widget;
                                          if(var32.index < 0) {
                                             break;
                                          }

                                          var23 = class239.method4167(var32.parentId);
                                       } while(var23 == null || var23.children == null || var32.index >= var23.children.length || var32 != var23.children[var32.index]);

                                       Ignore.method1054(var33);
                                    }
                                 }

                                 var32 = var33.widget;
                                 if(var32.index < 0) {
                                    break;
                                 }

                                 var23 = class239.method4167(var32.parentId);
                              } while(var23 == null || var23.children == null || var32.index >= var23.children.length || var32 != var23.children[var32.index]);

                              Ignore.method1054(var33);
                           }
                        }

                        var32 = var33.widget;
                        if(var32.index < 0) {
                           break;
                        }

                        var23 = class239.method4167(var32.parentId);
                     } while(var23 == null || var23.children == null || var32.index >= var23.children.length || var32 != var23.children[var32.index]);

                     Ignore.method1054(var33);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(Lho;S)V",
      garbageValue = "-22206"
   )
   void method1252(Widget var1) {
      Widget var2 = var1.parentId == -1?null:class239.method4167(var1.parentId);
      int var3;
      int var4;
      if(var2 == null) {
         var3 = class45.canvasWidth;
         var4 = class10.canvasHeight;
      } else {
         var3 = var2.width;
         var4 = var2.height;
      }

      class134.method2520(var1, var3, var4, false);
      class134.method2521(var1, var3, var4);
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1514437515"
   )
   final void method1111() {
      class91.method1663();
      if(class14.field281 == null) {
         if(field1077 == null) {
            int var1 = MouseInput.field729;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            if(isMenuOpen) {
               if(var1 != 1 && (GameEngine.field699 || var1 != 4)) {
                  var2 = MouseInput.field730;
                  var3 = MouseInput.field731;
                  if(var2 < class37.menuX - 10 || var2 > class37.menuX + WorldMapData.menuWidth + 10 || var3 < IndexDataBase.menuY - 10 || var3 > MilliTimer.menuHeight + IndexDataBase.menuY + 10) {
                     isMenuOpen = false;
                     class140.method2793(class37.menuX, IndexDataBase.menuY, WorldMapData.menuWidth, MilliTimer.menuHeight);
                  }
               }

               if(var1 == 1 || !GameEngine.field699 && var1 == 4) {
                  var2 = class37.menuX;
                  var3 = IndexDataBase.menuY;
                  var4 = WorldMapData.menuWidth;
                  var5 = MouseInput.field737;
                  var6 = MouseInput.field723;
                  var7 = -1;

                  int var9;
                  for(var8 = 0; var8 < menuOptionCount; ++var8) {
                     var9 = var3 + 31 + (menuOptionCount - 1 - var8) * 15;
                     if(var5 > var2 && var5 < var4 + var2 && var6 > var9 - 13 && var6 < var9 + 3) {
                        var7 = var8;
                     }
                  }

                  if(var7 != -1 && var7 >= 0) {
                     var8 = menuActionParams0[var7];
                     var9 = menuActionParams1[var7];
                     int var10 = menuTypes[var7];
                     int var11 = menuIdentifiers[var7];
                     String var12 = menuOptions[var7];
                     String var13 = menuTargets[var7];
                     class162.menuAction(var8, var9, var10, var11, var12, var13, MouseInput.field737, MouseInput.field723);
                  }

                  isMenuOpen = false;
                  class140.method2793(class37.menuX, IndexDataBase.menuY, WorldMapData.menuWidth, MilliTimer.menuHeight);
               }
            } else {
               var2 = class37.method492();
               if((var1 == 1 || !GameEngine.field699 && var1 == 4) && var2 >= 0) {
                  var3 = menuTypes[var2];
                  if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                     var4 = menuActionParams0[var2];
                     var5 = menuActionParams1[var2];
                     Widget var14 = class239.method4167(var5);
                     if(class9.method46(class60.getWidgetConfig(var14)) || XGrandExchangeOffer.method99(class60.getWidgetConfig(var14))) {
                        if(class14.field281 != null && !field1101 && menuOptionCount > 0 && !this.method1372()) {
                           var7 = field1143;
                           var8 = field1019;
                           class89 var15 = class54.field669;
                           class162.menuAction(var15.field1379, var15.field1377, var15.field1378, var15.field1380, var15.field1381, var15.field1381, var7, var8);
                           class54.field669 = null;
                        }

                        field1101 = false;
                        field1022 = 0;
                        if(class14.field281 != null) {
                           class21.method156(class14.field281);
                        }

                        class14.field281 = class239.method4167(var5);
                        field988 = var4;
                        field1143 = MouseInput.field737;
                        field1019 = MouseInput.field723;
                        if(var2 >= 0) {
                           class54.field669 = new class89();
                           class54.field669.field1379 = menuActionParams0[var2];
                           class54.field669.field1377 = menuActionParams1[var2];
                           class54.field669.field1378 = menuTypes[var2];
                           class54.field669.field1380 = menuIdentifiers[var2];
                           class54.field669.field1381 = menuOptions[var2];
                        }

                        class21.method156(class14.field281);
                        return;
                     }
                  }
               }

               if((var1 == 1 || !GameEngine.field699 && var1 == 4) && this.method1372()) {
                  var1 = 2;
               }

               if((var1 == 1 || !GameEngine.field699 && var1 == 4) && menuOptionCount > 0 && var2 >= 0) {
                  var3 = menuActionParams0[var2];
                  var4 = menuActionParams1[var2];
                  var5 = menuTypes[var2];
                  var6 = menuIdentifiers[var2];
                  String var16 = menuOptions[var2];
                  String var17 = menuTargets[var2];
                  class162.menuAction(var3, var4, var5, var6, var16, var17, MouseInput.field737, MouseInput.field723);
               }

               if(var1 == 2 && menuOptionCount > 0) {
                  this.method1113(MouseInput.field737, MouseInput.field723);
               }
            }

         }
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1956912918"
   )
   final void method1116() {
      class21.method156(field1077);
      ++class261.field3610;
      if(field1085 && field1082) {
         int var1 = MouseInput.field730;
         int var2 = MouseInput.field731;
         var1 -= field1079;
         var2 -= field1160;
         if(var1 < field1083) {
            var1 = field1083;
         }

         if(var1 + field1077.width > field1083 + field1147.width) {
            var1 = field1083 + field1147.width - field1077.width;
         }

         if(var2 < field1084) {
            var2 = field1084;
         }

         if(var2 + field1077.height > field1084 + field1147.height) {
            var2 = field1084 + field1147.height - field1077.height;
         }

         int var3 = var1 - field1086;
         int var4 = var2 - field931;
         int var5 = field1077.field2693;
         if(class261.field3610 > field1077.field2701 && (var3 > var5 || var3 < -var5 || var4 > var5 || var4 < -var5)) {
            field1088 = true;
         }

         int var6 = var1 - field1083 + field1147.scrollX;
         int var7 = var2 - field1084 + field1147.scrollY;
         ScriptEvent var8;
         if(field1077.field2706 != null && field1088) {
            var8 = new ScriptEvent();
            var8.widget = field1077;
            var8.field832 = var6;
            var8.field833 = var7;
            var8.field831 = field1077.field2706;
            Ignore.method1054(var8);
         }

         if(MouseInput.field733 == 0) {
            if(field1088) {
               if(field1077.field2651 != null) {
                  var8 = new ScriptEvent();
                  var8.widget = field1077;
                  var8.field832 = var6;
                  var8.field833 = var7;
                  var8.field835 = field923;
                  var8.field831 = field1077.field2651;
                  Ignore.method1054(var8);
               }

               if(field923 != null && class14.method83(field1077) != null) {
                  secretPacketBuffer1.putOpcode(62);
                  secretPacketBuffer1.putInt(field1077.id);
                  secretPacketBuffer1.putLEInt(field1077.itemId);
                  secretPacketBuffer1.method3129(field923.index);
                  secretPacketBuffer1.putShort(field1077.index);
                  secretPacketBuffer1.method3129(field923.itemId);
                  secretPacketBuffer1.method3139(field923.id);
               }
            } else if(this.method1372()) {
               this.method1113(field1079 + field1086, field1160 + field931);
            } else if(menuOptionCount > 0) {
               int var11 = field1086 + field1079;
               int var9 = field1160 + field931;
               class89 var10 = class54.field669;
               class162.menuAction(var10.field1379, var10.field1377, var10.field1378, var10.field1380, var10.field1381, var10.field1381, var11, var9);
               class54.field669 = null;
            }

            field1077 = null;
         }

      } else {
         if(class261.field3610 > 1) {
            field1077 = null;
         }

      }
   }

   public final void init() {
      if(this.isValidHost()) {
         Parameters[] var1 = new Parameters[]{Parameters.field3702, Parameters.field3698, Parameters.field3703, Parameters.field3705, Parameters.field3700, Parameters.field3701, Parameters.field3704, Parameters.field3711, Parameters.field3707, Parameters.field3710, Parameters.field3706, Parameters.field3697, Parameters.field3709, Parameters.field3699, Parameters.field3708};
         Parameters[] var2 = var1;

         for(int var3 = 0; var3 < var2.length; ++var3) {
            Parameters var4 = var2[var3];
            String var5 = this.getParameter(var4.key);
            if(var5 != null) {
               switch(Integer.parseInt(var4.key)) {
               case 1:
                  int var7 = Integer.parseInt(var5);
                  BuildType[] var8 = new BuildType[]{BuildType.BUILD_LIVE, BuildType.RC, BuildType.LIVE, BuildType.WIP};
                  BuildType[] var9 = var8;
                  int var10 = 0;

                  BuildType var16;
                  while(true) {
                     if(var10 >= var9.length) {
                        var16 = null;
                        break;
                     }

                     BuildType var11 = var9[var10];
                     if(var7 == var11.ordinal) {
                        var16 = var11;
                        break;
                     }

                     ++var10;
                  }

                  AbstractByteBuffer.field2373 = var16;
               case 2:
               case 5:
               case 12:
               default:
                  break;
               case 3:
                  socketType = Integer.parseInt(var5);
                  break;
               case 4:
                  languageId = Integer.parseInt(var5);
                  break;
               case 6:
                  world = Integer.parseInt(var5);
                  break;
               case 7:
                  field941 = Integer.parseInt(var5);
                  break;
               case 8:
                  class220.field2783 = var5;
                  break;
               case 9:
                  if(var5.equalsIgnoreCase("true")) {
                     isMembers = true;
                  } else {
                     isMembers = false;
                  }
                  break;
               case 10:
                  class31.sessionToken = var5;
                  break;
               case 11:
                  flags = Integer.parseInt(var5);
                  break;
               case 13:
                  if(var5.equalsIgnoreCase("true")) {
                     ;
                  }
                  break;
               case 14:
                  class20.field323 = Integer.parseInt(var5);
                  break;
               case 15:
                  class232[] var6 = new class232[]{class232.field3160, class232.field3164, class232.field3162, class232.field3161, class232.field3166, class232.field3163};
                  class98.field1497 = (class232)class36.forOrdinal(var6, Integer.parseInt(var5));
                  if(class98.field1497 == class232.field3164) {
                     class22.field331 = class289.field3845;
                  } else {
                     class22.field331 = class289.field3844;
                  }
               }
            }
         }

         class92.method1694();
         DynamicObject.host = this.getCodeBase().getHost();
         String var15 = AbstractByteBuffer.field2373.identifier;
         byte var12 = 0;

         try {
            Actor.method1497("oldschool", var15, var12, 17);
         } catch (Exception var14) {
            WorldMapType2.method495((String)null, var14);
         }

         CombatInfoListHolder.clientInstance = this;
         this.initialize(765, 503, 150);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method1459() {
      class203.field2470.method3648();
      class203.field2471 = 1;
      class222.field2815 = null;
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1755924551"
   )
   static final void method1268(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class3.method8(var9);
         pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1188 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-2133243420"
   )
   public static String method1460(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = FaceNormal.method2807(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}
